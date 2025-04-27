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
package eIPAD.chartsummary.activeproblems.healthobject;

import eIPAD.chartsummary.common.healthobject.SfsHo;

/**
 * @author saraswathir  
 *
 */
public class DiagnosisSfsHO extends SfsHo {
	private String sensitiveYN;

	/**
	 * @return the sensitiveYN
	 */
	public String getSensitiveYN() {
		return sensitiveYN;
	}

	/**
	 * @param sensitiveYN the sensitiveYN to set
	 */
	public void setSensitiveYN(String sensitiveYN) {
		this.sensitiveYN = sensitiveYN;
	}
}
