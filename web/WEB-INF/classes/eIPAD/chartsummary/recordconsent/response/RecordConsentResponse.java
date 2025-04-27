/**
 * 
 */
package eIPAD.chartsummary.recordconsent.response;

import java.util.ArrayList;
import java.util.List;

import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.recordconsent.healthobject.RecordConsentHO;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author psenthil
 *
 */
public class RecordConsentResponse extends GenericResponse{
	
	private List<RecordConsentHO> RecordConsentCount;
	/**
	 * @return the recordConsentCount
	 */
	public List<RecordConsentHO> getRecordConsentCount() {
		return RecordConsentCount;
	}

	/**
	 * @param recordConsentCount the recordConsentCount to set
	 */
	public void setRecordConsentCount(List<RecordConsentHO> recordConsentCount) {
		RecordConsentCount = recordConsentCount;
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
