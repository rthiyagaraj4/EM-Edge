/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.healthobject;
import java.util.*;
public class CurrentAndHistoryDM extends DiscreteMeasure implements java.io.Serializable {

	/**
	 * This Class holds the Current and History values for a discrete measure. 
	 */
	private static final long serialVersionUID = 1L;
	private List<DiscreteValue> discreteValuesList;
	/**
	 * @return the discreteValuesList
	 */
	public List<DiscreteValue> getDiscreteValuesList() {
		return discreteValuesList;
	}
	/**
	 * @param discreteValuesList the discreteValuesList to set
	 */
	public void setDiscreteValuesList(List<DiscreteValue> discreteValuesList) {
		this.discreteValuesList = discreteValuesList;
	}

	
	
	
}
