<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%@ page import="java.sql.*,java.io.*,java.net.*,java.util.*,eXH.*,webbeans.eCommon.*,javax.servlet.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
		

	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
		<title>Malaffi Portal</title>		
		<link rel="StyleSheet" href="../../eCommon/html/<%=sStyle%>" type="text/css" />
		<style>			
			#panel {
			  display: none;
			}
		</style>
		
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
	</head>
	<%

		StringBuffer samlData = new StringBuffer();		
		String httpSql = "", profileSql = "", practSql = "", paramString = "", protocolLinkID = "", l_app_msg = "", samlAssertion = "";
		String errorCode = "", errorMsg = "", responseTxt = "", l_return_resp = "", l_response_msg = "", strException = "Exception in";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null, pstmt = null;
		CallableStatement cstmt = null;	
		
		boolean isDebugYN = false;
		
		String l_url = "http://130.78.97.167:8080/EM/saml/s1/TransRequest";
		String l_http_content_type = "text/plain";
		String l_http_user_agent = "";
		String l_http_transfer_encoding = "";
		String l_http_soapaction = "", l_standard_code = "";
		int l_http_content_length_flag  = 0;

		String l_proxy_server="", l_proxy_port="", l_profile_url = "", l_profile_id = "", l_practitioner_id = "", l_patient_id = "";

		HttpURLConnection conn = null;


		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");
		String facilityId	= (String)session.getValue("facility_id");	
		
		String SegmentID = "PWEB", ElementID = "", StandardCode = "MLFIHL725";

		String l_first_name="", l_last_name="", l_full_name="", l_email_address="", l_phone="", l_gender="", l_apc_no="",l_pract_type="", l_subject_role="";

		String l_pat_first_name="", l_pat_second_name="", l_pat_third_name="", l_pat_full_name="", l_user_id = "";

		String disabledFlag = "";


		try {

			isDebugYN = (XHUtil.singleParamExeQry("SELECT NVL(DEBUG_YN,'N') DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;
			
			System.out.println("***Inside Invoke External Application - isDebugYN... " +isDebugYN);
			
			paramString = request.getParameter("dataElements")==null?"":request.getParameter("dataElements");
			l_app_msg = " Setting paramString... "+paramString;
			if (isDebugYN) System.out.println(l_app_msg);

			l_patient_id = FieldValueFetchMethod(paramString, "<PATIENT_ID>", "$!^", isDebugYN);
			l_app_msg = "Fetching Patient Details... "+l_patient_id;
			if (isDebugYN) System.out.println(l_app_msg);

			try {

				con = ConnectionManager.getConnection(request);

				practSql = "Select patient_id, NAME_PREFIX, FIRST_NAME, SECOND_NAME, THIRD_NAME, PATIENT_NAME from mp_patient where patient_id = ?";

				pstmt = con.prepareStatement(practSql);
				pstmt.setString(1, l_patient_id);			
				rs = pstmt.executeQuery();
				if (rs!=null){ 
					while(rs.next())
					{
					   l_pat_first_name = rs.getString("FIRST_NAME");
					   l_pat_second_name = rs.getString("SECOND_NAME");
					   l_pat_third_name = rs.getString("THIRD_NAME");
					   l_pat_full_name = rs.getString("PATIENT_NAME");
					  
					}

					rs = null;
				}

				l_app_msg = " ::: Patient First Name : "+ l_pat_first_name + " ::: Second Name : " + l_pat_second_name + " ::: Full Name : "+ l_pat_full_name;
				if (isDebugYN) System.out.println(l_app_msg);	

				pstmt = null;
			}
			catch(Exception e)
			{
				out.println("<h3> Exception in fetching the Patient Details : "+e.toString());
				errorMsg = "Exception in fetching the Patient Details : "+e.toString();
				e.printStackTrace();
			}
			finally{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}

			l_practitioner_id = FieldValueFetchMethod(paramString, "<PRACTITIONER_ID>", "$!^", isDebugYN);

			l_app_msg = "Practitioner ID... "+l_practitioner_id;
			if (isDebugYN) System.out.println(l_app_msg);

			l_user_id = FieldValueFetchMethod(paramString, "<USER_NAME>", "$!^", isDebugYN);

			l_app_msg = "Fetching User ID... "+l_user_id;
			if (isDebugYN) System.out.println(l_app_msg);

			/*

			if (!(l_practitioner_id.length()>0))
				l_practitioner_id = l_user_id;

			*/

			l_app_msg = "Fetching User Details... "+l_user_id;
			if (isDebugYN) System.out.println(l_app_msg);

			try {

				con = ConnectionManager.getConnection(request);

				practSql = "Select PRACTITIONER_ID, PRACTITIONER_NAME, NVL(EMAIL_ID,'') EMAIL_ID, NVL(OFF_TEL_NUM,'') OFF_TEL_NUM, GENDER, NVL(APC_NO,'') APC_NO, PRACT_TYPE From XH_EM_USERS_VW Where PRACTITIONER_ID=?";

				pstmt = con.prepareStatement(practSql);
				pstmt.setString(1, l_user_id);			
				rs = pstmt.executeQuery();

				l_app_msg = "User Details RS... "+rs;
				if (isDebugYN) System.out.println(l_app_msg);

				if (rs!=null){ 
					while(rs.next())
					{
					   l_first_name = rs.getString("PRACTITIONER_NAME");
					   l_last_name = rs.getString("PRACTITIONER_NAME");
					   l_full_name = rs.getString("PRACTITIONER_NAME");
					   l_email_address = rs.getString("EMAIL_ID");
					   l_phone = rs.getString("OFF_TEL_NUM");
					   l_gender = rs.getString("GENDER");
					   l_apc_no = rs.getString("APC_NO");
					   l_pract_type=rs.getString("PRACT_TYPE");
					}

					rs = null;
				}

				if (!(l_first_name.length()>0))				
					errorMsg = "User Details not available for the user id : "+l_practitioner_id;
				
				l_app_msg = " ::: First Name : "+ l_first_name + " ::: Last Name : " + l_last_name + " ::: Full Name : "+ l_full_name + " ::: Email Address : "+l_email_address+ " ::: Phone Number : "+ l_phone + " ::: Gender : " + l_gender + " ::: License No : "+ l_apc_no + " ::: Practitioner Type : "+l_pract_type;
				if (isDebugYN) System.out.println(l_app_msg);	

				pstmt = null;
			}
			catch(Exception e)
			{
				out.println("<h3> Exception in fetching the Practitioner Details : "+e.toString());
				errorMsg = "Exception in fetching the Practitioner Details : "+e.toString();
				e.printStackTrace();
			}
			finally{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}

			protocolLinkID = request.getParameter("protocolLinkId")==null?"":request.getParameter("protocolLinkId");
			l_app_msg = " Setting Protocol Link Id... "+protocolLinkID;
			if (isDebugYN) System.out.println(l_app_msg);

			if (l_pract_type.length()>0)
				l_subject_role = FetchSubjRoleMethod(l_pract_type, request, isDebugYN);			

			l_app_msg = "Error Message... "+errorMsg;
			if (isDebugYN) System.out.println(l_app_msg);

			if (l_subject_role.indexOf(strException) > 0)
				errorMsg = l_subject_role;	
			
			l_app_msg = " **************** User Name : "+ l_last_name + " *** Subject Role : "+l_subject_role+ " *** Subject Role Length : "+l_subject_role.length();
			if (isDebugYN) System.out.println(l_app_msg);	


			if (l_subject_role!=null && l_subject_role.length() > 0)
			{			
				disabledFlag = "";

				try
				{

					l_app_msg = " Fetching the EM Web Service URL... WEBURL... ";
					if (isDebugYN) System.out.println(l_app_msg);
					ElementID = "WEBURL";
					l_url = getHTTPValues(StandardCode, SegmentID, ElementID, request, isDebugYN);
					if (l_url.indexOf(strException) > 0)
						errorMsg = l_url;

					l_app_msg = " Fetching the EM Web Service URL... WEBURL... "+l_url;
					if (isDebugYN) System.out.println(l_app_msg);

					l_app_msg = " Fetching the EM Web Service Content Type... HTTP_CONTENT_TYPE... ";
					if (isDebugYN) System.out.println(l_app_msg);
					ElementID = "HTTP_CONTENT_TYPE";
					l_http_content_type = getHTTPValues(StandardCode, SegmentID, ElementID, request, isDebugYN);
					if (l_http_content_type.indexOf(strException) > 0)
						errorMsg = l_http_content_type;

					l_app_msg = " Fetching the EM Web Service URL... HTTP_CONTENT_TYPE... "+l_http_content_type;
					if (isDebugYN) System.out.println(l_app_msg);

					l_app_msg = " Fetching the EM Web Service Content Type... HTTP_PROXY_SERVER... ";
					if (isDebugYN) System.out.println(l_app_msg);
					ElementID = "HTTP_PROXY_SERVER";
					l_proxy_server = getHTTPValues(StandardCode, SegmentID, ElementID, request, isDebugYN);
					if (l_proxy_server.indexOf(strException) > 0)
						errorMsg = l_proxy_server;

					l_app_msg = " Fetching the EM Web Service URL... HTTP_PROXY_SERVER... "+l_proxy_server;
					if (isDebugYN) System.out.println(l_app_msg);

					l_app_msg = " Fetching the EM Web Service Content Type... HTTP_PROXY_PORT... ";
					if (isDebugYN) System.out.println(l_app_msg);
					ElementID = "HTTP_PROXY_PORT";
					l_proxy_port = getHTTPValues(StandardCode, SegmentID, ElementID, request, isDebugYN);
					if (l_proxy_port.indexOf(strException) > 0)
						errorMsg = l_proxy_port;

					l_app_msg = " Fetching the EM Web Service URL... HTTP_PROXY_PORT... "+l_proxy_port;
					if (isDebugYN) System.out.println(l_app_msg);
					
					l_app_msg = " Setting URL... "+l_url;
					if (isDebugYN) System.out.println(l_app_msg);

					URL url = new URL(l_url);			

					if (l_proxy_server.length()>0 && !l_proxy_server.equals("X"))
					{
						l_app_msg = " Setting http Proxy... "+l_proxy_server;
						if (isDebugYN) System.out.println(l_app_msg);

						System.setProperty("http.proxyHost", l_proxy_server);
						System.setProperty("https.proxyHost", l_proxy_server);
					}

					if (l_proxy_port.length()>0  && !l_proxy_server.equals("X"))
					{
						l_app_msg = " Setting http port... "+l_proxy_port;
						if (isDebugYN) System.out.println(l_app_msg);

						System.setProperty("http.proxyPort", l_proxy_port);       
						System.setProperty("https.proxyPort", l_proxy_port);

					}			 

					l_app_msg = " URL Open Connection...";
					if (isDebugYN) System.out.println(l_app_msg);	

					conn = (HttpURLConnection) url.openConnection();

					l_app_msg = " Connection Set Method... POST";
					if (isDebugYN) System.out.println(l_app_msg);	

					conn.setRequestMethod("POST");
					
					// Common Headers for Pancard Transactions
					
					if (l_http_content_type.length()>0  && !(l_http_content_type.equals("XXX")))
					{
						l_app_msg = " Set Property Content-Type... "+l_http_content_type;
						if (isDebugYN) System.out.println(l_app_msg);	
						conn.setRequestProperty("Content-Type", l_http_content_type);
					}			
					
					l_app_msg = " conn.setUseCaches(false)...";
					if (isDebugYN) System.out.println(l_app_msg);	
					
					conn.setUseCaches(false);
					
					//java certificate location
					//String certificatesTrustStorePath = "%JAVA_HOME%/jre/lib/security/cacerts";
					//System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);

					l_app_msg = " Set DoOutput(true)...";
					if (isDebugYN) System.out.println(l_app_msg);	
					conn.setDoOutput(true);

					l_app_msg = " Writing the request to the OutputStream...";
					if (isDebugYN) System.out.println(l_app_msg);	

					OutputStream os = conn.getOutputStream();
					os.write(paramString.getBytes());
					os.flush();

					l_app_msg = " Reading the response from the OutputStream...";
					if (isDebugYN) System.out.println(l_app_msg);	
					
					InputStream is;
					try{
						is = conn.getInputStream();
					}catch(Exception e){
						is = conn.getErrorStream();
					}

					BufferedReader br = new BufferedReader(new InputStreamReader((is)));

					l_app_msg = " Output from Server .... \n";
					if (isDebugYN) System.out.println(l_app_msg);	

					while ((l_response_msg = br.readLine()) != null) {
						l_return_resp = l_return_resp + l_response_msg;
						//l_app_msg = " Output Received from Server..."+l_return_resp;
						//if (isDebugYN) System.out.println(l_app_msg);
					}
					
					conn.disconnect();
					
				}
				catch (MalformedURLException e) 
				{
					e.printStackTrace();
					errorMsg = "MalformedURLException in accessing EM Web Service : "+  e.getMessage();
					System.out.println(" ::: MalformedURLException ::: " +errorMsg);
					
					l_return_resp = errorMsg;
					out.println("<h3>"+l_return_resp);
					
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
					errorMsg = "IOException in accessing the EM Web Service : " +  e.getMessage();
					System.out.println(" ::: IOException ::: " +errorMsg);
					
					l_return_resp = errorMsg;
					out.println("<h3>"+l_return_resp);
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					errorMsg = "Exception in accessing EM Web Service : " +  e.getMessage();
					System.out.println(" ::: Exception ::: " +errorMsg);

					l_return_resp = errorMsg;
					out.println("<h3>"+l_return_resp);
					
				}		
			}
			l_app_msg = " Response Returned : \n "+l_return_resp;
			if (isDebugYN) System.out.println(l_app_msg);
			
			if (!(l_return_resp.length()>0) && !(errorMsg.length()>0))
				errorMsg = "Error in generating the SAML Response...";
			else
				errorMsg = errorMsg;


			l_app_msg = "Fetching Malaffi Portal URL... Protocol Link Id... "+protocolLinkID;
			if (isDebugYN) System.out.println(l_app_msg);	

			try {

				con = ConnectionManager.getConnection(request);

				profileSql = "SELECT    nvl(profile_id,'') profile_id, nvl(xml_style_sheet_url, '') xml_style_sheet_url, nvl(standard_code,'') standard_code, "
						+ " nvl(http_user_agent,'XXX') http_user_agent, nvl(http_content_type, 'XXX') http_content_type, nvl(http_transfer_encoding, 'XXX') http_transfer_encoding, "
						+ " nvl(http_soapaction,'XXX') http_soapaction, nvl(http_content_length_flag,0)  http_content_length_flag "
			            + " FROM    xh_protocol a, xh_protocol_link b "
						+ " WHERE    a.protocol_id = b.protocol_id AND b.protocol_link_id = ? ";

				pstmt = con.prepareStatement(profileSql);
				pstmt.setString(1, protocolLinkID);			
				rs = pstmt.executeQuery();
				if (rs!=null){ 
					while(rs.next())
					{
					   l_profile_id = rs.getString("PROFILE_ID");
					   l_profile_url = rs.getString("XML_STYLE_SHEET_URL");
					   l_standard_code = rs.getString("STANDARD_CODE");
					   l_http_user_agent = rs.getString("HTTP_USER_AGENT");
					   l_http_content_type = rs.getString("HTTP_CONTENT_TYPE");
					   l_http_transfer_encoding = rs.getString("HTTP_TRANSFER_ENCODING");
					   l_http_soapaction = rs.getString("HTTP_SOAPACTION");
					   l_http_content_length_flag = rs.getInt("HTTP_CONTENT_LENGTH_FLAG");
					}

					rs = null;
				}

				l_app_msg = " ::: Profile ID : "+ l_profile_id + " ::: API URL : " + l_profile_url + " ::: Standard Code : "+ l_standard_code + " ::: HTTP User Agent : "+l_http_user_agent;
				if (isDebugYN) System.out.println(l_app_msg);	

				l_app_msg = " ::: HTTP Content Type : "+ l_http_content_type + " ::: HTTP Transfer Encoding : " + l_http_transfer_encoding + " ::: HTTP Soap Action : "+ l_http_soapaction + " ::: HTTP Content Length Flag : "+l_http_content_length_flag;
				if (isDebugYN) System.out.println(l_app_msg);	

				pstmt = null;
			}
			catch(Exception e)
			{
				out.println("<h3> Exception in fetching the Malaffi URL : "+e.toString());
				e.printStackTrace();
				errorMsg = "Exception in fetching the Malaffi URL : "+ l_app_msg + " : " +  e.getMessage();
			}
			finally{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}

			/*

			con = ConnectionManager.getConnection(request);
			
			l_app_msg = "***Inside Show Malaffi Portal - Protocol Link ID : "+protocolLinkID;
			if (isDebugYN) System.out.println(l_app_msg);

			cstmt = con.prepareCall("{ CALL XHEMWEBSERVICE.EM_WEB_REQUEST(?,?,?,?,?) }" );
			cstmt.setString(1,protocolLinkID);
			cstmt.setString(2,paramString);
			cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			cstmt.execute();
			samlAssertion = cstmt.getString(3);
			errorCode = cstmt.getString(4);
			errorMsg = cstmt.getString(5);
			if(isDebugYN) 
				System.out.println(" Error Code : "+errorCode+" Error paramString : "+errorMsg+ " SAML Assertion ::: \n "+samlAssertion);

			if((errorMsg != null) && (errorMsg.trim().length()>0)) 
			{
				responseTxt=errorMsg;	
			}
			else
			{
				if(errorCode=="S" || "S".equalsIgnoreCase(errorCode))
				{
					 responseTxt=samlAssertion;
				}
				else
				{
					 responseTxt=samlAssertion;
				}
			}

			*/

		}
		catch(Exception e){
			errorMsg = "General Exception caught : "+ l_app_msg + " : " +  e.getMessage();
			out.println("<h3> General Exception caught : "+e.toString());
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}	

		/****
		1. Param string
		2. All code calls to EM web service , SAML will be generated
		3.

		4. Malaffi URL and HTTP Post
		*/
		
		l_app_msg = "Error Message... "+errorMsg;
		if (isDebugYN) System.out.println(l_app_msg);

		if (errorMsg.length() > 0)
		{
			disabledFlag = "DISABLED";
		}
	%>
	<body>
		<div id="panel">
            <p><b>Loading Details...</b></p>
		</div>
		<form name="malaffiForm" id="malaffiForm" id="malaffiForm" method="POST" action="<%=l_profile_url%>" >
			<input type="hidden" name="SAMLResponse" id="SAMLResponse" id="SAMLResponse" value="<%=l_return_resp%>"/>
			<input type="hidden" name="errorMsg" id="errorMsg" id="errorMsg" value="<%=errorMsg%>"/>

			<table cellpadding='3' cellspacing='0' align='left' width='350px' border='1' FRAME=BOX>
			<tr>
				<td colspan='6'><label nowrap style="font-size:9;font-weight:bold">Practitioner and Patient Details</label></td>
			</tr>			
			<tr>
				<td  class='label' style:bold ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>	
				<td><input class='textbox' type='textbox' id='practitionerid' name='practitionerid' id='practitionerid' value='<%=l_user_id%>' DISABLED></td>
				<td  class='label'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/>
				<td><input class='textbox' type='textbox' size='50' id='practitionername' name='practitionername' id='practitionername' value='<%=l_first_name%>' DISABLED></td>
				<td  class='label'>License Number</td>
				<td><input class='textbox' type='textbox' id='licenseno' name='licenseno' id='licenseno' value='<%=l_apc_no%>' DISABLED></td>
			</tr>			
			<tr>	
			   	<td  class='label'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td><input class='textbox' type='textbox' id='patientid' name='patientid' id='patientid' value='<%=l_patient_id%>' DISABLED></td>
				<td  class='label'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
				<td colspan='3'><input class='textbox' type='textbox' size='50' id='patientname' name='patientname' id='patientname' value='<%=l_pat_full_name%>' DISABLED></td>
	        </tr>					
			<tr>				
				<td align='right' colspan=6>
					<input class='button'  type="submit" name="submit" id="submit" value="Send SAML response to Malaffi" <%=disabledFlag%>>
				</td>
			</tr>
			<tr>	
				<td class='label' colspan=2>Error</td>
				<td align='right' colspan=4>
					<textarea id="error" name="error" rows="4" cols="75" <%=disabledFlag%>><%=errorMsg%></textarea> 
				</td>
			</tr>			
	   	</table>
		</br>

		<!--
	<iframe id="malaffi_target" name="malaffi_target" style="width:800px;height:600px;border:0px solid #fff;" onload="stopUpload()">   
    </iframe>

	-->

	</form>
		<!--<pre><%=l_return_resp%></pre>-->
	

	<%!
		String getHTTPValues(String StandardCode, String SegmentID, String ElementID, HttpServletRequest request, boolean isDebugYN)
		{
			String httpSql = "", defaultValue = "", l_app_msg = "", l_errorMsg = "";
			Connection con = null;
			ResultSet rs = null;
			PreparedStatement stmt = null;
			
			try {

				con = ConnectionManager.getConnection(request);

				httpSql = "select DEFAULT_VALUE from XH_STANDARD_CONTROL_SEG where STANDARD_CODE = ? and SEGMENT_ID = ? and ELEMENT_ID = ? ";
				
				l_app_msg = "***Inside Show Malaffi Portal - Standard Control Segment Query  : " +httpSql+ " Standard Code : " +StandardCode+ " Segment ID : " +SegmentID+ " Element ID : "+ ElementID;
				if (isDebugYN) System.out.println(l_app_msg);

				stmt=con.prepareStatement(httpSql);
				stmt.setString(1,StandardCode);
				stmt.setString(2,SegmentID);
				stmt.setString(3,ElementID);
				rs=stmt.executeQuery();

				if (rs!=null){

					while (rs.next())
					{
						defaultValue = rs.getString("DEFAULT_VALUE")==null?"":rs.getString("DEFAULT_VALUE");
					}

					l_app_msg = "***HTTP Values  : " +defaultValue;
					if (isDebugYN) System.out.println(l_app_msg);
					
					
					rs = null;
				}
				stmt = null;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				l_errorMsg = "Exception in fetching the Default Values : "+ l_app_msg + " : " +  e.getMessage();
				return l_errorMsg;
			}
			finally{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}	

			return defaultValue;
		}

		String FetchSubjRoleMethod(String practType, HttpServletRequest request, boolean isDebugYN)
		{
			String practRoleSql = "", practRole = "", l_app_msg = "", l_errorMsg = "";
			Connection con = null;
			ResultSet rs = null;
			PreparedStatement stmt = null;
			
			try {

				con = ConnectionManager.getConnection(request);

				practRoleSql = "SELECT EXT_PK_ID FROM XH_OTH_APPL_DATA_SKEY WHERE TABLE_ID = 'AM_PRACT_TYPE' AND APPLICATION_ID = 'MALAFFI' AND " + "PK_VALUE = ?";
				
				l_app_msg = "***Inside Show Malaffi Portal - FetchSubjRoleMethod  : " +practRoleSql+ " Practitioner Type : " +practType;
				if (isDebugYN) System.out.println(l_app_msg);

				stmt=con.prepareStatement(practRoleSql);
				stmt.setString(1,practType);
				rs=stmt.executeQuery();

				if (rs!=null){

					while (rs.next())
					{
						practRole = rs.getString("EXT_PK_ID")==null?"":rs.getString("EXT_PK_ID");
					}

					l_app_msg = "***Practitioner Role : " +practRole;
					if (isDebugYN) System.out.println(l_app_msg);
					
					
					rs = null;
				}
				stmt = null;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				l_errorMsg = "Exception in fetching the User Role Type : "+ l_app_msg + " : " +  e.getMessage();
				return l_errorMsg;
			}
			finally{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}	

			return practRole;
		}

		String FieldValueFetchMethod(String message, String identifier, String fieldSep, boolean isDebugYN)
		{
			String l_app_msg = "", l_field_value = "";	

			try
			{
				
				l_app_msg = " ::: Inside FieldValueFetchMethod ::: ";
				if (isDebugYN)  System.out.println(l_app_msg);	

				l_app_msg = " ::: Message : "+ message + " ::: Identifier : " + identifier;
				if (isDebugYN)  System.out.println(l_app_msg);				
				
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
			catch (Exception e)
			{
				l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
			}		

			l_app_msg = " ::: l_field_value ::: "+l_field_value;
			if (isDebugYN)  System.out.println(l_app_msg);

			return l_field_value;
		}
	%>
	<script>

		/*
			$(document).ready(function(){
				if (!( $("#errorMsg").val().length>0) && ($("#SAMLResponse").val().length>0))
				{
					startUpload();
					$("malaffiForm").submit();		
				}
			});
		*/

			
			function startUpload()
			{            
				//$("#panel").dialog("open");
				//$("panel").show();
				document.getElementById("panel").style.display = "block";
				
			} 

			function stopUpload()
			{            
				//$("#panel").dialog("close");
				//$("#panel").hide();
				document.getElementById("panel").style.display = "none";
			}
		</script>
	</body>
</html>

