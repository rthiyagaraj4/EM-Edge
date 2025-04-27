/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eMP.TerminalDigit.* ;

public class TerminalDigitServlet extends HttpServlet {
	PrintWriter out;
	java.util.Properties p;
	String Facility_Id = "";
	String level="";
	String mr_section="";
	String terminal_digit_count;
	String group_count = "";
	String terminal_digit1_position="";
	String terminal_digit2_position="";
	String terminal_digit3_position="";
	String terminal_digit4_position="";
	String terminal_digit5_position="";
	String terminal_digit6_position="";
	String terminal_digit7_position="";
	String facilityId;
	String client_ip_address;
	String pt1="", pt2="", pt3="", pt4="", pt5="", pt6="", pt7="", pt8="";
	String st1="", st2="", st3="", st4="", st5="", st6="", st7="", st8="";
	String tt1="", tt2="", tt3="", tt4="", tt5="", tt6="", tt7="", tt8="";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
					throws javax.servlet.ServletException,IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		
		String operation = req.getParameter("function1");		
		try {
			this.out = res.getWriter();
				
			if(operation.equals("insert"))  insertTerminalDigits(req, res);	
			if(operation.equals("delete")) deleteTerminalDigits(req,res);			
		}
		catch (Exception e)	{
			  out.println(e.toString());
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException {
		try	{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();

			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;

			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/TerminalDigit.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e){	}
	}
	private void insertTerminalDigits(HttpServletRequest req, HttpServletResponse res) {
		try {
			
			Facility_Id = req.getParameter("Facility_Name")==null?"":req.getParameter("Facility_Name");
			level = req.getParameter("level")==null?"":req.getParameter("level");
			mr_section = req.getParameter("mr_section")==null?"":req.getParameter("mr_section");
			pt1 = req.getParameter("pt1")==null?"":req.getParameter("pt1");
			pt2 = req.getParameter("pt2")==null?"":req.getParameter("pt2");
			pt3 = req.getParameter("pt3")==null?"":req.getParameter("pt3");
			pt4 = req.getParameter("pt4")==null?"":req.getParameter("pt4");
			pt5 = req.getParameter("pt5")==null?"":req.getParameter("pt5");
			pt6 = req.getParameter("pt6")==null?"":req.getParameter("pt6");
			pt7 = req.getParameter("pt7")==null?"":req.getParameter("pt7");
			pt8 = req.getParameter("pt8")==null?"":req.getParameter("pt8");
			st1 = req.getParameter("st1")==null?"":req.getParameter("st1");
			st2 = req.getParameter("st2")==null?"":req.getParameter("st2");
			st3 = req.getParameter("st3")==null?"":req.getParameter("st3");
			st4 = req.getParameter("st4")==null?"":req.getParameter("st4");
			st5 = req.getParameter("st5")==null?"":req.getParameter("st5");
			st6 = req.getParameter("st6")==null?"":req.getParameter("st6");
			st7 = req.getParameter("st7")==null?"":req.getParameter("st7");
			st8 = req.getParameter("st8")==null?"":req.getParameter("st8");
			tt1 = req.getParameter("tt1")==null?"":req.getParameter("tt1");
			tt2 = req.getParameter("tt2")==null?"":req.getParameter("tt2");
			tt3 = req.getParameter("tt3")==null?"":req.getParameter("tt3");
			tt4 = req.getParameter("tt4")==null?"":req.getParameter("tt4");
			tt5 = req.getParameter("tt5")==null?"":req.getParameter("tt5");
			tt6 = req.getParameter("tt6")==null?"":req.getParameter("tt6");
			tt7 = req.getParameter("tt7")==null?"":req.getParameter("tt7");
			tt8 = req.getParameter("tt8")==null?"":req.getParameter("tt8");
			
			//if not selected in checkbox the values should be blank.
			if(pt8.equals("N")||pt8.equals("")) {
				pt1=""; pt2=""; pt3=""; pt4=""; pt5=""; pt6=""; pt7="";
			}
			if(st8.equals("N")||st8.equals("")) {
				st1=""; st2=""; st3=""; st4=""; st5=""; st6=""; st7="";
			}
			if(tt8.equals("N")||tt8.equals("")) {
				tt1=""; tt2=""; tt3=""; tt4=""; tt5=""; tt6=""; tt7="";
			}

		  terminal_digit_count = req.getParameter("terminal_digit_count");
		  if(terminal_digit_count==null)terminal_digit_count="";
		  group_count = req.getParameter("group_count");
		  if(group_count==null)group_count="";
		  terminal_digit1_position = req.getParameter("terminal_digit1_position");
  		  if(terminal_digit1_position==null)terminal_digit1_position="";
		  terminal_digit2_position = req.getParameter("terminal_digit2_position");
		  if(terminal_digit2_position==null)terminal_digit2_position="";
		  terminal_digit3_position = req.getParameter("terminal_digit3_position");
		  if(terminal_digit3_position==null)terminal_digit3_position="";
		  terminal_digit4_position = req.getParameter("terminal_digit4_position");
		  if(terminal_digit4_position==null)terminal_digit4_position="";
		  terminal_digit5_position = req.getParameter("terminal_digit5_position");
  		  if(terminal_digit5_position==null)terminal_digit5_position="";
		  terminal_digit6_position = req.getParameter("terminal_digit6_position");
  		  if(terminal_digit6_position==null)terminal_digit6_position="";
		  terminal_digit7_position = req.getParameter("terminal_digit7_position");
  		  if(terminal_digit7_position==null)terminal_digit7_position="";

			String addedFacilityId=facilityId;

			HashMap tabdata=new HashMap();
			HashMap tabdata1=new HashMap();
			tabdata.put("facility_id",Facility_Id);
			tabdata.put("term_digit_level",level);
			tabdata.put("mr_section_code",mr_section);
            tabdata.put("no_of_term_digit",terminal_digit_count);
			tabdata.put("no_of_term_digit_group",group_count);
			tabdata.put("term_digit1_position",terminal_digit1_position );
            tabdata.put("term_digit2_position",terminal_digit2_position );
            tabdata.put("term_digit3_position",terminal_digit3_position );
            tabdata.put("term_digit4_position",terminal_digit4_position );
            tabdata.put("term_digit5_position",terminal_digit5_position );
            tabdata.put("term_digit6_position",terminal_digit6_position );
            tabdata.put("term_digit7_position",terminal_digit7_position );
			tabdata1.put("facility_id",Facility_Id);
			tabdata1.put("term_digit_level",level);
			tabdata1.put("mr_section_code",mr_section);
			tabdata1.put("term_digit_grp1_position1",pt1);
			tabdata1.put("term_digit_grp1_position2",pt2);
			tabdata1.put("term_digit_grp1_position3",pt3);
			tabdata1.put("term_digit_grp1_position4",pt4);
			tabdata1.put("term_digit_grp1_position5",pt5);
			tabdata1.put("term_digit_grp1_position6",pt6);
			tabdata1.put("term_digit_grp1_position7",pt7);
			tabdata1.put("term_digit_grp1_id",pt8);
			tabdata1.put("term_digit_grp2_position1",st1);
			tabdata1.put("term_digit_grp2_position2",st2);
			tabdata1.put("term_digit_grp2_position3",st3);
			tabdata1.put("term_digit_grp2_position4",st4);
			tabdata1.put("term_digit_grp2_position5",st5);
			tabdata1.put("term_digit_grp2_position6",st6);
			tabdata1.put("term_digit_grp2_position7",st7);
			tabdata1.put("term_digit_grp2_id",st8);
			tabdata1.put("term_digit_grp3_position1",tt1);
			tabdata1.put("term_digit_grp3_position2",tt2);
			tabdata1.put("term_digit_grp3_position3",tt3);
			tabdata1.put("term_digit_grp3_position4",tt4);
			tabdata1.put("term_digit_grp3_position5",tt5);
			tabdata1.put("term_digit_grp3_position6",tt6);
			tabdata1.put("term_digit_grp3_position7",tt7);
			tabdata1.put("term_digit_grp3_id",tt8);

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) {
				local_ejbs = true;
			}

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/TerminalDigit",TerminalDigitLocalHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[] = new Object[5];
		argArray[0] = p;
		argArray[1] = client_ip_address;
		argArray[2] = addedFacilityId;
		argArray[3] = tabdata;
		argArray[4] = tabdata1;
		Class [] paramArray = new Class[5];
		paramArray[0] = p.getClass();
		paramArray[1] = String.class;
		paramArray[2] = String.class;
		paramArray[3] = tabdata.getClass();
		paramArray[4] = tabdata1.getClass();
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertTerminalDigit",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;
			tabdata.clear();
			tabdata1.clear();
			results.clear();
			
			if ( inserted ) {
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			}
			else {
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			}
		 }
		catch ( Exception e ) {
			//out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
	}
	private void deleteTerminalDigits(HttpServletRequest req, HttpServletResponse res) {
		try {
			Facility_Id = req.getParameter("Facility_Name")==null?"":req.getParameter("Facility_Name");
			level = req.getParameter("level")==null?"":req.getParameter("level");
			mr_section = req.getParameter("mr_section")==null?"":req.getParameter("mr_section");
			HashMap tabdata=new HashMap();			
			tabdata.put("facility_id",Facility_Id);
			tabdata.put("term_digit_level",level);
			tabdata.put("mr_section_code",mr_section);			

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) {
				local_ejbs = true;
			}
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/TerminalDigit",TerminalDigitLocalHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deleteTerminalDigit",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean deleted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;

			tabdata.clear();
			results.clear();

			if ( deleted ) {
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			}
			else {
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8") );
			}
		} 
		catch ( Exception e ) {
			//out.println(e.getMessage());
			//out.println(e.toString());
			e.printStackTrace(); // Added by lakshmanan for security issue ID 169519805 on 24-08-2023
		}
	}
}
