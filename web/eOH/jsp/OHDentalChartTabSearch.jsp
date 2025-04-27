<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%	request.setCharacterEncoding("UTF-8");	%>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String condition_tab_selected_class ="";
	String treatment_selected_class ="";
	String perio_selected_class ="";
	String condition_span_class ="";
	String treatment_span_class ="";
	String perio_span_class ="";
	String tab_disabled ="";
	String cond_trmt_tab ="";

	String params = request.getQueryString();
	String facility_id = (String)session.getValue("facility_id") ;
	String practitioner_type =(String) session.getValue("practitioner_type");
	String practitioner_id =(String) session.getValue("practitioner_id");
	String default_head_tab =checkForNull(request.getParameter("default_head_tab"));

	String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
	String chart_flag = checkForNull(request.getParameter( "chart_flag" )) ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String visit_id = checkForNull(request.getParameter( "visit_id" )) ;
	String episode_id = checkForNull(request.getParameter( "episode_id" )) ;
	String encounter_id = checkForNull(request.getParameter( "encounter_id" )) ;
	String location_code = checkForNull(request.getParameter( "location_code" )) ;
	String location_type = checkForNull(request.getParameter( "location_type" )) ;
	String episode_type = checkForNull(request.getParameter( "episode_type" )) ;
	String patient_class = checkForNull(request.getParameter( "patient_class" )) ;
	String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn"));
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
	String diag_params = params+"&practitioner_type="+practitioner_type+"&practitioner_id="+practitioner_id+"&modal_yn=N";
	String add_new_done_flag =checkForNull(request.getParameter("add_new_done_flag")) ;
	String add_new_yn =checkForNull(request.getParameter("add_new_yn")) ;  
	String default_head_tab_add_new =checkForNull(request.getParameter("default_head_tab_add_new"));
    //Added by Sharon Crasta on 11/2/2009 for PrintChart PMG20089-CRF-0700 
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
	//
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}
	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Used to disable the chart once the APP-OH000153 message is displayed and on cancel.
	String chart_disable_from_main = checkForNull(request.getParameter( "chart_disable_from_main" )) ;
   	//End
	//if(default_head_tab.equals("Treatment")){
	if(default_head_tab.equals("Treatment") || default_head_tab_add_new.equals("Treatment")){
		cond_trmt_tab = "T";
		condition_tab_selected_class = "tabA";
		treatment_selected_class = "tabClicked";
		perio_selected_class = "tabA";

		condition_span_class = "tabAspan";
		treatment_span_class = "tabSpanclicked";
		perio_span_class = "tabAspan";
	}
	else if(default_head_tab.equals("PeriodontalSummary") || default_head_tab_add_new.equals("PeriodontalSummary")){
		cond_trmt_tab = "P";
		condition_tab_selected_class = "tabA";
		treatment_selected_class = "tabA";
		perio_selected_class = "tabClicked";

		condition_span_class = "tabAspan";
		treatment_span_class = "tabAspan";
		perio_span_class = "tabSpanclicked";
	}
	else{
		cond_trmt_tab = "C";
		default_head_tab = "Condition";
		condition_tab_selected_class = "tabClicked";
		treatment_selected_class = "tabA";
		perio_selected_class = "tabA";

		condition_span_class = "tabSpanclicked";
		treatment_span_class = "tabAspan";
		perio_span_class = "tabAspan";
	}

	/*if(baseline_chart_yn.equals("Y")){//added by parul  for other facility chart CRF#0423
			tab_disabled = "disabled";
	}*/
	
	if(add_new_yn.equals("Y") || add_new_done_flag.equals("Y")){
	   other_chart_facility_id = facility_id;
	   other_facilitychart_yn = "N";
	  // baseline_chart_yn = "N";
	}
	//Commented and Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
	//if(baseline_chart_yn.equals("Y")){
	if(baseline_chart_yn.equals("Y") || chart_disable_from_main.equals("Y")){//End
	/*if(baseline_chart_yn.equals("Y") || baseline_chart_yn.equals("N")){
		if(!other_chart_facility_id.equals(facility_id)){	*/
  		tab_disabled = "disabled";
	}
	if(other_facilitychart_yn.equals("Y")){
		tab_disabled = "disabled";
	}
	//}
	
	/* 
	occur_srl_no,term_code,term_set_id

	Params required for Calling Diagnosis function.
Age,Dob,Function,Sex,encounter_id,episode_type,function_id,location_code,location_type,modal_yn,occur_srl_no,patient_class,patient_id,practitioner_id,practitioner_type,relationship_id,term_code,term_set_id,visit_adm_date, ,

07/07/25 11:34:01 11:called_from=CA&chart_flag=R&option_id=OH_REST_CHART_REC1&patient_id=SD00000046&visit_id=&episode_id=100040640001&encounter_id=100040640001&location_code=CL30&location_type=C&bed_num=&room_num=&episode_type=O&discharge_date=&visit_adm_date=03/07/2007%2014:12&episode_Status=04&Sex=M&Age=55Y&Dob=21/10/1951&security_level=&protection_ind=&reln_req_yn=Y&patient_class=OP&PQ=Y&CA=Y&from_service_yn=&accession_number=&accession_type=&mode=R&RelnYn=&RelnReqYn=&relationship_id=ATTENDINGES&window_name=&child_window=Y&child_window=Y&limit_function_id=&chartTitle=&reln_req_yn=Y&limit_function_id=&chart_name=Restorative%20Chart&tooth_numbering_system=FDI&numbering_system_desc=FDI%20Numbering%20System&upper_arch_desc=Upper%20Arch&lower_arch_desc=Lower%20Arch&Q1_id=1&Q2_id=2&Q3_id=3&Q4_id=4&Q1_desc=Upper%20Right&Q2_desc=Upper%20Left&Q3_desc=Lower%20Left&Q4_desc=Lower%20Right&permanent_deciduous_flag=P&chart_type=RA&dflt_mixed_dentition_chart=P&mixed_dentition_YN=N&new_chart_num=1&cur_chart_num=

	*/
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<!-- <style>
	.tabA{
		color: white;
		background: blue  url("../../eCommon/images/tab_left_corner.gif")  left top no-repeat;
		text-decoration: overline;color:black;
		padding-left: 10px
	} 

	.tabAspan {
		background: blue url("../../eCommon/images/tab_right_corner.gif") right top no-repeat;
		text-decoration: overline;color:white;
		padding-right: 10px;
		height:15
	} 

	.tabClicked {
	 
		background: green url("../../eCommon/images/tab_left_corner_click.gif") left top no-repeat;
		text-decoration: overline;color: yellow;
		padding-left: 10px
	}

	.tabSpanclicked {
		background: green url("../../eCommon/images/tab_right_corner_click.gif") right top no-repeat;
		text-decoration: overline;color:yellow;
		padding-right: 10px;
		height:15
	}
