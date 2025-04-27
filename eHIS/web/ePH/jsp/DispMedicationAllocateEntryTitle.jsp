<!DOCTYPE html>

  
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

</HEAD>

<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="DispMedicationAllocationDrugEntryTitle" id="DispMedicationAllocationDrugEntryTitle">
<%	

String	bean_id			=	"DispMedicationAllStages" ;
String	bean_name		=	"ePH.DispMedicationAllStages";
	
DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request ) ;
//bean.setLanguageId(locale);

String module_id		=	bean.getModuleId();
String drug_name		=	request.getParameter("drug_desc");
String qty				=	request.getParameter("qty");

if(module_id.equals("1")) {	%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
<th align="left" style="font-size:9"><fmt:message key="ePH.Add/ModifyBatchDetails.label" bundle="${ph_labels}"/></th>
</table>
<table cellpadding="0" cellspacing="0" width="97%" align="left" border="1">
<tr>
	<th align="center" width="24%" style="font-size:9"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
	<th align="center" width="24%" style="font-size:9"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
	<th align="center" width="16%" style="font-size:9"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
	<th align="center" width="19%" style="font-size:9"><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
	<th align="center" width="17%" style="font-size:9"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	</tr>
</table>
<%	}else{	%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
<td  class="CURRTEXT"><font size="1"><b><%=drug_name%>&nbsp;&nbsp;<%=qty%></b></font></td>
</table>
<%	}	%>
</form>
</body>
</html>
<%
//putObjectInBean(bean_id,bean,request);
%>

