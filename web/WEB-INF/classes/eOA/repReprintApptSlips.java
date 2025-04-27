/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA ;


import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
//import java.util.*;

public class repReprintApptSlips extends javax.servlet.http.HttpServlet{

PrintWriter out;

HttpSession session;
String p_report_id;
String p_module_id;
String p_facility_id;
String appt_ref_str;
String clinic_code_str;
String P_RESOURCE_CLASS;
String P_LOCATION_TYPE;
String p_language_id;



int i=0;
String ReportOutput="";

public void init(ServletConfig config) throws ServletException	{
	super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
	try {
		this.out = res.getWriter();
		doReportPrinting(req, res);

	}
	catch (Exception e)	{
		//out.println(e.toString());
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}
}

public void doReportPrinting( HttpServletRequest req, HttpServletResponse res)
{
	try
	{
		
		//p_user_name=req.getParameter( "p_user_name" ) ;
		P_RESOURCE_CLASS=req.getParameter( "P_RESOURCE_CLASS" ) ;
		if(P_RESOURCE_CLASS ==null) P_RESOURCE_CLASS="";
		P_LOCATION_TYPE=req.getParameter( "P_LOCATION_TYPE" ) ;
		if(P_LOCATION_TYPE ==null) P_LOCATION_TYPE="";
		p_report_id=req.getParameter("p_report_id");
		p_module_id=req.getParameter("p_module_id");
		p_facility_id=req.getParameter("p_facility_id");
		p_language_id=req.getParameter("p_language_id");
		appt_ref_str=req.getParameter("p_appt_ref_no");
		clinic_code_str=req.getParameter("p_clinic_code"); 

		StringTokenizer st1 = new StringTokenizer(appt_ref_str,",");
		StringTokenizer st2 = new StringTokenizer(clinic_code_str,",");
		String p_appt_ref_no[]=new String[st1.countTokens()];
		String p_clinic_code[]=new String[st2.countTokens()];
		
		i = st1.countTokens();

		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		
		for(int j=0; j<i; j++) {
		   	p_appt_ref_no[j] = st1.nextToken();
			p_clinic_code[j] =  st2.nextToken();					   	
			
		    ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( p_facility_id, p_module_id, p_report_id,P_LOCATION_TYPE,p_clinic_code[j],p_language_id);
		    report1.addParameter( "p_facility_id",	p_facility_id ) ;
			report1.addParameter( "p_appt_ref_no",p_appt_ref_no[j]) ;
		    report1.addParameter("p_module_id",p_module_id);
			report1.addParameter("p_report_id",p_report_id);
			report1.addParameter( "P_LOCATION_TYPE",	P_LOCATION_TYPE ) ;
			report1.addParameter( "P_CLINIC_CODE",	p_clinic_code[j] ) ;
		    report1.addParameter( "p_language_id",	p_language_id ) ;


		    onlineReports.add( report1) ;
		    
	    }
		session.putValue("online_reports", onlineReports) ;
	    ReportOutput = onlineReports.execute( req, res );
		res.sendRedirect("../eOA/jsp/oaprinterror.jsp?err_num=" + java.net.URLEncoder.encode( ReportOutput,"UTF-8" ) );

	}
	catch ( Exception e )
	{
		e.printStackTrace();
		//out.println("Encountered error while Processing Online Reports "+e.toString());
	}

} // END OF THE METHOD........


}//end of class 

