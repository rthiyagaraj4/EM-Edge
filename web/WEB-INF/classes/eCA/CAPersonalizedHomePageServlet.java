/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
 

 public class CAPersonalizedHomePageServlet extends HttpServlet
 {
	public void init(ServletConfig config) throws ServletException
	{
			 super.init(config);
	}

		public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MOHE-SCF-0153
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		try
		{
			
			out = res.getWriter();
			String mode =(req.getParameter("mode")==null)?"":req.getParameter("mode");
			
			if(mode.trim().equalsIgnoreCase("delete") || mode=="delete")
					delete(req, res, out);
			if (mode.trim().equalsIgnoreCase("insert"))
					insert(req, res, out);
			if(mode.trim().equalsIgnoreCase("modify"))
					modify(req, res, out);
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
		//req.setCharacterEncoding("UTF-8");
		//res.setContentType("text/html;charset=UTF-8");
		out = res.getWriter();
		doPost(req, res);

	}
	catch(Exception ei)
	{	
			//out.println(ei.toString());
			ei.printStackTrace();
	}
 }

	public void insert(HttpServletRequest request,HttpServletResponse response, PrintWriter out)
	 {
			response.setContentType("text/html;charset=UTF-8");			
			//String val = "";
			StringBuffer sql = new StringBuffer();
			Connection con = ConnectionManager.getConnection(request);
			PreparedStatement ps = null;
			boolean flag = false;
			boolean delete = false; 
			//boolean insert = false; 
			//boolean modify = false; 
			String err_val = "";
			HttpSession session = request.getSession(false);
			Properties property = new	Properties();
			String pract_id = request.getParameter("hid_sub");
			
			String error = "";
			int k = 0;
			//int rows = 0;
			String pract_type = request.getParameter("pract_type");
			
			String comp_id = request.getParameter("hid_sub1");
			
			property = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) property.getProperty("LOCALE");
			String facilityId = (String)session.getValue("facility_id") ;
			String client_ip_address = property.getProperty("client_ip_address");
			
			String modifiedById = (property.getProperty("login_user")==null)?"": property.getProperty("login_user")  ;           
			
			//int i = 0;
		
		try
		{
			try
			{

							//if(sql.length() > 0) sql.delete(0,sql.length());
							sql.append("delete from ");
							sql.append("SM_PERSONALIZED_HOME_PAGE where ");
							sql.append("PRACT_TYPE =? and PRACTITIONER_ID =?");
							ps = con.prepareStatement(sql.toString());
							ps.setString(1,pract_type);
							ps.setString(2,pract_id);
							 ps.executeUpdate();
							delete = true; 
							flag = true;
							if(ps != null) ps.close();
						
						/* else
						{
							 if(sql.length() > 0) sql.delete(0,sql.length());
							sql.append(" delete from ");
							sql.append("SM_PERSONALIZED_HOME_PAGE where");
							sql.append(" PRACT_TYPE =? and PRACTITIONER_ID =?");
							ps = con.prepareStatement(sql.toString());
							ps.setString(1,pract_type);
							ps.setString(2,pract_id);
							 ps.executeUpdate();
							if(ps != null) ps.close();

						}*/
			}
			catch(Exception ex)
			 {
						//out.println("Exception 1 from CAPersonalizedHomePageServlet.java -- "+ex.toString());//common-icn-0181
						ex.printStackTrace();
			 }
			
			
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<body>");
			out.println("<form name =\"insertProcess\" target =\"messageFrame\">");
			try
				 {

						/*StringTokenizer token = new StringTokenizer(comp_id,":");
						final int count = token.countTokens();
						String array[] = new String[count];

						while(token.hasMoreTokens())
						{
									val = token.nextToken();
									array[i] = val; 
									i++;
						}

						StringTokenizer token1 = new StringTokenizer(x,":");

						final int MAX =  token1.countTokens();
						int checked_value[] =  new int[MAX];
						i=0;
						while(token1.hasMoreTokens())
						{
									val = token1.nextToken();
									checked_value[i] = Integer.parseInt(val); 
									i++;
						}
						i = 0;
						int j = 0;
						comp_id = "";*/
						
							//if(sql.length() > 0) sql.delete(0,sql.length());
							sql.setLength(0);
							sql.append("INSERT INTO ");
							sql.append("SM_PERSONALIZED_HOME_PAGE ");
							sql.append("(PRACT_TYPE, PRACTITIONER_ID,");
							sql.append("DESKTOP_SUMMARY_ID, ADDED_BY_ID,ADDED_DATE,");
							sql.append("ADDED_AT_WS_NO,");
							sql.append("ADDED_FACILITY_ID,");
							sql.append("MODIFIED_BY_ID, MODIFIED_DATE,"); 
							sql.append("MODIFIED_AT_WS_NO,");
							sql.append("MODIFIED_FACILITY_ID) ");
							sql.append("VALUES ");
							sql.append("(?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
							ps = con.prepareStatement(sql.toString());
                    
							ps.setString(1,pract_type);
							ps.setString(2,pract_id);
							ps.setString(3,comp_id);
							ps.setString(4,modifiedById);	
							ps.setString(5,client_ip_address);	
							ps.setString(6,facilityId);	
							ps.setString(7,modifiedById);	
							ps.setString(8,client_ip_address);	
							ps.setString(9,facilityId);
							


							k = ps.executeUpdate();






							/*while(i < MAX)
							{
							 
								j = checked_value[i];		
								comp_id = array[j];
								ps.setString(3,comp_id);
								
								rows = rows + k;
								i++;


							}*/

							if(ps != null) ps.close();
						
						 
						
						 Hashtable htError = new Hashtable();
						 //if( (rows == MAX) || (flag == true))
						 //if(flag == true && k>0)
						 if(k>0)
						 {

							con.commit();	
							htError= MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
							error = (String) htError.get("message");
							err_val = "1";
							response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value="+err_val);
						}			
						else
						{
							con.rollback();
							htError = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
							error = (String) htError.get("message");
//							String error_value = "0";
							response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value="+err_val);

						}
			out.println("</form>");						 
			out.println("</body>");
			out.println("</html>");


					
				 }
				catch(Exception e)
				{
					//out.println("Exception 2 from CAPersonalizedHomePageServlet.java---"+e.toString());//common-icn-0181
					e.printStackTrace();
			 
				}
				finally
				 {
					try
					{
						if(ps != null) ps.close();
						con.rollback();
						
					}
					catch(Exception e)
					{
					}
						
					
				 }
		}//end of main try
		catch(Exception e)
		{
			out.println("Exception in main try of CAPersonalizedHomePageServlet.java---"+e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con);
		}
		 }//end of doPost()

		public void delete(HttpServletRequest request,HttpServletResponse response, PrintWriter out)
	 {
			//request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");			
			//String val = "";
			StringBuffer sql = new StringBuffer();
			Connection con = ConnectionManager.getConnection(request);
			PreparedStatement ps = null;
			boolean flag = false;
			boolean delete = false; 
			//boolean insert = false; 
			//boolean modify = false; 
			String err_val = "";
			HttpSession session = request.getSession(false);
			Properties property = new	Properties();
			String pract_id = request.getParameter("hid_sub");
			String error = "";
			//String x = request.getParameter("x");
			//int k = 0;
			//nt rows = 0;
			String pract_type = request.getParameter("pract_type");
			//String comp_id = request.getParameter("hid_sub1");
			property = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) property.getProperty("LOCALE");
			//String facilityId = (String)session.getValue("facility_id") ;
			//String client_ip_address = property.getProperty("client_ip_address");
			
			//String modifiedById = (property.getProperty("login_user")==null)?"": property.getProperty("login_user")  ;           
			
		//int i = 0;
			
			out.println("pract_type"+pract_type);
		try
		{
			try
			{
				
						
							//if(sql.length() > 0) sql.delete(0,sql.length());

							sql.append("delete from ");
							sql.append("SM_PERSONALIZED_HOME_PAGE where ");
							sql.append("PRACT_TYPE =? and PRACTITIONER_ID =?");
							ps = con.prepareStatement(sql.toString());
							ps.setString(1,pract_type);
							ps.setString(2,pract_id);
							 ps.executeUpdate();
							delete = true; 
							flag = true;
							if(ps != null) ps.close();
						
						/* else
						{
							 if(sql.length() > 0) sql.delete(0,sql.length());
							sql.append(" delete from ");
							sql.append("SM_PERSONALIZED_HOME_PAGE where");
							sql.append(" PRACT_TYPE =? and PRACTITIONER_ID =?");
							ps = con.prepareStatement(sql.toString());
							ps.setString(1,pract_type);
							ps.setString(2,pract_id);
							 ps.executeUpdate();
							if(ps != null) ps.close();

						}*/
			}
			catch(Exception ex)
			 {
						//out.println("Exception 1 from CAPersonalizedHomePageServlet.java -- "+ex.toString());//common-icn-0181
						ex.printStackTrace();
			 }
			
			
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<body>");
			out.println("<form name =\"insertProcess\" target =\"messageFrame\">");
			try
				 {

						/*StringTokenizer token = new StringTokenizer(comp_id,":");
						final int count = token.countTokens();
						String array[] = new String[count];

						while(token.hasMoreTokens())
						{
									val = token.nextToken();
									array[i] = val; 
									i++;
						}

						StringTokenizer token1 = new StringTokenizer(x,":");

						final int MAX =  token1.countTokens();
						int checked_value[] =  new int[MAX];
						i=0;
						while(token1.hasMoreTokens())
						{
									val = token1.nextToken();
									checked_value[i] = Integer.parseInt(val); 
									i++;
						}
						i = 0;
						int j = 0;
						comp_id = "";

						if(delete == false)
						{	
							if(sql.length() > 0) sql.delete(0,sql.length());
							sql.append("INSERT INTO ");
							sql.append("SM_PERSONALIZED_HOME_PAGE ");
							sql.append("(PRACT_TYPE, PRACTITIONER_ID,");
							sql.append("DESKTOP_SUMMARY_ID, ADDED_BY_ID,ADDED_DATE,");
							sql.append("ADDED_AT_WS_NO,");
							sql.append("ADDED_FACILITY_ID,");
							sql.append("MODIFIED_BY_ID, MODIFIED_DATE,"); 
							sql.append("MODIFIED_AT_WS_NO,");
							sql.append("MODIFIED_FACILITY_ID) ");
							sql.append("VALUES ");
							sql.append("(?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
							ps = con.prepareStatement(sql.toString());
							ps.setString(1,pract_type);
							ps.setString(2,pract_id);
							ps.setString(3,comp_id);
							ps.setString(4,modifiedById);	
							ps.setString(5,client_ip_address);	
							ps.setString(6,facilityId);	
							ps.setString(7,modifiedById);	
							ps.setString(8,client_ip_address);	
							ps.setString(9,facilityId);	

							k = ps.executeUpdate();

							/*while(i < MAX)
							{
							 
								j = checked_value[i];		
								comp_id = array[j];
								ps.setString(3,comp_id);
								
								rows = rows + k;
								i++;


							}*/

							//if(ps != null) ps.close();
						//}
						 
						
						 Hashtable htError = new Hashtable();
						 //if( (rows == MAX) || (flag == true))
						 if(flag == true)
						 { 							
							con.commit();	
							htError= MessageManager.getMessage(locale, "RECORD_DELETED","CA");
							error = (String) htError.get("message");
							err_val = "1";
							response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value="+err_val);
						}			
						else
						{
							con.rollback();
							htError = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
							error = (String) htError.get("message");
//							String error_value = "0";
							response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value="+err_val);

						}
			out.println("</form>");						 
			out.println("</body>");
			out.println("</html>");


					
				 }
				catch(Exception e)
				{
					//out.println("Exception 2 from delete  CAPersonalizedHomePageServlet.java---"+e.toString());//common-icn-0181
					e.printStackTrace();
			 
				}
				finally
				 {
					try
					{
						if(ps != null) ps.close();
						con.rollback();
						
					}
					catch(Exception e)
					{
					}
						
					
				 }
		}//end of main try
		catch(Exception e)
		{
			out.println("Exception in main try of CAPersonalizedHomePageServlet.java---"+e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con);
		}
	}//end of doPost()
		public void modify(HttpServletRequest request,HttpServletResponse response, PrintWriter out)
	 {
			//request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");			
			//String val = "";
			StringBuffer sql = new StringBuffer();
			Connection con = ConnectionManager.getConnection(request);
			PreparedStatement ps = null;
			boolean flag = false;
			boolean delete = false; 
			//boolean insert = false; 
			//boolean modify = false; 
			String err_val = "";
			HttpSession session = request.getSession(false);
			Properties property = new	Properties();
			String pract_id = request.getParameter("hid_sub");
			String error = "";
			//String x = request.getParameter("x");
			int k = 0;
			//int rows = 0;
			String pract_type = request.getParameter("pract_type");
			String comp_id = request.getParameter("hid_sub1");
			property = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) property.getProperty("LOCALE");
			//String facilityId = (String)session.getValue("facility_id") ;
			//String client_ip_address = property.getProperty("client_ip_address");
			
			//String modifiedById = (property.getProperty("login_user")==null)?"": property.getProperty("login_user")  ;           
			
			//int i = 0;
			
		try
		{
			try
			{
				
						
							//if(sql.length() > 0) sql.delete(0,sql.length());

							sql.append("update ");
							sql.append("SM_PERSONALIZED_HOME_PAGE set DESKTOP_SUMMARY_ID=? where ");
							sql.append("PRACT_TYPE =? and PRACTITIONER_ID =?");
							ps = con.prepareStatement(sql.toString());
							ps.setString(1,comp_id);
							ps.setString(2,pract_type);
							ps.setString(3,pract_id);
                        
							k=ps.executeUpdate();
							delete = true; 
							flag = true;
							if(ps != null) ps.close();
						
						/* else
						{
							 if(sql.length() > 0) sql.delete(0,sql.length());
							sql.append(" delete from ");
							sql.append("SM_PERSONALIZED_HOME_PAGE where");
							sql.append(" PRACT_TYPE =? and PRACTITIONER_ID =?");
							ps = con.prepareStatement(sql.toString());
							ps.setString(1,pract_type);
							ps.setString(2,pract_id);
							 ps.executeUpdate();
							if(ps != null) ps.close();

						}*/
			}
			catch(Exception ex)
			 {
						//out.println("Exception 1 from CAPersonalizedHomePageServlet.java -- "+ex.toString());//common-icn-0181
						ex.printStackTrace();
			 }
			
			
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<body>");
			out.println("<form name =\"insertProcess\" target =\"messageFrame\">");
			try
				 {

						/*StringTokenizer token = new StringTokenizer(comp_id,":");
						final int count = token.countTokens();
						String array[] = new String[count];

						while(token.hasMoreTokens())
						{
									val = token.nextToken();
									array[i] = val; 
									i++;
						}

						StringTokenizer token1 = new StringTokenizer(x,":");

						final int MAX =  token1.countTokens();
						int checked_value[] =  new int[MAX];
						i=0;
						while(token1.hasMoreTokens())
						{
									val = token1.nextToken();
									checked_value[i] = Integer.parseInt(val); 
									i++;
						}
						i = 0;
						int j = 0;
						comp_id = "";
						if(delete == false)
						{	
							if(sql.length() > 0) sql.delete(0,sql.length());
							sql.append("INSERT INTO ");
							sql.append("SM_PERSONALIZED_HOME_PAGE ");
							sql.append("(PRACT_TYPE, PRACTITIONER_ID,");
							sql.append("DESKTOP_SUMMARY_ID, ADDED_BY_ID,ADDED_DATE,");
							sql.append("ADDED_AT_WS_NO,");
							sql.append("ADDED_FACILITY_ID,");
							sql.append("MODIFIED_BY_ID, MODIFIED_DATE,"); 
							sql.append("MODIFIED_AT_WS_NO,");
							sql.append("MODIFIED_FACILITY_ID) ");
							sql.append("VALUES ");
							sql.append("(?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
							ps = con.prepareStatement(sql.toString());
							ps.setString(1,pract_type);
							ps.setString(2,pract_id);
							ps.setString(3,comp_id);
							ps.setString(4,modifiedById);	
							ps.setString(5,client_ip_address);	
							ps.setString(6,facilityId);	
							ps.setString(7,modifiedById);	
							ps.setString(8,client_ip_address);	
							ps.setString(9,facilityId);	

							k = ps.executeUpdate();

							/*while(i < MAX)
							{
							 
								j = checked_value[i];		
								comp_id = array[j];
								ps.setString(3,comp_id);
								
								rows = rows + k;
								i++;


							}*/

							//if(ps != null) ps.close();
						//}
						 
						
						 Hashtable htError = new Hashtable();
						 //if( (rows == MAX) || (flag == true))
						 if(flag == true && k>0)
						 { 							
							con.commit();	
							htError= MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
							error = (String) htError.get("message");
							err_val = "1";
							response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value="+err_val);
						}			
						else
						{
							con.rollback();
							htError = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
							error = (String) htError.get("message");
//							String error_value = "0";
							response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value="+err_val);

						}
			out.println("</form>");						 
			out.println("</body>");
			out.println("</html>");


					
				 }
				catch(Exception e)
				{
					//out.println("Exception 2 from update CAPersonalizedHomePageServlet.java---"+e.toString());//common-icn-0181
					e.printStackTrace();
			 
				}
				finally
				 {
					try
					{
						if(ps != null) ps.close();
						con.rollback();
						
					}
					catch(Exception e)
					{
					}
						
					
				 }
		}//end of main try
		catch(Exception e)
		{
			out.println("Exception in main try of CAPersonalizedHomePageServlet.java---"+e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con);
		}
    }//end of doPost()

 }


