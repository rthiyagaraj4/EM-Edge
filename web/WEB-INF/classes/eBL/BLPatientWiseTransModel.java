/*
 * @author Aravindh H
 * Created On 05-02-2018
 * 
 */
package eBL;

import java.io.Serializable;

public class BLPatientWiseTransModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String encounterId;
	private String encounterType;
	private String documentDate;
	private String documentNumber;
	private String documentType;
	private String amountDr;
	private String amountCr;
	private String amountBal;
	private String patientName;
	private String episodeType;
	private String packagedtl;

	
	
	
	public String getPackagedtl() {
		return packagedtl;
	}

	public void setPackagedtl(String packagedtl) {
		this.packagedtl = packagedtl;
	}

	public String getEpisodeType() {
		return episodeType;
	}

	public void setEpisodeType(String episodeType) {
		this.episodeType = episodeType;
	}

	public String getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}

	public String getEncounterType() {
		return encounterType;
	}

	public void setEncounterType(String encounterType) {
		this.encounterType = encounterType;
	}

	public String getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getAmountDr() {
		return amountDr;
	}

	public void setAmountDr(String amountDr) {
		this.amountDr = amountDr;
	}

	public String getAmountCr() {
		return amountCr;
	}

	public void setAmountCr(String amountCr) {
		this.amountCr = amountCr;
	}

	public String getAmountBal() {
		return amountBal;
	}

	public void setAmountBal(String amountBal) {
		this.amountBal = amountBal;
	}
	
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

}
