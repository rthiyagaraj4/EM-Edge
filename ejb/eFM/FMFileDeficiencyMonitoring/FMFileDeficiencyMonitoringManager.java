/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMFileDeficiencyMonitoring;

import javax.ejb.* ;

import java.sql.*;
import java.rmi.*;
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
*	name="FMFileDeficiencyMonitoring"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMFileDeficiencyMonitoring"
*	local-jndi-name="FMFileDeficiencyMonitoring"
*	impl-class-name="eFM.FMFileDeficiencyMonitoring.FMFileDeficiencyMonitoringManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMFileDeficiencyMonitoring.FMFileDeficiencyMonitoringLocal"
*	remote-class="eFM.FMFileDeficiencyMonitoring.FMFileDeficiencyMonitoringRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMFileDeficiencyMonitoring.FMFileDeficiencyMonitoringLocalHome"
*	remote-class="eFM.FMFileDeficiencyMonitoring.FMFileDeficiencyMonitoringHome"
*	generate= "local,remote"
*
*
*/

public class FMFileDeficiencyMonitoringManager implements SessionBean 
{
	Connection con ;
	PreparedStatement pstmt ;
	PreparedStatement pstmt1 ;
	PreparedStatement pstmt2 ;
	PreparedStatement pstmt3	= null;
	PreparedStatement pstmt4	= null;
	PreparedStatement pstmt5	= null;
	ResultSet rset				= null; 

