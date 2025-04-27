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

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import webbeans.eCommon.*;
import eCP.CriteriaForAssessmentCategory.*;

public class CriteriaForAssessmentCategoryServlet extends javax.servlet.http.HttpServlet {
	
	PrintWriter out;
	java.util.Properties properties;
    String assess_note_id="";
	String assess_catg_code="";
	String facility_id = "";
	String added_by_id = "";
	String client_ip_address ;
    ArrayList resultArray=new ArrayList();
		
	String chk_sec_hdg_code="";
	String chk_child_sec_hdg_code="";
	String chk_comp_id="";
	String chk_srl_no="";
	String chk_comp_type="";
	String chk_select="";
	String chk_action="";
    String ch_sc_hdg="";
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
			AddModify(req,res);
		}
		catch(Exception e)	{
			out.println(e.toString());
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
 		try{
			req = req;
			this.out = res.getWriter();
			res.setContentType("text/html");
		
		}
		catch(Exception e)	{			
			out.println(e.toString());
		}
	}

	private void AddModify(HttpServletRequest req, HttpServletResponse res){

		try{
			facility_id=(String)session.getAttribute("facility_id");
			added_by_id 	= properties.getProperty( "login_user" ) ;
            
			HashMap tabData=new HashMap();
        
            RecordSet	CriteriaForAssessmentCategory	=	null;
 
            String	from	=	"",	to		=	"";
			String locale=(String)session.getAttribute("LOCALE");
			assess_note_id = req.getParameter("assess_note_id");
			assess_catg_code = req.getParameter("assess_catg_code");
			tabData.put("assess_note_id",assess_note_id );
			tabData.put("assess_catg_code",assess_catg_code );
		
			from		=	(req.getParameter("from")==null)	?	"0"	:	req.getParameter("from");
			to			=	(req.getParameter("to")==null)		?	"0"	:	req.getParameter("to");
			CriteriaForAssessmentCategory = (webbeans.eCommon.RecordSet) session.getAttribute("CriteriaForAssessmentCategory");		
			if(from != null && to != null){
		    for(int i=Integer.parseInt(from); i<Integer.parseInt(to); i++){

				 chk_sec_hdg_code = req.getParameter("sec_hdg_code"+(i));
				 chk_child_sec_hdg_code = req.getParameter("child_sec_hdg_code"+(i));
				 chk_comp_id = req.getParameter("comp_id"+(i));
				 chk_srl_no = req.getParameter("srl_no"+(i));
				 chk_comp_type = req.getParameter("comp_type"+(i));
				 chk_action = req.getParameter("action"+(i));
				 if((req.getParameter("select"+(i)))!=null)
					 chk_select="Y";
				 else
					 chk_select="N";
				
				     resultArray=new ArrayList();
					 resultArray.add(chk_sec_hdg_code);
					 resultArray.add(chk_child_sec_hdg_code);
					 resultArray.add(chk_comp_id);
					 resultArray.add(chk_srl_no);
					 resultArray.add(chk_comp_type);
					 resultArray.add(chk_action);
					 resultArray.add(chk_select);
					System.err.println("===resultArray===="+resultArray);
			 		 CriteriaForAssessmentCategory.setObject(i,resultArray);		   											 
				 }
			}
			int l=CriteriaForAssessmentCategory.getSize();

			for(int k=0;k<l;k++)
			{
			 	resultArray=(ArrayList)CriteriaForAssessmentCategory.getObject(k);
				ch_sc_hdg=(String)resultArray.get(1);
				if(ch_sc_hdg.equals("null"))
				{
				ch_sc_hdg=(String)resultArray.get(0);
				}
					tabData.put(("sec_hdg_code"+k), (String)resultArray.get(0));
					tabData.put(("child_sec_hdg_code"+k), ch_sc_hdg);
					tabData.put(("comp_id"+k),(String)resultArray.get(2));
					tabData.put(("srl_no"+k),(String)resultArray.get(3));
					tabData.put(("comp_type"+k),(String)resultArray.get(4));
					tabData.put(("db_action"+k),(String)resultArray.get(5));
					tabData.put(("select"+k),(String)resultArray.get(6));
			}

		 	int size=CriteriaForAssessmentCategory.getSize();
			tabData.put("total_records", String.valueOf(size));
			tabData.put("added_by_id", added_by_id);
			tabData.put("added_at_ws_no",  client_ip_address);
			tabData.put("added_facility_id",  facility_id);
			tabData.put("locale",  locale);
			tabData.put("properties",properties);
			//System.err.println("=====tabData====="+tabData);
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/CriteriaForAssessmentCategory", eCP.CriteriaForAssessmentCategory.CriteriaForAssessmentCategoryHome.class, local_ejbs);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[1];
			aobj[0] = tabData;
			Class aclass[] = new Class[1];
			aclass[0] = tabData.getClass();
			HashMap map = (HashMap)obj1.getClass().getMethod("AddModify", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);
			String result = ((Boolean)map.get("result")).toString();
			String err_num="";
			String err_value="";
			if(result.equals("true"))
				err_value ="1";
			else
				err_value="0";
			err_num=(String)map.get("message");
				System.err.println("err_num is..... ===="+err_num);
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(err_num,"UTF-8")+"&err_value="+err_value);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.removeAttribute("CriteriaForAssessmentCategory");
		}		
	}//End of AddModify
}
