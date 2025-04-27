/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.schedule.viewupcomingappointment.svc;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingType;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import org.apache.log4j.Logger;

import portal.common.request.BaseRequest;
import portal.common.request.ValidationRequest;
import portal.common.response.BaseResponse;
import portal.common.response.ErrorInfo;
import portal.common.svc.BaseServiceImpl;
import portal.schedule.viewupcomingappointment.bc.UpcomingAppointmentDetailsBC;
import portal.schedule.viewupcomingappointment.request.UpcomingAppointmentDetailsRequest;
import portal.schedule.viewupcomingappointment.response.UpcomingAppointmentDetails;
import portal.schedule.viewupcomingappointment.response.UpcomingAppointmentDetailsResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.PortalConstants;
import portal.tools.PortalHelper;
import portal.tools.UpcomingAppointmentDetailsConstant;

/**
 * @author vkodancha
 * This class can be made into a RESTful web service
 * by implementing Provider interface given by JAX-WS
 * This class is used to get the upcoming appointment details 
 * on the patient portal upcoming appointment page
 * 
 */
@WebServiceProvider()    
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class UpcomingAppointmentDetailsSvcImpl extends BaseServiceImpl implements UpcomingAppointmentDetailsSvc,Provider<Source>{
	private static Logger logger = Logger.getLogger(UpcomingAppointmentDetailsSvcImpl.class
			.getName());

	@Resource
	protected WebServiceContext wsContext;

	@Override
	public void registerService(BaseRequest request) {
		logger.info("URL is registered");
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String testResultsUrl = PortalHelper
				.getWebServiceURL(PortalConstants.UPCOMING_APPOINTMENTDETAILS_WS_URL_KEY);
		e.publish(testResultsUrl);
		logger.info("URL is published");
	}
	
	@Override
	public Source invoke(Source request) {
		logger.info("Invoking the service with request :" + request);
		StreamSource reply = null;
		UpcomingAppointmentDetailsResponse apptResponse = new UpcomingAppointmentDetailsResponse();
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			logger.debug("Path is  :" + path);
			/**
			 * get the parameters from path parameters are expected to be known
			 */
			UpcomingAppointmentDetailsRequest apptRequest = formRequestFromPath(path);
			logger.debug("Request formed after formRequestFromPath :"
					+ apptRequest.toString());
			apptResponse = (UpcomingAppointmentDetailsResponse) this.isValidRequestor(apptRequest);
			logger.debug("Is respoinse Valid :" + apptResponse.isValid());
			if (apptResponse.isValid()) {
				apptResponse = getUpcomingAppointmentDetails(apptRequest);
			}
			logger.debug("Response is :" + apptResponse.toString());
			String xmlFileContent = getXMLFile(apptResponse);
			logger.debug("XML response is :" + xmlFileContent);
			reply = new StreamSource(new StringReader(xmlFileContent));
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal("Exception while converting to stream source", e);
		}
		return reply;
	}
	/**
	 * This method is used for retrieving all the request parameters from the
	 * URL
	 * 
	 * @param path
	 * @return
	 */
	private UpcomingAppointmentDetailsRequest formRequestFromPath(String path) {
		logger.info("Entered the method formRequestFromPath");
		UpcomingAppointmentDetailsRequest request = new UpcomingAppointmentDetailsRequest();
		Map<String, String> parameterMap = getParametersFromRequest(path);

		logger.debug("parameterMap :" + parameterMap.toString());
		// now iterate through the hash map and find the parameters
		if (parameterMap.isEmpty()) {
			return request;
		}

		/* call to update portal user name to request */
		setPortalUserNameToRequest(request, parameterMap);

		/* sets the URL parameters to request */
		request = setParamsToRequest(request, parameterMap);
		logger.info("leaving the method formRequestFromPath");
		return request;
	}

	/**
	 * This method updates the request with parameters
	 */
	private UpcomingAppointmentDetailsRequest setParamsToRequest(UpcomingAppointmentDetailsRequest request,
			Map<String, String> parameterMap) {
		logger.info("Entering the method setParamsToRequest");
		if (parameterMap.containsKey("patientId")) {
			request.setPatientId(parameterMap.get("patientId"));
		}
		if (parameterMap.containsKey("facilityId")) {
			request.setFaciltiyId(parameterMap.get("facilityId"));
		}
		if (parameterMap.containsKey("fromDate")) {
			request.setDateFrom(parameterMap.get("fromDate"));
		}
		if (parameterMap.containsKey("toDate")) {
			request.setDateTo(parameterMap.get("toDate"));
		}
		if (parameterMap.containsKey("language")) {
			request.setLanguage(parameterMap.get("language"));
		}
		logger.info("leaving the method setParamsToRequest");
		return request;
	}

	/**
	 * Validation of the input parameters
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public BaseResponse isValidRequestor(ValidationRequest request) {
		logger.info("Entering the method isValidRequestor :"
				+ request.toString());
		UpcomingAppointmentDetailsResponse uresponse = new UpcomingAppointmentDetailsResponse();
		UpcomingAppointmentDetailsRequest urequest = (UpcomingAppointmentDetailsRequest) request;
		uresponse.setValid(true);

		if (!super.isValidRequestor(request).isValid()) { // if portalusername
															// is not valid
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					UpcomingAppointmentDetailsConstant.MODULE_NAME,
					ErrorInfo.UPCOMING_APPT_INVALID_LOGIN_CODE);
			uresponse.setErrorInfo(errorInfo);
			uresponse.setValid(false);
		} else if (isEmptyOrNull(urequest.getPatientId())) { // if patientId or
																// oderId Or
																// Order or
																// resultType //
																// not passed
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					UpcomingAppointmentDetailsConstant.MODULE_NAME,
					ErrorInfo.UPCOMING_APPT_INSUFFICIENT_REQUEST_PARAMETERS_CODE);
			uresponse.setErrorInfo(errorInfo);
			uresponse.setValid(false);
		}
		logger.info("Leaving the method isValidRequestor :");
		return uresponse;
	}
	

	/**
	 * This method calls the business component which calls DAO layer to get the appointments
	 */
	@Override
	public UpcomingAppointmentDetailsResponse getUpcomingAppointmentDetails(
			UpcomingAppointmentDetailsRequest request) {
		logger.info("Entering the method getTestReport");
		// ApplicationContext context1 = new
		// ClassPathXmlApplicationContext("Beans.xml");

		UpcomingAppointmentDetailsBC inst = (UpcomingAppointmentDetailsBC) context.getBean("UpcomingAppointmentDetailsBC");
		UpcomingAppointmentDetailsResponse response = inst.getUpcomingAppointmentDetails(request);

		logger.debug("Error Info is:" + response.getErrorInfo().toString());
		logger.info("Leaving the method getTestReport");
		return response;
	}

	/**
	 * This method is used to convert the Response object in to XML String
	 * @param apptResponse
	 * @return
	 */
	private String getXMLFile(UpcomingAppointmentDetailsResponse apptResponse) {
		StringBuffer xmlFileContent = new StringBuffer();
		xmlFileContent
				.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");

		if (apptResponse == null) {
			logger.error("Empty response - so no file output");
			return "";
		}
		ErrorInfo errorInfo = apptResponse.getErrorInfo();
		if (errorInfo != null) {
			int errorCode = errorInfo.getErrorCode();
			String errorMessage = errorInfo.getErrorMessage();
			if (ErrorInfo.SUCCESS_CODE != errorCode) {
				xmlFileContent = createErrorResponse(errorMessage, errorCode,
						xmlFileContent);
				logger.info("Response is filled with failure"+errorMessage+errorCode);
			} else {
				xmlFileContent = getXMLForUpcomingApptList(apptResponse,
						xmlFileContent);
			}
		}
		return xmlFileContent.toString();
		
	}
	/**
	 * This method gets the appointment XML from list
	 * @param apptResponse
	 * @param xmlFileContent
	 * @return
	 */
	private StringBuffer getXMLForUpcomingApptList(
			UpcomingAppointmentDetailsResponse apptResponse,
			StringBuffer xmlFileContent) {
		xmlFileContent.append("<").append(UpcomingAppointmentDetailsConstant.APPOINTMENTDETAILS_KEY).append(">");
		List<UpcomingAppointmentDetails> upcomingAppointmentDetailsList = apptResponse.getUpcomingAppointmentDetails();
		if (upcomingAppointmentDetailsList != null && !upcomingAppointmentDetailsList.isEmpty()) {
			for(UpcomingAppointmentDetails upcomingAppointmentDetails : upcomingAppointmentDetailsList){
				xmlFileContent = getXMLForAppointment(xmlFileContent,
						upcomingAppointmentDetails);
			}
		}
		
		xmlFileContent.append("</").append(UpcomingAppointmentDetailsConstant.APPOINTMENTDETAILS_KEY).append(">");
		return xmlFileContent;
	}
	/**
	 * This method gets the appointment XML for each appointment
	 * @param xmlFileContent
	 * @param upcomingAppointmentDetails
	 * @return
	 */
	private StringBuffer getXMLForAppointment(StringBuffer xmlFileContent,
			UpcomingAppointmentDetails upcomingAppointmentDetails) {
		xmlFileContent.append("<").append(UpcomingAppointmentDetailsConstant.APPOINTMENTDETAIL_KEY).append(">");
		
		xmlFileContent = createXMLFileContent(xmlFileContent,
				UpcomingAppointmentDetailsConstant.APPOINTMENT_NUMBER,
				upcomingAppointmentDetails.getApptNumber());
		
		xmlFileContent = createXMLFileContent(xmlFileContent,
				UpcomingAppointmentDetailsConstant.PRACTITIONER_KEY,
				upcomingAppointmentDetails.getPractitioner());
		
		xmlFileContent = createXMLFileContent(xmlFileContent,
				UpcomingAppointmentDetailsConstant.SPECIALITY_KEY,
				upcomingAppointmentDetails.getApptSpeciality());
		
		xmlFileContent = createXMLFileContent(xmlFileContent,
				UpcomingAppointmentDetailsConstant.APPOINTMENT_DATE,
				upcomingAppointmentDetails.getAppointmentDate());
		
		xmlFileContent = createXMLFileContent(xmlFileContent,
				UpcomingAppointmentDetailsConstant.APPOINTMENT_STARTTIME_KEY,
				upcomingAppointmentDetails.getApptStartTime());
		
		xmlFileContent = createXMLFileContent(xmlFileContent,
				UpcomingAppointmentDetailsConstant.APPOINTMENT_ENDTIME_KEY,
				upcomingAppointmentDetails.getApptEndTime());
		
		xmlFileContent = createXMLFileContent(xmlFileContent,
				UpcomingAppointmentDetailsConstant.FACILITY_ID,
				upcomingAppointmentDetails.getFacilityId());
		
		xmlFileContent = createXMLFileContent(xmlFileContent,
				UpcomingAppointmentDetailsConstant.FACILITY_NAME,
				upcomingAppointmentDetails.getFacilityName());
		
		xmlFileContent = createXMLFileContent(xmlFileContent,
				UpcomingAppointmentDetailsConstant.LOCATION_KEY,
				upcomingAppointmentDetails.getLocation());
		
		xmlFileContent = createXMLFileContent(xmlFileContent,
				UpcomingAppointmentDetailsConstant.STATUS,
				upcomingAppointmentDetails.getStatus());
		
		xmlFileContent.append("</").append(UpcomingAppointmentDetailsConstant.APPOINTMENTDETAIL_KEY).append(">");
		return xmlFileContent;
	}
}
