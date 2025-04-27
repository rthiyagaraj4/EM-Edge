/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import eCommon.Common.*;
import webbeans.eCommon.*;

import eRS.RSManageWorkScheduleCancel.*;

public class ManageWorkScheduleCancelServlet extends HttpServlet
{
	private ServletConfig config = null;
	PrintWriter out = null;
	HttpSession session = null;
	Properties prop = new Properties();
	String client_ip_address = "";
	String err_num="";
	String total_records="";
	String activity_type="";
	String reason_code="";
	String remarks="";
	String date_from="";
	String date_to="";
	String locn_type="";
	String facility_id="";
	String workplace_code="";
	String requirement_id="";
	String role_type="";
	String staff_type="";
	String staff_id="";
	String position_code="";
	String schedule_date="";
	String shift_code="";
	String shift_mnemonic="";
	String shift_start_time="";
	String shift_end_time="";
	String schedule_type="";
	String over_time_durn="";
	String activity_id="";
	String productive_flag="";
	String shift_indicator="";
	String return_value="";
	String s_tilde="~";
	String select="";
	String added_by_id = "";
	String added_facility_id = "";
	String locale				="";
	int n=0;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
        	session = request.getSession(false);
			this.facility_id = (String) session.getAttribute( "facility_id" ) ;
			this.prop = (java.util.Properties) session.getAttribute( "jdbc" ) ;
			client_ip_address = prop.getProperty("client_ip_address");
			locale=(String)session.getAttribute("LOCALE");
		
		try	
		{
			request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8"); 
		    this.out = response.getWriter();
			cancel(request);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='/eCIS/ip/js/NursUnitRoom.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Rooms For Nursing Unit' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	
		{
			out.println(e.toString());
		}
	}

	public void cancel(HttpServletRequest request) 
	{
		try
		{	
    		added_by_id 	= prop.getProperty( "login_user" ) ;
			added_facility_id=(String)session.getAttribute("facility_id");

			added_facility_id= facility_id;

			total_records=request.getParameter("total_Records");

            activity_type="CS";
            reason_code=request.getParameter("Reason");
            remarks= request.getParameter("Remarks");
  			schedule_date=request.getParameter("schedule_date"); 
			date_from=schedule_date;
            date_to=schedule_date;
            locn_type=request.getParameter("locn_type");
            facility_id=request.getParameter("facility_id");
            workplace_code=request.getParameter("workplace_code"); 
            requirement_id=request.getParameter("requirement_id"); 
            role_type=request.getParameter("role_type");
            staff_type=request.getParameter("staff_type");
            staff_id=request.getParameter("staff_id");
            position_code=request.getParameter("position_code");
            over_time_durn="";
			activity_id=request.getParameter("activity_id");

			HashMap tabData=new HashMap();

			n=Integer.parseInt(total_records);

			tabData.put("total_records",total_records);
			tabData.put("activity_type",activity_type);
			tabData.put("reason_code",reason_code);
			tabData.put("remarks",remarks);
			tabData.put("date_from",date_from);
			tabData.put("date_to",date_to);
			tabData.put("locn_type",locn_type);
			tabData.put("facility_id",facility_id);
			tabData.put("workplace_code",workplace_code);
			tabData.put("requirement_id",requirement_id);
			tabData.put("role_type",role_type);
			tabData.put("staff_type",staff_type);
			tabData.put("staff_id",staff_id);
			tabData.put("position_code",position_code);
			tabData.put("schedule_date",schedule_date);
			tabData.put("activity_id",activity_id);

        	StringBuffer return_buffer=new StringBuffer();
    		int k=0;
    		int l=0;

			for(int i=1;i<=n;i++)
			{
    		select=request.getParameter("select"+(i))==null?"N":request.getParameter("select"+(i));
            shift_code=request.getParameter("shift_code"+(i));
            shift_mnemonic=request.getParameter("shift_mnemonic"+(i));
            shift_start_time=request.getParameter("shift_start_time"+(i));
            shift_end_time=request.getParameter("shift_end_time"+(i)); 
            schedule_type=request.getParameter("schedule_type"+(i)); 
    		shift_indicator=request.getParameter("shift_indicator"+(i));
			productive_flag=request.getParameter("productive_flag"+(i));

    	    if(select.equals("Y"))
			{
			HashMap selectedItem=new HashMap();

			selectedItem.put("shift_code",shift_code);
			selectedItem.put("shift_mnemonic",shift_mnemonic);
			selectedItem.put("shift_start_time",shift_start_time);
			selectedItem.put("shift_end_time",shift_end_time);
			selectedItem.put("schedule_type",schedule_type);

			tabData.put(("selectedItem"+(++k)),selectedItem);

        	return_value=shift_code+"|"+shift_mnemonic+"|"+shift_indicator+"|"+productive_flag;

			if(l==0)
			{
				return_buffer.append(return_value);
				l++;
			}
			else if(l>=0)
			{
				return_buffer.append(s_tilde);
				return_buffer.append(return_value);
    			l++;
			}
		}
			}

			String record=String.valueOf(k);
			tabData.put("Records",record);
			tabData.put("over_time_durn",over_time_durn);
    	    tabData.put("added_by_id", added_by_id);
		    tabData.put("added_at_ws_no",  client_ip_address);
		    tabData.put("added_facility_id",  added_facility_id);
		    tabData.put("locale",  locale);
		    tabData.put("properties",prop);
			//System.out.println("tabData in servlet 188----|"+tabData+"|-----locale in servlet 159----|"+locale+"|----");

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSManageWorkScheduleCancel", eRS.RSManageWorkScheduleCancel.RSManageWorkScheduleCancelLocalHome.class, local_ejbs);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[1];
			aobj[0] = tabData;
			Class aclass[] = new Class[1];
			aclass[0] = tabData.getClass();
			HashMap map=(HashMap)obj1.getClass().getMethod("cancelshift", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);
			//System.err.println("Map in servlet 202----|"+map+"|----");

			String result = ((Boolean)map.get("result")).toString();

			String total_return_value=return_buffer.toString();
    		err_num =(String)map.get("message");
			//System.out.println("result in servlet 208----|"+result+"|-----err_num in servlet 207-----|"+err_num+"|----");
			if(result.equals("true")){
					out.println("<script>alert('"+err_num+"');</script>");
					out.println("<script>window.close();</script>");
					out.println("<script>window.returnValue='"+total_return_value+"';</script>");
			}
			else{
				out.println("<script>alert('"+err_num+"');</script>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
}
