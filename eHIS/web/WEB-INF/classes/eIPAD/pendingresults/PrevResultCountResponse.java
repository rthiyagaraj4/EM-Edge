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
public class PrevResultCountResponse implements Serializable {

	/**
	 * 
	 */
	private List<PrevResultDateContainer> prevResultDateContainerList = new ArrayList<PrevResultDateContainer>();
	
	/**
	 * Default constructor of the class
	 */
	public PrevResultCountResponse() {
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

}
