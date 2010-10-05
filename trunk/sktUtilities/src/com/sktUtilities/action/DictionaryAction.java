package com.sktUtilities.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.dictionary.service.DictionaryService;
import com.dictionary.main.MainClass;
import com.dictionary.util.SpringUtil;
import com.dictionary.vo.WordMaster;
import com.sktUtilities.forms.DictionaryForm;
import com.sktutilities.util.EncodingUtil;
import com.sktutilities.util.Log;

public class DictionaryAction extends DispatchAction
{
    public ActionForward findMeaning(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

        // Retrieve the Form
        DictionaryForm dForm = (DictionaryForm) form;
        String entry = dForm.getEntry().trim();

        // Get the Encoding
        String encoding = dForm.getEncoding();

        // Get the Search Type
        String searchType = dForm.getSearchType();

        String wordForSearch = EncodingUtil.convertToSLP(entry, encoding);
        DictionaryService svc = (DictionaryService) SpringUtil.getBean("DictionaryService");

        ArrayList<WordMaster> wordList = svc.findWord(wordForSearch, searchType);

        dForm.setNotes(svc.decorateResult(wordList, entry, EncodingUtil.convertToDVN(entry, encoding)));
        Log.logInfo("Notes: " + dForm.getNotes());
        // svc.getDictionaryDAO().logUserActivityToDB("Dictionary",
        // request.getRemoteAddr(), entry + ", " + searchType + ", " +
        // encoding);

        return mapping.findForward("result");
    }

}
