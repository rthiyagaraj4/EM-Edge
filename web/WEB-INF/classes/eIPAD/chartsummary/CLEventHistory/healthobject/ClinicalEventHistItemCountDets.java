/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.healthobject;

import java.util.Date;

/**
 * @author SaraswathiR
 *
 */
public class ClinicalEventHistItemCountDets {

	private Date eventDate;
	private Date eventDateTime;
	private String histType;
	private String histDesc;
	private String encounterId;
	private String patientClass;
	/**
	 * @return the eventDate
	 */
	public Date getEventDate() {
		return eventDate;
	}
	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	/**
	 * @return the eventDateTime
	 */
	public Date getEventDateTime() {
		return eventDateTime;
	}
	/**
	 * @param eventDateTime the eventDateTime to set
	 */
	public void setEventDateTime(Date eventDateTime) {
		this.eventDateTime = eventDateTime;
	}
	/**
	 * @return the histType
	 */
	public String getHistType() {
		return histType;
	}
	/**
	 * @param histType the histType to set
	 */
	public void setHistType(String histType) {
		this.histType = histType;
	}
	/**
	 * @return the histDesc
	 */
	public String getHistDesc() {
		return histDesc;
	}
	/**
	 * @param histDesc the histDesc to set
	 */
	public void setHistDesc(String histDesc) {
		this.histDesc = histDesc;
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
	
}
