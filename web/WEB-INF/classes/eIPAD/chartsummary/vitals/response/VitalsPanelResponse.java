/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.response;
import eIPAD.chartsummary.common.response.*;

import java.util.*;
import eIPAD.chartsummary.vitals.healthobject.*;
public class VitalsPanelResponse extends GenericResponse{
	private NormalcyIndicator normalcyIndicator;
	private List<VitalsPanel> listVitalsPanel;
	private String chartId;

	/**
	 * @return the listVitalsPanel 
	 */
	public List<VitalsPanel> getListVitalsPanel() {
		return listVitalsPanel;
	}

	/**
	 * @param listVitalsPanel the listVitalsPanel to set
	 */
	public void setListVitalsPanel(List<VitalsPanel> listVitalsPanel) {
		this.listVitalsPanel = listVitalsPanel;
	}

	/**
	 * @return the normalcyIndicator
	 */
	public NormalcyIndicator getNormalcyIndicator() {
		return normalcyIndicator;
	}

	/**
	 * @param normalcyIndicator the normalcyIndicator to set
	 */
	public void setNormalcyIndicator(NormalcyIndicator normalcyIndicator) {
		this.normalcyIndicator = normalcyIndicator;
	}

	/**
	 * @return the chartId
	 */
	public String getChartId() {
		return chartId;
	}

	/**
	 * @param chartId the chartId to set
	 */
	public void setChartId(String chartId) {
		this.chartId = chartId;
	}
	
}
