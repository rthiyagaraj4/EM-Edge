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

import java.util.ArrayList;
import java.util.List;

/**
 * This is a constants file to store the different statuses for a patient
 * This constants file will be used in patient search and in bed status modules
 * @author GRamamoorthy
 *
 */
public class PatientStatusConstants {

	/**
	 * Constant denoting the different status values for a patient
	 *  
	 */
	public static final String ADMITTED_STATUS_DEFAULT_VALUE = "01";
	
	public static final String ADMISSION_INITIATED_STATUS_DEFAULT_VALUE = "00";
	
	public static final String TRANSFER_OUT_VALUE = "3";
	
	public static final String TRANFER_ACCEPTED_VALUE = "1";
	
	public static final String TRANFER_INITIATED_VALUE = "0";
	
	//public static final String TRANFER_INITIATED_INTER_WARD_VALUE = "1";
	
	public static final String LEAVE_STATUS_VALUE = "1";
	
	public static final String ABSCOND_STATUS_VALUE = "4";
	
	public static final List<String> BLOCKED_STATUS_VALUE = new ArrayList<String>();
	
	static{
		BLOCKED_STATUS_VALUE.add("N");
		BLOCKED_STATUS_VALUE.add("B");
		BLOCKED_STATUS_VALUE.add("L");
		BLOCKED_STATUS_VALUE.add("T");
		BLOCKED_STATUS_VALUE.add("D");
	}
	
	public static final String BLOCKED_OVERRIDE_STATUS_VALUE = "Y";
	
	public static final String DISCHARGE_INITIATED_STATUS_VALUE = "0";
	
	public static final String DISCHARGED_STATUS_VALUE = "1";
	
	
}
