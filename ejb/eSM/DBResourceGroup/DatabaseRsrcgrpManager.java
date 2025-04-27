/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM.DBResourceGroup;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;


import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="DBResourceGroup"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DBResourceGroup"
*	local-jndi-name="DBResourceGroup"
*	impl-class-name="eSM.DBResourceGroup.DatabaseRsrcgrpManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSM.DBResourceGroup.DatabaseRsrcgrpLocal"
*	remote-class="eSM.DBResourceGroup.DatabaseRsrcgrpRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.DBResourceGroup.DatabaseRsrcgrpLocalHome"
*	remote-class="eSM.DBResourceGroup.DatabaseRsrcgrpHome"
*	generate= "local,remote"
*
*
*/

public class DatabaseRsrcgrpManager implements SessionBean {

	Connection con ;
	//Connection con1 ;
	PreparedStatement pstmt ;
    String locale="";   
	ResultSet rs;
	ResultSet rs_ora=null;
	int p_life_time=0;
	int p_grace_time=0;

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
	public final String RECORD_DELETED	= "RECORD_DELETED" ;
	public String connection_pooling_yn="";
	SessionContext ctx;
    String ora_rsrc_group_id               ="";    
    String ora_rsrc_group_name             ="";	
    String ora_pwd_grace_time              ="";
    String ora_pwd_life_time               ="";
	String ora_pwd_reuse_time              ="";
	String ora_pwd_reuse_max               ="";
	String ora_failed_login_attempts       ="";
	String ora_pwd_lock_time               ="";
	String ora_idle_time                   ="";
	String ora_sessions_per_user           ="";
	String ora_connect_time                ="";
	String ora_private_sga                 ="";
	String ora_private_sga_unit            ="";
	String ora_cpu_per_session             ="";
	String ora_cpu_per_call                ="";
	String password_expiry_alert_days      ="";//Maheshwaran added for the MMS-CRF-0149
	String ora_ir_per_session              ="";
	String ora_ir_per_call                 ="";
	String addedAtWorkstation              ="";
	String addedById                       ="";
	String modifiedById                    ="";
	String modifiedAtWorkstation           ="";
    StringBuffer sb = new StringBuffer() ;

	public void ejbCreate() {};
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {
	
	this.ctx = context;
	}
	/**
	 *Method to insert DB Resource Group
	 *@param hashaMap Record data 
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertDBRsrcgrp(
							java.util.HashMap tabdata1		
													 ) 
	 {
		boolean result = false ;
		boolean insertable = true ;
    	
    	java.util.HashMap results = new java.util.HashMap() ;
		java.util.Properties p=(java.util.Properties)tabdata1.get("p");
		locale = p.getProperty("LOCALE");
		
		ora_rsrc_group_id             =(String)tabdata1.get("ora_rsrc_group_id");	
		ora_rsrc_group_name           =(String)tabdata1.get("ora_rsrc_group_name");	
		ora_pwd_grace_time            =(String)tabdata1.get("ora_pwd_grace_time");	
		ora_pwd_life_time             =(String)tabdata1.get("ora_pwd_life_time");	
		ora_pwd_reuse_time            =(String)tabdata1.get("ora_pwd_reuse_time");	
		ora_pwd_reuse_max             =(String)tabdata1.get("ora_pwd_reuse_max");	
		ora_failed_login_attempts     =(String)tabdata1.get("ora_failed_login_attempts");	
		ora_pwd_lock_time             =(String)tabdata1.get("ora_pwd_lock_time");	
		ora_idle_time                 =(String)tabdata1.get("ora_idle_time");	
		ora_sessions_per_user         =(String)tabdata1.get("ora_sessions_per_user");	
		ora_connect_time              =(String)tabdata1.get("ora_connect_time");	
		ora_private_sga               =(String)tabdata1.get("ora_private_sga");	
		ora_private_sga_unit          =(String)tabdata1.get("ora_private_sga_unit");	
		ora_cpu_per_session           =(String)tabdata1.get("ora_cpu_per_session");	
		ora_cpu_per_call              =(String)tabdata1.get("ora_cpu_per_call");
		ora_ir_per_session            =(String)tabdata1.get("ora_ir_per_session");	
		ora_ir_per_call               =(String)tabdata1.get("ora_ir_per_call");	
		password_expiry_alert_days     =(String)tabdata1.get("password_expiry_alert_days");//Maheshwaran added for the MMS-CRF-0149
		addedAtWorkstation            =(String)tabdata1.get("client_ip_address");	
		addedById                     = p.getProperty( "login_user" ) ;
		modifiedById                  = addedById ;
		modifiedAtWorkstation         = addedAtWorkstation ;

		


	

							 
		try {


			/*String ecis_jdbc_driver = p.getProperty( "ecis_jdbc_driver" ) ;
			String ecis_jdbc_dns 	= p.getProperty( "ecis_jdbc_dns" ) ;
			String ecis_jdbc_user	= p.getProperty( "ecis_jdbc_user" ) ;
			String ecis_jdbc_password=p.getProperty( "ecis_jdbc_password" ) ;*/
			try
				{
			/*	Class.forName( ecis_jdbc_driver ) ;
				con1 = DriverManager.getConnection( ecis_jdbc_dns, ecis_jdbc_user, ecis_jdbc_password ) ;*/
				con = ConnectionManager.getConnection(p);
				con.setAutoCommit(false);
				}
			catch(Exception e)	
				{
				System.out.println("Exception occurred while getting Connection in insertDBRsrcgrp() "+e);
				e.printStackTrace();
				}
			connection_pooling_yn=p.getProperty( "connection_pooling_yn" ) ;

