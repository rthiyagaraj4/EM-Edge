/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMLostFoundFile;

import javax.ejb.* ;

import java.sql.*;
import java.rmi.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="FMLostFoundFile"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMLostFoundFile"
*	local-jndi-name="FMLostFoundFile"
*	impl-class-name="eFM.FMLostFoundFile.LostFoundFileManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMLostFoundFile.LostFoundFileLocal"
*	remote-class="eFM.FMLostFoundFile.LostFoundFileRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMLostFoundFile.LostFoundFileLocalHome"
*	remote-class="eFM.FMLostFoundFile.LostFoundFileHome"
*	generate= "local,remote"
*
*
*/

public class LostFoundFileManager implements SessionBean {

	Connection con;
	PreparedStatement pstmt;
	PreparedStatement pstmt_log;
	PreparedStatement pstmt1;	

	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	
	int ins_fm_log = 0;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext ctx ) {}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertLostFoundFile(
							java.util.Properties p,
							java.util.Properties prop,
							java.util.HashMap htRecord) 
		{

		HashMap results = new HashMap();
	
		StringBuffer sqlbuff	= new StringBuffer();
		String sql				= "";
		String sql1				= "";
		String mysql			= "";
		String p_locn_identity	= "";
		String p_holder_name	= "";
		String p_mr_locn_yn		= "";
				
		String p_duration_type			= "";
		String dest_narration_code		= "";
		String dest_holder_name			= "";
		String src_fs_locn_code			= "";	
		String src_locn_identity		= ""; 
		String src_user_id				= "";
		String src_mr_locn_yn			= "";
		String patient_id				= "";
		String p_permanent_file_area_yn	= "";
		String curr_facility_id			= "";

		String p_new_status				= "";
		String Ret_p_new_status				= "";
		String p_fs_location			= "";		         
		String p_updated_by				= "";
		String p_file_no				= "";
		String p_remarks				= "";
		String p_facility_id			= "";
		String changed_by				= "";
		String addedAtWorkstation		= "";
		String p_file_type_code			= "";
		String p_volume_no				= "";
		String p_doc_folder_id			= "";
		String p_doc_type_code			= "";
		String p_locn_code				= "";
		String locale				= "";
		String archive_yn           ="";
       String patient_id1="";
		int count						= 0;
		int p_no_of_dh_to_return_ip		= 0;
		int p_no_of_dh_to_return_op		= 0;
		int p_days						= 0;
		int ins_req_hdr					= 0;

		boolean result	= false ;
	
		StringBuffer sb = new StringBuffer( "" ) ;

		con				= ConnectionManager.getConnection(p);
		Statement stmt	= null;
		ResultSet rs	= null;		

		try
		{


			p_new_status		= (String) htRecord.get("p_new_status");
		    p_fs_location		= (String) htRecord.get("p_fs_location");		         
			p_updated_by		= (String) htRecord.get("p_updated_by");
			p_file_no			= (String) htRecord.get("p_file_no");
			p_remarks			= (String) htRecord.get("p_remarks");
			p_facility_id		= (String) htRecord.get("facilityId");
			changed_by			= (String) htRecord.get("changed_by");
			addedAtWorkstation	= (String) htRecord.get("addedAtWorkstation");
			p_file_type_code	= (String) htRecord.get("p_file_type_code");
			p_volume_no			= (String) htRecord.get("p_volume_no");
			p_doc_folder_id		= (String) htRecord.get("p_doc_folder_id");
			p_doc_type_code		= (String) htRecord.get("p_doc_type_code");
			p_locn_code			= (String) htRecord.get("p_locn_code");
			locale			= (String) htRecord.get("locale");
			archive_yn		= (String) htRecord.get("archive_yn");
           String  volume_nomax="";

			htRecord.clear();
			
			if(p_new_status == null || p_new_status.equals("null")) p_new_status = "";
			if(p_fs_location == null || p_fs_location.equals("null"))p_fs_location = "";
			if(p_updated_by == null || p_updated_by.equals("null"))p_updated_by = "";
			if(p_file_no == null || p_file_no.equals("null"))p_file_no = "";
			if(p_remarks == null || p_remarks.equals("null"))p_remarks = "";
			if(p_facility_id == null || p_facility_id.equals("null")) p_facility_id = "";
			if(changed_by == null || changed_by.equals("null"))changed_by = "";
			if(addedAtWorkstation == null || addedAtWorkstation.equals("null"))addedAtWorkstation = "";
			if(p_file_type_code == null || p_file_type_code.equals("null"))p_file_type_code = "";
			if(p_volume_no == null || p_volume_no.equals("null"))p_volume_no = "";
			if(p_doc_folder_id == null || p_doc_folder_id.equals("null"))p_doc_folder_id = "";
			if(p_doc_type_code == null || p_doc_type_code.equals("null"))p_doc_type_code = "";
			if(p_locn_code == null || p_locn_code.equals("null"))p_locn_code = "";

			Ret_p_new_status = p_new_status;


			stmt						 = con.createStatement();			
			String modifiedAtWorkstation = addedAtWorkstation ;
			
			sql = "select locn_identity,holder_name, mr_locn_yn, permanent_file_area_yn, no_of_dh_to_return_ip, no_of_dh_to_return_op,duration_type,narration_code,holder_name FROM fm_storage_locn WHERE facility_id='"+p_facility_id+"' AND fs_locn_code='"+p_fs_location+"' " ;
		
			rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				p_locn_identity				= rs.getString("locn_identity");
				p_holder_name				= rs.getString("holder_name");
				p_mr_locn_yn				= rs.getString("mr_locn_yn");
				p_permanent_file_area_yn	= rs.getString("permanent_file_area_yn");
				p_no_of_dh_to_return_ip		= rs.getInt("no_of_dh_to_return_ip");
				p_no_of_dh_to_return_op		= rs.getInt("no_of_dh_to_return_op");
				p_duration_type				= rs.getString("duration_type");
				dest_narration_code			= rs.getString("narration_code");
				dest_holder_name			= rs.getString("holder_name");
			} if(rs != null) rs.close();



			if((p_new_status.equals("F")) || (p_new_status.equals("R")))
			{
				if((p_mr_locn_yn.equals("Y")) || (p_permanent_file_area_yn.equals("Y")))
					p_new_status="I";
				else
					p_new_status="O";
			}


			if (p_holder_name==null)
			{
				p_holder_name="";
			}
			if (p_duration_type==null)
			{
					p_duration_type="";
			}
			//added on 22/11/2003
			if(p_locn_identity.equals("C"))
			{
				p_days = p_no_of_dh_to_return_op;
			}
			else if(p_locn_identity.equals("N"))
			{
				p_days = p_no_of_dh_to_return_ip;
			}
			else
			{
				p_days =0;
			}
			if (p_duration_type.equals("D"))
			{
				p_days = ((p_days)*24);
			}
			else
			{
				p_days = p_days;
			}
			//ends here
			if(dest_holder_name ==null)
				dest_holder_name = "";
			
			if (p_permanent_file_area_yn.equals("Y"))
			{
				//sql = "UPDATE fm_curr_locn SET curr_file_status=?,ARCHIVE_YN=?,curr_fs_locn_code=?,curr_fs_locn_identity=?,curr_holder_user_id=?,remarks=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=?,prev_facility_id=curr_facility_id,prev_fs_locn_code=curr_fs_locn_code,iss_date_time='',return_date_time='',mr_locn_yn='Y' WHERE facility_id=? AND file_no=? AND volume_no = ?" ;

				sqlbuff.append("UPDATE fm_curr_locn SET curr_file_status=?,ARCHIVE_YN=?,curr_fs_locn_code=?,curr_fs_locn_identity=?,curr_holder_user_id=?,remarks=? ");
				
				if(p_new_status.equals("L"))
				{
					sqlbuff.append(",VOLUME_STATUS=? ");
				}
				else if(Ret_p_new_status.equals("F"))
				{
					sqlbuff.append(",VOLUME_STATUS=? ");
				}
				sqlbuff.append(",modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=?,prev_facility_id=curr_facility_id,prev_fs_locn_code=curr_fs_locn_code,iss_date_time='',return_date_time='',mr_locn_yn='Y' WHERE facility_id=? AND file_no=? AND volume_no = ?");
			}						
			else if ((p_locn_identity.equals("C")) || (p_locn_identity.equals("N")))						
			{
				//sql = "UPDATE fm_curr_locn SET curr_file_status=?,ARCHIVE_YN=?,curr_fs_locn_code=?,curr_fs_locn_identity=?,curr_holder_user_id=?,remarks=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=?,prev_facility_id=curr_facility_id,prev_fs_locn_code=curr_fs_locn_code,return_date_time=sysdate+'" + p_days + "'/24, curr_locn_id = ? WHERE facility_id=? AND file_no=? AND volume_no = ?  " ;
				
				sqlbuff.append("UPDATE fm_curr_locn SET curr_file_status=?,ARCHIVE_YN=?,curr_fs_locn_code=?,curr_fs_locn_identity=?,curr_holder_user_id=?,remarks=? ");

				if(p_new_status.equals("L"))
				{
					sqlbuff.append(",VOLUME_STATUS=? ");
				}
				else if(Ret_p_new_status.equals("F"))
				{
					sqlbuff.append(",VOLUME_STATUS=? ");
				}
			//	sqlbuff.append(",modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=?,prev_facility_id=curr_facility_id,prev_fs_locn_code=curr_fs_locn_code,return_date_time=sysdate+'" + p_days + "'/24, curr_locn_id = ? WHERE facility_id=? AND file_no=? AND volume_no = ?  ") ;
			sqlbuff.append(",modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=?,prev_facility_id=curr_facility_id,prev_fs_locn_code=curr_fs_locn_code,return_date_time='', curr_locn_id = ? WHERE facility_id=? AND file_no=? AND volume_no = ?  ") ;
			}						
			else
			{
				//sql = "UPDATE fm_curr_locn SET curr_file_status=?,ARCHIVE_YN=?,curr_fs_locn_code=?,curr_fs_locn_identity=?,curr_holder_user_id=?,remarks=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=?,prev_facility_id=curr_facility_id,prev_fs_locn_code=curr_fs_locn_code, curr_locn_id = ?  WHERE facility_id=? AND file_no=? AND volume_no = ?  " ;
			
				sqlbuff.append("UPDATE fm_curr_locn SET curr_file_status=?,ARCHIVE_YN=?,curr_fs_locn_code=?,curr_fs_locn_identity=?,curr_holder_user_id=?,remarks=? ");

				if(p_new_status.equals("L"))
				{
					sqlbuff.append(",VOLUME_STATUS=? ");
				}
				else if(Ret_p_new_status.equals("F"))
				{
					sqlbuff.append(",VOLUME_STATUS=? ");
				}			
				sqlbuff.append(",modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=?,prev_facility_id=curr_facility_id,prev_fs_locn_code=curr_fs_locn_code, curr_locn_id = ?  WHERE facility_id=? AND file_no=? AND volume_no = ?  ") ;
			}
			
			//pstmt1 = con.prepareStatement(sql);
			
			patient_id1			= (String)prop.get("patient_id");
			if(patient_id1 == null || patient_id1.equals("null"))patient_id1 = "0";
			mysql = "SELECT count(volume_no) count,max(volume_no) volume_no  FROM fm_curr_locn WHERE facility_id='"+p_facility_id+"' AND file_no= '"+p_file_no+"' AND patient_id= '"+patient_id1+"' ";
			rs = stmt.executeQuery(mysql);
			if(rs != null && rs.next())
			{
				count = rs.getInt("count");
			  volume_nomax= rs.getString("volume_no");
			}
			if(volume_nomax == null || volume_nomax.equals("null"))volume_nomax = "0";
			
			
			pstmt1 = con.prepareStatement(sqlbuff.toString());

			pstmt1.setString	(1, p_new_status) ;
			pstmt1.setString	(2, archive_yn) ;
			pstmt1.setString	(3, p_fs_location) ;
			pstmt1.setString	(4, p_locn_identity) ;
			pstmt1.setString	(5, p_holder_name) ;
			pstmt1.setString	(6, p_remarks) ;
			
			if(p_new_status.equals("L") || Ret_p_new_status.equals("F"))
			{
			if(p_new_status.equals("L") )
			{
			pstmt1.setString	(7, "L") ;
			}
			else
			if(Ret_p_new_status.equals("F") && volume_nomax.equals(p_volume_no))
			{
			pstmt1.setString	(7, "A") ;
			}else{
             pstmt1.setString	(7, "I") ;
			}

			pstmt1.setString	(8, changed_by) ;
			pstmt1.setString	(9, modifiedAtWorkstation ) ;
			pstmt1.setString	(10, p_facility_id) ;
			if(!p_permanent_file_area_yn.equals("Y"))
			{
				pstmt1.setString	(11, p_locn_code) ;
				pstmt1.setString	(12, p_facility_id) ;
				pstmt1.setString	(13, p_file_no) ;
				pstmt1.setString	(14, p_volume_no) ;
			}
			else
			{
				pstmt1.setString	(11, p_facility_id) ;
				pstmt1.setString	(12, p_file_no) ;
				pstmt1.setString	(13, p_volume_no) ;
			}
			}
			else
			{
			pstmt1.setString	(7, changed_by) ;
			pstmt1.setString	(8, modifiedAtWorkstation ) ;
			pstmt1.setString	(9, p_facility_id) ;
			if(!p_permanent_file_area_yn.equals("Y"))
			{
				pstmt1.setString	(10, p_locn_code) ;
				pstmt1.setString	(11, p_facility_id) ;
				pstmt1.setString	(12, p_file_no) ;
				pstmt1.setString	(13, p_volume_no) ;
			}
			else
			{
				pstmt1.setString	(10, p_facility_id) ;
				pstmt1.setString	(11, p_file_no) ;
				pstmt1.setString	(12, p_volume_no) ;
			}
			}
									
			ins_req_hdr = pstmt1.executeUpdate() ;


		//	mysql = "SELECT count(volume_no) count FROM fm_curr_locn WHERE facility_id='"+p_facility_id+"' AND file_no= '"+p_file_no+"' ";
		//	rs = stmt.executeQuery(mysql);
		//	if(rs != null && rs.next())
		//	{
		//		count = rs.getInt("count");
		//	}
			if(count == 1)
			{			
				if (ins_req_hdr > 0 )
				{
					if (p_new_status.equals("A"))
					{	
						sql1 = " UPDATE mr_pat_file_index SET archived_yn='Y', modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? WHERE facility_id=? AND file_no=? " ;
					}
					else if (p_new_status.equals("L"))
					{
						sql1 = " UPDATE mr_pat_file_index SET lost_yn='Y',archived_yn='N', modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? WHERE facility_id=? AND file_no=? " ;
					}
					else 
					{
						sql1 = " UPDATE mr_pat_file_index SET lost_yn='N',archived_yn='N', modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? WHERE facility_id=? AND file_no=? " ;
					}
					pstmt = con.prepareStatement( sql1 );
					pstmt.setString	( 1, p_updated_by ) ;
					pstmt.setString	( 2, modifiedAtWorkstation ) ;
					pstmt.setString	( 3, p_facility_id ) ;
					pstmt.setString	( 4, p_facility_id ) ;
					pstmt.setString	( 5, p_file_no ) ;
								
					pstmt.executeUpdate() ;
				}
			}
			if(ins_req_hdr != 0)
			{
				src_fs_locn_code	= (String)prop.get("src_fs_locn_code");	
				src_locn_identity	= (String)prop.get("src_locn_identity");	 
				src_user_id			= (String)prop.get("src_user_id");
				src_mr_locn_yn		= (String)prop.get("src_mr_locn_yn");
				patient_id			= (String)prop.get("patient_id");
				curr_facility_id	= (String)prop.get("curr_facility_id");

				

				String insert_sql="INSERT INTO fm_movement_log(facility_id, file_no, file_type_code,volume_no, sent_date_time, patient_id, src_facility_id, src_fs_locn_code, src_locn_identity, src_user_id, dest_facility_id, rec_date_time, dest_fs_locn_code, dest_locn_identity, dest_user_id, narration_code, movement_type, src_mr_locn_yn, dest_mr_locn_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, doc_folder_id, doc_type_code, dest_locn_id)VALUES(?,?,?,?,sysdate,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,? )";
				
				pstmt_log = con.prepareStatement(insert_sql);
				
				pstmt_log.setString	( 1, p_facility_id ) ;
				pstmt_log.setString	( 2, p_file_no ) ;
				pstmt_log.setString	( 3, p_file_type_code ) ;
				pstmt_log.setString	( 4, p_volume_no ) ;
				pstmt_log.setString	( 5, patient_id ) ;
				pstmt_log.setString	( 6, curr_facility_id ) ;
				pstmt_log.setString	( 7, src_fs_locn_code ) ;
				pstmt_log.setString	( 8, src_locn_identity ) ;
				pstmt_log.setString	( 9, src_user_id ) ;
				pstmt_log.setString	( 10, p_facility_id ) ;
				pstmt_log.setString	( 11, p_fs_location ) ;
				pstmt_log.setString	( 12, p_locn_identity ) ; //dest_locn_identity
				pstmt_log.setString	( 13, dest_holder_name ) ;
				pstmt_log.setString	( 14, dest_narration_code ) ;
				pstmt_log.setString	( 15, "L" ) ;
				pstmt_log.setString	( 16, src_mr_locn_yn ) ;
				pstmt_log.setString	( 17, p_mr_locn_yn ) ; //dest_mr_locn_yn
				pstmt_log.setString	( 18, p_updated_by ) ;
				pstmt_log.setString	( 19, modifiedAtWorkstation ) ;
				pstmt_log.setString	( 20, p_facility_id ) ;
				pstmt_log.setString	( 21, p_updated_by ) ;
				pstmt_log.setString	( 22, modifiedAtWorkstation ) ;
				pstmt_log.setString	( 23, p_facility_id ) ;
				pstmt_log.setString	( 24, p_doc_folder_id ) ;
				pstmt_log.setString	( 25, p_doc_type_code ) ;
				pstmt_log.setString	( 26, p_locn_code ) ;
				
				ins_fm_log = pstmt_log.executeUpdate() ;
				
				pstmt_log.close();
			}
			if ( ins_fm_log != 0  )
			{
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED,"SM" ) ;
				sb.append( (String) message.get("message") ) ;
				con.commit();
				message.clear();
			}
			if(rs!=null)  rs.close();
		    if(stmt!=null)  stmt.close();
		    if(pstmt!=null)  pstmt.close();
		    if(pstmt1!=null)  pstmt1.close();
		    if(pstmt_log!=null)  pstmt_log.close();
		}
		catch(Exception e)
		{
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			try
			{
				con.rollback();
			}
			catch (Exception ce){sb.append( ce.getMessage() + "<br>" ) ;}
		}
		finally
		{
	    	ConnectionManager.returnConnection(con,p);		
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
}
