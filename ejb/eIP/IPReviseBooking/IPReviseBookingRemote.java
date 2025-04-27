/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP.IPReviseBooking;

import java.rmi.* ;
import javax.ejb.* ;

public interface IPReviseBookingRemote extends EJBObject {

public java.util.HashMap insertIPReviseBooking(java.util.Properties p,java.util.HashMap hashData) throws RemoteException;
}
