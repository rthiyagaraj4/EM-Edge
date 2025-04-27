<!DOCTYPE html>
<html>

<%@page import="eXH.GatewayServiceBO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale = ((String) session.getAttribute("LOCALE"));
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

	System.out.println("sstyle g value....." + sStyle);
%>

<head>

<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' href='../../eXH/html/ViewEvents.css'
	type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/Gatewayinterface.css'
	type='text/css'></link>


<%
	Map<String, String> clientMap = null;
	Map<String, String> applicationMap = null;
	Map<String, String> facililtyMap = null;
	Map<Integer, String> paramMap = null;
	String communicationArray[] = new String[2];
	String selectedCommunimode = null;

	String clientID = null;
	String applicationID = null;
	String facilityID = null;
	clientID = (String) request.getAttribute("serverclientid");
	applicationID = (String) request.getAttribute("application");
	facilityID = (String) request.getAttribute("facility");

	communicationArray[0] = "Outbound";
	communicationArray[1] = "Inbound";

	applicationMap = (Map<String, String>) request
			.getAttribute("applicationmap");
	clientMap = (Map<String, String>) request.getAttribute("clientmap");
	facililtyMap = (Map<String, String>) request
			.getAttribute("facilitymap");
	selectedCommunimode = (String) request.getAttribute("comType");
	
	
	if(selectedCommunimode==null || selectedCommunimode=="")
	{
		selectedCommunimode="All";
	}
	
	pageContext.setAttribute("clientID", clientID);
	pageContext.setAttribute("applicationID", applicationID);
	pageContext.setAttribute("facilityID", facilityID);
	pageContext.setAttribute("selectedCommunimode", selectedCommunimode);
	pageContext.setAttribute("clientMap", clientMap);
	pageContext.setAttribute("applicationMap", applicationMap);
	pageContext.setAttribute("communicationArray", communicationArray);
%>


<script type="text/javascript" language="JAVASCRIPT"
	src="${pageContext.request.contextPath}/eCommon/js/jquery-3.6.3.js"></script>
<script type="text/javascript" language="JAVASCRIPT"
	src="${pageContext.request.contextPath}/eXH/js/GatewayInterfaceMonitor.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>

<script type="text/javascript">

