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
package portalrefimpl.contactreason.rescheduleapptrequest.svc;

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
import portalrefimpl.contactreason.ContactReasonConstants;
import portalrefimpl.contactreason.rescheduleapptrequest.bc.ContactReasonBC;
import portalrefimpl.contactreason.rescheduleapptrequest.request.ContactReasonRequest;
import portalrefimpl.contactreason.rescheduleapptrequest.response.ContactReasonResponse;

/**
 * This is the service implementation class for getting the contact reasons
 * in the reschedule appointment request flow
 * This class extends BaseServiceImpl and implements the business interface
 * ContactReasonSvc and JAX-WS interface Provider
 * @author GRamamoorthy
 *
 */
@WebServiceProvider
public class ContactReasonSvcImpl extends BaseServiceImpl implements
		ContactReasonSvc, Provider<Source> {

	/**
	 * This method registers the HTTP URL for this service
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String serviceURL = PortalHelper
				.getWebServiceURL(PortalConstants.RESCHEDULE_APPT_REQ_CONTACT_REASON_WS_URL_KEY);
		e.publish(serviceURL);
	}

	/**
	 * This method validates the request
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);
		
		ContactReasonResponse response = new ContactReasonResponse();
		// there is nothing more to validate as the request
		// has only optional parameters
		// if basic validation fails return the response
		if(!validationResponse.isSuccessful()){
			response.addAllErrors(validationResponse.getErrors());
			return response;
		}
		// validation has passed - set success error info to the response
		response.addError(ErrorInfo.SUCCESS_CODE, null);
		return response;
	}

	/**
	 * This is the main method in this web service
	 * this method is invoked when the HTTP URL for this service
	 * is accessed
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		ContactReasonResponse response = null;
		
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String)mc.get(MessageContext.QUERY_STRING);
			Map<String, String> parameterMap = getRequestParameterMap(path);
			/*ContactReasonForCancelApptRequest request = getRequest(parameterMap);
			response = getContactReasons(request);*/
			ContactReasonRequest request = getRequest(parameterMap);
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
			response = new ContactReasonResponse();
			response = new ContactReasonResponse();
			response.addError(errorInfo);
		}
		
		// get the response stream		
		reply = getServiceResponseAsStreamSource(response,
				CommonConstants.RESCHEDULE_APPTREQUEST_CONTACTREASON_SVC_NAME_KEY);
		
		return reply;
	}

	/**
	 * This is the main business method in this service
	 * This method gets the contact reasons 
	 */
	public ContactReasonResponse getContactReasons(ContactReasonRequest request) {
		// first validate the request and check for its success
		// if it is not return the response
		ContactReasonResponse response = (ContactReasonResponse)isValidRequest(request);
		if(!response.isSuccessful()){
			return response;
		}
		
		// call the bc instance and get the contact reasons
		ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");
		ContactReasonBC bcInst = (ContactReasonBC)context.getBean("refRescheduleApptReqContactReasonBC");
		response = bcInst.getContactReasons(request);
		
		return response;
	}
	
	/**
	 * This method forms an instance of contact reason request object and returns the same
	 * @param parameterMap
	 * @return
	 */
	private ContactReasonRequest getRequest(Map<String, String> parameterMap){
		ContactReasonRequest request = new ContactReasonRequest();
		
		// set the portal user name to the request first
		if (parameterMap
				.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)) {
			String portalKeyValue = parameterMap
					.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			request.setPortalUserName(portalKeyValue);
		}
		
		// reason code - this is only optional
		if (parameterMap
				.containsKey(ContactReasonConstants.APPT_REQ_REASONCODE_PARAM)) {
			String reasonCode = parameterMap
					.get(ContactReasonConstants.APPT_REQ_REASONCODE_PARAM);
			request.setReasonCode(reasonCode);
		}
		
		// reason description- this is only optional
		if (parameterMap
				.containsKey(ContactReasonConstants.APPT_REQ_REASONDESCRIPTION_PARAM)) {
			String reasonDesc = parameterMap
					.get(ContactReasonConstants.APPT_REQ_REASONDESCRIPTION_PARAM);
			request.setReasonDescription(reasonDesc);
		}
		
		// language is optional 
		if(parameterMap.containsKey(CommonConstants.LANGUAGE_WS_PARAMETER_KEY)){
			String language =  parameterMap
					.get(CommonConstants.LANGUAGE_WS_PARAMETER_KEY);
			request.setLocale(language);
		}
		
		return request;
	}
	

}
