/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSM.SMUser ;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*; 

/**
*
* @ejb.bean
*	name="SMUser"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="SMUser"
*	local-jndi-name="SMUser"
*	impl-class-name="eSM.SMUser.SMUserManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSM.SMUser.SMUserManagerLocal"
*	remote-class="eSM.SMUser.SMUserManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.SMUser.SMUserManagerLocalHome"
*	remote-class="eSM.SMUser.SMUserManagerHome"
*	generate= "local,remote"
*
*
*/
 

public class SMUserManager implements SessionBean {
    SessionContext ctx;
	Connection con ; 
	PreparedStatement pstmt ;
	PreparedStatement pstmt2 ;
	Statement stmt ;
	String locale="";
	ResultSet rs_ora=null;
	ResultSet rs =null;
	ResultSet rs1 =null;
	ResultSet rset=null;
	ResultSet rs2= null;
	boolean result = false ;
	boolean insertable = true ;
	StringBuffer sb = new StringBuffer( "" ) ;	

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
	public String connection_pooling_yn="";
    String sql1="";
	String ora_role_password="";
	public void ejbCreate()  {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx = context;
	}
   	/**
	 *Method to insert SM User
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertSMUser(java.util.HashMap tabdata1) {
        System.err.println("89-------insertSMUser-------SMUSERMANAGERJAVA---------------->");
		insertable                = true ;
		java.util.Properties p    =(java.util.Properties)tabdata1.get("p");
		locale                    = p.getProperty("LOCALE");
		String appl_user_id       =(String)tabdata1.get("appl_user_id");	
		String appl_user_name     =(String)tabdata1.get("appl_user_name");	
		String appl_user_password =(String)tabdata1.get("appl_user_password");
		String rep_facility_id	  =(String)tabdata1.get("rep_facility_id");	
		String contact_tel_no	  =(String)tabdata1.get("contact_tel_no");	
		String contact_fax_no	  =(String)tabdata1.get("contact_fax_no");
		String language_id	      =(String)tabdata1.get("LANGUAGE_ID");	
		String email_id			  =(String)tabdata1.get("email_id");	
		String resp_group_id	  =(String)tabdata1.get("resp_group_id");
		String responsibility_group=(String)tabdata1.get("responsibility_group"); //Added by Suji Keerthi for MMS-MD-SCF-0173
		String employee_no	      =(String)tabdata1.get("employee_no");
		String effectiveDateFrom  =(String)tabdata1.get("effectiveDateFrom");	
		String effectiveDateTo    =(String)tabdata1.get("effectiveDateTo");
		String effectiveStatus    =(String)tabdata1.get("effectiveStatus");
		String funcroleid         =(String)tabdata1.get("funcroleid");
		String funcrole           =(String)tabdata1.get("funcrole");
		String addedAtWorkstation =(String)tabdata1.get("addedAtWorkstation");
		String appl_pin_no        =(String)tabdata1.get("appl_pin_no");
		//String responsibility_grp =(String)tabdata1.get("responsibility_grp"); //Commented by Suji Keerthi for MMS-MD-SCF-0173
		String reports_home_dir   =(String)tabdata1.get("reports_home_dir");
		String long_name		  =(String)tabdata1.get("long_name");		
		String active_dir_id		  =(String)tabdata1.get("active_dir_id");
		
		String link_ad_user		  =(String)tabdata1.get("link_ad_user");//Added by Kamatchi S for ML-MMOH-CRF-1844
		
		String case_sensitive_password_yn=(String)tabdata1.get("case_sensitive_password_yn");//Maheshwaran added for the MMS-QH-CRF-0149
		java.util.HashMap results = new java.util.HashMap() ;
		String sql = "insert into sm_appl_user(appl_user_id,appl_user_name,appl_user_password,rep_facility_id,contact_tel_no,contact_fax_no,email_id, ora_rsrc_group_id,employee_no,eff_date_from,eff_date_to,eff_status, FUNC_ROLE_ID, FUNC_ROLE,added_by_id,added_date,added_at_ws_no,modified_by_id, modified_date,modified_at_ws_no,pin_no, RESP_GROUP_ID,REPORTS_HOME_DIR,LANGUAGE_ID,APPL_USER_LONG_NAME,ACTIVE_DIR_ID,LINK_AD_USER) values (?, ?, APP_PASSWORD.Encrypt(?), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, sysdate, ?,?,sysdate,?,APP_PASSWORD.Encrypt(?),?,?,?,?,?,?)" ;
		String addedById		     = p.getProperty( "login_user" ) ;
		String modifiedById		     = addedById ;
		String modifiedAtWorkstation = addedAtWorkstation ;
    	Date effective_date_from	 = null ;
		Date effective_date_to	     = null ;
		if ( (effectiveDateFrom != null) && (!effectiveDateFrom.equals("")) )
	 	effective_date_from          = Date.valueOf( effectiveDateFrom ) ;
		if ( (effectiveDateTo != null) && (!effectiveDateTo.equals("")) )
		effective_date_to            = Date.valueOf( effectiveDateTo ) ;
		try {
			con = ConnectionManager.getConnection(p);
		try {
			con.setAutoCommit(false);
    		connection_pooling_yn=p.getProperty( "connection_pooling_yn" ) ;
        
			if(connection_pooling_yn.equals("Y")) 
			{ 
				String sql_ora=" Select APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) from sm_ora_role where ora_role_id='MEDADMIN' ";
				pstmt=con.prepareStatement(sql_ora);
				rs_ora=pstmt.executeQuery();
				if(rs_ora!=null){
					while(rs_ora.next()){
						ora_role_password=rs_ora.getString(1);
					}
					
					rs_ora.close();pstmt.close();
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
			 final String duplicateSql = "select 1 from  sm_appl_user where appl_user_id = ?" ;
			 if(pstmt!=null) pstmt.close();
			 pstmt = con.prepareStatement( duplicateSql ) ;
			 pstmt.setString( 1, appl_user_id ) ;
			 rs = pstmt.executeQuery() ;
			 if ( rs.next() ) {
	  			insertable = false ;
				java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_EXISTS", "SM");
				sb.append( (String) message.get("message") ) ;
				rs.close();message.clear();
			}
			if(!funcroleid.equals("") && funcrole.equals("P")){
			String duplfuncrole = "select 1 from sm_appl_user where func_role_id = ?";
			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement( duplfuncrole ) ;
			pstmt.setString( 1, funcroleid ) ;
			rs1 = pstmt.executeQuery() ;
			if ( rs1.next() ) {
				insertable = false ;
					java.util.Hashtable message = MessageManager.getMessage(locale,"PRACT_ATTACHED_TO_USER", "SM");
					sb.append( (String) message.get("message") ) ;
					if(rs1!=null) rs1.close();
					message.clear();
				}
				
			}else if(!funcroleid.equals("") && funcrole.equals("O")){
			String duplfuncrole = "select 1 from sm_appl_user where func_role_id = ?";
			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement( duplfuncrole ) ;
			pstmt.setString( 1, funcroleid ) ;
			rs1 = pstmt.executeQuery() ;
			if ( rs1.next() ) {
				insertable = false ;
					java.util.Hashtable message = MessageManager.getMessage(locale,"OTHERSTAFF_ATTACHED_TO_USER", "SM");
					sb.append( (String) message.get("message") ) ;
					if(rs1!=null) rs1.close();
					message.clear();
				}
				
			}
		} catch ( Exception e ) {
			insertable = false ;
			sb.append( e.getMessage()) ;e.printStackTrace() ;

				try{
					con.rollback();
				}catch(Exception ce){
					ce.printStackTrace();
				}
		}
		if ( insertable ) {
			try {if(pstmt!=null) pstmt.close();
				sql1=" create user  "+appl_user_id+" identified by "+'"'+""+appl_user_password.toUpperCase()+""+'"'+"";//Maheshwaran modified for the MMS-QH-CRF-0149
				pstmt=con.prepareStatement(sql1);
				pstmt.executeUpdate();
				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement( sql );
				pstmt.setString	( 1, appl_user_id ) ;
				pstmt.setString	( 2, appl_user_name ) ;
				//Maheshwaran added for the MMS-QH-CRF-0149
				if(case_sensitive_password_yn.equals("N"))
					{
					pstmt.setString	( 3, appl_user_password.toUpperCase()) ;
					}
				else
					{
					pstmt.setString	( 3, appl_user_password) ;
					}
				pstmt.setString	( 4, rep_facility_id) ;
				pstmt.setString	( 5, contact_tel_no) ;
				pstmt.setString	( 6, contact_fax_no) ;
				pstmt.setString	( 7, email_id) ;
				pstmt.setString	( 8, resp_group_id) ;
				pstmt.setString	( 9, employee_no) ;
				pstmt.setDate	( 10, effective_date_from ) ;
				pstmt.setDate	( 11, effective_date_to ) ;
				pstmt.setString	( 12, effectiveStatus ) ;
				pstmt.setString	( 13, funcroleid ) ;
				pstmt.setString	( 14, funcrole ) ;
				pstmt.setString	( 15, addedById ) ;
				pstmt.setString	( 16, addedAtWorkstation ) ;
				pstmt.setString	( 17, modifiedById ) ;
				pstmt.setString	( 18, modifiedAtWorkstation ) ;
				pstmt.setString	( 19, appl_pin_no ) ;
				pstmt.setString	( 20, responsibility_group ) ; //Modified by Suji Keerthi for MMS-MD-SCF-0173
				pstmt.setString	( 21, reports_home_dir ) ;
				pstmt.setString	( 22, language_id ) ;
				pstmt.setString	( 23, long_name ) ;
				pstmt.setString	( 24, active_dir_id ) ;
				pstmt.setString	( 25, link_ad_user ) ; //Added by Kamatchi S for ML-MMOH-CRF-1844
				int res = pstmt.executeUpdate() ;
				if(pstmt!=null)pstmt.close();

			//	String sql2=" GRANT CONNECT,RESOURCE,MEDSTARTUP,MEDUSERS,MEDADMIN TO "+appl_user_id;
				// change done for GHL SCF 1214
				
				/*Added by Ashwini on 20-Jul-2020 for AMS-SCF-0888*/
				if(effectiveStatus.equals("E"))
				{
					String sql2=" GRANT CONNECT,RESOURCE,MEDSTARTUP,MEDUSERS TO "+appl_user_id;
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( sql2 );
					pstmt.executeUpdate();				
					if (pstmt!=null)pstmt.close();

				/*Commented by Ashwini on 31-Oct-2018 for PMG2018-COMN-CRF-0008*/
				/*String sql_grant=" GRANT ALTER SESSION, CREATE SESSION,SELECT ANY TABLE,UPDATE ANY TABLE,DELETE ANY TABLE,EXECUTE ANY PROCEDURE TO "+appl_user_id;
				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement( sql_grant );
				pstmt.executeUpdate();*/
				
					String sql3=" ALTER USER "+appl_user_id+" DEFAULT ROLE MEDSTARTUP ";
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( sql3 );
					pstmt.execute();
				}
				/*End AMS-SCF-0888*/

