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
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.clinicalnotes.healthobject.*;
import java.util.*;
/**
 * @author GaneshkumarC 
 *
 */
public class ClinicalNotesResponse extends GenericResponse{
	private List<ClinicalNoteGroup> listNoteGroup;
	private List<NormalViewDetails> listNormalViewDetails;
	private List<NormalViewDetailsTimeRange> listNormalViewDetailsTimeRange; 
	/**
	 * @return the listNormalViewDetailsTimeRanges
	 */
	public List<NormalViewDetailsTimeRange> getListNormalViewDetailsTimeRange() {
		return listNormalViewDetailsTimeRange;
	}
	/**
	 * @param listNormalViewDetailsTimeRanges the listNormalViewDetailsTimeRanges to set
	 */
	public void setListNormalViewDetailsTimeRange(List<NormalViewDetailsTimeRange> listNormalViewDetailsTimeRange) {
		this.listNormalViewDetailsTimeRange = listNormalViewDetailsTimeRange;
	}
	/*private List<ClinicalNotesSFSNoteType> listSFSNoteType;*/
	/**
	 * @return the listNoteGroup 
	 */
	public List<ClinicalNoteGroup> getListNoteGroup() {
		return listNoteGroup;
	}
	/**
	 * @param listNoteGroup the listNoteGroup to set
	 */
	public void setListNoteGroup(List<ClinicalNoteGroup> listNoteGroup) {
		this.listNoteGroup = listNoteGroup;
	}
	/**
	 * @return the listNormalViewDetails
	 */
	public List<NormalViewDetails> getListNormalViewDetails() {
		return listNormalViewDetails;
	}
	/**
	 * @param listNormalViewDetails the listNormalViewDetails to set
	 */
	public void setListNormalViewDetails(List<NormalViewDetails> listNormalViewDetails) {
		this.listNormalViewDetails = listNormalViewDetails;
	}
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

}
