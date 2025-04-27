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

import java.util.List;

import eIPAD.chartsummary.common.response.GenericResponse;
import eIPAD.chartsummary.activeproblems.healthobject.ComplaintSfsHO;
/**
 * @author SaraswathiR  
 *
 */
public class ComplaintSfsResponse extends GenericResponse {

	private List<ComplaintSfsHO> complaintSfsList;

	/**
	 * @return the complaintSfsList
	 */
	public List<ComplaintSfsHO> getComplaintSfsList() {
		return complaintSfsList;
	}

	/**
	 * @param complaintSfsList the complaintSfsList to set
	 */
	public void setComplaintSfsList(List<ComplaintSfsHO> complaintSfsList) {
		this.complaintSfsList = complaintSfsList;
	}
}
