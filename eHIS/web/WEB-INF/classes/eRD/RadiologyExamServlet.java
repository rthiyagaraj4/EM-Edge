/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
Sr No        Version              TFS              SCF/CRF           	   				 Developer Name
-------------------------------------------------------------------------------------------------------
1            V211228            26735      PMG2021-COMN-CRF-0089.1-TF-US001            Mohanapriya K
*/
package eRD;

import java.lang.reflect.Method;
import java.net.URLEncoder;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class RadiologyExamServlet extends javax.servlet.http.HttpServlet
{
	private static final long serialVersionUID = 1L; 
	PrintWriter out;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String locale="";	
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = this.p.getProperty("client_ip_address");
		login_user = this.p.getProperty( "login_user" ) ;
		locale=(String) session.getValue( "LOCALE" );
		Connection con = null;
		
		
		try
		{
			con   =   ConnectionManager.getConnection(p);

	
			this.out = res.getWriter();
			String operation = checkForNull(req.getParameter("mode"));
			//String param = checkForNull(req.getParameter("params"));
			System.err.println("operation-"+operation);
			if ( operation.equals("updRepText"))    modify(req, res,con); //Upd rep text
			
			if ( operation.equals("updateType"))   updateType(req, res,con); //Update TYPE
			
			con.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println(e.toString());
		}
		finally
		{
			if(con !=null)  ConnectionManager.returnConnection(con);
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}

	private void modify(HttpServletRequest request, HttpServletResponse res,Connection con)
	{
		try{		
			
			String P_FACILITY_ID = checkForNull(request.getParameter("P_FACILITY_ID"));
			String P_PATIENT_ID = checkForNull(request.getParameter("P_PATIENT_ID"));
			String P_ENCOUNTER_ID = checkForNull(request.getParameter("P_ENCOUNTER_ID"));
			String P_LOGIN_USER = checkForNull(request.getParameter("P_LOGIN_USER"));
			String P_LANGUAGE_ID = checkForNull(request.getParameter("P_LANGUAGE_ID"));
			String P_RESP_ID = checkForNull(request.getParameter("P_RESP_ID"));
			String P_REQUEST_NUM = checkForNull(request.getParameter("P_REQUEST_NUM"));
			String P_REQUEST_LINE_NUM = checkForNull(request.getParameter("P_REQUEST_LINE_NUM"));
			String P_EXT_APPL_ACCESSION_NUM = checkForNull(request.getParameter("P_EXT_APPL_ACCESSION_NUM"));
			//String clinicnote = checkForNull(request.getParameter("clinicnote"));
			String clinicnote = checkForNull(request.getParameter("updatedText"));
			String radiologist = checkForNull(request.getParameter("radiologist"));
			String prevComm = checkForNull(request.getParameter("prevComm"));
			String indicator = checkForNull(request.getParameter("indicator"));
		//	String error_flag="N";
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1 =null;
			ResultSet rs = null;
			String curr_sys_date="";
			ResultSet rs1 = null;

			
			String sys_date = "select to_char(sysdate, 'DD/MM/YYYY')  sysday from dual";
			pstmt = con.prepareStatement(sys_date);

			rs = pstmt.executeQuery();
			if (rs != null) {

				if (rs.next()) {

					curr_sys_date = rs.getString("sysday");
				}
			}
				
			if(indicator.equals("M")){
				clinicnote =""+prevComm+"\n"+clinicnote+"\n"+"----------------------------------------------------------"+"--------------"+"\n"+"Addendum --> Created On : "+curr_sys_date+" By : "+""+radiologist+"\n"+"----------------------------------------------------------"+"-------------";
			}
				
				System.err.println("clinicnote in servlet-->"+clinicnote);
				
			String updateComment ="UPDATE rd_exam_view_requested SET report_text = '"+clinicnote+"' WHERE operating_facility_id = '"+P_FACILITY_ID+"' and request_num='"+P_REQUEST_NUM+"'  and REQUEST_LINE_NUM='"+P_REQUEST_LINE_NUM+"'";
			
			pstmt1 = con.prepareStatement(updateComment);
				
			int res_upd1 =pstmt1.executeUpdate();
			System.err.println("res_upd1  "+res_upd1);
					if (res_upd1 == 0) {
			
					}else{
					Hashtable messageHashtable=new Hashtable();
					messageHashtable=MessageManager.getMessage(locale,"RD0001","RD");
					String error=(String)messageHashtable.get("message");
				//	res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value=1");
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ));
				}			 
					
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (pstmt1 != null)
						pstmt1.close();
					
			}catch ( Exception e ){
				e.printStackTrace();
				out.println(" Exception raised ...So Record Not updatedFoll: Error Received : "+e.toString());
			}
			
	}

	private void updateType(HttpServletRequest request, HttpServletResponse res,Connection con)
	{
		try{
			String P_FACILITY_ID = checkForNull(request.getParameter("P_FACILITY_ID"));
			String P_PATIENT_ID = checkForNull(request.getParameter("P_PATIENT_ID"));
			String P_ENCOUNTER_ID = checkForNull(request.getParameter("P_ENCOUNTER_ID"));
			String P_LOGIN_USER = checkForNull(request.getParameter("P_LOGIN_USER"));
			String P_LANGUAGE_ID = checkForNull(request.getParameter("P_LANGUAGE_ID"));
			String P_RESP_ID = checkForNull(request.getParameter("P_RESP_ID"));
			String P_REQUEST_NUM = checkForNull(request.getParameter("P_REQUEST_NUM"));
			String P_REQUEST_LINE_NUM = checkForNull(request.getParameter("P_REQUEST_LINE_NUM"));
			String P_EXT_APPL_ACCESSION_NUM = checkForNull(request.getParameter("P_EXT_APPL_ACCESSION_NUM"));
			String clinicnote = checkForNull(request.getParameter("clinicnote"));
			String radiologist = checkForNull(request.getParameter("radiologist"));
			String prevComm = checkForNull(request.getParameter("prevComm"));
			String indicator = checkForNull(request.getParameter("indicator"));
			String P_REP_TYPE_FROM = checkForNull(request.getParameter("P_REP_TYPE_FROM"));
			String P_REP_TYPE_TO = checkForNull(request.getParameter("P_REP_TYPE_TO"));
			String error_value="";
			String error="";
			System.err.println("P_REP_TYPE_FROM serv "+P_REP_TYPE_FROM);
			System.err.println("P_REP_TYPE_TO serv "+P_REP_TYPE_TO);
			CallableStatement cstmt= null ;
			ResultSet rs = null;
			
			
			String REP_TYPE_TO = "{ call RD_RESULT.UPD_RESULT(?,?,?,?,?,?,?,?)}";
			cstmt = con.prepareCall(REP_TYPE_TO);
			cstmt.setString(1,P_FACILITY_ID);
			cstmt.setString(2,P_LOGIN_USER);
			cstmt.setString(3,client_ip_address);
			cstmt.setString(4,P_REQUEST_NUM);
			cstmt.setString(5,P_REQUEST_LINE_NUM);
			cstmt.setString(6,P_REP_TYPE_TO);
			cstmt.setString(7,P_LANGUAGE_ID);
			
			System.err.println("p_facility_id="+P_FACILITY_ID+" P_PATIENT_ID "+P_PATIENT_ID+" P_REQUEST_NUM "+P_REQUEST_NUM+" P_REP_TYPE_TO-"+P_REP_TYPE_TO+" P_REP_TYPE_FROM "+P_REP_TYPE_FROM);
			cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
			cstmt.execute();
			String P_ERROR_TEXT = checkForNull(cstmt.getString(8));
			System.err.println("P_ERROR_TEXT,204 serv-"+P_ERROR_TEXT);
			if(!P_ERROR_TEXT.equals(""))
			{	
				error_value="0";
				System.err.println("P_ERROR_TEXT-"+P_ERROR_TEXT);
				//error=P_ERROR_TEXT;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( P_ERROR_TEXT,"UTF-8" ) +"&err_value="+error_value);		
			}else{
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ));
			}
		}catch ( Exception e ){
				e.printStackTrace();
				out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());				
		}
	}

	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String str,String defaultVal){
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}
}