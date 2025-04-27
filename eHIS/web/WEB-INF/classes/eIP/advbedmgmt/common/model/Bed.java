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
package eIP.advbedmgmt.common.model;

/**
 * This is the model class to represent a bed Contains details like bed
 * dimensions, occupying patient details This class extends Basic Bed
 * 
 * @author gramamoorthy
 * 
 */
public class Bed extends BasicBed {

	/**
	 * Data members of this class
	 */
	protected Patient patientDetails = null;

	protected Practitioner practitionerDetails = null;

	protected String bedClassCode = null;

	protected String bedTypeCode = null;

	protected String specialtyCode = null;

	protected boolean psuedoBed = false;

	protected int bedLeftPosition = 0;

	protected int bedTopPosition = 0;

	protected int bedHeight = 0;

	protected int bedWidth = 0;

	protected String currentStatus = null;

	protected String effectiveStatus = null;
	
	/**
	 * new data members added
	 */
	protected String bookingType = null;
	
	protected String bedStat = null;
	
	protected String trnsAllowed = null;

	/**
	 * Default empty constructor
	 */
	public Bed() {
		// does nothing
	}

	/**
	 * @param bedNumber
	 * @param bedLeftPosition
	 * @param bedTopPosition
	 * @param bedHeight
	 * @param bedWidth
	 */
	public Bed(String bedNumber, int bedLeftPosition, int bedTopPosition,
			int bedHeight, int bedWidth) {
		setBedNumber(bedNumber);
		this.bedLeftPosition = bedLeftPosition;
		this.bedTopPosition = bedTopPosition;
		this.bedHeight = bedHeight;
		this.bedWidth = bedWidth;
	}

	/**
	 * @return the bedClassCode
	 */
	public String getBedClassCode() {
		return bedClassCode;
	}

	/**
	 * @param bedClassCode
	 *            the bedClassCode to set
	 */
	public void setBedClassCode(String bedClassCode) {
		this.bedClassCode = bedClassCode;
	}

	/**
	 * @return the bedTypeCode
	 */
	public String getBedTypeCode() {
		return bedTypeCode;
	}

	/**
	 * @param bedTypeCode
	 *            the bedTypeCode to set
	 */
	public void setBedTypeCode(String bedTypeCode) {
		this.bedTypeCode = bedTypeCode;
	}

	/**
	 * @return the psuedoBed
	 */
	public boolean isPsuedoBed() {
		return psuedoBed;
	}

	/**
	 * @param psuedoBed
	 *            the psuedoBed to set
	 */
	public void setPsuedoBed(boolean psuedoBed) {
		this.psuedoBed = psuedoBed;
	}

	/**
	 * @return the patientDetails
	 */
	public Patient getPatientDetails() {
		return patientDetails;
	}

	/**
	 * @param patientDetails
	 *            the patientDetails to set
	 */
	public void setPatientDetails(Patient patientDetails) {
		this.patientDetails = patientDetails;
	}

	/**
	 * @return the bedLeftPosition
	 */
	public int getBedLeftPosition() {
		return bedLeftPosition;
	}

	/**
	 * @param bedLeftPosition
	 *            the bedLeftPosition to set
	 */
	public void setBedLeftPosition(int bedLeftPosition) {
		this.bedLeftPosition = bedLeftPosition;
	}

	/**
	 * @return the bedTopPosition
	 */
	public int getBedTopPosition() {
		return bedTopPosition;
	}

	/**
	 * @param bedTopPosition
	 *            the bedTopPosition to set
	 */
	public void setBedTopPosition(int bedTopPosition) {
		this.bedTopPosition = bedTopPosition;
	}

	/**
	 * @return the bedHeight
	 */
	public int getBedHeight() {
		return bedHeight;
	}

	/**
	 * @param bedHeight
	 *            the bedHeight to set
	 */
	public void setBedHeight(int bedHeight) {
		this.bedHeight = bedHeight;
	}

	/**
	 * @return the bedWidth
	 */
	public int getBedWidth() {
		return bedWidth;
	}

	/**
	 * @param bedWidth
	 *            the bedWidth to set
	 */
	public void setBedWidth(int bedWidth) {
		this.bedWidth = bedWidth;
	}

	/**
	 * @return the practitionerDetails
	 */
	public Practitioner getPractitionerDetails() {
		return practitionerDetails;
	}

	/**
	 * @param practitionerDetails
	 *            the practitionerDetails to set
	 */
	public void setPractitionerDetails(Practitioner practitionerDetails) {
		this.practitionerDetails = practitionerDetails;
	}

	/**
	 * @return the specialtyCode
	 */
	public String getSpecialtyCode() {
		return specialtyCode;
	}

	/**
	 * @param specialtyCode
	 *            the specialtyCode to set
	 */
	public void setSpecialtyCode(String specialtyCode) {
		this.specialtyCode = specialtyCode;
	}

	/**
	 * @return the currentStatus
	 */
	public String getCurrentStatus() {
		return currentStatus;
	}

	/**
	 * @param currentStatus
	 *            the currentStatus to set
	 */
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	/**
	 * @return the effectiveStatus
	 */
	public String getEffectiveStatus() {
		return effectiveStatus;
	}

	/**
	 * @param effectiveStatus
	 *            the effectiveStatus to set
	 */
	public void setEffectiveStatus(String effectiveStatus) {
		this.effectiveStatus = effectiveStatus;
	}

	/**
	 * @return the bookingType
	 */
	public String getBookingType() {
		return bookingType;
	}

	/**
	 * @param bookingType the bookingType to set
	 */
	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	/**
	 * @return the bedStatus
	 */
	public String getBedStat() {
		return bedStat;
	}

	/**
	 * @param bedStatus the bedStatus to set
	 */
	public void setBedStat(String bedStat) {
		this.bedStat = bedStat;
	}

	/**
	 * @return the trnsAllowed
	 */
	public String getTrnsAllowed() {
		return trnsAllowed;
	}

	/**
	 * @param trnsAllowed the trnsAllowed to set
	 */
	public void setTrnsAllowed(String trnsAllowed) {
		this.trnsAllowed = trnsAllowed;
	}
}
