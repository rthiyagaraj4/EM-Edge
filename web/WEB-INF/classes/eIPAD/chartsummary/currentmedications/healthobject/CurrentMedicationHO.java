/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.currentmedications.healthobject;

import java.util.ArrayList;

public class CurrentMedicationHO implements java.io.Serializable {
	private String orderType; // not used 
	private String orderId; 
	private String priorityIndicator; // not used 
	private String drugName; // drug_desc in sql 
	private String dosageDetails; //dosage_uom_code (to print the quantity in UI)
	private String duration; 
	private String duration_desc;
	private String frequency;
	private String startDate;
	private String endDate;
	private String formDesc; 
	private String prepYN; 
	private String route;
	private String routeDesc;
	private String orderDesc;
	private String lineStatus;
	private String status;
	private String returnedQty; 
	private String patientClass;
	private String dischargeMed;
	private String splitFluidMedicationYN;
	private String infusionTime;
	private String infusionOverUnit;
	private String infusionRate;
	private String infusionVolStrUnit;
	private String infusionPerUnit;
	private String orderQty; // only used in IV Rx not taken for any other record 
	private ArrayList<CurMedMultipleFlowRateHO> mulitpleFlowRate;
	
	//private int count;
	
	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * @param orderType the orderType to set 
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
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
	 * @return the priorityIndicator
	 */
	public String getPriorityIndicator() {
		return priorityIndicator;
	}
	/**
	 * @param priorityIndicator the priorityIndicator to set
	 */
	public void setPriorityIndicator(String priorityIndicator) {
		this.priorityIndicator = priorityIndicator;
	}
	/**
	 * @return the drugName
	 */
	public String getDrugName() {
		return drugName;
	}
	/**
	 * @param drugName the drugName to set
	 */
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	/**
	 * @return the dosageDetails
	 */
	public String getDosageDetails() {
		return dosageDetails;
	}
	/**
	 * @param dosageDetails the dosageDetails to set
	 */
	public void setDosageDetails(String dosageDetails) {
		this.dosageDetails = dosageDetails;
	}
	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	/**
	 * @return the frequency
	 */
	public String getFrequency() {
		return frequency;
	}
	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the formDesc
	 */
	public String getFormDesc() {
		return formDesc;
	}
	/**
	 * @param formDesc the formDesc to set
	 */
	public void setFormDesc(String formDesc) {
		this.formDesc = formDesc;
	}
	/**
	 * @return the prepYN
	 */
	public String getPrepYN() {
		return prepYN;
	}
	/**
	 * @param prepYN the prepYN to set
	 */
	public void setPrepYN(String prepYN) {
		this.prepYN = prepYN;
	}
	/**
	 * @return the duration_desc
	 */
	public String getDuration_desc() {
		return duration_desc;
	}
	/**
	 * @param duration_desc the duration_desc to set
	 */
	public void setDuration_desc(String duration_desc) {
		this.duration_desc = duration_desc;
	}
	/**
	 * @return the route
	 */
	public String getRoute() {
		return route;
	}
	/**
	 * @param route the route to set
	 */
	public void setRoute(String route) {
		this.route = route;
	}
	/**
	 * @return the count
	 *//*
	public int getCount() {
		return count;
	}
	*//**
	 * @param count the count to set
	 *//*
	public void setCount(int count) {
		this.count = count;
	}*/
	/**
	 * @return the orderDesc
	 */
	public String getOrderDesc() {
		return orderDesc;
	}
	/**
	 * @param orderDesc the orderDesc to set
	 */
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	/**
	 * @return the routeDesc
	 */
	public String getRouteDesc() {
		return routeDesc;
	}
	/**
	 * @param routeDesc the routeDesc to set
	 */
	public void setRouteDesc(String routeDesc) {
		this.routeDesc = routeDesc;
	}
	/**
	 * @return the lineStatus
	 */
	public String getLineStatus() {
		return lineStatus;
	}
	/**
	 * @param lineStatus the lineStatus to set
	 */
	public void setLineStatus(String lineStatus) {
		this.lineStatus = lineStatus;
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
	 * @return the returnedQty
	 */
	public String getReturnedQty() {
		return returnedQty;
	}
	/**
	 * @param returnedQty the returnedQty to set
	 */
	public void setReturnedQty(String returnedQty) {
		this.returnedQty = returnedQty;
	}
	/**
	 * @return the patientClass
	 */
	public String getPatientClass() {
		return patientClass;
	}
	/**
	 * @param patientClass the patientClass to set
	 */
	public void setPatientClass(String patientClass) {
		this.patientClass = patientClass;
	}
	/**
	 * @return the dischargeMed
	 */
	public String getDischargeMed() {
		return dischargeMed;
	}
	/**
	 * @param dischargeMed the dischargeMed to set
	 */
	public void setDischargeMed(String dischargeMed) {
		this.dischargeMed = dischargeMed;
	}
	/**
	 * @return the infusionTime
	 */
	public String getInfusionTime() {
		return infusionTime;
	}
	/**
	 * @param infusionTime the infusionTime to set
	 */
	public void setInfusionTime(String infusionTime) {
		this.infusionTime = infusionTime;
	}
	/**
	 * @return the infusionOverUnit
	 */
	public String getInfusionOverUnit() {
		return infusionOverUnit;
	}
	/**
	 * @param infusionOverUnit the infusionOverUnit to set
	 */
	public void setInfusionOverUnit(String infusionOverUnit) {
		this.infusionOverUnit = infusionOverUnit;
	}
	/**
	 * @return the infusionRate
	 */
	public String getInfusionRate() {
		return infusionRate;
	}
	/**
	 * @param infusionRate the infusionRate to set
	 */
	public void setInfusionRate(String infusionRate) {
		this.infusionRate = infusionRate;
	}
	/**
	 * @return the infusionVolStrUnit
	 */
	public String getInfusionVolStrUnit() {
		return infusionVolStrUnit;
	}
	/**
	 * @param infusionVolStrUnit the infusionVolStrUnit to set
	 */
	public void setInfusionVolStrUnit(String infusionVolStrUnit) {
		this.infusionVolStrUnit = infusionVolStrUnit;
	}
	/**
	 * @return the infusionPerUnit
	 */
	public String getInfusionPerUnit() {
		return infusionPerUnit;
	}
	/**
	 * @param infusionPerUnit the infusionPerUnit to set
	 */
	public void setInfusionPerUnit(String infusionPerUnit) {
		this.infusionPerUnit = infusionPerUnit;
	}
	/**
	 * @return the splitFluidMedicationYN
	 */
	public String getSplitFluidMedicationYN() {
		return splitFluidMedicationYN;
	}
	/**
	 * @param splitFluidMedicationYN the splitFluidMedicationYN to set
	 */
	public void setSplitFluidMedicationYN(String splitFluidMedicationYN) {
		this.splitFluidMedicationYN = splitFluidMedicationYN;
	}
	/**
	 * @return the orderQty
	 */
	public String getOrderQty() {
		return orderQty;
	}
	/**
	 * @param orderQty the orderQty to set
	 */
	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}
	/**
	 * @return the mulitpleFlowRate
	 */
	public ArrayList<CurMedMultipleFlowRateHO> getMulitpleFlowRate() {
		return mulitpleFlowRate;
	}
	/**
	 * @param mulitpleFlowRate the mulitpleFlowRate to set
	 */
	public void setMulitpleFlowRate(
			ArrayList<CurMedMultipleFlowRateHO> mulitpleFlowRate) {
		this.mulitpleFlowRate = mulitpleFlowRate;
	}
	
	

}
