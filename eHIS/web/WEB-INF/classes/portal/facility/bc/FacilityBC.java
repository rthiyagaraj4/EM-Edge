/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.facility.bc;

import org.apache.log4j.Logger;

import portal.facility.dac.FacilityDAC;
import portal.facility.request.FacilityRequest;
import portal.facility.response.FacilityResponse;

/**
 * This method invokes the DAC class to get the Facility list for the Test
 * Result details page
 * 
 * @author vkodancha
 * 
 */
public class FacilityBC {
	private static Logger logger = Logger
			.getLogger(FacilityBC.class.getName());
	
	// instance variable
	private FacilityDAC dacInst;
	
	/**
	 * This method fetches the facilities from EM DB for patient portal
	 * application Test Result details page
	 * 
	 * @param request
	 * @return FacilityResponse
	 */
	public FacilityResponse getFacilities(FacilityRequest request) {
		logger.debug("inside the method getFacilities");
		return dacInst.getFacilities(request);
	}

	/**
	 * @param inst
	 *            the inst to set
	 */
	public void setDacInst(FacilityDAC dacInst) {
		this.dacInst = dacInst;
	}

}
