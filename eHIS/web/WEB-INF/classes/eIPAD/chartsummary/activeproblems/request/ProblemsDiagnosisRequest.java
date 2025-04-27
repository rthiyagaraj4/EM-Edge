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
package eIPAD.chartsummary.activeproblems.request;

import eIPAD.chartsummary.common.request.GenericRequest;

/**
 * @author SaraswathiR 
 *
 */
public class ProblemsDiagnosisRequest extends GenericRequest {
	
	boolean showSensitive;

	/**
	 * @return the showSensitive
	 */
	public boolean isShowSensitive() {
		return showSensitive;
	}

	/**
	 * @param showSensitive the showSensitive to set
	 */
	public void setShowSensitive(boolean showSensitive) {
		this.showSensitive = showSensitive;
	}

}
