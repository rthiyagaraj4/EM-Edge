/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
   File:	DRGCalculationServlet.java
   Date      Author			Changes
   Nov 18	Ravindranath	Created 
*/
package eXB; 

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import webbeans.eCommon.*;

/**
*	Class used to insert a request for calculating the drg values for in values passed.
*	And send back the response to the user with the calculated dgr results
**/

public class DRGCalculationServlet extends javax.servlet.http.HttpServlet 
{
	String requestBuilderProc = "{call XBDRG.DRGBUILDER(?,?,?,?,?,?,?,?,?,?,?)}";
	String calculateDRGProc = "{call XHINTERACTIVE.INTERACTIVE_INTERFAC_AUDIT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	String requestDateFormat = "dd-MMM-yyyy HH:mm:ss";
	String locale = null;

	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException 
	{
		HttpSession session = null;
		PrintWriter out = null;		

		String eventType = "";						
		String facility_id = "";
		String patient_id = "";
		String encounter_id = "";
		String profile_id = "";	
		String applicationID = "";
		
		HashMap requestDetails = new HashMap();
		HashMap results = null;

		try 
		{
			out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			session = request.getSession(false);

			Properties p;				
			p = (Properties) session.getValue("jdbc");
			locale = p.getProperty("LOCALE");

			String userID = p.getProperty("login_user");
			String sessionID = session.getId();			

			String strClientHostName = p.getProperty("client_ip_address");
			String addedFacility = (String) session.getValue( "facility_id" ) ;
			String moduleID = "XB";
			String msgID = "";
			
			String mode = request.getParameter("req_mode");
			if(mode != null && mode.equalsIgnoreCase("refresh"))
			{
				msgID = request.getParameter("msg_id");
			//	System.out.println("Mode "+mode);
			//	System.out.println("Message ID "+msgID);
				results = getMsgData(msgID);
			}
			else
			{

				facility_id = request.getParameter("facilityID");
				patient_id = request.getParameter("patientID");
				encounter_id = request.getParameter("encounterID");
				profile_id = request.getParameter("profileID");
				eventType = request.getParameter("eventType");
				applicationID = request.getParameter("applicationID");

				if(profile_id == null || profile_id.equals(""))
				{
					profile_id = "SRRDRG1"; // default profile id to be used as of now.
				}
				
				requestDetails.put("applicationID",applicationID);
				requestDetails.put("facility_id",facility_id);
				requestDetails.put("patient_id",patient_id);
				requestDetails.put("encounter_id",encounter_id);
				requestDetails.put("profile_id",profile_id);
				requestDetails.put("eventType",eventType);
				
				requestDetails.put("userid",userID);
				requestDetails.put("clientMachine",strClientHostName);
				requestDetails.put("pgmid","XBDRG");
				requestDetails.put("moduleID",moduleID);
				requestDetails.put("sessionID",sessionID);
				requestDetails.put("facilityID",facility_id);
				requestDetails.put("patientID",patient_id);
				requestDetails.put("mergedPatientID","");
				requestDetails.put("encounterID",encounter_id);
				requestDetails.put("profileID",profile_id);			
				requestDetails.put("addedBy",userID);
				requestDetails.put("modifiedBy",userID);
				requestDetails.put("addedWS",strClientHostName);
				requestDetails.put("addedFacility",addedFacility);
				requestDetails.put("modifiedWS",strClientHostName);
				requestDetails.put("modifiedFacility",addedFacility);

//				System.out.println("(DRGCalculationServlet:doPost)applicationID: "+applicationID);
//				System.out.println("(DRGCalculationServlet:doPost)facility_id: "+facility_id);
//				System.out.println("(DRGCalculationServlet:doPost)patient_id: "+patient_id);
//				System.out.println("(DRGCalculationServlet:doPost)encounter_id: "+encounter_id);
//				System.out.println("(DRGCalculationServlet:doPost)profile_id: "+profile_id);
//				System.out.println("(DRGCalculationServlet:doPost)eventType: "+eventType);						
				
				results = processDRGRequest(requestDetails);
			}
			
			request.setAttribute("results",results);			
			RequestDispatcher reqDis = session.getServletContext().getRequestDispatcher("/eXH/jsp/DRGQueryResults.jsp");
			reqDis.forward(request,response);						
		} 
		catch (Exception e) 
		{
			e.printStackTrace(System.err);
			out.println("Exception in try of doPost() of DRGCalculationServlet.java"+ e.toString());
			System.out.println("Exception in try of doPost() of DRGCalculationServlet.java"+ e.toString());
		}
		finally{
			requestDetails.clear();
			results.clear();
			
		}
	}	

