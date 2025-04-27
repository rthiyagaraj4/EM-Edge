<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	String splChartType = request.getParameter("splChartType") == null ? "" : request.getParameter("splChartType");
	String noOfChkdBoxes = request.getParameter("numOfchkedBoxes") == null ? "" : request.getParameter("numOfchkedBoxes");
	String noOfGroups = request.getParameter("noOfGroups") == null ? "1" : request.getParameter("noOfGroups"); 

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<html>
	<head>
		<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
		<form name='grpTabsForm' id='grpTabsForm'>
			<table  width='100%' border='0' align='left' cellspacing='0' cellpadding='0'>
				<tr>
					<td align='left' class='BODYCOLORFILLED'>
						<%if((!splChartType.equals("") && !noOfChkdBoxes.equals("") && !noOfChkdBoxes.equals("0")) || (splChartType.equals(""))){%>
						<input type='button' name='grpEvents' id='grpEvents' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RegularGraph.label","ca_labels")%>' onclick="tab_click('grouping')" class='button'>
						<%}%>
						<% if(!splChartType.equals("")){%>
							<input type='button' name='splGraph' id='splGraph' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialGraph.label","ca_labels")%>' onclick="tab_click('splChart')" class='button'>
						<%}%>
					</td> 
				</tr>
			</table>
			<input type='hidden' name='qryStr' id='qryStr' value='<%=queryString%>'>
			<input type='hidden' name='noOfGroups' id='noOfGroups' value='<%=noOfGroups%>'>
		</form>
	</body>
</html>

