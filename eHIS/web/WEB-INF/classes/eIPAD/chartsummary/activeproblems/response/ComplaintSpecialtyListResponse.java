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
package eIPAD.chartsummary.activeproblems.response;

import java.util.ArrayList;

import eIPAD.chartsummary.activeproblems.healthobject.ComplaintSpecialtyHO;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author SaraswathiR  
 *
 */
public class ComplaintSpecialtyListResponse extends GenericResponse{

	ArrayList<ComplaintSpecialtyHO> specialtyList = new ArrayList<ComplaintSpecialtyHO>();

	/**
	 * @return the specialtyList
	 */
	public ArrayList<ComplaintSpecialtyHO> getSpecialtyList() {
		return specialtyList;
	}

	/**
	 * @param specialtyList the specialtyList to set
	 */
	public void setSpecialtyList(ArrayList<ComplaintSpecialtyHO> specialtyList) {
		this.specialtyList = specialtyList;
	}
}
