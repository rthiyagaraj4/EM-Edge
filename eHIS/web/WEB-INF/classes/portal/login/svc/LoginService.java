/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.login.svc;

import portal.login.request.LoginRequest;
import portal.login.response.LoginResponse;

/**
 * This class defines all the abstract methods used in Login Service
 * This method takes as input LoginRequest object
 * and returns LoginResponse object
 * 
 * @author skrishnared2
 *
 */
public interface LoginService {

	/**
	 * This method validates the credential of the Patient.
	 * This method takes as input LoginRequest object
	 * and returns LoginResponse object
	 * @param request
	 * @return
	 */
	public LoginResponse authenticatePatientLogin(LoginRequest request);
}
