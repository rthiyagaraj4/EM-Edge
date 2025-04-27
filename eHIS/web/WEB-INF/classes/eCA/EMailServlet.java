/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class EMailServlet extends javax.servlet.http.HttpServlet
{
	HttpSession session				= null;
	java.util.Properties p			= null;

	String locale					= "";

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");	
		PrintWriter out = null;

		try
		{

		   session					= req.getSession(false);
		   p						= (java.util.Properties) session.getValue( "jdbc" ) ;
		   locale					= (String) p.getProperty("LOCALE");

			out = res.getWriter();
			String beanKey=req.getParameter("beanKey")==null?"":req.getParameter("beanKey");

			eCA.EmailRepBodyTxtBean CA_EmailRepBodyTxtBean= (eCA.EmailRepBodyTxtBean)com.ehis.persist.PersistenceHelper.getObjectFromBean(beanKey,"eCA.EmailRepBodyTxtBean",session);
			sendMail(req, res, out,CA_EmailRepBodyTxtBean);
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}

private void sendMail(HttpServletRequest req, HttpServletResponse res, PrintWriter out,eCA.EmailRepBodyTxtBean CA_EmailRepBodyTxtBean){
	java.util.Properties p;
	String module_id = "";
	String report_id ="";
	String disclaimer = "" ;
	String to_emailId = "" ;
	String to_id = "" ;
	String to_name = "" ;
	String cc_emailId="";
	String cc_id="";
	String cc_name="";
	String subject = "";
	String editor_content = "";
	String verReqdYn = "";
	String password = "";
	String patient_id = "";
	String patientName = "";
	String mailToType = "";

	String p_accession_num = "";	
	String p_file_name	 = "";
	String p_report_type	 = "";
	String p_report_text = "";
	String error = "";
	String error_value = "";
	String appl_user_name ="";
	String facilityId ="";
	String client_ip_address ="";

	HttpSession session;
	session = req.getSession(false);
	p					= (java.util.Properties) session.getValue( "jdbc" ) ;
	facilityId			= (String) session.getValue( "facility_id" ) ;
	appl_user_name			= (String) session.getValue( "appl_user_name" ) ;
	client_ip_address	= (String) p.getProperty("client_ip_address");
	try{
		patient_id =req.getParameter("patient_id")==null?"":req.getParameter("patient_id");
		module_id =req.getParameter("module_id")==null?"":req.getParameter("module_id");
		report_id =req.getParameter("report_id")==null?"":req.getParameter("report_id");
		disclaimer =req.getParameter("disclaimer")==null?"":req.getParameter("disclaimer");
		to_emailId =req.getParameter("to_emailId")==null?"":req.getParameter("to_emailId");
		to_id =req.getParameter("to_id")==null?"":req.getParameter("to_id");
		to_name =req.getParameter("to_name")==null?"":req.getParameter("to_name");
		cc_emailId =req.getParameter("cc_emailId")==null?"":req.getParameter("cc_emailId");
		cc_id =req.getParameter("cc_id")==null?"":req.getParameter("cc_id");
		cc_name =req.getParameter("cc_name")==null?"":req.getParameter("cc_name");
		subject =req.getParameter("subject")==null?"":req.getParameter("subject");
		p_file_name =req.getParameter("p_file_name")==null?"":req.getParameter("p_file_name");
		p_report_type	 =req.getParameter("p_report_type")==null?"":req.getParameter("p_report_type");
		p_accession_num	 =req.getParameter("encounter_id")==null?"":req.getParameter("encounter_id");

		verReqdYn = req.getParameter("veryReqdYn") == null ? "V" : req.getParameter("veryReqdYn");
		password = req.getParameter("password") == null ? "" : req.getParameter("password");
		mailToType = req.getParameter("mailToType") == null ? "" : req.getParameter("mailToType");

		editor_content=(String)(CA_EmailRepBodyTxtBean.getEditorContent()==null?"":CA_EmailRepBodyTxtBean.getEditorContent());
		p_report_text=(String)(CA_EmailRepBodyTxtBean.getReportText()==null?"":CA_EmailRepBodyTxtBean.getReportText());

		String addedById = p.getProperty( "login_user" ) ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		Connection con = null;
		oracle.jdbc.OracleCallableStatement csFaxMail = null;
		String sqlPatNamePwd = "select Translate(PATIENT_NAME,'~!@#$%^&*','          ' ) pat_name, app_password.encrypt(?) enc_pwd from mp_patient where patient_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlPwdForRegUser = "select  PASSWORD pwd from SM_REGD_MAIL_USER_PWD where  MAILER_ID =? and sysdate between FROM_DATE  and nvl(TO_DATE,sysdate)";

	
		try{
			con = ConnectionManager.getConnection(req);

			ps = con.prepareStatement(sqlPatNamePwd);
			ps.setString(1,password);
			ps.setString(2,patient_id);

			rs = ps.executeQuery();

			while(rs.next())
			{
				patientName = rs.getString("pat_name") == null ? "" : rs.getString("pat_name");
				password = rs.getString("enc_pwd") == null ? "" : rs.getString("enc_pwd");
			}

			if(rs != null) rs.close();
			if(ps != null) ps.close();

			if(mailToType.equals("R"))
			{
				ps = con.prepareStatement(sqlPwdForRegUser);
				ps.setString(1,to_id);

				rs = ps.executeQuery();

				while(rs.next())
				{
					password = rs.getString("pwd") == null ? password : rs.getString("pwd");
				}

				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}

			if(patientName.indexOf("\"") != -1) patientName.replaceAll("\""," ");
			p_file_name = module_id + "-" + report_id + "-" + patientName;

			csFaxMail = (oracle.jdbc.OracleCallableStatement) con.prepareCall("{call APPFAXMAIL.FAX_MAIL_REPORT (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			csFaxMail.setString(1,facilityId);
			csFaxMail.setString(2,module_id);
			csFaxMail.setString(3,report_id);
			csFaxMail.setString(4,"@");
			csFaxMail.setString(5,"@");
			csFaxMail.setString(6,to_emailId);
			csFaxMail.setString(7,cc_emailId);
			csFaxMail.setString(8,null);
			csFaxMail.setString(9,subject);
			csFaxMail.setString(10,null);
			csFaxMail.setString(11,editor_content);
			csFaxMail.setString(12,disclaimer);
			csFaxMail.setString(13,"N");
			if(to_name.equals(""))
				csFaxMail.setString(14,null);
			else
			csFaxMail.setString(14,to_name);

			csFaxMail.setString(15,null);
			csFaxMail.setString(16,null);
			csFaxMail.setString(17,appl_user_name);
			csFaxMail.setString(18,null);
			csFaxMail.setString(19,null);
			csFaxMail.setString(20,"M");
			csFaxMail.setString(21,p_file_name);
			csFaxMail.setString(22,addedById);
			csFaxMail.setString(23,modifiedAtWorkstation);
			csFaxMail.setString(24,null);
			csFaxMail.registerOutParameter(25,Types.VARCHAR);
			csFaxMail.setString(26,p_report_type);
			csFaxMail.setStringForClob(27,p_report_text);
			csFaxMail.setString(28,null);
			csFaxMail.setString(29,null);
			csFaxMail.setString(30,verReqdYn);
			csFaxMail.setString(31,password);
			csFaxMail.setString(32,patient_id);
			csFaxMail.setString(33,p_accession_num);
			csFaxMail.execute();
			error = csFaxMail.getString(25);
			if(error!=null){
				con.rollback();
				error=error+":"+getMessage(locale,"FAILED_TRANSACTION","CA");
				out.println("<script>alert('"+error+"');</script>");
			}else{
				con.commit();
				error_value = "1" ;
				error=getMessage(locale,"RECORD_INSERTED","CA");				out.println("<script>alert('"+error+"');parent.parent.window.close()</script>");
			}
		}catch (Exception eeeee){
			con.rollback();
			//out.println("Exception while parsing SectionTemplate ! "+eeeee.toString());//common-icn-0181
			
			eeeee.printStackTrace();
		}finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if (csFaxMail != null) 
				csFaxMail.close();
			if(con != null) ConnectionManager.returnConnection(con,req);
		}
		//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
		
	}catch ( Exception e ){
		out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		
		out.println( "Values sent are : <br>" ) ;
		e.printStackTrace();

	}
}
private String getMessage(String locale, String messageId, String moduleId){
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	 }

}
