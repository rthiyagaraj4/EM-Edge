package eFM.FMIssueFiles;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;

import java.sql.*;
import java.rmi.RemoteException;
import java.util.*;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import com.ehis.util.*;


/**
*
* @ejb.bean
*	name="FMIssueFiles"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMIssueFiles"
*	local-jndi-name="FMIssueFiles"
*	impl-class-name="eFM.FMIssueFiles.FMIssueFilesManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMIssueFiles.FMIssueFilesLocal"
*	remote-class="eFM.FMIssueFiles.FMIssueFilesRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMIssueFiles.FMIssueFilesLocalHome"
*	remote-class="eFM.FMIssueFiles.FMIssueFilesHome"
*	generate= "local,remote"
*
*
*/

public class FMIssueFilesManager implements SessionBean 
{
	Connection connection				=	null;
//	PreparedStatement preStatement		=	null;
	PreparedStatement preStatement1		=	null;
	PreparedStatement preStatement2		=	null;
	PreparedStatement preStatement3		=	null;
	PreparedStatement preStatement4		=	null;
	PreparedStatement preStatement5		=	null;
	PreparedStatement preStatement6		=	null;
	PreparedStatement preStatement7		=	null;
	PreparedStatement preStatement8		=	null;
	PreparedStatement preStatement9		=	null;
	PreparedStatement preStatement10	=	null;
	PreparedStatement preStatement11	=	null;
	PreparedStatement preStatement12	=	null;	
	ResultSet resultSet					=	null;

