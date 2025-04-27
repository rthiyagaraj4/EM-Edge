<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
	%>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<!--<link rel='stylesheet' type='text/css' href='../../eCA/html/CAStyle.css'>-->
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table border=0  cellpadding=0 cellspacing=0 width="100%">
	<tr>
	<!-- <td class=BLUE width='18%%'><font size=1 color=white>&nbsp;<b><fmt:message key="Common.CurrentEncounter.label" bundle="${common_labels}"/></b></font></td>
	<td width='3%'><font size=1>&nbsp;</td>
	<td width='15%'><font size=1>&nbsp;<b><fmt:message key="Common.Differentials.label" bundle="${common_labels}"/> <font color=blue>(D)</font> </b></font></td>
	<td colspan='4' class='label'></td> -->

	<td width='15%%'><font size=1>&nbsp;<b><img src='../../eCommon/images/CurrentEncounter.gif'>&nbsp;<fmt:message key="Common.CurrentEncounter.label" bundle="${common_labels}"/></b></font></td>
	<td width='10%%'><font size=1>&nbsp;<b><img src='../../eCommon/images/Problems.gif'>&nbsp;<fmt:message key="Common.Problem.label" bundle="${common_labels}"/></b></font></td>
	<td width='15%'><font size=1><img src='../../eCommon/images/Differentials.gif'>&nbsp;<b><fmt:message key="Common.Differentials.label" bundle="${common_labels}"/></b></font></td>
	<td width='20%'><font size=1><img src='../../eCommon/images/LinkView.gif'>&nbsp;<b>View Linked Problems</b></font></td>
	<td colspan='4' class='label'></td>


	<!--<td width='10%'><font size=1>&nbsp;<b><fmt:message key="Common.priority.label" bundle="${common_labels}"/>:</b></font></td>
	<td  align='left' class='SEMICRITICAL'><font size=1 >&nbsp;<b><fmt:message key="Common.High.label" bundle="${common_labels}"/></b>&nbsp;&nbsp;</td>	
		<td class=RED><font size=1 color=white>&nbsp;<b><fmt:message key="Common.Critical.label" bundle="${common_labels}"/></b></font></td>
		<td class=NONCRITICAL><font size=1 color=white>&nbsp;<b><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></b></font></td>-->
	</tr>
	</table>
</body>
</html>

