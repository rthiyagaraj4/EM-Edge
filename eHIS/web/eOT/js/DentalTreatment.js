/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var qry_string = "";
var tab_name = "T";
var area_legend;

function setValuesFromMenu(type,site,code,arch_quad,thrng_nos,ref_tooth_no,tooth_numbering_system,permanent_deciduous_flag,status,outcome,surface){
	var formObj = document.forms[0];
	var date_diff_flag = "";
	if(formObj.date_diff_flag != null && formObj.date_diff_flag != "null"){
		date_diff_flag = formObj.date_diff_flag.value;
	}
	else{
		date_diff_flag ="";
	}
	formObj.oh_category.value = type;
	populateConditionCode(formObj.oh_category)
	populateSiteOptions(formObj.oh_category);
	formObj.oh_site.value = site;
	populateTreatments(formObj.oh_category);
	if(code != null && code != "null" && code != "undefined"){
		formObj.oh_treatment.value = code;
	}

	getAreaLegend(formObj.oh_site,thrng_nos);
	populateArea(formObj.oh_site,tooth_numbering_system,permanent_deciduous_flag,ref_tooth_no,thrng_nos);

	if(formObj.oh_site.value == "ARCH" || formObj.oh_site.value == "QUAD"){
		formObj.oh_area.value = arch_quad;

		//These values for the hidden variables
		formObj.area.value = arch_quad;
	}
	else if(formObj.oh_site.value == "THRNG"){
		formObj.oh_area.value = thrng_nos;

		//These values for the hidden variables
		formObj.area.value = thrng_nos;
	}
	else{
		formObj.oh_area.value = ref_tooth_no;

		//These values for the hidden variables
		formObj.area.value = ref_tooth_no;
	}
	
	populateSurfaces(formObj.oh_area);
	formObj.oh_surface.value = surface;
	enableDisableSurface(formObj.oh_site);

	if(status == "25" && (outcome == "" || outcome == null || outcome == "null") && document.getElementById("outcome_label") != null){
		var success = getLabel("eOH.Success.Label","OH");
		var failure = getLabel("eOH.Failure.Label","OH");
		document.getElementById("outcome_label").innerHTML = getLabel("Common.outcome.label","Common");
		document.getElementById("outcome_select").innerHTML ="<select name='oh_outcome' id='oh_outcome'><option value='S'>"+success+"</option><option value='F'>"+failure+"</option></select><img src='../../eCommon/images/mandatory.gif'>"		
	}

	//These values for the hidden variables
	formObj.category.value = type;
	formObj.site.value = site;
	if(code != null && code != "null" && code != "undefined"){
		formObj.treatment.value = code;
	}

	if(formObj.oh_category.value != "" && formObj.oh_category.value != null){
		formObj.oh_category.disabled = true;
		formObj.oh_area.disabled = true;
		formObj.oh_site.disabled = true;
		if(code != null && code != "null" && code != "" && code != "undefined"){
			formObj.oh_treatment.disabled = true;
		}
	}
	/*
	else{
		//formObj.treatment_status.disabled = true;
		//formObj.treatment_status.value = "10";
	}
	*/
	if(status == "60" || status == "85" &&( formObj.oh_task == null || formObj.oh_task == "null")){
			formObj.oh_outcome.value = outcome;
	}

	if(formObj.called_from_viewchart_yn.value == 'Y' || date_diff_flag == "disable"){
		formObj.oh_surface.value = surface;
		if(status == "25"){
			//formObj.oh_outcome.value = outcome;
		}
		
		formObj.oh_category.disabled = true;
		formObj.oh_area.disabled = true;
		formObj.oh_site.disabled = true;
		formObj.oh_treatment.disabled = true;
		formObj.oh_surface.disabled = true;
		if(formObj.called_from_viewchart_yn.value == 'Y' && formObj.oh_task != null && formObj.oh_task != "null"){
			formObj.oh_task.disabled = true;
		}
		//formObj.oh_outcome.disabled = true;
	}

	if(type == "MAXILLA" || type=="ORALCVT" || type=="PERIO" || type=="OTHERS"){
		document.getElementById("MandatoryRemarks").style.visibility = 'visible';
	}
	else{
		document.getElementById("MandatoryRemarks").style.visibility = 'hidden';
	}
	
}

function changeStatus(obj){
	var save_legend = "";
	var reset_legend = getLabel("Common.reset.label","common_labels");
	if(obj.value == "E"){
		save_legend = getLabel("Common.record.label","common_labels");
		document.getElementById("showCancelForReason").style.visibility = 'visible';
		document.getElementById("mandatoryReason").style.visibility = 'visible';
	}
	else if(obj.value == "10"){
		save_legend = getLabel("Common.Schedule.label","common_labels");
		document.getElementById("showCancelForReason").style.visibility = 'hidden';
		document.getElementById("mandatoryReason").style.visibility = 'hidden';
	}
	else if(obj.value == "15"){
		save_legend = getLabel("eOR.Register.label","or_labels");
		document.getElementById("showCancelForReason").style.visibility = 'hidden';
		document.getElementById("mandatoryReason").style.visibility = 'hidden';
	}
	else if(obj.value == "25" ||obj.value == "52" || obj.value == "55" ||obj.value == "80"){
		save_legend = getLabel("eOR.ResultEntry.label","or_labels");
		document.getElementById("showCancelForReason").style.visibility = 'hidden';
		document.getElementById("mandatoryReason").style.visibility = 'hidden';
	}
	else{
		save_legend = getLabel("Common.record.label","common_labels");
		document.getElementById("showCancelForReason").style.visibility = 'hidden';
		document.getElementById("mandatoryReason").style.visibility = 'hidden';
	}
	
	document.getElementById("save_reset_button").innerHTML = '<input type="button" class="button" name="save" id="save" value="'+save_legend+'" onclick ="actionToServlet(\''+obj.value+'\');">&nbsp;<input type="button" class="button" name="'+reset_legend+'" id="'+reset_legend+'" value="Reset" onclick="Treatment_Reset(document.forms[0])">';
	
}
function checkForMaxilla(obj){
	if(obj.value=="ORALCVT" || obj.value=="PERIO"){
		document.getElementById("AreaMandatory").style.visibility = 'visible';
	}
	if(obj.value == "MAXILLA" || obj.value=="ORALCVT" || obj.value=="PERIO" || obj.value=="OTHERS"){
		var remarks_title = getLabel("Common.remarks.label","Common");
		document.getElementById("maxillaTrmt").innerHTML ="<a href=\"javascript:showOperRemarks('"+remarks_title+"')\">"+remarks_title+"</a><IMG id='MandatoryRemarks' style='visibility:hidden' name='MandatoryRemarks' border='0' src='../../eCommon/images/mandatory.gif'>";
		document.getElementById("MandatoryRemarks").style.visibility = 'visible';
	}else{
		//document.getElementById("maxillaTrmt").innerHTML ="";
		document.getElementById("MandatoryRemarks").style.visibility = 'hidden';
	}
}
/* Prev Code not applicable for OTHERS trmt type
function checkForMaxilla(obj){
	if(obj.value == "MAXILLA"){
		var remarks_title = getLabel("Common.remarks.label","Common");
		document.getElementById("maxillaTrmt").innerHTML ="<a href=\"javascript:showOperRemarks('"+remarks_title+"')\">"+remarks_title+"</a><img src='../../eCommon/images/mandatory.gif'>";
	}
}
function showOperRemarks(title,remarks){
	var remarks = document.forms[0].remarks.value;
	title = encodeURIComponent(title);
	var retVal = window.showModalDialog('../../eOH/jsp/TextArea.jsp?heading='+title+'&remarks='+remarks+'&readOnlyYN=N',window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
	document.forms[0].remarks.value = retVal;
}
*/

