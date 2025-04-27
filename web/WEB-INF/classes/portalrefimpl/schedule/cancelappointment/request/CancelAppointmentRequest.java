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
package portalrefimpl.schedule.cancelappointment.request;

import portalrefimpl.schedule.common.request.AppointmentRequest;

/**
 * This is the request class for the cancel appointment service
 * This class extends AppointmentRequest
 * @author gramamoorthy
 *
 */
public class CancelAppointmentRequest extends AppointmentRequest {

	/**
	 * Data members in this class
	 */
	private String appointmentReferenceNumber = null;
	
	private String visitIndicator = null;
	
	private String reasonForCancellation = null;
	
	private String reasonForRevision = null;
	
	private String alcnCriteria = null;
	
	private String patientCategory = null;
	
	private String addedAtWorkStation = null;
	
	private String forced = null;
	
	private String referralValue = null;
	
	private String episodeType = null;
	
	private String appointmentDate = null;
	
	private String blOperational = null;
	
	private String captureFinancialDetailsYn = null;
	
	private String sendEmailYn = null;
	
	private String operation = null;
	
	private String emailAppYn = null;
	
	private String emailAppForApptWoPatientIdYn = null;

	/**
	 * @return the appointmentReferenceNumber
	 */
	public String getAppointmentReferenceNumber() {
		return appointmentReferenceNumber;
	}

	/**
	 * @param appointmentReferenceNumber the appointmentReferenceNumber to set
	 */
	public void setAppointmentReferenceNumber(String appointmentReferenceNumber) {
		this.appointmentReferenceNumber = appointmentReferenceNumber;
	}

	/**
	 * @return the visitIndicator
	 */
	public String getVisitIndicator() {
		return visitIndicator;
	}

	/**
	 * @param visitIndicator the visitIndicator to set
	 */
	public void setVisitIndicator(String visitIndicator) {
		this.visitIndicator = visitIndicator;
	}

	/**
	 * @return the reasonForCancellation
	 */
	public String getReasonForCancellation() {
		return reasonForCancellation;
	}

	/**
	 * @param reasonForCancellation the reasonForCancellation to set
	 */
	public void setReasonForCancellation(String reasonForCancellation) {
		this.reasonForCancellation = reasonForCancellation;
	}

	/**
	 * @return the reasonForRevision
	 */
	public String getReasonForRevision() {
		return reasonForRevision;
	}

	/**
	 * @param reasonForRevision the reasonForRevision to set
	 */
	public void setReasonForRevision(String reasonForRevision) {
		this.reasonForRevision = reasonForRevision;
	}

	/**
	 * @return the alcnCriteria
	 */
	public String getAlcnCriteria() {
		return alcnCriteria;
	}

	/**
	 * @param alcnCriteria the alcnCriteria to set
	 */
	public void setAlcnCriteria(String alcnCriteria) {
		this.alcnCriteria = alcnCriteria;
	}

	/**
	 * @return the patientCategory
	 */
	public String getPatientCategory() {
		return patientCategory;
	}

	/**
	 * @param patientCategory the patientCategory to set
	 */
	public void setPatientCategory(String patientCategory) {
		this.patientCategory = patientCategory;
	}

	/**
	 * @return the addedAtWorkStation
	 */
	public String getAddedAtWorkStation() {
		return addedAtWorkStation;
	}

	/**
	 * @param addedAtWorkStation the addedAtWorkStation to set
	 */
	public void setAddedAtWorkStation(String addedAtWorkStation) {
		this.addedAtWorkStation = addedAtWorkStation;
	}

	/**
	 * @return the forced
	 */
	public String getForced() {
		return forced;
	}

	/**
	 * @param forced the forced to set
	 */
	public void setForced(String forced) {
		this.forced = forced;
	}

	/**
	 * @return the referralValue
	 */
	public String getReferralValue() {
		return referralValue;
	}

	/**
	 * @param referralValue the referralValue to set
	 */
	public void setReferralValue(String referralValue) {
		this.referralValue = referralValue;
	}


	/**
	 * @return the episodeType
	 */
	public String getEpisodeType() {
		return episodeType;
	}

	/**
	 * @param episodeType the episodeType to set
	 */
	public void setEpisodeType(String episodeType) {
		this.episodeType = episodeType;
	}

	/**
	 * @return the appointmentDate
	 */
	public String getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	/**
	 * @return the blOperational
	 */
	public String getBlOperational() {
		return blOperational;
	}

	/**
	 * @param blOperational the blOperational to set
	 */
	public void setBlOperational(String blOperational) {
		this.blOperational = blOperational;
	}

	/**
	 * @return the captureFinancialDetailsYn
	 */
	public String getCaptureFinancialDetailsYn() {
		return captureFinancialDetailsYn;
	}

	/**
	 * @param captureFinancialDetailsYn the captureFinancialDetailsYn to set
	 */
	public void setCaptureFinancialDetailsYn(String captureFinancialDetailsYn) {
		this.captureFinancialDetailsYn = captureFinancialDetailsYn;
	}

	/**
	 * @return the sendEmailYn
	 */
	public String getSendEmailYn() {
		return sendEmailYn;
	}

	/**
	 * @param sendEmailYn the sendEmailYn to set
	 */
	public void setSendEmailYn(String sendEmailYn) {
		this.sendEmailYn = sendEmailYn;
	}

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * @return the emailAppYn
	 */
	public String getEmailAppYn() {
		return emailAppYn;
	}

	/**
	 * @param emailAppYn the emailAppYn to set
	 */
	public void setEmailAppYn(String emailAppYn) {
		this.emailAppYn = emailAppYn;
	}

	/**
	 * @return the emailAppForApptWoPatientIdYn
	 */
	public String getEmailAppForApptWoPatientIdYn() {
		return emailAppForApptWoPatientIdYn;
	}

	/**
	 * @param emailAppForApptWoPatientIdYn the emailAppForApptWoPatientIdYn to set
	 */
	public void setEmailAppForApptWoPatientIdYn(String emailAppForApptWoPatientIdYn) {
		this.emailAppForApptWoPatientIdYn = emailAppForApptWoPatientIdYn;
	}
	
}
