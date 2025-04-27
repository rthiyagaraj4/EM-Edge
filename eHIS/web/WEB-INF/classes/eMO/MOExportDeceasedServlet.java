/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import eCommon.SingleTabHandler.SingleTabHandlerManagerRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.Date;
import java.util.*;
import com.ehis.util.*;

public class MOExportDeceasedServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;
String patientid ="";
java.util.Properties p;
Timestamp receiveTimestamp=null;
String facilityId ;
String client_ip_address ;
String patid="";
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

public void init(ServletConfig config) throws ServletException
{
	super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
{
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	HttpSession session = req.getSession(false);
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.facilityId = (String) session.getValue( "facility_id" ) ;
	this.client_ip_address = p.getProperty("client_ip_address");
	
	try
	{
		this.out = res.getWriter();
		String operation = "MODIFY";
		
		if ( operation.equals("MODIFY"))
			updateExportDeceased(req, res);

	}
	catch (Exception e)
	{
		out.println(e.toString());
	}
}

public void doGet(HttpServletRequest req, HttpServletResponse res)
throws javax.servlet.ServletException,IOException
{
	try
	{
		req.setCharacterEncoding("UTF-8");
		this.out = res.getWriter();
		res.setContentType("text/html;charset=UTF-8");
		String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = req.getQueryString() ;
		String source = url + params ;

		out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eSM/js/SiteParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
	}
	catch(Exception e)	
	{
		e.printStackTrace();
	}
}


	private void updateExportDeceased(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			String s = p.getProperty("login_user");
            String s1 = dateFormat.format(new Date());
            String s2 = s;
            String s3 = s1;
            String s4 = facilityId;
            String s5 = s4;
            String s6 = client_ip_address;
            String s7 = s6;
            String prnyn = "";
            String exportation_address="";
			String exportation_doc_issued_by="";
			String embassy_certificate_no="";
			String health_officer="";
			String remarks="";
			String designation="";
			String release_letter_frm_embassy_yn= ""; //Added by Mano aganist ML-MMOH-CRF-0738
			
			java.sql.Date date1 = java.sql.Date.valueOf(s3);
			prnyn	 = req.getParameter("prnyn1");
			if(prnyn == null)prnyn = "";
			
			doi	 = req.getParameter("doi");
			patientid	 = req.getParameter("patient_id");
			patid        =  req.getParameter("patid");
			destn	 = req.getParameter("des");
			if(destn == null)destn = "";
			if(doi == null)doi = "";
		    if(patientid == null)patientid = "";
			exportation_address	 = req.getParameter("exportation_address");
			if(exportation_address == null)exportation_address = "";
		   
		   	exportation_doc_issued_by	 = req.getParameter("exportation_doc_issued_by");
			if(exportation_doc_issued_by == null)exportation_doc_issued_by = "";
			embassy_certificate_no	 = req.getParameter("embassy_certificate_no");
			if(embassy_certificate_no == null)embassy_certificate_no = "";
			health_officer =req.getParameter("health_officer");
			if(health_officer == null) health_officer="";
			designation = req.getParameter("designation");
			if(designation == null) designation ="";
			remarks = req.getParameter("remarks");
			if(remarks == null) remarks = "";
			//Below lines added by Mano aganist ML-MMOH-CRF-0738
			release_letter_frm_embassy_yn =(req.getParameter("release_letter_frm_embassy_yn")==null || req.getParameter("release_letter_frm_embassy_yn")=="")? "N":req.getParameter("release_letter_frm_embassy_yn");
			//End of CRF-0738
			locale=p.getProperty("LOCALE");
			doi=DateUtils.convertDate(req.getParameter("doi"),"DMYHM",locale,"en");
			
			HashMap tabdata=new HashMap();
			tabdata.put("exportation_address",exportation_address);	
			tabdata.put("exportation_doc_issued_by",exportation_doc_issued_by);	
			tabdata.put("embassy_certificate_no",embassy_certificate_no);	
			tabdata.put("destination",destn);	
			tabdata.put("EXPT_HEALTH_OFFICER",health_officer);
			tabdata.put("EXPT_HEALTH_OFFICER_DESIG",designation);
			tabdata.put("EXPT_HEALTH_OFFICER_REMARKS",remarks);
			tabdata.put("release_letter_frm_embassy_yn",release_letter_frm_embassy_yn); //Added by Mano aganist ML-MMOH-CRF-0738
			

			StringTokenizer receivetoks = new StringTokenizer (doi," ") ;
			StringTokenizer receivetok1 = new StringTokenizer (receivetoks.nextToken(), "/" ) ;
			String receiveArr[] =new String[3] ;
			for( int q=0;q<3;q++ )
				receiveArr[q] = receivetok1.nextToken() ;
			String time24 = receivetoks.nextToken();
			if(time24.equals("")||(time24==null)) time24="00:00";
			doi = receiveArr[2] +"-"+receiveArr[1]+"-"+ receiveArr[0]+" "+time24+":00"  ;
			receiveTimestamp= Timestamp.valueOf(doi);
			HashMap condflds=new HashMap();
			condflds.put("FACILITY_ID",facilityId);
			condflds.put("REGISTRATION_NO",patientid);
            tabdata.put("modified_by_id", s2);
            tabdata.put("modified_date", date1);
            tabdata.put("modified_facility_id", s5);
            tabdata.put("modified_at_ws_no", s7);
			if(!(doi.equals("")))
			{
				tabdata.put("EXPORTATION_DOC_ISS_DATE",receiveTimestamp);		
			}
			else
			{
				tabdata.put("EXPORTATION_DOC_ISS_DATE","");
			}
			String tabname     = "MO_MORTUARY_REGN";
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tabname;
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tabname.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			error_value = "0" ;
			if ( inserted )
			{
				 error="";
				 error_value = "1" ;
				 
				 doOnlineReports(facilityId,patientid);
				//out.println("<script>alert(getMessage(\"RECORD_MODIFIED\"));</script>");		
			    out.println("<script>parent.msgFrame.location.href='../eCommon/jsp/error.jsp?err_num=&err_value=1'</script>");
				 /*if(prnyn.equals("Y"))
				 {
					doOnlineReports(res,facilityId,patientid,error);
				 }
				 else
				 {
					getMessage
					//out.println("<html><script src='../eCommon/js/messages.js' language='javascript'></script><script>alert(getMessage(\"RECORD_MODIFIED\"));</script></html>");
					//out.println("<script>top.close();</script>") ;
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error) +"&err_value="+error_value );
				 }*/
			}
			else
			{		
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error )+ "&err_value=" + error_value );
			}
		
		tabdata.clear();
		condflds.clear();
		results.clear();
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			
		}
	}
	
	private void doOnlineReports(String facility_id,String registration_no) throws ServletException, IOException, SQLException
    {
		StringBuffer htmlFor =new StringBuffer();
		htmlFor.setLength(0);
		String sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MO' AND REPORT_ID = 'MOBEXDOC'";		
		
	
		String reportParamNames = "p_facility_id,P_FM_REGISTRATION_NO,P_TO_REGISTRATION_NO";
		String reportParamValues = ""+facility_id+","+registration_no+","+registration_no+"";
	     
	    htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
        htmlFor.append("</head><body class='message'> <script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script> ");
        htmlFor.append("<script language = 'JavaScript'>" );
        htmlFor.append( " async function showInternalReport() {var dialogHeight    = '400px' ;");
        htmlFor.append( " var dialogWidth = '700px' ;");
        htmlFor.append( " var dialogTop = '65';" );
        htmlFor.append( " var arguments =   ''; ");
    	// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
        htmlFor.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=MO_EXPORT_OF_DECEASED&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&Patient_ID="+patid+"';");

        htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");

        htmlFor.append(" var retVal   = await window.showModalDialog(getUrl,arguments,features); parent.parent.document.getElementById('dialog_tag').close();} showInternalReport(); ");
        htmlFor.append(" </script>"  );
        out.println(htmlFor.toString());
		htmlFor.setLength(0);
 }
	/*private void doOnlineReports(HttpServletResponse res, String facid,String regno, String error) throws ServletException, IOException, SQLException
	{
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( facid, "MO","MOBEXDOC") ;
		report1.addParameter( "p_facility_id",	facid ) ;
		report1.addParameter("p_registration_no",regno);
		report1.addParameter("p_report_id","MOBEXDOC");
		report1.addParameter("p_curr_facility_id",facid);					
		report1.addParameter("p_module_id","MO");
		onlineReports.add( report1) ;
		
		//out.println("<html><script src='../eCommon/js/messages.js' language='javascript'></script><script>alert(getMessage(\"RECORD_MODIFIED\"));</script></html>");
		//			out.println("<script>top.close();</script>") ;
		res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error) +"&err_value="+error_value );
	}*/
	String destn="";
	String doi="";
	String error_value= "";
	String locale	            = "";
 }
