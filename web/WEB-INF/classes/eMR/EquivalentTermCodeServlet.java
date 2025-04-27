/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
//import com.medicom.ESLP.ServiceLocator;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.*;
import java.util.Properties;
import javax.servlet.*;
import javax.sql.*;
import java.sql.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
public class EquivalentTermCodeServlet extends HttpServlet
{
  
	 PrintWriter out;
	    Properties p;
	    HttpSession session;
	    private ServletConfig config;
	    String eff_status;
	    String selectable;
	    String added_by_id;
	    String added_at_ws_no;
	    String added_facility_id;
	    String modified_by_id;
	    String modified_at_ws_no;
	    String modified_facility_id;
	    String client_ip_address;
	    String error_value;
	    Connection connection =null;
	    PreparedStatement pstmt = null;
		//Statement st = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//Statement st1 = null;
		PreparedStatement st1 = null;
		ArrayList ListAll;
		ArrayList checkvalues=new ArrayList();
		ResultSet resultset = null;
		Statement statement = null;
		String msg = "";
		String s2="";
		String s3="";
		String s4="";
		String s5="";
		String s6="";
		String check_val="";
	    String d = "";
		int rcnt=0;
		String term_set_id;
		String type_set;
		String term_code;
		String equivalent_term_set_id;
		String locale="";
		int tmpcount=0;
	
