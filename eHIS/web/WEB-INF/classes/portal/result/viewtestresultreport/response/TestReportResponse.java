/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultreport.response;

import java.util.Iterator;
import java.util.List;

import portal.common.response.BaseResponse;
/**
 * This class is used as the response object by test report service
 * @author vkodancha
 *
 */
public class TestReportResponse extends BaseResponse {
	private TestReport testReport;
	private List<Report> reportList;
	/**
	 * @return the reportList
	 */
	public List<Report> getReportList() {
		return reportList;
	}
	
	/**
	 * @return the reportList
	 */
	public void setReportList(List<Report> reportList) {
		this.reportList =reportList;
	}

	/**
	 * @param reportList the reportList to set
	 */
	public void addToReportList(Report report) {
		this.reportList.add(report);
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return this.testReport.getOrder();
	}

	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return this.testReport.getOrderNo();
	}

	/**
	 * @return the orderDateandTime
	 */
	public String getOrderDateandTime() {
		return this.testReport.getOrderDateandTime();
	}

	/**
	 * @return the resultType
	 */
	public String getResultType() {
		return this.testReport.getResultType();
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(String order) {
		if(this.testReport == null){
			this.testReport = new TestReport();
		}
		this.testReport.setOrder(order);
	}

	/**
	 * @param orderNo
	 *            the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		if(this.testReport == null){
			this.testReport = new TestReport();
		}
		this.testReport.setOrderNo(orderNo);
	}

	/**
	 * @param orderDateandTime
	 *            the orderDateandTime to set
	 */
	public void setOrderDateandTime(String orderDateandTime) {
		if(this.testReport == null){
			this.testReport = new TestReport();
		}
		this.testReport.setOrderDateandTime(orderDateandTime);
	}

	/**
	 * @param resultType
	 *            the resultType to set
	 */
	public void setResultType(String resultType) {
		if(this.testReport == null){
			this.testReport = new TestReport();
		}
		this.testReport.setResultType(resultType);
	}
	/**
	 * Method over ridden for logging purpose
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.testReport!=null ? this.testReport.toString():" ");
		if(null!=this.reportList && !this.reportList.isEmpty()){
			Iterator<Report> it = this.reportList.iterator();
			while (it.hasNext()) {
				Report report = (Report) it.next();
				sb.append(report.toString());
			}
		}
		return sb.toString();
	}
}
