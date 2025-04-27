/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;

public class MergeDuplicateForPatientServlet extends javax.servlet.http.HttpServlet 
{
	PrintWriter out;
	Properties p;
	HttpSession session;
	
	Connection con						= null;
	Statement stmt						= null;
	PreparedStatement pstmt				= null;
	PreparedStatement pstmt1			= null;
	PreparedStatement InsertSQLPstmt	= null;
	PreparedStatement InsDupGrDtlPstmt	= null;
	PreparedStatement InsDupGrDtlPstmt1	= null;
	ResultSet messageResultset          = null;
	ResultSet rs						= null;

	StringBuffer sb						= null;
	StringBuffer sb1					= null;
	StringBuffer InsertSQL				= null;
	StringBuffer InsertSQLDrSrCr		= null;
	StringBuffer InsertSQLDrDupGeHrd	= null;
	StringBuffer InsertSQLDrDupGeDtl	= null;
	StringBuffer InsertSQLDrDupGeDtl1	= null;

	String client_ip_address			= "";
	String other_alt_id_type			= "";
	String p_oth_alt_id_type			= "";
	String name_loc_lang_yn				= "";
	String names_in_oth_lang_yn			= "";
	String first_name 					= "";
	String second_name 					= "";
	String third_name 					= "";
	String family_name 					= "";
	String names_sndx_type				= "";
	String nationality_code				= "";
	String sex 							= "";
	String day_of_birth 				= "";
	String month_of_birth 				= "";
	String year_of_birth 				= "";
	String res_area_code 				= "";
	String contact1_no 					= "";
	String contact2_no					= "";
	String search_type 					= "";
	String facilityId					= "";
    String addedById					= "";
	String modifiedById					= "";
	String addedFacilityId				= "";
	String modifiedFacilityId			= "";
	String addedAtWorkstation			= "";
	String modifiedAtWorkstation		= "";
	String p_patient_id					= "";
	String p_id_no						= "";
	String sqlupdate					= "";
	String p_line						= "";
	String pCount						= "";
	String message						= "";
	String code							= "";
	String p_p_patient_id				= "";
	String search_all_ser				= "";
	String proc_id						= "";
	String groupId						= "";
	String sStyle                       = "";
	////
			String p_first_name				= "";
			String p_second_name			= "";
			String p_third_name				= "";
			String p_family_name			= "";
			String p_patient_name			= "";
			String p_sex					= "";
			String p_date_of_birth			= "";
			String p_pat_ser_grp_code		= "";
			String p_nationality_code		= "";
			String p_res_area_code			= "";
			String p_contact1_no			= "";
			String p_contact2_no			= "";
			String p_regn_facility_id		= "";
			String p_mp_patient_added_date	= "";
			String p_remarks				= "";
			String p_file_location			= "";
			String p_file_facility_id		= "";
			String p_file_mr_section_code	= "";
			String p_file_no				= "";
			String p_check_single_multi_file= "";
			String sqlselect				= "";
	
	int	group_id						= 0;
	int	p_count							= 0;
	int rsinsertctl						= 0;
	int rsinserthdr						= 0;
	int rsinsertdtl1					= 0;
	int insertdrcriteria				= 0;
	//t p_dup_group_id					= 1;
		
	boolean com_flag					= true;
	boolean com_flag_fail				= true;


