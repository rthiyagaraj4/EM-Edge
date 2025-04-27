/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;
import javax.rmi.*;
import eCA.PatTaskList.*;

public class PatTaskListAdhocServlet extends HttpServlet
{
	public  void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;		
		out = response.getWriter();
		HttpSession  session = request.getSession(false);		
		String outPut1 = " ";
		String outPut2 = " ";

		out.println(outPut1);
		
		insertRecord(request,session,out);
		
		out.println(outPut2);
	}

	public void insertRecord(HttpServletRequest request,HttpSession session,PrintWriter out)
	{
		java.util.Properties p = null;
		p = (java.util.Properties) session.getValue("jdbc") ;
		String locale = (String) p.getProperty("LOCALE");
		Connection con = null;
		ArrayList arrayRecords= new ArrayList();
		arrayRecords.add(p);
		String facilityId = checkForNull((String)session.getValue("facility_id"));
		arrayRecords.add(facilityId);
		String patientId= checkForNull((String)request.getParameter("patientId"));
		arrayRecords.add(patientId);
		String encounterId= checkForNull((String)request.getParameter("encounterId"));
		arrayRecords.add(encounterId);
		String taskType= checkForNull((String)request.getParameter("taskType"));
		arrayRecords.add(taskType);
		String taskCode= checkForNull((String)request.getParameter("taskCode"));
		arrayRecords.add(taskCode);
		String taskDesc= checkForNull((String)request.getParameter("taskDesc"));
		arrayRecords.add(taskDesc);
		String dateTime= checkForNull((String)request.getParameter("dateTime"));

		dateTime	=	com.ehis.util.DateUtils.convertDate(dateTime,"DMYHM",locale,"en");
		arrayRecords.add(dateTime);
		String practitonerId= checkForNull((String)request.getParameter("practitonerId"));
		arrayRecords.add(practitonerId);
		String remarks= checkForNull((String)request.getParameter("remarks"));
		arrayRecords.add(remarks);
		String priority= checkForNull((String)request.getParameter("priority"));
		arrayRecords.add(priority);
		String sysdate="";
		arrayRecords.add(locale);

		try
		{
			con  = ConnectionManager.getConnection(request);
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PatTaskList",PatTaskListHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[1];
		argArray[0] = arrayRecords;

		Class [] paramArray = new Class[1];
		paramArray[0] = arrayRecords.getClass();

		java.util.ArrayList results = (java.util.ArrayList )(busObj.getClass().getMethod("insertTaskList",paramArray)).invoke(busObj,argArray);
		sysdate = checkForNull((String)results.get(0));
		boolean inserted = results.get(1) == null ? false : ((Boolean)results.get(1)).booleanValue() ;

			if(inserted== true)
			{
				int index=0;				
				Hashtable tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
				String errorMsg = "";
				StringBuffer replaceString = null;
				errorMsg= (String) tabdata.get("message");
				replaceString = new StringBuffer(errorMsg);

				if((index=replaceString.toString().indexOf("<br>"))!=-1)
					replaceString=replaceString.replace(index,index+"<br>".length()," ");
			
				out.println("<script>alert('"+replaceString.toString()+"')</script>");
				out.println("<script>window.returnValue='"+sysdate+"'</script>");
				out.println("<script>window.close()</script>");
			}
		}
		catch(Exception ee)
		{
			//out.println("Exception raise by PatTaskListAdhocServlet ...So Record Not Inserted  : "+ee.toString());//common-icn-0181
			
			ee.printStackTrace();
		}
		finally
		{
				if(con != null)
					ConnectionManager.returnConnection(con);
		}

	}
	private String checkForNull(String IntermediateString)	
	{
		if(IntermediateString == null ||IntermediateString.equals(""))
		IntermediateString="";

		return IntermediateString;
	}
}
