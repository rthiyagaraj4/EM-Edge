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

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author vchoughule
 *
 */
public class ClinicalNotesSectionFields {
	
	private ArrayList<String> secNoteList;
	//private ArrayList<String> childSecNoteDesc;
	private String secCode;
	private String secDesc;
	private String childSecCode;
	private String childSecDesc;
	private String secContentType;
	private String reportHeader;
	private StringBuffer sectionContentUpdatedXML;
	private String contentType;
	private String image_linked_yn;
	private String chief_complaint_sec_yn;
	private String result_link_type;
	private String output_form_exists_yn;
	private String footerCode ;
	private StringBuffer sectionContentUpdatedHeaderXML;
	private StringBuffer sectionContentUpdatedFooterXML;
	private StringBuffer sectionContentUpdatedSecXML;
	private Hashtable htPatientDetail; // nt required 
	private String patientId;
	
	/**
	 * @return the secNoteList
	 */
	public ArrayList<String> getSecNoteList() {
		return secNoteList;
	}

	/**
	 * @param secNoteList the secNoteList to set
	 */
	public void setSecNoteList(ArrayList<String> secNoteList) {
		this.secNoteList = secNoteList;
	}

	/**
	 * @return the secCode
	 */
	public String getSecCode() {
		return secCode;
	}

	/**
	 * @param secCode the secCode to set
	 */
	public void setSecCode(String secCode) {
		this.secCode = secCode;
	}

	/**
	 * @return the secDesc
	 */
	public String getSecDesc() {
		return secDesc;
	}

	/**
	 * @param secDesc the secDesc to set
	 */
	public void setSecDesc(String secDesc) {
		this.secDesc = secDesc;
	}

	/**
	 * @return the childSecCode
	 */
	public String getChildSecCode() {
		return childSecCode;
	}

	/**
	 * @param childSecCode the childSecCode to set
	 */
	public void setChildSecCode(String childSecCode) {
		this.childSecCode = childSecCode;
	}

	/**
	 * @return the childSecDesc
	 */
	public String getChildSecDesc() {
		return childSecDesc;
	}

	/**
	 * @param childSecDesc the childSecDesc to set
	 */
	public void setChildSecDesc(String childSecDesc) {
		this.childSecDesc = childSecDesc;
	}

	/**
	 * @return the secContentType
	 */
	public String getSecContentType() {
		return secContentType;
	}

	/**
	 * @param secContentType the secContentType to set
	 */
	public void setSecContentType(String secContentType) {
		this.secContentType = secContentType;
	}

	/**
	 * @return the reportHeader
	 */
	public String getReportHeader() {
		return reportHeader;
	}

	/**
	 * @param reportHeader the reportHeader to set
	 */
	public void setReportHeader(String reportHeader) {
		this.reportHeader = reportHeader;
	}

	/**
	 * @return the sectionContentUpdatedXML
	 */
	public StringBuffer getSectionContentUpdatedXML() {
		return sectionContentUpdatedXML;
	}

	/**
	 * @param sectionContentUpdatedXML the sectionContentUpdatedXML to set
	 */
	public void setSectionContentUpdatedXML(StringBuffer sectionContentUpdatedXML) {
		this.sectionContentUpdatedXML = sectionContentUpdatedXML;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the image_linked_yn
	 */
	public String getImage_linked_yn() {
		return image_linked_yn;
	}

	/**
	 * @param image_linked_yn the image_linked_yn to set
	 */
	public void setImage_linked_yn(String image_linked_yn) {
		this.image_linked_yn = image_linked_yn;
	}

	/**
	 * @return the chief_complaint_sec_yn
	 */
	public String getChief_complaint_sec_yn() {
		return chief_complaint_sec_yn;
	}

	/**
	 * @param chief_complaint_sec_yn the chief_complaint_sec_yn to set
	 */
	public void setChief_complaint_sec_yn(String chief_complaint_sec_yn) {
		this.chief_complaint_sec_yn = chief_complaint_sec_yn;
	}

	/**
	 * @return the result_link_type
	 */
	public String getResult_link_type() {
		return result_link_type;
	}

	/**
	 * @param result_link_type the result_link_type to set
	 */
	public void setResult_link_type(String result_link_type) {
		this.result_link_type = result_link_type;
	}

	/**
	 * @return the output_form_exists_yn
	 */
	public String getOutput_form_exists_yn() {
		return output_form_exists_yn;
	}

	/**
	 * @param output_form_exists_yn the output_form_exists_yn to set
	 */
	public void setOutput_form_exists_yn(String output_form_exists_yn) {
		this.output_form_exists_yn = output_form_exists_yn;
	}

	/**
	 * @return the footerCode
	 */
	public String getFooterCode() {
		return footerCode;
	}

	/**
	 * @param footerCode the footerCode to set
	 */
	public void setFooterCode(String footerCode) {
		this.footerCode = footerCode;
	}

	/**
	 * @return the sectionContentUpdatedHeaderXML
	 */
	public StringBuffer getSectionContentUpdatedHeaderXML() {
		return sectionContentUpdatedHeaderXML;
	}

	/**
	 * @param sectionContentUpdatedHeaderXML the sectionContentUpdatedHeaderXML to set
	 */
	public void setSectionContentUpdatedHeaderXML(
			StringBuffer sectionContentUpdatedHeaderXML) {
		this.sectionContentUpdatedHeaderXML = sectionContentUpdatedHeaderXML;
	}

	/**
	 * @return the sectionContentUpdatedFooterXML
	 */
	public StringBuffer getSectionContentUpdatedFooterXML() {
		return sectionContentUpdatedFooterXML;
	}

	/**
	 * @param sectionContentUpdatedFooterXML the sectionContentUpdatedFooterXML to set
	 */
	public void setSectionContentUpdatedFooterXML(
			StringBuffer sectionContentUpdatedFooterXML) {
		this.sectionContentUpdatedFooterXML = sectionContentUpdatedFooterXML;
	}

	/**
	 * @return the sectionContentUpdatedSecXML
	 */
	public StringBuffer getSectionContentUpdatedSecXML() {
		return sectionContentUpdatedSecXML;
	}

	/**
	 * @param sectionContentUpdatedSecXML the sectionContentUpdatedSecXML to set
	 */
	public void setSectionContentUpdatedSecXML(
			StringBuffer sectionContentUpdatedSecXML) {
		this.sectionContentUpdatedSecXML = sectionContentUpdatedSecXML;
	}

	/**
	 * @return the htPatientDetail
	 */
	public Hashtable getHtPatientDetail() {
		return htPatientDetail;
	}

	/**
	 * @param htPatientDetail the htPatientDetail to set
	 */
	public void setHtPatientDetail(Hashtable htPatientDetail) {
		this.htPatientDetail = htPatientDetail;
	}

	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


}
