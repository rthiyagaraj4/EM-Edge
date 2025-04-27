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
 * This is a model class representing a room in a nursing unit 
 * Contains info like facility id, nursing unit code and room number only
 * This class should be extended by specific classes which can
 * store room dimensions and other room related data
 * @author GRamamoorthy
 *
 */
public class BasicRoom {

	/**
	 * Data members
	 */
	protected String facilityId = null;

	protected String nursingUnitCode = null;

	protected String roomNumber = null;
	
	protected String roomDesc = null;
	
	protected List<BasicBed> bedList = null;
	
	protected boolean valid = true;
	
	protected String roomBackgndColor = null;

	/**
	 * @return the facilityId
	 */
	public String getFacilityId() {
		return facilityId;
	}

	/**
	 * @param facilityId the facilityId to set
	 */
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	/**
	 * @return the nursingUnitCode
	 */
	public String getNursingUnitCode() {
		return nursingUnitCode;
	}

	/**
	 * @param nursingUnitCode the nursingUnitCode to set
	 */
	public void setNursingUnitCode(String nursingUnitCode) {
		this.nursingUnitCode = nursingUnitCode;
	}

	/**
	 * @return the roomNumber
	 */
	public String getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * @return the bedList
	 */
	public List<BasicBed> getBedList() {
		return bedList;
	}

	/**
	 * @param bedList the bedList to set
	 */
	public void setBedList(List<BasicBed> bedList) {
		this.bedList = bedList;
	}

	/**
	 * overriding hashcode method along with equals method
	 */
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Overriding equals to give specific behavior
	 * two basicroom objects are equal if their facility id, nursing unit code,
	 * and the room number are equal
	 */
	public boolean equals(Object obj) {
		boolean equals = false;
		// short circuit
		if(this == obj){
			equals = true;
			return equals;
		}
		
		// instance check
		if(!(obj instanceof BasicRoom)){
			return equals;
		}
		
		BasicRoom tempRoom = (BasicRoom)obj;
		String tempRoomFacId = tempRoom.getFacilityId();
		String tempRoomNUCode = tempRoom.getNursingUnitCode();
		String tempRoomNumber = tempRoom.getRoomNumber();
		
		if ((roomNumber != null && roomNumber.equals(tempRoomNumber))
				&& (facilityId != null && facilityId.equals(tempRoomFacId))
				&& (nursingUnitCode != null && nursingUnitCode
						.equals(tempRoomNUCode))) {
			equals = true;
		}
		
		return equals;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * @return the roomDesc
	 */
	public String getRoomDesc() {
		return roomDesc;
	}

	/**
	 * @param roomDesc the roomDesc to set
	 */
	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	/**
	 * @return the roomBackgndColor
	 */
	public String getRoomBackgndColor() {
		return roomBackgndColor;
	}

	/**
	 * @param roomBackgndColor the roomBackgndColor to set
	 */
	public void setRoomBackgndColor(String roomBackgndColor) {
		this.roomBackgndColor = roomBackgndColor;
	}
	
}
