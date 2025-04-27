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
13/09/2013        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eCA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EncSummGroupSummBean implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String sSummCode; 
	private String sSummDesc;
	private String sSummTitle; 
	private String sSummStatus;
	
	private String sSummType; 
	
	private int iGroupFlag;	
	private String sGroupType; 
	private String sGroupCode; 
	private String sGroupDesc;	 
	private String sGroupStatus;
	
	public HttpServletRequest request;
	public HttpSession session;

	/**
	 * @return the Summary Code
	 */
	public String getsSummCode() {
		return sSummCode;
	}
	/**
	 * @param sSummCode the sSummCode to set
	 */
	public void setsSummCode(String sSummCode) {
		this.sSummCode = sSummCode;
	}

	/**
	 * @return the Summary Description 
	 */
	public String getsSummDesc() {
		return sSummDesc;
	}
	/**
	 * @param sSummDesc the sSummDesc to set
	 */
	public void setsSummDesc(String sSummDesc) {
		this.sSummDesc = sSummDesc;
	}

	/**
	 * @return the Summary Title 
	 */
	public String getsSummTitle() {
		return sSummTitle;
	}
	/**
	 * @param sSummTitle the sSummTitle to set
	 */
	public void setsSummTitle(String sSummTitle) {
		this.sSummTitle = sSummTitle;
	}

	/**
	 * @return the Summary Status
	 */
	public String getsSummStatus() {
		return sSummStatus;
	}
	/**
	 * @param sSummStatus the sSummStatus to set
	 */
	public void setsSummStatus(String sSummStatus) {
		this.sSummStatus = sSummStatus;
	}
	
	/**
	 * @return the Summary Type 
	 */
	public String getsSummType() {
		return sSummType;
	}
	/**
	 * @param sSummType the sSummType to set
	 */
	public void setsSummType(String sSummType) {
		this.sSummType = sSummType;
	}
	
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
