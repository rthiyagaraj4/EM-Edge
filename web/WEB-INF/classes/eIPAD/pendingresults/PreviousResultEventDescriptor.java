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
package eIPAD.pendingresults;

import java.io.Serializable;

/**
 * This is the model class to hold data about an event
 * in the case of previous results
 * @author GRamamoorthy
 *
 */
public class PreviousResultEventDescriptor implements Serializable {

	private String eventCategory = null;
	
	private String description = null;
	
	private String eventGroupDescription = null;
	
	private String eventDescription = null;
	
	private String resultDescriptor = null;
	
	/**
	 * default constructor
	 */
	public PreviousResultEventDescriptor() {
	}

	/**
	 * @return the eventCategory
	 */
	public String getEventCategory() {
		return eventCategory;
	}

	/**
	 * @param eventCategory the eventCategory to set
	 */
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the eventGroupDescription
	 */
	public String getEventGroupDescription() {
		return eventGroupDescription;
	}

	/**
	 * @param eventGroupDescription the eventGroupDescription to set
	 */
	public void setEventGroupDescription(String eventGroupDescription) {
		this.eventGroupDescription = eventGroupDescription;
	}

	/**
	 * @return the eventDescription
	 */
	public String getEventDescription() {
		return eventDescription;
	}

	/**
	 * @param eventDescription the eventDescription to set
	 */
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	/**
	 * @return the resultDescriptor
	 */
	public String getResultDescriptor() {
		return resultDescriptor;
	}

	/**
	 * @param resultDescriptor the resultDescriptor to set
	 */
	public void setResultDescriptor(String resultDescriptor) {
		this.resultDescriptor = resultDescriptor;
	}

}
