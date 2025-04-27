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
package eAlert.src.databeans;

/**
 * @author prasannar 
 *
 */
public class AlertFlagOptions {

	private String timeIntervalCode;
	
	private String timeIntervalDesc;

	/**
	 * @return the timeIntervalCode
	 */
	public String getTimeIntervalCode() {
		return timeIntervalCode;
	}

	/**
	 * @param timeIntervalCode the timeIntervalCode to set
	 */
	public void setTimeIntervalCode(String timeIntervalCode) {
		this.timeIntervalCode = timeIntervalCode;
	}

	/**
	 * @return the timeIntervalDesc
	 */
	public String getTimeIntervalDesc() {
		return timeIntervalDesc;
	}

	/**
	 * @param timeIntervalDesc the timeIntervalDesc to set
	 */
	public void setTimeIntervalDesc(String timeIntervalDesc) {
		this.timeIntervalDesc = timeIntervalDesc;
	} 
}
