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
package portal.common.message;

import java.util.ResourceBundle;

/**
 * This class is contains the attribute of message class
 * @author gramamoorthy
 *
 */
public class Message {

	private String code = null;
	
	private String resourceBundleClass = null;
	
	private String resourceMessage = null;
	
	private String displayMessage = null;
	
	private ResourceBundle resourceBundleInst = null;
	 

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the resourceBundleClass
	 */
	public String getResourceBundleClass() {
		return resourceBundleClass;
	}

	/**
	 * @param resourceBundleClass the resourceBundleClass to set
	 */
	public void setResourceBundleClass(String resourceBundleClass) {
		this.resourceBundleClass = resourceBundleClass;
	}

	/**
	 * @return the resourceMessage
	 */
	public String getResourceMessage() {
		return resourceMessage;
	}

	/**
	 * @param resourceMessage the resourceMessage to set
	 */
	public void setResourceMessage(String resourceMessage) {
		this.resourceMessage = resourceMessage;
	}

	/**
	 * @return the displayMessage
	 */
	public String getDisplayMessage() {
		return displayMessage;
	}

	/**
	 * @param displayMessage the displayMessage to set
	 */
	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}
	
	/**
	 * 
	 */
	public ResourceBundle getResourceBundleInstance(){
		if(resourceBundleInst == null && resourceBundleClass != null){
			try {
				resourceBundleInst = ResourceBundle.getBundle(resourceBundleClass);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			/*Class resourceClass = null;
			try {
				resourceClass = Class.forName(resourceBundleClass);
				resourceClass.newInstance();
				
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		}
			
		return resourceBundleInst;	
	}
	

}
