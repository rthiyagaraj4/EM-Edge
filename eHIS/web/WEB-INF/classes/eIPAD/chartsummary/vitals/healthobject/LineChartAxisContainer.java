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

public class LineChartAxisContainer extends ChartAxisContainer implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<GraphYAxis> oGraphYAxisList;
	/**
	 * @return the oGraphYAxisList 
	 */
	public ArrayList<GraphYAxis> getoGraphYAxisList() {
		return oGraphYAxisList;
	}
	/**
	 * @param oGraphYAxisList the oGraphYAxisList to set
	 */
	public void setoGraphYAxisList(ArrayList<GraphYAxis> oGraphYAxisList) {
		this.oGraphYAxisList = oGraphYAxisList;
	}
	
}
