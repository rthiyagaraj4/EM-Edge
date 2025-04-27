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
*	Filename		:	ClinicEventParamRemote.java
*	Purpose 		:	This Remote Interface for the EJB ClinicEventParam
*	Created By	:	Dheeraj Kumar M
*	Created On	:	24 July 2002
*/
package eCA.ClinicEventParam;
import java.rmi.RemoteException;
import java.util.*;
import java.util.Properties;
import javax.ejb.EJBObject;
public interface ClinicEventParamRemote extends EJBObject {
    public abstract HashMap manageClinicEventParam(Properties properties, HashMap hashtable)
        throws RemoteException;
}
