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
public class SparkLineDM extends DiscreteMeasure implements java.io.Serializable {

	/**
	 * This Class is used to hold the values related to Sparkline graph. 
	 */
	private static final long serialVersionUID = 1L;
	
	private LineChartAxisContainer lineChartAxisContainer;
	/**
	 * @return the lineChartAxisContainer
	 */
	public LineChartAxisContainer getLineChartAxisContainer() {
		return lineChartAxisContainer;
	}
	/**
	 * @param lineChartAxisContainer the lineChartAxisContainer to set
	 */
	public void setLineChartAxisContainer(
			LineChartAxisContainer lineChartAxisContainer) {
		this.lineChartAxisContainer = lineChartAxisContainer;
	}
	

}
