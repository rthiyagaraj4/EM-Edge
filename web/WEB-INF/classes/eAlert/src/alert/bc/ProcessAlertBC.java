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
package eAlert.src.alert.bc;

import eAlert.src.alert.common.AlertBaseResponse;
import eAlert.src.alert.dac.AlertProcessingDAC;
import eAlert.src.alert.dacimpl.AlertProcessingDACImpl;
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
public class ProcessAlertBC {

	public AlertUserResponse getAlertsByUser(BaseRequest request){
		
		AlertProcessingDAC alertProcess = new AlertProcessingDACImpl();
		AlertUserResponse response =  alertProcess.getAlertsByUser(request);
		return response;
	}
	
	public AlertsByGroupResponse getAlertsByGroup(AlertsByGroupRequest request){
		
		AlertProcessingDAC alertProcess = new AlertProcessingDACImpl();
		AlertsByGroupResponse response =  alertProcess.getAlertsByGroup(request);
		return response;
	}
	
	public AlertsByFilterResponse getAlertsByFilter(AlertsByFilterRequest request){
		
		AlertProcessingDAC alertProcess = new AlertProcessingDACImpl();
		AlertsByFilterResponse response =  alertProcess.getAlertsByFilter(request);
		return response;
	}
	
	public AlertDetailsResponse getAlertDetails(AlertDetailsRequest request){
		
		AlertProcessingDAC alertProcess = new AlertProcessingDACImpl();
		AlertDetailsResponse response =  alertProcess.getAlertDetails(request);
		return response;
	}
	
	public AlertFlagOptionResponse getFlagOptions(){
		
		AlertProcessingDAC alertProcess = new AlertProcessingDACImpl();
		AlertFlagOptionResponse response = alertProcess.getFlagOptions();
		return response;
	}
	
	public AlertForwardUserResponse getForwardToUsers(AlertForwardUserRequest request){
		
		AlertProcessingDAC alertProcess = new AlertProcessingDACImpl();
		AlertForwardUserResponse response = alertProcess.getForwardToUsers(request);
		return response;
	}
	
	public AlertBaseResponse updateAlertReviewState(AlertReviewMangRequest request){

		AlertProcessingDAC alertProcess = new AlertProcessingDACImpl();
		AlertBaseResponse response = alertProcess.updateAlertReviewState(request);
		return response;
	}
	
	public AlertBaseResponse updateAlertFlagState(AlertFlagManageRequest request){
		
		AlertProcessingDAC alertProcess = new AlertProcessingDACImpl();
		AlertBaseResponse response = alertProcess.updateAlertFlagState(request);
		return response;
	}
	
	public AlertBaseResponse updateAlertForwardState(AlertFwdManageRequest request){
		
		AlertProcessingDAC alertProcess = new AlertProcessingDACImpl();
		AlertBaseResponse response = alertProcess.updateAlertForwardState(request);
		return response;
	}
	
	public AlertBaseResponse archiveAlert(AlertRequest request){
		
		AlertProcessingDAC alertProcess = new AlertProcessingDACImpl();
		AlertBaseResponse response = alertProcess.archiveAlert(request);
		return response;
	}
}
