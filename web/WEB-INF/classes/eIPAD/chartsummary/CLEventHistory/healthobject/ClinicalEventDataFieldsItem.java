/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.healthobject;

import java.sql.Clob;
import java.util.Date;

/**
 * @author saraswathir
 *
 */
public class ClinicalEventDataFieldsItem {
	private String histRecType;
	private String histRecTypeDesc;
	private String histDataType;
	private String accessionnum;
	private String extImageObjId;
	private String eventDateTimeStr;
	private Clob note;
	private String patient_class;
	private String eventClass;
	private String eventClassDesc;
	private String eventGroup;
	private String eventGroupDesc;
	private String eventCode;
	private String eventDesc;
	private String accessionNum;
	private Date eventDateTime;
	private String resultNumPrefix;
	private String resultNum;
	private String resultNumUom;
	private String resultStr;
	private String normalcyInd;
	private String normalLow;
	private String normalHigh;
	private String criticalLow;
	private String criticalHigh;
	private String performedById;
	private String clinicianShortName;
	private String encounterId;
	private String histData;
	private String normalcyStr;
	private String facilityId;
	private String eventCodeType;
	private String deciresult;
	private String decival;
	private String result_uom;
	private String result_Number_values;
	/**
	 * @return the result_Number_values
	 */
	public String getResult_Number_values() {
		return result_Number_values;
	}
	/**
	 * @param result_Number_values the result_Number_values to set
	 */
	public void setResult_Number_values(String result_Number_values) {
		this.result_Number_values = result_Number_values;
	}
	/**
	 * @return the deciresult
	 */
	public String getDeciresult() {
		return deciresult;
	}
	/**
	 * @param deciresult the deciresult to set
	 */
	public void setDeciresult(String deciresult) {
		this.deciresult = deciresult;
	}
	/**
	 * @return the decival
	 */
	public String getDecival() {
		return decival;
	}
	/**
	 * @param decival the decival to set
	 */
	public void setDecival(String decival) {
		this.decival = decival;
	}
	/**
	 * @return the result_uom
	 */
	public String getResult_uom() {
		return result_uom;
	}
	/**
	 * @param result_uom the result_uom to set
	 */
	public void setResult_uom(String result_uom) {
		this.result_uom = result_uom;
	}
	/**
	 * @return the patient_class
	 */
	public String getPatient_class() {
		return patient_class;
	}
	/**
	 * @param patient_class the patient_class to set
	 */
	public void setPatient_class(String patient_class) {
		this.patient_class = patient_class;
	}
	/**
	 * @return the note
	 */
	public Clob getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(Clob note) {
		this.note = note;
	}
	/**
	 * @return the eventDateTimeStr
	 */
	public String getEventDateTimeStr() {
		return eventDateTimeStr;
	}
	/**
	 * @param eventDateTimeStr the eventDateTimeStr to set
	 */
	public void setEventDateTimeStr(String eventDateTimeStr) {
		this.eventDateTimeStr = eventDateTimeStr;
	}
	/**
	 * @return the extImageObjId
	 */
	public String getExtImageObjId() {
		return extImageObjId;
	}
	/**
	 * @param extImageObjId the extImageObjId to set
	 */
	public void setExtImageObjId(String extImageObjId) {
		this.extImageObjId = extImageObjId;
	}
	/**
	 * @return the accessionnum
	 */
	public String getAccessionnum() {
		return accessionnum;
	}
	/**
	 * @param accessionnum the accessionnum to set
	 */
	public void setAccessionnum(String accessionnum) {
		this.accessionnum = accessionnum;
	}
	/**
	 * @return the histDataType
	 */
	public String getHistDataType() {
		return histDataType;
	}
	/**
	 * @param histDataType the histDataType to set
	 */
	public void setHistDataType(String histDataType) {
		this.histDataType = histDataType;
	}
	
