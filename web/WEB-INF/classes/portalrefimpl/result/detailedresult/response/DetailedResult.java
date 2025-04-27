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
package portalrefimpl.result.detailedresult.response;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is the model class for storing a test result
 * @author GRamamoorthy
 *
 */
public class DetailedResult {

	/**
	 * Data members in this class
	 */
	private String orderNumber = null;
	
	private String orderCatalogue = null;
	
	private String location = null;
	
	private String orderCategory = null;
	
	private Date orderDate = null;
	
	private String orderPractitioner = null;
	
	private ResultStatus resultStatus = null;

	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the orderCategory
	 */
	public String getOrderCategory() {
		return orderCategory;
	}

	/**
	 * @param orderCategory the orderCategory to set
	 */
	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
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
	 * @return the orderPractitioner
	 */
	public String getOrderPractitioner() {
		return orderPractitioner;
	}

	/**
	 * @param orderPractitioner the orderPractitioner to set
	 */
	public void setOrderPractitioner(String orderPractitioner) {
		this.orderPractitioner = orderPractitioner;
	}

	/**
	 * @return the resultStatus
	 */
	public ResultStatus getResultStatus() {
		return resultStatus;
	}

	/**
	 * @param resultStatus the resultStatus to set
	 */
	public void setResultStatus(ResultStatus resultStatus) {
		this.resultStatus = resultStatus;
	}

	/**
	 * @return the orderCatalogue
	 */
	public String getOrderCatalogue() {
		return orderCatalogue;
	}

	/**
	 * @param orderCatalogue the orderCatalogue to set
	 */
	public void setOrderCatalogue(String orderCatalogue) {
		this.orderCatalogue = orderCatalogue;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDisplayOrderDateValue(){
		String displayValue = "";
		final String format = "MMMM dd,yyyy";
		if(orderDate != null){
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			displayValue = dateFormat.format(orderDate);
		}
		return displayValue;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDisplayOrderTimeValue(){
		String displayValue = "";
		final String format = "HH:mm";
		if(orderDate != null){
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			displayValue = dateFormat.format(orderDate);
			int index = displayValue.indexOf(":");
			String hrStr = "";
			int hr = 0;
			String ampmStr = "am";
			if(index >= 0){
				hrStr = displayValue.substring(0, index);
				//System.out.println(hrStr);
				try {
					hr = Integer.parseInt(hrStr);
				} catch (NumberFormatException e) {
					hr = -1;
				}
				
				if(hr >= 12 && hr<=23){
					ampmStr = "pm";
				}
			}
			displayValue += ampmStr;
		}
		return displayValue;
	}
	
}
