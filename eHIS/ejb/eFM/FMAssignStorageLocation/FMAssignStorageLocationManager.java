/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMAssignStorageLocation;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="FMAssignStorageLocation"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMAssignStorageLocation"
*	local-jndi-name="FMAssignStorageLocation"
*	impl-class-name="eFM.FMAssignStorageLocation.FMAssignStorageLocationManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMAssignStorageLocation.FMAssignStorageLocationLocal"
*	remote-class="eFM.FMAssignStorageLocation.FMAssignStorageLocationRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMAssignStorageLocation.FMAssignStorageLocationLocalHome"
*	remote-class="eFM.FMAssignStorageLocation.FMAssignStorageLocationHome"
*	generate= "local,remote"
*
*
*/

public class FMAssignStorageLocationManager implements SessionBean
{
	Connection con				= null;
	PreparedStatement pstmt_ins	= null ;
	PreparedStatement pstmt_upd	= null;
	PreparedStatement pstmt_sel	= null;
	ResultSet			 rs_sql = null;
	
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");	

	public final String RECORD_MODIFIED = "RECORD_MODIFIED";	

	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context)
	{
		this.ctx = context;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public java.util.HashMap insertFMAssignLocn(
								java.util.Properties p,
								webbeans.eCommon.RecordSet recordSet,
								String addedFacilityId,
								String addedAtWorkstation) 
	{
		StringBuffer sb	= new StringBuffer("");
		HashMap results	= new HashMap();
		boolean result	= false;

		String facilityId			= addedFacilityId;		
		String added_by_id			= p.getProperty("login_user");
		String added_facility_id	= addedFacilityId;
		String added_at_ws_no		= addedAtWorkstation;		
		String locn_identity = "", narration_code = "", holder_name = "";
		String file_no = "",patient_id = "",fs_locn_code = "";
		String associate_yn = "";
		String locale = p.getProperty("LOCALE");
		String file_type_code = "", doc_folder_id = "",doc_type_code = "";	

		String terminal_dgt = "";
		String terminal_dgt_grp1 = "";
		String terminal_dgt_grp2 = "";
		String terminal_dgt_grp3 = "";		

		boolean insert_flag = true;
		int insert_count = 0;		
		int count_assign = 0, count_insert = 0;

		HashMap htRecord	= new HashMap();

		try
		{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			String sel_sql = "SELECT TERMINAL_DIGIT, TERMINAL_DIGIT_GRP1, TERMINAL_DIGIT_GRP2, TERMINAL_DIGIT_GRP3 FROM MR_PAT_FILE_INDEX WHERE file_no = ? and facility_id = ? ";
			pstmt_sel = con.prepareStatement(sel_sql);

			String insert_sql = "Insert into fm_curr_locn( FACILITY_ID, FILE_NO, PATIENT_ID, CURR_FILE_STATUS, CURR_FS_LOCN_CODE, CURR_FS_LOCN_IDENTITY, CURR_HOLDER_USER_ID, NARRATION_CODE, MR_LOCN_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, CURR_FACILITY_ID, FILE_TYPE_CODE, VOLUME_NO, VOLUME_STATUS, DOC_FOLDER_ID, DOC_TYPE_CODE, PERM_FS_LOCN_CODE, TERMINAL_DIGIT, TERMINAL_DIGIT_GRP1, TERMINAL_DIGIT_GRP2, TERMINAL_DIGIT_GRP3)values(?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt_ins	=	con.prepareStatement(insert_sql);

			String update_sql = "Update mr_pat_file_index set fs_locn_code=?, MODIFIED_BY_ID=?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where file_no = ? and facility_id = ?";
			pstmt_upd	=	con.prepareStatement(update_sql);

			int row_count	=	recordSet.getSize();

			for(int k=0; k<row_count; k++)
			{
				htRecord			=	(java.util.HashMap)	recordSet.getObject(k);
				associate_yn		=	(String)	htRecord.get("associate_yn");
				if(associate_yn.equals("Y"))
				{
					count_assign++;
					file_no			=	(String)	htRecord.get("file_no");
					doc_folder_id	=	(String)	htRecord.get("doc_folder_id");
					doc_type_code	=	(String)	htRecord.get("doc_type_code");
					patient_id		=	(String)	htRecord.get("patient_id");
					file_type_code	=	(String)	htRecord.get("file_type_code");
					//patient_name	=	(String)	htRecord.get("patient_name");
					//old_file_no	=	(String)	htRecord.get("old_file_no");
					fs_locn_code	=	(String)	htRecord.get("fn_locn_code");
					locn_identity	=	(String)	htRecord.get("locn_identity");
					narration_code	=	(String)	htRecord.get("narration_code");
					holder_name		=	(String)	htRecord.get("holder_name");

					if(file_no == null || file_no.equals("null")) file_no = "";
					if(patient_id == null || patient_id.equals("null")) patient_id = "";
					if(file_type_code == null || file_type_code.equals("null")) file_type_code = "";
					if(doc_folder_id == null || doc_folder_id.equals("null")) doc_folder_id = "";
					if(doc_type_code == null || doc_type_code.equals("null")) doc_type_code = "";

					///////////////////////////////////////////////////////////////////

					pstmt_sel.setString	(1,	file_no );
					pstmt_sel.setString	(2,	facilityId );
					rs_sql = pstmt_sel.executeQuery();

					if(rs_sql.next())
					{
						terminal_dgt		= rs_sql.getString("TERMINAL_DIGIT");
						terminal_dgt_grp1	= rs_sql.getString("TERMINAL_DIGIT_GRP1");
						terminal_dgt_grp2	= rs_sql.getString("TERMINAL_DIGIT_GRP2");
						terminal_dgt_grp3	= rs_sql.getString("TERMINAL_DIGIT_GRP3");
					}
                  if(rs_sql!= null) rs_sql.close();

					//////////////////////////////////////////////////////////////////
			
		///////////////////////////////////////////////////////////////////////////
					pstmt_ins.setString	(1,	facilityId );
					pstmt_ins.setString	(2,	file_no );
					pstmt_ins.setString	(3,	patient_id );
					pstmt_ins.setString	(4, "I" );
					pstmt_ins.setString	(5, fs_locn_code );
					pstmt_ins.setString	(6, locn_identity );
					pstmt_ins.setString	(7, holder_name );
					pstmt_ins.setString	(8, narration_code );
					pstmt_ins.setString	(9, "Y" );
					pstmt_ins.setString	(10, added_by_id );
					pstmt_ins.setString	(11, added_at_ws_no );
					pstmt_ins.setString	(12, added_facility_id );
					pstmt_ins.setString	(13, added_by_id );
					pstmt_ins.setString	(14, added_at_ws_no );
					pstmt_ins.setString	(15, added_facility_id );
					pstmt_ins.setString	(16, added_facility_id );
					pstmt_ins.setString	(17, file_type_code );
					pstmt_ins.setInt	(18, 1 );
					pstmt_ins.setString	(19, "A" );
					pstmt_ins.setString	(20, doc_folder_id);
					pstmt_ins.setString	(21, doc_type_code );
					pstmt_ins.setString	(22, fs_locn_code );
					pstmt_ins.setString	(23, terminal_dgt );
					pstmt_ins.setString	(24, terminal_dgt_grp1 );
					pstmt_ins.setString	(25, terminal_dgt_grp2 );
					pstmt_ins.setString	(26, terminal_dgt_grp3 );
					
					insert_count = pstmt_ins.executeUpdate() ;
		///////////////////////////////////////////////////////////////////////////
					if(insert_count >0)
					{
						count_insert++;
		///////////////////////////////////////////////////////////////////////////

						pstmt_upd.setString	(1,	fs_locn_code );
						pstmt_upd.setString	(2,	added_by_id );
						pstmt_upd.setString	(3,	added_at_ws_no );
						pstmt_upd.setString	(4,	added_facility_id );
						pstmt_upd.setString	(5,	file_no );
						pstmt_upd.setString	(6,	facilityId );
						
						pstmt_upd.executeUpdate() ;
		///////////////////////////////////////////////////////////////////////////
					}
					else
					{
						insert_flag=false;
						break;
					}
				}
			}
			if((count_assign==count_insert)&&(insert_flag))
			{
				result = true ;
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM" ) ;
				sb.append( (String) message.get("message") ) ;
				htRecord.clear();
				message.clear();
			}
			else
			{
				result = false ;
				con.rollback();
			}
			if(rs_sql!= null) rs_sql.close();
			if(pstmt_ins !=	null) pstmt_ins.close();
			if(pstmt_upd != null) pstmt_upd.close();
		    if(pstmt_sel != null) pstmt_sel.close();
			
		
		}
		catch(Exception e)
		{
			sb.append(e.getMessage());
			if ( con != null )
			{
				try
				{
					con.rollback();
				}
				catch( Exception ce ) {sb.append(e.getMessage());}
			}
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con, p);
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
}