	private String contr_sys_event_code;
	/**
	 * @return the contr_sys_event_code
	 */
	public String getContr_sys_event_code() {
		return contr_sys_event_code;
	}
	/**
	 * @param contr_sys_event_code the contr_sys_event_code to set
	 */
	public void setContr_sys_event_code(String contr_sys_event_code) {
		this.contr_sys_event_code = contr_sys_event_code;
	}

	
	/**
	 * @return the histRecType
	 */
	public String getHistRecType() {
		return histRecType;
	}
	/**
	 * @param histRecType the histRecType to set
	 */
	public void setHistRecType(String histRecType) {
		this.histRecType = histRecType;
	}
	/**
	 * @return the histRecTypeDesc
	 */
	public String getHistRecTypeDesc() {
		return histRecTypeDesc;
	}
	/**
	 * @param histRecTypeDesc the histRecTypeDesc to set
	 */
	public void setHistRecTypeDesc(String histRecTypeDesc) {
		this.histRecTypeDesc = histRecTypeDesc;
	}
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
	 * @return the eventClassDesc
	 */
	public String getEventClassDesc() {
		return eventClassDesc;
	}
	/**
	 * @param eventClassDesc the eventClassDesc to set
	 */
	public void setEventClassDesc(String eventClassDesc) {
		this.eventClassDesc = eventClassDesc;
	}
	/**
	 * @return the eventGroup
	 */
	public String getEventGroup() {
		return eventGroup;
	}
	/**
	 * @param eventGroup the eventGroup to set
	 */
	public void setEventGroup(String eventGroup) {
		this.eventGroup = eventGroup;
	}
	/**
	 * @return the eventGroupDesc
	 */
	public String getEventGroupDesc() {
		return eventGroupDesc;
	}
	/**
	 * @param eventGroupDesc the eventGroupDesc to set
	 */
	public void setEventGroupDesc(String eventGroupDesc) {
		this.eventGroupDesc = eventGroupDesc;
	}
	/**
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}
	/**
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	/**
	 * @return the eventDesc
	 */
	public String getEventDesc() {
		return eventDesc;
	}
	/**
	 * @param eventDesc the eventDesc to set
	 */
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
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
	 * @return the resultNumPrefix
	 */
	public String getResultNumPrefix() {
		return resultNumPrefix;
	}
	/**
	 * @param resultNumPrefix the resultNumPrefix to set
	 */
	public void setResultNumPrefix(String resultNumPrefix) {
		this.resultNumPrefix = resultNumPrefix;
	}
	/**
	 * @return the resultNum
	 */
	public String getResultNum() {
		return resultNum;
	}
	/**
	 * @param resultNum the resultNum to set
	 */
	public void setResultNum(String resultNum) {
		this.resultNum = resultNum;
	}
	/**
	 * @return the resultNumUom
	 */
	public String getResultNumUom() {
		return resultNumUom;
	}
	/**
	 * @param resultNumUom the resultNumUom to set
	 */
	public void setResultNumUom(String resultNumUom) {
		this.resultNumUom = resultNumUom;
	}
	/**
	 * @return the resultStr
	 */
	public String getResultStr() {
		return resultStr;
	}
	/**
	 * @param resultStr the resultStr to set
	 */
	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}
	/**
	 * @return the normalcyInd
	 */
	public String getNormalcyInd() {
		return normalcyInd;
	}
	/**
	 * @param normalcyInd the normalcyInd to set
	 */
	public void setNormalcyInd(String normalcyInd) {
		this.normalcyInd = normalcyInd;
	}
	/**
	 * @return the normalLow
	 */
	public String getNormalLow() {
		return normalLow;
	}
	/**
	 * @param normalLow the normalLow to set
	 */
	public void setNormalLow(String normalLow) {
		this.normalLow = normalLow;
	}
	/**
	 * @return the normalHigh
	 */
	public String getNormalHigh() {
		return normalHigh;
	}
	/**
	 * @param normalHigh the normalHigh to set
	 */
	public void setNormalHigh(String normalHigh) {
		this.normalHigh = normalHigh;
	}
	/**
	 * @return the criticalLow
	 */
	public String getCriticalLow() {
		return criticalLow;
	}
	/**
	 * @param criticalLow the criticalLow to set
	 */
	public void setCriticalLow(String criticalLow) {
		this.criticalLow = criticalLow;
	}
	/**
	 * @return the criticalHigh
	 */
	public String getCriticalHigh() {
		return criticalHigh;
	}
	/**
	 * @param criticalHigh the criticalHigh to set
	 */
	public void setCriticalHigh(String criticalHigh) {
		this.criticalHigh = criticalHigh;
	}
	/**
	 * @return the performedById
	 */
	public String getPerformedById() {
		return performedById;
	}
	/**
	 * @param performedById the performedById to set
	 */
	public void setPerformedById(String performedById) {
		this.performedById = performedById;
	}
	/**
	 * @return the clinicianShortName
	 */
	public String getClinicianShortName() {
		return clinicianShortName;
	}
	/**
	 * @param clinicianShortName the clinicianShortName to set
	 */
	public void setClinicianShortName(String clinicianShortName) {
		this.clinicianShortName = clinicianShortName;
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
	 * @return the histData
	 */
	public String getHistData() {
		return histData;
	}
	/**
	 * @param histData the histData to set
	 */
	public void setHistData(String histData) {
		this.histData = histData;
	}
	/**
	 * @return the normalcyStr
	 */
	public String getNormalcyStr() {
		return normalcyStr;
	}
	/**
	 * @param normalcyStr the normalcyStr to set
	 */
	public void setNormalcyStr(String normalcyStr) {
		this.normalcyStr = normalcyStr;
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
	 * @return the eventCodeType
	 */
	public String getEventCodeType() {
		return eventCodeType;
	}
	/**
	 * @param eventCodeType the eventCodeType to set
	 */
	public void setEventCodeType(String eventCodeType) {
		this.eventCodeType = eventCodeType;
	}
	

}
