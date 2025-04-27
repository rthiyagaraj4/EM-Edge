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
import eRS.LocnForWorkplace.*;

public class LocnForWorkplaceServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel{

	PrintWriter out;
	java.util.Properties p;

	String workplace_code;
	String facility_id;
	String location_type;
	String facilityId1 ;
	String client_ip_address ;
	String locale					="";


	HttpSession session;

	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{			
		
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.facilityId1 = (String) session.getAttribute( "facility_id" ) ;
		
		client_ip_address = p.getProperty("client_ip_address");
		locale=(String)session.getAttribute("LOCALE");

		try{
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8"); 
			this.out = res.getWriter();
			LocationAddModify(req,res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		try{
			
			this.out = res.getWriter();
			res.setContentType("text/html");
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
	}

	private void LocationAddModify(HttpServletRequest req, HttpServletResponse res){
		try{
			
	        HashMap tabdata=new HashMap();
            RecordSet	 LocationWorkplace	=	null;
            String checkedOnes = "";
            String	from	=	"",	to		=	"";
			workplace_code = req.getParameter("workplace_code");
			facility_id = req.getParameter("facility_id");
			location_type = req.getParameter("locn_code");
			
			if(workplace_code== null) workplace_code="";
			if(facility_id== null) facility_id="";
			if(location_type== null) location_type="";
			
			tabdata.put("workplace_code",workplace_code );
			tabdata.put("facility_id",facility_id );
			tabdata.put("locale",locale );
			tabdata.put("location_type",location_type );

            from		=	(req.getParameter("from")==null)	?	"0"	:	req.getParameter("from");
            to			=	(req.getParameter("to")==null)		?	"0"	:	req.getParameter("to");

            LocationWorkplace	=	(webbeans.eCommon.RecordSet)	session.getAttribute("LocationWorkplace");
	             			
			if(from != null && to != null){
				from	=	from.trim();
				to		=	to.trim();
				for( int i=(Integer.parseInt(from)); i<=(Integer.parseInt(to)); i++)	{
					if(req.getParameter(("chk"+i)) != null)	{
						checkedOnes = req.getParameter(("chk"+i));
					
						if(!(LocationWorkplace.containsObject(checkedOnes)))
							LocationWorkplace.putObject(checkedOnes);
					}
				}
			}
							
			for(int i=0;i<LocationWorkplace.getSize();i++){
				tabdata.put( ("chk"+i), (String)LocationWorkplace.getObject(i) );
			}
			String slCount	=	""+LocationWorkplace.getSize();
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String modifiedFacilityId = facilityId1 ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("totCount", new Integer(slCount) );

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;

			//Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ejb/eRS/LocnForWorkplace", eRS.LocnForWorkplace.LocnForWorkplaceLocalHome.class, local_ejbs);
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/LocnForWorkplace", eRS.LocnForWorkplace.LocnForWorkplaceLocalHome.class, local_ejbs);

			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[2];
			aobj[0] = p;
			aobj[1] = tabdata;
			Class aclass[] = new Class[2];
			aclass[0] = p.getClass();
			aclass[1] = tabdata.getClass();
			HashMap results=(HashMap)obj1.getClass().getMethod("LocationAddModify", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String err_num = (String) results.get("error") ;
			System.err.println("err_num---------->"+err_num);
			String error_value = "0" ;

			if ( inserted ) error_value = "1" ;
			//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+err_num+"&err_value="+error_value);


		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;

			}
	}//E.O.Method
}
