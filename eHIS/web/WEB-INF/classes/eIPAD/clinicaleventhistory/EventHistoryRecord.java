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
package eIPAD.clinicaleventhistory;

import java.io.Serializable;

/**
 * @author GRamamoorthy 
 *
 */
public class EventHistoryRecord implements Serializable {
	
	private int quick_text_count = 0;
	
	private String histdatatype = null;
	
	private String histrectype = null;
	
	private String accessionnum = null;
	
	private String enctr_id = null;
	
	private String eventdatetime = null;
	
	private String sortEventDateTime = null;
	
	private String histtypedesc = null;
	
	private String eventclassdesc = null;
	
	private String eventgroupdesc = null;
	
	private String eventdesc = null;
	
	private String resultstr = null;
	
	private String normalcy_str = null;
	
	private String encline = null;
	
	private String extimageapplid = null;
	
	private String performed_by = null;
	
	private String contr_sys_id = null;
	
	private String contr_sys_event_code = null;
	
	private String normalrangeLow = null;
	
	private String normalrangeHigh = null;
	
	private String color_cell_indicator = null;
	
	private String symbol_legend_ind = null;
	
	private String descCellInd = null;
	
	private String normalcy_ind = null;
	
	private String criticalrangeLow = null;
	
	private String criticalrangeHigh = null;
	
	private String strStatus = null;
	
	private String delta_fail_id_ind = null;
	
	private String resultNum = null;
	
	private String resultNumPrefix = null;
	
	private String result_uom = null;
	
	
	private int historyRecordCount = 0;
	
	/**
	 * 
	 */
	public EventHistoryRecord() {
	}

	
	/**
	 * @return the quick_text_count
	 */
	public int getQuick_text_count() {
		return quick_text_count;
	}

	/**
	 * @param quick_text_count the quick_text_count to set
	 */
	public void setQuick_text_count(int quick_text_count) {
		this.quick_text_count = quick_text_count;
	}

	/**
	 * @return the histdatatype
	 */
	public String getHistdatatype() {
		return histdatatype;
	}

	/**
	 * @param histdatatype the histdatatype to set
	 */
	public void setHistdatatype(String histdatatype) {
		this.histdatatype = histdatatype;
	}

	/**
	 * @return the histrectype
	 */
	public String getHistrectype() {
		return histrectype;
	}

	/**
	 * @param histrectype the histrectype to set
	 */
	public void setHistrectype(String histrectype) {
		this.histrectype = histrectype;
	}

	/**
	 * @return the enctr_id
	 */
	public String getEnctr_id() {
		return enctr_id;
	}

	/**
	 * @param enctr_id the enctr_id to set
	 */
	public void setEnctr_id(String enctr_id) {
		this.enctr_id = enctr_id;
	}

	/**
	 * @return the eventdatetime
	 */
	public String getEventdatetime() {
		return eventdatetime;
	}

	/**
	 * @param eventdatetime the eventdatetime to set
	 */
	public void setEventdatetime(String eventdatetime) {
		this.eventdatetime = eventdatetime;
	}

	/**
	 * @return the sortEventDateTime
	 */
	public String getSortEventDateTime() {
		return sortEventDateTime;
	}

	/**
	 * @param sortEventDateTime the sortEventDateTime to set
	 */
	public void setSortEventDateTime(String sortEventDateTime) {
		this.sortEventDateTime = sortEventDateTime;
	}

	/**
	 * @return the histtypedesc
	 */
	public String getHisttypedesc() {
		return histtypedesc;
	}

	/**
	 * @param histtypedesc the histtypedesc to set
	 */
	public void setHisttypedesc(String histtypedesc) {
		this.histtypedesc = histtypedesc;
	}

	/**
	 * @return the eventclassdesc
	 */
	public String getEventclassdesc() {
		return eventclassdesc;
	}

	/**
	 * @param eventclassdesc the eventclassdesc to set
	 */
	public void setEventclassdesc(String eventclassdesc) {
		this.eventclassdesc = eventclassdesc;
	}

	/**
	 * @return the eventgroupdesc
	 */
	public String getEventgroupdesc() {
		return eventgroupdesc;
	}

	/**
	 * @param eventgroupdesc the eventgroupdesc to set
	 */
	public void setEventgroupdesc(String eventgroupdesc) {
		this.eventgroupdesc = eventgroupdesc;
	}

	/**
	 * @return the eventdesc
	 */
	public String getEventdesc() {
		return eventdesc;
	}

	/**
	 * @param eventdesc the eventdesc to set
	 */
	public void setEventdesc(String eventdesc) {
		this.eventdesc = eventdesc;
	}

	/**
	 * @return the resultstr
	 */
	public String getResultstr() {
		return resultstr;
	}

	/**
	 * @param resultstr the resultstr to set
	 */
	public void setResultstr(String resultstr) {
		this.resultstr = resultstr;
	}

