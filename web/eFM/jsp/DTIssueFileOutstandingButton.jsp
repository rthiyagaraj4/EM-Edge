<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eFM/js/FMIssueFilesDoc.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	String resLocnIdentities = request.getParameter("resLocnIdentities");
	resLocnIdentities = "N";
%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name="Outstanding_button_form" id="Outstanding_button_form">
	<table border="0" cellpadding="0" cellspacing="0" width='100%'>
			<td width="1%" class='white'>&nbsp;</td>
			<td width="2%" style='background-color:mediumaquamarine' id="selectedfilecolor">&nbsp;</td>
			<td width="20%"  class='white' id="selectedfilelegend"><font size='1'><b><fmt:message key="eFM.DocsSelectedforIssue.label" bundle="${fm_labels}"/></b></font></td>
			<td width="2%" ><img src='../../eFM/images/stop.gif' align='center'></img></td>
			<td width="20%" class='white' id="selectedfilelegend"><font size='1'><b><fmt:message key="eFM.MedicoLegalCase.label" bundle="${fm_labels}"/></b></font></td>
<%
		if(resLocnIdentities.equals("Y"))
		{
%>
			<td width="2%"  style='background-color:mediumvioletred' id="restrictioncolor">&nbsp;</td>
			<td width="30%" class='white' id="restrictionlegend"><font size='1'><b><fmt:message key="eFM.RestrictionacrossFSLocnIdentities.label" bundle="${fm_labels}"/></b></font></td>
<%
		}
%>
			<td width="20%"  class='button'>
			<input type='button' class='button' name='add' id='add' value='Add for Issue' onClick='AddDocs();'>
			</td>
	</table>
</form>
</body>
</html>