function setComMode()
{
	document.getElementById("selectedcommunimode").value="<%=selectedCommunimode%>";
	document.getElementById("communicmode").value="<%=selectedCommunimode%>";
	document.getElementById("serverclientid").value="<%=clientID%>";
	document.getElementById("application").value="<%=applicationID%>";
	
	var formName = document.
	    getElementById("gatewayserverform");
		formName.target = 'gatewaytableframe';
		document.getElementById("frame").value = 'body';
		document.forms[0].action = '../servlet/eXH.CentralizedServlet';
		document.forms[0].submit();
	}

	function startBound() {
		document.getElementById("communicmode").value=document.getElementById("selectedcommunimode").value;
		parent.gatewaytableframe.document.gatewayserverTableform.gatewayoperation.value = 'start';
		parent.gatewaytableframe.document.gatewayserverTableform.submit();

	}

	function stopBound() {
		document.getElementById("communicmode").value=document.getElementById("selectedcommunimode").value;
		parent.gatewaytableframe.document.gatewayserverTableform.gatewayoperation.value = 'stop';
		parent.gatewaytableframe.document.gatewayserverTableform.submit();
	}
	
	function refresh() {
		document.getElementById("communicmode").value=document.getElementById("selectedcommunimode").value;
		document.gatewayserverform.gatewayoperation.value='refresh';
		document.gatewayserverform.submit();
	}

	function hotStateImage(obj) {
		obj.className = 'linkClass2';
	}

	function restorePrevState(obj) {
		obj.className = 'linkClass1';

	}
	
	
	function validateCheckboxHeader(opern) {
		alert('validatecheckbox');
		var validateString = "";
		if (parent.gatewaytableframe.document.gatewayserverTableform.gatewayservers.length != undefined) {
			for ( var a = 0; a < parent.gatewaytableframe.document.gatewayserverTableform.gatewayservers.length; a++) {
				if (parent.gatewaytableframe.document.gatewayserverTableform.gatewayservers[a].checked == true) {
					validateString = "checked";
					break;
				}
			}
			if (validateString == "checked" && opern == "start") {
				document.getElementById("communicmode").value = document
						.getElementById("selectedcommunimode").value;
				parent.gatewaytableframe.document.gatewayserverTableform.gatewayoperation.value = 'start';
				parent.gatewaytableframe.document.gatewayserverTableform
						.submit();
			} else if (validateString == "checked" && opern == "stop") {
				document.getElementById("communicmode").value = document
						.getElementById("selectedcommunimode").value;
				parent.gatewaytableframe.document.gatewayserverTableform.gatewayoperation.value = 'stop';
				parent.gatewaytableframe.document.gatewayserverTableform
						.submit();
			} else {
				alert("Please select any gateway server");
				return;
			}
		} else if (parent.gatewaytableframe.document.gatewayserverTableform.gatewayservers.length == undefined
				&& parent.gatewaytableframe.document.gatewayserverTableform.gatewayservers.checked == true) {
			if (opern == "start") {
				document.getElementById("communicmode").value = document
						.getElementById("selectedcommunimode").value;
				parent.gatewaytableframe.document.gatewayserverTableform.gatewayoperation.value = 'start';
				parent.gatewaytableframe.document.gatewayserverTableform
						.submit();
			} else if (opern == "stop") {
				document.getElementById("communicmode").value = document
						.getElementById("selectedcommunimode").value;
				parent.gatewaytableframe.document.gatewayserverTableform.gatewayoperation.value = 'stop';
				parent.gatewaytableframe.document.gatewayserverTableform
						.submit();

			}
		} else if (parent.gatewaytableframe.document.gatewayserverTableform.gatewayservers.length == undefined) {
			alert("Please select any gateway server");
			return;
		}
	}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




<style>
.COLUMNHEADER {
	BACKGROUND-COLOR: #404040;
	COLOR: white;
	FONT-SIZE: 8pt;
	font-weight: bolder;
}

TD.CAGROUP {
	FONT-FAMILY: VERDANA;
	FONT-SIZE: 8pt;
	BACKGROUND-COLOR: #83AAB4; /*----- Changed from #FFFFFFF -------*/
	COLOR: BLACK;
	FONT-WEIGHT: BOLDER
}

.CAGROUP {
	FONT-FAMILY: VERDANA;
	FONT-SIZE: 8pt;
	BACKGROUND-COLOR: #D5E2E5;
	COLOR: BLACK;
	FONT-WEIGHT: BOLDER
}

.linkClass1 {
	margin-left: 0;
	margin-right: 0;
	margin-top: 0;
	margin-bottom: 0;
	padding-left: 3px;
	padding-right: 3px;
	padding-top: 2px;
	padding-bottom: 1px;
	border-top: 0px;
}

TD.BUTTON {
	FONT-SIZE: 8pt;
	FONT-FAMILY: verdana;
	TEXT-ALIGN: RIGHT;
}

INPUT.BUTTON {
	height: 20px;
	font-family: verdana;
	COLOR: #000000;
	FONT-SIZE: 8pt;
}

TD.LABEL {
	COLOR: #444444;
	/*background-color:#FFFFFF;*/
	background-color: #FFFFFF;
	FONT-SIZE: 9pt;
	TEXT-ALIGN: LEFT;
	/*TEXT-ALIGN: RIGHT;*/
	PADDING-LEFT: 7px;
	PADDING-RIGHT: 7px
}

.label {
	COLOR: #444444;
	/*background-color:#FFFFFF;*/
	background-color: #FFFFFF;
	FONT-SIZE: 9pt;
	TEXT-ALIGN: LEFT;
	/*TEXT-ALIGN: RIGHT;*/
	PADDING-LEFT: 7px;
	PADDING-RIGHT: 7px
}

