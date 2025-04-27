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
package eIP.advbedmgmt.common.model;

/**
 * This enum stores the different statuses for a bed
 * This enum stores a state NOT_INITIALIZED apart from
 * the different known statuses
 * @author gramamoorthy
 *
 */
public enum BedStatusEnum {

	VACANT,ADMITTED,ADMISSION_INITIATED,TRANSFER_INIT,
	TRANSFER_ACCEPTED,TRANSFER_OUT,
	LEAVE,ABSCOND,BLOCKED,BLOCKED_OVERRIDEABLE,BOOKED,
	DISCHARGE_INITIATED,DISCHARGED,INFANT,NOT_INITIALIZED,ROOM_BCKGND;
	
}
