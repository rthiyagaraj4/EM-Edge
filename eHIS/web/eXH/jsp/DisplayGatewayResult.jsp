<!DOCTYPE html>
<%@page import="java.util.*"%>
<html>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<head>
<%
	List<String> resultArrayList = new ArrayList<String>();
	String selectedCommuniMode = "";
	String resultMsg = "";
	String clientID="";
	String applicationID="";
	String facilityID="";
	String gatewayOperation = "refresh";
	resultArrayList = (List<String>) request
			.getAttribute("resultArrayList");
	if (resultArrayList != null) {
		
		for(int i=0;i<resultArrayList.size();i++)
		{
			resultMsg=resultMsg+resultArrayList.get(i);
		}
	}
System.out.println("final result...."+resultMsg);
	selectedCommuniMode = request.getParameter("selectedcommunimode");
	clientID = request.getParameter("serverclientid");
	applicationID = request.getParameter("application");
	facilityID = request.getParameter("facility");
	System.out.println("slecte com type..." + selectedCommuniMode);
	System.out.println("clientID com type..." + clientID);
	System.out.println("applicationID com type..." + applicationID);
	System.out.println("facilityID com type..." + facilityID);
	
%>
<script type="text/javascript" language="JAVASCRIPT"
	src="${pageContext.request.contextPath}/eCommon/js/jquery-3.6.3.js"></script>
<script Language="JavaScript" src="../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript">
function displayDialogMsg() {
	
		alert(" <%=resultMsg %>" );
document.forms[0].submit();
}
</script>
<Script src="../eCommon/js/showModalDialog.js" language="JavaScript"></Script>




</head>
<BODY CLASS="MESSAGE" onLoad="displayDialogMsg();"
	onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
	<form name="gatewaydisplayform" id="gatewaydisplayform"
		action="../servlet/eXH.CentralizedServlet" method="get">

		<input type="hidden" name="gatewayoperation" id="gatewayoperation" value="refresh"
			id="gatewayoperation"> <input type="hidden"
			name="selectedcommunimode" id="selectedcommunimode" value="<%=selectedCommuniMode%>">
			<input type="hidden"
			name="serverclientid" id="serverclientid" value="<%=clientID%>">
			<input type="hidden"
			name="application" id="application" value="<%=applicationID%>">
			<input type="hidden"
			name="facility" id="facility" value="<%=facilityID%>">
			
			<input type="hidden" name="frame" id="frame" value="body">

	</form>
</BODY>
</html>

