/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.allergies.response;
import eIPAD.chartsummary.allergies.healthobject.*;
import eIPAD.chartsummary.common.response.*;

import java.util.*;
/**
 * @author GaneshkumarC 
 * 
 */
public class AllergyResponse extends GenericResponse{
	private List<Allergy> lstAllergyDetails;

	/**
	 * @return the lstAllergyDetails
	 */
	public List<Allergy> getAllergyDetails() {
		return lstAllergyDetails;
	}

	/**
	 * @param lstAllergyDetails the lstAllergyDetails to set
	 */
	public void setAllergyDetails(List<Allergy> lstAllergyDetails) {
		this.lstAllergyDetails = lstAllergyDetails;
	}
	/**
	 * @override this method is overridden since Problems Diagnosis will have the error item ALLERGYLIST_EMPTY_DATA
	 */
	public boolean isEmptyDataResponse(){
		boolean isEmpty = false;
		ArrayList<ErrorInfo> errorsList = getErrorsList();
		if(!errorsList.isEmpty()){
			for(ErrorInfo errorInfo:errorsList){
				if(errorInfo.getErrorType() == Errors.ALLERGYLIST_EMPTY_DATA)
				{
					isEmpty = true;
					break;
				}
			}
		}
		return isEmpty;
	}

}
