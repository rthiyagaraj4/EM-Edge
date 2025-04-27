/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//coreected on10/25/2005
package ePH.DispMedicationTPNWorkSheet ;

import java.rmi.RemoteException ;
import javax.ejb.CreateException ;

import ePH.Common.PhEJBHome ;

public interface DispMedicationTPNWorkSheetHome extends PhEJBHome {
	public DispMedicationTPNWorkSheetRemote create() throws RemoteException, CreateException ;
}
