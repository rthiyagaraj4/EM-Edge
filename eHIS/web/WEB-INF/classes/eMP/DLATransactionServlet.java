/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/***** Created on Date 6/17/2008 *******/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.net.InetAddress;

import webbeans.eCommon.*;
import eMP.DLAInterfaceUtil;

import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

public class DLATransactionServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	HttpServletRequest request = null;
	HttpServletResponse response = null;

	PrintWriter out;
	java.util.Properties p;

	private static final long pollTime = 60*1000;

	boolean isFromOracleDB = false;
	boolean newRequest = false;

	int sleepParam = 5;

	String facilityId ;
	String mode; // used to perform different query operations based on this value
	String user_name;
	String pass_word;
	String serach_mode;

	String national_id_name;
	String first_name;
	String sur_name;
	String search_type;
	String req_search;
	String locale;
	String req_status = null;
	String req_desc = null;
	String machineName;
	String added_by_id;
	String requestText = "";
	String requestSyntax = "";
	String responseText = "";
	String responseSyntax = "";
	String errorString = "";
	String patient_id = "";
	String function_id = "";
	boolean error = false;
	boolean dlaRequest = false;

	String searchQuery;
	String insertRequestQuery = 
					"INSERT INTO req_patient " +
					"(req_comp_name,req_search,req_type,req_status,req_username,req_password,req_desc,req_date,req_purge) " +
					"VALUES (?,?,?,?,?,?,?,?,?)";	
	String pollResponseQuery = "SELECT req_status,req_desc FROM req_patient WHERE req_search=? AND req_comp_name=?";

	Connection sqlServerConn;
	Connection oracleConnection;

	java.sql.Timestamp today_datetime = null;

	int seqNo = 0;
	
	HttpSession session = null;

	ArrayList symbols = null;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws javax.servlet.ServletException,IOException
	{			
		this.request = request;
		this.response = response;

		// Clearing the persistent info to avoid conflicts across various requests.
		isFromOracleDB = false;
		newRequest = false;
		seqNo = 0;
		error = false;
		errorString = "";
		//

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187
		request = new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
	//Added by Kamatchi S for security issue against COMMON-ICN-0187 END
		session = request.getSession(false);	
		out = response.getWriter();		

		try
		{
			// exception set if not able to get SQL server connection for the previous request, clearing that attribute if SQL Server connection was not successful
			session.removeAttribute("exception"); 
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facilityId = (String) session.getValue( "facility_id" ) ;		
			locale = p.getProperty("LOCALE");		
			added_by_id = (String) p.getProperty("login_user");
			machineName = p.getProperty("client_ip_address");

			mode = request.getParameter("mode");//indicates whether to search for eHIS tables or DLA request
			user_name = request.getParameter("user_name"); if(user_name==null) user_name="";
			pass_word = request.getParameter("pass_word"); if(pass_word==null) pass_word="";
			serach_mode = request.getParameter("search_by"); if(serach_mode==null) serach_mode="";

			national_id_name = request.getParameter("national_id_name"); if(national_id_name == null) national_id_name = "";
			first_name = request.getParameter("first_name"); if(first_name == null) first_name = "";
			sur_name = request.getParameter("sur_name"); if(sur_name == null) sur_name = "";
			patient_id = request.getParameter("patient_id"); if(patient_id == null) patient_id = "";
			function_id = request.getParameter("fucntion_id"); if(function_id == null) function_id = "";

		
			if(user_name != null && !user_name.equals(""))
			{
			
				session.setAttribute("dla_first_name",first_name);			
				session.setAttribute("dla_sur_name",sur_name);
				session.setAttribute("dla_machine_name",machineName);				
			}

			boolean isOldPatient = true;		

			// Indicates the flow from Change patient details - Citizen ID based search
			if(mode != null && mode.equalsIgnoreCase("search") && serach_mode != null && serach_mode.equalsIgnoreCase("N"))
			{				
				// Checking whether entered Citizen ID is a duplicate or not.
				isOldPatient = isOldPatient(); 								

				if(!isOldPatient)
				{
					String forward = "<script>parent.message_frame.location.href='../eCommon/html/blank.html';parent.action_frame.location.href = '../eMP/jsp/DlaInterfaceMain.jsp?display=details&national_id=&isFromOracleDB="+isFromOracleDB+"&patient_id="+patient_id+"&CalledFromFunction="+function_id+"'</script>";				
					out.print(forward);
				}				
			}
			else if(mode != null && mode.equalsIgnoreCase("close")) // Clearing the session if the user clicks on close button
			{
				

				session.removeAttribute("dla_image");
				session.setAttribute("dla_image_yn","N");				
				out.print("<script>window.close();</script>");

				isOldPatient = false;
			}
						
			if(isOldPatient)
			{					
				sqlServerConn = DLAInterfaceUtil.getConnection("DLAP");
				if(sqlServerConn == null)
				{
					error = true;
					java.util.Locale loc = new java.util.Locale(locale);
					java.util.ResourceBundle labels = java.util.ResourceBundle.getBundle( "eMP.resources.Messages",loc);					
					errorString = labels.getString("SQL_DB_CONN_FAIL");
					
					String forward = "<script>parent.message_frame.location.href = '../eCommon/jsp/MstCodeError.jsp?err_num="+errorString+"'</script>";
					out.print(forward);					
				}
				else
				{
					sleepParam = DLAInterfaceUtil.getSQLServerDBDetails("DLAP");
				//	insertAuditRecord("I","new"); // Inserting request audit record in to XH_INTERACTIVE_INTEGRATION
					if(sqlServerConn != null) DLAInterfaceUtil.closeConnection(sqlServerConn);
					if(serach_mode != null && serach_mode.equalsIgnoreCase("S"))
					{
						search_type = "1";
						req_search = first_name;						
						if(sur_name != null && !sur_name.equalsIgnoreCase(""))
						{
							req_search = req_search + " " + sur_name;							
						}
					}
					else
					{
						search_type = "0";
						req_search = national_id_name;
					}
					
					dlaSearch(out);
				}
			}							
		/*	else if(mode != null && mode.equalsIgnoreCase("DLASearch"))
			{
			

				user_name = (String)session.getAttribute("dla_user_id");
				pass_word = (String)session.getAttribute("dla_password");
				national_id_name = (String)session.getAttribute("dla_national_id");
				first_name = (String)session.getAttribute("dla_first_name");
				sur_name = (String)session.getAttribute("dla_sur_name");
				req_search = (String)session.getAttribute("dla_national_id");

				String seq = (String)session.getAttribute("dla_transaction_no");
				if(seq != null)
					seqNo = Integer.parseInt((String)session.getAttribute("dla_transaction_no"));				
				else
				{
				
					seqNo = getSequenceNumber("SELECT xh_Interactive_Trx_no_seq.NEXTVAL FROM dual");
				//	insertAuditRecord("I","old");
				}

				requestSyntax = (String)session.getAttribute("requestSyntax");
				requestText = (String)session.getAttribute("requestText");

				if(search_type.equals("0"))
					serach_mode = "N";
				else if(search_type.equals("1"))
					serach_mode = "S";


				if(serach_mode != null && serach_mode.equalsIgnoreCase("N"))
				{
					req_search = national_id_name;
				}
				else if(serach_mode != null && serach_mode.equalsIgnoreCase("S"))
				{
					req_search = first_name;
					if(first_name != null && !first_name.equalsIgnoreCase(""))
						req_search = req_search+" ";
					if(sur_name != null && !sur_name.equalsIgnoreCase(""))
						req_search = req_search+sur_name;
				}

				
				dlaSearch(out);
			} */
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);			
		}
	}


	private boolean requestPatientData(PrintWriter out)
	{
		PreparedStatement insertRequestPStmt = null;
		PreparedStatement tempPStmt = null;
		ResultSet tempRSet = null;		

		boolean recordInserted = false;
		boolean recordFound = false;
		
		newRequest = true;				

		req_status = "";

		today_datetime = null;
		
		try
		{	
		
			today_datetime = new java.sql.Timestamp(new java.util.Date().getTime());			

			String str_date = String.valueOf(today_datetime);
			str_date = str_date.replace('.','-');
			str_date = str_date.replaceAll("-","");
			str_date = str_date.replaceAll(":","");
			str_date = str_date.replaceAll(" ","");			

			//setting datetime & req_search in session to be used in DLAInterfaceSearchResult to update purge status for new DLA request.
			session.setAttribute("today_datetime",str_date);
			session.setAttribute("req_search",req_search);

			sqlServerConn = DLAInterfaceUtil.getConnection("");
			if(sqlServerConn == null)
			{
				session.setAttribute("exception",errorString);	
			}

			insertRequestPStmt = sqlServerConn.prepareStatement(insertRequestQuery);
			insertRequestPStmt.setString(1,machineName+"/"+str_date);			
			insertRequestPStmt.setString(2,req_search);
			insertRequestPStmt.setString(3,search_type);
			insertRequestPStmt.setString(4,"R");
			insertRequestPStmt.setString(5,user_name);
			insertRequestPStmt.setString(6,pass_word);
			insertRequestPStmt.setString(7,"");
			insertRequestPStmt.setTimestamp(8,today_datetime);
			insertRequestPStmt.setString(9,"N");
			
			int i = insertRequestPStmt.executeUpdate();	
			
			if(i > 0)
			{
				recordInserted = true;
				
				long startTime = System.currentTimeMillis();
				long currentDiff = System.currentTimeMillis() - startTime;

				insertAuditRecord("I","new");

				

				// Checking response for 60 seconds.			
				while(currentDiff < pollTime)
				{						
					Thread.sleep(sleepParam*1000); // Checking for updation of request 60 seconds in the interval specified for sleepParam.

					tempPStmt = sqlServerConn.prepareStatement(pollResponseQuery);					
					tempPStmt.setString(1,req_search);
					tempPStmt.setString(2,machineName+"/"+str_date);
				//	tempPStmt.setTimestamp(3,today_datetime);
					
					tempRSet = tempPStmt.executeQuery();										
					if(tempRSet.next())
					{						
						req_status = tempRSet.getString("req_status");
						req_desc = tempRSet.getString("req_desc");
					}

					if(req_status != null && 
						(req_status.equalsIgnoreCase("Y") || req_status.equalsIgnoreCase("N") || req_status.equalsIgnoreCase("E")))
					{
						recordFound = true;
						if(tempRSet != null) tempRSet.close();
						if(tempPStmt != null) tempPStmt.close();
						
						break;
					}
					currentDiff = System.currentTimeMillis() - startTime;
				}	
				insertAuditRecord("U","");
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
				if(insertRequestPStmt != null) insertRequestPStmt.close();											
				if(tempRSet != null) tempRSet.close();
				if(tempPStmt != null) tempPStmt.close();
				DLAInterfaceUtil.closeConnection(sqlServerConn);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return recordFound;
	}	

	private void dlaSearch(PrintWriter out)
	{
	
		session.setAttribute("new_req","Y"); // flag used in DLAInterfaceSearchResult to update purge status for new DLA request.
		
		boolean recordFound = requestPatientData(out);
	//	insertAuditRecord("U","");		

		String t_datetime = (String)session.getAttribute("today_datetime");
		String req_srch = (String)session.getAttribute("req_search");
		String dla_mach_name = (String)session.getAttribute("dla_machine_name");
	
		if(recordFound && (req_status.equalsIgnoreCase("E") || req_status.equalsIgnoreCase("N")))
		{					
			if(req_status.equalsIgnoreCase("E"))
				req_desc = "DLA-Error:"+req_desc;
			DLAInterfaceUtil.updatePurgeStatus(t_datetime,dla_mach_name,req_srch);
			out.print("<script>parent.message_frame.location.href='../eCommon/html/blank.html';alert('"+req_desc+"')</script>");			
		}		
		else if(recordFound && req_status.equalsIgnoreCase("Y"))
		{
			String forward = "";
			String code = null;

			if(serach_mode != null && serach_mode.equalsIgnoreCase("S"))
			{
				code = getRecordCount(first_name,sur_name,false,dla_mach_name,t_datetime);			
				if(code != null)
				{				
					forward = "<script>parent.message_frame.location.href='../eCommon/html/blank.html';location.href='../eMP/jsp/DlaIDupChk.jsp?national_id="+code+"&patient_id="+patient_id+"'</script>";			
				}
				else
				{
					forward = "<script>parent.message_frame.location.href='../eCommon/html/blank.html';parent.action_frame.location.href = '../eMP/jsp/DLAQueryResults.jsp?message=&mode="+mode+"&serach_mode="+serach_mode+"&isFromOracleDB="+isFromOracleDB+"&newRequest="+newRequest+"&code="+code+"'</script>";
				}			
			}
			if(serach_mode != null && serach_mode.equalsIgnoreCase("N"))
				forward = "<script>parent.message_frame.location.href='../eCommon/html/blank.html';parent.action_frame.location.href = '../eMP/jsp/DlaInterfaceMain.jsp?display=details&national_id="+req_search+"&isFromOracleDB=false&code="+code+"&patient_id="+patient_id+"&CalledFromFunction="+function_id+"'</script>";
			out.print(forward);
		}
		else if(!recordFound)
		{
			java.util.Locale loc = new java.util.Locale(locale);
			java.util.ResourceBundle labels = java.util.ResourceBundle.getBundle( "eMP.resources.Messages",loc);
			java.util.ResourceBundle commonLabels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
			//java.util.ResourceBundle mpLabels = java.util.ResourceBundle.getBundle( "eMP.resources.Labels",loc);
			errorString = labels.getString("DLA_REQUEST_TIME_OUT");

			//String reqStatDesc_label = mpLabels.getString("eMP.ReqStatDesc.label");
			String reqStatus_label = commonLabels.getString("Common.RequestStatus.label");
			String temp = "";

			if(req_status != null && req_status.equalsIgnoreCase("R"))	temp = labels.getString("DLA_REQUEST_NOT_PROCESSED");
			else temp = labels.getString("DLA_RESPONSE_NOT_FOUND");

			req_desc = "DLA-Error:"+errorString+"\\n";
			req_desc = req_desc+temp+"\\n";
			req_desc = req_desc+reqStatus_label+": "+req_status;			

			String forward = "<script>parent.message_frame.location.href = '../eCommon/html/blank.html'</script>";
			out.print(forward);
			out.print("<script>alert('"+req_desc+"')</script>");
		}
	}

	private boolean isOldPatient()
	{
	
		PreparedStatement isExistingPStmt = null;
		ResultSet isExistingRSet = null;

		req_search = "";
		String tempQuery = "";

	//	HashMap patientDetails = null;				
		
		boolean dlaRequest = false;

		tempQuery = "SELECT * FROM mp_patient WHERE ";

		try
		{
			sqlServerConn = ConnectionManager.getConnection();
			if(serach_mode != null && serach_mode.equalsIgnoreCase("N"))
			{
				tempQuery = DLAInterfaceUtil.getOracleDBQueryByNationalID();
				isExistingPStmt = sqlServerConn.prepareStatement(tempQuery);
				isExistingPStmt.setString(1,national_id_name);			
				search_type = "0";
				req_search = national_id_name;
				isExistingRSet = isExistingPStmt.executeQuery();


				if(isExistingRSet.next())
				{
												
					String pat_id = isExistingRSet.getString(2);
				
					if(pat_id != null && pat_id.equalsIgnoreCase(patient_id))
					{
						
						dlaRequest = true;
					}
					else
					{
						dlaRequest = false;
						isFromOracleDB = true; // Indicates duplicate citizen ID
					}
				}
				else
				{
					dlaRequest = true;
				}
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
			
				if(isExistingPStmt != null) isExistingPStmt.close();
				if(isExistingRSet != null) isExistingRSet.close();
				ConnectionManager.returnConnection(sqlServerConn);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return dlaRequest;
	}	

	public void insertAuditRecord(String modee,String requestType)
	{
		

		CallableStatement oraclecallablestatement = null;
		Connection oraConnection = null;

		String mode = "";		

		try
		{									
			if(modee != null && modee.equalsIgnoreCase("I"))	
			{
				ArrayList requestAttributeList = (ArrayList)buildRequestAttributes(requestType);

				requestText = (String)requestAttributeList.get(0);
				requestSyntax = (String)requestAttributeList.get(1);

				session.setAttribute("requestText",requestText);
				session.setAttribute("requestSyntax",requestSyntax);

				seqNo = getSequenceNumber("SELECT xh_Interactive_Trx_no_seq.NEXTVAL FROM dual"); 
				session.setAttribute("dla_transaction_no",String.valueOf(seqNo));
				mode = "I";
			}
			else if(modee != null && modee.equalsIgnoreCase("U"))
			{
				ArrayList responseAttributeList = (ArrayList)buildResponseAttributes();				

				responseText = (String)responseAttributeList.get(0);
				responseSyntax = (String)responseAttributeList.get(1);

				mode = "U";
			}

			java.util.Date d = new java.util.Date();
			String strDateTime = DLAInterfaceUtil.getFormattedStringDate("dd-MMM-yyyy HH:mm:ss", d);

			if(oraConnection == null) oraConnection = ConnectionManager.getConnection();
			oraclecallablestatement = oraConnection.prepareCall("{call XHINTERACTIVE.Interactive_interfac_audit(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			oraclecallablestatement.setString(1,mode);
			oraclecallablestatement.registerOutParameter(2,java.sql.Types.VARCHAR);
			oraclecallablestatement.registerOutParameter(3,java.sql.Types.VARCHAR);
			oraclecallablestatement.setString(4,user_name);
			oraclecallablestatement.setString(5,machineName);
			oraclecallablestatement.setString(6,machineName);
			oraclecallablestatement.setString(7,"DLASearch");
			oraclecallablestatement.setString(8,"XR");						
			oraclecallablestatement.setString(9,String.valueOf(session.getId()));
		//	oraclecallablestatement.setDate(10,new java.sql.Date(d.getTime()));
			oraclecallablestatement.setString(10, strDateTime);
			oraclecallablestatement.setString(11,requestText);
			oraclecallablestatement.setString(12,"DLA");
			oraclecallablestatement.setString(13,String.valueOf(getSequenceNumber("SELECT XH_DLA_INTERFACE_SEQ.nextVal FROM dual")));
			oraclecallablestatement.setString(14,facilityId);
		//	oraclecallablestatement.setDate(15,new java.sql.Date(d.getTime()));
			oraclecallablestatement.setString(15, strDateTime);
			oraclecallablestatement.setString(16,"DLA");
			oraclecallablestatement.setString(17,req_search);
			oraclecallablestatement.setString(18,"");
			oraclecallablestatement.setString(19,""); 
			oraclecallablestatement.setString(20,""); //encounter
			oraclecallablestatement.setString(21,req_search);
			oraclecallablestatement.setString(22,"");
			oraclecallablestatement.setString(23,requestSyntax);
			oraclecallablestatement.setString(24,req_search);
			oraclecallablestatement.setString(25,"DLA");
			oraclecallablestatement.setString(26,added_by_id);
		//	oraclecallablestatement.setDate(27,new java.sql.Date(d.getTime()));
			oraclecallablestatement.setString(27, strDateTime);
			oraclecallablestatement.setString(28,added_by_id);
		//	oraclecallablestatement.setDate(29,new java.sql.Date(d.getTime()));
			oraclecallablestatement.setString(29, strDateTime);
			oraclecallablestatement.setString(30,machineName);
			oraclecallablestatement.setString(31,facilityId);
			oraclecallablestatement.setString(32,machineName);
			oraclecallablestatement.setString(33,facilityId);
			
			oraclecallablestatement.setInt(34,seqNo);
			oraclecallablestatement.setString(35,responseText);
			oraclecallablestatement.setString(36,responseSyntax);
			oraclecallablestatement.setString(37,"DLAP");

			oraclecallablestatement.execute();
	
			if(modee != null && modee.equalsIgnoreCase("U"))
			{
				requestText = "";
				requestSyntax = "";
				responseText = "";
				responseSyntax = "";
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
				if(oraclecallablestatement != null) oraclecallablestatement.close();
				if(oraConnection != null) ConnectionManager.returnConnection(oraConnection);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}

	}
	//Method to build the request string with the data requested from DLA
	public List buildRequestAttributes(String requestType)
	{
		StringBuffer requestText = null;
		StringBuffer requestSyntax = null;

		String field_seperator = "";

		ArrayList attributeList = null;		

		try
		{
			symbols = (ArrayList)DLAInterfaceUtil.getMessageDelimiters();
			field_seperator = (String)symbols.get(4);

			requestText = new StringBuffer();

			requestText.append((String)symbols.get(0));
			requestText.append((String)symbols.get(2));
			requestText.append(machineName+field_seperator);
			requestText.append(req_search+field_seperator);
			requestText.append(search_type+field_seperator);
			requestText.append("R"+field_seperator);
			requestText.append(user_name+field_seperator);			
			requestText.append(field_seperator);
			requestText.append(new java.sql.Timestamp(new java.util.Date().getTime())+field_seperator);
			requestText.append("N"+field_seperator);
			requestText.append(requestType);
			requestText.append((String)symbols.get(3));
			requestText.append((String)symbols.get(1));					

			requestSyntax = new StringBuffer();

			requestSyntax.append((String)symbols.get(0));
			requestSyntax.append((String)symbols.get(2));
			requestSyntax.append("req_comp_name"+field_seperator);
			requestSyntax.append("req_search"+field_seperator);
			requestSyntax.append("req_type"+field_seperator);
			requestSyntax.append("req_status"+field_seperator);
			requestSyntax.append("req_username"+field_seperator);		
			requestSyntax.append("req_desc"+field_seperator);
			requestSyntax.append("req_date"+field_seperator);
			requestSyntax.append("req_purge"+field_seperator);
			requestSyntax.append("request_type");
			requestSyntax.append((String)symbols.get(3));
			requestSyntax.append((String)symbols.get(1));

			

			attributeList = new ArrayList();
			attributeList.add(requestText.toString());
			attributeList.add(requestSyntax.toString());
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		return attributeList;
	}

	//Method to build the request string with the data requested from DLA
	public List buildResponseAttributes()
	{
		PreparedStatement isExistingPStmt = null;
		ResultSet isExistingRSet = null;
		Connection sqlServerConn;

		StringBuffer responseText = null;
		StringBuffer responseSyntax = null;
		StringBuffer requestText = null;
	//	StringBuffer requestSyntax = null;

		String field_seperator = "";
		String searchQuery = "SELECT * FROM patient WHERE req_comp_name = ?";

		ArrayList attributeList = null; 
		sqlServerConn = null;

		try
		{
			if(symbols == null)	symbols = (ArrayList)DLAInterfaceUtil.getMessageDelimiters();

			field_seperator = (String)symbols.get(4);

			requestText = new StringBuffer();

			sqlServerConn = DLAInterfaceUtil.getConnection("DLAP");
			if(sqlServerConn == null)
			{				
				session.setAttribute("exception",errorString);		
			}

		
			String today_datetime = (String)session.getAttribute("today_datetime");			

			isExistingPStmt = sqlServerConn.prepareStatement(searchQuery);
			isExistingPStmt.setString(1,machineName+"/"+today_datetime);
			isExistingRSet = isExistingPStmt.executeQuery();

			responseText = new StringBuffer();			
			responseText.append((String)symbols.get(0));
			responseText.append((String)symbols.get(2));

			while(isExistingRSet.next())
			{								
				responseText.append(isExistingRSet.getString("req_comp_name")+field_seperator);
				responseText.append(isExistingRSet.getString("pid")+field_seperator);
				responseText.append(isExistingRSet.getString("title")+field_seperator);
				responseText.append(isExistingRSet.getString("fname")+field_seperator);
				responseText.append(isExistingRSet.getString("lname")+field_seperator);				
				responseText.append(isExistingRSet.getString("dob")+field_seperator);
				responseText.append(isExistingRSet.getString("sex")+field_seperator);				
				responseText.append(isExistingRSet.getString("nat")+field_seperator);				
				responseText.append(isExistingRSet.getString("ffname")+field_seperator);				
				responseText.append(isExistingRSet.getString("mfname")+field_seperator);												
				responseText.append(isExistingRSet.getString("si_prov_code")+field_seperator);
				responseText.append("IMAGE"+field_seperator);
				responseText.append(isExistingRSet.getString("imgtxt")+field_seperator);
				responseText.append(isExistingRSet.getString("imgsize")+field_seperator);
				responseText.append(isExistingRSet.getString("dead_status")+field_seperator);
				responseText.append(isExistingRSet.getString("dead_discharge")+field_seperator);
				responseText.append(isExistingRSet.getString("si_present_address1")+field_seperator);
				responseText.append(isExistingRSet.getString("si_present_address2")+field_seperator);
				responseText.append(isExistingRSet.getString("si_present_address3")+field_seperator);
				responseText.append(isExistingRSet.getString("si_present_address4")+field_seperator);
				responseText.append((char)13);
			}
			responseText.append((String)symbols.get(3));
			responseText.append((String)symbols.get(1)); 		

			responseSyntax = new StringBuffer();

			responseSyntax.append((String)symbols.get(0));
			responseSyntax.append((String)symbols.get(2));
			responseSyntax.append("req_comp_name"+field_seperator);
			responseSyntax.append("pid"+field_seperator);
			responseSyntax.append("title"+field_seperator);						
			responseSyntax.append("fname"+field_seperator);
			responseSyntax.append("lname"+field_seperator);			
			responseSyntax.append("dob"+field_seperator);
			responseSyntax.append("sex"+field_seperator);			
			responseSyntax.append("nat"+field_seperator);			
			responseSyntax.append("ffname"+field_seperator);			
			responseSyntax.append("mfname"+field_seperator);			
			responseSyntax.append("si_prov_code"+field_seperator);
			responseSyntax.append("img"+field_seperator);
			responseSyntax.append("imgtxt"+field_seperator);
			responseSyntax.append("imgsize"+field_seperator);
			responseSyntax.append("dead_status"+field_seperator);
			responseSyntax.append("dead_discharge"+field_seperator);
			responseSyntax.append("si_present_address1"+field_seperator);
			responseSyntax.append("si_present_address2"+field_seperator);
			responseSyntax.append("si_present_address3"+field_seperator);
			responseSyntax.append("si_present_address4"+field_seperator);
			responseSyntax.append((String)symbols.get(3));
			responseSyntax.append((String)symbols.get(1));			

			attributeList = new ArrayList();

			attributeList.add(responseText.toString());
			attributeList.add(responseSyntax.toString());
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(isExistingRSet != null) isExistingRSet.close();
				if(isExistingPStmt != null) isExistingPStmt.close();
				if(sqlServerConn != null) sqlServerConn.close();
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return attributeList;
	}

	public int getSequenceNumber(String query)
	{
	//	query = "SELECT Interfactive_Trx_no_seq.NEXTVAL FROM dual";
		ResultSet rs = null;
		Connection oraConnection = null;
		int seqNo = 0;
		try
		{
			if(oraConnection == null) oraConnection = ConnectionManager.getConnection();
			rs = oraConnection.createStatement().executeQuery(query);
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
				if(oraConnection != null) ConnectionManager.returnConnection(oraConnection); 
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return seqNo;
	}

	/**
	*  Method checks for any exception occured by checking global boolean variable error.
	*  If error is true, then request will be sent back with the erorrString displayed in message frame.
	**/
	public void errorCheck(PrintWriter out)
	{		
		if(error)
		{			 
		//	String forward =  "<script>parent.message_frame.location.href = '../eCommon/jsp/MstCodeError.jsp?err_num="+errorString+"'</script>";
			
			out.print(errorString);
		}
	}
	
	/**
	 * Method used to find out how many records exists with the entered search criteria.
	 * When the search results only one record, 
	 * patient details are directly displayed without displaying multiple records screen.
	 */
	public String getRecordCount(String firstName,String lastName,boolean isFromOracleDB,String machineName,String dateTime)
	{
		String searchQuery = "";
		String code = null; 

		Connection sqlServerConn = null;
		PreparedStatement isExistingPStmt = null;
		ResultSet isExistingRSet = null;

		try
		{
			sqlServerConn = DLAInterfaceUtil.getConnection("DLAP");
			if(sqlServerConn == null)
			{
				session.setAttribute("exception",errorString);	
			}
			searchQuery = DLAInterfaceUtil.getSqlDBSearchByName(); 		
		
			isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			isExistingPStmt.setString(1,machineName+"/"+dateTime);
			isExistingRSet = isExistingPStmt.executeQuery();

			isExistingRSet.last();
			int rowCount = isExistingRSet.getRow();
			isExistingRSet.beforeFirst();

			if(rowCount == 1)
			{
				isExistingRSet.next() ;
				code = isExistingRSet.getString(1);
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
				if(isExistingRSet != null) isExistingRSet.close();
				if(isExistingPStmt != null) isExistingPStmt.close();
				if(sqlServerConn != null) DLAInterfaceUtil.closeConnection(sqlServerConn);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}

		return code;
	}	
}
