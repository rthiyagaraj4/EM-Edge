/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import javax.rmi.*;
import javax.naming.*;
import javax.ejb.*;
import webbeans.eCommon.*;

public class FMIPConfirmPullingListServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	String facility_id="",p_fm_nursing_unit_code="",p_to_nursing_unit_code="",p_fm_pract_id="",p_to_pract_id="",p_gender="",p_preferred_date="",user_id="",print_pulled_list="",print_tracer_card="",p_appt_time="",p_fs_locn_code="";
	String print_only_report="",appl_user_id="";
	String p_pull_list_no = "";
	String locale			= "" ;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,java.io.IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		java.io.PrintWriter out = response.getWriter();
		String client_ip_address="";		
		HttpSession session=request.getSession(false);
		Connection con	=	null;	
		PreparedStatement pstmt = null;
		Statement stmt	=	null;
		Statement stmt1	=	null;
		ResultSet rs1	=	null;
		ResultSet rs2	=	null;
		CallableStatement statement = null;		
		int updatepullinglist=0;		
		Properties p = (Properties) session.getValue("jdbc");
		client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		String sql="";
		String sql1="";
		String autotrack_upon_confirm_pl_yn="";
		String locn_identity="", mr_locn_yn="";

		boolean inserted=false;
		String error="", err_out="",confirm_yn="";//String error_value="";	
		p_gender			= request.getParameter("p_gender");
		p_fm_nursing_unit_code	= request.getParameter("fm_nursing_unit_code");
		p_to_nursing_unit_code	= request.getParameter("to_nursing_unit_code");
		p_fm_pract_id		= request.getParameter("fm_pract_id");
		p_to_pract_id		= request.getParameter("to_pract_id");
		p_preferred_date			= request.getParameter("preferred_date");
		print_pulled_list	= request.getParameter("print_pulled_list");
		print_tracer_card	= request.getParameter("print_tracer_card");
		print_only_report	= request.getParameter("print_only_report");
		p_fs_locn_code		= request.getParameter("p_fs_locn_code");
		appl_user_id		= request.getParameter("appl_user_id");
		confirm_yn		    = request.getParameter("confirm_yn");

		if (appl_user_id==null)
		{
			appl_user_id="";
		}
		if (print_pulled_list==null)
		{
			print_pulled_list="N";
		}
		if (print_tracer_card==null)
		{
			print_tracer_card="N";
		}
		if (p_fm_nursing_unit_code==null)
		{
			p_fm_nursing_unit_code="";
		}
		if (p_to_nursing_unit_code==null)
		{
			p_to_nursing_unit_code="";
		}
		if (p_fm_pract_id==null)
		{
			p_fm_pract_id="";
		}
		if (p_to_pract_id==null)
		{
			p_to_pract_id="";
		}
		if (print_only_report==null)
		{
			print_only_report="N";
		}
		try
		{
			con									=	ConnectionManager.getConnection(request);
			facility_id							=	(String)session.getValue("facility_id");
			user_id								=	(String)session.getValue("login_user");			
			RecordSet pullinglistrefno=null;
			RecordSet pullinglistremarks=null;
			RecordSet pullinglistFileNo=null;
			RecordSet pullinglistpatientId=null;
			RecordSet pullinglistVolumeNo=null;
			String from ="";
			String to="";
			//fetch the parameters...
			try
			{				
				if (print_only_report.equals("Y"))
				{
					//error = "Confirmed Pulling List Report is submitted for printing...";
					doOnlineReportPrinting(request,response,"FMBPULST",locale);					
					out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value="+"\"</script><body class='message'></html>");
				}
				else
                {
                 from		=	(request.getParameter("from")==null)	?	"0"	:	request.getParameter("from");
				 to			=	(request.getParameter("to")==null)		?	"0"	:	request.getParameter("to");
				pullinglistrefno	=	(webbeans.eCommon.RecordSet)	session.getAttribute("pullinglistrefno");
	            pullinglistremarks	=	(webbeans.eCommon.RecordSet)	session.getAttribute("pullinglistremarks");
	            pullinglistFileNo	=	(webbeans.eCommon.RecordSet)	session.getAttribute("pullinglistFileNo");
	            pullinglistpatientId=	(webbeans.eCommon.RecordSet)	session.getAttribute("pullinglistpatientId");
				pullinglistVolumeNo	=	(webbeans.eCommon.RecordSet)	session.getAttribute("pullinglistVolumeNo");

				if(from != null && to != null)
				{
					from	=	from.trim();
					to		=	to.trim();
					
					for( int i1=(Integer.parseInt(from)); i1<=(Integer.parseInt(to)); i1++)
					{
						
						if(request.getParameter(("pull_yn"+i1)) != null)
						{
						String checkedApptRefNo = request.getParameter("p_bkg_lst_ref_no"+(i1));
                        String checkedRemarks=request.getParameter("p_remarks"+(i1));
                        String checkedFileNo=request.getParameter("p_file_no"+(i1));
						String checkedPatientID=request.getParameter("p_patient_id"+(i1));
						String checkedVolumeNo=request.getParameter("p_volume_no"+(i1));

						if(!(pullinglistrefno.containsObject(checkedApptRefNo))){
								pullinglistrefno.putObject(checkedApptRefNo);
                                pullinglistremarks.putObject(checkedRemarks);
								pullinglistFileNo.putObject(checkedFileNo);
                                pullinglistpatientId.putObject(checkedPatientID);
								pullinglistVolumeNo.putObject(checkedVolumeNo);
							}
						}
					}
			     }
            
			stmt=con.createStatement();
			sql1 = "select '"+facility_id+"' || FM_IP_PULLING_LIST_TMP_SEQ1.nextval p_pull_list_no from dual" ;
			rs1	 = stmt.executeQuery(sql1);
			while(rs1.next())
			{
				p_pull_list_no = rs1.getString("p_pull_list_no");
			} if(rs1 != null) rs1.close();
            /*Added audit column in the below query*/			
			sql = "update fm_ip_pulling_list set confirm_yn = 'N', remarks = '', PULL_LIST_NO = '' , MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ? , MODIFIED_FACILITY_ID = ?  where facility_id = ? and preferred_date= to_date(?,'dd/mm/yyyy') and nursing_unit_code between nvl(?,'!') and nvl(?,'~') and (practitioner_id is null or practitioner_id between nvl(?,'!') and nvl(?,'~')) and src_fs_locn_code=?  and patient_id in (select patient_id from mp_patient where sex = decode(?,'A',sex,?)) and confirm_yn = ?";
			
			
			pstmt		=	con.prepareStatement(sql);
			
			pstmt.setString(1,user_id);
			pstmt.setString(2,client_ip_address);
			pstmt.setString(3,facility_id);

         	pstmt.setString(4,facility_id);
			pstmt.setString(5,p_preferred_date);
			pstmt.setString(6,p_fm_nursing_unit_code);
			pstmt.setString(7,p_to_nursing_unit_code);
			pstmt.setString(8,p_fm_pract_id);
			pstmt.setString(9,p_to_pract_id);
			pstmt.setString(10,p_fs_locn_code);
			pstmt.setString(11,p_gender);
			pstmt.setString(12,p_gender);
			pstmt.setString(13,confirm_yn);
			updatepullinglist = pstmt.executeUpdate();
			if (pstmt != null)  pstmt.close();
		
			for(int i=0;i<pullinglistrefno.getSize();i++)
			{
				String final_appt_ref_no =(String)pullinglistrefno.getObject(i);
				String final_remarks =(String)pullinglistremarks.getObject(i);
				String final_patientid =(String)pullinglistpatientId.getObject(i);
				String final_fileno=(String)pullinglistFileNo.getObject(i);
				String final_volumeno=(String)pullinglistVolumeNo.getObject(i);
				
				sql = "select to_char(preferred_date,'dd/mm/rrrr hh24:mi') appt_time from ip_booking_list where FACILITY_ID=? AND BKG_LST_REF_NO=?";
				pstmt	=	con.prepareStatement(sql);
                pstmt.setString(1,facility_id);
                pstmt.setString(2,final_appt_ref_no);
				rs1=pstmt.executeQuery();
				while (rs1!=null && rs1.next())
					p_appt_time=rs1.getString("appt_time");	
				if(rs1 != null)rs1.close();
				if (pstmt != null)  pstmt.close();
				sql = "UPDATE FM_IP_PULLING_LIST SET CONFIRM_YN = 'Y', REMARKS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ? , MODIFIED_FACILITY_ID = ?, PREFERRED_TIME = to_date(nvl(?,sysdate),'dd/mm/rrrr hh24:mi'), PULL_LIST_NO = ? WHERE FACILITY_ID = ? AND BKG_LST_REF_NO = ? AND FILE_NO = ? AND PATIENT_ID = ? AND VOLUME_NO = ? ";
							pstmt		=	con.prepareStatement(sql);
							int colIndex	=	0;
							pstmt.setString	(	++colIndex,		final_remarks	);
							pstmt.setString	(	++colIndex,		user_id			);
							pstmt.setString	(	++colIndex,		client_ip_address);
							pstmt.setString	(	++colIndex,		facility_id		);
							pstmt.setString	(	++colIndex,		p_appt_time		);
							pstmt.setString	(	++colIndex,		p_pull_list_no	);
							pstmt.setString	(	++colIndex,		facility_id		);
							pstmt.setString	(	++colIndex,		final_appt_ref_no);
							pstmt.setString	(	++colIndex,		final_fileno	);
							pstmt.setString	(	++colIndex,		final_patientid	);
							pstmt.setString	(	++colIndex,		final_volumeno	);
							updatepullinglist = pstmt.executeUpdate();
							if(pstmt != null)pstmt.close();
			}
		}
				if(updatepullinglist > 0)
				{
					inserted=true;
					//error="APP-SM0002 Operation Completed Successfully ....";
					java.util.Hashtable message1 = MessageManager.getMessage(locale, "RECORD_MODIFIED", "SM");
					error	=	(String) message1.get("message");
				   message1.clear();	
				}
				else
				{
					error=err_out;
					inserted=false;
				}
			}
			catch(Exception e)
			{
				out.println("Exception in calling procedure "+e.toString());				
				e.printStackTrace();
			}
			if (confirm_yn.equals("Y")||confirm_yn.equals("N"))
			{
			if(inserted)
			{				
				con.commit();
			/*	if (print_pulled_list.equals("Y"))
				{
					doOnlineReportPrinting(request,response,"FMBMRPLI",locale);
				}

				if (print_tracer_card.equals("Y"))
				{
					doOnlineReportPrinting(request,response,"FMBATRCI",locale);
				} */
				stmt1=con.createStatement();
				sql1 = "SELECT   autotrack_upon_confirm_pl_yn FROM fm_parameter WHERE FACILITY_ID = '"+facility_id+"'";
				rs2	 = stmt1.executeQuery(sql1);

				if(rs2.next())
				{
					autotrack_upon_confirm_pl_yn = rs2.getString("autotrack_upon_confirm_pl_yn"); 
				}
				if (autotrack_upon_confirm_pl_yn == null)
					autotrack_upon_confirm_pl_yn ="N";
				
				if(stmt1 != null) stmt1.close();
				if(rs2 != null) rs2.close();
				
				if (autotrack_upon_confirm_pl_yn.equals("Y"))
				{
					
					if (print_pulled_list.equals("Y"))
				{
					doOnlineReportPrinting(request,response,"FMBMRCPI",locale);
				}

				if (print_tracer_card.equals("Y"))
				{
					doOnlineReportPrinting(request,response,"FMBIPTRC",locale);
				}
					
					
					stmt1=con.createStatement();
					sql1 = "SELECT   LOCN_IDENTITY, MR_LOCN_YN FROM FM_STORAGE_LOCN_LANG_VW WHERE FACILITY_ID = '"+facility_id+"' AND EFF_STATUS = 'E'  AND PERMANENT_FILE_AREA_YN = 'Y' AND LANGUAGE_ID='"+locale+"' and FS_LOCN_CODE='"+p_fs_locn_code+"'  ORDER BY 2";
						rs2	 = stmt1.executeQuery(sql1);

					if(rs2.next())
					{
						locn_identity = rs2.getString("LOCN_IDENTITY"); 
						mr_locn_yn = rs2.getString("MR_LOCN_YN"); 
					}

					if(mr_locn_yn == null)
						mr_locn_yn ="N";

					if(locn_identity == null)
						locn_identity ="";
					/*if (p_preferred_date != null)
					{
						p_preferred_date=DateUtils.convertDate(p_preferred_date,"DMY","en",locale);
					}*/
					 request.setAttribute("preferred_date",p_preferred_date);
					request.setAttribute("iss_locn_code",p_fs_locn_code);
					//request.setAttribute("iss_locn_iden",locn_identity);
					//request.setAttribute("iss_locn_mryn",mr_locn_yn);
					request.setAttribute("issue_user",appl_user_id);
					request.setAttribute("from_nursing_unit",p_fm_nursing_unit_code);
					request.setAttribute("to_nursing_unit",p_to_nursing_unit_code);
					request.setAttribute("autotrack_upon_confirm_pl_yn",autotrack_upon_confirm_pl_yn);
					request.setAttribute("print_card",print_tracer_card);
		     		 request.setAttribute("p_fm_pract_id",p_fm_pract_id);
					request.setAttribute("p_to_pract_id",p_to_pract_id);
					request.setAttribute("p_gender",p_gender);
					request.setAttribute("p_pull_list_no",p_pull_list_no);
					request.setAttribute("print_pulled_list",print_pulled_list);
					
					
			
					
					RequestDispatcher disp = request.getRequestDispatcher("/servlet/eFM.FMAutoTrackOutToIPWServlet");
					
					//RequestDispatcher disp =  getServletContext().getRequestDispatcher("/servlet/eFM.FMAutoTrackOutToOPDServlet");
					disp.forward(request,response);	
			
				  }
			   	else
			   	{
			  out.println("<script>parent.frames(1).frames(1).doOnlineReportPrinting('"+error+"','"+p_fm_nursing_unit_code+"','"+p_fm_nursing_unit_code+"','"+p_fm_pract_id+"','"+p_to_pract_id+"','"+p_gender+"','"+p_preferred_date+"','"+p_pull_list_no+"','"+p_fs_locn_code+"','"+appl_user_id+"','"+print_pulled_list+"','"+print_tracer_card+"');</script>");
			
			//	out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value=1"+"\"</script><body class='message'></html>");
				}

				if(stmt1 != null) stmt1.close();
				if(rs2 != null) rs2.close();
			}		
			else
			{				
				con.rollback();		
		out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value=0"+"\"</script><body class='message'></html>");
			}
		}
		else
		{		 
		 out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value=1"+"\"</script><body class='message'></html>");
		}
		if(pstmt != null)pstmt.close();	
		if(stmt != null)stmt.close();
		if(statement != null)statement.close();
		if(rs1 != null)rs1.close();
		}
		catch(Exception e)
		{
			out.println("Exception in main try"+e);
			e.printStackTrace();
		}
		finally
		{				
			ConnectionManager.returnConnection(con, request);			
		}
	}//end of doPost

