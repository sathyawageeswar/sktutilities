package com.sktUtilities.forms;

import org.apache.struts.validator.ValidatorForm;

import com.sktutilities.util.*;

public class PratyaharaForm extends ValidatorForm {
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String pratyahara = "al";

	private String transformedPratyahara = EncodingUtil.convertRawItransToDevanagari(pratyahara);

	private boolean hideMarkers;

	private String encoding = "ITRANS";

	private String notes;

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPratyahara() {
		return pratyahara;
	}

	public void setPratyahara(String pratyahara) {
		this.pratyahara = pratyahara;
	}

	public String getTransformedPratyahara() {
		return transformedPratyahara;
	}

	public void setTransformedPratyahara(String transformedPratyahara) {
		this.transformedPratyahara = transformedPratyahara;
	}

    public boolean isHideMarkers()
    {
        return hideMarkers;
    }

    public void setHideMarkers(boolean hideMarkers)
    {
        this.hideMarkers = hideMarkers;
    }

}