			String ora_role_password="";
			try
				{
				if(connection_pooling_yn.equals("Y"))
				{				
					String sql_ora=" Select APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) from sm_ora_role where ora_role_id='MEDADMIN' ";
					pstmt=con.prepareStatement(sql_ora);
					rs_ora=pstmt.executeQuery();
					if(rs_ora!=null){
						while(rs_ora.next()){
							ora_role_password=rs_ora.getString(1);
						}
					}else{
						sb.append("Record not Found For the Role MEDADMIN");
					}
					if(ora_role_password != null && !ora_role_password.equals("")){
						try{
							  sql_ora="Set Role MEDADMIN identified by "+ora_role_password;
							  if(pstmt!=null)pstmt.close();
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
							  if(pstmt!=null)pstmt.close();
							  pstmt=con.prepareStatement(sql_ora);
							  pstmt.execute();
							  pstmt.close();
						}catch(Exception pswd){
							sb.append(pswd.getMessage());
							pswd.printStackTrace();
						}
					}
				}
				}
			catch(Exception e)	
				{
				System.out.println("exception occurred while setting the Role in insertDBRsrcgrp() "+e);
				e.printStackTrace();
				}
			try
				{
			final String duplicateSql = "select ORA_RSRC_GROUP_ID from SM_ora_rsrc_grp where ora_rsrc_group_id = ? " ;
			if(pstmt!=null)pstmt.close();
			pstmt = con.prepareStatement( duplicateSql ) ;
			pstmt.setString( 1, ora_rsrc_group_id ) ;
			rs = pstmt.executeQuery() ;

			if ( rs.next() )
			{
			  insertable = false ;
			 java.util.Hashtable message = MessageManager.getMessage(locale,"CODE_ALREADY_EXISTS", "Common");
		//	  final java.util.Hashtable message = MessageManager.getMessage( con, CODE_ALREADY_EXISTS ) ;
			  sb.append( (String) message.get("message") ) ;
              message.clear();
			}
			if(rs!=null) rs.close();
			}
		catch(Exception e)	
			{
			System.out.println("Exception occurred while getting the record from SM_ora_rsrc_grp "+e);
			e.printStackTrace();
			}

