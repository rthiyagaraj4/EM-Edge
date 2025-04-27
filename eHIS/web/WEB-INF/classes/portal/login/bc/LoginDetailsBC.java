/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.login.bc;

import org.apache.log4j.Logger;

import portal.login.dac.LoginDAC;
import portal.login.request.LoginRequest;
import portal.login.response.LoginResponse;

/**
 * This method is used to call the DAC layer to
 * validate the user
 * 
 * @author skrishnared2
 *
 */
public class LoginDetailsBC {
	
	private static Logger logger = Logger.getLogger(LoginDetailsBC.class.getName());
	/**
	 * 
	 * @param request
	 * @return
	 */
	public LoginResponse getLoginDetails(LoginRequest request){
		logger.info("Entering the method getLoginDetails :"
				+ request.toString());
		LoginResponse response = new LoginResponse();
				
		// second step
		// initialize the DAC class and get the data from it
		LoginDAC loginInst = new LoginDAC();
		response = loginInst.getLoginDetails(request);
		logger.info("Leaving the method getLoginDetails :"
				+ response.toString());
		return response;
	}
}
