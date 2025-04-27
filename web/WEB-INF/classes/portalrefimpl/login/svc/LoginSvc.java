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
package portalrefimpl.login.svc;

import portalrefimpl.login.request.LoginRequest;
import portalrefimpl.login.response.LoginResponse;



/**
 * This interface represents the Login service
 * @author GRamamoorthy
 *
 */
public interface LoginSvc {

	public LoginResponse validateUserLogin(LoginRequest loginRequest);
	
}
