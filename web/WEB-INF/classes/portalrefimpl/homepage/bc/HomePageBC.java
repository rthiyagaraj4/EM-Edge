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
package portalrefimpl.homepage.bc;

import portalrefimpl.homepage.dac.HomePageDAC;
import portalrefimpl.homepage.request.HospitalDetailsRequest;
import portalrefimpl.homepage.request.PatientDetailsRequest;
import portalrefimpl.homepage.response.HospitalDetailsResponse;
import portalrefimpl.homepage.response.PatientDetailsResponse;



/**
 * This class is the business component class for home page
 * @author gramamoorthy
 *
 */
public class HomePageBC {

	/**
	 * This method returns the hospital details
	 * @param hospitalDetailsRequest
	 * @return
	 */
	public HospitalDetailsResponse getHospitalDetails(
			HospitalDetailsRequest hospitalDetailsRequest) {
		HomePageDAC dacInst = new HomePageDAC();
		return dacInst.getHospitalDetails(hospitalDetailsRequest);
	}
	
	/**
	 * This method returns the patient details
	 * @param patientDetailsRequest
	 * @return
	 */
	public PatientDetailsResponse getPatientDetails(
			PatientDetailsRequest patientDetailsRequest) {
		HomePageDAC dacInst = new HomePageDAC();
		return dacInst.getPatientDetails(patientDetailsRequest);
	}
	
}