	public void init(ServletConfig config) throws ServletException
	{
			super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			session					= req.getSession(false);
			this.facilityId			= (String) session.getValue("facility_id");
			this.p					= (Properties) session.getValue("jdbc");
			this.client_ip_address	= p.getProperty("client_ip_address");
			sStyle	=
        	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			
			con  = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			stmt = con.createStatement();			
			
			this.out					=res.getWriter();

			sb  = new StringBuffer();
			sb1 = new StringBuffer();

			p_patient_id				= req.getParameter("patient_id_for");
			p_line						= req.getParameter("p_p_line");
			pCount						= req.getParameter("count_record");
			name_loc_lang_yn			= req.getParameter("name_loc_lang_ser");
			names_in_oth_lang_yn		= req.getParameter("names_in_oth_lang_yn");
			first_name 					= req.getParameter("first_name_ser");
			second_name 				= req.getParameter("second_name_ser");
			third_name 					= req.getParameter("third_name_ser");
			family_name 				= req.getParameter("family_name_ser");    
			names_sndx_type				= req.getParameter("names_sndx_type"); 
			nationality_code			= req.getParameter("nationality_ser"); 
			sex 						= req.getParameter("sex_ser");
			day_of_birth 				= req.getParameter("day_of_birth_yn"); 
			month_of_birth 				= req.getParameter("month_of_birth_yn"); 
			year_of_birth 				= req.getParameter("year_of_birth_yn"); 
			res_area_code 				= req.getParameter("area_ser"); 
			contact1_no 				= req.getParameter("contact1_no_ser"); 
			contact2_no					= req.getParameter("contact2_no_ser");
			search_all_ser				= req.getParameter("search_all_ser");
			other_alt_id_type			= req.getParameter("other_alt_id_type");

			addedById					= p.getProperty( "login_user" );
			p_count						= Integer.parseInt(pCount);

			if(names_sndx_type == null) names_sndx_type="G";
			if(other_alt_id_type == null || other_alt_id_type.equals("null")) other_alt_id_type="";
			if(names_in_oth_lang_yn == null || names_in_oth_lang_yn.equals("null")) names_in_oth_lang_yn="";
			if(names_in_oth_lang_yn.equals("N"))
			{
				name_loc_lang_yn = "N";
			}
			modifiedById				= addedById;
			addedFacilityId				= facilityId;
			modifiedFacilityId	        = addedFacilityId ;
			addedAtWorkstation	        = client_ip_address;
			modifiedAtWorkstation       = addedAtWorkstation;	

			insertMergeDuplicateForPatientServlet(res);

			if(rs!=null) rs.close();
			if(messageResultset!=null) 	messageResultset.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(InsertSQLPstmt != null) InsertSQLPstmt.close();
			if(InsDupGrDtlPstmt != null) InsDupGrDtlPstmt.close();

		}catch(Exception e){out.println(e.toString());e.printStackTrace();}
		finally
		{
			ConnectionManager.returnConnection(con,req);
		}
	}//do post	 
	private synchronized void insertMergeDuplicateForPatientServlet(HttpServletResponse res)
	{
		try {

			String locale = p.getProperty("LOCALE");
			

			com_flag_fail			= true;
			com_flag				= true;
			InsertSQL				= new StringBuffer();
			InsertSQLDrSrCr			= new StringBuffer();
			InsertSQLDrDupGeHrd		= new StringBuffer();
			InsertSQLDrDupGeDtl		= new StringBuffer();
			InsertSQLDrDupGeDtl1	= new StringBuffer();
			rs = stmt.executeQuery("SELECT DR_DUP_GROUP_HDR_SEQ1.nextval next_group_id FROM dual ");
			while (rs.next())
			{
				groupId	 = rs.getString("next_group_id");
				group_id = Integer.parseInt(groupId);
			} if(rs != null) rs.close();
			rs = stmt.executeQuery( "SELECT DR_PROCESS_CTL_SEQ1.nextval next_proc_id FROM dual ");
			while (rs.next()){
				proc_id	= rs.getString("next_proc_id");
			} if(rs != null) rs.close();
			sqlupdate = "SELECT search_privilege_level from dr_user_rights WHERE appl_user_id = '"+addedById+"'";
			rs = stmt.executeQuery(sqlupdate);
			while(rs.next()){
				search_type = rs.getString("search_privilege_level");
			} if(rs != null) rs.close();
			if(search_all_ser != null && search_all_ser.equals("Y")) search_type = "A";
			else search_type = "L";
			stmt.executeUpdate("DELETE FROM dr_process_ctl");
			InsertSQL.append("INSERT INTO dr_process_ctl (proc_id,initiating_function_id,proc_status,search_status, order_by_for_process_cycle,merge_submit_date,merge_submit_by_id,merge_schedule_date, added_by_id,added_date,added_at_ws_no,added_facility_id, modified_by_id,modified_date,modified_at_ws_no,modified_facility_id, merge_facility_id,merge_ws_no,search_facility_id,search_type,search_ws_no) values (?,'DR_CHECK_CONFIRM_DUPLICATES','S1','S','P',sysdate,?,sysdate,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?)");
			InsertSQLPstmt = con.prepareStatement(InsertSQL.toString());
			InsertSQLPstmt.setString(1,proc_id);
			InsertSQLPstmt.setString(2,addedById);
			InsertSQLPstmt.setString(3,addedById);
			InsertSQLPstmt.setString(4,addedAtWorkstation);
			InsertSQLPstmt.setString(5,addedFacilityId);
			InsertSQLPstmt.setString(6,modifiedById);
			InsertSQLPstmt.setString(7,modifiedAtWorkstation);
			InsertSQLPstmt.setString(8,modifiedFacilityId);
			InsertSQLPstmt.setString(9,addedFacilityId);
			InsertSQLPstmt.setString(10,addedAtWorkstation);
			InsertSQLPstmt.setString(11,addedFacilityId);
			InsertSQLPstmt.setString(12,search_type);
			InsertSQLPstmt.setString(13,addedAtWorkstation);
         	rsinsertctl  = InsertSQLPstmt.executeUpdate();
            if(InsertSQLPstmt != null) InsertSQLPstmt.close();
			if(rsinsertctl > 0)
			{
				buildQuery_update();
				if(rsinserthdr > 0)
				{
					p_p_patient_id = "";
					StringTokenizer indtoken = new StringTokenizer(p_line,"|");
					InsertSQLDrDupGeDtl.append("INSERT INTO dr_dup_group_dtls (dup_group_id,patient_id,dup_indicator,sug_valid_pat_flag,remarks,first_name,second_name,third_name,family_name,patient_name,sex,date_of_birth,pat_ser_grp_code,national_id_no,nationality_code,res_area_code,contact1_no,contact2_no,regn_facility_id,mp_patient_added_date,file_location,file_facility_id,file_mr_section_code,file_no,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,oth_alt_id_type) values (?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi:ss'),?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi:ss'),?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)");
					InsDupGrDtlPstmt = con.prepareStatement(InsertSQLDrDupGeDtl.toString());
					InsertSQLDrDupGeDtl1.append("INSERT INTO dr_dup_group_dtls (dup_group_id,patient_id,dup_indicator,sug_valid_pat_flag,remarks,first_name,second_name,third_name,family_name,patient_name,sex,date_of_birth,pat_ser_grp_code,national_id_no,nationality_code,res_area_code,contact1_no,contact2_no,regn_facility_id,mp_patient_added_date,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,oth_alt_id_type) values (?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi:ss'),?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi:ss'),?,sysdate,?,?,?,sysdate,?,?,?)");
					InsDupGrDtlPstmt1 = con.prepareStatement(InsertSQLDrDupGeDtl1.toString());
             		sqlselect = "select count(*) from dr_dup_group_dtls where patient_id = ?";
					pstmt = con.prepareStatement(sqlselect);
					sqlupdate = "SELECT a.patient_id,first_name,second_name,third_name,family_name,patient_name,sex,to_char(date_of_birth,'dd/mm/rrrr hh24:mi') date_of_birth ,pat_ser_grp_code,national_id_no,nationality_code,res_area_code,contact1_no,contact2_no,regn_facility_id,to_char(a.added_date,'dd/mm/rrrr')patient_added_date,Substr(a.Patient_Id,5,1)||Substr(a.Patient_Id,7,2) file_location,b.facility_id,mr_section_code,file_no,oth_alt_id_type FROM mp_patient a,mr_pat_file_index b WHERE a.patient_id = b.patient_id(+) AND a.patient_id = ? AND rownum <= 1 ";
					pstmt1 = con.prepareStatement(sqlupdate);
					while(indtoken.hasMoreTokens())
					{
						p_p_patient_id	= indtoken.nextToken();
						int no_record	= 0;
						pstmt.setString(1,p_p_patient_id);	
						rs	  = pstmt.executeQuery();
						while(rs != null && rs.next()){
							no_record = rs.getInt(1);
						}  if(rs != null) rs.close(); 
						
						if(no_record == 0) {	
							buidQuery_mergedp();
							buidQuery();
							sb.append("rsinsertdtl1  8:"+rsinsertdtl1+"<br>");
						}else {
							com_flag = false;
							com_flag_fail=false;
					   }
					}//while
				}
				else
					com_flag = false;
			 }
			else 
				com_flag = false;
			if(com_flag){
				con.commit();
			
			/*	String msg = "SELECT message_id, message_text_sysdef FROM sm_message WHERE message_ref = 'RECORD_INSERTED'";
				messageResultset = stmt.executeQuery(msg);
				if(messageResultset != null){
					if(messageResultset.next()){
						code	= messageResultset.getString("message_id");
						message = messageResultset.getString("message_text_sysdef");
					}
				} if(messageResultset != null) messageResultset.close();  */

					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					String error = ((String) message.get("message"));

					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=1 " );
			} 
			else if((com_flag_fail==false) && (com_flag==false)) {
				con.rollback();	
				//String msg=sb1.toString()+sb.toString();
				
				//String message="APP-DR0011 The Cycle is already in progress" ;
				java.util.Hashtable message = MessageManager.getMessage(locale, "CYCLE_IN_PROGRESS", "DR");
				String error = ((String) message.get("message"));
				
				out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link></head><body class='message'>") ;
				out.println("<script>alert('"+error+"');</script>");
				out.println("<script> parent.location.href='../eCommon/jsp/dmenu.jsp';</script>");
				out.println("<script> location.href='../eCommon/jsp/error.jsp?err_num=&err_value=1';</script>");
				out.println("</body></html>");
			}else{
				con.rollback();	
			//	String msg = sb1.toString()+sb.toString();
			//	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("Transaction Failed... "+msg) + "&err_value=0 " );
			}
			if((InsertSQL != null) && (InsertSQL.length() > 0)) InsertSQL.delete(0,InsertSQL.length());
			if((InsertSQLDrSrCr != null) && (InsertSQLDrSrCr.length() > 0)) InsertSQLDrSrCr.delete(0,InsertSQLDrSrCr.length());
			if((InsertSQLDrDupGeHrd != null) && (InsertSQLDrDupGeHrd.length() > 0)) InsertSQLDrDupGeHrd.delete(0,InsertSQLDrDupGeHrd.length());
			if((InsertSQLDrDupGeDtl != null) && (InsertSQLDrDupGeDtl.length() > 0)) InsertSQLDrDupGeDtl.delete(0,InsertSQLDrDupGeDtl.length());	
			if((InsertSQLDrDupGeDtl1 != null) && (InsertSQLDrDupGeDtl1.length() > 0))InsertSQLDrDupGeDtl1.delete(0,InsertSQLDrDupGeDtl1.length());
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(pstmt1 != null) pstmt1.close();
			if(InsDupGrDtlPstmt != null) InsDupGrDtlPstmt.close();
			if(InsDupGrDtlPstmt1 != null) InsDupGrDtlPstmt1.close();

		}catch(Exception e)
		{
			e.printStackTrace();
			try
			{
				con.rollback();	
			}catch(Exception ed){out.println("Exception while Rollback :"+ed);ed.printStackTrace();}

			out.println("<h3> Exception raise by Servlet ...So Record Not modified </h3> Foll: Error Received : "+e.toString());
			out.println("<br>Values sent are :") ;
			out.println("<br>Querie values :" + sb.toString());
			out.println("<br>Result values :" + sb1.toString());
		}
	}//method		
