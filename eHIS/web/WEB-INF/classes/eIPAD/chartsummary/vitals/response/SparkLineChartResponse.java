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

public class SparkLineChartResponse extends GenericResponse{
	private List<SparkLineDM> lstSparkLineDM;

	/**
	 * @return the lstSparkLineDM 
	 */
	public List<SparkLineDM> getLstSparkLineDM() {
		return lstSparkLineDM;
	}

	/**
	 * @param lstSparkLineDM the lstSparkLineDM to set
	 */
	public void setLstSparkLineDM(List<SparkLineDM> lstSparkLineDM) {
		this.lstSparkLineDM = lstSparkLineDM;
	}
	/*
	public boolean isSuccessResponse(){
		boolean isSuccessful = true;
		if(!errorsList.isEmpty()){
			for(ErrorInfo errorInfo:errorsList){
				if(errorInfo.getErrorType() != Errors.COMMON_SUCCESS && errorInfo.getErrorType() != Errors.COMMON_EMPTY_DATA && errorInfo.getErrorType() != Errors.NO_CHART_CONFIGURED)
				{
					isSuccessful = false;
					break;
				}
			}
		}
		return isSuccessful;
	}
	*/
	public SparkLineDM getDiscreteMeasure(String eventCode)
	{
		SparkLineDM oSparkLineDM = null;
		try
		{
			if(lstSparkLineDM != null && lstSparkLineDM.size() > 0)
			{
				int nLoopCount = 0;
				int nSize = lstSparkLineDM.size();
				for(nLoopCount = 0 ; nLoopCount < nSize; nLoopCount++)
				{
					SparkLineDM objSparkLineDM = lstSparkLineDM.get(nLoopCount);
					if(objSparkLineDM != null && objSparkLineDM.getEventCode().equals(eventCode))
					{
						oSparkLineDM = objSparkLineDM;
						break;
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
		return oSparkLineDM;
	}
	
}
