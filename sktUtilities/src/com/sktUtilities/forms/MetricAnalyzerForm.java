package com.sktUtilities.forms;

import org.apache.struts.validator.ValidatorForm;

public class MetricAnalyzerForm extends ValidatorForm
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String chanda;

    private String transformedchanda;

    private String notes;

    private String encoding = "ITRANS";
    
    private int characterCounter;

    public String getChanda()
    {
        return chanda;
    }

    public void setChanda(String chanda)
    {
        this.chanda = chanda;
    }

    public String getEncoding()
    {
        return encoding;
    }

    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getTransformedchanda()
    {
        return transformedchanda;
    }

    public void setTransformedchanda(String transformedchanda)
    {
        this.transformedchanda = transformedchanda;
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
