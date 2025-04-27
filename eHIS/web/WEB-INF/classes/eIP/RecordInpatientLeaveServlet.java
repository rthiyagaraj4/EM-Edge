/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.rmi.*;
import com.ehis.util.*;
import eIP.IPRecordInpatientLeave.*;

public class RecordInpatientLeaveServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;
Properties p;
String sStyle;
String from_date;
String to_date;
String remarks;
String releasebed;
String practid;
String strPatientId ;
String facilityId ;
String client_ip_address ; 
String error			= "";
String eid ;
String srl_no = "" ;
String record_status	= "" ;
String leave_pass		= "";
String nursingunit		= "";
String room_no		= "";
String bedno		= "";
String specialtycode		= "";
String bed_class_code		= "";
String service_code		= "";
String bed_type_code		= "";
String patient_id		= "";
String locale			= "";
String userName			= "";

public void init(ServletConfig config) throws ServletException	
{
	super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
throws javax.servlet.ServletException,IOException
{
	try	
	{

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

		this.out = res.getWriter();
		String url = "../eCommon/jsp/commonToolbar.jsp?" ;
		String params = req.getQueryString() ;
		String source = url + params ;

		HttpSession session = req.getSession(false);
		sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
		// commented below line for Edge tech refresh work by VEDESH A D
		//out.println("<!DOCTYPE html><html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../eOP/js/PClinic.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
	
	}catch(Exception e)	{e.printStackTrace();}

	HttpSession session = req.getSession(false);
	this.p = (Properties) session.getValue( "jdbc" ) ;
	this.facilityId = (String) session.getValue( "facility_id" ) ;
	client_ip_address = p.getProperty("client_ip_address");
	locale = p.getProperty("LOCALE");
	userName			= p.getProperty( "login_user" ) ;
	try 
	{ 
		insertRecordInpatientLeave(req);
	}catch (Exception e) 
	{
		e.printStackTrace();
	}
}


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}


