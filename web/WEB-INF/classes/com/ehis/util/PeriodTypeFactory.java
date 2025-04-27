/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Factory Class to retrieve PeriodType based on a pattern string
 * <BR>
 * Created on 26/09/2006  
 * 
 */
package com.ehis.util;

import org.joda.time.PeriodType;

/**
 * Factory Class to retrieve PeriodType based on a pattern string
 * 
 * @author ChandrasekharM
 * 
 */

public class PeriodTypeFactory {
	
	
	/** 
	 * Method returns a PeriodType to suit the input pattern
	 * @param format Date format pattern (pattern correspinding to FormatterFactory)
	 * @return A PeriodType object that understands the input pattern <br>
	 * 
	 * Currently the all the formats are supported by the FormatterFactory are supported
	 * 
	 */
	public static PeriodType getPeriodType(String format){
		PeriodType periodType = null;
		
		if (format == null || format.equals(""))
			format = "DMY";
		
		if (format.equalsIgnoreCase("DMY")){
			periodType = PeriodType.yearMonthDay();
		}else if (format.equalsIgnoreCase("MY")){
			periodType = PeriodType.yearMonthDay().withDaysRemoved();
		}else if (format.equalsIgnoreCase("MM")){
			periodType = PeriodType.yearMonthDay().withDaysRemoved().withYearsRemoved();
		}else if (format.equalsIgnoreCase("YY")){
			periodType = PeriodType.yearMonthDay().withDaysRemoved().withMonthsRemoved();			
		}else if (format.equalsIgnoreCase("DMYHM")){
			periodType = PeriodType.yearMonthDayTime().withSecondsRemoved().withMillisRemoved();
		}else if (format.equalsIgnoreCase("DMYHMS")){
			periodType = PeriodType.yearMonthDayTime().withMillisRemoved();
		}else if (format.equalsIgnoreCase("HM")){
			periodType = PeriodType.time().withSecondsRemoved().withMillisRemoved();
		}	
		return periodType;	
	}
}
