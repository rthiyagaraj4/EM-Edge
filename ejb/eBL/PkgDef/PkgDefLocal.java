/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.PkgDef;

import javax.ejb.* ;
import java.sql.* ;

public interface PkgDefLocal extends EJBLocalObject
{
    public java.util.HashMap insert(java.util.Properties p,java.util.HashMap tabdata);
    public java.util.HashMap modify(java.util.Properties p,java.util.HashMap tabdata);
}
