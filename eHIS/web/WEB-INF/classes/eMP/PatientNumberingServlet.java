/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 12:06 PM PM ******/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCommon.SingleTabHandler.*; 
import webbeans.eCommon.*;

public class PatientNumberingServlet extends javax.servlet.http.HttpServlet	
{
PrintWriter out;
java.util.Properties p;

String patSerGrpCode ;
String longDesc ;
String shortDesc ;
String SchemeId ;
String genPatIdYn;
String prefixReqdYn;
String patNoCtrl ;
String useIdNoYn;
String useFamilyNoWithSfxYn;

String client_ip_address ;
String idType;
String familyNoLinkYn;
String namesInOthLangYn;
String gen_pid_using_alt_id1_rule_yn;
String separator_value;
String separator_position;
String pid_use_alt_id1_or_sys_gen;
String email_appl_yn;
String default_yn;
String associated_pat_ser_code="";
String locale ="";
String bd_year_pat_ser = "";
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
	
	client_ip_address = p.getProperty("client_ip_address");

	try {
		this.out = res.getWriter();
		String operation = req.getParameter("function");
        locale = p.getProperty("LOCALE");
	if ( operation.equals("insert") )
		insertPatientNumber(req, res);
	if ( operation.equals("modify"))
			modifyPatientNumber(req, res);
	}
	catch (Exception e)	{
		out.println(e.toString());
		e.printStackTrace();
		}
	}
public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
	
	Connection con = null;
	try	{
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	this.out = res.getWriter();

	Statement stmt;
	ResultSet rs;
	con = ConnectionManager.getConnection(req);
	stmt = con.createStatement();
	rs = stmt.executeQuery("select patient_no_ctrl from mp_param");


		if ( rs.next()  ) {

					String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
					String params = req.getQueryString() ;
					String source = url + params ;
					//out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/PatientNumbering.js'></script><script language='javascript' src='../eCommon/js/ValidateControl.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
					out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/PatientNumbering.js'></script><script language='javascript' src='../eCommon/js/ValidateControl.js'></script></head><iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='"+source+"' frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe> <iframe name='f_query_add_mod' id='f_query_add_mod' src='../eCommon/html/blank.html' frameborder='0' style='height:83vh;width:100vw'></iframe><iframe name='messageFrame'	id='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder='0' noresize scrolling='auto' style='height:8vh;width:100vw'></iframe></html> ");
					
		}
		else
		{
			java.util.Hashtable message = MessageManager.getMessage( locale, "MP_PARAM_NOT_FOUND","MP" ) ;
			String msg = (String) message.get("message");
			out.println("<script>alert('"+msg+"')</script>");
			out.println("<script>document.location.href='../eCommon/jsp/dmenu.jsp';</script>");
				message.clear();

			
		}

		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();


	}
	catch(Exception e)	{	}
	finally
		{
			if (con != null) ConnectionManager.returnConnection(con,req);
		}
	}
