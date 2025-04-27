/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.results.response;

import java.util.ArrayList;

import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.common.response.GenericResponse;
import eIPAD.chartsummary.results.healthobject.ResultHO;

/**
 * @author SaraswathiR  
 *
 */
public class ResultsResponse extends GenericResponse {

	ArrayList<ResultHO> results;

	/**
	 * @return the results
	 */
	public ArrayList<ResultHO> getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(ArrayList<ResultHO> results) {
		this.results = results;
	}

	public boolean isEmptyDataResponse(){
		boolean isEmpty = false;
		ArrayList<ErrorInfo> errorsList = getErrorsList();
		if(!errorsList.isEmpty()){
			for(ErrorInfo errorInfo:errorsList){
				if(errorInfo.getErrorType() == Errors.RESULTS_EMPTY_DATA)
				{
					isEmpty = true;
					break;
				}
			}
		}
		return isEmpty;
	}


}
