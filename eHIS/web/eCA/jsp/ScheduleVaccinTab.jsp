<!DOCTYPE html>

<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
 <%
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String qryString = request.getQueryString();
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String locn_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String location_type = ""; //request.getParameter("location_type")==null?"":request.getParameter("location_type");
//	String locale = request.getParameter("locale")==null?"":request.getParameter("locale");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String taskSelect = "M";
	String taskSelectAll = "CA_TASK_LIST_BLDCONS~A||CA_TASK_LIST_INT~A||CA_TASK_LIST_MSPECI~A||CA_TASK_LIST_REGORD~A||CA_TASK_LIST_RESREP~A||CA_TASK_LIST_MEDADMN~A";
	String OrderCategory = "PH";
	String ckhDue = "Y";
	String chkOverdue = "N";
	String chkElapsed = "N";
	String chkPerformed = "N";
	String chkFuture = "Y";
	String chkReg = "N";
	String chkUnclassify = "N";
	String status_code ="";
	String Groupby ="T";
	String taskListFlag="T";
	String OrderType="";
	StringBuffer qry_string = new StringBuffer();	
	qry_string.append("callFrom=IM");	
	qry_string.append("&patient_id="+patient_id);	
	qry_string.append("&locn_code="+locn_code);
	qry_string.append("&location_type="+location_type);	
	qry_string.append("&status_code="+status_code);
	qry_string.append("&taskSelect="+taskSelect);
	qry_string.append("&OrderCategory="+OrderCategory);	
	qry_string.append("&OrderType="+OrderType);	
	qry_string.append("&Groupby="+Groupby);		
	qry_string.append("&ckhDue="+ckhDue);
	qry_string.append("&chkOverdue="+chkOverdue);
	qry_string.append("&chkElapsed="+chkElapsed);
	qry_string.append("&chkPerformed="+chkPerformed);
	qry_string.append("&chkFuture="+chkFuture);
	qry_string.append("&chkReg="+chkReg);
	qry_string.append("&chkUnclassify="+chkUnclassify);
	qry_string.append("&taskListFlag="+taskListFlag);
	qry_string.append("&taskSelectAll="+taskSelectAll);	
	qry_string.append("&encounter_id="+encounter_id);	
	qry_string.append("&patient_class="+patient_class);	


	
 %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
        <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script src='../js/ScheduleForVacination.js' language='javascript'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<SCRIPT LANGUAGE="JavaScript">
		function dfltTab()
		{
			document.getElementById("PendingRx_tab").className = "tabA";
			document.getElementById("PendingRx_tabspan").className = "tabAspan";
			prevTabObj="Immuni_tab";
		}

		function tabClickImmuni(id)
		{
			selectTab(id);
			parent.parent.ExistScheduleDetailFrame.location.href= 'ScheduleVaccinTabResultMain.jsp?<%=qryString%>';
			parent.parent.VaccinationFrame.VaccinAdminDetailsFrame.location.href='../../eCommon/html/blank.html';
			parent.parent.VaccinationFrame.VaccineAdminTabFrame.location.href='../../eCommon/html/blank.html';
		}

		function tabClickPendingRx(id)
		{
			selectTab(id);
		//	http://indbgl-app25:8899/eHIS/eCA/jsp/TaskListRightResult.jsp?locn_desc=&locn_code=CL34&location_type=&patient_id=HC00003934&status_code=TASK_ALL&taskSelect=&OrderCategory=&OrderType=&Groupby=P&To_date=8/09/2009&From_date=8/09/2009&pat_discharge=&chkAll=N&ckhDue=Y&chkOverdue=Y&chkElapsed=N&chkPerformed=N&chkFuture=N&chkReg=&taskListFlag=P&taskSelectAll=CA_TASK_LIST_BLDCONS~A||CA_TASK_LIST_INT~A||CA_TASK_LIST_MSPECI~A||CA_TASK_LIST_REGORD~A||CA_TASK_LIST_RESREP~A||CA_TASK_LIST_MEDADMN~A&AdminRoute=&chkUnclassify=Y&time_chk=false
			parent.VaccineTabResult.location.href="../../eCA/jsp/ScheduleVaccinPendingRxForMARMain.jsp?<%=qry_string.toString()%>";
			parent.parent.VaccinationFrame.VaccinAdminDetailsFrame.location.href='../../eCommon/html/blank.html';
			parent.parent.VaccinationFrame.VaccineAdminTabFrame.location.href='../../eCommon/html/blank.html';

		}


		</SCRIPT>


		<title></title>
	</head>

	<body onLoad="dfltTab()" onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
		<form>
			<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
		<tr>
			<td width= "100%" class="white">
				<ul id="tablist" class="tablist" style="padding-left:0px" >
					<li class="tablistitem" title='Immunization Details'>
					<a onclick="tabClickImmuni('Immuni_tab')" class="tabClicked" id="Immuni_tab" >
						<span class="tabSpanclicked" id="Immuni_tabspan"><fmt:message key="eCA.ImmunizationDetails.label" bundle="${ca_labels}"/></span>
					</a>
					</li>
					<li id='PendingRxForMAR' class="tablistitem" title='Pending Rx For MAR'>
						<a onclick="tabClickPendingRx('PendingRx_tab')" class="tabClicked" id="PendingRx_tab" readonly >
							<span class="tabSpanclicked" id="PendingRx_tabspan"><fmt:message key="eCA.PendingRxForMAR.label" bundle="${ca_labels}"/></span>
						</a>
					</li>
				</ul>
			</td>
		</tr>
	</table>
		<input type='hidden' name='qryString' id='qryString' value='<%=qryString%>'>
		</form>
	</body>

</html>