</style> -->
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<script language="javascript">
function changeTab(objStr){
	var frmObj=document.forms[0];
	var baseline_chart_yn=frmObj.baseline_chart_yn.value;
	var chart_flag=frmObj.chart_flag.value;
	var patient_id=frmObj.patient_id.value;
	var visit_id=frmObj.visit_id.value;
	var episode_id=frmObj.episode_id.value;
	var encounter_id=frmObj.encounter_id.value;
	var location_code=frmObj.location_code.value;
	var location_type=frmObj.location_type.value;
	var episode_type=frmObj.episode_type.value;
	var patient_class=frmObj.patient_class.value;
	var other_facilitychart_yn=frmObj.other_facilitychart_yn.value;
	var disable = "";
	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
	var chart_disable_from_main = document.forms[0].chart_disable_from_main.value;
	if(baseline_chart_yn == "Y" || other_facilitychart_yn == "Y" || chart_disable_from_main == "Y"){//End
		disable = "disabled";
	}
	//Added by Sharon Crasta on 11/2/2009 for PrintChart PMG20089-CRF-0700
	//Added to display the print icon only when atleast one chart is present
	var other_chart_facility_id = frmObj.other_chart_facility_id.value;
	var oh_chart_level = frmObj.oh_chart_level.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var query_print_params = "patient_id="+patient_id+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getCountOfCharts&"+query_print_params,false);
	xmlHttp.send(xmlDoc);
	var retVal_print = trimString(xmlHttp.responseText);
	var count_chart=localTrimString(retVal_print);
	//Added by Sharon Crasta on 2/22/2010 for IN019266
	if(count_chart == 0){
		disable = "disabled";
	}
	//End
	

//chart_flag=R&locale=en&patient_id=BL09000953&visit_id=&episode_id=100114530001&encounter_id=100114530001&location_code=CL34&location_type=C&episode_type=O&patient_class=OP
	//if(other_facilitychart_yn != "Y"){
	//Commented and Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main != "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
	//if(baseline_chart_yn != "Y" && other_facilitychart_yn!="Y"){ //added by parul  for other facility chart CRF#0423
	if(baseline_chart_yn != "Y" && other_facilitychart_yn!="Y" && chart_disable_from_main != "Y"){
		selectTab(objStr);
		var param=frmObj.param.value;
		var hdr_param = "";
	    var called_from_cond_trt_tab_flag="";
		var change_tab_validity_yn = "";
		//param=parent.condTabDentalChartFrame.location.search;
		switch(objStr){
			case "Condition": 
				  called_from_cond_trt_tab_flag = "C";
				  hdr_param = "chart_flag="+chart_flag+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&location_code="+location_code+"&location_type="+location_type+"&episode_type="+episode_type+"&patient_class="+patient_class;
				  //param = parent.frames[3].document.forms[0].ca_params.value;
				  param=param+"&called_from_cond_trt_tab_flag=C"+"&change_tab_validity_yn=Y";
				 
				  parent.frames[2].location.href="../../eOH/jsp/OHCondDentalChartFrame.jsp?"+param;
				  //parent.frames[2].location.href="../../eOH/jsp/OHCondDentalChartFrame.jsp?"+param+"&loaded_from_main_tab=Y";
				  //parent.frames[0].location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp?"+hdr_param+"&tab_clicked=C";// This parameter is to display only condition images in the tool header frame
				  parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
				  //window.location.href="../../eOH/jsp/ConditionFrame.jsp?"+param;

				  //Added by Sridevi Joshi on 28/10/09 for RHS disappearing issue(IN015790)
				  parent.conditionDentalChartToolHeader.document.getElementById("print_chart").innerHTML = "<img src='../../eOH/images/Refresh.gif' alt='Refresh' onclick='changeNumberingSystem()'"+disable+" />";

				  break;


			case "Diagnosis": 
				  //parent.frames[1].location.href="../../eOH/jsp/DiagnosisFrame.jsp?"+param;
				  parent.frames[2].location.href="../../eMR/jsp/RecDiagnosis.jsp?"+diag_params;
				   parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
				  break;
			case "Treatment": 
				  called_from_cond_trt_tab_flag = "T";
				  hdr_param = "chart_flag="+chart_flag+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&location_code="+location_code+"&location_type="+location_type+"&episode_type="+episode_type+"&patient_class="+patient_class;
				  param=param+"&called_from_cond_trt_tab_flag=T&change_tab_validity_yn=Y";
				  //parent.frames[2].location.href="../../eOH/jsp/OHTrmtDentalChartFrame.jsp?"+param;
				  parent.frames[2].location.href="../../eOH/jsp/OHTrmtDentalChartFrame.jsp?"+param+"&loaded_from_main_tab=Y";
				  //parent.frames[0].location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp?"+hdr_param+"&tab_clicked=T";// This parameter is to display only Trmts images in the tool header frame
				  parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";

				  //Commented and Added by Sharon For Print Chart PMG20089-CRF-0700
				  //Added by Sridevi Joshi on 28/10/09 for RHS disappearing issue(IN015790)
				  //parent.conditionDentalChartToolHeader.document.getElementById("print_chart").innerHTML = "<img id='print_img' src='../../eOR/images/print-Preview.gif' alt='Print' style='cursor:pointer;' onclick='printOverview();' /><img src='../../eOH/images/Refresh.gif' alt='Refresh' onclick='changeNumberingSystem()'"+disable+" />";
				   //Commented and Added by Sharon Crasta on 2/22/2010 for IN019266
				  /*if(count_chart != 0){
					  parent.conditionDentalChartToolHeader.document.getElementById("print_chart").innerHTML = "<img id='print_img' src='../../eOR/images/print-Preview.gif' alt='Print' style='cursor:pointer;' onclick='printOverview();' /><img src='../../eOH/images/Refresh.gif' alt='Refresh' onclick='changeNumberingSystem()'"+disable+" />";
				  }else{
				  	   parent.conditionDentalChartToolHeader.document.getElementById("print_chart").innerHTML = "<img src='../../eOH/images/Refresh.gif' alt='Refresh' onclick='changeNumberingSystem()'"+disable+" />";
				  }	*/
				   parent.conditionDentalChartToolHeader.document.getElementById("print_chart").innerHTML = "<img id='print_img' src='../../eOR/images/print-Preview.gif' alt='Print' style='cursor:pointer;' onclick='printOverview();'"+disable+" /><img src='../../eOH/images/Refresh.gif' alt='Refresh' onclick='changeNumberingSystem()' />";
				 //End

				  break;
			case "ClinicalNote": 
				  //parent.frames[1].location.href="../../eOH/jsp/ClinicalNoteFrame.jsp?"+param;
				  parent.frames[2].location.href="../../eCA/jsp/RecClinicalNotesModal.jsp?"+param;
				   parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
				  break;
			case "PeriodontalSummary": 
					called_from_cond_trt_tab_flag = "P";
					param=param+"&called_from_cond_trt_tab_flag=P";
					//parent.frames[2].location.href="../../eOH/jsp/PeriodontalSummaryFrame.jsp?"+param;
					parent.frames[2].location.href="../../eOH/jsp/SummaryFrames.jsp?"+param;
					parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
					break;
		}
		//changeTabColor(called_from_cond_trt_tab_flag);
	}
	//Commented by Sridevi Joshi on 28/10/09 for RHS disappearing issue(IN015790)
	//parent.conditionDentalChartToolHeader.location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp?"+param+"&loaded_from_main_tab=N";
}

