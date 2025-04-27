package eXH;

public class GatewayServiceBO {
	
	private String status;   //1
	private String commStatus;  //2
	private String processID;   //3
	private String clientName;  //4   // gatewayserver
	private String applicationName;  //5
	private String protocolLinkID;  //6 gateway
	private String comType; // "I" for Inbound or "O" for Outbound
	private String startDateTime;    //12
	private String stopDateTime;   //14
	private String numOfRetries;  //7
	private String lastCommDateTime;  //8
	private String lastMsgId;        //9
	private String totalMsgs;  //10
	private String protocolType;  //11  // tcp/ip
	private String totalQueries;
	private String startedBy;   //13
	private String stoppedBy;   //15
	private String processType;
	private String addedWorkStation;
	private String modifiedWorkStation;
	private String addFacility;
	private String modifiedFacility;
	private String protocolLinkName;
	private String startedWSNo;
	
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
	 * @return the processID
	 */
	public String getProcessID() {
		return processID;
	}
	/**
	 * @param processID the processID to set
	 */
	public void setProcessID(String processID) {
		this.processID = processID;
	}
	/**
	 * @return the protocolLinkID
	 */
	public String getProtocolLinkID() {
		return protocolLinkID;
	}
	/**
	 * @param protocolLinkID the protocolLinkID to set
	 */
	public void setProtocolLinkID(String protocolLinkID) {
		this.protocolLinkID = protocolLinkID;
	}
	/**
	 * @return the comType
	 */
	public String getComType() {
		return comType;
	}
	/**
	 * @param comType the comType to set
	 */
	public void setComType(String comType) {
		this.comType = comType;
	}
	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
		/**
	 * @return the startDateTime
	 */
	public String getStartDateTime() {
		return startDateTime;
	}
	/**
	 * @param startDateTime the startDateTime to set
	 */
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	/**
	 * @return the stopDateTime
	 */
	public String getStopDateTime() {
		return stopDateTime;
	}
	/**
	 * @param stopDateTime the stopDateTime to set
	 */
	public void setStopDateTime(String stopDateTime) {
		this.stopDateTime = stopDateTime;
	}
	/**
	 * @return the numOfRetries
	 */
	public String getNumOfRetries() {
		return numOfRetries;
	}
	/**
	 * @param numOfRetries the numOfRetries to set
	 */
	public void setNumOfRetries(String numOfRetries) {
		this.numOfRetries = numOfRetries;
	}
	/**
	 * @return the lastCommDateTime
	 */
	public String getLastCommDateTime() {
		return lastCommDateTime;
	}
	/**
	 * @param lastCommDateTime the lastCommDateTime to set
	 */
	public void setLastCommDateTime(String lastCommDateTime) {
		this.lastCommDateTime = lastCommDateTime;
	}
	/**
	 * @return the lastMsgId
	 */
	public String getLastMsgId() {
		return lastMsgId;
	}
	/**
	 * @param lastMsgId the lastMsgId to set
	 */
	public void setLastMsgId(String lastMsgId) {
		this.lastMsgId = lastMsgId;
	}
	/**
	 * @return the totalMsgs
	 */
	public String getTotalMsgs() {
		return totalMsgs;
	}
	/**
	 * @param totalMsgs the totalMsgs to set
	 */
	public void setTotalMsgs(String totalMsgs) {
		this.totalMsgs = totalMsgs;
	}
	/**
	 * @return the totalQueries
	 */
	public String getTotalQueries() {
		return totalQueries;
	}
	/**
	 * @param totalQueries the totalQueries to set
	 */
	public void setTotalQueries(String totalQueries) {
		this.totalQueries = totalQueries;
	}
	/**
	 * @return the startedBy
	 */
	public String getStartedBy() {
		return startedBy;
	}
	/**
	 * @param startedBy the startedBy to set
	 */
	public void setStartedBy(String startedBy) {
		this.startedBy = startedBy;
	}
	/**
	 * @return the stoppedBy
	 */
	public String getStoppedBy() {
		return stoppedBy;
	}
	/**
	 * @param stoppedBy the stoppedBy to set
	 */
	public void setStoppedBy(String stoppedBy) {
		this.stoppedBy = stoppedBy;
	}
	/**
	 * @return the commStatus
	 */
	public String getCommStatus() {
		return commStatus;
	}
	/**
	 * @param commStatus the commStatus to set
	 */
	public void setCommStatus(String commStatus) {
		this.commStatus = commStatus;
	}
	/**
	 * @return the applicationName
	 */
	public String getApplicationName() {
		return applicationName;
	}
	/**
	 * @param applicationName the applicationName to set
	 */
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	/**
	 * @return the protocolType
	 */
	public String getProtocolType() {
		return protocolType;
	}
	/**
	 * @param protocolType the protocolType to set
	 */
	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType;
	}
	/**
	 * @return the processType
	 */
	public String getProcessType() {
		return processType;
	}
	/**
	 * @param processType the processType to set
	 */
	public void setProcessType(String processType) {
		this.processType = processType;
	}
	/**
	 * @return the addedWorkStation
	 */
	public String getAddedWorkStation() {
		return addedWorkStation;
	}
	/**
	 * @param addedWorkStation the addedWorkStation to set
	 */
	public void setAddedWorkStation(String addedWorkStation) {
		this.addedWorkStation = addedWorkStation;
	}
	/**
	 * @return the modifiedWorkStation
	 */
	public String getModifiedWorkStation() {
		return modifiedWorkStation;
	}
	/**
	 * @param modifiedWorkStation the modifiedWorkStation to set
	 */
	public void setModifiedWorkStation(String modifiedWorkStation) {
		this.modifiedWorkStation = modifiedWorkStation;
	}
	/**
	 * @return the addFacility
	 */
	public String getAddFacility() {
		return addFacility;
	}
	/**
	 * @param addFacility the addFacility to set
	 */
	public void setAddFacility(String addFacility) {
		this.addFacility = addFacility;
	}
	/**
	 * @return the modifiedFacility
	 */
	public String getModifiedFacility() {
		return modifiedFacility;
	}
	/**
	 * @param modifiedFacility the modifiedFacility to set
	 */
	public void setModifiedFacility(String modifiedFacility) {
		this.modifiedFacility = modifiedFacility;
	}
	/**
	 * @return the protocolLinkName
	 */
	public String getProtocolLinkName() {
		return protocolLinkName;
	}
	/**
	 * @param protocolLinkName the protocolLinkName to set
	 */
	public void setProtocolLinkName(String protocolLinkName) {
		this.protocolLinkName = protocolLinkName;
	}
	/**
	 * @return the startedWSNo
	 */
	public String getStartedWSNo() {
		return startedWSNo;
	}
	/**
	 * @param startedWSNo the startedWSNo to set
	 */
	public void setStartedWSNo(String startedWSNo) {
		this.startedWSNo = startedWSNo;
	} 
	
	

}
