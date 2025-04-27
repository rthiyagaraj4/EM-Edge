/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eOT;

import java.io.Serializable;

public class StaffAssignmentTimeBean implements Serializable {

	/**
	 * 
	 */ 
	private static final long serialVersionUID = 851973833523064837L;

	private String operatingFacilityId;
	private int staffAssginmentId;
	private int staffAssginmentHistId;
	private String assignmentDate;
	private String operRoomCode;
	private String staffId;

	private String roleId;
	private String showWidgetYN;
	private String fromTime;
	private String toTime;
	

	//For description
	private String staffName;
	private String roleDesc;
	
	//For Audit 
	private String modifiedBy;
	private String modifiedDate;

	

	public String getOperatingFacilityId() {
		return operatingFacilityId;
	}

	public void setOperatingFacilityId(String operatingFacilityId) {
		this.operatingFacilityId = operatingFacilityId;
	}

	public int getStaffAssginmentId() {
		return staffAssginmentId;
	}

	public void setStaffAssginmentId(int staffAssginmentId) {
		this.staffAssginmentId = staffAssginmentId;
	}

	public String getAssignmentDate() {
		return assignmentDate;
	}

	public void setAssignmentDate(String assignmentDate) {
		this.assignmentDate = assignmentDate;
	}

	public String getOperRoomCode() {
		return operRoomCode;
	}

	public void setOperRoomCode(String operRoomCode) {
		this.operRoomCode = operRoomCode;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getShowWidgetYN() {
		return showWidgetYN;
	}

	public void setShowWidgetYN(String showWidgetYN) {
		this.showWidgetYN = showWidgetYN;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	

	public int getStaffAssginmentHistId() {
		return staffAssginmentHistId;
	}

	public void setStaffAssginmentHistId(int staffAssginmentHistId) {
		this.staffAssginmentHistId = staffAssginmentHistId;
	}
	
	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
