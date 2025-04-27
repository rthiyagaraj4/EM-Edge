<!DOCTYPE html>

<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
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
	booking_num	=booking_num==null?"":booking_num;
	booking_num	=booking_num.equalsIgnoreCase("null")?"":booking_num;
	oper_num	=oper_num==null?"":oper_num;
	oper_num	=oper_num.equalsIgnoreCase("null")?"":oper_num;
	String final_status_cmpl_yn = "",initial_status_cmpl_yn = "";
%>
<body  onKeyDown="lockKey()">
<form name="InstrumentCountCreateSetButtonForm" id="InstrumentCountCreateSetButtonForm" >
<table border='1' cellpadding='3' cellspacing='0' align='center'  width='100%' >
<tr>
	<td class='fields' width="25%" >
		<input type="button" class="button" name="create_set" id="create_set" 
		value='<fmt:message key="eOT.AddaSet.Label" bundle="${ot_labels}"/>' onclick="createSet()">
	</td>
	<td class='field' width="25%" >
		<input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="window.returnValue='';window.close();">
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
</form>
</body>
</html>
			

