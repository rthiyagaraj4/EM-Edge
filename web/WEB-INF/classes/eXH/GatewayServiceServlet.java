/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.rmi.Naming;

import webbeans.eCommon.ConnectionManager;

/**
 * Starts gateway remotely from applicatio server
 */
public class GatewayServiceServlet extends HttpServlet
{ 
	/**
	 * Do post method which implements the functionalities for starting gateway service
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
	{					   	    
		String statusMsg = startGatewayProcess(request);
//	HttpSession session = request.getSession(false);
//			Properties p = (Properties) session.getValue("jdbc");
//			String locale = XHDBAdapter.checkNull(p.getProperty("LOCALE"));
//			String gatewayServerID = request.getParameter("gatewayServerID");
//		String status = XHUtil.getLocaleMessage(locale, "XH0108", "XH");
//		status = status.replace("$", gatewayServerID);
//		String statusMsg = "APP-XH0108 Gateway Started Successfully at INDBGL-W00340...";
//		statusMsg = status;
//statusMsg = "APP-XH0108 Gateway Started Successfully at INDBGL-W00340...";
		System.out.println("statusMsg "+statusMsg);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();	
		out.print(statusMsg.toString());
		out.flush();			
		out.close();
	}

	public String startGatewayProcess(HttpServletRequest request)
	{
		String status = "Gateway Started Successfully";
		String url = null;
		String locale = null;
		String [] params = new String[6];
		try
		{
			HttpSession session = request.getSession(false);
			Properties p = (Properties) session.getAttribute("jdbc");
			locale = XHDBAdapter.checkNull(p.getProperty("LOCALE"));

			String applicationID = request.getParameter("applicationID");
			String gatewayServerID = request.getParameter("gatewayServerID");
			String protocolLinkID = request.getParameter("protocolLinkID");
			String commType = request.getParameter("commType");
			String facilityID = request.getParameter("facilityID");
			String userID = p.getProperty("login_user");
			String userPassword = p.getProperty("login_password");

			System.out.println("applicationID "+applicationID);
			System.out.println("gatewayServerID "+gatewayServerID);
			System.out.println("protocolLinkID "+protocolLinkID);
			System.out.println("commType "+commType);
			System.out.println("userID "+userID);
			System.out.println("userPassword "+userPassword);
			System.out.println("facilityID "+facilityID);

			params = getGatewayParams(applicationID, gatewayServerID, protocolLinkID, commType, facilityID, userID); 

			HashMap startupParam = new HashMap();
			startupParam.put("applnId", applicationID);
			startupParam.put("facilityId", "XX");
			startupParam.put("client_id", gatewayServerID);
			startupParam.put("commtype", commType);
			startupParam.put("out_dir", params[2]);
			startupParam.put("procId", Integer.parseInt(params[1]));
			startupParam.put("db_string", params[3]);
			startupParam.put("user_id", userID);
			startupParam.put("pass_word", userPassword);
			startupParam.put("retryinterval", "9999");
			startupParam.put("servicemode", "Without Service");
			startupParam.put("protocolLinkID", protocolLinkID);
			startupParam.put("serviceName", "");

			url = "//"+gatewayServerID+":"+params[4]+"/InterfaceEngineRemoteObj";
			em.xh.remoteserver.CentralizedRemote remoteObject = (em.xh.remoteserver.CentralizedRemote)Naming.lookup(url);
			status = remoteObject.startHl7Gateway(startupParam);
			if(XHUtil.isSubstringExists(status, "Gateway Started Successfully"))
			{
				status = XHUtil.getLocaleMessage(locale, "XH0108", "XH");
				status = status.replace("$", params[5]);
			}
			else
			{
				System.out.println("(GatewayServiceBean:startGatewayProcess) RemoteService URL : "+url);
			}
			startupParam.clear();
		}
		catch (Exception exp)
		{
			System.out.println("(GatewayServiceBean:startGatewayProcess) RemoteService URL : "+url);
			System.out.println("(GatewayServiceBean:startGatewayProcess) Exception : "+exp);
			exp.printStackTrace(System.err);
			if(exp instanceof java.rmi.ConnectException)
			{
				status = XHUtil.getLocaleMessage(locale, "XH0110", "XH");
				status = status.replace("$", params[5]);
			}
			else
			{
				status = XHUtil.getLocaleMessage(locale, "XH1000", "XH");
			}
		}
		return status;
	}

	public String[] getGatewayParams(String appID, String gatewayServerID, String protocolLinkID, String commType, String facilityID, String userName) throws Exception
	{				
		CallableStatement ostmt = null;
		Connection dbConn = null;
		String [] params = new String [6];

		try
		{
			dbConn = ConnectionManager.getConnection();
			ostmt = dbConn.prepareCall("{ call get_gateway_startup_params(?,?,?,?,?,?,?,?,?,?,?,?,?) }" );
			ostmt.setString(1,appID);
			ostmt.setString(2,protocolLinkID);
			ostmt.setString(3,gatewayServerID);
			ostmt.setString(4,facilityID);
			ostmt.setString(5,commType);
			ostmt.setString(6,userName);
			ostmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(8,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(9,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(12,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(13,java.sql.Types.VARCHAR);
			ostmt.execute();
			params[0] = ostmt.getString(7);
			params[1] = ostmt.getString(8);
			params[2] = ostmt.getString(9);
			params[3] = ostmt.getString(10);
			params[4] = ostmt.getString(11);
			params[5] = ostmt.getString(13);
			String error = ostmt.getString(12);
			System.out.println("params[0] "+params[0]);
			System.out.println("params[1] "+params[1]);
			System.out.println("params[2] "+params[2]);
			System.out.println("params[3] "+params[3]);
			System.out.println("params[4] "+params[4]);			
			System.out.println("params[5] "+params[5]);			
			System.out.println("(GatewayServiceServlet:getGatewayParams) error "+error);
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(null, ostmt, dbConn);
		}
		return params;	
	}
}
