<!DOCTYPE html>
<%@page import="eXH.GatewayServiceBO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
	request.setCharacterEncoding("UTF-8");
	String locale = ((String) session.getAttribute("LOCALE"));
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	System.out.println("sstyle value....." + sStyle);
%>

<HEAD>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/ViewEvents.css'
	type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/Gatewayinterface.css'
	type='text/css'></link>

<%
	Map<Integer, GatewayServiceBO> boundMap = null;
	String selectedCommunimode = null;
	String clientID = null;
	String applicationID = null;
	String facilityID = null;
	String queryString = null;

	String refreshTimeArray[] = new String[2];

	refreshTimeArray[0] = "After 5 seconds";
	refreshTimeArray[1] = "Refresh Now";

	boundMap = (Map<Integer, GatewayServiceBO>) request
			.getAttribute("boundmap");
	queryString = (String) request.getAttribute("queryString");
	pageContext.setAttribute("boundMap", boundMap);
	pageContext.setAttribute("refreshTimeArray", refreshTimeArray);
	pageContext.setAttribute("queryString", queryString);
%>

<script type="text/javascript" language="JAVASCRIPT"
	src="${pageContext.request.contextPath}/eCommon/js/jquery-3.6.3.js"></script>
<script type="text/javascript" language="JAVASCRIPT"
	src="${pageContext.request.contextPath}/eXH/js/GatewayInterfaceMonitor.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>


<style type="text/css">
.COLUMNHEADER {
	BACKGROUND-COLOR: #83AAB4;
	COLOR: white;
	FONT-SIZE: 8pt;
	font-weight: bolder;
}

#mytable {
	width: 100%;
	overflow: scroll;
}

#bottomtabletr {
	font-size: 0.8em;
}

.QRYEVEN {
	BACKGROUND-COLOR: #FFFFFF;
	FONT-SIZE: 8pt;
	BORDER-STYLE: SOLID;
	border-left-color: #D5E2E5;
	border-right-color: #D5E2E5;
	border-top-color: #D5E2E5;
	border-bottom-color: #D5E2E5;
	height: 14;
	text-align: LEFT;
}

.QRYODD {
	FONT-SIZE: 9pt;
	BACKGROUND-COLOR: #FFFFFF;
	BORDER-STYLE: SOLID;
	border-left-color: #D5E2E5;
	border-right-color: #D5E2E5;
	border-top-color: #D5E2E5;
	border-bottom-color: #D5E2E5;
	height: 18;
	text-align: LEFT;
}

.FIELDS { /*background-color:#FFFFFF;*/
	background-color: #FFFFFF;
	COLOR: #000000;
	FONT-SIZE: 8pt;
	TEXT-ALIGN: LEFT
}

.divstyle {
	border: 5px gray solid;
}
</style>

<script type="text/javascript">
	function refreshNow() {
		var querystring = document.getElementById("queryString").value;
		location.href = "../servlet/eXH.CentralizedServlet?" + querystring;

	}

	function quitNow() {
		window.close();
	}

	function after5secs() {
		var querystring = document.getElementById("queryString").value;

		if (document.getElementById("refreshtime").value == "After 5 seconds") {
			setInterval(function() {
				location.href = "../servlet/eXH.CentralizedServlet?"
						+ querystring;
			}, 5000);

		} else if (document.getElementById("refreshtime").value == "Refresh Now") {
			location.href = "../servlet/eXH.CentralizedServlet?" + querystring;
}
}

</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




</head>

