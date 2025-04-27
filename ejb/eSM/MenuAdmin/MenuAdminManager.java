/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM.MenuAdmin;

import java.rmi.*;
import javax.ejb.*;

import java.sql.*;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="MenuAdmin"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="MenuAdmin"
*	local-jndi-name="MenuAdmin"
*	impl-class-name="eSM.MenuAdmin.MenuAdminManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSM.MenuAdmin.MenuAdminLocal"
*	remote-class="eSM.MenuAdmin.MenuAdminRemote"
*	generate= "local,remote"
*
* @ejb.home 
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.MenuAdmin.MenuAdminLocalHome"
*	remote-class="eSM.MenuAdmin.MenuAdminHome"
*	generate= "local,remote"
*
*
*/

public class MenuAdminManager implements SessionBean {

	Connection con=null;
	PreparedStatement pstmt ;
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
	 *Method to insert Menu Admin
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public java.util.HashMap insertMenuAdmin(							
							java.util.HashMap tabdata1
						 ) {
		
		java.util.Properties p=(java.util.Properties)tabdata1.get("p");
		locale = p.getProperty("LOCALE");
		java.util.HashMap tabdata=(java.util.HashMap)tabdata1.get("data");
		java.util.HashMap results = new java.util.HashMap() ;		
		boolean result = false ;
		boolean insertable = true ;		StringBuffer sb = new StringBuffer( "" ) ;
try {		
	con = ConnectionManager.getConnection(p);
try {
/***********************************************************************/

	con.setAutoCommit(false);
	connection_pooling_yn=p.getProperty( "connection_pooling_yn" ) ;

	String ora_role_password="";

	     if(connection_pooling_yn.equals("Y")){
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
				if(ora_role_password != null && !ora_role_password.equals("")){
					try{
						  sql_ora="Set Role MEDADMIN identified by "+ora_role_password;
						  if(pstmt!=null) pstmt.close();
						  pstmt=con.prepareStatement(sql_ora);
						  pstmt.execute();
						  pstmt.close();
					}catch(Exception pswd){
						sb.append(pswd.getMessage());
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
					}
				}
			}
/***********************************************************************/
//check for record already exists
/***********************************************************************/
final String duplicateSql = "select 1 from  sm_menu_admin where menu_admin_id = ?" ;
if(pstmt!=null) pstmt.close();
pstmt = con.prepareStatement( duplicateSql ) ;
pstmt.setString( 1, (String)tabdata.get("menu_admin_id") ) ;
ResultSet rs = pstmt.executeQuery() ;

if ( rs.next() ) {
	insertable = false ;
	java.util.Hashtable message = MessageManager.getMessage(locale,	"CODE_ALREADY_EXISTS", "Common");
	sb.append((String) message.get("message"));
	rs.close();
	message.clear();
	}
} catch ( Exception e ) {
	insertable = false ;
	sb.append( e.getMessage() + "<br>" ) ;
	e.printStackTrace() ;	

		}
			

/*************************************************************************/
	StringBuffer sql=new StringBuffer();
	sql.append("insert into	sm_menu_admin(menu_admin_id,resp_group_id,eff_date_from,eff_date_to,eff_status,added_by_id,added_date,added_at_ws_no, modified_by_id,modified_date,modified_at_ws_no) values (?, ?,to_date(ltrim(rtrim(?)),'dd/mm/yyyy'), to_date(ltrim(rtrim(?)),'dd/mm/yyyy'), ?, ?,sysdate,?,?,sysdate,?)");


if ( insertable ) {
try {

	
	pstmt = con.prepareStatement( sql.toString() );
	sql.setLength(0);

	pstmt.setString	( 1, (String)tabdata.get("menu_admin_id")) ;
	pstmt.setString	( 2, (String)tabdata.get("resp_group_id") ) ;
	pstmt.setString	( 3, (String)tabdata.get("eff_date_from") ) ;
	pstmt.setString	( 4, (String)tabdata.get("eff_date_to") ) ;
	pstmt.setString	( 5, (String)tabdata.get("eff_status")) ;
	pstmt.setString	( 6, (String)tabdata.get("added_by_id")) ;
	pstmt.setString	( 7, (String)tabdata.get("added_at_ws_no")) ;
	pstmt.setString	( 8, (String)tabdata.get("modified_by_id")) ;
	pstmt.setString	( 9, (String)tabdata.get("modified_at_ws_no")) ;
		
	int res = pstmt.executeUpdate() ;
	
	if ( res != 0  ) {
	result = true ;
	java.util.Hashtable message = MessageManager.getMessage(locale,	"RECORD_INSERTED", "SM");
		sb.append( (String) message.get("message") ) ;
		con.commit();
        message.clear();
				}
				else{
				con.rollback();
				}
				if(pstmt !=null) pstmt.close();
			} catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try{
					con.rollback();
			}catch (Exception ce){}
			}
			finally	{

			    try {
				try{
				}
				catch(Exception pswd)
				{
					sb.append(pswd.getMessage());
				
				}
				
				ConnectionManager.returnConnection(con,p);
		       } catch (Exception ee) {}
		      
		}
	}		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		tabdata.clear();
		tabdata1.clear();
}catch(Exception pswd)
				{
					sb.append(pswd.getMessage());
				
				}
		finally{ConnectionManager.returnConnection(con,p);}
		return results ;
	}

