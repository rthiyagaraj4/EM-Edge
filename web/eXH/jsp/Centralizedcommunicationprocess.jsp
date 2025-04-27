<!DOCTYPE html>
<%@page import="eXH.GatewayServiceBO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gateway single Record</title>

<script type="text/javascript" language="JAVASCRIPT"
	src="${pageContext.request.contextPath}/eCommon/js/jquery-3.6.3.js"></script>
<script src='${pageContext.request.contextPath}/eCommon/js/showModalDialog.js' language='JavaScript'></script>


<link rel='StyleSheet' href='${pageContext.request.contextPath}/eCommon/html/<%=sStyle%>'
	type='text/css'></link>
	
<style type="text/css">

.COLUMNHEADER {
	BACKGROUND-COLOR: #83AAB4;
	COLOR: white;
	FONT-SIZE: 8pt;
	font-weight: bolder;
}

</style>


</head>
<body>
	<form name="gatewayserverform" id="gatewayserverform"
		action="../servlet/eXH.CentralizedServlet" method="get">

		<%
		List<GatewayServiceBO> boundList=new ArrayList<GatewayServiceBO>();
		String noResultDisp="none";
		String chkDisp="block";
		
		boundList = (List<GatewayServiceBO>) request
					.getAttribute("commprocesslist");
		
		if(boundList!=null && boundList.size()>0)
		{
			chkDisp="block";
			noResultDisp="none";
		}
		else
		{
			chkDisp="none";
			noResultDisp="block";
		}
			pageContext.setAttribute("boundList", boundList);
			pageContext.setAttribute("chkDisp", chkDisp);
			pageContext.setAttribute("noResultDisp", noResultDisp);

		%>
<div style="display:block; border: medium; overflow-y:scroll;overflow-x:no;" >
		<table id="mytable" cellspacing=0 cellpadding=2 style="margin-top: 0px; padding-top: 0px; height: 100%; width: 100%; display:<%=chkDisp %>;"
			border="1" height="100">
			<thead style="text-align: left;">
				<tr>
					<th nowrap class='COLUMNHEADER'><font color=white> status </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> Process status </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> Process </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> ProcessType </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> Application </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> Gateway </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> CommunicationClient </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> StartDateTime </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> EndDateTime </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> LastOutboundRetries </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> LastCommunicationTime </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> LastMsgId </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> TotalMessages </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> TotalQueries </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> StartedBy </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> StoppedBy </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> AddedWorkStation </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> ModifiedWorkStation </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> AddedFacility </font></th>
					<th nowrap class='COLUMNHEADER'><font color=white> ModifiedFacility </font></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listObject" items="${boundList}"
					varStatus="loopStatus">
					<tr>
						<td align="center">
							<img
							src="${pageContext.request.contextPath}${listObject.status}"
							align="middle" height=10 >
							</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.commStatus}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.processID}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.comType}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.applicationName}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.protocolLinkName}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.clientName}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.startDateTime}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.stopDateTime}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.numOfRetries}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.lastCommDateTime}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.lastMsgId}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.totalMsgs}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.totalQueries}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.startedBy}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.stoppedBy}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.addedWorkStation}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.modifiedWorkStation}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.addFacility}</td>
						<td nowrap class="QRYEVEN"><font size=1> ${listObject.modifiedFacility}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
		<table id="norecordtable"
			style="width: 100%; display:<%=noResultDisp %>;">
			<tr align="center">
				<td align="center"><br> <br> <br> <b> <label>Query
							caused no records to be retrived!!!!</label></b></td>
			</tr>
		</table>
	</form>
</body>
</html>

