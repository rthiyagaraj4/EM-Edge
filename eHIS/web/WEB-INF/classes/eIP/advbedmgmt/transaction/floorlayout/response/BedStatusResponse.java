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

import java.util.ArrayList;
import java.util.List;

import eIP.advbedmgmt.common.model.BasicRoom;
import eIP.advbedmgmt.common.response.BaseResponse;

/**
 * This class is the response class for bed status stage
 * in bed management GUI rendering
 * @author GRamamoorthy
 *
 */
public class BedStatusResponse extends BaseResponse {

	/**
	 * Data members 
	 */
	private List<BasicRoom> roomList = new ArrayList<BasicRoom>();

	/**
	 * @return the roomList
	 */
	public List<BasicRoom> getRoomList() {
		return roomList;
	}

	/**
	 * @param roomList the roomList to set
	 */
	public void setRoomList(List<BasicRoom> roomList) {
		this.roomList = roomList;
	}
	
	
}
