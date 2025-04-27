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
package portalrefimpl.contactreason.cancelappointment.svc;

import java.text.MessageFormat;
import java.util.Map;

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
import portalrefimpl.contactreason.cancelappointment.ContactReasonCancelApptConstant;
import portalrefimpl.contactreason.cancelappointment.bc.ContactReasonForCancelApptBC;
import portalrefimpl.contactreason.cancelappointment.request.ContactReasonForCancelApptRequest;
import portalrefimpl.contactreason.cancelappointment.response.ContactReasonForCancelApptResponse;
import portalrefimpl.schedule.common.request.AppointmentType;

/**
 * This is the service implementation class for the contact reason
 * for cancel appointment functionality
 * @author GRamamoorthy
 *
 */
@WebServiceProvider
public class ContactReasonForCancelApptSvcImpl extends BaseServiceImpl
		implements ContactReasonForCancelApptSvc, Provider<Source> {

	/**
	 * This method registers the HTTP URL for this web service
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String serviceURL = PortalHelper
				.getWebServiceURL(PortalConstants.CONTACTREASON_CANCELAPPT_WS_URL_KEY);
		e.publish(serviceURL);
	}

	/**
	 * This method validates the given request
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);
		
		ContactReasonForCancelApptResponse response = new ContactReasonForCancelApptResponse();
		// check for errors
		/*if(validationResponse.hasErrors() || validationResponse.isValid()){
			response.addAllErrors(validationResponse.getErrors());
		}*/
		if(!validationResponse.isSuccessful()){
			response.addAllErrors(validationResponse.getErrors());
		}
		
		//ErrorInfo errorInfo = validationResponse.getErrorInfo();
		// set the errorinfo to the response
		// here after only the error info will be updated
		/*response.setErrorInfo(errorInfo);*/
		// request has failed basic validation - so return error response
		/*if (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) {
			response.addError(errorInfo);
			//return response;
		}*/
		
		ErrorInfo errorInfo = null;
		// cast to the specific request - no issues
		ContactReasonForCancelApptRequest apptRequest = (ContactReasonForCancelApptRequest) request;
		// validate only the appointment type
		AppointmentType appointmentType = apptRequest.getAppointmentType();
		if(appointmentType == null){
			int errorCode = ContactReasonCancelApptConstant.APPT_TYPE_INVALID_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CONTACT_REASON_MODULE_NAME,
							errorCode);
			
			errorInfo = new ErrorInfo();
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
	 * This is the main method of the web service
	 * This method is invoked when the HTTP URL for this web service
	 * is accessed
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		ContactReasonForCancelApptResponse response = null;
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String)mc.get(MessageContext.QUERY_STRING);
			Map<String, String> parameterMap = getRequestParameterMap(path);
			ContactReasonForCancelApptRequest request = getRequest(parameterMap);
			response = getContactReasons(request);
		}catch (Exception e) {
			// need to form an error info object as the xml output here
			int errorCode = CommonConstants.WEBSERVICE_EXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			// there is a need to fill in the web service
			// name in the error message using format
			errorMessage = MessageFormat
					.format(errorMessage,
							new Object[] { CommonConstants.CANCEL_APPT_REASON_SVC_NAME_KEY });
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response = new ContactReasonForCancelApptResponse();
			response.addError(errorInfo);
			//response.setErrorInfo(errorInfo);
		}
		
		/*xmlFileContent = getResponseXMLString(response);
		// form the reply object and return it
		reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(response,
				CommonConstants.CANCEL_APPT_REASON_SVC_NAME_KEY);
		
		return reply;
	}

	/**
	 * This method forms an instance of the contact reason for cancel
	 * appointment request object and returns the same
	 * @param parameterMap
	 * @return
	 */
	private ContactReasonForCancelApptRequest getRequest(
			Map<String, String> parameterMap) {
		ContactReasonForCancelApptRequest request = new ContactReasonForCancelApptRequest();
		// set the portal user name to the request first
		if (parameterMap
				.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)) {
			String portalKeyValue = parameterMap
					.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			request.setPortalUserName(portalKeyValue);
		}
		// appointment type
		if(parameterMap.containsKey(ContactReasonCancelApptConstant.APPOINTMENT_TYPE_REQUEST_PARAM_KEY)){
			String appointmentTypeStr = parameterMap
					.get(ContactReasonCancelApptConstant.APPOINTMENT_TYPE_REQUEST_PARAM_KEY);
			// there is a need to convert the appointment type string to appointment type
			// enum inside the try catch block
			try {
				AppointmentType appointmentType = AppointmentType.valueOf(appointmentTypeStr);
				request.setAppointmentType(appointmentType);
			} catch (Exception e) {
				// nothing much can be done
			}
		}
		
		return request;
	}
	
	/**
	 * This is the main business method in this service class
	 * This method can be invoked directly if this class is accessed
	 * as a simple java service
	 */
	public ContactReasonForCancelApptResponse getContactReasons(
			ContactReasonForCancelApptRequest request) {
		// first validate the request
		ContactReasonForCancelApptResponse response = null;
		response = (ContactReasonForCancelApptResponse)isValidRequest(request);
		/*ErrorInfo errorInfo = response.getErrorInfo();
		if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){
			return response;
		}*/
		if(!response.isSuccessful()){
			return response;
		}
		
		// next get the data through the BC class 
		ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");
		ContactReasonForCancelApptBC bcInst = (ContactReasonForCancelApptBC)context.getBean("refContactReasonForCancelApptBC");
		response = bcInst.getContactReasons(request);
		
		return response;
	}

}
