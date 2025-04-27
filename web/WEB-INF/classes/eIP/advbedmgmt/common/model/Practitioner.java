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
 * This model class represents the practitioner details of a bed's
 * occupying patient 
 * @author gramamoorthy
 *
 */
public class Practitioner {

	/**
	 * data members in this class
	 */
	private String practitionerId = null;
	
	private String practitionerName = null;

	/**
	 * default empty constructor
	 */
	public Practitioner(){
		// does not do anything
	}
	
	/**
	 * @param practitionerId
	 * @param practitionerName
	 */
	public Practitioner(String practitionerId, String practitionerName) {
		this.practitionerId = practitionerId;
		this.practitionerName = practitionerName;
	}

	/**
	 * @return the practitionerId
	 */
	public String getPractitionerId() {
		return practitionerId;
	}

	/**
	 * @param practitionerId the practitionerId to set
	 */
	public void setPractitionerId(String practitionerId) {
		this.practitionerId = practitionerId;
	}

	/**
	 * @return the practitionerName
	 */
	public String getPractitionerName() {
		return practitionerName;
	}

	/**
	 * @param practitionerName the practitionerName to set
	 */
	public void setPractitionerName(String practitionerName) {
		this.practitionerName = practitionerName;
	}	

}
