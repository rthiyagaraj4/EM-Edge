/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;

//import oracle.aurora.jndi.sess_iiop.ServiceCtx ;
public class BLLogInCashCounterServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	//HttpServletRequest	 HTTPreq ;
	//HttpServletResponse	HTTPres;
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{		
		//String mysql = "";
		String client_ip_address="";
		String login_user="";
		String facility_id = "";
		String cashcounter = "";
		String opening_balance = "";
		//String errorcode = "";
		java.util.Properties p = null;
		HttpSession session = req.getSession(false);
		cashcounter = req.getParameter("cashcounter");
		if (cashcounter == null) cashcounter="";
		facility_id = (String)session.getAttribute("facility_id") ;
		p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		login_user = p.getProperty( "login_user" ) ;
		opening_balance = req.getParameter("opening_balance");
		if ((opening_balance == null) ||(opening_balance.equals("")) ) opening_balance="0";

		double double_opening_balance = Double.valueOf(opening_balance).doubleValue();
//		String loginsuccess=req.getParameter("loin");
		
		try 
		{
				this.out = res.getWriter();
//				out.println("<html>");
//				out.println("<head>");
				Connection con = ConnectionManager.getConnection(req);				
				con.setAutoCommit(false);					
//				System.out.println("Inside CashCounter Login Servlet");
//				System.out.println("login_user:"+login_user);
//				System.out.println("facility_id:"+facility_id);
//				System.out.println("cashcounter:"+cashcounter);
//				System.out.println("double_opening_balance:"+double_opening_balance);
//				System.out.println("client_ip_address:"+client_ip_address);
				//debug(con+"");
				//debug("mysql			= "+	mysql            );
				//debug("client_ip_address="+	client_ip_address);
				//debug("login_user		="+	login_user       );
				//debug("facility_id		="+	facility_id      );
				//debug("cashcounter		="+	cashcounter      );
				//debug("opening_balance	="+	opening_balance  );
				//debug("errorcode		="+	errorcode        );

					try
					{
						CallableStatement call = con.prepareCall("{ call bl_cash_counter_check.insert_cash_counter(?,?,?,?,?,?,?,?) }");						
						call.setString(1,login_user);
						call.setString(2,facility_id);
						call.setString(3,cashcounter);
						call.setDouble(4,double_opening_balance);
						call.setString(5,client_ip_address); 	
						call.registerOutParameter(6,java.sql.Types.VARCHAR); // _hcard_scheme_id out varchar2,
						call.registerOutParameter(7,java.sql.Types.VARCHAR); 
						call.registerOutParameter(8,java.sql.Types.VARCHAR); 
						call.execute();

		      
						String err_level = call.getString(6);   
						String sys_message_id = call.getString(7);
						String err_text = call.getString(8);	
//						System.out.println("err_level in servlet "+err_level);
//						System.out.println("sys_message_id in servlet "+sys_message_id);
//						System.out.println("err_text in servlet "+err_text);
						
						
						if ((err_level == null)|| err_level.equalsIgnoreCase("null")) err_level="";
						if ((err_text == null)|| err_text.equalsIgnoreCase("null")) err_text="";
						if ((sys_message_id == null)|| sys_message_id.equalsIgnoreCase("null")) sys_message_id="";

					    if((err_level.equals("10") && !err_text.equals("")) || !(sys_message_id.equals("")))
						{
								if(err_level.equals("10") && !err_text.equals(""))
								{
									out.println("<script> alert('"+err_text+"');  parent.window.close(); </script>");
								}
								if(!sys_message_id.equals(""));
								{
									out.println("<script> alert(getMessage('"+sys_message_id+"','BL'));  parent.window.close(); </script>");
								}

								con.rollback();
						}	
						else
						{
							con.commit();
//							System.out.println("loginsuccess" +loginsuccess);
							out.println("SUCCESS");
							//out.println("<script> alert('"+loginsuccess+"'); </script>");
//							out.println("<script> parent.bl_cashier_login.home(); </script>");
							
						}
						call.close();
						
					}
					catch(Exception exp)
					{
						con.rollback();
						//debug(exp+"=Error2");;
						//out.println("error="+exp);
						exp.printStackTrace();
					}
		

				ConnectionManager.returnConnection(con, req);
//				out.println("</head>");
//				out.println("</html>");
		}
		catch(Exception e)
		{
			//debug(e+"=Main");;
			//out.println("Err="+e);
			e.printStackTrace();
		}
		 
	}
}
