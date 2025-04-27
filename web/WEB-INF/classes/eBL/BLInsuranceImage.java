/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to  
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.*;
import java.sql.Blob;

public class BLInsuranceImage  implements Serializable
{
	String payerGroupCode;  
	String payerCode;
	String policyCode;
	String policyNo;
	String startDate;
	String endDate;
	String imageFilePath; 
	Integer dbSharePathFlag;
	boolean cancelFlag;
	boolean dbModFlag;
	byte  image[];
	boolean imageLoaded=false;
    String docType;
	String blngGrpCode;
	String docRemarks;
	String creditAuthDate;
	String creditAuthNo;
	String index;
	String mIndex;
	String clicked_button;
	String Rowid;
	//Blob blobdata;
	String contentType;
	String strModuleId;
	//Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
	int episodeId ;
	int visitId;
	int encounterId ;
	String episodeType = null;
	String facilityId = null;
	
	public int getepisodeId() {
		return episodeId;
	}

	public void setepisodeId(int episodeId) {
		this.episodeId = episodeId;
	}
	public int getvisitId() {
		return visitId;
	}

	public void setvisitId(int visitId) {
		this.visitId = visitId;
	}
	public int getencounterId() {
		return encounterId;
	}

	public void setencounterId(int encounterId) {
		this.encounterId = encounterId;
	}
	public String getepisodeType() {
		return episodeType;
	}

	public void setepisodeType(String episodeType) {
		this.episodeType = episodeType;
	}
	
	public String getfacilityId() {
		return facilityId;
	}

	public void setfacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	//Ended by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
	
	public String getClicked_button() {
		return clicked_button;
	}

	public void setClicked_button(String clicked_button) {
		this.clicked_button = clicked_button;
	}

	public String getmIndex() {
		return mIndex;
	}

	public void setmIndex(String mIndex) {
		this.mIndex = mIndex;
	}

	public String getCreditAuthNo() {
		return creditAuthNo;
	}

	public void setCreditAuthNo(String creditAuthNo) {
		this.creditAuthNo = creditAuthNo;
	}

	public String getCreditAuthDate() {
		return creditAuthDate;
	}

	public void setCreditAuthDate(String creditAuthDate) {
		this.creditAuthDate = creditAuthDate;
	}

	public String getDocRemarks() {
		return docRemarks;
	}

	public void setDocRemarks(String docRemarks) {
		this.docRemarks = docRemarks;
	}

	public Integer getDbSharePathFlag() {
		return dbSharePathFlag;
	}

	public void setDbSharePathFlag(Integer dbSharePathFlag) {
		this.dbSharePathFlag = dbSharePathFlag;
	}

	public void setImageFilePath(String imageFilePath)
	{
	this.imageFilePath  = imageFilePath;
	}
	
	public String 	getImageFilePath()
	{
	return 	imageFilePath;
	}
	
	public void setPayerGroupCode(String payerGroupCode)
	{
	this.payerGroupCode  = payerGroupCode;
	}

	public void setPayerCode(String payerCode)
	{
	this.payerCode  = payerCode;
	}

	public void setPolicyCode(String policyCode)
	{
	this.policyCode  = policyCode;
	}

	public void setPolicyNo(String policyNo)
	{
	this.policyNo  = policyNo;
	}

	public void setStartDate(String startDate)
	{
	this.startDate  = startDate;
	}
	public void setEndDate(String endDate)
	{
	 this.endDate  =endDate;
	}  
	public void setImage(byte image[] )
	{
	this.image =image;	
	imageLoaded = true;
	}
	public boolean getImageLoaded()
	{
		return imageLoaded;
	}

	public String getPayerGroupCode()
	{
	return payerGroupCode;
	}

	public String getPayerCode()
	{
	return  payerCode;
	}

	public String getPolicyCode()
	{
	return policyCode;
	}

	public String getPolicyNo()
	{
	return policyNo;
	}

	public String getStartDate()
	{
	return startDate;
	}
	public String getEndDate()
	{
	return endDate;
	}  
	
	public String getIndex()
	{

	  return  ""+payerGroupCode+payerCode+policyCode+policyNo+startDate+endDate;	
	}
	
	public String getIndex_cash()
	{

	  return  "^^^1110";	
	}

	public String getRowid() {
		return Rowid;
	}

	public void setRowid(String rowid) {
		Rowid = rowid;
	}

	public void setCancelMod(boolean cancelFlag)
	{
		this.cancelFlag = cancelFlag;

	}

  public boolean getCancelMod()
	{
	  return cancelFlag;
	}

	public void setDbMod(boolean dbModFlag)
	{
		this.dbModFlag = dbModFlag;

	}

  public boolean getDbMod()
	{
	  return dbModFlag;
	}

	public byte getImage()[] 
	{
	return image;	
	}
	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getBillingGroup() {
		return blngGrpCode;
	}
	public void setBillingGroup(String blngGrpCode) {
		this.blngGrpCode = blngGrpCode;
	}
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getStrModuleId() {
		return strModuleId;
	}

	public void setStrModuleId(String strModuleId) {
		this.strModuleId = strModuleId;
	}

	@Override
	public String toString() {
		return "BLInsuranceImage [payerGroupCode=" + payerGroupCode
				+ ", payerCode=" + payerCode + ", policyCode=" + policyCode
				+ ", policyNo=" + policyNo + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", imageFilePath=" + imageFilePath
				+ ", cancelFlag=" + cancelFlag + ", dbModFlag=" + dbModFlag
				+ ", imageLoaded=" + imageLoaded 
				+ ", clicked_button=" + clicked_button +"]";
	}	
}
