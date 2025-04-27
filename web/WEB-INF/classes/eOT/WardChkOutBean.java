/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT ;
/*import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.rmi.* ;
import javax.naming.* ;
import eOT.Common.* ;
import eCommon.Common.* ;
import eOT.ExamsCheckList.*;*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.io.Serializable;
import eOT.ExamsCheckList.ExamsCheckListHome;
import eOT.ExamsCheckList.ExamsCheckListRemote;
import eOT.Common.OTRepository;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import eOT.Common.OTAdapter;
import java.util.Properties;
import com.ehis.util.DateUtils;

public class WardChkOutBean extends OTAdapter implements Serializable {

	HashMap all_ward_chk_out_details = null;
	HashMap all_rd_ward_chk_out_details = null;
	Properties	p = this.properties;
	String	locale	= "";
	public WardChkOutBean() {
        try {
			doCommon();
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
		}catch(Exception e) {}
	}

	public void doCommon() throws Exception {
	}

	public void clear(){
		all_ward_chk_out_details = null;
		all_rd_ward_chk_out_details = null;
	}

	public String getSysDateTime(){

		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		String curr_date		= "";
		locale = getProperties().getProperty("LOCALE");
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				curr_date = resultSet.getString("CURRENT_DATE");
				//curr_date=DateUtils.convertDate(resultSet.getString("CURRENT_DATE"),"DMY","en",locale);
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return curr_date;
	}
	public String getSysTime(){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		String curr_time		= "";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				curr_time = resultSet.getString("HOURS_MTS");
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return curr_time;
	}

/*
Below method is modified by bshankar against SCR-3032 on 14th May 2008

	public boolean loadSurgeryBkgWardChkOutDtls(String surgery_date,String nursing_unit,String patient_id,String appt_yn){
		HashMap ward_chk_out_details = null;
			all_ward_chk_out_details = new HashMap();
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		int index	= 0;
		try{
			if(patient_id!=null && patient_id.equals("null"))
				patient_id="";

			connection			= getConnection() ;
			if(appt_yn.equals("")){
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_WARD_CHK_OUT_SELECT3")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,surgery_date);
			pstmt.setString(3,nursing_unit);
			pstmt.setString(4,patient_id);
			}
			else{
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_WARD_CHK_OUT_SELECT1")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,surgery_date);
			pstmt.setString(3,nursing_unit);
			pstmt.setString(4,patient_id);
			pstmt.setString(5,appt_yn);
			}
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				index++;
				ward_chk_out_details = new HashMap();
				ward_chk_out_details.put("patient_id",resultSet.getString("PATIENT_ID"));
				ward_chk_out_details.put("patient_name",resultSet.getString("PATIENT_NAME"));
				ward_chk_out_details.put("primary_oper_code",resultSet.getString("PRIMARY_OPER_CODE"));
				ward_chk_out_details.put("oper_desc",resultSet.getString("OPER_DESC"));
				ward_chk_out_details.put("surgeon_name",resultSet.getString("SURGEON_NAME"));
				ward_chk_out_details.put("appt_from_time",resultSet.getString("APPT_FROM_TIME"));
				ward_chk_out_details.put("appt_to_time",resultSet.getString("APPT_TO_TIME"));
				ward_chk_out_details.put("status_desc",resultSet.getString("STATUS_DESC"));
				ward_chk_out_details.put("oper_status",resultSet.getString("OPER_STATUS"));
				ward_chk_out_details.put("appt_ref_num",resultSet.getString("APPT_REF_NUM"));
				ward_chk_out_details.put("appt_yn",resultSet.getString("APPT_YN"));
				ward_chk_out_details.put("order_id",resultSet.getString("ORDER_ID"));
				ward_chk_out_details.put("speciality_code",resultSet.getString("SPECIALITY_CODE"));
				ward_chk_out_details.put("case_called_time",resultSet.getString("CASE_CALLED_TIME"));
				ward_chk_out_details.put("check_out_from_ward_time",resultSet.getString("CHECK_OUT_FROM_WARD_TIME"));
				
				all_ward_chk_out_details.put(index+"",ward_chk_out_details);
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		if(index==0)
			return false;
		return true;
	}
*/
	public boolean loadSurgeryBkgWardChkOutDtls(String surgery_date,String nursing_unit,String patient_id,String appt_yn, String current_ip_ward_yn){
		HashMap ward_chk_out_details = null;
			all_ward_chk_out_details = new HashMap();
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		int index	= 0;
		try{
			if(patient_id!=null && patient_id.equals("null"))
				patient_id="";

			connection			= getConnection() ;
			if(appt_yn.equals("")){
				if(current_ip_ward_yn.equals("N")){
					pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_WARD_CHK_OUT_SELECT3")) ;
					pstmt.setString(1,locale);
					pstmt.setString(2,login_facility_id);
					pstmt.setString(3,surgery_date);
					pstmt.setString(4,nursing_unit);
					pstmt.setString(5,patient_id);
					pstmt.setString(6,locale);
				}else{
					//Join with IP_OPEN_ENCOUNTER to consider patients current ward 
					String SQL_OT_WARD_CHK_OUT_SELECT3_FOR_IPWARD = "SELECT A.PATIENT_ID, (SELECT DECODE (?, 'en', NVL (patient_name, patient_name_loc_lang), NVL (patient_name_loc_lang, patient_name) )  FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID) PATIENT_NAME, PRIMARY_OPER_CODE, OPER_DESC, SURGEON_NAME, TO_CHAR(APPT_FROM_TIME,'HH24:MI') APPT_FROM_TIME, TO_CHAR(APPT_TO_TIME,'HH24:MI') APPT_TO_TIME, STATUS_DESC, OPER_STATUS, APPT_REF_NUM, APPT_YN, ORDER_ID, SPECIALITY_CODE, TO_CHAR(CASE_CALLED_TIME,'HH24:MI') CASE_CALLED_TIME, TO_CHAR(CHECK_OUT_FROM_WARD_TIME,'HH24:MI') CHECK_OUT_FROM_WARD_TIME FROM OT_CHK_OUT_FROM_WARD_VW A, IP_OPEN_ENCOUNTER B  WHERE A.OPERATING_FACILITY_ID=? AND APPT_DATE=TO_DATE(?,'DD/MM/YYYY') AND B.NURSING_UNIT_CODE=? AND A.PATIENT_ID=NVL(?,A.PATIENT_ID) AND A.OPERATING_FACILITY_ID = B.FACILITY_ID AND A.PATIENT_ID=B.PATIENT_ID AND A.LANGUAGE_ID = ? ORDER BY APPT_DATE, APPT_FROM_TIME";
					pstmt = connection.prepareStatement(SQL_OT_WARD_CHK_OUT_SELECT3_FOR_IPWARD) ;
					pstmt.setString(1,locale);
					pstmt.setString(2,login_facility_id);
					pstmt.setString(3,surgery_date);
					pstmt.setString(4,nursing_unit);
					pstmt.setString(5,patient_id);
					pstmt.setString(6,locale);
				}
			}
			else{
				if(current_ip_ward_yn.equals("N")){
					pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_WARD_CHK_OUT_SELECT1")) ;
					pstmt.setString(1,locale);
					pstmt.setString(2,login_facility_id);
					pstmt.setString(3,surgery_date);
					pstmt.setString(4,nursing_unit);
					pstmt.setString(5,patient_id);
					pstmt.setString(6,appt_yn);
					pstmt.setString(7,locale);
				}else{
					//Join with IP_OPEN_ENCOUNTER to consider patients current ward 
					String SQL_OT_WARD_CHK_OUT_SELECT1_FOR_IPWARD = "SELECT A.PATIENT_ID, (SELECT DECODE (?, 'en', NVL (patient_name, patient_name_loc_lang), NVL (patient_name_loc_lang, patient_name) )  FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID) PATIENT_NAME, PRIMARY_OPER_CODE, OPER_DESC, SURGEON_NAME, TO_CHAR(APPT_FROM_TIME,'HH24:MI') APPT_FROM_TIME, TO_CHAR(APPT_TO_TIME,'HH24:MI') APPT_TO_TIME, STATUS_DESC, OPER_STATUS, APPT_REF_NUM, APPT_YN, ORDER_ID, SPECIALITY_CODE, TO_CHAR(CASE_CALLED_TIME,'HH24:MI') CASE_CALLED_TIME, TO_CHAR(CHECK_OUT_FROM_WARD_TIME,'HH24:MI') CHECK_OUT_FROM_WARD_TIME FROM OT_CHK_OUT_FROM_WARD_VW A, IP_OPEN_ENCOUNTER B WHERE OPERATING_FACILITY_ID=? AND APPT_DATE=TO_DATE(?,'DD/MM/YYYY') AND B.NURSING_UNIT_CODE=? AND A.PATIENT_ID=NVL(?,A.PATIENT_ID) AND NVL(APPT_YN,'X')=NVL(?,'X') AND A.OPERATING_FACILITY_ID = B.FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.LANGUAGE_ID = ? ORDER BY APPT_DATE, APPT_FROM_TIME";

					pstmt = connection.prepareStatement(SQL_OT_WARD_CHK_OUT_SELECT1_FOR_IPWARD) ;
					pstmt.setString(1,locale);
					pstmt.setString(2,login_facility_id);
					pstmt.setString(3,surgery_date);
					pstmt.setString(4,nursing_unit);
					pstmt.setString(5,patient_id);
					pstmt.setString(6,appt_yn);
					pstmt.setString(7,locale);
				}
			}
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				index++;
				ward_chk_out_details = new HashMap();
				ward_chk_out_details.put("patient_id",resultSet.getString("PATIENT_ID"));
				ward_chk_out_details.put("patient_name",resultSet.getString("PATIENT_NAME"));
				ward_chk_out_details.put("primary_oper_code",resultSet.getString("PRIMARY_OPER_CODE"));
				ward_chk_out_details.put("oper_desc",resultSet.getString("OPER_DESC"));
				ward_chk_out_details.put("surgeon_name",resultSet.getString("SURGEON_NAME"));
				ward_chk_out_details.put("appt_from_time",resultSet.getString("APPT_FROM_TIME"));
				ward_chk_out_details.put("appt_to_time",resultSet.getString("APPT_TO_TIME"));
				ward_chk_out_details.put("status_desc",resultSet.getString("STATUS_DESC"));
				ward_chk_out_details.put("oper_status",resultSet.getString("OPER_STATUS"));
				ward_chk_out_details.put("appt_ref_num",resultSet.getString("APPT_REF_NUM"));
				ward_chk_out_details.put("appt_yn",resultSet.getString("APPT_YN"));
				ward_chk_out_details.put("order_id",resultSet.getString("ORDER_ID"));
				ward_chk_out_details.put("speciality_code",resultSet.getString("SPECIALITY_CODE"));
				ward_chk_out_details.put("case_called_time",resultSet.getString("CASE_CALLED_TIME"));
				ward_chk_out_details.put("check_out_from_ward_time",resultSet.getString("CHECK_OUT_FROM_WARD_TIME"));
				
				all_ward_chk_out_details.put(index+"",ward_chk_out_details);
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		if(index==0)
			return false;
		return true;
	}

	public boolean loadRadiologyBkgWardChkOutDtls(String surgery_date,String nursing_unit,String patient_id){
		HashMap ward_chk_out_details = null;
			all_rd_ward_chk_out_details = new HashMap();
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		int index	= 0;
		try{
			if(patient_id!=null && patient_id.equals("null"))
				patient_id="";

			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_WARD_CHK_OUT_SELECT2")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,surgery_date);
			pstmt.setString(3,nursing_unit);
			pstmt.setString(4,patient_id);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				index++;
				ward_chk_out_details = new HashMap();
				ward_chk_out_details.put("patient_id",resultSet.getString("PATIENT_ID"));
				ward_chk_out_details.put("patient_name",resultSet.getString("PATIENT_NAME"));
				ward_chk_out_details.put("exam_code",resultSet.getString("EXAM_CODE"));
				ward_chk_out_details.put("exam_desc",resultSet.getString("EXAM_DESC"));
				ward_chk_out_details.put("surgeon_name",resultSet.getString("PHYSICIAN_NAME"));
				ward_chk_out_details.put("appt_from_time",resultSet.getString("APPT_START_TIME"));
				ward_chk_out_details.put("appt_to_time",resultSet.getString("APPT_END_TIME"));
				ward_chk_out_details.put("status_desc",resultSet.getString("STATUS_DESC"));
				ward_chk_out_details.put("appt_ref_num",resultSet.getString("APPT_REF_NUM"));
				ward_chk_out_details.put("order_id",resultSet.getString("ORDER_ID"));
				all_rd_ward_chk_out_details.put(index+"",ward_chk_out_details);
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		if(index==0)
			return false;
		return true;
	}

	public HashMap getWardChkOutDetails(){
		if(all_ward_chk_out_details==null)
			all_ward_chk_out_details=new HashMap();
		return this.all_ward_chk_out_details;
	}
	public HashMap getRDWardChkOutDetails(){
		if(all_rd_ward_chk_out_details==null)
			all_rd_ward_chk_out_details=new HashMap();
		return this.all_rd_ward_chk_out_details;
	}
	public ArrayList getMenuList(String oper_status, String role_id){
		ArrayList result = new ArrayList();
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT9")) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,oper_status);
			pstmt.setString(3,role_id);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				result.add(resultSet.getString("FUNCTION_ID"));
				result.add(resultSet.getString("FUNCTION_DESC_USER"));
				result.add(resultSet.getString("URL_DESC"));
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){}
        }
		return result;
	}
	public String updateStatusAndCommit(String appt_ref_num,String check_out_time){
		String error_text = "";
		String status = "";
		Connection connection  = null ;
		CallableStatement cstmt= null ;
		//int index=1;
		try{
/*
	OT_UPDATE_STATUS('22', <LOGGED IN FACILITY ID>, <BOOKING NUM>, NULL, NULL, NULL, NULL,NULL, <WAIT_LIST_YN>, <ORDER_ID>, NULL, NULL, NULL, <USER ID>, <WORKSTATION NO>, <L_STATUS>, <L_ERROR_TEXT>);
*/
			connection	= getConnection() ;
//			cstmt=connection.prepareCall("{call OT_UPDATE_STATUS(?,?,?,null,null,null,?,null,null,null,null,null,null,?,?,?,?)}");
			cstmt=connection.prepareCall("{call OT_UPDATE_OPER_DTLS(?,?,?,null,null,null,?,null,null,null,null,null,null,null,null,null,null,null,null,null,?,null,null,null,null,null,null,?,?,?,?,?)}");
			cstmt.setString( 1, "22");		// function_id
			cstmt.setString( 2, login_facility_id);	// operating_facility_id
			cstmt.setString( 3, appt_ref_num);		// booking_num
													// oper_num in this case it is passed as null
													// Holding Area Code
													// CHECKED_IN_DATE_TIME
			cstmt.setString( 4, "N");				// DOC_COMPL_YN for Recovery
					// ADDNL_FLD1,ADDNL_FLD2, ADDNL_FLD3,ADDNL_FLD4,ADDNL_FLD5, ADDNL_FLD6
			cstmt.setString( 5, check_out_time);//ADDNL_FLD14	
			cstmt.setString( 6, login_by_id);		// USER_ID , Slate login_id
			cstmt.setString( 7, login_at_ws_no);	// WS_NO

			cstmt.registerOutParameter( 8, Types.VARCHAR );	  // STATUS-> 'E' for Error and 'S' for Success
			cstmt.registerOutParameter( 9, Types.VARCHAR );  // ERROR_TEXT
			cstmt.registerOutParameter( 10, Types.VARCHAR );  // ERROR_TEXT
			cstmt.execute() ;
			connection.commit();
			status = cstmt.getString(8);
			if(status.equals("E")){
				error_text = cstmt.getString(9);
				error_text = cstmt.getString(10);
			}else
				error_text = "RECORD_INSERTED";
		}catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
                closeStatement( cstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return error_text;
	}

	public ArrayList updateRDExamsStatusAndCommit(String appt_ref_num){
		ArrayList result = new ArrayList();
		try{
			Properties prop = getProperties();
			InitialContext context = new InitialContext();
			Object object = context.lookup("java:comp/env/ExamsCheckList");
			ExamsCheckListHome home  = (ExamsCheckListHome) PortableRemoteObject.narrow( object, ExamsCheckListHome.class ) ;
			ExamsCheckListRemote remote = home.create() ;
			String sql = OTRepository.getOTKeyValue("SQL_OT_EXAMS_RD_APPT_UPDATE");
			result = remote.updateRDCheckList(prop,sql,appt_ref_num,login_facility_id,login_by_id,login_at_ws_no);
		}catch ( Exception e ) {
			result=null;
			result=new ArrayList();
			result.add("E");
			result.add(e);
	        e.printStackTrace() ;
		}finally {
        }
		return result;
	}
	public ArrayList getOperChecklists(String booking_num, String oper_num, String speciality_code,String order_id){
		Connection connection = null;
		CallableStatement cstmt=null;
		ArrayList result=new ArrayList();
		try{
			 if(booking_num==null)			booking_num="";
			 if(booking_num.equals("null"))	booking_num="";

			 if(oper_num==null)				oper_num="";
			 if(oper_num.equals("null"))	oper_num="";

			 if(order_id==null)				order_id="";
			 if(order_id.equals("null"))	order_id="";

			 if(booking_num!=null && !booking_num.equals("null") && !booking_num.equals(""))
				 order_id = "";

			 connection = getConnection();
		     cstmt=connection.prepareCall("{call OT_OPER_CHECKLISTS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,null,null,?)}");
		 	 cstmt.setString(1,login_facility_id);
			 cstmt.setString(2,"P");// V_PRE_OR_POST ="Pre" for checkin,checkoutfromward & holdingarea
		 	 cstmt.setString(3,order_id);
		 	 cstmt.setString(4,booking_num);
		 	 cstmt.setString(5,oper_num);
		 	 cstmt.setString(6,speciality_code);
			 cstmt.registerOutParameter(7,Types.VARCHAR); // concatenated Checklist String
			 cstmt.registerOutParameter(8,Types.VARCHAR); // V_NO_OF_VERIFICATIONS
			 cstmt.registerOutParameter(9,Types.VARCHAR); // role_1
			 cstmt.registerOutParameter(10,Types.VARCHAR); // role_2
			 cstmt.registerOutParameter(11,Types.VARCHAR); // role_3
			 cstmt.registerOutParameter(12,Types.VARCHAR); // role_4

			 cstmt.registerOutParameter(13,Types.VARCHAR); //STATUS
			 cstmt.registerOutParameter(14,Types.VARCHAR); // Error text
			 cstmt.registerOutParameter(15,Types.VARCHAR); // Language Error text
			 cstmt.execute();
			 result.add(cstmt.getString(7));  //checklist string
			 result.add(cstmt.getString(8));  // no_of_verifications
			 result.add(cstmt.getString(9));  // role_id_1
			 result.add(cstmt.getString(10));  // role_id_2
			 result.add(cstmt.getString(11)); // role_id_3
			 result.add(cstmt.getString(12)); // role_id_4
	    }
		catch (Exception e){
		 e.printStackTrace();
		}
		finally{
		  try{
			closeStatement( cstmt ) ;
			closeConnection( connection );
		  }catch(Exception e){}
		}
		return result;
	}

	public ArrayList getUserInfo(String booking_num, String oper_num, String current_level, String order_id, String appt_yn){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList result=new ArrayList();
		try{
			// if appt_yn = Y, it is completed and booking_num is to be considered
			// if appt_yn = N, it is waitlisted and order_id is to be considered

			if(booking_num==null || !appt_yn.equals("Y")) booking_num="";
			if(booking_num.equals("null") || !appt_yn.equals("Y"))	booking_num="";

			if(oper_num==null)				oper_num="";
			if(oper_num.equals("null"))		oper_num="";

			if(order_id==null || appt_yn.equals("Y"))			order_id="";
			if(order_id.equals("null") || appt_yn.equals("Y"))	order_id="";
		
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_SELECT6")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,booking_num);
			pstmt.setString(3,oper_num);
			pstmt.setString(4,order_id);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				result.add(resultSet.getString("PRE_OP_CHKLST_USR1_ID"));
				result.add(resultSet.getString("PRE_OP_CHKLST_USR1_COMPL_YN"));
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){}
        }
		return result;
	}
	 public String getCheckListReqdYNFlag(String function_id){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		String check_for_check_list_compl="";
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_SELECT7")) ;
			pstmt.setString(1, locale);
			pstmt.setString(2, function_id);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
		        check_for_check_list_compl = resultSet.getString("CHECK_FOR_CHECK_LIST_COMPL");
			}
		}catch (Exception e){
		 e.printStackTrace();
		}
		finally{
		  try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
		  }catch(Exception e){}
		}
		return check_for_check_list_compl;
	 }

}
