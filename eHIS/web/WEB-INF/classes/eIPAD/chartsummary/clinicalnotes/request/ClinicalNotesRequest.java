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
package eIPAD.chartsummary.clinicalnotes.request;
import eIPAD.chartsummary.common.request.*;
/**
 * @author GaneshkumarC 
 *
 */
public class ClinicalNotesRequest extends GenericRequest {
	private int pageNo;
	private int numberOfRecords;
	private int startIndex;
	private int endIndex;
	private String groupBy;
	private String filterBy;
	private String noteType;
	private String serviceCode;
	private String viewType;
	
	private String finalStartDate;
	private String finalEndDate;
	private String viewPage;
	private String encounterID;
	/**
	 * @return the encounterID
	 */
	public String getEncounterID() {
		return encounterID;
	}
	/**
	 * @param encounterID the encounterID to set
	 */
	public void setEncounterID(String encounterID) {
		this.encounterID = encounterID;
	}
	/**
	 * @return the viewPage
	 */
	public String getViewPage() {
		return viewPage;
	}
	/**
	 * @param viewPage the viewPage to set
	 */
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
	/**
	 * @return the finalStartDate
	 */
	public String getFinalStartDate() {
		return finalStartDate;
	}
	/**
	 * @param finalStartDate the finalStartDate to set
	 */
	public void setFinalStartDate(String finalStartDate) {
		this.finalStartDate = finalStartDate;
	}
	/**
	 * @return the finalEndDate
	 */
	public String getFinalEndDate() {
		return finalEndDate;
	}
	/**
	 * @param finalEndDate the finalEndDate to set
	 */
	public void setFinalEndDate(String finalEndDate) {
		this.finalEndDate = finalEndDate;
	}
	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}
	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	/**
	 * @return the numberOfRecords
	 */
	public int getNumberOfRecords() {
		return numberOfRecords;
	}
	/**
	 * @param numberOfRecords the numberOfRecords to set
	 */
	public void setNumberOfRecords(int numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}
	/**
	 * @return the startIndex
	 */
	public int getStartIndex() {
		return startIndex;
	}
	/**
	 * @param startIndex the startIndex to set
	 */
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	/**
	 * @return the endIndex
	 */
	public int getEndIndex() {
		return endIndex;
	}
	/**
	 * @param endIndex the endIndex to set
	 */
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	/**
	 * @return the groupBy
	 */
	public String getGroupBy() {
		return groupBy;
	}
	/**
	 * @param groupBy the groupBy to set
	 */
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}
	/**
	 * @return the filterBy
	 */
	public String getFilterBy() {
		return filterBy;
	}
	/**
	 * @param filterBy the filterBy to set
	 */
	public void setFilterBy(String filterBy) {
		this.filterBy = filterBy;
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
	 * @return the viewType
	 */
	public String getViewType() {
		return viewType;
	}
	/**
	 * @param viewType the viewType to set
	 */
	public void setViewType(String viewType) {
		this.viewType = viewType;
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
}
