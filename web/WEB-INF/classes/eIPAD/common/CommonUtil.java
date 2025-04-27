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
package eIPAD.common;

/**
 * @author GRamamoorthy
 *
 */
public class CommonUtil {

	public static String replace(String str, String change, String replace,
			String quotes) {
		int t = str.indexOf(change);
		if (t == -1){
			return str;
		}
		if (quotes.equalsIgnoreCase("Y")){
			str = str.substring(0, t) + " '" + replace.trim() + "' "
					+ str.substring(t + 1);
		}
		else if (quotes.equalsIgnoreCase("N")){
			str = str.substring(0, t) + " " + replace.trim() + " "
					+ str.substring(t + 1);	
		}
		
		return str;
	}
	
	
}
