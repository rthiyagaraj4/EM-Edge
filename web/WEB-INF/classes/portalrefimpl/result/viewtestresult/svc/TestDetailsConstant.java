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
package portalrefimpl.result.viewtestresult.svc;

/**
 * @author GRamamoorthy
 *
 */
public class TestDetailsConstant {

	public static final String TESTDETAILS_KEY = "TestDetails";
	
	public static final String TESTDETAIL_KEY = "TestDetail";
	
	public static final String ORDERNO_KEY = "OrderNumber";
	
	public static final String LOCATION_KEY = "Location";
	
	public static final String RESULTTYPE_KEY = "ResultType";
	
	public static final String ORDER_KEY = "Order"; 
	
	public static final String ORDER_DATE_KEY = "OrderDate";
	
	public static final String PRACT_ID_KEY = "PractitionerId";
	
	public static final String PRACT_NAME_KEY = "PractitionerName";
	
	public static final String STATUS_KEY = "Status";
	
	/**
	 * Constants to denote the error codes to be used in test details
	 * service
	 */
	public static final int TESTRESULTDETAILS_PATIENTID_INVALID_ERRORCODE = 201;
	
	public static final int TESTRESULTDETAILS_NULLRESULTSET_ERRORCODE = 251;
	
	public static final int TESTRESULTDETAILS_SQLEXCEPTION_ERRORCODE = 252;
	
	public static final int TESTRESULTDETAILS_DATANOTFOUND_ERRORCODE = 253;
	
	
	/**
	 * 
	 */
	public static final String ENCOUNTERID_PARAM_KEY = "encounterId";
	
	public static final String RECORDCOUNT_PARAM_KEY = "recordCount";
	/**
	 * 
	 */
	public static final int RECORDCOUNT_DEFAULT_VALUE = 3;
	
}
