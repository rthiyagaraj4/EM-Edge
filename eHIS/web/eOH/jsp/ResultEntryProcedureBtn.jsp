<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOH.* " %>
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

//out.println("<script>alert('parent_order_id:button:"+parent_order_id+"===')</script>");
//out.println("<script>alert('parent_order_id:button:"+called_from+"===')</script>");

%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='result_entry_proc_btn' id='result_entry_proc_btn' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%">
	<tr>
		<td  class='button'>
		<%if(called_from.equals("Coding")){%>
			<input id="" name='record' id='record' type="button" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' class='button' onClick='callRetainStatus(this)'><%}else{%><input id="" name='ok' id='ok' type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class='button' onClick='callRetainStatus("")'><%}%><input id="" name='close' id='close' type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='button' onClick='window.close()'></td>
		</td>
	</tr>
	
</table>
	
</form>
</body>
</html>
<%
//putObjectInBean(bean_id,bean,request);
%>

