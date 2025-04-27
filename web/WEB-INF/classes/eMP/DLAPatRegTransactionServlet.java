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

public class DLAPatRegTransactionServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	HttpServletRequest request = null;

	PrintWriter out;
	java.util.Properties p;

	private static final long pollTime = 60*1000;

	boolean isFromOracleDB = false;
	boolean newRequest = false;

	String facilityId ;
	String client_ip_address ;
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
	boolean error = false;

	String searchQuery;
	String authenticateUserQuery = "SELECT full_name FROM view_req_user WHERE user_name=? AND password=?";
	String authFailQuery = "INSERT INTO req_patient (req_status,req_desc) VALUES('E','Invalid username or password')";
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

		// Clearing the persistent info to avoid conflicts across various request.
		isFromOracleDB = false;
		newRequest = false;
		seqNo = 0;
		error = false;
		errorString = "";
		//

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		session = request.getSession(false);
		
		PrintWriter out = response.getWriter();

		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		locale  = p.getProperty("LOCALE");		

		added_by_id = (String) p.getProperty("login_user");;

	//	machineName = InetAddress.getLocalHost().getHostName();

		//InetAddress remoteAddress = null;

		try
		{
			
			
		//	remoteAddress = InetAddress.getByName(request.getRemoteAddr());
			
		//	machineName = remoteAddress.getHostName();	
			machineName = p.getProperty("client_ip_address");
		
		}
		catch(Exception e)
		{
		
		} 

		

	//	MessageManager mm=new MessageManager();

		searchQuery = "SELECT * FROM patient WHERE req_comp_name LIKE ?";

		try
		{
			mode = request.getParameter("mode");//indicates whether to search for eHIS tables or DLA request

			user_name = request.getParameter("user_name"); if(user_name==null) user_name="";
			pass_word = request.getParameter("pass_word"); if(pass_word==null) pass_word="";
			serach_mode = request.getParameter("search_by"); if(serach_mode==null) serach_mode="";

			national_id_name = request.getParameter("national_id_name"); if(national_id_name==null) national_id_name="";
			first_name = request.getParameter("first_name"); if(first_name==null) first_name="";
			sur_name = request.getParameter("sur_name"); if(sur_name==null) sur_name="";  
			

			if(user_name != null && !user_name.equals(""))
			{
				
				session.setAttribute("dla_user_id",user_name);
				session.setAttribute("dla_password",pass_word);
				session.setAttribute("dla_national_id",national_id_name);
				session.setAttribute("dla_first_name",first_name);
				session.setAttribute("dla_sur_name",sur_name);
				session.setAttribute("dla_machine_name",machineName);				
			}

		//	RequestDispatcher reqDis = null;		

			if(mode != null && mode.equalsIgnoreCase("search"))
			{				
				
				boolean isOldPatient = isOldPatient(); // checking in eHIS database for the user.
				boolean exists = false;
				if(!isOldPatient)
				{
					sqlServerConn = DLAInterfaceUtil.getConnection(getServletContext().getRealPath("/")+"WEB-INF/CLASSES/eMP/");
					if(sqlServerConn == null)
					{
						error = true;
						java.util.Locale loc = new java.util.Locale(locale);
						java.util.ResourceBundle labels = java.util.ResourceBundle.getBundle( "eMP.resources.Messages",loc);
					//	errorString = "Unable to establish SQL Server database connection";
						errorString = labels.getString("SQL_DB_CONN_FAIL");
						
					}
					else
					{
						sqlServerConn.close();
						
						exists = isExistingPatient(machineName,"");
					}
				}
				
				if(exists || isOldPatient)
				{
					String code = null;
					
					if(exists)
					{
						
					//	insertAuditRecord("I","old"); // Inserting request audit record in to XH_INTERACTIVE_INTEGRATION
					//	insertAuditRecord("U",""); // Updating the request audit record with response text.
					
						if(serach_mode != null && serach_mode.equalsIgnoreCase("S"))
						{
							code = getRecordCount(first_name,sur_name,false,machineName,"");
						}
					}
					else
					{
						if(serach_mode != null && serach_mode.equalsIgnoreCase("S"))
						{
							code = getRecordCount(first_name,sur_name,true,machineName,"");
						}
					}

					String message = "Patient details alreay exists! Would you like to continue getting data from DLA?.";
					String forward = "<script>parent.message_frame.location.href='../eCommon/html/blank.html';parent.action_frame.location.href = '../eMP/jsp/DLAQueryResults.jsp?message="+message+"&mode="+mode+"&serach_mode="+serach_mode+"&isFromOracleDB="+isFromOracleDB+"&code="+code+"'</script>";
				//	forward = forward+"<script>parent.image_frame.location.href = '../eMP/jsp/DlauiInterfaceSearchResultImage.jsp'</script>";
					out.print(forward);
				}
				else if(error)
				{
					String forward = "<script>parent.message_frame.location.href = '../eCommon/jsp/MstCodeError.jsp?err_num="+errorString+"'</script>";
				//	forward = forward+"<script>parent.image_frame.location.href = '../eMP/jsp/DlauiInterfaceSearchResultImage.jsp'</script>";
					out.print(forward);
				}
				else
				{
					
					/*	boolean validUser = isValidUser();
					if(validUser)
					{
					*/	

				//	insertAuditRecord("I","new"); // Inserting request audit record in to XH_INTERACTIVE_INTEGRATION
					dlaSearch(out);

					/*	}
					else
					{
					final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_USER_ID", "Common") ;
					String err_flag = ((String) mesg.get("message"));
					out.print("<script>alert('"+err_flag+"')</script>");					
					}
					*/
				}
				
			}
			else if(mode != null && mode.equalsIgnoreCase("getPatientData"))
			{
				
			}
			else if(mode != null && mode.equalsIgnoreCase("DLASearch"))
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


				
			/*	boolean validUser = isValidUser();
				if(validUser)
				{
			*/
				dlaSearch(out);

			/*	}
				else
				{
					final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_USER_ID", "Common") ;
					String err_flag = ((String) mesg.get("message"));
					out.print("<script>alert('"+err_flag+"')</script>");					
				}
			*/
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);			
		}
	}

	// Checks whether the required patient details already exists or not.
	private boolean isExistingPatient(String machineName,String dateTime)
	{
	
		PreparedStatement isExistingPStmt = null;
		ResultSet isExistingRSet = null;

		req_search = "";
		String tempQuery = "";

	//	HashMap patientDetails = null;				

		boolean isPatientExists = false;

		try
		{
		
			
			sqlServerConn = DLAInterfaceUtil.getConnection(getServletContext().getRealPath("/")+"WEB-INF/CLASSES/eMP/");				
			
		
			if(serach_mode != null && serach_mode.equalsIgnoreCase("N"))
			{
			

				tempQuery = searchQuery+" AND pid = ?";

				isExistingPStmt = sqlServerConn.prepareStatement(tempQuery);
				isExistingPStmt.setString(1,machineName+"/"+dateTime+"%");			
				isExistingPStmt.setString(2,national_id_name);
				
				search_type = "0";
				req_search = national_id_name;

		
			}
			else if(serach_mode != null && serach_mode.equalsIgnoreCase("S"))
			{
			
			//	tempQuery = searchQuery+" AND fname LIKE ? AND lname LIKE ?";
			
				boolean flag = false;
				if(first_name != null && !first_name.equalsIgnoreCase(""))
				{
					flag = true;
					tempQuery = searchQuery+" AND fname LIKE ?";
				}
				if(sur_name != null && !sur_name.equalsIgnoreCase(""))
				{
					if(flag)
					{
						tempQuery = tempQuery+" AND lname LIKE ?";
						isExistingPStmt = sqlServerConn.prepareStatement(tempQuery);
						isExistingPStmt.setString(1,machineName+"/"+dateTime+"%");
						isExistingPStmt.setString(2,first_name+"%");
						isExistingPStmt.setString(3,sur_name+"%");
					}
					else
					{
						tempQuery = searchQuery+" AND lname LIKE ?";
						isExistingPStmt = sqlServerConn.prepareStatement(tempQuery);
						isExistingPStmt.setString(1,machineName+"/"+dateTime+"%");						
						isExistingPStmt.setString(2,first_name+"%");
					}
				}
				else
				{
					isExistingPStmt = sqlServerConn.prepareStatement(tempQuery);
					isExistingPStmt.setString(1,machineName+"/"+dateTime+"%");						
					isExistingPStmt.setString(2,sur_name+"%");
				}
				
													

				search_type = "1";
				req_search = first_name;

				if(first_name != null && !first_name.equalsIgnoreCase(""))
					req_search = req_search+" ";
				if(sur_name != null && !sur_name.equalsIgnoreCase(""))
					req_search = req_search+sur_name;
			
			}

			isExistingRSet = isExistingPStmt.executeQuery();
		
			if(isExistingRSet.next())
			{
				
				isPatientExists = true;
			/*	patientDetails = new HashMap();
				patientDetails.put("firstname",isExistingRSet.getString("fname"));
				patientDetails.put("surname",isExistingRSet.getString("lname"));
				
				patientDetails.put("dob",isExistingRSet.getString("dob"));
				patientDetails.put("nationality",isExistingRSet.getString("nat"));
				patientDetails.put("national_id",isExistingRSet.getString("pid"));
				patientDetails.put("fathername",isExistingRSet.getString("ffname"));
				patientDetails.put("mothername",isExistingRSet.getString("mfname"));
				patientDetails.put("address",isExistingRSet.getString("si_present_address"));
				patientDetails.put("gender",isExistingRSet.getString("sex"));
				patientDetails.put("serach_mode",serach_mode);

				if(session != null) session.setAttribute("patientDetails",patientDetails);
				
			*/
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
				DLAInterfaceUtil.closeConnection(sqlServerConn);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return isPatientExists;
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

			sqlServerConn = DLAInterfaceUtil.getConnection(getServletContext().getRealPath("/")+"WEB-INF/CLASSES/eMP/");
			
		//	java.util.Date today = new java.util.Date();								

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
								
			}			

			if(recordInserted)
			{
				//String forward = "<script>parent.message_frame.location.href = '../eCommon/html/process.html'</script>";
			//	forward = forward+"<script>parent.image_frame.location.href = '../eMP/jsp/DlauiInterfaceSearchResultImage.jsp'</script>";
			//	out.print(forward);
				long startTime = System.currentTimeMillis();
				long currentDiff = System.currentTimeMillis() - startTime;
				
			//	out.print(forward);
				// Checking for response for 60 seconds.
				//int counter = 0;
				while(currentDiff < pollTime)
				{	
					Thread.sleep(10000); // Checking for the request updare every 10 seconds for 60 seconds.					
				//	out.print(forward);
				
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

	// Checks whether the user is valid or not.
	private boolean isValidUser()
	{
		PreparedStatement authPStmt = null;
		Statement authFailStmt = null;
		ResultSet authResultSet = null;
		boolean isValidUser = true;
		
		try
		{
			sqlServerConn = DLAInterfaceUtil.getConnection(getServletContext().getRealPath("/")+"WEB-INF/CLASSES/eMP/");

			authPStmt = sqlServerConn.prepareStatement(authenticateUserQuery);
			authPStmt.setString(1,user_name);
			authPStmt.setString(2,pass_word);
			authResultSet = authPStmt.executeQuery();

			if(!authResultSet.next()) 
			{				
				authFailStmt = sqlServerConn.createStatement();
				authFailStmt.executeUpdate(authFailQuery);				
				isValidUser = false;
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
				if(authFailStmt != null) authFailStmt.close();
				if(authPStmt != null) authPStmt.close();
				if(authResultSet != null) authResultSet.close();
				DLAInterfaceUtil.closeConnection(sqlServerConn);
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}
		return isValidUser;
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
		//	isExistingPatient();
		//	updatePurgeStatus();
			String forward = "";
			
			
			String code = null;
			if(serach_mode != null && serach_mode.equalsIgnoreCase("S"))
			{
				code = getRecordCount(first_name,sur_name,false,dla_mach_name,t_datetime);
				forward = "<script>parent.message_frame.location.href='../eCommon/html/blank.html';parent.action_frame.location.href = '../eMP/jsp/DLAQueryResults.jsp?message=&mode="+mode+"&serach_mode="+serach_mode+"&isFromOracleDB="+isFromOracleDB+"&newRequest="+newRequest+"&code="+code+"'</script>";
			}
			if(serach_mode != null && serach_mode.equalsIgnoreCase("N"))
				forward = "<script>parent.message_frame.location.href='../eCommon/html/blank.html';parent.action_frame.location.href = '../eMP/jsp/DlaInterfaceMain.jsp?display=details&national_id="+req_search+"&isFromOracleDB="+isFromOracleDB+"&code="+code+"'</script>";
		//	forward = forward+"<script>parent.image_frame.location.href = '../eMP/jsp/DlauiInterfaceSearchResultImage.jsp'</script>";
		//	DLAInterfaceUtil.updatePurgeStatus(t_datetime,dla_mach_name,req_srch);
			out.print(forward);
		//	out.print("<script>location.href = '../eMP/jsp/DlauiInterfaceSearchResultImage.jsp'</script>");
		}
		else if(!recordFound)
		{
			java.util.Locale loc = new java.util.Locale(locale);
			java.util.ResourceBundle labels = java.util.ResourceBundle.getBundle( "eMP.resources.Messages",loc);
			java.util.ResourceBundle commonLabels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
			java.util.ResourceBundle mpLabels = java.util.ResourceBundle.getBundle( "eMP.resources.Labels",loc);
			errorString = labels.getString("DLA_REQUEST_TIME_OUT");
			String reqStatDesc_label = mpLabels.getString("eMP.ReqStatDesc.label");
			String reqStatus_label = commonLabels.getString("Common.RequestStatus.label");

			String temp = req_desc;
			req_desc = "DLA-Error:"+errorString+"\\n";
			if(temp != null && !temp.equalsIgnoreCase(""))	req_desc = req_desc+reqStatDesc_label+temp;
			else req_desc = req_desc+reqStatus_label+": "+req_status;			

		
			String forward = "<script>parent.message_frame.location.href = '../eCommon/html/blank.html'</script>";
		//	forward = forward+"<script>parent.image_frame.location.href = '../eMP/jsp/DlauiInterfaceSearchResultImage.jsp'</script>";
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

		boolean isPatientExists = false;

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
				
			}
			else if(serach_mode != null && serach_mode.equalsIgnoreCase("S"))
			{
				
				tempQuery = DLAInterfaceUtil.getOracleDBQueryByName();
				
				isExistingPStmt = sqlServerConn.prepareStatement(tempQuery);
				isExistingPStmt.setString(1,first_name+"%");
				isExistingPStmt.setString(2,sur_name+"%");			
				search_type = "1";
				req_search = first_name+sur_name;
				
			}

			isExistingRSet = isExistingPStmt.executeQuery();
			
			if(isExistingRSet.next())
			{
				
				isPatientExists = true;	
				isFromOracleDB = true;
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
		return isPatientExists;
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

		
			if(oraConnection == null) oraConnection = ConnectionManager.getConnection();
			oraclecallablestatement = oraConnection.prepareCall("{call XHINTERACTIVE.Interactive_interfac_audit(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			oraclecallablestatement.setString(1,mode);
			oraclecallablestatement.registerOutParameter(2,java.sql.Types.VARCHAR);
			oraclecallablestatement.registerOutParameter(3,java.sql.Types.VARCHAR);
			oraclecallablestatement.setString(4,user_name);
			oraclecallablestatement.setString(5,machineName);
			oraclecallablestatement.setString(6,machineName);
			oraclecallablestatement.setString(7,"DLASearch");
			oraclecallablestatement.setString(8,"MP");
			java.util.Date d = new java.util.Date();			
			oraclecallablestatement.setString(9,String.valueOf(session.getId()));
			oraclecallablestatement.setDate(10,new java.sql.Date(d.getTime()));
			oraclecallablestatement.setString(11,requestText);
			oraclecallablestatement.setString(12,"DLA");
			oraclecallablestatement.setString(13,String.valueOf(getSequenceNumber("SELECT XH_DLA_INTERFACE_SEQ.nextVal FROM dual")));
			oraclecallablestatement.setString(14,facilityId);
			oraclecallablestatement.setDate(15,new java.sql.Date(d.getTime()));
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
			oraclecallablestatement.setDate(27,new java.sql.Date(d.getTime()));
			oraclecallablestatement.setString(28,added_by_id);
			oraclecallablestatement.setDate(29,new java.sql.Date(d.getTime()));
			oraclecallablestatement.setString(30,machineName);
			oraclecallablestatement.setString(31,facilityId);
			oraclecallablestatement.setString(32,machineName);
			oraclecallablestatement.setString(33,facilityId);
			
			oraclecallablestatement.setInt(34,seqNo);
			oraclecallablestatement.setString(35,responseText);
			oraclecallablestatement.setString(36,responseSyntax);
			oraclecallablestatement.setString(37,"DLAP");

			oraclecallablestatement.execute();

		/*	String errorCode = oraclecallablestatement.getString(2);
			String errorMessage = oraclecallablestatement.getString(3);				
		*/
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
			requestText.append(pass_word+field_seperator);
			requestText.append(field_seperator);
			requestText.append(new java.util.Date()+field_seperator);
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
			requestSyntax.append("req_password"+field_seperator);
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
		String searchQuery = "SELECT * FROM patient WHERE ";

		ArrayList attributeList = null; 
		sqlServerConn = null;

		try
		{
			if(symbols == null)	symbols = (ArrayList)DLAInterfaceUtil.getMessageDelimiters();

			field_seperator = (String)symbols.get(4);

			requestText = new StringBuffer();

			sqlServerConn = DLAInterfaceUtil.getConnection(getServletContext().getRealPath("/")+"WEB-INF/CLASSES/eMP/");

			if(serach_mode != null && serach_mode.equalsIgnoreCase("N"))
			{
				
				
				searchQuery = searchQuery+"pid=?";

				

				isExistingPStmt = sqlServerConn.prepareStatement(searchQuery);
				isExistingPStmt.setString(1,national_id_name);			
				search_type = "0";
				req_search = national_id_name;

				
			}
			else if(serach_mode != null && serach_mode.equalsIgnoreCase("S"))
			{
				

				searchQuery = searchQuery+"fname LIKE ? AND lname LIKE ?";

				
				isExistingPStmt = sqlServerConn.prepareStatement(searchQuery);
				isExistingPStmt.setString(1,first_name+"%");
				isExistingPStmt.setString(2,sur_name+"%");			
				search_type = "1";
				req_search = first_name+sur_name;

				
			}

			isExistingRSet = isExistingPStmt.executeQuery();

			responseText = new StringBuffer();			

			if(isExistingRSet.next())
			{
				responseText.append((String)symbols.get(0));
				responseText.append((String)symbols.get(2));
				responseText.append(isExistingRSet.getString("req_comp_name")+field_seperator);
				responseText.append(isExistingRSet.getString("pid")+field_seperator);
				responseText.append(isExistingRSet.getString("title")+field_seperator);
				responseText.append(isExistingRSet.getString("si_title_code")+field_seperator);
				responseText.append(isExistingRSet.getString("si_prefix_code")+field_seperator);
				responseText.append(isExistingRSet.getString("fname")+field_seperator);
				responseText.append(isExistingRSet.getString("lname")+field_seperator);
				responseText.append(isExistingRSet.getString("si_patient_name")+field_seperator);
				responseText.append(isExistingRSet.getString("dob")+field_seperator);
				responseText.append(isExistingRSet.getString("sex")+field_seperator);
				responseText.append(isExistingRSet.getString("si_sex")+field_seperator);
				responseText.append(isExistingRSet.getString("nat")+field_seperator);
				responseText.append(isExistingRSet.getString("si_nat")+field_seperator);
				responseText.append(isExistingRSet.getString("ffname")+field_seperator);
				responseText.append(isExistingRSet.getString("fpid")+field_seperator);
				responseText.append(isExistingRSet.getString("si_father_name")+field_seperator);
				responseText.append(isExistingRSet.getString("mfname")+field_seperator);
				responseText.append(isExistingRSet.getString("mpid")+field_seperator);
				responseText.append(isExistingRSet.getString("si_mother_name")+field_seperator);
				responseText.append(isExistingRSet.getString("hdesc")+field_seperator);
				responseText.append(isExistingRSet.getString("si_present_address")+field_seperator);
				responseText.append(isExistingRSet.getString("si_prov_code")+field_seperator);
				responseText.append("IMAGE"+field_seperator);
				responseText.append(isExistingRSet.getString("imgtxt")+field_seperator);
				responseText.append(isExistingRSet.getString("imgsize")+field_seperator);
				responseText.append(isExistingRSet.getString("dead_status")+field_seperator);
				responseText.append(isExistingRSet.getString("dead_discharge")+field_seperator);
				responseText.append((String)symbols.get(3));
				responseText.append((String)symbols.get(1));
			}

				

			responseSyntax = new StringBuffer();

			responseSyntax.append((String)symbols.get(0));
			responseSyntax.append((String)symbols.get(2));
			responseSyntax.append("req_comp_name"+field_seperator);
			responseSyntax.append("pid"+field_seperator);
			responseSyntax.append("title"+field_seperator);
			responseSyntax.append("si_title_code"+field_seperator);
			responseSyntax.append("si_prefix_code"+field_seperator);
			responseSyntax.append("fname"+field_seperator);
			responseSyntax.append("lname"+field_seperator);
			responseSyntax.append("si_patient_name"+field_seperator);
			responseSyntax.append("dob"+field_seperator);
			responseSyntax.append("sex"+field_seperator);
			responseSyntax.append("si_sex"+field_seperator);
			responseSyntax.append("nat"+field_seperator);
			responseSyntax.append("si_nat"+field_seperator);
			responseSyntax.append("ffname"+field_seperator);
			responseSyntax.append("fpid"+field_seperator);
			responseSyntax.append("si_father_name"+field_seperator);
			responseSyntax.append("mfname"+field_seperator);
			responseSyntax.append("mpid"+field_seperator);
			responseSyntax.append("si_mother_name"+field_seperator);
			responseSyntax.append("hdesc"+field_seperator);
			responseSyntax.append("si_present_address"+field_seperator);
			responseSyntax.append("si_prov_code"+field_seperator);
			responseSyntax.append("img"+field_seperator);
			responseSyntax.append("imgtxt"+field_seperator);
			responseSyntax.append("imgsize"+field_seperator);
			responseSyntax.append("dead_status"+field_seperator);
			responseSyntax.append("dead_discharge"+field_seperator);
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
	
	public String getRecordCount(String firstName,String lastName,boolean isFromOracleDB,String machineName,String dateTime)
	{
		String searchQuery = "";
		String code = null; 

		Connection sqlServerConn = null;
		PreparedStatement isExistingPStmt = null;
		ResultSet isExistingRSet = null;

		try
		{
			if(isFromOracleDB) 
			{
				sqlServerConn = ConnectionManager.getConnection();
				searchQuery = DLAInterfaceUtil.getOracleDBQueryByName();
			}
			else 
			{
				sqlServerConn = DLAInterfaceUtil.getConnection(session.getServletContext().getRealPath("/")+"WEB-INF/CLASSES/eMP/");
				searchQuery = DLAInterfaceUtil.getSqlDBSearchByName();
			}

		/*	
			isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			isExistingPStmt.setString(1,machineName+"/"+dateTime+"%");
			isExistingPStmt.setString(2,first_name+"%");
			isExistingPStmt.setString(3,sur_name+"%");									
		*/
			boolean flag = false;
			if(first_name != null && !first_name.equalsIgnoreCase(""))
			{
				flag = true;
				searchQuery = searchQuery+" fname LIKE ?";
			}
			if(sur_name != null && !sur_name.equalsIgnoreCase(""))
			{
				if(flag)
				{
					searchQuery = searchQuery+" AND lname LIKE ?";
					isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					isExistingPStmt.setString(1,machineName+"/"+dateTime+"%");
					isExistingPStmt.setString(2,first_name+"%");
					isExistingPStmt.setString(3,sur_name+"%");
				}
				else
				{
					searchQuery = searchQuery+" lname LIKE ?";
					isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					isExistingPStmt.setString(1,machineName+"/"+dateTime+"%");					
					isExistingPStmt.setString(2,sur_name+"%");
				}
			}
			else
			{
				isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				isExistingPStmt.setString(1,machineName+"/"+dateTime+"%");					
				isExistingPStmt.setString(2,first_name+"%");
			}
		
			
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
				if(sqlServerConn != null)
				{
					if(isFromOracleDB) ConnectionManager.returnConnection(sqlServerConn);
					else sqlServerConn.close();
				}
			}
			catch(Exception exp)
			{
				exp.printStackTrace(System.err);
			}
		}

		return code;
	}	
}
