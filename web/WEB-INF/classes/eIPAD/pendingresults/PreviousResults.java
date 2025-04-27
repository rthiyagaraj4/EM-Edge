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
package eIPAD.pendingresults;

import java.io.Serializable;

/**
 * @author GRamamoorthy
 *
 */
public class PreviousResults implements Serializable {

	private String eventDummyDate = null;
	
	private String histRecType = null;
	
	private String histRecTypeDesc = null;
	
	private String eventClass = null;
	
	private String eventClassDesc = null;
	
	private String eventGroup = null;
	
	private String eventGroupDesc = null;
	
	private String eventCode = null;
	
	private String eventDesc = null;
	
	private String resultNumUOM = null;
	
	private String histDataType = null;
	
	private String resultNum = null; 
	
	private String accessionNum = null;
	private String sysID = null;
	private String sysEventCode = null;
	private String resultStr = null;
	private String normIndicator = null;
	private String normalLow = null;
	
	private String normalHigh = null;
	private String criticalLow = null;
	private String criticalHigh = null;
	private String extImgID = null;
	private String extApplID = null;
	private String toolTip = null;
	private String performed_by = null;
	private String enctr_id = null;
	private String normalcy_str = null;
	
	
	/**
	 * Default constructor of the class
	 */
	public PreviousResults() {
	}

	/**
	 * @return the eventDummyDate
	 */
	public String getEventDummyDate() {
		return eventDummyDate;
	}

	/**
	 * @param eventDummyDate the eventDummyDate to set
	 */
	public void setEventDummyDate(String eventDummyDate) {
		this.eventDummyDate = eventDummyDate;
	}

	/**
	 * @return the histRecType
	 */
	public String getHistRecType() {
		return histRecType;
	}

	/**
	 * @param histRecType the histRecType to set
	 */
	public void setHistRecType(String histRecType) {
		this.histRecType = histRecType;
	}

	/**
	 * @return the histRecTypeDesc
	 */
	public String getHistRecTypeDesc() {
		return histRecTypeDesc;
	}

	/**
	 * @param histRecTypeDesc the histRecTypeDesc to set
	 */
	public void setHistRecTypeDesc(String histRecTypeDesc) {
		this.histRecTypeDesc = histRecTypeDesc;
	}

	/**
	 * @return the eventClass
	 */
	public String getEventClass() {
		return eventClass;
	}

	/**
	 * @param eventClass the eventClass to set
	 */
	public void setEventClass(String eventClass) {
		this.eventClass = eventClass;
	}

	/**
	 * @return the eventClassDesc
	 */
	public String getEventClassDesc() {
		return eventClassDesc;
	}

	/**
	 * @param eventClassDesc the eventClassDesc to set
	 */
	public void setEventClassDesc(String eventClassDesc) {
		this.eventClassDesc = eventClassDesc;
	}

	/**
	 * @return the eventGroup
	 */
	public String getEventGroup() {
		return eventGroup;
	}

	/**
	 * @param eventGroup the eventGroup to set
	 */
	public void setEventGroup(String eventGroup) {
		this.eventGroup = eventGroup;
	}

	/**
	 * @return the eventGroupDesc
	 */
	public String getEventGroupDesc() {
		return eventGroupDesc;
	}

	/**
	 * @param eventGroupDesc the eventGroupDesc to set
	 */
	public void setEventGroupDesc(String eventGroupDesc) {
		this.eventGroupDesc = eventGroupDesc;
	}

	/**
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}

	/**
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * @return the eventDesc
	 */
	public String getEventDesc() {
		return eventDesc;
	}

	/**
	 * @param eventDesc the eventDesc to set
	 */
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	/**
	 * @return the resultNumUOM
	 */
	public String getResultNumUOM() {
		return resultNumUOM;
	}

	/**
	 * @param resultNumUOM the resultNumUOM to set
	 */
	public void setResultNumUOM(String resultNumUOM) {
		this.resultNumUOM = resultNumUOM;
	}

	/**
	 * @return the histDataType
	 */
	public String getHistDataType() {
		return histDataType;
	}

	/**
	 * @param histDataType the histDataType to set
	 */
	public void setHistDataType(String histDataType) {
		this.histDataType = histDataType;
	}

