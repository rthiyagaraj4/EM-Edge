/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
package eCP.PositionForIntervention;

import java.util.HashMap;
import java.util.Properties;
import javax.ejb.EJBLocalObject;

public interface PositionForInterventionLocal
    extends EJBLocalObject
{
    public abstract HashMap SpecialityAddModify(Properties properties, HashMap hashtable);
}
