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

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import portalrefimpl.common.response.BaseResponse;



/**
 * This class will be used as the response class
 * for getting the list of specialities needed in
 * the create appointment functionality
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "Specialities")
public class SpecialityResponse extends BaseResponse {

	/**
	 * Stores the list of the specialities
	 */
	private List<SpecialityModel> specialityList = null;

	/**
	 * @return the specialityList
	 */
	@XmlElementWrapper(name = "SpecialityDetails")
	@XmlElement(name = "SpecialityDetail")
	public List<SpecialityModel> getSpecialityList() {
		return specialityList;
	}

	/**
	 * @param specialityList the specialityList to set
	 */
	public void setSpecialityList(List<SpecialityModel> specialityList) {
		this.specialityList = specialityList;
	}
	
	
	
}
