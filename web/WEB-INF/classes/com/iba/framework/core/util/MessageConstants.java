/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Aug 18, 2006
 */
package com.iba.framework.core.util;

/**
 * @author Sabarinathan S
 * @version
 */
public interface MessageConstants {
	String PROBLEM_UNKNOWN = "Found unknown problem. Please check the log for details.";

	String BEANID_REQUIRED = "BeanId cannot be null or empty.";

	String MISSING_BEAN_ENTRY = "'{0}' bean is not defined in the configuration file.";

	String SEQ_GEN_ERROR = "Problem occured in Accession Number generation.";

	String INVALID_KEY = "Data not found for the given key {0}.";

	String DUPLICATE_OBSERVATION = "Found duplicate observation insertion. The chart Date Time should be between last recorded time.";

	String DATA_NOT_FOUND = "No record(s) found for {0}.";

	String ENCOUNTER_NOT_FOUND = "Encounter record not exists for the given id {0}.";

	String INPUT_MISSING = "Missing input parameters. Given data : {0} ";

	String SUCCESS_MESSAGE = "Record Inserted SuccesFully";
}
