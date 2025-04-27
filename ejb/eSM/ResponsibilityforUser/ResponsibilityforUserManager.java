/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM.ResponsibilityforUser;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.*;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import java.sql.Date;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="ResponsibilityforUser"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ResponsibilityforUser"
*	local-jndi-name="ResponsibilityforUser"
*	impl-class-name="eSM.ResponsibilityforUser.ResponsibilityforUserManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSM.ResponsibilityforUser.ResponsibilityforUserManagerLocal"
*	remote-class="eSM.ResponsibilityforUser.ResponsibilityforUserManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.ResponsibilityforUser.ResponsibilityforUserManagerLocalHome"
*	remote-class="eSM.ResponsibilityforUser.ResponsibilityforUserManagerHome"
*	generate= "local,remote"
*
*
*/

public class ResponsibilityforUserManager implements SessionBean {

	Connection con ;
	PreparedStatement pstmt ;
	PreparedStatement pstmt_ora;
	PreparedStatement pstmt1 ;
	SessionContext ctx;

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
	public final String RECORD_DELETED = "RECORD_DELETED" ;

	public void ejbCreate()  {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx = context;}

	String Role="";
   String locale="";

   	/**
	 *Method to insert SM Responsibility for User
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertResponsibilityforUser(HashMap argMap )  
		{java.util.Properties p=(java.util.Properties)argMap.get("p");
		locale = p.getProperty("LOCALE");
		String    userid=(String)argMap.get("userid");
		String    respid=(String)argMap.get("respid");
		String    effectivedatefrom=(String)argMap.get("effectivedatefrom");
		String    effectivedateto=(String)argMap.get("effectivedateto");
		String	  addedAtWorkstation=(String)argMap.get("addedAtWorkstation");
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean insertable = true ;
		//int res1=0;
		StringBuffer sb = new StringBuffer( "" ) ;
		String sql = "insert into 	sm_resp_for_user(appl_user_id,resp_id,eff_date_from,eff_date_to,added_by_id,added_date,added_at_ws_no,modified_by_id, modified_date,modified_at_ws_no) values (?, ?, ?, ?, ?, sysdate, ?, ?, sysdate, ?)" ;
		String sql_grant="";
		String connection_pooling_yn="";
		try{		
				con = ConnectionManager.getConnection(p);
				connection_pooling_yn=p.getProperty( "connection_pooling_yn" ) ;
				String ora_role_password="";
				if(connection_pooling_yn.equals("Y")) 
				{				
				String sql_ora=" Select APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) from sm_ora_role where ora_role_id='MEDADMIN' ";
				pstmt_ora=con.prepareStatement(sql_ora);
				ResultSet rs_ora=pstmt_ora.executeQuery();
				if(rs_ora!=null){
					while(rs_ora.next()){
						ora_role_password=rs_ora.getString(1);
					}
					rs_ora.close();
				}else{
					sb.append("Record not Found For the Role MEDADMIN");
				}
				if(ora_role_password != "" && !ora_role_password.equals("")){
					try{
						sql_ora="Set Role MEDADMIN identified by "+ora_role_password;
						if(pstmt_ora!=null) pstmt_ora.close();
						pstmt_ora=con.prepareStatement(sql_ora);
						pstmt_ora.executeQuery();						
						pstmt_ora.close();
					}catch(Exception pswd){
						sb.append(pswd.getMessage());
					}
				 }else{
					 try{
						sql_ora="Set Role MEDADMIN";
						if(pstmt_ora!=null) pstmt_ora.close();
						pstmt_ora=con.prepareStatement(sql_ora);
						pstmt_ora.executeQuery();						
						pstmt_ora.close();
					 }catch(Exception pswd){
						sb.append(pswd.getMessage());
					}
				 }
			  }
				String sqlResp="select ora_role_id  from sm_resp  where resp_id = ? ";
				PreparedStatement pstmt_o=con.prepareStatement( sqlResp );
				pstmt_o.setString(1,respid);
				ResultSet rs1=pstmt_o.executeQuery();
				if (rs1 !=null){
					while (rs1.next()){
					Role=rs1.getString(1);
					}rs1.close();
					pstmt_o.close();
				}
			if(Role!=null)
			{	sql_grant = " Grant "+Role +" to "+userid ;
			}
			String sql3=" ALTER USER "+userid+" DEFAULT ROLE MEDSTARTUP ";
			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement( sql3 );
			pstmt.executeUpdate();
			pstmt.close();
			}
			catch( Exception e){
    		}
		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String modifiedAtWorkstation = addedAtWorkstation ;
		Date effective_date_from = null ;
		Date effective_date_to = null ;
		if ( (effectivedatefrom != null) && (!effectivedatefrom.equals("")) )
			effective_date_from = Date.valueOf( effectivedatefrom ) ;
		if ( (effectivedateto != null) && (!effectivedateto.equals("")) )
			effective_date_to = Date.valueOf( effectivedateto ) ;
		try
			{
    	String duplicateSql = "select 1 from  sm_resp_for_user where appl_user_id=? and  resp_id = ?" ;
		if(pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement( duplicateSql ) ;
		pstmt.setString( 1, userid ) ;
		pstmt.setString( 2, respid ) ;
		ResultSet rs = pstmt.executeQuery() ;
		if ( rs.next() )
		{ insertable = false ;
		  java.util.Hashtable message = MessageManager.getMessage(locale,"CODE_ALREADY_EXISTS", "Common");
		  //java.util.Hashtable message = MessageManager.getMessage( con, CODE_ALREADY_EXISTS ) ;
		  sb.append( (String) message.get("message") ) ;
		  rs.close();
		}
		}
		catch ( Exception e )
		{
			insertable = false ;
			sb.append( e+ "<br>" ) ;
			e.printStackTrace() ;
		    if (con != null)
	  	{ try
		  	 {
				ConnectionManager.returnConnection(con,p);
		     }
		   	catch (Exception ee) {}
		  }	}
		if ( insertable )
		{	try
			{   pstmt = con.prepareStatement( sql );
				pstmt.setString	( 1, userid) ;
				pstmt.setString	( 2, respid) ;
				pstmt.setDate   ( 3, effective_date_from ) ;
				pstmt.setDate   ( 4, effective_date_to ) ;
				pstmt.setString ( 5, addedById ) ;
				pstmt.setString	( 6, addedAtWorkstation ) ;
				pstmt.setString	( 7, modifiedById ) ;
				pstmt.setString	( 8,modifiedAtWorkstation) ;
				int res = pstmt.executeUpdate() ;
				pstmt1=con.prepareStatement(sql_grant);
				pstmt1.executeUpdate();
				if ( res != 0  )
				{	result = true ;
					java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
				//	java.util.Hashtable message = MessageManager.getMessage( con, RECORD_INSERTED ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit();
				}
				if(pstmt !=null) pstmt.close() ;
				if(pstmt1 !=null) pstmt1.close() ;
			}
			catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try{con.rollback();			}
				catch (Exception ce){}
			} finally {
			  if (con != null)
			  {   try {
					  try{
						}
						catch(Exception pswd)
						{
						sb.append("1"+pswd.getMessage());
						}
					  ConnectionManager.returnConnection(con,p);
		       		} catch (Exception ee) {}
		      	   }}}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
	/**
	 *Method to update SM Responsibility for User
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


public java.util.HashMap updateResponsibilityforUser(
						HashMap argMap
						)   {

		java.util.HashMap results = new java.util.HashMap() ;

		java.util.Properties p=(java.util.Properties)argMap.get("p");
		locale = p.getProperty("LOCALE");
		String    userid=(String)argMap.get("userid");
		String    respid=(String)argMap.get("respid");
		String    effectivedatefrom=(String)argMap.get("effectivedatefrom");
		String    effectivedateto=(String)argMap.get("effectivedateto");
		String	  addedAtWorkstation=(String)argMap.get("addedAtWorkstation");
		
		boolean result = false ;
		boolean updatable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;

		String sql = "update sm_resp_for_user set eff_date_from=?,eff_date_to= ?,modified_by_id=?, modified_date= sysdate,modified_at_ws_no= ? where appl_user_id = ? and resp_id = ?";


		String modifiedById = p.getProperty( "login_user" ) ;
		Date effective_date_from = null ;
		Date effective_date_to = null ;
		String modifiedAtWorkstation = addedAtWorkstation ;

		if ( (effectivedatefrom != null) && (!effectivedatefrom.equals("")) )
			effective_date_from = Date.valueOf( effectivedatefrom ) ;

		if ( (effectivedateto != null) && (!effectivedateto.equals("")) )
			effective_date_to = Date.valueOf( effectivedateto ) ;


		if ( updatable ) {
			try {
				con = ConnectionManager.getConnection(p);
				 if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement( sql );
				pstmt.setDate ( 1,effective_date_from ) ;
				pstmt.setDate ( 2,effective_date_to ) ;
				pstmt.setString	( 3, modifiedById ) ;
				pstmt.setString	( 4, modifiedAtWorkstation ) ;
				pstmt.setString ( 5,userid ) ;
				pstmt.setString ( 6,respid);

				int res = pstmt.executeUpdate() ;

				if ( res != 0 ) {
					result = true ;
               java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED", "SM");
					sb.append( (String) message.get("message") ) ;
					con.commit();
				}

				pstmt.close() ;
			} catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try{
												con.rollback();
			}catch (Exception ce){}
			}
		  finally{
			  if (con != null)
			  {
			   try {
						ConnectionManager.returnConnection(con,p);
		       	       } catch (Exception ee) {}
		      	  }
			}
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}

	/**
	 *Method to delete SM Responsibility for User
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public java.util.HashMap deleteResponsibilityforUser(
							
							HashMap argMap
						)  
	{

		java.util.Properties p=(java.util.Properties)argMap.get("p");
		locale = p.getProperty("LOCALE");
		String    userid=(String)argMap.get("respid");
		String    respid=(String)argMap.get("userid");
		java.util.HashMap results = new java.util.HashMap() ;

			boolean result = false ;


			StringBuffer sb = new StringBuffer( "" ) ;
			String connection_pooling_yn="";
//			String sql_grant="";
	try
	{
			String sql = "delete from SM_RESP_FOR_USER where appl_user_id=? and resp_id=? ";


					con = ConnectionManager.getConnection(p);
				connection_pooling_yn=p.getProperty( "connection_pooling_yn" ) ;
				String ora_role_password="";
				if(connection_pooling_yn.equals("Y")) 
				{
				
				String sql_ora=" Select APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) from sm_ora_role where ora_role_id='MEDADMIN' ";
				if(pstmt_ora!=null)	pstmt_ora.close();
				pstmt_ora=con.prepareStatement(sql_ora);
				ResultSet rs_ora=pstmt_ora.executeQuery();
				if(rs_ora!=null){
					while(rs_ora.next()){
						ora_role_password=rs_ora.getString(1);
					}
					rs_ora.close();
				}else{
					sb.append("Record not Found For the Role MEDADMIN");
				}
				if(ora_role_password != null && ora_role_password.equals("")){
					try{
						sql_ora="Set Role MEDADMIN identified by "+ora_role_password;
						if(pstmt_ora!=null)	pstmt_ora.close();
						pstmt_ora=con.prepareStatement(sql_ora);
						pstmt_ora.executeQuery();				
						pstmt_ora.close();
					}catch(Exception pswd){
						sb.append(pswd.getMessage());
					}
				}else{
					try{
						sql_ora="Set Role MEDADMIN";
						if(pstmt_ora!=null)pstmt_ora.close();
						pstmt_ora=con.prepareStatement(sql_ora);
						pstmt_ora.executeQuery();				
						pstmt_ora.close();
					}catch(Exception pswd){
					sb.append(pswd.getMessage());
				   }
				}
				}

					pstmt = con.prepareStatement( sql );
					pstmt.setString	( 1, userid ) ;
					pstmt.setString	( 2, respid) ;
					int res = pstmt.executeUpdate() ;

					if ( res != 0 ) {
					result = true ;
					    java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_DELETED", "SM");
					//java.util.Hashtable message = MessageManager.getMessage( con, RECORD_DELETED ) ;
					sb.append( (String) message.get("message") ) ;


				String sqlResp="select ora_role_id  from sm_resp  where resp_id = ? ";				
				PreparedStatement pstmt_d=con.prepareStatement( sqlResp );
				pstmt_d.setString(1,respid);
				ResultSet rs1=pstmt_d.executeQuery(sqlResp);
				if (rs1 !=null){
					while (rs1.next()){
								Role=rs1.getString(1);
								rs1.close();
								pstmt_d.close();
					}
				}
//			if(Role!=null)
//			{
//				sql_grant = " Revoke "+Role +" from "+userid ;
//			}
					
					con.commit();
					}
			
					pstmt.close() ;		
		
		}
		catch ( Exception e )
		{
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			try{
											con.rollback();
			}catch (Exception ce){}
		}
		finally
		{
		  if (con != null)
			  {
			   try {
				    try{
						if(pstmt_ora != null) pstmt_ora.close();
						}
						catch(Exception pswd)
						{
						sb.append("1"+pswd.getMessage());
						}
				 ConnectionManager.returnConnection(con,p);
		       		} catch (Exception ee) {}
		      	   }
		}

			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sb.toString() ) ;
			return results ;
		}
}
