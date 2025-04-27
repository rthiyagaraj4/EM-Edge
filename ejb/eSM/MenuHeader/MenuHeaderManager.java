/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM.MenuHeader;
import java.rmi.*;
import javax.ejb.*;
import java.util.*;
import java.sql.*;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="MenuHeader"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="MenuHeader"
*	local-jndi-name="MenuHeader"
*	impl-class-name="eSM.MenuHeader.MenuHeaderManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSM.MenuHeader.MenuHeaderLocal"
*	remote-class="eSM.MenuHeader.MenuHeaderRemote"
*	generate= "local,remote"
*
* @ejb.home 
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.MenuHeader.MenuHeaderLocalHome"
*	remote-class="eSM.MenuHeader.MenuHeaderHome"
*	generate= "local,remote"
*
*
*/


public class MenuHeaderManager implements SessionBean {

	Connection con ;
	//Connection con1 ;
	PreparedStatement pstmt ;
	//Statement stmt ;
	SessionContext ctx;
    String locale="";
	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
	public String connection_pooling_yn="";

	public void ejbCreate()  {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx=context;
	}


/*****************************************************************************/
	/**
	 *Method to insert Menu Header
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public java.util.HashMap insertMenuHeader(
							HashMap argMap
						 ) {
		java.util.Properties p=(java.util.Properties)argMap.get("p");
		locale = p.getProperty("LOCALE");
		java.util.HashMap tabdata=(java.util.HashMap)argMap.get("tabdata");
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean insertable = true ;		
		StringBuffer sb = new StringBuffer( "" ) ;
try {
/***********************************************************************/
	con = ConnectionManager.getConnection(p);
	con.setAutoCommit(false);
	connection_pooling_yn=p.getProperty( "connection_pooling_yn" ) ;
	String ora_role_password="";
	
	if(connection_pooling_yn.equals("Y")) 
	{				
	    String sql_ora=" Select APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) from sm_ora_role where ora_role_id='MEDADMIN' ";
	    pstmt=con.prepareStatement(sql_ora);
		ResultSet rs_ora=pstmt.executeQuery();
		if(rs_ora!=null){
			 while(rs_ora.next()){
				ora_role_password=rs_ora.getString(1);
			 }
			 rs_ora.close();
	     }else{
		  sb.append("Record not Found For the Role MEDADMIN");
	     }		 
		if(ora_role_password !=null && !ora_role_password.equals("")){
			try{
				  sql_ora="Set Role MEDADMIN identified by "+ora_role_password;
				  if(pstmt!=null) pstmt.close();
				  pstmt=con.prepareStatement(sql_ora);
				  pstmt.execute();
				  pstmt.close();
			}catch(Exception pswd){
				sb.append(pswd.getMessage());
				pswd.printStackTrace();
			}
	      }else{
			try{
				  sql_ora="Set Role MEDADMIN";
				  if(pstmt!=null) pstmt.close();
				  pstmt=con.prepareStatement(sql_ora);
				  pstmt.execute();
				  pstmt.close();
			  }catch(Exception pswd){
				sb.append(pswd.getMessage());
				pswd.printStackTrace();
			  }
	      }
  }
/***********************************************************************/
//check for record already exists
/***********************************************************************/
final String duplicateSql = "select 1 from  sm_menu_hdr where menu_id = ?" ;
 if(pstmt!=null) pstmt.close();
pstmt = con.prepareStatement( duplicateSql ) ;
pstmt.setString( 1, (String)tabdata.get("menu_id") ) ;
ResultSet rs = pstmt.executeQuery() ;

if ( rs.next() ) {
	insertable = false ;
	java.util.Hashtable message = MessageManager.getMessage(locale,"CODE_ALREADY_EXISTS", "Common");
	
	sb.append( (String) message.get("message") ) ;
	rs.close();
	message.clear();
	}
} catch ( Exception e ) {
	insertable = false ;
	sb.append( e.getMessage() + "<br>" ) ;
	e.printStackTrace() ;

		}
			
/*************************************************************************/
	
	String sql = "insert into sm_menu_hdr(menu_id,menu_name,root_menu_yn,resp_group_id,adhoc_menu_yn,adhoc_menu_eff_from,adhoc_menu_eff_to, remarks,added_by_id,added_date, added_at_ws_no,modified_by_id,modified_date,modified_at_ws_no,dev_tool,sys_defined_yn) values (?, ?, ?, ?, ?, to_date(ltrim(rtrim(?)),'dd/mm/yyyy'), to_date(ltrim(rtrim(?)),'dd/mm/yyyy'), ?, ?,sysdate,?,?,sysdate,?,?,'N')" ;


