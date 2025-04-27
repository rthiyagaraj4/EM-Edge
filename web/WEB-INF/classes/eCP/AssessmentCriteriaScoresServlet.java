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
//import javax.naming.*;
//import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;
import eCP.AssessmentCriteriaScores.*;

public class AssessmentCriteriaScoresServlet extends HttpServlet
{
	Connection con = null;
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	private ServletConfig config=null;
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";
	String client_ip_address = "";
	String mode = "";
	String maxRecord = "";
	String Listcnt = "";
	String assess_note = "";
	String assess_catg = "";
	String comp_id = "";
	String srl_no = "";
	String sec_hdg_code = "";
	String child_sec_hdg_code = "";
	String comp_type = "";
	String scorelistyes = "";
	String scorelistno = "";
	String list_item_id = "";
	String txtnl = "";
	String txtnh = "";
	String scorelistnor = "";
	String txtal = "";
	String txtah = "";
	String scorelistabnor ="";
	String txtcl = "";
	String txtch = "";
	String scorelistcrit = "";
	String scorelist = "";
	String error_value = "";
	String locale="";

	public void init(ServletConfig config)throws ServletException
	{
		super.init(config);
		this.config = config;
	}
	//end of init()
	public  void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		this.out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		this.prop = (java.util.Properties)session.getAttribute("jdbc");
		this.added_facility_id = (String)session.getAttribute("facility_id");
		client_ip_address = this.prop.getProperty("client_ip_address");
		modified_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		modified_facility_id = (this.added_facility_id==null)?"":this.added_facility_id;
		modified_at_ws_no = (client_ip_address==null)?"":client_ip_address;
		try
		{
			 mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
			 if(mode.equals("")) insert(request,response);
		}
		catch(Exception e)
		{
			out.println("Exception in try of doPost()"+e);
		}
	}
	//end of doPost()
	public  void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = response.getWriter();
			response.setContentType("text/html");
			doPost(request,response);
		}
		catch(Exception e)
		{
			out.println("Exception in doGet()"+e);
		}
	}//end of doGet()