private void modifyPatientNumber(HttpServletRequest req, HttpServletResponse res)	{
	try {
		
		patSerGrpCode = req.getParameter("pat_ser_grp_code") == null ? "" : req.getParameter( "pat_ser_grp_code");		
		longDesc = req.getParameter("long_desc") == null ? "" : req.getParameter("long_desc");		
		shortDesc = req.getParameter("short_desc") == null ? "" : req.getParameter("short_desc");		
		SchemeId = req.getParameter("pat_ser_chk_dig_scheme") == null ? "" : req.getParameter("pat_ser_chk_dig_scheme");		
		genPatIdYn = req.getParameter("gen_pat_id_yn") == null ? "Y" : req.getParameter("gen_pat_id_yn");		
		prefixReqdYn = req.getParameter("prefix_reqd_yn") == null ? "N" : req.getParameter("prefix_reqd_yn");	patNoCtrl = req.getParameter("pat_no_ctrl")== null ? "Z" : req.getParameter("pat_no_ctrl");	
		familyNoLinkYn = req.getParameter("family_no_link_yn") == null ? "N" : req.getParameter("family_no_link_yn");		
		namesInOthLangYn = req.getParameter("name_in_oth_lang_yn") == null ? "N" : req.getParameter("name_in_oth_lang_yn");
		idType=req.getParameter("id_type") == null ? "" : req.getParameter("id_type");
		useIdNoYn="N";
		useFamilyNoWithSfxYn="N";	
		gen_pid_using_alt_id1_rule_yn = req.getParameter("gen_pid_using_alt_id1_rule_yn") == null ? "N" : req.getParameter("gen_pid_using_alt_id1_rule_yn");
		separator_value=req.getParameter("separator_value") == null ? "" : req.getParameter("separator_value");
		separator_position=req.getParameter("separator_position") == null ? "" : req.getParameter("separator_position");
		pid_use_alt_id1_or_sys_gen=req.getParameter("pid_use_alt_id1_or_sys_gen") == null ?"" : req.getParameter("pid_use_alt_id1_or_sys_gen");
     
		email_appl_yn=req.getParameter("email_appl_yn") == null ?"N" : req.getParameter("email_appl_yn");
        associated_pat_ser_code=req.getParameter("associ_num_series") == null ?"":req.getParameter("associ_num_series");
		bd_year_pat_ser=req.getParameter("year_pat_ser") == null ?"N":req.getParameter("year_pat_ser");
		default_yn=req.getParameter("default_yn") == null ?"N" : req.getParameter("default_yn");	
		
		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("pat_ser_grp_code",patSerGrpCode);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("scheme_id",SchemeId);
			tabdata.put("gen_pat_id_yn",genPatIdYn);
			tabdata.put("prefix_reqd_yn",prefixReqdYn);
			tabdata.put("pat_no_ctrl",patNoCtrl);
			tabdata.put("use_id_no_yn",useIdNoYn);
			tabdata.put("use_family_no_with_sfx_yn",useFamilyNoWithSfxYn);
			tabdata.put("id_type",idType);
			tabdata.put("allow_family_no_yn",familyNoLinkYn);
			tabdata.put("pat_name_in_loc_lang_reqd_yn",namesInOthLangYn);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("gen_pid_using_alt_id1_rule_yn",gen_pid_using_alt_id1_rule_yn);
			tabdata.put("separator_value",separator_value );
			tabdata.put("separator_position",separator_position );
			tabdata.put("pid_use_alt_id1_or_sys_gen",pid_use_alt_id1_or_sys_gen);
           tabdata.put("ASSOCIATED_PAT_SER_GRP_CODE",associated_pat_ser_code);
          
			tabdata.put("email_appl_yn",email_appl_yn);
			tabdata.put("default_yn",default_yn);
			
			 tabdata.put("YEAR_PREFIX_REQD_YN",bd_year_pat_ser);
			HashMap condflds=new HashMap();
			condflds.put("pat_ser_grp_code",patSerGrpCode);


			
			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "MP_PAT_SER_GRP";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


		String error = (String) results.get("error") ;
		tabdata.clear();	
		condflds.clear();	
		results.clear();	
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") );
	
	} catch ( Exception e ) {
		// out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		e.printStackTrace();
	}

}


