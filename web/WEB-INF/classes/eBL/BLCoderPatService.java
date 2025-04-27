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
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eBL.Common.*;

@SuppressWarnings({"rawtypes","unchecked"})
public class BLCoderPatService extends BlAdapter implements Serializable {	
	String sessionId;
	String operatingFacilityId;
	String billDocTypeCode = "";
	String billDocNum =  "";
	String custGroupCode = "";
	String custCode = "";
	String trxDocRef =  "";
	String trxDocRefLineNum = "";
	String trxDocRefSeqNum = "";
	String trxDate =  "";
	String episodeType ;
	String patientId ;
	String episodeId;
	String visitId ;
	String encounterId;
	String settlementInd;
	String servTypeInd =  "";
	String servTypeDesc =  "";
	String cptCode=  "";
	String servItemCode=  "";
	String servItemDesc= "";
	String servQty= "";
	String serviceDate= "";
	String performPhysicianId="";
	String performPhysicianName="";
	String orderPhysicianName="";
	String physicianId= "";
	String serviceAmount= "";
	String patientAmount= "";
	String insuranceAmount= "";
	String patientpay="";//V230222-AAKH-CRF-0172
	String modifierAdjusterId;
	String zeroPriceYN = "N";
	String CdrapprovalNo = "";
	String CdrapprovalDate = "";
	String cdrApprovalNoModifyYN = "N";
	String ModifyYN = "N";
	String approvalNo="";
	String billableYN = "N";
	String billYN = "N";
	String addRowYN = "N";
	String cancelRowYN = "N";
	String index ="";
	String logInID="";
	String logInWSNo="";
	String preAppFlag="";
	String primaryKeyModID="";
	
	public String getprimaryKeyModID() {
		return primaryKeyModID;
	}

	public void setprimaryKeyModID(String primaryKeyModID) {
		this.primaryKeyModID = primaryKeyModID;
	}
	
	public String getPreAppFlag() {
		return preAppFlag;
	}

	public void setPreAppFlag(String preAppFlag) {
		this.preAppFlag = preAppFlag;
	}
	
	public String getlogInID() {
		return logInID;
	}

	public void setlogInID(String logInID) {
		this.logInID = logInID;
	}
	
	public String getlogInWSNo() {
		return logInWSNo;
	}

	public void setlogInWSNo(String logInWSNo) {
		this.logInWSNo = logInWSNo;
	}
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getOperatingFacilityId() {
		return operatingFacilityId;
	}

	public void setOperatingFacilityId(String operatingFacilityId) {
		this.operatingFacilityId = operatingFacilityId;
	}

	public String getBillDocTypeCode() {
		return billDocTypeCode;
	}

	public void setBillDocTypeCode(String billDocTypeCode) {
		this.billDocTypeCode = billDocTypeCode;
	}

	public String getBillDocNum() {
		return billDocNum;
	}

	public void setBillDocNum(String billDocNum) {
		this.billDocNum = billDocNum;
	}

	public String getCustGroupCode() {
		return custGroupCode;
	}

