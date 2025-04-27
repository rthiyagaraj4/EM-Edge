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

import org.w3c.dom.Document;

import portalrefimpl.PortalConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.serviceinvoker.AbstractServiceInvoker;
import portalrefimpl.common.serviceinvoker.XMLReaderIdentifier;
import portalrefimpl.common.svc.BaseService;
import portalrefimpl.contactreason.ContactReasonConstants;
import portalrefimpl.contactreason.rescheduleapptrequest.request.ContactReasonRequest;
import portalrefimpl.contactreason.rescheduleapptrequest.response.ContactReasonResponse;

/**
 * This is the service invoker class for getting the contact reasons
 * in the reschedule appointment request flow
 * This class extends abstract service invoker class
 * @author GRamamoorthy
 *
 */
public class ContactReasonServiceInvoker extends AbstractServiceInvoker {
	
	/**
	 * Default constructor of the class
	 */
	public ContactReasonServiceInvoker(){
		// set xmlReaderIdentifier to XMLReaderIdentifier.JAXB if JAXB
		// unmarshalling is expected
		xmlReaderIdentifier = XMLReaderIdentifier.JAXB;
	}

	/**
	 * This method returns the HTTP URL for the web service
	 */
	public String getWebServiceURL(BaseRequest request) {
		String serviceURL = PortalHelper
				.getWebServiceURL(PortalConstants.RESCHEDULE_APPT_REQ_CONTACT_REASON_WS_URL_KEY);
		return serviceURL;
	}

	/**
	 * This method returns the URL parameters for this service
	 */
	public String getURLParameters(BaseRequest request) {
		StringBuilder parameterBuffer = new StringBuilder();
		// portal user name
		String portalUserName = request.getPortalUserName();
		parameterBuffer.append(getCompleteParamString(
				PortalConstants.PORTALUSER_REQUEST_PARAM_KEY,
				portalUserName));
		parameterBuffer.append("&");
		
		// language optional
		String language = request.getLocale();
		if(language != null && !language.trim().equals("")){
			parameterBuffer.append(getCompleteParamString(
					CommonConstants.LANGUAGE_WS_PARAMETER_KEY, language));
			parameterBuffer.append("&");
		}
		
		ContactReasonRequest contactReasonRequest = (ContactReasonRequest) request;
		// reason code - optional
		String reasonCode = contactReasonRequest.getReasonCode();
		if(reasonCode != null && !reasonCode.trim().equals("")){
			parameterBuffer.append(getCompleteParamString(
					ContactReasonConstants.APPT_REQ_REASONCODE_PARAM, reasonCode));
			parameterBuffer.append("&");
		}
		
		// reason description - optional
		String reasonDesc = contactReasonRequest.getReasonDescription();
		if(reasonDesc != null && !reasonDesc.trim().equals("")){
			parameterBuffer.append(getCompleteParamString(
					ContactReasonConstants.APPT_REQ_REASONDESCRIPTION_PARAM, reasonDesc));
		}
		
		
		return parameterBuffer.toString();
	}

	/**
	 * This method returns an instance of the response object
	 */
	public BaseResponse getResponseObject() {
		return new ContactReasonResponse();
	}

	/**
	 * 
	 */
	public void readXMLContent(Document document, BaseResponse response) {
		// This method need not be implemented when we are doing JAXB
		// unmarshalling This method is implemented merely to satisfy the
		// contract

	}

	/**
	 * This method returns an instance of the service impl
	 */
	protected BaseService getServiceImpl() {
		return new ContactReasonSvcImpl();
	}
	
	/**
	 * This method enables a user to call the service as a normal java service
	 * @return
	 */
	public ContactReasonResponse getDataThroughService(ContactReasonRequest request){
		ContactReasonSvcImpl svcImpl = (ContactReasonSvcImpl)getServiceImpl();
		return svcImpl.getContactReasons(request);
	}
	
	
	/*public static void main(String[] args){
		ContactReasonRequest request = new ContactReasonRequest();
		request.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		
		ContactReasonServiceInvoker client = new ContactReasonServiceInvoker();
		//client.registerService(request);
		
		ContactReasonResponse response = (ContactReasonResponse)client.getDataThroughWebService(request);
		ContactReasonResponse response = (ContactReasonResponse)client.getDataThroughService(request);
		if(response.hasErrors() && response.isSuccessful()){
			System.out.println("response is obtained successfully");
			List<ContactReasonModel> contactReasonModelList = response.getContactReasonList();
			System.out.println("--------------------------------------------------------------");
			for(ContactReasonModel model : contactReasonModelList){
				System.out.println("reason code="+model.getCode()+";;description="+model.getDescription());
			}
		}else{
			System.out.println("could not get response - error message="+response.getErrorMessage());
		}
	}*/

}
