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
package com.ehis.util;

import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

/**
 * @author chandrasekharm
 *
 */
public class PeriodFormatterFactory {

	public static PeriodFormatter getFormatter(String format){
		PeriodFormatter pf = null;
		
		if (format == null || format.equals(""))
			format = "DMY";
		
		if (format.equalsIgnoreCase("DMY")){
			pf = new PeriodFormatterBuilder()
					.printZeroAlways()
					.appendYears()
					.appendSuffix("Y:")
					.printZeroAlways()
					.appendMonths()
					.appendSuffix("M:")
					.printZeroAlways()
					.appendDays()
					.appendSuffix("D")
					.toFormatter();
		}else if (format.equalsIgnoreCase("MY")){
			pf = new PeriodFormatterBuilder()
				.printZeroAlways()
				.appendYears()
				.appendSuffix("Y:")
				.printZeroAlways()
				.appendMonths()
				.appendSuffix("M")				
				.toFormatter();
		}else if (format.equalsIgnoreCase("MM")){
			pf = new PeriodFormatterBuilder()				
				.printZeroAlways()
				.appendMonths()
				.appendSuffix("M")				
				.toFormatter();
		}else if (format.equalsIgnoreCase("YY")){
			pf = new PeriodFormatterBuilder()				
				.printZeroAlways()
				.appendYears()
				.appendSuffix("Y")				
				.toFormatter();			
		}else if (format.equalsIgnoreCase("DMYHM")){
			pf = new PeriodFormatterBuilder()
				.printZeroAlways()
				.appendYears()
				.appendSuffix("Y:")
				.printZeroAlways()
				.appendMonths()
				.appendSuffix("M:")
				.printZeroAlways()
				.appendDays()
				.appendSuffix("D:")
				.printZeroAlways()
				.appendHours()
				.appendSuffix("H:")
				.printZeroAlways()
				.appendMinutes()
				.appendSuffix("m")
				.toFormatter();
		}else if (format.equalsIgnoreCase("DMYHMS")){
			pf = new PeriodFormatterBuilder()
				.printZeroAlways()
				.appendYears()
				.appendSuffix("Y:")
				.printZeroAlways()
				.appendMonths()
				.appendSuffix("M:")
				.printZeroAlways()
				.appendDays()
				.appendSuffix("D:")
				.printZeroAlways()
				.appendHours()
				.appendSuffix("H:")
				.printZeroAlways()
				.appendMinutes()
				.appendSuffix("m:")
				.printZeroAlways()
				.appendSeconds()
				.appendSuffix("S")
				.toFormatter();
		}else if (format.equalsIgnoreCase("HM")){
			pf = new PeriodFormatterBuilder()
				.appendSuffix("H:")
				.printZeroAlways()
				.appendMinutes()
				.appendSuffix("m")				
				.toFormatter();
		}	
		return pf;
	}

}
