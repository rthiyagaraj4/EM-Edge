/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Filename		:	ClinicEventParamHome.java
*	Purpose 		:	This Home Interface for the EJB ClinicEventParam
*	Created By		:	Dheeraj Kumar M
*	Created On		:	24 July 2002
*/
package eCA.ClinicEventParam;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;
public interface ClinicEventParamHome extends EJBHome {
    public ClinicEventParamRemote create() throws RemoteException, CreateException;
}
