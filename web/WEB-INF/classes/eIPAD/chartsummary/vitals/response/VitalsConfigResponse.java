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
public class VitalsConfigResponse extends GenericResponse{
	private List<VitalsConfig> listVitalConfig;
	private String chartId;

	/**
	 * @return the listVitalConfig 
	 */
	public List<VitalsConfig> getListVitalConfig() {
		return listVitalConfig;
	}

	/**
	 * @param listVitalConfig the listVitalConfig to set
	 */
	public void setListVitalConfig(List<VitalsConfig> listVitalConfig) {
		this.listVitalConfig = listVitalConfig;
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
