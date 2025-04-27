<!DOCTYPE html>
<HTML>

<%@page import="eXH.GatewayServiceBO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<HEAD>
<link rel='StyleSheet' href='${pageContext.request.contextPath}/eCommon/html/<%=sStyle%>'
	type='text/css'></link>

<%
			Map<Integer,GatewayServiceBO> boundMap=null;
			String selectedCommunimode=null;
			String clientID=null;
			String applicationID=null;
			String facilityID=null;
			String chkDisp="block";
			String noResultDisp="none";
			String checkboxDisp="block";
			String optionTab="none";
			String refreshAuto="";
			String isQueryOnlyForTab=null;
			String facilityIDD=null;
			String startDateTime=null;
			String stopDateTime=null;
			String processStatus=null;
			String startedByID=null;
			String stoppedByID=null;
			String addedWorkStation=null;
			String modifiedWS=null;
			String modifiedFacilityID=null;
			String protocolLink=null;
			String commStatus=null;
			String applicationIDD=null;
			String processType=null;
			String addedFacilityID=null;
			String clientIDD=null;
			String queryString = null;
			String startedWSNo=null;
			String refreshTimeArray[] = new String[3];
			String showModal="showModal()";

			refreshTimeArray[0] = "After 5 seconds";
			refreshTimeArray[1] = "Refresh Now";
			refreshTimeArray[2] = "Manual";
			
			
			clientID = (String)request.getAttribute("serverclientid");
			applicationID = (String)request.getAttribute("application");
			facilityID = (String)request.getAttribute("facility");
			selectedCommunimode=(String)request.getAttribute("comType");
			boundMap = (Map<Integer, GatewayServiceBO>) request
					.getAttribute("boundmap");
			isQueryOnlyForTab=(String)request.getAttribute("isQueryOnlyForTable");
			
			if(isQueryOnlyForTab!=null && "true".equalsIgnoreCase(isQueryOnlyForTab))
			{
				
				String isQueryOnlyManual=(String)request.getAttribute("isQueryOnlyManual");
				
				checkboxDisp="none";
				optionTab="block";
				showModal="";
				
				if("manual".equalsIgnoreCase(isQueryOnlyManual))
				{
				refreshAuto="setManual()";
				}
				else
				{
					refreshAuto="after5secs()";
				}
				
				facilityIDD= (request.getAttribute("facilityID")!=null) ? (String)request.getAttribute("facilityID") : "*";
				pageContext.setAttribute("facilityIDD",facilityIDD );
				
				startDateTime=(request.getAttribute("startDateTime")!=null) ? (String)request.getAttribute("startDateTime") : "*";
				pageContext.setAttribute("startDateTime", startDateTime);
				
				stopDateTime=(request.getAttribute("stopDateTime")!=null) ? (String)request.getAttribute("stopDateTime") : "*";
				pageContext.setAttribute("stopDateTime", stopDateTime);
				
				processStatus=(request.getAttribute("processStatus")!=null) ? (String)request.getAttribute("processStatus") : "*";
				pageContext.setAttribute("processStatus",processStatus);
				
				startedByID=(request.getAttribute("startedByID")!=null) ? (String)request.getAttribute("startedByID") : "*";
				pageContext.setAttribute("startedByID", startedByID);
				
				stoppedByID=(request.getAttribute("stoppedByID")!=null) ? (String)request.getAttribute("stoppedByID") : "*";
				pageContext.setAttribute("stoppedByID", stoppedByID);
				
				addedWorkStation=(request.getAttribute("addedWorkStation")!=null) ? (String)request.getAttribute("addedWorkStation") : "*";
	            pageContext.setAttribute("addedWorkStation",addedWorkStation);
				
	            modifiedWS=(request.getAttribute("modifiedWS")!=null) ? (String)request.getAttribute("modifiedWS") : "*";
				pageContext.setAttribute("modifiedWS",modifiedWS);
				
				modifiedFacilityID=(request.getAttribute("modifiedFacilityID")!=null) ? (String)request.getAttribute("modifiedFacilityID") : "*";
				pageContext.setAttribute("modifiedFacilityID",modifiedFacilityID);
				
				protocolLink=(request.getAttribute("protocolLink")!=null) ? (String)request.getAttribute("protocolLink") : "*";
				pageContext.setAttribute("protocolLink",protocolLink);
				
				commStatus=(request.getAttribute("commStatus")!=null) ? (String)request.getAttribute("commStatus") : "*";
	            pageContext.setAttribute("commStatus",commStatus);
				
	            applicationIDD=(request.getAttribute("applicationID")!=null) ? (String)request.getAttribute("applicationID") : "";
				pageContext.setAttribute("applicationIDD",applicationIDD);
				
				processType=(request.getAttribute("processType")!=null) ? (String)request.getAttribute("processType") : "";
				pageContext.setAttribute("processType",processType);
				
				addedFacilityID=(request.getAttribute("addedFacilityID")!=null) ? (String)request.getAttribute("addedFacilityID") : "*";
				pageContext.setAttribute("addedFacilityID",addedFacilityID);
				
				clientIDD=(request.getAttribute("clientID")!=null) ? (String)request.getAttribute("clientID") : "";
				pageContext.setAttribute("clientIDD",clientIDD);
				
				startedWSNo=(request.getAttribute("startedWSNo")!=null) ? (String)request.getAttribute("startedWSNo") : "";
				pageContext.setAttribute("startedWSNo",startedWSNo);
			}
			else
			{
				checkboxDisp="block";
				optionTab="none";
				refreshAuto="";
			}
			
			if(boundMap!=null && boundMap.size()>0)
			{
				chkDisp="block";
				noResultDisp="none";
			}
			else
			{
				chkDisp="none";
				noResultDisp="block";
			}
			pageContext.setAttribute("boundMap", boundMap);
			pageContext.setAttribute("clientID", clientID);
			pageContext.setAttribute("applicationID", applicationID);
			pageContext.setAttribute("facilityID", facilityID);
			pageContext.setAttribute("selectedCommunimode", selectedCommunimode);
			pageContext.setAttribute("checkboxDisp", checkboxDisp);
			pageContext.setAttribute("chkDisp", chkDisp);
			pageContext.setAttribute("refreshAuto", refreshAuto);
			pageContext.setAttribute("optionTab", optionTab);
			pageContext.setAttribute("noResultDisp", noResultDisp);
			pageContext.setAttribute("refreshTimeArray", refreshTimeArray);
			pageContext.setAttribute("queryString", queryString);
			pageContext.setAttribute("showModal", showModal);
		%>
