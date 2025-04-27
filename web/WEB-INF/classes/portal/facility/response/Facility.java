/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.facility.response;
/**
 * This class is used in Facility response as an element of facility
 * 
 * @author vkodancha
 * 
 */
	
public class Facility {
	/**
	 * constructor
	 * @param facilityId
	 * @param facilityName
	 */
	public Facility(String facilityId,String facilityName){
		this.facilityId = facilityId;
		this.facilityName = facilityName;
	}
	// instance variable
	private String facilityId;
	private String facilityName;
	
	/**
	 * @return the facilityId
	 */
	public String getFacilityId() {
		return facilityId;
	}
	/**
	 * @return the facilityName
	 */
	public String getFacilityName() {
		return facilityName;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("facilityId : "+facilityId);
		sb.append("facilityName : "+facilityName);
		return super.toString();
	}
}
