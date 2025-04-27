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
package eAlert.src.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author PrasannaR 
 *
 */
public class ConfigHelper {
	
	private static Properties alertConfigProperties = new Properties();
	
	private static boolean isInitialized = false;
	
	/**
	 * 
	 */
	private static void initializeConfigProperties()
	{
		try {
			InputStream is = Thread.currentThread().getContextClassLoader()
							.getResourceAsStream("./conf/DBConfig.properties");
		
			alertConfigProperties.load(is);
			isInitialized = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}

	/**
	 * 
	 * @param propertyKey
	 * @return
	 */
	public static String getConfigPropertyValue(String propertyKey){
		return getConfigPropertyValue(propertyKey, false);
	}
	
	/**
	 * 
	 * @param propertyKey
	 * @param initialize
	 * @return
	 */
	public static String getConfigPropertyValue(String propertyKey, boolean initialize)
	{
		String propertyValue = "";
		
		if(initialize || !isInitialized)
		{
			initializeConfigProperties();
		}
		
		if(alertConfigProperties.containsKey(propertyKey)){
			propertyValue = alertConfigProperties.getProperty(propertyKey);
		}
		
		return propertyValue;
	}
}
