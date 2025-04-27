/**
 * 
 */
package eIPAD.InPatientDetails.dao;

import javax.servlet.http.HttpServletRequest;

import eIPAD.InPatientDetails.request.InPatientTaskRequest;
import eIPAD.InPatientDetails.ho.PatientTaskItem;
import eIPAD.InPatientDetails.response.InPatientTaskResponse;
import eIPAD.chartsummary.common.response.TransactionResponse;

/**
 * @author saraswathir
 *
 */
public interface InPatientTasksDAO {
	public InPatientTaskResponse getInPatientPendingTasks(InPatientTaskRequest taskRequest,  HttpServletRequest request);
	public TransactionResponse getPerformChargePatient(InPatientTaskRequest taskRequest, HttpServletRequest request);
}
