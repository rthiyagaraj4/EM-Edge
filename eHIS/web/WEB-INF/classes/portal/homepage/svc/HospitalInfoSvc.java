/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.homepage.svc;

import portal.common.request.BaseRequest;
import portal.homepage.response.HospitalInfoResponse;


/**
 * This class defines all the abstract methods used in Hospital Service
 * This method takes as input HospitalRequest object
 * and returns HospitalInfoResponse object
 * 
 * @author skrishnared2
 *
 */
public interface HospitalInfoSvc{

	/**
	 * This method retrieves the details of the Hospital.
	 * This method takes as input BaseRequest object
	 * and returns HospitalInfoResponse object
	 * @param request
	 * @return
	 */
	public HospitalInfoResponse getHospitalInformation(BaseRequest request);
		
}
