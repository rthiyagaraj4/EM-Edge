/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA.SignNotes;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;

public interface SignNotesLocal extends EJBLocalObject {

public java.util.HashMap insertSignNotes(
							java.util.Properties p,
							java.util.HashMap htSignNotesProp
							);

}

