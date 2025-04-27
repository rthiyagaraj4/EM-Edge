/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eSM.DBRole.*;
public class DatabaseRoleServlet extends javax.servlet.http.HttpServlet{

PrintWriter out;
Properties p;
String error="";
String ora_role_id1;
String ora_role_password1;
String ora_role_password2 ;
String old_password="";
String current_password="";
Connection con=null;
String locale="";
public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		HttpSession session		= req.getSession(true);
		this.p			  		= (java.util.Properties) session.getValue( "jdbc" ) ;
		locale=p.getProperty("LOCALE");
	try {
             req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
             
            
			PreparedStatement pstmt=null;
			ora_role_id1 	 	=	req.getParameter("ObjVal");
			
			old_password = req.getParameter("old_password");
			ora_role_password1 = req.getParameter("new_password1");
			ora_role_password2 = req.getParameter("new_password2");

			con = ConnectionManager.getConnection(req);

			pstmt		= con.prepareStatement( "SELECT app_password.decrypt(ora_role_password) password from sm_ora_role where ora_role_id = ?" ) ;
	        pstmt.setString( 1, ora_role_id1 ) ;
	        ResultSet rs = pstmt.executeQuery() ;
            if ( rs != null && rs.next() )
		    current_password = rs.getString( "password" ) ;
	        
			if(rs!=null) rs.close();
	        if(pstmt!=null) pstmt.close();
			MessageManager mm=new MessageManager();

			if(!(current_password.equals(old_password)))
		    {
			            java.util.Hashtable mesg=mm.getMessage(locale, "INCORRECT_OLD_PW", "SM") ;
                        String err=(String)mesg.get("message");			//String err="APP-SM0046 Incorrect Old Password...";	
			out.println("<script> alert('"+err+"');parent.frames[4].location.href='../../eCommon/html/blank.html'</script>");
		   	mesg.clear();
			
			}else   if ( current_password.equals(ora_role_password1 )|| current_password.equals(ora_role_password2))
		   {
               java.util.Hashtable mesg=mm.getMessage(locale, "OLD_NEW_PW_SAME", "SM") ;
             String  err=(String)mesg.get("message");
				//String err="APP-SM0053 Old and New Passwords are same...";
             out.println("<script> alert('"+err+"');parent.frames[4].location.href='../../eCommon/html/blank.html'</script>");
		   			mesg.clear();
            }else
		{
			
			modifyOraRole();
		}
		}catch (Exception e)
			{
				out.println(e.toString());
			}


finally	{
			  if (con != null)
			  {
			   try {
									 
				 ConnectionManager.returnConnection(con,req);
		       } catch (Exception ee) {}
		      }

		}


    }

private void modifyOraRole()	{
	try {
			
			
		
				
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/DatabaseRoleManager",DatabaseRoleHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			HashMap argMap=new HashMap ();
			argMap.put("p",p);
			argMap.put("ora_role_id1",ora_role_id1);
			argMap.put("ora_role_password1",ora_role_password1);
			argMap.put("addedAtWorkstation",p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address"));
			

			Object argArray[] = new Object[1];
			argArray[0] =argMap ;

			Class [] paramArray = new Class[1];

			paramArray[0] = argMap.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateOraRole",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);		

			error = (String) results.get("error") ; 

			
			
			out.println("<script>parent.frames[3].location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode( error, "UTF-8" ) +"&err_value=1'</script>");

            argMap.clear();
			results.clear();
		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;

			}
	}//E.O.Method
}