				if ( res != 0 ) {
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
				sb.append( (String) message.get("message") ) ;
				con.commit();//con1.commit();
				message.clear();
				}
				else{con.rollback();//con1.rollback();
				}
				if(rs_ora !=null) rs_ora.close();
				if(rs !=null) rs.close();
				if(rs1 !=null) rs1.close();
				if(rset !=null) rset.close();
				if(stmt !=null) stmt.close();
    			if(pstmt !=null) pstmt.close();				
			} catch ( Exception e ) {
				sb.append( e.getMessage()) ;
				e.printStackTrace() ;
				try{
					con.rollback();
				}catch(Exception ce){
					ce.printStackTrace();
				}
		  }
		  }
		 }catch (Exception e){
			e.printStackTrace() ;
			try{
				con.rollback();
			}catch(Exception ce){
				ce.printStackTrace();
			}
		 }
			finally	{
					  if (con != null)
					  {   try {	 	ConnectionManager.returnConnection(con,p);//ConnectionManager.returnConnection(con1,p);
							  } catch (Exception ee) {}
					  }	
			   }
		tabdata1.clear();
     	results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		sb.setLength(0);
		return results ;
	}

	/**
	 *Method to update SM User
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap updateSMUser(java.util.HashMap tabdata1 ) 
		{ System.err.println("343-------updateSMUser-------SMUSERMANAGERJAVA---------------->");
		java.util.Properties p=(java.util.Properties)tabdata1.get("p");
		locale = p.getProperty("LOCALE");
		String resource_status=(String)tabdata1.get("resource_status");	
		String response_status=(String)tabdata1.get("response_status");	//Added by Suji Keerthi for MMS-MD-SCF-0173 
		String password_status=(String)tabdata1.get("password_status");	
		String appl_user_id=(String)tabdata1.get("appl_user_id");	
		String appl_user_name=(String)tabdata1.get("appl_user_name");	
		String appl_user_password=(String)tabdata1.get("appl_user_password");
		String rep_facility_id=(String)tabdata1.get("rep_facility_id");	
		String language_id=(String)tabdata1.get("LANGUAGE_ID");	
		String contact_tel_no=(String)tabdata1.get("contact_tel_no");	
		String contact_fax_no=(String)tabdata1.get("contact_fax_no");
		String email_id=(String)tabdata1.get("email_id");	
		String resp_group_id=(String)tabdata1.get("resp_group_id");	
		String responsibility_group=(String)tabdata1.get("responsibility_group"); //Added by Suji Keerthi for MMS-MD-SCF-0173
		String employee_no=(String)tabdata1.get("employee_no");
		String effectiveDateFrom=(String)tabdata1.get("effectiveDateFrom");	
		String effectiveDateTo=(String)tabdata1.get("effectiveDateTo");
		String first_login_yn=(String)tabdata1.get("first_login_yn");//Maheshwaran added for the MMS-QH-CRF-0149
		String case_sensitive_password_yn=(String)tabdata1.get("case_sensitive_password_yn");//Maheshwaran added for the MMS-QH-CRF-0149
		String curr_effstatus = (String)tabdata1.get("curr_effstatus");//Added by Ashwini on 20-Jul-2020 for AMS-SCF-0888
		//Added by Maheshwaran K for the Password Validation as on 11/07/2012
		//Start
		//String effectiveStatus=(String)tabdata1.get("effectiveStatus");
		PreparedStatement cs1=null;
		String user_status="";
		String effectiveStatus="";
		String wsno="";
		String password_value_Y=(String)tabdata1.get("password_value_Y");
		String unlock_yn=(String)tabdata1.get("unlock_yn");
		if (unlock_yn=="Y" || unlock_yn.equals("Y"))
		{
			effectiveStatus="E";
			wsno="";
		}else
		{
			effectiveStatus=(String)tabdata1.get("effectiveStatus");
			if(effectiveStatus.equals("D"))
				{
				wsno=(String)tabdata1.get("ws_no");
				}
			else	
				{
				wsno="";
				}
		}
		//End
		java.sql.Timestamp enable_date_time = null;
		
		if(!effectiveStatus.equals(curr_effstatus) && effectiveStatus.equals("E"))
		{
			enable_date_time=(java.sql.Timestamp)tabdata1.get("enable_date_time");
		}
	
		String funcroleid=(String)tabdata1.get("funcroleid");
		String func_id=(String)tabdata1.get("func_id");
		String funcrole=(String)tabdata1.get("funcrole");

		String modifiedAtWorkstation=(String)tabdata1.get("modifiedAtWorkstation");
		String appl_pin_no=(String)tabdata1.get("appl_pin_no");
		//String responsibility_grp=(String)tabdata1.get("responsibility_grp"); //Commented by Suji Keerthi for MMS-MD-SCF-0173
		String reports_home_dir=(String)tabdata1.get("reports_home_dir");
		String long_name=(String)tabdata1.get("long_name");
		String active_dir_id=(String)tabdata1.get("active_dir_id");
		
		String link_ad_user=(String)tabdata1.get("link_ad_user");//Added by Kamatchi S for ML-MMOH-CRF-1844

		
		java.util.HashMap results = new java.util.HashMap() ;
		result = false ;
		boolean updatable = true ;
		//"WS_NO" was added in the query for the Password Validation as on 11/07/2012		
		//Maheshwaran added FIRST_LOGIN_YN in the query for the MMS-QH-CRF-0149

		String sql = "";

		if(!effectiveStatus.equals(curr_effstatus) && effectiveStatus.equals("E"))
		{
			sql = "update sm_appl_user set appl_user_name= ?,appl_user_password= APP_PASSWORD.Encrypt(?),rep_facility_id	= ?,contact_tel_no= ?,contact_fax_no= ?,email_id= ?,ora_rsrc_group_id= ?,employee_no= ?,eff_date_from= ?,eff_date_to= ?,eff_status= ?,FUNC_ROLE_ID =?,FUNC_ROLE=?,modified_by_id= ?,modified_date= sysdate,modified_at_ws_no = ?,pin_no = APP_PASSWORD.Encrypt(?),RESP_GROUP_ID =?,REPORTS_HOME_DIR = ?,LANGUAGE_ID=? ,WS_NO = ?,APPL_USER_LONG_NAME=?,ACTIVE_DIR_ID=?,FIRST_LOGIN_YN=?,LINK_AD_USER=?, ENABLE_DATE_TIME=? where appl_user_id = ?";
		}else
		{
			sql = "update sm_appl_user set appl_user_name= ?,appl_user_password= APP_PASSWORD.Encrypt(?),rep_facility_id	= ?,contact_tel_no= ?,contact_fax_no= ?,email_id= ?,ora_rsrc_group_id= ?,employee_no= ?,eff_date_from= ?,eff_date_to= ?,eff_status= ?,FUNC_ROLE_ID =?,FUNC_ROLE=?,modified_by_id= ?,modified_date= sysdate,modified_at_ws_no = ?,pin_no = APP_PASSWORD.Encrypt(?),RESP_GROUP_ID =?,REPORTS_HOME_DIR = ?,LANGUAGE_ID=? ,WS_NO = ?,APPL_USER_LONG_NAME=?,ACTIVE_DIR_ID=?,FIRST_LOGIN_YN=?,LINK_AD_USER=? where appl_user_id = ?";
		}

		String modifiedById = p.getProperty( "login_user" ) ;
		Date effective_date_from = null ;
		Date effective_date_to = null ;
		if ( (effectiveDateFrom != null) && (!effectiveDateFrom.equals("")) )
		effective_date_from = Date.valueOf( effectiveDateFrom ) ;
		if ( (effectiveDateTo != null) && (!effectiveDateTo.equals("")) )
		effective_date_to = Date.valueOf( effectiveDateTo ) ;
	try {	
		try {	con = ConnectionManager.getConnection(p);
				con.setAutoCommit(false);
				connection_pooling_yn=p.getProperty( "connection_pooling_yn" ) ;
    			ora_role_password="";
				//Added by Maheshwaran K for the Password Validation as on 11/07/2012
				//Start
		/*		if ((resp_group_id != "") && (!unlock_yn.equals("Y")) && password_value_Y.equals("Y"))
					{	 
					String valcal = "select SM_VALIDATE_USER.PASS_VALID_CHECK(?, ?) FROM dual";
					cs1=con.prepareStatement(valcal);
					cs1.setString ( 1,appl_user_id   ) ;
					//Maheshwaran modified for the MMS-QH-CRF-0149
					if(case_sensitive_password_yn.equals("N"))
						{
						cs1.setString ( 2,appl_user_password.toUpperCase()) ;
						}
					else
						{
						cs1.setString ( 2,appl_user_password) ;
						}
					if(rs!=null) rs.close();
					rs = cs1.executeQuery();
					if (rs != null && rs.next())
						{
						user_status = rs.getString(1) == null ? "" : rs.getString(1);
						}
					if (rs != null)
						rs.close();
					if (cs1 != null)
						cs1.close();
					if(user_status.equals("CANNOT_REUSE:1"))
						{
						java.util.Hashtable message = MessageManager.getMessage(locale,"CANNOT_REUSE:1", "SM");
						sb.append( (String) message.get("message") ) ;
						message.clear();
						updatable = false ;
						}
					else if(user_status.equals("CANNOT_REUSE:2"))
						{
						java.util.Hashtable message = MessageManager.getMessage(locale,"CANNOT_REUSE:2", "SM");
						sb.append( (String) message.get("message") ) ;
						message.clear();
						updatable = false ;
						}	
					else if(user_status.equals("CANNOT_REUSE:3"))
						{
						java.util.Hashtable message = MessageManager.getMessage(locale,"CANNOT_REUSE:3", "SM");
						sb.append( (String) message.get("message") ) ;
						message.clear();
						updatable = false ;
						}		
					}*/
				//End
    			if(connection_pooling_yn.equals("Y")) 
			     {String sql_ora=" Select APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) from sm_ora_role where ora_role_id='MEDADMIN' ";
				if(pstmt!=null) pstmt.close();
				pstmt=con.prepareStatement(sql_ora);
				rs_ora=pstmt.executeQuery();
				if(rs_ora!=null)
				{ while(rs_ora.next())
				 {ora_role_password=rs_ora.getString(1);
				 } rs_ora.close();
				}else{
					sb.append("Record not Found For the Role MEDADMIN");
				}
				if(ora_role_password !=null && !ora_role_password.equals("")){
					try{
						sql_ora="Set Role MEDADMIN identified by "+ora_role_password;
						if(pstmt!=null) pstmt.close();
						pstmt=con.prepareStatement(sql_ora);
						pstmt.execute();
					}catch(Exception pswd){
						sb.append(pswd.getMessage());
					}
				}else{
					try{
						sql_ora="Set Role MEDADMIN";
						if(pstmt!=null) pstmt.close();
						pstmt=con.prepareStatement(sql_ora);
						pstmt.execute();
					}catch(Exception pswd){
						sb.append(pswd.getMessage());
					}
				}
		   if(!funcroleid.equals("") && funcrole.equals("P")){
		       if(!funcroleid.equalsIgnoreCase(func_id))
		   {	try{   String duplfuncrole1 = "select 1 from sm_appl_user where func_role_id = ?";
			    pstmt2 = con.prepareStatement( duplfuncrole1 ) ;
			    pstmt2.setString( 1, funcroleid ) ;
    		    rs2= pstmt2.executeQuery() ;
			    if ( rs2.next() ) {
			    updatable = false ;
		    	java.util.Hashtable message = MessageManager.getMessage(locale,"PRACT_ATTACHED_TO_USER", "SM");
		    	sb.append( (String) message.get("message") ) ;message.clear();
			 }	}catch(Exception e)
				{	updatable = false ;
					sb.append( e.getMessage()) ;
			    	e.printStackTrace() ;
				}
				if(rs2!=null) rs2.close(); //checklist
				if(pstmt2!=null) pstmt2.close(); //checklist
			}}
			else if(!funcroleid.equals("") && funcrole.equals("O")){
				if(!funcroleid.equalsIgnoreCase(func_id))
		   {	try{   String duplfuncrole1 = "select 1 from sm_appl_user where func_role_id = ?";
			    pstmt2 = con.prepareStatement( duplfuncrole1 ) ;
			    pstmt2.setString( 1, funcroleid ) ;
    		    rs2= pstmt2.executeQuery() ;
			    if ( rs2.next() ) {
			    updatable = false ;
		    	java.util.Hashtable message = MessageManager.getMessage(locale,"OTHERSTAFF_ATTACHED_TO_USER", "SM");
		    	sb.append( (String) message.get("message") ) ;message.clear();
			 }	}catch(Exception e)
				{	updatable = false ;
					sb.append( e.getMessage()) ;
			    	e.printStackTrace() ;
				}
			}
			}}
			con.setAutoCommit(false);
			if ( updatable ) {
			try{if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement( sql );
				pstmt.setString	( 1, appl_user_name ) ;
				//Maheshwaran modified for the MMS-QH-CRF-0149
				if(case_sensitive_password_yn.equals("N"))
					{
					pstmt.setString	( 2, appl_user_password.toUpperCase()) ;
					}
				else
					{
					pstmt.setString	( 2, appl_user_password) ;
					}
				pstmt.setString	( 3, rep_facility_id) ;
				pstmt.setString	( 4, contact_tel_no) ;
				pstmt.setString	( 5, contact_fax_no) ;
				pstmt.setString	( 6, email_id) ;
				pstmt.setString	( 7, resp_group_id) ;
				pstmt.setString	( 8, employee_no) ;
				pstmt.setDate	( 9, effective_date_from  ) ;
				pstmt.setDate	( 10, effective_date_to  ) ;
				pstmt.setString	( 11, effectiveStatus ) ;
				pstmt.setString	( 12, funcroleid ) ;
				pstmt.setString	( 13, funcrole) ;
				pstmt.setString	( 14, modifiedById ) ;
				pstmt.setString	( 15, modifiedAtWorkstation ) ;
				pstmt.setString	( 16, appl_pin_no ) ;
				pstmt.setString	( 17, responsibility_group) ; //Modified by Suji Keerthi for MMS-MD-SCF-0173
				pstmt.setString	( 18, reports_home_dir) ;
				pstmt.setString	( 19, language_id ) ;
				//Added by Maheshwaran K for the Password Validation as on 11/07/2012
				//Start
				pstmt.setString	( 20, wsno) ;
				//End
				pstmt.setString	( 21, long_name ) ;
				pstmt.setString ( 22, active_dir_id);
				pstmt.setString ( 23, first_login_yn);//Maheshwaran added for the MMS-QH-CRF-0149
				pstmt.setString ( 24, link_ad_user);//Added by Kamatchi S for ML-MMOH-CRF-1844

				if(!effectiveStatus.equals(curr_effstatus) && effectiveStatus.equals("E"))
				{
					pstmt.setTimestamp ( 25, enable_date_time);
					pstmt.setString	( 26, appl_user_id ) ;
					
				}else
				{
					pstmt.setString	( 25, appl_user_id ) ;
				}
				
				int res = pstmt.executeUpdate() ;
				if (unlock_yn=="Y" || unlock_yn.equals("Y")){}
				else
				{
				if(password_status !=null && password_status.equals("N")){
			//	try{
					String sql4=" Alter user  "+appl_user_id+" identified by "+'"'+""+appl_user_password.toUpperCase()+""+'"'+"";
					//Maheshwaran modified for the MMS-QH-CRF-0149
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( sql4 );
					pstmt.execute();
				//	}
				//catch(Exception e)	
				//	{}
				}
				}
				if (unlock_yn=="Y" || unlock_yn.equals("Y")){
					String sql6=" Alter user  "+appl_user_id+" account unlock";
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( sql6 );
					pstmt.execute();
					if(password_status !=null && password_status.equals("N")){
					//try{
					String sql7=" Alter user  "+appl_user_id+" identified by "+'"'+""+appl_user_password.toUpperCase()+""+'"'+"";
					//Maheshwaran modified for the MMS-QH-CRF-0149
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement( sql7 );
					pstmt.execute();
				//	}
				//	catch(Exception e){}
					}
				}
			   /*if(resource_status !=null && resource_status.equals("N")){
				   if (resp_group_id !=null &&  !resp_group_id.equals("")){
					   String sql5=" Alter user  "+appl_user_id+" profile "+resp_group_id;
						if(pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement( sql5);
						pstmt.execute();
						pstmt.close();
					}else {
					try
						{
						String sql5=" Alter user  "+appl_user_id+" profile default";
						if(pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement( sql5);
						pstmt.execute();
						pstmt.close();
						}
					catch(Exception e)	
						{}
					}
				}	*/
				if ( res != 0 ) {
				result = true ;
                 System.err.println("628-------------SMUSERMANAGERJAVA----------effectiveStatus------>"+effectiveStatus);
				/*Added by Ashwini on 20-Jul-2020 for AMS-SCF-0888*/
				if(!effectiveStatus.equals(curr_effstatus))
				{
				 String sql2="";
				 System.err.println("633-------------SMUSERMANAGERJAVA----------effectiveStatus------>"+effectiveStatus);
				   if(effectiveStatus.equals("E"))
				   {
					   try
						{System.err.println("637-------try-------SMUSERMANAGERJAVA---------------->");
						  sql2 = " GRANT CONNECT, RESOURCE TO "+appl_user_id;
						  System.err.println("636--------------SMUSERMANAGERJAVA--------sql2-------->"+sql2);
					  if(pstmt!=null) pstmt.close();
					  pstmt = con.prepareStatement( sql2 );
					  System.err.println("642-------before execute-------SMUSERMANAGERJAVA---------------->");
					  pstmt.executeUpdate(); 
					  System.err.println("644-------after execute--------SMUSERMANAGERJAVA---------------->");
					  }
					  catch(Exception ex)
						{System.err.println("647-------catch-------SMUSERMANAGERJAVA---------------->"+ex.getMessage());
						ex.printStackTrace();
						}
						
					  if (pstmt!=null)pstmt.close();

					  try
					  {System.err.println("654-------try-------SMUSERMANAGERJAVA----------------");
					  sql2 = " GRANT CREATE SESSION TO "+appl_user_id;
					  System.err.println("656--------------SMUSERMANAGERJAVA----------sql2------>"+sql2);
					  if(pstmt!=null) pstmt.close();
					  pstmt = con.prepareStatement( sql2 );
					  System.err.println("659-------before execute-------SMUSERMANAGERJAVA----------------");
					  pstmt.executeUpdate(); 
					  System.err.println("661-------after execute-------SMUSERMANAGERJAVA----------------");
					  }
					  catch(Exception ex)
						{System.err.println("664-------catch-------SMUSERMANAGERJAVA---------------->"+ex.getMessage());
						ex.printStackTrace();
						}
						
					  if (pstmt!=null)pstmt.close();

					  try{System.err.println("670-------try-------SMUSERMANAGERJAVA----------------");
					  sql2 = " GRANT MEDSTARTUP,MEDUSERS TO "+appl_user_id;
					  System.err.println("672--------------SMUSERMANAGERJAVA----------sql2------>"+sql2);
					  if(pstmt!=null) pstmt.close();
					  pstmt = con.prepareStatement( sql2 );
					   System.err.println("675-------before execute-------SMUSERMANAGERJAVA----------------");
					  pstmt.executeUpdate();
					   System.err.println("677-------after execute-------SMUSERMANAGERJAVA----------------");
					  }
					  catch(Exception ex)
						{System.err.println("680-------catch-------SMUSERMANAGERJAVA---------------->"+ex.getMessage());
						ex.printStackTrace();
						}
						
					  if (pstmt!=null)pstmt.close();
					   
					  sql2 = " ALTER USER "+appl_user_id+" DEFAULT ROLE MEDSTARTUP ";
					   System.err.println("687--------------SMUSERMANAGERJAVA----------sql2------>"+sql2);
					}
					else
				   {
					  sql2 = " GRANT CONNECT, RESOURCE, CREATE SESSION, MEDSTARTUP,MEDUSERS TO "+appl_user_id;
					  System.err.println("692--------------SMUSERMANAGERJAVA----------sql2------>"+sql2);
					  if(pstmt!=null) pstmt.close();
					  pstmt = con.prepareStatement( sql2 );
					  System.err.println("695-------before execute-------SMUSERMANAGERJAVA----------------");
					  pstmt.executeUpdate();
					  System.err.println("697-------after execute-------SMUSERMANAGERJAVA----------------");
					  if (pstmt!=null)pstmt.close();

					  sql2 = " REVOKE CONNECT, RESOURCE, CREATE SESSION, MEDSTARTUP,MEDUSERS FROM "+appl_user_id;
					  System.err.println("700--------------SMUSERMANAGERJAVA----------sql2------>"+sql2);
				   }
				   if(pstmt!=null) pstmt.close();
				   try{
				   pstmt = con.prepareStatement( sql2 );
				   System.err.println("705-------before execute-------SMUSERMANAGERJAVA----------------");
				   pstmt.executeUpdate();
				    System.err.println("707-------after execute-------SMUSERMANAGERJAVA----------------");
				   }
				   catch(Exception ex)
						{System.err.println("710-------catch-------SMUSERMANAGERJAVA---------------->"+ex.getMessage());
						ex.printStackTrace();
						}
				   if (pstmt!=null)pstmt.close();
				}
				/*End AMS-SCF-0888*/

				java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED", "SM");
				sb.append( (String) message.get("message") ) ;
				message.clear();
				con.commit();
	 		}
			else
				{   
				con.rollback();
				}
				}catch ( Exception e ) {
				System.err.println("727-------catch-------SMUSERMANAGERJAVA---------------->"+e.getMessage());
				sb.append( e.getMessage()) ;
				e.printStackTrace() ;
				try{
					con.rollback();
				}catch(Exception ce){
					System.err.println("733-------catch-------SMUSERMANAGERJAVA---------------->"+ce.getMessage());
					ce.printStackTrace();
				}
				}	
			}	if(rs_ora !=null) rs_ora.close();
				if(rs2 !=null) rs2.close();
				if(pstmt !=null) pstmt.close();
				if(pstmt2 !=null) pstmt2.close();
			}catch ( Exception e ) {
				System.err.println("742-------catch-------SMUSERMANAGERJAVA---------------->"+e.getMessage());
				sb.append( e.getMessage()) ;
				e.printStackTrace() ;
				try{
					con.rollback();		
			}catch ( Exception e1 ) {
				System.err.println("748-------catch-------SMUSERMANAGERJAVA---------------->"+e1.getMessage());
				e1.printStackTrace() ;
			}} 
           }catch ( Exception e ) {
			    System.err.println("752-------catch-------SMUSERMANAGERJAVA---------------->"+e.getMessage());
				sb.append( e.getMessage()) ;
				e.printStackTrace() ;
				try{
					con.rollback();
				}catch(Exception ce){
					System.err.println("758-------catch-------SMUSERMANAGERJAVA---------------->"+ce.getMessage());
					ce.printStackTrace();
				}
		   } finally {
			  if (con != null)
			  {  try {ConnectionManager.returnConnection(con,p);	
		       } catch (Exception ee) {}
		      }}
			 results.put( "status", new Boolean(result) ) ;
		     results.put( "error", sb.toString() ) ;
		     tabdata1.clear();
			 sb.setLength(0);
			 return results ;
	}}
