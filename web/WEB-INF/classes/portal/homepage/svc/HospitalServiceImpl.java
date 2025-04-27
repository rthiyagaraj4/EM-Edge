/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.homepage.svc;

import java.io.StringReader;
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
import portal.common.response.ErrorInfo;
import portal.common.response.ValidationResponse;
import portal.common.svc.BaseServiceImpl;
import portal.homepage.bc.HospitalDetailsBC;
import portal.homepage.request.HospitalRequest;
import portal.homepage.response.HospitalDetailsResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.HospitalKeyConstants;
import portal.tools.PortalConstants;
import portal.tools.PortalHelper;


/**
 * @author skrishnared2
 * This class can be made into a RESTful web service
 * by implementing Provider interface given by JAX-WS
 * This class is used to get the Hospital details
 * 
 */
@WebServiceProvider()
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class HospitalServiceImpl extends BaseServiceImpl implements HospitalService, Provider<Source>{
	
	private static Logger logger = Logger.getLogger(HospitalServiceImpl.class
			.getName());
	@Resource
    protected WebServiceContext wsContext;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public HospitalDetailsResponse getHospitalDetails(HospitalRequest request){
		
		// initialize the BC class and get the data from it
		// this initialization is done only for test purpose
		// once this works, the bean instance will be obtained from
		// spring framework
		logger.info("Entering the method getHospitalDetails");
		HospitalDetailsResponse response = null;
		HospitalDetailsBC inst = (HospitalDetailsBC)context.getBean("hospitalDetailsBC");
		response = inst.getHospitalDetails(request);
		logger.debug("Error Info is:" + response.getErrorInfo().toString());
		logger.info("Leaving the method getHospitalDetails");
		return response;
	}

	
	/**
	 * 
	 */
	public Source invoke(Source request) {
		logger.info("Invoking the service with request :" + request);
		StreamSource reply = null;
		HospitalDetailsResponse hospitalResponse = new HospitalDetailsResponse();
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String)mc.get(MessageContext.QUERY_STRING);
			logger.debug("Path is  :" + path);
			
			// get the parameters from the URL path
			HospitalRequest hospitalRequest = formRequestFromPath(path);
			logger.debug("Request formed after formRequestFromPath :"
					+ hospitalRequest.toString());
			hospitalResponse = (HospitalDetailsResponse)isValidRequestor(hospitalRequest);
			logger.debug("Is respoinse Valid :" + hospitalResponse.isValid());	
			if(hospitalResponse.isValid())
			{
				hospitalResponse = getHospitalDetails(hospitalRequest);
			}
			logger.debug("Response is :" + hospitalResponse.toString());
			String xmlFileContent = getXMLFile(hospitalResponse);
			logger.debug("XML response is :" + xmlFileContent);
			reply = new StreamSource(new StringReader(xmlFileContent));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reply;
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
		HospitalDetailsResponse response = new HospitalDetailsResponse();
		HospitalRequest hrequest = (HospitalRequest)request;
		response.setValid(true);
		
		// if portalUserName is null
		if(isEmptyOrNull(hrequest.getPortalUserName()) ){
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					HospitalKeyConstants.MODULE_NAME,
					ErrorInfo.HOSPITAL_INSUFFICIENT_REQUEST_PARAMETERS_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		} else if (!super.isValidRequestor(request).isValid()) { // if portalusername is not valid
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					HospitalKeyConstants.MODULE_NAME,
					ErrorInfo.HOSPITAL_INVALID_LOGIN_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		} 
		else if(isEmptyOrNull(hrequest.getFacilityId())) {  // if facitlyId 
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					HospitalKeyConstants.MODULE_NAME,
					ErrorInfo.HOSPITAL_INSUFFICIENT_REQUEST_PARAMETERS_CODE);
			response.setErrorInfo(errorInfo);
			response.setValid(false);
		}
		logger.info("Leaving the method isValidRequestor :");
		return response;
	}
	/**
	 * This method registers the http URL for the service with
	 * the end point
	 * 
	 * @param request
	 */
	public void registerService(BaseRequest request) {
		logger.info("URL is registered");
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String hospitalDetailsUrl = PortalHelper.getWebServiceURL(PortalConstants.HOSPITAL_WS_URL_KEY);
		e.publish(hospitalDetailsUrl);
		logger.info("URL is published");
	}
	/**
	 * This method creates the request from parameters path
	 * @param path
	 * @return
	 */
	private HospitalRequest formRequestFromPath(String path) {
		logger.info("Entered the method formRequestFromPath");
		HospitalRequest request = new HospitalRequest();
		
		/* call to get the parameters to map */
		Map<String, String> parameterMap = getParametersFromRequest(path);
		logger.debug("parameterMap :" + parameterMap.toString());
		// now iterate through the hashmap and find the parameters
		if(parameterMap.isEmpty()){
			return request;
		}
		
		/* setting EM user */
		setPortalUserNameToRequest(request,parameterMap);
		
		/* setting request with Hospital parameters */
		setRequestParams(request, parameterMap);
		logger.info("leaving the method formRequestFromPath");		
		return request;
	}

	/**
	 * This method sets the parameters specific to hospital request
	 * @param request
	 * @param parameterMap
	 */
	private void setRequestParams(HospitalRequest request,
			Map<String, String> parameterMap) {
		logger.info("Entering the method setParamsToRequest");
		if(parameterMap.containsKey("facilityId")){
			request.setFacilityId(parameterMap.get("facilityId"));
		}
		logger.info("Leaving the method setParamsToRequest");
	}

	/**
	 * This method is used to convert response object to XML string
	 * @param response
	 * @return
	 */
	private String getXMLFile(HospitalDetailsResponse response) {

		StringBuffer xmlFileContent = new StringBuffer();
		xmlFileContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		// just a safe check - response can never be null but still handle it
		if(response == null){
			System.out.println("Empty response - so no file output");
			return "";
		}
		ErrorInfo errorInfo = response.getErrorInfo();
		if(errorInfo != null){
			int errorCode = errorInfo.getErrorCode();
			String errorMessage = null;
				errorMessage = errorInfo.getErrorMessage();
				if(ErrorInfo.SUCCESS_CODE != errorCode){
					xmlFileContent = createErrorResponse(errorMessage, errorCode, xmlFileContent);
				} else {
				// on success
				
				xmlFileContent.append("<").append(HospitalKeyConstants.HOSPITAL_DETAILS_KEY).append(">");
				
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.HOSPITAL_NAME_KEY, response.getHospitalName());
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.ADDRESSDETAILS_KEY, response.getAddressDetails());
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.COUNTRY_KEY, response.getCountry());
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.RESIDENT_AREA_NAME_KEY, response.getResidentAreaName());
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.RESIDENT_TOWN_NAME_KEY, response.getResidentTownName());
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.REGION_NAME_KEY, response.getRegionName());
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.PINCODE_KEY, response.getPincode());
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.PRIMARY_TELEPHONE_KEY, response.getPrimaryTelephoneNo());
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.FAX_NUMBER_KEY, response.getFaxNumber());
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.EMAILID_KEY, response.geteMailId());
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.WEBSITE_KEY, response.getWebsiteDetails());
				
				xmlFileContent.append("</").append(HospitalKeyConstants.HOSPITAL_DETAILS_KEY).append(">");
			}
		}
		return xmlFileContent.toString();
	
	}
}
