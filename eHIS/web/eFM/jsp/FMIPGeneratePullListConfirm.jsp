<!DOCTYPE html>
<%@ page import="java.util.*, java.sql.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMIPGeneratePullList.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown='CodeArrest()' onKeyDown = 'lockKey();' class=message>
	<form name='GenaratePulingListConfirm' id='GenaratePulingListConfirm'>

<% 
	Connection con	=	null;
	Statement stmt	=	null;
	ResultSet rs	=	null;
	String facility_id="",sql="",p_preferred_date="",p_fm_nursing_unit_code="",p_to_nursing_unit_code="";
	String p_fs_locn_code="",p_pull_type="",p_gender="",alert_flag="";
	String p_fm_pract_id="",p_to_pract_id="";

	String fm_preferred_date="", to_preferred_date="",preferred_date="" , fm_nursing_unit_code="", to_nursing_unit_code="", fm_pract_id="";
	String to_pract_id="",	pull_list_yn="" ;

	String gen_tracer="";
	String p_order_term = "";
	String   user_id="", fs_locn_code="",appl_user_id="" ;
	String p_gen_report="",print_pull_list_type="",order_by_pull_list="",print_tel_no="",print_bar_code="",operation_type="" ;
	String locale				= (String)session.getAttribute("LOCALE");
    String p_print_req_slip="";
    String flag="" ,from_nursing_unit="" ,to_nursing_unit="" ,p_pull_list_no="";;
	String login_facility_id="" ,login_user_id="",print_pulled_list="N" ,print_tracer_card="N"; 
	String p_pull_list_seq="";
	try
	{
		con			=	ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");

		p_preferred_date			=	request.getParameter("p_preferred_date");
		p_fm_nursing_unit_code	=	request.getParameter("p_fm_nursing_unit_code");
		p_to_nursing_unit_code	=	request.getParameter("p_to_clinic_code");
	//	p_fm_pract_id		=	request.getParameter("p_fm_pract_id");
	//	p_to_pract_id		=	request.getParameter("p_to_pract_id");
		p_fs_locn_code		=	request.getParameter("p_fs_locn_code");
		p_pull_type		    =	request.getParameter("p_pull_type");
		p_gender		    =	request.getParameter("p_gender");
         flag                    =	request.getParameter("flag");
		if (flag==null || flag.equals("null")) flag="";
		int p_total_cnt=0;
		int p_T_status_cnt=0,p_male_main_cnt=0,p_female_main_cnt=0,p_unknown_main_cnt=0,p_male_supp_cnt=0,p_female_supp_cnt=0,p_unknown_supp_cnt=0,p_MS_status_cnt=0,p_S_status_cnt=0,p_M_status_cnt=0;
		String p_status="",p_male_pull_list_type="",p_female_pull_list_type="",p_unknown_pull_list_type="",pull_list_gen_by_gender="";
		
		if(flag.equals("Generate IP Pulling List"))
		{
            user_id			=	(String)session.getValue("login_user");	
			fm_preferred_date	= request.getParameter("fm_preferred_date");
			to_preferred_date	= request.getParameter("to_preferred_date");
			fm_nursing_unit_code	= request.getParameter("fm_nursing_unit_code");
			to_nursing_unit_code	= request.getParameter("to_nursing_unit_code");
			fm_pract_id		= request.getParameter("fm_pract_id");
			to_pract_id		= request.getParameter("to_pract_id");
			p_gender		= request.getParameter("p_gender");
			pull_list_yn	= request.getParameter("pull_list_yn");
			fs_locn_code	= request.getParameter("fs_locn_code");	
			appl_user_id	= request.getParameter("appl_user_id");	
			p_gen_report	= request.getParameter("p_gen_report");
			print_tel_no	= request.getParameter("print_tel_no");
			print_bar_code	= request.getParameter("print_bar_code");
			gen_tracer	         = request.getParameter("gen_tracer");
			operation_type	     = request.getParameter("operation_type");
			order_by_pull_list	 = request.getParameter("order_by_pull_list");
			print_pull_list_type = request.getParameter("print_pull_list_type");			
			p_order_term = request.getParameter("p_order_term");	
			p_print_req_slip = request.getParameter("p_print_req_slip");
			p_pull_list_seq = request.getParameter("p_pull_list_seq");
			if(fm_preferred_date !=null )
			{
				fm_preferred_date=DateUtils.convertDate(fm_preferred_date,"DMY",locale,"en");//Added by Rameswar on 08-Oct-15 for Leap Year Issue
			}
			else{
				fm_preferred_date=""; }

			if(to_preferred_date!=null )
			{
				to_preferred_date=DateUtils.convertDate(to_preferred_date,"DMY",locale,"en");//Added by Rameswar on 08-Oct-15 for Leap year ssue
			}
			else{
				to_preferred_date=""; }
				
				
		
		if (operation_type.equals("print"))
			{
		 doOnlineReportPrinting(request,response,"FMBMRPLA",locale, facility_id, user_id, fm_nursing_unit_code, to_nursing_unit_code, fm_pract_id, to_pract_id , p_gender, fm_preferred_date, fs_locn_code, print_pull_list_type, appl_user_id, order_by_pull_list, print_tel_no, print_bar_code,p_order_term ,p_pull_list_seq);
			}
            else
			{
			if (print_pull_list_type==null)
			{
				print_pull_list_type="N";
			}
			if (p_gen_report==null)
			{
				p_gen_report="N";
			}
			
			}
			
			if(to_preferred_date==null || to_preferred_date.equals("null"))to_preferred_date="";
			if(fm_nursing_unit_code==null || fm_nursing_unit_code.equals("null"))fm_nursing_unit_code="";
			if(to_nursing_unit_code==null || to_nursing_unit_code.equals("null"))to_nursing_unit_code="";
			if(fm_pract_id==null || fm_pract_id.equals("null"))fm_pract_id="";
			if(to_pract_id==null || to_pract_id.equals("null"))to_pract_id="";
			if(p_gender==null || p_gender.equals("null"))p_gender="";
			if(pull_list_yn==null || pull_list_yn.equals("null"))pull_list_yn="N";
			if(fs_locn_code==null || fs_locn_code.equals("null"))fs_locn_code="";
			if(appl_user_id==null || appl_user_id.equals("null"))appl_user_id="";			
			if(gen_tracer==null || gen_tracer.equals("null"))gen_tracer="";		
			if(order_by_pull_list==null || order_by_pull_list.equals("null"))order_by_pull_list="";		
			if(print_tel_no==null || print_tel_no.equals("null"))print_tel_no="N";		
			if(print_bar_code==null || print_bar_code.equals("null"))print_bar_code="N";		
			if(operation_type==null || operation_type.equals("null"))operation_type="N";		
			if(p_print_req_slip==null || p_print_req_slip.equals("null")) p_print_req_slip="N";
			if(p_order_term==null || p_order_term.equals("null"))p_order_term="";	
			 if(p_pull_list_seq==null || p_pull_list_seq.equals("null")) p_pull_list_seq="";	
		if(fm_preferred_date !=null )
		{
			//	fm_preferred_date=DateUtils.convertDate(fm_preferred_date,"DMY",locale,"en");
			}
			else
				fm_preferred_date="";
 		   
			   if (p_gen_report.equals("Y"))
			        {
					  doOnlineReportPrinting(request,response,"FMBMRPLI",locale, facility_id, user_id, fm_nursing_unit_code, to_nursing_unit_code, fm_pract_id, to_pract_id , p_gender, fm_preferred_date, fs_locn_code, print_pull_list_type, appl_user_id, order_by_pull_list, print_tel_no, print_bar_code,p_order_term ,p_pull_list_seq);
				      }
						if (gen_tracer.equals("Y"))
			           {
						doOnlineReportPrinting(request,response,"FMBIPTRC",locale,facility_id, user_id, fm_nursing_unit_code, to_nursing_unit_code, fm_pract_id, to_pract_id , p_gender, fm_preferred_date, fs_locn_code, print_pull_list_type, appl_user_id, order_by_pull_list, print_tel_no, print_bar_code,p_order_term ,p_pull_list_seq);
					   }
						 
						 if (p_print_req_slip.equals("Y"))
						{
						 
						doOnlineReq_file_ReportPrinting(request,response,"FMFLRQSL",locale,facility_id, user_id, fm_nursing_unit_code, to_nursing_unit_code, fm_pract_id, to_pract_id , p_gender, fm_preferred_date, fs_locn_code, print_pull_list_type, appl_user_id, order_by_pull_list, print_tel_no, print_bar_code,p_order_term ,p_pull_list_seq);
								
							
							}
  
 
 %>
	
 	<%!
      public synchronized void doOnlineReportPrinting( HttpServletRequest req, HttpServletResponse res,String p_report_id, String locale,String facility_id,String user_id,String fm_nursing_unit_code,String to_nursing_unit_code,String fm_pract_id,String to_pract_id ,String p_gender,String fm_preferred_date,String fs_locn_code,String print_pull_list_type,String appl_user_id,String order_by_pull_list,String print_tel_no,String print_bar_code,String p_order_term ,String p_pull_list_seq)
 {
	//java.io.PrintWriter out = null;
	try
	{
		//out = res.getWriter();
		String 	rs_report_id = p_report_id;		
		String ReportOutput="";
         String fm_preferred_date1="";
		if(fm_preferred_date!=null){
			fm_preferred_date1=fm_preferred_date;
			//fm_preferred_date1= DateUtils.convertDate(fm_preferred_date,"DMY","en",locale);
		}else{
			fm_preferred_date1="";
		}

		ecis.utils.OnlineReport report1=null;
			ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
				
                report1= new ecis.utils.OnlineReport( facility_id, "FM",rs_report_id) ;			
				report1.addParameter( "p_facility_id",facility_id ) ;
				report1.addParameter("p_user_name",user_id);
				report1.addParameter("p_report_id",rs_report_id);
				report1.addParameter("p_fm_nursing_unit_code",fm_nursing_unit_code);
				report1.addParameter("p_to_nursing_unit_code",to_nursing_unit_code);
				report1.addParameter("p_fm_pract_id",fm_pract_id);
				report1.addParameter("p_to_pract_id",to_pract_id);
				report1.addParameter("p_gender",p_gender);
				report1.addParameter("p_preferred_date",fm_preferred_date1);
				report1.addParameter("p_module_id","FM");
				report1.addParameter("p_src_fs_locn_code",fs_locn_code);
				report1.addParameter("p_status",print_pull_list_type);
				report1.addParameter("p_appl_user_id",appl_user_id);				
                report1.addParameter("p_call_from","GENERATE_PULLING_LIST");	
		       	report1.addParameter("ORDER_BY",order_by_pull_list);				
				report1.addParameter("P_T_NAME","FM_IP_PULLING_LIST");				
				report1.addParameter("p_print_tel_no",print_tel_no);				
				report1.addParameter("print_bar_code",print_bar_code);				
				report1.addParameter("p_order_term",p_order_term);
				report1.addParameter("P_LANGUAGE_ID",locale);
			report1.addParameter("p_pull_list_seq",p_pull_list_seq);
				onlineReports.add(report1);
		 ReportOutput = onlineReports.execute( req, res );
			}
	catch ( Exception e )
	{
		e.printStackTrace();
	}
}
	
 
public synchronized void doOnlineReq_file_ReportPrinting( HttpServletRequest req, HttpServletResponse res,String p_report_id, String locale,String facility_id,String user_id,String fm_nursing_unit_code,String to_nursing_unit_code,String fm_pract_id,String to_pract_id ,String p_gender,String fm_preferred_date, String fs_locn_code,String print_pull_list_type,String appl_user_id,String order_by_pull_list,String print_tel_no, String print_bar_code,String p_order_term ,String p_pull_list_seq )
{
	//java.io.PrintWriter out = null;
	try
	{
	
	
	//	out = res.getWriter();
		String 	rs_report_id = p_report_id;	
		String ReportOutput = "";
       	String fm_preferred_date1="";			
				if(fm_preferred_date!=null){
					
					fm_preferred_date1=fm_preferred_date;
					//fm_preferred_date1= DateUtils.convertDate(fm_preferred_date,"DMY","en",locale);
				}else{
					fm_preferred_date1="";
				}

		       ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
				ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport(facility_id,"FM",rs_report_id,"F",fs_locn_code) ;
	        					
				report1.addParameter( "p_facility_id",facility_id ) ;
				report1.addParameter("p_user_name",user_id);
				report1.addParameter("p_report_id",rs_report_id);
				report1.addParameter("p_fm_nursing_unit_code",fm_nursing_unit_code);
				report1.addParameter("p_to_nursing_unit_code",to_nursing_unit_code);
				report1.addParameter("p_fm_pract_id",fm_pract_id);
				report1.addParameter("p_to_pract_id",to_pract_id);
				report1.addParameter("p_gender",p_gender);
				report1.addParameter("p_preferred_date",fm_preferred_date1);
				report1.addParameter("p_module_id","FM");
				report1.addParameter("p_src_fs_locn_code",fs_locn_code);
				report1.addParameter("p_status",print_pull_list_type);
				report1.addParameter("P_PULL_LIST_TYPE",print_pull_list_type);
				report1.addParameter("p_appl_user_id",appl_user_id);
		        report1.addParameter("p_call_from","GENERATE_IP_PULLING_LIST");	
		        report1.addParameter("ORDER_BY",order_by_pull_list);				
				report1.addParameter("P_T_NAME","FM_PULLING_LIST");				
				report1.addParameter("p_print_tel_no",print_tel_no);				
				report1.addParameter("print_bar_code",print_bar_code);				
				report1.addParameter("p_order_term",p_order_term);
				report1.addParameter("P_LANGUAGE_ID",locale);
				report1.addParameter("p_pull_list_seq",p_pull_list_seq);
				onlineReports.add( report1) ;
				ReportOutput = onlineReports.execute( req, res ); 			
							
						
						}
	catch ( Exception e )
	{
		e.printStackTrace();
	}	
}	

%>	
<%	} else if(flag.equals("AutoTrackouttoIPW"))
		{
    	   String fm_preferred_date1="";
			
			
			from_nursing_unit			=	request.getParameter("from_nursing_unit");
		    to_nursing_unit			=	request.getParameter("to_nursing_unit");
		   login_facility_id			=	request.getParameter("login_facility_id");
			login_user_id			=	request.getParameter("login_user_id");
		    p_fm_pract_id			=	request.getParameter("p_fm_pract_id");
			p_to_pract_id			=	request.getParameter("p_to_pract_id");
			preferred_date			=	request.getParameter("preferred_date");
		    fs_locn_code	= request.getParameter("fs_locn_code");	

			 if (from_nursing_unit==null || from_nursing_unit.equals("null"))
			{
				from_nursing_unit="";
			}

			if (to_nursing_unit==null || to_nursing_unit.equals("null"))
			{
				to_nursing_unit="";
			}	
			
			  if (login_facility_id==null || login_facility_id.equals("null"))
			{
				login_facility_id="";
			}

			if (login_user_id==null || login_user_id.equals("null"))
			{
				login_user_id="";
			}	
			
			 
			  if (p_fm_pract_id==null || p_fm_pract_id.equals("null"))
			{
				p_fm_pract_id="";
			}

			if (p_to_pract_id==null || p_to_pract_id.equals("null"))
			{
				p_to_pract_id="";
			}	
			 
				
				 if (preferred_date != null)
					{
						
					fm_preferred_date1=preferred_date;	//fm_preferred_date1=DateUtils.convertDate(preferred_date,"DMY","en",locale);
					}

					ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;

					ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( login_facility_id, "FM","FMBATRCI") ;
					report1.addParameter( "p_facility_id",	login_facility_id ) ;
					report1.addParameter("p_user_name",login_user_id);
					report1.addParameter("p_report_id","FMBATRCI");
					report1.addParameter("p_fm_nursing_unit_code",from_nursing_unit);
					report1.addParameter("p_to_nursing_unit_code",to_nursing_unit);
					report1.addParameter("p_fm_pract_id",p_fm_pract_id);
					report1.addParameter("p_to_pract_id",p_to_pract_id);
					report1.addParameter("p_gender","A");
					report1.addParameter("p_preferred_date",fm_preferred_date1);
					report1.addParameter("p_module_id","FM");
					report1.addParameter("P_T_NAME","FM_IP_AUTO_TRACK_LOG");	
					report1.addParameter("p_call_from","AUTO_TRACK");
					report1.addParameter("p_src_fs_locn_code",fs_locn_code);
					onlineReports.add( report1) ;

					String ReportOutput = onlineReports.execute( request, response );
				
		        } else  if(flag.equals("Confirm IP Pulling List"))  
	               {
		              
		  String p_fs_locn_code1="";
		 user_id			=	(String)session.getValue("login_user");
		p_gender			= request.getParameter("p_gender");
		p_fm_nursing_unit_code	= request.getParameter("p_fm_nursing_unit_code");
		p_to_nursing_unit_code	= request.getParameter("p_to_nursing_unit_code");
		p_fm_pract_id		= request.getParameter("p_fm_pract_id");
		p_to_pract_id		= request.getParameter("p_to_pract_id");
		p_preferred_date			= request.getParameter("p_preferred_date");
		print_pulled_list	= request.getParameter("print_pulled_list");
		print_tracer_card	= request.getParameter("print_tracer_card");
		p_fs_locn_code1		= request.getParameter("fs_locn_code");
		appl_user_id		= request.getParameter("appl_user_id");
		p_pull_list_no  = request.getParameter("p_pull_list_no");
		
		if (p_gender==null)
		{
			p_gender="";
		}
		if (p_pull_list_no==null)
		{
			p_pull_list_no="";
		}
		
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
		if (p_fs_locn_code1==null)
		{
			p_fs_locn_code1="";
		}
		  
			if (print_pulled_list.equals("Y"))
				{
	doOnlineReportPrinting(request,response,"FMBMRPLI",locale,facility_id,user_id,p_fm_nursing_unit_code,p_to_nursing_unit_code,p_fm_pract_id,p_to_pract_id,p_gender,p_preferred_date,p_pull_list_no,p_fs_locn_code1,appl_user_id);
				}

				if (print_tracer_card.equals("Y"))
				{
					doOnlineReportPrinting(request,response,"FMBIPTRC",locale,facility_id,user_id,p_fm_nursing_unit_code,p_to_nursing_unit_code,p_fm_pract_id,p_to_pract_id,p_gender,p_preferred_date,p_pull_list_no,p_fs_locn_code1,appl_user_id);
				}  %>
		 
		  <%!
      public synchronized void doOnlineReportPrinting( HttpServletRequest req, HttpServletResponse res,String p_report_id, String locale,String facility_id,String user_id,String p_fm_nursing_unit_code,String p_to_nursing_unit_code,String p_fm_pract_id,String p_to_pract_id ,String p_gender,String p_preferred_date, String p_pull_list_no,String p_fs_locn_code1,String appl_user_id)
 {
	//java.io.PrintWriter out = null;
	try
	{
	//	out = res.getWriter();		

		String 	rs_report_id = p_report_id;
		String ReportOutput="";
		String p_preferred_date_new="";
		         if (p_preferred_date != null)
					{
						
					p_preferred_date_new=p_preferred_date;	//p_preferred_date_new=DateUtils.convertDate(p_preferred_date,"DMY","en",locale);
					}
				 
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
				report1.addParameter("p_preferred_date",p_preferred_date_new);
				report1.addParameter("p_pull_list_no",p_pull_list_no);
			    report1.addParameter("p_module_id","FM");
				report1.addParameter("P_SRC_FS_LOCN_CODE",p_fs_locn_code1);
				report1.addParameter("p_appl_user_id",appl_user_id);
				report1.addParameter("p_call_from","CONFIRM_PULLING_LIST");
				report1.addParameter("P_T_NAME","FM_IP_PULLING_LIST");	
				report1.addParameter("P_LANGUAGE_ID",locale);
				onlineReports.add( report1) ;
		      ReportOutput = onlineReports.execute( req, res );
	 	}
	catch ( Exception e )
	{
		e.printStackTrace();
	}
} %>
	
	<%	  }
		  else{
	  	stmt		=	con.createStatement();
		sql = "select pull_list_gen_by_gender from fm_parameter where facility_id = '"+facility_id+"'";
		rs = stmt.executeQuery(sql);
		if (rs!=null)
		{
          if (rs.next())
			pull_list_gen_by_gender = rs.getString(1);
		}
	if(rs != null)		rs.close();
	
		sql			=	"select status,male_pull_list_type, female_pull_list_type, unknown_pull_list_type from fm_ip_pulling_list_ctl where facility_id='"+facility_id+"' and src_fs_locn_code = '"+p_fs_locn_code+"' and trunc(preferred_date)=to_date('"+p_preferred_date+"','dd/mm/rrrr') and nursing_unit_code between nvl('"+p_fm_nursing_unit_code+"','!') and nvl('"+p_to_nursing_unit_code+"','~')  " ;
	
		rs = stmt.executeQuery(sql);
		if (rs!=null)
		{
			while (rs.next())
			{
				p_status				 = rs.getString("status");
				p_male_pull_list_type	 = rs.getString("male_pull_list_type");
				p_female_pull_list_type	 = rs.getString("female_pull_list_type");
				p_unknown_pull_list_type = rs.getString("unknown_pull_list_type");
				if (p_status==null) p_status="";
				if (p_male_pull_list_type==null) p_male_pull_list_type="";
				if (p_female_pull_list_type==null) p_female_pull_list_type="";
				if (p_unknown_pull_list_type==null) p_unknown_pull_list_type="";

					if (p_status.equals("T"))
					{
						p_T_status_cnt++;
					}
					else if (p_status.equals("S") || p_status.equals("M"))
					{
                       if (p_status.equals("M")) p_M_status_cnt++;
					   else
						p_S_status_cnt++;
						p_MS_status_cnt++;
                        if (p_male_pull_list_type.equals("M")) p_male_main_cnt++;
						else p_male_supp_cnt++;
                        if (p_female_pull_list_type.equals("M")) p_female_main_cnt++;
						else p_female_supp_cnt++;
                        if (p_unknown_pull_list_type.equals("M")) p_unknown_main_cnt++;
						else p_unknown_supp_cnt++;

					}
				p_total_cnt++;
			}
		}
		if (p_total_cnt==0)
		{
			p_total_cnt=1;
		}
		if (p_total_cnt == p_T_status_cnt)
		{
		%>
		<script>			
		var msg1 = getMessage("FILES_ALREADY_TRACKED","FM");
		parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg1+"&err_value=0";
		</script>
		<%
		}
		else if (p_MS_status_cnt > 0)
		{
		 if (p_pull_type.equals("M"))
			alert_flag = "M";
	
		}
		else if (p_MS_status_cnt == 0)
		{
		 if (p_pull_type.equals("S"))
			alert_flag = "S";

		}
		if (pull_list_gen_by_gender.equals("Y"))
		{
			if (!p_gender.equals("A")&&p_pull_type.equals("M")){
				alert_flag="";
				if (p_gender.equals("M")){
					if (p_male_main_cnt>0) alert_flag = "M";
				}
				else if (p_gender.equals("F")){
					if (p_female_main_cnt>0) alert_flag = "M";
				}
				else if (p_gender.equals("U")){
					if (p_unknown_main_cnt>0) alert_flag = "M";
				}
			}
			if (!p_gender.equals("A")&& p_pull_type.equals("S")){
				alert_flag="";
				if (p_gender.equals("M")){
					if (p_male_main_cnt==0) alert_flag = "S";
				}
				else if (p_gender.equals("F")){
					if (p_female_main_cnt==0) alert_flag = "S";
				}
				else if (p_gender.equals("U")){
					if (p_unknown_main_cnt==0) alert_flag = "S";
				}
			}
		}
		if (alert_flag.equals("M")){
			 %>
			   <script>
				alert(getMessage("PULL_LIST_GEN_FOR_MAIN","FM"));
			    parent.frames[1].frames[1].document.forms[0].print_pull_list_type.value="S";
			    parent.frames[1].frames[1].document.forms[0].print_pull_list_type.focus();
				parent.frames[1].frames[1].document.forms[0].generate.disabled=false;
				parent.frames[1].frames[1].document.getElementById("calend").style.display="inline";
				parent.frames[1].frames[1].document.getElementById("calend").style.visibility="visible";
				parent.frames[1].frames[1].document.forms[0].fm_preferred_date.readOnly=false;
			   </script>
			 <%
			}
			else if (alert_flag.equals("S")){
				 %>
				   <script>
					alert(getMessage("PULL_LIST_NOT_GEN_FOR_MAIN","FM"));
					parent.frames[1].frames[1].document.forms[0].print_pull_list_type.value="M";
				    parent.frames[1].frames[1].document.forms[0].print_pull_list_type.focus();
					parent.frames[1].frames[1].document.forms[0].generate.disabled=false;
					parent.frames[1].frames[1].document.getElementById("calend").style.display="inline";
					parent.frames[1].frames[1].document.forms[0].fm_preferred_date.readOnly=true;
					parent.frames[1].frames[1].document.forms[0].fm_preferred_date.value=parent.frames[1].frames[1].document.forms[0].to_appt_date_disp.value;
				   </script>
				 <%
			}   else
			{
             %>
			   <script>
				parent.parent.frames[2].commontoolbarFrame.location.href ='../../eCommon/html/process.html';
				parent.frames[1].frames[1].document.forms[0].method='post';		
			    parent.frames[1].frames[1].document.forms[0].action='../../servlet/eFM.FMIPGeneratePullingListServlet';
				parent.frames[1].frames[1].document.forms[0].target=parent.frames[2].name;
				parent.frames[1].frames[1].document.forms[0].submit();
			 </script>
			 <%
			}

%>
	</form>		
	</body>
	</html>	
<%}
	if(rs != null)		rs.close();		
	if(stmt != null)stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

