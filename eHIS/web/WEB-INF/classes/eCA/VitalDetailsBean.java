/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;  
import java.io.* ;
public class VitalDetailsBean implements java.io.Serializable
{
	private String sPatienID; 
	private String sEncounterID; 
	private String sFacilityID;
	private String sDiscrMsrId; 
	private String sShortDesc; 
	private String sDiscrMsrPanelId;
	private String sDiscrMsrResultType;
	private String sDiscrMsrResultNum;
	private String sDiscrMsrResultNumUom;
	private String sDiscrMsrResultStr;
	private String sCriticalLow;
	private String sNormalLow;
	private String sNormalHigh;
	private String sCriticalHigh;
	private String sAddedDate;
	private int iChartType;

	/**
	 * @return the Patient ID 
	 */
	public String getsPatienID() {
		return sPatienID;
	}
	/**
	 * @param sPatienID the sPatienID to set
	 */
	public void setsPatienID(String sPatienID) {
		this.sPatienID = sPatienID;
	}

	/**
	 * @return the Encounter ID 
	 */
	public String getsEncounterID() {
		return sEncounterID;
	}
	/**
	 * @param sEncounterID the sEncounterID to set
	 */
	public void setsEncounterID(String sEncounterID) {
		this.sEncounterID = sEncounterID;
	}

	/**
	 * @return the sFacilityID 
	 */
	public String getsFacilityID() {
		return sFacilityID;
	}
	/**
	 * @param sFacilityID the sFacilityID to set
	 */
	public void setsFacilityID(String sFacilityID) {
		this.sFacilityID = sFacilityID;
	}

	/**
	 * @return the discrete measure id
	 */
	public String getsDiscrMsrId() {
		return sDiscrMsrId;
	}
	/**
	 * @param sDiscrMsrId the sDiscrMsrId to set
	 */
	public void setsDiscrMsrId(String sDiscrMsrId) {
		this.sDiscrMsrId = sDiscrMsrId;
	}
	/**
	 * @return the discrete measure short description
	 */
	public String getsShortDesc() {
		return sShortDesc;
	}
	/**
	 * @param sShortDesc the sShortDesc to set
	 */
	public void setsShortDesc(String sShortDesc) {
		this.sShortDesc = sShortDesc;
	}
	/**
	 * @return the discrete measure panel id
	 */
	public String getsDiscrMsrPanelId() {
		return sDiscrMsrPanelId;
	}
	/**
	 * @param sDiscrMsrPanelId the sDiscrMsrPanelId to set
	 */
	public void setsDiscrMsrPanelId(String sDiscrMsrPanelId) {
		this.sDiscrMsrPanelId = sDiscrMsrPanelId;
	}
	/**
	 * @return the discrete measure result type
	 */
	public String getsDiscrMsrResultType() {
		return sDiscrMsrResultType;
	}
	/**
	 * @param sDiscrMsrResultType the sDiscrMsrResultType to set
	 */
	public void setsDiscrMsrResultType(String sDiscrMsrResultType) {
		this.sDiscrMsrResultType = sDiscrMsrResultType;
	}
	/**
	 * @return the discrete measure result number
	 */
	public String getsDiscrMsrResultNum() {
		return sDiscrMsrResultNum;
	}
	/**
	 * @param lDiscrMsrResultNum the lDiscrMsrResultNum to set
	 */
	public void setlDiscrMsrResultNum(String sDiscrMsrResultNum) {
		this.sDiscrMsrResultNum = sDiscrMsrResultNum;
	}
	/**
	 * @return the discrete measure result number UOM
	 */
	public String getsDiscrMsrResultNumUom() {
		return sDiscrMsrResultNumUom;
	}
	/**
	 * @param sDiscrMsrResultNumUom the sDiscrMsrResultNumUom to set
	 */
	public void setsDiscrMsrResultNumUom(String sDiscrMsrResultNumUom) {
		this.sDiscrMsrResultNumUom = sDiscrMsrResultNumUom;
	}
	/**
	 * @return the discrete measure result string
	 */
	public String getsDiscrMsrResultStr() {
		return sDiscrMsrResultStr;
	}
	/**
	 * @param sDiscrMsrResultStr the sDiscrMsrResultStr to set
	 */
	public void setsDiscrMsrResultStr(String sDiscrMsrResultStr) {
		this.sDiscrMsrResultStr = sDiscrMsrResultStr;
	}
	/**
	 * @return the discrete measrue critical low values
	 */
	public String getsCriticalLow() {
		return sCriticalLow;
	}
	/**
	 * @param sCriticalLow the sCriticalLow to set
	 */
	public void setsCriticalLow(String sCriticalLow) {
		this.sCriticalLow = sCriticalLow;
	}
	/**
	 * @return the discrete measrue normal low values
	 */
	public String getsNormalLow() {
		return sNormalLow;
	}
	/**
	 * @param sNnormalLow the sNnormalLow to set
	 */
	public void setsNormalLow(String sNnormalLow) {
		this.sNormalLow = sNnormalLow;
	}

	/**
	 * @return the discrete measrue normal high values
	 */
	public String getsNormalHigh() {
		return sNormalHigh;
	}
	/**
	 * @param sNormalHigh the sNormalHigh to set
	 */
	public void setsNormalHigh(String sNormalHigh) {
		this.sNormalHigh = sNormalHigh;
	}
	/**
	 * @return the discrete measrue Critical high values
	 */
	public String getsCriticalHigh() {
		return sCriticalHigh;
	}
	/**
	 * @param sCount the sCount to set
	 */
	public void setsCriticalHigh(String sCriticalHigh) {
		this.sCriticalHigh = sCriticalHigh;
	}

	/**
	 * @return the Added Date
	 */
	public String getsAddedDate() {
		return sAddedDate;
	}
	/**
	 * @param sCount the sCount to set
	 */
	public void setsAddedDate(String sAddedDate) {
		this.sAddedDate = sAddedDate;
	}

	/**
	 * @return the Chart Type
	 */
	public int getiChartType() {
		return iChartType;
	}
	/**
	 * @param sCount the sCount to set
	 */
	public void setiChartType(int iChartType) {
		this.iChartType = iChartType;
	}
}
