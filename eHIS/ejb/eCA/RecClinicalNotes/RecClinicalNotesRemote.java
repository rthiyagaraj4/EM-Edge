/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/06/2018	IN67872			Dinesh T		05/06/2018	Ramesh G		GHL-CRF-0497.1	
18/03/2020	IN071264		Nijitha S									GHL-CRF-0604
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA.RecClinicalNotes;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Properties;
import javax.ejb.EJBObject;
import webbeans.eCA.RecClinicalNotesSectionBean;
import webbeans.eCA.XMLtoHTML;

public abstract interface RecClinicalNotesRemote extends EJBObject
{
  public abstract HashMap recordRecClinicalNotes(Properties paramProperties, HashMap paramHashMap, RecClinicalNotesSectionBean paramRecClinicalNotesSectionBean, XMLtoHTML paramXMLtoHTML, String paramString)
    throws RemoteException;

  public abstract HashMap signRecClinicalNotes(Properties paramProperties, HashMap paramHashMap, RecClinicalNotesSectionBean paramRecClinicalNotesSectionBean, XMLtoHTML paramXMLtoHTML)
    throws RemoteException;

  public abstract HashMap forwardRecClinicalNotes(Properties paramProperties, HashMap paramHashMap)
    throws RemoteException;

  public abstract HashMap reviewRecClinicalNotes(Properties paramProperties, HashMap paramHashMap)
    throws RemoteException;

  public abstract HashMap modifyRecClinicalNotes(Properties paramProperties, HashMap paramHashMap, RecClinicalNotesSectionBean paramRecClinicalNotesSectionBean, XMLtoHTML paramXMLtoHTML)
    throws RemoteException;

  public abstract HashMap deleteRecClinicalNotes(Properties paramProperties, HashMap paramHashMap)
    throws RemoteException;

  public abstract HashMap errorRecClinicalNotes(Properties paramProperties, HashMap paramHashMap)
    throws RemoteException;
  
  public abstract HashMap rejectRecClinicalNotes(Properties paramProperties, HashMap paramHashMap)
		    throws RemoteException;//IN67872
  
  public abstract HashMap recordRecClinicalNotesAutosave(Properties paramProperties, HashMap paramHashMap, RecClinicalNotesSectionBean paramRecClinicalNotesSectionBean, XMLtoHTML paramXMLtoHTML, String paramString)throws RemoteException ;//IN071264
}
