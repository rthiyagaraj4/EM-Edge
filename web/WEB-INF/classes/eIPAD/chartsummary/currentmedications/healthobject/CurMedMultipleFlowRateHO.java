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
package eIPAD.chartsummary.currentmedications.healthobject;

import java.util.Date;

/**
 * @author vchoughule
 *
 */
public class CurMedMultipleFlowRateHO {
	private String totalStrength ;
	private String totStrengthUOM ; 
	private String infuseOver ; 
	private String infuseOverUnit;
	private String infusionRate;
	private String infusionVolStrUnit;
	private String infusionVolStrUnitDesc;
	private String infusionPerUnit;
	private String StartDateTime;
	private String EndDateTime;
	private String gapInHrs;
	/**
	 * @return the totalStrength
	 */
	public String getTotalStrength() {
		return totalStrength;
	}
	/**
	 * @param totalStrength the totalStrength to set
	 */
	public void setTotalStrength(String totalStrength) {
		this.totalStrength = totalStrength;
	}
	/**
	 * @return the totStrengthUOM
	 */
	public String getTotStrengthUOM() {
		return totStrengthUOM;
	}
	/**
	 * @param totStrengthUOM the totStrengthUOM to set
	 */
	public void setTotStrengthUOM(String totStrengthUOM) {
		this.totStrengthUOM = totStrengthUOM;
	}
	/**
	 * @return the infuseOver
	 */
	public String getInfuseOver() {
		return infuseOver;
	}
	/**
	 * @param infuseOver the infuseOver to set
	 */
	public void setInfuseOver(String infuseOver) {
		this.infuseOver = infuseOver;
	}
	/**
	 * @return the infuseOverUnit
	 */
	public String getInfuseOverUnit() {
		return infuseOverUnit;
	}
	/**
	 * @param infuseOverUnit the infuseOverUnit to set
	 */
	public void setInfuseOverUnit(String infuseOverUnit) {
		this.infuseOverUnit = infuseOverUnit;
	}
	/**
	 * @return the infusionRate
	 */
	public String getInfusionRate() {
		return infusionRate;
	}
	/**
	 * @param infusionRate the infusionRate to set
	 */
	public void setInfusionRate(String infusionRate) {
		this.infusionRate = infusionRate;
	}
	/**
	 * @return the infusionVolStrUnit
	 */
	public String getInfusionVolStrUnit() {
		return infusionVolStrUnit;
	}
	/**
	 * @param infusionVolStrUnit the infusionVolStrUnit to set
	 */
	public void setInfusionVolStrUnit(String infusionVolStrUnit) {
		this.infusionVolStrUnit = infusionVolStrUnit;
	}
	/**
	 * @return the infusionVolStrUnitDesc
	 */
	public String getInfusionVolStrUnitDesc() {
		return infusionVolStrUnitDesc;
	}
	/**
	 * @param infusionVolStrUnitDesc the infusionVolStrUnitDesc to set
	 */
	public void setInfusionVolStrUnitDesc(String infusionVolStrUnitDesc) {
		this.infusionVolStrUnitDesc = infusionVolStrUnitDesc;
	}
	/**
	 * @return the infusionPerUnit
	 */
	public String getInfusionPerUnit() {
		return infusionPerUnit;
	}
	/**
	 * @param infusionPerUnit the infusionPerUnit to set
	 */
	public void setInfusionPerUnit(String infusionPerUnit) {
		this.infusionPerUnit = infusionPerUnit;
	}
	/**
	 * @return the startDateTime
	 */
	public String getStartDateTime() {
		return StartDateTime;
	}
	/**
	 * @param startDateTime the startDateTime to set
	 */
	public void setStartDateTime(String startDateTime) {
		StartDateTime = startDateTime;
	}
	/**
	 * @return the endDateTime
	 */
	public String getEndDateTime() {
		return EndDateTime;
	}
	/**
	 * @param endDateTime the endDateTime to set
	 */
	public void setEndDateTime(String endDateTime) {
		EndDateTime = endDateTime;
	}
	/**
	 * @return the gapInHrs
	 */
	public String getGapInHrs() {
		return gapInHrs;
	}
	/**
	 * @param gapInHrs the gapInHrs to set
	 */
	public void setGapInHrs(String gapInHrs) {
		this.gapInHrs = gapInHrs;
	}
	
}
