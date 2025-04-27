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
package eIP.advbedmgmt.transaction.requestfortransfer.response;

/**
 * This is the response class storing the meta data needed to launch
 * request for transfer functionality in ABM
 * @author GRamamoorthy
 *
 */
public class TransferMetaDataResponse {

	/**
	 * Data members in this class
	 */
	private String patientCheckInAllowedYN = null;
	
	private String setupBillDetailsInIPYN = null;
	
	private String blInterfacedYN = null;
	
	private String priorityStatus = null;
	
	private String changeBedClassYN = null;
	
	private String deactivatePseudoBedYN = null;
	
	private int defaultBlockPeriodForTransferOut = 0;
	
	private int bedBlockPeriodNormal = 0;
	
	private String reserveBedOnTransferYN = null;
	
	private int bedBlockPeriodMax = 0;
	
	private String bedBlockPeriodMaxType = null;
	
	private String allowMultipleBedForReservationYN = null;
	
	private int maxDischargePeriodForDC = 0;

	/**
	 * @return the patientCheckInAllowedYN
	 */
	public String getPatientCheckInAllowedYN() {
		return patientCheckInAllowedYN;
	}

	/**
	 * @param patientCheckInAllowedYN the patientCheckInAllowedYN to set
	 */
	public void setPatientCheckInAllowedYN(String patientCheckInAllowedYN) {
		this.patientCheckInAllowedYN = patientCheckInAllowedYN;
	}

	/**
	 * @return the setupBillDetailsInIPYN
	 */
	public String getSetupBillDetailsInIPYN() {
		return setupBillDetailsInIPYN;
	}

	/**
	 * @param setupBillDetailsInIPYN the setupBillDetailsInIPYN to set
	 */
	public void setSetupBillDetailsInIPYN(String setupBillDetailsInIPYN) {
		this.setupBillDetailsInIPYN = setupBillDetailsInIPYN;
	}

	/**
	 * @return the blInterfacedYN
	 */
	public String getBlInterfacedYN() {
		return blInterfacedYN;
	}

	/**
	 * @param blInterfacedYN the blInterfacedYN to set
	 */
	public void setBlInterfacedYN(String blInterfacedYN) {
		this.blInterfacedYN = blInterfacedYN;
	}

	/**
	 * @return the priorityStatus
	 */
	public String getPriorityStatus() {
		return priorityStatus;
	}

	/**
	 * @param priorityStatus the priorityStatus to set
	 */
	public void setPriorityStatus(String priorityStatus) {
		this.priorityStatus = priorityStatus;
	}

	/**
	 * @return the changeBedClassYN
	 */
	public String getChangeBedClassYN() {
		return changeBedClassYN;
	}

	/**
	 * @param changeBedClassYN the changeBedClassYN to set
	 */
	public void setChangeBedClassYN(String changeBedClassYN) {
		this.changeBedClassYN = changeBedClassYN;
	}

	/**
	 * @return the deactivatePseudoBedYN
	 */
	public String getDeactivatePseudoBedYN() {
		return deactivatePseudoBedYN;
	}

	/**
	 * @param deactivatePseudoBedYN the deactivatePseudoBedYN to set
	 */
	public void setDeactivatePseudoBedYN(String deactivatePseudoBedYN) {
		this.deactivatePseudoBedYN = deactivatePseudoBedYN;
	}

	/**
	 * @return the defaultBlockPeriodForTransferOut
	 */
	public int getDefaultBlockPeriodForTransferOut() {
		return defaultBlockPeriodForTransferOut;
	}

	/**
	 * @param defaultBlockPeriodForTransferOut the defaultBlockPeriodForTransferOut to set
	 */
	public void setDefaultBlockPeriodForTransferOut(
			int defaultBlockPeriodForTransferOut) {
		this.defaultBlockPeriodForTransferOut = defaultBlockPeriodForTransferOut;
	}

	/**
	 * @return the bedBlockPeriodNormal
	 */
	public int getBedBlockPeriodNormal() {
		return bedBlockPeriodNormal;
	}

	/**
	 * @param bedBlockPeriodNormal the bedBlockPeriodNormal to set
	 */
	public void setBedBlockPeriodNormal(int bedBlockPeriodNormal) {
		this.bedBlockPeriodNormal = bedBlockPeriodNormal;
	}

	/**
	 * @return the reserveBedOnTransferYN
	 */
	public String getReserveBedOnTransferYN() {
		return reserveBedOnTransferYN;
	}

	/**
	 * @param reserveBedOnTransferYN the reserveBedOnTransferYN to set
	 */
	public void setReserveBedOnTransferYN(String reserveBedOnTransferYN) {
		this.reserveBedOnTransferYN = reserveBedOnTransferYN;
	}

	/**
	 * @return the bedBlockPeriodMax
	 */
	public int getBedBlockPeriodMax() {
		return bedBlockPeriodMax;
	}

	/**
	 * @param bedBlockPeriodMax the bedBlockPeriodMax to set
	 */
	public void setBedBlockPeriodMax(int bedBlockPeriodMax) {
		this.bedBlockPeriodMax = bedBlockPeriodMax;
	}

	/**
	 * @return the bedBlockPeriodMaxType
	 */
	public String getBedBlockPeriodMaxType() {
		return bedBlockPeriodMaxType;
	}

	/**
	 * @param bedBlockPeriodMaxType the bedBlockPeriodMaxType to set
	 */
	public void setBedBlockPeriodMaxType(String bedBlockPeriodMaxType) {
		this.bedBlockPeriodMaxType = bedBlockPeriodMaxType;
	}

	/**
	 * @return the allowMultipleBedForReservationYN
	 */
	public String getAllowMultipleBedForReservationYN() {
		return allowMultipleBedForReservationYN;
	}

	/**
	 * @param allowMultipleBedForReservationYN the allowMultipleBedForReservationYN to set
	 */
	public void setAllowMultipleBedForReservationYN(
			String allowMultipleBedForReservationYN) {
		this.allowMultipleBedForReservationYN = allowMultipleBedForReservationYN;
	}

	/**
	 * @return the maxDischargePeriodForDC
	 */
	public int getMaxDischargePeriodForDC() {
		return maxDischargePeriodForDC;
	}

	/**
	 * @param maxDischargePeriodForDC the maxDischargePeriodForDC to set
	 */
	public void setMaxDischargePeriodForDC(int maxDischargePeriodForDC) {
		this.maxDischargePeriodForDC = maxDischargePeriodForDC;
	}	

	
}
