/**
 * 
 */
package eIPAD.chartsummary.clinicalnotes.healthobject;

/**
 * @author psenthil
 *
 */
public abstract class NoteDetailsTimeRange {
	private String eventClass;
	private String facilityId;
	private String accessionNum;
	private String noteType;
	private String noteTypeDesc;
	private String noteGroupId;
	private String eventDate;
	private String eventTime;
	private String encounterId;
	private String status;
	private String serviceCode;
	private String performedBy;
	private String primarySpec;
	private String actionType;
	/**
	 * @return the actionType
	 */
	public String getActionType() {
		return actionType;
	}

	/**
	 * @param actionType the actionType to set
	 */
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public abstract NotesData getDescription();
	
	/**
	 * @return the eventClass
	 */
	public String getEventClass() {
		return eventClass;
	}
	/**
	 * @param eventClass the eventClass to set
	 */
	public void setEventClass(String eventClass) {
		this.eventClass = eventClass;
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
	/**
	 * @return the accessionNum
	 */
	public String getAccessionNum() {
		return accessionNum;
	}
	/**
	 * @param accessionNum the accessionNum to set
	 */
	public void setAccessionNum(String accessionNum) {
		this.accessionNum = accessionNum;
	}
	/**
	 * @return the noteType
	 */
	public String getNoteType() {
		return noteType;
	}
	/**
	 * @param noteType the noteType to set
	 */
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}
	/**
	 * @return the noteTypeDesc
	 */
	public String getNoteTypeDesc() {
		return noteTypeDesc;
	}
	/**
	 * @param noteTypeDesc the noteTypeDesc to set
	 */
	public void setNoteTypeDesc(String noteTypeDesc) {
		this.noteTypeDesc = noteTypeDesc;
	}
	/**
	 * @return the noteGroupId
	 */
	public String getNoteGroupId() {
		return noteGroupId;
	}
	/**
	 * @param noteGroupId the noteGroupId to set
	 */
	public void setNoteGroupId(String noteGroupId) {
		this.noteGroupId = noteGroupId;
	}
	/**
	 * @return the eventDate
	 */
	public String getEventDate() {
		return eventDate;
	}
	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	/**
	 * @return the eventTime
	 */
	public String getEventTime() {
		return eventTime;
	}
	/**
	 * @param eventTime the eventTime to set
	 */
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the serviceCode
	 */
	public String getServiceCode() {
		return serviceCode;
	}

	/**
	 * @param serviceCode the serviceCode to set
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	/**
	 * @return the performedBy
	 */
	public String getPerformedBy() {
		return performedBy;
	}

	/**
	 * @param performedBy the performedBy to set
	 */
	public void setPerformedBy(String performedBy) {
		this.performedBy = performedBy;
	}

	/**
	 * @return the primarySpec
	 */
	public String getPrimarySpec() {
		return primarySpec;
	}

	/**
	 * @param primarySpec the primarySpec to set
	 */
	public void setPrimarySpec(String primarySpec) {
		this.primarySpec = primarySpec;
	}

}
