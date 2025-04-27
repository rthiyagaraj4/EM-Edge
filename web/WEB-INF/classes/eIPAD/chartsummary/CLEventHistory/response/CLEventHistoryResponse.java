/**
 *  @author poorani
 */
package eIPAD.chartsummary.CLEventHistory.response;

import java.util.ArrayList;
import java.util.List;

import eIPAD.chartsummary.CLEventHistory.healthobject.CLEventHistoryData;
import eIPAD.chartsummary.CLEventHistory.healthobject.CLEventHistoryGroupData;
import eIPAD.chartsummary.CLEventHistory.healthobject.CLEventHistoryItemHO;
import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesFieldItem;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.common.response.GenericResponse;


public class CLEventHistoryResponse extends GenericResponse{
	private List<CLEventHistoryItemHO> CLEventsList;
	
	

	/**
	 * @return the cLEventsList
	 */
	public List<CLEventHistoryItemHO> getCLEventsList() {
		return CLEventsList;
	}



	/**
	 * @param cLEventsList the cLEventsList to set
	 */
	public void setCLEventsList(List<CLEventHistoryItemHO> cLEventsList) {
		CLEventsList = cLEventsList;
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
