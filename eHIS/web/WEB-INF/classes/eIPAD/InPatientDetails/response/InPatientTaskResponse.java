/**
 * 
 */
package eIPAD.InPatientDetails.response;

import eIPAD.InPatientDetails.ho.PatientTaskItem;
import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author saraswathir
 *
 */
public class InPatientTaskResponse extends GenericResponse{
	
	/**
	 * 
	 */
	private PatientTaskItem chargeConsultationTask = new PatientTaskItem();
	private PatientTaskItem insuranceAuthorizationFormTask = new PatientTaskItem();

	/**
	 * @return the insuranceAuthorizationFormTask
	 */
	public PatientTaskItem getInsuranceAuthorizationFormTask() {
		return insuranceAuthorizationFormTask;
	}

	/**
	 * @param insuranceAuthorizationFormTask the insuranceAuthorizationFormTask to set
	 */
	public void setInsuranceAuthorizationFormTask(
			PatientTaskItem insuranceAuthorizationFormTask) {
		this.insuranceAuthorizationFormTask = insuranceAuthorizationFormTask;
	}

	/**
	 * @return the chargeConsultationTask
	 */
	public PatientTaskItem getChargeConsultationTask() {
		return chargeConsultationTask;
	}

	/**
	 * @param chargeConsultationTask the chargeConsultationTask to set
	 */
	public void setChargeConsultationTask(PatientTaskItem chargeConsultationTask) {
		this.chargeConsultationTask = chargeConsultationTask;
	}
	
	
}
