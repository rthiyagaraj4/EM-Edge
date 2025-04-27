<!DOCTYPE html>
<!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>                                
<head>                                
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="javascript" src="../js/PhCommon.js"></script>
 	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="ePH.ScheduleDosageDetail.label" bundle="${ph_labels}"/></title>
</head>                               

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String params = request.getQueryString() ;
	String bean_id				= "QueryMednAdminChartBean";
	String bean_name			= "ePH.QueryMednAdminChartBean";

	QueryMednAdminChartBean bean = (QueryMednAdminChartBean)getBeanObject( bean_id,bean_name,request);

	String  relevantencounterid	=	request.getParameter("relevantencounter");
	String rows	=	"";



	HashMap sch_dates			=	bean.loadSchDates(relevantencounterid);
	ArrayList future_records	=	(ArrayList) sch_dates.get("future_records");

	if(future_records.size()==0) {
		rows	=	"94%,6%";
	} else {
		rows	=	"47%,6%,47%";
	}
		
%>


	<iframe name="f_past_orders" id="f_past_orders"  src="../../ePH/jsp/QueryMednAdminChartAllDose.jsp?<%=params%>&called_from=PAST" frameborder="1" noresize scrolling="auto" style="height:47vh;width:100vw"></iframe>
	<iframe name="f_legends" id="f_legends"  src="../../ePH/jsp/QueryMednAdminChartColor.jsp" frameborder="0" noresize scrolling="no" style="height:6vh;width:100vw"></iframe>
<% if(future_records.size()!=0) {	%>
	<iframe name="f_future_orders" id="f_future_orders" src="../../ePH/jsp/QueryMednAdminChartAllDose.jsp?<%=params%>&called_from=FUTURE" frameborder="1" noresize scrolling="auto" style="height:47vh;width:100vw"></iframe>
<%	}	%>

<% putObjectInBean(bean_id,bean,request); %>
</html>