	public final String RECORD_INSERTED	=	"RECORD_INSERTED" ;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext ctx ) {}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap createIssueFiles(
							java.util.Properties			p,
							java.util.HashMap				htIssueFiles,
							webbeans.eFM.FMFilesIssueCart	FMIssueFilesBean,
							ArrayList newArrayListTransMode,
							ArrayList newArrayListCarried,
							ArrayList newArrayListRetDate,
							ArrayList newArrayListreturndatehidden,
							ArrayList newArrayListreturncriteria,
							ArrayList newArrayListdischargedatetime
						 ) 
	{
		
	StringBuffer sb = new StringBuffer( "" ) ;
	java.util.HashMap results = new java.util.HashMap() ;

	boolean result = false ;

	int ins_move_dtl		= 0;
	int p_count				= 0;
	int p_count_req				= 0;

	String sql						= "";
	String sql1						= ""; 
	String sql2						= "";
	String sql3						= "";
	String sql4						= "";
	String sql5						= "";
	String sql6						= "";
	String sql7						= "";
	String sql8						= "";
	String sql9						= "";
	String option					= "";
	String cal_return_date			= "";
	String p_curr_facility_id		= "";
	String p_facility_id			= "";
	String p_file_no				= "";
	String p_file_type				= "";
	String p_volume_no				= "";
	String p_third_party_name		= "";
	String p_requesting_from		= "";
	String p_patient_id				= "";
	String p_iss_locn_code			= "";
	String p_iss_locn_iden			= "";
	String p_rec_locn_code			= "";
	String p_rec_locn_iden			= "";
	String p_rec_user_id			= "";
	String p_narration_code			= "";
	String p_move_narration			= "";
	String p_sen_mr_locn_yn			= "";
	String p_rec_mr_locn_yn			= "";
	String p_system_date			= "";	
	String p_dtl_prev_facility		= "";
	String p_dtl_prev_locn			= "";
	String p_curr_file_status		= "";
	String p_remarks				= "";
	String p_req_remarks			= "";
	String p_days_to_return			= "";
	String p_req_no					= "";
	String p_src_user_id			= "";
	String p_src_facility_id		= "";
	String auto_rec_ward_yn			= "";
	String auto_rec_clinic_yn		= ""; 
	String auto_rec_pract_yn		= ""; 
	String auto_rec_dept_yn			= ""; 
	String auto_rec_external_yn		= "";
	String auto_rec_proc_yn="";
	String sys_date					= "";
	String request_from				= "";
	String req_mode					= "";
	String addedAtWorkstation		= "";
	String addedById				= "";
	String carried_by				= "";
	String transmode				= "";
	String retdate					= "";
	String p_iss_no					= "";
	String doc_or_file				= "";
//	String sqlString				= "";
	String sqlString1				= "";
	String sqlString2				= "";			
	String sql_result_query			= "";
	String locale			= "";
	String curr_file_status="";			
    String flagvlaue="false";
	String flagstatus="";
	int p_count1=0;
	int parameter_hours=0;
	
	//Added for this CRF HSA-CRF-0306.1
	String returndatehidden=""; 
	String returndate_manual_yn="N";
	String isCurrentFsLocation="";	
    String current_date="";	
	
	String returncriteria="";
	
	String dischargedatetime="";
	//End HSA-CRF-0306.1

	Statement stmt  = null;
	Statement stmt1 = null;
	ResultSet rs    = null;
	ResultSet rs2   = null;
	
	String file_curr_locn_id  = "";
	String file_prev_locn_id  = "";
	String DOC_TYPE_CODE      = "";
	String DOC_FOLDER_ID      = "";
 /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
	String Borrowing_Reason="";
/* end ML-MMOH-CRF-0393-IN057159  */
	String p_patient_id_old="";
	boolean flag=false;

	try
	{
		connection			= ConnectionManager.getConnection(p);
		p_curr_facility_id	= (String) htIssueFiles.get ( "curr_facility_id" );
		addedAtWorkstation	= (String) htIssueFiles.get ( "addedAtWorkstation" );
		addedById			= (String) htIssueFiles.get ( "login_user_id" );
		p_iss_no			= (String) htIssueFiles.get ( "p_iss_no" );
		locale			= (String) htIssueFiles.get ( "locale" );
		isCurrentFsLocation= (String) htIssueFiles.get("isCurrentFsLocation");
		current_date = (String) htIssueFiles.get("current_date"); //Added for this CRF HSA-CRF-0306.1
				
		htIssueFiles.clear();
		stmt = connection.createStatement();
		sql1 = "Select AUTO_REC_WARD_YN, AUTO_REC_CLINIC_YN, AUTO_REC_PRACT_YN, AUTO_REC_DEPT_YN,AUTO_REC_PROCEDURE_YN,AUTO_REC_EXTERNAL_YN, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE from FM_PARAMETER Where FACILITY_ID = '"+p_curr_facility_id+"' ";
		rs   = stmt.executeQuery(sql1);
    
		if(rs.next())
		{
			 auto_rec_ward_yn	  = rs.getString("AUTO_REC_WARD_YN");
			 auto_rec_clinic_yn	  = rs.getString("AUTO_REC_CLINIC_YN");
			 auto_rec_pract_yn	  = rs.getString("AUTO_REC_PRACT_YN");
			 auto_rec_dept_yn	  = rs.getString("AUTO_REC_DEPT_YN");
			 auto_rec_proc_yn	  = rs.getString("AUTO_REC_PROCEDURE_YN");
			 auto_rec_external_yn = rs.getString("AUTO_REC_EXTERNAL_YN");
			 sys_date			  = rs.getString("SYDATE");
		}
		 
		ArrayList ArrFileCart =(ArrayList) FMIssueFilesBean.getPresCart();
				
	//	sqlString  = "SELECT requesting_from FROM fm_req_hdr  where req_no = ? ";
	//	preStatement = connection.prepareStatement(sqlString);

		sqlString1 = "SELECT curr_locn_id, DOC_TYPE_CODE, DOC_FOLDER_ID,curr_file_status  FROM  fm_curr_locn  WHERE facility_id = ? and file_no = ? and volume_no = ? ";
		preStatement1 = connection.prepareStatement(sqlString1);

		sql = " INSERT INTO FM_MOVEMENT_LOG (FACILITY_ID, FILE_NO, PATIENT_ID, SENT_DATE_TIME, SRC_FACILITY_ID, SRC_FS_LOCN_CODE, SRC_LOCN_IDENTITY, SRC_USER_ID, REC_DATE_TIME, DEST_FACILITY_ID, DEST_FS_LOCN_CODE, DEST_LOCN_IDENTITY, DEST_USER_ID, NARRATION_CODE, MOVEMENT_TYPE, SRC_MR_LOCN_YN, DEST_MR_LOCN_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,REQ_REMARKS,ISS_REMARKS,REQ_MODE, TRANSPORT_MODE, CARRIED_BY_NAME, FILE_TYPE_CODE, VOLUME_NO, SRC_LOCN_ID, DEST_LOCN_ID, THIRD_PARTY_NAME_DTL, DOC_TYPE_CODE, DOC_FOLDER_ID) VALUES(?,?,?,SYSDATE,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,'I',?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?, ?, ?, ?, ?, ?, ?, ?)" ;
		preStatement2 = connection.prepareStatement(sql);		
		
		//Below query modified for this CRF HSA-CRF-0306.1

		/*Below line(s) borrowing_reason column added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */		
		sqlString2 = "Update FM_CURR_LOCN SET ISS_DATE_TIME = SYSDATE, CURR_FACILITY_ID = ?, CURR_FILE_STATUS = ?, CURR_FS_LOCN_CODE = ?, CURR_FS_LOCN_IDENTITY = ?, CURR_HOLDER_USER_ID = ?, NARRATION_CODE = ?, REMARKS = ?, LAST_MOVEMENT_DATE_TIME = SYSDATE, RETURN_DATE_TIME = to_date(?, 'dd/mm/rrrr hh24:mi'), PREV_FACILITY_ID = ?, PREV_FS_LOCN_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, REQ_REMARKS = ?, CURR_LOCN_ID = ?, PREV_LOCN_ID = ?, ISS_NO = ?, return_date_manual_yn=? , rec_return_date_time =to_date(?,'dd/mm/yyyy hh24:mi'),borrowing_reason=? Where Facility_id = ? AND File_no = ? and volume_no = ?";	
		preStatement4 = connection.prepareStatement(sqlString2);
		

		sql2 = "Update FM_REQ_DTL SET ISS_YN = 'Y', ISS_USER_ID = ?, ISS_DATE_TIME = SYSDATE, CURR_FILE_STATUS = ?, CURR_FACILITY_ID = ?, CURR_FS_LOCN_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? Where Req_no = ? and File_no = ? and ISS_YN = 'N' ";
		preStatement5 = connection.prepareStatement(sql2);

		sql5 = "Update FM_REQ_DTL SET CURR_FACILITY_ID = ?, CURR_FS_LOCN_CODE = ?, CURR_FILE_STATUS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? Where FILE_NO = ? AND CURR_FACILITY_ID = ? AND ISS_YN = 'N'";
		preStatement6 = connection.prepareStatement( sql5 );

		sql3 = "Select COUNT(*) From FM_REQ_DTL Where ISS_YN = 'N' AND Req_no = ?";
		preStatement7 = connection.prepareStatement( sql3 );

		sql9 = "Select COUNT(*) From FM_REQ_DTL Where ISS_YN = 'N' AND file_no = ? AND volume_no = ?";
		preStatement3 = connection.prepareStatement( sql9 );

		sql4 = "Update FM_REQ_HDR SET ISS_COMPLETED_YN = 'Y', MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? Where Req_no = ?";
		preStatement8 = connection.prepareStatement( sql4 );

		//Below query modified for this CRF HSA-CRF-0306.1
			/*Below line(s) borrowing_reason column added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */	
		sql6 = "Update FM_CURR_LOCN SET ISS_DATE_TIME = SYSDATE, CURR_FACILITY_ID = ?, CURR_FILE_STATUS = ?, CURR_FS_LOCN_CODE = ?, CURR_FS_LOCN_IDENTITY = ?, CURR_HOLDER_USER_ID = ?, NARRATION_CODE = ?, REMARKS = ?, LAST_MOVEMENT_DATE_TIME = SYSDATE, RETURN_DATE_TIME = to_date(?, 'dd/mm/rrrr hh24:mi'), PREV_FACILITY_ID = ?, PREV_FS_LOCN_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,REQ_REMARKS = ?, CURR_LOCN_ID = ?, PREV_LOCN_ID = ?, ISS_NO = ?, return_date_manual_yn=?, rec_return_date_time =to_date(?,'dd/mm/yyyy hh24:mi'),borrowing_reason=? Where Facility_id = ? AND File_no = ? AND volume_no = ? ";
		preStatement9 = connection.prepareStatement( sql6 );

		sql7 = " INSERT INTO FM_TRANSIT_FILE (FACILITY_ID, FILE_NO, PATIENT_ID, SENT_DATE_TIME, SRC_FACILITY_ID, SRC_FS_LOCN_CODE, SRC_LOCN_IDENTITY,  DEST_FACILITY_ID, DEST_FS_LOCN_CODE, DEST_LOCN_IDENTITY, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,REQ_REMARKS,ISS_REMARKS, FILE_TYPE_CODE, VOLUME_NO, DOC_TYPE_CODE, DOC_FOLDER_ID) VALUES(?,?,?,SYSDATE,?,?,?,?,?,?,?,SYSDATE,?,?,?,?, ?, ?, ?, ?)" ;
		preStatement10 = connection.prepareStatement( sql7 );

		sql8 = "Update FM_REQ_DTL SET ISS_YN = 'Y', ISS_USER_ID = ?, ISS_DATE_TIME = SYSDATE, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? Where Req_no = ? and File_no = ?";
		preStatement11 = connection.prepareStatement( sql8 );	
				
		webbeans.eFM.FMFilesIssueDetail fissuebean = new webbeans.eFM.FMFilesIssueDetail();
		

		for(int ind = 0;ind < ArrFileCart.size();ind++)
		{
			//webbeans.eFM.FMFilesIssueDetail fissuebean = new webbeans.eFM.FMFilesIssueDetail();
			fissuebean = FMIssueFilesBean.getIssuesfromCart(ind);
			
			p_facility_id			= (java.lang.String) fissuebean.getReq_Facility_Id(); 
			p_file_no				= (java.lang.String) fissuebean.getFile_No();
			p_file_type				= (java.lang.String) fissuebean.getFile_Type();
			p_volume_no				= (java.lang.String) fissuebean.getVolume_No();
			p_third_party_name		= (java.lang.String) fissuebean.getThird_Party_Name();
			p_requesting_from		= (java.lang.String) fissuebean.getRequesting_From();
			p_patient_id			= (java.lang.String) fissuebean.getPatient_Id(); 
			 /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
			Borrowing_Reason		= (java.lang.String) fissuebean.getBorrowing_Reason(); 
			 /* end ML-MMOH-CRF-0393-IN057159  */
			// Below code added for the icn:19419 Date:Thursday, February 18, 2010

			if(!p_patient_id_old.equals(p_patient_id) && !p_patient_id_old.equals(""))
			{
			flag=true;
			}
			p_patient_id_old=p_patient_id;

			p_rec_locn_code	= (java.lang.String) fissuebean.getRec_Locn_Code();
			p_rec_locn_iden	= (java.lang.String) fissuebean.getRec_Locn_Identity();
			p_rec_mr_locn_yn	= (java.lang.String) fissuebean.getRec_MR_Location();
			p_rec_user_id		= (java.lang.String) fissuebean.getRec_Name();
			p_iss_locn_code	= (java.lang.String) fissuebean.getIss_Locn_Code();
			p_iss_locn_iden		= (java.lang.String) fissuebean.getIss_Locn_Identity();
			p_sen_mr_locn_yn	= (java.lang.String) fissuebean.getIss_MR_Location();
			p_narration_code	= (java.lang.String) fissuebean.getNarration_Code();
			p_move_narration	= (java.lang.String) fissuebean.getMovement_Narration();
			p_remarks			= (java.lang.String) fissuebean.getRemarks();
			p_req_remarks		= (java.lang.String) fissuebean.getReq_Remarks();
			p_days_to_return	= (java.lang.String) fissuebean.getRet_Date_Time();
			p_req_no				= (java.lang.String) fissuebean.getReq_No();
			p_src_user_id		= (java.lang.String) fissuebean.getSrc_User_Id();
			p_src_facility_id		= (java.lang.String) fissuebean.getSrc_Facility_Id();
			request_from		= (java.lang.String) fissuebean.getRequest_From();
			req_mode			= (java.lang.String) fissuebean.getREQ_MODE_1();
			transmode			= (java.lang.String) newArrayListTransMode.get(ind);
			carried_by			= (java.lang.String) newArrayListCarried.get(ind);
			retdate				= (java.lang.String) newArrayListRetDate.get(ind);
			
			/*Added for this CRF HSA-CRF-0306.1*/
			returndatehidden= (java.lang.String) newArrayListreturndatehidden.get(ind); 
			
			returncriteria= (java.lang.String) newArrayListreturncriteria.get(ind);
            System.err.println("FMIssueFilesManager.java returncriteria===>"+returncriteria);			
			if(returncriteria == null)	returncriteria = "I";
			
			dischargedatetime =(java.lang.String) newArrayListdischargedatetime.get(ind);			
			System.err.println("dischargedatetime 312===>"+dischargedatetime);
			if(dischargedatetime == null) dischargedatetime = "";
			System.err.println("dischargedatetime 314===>"+dischargedatetime);
			
			if(returndatehidden != null )
			{
				returndatehidden=DateUtils.convertDate(returndatehidden,"DMYHM",locale,"en");
			}else{
				returndatehidden = "";
			}
			
			//End HSA-CRF-0306.1
			
			if(p_narration_code == null)	p_narration_code = "";
			if(p_move_narration == null)	p_move_narration = "";
			if(p_remarks == null)			p_remarks = "";
			if(p_req_remarks == null)		p_req_remarks = "";
			if(p_days_to_return == null)	p_days_to_return = "";
			if(p_req_no == null)			p_req_no = "";
			if(req_mode == null)			req_mode = "";
			if(p_third_party_name == null)	p_third_party_name = "";
			if(p_requesting_from == null)	p_requesting_from = "";
			if(retdate != null )
			{
				retdate=DateUtils.convertDate(retdate,"DMYHM",locale,"en");
			}
			else
				retdate = "";
				
			//Added for this CRF HSA-CRF-0306.1
					
             if(isCurrentFsLocation.equals("true")&&!returndatehidden.equals(retdate)){
			      returndate_manual_yn="Y";
			  }else{
			      returndate_manual_yn="N";
			  }
			    
            //End  HSA-CRF-0306.1		
				

				if(p_facility_id.equals(p_curr_facility_id)) {
				if(p_rec_locn_iden.equals("D") && auto_rec_dept_yn.equals("Y"))	{  
					p_system_date = sys_date; 		option = "1";		
				} else if(p_rec_locn_iden.equals("C") && auto_rec_clinic_yn.equals("Y")) {
					p_system_date = sys_date;		option = "1";		
				} else if(p_rec_locn_iden.equals("N") && auto_rec_ward_yn.equals("Y")) {
					p_system_date = sys_date;		option = "1";		
				} else if(p_rec_locn_iden.equals("T") && auto_rec_pract_yn.equals("Y")) {
					p_system_date = sys_date;		option = "1";		
				} else if(p_rec_locn_iden.equals("E") && auto_rec_proc_yn.equals("Y")) {
					p_system_date = sys_date;		option = "1";		
				} else {
					option = "2";
				}
			} else if(!(p_facility_id.equals(p_curr_facility_id))) {
				if(auto_rec_external_yn.equals("Y")) {
					p_system_date = sys_date;		option = "1";		
				} else {	
					option = "2";
				}
			}   	

			/*
    		if(p_rec_locn_iden.equals("D") && auto_rec_dept_yn.equals("Y"))
			{  p_system_date = sys_date; 		option = "1";		}
			else if(p_rec_locn_iden.equals("C") && auto_rec_clinic_yn.equals("Y"))
			{   p_system_date = sys_date;		option = "1";		}
			else if(p_rec_locn_iden.equals("N") && auto_rec_ward_yn.equals("Y"))
			{   p_system_date = sys_date;		option = "1";		}
			else if(p_rec_locn_iden.equals("T") && auto_rec_pract_yn.equals("Y"))
			{   p_system_date = sys_date;		option = "1";		}
			else if(p_rec_locn_iden.equals("E") && auto_rec_proc_yn.equals("Y"))
			{   p_system_date = sys_date;		option = "1";		}
			else if(auto_rec_external_yn.equals("Y") && !(p_facility_id.equals(p_curr_facility_id)))
			{   p_system_date = sys_date;		option = "1";		}
			else	
			option = "2";
			*/


				if(p_sen_mr_locn_yn.equals("Y"))
				{				
					p_dtl_prev_facility = p_src_facility_id;
					p_dtl_prev_locn = p_iss_locn_code;
				}			
				file_curr_locn_id = "";
				file_prev_locn_id = "";
				file_curr_locn_id = p_requesting_from;
				//////////////////////////////////////////////////////////////				
		/*		preStatement.setString(1, p_req_no);
				resultSet = preStatement.executeQuery();

				if((resultSet != null) && (resultSet.next()))
				{
					file_curr_locn_id = resultSet.getString("requesting_from");
				} if(resultSet != null) resultSet.close();
		*/
		//		if((file_curr_locn_id==null) || (file_curr_locn_id.equals("null")))  
		//			file_curr_locn_id = "";

		//		if(file_curr_locn_id.equals("")) 
		//		{					
					
		//		}
		/////////////////////////////////////////////////////////////////
		if(doc_or_file.equals("D"))
			{	
				preStatement1.setString(1, p_curr_facility_id);
				preStatement1.setString(2, p_file_no);
				preStatement1.setString(3, p_volume_no);
				resultSet = preStatement1.executeQuery();

				if((resultSet != null) && (resultSet.next()))
				{
					file_prev_locn_id	= resultSet.getString("curr_locn_id");
					DOC_TYPE_CODE		= resultSet.getString("DOC_TYPE_CODE");
					DOC_FOLDER_ID		= resultSet.getString("DOC_FOLDER_ID");
				    curr_file_status	= resultSet.getString("curr_file_status");
				} if(resultSet != null) resultSet.close();
				
		////////////////////////////////////////////////////////////////////////
			
				if((file_prev_locn_id==null) || (file_prev_locn_id.equals("null")))  
					file_prev_locn_id = "";
				if ((DOC_TYPE_CODE==null) || (DOC_TYPE_CODE.equals("null")))  
					DOC_TYPE_CODE = "";
				if ((DOC_FOLDER_ID==null) || (DOC_FOLDER_ID.equals("null")))  
					DOC_FOLDER_ID = "";
			  if ((curr_file_status==null) || (curr_file_status.equals("null")))  
					curr_file_status = "";
			} else {
                preStatement1.setString(1, p_curr_facility_id);
				preStatement1.setString(2, p_file_no);
				preStatement1.setString(3, p_volume_no);
				resultSet = preStatement1.executeQuery();

				if((resultSet != null) && (resultSet.next()))
				{
					curr_file_status	= resultSet.getString("curr_file_status");
					} if(resultSet != null) resultSet.close();
				if((curr_file_status==null) || (curr_file_status.equals("null")))  
				curr_file_status = "";
			}
				
		//////////////////////////////////////////////////////////////////////
	
			sql_result_query = "select to_char(sysdate  + "+parameter_hours+"/24,'dd/mm/rrrr hh24:mi') return_date from dual";
			stmt1 = connection.createStatement();		
			rs2   = stmt1.executeQuery(sql_result_query);
			if((rs2 != null) && (rs2.next()))					
				cal_return_date = rs2.getString("return_date");
			if(cal_return_date == null ) cal_return_date ="";
			if(rs2!=null)		  rs2.close();
			if(stmt1!=null)		  stmt1.close();
			
			if(option.equals("1"))
			{
				//if(!(p_facility_id.equals(p_curr_facility_id)))
					p_curr_file_status = "O";
				//else if(p_rec_locn_iden.equals("D"))
			//		p_curr_file_status = "I";
			//	else
			//		p_curr_file_status = "O";
			////////////////////////////////////////////////////////////////////
			
			System.err.println("FMIssueFilesManager.java returncriteria===>"+returncriteria);
			
		/* if(returncriteria.equals("I")){
			   sqlString2 = "Update FM_CURR_LOCN SET ISS_DATE_TIME = SYSDATE, CURR_FACILITY_ID = ?, CURR_FILE_STATUS = ?, CURR_FS_LOCN_CODE = ?, CURR_FS_LOCN_IDENTITY = ?, CURR_HOLDER_USER_ID = ?, NARRATION_CODE = ?, REMARKS = ?, LAST_MOVEMENT_DATE_TIME = SYSDATE, RETURN_DATE_TIME = to_date(?, 'dd/mm/rrrr hh24:mi'), PREV_FACILITY_ID = ?, PREV_FS_LOCN_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, REQ_REMARKS = ?, CURR_LOCN_ID = ?, PREV_LOCN_ID = ?, ISS_NO = ?, return_date_manual_yn=? , rec_return_date_time =to_date(?,'dd/mm/yyyy hh24:mi') Where Facility_id = ? AND File_no = ? and volume_no = ?";
          }else{		   
		      sqlString2 = "Update FM_CURR_LOCN SET ISS_DATE_TIME = SYSDATE, CURR_FACILITY_ID = ?, CURR_FILE_STATUS = ?, CURR_FS_LOCN_CODE = ?, CURR_FS_LOCN_IDENTITY = ?, CURR_HOLDER_USER_ID = ?, NARRATION_CODE = ?, REMARKS = ?, LAST_MOVEMENT_DATE_TIME = SYSDATE, RETURN_DATE_TIME = to_date(?, 'dd/mm/rrrr hh24:mi'), PREV_FACILITY_ID = ?, PREV_FS_LOCN_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, REQ_REMARKS = ?, CURR_LOCN_ID = ?, PREV_LOCN_ID = ?, ISS_NO = ?, return_date_manual_yn=? Where Facility_id = ? AND File_no = ? and volume_no = ?";		   
		   }	
              System.err.println("FMIssueFilesManager.java476 sqlString2 ===>"+sqlString2);		   
		
		            preStatement4 = connection.prepareStatement(sqlString2); */  				
					
					preStatement4.setString ( 1, p_facility_id) ;
					preStatement4.setString ( 2, p_curr_file_status) ;
					preStatement4.setString ( 3, p_rec_locn_code) ;
					preStatement4.setString ( 4, p_rec_locn_iden) ;
					preStatement4.setString ( 5, p_rec_user_id) ;
					preStatement4.setString ( 6, p_narration_code) ;
					preStatement4.setString ( 7, p_remarks) ;
					preStatement4.setString ( 8, retdate) ;				
					preStatement4.setString ( 9, p_dtl_prev_facility) ;
					preStatement4.setString ( 10, p_dtl_prev_locn) ;
					preStatement4.setString ( 11, addedById ) ;
					preStatement4.setString ( 12, addedAtWorkstation) ;
					preStatement4.setString ( 13, p_curr_facility_id) ;
					preStatement4.setString ( 14, p_req_remarks) ;
					preStatement4.setString ( 15, file_curr_locn_id) ;
					preStatement4.setString ( 16, file_prev_locn_id) ;
					preStatement4.setString ( 17, p_iss_no) ;
					//Added for this CRF HSA-CRF-0306.1					
					preStatement4.setString ( 18, returndate_manual_yn) ;
                    if(returncriteria.equals("I")){			
						preStatement4.setString ( 19, current_date) ;						
					}else{                        
                        preStatement4.setString ( 19, dischargedatetime) ;	 								
					}
					
					 /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
				    	preStatement4.setString ( 20, Borrowing_Reason) ;
						 /* end ML-MMOH-CRF-0393-IN057159  */
					    preStatement4.setString ( 21, p_curr_facility_id) ;
						preStatement4.setString ( 22, p_file_no) ;
						preStatement4.setString ( 23, p_volume_no) ;
					
					preStatement4.executeUpdate() ;
					
				   //if(preStatement4!=null)  preStatement4.close();  //this line commented for this incident [59792]
		///////////////////////////////////////////////////////////////
				
			//	if(!(p_facility_id.equals(p_curr_facility_id)))
					p_curr_file_status = "O";
			//	else if(p_rec_locn_iden.equals("D"))
				//	p_curr_file_status = "I";
				//else if(p_rec_locn_iden.equals("C") || p_rec_locn_iden.equals("N") || p_rec_locn_iden.equals("T"))
				//	p_curr_file_status = "O";
		////////////////////////////////////////////////////////////////		
		
			//	preStatement5 = connection.prepareStatement( sql2 );
				preStatement5.setString	( 1, p_src_user_id  ) ;
				preStatement5.setString	( 2, p_curr_file_status ) ;
				preStatement5.setString	( 3, p_facility_id ) ;
				preStatement5.setString	( 4, p_rec_locn_code ) ;
				preStatement5.setString	( 5, addedById ) ;
				preStatement5.setString	( 6, addedAtWorkstation) ;
				preStatement5.setString	( 7, p_curr_facility_id) ;
				preStatement5.setString	( 8, p_req_no ) ;
				preStatement5.setString	( 9, p_file_no ) ;

				preStatement5.executeUpdate() ;
		//////////////////////////////////////////////////////////////////////////
				preStatement3.setString	( 1, p_file_no) ;
				preStatement3.setString	( 2, p_volume_no) ;
					rs = preStatement3.executeQuery();

					if( rs.next())
					{
						p_count_req = rs.getInt(1);
					} if( rs != null) rs.close();
		//////////////////////////////////////////////////////////////////////
				if(p_count_req > 0)
				{
				preStatement6.setString ( 1, p_facility_id) ;
				preStatement6.setString ( 2, p_rec_locn_code) ;
				preStatement6.setString ( 3, p_curr_file_status) ;
				preStatement6.setString ( 4, addedById ) ;
				preStatement6.setString ( 5, addedAtWorkstation) ;
				preStatement6.setString ( 6, p_curr_facility_id) ;
				preStatement6.setString ( 7, p_file_no) ;
				preStatement6.setString ( 8, p_curr_facility_id) ;

				preStatement6.executeUpdate() ;
				
				
				}
		/////////////////////////////////////////////////////////////////////////
			
				if(request_from.equals("S") || request_from.equals("D"))
				{					
					preStatement7.setString	( 1, p_req_no) ;
					rs = preStatement7.executeQuery();

					if( rs.next())
					{
						p_count = rs.getInt(1);
					} if( rs != null) rs.close();
		//////////////////////////////////////////////////////////////////////
					
					if(p_count == 0)
					{						
		////////////////////////////////////////////////////////////////////////

						preStatement8.setString	( 1, addedById ) ;
						preStatement8.setString	( 2, addedAtWorkstation) ;
						preStatement8.setString	( 3, p_curr_facility_id) ;
						preStatement8.setString	( 4, p_req_no) ;
						preStatement8.executeUpdate() ;
		//////////////////////////////////////////////////////////////////////

					}
				}
			}
			else if(option.equals("2"))
			{
			    	if(!(p_facility_id.equals(p_curr_facility_id)))
					p_curr_file_status = "E";
					else
					p_curr_file_status = "T";
		/////////////////////////////////////////////////////////////////////////
		 System.err.println("FMIssueFilesManager.java returncriteria===>"+returncriteria);
		
		   /*  if(returncriteria.equals("I")){
		        sql6 = "Update FM_CURR_LOCN SET ISS_DATE_TIME = SYSDATE, CURR_FACILITY_ID = ?, CURR_FILE_STATUS = ?, CURR_FS_LOCN_CODE = ?, CURR_FS_LOCN_IDENTITY = ?, CURR_HOLDER_USER_ID = ?, NARRATION_CODE = ?, REMARKS = ?, LAST_MOVEMENT_DATE_TIME = SYSDATE, RETURN_DATE_TIME = to_date(?, 'dd/mm/rrrr hh24:mi'), PREV_FACILITY_ID = ?, PREV_FS_LOCN_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,REQ_REMARKS = ?, CURR_LOCN_ID = ?, PREV_LOCN_ID = ?, ISS_NO = ?, return_date_manual_yn=?, rec_return_date_time =to_date(?,'dd/mm/yyyy hh24:mi') Where Facility_id = ? AND File_no = ? AND volume_no = ? ";
			}else{
				sql6 = "Update FM_CURR_LOCN SET ISS_DATE_TIME = SYSDATE, CURR_FACILITY_ID = ?, CURR_FILE_STATUS = ?, CURR_FS_LOCN_CODE = ?, CURR_FS_LOCN_IDENTITY = ?, CURR_HOLDER_USER_ID = ?, NARRATION_CODE = ?, REMARKS = ?, LAST_MOVEMENT_DATE_TIME = SYSDATE, RETURN_DATE_TIME = to_date(?, 'dd/mm/rrrr hh24:mi'), PREV_FACILITY_ID = ?, PREV_FS_LOCN_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,REQ_REMARKS = ?, CURR_LOCN_ID = ?, PREV_LOCN_ID = ?, ISS_NO = ?, return_date_manual_yn=? Where Facility_id = ? AND File_no = ? AND volume_no = ? ";
			
			}
			System.err.println("FMIssueFilesManager.java602 sql6===>"+sql6);
		
		       preStatement9 = connection.prepareStatement( sql6 );	*/

					
				//	preStatement9.setString ( 1, p_facility_id) ;
					preStatement9.setString ( 1, p_curr_facility_id) ;
					preStatement9.setString ( 2, p_curr_file_status) ;
					/*if (p_curr_file_status.equals("E"))
					{
						preStatement9.setString ( 3, p_rec_locn_code) ;
						preStatement9.setString ( 4, p_rec_locn_iden) ;
					} */
					 if (p_curr_file_status.equals("T") || p_curr_file_status.equals("E"))
					{
						preStatement9.setString ( 3, p_iss_locn_code) ;
						preStatement9.setString ( 4, p_iss_locn_iden) ;
					}
					preStatement9.setString ( 5, addedById) ;
					preStatement9.setString ( 6, p_narration_code) ;
					preStatement9.setString ( 7, p_remarks) ;
					preStatement9.setString ( 8, retdate) ;
					preStatement9.setString ( 9, p_dtl_prev_facility) ;
					preStatement9.setString ( 10, p_dtl_prev_locn) ;
					preStatement9.setString ( 11, addedById ) ;
					preStatement9.setString ( 12, addedAtWorkstation) ;
					preStatement9.setString ( 13, p_curr_facility_id) ;
					preStatement9.setString ( 14, p_req_remarks) ;
					preStatement9.setString ( 15, file_curr_locn_id) ;
					preStatement9.setString ( 16, file_prev_locn_id) ;
					preStatement9.setString ( 17, p_iss_no) ;					
					//Added for this CRF HSA-CRF-0306.1					
					preStatement9.setString ( 18, returndate_manual_yn) ;
                    if(returncriteria.equals("I")){					
						preStatement9.setString ( 19, current_date) ; 									
					}else{
                        preStatement9.setString ( 19, dischargedatetime) ;							
					}
					/*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
					preStatement9.setString ( 20, Borrowing_Reason) ;
					 /* end ML-MMOH-CRF-0393-IN057159  */
					preStatement9.setString ( 21, p_curr_facility_id) ;
					preStatement9.setString ( 22, p_file_no) ;
					preStatement9.setString ( 23, p_volume_no) ;
				
					preStatement9.executeUpdate() ;
										
					//if(preStatement9!=null) preStatement9.close(); //this line commented for this incident [59792]
					
					//Incident NO-29472 starts by srinivas Y
					System.out.println("FMIssueFilesManager---p_curr_file_status-----"+p_curr_file_status);
					System.out.println("p_file_no---"+p_file_no);
					System.out.println("p_volume_no----"+p_volume_no);
					System.out.println("FMIssueFilesManager----sql6----"+sql6);
					//Incident NO-29472  ends  by srinivas Y
		/////////////////////////////////////////////////////////////////////
		
			if(curr_file_status.equals("I"))
			  {
				preStatement2.setString	( 1, p_curr_facility_id) ;
				preStatement2.setString	( 2, p_file_no) ;
				preStatement2.setString	( 3, p_patient_id) ;
				preStatement2.setString	( 4, p_src_facility_id) ;
				preStatement2.setString	( 5, p_iss_locn_code) ;
				preStatement2.setString	( 6, p_iss_locn_iden) ;
				preStatement2.setString	( 7, p_src_user_id) ;
				preStatement2.setString	( 8, p_system_date) ;
				preStatement2.setString	( 9, p_facility_id) ;
				preStatement2.setString	( 10, p_rec_locn_code) ;
				preStatement2.setString	( 11, p_rec_locn_iden) ;
				preStatement2.setString	( 12, p_rec_user_id) ;
				preStatement2.setString	( 13, p_narration_code) ;
				preStatement2.setString	( 14, p_sen_mr_locn_yn) ;
				preStatement2.setString	( 15, p_rec_mr_locn_yn) ;
				preStatement2.setString ( 16, addedById ) ;
				preStatement2.setString	( 17, addedAtWorkstation ) ;
				preStatement2.setString	( 18, p_curr_facility_id ) ;
				preStatement2.setString	( 19, addedById ) ;
				preStatement2.setString	( 20, addedAtWorkstation) ;
				preStatement2.setString	( 21, p_curr_facility_id) ;
				preStatement2.setString	( 22, p_req_remarks) ;
				preStatement2.setString	( 23, p_remarks) ;
				preStatement2.setString	( 24, req_mode) ;
				preStatement2.setString	( 25, transmode) ;
				preStatement2.setString	( 26, carried_by) ;
				preStatement2.setString	( 27, p_file_type) ;
				preStatement2.setString	( 28, p_volume_no) ;
				preStatement2.setString	( 29, file_prev_locn_id) ;
				preStatement2.setString	( 30, file_curr_locn_id) ;
				preStatement2.setString	( 31, p_third_party_name) ;
				preStatement2.setString	( 32, DOC_TYPE_CODE) ;
				preStatement2.setString	( 33, DOC_FOLDER_ID) ;
				ins_move_dtl = preStatement2.executeUpdate() ;	
		
			  }	
				
				/////////////////////////////////////////////////////////////////////
						
					
				if(curr_file_status.equals("I"))
				   {
					preStatement10.setString	( 1, p_curr_facility_id) ;
					preStatement10.setString	( 2, p_file_no) ;
					preStatement10.setString	( 3, p_patient_id) ;
					preStatement10.setString	( 4, p_src_facility_id) ;
					preStatement10.setString	( 5, p_iss_locn_code) ;
					preStatement10.setString	( 6, p_iss_locn_iden) ;
					preStatement10.setString	( 7, p_facility_id) ;
					preStatement10.setString	( 8, p_rec_locn_code) ;
					preStatement10.setString	( 9, p_rec_locn_iden) ;
					preStatement10.setString	( 10, addedById ) ;
					preStatement10.setString	( 11, addedAtWorkstation ) ;
					preStatement10.setString	( 12, p_curr_facility_id ) ;
					preStatement10.setString	( 13, p_req_remarks ) ;
					preStatement10.setString	( 14, p_remarks ) ;
					preStatement10.setString	( 15, p_file_type ) ;
					preStatement10.setString	( 16, p_volume_no ) ;
					preStatement10.setString	( 17, DOC_TYPE_CODE ) ;
					preStatement10.setString	( 18, DOC_FOLDER_ID ) ;
				    preStatement10.executeUpdate() ;
					 flagvlaue="true";
					 //Incident NO-29472  starts by srinivas Y
					 System.out.println("p_file_no----111---"+p_file_no);
					 System.out.println("p_patient_id---111---"+p_patient_id);
					 System.out.println("FMIssueFilesManager-----sql7---"+sql7);
					 //Incident NO-29472  ends  by srinivas Y
					 
				   }
		
		////////////////////////////////////////////////////////////////////
				
				if(request_from.equals("S") || request_from.equals("D"))
				{
		/////////////////////////////////////////////////////////////////////////

					preStatement11.setString	( 1, p_src_user_id  ) ;
					preStatement11.setString	( 2, addedById ) ;
					preStatement11.setString	( 3, addedAtWorkstation) ;
					preStatement11.setString	( 4, p_curr_facility_id) ;					
					preStatement11.setString	( 5, p_req_no ) ;
					preStatement11.setString	( 6, p_file_no ) ;

					preStatement11.executeUpdate() ;
					
		/////////////////////////////////////////////////////////////////////////
					
					preStatement7.setString	( 1, p_req_no) ;
					rs = preStatement7.executeQuery();

					if( rs.next())
					{
						p_count = rs.getInt(1);
					} if( rs != null) rs.close();
		/////////////////////////////////////////////////////////////////

					if(p_count == 0)
					{
						preStatement8.setString	( 1, addedById ) ;
						preStatement8.setString	( 2, addedAtWorkstation) ;
						preStatement8.setString	( 3, p_curr_facility_id) ;
						preStatement8.setString	( 4, p_req_no) ;
						preStatement8.executeUpdate() ;		
		//////////////////////////////////////////////////////////////////
					}
				}
			}// end of option
		
		p_count1++;
		} // end of for
		
		
		if(p_count1==1 && flagvlaue.equals("false") && option.equals("2"))
		{
			    result = true ;
				flagstatus="Record";
				java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_ALREADY_MODI","FM");
				sb.append( (String) message.get("message")) ;
				connection.commit();
				message.clear();
		
		} else {
	
			result = true ;
			flagstatus="";
			java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED, "SM" ) ;
			sb.append( (String) message.get("message") ) ;
			connection.commit();
			message.clear();
		} 
		 newArrayListTransMode.clear();
		 newArrayListCarried.clear();
		 newArrayListRetDate.clear();
		 newArrayListreturndatehidden.clear();
         newArrayListreturncriteria.clear();
         newArrayListdischargedatetime.clear();		 
		 ArrFileCart.clear();
		 fissuebean = null;
		 FMIssueFilesBean = null;
		 if(rs!=null)			  rs.close(); rs = null;		 
		 if(resultSet!=null)	  resultSet.close(); resultSet = null;
		 if(stmt!=null)			  stmt.close();	stmt = null;	
	//	 if(preStatement!=null)   preStatement.close();preStatement = null; 
		 if(preStatement1!=null)  preStatement1.close();preStatement1 = null; 
		 if(preStatement2!=null)  preStatement2.close();preStatement2 = null; 	
		 if(preStatement3!=null)  preStatement3.close();preStatement3 = null; 		
		 if(preStatement4!=null)  preStatement4.close();preStatement4 = null; 
		 if(preStatement5!=null)  preStatement5.close();preStatement5 = null; 
		 if(preStatement6!=null)  preStatement6.close();preStatement6 = null; 
		 if(preStatement7!=null)  preStatement7.close();preStatement7 = null; 
		 if(preStatement8!=null)  preStatement8.close();preStatement8 = null; 
		 if(preStatement9!=null)  preStatement9.close();preStatement9 = null; 
		 if(preStatement10!=null) preStatement10.close();preStatement10 = null; 
		 if(preStatement11!=null) preStatement11.close();preStatement11 = null; 
		 if(preStatement12!=null) preStatement12.close();preStatement12 = null; 		 
	}catch(Exception e)
	{
		sb.append("Main Catch :"+e.toString() + "<br>" ) ;
		e.printStackTrace() ;
		try
		{
			connection.rollback();
		}catch (Exception ce){
		sb.append("While Rollback :"+ce.toString() + "<br>" ) ; 
		}
		}
		finally
		{
			ConnectionManager.returnConnection(connection,p);		
		}	
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
        results.put( "flagstatus", flagstatus) ;
		// Below code added for the icn: Date:Thursday, February 18, 2010

		results.put( "flag",new Boolean(flag)  ) ;
		results.put( "p_patient_id_old", p_patient_id_old ) ;
		return results ;
	}
}
