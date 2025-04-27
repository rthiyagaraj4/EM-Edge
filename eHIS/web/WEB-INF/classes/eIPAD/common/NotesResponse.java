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
package eIPAD.common;

import java.io.Serializable;

/**
 * @author GRamamoorthy
 *
 */
public class NotesResponse implements Serializable {

	/**
	 * Stores the notes value
	 */
	private String notesText = null;
	
	/**
	 * default constructor of the class
	 */
	public NotesResponse() {
	}

	/**
	 * @return the notesText
	 */
	public String getNotesText() {
		return notesText;
	}

	/**
	 * @param notesText the notesText to set
	 */
	public void setNotesText(String notesText) {
		this.notesText = notesText;
	}

}
