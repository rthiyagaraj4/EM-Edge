/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.homepage.bc;

import org.apache.log4j.Logger;

import portal.common.request.BaseRequest;
import portal.homepage.dac.PatientDetailsDAC;
import portal.homepage.response.PatientDetailsResponse;

/**
 * This method is used to call the DAC layer to
 * get the patient details
 * @author vkodancha
 *
 */
public class PatientDetailsBC {
	
	private static Logger logger = Logger.getLogger(PatientDetailsBC.class.getName());
	PatientDetailsDAC patientInst;
	PatientDetailsResponse response;
	
	/**
	 * @param patientDetailsResponse the patientDetailsResponse to set
	 */
	public void setResponse(
			PatientDetailsResponse response) {
		this.response = response;
	}

	/**
	 * @param patientInst the patientInst to set
	 */
	public void setPatientInst(PatientDetailsDAC patientInst) {
		this.patientInst = patientInst;
	}

	/**
	 * This method calls the Patient Details DAC with Patient Request
	 * @param request
	 * @return
	 */
	public PatientDetailsResponse getPatientDetails(BaseRequest request){
		logger.debug("Entering the method : getPatientDetails with request :"+request.toString());
		// initialize the DAC class and get the data from it
		response = patientInst.getPatientDetails(request);
		logger.debug("Leaving the method : getPatientDetails with response :"+response.toString());		
		return response;
	}
}
