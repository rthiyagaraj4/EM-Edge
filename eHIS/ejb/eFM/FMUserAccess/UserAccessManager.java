/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMUserAccess;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import java.io.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import java.util.*;

/**
*
* @ejb.bean
*	name="UserAccessManager"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="UserAccessManager"
*	local-jndi-name="UserAccessManager"
*	impl-class-name="eFM.FMUserAccess.UserAccessManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMUserAccess.UserAccessManagerLocal"
*	remote-class="eFM.FMUserAccess.UserAccessManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMUserAccess.UserAccessManagerLocalHome"
*	remote-class="eFM.FMUserAccess.UserAccessManagerHome"
*	generate= "local,remote"
*
*
*/

public class UserAccessManager implements SessionBean 
{

	Connection con;
	PreparedStatement pstmt;	
	PreparedStatement pstmt2;	
	
	String sql_chek							= "";	
	String transfer_file_yn_prop			= "";
	String assign_fs_locn_prop				= "";
	String change_fs_locn_prop				= "";
	String req_across_facilities_yn_prop	= "";
	String iss_yn_prop						= "";
	String iss_across_facilities_yn_prop	= "";
	String deficiency_check_yn_prop			= "";
	String track_out_to_opd_yn_prop			= "";
	String track_out_to_ipw_yn_prop			= "";
	String receive_file_yn_prop				= "";
	String return_file_yn_prop				= "";
	String change_return_date_yn_prop		= "";	
	String file_lost_found_yn_prop			= ""; 
	String confirm_receipt_file_yn_prop		= "";
	String req_yn_prop						= "";
	String manual_request_yn_prop			= "";
	String cancel_request_yn_prop			= "";
	String CREATE_FILE_VOLUME_YN_prop	= "";
	String facilityId						= "";
	String appl_user_id						= "";					         
	String fs_locn_code						= "";
	String access_all						= "";
	String assign_fs_locn					= "";          
	String change_fs_locn					= "";          
	String req_yn							= "";          
	String req_across_facilities_yn			= ""; 
	String manual_request_yn				= "";
	String cancel_request_yn				= "";
	String CREATE_FILE_VOLUME_YN			= "";
	String iss_yn							= "";    
	String iss_across_facilities_yn			= "";   
	String change_return_date_yn			= "";    
	String deficiency_check_yn				= "";    
	String file_lost_found_yn				= "";    
	String track_out_to_opd_yn				= "";
	String track_out_to_ipw_yn				= "";
	String receive_file_yn					= "";
	String return_file_yn					= "";
	String confirm_receipt_file_yn			= ""; 
	String transfer_file_yn					= "";
	String locn_identity					= "";
	String all_fs_locn_codes				= "";
	String addedAtWorkstation				= "";
	String locale				= "";

	SessionContext ctx;		

