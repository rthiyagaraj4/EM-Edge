/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import com.ehis.util.*;

import webbeans.eCommon.*;
import webbeans.eFM.*; 
import eFM.FMIssueFiles.* ;

import java.net.URLEncoder;

//public class  extends javax.servlet.http.HttpServlet	

public class FMIssueFilesServlet extends HttpServlet implements SingleThreadModel
{
	HttpSession	session		= null;
    java.io.PrintWriter out	= null;
    java.util.Properties p	= null;

	Connection	connection	=	null;
	ResultSet	rs			=	null;
	Statement stmt			=	null;	

	String p_file_no			= "!";
	String p_curr_facility_id	= "!";
	String print_tracer_card	= "";
	String sql9					= "";
	String p_iss_no				= "";
	String sys_date				= "";
	String locale			= "" ;
    
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
        throws javax.servlet.ServletException,IOException
	{
		try 
		{
				
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			this.out = response.getWriter();
            insertIssueFiles(request,response);
			
		}catch(Exception e){
		out.println("Exception@Servlet:1 : "+e);}
    }
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try	
		{
						
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			out.println ("<html><head>");
			out.println ("<link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'></link>");
			out.println ("<body class='MESSAGE'>");
		}catch(Exception e){
		out.println("Exception in doGet method : "+e);}
	}
	private void insertIssueFiles(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
	{
		response.setContentType("text/html");
		webbeans.eFM.FMFilesIssueCart issueFilesCart = null;
		HashMap htIssueFiles	  =	new java.util.HashMap();

		String curr_facility_id	  =	"";
		String login_user_id	  = "";
		String client_ip_address = "";
		String retdate = "";
		String Patient_Id= "";
		try
        {			
			connection			=	ConnectionManager.getConnection(request);			
			session				=	request.getSession(false);
			p					=	(java.util.Properties) session.getValue( "jdbc" ) ;
			locale = p.getProperty("LOCALE");
			curr_facility_id	=	(String) session.getValue("facility_id");
			login_user_id		=	(String) session.getValue("login_user");
            client_ip_address  =	p.getProperty("client_ip_address");
			String fileCount	=	request.getParameter("fileCount");			
			if (fileCount==null) fileCount = "0";
			int recCount = Integer.parseInt(fileCount);
			
			
			if(recCount == 1)
			  Patient_Id=checkForNull(request.getParameter("Patient_Id"));
			else
			  Patient_Id="";

	        
			String doc_or_file	=	request.getParameter("doc_or_file");
			
			String isCurrentFsLocation=checkForNull(request.getParameter("isCurrentFsLocation")); //Added for this CRF HSA-CRF-0306.1
			String current_date=checkForNull(request.getParameter("sys_date")); //Added for this CRF HSA-CRF-0306.1
			
			stmt = connection.createStatement();

			sql9 = "select '"+curr_facility_id+"' || FM_ISS_HDR_SEQ1.nextval p_iss_no,TO_CHAR(SYSDATE,'DD/MM/YYYY')sys_date from dual" ;
			rs	 = stmt.executeQuery(sql9);
			while(rs.next())
			{
				p_iss_no = rs.getString("p_iss_no");
				sys_date = rs.getString("sys_date");
			} if(rs != null) rs.close();		

			ArrayList newArrayListTransMode = new ArrayList();
			for (int i=0; i<recCount;i++ )
			{
				retdate=checkForNull(request.getParameter("file_transport_mode"+i));
				newArrayListTransMode.add(retdate);
			}
			ArrayList newArrayListCarried = new ArrayList();
			for (int i=0; i<recCount;i++ )
			{
				newArrayListCarried.add(checkForNull(request.getParameter("carried_by_name"+i)));
			}
			ArrayList newArrayListRetDate = new ArrayList();
			for (int i=0; i<recCount;i++ )
			{
				newArrayListRetDate.add(checkForNull(request.getParameter("retdate"+i)));
			}
			
			/*Below line added for this CRF HSA-CRF-0306.1*/
			ArrayList newArrayListreturndatehidden= new ArrayList();
			for (int i=0; i<recCount;i++ )
			{ 
			   newArrayListreturndatehidden.add(checkForNull(request.getParameter("return_date"+i)));
			} 
			
			ArrayList newArrayListreturncriteria= new ArrayList();
			for (int i=0; i<recCount;i++ )
			{ 
			   newArrayListreturncriteria.add(checkForNull(request.getParameter("fslocn_return_criteria"+i)));
			} 
			
			ArrayList newArrayListdischargedatetime= new ArrayList();
			for (int i=0; i<recCount;i++ )
			{ 
			   newArrayListdischargedatetime.add(checkForNull(request.getParameter("dischargedatetime"+i)));
			}
						
			//End HSA-CRF-0306.1
			
			issueFilesCart = (webbeans.eFM.FMFilesIssueCart) session.getValue("FMIssueFilesCartBean"); // Changes Modified against Incident Number 28306 By Saanthaakumar Dated on 18-06-2012
			print_tracer_card	= request.getParameter("p_tracer_card_yn");
			if(print_tracer_card==null)	{ print_tracer_card = "N"; }

			htIssueFiles.put ( "curr_facility_id",	curr_facility_id );
			htIssueFiles.put ( "login_user_id", login_user_id	);
			htIssueFiles.put ( "addedAtWorkstation", client_ip_address	);
			htIssueFiles.put ( "p_iss_no", p_iss_no	);
			htIssueFiles.put ( "doc_or_file", doc_or_file	);
			htIssueFiles.put ( "locale", locale	);
			htIssueFiles.put ("isCurrentFsLocation", isCurrentFsLocation);
			htIssueFiles.put ("current_date", current_date); //Added for this CRF HSA-CRF-0306.1
		
			boolean inserted = false;
			boolean flag = false;
			String error_msg = "";
			String p_patient_id_old = "";

			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			
			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMIssueFiles",FMIssueFilesHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[9];
			argArray[0] = p;
			argArray[1] = htIssueFiles;
			argArray[2] = issueFilesCart;
			argArray[3] = newArrayListTransMode;
			argArray[4] = newArrayListCarried;
			argArray[5] = newArrayListRetDate;
			
			/*Below line added for this CRF HSA-CRF-0306.1*/
			argArray[6] = newArrayListreturndatehidden;			
			argArray[7] = newArrayListreturncriteria;
			argArray[8] = newArrayListdischargedatetime;
			
			Class [] paramArray = new Class[9];
			paramArray[0] = p.getClass();
			paramArray[1] = htIssueFiles.getClass();
			paramArray[2] = issueFilesCart.getClass();
			paramArray[3] = newArrayListTransMode.getClass();
			paramArray[4] = newArrayListCarried.getClass();
			paramArray[5] = newArrayListRetDate.getClass();
			
			/*Below line added for this CRF HSA-CRF-0306.1*/
			paramArray[6] = newArrayListreturndatehidden.getClass();			
			paramArray[7] = newArrayListreturncriteria.getClass();
			paramArray[8] = newArrayListdischargedatetime.getClass();
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("createIssueFiles",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			inserted	=	(((Boolean) results.get( "status" )).booleanValue()) ;

			// Below code added for the icn:19419 Date:Thursday, February 18, 2010

			flag	=	(((Boolean) results.get( "flag" )).booleanValue()) ;
			
			error_msg	=	(String)	results.get("error") ;	
			if(flag==true)
				p_patient_id_old	=	"" ;	
			else
				p_patient_id_old	=	(String)	results.get("p_patient_id_old") ;	

			// end here

			
			String error_value = "0" ;
			newArrayListTransMode.clear();
			newArrayListCarried.clear();
			newArrayListRetDate.clear();
			newArrayListreturndatehidden.clear();
			htIssueFiles.clear();
			issueFilesCart = null;
			results.clear();
			session.removeAttribute("FMIssueFilesCartBean");// Changes Modified against Incident Number 28306 By Saanthaakumar Dated on 18-06-2012
           
			if(inserted)
			{
				error_value = "1";		
				if (print_tracer_card.equals("Y"))
				{
					 
					doOnlineReportsSec(sys_date,p_iss_no, login_user_id,curr_facility_id,locale,p_patient_id_old);
				}
			} 
			else
			{
				out.println("<script>alert('"+error_msg+"');window.close();</script>");
			}
			
			out.println("<Script>parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+ java.net.URLEncoder.encode( error_msg,"UTF-8" )+"&err_value="+error_value+"';</script>");
			if(stmt!=null)  stmt.close();
			/*		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;

					ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( curr_facility_id, "FM","FMBISSCD") ;
					report1.addParameter("p_facility_id",curr_facility_id) ;
					report1.addParameter("p_user_name",login_user_id);
					report1.addParameter("p_report_id","FMBISSCD");
					report1.addParameter("p_iss_no",p_iss_no);
					report1.addParameter("p_appt_date",sys_date);									
					report1.addParameter("p_module_id","FM");
					onlineReports.add( report1) ;

					String ReportOutput = onlineReports.execute( request, response );
				}
			}
			p_file_no			= "!";
			p_curr_facility_id  = "!";
			
			out.println("<Script>parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+ java.net.URLEncoder.encode( error_msg,"UTF-8" )+"&err_value="+error_value+"';</script>");
			*/
			
		} 
		catch(Exception e)
		{
			out.println("Exception@Insert: "+e);
			out.println(e.toString());
			e.printStackTrace();
		} 
		finally
		{			
			ConnectionManager.returnConnection(connection, request);		
		}
    } // end of method insertIssueFiles
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	private void doOnlineReportsSec( String p_appt_date, String p_iss_no, String p_user_name, String p_facility_id, String locale , String Patient_Id)
        throws ServletException, IOException, SQLException
    {	
		
		StringBuffer sqlString=new StringBuffer();
        String sql = " select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'FM' AND REPORT_ID = 'FMBISSCD'";   
        String repParamNames = "p_appt_date,p_facility_id,p_user_name,p_iss_no";
        String repParamValues = p_appt_date + "," + p_facility_id+","+p_user_name+","+p_iss_no;
        sqlString = sqlString.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
        sqlString.append( "<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body class='message'>");
		sqlString.append("<script language = 'JavaScript'>");
        sqlString.append("var message = 'APP-SM0002 Operation Completed Successfully';");
        sqlString.append( "  var dialogHeight    = '30' ;");
        sqlString.append(" var dialogWidth = '70' ;");
        sqlString.append( "var dialogTop = '65';");
        sqlString.append( "  var arguments =   ''; ");
        sqlString.append("  var getUrl        =   '../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString=" + URLEncoder.encode(sql) + "&reportParamNames=" + repParamNames + "&reportParamValues=" +repParamValues+"&Patient_ID="+Patient_Id+"';");
		sqlString.append( " var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;';");
        sqlString.append( "  retVal            =   window.showModalDialog(getUrl,arguments,features); ");	
		sqlString.append( "window.close(); </script>");
        out.println(sqlString.toString());
		sqlString.setLength(0);
    }//method

} // end of class FMIssueFilesServlet 
