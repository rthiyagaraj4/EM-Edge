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

public class EncSummConfigGroupBean implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int iGroupFlag;	
	private String sGroupType; 
	private String sGroupCode; 
	private String sGroupDesc;
	private String sGroupRemarks; 
	private String sImageURL; 
	private String sGroupStatus;
	private String sRowId;
	private String sSearchText;
	
	private String sSummaryCode;
	private String sSummaryDesc;
	private String sValid;
	
	private int iSequence;	
	
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
	 * @return the sRowID
	 */
	public String getsRowId() {
		return sRowId;
	}
	/**
	 * @param sRowId the sRowId to set
	 */
	public void setsRowId(String sRowId) {
		this.sRowId = sRowId;
	}	
	
	/**
	 * @return the sSearchText
	 */
	public String getsSearchText() {
		return sSearchText;
	}
	/**
	 * @param sSearchText the sSearchText to set
	 */
	public void setsSearchText(String sSearchText) {
		this.sSearchText = sSearchText;
	}	
	
	/**
	 * @return the sSummaryCode
	 */
	public String getsSummaryCode() {
		return sSummaryCode;
	}
	/**
	 * @param sSummaryCode the sSummaryCode to set
	 */
	public void setsSummaryCode(String sSummaryCode) {
		this.sSummaryCode = sSummaryCode;
	}	
	
	/**
	 * @return the sSummaryDesc
	 */
	public String getsSummaryDesc() {
		return sSummaryDesc;
	}
	/**
	 * @param sSummaryDesc the sSummaryDesc to set
	 */
	public void setsSummaryDesc(String sSummaryDesc) {
		this.sSummaryDesc = sSummaryDesc;
	}	
	
	/**
	 * @return the sValid
	 */
	public String getsValid() {
		return sValid;
	}
	/**
	 * @param sSummaryCode the sSummaryCode to set
	 */
	public void setsValid(String sValid) {
		this.sValid = sValid;
	}	
	
	/**
	 * @return the iSequence 
	 */
	public int getiSequence() {
		return iSequence;
	}
	/**
	 * @param iSequence the iSequence to set
	 */
	public void setiSequence(int iSequence) {
		this.iSequence = iSequence;
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
