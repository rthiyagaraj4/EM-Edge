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
import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisSetHO;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author SaraswathiR 
 *
 */
public class DiagnosisSetResponse extends GenericResponse {

	private ArrayList<DiagnosisSetHO> diagnosisSetList = new ArrayList<DiagnosisSetHO>();
	private String defaultValue;
	/**
	 * @return the diagnosisSetList
	 */
	public ArrayList<DiagnosisSetHO> getDiagnosisSetList() {
		return diagnosisSetList;
	}

	/**
	 * @param diagnosisSetList the diagnosisSetList to set
	 */
	public void setDiagnosisSetList(ArrayList<DiagnosisSetHO> diagnosisSetList) {
		this.diagnosisSetList = diagnosisSetList;
	}

	/**
	 * @return the defaultValue
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * @param defaultValue the defaultValue to set
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
}