	public EquivalentTermCodeServlet()
    {
        config = null;

		eff_status = "";
        selectable = "";
        added_by_id = "";
        added_at_ws_no = "";
        added_facility_id = "";
        modified_by_id = "";
        modified_at_ws_no = "";
        modified_facility_id = "";
        client_ip_address = "";
        error_value = "0";
	    term_set_id="";
		type_set="";
		term_code="";
		equivalent_term_set_id="";
		}

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        config = servletconfig;
    }

    public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
		httpservletrequest.setCharacterEncoding("UTF-8");
		httpservletresponse.setContentType("text/html;charset=UTF-8");
        out = httpservletresponse.getWriter();
        session = httpservletrequest.getSession(false);
        p = (Properties)session.getValue("jdbc");
		locale = p.getProperty("LOCALE");
        added_facility_id = (String)session.getValue("facility_id");
        client_ip_address = p.getProperty("client_ip_address");
        modified_by_id = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		modified_facility_id = added_facility_id != null ? added_facility_id : "";
        modified_at_ws_no = client_ip_address != null ? client_ip_address : "";
		connection=ConnectionManager.getConnection(httpservletrequest);
        try
        {
    
           
                insert(httpservletrequest, httpservletresponse);
            
        }
        catch(Exception exception)
        {
           // out.println("Exception in try of doPost() of TerminologyCodeServlet.java" + exception);
			exception.printStackTrace();
        }
    }

    public synchronized void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
            out = httpservletresponse.getWriter();
            //httpservletresponse.setContentType("text/html");
            doPost(httpservletrequest, httpservletresponse);
        }
        catch(Exception exception)
        {
            //out.println("Exception in doGet() of TerminologyCodeServlet.java" + exception);
			exception.printStackTrace();
        }
    }

    private void insert(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
			httpservletrequest.setCharacterEncoding("UTF-8");
			httpservletresponse.setContentType("text/html;charset=UTF-8");
   			ArrayList arraylist = new ArrayList();
			ArrayList arraylist_code = new ArrayList();
			String msg_chk = httpservletrequest.getParameter("msg");
			String obj =httpservletrequest.getParameter("obj") != null ?httpservletrequest.getParameter("obj") : "";
			added_by_id = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
            added_facility_id = added_facility_id != null ? added_facility_id : "";
            added_at_ws_no = client_ip_address != null ? client_ip_address : "";
            term_set_id=httpservletrequest.getParameter("FirstConbox");//!=null 
			term_code=httpservletrequest.getParameter("SecondValue");//!=null 
			equivalent_term_set_id=httpservletrequest.getParameter("ThirdConbox");//!=null 
			type_set=httpservletrequest.getParameter("type_set");//!=null          
			selectable = httpservletrequest.getParameter("selectable") != null ? httpservletrequest.getParameter("selectable") : "N";
            s5 = httpservletrequest.getParameter("from") != null ? httpservletrequest.getParameter("from") : "0";
			 s6 = httpservletrequest.getParameter("to") != null ? httpservletrequest.getParameter("to") : "0";
            int from = Integer.parseInt(s5);
			int to = Integer.parseInt(s6);



			if (msg_chk.equals("y"))
			{
				from = from;
				to = to;
					
			}
			else if(obj.equals("Previous"))
			{
				from = from+7;
				to = to+7;
			}
			else if(obj.equals("Next"))
			{
				from = from-7;
				to = to-7;
			}
						
	 		for(int i = from; i <= to; i++)			
		    {
				String s4 = httpservletrequest.getParameter("chks_factor" + i) != null ? httpservletrequest.getParameter("chks_factor" + i) : "D";
		           
			    if(s4.equals("E"))
				{
						String s3 = httpservletrequest.getParameter("factor_code" + i);
                  		
						arraylist.add(s3);
				}
				 s3 = httpservletrequest.getParameter("factor_code" + i);
				arraylist_code.add(s3);
			}

		
			/* st = connection.createStatement();
			st1 = connection.createStatement();	 */

	      for(int i=0; i<arraylist_code.size(); i++)
			{ 

			String equivalent_term_code= (String)arraylist_code.get(i);
			String sq = "select * from MR_EQUIVALENT_TERM_CODE where  TERM_SET_ID=? and TERM_CODE=? and EQUIVALENT_TERM_SET_ID=? and EQUIVALENT_TERM_CODE=? and CROSS_REF_TYPE=?";
			
			st = connection.prepareStatement(sq);
							st.setString(1, term_set_id);
							st.setString(2, term_code);
							st.setString(3, equivalent_term_set_id);
							st.setString(4, equivalent_term_code);
							st.setString(5, type_set);
			rs = st.executeQuery();
				
				while(rs!=null && rs.next())
				{
					sq = "delete from MR_EQUIVALENT_TERM_CODE where  TERM_SET_ID=? and TERM_CODE=? and EQUIVALENT_TERM_SET_ID=? and EQUIVALENT_TERM_CODE=? and CROSS_REF_TYPE=?";
					//int val=st.executeUpdate(sq);
					st1 = connection.prepareStatement(sq);
							st1.setString(1, term_set_id);
							st1.setString(2, term_code);
							st1.setString(3, equivalent_term_set_id);
							st1.setString(4, equivalent_term_code);
							st1.setString(5, type_set);
					st1.executeUpdate();
					
					
				}
				if(rs!=null) rs.close(); //Added for checkstyle
				if(st!=null) st.close(); //Added for checkstyle issue DEC23
				if(st1!=null) st1.close(); //Added for checkstyle issue DEC23
				//if(rs!=null)
					//rs.close();

			}

			/*if(rs!=null)
				rs.close();
			if(st!=null)
				st.close();
			if(st1!=null)
				st1.close();*/

			for(int i=0; i<arraylist.size(); i++)
			{ 
			String equivalent_term_code= (String)arraylist.get(i);
			String sql_insert2="insert into MR_EQUIVALENT_TERM_CODE(TERM_SET_ID,TERM_CODE,EQUIVALENT_TERM_SET_ID,EQUIVALENT_TERM_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,CROSS_REF_TYPE)VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
			pstmt=connection.prepareStatement(sql_insert2);
			pstmt.setString(1,term_set_id);
			pstmt.setString(2,term_code);
			pstmt.setString(3,equivalent_term_set_id);
			pstmt.setString(4,equivalent_term_code);
			pstmt.setString(5,added_by_id);
			pstmt.setString(6,added_at_ws_no);
			pstmt.setString(7,added_facility_id);
			pstmt.setString(8,modified_by_id);
			pstmt.setString(9,modified_at_ws_no);
			pstmt.setString(10,modified_facility_id);
			pstmt.setString(11,type_set);
			rcnt=pstmt.executeUpdate();
			if(pstmt !=null) pstmt.close(); //Added for checkstyle

		    
								
        }

		//if(pstmt !=null) pstmt.close(); //Commented for checkstyle


	if (rcnt>=1)
			{
				connection.commit();
				if (msg_chk.equals("y"))
				{
					//s1 = "APP-SM0001 Operation Completed Successfully ....";
					java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
					msg = (String) message.get("message");				
			
				}
				else
					msg = "";

				httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg, "UTF-8" ) + "&err_value=" + msg);
			
			}
		
		
		}
        catch(Exception exception)
        {
			try{

			connection.rollback();
			}
			catch(Exception aa){}
           /*  out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + exception.toString());
			//exception.printStackTrace(System.err);
			System.out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + exception.toString()); */
			
			exception.printStackTrace();
        }
		finally{
			if (connection != null)
			{
				ConnectionManager.returnConnection(connection,httpservletrequest);
			}
			try
			{
				if(rs!=null)
					rs.close();
				if(st!=null)
					st.close();
				if(st1!=null)
					st1.close();
				if(pstmt !=null) pstmt.close();
				//if(pst_upd_mr_adv_cause !=null) pst_upd_mr_adv_cause.close();
			}
			catch (Exception e)
			{
			}
		}
    }


   
}
