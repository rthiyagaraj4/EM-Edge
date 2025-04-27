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
package portalrefimpl.facility.facilityforcontact.svc;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.request.ValidationRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.response.ValidationResponse;
import portalrefimpl.common.svc.BaseServiceImpl;
import portalrefimpl.facility.FacilityConstants;
import portalrefimpl.facility.facilityforcontact.bc.FacilityForContactBC;
import portalrefimpl.facility.facilityforcontact.request.FacilityForContactRequest;
import portalrefimpl.facility.facilityforcontact.response.FacilityForContactResponse;

/**
 * This is the service implementation class for Facility for contact service
 * this class extends BaseServiceImpl and implements the interface
 * FacilityForContactSvc and Provider This class is the web service
 * implementation class
 * 
 * @author GRamamoorthy
 * 
 */
@WebServiceProvider
public class FacilityForContactSvcImpl extends BaseServiceImpl implements
		FacilityForContactSvc, Provider<Source> {

	/**
	 * This method registers the HTTP URL for this service
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String serviceURL = PortalHelper
				.getWebServiceURL(PortalConstants.FACILITY_FOR_CONTACT_WS_URL_KEY);
		e.publish(serviceURL);
	}

	/**
	 * This method validates the facility for contact request
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);

		FacilityForContactResponse response = new FacilityForContactResponse();
		// check for errors
		/*if(validationResponse.hasErrors() || validationResponse.isValid()){
			response.addAllErrors(validationResponse.getErrors());
		}*/
		if(!validationResponse.isSuccessful()){
			response.addAllErrors(validationResponse.getErrors());
		}
		
		/*ErrorInfo errorInfo = validationResponse.getErrorInfo();
		// set the error info to the response
		// here after only the error info will be updated
		response.setErrorInfo(errorInfo);
		// request has failed basic validation - so return error response
		if (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) {
			return response;
		}*/

		ErrorInfo errorInfo = new ErrorInfo();
		// no worries - cast the request object
		FacilityForContactRequest facilityForContactRequest = (FacilityForContactRequest) request;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// validate only the facility record count parameter passed
		// by the user
		int facilityCount = facilityForContactRequest.getFacilityCount();
		if (facilityCount <= 0) {
			errorCode = FacilityConstants.FACILITY_FORCONTACT_INVALID_RECORDCOUNT_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.FACILITY_FORCONTACT_MODULE_NAME, errorCode);
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			response.addError(errorInfo);
		}
		
		// this code is to add a positive error info object
		// when all the validations have passed
		if(!response.hasErrors()){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			
			response.addError(errorInfo);
		}
		

		return response;
	}

	/**
	 * This is the main method in this class This method is invoked when the
	 * HTTP URL for this web service is accessed This class in turn calls the
	 * business method getFacilitiesForContact()
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		FacilityForContactResponse response = null;
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			Map<String, String> parameterMap = getRequestParameterMap(path);
			FacilityForContactRequest request = getFacilityForContactRequest(parameterMap);
			response = getFacilitiesForContact(request);
		} catch (Exception e) {
			// need to form an error info object as the xml output here
			int errorCode = CommonConstants.WEBSERVICE_EXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			// there is a need to fill in the web service
			// name in the error message using format
			errorMessage = MessageFormat
					.format(errorMessage,
							new Object[] { CommonConstants.FACILITY_DETAILS_SVC_NAME_KEY });
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response = new FacilityForContactResponse();
			response.setErrorInfo(errorInfo);
		}

		/*xmlFileContent = getResponseXMLString(response);
		// form the reply object and return it
		reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(response,
				CommonConstants.FACILITY_DETAILS_SVC_NAME_KEY);
		
		return reply;
	}

	/**
	 * This method gets the facilities for contact This method is the main
	 * business method in this service
	 */
	public FacilityForContactResponse getFacilitiesForContact(
			FacilityForContactRequest request) {
		FacilityForContactResponse response = new FacilityForContactResponse();
		// first step - validate the request
		// if validation fails return the response
		response = (FacilityForContactResponse) isValidRequest(request);
		/*ErrorInfo errorInfo = response.getErrorInfo();
		if (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) {
			return response;
		}*/
		
		if(!response.isSuccessful()){
			return response;
		}

		// next get the data through the BC class
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-beans.xml");
		FacilityForContactBC bcInst = (FacilityForContactBC) context
				.getBean("refFacilityForContactBC");
		response = bcInst.getFacilitiesForContact(request);

		return response;
	}

	/**
	 * This method forms the facilityforcontact request object and returns it
	 * 
	 * @param parameterMap
	 * @return
	 */
	private FacilityForContactRequest getFacilityForContactRequest(
			Map<String, String> parameterMap) {
		FacilityForContactRequest request = new FacilityForContactRequest();
		// set the portal user name to the request first
		if (parameterMap
				.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)) {
			String portalKeyValue = parameterMap
					.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			request.setPortalUserName(portalKeyValue);
		}

		// facility Ids
		if (parameterMap
				.containsKey(FacilityConstants.FACILITY_FORCONTACT_FACILITYIDS_REQUEST_PARAM_KEY)) {
			String facilityIds = parameterMap
					.get(FacilityConstants.FACILITY_FORCONTACT_FACILITYIDS_REQUEST_PARAM_KEY);
			// the facility ids string will be in the format
			// FacilityId1##FacilityId2##FacilityId3
			// hence for getting the individual facility ids
			// there is a need to tokenize the facility ids
			StringTokenizer facilityIdTokenizer = new StringTokenizer(
					facilityIds,
					FacilityConstants.FACILITY_FORCONTACT_FACILITYIDS_DELIMITER);
			String facilityId = null;
			List<String> facilityIdList = new ArrayList<String>();
			while(facilityIdTokenizer.hasMoreTokens()){
				facilityId = facilityIdTokenizer.nextToken();
				facilityIdList.add(facilityId);
			}
			if(!facilityIdList.isEmpty()){
				request.setFacilityIds(facilityIdList);
			}
		}

		// facility record count
		if (parameterMap
				.containsKey(FacilityConstants.FACILITY_FORCONTACT_FACILITY_RECORD_COUNT_REQUEST_PARAM_KEY)) {
			
			String facilityRecordCountStr = parameterMap
					.get(FacilityConstants.FACILITY_FORCONTACT_FACILITY_RECORD_COUNT_REQUEST_PARAM_KEY);
			int facilityRecordCount = PortalHelper.getIntegerValue(
					facilityRecordCountStr,
					FacilityConstants.FACILITY_FORCONTACT_FACILITY_RECORDCOUNT_DEFAULT_VALUE);
			request.setFacilityCount(facilityRecordCount);
		}

		return request;
	}

}
