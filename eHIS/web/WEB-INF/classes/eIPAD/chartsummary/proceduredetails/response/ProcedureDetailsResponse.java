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
package eIPAD.chartsummary.proceduredetails.response;
import eIPAD.chartsummary.common.response.*;

import java.util.*;

import eIPAD.chartsummary.proceduredetails.healthobject.*;
/**
 * @author GaneshkumarC 
 *
 */
public class ProcedureDetailsResponse extends GenericResponse {
	private List<ProcedureDetailsHO> lstProcedureDetails;

	/**
	 * @return the lstProcedureDetails
	 */
	public List<ProcedureDetailsHO> getLstProcedureDetails() {
		return lstProcedureDetails;
	}

	/**
	 * @param lstProcedureDetails the lstProcedureDetails to set
	 */
	public void setLstProcedureDetails(List<ProcedureDetailsHO> lstProcedureDetails) {
		this.lstProcedureDetails = lstProcedureDetails;
	}
	/**
	 * @override this method is overridden since Problems Diagnosis will have the error item ALLERGYLIST_EMPTY_DATA
	 */
	public boolean isEmptyDataResponse(){
		boolean isEmpty = false;
		ArrayList<ErrorInfo> errorsList = getErrorsList();
		if(!errorsList.isEmpty()){
			for(ErrorInfo errorInfo:errorsList){
				if(errorInfo.getErrorType() == Errors.PROCEDUREDETAILS_EMPTY_DATA)
				{
					isEmpty = true;
					break;
				}
			}
		}
		return isEmpty;
	}
	
}