async function showOperRemarks(title,remarks){
	var readOnlyYN = "N";
	var remarks = document.forms[0].remarks.value;
	var called_from_viewchart_yn = document.forms[0].called_from_viewchart_yn.value;
	var date_diff_flag = document.forms[0].date_diff_flag.value;

	if(called_from_viewchart_yn == "Y" || date_diff_flag == "disable"){
		readOnlyYN = "Y";
	}else{
		readOnlyYN = "N";
	}
	title = encodeURIComponent(title);

	var retVal = await window.showModalDialog('../../eOH/jsp/TextArea.jsp?heading='+title+'&remarks='+remarks+'&readOnlyYN='+readOnlyYN,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
	document.forms[0].remarks.value = retVal;
}

async function showReasonForCancel(title){
	var reasonforcancel = document.forms[0].reasonforcancel.value;
	title = encodeURIComponent(title);
	var retVal = await window.showModalDialog('../../eOH/jsp/TextArea.jsp?heading='+title+'&remarks='+reasonforcancel+'&readOnlyYN=N',window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
	document.forms[0].reasonforcancel.value = retVal;
}

function enableDisableSurface(obj){
	if(obj.value != null ){
		if(obj.value == 'ROOT' || obj.value == 'CROWN'){
			if(document.forms[0].oh_surface.value != ""){
				document.forms[0].oh_surface.disabled = true;
			}
			else{
				document.forms[0].oh_surface.disabled = false;
			}
		}
		else{
			//document.forms[0].oh_surface.value = 'AS';
			document.forms[0].oh_surface.disabled = true;
		}
	}
}
/*
function populateSiteOptions(obj){
	clear_list(document.forms[0].oh_site); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_site.add(optSel);
	var trmt_condition_type_val = obj.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "trmt_condition_type_val="+trmt_condition_type_val+"&tab_name="+tab_name;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSiteOptions&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	
	if(retVal.length>1){
		var retVal_arr = retVal.split("~");
		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			var element 	= document.createElement('OPTION') ;
			element.value 	= code_desc_arr[0];
			element.text 	= code_desc_arr[1] ;
			document.forms[0].oh_site.add(element);
		}
	}
}
*/
function populateSiteOptions(obj){
	if(obj.value == "OTHERS"){ // For Trmt type OTHERS 
		if(document.getElementById("AreaMandatory")!=null){
			document.getElementById("AreaMandatory").style.visibility = 'hidden';
		}
		document.getElementById("SiteMandatory").style.visibility = 'hidden';
	}
	clear_list(document.forms[0].oh_site); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_site.add(optSel);
	if(document.forms[0].oh_area!=null){
		clear_list(document.forms[0].oh_area); 
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].oh_area.add(optSel);
	}
	var trmt_condition_type_val = obj.value;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "trmt_condition_type_val="+trmt_condition_type_val+"&tab_name="+tab_name;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSiteOptions&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	
	if(retVal.length>1){
		document.getElementById("SiteMandatory").style.visibility = 'visible';
		var retVal_arr = retVal.split("~");
		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			var element 	= document.createElement('OPTION') ;
			element.value 	= code_desc_arr[0];
			element.text 	= code_desc_arr[1] ;
			document.forms[0].oh_site.add(element);
		}
	}//else{
		//document.getElementById("SiteMandatory").style.visibility = 'hidden';
	//}
}

function populateSurfaces(obj){
	clear_list(document.forms[0].oh_surface); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_surface.add(optSel);
	var site_type_val = document.forms[0].oh_site.value;
	var tooth_no_val = obj.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "site_type_val="+site_type_val+"&tooth_no_val="+tooth_no_val;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSurfaces&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	
	if(retVal.length>1){
		document.getElementById("MandatorySurface").style.visibility = 'visible';
		var retVal_arr = retVal.split("~");
		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			var element 	= document.createElement('OPTION') ;
			element.value 	= code_desc_arr[0];
			element.text 	= code_desc_arr[1] ;
			document.forms[0].oh_surface.add(element);
		}
	}
	else{
		document.getElementById("MandatorySurface").style.visibility = 'hidden';
	}
}

function populateTreatments(obj){
	clear_list(document.forms[0].oh_treatment); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_treatment.add(optSel);
	var category_val = obj.value;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "category_val="+category_val;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateTreatments&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);

	if(retVal.length>1){
		var retVal_arr = retVal.split("~");
		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			var element 	= document.createElement('OPTION');
			element.value 	= code_desc_arr[0];
			element.text 	= code_desc_arr[1] ;
			document.forms[0].oh_treatment.add(element);
		}
	}
}

function populateStatus(obj){
	var category = trimString(obj.value);
	category = localTrimString(category);
	if(category != "" && category != null && category != "null"){
		clear_list(document.forms[0].treatment_status); 
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.Ordered.Label","OH");
		optSel.value= '10'; 
		document.forms[0].treatment_status.add(optSel);
		document.forms[0].treatment_status.disabled = true;
	}
	else{
		clear_list(document.forms[0].treatment_status); 
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		//optSel.value= '10'; 
		optSel.value= ''; 
		document.forms[0].treatment_status.add(optSel);
		document.forms[0].treatment_status.disabled = false;
	}
}

function populateConditionCode(obj){
	var condition_type = obj.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "condition_type="+condition_type;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateConditionCode&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal);
	if(retVal.length>1){
		if(document.forms[0].cat_code != "null" && document.forms[0].cat_code != null){
			document.forms[0].cat_code.value = retVal;
		}
	}
}

