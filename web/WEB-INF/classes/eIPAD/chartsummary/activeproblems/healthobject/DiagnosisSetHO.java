/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIPAD.chartsummary.activeproblems.healthobject;

/**
 * @author SaraswathiR  
 *
 */
public class DiagnosisSetHO {

	private String code;
	private String desc;
	private boolean defaultValue;
	private String applicableFields;
	private boolean freeTextDiagnosis;


	/**
	 * @return the applicableFields
	 */
	public String getApplicableFields() {
		return applicableFields;
	}
	/**
	 * @param applicableFields the applicableFields to set
	 */
	public void setApplicableFields(String applicableFields) {
		this.applicableFields = applicableFields;
	}
	/**
	 * @return the freeTextDiagnosis
	 */
	public boolean isFreeTextDiagnosis() {
		return freeTextDiagnosis;
	}
	/**
	 * @param freeTextDiagnosis the freeTextDiagnosis to set
	 */
	public void setFreeTextDiagnosis(boolean freeTextDiagnosis) {
		this.freeTextDiagnosis = freeTextDiagnosis;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the defaultValue
	 */
	public boolean isDefaultValue() {
		return defaultValue;
	}
	/**
	 * @param defaultValue the defaultValue to set
	 */
	public void setDefaultValue(boolean defaultValue) {
		this.defaultValue = defaultValue;
	}
	
}
