/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.request;

import java.util.ArrayList;

import eIPAD.chartsummary.common.request.GenericRequest;

/**
 * @author SaraswathiR
 *
 */
public class ClinicalEventsFilterRequest extends GenericRequest{
	String fromDate;
	String toDate;
	String selectedDate;
	String patientClass;
	String historyType;
	ArrayList<String> encounterIdList;
	/**
	 * @return the encounterIdList
	 */
	public ArrayList<String> getEncounterIdList() {
		return encounterIdList;
	}
	/**
	 * @param encounterIdList the encounterIdList to set
	 */
	public void setEncounterIdList(ArrayList<String> encounterIdList) {
		this.encounterIdList = encounterIdList;
	}
	
	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	/**
	 * @return the selectedDate
	 */
	public String getSelectedDate() {
		return selectedDate;
	}
	/**
	 * @param selectedDate the selectedDate to set
	 */
	public void setSelectedDate(String selectedDate) {
		this.selectedDate = selectedDate;
	}
	/**
	 * @return the patientClass
	 */
	public String getPatientClass() {
		return patientClass;
	}
	/**
	 * @param patientClass the patientClass to set
	 */
	public void setPatientClass(String patientClass) {
		this.patientClass = patientClass;
	}
	/**
	 * @return the historyType
	 */
	public String getHistoryType() {
		return historyType;
	}
	/**
	 * @param historyType the historyType to set
	 */
	public void setHistoryType(String historyType) {
		this.historyType = historyType;
	}
}
