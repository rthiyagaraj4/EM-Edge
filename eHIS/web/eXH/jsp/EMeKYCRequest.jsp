<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.HashMap, java.util.ArrayList, webbeans.eCommon.ConnectionManager,java.util.*,com.ehis.util.*,eCommon.Common.*,eXH.InterfaceUtil,eXH.XHUtil, eXH.*,  java.util.Properties,java.util.StringTokenizer "%>
<%@ page contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Aadhaar Validation</title>
		<%String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eCommon/js/jquery-3.6.3.js'></script>
		<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eMP/js/PasInterface.js'></script>
		<script type="text/javascript">

			$(document).ready(function() {
				window.document.KDAHEKYC.submit();
				afterSubmit();

			});

			function afterSubmit()
			{
				var response;
				var aadharno;
				var response_json;
				var request_id;
				var status;

				var waittime = document.getElementById("WAITTIME").value;

				var timeoutseconds = waittime * 1000;

				setTimeout(function()
				{
					response = WaitingResponse();

					var responseMsg=response.split("$!^");
					if(responseMsg[0]=="W")
					{
						afterSubmit();
					}
					else if(responseMsg[0]=="S")
					{
						//alert(responseMsg[1]);
						window.returnValue="true";
						window.close();
					}
					else
					{
						alert(responseMsg[1]);
						window.returnValue = "false";
						window.close();
					}

				},timeoutseconds);

			}

			function WaitingResponse()
			{
				var responseMsg="";
				var data1 = true;
				var request_id = document.getElementById("REQUEST_ID").value;
				$.ajax({
					url: '../../servlet/eXH.AadhaarRequest',
					type: 'POST',
					cache: false,
					data: {
							CallType: 'VALIDATE',
							request_id:	request_id
						  
					}, 
					success: function (data1) {
						responseMsg = data1;
					},
					dataType: 'text',
					async: false
				});

			   return responseMsg;
			}

		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
			String sql="";
			String facilityId = "", addedId = "", l_aadhaar_no = "", l_request_id = "",err_cd="",err_msg="";
			String uuid = "";
			String[] data=null;
			Properties p;			

			String l_param_string = "", l_return_str = "";
			int l_wait_time=60;		
			
			request.setCharacterEncoding("UTF-8");
			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" );

			boolean isDebugYN = false; 
			String l_app_msg = "";
			
			String l_element_id = "REQUEST_URL";
			String l_segment_id = "AAG";
			String l_standard_code = "AADHAARSTD";
			String l_field_value = "http://ekyc.mobilewaretech.com:2080/KDAHEKYC/kyc";	

			Connection dbConn = null;
			ResultSet rs = null;
			Statement stmt=null;
			PreparedStatement pstmt = null;

			String query = "";

			try
			{
				
				dbConn = ConnectionManager.getConnection(request); 
				

				query = "SELECT NVL(DEFAULT_VALUE,'') DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG " 
							+ " WHERE SEGMENT_ID = ? and  STANDARD_CODE = ? "
							+ " AND ELEMENT_ID = ?";
						
				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, l_segment_id);
				pstmt.setString(2, l_standard_code);
				pstmt.setString(3, l_element_id);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
				   l_field_value = rs.getString("DEFAULT_VALUE");
				}

			}
			catch(Exception e)
			{
				System.out.println("Error in "+ l_app_msg + " : " +  e.getMessage());
			}
			finally
			{			
				XHUtil.closeDBResources(rs, pstmt, dbConn);
			}	


			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			facilityId = (String) session.getValue("facility_id");			
			l_app_msg = " ::: facilityId ::: "+facilityId;
			if (isDebugYN) System.out.println(l_app_msg);

			addedId = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
			l_app_msg = "::: addedId ::: "+addedId;
			if (isDebugYN) System.out.println(l_app_msg);

			l_aadhaar_no = request.getParameter("AADHAAR_NO");
			l_app_msg = "::: l_aadhaar_no ::: "+l_aadhaar_no;
			if (isDebugYN) System.out.println(l_app_msg);

			l_request_id = request.getParameter("REQUEST_ID");
			l_app_msg = "::: l_request_id ::: "+l_request_id;
			if (isDebugYN) System.out.println(l_app_msg);
			
			AadhaarRequest aadhaarReq = new AadhaarRequest();
			//l_request_id = aadhaarReq.eKYCGetRequestId();///Getting the sequence Id

			l_param_string = "<FACILITY_ID>"+facilityId+"$!^<ADDED_BY_ID>"+addedId+"$!^<AADHAAR_NO>"+l_aadhaar_no+"$!^<REQUEST_ID>"+l_request_id+"$!^";
			l_app_msg = " ::: l_param_string ::: "+l_param_string;
			//if (isDebugYN) System.out.println(l_app_msg);


			l_return_str = aadhaarReq.InsertAadhaarRequest(request, l_param_string);///inserting into the table

			l_app_msg = "::: l_return_str ::: "+l_return_str;
			if (isDebugYN) System.out.println(l_app_msg);
			
			int waittime = InterfaceUtil.getWaitTime("AADHAARPO");	
			l_app_msg = "::: AADHAAR Wait time ::: "+waittime;
			if (isDebugYN) System.out.println(l_app_msg);
			
			StringTokenizer token = new StringTokenizer(l_return_str, "$!^");
			String[] arr = new String[2];
			int i=0;
			while (token.hasMoreTokens()) {
				arr[i] = token.nextToken();
				i++;
			}
			err_cd = arr[0];
			err_msg = arr[1];

			l_app_msg = " ::: ERR_CD ::: "+err_cd+" ::: ERR_MSG ::: "+err_msg;
			if (isDebugYN) System.out.println(l_app_msg);
			
			if(err_cd.equals("E"))
			{
		%>		
				<script>
					alert("APP-002415 Error in Inserting Aadhaar Details.");
				</script>																						
		<% 
			}
			else
			{
		%>
	</head>
	<body>
		<div align="center" >
			<table cellspacing=0 cellpadding=3 width='100%' align=center>
			<tr><td align='center'> <img id='spinner' src='../images/ajax-loader.gif' style='visibility:visible'></img></td></tr>
			<tr>
				<td  align='center' class="label"><b>Aadhaar validation is currently being processed... Please wait...</b></br>
										Do not close this window...</br>
										This window will close automatically after completion of the validation.</td>
				
			</tr>	
			</table>
			
					
			<div align="center" style="width: 0px;height:0px">
				<!--<form name="KDAHEKYC" id="KDAHEKYC" action="http://ekyc.mobilewaretech.com:2080/KDAHEKYC/kyc" method="post">!-->
					<form name="KDAHEKYC" id="KDAHEKYC" action="<%=l_field_value%>" method="post">

					<fieldset>
					<input type="hidden" value=<%=l_aadhaar_no%> name="AADHAAR_NO"  id="AADHAAR_NO"></p>
					<input type="hidden" value=<%=l_request_id%> name="REQUEST_ID" id="REQUEST_ID"></p>
					<input type="hidden" value=<%=facilityId%> name="" id="EM_FACILITY_ID"></p>
					<input type="hidden" value=<%=addedId%> name="EM_USER_ID" id="EM_USER_ID"></p>
					<input type="hidden" value=<%=waittime%> name="WAITTIME" id="WAITTIME"></p>
					</fieldset>
				</form>
			</div>
		</div>
	</body>
		<%
			}
		%>
</html>

