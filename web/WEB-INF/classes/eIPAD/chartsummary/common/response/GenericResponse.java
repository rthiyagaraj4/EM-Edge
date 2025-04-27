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
package eIPAD.chartsummary.common.response;

import java.util.ArrayList;

/**
 * @author SaraswathiR
 *
 */
public abstract class GenericResponse {
	
	protected ArrayList<ErrorInfo> errorsList = new ArrayList<ErrorInfo>();

	/**
	 * @return the errorsList
	 */
	public ArrayList<ErrorInfo> getErrorsList() {
		return errorsList;
	}

	/**
	 * @param errorsList the errorsList to set
	 */
	public void setErrorsList(ArrayList<ErrorInfo> errorsList) {
		this.errorsList = errorsList;
	}
	
	/**
	 * @return boolean - Returns true if the response does not contain any errors
	 */
	public boolean isSuccessResponse(){
		boolean isSuccessful = true;
		if(!errorsList.isEmpty()){
			for(ErrorInfo errorInfo:errorsList){
				if(errorInfo.getErrorType() != Errors.COMMON_SUCCESS && errorInfo.getErrorType() != Errors.COMMON_EMPTY_DATA)
				{
					isSuccessful = false;
					break;
				}
			}
		}
		return isSuccessful;
	}
	
	public boolean isEmptyDataResponse(){
		boolean isEmpty = false;
		if(!errorsList.isEmpty()){
			for(ErrorInfo errorInfo:errorsList){
				if(errorInfo.getErrorType() == Errors.COMMON_EMPTY_DATA)
				{
					isEmpty = true;
					break;
				}
			}
		}
		return isEmpty;
	}
			

}
