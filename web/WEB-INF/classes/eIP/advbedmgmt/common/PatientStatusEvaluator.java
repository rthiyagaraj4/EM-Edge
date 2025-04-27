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
package eIP.advbedmgmt.common;

/**
 * This class is used to evaluate the status of a patient this class will be
 * used in patient search as well as in the bed status modules
 * 
 * @author GRamamoorthy
 * 
 */
public class PatientStatusEvaluator {

	/**
	 * This method evaluates the different statuses contained in the input
	 * struct attributes array
	 * 
	 * @param structAttributes
	 * @return
	 */
	public static boolean evaluateStructAttributes(Object[] structAttributes) {
		boolean evaluationResult = false;

		final int TOTAL_INDEX_COUNT = 11;
		// safe check
		if (structAttributes == null
				|| structAttributes.length < TOTAL_INDEX_COUNT) {
			return evaluationResult;
		}

		// another safe check - check if encounter id is filled - if not data is
		// not proper
		// so return false
		String encounterId = (String) structAttributes[CommonConstants.BED_STAT_ENC_ID_INDEX];
		if (encounterId == null || encounterId.trim().equals("")) {
			return evaluationResult;
		}
		// another safe check - check if bed number is filled - if not data is
		// not proper
		// so return false
		String bedNumber = (String) structAttributes[CommonConstants.BED_STAT_BED_NUM_INDEX];
		if (bedNumber == null || bedNumber.trim().equals("")) {
			return evaluationResult;
		}

		// now the individual statuses have to be checked
		// first check the admission status
		// if it is having value "00" or "01" - then no need to evaluate
		// other statuses - return true
		String admissionStatus = (String) structAttributes[CommonConstants.ADMISSION_STATUS_INDEX];
		if (PatientStatusConstants.ADMITTED_STATUS_DEFAULT_VALUE
				.equals(admissionStatus)
				|| PatientStatusConstants.ADMISSION_INITIATED_STATUS_DEFAULT_VALUE
						.equals(admissionStatus)) {
			evaluationResult = true;
			return evaluationResult;
		}

		// next check the transfer status
		// value 3 - it is transfer out
		// value 1 - transfer accepted
		// value 0 - transfer initiated
		String transferStatus = (String) structAttributes[CommonConstants.TRANSFER_STATUS_INDEX];
		if (PatientStatusConstants.TRANSFER_OUT_VALUE.equals(transferStatus)
				|| PatientStatusConstants.TRANFER_ACCEPTED_VALUE
						.equals(transferStatus)
				|| PatientStatusConstants.TRANFER_INITIATED_VALUE
						.equals(transferStatus)
				) {
			evaluationResult = true;
			return evaluationResult;
		}

		// next leave status
		String leaveStatus = (String) structAttributes[CommonConstants.LEAVE_STATUS_INDEX];
		if (PatientStatusConstants.LEAVE_STATUS_VALUE.equals(leaveStatus)
				|| PatientStatusConstants.ABSCOND_STATUS_VALUE
						.equals(leaveStatus)) {
			evaluationResult = true;
			return evaluationResult;
		}

		// next blocked and blocked overrideable
		String blockedStatus = (String) structAttributes[CommonConstants.BLOCKED_STATUS_INDEX];
		if (PatientStatusConstants.BLOCKED_STATUS_VALUE.contains(blockedStatus)) {
			evaluationResult = true;
			return evaluationResult;
		}

		String blockedOverrideStatus = (String) structAttributes[CommonConstants.BLOCKED_OVERRIDE_STATUS_INDEX];
		if (PatientStatusConstants.BLOCKED_OVERRIDE_STATUS_VALUE
				.equals(blockedOverrideStatus)) {
			evaluationResult = true;
			return evaluationResult;
		}

		// next booked
		String bookedStatus = (String) structAttributes[CommonConstants.BOOK_STATUS_INDEX];
		if (bookedStatus != null && !bookedStatus.trim().equals("")) {
			evaluationResult = true;
			return evaluationResult;
		}

		// next discharge related status
		String dischargeStatus = (String) structAttributes[CommonConstants.DISCHARGE_STATUS_INDEX];
		if (PatientStatusConstants.DISCHARGE_INITIATED_STATUS_VALUE
				.equals(dischargeStatus)
				|| PatientStatusConstants.DISCHARGED_STATUS_VALUE
						.equals(dischargeStatus)) {
			evaluationResult = true;
			return evaluationResult;
		}

		// next infant
		String infantStatus = (String) structAttributes[CommonConstants.INFANT_STATUS_INDEX];
		if (infantStatus != null && !infantStatus.trim().equals("")) {
			evaluationResult = true;
			return evaluationResult;
		}

		// next vacant
		String vacantStatus = (String) structAttributes[CommonConstants.VACANT_STATUS_INDEX];
		if (vacantStatus != null && !vacantStatus.trim().equals("")) {
			evaluationResult = true;
			return evaluationResult;
		}

		return evaluationResult;
	}

}