function actionToServlet(treatment_status_param){
	var tooth_no ;
	var appt_scheduled_yn;
	var formObj=document.forms[0];
	var params = formObj.params.value;
	var patient_id = formObj.patient_id.value;
	var encounter_id = formObj.encounter_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var site_type = formObj.oh_site.value;
	var ca_practitioner_id = formObj.ca_practitioner_id.value;
	formObj.oh_status.value = formObj.treatment_status.value;
	var status = formObj.oh_status.value;
	var trmt_category_type = formObj.oh_category.value;
	var trmt_code = formObj.oh_treatment.value;
	var surface = formObj.oh_surface.value;
	var appt_reqd_yn = formObj.appt_reqd_yn.value;
	var status_for_filling = formObj.status_for_filling.value;
	
	var chart_num = formObj.chart_num.value;
	var surface_code = formObj.oh_surface.value;
	var dentalChartFormObj = parent.trmtDentalChartDetails;
	var thrng_nos_ref = formObj.thrng_nos_ref.value;

	//This is the string of selected diagnosis information...
	var diagcodeselected = formObj.diagcodeselected.value;

	//This is the string of selected materials information...
	var comp_code_selected = formObj.comp_code_selected.value;

	var numbering_system = document.forms[0].tooth_numbering_system.value;
	var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
	var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
	var tooth_num = "";
	var tooth_name = "";
	var mapped_tooth_no = "";

	formObj.category.value = formObj.oh_category.value;
	formObj.site.value = formObj.oh_site.value;
	formObj.area.value = formObj.oh_area.value;
	formObj.treatment.value = formObj.oh_treatment.value;
	//formObj.outcome.value = formObj.oh_outcome.value;
	var tooth_range_count_for_order = 0;

	if(site_type == "THRNG" && thrng_nos_ref != ""){
		tooth_no = formObj.thrng_nos_ref.value;
		var thrng_nos_ref_arr = thrng_nos_ref.split(",");
		
		tooth_range_count_for_order = thrng_nos_ref_arr.length 
	}
	else if(site_type == "THRNG" && thrng_nos_ref == ""){
		tooth_range_count_for_order = formObj.oh_area.options.length 
		for (var m=0;m<formObj.oh_area.options.length-1; m++) {
			if (formObj.oh_area.options[m].selected == true) {
				if(thrng_nos_ref == ""){
					thrng_nos_ref = formObj.oh_area.options[m].value; 
				}
				else{
					thrng_nos_ref = thrng_nos_ref+","+formObj.oh_area.options[m].value; 
				}
			}
		}
		formObj.thrng_nos_ref.value = thrng_nos_ref;
		tooth_no = thrng_nos_ref;
	}
	else{
		tooth_no = formObj.oh_area.value;
	}

	var messageFrame = parent.parent.parent.parent.messageFrame;
	if(formObj != null){
		var category_title=getLabel("Common.category1.label","Common");
		var site_title = getLabel("Common.Site.label","Common");
		var area_title = area_legend;
		var status_title = getLabel("Common.status.label","Common");
		var treatment_title = getLabel("eOH.Treatment.Label","OH");
		var surface_title = getLabel("eOH.Surface.Label","OH");
		var outcome_title = getLabel("Common.outcome.label","Common");
		var remarks_title = getLabel("Common.remarks.label","Common");
		var cancel_reason_title = getLabel("eOR.CancelReason.label","OR");
/* Prev code not applicable for OTHERS
		if(formObj.oh_outcome == null){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.treatment_status,formObj.oh_treatment);
			var names = new Array ( category_title,site_title,status_title,treatment_title);
		}
		else if(trmt_category_type == "MAXILLA"){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.treatment_status,formObj.oh_treatment,formObj.oh_outcome,formObj.remarks);
			var names = new Array ( category_title,site_title,status_title,treatment_title,outcome_title,remarks_title);
		}
		else if((formObj.oh_surface.disabled == false && site_type=="CROWN" && formObj.oh_surface.options.length > 1) || (formObj.oh_surface.options.length > 1 && site_type=="ROOT")){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.oh_outcome);
			var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,surface_title,outcome_title);
		}
		else{
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_outcome);
			var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,outcome_title);
		}
		
*/		if(trmt_category_type == "OTHERS" && status != "E"){
			var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.remarks);
			var names = new Array ( category_title,status_title,treatment_title,remarks_title);
		}
		else if(trmt_category_type == "OTHERS" &&  status == "E"){
			var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.reasonforcancel);
			var names = new Array ( category_title,status_title,treatment_title,cancel_reason_title);
		}
		else if(trmt_category_type == "ORALCVT" && site_type=="MOUTH" && status != "E"){
			var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.remarks);
			var names = new Array ( category_title,status_title,treatment_title,site_title,remarks_title);
		}
		else if(trmt_category_type == "ORALCVT" && site_type=="MOUTH" && status == "E"){
			var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.reasonforcancel);
			var names = new Array ( category_title,status_title,treatment_title,site_title,cancel_reason_title);
		}
		else if((trmt_category_type == "ORALCVT" || trmt_category_type == "PERIO") && status != "E"){
			var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.oh_area,formObj.remarks);
			var names = new Array ( category_title,status_title,treatment_title,site_title,area_title,remarks_title);
		}
		else if((trmt_category_type == "ORALCVT" || trmt_category_type == "PERIO") && status == "E"){
			var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.oh_area,formObj.reasonforcancel);
			var names = new Array ( category_title,status_title,treatment_title,site_title,area_title,cancel_reason_title);
		}
		else if((trmt_category_type == "MAXILLA" || site_type=="MOUTH") && status != "E"){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.treatment_status,formObj.oh_treatment,formObj.remarks);
			var names = new Array ( category_title,site_title,status_title,treatment_title,remarks_title);
		}
		else if((trmt_category_type == "MAXILLA" || site_type=="MOUTH") && status == "E"){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.treatment_status,formObj.oh_treatment,formObj.reasonforcancel);
			var names = new Array ( category_title,site_title,status_title,treatment_title,cancel_reason_title);
		}
		else if((formObj.oh_surface.disabled == false && site_type=="CROWN" && formObj.oh_surface.options.length > 1) || (formObj.oh_surface.options.length > 1 && site_type=="ROOT") && status != 'E'){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface);
			var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,surface_title);
		}
		else if((formObj.oh_surface.disabled == false && site_type=="CROWN" && formObj.oh_surface.options.length > 1) || (formObj.oh_surface.options.length > 1 && site_type=="ROOT") && status == 'E'){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.reasonforcancel);
			var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,surface_title,cancel_reason_title);
		}
		else if(status == "E"){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.reasonforcancel);
			var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,cancel_reason_title);
		}
		else{
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment);
			var names = new Array ( category_title,site_title,area_title,status_title,treatment_title);
		}
		if(checkFieldsofMst( fields, names, messageFrame)){	
			var dentalchartFormObj = parent.trmtDentalChartDetails.document.forms[0];
			var thrng_nos = formObj.thrng_nos.value;
			formObj.chart_hdr_insert_yn.value  = dentalchartFormObj.chart_hdr_insert_yn.value;

			//To retrive all Treatment Category Types Description
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "trmt_category_type="+trmt_category_type;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=populateTrmtCatTypeDesc&"+params,false);
			xmlHttp.send(xmlDoc);
			var trmt_category_type_desc = trimString(xmlHttp.responseText);
			
			if(treatment_status_param == "PLAN" || treatment_status_param == ""){
				if((tooth_no != null && tooth_no != "" && tooth_no.indexOf(",") == -1) || (site_type == "ROOT" || site_type == "CROWN" || site_type == "ARCH" || site_type == "QUAD")){ // This code is for single tooth selection 

				//This function is to check the applicable menu options..
					var ret_val = applicableTrmtOptions(tooth_no,patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,site_type,thrng_nos_ref,trmt_category_type);

					proceed_yn = resultTrmtOptions(tooth_no,mixed_dentition_YN,permanent_deciduous_flag,trmt_category_type);
					var msg = getMessage("APP-OH00047","OH");
					var msg_arr = msg.split("##");
					if(ret_val =="false"){
						alert(msg_arr[0]+trmt_category_type_desc+msg_arr[1]);
						return;
					}
					else if(proceed_yn == "false"){
						alert(msg_arr[0]+trmt_category_type_desc+msg_arr[1]);
						return;
					}
				
				}
				else if(tooth_no != null && tooth_no != "" && tooth_no.indexOf(",") != -1){ // This code is for multiple tooth selection 
					var nors_arr = tooth_no.split(",");
					for(j=0;j<nors_arr.length;j++){
						var len = nors_arr.length;
						var no_of_tooth = parseInt(nors_arr[len-1])-parseInt(nors_arr[0])-1;

						//This function is to check the applicable menu options..
						var ret_val = applicableTrmtOptions(nors_arr[j],patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,site_type,thrng_nos_ref,trmt_category_type,j,nors_arr.length-1,no_of_tooth);

						proceed_yn = resultTrmtOptions(nors_arr[j],mixed_dentition_YN,permanent_deciduous_flag,trmt_category_type);
						var msg = getMessage("APP-OH00047","OH");
						var msg_arr = msg.split("##");
						if(ret_val == "false"){
							alert(msg_arr[0]+trmt_category_type_desc+msg_arr[1]);
							thrng_nos_ref = "";
							formObj.thrng_nos_ref.value = "";
							return;
						}
						else if(proceed_yn == "false"){
							alert(msg_arr[0]+trmt_category_type_desc+msg_arr[1]);
							thrng_nos_ref = "";
							formObj.thrng_nos_ref.value ="";
							return;
						}
					}
					
				}
			}
			//resultTrmtMenuOptions(applicable_trmt_types,applicable_trmt_desc,tooth_no,mixed_dentition_YN,permanent_deciduous_flag,display_menu_yn){
			/*
			if(formObj.called_from_viewchart_yn.value == 'Y' && formObj.treatment_status.value != 'E'){
				appt_scheduled_yn = getApptDetails('', '', patient_id, '',formObj.ca_practitioner_id.value,formObj.location_code.value,'',formObj.location_code.value,formObj.location_type.value,'',formObj.ca_practitioner_id.value,formObj.location_code.value,'OH','OH','','','');
				if(appt_scheduled_yn == "Y"){
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=updateStatus&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					status = localTrimString(retVal);
				}
				formObj.called_from_viewchart_yn.value = "";
			}
			else
			*/
			/* This block of code is to restrict Extract and Implant trmts..
			var tooth_layer = "toothLayer"+tooth_no;
			var root_layer = "rootLayer"+tooth_no;
			if(status != "E"){
				if(site_type == "TOOTH"){
					if((dentalchartFormObj.document.getElementById(root_layer) == null || dentalchartFormObj.document.getElementById(root_layer) == "" || dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == "undefined") && (dentalchartFormObj.document.getElementById(tooth_layer) == null || dentalchartFormObj.document.getElementById(tooth_layer) == "" || dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == "undefined")){
						if(trmt_category_type == "EXTRACT"){
							alert("Extract can't be performed as root and crown are missing");
							return;
						}
					}
					else{
						if(trmt_category_type == "IMPLANT"){
							alert("IMPLANT can be performed only on Missing or Extracted tooth");
							return;
						}
					}
				}
				else if(site_type == "THRNG"){
					var thrng_nos_ref_arr = tooth_no.split(",");
					for (var m=0;m<thrng_nos_ref_arr.length; m++){
						tooth_layer = "toothLayer"+thrng_nos_ref_arr[m];
						root_layer = "rootLayer"+thrng_nos_ref_arr[m];
						if((dentalchartFormObj.document.getElementById(root_layer) == null || dentalchartFormObj.document.getElementById(root_layer) == "" || dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == "undefined") && (dentalchartFormObj.document.getElementById(tooth_layer) == null || dentalchartFormObj.document.getElementById(tooth_layer) == "" || dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == "undefined")){
							if(trmt_category_type == "EXTRACT"){
								alert("Extract can't be performed as root and crown are missing");
								return;
							}
						}
						else{
							if(trmt_category_type == "IMPLANT"){
								alert("IMPLANT can be performed only on Missing or Extracted tooth");
								return;
							}
						}
					}
				}
			}
			*/

			// To check wheter the tasks are associated with the treatment or not..
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "trmt_code="+trmt_code;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=getTasks&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			tasks_yn = localTrimString(retVal);
			if(tasks_yn == "N"){
				alert(getMessage("APP-OH00031","OH"));
				return;
			}

			if((treatment_status_param=="60" || treatment_status_param=="85")){
				var task_code = formObj.task_code.value;
				if(task_code == ""){
					// Insert Diagnosis in to the table 
					if(diagcodeselected!=null && diagcodeselected!="null" && diagcodeselected!=""){
						var diagcodeselected_arr = diagcodeselected.split("~");
						for(i=0;i<diagcodeselected_arr.length;i++){
							diag_code_desc_arr = diagcodeselected_arr[i].split("##");
							var diag_code = diag_code_desc_arr[0] // Diagnosis code
							var term_set_id = diag_code_desc_arr[1] // Term Set Id
							var occur_srl_no = diag_code_desc_arr[2] // Occurance Serial Number
							var diag_status = diag_code_desc_arr[3] // Diagnosis status
							if(treatment_status_param != 'E'){
								insertDiagnosisForTrmt(patient_id,encounter_id,chart_num,chart_line_num,trmt_code,term_set_id,diag_code,occur_srl_no,diag_status,tooth_range_count_for_order);
							}
						}
					}
				}
			}
			
			/*
			// Insert Material Used(Composition) in to the table 
			var comp_code_selected_arr = comp_code_selected.split("~");
			for(i=0;i<comp_code_selected_arr.length;i++){
				mat_code_desc_arr = comp_code_selected_arr[i].split("##");
				var comp_code = mat_code_desc_arr[0] // composition code
				var comp_class_code = mat_code_desc_arr[1] // composition class code
				
				insertMaterialsUsed(patient_id,chart_num,chart_line_num,trmt_code,comp_class_code,comp_code,tooth_range_count_for_order);
			}
			*/

			var order_id = formObj.order_id.value;
			var order_line_num = formObj.order_line_num.value;
			if(treatment_status_param == 'E'){
				//formObj.action="../../servlet/eOH.OHDentalChartAmendServlet";
				var task_code = formObj.task_code.value;
				var reasonforcancel = formObj.reasonforcancel.value;
				
				updateTreatmentStatus(site_type,thrng_nos_ref,patient_id,chart_num,chart_line_num,'E',parseInt(chart_line_num),order_id,trmt_code,task_code,reasonforcancel,encounter_id,trmt_code,order_line_num);

				status_for_filling = 'E';
				//formObj.submit();
			}
			else{
				if(treatment_status_param=="10" && appt_reqd_yn=="Y"){
					
			// this condition is added by bshankar on 09FEB2008. If appt_reqd_yn is YES, scheduling is applicable
					var tFormObj = document.OHTreatmentForm;
					var schedule_yn = getApptDetails('', '', tFormObj.patient_id.value, '',tFormObj.ca_practitioner_id.value,tFormObj.location_code.value,'',tFormObj.location_code.value,tFormObj.location_type.value,'',tFormObj.ca_practitioner_id.value,tFormObj.location_code.value,"OH","OH",'','','',tFormObj.chart_num.value,tFormObj.chart_line_num.value,trmt_category_type,tooth_no,dentalchartFormObj,site_type,surface_code,tFormObj.oh_area.value,tFormObj.oh_area.value,thrng_nos_ref,formObj.order_id.value,formObj.order_line_num.value,formObj.trmt_code.value,formObj.task_code.value);					
				}else if(treatment_status_param=="10" && appt_reqd_yn=="N"){
			// this condition is added by bshankar on 09FEB2008. If appt_reqd_yn is NO, scheduling is not applicable and directly REGISTER function to be invoked
					// Invoke the Register Order
					var task_code = formObj.task_code.value;
					var seq_no = formObj.seq_no.value;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&seq_no="+seq_no;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=getStatusOfPrevTask&"+params,false);
					xmlHttp.send(xmlDoc);
					var task_status = trimString(xmlHttp.responseText);
					task_status = localTrimString(task_status);

					if(task_status != "" && task_status != "60" && task_status != "85"){
						alert(getMessage("APP-OH00063","OH"));
						return;
					}
					else if(task_status == "60" || task_status == "85" || task_status == ""){
						// Invoke the Register Order
						showRegisterOrder('register');
					}
				}else if(treatment_status_param=="15"){
					var task_code = formObj.task_code.value;
					var seq_no = formObj.seq_no.value;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&seq_no="+seq_no;;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=getStatusOfPrevTask&"+params,false);
					xmlHttp.send(xmlDoc);
					var task_status = trimString(xmlHttp.responseText);
					task_status = localTrimString(task_status);
					
					if(task_status != "" && task_status != "60" && task_status != "85"){
						alert(getMessage("APP-OH00063","OH"));
						return;
					}
					else if(task_status == "60" || task_status == "85" || task_status == ""){
						// Invoke the Register Order
						showRegisterOrder('register');
					}
					// Now ORBean has to be invoked
				}else if(treatment_status_param=="25" || treatment_status_param == "52"|| treatment_status_param =="55"|| treatment_status_param=="80"){
					// Invoke the Result Entry Screen
					status_for_filling = showRegisterOrder('result');
					//status_for_filling = "85";
				}else if(treatment_status_param == "PO" || status == "PO"){
					var tFormObj = document.OHTreatmentForm;
					var order_catalog_code = "";
					var order_type_code = "";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "trmt_code="+trmt_code;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=getOrderCatalogDetails&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal = localTrimString(retVal);
					if(retVal.length > 1){
						var retVal_arr =  retVal.split("##");
						order_catalog_code = retVal_arr[0]
						order_type_code = retVal_arr[1]
					}
					placeOrder(patient_id,chart_num,chart_line_num,tooth_range_count_for_order,ca_practitioner_id,formObj.encounter_id.value,formObj.location_type.value,formObj.location_code.value,formObj.patient_class.value,order_catalog_code,order_type_code,formObj.facility_id.value,trmt_code,"RHS_MENU",trmt_category_type,site_type,surface_code,tFormObj.oh_area.value,thrng_nos_ref,tFormObj.oh_area.value,tFormObj.oh_area.value);
				}else{
					formObj.submit();
				}
			}
			//parent.frames[2].expandMenu('menu1',parent.frames[2].document.forms[0].T_arrow);
			parent.frames[2].expandMenu('menu1',parent.frames[2].document.forms[0].T_arrow);
			var el_menu1 = parent.frames[2].document.getElementById("menu1");
			if ( el_menu1.style.display != "none" ) {
				el_menu1.style.display = 'none';
				parent.frames[2].document.forms[0].T_arrow.src = "../../eOH/images/arrow-down.gif";
			}
			else {
				el_menu1.style.display = '';
				parent.frames[2].document.forms[0].T_arrow.src = "../../eOH/images/arrow-up.gif";
			}

			parent.frames[2].expandMenu('menu5',parent.frames[2].document.forms[0].T_arrow);
			var el = parent.frames[2].document.getElementById("menu5");
			if ( el.style.display != "none" ) {
				el.style.display = 'none';
				parent.frames[2].document.forms[0].T_arrow.src = "../../eOH/images/arrow-down.gif";
			}
			else {
				el.style.display = '';
				parent.frames[2].document.forms[0].T_arrow.src = "../../eOH/images/arrow-up.gif";
			}
			//parent.frames[2].expandMenu('menu5',parent.frames[2].document.forms[0].T_arrow);
			

			//parent.frames[2].expandMenu('menuBC',parent.frames[2].document.forms[0].T_arrow);
			//parent.frames[2].expandMenu('menuBC',parent.frames[2].document.forms[0].T_arrow);
			
			var status_int = parseInt(status);
			//Refreshing the form values with the original params
			var old_params = parent.frames[2].document.forms[0].params.value;
			document.location.href = "../../eOH/jsp/DentalTreatment.jsp?"+old_params;
			if(status == "E" || status_int>=25){ // Only for Mark Error Cases. For other casese it calls the functions in the DentalTreatmentStages.js
				if(site_type == "TOOTH" || site_type == "THRNG" || site_type == "ARCH" || site_type == "QUAD"){
					imageReplace(trmt_category_type,tooth_no,dentalChartFormObj,site_type,status,document.forms[0]);
				}
				if(site_type == "CROWN"){				
					tooth_no = 'toothLayer'+tooth_no;
					fillCrownImages(tooth_no,surface_code,dentalChartFormObj,trmt_category_type,status_for_filling);
				}else if(site_type == "ROOT"){
					drawLineForRootImage('rootLayer'+tooth_no,surface_code,dentalChartFormObj,trmt_category_type,"T",tooth_no,status_for_filling);
				}else{
					//if(trmt_category_type != "TOOTHTM") {
						
						if(site_type == "THRNG"){
							var tooth_no_arr = tooth_no.split(",");
							for (var k=0;k<tooth_no_arr.length; k++){
								//To retrieve the display tooth_no and the tooth_name...
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDisplayToothNoAndName&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);
								retVal = localTrimString(retVal);
								if(retVal.length > 1){
									var retVal_arr = retVal.split("##");
									tooth_num = retVal_arr[0];
									tooth_name = retVal_arr[1];
									mapped_tooth_no = retVal_arr[2];
								}
								var tooth_sn = tooth_no_arr[k];
								var imageId = "T"+tooth_no_arr[k];
								//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/T.gif'>";
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

								var imageId = "R"+tooth_no_arr[k];
								if(permanent_deciduous_flag == "D"){
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
								}
								//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='"+imageSrc+"'>";
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"

								var imageId = tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="&nbsp;";

								var imageId = tooth_no_arr[k];
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="&nbsp;";
							}
						}
						getImageFromDB(tooth_no,site_type,chart_num,tab_name,document.forms[0],dentalChartFormObj);
					//}
				}
			}
			//getImageFromDB(tooth_no,site_type,chart_num,tab_name,document.forms[0],dentalChartFormObj);
			Treatment_Reset(formObj,site_type,tooth_no,thrng_nos);

			dentalchartFormObj.chart_hdr_insert_yn.value = "N";	
		}
	}
}

