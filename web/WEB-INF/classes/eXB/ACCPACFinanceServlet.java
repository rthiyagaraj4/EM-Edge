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
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import eXB.XBDBAdapter;
import eXH.XHUtil;
import webbeans.eCommon.*;
import com.ehis.util.DateUtils;

public class ACCPACFinanceServlet extends HttpServlet
{
	HttpServletRequest req = null;
	MessageManager mm = new MessageManager();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		req = request;
		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
		
		String statusMsg = "";
		HashMap<String,String> statusList = null;		
			
		HttpSession session = request.getSession(false);
		Properties p = (Properties) session.getValue("jdbc");
		String facilityID = (String)session.getValue("facility_id");
		String locale  = p.getProperty("LOCALE");		
		try
		{			
			String reportRunDateStr = XBDBAdapter.checkNull(req.getParameter("P_DOC_DATE"));
			
			statusList = procCSVGen(facilityID, reportRunDateStr, locale, p);
			statusMsg = (String)statusList.get("status");
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.err);
			statusMsg = XHUtil.getMessage("1", locale);
		}
		String queryString = "message=" + statusMsg;		
System.out.println("queryString "+queryString);
        RequestDispatcher reqDis = session.getServletContext().getRequestDispatcher("/eXB/jsp/RefreshPage.jsp?action=eXB/jsp/accPACFinReportCriteria.jsp&"+queryString);
        reqDis.forward(request,response);		
	}

	private synchronized HashMap<String,String> procCSVGen(String facilityID, String repRunDateStr, String locale, Properties prop)
	{
		HashMap<String,String> statusList = new HashMap<String,String>();
		java.util.Hashtable<String,String> mesg = null;
		try
		{
			if("th".equals(locale)) repRunDateStr = DateUtils.convertDate(repRunDateStr, "DMY", "th", "en");			

			String jobWhatStr = "XBSSINT.accpacfin_invdata(to_date('"+ repRunDateStr +"','dd/mm/yyyy'));";
			System.out.println("jobWhatStr "+jobWhatStr);
			java.util.Date jobStartTime = new java.util.Date();
			String jobInterval = "0.0001"; // Runs the job almost immediately

			String [] tempStatus = XHUtil.submitJob(jobWhatStr, jobStartTime, jobInterval);
			statusList.put("exceptions", tempStatus[1]);

			if("0".equals(tempStatus[0]))
			{
				mesg = mm.getMessage(locale, "XH0107", "XH") ;
				String statusMsg = ((String) mesg.get("message"));
				statusList.put("status", statusMsg);
			}
			else
			{
				statusList.put("status", XHUtil.getMessage(tempStatus[0], locale));
			}
			System.out.println("tempStatus "+tempStatus[1]);
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.err);
			statusList.put("exceptions", exp.getMessage());
			statusList.put("status", XHUtil.getMessage("1", locale));
		}
		finally
		{
			mesg.clear();
		}
		return statusList;
	}	
}
