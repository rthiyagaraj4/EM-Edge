<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page  import="eOT.*, eOT.Common.*,eCommon.Common.CommonBean,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"  %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/OtReports.js" ></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<title>
			<fmt:message key="eOT.ReportEmailReminderLetter.Label" bundle="${ot_labels}"/>
	</title>
<script language='javascript'>
// Invoke Mail Servlet
	function sendMail(){
		var formObj = document.BookingMailReportConfirmForm;	
		if(document.BookingMailReportConfirmForm.report_mail_opt[0].checked){
			var booking_num = formObj.booking_num.value;
			var facility_id = formObj.facility_id.value;
			var p_facility_id = formObj.p_facility_id.value;
			var p_user_id = formObj.p_user_id.value;
			var user_id = formObj.user_id.value;
			var p_user_name = formObj.p_user_name.value;
			var p_module_id = "OT";
			var p_report_id = "OTRREMLT";
			var pgm_id = "OTRREMLT";
			var no_of_mandatory_fields = "0";
			var no_of_compare_date_fields = "0";
			var no_of_comparison_fields = "0";
			var params="booking_num="+booking_num+"&facility_id="+facility_id+"&p_facility_id="+p_facility_id+"&p_user_id="+p_user_id+"&user_id="+user_id+"&p_user_name="+p_user_name+"&p_module_id=OT&p_report_id="+p_report_id+"&pgm_id="+pgm_id;

			// Call Reports
			formObj.action="../../eCommon/jsp/report_options.jsp?"+params;
		}else{
			// Send Email
			formObj.action="../../servlet/eOT.BookingMailServlet";
		}
		formObj.submit();	
		window.returnValue="";
		window.close();
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String booking_num		= request.getParameter("booking_num");
	String facility_id		= request.getParameter("facility_id");
//	String user_id			= request.getParameter("user_id");
	String user_id			= (String)session.getValue("login_user");
	String email_id         = "";

 	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

	String  sql_email = "SELECT EMAIL_ID FROM MP_PATIENT WHERE PATIENT_ID IN (SELECT PATIENT_ID FROM OT_BOOKING_HDR WHERE  BOOKING_NUM = '"+booking_num+"' AND OPERATING_FACILITY_ID = '"+facility_id+"')"; 

	try{
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement(sql_email);
	rst = pstmt.executeQuery();

		while(rst.next()){
		  email_id = rst.getString(1);
		}
	}
	catch(Exception e){
		System.err.println("Err Msg BookingMailReportConfirm.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}

	String email_id_disabled = "";
	email_id=email_id==null?"":email_id;
	email_id=email_id.equalsIgnoreCase("null")?"":email_id;
	if(email_id.equals(""))
		email_id_disabled = "disabled";

%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name="BookingMailReportConfirmForm" id="BookingMailReportConfirmForm" method="POST" target="messageFrame" action="../../eCommon/jsp/report_options.jsp">
<table  border=0 align="center" width='100%' cellpadding=3 cellspacing='0'>
<tr>
	<td class="label" width='25%'>
		<fmt:message key="Common.report.label" bundle="${common_labels}"/>
		<input type="radio" name="report_mail_opt" id="report_mail_opt" checked>
		<fmt:message key="Common.email.label" bundle="${common_labels}"/>
		<input type="radio" name="report_mail_opt" id="report_mail_opt" <%=email_id_disabled%>>
	</td>
</tr>
<tr>
	<td width='25%' class='button' align='right'>
		<input type="button" class="button" name= "btnOK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="sendMail()"></input>
		<input type="button" class="button" name= "btnCN" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="let dialogBody = parent.document.getElementById('dialog-body');dialogBody.contentWindow.returnValue ='false';const dialogTag = parent.document.getElementById('dialog_tag'); dialogTag.close();" ></input>
	</td>
</tr>
		</table>	
		<input type="hidden" name="booking_num" id="booking_num"	value="<%=booking_num%>"   >
		<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
		<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
		<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
		<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
		<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
		<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
		<input type="hidden" name="p_report_id" id="p_report_id" value="OTRREMLT">
		<input type="hidden" name="pgm_id" id="pgm_id" value="OTRREMLT">
	    <input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="0" disabled>
		<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="0" disabled>
		<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="0" disabled>
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

