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
import java.util.ArrayList;
import java.util.List;

/**
 * @author GRamamoorthy
 *
 */
public class PreviousResultsResponse implements Serializable {

	/**
	 * 
	 */
	private List<PreviousResults> previousResultsList = new ArrayList<PreviousResults>();
	
	/**
	 * 
	 */
	private List<PrevResultDateContainer> prevResultDateContainerList = new ArrayList<PrevResultDateContainer>();
	
	/**
	 * Stores data to describe the event for which previous
	 * results are obtained
	 */
	private PreviousResultEventDescriptor eventDescriptor = null;
	
	/**
	 * default constructor of the class
	 */
	public PreviousResultsResponse() {
	}

	/**
	 * @return the previousResultsList
	 */
	public List<PreviousResults> getPreviousResultsList() {
		return previousResultsList;
	}

	/**
	 * @param previousResultsList the previousResultsList to set
	 */
	public void setPreviousResultsList(List<PreviousResults> previousResultsList) {
		this.previousResultsList = previousResultsList;
	}

	/**
	 * @return the prevResultDateContainerList
	 */
	public List<PrevResultDateContainer> getPrevResultDateContainerList() {
		return prevResultDateContainerList;
	}

	/**
	 * @param prevResultDateContainerList the prevResultDateContainerList to set
	 */
	public void setPrevResultDateContainerList(
			List<PrevResultDateContainer> prevResultDateContainerList) {
		this.prevResultDateContainerList = prevResultDateContainerList;
	}

	/**
	 * @return the eventDescriptor
	 */
	public PreviousResultEventDescriptor getEventDescriptor() {
		return eventDescriptor;
	}

	/**
	 * @param eventDescriptor the eventDescriptor to set
	 */
	public void setEventDescriptor(PreviousResultEventDescriptor eventDescriptor) {
		this.eventDescriptor = eventDescriptor;
	}

}
