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
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCA.ExtApplParamBean.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;



public class ExtApplParamServlet extends javax.servlet.http.HttpServlet
{
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{    
	
	PrintWriter out = null;
	PreparedStatement pstmt = null;
	Connection con = null;
	ResultSet rs = null;

	String appcn2="";
	String error_value="";
	String errormsg="";

	
		

	try
		{
		    out = response.getWriter();
			con=ConnectionManager.getConnection(request);
			//this.out = response.getWriter();
			response.setContentType("text/html");
			int rowlength= Integer.parseInt((request.getParameter("countrow") == null) ? "" : request.getParameter("countrow"));
		
						
			if(rowlength != 0)
				{
					appcn2 = (request.getParameter("appcn2") == null) ? "" : request.getParameter("appcn2");
					pstmt = con.prepareStatement("delete from CA_EXT_IMAGE_APPL_PARAM where EXT_IMAGE_APPL_ID = ? ");
					pstmt.setString(1,appcn2);
					pstmt.executeUpdate();
				
					
					insertModify(request,response,rowlength,con,out);
				}
			else
				{
					appcn2 = (request.getParameter("appcn2") == null) ? "" : request.getParameter("appcn2");
									
					pstmt = con.prepareStatement("delete from CA_EXT_IMAGE_APPL_PARAM where EXT_IMAGE_APPL_ID = ? ");
					pstmt.setString(1,appcn2);
					pstmt.executeUpdate();
					error_value = "1";
					errormsg = "APP-SM0001 Operation Completed Successfully ....";
					out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+errormsg+"&err_value=1'</script>");
					

				}
			
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
		}
		catch(Exception ee)
			{
				//out.println("Exception raise by Sections For  extapparameter servlet...So Record Not inserted  : "+ee.toString());//common-icn-0181
				ee.printStackTrace();
				errormsg="Exception raise by Sections For  extapparameter servlet...So Record Not inserted  :";
				out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+errormsg+"&err_value=0'</script>");
			}
		finally
			{
					
				if(con != null) ConnectionManager.returnConnection(con);
				
			}	
			
	}
			

	public void insertModify(HttpServletRequest request,HttpServletResponse response,int rowlength,Connection con, PrintWriter out)
	{
		java.util.Properties p;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//Hashtable tabdata;
		String paramname="";
		String paramtype="";
		String paramvalue="";
		HttpSession session;;
		String appcn2="";
		String error_value="";
		String errormsg="";
		session =  request.getSession(false);
        		
		String sqlInsert = "";
		
			   
		eCA.ExtApplParamBean parabean = (eCA.ExtApplParamBean)com.ehis.persist.PersistenceHelper.getObjectFromBean("parabean","eCA.ExtApplParamBean",session);
		
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String facilityId = (String) session.getValue( "facility_id" ) ;
		String client_ip_addr=	p.getProperty("client_ip_address");
		String addedId =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ; 
	    ArrayList  b=new ArrayList();
		b=parabean.getbeanHandle();
		String countrow=request.getParameter("countrow") == null ? "" : request.getParameter("countrow");
		int count=Integer.parseInt(countrow);
		
		 int i=0;
		for(int index=0;index<count;index++)
		{  
			
			
			paramname=b.get(i).toString();
			
			paramtype=b.get(i+1).toString();
			
			paramvalue=b.get(i+2).toString();
			
			
						
			String paramref=request.getParameter("paramref") == null ? "" : request.getParameter("paramref");
			
			try
				{
				
				
				sqlInsert="INSERT INTO  CA_EXT_IMAGE_APPL_PARAM (EXT_IMAGE_APPL_ID ,PARAM_NAME, PARAM_TYPE,PARAM_VALUE ,PARAM_REF,ADED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES(?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

  

				 pstmt=con.prepareStatement(sqlInsert);
				 pstmt.setString(1,appcn2);
				 pstmt.setString(2,paramname);
				 pstmt.setString(3,paramtype);
			     pstmt.setString(4,paramvalue);
				 pstmt.setString(5,paramref);
				 pstmt.setString(6,addedId);
			//pstmt.setString(7,addeddate);
				 pstmt.setString(7,client_ip_addr);
				 pstmt.setString(8,facilityId);
				 pstmt.setString(9, addedId);
			
			    pstmt.setString(10,client_ip_addr);
				 pstmt.setString(11,facilityId);

				 pstmt.executeUpdate();

				





				     //tabdata = MessageManager.getMessage(con, "Successfully inserted the data into table");
			//confirmMsg= (String) tabdata.get("message");
			//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(confirmMsg)+"&err_value=0");

				
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();

					error_value = "1";
					errormsg = "APP-SM0001 Operation Completed Successfully ....";
					out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+errormsg+"&err_value=1'</script>");
				
	
		}
		catch(Exception e)
		{
			//out.println("Exception "+e.toString());//common-icn-0181
			e.printStackTrace();
			errormsg="Exception raise by Sections For  extapparameter servlet...So Record Not inserted  :";
			//out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+errormsg+"&err_value=0'</script>");//common-icn-0181
		
		}

		finally
			{
				i+=3;
				
			}
		}

	}

}


		
