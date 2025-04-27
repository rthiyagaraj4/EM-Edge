<!DOCTYPE html>
<!--Created by sathish on 20-01-2010-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eOH/jsp/StringUtil.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
%>

<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eOH/js/TrmtComplicationDetails.js" language="javascript"></script>
		<script language="javascript" src="../../eOH/js/Hashtable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
		<table border="1" width="98%" cellspacing='0' cellpadding='1'  align='center'>
			<tr>
				<td class='columnHeaderCenter' width='60%' wrap><fmt:message key="eOH.ComplicationDetails.Label" bundle="${oh_labels}"/></td>
				
				<td class='columnHeaderCenter' width='10%%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			</tr>
		</table>
	</body>
</html>

