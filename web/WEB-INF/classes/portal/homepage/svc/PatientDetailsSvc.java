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
import portal.common.svc.BaseService;
import portal.homepage.response.PatientDetailsResponse;
/**
 * This class defines all the abstract methods used in Patient Details Service
 * This method takes as input BaseRequest object
 * and returns PatientDetailsResponse object
 * 
 * @author vkodancha
 *
 */
public interface PatientDetailsSvc  extends BaseService{

	/**
	 * 
	 * @param request
	 * @return
	 */
	public PatientDetailsResponse getPatientDetails(BaseRequest request);
}
