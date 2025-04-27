/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.pkgpricerevision.dao;


import java.util.HashMap;

import eBL.pkgpricerevision.request.PkgPriceRevisionRequest;
import eBL.pkgpricerevision.response.PkgPriceRevisionResponse;
/**
 * This file acts as the DAO Layer Interface for the function Package price Discount Revision
 * This Interface is implemented by PkgpriceDiscountDAOImpl
 * @author Rajesh V
 *
 */
public interface PkgPriceDiscountDAO {
	public PkgPriceRevisionResponse basePriceRevision(PkgPriceRevisionRequest priceRevisionRequest);
	
	public PkgPriceRevisionResponse custPriceRevision(PkgPriceRevisionRequest priceRevisionRequest);
	
	public PkgPriceRevisionResponse baseDiscountRevision(PkgPriceRevisionRequest priceRevisionRequest);
	
	public PkgPriceRevisionResponse custDiscountRevision(PkgPriceRevisionRequest priceRevisionRequest);
	
	public PkgPriceRevisionResponse insertPkgDiscountInd(PkgPriceRevisionRequest priceRevisionRequest);
	
	public PkgPriceRevisionResponse insertPkgDiscountBulk(PkgPriceRevisionRequest priceRevisionRequest);
	
	public HashMap<String,String> generateSessionId();
	
	public PkgPriceRevisionResponse populatePkgUpdateRequest(PkgPriceRevisionRequest priceRevisionRequest);
	
	public PkgPriceRevisionResponse getOverlapRecords(PkgPriceRevisionRequest priceRevisionRequest);
	
	public String checkBulkUpdateAccess(String userId, String facilityId);
	
	public String getPkgBackDate(String facilityId);
	
	public String getPkgEffectiveDates(String pkgCode,String facilityId);
	
	public String getJobNumber(String sessionId, String pgmDate);

	public int getNoOfDecimal();
}
