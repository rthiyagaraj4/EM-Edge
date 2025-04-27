/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA.RecMaternityCons;
import java.rmi.RemoteException;
import java.util.*;
import java.util.ArrayList;
import java.util.Properties;
import javax.ejb.EJBObject;

public interface RecMaternityConsRemote extends EJBObject {
	    public abstract HashMap insertMaternityConsRecs(Properties properties,HashMap hashRecords,String locale,webbeans.eCA.XMLtoHTML converter,webbeans.eCA.RecClinicalNotesSectionBean matSectionBean) throws RemoteException;

		public HashMap closeMaternityEvent(Properties properties,HashMap hashRecords,String locale) throws RemoteException;
}
