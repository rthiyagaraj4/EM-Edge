/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
package eCP.EvaluateCarePlanMarkError;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface EvaluateCarePlanMarkErrorLocalHome extends EJBLocalHome
{
	public EvaluateCarePlanMarkErrorLocal create() throws CreateException;
}
