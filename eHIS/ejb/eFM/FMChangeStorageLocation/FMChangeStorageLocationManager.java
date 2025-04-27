/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMChangeStorageLocation;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.sql.*;
import com.ehis.util.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="FMChangeStorageLocation"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMChangeStorageLocation"
*	local-jndi-name="FMChangeStorageLocation"
*	impl-class-name="eFM.FMChangeStorageLocation.FMChangeStorageLocationManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMChangeStorageLocation.FMChangeStorageLocationLocal"
*	remote-class="eFM.FMChangeStorageLocation.FMChangeStorageLocationRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMChangeStorageLocation.FMChangeStorageLocationLocalHome"
*	remote-class="eFM.FMChangeStorageLocation.FMChangeStorageLocationHome"
*	generate= "local,remote"
*
*
*/

public class FMChangeStorageLocationManager implements SessionBean
{
	Connection con					=	null;
	PreparedStatement pstmt_upd		=	null;
	PreparedStatement pstmt_mul		=	null;
	PreparedStatement pstmt_ins		=	null;
	PreparedStatement pstmt_check	=	null;
	PreparedStatement pstmt_facility	=	null;
	PreparedStatement pstmt	=	null;
	PreparedStatement pstmt1	=	null;
	ResultSet rs1					=   null;
    ResultSet rset					=   null;
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public final String RECORD_MODIFIED = "RECORD_MODIFIED";
	
	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context)
	{
		this.ctx=context;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public java.util.HashMap insertFMChangeLocn (
								java.util.Properties p,
								webbeans.eCommon.RecordSet recordSet,
								String addedFacilityId,
								String addedAtWorkstation,
								String fs_locn) 
	 {
		StringBuffer sb = new StringBuffer("");
		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;

		String facilityId  = addedFacilityId;
		String added_by_id = p.getProperty("login_user");
		String added_facility_id = addedFacilityId ;		
		String added_at_ws_no = addedAtWorkstation ;		

		String locn_identity = "", holder_name = "";
		String file_no = "",patient_id = "",fs_locn_code = "";
		String associate_yn = "";
		String update_sql = "", fs_locn_disp = "",curr_fs_locn_identity = "", insert_sql = "";
		String curr_facility_id = "";
		String curr_holder_name = "";
		String curr_mr_locn_yn = "",mr_locn_yn = "",other_locn_code = "";
		String result_query = "";
		String temp_curr = "";
		String locale = "";
		String file_type_code = "",volume_no = "";
		String doc_folder_id = "",doc_type_code = "";		
		String  sqlString="";
		String  sqlString1="";
		String file_creat_fac_id="";
		String prev_fs_locn_code="";
		String prev_locn_id="";
		String sql="";
		String permsql="";
		String return_criteria="";
		String returndays="";
		String number="";
        String duration_type="";
		String daystoreturn="";
		String prev_facility_id="";
		String permanent_file_area_yn="N";
		String locn_iden=""; 
		String perm_fs_locn_code="";
		boolean insert_flag = false;

		int insert_count = 0, update_count = 0;
		int count_assign = 0;

		HashMap htRecord	= new HashMap();

		try
		{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			if(fs_locn.equals("P"))
			{
				update_sql = "Update mr_pat_file_index set fs_locn_code = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where file_no = ? and facility_id = ?";
			}
			else if(fs_locn.equals("C"))
			{
				update_sql = "Update fm_curr_locn set curr_fs_locn_code = ?, curr_facility_id = ?, mr_locn_yn = decode(?,'X',mr_locn_yn,?), curr_file_status = ?, CURR_FS_LOCN_IDENTITY = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate,ISS_DATE_TIME= sysdate , MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, curr_locn_id='',prev_locn_id= ?,prev_fs_locn_code= ?,return_date_time=to_date(?,'dd/mm/rrrr hh24:mi'),prev_facility_id = ?  where file_no=? and facility_id = ? and volume_no = ? ";
			}
			pstmt_upd	=	con.prepareStatement(update_sql);
		
			result_query ="select CURR_FILE_STATUS,curr_fs_locn_code,curr_locn_id ,curr_facility_id ,perm_fs_locn_code  from fm_curr_locn where curr_facility_id = ? and  file_no = ? and volume_no = ?";
			pstmt_check = con.prepareStatement(result_query);
            String update_c_sql="Update fm_curr_locn set curr_fs_locn_code=?,PERM_FS_LOCN_CODE=?, mr_locn_yn = decode(?,'X',mr_locn_yn,?),MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO = ? ,MODIFIED_FACILITY_ID = ? where file_no = ? and facility_id = ? and volume_no = ?";
			pstmt_mul =	con.prepareStatement(update_c_sql);

			insert_sql="Insert into fm_movement_log(FACILITY_ID, FILE_NO, FILE_TYPE_CODE, VOLUME_NO, SENT_DATE_TIME, PATIENT_ID, SRC_FACILITY_ID, SRC_FS_LOCN_CODE, SRC_LOCN_IDENTITY, SRC_USER_ID, DEST_FACILITY_ID, REC_DATE_TIME, DEST_FS_LOCN_CODE, DEST_LOCN_IDENTITY, DEST_USER_ID, SRC_MR_LOCN_YN, DEST_MR_LOCN_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, MOVEMENT_TYPE,DOC_FOLDER_ID,DOC_TYPE_CODE)values(?,?,?,?,sysdate,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?)";
			pstmt_ins	=	con.prepareStatement(insert_sql);
		
			int row_count	=	recordSet.getSize();
				for(int k=0; k<row_count; k++)
			{ 
				htRecord			=	(java.util.HashMap)	recordSet.getObject(k);
				associate_yn		=	(String)	htRecord.get("associate_yn");
				if(associate_yn==null) associate_yn="N";
				if(associate_yn.equals("Y"))
				{
					count_assign++;
					file_no					=	(String)	htRecord.get("file_no");
					patient_id				=	(String)	htRecord.get("patient_id");
					file_type_code          =	(String)	htRecord.get("file_type_code");
					doc_type_code           =	(String)	htRecord.get("doc_type_code");
					doc_folder_id           =	(String)	htRecord.get("doc_folder_id");
					volume_no				=	(String)	htRecord.get("volume_no");					
					fs_locn_code			=	(String)	htRecord.get("fn_locn_code");
					locn_identity			=	(String)	htRecord.get("locn_identity");
					holder_name				=	(String)	htRecord.get("holder_name");
					fs_locn_disp			=	(String)	htRecord.get("fs_locn_disp");
					curr_facility_id		=	(String)	htRecord.get("curr_facility_id");
					curr_fs_locn_identity	=	(String)	htRecord.get("curr_fs_locn_identity");
					curr_holder_name		=	(String)	htRecord.get("curr_holder_name");
					curr_mr_locn_yn			=	(String)	htRecord.get("curr_mr_locn_yn");
					mr_locn_yn				=	(String)	htRecord.get("mr_locn_yn");
					other_locn_code			=	(String)	htRecord.get("other_locn_code");
					locale			=	(String)	htRecord.get("locale");
									
					if(file_type_code == null || file_type_code.equals("")) file_type_code = "";
					if(doc_folder_id == null || doc_folder_id.equals("")) doc_folder_id = "";
					if(doc_type_code == null || doc_type_code.equals("")) doc_type_code = "";
					if(volume_no == null || volume_no.equals("")) volume_no = "";
			//////////////////////////////////////////////////////////////////////
							   
		   if(fs_locn.equals("C"))
			{
              if(rs1 != null) rs1.close();
			
			permsql= "SELECT permanent_file_area_yn , locn_identity from fm_storage_locn where FS_LOCN_CODE = '"+fs_locn_code+"'";
			pstmt1	=	con.prepareStatement(permsql);
            rs1 = pstmt1.executeQuery();	
			 if(rs1  != null &&rs1 .next())
		   {
			permanent_file_area_yn		= rs1.getString("permanent_file_area_yn");
		    locn_iden = rs1.getString("locn_identity");
				}
				}
		   	if(permanent_file_area_yn == null || permanent_file_area_yn.equals("")) permanent_file_area_yn = "";
			if(locn_iden == null || locn_iden.equals("")) locn_iden = "";
		   
		
		   if(rs1 != null) rs1.close();
		   if(pstmt1!=null)	pstmt1.close();
			sqlString = "SELECT FACILITY_ID  FROM mr_pat_file_index WHERE  file_no ='"+file_no+"' and doc_folder_id is null ";
			  	pstmt_facility =	con.prepareStatement(sqlString);
				rs1 = pstmt_facility.executeQuery();	
					rs1.next();
					file_creat_fac_id = rs1.getString("FACILITY_ID");
					 if(file_creat_fac_id == null || file_creat_fac_id.equals("")) file_creat_fac_id = "";
					if(rs1 != null) rs1.close();
					if(pstmt_facility != null) pstmt_facility.close();
					
					pstmt_check.setString(1,addedFacilityId);
					pstmt_check.setString(2,file_no);
					pstmt_check.setString(3,volume_no);
				  					
					rs1 = pstmt_check.executeQuery();
									
					rs1.next();
				    	temp_curr = rs1.getString("CURR_FILE_STATUS");
					 prev_fs_locn_code= rs1.getString("curr_fs_locn_code");
					 prev_locn_id       = rs1.getString("curr_locn_id");
					prev_facility_id	 = rs1.getString("curr_facility_id");	 	
					perm_fs_locn_code=  rs1.getString("perm_fs_locn_code");	 
					if(prev_fs_locn_code==null || prev_fs_locn_code.equals("")) prev_fs_locn_code = "";
					if(prev_locn_id==null || prev_locn_id.equals("")) prev_locn_id = "";
				   if(prev_facility_id == null || prev_facility_id.equals("")) prev_facility_id = "";
				  if(perm_fs_locn_code == null || perm_fs_locn_code.equals("")) perm_fs_locn_code = "";
					 if(rs1 != null) rs1.close();
			
			  sqlString1="SELECT * FROM FM_REQ_HDR A,FM_REQ_dtl B WHERE A.REQ_NO = B.REQ_NO  AND B.PATIENT_ID =?  AND B.CURR_FS_LOCN_CODE =?  AND EXISTS (SELECT 1 FROM FM_CURR_LOCN  WHERE FILE_NO =B.FILE_NO AND VOLUME_NO = B.VOLUME_NO) " ;

			
			int hrs = 0;		
		 if(locn_identity.equals("C") || locn_identity.equals("N")|| locn_identity.equals("D"))
		{
			sql = "SELECT (CASE WHEN  LOCN_IDENTITY in('C','E') THEN NO_OF_DH_TO_RETURN_OP  ELSE (CASE WHEN LOCN_IDENTITY = 'N' THEN NO_OF_DH_TO_RETURN_IP ELSE (CASE WHEN LOCN_IDENTITY = 'Y' THEN NO_OF_DH_TO_RETURN_DC END) END) END) ,duration_type FROM fm_storage_locn WHERE FS_LOCN_CODE =? AND FACILITY_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,fs_locn_code);
			pstmt.setString(2,facilityId);
			rset = pstmt.executeQuery();
			while(rset != null && rset.next())
			{
				number			= rset.getString(1);
				duration_type	= rset.getString(2);
			 
				}
			
			if(rset  !=null) rset.close();
			if(pstmt !=null) pstmt.close();

			if(number==null || number.equals("")) number = "0";
			if(duration_type == null || duration_type.equals("null"))	  duration_type = "";
        if(duration_type.equals("D")) hrs = Integer.parseInt(number)*24;
			else if(duration_type.equals("H")) hrs = Integer.parseInt(number);
			
		}

		//sql = "Select to_char(SYSDATE+"+(hrs)+"/24,'DD/MM/YYYY HH24:MI') RET, SHORT_DESC,RETURN_CRITERIA from FM_STORAGE_LOCN Where FACILITY_ID = ? and FS_LOCN_CODE = ? ";
		sql = "SELECT to_char(SYSDATE + "+(hrs)+" / 24,'dd/mm/yyyy hh24:mi') RET, RETURN_CRITERIA FROM   FM_STORAGE_LOCN_LANG_VW WHERE  FACILITY_ID = ? AND FS_LOCN_CODE = ? AND language_id= ? ";
 	  
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,facilityId);
		pstmt.setString(2,fs_locn_code);
		pstmt.setString(3,locale);
		rset = pstmt.executeQuery();

		if(rset != null && rset.next())
		{
			returndays		= rset.getString(1);
		    return_criteria = rset.getString(2);
				}
		
		if(rset  !=null) rset.close();
		if(pstmt !=null) pstmt.close();		

     if(return_criteria == null || return_criteria.equals("null")) return_criteria = "";
	  if(hrs<=0 || return_criteria.equals("D"))
		{
     returndays =null;
		}
		
		if(returndays != null )
		{
		//returndays=DateUtils.convertDate(returndays,"DMYHM","en",locale);
		}else
			returndays = "";

		
	
		if(return_criteria.equals("I") || locn_identity.equals("D")|| locn_identity.equals("C")|| 
		locn_identity.equals("N"))
		{
			daystoreturn = returndays;
			}
		else
		{
			daystoreturn = "";
		 }
			
			//////////////////////////////////////////////////////////////////////
					
                  	if(fs_locn.equals("P") && temp_curr.equals("I"))
					{
						
                  		pstmt_upd.setString	(1,	fs_locn_code );
						pstmt_upd.setString	(2,	added_by_id );
						pstmt_upd.setString	(3,	added_at_ws_no );
						pstmt_upd.setString	(4,	added_facility_id );
						pstmt_upd.setString	(5,	file_no );
						pstmt_upd.setString	(6,	facilityId );
						
						update_count = pstmt_upd.executeUpdate() ;		
		/////////////////////////////////////////////////////////////////////////
												
						pstmt_mul.setString	(1,	fs_locn_code );
						pstmt_mul.setString	(2,	fs_locn_code );

						if(fs_locn_code.equals(other_locn_code))
						{
							pstmt_mul.setString	(3,	"Y");
							pstmt_mul.setString	(4,	"Y");
						}
						else
						{
							pstmt_mul.setString	(3,	"X");
							pstmt_mul.setString	(4,	"Y");
						}
						pstmt_mul.setString	(5,	added_by_id );
						pstmt_mul.setString	(6,	added_at_ws_no );
						pstmt_mul.setString	(7,	added_facility_id );
						pstmt_mul.setString	(8,	file_no );
						pstmt_mul.setString	(9,	facilityId );
						pstmt_mul.setString	(10,	volume_no );
						
						pstmt_mul.executeUpdate() ;
				//////////////////////////////////////////////////////////////////////

						pstmt_ins.setString	(1,	facilityId );
						pstmt_ins.setString	(2,	file_no );
						pstmt_ins.setString	(3,	file_type_code );
						pstmt_ins.setString	(4,	volume_no );
						pstmt_ins.setString	(5,	patient_id );
						pstmt_ins.setString	(6,	facilityId );
						pstmt_ins.setString	(7,	fs_locn_disp );
						pstmt_ins.setString	(8,	curr_fs_locn_identity );
						pstmt_ins.setString	(9, curr_holder_name );
						pstmt_ins.setString	(10, facilityId );
						pstmt_ins.setString	(11, fs_locn_code );
						pstmt_ins.setString	(12, locn_identity );
						pstmt_ins.setString	(13, holder_name );
						pstmt_ins.setString	(14, curr_mr_locn_yn );
						pstmt_ins.setString	(15, mr_locn_yn );
						pstmt_ins.setString	(16, added_by_id );
						pstmt_ins.setString	(17, added_at_ws_no );
						pstmt_ins.setString	(18, added_facility_id );
						pstmt_ins.setString	(19, added_by_id );
						pstmt_ins.setString	(20, added_at_ws_no );
						pstmt_ins.setString	(21, added_facility_id );
						pstmt_ins.setString	(22, "C");
						pstmt_ins.setString	(23, doc_folder_id);
						pstmt_ins.setString	(24, doc_type_code);
					
						insert_count = pstmt_ins.executeUpdate() ;
					}
					else
					{						
			//////////////////////////////////////////////////////////////////////			
												
						if(fs_locn.equals("P"))
						{
							pstmt_upd.setString	(1,	fs_locn_code );
							pstmt_upd.setString	(2,	added_by_id );
							pstmt_upd.setString	(3,	added_at_ws_no );
							pstmt_upd.setString	(4,	file_creat_fac_id );
							pstmt_upd.setString	(5,	file_no );
							pstmt_upd.setString	(6,	file_creat_fac_id );

							update_count = pstmt_upd.executeUpdate() ;
						}
						else if(fs_locn.equals("C"))
						{
						
				            pstmt_upd.setString	(1,	fs_locn_code );
							pstmt_upd.setString	(2,	facilityId );
						/*	if(fs_locn_code.equals(other_locn_code))
							{
								pstmt_upd.setString	(3,	"Y");
								pstmt_upd.setString	(4,	"Y");
								pstmt_upd.setString	(5,	"I");
							} */
						//	if(fs_locn_code.equals(other_locn_code) || (locn_iden.equals("D") && permanent_file_area_yn.equals("Y")))
						if(fs_locn_code.equals(perm_fs_locn_code))
							{
                                pstmt_upd.setString	(3,	"Y");
								pstmt_upd.setString	(4,	"Y");
								pstmt_upd.setString	(5,	"I");
							}
							else
							{
								pstmt_upd.setString	(3,	"X");
								pstmt_upd.setString	(4,	"Y");
								pstmt_upd.setString	(5,	"O");
							}
							pstmt_upd.setString	(6,	locn_identity );
							pstmt_upd.setString	(7,	added_by_id );
							pstmt_upd.setString	(8,	added_at_ws_no );
							pstmt_upd.setString	(9,	file_creat_fac_id);
							pstmt_upd.setString	(10,prev_locn_id);
														
							pstmt_upd.setString	(11,prev_fs_locn_code);
							pstmt_upd.setString	(12,daystoreturn);
							pstmt_upd.setString	(13,prev_facility_id);
							
							pstmt_upd.setString	(14,	file_no );
							pstmt_upd.setString	(15, file_creat_fac_id);
							pstmt_upd.setString	(16, volume_no );
						  	update_count = pstmt_upd.executeUpdate() ;
						   	//////////////////////////////////////////////////////////////////////

							pstmt_ins.setString	(1,	facilityId );
							pstmt_ins.setString	(2,	file_no );
							pstmt_ins.setString	(3,	file_type_code );
							pstmt_ins.setString	(4,	volume_no );
							pstmt_ins.setString	(5,	patient_id );
							pstmt_ins.setString	(6,	curr_facility_id );
							pstmt_ins.setString	(7,	fs_locn_disp );
							pstmt_ins.setString	(8,	curr_fs_locn_identity );
							pstmt_ins.setString	(9, curr_holder_name );
							pstmt_ins.setString	(10, facilityId );
							pstmt_ins.setString	(11, fs_locn_code );
							pstmt_ins.setString	(12, locn_identity );
							pstmt_ins.setString	(13, holder_name );
							pstmt_ins.setString	(14, curr_mr_locn_yn );
							pstmt_ins.setString	(15, mr_locn_yn );
							pstmt_ins.setString	(16, added_by_id );
							pstmt_ins.setString	(17, added_at_ws_no );
							pstmt_ins.setString	(18, added_facility_id );
							pstmt_ins.setString	(19, added_by_id );
							pstmt_ins.setString	(20, added_at_ws_no );
							pstmt_ins.setString	(21, added_facility_id );
							pstmt_ins.setString	(22, "C");
							pstmt_ins.setString	(23, doc_folder_id);
							pstmt_ins.setString	(24, doc_type_code);
							
							insert_count = pstmt_ins.executeUpdate() ;
			//////////////////////////////////////////////////////////////////////
					}
				}
			}
		}//End of IF
		if(fs_locn.equals("C"))
		{
			if((update_count > 0) && (insert_count > 0))
				insert_flag = true;
			else
				insert_flag = false;
		}
		else if(fs_locn.equals("P") && temp_curr.equals("I"))
		{
			if((update_count > 0) && (insert_count > 0))
				insert_flag = true;
			else
				insert_flag = false;
		}
		else
		{
			if(update_count > 0)
				insert_flag = true;
			else
				insert_flag = false;
		}
		if(insert_flag)
		{
			result = true ;
			con.commit();
			java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_MODIFIED,"SM" ) ;
			sb.append( (String) message.get("message") ) ;
			message.clear();
		}
		else
		{
			result = false ;
			con.rollback();
		}	
		htRecord.clear();
		if(rs1 != null) rs1.close();
		if(rset  !=null) rset.close();
		if(pstmt_upd != null) pstmt_upd.close();
		if(pstmt_check != null) pstmt_check.close();
		if(pstmt_mul != null) pstmt_mul.close();
		if(pstmt_ins != null) pstmt_ins.close();
	    if(pstmt_facility != null) pstmt_facility.close();
		if(pstmt !=null) pstmt.close();
	   if(pstmt1 !=null) pstmt.close();
	}
	catch(Exception e)
	{
		sb.append("Exception in ChangeFileStorageLocation :"+e.getMessage());
		e.printStackTrace();
		if ( con != null )
		{
			try
			{
				con.rollback();
			}
			catch(Exception ce) {sb.append("Exception  ce:"+ce.getMessage());}
		}
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con, p);
	}
	results.put("status", new Boolean(result));
	results.put("error", sb.toString());
	return results ;
	}
}
