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
*	Filename		:	ClinicEventParamLocal.java
*	Purpose 		:	This Local Interface for the EJB ClinicEventParam
*	Created By	:	Jupitora
*	Created On	:	18/2/2005
*/
package eCA.ClinicEventParam;

import java.util.*;
import java.util.Properties;
import javax.ejb.EJBLocalObject;
public interface ClinicEventParamLocal extends EJBLocalObject {
    public abstract HashMap manageClinicEventParam(Properties properties, HashMap hashtable);
       
}
