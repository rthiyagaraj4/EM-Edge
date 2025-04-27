/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.HealthObjects;
import java.io.*;
public class PatientCFS implements java.io.Serializable {
	
	private String sDesc;
	private String sCareFlowDetail;
	private String sDescCellIndicator;
	private String sResultNum;
	private String sColorCellIndicator;
	private String sNormalRangeSymbol;
	private String sNormalLow;
	private String sNormalHigh;
	private String sCount;
	private String sEventDate;
	private String sEventClass;
	private String sEventGroupDesc;
	private String sContrSysID;
	private String sHistRecType;
	private String sAccessionNum;
	private String sContrSysEventCode;
	private String sTextExist;
	
	public String getsContrSysID() {
		return sContrSysID;
	}
	public void setsContrSysID(String sContrSysID) {
		this.sContrSysID = sContrSysID;
	}
	public String getsHistRecType() {
		return sHistRecType;
	}
	public void setsHistRecType(String sHistRecType) {
		this.sHistRecType = sHistRecType;
	}
	public String getsAccessionNum() {
		return sAccessionNum;
	}
	public void setsAccessionNum(String sAccessionNum) {
		this.sAccessionNum = sAccessionNum;
	}
	public String getsContrSysEventCode() {
		return sContrSysEventCode;
	}
	public void setsContrSysEventCode(String sContrSysEventCode) {
		this.sContrSysEventCode = sContrSysEventCode;
	}
	public String getsTextExist() {
		return sTextExist;
	}
	public void setsTextExist(String sTextExist) {
		this.sTextExist = sTextExist;
	}

	
	
	
	

	/**
	 * @return the sDesc
	 */
	public String getsDesc() {
		return sDesc;
	}
	/**
	 * @return the sEventDate
	 */
	public String getsEventDate() {
		return sEventDate;
	}
	/**
	 * @param sEventDate the sEventDate to set
	 */
	public void setsEventDate(String sEventDate) {
		this.sEventDate = sEventDate;
	}
	/**
	 * @return the sEventClass
	 */
	public String getsEventClass() {
		return sEventClass;
	}
	/**
	 * @param sEventClass the sEventClass to set
	 */
	public void setsEventClass(String sEventClass) {
		this.sEventClass = sEventClass;
	}
	/**
	 * @return the sEventGroupDesc
	 */
	public String getsEventGroupDesc() {
		return sEventGroupDesc;
	}
	/**
	 * @param sEventGroupDesc the sEventGroupDesc to set
	 */
	public void setsEventGroupDesc(String sEventGroupDesc) {
		this.sEventGroupDesc = sEventGroupDesc;
	}
	/**
	 * @param sDesc the sDesc to set
	 */
	public void setsDesc(String sDesc) {
		this.sDesc = sDesc;
	}
	/**
	 * @return the sCareFlowDetail
	 */
	public String getsCareFlowDetail() {
		return sCareFlowDetail;
	}
	/**
	 * @param sCareFlowDetail the sCareFlowDetail to set
	 */
	public void setsCareFlowDetail(String sCareFlowDetail) {
		this.sCareFlowDetail = sCareFlowDetail;
	}
	/**
	 * @return the sDescCellIndicator
	 */
	public String getsDescCellIndicator() {
		return sDescCellIndicator;
	}
	/**
	 * @param sDescCellIndicator the sDescCellIndicator to set
	 */
	public void setsDescCellIndicator(String sDescCellIndicator) {
		this.sDescCellIndicator = sDescCellIndicator;
	}
	/**
	 * @return the sResultNum
	 */
	public String getsResultNum() {
		return sResultNum;
	}
	/**
	 * @param sResultNum the sResultNum to set
	 */
	public void setsResultNum(String sResultNum) {
		this.sResultNum = sResultNum;
	}
	/**
	 * @return the sColorCellIndicator
	 */
	public String getsColorCellIndicator() {
		return sColorCellIndicator;
	}
	/**
	 * @param sColorCellIndicator the sColorCellIndicator to set
	 */
	public void setsColorCellIndicator(String sColorCellIndicator) {
		this.sColorCellIndicator = sColorCellIndicator;
	}
	/**
	 * @return the sNormalRangeSymbol
	 */
	public String getsNormalRangeSymbol() {
		return sNormalRangeSymbol;
	}
	/**
	 * @param sNormalRangeSymbol the sNormalRangeSymbol to set
	 */
	public void setsNormalRangeSymbol(String sNormalRangeSymbol) {
		this.sNormalRangeSymbol = sNormalRangeSymbol;
	}
	/**
	 * @return the sNormalLow
	 */
	public String getsNormalLow() {
		return sNormalLow;
	}
	/**
	 * @param sNormalLow the sNormalLow to set
	 */
	public void setsNormalLow(String sNormalLow) {
		this.sNormalLow = sNormalLow;
	}
	/**
	 * @return the sNormalHigh
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
	 * @return the sCount
	 */
	public String getsCount() {
		return sCount;
	}
	/**
	 * @param sCount the sCount to set
	 */
	public void setsCount(String sCount) {
		this.sCount = sCount;
	}

}