<script type="text/javascript" language="JAVASCRIPT"
	src="${pageContext.request.contextPath}/eCommon/js/jquery-3.6.3.js"></script>
<script type="text/javascript" language="JAVASCRIPT"
	src="${pageContext.request.contextPath}/eXH/js/GatewayInterfaceMonitor.js"></script>
<script language='javascript' src='${pageContext.request.contextPath}/eCommon/js/ValidateControl.js'></script>
<script src='${pageContext.request.contextPath}/eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style type="text/css">

.COLUMNHEADER {
	background-position:right;
	COLOR: white ;
	text-align: left;
	background-color:#83AAB4;
	padding-left:0px;
	font-family: Verdana;
	font-size: 8pt;
	font-weight:bold;
	border-collapse:collapse; 
}
</style>

<script type="text/javascript">
	function refreshNow() {
		window.name = 'myModal';
		var formName = document.getElementById("gatewayserverTableform");
		formName.target = 'myModal';
		document.getElementById("frame").value = "body";
		document.getElementById("isQueryOnly").value = "true";
		document.forms[0].action = '../servlet/eXH.CentralizedServlet';
		document.forms[0].submit();
	}

	function quitNow() {
		window.close();
	}
	
	function setManual()
	{
		document.getElementById("refreshtime").value="Manual";
		
	}

	
	function after5secs() {
		if (document.getElementById("refreshtime").value == "After 5 seconds") {
			setInterval(function() {
				window.name = 'myModal';
				var formName = document.getElementById("gatewayserverTableform");
				formName.target = 'myModal';
				document.getElementById("frame").value = "body";
				document.getElementById("isQueryOnly").value = "true";
				document.forms[0].action = '../servlet/eXH.CentralizedServlet';
				document.forms[0].submit();
			}, 5000);

		} else if (document.getElementById("refreshtime").value == "Refresh Now") {
			window.name = 'myModal';
			var formName = document.getElementById("gatewayserverTableform");
			formName.target = 'myModal';
			document.getElementById("frame").value = "body";
			document.getElementById("isQueryOnly").value = "true";
			document.forms[0].action = '../servlet/eXH.CentralizedServlet';
			document.forms[0].submit();
}
		
		else if (document.getElementById("refreshtime").value == "Manual") {
			window.name = 'myModal';
			var formName = document.getElementById("gatewayserverTableform");
			formName.target = 'myModal';
			document.getElementById("frame").value = "body";
			document.getElementById("isQueryOnly").value = "true";
			document.getElementById("isQueryOnlyManual").value = "manual";
			document.forms[0].action = '../servlet/eXH.CentralizedServlet';
			document.forms[0].submit();
}
}

</script>


