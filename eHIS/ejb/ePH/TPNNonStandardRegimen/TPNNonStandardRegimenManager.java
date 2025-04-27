/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//saved on 08/11/2005
package ePH.TPNNonStandardRegimen ;

import java.rmi.* ;
import java.util.HashMap ;
//import java.util.ArrayList;
//import java.util.Properties;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;
/**
*
* @ejb.bean
*	name="TPNNonStandardRegimen"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TPNNonStandardRegimen"
*	local-jndi-name="TPNNonStandardRegimen"
*	impl-class-name="ePH.TPNNonStandardRegimen.TPNNonStandardRegimenManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.TPNNonStandardRegimen.TPNNonStandardRegimenLocal"
*	remote-class="ePH.TPNNonStandardRegimen.TPNNonStandardRegimenRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.TPNNonStandardRegimen.TPNNonStandardRegimenLocalHome"
*	remote-class="ePH.TPNNonStandardRegimen.TPNNonStandardRegimenHome"
*	generate= "local,remote"
*
*
*/
public class TPNNonStandardRegimenManager extends PhEJBSessionAdapter {
	
//	Properties prop=null;

	
	// insert method starts here

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		
			return new HashMap() ;
	}
// insert method ends here

//  modify method starts here

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify( HashMap tabData, HashMap sqlMap )  {
			
				return new HashMap() ;
	}

				  
	/* Function specific methods end */

	
	

	// delete method starts here
public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		return map;
	}
	// delete method ends here
}
