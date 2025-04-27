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
public class NoteTypeResponse implements java.io.Serializable {
	private List<NoteTypeHO> lstNoteType;

	/**
	 * @return the lstNoteType
	 */
	public List<NoteTypeHO> getLstNoteType() {
		return lstNoteType;
	}

	/**
	 * @param lstNoteType the lstNoteType to set
	 */
	public void setLstNoteType(List<NoteTypeHO> lstNoteType) {
		this.lstNoteType = lstNoteType;
	}
	

}
