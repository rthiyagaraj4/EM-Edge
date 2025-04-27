/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.facility.svc;

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
import portal.facility.bc.FacilityBC;
import portal.facility.request.FacilityRequest;
import portal.facility.response.Facility;
import portal.facility.response.FacilityResponse;
import portal.tools.ErrorMessageUtil;
import portal.tools.FacilityConstants;
import portal.tools.PortalConstants;
import portal.tools.PortalHelper;

/**
 * @author vkodancha
 * This class can be made into a RESTful web service
 * by implementing Provider interface given by JAX-WS
 * This class is used to get the Facilty details 
 * on the patient portal Test result Details page
 * 
 */
@WebServiceProvider()
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class FacilitySvcImpl extends BaseServiceImpl implements FacilitySvc,
		Provider<Source> {

	private static Logger logger = Logger.getLogger(FacilitySvcImpl.class
			.getName());

	@Resource
	protected WebServiceContext wsContext;
	/**
	 * This method is used to register the service against a URL
	 */
	@Override
	public void registerService(BaseRequest request) {
		logger.info("URL is registered");
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, this);
		String testResultsUrl = PortalHelper
				.getWebServiceURL(PortalConstants.FACILITY_WS_URL_KEY);
		e.publish(testResultsUrl);
		logger.info("URL is published");
	}
	/**
	 * This method is invoked when the service is called and it returns stream response
	 */
	@Override
	public Source invoke(Source request) {
		logger.info("Invoking the service with request :" + request);
		StreamSource reply = null;
		FacilityResponse response = new FacilityResponse();
		try {
			MessageContext mc = wsContext.getMessageContext();
			String path = (String) mc.get(MessageContext.QUERY_STRING);
			logger.debug("Path is  :" + path);
			/**
			 * get the parameters from path parameters are expected to be known
			 */
			FacilityRequest facilityRequest = formRequestFromPath(path);
			logger.debug("Request formed after formRequestFromPath :"
					+ facilityRequest.toString());
			response = (FacilityResponse) this
					.isValidRequestor(facilityRequest);
			logger.debug("Is respoinse Valid :" + response.isValid());
			if (response.isValid()) {
				response = getFacilities(facilityRequest);
			}
			logger.debug("Response is :" + response.toString());
			String xmlFileContent = getXMLFile(response);
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
	private FacilityRequest formRequestFromPath(String path) {
		logger.info("Entered the method formRequestFromPath");
		FacilityRequest request = new FacilityRequest();
		Map<String, String> parameterMap = getParametersFromRequest(path);

		logger.debug("parameterMap :" + parameterMap.toString());
		// now iterate through the hash map and find the parameters
		if (parameterMap.isEmpty()) {
			return request;
		}

		/* call to update portal user name to request */
		setPortalUserNameToRequest(request, parameterMap);

		/* sets the URL parameters to request */
		// request = setParamsToRequest(request, parameterMap);
		// no parameters apart from portal user name
		logger.info("leaving the method formRequestFromPath");
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
		FacilityResponse uresponse = new FacilityResponse();
		uresponse.setValid(true);

		if (!super.isValidRequestor(request).isValid()) { // if portalusername
															// is not valid
			ErrorInfo errorInfo = ErrorMessageUtil.getErrorMessage(
					FacilityConstants.MODULE_NAME,
					ErrorInfo.FACILITY_INVALID_LOGIN_CODE);
			uresponse.setErrorInfo(errorInfo);
			uresponse.setValid(false);
		}
		logger.info("Leaving the method isValidRequestor :");
		return uresponse;
	}
	/**
	 * This method calls the business component which calls DAO layer to get the Facilities
	 */
	@Override
	public FacilityResponse getFacilities(FacilityRequest request) {
		logger.info("Entering the method getFacilities");
		// ApplicationContext context1 = new
		// ClassPathXmlApplicationContext("Beans.xml");

		FacilityBC inst = (FacilityBC) context.getBean("FacilityBC");
		FacilityResponse response = inst.getFacilities(request);

		logger.debug("Error Info is:" + response.getErrorInfo().toString());
		logger.info("Leaving the method getFacilities");
		return response;
	}
	/**
	 * This method is used to convert the Response object in to XML String
	 * @param response
	 * @return
	 */
	private String getXMLFile(FacilityResponse response) {
		StringBuffer xmlFileContent = new StringBuffer();
		xmlFileContent
				.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");

		if (response == null) {
			logger.error("Empty response - so no file output");
			return "";
		}
		ErrorInfo errorInfo = response.getErrorInfo();
		if (errorInfo != null) {
			int errorCode = errorInfo.getErrorCode();
			String errorMessage = errorInfo.getErrorMessage();
			if (ErrorInfo.SUCCESS_CODE != errorCode) {
				xmlFileContent = createErrorResponse(errorMessage, errorCode,
						xmlFileContent);
				logger.info("Response is filled with failure" + errorMessage
						+ errorCode);
			} else {
				xmlFileContent = getXMLForFacilityList(response, xmlFileContent);
			}
		}
		return xmlFileContent.toString();
	}
	/**
	 * This method gets the Facility XML from list
	 * @param response
	 * @param xmlFileContent
	 * @return
	 */
	private StringBuffer getXMLForFacilityList(FacilityResponse response,
			StringBuffer xmlFileContent) {
		xmlFileContent.append("<").append(FacilityConstants.FACILICTIES_KEY)
				.append(">");
		List<Facility> facilityList = response.getFacilityList();
			for (Facility facility : facilityList) {
				xmlFileContent = getXMLForFacility(xmlFileContent, facility);
			}
		xmlFileContent.append("</").append(FacilityConstants.FACILICTIES_KEY)
				.append(">");
		return xmlFileContent;
	}
	/**
	 * This method gets the Facility XML for each Facility entry
	 * @param xmlFileContent
	 * @param facility
	 * @return
	 */
	private StringBuffer getXMLForFacility(StringBuffer xmlFileContent,
			Facility facility) {
		xmlFileContent.append("<").append(FacilityConstants.FACILITY_KEY)
				.append(">");

		xmlFileContent = createXMLFileContent(xmlFileContent,
				FacilityConstants.FACILITY_ID, facility.getFacilityId());

		xmlFileContent = createXMLFileContentForCDATA(xmlFileContent,
				FacilityConstants.FACILITY_NAME, facility.getFacilityName());

		xmlFileContent.append("</").append(FacilityConstants.FACILITY_KEY)
				.append(">");
		return xmlFileContent;
	}

}