public synchronized void doOnlineReportPrinting( HttpServletRequest req, HttpServletResponse res,String p_report_id, String locale )
{
	java.io.PrintWriter out = null;
	java.util.Properties p=null;
	HttpSession session=req.getSession(false);
	p = (Properties) session.getValue("jdbc");
	locale = p.getProperty("LOCALE");
	try
	{
		out = res.getWriter();		

		String 	rs_report_id = p_report_id;
		String ReportOutput="";
		
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;

				ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id, "FM",rs_report_id) ;
				report1.addParameter( "p_facility_id",	facility_id ) ;
				report1.addParameter("p_user_name",user_id);
			    report1.addParameter("p_report_id",rs_report_id);
				report1.addParameter("p_fm_nursing_unit_code",p_fm_nursing_unit_code);
				report1.addParameter("p_to_nursing_unit_code",p_to_nursing_unit_code);
				report1.addParameter("p_fm_pract_id",p_fm_pract_id);
				report1.addParameter("p_to_pract_id",p_to_pract_id);
				report1.addParameter("p_gender",p_gender);
				report1.addParameter("p_preferred_date",p_preferred_date);
				report1.addParameter("p_pull_list_no",p_pull_list_no);
			    report1.addParameter("p_module_id","FM");
				report1.addParameter("P_SRC_FS_LOCN_CODE",p_fs_locn_code);
				report1.addParameter("p_appl_user_id",appl_user_id);
				report1.addParameter("p_call_from","CONFIRM_PULLING_LIST");
				report1.addParameter("P_T_NAME","FM_IP_PULLING_LIST");	
				report1.addParameter("P_LANGUAGE_ID",locale);
				onlineReports.add( report1) ;
		
		
		 ReportOutput = onlineReports.execute( req, res );

	}
	catch ( Exception e )
	{
		out.println("Encountered error while Processing Online Reports "+e);
		e.printStackTrace();
	}
	

} // END OF THE METHOD........

}//end of Main class



		