	/**
	 * @return the resultNum
	 */
	public String getResultNum() {
		return resultNum;
	}

	/**
	 * @param resultNum the resultNum to set
	 */
	public void setResultNum(String resultNum) {
		this.resultNum = resultNum;
	}

	/**
	 * @return the accessionNum
	 */
	public String getAccessionNum() {
		return accessionNum;
	}

	/**
	 * @param accessionNum the accessionNum to set
	 */
	public void setAccessionNum(String accessionNum) {
		this.accessionNum = accessionNum;
	}

	/**
	 * @return the sysID
	 */
	public String getSysID() {
		return sysID;
	}

	/**
	 * @param sysID the sysID to set
	 */
	public void setSysID(String sysID) {
		this.sysID = sysID;
	}

	/**
	 * @return the sysEventCode
	 */
	public String getSysEventCode() {
		return sysEventCode;
	}

	/**
	 * @param sysEventCode the sysEventCode to set
	 */
	public void setSysEventCode(String sysEventCode) {
		this.sysEventCode = sysEventCode;
	}

	/**
	 * @return the resultStr
	 */
	public String getResultStr() {
		return resultStr;
	}

	/**
	 * @param resultStr the resultStr to set
	 */
	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}

	/**
	 * @return the normIndicator
	 */
	public String getNormIndicator() {
		return normIndicator;
	}

	/**
	 * @param normIndicator the normIndicator to set
	 */
	public void setNormIndicator(String normIndicator) {
		this.normIndicator = normIndicator;
	}

	/**
	 * @return the normalLow
	 */
	public String getNormalLow() {
		return normalLow;
	}

	/**
	 * @param normalLow the normalLow to set
	 */
	public void setNormalLow(String normalLow) {
		this.normalLow = normalLow;
	}

	/**
	 * @return the normalHigh
	 */
	public String getNormalHigh() {
		return normalHigh;
	}

	/**
	 * @param normalHigh the normalHigh to set
	 */
	public void setNormalHigh(String normalHigh) {
		this.normalHigh = normalHigh;
	}

	/**
	 * @return the criticalLow
	 */
	public String getCriticalLow() {
		return criticalLow;
	}

	/**
	 * @param criticalLow the criticalLow to set
	 */
	public void setCriticalLow(String criticalLow) {
		this.criticalLow = criticalLow;
	}

	/**
	 * @return the criticalHigh
	 */
	public String getCriticalHigh() {
		return criticalHigh;
	}

	/**
	 * @param criticalHigh the criticalHigh to set
	 */
	public void setCriticalHigh(String criticalHigh) {
		this.criticalHigh = criticalHigh;
	}

	/**
	 * @return the extImgID
	 */
	public String getExtImgID() {
		return extImgID;
	}

	/**
	 * @param extImgID the extImgID to set
	 */
	public void setExtImgID(String extImgID) {
		this.extImgID = extImgID;
	}

	/**
	 * @return the extApplID
	 */
	public String getExtApplID() {
		return extApplID;
	}

	/**
	 * @param extApplID the extApplID to set
	 */
	public void setExtApplID(String extApplID) {
		this.extApplID = extApplID;
	}

	/**
	 * @return the toolTip
	 */
	public String getToolTip() {
		return toolTip;
	}

	/**
	 * @param toolTip the toolTip to set
	 */
	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}

	/**
	 * @return the performed_by
	 */
	public String getPerformed_by() {
		return performed_by;
	}

	/**
	 * @param performed_by the performed_by to set
	 */
	public void setPerformed_by(String performed_by) {
		this.performed_by = performed_by;
	}

	/**
	 * @return the enctr_id
	 */
	public String getEnctr_id() {
		return enctr_id;
	}

	/**
	 * @param enctr_id the enctr_id to set
	 */
	public void setEnctr_id(String enctr_id) {
		this.enctr_id = enctr_id;
	}

	/**
	 * @return the normalcy_str
	 */
	public String getNormalcy_str() {
		return normalcy_str;
	}

	/**
	 * @param normalcy_str the normalcy_str to set
	 */
	public void setNormalcy_str(String normalcy_str) {
		this.normalcy_str = normalcy_str;
	}

}
