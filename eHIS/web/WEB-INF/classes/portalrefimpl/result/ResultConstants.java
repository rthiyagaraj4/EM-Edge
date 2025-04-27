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
package portalrefimpl.result;

/**
 * Constants file to be used for results module
 * @author GRamamoorthy
 *
 */
public class ResultConstants {

	/**
	 * The different error codes used in the detailed test results
	 * module
	 */
	public static final int SQLEXCEPTION_DETAILEDTESTRESULT_CODE = 621;
	
	public static final int DETAILEDTESTRESULT_NOTOBTAINED_CODE = 622;
	
	public static final int DTLD_RESULT_REQUEST_PATIENTID_ABSENT_CODE = 601;
	
	public static final int DTLD_RESULT_REQUEST_DATE_INVALID_CODE = 602;
	
	public static final int DTLD_RESULT_REQUEST_ORDERCATEGORY_ABSENT_CODE = 603;
	
	public static final int DTLD_RESULT_EMPTYDATA_CODE = 623;

	/**
	 * constant denoting the value against which the original value
	 * from the database is checked
	 */
	public static final String DETAILED_TESTRESULT_STATUS_VALUE = "Y";
	
	
	/**
	 * these are constants denoting the request parameter key values
	 * to be used for getting detailed test results 
	 */
	public static final String DETAILEDRESULTS_ORDERNUMBER_PARAM_KEY = "orderNumber";
	
	public static final String DETAILEDRESULTS_FACILITY_PARAM_KEY = "facility";
	
	public static final String DETAILEDRESULTS_ORDERCATEGORY_PARAM_KEY = "orderCategory";
	
	public static final String DETAILEDRESULTS_FROMDATE_PARAM_KEY = "fromDate";
	
	public static final String DETAILEDRESULTS_TODATE_PARAM_KEY = "toDate";
	
	/**
	 * These are constants denoting the different order categories supported
	 * in the portal web service - first cut
	 */
	public static final String DETAILEDRESULTS_ORDERCATEGORY_LAB_KEY = "LB";
	
	public static final String DETAILEDRESULTS_ORDERCATEGORY_RADIOLOGY_KEY = "RD";
	
	public static final String DETAILEDRESULTS_ORDERCATEGORY_LAB_MEDIUM_KEY = "Lab Order";
	
	public static final String DETAILEDRESULTS_ORDERCATEGORY_LAB_ALT_MEDIUM_KEY = "Laboratory";
	
	public static final String DETAILEDRESULTS_ORDERCATEGORY_RADIOLOGY_MEDIUM_KEY = "Radiology";
	
	/**
	 * Constant denoting the date format to be used for detailed test result module
	 */
	public static final String DETAILEDRESULTS_DATEFORMAT = "dd/MM/yyyy";
	
	public static final String DETAILEDRESULTS_DATETOSTRING_FORMAT = "dd/MM/yyyy";
	
	public static final String DETAILEDRESULTS_KENDOUI_DATE_FORMAT = "MM/dd/yyyy";
	
	public static final String DETAILEDRESULTS_DATETIMETOSTRING_FORMAT = "dd/MM/yyyy hh:mm:ss";
	
	
	/**
	 * constants denoting the xml tags used for detailed test result response
	 */
	public static final String DTLDRESULTS_XML_TAG = "DetailedResults";
	
	public static final String DTLDRESULTS_RESULT_XML_TAG = "DetailedResult";
	
	public static final String DTLDRESULTS_RESULT_PATIENTID_XML_TAG = "PatientId";
	
	public static final String DTLDRESULTS_RESULT_ORDERNUMBER_XML_TAG = "OrderNumber";
	
	public static final String DTLDRESULTS_RESULT_ORDERCATALOGUE_XML_TAG = "OrderCatalogue";
	
	public static final String DTLDRESULTS_RESULT_LOCATION_XML_TAG = "Location";
	
	public static final String DTLDRESULTS_RESULT_ORDERCATEGORY_XML_TAG = "OrderCategory";
	
	public static final String DTLDRESULTS_RESULT_ORDERDATE_XML_TAG = "OrderDate";
	
	public static final String DTLDRESULTS_RESULT_PRACTITIONER_XML_TAG = "Practitioner";
	
	public static final String DTLDRESULTS_RESULT_STATUS_XML_TAG = "ResultStatus";

	/**
	 * Constants denoting the request parameter key values
	 * for detailed results service
	 */
	public static final String DETAILEDRESULTS_ORDERNUMBER_REQUEST_PARAM_KEY = "orderNumber";
	
	public static final String DETAILEDRESULTS_ORDERCATALOGUE_REQUEST_PARAM_KEY = "orderCatalogue";
	
	public static final String DETAILEDRESULTS_ORDERCATEGORY_REQUEST_PARAM_KEY = "orderCategory";
	
