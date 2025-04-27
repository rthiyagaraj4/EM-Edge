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
package eIPAD.chartsummary.clinicalnotes.response;

import java.util.ArrayList;
import java.util.List;

import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesSectionFields;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.common.response.GenericResponse;
/**
 * @author vchoughule
 *
 */
public class ClinicalNotesSectionResponse extends GenericResponse {
	private List<ClinicalNotesSectionFields> cNSecList;
	
	public boolean isEmptyDataResponse(){
		boolean isEmpty = false;
		ArrayList<ErrorInfo> errorsList = getErrorsList();
		if(!errorsList.isEmpty()){
			for(ErrorInfo errorInfo:errorsList){
				if(errorInfo.getErrorType() == Errors.CLINICALNOTES_EMPTY_DATA)
				{
					isEmpty = true;
					break;
				}
			}
		}
		return isEmpty;
	}

	/**
	 * @return the cNSecList
	 */
	public List<ClinicalNotesSectionFields> getcNSecList() {
		return cNSecList;
	}

	/**
	 * @param cNSecList the cNSecList to set
	 */
	public void setcNSecList(List<ClinicalNotesSectionFields> cNSecList) {
		this.cNSecList = cNSecList;
	}

}
