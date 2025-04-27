/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.PkgCardSubscription;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.ejb.EJBLocalObject;
import javax.ejb.* ;


public interface PkgCardSubscriptionLocal extends EJBLocalObject
{
    public java.util.HashMap insertCardSubscription(java.util.HashMap tabdata,java.util.Properties p);
    public java.util.HashMap insert(java.util.Properties p,java.util.HashMap tabdata);
    public boolean modify(Connection connection,java.util.HashMap tabdata);

   
}
