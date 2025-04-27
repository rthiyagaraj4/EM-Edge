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
package eIPAD.chartsummary.common.response;

import eIPAD.chartsummary.common.constants.LocalizationConstants;

/**
 * @author SaraswathiR
 *
 */
public enum Errors {
	
	  //Common Errors 
	  COMMON_SUCCESS(1000,LocalizationConstants.COMMON_ERROR_BUNDLE,"SUCCESS"),
	  COMMON_CONNECTION_FAILURE(1001,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.COMMON_DBCONNECTION_FAILURE_ERRORKEY),
	  COMMON_SQL_EXCEPTION(1002,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.COMMON_SQL_EXCEPTION_ERRORKEY),
	  COMMON_EMPTY_DATA(1003,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.COMMON_NO_DATA_ERRORKEY),
	  COMMON_NULL_EXCEPTION(1004,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.COMMON_NO_DATA_ERRORKEY),
	  COMMON_NULL_REQUEST(1005,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.COMMON_NO_DATA_ERRORKEY),
	  COMMON_TRANSACTION_SUCCESS(1006,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.COMMON_TRANSACTION_SUCCESS_MSGKEY),
	  COMMON_TRANSACTION_FAILURE(1007,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.COMMON_TRANSACTION_FAILURE_ERRORKEY),
	  
	  //Encounter List Errors
	  ENCOUNTERLIST_EMPTY_DATA(1101,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.ENCOUNTERLIST_NO_DATA_ERRORKEY),
	 
	  //Active Problems and Diagnosis Errors
	  PROBLEMSDIAGNOSIS_EMPTY_DATA(1201,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.PROBLEMSDIAGNOSIS_NO_DATA_ERRORKEY),

	  //Clinical notes Errors
	  CLINICALNOTES_EMPTY_DATA(1301,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.CLINICALNOTES_NO_DATA_ERRORKEY),
	  
	  //Procedure Details Errors
	  PROCEDUREDETAILS_EMPTY_DATA(1401,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.PROCEDUREDETAILS_NO_DATA_ERRORKEY),
	  
	  //Allergies Errors
	  ALLERGYLIST_EMPTY_DATA(1501,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.ALLERGYLIST_NO_DATA_ERRORKEY),
	  
	  //Results Errors
	  RESULTS_EMPTY_DATA(1601,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.RESULTS_NO_DATA_ERRORKEY),
	  
	  //Results Errors
	  PENDINGORDER_EMPTY_DATA(1701,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.PENDINGORDERS_NO_DATA_ERRORKEY),
	  
      //Vital error
	  NO_CHART_CONFIGURED(1303,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.NO_CHART_CONFIGURED),
	  MULTIPLE_CHART_CONFIGURED(1304,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.VITALS_MULTIPLE_CHART_CONFIGURED),
	  CURRENT_MEDICATION_EMPTY_DATA(1801,LocalizationConstants.COMMON_ERROR_BUNDLE,LocalizationConstants.CURRENTMEDICATION_NO_DATA_ERRORKEY);
	  
	  private final int id;
	  private final String bundleName;
	  private final String bundleMessage;

	  Errors(int id, String bundleName, String bundleMessage) {
	     this.id = id;
	     this.bundleName = bundleName;
	     this.bundleMessage = bundleMessage;
	  }

	  public int getId() { return id; }
	  public String getBundleMessage() { return bundleMessage; }
	  public String getBundleName() { return bundleName; }

}
