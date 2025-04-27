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
package eIPAD.chartsummary.clinicalnotes.healthobject;

/**
 * @author vchoughule 
 *
 */
public class ClinicalNotesJSONFileds {

	private String code;
	private String desc;
	private String detail;// to add any extra feild which is required
	private Boolean defaultField;
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
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * @return the defaultField
	 */
	public Boolean getDefaultField() {
		return defaultField;
	}
	/**
	 * @param defaultField the defaultField to set
	 */
	public void setDefaultField(Boolean defaultField) {
		this.defaultField = defaultField;
	}
	
}
