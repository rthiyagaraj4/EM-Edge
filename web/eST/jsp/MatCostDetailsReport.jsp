<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, java.lang.*,eST.*, eST.Common.* , eCommon.Common.*" %>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!--	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'> 	</link> -->
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<!--	<script language='javascript' src='../../eCommon/js/messages.js'></script> -->
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
<!--	<script language='javascript' src='../../eST/js/StMessages.js'></script> -->
		<script language='javascript' src='../../eST/js/MatCostDetailsReport.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



    <script>
        function_id				=		"<%= request.getParameter( "function_id" ) %>"
    </script>
</head>

<%
		String url				=		"../../eCommon/jsp/commonToolbar.jsp?" ;
		String params			=		request.getQueryString() ;
		String source			=		url + params ;
		String facilityid		=		(String)session.getValue("facility_id");
		String bean_id				=		"MonthlySummaryReportBean";
		String bean_name			=		"eST.MonthlySummaryReportBean";
		MonthlySummaryReportBean bean =		(MonthlySummaryReportBean) getBeanObject(bean_id,bean_name,request);  
		
	if(!bean.checkForNull((String)	bean.fetchRecord(bean.getStRepositoryValue("ST_SQL_VIEW_COST_YN_SELECT"),new String[]{bean.getLoginById()}).get("VIEW_COST_YN"),"N").equals("Y")){%>

	<SCRIPT>alert(getMessage("NO_ACCESS_FOR_USER","ST"));window.location.href =
	'../../eCommon/jsp/dmenu.jsp'</SCRIPT>
<%}
	putObjectInBean("bean",bean,request);

%>

<title><fmt:message key="eST.ItemSearch.label" bundle="${st_labels}"/></title>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eST/jsp/MatCostDetailsReportCriteria.jsp" frameborder=0 scrolling='no' style='height:82vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>