	/**
	 * @return the normalcy_str
	 */
	public String getNormalcy_str() {
		return normalcy_str;
	}

	/**
	 * @param normalcy_str the normalcy_str to set
	 */
	public void setNormalcy_str(String normalcy_str) {
		this.normalcy_str = normalcy_str;
	}

	/**
	 * @return the extimageapplid
	 */
	public String getExtimageapplid() {
		return extimageapplid;
	}

	/**
	 * @param extimageapplid the extimageapplid to set
	 */
	public void setExtimageapplid(String extimageapplid) {
		this.extimageapplid = extimageapplid;
	}

	/**
	 * @return the performed_by
	 */
	public String getPerformed_by() {
		return performed_by;
	}

	/**
	 * @param performed_by the performed_by to set
	 */
	public void setPerformed_by(String performed_by) {
		this.performed_by = performed_by;
	}

	/**
	 * @return the normalrangeLow
	 */
	public String getNormalrangeLow() {
		return normalrangeLow;
	}

	/**
	 * @param normalrangeLow the normalrangeLow to set
	 */
	public void setNormalrangeLow(String normalrangeLow) {
		this.normalrangeLow = normalrangeLow;
	}

	/**
	 * @return the normalrangeHigh
	 */
	public String getNormalrangeHigh() {
		return normalrangeHigh;
	}

	/**
	 * @param normalrangeHigh the normalrangeHigh to set
	 */
	public void setNormalrangeHigh(String normalrangeHigh) {
		this.normalrangeHigh = normalrangeHigh;
	}

	/**
	 * @return the symbol_legend_ind
	 */
	public String getSymbol_legend_ind() {
		return symbol_legend_ind;
	}

	/**
	 * @param symbol_legend_ind the symbol_legend_ind to set
	 */
	public void setSymbol_legend_ind(String symbol_legend_ind) {
		this.symbol_legend_ind = symbol_legend_ind;
	}

	/**
	 * @return the normalcy_ind
	 */
	public String getNormalcy_ind() {
		return normalcy_ind;
	}

	/**
	 * @param normalcy_ind the normalcy_ind to set
	 */
	public void setNormalcy_ind(String normalcy_ind) {
		this.normalcy_ind = normalcy_ind;
	}

	/**
	 * @return the strStatus
	 */
	public String getStrStatus() {
		return strStatus;
	}

	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
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
	 * @return the encline
	 */
	public String getEncline() {
		return encline;
	}

	/**
	 * @param encline the encline to set
	 */
	public void setEncline(String encline) {
		this.encline = encline;
	}

	/**
	 * @return the contr_sys_id
	 */
	public String getContr_sys_id() {
		return contr_sys_id;
	}

	/**
	 * @param contr_sys_id the contr_sys_id to set
	 */
	public void setContr_sys_id(String contr_sys_id) {
		this.contr_sys_id = contr_sys_id;
	}

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
	 * @return the color_cell_indicator
	 */
	public String getColor_cell_indicator() {
		return color_cell_indicator;
	}

	/**
	 * @param color_cell_indicator the color_cell_indicator to set
	 */
	public void setColor_cell_indicator(String color_cell_indicator) {
		this.color_cell_indicator = color_cell_indicator;
	}

	/**
	 * @return the descCellInd
	 */
	public String getDescCellInd() {
		return descCellInd;
	}

	/**
	 * @param descCellInd the descCellInd to set
	 */
	public void setDescCellInd(String descCellInd) {
		this.descCellInd = descCellInd;
	}

	/**
	 * @return the criticalrangeLow
	 */
	public String getCriticalrangeLow() {
		return criticalrangeLow;
	}

	/**
	 * @param criticalrangeLow the criticalrangeLow to set
	 */
	public void setCriticalrangeLow(String criticalrangeLow) {
		this.criticalrangeLow = criticalrangeLow;
	}

	/**
	 * @return the criticalrangeHigh
	 */
	public String getCriticalrangeHigh() {
		return criticalrangeHigh;
	}

	/**
	 * @param criticalrangeHigh the criticalrangeHigh to set
	 */
	public void setCriticalrangeHigh(String criticalrangeHigh) {
		this.criticalrangeHigh = criticalrangeHigh;
	}

	/**
	 * @return the delta_fail_id_ind
	 */
	public String getDelta_fail_id_ind() {
		return delta_fail_id_ind;
	}

	/**
	 * @param delta_fail_id_ind the delta_fail_id_ind to set
	 */
	public void setDelta_fail_id_ind(String delta_fail_id_ind) {
		this.delta_fail_id_ind = delta_fail_id_ind;
	}


	/**
	 * @return the historyRecordCount
	 */
	public int getHistoryRecordCount() {
		return historyRecordCount;
	}


	/**
	 * @param historyRecordCount the historyRecordCount to set
	 */
	public void setHistoryRecordCount(int historyRecordCount) {
		this.historyRecordCount = historyRecordCount;
	}

}
