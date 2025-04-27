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

import eIPAD.chartsummary.common.response.GenericResponse;
import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisAccuracyHO;

/**
 * @author SaraswathiR 
 *
 */
public class DiagnosisAccuracyResponse extends GenericResponse {

	private ArrayList<DiagnosisAccuracyHO> diagAccuracyList = new ArrayList<DiagnosisAccuracyHO>();
	private String defaultValue;
	/**
	 * @return the diagAccuracyList
	 */
	public ArrayList<DiagnosisAccuracyHO> getDiagAccuracyList() {
		return diagAccuracyList;
	}

	/**
	 * @param diagAccuracyList the diagAccuracyList to set
	 */
	public void setDiagAccuracyList(ArrayList<DiagnosisAccuracyHO> diagAccuracyList) {
		this.diagAccuracyList = diagAccuracyList;
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
