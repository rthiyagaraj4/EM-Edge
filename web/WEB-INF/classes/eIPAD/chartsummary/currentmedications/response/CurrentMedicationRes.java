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
package eIPAD.chartsummary.currentmedications.response;

/**
 * @author GaneshkumarC modified by Vivek C - 31/03/2015 
 *
 */
import eIPAD.chartsummary.currentmedications.healthobject.*;
import eIPAD.chartsummary.common.response.*;

import java.util.*;

public class CurrentMedicationRes extends GenericResponse{
	private List<CurrentMedicationHO> lstCMDtls;
    private int count ;
    /**
	 * @return the lstCMDtls
	 */
	public List<CurrentMedicationHO> getCurrentMedicationList() {
		return lstCMDtls;
	}

	/**
	 * @param lstCMDtls the lstCMDtls to set
	 */
	public void setCurrentMedicationList(List<CurrentMedicationHO> lstCMDtls) {
		this.lstCMDtls = lstCMDtls;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isEmptyDataResponse(){
		boolean isEmpty = false;
		ArrayList<ErrorInfo> errorsList = getErrorsList();
		if(!errorsList.isEmpty()){
			for(ErrorInfo errorInfo:errorsList){ 
				if(errorInfo.getErrorType() == Errors.CURRENT_MEDICATION_EMPTY_DATA)
				{
					isEmpty = true;
					break;
				}
			}
		}
		return isEmpty;
	}

	
}
