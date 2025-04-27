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
package eAlert.src.alert.dac;

import eAlert.src.alert.common.AlertBaseResponse;
import eAlert.src.alert.request.AlertDetailsRequest;
import eAlert.src.alert.request.AlertFlagManageRequest;
import eAlert.src.alert.request.AlertForwardUserRequest;
import eAlert.src.alert.request.AlertFwdManageRequest;
import eAlert.src.alert.request.AlertRequest;
import eAlert.src.alert.request.AlertReviewMangRequest;
import eAlert.src.alert.request.AlertsByFilterRequest;
import eAlert.src.alert.request.AlertsByGroupRequest;
import eAlert.src.alert.request.BaseRequest;
import eAlert.src.alert.response.AlertDetailsResponse;
import eAlert.src.alert.response.AlertFlagOptionResponse;
import eAlert.src.alert.response.AlertForwardUserResponse;
import eAlert.src.alert.response.AlertUserResponse;
import eAlert.src.alert.response.AlertsByFilterResponse;
import eAlert.src.alert.response.AlertsByGroupResponse;

/**
 * @author prasannar
 *
 */
public interface AlertProcessingDAC {

	/**
	 * Retrieval methods 
	 * @param request
	 * @return
	 */
	
	public AlertUserResponse getAlertsByUser(BaseRequest request);
	
	public AlertsByGroupResponse getAlertsByGroup(AlertsByGroupRequest request);
	
	public AlertsByFilterResponse getAlertsByFilter(AlertsByFilterRequest request);
	
	public AlertDetailsResponse getAlertDetails(AlertDetailsRequest request);
	
	public AlertFlagOptionResponse getFlagOptions();
	
	public AlertForwardUserResponse getForwardToUsers(AlertForwardUserRequest request);
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	
	public AlertBaseResponse updateAlertReviewState(AlertReviewMangRequest request);
	
	public AlertBaseResponse updateAlertFlagState(AlertFlagManageRequest request);
	
	public AlertBaseResponse updateAlertForwardState(AlertFwdManageRequest request);
	
	public AlertBaseResponse archiveAlert(AlertRequest request);
}
