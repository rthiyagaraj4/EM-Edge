<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql = "";
	String chart_selected = "";
	String disabled = "";
	String facility_id = (String)session.getValue("facility_id") ;
	String chart_flag = (String)session.getValue("chart_flag") ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter("encounter_id")) ;

	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
	String main_tab = checkForNull(request.getParameter("main_tab"));
	
	String show_new_active_yn = checkForNull(request.getParameter("show_new_active_yn"));

	String perio_chart = checkForNull(request.getParameter("perio_chart"));
	String perio_arch = checkForNull(request.getParameter("perio_arch"));
	String baseline_active_yn = checkForNull(request.getParameter("baseline_active_yn"));
	String baseline_closed_yn = checkForNull(request.getParameter("baseline_closed_yn"));
	String baseline_status = checkForNull(request.getParameter("baseline_status"));
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
	String chart_date = checkForNull(request.getParameter("chart_date"));
	String chart_close_date = checkForNull(request.getParameter("chart_close_date"));
	String chart_desc = checkForNull(request.getParameter("chart_desc"));
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
	String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn"));
	String chart_date_start = checkForNull(request.getParameter("chart_date_start"));
	String chart_type_for_alert = checkForNull(request.getParameter("chart_type_for_alert"));//Added by Sridevi Joshi on 4/27/2010 for PE ...the qry for this value was getting executed in all frames mentioned in OH.jsp
	
	try{
		con=ConnectionManager.getConnection(request);
	
		if(chart_type_for_alert.equals("")){//Added by Sridevi Joshi on 4/27/2010 for PE ...the qry for this value was getting executed in all frames mentioned in OH.jsp
			disabled = "disabled";
		}
%>
			
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
	<script language="javascript" src="../../eOH/js/PerioChart.js"></script>
	<script language='javascript' src='../../eOH/js/HistPerioChart.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		function refresh(){
			var formObj = document.forms[0];
			var messageFrame = parent.parent.messageFrame;
			var show_new_active_yn = formObj.show_new_active_yn.value; 
			var chart_num = formObj.chart_num.value; 
			var perio_arch = formObj.perio_arch.value; 
			var perio_chart = formObj.perio_chart.value; 
			var patient_id = formObj.patient_id.value; 
			var chart_num = formObj.chart_num.value; 
			var chart_code=formObj.perio_chart.value;
			var added_date="";

			/*
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_code="+perio_chart+"&chart_num="+chart_num;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForPerioChartValidity&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			var retVal=localTrimString(retVal);
			if(retVal.length > 1){
				var retVal_arr = retVal.split("~");
				for(k=0;k<retVal_arr.length-1;k++){
					var validity_period_arr = retVal_arr[k].split("##");
					if(parseInt(validity_period_arr[0]) > parseInt(validity_period_arr[1])){
						alert(getMessage("APP-OH00072","OH"));
						//return;
					}
				}
			}
			*/
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_code="+perio_chart+"&chart_num="+chart_num;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=checkForPerioChart&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			var retVal=localTrimString(retVal);
			if(retVal.length > 1){
				var retVal_arr = retVal.split("~");
				added_date=retVal_arr[0];
				
			}
			
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
			
			parent.perioChartMainDummyFrame.document.forms[0].main_chart_num.value = ""; // Clearing the chart_num ecah time whicen u refresh..This is to get the fresh chart_num whenever u insert record..
			
			formObj.baseline_active_yn.value = 'N';

			if(formObj != null){
				var numbering_system_title=getLabel("eOH.NumberingSystem.Label","OH");
				//var chart_title = "Chart";//getLabel("Common.Components.label","Common");
				var chart_title = getLabel("Common.Chart.label","Common");
				var arch_title = getLabel("eOH.Arch.Label","OH");
				
				var fields = new Array (formObj.perio_numbering_system,formObj.perio_chart,formObj.perio_arch);
				var names = new Array ( numbering_system_title,chart_title,arch_title);

				if(checkFieldsofMst( fields, names, messageFrame)){	
					changeNumberingSystem(perio_arch,'refresh',added_date);
				}
			}
		}

		function changeNumberingSystem(arch_code,called_from,added_date){ // This function is to rebuild the query without tooth_numbering_system parameter...
			var formObj = document.forms[0];
			//Added by Sharon Crasta on 11/26/2008 for SCR #6545
			//The Chart should not be loaded for Deciduous and Mixed Dentition Patients
			if('<%=chart_type_for_alert%>' == "RA"){
			//End
			var main_tab = "";
			var perio_numbering_system = formObj.perio_numbering_system.value; // OnChange parameter
			var tooth_numbering_system = formObj.tooth_numbering_system.value; //Form params..

			var perio_chart = formObj.perio_chart.value; 
			var perio_arch = formObj.perio_arch.value; 
			var chart_num = formObj.chart_num.value; 

			var perio_arch_hid = formObj.perio_arch_hid.value; 
			var baseline_active_yn = formObj.baseline_active_yn.value; 
			var baseline_closed_yn = formObj.baseline_closed_yn.value; 
			var baseline_status = formObj.baseline_status.value; 
			var chart_date = formObj.chart_date.value; 
			var other_chart_facility_id = formObj.other_chart_facility_id.value; 
			var chart_close_date = formObj.chart_close_date.value; 
			var oh_chart_level = formObj.oh_chart_level.value; 
			var other_facilitychart_yn = formObj.other_facilitychart_yn.value; 
			var chart_date_start = formObj.chart_date_start.value; 

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "oh_chart_level="+oh_chart_level;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=selectUserPrefferences&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			var retVal=localTrimString(retVal);
			if(retVal.length > 1){
				retVal_arr = retVal.split("##");
				if( (retVal_arr[0] == null || retVal_arr[0] == "null" || retVal_arr[0] == "") && (tooth_numbering_system == null || tooth_numbering_system == "null" || tooth_numbering_system=="")){ // Loding page for the first time and there thee is no record in OH_USER_PREFERENCES table
					tooth_numbering_system = retVal_arr[1];
					formObj.tooth_numbering_system.value = retVal_arr[1];
					formObj.perio_numbering_system.value = retVal_arr[1];
				}
				else if( retVal_arr[0] != null && retVal_arr[0] != "null" && retVal_arr[0] != "" && (tooth_numbering_system == null || tooth_numbering_system == "null" ||tooth_numbering_system == "")){ // Loding page for the first time and there thee is a record in OH_USER_PREFERENCES table
					tooth_numbering_system = retVal_arr[0];
					formObj.tooth_numbering_system.value = retVal_arr[0];
					formObj.perio_numbering_system.value = retVal_arr[0];
				}
				else{ // Loding page when you click on the refresh button and tooth_numbering_system is not null
					if(tooth_numbering_system != perio_numbering_system){
						var copy_as_defult  = confirm(getMessage("APP-OH00032","OH"))
						if(copy_as_defult){ // If you want to set this numbering system as default numbering system

							// Insert a record in to OH_USER_PREFERENCES table
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_numbering_system="+perio_numbering_system;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=updateUserPrefferences&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							var retVal=localTrimString(retVal);
							if(retVal != 0){
								formObj.tooth_numbering_system.value = perio_numbering_system;
								tooth_numbering_system = perio_numbering_system;
							}
						}
						else{ //If you dont want to set this numbering system as default numbering system
							formObj.tooth_numbering_system.value = perio_numbering_system;
							tooth_numbering_system = perio_numbering_system;
						}
					}
			
				}
				
			}

			// TO ADD ARCH PARAMETERS TO THE SELECT BOX perio_arch ACCORDING TO THE tooth_numbering_system
			clear_list(document.forms[0].perio_arch); 
			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
			optSel.value= ''; 
			document.forms[0].perio_arch.add(optSel);

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_numbering_system="+tooth_numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=populateArch&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					var element 	= document.createElement('OPTION') ;
					element.value 	= code_desc_arr[0];
					element.text 	= code_desc_arr[1] ;
					document.forms[0].perio_arch.add(element);
				}
			}
			document.forms[0].perio_arch.value = perio_arch;
			if(baseline_active_yn == "Y"){
				document.forms[0].perio_arch.value = perio_arch_hid;
				perio_arch = perio_arch_hid;
			}
			
			if(baseline_closed_yn == "Y" || other_facilitychart_yn=="Y"){
				document.forms[0].perio_arch.value = perio_arch_hid;
				perio_arch = perio_arch_hid;
				document.forms[0].perio_numbering_system.disabled = true;
				document.forms[0].perio_chart.disabled = true;
				if(document.forms[0].perio_status != null){
					document.forms[0].perio_status.disabled = true;
				}

			}

			if(arch_code != "undefined" && arch_code != undefined){
				document.forms[0].perio_arch.value = arch_code;
				perio_arch = arch_code;
			}
				
			if(parent.frames[1].EvaluationChart != null && parent.frames[1].EvaluationChart != "null" && parent.frames[1].EvaluationChart != undefined && parent.frames[1].EvaluationChart != "undefined" ){
				if(parent.frames[1].EvaluationChart.className == "tabClicked"){
					main_tab = "EvaluationChart";
				}
				else if(parent.frames[1].Compare.className == "tabClicked"){
					main_tab = "Compare";
				}
				else{
					main_tab = "BaselineChart";
				}
			}
			//var params_str = formObj.params.value;
			//var params_str = parent.frames[2].document.forms[0].ca_params.value //PerioChartMain
			var params_str = parent.perioChartMainDummyFrame.document.forms[0].ca_params.value //PerioChartMain
			
			var patient_id = formObj.patient_id.value;
			var chart_flag = formObj.chart_flag.value;
			var oh_chart_level = formObj.oh_chart_level.value;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "numbering_system="+tooth_numbering_system+"&patient_id="+patient_id+"&chart_flag="+chart_flag+"&oh_chart_level="+oh_chart_level;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","buildPerioParameters.jsp?func_mode=buildPerioParameters&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			var ret_params=localTrimString(retVal);
			if(called_from != "refresh" && baseline_closed_yn != "Y" && baseline_active_yn != "Y"){
				
				//To default the chart if there is only one record in the Header table
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "patient_id="+patient_id+"&oh_chart_level="+oh_chart_level;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=countHeaderRecords&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				var retVal_arr = retVal.split("##");
				if(retVal_arr[0] == "1"){ // No of Header Records
					formObj.perio_chart.value = retVal_arr[1];
					perio_chart = retVal_arr[1];

					formObj.perio_arch.value = "U";
					perio_arch = "U";

					chart_num = retVal_arr[2];

					if(retVal_arr[3] == "CM"){ //To remove Active and Mark Error entries from the status list item when the chart is completed
						clear_list(formObj.perio_status); 
						optSel	= document.createElement("OPTION");
						optSel.text = getLabel("Common.completed.label","Common");
						optSel.value= 'CM'; 
						formObj.perio_status.add(optSel);

						optSel	= document.createElement("OPTION");
						optSel.text = getLabel("Common.closed.label","Common");
						optSel.value= 'CD'; 
						formObj.perio_status.add(optSel);
					}

					formObj.perio_status.value = retVal_arr[3];
				}
				/*
				//To Check the validity of Perio Chart if there is only one record in the Header Table
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "patient_id="+patient_id+"&chart_code="+perio_chart;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForPerioChartValidity&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				var retVal=localTrimString(retVal);
				if(retVal.length > 1){
					var retVal_arr = retVal.split("~");
					for(k=0;k<retVal_arr.length-1;k++){
						var validity_period_arr = retVal_arr[k].split("##");
						if(parseInt(validity_period_arr[0]) > parseInt(validity_period_arr[1])){
							alert(getMessage("APP-OH00072","OH"));
						}
					}
				}
				*/
			}

			var called_from_BC_EV_yn = formObj.called_from_BC_EV_yn.value;
			if(formObj.perio_status.value == "CM" || baseline_status == "CM"   || formObj.perio_status.value == "CD" || baseline_status == "CD"){
				var disable_record = "Y";
				called_from_BC_EV_yn = "Y";
			}
			else{
				var disable_record = "N";
				called_from_BC_EV_yn = "N";
			}

			// This to set the Chart_num in the Header page bcoz we are not reloding this page on click og Refresh button
			formObj.chart_num.value = chart_num;

			if(formObj.perio_status.value == "PE" || formObj.baseline_status.value == "PE"){
				//Check for Perio Chart Validity days
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				////Commented and Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
				//var params = "patient_id="+patient_id+"&chart_code="+perio_chart+"&chart_num="+chart_num;
				var params = "patient_id="+patient_id+"&chart_code="+perio_chart+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level;
				//
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForPerioChartValidity&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				var retVal=localTrimString(retVal);
				if(retVal.length > 1){
					var retVal_arr = retVal.split("~");
					for(k=0;k<retVal_arr.length-1;k++){
						var validity_period_arr = retVal_arr[k].split("##");
						if(parseInt(validity_period_arr[1]) > 0){
							if(parseInt(validity_period_arr[0]) > parseInt(validity_period_arr[1])){
								alert(getMessage("APP-OH00072","OH"));
							}
						}
					}
				}
			}

			
			//params=params_str+ret_params+"&perio_arch="+perio_arch+"&perio_chart="+perio_chart+"&main_tab="+main_tab+"&baseline_active_yn="+baseline_active_yn+"&baseline_closed_yn="+baseline_closed_yn+"&chart_num="+chart_num; //Main_tab value is the value of the tab (Condition or Treatment) which will be in clicked position when you click on the refresh button.
			
			params=params_str+ret_params+"&perio_arch="+perio_arch+"&perio_chart="+perio_chart+"&main_tab="+main_tab+"&baseline_active_yn="+baseline_active_yn+"&baseline_closed_yn="+baseline_closed_yn+"&chart_num="+chart_num+"&disable_record="+disable_record+"&called_from_BC_EV_yn="+called_from_BC_EV_yn+"&chart_date="+chart_date+"&chart_close_date="+chart_close_date+"&added_date="+added_date+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&other_facilitychart_yn="+other_facilitychart_yn+"&chart_date_start="+chart_date_start;
			//Main_tab value is the value of the tab (Condition or Treatment) which will be in clicked position when you click on the refresh button.
			//formObj.params.value = params;
			if(main_tab == "EvaluationChart"){
				//parent.frames[2].location.href="../../eOH/jsp/OHTrmtDentalChartFrame.jsp?"+params;
				//parent.frames[1].location.href="../../eOH/jsp/PerioChartLoadParamsFrame.jsp?"+params;
				parent.perioChartRecordFrame.location.href="../../eOH/jsp/PerioChartLoadParamsFrame.jsp?"+params;
			}
			else if(main_tab == "Compare"){
				//parent.frames[2].location.href="../../eOH/jsp/PeriodontalSummaryFrame.jsp?"+params;
				//parent.frames[1].location.href="../../eOH/jsp/PerioChartLoadParamsFrame.jsp?"+params;
				parent.perioChartRecordFrame.location.href="../../eOH/jsp/PerioChartLoadParamsFrame.jsp?"+params;
				
			}
			else{
				//parent.frames[1].location.href="../../eOH/jsp/PerioChartLoadParamsFrame.jsp?"+params;
				parent.perioChartRecordFrame.location.href="../../eOH/jsp/PerioChartLoadParamsFrame.jsp?"+params; 
				//parent.frames[2].location.href="../../eOH/jsp/PerioBaselineChart.jsp?"+params;
			}
		} 
		//Added by Sharon Crasta on 11/26/2008 for SCR #6545
		//The Chart should not be loaded for Deciduous and Mixed Dentition Patients
		else {
			if('<%=chart_type_for_alert%>' == ""){
				//alert("Patient is in Deciduous/Mixed Dentition period.Periodontal Charting is not allowed");
				alert(getMessage("APP-OH00036","OH"));
			}
		}
		//End
	}
	</script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onLoad="assignDBValue();">
	<form name="perioChartHeaderForm" id="perioChartHeaderForm" method="post" target="messageFrame">
		<table width="100%" cellpadding =4 cellspacing=0 border=0>
			<tr>
				<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.NumberingSystem.Label" bundle="${oh_labels}"/></td>
				<td width="25%" class="field" nowrap>
						<!-- Commented and added disabled Flag for SCR #6545 by Sharon Crasta on 11/26/2008-->
						<!--<select name="perio_numbering_system" id="perio_numbering_system">-->
						<!-- -->
						<select name="perio_numbering_system" id="perio_numbering_system" <%=disabled%>>
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<%
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							pstmt=con.prepareStatement("SELECT NUMBERING_SYSTEM, NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW WHERE LANGUAGE_ID = ? ORDER BY 2");
							pstmt.setString(1,locale);
							rs=pstmt.executeQuery();
							while(rs.next()){
								String DB_numbering_system = rs.getString("NUMBERING_SYSTEM");
								String DB_numbering_system_desc = rs.getString("NUMBERING_SYSTEM_DESC");
						%>
								<option value="<%=DB_numbering_system%>"><%=DB_numbering_system_desc%></option>
						<%
							}
						%>
					</select> <img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td width="25%" class='LABEL' nowrap><fmt:message key="Common.Chart.label" bundle="${common_labels}"/></td>
				<td width="25%" class="field" nowrap>
					<!-- Commented and added disabled Flag for SCR #6545 by Sharon Crasta on 11/26/2008-->
					<!--<select name="perio_chart" id="perio_chart" onchange="getHeaderChartNum();clearChartStatus('BC');">-->
					<!-- -->
					<select name="perio_chart" id="perio_chart" onchange="getHeaderChartNum();clearChartStatus('BC');" <%=disabled%>>

						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<%
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							sql="SELECT CHART_CODE, CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR ORDER BY 2";
							pstmt=con.prepareStatement(sql);
							rs=pstmt.executeQuery();
							
							while(rs.next()){
								if(rs.getString("CHART_CODE").equals(perio_chart)){
									chart_selected = "selected";
								}
								else{
									chart_selected = "";
								}
						%>
								<option value='<%=rs.getString("CHART_CODE")%>' <%=chart_selected%>><%=rs.getString("CHART_DESC")%></option>
						<%
							}
						%>
					</select> <img src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr>
			<tr>
				<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.Arch.Label" bundle="${oh_labels}"/></td>
				<td width="25%" class="field" nowrap>
					<!-- Commented and added disabled Flag for SCR #6545 by Sharon Crasta on 11/26/2008-->
					<!--<select name="perio_arch" id="perio_arch">-->
					<!-- -->
					<select name="perio_arch" id="perio_arch" <%=disabled%>>
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select> <img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td width="25%" class='LABEL' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td width="25%" class="field" nowrap>
					<!-- Commented and added disabled Flag for SCR #6545 by Sharon Crasta on 11/26/2008-->
					<!--<select name="perio_status" id="perio_status" onChange="closeChart(this,'BC')" DB_Value="<%=baseline_status%>">-->
					<!-- -->
					<select name="perio_status" id="perio_status" onChange="closeChart(this,'BC')" DB_Value="<%=baseline_status%>" <%=disabled%>>
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<%
							//To remove Active entries from the status list item when the chart is completed
							if(!baseline_status.equals("CM")){
						%>
								<option value="PE"><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
						<%
							}
						%>
						<option value="CM"><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
						<option value="CD"><fmt:message key="Common.closed.label" bundle="${common_labels}"/></option>
						<%
							//To remove Mark Error entries from the status list item when the chart is completed
							if(!baseline_status.equals("CM")){
						%>
							<option value="ME"><fmt:message key="Common.MarkError.label" bundle="${common_labels}"/></option>
						<%
							}
						%>
					</select> &nbsp;&nbsp;&nbsp;&nbsp;
				<!-- </td>
				<td width="25%" align="right" colspan="2">  -->
					<!-- Commented and added disabled Flag for SCR #6545 by Sharon Crasta on 11/26/2008-->
					<!--<img src="../../eOH/images/Refresh.gif" alt="Refresh" onclick="refresh()"/>-->
					<!-- -->
					<img src="../../eOH/images/Refresh.gif" alt="Refresh" onclick="refresh()" <%=disabled%>/>&nbsp;&nbsp;
					<!-- Commented and added disabled Flag for SCR #6545 by Sharon Crasta on 11/26/2008-->
					<!--<input type="button" class="button" name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onclick ="reset_header()">-->
					<!-- -->
					<input type="button" class="button" name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onclick ="reset_header()" <%=disabled%>>
				</td>
			</tr>
			<!-- <tr>
				<td width="25%" class='LABEL'><fmt:message key="eOH.Status.Label" bundle="${oh_labels}"/></td>
				<td width="25%" class="field">
					<select name="perio_status" id="perio_status">
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select> <img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td width="25%" colspan="2" class="button">
					<input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick ="closeChart()">&nbsp;
				</td>
			</tr> -->
			
		</table>
		<input type = "hidden" name= "params" value = "<%=request.getQueryString()%>">
		<input type = "hidden" name= "facility_id" value = "<%=facility_id%>">
		<input type = "hidden" name= "chart_flag" value = "<%=chart_flag%>">
		<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
		<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
		<input type = "hidden" name= "tooth_numbering_system" value = "<%=tooth_numbering_system%>">
		<input type = "hidden" name= "permanent_deciduous_flag" value = "<%=permanent_deciduous_flag%>">
		<input type = "hidden" name= "chart_num" value = "<%=chart_num%>">
		<input type = "hidden" name= "chart_line_num" value = "<%=chart_line_num%>">
		<input type = "hidden" name= "perio_chart_hid" value = "<%=perio_chart%>">
		<input type = "hidden" name= "perio_arch_hid" value = "<%=perio_arch%>">
		<input type = "hidden" name= "baseline_active_yn" value = "<%=baseline_active_yn%>">
		<input type = "hidden" name= "baseline_closed_yn" value = "<%=baseline_closed_yn%>">
		<input type = "hidden" name= "show_new_active_yn" value = "<%=show_new_active_yn%>">
		<input type = "hidden" name= "main_tab" value = "<%=main_tab%>">
		<input type = "hidden" name= "baseline_status" value = "<%=baseline_status%>">
		<input type = "hidden" name= "called_from_BC_EV_yn" value = "<%=request.getParameter("called_from_BC_EV_yn")%>">
		<input type = "hidden" name= "patient_class" value = "<%=request.getParameter("patient_class")%>">
		<!--Added by Sharon Crasta on 11/26/2008 for SCR #6545-->
		<!--The Chart should not be loaded for Deciduous and Mixed Dentition Patients-->
		<input type = "hidden" name= "chart_type_for_alert" value = "<%=chart_type_for_alert%>">
		<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
		<input type = "hidden" name= "chart_date" value = "<%=chart_date%>">
		<input type = "hidden" name= "chart_close_date" value = "<%=chart_close_date%>">
		<input type = "hidden" name= "chart_desc" value = "<%=chart_desc%>">
		<input type = "hidden" name= "other_chart_facility_id" value = "<%=other_chart_facility_id%>">
		<input type = "hidden" name= "other_facilitychart_yn" value = "<%=other_facilitychart_yn%>">
		<input type = "hidden" name= "chart_date_start" value = "<%=chart_date_start%>">
		<!-- -->
	</form>
	<script>
		changeNumberingSystem();
	</script>
</body>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>

