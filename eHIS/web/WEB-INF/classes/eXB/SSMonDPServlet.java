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
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXB.XBDBAdapter;
import eXH.XHUtil;
//import eXH.GatewayServiceBean;
import com.ehis.util.DateUtils;

public class SSMonDPServlet extends HttpServlet
{
	HttpServletRequest req = null;
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{
		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");

		req = request;
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		Properties p = (Properties) session.getValue("jdbc");	

		String locale = p.getProperty("LOCALE");
		String facilityID	= (String)session.getValue("facility_id");
		String funcSelected = XBDBAdapter.checkNull(req.getParameter("ssDPFunc"));
		String actionParam  = XBDBAdapter.checkNull(req.getParameter("actionParam"));
		String jobNo = "0";

		if("C".equals(funcSelected))
		{
			jobNo  = XBDBAdapter.checkNull(req.getParameter("confirmJobNo"));
		}
		else 
		{
			jobNo  = XBDBAdapter.checkNull(req.getParameter("processJobNo"));
		}		
		
		HashMap<String,String> result_hm = processReq(funcSelected, locale, facilityID, actionParam, jobNo, req);
		String queryString = "message=" + (String)result_hm.get("status") 
								+ "&statuscode=" + (String)result_hm.get("statusCode")
								+ "&funcselected=" + funcSelected;

		String forwardFile = "ssMonDPReportCriteria.jsp";
		if("OPD".equals(funcSelected)) 
		{
			forwardFile = "opIPOBReportCriteria.jsp";
		}

		if("DE".equals(funcSelected)) 
		{
			out.println("<script language=\"Javascript\">"); 
			out.println("alert('" + (String)result_hm.get("status") + "');window.close();");
			out.println("</script>"); 

		}
		else {		
			out.println("parent.f_query_add_mod.location.href='../../eXB/jsp/" + forwardFile + "'");
			RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXB/jsp/RefreshPage.jsp?action=eXB/jsp/" + forwardFile + "&" + queryString);
			reqDis.forward(request,response);	
		}        	
	}

	public HashMap<String,String> processReq(String funcSelected, String locale, String facilityID, String actionParam, String jobNo, HttpServletRequest request)
	{    
		Connection connection = null;
		CallableStatement ostmt = null;
		Statement stmt = null;
		String message_text2 = "";
		String status = "";
		String exceptions = "";	
		String statusCode = "";
		String storedProc = "{ call xhjob.process_job(?,?,?,?,?,?,?,?,?,?) }";
		String jobWhatStr = "XBSSINT.PROCESSMAIN('" + facilityID + "');";
		HashMap<String,String> result_hm = new HashMap<String,String>();
		MessageManager mm = new MessageManager();
	
		try
		{
			if(connection == null) connection = ConnectionManager.getConnection();
			if("C".equals(funcSelected)) jobWhatStr = "xbssint.process_delete_ss();";
			else if("D".equals(funcSelected)) jobWhatStr = "xbssint.ssupload_data;";
			String custCode = null;
			String opdDate = null;
			
			if("P".equals(funcSelected) || "C".equals(funcSelected) || "D".equals(funcSelected))
			{
				ostmt = connection.prepareCall(storedProc); 
				ostmt.setString(1, actionParam);
				ostmt.setString(2, "0");		 
				ostmt.setString(3, jobNo);
				ostmt.setString(4, "0");
				ostmt.setString(5, jobWhatStr);
				ostmt.setString(6, "0");
				ostmt.setTimestamp(7, new java.sql.Timestamp((new Date()).getTime()));
				ostmt.setString(8, "0.0001"); // for running the job immediately
				ostmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				ostmt.execute();

				statusCode = ostmt.getString(9);	
				message_text2 = ostmt.getString(10);
			}
			else if("OPD".equals(funcSelected))
			{
				storedProc = "{ call xbssint.e11_event_creation(?,?,?,?,?) }";

				custCode = request.getParameter("custCode");
				opdDate = request.getParameter("opdDate");
				if("th".equals(locale)) opdDate = DateUtils.convertDate(opdDate, "MY", "th", "en");
				opdDate = XHUtil.convertDateFormat(opdDate, "MM/yyyy", "yyyyMM");

				ostmt = connection.prepareCall(storedProc); 
				ostmt.setString(1, facilityID);
				ostmt.setString(2, custCode);
				ostmt.setString(3, opdDate);				
				ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
				ostmt.registerOutParameter(5,java.sql.Types.VARCHAR);
				ostmt.execute();

				statusCode = ostmt.getString(4);	
				message_text2 = ostmt.getString(5);

				System.out.println("OPD statusCode "+statusCode);

				if("0".equals(statusCode))
				{
					connection.commit();
/*
					GatewayServiceBean gatewayServiceBean = new GatewayServiceBean();
					System.out.println("appID "+request.getParameter("appID"));
					System.out.println("gatewayServerID "+request.getParameter("gatewayServerID"));
					System.out.println("protocolLinkID "+request.getParameter("protocolLinkID"));
					System.out.println("commType "+request.getParameter("commType"));
					System.out.println("userName "+request.getParameter("userName"));
					status = gatewayServiceBean.startGatewayProcess(
											request.getParameter("appID"), request.getParameter("gatewayServerID"), 
											request.getParameter("protocolLinkID"), request.getParameter("commType"), 
											"XX", request.getParameter("userName"), locale);
					System.out.println("Remote Status: "+status);
*/					
				}
				else connection.rollback();
			}
			else if("DE".equals(funcSelected)) // deleting process errors
			{
				String query = "DELETE xf_ss_int_error_log";

				stmt = connection.createStatement();
				int recCount = stmt.executeUpdate(query);
				if(recCount > 0) statusCode = "0";
				else statusCode = "1";
			}

			if("0".equals(statusCode))
			{
				java.util.Hashtable mesg = null;

				if("P".equals(funcSelected) || "C".equals(funcSelected) || "D".equals(funcSelected) || "OPD".equals(funcSelected))
				{
					mesg = mm.getMessage(locale, "XH0107", "XH");
					status = ((String) mesg.get("message"));
				}
/*				else if(!"OPD".equals(funcSelected))
				{
					mesg = mm.getMessage(locale, "XH1001", "XH");
					status = ((String) mesg.get("message"));
				}				
*/
				mesg.clear();
			}
			else
			{
				System.out.println("(SSMonDPServlet:statusCode) : " + statusCode);
				System.out.println("(SSMonDPServlet:message_text2) : " + message_text2);
				System.out.println("(SSMonDPServlet:Function) : " + funcSelected);

				if("OPD".equals(funcSelected))
				{
					System.out.println("(SSMonDPServlet:Customer code) : " + custCode);
					System.out.println("(SSMonDPServlet:OPD Month/Year) : " + opdDate);					
				}
				
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				status = ((String) mesg.get("message"));		
				
			}
			connection.commit();
		}
		catch(Exception ex)
		{ 
			System.out.println("Error in calling dbrelated statements in processReq method of SSMonDPServlet  :"+ex.toString());
			exceptions = exceptions + "3" + "*" + ex.toString();
			ex.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(null, ostmt, null);
			XHUtil.closeDBResources(null, stmt, connection);
		}				 

		result_hm.put("exceptions",exceptions);
		result_hm.put("status",status);
		result_hm.put("statusCode",statusCode);

		return result_hm;  
	}

}
