/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM.Responsibility ;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="Responsibility"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="Responsibility"
*	local-jndi-name="Responsibility"
*	impl-class-name="eSM.Responsibility.ResponsibilityManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eSM.Responsibility.ResponsibilityLocal"
*	remote-class="eSM.Responsibility.ResponsibilityRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.Responsibility.ResponsibilityLocalHome"
*	remote-class="eSM.Responsibility.ResponsibilityHome"
*	generate= "local,remote"
*
*
*/


public class ResponsibilityManager implements SessionBean {

	Connection con ;
	PreparedStatement pstmt ;
	String locale="";
	SessionContext ctx;
	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
	public String connection_pooling_yn="";
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx=context;
	}

/***************************************************************************/
	/**
	 *Method to insert SM Responsibility
	 *@param hashaMap Record data
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public java.util.HashMap insertSMResponsibility(
							java.util.HashMap argMap

						 ) {
		java.util.Properties p=(java.util.Properties)argMap.get("p");
		locale = p.getProperty("LOCALE");
		java.util.HashMap tabdata=(java.util.HashMap)argMap.get("tabdata");

		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean insertable = true ;		StringBuffer sb = new StringBuffer( "" ) ;

	try {

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


			final String duplicateSql = "select 1 from  sm_resp where resp_id = ?" ;
			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement( duplicateSql ) ;
			pstmt.setString( 1, (String)tabdata.get("resp_id")) ;


			ResultSet rs = pstmt.executeQuery() ;

			if ( rs.next() ) {

				insertable = false ;

				java.util.Hashtable message = MessageManager.getMessage( locale,"CODE_ALREADY_EXISTS", "Common") ;
				sb.append( (String) message.get("message") ) ;
				rs.close();
				message.clear();
			}
		} catch ( Exception e ) {
			insertable = false ;
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;

		}

		String sql = "insert into sm_resp(resp_id,resp_name,menu_id,desktop_code,resp_group_id,ora_role_id,remarks,eff_date_from, eff_date_to,eff_status,added_by_id,added_date,added_at_ws_no,modified_by_id,modified_date,modified_at_ws_no,sys_defined_yn) values (?, ?, ?,?,?,?,?,  to_date(ltrim(rtrim(?)),'dd/mm/yyyy'), to_date(ltrim(rtrim(?)),'dd/mm/yyyy'), ?, ?,sysdate, ?,?,sysdate,?,'N')" ;


		if ( insertable ) {
			try {
				pstmt = con.prepareStatement( sql );
				pstmt.setString	( 1, (String)tabdata.get("resp_id") ) ;
				pstmt.setString	( 2, (String)tabdata.get("resp_name") ) ;
				pstmt.setString	( 3, (String)tabdata.get("menu_id") ) ;
				pstmt.setString	( 4, (String)tabdata.get("desktop_code") ) ;
				pstmt.setString	( 5, (String)tabdata.get("resp_group_id")) ;
				pstmt.setString	( 6, (String)tabdata.get("ora_role_id")) ;
				pstmt.setString	( 7, (String)tabdata.get("remarks")) ;
				pstmt.setString	( 8, (String)tabdata.get("eff_date_from")) ;
				pstmt.setString	( 9, (String)tabdata.get("eff_date_to")) ;
				pstmt.setString	( 10, (String)tabdata.get("eff_status")) ;
				pstmt.setString ( 11,(String)tabdata.get("added_by_id") ) ;
				pstmt.setString ( 12,(String)tabdata.get("added_at_ws_no") ) ;
				pstmt.setString	( 13,(String)tabdata.get("modified_by_id") ) ;
				pstmt.setString	( 14,(String)tabdata.get("modified_at_ws_no") ) ;

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
			if(pstmt !=null) pstmt.close();
			} catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try{
					con.rollback();
			}catch (Exception ce){}
			}
			finally	{

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
		argMap.clear();
		tabdata.clear();
		return results ;
	}


/**************************************************************************/
	/**
	 *Method to update SM Responsibility
	 *@param hashaMap Record data
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


public java.util.HashMap updateSMResponsibility(
							java.util.HashMap argMap

						 ) {
		java.util.Properties p=(java.util.Properties)argMap.get("p");
		locale = p.getProperty("LOCALE");
		java.util.HashMap tabdata=(java.util.HashMap)argMap.get("tabdata");

		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		boolean updatable = true ;
		StringBuffer sb = new StringBuffer( "" ) ;



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

String sql = "update sm_resp set resp_name= ?, menu_id= ?,desktop_code= ?,resp_group_id= ?, ora_role_id= ?,remarks= ?,eff_date_from= to_date(ltrim(rtrim(?)),'dd/mm/yyyy'),eff_date_to= to_date(ltrim(rtrim(?)),'dd/mm/yyyy'),eff_status=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?where resp_id= ?";

	pstmt = con.prepareStatement( sql );
	pstmt.setString	( 1, (String)tabdata.get("resp_name") ) ;
	pstmt.setString	( 2, (String)tabdata.get("menu_id") ) ;
	pstmt.setString	( 3, (String)tabdata.get("desktop_code") ) ;
	pstmt.setString	( 4, (String)tabdata.get("resp_group_id")) ;
	pstmt.setString	( 5, (String)tabdata.get("ora_role_id")) ;
	pstmt.setString	( 6, (String)tabdata.get("remarks")) ;
	pstmt.setString	( 7, (String)tabdata.get("eff_date_from")) ;
	pstmt.setString	( 8, (String)tabdata.get("eff_date_to")) ;
	pstmt.setString	( 9, (String)tabdata.get("eff_status")) ;
	pstmt.setString	( 10, (String)tabdata.get("modified_by_id") ) ;
	pstmt.setString	( 11, (String)tabdata.get("modified_at_ws_no") ) ;
	pstmt.setString	( 12, (String)tabdata.get("resp_id") ) ;

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
					sb.append("Error in update"+sql+" "+(String)tabdata.get("modified_at_ws_no")+""+(String)tabdata.get("resp_id"));
					con.rollback();
				}
			if (pstmt != null) pstmt.close();

			} catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try{
						con.rollback();
			}catch (Exception ce){}
			}
			  finally {
			  if (con != null)
			  {

				try{

					ConnectionManager.returnConnection(con,p);

				}
				catch(Exception pswd)
				{
					sb.append(pswd.getMessage());

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