	public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS";
	public final String RECORD_INSERTED		= "RECORD_INSERTED";
	public final String RECORD_MODIFIED		= "RECORD_MODIFIED";
	public final String RECORD_DELETED		= "RECORD_DELETED";
	

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}

	public void setSessionContext(SessionContext context) 
	{
		this.ctx=context;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertUserAccess(java.util.Properties p,java.util.HashMap insUserAccess) 
	{
		java.util.HashMap results = new java.util.HashMap();

		boolean result		= false;
		boolean insertable	= true;
		
		int res_for_all = 0;

		StringBuffer sb = new StringBuffer("");
		

		facilityId					= (String) insUserAccess.get ( "facilityId" );
		appl_user_id				= (String) insUserAccess.get ( "appl_user_id" );
		fs_locn_code				= (String) insUserAccess.get ( "fs_locn_code" );
		access_all					= (String) insUserAccess.get ( "access_all" );
		assign_fs_locn				= (String) insUserAccess.get ( "assign_fs_locn" );
		change_fs_locn				= (String) insUserAccess.get ( "change_fs_locn" );
		req_yn						= (String) insUserAccess.get ( "req_yn" );
		req_across_facilities_yn	= (String) insUserAccess.get ( "req_across_facilities_yn" );
		manual_request_yn			= (String) insUserAccess.get ( "manual_request_yn" );
		cancel_request_yn			= (String) insUserAccess.get ( "cancel_request_yn" );
		CREATE_FILE_VOLUME_YN	= (String) insUserAccess.get ( "CREATE_FILE_VOLUME_YN" );
		iss_yn						= (String) insUserAccess.get ( "iss_yn" );
		iss_across_facilities_yn	= (String) insUserAccess.get ( "iss_across_facilities_yn" );
		change_return_date_yn		= (String) insUserAccess.get ( "change_return_date_yn" );
		deficiency_check_yn			= (String) insUserAccess.get ( "deficiency_check_yn" );
		file_lost_found_yn			= (String) insUserAccess.get ( "file_lost_found_yn" );
		track_out_to_opd_yn			= (String) insUserAccess.get ( "track_out_to_opd_yn" );
		track_out_to_ipw_yn			= (String) insUserAccess.get ( "track_out_to_ipw_yn" );
		receive_file_yn				= (String) insUserAccess.get ( "receive_file_yn" );
		return_file_yn				= (String) insUserAccess.get ( "return_file_yn" );
		confirm_receipt_file_yn		= (String) insUserAccess.get ( "confirm_receipt_file_yn" );
		transfer_file_yn			= (String) insUserAccess.get ( "transfer_file_yn" );
		locn_identity				= (String) insUserAccess.get ( "locn_identity" );
		all_fs_locn_codes			= (String) insUserAccess.get ( "all_fs_locn_codes" );
		addedAtWorkstation			= (String) insUserAccess.get ( "addedAtWorkstation" );
		locale			= (String) insUserAccess.get ( "locale" );
		con				= ConnectionManager.getConnection(p);


		if(access_all.equals("Y") && (locn_identity.equals("AID")))
		{
			try
			{
				
								
				String sqlDelete = "delete from fm_user_access_rights where facility_id = ? and appl_user_id = ?";
				
				try
				{
					PreparedStatement pstmt_del = con.prepareStatement(sqlDelete);
					pstmt_del.setString	( 1, facilityId ) ;
					pstmt_del.setString	( 2, appl_user_id) ;
					
					pstmt_del.executeUpdate() ;
					
					pstmt_del.close() ;
				}
				catch(Exception edel)
				{
					sb.append( edel.getMessage() + "<br>" ) ;
					edel.printStackTrace() ;
					try
					{
						con.rollback();
					}
					catch (Exception ce){
					sb.append("While Rollback of deleting records for insert :"+ ce.getMessage());
					}
				}

				transfer_file_yn_prop			= transfer_file_yn;
				assign_fs_locn_prop				= assign_fs_locn;
				change_fs_locn_prop				= change_fs_locn;
				req_across_facilities_yn_prop	= req_across_facilities_yn;
				iss_yn_prop						= iss_yn;
				iss_across_facilities_yn_prop	= iss_across_facilities_yn;
				deficiency_check_yn_prop		= deficiency_check_yn;
				track_out_to_opd_yn_prop		= track_out_to_opd_yn;
				track_out_to_ipw_yn_prop		= track_out_to_ipw_yn;
				receive_file_yn_prop			= receive_file_yn;
				change_return_date_yn_prop		= change_return_date_yn;
				file_lost_found_yn_prop			= file_lost_found_yn;
				confirm_receipt_file_yn_prop	= confirm_receipt_file_yn;
				req_yn_prop						= req_yn;
				manual_request_yn_prop			= manual_request_yn;
				cancel_request_yn_prop			= cancel_request_yn;
				CREATE_FILE_VOLUME_YN_prop		= CREATE_FILE_VOLUME_YN;
				return_file_yn_prop				= return_file_yn;
				

				String sql = "insert into fm_user_access_rights ( facility_id,appl_user_id,fs_locn_code,assign_fs_locn_yn,change_fs_locn_yn,req_yn,req_across_facilities_yn,manual_request_yn,cancel_request_yn,iss_yn,iss_across_facilities_yn,CREATE_FILE_VOLUME_YN,change_return_date_yn,deficiency_check_yn,Change_file_status_yn,track_out_to_opd_yn,track_out_to_ipw_yn,receive_file_yn,return_file_yn, confirm_receipt_file_yn,transfer_file_yn,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id, modified_date,modified_at_ws_no,modified_facility_id ) values  (?,?,'*ALL','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y',?,sysdate,?,?,?,sysdate,?,?) ";

				String addedById				= p.getProperty( "login_user" ) ;
				String modifiedById				= addedById ;				
				String modifiedAtWorkstation	= addedAtWorkstation ;				
				

				if(insertable)
				{
					try
					{
						pstmt = con.prepareStatement( sql );
						pstmt.setString	( 1, facilityId) ;
						pstmt.setString	( 2, appl_user_id) ;						
						pstmt.setString ( 3, addedById ) ;
						pstmt.setString	( 4, addedAtWorkstation ) ;
						pstmt.setString	( 5, facilityId ) ;
						pstmt.setString	( 6, modifiedById ) ;
						pstmt.setString	( 7,modifiedAtWorkstation) ;
						pstmt.setString	( 8,facilityId) ;

						int res = pstmt.executeUpdate() ;

						res_for_all = res;

						if(pstmt != null) pstmt.close();
						insUserAccess.clear();
					}
					catch ( Exception e ) 
					{
						sb.append( e.getMessage() + "<br>" ) ;
						e.printStackTrace() ;
						try
						{
							con.rollback();
						}
						catch (Exception ce){
						sb.append(" Rollback while setting values for insert :"+ ce.getMessage());
						}
					}
				}//insertable
				if ( res_for_all != 0  )
				{
					result = true ;
					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED, "SM" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit();
					message.clear();
				}
			}//try
			catch(Exception pswd)
			{
				sb.append(pswd.getMessage());
			}
			finally
			{
				if (con != null)
				{					
						 ConnectionManager.returnConnection(con,p);					
				}
			}
		}
		else if(access_all.equals("Y") && (!locn_identity.equals("AID")))
		{
			try
			{
	//			con = ConnectionManager.getConnection(p);
				ResultSet rs_chk_locn = null;
			
				try
				{
					StringTokenizer indtoken = new StringTokenizer(all_fs_locn_codes, "|");

					String p_fs_locn_code = "",sql = "";
					int p_chk_rec = 0;

					sql_chek = "select 1 from fm_user_access_rights where facility_id= ? and appl_user_id= ? and fs_locn_code = ? union select 1 from fm_user_access_rights where appl_user_id = ? and  fs_locn_code = '*ALL' and facility_id = ?"; 
					pstmt2 = con.prepareStatement(sql_chek);

					sql = " insert into fm_user_access_rights (facility_id,appl_user_id,fs_locn_code,assign_fs_locn_yn,change_fs_locn_yn,req_yn,req_across_facilities_yn,manual_request_yn,cancel_request_yn,iss_yn,iss_across_facilities_yn,CREATE_FILE_VOLUME_YN,change_return_date_yn,deficiency_check_yn,Change_file_status_yn,track_out_to_opd_yn,track_out_to_ipw_yn,receive_file_yn,return_file_yn, confirm_receipt_file_yn, transfer_file_yn,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id, modified_date,modified_at_ws_no,modified_facility_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?) ";
					pstmt = con.prepareStatement(sql);

					while(indtoken.hasMoreTokens())
					{
						p_fs_locn_code		= indtoken.nextToken();

						pstmt2.setString(1,facilityId);
						pstmt2.setString(2,appl_user_id);
						pstmt2.setString(3,p_fs_locn_code);
						pstmt2.setString(4,appl_user_id);
						pstmt2.setString(5,facilityId);
						rs_chk_locn = pstmt2.executeQuery();
						
						while (rs_chk_locn.next())
						{
							p_chk_rec= rs_chk_locn.getInt(1);
						}
						if(rs_chk_locn != null) rs_chk_locn.close();

						if(p_chk_rec != 1)
						{
							if(locn_identity.equals("P"))
							{
								transfer_file_yn_prop			= "N";
								assign_fs_locn_prop				= "Y";
								change_fs_locn_prop				= "Y";
								req_across_facilities_yn_prop	= "Y";
								iss_yn_prop						= "Y";
								iss_across_facilities_yn_prop	= "Y";
								deficiency_check_yn_prop		= "Y";
								track_out_to_opd_yn_prop		= "Y";
								track_out_to_ipw_yn_prop		= "Y";
								receive_file_yn_prop			= "Y";
								change_return_date_yn_prop		= "Y";
								file_lost_found_yn_prop			= "Y";
								confirm_receipt_file_yn_prop	= "Y";
								req_yn_prop						= "Y";
								manual_request_yn_prop			= "Y";
								cancel_request_yn_prop			= "Y";
								CREATE_FILE_VOLUME_YN_prop		= "Y";
								return_file_yn_prop			= "Y";
							}
							else if(locn_identity.equals("D"))
							{
							//	transfer_file_yn_prop			= transfer_file_yn;
								transfer_file_yn_prop			="Y"; 
								assign_fs_locn_prop				= assign_fs_locn;
								change_fs_locn_prop				= change_fs_locn;
								req_across_facilities_yn_prop	= req_across_facilities_yn;
								iss_yn_prop						= iss_yn;
								iss_across_facilities_yn_prop	= iss_across_facilities_yn;
								deficiency_check_yn_prop		= deficiency_check_yn;
								track_out_to_opd_yn_prop		= track_out_to_opd_yn;
								track_out_to_ipw_yn_prop		= track_out_to_ipw_yn;
								receive_file_yn_prop			= receive_file_yn;
								change_return_date_yn_prop		= change_return_date_yn;
								file_lost_found_yn_prop			= file_lost_found_yn;
								confirm_receipt_file_yn_prop	= "Y";
								req_yn_prop						= "Y";
								manual_request_yn_prop			= "Y";
								cancel_request_yn_prop			= "Y";
								CREATE_FILE_VOLUME_YN_prop		= CREATE_FILE_VOLUME_YN;
								//return_file_yn_prop				= return_file_yn;
							      return_file_yn_prop				=  "Y";
							}
							else 
							{
								transfer_file_yn_prop			= "Y";
								assign_fs_locn_prop				= assign_fs_locn;
								change_fs_locn_prop				= change_fs_locn;
								req_across_facilities_yn_prop	= req_across_facilities_yn;
								iss_yn_prop						= iss_yn;
								iss_across_facilities_yn_prop	= iss_across_facilities_yn;
								deficiency_check_yn_prop		= deficiency_check_yn;
								track_out_to_opd_yn_prop		= track_out_to_opd_yn;
								track_out_to_ipw_yn_prop		= track_out_to_ipw_yn;
								receive_file_yn_prop			= receive_file_yn;
								change_return_date_yn_prop		= change_return_date_yn;
								file_lost_found_yn_prop			= file_lost_found_yn;
								confirm_receipt_file_yn_prop	= "Y";
								req_yn_prop						= "Y";
								manual_request_yn_prop			= "Y";
								cancel_request_yn_prop			= "Y";
								CREATE_FILE_VOLUME_YN_prop		= CREATE_FILE_VOLUME_YN;
								return_file_yn_prop				= return_file_yn;
						  
							}
							
							String addedById = p.getProperty( "login_user" ) ;
							String modifiedById = addedById ;							
							String modifiedAtWorkstation = addedAtWorkstation ;							
							

							if(insertable)
							{
								try
								{
									pstmt.setString	( 1, facilityId) ;
									pstmt.setString	( 2, appl_user_id) ;
									pstmt.setString ( 3, p_fs_locn_code) ;
									pstmt.setString ( 4, assign_fs_locn_prop ) ;
									pstmt.setString ( 5, change_fs_locn_prop ) ;
									pstmt.setString ( 6, req_yn_prop ) ;
									pstmt.setString ( 7, req_across_facilities_yn_prop ) ;
									pstmt.setString ( 8, manual_request_yn_prop ) ;
									pstmt.setString ( 9, cancel_request_yn_prop ) ;
									pstmt.setString ( 10, iss_yn_prop ) ;
									pstmt.setString ( 11, iss_across_facilities_yn_prop ) ;
									pstmt.setString ( 12, CREATE_FILE_VOLUME_YN_prop ) ;
									pstmt.setString ( 13, change_return_date_yn_prop ) ;
									pstmt.setString ( 14, deficiency_check_yn_prop ) ;
									pstmt.setString ( 15, file_lost_found_yn_prop ) ;
									pstmt.setString ( 16, track_out_to_opd_yn_prop ) ;					
									pstmt.setString ( 17, track_out_to_ipw_yn_prop ) ;					
									pstmt.setString ( 18, receive_file_yn_prop  ) ;
									pstmt.setString ( 19, return_file_yn_prop  ) ;
									pstmt.setString ( 20, confirm_receipt_file_yn_prop  ) ;
									pstmt.setString ( 21, transfer_file_yn_prop ) ;
									pstmt.setString ( 22, addedById ) ;	
									pstmt.setString	( 23, addedAtWorkstation ) ;
									pstmt.setString	( 24, facilityId ) ;
									pstmt.setString	( 25, modifiedById ) ;	
									pstmt.setString	( 26,modifiedAtWorkstation) ;
									pstmt.setString	( 27,facilityId) ;

									int res = pstmt.executeUpdate() ;
								
									res_for_all= res;
								}
								catch ( Exception e ) 
								{
									sb.append( e.getMessage() + "<br>" ) ;
									e.printStackTrace() ;
									try
									{
										con.rollback();
									}
									catch (Exception ce){
									sb.append(" Rollback while setting values for insert2 :"+ ce.getMessage());
									}
								}
							}//insertable
						}										
					}
						
					if(res_for_all != 0)
					{
						result = true ;
						java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED, "SM" ) ;
						sb.append( (String) message.get("message") ) ;
						con.commit();
						message.clear();
					}
					else
					{
						insertable = false ;
						java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS, "Common" ) ;
						sb.append( (String) message.get("message") ) ;
						message.clear();
					}
				}
				catch(Exception edel)
				{
					sb.append( edel.getMessage() + "<br>" ) ;
					edel.printStackTrace() ;
					try
					{
						con.rollback();
					}
					catch (Exception ce){
					sb.append(" Rollback while setting values for insertMain :"+ ce.getMessage());
					}
				}
				if(pstmt != null) pstmt.close();
				if(pstmt2 != null) pstmt2.close();
			}//try
			catch(Exception pswd)
			{
				sb.append(pswd.getMessage());
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con,p);
					
			}
		}
		else
		{
			String sql = "insert into fm_user_access_rights ( facility_id,appl_user_id,fs_locn_code,assign_fs_locn_yn,change_fs_locn_yn,req_yn,req_across_facilities_yn,manual_request_yn,cancel_request_yn,iss_yn,iss_across_facilities_yn,CREATE_FILE_VOLUME_YN,change_return_date_yn,deficiency_check_yn,Change_file_status_yn,track_out_to_opd_yn,track_out_to_ipw_yn,receive_file_yn,return_file_yn, confirm_receipt_file_yn, transfer_file_yn,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id, modified_date,modified_at_ws_no,modified_facility_id ) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?) ";
						
			con = ConnectionManager.getConnection(p);	
			
			String addedById				= p.getProperty( "login_user" ) ;
			String modifiedById				= addedById ;			
			String modifiedAtWorkstation	= addedAtWorkstation ;			
			

			try
			{					

				String duplicateSql = "select 1 from  fm_user_access_rights where appl_user_id = ? and  fs_locn_code = '*ALL' and facility_id = ? union select 1 from fm_user_access_rights  where appl_user_id = ? and fs_locn_code = ? and facility_id = ? " ;
			
				pstmt = con.prepareStatement(duplicateSql);

				pstmt.setString( 1, appl_user_id );				
				pstmt.setString( 2, facilityId);
				pstmt.setString( 3, appl_user_id);				
				pstmt.setString( 4, fs_locn_code);
				pstmt.setString( 5, facilityId);

				ResultSet rs = pstmt.executeQuery() ;

				if(rs.next())
				{				
					insertable = false ;
					java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS, "Common" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
				}

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}
			catch(Exception e)
			{
				insertable = false ;
				sb.append( e+ "<br>" ) ;
				e.printStackTrace() ;

				if (con != null)
				{					
					ConnectionManager.returnConnection(con,p);					
				}
			}
			if ( insertable )
			{	
				try
				{
					pstmt = con.prepareStatement( sql );
					pstmt.setString	 ( 1, facilityId) ;
					pstmt.setString	 ( 2, appl_user_id);
					pstmt.setString  ( 3, fs_locn_code );
					pstmt.setString  ( 4, assign_fs_locn );
					pstmt.setString  ( 5, change_fs_locn );
					pstmt.setString  ( 6, req_yn );
					pstmt.setString  ( 7, req_across_facilities_yn );
					pstmt.setString	 ( 8, manual_request_yn );
					pstmt.setString	 ( 9, cancel_request_yn );
					pstmt.setString  ( 10, iss_yn );
					pstmt.setString  ( 11, iss_across_facilities_yn );
					pstmt.setString	 ( 12, CREATE_FILE_VOLUME_YN );
					pstmt.setString  ( 13, change_return_date_yn );
					pstmt.setString  ( 14, deficiency_check_yn );
					pstmt.setString  ( 15, file_lost_found_yn );
					pstmt.setString  ( 16, track_out_to_opd_yn );					
					pstmt.setString  ( 17, track_out_to_ipw_yn );					
					pstmt.setString  ( 18, receive_file_yn  ) ;
					pstmt.setString  ( 19, return_file_yn  ) ;
					pstmt.setString  ( 20, confirm_receipt_file_yn );
					pstmt.setString  ( 21, transfer_file_yn );					
					pstmt.setString  ( 22, addedById );
					pstmt.setString	 ( 23, addedAtWorkstation );
					pstmt.setString	 ( 24, facilityId );
					pstmt.setString	 ( 25, modifiedById );
					pstmt.setString	 ( 26,modifiedAtWorkstation);
					pstmt.setString	 ( 27,facilityId);

					int res = pstmt.executeUpdate() ;

				if ( res != 0  )
				{
					result = true ;
					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED, "SM" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit();
					message.clear();
				}
				if(pstmt != null) pstmt.close();
			}
			catch ( Exception e ) {
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			try
			{
				con.rollback();
			}
			catch (Exception ce){
			sb.append("While Rollback of insert :"+ ce.getMessage());
			}
		}
		finally 
		{
			if (con != null)
			{				
				ConnectionManager.returnConnection(con,p);				  
			}
			}
		}
	}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	return results ;
}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap updateUserAccess(java.util.Properties p,java.util.HashMap	htUserAccess)
	{
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result		= false ;
		boolean updatable	= true ;

		facilityId					= (String) htUserAccess.get ( "facilityId" );
		appl_user_id				= (String) htUserAccess.get ( "appl_user_id" );
		fs_locn_code				= (String) htUserAccess.get ( "fs_locn_code" );			
		assign_fs_locn				= (String) htUserAccess.get ( "assign_fs_locn" );
		change_fs_locn				= (String) htUserAccess.get ( "change_fs_locn" );
		req_yn						= (String) htUserAccess.get ( "req_yn" );
		req_across_facilities_yn	= (String) htUserAccess.get ( "req_across_facilities_yn" );
		manual_request_yn			= (String) htUserAccess.get ( "manual_request_yn" );
		cancel_request_yn			= (String) htUserAccess.get ( "cancel_request_yn" );
		CREATE_FILE_VOLUME_YN		= (String) htUserAccess.get ( "CREATE_FILE_VOLUME_YN" );
		iss_yn						= (String) htUserAccess.get ( "iss_yn" );
		iss_across_facilities_yn	= (String) htUserAccess.get ( "iss_across_facilities_yn" );
		change_return_date_yn		= (String) htUserAccess.get ( "change_return_date_yn" );
		deficiency_check_yn			= (String) htUserAccess.get ( "deficiency_check_yn" );
		file_lost_found_yn			= (String) htUserAccess.get ( "file_lost_found_yn" );
		track_out_to_opd_yn			= (String) htUserAccess.get ( "track_out_to_opd_yn" );
		track_out_to_ipw_yn			= (String) htUserAccess.get ( "track_out_to_ipw_yn" );
		receive_file_yn				= (String) htUserAccess.get ( "receive_file_yn" );
		return_file_yn				= (String) htUserAccess.get ( "return_file_yn" );
		confirm_receipt_file_yn		= (String) htUserAccess.get ( "confirm_receipt_file_yn" );
		transfer_file_yn			= (String) htUserAccess.get ( "transfer_file_yn" );
		locn_identity				= (String) htUserAccess.get ( "locn_identity" );
		all_fs_locn_codes			= (String) htUserAccess.get ( "all_fs_locn_codes" );
		addedAtWorkstation			= (String) htUserAccess.get ( "addedAtWorkstation" );

		htUserAccess.clear();
		StringBuffer sb = new StringBuffer( "" ) ;

		String sql = "update fm_user_access_rights set assign_fs_locn_yn = ?,change_fs_locn_yn = ?, req_yn	= ?, req_across_facilities_yn = ?, manual_request_yn = ?, cancel_request_yn = ?,    iss_yn = ?, iss_across_facilities_yn = ?, CREATE_FILE_VOLUME_YN = ?,     change_return_date_yn = ?,deficiency_check_yn = ?,Change_file_status_yn	= ?,   track_out_to_opd_yn	= ?,track_out_to_ipw_yn	= ?,receive_file_yn = ?,return_file_yn = ?, confirm_receipt_file_yn = ?,         transfer_file_yn = ?,modified_by_id = ?,modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ? where facility_id = ? and fs_locn_code = ? and appl_user_id = ? ";
				
		String modifiedById = p.getProperty("login_user");					
			
		String modifiedAtWorkstation	= addedAtWorkstation;


		if ( updatable )
		{
			try
			{				

				con = ConnectionManager.getConnection(p);

				pstmt = con.prepareStatement( sql );
				pstmt.setString ( 1,assign_fs_locn ) ;
				pstmt.setString ( 2,change_fs_locn ) ;
				pstmt.setString ( 3,req_yn ) ;
				pstmt.setString ( 4,req_across_facilities_yn ) ;
				pstmt.setString ( 5,manual_request_yn );
				pstmt.setString ( 6,cancel_request_yn );
				pstmt.setString ( 7,iss_yn ) ;
				pstmt.setString ( 8,iss_across_facilities_yn ) ;
				pstmt.setString ( 9,CREATE_FILE_VOLUME_YN );
				pstmt.setString ( 10,change_return_date_yn ) ;
				pstmt.setString ( 11,deficiency_check_yn ) ;
				pstmt.setString ( 12,file_lost_found_yn ) ;
				pstmt.setString ( 13,track_out_to_opd_yn ) ;				
				pstmt.setString ( 14,track_out_to_ipw_yn ) ;				
				pstmt.setString ( 15, receive_file_yn ) ;
				pstmt.setString ( 16, return_file_yn ) ;
				pstmt.setString ( 17, confirm_receipt_file_yn  ) ;
				pstmt.setString ( 18, transfer_file_yn ) ;				
				pstmt.setString	( 19, modifiedById ) ;				
				pstmt.setString	( 20, modifiedAtWorkstation ) ;
				pstmt.setString	( 21, facilityId ) ;
				pstmt.setString ( 22,facilityId ) ;
				pstmt.setString ( 23,fs_locn_code);
				pstmt.setString ( 24,appl_user_id);
			
				int res = pstmt.executeUpdate() ;

				if ( res != 0 ) {
					result = true ;

					java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED, "SM" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit();
					message.clear();
				}

				if(pstmt != null) pstmt.close();
			} catch ( Exception e ) {
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
				try{
					con.rollback();
					}catch (Exception ce){
					sb.append("While Rollback of update :"+ ce.getMessage());
					}
		}
		finally{
			  if (con != null)
			  {			   
				ConnectionManager.returnConnection(con,p);
		      }
			}
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap deleteUserAccess(java.util.Properties p,java.util.HashMap delUserAccess) 
	{
		java.util.HashMap results = new java.util.HashMap() ;

		boolean result = false ;


		StringBuffer sb = new StringBuffer( "" ) ;			

		facilityId	= (String) delUserAccess.get ( "facilityId" );
		appl_user_id	= (String) delUserAccess.get ( "appl_user_id" );
		fs_locn_code	= (String) delUserAccess.get ( "fs_locn_code" );
		delUserAccess.clear();

		try
		{
			String sql = "delete from fm_user_access_rights where facility_id = ? and appl_user_id = ? and fs_locn_code = ? ";
						
			con = ConnectionManager.getConnection(p);
			
			pstmt = con.prepareStatement( sql );
			pstmt.setString	( 1, facilityId ) ;
			pstmt.setString	( 2, appl_user_id) ;
			pstmt.setString	( 3, fs_locn_code) ;
			int res = pstmt.executeUpdate() ;

			if ( res != 0 )
			{
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_DELETED, "SM" ) ;
				sb.append( (String) message.get("message") ) ;
				con.commit();
				message.clear();
			}
			if(pstmt != null) pstmt.close();
		}
		catch ( Exception e )
		{
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			try
			{
				con.rollback();
			}catch (Exception ce){
			sb.append("While Rollback of delete :"+ ce.getMessage());
			}
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
