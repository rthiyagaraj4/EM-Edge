<!DOCTYPE html>
<%@page  import=" eST.ReportsStockStatusBean" contentType="text/html;charset=UTF-8"%>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%

request.setCharacterEncoding("UTF-8");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eST/js/StCommon.js'></script>
<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>	
<script language='javascript' src='../../eST/js/DrugMedicalItemSalesHistoryReport.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="eST.ABCAnalysisReport.label" bundle="${st_labels}"/></title>
    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>";
    </script>
</head>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String bean_id = "ReportsStockStatusBean";
	String bean_name = "eST.ReportsStockStatusBean";
	ReportsStockStatusBean bean = (ReportsStockStatusBean)getBeanObject( bean_id,bean_name,request);  
	
	if(bean.getAccessCostDetails().equals("N")){%>

	<SCRIPT>alert("Drug Medical Item Sales History Report Function is not applicable");window.location.href =
'../../eCommon/jsp/dmenu.jsp'</SCRIPT>
<%}%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eST/jsp/DrugMedicalItemSalesHistoryReportCriteria.jsp" frameborder=0 scrolling='no' style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:50%;width:100vw'></iframe>
 <%
putObjectInBean(bean_id,bean,request);
%>

</html>
     

