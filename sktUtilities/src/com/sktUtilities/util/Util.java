package com.sktUtilities.util;
import com.sktutilities.util.EncodingUtil;

public class Util
{
    public static String convertSLPToDVN(String str)
    {
        return EncodingUtil.convertSLPToDevanagari(str);
    }

    public static String convertITRANSToDVN(String str)
    {
        return EncodingUtil.convertRawItransToDevanagari(str);
    }

    public static String convertToIAST(String str)
    {
        // It is assumed that if No Encoding is specified than we are talking
        // about ITRANS
        return EncodingUtil.convertRawItransToIAST(str);
    }

    public static String convertJavaNewLinesToHTMLBreaks(String convertibleStr)
    {
        StringBuilder cnvtedStr = new StringBuilder("");

        String[] arr = convertibleStr.split("\n");

        for (int i = 0; i < arr.length; i++)
        {
            cnvtedStr.append(arr[i] + "<br>");
        }
        return cnvtedStr.toString();
    }

    public static String decorateAsErrorMsg(String errorMsg)
    {
        return "<p style='color:red;font:bold'>" + errorMsg + "</p>";
    }
}