	public void setCustGroupCode(String custGroupCode) {
		this.custGroupCode = custGroupCode;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getTrxDocRef() {
		return trxDocRef;
	}

	public void setTrxDocRef(String trxDocRef) {
		this.trxDocRef = trxDocRef;
	}

	public String getTrxDocRefLineNum() {
		return trxDocRefLineNum;
	}

	public void setTrxDocRefLineNum(String trxDocRefLineNum) {
		this.trxDocRefLineNum = trxDocRefLineNum;
	}

	public String getTrxDocRefSeqNum() {
		return trxDocRefSeqNum;
	}

	public void setTrxDocRefSeqNum(String trxDocRefSeqNum) {
		this.trxDocRefSeqNum = trxDocRefSeqNum;
	}

	public String getTrxDate() {
		return trxDate;
	}

	public void setTrxDate(String trxDate) {
		this.trxDate = trxDate;
	}

	public String getEpisodeType() {
		return episodeType;
	}

	public void setEpisodeType(String episodeType) {
		this.episodeType = episodeType;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(String episodeId) {
		this.episodeId = episodeId;
	}

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public String getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}

	public String getSettlementInd() {
		return settlementInd;
	}

	public void setSettlementInd(String settlementInd) {
		this.settlementInd = settlementInd;
	}

	public String getServTypeDesc() {
		return servTypeDesc;
	}

	public void setServTypeDesc(String servTypeDesc) {
		this.servTypeDesc = servTypeDesc;
	}

	public String getcptCode() {
		return cptCode;
	}

	public void setcptCode(String cptCode) {
		this.cptCode = cptCode;
	}

	public String getServItemCode() {
		return servItemCode;
	}

	public void setServItemCode(String servItemCode) {
		this.servItemCode = servItemCode;
	}

	public String getServItemDesc() {
		return servItemDesc;
	}

	public void setServItemDesc(String servItemDesc) {
		this.servItemDesc = servItemDesc;
	}

	public String getServQty() {
		return servQty;
	}

	public void setServQty(String servQty) {
		this.servQty = servQty;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}
	
	public String getOrderingPhysicianName() {
		return orderPhysicianName;
	}

	public void setOrderingPhysicianName(String orderPhysicianName) {
		this.orderPhysicianName = orderPhysicianName;
	}

	public String getPerformPhysicianName() {
		return performPhysicianName;
	}

	public void setPerformPhysicianName(String performPhysicianName) {
		this.performPhysicianName = performPhysicianName;
	}
	
	public String getPerformPhysicianId() {
		return performPhysicianId;
	}

	public void setPerformPhysicianId(String performPhysicianId) {
		this.performPhysicianId = performPhysicianId;
	}
	
	public String getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(String physicianId) {
		this.physicianId = physicianId;
	}

	public String getServiceAmount() {
		return serviceAmount;
	}

	public void setServiceAmount(String serviceAmount) {
		this.serviceAmount = serviceAmount;
	}

	public String getPatientAmount() {
		return patientAmount;
	}

	public void setPatientAmount(String patientAmount) {
		this.patientAmount = patientAmount;
	}

	public String getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(String insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}
//V230222
	public String getPatientPayable() {
		return patientpay;
	}

	public void setPatientPayable(String patientpay) {
		this.patientpay = patientpay;
	}


	public String getModifierAdjusterId() {
		return modifierAdjusterId;
	}

	public void setModifierAdjusterId(String modifierAdjusterId) {
		this.modifierAdjusterId = modifierAdjusterId;
	}

	public String getZeroPriceYN() {
		return zeroPriceYN;
	}

	public void setZeroPriceYN(String zeroPriceYN) {
		this.zeroPriceYN = zeroPriceYN;
	}

	public String getApprovalNo() {
		return approvalNo;
	}

	public void setApprovalNo(String approvalNo) {
		this.approvalNo = approvalNo;
	}
	
	public String getCDRApprovalNo() {
		return CdrapprovalNo;
	}

	public void setCDRApprovalNo(String CdrapprovalNo) {
		this.CdrapprovalNo = CdrapprovalNo;
	}
	
	public String getCDRApprovalDate() {
		return CdrapprovalDate;
	}

	public void setCDRApprovalDate(String CdrapprovalDate) {
		this.CdrapprovalDate = CdrapprovalDate;
	}
	
	
	public String getCdrApprovalNoModifyYN() {
		return cdrApprovalNoModifyYN;
	}

	public void setCdrApprovalNoModifyYN(String cdrApprovalNoModifyYN) {
		this.cdrApprovalNoModifyYN = cdrApprovalNoModifyYN;
	}
	
	public String getModifyYN() {
		return ModifyYN;
	}

	public void setModifyYN(String ModifyYN) {
		this.ModifyYN = ModifyYN;
	}
	
	public String getBillYN() {
		return billYN;
	}

	public void setBillYN(String billYN) {
		this.billYN = billYN;
	}
	
	public String getBillableYN() {
		return billableYN;
	}

	public void setBillableYN(String billableYN) {
		this.billableYN = billableYN;
	}

	public String getAddRowYN() {
		return addRowYN;
	}

	public void setAddRowYN(String addRowYN) {
		this.addRowYN = addRowYN;
	}

	public String getCancelRowYN() {
		return cancelRowYN;
	}

	public void setCancelRowYN(String cancelRowYN) {
		this.cancelRowYN = cancelRowYN;
	}	
	
	public String getIndex() {
		return  ""+operatingFacilityId+trxDocRef+trxDocRefLineNum+trxDocRefSeqNum;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getServTypeInd() {
		return servTypeInd;
	}
	
	public void setServTypeInd(String servTypeInd) {
		this.servTypeInd = servTypeInd;
	}

	public BLCoderPatService()
	{	
		System.out.println("BLCoderPatService Initialized");
	}

	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		return map;
	}	
	
	public void clearBean()
	{
		sessionId ="";
		operatingFacilityId ="";
		billDocTypeCode = "";
		billDocNum = "";
		custGroupCode = "";
		custCode = "";
		trxDocRef = "";
		trxDocRefLineNum = "";
		trxDocRefSeqNum = "";
		trxDate = "";
		episodeType ="";
		patientId ="" ;
		episodeId ="";
		visitId ="";
		encounterId ="";
		settlementInd ="";
		servTypeInd = "";
		servTypeDesc = "";
		servItemCode= "";
		cptCode="";
		servItemDesc= "";
		servQty ="";
		serviceDate ="";
		physicianId ="";
		performPhysicianId="";
		performPhysicianName="";
		orderPhysicianName="";
		serviceAmount ="";
		patientAmount ="";
		 insuranceAmount ="";
		 patientpay="";//V230222
		modifierAdjusterId ="";
		zeroPriceYN = "N";
		CdrapprovalDate="";
		CdrapprovalNo="";
		approvalNo = "";
		billYN = "N";
		billableYN = "N";
		addRowYN = "N";
		cancelRowYN = "N";
		index= "";
		cdrApprovalNoModifyYN = "N";
		ModifyYN = "N";
		logInID="";
		logInWSNo="";
		preAppFlag="";
		primaryKeyModID="";
	}	
}