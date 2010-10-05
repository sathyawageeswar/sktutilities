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
import com.sktUtilities.forms.PratyaharaForm;
import com.sktUtilities.util.Util;
import com.sktutilities.pratyahara.PratyaharaDecoder;
import com.sktutilities.util.EncodingUtil;
import com.sktutilities.util.Log;

public class PratyaharaAction extends DispatchAction {
	public ActionForward displayPratyahara(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		// Retrieve the Form
		PratyaharaForm pratyaharaForm = (PratyaharaForm) form;

        // Get the Encoding
        String encoding = pratyaharaForm.getEncoding();
        Log.logInfo("Encoding: " + encoding);
        
		// Strings that represent the SLP view of Input, irrespective of the
		// Encoding chosen by the User
		String pratyaharaInSLP = EncodingUtil.convertToSLP(pratyaharaForm.getPratyahara().trim(), encoding);

		//Fetch Check Box value where markers-display is required
		boolean hideMarkers = pratyaharaForm.isHideMarkers();
		
		// Fetch Pratyaharas long Form
		PratyaharaDecoder pratyahara = new PratyaharaDecoder();
		
		String result = pratyahara.decodePratyahara(pratyaharaInSLP,hideMarkers);
		
		// Get the DVN Strings into DVN as well
		//pratyaharaForm.setTransformedPratyahara(EncodingUtil.convertToDVN(pratyaharaForm.getPratyahara(), encoding));

		// Set Notes
		pratyaharaForm.setNotes(Util.convertJavaNewLinesToHTMLBreaks(result));

		DictionaryService service = (DictionaryService) SpringUtil.getBean("DictionaryService");
		//service.getDictionaryDAO().logUserActivityToDB("Pratyahara", request.getRemoteAddr(), pratyaharaInSLP + ", " + encoding);

		// Forward to View
		return mapping.findForward("result");
	}

}