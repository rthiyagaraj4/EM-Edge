/***************************************************************************************************************
 * Author   :   Ravindranath.O
 * Desc     :	
 ***************************************************************************************************************/
package eXH;

public class NotificationCriteriaBean
{
	public NotificationCriteriaBean() {
		
	}
	private String fromMsgID = "";
	private String toMsgID = "";
	private String recipientType = "";
	private String fromMsgDate = XHUtil.convertDateToStr(new java.util.Date(), "dd/MM/yyyy");
	private String toMsgDate = XHUtil.convertDateToStr(new java.util.Date(), "dd/MM/yyyy");
	private String msgStatus = "";
	private String contactMode = "";
	private String facilityID = "";
	private String recipientID = "";
	private String recipientName = "";
	
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	private String contactType = "";
	private String languageID = "";
	private String notificationType = "";
	private String toCommID = "";
	private String eventTypeDesc = "";
	
	public String getEventTypeDesc() {
		return eventTypeDesc;
	}
	public void setEventTypeDesc(String eventTypeDesc) {
		this.eventTypeDesc = eventTypeDesc;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getMessageTypeDesc() {
		return messageTypeDesc;
	}
	public void setMessageTypeDesc(String messageTypeDesc) {
		this.messageTypeDesc = messageTypeDesc;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	private String eventType = "";
	private String messageTypeDesc = "";
	private String messageType = "";
	
	public String getMsgStatus() {
		return msgStatus;
	}
	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
	}
	public String getContactMode() {
		return contactMode;
	}
	public void setContactMode(String contactMode) {
		this.contactMode = contactMode;
	}
	public String getFacilityID() {
		return facilityID;
	}
	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}
	public String getRecipientID() {
		return recipientID;
	}
	public void setRecipientID(String recipientID) {
		this.recipientID = recipientID;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	public String getLanguageID() {
		return languageID;
	}
	public void setLanguageID(String languageID) {
		this.languageID = languageID;
	}
	public String getFromMsgID() {
		return fromMsgID;
	}
	public void setFromMsgID(String fromMsgID) {
		this.fromMsgID = fromMsgID;
	}
	public String getToMsgID() {
		return toMsgID;
	}
	public void setToMsgID(String toMsgID) {
		this.toMsgID = toMsgID;
	}
	public String getFromMsgDate() {
		return fromMsgDate;
	}
	public void setFromMsgDate(String fromMsgDate) {
		this.fromMsgDate = fromMsgDate;
	}
	public String getToMsgDate() {
		return toMsgDate;
	}
	public void setToMsgDate(String toMsgDate) {
		this.toMsgDate = toMsgDate;
	}
	public String getRecipientType() {
		return recipientType;
	}
	public void setRecipientType(String recipientType) {
		this.recipientType = recipientType;
	}
	public String getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}
	public String getToCommID() {
		return toCommID;
	}
	public void setToCommID(String toCommID) {
		this.toCommID = toCommID;
	}
}