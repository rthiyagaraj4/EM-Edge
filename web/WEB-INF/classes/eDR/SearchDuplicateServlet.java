/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
	Developed By       :  P.Sudhakaran
	Module Name 	   :  eHIS/dr
	Function Name	   :  Duplicate search  Criteria
	Function ID		   :
	This servlet is used fo insert and update the default search criteria values into the database.
*/
package eDR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
public class SearchDuplicateServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	HttpSession session;
	
	Connection con						= null;
	Statement stmt						= null;
	PreparedStatement InsertPstmtCtl	= null;
	PreparedStatement InsertPstmtCtlPNL	= null;
	PreparedStatement InsertPstmtDrSrCr	= null;
	CallableStatement csstmt		    = null;
	ResultSet rs						= null;
	ResultSet messageResultset          = null;

	StringBuffer sb			= null;
	StringBuffer CtlSQL		= null;
	StringBuffer CtlPNLSQL	= null;
	StringBuffer DrSrCrSQL	= null;

	String client_ip_address		= "";
	String facilityId				= "";
	String proc_status_chk			= "";
    String mode						= "";
	String addedById				= "";
	String modifiedById				= "";
	String addedFacilityId			= "";
	String modifiedFacilityId		= "";
	String addedAtWorkstation		= "";
	String modifiedAtWorkstation	= "";
	String name_loc_lang_yn			= "";
	String first_name 				= "";
	String second_name 				= "";
	String third_name 				= "";
	String family_name 				= "";
	String names_sndx_type			= "";
	String nationality_code			= "";
	String sex 						= "";
	String day_of_birth 			= "";
	String month_of_birth 			= "";
	String year_of_birth 			= "";
	String res_area_code 			= "";
	String contact1_no 				= "";
	String contact2_no				= "";
	String search_type 				= "";
	String order_by_process			= "";
	String str						= "";
	String process_start			= "";
	String process_start_time		= "";
	String proc_one					= "";
	String job_queue				= "";
	String proc_id					= "";
	String comp_sys					= "";
	String sys_compare				= "";
	String short_desc11				= "";
	String short_desc22				= "";
	String short_desc33				= "";
	String short_desc44				= "";
	String other_alt_id_type		= "";
     
	int rsdelete		= 0;
	int count_ctl		= 0;
	int rsinsertctl		= 0;
	int rsinsertft		= 0;
   String sStyle;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session					= req.getSession(false);
		this.facilityId			= (String) session.getValue("facility_id");

		this.p					= (Properties) session.getValue("jdbc");
		this.client_ip_address	= p.getProperty("client_ip_address");
		addedById				= p.getProperty("login_user");
	
		String locale = p.getProperty("LOCALE");
		

		try
		{
			con		= ConnectionManager.getConnection(req);
			stmt	= con.createStatement();
			HttpSession session;
			session = req.getSession(true);
			 sStyle	=
        	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			this.out	= res.getWriter();

			mode				= req.getParameter("mode");
			name_loc_lang_yn	= req.getParameter("name_loc_lang_yn");
			first_name 			= req.getParameter("first_name");
			short_desc11 		= req.getParameter("short_desc11");
			short_desc22 		= req.getParameter("short_desc22");
			short_desc33 		= req.getParameter("short_desc33");
			short_desc44 		= req.getParameter("short_desc44");
			second_name 		= req.getParameter("second_name");
			third_name 			= req.getParameter("third_name");
			family_name 		= req.getParameter("family_name");
			names_sndx_type		= req.getParameter("names_sndx_type");
			nationality_code	= req.getParameter("nationality_code");
			sex 				= req.getParameter("sex");
			day_of_birth 		= req.getParameter("day_of_birth1");
			month_of_birth 		= req.getParameter("month_of_birth1");
			year_of_birth 		= req.getParameter("year_of_birth1");
			res_area_code 		= req.getParameter("res_area_code");
			contact1_no 		= req.getParameter("contact1_no");
			contact2_no			= req.getParameter("contact2_no");
			search_type 		= req.getParameter("search_type");
			order_by_process	= req.getParameter("order_by");
			process_start		= req.getParameter("process_start");
			other_alt_id_type	= req.getParameter("other_alt_id_type");
			
		
			if(other_alt_id_type == null || other_alt_id_type.equals("null")) other_alt_id_type = "";
		
			if(process_start.equals("process_later"))
			{
				process_start_time	= req.getParameter("start_later_time");
               	process_start_time=DateUtils.convertDate(process_start_time,"DMYHM",locale,"en");
				sys_compare = "";
				sys_compare = "SELECT (CASE WHEN to_date(to_char(SYSDATE,'dd/mm/rrrr hh24:mi'),'dd/mm/rrrr hh24:mi')<(to_date('"+process_start_time+"','dd/mm/rrrr hh24:mi')) THEN 'Y' ELSE 'N' END) FROM dual";
				rs = stmt.executeQuery(sys_compare);
			
				while(rs != null && rs.next())
				{
					comp_sys = rs.getString(1);
				} 
			 }
			else
			{
				comp_sys = "Y";
			} 

			if(rs != null) rs.close();
		
			if(comp_sys !=null && comp_sys.equals("Y"))
			{
				modifiedById				= addedById ;
				addedFacilityId				= facilityId;
				modifiedFacilityId	        = addedFacilityId ;
				addedAtWorkstation	        = client_ip_address;
				modifiedAtWorkstation       = addedAtWorkstation ;

				if(nationality_code == null) nationality_code = "";
				if(name_loc_lang_yn == null) name_loc_lang_yn = "";
				if(first_name == null) first_name = "";
				if(second_name == null) second_name	= "";
				if(third_name == null) third_name = "";
				if(family_name == null) family_name = "";
				if(names_sndx_type == null)	names_sndx_type = "N";
				if(sex == null) sex	= "";
				if(day_of_birth == null) day_of_birth = "";
				if(month_of_birth == null) month_of_birth = "";
				if(year_of_birth == null) year_of_birth = "";
				if(res_area_code == null) res_area_code = "";
				if(contact1_no == null) contact1_no = "";
				if(contact2_no == null)	contact2_no = "";
				if(search_type == null)	search_type = "";
				if(short_desc11 == null) short_desc11 = "";
				if(short_desc22 == null) short_desc22 = "";
				if(short_desc33 == null) short_desc33 = "";
				if(short_desc44 == null) short_desc44 = "";

				if(!nationality_code.equals("Y")) nationality_code = "N";
				if(!name_loc_lang_yn.equals("Y")) name_loc_lang_yn = "N";
				if(!first_name.equals("Y")) first_name = "N";
				if(!second_name.equals("Y")) second_name = "N";
				if(!third_name.equals("Y"))	third_name = "N";
				if(!family_name.equals("Y")) family_name = "N";
								
				if(!sex.equals("Y")) sex = "N";
				if(!day_of_birth.equals("Y")) day_of_birth = "N";
				if(!month_of_birth.equals("Y")) month_of_birth = "N";
				if(!year_of_birth.equals("Y")) year_of_birth = "N";
				if(!res_area_code.equals("Y")) res_area_code = "N";
				if(!contact1_no.equals("Y")) contact1_no = "N";
				if(!contact2_no.equals("Y")) contact2_no = "N";

				proc_status_chk = "";

				str	= "SELECT proc_status FROM dr_process_ctl";
				rs	= stmt.executeQuery(str);
				if(rs != null && rs.next())
				{
					proc_status_chk=rs.getString("proc_status");
				} if(rs!= null) rs.close();

				if( (proc_status_chk == null) || (proc_status_chk.equals("null")) || (proc_status_chk.equals(""))  || (proc_status_chk.equals("S2")) || (proc_status_chk.equals("AB")) || (proc_status_chk.equals("M1")) || (proc_status_chk.equals("M2")) || (proc_status_chk.equals("CS")) )
				{
					mode = "insert";

					if(mode.equals("insert")) insert_dr_def_search_criter(res);
				}
				else
				{
					//String msgage="APP-DR0011 The Cycle is already in progress";
					java.util.Hashtable message = MessageManager.getMessage(locale, "CYCLE_IN_PROGRESS", "DR");
					String error = ((String) message.get("message"));

					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +	java.net.URLEncoder.encode(error,"UTF-8"));
				}
			}
			else
			{
				//String mes_error = "APP-DR0019 Start-Later Date Time should be greater than Current Date Time";
				//String cod = "";
				java.util.Hashtable message = MessageManager.getMessage(locale, "START_LATER_TIME", "DR");
				String error = ((String) message.get("message"));

				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8" ) + "&err_value=0 " );
			}

			if(messageResultset != null) messageResultset.close();
			if(rs != null ) rs.close();
			if(csstmt != null) csstmt.close();
			if(stmt != null) stmt.close();

		}catch(Exception e){
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,req);
		}
	}//do post
	private synchronized void insert_dr_def_search_criter(HttpServletResponse res)
	{
       
		try
		{
			String locale = p.getProperty("LOCALE");
			

			sb	= new StringBuffer("");

			sb.append("Values from sevlet :");

			str = "SELECT DR_PROCESS_CTL_SEQ1.nextval next_proc_id FROM dual ";
			rs  = stmt.executeQuery(str);
			
			while(rs.next())
			{
				proc_id = rs.getString("next_proc_id");
			} if(rs != null) rs.close();

			str = "";
			str	= "SELECT count(*) FROM dr_process_ctl";
			rs	= stmt.executeQuery(str);
			if(rs!= null && rs.next())
			{
				count_ctl = rs.getInt(1);
			} if(rs != null) rs.close();

			if(count_ctl == 1)
			{
				con.setAutoCommit(false);
				str				= "";
			}
			else
			{
				CtlSQL = null;
				CtlSQL	= new StringBuffer();

				CtlSQL.append("INSERT INTO dr_process_ctl ");
				CtlSQL.append("(proc_id,");
				CtlSQL.append("search_submit_date,");
				CtlSQL.append("search_submit_by_id,");
				CtlSQL.append("search_schedule_date,");
				CtlSQL.append("search_start_date,");
				CtlSQL.append("search_end_date,");
				CtlSQL.append("search_status,");
				CtlSQL.append("proc_status,");
				CtlSQL.append("order_by_for_process_cycle,");
				CtlSQL.append("initiating_function_id,");
				CtlSQL.append("search_facility_id,");
				CtlSQL.append("search_type,");
				CtlSQL.append("search_ws_no,");
				CtlSQL.append("added_by_id,");
				CtlSQL.append("added_date,");
				CtlSQL.append("added_at_ws_no,");
				CtlSQL.append("added_facility_id,");
				CtlSQL.append("modified_by_id,");
				CtlSQL.append("modified_date,");
				CtlSQL.append("modified_at_ws_no,");
				CtlSQL.append("modified_facility_id) ");
				CtlSQL.append("values (?,sysdate,?,sysdate,null,null,null,'S0',?,'DR_SEARCH_DUPLICATES',?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
				
				InsertPstmtCtl = con.prepareStatement(CtlSQL.toString());
				
				InsertPstmtCtl.setString(1,proc_id);
				InsertPstmtCtl.setString(2,addedById);
				InsertPstmtCtl.setString(3,order_by_process);
				InsertPstmtCtl.setString(4,addedFacilityId);
				InsertPstmtCtl.setString(5,search_type);
				InsertPstmtCtl.setString(6,addedAtWorkstation);
				InsertPstmtCtl.setString(7,addedById);
				InsertPstmtCtl.setString(8,addedAtWorkstation);
				InsertPstmtCtl.setString(9,addedFacilityId);
				InsertPstmtCtl.setString(10,modifiedById);
				InsertPstmtCtl.setString(11,modifiedAtWorkstation);
				InsertPstmtCtl.setString(12,modifiedFacilityId);

				rsinsertctl = InsertPstmtCtl.executeUpdate();

				if(InsertPstmtCtl != null) InsertPstmtCtl.close();
				if((CtlSQL != null) && (CtlSQL.length() > 0))
				{
					CtlSQL.delete(0,CtlSQL.length());
				}
			}

			String strdelctl = "DELETE dr_process_ctl";
			rsdelete = stmt.executeUpdate(strdelctl);

			if(rsdelete == 1)
			{
				CtlPNLSQL = null;
				CtlPNLSQL = new StringBuffer();
			
				if(process_start.equals("process_now"))
				{
					CtlPNLSQL.append("INSERT INTO dr_process_ctl ");
					CtlPNLSQL.append("(proc_id,");
					CtlPNLSQL.append("search_submit_date,");
					CtlPNLSQL.append("search_submit_by_id,");
					CtlPNLSQL.append("search_schedule_date,");
					CtlPNLSQL.append("search_start_date,");
					CtlPNLSQL.append("search_end_date,");
					CtlPNLSQL.append("search_status,");
					CtlPNLSQL.append("proc_status,");
					CtlPNLSQL.append("order_by_for_process_cycle,");
					CtlPNLSQL.append("initiating_function_id,");
					CtlPNLSQL.append("search_facility_id,");
					CtlPNLSQL.append("search_type,");
					CtlPNLSQL.append("search_ws_no,");
					CtlPNLSQL.append("added_by_id,");
					CtlPNLSQL.append("added_date,");
					CtlPNLSQL.append("added_at_ws_no,");
					CtlPNLSQL.append("added_facility_id,");
					CtlPNLSQL.append("modified_by_id,");
					CtlPNLSQL.append("modified_date,");
					CtlPNLSQL.append("modified_at_ws_no,");
					CtlPNLSQL.append("modified_facility_id) ");
					CtlPNLSQL.append("values (?,sysdate,?,sysdate,null,null,null,'S0',?,'DR_SEARCH_DUPLICATES',?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
					
					InsertPstmtCtlPNL = con.prepareStatement(CtlPNLSQL.toString());
					
					InsertPstmtCtlPNL.setString(1,proc_id);
					InsertPstmtCtlPNL.setString(2,addedById);
					InsertPstmtCtlPNL.setString(3,order_by_process);
					InsertPstmtCtlPNL.setString(4,addedFacilityId);
					InsertPstmtCtlPNL.setString(5,search_type);
					InsertPstmtCtlPNL.setString(6,addedAtWorkstation);
					InsertPstmtCtlPNL.setString(7,addedById);
					InsertPstmtCtlPNL.setString(8,addedAtWorkstation);
					InsertPstmtCtlPNL.setString(9,addedFacilityId);
					InsertPstmtCtlPNL.setString(10,modifiedById);
					InsertPstmtCtlPNL.setString(11,modifiedAtWorkstation);
					InsertPstmtCtlPNL.setString(12,modifiedFacilityId);
				}
				else if(process_start.equals("process_later"))
				{
				
					CtlPNLSQL.append("INSERT INTO dr_process_ctl ");
					CtlPNLSQL.append("(proc_id,");
					CtlPNLSQL.append("search_submit_date,");
					CtlPNLSQL.append("search_submit_by_id,");
					CtlPNLSQL.append("search_schedule_date,");
					CtlPNLSQL.append("search_start_date,");
					CtlPNLSQL.append("search_end_date,");
					CtlPNLSQL.append("search_status,");
					CtlPNLSQL.append("proc_status,");
					CtlPNLSQL.append("order_by_for_process_cycle,");
					CtlPNLSQL.append("initiating_function_id,");
					CtlPNLSQL.append("search_facility_id,");
					CtlPNLSQL.append("search_type,");
					CtlPNLSQL.append("search_ws_no,");
					CtlPNLSQL.append("added_by_id,");
					CtlPNLSQL.append("added_date,");
					CtlPNLSQL.append("added_at_ws_no,");
					CtlPNLSQL.append("added_facility_id,");
					CtlPNLSQL.append("modified_by_id,");
					CtlPNLSQL.append("modified_date,");
					CtlPNLSQL.append("modified_at_ws_no,");
					CtlPNLSQL.append("modified_facility_id) ");
					CtlPNLSQL.append(" values (?,sysdate,?,to_date(?,'dd/mm/yyyy hh24:mi'),null,null,null,'S0',?,'DR_SEARCH_DUPLICATES',?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
					
					InsertPstmtCtlPNL = con.prepareStatement(CtlPNLSQL.toString());	
				
					InsertPstmtCtlPNL.setString(1,proc_id);
					InsertPstmtCtlPNL.setString(2,addedById);
					InsertPstmtCtlPNL.setString(3,process_start_time);
					InsertPstmtCtlPNL.setString(4,order_by_process);
					InsertPstmtCtlPNL.setString(5,addedFacilityId);
					InsertPstmtCtlPNL.setString(6,search_type);
					InsertPstmtCtlPNL.setString(7,addedAtWorkstation);
					InsertPstmtCtlPNL.setString(8,addedById);
					InsertPstmtCtlPNL.setString(9,addedAtWorkstation);
					InsertPstmtCtlPNL.setString(10,addedFacilityId);
					InsertPstmtCtlPNL.setString(11,modifiedById);
					InsertPstmtCtlPNL.setString(12,modifiedAtWorkstation);
					InsertPstmtCtlPNL.setString(13,modifiedFacilityId);
				}
			
				rsinsertctl	= InsertPstmtCtlPNL.executeUpdate();
			
				if(InsertPstmtCtlPNL != null) InsertPstmtCtlPNL.close();
				if((CtlPNLSQL != null) && (CtlPNLSQL.length() > 0))
				{
					CtlPNLSQL.delete(0,CtlPNLSQL.length());
				}
			}
			if(rsinsertctl > 0)
			{
				DrSrCrSQL = null;
				DrSrCrSQL = new StringBuffer();

				String strdelsearch	= "delete dr_search_criteria";

				stmt.executeUpdate(strdelsearch);
				
				DrSrCrSQL.append("INSERT INTO dr_search_criteria ");
				DrSrCrSQL.append("(facility_id,");
				DrSrCrSQL.append("nationality_code_yn,");
				DrSrCrSQL.append("name_loc_lang_yn,");
				DrSrCrSQL.append("first_name_yn,");
				DrSrCrSQL.append("second_name_yn,");
				DrSrCrSQL.append("third_name_yn,");
				DrSrCrSQL.append("family_name_yn,");
				DrSrCrSQL.append("names_sndx_type,");
				DrSrCrSQL.append("sex_yn,");
				DrSrCrSQL.append("day_of_birth_yn,");
				DrSrCrSQL.append("month_of_birth_yn,");
				DrSrCrSQL.append("year_of_birth_yn,");
				DrSrCrSQL.append("res_area_code_yn,");
				DrSrCrSQL.append("contact1_no_yn,");
				DrSrCrSQL.append("contact2_no_yn,");
				DrSrCrSQL.append("search_type,");
				DrSrCrSQL.append("added_by_id,");
				DrSrCrSQL.append("added_date,");
				DrSrCrSQL.append("added_at_ws_no,");
				DrSrCrSQL.append("added_facility_id,");
				DrSrCrSQL.append("modified_by_id,");
				DrSrCrSQL.append("modified_date,");
				DrSrCrSQL.append("modified_at_ws_no,");
				DrSrCrSQL.append("modified_facility_id,");
				DrSrCrSQL.append("ALT_ID1_NO_YN,");
				DrSrCrSQL.append("ALT_ID2_NO_YN,");
				DrSrCrSQL.append("ALT_ID3_NO_YN,");
				DrSrCrSQL.append("other_alt_id_type,");
				DrSrCrSQL.append("ALT_ID4_NO_YN) ");
				DrSrCrSQL.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?)");
				
				InsertPstmtDrSrCr = con.prepareStatement(DrSrCrSQL.toString());
				
				InsertPstmtDrSrCr.setString(1,facilityId);
				InsertPstmtDrSrCr.setString(2,nationality_code);
				InsertPstmtDrSrCr.setString(3,name_loc_lang_yn);
				InsertPstmtDrSrCr.setString(4,first_name);
				InsertPstmtDrSrCr.setString(5,second_name);
				InsertPstmtDrSrCr.setString(6,third_name);
				InsertPstmtDrSrCr.setString(7,family_name);
				InsertPstmtDrSrCr.setString(8,names_sndx_type);
				InsertPstmtDrSrCr.setString(9,sex);
				InsertPstmtDrSrCr.setString(10,day_of_birth);
				InsertPstmtDrSrCr.setString(11,month_of_birth);
				InsertPstmtDrSrCr.setString(12,year_of_birth);
				InsertPstmtDrSrCr.setString(13,res_area_code);
				InsertPstmtDrSrCr.setString(14,contact1_no);
				InsertPstmtDrSrCr.setString(15,contact2_no);
				InsertPstmtDrSrCr.setString(16,search_type);
				InsertPstmtDrSrCr.setString(17,addedById);
				InsertPstmtDrSrCr.setString(18,addedAtWorkstation);
				InsertPstmtDrSrCr.setString(19,addedFacilityId);
				InsertPstmtDrSrCr.setString(20,modifiedById);
				InsertPstmtDrSrCr.setString(21,modifiedAtWorkstation);
				InsertPstmtDrSrCr.setString(22,modifiedFacilityId);
				InsertPstmtDrSrCr.setString(23,short_desc11);
				InsertPstmtDrSrCr.setString(24,short_desc22);
				InsertPstmtDrSrCr.setString(25,short_desc33);
				InsertPstmtDrSrCr.setString(26,other_alt_id_type);
				InsertPstmtDrSrCr.setString(27,short_desc44);
				
				rsinsertft=InsertPstmtDrSrCr.executeUpdate();
				
				if(InsertPstmtDrSrCr != null) InsertPstmtDrSrCr.close();
				if((DrSrCrSQL != null) && (DrSrCrSQL.length() > 0));
				{
					DrSrCrSQL.delete(0,DrSrCrSQL.length());
				}
			}

			if(rsinsertctl>0 && rsinsertft > 0)
			{
				proc_one = "SELECT Check_For_Dr_Jobs_In_Job_Queue() FROM dual";
				rs = stmt.executeQuery(proc_one);
				if(rs.next())
				{
					job_queue = rs.getString(1);
				} if(rs != null) rs.close();

				String what = "drbfinddup;";

				if(job_queue != null && !(job_queue.equals("Y")))
				{
					if(process_start.equals("process_now"))
					{
						csstmt = con.prepareCall("{call DBMS_JOB.SUBMIT(?,?)}");
						csstmt.registerOutParameter(1,Types.NUMERIC);
						csstmt.setString( 2, what);
						csstmt.execute();
						con.commit();
						

						if(csstmt != null) csstmt.close();
					}
					else if(process_start.equals("process_later"))
					{
						csstmt = con.prepareCall("{call DBMS_JOB.SUBMIT(?,?,to_date('"+process_start_time+"','dd/mm/yyyy hh24:mi'))}");
						csstmt.registerOutParameter(1, Types.NUMERIC);
						csstmt.setString( 2, what);
						csstmt.execute();
						con.commit();
						if(csstmt != null) csstmt.close();
					}
					/* Moved here by Nanda on 28/04/2002 */
				
				/*	String message   = "";
					String msg		 = "SELECT GET_ERROR_MESSAGE('SEARCH_PROCESS_JOB') FROM dual";
					messageResultset = stmt.executeQuery(msg);
					if(messageResultset != null)
					{
						if(messageResultset.next())
						{
							message = messageResultset.getString(1);
						}
					} if(messageResultset != null) messageResultset.close();  */

					java.util.Hashtable message = MessageManager.getMessage(locale, "SEARCH_PROCESS_JOB", "DR");
					String error = ((String) message.get("message"));

					out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link></head><body class='message'>") ;
					out.println("<script>alert('"+error+"');</script>");
					out.println("<script> parent.location.href='../eCommon/jsp/dmenu.jsp';</script>");
					out.println("<script> location.href='../eCommon/jsp/error.jsp?err_num=&err_value=1';</script>");
					out.println("</body></html>");
				}
				else
				{
				/*	String mess = "";
					String msg1 = "SELECT GET_ERROR_MESSAGE('SEARCH_MERGE_JOB_EXISTS') FROM dual";
					messageResultset = stmt.executeQuery(msg1);
					if(messageResultset != null)
					{
						if(messageResultset.next())
						{
							mess = messageResultset.getString(1);
						}
					}
					if(messageResultset != null) messageResultset.close();  */

					java.util.Hashtable message = MessageManager.getMessage(locale, "SEARCH_MERGE_JOB_EXISTS", "DR");
					String error = ((String) message.get("message"));

					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8" ) + "&err_value=0 " );
				}
			}
			else
			{
				con.rollback();
		//		String msg = sb.toString();
		//		res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("Transaction Failed "+msg) + "&err_value=0 " );
			}

			if(rs != null ) rs.close();
			if(InsertPstmtCtlPNL != null) InsertPstmtCtlPNL.close();
			if(messageResultset!= null) messageResultset.close();
			if(csstmt != null) csstmt.close();
		}//try
		catch(Exception e)
		{
			try
			{
				con.rollback();
			}
			catch(Exception de) {out.println("Exception while Rollback :"+de.toString());}
			
			out.println("Values sent are : <br>");
			out.println("Error message"+sb.toString());
			out.println("<h3>Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
	}//method
}//class
