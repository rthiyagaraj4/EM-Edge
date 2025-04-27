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
package portalrefimpl.result.viewtestresult.response;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author GRamamoorthy
 *
 */
public class TestDetails {

	private String orderNo;
	
	private String location;
	
	private String resultType;
	
	private String order;
	
	private Date orderDate;
	
	private String practId;
	
	private String practName;
	
	private String status;

	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the practId
	 */
	public String getPractId() {
		return practId;
	}

	/**
	 * @param practId the practId to set
	 */
	public void setPractId(String practId) {
		this.practId = practId;
	}

	/**
	 * @return the practName
	 */
	public String getPractName() {
		return practName;
	}

	/**
	 * @param practName the practName to set
	 */
	public void setPractName(String practName) {
		this.practName = practName;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getOrderDateString(){
		String orderDateStr = "";
		final String formatStr = "MMMM dd,yyyy";
		final String timeFormatStr = "HH:mm";
		if(orderDate != null){
			SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
			orderDateStr = dateFormat.format(orderDate);
			
			orderDateStr += " at ";
			dateFormat = new SimpleDateFormat(timeFormatStr);
			orderDateStr += dateFormat.format(orderDate);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(orderDate);
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			String ampmStr = "am";
			if(hour >= 12 && hour <= 23){
				ampmStr = "pm";
			}
			
			orderDateStr += ampmStr;
		}
		
		
		
		
		return orderDateStr;
	}
	
}
