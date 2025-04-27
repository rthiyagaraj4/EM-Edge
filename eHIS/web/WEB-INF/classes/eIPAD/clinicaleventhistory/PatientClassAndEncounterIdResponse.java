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
package eIPAD.clinicaleventhistory;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * this is the response class for the patient class and encounter id response
 * to be given to the clinical event history page
 * @author GRamamoorthy 
 *
 */
public class PatientClassAndEncounterIdResponse implements Serializable {

	/**
	 * stores the patient class and the encounter ids mapped to each other
	 * as in real time, they are indeed mapped
	 */
	private Map<PatientClassResponse, List<EncounterIdContainer>> dataMap = new java.util.HashMap<PatientClassResponse, List<EncounterIdContainer>>();
	
	/**
	 * default constructor of the class
	 */
	public PatientClassAndEncounterIdResponse() {
	}

	/**
	 * @return the dataMap
	 */
	public Map<PatientClassResponse, List<EncounterIdContainer>> getDataMap() {
		return dataMap;
	}

	/**
	 * @param dataMap the dataMap to set
	 */
	public void setDataMap(
			Map<PatientClassResponse, List<EncounterIdContainer>> dataMap) {
		this.dataMap = dataMap;
	}

}
