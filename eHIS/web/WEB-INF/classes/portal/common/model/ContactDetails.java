/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.common.model;

/**
 * This class defines all the Contact detail attributes required for 
 * Hospital and patient information
 * 
 * @author skrishnared2
 */
public class ContactDetails {

	/**
	 * Instance variables
	 */
	private String primaryTelephoneNo;
	private String secondaryTelephoneNo;
	private String faxNumber;
	private String emailId;
	private String websiteId;
	
	/**
	 * @return the primaryTelephoneNo
	 */
	public String getPrimaryTelephoneNo() {
		return primaryTelephoneNo;
	}
	/**
	 * @param primaryTelephoneNo the primaryTelephoneNo to set
	 */
	public void setPrimaryTelephoneNo(String primaryTelephoneNo) {
		if(primaryTelephoneNo != null){
			this.primaryTelephoneNo = primaryTelephoneNo;
		} else {
			this.primaryTelephoneNo = "";
		}
	}
	/**
	 * @return the secondaryTelephoneNo
	 */
	public String getSecondaryTelephoneNo() {
		return secondaryTelephoneNo;
	}
	/**
	 * @param secondaryTelephoneNo the secondaryTelephoneNo to set
	 */
	public void setSecondaryTelephoneNo(String secondaryTelephoneNo) {
		if(secondaryTelephoneNo != null){
			this.secondaryTelephoneNo = secondaryTelephoneNo;
		} else {
			this.secondaryTelephoneNo = "";
		}
	}
	/**
	 * @return the faxNumber
	 */
	public String getFaxNumber() {
		return faxNumber;
	}
	/**
	 * @param faxNumber the faxNumber to set
	 */
	public void setFaxNumber(String faxNumber) {
		if(faxNumber != null){
			this.faxNumber = faxNumber;
		} else {
			this.faxNumber = "";
		}
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		if(emailId != null){
			this.emailId = emailId;
		} else {
			this.emailId = "";
		}
	}
	/**
	 * @return the websiteId
	 */
	public String getWebsiteId() {
		return websiteId;
	}
	/**
	 * @param websiteId the websiteId to set
	 */
	public void setWebsiteId(String websiteId) {
		if(websiteId != null){
			this.websiteId = websiteId;
		} else {
			this.websiteId = "";
		}
	}
	
}
