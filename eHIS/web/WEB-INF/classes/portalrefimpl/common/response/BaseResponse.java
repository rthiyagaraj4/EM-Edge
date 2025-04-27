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
package portalrefimpl.common.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

import portalrefimpl.PortalConstants;

/**
 * This is the base class for representing a response of an operation This class
 * needs to be extended to provide more specific operation responses
 * 
 * @author GRamamoorthy
 * 
 */
public class BaseResponse {

	/**
	 * data members in the class
	 */
	protected ErrorInfo errorInfo = null;

	protected List<ErrorInfo> errors = new ArrayList<ErrorInfo>();

	/**
	 * @return the errorInfo
	 */
	@XmlTransient
	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	/**
	 * @param errorInfo
	 *            the errorInfo to set
	 */
	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	/**
	 * This method forms a new error info object with the given error code and
	 * error message and adds the error info object to errors list
	 * 
	 * @param errorCode
	 * @param errorMessage
	 */
	public void addError(int errorCode, String errorMessage) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMessage);
		addError(errorInfo);
		// errors.add(errorInfo);
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
	 * @return the errors
	 */
	@XmlElementWrapper(name = "Errors")
	@XmlElement(name = "Error")
	public List<ErrorInfo> getErrors() {
		return errors;
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
	 * This method adds all the given errors to the list of errors maintained in
	 * this instance
	 * 
	 * @param errors
	 */
	public void addAllErrors(List<ErrorInfo> errors) {
		this.errors.addAll(errors);
	}

	/**
	 * 
	 * @return
	 */
	public String getErrorAsXMLString() {
		StringBuffer xmlFileContent = new StringBuffer();

		// just for safe handling
		if (!hasErrors()) {
			xmlFileContent.append(PortalConstants.CLOSE_XML_TAG)
					.append(PortalConstants.ERRORS_WRAPPER_KEY)
					.append(PortalConstants.XML_CLOSE_TAG);
			return xmlFileContent.toString();
		}
		// normal flow
		xmlFileContent.append(PortalConstants.OPEN_XML_TAG)
				.append(PortalConstants.ERRORS_WRAPPER_KEY)
				.append(PortalConstants.XML_CLOSE_TAG);
		for (ErrorInfo errorInfo : errors) {
			// open with error tag
			xmlFileContent.append(PortalConstants.OPEN_XML_TAG)
					.append(PortalConstants.ERROR_KEY)
					.append(PortalConstants.XML_CLOSE_TAG);

			// now error code and error message
			xmlFileContent.append(PortalConstants.OPEN_XML_TAG)
					.append(PortalConstants.ERRORCODE_KEY)
					.append(PortalConstants.XML_CLOSE_TAG);

			xmlFileContent.append(errorInfo.getErrorCode());

			xmlFileContent.append(PortalConstants.CLOSE_XML_TAG)
					.append(PortalConstants.ERRORCODE_KEY)
					.append(PortalConstants.XML_CLOSE_TAG);

			xmlFileContent.append(PortalConstants.OPEN_XML_TAG)
					.append(PortalConstants.ERRORMESSAGE_KEY)
					.append(PortalConstants.XML_CLOSE_TAG);

			String errorMessage = errorInfo.getErrorMessage();
			if (errorMessage == null) {
				errorMessage = "";
			}
			xmlFileContent.append(errorMessage);

			xmlFileContent.append(PortalConstants.CLOSE_XML_TAG)
					.append(PortalConstants.ERRORMESSAGE_KEY)
					.append(PortalConstants.XML_CLOSE_TAG);

			// close the error tag
			xmlFileContent.append(PortalConstants.CLOSE_XML_TAG)
					.append(PortalConstants.ERROR_KEY)
					.append(PortalConstants.XML_CLOSE_TAG);
		}

		xmlFileContent.append(PortalConstants.CLOSE_XML_TAG)
				.append(PortalConstants.ERRORS_WRAPPER_KEY)
				.append(PortalConstants.XML_CLOSE_TAG);

		return xmlFileContent.toString();
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
			if(errorMessage == null){
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
	 * 
	 * @param errorInfo
	 * @return
	 */
	protected boolean shouldConsiderErrorObject(ErrorInfo errorInfo){
		boolean consider = false;
		int errorCode = errorInfo.getErrorCode();
		if(ErrorInfo.SUCCESS_CODE != errorCode){
			consider = true;
		}
		
		return consider;
	}
	
}
