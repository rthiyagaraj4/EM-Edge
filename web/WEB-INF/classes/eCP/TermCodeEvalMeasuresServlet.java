/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import eCommon.Common.*;
import  eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
public class TermCodeEvalMeasuresServlet extends HttpServlet implements SingleThreadModel
{
	//private ServletConfig config = null;
	PrintWriter out = null;
	HttpSession session = null;

	String error_value ="";
	String err_num="";

	String facility_id = "";
	Properties p = new Properties();
	String client_ip_address = "";
	boolean inserted= false;
	String added_by_id = "";
	String added_at_ws_no = "";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;	
	String locale;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		this.out = res.getWriter();
		try	
		{
			session = req.getSession(false);
			this.facility_id = (String) session.getAttribute( "facility_id" ) ;
			this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
			this.client_ip_address = p.getProperty("client_ip_address");
			
			//System.err.println("************in the servlet************");
			insertOperation(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void insertOperation(HttpServletRequest req,HttpServletResponse res)throws Exception
	{


		//String addeddate = dateFormat.format( new java.util.Date() ) ;
		facility_id = (String) session.getAttribute( "facility_id" ) ;
		added_by_id 	= p.getProperty( "login_user" ) ;
		added_at_ws_no	= client_ip_address;


		String id="";
		String desc="";
		String score="";
		String seqno="";
		String flag="";
		String termSet=req.getParameter("termSet");
		String termCode=req.getParameter("termCode");
//		System.err.println("in Servlet termSet "+termSet+" termCode "+termCode);


		String sql_insert = "INSERT INTO CP_TERM_CODE_MSR(TERM_SET_ID, TERM_CODE, TERM_CODE_MSR_ID, TERM_CODE_MSR_DESC, CUT_OFF_SCORE, DISP_SEQ_NO, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		String sql_update = "UPDATE CP_TERM_CODE_MSR SET TERM_CODE_MSR_DESC=?, CUT_OFF_SCORE=?, DISP_SEQ_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE TERM_SET_ID=? AND TERM_CODE=? AND TERM_CODE_MSR_ID=?";
		String sql_delete="DELETE FROM  CP_TERM_CODE_MSR WHERE TERM_SET_ID=? AND TERM_CODE=? AND TERM_CODE_MSR_ID=?";

		HashMap map=new HashMap();
		ArrayList Tablist=new ArrayList();
		HashMap tabData = new HashMap();
		HashMap sqlMap = new HashMap();
		ArrayList insertData = new ArrayList() ;

		try
		{
			RecordSet	CPTermCodeEvalMeasures	=	null;
			CPTermCodeEvalMeasures	=	(webbeans.eCommon.RecordSet)session.getValue("TermCodeEvalMeasure");
			Tablist=(ArrayList)CPTermCodeEvalMeasures.getObject(0);
//			System.err.println("Tablist in servlet "+Tablist);
			for(int i=0;i<Tablist.size();i=i+5)
			{
				id=(String)Tablist.get(i);
				desc=(String)Tablist.get(i+1);
				score=(String)Tablist.get(i+2);
				seqno=(String)Tablist.get(i+3);
				flag=(String)Tablist.get(i+4);

				tabData.clear();
				insertData.clear();

				if(flag.equals("I"))
				{
					insertData.add(termSet);
					insertData.add(termCode);
					insertData.add(id);
					insertData.add(desc);
					insertData.add(score);
					insertData.add(seqno);
					insertData.add(added_by_id);
					insertData.add(added_at_ws_no);
					insertData.add(facility_id);
					insertData.add(added_by_id);
					insertData.add(added_at_ws_no);
					insertData.add(facility_id);
					tabData.put( "InsertData", insertData);
					tabData.put( "properties",	p ) ;

					try{
						sqlMap.clear();
						sqlMap.put( "InsertSQL", sql_insert);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				else if(flag.equals("U"))
				{
					insertData.add(desc);
					insertData.add(score);
					insertData.add(seqno);
					insertData.add(added_by_id);
					insertData.add(added_at_ws_no);
					insertData.add(facility_id);
					insertData.add(termSet);
					insertData.add(termCode);
					insertData.add(id);
					tabData.put( "InsertData", insertData);
					tabData.put( "properties",	p ) ;

					try{
						sqlMap.clear();
						sqlMap.put( "InsertSQL", sql_update);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				else if(flag.equals("D"))
				{
					insertData.add(termSet);
					insertData.add(termCode);
					insertData.add(id);
					tabData.put( "InsertData", insertData);
					tabData.put( "properties",	p ) ;

					try{
						sqlMap.clear();
						sqlMap.put( "InsertSQL", sql_delete);
					}catch(Exception e){
						e.printStackTrace();
					}
				}

//				System.err.println(" record no. "+(i+1)+" tabData "+tabData);


				if(!(tabData.isEmpty()) && !(sqlMap.isEmpty())){
					boolean local_ejbs = false;
					ServletContext context = getServletConfig().getServletContext();
					if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
					local_ejbs = true;
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTableHandler",SingleTableHandlerLocalHome.class,local_ejbs);
					//Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ejb/eCommon/SingleTableHandler",SingleTableHandlerLocalHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					Object argArray[] = new Object[2];
					argArray[0] =tabData;
					argArray[1] =sqlMap;

					Class [] paramArray = new Class[2];
					paramArray[0] =tabData.getClass();
					paramArray[1] =sqlMap.getClass();
					
					map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					locale=(String)session.getAttribute("LOCALE");
					String result = ((Boolean)map.get("result")).toString();
					if(result.equals("true")){
						error_value ="1";
						//err_num= "APP-SM0001 Operation Completed Successfully...";
						Hashtable mestable=MessageManager.getMessage(locale,"RECORD_INSERTED", "CP");
						err_num=(String)mestable.get("message");
					}
					else{
						err_num = "Exception Occured... "+ (String)map.get("msgid");
						error_value="0";
					}
				}

			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+err_num+"&err_value="+error_value);

		}
		catch(Exception e)
		{
			out.println("<h3> Exception raised by TermcodeEvalMeasureServlet ... </h3> Foll: Error Received : "+e.toString());
			System.err.println(e.toString());
			e.printStackTrace();
		}


	} 
}
