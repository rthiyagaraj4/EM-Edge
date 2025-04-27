/**
 * 
 */
package eIPAD.InPatientDetails.ho;

/**
 * @author saraswathir
 *
 */
public class PatientTaskItem {
	
	private boolean taskPending;
	private String taskDetails;
	private String taskDescription;
	/**
	 * @return the taskPending
	 */
	public boolean isTaskPending() {
		return taskPending;
	}
	/**
	 * @param taskPending the taskPending to set
	 */
	public void setTaskPending(boolean taskPending) {
		this.taskPending = taskPending;
	}
	/**
	 * @return the taskDetails
	 */
	public String getTaskDetails() {
		return taskDetails;
	}
	/**
	 * @param taskDetails the taskDetails to set
	 */
	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}
	/**
	 * @return the taskDescription
	 */
	public String getTaskDescription() {
		return taskDescription;
	}
	/**
	 * @param taskDescription the taskDescription to set
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}


}
