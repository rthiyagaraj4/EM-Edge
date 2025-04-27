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
package eIP.advbedmgmt.common;

import java.math.BigDecimal;

import webbeans.eCommon.MessageManager;

/**
 * This is common module helper class
 * @author GRamamoorthy
 *
 */
public class CommonHelper {

	/**
	 * This method gets the gender value as a full string value
	 * that is, M means Male, F means Female, and U means Unknown
	 * The returned value is also obtained from resource bundle
	 * @param gender
	 * @param locale
	 * @return
	 */
	public static String getDisplayGender(String gender,String locale){
		String displayValue = gender;
		if (gender.equals("M")) {
			displayValue = MessageManager.getLabel(locale,
					"Common.male.label", "Common");
		} else if (gender.equals("F")) {
			displayValue = MessageManager.getLabel(locale,
					"Common.female.label", "Common");
		} else if (gender.equals("U")) {
			displayValue = MessageManager.getLabel(locale,
					"Common.unknown.label", "Common");
		}
		return displayValue;
	}
	
	/**
	 * This method gets an integer value given the equivalent string value
	 * @param intValStr
	 * @param defaultValue
	 * @return
	 */
	public static int getIntegerValue(String intValStr,int defaultValue){
		int retVal = defaultValue;
		try {
			retVal = Integer.parseInt(intValStr);
		} catch (NumberFormatException e) {
			retVal = defaultValue;
		}
		
		return retVal;
	}
	
	/**
	 * This method gets an integer value given a big decimal instance
	 * 
	 * @param decVal
	 * @param defaultValue
	 * @return
	 */
	public static int getIntegerValue(BigDecimal decVal,int defaultValue){
		int retVal = defaultValue;
		if(decVal != null){
			retVal = decVal.intValue();	
		}
		return retVal;
	}
	
}
