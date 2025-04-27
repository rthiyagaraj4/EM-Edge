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
package eIP.advbedmgmt.common.resourcebundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.WeakHashMap;

/**
 * This class will hold all the resource bundle messages to be used in GBM
 * module Module classes which need resource bundle messages will call this
 * class to get the resource messages The resource messages will be stored in a
 * map with the code for the messages as the key This class is a singleton class
 * 
 * @author gramamoorthy
 * 
 */
public class BundleManager {

	/**
	 * private static instance of this class
	 */
	private static BundleManager s_instance = null;

	/**
	 * Holds number code as keys and the resource message keys as values
	 */
	private Map<Integer, List<String>> resourcebundleKeyMap = new HashMap<Integer, List<String>>();
	
	/**
	 * Holds the resourcebundle instances - map contains the bundle class name
	 * as key and the resource bundle instances as values
	 * WeakHashMap is used to not have impact on memory
	 */
	private Map<String, ResourceBundle> resourcebundleMap = new WeakHashMap<String, ResourceBundle>();

	/**
	 * private constructor
	 */
	private BundleManager() {
		// does nothing
	}

	/**
	 * This method returns the instance of this class
	 * 
	 * @return
	 */
	public static BundleManager getInstance() {
		if (s_instance == null) {
			s_instance = new BundleManager();
		}
		return s_instance;
	}

	/**
	 * This method adds the code and the message key list to the map The message
	 * key list should have the following 1. resource message key for logging
	 * purpose should be first 2. resource message key for display purpose
	 * should be second The message key list should not have any more keys
	 * 
	 * @param code
	 * @param messageKeyList
	 */
	public void addToResourceBundleMap(Integer code, List<String> messageKeyList) {
		resourcebundleKeyMap.put(code, messageKeyList);
	}

	/**
	 * This method adds the code and the keys supplied to the internal map
	 * code is key in the map
	 * The resourcemsgforlogkey and resourcemsgfordisplaykey are added to a list
	 * in the same order and then added to the map as value for the given code
	 * 
	 * @param code
	 * @param resourceMsgForLogKey
	 * @param resourceMsgForDisplayKey
	 */
	public void addToResourceBundleMap(Integer code,
			String resourceMsgForLogKey, String resourceMsgForDisplayKey) {
		List<String> messageKeyList = new ArrayList<String>();
		messageKeyList.add(resourceMsgForLogKey);
		messageKeyList.add(resourceMsgForDisplayKey);
		addToResourceBundleMap(code, messageKeyList);
	}

	/**
	 * This method returns the display resource bundle message key
	 * from the internal map
	 * @param code
	 * @return
	 */
	public String getDisplayMessageKey(Integer code) {
		String key = "";
		final int DISPLAY_INDEX = 1;
		if (resourcebundleKeyMap.containsKey(code)) {
			List<String> keyList = resourcebundleKeyMap.get(code);
			// key list will be non null and non empty
			key = keyList.get(DISPLAY_INDEX);
		}

		return key;
	}
	
	/**
	 * This method returns the log resource bundle message key
	 * from the internal map
	 * @param code
	 * @return
	 */
	public String getResourceMessageKey(Integer code){
		String key = "";
		final int INDEX = 0;
		if (resourcebundleKeyMap.containsKey(code)) {
			List<String> keyList = resourcebundleKeyMap.get(code);
			// key list will be non null and non empty
			key = keyList.get(INDEX);
		}

		return key;
	}
	
	/**
	 * This method gets the display message from resource bundle properties file
	 * The message is obtained for a given code
	 * This method first retrieves the resource bundle instance based on the bundle class
	 * name passed to this method
	 * The message is obtained from the resource bundle instance
	 * @param code
	 * @param bundleClassName
	 * @return
	 */
	public String getDisplayMessageFromBundle(Integer code,String bundleClassName){
		// first get the message key for the given code
		String messageKey = getDisplayMessageKey(code);
		// now call the method to get the resource bundle message
		String message = getMessageFromResourceBundle(messageKey, bundleClassName);
		return message;
	}
	
	/**
	 * This method gets the display message from resource bundle properties file
	 * @param messageKey
	 * @param bundleClassName
	 * @return
	 */
	public String getDisplayMessageFromBundle(String messageKey,String bundleClassName){
		// now call the method to get the resource bundle message
		String message = getMessageFromResourceBundle(messageKey,
				bundleClassName);
		return message;
	}
	
	
	/**
	 * This method gets the log message from resource bundle properties file
	 * The message is obtained for a given code
	 * This method first retrieves the resource bundle instance based on the bundle class
	 * name passed to this method
	 * The message is obtained from the resource bundle instance
	 * @param code
	 * @param bundleClassName
	 * @return
	 */
	public String getLogMessageFromBundle(Integer code,String bundleClassName){
		// first get the message key for the given code
		String messageKey = getResourceMessageKey(code);
		// now call the method to get the resource bundle message
		String message = getMessageFromResourceBundle(messageKey, bundleClassName);
		return message;
	}
	
	/**
	 * This method gets the resource bundle message from the resource bundle properties
	 * file given the resource bundle message key and the bundle class 
	 * @param messageKey
	 * @param bundleClassName
	 * @return
	 */
	public String getMessageFromResourceBundle(String messageKey,String bundleClassName){
		String message = "";
		ResourceBundle bundleInst = null;
		// check is done if the bundle is already present in the map		
		if(resourcebundleMap.containsKey(messageKey)){
			bundleInst = resourcebundleMap.get(messageKey);
			if(bundleInst == null){
				try {
					bundleInst = ResourceBundle.getBundle(bundleClassName);
					resourcebundleMap.put(bundleClassName, bundleInst);
				} catch (Exception e) {
					// cannot do much
				}
			}
		}else{
			try {
				bundleInst = ResourceBundle.getBundle(bundleClassName);
				resourcebundleMap.put(bundleClassName, bundleInst);
			} catch (Exception e) {
				// cannot do much
			}
		}
		
		// finally get the string message from the bundle instance
		if(bundleInst != null){
			try {
				message = bundleInst.getString(messageKey);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				message = "";
			}	
		}
		
		return message;
	}
	

}
