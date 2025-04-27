/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.net.URLEncoder;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.ConnectionManager;

public class ReportCodeSetup extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	//String mysql;
	java.util.Properties p;
	String report_id;
	String type;
	String code;
	String serial_no;
	String facilityId ;
	String client_ip_address ;
	//String error_value ;
	String error="";
   // boolean insertable;
	HttpSession session;
	Connection con;
	String err_value="";
	String report_desc="";
	String group_id="";
	String inc="";
	String locale="";

	//java.text.SimpleDateFormat dateFormat =		new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{ 
	    
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");	
		
		try
		{			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();

			insertReport(req, res);
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	private void insertReport(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{ 
			
             con =  ConnectionManager.getConnection(req);
	        PreparedStatement pstmt = null;
	        //ResultSet rs = null;
			boolean status=true;
	        con.setAutoCommit(false);
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
            String maxRecord=req.getParameter("maxrecord");
			//String grp_value=req.getParameter("grp_value")==null?"":req.getParameter("grp_value");
			int maxRec=Integer.parseInt(maxRecord);
            int cnt=0;
			report_id=req.getParameter("Rep_id")==null ? "" : req.getParameter("Rep_id");
			type=req.getParameter("type")==null ? "" : req.getParameter("type");
			int var=0;

			String sql22="DELETE FROM MR_REPORT_MAPPING WHERE REPORT_ID=? and MAST_TABLE_NAME_REFERENCE=?";

			pstmt=con.prepareStatement(sql22);
			pstmt.setString(1,report_id);
			pstmt.setString(2,type);
			pstmt.executeUpdate();
		    if(pstmt != null) pstmt.close();
			for(int k=1;k<maxRec;k++)
			{
				inc=req.getParameter("inc"+k)==null ? "" : req.getParameter("inc"+k);
				code=req.getParameter("code"+k)==null ? "" : req.getParameter("code"+k);
				report_desc=req.getParameter("report_desc"+k)==null ? "" : req.getParameter("report_desc"+k);
				group_id=req.getParameter("Group_id"+k)==null ? "" : req.getParameter("Group_id"+k);
				serial_no=req.getParameter("serial_no"+k)==null ? "" : req.getParameter("serial_no"+k);
				if(serial_no.equals("") ||serial_no==null)
				serial_no="0";
				if(inc.equals("Y")) {

								
				if(report_desc.equals("") || report_desc==null)
				{
					status=false;
					error="APP-000001  Report Description cannot be blank.";
				}
				else if(group_id.equals("") || group_id== null)
				{
						status=false;
						error="APP-000001  Group cannot be blank.";
				}
				else if(serial_no.equals("0") || serial_no== null)
				{
						status=false;
						error="APP-000001  Order Serial No cannot be blank.";
				}
				
				

				if(status)
				{
					var=Integer.parseInt(serial_no);
					try
					{
					String sql ="insert into mr_report_mapping values (?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,null)";
					
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,report_id);
					pstmt.setString(2,group_id);
					pstmt.setString(3,type);
					pstmt.setString(4,code);
					pstmt.setString(5,null);
					pstmt.setString(6,report_desc);
					pstmt.setInt(7,var);
					pstmt.setString(8,addedById);
					pstmt.setString(9,addedAtWorkstation);
					pstmt.setString(10,addedFacilityId);
					pstmt.setString(11,modifiedById);
					pstmt.setString(12,modifiedAtWorkstation);
					pstmt.setString(13,modifiedFacilityId);
					cnt=pstmt.executeUpdate();
					 if(cnt>0)
						status=true;
					 else
						status=false;
					}
					catch(Exception x)
					{
						x.printStackTrace();
						status=false;
						con.rollback();
						error=x.getMessage();
					}
				
				}
				}
				if(pstmt != null) pstmt.close(); 
			} 
			if(status)
			{
				err_value="1";
				con.commit();
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
    			error = (String)hashtable1.get("message");
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8")+"&err_value="+err_value);
				if ( hashtable1 != null ) hashtable1.clear();
			}
			else
			{
				err_value="0";
    			con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error)+"&err_value="+err_value);	 	 
			}
		}
	catch ( Exception e )
	{
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		try{con.rollback();	}
		catch(Exception eee){}
		//out.println(e.toString());
		e.printStackTrace();
	}
     finally
	 { 
		if( con != null ) ConnectionManager.returnConnection(con,req);
	 }      
	}
}