function imageReplace(trmt_category_type,tooth_no,dentalchartFormObj,site_type,status,formObj){
	var numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var tooth_num = "";
	var tooth_name = "";
	var mapped_tooth_no = "";
	var status_int = 0;
	if(trmt_category_type != null && trmt_category_type != "null" && trmt_category_type != "" && trmt_category_type != "undefined"){
		//if(status != "OS" && status != "10"){ // Ordered Status
			if(site_type == "THRNG"){
				var tooth_no_arr = tooth_no.split(",");
				for(var k=0;k<tooth_no_arr.length;k++){
					var tooth_sn = tooth_no_arr[k];
					//To retrieve the display tooth_no and the tooth_name...
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDisplayToothNoAndName&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal = localTrimString(retVal);
					if(retVal.length > 1){
						var retVal_arr = retVal.split("##");
						tooth_num = retVal_arr[0];
						tooth_name = retVal_arr[1];
						mapped_tooth_no = retVal_arr[2];
					}

					if(status == 'E'){
						if( trmt_category_type == "EXTRACT"){
							var imageId = "T"+tooth_no_arr[k];
							//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/T.gif'>";
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

							var imageId = "R"+tooth_no_arr[k];
							if(permanent_deciduous_flag == "D"){
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}
							//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='"+imageSrc+"'>";
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"
						}
						else if(trmt_category_type == "IMPLANT"){
							var imageId = "T"+tooth_no_arr[k];
							//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/T.gif'>";
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

							var imageId = "R"+tooth_no_arr[k];
							if(permanent_deciduous_flag == "D"){
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}
							//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='"+imageSrc+"'>";
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"
						}
						/*
						else if(trmt_category_type == "TOOTHTM"){
							var imageId = "toothLayer"+tooth_no_arr[k];
							fillCrownImages(imageId,"ALL",frameObj,trmt_category_type,status);

							var imageId = "rootLayer"+tooth_no_arr[k];
							drawLineForRootImage(imageId,"ALL",dentalchartFormObj,trmt_category_type,"T",tooth_no_arr[k],status);
						}
						*/
					}
					else{
						status_int = parseInt(status);
						if(trmt_category_type == "EXTRACT"){
							if(status_int >= 10 && (status_int < 60 || status_int < 85)){ // planned
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownYellow.gif'>";

								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootYellow.gif'>";
							}
							else if(status_int == 60 || status_int == 85){
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen.gif'>";

								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen.gif'>";
							}
							
						}
						else if(trmt_category_type == "IMPLANT"){
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant.gif' width='45' height='25'/>";

							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant.gif' width='45' height=34'/>";
						}
						/*
						else if(trmt_category_type == "TOOTHTM"){
							var imageId = "toothLayer"+tooth_no_arr[k];
							fillCrownImages(imageId,"ALL",frameObj,trmt_category_type,status);

							var imageId = "rootLayer"+tooth_no_arr[k];
						drawLineForRootImage(imageId,"ALL",dentalchartFormObj,trmt_category_type,"T",tooth_no_arr[k],status);
						}
						*/
					}
				}
			}
			else if(site_type == "TOOTH"){
				var tooth_sn = tooth_no;
				//To retrieve the display tooth_no and the tooth_name...
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDisplayToothNoAndName&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal = localTrimString(retVal);
				if(retVal.length > 1){
					var retVal_arr = retVal.split("##");
					tooth_num = retVal_arr[0];
					tooth_name = retVal_arr[1];
					mapped_tooth_no = retVal_arr[2];
				}
				if(status == 'E'){
					if( trmt_category_type == "EXTRACT"){
						var imageId = "T"+tooth_no;
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/T.gif'>";
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

						var imageId = "R"+tooth_no;
						if(permanent_deciduous_flag == "D"){
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
						}
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='"+imageSrc+"'>";
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"
					}
					else if(trmt_category_type == "IMPLANT"){
						var imageId = "T"+tooth_no;
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/T.gif'>";
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

						var imageId = "R"+tooth_no;
						if(permanent_deciduous_flag == "D"){
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
						}
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='"+imageSrc+"'>";
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"
					}
					/*
					else if(trmt_category_type == "TOOTHTM" && site_type == "TOOTH"){
						var imageId = "toothLayer"+tooth_no;
						fillCrownImages(imageId,"ALL",frameObj,trmt_category_type,status);

						var imageId = "rootLayer"+tooth_no;
						drawLineForRootImage(imageId,"ALL",dentalchartFormObj,trmt_category_type,"T",tooth_no,status);
					}
					*/
				}
				else{
					status_int = parseInt(status);
					if(trmt_category_type == "EXTRACT"){
						if(status_int >= 10 && (status_int < 60 || status_int < 85)){ // planned
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownYellow.gif'>";

							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootYellow.gif'>";
						}
						else if(status_int == 60 || status_int == 85){
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen.gif'>";

							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen.gif'>";
						}
					}
					else if(trmt_category_type == "IMPLANT"){
						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant.gif' width='45' height='25'/>";

						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant.gif' width='45' height=34'/>";
					}
					/*
					else if(trmt_category_type == "TOOTHTM"){
						var imageId = "toothLayer"+tooth_no;
						fillCrownImages(imageId,"ALL",frameObj,trmt_category_type,status);

						var imageId = "rootLayer"+tooth_no;
						drawLineForRootImage(imageId,"ALL",dentalchartFormObj,trmt_category_type,"T",tooth_no,status);
					}
					*/
				}
			}
			else if(site_type == "ARCH" || site_type == "QUAD"){
				if(trmt_category_type == "TOOTHTM"){
					if(site_type == "ARCH"){
						var imageId = "COLORA"+tooth_no;
						fill_color = "#99ddee";
					}else if(site_type == "QUAD"){
						var imageId = "COLORQ"+tooth_no;
						fill_color = "#CCECFF";
					}
					dentalchartFormObj.document.getElementById(imageId).style.backgroundColor = fill_color;
				}
			}
		//}
	}
	else{
		status_int = parseInt(status);
		if(site_type == "ARCH"){
			
			var imageId = "COLORA"+tooth_no;
			if(status == "E" || status == "undefined" || status == "" || status == "null" || status == null){
				fill_color = "#99ddee";
			}
			else if(status_int >= 10 && (status_int < 60 || status_int < 85)){
				fill_color = "yellow";
			}
			else{
				fill_color = "lightgreen";
			}
			dentalchartFormObj.document.getElementById(imageId).style.backgroundColor = fill_color;
		}else if(site_type == "QUAD"){
			var imageId = "COLORQ"+tooth_no;
			if(status == "E" || status == "undefined" || status == "" || status == "null" || status == null){
				fill_color = "#CCECFF";
			}
			else if(status_int >= 10 && (status_int < 60 || status_int < 85)){
				fill_color = "yellow";
			}
			else{
				fill_color = "lightgreen";
			}
			dentalchartFormObj.document.getElementById(imageId).style.backgroundColor = fill_color;
		}
		else{
			var imageId = "R"+tooth_no;
			var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
			if(dentalchartFormObj.document.getElementById(imageId) != null){
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='"+imageSrc+"'>";
			}
			var imageId = "T"+tooth_no;
			if(dentalchartFormObj.document.getElementById(imageId) != null){
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/T.gif'/>";
			}
		}
	}
}

