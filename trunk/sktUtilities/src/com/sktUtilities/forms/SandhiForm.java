package com.sktUtilities.forms;

import org.apache.struts.validator.ValidatorForm;

public class SandhiForm extends ValidatorForm {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String purvaPada;

	private String uttaraPada;

	private String samhitaPada;

	private String transformedPurvaPada;

	private String transformedUttaraPada;
	
	private String transformedSamhitaPada;

	private String notes;

	private String encoding = "ITRANS";
	
	private boolean padanta;
	
	private boolean pragrhya;
	
	public String getPurvaPada() {
		return purvaPada;
	}

	public void setPurvaPada(String purvaPada) {
		this.purvaPada = purvaPada;
	}

	public String getUttaraPada() {
		return uttaraPada;
	}

	public void setUttaraPada(String uttaraPada) {
		this.uttaraPada = uttaraPada;
	}

	public String getTransformedPurvaPada() {
		return transformedPurvaPada;
	}

	public void setTransformedPurvaPada(String transformedPurvaPada) {
		this.transformedPurvaPada = transformedPurvaPada;
	}

	public String getTransformedUttaraPada() {
		return transformedUttaraPada;
	}

	public void setTransformedUttaraPada(String transformedUttaraPada) {
		this.transformedUttaraPada = transformedUttaraPada;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getSamhitaPada() {
		return samhitaPada;
	}

	public void setSamhitaPada(String samhitaPada) {
		this.samhitaPada = samhitaPada;
	}

	public String getTransformedSamhitaPada() {
		return transformedSamhitaPada;
	}

	public void setTransformedSamhitaPada(String transformedSamhitaPada) {
		this.transformedSamhitaPada = transformedSamhitaPada;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public boolean isPadanta() {
		return padanta;
	}

	public void setPadanta(boolean padanta) {
		this.padanta = padanta;
	}

	public boolean isPragrhya() {
		return pragrhya;
	}

	public void setPragrhya(boolean pragrhya) {
		this.pragrhya = pragrhya;
	}



}
