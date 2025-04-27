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
package portalrefimpl.homepage.svc;


import portalrefimpl.homepage.request.HospitalDetailsRequest;
import portalrefimpl.homepage.request.PatientDetailsRequest;
import portalrefimpl.homepage.response.HospitalDetailsResponse;
import portalrefimpl.homepage.response.PatientDetailsResponse;


/**
 * @author gramamoorthy
 *
 */
public interface HomePageSvc {

	/**
	 * 
	 * @param patientDetailsRequest
	 * @return
	 */
	public PatientDetailsResponse getPatientDetails(PatientDetailsRequest patientDetailsRequest);
	
	/**
	 * 
	 * @param hospitalDetailsRequest
	 * @return
	 */
	public HospitalDetailsResponse getHospitalDetails(HospitalDetailsRequest hospitalDetailsRequest);
	
}
