/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.HealthObjects;
import java.io.*;
public class NoteTypeHO implements java.io.Serializable{
	private String noteType;
	private String noteTypeDesc;
	private String dfltTranscriptionYN;
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
	}
	/**
	 * @return the dfltTranscriptionYN
	 */
	public String getDfltTranscriptionYN() {
		return dfltTranscriptionYN;
	}
	/**
	 * @param dfltTranscriptionYN the dfltTranscriptionYN to set
	 */
	public void setDfltTranscriptionYN(String dfltTranscriptionYN) {
		this.dfltTranscriptionYN = dfltTranscriptionYN;
	}
	

}
