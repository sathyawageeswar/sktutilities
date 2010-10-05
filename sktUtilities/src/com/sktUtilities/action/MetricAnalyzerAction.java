/**
 * 
 */
package com.sktUtilities.action;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.dictionary.service.DictionaryService;
import com.dictionary.util.SpringUtil;
import com.sktUtilities.chandoviciti.MetricAnalysisBean;
import com.sktUtilities.chandoviciti.MetricAnalyzer;
import com.sktUtilities.forms.MetricAnalyzerForm;
import com.sktutilities.util.EncodingUtil;

/**
 * @author chetan
 * 
 */
public class MetricAnalyzerAction extends DispatchAction
{
    public ActionForward analyze(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

        // Retrieve the Form
        MetricAnalyzerForm metricForm = (MetricAnalyzerForm) form;
        // Get User Input
        String textInRoman = metricForm.getChanda().trim();

        // Get the Encoding
        String encoding = metricForm.getEncoding();

        // Perform conversions
        String textInDVN = EncodingUtil.convertToDVN(textInRoman, encoding);

        // converts ITRANS Encoding to SLP
        if (!"SLP".equalsIgnoreCase(encoding))
        {
            textInRoman = EncodingUtil.convertRawItransToSLP(textInRoman);
        }
       

        // Set Converted Values in form
        metricForm.setTransformedchanda(textInDVN);

        MetricAnalyzer analyzer = new MetricAnalyzer();
        LinkedList<MetricAnalysisBean>  varnaDistribution = analyzer.analyzeVarnaFrequency(textInRoman);

        request.setAttribute("varnaDistribution", varnaDistribution);
        DictionaryService service = (DictionaryService) SpringUtil.getBean("DictionaryService");
        //service.getDictionaryDAO().logUserActivityToDB("Metric Analyzer", request.getRemoteAddr(), ", " + encoding);
        // Forward to View
        return mapping.findForward("result");

    }
}