//***********Start of Insert************************
	private void insert(HttpServletRequest request,HttpServletResponse response)
	{
		HashMap Ases_crit_scor = null;
		ArrayList assess_main = new ArrayList();
		ArrayList assess_sub = new ArrayList();
		String locale=(String)session.getAttribute("LOCALE");
	try
		{
			int cnt = 1;
			added_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
			added_facility_id = (this.added_facility_id == null)?"":this.added_facility_id; 
			added_at_ws_no = (client_ip_address == null)?"":client_ip_address; 
			assess_note = request.getParameter("assess_note")==null?"":request.getParameter("assess_note");
			assess_catg = request.getParameter("assess_catg")==null?"":request.getParameter("assess_catg");
			maxRecord = request.getParameter("maxRecord")==null?"":request.getParameter("maxRecord");
			int j = Integer.parseInt(maxRecord);
			int inc = 1;
			for(int i=1;i<=j;i++)
			{
				Ases_crit_scor = new HashMap();
				comp_id = request.getParameter("comp_id"+i)==null?"":request.getParameter("comp_id"+i);
				srl_no = request.getParameter("srl_no"+i)==null?"0":request.getParameter("srl_no"+i);
				sec_hdg_code = request.getParameter("sec_hdg_code"+i)==null?"":request.getParameter("sec_hdg_code"+i);
				child_sec_hdg_code = request.getParameter("child_sec_hdg_code"+i)==null?"":request.getParameter("child_sec_hdg_code"+i);
				comp_type = request.getParameter("comp_type"+i)==null?"":request.getParameter("comp_type"+i);
				// If Checkbox
				scorelistyes = request.getParameter("scorelistyes"+i)==null?"0":request.getParameter("scorelistyes"+i);
				scorelistno = request.getParameter("scorelistno"+i)==null?"0":request.getParameter("scorelistno"+i);
				// End of Checkbox
				// If Number
				txtnl = request.getParameter("txtnl"+i)==null?"0":request.getParameter("txtnl"+i);
				txtnh = request.getParameter("txtnh"+i)==null?"0":request.getParameter("txtnh"+i);
				scorelistnor = request.getParameter("scorelistnor"+i)==null?"0":request.getParameter("scorelistnor"+i);
				txtal = request.getParameter("txtal"+i)==null?"0":request.getParameter("txtal"+i);
				txtah = request.getParameter("txtah"+i)==null?"0":request.getParameter("txtah"+i);
				scorelistabnor = request.getParameter("scorelistabnor"+i)==null?"0":request.getParameter("scorelistabnor"+i);
				txtcl = request.getParameter("txtcl"+i)==null?"0":request.getParameter("txtcl"+i);
				txtch = request.getParameter("txtch"+i)==null?"0":request.getParameter("txtch"+i);
				scorelistcrit = request.getParameter("scorelistcrit"+i)==null?"0":request.getParameter("scorelistcrit"+i);
				// End of Number
				// If Listbox
				if(comp_type.equals("L"))
				{
					Listcnt = request.getParameter("Listcnt"+cnt)==null?"":request.getParameter("Listcnt"+cnt);
					if(!Listcnt.equals(""))
					{
						int Listcnts = 0;
						Listcnts = Integer.parseInt(Listcnt);
						assess_sub = new ArrayList();
						for(int k=1;k<=Listcnts;k++)
						{
							list_item_id = request.getParameter("list_item_id"+inc)==null?"":request.getParameter("list_item_id"+inc);
							scorelist = request.getParameter("scorelist"+inc)==null?"0":request.getParameter("scorelist"+inc);
							assess_sub.add(list_item_id);
							assess_sub.add(scorelist);
							inc++;
						}
						cnt++;
					}
				}
				// End of Listbox
				// Putting Values into Hastable
				Ases_crit_scor.put("ASSESS_NOTE_ID",assess_note);
				Ases_crit_scor.put("ASSESS_CATG_CODE",assess_catg);
				Ases_crit_scor.put("SEC_HDG_CODE",sec_hdg_code);
				Ases_crit_scor.put("CHILD_SEC_HDG_CODE",child_sec_hdg_code);
				Ases_crit_scor.put("COMP_ID",comp_id);
				Ases_crit_scor.put("COMP_SRL_NO",srl_no);
				Ases_crit_scor.put("COMP_TYPE",comp_type);
				Ases_crit_scor.put("MAXRECORD",maxRecord);
				Ases_crit_scor.put("LISTCNT",Listcnt);
				// If Checkbox
				Ases_crit_scor.put("SCORELISTYES",scorelistyes);
				Ases_crit_scor.put("SCORELISTNO",scorelistno);
				// End of  Checkbox
				// If Number
				Ases_crit_scor.put("NORMAL_RNG_LOW",txtnl);
				Ases_crit_scor.put("NORMAL_RNG_HIGH",txtnh);
				Ases_crit_scor.put("NORMAL_SCORE",scorelistnor);
				Ases_crit_scor.put("ABNORMAL_RNG_LOW",txtal);
				Ases_crit_scor.put("ABNORMAL_RNG_HIGH",txtah);
				Ases_crit_scor.put("ABNORMAL_SCORE",scorelistabnor);
				Ases_crit_scor.put("CRITICAL_RNG_LOW",txtcl);
				Ases_crit_scor.put("CRITICAL_RNG_HIGH",txtch);
				Ases_crit_scor.put("CRITICAL_SCORE",scorelistcrit);
				// End of Number
				Ases_crit_scor.put("ADDED_BY_ID",added_by_id);
				Ases_crit_scor.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
				Ases_crit_scor.put("ADDED_AT_WS_NO",added_at_ws_no);
				Ases_crit_scor.put("ADDED_FACILITY_ID",added_facility_id);
				Ases_crit_scor.put("MODIFIED_BY_ID",modified_by_id);
				Ases_crit_scor.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
				Ases_crit_scor.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
				Ases_crit_scor.put("MODIFIED_FACILITY_ID",modified_facility_id);
				Ases_crit_scor.put("RESP",assess_sub);
				Ases_crit_scor.put("locale",locale);
				// End of HashMap
				assess_main.add(Ases_crit_scor);
			}
			try
			{
			    con = ConnectionManager.getConnection(request);
			    /*Context context = new InitialContext();
				Object homeobj = context.lookup("java:comp/env/AssessmentCriteriaScores");
				AssessmentCriteriaScoresHome AssessmentCriteriaScoreshome = (AssessmentCriteriaScoresHome) PortableRemoteObject.narrow(homeobj,AssessmentCriteriaScoresHome.class);
				final AssessmentCriteriaScoresRemote AssessmentCriteriaScoresRemote = AssessmentCriteriaScoreshome.create();
				final java.util.HashMap results = AssessmentCriteriaScoresRemote.AddModify(prop,assess_main);*/

				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AssessmentCriteriaScores", eCP.AssessmentCriteriaScores.AssessmentCriteriaScoresHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[2];
				aobj[0] = prop;
				aobj[1] = assess_main;
				Class aclass[] = new Class[2];
				aclass[0] = prop.getClass();
				aclass[1] = assess_main.getClass();
				HashMap results = (HashMap)obj1.getClass().getMethod("AddModify", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);
				locale=(String)session.getAttribute("LOCALE");
				boolean inserted = (((Boolean)results.get("status")).booleanValue());
				String error = (String) results.get("error");
				Hashtable final_result = MessageManager.getMessage(locale,"RECORD_INSERTED" ,"CP");
				String msgid= (String) final_result.get("message");
				if (inserted)
				{
					error_value= "1";
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +msgid);
				}
				else
				{
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
				}
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
				String error = "Error ";
				String error_value = "0" ;
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
			}
			finally
			{
				ConnectionManager.returnConnection(con,request);
			}
		}
		catch(Exception e)
		{
			out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
		}//end of catch
	}//end of insert
}
