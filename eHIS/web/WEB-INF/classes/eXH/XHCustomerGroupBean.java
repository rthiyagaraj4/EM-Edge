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
Date       	 Name        	Description
-----------------------------------------------------------------------------------------------
30/07/2020   G.Niveditha    created

-----------------------------------------------------------------------------------------------
*/ 
package eXH;

import org.apache.commons.lang.StringUtils;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.io.*;
import java.lang.*;

public class XHCustomerGroupBean implements java.io.Serializable
{
	private String custGroupCode;
	private String opInterface;
	private String emInterface;
	private String ipInterface;
	private String dcInterface;
	private String nationalIdFlag;
	private String altId1;
	private String altId2;
	private String altId3;
	private String altId4;
	private String altId5;
	private String membshpIdFlag;
	private String visitRegFlag;
	private String policyNoFlag;
	private String citizenAltId1;
	private String citizenAltId2;
	private String citizenAltId3;
	private String citizenAltId4;
	private String citizenAltId5;
	
	public String getCustGroupCode() {
		return custGroupCode;
	}
	public void setCustGroupCode(String custGroupCode) {
		this.custGroupCode = custGroupCode;
	}
	public String getOpInterface() {
		return opInterface;
	}
	public void setOpInterface(String opInterface) {
		this.opInterface = opInterface;
	}
	public String getEmInterface() {
		return emInterface;
	}
	public void setEmInterface(String emInterface) {
		this.emInterface = emInterface;
	}
	public String getIpInterface() {
		return ipInterface;
	} 
	public void setIpInterface(String ipInterface) {
		this.ipInterface = ipInterface;
	}
	public String getDcInterface() {
		return dcInterface;
	}
	public void setDcInterface(String dcInterface) {
		this.dcInterface = dcInterface;
	}
	public String getNationalIdFlag() {
		return nationalIdFlag;
	}
	public void setNationalIdFlag(String nationalIdFlag) {
		this.nationalIdFlag = nationalIdFlag;
	}
	public String getAltId1() {
		return altId1;
	}
	public void setAltId1(String altId1) {
		this.altId1 = altId1;
	}
	public String getAltId2() {
		return altId2;
	}
	public void setAltId2(String altId2) {
		this.altId2 = altId2;
	}
	public String getAltId3() {
		return altId3;
	}
	public void setAltId3(String altId3) {
		this.altId3 = altId3;
	}
	public String getAltId4() {
		return altId4;
	}
	public void setAltId4(String altId4) {
		this.altId4 = altId4;
	}
	public String getAltId5() {
		return altId5;
	}
	public void setAltId5(String altId5) {
		this.altId5 = altId5;
	}
	public String getMembshpIdFlag() {
		return membshpIdFlag;
	}
	public void setMembshpIdFlag(String membshpIdFlag) {
		this.membshpIdFlag = membshpIdFlag;
	}
	public String getVisitRegFlag() {
		return visitRegFlag;
	}
	public void setVisitRegFlag(String visitRegFlag) {
		this.visitRegFlag = visitRegFlag;
	}
	public String getPolicyNoFlag() {
		return policyNoFlag;
	}
	public void setPolicyNoFlag(String policyNoFlag) {
		this.policyNoFlag = policyNoFlag;
	}
	public String getCitizenAltId1() {
		return citizenAltId1;
	}
	public void setCitizenAltId1(String citizenAltId1) {
		this.citizenAltId1 = citizenAltId1;
	}
	public String getCitizenAltId2() {
		return citizenAltId2;
	}
	public void setCitizenAltId2(String citizenAltId2) {
		this.citizenAltId2 = citizenAltId2;
	}
	public String getCitizenAltId3() {
		return citizenAltId3;
	}
	public void setCitizenAltId3(String citizenAltId3) {
		this.citizenAltId3 = citizenAltId3;
	}
	public String getCitizenAltId4() {
		return citizenAltId4;
	}
	public void setCitizenAltId4(String citizenAltId4) {
		this.citizenAltId4 = citizenAltId4;
	}
	public String getCitizenAltId5() {
		return citizenAltId5;
	}
	public void setCitizenAltId5(String citizenAltId5) {
		this.citizenAltId5 = citizenAltId5;
	}
}
