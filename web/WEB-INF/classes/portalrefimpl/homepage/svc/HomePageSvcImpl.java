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
package portalrefimpl.homepage.svc;

import java.text.MessageFormat;
import java.util.Date;
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
import portalrefimpl.common.model.Address;
import portalrefimpl.common.model.ContactDetails;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.request.ValidationRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.response.ValidationResponse;
import portalrefimpl.common.svc.BaseServiceImpl;
import portalrefimpl.homepage.HomePageConstants;
import portalrefimpl.homepage.bc.HomePageBC;
import portalrefimpl.homepage.request.HospitalDetailsRequest;
import portalrefimpl.homepage.request.PatientDetailsRequest;
import portalrefimpl.homepage.response.HospitalDetailsResponse;
import portalrefimpl.homepage.response.PatientDetailsResponse;

/**
 * This is the home page service implementation class
 * 
 * @author gramamoorthy
 * 
 */
@WebServiceProvider
public class HomePageSvcImpl extends BaseServiceImpl implements HomePageSvc,
		Provider<Source> {

	/**
	 * This method registers a http url with the end point there by making this
	 * service accessible
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String serviceURL = PortalHelper
				.getWebServiceURL(PortalConstants.HOMEPAGE_WS_URL_KEY);
		e.publish(serviceURL);
	}

	/**
	 * This method validates the request - checks if it contains the portal user
	 * name
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		/*
		 * BaseResponse response = new BaseResponse(); ErrorInfo errorInfo = new
		 * ErrorInfo(); errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE); String
		 * errorMessage = ""; errorInfo.setErrorMessage(errorMessage);
		 * 
		 * response.setErrorInfo(errorInfo); if(request == null){
		 * errorInfo.setErrorCode(ErrorInfo.NULL_REQUEST_ERRORCODE);
		 * errorMessage = MessageContainer.getInstance().getDisplayMessage(
		 * CommonConstants.COMMON_MODULE_NAME,
		 * ErrorInfo.NULL_REQUEST_ERRORCODE); } String portalUserName =
		 * request.getPortalUserName(); if(portalUserName == null ||
		 * portalUserName.trim().equals("")){ errorMessage =
		 * MessageContainer.getInstance().getDisplayMessage(
		 * CommonConstants.COMMON_MODULE_NAME,
		 * ""+ErrorInfo.PORTALUSER_NOTPRESENT_ERRORCODE); }
		 */

		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);

		BaseResponse response = new BaseResponse();
		response.addAllErrors(validationResponse.getErrors());
		//response.setErrorInfo(validationResponse.getErrorInfo());
		return response;
	}

	/**
	 * This method gets the patient details given the patient request
	 * 
	 */
	public PatientDetailsResponse getPatientDetails(
			PatientDetailsRequest patientDetailsRequest) {
		// initialize the response object
		PatientDetailsResponse patientDetailsResponse = new PatientDetailsResponse();

		// // first step
		// validate the request for the common portal user name
		BaseResponse baseResponse = isValidRequest(patientDetailsRequest);
		if (!baseResponse.isSuccessful()) {
			patientDetailsResponse.addAllErrors(baseResponse.getErrors());
		}
		/*
		 * if(ErrorInfo.SUCCESS_CODE !=
		 * baseResponse.getErrorInfo().getErrorCode()){ patientDetailsResponse =
		 * new PatientDetailsResponse();
		 * patientDetailsResponse.setErrorInfo(baseResponse.getErrorInfo());
		 * return patientDetailsResponse; }
		 */
		// validate the other parameters in the request
		PatientDetailsResponse validatedResponse = validatePatientDetailsRequest(patientDetailsRequest);
		if (!validatedResponse.isSuccessful()) {
			patientDetailsResponse.addAllErrors(validatedResponse.getErrors());
		}

		// this is needed in the positive case where both the above validations
		// were successful - in that case, hospital response object will not
		// have even one - check that and then return the response
		// if there are failure in it
		if (patientDetailsResponse.hasErrors()
				&& !patientDetailsResponse.isSuccessful()) {
			return patientDetailsResponse;
		}

		/*
		 * if (ErrorInfo.SUCCESS_CODE != patientDetailsResponse.getErrorInfo()
		 * .getErrorCode()) { return patientDetailsResponse; }
		 */

		// second step
		// initialize the BC class and get the data from it
		// this initialization is done only for test purpose
		// once this works, the bean instance will be obtained from
		// spring framework
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-beans.xml");
		HomePageBC homePageBCInst = (HomePageBC) context
				.getBean("refHomePageBC");
		patientDetailsResponse = homePageBCInst
				.getPatientDetails(patientDetailsRequest);
		return patientDetailsResponse;
	}

	/**
	 * This method validates the patient request
	 * 
	 * @param patientDetailsRequest
	 * @return
	 */
	private PatientDetailsResponse validatePatientDetailsRequest(
			PatientDetailsRequest patientDetailsRequest) {
		// initialize the response object
		PatientDetailsResponse patientDetailsResponse = new PatientDetailsResponse();
		ErrorInfo errorInfo = null;
		/*errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		patientDetailsResponse.setErrorInfo(errorInfo);*/
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;

		// validate the patient id - this alone needs to be
		// validated in the request
		String patientId = patientDetailsRequest.getPatientId();
		if (patientId == null || patientId.trim().equals("")) {
			errorCode = HomePageConstants.PATIENT_DETAILS_INVALID_PATIENTID_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.HOMEPAGE_MODULE_NAME, errorCode);
		}
		
		errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMessage);
		patientDetailsResponse.addError(errorInfo);
		/*errorInfo.setErrorMessage(errorMessage);*/
		return patientDetailsResponse;
	}

	/**
	 * This method gets the hospital details
	 */
	public HospitalDetailsResponse getHospitalDetails(
			HospitalDetailsRequest hospitalDetailsRequest) {
		HospitalDetailsResponse hospitalDetailsResponse = new HospitalDetailsResponse();
		// first step
		// validate the request for the common portal user name
		BaseResponse baseResponse = isValidRequest(hospitalDetailsRequest);
		if (!baseResponse.isSuccessful()) {
			hospitalDetailsResponse.addAllErrors(baseResponse.getErrors());
		}
		/*
		 * if(ErrorInfo.SUCCESS_CODE !=
		 * baseResponse.getErrorInfo().getErrorCode()){ hospitalDetailsResponse
		 * = new HospitalDetailsResponse();
		 * hospitalDetailsResponse.setErrorInfo(baseResponse.getErrorInfo());
		 * return hospitalDetailsResponse; }
		 */
		// validate the other parameters in the request
		HospitalDetailsResponse validatedResponse = validateHospitalDetails(hospitalDetailsRequest);
		if (!validatedResponse.isSuccessful()) {
			hospitalDetailsResponse.addAllErrors(validatedResponse.getErrors());
		}

		// this is needed in the positive case where both the above validations
		// were successful - in that case, hospital response object will not
		// have even one - check that and then return the response
		// if there are failure in it
		if (hospitalDetailsResponse.hasErrors()
				&& !hospitalDetailsResponse.isSuccessful()) {
			return hospitalDetailsResponse;
		}
		/*
		 * if (ErrorInfo.SUCCESS_CODE != hospitalDetailsResponse.getErrorInfo()
		 * .getErrorCode()) { return hospitalDetailsResponse; }
		 */

		// second step
		// initialize the BC class and get the data from it
		// this initialization is done only for test purpose
		// once this works, the bean instance will be obtained from
		// spring framework
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-beans.xml");
		HomePageBC homePageBCInst = (HomePageBC) context
				.getBean("refHomePageBC");
		hospitalDetailsResponse = homePageBCInst
				.getHospitalDetails(hospitalDetailsRequest);
		return hospitalDetailsResponse;
	}

	/**
	 * This method validates the hospital details request object
	 * 
	 * @param hospitalDetailsRequest
	 * @return
	 */
	private HospitalDetailsResponse validateHospitalDetails(
			HospitalDetailsRequest hospitalDetailsRequest) {
		HospitalDetailsResponse hospitalDetailsResponse = new HospitalDetailsResponse();
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		String errorMessage = "";
		// hospitalDetailsResponse.setErrorInfo(errorInfo);
		// validate the facility id - this only needs to be validated for
		// this request
		// this validation is not needed
		/*
		 * String facilityId = hospitalDetailsRequest.getFacilityId();
		 * if(facilityId == null || facilityId.trim().equals("")){ errorInfo
		 * .setErrorCode
		 * (HomePageConstants.HOSPITALDETAILS_REQUESTINVALID_ERRORCODE);
		 * errorMessage = MessageContainer.getInstance().getDisplayMessage(
		 * CommonConstants.HOMEPAGE_MODULE_NAME,
		 * HomePageConstants.HOSPITALDETAILS_REQUESTINVALID_ERRORCODE); }
		 */
		errorInfo.setErrorMessage(errorMessage);
		hospitalDetailsResponse.addError(errorInfo);
		return hospitalDetailsResponse;
	}

	/**
	 * This is the main method in this class This method gets invoked when this
	 * service is called
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		String xmlFileContent = "";
		String webServiceName = null;
		
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);

			Map<String, String> parameterMap = getRequestParameterMap(path);
			String methodName = parameterMap.get(HomePageConstants.METHOD_NAME);

			if (HomePageConstants.GETHOSPITALDETAILS_METHOD_KEY
					.equalsIgnoreCase(methodName)) {
				webServiceName = CommonConstants.HOSPITAL_DETAILS_SVC_NAME_KEY;
				HospitalDetailsRequest hospitalDetailsRequest = getHospitalDetailsRequest(parameterMap);
				HospitalDetailsResponse hospitalDetailsResponse = getHospitalDetails(hospitalDetailsRequest);

				xmlFileContent = getHospitalDetailsResponseXML(hospitalDetailsResponse);
				
			} else if (HomePageConstants.GETPATIENTDETAILS_METHOD_KEY
					.equalsIgnoreCase(methodName)) {
				webServiceName = CommonConstants.PATIENT_DETAILS_SVC_NAME_KEY;
				PatientDetailsRequest patientDetailsRequest = getPatientDetailsRequest(parameterMap);
				PatientDetailsResponse patientDetailsResponse = getPatientDetails(patientDetailsRequest);

				xmlFileContent = getPatientDetailsResponseXML(patientDetailsResponse);
			}
		} catch (Exception e) {
			// need to form an error info object as the xml output here
			int errorCode = CommonConstants.WEBSERVICE_EXCEPTION_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			// there is a need to fill in the web service
			// name in the error message using format
			if(webServiceName == null){
				webServiceName = "";
			}
			errorMessage = MessageFormat
					.format(errorMessage,
							new Object[] { webServiceName });
			StringBuffer xmlContentBuff = new StringBuffer();
			xmlContentBuff
					.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
			createErrorResponse(errorMessage, errorCode, xmlContentBuff);
			xmlFileContent = xmlContentBuff.toString();
		}
		// form the reply object and return it
		/*reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(xmlFileContent,
				webServiceName);
		
		return reply;
	}

	/**
	 * This method gets the request object for getting hospital details
	 * 
	 * @return
	 */
	private HospitalDetailsRequest getHospitalDetailsRequest(
			Map<String, String> parameterMap) {
		HospitalDetailsRequest hospitalDetailsRequest = new HospitalDetailsRequest();

		// portal user is obtained
		if (parameterMap
				.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)) {
			String portalUser = parameterMap
					.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			hospitalDetailsRequest.setPortalUserName(portalUser);
		}
		// facility id is obtained next
		if (parameterMap
				.containsKey(PortalConstants.FACILITYID_REQUEST_PARAM_KEY)) {
			String facilityId = parameterMap
					.get(PortalConstants.FACILITYID_REQUEST_PARAM_KEY);
			hospitalDetailsRequest.setFacilityId(facilityId);
		}

		return hospitalDetailsRequest;
	}

	/**
	 * This method forms and returns the patient details request object from the
	 * http url request
	 * 
	 * @param parameterMap
	 * @return
	 */
	private PatientDetailsRequest getPatientDetailsRequest(
			Map<String, String> parameterMap) {
		PatientDetailsRequest patientDetailsRequest = new PatientDetailsRequest();
		// patient id is obtained first
		if (parameterMap
				.containsKey(PortalConstants.PATIENTID_REQUEST_PARAM_KEY)) {
			String patientId = parameterMap
					.get(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
			patientDetailsRequest.setPatientId(patientId);
		}

		// portal user is obtained next
		if (parameterMap
				.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)) {
			String portalUser = parameterMap
					.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			patientDetailsRequest.setPortalUserName(portalUser);
		}

		return patientDetailsRequest;
	}

	/**
	 * This method returns a xml string containing the patient details response
	 * object contents
	 * 
	 * @param patientDetailsResponse
	 * @return
	 */
	private String getPatientDetailsResponseXML(
			PatientDetailsResponse patientDetailsResponse) {
		// buffer containing the xml response
		StringBuffer xmlContentBuff = new StringBuffer();
		xmlContentBuff
				.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		// safe check first
		if (patientDetailsResponse == null) {
			int errorCode = CommonConstants.NULLRESPONSE_ERROR_CODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			/**
			 * TODO there might be a need to format the error message since the
			 * service name needs to be passed
			 */
			/*createErrorResponse(errorMessage, errorCode, xmlContentBuff);*/
			populateXMLForErrorResponse(errorMessage, errorCode, xmlContentBuff);
			return xmlContentBuff.toString();
		}
		// check if the response has error info filled with error code and
		// message
		// if so, the xml content will contain only the error message
		if(!patientDetailsResponse.isSuccessful()){
			String errorContent = getErrorsInResponseAsXML(patientDetailsResponse);
			xmlContentBuff.append(errorContent);
			return xmlContentBuff.toString();
		}
		
		/*ErrorInfo errorInfo = patientDetailsResponse.getErrorInfo();
		if (errorInfo == null
				|| (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode())) {
			int errorCode = 0;
			String errorMessage = "";
			if (errorInfo == null) {
				errorCode = CommonConstants.NULLRESPONSE_ERROR_CODE;
			} else {
				errorCode = errorInfo.getErrorCode();
			}
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			createErrorResponse(errorMessage, errorCode, xmlContentBuff);
			return xmlContentBuff.toString();
		}*/

		// now the response is a success response - so process the response
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(HomePageConstants.PATIENT_DETAILS_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);

		// patient id is filled here
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(HomePageConstants.PATIENTID_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String patientId = patientDetailsResponse.getPatientId();
		if (patientId == null) {
			patientId = "";
		}
		xmlContentBuff.append(patientId);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(HomePageConstants.PATIENTID_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);

		// national id of patient
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(HomePageConstants.NATIIONALID_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String nationalId = patientDetailsResponse.getNationalId();
		if (nationalId == null) {
			nationalId = "";
		}
		xmlContentBuff.append(nationalId);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(HomePageConstants.NATIIONALID_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);

		// patient name
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(HomePageConstants.PATIENTNAME_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String patientName = patientDetailsResponse.getPatientName();
		if (patientName == null) {
			patientName = "";
		}
		xmlContentBuff.append(patientName);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(HomePageConstants.PATIENTNAME_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);

		// patient display name
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(HomePageConstants.PATIENT_DISPLAYNAME_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String displayName = patientDetailsResponse.getPatientDisplayName();
		if (displayName == null) {
			displayName = "";
		}
		xmlContentBuff.append(displayName);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(HomePageConstants.PATIENT_DISPLAYNAME_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);

		// patient sex
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(HomePageConstants.PATIENTSEX_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String sex = patientDetailsResponse.getSex();
		if (sex == null) {
			sex = "";
		}
		xmlContentBuff.append(sex);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(HomePageConstants.PATIENTSEX_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);

		// patient date of birth
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(HomePageConstants.DATEOFBIRTH_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		Date dateOfBirth = patientDetailsResponse.getDateOfBirth();
		if (dateOfBirth == null) {
			dateOfBirth = new Date();
		}
		xmlContentBuff.append(dateOfBirth);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(HomePageConstants.DATEOFBIRTH_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);

		// finally close the patient details
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(HomePageConstants.PATIENT_DETAILS_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);

		return xmlContentBuff.toString();
	}

	/**
	 * This method returns a xml string containing the hospital details response
	 * object contents
	 * 
	 * @param hospitalDetailsResponse
	 * @return
	 */
	private String getHospitalDetailsResponseXML(
			HospitalDetailsResponse hospitalDetailsResponse) {
		StringBuffer xmlContentBuff = new StringBuffer();

		xmlContentBuff
				.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		// safe check first - for null response
		if (hospitalDetailsResponse == null) {
			int errorCode = CommonConstants.NULLRESPONSE_ERROR_CODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			/**
			 * TODO there might be a need to format the error message since the
			 * service name needs to be passed
			 */
			populateXMLForErrorResponse(errorMessage, errorCode, xmlContentBuff);
			//createErrorResponse(errorMessage, errorCode, xmlContentBuff);
			return xmlContentBuff.toString();
		}
		// check if the response has error info filled with error code and
		// message
		// if so, the xml content will contain only the error message
		if(!hospitalDetailsResponse.isSuccessful()){
			String errorContent = getErrorsInResponseAsXML(hospitalDetailsResponse);
			xmlContentBuff.append(errorContent);
			return xmlContentBuff.toString();
		}
		/*ErrorInfo errorInfo = hospitalDetailsResponse.getErrorInfo();
		if (errorInfo == null
				|| (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode())) {
			int errorCode = 0;
			String errorMessage = "";
			if (errorInfo == null) {
				errorCode = CommonConstants.NULLRESPONSE_ERROR_CODE;
				errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
								errorCode);
			} else {
				errorCode = errorInfo.getErrorCode();
				errorMessage = errorInfo.getErrorMessage();
			}

			createErrorResponse(errorMessage, errorCode, xmlContentBuff);
			return xmlContentBuff.toString();
		}*/
		// response has data - process it
		// first comes the hospitaldetails tag - this is the tag
		// within which all hospital details will be housed
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(HomePageConstants.HOSPITALDETAILS_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);

		// facilityId
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(HomePageConstants.HOSPITALDETAILS_SITEID_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String siteId = hospitalDetailsResponse.getSiteId();
		if (siteId == null) {
			siteId = "";
		}
		xmlContentBuff.append(siteId);

		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(HomePageConstants.HOSPITALDETAILS_SITEID_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);

		// facility name
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(HomePageConstants.HOSPITALDETAILS_SITENAME_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String siteName = hospitalDetailsResponse.getSiteName();
		if (siteName == null) {
			siteName = "";
		}
		xmlContentBuff.append(siteName);

		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(HomePageConstants.HOSPITALDETAILS_SITENAME_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);

		// address is next
		Address address = hospitalDetailsResponse.getAddress();
		if (address != null) {
			xmlContentBuff.append(address.getXMLString());
		}

		// contact details come next
		ContactDetails contactDetails = hospitalDetailsResponse
				.getContactDetails();
		if (contactDetails != null) {
			xmlContentBuff.append(contactDetails.getXMLString());
		}

		// finally close the hospital details
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(HomePageConstants.HOSPITALDETAILS_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);

		return xmlContentBuff.toString();
	}

}