/*
Not Used
function buildRegisterOrderMenu(){
	var tab_dat  = "<table id ='tooltiptable' cellpadding='3' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	tab_dat     += "<tr>";
	tab_dat     += "<td nowrap id='mouse' class='Menu'><a href = \"javascript:showRegisterOrder('register')\">Register Order</a></td>";
	tab_dat     += "</tr> ";
	tab_dat     += "<tr>";
	tab_dat     += "<td nowrap id='mouse' class='Menu'><a href = \"javascript:showRegisterOrder('result')\">Result Entry</a></td>";
	tab_dat     += "</tr> ";
	tab_dat     += "</table> ";	
	document.getElementById("menu_table").innerHTML = tab_dat;
	resizeWindow();
}
*/
function resizeWindow(){
	/*
	window.pageX = window.event.pageX | window.event.clientX;
	window.pageY = window.event.pageY |  window.event.clientY;

	var x =window.pageX + document.body.scrollLeft;
	var y = window.pageY + document.body.scrollTop;

	document.getElementById("tooltiplayer").style.posLeft= x;
	document.getElementById("tooltiplayer").style.posTop = y;
	document.getElementById("tooltiplayer").style.visibility='visible';
	*/
		bodwidth = parent.frames[1].document.body.offsetWidth
		bodheight = parent.frames[1].document.body.offsetHeight
		var x =  event.x;
		var y =  event.y;

		x = x + (document.getElementById("tooltiplayer").offsetWidth)
		y = y + (document.getElementById("tooltiplayer").offsetHeight)

		if(x<bodwidth)
			x =event.x
		else
			x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

		if(y<bodheight || event.y<150){
			if(event.y<150)
			  y =event.y-30
		}else{
			y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
		}

		y+=document.body.scrollTop
		x+=document.body.scrollLeft

		document.getElementById("tooltiplayer").style.posLeft= x
		document.getElementById("tooltiplayer").style.posTop = y
		document.getElementById("tooltiplayer").style.visibility='visible'
}

