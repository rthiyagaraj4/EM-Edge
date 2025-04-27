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
package portalrefimpl.facility.facilityforcontact.bc;

import portalrefimpl.facility.facilityforcontact.dac.FacilityForContactDAC;
import portalrefimpl.facility.facilityforcontact.request.FacilityForContactRequest;
import portalrefimpl.facility.facilityforcontact.response.FacilityForContactResponse;

/**
 * This is the BC layer class for facility for contact service
 * @author GRamamoorthy
 *
 */
public class FacilityForContactBC {

	/**
	 * This method gets the facilities with their details for the service
	 * This method in turn calls the DAC class to get the data
	 * @param request
	 * @return
	 */
	public FacilityForContactResponse getFacilitiesForContact(FacilityForContactRequest request){
		FacilityForContactDAC dacInst = new FacilityForContactDAC();
		return dacInst.getFacilitiesForContact(request);
	}
	
}
