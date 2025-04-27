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

import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisComplaintHO;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author saraswathir 
 *
 */
public class DiagnosisComplaintResponse extends GenericResponse {
	
	private ArrayList<String> selectedComplaints;
	private ArrayList<DiagnosisComplaintHO> complaintsList;
	/**
	 * @return the selectedComplaints
	 */
	public ArrayList<String> getSelectedComplaints() {
		return selectedComplaints;
	}
	/**
	 * @param selectedComplaints the selectedComplaints to set
	 */
	public void setSelectedComplaints(ArrayList<String> selectedComplaints) {
		this.selectedComplaints = selectedComplaints;
	}
	/**
	 * @return the complaintsList
	 */
	public ArrayList<DiagnosisComplaintHO> getComplaintsList() {
		return complaintsList;
	}
	/**
	 * @param complaintsList the complaintsList to set
	 */
	public void setComplaintsList(ArrayList<DiagnosisComplaintHO> complaintsList) {
		this.complaintsList = complaintsList;
	}

}
