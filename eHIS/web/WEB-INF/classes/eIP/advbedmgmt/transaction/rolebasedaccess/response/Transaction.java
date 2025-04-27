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
package eIP.advbedmgmt.transaction.rolebasedaccess.response;

import java.io.Serializable;

import eIP.advbedmgmt.transaction.rolebasedaccess.TransactionListConstants;

/**
 * This is the model class for representing an individual transaction
 * This model class is used in representing transactions allowed for a user
 * based on the role of the user
 * @author gramamoorthy
 *
 */
public class Transaction implements Serializable {

	/**
	 * data members in the class
	 */
	private String moduleId = null;
	
	private String functionId = null;
	
	private String functionDesc = null;
	
	private String insertAccessYN = null;
	
	private String updateAccessYN = null;
	
	private String deleteAccessYN = null;
	
	private String printAccessYN = null;
	
	private String queryOnlyAccessYN = null;
	
	private String executableURL = null;

	/**
	 * @return the functionId
	 */
	public String getFunctionId() {
		return functionId;
	}

	/**
	 * @param functionId the functionId to set
	 */
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	/**
	 * @return the functionName
	 */
	public String getFunctionDesc() {
		return functionDesc;
	}

	/**
	 * @param functionName the functionName to set
	 */
	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
	}

	/**
	 * @return the insertAccessYN
	 */
	public String getInsertAccessYN() {
		return insertAccessYN;
	}

	/**
	 * @param insertAccessYN the insertAccessYN to set
	 */
	public void setInsertAccessYN(String insertAccessYN) {
		this.insertAccessYN = insertAccessYN;
	}

	/**
	 * @return the updateAccessYN
	 */
	public String getUpdateAccessYN() {
		return updateAccessYN;
	}

	/**
	 * @param updateAccessYN the updateAccessYN to set
	 */
	public void setUpdateAccessYN(String updateAccessYN) {
		this.updateAccessYN = updateAccessYN;
	}

	/**
	 * @return the deleteAccessYN
	 */
	public String getDeleteAccessYN() {
		return deleteAccessYN;
	}

	/**
	 * @param deleteAccessYN the deleteAccessYN to set
	 */
	public void setDeleteAccessYN(String deleteAccessYN) {
		this.deleteAccessYN = deleteAccessYN;
	}

	/**
	 * @return the printAccessYN
	 */
	public String getPrintAccessYN() {
		return printAccessYN;
	}

	/**
	 * @param printAccessYN the printAccessYN to set
	 */
	public void setPrintAccessYN(String printAccessYN) {
		this.printAccessYN = printAccessYN;
	}

	/**
	 * @return the queryOnlyAccessYN
	 */
	public String getQueryOnlyAccessYN() {
		return queryOnlyAccessYN;
	}

	/**
	 * @param queryOnlyAccessYN the queryOnlyAccessYN to set
	 */
	public void setQueryOnlyAccessYN(String queryOnlyAccessYN) {
		this.queryOnlyAccessYN = queryOnlyAccessYN;
	}

	/**
	 * @return the executableURL
	 */
	public String getExecutableURL() {
		return executableURL;
	}

	/**
	 * @param executableURL the executableURL to set
	 */
	public void setExecutableURL(String executableURL) {
		this.executableURL = executableURL;
	}

	/**
	 * @return the moduleId
	 */
	public String getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	
	/**
	 * This method returns a boolean flag
	 * which indicates whether this transaction is part
	 * of Inpatient Management module
	 * @return
	 */
	public boolean isInpatientModule(){
		boolean isInpatient = false;
		
		if (moduleId != null
				&& moduleId
						.equalsIgnoreCase(TransactionListConstants.INPATIENT_MGMT_MODULE)) {
			isInpatient = true;
		}
		
		return isInpatient;
	}

	/**
	 * over ridden 
	 */
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * checks equality with this object
	 */
	public boolean equals(Object obj) {
		boolean equals = false;
		// primary check
		if(!(obj instanceof Transaction)){
			return equals;
		}
		
		// two instances are equal if module id and
		// function id are equal
		Transaction tempInst = (Transaction)obj;
		String tempModuleId = tempInst.getModuleId();
		String tempFunctionId = tempInst.getFunctionId();
		
		if ((moduleId != null && moduleId.equals(tempModuleId))
				&& (functionId != null && functionId.equals(tempFunctionId))) {
			equals = true;
		}
		
		return equals;
	}
	
}
