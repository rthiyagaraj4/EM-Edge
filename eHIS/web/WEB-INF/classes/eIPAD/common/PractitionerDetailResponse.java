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
package eIPAD.common;

import java.io.Serializable;

/**
 * @author GRamamoorthy
 *
 */
public class PractitionerDetailResponse implements Serializable {

	/**
	 * Stores the practitioner id
	 */
	private String practitionerId = null;
	
	/**
	 * Stores the practitioner name
	 */
	private String practitionerName = null;
	
	/**
	 * Default constructor of the class
	 */
	public PractitionerDetailResponse() {
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
