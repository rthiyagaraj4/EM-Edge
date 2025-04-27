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

import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisCustomGroupHO;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author SaraswathiR 
 *
 */
public class DiagnosisCustomGroupResponse extends GenericResponse{
	
	private ArrayList<DiagnosisCustomGroupHO> diagnosisCustomList = new ArrayList<DiagnosisCustomGroupHO>();

	/**
	 * @return the diagnosisCustomList
	 */
	public ArrayList<DiagnosisCustomGroupHO> getDiagnosisCustomList() {
		return diagnosisCustomList;
	}

	/**
	 * @param diagnosisCustomList the diagnosisCustomList to set
	 */
	public void setDiagnosisCustomList(
			ArrayList<DiagnosisCustomGroupHO> diagnosisCustomList) {
		this.diagnosisCustomList = diagnosisCustomList;
	}
	

}
