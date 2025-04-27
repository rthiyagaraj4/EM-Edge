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
package portalrefimpl.schedule.cancelappointment.svc;

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
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.schedule.cancelappointment.bc.CancelAppointmentBC;
import portalrefimpl.schedule.cancelappointment.request.CancelAppointmentRequest;
import portalrefimpl.schedule.cancelappointment.response.CancelAppointmentResponse;
import portalrefimpl.schedule.common.request.AppointmentType;

/**
 * This is the service implementation for cancel appointment service This class
 * is also the web service implementation class This class extends
 * BaseServiceImpl and implements the interface CancelAppointmentSvc and
 * Provider
 * 
 * @author gramamoorthy
 * 
 */
@WebServiceProvider
public class CancelAppointmentSvcImpl extends BaseServiceImpl implements
		CancelAppointmentSvc, Provider<Source> {

	/**
	 * This method registers the HTTP URL for this service
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.CANCEL_APPOINTMENT_WS_URL_KEY);
		e.publish(webServiceUrl);
	}

	/**
	 * This method validates the request
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);

		CancelAppointmentResponse response = new CancelAppointmentResponse();
		// if basic validation has failed, then set these errors to response
		if(!validationResponse.isSuccessful()){
			response.addAllErrors(validationResponse.getErrors());
		}
		/*ErrorInfo errorInfo = validationResponse.getErrorInfo();
		// set the errorinfo to the response
		// here after only the error info will be updated
		response.setErrorInfo(errorInfo);
		// request has failed basic validation - so return error response
		if (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) {
			return response;
		}*/

		// safely cast the request
		CancelAppointmentRequest cancelAppointmentRequest = (CancelAppointmentRequest) request;
		validateCancelAppointmentRequest(cancelAppointmentRequest,response);
		// request has failed validation - so return error response
		/*if (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) {
			return response;
		}*/
		
		// finally if all the validation has passed, then set positive response
		if(!response.hasErrors()){
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			response.addError(errorInfo);
		}
		
		return response;
	}

	/**
	 * this method validates the cancel appointment request
	 * 
	 * @param cancelAppointmentRequest
	 * @param errorInfo
	 */
	private void validateCancelAppointmentRequest(
			CancelAppointmentRequest cancelAppointmentRequest,
			CancelAppointmentResponse cancelAppointmentResponse) {
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// validate the patient id,appointment number, appointment status,
		// facility id and the reason for cancellation
		
		// patient id
		String patientId = cancelAppointmentRequest.getPatientId();
		if(patientId == null || patientId.trim().equals("")){
			errorCode = ScheduleConstants.CANCEL_APPT_INVALIDPATIENTID_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CANCEL_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			cancelAppointmentResponse.addError(errorInfo);
			/*return;*/
		}
		
		// appointment number
		String appointmentNumber = cancelAppointmentRequest
				.getAppointmentReferenceNumber();
		if (appointmentNumber == null || appointmentNumber.trim().equals("")) {
			errorCode = ScheduleConstants.CANCEL_APPT_INVALIDAPPTNUMBER_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CANCEL_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			cancelAppointmentResponse.addError(errorInfo);
			/*return;*/
		}
		
		// appointment status
		AppointmentType appointmentType = cancelAppointmentRequest
				.getAppointmentType();
		if(appointmentType == null){
			errorCode = ScheduleConstants.CANCEL_APPT_INVALIDAPPTSTATUS_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CANCEL_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			cancelAppointmentResponse.addError(errorInfo);
			/*return;*/
		}
		
		// facility id
		String facilityId = cancelAppointmentRequest.getFacilityId();
		if(facilityId == null || facilityId.trim().equals("")){
			errorCode = ScheduleConstants.CANCEL_APPT_INVALIDFACILITYID_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CANCEL_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			cancelAppointmentResponse.addError(errorInfo);
			/*return;*/
		}
		
		// reason for cancellation
		String reasonForCancellation = cancelAppointmentRequest.getReasonForCancellation();
		if(reasonForCancellation == null || reasonForCancellation.trim().equals("")){
			errorCode = ScheduleConstants.CANCEL_APPT_INVALIDREASONCODE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CANCEL_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			cancelAppointmentResponse.addError(errorInfo);
			/*return;*/
		}

	}

	/**
	 * This is the main method in this class This method is invoked when the
	 * HTTP URL for this web service is accessed This class in turn calls the
	 * business method cancelAppointment()
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		// initialize the response object
		CancelAppointmentResponse response = null;

		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			Map<String, String> parameterMap = getRequestParameterMap(path);
			CancelAppointmentRequest request = getCancelAppointmentRequest(parameterMap);
			response = cancelAppointment(request);
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
							new Object[] { CommonConstants.CANCEL_APPPOINTMENT_SVC_NAME_KEY });
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response = new CancelAppointmentResponse();
			/*response.setErrorInfo(errorInfo);*/
			response.addError(errorInfo);
		}

		/*xmlFileContent = getResponseXMLString(response);
		// form the reply object and return it
		reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(response,
				CommonConstants.CANCEL_APPPOINTMENT_SVC_NAME_KEY);
		
		return reply;
	}

	/**
	 * This method forms the cancel appointment request and returns the same
	 * 
	 * @param parameterMap
	 * @return
	 */
	private CancelAppointmentRequest getCancelAppointmentRequest(
			Map<String, String> parameterMap) {
		CancelAppointmentRequest request = new CancelAppointmentRequest();
		// set the portal user name to the request first
		if (parameterMap
				.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)) {
			String portalKeyValue = parameterMap
					.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			request.setPortalUserName(portalKeyValue);
		}

		// next patient id
		if (parameterMap
				.containsKey(PortalConstants.PATIENTID_REQUEST_PARAM_KEY)) {
			String patientId = parameterMap
					.get(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
			request.setPatientId(patientId);
		}

		// appointment number
		if (parameterMap
				.containsKey(ScheduleConstants.CANCELAPPT_APPT_NUMBER_REQUEST_PARAM_KEY)) {
			String appointmentNumber = parameterMap
					.get(ScheduleConstants.CANCELAPPT_APPT_NUMBER_REQUEST_PARAM_KEY);
			request.setAppointmentReferenceNumber(appointmentNumber);
		}
		// appointment status
		if (parameterMap
				.containsKey(ScheduleConstants.CANCELAPPT_APPT_STATUS_REQUEST_PARAM_KEY)) {
			String appointmentStatus = parameterMap
					.get(ScheduleConstants.CANCELAPPT_APPT_STATUS_REQUEST_PARAM_KEY);

			AppointmentType appointmentType = null;
			if (ScheduleConstants.CANCELAPPT_APPT_REQUEST_TYPE_IDENTIFIER
					.equals(appointmentStatus)) {
				appointmentType = AppointmentType.Appointment_Request;
			}else if(ScheduleConstants.CANCELAPPT_APPT_IDENTIFIER.equals(appointmentStatus)){
				appointmentType = AppointmentType.Appointment;
			}
			request.setAppointmentType(appointmentType);
		}
		// facility id
		if (parameterMap
				.containsKey(ScheduleConstants.CANCELAPPT_FACILITYID_REQUEST_PARAM_KEY)) {
			String facilityId = parameterMap
					.get(ScheduleConstants.CANCELAPPT_FACILITYID_REQUEST_PARAM_KEY);
			request.setFacilityId(facilityId);
		}
		// cancellation reason
		if (parameterMap
				.containsKey(ScheduleConstants.CANCELAPPT_REASONCODE_REQUEST_PARAM_KEY)) {
			String cancelReasonCode = parameterMap
					.get(ScheduleConstants.CANCELAPPT_REASONCODE_REQUEST_PARAM_KEY);
			request.setReasonForCancellation(cancelReasonCode);
		}

		return request;
	}

	/**
	 * This method cancels an appointment This method is the main business
	 * method in this service
	 */
	public CancelAppointmentResponse cancelAppointment(
			CancelAppointmentRequest request) {
		CancelAppointmentResponse response = new CancelAppointmentResponse();
		// first step - validate the request
		// if validation fails return the response
		response = (CancelAppointmentResponse)isValidRequest(request);
		if(!response.isSuccessful()){
			return response;
		}
		/*ErrorInfo errorInfo = response.getErrorInfo();
		if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){
			return response;
		}*/
		
		// next get the data through the BC class 
		ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");
		CancelAppointmentBC bcInst = (CancelAppointmentBC)context.getBean("refCancelAppointmentBC");
		response = bcInst.cancelAppointment(request);
		return response;
	}

}
