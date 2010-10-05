package com.sktUtilities.forms;

import org.apache.struts.validator.ValidatorForm;

import com.dictionary.main.MainClass;
import com.sktutilities.util.EncodingUtil;

public class DictionaryForm extends ValidatorForm
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String entry;

    private String transformedEntry;

    private String notes;

    private String encoding = EncodingUtil.ITRANS;
    
    private String searchType = MainClass.EXACT;

    public String getEncoding()
    {
        return encoding;
    }

    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }

    public String getEntry()
    {
        return entry;
    }

    public void setEntry(String entry)
    {
        this.entry = entry;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getTransformedEntry()
    {
        return transformedEntry;
    }

    public void setTransformedEntry(String transformedEntry)
    {
        this.transformedEntry = transformedEntry;
    }

    public String getSearchType()
    {
        return searchType;
    }

    public void setSearchType(String searchType)
    {
        this.searchType = searchType;
    }
}
