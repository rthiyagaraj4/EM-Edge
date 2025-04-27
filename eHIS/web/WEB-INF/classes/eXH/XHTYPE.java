/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eXH;

/**
 *  The XHTYPE class used tto Define database OBject Types for XH module 
 *
 */
public class XHTYPE
{
	public static String schema = "IBAEHIS";
	public static String xhparamType = schema+"."+"XH_PARAM_TP";
	public static String xhauditType = schema+"."+"XH_AUDIT_TP";
	public static String xhparamForFacilityType = schema+"."+"XH_PARAM_FOR_FACILITY_TP";
	public static String xhEventForMessageType = schema+"."+"XH_EVENT_FOR_MESSAGE_TP";
	public static String xhSegmentType = schema+"."+"XH_SEGMENT_TP";
	public static String xhEventSegmentType = schema+"."+"XH_EVENT_SEGMENT_TP";
	public static String xhApplicationAddModifyType = schema+"."+"XH_APPLICATION_TP";
	public static String xhMsgForApplEvent = schema+"."+"XH_MSG_APPL_EVENT_TP";
	public static String xhMsgForApplSegment = schema+"."+"XH_MSG_APPL_SEGMENT_TP";
	public static String xhApplOutType = schema+"."+"XH_APPL_OUTBOUND_TP";
	public static String xhApplInType = schema+"."+"XH_APPL_INBOUND_TP";
	public static String xhFilterRuleType = schema+"."+"XH_APPL_FILTER_RULE_TP";
	public static String xhCommClientMain = schema+"."+"XH_COMMUNICATION_CLIENT_TP";
	public static String xhCommClientOutbound = schema+"."+"XH_COMM_CLIENT_OUTBOUND_TP";
	public static String xhCommClientInbound = schema+"."+"XH_COMM_CLIENT_INBOUND_TP";
	public static String xhAuth = schema+"."+"XH_AUTH_USER_TP";
}
//end of class
