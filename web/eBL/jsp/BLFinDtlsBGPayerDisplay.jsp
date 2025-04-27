<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%request.getParameter("UTF-8"); 
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String visibility = request.getParameter("visibility");
if(visibility == null)		visibility = "";
%>
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eBL/js/BLFinDtlsBGPayerLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body>
	<form name='frmBGPayerDisplay' id='frmBGPayerDisplay'>
	<br/>
		<%if("Y".equals(visibility)){ %>
		<div id='divResults' name='divResults' style="visibility: visible;">
		<%}
		else{
		%>
		<div id='divResults' name='divResults' style="visibility: hidden;">
		<%} %>
		<div style="height: 125px; overflow: auto;">
		<table class='grid' border='1' width='95%' cellpadding='3'  cellspacing=0 align="center" name='tblDisplay' id='tblDisplay'>
			<tr>
				<td width='20%' class='COLUMNHEADER' nowrap>
					<fmt:message bundle="${bl_labels }" key="eBL.BillingGroup.label"></fmt:message>
				</td>
				<td width='20%' class='COLUMNHEADER' nowrap>
					<fmt:message bundle="${bl_labels }" key="eBL.PAYER_GROUP.label"></fmt:message>
				</td>
				<td width='20%' class='COLUMNHEADER' nowrap>
					<fmt:message bundle="${bl_labels }" key="eBL.PAYER.label"></fmt:message>
				</td>
				<td width='20%' class='COLUMNHEADER' nowrap>
					<fmt:message bundle="${bl_labels }" key="eBL.POLICY.label"></fmt:message>
				</td>
				<td width='16%' class='COLUMNHEADER' nowrap>
						<fmt:message bundle="${common_labels }" key="Common.priority.label"></fmt:message>
				</td>
				<td width='4%' class='COLUMNHEADER' nowrap>
					<fmt:message bundle="${common_labels }" key="Common.Remove.label"></fmt:message>
				</td>
			</tr>
		</table>
		</div>
		<table  width='95%' align="center">
		<tr>
			<td width='80%'>
				&nbsp;
			</td>
			<td width='10%'>
				<input type='button' class='button' name='removePayer' id='removePayer' value='Remove Payer'>
			</td>
			<td width='10%'>
				<input type='button' class='button' name='btnClose' id='btnClose' value='close'>
			</td>
		</tr>
		</table>
		</div>
		<input type='hidden' name='precessedArray' id='precessedArray' value=''>
	</form>
</body>
</html>
