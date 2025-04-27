<!DOCTYPE html>
 <%@page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src='../../eOT/js/InstrumentCount.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
	String params		= request.getQueryString();
	String facility_id	= (String)session.getValue("facility_id");
	String booking_num	= request.getParameter("booking_num");
	String oper_num		= request.getParameter("oper_num");
	String patient_id	= request.getParameter("patient_id");
	String set_code		= request.getParameter("set_code");
	String oper_code	= request.getParameter("oper_code");
	String tray_num		= request.getParameter("tray_num");
	String row_num		= request.getParameter("row_num");

	booking_num	=booking_num==null?"":booking_num;
	booking_num	=booking_num.equalsIgnoreCase("null")?"":booking_num;
	oper_num	=oper_num==null?"":oper_num;
	oper_num	=oper_num.equalsIgnoreCase("null")?"":oper_num;
%>
<body  onKeyDown="lockKey()">
<form name="InstrumentCountItemConfirmForm" id="InstrumentCountItemConfirmForm" >
<table border='1' cellpadding=3  cellspacing='0' align='center'  width='100%' >
<tr>
	<td width="25%"  class='fields' colspan="3"> </td>
	<td width="25%" class='fields'>
		<input type="button" class="button" name="confirm" id="confirm" value='<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>' onclick="confirmItem()">
	</td>
</tr>		
</table>
	<input type="hidden" name="params" id="params" value="<%=params%>">	
	<input type="hidden" name="patient_id" id="patient_id"  value="<%=patient_id%>">
	<input type="hidden" name="booking_num" id="booking_num" value="<%=booking_num%>">
	<input type="hidden" name="oper_num" id="oper_num" value="<%=oper_num%>">
	<input type="hidden" name="oper_code" id="oper_code" value="<%=oper_code%>">
	<input type="hidden" name="set_code" id="set_code"  value="<%=set_code%>">
 	<input type="hidden" name="tray_num" id="tray_num"  value="<%=tray_num%>">
 	<input type="hidden" name="row_num" id="row_num"  value="<%=row_num%>">
</form>
</body>
</html>

