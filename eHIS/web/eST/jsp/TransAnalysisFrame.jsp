<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page   contentType="text/html;charset=UTF-8"%>
<%@page  import="java.util.*, eST.*, eST.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<html>
<head>
<%
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
	<!-- <script language="JavaScript" src="../js/StMessages.js"></script> -->
	<script language="JavaScript" src="../js/TransAnalysisReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<body onload="FocusFirstElement()" >

<%
	/* Mandatory checks start */
//	String mode					=	request.getParameter( "mode" );
	String bean_id				=	"TransAnalysisBean";
	String bean_name			=	"eST.TransAnalysisBean";
	
	/* Initialize Function specific start */
	TransAnalysisBean bean = (TransAnalysisBean)getBeanObject( bean_id,bean_name,request ) ;  
//	bean.clear() ;

	/* Initialize Function specific end */

%>
		
<form name="formTransAnalysis" id="formTransAnalysis" >
<br>

<table border = 1 cellpadding=0 cellspacing=0 width="70%" align="center">
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td align="right" class="label" width='35%'><fmt:message key="Common.Transaction.label"   bundle="${common_labels}"/></td>
	<td align="left"  colspan="2">&nbsp;&nbsp;
	<select name="summary_code" id="summary_code"  onchange="loadPage();">
	<option value=""  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------&nbsp;&nbsp;</option>
	<option value="A"><fmt:message key="eST.RequestStatisticsReport.label"   bundle="${st_labels}"/></option>
	<option value="B"><fmt:message key="eST.GRNStatisticsReport.label"   bundle="${st_labels}"/></option>
	<option value="C"><fmt:message key="eST.UnfinalizedTransactionsReport.label"   bundle="${st_labels}"/></option>
	<option value="D"><fmt:message key="eST.StockStatusReportForTransactedItems.label"   bundle="${st_labels}"/></option>
	<option value="E"><fmt:message key="eST.FacilityWiseYearlySummaryReport.label"   bundle="${st_labels}"/></option>
	<option value="F"><fmt:message key="eST.YearlyStockTurnoverReport.label"   bundle="${st_labels}"/></option>
	<option value="G"><fmt:message key="eST.MFGWorkloadStatisticsReport.label"   bundle="${st_labels}"/></option>


	</select></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
</table>
	<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"		value="<%= bean_name %>">
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>

</html>

