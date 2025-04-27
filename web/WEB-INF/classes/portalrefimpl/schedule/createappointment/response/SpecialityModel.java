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
package portalrefimpl.schedule.createappointment.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This model class contains information about one speciality
 * Contains the speciality code and the short description
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "SpecialityDetail")
public class SpecialityModel {

	/**
	 * Stores the short description of the speciality
	 */
	private String shortDesc = null;
	
	/**
	 * Stores the code of the speciality
	 */
	private String specialityCode = null;
	
	/**
	 * Default constructor of the class
	 */
	public SpecialityModel(){
		
	}
	
	/**
	 * Constructor taking the short description and the speciality code
	 * as inputs
	 * @param shortDesc
	 * @param specialityCode
	 */
	public SpecialityModel(String shortDesc,String specialityCode){
		this.shortDesc = shortDesc;
		this.specialityCode = specialityCode;
	}
	

	/**
	 * @return the shortDesc
	 */
	@XmlElement(name = "SpecialityDescription")
	public String getShortDesc() {
		return shortDesc;
	}

	/**
	 * @param shortDesc the shortDesc to set
	 */
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	/**
	 * @return the specialityCode
	 */
	@XmlElement(name = "SpecialityCode")
	public String getSpecialityCode() {
		return specialityCode;
	}

	/**
	 * @param specialityCode the specialityCode to set
	 */
	public void setSpecialityCode(String specialityCode) {
		this.specialityCode = specialityCode;
	}
	
}
