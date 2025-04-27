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
public class NoteSectionResponse implements java.io.Serializable {

	private List<NoteSectionHO> lstNoteSection;

	/**
	 * @return the lstNoteSection
	 */
	public List<NoteSectionHO> getLstNoteSection() {
		return lstNoteSection;
	}

	/**
	 * @param lstNoteSection the lstNoteSection to set
	 */
	public void setLstNoteSection(List<NoteSectionHO> lstNoteSection) {
		this.lstNoteSection = lstNoteSection;
	}
	
}
