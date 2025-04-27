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
package portalrefimpl.schedule.viewappointment.svc;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
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
import portalrefimpl.common.request.PatientInfo;
import portalrefimpl.common.request.ValidationRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.response.ValidationResponse;
import portalrefimpl.common.svc.BaseServiceImpl;
import portalrefimpl.schedule.viewappointment.bc.AppointmentDetailsBC;
import portalrefimpl.schedule.viewappointment.request.AppointmentDetailsRequest;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetails;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetailsResponse;

/**
 * @author GRamamoorthy This class can be made into a RESTful web service by
 *         implementing Provider interface given by JAX-WS
 * 
 */
@WebServiceProvider
public class AppointmentSvcImpl extends BaseServiceImpl implements
		AppointmentSvc, Provider<Source> {

	/**
	 * This is the main business method in this service This method gets the
	 * appointment details
	 * 
	 * @param request
	 * @return
	 */
	public AppointmentDetailsResponse getAppointmentDetails(
			AppointmentDetailsRequest request) {
		// // first step
		// validate the request
		AppointmentDetailsResponse response = (AppointmentDetailsResponse) isValidRequest(request);
		if (!response.isSuccessful()) {
			return response;
		}
		/*
		 * ErrorInfo errorInfo = response.getErrorInfo();
		 * if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){ return
		 * response; }
		 */
		// second step
		// initialize the BC class and get the data from it
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-beans.xml");
		AppointmentDetailsBC inst = (AppointmentDetailsBC) context
				.getBean("refAppointmentDetailsBC");
		response = inst.getAppointmentDetails(request);

		return response;
	}

	/**
	 * This is the main method in this web service implementation This method is
	 * invoked once the HTTP URL of this web service is accessed
	 */
	public Source invoke(Source request) {
		StreamSource reply = null;
		AppointmentDetailsResponse appointmentDetailsResponse = null;
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);

			AppointmentDetailsRequest appointmentDetailsRequest = formRequestFromPath(path);
			appointmentDetailsResponse = getAppointmentDetails(appointmentDetailsRequest);
		} catch (Exception e) {
			int errorCode = CommonConstants.WEBSERVICE_EXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			// there is a need to fill in the web service
			// name in the error message using format
			errorMessage = MessageFormat
					.format(errorMessage,
							new Object[] { CommonConstants.APPOINTMENTS_RECENT_SVC_NAME_KEY });
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);

			appointmentDetailsResponse = new AppointmentDetailsResponse();
			appointmentDetailsResponse.addError(errorInfo);
			// appointmentDetailsResponse.setErrorInfo(errorInfo);
		}

		/*String xmlFileContent = getXMLFile(appointmentDetailsResponse);
		try {
			reply = new StreamSource(new StringReader(xmlFileContent));
		} catch (Exception e) {
			// cannot do much - so simply initialize the reply
			reply = new StreamSource();
		}*/
		
		String xmlFileContent = getXMLFile(appointmentDetailsResponse);
		reply = getServiceResponseAsStreamSource(xmlFileContent,
				CommonConstants.APPOINTMENTS_RECENT_SVC_NAME_KEY);
		return reply;
	}

	/**
	 * This method registers the http URL for the service with the end point
	 */
	private void registerService(AppointmentDetailsRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String appointmentDetailsUrl = PortalHelper
				.getWebServiceURL(PortalConstants.APPOINTMENTDETAILS_WS_URL_KEY);
		e.publish(appointmentDetailsUrl);
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	private AppointmentDetailsRequest formRequestFromPath(String path) {
		AppointmentDetailsRequest request = new AppointmentDetailsRequest();
		PatientInfo patientInfo = new PatientInfo();
		request.setPatientInfo(patientInfo);
		// the main logic in this method is to break the path based on
		// & character
		Map<String, String> parameterMap = getRequestParameterMap(path);
		/*
		 * StringTokenizer parameterTokenizer = new StringTokenizer(path, "&");
		 * String token = null; int index = -1;
		 * 
		 * Map<String, String> parameterMap = new HashMap<String, String>();
		 * String paramName = null; String paramValue = null;
		 * while(parameterTokenizer.hasMoreTokens()){ token =
		 * parameterTokenizer.nextToken(); index = token.indexOf("="); if(index
		 * >= 0){ paramName = token.substring(0, index); paramValue =
		 * token.substring(index+1); parameterMap.put(paramName, paramValue); }
		 * }
		 */

		// now iterate through the hashmap and find the parameters
		if (parameterMap.isEmpty()) {
			return request;
		}

		if (parameterMap.containsKey("patientId")) {
			patientInfo.setPatientId(parameterMap.get("patientId"));
		}
		if (parameterMap.containsKey("encounterId")) {
			patientInfo.setEncounterId(parameterMap.get("encounterId"));
		}
		int recordCount = 0;
		// code modified to calculate the record count value
		// even if the request parameter is not passed
		String recordCntStr = null;
		if (parameterMap.containsKey("recordCount")) {
			recordCntStr = parameterMap.get("recordCount");
		}
		recordCount = PortalHelper.getIntegerValue(recordCntStr,
				PortalConstants.HOMEPAGE_APPOINTMENTLIST_RECORDCOUNT);
		request.setRecordCount(recordCount);
		
		// portal user name
		if(parameterMap.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)){
			String portalUserName = parameterMap.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			if(portalUserName == null){
				portalUserName = "";
			}
			request.setPortalUserName(portalUserName);
		}
		
		// set the service call to true
		request.setServiceCall(true);

		return request;
	}

	/**
	 * 
	 * @param appointmentDetailsResponse
	 * @return
	 */
	private String getXMLFile(
			AppointmentDetailsResponse appointmentDetailsResponse) {
		StringBuffer xmlFileContent = new StringBuffer();
		xmlFileContent
				.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		/*
		 * // just a safe check - response can never be null but still handle it
		 * if(appointmentDetailsResponse == null){
		 * System.out.println("Empty response - so no file output"); return "";
		 * }
		 */

		if (appointmentDetailsResponse.isSuccessful()) {
			xmlFileContent.append("<")
					.append(AppointmentDetailConstant.APPOINTMENTDETAILS_KEY)
					.append(">");
			List<AppointmentDetails> appointmentDetailsList = appointmentDetailsResponse
					.getAppointmentDetailsList();
			if (appointmentDetailsList != null
					&& !appointmentDetailsList.isEmpty()) {
				String practitioner = "";
				String speciality = "";
				Date appointmentStartTime = null;
				Date appointmentEndTime = null;
				Date appointmentDate = null;
				for (AppointmentDetails appointmentDetails : appointmentDetailsList) {
					xmlFileContent
							.append("<")
							.append(AppointmentDetailConstant.APPOINTMENTDETAIL_KEY)
							.append(">");
					practitioner = appointmentDetails.getPractitioner();
					xmlFileContent.append("<")
							.append(AppointmentDetailConstant.PRACTITIONER_KEY)
							.append(">");
					xmlFileContent.append(practitioner);
					xmlFileContent.append("</")
							.append(AppointmentDetailConstant.PRACTITIONER_KEY)
							.append(">");

					speciality = appointmentDetails.getApptSpeciality();
					xmlFileContent.append("<")
							.append(AppointmentDetailConstant.SPECIALITY_KEY)
							.append(">");
					xmlFileContent.append(speciality);
					xmlFileContent.append("</")
							.append(AppointmentDetailConstant.SPECIALITY_KEY)
							.append(">");

					appointmentDate = appointmentDetails.getAppointmentDate();
					xmlFileContent.append("<")
							.append(AppointmentDetailConstant.APPOINTMENT_DATE)
							.append(">");
					xmlFileContent.append(appointmentDate.getTime());
					xmlFileContent.append("</")
							.append(AppointmentDetailConstant.APPOINTMENT_DATE)
							.append(">");

					appointmentStartTime = appointmentDetails
							.getApptStartTime();
					xmlFileContent
							.append("<")
							.append(AppointmentDetailConstant.APPOINTMENT_STARTTIME_KEY)
							.append(">");
					xmlFileContent.append(appointmentStartTime.getTime());
					xmlFileContent
							.append("</")
							.append(AppointmentDetailConstant.APPOINTMENT_STARTTIME_KEY)
							.append(">");

					appointmentEndTime = appointmentDetails.getApptEndTime();
					xmlFileContent
							.append("<")
							.append(AppointmentDetailConstant.APPOINTMENT_ENDTIME_KEY)
							.append(">");
					xmlFileContent.append(appointmentEndTime.getTime());
					xmlFileContent
							.append("</")
							.append(AppointmentDetailConstant.APPOINTMENT_ENDTIME_KEY)
							.append(">");

					xmlFileContent
							.append("</")
							.append(AppointmentDetailConstant.APPOINTMENTDETAIL_KEY)
							.append(">");
				}
			}

			xmlFileContent.append("</")
					.append(AppointmentDetailConstant.APPOINTMENTDETAILS_KEY)
					.append(">");
		} else {
			xmlFileContent.append(appointmentDetailsResponse
					.getErrorAsXMLString());
		}

		/*
		 * ErrorInfo errorInfo = appointmentDetailsResponse.getErrorInfo(); if
		 * (errorInfo != null) { int errorCode = errorInfo.getErrorCode();
		 * String errorMessage = null; // in case of error, form the error
		 * information // and put it to the string buffer if
		 * (ErrorInfo.SUCCESS_CODE != errorCode) { errorMessage =
		 * errorInfo.getErrorMessage(); xmlFileContent.append("<")
		 * .append(PortalConstants.ERRORINFO_KEY).append(">");
		 * xmlFileContent.append("<")
		 * .append(PortalConstants.ERRORCODE_KEY).append(">");
		 * xmlFileContent.append(errorCode); xmlFileContent.append("</")
		 * .append(PortalConstants.ERRORCODE_KEY).append(">");
		 * xmlFileContent.append("<")
		 * .append(PortalConstants.ERRORMESSAGE_KEY).append(">");
		 * xmlFileContent.append(errorMessage); xmlFileContent.append("</")
		 * .append(PortalConstants.ERRORMESSAGE_KEY).append(">");
		 * xmlFileContent.append("</")
		 * .append(PortalConstants.ERRORINFO_KEY).append(">"); } else {
		 * xmlFileContent .append("<")
		 * .append(AppointmentDetailConstant.APPOINTMENTDETAILS_KEY)
		 * .append(">"); List<AppointmentDetails> appointmentDetailsList =
		 * appointmentDetailsResponse .getAppointmentDetailsList(); if
		 * (appointmentDetailsList != null && !appointmentDetailsList.isEmpty())
		 * { String practitioner = ""; String speciality = ""; Date
		 * appointmentStartTime = null; Date appointmentEndTime = null; Date
		 * appointmentDate = null; for (AppointmentDetails appointmentDetails :
		 * appointmentDetailsList) { xmlFileContent .append("<")
		 * .append(AppointmentDetailConstant.APPOINTMENTDETAIL_KEY)
		 * .append(">"); practitioner = appointmentDetails.getPractitioner();
		 * xmlFileContent .append("<")
		 * .append(AppointmentDetailConstant.PRACTITIONER_KEY) .append(">");
		 * xmlFileContent.append(practitioner); xmlFileContent .append("</")
		 * .append(AppointmentDetailConstant.PRACTITIONER_KEY) .append(">");
		 * 
		 * speciality = appointmentDetails.getApptSpeciality(); xmlFileContent
		 * .append("<") .append(AppointmentDetailConstant.SPECIALITY_KEY)
		 * .append(">"); xmlFileContent.append(speciality); xmlFileContent
		 * .append("</") .append(AppointmentDetailConstant.SPECIALITY_KEY)
		 * .append(">");
		 * 
		 * appointmentDate = appointmentDetails .getAppointmentDate();
		 * xmlFileContent .append("<")
		 * .append(AppointmentDetailConstant.APPOINTMENT_DATE) .append(">");
		 * xmlFileContent.append(appointmentDate.getTime()); xmlFileContent
		 * .append("</") .append(AppointmentDetailConstant.APPOINTMENT_DATE)
		 * .append(">");
		 * 
		 * appointmentStartTime = appointmentDetails .getApptStartTime();
		 * xmlFileContent .append("<")
		 * .append(AppointmentDetailConstant.APPOINTMENT_STARTTIME_KEY)
		 * .append(">"); xmlFileContent.append(appointmentStartTime.getTime());
		 * xmlFileContent .append("</")
		 * .append(AppointmentDetailConstant.APPOINTMENT_STARTTIME_KEY)
		 * .append(">");
		 * 
		 * appointmentEndTime = appointmentDetails .getApptEndTime();
		 * xmlFileContent .append("<")
		 * .append(AppointmentDetailConstant.APPOINTMENT_ENDTIME_KEY)
		 * .append(">"); xmlFileContent.append(appointmentEndTime.getTime());
		 * xmlFileContent .append("</")
		 * .append(AppointmentDetailConstant.APPOINTMENT_ENDTIME_KEY)
		 * .append(">");
		 * 
		 * xmlFileContent .append("</")
		 * .append(AppointmentDetailConstant.APPOINTMENTDETAIL_KEY)
		 * .append(">"); } }
		 * 
		 * xmlFileContent .append("</")
		 * .append(AppointmentDetailConstant.APPOINTMENTDETAILS_KEY)
		 * .append(">"); } }
		 */

		/*
		 * final String outputFileName = "Output.xml"; File file = null;
		 * BufferedWriter bufWriter = null; try { file = new
		 * File(outputFileName); bufWriter = new BufferedWriter(new
		 * FileWriter(file)); bufWriter.write(xmlFileContent.toString());
		 * bufWriter.flush(); } catch (Exception e1) {
		 * System.out.println("Could not create file for writing the contents "
		 * +e1.getMessage()); return ""; }
		 */
		return xmlFileContent.toString();
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AppointmentSvcImpl svcInst = new AppointmentSvcImpl();
		AppointmentDetailsRequest appointmentDetailsRequest = new AppointmentDetailsRequest();
		PatientInfo patientInfo = new PatientInfo();
		patientInfo.setPatientId("HC00009253");
		patientInfo.setEncounterId("10000002");
		appointmentDetailsRequest.setPatientInfo(patientInfo);
		svcInst.registerService(appointmentDetailsRequest);

	}

	/**
	 * This method registers the http URL for the service with the end point
	 * 
	 * @param request
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String appointmentDetailsUrl = PortalHelper
				.getWebServiceURL(PortalConstants.APPOINTMENTDETAILS_WS_URL_KEY);
		e.publish(appointmentDetailsUrl);
	}

	/**
	 * This method validates the appointment details request object
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);

		AppointmentDetailsResponse response = new AppointmentDetailsResponse();
		if (!validationResponse.isSuccessful()) {
			response.addAllErrors(validationResponse.getErrors());
		}

		/*
		 * ErrorInfo errorInfo = validationResponse.getErrorInfo(); // set the
		 * errorinfo to the response // here after only the error info will be
		 * updated response.setErrorInfo(errorInfo); // request has failed basic
		 * validation - so return error response if (ErrorInfo.SUCCESS_CODE !=
		 * errorInfo.getErrorCode()) { return response; }
		 */
		ErrorInfo errorInfo = null;
		// validate only the patient id
		String patientId = request.getPatientId();
		if (patientId == null || patientId.trim().equals("")) {
			int errorCode = AppointmentDetailConstant.APPOINTMENTDETAILS_INVALIDPATIENTID_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.VIEWAPPTDETAILS_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
		}
		// when code comes here, response has either got errors
		// or all the validation has passed
		// if all the validation has passed, then we need to set
		// a positive error
		if (!response.hasErrors()) {
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			response.addError(errorInfo);
		}

		return response;
	}

}
