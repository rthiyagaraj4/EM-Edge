<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eXH.InterfaceUtil,eXH.XHDBAdapter,java.text.*,java.io.*,java.net.*,javax.servlet.*"%>
<%@ page import="java.io.BufferedReader, java.io.InputStreamReader, java.io.OutputStream, java.net.HttpURLConnection, java.net.MalformedURLException, java.net.URL, java.io.InputStream, java.io.DataOutputStream" %>
<%@ page contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>	
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
		<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eCommon/js/jquery-3.6.3.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
		<%

		//http://localhost:8899/eHIS/eXH/jsp/EMKYCDetails.jsp?requestId=731418475004&uuid=3722398c-72fb-4bf1-a662-8611a1cb21b1&hash=f063f1205ec53b6f376f93057f5bd27011332db55385de5b05aefda1e3ccd430&status=success

			String hashData = "";
			String uuid = "";
			String status = "", requestId = "";
			
			request.setCharacterEncoding("UTF-8");
			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			hashData = request.getParameter("hash");
			uuid = request.getParameter("uuid");
			status = request.getParameter("status");
			requestId = request.getParameter("requestId");
			System.out.println(" ::: hashData ::: "+hashData);
			System.out.println(" ::: uuid  ::: "+uuid);
			System.out.println(" ::: status ::: "+status);
			System.out.println(" ::: Request id  ::: "+requestId);

			String eKYCUrl = "http://ekyc.mobilewaretech.com:2080/Ekyc-web/api/users/1.0/fetchekyc";

			String message = "", l_return_resp = "", l_response_msg = "";

			HttpURLConnection conn = null;

			try
			{
				message = "{ "
						  +"  \"tenantCode\": \"mbwareKDAKYC\", "
						  +"  \"requestId\": \""+requestId+"\","
						  +"  \"hash\": \""+hashData+"\","
						  +"  \"uuid\": \""+uuid+"\","
						  +"  \"status\": \""+status+"\","
						  +"  \"dt\":\"43215001\" "
						  +"}";

				System.out.println(" ::: Message ::: "+message);

				URL url = new URL(eKYCUrl);

				System.out.println(" ::: URL Open Connection ::: ");	

				conn = (HttpURLConnection) url.openConnection();

				System.out.println(" ::: Set Request Method POST ::: ");	

				conn.setRequestMethod("POST");
				
				System.out.println(" ::: Set Content Header : Content Type Application/json ::: ");

				conn.setRequestProperty("Content-Type", "Application/json");

				System.out.println(" ::: Set Content Header : Access Token ::: ");
				
				conn.setRequestProperty("Access-Token", "41fa498922a60d020f882e4b349a14cc");

				System.out.println(" ::: Set Content Header : Accept ::: ");
				
				conn.setRequestProperty("Accept", "Application/json");

				System.out.println(" ::: Set setUseCaches(false) ::: ");

				conn.setUseCaches(false);

				System.out.println(" ::: Set setDoOutput(true) ::: ");
				
				conn.setDoOutput(true);

				System.out.println(" ::: Writing the request to the OutputStream...");

				OutputStream os = conn.getOutputStream();
				os.write(message.getBytes());
				os.flush();

				System.out.println(" ::: Reading the response from the OutputStream...");
				
				InputStream is;
				try{
					is = conn.getInputStream();
				}catch(Exception e){
					is = conn.getErrorStream();
				}

				BufferedReader br = new BufferedReader(new InputStreamReader((is)));

				System.out.println(" ::: Output from Server .... \n");

				while ((l_response_msg = br.readLine()) != null) {
					l_return_resp = l_return_resp + l_response_msg;
					System.out.println(l_return_resp);
				}
				
				conn.disconnect();
				
			}
			catch (MalformedURLException e) 
			{
				System.out.println("Error in Malformed URL : " +  e.getMessage());
			} 
			catch (IOException e) 
			{
				System.out.println("Error in IO Exception : " +  e.getMessage());
			}
			catch(Exception e)
			{
				System.out.println("Error in Exception : " +  e.getMessage());
			}			
			
		%>
	</head>
	
	<body>	
		<form name="ekycform" id="ekycform">

		<p>
				Request Details : Hash <%=hashData %>
		</p>
		<p>
				Request Details : UUID <%=uuid %> 
		</p>
		<p>
				Request Details : Status <%=status %>
		</p>
		<p>
				Request Details : requestId <%=requestId %>
		</p>
		<p>
				Response Message :  <%=l_return_resp %>
		</p>
		<input type='hidden' name='hashData' id='hashData' value="<%=hashData%>" >
		<input type='hidden' name='uuid' id='uuid' value="<%=uuid%>" >
		<input type='hidden' name='status' id='status' value="<%=status%>" >
		<input type='hidden' name='requestId' id='requestId' value="<%=requestId%>" >

		</form>
	</body>
</html>

