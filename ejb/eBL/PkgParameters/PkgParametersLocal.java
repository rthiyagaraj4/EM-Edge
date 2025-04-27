/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.PkgParameters;

import java.util.HashMap;
import java.util.Properties;
import javax.ejb.EJBLocalObject;

public abstract interface PkgParametersLocal extends EJBLocalObject
{
  public abstract HashMap modify(Properties paramProperties, HashMap paramHashMap);
}
