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
 * This is the response class which stores the list of practitioners
 * for a speciality
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "Practitioners")
public class PractitionerResponse extends BaseResponse {

	/**
	 * Stores the list of practitioners
	 */
	private List<PractitionerModel> practitionerModelList = null;

	/**
	 * @return the practitionerModelList
	 */
	@XmlElementWrapper(name = "PractitionerDetails")
	@XmlElement(name = "PractitionerDetail")
	public List<PractitionerModel> getPractitionerModelList() {
		return practitionerModelList;
	}

	/**
	 * @param practitionerModelList the practitionerModelList to set
	 */
	public void setPractitionerModelList(
			List<PractitionerModel> practitionerModelList) {
		this.practitionerModelList = practitionerModelList;
	}
	
	/**
	 * 
	 */
	public void printResults(){
		if(practitionerModelList != null && !practitionerModelList.isEmpty()){
			System.out.println("printing the practitioner list - totally "+practitionerModelList.size()+" records");
			System.out.println("--------------------------------------------------------------------------------------------------------");
			for(PractitionerModel model : practitionerModelList){
				model.printResult();
			}
			System.out.println("--------------------------------------------------------------------------------------------------------");
		}
	}
	
	
}
