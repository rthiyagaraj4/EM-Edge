/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM.PatTypeClass;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

import java.util.Properties;

/**
*
* @ejb.bean
*	name="PatTypeClass"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PatTypeClass"
*	local-jndi-name="PatTypeClass"
*	impl-class-name="eAM.PatTypeClass.PatTypeClassManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eAM.PatTypeClass.PatTypeClassManagerLocal"
*	remote-class="eAM.PatTypeClass.PatTypeClassManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eAM.PatTypeClass.PatTypeClassManagerLocalHome"
*	remote-class="eAM.PatTypeClass.PatTypeClassManagerHome"
*	generate= "local,remote"
*
*
*/
public class PatTypeClassManager implements SessionBean {

	Connection con ;
	PreparedStatement pstmt ;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	 //public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	//public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context)
	{
		context=context;//for avoiding PMD violation
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertPatTypeClass(java.util.HashMap hashmap)
	{
		java.util.Properties p				=(Properties)hashmap.get("p");
		String 		patienttype				=(String)hashmap.get("patienttype");
		String 		selectedpatientclass[]	=(String[])hashmap.get("selectedpatientclass");
		String		addedFacilityId			=(String)hashmap.get("facilityId");
		String		addedAtWorkstation		=(String)hashmap.get("client_ip_address");
		String locale="";
			locale= p.getProperty("LOCALE");
		java.util.HashMap results = new java.util.HashMap() ;

		boolean result = false;
		boolean insertable = true;

		StringBuffer sb = new StringBuffer( "" ) ;

		String sql = "insert into am_patient_type_class values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;

		String addedById = p.getProperty( "login_user" );
		String addedDate = dateFormat.format( new java.util.Date() );
		String modifiedById = addedById;
		String modifiedDate = addedDate;
		String modifiedFacilityId = addedFacilityId ;
		String modifiedAtWorkstation = addedAtWorkstation ;

		Date added_date = Date.valueOf( addedDate ) ;
		Date modified_date = Date.valueOf( modifiedDate ) ;

		int res=0;
		int i=0;

		hashmap.clear();
		try
		{

			  con=ConnectionManager.getConnection(p);

			con.setAutoCommit(false);
			final String deleteSQL = "delete from am_patient_type_class where patient_type='"+patienttype+"'";
			pstmt = con.prepareStatement(deleteSQL);
			 pstmt.executeUpdate();
			if(pstmt!=null) pstmt.close();
			if (selectedpatientclass[0].equals("novalue"))
			   insertable=false;
			else
			  insertable=true;
			if (insertable)
			{
				while (i  < selectedpatientclass.length)
				{
					pstmt = con.prepareStatement(sql);
					pstmt.setString	( 1, patienttype) ;
					pstmt.setString	( 2, selectedpatientclass[i]) ;
					pstmt.setString	( 3, "Y") ;
					pstmt.setString	( 4, addedById) ;
					pstmt.setDate	( 5, added_date) ;
					pstmt.setString	( 6, addedAtWorkstation) ;
					pstmt.setString	( 7, addedFacilityId) ;
					pstmt.setString	( 8, modifiedById) ;
					pstmt.setDate	( 9, modified_date) ;
					pstmt.setString	( 10,modifiedAtWorkstation);
					pstmt.setString	( 11,modifiedFacilityId) ;
					res = pstmt.executeUpdate();
					i++;
					pstmt.close() ;
				}

			}

			if ( res != 0 )
			{
				result = true ;
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED ,"SM") ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
			}

		}

		catch ( Exception e )
		{
			try{
					con.rollback();
			   }catch(Exception ce){}
			sb.append( e.toString() + "<br>" ) ;
			e.printStackTrace() ;
		}
		finally
		{
		  if (con != null)
		  {
		   ConnectionManager.returnConnection(con,p);
		  }
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}

}
