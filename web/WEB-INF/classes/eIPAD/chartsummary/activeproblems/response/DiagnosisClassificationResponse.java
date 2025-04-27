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

import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisClassificationHO;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author SaraswathiR 
 *
 */
public class DiagnosisClassificationResponse extends GenericResponse {
	private ArrayList<DiagnosisClassificationHO> diagClassificationList = new ArrayList<DiagnosisClassificationHO>();
	private String defaultValue;
	/**
	 * @return the diagClassificationList
	 */
	public ArrayList<DiagnosisClassificationHO> getDiagClassificationList() {
		return diagClassificationList;
	}

	/**
	 * @param diagClassificationList the diagClassificationList to set
	 */
	public void setDiagClassificationList(
			ArrayList<DiagnosisClassificationHO> diagClassificationList) {
		this.diagClassificationList = diagClassificationList;
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
