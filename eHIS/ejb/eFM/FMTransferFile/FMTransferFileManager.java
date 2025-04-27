/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMTransferFile;

import javax.ejb.* ;

import java.sql.*;
import java.rmi.*;
import java.io.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import webbeans.eCommon.*;
import com.ehis.util.*;


/**
*
* @ejb.bean
*	name="FMTransferFile"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMTransferFile"
*	local-jndi-name="FMTransferFile"
*	impl-class-name="eFM.FMTransferFile.FMTransferFileManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMTransferFile.FMTransferFileLocal"
*	remote-class="eFM.FMTransferFile.FMTransferFileRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMTransferFile.FMTransferFileLocalHome"
*	remote-class="eFM.FMTransferFile.FMTransferFileHome"
*	generate= "local,remote"
*
*
*/

public class FMTransferFileManager implements SessionBean 
{
	Connection con           = null;
	PreparedStatement pstmt  = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	PreparedStatement pstmt4 = null;
	PreparedStatement pstmt5 = null;
	PreparedStatement pstmt6 = null;
	ResultSet rset			 = null;
	ResultSet rset1			 = null;
	Statement stmt1			= null;
	
	//Added for this CRF HSA-CRF-0306.1
	PreparedStatement pstmt7 = null; 
	CallableStatement cstmt = null;

	
	public final String RECORD_INSERTED		= "RECORD_INSERTED" ;
		
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext ctx ) {}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap createTransferFile(
							java.util.Properties	p,
							java.util.HashMap		httransferFiles
						 ) 
		{
		StringBuffer sb	= new StringBuffer( "" ) ;
		java.util.HashMap results = new java.util.HashMap() ;

		boolean result	= false ;	
		int ins_move_dtl	= 0;
		int upd_curr_locn	= 0;
		
		StringBuffer sql	= new StringBuffer();

		String sql1		= "";
		String sql2		= "";
		String sql3		= "";
		String sql4		= "";
		String sql5		= "";
	     String sql6		= "";
		String sql7     = ""; //Added for this CRF HSA-CRF-0306.1
		String option	= "";

		String auto_rec_ward_yn		= "";
		String auto_rec_clinic_yn	= ""; 
		String auto_rec_pract_yn	= ""; 
		String auto_rec_dept_yn	= ""; 
		String sys_date				= "";
		String login_facility_id	= "";
		String addedById			= "";
		String addedAtWorkstation	= "";
		String transfer_file_nos	= "";

		String p_file_no		 = "";
		String p_volume_no		 = "";
		String p_file_type		 = "";
		String p_doc_type		 = "";
		String p_doc_folder		 = "";
		String p_from_locn		 = "";
		String p_to_locn		 = "";
		String p_to_narration	 = "";
		String p_src_user_id	 = "";
		String p_trans_to		 = "";
		String x_system_date		= "";
		String x_patient_id			= "";
		String x_src_locn_identity  = "";
		String x_src_mr_locn		= "";
		String x_dest_locn_identity = "";
		String x_dest_mr_locn		= "";
		String x_dest_user		= "",p_iss_remarks="";
		String transport_mode	= "",carried_by_name="";
		String x_curr_locn_id	= "";
		String locale	= "";
		String x_x_facility_id="";
        String return_criteria="";
	   	String daystoreturn="";
	//	String duration_type="";
		String returndays="";
		String number="";
		String x_perm_file_area_yn="N";
		String x_perm_fs_locn_code="";
		int x_dest_return_days	= 0;
		
		//Added for this CRF HSA-CRF-0306.1
		boolean isSiteSpecific=false;
		String current_date="";
		String isCurrentFsLocation =""; 
		String noofdhtoreturn="";
        String duration_type="";
        String fslocn_return_criteria="";
        String patientClass="";
        String assigncarecode="";
        String dischargedatetime="";
        String patient_id ="";

		//String returndate			= ""; //Commented for checkstyle
		//String returndateSqlQuery	= ""; //Commented for checkstyle
		//String permanent_file_area_yn	= ""; //Commented for checkstyle
      
		try
		{
			con	= ConnectionManager.getConnection(p);

			login_facility_id	= (String) httransferFiles.get ( "login_facility_id" );
			addedById			= (String) httransferFiles.get ( "login_user_id" );
			addedAtWorkstation	= (String) httransferFiles.get ( "addedAtWorkstation" );
			transfer_file_nos	= (String) httransferFiles.get ( "transfer_file_nos" );
			p_from_locn			= (String) httransferFiles.get ( "from_locn_code" );
			p_src_user_id		= (String) httransferFiles.get ( "transfer_user_id" );
			p_iss_remarks		= (String) httransferFiles.get ( "p_iss_remarks" );
			transport_mode		= (String) httransferFiles.get ( "file_transport_mode" );
			carried_by_name		= (String) httransferFiles.get ( "carried_by_name" );			
			auto_rec_ward_yn	= (String) httransferFiles.get ( "auto_rec_ward_yn" );
			auto_rec_clinic_yn	= (String) httransferFiles.get ( "auto_rec_clinic_yn" );
			auto_rec_pract_yn	= (String) httransferFiles.get ( "auto_rec_pract_yn" );
			auto_rec_dept_yn	= (String) httransferFiles.get ( "auto_rec_dept_yn" );
			locale	= (String) httransferFiles.get ( "locale" );
			
			//Added for this CRF HSA-CRF-0306.1
			isCurrentFsLocation = (String) httransferFiles.get ( "isCurrentFsLocation" );
            noofdhtoreturn = (String) httransferFiles.get ( "noofdhtoreturn" ); 
            duration_type = (String) httransferFiles.get ( "duration_type" ); 
            fslocn_return_criteria = (String) httransferFiles.get ( "fslocn_return_criteria" ); 
			current_date = (String) httransferFiles.get("current_date"); //Added for this CRF HSA-CRF-306.1 linked incident
            isSiteSpecific = Boolean.parseBoolean(isCurrentFsLocation);
           
		   /* patientClass = (String) httransferFiles.get ( "patientClass" ); 
            assigncarecode = (String) httransferFiles.get ( "assigncarecode" );
            dischargedatetime = (String) httransferFiles.get ( "dischargedatetime" ); */

			httransferFiles.clear();
			
 			sql.append("Select A.PATIENT_ID,A.FACILITY_ID, B.LOCN_IDENTITY CURR_FS_LOCN_IDENTITY,C.PERMANENT_FILE_AREA_YN  PERMANENT_FILE_AREA_YN , B.MR_LOCN_YN CURR_MR_LOCN, C.LOCN_IDENTITY DEST_FS_LOCN_IDENTITY, C.MR_LOCN_YN DEST_MR_LOCN, NVL(C.NO_OF_DAYS_TO_RETURN,0) DEST_RETURN_DAYS, C.HOLDER_NAME DEST_USER,A.CURR_LOCN_ID,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE,A.PERM_FS_LOCN_CODE From FM_CURR_LOCN_VW A, FM_STORAGE_LOCN B, FM_STORAGE_LOCN C Where A.CURR_FACILITY_ID = ? AND A.FILE_NO = ? AND A.VOLUME_NO = ? AND A.CURR_FS_LOCN_CODE = ? AND A.CURR_FACILITY_ID = B.FACILITY_ID AND A.CURR_FS_LOCN_CODE = B.FS_LOCN_CODE AND A.CURR_FACILITY_ID = C.FACILITY_ID AND C.FS_LOCN_CODE = ? ");
			pstmt = con.prepareStatement( sql.toString() );

			sql1 = " INSERT INTO FM_MOVEMENT_LOG (FACILITY_ID, FILE_NO, FILE_TYPE_CODE, VOLUME_NO, PATIENT_ID, SENT_DATE_TIME, SRC_FACILITY_ID, SRC_FS_LOCN_CODE, SRC_LOCN_IDENTITY, SRC_USER_ID, REC_DATE_TIME, DEST_FACILITY_ID, DEST_FS_LOCN_CODE, DEST_LOCN_IDENTITY, DEST_USER_ID, NARRATION_CODE, MOVEMENT_TYPE, SRC_MR_LOCN_YN, DEST_MR_LOCN_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,ISS_REMARKS,TRANSPORT_MODE,CARRIED_BY_NAME,DOC_FOLDER_ID,DOC_TYPE_CODE) VALUES(?,?,?,?,?,SYSDATE,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,'F',?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?)" ;
			pstmt1 = con.prepareStatement( sql1 );

				
			//sql2 = "Update FM_CURR_LOCN SET ISS_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'), CURR_FACILITY_ID = ?, CURR_FILE_STATUS = ?, CURR_FS_LOCN_CODE = ?, CURR_FS_LOCN_IDENTITY = ?, CURR_HOLDER_USER_ID = ?, NARRATION_CODE = ?, LAST_MOVEMENT_DATE_TIME = SYSDATE, RETURN_DATE_TIME = (SYSDATE+?), PREV_FACILITY_ID = ?, PREV_FS_LOCN_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,REMARKS = ?, CURR_LOCN_ID= ?, PREV_LOCN_ID = ? Where Facility_id = ? AND File_no = ? AND VOLUME_NO = ? ";

               //below line modified for this CRF HSA-CRF-0306.1  
               	if(isSiteSpecific){        
				sql2 = "Update FM_CURR_LOCN SET ISS_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'), CURR_FACILITY_ID = ?, CURR_FILE_STATUS = ?, CURR_FS_LOCN_CODE = ?, CURR_FS_LOCN_IDENTITY = ?, CURR_HOLDER_USER_ID = ?, NARRATION_CODE = ?, LAST_MOVEMENT_DATE_TIME = SYSDATE, PREV_FACILITY_ID = ?, PREV_FS_LOCN_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,REMARKS = ?, CURR_LOCN_ID= ?, PREV_LOCN_ID = ? Where Facility_id = ? AND File_no = ? AND VOLUME_NO = ? ";
	            }else{				 
				 sql2 = "Update FM_CURR_LOCN SET ISS_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'), CURR_FACILITY_ID = ?, CURR_FILE_STATUS = ?, CURR_FS_LOCN_CODE = ?, CURR_FS_LOCN_IDENTITY = ?, CURR_HOLDER_USER_ID = ?, NARRATION_CODE = ?, LAST_MOVEMENT_DATE_TIME = SYSDATE, RETURN_DATE_TIME = (SYSDATE+?), PREV_FACILITY_ID = ?, PREV_FS_LOCN_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,REMARKS = ?, CURR_LOCN_ID= ?, PREV_LOCN_ID = ? Where Facility_id = ? AND File_no = ? AND VOLUME_NO = ? ";
				}
			    pstmt2 = con.prepareStatement( sql2 );
			

		//	sql3 = "Update FM_CURR_LOCN SET ISS_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'), CURR_FACILITY_ID = ?, CURR_FILE_STATUS = 'T', CURR_FS_LOCN_CODE = ?, CURR_FS_LOCN_IDENTITY = ?, CURR_HOLDER_USER_ID = ?, NARRATION_CODE = ?, LAST_MOVEMENT_DATE_TIME = SYSDATE, RETURN_DATE_TIME =to_date(?,'dd/mm/rrrr hh24:mi'), PREV_FACILITY_ID = ?, PREV_FS_LOCN_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, REMARKS = ?,CURR_LOCN_ID =?,PREV_LOCN_ID = ? Where Facility_id = ? AND File_no = ? AND VOLUME_NO = ? ";
		
		    //below line modified for this CRF HSA-CRF-0306.1  
		    if(isSiteSpecific){
			sql3 = "Update FM_CURR_LOCN SET ISS_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'), CURR_FACILITY_ID = ?, CURR_FILE_STATUS = 'T', CURR_FS_LOCN_CODE = ?, CURR_FS_LOCN_IDENTITY = ?, CURR_HOLDER_USER_ID = ?, NARRATION_CODE = ?, LAST_MOVEMENT_DATE_TIME = SYSDATE, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, REMARKS = ?,CURR_LOCN_ID =?  Where Facility_id = ? AND File_no = ? AND VOLUME_NO = ? ";
			}else{
			sql3 = "Update FM_CURR_LOCN SET ISS_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'), CURR_FACILITY_ID = ?, CURR_FILE_STATUS = 'T', CURR_FS_LOCN_CODE = ?, CURR_FS_LOCN_IDENTITY = ?, CURR_HOLDER_USER_ID = ?, NARRATION_CODE = ?, LAST_MOVEMENT_DATE_TIME = SYSDATE, RETURN_DATE_TIME =to_date(?,'dd/mm/rrrr hh24:mi'), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, REMARKS = ?,CURR_LOCN_ID =?  Where Facility_id = ? AND File_no = ? AND VOLUME_NO = ? ";	
			
			}
			
			pstmt3 = con.prepareStatement( sql3 );
			
			sql4 = "Update FM_CURR_LOCN SET ISS_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI'), CURR_FACILITY_ID = ?, CURR_FILE_STATUS ='I', CURR_FS_LOCN_CODE = ?, CURR_FS_LOCN_IDENTITY = ?, CURR_HOLDER_USER_ID = ?, NARRATION_CODE = ?, LAST_MOVEMENT_DATE_TIME = SYSDATE, RETURN_DATE_TIME =to_date(?,'dd/mm/rrrr hh24:mi'), PREV_FACILITY_ID = ?, PREV_FS_LOCN_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, REMARKS = ?,CURR_LOCN_ID =?,PREV_LOCN_ID = ? Where Facility_id = ? AND File_no = ? AND VOLUME_NO = ? ";
			pstmt4 = con.prepareStatement( sql3 );
			
			sql5 = " INSERT INTO FM_TRANSIT_FILE (FACILITY_ID, FILE_NO, FILE_TYPE_CODE, VOLUME_NO, PATIENT_ID, SENT_DATE_TIME, SRC_FACILITY_ID, SRC_FS_LOCN_CODE, SRC_LOCN_IDENTITY,  DEST_FACILITY_ID, DEST_FS_LOCN_CODE, DEST_LOCN_IDENTITY, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,ISS_REMARKS,DOC_FOLDER_ID,DOC_TYPE_CODE) VALUES(?,?,?,?,?,SYSDATE,?,?,?,?,?,?,?,SYSDATE,?,?,?,?,?)" ;
			pstmt5 = con.prepareStatement( sql5 );
			
			//Added for this CRF HSA-CRF-0306.1
			/*sql7 = "Update FM_CURR_LOCN SET RETURN_DATE_MANUAL_YN='N', RETURN_DATE_TIME='', REC_RETURN_DATE_TIME=to_date(?,'dd/mm/yyyy hh24:mi'), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? Where Facility_id = ? AND File_no = ? AND VOLUME_NO = ?";*/
			
			sql7 = "Update FM_CURR_LOCN SET RETURN_DATE_MANUAL_YN='N', RETURN_DATE_TIME='', REC_RETURN_DATE_TIME=SYSDATE, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? Where Facility_id = ? AND File_no = ? AND VOLUME_NO = ?";
			pstmt7 = con.prepareStatement( sql7 );
			
			System.err.println("FMTransferFileManager.java sql7===>"+sql7);
			//End HSA-CRF-0306.1
			
			
            						
			StringTokenizer token = new StringTokenizer(transfer_file_nos,"|");

			
		
			while(token.hasMoreTokens())
			{
				if(token.hasMoreTokens())
				p_file_no		= token.nextToken();
									
				if(token.hasMoreTokens())
				p_file_type		= token.nextToken();
						
				if(token.hasMoreTokens())
				p_volume_no		= token.nextToken();
				if(token.hasMoreTokens())
				p_doc_folder	= token.nextToken();
				if(token.hasMoreTokens())
				p_doc_type		= token.nextToken();
				if(token.hasMoreTokens())
				p_to_locn		= token.nextToken();
					if(token.hasMoreTokens())
				p_to_narration	= token.nextToken();
				if(token.hasMoreTokens())
					patientClass		= token.nextToken();
				if(token.hasMoreTokens())
					assigncarecode		= token.nextToken();
				if(token.hasMoreTokens())
					dischargedatetime 	= token.nextToken();
				if(token.hasMoreTokens())
					patient_id 	= token.nextToken();
				if(token.hasMoreTokens())
					p_trans_to		= token.nextToken();
			
			




				if(p_to_narration.equals("THISISSPACE") || p_file_type == null || p_file_type.equals("null"))
					p_to_narration = "";
				if(p_file_type.equals("THISISSPACE") || p_file_type == null || p_file_type.equals("null"))
					p_file_type = "";
				if(p_volume_no.equals("THISISSPACE") ||  p_file_type == null || p_file_type.equals("null"))
					p_volume_no = "";
				if(p_doc_type.equals("THISISSPACE") ||  p_doc_type == null || p_doc_type.equals("null"))
					p_doc_type = "";
				if(p_doc_folder.equals("THISISSPACE") ||  p_doc_folder == null || p_doc_folder.equals("null"))
					p_doc_folder = "";
                 //Added for this CRF HSA-CRF-0306.1
                 if(dischargedatetime.equals("THISISSPACE") || dischargedatetime == null || dischargedatetime.equals("null"))
					dischargedatetime = "";
			

		/////////////////////////sql Query //////////////////////////////////////////////	
		
				pstmt.setString	( 1, login_facility_id) ;
				pstmt.setString	( 2, p_file_no) ;
				pstmt.setString	( 3, p_volume_no) ;
				pstmt.setString	( 4, p_from_locn) ;
				pstmt.setString	( 5, p_to_locn) ;
						
						
				
				rset = pstmt.executeQuery();
				while(rset.next())
				{
					x_patient_id		 = rset.getString("PATIENT_ID");
					x_x_facility_id		 = rset.getString("FACILITY_ID");
					x_src_locn_identity  = rset.getString("CURR_FS_LOCN_IDENTITY");
					x_src_mr_locn		 = rset.getString("CURR_MR_LOCN");
					x_dest_locn_identity = rset.getString("DEST_FS_LOCN_IDENTITY");
					x_perm_file_area_yn   = rset.getString("PERMANENT_FILE_AREA_YN");
					x_perm_fs_locn_code   = rset.getString("PERM_FS_LOCN_CODE");
					x_dest_mr_locn		 = rset.getString("DEST_MR_LOCN");
					x_dest_return_days	 = rset.getInt("DEST_RETURN_DAYS");
					x_dest_user			 = rset.getString("DEST_USER");
					x_curr_locn_id		 = rset.getString("CURR_LOCN_ID");	
					sys_date			 = rset.getString("SYDATE");	
						}
				if (rset!=null)    rset.close();

		//////////////////////////////End of sql Query////////////////////////////////////////////////

				if(x_dest_locn_identity.equals("C") && auto_rec_clinic_yn.equals("Y"))
				{   x_system_date = sys_date;		option = "1";		}
				else if(x_dest_locn_identity.equals("N") && auto_rec_ward_yn.equals("Y"))
				{   x_system_date = sys_date;		option = "1";		}
				else if(x_dest_locn_identity.equals("T") && auto_rec_pract_yn.equals("Y"))
				{   x_system_date = sys_date;		option = "1";		}
				else if(x_dest_locn_identity.equals("D") && auto_rec_dept_yn.equals("Y"))
				{   x_system_date = sys_date;		option = "1";		}
				else	
					option = "2";

		////////////////////////////sql1 Query//////////////////////////////////////////////////
				
				pstmt1.setString	( 1, x_x_facility_id) ;
				pstmt1.setString	( 2, p_file_no) ;
				pstmt1.setString	( 3, p_file_type) ;
				pstmt1.setString	( 4, p_volume_no) ;
				pstmt1.setString	( 5, x_patient_id) ;
				pstmt1.setString	( 6, login_facility_id) ;
				pstmt1.setString	( 7, p_from_locn) ;
				pstmt1.setString	( 8, x_src_locn_identity) ;
				pstmt1.setString	( 9, p_src_user_id) ;
				pstmt1.setString	( 10, x_system_date) ;
				pstmt1.setString	( 11, login_facility_id) ;
				pstmt1.setString	( 12, p_to_locn) ;
				pstmt1.setString	( 13, x_dest_locn_identity) ;
				pstmt1.setString	( 14, x_dest_user) ;
				pstmt1.setString	( 15, p_to_narration) ;
				pstmt1.setString	( 16, x_src_mr_locn) ;
				pstmt1.setString	( 17, x_dest_mr_locn) ;
				pstmt1.setString	( 18, addedById ) ;
				pstmt1.setString	( 19, addedAtWorkstation ) ;
				pstmt1.setString	( 20, login_facility_id ) ;
				pstmt1.setString	( 21, addedById ) ;
				pstmt1.setString	( 22, addedAtWorkstation) ;
				pstmt1.setString	( 23, login_facility_id) ;
				pstmt1.setString	( 24, p_iss_remarks) ;
				pstmt1.setString	( 25, carried_by_name) ;
				pstmt1.setString	( 26, transport_mode) ;
				pstmt1.setString	( 27, p_doc_folder) ;
				pstmt1.setString	( 28, p_doc_type) ;
				
						
				ins_move_dtl = pstmt1.executeUpdate() ;

	///////////////////////////sql1 Query///////////////////////////////////////////////////
				
				String x_dtl_sysdate = "";
				String x_dtl_prev_facility = "";
				String x_dtl_prev_locn = "";
				//if(x_src_mr_locn.equals("Y"){
				//Above line commented and below line added for this CRF HSA-CRF-0306.1
				if(x_src_mr_locn.equals("Y") || isCurrentFsLocation.equals("true"))
				{					
					x_dtl_sysdate = sys_date;
					x_dtl_prev_facility = login_facility_id;
					x_dtl_prev_locn = p_from_locn;
							
				}
				
				if(option.equals("1"))
				{					
		//////////////////////////End of sql1 Query/////////////////////////////////////////////	

					
						pstmt2.setString ( 1, x_dtl_sysdate) ;
						pstmt2.setString ( 2, login_facility_id) ;
					if(x_dest_locn_identity.equals("D") && x_perm_file_area_yn.equals("Y"))
					{
						pstmt2.setString ( 3,"I" ) ;
					}else{
						pstmt2.setString ( 3,"O" ) ;
					}
						pstmt2.setString ( 4, p_to_locn) ;
						pstmt2.setString ( 5, x_dest_locn_identity) ;
						pstmt2.setString ( 6, x_dest_user) ;
						pstmt2.setString ( 7, p_to_narration) ;
						
						//Below line Added for this CRF HSA-CRF-0306.1	

					if(isSiteSpecific){
					    pstmt2.setString ( 8, x_dtl_prev_facility) ;
						pstmt2.setString ( 9, x_dtl_prev_locn) ;
						pstmt2.setString ( 10, addedById ) ;
						pstmt2.setString ( 11, addedAtWorkstation) ;
						pstmt2.setString ( 12, login_facility_id) ;
						pstmt2.setString ( 13, p_iss_remarks) ;
						pstmt2.setString ( 14, p_trans_to) ;
						pstmt2.setString ( 15, x_curr_locn_id) ;
						pstmt2.setString ( 16, x_x_facility_id) ;
						pstmt2.setString ( 17, p_file_no) ;
						pstmt2.setString ( 18, p_volume_no) ;				   
					}else{				   
							if(x_dest_locn_identity.equals("D"))
							{
								  pstmt2.setString  (8,"") ;
							} else{							  
								   pstmt2.setInt    (8, x_dest_return_days) ;
								
							}
										

						pstmt2.setString ( 9, x_dtl_prev_facility) ;
						pstmt2.setString ( 10, x_dtl_prev_locn) ;
						pstmt2.setString ( 11, addedById ) ;
						pstmt2.setString ( 12, addedAtWorkstation) ;
						pstmt2.setString ( 13, login_facility_id) ;
						pstmt2.setString ( 14, p_iss_remarks) ;
						pstmt2.setString ( 15, p_trans_to) ;
						pstmt2.setString ( 16, x_curr_locn_id) ;
						pstmt2.setString ( 17, x_x_facility_id) ;
						pstmt2.setString ( 18, p_file_no) ;
						pstmt2.setString ( 19, p_volume_no) ;
						}
						
						upd_curr_locn = pstmt2.executeUpdate() ;
						//Incident NO-29472 starts  by srinivas Y
						
                        //Incident NO-29472 ends  by srinivas Y		
				
						
						
			///////////////////////////////////////////////////////////////////////
				}
				else if(option.equals("2"))
				{					
			///////////////////////////////////////////////////////////////////////	
	           			
		int hrs = 0;		
		 if(x_src_locn_identity.equals("C") || x_src_locn_identity.equals("N")|| x_src_locn_identity.equals("D") || x_src_locn_identity.equals("E") )
		{
			sql6 = "SELECT (CASE WHEN  LOCN_IDENTITY in('C','E') THEN NO_OF_DH_TO_RETURN_OP  ELSE (CASE WHEN LOCN_IDENTITY = 'N' THEN NO_OF_DH_TO_RETURN_IP ELSE (CASE WHEN LOCN_IDENTITY = 'Y' THEN NO_OF_DH_TO_RETURN_DC END) END) END) ,duration_type FROM fm_storage_locn WHERE FS_LOCN_CODE =? AND FACILITY_ID = ?";
			pstmt6 = con.prepareStatement(sql6);
			pstmt6.setString(1,p_to_locn);
			pstmt6.setString(2,login_facility_id);
			rset = pstmt6.executeQuery();
			while(rset != null && rset.next())
			{
			number			= rset.getString(1);
			duration_type	= rset.getString(2);
			}
			
			if(rset  !=null) rset.close();
			if(pstmt6 !=null) pstmt6.close();

			if(number==null || number.equals("")) number = "0";
			if(duration_type == null || duration_type.equals("null"))	  duration_type = "";
        if(duration_type.equals("D")) hrs = Integer.parseInt(number)*24;
			else if(duration_type.equals("H")) hrs = Integer.parseInt(number);
			
		}

		//sql = "Select to_char(SYSDATE+"+(hrs)+"/24,'DD/MM/YYYY HH24:MI') RET, SHORT_DESC,RETURN_CRITERIA from FM_STORAGE_LOCN Where FACILITY_ID = ? and FS_LOCN_CODE = ? ";
		sql6 = "SELECT to_char(SYSDATE + "+(hrs)+" / 24,'dd/mm/yyyy hh24:mi') RET, RETURN_CRITERIA FROM   FM_STORAGE_LOCN_LANG_VW WHERE  FACILITY_ID = ? AND FS_LOCN_CODE = ? AND language_id= ? ";
 	  
		pstmt6 = con.prepareStatement(sql6);
		pstmt6.setString(1,login_facility_id);
		pstmt6.setString(2,p_to_locn);
		pstmt6.setString(3,locale);
		rset = pstmt6.executeQuery();

		if(rset != null && rset.next())
		{
			returndays		= rset.getString(1);
		    return_criteria = rset.getString(2);
				}
		
		if(rset  !=null) rset.close();
		if(pstmt6 !=null) pstmt6.close();		

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

		
	
	
		if(return_criteria.equals("I") || x_src_locn_identity.equals("D")|| x_src_locn_identity.equals("C")|| 
		x_src_locn_identity.equals("N") || x_src_locn_identity.equals("E"))
		{
			daystoreturn = returndays;
			}
		else
		{
			daystoreturn = "";
		 }
				
			if(x_src_mr_locn.equals("N"))
				{
			        daystoreturn="";
			    }	
					
				//Added for this CRF HSA-CRF-0306.1
				if(isSiteSpecific){              				
						pstmt3.setString ( 1, x_dtl_sysdate) ;
						pstmt3.setString ( 2, login_facility_id) ;
						pstmt3.setString ( 3, p_from_locn) ;
						pstmt3.setString ( 4, x_src_locn_identity) ;
						pstmt3.setString ( 5, p_src_user_id) ;
						pstmt3.setString ( 6, p_to_narration) ;
						//pstmt3.setString( 7, daystoreturn) ;				
						//pstmt3.setString ( 8, x_dtl_prev_facility) ;
				//		pstmt3.setString ( 9, x_dtl_prev_locn) ;
						pstmt3.setString ( 7, addedById ) ;
						pstmt3.setString ( 8, addedAtWorkstation) ;
						pstmt3.setString ( 9, login_facility_id) ;
						pstmt3.setString ( 10, p_iss_remarks) ;
						pstmt3.setString ( 11, p_trans_to) ;
					//	pstmt3.setString ( 14, x_curr_locn_id) ;
						pstmt3.setString ( 12, x_x_facility_id) ;
						pstmt3.setString ( 13, p_file_no) ;
						pstmt3.setString ( 14, p_volume_no) ;
						
				}else{
				        pstmt3.setString ( 1, x_dtl_sysdate) ;
						pstmt3.setString ( 2, login_facility_id) ;
						pstmt3.setString ( 3, p_from_locn) ;
						pstmt3.setString ( 4, x_src_locn_identity) ;
						pstmt3.setString ( 5, p_src_user_id) ;
						pstmt3.setString ( 6, p_to_narration) ;
						pstmt3.setString( 7, daystoreturn) ;				
						//pstmt3.setString ( 8, x_dtl_prev_facility) ;
				//		pstmt3.setString ( 9, x_dtl_prev_locn) ;
						pstmt3.setString ( 8, addedById ) ;
						pstmt3.setString ( 9, addedAtWorkstation) ;
						pstmt3.setString ( 10, login_facility_id) ;
						pstmt3.setString ( 11, p_iss_remarks) ;
						pstmt3.setString ( 12, p_trans_to) ;
					//	pstmt3.setString ( 14, x_curr_locn_id) ;
						pstmt3.setString ( 13, x_x_facility_id) ;
						pstmt3.setString ( 14, p_file_no) ;
						pstmt3.setString ( 15, p_volume_no) ;
				
				
				
                 }		
						
						upd_curr_locn = pstmt3.executeUpdate() ;   System.err.println("FMTransferFileManager.javaupd_curr_locn pstmt3====>"+upd_curr_locn);
						 //Incident NO-29472   start by srinivas Y
						 
                        //Incident NO-29472	ends  by srinivas Y					
		//////////////////////////////////////////////////////////////////////////////					
						
						pstmt5.setString	( 1, x_x_facility_id) ;
						pstmt5.setString	( 2, p_file_no) ;
						pstmt5.setString	( 3, p_file_type) ;
						pstmt5.setString	( 4, p_volume_no) ;
						pstmt5.setString	( 5, x_patient_id) ;
						pstmt5.setString	( 6, login_facility_id) ;
						pstmt5.setString	( 7, p_from_locn) ;
						pstmt5.setString	( 8, x_src_locn_identity) ;
						pstmt5.setString	( 9, login_facility_id) ;
						pstmt5.setString	( 10, p_to_locn) ;
						pstmt5.setString	( 11, x_dest_locn_identity) ;
						pstmt5.setString	( 12, addedById ) ;
						pstmt5.setString	( 13, addedAtWorkstation ) ;
						pstmt5.setString	( 14, login_facility_id ) ;
						pstmt5.setString	( 15, p_iss_remarks ) ;
						pstmt5.setString	( 16, p_doc_folder ) ;
						pstmt5.setString	( 17, p_doc_type ) ;
						
						pstmt5.executeUpdate();
						 //Incident NO-29472  ends by srinivas Y

						 //Incident NO-29472ends  by srinivas Y
		//////////////////////////////////////////////////////////////////////////////
				}
				
				/*Below line added for this CRF HSA-CRF-0306.1*/
					if(isSiteSpecific){ 
                    
					    //pstmt7.setString ( 1, current_date) ;						
						pstmt7.setString ( 1, addedById) ;
						pstmt7.setString ( 2, addedAtWorkstation) ;
						pstmt7.setString ( 3, login_facility_id) ;   		
						pstmt7.setString ( 4, x_x_facility_id) ;
						pstmt7.setString ( 5, p_file_no);
						pstmt7.setString ( 6, p_volume_no);					
       				    int fs_curr_locn_update=pstmt7.executeUpdate();
					    con.commit();
                                  					
					
					  
				    cstmt = con.prepareCall("{call sm_day_return_date_proc(?,?,?,?,?,?,?,?)}");				
				    cstmt.setString(1, p_to_locn);
                    cstmt.setString(2, x_x_facility_id);
                    cstmt.setString(3, "TRANSFER_FILE");
                    cstmt.setString(4, "");
                    cstmt.setString(5, patient_id);
                    cstmt.setString(6, p_trans_to); 
                    cstmt.setString(7, ""); 					
				    cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				    cstmt.execute();					
				    String errmsg=cstmt.getString(8);
				   
				
				}				
				//End HSA-CRF-0306.1

				

            if(cstmt != null)cstmt.close(); //Added for checkstyle

			} // end of while (token)
			if ( ins_move_dtl != 0  && upd_curr_locn != 0 )
			{
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED, "SM" ) ;
				sb.append( (String) message.get("message") ) ;
				con.commit();
				message.clear();
			}
			if((sql != null) && (sql.length() >0))
			{
				sql.delete(0,sql.length());
			}
			if (rset!=null)    rset.close();
			if (pstmt!=null)   pstmt.close();
			if (pstmt1!=null)  pstmt1.close();
			if (pstmt2!=null)  pstmt2.close();
			if (pstmt3!=null)  pstmt3.close();
			if(pstmt4!=null)   pstmt4.close();
			if (pstmt5!=null)  pstmt5.close();
			if (pstmt7!=null)  pstmt7.close();//Added for checkstyle
		}catch(Exception e)
		{
			sb.append("Exception in main try block :"+e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			try
			{
				con.rollback();
			}catch(Exception ce)
			{
				sb.append("Exception while rollbacking connection :"+e.getMessage() + "<br>" ) ;
			}
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
