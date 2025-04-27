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
 * This Bean is used in Bulk Update
 * @author Rajesh V
 *
 */
public class BulkUpdateBean {
	
	private String pkgPriceDiscType = "";
	private String pkgPriceDiscValue = "";
	private String markUpDown = "";
	private String roundOff = "";
	private String effectiveFrom = "";
	private String effectiveTo = "";
	private String rndMarkUpDown = "";
	//added against MMS-DM-CRF-118.9 starts
	private String PackagePrice = "";
	private String VAT = "";
	private String VatApplicable = "";
	private String VatRule = "";
	private String RuleCoverage = "";
	//added against MMS-DM-CRF-118.9 ends
	
	public String getRndMarkUpDown() {
		return rndMarkUpDown;
	}
	public void setRndMarkUpDown(String rndMarkUpDown) {
		this.rndMarkUpDown = rndMarkUpDown;
	}
	public String getPkgPriceDiscType() {
		return pkgPriceDiscType;
	}
	public void setPkgPriceDiscType(String pkgPriceDiscType) {
		this.pkgPriceDiscType = pkgPriceDiscType;
	}
	public String getPkgPriceDiscValue() {
		return pkgPriceDiscValue;
	}
	public void setPkgPriceDiscValue(String pkgPriceDiscValue) {
		this.pkgPriceDiscValue = pkgPriceDiscValue;
	}
	public String getMarkUpDown() {
		return markUpDown;
	}
	public void setMarkUpDown(String markUpDown) {
		this.markUpDown = markUpDown;
	}
	public String getRoundOff() {
		return roundOff;
	}
	public void setRoundOff(String roundOff) {
		this.roundOff = roundOff;
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
	
}
