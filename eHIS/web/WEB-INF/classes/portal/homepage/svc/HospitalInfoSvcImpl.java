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
import portal.homepage.bc.HospitalInfoBC;
import portal.homepage.response.HospitalInfoResponse;
import portal.result.viewtestresultreport.svc.TestReportSvcImpl;
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
public class HospitalInfoSvcImpl extends BaseServiceImpl implements HospitalInfoSvc, Provider<Source>{
	
	private static Logger logger = Logger.getLogger(HospitalInfoSvcImpl.class
			.getName());
	@Resource
    protected WebServiceContext wsContext;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public HospitalInfoResponse getHospitalInformation(BaseRequest request){
		
		// initialize the BC class and get the data from it
		// this initialization is done only for test purpose
		// once this works, the bean instance will be obtained from
		// spring framework
		logger.info("Entering the method getHospitalInformation");
		HospitalInfoResponse response = null;
		HospitalInfoBC inst = (HospitalInfoBC)context.getBean("hospitalInfoBC");
		response = inst.getHospitalInformation(request);
		logger.debug("Error Info is:" + response.getErrorInfo().toString());
		logger.info("Leaving the method getHospitalInformation");
		return response;
	}

	
	/**
	 * 
	 */
	public Source invoke(Source request) {
		logger.info("Invoking the service with request :" + request);
		StreamSource reply = null;
		HospitalInfoResponse hospitalResponse = new HospitalInfoResponse();
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String)mc.get(MessageContext.QUERY_STRING);
			logger.debug("Path is  :" + path);
			
			// get the parameters from the URL path
			BaseRequest baseRequest = formRequestFromPath(path);
			logger.debug("Request formed after formRequestFromPath :"
					+ baseRequest.toString());
			hospitalResponse = (HospitalInfoResponse)isValidRequestor(baseRequest);
			logger.debug("Is respoinse Valid :" + hospitalResponse.isValid());
			if(hospitalResponse.isValid())
			{
				hospitalResponse = getHospitalInformation(baseRequest);
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
		HospitalInfoResponse response = new HospitalInfoResponse();
		BaseRequest brequest = (BaseRequest)request;
		response.setValid(true);
		
		// if portalUserName is null
		if(isEmptyOrNull(brequest.getPortalUserName()) ){
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
		String hospitalInfoUrl = PortalHelper.getWebServiceURL(PortalConstants.HOSPITAL_INFO_WS_URL_KEY);
		e.publish(hospitalInfoUrl);
		logger.info("URL is published");
	}
	
	private BaseRequest formRequestFromPath(String path) {
		logger.info("Entered the method formRequestFromPath");
		BaseRequest request = new BaseRequest();
		
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
	private void setRequestParams(BaseRequest request,
			Map<String, String> parameterMap) {
		// no additional parameters
	}

	/**
	 * This method is used to convert response object to XML string
	 * @param response
	 * @return
	 */
	private String getXMLFile(HospitalInfoResponse response) {

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
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.RESIDENT_AREA_NAME_KEY, response.getResidentAreaName());
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.RESIDENT_TOWN_NAME_KEY, response.getResidentTownName());
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.REGION_NAME_KEY, response.getRegionName());
				xmlFileContent = createXMLFileContent(xmlFileContent, HospitalKeyConstants.PINCODE_KEY, response.getPincode());
			
				xmlFileContent.append("</").append(HospitalKeyConstants.HOSPITAL_DETAILS_KEY).append(">");
			}
		}
		return xmlFileContent.toString();
	
	}
}
