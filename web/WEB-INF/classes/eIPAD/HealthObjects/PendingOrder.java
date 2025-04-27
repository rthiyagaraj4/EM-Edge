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
public class PendingOrder implements java.io.Serializable {

	  private String sOrderDesc;
	  private String sOrdercount;
	  private String sOCount;
	  private String sTestDateTime;
	  private String sItemShortDesc;
	  private String sOrdPractId;
	  private String sFormatExists;
	  
	  // added to get additional details for showing format text
	  private String orderId;
	  private String orderLineNum;
	  
	/**
	 * @return the sOrderDesc
	 */
	public String getsOrderDesc() {
		return sOrderDesc;
	}
	/**
	 * @param sOrderDesc the sOrderDesc to set
	 */
	public void setsOrderDesc(String sOrderDesc) {
		this.sOrderDesc = sOrderDesc;
	}
	/**
	 * @return the sOrdercount
	 */
	public String getsOrdercount() {
		return sOrdercount;
	}
	/**
	 * @param sOrdercount the sOrdercount to set
	 */
	public void setsOrdercount(String sOrdercount) {
		this.sOrdercount = sOrdercount;
	}
	/**
	 * @return the sOCount
	 */
	public String getsOCount() {
		return sOCount;
	}
	/**
	 * @param sOCount the sOCount to set
	 */
	public void setsOCount(String sOCount) {
		this.sOCount = sOCount;
	}
	/**
	 * @return the sTestDateTime
	 */
	public String getsTestDateTime() {
		return sTestDateTime;
	}
	/**
	 * @param sTestDateTime the sTestDateTime to set
	 */
	public void setsTestDateTime(String sTestDateTime) {
		this.sTestDateTime = sTestDateTime;
	}
	/**
	 * @return the sItemShortDesc
	 */
	public String getsItemShortDesc() {
		return sItemShortDesc;
	}
	/**
	 * @param sItemShortDesc the sItemShortDesc to set
	 */
	public void setsItemShortDesc(String sItemShortDesc) {
		this.sItemShortDesc = sItemShortDesc;
	}
	/**
	 * @return the sOrdPractId
	 */
	public String getsOrdPractId() {
		return sOrdPractId;
	}
	/**
	 * @param sOrdPractId the sOrdPractId to set
	 */
	public void setsOrdPractId(String sOrdPractId) {
		this.sOrdPractId = sOrdPractId;
	}
	/**
	 * @return the sFormatExists
	 */
	public String getsFormatExists() {
		return sFormatExists;
	}
	/**
	 * @param sFormatExists the sFormatExists to set
	 */
	public void setsFormatExists(String sFormatExists) {
		this.sFormatExists = sFormatExists;
	}
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderLineNum
	 */
	public String getOrderLineNum() {
		return orderLineNum;
	}
	/**
	 * @param orderLineNum the orderLineNum to set
	 */
	public void setOrderLineNum(String orderLineNum) {
		this.orderLineNum = orderLineNum;
	}
	
	  
}
