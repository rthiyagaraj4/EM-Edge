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
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMIssueFiles.js'></script>
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
			<td width="20%"  class='white' id="selectedfilelegend">&nbsp;<font size='1'><b><fmt:message key="eFM.FilesSelectedforIssue.label" bundle="${fm_labels}"/></b></font></td>
			<td width="2%" ><img src='../../eFM/images/stop.gif' align='center'></img></td>
			<td width="20%" class='white' id="selectedfilelegend"><font size='1'><b><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></b></font></td>
			<!--Above line modified for this incident [61325] -->
			<%
			if(resLocnIdentities.equals("Y"))
			{
			%>
				<td width="2%" style='background-color:mediumvioletred' id="restrictioncolor">&nbsp;</td>
				<td width="30%" class='white' id="restrictionlegend">&nbsp;<font size='1'><b><fmt:message key="eFM.RestrictionacrossFSLocnIdentities.label" bundle="${fm_labels}"/></b></font></td>
			<%
			}
			%>
			<td width="20%" class='button' align="right">
			<input type='button' class='button' name='add' id='add' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>&nbsp;<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.for.label","common_labels")%>&nbsp;<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Issue.label","common_labels")%>' onClick='AddForIssue();'>
			&nbsp;&nbsp;
			</td>
		</table>
	</form>
</body>
</html>


