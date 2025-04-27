/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultreport.response;

/**
 * This class is used in Test report response as an element of reports
 * 
 * @author vkodancha
 * 
 */
public class Report {

	private String resultNumber;
	private String resultNumberUom;
	private String resultStr;
	private String resultData;
	private String reportingDate;
	private String normalLow;
	private String normalHigh;
	private String criticalLow;
	private String criticalHigh;
	private String normalAbnormalInd;
	private String reportCaption;
	private String practitionerId;
	private String reportingPractitionerId;
	private String ResultType;
	private String orderType;
	private String accesssionNumber;
	private String numDataYnInd;
	private String Status;
	private String normalacyStr;

	/**
	 * @return the resultNumber
	 */
	public String getResultNumber() {
		return resultNumber;
	}

	/**
	 * @return the resultNumberUom
	 */
	public String getResultNumberUom() {
		return resultNumberUom;
	}

	/**
	 * @return the resultStr
	 */
	public String getResultStr() {
		return resultStr;
	}

	/**
	 * @return the resultData
	 */
	public String getResultData() {
		return resultData;
	}

	/**
	 * @return the reportingDate
	 */
	public String getReportingDate() {
		return reportingDate;
	}

	/**
	 * @return the normalLow
	 */
	public String getNormalLow() {
		return normalLow;
	}

	/**
	 * @return the normalHigh
	 */
	public String getNormalHigh() {
		return normalHigh;
	}

	/**
	 * @return the criticalLow
	 */
	public String getCriticalLow() {
		return criticalLow;
	}

	/**
	 * @return the criticalHigh
	 */
	public String getCriticalHigh() {
		return criticalHigh;
	}

	/**
	 * @return the normalAbnormalInd
	 */
	public String getNormalAbnormalInd() {
		return normalAbnormalInd;
	}

	/**
	 * @return the childDesc
	 */
	public String getReportCaption() {
		return reportCaption;
	}

	/**
	 * @return the practitionerId
	 */
	public String getPractitionerId() {
		return practitionerId;
	}

	/**
	 * @return the reportingPractitionerId
	 */
	public String getReportingPractitionerId() {
		return reportingPractitionerId;
	}

	/**
	 * @return the resultType
	 */
	public String getResultType() {
		return ResultType;
	}

	/**
	 * @return the accesssionNumber
	 */
	public String getAccesssionNumber() {
		return accesssionNumber;
	}

	/**
	 * @return the numDataYnInd
	 */
	public String getNumDataYnInd() {
		return numDataYnInd;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * @return the normalacyStr
	 */
	public String getNormalacyStr() {
		return normalacyStr;
	}

	/**
	 * @param resultNumber
	 *            the resultNumber to set
	 */
	public void setResultNumber(String resultNumber) {
		this.resultNumber = resultNumber;
	}

	/**
	 * @param resultNumberUom
	 *            the resultNumberUom to set
	 */
	public void setResultNumberUom(String resultNumberUom) {
		this.resultNumberUom = resultNumberUom;
	}

	/**
	 * @param resultStr
	 *            the resultStr to set
	 */
	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}

	/**
	 * @param resultData
	 *            the resultData to set
	 */
	public void setResultData(String resultData) {
		this.resultData = resultData;
	}

	/**
	 * @param reportingDate
	 *            the reportingDate to set
	 */
	public void setReportingDate(String reportingDate) {
		this.reportingDate = reportingDate;
	}

	/**
	 * @param normalLow
	 *            the normalLow to set
	 */
	public void setNormalLow(String normalLow) {
		this.normalLow = normalLow;
	}

	/**
	 * @param normalHigh
	 *            the normalHigh to set
	 */
	public void setNormalHigh(String normalHigh) {
		this.normalHigh = normalHigh;
	}

	/**
	 * @param criticalLow
	 *            the criticalLow to set
	 */
	public void setCriticalLow(String criticalLow) {
		this.criticalLow = criticalLow;
	}

	/**
	 * @param criticalHigh
	 *            the criticalHigh to set
	 */
	public void setCriticalHigh(String criticalHigh) {
		this.criticalHigh = criticalHigh;
	}

	/**
	 * @param normalAbnormalInd
	 *            the normalAbnormalInd to set
	 */
	public void setNormalAbnormalInd(String normalAbnormalInd) {
		this.normalAbnormalInd = normalAbnormalInd;
	}

	/**
	 * @param childDesc
	 *            the childDesc to set
	 */
	public void setReportCaption(String childDesc) {
		this.reportCaption = childDesc;
	}


	/**
	 * @param practitionerId
	 *            the practitionerId to set
	 */
	public void setPractitionerId(String practitionerId) {
		this.practitionerId = practitionerId;
	}

	/**
	 * @param reportingPractitionerId
	 *            the reportingPractitionerId to set
	 */
	public void setReportingPractitionerId(String reportingPractitionerId) {
		this.reportingPractitionerId = reportingPractitionerId;
	}

	/**
	 * @param resultType
	 *            the resultType to set
	 */
	public void setResultType(String resultType) {
		ResultType = resultType;
	}

	/**
	 * @param accesssionNumber
	 *            the accesssionNumber to set
	 */
	public void setAccesssionNumber(String accesssionNumber) {
		this.accesssionNumber = accesssionNumber;
	}

	/**
	 * @param numDataYnInd
	 *            the numDataYnInd to set
	 */
	public void setNumDataYnInd(String numDataYnInd) {
		this.numDataYnInd = numDataYnInd;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * @param normalacyStr
	 *            the normalacyStr to set
	 */
	public void setNormalacyStr(String normalacyStr) {
		this.normalacyStr = normalacyStr;
	}

	/**
	 * To String method is over ridden for logging purpose
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("resultNumber :" + resultNumber);
		sb.append("resultNumberUom :" + resultNumberUom);
		sb.append("resultStr :" + resultStr);
		sb.append("resultData :" + resultData);
		sb.append("reportingDate :" + reportingDate);
		sb.append("normalLow :" + normalLow);
		sb.append("normalHigh :" + normalHigh);
		sb.append("criticalLow :" + criticalLow);
		sb.append("criticalHigh :" + criticalHigh);
		sb.append("normalAbnormalInd :" + normalAbnormalInd);
		sb.append("childDesc :" + reportCaption);
		sb.append("practitionerId :" + practitionerId);
		sb.append("reportingPractitionerId :" + reportingPractitionerId);
		sb.append("ResultType :" + ResultType);
		sb.append("accesssionNumber :" + accesssionNumber);
		sb.append("numDataYnInd :" + numDataYnInd);
		sb.append("Status :" + Status);
		sb.append("normalacyStr :" + normalacyStr);
		sb.append("orderType :" + orderType);
		return sb.toString();
	}
	/**
	 * @param orderType
	 *            the orderType to get
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * @param orderType
	 *            the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
}
