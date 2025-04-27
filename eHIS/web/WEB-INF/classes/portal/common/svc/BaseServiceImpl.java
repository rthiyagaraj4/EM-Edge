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
package portal.common.svc;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import portal.common.request.BaseRequest;
import portal.common.request.ValidationRequest;
import portal.common.response.ValidationResponse;
import portal.tools.PortalConstants;


/**
 * This class defines all the common method that have to be 
 * defined for all the services.
 * 
 * isValidRequestor() method has to be overridden when the request is
 * validated before the request parameters are passed to service method
 * 
 * @author GRamamoorthy
 *
 */
public abstract class BaseServiceImpl implements BaseService {

	public static ApplicationContext context = null;
	public BaseServiceImpl(){
		if(context==null){
			context = new ClassPathXmlApplicationContext("Beans.xml");
		}
	}
	/**
	 * This method enables the Service to validate the requester of the service.
	 * The requester to be validated will be sent through
	 * the ValidationRequest object
	 * This method will return a ValidationResponse object which will contain
	 * the result of the validation  
	 * @param request
	 * @return
	 */
	public ValidationResponse isValidRequestor(ValidationRequest request) {
		ValidationResponse response = new ValidationResponse();
		boolean isValid = validateEMUserId(request);
		response.setValid(isValid);
		return response;
	}
	/**
	 * This method creates the error tag for response
	 * @param errormsg
	 * @param errorCode
	 * @param xmlFileContent
	 * @return
	 */
	public StringBuffer createErrorResponse(String errormsg, int errorCode, StringBuffer xmlFileContent) {
		xmlFileContent.append("<").append(PortalConstants.ERRORINFO_KEY).append(">");
		xmlFileContent.append("<").append(PortalConstants.ERRORCODE_KEY).append(">");
		xmlFileContent.append(errorCode);
		xmlFileContent.append("</").append(PortalConstants.ERRORCODE_KEY).append(">");
		xmlFileContent.append("<").append(PortalConstants.ERRORMESSAGE_KEY).append(">");
		xmlFileContent.append(errormsg!=null ? errormsg : "");
		xmlFileContent.append("</").append(PortalConstants.ERRORMESSAGE_KEY).append(">");
		xmlFileContent.append("</").append(PortalConstants.ERRORINFO_KEY).append(">");
		return xmlFileContent;
	}
	/**
	 * This method creates the XML tag for each key and value
	 * @param xmlFileContent
	 * @param key
	 * @param value
	 * @return
	 */
	public StringBuffer createXMLFileContent(StringBuffer xmlFileContent, String key, String value) {
		xmlFileContent.append("<").append(key).append(">");
		if (value != null && value.trim().length() > 0) {
			xmlFileContent.append("<![CDATA[" + value + "]]>");
		}
		xmlFileContent.append("</").append(key).append(">");
		return xmlFileContent;
	}
	/**
	 * This method creates the XML tag for each key and value
	 * @param xmlFileContent
	 * @param key
	 * @param value
	 * @return
	 */
	public StringBuffer createXMLFileContentForCDATA(StringBuffer xmlFileContent, String key, String value) {
		xmlFileContent.append("<").append(key).append(">");
		if(value != null && value.trim().length() > 0) {
			xmlFileContent.append("<![CDATA["+value+"]]>");
		}
		xmlFileContent.append("</").append(key).append(">");
		return xmlFileContent;
	}
	/**
	 * This method validate the portaluserName
	 * @param request
	 * @return
	 */
	private boolean validateEMUserId(ValidationRequest request) {
		String commonUserName = request.getPortalUserName();
		if(PortalConstants.COMMON_USER_NAME.equals(commonUserName)){
			return true;
		} else {
			return false;
		}
	}
	/**
	 * This method gets the stores all the request URL parameters 
	 * in to a HashMap
	 * @param path
	 * @return
	 */
	protected Map<String, String> getParametersFromRequest(String path) {
		// the main logic in this method is to break the path based on
		// & character
		Map<String, String> parameterMap = new HashMap<String, String>();
		// added to remove null pointer exception when path is null
		if (!isEmptyOrNull(path)) {
			StringTokenizer parameterTokenizer = new StringTokenizer(path, "&");
			String token = null;
			int index = -1;

			String paramName = null;
			String paramValue = null;
			while (parameterTokenizer.hasMoreTokens()) {
				token = parameterTokenizer.nextToken();
				index = token.indexOf("=");
				if (index >= 0) {
					paramName = token.substring(0, index);
					paramValue = token.substring(index + 1);
					parameterMap.put(paramName, paramValue);
				}
			}
		}
		return parameterMap;
	}
	
	/**
	 * This method updates the request with portaluserName parameter
	 */
	protected void setPortalUserNameToRequest(BaseRequest request, Map<String,String> parameterMap){
		if(parameterMap.containsKey("portalUserName")){
			request.setPortalUserName(parameterMap.get("portalUserName"));
		}
	}
	/**
	 * This method is used to validate the string input parameter
	 * @param value
	 * @return
	 */
	protected boolean isEmptyOrNull(String value){
		return null==value || value.trim().length() ==0;
	}
}
