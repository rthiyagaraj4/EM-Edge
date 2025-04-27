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

import eIP.advbedmgmt.common.model.BasicRoom;

/**
 * This model class represents a room which will contain a collection
 * of bediconsection objects
 * This class is used in the response class for bed icon section
 * @author GRamamoorthy
 *
 */
public class RoomForBedIconSection extends BasicRoom {

	private List<BedIconSection> bedIcons = null;

	/**
	 * @return the bedIcons
	 */
	public List<BedIconSection> getBedIcons() {
		return bedIcons;
	}

	/**
	 * @param bedIcons the bedIcons to set
	 */
	public void setBedIcons(List<BedIconSection> bedIcons) {
		this.bedIcons = bedIcons;
	}

	/**
	 * override hashcode
	 */
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * override equals
	 */
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	
	
}
