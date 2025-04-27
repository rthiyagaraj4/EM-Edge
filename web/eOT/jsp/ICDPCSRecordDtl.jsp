<!DOCTYPE html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<HTML>
<HEAD>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eOT/js/ICDPCS.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
OPTION.AUTO,TD.AUTO {
			FONT-FAMILY: VERDANA ;
			FONT-SIZE: X-LARGE ;
			BACKGROUND-COLOR: #00ff66;
			BORDER-STYLE: SOLID;
			BORDER-LEFT-COLOR: #B2B6D7;
			BORDER-RIGHT-COLOR: #B2B6D7;
			BORDER-TOP-COLOR: #E2E3F0;
			BORDER-BOTTOM-COLOR: #E2E3F0;
}
OPTION.MANDATORY,TD.MANDATORY{
			FONT-FAMILY: VERDANA ;
			FONT-SIZE: X-LARGE ;
			BACKGROUND-COLOR: #cc0033;
			COLOR:WHITE;
			BORDER-STYLE: SOLID;
			BORDER-LEFT-COLOR: #B2B6D7;
			BORDER-RIGHT-COLOR: #B2B6D7;
			BORDER-TOP-COLOR: #E2E3F0;
			BORDER-BOTTOM-COLOR: #E2E3F0;
 }
 OPTION.OPTIONAL,TD.OPTIONAL{
			FONT-FAMILY: VERDANA ;
			FONT-SIZE: X-LARGE ;
			COLOR:BROWN;
			BACKGROUND-COLOR: Gold;
			BORDER-STYLE: SOLID;
			BORDER-LEFT-COLOR: #B2B6D7;
			BORDER-RIGHT-COLOR: #B2B6D7;
			BORDER-TOP-COLOR: #E2E3F0;
			BORDER-BOTTOM-COLOR: #E2E3F0;
 }
</STYLE>
</head>
<body onLoad="loadOperListItem();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name = 'ICDPCSRecordForm' >
<table  border='2' cellpadding='3' cellspacing='0' width='100%'>
<tr>
	<td class='MANDATORY' style="font-size:9;font-weight:bold" align='center' width="5%">&nbsp;&nbsp;&nbsp;</td>
	<td CLASS="PATIENTLINE7" >
		<fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/>
	</td>
	<td class='OPTIONAL' style="font-size:9;font-weight:bold" align='center' width="5%">&nbsp;&nbsp;&nbsp;</td>
	<td CLASS="PATIENTLINE7">
		<fmt:message key="Common.Optional.label" bundle="${common_labels}"/>
	</td>
	<td class='AUTO' style="font-size:9;font-weight:bold" align='center' width="5%">&nbsp;&nbsp;&nbsp;</td>
	<td CLASS="PATIENTLINE7">
		<fmt:message key="eOT.AutoPopulated.Label" bundle="${ot_labels}"/>
	</td>
</table>
</form>
</body>
</html>

