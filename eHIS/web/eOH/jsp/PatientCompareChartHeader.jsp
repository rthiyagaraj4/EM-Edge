<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.Statement,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String chart_code=checkForNull(request.getParameter("chart_code"));
	String eval_type=checkForNull(request.getParameter("eval_type"));
	String eval_chart_date1=checkForNull(request.getParameter("eval_chart_date1"));
	String selected_val1=checkForNull(request.getParameter("selected_val1"));
	String selected_val2=checkForNull(request.getParameter("selected_val2"));
	String selected_val3=checkForNull(request.getParameter("selected_val3"));
	String no_of_charts=checkForNull(request.getParameter("no_of_charts"));
	
%>

<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	 <table border="0" cellspacing="0" width="100%">
		<tr>

			<td  class='PATIENTLINE1'>
				<fmt:message key="Common.patientId.label" bundle="${common_labels}"/> : <font color="white" size='2'><%=patient_id%></font>
			</td>
			
			<td  class='PATIENTLINE1'>
 				<fmt:message key="eOH.ChartDate.Label" bundle="${oh_labels}"/> : <font color="white" size='2'> <%=eval_chart_date1%></font>
			</td>

			<td  class='PATIENTLINE1'>
 				<fmt:message key="eOH.ChartCode.Label" bundle="${oh_labels}"/> : <font color="white" size='2'><%=chart_code%></font>
			</td>
			<td  class='PATIENTLINE1'></td>
			
		</tr>
		<tr>
		<td class='PATIENTLINE1'></td>
		<td class='PATIENTLINE1'></td>
		<td class='PATIENTLINE1'></td>
		<td class='PATIENTLINE1'></td>
		</tr>
		<tr>
		<%if(no_of_charts.equals("3")){
			if(eval_type.equals("BB")){		
		%>
				<td class='PATIENTLINE1'>
					<fmt:message key="eOH.Baseline_Chart.Label" bundle="${oh_labels}"/> 1 : <font color="white" size='2'><%=selected_val1%> </font>
				</td>
				<td class='PATIENTLINE1'>
					<fmt:message key="eOH.Baseline_Chart.Label" bundle="${oh_labels}"/> 2 : <font color="white" size='2'><%=selected_val2%> </font>
				</td>
				<td class='PATIENTLINE1'>
					<fmt:message key="eOH.Baseline_Chart.Label" bundle="${oh_labels}"/> 3 : <font color="white" size='2'><%=selected_val3%> </font>
				</td>
		<%} else if(eval_type.equals("BE")){ %>
				<td class='PATIENTLINE1'>
						<fmt:message key="eOH.Baseline_Chart.Label" bundle="${oh_labels}"/> 1 : <font color="white" size='2'><%=selected_val1%> </font>
				</td>
				<td class='PATIENTLINE1'>
						<fmt:message key="eOH.Evaluation_Chart.Label" bundle="${oh_labels}"/> 2 : <font color="white" size='2'><%=selected_val2%> </font>
				</td>
				<td class='PATIENTLINE1'>
						<fmt:message key="eOH.Evaluation_Chart.Label" bundle="${oh_labels}"/> 3 : <font color="white" size='2'><%=selected_val3%> </font>
				</td>
			<%} else if(eval_type.equals("EE")){%>
				<td class='PATIENTLINE1'>
						<fmt:message key="eOH.Evaluation_Chart.Label" bundle="${oh_labels}"/> 1 : <font color="white" size='2'><%=selected_val1%> </font>
				</td>
				<td class='PATIENTLINE1'>
						<fmt:message key="eOH.Evaluation_Chart.Label" bundle="${oh_labels}"/> 2 : <font color="white" size='2'><%=selected_val2%> </font>
				</td>
				<td class='PATIENTLINE1'>
						<fmt:message key="eOH.Evaluation_Chart.Label" bundle="${oh_labels}"/> 3 : <font color="white" size='2'><%=selected_val3%> </font>
				</td>
			<%}%>
			<%} else if(no_of_charts.equals("2")){
				if(eval_type.equals("BB")){
			%>
						<td class='PATIENTLINE1'>
					<fmt:message key="eOH.Baseline_Chart.Label" bundle="${oh_labels}"/> 1 : <font color="white" size='2'><%=selected_val1%> </font>
				</td>
				<td class='PATIENTLINE1'>
					<fmt:message key="eOH.Baseline_Chart.Label" bundle="${oh_labels}"/> 2 : <font color="white" size='2'><%=selected_val2%> </font>
				</td>
			<%} else if(eval_type.equals("BE")){ %>
				<td class='PATIENTLINE1'>
						<fmt:message key="eOH.Baseline_Chart.Label" bundle="${oh_labels}"/> : <font color="white" size='2'><%=selected_val1%> </font>
				</td>
				<td class='PATIENTLINE1'>
						<fmt:message key="eOH.Evaluation_Chart.Label" bundle="${oh_labels}"/> : <font color="white" size='2'><%=selected_val2%> </font>
				</td>
			<%} else if(eval_type.equals("EE")){%>
				<td class='PATIENTLINE1'>
						<fmt:message key="eOH.Evaluation_Chart.Label" bundle="${oh_labels}"/> 1 : <font color="white" size='2'><%=selected_val1%> </font>
				</td>
				<td class='PATIENTLINE1'>
						<fmt:message key="eOH.Evaluation_Chart.Label" bundle="${oh_labels}"/> 2 : <font color="white" size='2'><%=selected_val2%> </font>
				</td>
			<%}%>
			<td  class='PATIENTLINE1'></td>

			<%}%>
				<td class='PATIENTLINE1'></td>
		 </tr>	

	 <tr>
		 <td  class='PATIENTLINE1'></td>
		 <td  class='PATIENTLINE1'><fmt:message key="eOH.Compare.Label" bundle="${oh_labels}"/> :
		<%
		if(no_of_charts.equals("3")){
						if("BB".equals(eval_type)){
				%>
					<font color="white" size='2'>
						<fmt:message key="eOH.BaseLine1VsBaseLine2VsBaseLine3.Label" bundle="${oh_labels}"/>
						</font>
					</td>	
				<%}else if("BE".equals(eval_type)){%>
					<font color="white" size='2'>
						<fmt:message key="eOH.BaseLineVsEvaluation1VsEvaluation2.Label" bundle="${oh_labels}"/>
						</font>
					</td>
				<%} else if("EE".equals(eval_type)){%>
					<font color="white" size='2'>
						<fmt:message key="eOH.Evaluation1VsEvaluation2VsEvaluation3.Label" bundle="${oh_labels}"/>
						</font>
					</td>
				<%}%>
		<%}else if(no_of_charts.equals("2")){
				if("BB".equals(eval_type)){
		%>
					<font color="white" size='2'>
						<fmt:message key="eOH.BaselineVSBaseline.Label" bundle="${oh_labels}"/>  
						</font>
					</td>	
				<%}else if("BE".equals(eval_type)){%>
					<font color="white" size='2'>
						<fmt:message key="eOH.BaselineVSEvaluation.Label" bundle="${oh_labels}"/>
						</font>
					</td>
				<%} else if("EE".equals(eval_type)){%>
					<font color="white" size='2'>
						<fmt:message key="eOH.EvaluationVSBaseline.Label" bundle="${oh_labels}"/>
						</font>
					</td>
				<%}%>
		<%}%>
		</td>
		 <td  class='PATIENTLINE1'></td>
		 <td  class='PATIENTLINE1'></td>
		 </tr>
	 </body>
</html>

