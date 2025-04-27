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
package eIPAD.DiaryView.response;

import java.util.*;

import eIPAD.DiaryView.healthobject.AppointmentBlockItem;


import eIPAD.chartsummary.common.response.*;

/**
 * @author vchoughule
 *
 */
public class DiaryViewResponse extends GenericResponse{
	private List<AppointmentBlockItem> apptBlockItemList = new ArrayList<AppointmentBlockItem>();

/*
	public boolean isEmptyDataResponse(){
		boolean isEmpty = false;
		ArrayList<ErrorInfo> errorsList = getErrorsList();
		if(!errorsList.isEmpty()){
			for(ErrorInfo errorInfo:errorsList){
				if(errorInfo.getErrorType() == Errors.PROBLEMSDIAGNOSIS_EMPTY_DATA)
				{
					isEmpty = true;
					break;
				}
			}
		}
		return isEmpty;
	}

	*/

	/**
	 * @return the apptBlockItemList
	 */
	public List<AppointmentBlockItem> getApptBlockItemList() {
		return apptBlockItemList;
	}

	/**
	 * @param apptBlockItemList the apptBlockItemList to set
	 */
	public void setApptBlockItemList(List<AppointmentBlockItem> apptBlockItemList) {
		this.apptBlockItemList = apptBlockItemList;
	}
}
