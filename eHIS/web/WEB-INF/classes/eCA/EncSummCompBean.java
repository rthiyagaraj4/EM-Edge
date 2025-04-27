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

public class EncSummCompBean implements java.io.Serializable
{	
	private static final long serialVersionUID = 1L; 
	
	private String sHistTypeRec; 
	private String sGroupCode;
	private String sCompCode; 
	private String sLongDesc; 
	private String sShortDesc;
	private String sRowId;
	private String sSearchText;
	
	private int iGFlag;
	private String sSubGroupType;
	
		
	public HttpServletRequest request;
	public HttpSession session;

	
	/**
	 * @return the History Type record 
	 */
	public String getsHistTypeRec() {
		return sHistTypeRec;
	}
	/**
	 * @param sHistTypeRec the sHistTypeRec to set
	 */
	public void setsHistTypeRec(String sHistTypeRec) {
		this.sHistTypeRec = sHistTypeRec;
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
	 * @return the Component Code 
	 */
	public String getsCompCode() {
		return sCompCode;
	}
	/**
	 * @param sCompCode the sCompCode to set
	 */
	public void setsCompCode(String sCompCode) {
		this.sCompCode = sCompCode;
	}

	/**
	 * @return the sLongDesc
	 */
	public String getsLongDesc() {
		return sLongDesc;
	}
	/**
	 * @param sLongDesc the sLongDesc to set
	 */
	public void setsLongDesc(String sLongDesc) {
		this.sLongDesc = sLongDesc;
	}

	/**
	 * @return the sShortDesc
	 */
	public String getsShortDesc() {
		return sShortDesc;
	}
	/**
	 * @param sShortDesc the sShortDesc to set
	 */
	public void setsShortDesc(String sShortDesc) {
		this.sShortDesc = sShortDesc;
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
	 * @return the iGFlag
	 */
	public int getiGFlag() {
		return iGFlag;
	}
	/**
	 * @param iGFlag the iGFlag to set
	 */
	public void setiGFlag(int iGFlag) {
		this.iGFlag = iGFlag;
	}	
	
	/**
	 * @return the sSubGroupType
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
