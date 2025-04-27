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
import com.ehis.util.*;




public class FMInternalReportReprintServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	
	String error="", user_id="", facility_id="";
	String p_fs_locn_code="",p_appt_date="",p_gender="",p_fm_clinic_code="",p_to_clinic_code="",p_fm_nursing_unit_code="",p_to_nursing_unit_code="";
	String p_fm_pract_id="",p_to_pract_id="",p_facility_id="",p_report_id="",p_module_id="",req_user_id="",print_tel_no="",print_bar_code="";
	String print_pull_list_type="",order_by_pull_list="",file_no="",patient_id="",fs_locn_id,fcy_id="",file_no_temp="";
	Connection con	=	null;
	String locale			= "" ;
 	String pat_id="";
	String fileno="";
	String volno="",volume_no="";
   String Rep_name="",req_no,encounter_id="",requesting_from="";
	String p_perm_fs_locn_code="";
	String dest_fs_locn_code="";
	String req_fac_id="";
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,java.io.IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		java.io.PrintWriter out = response.getWriter();				
		HttpSession session=request.getSession(false);
		Properties p = (Properties) session.getValue("jdbc");
		locale = p.getProperty("LOCALE");
		Statement stmt	=	null;
		ResultSet rs	=	null;
		CallableStatement statement = null;		
		try
		{
			con						= ConnectionManager.getConnection(request);
			facility_id				= (String)session.getValue("facility_id");
			user_id					= (String)session.getValue("login_user");	
			stmt					= con.createStatement();
			p_fs_locn_code			= request.getParameter("fs_locn_code");
			p_appt_date				= request.getParameter("appt_date");
			p_gender				= request.getParameter("p_gender");
			p_fm_clinic_code		= request.getParameter("fm_clinic_code");
			p_to_clinic_code		= request.getParameter("to_clinic_code");
			p_fm_nursing_unit_code	= request.getParameter("fm_nursing_unit_code");
			p_to_nursing_unit_code  = request.getParameter("to_nursing_unit_code");
			p_fm_pract_id			= request.getParameter("fm_pract_id");
			p_to_pract_id			= request.getParameter("to_pract_id");
			p_facility_id			= request.getParameter("p_facility_id");
			p_report_id				= request.getParameter("p_report_id");
			p_module_id				= request.getParameter("p_module_id");
			req_user_id				= request.getParameter("req_name");
			print_pull_list_type	= request.getParameter("print_pull_list_type");
			order_by_pull_list		= request.getParameter("order_by_pull_list");
			print_tel_no			= request.getParameter("print_tel_no");
			print_bar_code			= request.getParameter("print_bar_code");
			file_no					= request.getParameter("fileno");
			fileno                  = request.getParameter("file_no");
			volume_no         = request.getParameter("volumeno");
			requesting_from =request.getParameter("requesting");
			req_fac_id     =request.getParameter("req_fac_id");
		//	if(fileno!=null) file_no=fileno;
			patient_id				= request.getParameter("patientid");
			
			pat_id                   =request.getParameter("pat_id");
				//	if(pat_id!=null) patient_id=pat_id;
			volno                  = request.getParameter("vol_no");
			fs_locn_id				= request.getParameter("FS_LOCN_ID");
			Rep_name             = request.getParameter("Rep_name");
			req_no                  = request.getParameter("req_no");
			encounter_id          = request.getParameter("encounter_id");
			dest_fs_locn_code          = request.getParameter("curr_fs_locn_code");
			if(req_fac_id==null ||req_fac_id.equals("null"))req_fac_id="";		
			if(volno==null ||volno.equals("null"))volno="";		
			if(volume_no==null ||volume_no.equals("null"))volume_no="";		
			if(print_tel_no==null || print_tel_no.equals("null"))print_tel_no="Y";	
			if(print_bar_code==null || print_bar_code.equals("null"))print_bar_code="Y";		
			if(p_fs_locn_code==null || p_fs_locn_code.equals("null"))p_fs_locn_code="";
			if(p_appt_date==null || p_appt_date.equals("null"))p_appt_date="";
			if(p_gender==null || p_gender.equals("null"))p_gender="A";
			if(p_fm_clinic_code==null || p_fm_clinic_code.equals("null"))p_fm_clinic_code="";
			if(p_to_clinic_code==null || p_to_clinic_code.equals("null"))p_to_clinic_code="";
			if(p_fm_pract_id==null || p_fm_pract_id.equals("null"))p_fm_pract_id="";
			if(p_to_pract_id==null || p_to_pract_id.equals("null"))p_to_pract_id="";
			if(p_facility_id==null || p_facility_id.equals("null"))p_facility_id="";
			if(p_fm_nursing_unit_code==null || p_fm_nursing_unit_code.equals("null"))p_fm_nursing_unit_code="";
			if(p_to_nursing_unit_code==null || p_to_nursing_unit_code.equals("null"))p_to_nursing_unit_code="";
			if(p_report_id==null || p_report_id.equals("null"))p_report_id="";
			if(p_module_id==null || p_module_id.equals("null"))p_module_id="";
			if(req_user_id==null || req_user_id.equals("null"))req_user_id="";
			if(print_pull_list_type==null || print_pull_list_type.equals("null"))print_pull_list_type="";
			if(order_by_pull_list==null || order_by_pull_list.equals("null"))order_by_pull_list="";
			if(file_no==null || file_no.equals("null"))file_no="";
			if(patient_id==null || patient_id.equals("null"))patient_id="";
			if(fs_locn_id==null || fs_locn_id.equals("null"))fs_locn_id="";
            if(Rep_name==null || Rep_name.equals("null"))Rep_name="";
			  if(req_no==null || req_no.equals("null"))req_no="";
			if(encounter_id==null || encounter_id.equals("null"))encounter_id="";
			if(requesting_from==null || requesting_from.equals("null"))requesting_from="";
			if(dest_fs_locn_code==null || dest_fs_locn_code.equals("null"))dest_fs_locn_code="";
				
				if (p_appt_date != null){
					p_appt_date=DateUtils.convertDate(p_appt_date,"DMY",locale,"en");
				}
				
					if(req_fac_id.equals(""))
			          {
                      req_fac_id=facility_id;
					         }
					 rs= stmt.executeQuery("	SELECT perm_fs_locn_code   FROM fm_curr_locn  WHERE patient_id ='"+pat_id+"'  AND file_no = nvl('"+fileno+"', file_no) AND volume_no = nvl('"+volno+"', volume_no)");
					while(rs!=null && rs.next()){
				  p_perm_fs_locn_code=rs.getString("perm_fs_locn_code");
						if(p_perm_fs_locn_code==null) p_perm_fs_locn_code="";		
							}
			if(rs != null)		rs.close();
			if(stmt != null)stmt.close();
				
			stmt		= con.createStatement();	
				if(p_report_id.equals("FMBISSCD"))
				{
					StringBuffer sql	= null;
					sql					= new StringBuffer();
					int cnt=0;
					file_no_temp="('";
					fcy_id="('";					
					sql.append("select facility_id,file_no from fm_movement_log where facility_id ='"+  facility_id + "'and to_char(sent_date_time,'dd/mm/yyyy') = '"+  p_appt_date + "'and dest_locn_identity = '"+  fs_locn_id + "'and dest_fs_locn_code = '"+  p_fs_locn_code + "'");
					if(!patient_id.equals(""))
						sql.append("and facility_id = '"+p_facility_id+"' and file_no = '"+file_no+"'");				
						rs= stmt.executeQuery(sql.toString());
					
					while(rs!=null && rs.next()){
						cnt++;
                       fcy_id=fcy_id + rs.getString(1)+"','";
                       file_no_temp=file_no_temp + rs.getString(2)+"','";					  
					}
				    file_no_temp=file_no_temp.substring(0,file_no_temp.length()-2);
					file_no_temp=file_no_temp + ")";
					fcy_id=fcy_id.substring(0,fcy_id.length()-2);
					fcy_id=fcy_id + ")";  					 
					
					if (cnt==0)
					{
						file_no_temp="(null)";
						fcy_id="(null)";						
						
					}
				}
			try
			{
				if(!p_report_id.equals("FMFLRQSL"))
				{
				
				 doOnlineReportPrinting(request,response,locale);
				}
				 if (p_report_id.equals("FMFLRQSL"))
				{
				 	 doOnlineReq_file_ReportPrinting(request,response,"FMFLRQSL",locale);
				}			
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(error,"UTF-8" )+ "&err_value=1"  );
			}
			catch(Exception e)
			{
				out.println("Exception in calling Reports "+e.toString());				
			}
			if(rs != null)		rs.close();
			if(stmt != null)stmt.close();
			if(statement != null)statement.close();
		}
		catch(Exception e)
		{
			out.println("Exception in main try"+e);
		}
		finally
		{			
			ConnectionManager.returnConnection(con, request);			
		}
	}

