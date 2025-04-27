/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Filename		:	
*	Purpose 		:	
*	Created By		:	
*	Created On		:	21 Feb 2005
*/
package eCP.GCPGeneratePlan;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
public interface GCPGeneratePlanLocalHome extends EJBLocalHome {
    public GCPGeneratePlanLocal create() throws  CreateException;
}
