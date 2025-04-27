/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.pkgpricerevision.bc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import eBL.pkgpricerevision.dao.PkgPriceDiscountDAO;
import eBL.pkgpricerevision.dao.PkgPriceDiscountDAOImpl;
import eBL.pkgpricerevision.request.BulkUpdateBean;
import eBL.pkgpricerevision.request.PackagePriceBean;
import eBL.pkgpricerevision.request.PkgPriceRevisionRequest;
import eBL.pkgpricerevision.response.PkgPriceRevisionResponse;

/**
 * This file acts as the Business Layer for the function Package price Discount Revision
 * @author Rajesh V
 *
 */
public class PkgPriceDisountBC {
	
	PkgPriceDiscountDAO priceDiscountDAO = null;
	
	public PkgPriceRevisionResponse priceDiscountRevision(PkgPriceRevisionRequest priceRevisionRequest){
		PkgPriceRevisionResponse priceRevisionResponse = new PkgPriceRevisionResponse();
		priceDiscountDAO = new PkgPriceDiscountDAOImpl();
		if("S".equals(priceRevisionRequest.getPriceType())){
			if("Price".equalsIgnoreCase(priceRevisionRequest.getRevisionType())){
				priceRevisionResponse = priceDiscountDAO.basePriceRevision(priceRevisionRequest);
			}
			else if("Discount".equalsIgnoreCase(priceRevisionRequest.getRevisionType())){
				priceRevisionResponse = priceDiscountDAO.baseDiscountRevision(priceRevisionRequest);
			}
		}
		else if("C".equals(priceRevisionRequest.getPriceType())){
			if("Price".equalsIgnoreCase(priceRevisionRequest.getRevisionType())){
				priceRevisionResponse = priceDiscountDAO.custPriceRevision(priceRevisionRequest);
			}
			else if("Discount".equalsIgnoreCase(priceRevisionRequest.getRevisionType())){
				priceRevisionResponse = priceDiscountDAO.custDiscountRevision(priceRevisionRequest);
			}
		}
		
		if(priceRevisionRequest.getStartFrom()>1){
			priceRevisionResponse.setPrevYN("Y");
			priceRevisionResponse.setTraversal("Y");
		}
		
		if((priceRevisionRequest.getStartFrom() +priceRevisionRequest.getConstCount()) < priceRevisionResponse.getTotalCount()){
			priceRevisionResponse.setNextYN("Y");
			priceRevisionResponse.setTraversal("Y");
		}	
		return priceRevisionResponse;
	}

	
	public PkgPriceRevisionResponse insertPkgUpdateRequest(PkgPriceRevisionRequest priceRevisionRequest){		
		PkgPriceRevisionResponse pkgResponse = null;
		try{
			priceDiscountDAO =  new PkgPriceDiscountDAOImpl();
			HashMap<String,String> sessionIdMap = priceDiscountDAO.generateSessionId();
			priceRevisionRequest.setSessionId(sessionIdMap.get("session_id"));
			priceRevisionRequest.setPgmDate(sessionIdMap.get("pgm_date"));
			pkgResponse = new PkgPriceRevisionResponse();
			if("Y".equals(priceRevisionRequest.getBulkUpdateYn())){						
				priceDiscountDAO = new PkgPriceDiscountDAOImpl();
				pkgResponse = priceDiscountDAO.insertPkgDiscountBulk(priceRevisionRequest);
			}
			else{			
				priceDiscountDAO = new PkgPriceDiscountDAOImpl();
				pkgResponse = priceDiscountDAO.insertPkgDiscountInd(priceRevisionRequest);
			}
			pkgResponse.setSessionId(sessionIdMap.get("session_id"));
			pkgResponse.setPgmDate(sessionIdMap.get("pgm_date"));
		}
		catch(Exception e){
			System.err.println("Exception in insertPkgUpdateRequest ->"+e);
			pkgResponse.setStatus(false);
		}
		return pkgResponse;
	}
	
	public PkgPriceRevisionResponse populatePkgUpdateRequest(PkgPriceRevisionRequest priceRevisionRequest){
		PkgPriceRevisionResponse pkgResponse = new PkgPriceRevisionResponse();
		priceDiscountDAO = new PkgPriceDiscountDAOImpl();
		pkgResponse = priceDiscountDAO.populatePkgUpdateRequest(priceRevisionRequest);
		return pkgResponse;
	}
	
	public PkgPriceRevisionResponse getOverlapRecords(PkgPriceRevisionRequest priceRevisionRequest){
		PkgPriceRevisionResponse pkgResponse = new PkgPriceRevisionResponse();
		priceDiscountDAO = new PkgPriceDiscountDAOImpl();
		pkgResponse = priceDiscountDAO.getOverlapRecords(priceRevisionRequest);
		return pkgResponse;
	}
	
	public String checkBulkUpdateAccess(String userId, String facilityId){
		priceDiscountDAO = new PkgPriceDiscountDAOImpl();
		return priceDiscountDAO.checkBulkUpdateAccess(userId, facilityId);
	}
	
	public String getPkgBackDate(String facilityId) {
		priceDiscountDAO = new PkgPriceDiscountDAOImpl();
		return priceDiscountDAO.getPkgBackDate(facilityId);
	}
	public String getPkgEffectiveDates(String pkgCode,String facilityId){
		priceDiscountDAO = new PkgPriceDiscountDAOImpl();
		return priceDiscountDAO.getPkgEffectiveDates(pkgCode, facilityId);
	}
	public String getJobNumber(String sessionId, String pgmDate){
		priceDiscountDAO = new PkgPriceDiscountDAOImpl();
		return priceDiscountDAO.getJobNumber(sessionId, pgmDate);
	}
	public int getNoOfDecimal(){
		priceDiscountDAO = new PkgPriceDiscountDAOImpl();
		return priceDiscountDAO.getNoOfDecimal();
	}
}
