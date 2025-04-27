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
package portalrefimpl.facility.facilityforpatient.svc;

import portalrefimpl.facility.facilityforpatient.request.FacilityListRequest;
import portalrefimpl.facility.facilityforpatient.response.FacilityListResponse;

/**
 * This is the service interface for facilities
 * As of now, there is only one service method defined in this interface
 * This service method will retrieve a list of facilities which a patient
 * can access
 * @author GRamamoorthy
 *
 */
public interface FacilityListSvc {

	/**
	 * This service method will retrieve a list of facilities which a patient
	 * can access
	 * @param facilityListRequest
	 * @return
	 */
	public FacilityListResponse getFacilityList(FacilityListRequest facilityListRequest);
	
}
