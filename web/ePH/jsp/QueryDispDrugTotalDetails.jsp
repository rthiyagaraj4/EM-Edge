<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*, java.text.DecimalFormat,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin='0'>
<%
		//Search Criteria's from Query Criteria page
		String	bean_id			=	"QueryPresVsDispDrugsBean" ;
		String	bean_name		=	"ePH.QueryPresVsDispDrugsBean";
		QueryPresVsDispDrugsBean bean = (QueryPresVsDispDrugsBean)getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
		//Modified for CRF 0749 INC-13640
		String facility_id			  = (String) session.getValue("facility_id");
		String uom					  =	bean.getUomDisplay(facility_id,request.getParameter("uom"));
		int no_decimals =bean.getNoOfDecimals() ;
		String decimalStringFormat = "#.";
		// if Condition added for IN18681 to avoid displaying decimal point after the number  --01/02/2010--   shyampriya
		if(no_decimals == 0)
			decimalStringFormat = "#";
		for (int i=0;i<no_decimals;i++){
			decimalStringFormat += "#";
		}
		DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	
%>
		<table border="0" cellpadding="0" cellspacing="0" width="100%" align="LEFT" topmargin='0'>
			<tr>
				<td><b><fmt:message key="ePH.TotalNoofPatients.label" bundle="${ph_labels}"/></b></td>
				<td><%=bean.getTotalPatients()%></td>
				<td ><b><fmt:message key="ePH.TotalOrders.label" bundle="${ph_labels}"/></b></td>
				<td ><%=bean.getTotalOrders()%></td>
				<td><b><fmt:message key="ePH.TotalOrderedQuantity.label" bundle="${ph_labels}"/></b></td>
				<td><%=dfToInteger.format(bean.getTotalOrdered())%>&nbsp;<%=uom%></td>
				</tr>
				<tr>
					<td><b><fmt:message key="ePH.TotalDispensedQuantity.label" bundle="${ph_labels}"/></b></td>
					<td><%=dfToInteger.format(bean.getTotalDispensed())%>&nbsp;<%=uom%></td>
					<td><b><fmt:message key="ePH.TotalReturnedQuantity.label" bundle="${ph_labels}"/></b></td>
					<td><%=dfToInteger.format(bean.getTotalReturned())%>&nbsp;<%=uom%></td>
					<td><b><fmt:message key="ePH.TotalPendingQuantity.label" bundle="${ph_labels}"/>  </b></td>
					<td><%=dfToInteger.format(bean.getTotalPending())%>&nbsp;<%=uom%></td>
				</tr>
				<tr>
				<td colspan=4></td>
				 <td><b><fmt:message key="ePH.ExcessDispensedQuantity.label" bundle="${ph_labels}"/></b></td>
					<td><%=dfToInteger.format(bean.getTotalExcess())%>&nbsp;<%=uom%></td>	
				</tr>
		</table>
	</body>
<% putObjectInBean(bean_id,bean,request); %>
</html> 