public synchronized void doOnlineReportPrinting( HttpServletRequest req, HttpServletResponse res, String locale )
{
	java.io.PrintWriter out = null;
	try
	{
		
		String out_put="";
		out = res.getWriter();		
	
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
      
		/*
		String p_report_id1 = "";
				if(p_report_id.equals("FMBPULST"))
					{
					  p_report_id1 = p_report_id;
					  p_report_id = "FMBMRPLA";
					}

				if(p_report_id.equals("FMBPULS1"))
					{
					  p_report_id1 = p_report_id;
					  p_report_id = "FMBMRPLI";
					}
		*/
				String p_reprint_yn  = req.getParameter("p_reprint_yn")==null?"N":req.getParameter("p_reprint_yn");//Added @UAT-3
				ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facility_id,"FM",p_report_id) ;
				report1.addParameter( "p_facility_id",	facility_id ) ;
				report1.addParameter("p_user_name",user_id);
					//if(p_report_id1.equals("FMBPULST")||p_report_id1.equals("FMBPULS1"))
				
				
				if(p_report_id.equals("FMBPULST")||(p_report_id.equals("FMBIPLST") && p_reprint_yn.equals("Y"))) {//Changed @UAT-3
					report1.addParameter("p_call_from","CONFIRM_PULLING_LIST");
				} else {
                  if (p_report_id.equals("FMBMRPLA")||p_report_id.equals("FMBMRPLI"))
				  {
					report1.addParameter("p_call_from","GENERATE_PULLING_LIST");
					
					}
				}
				//if(p_report_id1.equals("FMBATRCD")||p_report_id1.equals("FMBATRCI"))
				if(p_report_id.equals("FMBATRCD")||p_report_id.equals("FMBATRCI"))
					report1.addParameter("p_call_from","AUTO_TRACK");				
				
				report1.addParameter("p_report_id",p_report_id);
				report1.addParameter("p_fm_clinic_code",p_fm_clinic_code);								
				report1.addParameter("p_to_clinic_code",p_to_clinic_code);								
				report1.addParameter("p_fm_nursing_unit_code",p_fm_nursing_unit_code);								
				report1.addParameter("p_to_nursing_unit_code",p_to_nursing_unit_code);								
				report1.addParameter("p_fm_pract_id",p_fm_pract_id);				
				report1.addParameter("p_to_pract_id",p_to_pract_id);								
				report1.addParameter("p_gender",p_gender);								
				report1.addParameter("p_appt_date",p_appt_date);
				report1.addParameter("p_preferred_date",p_appt_date);								
			    report1.addParameter("p_module_id","FM");								
				report1.addParameter("p_src_fs_locn_code",p_fs_locn_code);								
				report1.addParameter("p_status",print_pull_list_type);								
				report1.addParameter("ORDER_BY",order_by_pull_list);								
				report1.addParameter("p_file_no",file_no_temp);								
				report1.addParameter("p_curr_facility_id",fcy_id);								
				report1.addParameter("file_no_temp",file_no);	
				report1.addParameter("p_reprint_yn",p_reprint_yn);	//Added @UAT-3			
				if(p_report_id.equals("FMBATRCI"))
					report1.addParameter("P_T_NAME","FM_IP_AUTO_TRACK_LOG");	
				else
					report1.addParameter("P_T_NAME","FM_AUTO_TRACK_LOG");	

				report1.addParameter("p_print_tel_no",print_tel_no);	
				report1.addParameter("print_bar_code",print_bar_code);
				report1.addParameter("P_LANGUAGE_ID",locale);
				onlineReports.add( report1) ;				
			     out_put=onlineReports.execute( req, res );				
				java.util.Hashtable message = MessageManager.getMessage( locale, "REPORT_SUBMIT_SERVER","common" ) ;
                error = ( (String) message.get("message") ) ;
				message.clear();
	}
	catch ( Exception e )
	{
		out.println("Encountered error while Processing Online Reports "+e);
	}
}	
public synchronized void doOnlineReq_file_ReportPrinting(HttpServletRequest req, HttpServletResponse res,String p_report_id ,String locale )
{
	java.io.PrintWriter out = null;
	try
	{
		out = res.getWriter();		
	    String out_put="";     
		int count_token=0;
	
	String 	rs_report_id = p_report_id;	
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;

		/*
		String p_report_id1 = "";
				if(p_report_id.equals("FMBPULST"))
					{
					  p_report_id1 = p_report_id;
					  p_report_id = "FMBMRPLA";
					}

				if(p_report_id.equals("FMBPULS1"))
					{
					  p_report_id1 = p_report_id;
					  p_report_id = "FMBMRPLI";
					}
		*/
		String p_reprint_yn  = req.getParameter("p_reprint_yn")==null?"N":req.getParameter("p_reprint_yn");//Added @UAT-3
		StringTokenizer dest_fs_locn_code_token=new StringTokenizer(dest_fs_locn_code,"|");
		count_token=dest_fs_locn_code_token.countTokens();		
				ecis.utils.OnlineReport report1=null;
				if(count_token > 1){
					for(int j=1;j<=count_token;j++){
						dest_fs_locn_code=dest_fs_locn_code_token.nextToken();						
						 report1= new ecis.utils.OnlineReport(req_fac_id,"FM",rs_report_id,"F",dest_fs_locn_code) ;
						 report1.addParameter( "p_facility_id",req_fac_id) ;
						 report1.addParameter("p_user_name",user_id);
						 report1.addParameter("p_call_from","REQUEST_FILE_LIST");				 	
						 report1.addParameter("p_file_no",fileno);	
						 report1.addParameter("p_volume_no",volno);	
						 report1.addParameter("p_encounter_id",encounter_id);
						 report1.addParameter("p_requested_date",p_appt_date);
						 report1.addParameter("p_req_fs_locn_code",p_fs_locn_code);	 	
						 report1.addParameter("p_req_user_id",req_user_id);	
						 report1.addParameter("p_patient_id",pat_id);
						 report1.addParameter("P_LANGUAGE_ID",locale);
						 report1.addParameter("p_dest_locn_code",dest_fs_locn_code);						 
						 onlineReports.add( report1) ;	

					}
				}
				else{
				if (Rep_name.equals("RE"))
		       {
             report1= new ecis.utils.OnlineReport(req_fac_id,"FM",rs_report_id,"F",p_perm_fs_locn_code) ;
		     	  }else{				
				 report1= new ecis.utils.OnlineReport( facility_id,"FM",rs_report_id,"F",p_fs_locn_code) ;
		          }
				if (Rep_name.equals("RE"))
					{
                	report1.addParameter( "p_facility_id",req_fac_id) ;
				     }else{
                report1.addParameter( "p_facility_id",facility_id) ;
				  	   }
					report1.addParameter("p_user_name",user_id);
			             
				  if (Rep_name.equals("RE")){
					
					report1.addParameter("p_call_from","REQUEST_FILE_LIST");
				  //  report1.addParameter("p_req_no",req_no);	
			        report1.addParameter("p_file_no",fileno);	
				    report1.addParameter("p_volume_no",volno);	
				    report1.addParameter("p_encounter_id",encounter_id);
					report1.addParameter("p_requested_date",p_appt_date);
					report1.addParameter("p_req_fs_locn_code",p_fs_locn_code);	 	
				    report1.addParameter("p_req_user_id",req_user_id);	
					report1.addParameter("p_patient_id",pat_id);				
				    report1.addParameter("p_reprint_yn",p_reprint_yn);//Added @UAT-3
				
				
				}else if(Rep_name.equals("OP"))		
		        {
                  report1.addParameter("p_call_from","GENERATE_OP_PULLING_LIST");
		 		  }else if(Rep_name.equals("IP"))
		      {
			    report1.addParameter("p_call_from","GENERATE_IP_PULLING_LIST");
		  			  }
		         if (!Rep_name.equals("RE")){
				report1.addParameter("p_report_id",rs_report_id);
				report1.addParameter("p_fm_clinic_code",p_fm_clinic_code);								
				report1.addParameter("p_to_clinic_code",p_to_clinic_code);								
				report1.addParameter("p_fm_nursing_unit_code",p_fm_nursing_unit_code);								
				report1.addParameter("p_to_nursing_unit_code",p_to_nursing_unit_code);								
				report1.addParameter("p_fm_pract_id",p_fm_pract_id);				
				report1.addParameter("p_to_pract_id",p_to_pract_id);								
				report1.addParameter("p_gender",p_gender);								
				report1.addParameter("p_appt_date",p_appt_date);
				report1.addParameter("p_preferred_date",p_appt_date);								
			    report1.addParameter("p_module_id","FM");								
				report1.addParameter("p_src_fs_locn_code",p_fs_locn_code);								
				report1.addParameter("p_status",print_pull_list_type);								
				report1.addParameter("ORDER_BY",order_by_pull_list);								
				report1.addParameter("p_patient_id",patient_id);	
				report1.addParameter("p_volume_no",volume_no);								
				report1.addParameter("p_file_no",file_no);	
				report1.addParameter("p_curr_facility_id",fcy_id);								
				report1.addParameter("file_no_temp",file_no_temp);				
			  				
				//	if(p_report_id.equals("FMBATRCI"))
			//		report1.addParameter("P_T_NAME","FM_IP_AUTO_TRACK_LOG");	
			//	else
				//	report1.addParameter("P_T_NAME","FM_AUTO_TRACK_LOG");	

				report1.addParameter("p_print_tel_no",print_tel_no);	
				report1.addParameter("print_bar_code",print_bar_code);
				 }
				report1.addParameter("P_LANGUAGE_ID",locale);				
				onlineReports.add( report1) ;	
				}
			 out_put=	onlineReports.execute( req,res);				 
					java.util.Hashtable message = MessageManager.getMessage( locale, "REPORT_SUBMIT_SERVER","common" ) ;
                error = ( (String) message.get("message") ) ;
				message.clear();
	}
	catch ( Exception e )
	{
		out.println("Encountered error while Processing Online Reports "+e);
	}
} 
}



		
