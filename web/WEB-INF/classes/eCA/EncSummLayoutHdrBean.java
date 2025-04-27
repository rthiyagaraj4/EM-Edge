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

public class EncSummLayoutHdrBean implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int iHeaderOrient; 
	private int iColorsIndicate; 
	private int iTabcellColFill; 
	private int iTabCellBorFill; 
	
	private int iFooterSignFlag; 
	private int iFooterSignPosn; 
	private int iFooterSign1Flag; 
	private String sFooterSign1Lbl; 
	private int iFooterSign1PractID; 
	private int iFooterSign1Splty; 
	private int iFooterSign2Flag; 
	private String sFooterSign2Lbl; 
	private int iFooterSign2PractID; 
	private int iFooterSign2Splty; 
	private int iFooterSign3Flag; 
	private String sFooterSign3Lbl; 
	private int iFooterSign3PractID; 
	private int iFooterSign3Splty;
	
	private int iFooterDigitSign;
	
	private String sHeaderCode;
	private String sFooterCode;
	
	private String sSummaryCode;
	private String sSummaryDesc;
	
	public HttpServletRequest request;
	public HttpSession session;

	/**
	 * @return the Header Orientation
	 */
	public int getiHeaderOrient() {
		return iHeaderOrient;
	}
	/**
	 * @param iHeaderOrient the iHeaderOrient to set
	 */
	public void setiHeaderOrient(int iHeaderOrient) {
		this.iHeaderOrient = iHeaderOrient;
	}

	/**
	 * @return the Colors Indicate
	 */
	public int getiColorsIndicate() {
		return iColorsIndicate;
	}
	/**
	 * @param iColorsIndicate the iColorsIndicate to set
	 */
	public void setiColorsIndicate(int iColorsIndicate) {
		this.iColorsIndicate = iColorsIndicate;
	}
	
	/**
	 * @return the Table Cell Color
	 */
	public int getiTabcellColFill() {
		return iTabcellColFill;
	}
	/**
	 * @param iTabcellColFill the iTabcellColFill to set
	 */
	public void setiTabcellColFill(int iTabcellColFill) {
		this.iTabcellColFill = iTabcellColFill;
	}
	
	/**
	 * @return the Table Cell Border Color Fill
	 */
	public int getiTabCellBorFill() {
		return iTabCellBorFill;
	}
	/**
	 * @param iTabCellBorFill the iTabCellBorFill to set
	 */
	public void setiTabCellBorFill(int iTabCellBorFill) {
		this.iTabCellBorFill = iTabCellBorFill;
	}
	
	/**
	 * @return the Footer Sign Flag
	 */
	public int getiFooterSignFlag() {
		return iFooterSignFlag;
	}
	/**
	 * @param iFooterSignFlag the iFooterSignFlag to set
	 */
	public void setiFooterSignFlag(int iFooterSignFlag) {
		this.iFooterSignFlag = iFooterSignFlag;
	}
	
	/**
	 * @return the Footer Sign Position
	 */
	public int getiFooterSignPosn() {
		return iFooterSignPosn;
	}
	/**
	 * @param iFooterSignPosn the iFooterSignPosn to set
	 */
	public void setiFooterSignPosn(int iFooterSignPosn) {
		this.iFooterSignPosn = iFooterSignPosn;
	}
	
	
	/**
	 * @return the Table Sign 1 Flag
	 */
	public int getiFooterSign1Flag() {
		return iFooterSign1Flag;
	}
	/**
	 * @param iFooterSign1Flag the iFooterSign1Flag to set
	 */
	public void setiFooterSign1Flag(int iFooterSign1Flag) {
		this.iFooterSign1Flag = iFooterSign1Flag;
	}
		
	/**
	 * @return the Sign 1 label 
	 */
	public String getsFooterSign1Lbl() {
		return sFooterSign1Lbl;
	}
	/**
	 * @param sFooterSign1Lbl the sFooterSign1Lbl to set
	 */
	public void setsFooterSign1Lbl(String sFooterSign1Lbl) {
		this.sFooterSign1Lbl = sFooterSign1Lbl;
	}
	
	/**
	 * @return the Footer Sign 1 Practitioner ID
	 */
	public int getiFooterSign1PractID() {
		return iFooterSign1PractID;
	}
	/**
	 * @param iFooterSign1PractID the iFooterSign1PractID to set
	 */
	public void setiFooterSign1PractID(int iFooterSign1PractID) {
		this.iFooterSign1PractID = iFooterSign1PractID;
	}
	
	/**
	 * @return the FOoter Sign 1 Specialty
	 */
	public int getiFooterSign1Splty() {
		return iFooterSign1Splty;
	}
	/**
	 * @param iFooterSign1Splty the iFooterSign1Splty to set
	 */
	public void setiFooterSign1Splty(int iFooterSign1Splty) {
		this.iFooterSign1Splty = iFooterSign1Splty;
	}
	
	/**
	 * @return the Table Sign 2 Flag
	 */
	public int getiFooterSign2Flag() {
		return iFooterSign2Flag;
	}
	/**
	 * @param iFooterSign2Flag the iFooterSign2Flag to set
	 */
	public void setiFooterSign2Flag(int iFooterSign2Flag) {
		this.iFooterSign2Flag = iFooterSign2Flag;
	}
		
	/**
	 * @return the Sign 2 label 
	 */
	public String getsFooterSign2Lbl() {
		return sFooterSign2Lbl;
	}
	/**
	 * @param sFooterSign2Lbl the sFooterSign2Lbl to set
	 */
	public void setsFooterSign2Lbl(String sFooterSign2Lbl) {
		this.sFooterSign2Lbl = sFooterSign2Lbl;
	}
	
	/**
	 * @return the Footer Sign 2 Practitioner ID
	 */
	public int getiFooterSign2PractID() {
		return iFooterSign2PractID;
	}
	/**
	 * @param iFooterSign2PractID the iFooterSign2PractID to set
	 */
	public void setiFooterSign2PractID(int iFooterSign2PractID) {
		this.iFooterSign2PractID = iFooterSign2PractID;
	}
	
	/**
	 * @return the FOoter Sign 2 Specialty
	 */
	public int getiFooterSign2Splty() {
		return iFooterSign2Splty;
	}
	/**
	 * @param iFooterSign2Splty the iFooterSign2Splty to set
	 */
	public void setiFooterSign2Splty(int iFooterSign2Splty) {
		this.iFooterSign2Splty = iFooterSign2Splty;
	}
		
	/**
	 * @return the Table Sign 3 Flag
	 */
	public int getiFooterSign3Flag() {
		return iFooterSign3Flag;
	}
	/**
	 * @param iFooterSign3Flag the iFooterSign3Flag to set
	 */
	public void setiFooterSign3Flag(int iFooterSign3Flag) {
		this.iFooterSign3Flag = iFooterSign3Flag;
	}
		
	/**
	 * @return the Sign 3 label 
	 */
	public String getsFooterSign3Lbl() {
		return sFooterSign3Lbl;
	}
	/**
	 * @param sFooterSign3Lbl the sFooterSign3Lbl to set
	 */
	public void setsFooterSign3Lbl(String sFooterSign3Lbl) {
		this.sFooterSign3Lbl = sFooterSign3Lbl;
	}
	
	/**
	 * @return the Footer Sign 3 Practitioner ID
	 */
	public int getiFooterSign3PractID() {
		return iFooterSign3PractID;
	}
	/**
	 * @param iFooterSign3PractID the iFooterSign3PractID to set
	 */
	public void setiFooterSign3PractID(int iFooterSign3PractID) {
		this.iFooterSign3PractID = iFooterSign3PractID;
	}
	
	/**
	 * @return the FOoter Sign 3 Specialty
	 */
	public int getiFooterSign3Splty() {
		return iFooterSign3Splty;
	}
	/**
	 * @param iFooterSign3Splty the iFooterSign3Splty to set
	 */
	public void setiFooterSign3Splty(int iFooterSign3Splty) {
		this.iFooterSign3Splty = iFooterSign3Splty;
	}
	
	/**
	 * @return the Footer Sign 3 Specialty
	 */
	public int getiFooterDigitSign() {
		return iFooterDigitSign;
	}
	/**
	 * @param iFooterDigitSign the iFooterDigitSign to set
	 */
	public void setiFooterDigitSign(int iFooterDigitSign) {
		this.iFooterDigitSign = iFooterDigitSign;
	}

	/**
	 * @return the Header Code
	 */
	public String getsHeaderCode() {
		return sHeaderCode;
	}
	/**
	 * @param sHeaderCode the sHeaderCode to set
	 */
	public void setsHeaderCode(String sHeaderCode) {
		this.sHeaderCode = sHeaderCode;
	}

	/**
	 * @return the Field Flag 
	 */
	public String getsFooterCode() {
		return sFooterCode;
	}
	/**
	 * @param sFooterCode the sFooterCode to set
	 */
	public void setsFooterCode(String sFooterCode) {
		this.sFooterCode = sFooterCode;
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
