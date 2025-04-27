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
package eIP.advbedmgmt.transaction.patientsearch.dao;

import eIP.advbedmgmt.transaction.patientsearch.request.PatientSearchRequest;
import eIP.advbedmgmt.transaction.patientsearch.response.PatientSearchResponse;

/**
 * This is the DAO layer interface for the patient search sub module This interface
 * provides a method which retrieves data from back end database based 
 * on the input request object
 * @author GRamamoorthy
 *
 */
public interface PatientSearchDAO {

	/**
	 * This method retrieves data from back end database based on the input
	 * request object The input object is not validated in this method - it is
	 * assumed that this object contains the required data
	 * 
	 * @param request
	 * @return
	 */
	public PatientSearchResponse getPatientNursingUnit(
			PatientSearchRequest request);
	
}
