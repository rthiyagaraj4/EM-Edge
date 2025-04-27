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
package portalrefimpl.facility.facilityforpatient.bc;

import portalrefimpl.facility.facilityforpatient.dac.FacilityListDAC;
import portalrefimpl.facility.facilityforpatient.request.FacilityListRequest;
import portalrefimpl.facility.facilityforpatient.response.FacilityListResponse;

/**
 * This is the business component class for getting the list of facilities
 * needed for a patient
 * This class in turn calls the DAC class for getting the list of facilities
 * @author GRamamoorthy
 *
 */
public class FacilityListBC {

	/**
	 * 
	 * @param facilityListRequest
	 * @return
	 */
	public FacilityListResponse getFacilityList(FacilityListRequest facilityListRequest){
		FacilityListDAC dacInst = new FacilityListDAC();
		return dacInst.getFacilityList(facilityListRequest);
	}
	
}
