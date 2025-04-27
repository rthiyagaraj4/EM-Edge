<!DOCTYPE html>
<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
	
%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src="../js/AddModifyPatFinDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='' id=''>
<table cellpadding=3 cellspacing=0  width="100%" align='left' border='1'>
	<tr>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.INCLUDED_EXCLUDED.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.INCLUDED_EXCLUDED_ACTION.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.RATE_CHARGE.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='18%'><fmt:message key="eBL.ORIG_QTY_PER_PANEL.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='4%'><fmt:message key="Common.uom.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='20%'><fmt:message key="eBL.REVISED_QTY_PER_PANEL.label" bundle="${bl_labels}"/></td>	
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.TOTAL_QTY.label" bundle="${bl_labels}"/></td>
	</tr>
	<tr>
	<td class='COLUMNHEADER' width='5%'></td>	
	<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.RATE.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.PRACT_STAFF_TYPE.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.PRACTITIONER_STAFF.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.TOTAL_PAYABLE.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='18%'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='4%'><fmt:message key="eBL.PREAPPR_REQD.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='20%'></td>	
	<td class='COLUMNHEADER' width='10%'></td>		
	</tr>
	</table>
</form>
</body>
</html>

