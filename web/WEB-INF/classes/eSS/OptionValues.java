/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* This is class is used for displaying the list box values*/
package eSS;

public class OptionValues {

	private String display;
	private String value;
	private boolean isDefault;

	public OptionValues(String value, String display) {
		this.display = display;
		this.value = value;
	}
	
	public void setDisplay(String display) {
		this.display = display;
	}

	public void  setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public String getDisplay() {
		return display;
	}	

	public void  setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public boolean equals(String object) {
			return (value.equals(object))?true:false;
	}

	public String toString() {
		if (isDefault) {
			return "<option value = \""+value+"\" selected >"+display+"</option>";	
		}
		return "<option value = \""+value+"\">"+display+"</option>";
	}
}