private void insertRecordInpatientLeave(HttpServletRequest req)	
{
	try 
	{
		eid						= checkForNull(req.getParameter( "encounterid" ));
		srl_no						= checkForNull(req.getParameter( "srl_no" ));
		from_date				= checkForNull(req.getParameter("fromdate"));
		from_date = DateUtils.convertDate(from_date,"DMYHM",locale,"en");
		
		to_date					= checkForNull(req.getParameter("todate"));
		to_date = DateUtils.convertDate(to_date,"DMYHM",locale,"en");
		
		remarks					= checkForNull(req.getParameter("Remarks"));
		releasebed				= checkForNull(req.getParameter("release_bed"),"N");
		practid					= checkForNull(req.getParameter("practid"));
		record_status			= checkForNull(req.getParameter("record_status"));
		nursingunit				= checkForNull(req.getParameter("nursing_unit"));

		patient_id				= checkForNull(req.getParameter("patient_id"));
		bed_class_code				= checkForNull(req.getParameter("bed_class_code"));
		bed_type_code				= checkForNull(req.getParameter("bed_type_code"));
		service_code				= checkForNull(req.getParameter("service_code"));
		room_no				= checkForNull(req.getParameter("room_no"));
		bedno				= checkForNull(req.getParameter("bedno"));
		specialtycode				= checkForNull(req.getParameter("specialtycode"));
		

		strPatientId			= checkForNull(req.getParameter("hdnPatientId"));


		String informed_date	= checkForNull(req.getParameter("informed_date"));
		informed_date = DateUtils.convertDate(informed_date,"DMYHM",locale,"en");

		HashMap hashData = new HashMap();
		hashData.put("from_date",from_date);
		hashData.put("to_date",to_date);
		hashData.put("remarks",remarks);
		hashData.put("releasebed",releasebed);
		hashData.put("practid",practid);
		hashData.put("overrideyn",checkForNull(req.getParameter("overrideyn")));
		hashData.put("encounterid",eid);
		hashData.put("srl_no",srl_no);
		hashData.put("facilityId",facilityId);
		hashData.put("client_ip_address",client_ip_address);
		hashData.put("pseudobed",checkForNull(req.getParameter("pseudo_bed")));
		hashData.put("nursingunit",nursingunit);
		hashData.put("service_code",service_code);
		hashData.put("room_no",room_no);
		hashData.put("bedno",bedno);
		hashData.put("specialtycode",specialtycode);
		hashData.put("bed_class_code",bed_class_code);
		hashData.put("bed_type_code",bed_type_code);
		hashData.put("patient_id",patient_id);
		hashData.put("generatepseudobed",checkForNull(req.getParameter("generate_pseudo_bed")));
		hashData.put("record_status",record_status);
		hashData.put("reported_to",checkForNull(req.getParameter("reported_to")));
		hashData.put("informed_to",checkForNull(req.getParameter("inform_to")));
		hashData.put("informed_name",checkForNull(req.getParameter("informed_name")));
		hashData.put("informed_date",informed_date);
		hashData.put("pol_rep_no",checkForNull(req.getParameter("pol_rep_no")));
		hashData.put("pol_stn_id",checkForNull(req.getParameter("pol_stn_id")));
		hashData.put("pol_id",checkForNull(req.getParameter("pol_id")));
		hashData.put("setup_bl_dtls_in_ip_yn",checkForNull(req.getParameter("setup_bl_dtls_in_ip_yn")));
		hashData.put("peudobed_val",checkForNull(req.getParameter("hdd_peudobed_val")));
		hashData.put("deactivate_pseudoBed",checkForNull(req.getParameter("deactivate_pseudoBed")));
		hashData.put("patient_class",checkForNull(req.getParameter("patient_class")));
		hashData.put("admission_date_time",checkForNull(req.getParameter("admdate")));
		hashData.put("release_reserve_bed_yn",checkForNull(req.getParameter("release_reserve_bed_yn")));
		/*hashData.put("reserve_nursing_unit_code",checkForNull(req.getParameter("reserve_nursing_unit_code")));
		hashData.put("reserve_room_no",checkForNull(req.getParameter("reserve_room_no")));
		hashData.put("reserve_bed_no",checkForNull(req.getParameter("reserve_bed_no")));*/
		hashData.put("no_of_record",checkForNull(req.getParameter("no_of_record")));

		boolean local_ejbs = false;

		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPRecordInpatientLeave",IPRecordInpatientLeaveManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = hashData;
		
		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = hashData.getClass();

		HashMap results = (HashMap)(busObj.getClass().getMethod("insertRecordInpatientLeave",paramArray)).invoke(busObj,argArray);
		
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		 boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		 error = (String) results.get("error");
		if ( inserted )
		{
			error = (String) results.get("message") ;

			
			if(error.indexOf("<br>")!=-1)
			{
				error = error.substring(0,error.indexOf("<br>"));
			}
			
				

			if(record_status.equals("01"))
			{
				leave_pass = "leave";			
			}
			else
			if(record_status.equals("02"))
			{
				leave_pass = "abscond";
			}
			doOnlineReports(eid, nursingunit);
			out.println("<script>alert('"+error+"');</script>");
			out.println("<script>top.window.document.getElementById('dialog_tag').close();</script>");
		}
		 else
		{
			if(error.indexOf("Exception") == -1)
			{
				out.println("<script>parent.frames[1].document.recordinpatientleave_form.confirm.disabled = false;</script>");
			}
			 if(error.indexOf("<br>")!=-1)
				error = error.substring(0,error.indexOf("<br>"));
			 out.print("<script>alert("+error+")</script>");
		}
		hashData.clear();
		results.clear();
	} catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	private void doOnlineReports(String encounter_id,String nursing_unit) throws ServletException, IOException, SQLException
    {
	    String sqlString = "";		
		String clinic_type = "N";

		if(leave_pass.equals("leave"))
		{
		sqlString = "SELECT report_id , report_desc report_desc,  1 no_of_copies,module_id FROM SM_REPORT_LANG_VW  b  WHERE  language_id='"+locale+"' and module_id = 'IP' AND report_id = 'IPBLVPAS'";
		}
		else
		if(leave_pass.equals("abscond"))
		{
		sqlString = "SELECT report_id , report_desc report_desc,  1 no_of_copies,module_id FROM SM_REPORT_LANG_VW b  WHERE language_id='"+locale+"' and module_id = 'IP' AND report_id = 'IPBABNOT'";
		}

		String reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id,p_user_name";
		String reportParamValues = ""+encounter_id+","+nursing_unit+","+clinic_type+","+strPatientId+","+userName+" ";

		StringBuffer htmlFor = new StringBuffer();
		htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
		htmlFor.append("</head><body class='message'>");
		htmlFor.append("var dialogHeight    = '25' ;");
		htmlFor.append("var dialogWidth = '65' ;");
		htmlFor.append("var dialogTop = 58;" );
		htmlFor.append("var arguments	=	''; ");
		//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
		htmlFor.append("  var getUrl		=	'../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=RECORD_LEAVE&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&EncounterId="+encounter_id+"&dest_locn_type="+clinic_type+"&dest_locn_code="+nursing_unit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
		htmlFor.append(" var features    = 		'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
		htmlFor.append("  retVal			=	window.showModalDialog(getUrl,arguments,features); top.window.document.getElementById('dialog_tag').close();");
		htmlFor.append(" </script>"  );
		out.println(htmlFor.toString()); 
		out.println("</body></html>");
	}

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