		if ( insertable )
		{
		  insertable=insertintoSMORASrcGrp();
		  if ( insertable )
		  {	result = true ;
		 	java.util.Hashtable message = MessageManager.getMessage(locale,	"RECORD_INSERTED", "SM");
			sb.append( (String) message.get("message") ) ;
			con.commit();
			//con1.commit();
		    message.clear();
		}
		else{
		try{con.rollback();
		//con1.rollback();
		}catch(Exception ec){
			ec.printStackTrace();
		}}
			
		}//E.O.Insertable
		if(rs_ora !=null) rs_ora.close();
}catch ( Exception e )
			{
				insertable = false ;
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
			}
			finally
				{ 
				try
					{
					if (con != null)
					ConnectionManager.returnConnection(con,p);
					}
				catch (Exception ee)
					{
					ee.printStackTrace();
					}
		      	  }
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
	    tabdata1.clear();
		sb.setLength(0);
		return results ;
	}//E.O.InsertOraRole

    public boolean insertintoSMORASrcGrp()
	{  
	int ora_failed_login_count=0;
	try {
				try
				{
	            String sql1 = "INSERT into SM_ora_rsrc_grp (ora_rsrc_group_id, ora_rsrc_group_name, ora_pwd_grace_time, ora_pwd_life_time, ora_pwd_reuse_time, ora_pwd_reuse_max, ora_failed_login_attempts, ora_pwd_lock_time, ora_idle_time, ora_sessions_per_user, ora_connect_time, ora_private_sga, ora_private_sga_unit, ora_cpu_per_session, ora_cpu_per_call, ora_ir_per_session, ora_ir_per_call, added_by_id, added_date, added_at_ws_no, modified_by_id, modified_date, modified_at_ws_no,password_expiry_alert_days) values ('"+ora_rsrc_group_id+"', '"+ora_rsrc_group_name+"', '"+ora_pwd_grace_time+"', '"+ora_pwd_life_time+"', '"+ora_pwd_reuse_time+"', '"+ora_pwd_reuse_max+"', '"+ora_failed_login_attempts+"', '"+ora_pwd_lock_time+"', '"+ora_idle_time+"', '"+ora_sessions_per_user+"', '"+ora_connect_time+"', '"+ora_private_sga+"', '"+ora_private_sga_unit+"', '"+ora_cpu_per_session+ "', '"+ora_cpu_per_call+"', '"+ora_ir_per_session+"', '"+ora_ir_per_call+"', '"+addedById+ "', sysdate, '"+addedAtWorkstation+"', '"+modifiedById+"', sysdate, '"+modifiedAtWorkstation+"','"+password_expiry_alert_days+"')";
				if(pstmt!=null)pstmt.close();
     			pstmt = con.prepareStatement(sql1);
				 pstmt.executeUpdate() ;
				 }
				catch(Exception e) 
					{
					System.out.println("Exception occurred while executing inserting into SM_ora_rsrc_grp "+e);
					e.printStackTrace();
					}
				/*try
					{
				if(!(ora_failed_login_attempts.equals("")))
				{
				ora_failed_login_count=Integer.parseInt(ora_failed_login_attempts);
				}
				StringBuffer sql2=new StringBuffer();
				sql2.append("CREATE profile "+ora_rsrc_group_id+" limit");
				if(ora_pwd_grace_time.equals(""))
					p_grace_time=0;
				else
					p_grace_time = Integer.parseInt(ora_pwd_grace_time);

				if(ora_pwd_life_time.equals(""))
					sql2 .append(" password_life_time 	default					 ");
				else
				  {
					p_life_time = Integer.parseInt(ora_pwd_life_time);

					sql2.append(" password_life_time 	"+(p_life_time+p_grace_time));
				  }	sql2.append(" password_grace_time 	default					 ");
				if(ora_pwd_reuse_time.equals("") && (!ora_pwd_reuse_max.equals("")) || ora_pwd_reuse_max!=null && (ora_pwd_reuse_time==null))
				{
					sql2 .append(" password_reuse_time 	unlimited				  ");
					sql2.append(" password_reuse_max 	"+ora_pwd_reuse_max);
				}
				if(ora_pwd_reuse_max.equals("") && (!ora_pwd_reuse_time.equals("")) || ora_pwd_reuse_max==null && (ora_pwd_reuse_time!=null))
				{
					sql2.append(" password_reuse_max 	unlimited				   ");
					//sql2.append(" password_reuse_time 	"+ora_pwd_reuse_time);
					//Modified by Maheshwaran K for the Password Validation as on 11/07/2012
					//Start
					sql2.append(" password_reuse_time 	unlimited                 ");
					//End
				}

				if(ora_pwd_reuse_max.equals("") && (ora_pwd_reuse_time.equals(""))|| ora_pwd_reuse_max==null && (ora_pwd_reuse_time==null))
				{
					sql2.append(" password_reuse_max 	2147483646				   ");
					sql2.append(" password_reuse_time 	unlimited 				   ");
				}
				if(ora_idle_time.equals(""))
					sql2.append(" idle_time 	default							   ");
				else
					sql2.append(" idle_time 	"+ora_idle_time);
				if(ora_failed_login_attempts.equals(""))
					sql2.append(" failed_login_attempts 	default				   ");
				else
					sql2.append(" failed_login_attempts 	"+ora_failed_login_count);
				if(ora_pwd_lock_time.equals(""))
					sql2.append(" password_lock_time 	default					   ");
				else
					sql2.append(" password_lock_time 	"+ora_pwd_lock_time	);
				if(ora_sessions_per_user.equals(""))
					sql2.append(" sessions_per_user 	default					   ");
				else
					sql2.append(" sessions_per_user 	"+ora_sessions_per_user);
				if(ora_connect_time.equals(""))
					sql2.append(" connect_time 	default							    ");
				else
					sql2.append(" connect_time 	"+ora_connect_time);
				if(ora_private_sga.equals(""))
					sql2.append(" private_sga 	default								");
				else
					sql2.append(" private_sga 	"+ora_private_sga);
				if(ora_cpu_per_session.equals(""))
					sql2.append(" cpu_per_session 	default							");
				else
					sql2.append(" cpu_per_session 	"+ora_cpu_per_session);
				if(ora_cpu_per_call.equals(""))
					sql2.append(" cpu_per_call 	default								");
				else
					sql2.append(" cpu_per_call 	"+ora_cpu_per_call);
				if(ora_ir_per_session.equals(""))
					sql2.append(" logical_reads_per_session 	default				");
				else
				sql2.append(" logical_reads_per_session 	"+ora_ir_per_session);
				if(ora_ir_per_call.equals(""))
					sql2.append(" logical_reads_per_call 	default					");
				else
					sql2.append(" logical_reads_per_call 	"+ora_ir_per_call);
				if(pstmt!=null)pstmt.close();
				
				 pstmt = con.prepareStatement( sql2.toString());
				 pstmt.executeUpdate() ;
				  sql2.setLength(0);
				  }
				  catch(Exception e)
					{
					e.printStackTrace();
					System.out.println("Exception occurred while creating profile in insertintoSMORASrcGrp "+e);
					}*/
			    
			} catch ( Exception e )
			   {
					sb.append( e.getMessage() + "<br>" ) ;
					e.printStackTrace() ;
						try{
							con.rollback();
							//con1.rollback();
						   }catch (Exception ce){
							   ce.printStackTrace();
						   }
			   }
		
	
	return true;
	
	}
	
	/**
	 *Method to update DB Resource Group
	 *@param hashaMap Record data 
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public java.util.HashMap updateDBRsrcgrp(
								java.util.HashMap tabdata1	
					 ) 
	 {
		boolean result 		= false ;
		boolean updateable  = true ;
		java.util.HashMap results = new java.util.HashMap() ;
		StringBuffer sb 	= new StringBuffer( "" ) ;
		java.util.Properties p=(java.util.Properties)tabdata1.get("p");
         locale = p.getProperty("LOCALE");
        ora_rsrc_group_id             =(String)tabdata1.get("ora_rsrc_group_id");	
		ora_rsrc_group_name           =(String)tabdata1.get("ora_rsrc_group_name");	
		ora_pwd_grace_time            =(String)tabdata1.get("ora_pwd_grace_time");	
		ora_pwd_life_time             =(String)tabdata1.get("ora_pwd_life_time");	
		ora_pwd_reuse_time            =(String)tabdata1.get("ora_pwd_reuse_time");	
		ora_pwd_reuse_max             =(String)tabdata1.get("ora_pwd_reuse_max");	
		ora_failed_login_attempts     =(String)tabdata1.get("ora_failed_login_attempts");	
		ora_pwd_lock_time             =(String)tabdata1.get("ora_pwd_lock_time");	
		ora_idle_time                 =(String)tabdata1.get("ora_idle_time");	
		ora_sessions_per_user         =(String)tabdata1.get("ora_sessions_per_user");	
		ora_connect_time              =(String)tabdata1.get("ora_connect_time");	
		ora_private_sga               =(String)tabdata1.get("ora_private_sga");	
		ora_private_sga_unit          =(String)tabdata1.get("ora_private_sga_unit");	
		ora_cpu_per_session           =(String)tabdata1.get("ora_cpu_per_session");	
		ora_cpu_per_call              =(String)tabdata1.get("ora_cpu_per_call");
		ora_ir_per_session            =(String)tabdata1.get("ora_ir_per_session");	
		ora_ir_per_call               =(String)tabdata1.get("ora_ir_per_call");	
		password_expiry_alert_days     =(String)tabdata1.get("password_expiry_alert_days");//Maheshwaran added for the MMS-CRF-0149
		addedAtWorkstation            =(String)tabdata1.get("client_ip_address");	
		addedById                     = p.getProperty( "login_user" ) ;
		modifiedById                  = addedById ;
		modifiedAtWorkstation         = addedAtWorkstation ;
	
try{
				try {

			
			/*String ecis_jdbc_driver = p.getProperty( "ecis_jdbc_driver" ) ;
			String ecis_jdbc_dns 	= p.getProperty( "ecis_jdbc_dns" ) ;
			String ecis_jdbc_user	= p.getProperty( "ecis_jdbc_user" ) ;
			String ecis_jdbc_password=p.getProperty( "ecis_jdbc_password" ) ;*/
			/*Class.forName( ecis_jdbc_driver ) ;
			con1 = DriverManager.getConnection( ecis_jdbc_dns, ecis_jdbc_user, ecis_jdbc_password ) ;*/
			con = ConnectionManager.getConnection(p);
			} catch ( Exception e )
			  {	
			  System.out.println("Exception occurred while getting Connection in updateDBRsrcgrp() "+e);
			  updateable = false ;
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				if (con != null)
				{	try {

						} catch (Exception ee) {}
		      	} }

		try {
			connection_pooling_yn=p.getProperty( "connection_pooling_yn" ) ;
             String ora_role_password="";
			if(connection_pooling_yn.equals("Y"))
			{	if(pstmt!=null)pstmt.close();
				String sql_ora=" Select APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) from sm_ora_role where ora_role_id='MEDADMIN' ";
				pstmt=con.prepareStatement(sql_ora);
				rs_ora=pstmt.executeQuery();
				if(rs_ora!=null){  
				  while(rs_ora.next()){
					ora_role_password=rs_ora.getString(1);
				  }
				}else{
					sb.append("Record not Found For the Role MEDADMIN");
				}
				if(ora_role_password != null && !ora_role_password.equals("")){
					try{
						if(pstmt!=null)pstmt.close();
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
						    if(pstmt!=null)pstmt.close();
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
		if ( updateable )
		{  con.setAutoCommit(false);	
		updateable=updateSMORAGrp(); 
		if (updateable)
			{
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage(locale,	"RECORD_MODIFIED", "SM");
				sb.append( (String) message.get("message") ) ;
				con.commit();
			//	con1.commit();
    			message.clear();
			}
			else{
			con.rollback();
		//	con1.rollback();
			}
			pstmt.close() ;
		}
		}	catch ( Exception e )
			   {
					sb.append( e.getMessage() + "<br>" ) ;
					e.printStackTrace() ;
						try{
							con.rollback();
					//		con1.rollback();
						   }catch (Exception ce){}
			   }
			finally
			{
			  if (con != null)
			  {
			   try
			   {
try{
				}
				catch(Exception pswd)
				{
					sb.append(pswd.getMessage());

				}
			//	con1.close();
		       } catch (Exception ee) {}
		      }

		   }
		   if(rs_ora !=null) rs_ora.close();

}catch ( Exception e )
			{
				updateable = false ;
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
			}
			finally
			{
			try {
				  if (con != null)
				  
				   		ConnectionManager.returnConnection(con,p);
				       } catch (Exception ee) {}
		      	  }
			//}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
	tabdata1.clear();
		return results ;
	
	}//E.O.ModifyDBRsrc



	public boolean updateSMORAGrp()
	{
		int ora_failed_login_count=0;
	    try
		{
		try
			{
        String sql2 =	 " UPDATE	SM_ora_rsrc_grp set	 ora_rsrc_group_name = '"+ora_rsrc_group_name+"',	"+
		" ora_pwd_grace_time  = '"+ora_pwd_grace_time+"',"+" ora_pwd_life_time= '"+ora_pwd_life_time+"',"+" ora_pwd_reuse_time  = '"+ora_pwd_reuse_time+"',	"+" ora_pwd_reuse_max   =  '"+ora_pwd_reuse_max+"',"+" ora_failed_login_attempts = '"+ora_failed_login_attempts+"', "+" ora_pwd_lock_time   = '"+ora_pwd_lock_time+"',	"+" ora_idle_time 	   = '"+ora_idle_time+"',"+" ora_sessions_per_user ='"+ora_sessions_per_user+"',"+" ora_connect_time    ='"+ora_connect_time+"',"+" ora_private_sga	   = '"+ora_private_sga+"',"+" ora_private_sga_unit= '"+ora_private_sga_unit+"',"+" ora_cpu_per_session = '"+ora_cpu_per_session+"',"+" ora_cpu_per_call    = '"+ ora_cpu_per_call+"',"+" ora_ir_per_session  = '"+ora_ir_per_session+"',"+" ora_ir_per_call     = '"+ora_ir_per_call+"',"+" added_by_id   = '"+ addedById +"',"+" added_date 	  = sysdate ,"+" added_at_ws_no = '"+ addedAtWorkstation +"',"+" modified_by_id 	   = '"+ modifiedById +"',"+" modified_date 	   = sysdate,"+" modified_at_ws_no   = '"+ modifiedAtWorkstation +"'"+",password_expiry_alert_days='"+password_expiry_alert_days+"' where ora_rsrc_group_id = '"+ora_rsrc_group_id+"'";
		if(pstmt!=null)pstmt.close();
		pstmt = con.prepareStatement( sql2 );
		pstmt.executeUpdate() ;
		}
		catch(Exception e)
			{
			System.out.println("Exception occurred while executing the update in SM_ora_rsrc_grp "+e);
			e.printStackTrace();
			}
	/*	try	
		{
		if(!(ora_failed_login_attempts.equals(""))){
		ora_failed_login_count=Integer.parseInt(ora_failed_login_attempts);
		}
		StringBuffer sql3=new StringBuffer();
	    sql3.append(" ALTER profile "+ora_rsrc_group_id+"  limit			 ");
		if(ora_pwd_grace_time.equals(""))
		p_grace_time=0;
		else
    	p_grace_time = Integer.parseInt(ora_pwd_grace_time);
		if(ora_pwd_life_time.equals(""))
		sql3.append(" password_life_time 	default					 ");
		else
       {	p_life_time = Integer.parseInt(ora_pwd_life_time);
			sql3.append(" password_life_time 	"+(p_life_time+p_grace_time));
	   }
    	sql3.append(" password_grace_time 	default					 ");
		if(ora_pwd_reuse_time.equals("") && (!ora_pwd_reuse_max.equals("")) || ora_pwd_reuse_max!=null && (ora_pwd_reuse_time==null))
		{
		sql3.append(" password_reuse_time 	unlimited				  ");
		sql3.append(" password_reuse_max 	"+ora_pwd_reuse_max);
     	}
		if(ora_pwd_reuse_max.equals("") && (!ora_pwd_reuse_time.equals("")) || ora_pwd_reuse_max==null && (ora_pwd_reuse_time!=null))
			{
			sql3.append(" password_reuse_max 	unlimited				   ");
			//Modified by Maheshwaran K for the Password Validation as on 11/07/2012
			//Start
			//sql3.append(" password_reuse_time 	"+ora_pwd_reuse_time);
			sql3.append(" password_reuse_time 	unlimited                  ");
			//End
		}
		if(ora_pwd_reuse_max.equals("") && (ora_pwd_reuse_time.equals(""))|| ora_pwd_reuse_max==null && (ora_pwd_reuse_time==null))
		{
			sql3.append(" password_reuse_max 	2147483646				   ");
			sql3.append(" password_reuse_time 	unlimited 				   ");
			}
		if(ora_idle_time.equals(""))
			sql3.append(" idle_time 	default							   ");
			else
			sql3.append(" idle_time 	"+ora_idle_time	);
		if(ora_failed_login_attempts.equals(""))
			sql3.append(" failed_login_attempts 	default				   ");
			else
			sql3.append(" failed_login_attempts 	"+ora_failed_login_count);
		if(ora_pwd_lock_time.equals(""))
			sql3.append(" password_lock_time 	default					   ");
			else
			sql3.append(" password_lock_time 	"+ora_pwd_lock_time);
		if(ora_sessions_per_user.equals(""))
			sql3.append(" sessions_per_user 	default					   ");
			else
			sql3.append(" sessions_per_user 	"+ora_sessions_per_user);
    	if(ora_connect_time.equals(""))
			sql3.append(" connect_time 	default							    ");
			else
			sql3.append(" connect_time 	"+ora_connect_time)	;
		if(ora_private_sga.equals(""))
			sql3.append(" private_sga 	default								");
			else
			sql3.append(" private_sga 	"+ora_private_sga);
		if(ora_cpu_per_session.equals(""))
			sql3.append(" cpu_per_session 	default							");
			else
			sql3.append(" cpu_per_session 	"+ora_cpu_per_session);
		if(ora_cpu_per_call.equals(""))
			sql3.append(" cpu_per_call 	default								");
			else
			sql3.append(" cpu_per_call 	"+ora_cpu_per_call);
		if(ora_ir_per_session.equals(""))
			sql3.append(" logical_reads_per_session 	default				");
			else
			sql3.append(" logical_reads_per_session 	"+ora_ir_per_session);
		if(ora_ir_per_call.equals(""))
			sql3.append(" logical_reads_per_call 	default					");
			else
    		sql3.append(" logical_reads_per_call 	"+ora_ir_per_call);
		if(pstmt!=null)pstmt.close();
			 pstmt 	  = con.prepareStatement( sql3.toString() );
			 pstmt.executeUpdate() ;
		}
		catch(Exception e)
			{
			System.out.println("Exception occurred while altering the profile in updateSMORAGrp() "+e);
			e.printStackTrace();
			}
*/
		}catch(Exception e)
		{
		e.printStackTrace();
		}

return true;
	}

	/**
	 *Method to delete DB Resource Group
	 *@param hashaMap Record data 
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	
	public java.util.HashMap deleteDBRsrcgrp(
								java.util.HashMap tabdata1	
								) 
		 {
			java.util.Properties p=(java.util.Properties)tabdata1.get("p");
			locale = p.getProperty("LOCALE");
			String ora_rsrc_group_id=(String)tabdata1.get("ora_rsrc_group_id");	
    	 	int res5=0;
			java.util.HashMap results = new java.util.HashMap() ;
			boolean result 		= false ;
			boolean deletable  = true ;
			StringBuffer sb 	= new StringBuffer( "" ) ;
			String sql7="";
try{
		try {	
			/*String ecis_jdbc_driver = p.getProperty( "ecis_jdbc_driver" ) ;
			String ecis_jdbc_dns 	= p.getProperty( "ecis_jdbc_dns" ) ;
			String ecis_jdbc_user	= p.getProperty( "ecis_jdbc_user" ) ;
			String ecis_jdbc_password=p.getProperty( "ecis_jdbc_password" ) ;
			Class.forName( ecis_jdbc_driver ) ;
			con1 = DriverManager.getConnection( ecis_jdbc_dns, ecis_jdbc_user, ecis_jdbc_password ) ;*/
			con = ConnectionManager.getConnection(p);
			}
		catch ( Exception e )
				{	
				System.out.println("Exception occurred while getting Connection in deleteDBRsrcgrp() "+e);
				deletable = false ;
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				}
			try {
			if ( deletable )
			{con.setAutoCommit(false);
			connection_pooling_yn=p.getProperty( "connection_pooling_yn" ) ;
			String ora_role_password="";
			try
				{
			if(connection_pooling_yn.equals("Y"))
			{	if(rs_ora!=null)rs_ora.close();
				if(pstmt!=null)pstmt.close();
				String sql_ora=" Select APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) from sm_ora_role where ora_role_id='MEDADMIN' ";
				pstmt=con.prepareStatement(sql_ora);
				rs_ora=pstmt.executeQuery();
				if(rs_ora!=null)
			    {while(rs_ora.next())
				 {ora_role_password=rs_ora.getString(1);		}
					rs_ora.close();
				}
			else
				{sb.append("Record not Found For the Role MEDADMIN");
				}
			if(ora_role_password != null && !ora_role_password.equals(""))
				{
				try
					{
					if(pstmt!=null)pstmt.close();
					sql_ora="Set Role MEDADMIN identified by "+ora_role_password;
					pstmt=con.prepareStatement(sql_ora);
					pstmt.execute();
					}
				catch(Exception pswd)
					{
					sb.append(pswd.getMessage());
					pswd.printStackTrace();
					}
				}
			else{
				try
					{
					if(pstmt!=null)pstmt.close();
					sql_ora="Set Role MEDADMIN";
					if(pstmt!=null) pstmt.close();
					pstmt=con.prepareStatement(sql_ora);
					pstmt.execute();
					pstmt.close();
					}
				catch(Exception pswd)
					{
					sb.append(pswd.getMessage());
					}
				}	
			}
			}
			catch(Exception e)
				{
				System.out.println("Exception occurred while setting role in deleteDBRsrcgrp "+e);
				e.printStackTrace();
				}
			sql7 = "UPDATE SM_APPL_USER SET ORA_RSRC_GROUP_ID=NULL WHERE "+"ORA_RSRC_GROUP_ID='"+ora_rsrc_group_id+"'";
        	String sqlChk=" select count(*) from sm_appl_user where ORA_RSRC_GROUP_ID='"+ora_rsrc_group_id+"' ";
			if(pstmt!=null)pstmt.close();
		    pstmt = con.prepareStatement( sqlChk );
		    ResultSet rsChk=pstmt.executeQuery();
			if(rsChk.next())
			{ if(rsChk.getInt(1) > 0)
				{	deletable = false ;
					java.util.Hashtable message = MessageManager.getMessage(locale,	"OS_CANNOT_DELETED_USER_EXIST", "AM");
					sb.append( (String) message.get("message") ) ;
				message.clear();
				}
				else
					deletable = true ;
			}
      if(deletable)
      {		if(rsChk!=null)rsChk.close();
			if(pstmt!=null)pstmt.close();
			try
				{
				pstmt = con.prepareStatement( sql7 );
				}
			catch(Exception e)	
				{
				System.out.println("Exception occurred while updating in SM_APPL_USER "+e);
				e.printStackTrace();
				}
			try
				{
				String sql5 = " DELETE from	sm_ora_rsrc_grp where ora_rsrc_group_id = '"+ora_rsrc_group_id+"' ";
				if(pstmt!=null)pstmt.close();
				pstmt = con.prepareStatement( sql5 );
				res5 = pstmt.executeUpdate() ;
				}
			catch(Exception e)	
				{
				System.out.println("Exception occurred while deleting in sm_ora_rsrc_grp "+e);
				e.printStackTrace();
				}
			/*try
				{
				String sql6 = " DROP profile "+ora_rsrc_group_id + " CASCADE " ;
				pstmt 	  = con.prepareStatement( sql6 );
				pstmt.executeUpdate() ;
				}
			catch(Exception e)	
				{
				System.out.println("Exception occurred while dropping profile "+e);
				e.printStackTrace();
				}	*/
			if (res5 != 0)
    		{	result = true ;
				java.util.Hashtable message = MessageManager.getMessage(locale,	"RECORD_DELETED", "SM");
				sb.append( (String) message.get("message") ) ;
				con.commit();
				//con1.commit();
                 message.clear();
			}
			else{	con.rollback();
				    //con1.rollback();
        		}}			pstmt.close() ;
				}}	catch ( Exception e )
				   {	sb.append( e.getMessage() + "<br>" ) ;
						e.printStackTrace() ;
						try{
							con.rollback();
							//con1.rollback();
					       }catch (Exception ce){
							   ce.printStackTrace();
						   }
				   }finally
				    {
					try
						{
						if (con != null)
						 con.close();
						} catch (Exception ee) {
					   ee.printStackTrace();
				  			      } }
				if(rs_ora !=null) rs_ora.close();
				if(pstmt !=null) pstmt.close();
						
}catch ( Exception e )
		{
				deletable = false ;
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
			}
			finally
			{
				    try {
					if (con != null)

						ConnectionManager.returnConnection(con,p);
				       } catch (Exception ee) {
						   ee.printStackTrace();
					   }
		      	  }
			//}

			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sb.toString() ) ;
	tabdata1.clear();
			return results ;
	
	}//E.O.deleteDBRsrcgrp

}//E.O.sess bean