/****************************************************************************/
	/**
	 *Method to update Menu Admin
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public java.util.HashMap updateMenuAdmin(
							java.util.HashMap tabdata1
						 ) {

		java.util.Properties p=(java.util.Properties)tabdata1.get("p");
		locale = p.getProperty("LOCALE");
		java.util.HashMap tabdata=(java.util.HashMap)tabdata1.get("data");

		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean updatable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;

		StringBuffer sql=new StringBuffer();
		 sql.append("update sm_menu_admin set resp_group_id	=?,eff_date_from	=to_date(ltrim(rtrim(?)),'dd/mm/yyyy'), eff_date_to	=to_date(ltrim(rtrim(?)),'dd/mm/yyyy'),  eff_status	=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no	=? where menu_admin_id	=?");
         try{
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
				if(ora_role_password != null && !ora_role_password.equals("")){
					try{
						  sql_ora="Set Role MEDADMIN identified by "+ora_role_password;
						  if(pstmt!=null) pstmt.close();
						  pstmt=con.prepareStatement(sql_ora);
						  pstmt.execute();						
						  pstmt.close();
					}catch(Exception pswd){
						sb.append(pswd.getMessage());				
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
					}
				}
			}
			con.setAutoCommit(false);


			pstmt = con.prepareStatement( sql.toString() );
			pstmt.setString	( 1, (String)tabdata.get("resp_group_id") ) ;
			pstmt.setString	( 2, (String)tabdata.get("eff_date_from")) ;
			pstmt.setString	( 3, (String)tabdata.get("eff_date_to")) ;
			pstmt.setString	( 4, (String)tabdata.get("eff_status")) ;
			pstmt.setString	( 5, (String)tabdata.get("modified_by_id")) ;
			pstmt.setString	( 6, (String)tabdata.get("modified_at_ws_no") ) ;
			pstmt.setString	( 7,(String)tabdata.get("menu_admin_id") ) ;
				
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
				sql.setLength(0);
			 if (pstmt != null) pstmt.close();
				
			} catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try{
						con.rollback();
			}catch (Exception ce){}
			}
			  finally {
			    try {
				try{
				}
				catch(Exception pswd)
				{
					sb.append(pswd.getMessage());
				
				}
				  
				   ConnectionManager.returnConnection(con,p);
		       } catch (Exception ee) {}
		    
			}

	}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		tabdata.clear();
		tabdata1.clear();
		 }
		 catch(Exception pswd)
				{
					sb.append(pswd.getMessage());
				
				}
				 finally {ConnectionManager.returnConnection(con,p);}
		return results ;
	}
}

