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
package eIP.advbedmgmt.common.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the base class for representing a response of an operation This class
 * needs to be extended to provide more specific operation responses
 * 
 * @author gramamoorthy
 * 
 */
public class BaseResponse implements Serializable {

	/**
	 * 
	 */
	protected List<ErrorInfo> errors = new ArrayList<ErrorInfo>();

	/**
	 * @return the errors
	 */
	public List<ErrorInfo> getErrors() {
		return errors;
	}

	/**
	 * @param errors
	 *            the errors to set
	 */
	public void setErrors(List<ErrorInfo> errors) {
		this.errors = errors;
	}

	/**
	 * This method adds an error info object to the errors list
	 * 
	 * @param errorInfo
	 */
	public void addError(ErrorInfo errorInfo) {
		errors.add(errorInfo);
	}

	/**
	 * This method returns a boolean flag whether this instance has error info
	 * objects in the list returns true if errors are present, false otherwise
	 * 
	 * @return
	 */
	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	/**
	 * This method removes all the error objects from this response object
	 */
	public void clearAllErrors() {
		errors.clear();
	}

	/**
	 * This method returns the error messages contained in this object
	 * 
	 * @return
	 */
	public String getErrorMessage() {
		StringBuffer errorMessageBuffer = new StringBuffer();
		// safe check
		if (errors.isEmpty()) {
			return errorMessageBuffer.toString();
		}
		// iterate through the errors list and get the
		// error message from each error info object
		// and append it to the buffer
		int errorObjSize = errors.size();
		final String lineSeparator = System.getProperty("line.separator");
		ErrorInfo errorInfo = null;
		String errorMessage = null;
		for (int count = 0; count < errorObjSize; count++) {
			errorInfo = errors.get(count);
			errorMessage = errorInfo.getErrorMessage();
			// do not add null message
			if (errorMessage == null) {
				continue;
			}
			errorMessageBuffer.append(errorMessage);
			if (count != (errorObjSize - 1)) {
				errorMessageBuffer.append(lineSeparator);
			}
		}

		return errorMessageBuffer.toString();
	}

	/**
	 * This method returns a boolean flag which gives the status of the response
	 * - whether it is successful or not
	 * 
	 * @return
	 */
	public boolean isSuccessful() {
		boolean isSuccessful = false;
		// this should not be the case - but just handle it anyway
		if (errors.isEmpty()) {
			return isSuccessful;
		}
		// if there are more than 1 error objects - it has to be
		// a failure
		if (errors.size() > 1) {
			return isSuccessful;
		}
		boolean tempSuccess = true;
		// if the response is successful, the first error info
		// itself has to be successful - check for this alone
		// is enough
		int errorCode = 0;
		for (ErrorInfo errorInfo : errors) {
			errorCode = errorInfo.getErrorCode();
			if (shouldConsiderErrorObject(errorInfo)
					&& ErrorInfo.SUCCESS_CODE != errorCode) {
				tempSuccess = false;
				break;
			}
		}

		if (tempSuccess) {
			isSuccessful = true;
		}

		return isSuccessful;
	}

	/**
	 * 
	 * @param errorInfo
	 * @return
	 */
	protected boolean shouldConsiderErrorObject(ErrorInfo errorInfo) {
		boolean consider = false;
		int errorCode = errorInfo.getErrorCode();
		if (ErrorInfo.SUCCESS_CODE != errorCode) {
			consider = true;
		}

		return consider;
	}

}
