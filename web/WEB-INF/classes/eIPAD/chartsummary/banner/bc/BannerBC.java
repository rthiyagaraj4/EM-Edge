/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 *  
 */
package eIPAD.chartsummary.banner.bc;

import eIPAD.chartsummary.banner.dao.BannerDAO;
import eIPAD.chartsummary.banner.daoimpl.BannerDAOImpl;
import eIPAD.chartsummary.banner.request.BannerRequest;
import eIPAD.chartsummary.banner.response.BannerResponse;

/**
 * @author SaraswathiR
 *
 */
public class BannerBC {
	
	public BannerResponse getBannerDetails(BannerRequest oBannerReq){
		
		BannerResponse oBannerResponse;
		BannerDAO oBannerDAO = new BannerDAOImpl();
		oBannerResponse = oBannerDAO.getBannerDetails(oBannerReq);
		
		return oBannerResponse;
	}

}
