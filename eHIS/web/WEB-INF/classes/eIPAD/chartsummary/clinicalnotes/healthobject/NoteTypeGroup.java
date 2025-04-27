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
package eIPAD.chartsummary.clinicalnotes.healthobject;
import java.util.*;
/**
 * @author GaneshkumarC 
 *
 */
public class NoteTypeGroup extends ClinicalNoteGroup {
	private String noteType;
	private String noteTypeDesc;
	private String eventClass;
	private String serviceCode;
	private String performedBy;
	private String status;
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

	private List<DateDetails> listDateDetails;
    private List<DateDetailsTimeRange> listDateDetailsTimeRange;
   
    /**
	 * @return the listDateDetailsTimeRange
	 */
	public List<DateDetailsTimeRange> getListDateDetailsTimeRange() {
		return listDateDetailsTimeRange;
	}

	/**
	 * @param listDateDetailsTimeRange the listDateDetailsTimeRange to set
	 */
	public void setListDateDetailsTimeRange(
			List<DateDetailsTimeRange> listDateDetailsTimeRange) {
		this.listDateDetailsTimeRange = listDateDetailsTimeRange;
	}

	private GroupByData  oGroupByData; 
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
		if(oGroupByData == null)
		{
			oGroupByData = new GroupByData ();
		}
		oGroupByData.setGroupByValue(noteType);
		
		
	}
	public GroupByData getGroupDescription()
	{
		//NotesData oNotesData = new NotesData();
	//	oNotesData.setGroupByField(this.getNoteType());
		
		return oGroupByData;
				
	}
	/**
	 * @Override
	 * Implementing equals because this object will be added to a map in the dao
	 */
	public boolean equals(Object obj) {
		if(obj != null)
		{
			NoteTypeGroup oNoteTypeGroup = (NoteTypeGroup)obj;
			String thisNoteStr = this.getNoteType();
			String noteStr = oNoteTypeGroup.getNoteType();
			if(thisNoteStr != null && thisNoteStr.equals(noteStr))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	public int hashCode() {
		return this.getNoteType().hashCode();
	}

	/**
	 * @return the listNoteDetails
	 */
	public List<NoteDetails> getListNoteDetails() {
		
		List<NoteDetails> listNoteDetails = new ArrayList<NoteDetails>();
		int nListSize = 0;
		int nLoopCount = 0;
		if(this.getListDateDetails() != null && this.getListDateDetails().size() > 0)
		{
			nListSize = this.getListDateDetails().size();
		}
		if(nListSize > 0)
		{
			//listNoteDetails.add(this.getListDateDetails().get(nLoopCount));
			for(;nLoopCount < nListSize; nLoopCount++)
			{
				listNoteDetails.add(this.getListDateDetails().get(nLoopCount));
			}
		}
		return listNoteDetails ;
	}

	/**
	 * @param listDateDetails the listDateDetails to set
	 */
	public void setListDateDetails(List<DateDetails> listDateDetails) {
		this.listDateDetails = listDateDetails;
	}

	/**
	 * @return the listDateDetails
	 */
	public List<DateDetails> getListDateDetails() {
		return listDateDetails;
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
		if(oGroupByData == null)
		{
			oGroupByData = new GroupByData ();
		}
		oGroupByData.setGroupByDesc(noteTypeDesc);
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
		if(oGroupByData == null)
		{
			oGroupByData = new GroupByData ();
		}
		oGroupByData.setEventClass(eventClass);
		
	}

	/**
	 * @return the servCode
	 */
	public String getServiceCode() {
		return serviceCode;
	}

	/**
	 * @param servCode the servCode to set
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
		
		if(oGroupByData == null)
		{
			oGroupByData = new GroupByData ();
		}
		oGroupByData.setServiceCode(serviceCode);
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
		if(oGroupByData == null)
		{
			oGroupByData = new GroupByData ();
		}
		oGroupByData.setPerformedBy(performedBy);
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
		if(oGroupByData == null)
		{
			oGroupByData = new GroupByData ();
		}
		oGroupByData.setStatus(status);
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
		if(oGroupByData == null)
		{
			oGroupByData = new GroupByData ();
		}
		oGroupByData.setPrimarySpec(primarySpec);
	}

	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNoteGroup#getListNoteDetailsTimeRange()
	 */
	@Override
	public List<NoteDetailsTimeRange> getListNoteDetailsTimeRange() {
		// TODO Auto-generated method stub
		List<NoteDetailsTimeRange> listNoteDetailsTimeRange = new ArrayList<NoteDetailsTimeRange>();
		int nListSize = 0;
		int nLoopCount = 0;
		if(this.getListDateDetailsTimeRange() != null && this.getListDateDetailsTimeRange().size() > 0)
		{
			nListSize = this.getListDateDetailsTimeRange().size();
		}
		if(nListSize > 0)
		{
			//listNoteDetails.add(this.getListDateDetails().get(nLoopCount));
			for(;nLoopCount < nListSize; nLoopCount++)
			{
				listNoteDetailsTimeRange.add(this.getListDateDetailsTimeRange().get(nLoopCount));
			}
		}
		return listNoteDetailsTimeRange ;
	}

}
