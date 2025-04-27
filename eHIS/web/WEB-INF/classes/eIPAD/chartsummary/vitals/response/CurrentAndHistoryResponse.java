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
import java.text.SimpleDateFormat;
public class CurrentAndHistoryResponse extends GenericResponse {
	//private Map<CurrentAndHistoryDM,ArrayList<DiscreteValue>> mapCurrentAndHistoryDM;
	private List<CurrentAndHistoryDM> lstCurrentAndHistoryDM;
	
	/**
	 * @return the lstCurrentAndHistoryDM 
	 */
	public List<CurrentAndHistoryDM> getLstCurrentAndHistoryDM() {
		return lstCurrentAndHistoryDM;
	}
	/*
	 *  This method takes event code as a parameter and loops through the list to check whether the list contains an object with the same event code.
	 */
	public CurrentAndHistoryDM getDiscreteMeasure(String eventCode)
	{
		CurrentAndHistoryDM oCurrHistDM = null;
			if(lstCurrentAndHistoryDM != null && lstCurrentAndHistoryDM.size() > 0)
			{
				for(CurrentAndHistoryDM objCurrHistDM : lstCurrentAndHistoryDM)
				{
					if(objCurrHistDM != null && objCurrHistDM.getEventCode().equals(eventCode))
					{
						oCurrHistDM = objCurrHistDM;
						break;
					}
				}
			}
		return oCurrHistDM;
	}

