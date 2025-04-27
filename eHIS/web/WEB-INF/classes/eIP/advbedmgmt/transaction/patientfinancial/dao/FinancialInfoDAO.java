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
package eIP.advbedmgmt.transaction.patientfinancial.dao;

import eIP.advbedmgmt.transaction.patientfinancial.request.FinancialInfoRequest;
import eIP.advbedmgmt.transaction.patientfinancial.response.FinancialInfoResponse;

/**
 * This is the DAO interface for getting meta data needed for obtaining
 * patient financial information
 * @author GRamamoorthy
 *
 */
public interface FinancialInfoDAO {

	/**
	 * This method gets meta data needed for obtaining
	 * patient financial information
	 * @param request
	 * @return
	 */
	public FinancialInfoResponse getPatientFinancialInfo(FinancialInfoRequest request);	

}
