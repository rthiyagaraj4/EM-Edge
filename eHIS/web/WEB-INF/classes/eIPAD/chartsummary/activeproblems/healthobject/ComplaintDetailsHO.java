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
package eIPAD.chartsummary.activeproblems.healthobject;

/**
 * @author SaraswathiR  
 *
 */
public class ComplaintDetailsHO {
	
	private String complaintCode;
	private String complaintDesc;
	private String onsetDate;
	private String remarks;
	private String encounterId;
	private String facilityId;
	/**
	 * @return the complaintCode
	 */
	public String getComplaintCode() {
		return complaintCode;
	}
	/**
	 * @param complaintCode the complaintCode to set
	 */
	public void setComplaintCode(String complaintCode) {
		this.complaintCode = complaintCode;
	}
	/**
	 * @return the complaintDesc
	 */
	public String getComplaintDesc() {
		return complaintDesc;
	}
	/**
	 * @param complaintDesc the complaintDesc to set
	 */
	public void setComplaintDesc(String complaintDesc) {
		this.complaintDesc = complaintDesc;
	}
	/**
	 * @return the onsetDate
	 */
	public String getOnsetDate() {
		return onsetDate;
	}
	/**
	 * @param onsetDate the onsetDate to set
	 */
	public void setOnsetDate(String onsetDate) {
		this.onsetDate = onsetDate;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the encounterId
	 */
	public String getEncounterId() {
		return encounterId;
	}
	/**
	 * @param encounterId the encounterId to set
	 */
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}
	/**
	 * @return the facilityId
	 */
	public String getFacilityId() {
		return facilityId;
	}
	/**
	 * @param facilityId the facilityId to set
	 */
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	
}
