
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

public class XHPatientDetailsBean implements java.io.Serializable
{
	private String patientId;
	private String nationalId;
	private String altId1Type;
	private String altId1No;
	private String altId2Type;
	private String altId2No;
	private String altId3Type;
	private String altId3No;
	private String altId4Type;
	private String altId4No;
	private String othAltIdType;
	private String othAltIdNo;
	 
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public String getAltId1Type() {
		return altId1Type;
	}
	public void setAltId1Type(String altId1Type) {
		this.altId1Type = altId1Type;
	}
	public String getAltId1No() {
		return altId1No;
	}
	public void setAltId1No(String altId1No) {
		this.altId1No = altId1No;
	}
	public String getAltId2Type() {
		return altId2Type;
	}
	public void setAltId2Type(String altId2Type) {
		this.altId2Type = altId2Type;
	}
	public String getAltId2No() {
		return altId2No;
	}
	public void setAltId2No(String altId2No) {
		this.altId2No = altId2No;
	}
	public String getAltId3Type() {
		return altId3Type;
	}
	public void setAltId3Type(String altId3Type) {
		this.altId3Type = altId3Type;
	}
	public String getAltId3No() {
		return altId3No;
	}
	public void setAltId3No(String altId3No) {
		this.altId3No = altId3No;
	}
	public String getAltId4Type() {
		return altId4Type;
	}
	public void setAltId4Type(String altId4Type) {
		this.altId4Type = altId4Type;
	}
	public String getAltId4No() {
		return altId4No;
	}
	public void setAltId4No(String altId4No) {
		this.altId4No = altId4No;
	}
	public String getOthAltIdType() {
		return othAltIdType;
	}
	public void setOthAltIdType(String othAltIdType) {
		this.othAltIdType = othAltIdType;
	}
	public String getOthAltIdNo() {
		return othAltIdNo;
	}
	public void setOthAltIdNo(String othAltIdNo) {
		this.othAltIdNo = othAltIdNo;
	}
}