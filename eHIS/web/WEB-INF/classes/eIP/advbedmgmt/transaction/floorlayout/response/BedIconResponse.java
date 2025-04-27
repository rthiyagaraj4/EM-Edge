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
package eIP.advbedmgmt.transaction.floorlayout.response;

import java.util.List;

import eIP.advbedmgmt.common.response.BaseResponse;

/**
 * This is the response class which will store bed icon statuses
 * for beds in a nursing unit
 * @author GRamamoorthy
 *
 */
public class BedIconResponse extends BaseResponse {

	private List<RoomForBedIconSection> rooms = null;

	/**
	 * @return the rooms
	 */
	public List<RoomForBedIconSection> getRooms() {
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(List<RoomForBedIconSection> rooms) {
		this.rooms = rooms;
	}
	
}