	public static final String DETAILEDRESULTS_FROMDATE_REQUEST_PARAM_KEY = "fromDate";
	
	public static final String DETAILEDRESULTS_TODATE_REQUEST_PARAM_KEY = "toDate";
	
	public static final String DETAILEDRESULTS_ORDERCATALOGUE_LAB_KEY = "LB";
	
	public static final String DETAILEDRESULTS_ORDERCATALOGUE_RADIOLOGY_KEY = "RD";
	
	public static final String DETAILEDRESULTS_RESULTCOUNT_REQUEST_PARAM_KEY = "resultCount";
	
	public static final String DETAILEDRESULTS_RESULTCOUNTER_REQUEST_PARAM_KEY = "resultCounter";
	
	public static final String DETAILEDRESULTS_INITIALRESET_REQUEST_PARAM_KEY = "initialReset";
	
	public static final String DETAILEDRESULTS_DEFAULT_INITIALRESET_VALUE = "Y";
	
	/**
	 * constant denoting the key for storing the number of results 
	 * in detailed results service
	 */
	public static final String DETAILEDRESULTS_RESULTROWCOUNT_KEY = "DetailedTestResultsRowCount";
	
	public static final int DETAILEDRESULTS_DEFAULT_RESULTROWCOUNT = 4;
	
	/**
	 * constants denoting the error codes for test result service
	 */
	public static final int TESTRESULT_PATIENTID_ABSENT_ERRORCODE = 801;
	
	public static final int TESTRESULT_ORDERID_ABSENT_ERRORCODE = 802;
	
	public static final int TESTRESULT_CONNECTION_ERRORCODE = 821;
	
	public static final int TESTRESULT_SQLEXCEPTION_ERRORCODE = 822;
	
	public static final int TESTRESULT_RESULTSET_NOTOBTAINED_ERRORCODE = 823;
	
	public static final int TESTRESULT_DATA_NOTOBTAINED_ERRORCODE = 824;
	
	/**
	 * constants denoting the request parameter keys for test result service
	 */
	public static final String TESTRESULT_ORDERID_REQUEST_PARAM_KEY = "orderId";
	
	public static final String TESTRESULT_ORDER_REQUEST_PARAM_KEY = "order";
	
	public static final String TESTRESULT_RESULTTYPE_REQUEST_PARAM_KEY = "resultType";
	
	public static final String TESTRESULT_ORDERDATE_REQUEST_PARAM_KEY = "orderDate";
	
	/**	
	 * constant denoting the date format to be used for representing
	 * the publish date in test result service
	 */
	public static final String TESTRESULT_RESPONSE_PUBLISHDATE_FORMAT = "dd/MM/yyyy HH:mm";
	
	/**
	 * constants denoting the XML tags to be used for representing the 
	 * test result service response
	 * 
	 */
	public static final String TR_RESPONSE_PARENT_XML_TAG = "TestResult";
	
	public static final String TR_RESPONSE_ORDER_XML_TAG = "Order";
	
	public static final String TR_RESPONSE_ORDERNUMBER_XML_TAG = "OrderNumber";
	
	public static final String TR_RESPONSE_RESULTTYPE_XML_TAG = "ResultType";
	
	public static final String TR_RESPONSE_PUBLISHDATE_XML_TAG = "PublishDate";
	
	public static final String TR_RESPONSE_RESULTS_XML_TAG = "Results";
	
	public static final String TR_RESPONSE_RESULT_XML_TAG = "Result";
	
	public static final String TR_RESPONSE_RESULT_VALUE_XML_TAG = "ResultValue";
	
	public static final String TR_RESPONSE_RESULT_UOM_XML_TAG = "ResultUOM";
	
	public static final String TR_RESPONSE_RESULT_STR_XML_TAG = "ResultStr";
	
	public static final String TR_RESPONSE_RESULT_PUBLISHDATE_XML_TAG = "PublishDate";
	
	public static final String TR_RESPONSE_RESULT_PRACTITIONERID_XML_TAG = "PractitionerId";
	
	public static final String TR_RESPONSE_RESULT_REPORTINGPRACTID_XML_TAG = "ReportingPractitionerId";
	
	public static final String TR_RESPONSE_RESULT_NOTES_XML_TAG = "Notes";
	
	public static final String TR_RESPONSE_RESULT_NORMALLOW_XML_TAG = "NormalLow";
	
	public static final String TR_RESPONSE_RESULT_NORMALHIGH_XML_TAG = "NormalHigh";
	
	public static final String TR_RESPONSE_RESULT_CRITICALLOW_XML_TAG = "CriticalLow";
	
	public static final String TR_RESPONSE_RESULT_CRITICALHIGH_XML_TAG = "CriticalHigh";
	
	public static final String TR_RESPONSE_RESULT_ORDER_XML_TAG = "Order";
}
