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
import webbeans.eCommon.*;
import java.net.*;

import eRS.RSAccessRights.*;

public class AccessRightsServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel{
	PrintWriter out;
	java.util.Properties properties;

	String facility_id;
	String user_id="";
	String workplace_code="";
	String setup_yn="";
	String allocate_yn="";
	String reallocate_yn="";
	String cancel_yn="";
	String select_yn="";
	String added_by_id = "";
	String db_action="";
	String client_ip_address;
	String locale					="";

	int size=1;

	HttpSession session;

	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException	{

		session = request.getSession(false);
		this.properties = (java.util.Properties) session.getAttribute("jdbc") ;
		this.facility_id = (String) session.getAttribute("facility_id") ;
		client_ip_address = properties.getProperty("client_ip_address");
		locale=(String)session.getAttribute("LOCALE");
		/*System.out.println("------Values-------");
		System.out.println("locale------> 46"+locale);*/
		try{
			request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8"); 
			this.out = response.getWriter();
			modify(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
    try
	{
		this.out = response.getWriter();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		doPost(request,response);
	}
	catch(Exception e){
		out.println("Exception in doGet() of AccessRightsServlet.java"+e);
	}
	}

	private void modify(HttpServletRequest request, HttpServletResponse response){

		try{

    		added_by_id 	= properties.getProperty( "login_user" ) ;

			HashMap tabData=new HashMap();
            RecordSet	AccessRights	=	null;
			String workplace="";
            String select = "";
            String setup = "";
            String allocate = "";
            String reallocate = "";
            String cancel= "";
			String dbaction="";

            String	from	=	"",	to		=	"";
			locale = locale ;

			facility_id=request.getParameter("facility_id");
			user_id=request.getParameter("user_id");
			workplace=request.getParameter("workplace")==null?"":request.getParameter("workplace");
			workplace_code=request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");

			setup_yn=request.getParameter("setup");
			allocate_yn=request.getParameter("allocate");
			reallocate_yn=request.getParameter("reallocate");
			cancel_yn=request.getParameter("cancel");
			select_yn=request.getParameter("select1");
			dbaction=request.getParameter("dbaction");
			HashMap map=new HashMap();

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSAccessRights", eRS.RSAccessRights.RSAccessRightsLocalHome.class, local_ejbs);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[1];
			aobj[0] = tabData;
			Class aclass[] = new Class[1];
			aclass[0] = tabData.getClass();

			if(!workplace_code.equals("")){
				size=1;
				tabData.put("facility_id",facility_id );
				
				tabData.put("appl_user_id",user_id );
				tabData.put("workplace_code",workplace_code );
				tabData.put("setup_requirement_yn",setup_yn );
				tabData.put("allocate_yn",allocate_yn );
				tabData.put("reallocate_yn",reallocate_yn );
				tabData.put("cancel_schedule_yn",cancel_yn );
				tabData.put("select_yn",select_yn );
				tabData.put("dbaction",dbaction );
				tabData.put("total_records", String.valueOf(size));
				tabData.put("added_by_id", added_by_id);
				tabData.put("added_at_ws_no",  client_ip_address);
				tabData.put("added_facility_id",  facility_id);
				tabData.put("locale",locale);
				tabData.put("properties",properties);
				//System.out.println("locale 131-------->"+locale);

			}
			else if(workplace_code.equals("")){
				from		=	(request.getParameter("from")==null)?"0"	:	request.getParameter("from");
				to			=	(request.getParameter("to")==null)?"0"	:	request.getParameter("to");

				AccessRights	=	(webbeans.eCommon.RecordSet)session.getAttribute("AccessRights");

				if(from != null && to != null){				 	
					int from1	=	Integer.parseInt(from.trim());
					int to1	=	Integer.parseInt(to.trim());
					int i=0;
					for(i=from1; i<to1; i++){
						 workplace=request.getParameter("workplace_code"+(i));
						 select = request.getParameter("select"+(i))==null?"N":request.getParameter("select"+(i));
						 setup=request.getParameter("Setup"+(i))==null?"N":request.getParameter("Setup"+(i));
						 allocate=request.getParameter("Allocate"+(i))==null?"N":request.getParameter("Allocate"+(i));
						 reallocate=request.getParameter("Reallocate"+(i))==null?"N":request.getParameter("Reallocate"+(i));
						 cancel=request.getParameter("Cancel"+(i))==null?"N":request.getParameter("Cancel"+(i));
						 db_action=request.getParameter("db_action"+(i));

						 ArrayList checkedOnes=new ArrayList();
						   
						 checkedOnes.add(workplace);
						 checkedOnes.add(select);
						 checkedOnes.add(setup);
						 checkedOnes.add(allocate);
						 checkedOnes.add(reallocate);
						 checkedOnes.add(cancel);
						 checkedOnes.add(db_action);
						 
						 AccessRights.setObject(i,checkedOnes);
					}
				}

				size=AccessRights.getSize();

				tabData.put("facility_id",facility_id );
				tabData.put("appl_user_id",user_id );

				for(int i=0;i<size;i++){
					ArrayList al=new ArrayList();
					al=(ArrayList)AccessRights.getObject(i);
					String workplace_code1=(String)al.get(0);
					String select1=(String)al.get(1);
					String setup1=(String)al.get(2);
					String allocate1=(String)al.get(3);
					String reallocate1= (String)al.get(4);
					String cancel1= (String)al.get(5);
					String dbaction1=(String)al.get(6);
					tabData.put(("workplace_code"+(i)),workplace_code1);
					tabData.put(("select"+(i)),select1);
					tabData.put(("setup"+(i)),setup1);
					tabData.put(("allocate"+(i)),allocate1);
					tabData.put(("reallocate"+(i)),reallocate1);
					tabData.put(("cancel"+(i)),cancel1);
					tabData.put(("dbaction"+(i)),dbaction1);
				}
					tabData.put("total_records", String.valueOf(size));
					tabData.put("added_by_id", added_by_id);
					tabData.put("added_at_ws_no",  client_ip_address);
					tabData.put("added_facility_id",  facility_id);
					tabData.put("locale",  locale);
					tabData.put("properties",properties);
			}
			map=(HashMap)obj1.getClass().getMethod("modify", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);
			String result = ((Boolean)map.get("result")).toString();
			//System.out.println("result in servlet 199------>"+result);
			String err_num="";
			String err_value="";

			if(result.equals("true"))
				err_value ="1";
			else
				err_value="0";

			err_num=(String)map.get("message");
			//System.out.println("err_num in servlet 209-------->"+err_num);
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+err_num+"&err_value="+err_value);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}//End of Modify
}
