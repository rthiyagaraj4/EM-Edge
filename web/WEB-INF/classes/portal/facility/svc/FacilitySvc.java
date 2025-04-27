/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.facility.svc;

import portal.facility.request.FacilityRequest;
import portal.facility.response.FacilityResponse;

/**
 * This class defines all the abstract methods used in Facility Service
 * @author vkodancha
 *
 */
public interface FacilitySvc {
	
	/**
	 * This method retrieves the list of Facilities for patient portal.
	 * This method takes as input Facility Request object
	 * and returns Facility Response object
	 * @param request
	 * @return
	 */
	public FacilityResponse getFacilities(FacilityRequest request);

}
