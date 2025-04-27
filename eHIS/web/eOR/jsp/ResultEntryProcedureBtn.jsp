<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOR.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
 	<script language="JavaScript" src="../js/ResultEntry.js"></script>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	/* String resultReportingURL = request.getQueryString();
	 String requestFrom = request.getParameter("requestFrom");
	 String freqExplApplies = request.getParameter("freqExplApplies");
	 String orderId = request.getParameter("orderId");*/
	 String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	 String proc_resulting_option_result = request.getParameter("proc_resulting_option_result")==null?"":request.getParameter("proc_resulting_option_result");
//out.println("proc"+proc_resulting_option_result);
//out.println("<script>alert('parent_order_id:button:"+parent_order_id+"===')</script>");
//out.println("<script>alert('parent_order_id:button:"+called_from+"===')</script>");

%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='result_entry_proc_btn' id='result_entry_proc_btn' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%">
	<tr>
		<td  class='button'>
		<%if(called_from.equals("Coding")){%>
			<input id="" name='record' id='record' type="button" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' class='button' onClick='callRetainStatus(this)'><%}else{%><input id="" name='ok' id='ok' type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class='button' onClick='callRetainStatus("")'><%}%><input id="" name='close' id='close' type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='button' onClick='closeWindow()'></td>
		</td>
	</tr>
<Input type='hidden' name='proc_resulting_option_result' id='proc_resulting_option_result' value='<%=proc_resulting_option_result%>'>
</table>
	
</form>
</body>
</html>
<%
//putObjectInBean(bean_id,bean,request);
%>

