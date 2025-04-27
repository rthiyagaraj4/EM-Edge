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
package portalrefimpl.schedule.apptrequestdetails.svc;

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
import portalrefimpl.schedule.apptrequestdetails.bc.DetailsBC;
import portalrefimpl.schedule.apptrequestdetails.request.DetailsRequest;
import portalrefimpl.schedule.apptrequestdetails.response.DetailsResponse;
import portalrefimpl.schedule.rescheduleappointment.RescheduleRequestConstants;

/**
 * This is the implementation class for 
 * get the appointment request details service
 * This class extends BaseServiceImpl and implements the interfaces
 * DetailsSvc and Provider
 * @author GRamamoorthy
 *
 */
@WebServiceProvider
public class DetailsSvcImpl extends BaseServiceImpl implements DetailsSvc,
		Provider<Source> {

	/**
	 * This method registers this service with end point 
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String webServiceUrl = PortalHelper
				.getWebServiceURL(PortalConstants.GET_APPTREQDETAILS_WS_URL_KEY);
		e.publish(webServiceUrl);
	}

	/**
	 * This method validates the request
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);
		
		DetailsResponse response = new DetailsResponse();
		// if basic validation has failed, then set these errors to response
		if(!validationResponse.isSuccessful()){
			response.addAllErrors(validationResponse.getErrors());
		}
		
		// now validate the request - validate patient id and reference number
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// safely cast 
		DetailsRequest detailsRequest = (DetailsRequest)request;
		String patientId = detailsRequest.getPatientId();
		if(patientId == null || patientId.trim().equals("")){
			errorCode = RescheduleRequestConstants.GET_APPTREQUESTDETAILS_INVALIDPATIENTID_ERRORCODE;
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
		}
		
		String refNumber = detailsRequest.getApptRequestReferenceNumber();
		if(refNumber == null || refNumber.trim().equals("")){
			errorCode = RescheduleRequestConstants.GET_APPTREQUESTDETAILS_INVALIDREFNUMBER_ERRORCODE;
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
		}
		
		// finally if all validations pass, set the response as positive
		if(!response.hasErrors()){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
		}
		
		return response;
	}

	/**
	 * This is the main method in this web service
	 * This method is invoked when the HTTP URL for this web service
	 * is accessed
	 * This method in turn calls the business method getApptRequestDetails()
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		// initialize the response object
		DetailsResponse response = null;
		
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			Map<String, String> parameterMap = getRequestParameterMap(path);
			DetailsRequest detailsRequest = getDetailsRequest(parameterMap);
			response = getApptRequestDetails(detailsRequest);
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
							new Object[] { CommonConstants.RESCHEDULE_APPTREQUEST_DETAILS_SVC_NAME_KEY });
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response = new DetailsResponse();
			response.addError(errorInfo);
		}
		
		/*xmlFileContent = getResponseXMLString(response);
		// form the reply object and return it
		reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(response,
				CommonConstants.RESCHEDULE_APPTREQUEST_DETAILS_SVC_NAME_KEY);
		
		return reply;
	}

	/**
	 * This is the main business method for this service
	 * This method gets the appointment request details
	 */
	public DetailsResponse getApptRequestDetails(DetailsRequest request) {
		// first validate the request
		DetailsResponse response = (DetailsResponse)isValidRequest(request);
		if(!response.isSuccessful()){
			return response;
		}
		
		// next get the data through the BC class 
		ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");
		DetailsBC bcInst = (DetailsBC)context.getBean("refGetApptReqDetailsBC");
		response = bcInst.getApptRequestDetails(request);
		
		return response;
	}
	
	/**
	 * This method gets the details request 
	 * @param parameterMap
	 * @return
	 */
	private DetailsRequest getDetailsRequest(Map<String, String> parameterMap) {
		DetailsRequest detailsRequest = new DetailsRequest();
		// patient id
		if (parameterMap
				.containsKey(PortalConstants.PATIENTID_REQUEST_PARAM_KEY)) {
			String patientId = parameterMap
					.get(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
			detailsRequest.setPatientId(patientId);
		}

		// reference number
		if (parameterMap
				.containsKey(RescheduleRequestConstants.GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY)) {
			String referenceNumber = parameterMap
					.get(RescheduleRequestConstants.GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY);
			detailsRequest.setApptRequestReferenceNumber(referenceNumber);
		}

		// portal user name
		if (parameterMap
				.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)) {
			String portalUserName = parameterMap
					.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			detailsRequest.setPortalUserName(portalUserName);
		}

		return detailsRequest;
	}
	

}
