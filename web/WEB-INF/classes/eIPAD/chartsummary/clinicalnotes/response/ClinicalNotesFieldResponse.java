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

import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesFieldItem;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author vchoughule 
 *
 */
public class ClinicalNotesFieldResponse extends GenericResponse{

	/*private List<ClinicalNotesJSONFileds> noteTypeList;*/
	/*private List<ClinicalNotesJSONFileds> noteGroupList;*/
	private List<ClinicalNotesFieldItem> fieldList;
	/**
	 * @override this method is overridden since Problems Diagnosis will have the error item ALLERGYLIST_EMPTY_DATA
	 */
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
	 * @return the fieldList
	 */
	public List<ClinicalNotesFieldItem> getFieldList() {
		return fieldList;
	}
	/**
	 * @param fieldList the fieldList to set
	 */
	public void setFieldList(List<ClinicalNotesFieldItem> fieldList) {
		this.fieldList = fieldList;
	}
}
