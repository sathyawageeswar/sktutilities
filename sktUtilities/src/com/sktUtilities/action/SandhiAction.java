package com.sktUtilities.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.dictionary.service.DictionaryService;
import com.dictionary.util.SpringUtil;
import com.sktutilities.util.Log;
import com.sktUtilities.forms.PratyaharaForm;
import com.sktUtilities.forms.SandhiForm;
import com.sktUtilities.util.Util;
import com.sktutilities.sandhi.SandhiBean;

public class SandhiAction extends DispatchAction
{

    public ActionForward performSandhi(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

        // Retrieve the Form
        SandhiForm sandhiForm = (SandhiForm) form;

        String purvaPada = sandhiForm.getPurvaPada().trim();
        String uttaraPada = sandhiForm.getUttaraPada().trim();
        
        // Print to console User Inputs
        Log.logInfo("sandhiForm.purvapada = " + purvaPada);
        Log.logInfo("sandhiForm.uttarapada = " + uttaraPada);

        // Strings that represent the SLP view of Input, irrespective of the
        // Encoding chosen by the User
        //String purvapadaInSLP = sandhiForm.getPurvaPada().trim();
        //String uttarapadaInSLP = sandhiForm.getUttaraPada().trim();

        // Get the Encoding
        String encoding = sandhiForm.getEncoding();
        Log.logInfo("Encoding: " + encoding);

        // Print pragrhya and padanta checkboxes
        Log.logInfo("padanta : " + sandhiForm.isPadanta());
        Log.logInfo("pragrhya : " + sandhiForm.isPragrhya());
        
        // Do Sandhi
        // sandhi_maker sm = new sandhi_maker(purvapadaInSLP, uttarapadaInSLP);
        SandhiBean sb = new SandhiBean(purvaPada, uttaraPada, sandhiForm.isPadanta(), sandhiForm.isPragrhya(), encoding);
        String samhitaPada = sb.getRomanInput3(); // Merge the Two Words
        sandhiForm.setSamhitaPada(samhitaPada);
        Log.logInfo("Sandhi Pada in SLP is " + samhitaPada);

        // Get the DVN Strings into DVN as well
        sandhiForm.setTransformedPurvaPada(sb.getDvnInput1());
        sandhiForm.setTransformedUttaraPada(sb.getDvnInput2());
        sandhiForm.setTransformedSamhitaPada(sb.getDvnInput3());
        // sandhiForm.setTransformedSamhitaPada(Util.convertToDVN(samhitaPada,
        // encoding));

        // Set Notes
        String notes = sb.getNotes();
        sandhiForm.setNotes(Util.convertJavaNewLinesToHTMLBreaks(notes));
        
        DictionaryService service = (DictionaryService) SpringUtil.getBean("DictionaryService");
        //service.getDictionaryDAO().logUserActivityToDB("Sandhi", request.getRemoteAddr(), purvaPada + ", " + uttaraPada + ", " + samhitaPada + ", " + encoding);
        // Forward to View
        return mapping.findForward("result");
    }


    public ActionForward reset(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        @SuppressWarnings("unused")
        SandhiForm sform = (SandhiForm) form;
        return mapping.findForward("result");
    }
    public ActionForward transform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // Get Request Parameter "param1" and param2
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");

        // Print to Console
        Log.logInfo("param1 = " + param1);
        Log.logInfo("param2 = " + param2);

        // Convert String
        String convertedString = "";
        if (param2.equalsIgnoreCase("SLP"))
        {
            convertedString = Util.convertSLPToDVN(param1);
        }

        else
        {
            convertedString = Util.convertITRANSToDVN(param1);
        }
        Log.logInfo("convertedString: " + convertedString);

        // Send Converted String back to JSP
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(convertedString);

        return null;
    }

    public ActionForward setChkBox(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // Get Request Parameter "param1" and param2
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");

        // Print to Console
        Log.logInfo("param1 = " + param1);
        Log.logInfo("param2 = " + param2);
        
        SandhiForm sf = (SandhiForm) request.getSession().getAttribute("sandhiForm");
        if("padanta".equalsIgnoreCase(param1))
        {
            sf.setPadanta(Boolean.parseBoolean(param2));
        }
        
        else if("pragrhya".equalsIgnoreCase(param1))
        {
            sf.setPragrhya(Boolean.parseBoolean(param2));
        }
        
        else if("marker".equalsIgnoreCase(param1))
        {
            PratyaharaForm pf = (PratyaharaForm) request.getSession().getAttribute("pratyaharaForm");
            pf.setHideMarkers(Boolean.parseBoolean(param2));
        }
        return null;
    }

}
