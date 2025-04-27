<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
</head>
<script language="javascript">
function changeTab(objStr)
{
	selectTab(objStr);
	var frmObj=document.forms[0];
	var old_objStr ="";
	if(objStr=="HospitalPersonnel")
		old_objStr = "hosp_tab";
	else if(objStr=="VisitingPersonnel")
		old_objStr = "visit_tab";
	var param=frmObj.param.value+"&tab_id="+old_objStr;

	if(parent.ChildBaseFrame!=null)
			parent.ChildBaseFrame.location.href='../../eOT/jsp/PersonnelFrames.jsp?'+param;
			if(parent.parent.messageFrame!=null)
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="PersonnelTabForm" id="PersonnelTabForm">
	<table id="tab" cellspacing=0 cellpadding=3  border="0" width='100%' align="center">
<tr>
		<td width= "100%" class="white">
			<ul id="tablist" class="tablist">
				<li class="tablistitem" title='<fmt:message key="eOT.HospitalPersonnel.Label" bundle="${ot_labels}"/>'>
					<a onclick="changeTab('HospitalPersonnel')" class="tabclicked" id="HospitalPersonnel">
						<span class="tabSpanclicked" id="HospitalPersonnelspan">
							<fmt:message key="eOT.HospitalPersonnel.Label" bundle="${ot_labels}"/></span></a>
					</li>
				<li class="tablistitem" title='<fmt:message key="eOT.VisitingPersonnel.Label" bundle="${ot_labels}"/>'>
					<a onclick="changeTab('VisitingPersonnel')" class="tabA" id="VisitingPersonnel">
						<span class="tabAspan" id="VisitingPersonnelspan">
							<fmt:message key="eOT.VisitingPersonnel.Label" bundle="${ot_labels}"/></span></a>
				</li>
			</ul>
		</td>
		<td colspan='6' width='75%'></td>
</tr>

</table>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
<script>prevTabObj='HospitalPersonnel'</script>
<script>changeTab('HospitalPersonnel')</script>
</form>
</body >
</html>