function hideToolTip(){
	document.getElementById("tooltiplayer").style.visibility = 'hidden';
}

function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

async function showRegisterOrder(param){
	var formObj = document.OHTreatmentForm;
	var order_id = formObj.order_id.value;
	var order_line_num = formObj.order_line_num.value;
	var encounter_id = formObj.encounter_id.value;
	var practitioner_id = formObj.ca_practitioner_id.value;
	var facility_id = formObj.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var patient_class = formObj.patient_class.value;
	var site_type = formObj.oh_site.value;
	var thrng_nos_ref = formObj.thrng_nos_ref.value;
	var trmt_code = formObj.trmt_code.value;
	var task_code = formObj.task_code.value;
	if(param=="register"){
			var retVal = formApply(formObj,OR_CONTROLLER );
			retVal=trimString(retVal);
			eval(retVal);
			if(message!=""){					
				updateTreatmentStatus(site_type,thrng_nos_ref,patient_id,chart_num,chart_line_num,"25",parseInt(chart_line_num),order_id,trmt_code,task_code,'','','',order_line_num);
			}					
	}
	else if(param=="result"){

		/*
		Arguments whic are passed when Result entry is being called from CA screen
		var params = "p_called_from_ca =Y&option_id=ORDER_REPORTING1&module_id=OH&access=NNYNN&child_window=N&limit_function_id=&chartTitle=&reln_req_yn=N&limit_function_id=";
		*/		
		var finalString	= "colval1=ResultEntry&colval=ResultEntry&orderId="+order_id+"&patient_id="+patient_id+"&patient_class="+ patient_class;
		finalString = finalString + "&order_category=OH";
		finalString += "&can_location_type="+formObj.location_type.value;
		finalString += "&can_location="+formObj.location_code.value;
		finalString += "&can_order_category=OH";
		finalString += "&can_single_multi=S";
		finalString += "&can_priority=R";
		finalString += "&can_date_from=";
		finalString += "&can_date_to=";
		finalString += "&can_patient_id="+patient_id;
		finalString += "&can_order_id="+order_id;
		finalString += "&order_line_num="+order_line_num;
		finalString += "&can_encounter_id="+encounter_id;
		finalString += "&can_patient_id_found=";
		finalString += "&can_order_type=";
		finalString += "&can_performing_location_code="+formObj.location_code.value;
		finalString += "&can_specimen_no=";
		finalString += "&can_catalog_desc=";
		finalString += "&can_search_criteria=";
		finalString += "&can_source_location_type=";
		finalString += "&can_source_locn=";
		finalString += "&can_group_by=";
		finalString += "&can_task_status=";
		finalString += "&from=OHResultEntry";

		var params = "orderId="+order_id+"&order_category=OH";
		params=params+"&patient_id="+patient_id+"&episode_id="+encounter_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id;
		var url	= "../../eOR/jsp/ResultEntry.jsp?"+finalString;
		var dialogHeight= "40" ;
		var dialogWidth = "65" ;
		var dialogTop  = "71";
		var center  = "1" ;
		var status  = "no";				
		var arguments	= "" ;
		var features = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var retval = await window.showModalDialog(url,arguments,features);
		if(retval!=null && retval!="undefined"){
			//retval=="1" - In Progress
			//retval=="2" - Partially
			//retval=="3" - Completed
			var return_status	= updateTreatmentStatus(site_type,thrng_nos_ref,formObj.patient_id.value,formObj.chart_num.value,formObj.chart_line_num.value,"60",parseInt(chart_line_num),order_id,trmt_code,task_code,'','','',order_line_num);
			if(return_status=="60" || return_status == "85"){
				parent.frames[2].expandMenu('menu5',parent.frames[2].document.forms[0].T_arrow);
				parent.frames[2].expandMenu('menu5',parent.frames[2].document.forms[0].T_arrow);
			}
		}

	}
	return return_status;
}

