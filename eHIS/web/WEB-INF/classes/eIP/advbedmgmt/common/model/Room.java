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

import java.util.List;

/**
 * This is a model class representing a room in a nursing unit This class will
 * have room details like room number, room dimensions
 * 
 * @author gramamoorthy
 * 
 */
public class Room extends BasicRoom {

	/**
	 * data members in this class
	 */
	private List<Bed> beds = null;

	protected int roomLeftPosition = 0;

	protected int roomTopPosition = 0;

	protected int roomHeight = 0;

	protected int roomWidth = 0;

	/**
	 * Default empty constructor
	 */
	public Room() {
		// does nothing
	}

	/**
	 * @param facilityId
	 * @param nursingUnitCode
	 * @param roomNumber
	 * @param roomDesc
	 * @param roomLeftPosition
	 * @param roomTopPosition
	 * @param roomHeight
	 * @param roomWidth
	 */
	public Room(String facilityId, String nursingUnitCode, String roomNumber,
			String roomDesc, int roomLeftPosition, int roomTopPosition,
			int roomHeight, int roomWidth) {
		setFacilityId(facilityId);
		setNursingUnitCode(nursingUnitCode);
		setRoomNumber(roomNumber);
		setRoomDesc(roomDesc);
		this.roomLeftPosition = roomLeftPosition;
		this.roomTopPosition = roomTopPosition;
		this.roomHeight = roomHeight;
		this.roomWidth = roomWidth;
	}

	/**
	 * @return the roomLeftPosition
	 */
	public int getRoomLeftPosition() {
		return roomLeftPosition;
	}

	/**
	 * @param roomLeftPosition
	 *            the roomLeftPosition to set
	 */
	public void setRoomLeftPosition(int roomLeftPosition) {
		this.roomLeftPosition = roomLeftPosition;
	}

	/**
	 * @return the roomHeight
	 */
	public int getRoomHeight() {
		return roomHeight;
	}

	/**
	 * @param roomHeight
	 *            the roomHeight to set
	 */
	public void setRoomHeight(int roomHeight) {
		this.roomHeight = roomHeight;
	}

	/**
	 * @return the roomWidth
	 */
	public int getRoomWidth() {
		return roomWidth;
	}

	/**
	 * @param roomWidth
	 *            the roomWidth to set
	 */
	public void setRoomWidth(int roomWidth) {
		this.roomWidth = roomWidth;
	}

	/**
	 * @return the beds
	 */
	public List<Bed> getBeds() {
		return beds;
	}

	/**
	 * @param beds
	 *            the beds to set
	 */
	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}

	/**
	 * This method returns the hashcode value for this object
	 * 
	 */
	public int hashCode() {
		int hash = this.roomLeftPosition + this.roomTopPosition
				+ this.roomHeight + this.roomWidth;
		return hash;
	}

	/**
	 * @return the roomTopPosition
	 */
	public int getRoomTopPosition() {
		return roomTopPosition;
	}

	/**
	 * @param roomTopPosition
	 *            the roomTopPosition to set
	 */
	public void setRoomTopPosition(int roomTopPosition) {
		this.roomTopPosition = roomTopPosition;
	}

	/**
	 * this method is used to compare another object with this object this
	 * object is equal to the passed object if the room number, room description
	 *  and the room dimensions are equal
	 */
	public boolean equals(Object obj) {
		boolean equals = false;
		// safe check
		if (!(obj instanceof Room)) {
			return equals;
		}
		
		if(!(super.equals(obj))){
			return equals;
		}
		
		// get the values from the passed object
		Room tempRoom = (Room) obj;
		String tempRoomNumber = tempRoom.getRoomNumber();
		String tempRoomDesc = tempRoom.getRoomDesc();
		int tempRoomTopPosition = tempRoom.getRoomTopPosition();
		int tempRoomLeftPosition = tempRoom.getRoomLeftPosition();
		int tempRoomHeight = tempRoom.getRoomHeight();
		int tempRoomWidth = tempRoom.getRoomWidth();

		if ((this.roomNumber != null && this.roomNumber.equals(tempRoomNumber)) && 
				(this.roomDesc != null && this.roomDesc.equals(tempRoomDesc))) {
			if (this.roomLeftPosition == tempRoomLeftPosition
					&& this.roomTopPosition == tempRoomTopPosition
					&& this.roomHeight == tempRoomHeight
					&& this.roomWidth == tempRoomWidth) {
				equals = true;
			}
		}

		return equals;
	}

}