.FIELDS { /*background-color:#FFFFFF;*/
	background-color: #FFFFFF;
	COLOR: #000000;
	FONT-SIZE: 8pt;
	TEXT-ALIGN: LEFT
}

.linkClass2 {
	background-color: #FFFFFF;
	margin-left: 0;
	margin-right: 0;
	margin-top: 0;
	margin-bottom: 0;
	padding-left: 2px;
	padding-right: 2px;
	padding-top: 2px;
	padding-bottom: 1px;
	border-left: 1px solid;
	border-right: 1px solid;
	BORDER-COLOR: #75768B;
}
</style>
</head>

<BODY onload="setComMode();" style="margin-top: 0px; padding-top: 0px;">
	<form name="gatewayserverform" id="gatewayserverform" method="get">

		<%
	String chkDisp="block";
	String align="right";
	String isQueryOnly=(String)request.getAttribute("isQueryOnly");
	
	String queryDisplayParam="frame=header&isQueryOnly=true&clientID=CSCINDAE696239&processType=outbound";
    paramMap=(Map<Integer, String>)request.getAttribute("paramMap");
	request.getSession().setAttribute("paramMap", paramMap);
	
	if(isQueryOnly!=null && isQueryOnly=="true" )
	{
		chkDisp="none";
		align="center";
		
	}
	else
	{
		chkDisp="block";
		align="right";
	}
	%>
		<table cellspacing=0 cellpadding=1 border=0
			style="width: 100%; display: <%=chkDisp%>;">
			<tr style="height: 10pt;">
				<td class=label><fmt:message key="eXH.Gateway.Label"
						bundle="${xh_labels}" /> <select id="serverclientid"
					class='fields' name="serverclientid" id="serverclientid">
						<c:forEach var="gatewayclient" items="${clientMap}">
							<option style="font-size: 8pt;" value="${gatewayclient.key}">
								<c:out value="${gatewayclient.value}" />
							</option>
						</c:forEach>
				</select> <fmt:message key="eXH.CommMode.Label" bundle="${xh_labels}" /> <select id="selectedcommunimode" name="selectedcommunimode" id="selectedcommunimode" class='fields'>
						<c:forEach var="communicationmode" items="${communicationArray}">
							<option style="font-size: 8pt;" value="${communicationmode}">
								<c:out value="${communicationmode}" />
							</option>
						</c:forEach>
				</select> <fmt:message key="Common.Application.label"
						bundle="${common_labels}" /> <select name="application" id="application"
					class='fields'>
						<c:forEach var="appitems" items="${applicationMap}">
							<option style="font-size: 8pt;" value="${appitems.key}">
								<c:out value="${appitems.value}" />
							</option>
						</c:forEach>
				</select></td>
			</tr>

			<input type="hidden" name="gatewayoperation" id="gatewayoperation">
			<input type="hidden" value="header" name="frame" id="frame">

		</table>


		<input type="hidden" name="isQueryOnlyForTable" id="isQueryOnlyForTable"
			value="<%=isQueryOnly%>">

		<table id="indicatorTable" cellspacing=0 cellpadding=1 width='100%'>
			<tr>
				<TD align="<%=align%>" class="CAGROUP"><input class="CAGROUP"
					id="communicmode" type="text" name="communicmode" id="communicmode"
					style="color: black; text-align: center;" readonly="readonly">
				</TD>
				<td class='CAGROUP' align="right" style="display: <%=chkDisp%>;">
					<input class='BUTTON' type="button" TITLE="Refresh" value='Refresh'
					onClick="refresh();"> <input class='BUTTON' type="button"
					TITLE="Start" value='Start'
					onClick="validateCheckboxHeader('start');"> <input
					class='BUTTON' type="button" TITLE="Stop" value='Stop'
					onClick="validateCheckboxHeader('stop');">
				</td>
			</tr>
		</table>
	</form>
</BODY>
</html>

