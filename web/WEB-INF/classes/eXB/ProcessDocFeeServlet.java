/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Properties;
import java.util.Date;
import java.sql.Connection;
import java.sql.CallableStatement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import eXB.XBDBAdapter;
import eXH.XHUtil;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import com.ehis.util.DateUtils;

public class ProcessDocFeeServlet extends HttpServlet
{
	HttpServletRequest req = null;
	MessageManager mm = new MessageManager();
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		req = request;
		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
		String processDate = "";
		String status = "";
		HashMap<String,String> result_hm = null;		
			
		HttpSession session = request.getSession(false);
		Properties p = (Properties) session.getValue("jdbc");
		String facilityID = (String)session.getValue("facility_id");
		String locale  = p.getProperty("LOCALE");
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
			processDate = XBDBAdapter.checkNull(req.getParameter("processDate"));
			if("th".equals(locale)) processDate = DateUtils.convertDate(processDate, "MY", "th", "en");
			processDate = XHUtil.convertDateFormat(processDate, "MM/yyyy", "yyyyMM");
			Date procDate = XHUtil.convertStrToDate(processDate, "yyyyMM");
			
			result_hm = callEJB(facilityID, procDate, locale, p);
			status = (String)result_hm.get("status");
		}
		catch (Exception exp)
		{
			System.out.println("(ProcessDocFeeServlet:doPost) : "+exp.toString());
			System.out.println("processDate "+processDate);
			System.out.println("facilityID "+facilityID);
			System.out.println("locale "+locale);

			exp.printStackTrace(System.err);
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;			
			status = ((String) mesg.get("message"));
		    mesg.clear();
		}
		String queryString = "message=" + status
							+ "&functionID=XF_DF_HEALTHCAREDELIVERY"
							+ "&queueType=ONLINE";		

        RequestDispatcher reqDis = session.getServletContext().getRequestDispatcher("/eXB/jsp/RefreshPage.jsp?action=eXI/jsp/MonitorItemsPopulateRecords.jsp&"+queryString);
        reqDis.forward(request,response);		
	}

	public HashMap<String,String> callEJB(String facilityID, Date processDate, String locale, Properties p)
	{    
		Connection connection = null;
		CallableStatement ostmt = null;

		String message_text2 = "";
		String status = "";
		String exceptions = "";		
		String storedProc = "{ call XFADFINT.process_doc_fee(?,?,?,?,?) }";

		HashMap<String,String> result_hm = new HashMap<String,String>();
		java.util.Hashtable mesg = null;
		
		try
		{
			if(connection == null) connection = ConnectionManager.getConnection(p);
		}
		catch(Exception exp)
		{
			System.out.println("Error in calling getconnection method of ProcessDocFeeServlet  :"+exp.toString());
			exp.printStackTrace(System.err);
			exceptions = exceptions + "1" + "*" + exp.toString();
		}

		try
		{
			ostmt = connection.prepareCall(storedProc); 
			ostmt.setDate(1, new java.sql.Date(processDate.getTime()));
			ostmt.setString(2, facilityID);			
			ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			ostmt.execute();

			String statusCode = ostmt.getString(4);	
			message_text2 = ostmt.getString(5);

			if("0".equals(statusCode))
			{				
				mesg = mm.getMessage(locale, "XH0089", "XH");
				status += ((String) mesg.get("message"));
				status = status.replace("$", ostmt.getString(3));
			}
			else if("2".equals(statusCode))
			{
				mesg = mm.getMessage(locale, "NO_RECORD_FOUND", "COMMON");
				status = ((String) mesg.get("message"));
			}
			else
			{
				mesg = mm.getMessage(locale, "XH1000", "XH");
				status = ((String) mesg.get("message"));
				System.out.println("(ProcessDocFeeServlet:statusCode) : "+statusCode);
				System.out.println("(ProcessDocFeeServlet:message_text2) : "+message_text2);				
			}	
			
		    mesg.clear();
			connection.commit();
		}
		catch(Exception ex)
		{ 
			System.out.println("Error in calling dbrelated statements in callejb method of ProcessDocFeeServlet  :"+ex.toString());
			exceptions = exceptions + "3" + "*" + ex.toString();
			ex.printStackTrace(System.err);
			status = ex.toString();
		}
		finally
		{
			try
			{
				if(ostmt != null) ostmt.close();
				if(connection != null) ConnectionManager.returnConnection(connection);
			}
			catch(Exception fexp)
			{
				fexp.printStackTrace(System.err);
			}
		}			 

		result_hm.put("exceptions",exceptions);
		result_hm.put("status",status);

		return result_hm;  
	}
}
