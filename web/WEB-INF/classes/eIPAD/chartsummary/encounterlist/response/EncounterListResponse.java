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
package eIPAD.chartsummary.encounterlist.response;

import java.util.ArrayList;

import eIPAD.chartsummary.common.response.GenericResponse;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;

/**
 * @author SaraswathiR
 *
 */
public class EncounterListResponse extends GenericResponse{
	
	private ArrayList<EncounterHO> encounterList = new ArrayList<EncounterHO>();

	/**
	 * @return the encounterList
	 */
	public ArrayList<EncounterHO> getEncounterList() {
		return encounterList;
	}

	/**
	 * @param encounterList the encounterList to set
	 */
	public void setEncounterList(ArrayList<EncounterHO> encounterList) {
		this.encounterList = encounterList;
	}
	

}
