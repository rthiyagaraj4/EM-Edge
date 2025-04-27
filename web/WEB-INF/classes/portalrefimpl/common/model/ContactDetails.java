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
package portalrefimpl.common.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import portalrefimpl.PortalConstants;
import portalrefimpl.common.CommonConstants;

/**
 * This is the model class storing the contact details
 * for a person, hospital/clinic
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "ContactDetails")
public class ContactDetails {

	private List<String> telephoneNumbers;
	
	private String faxNumber;
	
	private String emailId;
	
	private String websiteId;

	/**
	 * @return the telephoneNumbers
	 */
	@XmlElementWrapper(name = "TelephoneNumbers")
	@XmlElement(name = "TelephoneNumber")
	public List<String> getTelephoneNumbers() {
		return telephoneNumbers;
	}

	/**
	 * @param telephoneNumbers the telephoneNumbers to set
	 */
	public void setTelephoneNumbers(List<String> telephoneNumbers) {
		this.telephoneNumbers = telephoneNumbers;
	}

	/**
	 * @return the faxNumber
	 */
	@XmlElement(name = "FaxNumber")
	public String getFaxNumber() {
		return faxNumber;
	}

	/**
	 * @param faxNumber the faxNumber to set
	 */
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	/**
	 * @return the emailId
	 */
	@XmlElement(name = "EmailId")
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the websiteId
	 */
	@XmlElement(name = "WebsiteId")
	public String getWebsiteId() {
		return websiteId;
	}

	/**
	 * @param websiteId the websiteId to set
	 */
	public void setWebsiteId(String websiteId) {
		this.websiteId = websiteId;
	}
	
	
	/**
	 * This method returns the contents of this object
	 * as an xml string
	 * @return
	 */
	public String getXMLString(){
		StringBuffer xmlContentBuff = new StringBuffer();
		
		// all the contact details are enclosed within
		// the contact details tag
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.CONTACTDETAILS_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		
		// now put the individual data one by one
		// telephone numbers
		if(telephoneNumbers != null && !telephoneNumbers.isEmpty()){
			xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
					.append(CommonConstants.TELEPHONE_NUMBERS_XML_TAG)
					.append(PortalConstants.XML_CLOSE_TAG);
			
			for(String telephoneNumber: telephoneNumbers){
				if(telephoneNumber == null){
					telephoneNumber = "";
				}
				
				xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
						.append(CommonConstants.TELEPHONE_NUMBER_XML_TAG)
						.append(PortalConstants.XML_CLOSE_TAG);
				xmlContentBuff.append(telephoneNumber);
				xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
						.append(CommonConstants.TELEPHONE_NUMBER_XML_TAG)
						.append(PortalConstants.XML_CLOSE_TAG);
			}
			
			xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
					.append(CommonConstants.TELEPHONE_NUMBERS_XML_TAG)
					.append(PortalConstants.XML_CLOSE_TAG);
			
		}
		
		// fax
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.FAX_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String tempFax = faxNumber;
		if (tempFax == null) {
			tempFax = "";
		}
		xmlContentBuff.append(tempFax);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.FAX_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		
		// email id
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.EMAILID_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String tempEmailId = emailId;
		if (tempEmailId == null) {
			tempEmailId = "";
		}
		xmlContentBuff.append(tempEmailId);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.EMAILID_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		
		// web site
		xmlContentBuff.append(PortalConstants.OPEN_XML_TAG)
				.append(CommonConstants.WEBSITE_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		String tempWebSite = websiteId;
		if (tempWebSite == null) {
			tempWebSite = "";
		}
		xmlContentBuff.append(tempWebSite);
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.WEBSITE_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		
		// finally close the contact details tag
		xmlContentBuff.append(PortalConstants.CLOSE_XML_TAG)
				.append(CommonConstants.CONTACTDETAILS_XML_TAG)
				.append(PortalConstants.XML_CLOSE_TAG);
		
		return xmlContentBuff.toString();
	}
	
}
