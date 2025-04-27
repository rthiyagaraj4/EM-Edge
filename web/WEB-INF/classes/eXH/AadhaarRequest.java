/***************************************************************************************************************
 * Author   :   Prithvirajan. R
 * Desc     :	This class is used to invoke the external EGL application
 ***************************************************************************************************************/

package eXH;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Properties;

import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.io.OutputStream; 
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStream;
import java.io.DataOutputStream;
import webbeans.eCommon.ConnectionManager;

import java.io.ByteArrayInputStream; 
import java.io.StringReader;

import eXH.XHJSONUtil;

/**
 * Servlet implementation class InvokeEGLapplication
 */
public class AadhaarRequest extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	boolean isDebugYN = false; 

	//public static final String l_segment_id = "AAG";
	//public static final String l_standard_code = "AADHAARSTD";	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    { 
		String responseTxt=null;
		String l_call_type = "" ;
		//String request_id="", national_Id="", aadhar_id="", l_errmsg="", l_errcd="";
		String l_app_msg ="";
		               
		try
		{

			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;
			//String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));

			Map<String, String> reqParams = XHUtil.getRequestParams(request);
			
			l_call_type = reqParams.get("CallType").toString();

			l_app_msg = " ::: L_CALL_TYPE ::: " +l_call_type;
			if (isDebugYN) System.out.println(l_app_msg);

			if("GET_REQUEST_ID".equals(l_call_type)) 
			{
				responseTxt=eKYCGetRequestId();
				PrintWriter resp = response.getWriter();
				resp.write(responseTxt);
				resp.flush();
				resp.close();
			}

			if("GET_EKYC_FUNC_PARAM".equals(l_call_type)) 
			{
				responseTxt = XHUtil.FetchStdCntrlSegMethod("AAG", "KYC_FUNC_PARAM", "AADHAARSTD");	
				PrintWriter resp = response.getWriter();
				resp.write(responseTxt);
				resp.flush();
				resp.close();
			}

			if("VALIDATE".equals(l_call_type)) 
			{
				responseTxt=Validate(request,reqParams);
				PrintWriter resp = response.getWriter();
				resp.write(responseTxt);
				resp.flush();
				resp.close();
			}

			if("FETCHRESPONSE".equals(l_call_type)) 
			{
				responseTxt=fetchResponse(request,reqParams);
				PrintWriter resp = response.getWriter();
				resp.write(responseTxt);
				resp.flush();
				resp.close();
			}
			
		}
		catch (Exception exp) 
		{
			exp.printStackTrace(System.err);
		}
	}
	public String eKYCGetRequestId()
	{
		
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";  //String updateStmt = ""; 
		String requestid = "";String l_app_msg="";

		try
		{
			l_app_msg = " ::: Inside eKYCGetRequestId...";
			if(isDebugYN) System.out.println(l_app_msg);
			
			query = "Select XH_AADHAAR_TRANSNO_SEQ.NEXTVAL as nextval FROM DUAL" ;
			dbConn =  ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(query);
			
			l_app_msg = " ::: query : "+query;
			if(isDebugYN) System.out.println(l_app_msg);	

			rs = pstmt.executeQuery();
			while(rs.next())
			{
				if(rs.getString("nextval")!=null && rs.getString("nextval").length() > 0)
				{
					requestid = rs.getString("nextval");
				}
			}

			l_app_msg = " ::: requestid : "+requestid;
			if(isDebugYN) System.out.println(l_app_msg);	

		}
		catch(Exception e)
		{
			System.out.println(l_app_msg+ " ::: "+e.getMessage());
			e.printStackTrace(System.err);
		}	
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);			
		}
			
		return requestid;
	}

	public String InsertAadhaarRequest(HttpServletRequest request, String paramString){
		
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		HttpSession session; 
		java.util.Properties p;		
		java.sql.Timestamp l_current_date = null;	

		String l_app_msg = "", l_field_separator = "$!^";

		//String query = "", l_debug_YN = ""; 
		String l_insert_stmt = "";

		String l_facility_id = "", l_user_id = "", l_aadhaar_id = "", l_request_id = "", l_tenant_code = "", l_message = "";

		String client_ip_addr = "", facilityId = "", addedId = "";

		//String l_response_str = "";
		String l_errorcode="",l_errormsg="";
		
		int l_insert_count  =0;
	
		try
		{
			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			l_app_msg = " ::: Inside InsertAadhaarRequest...";
			if(isDebugYN) System.out.println(l_app_msg);

			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" );

			facilityId = (String) session.getValue("facility_id");

			l_app_msg = " ::: Login facilityId... "+facilityId;
			if(isDebugYN) 	System.out.println(l_app_msg);

			addedId = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
			
			l_app_msg = " ::: Login User ID... "+addedId;
			if(isDebugYN)	System.out.println(l_app_msg);

			client_ip_addr=	p.getProperty("client_ip_address");
			l_app_msg = " ::: Login Machine IP Address... "+client_ip_addr;
			if(isDebugYN)	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching FACILITY_ID... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_facility_id = FetchFieldValue(paramString, "<FACILITY_ID>", null, l_field_separator, "InsertAadhaarRequest");			
			l_app_msg = " ::: l_facility_id : "+l_facility_id;
			if(isDebugYN)	System.out.println(l_app_msg);

			if (!(l_facility_id.length()>0))
			{
				l_facility_id = facilityId;
			}

			l_app_msg = " ::: Fetching ADDED_BY_ID... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_user_id = FetchFieldValue(paramString, "<ADDED_BY_ID>", null, l_field_separator, "InsertAadhaarRequest");
			l_app_msg = " ::: l_user_id : "+l_user_id;
			if(isDebugYN)	System.out.println(l_app_msg);

			if (!(l_user_id.length()>0))
			{
				l_user_id = addedId;
			}

			l_app_msg = " ::: Fetching AADHAAR_NO... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_aadhaar_id = FetchFieldValue(paramString, "<AADHAAR_NO>", null, l_field_separator, "InsertAadhaarRequest");
			l_app_msg = " ::: l_aadhaar_id : "+l_aadhaar_id;
			//if(isDebugYN)	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching REQUEST_ID... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_request_id = FetchFieldValue(paramString, "<REQUEST_ID>", null, l_field_separator, "InsertAadhaarRequest");
			l_app_msg = " ::: l_request_id : "+l_request_id;
			if(isDebugYN)	System.out.println(l_app_msg);			

			l_app_msg = " ::: Fetching TENANT_CODE... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_tenant_code = FetchFieldValue(paramString, "<TENANT_CODE>", null, l_field_separator, "InsertAadhaarRequest");
			l_app_msg = " ::: l_tenant_code : "+l_tenant_code;
			//if(isDebugYN)	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching REQUEST_JSON... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_message = FetchFieldValue(paramString, "<REQUEST_JSON>", null, l_field_separator, "UpdateAadhaarRequest");
			l_app_msg = " ::: l_message : "+l_message;
			//if(isDebugYN)	System.out.println(l_app_msg);

			l_current_date = new java.sql.Timestamp(System.currentTimeMillis());
			l_app_msg = "::: Current Date : "+ l_current_date;
			if (isDebugYN) System.out.println(l_app_msg);
			
			dbConn =  ConnectionManager.getConnection();
			l_insert_stmt  = " INSERT INTO XH_TRANS_REQUEST (FACILITY_ID, USER_ID, TRANS_NO, REQUEST_ID, TENANT_CODE, REQUEST_JSON, "
							 +"	ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) "
							 +" VALUES (?, ?,app_password.encrypt (?), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			l_app_msg = " ::: l_insert_stmt : "+l_insert_stmt;
			//if(isDebugYN) System.out.println(l_app_msg);	

			pstmt = dbConn.prepareStatement(l_insert_stmt);					
			pstmt.setString(1, l_facility_id);
			pstmt.setString(2, l_user_id);
			pstmt.setString(3, l_aadhaar_id);					
			pstmt.setInt(4, Integer.parseInt(l_request_id));
			pstmt.setString(5, l_tenant_code);
			pstmt.setString(6, l_message);
			pstmt.setString(7, addedId);
			pstmt.setTimestamp(8,l_current_date);
			pstmt.setString(9, client_ip_addr);
			pstmt.setString(10, facilityId);
			pstmt.setString(11, addedId);
			pstmt.setTimestamp(12,l_current_date);
			pstmt.setString(13, client_ip_addr);
			pstmt.setString(14, facilityId);
			l_insert_count = pstmt.executeUpdate();

			l_app_msg = " ::: l_insert_count : "+l_insert_count;
			if(isDebugYN) System.out.println(l_app_msg);	

			if (l_insert_count == 1)
			{
				l_errorcode="S";
				l_errormsg="Successfully inserted transaction details.";

				dbConn.commit();
			}
			else
			{
				l_errorcode="E";
				l_errormsg="Error in inserting transaction details.";

				dbConn.rollback();
			}
					
		}
		catch(Exception e)
		{
			System.out.println(l_app_msg+ " ::: "+e.getMessage());
			l_errorcode="E";
			l_errormsg=e.getMessage();

			try{
				dbConn.rollback();
			}catch(Exception ee){
				ee.printStackTrace();
			}
			return l_errorcode+"$!^" +l_errormsg;
			
		}	
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);			
		}
		 return l_errorcode+"$!^" +l_errormsg;		
	}	 

	 public String UpdateAadhaarRequest(HttpServletRequest request, String paramString){
	
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String l_app_msg = "", l_field_separator = "$!^";

		HttpSession session; 
		java.util.Properties p;		
		java.sql.Timestamp l_current_date = null;	

		String query = ""; 
		//String l_debug_yn = "" ; String updateStmt = ""; String l_insert_stmt="";
		String l_uuid_id = "",l_hashdata = "" ,l_status="" , l_request_id="",l_tenant_code="", l_dt = "";
		//String l_request_json = "", l_request_status = "";
		String l_message="",l_response="";
		
		String client_ip_addr = "", facilityId = "", addedId = "";
		int l_update_count = 0;		


		try{

			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			l_app_msg = " ::: Inside UpdateAadhaarRequest...";
			if(isDebugYN) System.out.println(l_app_msg);

			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" );

			facilityId = (String) session.getValue("facility_id");

			l_app_msg = " ::: Login facilityId... "+facilityId;
			if(isDebugYN)	System.out.println(l_app_msg);

			addedId = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
			
			l_app_msg = " ::: Login User ID... "+addedId;
			if(isDebugYN)	System.out.println(l_app_msg);

			client_ip_addr=	p.getProperty("client_ip_address");
			l_app_msg = " ::: Login Machine IP Address... "+client_ip_addr;
			if(isDebugYN)	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching TENANT_CODE... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_tenant_code = FetchFieldValue(paramString, "<TENANT_CODE>", null, l_field_separator, "UpdateAadhaarRequest");			
			l_app_msg = " ::: l_tenant_code : "+l_tenant_code;
			//if(isDebugYN)	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching REQUEST_ID... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_request_id = FetchFieldValue(paramString, "<REQUEST_ID>", null, l_field_separator, "UpdateAadhaarRequest");
			l_app_msg = " ::: l_request_id : "+l_request_id;
			if(isDebugYN)	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching HASH_DATA... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_hashdata = FetchFieldValue(paramString, "<HASH_DATA>", null, l_field_separator, "UpdateAadhaarRequest");
			l_app_msg = " ::: l_hashdata : "+l_hashdata;
			if(isDebugYN)	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching UUID... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_uuid_id = FetchFieldValue(paramString, "<UUID>", null, l_field_separator, "UpdateAadhaarRequest");
			l_app_msg = " ::: l_uuid_id : "+l_uuid_id;
			if(isDebugYN)	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching STATUS... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_status = FetchFieldValue(paramString, "<STATUS>", null, l_field_separator, "UpdateAadhaarRequest");
			l_app_msg = " ::: l_status : "+l_status;
			if(isDebugYN)	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching DT... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_dt = FetchFieldValue(paramString, "<DT>", null, l_field_separator, "UpdateAadhaarRequest");
			l_app_msg = " ::: l_dt : "+l_dt;
			if(isDebugYN)	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching REQUEST_JSON... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_message = FetchFieldValue(paramString, "<REQUEST_JSON>", null, l_field_separator, "UpdateAadhaarRequest");
			l_app_msg = " ::: l_message : "+l_message;
			if(isDebugYN)	System.out.println(l_app_msg);


			l_app_msg = " ::: Fetching RESPONSE_JSON... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_response = FetchFieldValue(paramString, "<RESPONSE_JSON>", null, l_field_separator, "UpdateAadhaarRequest");
			l_app_msg = " ::: l_message : "+l_response;
			if(isDebugYN)	System.out.println(l_app_msg);

			l_current_date = new java.sql.Timestamp(System.currentTimeMillis());
			l_app_msg = "::: Current Date : "+ l_current_date;
			if (isDebugYN) System.out.println(l_app_msg);

			dbConn =  ConnectionManager.getConnection();

			query = "UPDATE XH_TRANS_REQUEST set TENANT_CODE = ?, HASH_ID = ?, UUID_ID = ?, STATUS = ?, DT = ?, REQUEST_JSON = ?, REQUEST_STATUS = ?,RESPONSE_JSON = ?, "
					+"	MODIFIED_BY_ID = ?, MODIFIED_DATE = ?, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where REQUEST_ID = ? ";

			pstmt=dbConn.prepareStatement(query);
			pstmt.setString(1,l_tenant_code);
			pstmt.setString(2,l_hashdata);
			pstmt.setString(3,l_uuid_id);		
			pstmt.setString(4,l_status);
			pstmt.setString(5,l_dt);
			pstmt.setString(6,l_message);
			pstmt.setString(7,"R");
			pstmt.setString(8,l_response);
			pstmt.setString(9,addedId);
			pstmt.setTimestamp(10,l_current_date);
			pstmt.setString(11,client_ip_addr);
			pstmt.setString(12,facilityId);
			pstmt.setLong(13, Long.parseLong(l_request_id));
			l_update_count = pstmt.executeUpdate();

			l_app_msg = " ::: l_update_count : "+l_update_count;
			if(isDebugYN) System.out.println(l_app_msg);	

			if (l_update_count == 1)
			{
				dbConn.commit();
			}
			else
			{
				dbConn.rollback();
			}

		}
		catch(Exception e)
		{
			System.out.println(l_app_msg+ " ::: "+e.getMessage());
			try{
				dbConn.rollback();
			}catch(Exception ee){
				ee.printStackTrace();
			}
			return "E";
		}			
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
		return "S";
	}

	public String UpdateAadhaarResponse(HttpServletRequest request, String paramString){
	
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String l_app_msg = "", l_field_separator = "$!^";

		HttpSession session; 
		java.util.Properties p;		
		java.sql.Timestamp l_current_date = null;	
		

		String query = ""; 
		//String l_debug_yn = "" ; 
		String updateStmt = ""; 
		//String l_insert_stmt="";
		//String l_uuid_id = "",l_hashdata = "" ;
		String l_status="" , l_request_id="";
		//String l_tenant_code="", l_dt = "",l_request_json = "", l_request_status = "",l_message="", l_element_id = "";

		//String l_column = "";
		
		//String client_ip_addr = "", facilityId = "", addedId = "";
		int l_update_count = 0;
		//java.sql.Clob  clob=null;
		String l_response="";

		//String l_in_JSON = "";
		String l_status_code = "", l_status_desc = "", l_status_message = "";
        String l_errcd = "S",l_errmsg = "";
		try{

			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			l_app_msg = " ::: Inside UpdateAadhaarResponse...";
			if(isDebugYN) System.out.println(l_app_msg);

			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" );

			/*
			facilityId = (String) session.getValue("facility_id");

			l_app_msg = " ::: Login facilityId... "+facilityId;
			if(isDebugYN)	System.out.println(l_app_msg);

			addedId = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
			
			l_app_msg = " ::: Login User ID... "+addedId;
			if(isDebugYN)	System.out.println(l_app_msg);

			client_ip_addr=	p.getProperty("client_ip_address");
			l_app_msg = " ::: Login Machine IP Address... "+client_ip_addr;
			if(isDebugYN)	System.out.println(l_app_msg);

			l_app_msg = " ::: Fetching TENANT_CODE... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_tenant_code = FetchFieldValue(paramString, "<TENANT_CODE>", null, l_field_separator, "UpdateAadhaarRequest");			
			l_app_msg = " ::: l_tenant_code : "+l_tenant_code;
			if(isDebugYN)	System.out.println(l_app_msg);
			*/

			l_app_msg = " ::: Fetching REQUEST_ID... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_request_id = FetchFieldValue(paramString, "<REQUEST_ID>", null, l_field_separator, "UpdateAadhaarResponse");
			l_app_msg = " ::: l_request_id : "+l_request_id;
			if(isDebugYN)	System.out.println(l_app_msg);
			
			l_app_msg = " ::: Fetching RESPONSE_JSON... ";
			if(isDebugYN)	System.out.println(l_app_msg);

			l_response = FetchFieldValue(paramString, "<RESPONSE_JSON>", null, l_field_separator, "UpdateAadhaarResponse");
			//l_app_msg = " ::: l_message : "+l_response;
			if(isDebugYN)	System.out.println(l_app_msg);	

			l_status = XHJSONUtil.getJsonRequestString(l_response, "status");
			
			l_app_msg = " ::: l_status_code : "+l_status_code;
			if (isDebugYN) System.out.println(l_app_msg);	
			
			l_status_code = XHJSONUtil.getJsonRequestString(l_response, "errorCode");
			l_status_desc = XHJSONUtil.getJsonRequestString(l_response, "errorMessage");

			l_status_message = l_status_code + " - " + l_status_desc;			

			l_app_msg = " ::: l_status_code : "+l_status_code+" ::: l_status_desc : "+l_status_desc+" ::: l_status_message : "+l_status_message;
			if (isDebugYN) System.out.println(l_app_msg);	
			
			if (!(l_status_code.equals("00")))
			{
				l_errcd = "E";
			}

			l_current_date = new java.sql.Timestamp(System.currentTimeMillis());
			l_app_msg = "::: Current Date : "+ l_current_date;
			if (isDebugYN) System.out.println(l_app_msg);

			StringReader reader = new StringReader(l_response);
			l_app_msg = "::: reader : "+ reader;
			if (isDebugYN) System.out.println(l_app_msg);

			l_app_msg = "::: l_response.length() : "+  l_response.length();
			if (isDebugYN) System.out.println(l_app_msg);

			dbConn = ConnectionManager.getConnection();


			query = "update XH_TRANS_REQUEST set RESPONSE_JSON = ?, REQUEST_STATUS = ?, STATUS = ?, STATUS_DESC = ? where REQUEST_ID = ? ";

			l_app_msg = "::: COnnection ::: "+dbConn;
			if (isDebugYN) System.out.println(l_app_msg);

			pstmt=dbConn.prepareStatement(query);
			
			l_app_msg = "::: 1 ::: ";
			if (isDebugYN) System.out.println(l_app_msg);

			pstmt.setCharacterStream(1, reader, l_response.length());

			pstmt.setString(2,"U");

			pstmt.setString(3, l_status);

			pstmt.setString(4, l_status_message);

			l_app_msg = "::: 6 ::: ";
			if (isDebugYN) System.out.println(l_app_msg);

			pstmt.setLong(5, Long.parseLong(l_request_id));
			
			l_app_msg = "::: 7 ::: ";
			if (isDebugYN) System.out.println(l_app_msg);

			l_update_count = pstmt.executeUpdate();

			l_app_msg = " ::: l_update_count : "+l_update_count;
			if(isDebugYN) System.out.println(l_app_msg);	

			if (l_update_count == 1)
			{
				dbConn.commit();
			}
			else
			{
				dbConn.rollback();
				l_errcd = "E";
				l_errmsg = " Error in updating Transaction Records ";
			}			

			//dbConn =  ConnectionManager.getConnection();
			updateStmt = " UPDATE XH_INTERACTIVE_INTEGRATION "
							+" SET	response_text        = ?, "
							+" acknowledgment_text    = ?, "
							+" status            = ?, "
							+" error_text        = ? "
							+" WHERE MESSAGE_ID          = ? " 
								+" AND pgm_id = ? " ;

			pstmt = dbConn.prepareStatement(updateStmt);
			pstmt.setString(1, l_response);
			pstmt.setString(2, l_status_message);
			pstmt.setString(3, l_errcd);
			pstmt.setString(4, l_status_desc);
			pstmt.setString(5, l_request_id);
			pstmt.setString(6, "AADHAAR");
			l_update_count = pstmt.executeUpdate();

			l_app_msg = " ::: Update_Interactive_Count : "+l_update_count;
			if(isDebugYN) System.out.println(l_app_msg);	

			
			if (l_update_count == 1)
			{
				dbConn.commit();				
			}
			else
			{
				dbConn.rollback();	
				l_errcd = "E";
				l_errmsg = " Error in updating Interactive Integration Records ";				
			}	
			l_app_msg = " ::: l_errcd : "+l_errcd+" :: l_errmsg : "+l_errmsg;
			if(isDebugYN) System.out.println(l_app_msg);	

		}
		catch(Exception e)
		{
			System.out.println(l_app_msg+ " ::: "+e.getMessage());
			try{
				dbConn.rollback();
			}catch(Exception ee){
				ee.printStackTrace();
			}
			return "E";
		}			
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
		return "S";
	}


	public String FetchFieldValue(String message, String identifier, String standardCode, String fieldSep, String procID){

		String l_app_msg = "", l_field_value = "";
		//String l_app_key = "", 

		l_app_msg = " ::: Inside FetchFieldValue ::: ";
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Message : "+ message + " ::: Identifier : " + identifier + " ::: Standard Code : "+ standardCode;
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Deriving Field Value..."+identifier;
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			if(standardCode != null && !(standardCode.length()>0))
			{

			}
			else
			{
				if (message.indexOf(identifier) >= 0 )
				{
					if (message.indexOf(fieldSep) >= 0)
					{
						l_field_value = message.substring(message.indexOf(identifier)+identifier.length());
						if (l_field_value.indexOf(fieldSep) >= 0)
						{						
							l_field_value = l_field_value.substring(0, l_field_value.indexOf(fieldSep));
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}		

		l_app_msg = " ::: l_field_value ::: "+l_field_value;
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		return l_field_value;
	}	




	public String Validate(HttpServletRequest request,Map<String, String> reqParams)
	{
		
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";  //String updateStmt = ""; 
		String l_request_id = "";String l_app_msg="",l_status="",l_facility_id="",l_aadharno="",l_tenant_code="";
		String l_hash_id="",l_uuid="",l_dt="",l_request_json="",l_request_status="",l_response_json="";
		//FACILITY_ID, AADHAAR_NO, REQUEST_ID, TENANT_CODE, HASH_ID, UUID_ID, STATUS, DT, REQUEST_JSON, REQUEST_STATUS, RESPONSE_JSON
		String l_errorcode="S",l_errormsg="";
		int count=0;

		try
		{

			l_request_id = reqParams.get("request_id");
			l_app_msg = " ::: Inside validate...";
			if(isDebugYN) System.out.println(l_app_msg);
			query ="select REQUEST_ID, STATUS from XH_TRANS_REQUEST where ADDED_DATE < MODIFIED_DATE and REQUEST_ID=?";
			dbConn =  ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1,l_request_id);
			
			l_app_msg = " ::: query : "+query;
			if(isDebugYN) System.out.println(l_app_msg);	

			rs = pstmt.executeQuery();
			while(rs.next())
			{
					l_request_id = rs.getString("REQUEST_ID");
					l_status=rs.getString("STATUS");
					count++;
			}
			if(count>0){

				dbConn.close();

				l_app_msg = " ::: requestid : "+l_request_id;
				if(isDebugYN) System.out.println(l_app_msg);	

				if(l_status.equals("success"))
				{
					query ="select FACILITY_ID,TRANS_NO, REQUEST_ID, TENANT_CODE, HASH_ID, UUID_ID, STATUS, DT, REQUEST_JSON, REQUEST_STATUS, RESPONSE_JSON from XH_TRANS_REQUEST where REQUEST_ID=?";

					dbConn =  ConnectionManager.getConnection();
					pstmt = dbConn.prepareStatement(query);
					pstmt.setString(1,l_request_id);	
					rs = pstmt.executeQuery();
					while(rs.next())
					{	

						l_facility_id=rs.getString("FACILITY_ID");
						l_aadharno=rs.getString("TRANS_NO");
						l_tenant_code=rs.getString("TENANT_CODE");
						l_hash_id=rs.getString("HASH_ID");
						l_uuid=rs.getString("UUID_ID");
						l_dt=rs.getString("DT");
						l_request_json=rs.getString("REQUEST_JSON");
						l_request_status=rs.getString("REQUEST_STATUS");
						l_response_json=rs.getString("RESPONSE_JSON");
						l_request_id = rs.getString("REQUEST_ID");
						l_status=rs.getString("STATUS");
						
					}
					l_errorcode="S";
					l_errormsg="Sucessfully Validated Your adhar number";
				}
				else
				{
					l_errorcode="E";
					l_errormsg="Error in occured while validating EKYC";
				}
			}
			else
			{
				l_errorcode="W";
				l_errormsg="Wait";
			}
		}
		catch(Exception e)
		{
			System.out.println(l_app_msg+ " ::: "+e.getMessage());
			//e.printStackTrace(System.err);
			l_errorcode="E";
			l_errormsg="Exception..." +e.getMessage();

		}	
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);			
		}
			
		return l_errorcode+"$!^"+l_errormsg;
	}
    public String fetchResponse(HttpServletRequest request,Map<String, String> reqParams)
	{
		
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";  //String updateStmt = ""; 
		String l_request_id = "";String l_app_msg="",l_status="",l_facility_id="",l_aadharno="",l_tenant_code="";
		String l_hash_id="",l_uuid="",l_dt="",l_request_json="",l_request_status="",l_response_json="";
		//FACILITY_ID, AADHAAR_NO, REQUEST_ID, TENANT_CODE, HASH_ID, UUID_ID, STATUS, DT, REQUEST_JSON, REQUEST_STATUS, RESPONSE_JSON
		String l_errorcode = "S", l_errormsg = "";
		//int count=0;

		try
		{
			l_app_msg = " ::: Inside fetchResponse...";
			if(isDebugYN) System.out.println(l_app_msg);


			l_request_id = reqParams.get("request_id");
			l_app_msg = " ::: l_request_id : "+l_request_id;
			if(isDebugYN) System.out.println(l_app_msg);	

			l_aadharno = reqParams.get("aadhaar_id");
			l_app_msg = " ::: l_aadharno : "+l_aadharno;
			//if(isDebugYN) System.out.println(l_app_msg);	

			query ="select FACILITY_ID, REQUEST_ID, TENANT_CODE, HASH_ID, UUID_ID, STATUS, DT, REQUEST_JSON, REQUEST_STATUS, RESPONSE_JSON, STATUS_DESC from XH_TRANS_REQUEST where REQUEST_ID=? and TRANS_NO=app_password.encrypt (?)";

			dbConn =  ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1,l_request_id);
			pstmt.setString(2,l_aadharno);	

			rs = pstmt.executeQuery();
			while(rs.next())
			{	

				l_facility_id=rs.getString("FACILITY_ID");
				l_tenant_code=rs.getString("TENANT_CODE");
				l_hash_id=rs.getString("HASH_ID");
				l_uuid=rs.getString("UUID_ID");
				l_dt=rs.getString("DT");
				l_request_json=rs.getString("REQUEST_JSON");
				l_request_status=rs.getString("REQUEST_STATUS");
				l_response_json=rs.getString("RESPONSE_JSON");
				l_request_id = rs.getString("REQUEST_ID");
				l_status=rs.getString("STATUS");
				l_errormsg=rs.getString("STATUS_DESC");
				
			}
			l_errorcode="S";
		//	l_errormsg="Sucessfully Validated Your adhar number";
			l_errormsg= l_aadharno+"$!^"+l_response_json+"$!^"+l_request_id+"$!^"+l_status+"$!^"+l_errormsg;

		}

		catch(Exception e)
		{
			System.out.println(l_app_msg+ " ::: "+e.getMessage());
			//e.printStackTrace(System.err);
			l_errorcode="E";
			l_errormsg="Exception..." +e.getMessage();

		}	
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, dbConn);			
		}
			
		return l_errorcode+"$!^"+l_errormsg;	
	}
}