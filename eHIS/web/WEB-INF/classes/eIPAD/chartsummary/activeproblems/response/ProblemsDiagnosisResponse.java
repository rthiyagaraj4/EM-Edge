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
package eIPAD.chartsummary.activeproblems.response;

import java.util.ArrayList;

import eIPAD.chartsummary.activeproblems.healthobject.ProblemsDiagnosisHO;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author SaraswathiR
 *
 */
public class ProblemsDiagnosisResponse extends GenericResponse {
	
	private ArrayList<ProblemsDiagnosisHO> problemsDiagnosisList = new ArrayList<ProblemsDiagnosisHO>();
	private boolean sensitiveDataPresent;
	private int sensitiveDiagnosisCount;
	private boolean sensitiveDataShown;
	/**
	 * @return the problemsDiagnosisList
	 */
	public ArrayList<ProblemsDiagnosisHO> getProblemsDiagnosisList() {
		return problemsDiagnosisList;
	}

	/**
	 * @param problemsDiagnosisList the problemsDiagnosisList to set
	 */
	public void setProblemsDiagnosisList(ArrayList<ProblemsDiagnosisHO> problemsDiagnosisList) {
		this.problemsDiagnosisList = problemsDiagnosisList;
	}

	/**
	 * @return the sensitiveDataPresent
	 */
	public boolean isSensitiveDataPresent() {
		return sensitiveDataPresent;
	}

	/**
	 * @param sensitiveDataPresent the sensitiveDataPresent to set
	 */
	public void setSensitiveDataPresent(boolean sensitiveDataPresent) {
		this.sensitiveDataPresent = sensitiveDataPresent;
	}

	/**
	 * @return the sensitiveDiagnosisCount
	 */
	public int getSensitiveDiagnosisCount() {
		return sensitiveDiagnosisCount;
	}

	/**
	 * @param sensitiveDiagnosisCount the sensitiveDiagnosisCount to set
	 */
	public void setSensitiveDiagnosisCount(int sensitiveDiagnosisCount) {
		this.sensitiveDiagnosisCount = sensitiveDiagnosisCount;
	}

	/**
	 * @return the sensitiveDataShown
	 */
	public boolean isSensitiveDataShown() {
		return sensitiveDataShown;
	}

	/**
	 * @param sensitiveDataShown the sensitiveDataShown to set
	 */
	public void setSensitiveDataShown(boolean sensitiveDataShown) {
		this.sensitiveDataShown = sensitiveDataShown;
	}
	
	/**
	 * @override this method is overridden since Problems Diagnosis will have the error item PROBLEMSDIAGNOSIS_EMPTY_DATA
	 */
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

}
