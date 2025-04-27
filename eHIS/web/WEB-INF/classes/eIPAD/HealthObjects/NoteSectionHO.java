/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.HealthObjects;
import java.io.*;
public class NoteSectionHO implements java.io.Serializable {
	private String secHdgCode;
	private String docExists;
	private String noteType;
	private String secContentType;
	private String secResultLinkedRectype;
	private String childSecHdgCode;
	private String childSecContentType;
	private String childSecResultLinkRecType;
	private String chiefComplaintSecYN;
	private String imageLinkedYN;
	private String contentEditableYN;
	private String resultLinkType;
	private String contentType;
	private String outputFormExistsYN;
	private String selectionType;
	private String secHdgDesc;
	private String childSecHdgDesc;
	/**
	 * @return the secHdgCode
	 */
	public String getSecHdgCode() {
		return secHdgCode;
	}
	/**
	 * @param secHdgCode the secHdgCode to set
	 */
	public void setSecHdgCode(String secHdgCode) {
		this.secHdgCode = secHdgCode;
	}
	/**
	 * @return the docExists
	 */
	public String getDocExists() {
		return docExists;
	}
	/**
	 * @param docExists the docExists to set
	 */
	public void setDocExists(String docExists) {
		this.docExists = docExists;
	}
	/**
	 * @return the noteType
	 */
	public String getNoteType() {
		return noteType;
	}
	/**
	 * @param noteType the noteType to set
	 */
	public void setNoteType(String noteType) {
		this.noteType = noteType;
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
	 * @return the secResultLinkedRectype
	 */
	public String getSecResultLinkedRectype() {
		return secResultLinkedRectype;
	}
	/**
	 * @param secResultLinkedRectype the secResultLinkedRectype to set
	 */
	public void setSecResultLinkedRectype(String secResultLinkedRectype) {
		this.secResultLinkedRectype = secResultLinkedRectype;
	}
	/**
	 * @return the childSecHdgCode
	 */
	public String getChildSecHdgCode() {
		return childSecHdgCode;
	}
	/**
	 * @param childSecHdgCode the childSecHdgCode to set
	 */
	public void setChildSecHdgCode(String childSecHdgCode) {
		this.childSecHdgCode = childSecHdgCode;
	}
	/**
	 * @return the childSecContentType
	 */
	public String getChildSecContentType() {
		return childSecContentType;
	}
	/**
	 * @param childSecContentType the childSecContentType to set
	 */
	public void setChildSecContentType(String childSecContentType) {
		this.childSecContentType = childSecContentType;
	}
	/**
	 * @return the childSecResultLinkRecType
	 */
	public String getChildSecResultLinkRecType() {
		return childSecResultLinkRecType;
	}
	/**
	 * @param childSecResultLinkRecType the childSecResultLinkRecType to set
	 */
	public void setChildSecResultLinkRecType(String childSecResultLinkRecType) {
		this.childSecResultLinkRecType = childSecResultLinkRecType;
	}
	/**
	 * @return the chiefComplaintSecYN
	 */
	public String getChiefComplaintSecYN() {
		return chiefComplaintSecYN;
	}
	/**
	 * @param chiefComplaintSecYN the chiefComplaintSecYN to set
	 */
	public void setChiefComplaintSecYN(String chiefComplaintSecYN) {
		this.chiefComplaintSecYN = chiefComplaintSecYN;
	}
	/**
	 * @return the imageLinkedYN
	 */
	public String getImageLinkedYN() {
		return imageLinkedYN;
	}
	/**
	 * @param imageLinkedYN the imageLinkedYN to set
	 */
	public void setImageLinkedYN(String imageLinkedYN) {
		this.imageLinkedYN = imageLinkedYN;
	}
	/**
	 * @return the contentEditableYN
	 */
	public String getContentEditableYN() {
		return contentEditableYN;
	}
	/**
	 * @param contentEditableYN the contentEditableYN to set
	 */
	public void setContentEditableYN(String contentEditableYN) {
		this.contentEditableYN = contentEditableYN;
	}
	/**
	 * @return the resultLinkType
	 */
	public String getResultLinkType() {
		return resultLinkType;
	}
	/**
	 * @param resultLinkType the resultLinkType to set
	 */
	public void setResultLinkType(String resultLinkType) {
		this.resultLinkType = resultLinkType;
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
	 * @return the outputFormExistsYN
	 */
	public String getOutputFormExistsYN() {
		return outputFormExistsYN;
	}
	/**
	 * @param outputFormExistsYN the outputFormExistsYN to set
	 */
	public void setOutputFormExistsYN(String outputFormExistsYN) {
		this.outputFormExistsYN = outputFormExistsYN;
	}
	/**
	 * @return the selectionType
	 */
	public String getSelectionType() {
		return selectionType;
	}
	/**
	 * @param selectionType the selectionType to set
	 */
	public void setSelectionType(String selectionType) {
		this.selectionType = selectionType;
	}
	/**
	 * @return the secHdgDesc
	 */
	public String getSecHdgDesc() {
		return secHdgDesc;
	}
	/**
	 * @param secHdgDesc the secHdgDesc to set
	 */
	public void setSecHdgDesc(String secHdgDesc) {
		this.secHdgDesc = secHdgDesc;
	}
	/**
	 * @return the childSecHdgDesc
	 */
	public String getChildSecHdgDesc() {
		return childSecHdgDesc;
	}
	/**
	 * @param childSecHdgDesc the childSecHdgDesc to set
	 */
	public void setChildSecHdgDesc(String childSecHdgDesc) {
		this.childSecHdgDesc = childSecHdgDesc;
	}
	

}
