/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 18/10/2005.


package eCP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
//import javax.naming.*;
//import javax.rmi.*;

import webbeans.eCommon.*;


import eCP.PractTypeForAssessmentNote.*;

public class PractTypeForAssessmentNoteServlet extends javax.servlet.http.HttpServlet {
	PrintWriter out;
	java.util.Properties properties;

	String assess_note_id;
	String facility_id ;
	String added_by_id = "";
		
	String client_ip_address ;
	

	HttpSession session;
	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException	{

		session = req.getSession(false);
		this.properties = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.facility_id = (String) session.getAttribute( "facility_id" ) ;
		client_ip_address = properties.getProperty("client_ip_address");


		try{
			res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
			this.out = res.getWriter();
			modify(req,res);
		}
		catch(Exception e)	{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletResponse res) throws javax.servlet.ServletException,IOException{

		try{
			this.out = res.getWriter();
			res.setContentType("text/html");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='/eCIS/ip/js/NursUnitRoom.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Rooms For Nursing Unit' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	
		{	
			out.println(e.toString());
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res){

		try{
			added_by_id 	= properties.getProperty( "login_user" ) ;
			added_by_id 	= properties.getProperty( "login_user" ) ;


            
			HashMap tabData=new HashMap();
            RecordSet	PractTypeForAssessmentNote	=	null;
			String locale=(String)session.getAttribute("LOCALE");
            String checkedOnes = "";
            String	from	=	"",	to		=	"";
			assess_note_id = req.getParameter("assess_note_id");
			if(assess_note_id == null) assess_note_id="";
			tabData.put("assess_note_id",assess_note_id );

			from		=	(req.getParameter("from")==null)	?	"0"	:	req.getParameter("from");
			to			=	(req.getParameter("to")==null)		?	"0"	:	req.getParameter("to");
			PractTypeForAssessmentNote	=	(webbeans.eCommon.RecordSet)	session.getAttribute("PractTypeForAssessmentNote");

			if(from != null && to != null){				 	
				from	=	from.trim();
				to	=	to.trim();

				for( int i=(Integer.parseInt(from)); i<=(Integer.parseInt(to)); i++){
					if(req.getParameter(("select"+i)) != null){
						checkedOnes = req.getParameter(("select"+i));
						if(!(PractTypeForAssessmentNote.containsObject(checkedOnes)))
							PractTypeForAssessmentNote.putObject(checkedOnes);
					}
 				}
 			}
			int size=PractTypeForAssessmentNote.getSize();
			for(int i=0;i<size;i++){
				tabData.put( ("select"+i), (String)PractTypeForAssessmentNote.getObject(i) );
			}

			tabData.put("total_records", String.valueOf(size));
			tabData.put("added_by_id", added_by_id);
			tabData.put("added_at_ws_no",  client_ip_address);
			tabData.put("added_facility_id",  facility_id);
			tabData.put("locale",  locale);
			tabData.put("properties",properties);

			/*PractTypeForAssessmentNoteHome home = null;
			PractTypeForAssessmentNoteRemote remote = null;
			InitialContext context = new InitialContext() ;

			Object object = context.lookup("java:comp/env/PractTypeForAssessmentNote");
			home =  (PractTypeForAssessmentNoteHome) PortableRemoteObject.narrow(object ,PractTypeForAssessmentNoteHome.class);
			remote = home.create() ;
			HashMap map = remote.modify(tabData) ;*/

			boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PractTypeForAssessmentNote", eCP.PractTypeForAssessmentNote.PractTypeForAssessmentNoteHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[1];
				aobj[0] = tabData;
				Class aclass[] = new Class[1];
				aclass[0] = tabData.getClass();
				HashMap map = (HashMap)obj1.getClass().getMethod("modify", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			String result = ((Boolean)map.get("result")).toString();
			String err_num="";
			String err_value="";

			if(result.equals("true"))
				err_value ="1";
			else
				err_value="0";

			err_num=(String)map.get("message");
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(err_num,"UTF-8")+"&err_value="+err_value);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			session.removeAttribute("PractTypeForAssessmentNote");
		}

	}//End of Modify
}
