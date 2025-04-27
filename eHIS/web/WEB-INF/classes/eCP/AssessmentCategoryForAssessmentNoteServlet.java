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
import javax.naming.*;
import javax.rmi.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCP.AssessmentCategoryForAssessmentNote.*;

public class AssessmentCategoryForAssessmentNoteServlet extends javax.servlet.http.HttpServlet 
	{
	PrintWriter out;
	java.util.Properties p;
	
	String assess_note_id="";
    ArrayList resultArray=new ArrayList();
    	
	String facility_id="" ;
	String client_ip_address="" ;
	String chk_select="";
	String chk_action="";
	String assess_catg_code="";
    String added_by_id = "";
    
	HttpSession session;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
    public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{			
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.facility_id = (String) session.getAttribute( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");

		try
		{
			res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
			this.out = res.getWriter();
			AddModify(req,res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}
	
public void doGet(HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
		}
		catch(Exception e)	
		{	
			out.println(e.toString());
		}
	}

	private void AddModify(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			HashMap tabData=new HashMap();
            RecordSet	 CatgForAssessment 	=	null;
			added_by_id 	= p.getProperty( "login_user" ) ;
            String	from	=	"",	to		=	"";
			String locale=(String)session.getAttribute("LOCALE");
			assess_note_id = req.getParameter("assess_note_id");
			if(assess_note_id == null) assess_note_id="";

			tabData.put("assess_note_id",assess_note_id );

			 from		=	(req.getParameter("from")==null)	?	"0"	:	req.getParameter("from");
             to			=	(req.getParameter("to")==null)		?	"0"	:	req.getParameter("to");

              CatgForAssessment	=	(webbeans.eCommon.RecordSet)	session.getAttribute("CatgForAssessment");
			  	
		if(from != null && to != null)
				 			{
				 					from	=	from.trim();
				 					to		=	to.trim();
				 					for( int i=(Integer.parseInt(from)); i<(Integer.parseInt(to)); i++)
				 					{
				 							assess_catg_code=req.getParameter("assess_catg_code"+(i)); 
											chk_action = req.getParameter("action"+(i));
				 							if((req.getParameter("select"+(i)))!=null)
												chk_select="Y";
                            				else 
					                            chk_select="N";

		
                     resultArray=new ArrayList();
					 resultArray.add(assess_catg_code);
					 resultArray.add(chk_action);
					 resultArray.add(chk_select);
			 		 CatgForAssessment.setObject(i,resultArray);	
				 					}
				 			}
						
				int l=CatgForAssessment.getSize();

			for(int k=0;k<l;k++)
			{
			 	resultArray=(ArrayList)CatgForAssessment.getObject(k);
				tabData.put(("assess_catg_code"+k), (String)resultArray.get(0));
				tabData.put(("db_action"+k),(String)resultArray.get(1));
				tabData.put(("select"+k),(String)resultArray.get(2));
			}
		 	int size=CatgForAssessment.getSize();
			tabData.put("total_records", String.valueOf(size));
			tabData.put("added_by_id", added_by_id);
			tabData.put("added_at_ws_no",  client_ip_address);
			tabData.put("added_facility_id",  facility_id);
			tabData.put("locale",  locale);
			tabData.put("properties",p);

		/*InitialContext context = new InitialContext();
		Object homeObject = context.lookup("java:comp/env/AssessmentCategoryForAssessmentNote");
		AssessmentCategoryForAssessmentNoteHome home = (AssessmentCategoryForAssessmentNoteHome) PortableRemoteObject.narrow(homeObject ,AssessmentCategoryForAssessmentNoteHome.class);
		AssessmentCategoryForAssessmentNoteRemote remote = home.create();
		java.util.HashMap results = remote.SpecialityAddModify(tabData) ;*/

				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AssessmentCategoryForAssessmentNote", eCP.AssessmentCategoryForAssessmentNote.AssessmentCategoryForAssessmentNoteHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[1];
				aobj[0] = tabData;
				Class aclass[] = new Class[1];
				aclass[0] = tabData.getClass();
				HashMap results = (HashMap)obj1.getClass().getMethod("SpecialityAddModify", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);

		String result = ((Boolean)results.get("result")).toString();
    	String err_num="";
	 	String err_value="";

	    if(result.equals("true"))
				err_value ="1";
		else
				err_value="0";
		err_num=(String)results.get("message");
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(err_num,"UTF-8")+"&err_value="+err_value);
		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;

		}finally{
			session.removeAttribute("CatgForAssessment");
		}
	}//E.O.Method
} 
