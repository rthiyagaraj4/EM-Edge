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
import java.util.Hashtable;
import java.util.List;

import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesSectionItem;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.common.response.GenericResponse;

public class ClinicalNotesSectionListResponse extends GenericResponse {
	private List<ClinicalNotesSectionItem> sectionList;
	
	
	/**
	 * @return the sectionList
	 */
	public List<ClinicalNotesSectionItem> getSectionList() {
		return sectionList;
	}


	/**
	 * @param sectionList the sectionList to set
	 */
	public void setSectionList(List<ClinicalNotesSectionItem> sectionList) {
		this.sectionList = sectionList;
	}


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





}
