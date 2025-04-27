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

import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisSfsHO;
import eIPAD.chartsummary.common.healthobject.SfsHo;
import eIPAD.chartsummary.common.response.GenericResponse;
import eIPAD.chartsummary.common.response.SfsResponse;

/**
 * @author saraswathir 
 *
 */
public class DiagnosisSfsResponse extends GenericResponse {
	private List<DiagnosisSfsHO> DiagnosisSfsList;

	/**
	 * @return the diagnosisSfsList
	 */
	public List<DiagnosisSfsHO> getDiagnosisSfsList() {
		return DiagnosisSfsList;
	}

	/**
	 * @param diagnosisSfsList the diagnosisSfsList to set
	 */
	public void setDiagnosisSfsList(List<DiagnosisSfsHO> diagnosisSfsList) {
		DiagnosisSfsList = diagnosisSfsList;
	}

}
