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
package portalrefimpl.common;

import java.util.ResourceBundle;

/**
 * This is a utility class for performing operations
 * related to resource bundle
 * @author gramamoorthy
 *
 */
public class ResourceBundleHelper {

	/**
	 * This method gets a string value corresponding to the given key
	 * from a resource bundle
	 * @param bundleClassName
	 * @param key
	 * @return
	 */
	public static String getMessageFromBundle(String bundleClassName,String key){
		String message = null;
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle(bundleClassName);
			message = bundle.getString(key);
		} catch (Exception e) {
			message = "";
		}
		
		return message;
	}
	
}