</head>
<BODY style="margin-top: 0px; padding-top: 0px;" onload="<%=refreshAuto%>"  onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >

	<form name="gatewayserverTableform" id="gatewayserverTableform" target="gatewaytableframe">
		<table id="indicatorTable" cellspacing=0 cellpadding=1 width='100%'
			style="display:<%=optionTab %>;">
			<tr align="right">
				<TD><select id="refreshtime" name="refreshtime" id="refreshtime"
					style="background-color: #FFFFFF; color: #000000; font-size: 8pt; text-align: LEFT; width: 200px;"
					onchange="after5secs();">
						<c:forEach var="communicationmode" items="${refreshTimeArray}">
							<option style="font-size: 6pt;" value="${communicationmode}">
								<c:out value="${communicationmode}" />
							</option>
						</c:forEach>
				</select> <input  class="BUTTON" type="button" TITLE="Refresh" value='Refresh'
					onclick="refreshNow();"> <input class="BUTTON"
					type="button" TITLE="Quit" value='Quit' onclick="quitNow();">
					
					</TD>
			</tr>
		</table>

		<table id="mytable" cellspacing=0 cellpadding=0 border=1
			style="margin-top: 0px;width: 100%; overflow: scroll; padding-top: 0px;   display:<%=chkDisp %>;" >
			<thead>
				<tr>
					<th style="height: 2pt; width: 2pt; display: <%=checkboxDisp %>;"><input type="checkbox" onchange="checkBoxChecked()"
						onclick="checkBoxChecked()" id="mastercheckbox"
						name="mastercheckbox" id="mastercheckbox"></th>
					<th nowrap class='COLUMNHEADER' ><font color=white>&nbsp;&nbsp;$&nbsp;&nbsp;</font></th>
					<th nowrap class='COLUMNHEADER'><font color=white>&nbsp;&nbsp;#&nbsp;&nbsp;</font></th>
					<th nowrap class='COLUMNHEADER'><font color=white><fmt:message key="Common.Process.label" bundle="${common_labels}"/></font></th>
					<th nowrap class='COLUMNHEADER'><font color=white><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/>Server</font></th>
					<th nowrap class='COLUMNHEADER'><font color=white><fmt:message key="Common.Application.label" bundle="${common_labels}"/></font></th>
					<th nowrap class='COLUMNHEADER'><font color=white><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></font></th>
					<th nowrap class='COLUMNHEADER'><font color=white><fmt:message key="eXH.Retries.Label" bundle="${xh_labels}"/></font></th>
					<th nowrap class='COLUMNHEADER'><font color=white><fmt:message key="eXH.LastCommnTime.Label" bundle="${xh_labels}"/></font></th>
					<th nowrap class='COLUMNHEADER'><font color=white><fmt:message key="eXH.LastMessageID.Label" bundle="${xh_labels}"/></font></th>
					<th nowrap class='COLUMNHEADER'><font color=white><fmt:message key="eXH.TotalMessages.Label" bundle="${xh_labels}"/></font></th>
					<th nowrap class='COLUMNHEADER'><font color=white><fmt:message key="eXH.CommType.Label" bundle="${xh_labels}"/></font></th>
					<th nowrap class='COLUMNHEADER'><font color=white><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></font></th>
					<th nowrap class='COLUMNHEADER'><font color=white><fmt:message key="eXH.StartedbyID.Label" bundle="${xh_labels}"/></font></th>
					<th nowrap class='COLUMNHEADER'><font color=white><fmt:message key="eXH.StartedWSNO.Label" bundle="${xh_labels}"/></font></th>
					<th nowrap class='COLUMNHEADER'><font color=white><fmt:message key="Common.EndDateTime.label" bundle="${common_labels}"/></font></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="mapObject" items="${boundMap}">
					<tr>
						<td align="center"
							style="height: 2pt;width: 2pt;display: <%=checkboxDisp %>;"><input type="checkbox" id="gatewayservers" name="gatewayservers" id="gatewayservers"
							value="${mapObject.key}"></td>

						<td align="center"><img
							src="${pageContext.request.contextPath}${mapObject.value.status}"
							align="middle" height=10>
						</td>
						<td align="center"><img
							src="${pageContext.request.contextPath}${mapObject.value.commStatus}"
							align="middle" height=10></td>
						<td nowrap class='QRYEVEN'><font size=1> &nbsp;${mapObject.value.processID}  </td>
						<td nowrap class='QRYEVEN'><font size=1> &nbsp; 
							${mapObject.value.clientName}</td>
						<td nowrap class='QRYEVEN'><font size=1> &nbsp;
							${mapObject.value.applicationName} </td>
						<td nowrap class='QRYEVEN'><font size=1> &nbsp;
							${mapObject.value.protocolLinkName} </td>
						<td nowrap class='QRYEVEN'><font size=1> &nbsp;
							${mapObject.value.numOfRetries}  </td>
						<td nowrap class='QRYEVEN'><font size=1> &nbsp;
							${mapObject.value.lastCommDateTime}  </td>
						<td nowrap class='QRYEVEN'><font size=1>  &nbsp;
							${mapObject.value.lastMsgId}  </td>
						<td nowrap class='QRYEVEN'><font size=1>  &nbsp;
							${mapObject.value.totalMsgs} </td>
						<td nowrap class='QRYEVEN'><font size=1> &nbsp;
							${mapObject.value.protocolType}  </td>
						<td nowrap class='QRYEVEN'><font size=1> &nbsp;
							${mapObject.value.startDateTime}</td>
						<td nowrap class='QRYEVEN'><font size=1> &nbsp;
							${mapObject.value.startedBy}  </td>
						<td nowrap class='QRYEVEN'><font size=1> &nbsp;
							${mapObject.value.startedWSNo}  </td>
						<td nowrap class='QRYEVEN'><font size=1> &nbsp;
							${mapObject.value.stopDateTime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<table id="norecordtable"
			style="width: 100%; display:<%=noResultDisp %>;">
			<tr align="center">
				<td align="center"><br> <br> <br> <b> <label
						style="text-align: center;">Query caused no records to be
							retrived!!!!</label></b></td>
			</tr>
		</table>

		<input type="hidden" id="gatewayserverID" name="gatewayserverID" id="gatewayserverID">
		
		<input type="hidden" name="selectedcommunimode" id="selectedcommunimode"
			id="selectedcommunimode" value="<%=selectedCommunimode%>">
			
			 <input type="hidden" id="serverclientid" name="serverclientid" id="serverclientid"
			value="<%=clientID%>"> 
			
			<input id="application" type="hidden"
			name="application" id="application" value="<%=applicationID%>"> 
			
			<input type="hidden" id="facility" name="facility" id="facility" value="<%=facilityID%>">
		<input type="hidden" name="gatewayoperation" id="gatewayoperation"> 
		
			 <input type="hidden" id="frame" name="frame" id="frame"
			value="header">
			
			<%
			if(isQueryOnlyForTab!=null && "true".equalsIgnoreCase(isQueryOnlyForTab))
			{
			%>
			
			<input type="hidden" id="isQueryOnly" name="isQueryOnly" id="isQueryOnly" >
			<input type="hidden" id="isQueryOnlyManual" name="isQueryOnlyManual" id="isQueryOnlyManual" >
			
			<input type="hidden" id="facilityID" name="facilityID" id="facilityID" value="<%=facilityIDD%>" >
			<input type="hidden" id="start_dateTime" name="start_dateTime" id="start_dateTime" value="<%=startDateTime%>" >
			<input type="hidden" id="stop_dateTime" name="stop_dateTime" id="stop_dateTime" value="<%=stopDateTime%>" >
			<input type="hidden" id="processStatus" name="processStatus" id="processStatus" value="<%=processStatus%>">
			<input type="hidden" id="startedByID" name="startedByID" id="startedByID" value="<%=startedByID%>">
			<input type="hidden" id="stoppedByID" name="stoppedByID" id="stoppedByID" value="<%=stoppedByID%>">
			<input type="hidden" id="addedWorkStation" name="addedWorkStation" id="addedWorkStation" value="<%=addedWorkStation%>">
			<input type="hidden" id="addedFacilityID" name="addedFacilityID" id="addedFacilityID" value="<%=addedFacilityID%>">
			<input type="hidden" id="modifiedWorkstation" name="modifiedWorkstation" id="modifiedWorkstation" value="<%=modifiedWS%>">
			<input type="hidden" id="modifiedFacilityID" name="modifiedFacilityID" id="modifiedFacilityID" value="<%=modifiedFacilityID%>">
			<input type="hidden" id="protocolLink" name="protocolLink" id="protocolLink" value="<%=protocolLink%>">
			<input type="hidden" id="commStatus" name="commStatus" id="commStatus" value="<%=commStatus%>">
			<input type="hidden" id="applicationID" name="applicationID" id="applicationID" value="<%=applicationIDD%>">
			<input type="hidden" id="processType" name="processType" id="processType" value="<%=processType%>">
			<input type="hidden" id="clientID" name="clientID" id="clientID" value="<%=clientIDD%>">
			<input type="hidden" id="startedWSNo" name="startedWSNo" id="startedWSNo" value="<%=startedWSNo%>">
			
			<%
			}
			%>
	</form>
</BODY>
</html>

