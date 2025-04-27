<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.text.*,webbeans.eCommon.*" %>

<html>

<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	 -->
	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eOA/js/WaitListInvitation.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
</head>

<%
request.setCharacterEncoding("UTF-8");
	Connection con = null;
	String wait_list_status=request.getParameter("wait_list_status");
	if(wait_list_status==null)wait_list_status="";
	
	try{
	
			con = ConnectionManager.getConnection(request);



%>
		<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<form name='waitlistinvitetabs' id='waitlistinvitetabs' action='../../servlet/eOA.AppointmentWtListServlet' method='post' target='messageFrame'>
	<!-- 	<table name='waitlisttabs' id='waitlisttabs' width='100%' align='center' cellpadding='0' cellspacing='0' border='0'> -->
		<!-- <tr>
		<td width='95%' class='bodycolorfilled'>&nbsp;</td> -->
<!-- 			<%if(!wait_list_status.equals("I")) {%>
	<td align='right' ><input type='Button' class='button' name='invite' id='invite' value='Invite' onclick='invite_values()'></td>
		<%}else{%>
		<td align='right' ><input type='Button' class='button' disabled name='invite' id='invite' value='Invite' onclick='invite_values()'></td>
		<%}%>
	<!-- 	<%if(wait_list_status.equals("I")) {%>
	<td >&nbsp;&nbsp;<input type='Button' class='button' name='reprint' id='reprint' value='Reprint'></td>
		<%}else {%>
		<td >&nbsp;&nbsp;<input type='Button' class='button' disabled name='reprint' id='reprint' value='Reprint'></td>
	<%}%>	 -->
	
	<!-- <td align='right' >&nbsp;&nbsp<input type='Button' class='button' name='clear' id='clear' value='Clear' onclick='clear_val_tabs()'>&nbsp;&nbsp;</td>  -->

		
		<!-- </tr> -->
	<!-- 	</table> -->
			<input type='hidden' name='wait_list_value' id='wait_list_value' value=''>
			<input type='hidden' name='record_status' id='record_status' value=''>
			<input type='hidden' name='wait_date_value' id='wait_date_value' value=''>
			<input type='hidden' name='final_vals' id='final_vals' value=''>
			<input type='hidden' name='Operation' id='Operation' value='invitation'>
		</body>
	</html>


<%
	
}
catch(Exception es){
out.println(es);
}
finally{
	ConnectionManager.returnConnection(con,request);
}

%>