<BODY style="margin-top: 0px; padding-top: 0px;" onload="after5secs();">
	<form name="gatewayserverTableform" id="gatewayserverTableform" id="gatewayserverTableform">

		<table id="indicatorTable" cellspacing=0 cellpadding=1 width='100%'>
			<tr align="right">
				<TD><select id="refreshtime" name="refreshtime" id="refreshtime"
					style="background-color: #FFFFFF; color: #000000; font-size: 8pt; text-align: LEFT; width: 200px;"
					onchange="after5secs();">
						<c:forEach var="communicationmode" items="${refreshTimeArray}">
							<option style="font-size: 6pt;" value="${communicationmode}">
								<c:out value="${communicationmode}" />
							</option>
						</c:forEach>
				</select> <input type="button" TITLE="Refresh" value='Refresh'
					style="height: 20px; font-family: verdana; COLOR: #000000; FONT-SIZE: 8pt;"
					onclick="refreshNow();"> <input
					style="height: 20px; font-family: verdana; COLOR: #000000; FONT-SIZE: 8pt;"
					type="button" TITLE="Quit" value='Quit' onclick="quitNow();"></TD>

			</tr>
		</table>


		<div style="display:block; border: medium; overflow-y:scroll;overflow-x:no;" >
			<table id="mytable" cellspacing=0 cellpadding=0 border=1
				style="margin-top: 0px; padding-top: 0px;" width='100%'>
				<thead style="text-align: left; font-size: 10pt;">
					<tr>
						<th nowrap class='COLUMNHEADER'>&nbsp;&nbsp;$&nbsp;&nbsp;</th>
						<th nowrap class='COLUMNHEADER'>&nbsp;&nbsp;#&nbsp;&nbsp;</th>
						<th nowrap class='COLUMNHEADER'>Process</th>
						<th nowrap class='COLUMNHEADER'>Gateway Server</th>
						<th nowrap class='COLUMNHEADER'>Application</th>
						<th nowrap class='COLUMNHEADER'>Gateway</th>
						<th nowrap class='COLUMNHEADER'>Retries</th>
						<th nowrap class='COLUMNHEADER'>Last Comm Time</th>
						<th nowrap class='COLUMNHEADER'>Last Msg Id</th>
						<th nowrap class='COLUMNHEADER'>Total Messages</th>
						<th nowrap class='COLUMNHEADER'>Communication Type</th>
						<th nowrap class='COLUMNHEADER'>Start Date Time</th>
						<th nowrap class='COLUMNHEADER'>Started By</th>
						<th nowrap class='COLUMNHEADER'>End Date Time</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="mapObject" items="${boundMap}">
						<tr>
							<input type="hidden" id="gatewayserverID" name="gatewayserverID" id="gatewayserverID">
							<td align="center"><img
								src="${pageContext.request.contextPath}${mapObject.value.status}"
								align="middle" height=10
								onclick="document.getElementById('gatewayserverID').value=${mapObject.key};showModal();">
							</td>
							<td align="center"><img
								src="${pageContext.request.contextPath}${mapObject.value.commStatus}"
								align="middle" height=10></td>
							<td nowrap class='QRYEVEN'>&nbsp;${mapObject.value.processID}</td>
							<td nowrap class='QRYEVEN'>&nbsp;
								${mapObject.value.clientName}</td>
							<td nowrap class='QRYEVEN'>&nbsp;
								${mapObject.value.applicationName}</td>
							<td nowrap class='QRYEVEN'>&nbsp;
								${mapObject.value.protocolLinkName}</td>
							<td nowrap class='QRYEVEN'>&nbsp;
								${mapObject.value.numOfRetries}</td>
							<td nowrap class='QRYEVEN'>&nbsp;
								${mapObject.value.lastCommDateTime}</td>
							<td nowrap class='QRYEVEN'>&nbsp;
								${mapObject.value.lastMsgId}</td>
							<td nowrap class='QRYEVEN'>&nbsp;
								${mapObject.value.totalMsgs}</td>
							<td nowrap class='QRYEVEN'>&nbsp;
								${mapObject.value.protocolType}</td>
							<td nowrap class='QRYEVEN'>&nbsp;
								${mapObject.value.startDateTime}</td>
							<td nowrap class='QRYEVEN'>&nbsp;
								${mapObject.value.startedBy}</td>
							<td nowrap class='QRYEVEN'>&nbsp;
								${mapObject.value.stopDateTime}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<input type="hidden" name="frame" id="frame" value="body"> <input type="hidden" name="isQueryOnly" id="isQueryOnly" value="true"> <input type="hidden" id="queryString" name="queryString" id="queryString"
			value="<%=queryString%>">

	</form>
</BODY>
</html>

