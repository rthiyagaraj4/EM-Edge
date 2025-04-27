/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.healthobject;

import java.util.List;



public class VitalsConfig implements java.io.Serializable{

	/**
	 * To hold the configuration values for view and record vitals 
	 */
	private static final long serialVersionUID = 1L;
	private String sectionId;
	private String sectionDesc;
	private String discreteMeasureId;
	private String discreteMeasureDesc;
	private String defaultValue;
	private String panelOrderSequence;
	private String discOrderSequence;
	private String units;
	private String resultType;
	private String defaultDisplayYN;
	private String summaryType;
	private String summaryColumn;
	private String sumYN = "";
	private String formulaDef;
	private String orderSeqNo;
	private String mandatoryYN;
	private String numDigitsMax;
	private String numDigitsMin;
	private String numDigitsDecimal;
	private String minValue;
	private String maxValue;
	private String summationFormula;
	private String tempSummationFormaula;
	private String normalLow = "";
	private String normalHigh = "";
	private String UOM = "";
	private String criticalLow = "";
	private String criticalHigh = "";
	private String numDfltResult = "";
	private String refRangeType;
	private String refRangeSeq;
	private String associateScoreYN;
	private String highStr = "";
	private String lowStr = "";
	private String criticalHighStr = "";
	private String criticalLowStr = "";
	private String normalIndicator = "";
	private List<ChartCombo> chartComboList;
	/**
	 * @return the sectionId
	 */
	public String getSectionId() {
		return sectionId;
	}
	/**
	 * @param sectionId the sectionId to set
	 */
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	/**
	 * @return the sectionDesc
	 */
	public String getSectionDesc() {
		return sectionDesc;
	}
	/**
	 * @param sectionDesc the sectionDesc to set
	 */
	public void setSectionDesc(String sectionDesc) {
		this.sectionDesc = sectionDesc;
	}
	/**
	 * @return the discreteMeasureId
	 */
	public String getDiscreteMeasureId() {
		return discreteMeasureId;
	}
	/**
	 * @param discreteMeasureId the discreteMeasureId to set
	 */
	public void setDiscreteMeasureId(String discreteMeasureId) {
		this.discreteMeasureId = discreteMeasureId;
	}
	/**
	 * @return the discreteMeasureDesc
	 */
	public String getDiscreteMeasureDesc() {
		return discreteMeasureDesc;
	}
	/**
	 * @param discreteMeasureDesc the discreteMeasureDesc to set
	 */
	public void setDiscreteMeasureDesc(String discreteMeasureDesc) {
		this.discreteMeasureDesc = discreteMeasureDesc;
	}
	/**
	 * @return the defaultValue
	 */
	public String getDefaultValue() {
		return defaultValue;
	}
	/**
	 * @param defaultValue the defaultValue to set
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	/**
	 * @return the panelOrderSequence
	 */
	public String getPanelOrderSequence() {
		return panelOrderSequence;
	}
	/**
	 * @param panelOrderSequence the panelOrderSequence to set
	 */
	public void setPanelOrderSequence(String panelOrderSequence) {
		this.panelOrderSequence = panelOrderSequence;
	}
	/**
	 * @return the discOrderSequence
	 */
	public String getDiscOrderSequence() {
		return discOrderSequence;
	}
	/**
	 * @param discOrderSequence the discOrderSequence to set
	 */
	public void setDiscOrderSequence(String discOrderSequence) {
		this.discOrderSequence = discOrderSequence;
	}
	/**
	 * @return the units
	 */
	public String getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(String units) {
		this.units = units;
	}
	/**
	 * @return the chartComboList
	 */
	public List<ChartCombo> getChartComboList() {
		return chartComboList;
	}
	/**
	 * @param chartComboList the chartComboList to set
	 */
	public void setChartComboList(List<ChartCombo> chartComboList) {
		this.chartComboList = chartComboList;
	}
	/**
	 * @return the resultType
	 */
	public String getResultType() {
		return resultType;
	}
	/**
	 * @param resultType the resultType to set
	 */
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	/**
	 * @return the defaultDisplayYN
	 */
	public String getDefaultDisplayYN() {
		return defaultDisplayYN;
	}
	/**
	 * @param defaultDisplayYN the defaultDisplayYN to set
	 */
	public void setDefaultDisplayYN(String defaultDisplayYN) {
		this.defaultDisplayYN = defaultDisplayYN;
	}
	/**
	 * @return the summaryType
	 */
	public String getSummaryType() {
		return summaryType;
	}
	/**
	 * @param summaryType the summaryType to set
	 */
	public void setSummaryType(String summaryType) {
		this.summaryType = summaryType;
	}
	/**
	 * @return the summaryColumn
	 */
	public String getSummaryColumn() {
		return summaryColumn;
	}
	/**
	 * @param summaryColumn the summaryColumn to set
	 */
	public void setSummaryColumn(String summaryColumn) {
		this.summaryColumn = summaryColumn;
	}
	/**
	 * @return the sumYN
	 */
	public String getSumYN() {
		return sumYN;
	}
	/**
	 * @param sumYN the sumYN to set
	 */
	public void setSumYN(String sumYN) {
		this.sumYN = sumYN;
	}
	/**
	 * @return the formulaDef
	 */
	public String getFormulaDef() {
		return formulaDef;
	}
	/**
	 * @param formulaDef the formulaDef to set
	 */
	public void setFormulaDef(String formulaDef) {
		this.formulaDef = formulaDef;
	}
	/**
	 * @return the orderSeqNo
	 */
	public String getOrderSeqNo() {
		return orderSeqNo;
	}
	/**
	 * @param orderSeqNo the orderSeqNo to set
	 */
	public void setOrderSeqNo(String orderSeqNo) {
		this.orderSeqNo = orderSeqNo;
	}
	/**
	 * @return the mandatoryYN
	 */
	public String getMandatoryYN() {
		return mandatoryYN;
	}
	/**
	 * @param mandatoryYN the mandatoryYN to set
	 */
	public void setMandatoryYN(String mandatoryYN) {
		this.mandatoryYN = mandatoryYN;
	}
	/**
	 * @return the numDigitsMax
	 */
	public String getNumDigitsMax() {
		return numDigitsMax;
	}
	/**
	 * @param numDigitsMax the numDigitsMax to set
	 */
	public void setNumDigitsMax(String numDigitsMax) {
		this.numDigitsMax = numDigitsMax;
	}
	/**
	 * @return the numDigitsMin
	 */
	public String getNumDigitsMin() {
		return numDigitsMin;
	}
	/**
	 * @param numDigitsMin the numDigitsMin to set
	 */
	public void setNumDigitsMin(String numDigitsMin) {
		this.numDigitsMin = numDigitsMin;
	}
	/**
	 * @return the numDigitsDecimal
	 */
	public String getNumDigitsDecimal() {
		return numDigitsDecimal;
	}
	/**
	 * @param numDigitsDecimal the numDigitsDecimal to set
	 */
	public void setNumDigitsDecimal(String numDigitsDecimal) {
		this.numDigitsDecimal = numDigitsDecimal;
	}
	/**
	 * @return the minValue
	 */
	public String getMinValue() {
		return minValue;
	}
	/**
	 * @param minValue the minValue to set
	 */
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	/**
	 * @return the maxValue
	 */
	public String getMaxValue() {
		return maxValue;
	}
	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	/**
	 * @return the summationFormula
	 */
	public String getSummationFormula() {
		return summationFormula;
	}
	/**
	 * @param summationFormula the summationFormula to set
	 */
	public void setSummationFormula(String summationFormula) {
		this.summationFormula = summationFormula;
	}
	/**
	 * @return the tempSummationFormaula
	 */
	public String getTempSummationFormaula() {
		return tempSummationFormaula;
	}
	/**
	 * @param tempSummationFormaula the tempSummationFormaula to set
	 */
	public void setTempSummationFormaula(String tempSummationFormaula) {
		this.tempSummationFormaula = tempSummationFormaula;
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
	 * @return the uOM
	 */
	public String getUOM() {
		return UOM;
	}
	/**
	 * @param uOM the uOM to set
	 */
	public void setUOM(String uOM) {
		UOM = uOM;
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
	 * @return the numDfltResult
	 */
	public String getNumDfltResult() {
		return numDfltResult;
	}
	/**
	 * @param numDfltResult the numDfltResult to set
	 */
	public void setNumDfltResult(String numDfltResult) {
		this.numDfltResult = numDfltResult;
	}
	/**
	 * @return the refRangeType
	 */
	public String getRefRangeType() {
		return refRangeType;
	}
	/**
	 * @param refRangeType the refRangeType to set
	 */
	public void setRefRangeType(String refRangeType) {
		this.refRangeType = refRangeType;
	}
	/**
	 * @return the refRangeSeq
	 */
	public String getRefRangeSeq() {
		return refRangeSeq;
	}
	/**
	 * @param refRangeSeq the refRangeSeq to set
	 */
	public void setRefRangeSeq(String refRangeSeq) {
		this.refRangeSeq = refRangeSeq;
	}
	/**
	 * @return the associateScoreYN
	 */
	public String getAssociateScoreYN() {
		return associateScoreYN;
	}
	/**
	 * @param associateScoreYN the associateScoreYN to set
	 */
	public void setAssociateScoreYN(String associateScoreYN) {
		this.associateScoreYN = associateScoreYN;
	}
	/**
	 * @return the highStr
	 */
	public String getHighStr() {
		return highStr;
	}
	/**
	 * @param highStr the highStr to set
	 */
	public void setHighStr(String highStr) {
		this.highStr = highStr;
	}
	/**
	 * @return the lowStr
	 */
	public String getLowStr() {
		return lowStr;
	}
	/**
	 * @param lowStr the lowStr to set
	 */
	public void setLowStr(String lowStr) {
		this.lowStr = lowStr;
	}
	/**
	 * @return the criticalHighStr
	 */
	public String getCriticalHighStr() {
		return criticalHighStr;
	}
	/**
	 * @param criticalHighStr the criticalHighStr to set
	 */
	public void setCriticalHighStr(String criticalHighStr) {
		this.criticalHighStr = criticalHighStr;
	}
	/**
	 * @return the criticalLowStr
	 */
	public String getCriticalLowStr() {
		return criticalLowStr;
	}
	/**
	 * @param criticalLowStr the criticalLowStr to set
	 */
	public void setCriticalLowStr(String criticalLowStr) {
		this.criticalLowStr = criticalLowStr;
	}
	/**
	 * @return the normalIndicator
	 */
	public String getNormalIndicator() {
		return normalIndicator;
	}
	/**
	 * @param normalIndicator the normalIndicator to set
	 */
	public void setNormalIndicator(String normalIndicator) {
		this.normalIndicator = normalIndicator;
	}
}
