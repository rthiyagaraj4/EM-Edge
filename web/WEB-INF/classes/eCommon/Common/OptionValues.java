/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCommon.Common; 

public class OptionValues implements java.io.Serializable{

	private String display;
	private String value;
	private boolean isDefault;
	/**
 	 * 
 	 * @param value		code
     * @param display	Display
    */
	public OptionValues(String value, String display) {
		this.display = display;
		this.value = value;
	}
	
	/**
	 * 
	 * @param display 	sets display string
	 */
	public void setDisplay(String display) {
		this.display = display;
	}

	/**
	 * 
	 * @param value 	sets code value
	 */
	public void  setValue(String value) {
		this.value = value;
	}
	
	/**
	 * 
	 * @return	returns code
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 
	 * @return	returns display string
	 */
	public String getDisplay() {
		return display;
	}	

	/**
	 * 
	 * @param isDefault 	Sets the current object as default display 
	 */
	public void  setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * 
	 * @param object	String to compare with
	 * @return	boolean	indicating whether values are equals
	 */
	public boolean equals(String object) {
			return (value.equals(object))?true:false;
	}

	/**
	 * 
	 * @return returns String representation of option value
	 */
	public String toString() {
		if (isDefault) {
			return "<option value = \""+value+"\" selected >"+display+"</option>";	
		}
		return "<option value = \""+value+"\">"+display+"</option>";
	}
}