private synchronized void buidQuery_mergedp()
{
	try
	{
		pstmt1.setString(1,p_p_patient_id);
		rs	  = pstmt1.executeQuery();
		while(rs != null && rs.next()) {
			p_first_name			= rs.getString("first_name");
			p_second_name			= rs.getString("second_name");
			p_third_name			= rs.getString("third_name");
			p_family_name			= rs.getString("family_name");
			p_patient_name			= rs.getString("patient_name");
			p_sex					= rs.getString("sex");
			p_date_of_birth			= rs.getString("date_of_birth");
			p_pat_ser_grp_code		= rs.getString("pat_ser_grp_code");
			p_nationality_code		= rs.getString("nationality_code");
			p_res_area_code			= rs.getString("res_area_code");
			p_contact1_no			= rs.getString("contact1_no");
			p_contact2_no			= rs.getString("contact2_no");
			p_regn_facility_id		= rs.getString("regn_facility_id");
			p_mp_patient_added_date	= rs.getString("patient_added_date");
			p_file_location			= rs.getString("file_location");
			p_file_facility_id		= checkForNull(rs.getString("facility_id"));
			p_file_mr_section_code	= checkForNull(rs.getString("mr_section_code"));
			p_file_no				= checkForNull(rs.getString("file_no"));
			p_oth_alt_id_type		= rs.getString("oth_alt_id_type");
		} if(rs != null) rs.close(); 
	}catch(Exception e)
	{
		out.println("Exception occured"+e.toString());
		e.printStackTrace();
	}

}
private synchronized void buidQuery()
{
	try {
		rs = stmt.executeQuery("SELECT Check_Single_File_For_Patient check_single_multi_file FROM dual ");
		while (rs.next())
		{
			p_check_single_multi_file = rs.getString("check_single_multi_file");
		} if(rs != null) rs.close();
		sb.append("sqlupdate  7b:"+sqlupdate+"<br> p_check_single_multi_file  :"+p_check_single_multi_file+"<br>");
		if(p_patient_id.equals(p_p_patient_id))
		{
			if (p_check_single_multi_file.equals("T")){
	  			InsDupGrDtlPstmt.setInt(1,group_id);
				InsDupGrDtlPstmt.setString(2,p_p_patient_id);
				InsDupGrDtlPstmt.setString(3,"V");
				InsDupGrDtlPstmt.setString(4,"Y");
				InsDupGrDtlPstmt.setString(5,p_remarks);
				InsDupGrDtlPstmt.setString(6,p_first_name);
				InsDupGrDtlPstmt.setString(7,p_second_name);
				InsDupGrDtlPstmt.setString(8,p_third_name);
				InsDupGrDtlPstmt.setString(9,p_family_name);
				InsDupGrDtlPstmt.setString(10,p_patient_name);
				InsDupGrDtlPstmt.setString(11,p_sex);
				InsDupGrDtlPstmt.setString(12,p_date_of_birth);
				InsDupGrDtlPstmt.setString(13,p_pat_ser_grp_code);
				InsDupGrDtlPstmt.setString(14,p_id_no);
				InsDupGrDtlPstmt.setString(15,p_nationality_code);
				InsDupGrDtlPstmt.setString(16,p_res_area_code);
				InsDupGrDtlPstmt.setString(17,p_contact1_no);
				InsDupGrDtlPstmt.setString(18,p_contact2_no);
				InsDupGrDtlPstmt.setString(19,p_regn_facility_id);
				InsDupGrDtlPstmt.setString(20,p_mp_patient_added_date);
				InsDupGrDtlPstmt.setString(21,p_file_location);
				InsDupGrDtlPstmt.setString(22,p_file_facility_id);
				InsDupGrDtlPstmt.setString(23,p_file_mr_section_code);
				InsDupGrDtlPstmt.setString(24,p_file_no);
				InsDupGrDtlPstmt.setString(25,addedById);
				InsDupGrDtlPstmt.setString(26,addedAtWorkstation);
				InsDupGrDtlPstmt.setString(27,addedFacilityId);
				InsDupGrDtlPstmt.setString(28,modifiedById);
				InsDupGrDtlPstmt.setString(29,modifiedAtWorkstation);
				InsDupGrDtlPstmt.setString(30,modifiedFacilityId);
				InsDupGrDtlPstmt.setString(31,p_oth_alt_id_type);
				rsinsertdtl1	= InsDupGrDtlPstmt.executeUpdate();
			    }   else if(p_check_single_multi_file.equals("F")){
				InsDupGrDtlPstmt1.setInt(1,group_id);
				InsDupGrDtlPstmt1.setString(2,p_p_patient_id);
				InsDupGrDtlPstmt1.setString(3,"V");
				InsDupGrDtlPstmt1.setString(4,"Y");
				InsDupGrDtlPstmt1.setString(5,p_remarks);
				InsDupGrDtlPstmt1.setString(6,p_first_name);
				InsDupGrDtlPstmt1.setString(7,p_second_name);
				InsDupGrDtlPstmt1.setString(8,p_third_name);
				InsDupGrDtlPstmt1.setString(9,p_family_name);
				InsDupGrDtlPstmt1.setString(10,p_patient_name);
				InsDupGrDtlPstmt1.setString(11,p_sex);
				InsDupGrDtlPstmt1.setString(12,p_date_of_birth);
				InsDupGrDtlPstmt1.setString(13,p_pat_ser_grp_code);
				InsDupGrDtlPstmt1.setString(14,p_id_no);
				InsDupGrDtlPstmt1.setString(15,p_nationality_code);
				InsDupGrDtlPstmt1.setString(16,p_res_area_code);
				InsDupGrDtlPstmt1.setString(17,p_contact1_no);
				InsDupGrDtlPstmt1.setString(18,p_contact2_no);
				InsDupGrDtlPstmt1.setString(19,p_regn_facility_id);
				InsDupGrDtlPstmt1.setString(20,p_mp_patient_added_date);
				InsDupGrDtlPstmt1.setString(21,addedById);
				InsDupGrDtlPstmt1.setString(22,addedAtWorkstation);
				InsDupGrDtlPstmt1.setString(23,addedFacilityId);
				InsDupGrDtlPstmt1.setString(24,modifiedById);
				InsDupGrDtlPstmt1.setString(25,modifiedAtWorkstation);
				InsDupGrDtlPstmt1.setString(26,modifiedFacilityId);
				InsDupGrDtlPstmt1.setString(27,p_oth_alt_id_type);
				rsinsertdtl1	= InsDupGrDtlPstmt1.executeUpdate();
			}
		}else{
			if(p_check_single_multi_file.equals("T")){
				InsDupGrDtlPstmt.setInt(1,group_id);		
				InsDupGrDtlPstmt.setString(2,p_p_patient_id);									
				InsDupGrDtlPstmt.setString(3,"D");
				InsDupGrDtlPstmt.setString(4,"N");
				InsDupGrDtlPstmt.setString(5,p_remarks);									
				InsDupGrDtlPstmt.setString(6,p_first_name);									
				InsDupGrDtlPstmt.setString(7,p_second_name);									
				InsDupGrDtlPstmt.setString(8,p_third_name);									
				InsDupGrDtlPstmt.setString(9,p_family_name);									
				InsDupGrDtlPstmt.setString(10,p_patient_name);									
				InsDupGrDtlPstmt.setString(11,p_sex);									
				InsDupGrDtlPstmt.setString(12,p_date_of_birth);									
				InsDupGrDtlPstmt.setString(13,p_pat_ser_grp_code);									
				InsDupGrDtlPstmt.setString(14,p_id_no);									
				InsDupGrDtlPstmt.setString(15,p_nationality_code);									
				InsDupGrDtlPstmt.setString(16,p_res_area_code);									
				InsDupGrDtlPstmt.setString(17,p_contact1_no);									
				InsDupGrDtlPstmt.setString(18,p_contact2_no);									
				InsDupGrDtlPstmt.setString(19,p_regn_facility_id);									
				InsDupGrDtlPstmt.setString(20,p_mp_patient_added_date);									
				InsDupGrDtlPstmt.setString(21,p_file_location);									
				InsDupGrDtlPstmt.setString(22,p_file_facility_id);									
				InsDupGrDtlPstmt.setString(23,p_file_mr_section_code);									
				InsDupGrDtlPstmt.setString(24,p_file_no);									
				InsDupGrDtlPstmt.setString(25,addedById);									
				InsDupGrDtlPstmt.setString(26,addedAtWorkstation);									
				InsDupGrDtlPstmt.setString(27,addedFacilityId);									
				InsDupGrDtlPstmt.setString(28,modifiedById);									
				InsDupGrDtlPstmt.setString(29,modifiedAtWorkstation);									
				InsDupGrDtlPstmt.setString(30,modifiedFacilityId);									
				InsDupGrDtlPstmt.setString(31,p_oth_alt_id_type);									                     
				rsinsertdtl1	= InsDupGrDtlPstmt.executeUpdate();					
			}else if(p_check_single_multi_file.equals("F")){                       
				InsDupGrDtlPstmt1.setInt(1,group_id);
				InsDupGrDtlPstmt1.setString(2,p_p_patient_id);
				InsDupGrDtlPstmt1.setString(3,"D");
				InsDupGrDtlPstmt1.setString(4,"N");
				InsDupGrDtlPstmt1.setString(5,p_remarks);
				InsDupGrDtlPstmt1.setString(6,p_first_name);
				InsDupGrDtlPstmt1.setString(7,p_second_name);
				InsDupGrDtlPstmt1.setString(8,p_third_name);
				InsDupGrDtlPstmt1.setString(9,p_family_name);
				InsDupGrDtlPstmt1.setString(10,p_patient_name);
				InsDupGrDtlPstmt1.setString(11,p_sex);
				InsDupGrDtlPstmt1.setString(12,p_date_of_birth);
				InsDupGrDtlPstmt1.setString(13,p_pat_ser_grp_code);
				InsDupGrDtlPstmt1.setString(14,p_id_no);
				InsDupGrDtlPstmt1.setString(15,p_nationality_code);
				InsDupGrDtlPstmt1.setString(16,p_res_area_code);
				InsDupGrDtlPstmt1.setString(17,p_contact1_no);
				InsDupGrDtlPstmt1.setString(18,p_contact2_no);
				InsDupGrDtlPstmt1.setString(19,p_regn_facility_id);
				InsDupGrDtlPstmt1.setString(20,p_mp_patient_added_date);
				InsDupGrDtlPstmt1.setString(21,addedById);
				InsDupGrDtlPstmt1.setString(22,addedAtWorkstation);
				InsDupGrDtlPstmt1.setString(23,addedFacilityId);
				InsDupGrDtlPstmt1.setString(24,modifiedById);
				InsDupGrDtlPstmt1.setString(25,modifiedAtWorkstation);
				InsDupGrDtlPstmt1.setString(26,modifiedFacilityId);
				InsDupGrDtlPstmt1.setString(27,p_oth_alt_id_type);
				rsinsertdtl1	= InsDupGrDtlPstmt1.executeUpdate();
			}
		}
	}catch(Exception e){ out.println("Exception occured"+e.toString()); e.printStackTrace();
	}
}
private synchronized void buildQuery_update()
{
	      try
			{
				sqlupdate		= "DELETE FROM dr_search_criteria";	
				stmt.executeUpdate(sqlupdate);	
				InsertSQLDrSrCr.append("INSERT INTO dr_search_criteria (module_id,facility_id,name_loc_lang_yn,first_name_yn,second_name_yn,third_name_yn,family_name_yn,names_sndx_type,sex_yn,day_of_birth_yn,month_of_birth_yn,year_of_birth_yn,res_area_code_yn,contact1_no_yn,contact2_no_yn,nationality_code_yn,search_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,other_alt_id_type) values ('DR',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)");
				InsertSQLPstmt	 = con.prepareStatement(InsertSQLDrSrCr.toString());
				InsertSQLPstmt.setString(1,facilityId);
				InsertSQLPstmt.setString(2,name_loc_lang_yn);
				InsertSQLPstmt.setString(3,first_name);
				InsertSQLPstmt.setString(4,second_name);
				InsertSQLPstmt.setString(5,third_name);
				InsertSQLPstmt.setString(6,family_name);
				InsertSQLPstmt.setString(7,names_sndx_type);
				InsertSQLPstmt.setString(8,sex);
				InsertSQLPstmt.setString(9,day_of_birth);
				InsertSQLPstmt.setString(10,month_of_birth);
				InsertSQLPstmt.setString(11,year_of_birth);
				InsertSQLPstmt.setString(12,res_area_code);
				InsertSQLPstmt.setString(13,contact1_no);
				InsertSQLPstmt.setString(14,contact2_no);
				InsertSQLPstmt.setString(15,nationality_code);
				InsertSQLPstmt.setString(16,search_type);
				InsertSQLPstmt.setString(17,addedById);
				InsertSQLPstmt.setString(18,addedAtWorkstation);
				InsertSQLPstmt.setString(19,addedFacilityId);
				InsertSQLPstmt.setString(20,modifiedById);
				InsertSQLPstmt.setString(21,modifiedAtWorkstation);
				InsertSQLPstmt.setString(22,modifiedFacilityId);
				InsertSQLPstmt.setString(23,other_alt_id_type);
               	insertdrcriteria = InsertSQLPstmt.executeUpdate();
               	if(InsertSQLPstmt != null) InsertSQLPstmt.close();
				sb1.append("insertdrcriteria :"+insertdrcriteria+"<br>");		
				InsertSQLDrDupGeHrd.append("INSERT INTO dr_dup_group_hdr (dup_group_id,pat_count,group_created_date,group_status,status_upd_date,system_gen_yn, marked_for_merge_yn,added_by_id,added_date,added_at_ws_no,added_facility_id, modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)  values(?,?,sysdate,'U',sysdate,'Y','N',?,sysdate,?,?,?,sysdate,?,?)");
				InsertSQLPstmt = con.prepareStatement(InsertSQLDrDupGeHrd.toString());
				InsertSQLPstmt.setInt(1,group_id);
				InsertSQLPstmt.setInt(2,p_count);
  				InsertSQLPstmt.setString(3,addedById);
				InsertSQLPstmt.setString(4,addedAtWorkstation);
				InsertSQLPstmt.setString(5,addedFacilityId);
				InsertSQLPstmt.setString(6,modifiedById);
				InsertSQLPstmt.setString(7,modifiedAtWorkstation);
				InsertSQLPstmt.setString(8,modifiedFacilityId);
				rsinserthdr = InsertSQLPstmt.executeUpdate();
        		if(InsertSQLPstmt != null) InsertSQLPstmt.close();
		}
	  catch(Exception e)
	 {
      out.println("Exception occured"+e.toString());
	  e.printStackTrace();
	 }
				
}
public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
}//class
