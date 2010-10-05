package com.sktUtilities.forms;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

public class TransliteratorViaFileForm extends ValidatorForm
{
 /**
     * 
     */
    private static final long serialVersionUID = 1L;

private String filename;

 private String textInDVN;
 
 private String textIneLatin;
 
 private String encoding = "ITRANS";

 private FormFile  file;
 
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

public String getFilename()
{
    return filename;
}

public void setFilename(String filename)
{
    this.filename = filename;
}

public FormFile getFile()
{
    return file;
}

public void setFile(FormFile file)
{
    this.file = file;
}
 
}
