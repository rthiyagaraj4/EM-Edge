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
package eIP.advbedmgmt.transaction.access.request;

/**
 * This is the request class for getting access rights for CRUD
 * operations in bed manager GUI
 * @author GRamamoorthy
 *
 */
public class AccessRequest {

	/**
	 * Data members in this class
	 */
	private String menuId = null;
	
	private String functionId = null;
	
	private String locale = null;
	
	/**
	 * This variable holds the name of the functionality
	 * for which access rights are being obtained
	 */
	private String functionalityIdentifier = null;

	/**
	 * @return the menuId
	 */
	public String getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

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
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * @return the functionalityIdentifier
	 */
	public String getFunctionalityIdentifier() {
		return functionalityIdentifier;
	}

	/**
	 * @param functionalityIdentifier the functionalityIdentifier to set
	 */
	public void setFunctionalityIdentifier(String functionalityIdentifier) {
		this.functionalityIdentifier = functionalityIdentifier;
	}		

}
