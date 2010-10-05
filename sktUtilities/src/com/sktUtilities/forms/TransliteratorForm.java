package com.sktUtilities.forms;

import org.apache.struts.validator.ValidatorForm;

public class TransliteratorForm extends ValidatorForm
{
 /**
     * 
     */
    private static final long serialVersionUID = 1L;

private String textInRoman;

 private String textInDVN;
 
 private String textIneLatin;
 
 private String encoding = "ITRANS";
 
 private int characterCounter;

public String getEncoding()
{
    return encoding;
}

public void setEncoding(String encoding)
{
    this.encoding = encoding;
}

public String getTextInDVN()
{
    return textInDVN;
}

public void setTextInDVN(String textInDVN)
{
    this.textInDVN = textInDVN;
}

public String getTextIneLatin()
{
    return textIneLatin;
}

public void setTextIneLatin(String textIneLatin)
{
    this.textIneLatin = textIneLatin;
}

public String getTextInRoman()
{
    return textInRoman;
}

public void setTextInRoman(String textInRoman)
{
    this.textInRoman = textInRoman;
}

public int getCharacterCounter()
{
    return characterCounter;
}

public void setCharacterCounter(int characterCounter)
{
    this.characterCounter = characterCounter;
}
 
}
