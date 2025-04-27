/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMReturnToMRD;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="FMReturnToMRD"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMReturnToMRD"
*	local-jndi-name="FMReturnToMRD"
*	impl-class-name="eFM.FMReturnToMRD.FMReturnToMRDManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMReturnToMRD.FMReturnToMRDLocal"
*	remote-class="eFM.FMReturnToMRD.FMReturnToMRDRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMReturnToMRD.FMReturnToMRDLocalHome"
*	remote-class="eFM.FMReturnToMRD.FMReturnToMRDHome"
*	generate= "local,remote"
*
*
*/

public class FMReturnToMRDManager implements SessionBean 
{
	Connection connection			=	null;
	PreparedStatement preStatement	=	null;
	PreparedStatement preStatement1	=	null;
	PreparedStatement preStatement2	=	null;
	PreparedStatement preStatement3	=	null;
	PreparedStatement preStatement4	=	null;
	PreparedStatement preStatement5	=	null;
	
	ResultSet rSet					=	null;

	public final String RECORD_INSERTED		= "RECORD_INSERTED";
		
	public void ejbCreate() {
		
	}
	public void ejbRemove() {
		}
	public void ejbActivate() {
		
	}
	public void ejbPassivate() {
		}
	public void setSessionContext( SessionContext ctx ) {
		
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap returnFileToMRD(
							java.util.Properties p,
							java.util.HashMap hashmap
						 )
	{

		HashMap results			=	new HashMap() ;
		
		StringBuffer strBuffer	=	new StringBuffer();

		boolean result					= false;
		int records_modified			= 0;

		String file_no					= "";
		String volume_no				= "";
		String doc_folder_id			= "";
		String doc_type_code			= "";
		String sqlString				= "";
		String transitQuery				= "";
		String movementQuery			= "";
		String locationQuery			= "";
		String p_facility_id			= "";
		String p_fs_locn_code			= "";
		String p_fs_locn_identity		= "";
		String p_sender_mr_locn_yn		= "";
		String curr_facility_id			= "";
		String curr_fs_locn_code		= "";
		String curr_fs_locn_identity	= "";
		String curr_holder_user_id		= "";
		String req_remarks				= "";
		String file_type_code			= "";
		String patient_id				= "";
		String facility_id				= "";
		String valid_records			= "";
		//String date_time				= "";
		String transport_mode			= "";
		String transport_mode_desc		= "";	
		String client_ip_address		= "";
		String login_user				= "";
		String locale				= "";
       // String sqlString1         ="";
	//	String sqlString2         ="";
		String patient_id1="";
		String file_creat_fac_id="";
		String curr_fs_locn_ident="";
		String flagvalue="false";
		int tokenCount=0;
		try
		{
			connection	=	ConnectionManager.getConnection(p);
			connection.setAutoCommit(false);
			
			facility_id			= (String) hashmap.get("facility_id");
			valid_records		= (String) hashmap.get("valid_records");
			//date_time			= (String) hashmap.get("date_time");
			transport_mode		= (String) hashmap.get("transport_mode");
			transport_mode_desc = (String) hashmap.get("transport_mode_desc");
			client_ip_address	= (String) hashmap.get("client_ip_address");
			login_user			= (String) hashmap.get("login_user");
			locale					= (String) hashmap.get("locale");
            patient_id1         = (String) hashmap.get("patient_id");
			hashmap.clear();

			StringTokenizer strToken	= null;
			StringTokenizer innerToken	= null;

					
			transitQuery = "INSERT INTO fm_transit_file (facility_id, file_no, patient_id, sent_date_time, src_facility_id, src_fs_locn_code, src_locn_identity, dest_facility_id, dest_fs_locn_code, dest_locn_identity, req_remarks, iss_remarks, added_by_id, added_date, added_at_ws_no, added_facility_id, file_type_code, volume_no, doc_folder_id, doc_type_code) VALUES (?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?,?,?,?,?,?)";
			preStatement3 = connection.prepareStatement(transitQuery);

			movementQuery = "INSERT INTO fm_movement_log (facility_id, file_no, sent_date_time, patient_id, src_facility_id, src_fs_locn_code, src_locn_identity, src_user_id, dest_facility_id, rec_date_time, dest_fs_locn_code, dest_locn_identity,  dest_user_id, narration_code, movement_narration, movement_type, src_mr_locn_yn, dest_mr_locn_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,mrd_receipt_remarks, transport_mode, file_type_code, volume_no, carried_by_name, doc_folder_id, doc_type_code) VALUES (?, ?, sysdate, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, '', 'T', ?, 'Y', ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?,?,?) ";
			preStatement4 = connection.prepareStatement(movementQuery);

			locationQuery = "UPDATE fm_curr_locn SET curr_file_status = 'R', last_movement_date_time = sysdate, modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ?, req_remarks = '' WHERE curr_facility_id = ? AND  file_no = ? AND volume_no = ? ";
			preStatement5 = connection.prepareStatement(locationQuery);
	
			if(!valid_records.equals(""))
			{
				strToken = new StringTokenizer(valid_records, ",");
				 tokenCount	=	strToken.countTokens();
								
				int innerCount	=	0;
				int i			=	0;
				int j			=	0;

				for(i=0; i<tokenCount; i++)
				{
					file_no			=	"";
					volume_no		=	"";
					doc_folder_id	=	"";
					doc_type_code	=	"";

					if(strToken.hasMoreTokens())
					{
						innerCount	=	0;
						innerToken	=	new StringTokenizer(checkNull(strToken.nextToken()), "||");
						innerCount	=	innerToken.countTokens();
						
						p_facility_id			=	"";
						p_fs_locn_code			=	"";
						p_fs_locn_identity		=	"";
						p_sender_mr_locn_yn		=	"";
						curr_facility_id		=	"";
						curr_fs_locn_code		=	"";
						curr_fs_locn_identity	=	"";
						curr_holder_user_id		=	"";
						req_remarks				=	"";
						file_type_code			=	"";
						patient_id				=	"";
												
						for(j=0; j<innerCount; j++)
						{
							if(innerToken.hasMoreTokens()) 
							{
								file_no = checkNull(innerToken.nextToken());
							}
							if(innerToken.hasMoreTokens()) 
							{
								volume_no = checkNull(innerToken.nextToken());
							}
							if(innerToken.hasMoreTokens()) 
							{
								doc_folder_id =	checkNull(innerToken.nextToken());
							}
							if(innerToken.hasMoreTokens()) 
							{
								doc_type_code =	checkNull(innerToken.nextToken());
							}
						}

					/////////////////////////////////////////////////////////////////////
				
						if(rSet != null) { rSet = null; }
						
			preStatement2=connection.prepareStatement("SELECT curr_fs_locn_identity ,FACILITY_ID  FROM fm_curr_locn WHERE  file_no='"+file_no+"' and volume_no='"+volume_no+"' and CURR_FS_LOCN_IDENTITY='D'  and  curr_file_status='I' and  PERM_FS_LOCN_CODE <>CURR_FS_LOCN_CODE ");
			rSet	= preStatement2.executeQuery();
			if((rSet != null) && (rSet.next()))
			{
			
			curr_fs_locn_ident	= checkNull(rSet.getString("curr_fs_locn_identity"));	
			file_creat_fac_id	   = checkNull(rSet.getString("FACILITY_ID"));	 
			}		
					
						
			if(curr_fs_locn_ident==null)	curr_fs_locn_ident="";
				
			if(rSet != null) { rSet.close(); }			
			if(preStatement2!=null)	preStatement2.close();	
						
			if(!file_creat_fac_id.equals(facility_id) && curr_fs_locn_ident.equals("D"))
	       {
			sqlString = "SELECT a.facility_id, a.curr_facility_id, a.curr_fs_locn_code, a.curr_fs_locn_identity, a.curr_holder_user_id, a.req_remarks, a.file_type_code, a.patient_id, b.mr_locn_yn, a.perm_fs_locn_code fs_locn_code, c.locn_identity FROM fm_curr_locn a, fm_storage_locn b, fm_storage_locn c WHERE a.facility_id = ? AND a.curr_file_status = 'I' AND a.file_no = ? AND a.volume_no = ? AND a.curr_facility_id = b.facility_id AND a.curr_fs_locn_code = b.fs_locn_code AND a.facility_id = c.facility_id AND a.perm_fs_locn_code	= c.fs_locn_code";
		  
		   }else{
             sqlString = "SELECT a.facility_id, a.curr_facility_id, a.curr_fs_locn_code, a.curr_fs_locn_identity, a.curr_holder_user_id, a.req_remarks, a.file_type_code, a.patient_id, b.mr_locn_yn, a.perm_fs_locn_code fs_locn_code, c.locn_identity FROM fm_curr_locn a, fm_storage_locn b, fm_storage_locn c WHERE a.curr_facility_id = ? AND a.curr_file_status in('O','I') and  perm_fs_locn_code <> curr_fs_locn_code AND a.file_no = ? AND a.volume_no = ? AND a.curr_facility_id = b.facility_id AND a.curr_fs_locn_code = b.fs_locn_code AND a.facility_id = c.facility_id AND a.perm_fs_locn_code	= c.fs_locn_code";
			   }
		      	preStatement = connection.prepareStatement(sqlString);
					
					if(!file_creat_fac_id.equals(facility_id) && curr_fs_locn_ident.equals("D"))
	             {
					preStatement.setString(1, file_creat_fac_id);
				 	
				 }
				 else{
                     preStatement.setString(1, facility_id);
				 }
						preStatement.setString(2, file_no);
						preStatement.setString(3, volume_no);
												
							
						
						rSet	= preStatement.executeQuery();
						
						if((rSet != null) && (rSet.next()))
						{
							curr_facility_id		= checkNull(rSet.getString("curr_facility_id"));
							curr_fs_locn_code		= checkNull(rSet.getString("curr_fs_locn_code"));
							curr_fs_locn_identity	= checkNull(rSet.getString("curr_fs_locn_identity"));
							curr_holder_user_id		= checkNull(rSet.getString("curr_holder_user_id"));
							req_remarks				= checkNull(rSet.getString("req_remarks"));
							file_type_code			= checkNull(rSet.getString("file_type_code"));
							patient_id				= checkNull(rSet.getString("patient_id"));
							//////added//////
							p_facility_id			= checkNull(rSet.getString("facility_id"));
							p_fs_locn_code			= checkNull(rSet.getString("fs_locn_code"));
							p_fs_locn_identity		= checkNull(rSet.getString("locn_identity"));
							p_sender_mr_locn_yn		= checkNull(rSet.getString("mr_locn_yn"));
							flagvalue="true"	;
											
							} else {
								flagvalue="false"	;
									
							}
						
						if(rSet != null) { rSet.close(); }
						if(preStatement!=null)preStatement.close();
					
		///////////////////////////////////////////////////////////////////////////////	
								records_modified = 0;

		///////////////////////////////////////////////////////////////////////////////
						
						//preStatement3.setString(1, facility_id);
						
						if(!p_facility_id.equals("") && !patient_id.equals(""))
						{
						preStatement3.setString(1, p_facility_id);
						preStatement3.setString(2, file_no);
						preStatement3.setString(3, patient_id);
						preStatement3.setString(4, curr_facility_id);
						preStatement3.setString(5, curr_fs_locn_code);
						preStatement3.setString(6, curr_fs_locn_identity);
						preStatement3.setString(7, p_facility_id); 
						preStatement3.setString(8, p_fs_locn_code);
						preStatement3.setString(9, p_fs_locn_identity);
						preStatement3.setString(10, req_remarks);
						preStatement3.setString(11, "");
						preStatement3.setString(12, login_user);
						preStatement3.setString(13, client_ip_address);
						preStatement3.setString(14, facility_id);
						preStatement3.setString(15, file_type_code);
						preStatement3.setString(16, volume_no);
						preStatement3.setString(17, doc_folder_id);
						preStatement3.setString(18, doc_type_code);
						
						records_modified	=	preStatement3.executeUpdate();
											
						}	
		             
		
		///////////////////////////////////////////////////////////////////////////////

						if(records_modified > 0) { result = true; }

						if(result)
						{
							records_modified = 0;
			
			///////////////////////////////////////////////////////////////////////////////
			
							preStatement4.setString(1, p_facility_id ) ; 
							preStatement4.setString(2, file_no);
							preStatement4.setString(3, patient_id ) ; 
							preStatement4.setString(4, curr_facility_id ) ; 
							preStatement4.setString(5, curr_fs_locn_code ) ; 
							preStatement4.setString(6, curr_fs_locn_identity ) ; 
							preStatement4.setString(7, curr_holder_user_id ) ; 
							preStatement4.setString(8, p_facility_id ) ; 
							preStatement4.setString(9, p_fs_locn_code ) ;
							preStatement4.setString(10, p_fs_locn_identity ) ;
							preStatement4.setString(11, "" ) ; 
							preStatement4.setString(12, "" ) ;
							preStatement4.setString(13, p_sender_mr_locn_yn ) ;
							preStatement4.setString(14, login_user ) ;
							preStatement4.setString(15, client_ip_address ) ;
							preStatement4.setString(16, facility_id ) ;
							preStatement4.setString(17, login_user ) ;
							preStatement4.setString(18, client_ip_address ) ;
							preStatement4.setString(19, facility_id ) ;
							preStatement4.setString(20, "" ) ; 
							preStatement4.setString(21, transport_mode) ; 
							preStatement4.setString(22, file_type_code);
							preStatement4.setString(23, volume_no);
							preStatement4.setString(24, transport_mode_desc);
							preStatement4.setString(25, doc_folder_id);
							preStatement4.setString(26, doc_type_code);
							
							records_modified	=	preStatement4.executeUpdate();
							
			///////////////////////////////////////////////////////////////////////////////

							if(records_modified > 0) { result = true; }
						}
						if(result)
						{
							records_modified = 0;

				///////////////////////////////////////////////////////////////////////////////
				
							preStatement5.setString(1, login_user);
							preStatement5.setString(2, client_ip_address);
							preStatement5.setString(3, facility_id);
							preStatement5.setString(4, facility_id);
							preStatement5.setString(5, file_no);
							preStatement5.setString(6, volume_no);
							
							records_modified	=	preStatement5.executeUpdate();
							
				///////////////////////////////////////////////////////////////////////////////

							if(records_modified > 0) { result = true; }
						}
					}
				}
			}
			
			//if (result)
			//{
				 			
					
				if(tokenCount==1 && flagvalue.equals("false"))
				{
           //   java.util.Hashtable message = MessageManager.getMessage(locale,RECORD_ALREADY_MODI, "FM");
				 java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_ALREADY_MODI","FM");
				strBuffer.append((String) message.get("message")) ;
				connection.commit();
				message.clear();

				}else{
				java.util.Hashtable message = MessageManager.getMessage(locale, RECORD_INSERTED, "SM");
				strBuffer.append((String) message.get("message")) ;
				connection.commit();
				message.clear();
				}
			
			//} 
			if(rSet != null)  rSet.close();
			if(preStatement != null)   preStatement.close();
			if(preStatement1 != null)   preStatement1.close();
			if(preStatement2 != null)   preStatement2.close();
			if(preStatement3 != null)  preStatement3.close();
			if(preStatement4 != null)  preStatement4.close();
			if(preStatement5 != null)  preStatement5.close();
		}
		catch(Exception e)
		{
			strBuffer.append("Exception in FMReturnToMRD EJB :"+ e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			try
			{
				connection.rollback();
			}
			catch (Exception ce){strBuffer.append("Exception ce :"+ ce.getMessage() + "<br>" ) ;}
		}
		finally
		{
			 ConnectionManager.returnConnection(connection,p);		
		}

		results.put("status", new Boolean(result) ) ;
		results.put("error", strBuffer.toString() ) ;
		return results ;
	}
	public static String checkNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
}