	SessionContext ctx;	
	
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;	

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context) 
	{
		this.ctx=context;
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public java.util.HashMap createDeficiency(
							java.util.Properties					p,
							java.util.HashMap						htDeficiency,
							webbeans.eFM.FileDeficiencyMonitoring	recordSetDeficiency
						 ) 
		{
		StringBuffer sb = new StringBuffer( "" ) ;
		java.util.HashMap results = new java.util.HashMap() ;

		boolean result = false ;	
		int ins_hdr =0;
		int ins_dtl=0;
		int upd_dtl=0;	
		int upd_curr=0;	
		
		int row_count = 0;
		int ins_header = 1;
        int open_cnt= 0;
		int close_cnt= 0;
		int cancel_cnt= 0;
		int close_can_cnt=0;

		int close_cnt1= 0;
		int cancel_cnt1= 0;
        int row_count1 =0;

		String sql				= "";
		String sql1				= "";
		String sql2				= "";
		String sql_2			= "";
        String sql3              ="";
		 String p_facility_id					= "";
		String p_file_no						= "";
		String file_type						= "";
		String volume_no						= "";
		String patient_class					= "";
		String patient_id						= "";
		String p_encounter_id					= "";
		String p_admission_date					= "";
		String p_discharge_date					= "";
		String p_care_locn_code					= "";
		String p_deficiency_completed_status	= "";
		String p_deficiency_code	= "";
		String p_practitioner		= "";
		String p_def_reported_date	= "";
		String p_def_status			= "";
		String p_def_resolved_date	= "";
		String p_def_remarks		= "";
		String p_item_delete_yn		= "";
		String p_header_exist		= "";
		String p_operation_mode		= "";
		String p_curr_facility_id	= "";
		String addedAtWorkstation	= "";		
		String addedById			= "";
		String locale			= "";
		String def_status       = "";
		String def_status_val   = "";
       
		String		curr_fs_locn_code				=	"";
		String		curr_file_status				=	"";
		String		perm_fs_locn_code				=	"";
		String		dflt_incomplete_fs_locn_code	=	"";
		String       deficiency_status				=	"C";
		String       hdr_def_status			= "C";
		 String mntr_fldfcy_inc_fslocn_ntdf_yn="N";
		boolean		Status_flag						= false;

		con = ConnectionManager.getConnection(p);		
		
		HashMap		htRecord	=	null; 

		try
		{
			p_curr_facility_id	= (String) htDeficiency.get( "curr_facility_id" );
			addedAtWorkstation	= (String) htDeficiency.get ( "addedAtWorkstation" );
			addedById			= (String) htDeficiency.get ( "login_user_id" );			
			locale					= (String) htDeficiency.get ( "locale" );			
            htDeficiency.clear();
			row_count	=	recordSetDeficiency.getSize();
			
			sql = " INSERT INTO FM_DEFICIENCY_HDR (FACILITY_ID, ENCOUNTER_ID, FILE_NO, ADMISSION_DATE, DISCHARGE_DATE, ASSIGN_CARE_LOCN_CODE, DEFICIENCY_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, FILE_TYPE, VOLUME_NO, PATIENT_CLASS, PATIENT_ID) VALUES(?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,? )" ;
			pstmt = con.prepareStatement( sql );

			sql1 = " INSERT INTO FM_DEFICIENCY_DTL (FACILITY_ID, ENCOUNTER_ID, DEFICIENCY_CODE, FILE_NO, RESP_PRACTITIONER_ID, REPORTED_DATE, DEFICIENCY_STATUS, RESOLVED_DATE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, FILE_TYPE, VOLUME_NO, PATIENT_ID) VALUES(?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?, ?)" ;
			pstmt1 = con.prepareStatement( sql1 );

			sql2 = "UPDATE FM_DEFICIENCY_DTL SET RESP_PRACTITIONER_ID = ?,  DEFICIENCY_STATUS = ?, RESOLVED_DATE = TO_DATE(?,'DD/MM/YYYY HH24:MI'), REMARKS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, FILE_TYPE = ?, PATIENT_ID = ? Where FACILITY_ID = ? and ENCOUNTER_ID = ? and DEFICIENCY_CODE = ? and FILE_NO = ? AND VOLUME_NO = ?"; 
			pstmt2 = con.prepareStatement( sql2 );
			/*Added Audit column in the query */
			sql3 = "UPDATE FM_DEFICIENCY_HDR SET DEFICIENCY_STATUS = ? ,modified_by_id=?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id=?  Where FACILITY_ID = ? and ENCOUNTER_ID = ? and PATIENT_ID=? and FILE_NO = ? AND VOLUME_NO =?"; 
			
			
			pstmt5 = con.prepareStatement( sql3 );
			
			for(int i=0; i<row_count; i++)
			{
				htRecord	=	(java.util.HashMap)	recordSetDeficiency.getObject(i);

				p_facility_id			=	(String)	htRecord.get("facility_id");
				p_encounter_id			=	(String)	htRecord.get("encounter_id");
				p_file_no				=	(String)	htRecord.get("file_no");
				file_type				=	(String)	htRecord.get("file_type");
				volume_no				=	(String)	htRecord.get("volume_no");
				patient_class			=	(String)	htRecord.get("patient_class");
				patient_id				=	(String)	htRecord.get("PatientId");
				p_deficiency_code		=	(String)	htRecord.get("defi_code");
				p_admission_date		=	(String)	htRecord.get("admission_date");
				
			if(!p_admission_date.equals(""))	p_admission_date = DateUtils.convertDate(p_admission_date,"DMYHM",locale,"en");	

				p_discharge_date		=	(String)	htRecord.get("discharge_date");
				if(!p_discharge_date.equals(""))	p_discharge_date=DateUtils.convertDate(p_discharge_date,"DMYHM",locale,"en");

				p_care_locn_code		=	(String)	htRecord.get("care_locn_code");
				p_deficiency_completed_status=	(String)	htRecord.get("defi_completed_status");
				p_practitioner			=	(String)	htRecord.get("practitioner");
				p_def_reported_date		=	(String)	htRecord.get("defi_reported_date");
				if(!p_def_reported_date.equals(""))	p_def_reported_date=DateUtils.convertDate(p_def_reported_date,"DMYHM",locale,"en");

				p_def_status			=	(String)	htRecord.get("defi_status");
				p_def_resolved_date		=	(String)	htRecord.get("defi_resolved_date");
				p_def_remarks			=	(String)	htRecord.get("defi_remarks");
				p_item_delete_yn		=	(String)	htRecord.get("item_delete_yn");
				p_header_exist			=	(String)	htRecord.get("header_exist");
				p_operation_mode		=	(String)	htRecord.get("operation_mode");

				file_type = (file_type==null) ? "" :file_type;
				volume_no = (volume_no==null) ? "" :volume_no;
				patient_class = (patient_class==null) ? "" :patient_class;
				patient_id = (patient_id==null) ? "" :patient_id;

						
				if (p_def_status.equals("O"))
				{
					deficiency_status ="O";
				   open_cnt=open_cnt+1;
				   		}
				if (p_def_status.equals("C") || p_def_status.equals("X"))
				{
				   close_can_cnt=close_can_cnt+1;
				  		}
				if (p_def_status.equals("X"))
				{
				    cancel_cnt=cancel_cnt+1;
				 		}
				if (p_def_status.equals("C")){
                 close_cnt=close_cnt+1;
						}
			
				if(p_def_resolved_date == null || p_def_resolved_date.equals("null"))
					p_def_resolved_date = "";
				if(!p_def_resolved_date.equals(""))	p_def_resolved_date=DateUtils.convertDate(p_def_resolved_date,"DMYHM",locale,"en");
				if(p_def_remarks == null || p_def_remarks.equals("null"))
					p_def_remarks = "";
				if(p_header_exist == null || p_header_exist.equals("null"))
					p_header_exist = "1";

				if(p_header_exist.equals("0") && p_operation_mode.equals("Add") && ins_header == 1)
				{		
			////////////////////////////////////////////////////////////////////////////////	
		
						pstmt.setString	( 1, p_facility_id) ;
						pstmt.setLong	( 2, Long.parseLong(p_encounter_id)) ;
						pstmt.setString	( 3, p_file_no) ;
						pstmt.setString	( 4, p_admission_date) ;
						pstmt.setString	( 5, p_discharge_date) ;
						pstmt.setString	( 6, p_care_locn_code) ;
						pstmt.setString	( 7, p_deficiency_completed_status) ;
						pstmt.setString ( 8, addedById ) ;
						pstmt.setString	( 9, addedAtWorkstation ) ;
						pstmt.setString	( 10, p_curr_facility_id ) ;
						pstmt.setString	( 11, addedById ) ;
						pstmt.setString	( 12, addedAtWorkstation) ;
						pstmt.setString	( 13, p_curr_facility_id) ;
						pstmt.setString	( 14, file_type) ;
						pstmt.setString	( 15, volume_no) ;
						pstmt.setString	( 16, patient_class) ;
						pstmt.setString	( 17, patient_id) ;

						ins_hdr = pstmt.executeUpdate() ;

			////////////////////////////////////////////////////////////////////////////////
						ins_header = 2;
				}

				if(p_operation_mode.equals("Add") && p_item_delete_yn.equals("N"))
				{                	
			////////////////////////////////////////////////////////////////////////////////
						pstmt1.setString	( 1, p_facility_id) ;
						pstmt1.setLong		( 2, Long.parseLong(p_encounter_id)) ;
						pstmt1.setString	( 3, p_deficiency_code) ;
						pstmt1.setString	( 4, p_file_no) ;
						pstmt1.setString	( 5, p_practitioner) ;
						pstmt1.setString	( 6, p_def_reported_date) ;
						pstmt1.setString	( 7, p_def_status) ;
						pstmt1.setString	( 8, p_def_resolved_date) ;
						pstmt1.setString	( 9, p_def_remarks) ;
						pstmt1.setString	( 10, addedById ) ;
						pstmt1.setString	( 11, addedAtWorkstation ) ;
						pstmt1.setString	( 12, p_curr_facility_id ) ;
						pstmt1.setString	( 13, addedById ) ;
						pstmt1.setString	( 14, addedAtWorkstation) ;
						pstmt1.setString	( 15, p_curr_facility_id) ;
						pstmt1.setString	( 16, file_type) ;
						pstmt1.setString	( 17, volume_no) ;
						pstmt1.setString	( 18, patient_id) ;

						ins_dtl = pstmt1.executeUpdate() ;

			////////////////////////////////////////////////////////////////////////////////
				}
				if(p_operation_mode.equals("Modify") && p_item_delete_yn.equals("N"))
				{         
			////////////////////////////////////////////////////////////////////////////////	
						pstmt2.setString	( 1, p_practitioner) ;
						pstmt2.setString	( 2, p_def_status) ;
						pstmt2.setString	( 3, p_def_resolved_date) ;
						pstmt2.setString	( 4, p_def_remarks) ;
						pstmt2.setString	( 5, addedById ) ;
						pstmt2.setString	( 6, addedAtWorkstation ) ;
						pstmt2.setString	( 7, p_curr_facility_id ) ;
						pstmt2.setString	( 8, file_type ) ;
						pstmt2.setString	( 9, patient_id ) ;
						pstmt2.setString	( 10, p_facility_id) ;
						pstmt2.setLong		( 11, Long.parseLong(p_encounter_id)) ;
						pstmt2.setString	( 12, p_deficiency_code) ;
						pstmt2.setString	( 13, p_file_no) ;
						pstmt2.setString	( 14, volume_no) ;

						upd_dtl = pstmt2.executeUpdate() ;
		////////////////////////////////////////////////////////////////////////////////
				}
			}
					 	 if(open_cnt==row_count)
						 {
								hdr_def_status="O";
						 }else if(close_cnt==row_count || (close_can_cnt==row_count && cancel_cnt!=row_count))
						 {
								hdr_def_status="C";
						 }else if(cancel_cnt==row_count)
					     {
								hdr_def_status="X";
						 }else
						 {
                               hdr_def_status="O";
                         }

		pstmt5.setString	( 1,hdr_def_status) ;
		/*Below line added and modified */
		pstmt5.setString	( 2,addedById) ;
		pstmt5.setString	( 3,addedAtWorkstation) ;
		pstmt5.setString	( 4,p_curr_facility_id) ;		
		pstmt5.setString	( 5, p_facility_id) ;
		pstmt5.setLong	( 6, Long.parseLong(p_encounter_id)) ;
		pstmt5.setString	( 7, patient_id) ;
		pstmt5.setString	( 8, p_file_no) ;
		pstmt5.setString	( 9, volume_no) ;
		ins_dtl = pstmt5.executeUpdate() ;

		String sql_1="SELECT A.CURR_FS_LOCN_CODE,A.CURR_FILE_STATUS,A.PERM_FS_LOCN_CODE,B.DFLT_INCOMPLETE_FS_LOCN_CODE,B.mntr_fldfcy_inc_fslocn_ntdf_yn FROM  FM_CURR_LOCN A,FM_PARAMETER B WHERE A.FACILITY_ID = B.FACILITY_ID AND A.FACILITY_ID = '"+p_facility_id+"' AND   A.FILE_NO = '"+p_file_no+"'  AND A.VOLUME_NO = '"+volume_no+"'";

		String sql_def="SELECT DEFICIENCY_STATUS FROM FM_DEFICIENCY_HDR WHERE FACILITY_ID = ? AND FILE_NO = ? AND VOLUME_NO = ?";

		if(rset!=null)	 rset.close();
		if(pstmt3!=null) pstmt3.close();

		pstmt3 = con.prepareStatement(sql_def);
		pstmt3.setString	( 1,p_facility_id) ;
		pstmt3.setString	( 2,p_file_no) ;
		pstmt3.setString	( 3,volume_no) ;

		rset = pstmt3.executeQuery();

		if(rset != null)
		{
           while(rset.next())
			{
                 row_count1++;
                 def_status =  rset.getString("DEFICIENCY_STATUS");
				 if (def_status.equals("O")){
					def_status_val    ="O";
					close_cnt1=0;
					cancel_cnt1=0;
				    break;
				 }else if (def_status.equals("C") ) {
					close_cnt1=close_cnt1+1;
				 }else if (def_status.equals("X")) {
				    cancel_cnt1=cancel_cnt1+1;
				 }
				 
		  }
		}

	   if(close_cnt1>0){
		   def_status_val="C";
	   }else{
		   if(cancel_cnt1>0){
			   def_status_val="X";
		   }
	   }
 
		if(rset!=null)	 rset.close();
		if(pstmt3!=null) pstmt3.close();

			pstmt3 = con.prepareStatement(sql_1);
			rset = pstmt3.executeQuery();
			if(rset != null)
			{
				while(rset.next())
				{

				curr_fs_locn_code		=	rset.getString("CURR_FS_LOCN_CODE");
				curr_file_status		=	rset.getString("CURR_FILE_STATUS");
				perm_fs_locn_code		=	rset.getString("PERM_FS_LOCN_CODE");
				dflt_incomplete_fs_locn_code	=	rset.getString("DFLT_INCOMPLETE_FS_LOCN_CODE"); 
               mntr_fldfcy_inc_fslocn_ntdf_yn		=	rset.getString("mntr_fldfcy_inc_fslocn_ntdf_yn");
							
				}

			}

			if ((curr_fs_locn_code==null)||(curr_fs_locn_code.equals("null"))) curr_fs_locn_code = "";
			if ((curr_file_status==null)||(curr_file_status.equals("null"))) curr_file_status = "";
			if ((perm_fs_locn_code==null)||(perm_fs_locn_code.equals("null"))) perm_fs_locn_code = "";
			if ((dflt_incomplete_fs_locn_code==null)||(dflt_incomplete_fs_locn_code.equals("null"))) dflt_incomplete_fs_locn_code = "";
           if ((mntr_fldfcy_inc_fslocn_ntdf_yn==null)||(mntr_fldfcy_inc_fslocn_ntdf_yn.equals("null"))) mntr_fldfcy_inc_fslocn_ntdf_yn = "N";
				Status_flag		=	(Boolean)	htRecord.get("Status_flag");


						
				if(curr_fs_locn_code.equals(perm_fs_locn_code) && Status_flag)
				{
					if(mntr_fldfcy_inc_fslocn_ntdf_yn.equals("N"))
					{
						sql_2="UPDATE fm_curr_locn SET CURR_FACILITY_ID=?, curr_file_status='O',deficiency_status =?,curr_fs_locn_code=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? WHERE facility_id=? AND file_no=? AND volume_no = ?";
					}
					if(mntr_fldfcy_inc_fslocn_ntdf_yn.equals("Y"))
					{
						sql_2="UPDATE fm_curr_locn SET CURR_FACILITY_ID=?, deficiency_status =?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? WHERE facility_id=? AND file_no=? AND volume_no = ?";
					}
					
					pstmt4 = con.prepareStatement( sql_2 );
			   
						pstmt4.setString	( 1, p_curr_facility_id) ;
						pstmt4.setString	( 2,def_status_val) ;
						if(mntr_fldfcy_inc_fslocn_ntdf_yn.equals("N"))
					   {
						pstmt4.setString	( 3, dflt_incomplete_fs_locn_code);
					  	pstmt4.setString	( 4, addedById ) ;
						pstmt4.setString	( 5, addedAtWorkstation) ;
						pstmt4.setString	( 6, p_curr_facility_id) ;
						pstmt4.setString	( 7, p_curr_facility_id) ;
						pstmt4.setString	( 8, p_file_no) ;
						pstmt4.setString	( 9, volume_no) ;
					   }
                    if(mntr_fldfcy_inc_fslocn_ntdf_yn.equals("Y"))
					   {
						pstmt4.setString	( 3, addedById ) ;
						pstmt4.setString	(4, addedAtWorkstation) ;
						pstmt4.setString	(5, p_curr_facility_id) ;
						pstmt4.setString	(6, p_curr_facility_id) ;
						pstmt4.setString	( 7, p_file_no) ;
						pstmt4.setString	(8, volume_no) ;
					   }
			  										
						upd_curr = pstmt4.executeUpdate() ;
                       
				
				}
				else if(curr_fs_locn_code.equals(dflt_incomplete_fs_locn_code) && !Status_flag)
				{
					sql_2="UPDATE fm_curr_locn SET CURR_FACILITY_ID=?, curr_file_status='I',deficiency_status =?,curr_fs_locn_code=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=?,return_date_time= ?,iss_date_time=? WHERE facility_id=? AND file_no=? AND volume_no = ?";
					pstmt4 = con.prepareStatement( sql_2 );
						pstmt4.setString	( 1, p_curr_facility_id) ;
						pstmt4.setString	( 2, def_status_val) ;
						pstmt4.setString	( 3, perm_fs_locn_code) ;
						pstmt4.setString	( 4, addedById ) ;
						pstmt4.setString	( 5, addedAtWorkstation) ;
						pstmt4.setString	( 6, p_curr_facility_id) ;
						pstmt4.setString	( 7, "") ;
						pstmt4.setString	( 8, "") ;
						pstmt4.setString	( 9, p_curr_facility_id) ;
						pstmt4.setString	( 10, p_file_no) ;
						pstmt4.setString	( 11, volume_no) ;
						upd_curr = pstmt4.executeUpdate() ;
			       }else 
				   {
						sql_2="UPDATE fm_curr_locn SET deficiency_status =?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? WHERE facility_id=? AND file_no=? AND volume_no = ?";
					    pstmt4 = con.prepareStatement( sql_2 );
						pstmt4.setString	(1, def_status_val) ;
						pstmt4.setString	( 2, addedById ) ;
						pstmt4.setString	( 3, addedAtWorkstation) ;
						pstmt4.setString	( 4, p_curr_facility_id) ;
						pstmt4.setString	( 5, p_curr_facility_id) ;
						pstmt4.setString	( 6, p_file_no) ;
						pstmt4.setString	( 7, volume_no) ;
						upd_curr = pstmt4.executeUpdate() ;
                  						
					}
						

			
			if ( (ins_hdr != 0  && ins_dtl != 0) || (upd_dtl != 0) )
			{
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED ,"SM") ;
				sb.append( (String) message.get("message") ) ;
				con.commit();
				message.clear();
			}	
			htRecord.clear();
			if(rset!=null)	 rset.close();
			if(pstmt!=null) pstmt.close();
			if(pstmt1!=null) pstmt1.close();
			if(pstmt2!=null) pstmt2.close();
		     if(pstmt3!=null) pstmt3.close();
		     if(pstmt4!=null) pstmt4.close();
		    if(pstmt5!=null) pstmt5.close();
				}
		catch(Exception e)
		{			
			e.printStackTrace();
			try
			{
				con.rollback();
			}
			catch (Exception ce) { e.printStackTrace(); }
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
