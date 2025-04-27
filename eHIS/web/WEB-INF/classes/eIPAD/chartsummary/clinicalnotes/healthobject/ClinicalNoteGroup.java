/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * This class has to be extended if the clinical notes data has to be grouped.
 * Here, the class NoteTypegroup extends this class to group the clinical notes data by NoteType. 
 */
package eIPAD.chartsummary.clinicalnotes.healthobject;
import java.util.*;


/**
 * @author GaneshkumarC
 *
 */
public abstract class ClinicalNoteGroup {
	public abstract GroupByData getGroupDescription();
	public abstract List<NoteDetails> getListNoteDetails();
	public abstract List<NoteDetailsTimeRange> getListNoteDetailsTimeRange();
	private int childCount;
	/**
	 * @return the childCount
	 */
	public int getChildCount() {
		return childCount;
	}
	/**
	 * @param childCount the childCount to set
	 */
	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
}
