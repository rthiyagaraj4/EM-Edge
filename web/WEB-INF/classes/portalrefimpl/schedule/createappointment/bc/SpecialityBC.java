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
package portalrefimpl.schedule.createappointment.bc;

import portalrefimpl.schedule.createappointment.dac.SpecialityDAC;
import portalrefimpl.schedule.createappointment.request.SpecialityRequest;
import portalrefimpl.schedule.createappointment.response.SpecialityResponse;

/**
 * This is the BC class for getting the list of specialities
 * @author GRamamoorthy
 *
 */
public class SpecialityBC {

	/**
	 * This method gets the list of specialities given the speciality request
	 * This method in turn calls the SpecialityDAC and gets the data from it
	 * @param specialityRequest
	 * @return
	 */
	public SpecialityResponse getSpecialityList(SpecialityRequest specialityRequest){
		SpecialityDAC dacInst = new SpecialityDAC();
		SpecialityResponse specialityResponse = dacInst.getSpecialityList(specialityRequest);
		return specialityResponse;
	}
	
}
