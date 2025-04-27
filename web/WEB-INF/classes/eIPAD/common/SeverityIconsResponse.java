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
package eIPAD.common;

import java.io.Serializable;

/**
 * @author GRamamoorthy
 *
 */
public class SeverityIconsResponse implements Serializable {

	private String highSymbolIcon = null;
	
	private String lowSymbolIcon = null;
	
	private String abnormalSymbolIcon = null;
	
	private String criticalSymbolIcon = null;
	
	private String criticalHighSymbolIcon = null;
	
	private String criticalLowSymbolIcon = null;
	
	/**
	 * default constructor of the class
	 */
	public SeverityIconsResponse() {
	}

	/**
	 * @return the highSymbolIcon
	 */
	public String getHighSymbolIcon() {
		return highSymbolIcon;
	}

	/**
	 * @param highSymbolIcon the highSymbolIcon to set
	 */
	public void setHighSymbolIcon(String highSymbolIcon) {
		this.highSymbolIcon = highSymbolIcon;
	}

	/**
	 * @return the lowSymbolIcon
	 */
	public String getLowSymbolIcon() {
		return lowSymbolIcon;
	}

	/**
	 * @param lowSymbolIcon the lowSymbolIcon to set
	 */
	public void setLowSymbolIcon(String lowSymbolIcon) {
		this.lowSymbolIcon = lowSymbolIcon;
	}

	/**
	 * @return the abnormalSymbolIcon
	 */
	public String getAbnormalSymbolIcon() {
		return abnormalSymbolIcon;
	}

	/**
	 * @param abnormalSymbolIcon the abnormalSymbolIcon to set
	 */
	public void setAbnormalSymbolIcon(String abnormalSymbolIcon) {
		this.abnormalSymbolIcon = abnormalSymbolIcon;
	}

	/**
	 * @return the criticalSymbolIcon
	 */
	public String getCriticalSymbolIcon() {
		return criticalSymbolIcon;
	}

	/**
	 * @param criticalSymbolIcon the criticalSymbolIcon to set
	 */
	public void setCriticalSymbolIcon(String criticalSymbolIcon) {
		this.criticalSymbolIcon = criticalSymbolIcon;
	}

	/**
	 * @return the criticalHighSymbolIcon
	 */
	public String getCriticalHighSymbolIcon() {
		return criticalHighSymbolIcon;
	}

	/**
	 * @param criticalHighSymbolIcon the criticalHighSymbolIcon to set
	 */
	public void setCriticalHighSymbolIcon(String criticalHighSymbolIcon) {
		this.criticalHighSymbolIcon = criticalHighSymbolIcon;
	}

	/**
	 * @return the criticalLowSymbolIcon
	 */
	public String getCriticalLowSymbolIcon() {
		return criticalLowSymbolIcon;
	}

	/**
	 * @param criticalLowSymbolIcon the criticalLowSymbolIcon to set
	 */
	public void setCriticalLowSymbolIcon(String criticalLowSymbolIcon) {
		this.criticalLowSymbolIcon = criticalLowSymbolIcon;
	}

}
