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
package portal.tools;

import portal.common.message.MessageContainer;
import portal.common.response.ErrorInfo;
/**
 * This class is used to get the various error messages
 * @author vkodancha
 *
 */
public class ErrorMessageUtil {
	
	
	public static MessageContainer msgContainer = MessageContainer.getInstance();
	
	/**
	 * This method is used to set a message
	 * for invalid user
	 * @return
	 */
	public static ErrorInfo getErrorMessage(String moduleName, int errorCode){
		ErrorInfo errorInfo = new ErrorInfo();
		String errorMsg = msgContainer.getDisplayMessage(moduleName, String.valueOf(errorCode));
		errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMsg);
		return errorInfo;
	}
	/**
	 * This method is used to set a message
	 * for invalid user
	 * @return
	 */
	public static ErrorInfo getErrorMessage(String moduleName, int errorCode,Object[] parameterArray){
		ErrorInfo errorInfo = new ErrorInfo();
		String errorMsg = msgContainer.getDisplayMessage(moduleName, String.valueOf(errorCode),parameterArray);
		errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMsg);
		return errorInfo;
	}
	/**
	 * This method is used to get a ErrorMessage
	 * @return
	 */
	public static ErrorInfo getErrorMessage(String ModuleName, int errorCode,String parameter){
		Object[] parameterArray = new Object[]{parameter};
		return getErrorMessage(ModuleName,errorCode,parameterArray);
	}

}
