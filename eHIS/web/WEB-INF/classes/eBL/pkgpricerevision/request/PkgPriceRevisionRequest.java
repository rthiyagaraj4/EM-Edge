/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.pkgpricerevision.request;

import java.io.Serializable;
import java.util.List;

/**
 * This is used as Request Object in Price Discount Revision
 * @author Rajesh V
 *
 */
public class PkgPriceRevisionRequest implements Serializable
{
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;-->commented against checkstyle
	private String priceType = "";
	private String updateType = "";
	private String revisionType = "";
	private String blngGroupCode = "";
	private String blngClassCode = "";
	private String custGroupCode = "";
	private String custCode = "";
	private String pkgCode = "";
	private String facilityId = "";
	private int startFrom = 0;
	private int endWith = 0;
	private int constCount = 0;
	
	private String locale = "";
	private String priceBulkUpdateFlag = "";

	private String discountBulkUpdateFlag = "";
	private String sessionId = "";
	private String pgmDate = "";
	private String userId = "";
	private String bulkUpdateYn = "";
	//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 start
	private String policyCode = "";

	public String getPolicyCode() {
		return policyCode;
	}
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}
	//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 end
	//MMS-DM-CRF-118.9 starts
	private String PackagePrice = "";

	public String getPackagePrice() {
		return PackagePrice;
	}
	public void setPackagePrice(String PackagePrice) {
		this.PackagePrice = PackagePrice;
	}
	private String VAT = "";

	public String getVAT() {
		return VAT;
	}
	public void setVAT(String VAT) {
		this.VAT = VAT;
	}
	private String VatApplicable = "";

	public String getVatApplicable() {
		return VatApplicable;
	}
	public void setVatApplicable(String VatApplicable) {
		this.VatApplicable = VatApplicable;
	}
	private String VatRule = "";

	public String getVatRule() {
		return VatRule;
	}
	public void setVatRule(String VatRule) {
		this.VatRule = VatRule;
	}
	private String RuleCoverage = "";

	public String getRuleCoverage() {
		return RuleCoverage;
	}
	public void setRuleCoverage(String RuleCoverage) {
		this.RuleCoverage = RuleCoverage;
	}
	//MMS-DM-CRF-118.9 ends
	public String getBulkUpdateYn() {
		return bulkUpdateYn;
	}
	public void setBulkUpdateYn(String bulkUpdateYn) {
		this.bulkUpdateYn = bulkUpdateYn;
	}

	private List<BulkUpdateBean> bulkUpdatePrice = null;
	private List<BulkUpdateBean> bulkUpdateDiscount = null;
	private List<PackagePriceBean> priceRevision = null;
	private List<PackagePriceBean> discountRevision = null;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getPgmDate() {
		return pgmDate;
	}
	public void setPgmDate(String pgmDate) {
		this.pgmDate = pgmDate;
	}

	
	public String getPriceBulkUpdateFlag() {
		return priceBulkUpdateFlag;
	}
	public void setPriceBulkUpdateFlag(String priceBulkUpdateFlag) {
		this.priceBulkUpdateFlag = priceBulkUpdateFlag;
	}
	public String getDiscountBulkUpdateFlag() {
		return discountBulkUpdateFlag;
	}
	public void setDiscountBulkUpdateFlag(String discountBulkUpdateFlag) {
		this.discountBulkUpdateFlag = discountBulkUpdateFlag;
	}

	
	

	public int getConstCount() {
		return constCount;
	}
	public void setConstCount(int constCount) {
		this.constCount = constCount;
	}
	public int getStartFrom() {
		return startFrom;
	}
	public void setStartFrom(int startFrom) {
		this.startFrom = startFrom;
	}
	public int getEndWith() {
		return endWith;
	}
	public void setEndWith(int endWith) {
		this.endWith = endWith;
	}
	public String getRevisionType() {
		return revisionType;
	}
	public void setRevisionType(String revisionType) {
		this.revisionType = revisionType;
	}
	public String getPriceType() {
		return priceType;
	}
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}
	public String getUpdateType() {
		return updateType;
	}
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}
	public String getBlngGroupCode() {
		return blngGroupCode;
	}
	public void setBlngGroupCode(String blngGroupCode) {
		this.blngGroupCode = blngGroupCode;
	}
	public String getBlngClassCode() {
		return blngClassCode;
	}
	public void setBlngClassCode(String blngClassCode) {
		this.blngClassCode = blngClassCode;
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
	public String getPkgCode() {
		return pkgCode;
	}
	public void setPkgCode(String pkgCode) {
		this.pkgCode = pkgCode;
	}
	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public List<BulkUpdateBean> getBulkUpdatePrice() {
		return bulkUpdatePrice;
	}
	public void setBulkUpdatePrice(List<BulkUpdateBean> bulkUpdatePrice) {
		this.bulkUpdatePrice = bulkUpdatePrice;
	}
	public List<BulkUpdateBean> getBulkUpdateDiscount() {
		return bulkUpdateDiscount;
	}
	public void setBulkUpdateDiscount(List<BulkUpdateBean> bulkUpdateDiscount) {
		this.bulkUpdateDiscount = bulkUpdateDiscount;
	}
	public List<PackagePriceBean> getPriceRevision() {
		return priceRevision;
	}
	public void setPriceRevision(List<PackagePriceBean> priceRevision) {
		this.priceRevision = priceRevision;
	}
	public List<PackagePriceBean> getDiscountRevision() {
		return discountRevision;
	}
	public void setDiscountRevision(List<PackagePriceBean> discountRevision) {
		this.discountRevision = discountRevision;
	}
	
	public void clearAll(){
		priceType = "";
		updateType = "";
		revisionType = "";
		blngGroupCode = "";
		blngClassCode = "";
		custGroupCode = "";
		custCode = "";
		pkgCode = "";
		facilityId = "";
		startFrom = 0;
		endWith = 0;
		constCount = 0;
		
		locale = "";
		userId = "";
		priceBulkUpdateFlag = "";
		discountBulkUpdateFlag = "";
		sessionId = "";
		pgmDate = "";
		bulkUpdatePrice = null;
		bulkUpdateDiscount = null;
		priceRevision = null;
		discountRevision = null;
		policyCode = ""; //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
		PackagePrice = ""; //MMS-DM-CRF-118.9 starts
		VAT = "";
		VatApplicable ="";
		VatRule = "";
		RuleCoverage = ""; //MMS-DM-CRF-118.9 ends.
	}
	
}
