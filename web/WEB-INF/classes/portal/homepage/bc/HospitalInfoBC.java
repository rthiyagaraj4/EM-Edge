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
import portal.homepage.dac.HospitalInfoDAC;
import portal.homepage.response.HospitalInfoResponse;


/**
 * This method is used to call the DAC layer to
 * get Hospital Details
 * 
 * @author skrishnared2
 *
 */
public class HospitalInfoBC {
	
	private static Logger logger = Logger.getLogger(HospitalInfoBC.class.getName());
	HospitalInfoDAC dacInst;
	HospitalInfoResponse response;
	
	/**
	 * @param dacInst the dacInst to set
	 */
	public void setDacInst(HospitalInfoDAC dacInst) {
		this.dacInst = dacInst;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(HospitalInfoResponse response) {
		this.response = response;
	}

	/**
	 * This method calls the Hospital DAC with Hospital request
	 * to get the hospital Response
	 * @param request
	 * @return
	 */
	public HospitalInfoResponse getHospitalInformation(BaseRequest request){
		logger.debug("Entering the method : getHospitalInformation with request :"+request.toString());
		response = dacInst.getHospitalInformation(request);
		logger.debug("Leaving the method : getHospitalInformation with response :"+response.toString());		
		return response;
	}
}
