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

import eIP.advbedmgmt.common.model.Room;
import eIP.advbedmgmt.common.response.BaseResponse;

/**
 * This is the response class for containing the basic bed details
 * Bed details like bed number, bed dimensions, occupying patient details
 * will be contained in this class
 * @author gramamoorthy
 *
 */
public class BasicBedDetailsResponse extends BaseResponse{

	/**
	 * Stores the different rooms and its beds
	 */
	private List<Room> rooms = null;

	/**
	 * @return the rooms
	 */
	public List<Room> getRooms() {
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}	

}
