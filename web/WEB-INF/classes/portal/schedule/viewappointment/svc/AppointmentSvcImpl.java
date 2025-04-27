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
package portal.schedule.viewappointment.svc;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

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

import portal.common.request.BaseRequest;
import portal.common.request.PatientRequest;
import portal.common.request.ValidationRequest;
import portal.common.response.ErrorInfo;
import portal.common.response.ValidationResponse;
import portal.common.svc.BaseServiceImpl;
import portal.schedule.viewappointment.bc.AppointmentDetailsBC;
import portal.schedule.viewappointment.request.AppointmentDetailsRequest;
import portal.schedule.viewappointment.response.AppointmentDetails;
import portal.schedule.viewappointment.response.AppointmentDetailsResponse;
import portal.tools.AppointmentDetailConstant;
import portal.tools.ErrorMessageUtil;
import portal.tools.PortalConstants;
import portal.tools.PortalHelper;



/**
 * @author Vkodancha
 * This class can be made into a RESTful web service
 * by implementing Provider interface given by JAX-WS
 * This class is used to get the appointment details 
 * on the patient portal home page
 * 
 */
@WebServiceProvider()    
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class AppointmentSvcImpl extends BaseServiceImpl implements AppointmentSvc,Provider<Source>{
	
	private static Logger logger = Logger.getLogger(AppointmentSvcImpl.class.getName());

	@Resource
    protected WebServiceContext wsContext;
	/**
	 * 
	 * This method is used to get the list of appointments for the patient
	 *  and hospital. The number of records will be sent as request
	 * @param request
	 * @return
	 */
	public AppointmentDetailsResponse getAppointmentDetails(AppointmentDetailsRequest request){
		logger.info("Entering the method getAppointmentDetails");
		AppointmentDetailsResponse response = null;
		AppointmentDetailsBC inst = (AppointmentDetailsBC)context.getBean("appointmentDetailsBC");
		response = inst.getAppointmentDetails(request);
		logger.info("Leaving the method getAppointmentDetails");
		return response;
	}

	/**
	 * 
	 */
	public Source invoke(Source request) {
		logger.info("invoking the Appointment service");
		StreamSource reply = null;
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String)mc.get(MessageContext.QUERY_STRING);
			
			logger.debug("Path is  :" + path);
			
			/**
			 * get the parameters from path
			 * parameters are expected to be known
			 */
			AppointmentDetailsRequest appointmentDetailsRequest = formRequestFromPath(path);
			logger.debug("Request formed after formRequestFromPath :"
					+ appointmentDetailsRequest.toString());
			AppointmentDetailsResponse appointmentDetailsResponse =  (AppointmentDetailsResponse)isValidRequestor(appointmentDetailsRequest);
			logger.debug("Is respoinse Valid :" + appointmentDetailsResponse.isValid());
			if(appointmentDetailsResponse.isValid()){	
				appointmentDetailsResponse = getAppointmentDetails(appointmentDetailsRequest);
			}
			logger.debug("Response is :" + appointmentDetailsResponse.toString());
			String xmlFileContent = getXMLFile(appointmentDetailsResponse);
			logger.debug("XML response is :" + xmlFileContent);
			reply = new StreamSource(new StringReader(xmlFileContent));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reply;
	}

	/**
	 * This method registers the http URL for the service with
	 * the end point
	 */
	@Override
	public void registerService(BaseRequest request) {
		logger.info("URL is registered");
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String appointmentDetailsUrl = PortalHelper.getWebServiceURL(PortalConstants.APPOINTMENTDETAILS_WS_URL_KEY);
		e.publish(appointmentDetailsUrl);
		logger.info("URL is published");
	}
	
	/**
	 * This method creates the appointment details request with URL parameters
	 * @param path
	 * @return
	 */
	private AppointmentDetailsRequest formRequestFromPath(String path){
		logger.info("formRequestFromPath : entered");
		AppointmentDetailsRequest request = new AppointmentDetailsRequest();
		PatientRequest patientInfo = new PatientRequest();
		request.setPatientInfo(patientInfo);
			
		Map<String, String> parameterMap = getParametersFromRequest(path);
		// now iterate through the hashmap and find the parameters
		if(parameterMap.isEmpty()){
			return request;
		}
		logger.info("formRequestFromPath : params Map :"+parameterMap.toString());
		/* call to update portal user name to rquest */
		setPortalUserNameToRequest(request,parameterMap);
		
		/* sets the URL parameters to request */
		setParamsToRequest(request, parameterMap);
		logger.info("formRequestFromPath : leaving");
		return request;
	}
	 /**
	  * This method updates the Parameters to request
	  * @param request
	  * @param parameterMap
	  */
	private void setParamsToRequest(AppointmentDetailsRequest request,
			Map<String, String> parameterMap) {
		logger.info("Entering the method setParamsToRequest");
		if(parameterMap.containsKey("patientId")){
			request.setPatientId(parameterMap.get("patientId"));
		}
		/*if(parameterMap.containsKey("facilityId")){
			request.setFacilityId(parameterMap.get("facilityId"));
		}*/
		if(parameterMap.containsKey("resultSetSize")){
				request.setResultSetSize(checkAndSetResultSize(parameterMap.get("resultSetSize")));
		}
		logger.info("Leaving the method setParamsToRequest");
	}
		/**
		 * Called from setParamsToRequest
		 * @param strNum
		 * @return
		 */
	private int checkAndSetResultSize(String strNum) {
		try {
			return Integer.parseInt(strNum);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}
	
	/**
	 * This method converts the response to XML string
	 * @param appointmentDetailsResponse
	 * @return
	 */
	private String getXMLFile(AppointmentDetailsResponse appointmentDetailsResponse){
		StringBuffer xmlFileContent = new StringBuffer();
		xmlFileContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		// just a safe check - response can never be null but still handle it
		if(appointmentDetailsResponse == null){
			System.out.println("Empty response - so no file output");
			return "";
		}
		ErrorInfo errorInfo = appointmentDetailsResponse.getErrorInfo();
			if(errorInfo != null){
				int errorCode = errorInfo.getErrorCode();
				String errorMessage = errorInfo.getErrorMessage();
				if(ErrorInfo.SUCCESS_CODE != errorCode){
				xmlFileContent = createErrorResponse(errorMessage, errorCode,
						xmlFileContent);
				}
				else{
				xmlFileContent.append("<").append(AppointmentDetailConstant.APPOINTMENTDETAILS_KEY).append(">");
				List<AppointmentDetails> appointmentDetailsList = appointmentDetailsResponse.getAppointmentDetailsList();
				if (appointmentDetailsList != null && !appointmentDetailsList.isEmpty()) {
					String practitioner = "";
					String speciality = "";
					String appointmentStartTime = null;
					String appointmentEndTime = null;
					String appointmentDate = null;
					String appointmentNumber =null;
					for(AppointmentDetails appointmentDetails : appointmentDetailsList){
						appointmentNumber = appointmentDetails.getApptNumber();
						practitioner = appointmentDetails.getPractitioner();
						speciality = appointmentDetails.getApptSpeciality();
						appointmentDate = appointmentDetails.getAppointmentDate();
						appointmentStartTime = appointmentDetails.getApptStartTime();
						appointmentEndTime = appointmentDetails.getApptEndTime();
						
						xmlFileContent.append("<").append(AppointmentDetailConstant.APPOINTMENTDETAIL_KEY).append(">");
						
						xmlFileContent = createXMLFileContent(xmlFileContent,
								AppointmentDetailConstant.APPOINTMENT_NUMBER,
								appointmentNumber);
						
						xmlFileContent = createXMLFileContent(xmlFileContent,
								AppointmentDetailConstant.PRACTITIONER_KEY,
								practitioner);
						
						xmlFileContent = createXMLFileContent(xmlFileContent,
								AppointmentDetailConstant.SPECIALITY_KEY,
								speciality);
						
						xmlFileContent = createXMLFileContent(xmlFileContent,
								AppointmentDetailConstant.APPOINTMENT_DATE,
								appointmentDate);
						
						xmlFileContent = createXMLFileContent(xmlFileContent,
								AppointmentDetailConstant.APPOINTMENT_STARTTIME_KEY,
								appointmentStartTime);
						
						xmlFileContent = createXMLFileContent(xmlFileContent,
								AppointmentDetailConstant.APPOINTMENT_ENDTIME_KEY,
								appointmentEndTime);
						
						xmlFileContent.append("</").append(AppointmentDetailConstant.APPOINTMENTDETAIL_KEY).append(">");
					}
				}
				
				xmlFileContent.append("</").append(AppointmentDetailConstant.APPOINTMENTDETAILS_KEY).append(">");
			}
		}
		return xmlFileContent.toString();
	}

	/**
	 * Validation of the input parameters
	 * @param request
	 * @return
	 */
	@Override	
	public ValidationResponse isValidRequestor(ValidationRequest request){
		logger.info("Entering the method isValidRequestor :"
				+ request.toString());
		AppointmentDetailsResponse response = new AppointmentDetailsResponse();
		AppointmentDetailsRequest arequest = (AppointmentDetailsRequest)request;
		response.setValid(true);
		if(!super.isValidRequestor(request).isValid()){
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					AppointmentDetailConstant.MODULE_NAME,
					ErrorInfo.HOME_APPT_INVALID_LOGIN_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		} 
		else if(isEmptyOrNull(arequest.getPatientId())) {
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					AppointmentDetailConstant.MODULE_NAME,
					ErrorInfo.HOME_APPT_INVALID_LOGIN_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		}
		logger.info("Leaving the method isValidRequestor :");
		return response;
	}

}
