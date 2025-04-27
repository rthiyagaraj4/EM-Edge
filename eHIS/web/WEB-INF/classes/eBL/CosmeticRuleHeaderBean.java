/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.Serializable;
import java.util.List;

import eBL.Common.BlAdapter;

public class CosmeticRuleHeaderBean extends BlAdapter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int seqNo = 0;
	private String blngGroupCode = "";
	private String patientClass = "";
	private String custGroupCode = "";
	private String custCode = "";
	private String policyTypeCode = "";
	private String ruleCode = "";
	private String status = "";
	private String blngGroupDesc = "";
	private String custGroupDesc = "";
	private String custDesc = "";
	private String policyTypeDesc = "";
	private String ruleDesc = "";
	private String startDate = "";
	private String endDate = "";

	private List<CosmeticRuleDetailBean> criteriaList = null;
	private List<CosmeticRuleDetailBean> exclList = null;
	
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	public String getBlngGroupCode() {
		return blngGroupCode;
	}
	public void setBlngGroupCode(String blngGroupCode) {
		this.blngGroupCode = blngGroupCode;
	}
	public String getPatientClass() {
		return patientClass;
	}
	public void setPatientClass(String patientClass) {
		this.patientClass = patientClass;
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
	public String getPolicyTypeCode() {
		return policyTypeCode;
	}
	public void setPolicyTypeCode(String policyTypeCode) {
		this.policyTypeCode = policyTypeCode;
	}
	public String getRuleCode() {
		return ruleCode;
	}
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBlngGroupDesc() {
		return blngGroupDesc;
	}
	public void setBlngGroupDesc(String blngGroupDesc) {
		this.blngGroupDesc = blngGroupDesc;
	}
	public String getCustGroupDesc() {
		return custGroupDesc;
	}
	public void setCustGroupDesc(String custGroupDesc) {
		this.custGroupDesc = custGroupDesc;
	}
	public String getCustDesc() {
		return custDesc;
	}
	public void setCustDesc(String custDesc) {
		this.custDesc = custDesc;
	}
	public String getPolicyTypeDesc() {
		return policyTypeDesc;
	}
	public void setPolicyTypeDesc(String policyTypeDesc) {
		this.policyTypeDesc = policyTypeDesc;
	}
	public String getRuleDesc() {
		return ruleDesc;
	}
	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}
	public List<CosmeticRuleDetailBean> getCriteriaList() {
		return criteriaList;
	}
	public void setCriteriaList(List<CosmeticRuleDetailBean> criteriaList) {
		this.criteriaList = criteriaList;
	}
	public List<CosmeticRuleDetailBean> getExclList() {
		return exclList;
	}
	public void setExclList(List<CosmeticRuleDetailBean> exclList) {
		this.exclList = exclList;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}		
	
	
	public void clearAll(){
		seqNo = 0;
		blngGroupCode = "";
		patientClass = "";
		custGroupCode = "";
		custCode = "";
		policyTypeCode = "";
		ruleCode = "";
		status = "";
		blngGroupDesc = "";
		custGroupDesc = "";
		custDesc = "";
		policyTypeDesc = "";
		ruleDesc = "";
		startDate = "";
		endDate = "";

		criteriaList = null;
		exclList = null;
	}
}
