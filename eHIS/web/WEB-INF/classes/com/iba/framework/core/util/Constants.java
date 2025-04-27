/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.util;

/**
 * @author S Sabarinathan
 * 
 */
public interface Constants {
	
	int FAILED = 500;
	int SUCCESS = 400;
	
	String RUNTIME_ERROR = "RUNTIME_ERROR";
	String APPLICATION_BEANS 		= 	"app-beans.xml";
	String SPRING_STRUTS_FILE 		= 	"Spring-Struts.xml";
	String SPRING_ORM_FILE 		= 	"spring-orm.xml";
	String SPRING_JMS_FILE 		= 	"spring-jms.xml";
		
	boolean SPRING_CONTEXT_REFRESH 	= 	true;
	
	String CACHE_MANAGER            = "CacheManager";
	String COMMUNICATION_QUEUE 		= 	"IBACOMMUNICATIONQUEUE";
	String PRINTER_QUEUE 			= 	"IBA.PRINTER.QUEUE";
	String NAMING_EXCEPTION 		= 	"Caught NamingException.";
	String UNKNOWN_EXCEPTION 		= 	"Problem unknown. Please check the exception stacktrace.";
	String BEAN_ID_EXCEPTED 		= 	"BeanId cannot be null or empty.";
	
	//JMS Message Types
	int OBJECT_MESSAGE 				= 	1;
	int TEXT_MESSAGE				=	2;
	int MAP_MESSAGE					= 	3;
	int BYTE_MESSAGE				= 	4;
	
//	 Web Constants
	final int CREATE  =0;
	final int LOAD   =1;
	final int UPDATE  =2;
	final int DELETE  =3;
	final int QUERY		=4;
	final int EXECUTE =5;
	
	String GENERAL_LOG = "APPLICATION_LOG";
	String HL7_LOG = "HL7_LOG";
	String JBOSSCACHE_CONFIG_FILE = "cache-config.xml";
	String CACHE_BEAN = "cache";
	boolean REMOVE_OBJECT = false;
	boolean INVALIDATE_CACHE = true;
	int TIMEOUT_NOT_SET = -1;
	String APPLICATION_BUNDLE_FILENAME = "application";
	String VODOMAP_BUNDLE_FILENAME = "vodomapping";
	
	String USER_SESSION_CACHE = "US";
	String PATIENT_CACHE = "PA";
	String GLOBAL_CACHE = "GC";
	int STARTS_WITH = 601;
	int ENDS_WITH = 602;
	int CONTAINS = 603;
	int LOOKUP_BY_CODE = 604;
	int LOOKUP_BY_DESCRIPTION = 605;

	//DateTimeConstants
	final int ISO_CHRONOLOGY = 0;
	final int GREGORIAN_CHRONOLOGY = 1;
	final int BUDDHIST_CHRONOLOGY = 2;
	final int COPTIC_CHRONOLOGY = 3;
	final int ISLAMIC_CHRONOLOGY = 4;
	final int JULIAN_CHRONOLOGY= 5;
	
	
	int FIRST_RECORD = 0;
	String USER_PREFS = "user_prefs";
	boolean DISABLE_PAGING = false;
	String NOT_AVAILABLE = "NAREN";
	
	// Error Constants
	String FATAL_ERROR = "SYS_500";
	String DATA_NOT_FOUND = "APP_404";
	String CP_FUNCTION = "CP";
	String DUPLICATE_OBSERVATION = "APP_501";
	String INPUT_ERROR = "APP_502";
	boolean RECORD_EXISTS = true;
	boolean RECORD_NOT_EXISTS = false;
	//
	String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
	String DEFAULT_TIME_FORMAT = "HH:mm";
	String EMPTY = "";
	
	//Success Message
	String OPERATION_SUCCESS="MESSAGE.OPERATION_SUCCESS";
	String OPERATION_FAILURE="MESSAGE.OPERATION_FAILURE";
		
	//
	String EXCEPTION_IO="IOEXCEPTION";
	
	String DATE_FIELD_SUFFIX = ".pattern";		
	
	String DYNAMIC_QUERY_LOAD="dynamic";

	String STATIC_QUERY_LOAD="static";

}
