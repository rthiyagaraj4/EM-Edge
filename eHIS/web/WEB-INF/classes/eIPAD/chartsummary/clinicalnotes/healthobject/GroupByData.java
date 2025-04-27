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
package eIPAD.chartsummary.clinicalnotes.healthobject;

/**
 * @author GaneshkumarC 
 *
 */
public class GroupByData {
	private String groupByValue;
	private String groupByDesc;
	private String serviceCode;
	private String performedBy;
	private String status;
	private String primarySpec;
	private String eventClass;
	private String actionType;
	
	/**
	 * @return the servCode
	 */
	public String getServiceCode() {
		return serviceCode;
	}
	/**
	 * @param servCode the servCode to set
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	/**
	 * @return the groupByValue
	 */
	public String getGroupByValue() {
		return groupByValue;
	}
	/**
	 * @param groupByValue the groupByValue to set
	 */
	public void setGroupByValue(String groupByValue) {
		this.groupByValue = groupByValue;
	}
	/**
	 * @return the groupByDesc
	 */
	public String getGroupByDesc() {
		return groupByDesc;
	}
	/**
	 * @param groupByDesc the groupByDesc to set
	 */
	public void setGroupByDesc(String groupByDesc) {
		this.groupByDesc = groupByDesc;
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
	 * @return the performedBy
	 */
	public String getPerformedBy() {
		return performedBy;
	}
	/**
	 * @param performedBy the performedBy to set
	 */
	public void setPerformedBy(String performedBy) {
		this.performedBy = performedBy;
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
	 * @return the primarySpec
	 */
	public String getPrimarySpec() {
		return primarySpec;
	}
	/**
	 * @param primarySpec the primarySpec to set
	 */
	public void setPrimarySpec(String primarySpec) {
		this.primarySpec = primarySpec;
	}
	/**
	 * @return the actionType
	 */
	public String getActionType() {
		return actionType;
	}
	/**
	 * @param actionType the actionType to set
	 */
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	

}