function applicableTrmtOptions(tooth_no,patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,site,thrng_nos_ref,trmt_category_type,counter,len,no_of_tooth){

	var formObj = document.forms[0]; 
	var dentalChartFormObj = parent.trmtDentalChartDetails;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	
	var applicable_trmt_types_arr = new Array();
	var applicable_trmt_types_arr1 = new Array();
	var err_msg = "true";

	if(site == "THRNG"){ // For Tooth Range
		tooth_layer = "toothLayer"+tooth_no;
		root_layer = "rootLayer"+tooth_no;
		if(len >1){ //This is exclusively for Bridge Treatment
			if((counter == "0" || counter == len) && trmt_category_type == "BRIDGE"){
				if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined"){
					err_msg = "true";
					return err_msg;
				}
				else{
					if(trmt_category_type == "BRIDGE"){
						err_msg = "false";
						return err_msg;
					}
				}
			}
			else if(counter > 0  && counter < len && trmt_category_type == "BRIDGE" && no_of_tooth == (parseInt(len)-1)){
				
				if((dentalChartFormObj.document.getElementById(root_layer) == null || dentalChartFormObj.document.getElementById(root_layer) == "null" || dentalChartFormObj.document.getElementById(root_layer) == undefined || dentalChartFormObj.document.getElementById(root_layer) == "undefined") && (dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined")){
							err_msg = "true";
							return err_msg;
				}
				else{
					if(trmt_category_type == "BRIDGE"){
						err_msg = "false";
						return err_msg;
					}
				}
			}
			else{
				if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined"){
					if(trmt_category_type != "EXTRACT" && trmt_category_type != "TOOTHTM" && trmt_category_type != "ORTHO"){
						err_msg = "false";
						return err_msg;
					}
				}
				else{
					if(trmt_category_type != "DENTURE" && trmt_category_type != "IMPLANT" && trmt_category_type != "IMPACT"){
						err_msg = "false";
						return err_msg;
					}
				}
			}
		}
		else{ //Other than Bridge trmt
			if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined"){
				if(trmt_category_type != "EXTRACT" && trmt_category_type != "TOOTHTM" && trmt_category_type != "ORTHO"){
					err_msg = "false";
					return err_msg;
				}
			}
			else{
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=allConditionsRecorded&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText); 
				retVal = localTrimString(retVal); 
				if(retVal.length >1){
					var retVal_arr = retVal.split("~");
					for(m=0;m<retVal_arr.length-1;m++){
						var code_desc_arr = retVal_arr[m].split("##");
						if((code_desc_arr[0] == "UNERTH" || code_desc_arr[0] == "PARERTH" || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){
							if(trmt_category_type != "IMPLANT" && trmt_category_type != "IMPACT"){
								err_msg = "false";
								return err_msg;
							}
						}
						else{
							if(trmt_category_type != "DENTURE" && trmt_category_type != "IMPLANT" && trmt_category_type != "IMPACT"){
								err_msg = "false";
								return err_msg;
							}
						}
					}
				}
			}
		}
	}
	else if(site == "TOOTH"){ // For site type other than Tooth Range
		tooth_layer = "toothLayer"+tooth_no;
		root_layer = "rootLayer"+tooth_no;
		
		if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined"){
			if(trmt_category_type != "EXTRACT" && trmt_category_type != "TOOTHTM" &&trmt_category_type != "ORTHO"){
				err_msg = "false";
				return err_msg;
			}
		}
		else{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			params = "func_mode=allConditionsRecorded&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText); 
			retVal = localTrimString(retVal); 
			if(retVal.length >1){
				var retVal_arr = retVal.split("~");
				for(m=0;m<retVal_arr.length-1;m++){
					var code_desc_arr = retVal_arr[m].split("##");
					if((code_desc_arr[0] == "UNERTH" || code_desc_arr[0] == "PARERTH" || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){
						if(trmt_category_type != "IMPLANT" && trmt_category_type != "IMPACT"){
							err_msg = "false";
							return err_msg;
						}
					}
					else{
						if(trmt_category_type != "DENTURE" && trmt_category_type != "BRIDGE" && trmt_category_type != "IMPLANT"){
							err_msg = "false";
							return err_msg;
						}
					}
				}
			}
			else{
				if(trmt_category_type != "DENTURE" && trmt_category_type != "BRIDGE" && trmt_category_type != "IMPLANT"){
					err_msg = "false";
					return err_msg;
				}
			}
		}
	}
	else if(site == "ROOT" || site == "CROWN"){
		tooth_layer = "toothLayer"+tooth_no;
		root_layer = "rootLayer"+tooth_no;
		if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && site == "ROOT"){
			err_msg = "true";
			return err_msg;
		}
		else if(dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined" && site == "CROWN"){
			err_msg = "true";
			return err_msg;
		}
		else{
			err_msg = "false";
			return err_msg;
		}
	}
	err_msg = "true";
	return err_msg;
}

