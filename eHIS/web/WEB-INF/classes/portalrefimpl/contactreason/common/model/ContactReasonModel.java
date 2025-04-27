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
package portalrefimpl.contactreason.common.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the model class which will represent a particular contact reason.
 * A contact reason is made up of a code and description
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "ContactReason")
public class ContactReasonModel {

	private String code = null;
	
	private String description = null;

	/**
	 * Default constructor of the class
	 * does nothing
	 */
	public ContactReasonModel(){
		
	}
	
	/**
	 * Constructor taking the code and description
	 * @param code
	 * @param description
	 */
	public ContactReasonModel(String code, String description){
		this.code = code;
		this.description = description;
	}
	
	/**
	 * @return the code
	 */
	@XmlElement(name = "Code")
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	@XmlElement(name = "Description")
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
