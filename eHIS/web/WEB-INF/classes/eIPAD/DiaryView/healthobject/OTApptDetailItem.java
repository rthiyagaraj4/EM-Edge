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
package eIPAD.DiaryView.healthobject;

import java.util.ArrayList;

/**
 * @author vchoughule 
 *
 */
public class OTApptDetailItem extends AppointmentDetailItem {
	private String procedureDetail;
	private String practRole;
	private String operationType;
	private String statusDesc;
	private String bookingStage;
	private String PACStatus;
	private String OrderId;
	private ArrayList<String> procDetail;
	/**
	 * @return the procedureDetail
	 */
	public String getProcedureDetail() {
		return procedureDetail;
	}
	/**
	 * @param procedureDetail the procedureDetail to set
	 */
	public void setProcedureDetail(String procedureDetail) {
		this.procedureDetail = procedureDetail;
	}
	/**
	 * @return the practRole
	 */
	public String getPractRole() {
		return practRole;
	}
	/**
	 * @param practRole the practRole to set
	 */
	public void setPractRole(String practRole) {
		this.practRole = practRole;
	}
	/**
	 * @return the operationType
	 */
	public String getOperationType() {
		return operationType;
	}
	/**
	 * @param operationType the operationType to set
	 */
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	/**
	 * @return the procDetail
	 */
	public ArrayList<String> getProcDetail() {
		return procDetail;
	}
	/**
	 * @param procDetail the procDetail to set
	 */
	public void setProcDetail(ArrayList<String> procDetail) {
		this.procDetail = procDetail;
	}
	/**
	 * @return the statusDesc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}
	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	/**
	 * @return the bookingStage
	 */
	public String getBookingStage() {
		return bookingStage;
	}
	/**
	 * @param bookingStage the bookingStage to set
	 */
	public void setBookingStage(String bookingStage) {
		this.bookingStage = bookingStage;
	}
	/**
	 * @return the pACStatus
	 */
	public String getPACStatus() {
		return PACStatus;
	}
	/**
	 * @param pACStatus the pACStatus to set
	 */
	public void setPACStatus(String pACStatus) {
		PACStatus = pACStatus;
	}
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return OrderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

}
