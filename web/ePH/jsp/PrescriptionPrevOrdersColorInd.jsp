<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
 		request.setCharacterEncoding("UTF-8"); 
		String locale = (String) session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DrugSearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="frmPrescriptionPrevOrdersColorInd" id="frmPrescriptionPrevOrdersColorInd">
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
		<tr>
			<td class='CANCELLED' width='2%'>&nbsp;</td>
			<td class='white' >&nbsp;&nbsp;
				<label style="font-size:9;font-weight:bold"><fmt:message key="Common.cancelled.label
" bundle="${common_labels}"/></label>
			</td>
			<td class='DISCONTINUED' width='2%'>&nbsp;</td>
			<td class='white' >&nbsp;&nbsp;
				<label style="font-size:9;font-weight:bold"><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></label>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>

