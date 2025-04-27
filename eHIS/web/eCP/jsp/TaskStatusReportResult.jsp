<!DOCTYPE html>
<%
/*
	
	----------------------------------------------------------------------------------------------------------------
	 Date       Edit History   	Name       			Rev.Date   	Rev.By    				Description
	----------------------------------------------------------------------------------------------------------------
	15/05/2018 	 IN065254		Kamalakannan G  		15/05/2018 		 Ramesh G 		GHL_CRF_0485
	21/05/2018 	IN067699		Kamalakannan G  		21/05/2018 		 Ramesh G 		GHL_CRF_0485/02
	-----------------------------------------------------------------------------------------------------------------
	
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page
	import="java.util.*, eCP.*, eMR.*, eCA.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String bean_id = "CP_ReportBean" ;
	String bean_name = "eCP.ReportBean";
	ReportBean bean = (ReportBean)getBeanObject( bean_id, bean_name , request ) ;
	String mode	   = "1";
	request.setCharacterEncoding("UTF-8");
	bean.clear() ;
	bean.setMode( mode ) ;
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css' />
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript"
	src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../js/OrCommon.js"></script><!--IN067697-->
<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script><!--IN067699-->
<link rel="stylesheet" type="text/css"
	href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()"
	onKeyDown="lockKey()">
	<form name="task_status_report" id="task_status_report" method="post"><!--IN067699  -->
		<%
			
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			String patient_id = request.getParameter("patientId")==null?"":request.getParameter("patientId");
			String date_from = request.getParameter("date_from")==null?"":request.getParameter("date_from");
			date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY","en",locale); 
			String date_to = request.getParameter("date_to")==null?"":request.getParameter("date_to");
			date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY","en",locale);
			String currentDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
			String task = request.getParameter("p_task_stmt")==null?"":request.getParameter("p_task_stmt");//IN067699
			String status = request.getParameter("p_status")==null?"":request.getParameter("p_status");//IN067699
			String goal_stmt = request.getParameter("p_goal_stmt")==null?"":request.getParameter("p_goal_stmt");//IN067699
			String facility_id = (String)session.getValue("facility_id");//IN067699
			String userName = (String)session.getValue("appl_user_name");//IN067699
			ArrayList searchData=new ArrayList();
			searchData=bean.getTaskStatusReport(patient_id,date_from,date_to,locale,goal_stmt,task,status);
			if(searchData.size() == 0)
			{
			%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"))
					parent.TaskReportResult.location.href = "../../eCommon/html/blank.html";
					parent.printFrame.location.href = "../../eCommon/html/blank.html";//IN067699
				</script>

			<%	}
			%>
		<table class='grid' cellspacing=0 border='1' width="100%" 
			id="tableheader">
		<tr>
				<td class="columnheader" width='' nowrap >S 
					<fmt:message key="Common.no.label"
						bundle="${or_labels}" /></td>
				<td class="columnheader" width='' nowrap >
					<fmt:message key="Common.date.label"
						bundle="${common_labels}" /></td>
				<td class="columnheader" width='' nowrap >
					<fmt:message key="eCA.GoalStmt.label"
						bundle="${common_labels}" /></td>
				<td class="columnheader" width='' nowrap >
					<fmt:message key="eCA.Task.label"
						bundle="${common_labels}" /></td>
				<td class="columnheader" width='' nowrap >
					<fmt:message key="Common.priority.label"
						bundle="${common_labels}" /></td>
				<td class="columnheader" width='' nowrap >
					<fmt:message key="Common.status.label"
						bundle="${common_labels}" /></td>
			</tr>
		
			<%
			int count = 1;
			for(int i=0;i<searchData.size();i++){
			ArrayList<String> task_status_result = new ArrayList();
			task_status_result=(ArrayList<String>)searchData.get(i);
					out.println("<tr> <td class='gridData' name='start_date_time"+count+ "' width='' wrap><font size=1>"+(count++)+"</td>");
					out.println("<td class='gridData' name='start_date_time"+count+ "' width='' wrap><font size=1>"+ task_status_result.get(0)+"</td>");
					out.println("<td class='gridData' id='end_date_time"+count+ "' width='' nowrap><font size=1>"+ task_status_result.get(1)+"</td>");
					out.println("<td class='gridData' name='spec_no"+count+ "' width='' nowrap><font size=1>"+ task_status_result.get(2) +"</td>");
					out.println("<td class='gridData' name='order_cat"+count+ "' width='' wrap><font size=1>"+task_status_result.get(3)+"</td>");
					out.println("<td id='remarks"+count+"' name='remarks"+count+ "' class='gridData' width=''>"+task_status_result.get(4)+"</td>");
			}	
			%>	
		</table>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id %>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="p_patientId" id="p_patientId" value="<%=patient_id%>"><!-- IN067699 -->
		<input type="hidden" name="p_date_from" id="p_date_from" value="<%=date_from%>"><!-- IN067699 -->
		<input type="hidden" name="p_date_to" id="p_date_to" value="<%=date_to%>"><!-- IN067699 -->
		<input type="hidden" name="p_task_stmt" id="p_task_stmt" value="<%=task%>"><!-- IN067699 -->
		<input type="hidden" name="p_status" id="p_status" value="<%=status%>"><!-- IN067699 -->
		<input type="hidden" name="p_goal_stmt" id="p_goal_stmt" value="<%=goal_stmt%>"><!-- IN067699 -->
		<input type="hidden" name="p_userName" id="p_userName" value="<%=userName%>"><!-- IN067699 -->
		<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>"><!-- IN067699 -->
		<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>"><!-- IN067699 -->
	</form>
</body>
</html>

