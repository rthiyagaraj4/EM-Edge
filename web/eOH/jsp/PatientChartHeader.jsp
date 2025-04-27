<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page  contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");	
	String locale = (String) session.getValue( "LOCALE" ) ;
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String chart_num=checkForNull(request.getParameter("chart_num"));
	String chart_code=checkForNull(request.getParameter("chart_code"));
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
		<script type='text/javascript' src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body class="HEADER" OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
		<form name="header_form" id="header_form">
			<table class="HEADER" width="100%" cellpadding ="" cellspacing="">
				<tr class="HEADER">
					<td class="label" align="left" width="20%">
						<b><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp; : &nbsp; <%=patient_id%>	</b>
					</td>

					<td class="label" align="left" width="20%"><b>
						<fmt:message key="eOH.ChartNumber.Label" bundle="${common_labels}"/> &nbsp; : &nbsp; <%=chart_num%></b>
					</td>

					<td class="label" align="left" width="20%">
						<b><div id="datetime"></div></b>
					</td>
		  
					<td class="label" align="left" width="20%">
						<b><fmt:message key="eCA.ChartCode.label" bundle="${ca_labels}"/>&nbsp; : &nbsp; <%= chart_code %></b>
					</td>
				</tr>
			</table> 
		</form>
	</body>

	<script>
		var chart_date_label = getLabel("eOH.ChartDate.Label","OH"); 

		function displaydatetime(){
			var date_time = getCurrentDate("DMYHM","<%=locale%>");
			//document.getElementById("datetime").innerHTML = getCurrentDate("DMYHM","<%=locale%>");	
			document.getElementById("datetime").innerHTML = '<b>'+chart_date_label+'&nbsp; : &nbsp;'+date_time;	
		}

		window.setInterval("displaydatetime()", "60000");
		displaydatetime();
	</script>

</html>