	/**
	 * @param lstCurrentAndHistoryDM the lstCurrentAndHistoryDM to set
	 */
	public void setLstCurrentAndHistoryDM(
			List<CurrentAndHistoryDM> lstCurrentAndHistoryDM) {
		this.lstCurrentAndHistoryDM = lstCurrentAndHistoryDM;
	}
	/**
	 * This method loops through the discrete value list and returns all the discrete value which does not have the rank as 1.
	 */
	public List<DiscreteValue> getHistoryValues(CurrentAndHistoryDM oCurrentAndHistoryDM)
	{
		    List<DiscreteValue> lstHistoryValues = new ArrayList<DiscreteValue>();
			if(oCurrentAndHistoryDM != null && oCurrentAndHistoryDM.getDiscreteValuesList() != null && oCurrentAndHistoryDM.getDiscreteValuesList().size() > 0)
			{
				/*
				int nCount = 0;
				int nTotalCount = 0;
				nTotalCount = oCurrentAndHistoryDM.getDiscreteValuesList().size();
				for(nCount = 0 ; nCount < nTotalCount; nCount++)
				{
					DiscreteValue oDiscreteValue = oCurrentAndHistoryDM.getDiscreteValuesList().get(nCount);
					if(oDiscreteValue != null && !oDiscreteValue.getRank().equals("1"))
					{
						lstHistoryValues.add(oDiscreteValue);
					}
					
				}
				*/
				List<DiscreteValue> discreteValueList =  oCurrentAndHistoryDM.getDiscreteValuesList();
				for(DiscreteValue oDiscreteValue : discreteValueList)
				{
					if(oDiscreteValue != null && !oDiscreteValue.getRank().equals("1"))
					{
						lstHistoryValues.add(oDiscreteValue);
					}
				}
			}
		return lstHistoryValues;
	}
	/**
	 * This method loops through the discrete value list and returns the last 25 discrete values, which is used to plot the graph.
	 */
	public LineChartAxisContainer getChartValues(CurrentAndHistoryDM oCurrentAndHistoryDM)
	{
		LineChartAxisContainer oLineChartAxisContainer = null;
		ArrayList<GraphXAxis> oGraphXAxisList = new ArrayList<GraphXAxis>();
		ArrayList<GraphYAxis> oGraphYAxisList = new ArrayList<GraphYAxis>();
		if(oCurrentAndHistoryDM != null && oCurrentAndHistoryDM.getDiscreteValuesList() != null && oCurrentAndHistoryDM.getDiscreteValuesList().size() > 0)
		{
			int nCount = 0;
			int nTotalCount = oCurrentAndHistoryDM.getDiscreteValuesList().size();
			oLineChartAxisContainer = new LineChartAxisContainer();
			for(nCount = 0 ; nCount < nTotalCount; nCount++)
			{
				if(nCount == 25)
				{
					break;
				}
				DiscreteValue oDiscreteValue = oCurrentAndHistoryDM.getDiscreteValuesList().get(nCount);
				if(oDiscreteValue != null)
				{
					GraphXAxis oGraphXAxis = new GraphXAxis();
					GraphYAxis oGraphYAxis = new GraphYAxis();
					//if(oGraphXAxisList.size() < 25 && oGraphYAxisList.size() < 25)
				//	{
						oGraphXAxis.setEventDateTime(oDiscreteValue.getEventDateTimestamp());
						oGraphYAxis.setResultNumber(oDiscreteValue.getResultNumber());
						oGraphXAxisList.add(oGraphXAxis);
						oGraphYAxisList.add(oGraphYAxis);
					//}
				}
			}
			oLineChartAxisContainer.setoGraphXAxisList(oGraphXAxisList);
			oLineChartAxisContainer.setoGraphYAxisList(oGraphYAxisList);
			
		}
		return oLineChartAxisContainer;
	}
	/**
	 * This method returns all the unique dates from the discretevalue list.
	 */
	public DateContainer getDateContainer()
	{
		DateContainer oDateContainer = new DateContainer();
		List<Date> dateList = new ArrayList<Date>();
		CurrentAndHistoryDM oCurrHistDM = null;
		try
		{
			if(lstCurrentAndHistoryDM != null && lstCurrentAndHistoryDM.size() > 0)
			{
				int nLoopCount = 0;
				int nSize = lstCurrentAndHistoryDM.size();
				for(nLoopCount = 0 ; nLoopCount < nSize; nLoopCount++)
				{
					oCurrHistDM  = lstCurrentAndHistoryDM.get(nLoopCount);
					if(oCurrHistDM != null && oCurrHistDM.getDiscreteValuesList() != null && oCurrHistDM.getDiscreteValuesList().size() > 0)
					{
						List<DiscreteValue> discreteValueList	= oCurrHistDM.getDiscreteValuesList();
						for(DiscreteValue oDiscreteValue : discreteValueList)
						{
							if(oDiscreteValue != null)
							{
								if(!dateList.contains(oDiscreteValue.getEventDateTimestamp()))
								{
									dateList.add(oDiscreteValue.getEventDateTimestamp());
								}
							}
						}
					}
				}
				Collections.sort(dateList,Collections.reverseOrder());
			}
		}
		catch(Exception e)
		{
		}
		finally
		{
			oDateContainer.setDateList(dateList);
		}
		return oDateContainer;
	}
	public CurrentAndHistoryDM getDiscreteValueForAllDates(CurrentAndHistoryDM oCurrHistoryDM,DateContainer oDateContainer)
	{
		CurrentAndHistoryDM objcurrentHistoryDM = null;
		if(oCurrHistoryDM != null && oCurrHistoryDM.getDiscreteValuesList() != null && oCurrHistoryDM.getDiscreteValuesList().size() > 0 && oDateContainer != null && oDateContainer.getDateList() != null && oDateContainer.getDateList().size() > 0)
		{
			List<DiscreteValue> tempDiscreteValueList = oCurrHistoryDM.getDiscreteValuesList();
			List<DiscreteValue> discreteValueList = new ArrayList<DiscreteValue>();
			List<Date> tempDateList = oDateContainer.getDateList();
			objcurrentHistoryDM = oCurrHistoryDM;
			objcurrentHistoryDM.setDiscreteValuesList(null);
			for(Date oDate: tempDateList)
			{
				DiscreteValue oDiscreteValue = getAllDiscreteValue(oDate,tempDiscreteValueList);
				discreteValueList.add(oDiscreteValue);
				/*
				for(DiscreteValue oDiscreteValue : tempDiscreteValueList)
				{
					if(oDiscreteValue != null && oDate != null)
					{
						if(oDiscreteValue.getEventDateTimestamp().equals(oDate))
						{
							//discreteValueList.add(oDiscreteValue);
						}
						else
						{
							//discreteValueList.add(null);
						}
					}
				}
				*/
			}
			objcurrentHistoryDM.setDiscreteValuesList(discreteValueList);
		}
		return objcurrentHistoryDM;
	}
	private DiscreteValue getAllDiscreteValue(Date oDate,List<DiscreteValue> tempDiscreteValueList)
	{
		DiscreteValue objDiscreteValue = null;
		for(DiscreteValue oDiscreteValue : tempDiscreteValueList)
		{
			if(oDiscreteValue != null && oDate != null)
			{
				if(oDiscreteValue.getEventDateTimestamp().equals(oDate))
				{
					objDiscreteValue = oDiscreteValue;
					break;
				}
			}
		}
		
		return objDiscreteValue;
	}
	public String formatDate(Date oDate,String dateFormat)
	{
		String strDate = "";
		if(oDate != null && dateFormat != null && !dateFormat.equals(""))
		{
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			strDate = sdf.format(oDate);
		}
		return strDate;
	}
}
