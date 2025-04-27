/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;
import java.net.*;
import java.text.*;

public class UpdateUnknownDetailsServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	HttpSession session;
	String client_ip_address			= "";
	String s = "";
	Connection con						= null;
	PreparedStatement pstmt				= null;
	 PreparedStatement preparedstatement=null;
	Statement stmt						= null;
	ResultSet messageResultset          = null;
	ResultSet rs						= null;

	String facilityId					= "";
	String addedById					= "";
	String modifiedById					= "";
	String addedFacilityId				= "";
	String modifiedFacilityId			= "";
	String addedAtWorkstation			= "";
	String modifiedAtWorkstation		= "";
	String p_patient_id					= "";
	String p_id_patient_no				= "";
	String message						= "";
	String code							= "";
	//String job_queue					= "";
	String proc_id						= "";
	String group_id						= "";
	String national_id_no				= "";
	String alt_id1_no					= "";
	String alt_id2_no					= "";
	String alt_id3_no					= "";
	String alt_id4_no					= "";
	String oth_alt_id_no				= "";
	String oth_alt_id_type				= "";
	String pat_dtls_unknown_yn			= "";
	String NewPatDltsIDName				= "";
	StringBuffer MySqlBuff				= null;
	StringBuffer MySqlBuff1				= null;
	StringBuffer MySqlBuff2             = null;
	StringBuffer MySqlBuff3			    = null;
	StringBuffer MySqlBuff4             = null;
	StringBuffer sqlDrProc				= null;
	StringBuffer sqlDrGrp				= null;
	StringBuffer SqlDelBuff2			= null;
	StringBuffer SqlDelBuff1			= null;
	StringBuffer SqlDelBuff				= null;
	StringBuffer sqlMP					= null;
	StringBuffer sqlChFile				= null;
	StringBuffer sqlMP1					= null;
	StringBuffer sqlDR					= null;
	StringBuffer sqlDR1					= null;
	boolean proceed=false;
	String p_first_name				      = "";
	String p_second_name			      = "";
	String p_third_name				      = "";
	String p_family_name			      = "";
	String p_patient_name			      = "";
	String p_sex						  = "";
	String p_date_of_birth				  = "";
	String p_pat_ser_grp_code			  = "";
	String p_nationality_code			  = "";
	String p_res_area_code				  = "";
	String p_contact1_no				  = "";
	String p_contact2_no				  = "";
	String p_regn_facility_id			  = "";
	String p_mp_patient_added_date		  = "";
	String p_remarks					  = "";
	String p_file_location				  = "";
	String p_file_facility_id			  = "";
	String p_file_mr_section_code		  = "";
	String p_file_no					  = "";
	String p_check_single_multi_file	  = "";
	String name							  = "";
	String ProceedValue					  = "";
	StringBuffer sb						= new StringBuffer("");
	String sStyle="";
	String locale="";

	public void init(ServletConfig config) throws ServletException
	{
			super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{

		session					= req.getSession(false);
		this.facilityId			= (String) session.getValue("facility_id" );
		this.p					= (java.util.Properties) session.getValue( "jdbc" );
		this.client_ip_address	= p.getProperty("client_ip_address");
		locale=p.getProperty("LOCALE");
		 sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		try
		{
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			this.out					= res.getWriter();
			p_patient_id				= checkForNull(req.getParameter("patient_id"));
			p_id_patient_no				= checkForNull(req.getParameter("p_id_patient_id"));
			NewPatDltsIDName			= checkForNull(req.getParameter("NewPatDltsIDName"));
			addedById					= p.getProperty("login_user");
			modifiedById				= addedById;
			addedFacilityId				= facilityId;
			modifiedFacilityId	        = addedFacilityId;
			addedAtWorkstation	        = client_ip_address;
			modifiedAtWorkstation       = addedAtWorkstation;
			insertChangeIDSeriesServlet(req, res);
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();

		}
	}//do post
	private synchronized void insertChangeIDSeriesServlet(HttpServletRequest req, HttpServletResponse res)
	{	try
		{	con = ConnectionManager.getConnection(req);
			int count		  = 0;
			MySqlBuff = new StringBuffer();
			String s31 = req.getParameter("process_start");
            MySqlBuff.append("SELECT count(*) count FROM mp_patient ");
            MySqlBuff.append("  WHERE patient_id = ? ");
			pstmt = con.prepareStatement(MySqlBuff.toString());
			pstmt.setString ( 1, p_id_patient_no ) ;
            rs=pstmt.executeQuery();
			if(rs != null && rs.next())
			{count = rs.getInt("count");
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(count == 0)
			{ ProceedValue = "No";
			  MessageManager mm=new MessageManager();
			  java.util.Hashtable mesg=mm.getMessage(locale, "INVALID_PATIENT", "MP") ;
			  String msg=((String) mesg.get("message"));
			  out.println("<SCRIPT>var msg = '"+msg+"';parent.frames[1].document.getElementById('NewPatDltsID').innerHTML = '';parent.frames[1].document.forms[0].NewPatDltsIDName.value = '';parent.frames[1].document.forms[0].p_id_patient_id.select();parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num='+msg;</SCRIPT>");
			  mesg.clear();
			}
			else
			{ ProceedValue = "Yes";
			}

			if(ProceedValue.equals("Yes"))
			{    MySqlBuff1 = new StringBuffer();
                 MySqlBuff1.append("SELECT pat_dtls_unknown_yn FROM mp_patient ");
                 MySqlBuff1.append("  WHERE patient_id = ? ");
			     pstmt = con.prepareStatement(MySqlBuff1.toString());
		         pstmt.setString ( 1, p_id_patient_no ) ;
                 rs=pstmt.executeQuery();
			     if(rs != null && rs.next())
			      {  pat_dtls_unknown_yn = rs.getString("pat_dtls_unknown_yn");
			      }
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if((pat_dtls_unknown_yn.equals("Y")) || (p_patient_id.equals(p_id_patient_no)) || (count == 0))
       		{   	ProceedValue = "No";
               MessageManager mm=new MessageManager();
			  java.util.Hashtable mesg=mm.getMessage(locale, "NOT_KNOWN_PATIENT", "AE") ;
			  String msg=((String) mesg.get("message"));
			 out.println("<SCRIPT>var msg = '"+msg+"';parent.frames[1].document.getElementById('NewPatDltsID').innerHTML = '';parent.frames[1].document.forms[0].NewPatDltsIDName.value = '';parent.frames[1].document.forms[0].p_id_patient_id.select();parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num='+msg;</SCRIPT>");
			 mesg.clear();
			}else
			 {	ProceedValue = "Yes";
			 }

			if(ProceedValue.equals("Yes"))
			 { if(NewPatDltsIDName.equals(""))
			   {
			 	MySqlBuff2 = new StringBuffer();
				MySqlBuff2.append("SELECT GET_PATIENT_LINE(?,?) name FROM dual");
				pstmt = con.prepareStatement(MySqlBuff2.toString());
				pstmt.setString ( 1, p_id_patient_no ) ;
				pstmt.setString ( 2, locale ) ;
				rs=pstmt.executeQuery();
				if(rs != null && rs.next())
   				{name	= rs.getString("name");
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				int ind = name.lastIndexOf(',');
				name    = name.substring(0,ind);
				out.println("<SCRIPT>parent.frames[1].document.getElementById('NewPatDltsID').innerHTML = '<%=name%>';</SCRIPT>");
			  }

				con.setAutoCommit(false);
                proceed=drdupgroup3();
				if(proceed)
				{	try
						{
						  proceed=drdupgroup();
				     if(proceed)
					  {
                         sqlMP = new StringBuffer();
					     sqlMP.append("SELECT a.patient_id,first_name,second_name,third_name,family_name,patient_name,sex,to_char(date_of_birth,'dd/mm/rrrr hh24:mi:ss') date_of_birth ,pat_ser_grp_code,national_id_no,nationality_code,res_area_code,contact1_no,contact2_no,regn_facility_id,to_char(a.added_date,'dd/mm/rrrr')patient_added_date,Substr(a.Patient_Id,5,1)||Substr(a.Patient_Id,7,2) file_location,b.facility_id,mr_section_code,file_no,alt_id1_no,alt_id2_no,alt_id3_no,alt_id4_no,oth_alt_id_no,oth_alt_id_type  FROM mp_patient a,mr_pat_file_index b WHERE a.patient_id=b.patient_id(+) AND a.patient_id =? AND rownum<=1");
					     pstmt				=	con.prepareStatement(sqlMP.toString());
						 pstmt.setString	(	1,	p_patient_id);
						 rs        = pstmt.executeQuery();
						 while(rs.next())
						 {	  			p_first_name			= checkForNull(rs.getString("first_name"));
										p_second_name			= checkForNull(rs.getString("second_name"));
										p_third_name			= checkForNull(rs.getString("third_name"));
										p_family_name			= checkForNull(rs.getString("family_name"));
										p_patient_name			= checkForNull(rs.getString("patient_name"));
										p_sex					= checkForNull(rs.getString("sex"));
										p_date_of_birth			= checkForNull(rs.getString("date_of_birth"));
										p_pat_ser_grp_code		= checkForNull(rs.getString("pat_ser_grp_code")) ;
										p_nationality_code		= checkForNull(rs.getString("nationality_code")) ;
										p_res_area_code			= checkForNull(rs.getString("res_area_code"));
										p_contact1_no			= checkForNull(rs.getString("contact1_no"));
										p_contact2_no			= checkForNull(rs.getString("contact2_no"));
										p_regn_facility_id		= checkForNull(rs.getString("regn_facility_id")) ;
										p_mp_patient_added_date = checkForNull(rs.getString("patient_added_date"));
										p_file_location			= checkForNull(rs.getString("file_location"));
										p_file_facility_id		= checkForNull(rs.getString("facility_id"));
										p_file_mr_section_code	= checkForNull(rs.getString("mr_section_code"));
										national_id_no				= checkForNull(rs.getString("national_id_no"));
										p_file_no				= checkForNull(rs.getString("file_no"));
										alt_id1_no				= checkForNull(rs.getString("alt_id1_no"));
										alt_id2_no				= checkForNull(rs.getString("alt_id2_no"));
										alt_id3_no				= checkForNull(rs.getString("alt_id3_no"));
										alt_id4_no				= checkForNull(rs.getString("alt_id4_no")) ;
										oth_alt_id_no			= checkForNull(rs.getString("oth_alt_id_no"));
										oth_alt_id_type			= checkForNull(rs.getString("oth_alt_id_type"));
									}if(rs != null) rs.close();
                                    if(pstmt!=null) pstmt.close();
									if((sqlMP != null) && (sqlMP.length() > 0))
									{	sqlMP.delete(0,sqlMP.length());
									}
                                    sqlChFile = new StringBuffer();
									sqlChFile.append("select  Check_Single_File_For_Patient ");
									sqlChFile.append("check_single_multi_file from dual ");
									pstmt				=	con.prepareStatement(sqlChFile.toString());
									rs        = pstmt.executeQuery();
									while(rs.next())
									{	p_check_single_multi_file = rs.getString("check_single_multi_file");
									}if(rs != null) rs.close();
                                     if(pstmt!=null) pstmt.close();
									 if((sqlChFile != null) && (sqlChFile.length() > 0))
									 {sqlChFile.delete(0,sqlChFile.length());
									 }
								}	proceed=checksinglemultifile();
									if(proceed)
							        {
									proceed=drdupgroupdtls1();
									}
								}
						catch (Exception epatexp)
						{
							epatexp.printStackTrace();
							message = epatexp.getMessage()+" "+p_id_patient_no;
							//out.println("message-->'"+message);
							res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("APP-00000"+code+" "+message+"","UTF-8" ) + "&err_value=0 " );
						}
				 }

				 if(proceed)
						{	if(s31.equals("process_now"))
                            insert_dr_merge_start_now(res);
                        else{
                             String s3 = req.getParameter("start_later_time");
                             if(!s3.equals(""))
                             insert_dr_merge_start_later(req, res);
						}
                    } else
                    {  con.rollback();
                      }
					}
			}}//try
		catch(Exception e)
		{
			/* out.println("e");
			out.println("<h3> Exception raise by Servlet ...So Record Not modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println(sb.toString()); */
			e.printStackTrace();

		}finally
		{ConnectionManager.returnConnection(con,req);
		}
	}//method

	public synchronized void insert_dr_merge_start_now(HttpServletResponse httpservletresponse)
    {
        int i = 0;
         s = "";
        String s1 = "";
        //boolean flag = false;
       // Object obj = null;
        String s2 = "";

        try
        {
            String s3 = "select count(*) total from dr_job_control where status='R'";
            if(stmt!=null) stmt.close();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(s3);
            if(rs != null)
            {
                while(rs.next())
                    i = rs.getInt(1);

            }if(rs != null)
                    rs.close();
            if(i > 0)
            {
                con.rollback();
				MessageManager mm=new MessageManager();
				final java.util.Hashtable mesg=mm.getMessage(locale, "JOB_ALREADY_IN_QUEUE", "SM") ;
				message=((String) mesg.get("message"));
				httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode("" + message + "","UTF-8") + "&err_value=0 ");
				mesg.clear();
            }
			else
            {
                String s5 = "select count(*) from dr_job_control where to_date(to_char(scheduled_date,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') = to_date(to_char(sysdate,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi')";

				rs = stmt.executeQuery(s5);
                int k=0;
                if(rs.next())
                {
				   k = rs.getInt(1);
				}
				 if(rs!=null) rs.close();

                if(k > 0)
                {
                    con.rollback();
					MessageManager mm=new MessageManager();
					final java.util.Hashtable mesg=mm.getMessage(locale, "JOB_ALREADY_IN_QUEUE", "SM") ;
					message=((String) mesg.get("message"));
					httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode("" + message + "","UTF-8") + "&err_value=0 ");
					mesg.clear();
                }
				else
                {
                    String s7 = "select to_char(sysdate,'dd/mm/yyyy hh24:mi') from dual";
                    rs = stmt.executeQuery(s7);
                    if(rs != null)
                    {
                        while(rs.next())
                            s = rs.getString(1);

                    }
					if(rs != null)
                            rs.close();
                    String s8 = "select DR_JOB_CONTROL_SEQ.nextval from dual";
                    rs = stmt.executeQuery(s8);
                    if(rs != null)
                    {
                        while(rs.next())
                            s1 = rs.getString(1);

                    }
					if(rs != null)
                            rs.close();
                    String s9 = "";
                    s9 = "insert into DR_JOB_CONTROL values(" + s1 + ",sysdate,to_date('" + s + "','dd/mm/rrrr hh24:mi'),null,null,'" + s2 + "','" + addedById + "',sysdate,'" + addedAtWorkstation + "','" + addedFacilityId + "','" + modifiedById + "',sysdate,'" + modifiedAtWorkstation + "','" + modifiedFacilityId + "')";

                    int l = stmt.executeUpdate(s9);
                    if(l > 0)
                    {
                        String s10 = "";
                        s10 = "update DR_DUP_GROUP_HDR set MODIFIED_BY_ID='" + modifiedById + "',MODIFIED_DATE = SYSDATE ,MODIFIED_FACILITY_ID =  '" + modifiedFacilityId + "', MODIFIED_AT_WS_NO='" + modifiedAtWorkstation + "', marked_for_merge_yn='Y', job_ctrl_no=" + s1 + " where dup_group_id=" + group_id;

                         preparedstatement = con.prepareStatement(s10);
                        int j = preparedstatement.executeUpdate();
                        if(j > 0)
                        {
                            con.commit();
							MessageManager mm=new MessageManager();
					        final java.util.Hashtable mesg=mm.getMessage(locale, "PROCESS_SUBMITTED", "AE") ;
					        String msg=((String) mesg.get("message"));
							mesg.clear();
                            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link></head><body class='message'>");
                            out.println("<script>alert('" + msg + "');</script>");
                            out.println("<script> parent.location.href='../eCommon/jsp/dmenu.jsp';</script>");
                            out.println("<script> location.href='../eCommon/jsp/error.jsp?err_num=&err_value=1';</script>");
                            out.println("</body></html>");
                        } else
                        {
                            con.rollback();
                            out.println("Excepiton occured in Servlet");
                        }
                    } else
                    {
                        con.rollback();
                        out.println("Excepiton occured in Servlet");
                    }
                }
            }
       if(preparedstatement!=null)preparedstatement.close();}
        catch(Exception exception)
        {
			exception.printStackTrace();

			try
            {
                con.rollback();
            }
            catch(Exception exception1) {
				exception1.printStackTrace();
}
            //out.println("Exception occured in ChangeIDSeriesServlet" + exception.toString());
        }
    }

	public boolean drdupgroupdtls1()
	{
	try
	{
				sqlMP1 = new StringBuffer();
				sqlMP1.append("SELECT a.patient_id,first_name,second_name,third_name,family_name,patient_name,sex,to_char(date_of_birth,'dd/mm/rrrr hh24:mi:ss') date_of_birth ,pat_ser_grp_code,national_id_no,nationality_code,res_area_code,contact1_no,contact2_no,regn_facility_id,to_char(a.added_date,'dd/mm/rrrr')patient_added_date,Substr(a.Patient_Id,5,1)||Substr(a.Patient_Id,7,2) file_location,b.facility_id,mr_section_code,			file_no,alt_id1_no,alt_id2_no,alt_id3_no,alt_id4_no,oth_alt_id_no,oth_alt_id_type FROM mp_patient a,mr_pat_file_index b  WHERE a.patient_id=b.patient_id(+) AND a.patient_id =? AND rownum<=1 ");
				pstmt				=	con.prepareStatement(sqlMP1.toString());
				pstmt.setString	(	1,	p_patient_id);
     			rs        = pstmt.executeQuery();
				while(rs.next())
		    	{
						p_first_name			= checkForNull(rs.getString("first_name"));
						p_second_name			= checkForNull(rs.getString("second_name"));
						p_third_name			= checkForNull(rs.getString("third_name"));
						p_family_name			= checkForNull(rs.getString("family_name"));
						p_patient_name			= checkForNull(rs.getString("patient_name"));
						p_sex					= checkForNull(rs.getString("sex"));
						p_date_of_birth			= checkForNull(rs.getString("date_of_birth"));
						p_pat_ser_grp_code		= checkForNull(rs.getString("pat_ser_grp_code")) ;
						p_nationality_code		= checkForNull(rs.getString("nationality_code")) ;
						p_res_area_code			= checkForNull(rs.getString("res_area_code"));
						p_contact1_no			= checkForNull(rs.getString("contact1_no"));
						p_contact2_no			= checkForNull(rs.getString("contact2_no"));
						p_regn_facility_id		= checkForNull(rs.getString("regn_facility_id")) ;
						p_mp_patient_added_date = checkForNull(rs.getString("patient_added_date"));
						p_file_location			= checkForNull(rs.getString("file_location"));
						p_file_facility_id		= checkForNull(rs.getString("facility_id"));
						p_file_mr_section_code	= checkForNull(rs.getString("mr_section_code"));
						national_id_no			= checkForNull(rs.getString("national_id_no"));
						p_file_no				= checkForNull(rs.getString("file_no"));
						alt_id1_no				= checkForNull(rs.getString("alt_id1_no"));
						alt_id2_no				= checkForNull(rs.getString("alt_id2_no"));
						alt_id3_no				= checkForNull(rs.getString("alt_id3_no"));
						alt_id4_no				= checkForNull(rs.getString("alt_id4_no")) ;
						oth_alt_id_no			= checkForNull(rs.getString("oth_alt_id_no"));
						oth_alt_id_type			= checkForNull(rs.getString("oth_alt_id_type"));
					}if(rs != null) rs.close();
                     if(pstmt!=null) pstmt.close();
					 if((sqlMP1 != null) && (sqlMP1.length() > 0))
					  {	sqlMP1.delete(0,sqlMP1.length());
					  }
					 if(p_check_single_multi_file.equals("T"))
						{
							sqlDR1 = new StringBuffer();

							sqlDR1.append("insert into DR_DUP_GROUP_DTLS (dup_group_id,patient_id,dup_indicator,			sug_valid_pat_flag,	remarks,first_name,				second_name,third_name,family_name,patient_name,sex,date_of_birth,pat_ser_grp_code,national_id_no,nationality_code,res_area_code,contact1_no,contact2_no,regn_facility_id,mp_patient_added_date,file_location,file_facility_id,file_mr_section_code,file_no,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,alt_id1_no,alt_id2_no,alt_id3_no,alt_id4_no,oth_alt_id_no,oth_alt_id_type,modified_facility_id) values(?,?,'V','Y',?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi:ss'),?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi:ss'),?,?,?,?,?,sysdate,?,?,?, sysdate,?,?,?,?,?,?,?,?) ");
				            if(pstmt!=null) pstmt.close();
							pstmt				=	con.prepareStatement(sqlDR1.toString());
							pstmt.setString	(	1,	group_id);
							pstmt.setString	(	2,	p_id_patient_no);
							pstmt.setString	(	3,	p_remarks);
							pstmt.setString	(	4,	p_first_name);
							pstmt.setString	(	5,	p_second_name);
							pstmt.setString	(	6,	p_third_name);
							pstmt.setString	(	7,	p_family_name);
							pstmt.setString	(	8,	p_patient_name);
							pstmt.setString	(	9,	p_sex);
							pstmt.setString	(	10,	p_date_of_birth);
							pstmt.setString	(	11,	p_pat_ser_grp_code);
							pstmt.setString	(	12,	national_id_no);
							pstmt.setString	(	13,	p_nationality_code);
							pstmt.setString	(	14,	p_res_area_code);
							pstmt.setString	(	15,	p_contact1_no);
							pstmt.setString	(	16,	p_contact2_no);
							pstmt.setString	(	17,	p_regn_facility_id);
							pstmt.setString	(	18,	p_mp_patient_added_date);
							pstmt.setString	(	19,	p_file_location);
							pstmt.setString	(	20,	p_file_facility_id);
							pstmt.setString	(	21,	p_file_mr_section_code);
							pstmt.setString	(	22,	p_file_no);
							pstmt.setString	(	23,	addedById);
							pstmt.setString	(	24,	addedAtWorkstation);
							pstmt.setString	(	25,	addedFacilityId);
							pstmt.setString	(	26,	modifiedById);
							pstmt.setString	(	27,	modifiedAtWorkstation);
							pstmt.setString	(	28,	alt_id1_no);
							pstmt.setString	(	29,	alt_id2_no);
							pstmt.setString	(	30,	alt_id3_no);
							pstmt.setString	(	31,	alt_id4_no);
							pstmt.setString	(	32,	oth_alt_id_no);
							pstmt.setString	(	33,	oth_alt_id_type);
							pstmt.setString	(	34,	modifiedFacilityId);
						}
						else if(p_check_single_multi_file.equals("F"))
	 					{

								sqlDR1 = new StringBuffer();

								sqlDR1.append("insert into dr_dup_group_dtls (dup_group_id,patient_id,dup_indicator,			sug_valid_pat_flag,remarks,first_name,second_name,third_name,family_name,patient_name,sex,date_of_birth,pat_ser_grp_code,national_id_no,nationality_code,	res_area_code,contact1_no,contact2_no,regn_facility_id,mp_patient_added_date,added_by_id,	added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,alt_id1_no,alt_id2_no,alt_id3_no,alt_id4_no,oth_alt_id_no,oth_alt_id_type,modified_facility_id) values(?,?,'V','Y',?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi:ss'),?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi:ss'),?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?) ");
								if(pstmt!=null) pstmt.close();
								pstmt				=	con.prepareStatement(sqlDR1.toString());
								pstmt.setString	(	1,	group_id);
								pstmt.setString	(	2,	p_id_patient_no);
								pstmt.setString	(	3,	p_remarks);
								pstmt.setString	(	4,	p_first_name);
								pstmt.setString	(	5,	p_second_name);
								pstmt.setString	(	6,	p_third_name);
								pstmt.setString	(	7,	p_family_name);
								pstmt.setString	(	8,	p_patient_name);
								pstmt.setString	(	9,	p_sex);
								pstmt.setString	(	10,	p_date_of_birth);
								pstmt.setString	(	11,	p_pat_ser_grp_code);
								pstmt.setString	(	12,	national_id_no);
								pstmt.setString	(	13,	p_nationality_code);
								pstmt.setString	(	14,	p_res_area_code);
								pstmt.setString	(	15,	p_contact1_no);
								pstmt.setString	(	16,	p_contact2_no);
								pstmt.setString	(	17,	p_regn_facility_id);
								pstmt.setString	(	18,	p_mp_patient_added_date);
								pstmt.setString	(	19,	addedById);
								pstmt.setString	(	20,	addedAtWorkstation);
								pstmt.setString	(	21,	addedFacilityId);
								pstmt.setString	(	22,	modifiedById);
								pstmt.setString	(	23,	modifiedAtWorkstation);
								pstmt.setString	(	24,	alt_id1_no);
								pstmt.setString	(	25,	alt_id2_no);
								pstmt.setString	(	26,	alt_id3_no);
								pstmt.setString	(	27,	alt_id4_no);
								pstmt.setString	(	28,	oth_alt_id_no);
								pstmt.setString	(	29,	oth_alt_id_type);
								pstmt.setString	(	30,	modifiedFacilityId);

								}
								pstmt.executeUpdate();
								//rsinsertdtl2	=	pstmt.executeUpdate();
								if(pstmt!=null) pstmt.close();
							    if((sqlDR1 != null) && (sqlDR1.length() > 0))
								{
									sqlDR1.delete(0,sqlDR1.length());
								}

								}
									catch (Exception e6)
									{
										e6.printStackTrace();
										message = p_id_patient_no+" "+e6.toString();
										e6.printStackTrace();
                                       //		res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(""+code+" "+message+"" ) + "&err_value=0 " );
									return false;
									}

	 return true;
	}
    public boolean checksinglemultifile()
	{	try
	      {
		        if(p_check_single_multi_file.equals("T"))
				 {
				sqlDR = new StringBuffer();
				sqlDR.append("insert into dr_dup_group_dtls (dup_group_id,patient_id,dup_indicator,sug_valid_pat_flag,remarks,first_name,second_name,third_name,family_name,patient_name,sex,date_of_birth,pat_ser_grp_code,national_id_no,nationality_code,res_area_code,contact1_no,contact2_no,regn_facility_id,mp_patient_added_date,file_location,file_facility_id,file_mr_section_code,file_no,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,alt_id1_no,alt_id2_no,alt_id3_no,alt_id4_no,oth_alt_id_no,oth_alt_id_type,modified_facility_id)values (?,?,'D','N',?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi:ss'),?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi:ss'),?,?,?,?,?,sysdate,?,?,?, sysdate,?,?,?,?,?,?,?,?)");
				if(pstmt!=null) pstmt.close();
				pstmt				=	con.prepareStatement(sqlDR.toString());
				pstmt.setString	(	1,	group_id);
				pstmt.setString	(	2,	p_patient_id);
				pstmt.setString	(	3,	p_remarks);
				pstmt.setString	(	4,	p_first_name);
				pstmt.setString	(	5,	p_second_name);
				pstmt.setString	(	6,	p_third_name);
				pstmt.setString	(	7,	p_family_name);
				pstmt.setString	(	8,	p_patient_name);
				pstmt.setString	(	9,	p_sex);
				pstmt.setString	(	10,	p_date_of_birth);
				pstmt.setString	(	11,	p_pat_ser_grp_code);
				pstmt.setString	(	12,	national_id_no);
				pstmt.setString	(	13,	p_nationality_code);
				pstmt.setString	(	14,	p_res_area_code);
				pstmt.setString	(	15,	p_contact1_no);
				pstmt.setString	(	16,	p_contact2_no);
				pstmt.setString	(	17,	p_regn_facility_id);
				pstmt.setString	(	18,	p_mp_patient_added_date);
				pstmt.setString	(	19,	p_file_location);
				pstmt.setString	(	20,	p_file_facility_id);
				pstmt.setString	(	21,	p_file_mr_section_code);
				pstmt.setString	(	22,	p_file_no);
				pstmt.setString	(	23,	addedById);
				pstmt.setString	(	24,	addedAtWorkstation);
				pstmt.setString	(	25,	addedFacilityId);
				pstmt.setString	(	26,	modifiedById);
				pstmt.setString	(	27,	modifiedAtWorkstation);
				pstmt.setString	(	28,	alt_id1_no);
				pstmt.setString	(	29,	alt_id2_no);
				pstmt.setString	(	30,	alt_id3_no);
				pstmt.setString	(	31,	alt_id4_no);
				pstmt.setString	(	32,	oth_alt_id_no);
				pstmt.setString	(	33,	oth_alt_id_type);
				pstmt.setString	(	34,	modifiedFacilityId);
				}
				else if(p_check_single_multi_file.equals("F"))
										{
				sqlDR = new StringBuffer();
				sqlDR.append("insert into dr_dup_group_dtls(dup_group_id,patient_id,dup_indicator,sug_valid_pat_flag,remarks,first_name,second_name,third_name,family_name,patient_name,sex,date_of_birth,pat_ser_grp_code,national_id_no,nationality_code,res_area_code,contact1_no,contact2_no,regn_facility_id,mp_patient_added_date,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,alt_id1_no,alt_id2_no,alt_id3_no,alt_id4_no,oth_alt_id_no,oth_alt_id_type,modified_facility_id) values (?,?,'D','N',?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi:ss'),?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi:ss'),?,sysdate,?,?,?, sysdate,?,?,?,?,?,?,?,?) ");
				if(pstmt!=null) pstmt.close();
				pstmt				=	con.prepareStatement(sqlDR.toString());
				pstmt.setString	(	1,	group_id);
				pstmt.setString	(	2,	p_patient_id);
				pstmt.setString	(	3,	p_remarks);
				pstmt.setString	(	4,	p_first_name);
				pstmt.setString	(	5,	p_second_name);
				pstmt.setString	(	6,	p_third_name);
				pstmt.setString	(	7,	p_family_name);
				pstmt.setString	(	8,	p_patient_name);
				pstmt.setString	(	9,	p_sex);
				pstmt.setString	(	10,	p_date_of_birth);
				pstmt.setString	(	11,	p_pat_ser_grp_code);
				pstmt.setString	(	12,	national_id_no);
				pstmt.setString	(	13,	p_nationality_code);
				pstmt.setString	(	14,	p_res_area_code);
				pstmt.setString	(	15,	p_contact1_no);
				pstmt.setString	(	16,	p_contact2_no);
				pstmt.setString	(	17,	p_regn_facility_id);
				pstmt.setString	(	18,	p_mp_patient_added_date);
				pstmt.setString	(	19,	addedById);
				pstmt.setString	(	20,	addedAtWorkstation);
				pstmt.setString	(	21,	addedFacilityId);
				pstmt.setString	(	22,	modifiedById);
				pstmt.setString	(	23,	modifiedAtWorkstation);
				pstmt.setString	(	24,	alt_id1_no);
				pstmt.setString	(	25,	alt_id2_no);
				pstmt.setString	(	26,	alt_id3_no);
				pstmt.setString	(	27,	alt_id4_no);
				pstmt.setString	(	28,	oth_alt_id_no);
				pstmt.setString	(	29,	oth_alt_id_type);
				pstmt.setString	(	30,	modifiedFacilityId);
			}
			 pstmt.executeUpdate();
			if(pstmt!=null) pstmt.close();
			if((sqlDR != null) && (sqlDR.length() > 0))
			 {
			 		sqlDR.delete(0,sqlDR.length());
			 }
			}
			catch(Exception e4)
			{
				//out.println("Exception e4 : " + e4);
				message = e4.toString();
				e4.printStackTrace();
			   return false;
			   //res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(""+code+" "+message+"" ) + "&err_value=0 " );
			}

	return true;
	}

	public boolean drdupgroup3()
	{ try{
	      MySqlBuff3 = new StringBuffer();
		  MySqlBuff3.append("select DR_DUP_GROUP_HDR_SEQ1.nextval next_group_id from dual");
		  pstmt = con.prepareStatement(MySqlBuff3.toString());
		  rs=pstmt.executeQuery();
		  while(rs.next())
		  {	group_id = rs.getString("next_group_id");
		  }
		  if(rs != null) rs.close();
		  if(pstmt != null) pstmt.close();
		  if((MySqlBuff3 != null) && (MySqlBuff3.length() > 0))
		  { MySqlBuff3.delete(0,MySqlBuff3.length());
		  }
		  MySqlBuff4 = new StringBuffer();
		  MySqlBuff4.append("select DR_PROCESS_CTL_SEQ1.nextval next_proc_id from dual ");
		  pstmt = con.prepareStatement(MySqlBuff4.toString());
		  rs=pstmt.executeQuery();
		  while(rs.next())
		  {	proc_id	= rs.getString("next_proc_id");
		  }
		  if(rs != null) rs.close();
		  if(pstmt != null) pstmt.close();
		  if((MySqlBuff4 != null) && (MySqlBuff4.length() > 0))
		 	{
				MySqlBuff4.delete(0,MySqlBuff4.length());
			}
		   SqlDelBuff = new StringBuffer();
		   SqlDelBuff.append(" delete from dr_process_ctl ");
			pstmt				=	con.prepareStatement(SqlDelBuff.toString());
			pstmt.executeUpdate();
			if(pstmt != null) pstmt.close();
			SqlDelBuff1 = new StringBuffer();
			SqlDelBuff1.append("delete from dr_dup_group_dtls ");
			pstmt				=	con.prepareStatement(SqlDelBuff1.toString());
			pstmt.executeUpdate();
			if(pstmt != null) pstmt.close();
			SqlDelBuff2 = new StringBuffer();
			SqlDelBuff2.append("delete from dr_dup_group_dtls ");
			pstmt				=	con.prepareStatement(SqlDelBuff2.toString());
			pstmt.executeUpdate();
			if(pstmt != null) pstmt.close();
			if((SqlDelBuff != null) && (SqlDelBuff.length() > 0))
			 {
				SqlDelBuff.delete(0,SqlDelBuff.length());
			}
			if((SqlDelBuff1 != null) && (SqlDelBuff1.length() > 0))
			{
			 	SqlDelBuff1.delete(0,SqlDelBuff1.length());
			}
			if((SqlDelBuff2 != null) && (SqlDelBuff2.length() > 0))
			{
				SqlDelBuff2.delete(0,SqlDelBuff2.length());
			}
			sqlDrProc = new StringBuffer();

			sqlDrProc.append("insert into DR_PROCESS_CTL (PROC_ID,INITIATING_FUNCTION_ID,PROC_STATUS, ORDER_BY_FOR_PROCESS_CYCLE,MERGE_SUBMIT_DATE,MERGE_SUBMIT_BY_ID,MERGE_SCHEDULE_DATE, ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID, MERGE_FACILITY_ID,MERGE_WS_NO,SEARCH_FACILITY_ID,SEARCH_TYPE,SEARCH_WS_NO) values (?,'DR_SEARCH_DUPLICATES','S0','P',SYSDATE,?,SYSDATE,?,sysdate,?,?,?,sysdate,?,?,?,?,?,'L',?)");
			pstmt				=	con.prepareStatement(sqlDrProc.toString());
			pstmt.setString	(	1,	proc_id		);
			pstmt.setString	(	2,	addedById		);
			pstmt.setString	(	3,	addedById		);
			pstmt.setString	(	4,	addedAtWorkstation		);
			pstmt.setString	(	5,	addedFacilityId		);
			pstmt.setString	(	6,	modifiedById		);
			pstmt.setString	(	7,	modifiedAtWorkstation		);
			pstmt.setString	(	8,	modifiedFacilityId		);
			pstmt.setString	(	9,	addedFacilityId		);
			pstmt.setString	(	10,	addedAtWorkstation	);
			pstmt.setString	(	11,	addedFacilityId		);
			pstmt.setString	(	12,	addedAtWorkstation		);
			pstmt.executeUpdate();
			if(pstmt!=null) pstmt.close();
			if((sqlDrProc != null) && (sqlDrProc.length() > 0))
		     {
				sqlDrProc.delete(0,sqlDrProc.length());
			 }
			}
				catch(Exception e2)
				{
					//out.println("Exception e2 :" + e2);
					e2.printStackTrace();

					message = e2.toString();
				//	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(""+code+" "+message+"" ) + "&err_value=0 " );
				return false;
				}

	return true;

	}
	public boolean drdupgroup()
	{

		try
		{
			sqlDrGrp = new StringBuffer();
			sqlDrGrp.append(" insert into dr_dup_group_hdr ");
			sqlDrGrp.append("(DUP_GROUP_ID,PAT_COUNT,");
			sqlDrGrp.append("GROUP_CREATED_DATE,GROUP_STATUS,");
			sqlDrGrp.append("STATUS_UPD_DATE,SYSTEM_GEN_YN,");
			sqlDrGrp.append("MARKED_FOR_MERGE_YN,ADDED_BY_ID,");
			sqlDrGrp.append("ADDED_DATE,ADDED_AT_WS_NO,");
			sqlDrGrp.append("ADDED_FACILITY_ID, MODIFIED_BY_ID,");
			sqlDrGrp.append("MODIFIED_DATE,MODIFIED_AT_WS_NO,");
			sqlDrGrp.append("MODIFIED_FACILITY_ID) ");
			sqlDrGrp.append("values(?,2,sysdate,'I',");
			sqlDrGrp.append("sysdate,'N','Y',?,sysdate,?,?,?,");
			sqlDrGrp.append("sysdate,?,?) ");

			pstmt				=	con.prepareStatement(sqlDrGrp.toString());
			pstmt.setString	(	1,	group_id		);
			pstmt.setString	(	2,	addedById		);
			pstmt.setString	(	3,	addedAtWorkstation		);
			pstmt.setString	(	4,	addedFacilityId		);
			pstmt.setString	(	5,	modifiedById		);
			pstmt.setString	(	6,	modifiedAtWorkstation		);
			pstmt.setString	(	7,	modifiedFacilityId		);
            pstmt.executeUpdate();
			//rsinserthdr	=	pstmt.executeUpdate();

			if(pstmt!=null) pstmt.close();
			if((sqlDrGrp != null) && (sqlDrGrp.length() > 0))
			{
				sqlDrGrp.delete(0,sqlDrGrp.length());
			}
		}
		catch (Exception e3)
		{
			//out.println("Exception e3 : " + e3);
			e3.printStackTrace();
			message = e3.toString();
		   return false;
		//	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(""+code+" "+message+"" ) + "&err_value=0 " );
		}

      return true;

	}

	public synchronized void insert_dr_merge_start_later(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
         s = "";
        String s1 = "";
        String s2 = "";
        String s3 = httpservletrequest.getParameter("start_later_time");
        try
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            java.util.Date date = simpledateformat.parse(s3);
            String s4 = "select max(to_char(scheduled_date,'dd/mm/yyyy hh24:mi'))maxscdate,to_char(sysdate,'dd/mm/yyyy hh24:mi')sysdate1 from dr_job_control";
            if(stmt!=null) stmt.close();
            if(rs!=null) rs.close();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(s4);
            String s5 = "";
            String s6 = "";
            rs.last();
            //int j = rs.getRow();
            rs.beforeFirst();
            if(rs.next())
            {
                s5 = rs.getString(1);
                s6 = rs.getString(2);
            }


            if(s5 == null)
                s5 = s6;
            java.util.Date date1 = simpledateformat.parse(s5);
            java.util.Date date2 = simpledateformat.parse(s6);
            if(date.before(date2) || date1.after(date) || date.equals(date1))
            {
                MessageManager mm=new MessageManager();
                if(date.before(date2))
                {
                    con.rollback();
					 java.util.Hashtable mesg=mm.getMessage(locale, "START_LATER_TIME", "DR") ;
					String msg=(String)mesg.get("message");
                    message =msg+":" + s6;
                    httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode("" + code + " " + message + "","UTF-8") + "&err_value=0 ");
					mesg.clear();
                } else
                {
                    con.rollback();
                    java.util.Hashtable mesg=mm.getMessage(locale, "START_DT_LE_CURR_DT", "AE") ;
					String msg=(String)mesg.get("message");
                    httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode("" + code + " " + msg + "","UTF-8") + "&err_value=0 ");
                    mesg.clear();
				}
            } else
            {
                String s7 = "select DR_JOB_CONTROL_SEQ.nextval from dual";
                rs = stmt.executeQuery(s7);
                if(rs != null)
                {
                    while(rs.next())
                        s1 = rs.getString(1);
                    if(rs != null)
                        rs.close();
                }
                String sqlinsert = "insert into dr_job_control values(" + s1 + ",sysdate,to_date('" + s3 + "','dd/mm/rrrr hh24:mi'),null,null,'" + s2 + "','" + addedById + "',sysdate,'" + addedAtWorkstation + "','" + addedFacilityId + "','" + modifiedById + "',sysdate,'" + modifiedAtWorkstation + "','" + modifiedFacilityId + "')";

                int k = stmt.executeUpdate(sqlinsert);


                if(k > 0)
                {
                    sqlinsert = "";
                   // sqlinsert = "update dr_dup_group_hdr set marked_for_merge_yn='Y', job_ctrl_no=" + s1 + " where dup_group_id=" + group_id;
					sqlinsert = "update dr_dup_group_hdr set MODIFIED_BY_ID='" + modifiedById + "',MODIFIED_DATE = SYSDATE ,MODIFIED_FACILITY_ID =  '" + modifiedFacilityId + "', MODIFIED_AT_WS_NO='" + modifiedAtWorkstation + "', marked_for_merge_yn='Y', job_ctrl_no=" + s1 + " where dup_group_id=" + group_id;
                     preparedstatement = con.prepareStatement(sqlinsert);
                    int i = preparedstatement.executeUpdate();
                    if(i > 0)
                    {
                       con.commit();
					   MessageManager mm=new MessageManager();
					   final java.util.Hashtable mesg=mm.getMessage(locale, "PROCESS_SUBMITTED", "AE") ;
					   String msg=((String) mesg.get("message"));
					   mesg.clear();
                        out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link></head><body class='message'>");
                        out.println("<script>alert('" + msg + "');</script>");
                        out.println("<script> parent.location.href='../eCommon/jsp/dmenu.jsp';</script>");
                        out.println("<script> location.href='../eCommon/jsp/error.jsp?err_num=&err_value=1';</script>");
                        out.println("</body></html>");
                    } else
                    {
                        con.rollback();
                        out.println("Excepiton occured in Servlet");
                    }
                } else
                {
                    con.rollback();
                    out.println("Excepiton occured in Servlet");
                }
            }
        if(preparedstatement!=null)preparedstatement.close();
		 if(stmt != null)
                        stmt.close();
		 if(rs != null)
                        rs.close();}
        catch(Exception exception)
        {
			exception.printStackTrace();
			try
            {
                con.rollback();
            }
            catch(Exception exception1) {
				exception1.printStackTrace();
			}
           // out.println("Exception occured in MergeDuplicateServlet" + exception.toString());
        }
    }
	public static String checkForNull(String InputString)
	{
		return(((InputString == null)  || (InputString.equals("null"))) ? "" : InputString);
	}
}//class