if ( insertable ) {
try {
	pstmt = con.prepareStatement( sql );
	pstmt.setString	( 1, (String)tabdata.get("menu_id")) ;
	pstmt.setString	( 2, (String)tabdata.get("menu_name") ) ;
	pstmt.setString	( 3, (String)tabdata.get("root_menu_yn") ) ;
	pstmt.setString	( 4, (String)tabdata.get("resp_group_id") ) ;
	pstmt.setString	( 5, (String)tabdata.get("adhoc_menu_yn")) ;
	pstmt.setString	( 6, (String)tabdata.get("adhoc_menu_eff_from")) ;
	pstmt.setString	( 7, (String)tabdata.get("adhoc_menu_eff_to")) ;
	pstmt.setString	( 8, (String)tabdata.get("remarks")) ;
	
	pstmt.setString	( 9, (String)tabdata.get("added_by_id")) ;
	pstmt.setString	( 10,(String)tabdata.get("added_at_ws_no")) ;
	pstmt.setString ( 11,(String)tabdata.get("modified_by_id") ) ;
	pstmt.setString ( 12,(String)tabdata.get("modified_at_ws_no") ) ;
	pstmt.setString	( 13,(String)tabdata.get("dev_tool") ) ;
	int res = pstmt.executeUpdate() ;
	
	if ( res != 0  ) {
	result = true ;
	java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
	
		sb.append( (String) message.get("message") ) ;
		con.commit();
    message.clear();
				}
				else{
				con.rollback();
				}
			
			} catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try{
					con.rollback();
			}catch (Exception ce){
				ce.printStackTrace();
			}
			}
			finally	{

			  if (con != null)
			  {
			   try {
				try{
				}
				catch(Exception pswd)
				{
					sb.append(pswd.getMessage());
					pswd.printStackTrace();
				
				}
				if(pstmt !=null) pstmt.close();
				ConnectionManager.returnConnection(con,p);
		       } catch (Exception ee) {
				   ee.printStackTrace();
			   }
		      }

		}
	}
    tabdata.clear();
	argMap.clear();
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}

/****************************************************************************/
	/**
	 *Method to update Menu Header
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public java.util.HashMap updateMenuHeader(
							HashMap argMap
						 )   {

		java.util.Properties p=(java.util.Properties)argMap.get("p");
		locale = p.getProperty("LOCALE");
		java.util.HashMap tabdata=(java.util.HashMap)argMap.get("tabdata");
		
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean updatable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;

		String sql = "update sm_menu_hdr set menu_name=?,root_menu_yn=?,resp_group_id=?,adhoc_menu_yn=?,adhoc_menu_eff_from	=to_date(ltrim(rtrim(?)),'dd/mm/yyyy'), adhoc_menu_eff_to=to_date(ltrim(rtrim(?)),'dd/mm/yyyy'),remarks=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=? ,dev_tool=? where menu_id=?";



		if ( updatable ) {
			try {

			
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			connection_pooling_yn=p.getProperty( "connection_pooling_yn" ) ;
			String ora_role_password="";
			if(connection_pooling_yn.equals("Y")) 
			{				
				String sql_ora=" Select APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) from sm_ora_role where ora_role_id='MEDADMIN' ";
				if(pstmt!=null) pstmt.close();
				pstmt=con.prepareStatement(sql_ora);
				ResultSet rs_ora=pstmt.executeQuery();
				if(rs_ora!=null){
					while(rs_ora.next()){
						ora_role_password=rs_ora.getString(1);
					}
					rs_ora.close();
				}else{
					sb.append("Record not Found For the Role MEDADMIN");
				}
	
				if(ora_role_password !=null && !ora_role_password.equals("")){
					try{
						   sql_ora="Set Role MEDADMIN identified by "+ora_role_password;
							if(pstmt!=null) pstmt.close();
							pstmt=con.prepareStatement(sql_ora);
							pstmt.execute();
							pstmt.close();
					}catch(Exception pswd){
						sb.append(pswd.getMessage());
						pswd.printStackTrace();				
					}
				}else{
						try{
						   sql_ora="Set Role MEDADMIN";
							if(pstmt!=null) pstmt.close();
							pstmt=con.prepareStatement(sql_ora);
							pstmt.execute();
							pstmt.close();
					}catch(Exception pswd){
						sb.append(pswd.getMessage());
						pswd.printStackTrace();				
					}
				}


			}
			con.setAutoCommit(false);

			
			pstmt = con.prepareStatement( sql );
			pstmt.setString	( 1, (String)tabdata.get("menu_name") ) ;
			pstmt.setString	( 2, (String)tabdata.get("root_menu_yn")) ;
			pstmt.setString	( 3, (String)tabdata.get("resp_group_id")) ;
			pstmt.setString	( 4, (String)tabdata.get("adhoc_menu_yn")) ;
			pstmt.setString	( 5, (String)tabdata.get("adhoc_menu_eff_from")) ;
			pstmt.setString	( 6, (String)tabdata.get("adhoc_menu_eff_to")) ;
			pstmt.setString	( 7, (String)tabdata.get("remarks")) ;
			pstmt.setString	( 8, (String)tabdata.get("modified_by_id")) ;
			pstmt.setString	( 9, (String)tabdata.get("modified_at_ws_no") ) ;
			pstmt.setString	( 10,(String)tabdata.get("dev_tool") ) ;
			pstmt.setString	( 11,(String)tabdata.get("menu_id") ) ;
				
			int res = pstmt.executeUpdate() ;
							
				if ( res != 0 ) {
				
					result = true ;
                    java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED", "SM");
					sb.append( (String) message.get("message") ) ;
					con.commit();
				message.clear();
				}
				else
				{
					sb.append("Error in update"+sql+" "+(String)tabdata.get("modified_at_ws_no")+""+(String)tabdata.get("menu_id"));
					con.rollback();
				}

				
			} catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try{
						con.rollback();
			}catch (Exception ce){
				ce.printStackTrace();
			}
			}
			  finally {
			  if (con != null)
			  {
			   try {

				try{
				}
				catch(Exception pswd)
				{
					sb.append(pswd.getMessage());
					pswd.printStackTrace();
				
				}
				   if (pstmt != null) pstmt.close();
				   ConnectionManager.returnConnection(con,p);
		       } catch (Exception ee) {
				   ee.printStackTrace();
			   }
		      }
			}

	}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
	   argMap.clear();
	   tabdata.clear();
		return results ;
	}
}

