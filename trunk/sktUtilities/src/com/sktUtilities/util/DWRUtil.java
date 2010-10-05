package com.sktUtilities.util;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.dictionary.service.DictionaryService;
import com.dictionary.util.SpringUtil;
import com.sktUtilities.action.TransliteratorAction;
import com.sktutilities.util.EncodingUtil;
import com.sktutilities.util.Log;

public class DWRUtil
{
    public String convertSimple(String userInput, String encoding)
    {
        return EncodingUtil.convertToDVN(userInput, encoding);
    }

    public String convertComplicated(String userInput, String encoding, String iastRequired)
    {
        // Character Count
        int characterCount = userInput.length();
        if(characterCount > 50000)
        {
            userInput = userInput.substring(0, 50000);
        }
        // Convert String
        String dvnString = "";
        String iastString = "";

        dvnString = EncodingUtil.convertToDVN(userInput, encoding) ;
        if (!StringUtils.equalsIgnoreCase("FALSE", iastRequired))
        {
            Log.logInfo("Encoding: " + encoding);
            Log.logInfo("User Input" + userInput);
            iastString = EncodingUtil.convertToIAST(userInput, encoding);
            Log.logInfo("iastString" + iastString);
        }

        String compactString = dvnString + TransliteratorAction.SEPARATOR + characterCount + TransliteratorAction.SEPARATOR + iastString;
        return compactString;
    }
    
    public String getSuggestions(String userInput, String encoding)
    {
        DictionaryService svc = (DictionaryService) SpringUtil.getBean("DictionaryService");
        ArrayList<String> suggList = svc.getDictionaryDAO().findSuggestions(userInput, encoding);
        StringBuffer suggestions = new StringBuffer();
        for(String st : suggList)
        {
            suggestions.append(st + ", ");
        }
        return suggestions.toString();
    }
}
