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
package portalrefimpl.common.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This model class will hold information about a facility
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "Facility")
public class Facility {

	/**
	 * data members in this class
	 */
	private String facilityId;
	
	private String facilityName;

	/**
	 * @return the facilityId
	 */
	@XmlElement(name = "FacilityId")
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
	 * @return the facilityName
	 */
	@XmlElement(name = "FacilityName")
	public String getFacilityName() {
		return facilityName;
	}

	/**
	 * @param facilityName the facilityName to set
	 */
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	/**
	 * This method checks if the given object
	 * equals this object
	 */
	public boolean equals(Object obj) {
		boolean equals = false;
		if(!(obj instanceof Facility)){
			return equals;
		}
		String tempFacilityId = ((Facility)obj).getFacilityId();
		if(tempFacilityId != null && tempFacilityId.equals(this.facilityId)){
			equals = true;
		}
		
		return equals;
	}
	
}
