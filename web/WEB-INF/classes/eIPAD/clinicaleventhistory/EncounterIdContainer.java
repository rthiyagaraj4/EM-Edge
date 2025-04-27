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

/**
 * This class is a model class for storing the encounter id and
 * any other information related to encounter id.
 * This class can be used in request as well as response objects
 * 
 * @author GRamamoorthy 
 *
 */
public class EncounterIdContainer implements Serializable {

	/**
	 * Stores the encounter id
	 */
	private String encounterId = null;
	
	/**
	 * default constructor of the class
	 */
	public EncounterIdContainer() {
	}

	/**
	 * @return the encounterId
	 */
	public String getEncounterId() {
		return encounterId;
	}

	/**
	 * @param encounterId the encounterId to set
	 */
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}

}
