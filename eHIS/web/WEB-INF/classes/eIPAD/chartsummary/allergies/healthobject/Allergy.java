/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.allergies.healthobject;

import java.util.ArrayList;

/** 
 * @author GaneshkumarC
 * This class is used to hold the allergy records.
 */
public class Allergy implements java.io.Serializable{
	
	private String allergyEventDesc;
	private String allergyEventCode;
	private String allergyEventTypeInd;
	private String allergenCode;
	private String allergenDesc;
	private String onsetDate;
	private String activeDate;
	private boolean estimatedDuration; 
	private String allergyStatus;
	private String causativeSubstance;
	private String diagnosisCode;
	private String certainity;
	private String remarks;
	private String routeOfExposure;
	private String allergyTestResult;
	private String treatmentAdvice;
	private String informationSource;
	
	
	
	private ArrayList<Reaction> reactions;

	private int count;
	/**
	 * @return the allergyDesc
	 */
	public String getAllergyEventDesc() {
		return allergyEventDesc;
	}
	/**
	 * @param allergyDesc the allergyDesc to set
	 */
	public void setAllergyEventDesc(String allergyEventDesc) {
		this.allergyEventDesc = allergyEventDesc;
	}
	/**
	 * @return the allergenDesc
	 */
	public String getAllergenDesc() {
		return allergenDesc;
	}
	/**
	 * @param allergenDesc the allergenDesc to set
	 */
	public void setAllergenDesc(String allergenDesc) {
		this.allergenDesc = allergenDesc;
	}
	/**
	 * @return the onsetDate
	 */
	public String getOnsetDate() {
		return onsetDate;
	}
	/**
	 * @param onsetDate the onsetDate to set
	 */
	public void setOnsetDate(String onsetDate) {
		this.onsetDate = onsetDate;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the reactions
	 */
	public ArrayList<Reaction> getReactions() {
		return reactions;
	}
	/**
	 * @param reactions the reactions to set
	 */
	public void setReactions(ArrayList<Reaction> reactions) {
		this.reactions = reactions;
	}
	/**
	 * @return the estimatedDuration
	 */
	public boolean isEstimatedDuration() {
		return estimatedDuration;
	}
	/**
	 * @param estimatedDuration the estimatedDuration to set
	 */
	public void setEstimatedDuration(boolean estimatedDuration) {
		this.estimatedDuration = estimatedDuration;
	}
	
	/**
	 * @Override
	 * Implementing equals because this object will be added to a map in the dao
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Allergy){
			Allergy allergy = (Allergy)obj;
			String thisAllergyStr = this.allergenCode+this.onsetDate+this.allergyEventCode+this.allergyEventTypeInd;
			String allergyStr = allergy.getAllergenCode()+allergy.getOnsetDate()+allergy.getAllergyEventCode()+allergy.getAllergyEventTypeInd();
			if(thisAllergyStr.equals(allergyStr))
				return true;
			else 
				return false;
		}
		else{
			return false;
		}
	}
	
	public int hashCode() {
		return allergenCode.hashCode() + onsetDate.hashCode() + allergyEventCode.hashCode() + allergyEventTypeInd.hashCode();
	}
	/**
	 * @return the allergenCode
	 */
	public String getAllergenCode() {
		return allergenCode;
	}
	/**
	 * @param allergenCode the allergenCode to set
	 */
	public void setAllergenCode(String allergenCode) {
		this.allergenCode = allergenCode;
	}
	/**
	 * @return the activeDate
	 */
	public String getActiveDate() {
		return activeDate;
	}
	/**
	 * @param activeDate the activeDate to set
	 */
	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}
	/**
	 * @return the allergyEventCode
	 */
	public String getAllergyEventCode() {
		return allergyEventCode;
	}
	/**
	 * @param allergyEventCode the allergyEventCode to set
	 */
	public void setAllergyEventCode(String allergyEventCode) {
		this.allergyEventCode = allergyEventCode;
	}
	/**
	 * @return the allergyEventTypeInd
	 */
	public String getAllergyEventTypeInd() {
		return allergyEventTypeInd;
	}
	/**
	 * @param allergyEventTypeInd the allergyEventTypeInd to set
	 */
	public void setAllergyEventTypeInd(String allergyEventTypeInd) {
		this.allergyEventTypeInd = allergyEventTypeInd;
	}
	/**
	 * @return the allergyStatus
	 */
	public String getAllergyStatus() {
		return allergyStatus;
	}
	/**
	 * @param allergyStatus the allergyStatus to set
	 */
	public void setAllergyStatus(String allergyStatus) {
		this.allergyStatus = allergyStatus;
	}
	/**
	 * @return the causativeSubstance
	 */
	public String getCausativeSubstance() {
		return causativeSubstance;
	}
	/**
	 * @param causativeSubstance the causativeSubstance to set
	 */
	public void setCausativeSubstance(String causativeSubstance) {
		this.causativeSubstance = causativeSubstance;
	}
	/**
	 * @return the diagnosisCode
	 */
	public String getDiagnosisCode() {
		return diagnosisCode;
	}
	/**
	 * @param diagnosisCode the diagnosisCode to set
	 */
	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}
	/**
	 * @return the certainity
	 */
	public String getCertainity() {
		return certainity;
	}
	/**
	 * @param certainity the certainity to set
	 */
	public void setCertainity(String certainity) {
		this.certainity = certainity;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the routeOfExposure
	 */
	public String getRouteOfExposure() {
		return routeOfExposure;
	}
	/**
	 * @param routeOfExposure the routeOfExposure to set
	 */
	public void setRouteOfExposure(String routeOfExposure) {
		this.routeOfExposure = routeOfExposure;
	}
	/**
	 * @return the allergyTestResult
	 */
	public String getAllergyTestResult() {
		return allergyTestResult;
	}
	/**
	 * @param allergyTestResult the allergyTestResult to set
	 */
	public void setAllergyTestResult(String allergyTestResult) {
		this.allergyTestResult = allergyTestResult;
	}
	/**
	 * @return the treatmentAdvice
	 */
	public String getTreatmentAdvice() {
		return treatmentAdvice;
	}
	/**
	 * @param treatmentAdvice the treatmentAdvice to set
	 */
	public void setTreatmentAdvice(String treatmentAdvice) {
		this.treatmentAdvice = treatmentAdvice;
	}
	/**
	 * @return the informationSource
	 */
	public String getInformationSource() {
		return informationSource;
	}
	/**
	 * @param informationSource the informationSource to set
	 */
	public void setInformationSource(String informationSource) {
		this.informationSource = informationSource;
	}
	
}
