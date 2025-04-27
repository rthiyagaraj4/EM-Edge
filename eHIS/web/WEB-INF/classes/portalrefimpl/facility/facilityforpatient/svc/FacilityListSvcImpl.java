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
package portalrefimpl.facility.facilityforpatient.svc;

import java.text.MessageFormat;
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
import portalrefimpl.common.model.Facility;
import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.common.request.ValidationRequest;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.common.response.ValidationResponse;
import portalrefimpl.common.svc.BaseServiceImpl;
import portalrefimpl.facility.FacilityConstants;
import portalrefimpl.facility.facilityforpatient.bc.FacilityListBC;
import portalrefimpl.facility.facilityforpatient.request.FacilityListRequest;
import portalrefimpl.facility.facilityforpatient.response.FacilityListResponse;

/**
 * This is the service implementation class for facilityListSvc
 * This class implements the FacilityListSvc interface and extends
 * BaseServiceImpl
 * @author GRamamoorthy
 *
 */
@WebServiceProvider
public class FacilityListSvcImpl extends BaseServiceImpl implements
		FacilityListSvc, Provider<Source> {

	/**
	 * Registers the service with end point
	 */
	public void registerService(BaseRequest request) {
		Endpoint e = Endpoint
				.create(HTTPBinding.HTTP_BINDING, this);
		String serviceURL = PortalHelper
				.getWebServiceURL(PortalConstants.FACILITY_LIST_WS_URL_KEY);
		e.publish(serviceURL);
	}

	/**
	 *  This method validates the facility list request
	 */
	public BaseResponse isValidRequest(BaseRequest request) {
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setPortalUserName(request.getPortalUserName());
		ValidationResponse validationResponse = isValidRequestor(validationRequest);
		
		BaseResponse response = new BaseResponse();
		//response.setErrorInfo(validationResponse.getErrorInfo());
		if(!response.isSuccessful()){
			response.addAllErrors(validationResponse.getErrors());
		}
		
		// when code comes here, response has either got errors
		// or all the validation has passed
		// if all the validation has passed, then we need to set
		// a positive error
		if(!response.hasErrors()){
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			response.addError(errorInfo);
		}
		/*response.addAllErrors(validationResponse.getErrors());*/
		return response;
	}

	/**
	 * This method gets the facility list given the facility list 
	 * request object
	 */
	public FacilityListResponse getFacilityList(
			FacilityListRequest facilityListRequest) {
		// initialize the response
		FacilityListResponse facilityListResponse = new FacilityListResponse();
		
		// first step validate the request
		BaseResponse baseResponse = isValidRequest(facilityListRequest);
		if(!baseResponse.isSuccessful()){
			facilityListResponse.addAllErrors(baseResponse.getErrors());
			return facilityListResponse;
		}
		/*if(ErrorInfo.SUCCESS_CODE != baseResponse.getErrorInfo().getErrorCode()){
			facilityListResponse.setErrorInfo(baseResponse.getErrorInfo());
			return facilityListResponse;
		}*/
		
		// second step get the facility list
		ApplicationContext context = new ClassPathXmlApplicationContext("app-beans.xml");
		FacilityListBC bcInst = (FacilityListBC)context.getBean("refFacilityListBC");
		facilityListResponse = bcInst.getFacilityList(facilityListRequest);
		return facilityListResponse;
	}

	/**
	 * This is the main method in this service implementation
	 * This method gets invoked when the http URL for the service is hit
	 * This method in turn makes use of the getFacilityList() method to
	 * get the list of facilities
	 */
	public Source invoke(Source arg0) {
		StreamSource reply = null;
		String xmlFileContent = "";
		
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String)mc.get(MessageContext.QUERY_STRING);
			
			Map<String, String> parameterMap = getRequestParameterMap(path);
			FacilityListRequest facilityListRequest = getFacilityListRequest(parameterMap);
			FacilityListResponse facilityListResponse = getFacilityList(facilityListRequest);
			
			xmlFileContent = getFacilityListAsXML(facilityListResponse);
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
							new Object[] { CommonConstants.FACILITY_LIST_SVC_NAME_KEY });
			StringBuffer xmlContentBuff = new StringBuffer();
			xmlContentBuff
					.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
			createErrorResponse(errorMessage, errorCode, xmlContentBuff);
			xmlFileContent = xmlContentBuff.toString();
		}
		
		// form the reply object and return it
		/*reply = new StreamSource(new StringReader(xmlFileContent));*/
		
		reply = getServiceResponseAsStreamSource(xmlFileContent,
				CommonConstants.FACILITY_LIST_SVC_NAME_KEY);
		
		return reply;
	}
	
	/**
	 * This method forms the facilityListRequest object from the request
	 * parameters passed to the service
	 * @param parameterMap
	 * @return
	 */
	private FacilityListRequest getFacilityListRequest(
			Map<String, String> parameterMap) {
		FacilityListRequest facilityListRequest = new FacilityListRequest();
		// portal user is obtained
		if (parameterMap
				.containsKey(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY)) {
			String portalUser = parameterMap
					.get(PortalConstants.PORTALUSER_REQUEST_PARAM_KEY);
			facilityListRequest.setPortalUserName(portalUser);
		}
		
		if (parameterMap
				.containsKey(FacilityConstants.FACILITY_FORPATIENT_RECORDCOUNT_REQUEST_PARAM)) {
			String recordCntStr = parameterMap
					.get(FacilityConstants.FACILITY_FORPATIENT_RECORDCOUNT_REQUEST_PARAM);
			int recordCnt = PortalHelper.getIntegerValue(recordCntStr, 0);
			facilityListRequest.setRecordCount(recordCnt);
		}
		
		return facilityListRequest;
	}
	
	/**
	 * 
	 * @param facilityListResponse
	 * @return
	 */
	private String getFacilityListAsXML(FacilityListResponse facilityListResponse){
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		
		/*ErrorInfo errorInfo = facilityListResponse.getErrorInfo();
		int errorCode = errorInfo.getErrorCode();
		String errorMessage = errorInfo.getErrorMessage();
		// this implies erroneous response
		if(ErrorInfo.SUCCESS_CODE != errorCode){
			createErrorResponse(errorMessage, errorCode, xmlBuffer);
			return xmlBuffer.toString();
		}*/
		
		// check if the response has error info filled with error code and
		// message
		// if so, the xml content will contain only the error message
		if(!facilityListResponse.isSuccessful()){
			String errorContent = getErrorsInResponseAsXML(facilityListResponse);
			xmlBuffer.append(errorContent);
			return xmlBuffer.toString();
		}
		
		
		// success scenario
		// start off with the over all facilities tag
		xmlBuffer.append(getXMLStartTag(FacilityConstants.FACILITIES_XML_TAG));
		
		// get the facility list, iterate through the list and add individual
		// facility
		List<Facility> facilityList = facilityListResponse.getFacilityList();
		String facilityId = null;
		String facilityName = null;
		for(Facility facility : facilityList){
			// facility information will be housed inside "facility" tag
			xmlBuffer.append(getXMLStartTag(FacilityConstants.FACILITY_XML_TAG));
			// add facility id
			xmlBuffer.append(getXMLStartTag(FacilityConstants.FACILITYID_XML_TAG));
			facilityId = facility.getFacilityId();
			if(facilityId == null){
				facilityId = "";
			}
			xmlBuffer.append(facilityId);
			xmlBuffer.append(getXMLEndTag(FacilityConstants.FACILITYID_XML_TAG));
			// add facility name
			xmlBuffer.append(getXMLStartTag(FacilityConstants.FACILITYNAME_XML_TAG));
			facilityName = facility.getFacilityName();
			if(facilityName == null){
				facilityName = "";
			}
			xmlBuffer.append(facilityName);
			xmlBuffer.append(getXMLEndTag(FacilityConstants.FACILITYNAME_XML_TAG));
			
			// close the facility tag
			xmlBuffer.append(getXMLEndTag(FacilityConstants.FACILITY_XML_TAG));
		}
		
		// finally close the facilities xml
		xmlBuffer.append(getXMLEndTag(FacilityConstants.FACILITIES_XML_TAG));
		
		return xmlBuffer.toString();
	}
	

}