function resultTrmtOptions(tooth_no,mixed_dentition_YN,permanent_deciduous_flag,trmt_category_type){
	temp_array = new Array();
	temp_array_desc = new Array();
	var err_msg = "true";
	if(mixed_dentition_YN == "Y"){ // For Mixed Dentition Case
		if(permanent_deciduous_flag == "D"){ // For Mixed Dentition - Deciduous Chart
			if(trmt_category_type == "IMPACT" && trmt_category_type == "IMPLANT"){
				err_msg = "false";
				return err_msg;
			}
		}
		else{ //For Mixed Dentition - Permanent Chart
			if(trmt_category_type == "IMPACT" && trmt_category_type == "IMPLANT"){
				err_msg = "false";
				return err_msg;
			}
		}
	}
	else{ // Other than Mixed Dentition case
		if(permanent_deciduous_flag == "D"){ // For Deciduous Chart
			if(trmt_category_type == "DENTURE" && trmt_category_type == "BRIDGE" && trmt_category_type == "IMPACT" && trmt_category_type == "IMPLANT" && trmt_category_type == "ORTHO"){
				err_msg = "false";
				return err_msg;
					
			}
		}
		else if(permanent_deciduous_flag == "P"){ //For Permanent Chart
			err_msg = "true";
			return err_msg;
		}
	}
	err_msg = "true";
	return err_msg;
}

function clearDentalcondition(){
	var formObj = document.forms[0];
	//formObj.oh_treatment.value = "";
}

