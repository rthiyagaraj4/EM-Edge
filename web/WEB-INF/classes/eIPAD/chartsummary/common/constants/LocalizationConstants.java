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
package eIPAD.chartsummary.common.constants;

/**
 * @author SaraswathiR 
 *
 */
public class LocalizationConstants {
	
	/**
	 * Common module
	 */
	public static final String COMMON_ERROR_BUNDLE = "eIPAD.chartsummary.common.resourcebundle.errors";
	/**
	 * Common error keys
	 */
	public static final String COMMON_DBCONNECTION_FAILURE_ERRORKEY = "DatabaseConnectionFailure";
	public static final String COMMON_SQL_EXCEPTION_ERRORKEY = "SQLException";
	public static final String COMMON_NO_DATA_ERRORKEY = "NoData";
	public static final String COMMON_NULL_ERROR_ERRORKEY = "NullException";
	public static final String COMMON_NULL_REQUEST_ERRORKEY = "NullRequest";
	public static final String COMMON_TRANSACTION_SUCCESS_MSGKEY = "TransactionSuccessful";
	public static final String COMMON_TRANSACTION_FAILURE_ERRORKEY = "TransactionFailed";
	
	/**
	 * Encounter module
	 */
	public static final String ENCOUNTERLIST_ERROR_BUNDLE = "eIPAD.chartsummary.encounterlist.resourcebundle.errors";
	public static final String ENCOUNTERLIST_NO_DATA_ERRORKEY = "EncountersNoData";
	
	/**
	 * Problems Diagnosis module
	 */
	public static final String PROBLEMSDIAGNOSIS_ERROR_BUNDLE = "eIPAD.chartsummary.activeproblems.resourcebundle.errors";
	public static final String PROBLEMSDIAGNOSIS_NO_DATA_ERRORKEY = "ActiveProblemsNoData";
	
	/**
	 * Allergies
	 */
	public static final String CONST_EventTypeCode = "DA";
	public static final String ALLERGYLIST_ERROR_BUNDLE = "eIPAD.chartsummary.allergies.resourcebundle.errors";
	public static final String ALLERGYLIST_NO_DATA_ERRORKEY = "AllergiesNoData";
	
	/**
	 * Clinical Notes
	 */
	public static final String CLINICALNOTES_NO_DATA_ERRORKEY = "ClinicalNotesNoData";
	
	/**
	 * Procedure Details
	 */
	public static final String PROCEDUREDETAILS_NO_DATA_ERRORKEY = "ProcedureDetailsNoData";
	/**
	 * Results
	 */
	public static final String RESULTS_NO_DATA_ERRORKEY = "ResultsNoData";
	/**
	 * Pending Orders
	 */
	public static final String PENDINGORDERS_NO_DATA_ERRORKEY = "PendingOrdersNoData";
	/**
	 * Vitals
	 */
	public static final String NO_CHART_CONFIGURED = "NoChartConfigured";
	public static final String NORMAL_ICON = "NI_NORMAL.gif";
	public static final String NODATA_ICON = "NoData.PNG";
	public static final String VITALS_VIEW = "/eIPAD/jsp/chartwidgets/Vitals.jsp";
	public static final String VITALS_CHART_VIEW = "/eIPAD/jsp/chartwidgets/VitalsChart.jsp";
	public static final String VITALS_TABULAR_VIEW = "/eIPAD/jsp/chartwidgets/VitalsTabularView.jsp";
	public static final String VITALS_TABULAR_VIEW_VALUE = "/eIPAD/jsp/chartwidgets/VitalsValue.jsp";
	public static final String VITALS_MULTIPLE_CHART_CONFIGURED = "MultipleChartConfigured";
	public static final String RECORD_VITALS_VIEW = "/eIPAD/jsp/chartwidgets/RecordVitals.jsp";
	/**
	 * Current Medication
	 */
	public static final String CURRENTMEDICATION_NO_DATA_ERRORKEY = "No current medication recorded for the patient"; // TODO use errorKey to print - VivekC  
}
