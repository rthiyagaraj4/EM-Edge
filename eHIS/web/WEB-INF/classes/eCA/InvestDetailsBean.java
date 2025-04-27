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
public class InvestDetailsBean implements java.io.Serializable
{

	private String sPatienID; 
	private String sEncounterID; 
	private String sFacilityID;
	private String sSpecimenNo; 
	private String sGroupTestCode; 
	private String sTestCode;
	private String sLongDesc;
	private String sSectionCode;
	private String sNumericResult;
	private String sShortDesc;
	private String sHighLowInd;
	private String sLowValueCritical;
	private String sAgeRangeLow;
	private String sAgeRangeHigh;
	private String sHighValueCritical;
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
	 * @return the Specimen Number
	 */
	public String getsSpecimenNo() {
		return sSpecimenNo;
	}
	/**
	 * @param sSpecimenNo the sSpecimenNo to set
	 */
	public void setsSpecimenNo(String sSpecimenNo) {
		this.sSpecimenNo = sSpecimenNo;
	}
	/**
	 * @return the Group Test Code
	 */
	public String getsGroupTestCode() {
		return sGroupTestCode;
	}
	/**
	 * @param sGroupTestCode the sGroupTestCode to set
	 */
	public void setsGroupTestCode(String sGroupTestCode) {
		this.sGroupTestCode = sGroupTestCode;
	}
	/**
	 * @return the Test Code
	 */
	public String getsTestCode() {
		return sTestCode;
	}
	/**
	 * @param sTestCode the sTestCode to set
	 */
	public void setsTestCode(String sTestCode) {
		this.sTestCode = sTestCode;
	}
	/**
	 * @return the Test Code Long Description
	 */
	public String getsLongDesc() {
		return sLongDesc;
	}
	/**
	 * @param sLongDesc the sLongDesc to set
	 */
	public void setsLongDesc(String sLongDesc) {
		this.sLongDesc = sLongDesc;
	}
	/**
	 * @return the Test Section Code
	 */
	public String getsSectionCode() {
		return sSectionCode;
	}
	/**
	 * @param lDiscrMsrResultNum the lDiscrMsrResultNum to set
	 */
	public void setsSectionCode(String sSectionCode) {
		this.sSectionCode = sSectionCode;
	}
	/**
	 * @return the Numeric result
	 */
	public String getsNumericResult() {
		return sNumericResult;
	}
	/**
	 * @param sNumericResult the sNumericResult to set
	 */
	public void setsNumericResult(String sNumericResult) {
		this.sNumericResult = sNumericResult;
	}
	/**
	 * @return the Test UOM
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
	 * @return the High Low Indicator
	 */
	public String getsHighLowInd() {
		return sHighLowInd;
	}
	/**
	 * @param sHighLowInd the sHighLowInd to set
	 */
	public void setsHighLowInd(String sHighLowInd) {
		this.sHighLowInd = sHighLowInd;
	}
	/**
	 * @return the Critical low values
	 */
	public String getsLowValueCritical() {
		return sLowValueCritical;
	}
	/**
	 * @param sNnormalLow the sNnormalLow to set
	 */
	public void setsLowValueCritical(String sLowValueCritical) {
		this.sLowValueCritical = sLowValueCritical;
	}

	/**
	 * @return the Normal Low value
	 */
	public String getsAgeRangeLow() {
		return sAgeRangeLow;
	}
	/**
	 * @param sAgeRangeLow the sAgeRangeLow to set
	 */
	public void setsAgeRangeLow(String sAgeRangeLow) {
		this.sAgeRangeLow = sAgeRangeLow;
	}
	/**
	 * @return the Normal High Value
	 */
	public String getsAgeRangeHigh() {
		return sAgeRangeHigh;
	}
	/**
	 * @param sAgeRangeHigh the sAgeRangeHigh to set
	 */
	public void setsAgeRangeHigh(String sAgeRangeHigh) {
		this.sAgeRangeHigh = sAgeRangeHigh;
	}
	/**
	 * @return the Critical high values
	 */
	public String getsHighValueCritical() {
		return sHighValueCritical;
	}
	/**
	 * @param sHighValueCritical the sHighValueCritical to set
	 */
	public void setsHighValueCritical(String sHighValueCritical) {
		this.sHighValueCritical = sHighValueCritical;
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
