/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.resulttype.bc;

import org.apache.log4j.Logger;

import portal.resulttype.dac.ResultTypeDAC;
import portal.resulttype.request.ResultTypeRequest;
import portal.resulttype.response.ResultTypeResponse;

/**
 * This method invokes the DAC class to get the Result type list for the Test
 * Result details page
 * 
 * @author vkodancha
 * 
 */
public class ResultTypeBC {
	private static Logger logger = Logger
			.getLogger(ResultTypeBC.class.getName());
	
	// instance variable
	private ResultTypeDAC dacInst;
	/**
	 * This method fetches the Result Types from EM DB for patient portal
	 * application Test Result details page
	 * 
	 * @param request
	 * @return ResultTypeResponse
	 */
	public ResultTypeResponse getResultTypes(ResultTypeRequest request) {
		logger.debug("inside the method getResultTypes");
		return dacInst.getResultTypes(request);
	}

	/**
	 * @param inst
	 *            the inst to set
	 */
	public void setDacInst(ResultTypeDAC dacInst) {
		this.dacInst = dacInst;
	}
}
