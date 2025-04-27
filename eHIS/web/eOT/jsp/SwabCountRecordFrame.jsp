<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eOT/js/SwabCount.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
	String record_tab_name = request.getParameter("record_tab_name");
	String final_cnt_cmpl_yn		= request.getParameter("final_cnt_cmpl_yn");
	final_cnt_cmpl_yn=final_cnt_cmpl_yn==null?"N":final_cnt_cmpl_yn;
	final_cnt_cmpl_yn=final_cnt_cmpl_yn.equalsIgnoreCase("null")?"N":final_cnt_cmpl_yn;
	String disabled="";
	if(final_cnt_cmpl_yn.equals("Y"))
		disabled="disabled";
%>
<body  onKeyDown="lockKey()">
<form name="SwabCountRecordForm" id="SwabCountRecordForm" >
<table border='0' cellpadding=3  cellspacing='0' align='center'  width='100%'>
<tr>
	<td width='25%' class="button">
	<%
		if(record_tab_name.equals("SWABCOUNT")){
	%>
			<input type="button" class="button" name="record" id="record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' <%=disabled%> onClick="addItems();">
	<%
		}else if(record_tab_name.equals("VERIFY")){
	%>
		<input type="button" class="button" name="record" id="record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick="recordSwabVerify();">
	<%
		}else if(record_tab_name.equals("PERSONNELDTLS")){
	%>
		<input type="button" class="button" name="record" id="record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="recordPersonnelData();">
	<%
		}
	%>
		<input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="window.returnValue='';window.close();">
	</td>
</tr>		
</table>
</form>
</body>
</html>