	/**
	*	Method gets the request text by passing the required details and 
	*	inserts a request for calculating the drg values. 
	*	Response values will be populated back to the user once the request is processed.
	*	System will be continuesly checking for the response till it is available.	
	**/
	public HashMap processDRGRequest(HashMap requestDetails)
	{	
		Connection dbConn = null;
		CallableStatement requestStmt = null;
		CallableStatement responseStmt = null;	
		CallableStatement drgCalStmt = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet responseRS = null;
		ResultSet rs = null;
	
		String requestSyntax = "";
		String responseSyntax = "";
		String requestText = "";		
		String responseText = null;
		String strDate = "";
		String procErrorCode = null; // represents proc error code
		String procErrorTxt = null; // represents proc error text
		String errorCode = null; // represents DRG error code
		String errorMsg = null; // represents DRG error message
		String seqNo = "";
		String standardCode = "";
		String profileID = "";
		String resultQuery = "SELECT response_text,profile_id FROM xh_interactive_integration WHERE trx_no=?";

		int sleepParam = 2;

		ArrayList elements = new ArrayList();
		HashMap results = new HashMap();
		
		MessageManager mm = new MessageManager();

		try
		{			
			dbConn = ConnectionManager.getConnection();		

			requestStmt = dbConn.prepareCall(requestBuilderProc);

			requestStmt.setString(1,(String)requestDetails.get("applicationID"));
			requestStmt.setString(2,(String)requestDetails.get("facility_id"));
			requestStmt.setString(3,(String)requestDetails.get("patient_id"));
			requestStmt.setString(4,(String)requestDetails.get("encounter_id"));			
			requestStmt.setString(5,(String)requestDetails.get("eventType"));
			requestStmt.setString(6,(String)requestDetails.get("profile_id"));
			requestStmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			requestStmt.registerOutParameter(8,java.sql.Types.VARCHAR);
			requestStmt.registerOutParameter(9,java.sql.Types.VARCHAR);
			requestStmt.registerOutParameter(10,java.sql.Types.VARCHAR);
			requestStmt.registerOutParameter(11,java.sql.Types.VARCHAR);

			requestStmt.execute();			

			procErrorCode = requestStmt.getString(10);
			procErrorTxt = requestStmt.getString(11);
			
			if(procErrorCode != null && procErrorCode.equalsIgnoreCase("S"))
			{
			requestText = requestStmt.getString(7);	
			requestSyntax = requestStmt.getString(8);	
			responseSyntax = requestStmt.getString(9);

//			System.out.println("(DRGCalculationServlet:processDRGRequest)requestText "+requestText);
//			System.out.println("(DRGCalculationServlet:processDRGRequest)requestSyntax "+requestSyntax);
//			System.out.println("(DRGCalculationServlet:processDRGRequest)responseSyntax "+responseSyntax);
			
			if(requestText != null)
			{
				seqNo = String.valueOf(getSequenceNo());
//				System.out.println("(DRGCalculationServlet:processDRGRequest)TRX "+seqNo);
				responseStmt = dbConn.prepareCall(calculateDRGProc);				

				strDate = getFormattedStringDate(requestDateFormat,null);

				responseStmt.setString(1,"I");
				responseStmt.registerOutParameter(2,java.sql.Types.VARCHAR);
				responseStmt.registerOutParameter(3,java.sql.Types.VARCHAR);
				responseStmt.setString(4,(String)requestDetails.get("userid"));
				responseStmt.setString(5,(String)requestDetails.get("clientMachine"));
				responseStmt.setString(6,(String)requestDetails.get("clientMachine"));
				responseStmt.setString(7,(String)requestDetails.get("pgmid"));
				responseStmt.setString(8,(String)requestDetails.get("moduleID"));
				responseStmt.setString(9,(String)requestDetails.get("sessionID"));
				responseStmt.setString(10,strDate);
				responseStmt.setString(11,requestText);
				responseStmt.setString(12,"TGRP");
				responseStmt.setString(13,seqNo);
				responseStmt.setString(14,(String)requestDetails.get("facility_id"));
				responseStmt.setString(15,strDate);
				responseStmt.setString(16,"D01");
				responseStmt.setString(17,(String)requestDetails.get("patient_id"));
				responseStmt.setString(18,"");
				responseStmt.setString(19,"");
				responseStmt.setString(20,(String)requestDetails.get("encounter_id"));
				responseStmt.setString(21,"");
				responseStmt.setString(22,"0");
				responseStmt.setString(23,requestSyntax);
				responseStmt.setString(24,"");
				responseStmt.setString(25,"");				
				responseStmt.setString(26,(String)requestDetails.get("addedBy"));
				responseStmt.setString(27,strDate);
				responseStmt.setString(28,(String)requestDetails.get("modifiedBy"));
				responseStmt.setString(29,strDate);
				responseStmt.setString(30,(String)requestDetails.get("addedWS"));
				responseStmt.setString(31,(String)requestDetails.get("addedFacility"));
				responseStmt.setString(32,(String)requestDetails.get("modifiedWS"));
				responseStmt.setString(33,(String)requestDetails.get("addedFacility"));
				responseStmt.setString(34,seqNo);
				responseStmt.setString(35,"");
				responseStmt.setString(36,responseSyntax);
				responseStmt.setString(37,(String)requestDetails.get("profile_id"));
				responseStmt.setString(38,"");
				responseStmt.setString(39,"");
				responseStmt.setString(40,"");
				
				responseStmt.execute();

				errorCode = responseStmt.getString(2);
				errorMsg = responseStmt.getString(3);
			//	errorCode = "E";
			//	errorMsg = "Error";

//				System.out.println("(DRGCalculationServlet:processDRGRequest)errorCode: "+errorCode);
//				System.out.println("(DRGCalculationServlet:processDRGRequest)errorMsg: "+errorMsg);
			}

			if(errorCode != null && errorCode.equalsIgnoreCase("S"))
			{
				pstmt = dbConn.prepareCall(resultQuery);
				pstmt.setString(1,seqNo);
			//	pstmt.setString(1,String.valueOf(4110));

				sleepParam = getThreadSleepTime();
//				System.out.println("(DRGCalculationServlet:processDRGRequest)sleepParam: "+sleepParam);

				while(true)
				{
					Thread.sleep(sleepParam*1000); // Converting the sleep in seconds to milliseconds & make the thread sleep.
					responseRS = pstmt.executeQuery();
					if(responseRS.next())
					{
						responseText = responseRS.getString("response_text");
						profileID = responseRS.getString("profile_id");
						if(responseText != null) break;
					}
				}
			}
			else if(errorCode != null && !errorCode.equalsIgnoreCase("S"))
			{
//				System.out.println("(DRGCalculationServlet:processDRGRequest)Error Msg from Interactive Proc: "+errorMsg);

				java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				String errMsg = ((String) mesg.get("message"));

				results.put("drgErrCode",errorCode);
				results.put("drgErrMsg",errMsg);
				
				mesg.clear();
				return results;
			}

			responseText = responseText;
			stmt = dbConn.createStatement();
			rs = stmt.executeQuery("SELECT standard_code FROM xh_standard_profile WHERE profile_id='"+profileID+"'");
			if(rs.next())
			{
				standardCode = rs.getString("standard_code");
			}
			else
			{
				standardCode = "TGRP1";
			}

			elements.add(":DRG[38]");
			elements.add(":DRG[39]");
			elements.add(":DRG[40]");
			elements.add(":DRG[41]");
			elements.add(":DRG[42]");
			elements.add(":DRG[43]");
			elements.add(":DRG[44]");
			elements.add(":DRG[45]");
			elements.add(":DRG[48]");
			elements.add(":DRG[50]");		

			drgCalStmt = dbConn.prepareCall("begin ?:= XHGENERIC.GET_ELEMENT_VALUE(?,?,?); end;");
			drgCalStmt.registerOutParameter(1,java.sql.Types.VARCHAR);
			drgCalStmt.setString(2,responseText);
			drgCalStmt.setString(4,standardCode);

			String temp = "";
//			System.out.println("Elements Size "+elements.size());
			for(int i=0;i<elements.size();i++)
			{
				drgCalStmt.setString(3,(String)elements.get(i));
				drgCalStmt.execute();

				temp = checkNull(drgCalStmt.getString(1));
//				System.out.println("TEMP "+temp);
				if(i == 0)results.put("drg",temp);
				else if(i == 1)results.put("rw",temp);
				else if(i == 2)results.put("ot",temp);
				else if(i == 3)results.put("wtlos",temp);
				else if(i == 4)results.put("mdc",temp);
				else if(i == 5)results.put("err",temp);
				else if(i == 6)results.put("warn",temp);
				else if(i == 7)results.put("result",temp);
				else if(i == 8)results.put("Callos",temp);
				else if(i == 9)results.put("adjrw",temp);
				results.put("drgErrCode",errorCode);
				results.put("drgErrMsg","");
			}
			}			
			else if(procErrorCode == null || procErrorCode.equalsIgnoreCase("E"))
			{
	//			System.out.println("(DRGCalculationServlet:processDRGRequest)Error Msg from DRG Builder: "+procErrorTxt);

				java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
				String errMsg = ((String) mesg.get("message"));

				results.put("drgErrCode",procErrorCode);
				results.put("drgErrMsg",errMsg);
				
				mesg.clear();
				return results;
			}
			
						

		/*	while(true)
			{
				Thread.sleep(1000);
				responseStmt.execute();
				responseText = responseStmt.getString(2);
				if(responseText != null)
				{
					System.out.println("mdc... "+responseStmt.getString(5));
					results.put("mdc",responseStmt.getString(5));
					results.put("drg",responseStmt.getString(4));
					results.put("rw",responseStmt.getString(9));
					results.put("wtlos",responseStmt.getString(10));
					results.put("ot",responseStmt.getString(11));
					results.put("adjrw",responseStmt.getString(12));
					results.put("error",responseStmt.getString(6));
					results.put("warn",responseStmt.getString(7));
					results.put("exceptions",responseStmt.getString(14));
					results.put("status",responseStmt.getString(13));	
					break;
				}					
			}
		*/
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);			
			System.out.println("(DRGCalculationServlet:processDRGRequest) Exception "+exp.toString());
			
			java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
			String exceptionStr = ((String) mesg.get("message"));

			results.put("drgErrCode","E");
			results.put("drgErrMsg",exceptionStr);
			mesg.clear();
		}
		finally
		{
			try
			{				
				if(rs != null) rs.close();
				if(responseRS != null) responseRS.close();
				if(responseStmt != null) responseStmt.close();
				if(requestStmt != null) requestStmt.close();
				if(drgCalStmt != null) drgCalStmt.close();				
				if(pstmt != null) pstmt.close();
				if(stmt != null) stmt.close();
				if(dbConn != null) ConnectionManager.returnConnection(dbConn);
				
				elements.clear();
			}
			catch(Exception fexp)
			{
				fexp.printStackTrace(System.err);
			}
		}
		return results;
	}

	// Gets the next sequence no.
	private int getSequenceNo()
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		int seqNo = 0;
		String query = "SELECT xh_interactive_integration_seq.nextval FROM dual";

		try
		{
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			if(rs.next())
			{
				seqNo = rs.getInt(1);
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return seqNo;
	}

	/**
  * Method checks the Null String
  */
 public static String checkNull(String s)
 {
        return (((s == null)||(s.equals(""))||(s.equals("null"))||(s.equals(" "))) ? "" : s);
 }

/**
*  Method formats the "date" argument as per the "format" argument passed.
*  If the "date" argument is null, by default today's date will be considered.
*  Formatted date will returned as string
**/
public static String getFormattedStringDate(String format,java.util.Date date)
{	
	SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	if (date == null)
	{
		date = new java.util.Date();
	}
	String dateFormatted = dateFormat.format(date);
	return dateFormatted;
}

public HashMap getMsgData(String msgID)
{
	ArrayList elements = new ArrayList();
	HashMap results = new HashMap();

	String responseText = "";
	String profileID = "";
	String standardCode = "";

	Connection con = null;
	Statement stmt = null;
	Statement stmt1 = null;
	CallableStatement drgCalStmt = null;
	ResultSet rs1 = null;
	ResultSet rs = null;

	try
	{
		con = ConnectionManager.getConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT response_text,profile_id FROM xh_interactive_integration WHERE message_id='"+msgID+"'");
		if(rs.next())
		{
			responseText = rs.getString("response_text");
			profileID = rs.getString("profile_id");
		}

		responseText = responseText;
		stmt1 = con.createStatement();
		rs1 = stmt1.executeQuery("SELECT standard_code FROM xh_standard_profile WHERE profile_id='"+profileID+"'");
		if(rs1.next())
		{
			standardCode = rs1.getString("standard_code");
		}
		else
		{
			standardCode = "TGRP1";
		}

		elements.add(":DRG[38]");
		elements.add(":DRG[39]");
		elements.add(":DRG[40]");
		elements.add(":DRG[41]");
		elements.add(":DRG[42]");
		elements.add(":DRG[43]");
		elements.add(":DRG[44]");
		elements.add(":DRG[45]");
		elements.add(":DRG[48]");
		elements.add(":DRG[50]");		

		drgCalStmt = con.prepareCall("begin ?:= XHGENERIC.GET_ELEMENT_VALUE(?,?,?); end;");
		drgCalStmt.registerOutParameter(1,java.sql.Types.VARCHAR);
		drgCalStmt.setString(2,responseText);
		drgCalStmt.setString(4,standardCode);

		String temp = "";
//		System.out.println("Elements Size "+elements.size());
		for(int i=0;i<elements.size();i++)
		{
			drgCalStmt.setString(3,(String)elements.get(i));
			drgCalStmt.execute();

			temp = checkNull(drgCalStmt.getString(1));
//			System.out.println("Message TEMP "+temp);
			if(i == 0)results.put("drg",temp);
			else if(i == 1)results.put("rw",temp);
			else if(i == 2)results.put("ot",temp);
			else if(i == 3)results.put("wtlos",temp);
			else if(i == 4)results.put("mdc",temp);
			else if(i == 5)results.put("err",temp);
			else if(i == 6)results.put("warn",temp);
			else if(i == 7)results.put("result",temp);
			else if(i == 8)results.put("Callos",temp);
			else if(i == 9)results.put("adjrw",temp);
			results.put("drgErrCode","S");
		}

	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
	finally
	{
		try
		{
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt1.close();
			if(drgCalStmt != null) drgCalStmt.close();
			if(rs1 != null) rs1.close();
			if(rs != null) rs.close();
			if(con != null) ConnectionManager.returnConnection(con);
			elements.clear();
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
	}
	return results;
}

public int getThreadSleepTime()
{
	int sleepParam = 2;
	String queryInteractiveConnectParam = "SELECT sleepinterval FROM xh_interactive_connect_param WHERE plugin_type='DRG'";

	Connection dbConn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try
	{
		dbConn = ConnectionManager.getConnection();
		stmt = dbConn.createStatement();
		rs = stmt.executeQuery(queryInteractiveConnectParam);
		if(rs.next())
		{
			String temp = rs.getString("sleepinterval");
			if(temp != null) sleepParam = Integer.parseInt(temp);
		}
	}
	catch(Exception exp)
	{
		System.out.println("(DRGCalculationServlet:getThreadSleepTime) Exception "+exp);
		exp.printStackTrace(System.err);
	}
	finally
	{
		try
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(dbConn != null) ConnectionManager.returnConnection(dbConn);
		}
		catch(Exception fexp)
		{
			fexp.printStackTrace(System.err);
		}
	}
	return sleepParam;
}

	
}//end of class - DRGCalculationServlet
