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
package portalrefimpl.schedule.createappointment.svc.impl;

import java.text.MessageFormat;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.request.ValidationRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.response.ValidationResponse;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.bc.BookAppointmentRequestBC;
import portalrefimpl.schedule.createappointment.request.BookAppointmentRequest;
import portalrefimpl.schedule.createappointment.response.AppointmentResponse;
import portalrefimpl.schedule.createappointment.response.BookAppointmentResponse;
import portalrefimpl.schedule.createappointment.svc.BookAppointmentSvc;

/**
 * This is the service impl class for book appointment functionality
 * This class extends BaseAppointmentSvcImpl and implements the interfaces
 * BookAppointmentSvc and Provider
 * @author GRamamoorthy
 *
 */
@WebServiceProvider
public class BookAppointmentSvcImpl extends BaseAppointmentSvcImpl implements
		BookAppointmentSvc, Provider<Source> {

	/**
	 * This method registers the HTTP URL of this service
	 * with end point
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String webServiceURL = PortalHelper
				.getConfigPropertyValue(PortalConstants.CREATEAPPOINTMENT_WS_URL_KEY);
		e.publish(webServiceURL);
	}

	/**
	 * This method validates the book appointment request
	 * 
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		// initialize the response object
		BookAppointmentResponse bookApptResponse = new BookAppointmentResponse();
		
		// first perform the basic validation
		// which is done in the base class
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);
		
		// if basic validation has failed, then set the errors in response
		if(!validationResponse.isSuccessful()){
			bookApptResponse.addAllErrors(validationResponse.getErrors());
		}
		
		/*ErrorInfo errorInfo = validationResponse.getErrorInfo();
		bookApptResponse.setErrorInfo(errorInfo);
		// request has failed basic validation - so return the response
		if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){
			return bookApptResponse;
		}*/
		
		BookAppointmentRequest bookAppointmentRequest = (BookAppointmentRequest) request;
		AppointmentResponse appointmentResponse = validateAppointmentRequest(bookAppointmentRequest);
		// again add the errors from validating the request properties to the response
		if(!appointmentResponse.isSuccessful()){
			bookApptResponse.addAllErrors(appointmentResponse.getErrors());
		}
		
		// validate patient id
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		ErrorInfo errorInfo = null;
		String patientId = bookAppointmentRequest.getPatientId();
		if(patientId == null || patientId.trim().equals("")){
			errorCode = CreateAppointmentConstants.BOOKAPPOINTMENT_PATIENTID_INVALID_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			bookApptResponse.addError(errorInfo);
		}
		
		// finally if all validations have passed, then set positive response
		if(!bookApptResponse.hasErrors()){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			bookApptResponse.addError(errorInfo);
		}
		
		/*ErrorInfo apptRespErrorInfo = appointmentResponse.getErrorInfo();
		if(ErrorInfo.SUCCESS_CODE != apptRespErrorInfo.getErrorCode()){
			bookApptResponse.setErrorInfo(apptRespErrorInfo);
			return bookApptResponse;
		}*/
		
		return bookApptResponse;
	}
	

	/**
	 * This is the main method of this web service
	 * This method is invoked when the HTTP URL of the service
	 * is accessed
	 * This method in turn calls the business method
	 * bookAppointment()
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		BookAppointmentResponse response = null;
		
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String)mc.get(MessageContext.QUERY_STRING);
			Map<String, String> parameterMap = getRequestParameterMap(path);
			
			BookAppointmentRequest bookAppointmentRequest = getBookAppointmentRequest(parameterMap);
			response = bookAppointment(bookAppointmentRequest);
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
							new Object[] { CommonConstants.APPTREQUEST_BOOK_SVC_NAME_KEY });
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response = new BookAppointmentResponse();
			response.addError(errorInfo);
			/*response.setErrorInfo(errorInfo);*/
		}
		/*xmlFileContent = getResponseXMLString(response);
		// form the reply object and return it
		reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(response,
				CommonConstants.APPTREQUEST_BOOK_SVC_NAME_KEY);
		
		return reply;
	}

	/**
	 * This is the main business method in this class
	 * This method performs the book appointment transaction
	 */
	public BookAppointmentResponse bookAppointment(
			BookAppointmentRequest bookAppointmentRequest) {
		BookAppointmentRequestBC bcInst = new BookAppointmentRequestBC();
		return bcInst.getBookAppointmentResponse(bookAppointmentRequest);
	}
	
	/**
	 * This method returns the book appointment request object
	 * given the parameter map which contains all the parameters
	 * passed to this web service
	 * @param parameterMap
	 * @return
	 */
	private BookAppointmentRequest getBookAppointmentRequest(
			Map<String, String> parameterMap) {
		BookAppointmentRequest request = new BookAppointmentRequest();
		populateAppointmentRequest(parameterMap, request);
		return request;
	}

}
