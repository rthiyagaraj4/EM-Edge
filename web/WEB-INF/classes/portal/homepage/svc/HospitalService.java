/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.homepage.svc;

import portal.homepage.request.HospitalRequest;
import portal.homepage.response.HospitalDetailsResponse;

/**
 * This class defines all the abstract methods used in Hospital Service
 * This method takes as input HospitalRequest object
 * and returns HospitalDetailsResponse object
 * 
 * @author skrishnared2
 *
 */
public interface HospitalService{

	/**
	 * This method retrieves the details of the Hospital.
	 * This method takes as input HospitalRequest object
	 * and returns HospitalResponse object
	 * @param request
	 * @return
	 */
	public HospitalDetailsResponse getHospitalDetails(HospitalRequest request);
		
}
