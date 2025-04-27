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
 * This model class holds information of a floor layout
 * Currently the dimensions of a floor are only stored
 * @author GRamamoorthy
 *
 */
public class FloorLayout {

	/**
	 * data members in the class
	 */
	private int floorWidth = 0;
	
	private int floorHeight = 0;

	/**
	 * @return the floorWidth
	 */
	public int getFloorWidth() {
		return floorWidth;
	}

	/**
	 * @param floorWidth the floorWidth to set
	 */
	public void setFloorWidth(int floorWidth) {
		this.floorWidth = floorWidth;
	}

	/**
	 * @return the floorHeight
	 */
	public int getFloorHeight() {
		return floorHeight;
	}

	/**
	 * @param floorHeight the floorHeight to set
	 */
	public void setFloorHeight(int floorHeight) {
		this.floorHeight = floorHeight;
	}		
}
