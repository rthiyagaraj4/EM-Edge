/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  /*
----------------------------------------------------------------------------------------------
SNo			Version     TFS ID		CRF/SCF     			Developer Name
----------------------------------------------------------------------------------------------
1      		V210624     19511		MMS-DM-CRF-118.9        Nandhini M
----------------------------------------------------------------------------------------------
*/
package eBL.pkgpricerevision.request;

/**
 * This Bean is used for transporting the Price / Discount Revision along with Request Object
 * This Bean is used in Individual Update
 * @author Rajesh V
 *
 */
public class PackagePriceBean {

	private String pkgCode = "";
	private String pkgDesc = "";
	private String custGroupCode = "";
	private String custCode = "";
	private String blngClassCode = "";
	private String blngGroupCode = "";
	private String currentPriceType = "";
	private String currentPriceValue = "";
	private String revisedPriceType = "";
	private String revisedPriceValue = "";
	private String effectiveFrom = "";
	private String effectiveTo = "";
	private String status = "";
	//added against MMS-DM-CRF-118.9 starts
	private String PackagePrice = "";
	private String VAT = "";
	private String VatApplicable = "";
	private String VatRule = "";
	private String RuleCoverage = "";
	private String VatInd = "";
	//added against MMS-DM-CRF-118.9 ends
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPkgCode() {
		return pkgCode;
	}
	public void setPkgCode(String pkgCode) {
		this.pkgCode = pkgCode;
	}
	
	public String getPkgDesc() {
		return pkgDesc;
	}
	public void setPkgDesc(String pkgDesc) {
		this.pkgDesc = pkgDesc;
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
	public String getBlngClassCode() {
		return blngClassCode;
	}
	public void setBlngClassCode(String blngClassCode) {
		this.blngClassCode = blngClassCode;
	}
	public String getBlngGroupCode() {
		return blngGroupCode;
	}
	public void setBlngGroupCode(String blngGroupCode) {
		this.blngGroupCode = blngGroupCode;
	}
	public String getCurrentPriceType() {
		return currentPriceType;
	}
	public void setCurrentPriceType(String currentPriceType) {
		this.currentPriceType = currentPriceType;
	}
	public String getCurrentPriceValue() {
		return currentPriceValue;
	}
	public void setCurrentPriceValue(String currentPriceValue) {
		this.currentPriceValue = currentPriceValue;
	}
	public String getRevisedPriceType() {
		return revisedPriceType;
	}
	public void setRevisedPriceType(String revisedPriceType) {
		this.revisedPriceType = revisedPriceType;
	}
	public String getRevisedPriceValue() {
		return revisedPriceValue;
	}
	public void setRevisedPriceValue(String revisedPriceValue) {
		this.revisedPriceValue = revisedPriceValue;
	}
	public String getEffectiveFrom() {
		return effectiveFrom;
	}
	public void setEffectiveFrom(String effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	public String getEffectiveTo() {
		return effectiveTo;
	}
	public void setEffectiveTo(String effectiveTo) {
		this.effectiveTo = effectiveTo;
	}
	//added against MMS-DM-CRF-118.9 starts
	public String getPackagePrice() {
		return PackagePrice;
	}
	public void setPackagePrice(String PackagePrice) {
		this.PackagePrice = PackagePrice;
	}
	public String getVAT() {
		return VAT;
	}
	public void setVAT(String VAT) {
		this.VAT = VAT;
	}
	public String getVatApplicable() {
		return VatApplicable;
	}
	public void setVatApplicable(String VatApplicable) {
		this.VatApplicable = VatApplicable;
	}
	public String getVatRule() {
		return VatRule;
	}
	public void setVatRule(String VatRule) {
		this.VatRule = VatRule;
	}
	public String getRuleCoverage() {
		return RuleCoverage;
	}
	public void setRuleCoverage(String RuleCoverage) {
		this.RuleCoverage = RuleCoverage;
	}
	//added against MMS-DM-CRF-118.9 ends
	//Added against 21058 starts  
	public String getVatInd() {
		return VatInd;
	}
	public void setVatInd(String VatInd) {
		this.VatInd = VatInd;
	}
	//Added against 21058 ends
	
}
