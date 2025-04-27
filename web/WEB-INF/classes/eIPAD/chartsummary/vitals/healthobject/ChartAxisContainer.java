/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.healthobject;

import java.util.ArrayList;

public class ChartAxisContainer implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<GraphXAxis> oGraphXAxisList;

	/**
	 * @return the oGraphXAxisList 
	 */
	public ArrayList<GraphXAxis> getoGraphXAxisList() {
		return oGraphXAxisList;
	}

	/**
	 * @param oGraphXAxisList the oGraphXAxisList to set
	 */
	public void setoGraphXAxisList(ArrayList<GraphXAxis> oGraphXAxisList) {
		this.oGraphXAxisList = oGraphXAxisList;
	}
	
}
