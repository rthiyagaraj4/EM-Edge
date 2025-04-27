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
public class LineChartResponse  extends GenericResponse{
	private List<LineChartDM> lstLineChartDM;

	/**
	 * @return the lstLineChartDM 
	 */
	public List<LineChartDM> getLstLineChartDM() {
		return lstLineChartDM;
	}

	/**
	 * @param lstLineChartDM the lstLineChartDM to set
	 */
	public void setLstLineChartDM(List<LineChartDM> lstLineChartDM) {
		this.lstLineChartDM = lstLineChartDM;
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
}
