/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.HealthObjects;
import java.io.* ;
public class NursingUnit implements java.io.Serializable {
	public String sCode;
	 public String sDescription;
	/**
	 * @return the sCode
	 */
	public String getsCode() {
		return sCode;
	}
	/**
	 * @param sCode the sCode to set
	 */
	public void setsCode(String sCode) {
		this.sCode = sCode;
	}
	/**
	 * @return the sDescription
	 */
	public String getsDescription() {
		return sDescription;
	}
	/**
	 * @param sDescription the sDescription to set
	 */
	public void setsDescription(String sDescription) {
		this.sDescription = sDescription;
	}
	 
	 
}
