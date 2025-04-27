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

import eIPAD.chartsummary.activeproblems.healthobject.AnatomicalSiteHO;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author SaraswathiR  
 *
 */
public class DiagAnatomicalSiteResponse extends GenericResponse {
	
	private ArrayList<AnatomicalSiteHO> diagAnatomicalSiteList = new ArrayList<AnatomicalSiteHO>();
	private String defaultValue;
	/**
	 * @return the diagAnatomicalSiteList
	 */
	public ArrayList<AnatomicalSiteHO> getDiagAnatomicalSiteList() {
		return diagAnatomicalSiteList;
	}

	/**
	 * @param diagAnatomicalSiteList the diagAnatomicalSiteList to set
	 */
	public void setDiagAnatomicalSiteList(
			ArrayList<AnatomicalSiteHO> diagAnatomicalSiteList) {
		this.diagAnatomicalSiteList = diagAnatomicalSiteList;
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
