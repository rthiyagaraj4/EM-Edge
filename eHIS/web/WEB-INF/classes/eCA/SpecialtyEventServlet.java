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
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class  SpecialtyEventServlet extends HttpServlet 
{
	/**
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
	public  void init(ServletConfig config) throws ServletException
	{
			 super.init(config);
	}
/**
*	doPost	-	will be called when the method is of post
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	 {  request.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		String mode = request.getParameter("mode") == null ? "" :  request.getParameter("mode");
		if(mode.equals("insert"))
				insert(request,response, out);
		if(mode.equals("modify"))
				modify(request,response,out);
		if(mode.equals("delete"))
				delete(request,response,out);
}

  void insert(HttpServletRequest request,HttpServletResponse response, PrintWriter out)		
	 {
			String client_ip_addr;
			String facilityId;
			String addedId;
			HttpSession session; 
			Properties p;
			Hashtable tabdata;
			PreparedStatement ps;
			Connection con = null;
			ResultSet rs=null;
			String module = "";
			String errVal = "0";
			String code = "";
			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			facilityId = (String) session.getValue( "facility_id" ) ;
			client_ip_addr=	p.getProperty("client_ip_address");
			addedId =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;   
			String	description = "";
			String  agegroupCode = "";
			String  orderSequence = "";
			String  def_type_value = "";
			String  autoClosePeriod = "";
			String  autoClosePeriodType="";
			String  autoCloseType = "";
			String  enabled = "";
			String  errorMsg = "";
			try{
					con = ConnectionManager.getConnection(request);
					String counter="0";
					String counter1="0";
					module =  request.getParameter("module") == null ? "" : request.getParameter("module");
					code =  request.getParameter("code") == null ? "" : request.getParameter("code");
					description =  request.getParameter("description") == null ? "" : request.getParameter("description");
					agegroupCode =  request.getParameter("agegroupCode") == null ? "" : request.getParameter("agegroupCode");
					orderSequence =  request.getParameter("orderSequence") == null ? "" : request.getParameter("orderSequence");
					def_type_value =  request.getParameter("def_type_value") == null ? "" : request.getParameter("def_type_value");
					autoClosePeriod =  request.getParameter("autoClosePeriod") == null ? "" : request.getParameter("autoClosePeriod");
					autoClosePeriodType =  request.getParameter("autoClosePeriodType") == null ? "" : request.getParameter("autoClosePeriodType");
					autoCloseType =  request.getParameter("autoCloseType") == null ? "" : request.getParameter("autoCloseType");
					enabled =  request.getParameter("enabled") == null ? "D" : request.getParameter("enabled");
					ps = con.prepareStatement("select count(*) count from CA_SPLTY_EVENT where SPLTY_EVENT_CODE=? ");
					ps.setString(1,code);
					//ps.setString(2,orderSequence);
					rs = ps.executeQuery();
					while(rs.next())
				   {
					counter =rs.getString("count");
				   }
					if(ps != null)ps.close();
				    if(rs != null)rs.close();

					ps = con.prepareStatement("select count(*) count from CA_SPLTY_EVENT where ORDER_SEQ_NO=? ");
					ps.setString(1,orderSequence);
					rs = ps.executeQuery();
					while(rs.next())
				   {
					counter1=rs.getString("count");
				   }
					if(ps != null)ps.close();
				    if(rs != null)rs.close();
					
					if(Integer.parseInt(counter) == 0 &&   Integer.parseInt(counter1) == 0)
				   {
					ps = con.prepareStatement("Insert into CA_SPLTY_EVENT ( MODULE_ID,SPLTY_EVENT_CODE,SPLTY_EVENT_DESC,AGE_GROUP_CODE,ORDER_SEQ_NO,SYS_IND,AUTO_CLOSE_PERIOD,AUTO_CLOSE_PERIOD_TYPE,AUTO_CLOSE_TYPE,EFF_STATUS,ADDED_BY_ID,ADDED_DATE ,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,? ,?) ");
					ps.setString(1,module);
					ps.setString(2,code);
					ps.setString(3,description);
					ps.setString(4,agegroupCode);
					ps.setString(5,orderSequence);
					ps.setString(6,def_type_value);
					ps.setString(7,autoClosePeriod);
					ps.setString(8,autoClosePeriodType);
					ps.setString(9,autoCloseType);
					ps.setString(10,enabled);
					ps.setString(11,addedId);
					ps.setString(12,client_ip_addr);
					ps.setString(13,facilityId);
					ps.setString(14,addedId);
					ps.setString(15,client_ip_addr);
					ps.setString(16,facilityId);
					int inserted = ps.executeUpdate();
					if(ps != null)ps.close();
					if(rs != null)rs.close();
					if(inserted != 0)
					{
						con.commit();
						tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
						errorMsg= (String) tabdata.get("message");
						errVal = "1";
					}
				  }
				  else
				  {	con.rollback();
						if(Integer.parseInt(counter) != 0)
					   {
						tabdata = MessageManager.getMessage(locale, "DUPLICATE_CODE_EXISTS","Common");
						errorMsg= (String) tabdata.get("message");
						errVal = "0";
					   }
					   else if(Integer.parseInt(counter1) != 0)
					  {
						 tabdata = MessageManager.getMessage(locale, "DUPLICATE_SEQUENCE_NUMBER","CA");
						errorMsg= (String) tabdata.get("message");
						errVal = "0";
					  }
				  }
				  
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
						if(rs != null) rs.close();
						if(ps != null) ps.close();
			}
			catch(Exception ee)
			{
				//out.println("Exception raise by Specialty Event Servlet ...So Record Not inserted  : "+ee.toString());//common-icn-0181
				ee.printStackTrace();
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con);
			}
	}	

	 /**
*	modify	-	will be called when the mode value is modify
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	void modify(HttpServletRequest request,HttpServletResponse response,PrintWriter out)
	 {
			String client_ip_addr;
			String facilityId;
			String addedId;
			HttpSession session; 
			Properties p;
			Hashtable tabdata;
			PreparedStatement ps;
			Connection con = null;
			ResultSet rs=null;
			String errVal = "0";
			String code = "";
			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			facilityId = (String) session.getValue( "facility_id" ) ;
			client_ip_addr=	p.getProperty("client_ip_address");
			addedId =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;   
			String	description = "";
			String  agegroupCode = "";
			String  orderSequence = "";
			String  autoClosePeriod = "";
			String  autoClosePeriodType="";
			String  enabled = "";
			String  errorMsg = "";
			String  counter1="0";
			String  code1="";
			try{
					con = ConnectionManager.getConnection(request);
					code =  request.getParameter("code") == null ? "" : request.getParameter("code");
					description =  request.getParameter("description") == null ? "" : request.getParameter("description");
					agegroupCode =  request.getParameter("agegroupCode") == null ? "" : request.getParameter("agegroupCode");
					orderSequence =  request.getParameter("orderSequence") == null ? "" : request.getParameter("orderSequence");
					autoClosePeriod =  request.getParameter("autoClosePeriod") == null ? "" : request.getParameter("autoClosePeriod");
					autoClosePeriodType =  request.getParameter("autoClosePeriodType") == null ? "" : request.getParameter("autoClosePeriodType");
					enabled =  request.getParameter("enabled") == null ? "D" : request.getParameter("enabled");
					
					ps = con.prepareStatement("select count(*) count from CA_SPLTY_EVENT where ORDER_SEQ_NO=? ");
					ps.setString(1,orderSequence);
					rs = ps.executeQuery();
					while(rs.next())
				   {
					counter1=rs.getString("count");
				   }
					if(ps != null)ps.close();
				    if(rs != null)rs.close();
					if((Integer.parseInt(counter1) == 1))
				   {
					ps = con.prepareStatement("select SPLTY_EVENT_CODE from CA_SPLTY_EVENT  where ORDER_SEQ_NO=? ");
					ps.setString(1,orderSequence);
					rs = ps.executeQuery();
					while(rs.next())
				   {
					code1=rs.getString("SPLTY_EVENT_CODE");
					}
				   }
					if(ps != null)ps.close();
				    if(rs != null)rs.close();
					if(((Integer.parseInt(counter1) == 1) && (code.equals(code1)) )||  (Integer.parseInt(counter1) == 0))
					{
					ps = con.prepareStatement("Update CA_SPLTY_EVENT set SPLTY_EVENT_DESC =?, AGE_GROUP_CODE =?, ORDER_SEQ_NO =?,  AUTO_CLOSE_PERIOD =?, AUTO_CLOSE_PERIOD_TYPE =?, EFF_STATUS=? where  SPLTY_EVENT_CODE =? ");
					ps.setString(1,description);
					ps.setString(2,agegroupCode);
					ps.setString(3,orderSequence);
					ps.setString(4,autoClosePeriod);
					ps.setString(5,autoClosePeriodType);
					ps.setString(6,enabled);
					ps.setString(7,code);
					int updated = ps.executeUpdate();
					if(updated != 0)
					{
						con.commit();
						tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
						errorMsg= (String) tabdata.get("message");
						errVal = "1";
						out.println("<script>parent.f_query_add_mod.document.specialityeventaddmodifyForm.code.disabled=true;</script>");
						out.println("<script>parent.f_query_add_mod.document.specialityeventaddmodifyForm.description.disabled=true;</script>");
						out.println("<script>parent.f_query_add_mod.document.specialityeventaddmodifyForm.agegroupDes.disabled=false;</script>");
						out.println("<script>parent.f_query_add_mod.document.specialityeventaddmodifyForm.orderSequence.disabled=false;</script>");
						out.println("<script>parent.f_query_add_mod.document.specialityeventaddmodifyForm.definitionType.disabled=false;</script>");
						//out.println("<script>parent.f_query_add_mod.document.specialityeventaddmodifyForm.autoCloseType.disabled=true;</script>");
				}
				   }
				
				else
				  {
					  	 con.rollback(); 
						 tabdata = MessageManager.getMessage(locale, "DUPLICATE_SEQUENCE_NUMBER","CA");
						 errorMsg= (String) tabdata.get("message");
						 errVal = "0";
				         out.println("<script>parent.f_query_add_mod.document.specialityeventaddmodifyForm.code.disabled=true;</script>");
						 //out.println("<script>parent.f_query_add_mod.document.specialityeventaddmodifyForm.autoCloseType.disabled=true;</script>");
				 }
				
					//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
					out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg)+"&err_value="+errVal+"'</script>");
				
					if(rs != null) rs.close();
					if(ps != null) ps.close();
					
			}
			catch(Exception ee)
			{
				out.println("Exception raise by Specialty Event Servlet ...So Record Not inserted  : "+ee.toString());
				ee.printStackTrace();
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con);
			}
			
		}

	 /**
*	delete	-	will be called when the mode value is delete
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	 void delete(HttpServletRequest request,HttpServletResponse response, PrintWriter out)	
	 {
			String client_ip_addr;
			String facilityId;
			String addedId;
			HttpSession session; 
			Properties p;
			Hashtable tabdata;
			PreparedStatement ps;
			Connection con = null;
			ResultSet rs=null;
			String errVal = "0";
			String code = "";
			String  errorMsg = "";
			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			facilityId = (String) session.getValue( "facility_id" ) ;
			client_ip_addr=	p.getProperty("client_ip_address");
			addedId =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;   
				try{
						con = ConnectionManager.getConnection(request);
						code =  request.getParameter("code") == null ? "" : request.getParameter("code");
						code = code.trim();
						ps = con.prepareStatement("delete from CA_SPLTY_EVENT where SPLTY_EVENT_CODE = ? ");
						ps.setString(1,code);
						int deleted = ps.executeUpdate();
						if(deleted != 0)
					    {
						  con.commit();
						  tabdata = MessageManager.getMessage(locale,"RECORD_DELETED","CA");
						  errorMsg= (String) tabdata.get("message");
						  errVal = "1";
					    }
						else
						{
						 try
					    {
							con.rollback();
					    }
					    catch(Exception e)
					    {
					     e.printStackTrace();
					    }
						tabdata = MessageManager.getMessage(locale,"NO_RECORD_FOUND_FOR_CRITERIA","Common");
						errorMsg= (String) tabdata.get("message");
						errVal = "0";
						}
			         response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
				    if(rs != null) rs.close();
				    if(ps != null) ps.close();

			}
			catch(Exception ee)
			{
				//out.println("Exception raise by Specialty Event Servlet ...So Record Not inserted  : "+ee.toString());//common-icn-0181
				ee.printStackTrace();
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con);
			}
		}
}

