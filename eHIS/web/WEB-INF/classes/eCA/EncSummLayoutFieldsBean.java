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

public class EncSummLayoutFieldsBean implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String sFieldId; 
	private String sFieldType; 
	private String sFieldName;
	private int iFieldFlag; 
	private int iFieldOrient; 
	private String sFieldLabel;
	private String sFieldFormat;
	
	private String sSummaryCode;
	private String sSummaryDesc;
	
	public HttpServletRequest request;
	public HttpSession session;

	/**
	 * @return the Field ID 
	 */
	public String getsFieldId() {
		return sFieldId;
	}
	/**
	 * @param sFieldId the sFieldId to set
	 */
	public void setsFieldId(String sFieldId) {
		this.sFieldId = sFieldId;
	}

	/**
	 * @return the Field Type 
	 */
	public String getsFieldType() {
		return sFieldType;
	}
	/**
	 * @param sFieldType the sFieldType to set
	 */
	public void setsFieldType(String sFieldType) {
		this.sFieldType = sFieldType;
	}
	
	/**
	 * @return the Field Name 
	 */
	public String getsFieldName() {
		return sFieldName;
	}
	/**
	 * @param sFieldName the sFieldName to set
	 */
	public void setsFieldName(String sFieldName) {
		this.sFieldName = sFieldName;
	}

	/**
	 * @return the Field Flag 
	 */
	public int getiFieldFlag() {
		return iFieldFlag;
	}
	/**
	 * @param iFieldFlag the iFieldFlag to set
	 */
	public void setiFieldFlag(int iFieldFlag) {
		this.iFieldFlag = iFieldFlag;
	}
	
	/**
	 * @return the Field Orientation 
	 */
	public int getiFieldOrient() {
		return iFieldOrient;
	}
	/**
	 * @param iFieldOrient the iFieldOrient to set
	 */
	public void setiFieldOrient(int iFieldOrient) {
		this.iFieldOrient = iFieldOrient;
	}
	
	
	/**
	 * @return the Field Label 
	 */
	public String getsFieldLabel() {
		return sFieldLabel;
	}
	/**
	 * @param sFieldLabel the sFieldLabel to set
	 */
	public void setsFieldLabel(String sFieldLabel) {
		this.sFieldLabel = sFieldLabel;
	}

	/**
	 * @return the Field Format 
	 */
	public String getsFieldFormat() {
		return sFieldFormat;
	}
	/**
	 * @param sFieldFormat the sFieldFormat to set
	 */
	public void setsFieldFormat(String sFieldFormat) {
		this.sFieldFormat = sFieldFormat;
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
