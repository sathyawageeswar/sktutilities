package com.sktUtilities.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.MessageResources;

import com.dictionary.service.DictionaryService;
import com.dictionary.util.SpringUtil;
import com.sktUtilities.forms.TransliteratorForm;
import com.sktUtilities.forms.TransliteratorViaFileForm;
import com.sktUtilities.util.Util;
import com.sktutilities.util.EncodingUtil;
import com.sktutilities.util.Log;

public class TransliteratorAction extends DispatchAction
{
    public static final String VALIDATION_SUCCESS      = "1";

    public static final int    DEFAULT_LIMIT           = 100;

    public static final String SEPARATOR               = "#$%";

    public static final String NEWLINE_REPLACEMENT     = "####";

    public static final int    DEFAULT_CHARACTER_LIMIT = 5000;

    @Deprecated
    public ActionForward transliterate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Log.logInfo("in transliterate");
        // Fetch the form
        TransliteratorForm tForm = (TransliteratorForm) form;

        // Get User Input
        String textInRoman = tForm.getTextInRoman().trim();
        // Character Count
        int characterCount = tForm.getTextInRoman().replaceAll(NEWLINE_REPLACEMENT, "").length(); // WE
                                                                                                    // append
                                                                                                    // 4
                                                                                                    // Stars
                                                                                                    // wherever
                                                                                                    // '\n'
                                                                                                    // is
                                                                                                    // implied
                                                                                                    // as
                                                                                                    // the
                                                                                                    // latter
                                                                                                    // cannot
                                                                                                    // be
                                                                                                    // transmiited
                                                                                                    // as
                                                                                                    // is

        // Get the Limit of Characters
        MessageResources res = this.getResources(request);
        String charLimit = res.getMessage("transliterator.char.limit");

        if (charLimit == null) charLimit = String.valueOf(DEFAULT_CHARACTER_LIMIT);

        if (characterCount > Integer.valueOf(charLimit.trim()))
        {
            String errMsg = res.getMessage("error.transliterator.char.limit.exceeded", charLimit);
            request.setAttribute("valMsg", Util.decorateAsErrorMsg(errMsg));
        }
        else
        {
            // Get the Encoding
            String encoding = tForm.getEncoding();

            // Perform conversions
            String textInDVN = EncodingUtil.convertToDVN(textInRoman, encoding);
            String textIneLatin = EncodingUtil.convertToIAST(textInRoman, encoding);

            // Set Converted Values in form
            tForm.setTextInDVN(textInDVN);
            tForm.setTextIneLatin(textIneLatin);
        }
        
        tForm.setCharacterCounter(characterCount);
        return mapping.findForward("result");
    }
    @Deprecated
    public ActionForward transform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // Get Request Parameter "param1" and param2
        String userInput = request.getParameter("param1"); // Represents the
        // User Input
        String encoding = request.getParameter("param2"); // Represents the
        // Encoding Scheme

        // Character Count

        int characterCount = userInput.replaceAll(NEWLINE_REPLACEMENT, "").length(); // WE
                                                                                        // append
                                                                                        // 4
                                                                                        // Stars
                                                                                        // wherever
                                                                                        // '\n'
                                                                                        // is
                                                                                        // implied
                                                                                        // as
                                                                                        // the
                                                                                        // latter
                                                                                        // cannot
                                                                                        // be
                                                                                        // transmiited
                                                                                        // as
                                                                                        // is

        // Print to Console
        // Log.logInfo("param1 = " + userInput);
        // Log.logInfo("param2 = " + encoding);

        // Convert String
        String dvnString = "";
        String eLatinString = "";

        dvnString = EncodingUtil.convertToDVN(userInput, encoding);
        eLatinString = EncodingUtil.convertToIAST(userInput, encoding);

        // Log.logInfo("convertedString: " + dvnString);

        // Send Converted String back to JSP
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(dvnString + SEPARATOR + eLatinString + SEPARATOR + characterCount);

        return null;
    }

    public ActionForward transliterateFromFile(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        TransliteratorViaFileForm tForm = (TransliteratorViaFileForm) form;

        // Get the Form File
        FormFile file = tForm.getFile();
        // int fileSize = file.getFileSize();

        // Printing Some Values
        Log.logInfo("getRemoteAddr() : " + request.getRemoteAddr());
        Log.logInfo("getRemoteHost() : " + request.getRemoteHost());
        Log.logInfo("getRemotePort() : " + request.getRemotePort());
        Log.logInfo("getRemoteUser() : " + request.getRemoteUser());

        Log.logInfo("file == null ? " + file == null);
        String validation = doValidations(file, request);
        Log.logInfo("validation == " + validation);
        if (!VALIDATION_SUCCESS.equals(validation))
        {
            request.setAttribute("valMsg", Util.decorateAsErrorMsg(validation));
            Log.logInfo(" valMsg = " + request.getAttribute("valMsg"));

            // Clear all Fields
            tForm.setFile(null);
            tForm.setTextInDVN("");
            tForm.setTextIneLatin("");
            return mapping.findForward("result");
        }

        // Get User Input
        String textInRoman = convertFile(file);

        // Get the Encoding
        String encoding = tForm.getEncoding();

        // Perform conversions
        String textInDVN = EncodingUtil.convertToDVN(textInRoman, encoding);
        String textIneLatin = EncodingUtil.convertToIAST(textInRoman, encoding);

        // Set Converted Values in form
        tForm.setTextInDVN(textInDVN);
        tForm.setTextIneLatin(textIneLatin);
       // DictionaryService service = (DictionaryService) SpringUtil.getBean("DictionaryService");
       // service.getDictionaryDAO().logUserActivityToDB("Transliterate via File", request.getRemoteAddr(), file.getFileName() + ", Size: " + file.getFileSize() + " Bytes");

        return mapping.findForward("result");
    }

    public String convertFile(FormFile file)
    {
        String txt = "";
        // InputStream input = null;
        // PrintStream out = null;
        try
        {
            byte[] fileData = file.getFileData();
            // input = file.getInputStream();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < fileData.length; i++)
            {
                sb.append((char) fileData[i]);
            }

            txt = sb.toString();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                file.destroy();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return txt;
    }

    public String doValidations(FormFile file, HttpServletRequest request)
    {
        String result = null;
        try
        {
            MessageResources res = this.getResources(request);

            // Validate Form Size
            if (file == null || file.getFileSize() == 0)
            {
                result = res.getMessage("error.empty.file", file.getFileName());
            }

            else if (!file.getFileName().endsWith(".txt"))
            {
                result = res.getMessage("error.file.wrong.suffix", file.getFileName());
            }

            else
            {
                String fileSizeLimit = res.getMessage("transliterator.file.size.limit");
                int limit = DEFAULT_LIMIT;

                try
                {
                    limit = Integer.valueOf(fileSizeLimit);
                }
                catch (NumberFormatException e)
                {
                    limit = DEFAULT_LIMIT;
                }
                Log.logInfo("file.getFileSize()" + (file.getFileSize() / 1000) + "KB , LIMIT " + limit);

                if (file != null && file.getFileSize() / 1000 > limit)
                {
                    // file.getFileSize() is in Bytes. So we divide it by 1000
                    // to
                    // make it equal to KiloBytes
                    result = res.getMessage("error.file.size.limit", file.getFileName(), fileSizeLimit);
                }

            }

        }
        catch (Exception e)
        {
            Log.logInfo("Error in doValidations");
            e.printStackTrace();
        }
        return result == null ? VALIDATION_SUCCESS : result;
    }
}
