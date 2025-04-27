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

import eIPAD.chartsummary.activeproblems.healthobject.ComplaintDetailsHO;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author SaraswathiR  
 *
 */
public class ComplaintDetailsResponse extends GenericResponse {
	private ComplaintDetailsHO complaintDetails;

	/**
	 * @return the complaintDetails
	 */
	public ComplaintDetailsHO getComplaintDetails() {
		return complaintDetails;
	}

	/**
	 * @param complaintDetails the complaintDetails to set
	 */
	public void setComplaintDetails(ComplaintDetailsHO complaintDetails) {
		this.complaintDetails = complaintDetails;
	}
}
