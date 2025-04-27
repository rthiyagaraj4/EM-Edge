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
public class FlowSheetResponse extends GenericResponse {
	private List<FlowSheetDM> flowSheetDMList;
	private List<FlowSheetData> flowSheetDataList;
	public List<FlowSheetDM> getFlowSheetDMList() {
		return flowSheetDMList;
	}
	public void setFlowSheetDMList(List<FlowSheetDM> flowSheetDMList) {
		this.flowSheetDMList = flowSheetDMList;
	}
	/**
	 * @param flowSheetDataList the flowSheetDataList to set 
	 */
	public void setFlowSheetDataList(List<FlowSheetData> flowSheetDataList) {
		this.flowSheetDataList = flowSheetDataList;
	}
	public FlowSheetDM getDiscreteMeasureForAllDates(String strDiscreteMeasure)
	{
		List<DiscreteValue> lstDiscreteValue = new ArrayList<DiscreteValue>();
		FlowSheetDM oFlowSheetDM = null;
		try
		{
			if(flowSheetDMList != null && flowSheetDMList.size() > 0)
			{
				int index = flowSheetDMList.indexOf(strDiscreteMeasure);
				
				if(index != -1)
				{
					oFlowSheetDM = flowSheetDMList.get(index);
					if(oFlowSheetDM != null)
					{
						List<DiscreteValue> discreteValueList = oFlowSheetDM.getDiscreteValueList();
						if(flowSheetDataList != null && flowSheetDataList.size() > 0)
						{
							for(FlowSheetData oFlowSheetData : flowSheetDataList)
							{
								DiscreteValue oDiscreteValue = null;
								if(discreteValueList != null && discreteValueList.size() > 0  )
								{
									int dateIndex = discreteValueList.indexOf(oFlowSheetData.getEventDateTime());
									if(dateIndex != -1)
									{
										oDiscreteValue = discreteValueList.get(dateIndex);
									}
									else
									{
										oDiscreteValue = new DiscreteValue();
									}
								}
								lstDiscreteValue.add(oDiscreteValue);
							}
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			
		}
		oFlowSheetDM.setDiscreteValueList(lstDiscreteValue);
		return oFlowSheetDM;
	}
	/**
	 * @return the flowSheetDataList
	 */
	public List<FlowSheetData> getFlowSheetDataList() {
		return flowSheetDataList;
	}

}
