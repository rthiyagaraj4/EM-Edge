/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
18/07/2013        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eCA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EncSummGroupBean implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int iGroupFlag;	
	private String sGroupType; 
	private String sGroupCode; 
	private String sGroupDesc;
	private String sGroupRemarks; 
	private String sImageURL; 
	private String sGroupStatus;
	
	private int iSubCompFlag;	
	private String sSubCompType;
	private String sSubCompCode; 
	private String sSubCompDesc;
	private String sSubCompRemarks; 
	private String sSubImageURL; 
	private String sSubCompStatus;
	private int iSubCompTemplate;
	private int iSubCompColumns; 	
	private String sSubCompTemplate;
	private String sSubCompTempDesc;
	private String sSubCompColumnType;
	
	private String sSubGroupType; 
	private String sSubCompSubGroup;
	private String sSubCompSubGroupDesc;
	
	public HttpServletRequest request;
	public HttpSession session;

	/**
	 * @return the Group Flag 
	 */
	public int getiGroupFlag() {
		return iGroupFlag;
	}
	/**
	 * @param iGroupFlag the iGroupFlag to set
	 */
	public void setiGroupFlag(int iGroupFlag) {
		this.iGroupFlag = iGroupFlag;
	}
	
	/**
	 * @return the Group Type 
	 */
	public String getsGroupType() {
		return sGroupType;
	}
	/**
	 * @param sGroupType the sGroupType to set
	 */
	public void setsGroupType(String sGroupType) {
		this.sGroupType = sGroupType;
	}

	/**
	 * @return the Group Code
	 */
	public String getsGroupCode() {
		return sGroupCode;
	}
	/**
	 * @param sGroupCode the sGroupCode to set
	 */
	public void setsGroupCode(String sGroupCode) {
		this.sGroupCode = sGroupCode;
	}

	/**
	 * @return the Group Description 
	 */
	public String getsGroupDesc() {
		return sGroupDesc;
	}
	/**
	 * @param sGroupDesc the sGroupDesc to set
	 */
	public void setsGroupDesc(String sGroupDesc) {
		this.sGroupDesc = sGroupDesc;
	}

	/**
	 * @return the Group remarks
	 */
	public String getsGroupRemarks() {
		return sGroupRemarks;
	}
	/**
	 * @param sGroupRemarks the sGroupRemarks to set
	 */
	public void setsGroupRemarks(String sGroupRemarks) {
		this.sGroupRemarks = sGroupRemarks;
	}

	/**
	 * @return the Image URL
	 */
	public String getsImageURL() {
		return sImageURL;
	}
	/**
	 * @param sImageURL the sImageURL to set
	 */
	public void setsImageURL(String sImageURL) {
		this.sImageURL = sImageURL;
	}
	
	/**
	 * @return the Group Status
	 */
	public String getsGroupStatus() {
		return sGroupStatus;
	}
	/**
	 * @param iGroupStatus the iGroupStatus to set
	 */
	public void setsGroupStatus(String sGroupStatus) {
		this.sGroupStatus = sGroupStatus;
	}	


	/**
	 *Set & Get Methods for Group Components
	 */
	/**
	 * @return the Sub Group Type
	 */
	public String getsSubGroupType() {
		return sSubGroupType;
	}
	/**
	 * @param sSubGroupType the sSubGroupType to set
	 */
	public void setsSubGroupType(String sSubGroupType) {
		this.sSubGroupType = sSubGroupType;
	}
	
	/**
	 * @return the Sub Component Flag
	 */
	public int getiSubCompFlag() {
		return iSubCompFlag;
	}
	/**
	 * @param iSubCompFlag the iSubCompFlag to set
	 */
	public void setiSubCompFlag(int iSubCompFlag) {
		this.iSubCompFlag = iSubCompFlag;
	}	
	
	/**
	 * @return the Sub Component Type
	 */
	public String getsSubCompType() {
		return sSubCompType;
	}
	/**
	 * @param sSubCompType the sSubCompType to set
	 */
	public void setsSubCompType(String sSubCompType) {
		this.sSubCompType = sSubCompType;
	}

	/**
	 * @return the Sub Component Code
	 */
	public String getsSubCompCode() {
		return sSubCompCode;
	}
	/**
	 * @param sSubCompCode the sSubCompCode to set
	 */
	public void setsSubCompCode(String sSubCompCode) {
		this.sSubCompCode = sSubCompCode;
	}
	
	/**
	 * @return the Sub Component Description
	 */
	public String getsSubCompDesc() {
		return sSubCompDesc;
	}
	/**
	 * @param sSubCompDesc the sSubCompDesc to set
	 */
	public void setsSubCompDesc(String sSubCompDesc) {
		this.sSubCompDesc = sSubCompDesc;
	}
	
	/**
	 * @return the Sub Component Remarks
	 */
	public String getsSubCompRemarks() {
		return sSubCompRemarks;
	}
	/**
	 * @param sSubCompRemarks the sSubCompRemarks to set
	 */
	public void setsSubCompRemarks(String sSubCompRemarks) {
		this.sSubCompRemarks = sSubCompRemarks;
	}
	/**
	 * @return the Sub Component Image URL
	 */
	public String getsSubImageURL() {
		return sSubImageURL;
	}
	/**
	 * @param sSubImageURL the sSubImageURL to set
	 */
	public void setsSubImageURL(String sSubImageURL) {
		this.sSubImageURL = sSubImageURL;
	}

	
	/**
	 * @return the Sub Component Template
	 */
	public int getiSubCompTemplate() {
		return iSubCompTemplate;
	}
	/**
	 * @param iSubCompTemplate the iSubCompTemplate to set
	 */
	public void setiSubCompTemplate(int iSubCompTemplate) {
		this.iSubCompTemplate = iSubCompTemplate;
	}	

	/**
	 * @return the Sub Component Table Column Count
	 */
	public int getiSubCompColumns() {
		return iSubCompColumns;
	}
	/**
	 * @param iSubCompColumns the iSubCompColumns to set
	 */
	public void setiSubCompColumns(int iSubCompColumns) {
		this.iSubCompColumns = iSubCompColumns;
	}	
	
	/**
	 * @return the Sub Component Template Description
	 */
	public String getsSubCompTempDesc() {
		return sSubCompTempDesc;
	}
	/**
	 * @param sSubCompDesc the sSubCompDesc to set
	 */
	public void setsSubCompTempDesc(String sSubCompTempDesc) {
		this.sSubCompTempDesc = sSubCompTempDesc;
	}
	
	/**
	 * @return the Sub Component Column Type
	 */
	public String getsSubCompColumnType() {
		return sSubCompColumnType;
	}
	/**
	 * @param sSubCompDesc the sSubCompDesc to set
	 */
	public void setsSubCompColumnType(String sSubCompColumnType) {
		this.sSubCompColumnType = sSubCompColumnType;
	}
	
	/**
	 * @return the Sub Component Status
	 */
	public String getsSubCompStatus() {
		return sSubCompStatus;
	}
	/**
	 * @param iSubCompStatus the iSubCompStatus to set
	 */
	public void setsSubCompStatus(String sSubCompStatus) {
		this.sSubCompStatus = sSubCompStatus;
	}	
		
	/**
	 * @return the Sub Component Sub-Group
	 */
	public String getsSubCompSubGroup() {
		return sSubCompSubGroup;
	}
	/**
	 * @param sSubCompSubGroup the sSubCompSubGroup to set
	 */
	public void setsSubCompSubGroup(String sSubCompSubGroup) {
		this.sSubCompSubGroup = sSubCompSubGroup;
	}	
	
	/**
	 * @return the Sub Component Template Description
	 */
	public String getsSubCompTemplate() {
		return sSubCompTemplate;
	}
	/**
	 * @param sSubCompTemplate the sSubCompTemplate to set
	 */
	public void setsSubCompTemplate(String sSubCompTemplate) {
		this.sSubCompTemplate = sSubCompTemplate;
	}	
	
	/**
	 * @return the Sub Group Description
	 */
	public String getsSubCompSubGroupDesc() {
		return sSubCompSubGroupDesc;
	}
	/**
	 * @param sSubCompSubGroupDesc the sSubCompSubGroupDesc to set
	 */
	public void setsSubCompSubGroupDesc(String sSubCompSubGroupDesc) {
		this.sSubCompSubGroupDesc = sSubCompSubGroupDesc;
	}	
	
	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}
	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}	

	
}