private void insertPatientNumber(HttpServletRequest req, HttpServletResponse res)	{
	try {

	patSerGrpCode = req.getParameter("pat_ser_grp_code")== null ? "" : req.getParameter( "pat_ser_grp_code");
	longDesc = req.getParameter("long_desc")== null ? "" : req.getParameter( "long_desc");
	shortDesc = req.getParameter("short_desc")== null ? "" : req.getParameter( "short_desc");
	SchemeId = req.getParameter("pat_ser_chk_dig_scheme") == null ? "" : req.getParameter("pat_ser_chk_dig_scheme");		
	genPatIdYn= req.getParameter("gen_pat_id_yn")== null ? "N" : req.getParameter("gen_pat_id_yn");
	prefixReqdYn = req.getParameter("prefix_reqd_yn")== null ? "N" : req.getParameter("prefix_reqd_yn");
	patNoCtrl = req.getParameter("pat_no_ctrl")== null ? "Z" : req.getParameter("pat_no_ctrl");
	familyNoLinkYn = req.getParameter("family_no_link_yn")== null ? "N" : req.getParameter("family_no_link_yn");
	namesInOthLangYn = req.getParameter("name_in_oth_lang_yn")== null ? "N" : req.getParameter("name_in_oth_lang_yn");
	gen_pid_using_alt_id1_rule_yn = req.getParameter("gen_pid_using_alt_id1_rule_yn") == null ? "N" : req.getParameter("gen_pid_using_alt_id1_rule_yn");
	idType=req.getParameter("id_type") == null ? "" : req.getParameter("id_type");	
	separator_value=req.getParameter("separator_value") == null ? "" : req.getParameter("separator_value");
	separator_position=req.getParameter("separator_position") == null ? "" : req.getParameter("separator_position");
	pid_use_alt_id1_or_sys_gen=req.getParameter("pid_use_alt_id1_or_sys_gen") == null ?"" : req.getParameter("pid_use_alt_id1_or_sys_gen");
   associated_pat_ser_code=req.getParameter("associ_num_series") == null ?"":req.getParameter("associ_num_series");

	email_appl_yn=req.getParameter("email_appl_yn") == null ?"N" : req.getParameter("email_appl_yn");
	default_yn=req.getParameter("default_yn") == null ?"N" : req.getParameter("default_yn");
	
	 bd_year_pat_ser=req.getParameter("year_pat_ser") == null ?"N":req.getParameter("year_pat_ser");



	useIdNoYn="N";
	useFamilyNoWithSfxYn="N";



	String addedById = p.getProperty( "login_user" ) ;
	String modifiedById = addedById ;
	String addedAtWorkstation=client_ip_address;
	String modifiedAtWorkstation = addedAtWorkstation ;	
	
	HashMap tabdata=new HashMap();
	tabdata.put("pat_ser_grp_code",patSerGrpCode);
	tabdata.put("long_desc",longDesc);
	tabdata.put("short_desc",shortDesc);
	tabdata.put("scheme_id",SchemeId);
	tabdata.put("gen_pat_id_yn",genPatIdYn);
	tabdata.put("prefix_reqd_yn",prefixReqdYn);
	tabdata.put("pat_no_ctrl",patNoCtrl);
	tabdata.put("use_id_no_yn",useIdNoYn);
	tabdata.put("use_family_no_with_sfx_yn",useFamilyNoWithSfxYn);
	tabdata.put("id_type",idType);
	tabdata.put("allow_family_no_yn",familyNoLinkYn);
	tabdata.put("pat_name_in_loc_lang_reqd_yn",namesInOthLangYn);
	tabdata.put("id_type",idType);
	tabdata.put("added_by_id",addedById);
	tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
	tabdata.put("added_at_ws_no",addedAtWorkstation);	
	tabdata.put("modified_by_id",modifiedById);
	tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
	tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
	tabdata.put("gen_pid_using_alt_id1_rule_yn",gen_pid_using_alt_id1_rule_yn);	
	tabdata.put("separator_value",separator_value);	
	tabdata.put("separator_position",separator_position);	
	tabdata.put("pid_use_alt_id1_or_sys_gen",pid_use_alt_id1_or_sys_gen);	
    tabdata.put("ASSOCIATED_PAT_SER_GRP_CODE",associated_pat_ser_code);

	tabdata.put("email_appl_yn",email_appl_yn);	
	tabdata.put("default_yn",default_yn);	

	tabdata.put("YEAR_PREFIX_REQD_YN",bd_year_pat_ser);

	String dupflds[]={"pat_ser_grp_code"};
	
	boolean local_ejbs = isLocalEJB();
	Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

	Object argArray[] = new Object[4];
	argArray[0] = p;
	argArray[1] = tabdata;
	argArray[2] = dupflds;
	argArray[3] = "MP_PAT_SER_GRP";

	Class [] paramArray = new Class[4];
	paramArray[0] = p.getClass(); ;
	paramArray[1] = tabdata.getClass();
	paramArray[2] = dupflds.getClass();
	paramArray[3] = String.class;
	
	java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
	(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

	
	boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
	String error = (String) results.get("error") ;
	String error_value = "0" ;
		tabdata.clear();
		results.clear();
	if ( inserted ) error_value = "1" ;
	res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );

	
	} catch ( Exception e ) {
		//out.println(e.getMessage());
		//out.println(e.toString());
		e.printStackTrace();
		}

	}
	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	}
}