function changeTabColor(called_from_cond_trt_tab_flag){
	var cond_label = getLabel("eOH.Conditions.Label","OH");
	var trmt_label = getLabel("Common.Treatment.label","Common");
	var tabColorId   = document.getElementById("tabColor");
	var TreatmentId = document.getElementById("Treatment");
	var TreatmentSpanId = document.getElementById("Treatmentspan");

	var ConditionId = document.getElementById("Condition");
	var ConditionSpanId = document.getElementById("Conditionspan");
	if(called_from_cond_trt_tab_flag == "T"){
		if(tabColorId != "null" && tabColorId != null){
			tabColorId.innerHTML = '<font color="white"><b>'+trmt_label+'</b></font>';
			tabColorId.style.backgroundColor = "green";
			tabColorId.style.color="red";
		}
		//ConditionId.className = "tabA";
		//ConditionSpanId.style.color = "black";
		//ConditionSpanId.className = "tabAspan";

		//TreatmentId.style.backgroundColor = "green";
		//TreatmentSpanId.style.color="white";

	}
	else if(called_from_cond_trt_tab_flag == "C"){
		if(tabColorId != "null" && tabColorId != null){
			tabColorId.innerHTML = '<font color="white"><b>'+cond_label+'</b></font>';
			tabColorId.style.backgroundColor = "brown";
			tabColorId.style.color="white";

			//ConditionId.style.backgroundColor = "brown";
			//ConditionSpanId.style.color="white";

			//TreatmentId.className = "tabA";
			//TreatmentSpanId.style.color = "black";
			//TreatmentSpanId.className = "tabAspan";
		}
	}
	else{
		if(tabColorId != "null" && tabColorId != null){
			tabColorId.innerHTML = "";
			tabColorId.style.backgroundColor = "white";
			tabColorId.style.color="white";
		}
		//ConditionId.className = "tabA";
		//ConditionSpanId.style.color = "black";
		//ConditionSpanId.className = "tabAspan";

		//TreatmentId.className = "tabA";
		//TreatmentSpanId.style.color = "black";
		//TreatmentSpanId.className = "tabAspan";

	}
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- Commented by Sharon Crasta on 7/16/2009 for IN012454-->
<!-- <body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onMouseOver='hideMenuOnOutFocus("DentalChartTabSearch")'>
 --><body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<!-- <body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="alert(parent.frames[2].frames[1].frames[1].name)"> -->
<form name="OHCommonForm" id="OHCommonForm"> 

<table id="tab" cellspacing=0 cellpadding=3 border="0" width='100%'>
<tr>
	<td width= "18%" class="white">
	<ul id="tablist" class="tablist" <%=tab_disabled%>>
		<li class="tablistitem" title=<fmt:message key="Common.Condition.label" bundle="${common_labels}"/> >
			 <a  class="<%=condition_tab_selected_class%>"  onclick="changeTab('Condition');" id="Condition"> 
				<span class="<%=condition_span_class%>" id="Conditionspan" value="1"><fmt:message key="Common.Condition.label" bundle="${common_labels}"/></span> 
			</a> 
			
		</li>
<!--
		<li class="tablistitem" title='Diagnosis' >
			<a  class="tabA"  onclick="changeTab('Diagnosis');" id="Diagnosis"> 
				<span class="tabAspan" id="Diagnosisspan" value="10"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></span>
			</a>
		</li>
-->
		<li class="tablistitem" title=<fmt:message key="Common.Treatment.label" bundle="${common_labels}"/> >
			<a  class="<%=treatment_selected_class%>"  onclick="changeTab('Treatment');" id="Treatment"> 
				<span class="<%=treatment_span_class%>" id="Treatmentspan" value="15"><fmt:message key="Common.Treatment.label" bundle="${common_labels}"/></span>
			</a>
		</li> 
<!--		
		 <li class="tablistitem" title='ClinicalNote' >
			<a  class="tabA"  onclick="changeTab('ClinicalNote');" id="ClinicalNote"> 
				<span class="tabAspan" id="ClinicalNotespan" value="20"><fmt:message key="Common.ClinicalNote.label" bundle="${common_labels}"/></span>
			</a>
		</li>
-->
<!--
		<li class="tablistitem" title=<fmt:message key="Common.Summary.label" bundle="${common_labels}"/>>
			<a  class="<%=perio_selected_class%>"  onclick="changeTab('PeriodontalSummary');" id="PeriodontalSummary"> 
				<span class="<%=perio_span_class%>" id="PeriodontalSummaryspan" value="25"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></span>
			</a>
		</li> 
-->
	</ul>
	</td>
	<!-- <td width= "100%" align="center" style="background-color:brown" id="tabColor"><font color="white"><b><fmt:message key="eOH.Conditions.Label" bundle="${oh_labels}"/></b></font></td> -->
</tr>
	<!-- The below line is required to change the select state of Initial tab selected -->
	<script>
		//var ConditionId = document.getElementById("Condition");
		//var ConditionSpanId = document.getElementById("Conditionspan");
		//ConditionId.style.backgroundColor = "brown";
		//ConditionSpanId.style.color="white";
		prevTabObj='<%=default_head_tab%>'
		//alert(document.forms[0].cond_trmt_tab.value);
		//changeTabColor('<%=cond_trmt_tab%>');
		//alert(document.forms[0].Condition.className);
		//alert(document.forms[0].Treatment.className);
		
	</script>
	

</table>

<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
<input type='hidden' name='diag_params' id='diag_params' value='<%=diag_params%>'>
<input type = "hidden" name= "baseline_chart_yn" value = "<%=baseline_chart_yn%>">
<input type = "hidden" name= "chart_flag" value = "<%=chart_flag%>">
<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
<input type = "hidden" name= "visit_id" value = "<%=visit_id%>">
<input type = "hidden" name= "episode_id" value = "<%=episode_id%>">
<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
<input type = "hidden" name= "location_code" value = "<%=location_code%>">
<input type = "hidden" name= "location_type" value = "<%=location_type%>">
<input type = "hidden" name= "episode_type" value = "<%=episode_type%>">
<input type = "hidden" name= "patient_class" value = "<%=patient_class%>">
<input type = "hidden" name= "other_facilitychart_yn" value = "<%=other_facilitychart_yn%>">
<!-- Added by Sharon Crasta on 11/2/2009 for PrintChart PMG20089-CRF-0700 -->
<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
<input type = "hidden" name= "other_chart_facility_id" value = "<%=other_chart_facility_id%>">
<!-- Added by Sharon Crasta on 1/11/2010 for IN017822  -->
<input type = "hidden" name= "chart_disable_from_main" value = "<%=chart_disable_from_main%>">
<!-- -->

</form>
</body>
</html>

