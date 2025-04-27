/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.HealthObjects;
import java.util.* ;
import java.io.*;
public class RecentClinicalNotesResponse implements java.io.Serializable {
	private List<RecentClinicalNotesHO> lstRecentClinicalNotes;

	/**
	 * @return the lstRecentClinicalNotes
	 */
	public List<RecentClinicalNotesHO> getLstRecentClinicalNotes() {
		return lstRecentClinicalNotes;
	}

	/**
	 * @param lstRecentClinicalNotes the lstRecentClinicalNotes to set
	 */
	public void setLstRecentClinicalNotes(
			List<RecentClinicalNotesHO> lstRecentClinicalNotes) {
		this.lstRecentClinicalNotes = lstRecentClinicalNotes;
	}
}
