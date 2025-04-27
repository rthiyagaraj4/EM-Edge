var hasChanged = false;
var isExfoliated = false;
var isErupted = false;
var isDeciduousTooth = false;
var tooth_no_RD = "";
var count_GS = 0;
var count_Recorded_GS = 0;
var isExfoliatedMissing = false;
var flag_for_previous_recording = "";
var isDeciduous = false;
var isExfoliatedAfter = false;
var isErupted = false;
var isEruptedBeforeAfter = false;
var isExfoliatedDeciduous = false;
var GS_overridden = false;									  
var isSuperYN = false;
var isRetainedDeciduous = false;
var isExtracted = false;
var isImplanted = false;
var isErupted1=false;	//Added by Sridevi Joshi on 2/19/2010 for IN019368
var isExfoliated1 = false;//Added by Sridevi Joshi on 2/19/2010 for IN019368
var isSuperYN1 = false;//Added by Sridevi Joshi on 2/19/2010 for IN019368
var count_maxlia=1;



function checkFieldsofMst( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else    errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>"
    }
    if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
        return false ;
    }
    return true ; 
}

// Function for tab Reset
function DC_Tab_Reset_button(formObj,site_type,tooth_no,thrng_nos,clinical_group_before_refresh){
	//To reset Error Msg Frame
	parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';

	DC_Tab_Reset(formObj,site_type,tooth_no,thrng_nos,clinical_group_before_refresh);
}

// Function for tab Reset
function DC_Tab_Reset(formObj,site_type,tooth_no,thrng_nos,clinical_group_before_refresh){
	//parent.parent.frames[1].document.forms[0].date_diff_flag.value="";
	//var a=parent.parent.frames[1].document.forms[0].date_diff_flag.value;
	//var disable_fields_YN = formObj.disable_fields_YN.value;
	//Refreshing the form values with the original params
	var old_params = parent.parent.frames[2].document.forms[0].params.value;
	//var old_params = parent.parent.parent.parent.frames[2].frames[1].frames[2].document.forms[0].params.value;
	
	document.location.href = "../../eOH/jsp/DentalCondition.jsp?"+old_params;
	parent.f_query_add_mod_middle.document.location.href = "../../eOH/jsp/OHDentalChartSubTabSearch.jsp?"+old_params+"&defaultTab=DentalCondition&clinical_group_before_refresh="+clinical_group_before_refresh;
	var dentalChartFormObj = parent.parent.frames[1].document.dentalChartMainForm;
	var site_type = formObj.oh_site.value;
	var tooth_no = formObj.oh_area.value;
	var thrng_nos_ref = formObj.thrng_nos_ref.value;
	var count_checked = 0;
	if(site_type == "null" || site_type == null || site_type == "" || tooth_no == "" || tooth_no == "null" || tooth_no == null || tooth_no == "undefined" || tooth_no == undefined){
		for (j=1;j<=52;j++){
			if(eval("dentalChartFormObj.selcol"+j) != null && eval("dentalChartFormObj.selcol"+j) != "null"){
				if(eval("dentalChartFormObj.selcol"+j).checked == true){
					if(count_checked==0){
						site_type = "TOOTH";
						thrng_nos_ref = j+"";
						tooth_no = j+"";
					}
					else{
						site_type = "THRNG";
						thrng_nos_ref = thrng_nos_ref+","+j;
					}
					count_checked++;
				}
			}
		}
	}
	else{
		for (j=1;j<=52;j++){
			if(eval("dentalChartFormObj.selcol"+j) != null && eval("dentalChartFormObj.selcol"+j) != "null"){
				if(eval("dentalChartFormObj.selcol"+j).checked == true){
					if(count_checked==0){
						site_type = "TOOTH";
						thrng_nos_ref = j+"";
						tooth_no = j+"";
					}
					else{
						site_type = "THRNG";
						thrng_nos_ref = thrng_nos_ref+","+j;
					}
					count_checked++;
				}
			}
		}
	}
	// This code is to reset the Arch checkboxes
	dentalChartFormObj.selL.checked=false; // Lower Arch
	dentalChartFormObj.selU.checked=false;	// Upper Arch

	//This code is to reset the Quadrant checkboxes
	dentalChartFormObj.sel1.checked=false; // Upper Right
	dentalChartFormObj.sel2.checked=false; // Upper Left
	dentalChartFormObj.sel3.checked=false; // Lower Left
	dentalChartFormObj.sel4.checked=false; // Lower Right
	if(document.getElementById("status_show_yn") != null){
		document.getElementById("status_show_yn").innerHTML = "&nbsp;";
		document.getElementById("status_legend").innerHTML = "&nbsp;";
	}
	document.getElementById("MandatorySurface").style.visibility = "hidden";
	//document.getElementById("MandatorySurface").style.visibility = "hidden";
	//document.getElementById("MandatorySurface").style.visibility = "hidden";
	formObj.oh_condition_type.value = "";
	formObj.oh_site.value = "";
	formObj.oh_area.value = "";
	//formObj.oh_status.value = "";
	formObj.oh_dental_condition.value = "";
	formObj.oh_surface.value = "";
	formObj.oh_cusp_tip.value = "";
	formObj.selected_first_thno.value = "";
	
	
	formObj.condition_type.value = "";
	formObj.site.value = "";
	formObj.area.value = "";
	formObj.dental_condition.value = "";
	formObj.thrng_nos_ref.value = "";
	formObj.thrng_nos.value = "";
	formObj.called_from_viewchart_yn.value = ""; // This is to allow the usr to record now condition/treatments.If this value is 'Y' dental Chart operations are disabled.
	clear_list(formObj.oh_site);
	if((thrng_nos != "undefined" && thrng_nos != undefined) && site_type != "THRNG" && site_type != "undefined" && site_type != "null" && site_type != null && site_type != "" && thrng_nos.indexOf(",") == -1){
		clear_list(formObj.oh_area);
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].oh_area.add(optSel);
	}
	if((thrng_nos != "undefined" && thrng_nos != undefined) && (site_type == "THRNG" || thrng_nos.indexOf(",") != -1)){
		document.forms[0].oh_area.value = "";
		formObj.document.getElementById("area_field").innerHTML = "<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);' ></select>"
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].oh_area.add(optSel);
	}
	clear_list(formObj.oh_dental_condition);
	clear_list(formObj.oh_surface);
	formObj.document.getElementById("cusp_field").innerHTML = "<select name='oh_cusp_tip' id='oh_cusp_tip' multiple></select>"
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_cusp_tip.add(optSel);

	//clear_list(formObj.oh_cusp_tip);
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_site.add(optSel);
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_dental_condition.add(optSel);
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_surface.add(optSel);
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_cusp_tip.add(optSel);

	document.getElementById("change_area").innerHTML = getLabel("Common.area.label","Common");
  // var called_from_viewchart_yn=formObj.called_from_viewchart_yn.value;
 // var tool_reset=formObj.tool_reset.value;
	formObj.oh_condition_type.disabled = false;
	formObj.oh_area.disabled = false;
	formObj.oh_site.disabled = false;
	formObj.oh_dental_condition.disabled = false;
 //  }
	// Make the Dental Chart Tooth numbers checkbox to false(Uncheck)

	if(site_type=="THRNG" || (site_type=="TOOTH" && tooth_no.indexOf(",") != -1)){
		if(thrng_nos_ref != "" && thrng_nos_ref != "null" && thrng_nos_ref != null && thrng_nos_ref != "undefined"){
			var range_tooth_no = thrng_nos_ref.split(",");
			for(i=0;i<range_tooth_no.length;i++){
				var tooth_no_for_range = range_tooth_no[i];
				eval("dentalChartFormObj.selcol"+tooth_no_for_range).checked=false;
				eval("dentalChartFormObj.selcol"+tooth_no_for_range).value="N";
			}
		}
	}else if(site_type=="TOOTH" && ((tooth_no.indexOf() == -1) || (tooth_no.indexOf("s") != -1))){
		if(tooth_no != "" && tooth_no != "null" && tooth_no != null && tooth_no != "undefined"){
			eval("dentalChartFormObj.selcol"+tooth_no).checked=false;
			eval("dentalChartFormObj.selcol"+tooth_no).value="N";
		}
	}
	else if(site_type=="ARCH" || site_type=="QUAD"){
		if(tooth_no != "" && tooth_no != "null" && tooth_no != null && tooth_no != "undefined"){
			eval("dentalChartFormObj.sel"+tooth_no).checked=false;
			eval("dentalChartFormObj.sel"+tooth_no).value="N";
		}
	}

	dentalChartFormObj.UR_quadrant_applicable_yn.value= "Y";
	dentalChartFormObj.UL_quadrant_applicable_yn.value= "Y";
	dentalChartFormObj.LL_quadrant_applicable_yn.value= "Y";
	dentalChartFormObj.LR_quadrant_applicable_yn.value= "Y";
	dentalChartFormObj.lower_arch_applicable_yn.value= "Y";
	dentalChartFormObj.upper_arch_applicable_yn.value= "Y";

	//formObj.thrng_nos_ref.value = "";
	//This param is to clear 'selected_tooth_count' for multi selection on Supernumenary tooth after form submission(after reset)
	dentalChartFormObj.reset_done.value="Y";
	
	parent.f_query_add_mod_middle.document.getElementById("tablist").disabled = false;
	//parent.f_query_add_mod_middle.docuemnt.forms[0].param="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&type=&site=&code=&chart_num="+chart_num+"&show_new_active_yn=N&called_from_viewchart_yn=N&arch_quad=&thrng_nos=&thrng_nos_ref=&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&ref_tooth_no=&chart_line_num="+chart_line_num+"&surface=;
}

function ET_Tab_Reset_button(formObj,site_type,tooth_no,thrng_nos){
	//To reset Error Msg Frame
	parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';

	ET_Tab_Reset(formObj,site_type,tooth_no,thrng_nos)
}
function ET_Tab_Reset(formObj,site_type,tooth_no,thrng_nos){
	//Refreshing the form values with the original params
	var old_params = parent.parent.frames[2].document.forms[0].params.value;
	document.location.href = "../../eOH/jsp/DentalExtTreatment.jsp?"+old_params;
	//Commented by Sharon Crasta on 7/28/2009
	//If recordings are done on the External Trmt tab, then by default the external TReatment tab should be displayed.
	//parent.f_query_add_mod_middle.document.location.href = "../../eOH/jsp/OHDentalChartSubTabSearch.jsp?"+old_params+"&defaultTab=ExtTreatment";
	parent.f_query_add_mod_middle.document.location.href = "../../eOH/jsp/OHDentalChartSubTabSearch.jsp?"+old_params+"&defaultTab=ExtTreatment"+"&called_from_Ext_Trmt=Y";

	var dentalChartFormObj = parent.parent.frames[1].document.dentalChartMainForm;
	var site_type = formObj.oh_site.value;
	var tooth_no = formObj.oh_area.value;
	var thrng_nos_ref = formObj.thrng_nos_ref.value;
	var count_checked = 0;
	if(site_type == "null" || site_type == null || site_type == "" || tooth_no == "" || tooth_no == "null" || tooth_no == null || tooth_no == "undefined" || tooth_no == undefined){
		for (j=1;j<=52;j++){
			if(eval("dentalChartFormObj.selcol"+j) != null && eval("dentalChartFormObj.selcol"+j) != "null"){
				if(eval("dentalChartFormObj.selcol"+j).checked == true){
					if(count_checked==0){
						site_type = "TOOTH";
						thrng_nos_ref = j+"";
						tooth_no = j+"";
					}
					else{
						site_type = "THRNG";
						thrng_nos_ref = thrng_nos_ref+","+j;
					}
					count_checked++;
				}
			}
		}
	}
	else{
		for (j=1;j<=52;j++){
			if(eval("dentalChartFormObj.selcol"+j) != null && eval("dentalChartFormObj.selcol"+j) != "null"){
				if(eval("dentalChartFormObj.selcol"+j).checked == true){
					if(count_checked==0){
						site_type = "TOOTH";
						thrng_nos_ref = j+"";
						tooth_no = j+"";
					}
					else{
						site_type = "THRNG";
						thrng_nos_ref = thrng_nos_ref+","+j;
					}
					count_checked++;
				}
			}
		}
	}

	// This code is to reset the Arch checkboxes
	dentalChartFormObj.selL.checked=false; // Lower Arch
	dentalChartFormObj.selU.checked=false;	// Upper Arch

	//This code is to reset the Quadrant checkboxes
	dentalChartFormObj.sel1.checked=false; // Upper Right
	dentalChartFormObj.sel2.checked=false; // Upper Left
	dentalChartFormObj.sel3.checked=false; // Lower Left
	dentalChartFormObj.sel4.checked=false; // Lower Right
	document.getElementById("MandatorySurface").style.visibility = "hidden";
	formObj.oh_category.value = "";
	formObj.oh_site.value = "";
	formObj.oh_area.value = "";
	formObj.oh_status.value = "";
	formObj.oh_treatment.value = "";
	formObj.oh_location.value = "";
	formObj.oh_surface.value = "";
	formObj.oh_performed_date.value = "";
	formObj.oh_outcome.value = "";

	formObj.category.value = "";
	formObj.site.value = "";
	formObj.area.value = "";
	formObj.treatment.value = "";
	formObj.thrng_nos_ref.value = "";
	formObj.thrng_nos.value = "";

	formObj.called_from_viewchart_yn.value = ""; // This is to allow the usr to record now condition/treatments.If this value is 'Y' dental Chart operations are disabled.

	clear_list(formObj.oh_site);
	if(site_type != "THRNG" && site_type != "undefined" && site_type != "null" && site_type != "" && site_type != null){
		clear_list(formObj.oh_area);
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].oh_area.add(optSel);
	}
	if(site_type == "THRNG"){
		document.forms[0].oh_area.value = "";
		formObj.document.getElementById("area_field").innerHTML = "<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);' ></select>"
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].oh_area.add(optSel);
	}
	clear_list(formObj.oh_treatment);
	clear_list(formObj.oh_surface);
	clear_list(formObj.oh_status);
	clear_list(formObj.oh_outcome);

	formObj.document.getElementById("cusp_field").innerHTML = "<select name='oh_cusp_tip' id='oh_cusp_tip' multiple></select>"
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_cusp_tip.add(optSel);

	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_site.add(optSel);

	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_treatment.add(optSel);

	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_surface.add(optSel);
	
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_status.add(optSel);
	optSelComp	= document.createElement("OPTION");
	optSelComp.text = getLabel("Common.complete.label","Common");
	optSelComp.value= 'C'; 
	document.forms[0].oh_status.add(optSelComp);
	optSelIncomp	= document.createElement("OPTION");
	optSelIncomp.text = getLabel("Common.incomplete.label","Common");
	optSelIncomp.value= 'I'; 
	document.forms[0].oh_status.add(optSelIncomp);
	 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_outcome.add(optSel);
	optSelComp	= document.createElement("OPTION");
	optSelComp.text = getLabel("Common.Success.label","common");
	optSelComp.value= 'S'; 
	document.forms[0].oh_outcome.add(optSelComp);
	optSelIncomp	= document.createElement("OPTION");
	optSelIncomp.text = getLabel("Common.Failure.label","Common");
	optSelIncomp.value= 'F'; 
	document.forms[0].oh_outcome.add(optSelIncomp);

	document.getElementById("change_area").innerHTML = getLabel("Common.area.label","Common");

	formObj.oh_category.disabled = false;
	formObj.oh_area.disabled = false;
	formObj.oh_site.disabled = false;
	formObj.oh_status.disabled = false;
	formObj.oh_treatment.disabled = false;
	formObj.oh_location.disabled = false;
	formObj.oh_surface.disabled = true;
	formObj.oh_performed_date.disabled = false;
	//formObj.oh_outcome.disabled = false;

	// Make the Dental Chart Tooth numbers checkbox to false(Uncheck)
	
	if(site_type=="THRNG"){
		if(thrng_nos_ref != "" && thrng_nos_ref != "null" && thrng_nos_ref != null && thrng_nos_ref != "undefined"){
			var range_tooth_no = thrng_nos_ref.split(",");
			for(i=0;i<range_tooth_no.length;i++){
				eval("dentalChartFormObj.selcol"+range_tooth_no[i]).checked=false;
				eval("dentalChartFormObj.selcol"+range_tooth_no[i]).value="N";
			}
		}
	}else if(site_type=="TOOTH"){
		if(tooth_no != "" && tooth_no != "null" && tooth_no != null && tooth_no != "undefined"){
		
			eval("dentalChartFormObj.selcol"+tooth_no).checked=false;
			eval("dentalChartFormObj.selcol"+tooth_no).value="N";
		}
	}
	else if(site_type=="ARCH" || site_type=="QUAD"){
		if(tooth_no != "" && tooth_no != "null" && tooth_no != null && tooth_no != "undefined"){
			eval("dentalChartFormObj.sel"+tooth_no).checked=false;
			eval("dentalChartFormObj.sel"+tooth_no).value="N";
		}
	}
	parent.f_query_add_mod_middle.document.getElementById("tablist").disabled = false;

	dentalChartFormObj.UR_quadrant_applicable_yn.value= "Y";
	dentalChartFormObj.UL_quadrant_applicable_yn.value= "Y";
	dentalChartFormObj.LL_quadrant_applicable_yn.value= "Y";
	dentalChartFormObj.LR_quadrant_applicable_yn.value= "Y";
	dentalChartFormObj.lower_arch_applicable_yn.value= "Y";
	dentalChartFormObj.upper_arch_applicable_yn.value= "Y";

}

function Treatment_Reset_Button(formObj,site_type,tooth_no,thrng_nos){
	var ext_perm_loc_param = formObj.ext_perm_loc_param.value;
	var trmt_yn = formObj.treatment_flag.value;
	var trmt_done_yn = formObj.trmt_done_yn.value;
	var treatment_status_param = formObj.treatment_status_param.value;
	var treatment_status_param_int = parseInt(treatment_status_param);
	if(ext_perm_loc_param == "Y" || (treatment_status_param_int >=25 && trmt_yn != "Y" && trmt_done_yn != "Y") || treatment_status_param==undefined){//Added by Sridevi Joshi for CRF-702(IN012606)
		parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	}else{
		parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	}
	Treatment_Reset(formObj,site_type,tooth_no,thrng_nos,"Treatment_Reset_Button");
}

function Treatment_Reset(formObj,site_type,tooth_no,thrng_nos,trmt_button){
	
	var site_type = formObj.oh_site.value;
	var tooth_no = formObj.oh_area.value;
	var ext_perm_loc_param = formObj.ext_perm_loc_param.value;
	var trmt_yn = formObj.treatment_flag.value;
	var trmt_done_yn = formObj.trmt_done_yn.value;
	var treatment_status_param = formObj.treatment_status_param.value;
	var treatment_status_param_int = parseInt(treatment_status_param);
	var treatment_status=formObj.treatment_status.value;
	
	if(trmt_button == "Treatment_Reset_Button"){
		if(ext_perm_loc_param == "Y" || (treatment_status_param_int >=25 && trmt_yn != "Y" && trmt_done_yn != "Y") || treatment_status_param==undefined){//Added by Sridevi Joshi for CRF-702(IN012606)
			//var old_params = parent.parent.frames[2].document.forms[0].params.value;
			//parent.document.location.href = "../../eOH/jsp/DentalTreatment.jsp?"+old_params;
			document.location.reload();//Added by Sridevi Joshi for CRF-702(IN012606)

			var dentalChartFormObj = parent.parent.frames[1].document.dentalChartMainForm;
		}else{
			var old_params = parent.frames[2].document.forms[0].params.value;
			document.location.href = "../../eOH/jsp/DentalTreatment.jsp?"+old_params;

			var dentalChartFormObj = parent.frames[1].document.dentalChartMainForm;
		}
	}
	else{
		//if(ext_perm_loc_param == "Y" || (treatment_status_param_int >25 && trmt_yn != "Y" && trmt_done_yn != "Y") || treatment_status_param==undefined){//Added by Sridevi Joshi for CRF-702(IN012606) ---(= symbol for >25 is added by Sridevi Joshi on 2/25/2010 for one of the script error)
		if(ext_perm_loc_param == "Y" || (treatment_status_param_int >25 && trmt_yn != "Y" && trmt_done_yn != "Y") || treatment_status_param==undefined || (treatment_status=="A" && treatment_status_param_int >=25)){//added by parul on 02/06/2010 for IN021703 (for one of script error)
			var old_params = parent.parent.frames[2].document.forms[0].params.value;
			parent.document.location.href = "../../eOH/jsp/DentalTreatment.jsp?"+old_params;

			var dentalChartFormObj = parent.parent.frames[1].document.dentalChartMainForm;
		}else{
			var old_params = parent.frames[2].document.forms[0].params.value;
			document.location.href = "../../eOH/jsp/DentalTreatment.jsp?"+old_params;

			var dentalChartFormObj = parent.frames[1].document.dentalChartMainForm;
		}
	}

	var thrng_nos_ref = formObj.thrng_nos_ref.value;
	var count_checked = 0;
	if(site_type == "null" || site_type == null || site_type == "" || tooth_no == "" || tooth_no == "null" || tooth_no == null || tooth_no == "undefined" || tooth_no == undefined){
		for (j=1;j<=52;j++){
			if(eval("dentalChartFormObj.selcol"+j) != null && eval("dentalChartFormObj.selcol"+j) != "null"){
				if(eval("dentalChartFormObj.selcol"+j).checked == true){
					if(count_checked==0){
						site_type = "TOOTH";
						thrng_nos_ref = j+"";
						tooth_no = j+"";
					}
					else{
						site_type = "THRNG";
						thrng_nos_ref = thrng_nos_ref+","+j;
					}
					count_checked++;
				}
			}
		}
	}
	else{
		for (j=1;j<=52;j++){
			if(eval("dentalChartFormObj.selcol"+j) != null && eval("dentalChartFormObj.selcol"+j) != "null"){
				if(eval("dentalChartFormObj.selcol"+j).checked == true){
					if(count_checked==0){
						site_type = "TOOTH";
						thrng_nos_ref = j+"";
						tooth_no = j+"";
					}
					else{
						site_type = "THRNG";
						thrng_nos_ref = thrng_nos_ref+","+j;
					}
					count_checked++;
				}
			}
		}
	}

	
	// This code is to reset the Arch checkboxes
	dentalChartFormObj.selL.checked=false; // Lower Arch
	dentalChartFormObj.selU.checked=false;	// Upper Arch

	//This code is to reset the Quadrant checkboxes
	dentalChartFormObj.sel1.checked=false; // Upper Right
	dentalChartFormObj.sel2.checked=false; // Upper Left
	dentalChartFormObj.sel3.checked=false; // Lower Left
	dentalChartFormObj.sel4.checked=false; // Lower Right
	

	formObj.oh_category.value = "";
	formObj.oh_site.value = "";
	formObj.oh_area.value = "";
	formObj.treatment_status.value = "";
	formObj.oh_treatment.value = "";
	formObj.oh_surface.value = "";
	if(formObj.oh_status.value == "60" || formObj.oh_status.value == "85" ){
		 formObj.oh_outcome.value = "";
	}
	//formObj.oh_outcome.value = "";

	formObj.category.value = "";
	formObj.site.value = "";
	formObj.area.value = "";
	formObj.treatment.value = "";
	formObj.thrng_nos_ref.value = "";
	formObj.thrng_nos.value = "";

	formObj.remarks.value = "";
	formObj.called_from_viewchart_yn.value = ""; // This is to allow the usr to record now condition/treatments.If this value is 'Y' dental Chart operations are disabled.
	clear_list(formObj.oh_site);
	if(site_type != "THRNG" && site_type != "undefined" && site_type != "null" && site_type != null){
		clear_list(formObj.oh_area);
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].oh_area.add(optSel);
	}
	if(site_type == "THRNG"){
		formObj.document.getElementById("area_field").innerHTML = "<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);' ></select>"
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].oh_area.add(optSel);
	}
	clear_list(formObj.oh_treatment);
	//clear_list(formObj.oh_surface);
	clear_list(formObj.treatment_status);
	//clear_list(formObj.oh_sub_parts);
	//clear_list(formObj.oh_outcome);
	if(formObj.oh_status.value == "60" || formObj.oh_status.value == "85" ){
		clear_list(formObj.oh_outcome);
	}

	formObj.document.getElementById("cusp_field").innerHTML = "<select name='oh_cusp_tip' id='oh_cusp_tip' multiple></select>"
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_cusp_tip.add(optSel);

	

	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_site.add(optSel);

	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_treatment.add(optSel);

	if(site_type != "CROWN" && site_type != "ROOT" && site_type != "undefined" && site_type != "null" && site_type != null){
		clear_list(formObj.oh_surface);
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].oh_surface.add(optSel);
	}

	/*optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_surface.add(optSel);*/

	formObj.document.getElementById("surface_field").innerHTML = "<select name='oh_surface' id='oh_surface' multiple></select>"
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_surface.add(optSel);

	
	
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].treatment_status.add(optSel);
	/*
	optSelComp	= document.createElement("OPTION");
	optSelComp.text = getLabel("eOH.Planned.Label","OH");
	optSelComp.value= 'C'; 
	document.forms[0].oh_status.add(optSelComp);
	optSelIncomp	= document.createElement("OPTION");
	optSelIncomp.text = getLabel("Common.Performed.label","Common");
	optSelIncomp.value= 'I'; 
	document.forms[0].oh_status.add(optSelIncomp);*/


	if(formObj.oh_status.value == "60" || formObj.oh_status.value == "85" ){
	 
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].oh_outcome.add(optSel);
		optSelComp	= document.createElement("OPTION");
		optSelComp.text = getLabel("Common.Success.label","common");
		optSelComp.value= 'S'; 
		document.forms[0].oh_outcome.add(optSelComp);
		optSelIncomp	= document.createElement("OPTION");
		optSelIncomp.text = getLabel("Common.Failure.label","Common");
		optSelIncomp.value= 'F'; 
		document.forms[0].oh_outcome.add(optSelIncomp);
	
	}
	document.getElementById("change_area").innerHTML = getLabel("Common.area.label","Common");

	formObj.oh_category.disabled = false;
	formObj.oh_area.disabled = false;
	formObj.oh_site.disabled = false;
	formObj.treatment_status.disabled = false;
	formObj.oh_treatment.disabled = false;
	formObj.oh_surface.disabled = true;
	//formObj.oh_outcome.disabled = false;

	// Make the Dental Chart Tooth numbers checkbox to false(Uncheck)
	
	if(site_type=="THRNG"){
		
		if(thrng_nos_ref != "" && thrng_nos_ref != "null" && thrng_nos_ref != null && thrng_nos_ref != "undefined"){
			var range_tooth_no = thrng_nos_ref.split(",");
			for(i=0;i<range_tooth_no.length;i++){
				eval("dentalChartFormObj.selcol"+range_tooth_no[i]).checked=false;
				eval("dentalChartFormObj.selcol"+range_tooth_no[i]).value="N";
			}
		}
	}else if(site_type=="TOOTH"){
		
		eval("dentalChartFormObj.selcol"+tooth_no).checked=false;
		eval("dentalChartFormObj.selcol"+tooth_no).value="N";
	}
	else if(site_type=="ARCH" || site_type=="QUAD"){
		eval("dentalChartFormObj.sel"+tooth_no).checked=false;
		eval("dentalChartFormObj.sel"+tooth_no).value="N";
	}

	//This is to remove the oh_task field from the Data entry Area
	if(document.getElementById("task_legend") != null){
		document.getElementById("task_legend").innerHTML = "&nbsp;";
		document.getElementById("task_code_display").innerHTML = "&nbsp;";
	}

	dentalChartFormObj.UR_quadrant_applicable_yn.value= "Y";
	dentalChartFormObj.UL_quadrant_applicable_yn.value= "Y";
	dentalChartFormObj.LL_quadrant_applicable_yn.value= "Y";
	dentalChartFormObj.LR_quadrant_applicable_yn.value= "Y";
	dentalChartFormObj.lower_arch_applicable_yn.value= "Y";
	dentalChartFormObj.upper_arch_applicable_yn.value= "Y";


}

function localTrimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function countSelectedTooth(obj){
	var count = 0;
	if(document.forms[0].oh_site.value == "MAXFS"){
		var toothRgnVal="";
		for (var k=0;k<obj.options.length; k++) {
			if (obj.options[k].selected == true){
				if(obj.options[k].value != "" && obj.options[k].value != "null" && obj.options[k].value != null){
					toothRgnVal+=obj.options[k].value+",";
					count++;
				}
			}
		}
	}else{
		   for (var k=0;k<obj.options.length; k++) {
			if (obj.options[k].selected == true){
				if(obj.options[k].value != "" && obj.options[k].value != "null" && obj.options[k].value != null){
					count++;
				}
			}
		}
	}
	
	//if(obj.value != ""){
		hasChanged = true;
		if(count > 0 && count < 2){
			if(hasChanged){
				alert(getMessage("APP-OH00012",'OH'));
				obj.focus();
				hasChanged = false;
				return;
			}
		}
		//Commented by Sharon Crasta on 3/18/2010 - While recording Bridge/Ortho/Denture from Data Entry, getting  Invalid Number.
		/*else
		{
			document.getElementById("thrng_nos_ref").value=toothRgnVal;
		} */
}

function clear_list(obj){
	while(obj.options.length > 0){
		obj.remove(obj.options[0]);
	}
}															    

function getAreaLegendFromPage(obj){
	if(obj.value == "THRNG"){
		area_legend = getLabel("eOH.ToothNos.Label","OH");
		//document.getElementById("area_field").innerHTML ="<input type='text' name='oh_area' id='oh_area'><img src='../../eCommon/images/mandatory.gif'>"
		document.getElementById("area_field").innerHTML = "<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);clearDentalcondition(this);'  onBlur='countSelectedTooth(this);chkForSuper_RD(this);'  size=3 multiple><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='AreaMandatory' src='../../eCommon/images/mandatory.gif'>"
	}
	else if(obj.value == "ARCH"){
		area_legend = getLabel("eOH.Arch.Label","OH");
		document.getElementById("area_field").innerHTML ="<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);clearDentalcondition(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='AreaMandatory' src='../../eCommon/images/mandatory.gif'>"
	}
	else if(obj.value == "QUAD"){
		area_legend = getLabel("eOH.Quadrant.Label","OH");
		document.getElementById("area_field").innerHTML ="<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);clearDentalcondition(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='AreaMandatory' src='../../eCommon/images/mandatory.gif'>"
	}
	else if(obj.value == "CROWN" || obj.value == "ROOT" || obj.value == "TOOTH"){
		area_legend = getLabel("eOH.ToothNo.Label","OH");
		document.getElementById("area_field").innerHTML ="<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);clearDentalcondition(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='AreaMandatory' src='../../eCommon/images/mandatory.gif'>"
	}
	else if(obj.value == "MAXFS" || obj.value=="MOUTH"){
		area_legend = getLabel("Common.area.label","Common");//commented by parul on 16/09/2009 for CRF#701
		document.getElementById("area_field").innerHTML ="<select name='oh_area' id='oh_area' onChange='populateSurfacesFromPage(this,oh_surface);clearDentalcondition(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='AreaMandatory' src='../../eCommon/images/mandatory.gif'>"
		//document.getElementById("area_field").innerHTML ="<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);clearDentalcondition(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option>"

	}
	else{
		area_legend = getLabel("Common.area.label","Common");
		document.getElementById("area_field").innerHTML ="<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);clearDentalcondition(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='AreaMandatory'  src='../../eCommon/images/mandatory.gif'>"
	}
	document.getElementById("change_area").innerHTML = area_legend;
	//document.getElementById("change_surface").style.visibility = 'visible';
	//document.getElementById("change_surface").style.display = 'block';
}

function getAreaLegend(obj,thrng_nos){
	if(obj.value == "THRNG"){
		area_legend = getLabel("eOH.ToothNos.Label","OH");
		document.getElementById("area_field").innerHTML ="<input type='text' name='oh_area' id='oh_area'><img id='AreaMandatory' src='../../eCommon/images/mandatory.gif'>"
	}
	else if(obj.value == "ARCH"){
		area_legend = getLabel("eOH.Arch.Label","OH");
		document.getElementById("area_field").innerHTML ="<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='AreaMandatory' src='../../eCommon/images/mandatory.gif'>"
	}
	else if(obj.value == "QUAD"){
		area_legend = getLabel("eOH.Quadrant.Label","OH");
		document.getElementById("area_field").innerHTML ="<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='AreaMandatory' src='../../eCommon/images/mandatory.gif'>"
	}
	else if(obj.value == "CROWN" || obj.value == "ROOT" || (obj.value == "TOOTH" && thrng_nos.indexOf(",") == -1)){ // changed to convert  THRNG to TOOTH in 'DC' tab.
		area_legend = getLabel("eOH.ToothNo.Label","OH");
		document.getElementById("area_field").innerHTML ="<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='AreaMandatory' src='../../eCommon/images/mandatory.gif'>"
	}
	else if(obj.value == "TOOTH" && thrng_nos.indexOf(",") != -1){
		area_legend = getLabel("eOH.ToothNo.Label","OH");
		document.getElementById("area_field").innerHTML ="<input type='text' name='oh_area' id='oh_area'><img id='AreaMandatory' src='../../eCommon/images/mandatory.gif'>"
	}
	else{
		area_legend = getLabel("Common.area.label","Common");
		document.getElementById("area_field").innerHTML ="<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='AreaMandatory' src='../../eCommon/images/mandatory.gif'>"
	}
	document.getElementById("change_area").innerHTML = area_legend;
}

/*
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
		if(document.forms[0].oh_condition_type != "undefined"){
			if(document.forms[0].oh_condition_type.value == "PULPINV"){
				document.getElementById("MandatorySurface").style.visibility = 'hidden';
			}
		}
		else{
			document.getElementById("MandatorySurface").style.visibility = 'visible';
		}
		var retVal_arr = retVal.split("~");
		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			var element 	= document.createElement('OPTION') ;
			element.value 	= code_desc_arr[0];
			element.text 	= code_desc_arr[1] ;
			document.forms[0].oh_surface.add(element);
		}
	}
}
*/
function populateArea(obj,tooth_numbering_system,permanent_deciduous_flag,ref_tooth_no,thrng_nos,flag,thrng_nos_ref,maxila_sub_parts,super_tooth_ref){
	var formObj = document.forms[0];
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var RD_Normal_yn = formObj.RD_Normal_yn.value;
	var area = ""; 
	if(obj != null && obj != "" && obj.value != "THRNG" && obj.value != "null" && obj.value != null ){
		if(thrng_nos == undefined){
			clear_list(document.forms[0].oh_area); 
			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
			optSel.value= ''; 
			document.forms[0].oh_area.add(optSel);
		}else{
			if((thrng_nos.indexOf(",") == -1) ||((thrng_nos.indexOf(",") != -1) && obj.value=="MAXFS")){
				clear_list(document.forms[0].oh_area); 
				optSel	= document.createElement("OPTION");
				optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
				optSel.value= ''; 
				document.forms[0].oh_area.add(optSel);
				var site_type_val = obj.value;
				var retVal="";
				if (site_type_val=="MAXFS"){
					retVal="I##Intra Oral~E##Extra Oral~"
				}
				else{
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "site_type_val="+site_type_val+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateArea&"+params,false);
					xmlHttp.send(xmlDoc);
					retVal = trimString(xmlHttp.responseText);//all tooth_no
				}

				if(retVal.length>1){
					var retVal_arr = retVal.split("~");
					for(var i=0;i<retVal_arr.length-1;i++){
						var code_desc_arr = retVal_arr[i].split("##");
						var element 	= document.createElement('OPTION') ;
						if(ref_tooth_no != code_desc_arr[0] && obj.value != "ARCH" && obj.value != "QUAD" && obj.value != "MAXFS"){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_tooth = trimString(xmlHttp.responseText);
							retVal_tooth=localTrimString(retVal_tooth);
							element.value 	= ref_tooth_no;
							element.text 	= retVal_tooth ;	
						}else{
							element.value 	= code_desc_arr[0];
							element.text 	= code_desc_arr[1] ;
	
						}

						document.forms[0].oh_area.add(element);
					}
				}

				
				var site_type = obj.value;

				
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+ref_tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&site_type="+site_type;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithYN&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal=localTrimString(retVal);
				if(retVal.length > 1){
					if(document.getElementById("AreaMandatory")!=null){
						document.getElementById("AreaMandatory").style.visibility = 'visible';
					}
					var retVal_arr = retVal.split("~");
					for(var i=0;i<retVal_arr.length-1;i++){
						var code_desc_arr = retVal_arr[i].split("##");
						if(code_desc_arr[0] == "DECITH" && obj.value!="MAXFS"){ //MAXFS is added by Sridevi Joshi on 4/8/2010
                            var count=0;
							if (retVal_arr.length>3 && permanent_deciduous_flag=="P" && mixed_dentition_YN=="Y"){
								var Superyn="";
								var condition_SuperRD="";
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&tooth_no="+ref_tooth_no+"&chart_num="+chart_num;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=SuperRDyn&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_super = trimString(xmlHttp.responseText);
								retVal_super=localTrimString(retVal_super);
								
								if(retVal_super.length >= 1){
									var retVal_arr_super = retVal_super.split("##");
									Superyn = retVal_arr_super[0];
									condition_SuperRD = retVal_arr_super[1];
								}

								var retVal_Erupt="";
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&tooth_no="+ref_tooth_no+"&chart_num="+chart_num;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateErupted&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_super = trimString(xmlHttp.responseText);
								retVal_Erupt=localTrimString(retVal_super);
								
                                 var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+ref_tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_exf = trimString(xmlHttp.responseText);
								retVal_exf = localTrimString(retVal_exf);
								if(retVal_exf.length > 0 && parseInt(retVal_exf) > 0){ 
									var retVal_arr_exf = retVal_exf.split("##");
									count = retVal_arr_exf[0];			
								} 
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
																
								if(RD_Normal_yn == "D"){
									xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
								}
								else if((condition_SuperRD=="SUPRTH" || condition_SuperRD=="RTDESTH") && count<=1){ //added by parul on 18/11/2009 for IN016381
									if (retVal_Erupt==1){
									   xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
									}else{
										xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
									}
								}else if((condition_SuperRD=="" || condition_SuperRD=="null" || condition_SuperRD==null) && count==0){
								 	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
                                }
								else{
									xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
								}

								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);
								retVal=localTrimString(retVal);								
								clear_list(document.forms[0].oh_area);
								if(retVal.length > 1){
									var retVal_arr = retVal.split("##");
									var element 	= document.createElement('OPTION') ;
									element.value 	= ref_tooth_no;
									element.text 	= retVal_arr[0];
									document.forms[0].oh_area.add(element);
									var element 	= document.createElement('OPTION') ;
									element.value 	= "";
									element.text 	= getLabel("eOH.DefaultSelect.Label","OH");
									document.forms[0].oh_area.add(element);

								}
							}else{
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
							//	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);
								retVal=localTrimString(retVal);
								clear_list(document.forms[0].oh_area);
								if(retVal.length > 1){
									
									var retVal_arr = retVal.split("##");
									var element 	= document.createElement('OPTION') ;
									element.value 	= ref_tooth_no;
									element.text 	= retVal_arr[0];
									document.forms[0].oh_area.add(element);
									var element 	= document.createElement('OPTION') ;
									element.value 	= "";
									element.text 	= getLabel("eOH.DefaultSelect.Label","OH");
									document.forms[0].oh_area.add(element);

								}
							}
						}
						else if(code_desc_arr[0] == "RTDESTH" && super_tooth_ref == "RD" && permanent_deciduous_flag != "D" &&  obj.value!="MAXFS"){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal=localTrimString(retVal);
							clear_list(document.forms[0].oh_area);
							if(retVal.length > 1){
								var retVal_arr = retVal.split("##");
								var element 	= document.createElement('OPTION') ;
								element.value 	= ref_tooth_no;
								element.text 	= retVal_arr[0];
								document.forms[0].oh_area.add(element);
								var element 	= document.createElement('OPTION') ;
								element.value 	= "";
								element.text 	= getLabel("eOH.DefaultSelect.Label","OH");
								document.forms[0].oh_area.add(element);

							}
						}
						//else if(code_desc_arr[0] == "RTDESTH" && (super_tooth_ref != "RD" && super_tooth_ref != "s1" && super_tooth_ref != "s2") && permanent_deciduous_flag == "D"){
						else if(code_desc_arr[0] == "RTDESTH" && (super_tooth_ref != "RD" && (super_tooth_ref == "" || super_tooth_ref == "undefined" || super_tooth_ref == undefined )) && permanent_deciduous_flag == "D"){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal=localTrimString(retVal);

							clear_list(document.forms[0].oh_area);
							if(retVal.length > 1){
								var retVal_arr = retVal.split("##");
								var element 	= document.createElement('OPTION') ;
								element.value 	= ref_tooth_no;
								element.text 	= retVal_arr[0];
								document.forms[0].oh_area.add(element);
								var element 	= document.createElement('OPTION') ;
								element.value 	= "";
								element.text 	= getLabel("eOH.DefaultSelect.Label","OH");
								document.forms[0].oh_area.add(element);

							}
						}
					}
				}

				if(obj.value != "ARCH" && obj.value != "QUAD" && obj.value!="MAXFS"){
					//Added by Sridevi Joshi on 1/18/2010 for IN010894
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+ref_tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
					xmlHttp.send(xmlDoc);
					var countExfTooth_retVal = trimString(xmlHttp.responseText);
					countExfTooth_retVal=localTrimString(countExfTooth_retVal);
					if(countExfTooth_retVal.length > 0){
						if(parseInt(countExfTooth_retVal) == 1 && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
							//To retrieve chart_line_num if SUPRTH is recorded
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+ref_tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
							xmlHttp.send(xmlDoc);
							var suprth_chart_line_num = trimString(xmlHttp.responseText);
							suprth_chart_line_num = localTrimString(suprth_chart_line_num);
							if(suprth_chart_line_num.length == 0){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);
								retVal=localTrimString(retVal);
								
								clear_list(document.forms[0].oh_area);
								if(retVal.length > 1){
									var retVal_arr = retVal.split("##");
									var element 	= document.createElement('OPTION') ;
									element.value 	= ref_tooth_no;
									element.text 	= retVal_arr[0];
									document.forms[0].oh_area.add(element);
									var element 	= document.createElement('OPTION') ;
									element.value 	= "";
									element.text 	= getLabel("eOH.DefaultSelect.Label","OH");
									document.forms[0].oh_area.add(element);
								}
							}
							else{
								//To retrieve chart_line_num if EXFOLTH is recorded
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+ref_tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
								xmlHttp.send(xmlDoc);
								var exfolth_chart_line_num = trimString(xmlHttp.responseText);
								exfolth_chart_line_num = localTrimString(exfolth_chart_line_num);
								if(parseInt(exfolth_chart_line_num) < parseInt(suprth_chart_line_num) ){
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
									xmlHttp.send(xmlDoc);
									var retVal = trimString(xmlHttp.responseText);
									retVal=localTrimString(retVal);

									clear_list(document.forms[0].oh_area);
									if(retVal.length > 1){
										var retVal_arr = retVal.split("##");
										var element 	= document.createElement('OPTION') ;
										element.value 	= ref_tooth_no;
										element.text 	= retVal_arr[0];
										document.forms[0].oh_area.add(element);
										var element 	= document.createElement('OPTION') ;
										element.value 	= "";
										element.text 	= getLabel("eOH.DefaultSelect.Label","OH");
										document.forms[0].oh_area.add(element);
									}
								}
							}
						}
						//else if(parseInt(countExfTooth_retVal) == 2 && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
						else if(parseInt(countExfTooth_retVal) == 3 && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal=localTrimString(retVal);

							clear_list(document.forms[0].oh_area);
							if(retVal.length > 1){
								var retVal_arr = retVal.split("##");
								var element 	= document.createElement('OPTION') ;
								element.value 	= ref_tooth_no;
								element.text 	= retVal_arr[0];
								document.forms[0].oh_area.add(element);
								var element 	= document.createElement('OPTION') ;
								element.value 	= "";
								element.text 	= getLabel("eOH.DefaultSelect.Label","OH");
								document.forms[0].oh_area.add(element);
							}
						}
					}
				
					if(RD_Normal_yn == "MR" || RD_Normal_yn == "MRP"){ //Added By SRidevi Joshi on 2/3/2010 for IN010894
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						clear_list(document.forms[0].oh_area);
						if(retVal.length > 0){
							var retVal_arr = retVal.split("##");
							var element 	= document.createElement('OPTION') ;
							element.value 	= ref_tooth_no;
							element.text 	= retVal_arr[0];
							document.forms[0].oh_area.add(element);
							var element 	= document.createElement('OPTION') ;
							element.value 	= "";
							element.text 	= getLabel("eOH.DefaultSelect.Label","OH");
							document.forms[0].oh_area.add(element);
						}
					}
				}

				/*if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && (super_tooth_ref == "s1" || super_tooth_ref == "s2" || super_tooth_ref == "undefined" || super_tooth_ref == undefined || super_tooth_ref == "") && (obj.value == "TOOTH" || obj.value == "CROWN" ||obj.value == "ROOT")){//ROOT and CROWN condition is added by Sridevi Joshi on 30/10/09 for IN015475
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=localTrimString(retVal);
					clear_list(document.forms[0].oh_area);

					//To get the chart_line_num if exfolth/erupth is recorded on deciduous tooth.
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+ref_tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&called_from=populateArea";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForERUPTH&"+params,false);
					xmlHttp.send(xmlDoc);
					var erupth_chart_line_num = trimString(xmlHttp.responseText);
					erupth_chart_line_num=localTrimString(erupth_chart_line_num);

					if(retVal.length > 1 && retVal != "##" && erupth_chart_line_num != "0"){
						var retVal_arr = retVal.split("##");
						var element 	= document.createElement('OPTION') ;
						element.value 	= ref_tooth_no;
						element.text 	= retVal_arr[0];
						document.forms[0].oh_area.add(element);
						var element 	= document.createElement('OPTION') ;
						element.value 	= "";
						element.text 	= getLabel("eOH.DefaultSelect.Label","OH");
						document.forms[0].oh_area.add(element);
					}
					else{
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						clear_list(formObj.oh_area);

		
						var element 	= document.createElement('OPTION') ;
						element.value 	= "";
						element.text 	= getLabel("eOH.DefaultSelect.Label","OH");
						document.forms[0].oh_area.add(element);
						var element 	= document.createElement('OPTION') ;
						element.value 	= ref_tooth_no;
						element.text 	= retVal;
						document.forms[0].oh_area.add(element);
					}
				}*/
			}
			else{
				if(thrng_nos_ref.indexOf(",") == -1){ //only for site TOOTH(even not for multiple selection)
					var patient_id = formObj.patient_id.value;
					var chart_num = formObj.chart_num.value;
					var site_type = obj.value;

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+ref_tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&site_type="+site_type;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithYN&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=localTrimString(retVal);
					if(retVal.length > 1){
						if(document.getElementById("AreaMandatory")!=null){
							document.getElementById("AreaMandatory").style.visibility = 'visible';
						}
						
						var retVal_arr = retVal.split("~");
						for(var i=0;i<retVal_arr.length-1;i++){
							var code_desc_arr = retVal_arr[i].split("##");
							if(code_desc_arr[0] == "DECITH"){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);
								retVal=localTrimString(retVal);
								var retVal_arr = retVal.split("##");
								area = retVal_arr[0];
							}
							else if(code_desc_arr[0] == "RTDESTH" && super_tooth_ref == "RD" && permanent_deciduous_flag != "D"){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);
								retVal=localTrimString(retVal);
								var retVal_arr = retVal.split("##");
								area = retVal_arr[0];
							}
							//else if(code_desc_arr[0] == "RTDESTH" &&(super_tooth_ref != "RD" && super_tooth_ref != "s1" && super_tooth_ref != "s2") && permanent_deciduous_flag == "D"){
							else if(code_desc_arr[0] == "RTDESTH" &&(super_tooth_ref != "RD" && (super_tooth_ref == "" || super_tooth_ref == "undefined" || super_tooth_ref == undefined )) && permanent_deciduous_flag == "D"){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);
								retVal=localTrimString(retVal);

								var retVal_arr = retVal.split("##");
								area = retVal_arr[0];
							}
						}
					}
				}

				var thrng_nos_arr = thrng_nos_ref.split(",");
				for(var k=0;k<thrng_nos_arr.length;k++){
					if(obj.value != "ARCH" && obj.value != "QUAD"){
						//Added by Sridevi Joshi on 1/18/2010 for IN010894
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+thrng_nos_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
						xmlHttp.send(xmlDoc);
						var countExfTooth_retVal = trimString(xmlHttp.responseText);
						countExfTooth_retVal=localTrimString(countExfTooth_retVal);
						if(countExfTooth_retVal.length > 0){
							if(parseInt(countExfTooth_retVal) == 1 && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
								//To retrieve chart_line_num if SUPRTH is recorded
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+thrng_nos_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
								xmlHttp.send(xmlDoc);
								var suprth_chart_line_num = trimString(xmlHttp.responseText);
								suprth_chart_line_num = localTrimString(suprth_chart_line_num);
								if(suprth_chart_line_num.length == 0){
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									
									var params = "tooth_no="+thrng_nos_arr[k]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
									xmlHttp.send(xmlDoc);
									var retVal = trimString(xmlHttp.responseText);
									retVal=localTrimString(retVal);

									if(retVal.length > 1 && retVal != "##"){
										var retVal_arr = retVal.split("##");
										if(area == ""){
											area = retVal_arr[0];
										}
										else{
											area = area +","+ retVal_arr[0];
										}
									}
								}
								else{
									//To retrieve chart_line_num if EXFOLTH is recorded
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									var params = "tooth_no="+thrng_nos_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
									xmlHttp.send(xmlDoc);
									var exfolth_chart_line_num = trimString(xmlHttp.responseText);
									exfolth_chart_line_num = localTrimString(exfolth_chart_line_num);
									if(parseInt(exfolth_chart_line_num) < parseInt(suprth_chart_line_num) ){
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "tooth_no="+thrng_nos_arr[k]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
										xmlHttp.send(xmlDoc);
										var retVal = trimString(xmlHttp.responseText);
										retVal=localTrimString(retVal);

										if(retVal.length > 1 && retVal != "##"){
											var retVal_arr = retVal.split("##");
											if(area == ""){
												area = retVal_arr[0];
											}
											else{
												area = area +","+ retVal_arr[0];
											}
										}
									}
								}
							}
						}
					}
				}

				/*if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && (super_tooth_ref == "s1" || super_tooth_ref == "s2") && (obj.value == "TOOTH" || obj.value == "CROWN" ||obj.value == "ROOT")){//ROOT and CROWN condition is added by Sridevi Joshi on 30/10/09 for IN015475
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					
					var thrng_nos_arr = thrng_nos_ref.split(",");
					for(var k=0;k<thrng_nos_arr.length;k++){
						var params = "tooth_no="+thrng_nos_arr[k]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						
						if(retVal.length > 1 && retVal != "##"){
							var retVal_arr = retVal.split("##");
							if(area == ""){
								area = retVal_arr[0];
							}
							else{
								area = area +","+ retVal_arr[0];
							}
						}
					}
				}*/
			}
		}
		/*if(obj.value == "MAXFS" || obj.value == "MOUTH"){
			if(document.getElementById("AreaMandatory")!=null){
				document.getElementById("AreaMandatory").style.visibility = 'hidden';
			}
		}*/
	}
	else if((obj != null && obj != "" && obj.value == "THRNG") ){	
//	else if((obj != null && obj != "" &&  (obj.value == "THRNG") || (obj.value == "MAXFS")) ){	
		var patient_id = formObj.patient_id.value;
		var chart_num = formObj.chart_num.value;
		var site_type = obj.value;

		var thrng_nos_arr = thrng_nos_ref.split(",");
		for(var k=0;k<thrng_nos_arr.length;k++){

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+thrng_nos_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&site_type="+site_type;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithYN&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 1){
				if(document.getElementById("AreaMandatory")!=null){
					document.getElementById("AreaMandatory").style.visibility = 'visible';
				}
				
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					if(code_desc_arr[0] == "DECITH"){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+thrng_nos_arr[k]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 1 && retVal != "##"){
							var retVal_arr = retVal.split("##");
							if(area == ""){
								area = retVal_arr[0];
							}
							else{
								area = area +","+ retVal_arr[0];
							}
						}
					}
					else if(code_desc_arr[0] == "RTDESTH" && super_tooth_ref == "RD" && permanent_deciduous_flag != "D"){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+thrng_nos_arr[k]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 1 && retVal != "##"){
							var retVal_arr = retVal.split("##");
							if(area == ""){
								area = retVal_arr[0];
							}
							else{
								area = area +","+ retVal_arr[0];
							}
						}
					}
					else if(code_desc_arr[0] == "RTDESTH" &&(super_tooth_ref == "undefined" || super_tooth_ref == undefined || super_tooth_ref == "") && permanent_deciduous_flag == "D"){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+thrng_nos_arr[k]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);

						if(retVal.length > 1 && retVal != "##"){
							var retVal_arr = retVal.split("##");
							if(area == ""){
								area = retVal_arr[0];
							}
							else{
								area = area +","+ retVal_arr[0];
							}
						}
					}
				}
			}
		}

		var thrng_nos_arr = thrng_nos_ref.split(",");
		for(var k=0;k<thrng_nos_arr.length;k++){
			if(obj.value != "ARCH" && obj.value != "QUAD"){
			//Added by Sridevi Joshi on 1/18/2010 for IN010894
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+thrng_nos_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
			xmlHttp.send(xmlDoc);
			var countExfTooth_retVal = trimString(xmlHttp.responseText);
			countExfTooth_retVal=localTrimString(countExfTooth_retVal);
				if(countExfTooth_retVal.length > 0){
					if(parseInt(countExfTooth_retVal) == 1 && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
						//To retrieve chart_line_num if SUPRTH is recorded
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+thrng_nos_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
						xmlHttp.send(xmlDoc);
						var suprth_chart_line_num = trimString(xmlHttp.responseText);
						suprth_chart_line_num = localTrimString(suprth_chart_line_num);
						if(suprth_chart_line_num.length == 0){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							
							var params = "tooth_no="+thrng_nos_arr[k]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal=localTrimString(retVal);
							
							if(retVal.length > 1 && retVal != "##"){
								var retVal_arr = retVal.split("##");
								if(area == ""){
									area = retVal_arr[0];
								}
								else{
									area = area +","+ retVal_arr[0];
								}
								
							}
						}
						else{
							//To retrieve chart_line_num if EXFOLTH is recorded
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+thrng_nos_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
							xmlHttp.send(xmlDoc);
							var exfolth_chart_line_num = trimString(xmlHttp.responseText);
							exfolth_chart_line_num = localTrimString(exfolth_chart_line_num);
							if(parseInt(exfolth_chart_line_num) < parseInt(suprth_chart_line_num) ){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+thrng_nos_arr[k]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);
								retVal=localTrimString(retVal);

								if(retVal.length > 1 && retVal != "##"){
									var retVal_arr = retVal.split("##");
									if(area == ""){
										area = retVal_arr[0];
									}
									else{
										area = area +","+ retVal_arr[0];
									}
								}
							}
						}
					}
				}
			}
		}

		/*if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && (super_tooth_ref == "s1" || super_tooth_ref == "s2" || super_tooth_ref == "undefined")){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			
			var thrng_nos_arr = thrng_nos_ref.split(",");
			for(var k=0;k<thrng_nos_arr.length;k++){
				var params = "tooth_no="+thrng_nos_arr[k]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal=localTrimString(retVal);
				
				if(retVal.length > 1 && retVal != "##"){
					var retVal_arr = retVal.split("##");
					if(area == ""){
						area = retVal_arr[0];
					}
					else{
						area = area +","+ retVal_arr[0];
					}
					
				}
			}
		}*/
	}

	return area;
}

function populateAreaFromPage(obj,tooth_numbering_system,permanent_deciduous_flag,ref_tooth_no){
	var formObj = document.forms[0];
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	clear_list(document.forms[0].oh_area); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_area.add(optSel);
	var site_type_val = obj.value;
	var retVal ="";
	if (site_type_val=="MAXFS"){
		retVal="I##Intra Oral~E##Extra Oral~"
	}else{
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "site_type_val="+site_type_val+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateArea&"+params,false);
		xmlHttp.send(xmlDoc);
		retVal = trimString(xmlHttp.responseText);
	}
	
	if(retVal.length>1 ){
		if(document.getElementById("AreaMandatory")!=null){
			document.getElementById("AreaMandatory").style.visibility = 'visible';
		}
		var retVal_arr = retVal.split("~");
		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			var element 	= document.createElement('OPTION') ;
			if(mixed_dentition_YN == "Y" && site_type_val != "ARCH" && site_type_val != "QUAD" && site_type_val != "MOUTH" && site_type_val != "MAXFS"){ // This condition is to remove the extreme end teeth of each quadrant as these tooth wont be there in case of mixed dentition chart. 
				if(code_desc_arr[0] != "1" && code_desc_arr[0] != "16" && code_desc_arr[0] != "17" && code_desc_arr[0] != "32" ){
					element.value 	= code_desc_arr[0];
					element.text 	= code_desc_arr[1] ;
					
				}
				else{	
					
					continue;
				}
			}
			else{
				
				element.value 	= code_desc_arr[0];
				element.text 	= code_desc_arr[1] ;
			}
			document.forms[0].oh_area.add(element);
		}
	}else{
			if(document.getElementById("AreaMandatory")!=null){
				document.getElementById("AreaMandatory").style.visibility = 'hidden';
			}
				
	}
		
	//Added  site_type_val in the below condition to restrict the number display only for site type 'TOOTH'
	if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && site_type_val != "ARCH" && site_type_val != "QUAD" && site_type_val != "MOUTH" && site_type_val != "MAXFS"){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateMixedDentToothNo&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_mixed = trimString(xmlHttp.responseText);
		retVal_mixed=localTrimString(retVal_mixed);
		var retVal_mixed_arr = retVal_mixed.split("~");
		for(k=0;k<retVal_mixed_arr.length-1;k++){
			var code_mixed = retVal_mixed_arr[k].split("##");
			if(code_mixed[1] != "0" && code_mixed[1] != "" && code_mixed[1] != null && code_mixed[1] != "null"){
				var element 	= document.createElement('OPTION') ;
				element.value 	= code_mixed[0];
				element.text 	= code_mixed[1] ;
				document.forms[0].oh_area.add(element);
			}
		}
	}
}

function checkDateNotLessSysDate(obj,locale) 
{
	var entered_date = obj.value;
	entered_date =   convertDate(entered_date,'DMY',locale,'en') ;
	var sys_date = new Date();
	var month = sys_date.getMonth();
	var year = sys_date.getFullYear();
	var date = sys_date.getDate();
	if(entered_date != ""){
		if(entered_date.indexOf("/") != -1){
			var enteredDateArray = entered_date.split("/");
			
			if(enteredDateArray[0].length == 2 && enteredDateArray[1].length == 2 && enteredDateArray[2].length == 4){
				var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
				var sysDateObject = new Date(year,month,date);
				if(Date.parse(sysDateObject) >= Date.parse(enteredDateObject)){
					return true;
				}
				else if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) {
					alert(getMessage("APP-OH00013",'OH'));
					obj.focus();
					obj.select();
					return false;
				}											  
			}
			else{
				alert(getMessage("INVALID_DATE_FMT",'SM'));
				obj.focus();
				obj.select();
				return false;
			}
		}
		else{
			alert(getMessage("INVALID_DATE_FMT",'SM'));
			obj.focus();
			obj.select();
			return false;
		}
	}
	return true;
}

function NumberCheck(obj){ 
	if ((event.keyCode < 47) || (event.keyCode > 57))
	{
		event.keyCode=0;
	}
}

/*
function isValidDate(Obj){
	if(Obj.value != ''){
		var locale = document.forms[0].locale.value;
		if(!validDateObj(Obj,'DMY',locale)){
			Obj.select();
		}
		
	}
	return true;
}
*/

function checkDateNotGraterThanSysDate(obj) 
{
   var locale=document.forms[0].locale.value;
	var entered_date = convertDate(obj.value,'DMY',locale,"en");
	var sys_date = new Date();
	var month = sys_date.getMonth();
	var year = sys_date.getFullYear();
	var date = sys_date.getDate();
	if(entered_date != ""){
		if(entered_date.indexOf("/") != -1){
			var enteredDateArray = entered_date.split("/");
			if(enteredDateArray[0].length == 2 && enteredDateArray[1].length == 2 && enteredDateArray[2].length == 4){
				var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
				var sysDateObject = new Date(year,month,date);
				if(Date.parse(sysDateObject) > Date.parse(enteredDateObject)){
					return true;
				}
				else if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) {
					alert(getMessage("DATE_NOT_GREATER_SYSDATE",'Common'));
					obj.focus();
					obj.select();
					return false;
				}
			}
			else{
				alert(getMessage("INVALID_DATE_FMT",'SM'));
				obj.focus();
				obj.select();
				return false;
			}
		}
		else{
			alert(getMessage("INVALID_DATE_FMT",'SM'));
			obj.focus();
			obj.select();
			return false;
		}
	}
	return true;
}

//function checkApplicableConditionTypes(tooth_no,patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,RD_SUPR_yn,site,thrng_nos_ref,tab_name){
function checkApplicableConditionTypes(tooth_no,patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,RD_SUPR_yn,site,thrng_nos_ref,oh_chart_level,tab_name,arch_quad){
	var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
	var super_tooth_ref = document.forms[0].super_tooth_ref.value;//added by parul for super changes
	var arr_prev = "";
	var miss_uner_applicable = "";
	var parer_uner_applicable = "";
	var missth_applicable = "";
	var rtd_decith_applicable = "";
	var parer_er_applicable = "";
	var uner_applicable = "";
	var erup_applicable = "";
	var mixed_parer_applicable = "";
	var decith_applicable = "";
	var impact_applicable = "";
	var trauma_applicable = "";
	var super_applicable = "";
	var atrarer_applicable = "";
	var display_menu_yn = "N";
	var deci_supr_tooth_selected = "";
	var parer_er_not_applicable = "";
	var pulpinv_not_applicable = "";
	var periinv_not_applicable = "";
	var super_not_applcable = "";
	var show_exfolth = "";
	var rootinvtooth_not_applicable = "";
	var cariestooth_not_applicable = "";
	var no_records = "";
	var retVal = "";
	var count = "";
	var mobility_applicable="";
	var retained_tooth_no="";
	var isSuperYN = "N";
	var isRetainedYN = "N";
	//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
	var malposn_applicable ="";
	var malocclusion_applicable ="";
	//End
	//Added by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
	var abutment_applicable = "";
	//End

	var ref_tooth_no=document.forms[0].ref_tooth_no.value;//added by parul for super changes to Differentiate data enrty and dental chart tooth no this will be null from data entey
	var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;


	var mixed_dent_num = "";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	params = "func_mode=populateDisplayToothNoAndName&tooth_no="+tooth_no+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_mixed = trimString(xmlHttp.responseText); 
	retVal_mixed = localTrimString(retVal_mixed); 
	if(retVal_mixed.length > 1){
		var retVal_mixed_arr = retVal_mixed.split("##");
		mixed_dent_num = retVal_mixed_arr[3];
	}
	
	/*//Added by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
	var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params_bridge_extract = "func_mode=getTrmtCatCode&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
	xmlHttp.send(xmlDoc);
	var retVal_bridge_extract = trimString(xmlHttp.responseText); 
	retVal_bridge_extract = localTrimString(retVal_bridge_extract);
	if(retVal_bridge_extract.length > 0){
		abutment_applicable = "abutment_applicable" ;
		
	}
	//End*/
	//Added by Sharon Crasta on 2/4/2010 for SRR20056-CRF-0498(IN010982)
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	if(site == "ARCH"){
		params = "func_mode=allConditionsRecordedForArchQuad&arch_quad="+arch_quad+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText); 
		retVal = localTrimString(retVal); 
	}else{//End
		//Passed site in params for IN020809 by Sridevi Joshi on 4/21/2010
		params = "func_mode=allTypeConditionsRecorded&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&site="+site+"&other_chart_facility_id="+other_chart_facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText); 
		retVal = localTrimString(retVal); 
	}

	if(retVal.length >1){
		var retVal_arr = retVal.split("~");
		for(m=0;m<retVal_arr.length-1;m++){
			var code_desc_arr = retVal_arr[m].split("##");
			if(code_desc_arr[0] != "" && code_desc_arr[0] != "null" && code_desc_arr[0] != null){
			 if (mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){//added by parul for retained changes on 18/01/2010

				   var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=SuperRDyn&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_cond = trimString(xmlHttp.responseText); 
					retVal_cond = localTrimString(retVal_cond); 
					var retVal_cond_arr = retVal_cond.split("##");
					var condition_type_ref = retVal_cond_arr[1];
					if(condition_type_ref == "SUPRTH"){
						isSuperYN = "Y";
					}else if(condition_type_ref == "RTDESTH"){
						isRetainedYN = "Y";
					}
					//if (isRetainedYN=="Y" && (super_tooth_ref != "RD" && super_tooth_ref != "s1" && super_tooth_ref != "s2")){
					if (isRetainedYN=="Y" && (super_tooth_ref != "RD" && (super_tooth_ref == "" || super_tooth_ref == "undefined" || super_tooth_ref == undefined ))){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=getMappedToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var mapped_tooth_no = trimString(xmlHttp.responseText);
						mapped_tooth_no=localTrimString(mapped_tooth_no);

						var ns_tooth_no = "";
						//To get Display_tooth_no
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+mapped_tooth_no+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							retained_tooth_no = retVal;
						}

						retained_tooth_no = mapped_tooth_no;//commented above and Added by Sridevi Joshi on 4/12/2010 for IN020464..retained_tooth_no was going as dissplay tooth no
					}

			   }else{
					if(super_tooth_ref == "RD"){//Added by Sridevi Joshi on 12/17/2009 for RTDESTH new changes
				//Added by Sridevi Joshi on 12/17/2009 for RTDESTH new changes TO GET mapped tooth no
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					retained_tooth_no = trimString(xmlHttp.responseText); 
					retained_tooth_no = localTrimString(retained_tooth_no); 
				}
			}
				if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "P"){
					if(retained_tooth_no == "RD"){ //This is for the deciduous(primary) tooth (RTDESTH)
						deci_supr_tooth_selected = "deci_tooth_selected";
					}
					/*else if(super_tooth_ref == "s1" || super_tooth_ref == "s2"){ //This is for the supernumarary tooth (SUPRTH)
						deci_supr_tooth_selected = "supr_tooth_selected";
					}*/
					else if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined && super_tooth_ref != "RD"){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
					  deci_supr_tooth_selected = "supr_tooth_selected";
					}
					/*else if(RD_SUPR_yn == "" && super_tooth_ref != "s1" && super_tooth_ref != "s2"){ //On Permanent_tooth after recording SUPRTH added by Sridevi Joshi on 12/15/2009 for new SUPRTH changes
						deci_supr_tooth_selected = "supr_normal_tooth"; //This is for the permanent tooth (SUPRTH)
					}*/
					else{
						if(code_desc_arr[0] == "RTDESTH"){						
							rtd_decith_applicable = "rtd_decith_applicable";
						}
						else if(code_desc_arr[0] == "SUPRTH"){
							deci_supr_tooth_selected = "supr_normal_tooth"; //This is for the permanent tooth (SUPRTH)
						}
					}

				 if(code_desc_arr[0] == "ATRARER"){
						if(site=="QUAD"){
							atrarer_applicable = ""; 
						}else{
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 

							if(retVal == "ATRARER"){
								atrarer_applicable = "atrarer_applicable"; //Attrition,Abrasion and Erosion Tooth Condition
							}
						}
					}
					else if(code_desc_arr[0] == "MISSTH"){ 
						missth_applicable = "missth_applicable"; 
					}
					else if(code_desc_arr[0] == "TRUMTH"){
						if(site=="QUAD"){
							atrarer_applicable = ""; 
						}else{
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "TRUMTH"){
								trauma_applicable = "trauma_applicable";
							}
						}
					}
					else if(code_desc_arr[0] == "MOBLTY"){//commented by parul on 03/09/2009 for CRF#699 added mobility_applicable 
						if(site=="QUAD"){
							atrarer_applicable = ""; 
						}else{
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "MOBLTY"){
								mobility_applicable = "mobility_applicable"; //Attrition,Abrasion and Erosion Tooth Condition
							}
						}
					}
					//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
					else if(code_desc_arr[0] == "MALPOSN"){
						if(site=="QUAD"){
							atrarer_applicable = ""; 
						}else{
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "MALPOSN"){
								malposn_applicable = "malposn_applicable"; 
							}
						}
					}
					else if(code_desc_arr[0] == "MALOCLN"){
						malocclusion_applicable = "malocclusion_applicable";
					}//End
					else if(code_desc_arr[0] == "IMPACTN"){
						impact_applicable = "impact_applicable"; 
					}
					else if(code_desc_arr[0] == "RTDESTH"){ 
						if(code_desc_arr[2] == "R"){
							display_menu_yn = "Y";
							//uner_applicable = "uner_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "UNERTH" && super_tooth_ref != "RD"){//RD_SUPR_yn != "RD" is added bcoz we are adding one UNERTH record forcibly in to table when RTDESTH is recorded in case of Permanent  chart.// super_tooth_ref != "RD" This condition is not to get menu on retained tooth
						uner_applicable = "uner_applicable"; 
						/*added by parul for super changes if u recod root or crown-->super num --> on unerupted tooth menu was not coming*/
						rootinvtooth_not_applicable="";
						pulpinv_not_applicable="";
						periinv_not_applicable="";
						cariestooth_not_applicable="";
						//end 
					}
					else if(code_desc_arr[0] == "PARERTH" && super_tooth_ref != "RD"){// super_tooth_ref != "RD" This condition is not to get menu on retained tooth
						parer_uner_applicable = "parer_uner_applicable"; 
					}
					else if(code_desc_arr[0] == "ERUPTH" && super_tooth_ref != "RD"){// super_tooth_ref != "RD" This condition is not to get menu on retained tooth
						erup_applicable = "erup_applicable";
						impact_applicable = "";
						rootinvtooth_not_applicable = "";
						periinv_not_applicable = "";
						pulpinv_not_applicable = "";
						cariestooth_not_applicable = "";
					}
					else if(code_desc_arr[0] == "EXFOLTH"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "EXFOLTH"){
							parer_er_applicable = "parer_er_applicable"; 
							/*if caries ,root ,pulp,peri apical is recorded on Permanent tooth when tooth is exfoliated from data entry by parul on 15/12/2009 for super change*/
							cariestooth_not_applicable = "cariestooth_not_applicable"; 
							rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
							periinv_not_applicable = "periinv_not_applicable"; 
							/*end */
							display_menu_yn = "N";
						}
					}
					else if(code_desc_arr[0] == "PULPINV"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "PULPINV"){
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "PERIINV"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "PERIINV"){
							periinv_not_applicable = "periinv_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "CARIES" && site=="TOOTH"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "CARIES"){
							cariestooth_not_applicable = "cariestooth_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "ROOTINV" && site=="TOOTH"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "ROOTINV"){
							rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
						}
					}
					/*else if(code_desc_arr[0] == "PULPINV" && site == "CROWN"){ 
						pulpinv_not_applicable = "pulpinv_not_applicable"; 
					}
					else if(code_desc_arr[0] == "PERIINV" && site == "ROOT"){ 
						periinv_not_applicable = "periinv_not_applicable"; 
					}
					else if(code_desc_arr[0] == "PULPINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
						pulpinv_not_applicable = "pulpinv_not_applicable"; 
					}
					else if(code_desc_arr[0] == "PERIINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
						periinv_not_applicable = "periinv_not_applicable"; 
					}
					else if(code_desc_arr[0] == "ROOTINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
						rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
					}
					else if(code_desc_arr[0] == "CARIES" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
						cariestooth_not_applicable = "cariestooth_not_applicable"; 
					}*/
					else if((site == "CROWN" || site == "ROOT")){/* If Root and Crown related Condition is recorded */
						parer_er_not_applicable = "parer_er_not_applicable"; // for Root and Crown related Condition

					}
					
					if(parer_uner_applicable != "parer_uner_applicable" && uner_applicable != "uner_applicable"){
						miss_uner_applicable = "miss_uner_applicable"; 
					}
					else{
						miss_uner_applicable = "miss_uner_impact_applicable"; 
					}

					if(impact_applicable == "impact_applicable"){
						miss_uner_applicable = "miss_uner_applicable"; 
					}
				}
				else if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "D"){
                 
					/*if(super_tooth_ref == "s1" || super_tooth_ref == "s2"){ //This is for the supernumarary tooth (SUPRTH)
						deci_supr_tooth_selected = "supr_tooth_selected";

					}*/
					if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined && super_tooth_ref != "RD"){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
					  deci_supr_tooth_selected = "supr_tooth_selected";
					}
					/*else if(RD_SUPR_yn == "" && super_tooth_ref != "s1" && super_tooth_ref != "s2"){ //On Permanent_tooth after recording SUPRTH added by Sridevi Joshi on 12/15/2009 for new SUPRTH changes
						deci_supr_tooth_selected = "supr_normal_tooth"; //This is for the permanent tooth (SUPRTH)
					}*/
					else{
						if(code_desc_arr[0] == "SUPRTH"){
							deci_supr_tooth_selected = "supr_normal_tooth"; //This is for the permanent tooth (SUPRTH)
						}
					}

					if(code_desc_arr[0] == "ATRARER"){// Added by Sridevi joshi for IN013794	
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "ATRARER"){
							atrarer_applicable = "atrarer_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "MISSTH"){ 
						missth_applicable = "missth_applicable"; 
					}
					else if(code_desc_arr[0] == "TRUMTH"){// Added by Sridevi joshi for IN013794	
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "TRUMTH"){
							trauma_applicable = "trauma_applicable";
							erup_applicable = "";//Added by Sridevi Joshi for IN015362
						}
					}
					else if(code_desc_arr[0] == "MOBLTY"){ // Added By Sridevi Joshi For IN013794
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "MOBLTY"){
							mobility_applicable = "mobility_applicable"; //Attrition,Abrasion and Erosion Tooth Condition
						}
					}
					//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
					else if(code_desc_arr[0] == "MALPOSN"){ // Added By Sridevi Joshi For IN013794
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "MALPOSN"){
							malposn_applicable = "malposn_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "MALOCLN"){
						malocclusion_applicable = "malocclusion_applicable";
					}//End
					else if(code_desc_arr[0] == "UNERTH"){
						uner_applicable = "uner_applicable"; 
					}
					else if(code_desc_arr[0] == "PARERTH"){ 
						parer_uner_applicable = "parer_uner_applicable"; 
					}
					else if(code_desc_arr[0] == "ERUPTH"){
						erup_applicable = "erup_applicable"; 
						impact_applicable = "";
					}
					else if(code_desc_arr[0] == "EXFOLTH"){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "EXFOLTH"){
							parer_er_applicable = "parer_er_applicable"; 
							/*if caries ,root ,pulp,peri apical is recorded on Permanent tooth when tooth is exfoliated from data entry by parul on 15/12/2009 for super change*/
							cariestooth_not_applicable = "cariestooth_not_applicable"; 
							rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
							periinv_not_applicable = "periinv_not_applicable"; 
							/*end */
							display_menu_yn = "N";
						}
					}
					else if(code_desc_arr[0] == "PULPINV"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "PULPINV"){
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "PERIINV"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "PERIINV"){
							periinv_not_applicable = "periinv_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "CARIES" && site=="TOOTH"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "CARIES"){
							cariestooth_not_applicable = "cariestooth_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "ROOTINV" && site=="TOOTH"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "ROOTINV"){
							rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
						}
					}
					/*else if(code_desc_arr[0] == "PULPINV" && site == "CROWN"){ 
						pulpinv_not_applicable = "pulpinv_not_applicable"; 
					}
					else if(code_desc_arr[0] == "PERIINV" && site == "ROOT"){ 
						periinv_not_applicable = "periinv_not_applicable"; 
					}
					else if(code_desc_arr[0] == "PULPINV" && site == "TOOTH"){
						pulpinv_not_applicable = "pulpinv_not_applicable"; 
					}
					else if(code_desc_arr[0] == "PERIINV" && site == "TOOTH"){
						periinv_not_applicable = "periinv_not_applicable"; 
					}
					else if(code_desc_arr[0] == "ROOTINV" && site == "TOOTH"){ 
						rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
					}
					else if(code_desc_arr[0] == "CARIES" && site == "TOOTH"){ 
						cariestooth_not_applicable = "cariestooth_not_applicable"; 
					}*/
					else if((site == "CROWN" || site == "ROOT")){/* If Root and Crown related Condition is recorded */
						parer_er_not_applicable = "parer_er_not_applicable"; // for Root and Crown related Condition
					}
					
					miss_uner_applicable = "miss_uner_applicable"; 
				}
				else if(mixed_dentition_YN == "Y"){
					if(permanent_deciduous_flag == "D"){
						if(super_tooth_ref == "RD"){ //This is for the deciduous(primary) tooth (RTDESTH)
							deci_supr_tooth_selected = "deci_tooth_selected";
						}
						/*else if(super_tooth_ref == "s1" || super_tooth_ref == "s2"){ //This is for the supernumarary tooth (SUPRTH) added by Parul on 12/15/2009 for new SUPRTH changes
							deci_supr_tooth_selected = "supr_tooth_selected";
						}*/
						else if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined && super_tooth_ref != "RD"){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
						  deci_supr_tooth_selected = "supr_tooth_selected";
						}
						else{
							if(code_desc_arr[0] == "RTDESTH"){
								parer_uner_applicable = "parer_uner_applicable"; //This is for the permanent tooth (RTDESTH)
								rtd_decith_applicable = "rtd_decith_applicable";
							}
							else if(code_desc_arr[0] == "SUPRTH"){
								deci_supr_tooth_selected = "supr_normal_tooth"; //This is for the permanent tooth (SUPRTH)
							}
						}

						if(code_desc_arr[0] == "ATRARER"){
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;

							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "ATRARER"){
								atrarer_applicable = "atrarer_applicable"; //Attrition,Abrasion and Erosion Tooth Condition
							}
							
						}
						else if(code_desc_arr[0] == "MISSTH"){ 
							missth_applicable = "missth_applicable"; 
						}
						else if(code_desc_arr[0] == "TRUMTH"){
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "TRUMTH"){
								trauma_applicable = "trauma_applicable";
							}
						}
						else if(code_desc_arr[0] == "MOBLTY"){ // Added By Sridevi Joshi For IN013794
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "MOBLTY"){
								mobility_applicable = "mobility_applicable"; //Attrition,Abrasion and Erosion Tooth Condition
							}
						}
						//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
						else if(code_desc_arr[0] == "MALPOSN"){ // Added By Sridevi Joshi For IN013794
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "MALPOSN"){
								malposn_applicable = "malposn_applicable"; 
							}
						}
						else if(code_desc_arr[0] == "MALOCLN"){
							malocclusion_applicable = "malocclusion_applicable";
						}//End
						else if(code_desc_arr[0] == "RTDESTH"){ 
							if(code_desc_arr[2] == "R"){
								display_menu_yn = "Y";
							}
						}
						else if(code_desc_arr[0] == "UNERTH" && super_tooth_ref != "RD"){
							uner_applicable = "uner_applicable"; 
						}
						else if(code_desc_arr[0] == "PARERTH" && super_tooth_ref != "RD"){ //RD_SUPR_yn != "RD" is added bcoz we are adding one UNERTH record forcibly in to table when RTDESTH is recorded in case of Permanent  chart.
							parer_uner_applicable = "parer_uner_applicable"; 
							 var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}
							  if (exfolth_count!=0 && (ref_tooth_no=="" || ref_tooth_no=="null" || ref_tooth_no==null)){//added by parul for super changes flag "ref_tooth_no" is to Differentiate  data entry and dental chart
								periinv_not_applicable = "periinv_not_applicable"; 
								pulpinv_not_applicable = "pulpinv_not_applicable"; 
								cariestooth_not_applicable = "cariestooth_not_applicable"; 
								rootinvtooth_not_applicable = "rootinvtooth_not_applicable";
								mobility_applicable = "mobility_applicable";
								trauma_applicable = "trauma_applicable";
								atrarer_applicable = "atrarer_applicable";
								uner_applicable = "uner_applicable";


								
                           }else{
								 uner_applicable = ""; //temprorary added to get the menu on exfolth----> erupted toooth
								deci_supr_tooth_selected = "";
								mobility_applicable = "";
								trauma_applicable = "";
								atrarer_applicable = "";
								//Added by Sharon Crasta on 12/1/2009 Peri Apical -> Retained -> Erupt -> New root -> should be able to record periapical condition on the newly erupted root.
								periinv_not_applicable = "";
								pulpinv_not_applicable = "";
								//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
								malposn_applicable = "";	
								//End
						   }
						}
						else if(code_desc_arr[0] == "ERUPTH" && super_tooth_ref != "RD"){
                            var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							erup_applicable = "erup_applicable";
							impact_applicable = "";
							
							//parer_er_applicable = "";//temprorary added to get the menu on exfolth----> erupted toooth
							if(parer_uner_applicable != ""){
								parer_uner_applicable = "";
							}
                           if (exfolth_count!=0 && (ref_tooth_no=="" || ref_tooth_no=="null" || ref_tooth_no==null)){//added by parul for super changes flag "ref_tooth_no" is to Differentiate  data entry and dental chart
								periinv_not_applicable = "periinv_not_applicable"; 
								pulpinv_not_applicable = "pulpinv_not_applicable"; 
								cariestooth_not_applicable = "cariestooth_not_applicable"; 
								rootinvtooth_not_applicable = "rootinvtooth_not_applicable";
								mobility_applicable = "mobility_applicable";
								trauma_applicable = "trauma_applicable";
								atrarer_applicable = "atrarer_applicable";
								uner_applicable = "uner_applicable";
								//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
								malposn_applicable = "malposn_applicable";	
								//End
								
                           }else{
								 uner_applicable = ""; //temprorary added to get the menu on exfolth----> erupted toooth
								deci_supr_tooth_selected = "";
								mobility_applicable = "";
								trauma_applicable = "";
								atrarer_applicable = "";
								//Added by Sharon Crasta on 12/1/2009 Peri Apical -> Retained -> Erupt -> New root -> should be able to record periapical condition on the newly erupted root.
								periinv_not_applicable = "";
								pulpinv_not_applicable = "";
								//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
								malposn_applicable = "";	
								//End
						   }
						}
						else if(code_desc_arr[0] == "EXFOLTH"){
							var exfolth_count = 0;
							var retVal_SuperKey_count = 0;
							var total_SuperKey_count = 0;

							//Added by SRidevi Joshi on 1/27/2010 for IN010894(SRR20056-CRF-0481). To get super_key_val
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_SUPR_yn;

							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_SuperKey = trimString(xmlHttp.responseText); 
							retVal_SuperKey = localTrimString(retVal_SuperKey); 
							var retVal_SuperKey_arr = retVal_SuperKey.split("~");

							if(retVal_SuperKey_arr.length >1){

								retVal_SuperKey_count = parseInt(retVal_SuperKey_arr.length)-1;
								
								total_SuperKey_count = parseInt(retVal_SuperKey_count)+1; //this is to include tooth_no count also
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var exfolth_retVal = trimString(xmlHttp.responseText); 
							exfolth_retVal = localTrimString(exfolth_retVal); 
							if(exfolth_retVal == "EXFOLTH"){
								//To retrieve chart_line_num if SUPRTH is recorded
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
								xmlHttp.send(xmlDoc);
								var suprth_chart_line_num = trimString(xmlHttp.responseText);
								suprth_chart_line_num = localTrimString(suprth_chart_line_num);
								if(suprth_chart_line_num.length > 0){
									//Added to count the number of Exfoliated conditions recorded in case of Retained.
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+RD_SUPR_yn;
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									//xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
									xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfToothForSUPRTH&"+params,false);
									xmlHttp.send(xmlDoc);
									var count_Exf = trimString(xmlHttp.responseText);
									count_Exf = localTrimString(count_Exf);
									if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
										var exfolth_retVal_arr = count_Exf.split("##");
										exfolth_count = exfolth_retVal_arr[0];			
									}
									if(exfolth_count == total_SuperKey_count){
										uner_applicable = "uner_applicable";
										deci_supr_tooth_selected = "";
										mobility_applicable = "";
										trauma_applicable = "";
										atrarer_applicable = "";
										display_menu_yn = "Y";
										//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										malposn_applicable = "";	
										//End
									}
									else{
										/*if (code_desc_arr[2]=="M"){//added by parul on 13/01/2010 for super changes ,exfoliate-->erupted-->super num-->not able to record any condition
											uner_applicable = "uner_applicable";
											mobility_applicable = "";
											trauma_applicable = "";
											atrarer_applicable = "";
											display_menu_yn = "Y";
											//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											malposn_applicable = "";	
											//End
										}else{*/
											parer_er_applicable = "parer_er_applicable"; 
											display_menu_yn = "N";
										//}
									}

									/*if(exfolth_count == "1"){
										if (code_desc_arr[2]=="M"){//added by parul on 13/01/2010 for super changes ,exfoliate-->erupted-->super num-->not able to record any condition
											uner_applicable = "uner_applicable";
											mobility_applicable = "";
											trauma_applicable = "";
											atrarer_applicable = "";
											display_menu_yn = "Y";
											//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											malposn_applicable = "";	
											//End
										}else{
											parer_er_applicable = "parer_er_applicable"; 
											display_menu_yn = "N";
										}
									}
									else if(exfolth_count == "2"){
										uner_applicable = "uner_applicable";
										deci_supr_tooth_selected = "";
										mobility_applicable = "";
										trauma_applicable = "";
										atrarer_applicable = "";
										display_menu_yn = "Y";
										//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										malposn_applicable = "";	
										//End
									}*/
								}
								else{
								
									 if (ref_tooth_no=="" || ref_tooth_no=="null" || ref_tooth_no==null){//added by parul if tooth if exfoliated ,should not allow to record from data entry becoz tooth no is permanet.
										erup_applicable = "erup_applicable";
										parer_uner_applicable = "parer_uner_applicable";
									 }
									uner_applicable = "uner_applicable";
									mobility_applicable = "";
									trauma_applicable = "";
									atrarer_applicable = "";
									display_menu_yn = "Y";
									//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
									malposn_applicable = "";	
									//End
								}
							}
							
							

						}
						/*else if(code_desc_arr[0] == "PULPINV" && site == "CROWN"){ 
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "PERIINV" && site == "ROOT"){ 
							periinv_not_applicable = "periinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "PULPINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "PERIINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
							periinv_not_applicable = "periinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "ROOTINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
						
							rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
						}
						else if(code_desc_arr[0] == "CARIES" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
											
							cariestooth_not_applicable = "cariestooth_not_applicable"; 
						}*/
					else if(code_desc_arr[0] == "PULPINV"){ 
						var exfolth_count = 0;
						//Added to count the number of Exfoliated conditions recorded in case of Retained.
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
						xmlHttp.send(xmlDoc);
						var count_Exf = trimString(xmlHttp.responseText);
						count_Exf = localTrimString(count_Exf);
						if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
							var exfolth_retVal_arr = count_Exf.split("##");
							exfolth_count = exfolth_retVal_arr[0];			
						}

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "PULPINV"){
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "PERIINV"){ 
						var exfolth_count = 0;
						//Added to count the number of Exfoliated conditions recorded in case of Retained.
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
						xmlHttp.send(xmlDoc);
						var count_Exf = trimString(xmlHttp.responseText);
						count_Exf = localTrimString(count_Exf);
						if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
							var exfolth_retVal_arr = count_Exf.split("##");
							exfolth_count = exfolth_retVal_arr[0];			
						}

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "PERIINV"){
							periinv_not_applicable = "periinv_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "CARIES" && site=="TOOTH"){ 
						var exfolth_count = 0;
						//Added to count the number of Exfoliated conditions recorded in case of Retained.
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
						xmlHttp.send(xmlDoc);
						var count_Exf = trimString(xmlHttp.responseText);
						count_Exf = localTrimString(count_Exf);
						if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
							var exfolth_retVal_arr = count_Exf.split("##");
							exfolth_count = exfolth_retVal_arr[0];			
						}

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "CARIES"){
							cariestooth_not_applicable = "cariestooth_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "ROOTINV" && site=="TOOTH"){ 
						var exfolth_count = 0;
						//Added to count the number of Exfoliated conditions recorded in case of Retained.
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
						xmlHttp.send(xmlDoc);
						var count_Exf = trimString(xmlHttp.responseText);
						count_Exf = localTrimString(count_Exf);
						if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
							var exfolth_retVal_arr = count_Exf.split("##");
							exfolth_count = exfolth_retVal_arr[0];			
						}

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "ROOTINV"){
							rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
						}
					}
						else if((site == "CROWN" || site == "ROOT")){/* If Root and Crown related Condition is recorded */
							parer_er_not_applicable = "parer_er_not_applicable"; // for Root and Crown related Condition

						}
						
						miss_uner_applicable = "miss_uner_applicable"; 
					}
					else if(permanent_deciduous_flag == "P"){
						if(super_tooth_ref == "RD" || RD_SUPR_yn=="D"){ //IN016204 by parul on 16/11/2009
							show_exfolth = "show_exfolth";
						}
						else{
							show_exfolth = "";
						}

						if(super_tooth_ref == "RD"){ //This is for the deciduous(primary) tooth (RTDESTH)
							deci_supr_tooth_selected = "deci_tooth_selected";
						}
						/*else if(super_tooth_ref == "s1" || super_tooth_ref == "s2"){ //This is for the supernumarary tooth (SUPRTH) added by Parul on 12/15/2009 for new SUPRTH changes
							deci_supr_tooth_selected = "supr_tooth_selected";
						}*/
						else if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined && super_tooth_ref != "RD"){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
						  deci_supr_tooth_selected = "supr_tooth_selected";
						}
						else{
							if(code_desc_arr[0] == "RTDESTH"){
								parer_uner_applicable = "parer_uner_applicable"; //This is for the permanent tooth (RTDESTH)
								
								rtd_decith_applicable = "rtd_decith_applicable";
								//Added by Sharon Crasta on 12/1/2009 Peri Apical -> Retained -> Erupt -> New root -> should be able to record periapical condition on the newly erupted root.
								periinv_not_applicable = "";
							}
							else if(code_desc_arr[0] == "SUPRTH"){
								deci_supr_tooth_selected = "supr_normal_tooth"; //This is for the permanent tooth (SUPRTH)
							}
						}

						 if(code_desc_arr[0] == "ATRARER"){//Added by Sridevi Joshi for IN013794
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "ATRARER"){
								atrarer_applicable = "atrarer_applicable"; //Attrition,Abrasion and Erosion Tooth Condition
							}
						}
						else if(code_desc_arr[0] == "MISSTH"){ 
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "MISSTH"){
								missth_applicable = "missth_applicable"; 
							}
							
						}
						else if(code_desc_arr[0] == "TRUMTH"){//Added by Sridevi Joshi for IN013794
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "TRUMTH"){
								trauma_applicable = "trauma_applicable";
							}
						}
						else if(code_desc_arr[0] == "MOBLTY"){// Added By Sridevi Joshi For IN013794
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "MOBLTY"){
								mobility_applicable = "mobility_applicable"; 
							}
						}
						//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
						else if(code_desc_arr[0] == "MALPOSN"){
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "MALPOSN"){
								malposn_applicable = "malposn_applicable"; 
							}
						}
						else if(code_desc_arr[0] == "MALOCLN"){
							malocclusion_applicable = "malocclusion_applicable";
						}//End
						else if(code_desc_arr[0] == "DECITH"){  
							//commented by parul on 21/12/2009 for super changes ,DECITH--->SUPRTH--->EXFOLT on super tooth it was going on if blk,becoz of  "uner_applicable" menu was not comng now this blk is not requird becoz we r handling this in exfolation blk

						  /*if(code_desc_arr[4] == "D"){//Added by Sridevi Joshi on 12/16/2009--DECITH--->SUPRTH--->EXFOLTH both
								uner_applicable = "uner_applicable"; 
								display_menu_yn = "Y";
							}
							else{*/
								 if (ref_tooth_no=="" || ref_tooth_no=="null" || ref_tooth_no==null){//added by parul for super changes flag "ref_tooth_no" is to Differentiate  data entry and dental chart
									periinv_not_applicable = "periinv_not_applicable"; 
									pulpinv_not_applicable = "pulpinv_not_applicable"; 
									cariestooth_not_applicable = "cariestooth_not_applicable"; 
									rootinvtooth_not_applicable = "rootinvtooth_not_applicable";
									mobility_applicable = "mobility_applicable";
									trauma_applicable = "trauma_applicable";
									atrarer_applicable = "atrarer_applicable";
									//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
									malposn_applicable ="malposn_applicable";
									//End
								}
								decith_applicable = "decith_applicable"; 
							//}
						}
						else if(code_desc_arr[0] == "RTDESTH"){ 
							if(code_desc_arr[2] == "R"){
								display_menu_yn = "Y";
							}
						}
						else if(code_desc_arr[0] == "UNERTH" && super_tooth_ref != "RD"){
							uner_applicable = "uner_applicable"; 
						}
						else if(code_desc_arr[0] == "PARERTH" && super_tooth_ref != "RD"){//RD_SUPR_yn != "RD" is added bcoz we are adding one UNERTH record forcibly in to table when RTDESTH is recorded in case of Permanent  chart.
							parer_uner_applicable = "parer_uner_applicable"; 
						}
						else if(code_desc_arr[0] == "ERUPTH" && super_tooth_ref != "RD"){
							erup_applicable = "erup_applicable"; 
							uner_applicable = "";
							parer_uner_applicable = "";
							impact_applicable = "";
							parer_er_applicable = "";
							decith_applicable = "";
						}
						else if(code_desc_arr[0] == "EXFOLTH"){
							var exfolth_count = 0;

							var retVal_SuperKey_count = 0;
							var total_SuperKey_count = 0;

							//Added by SRidevi Joshi on 1/27/2010 for IN010894(SRR20056-CRF-0481). To get super_key_val
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_SUPR_yn;

							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_SuperKey = trimString(xmlHttp.responseText); 
							retVal_SuperKey = localTrimString(retVal_SuperKey); 
							var retVal_SuperKey_arr = retVal_SuperKey.split("~");

							if(retVal_SuperKey_arr.length >1){
								retVal_SuperKey_count = parseInt(retVal_SuperKey_arr.length)-1;
								total_SuperKey_count = parseInt(retVal_SuperKey_count)+1; //this is to include tooth_no count also
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;

							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var exfolth_retVal = trimString(xmlHttp.responseText); 
							exfolth_retVal = localTrimString(exfolth_retVal); 
							if(exfolth_retVal == "EXFOLTH"){
								//To retrieve chart_line_num if SUPRTH is recorded
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
								xmlHttp.send(xmlDoc);
								var suprth_chart_line_num = trimString(xmlHttp.responseText);
								suprth_chart_line_num = localTrimString(suprth_chart_line_num);
								if(suprth_chart_line_num.length > 0){
									//Added to count the number of Exfoliated conditions recorded in case of Retained.
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+RD_SUPR_yn;
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									//xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
									xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfToothForSUPRTH&"+params,false);
									xmlHttp.send(xmlDoc);
									var count_Exf = trimString(xmlHttp.responseText);
									count_Exf = localTrimString(count_Exf);
									if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
										var exfolth_retVal_arr = count_Exf.split("##");
										exfolth_count = exfolth_retVal_arr[0];			
									}

									/*if(exfolth_count == "1"){
										if (code_desc_arr[2]=="D"){//added by parul on 17/12/2009 for super changes ,deciduous-->exfoliate-->super num-->menu was not coming on normal tooth.
											uner_applicable = "uner_applicable";
											mobility_applicable = "";
											trauma_applicable = "";
											atrarer_applicable = "";
											display_menu_yn = "Y";
											//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											malposn_applicable = "";
											//End
										}else{
											parer_er_applicable = "parer_er_applicable"; 
											display_menu_yn = "N";
										}
									}
									else if(exfolth_count == "2"){
										uner_applicable = "uner_applicable";
										deci_supr_tooth_selected = "";
										mobility_applicable = "";
										trauma_applicable = "";
										atrarer_applicable = "";
										display_menu_yn = "Y";
										//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										malposn_applicable = "";
										//End
									}*/
									if(total_SuperKey_count == exfolth_count){
										uner_applicable = "uner_applicable";
										deci_supr_tooth_selected = "";
										mobility_applicable = "";
										trauma_applicable = "";
										atrarer_applicable = "";
										display_menu_yn = "Y";
										malposn_applicable ="";//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										decith_applicable = "";
									}else{
										/*if (code_desc_arr[2]=="D"){//added by parul on 17/12/2009 for super changes ,deciduous-->exfoliate-->super num-->menu was not coming on normal tooth.
											//uner_applicable = "uner_applicable";
											uner_applicable = "uner_applicable";
											mobility_applicable = "";
											trauma_applicable = "";
											atrarer_applicable = "";
											display_menu_yn = "Y";
											//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											malposn_applicable ="";
											//End
										}else{*/
											parer_er_applicable = "parer_er_applicable"; 
											display_menu_yn = "N";

											
										//}
									}
								}
								else{
									/* if (ref_tooth_no=="" || ref_tooth_no=="null" || ref_tooth_no==null){//added by parul if tooth if exfoliated ,should not allow to record from data entry becoz tooth no is permanet.
										erup_applicable = "erup_applicable";
										parer_uner_applicable = "parer_uner_applicable";
									 }*/
										uner_applicable = "uner_applicable";
										display_menu_yn = "Y";

										decith_applicable = "";

								}
							}
						}
						/*else if(code_desc_arr[0] == "PULPINV" && site == "CROWN"){ 
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "PERIINV" && site == "ROOT"){ 
							periinv_not_applicable = "periinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "PULPINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "PERIINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
							periinv_not_applicable = "periinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "ROOTINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
							rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
						}
						else if(code_desc_arr[0] == "CARIES" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
							cariestooth_not_applicable = "cariestooth_not_applicable"; 
						}
						
						*/
						else if(code_desc_arr[0] == "PULPINV"){ 
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "PULPINV"){
								pulpinv_not_applicable = "pulpinv_not_applicable"; 
							}
						}
						else if(code_desc_arr[0] == "PERIINV"){ 
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "PERIINV"){
								periinv_not_applicable = "periinv_not_applicable"; 
							}
						}
						else if(code_desc_arr[0] == "CARIES" && site=="TOOTH"){ 
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "CARIES"){
								cariestooth_not_applicable = "cariestooth_not_applicable"; 
							}
						}
						else if(code_desc_arr[0] == "ROOTINV" && site=="TOOTH"){ 
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "ROOTINV"){
								rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
							}
						}
						else if((site == "CROWN" || site == "ROOT")){/* If Root and Crown related Condition is recorded */
							parer_er_not_applicable = "parer_er_not_applicable"; // for Root and Crown related Condition
						}
						//if(impact_applicable != "impact_applicable"){
							miss_uner_applicable = "miss_uner_applicable"; 
						//}
						//else{
						//	miss_uner_applicable = "miss_uner_impact_applicable"; 
						//}
					}
				}
			}
		}
	}
	else{
		no_records = "no_records";
	}

	if(mixed_dentition_YN == "Y"){
		if(mixed_dent_num != null && mixed_dent_num != "null" && mixed_dent_num != ""){
			mixed_parer_applicable = "mixed_parer_applicable";
		}
	}
	/*
	else{
		if(mixed_dent_num != null && mixed_dent_num != "null" && mixed_dent_num != ""){
			mixed_parer_applicable = "mixed_parer_applicable";
		}
	}
	*/

	//Added by Sharon Crasta on 2/19/2010 for SRR20056-CRF-0475
	var retVal_bridge_extract="";//added by parul on 07/05/2010 for IN021229
	if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "P"){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params_bridge_extract = "func_mode=getTrmtCatCode&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
		xmlHttp.send(xmlDoc);
		retVal_bridge_extract = trimString(xmlHttp.responseText); 
		retVal_bridge_extract = localTrimString(retVal_bridge_extract);
		if(retVal_bridge_extract.length > 0){
			abutment_applicable = "abutment_applicable" ;
		}
	} //End

	if(no_records == "no_records"){
		retVal = no_records;
		if(retVal_bridge_extract.length > 0){//Added by Sridevi Joshi on 4/26/2010 for PE..Written common block for query above
			retVal =  abutment_applicable;
		}
		//Added by Sharon Crasta on 2/19/2010 for SRR20056-CRF-0475
		/*if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "P"){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params_bridge_extract = "func_mode=getTrmtCatCode&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
			xmlHttp.send(xmlDoc);
			var retVal_bridge_extract = trimString(xmlHttp.responseText); 
			retVal_bridge_extract = localTrimString(retVal_bridge_extract);
			if(retVal_bridge_extract.length > 0){
				abutment_applicable = "abutment_applicable" ;
				retVal =  abutment_applicable;
			}
		} //End*/
	}
	else{
		if(mixed_dentition_YN == "Y"){
			
			var return_val = display_menu_yn+"~~"+show_exfolth+"~~"+super_not_applcable+"~~"+miss_uner_applicable+"~~"+parer_uner_applicable+"~~"+missth_applicable+"~~"+uner_applicable+"~~"+parer_er_applicable+"~~"+rtd_decith_applicable+"~~"+erup_applicable+"~~"+atrarer_applicable+"~~"+super_applicable+"~~"+trauma_applicable+"~~"+decith_applicable+"~~"+deci_supr_tooth_selected+"~~"+parer_er_not_applicable+"~~"+pulpinv_not_applicable+"~~"+impact_applicable+"~~"+periinv_not_applicable+"~~"+rootinvtooth_not_applicable+"~~"+cariestooth_not_applicable+"~~"+mobility_applicable+"~~"+malposn_applicable+"~~"+malocclusion_applicable;	//Added malposn_applicable,malocclusion_applicable by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
		}
		else{
			//Added abutment_applicable by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
			var return_val = display_menu_yn+"~~"+show_exfolth+"~~"+super_not_applcable+"~~"+miss_uner_applicable+"~~"+parer_uner_applicable+"~~"+missth_applicable+"~~"+uner_applicable+"~~"+parer_er_applicable+"~~"+rtd_decith_applicable+"~~"+erup_applicable+"~~"+mixed_parer_applicable+"~~"+atrarer_applicable+"~~"+super_applicable+"~~"+trauma_applicable+"~~"+decith_applicable+"~~"+deci_supr_tooth_selected+"~~"+parer_er_not_applicable+"~~"+pulpinv_not_applicable+"~~"+impact_applicable+"~~"+periinv_not_applicable+"~~"+rootinvtooth_not_applicable+"~~"+cariestooth_not_applicable+"~~"+mobility_applicable+"~~"+malposn_applicable+"~~"+malocclusion_applicable+"~~"+abutment_applicable;	//Added malposn_applicable,malocclusion_applicable by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
		}
		var ret_arr  = return_val.split("~~");
		for(l=0;l<ret_arr.length;l++){
			if(ret_arr[l] != ""){
				if(l==0){
					retVal = ret_arr[l];
				}
				else{
					retVal = retVal+"~~"+ret_arr[l];
				}
			}
		}
	}
	return retVal;
	
}

//Commented and Added by Sharon Crasta on 3/13/2009 to pass the site_type to accept the data entry for the first quadrant.
//function resultedConditionTypes(applicable_yn,applicable_cond_types,applicable_cond_desc,tooth_no,mixed_dentition_YN,permanent_deciduous_flag,display_menu_yn,condition_type){
function resultedConditionTypes(applicable_yn,applicable_cond_types,applicable_cond_desc,tooth_no,mixed_dentition_YN,permanent_deciduous_flag,display_menu_yn,condition_type,site_type,RD_Normal_yn){
	var patient_id = document.forms[0].patient_id.value;
	var chart_num = document.forms[0].chart_num.value;
	var ref_tooth_no = document.forms[0].ref_tooth_no.value;
	var super_not_applcable = "";
	var erupth_yn = "N";
	var super_cnt = "";
	var ispartially_erupted = false; //added by parul on 10/09/2009 for IN014257(record Partially Erupted,any condition on crown after that menu was not coming on tooth for MP,MD chart,passed flag "ispulp_recorded" in caries,root involvement,periapical)

	if(ref_tooth_no == "" || ref_tooth_no == "null" || ref_tooth_no == null || ref_tooth_no == "undefined" || ref_tooth_no == undefined){
		if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
			RD_Normal_yn = "MR";
		}
	}
	
	//Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	params = "func_mode=checkSuperCount&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_cond = trimString(xmlHttp.responseText); 
	retVal_cond = localTrimString(retVal_cond); 
	var retVal_cond_arr = retVal_cond.split("##");
	var condition_type_ref = retVal_cond_arr[1];
	if(condition_type_ref == "SUPRTH"){
		super_cnt = retVal_cond_arr[2];
	}

	for(z=0;z<applicable_yn.length;z++){
		temp_array = new Array();
		temp_array_desc = new Array();
		show_exfolth = applicable_yn[1];
		if(applicable_yn[z] == "rtd_decith_applicable"){
			super_not_applcable = "super_not_applcable";	
		}

		//super_not_applcable = applicable_yn[2];
		if(applicable_yn[z] != "N" && applicable_yn[z] != "Y" && applicable_yn[z] != "show_exfolth"  && applicable_yn[z] != "super_not_applcable" && applicable_yn[z] != "rtd_decith_applicable"){ // This necessary bcoz we are not checking for the conditions applicable_yn[z] == "N" and applicable_yn[z] == "Y".. So its better to remove these from the list
			for(i=0; i<applicable_cond_types.length; i++ ){
				if(mixed_dentition_YN == "Y"){ // For Mixed Dentition Case
					if(permanent_deciduous_flag == "D"){ // For Mixed Dentition - Deciduous Chart
					
						if(applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "IMPACTN"){
							if(applicable_yn[z] == "miss_uner_applicable"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "UNERTH"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
									
								}
							}else if(applicable_yn[z] == "missth_applicable"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//added by parul on 21/04/2010 for IN020794
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "parer_uner_applicable"){ //Partially Erupted Condition
								//if(applicable_cond_types[i] == "ERUPTH" ){
								ispartially_erupted=true;
                               
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
										
								}
							}
							else if(applicable_yn[z] == "deci_tooth_selected"){ // Deciduous Tooth case
								//if(applicable_cond_types[i] == "EXFOLTH" || applicable_cond_types[i] == "ATRARER" || applicable_cond_types[i] == "TRUMTH"){

								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "supr_tooth_selected"){ // Deciduous Tooth case
								//if(applicable_cond_types[i] == "EXFOLTH" || applicable_cond_types[i] == "ATRARER" || applicable_cond_types[i] == "TRUMTH"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "supr_normal_tooth" && super_cnt == "1"){//Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To allow SUPRTH 2nd time.
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "supr_normal_tooth"){ // Deciduous Tooth case
								/* Removed EXFOLTH from below condition for IN015475 by Sridevi Joshi on 16/10/09 */
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "trauma_applicable" ){ // Deciduous Tooth case
								//if(applicable_cond_types[i] == "ATRARER" || applicable_cond_types[i] == "EXFOLTH" ){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "mobility_applicable"){ // MOBILITY Tooth case for CRF#699 added by parul on 03/09/2009(If Mobility is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.)
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY"&& applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
							//If malposition condition is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.
							else if(applicable_yn[z] == "malposn_applicable"){
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MALPOSN"&& applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "malocclusion_applicable"){
							   if(applicable_cond_types[i] != "MALOCLN"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}//End
							else if(applicable_yn[z] == "atrarer_applicable"){ // Attrition,Abration and Erosion Tooth case
								//if(applicable_cond_types[i] == "TRUMTH" || applicable_cond_types[i] == "EXFOLTH" || applicable_cond_types[i] == "SUPRTH"){
									if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "parer_er_applicable" ){ // Exfoliated Case
								//if(applicable_cond_types[i] == "PARERTH" || applicable_cond_types[i] == "ERUPTH"){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i]!="ERUPTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "erup_applicable" && super_not_applcable != "super_not_applcable"){ // Erupted Case and if RTDESTH is not recorded previously...
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "erup_applicable" && super_not_applcable == "super_not_applcable"){ // Erupted Case  and if RTDESTH is recorded previously...
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "SUPRTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "mixed_parer_applicable"){ // Erupted Case
								//if(applicable_cond_types[i] == "PARERTH" || applicable_cond_types[i] == "ERUPTH"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "uner_applicable"){ // Un Erupted Case
								//if(applicable_cond_types[i] == "PARERTH" || applicable_cond_types[i] == "ERUPTH"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							/* Added by Sridevi Joshi for IN013769(Not getting ERUPTH in the menu after PULPINV-->Retained-->Exfolth on deciduous tooth) on 22/08/09 */
							else if(applicable_yn[z] == "pulpinv_not_applicable" && super_not_applcable == "super_not_applcable"){ // For Pulp Involvement Condition
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "CARIES" ){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "pulpinv_not_applicable"){ // For Pulp Involvement Condition
								if(ispartially_erupted==true){
									if(applicable_cond_types[i] != "PARERTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "CARIES" ){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}else{
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "CARIES" ){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									
										}
								}
							}
							/* Added by Sridevi Joshi for IN013769(Not getting ERUPTH in the menu after PERIINV-->Retained-->Exfolth on deciduous tooth) on 22/08/09 */
							else if(applicable_yn[z] == "periinv_not_applicable" && super_not_applcable == "super_not_applcable"){ // For Pulp Involvement Condition
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "periinv_not_applicable"){ // For Pulp Involvement Condition
								if(ispartially_erupted==true){

									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								
								}
							}
							/* Added by Sridevi Joshi for IN013769(Not getting ERUPTH in the menu after ROOTHINV-->Retained-->Exfolth on deciduous tooth) on 22/08/09 */
							else if(applicable_yn[z] == "rootinvtooth_not_applicable" && super_not_applcable == "super_not_applcable"){ // For Root Involvement Condition when menu select from Site TOOTH
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "rootinvtooth_not_applicable"){ // For Root Involvement Condition when menu select from Site TOOTH
								if(ispartially_erupted==true){
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								
								}
							}
							/* Added by Sridevi Joshi for IN013769(Not getting ERUPTH in the menu after CARIES-->Retained-->Exfolth on deciduous tooth) on 22/08/09 */
							else if(applicable_yn[z] == "cariestooth_not_applicable" && super_not_applcable == "super_not_applcable"){ // For Caries Condition when menu select from Site TOOTH
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "cariestooth_not_applicable"){ // For Caries Condition when menu select from Site TOOTH
								if(ispartially_erupted==true){
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							}
							/*
							else if(applicable_yn[z] == "rootinv_not_applicable"){ // For Pulp Involvement Condition
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							*/
							else if(applicable_yn[z] == "parer_er_not_applicable"){ // For Crown and Root related Conditions
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else{
								//This condition was not there...bcoz of which we were getting the menu on Missing tooth also(content of If block was there ....added only if condition) by Sridevi Joshi on 17/12/2008 
								if(applicable_yn[z] == "no_records"){ // No conditions are recorded.
									//if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if((tooth_no == 2 && site_type == "TOOTH" ) || ( tooth_no == 3 && site_type == "TOOTH" ) || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
										//if(applicable_cond_types[i] == "PARERTH" || applicable_cond_types[i] == "ERUPTH"){ //unerrupted is applicable only for extream tooth
										if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "IMPACTN"&& applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}									
								}
								//Added by Sharon Crasta on 11/27/2009 for IN016114
								//When the tooth is extracted from the treatment tab, the condition type is taken as missing tooth.
								else{
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
						}
					}
					else{
						//For Mixed Dentition - Permanent Chart
						if(applicable_cond_types[i] != "IMPACTN"){
							if(applicable_yn[z] == "miss_uner_applicable"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "UNERTH"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}else if(applicable_yn[z] == "missth_applicable"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//added by parul on 21/04/2010 for IN020794
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "parer_uner_applicable"){ //Partially Erupted Condition
								//if(applicable_cond_types[i] == "ERUPTH" ){
								//Added by Sharon Crasta on 10/10/2009 for IN015207
								ispartially_erupted = true;
								//
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
										
								}
							}
							else if(applicable_yn[z] == "decith_applicable"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH"  && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "ATRARER"){// && applicable_cond_types[i] != "ATRARER" added by parul for super changes,attrition should not come in menu on deciduous
								//End
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "trauma_applicable" && show_exfolth == "show_exfolth"){ // Deciduous Tooth case
								/* Removed ATRARER and added TRUMTH in the condition for IN015478 by Sridevi Joshi on 21/10/09 */
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "trauma_applicable" && show_exfolth != "show_exfolth"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "EXFOLTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							//Added by Sharon Crasta on 10/29/2009 for IN015697
							//If mobility is recorded on Deciduous tooth and Retained Deciduous tooth, then Exfoliation should appear. On a permanent tooth, on mobility exfoliation shoudl not appear.
							else if(applicable_yn[z] == "mobility_applicable" && show_exfolth == "show_exfolth"){ // MOBILITY Tooth case for CRF#699 added by parul on 03/09/2009(If Mobility is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.)
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY"&& applicable_cond_types[i] != "DECITH"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}							
							//else if(applicable_yn[z] == "mobility_applicable"){ // MOBILITY Tooth case for CRF#699 added by parul on 03/09/2009(If Mobility is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.)
							else if(applicable_yn[z] == "mobility_applicable"  && show_exfolth != "show_exfolth"){ // MOBILITY Tooth case for CRF#699 added by parul on 03/09/2009(If Mobility is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.)
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY"&& applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "EXFOLTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							//Added by Sharon Crasta on 10/29/2009 for IN015697
							//If mobility is recorded on Deciduous tooth and Retained Deciduous tooth, then Exfoliation should appear. On a permanent tooth, on mobility exfoliation shoudl not appear.
							else if(applicable_yn[z] == "malposn_applicable" && show_exfolth == "show_exfolth"){
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MALPOSN"&& applicable_cond_types[i] != "DECITH"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}							
							else if(applicable_yn[z] == "malposn_applicable"  && show_exfolth != "show_exfolth"){
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MALPOSN"&& applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "EXFOLTH"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "malocclusion_applicable"){
							   if(applicable_cond_types[i] != "MALOCLN"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}//End
							else if(applicable_yn[z] == "super_applicable"){ // Deciduous Tooth case
								///if(applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "EXFOLTH"){
								if(applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "EXFOLTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							//Added by Sharon Crasta on 10/29/2009 for IN015697
							//If attrition is recorded on Deciduous tooth and Retained Deciduous tooth, then Exfoliation should appear. On a permanent tooth, on attrition exfoliation should not appear.
							else if(applicable_yn[z] == "atrarer_applicable"  && show_exfolth == "show_exfolth"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "atrarer_applicable"  && show_exfolth != "show_exfolth"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "EXFOLTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "parer_er_applicable"){ // Exfoliated Case
								ispartially_erupted=true;//Added by Sharon Crasta on 10/10/2009 for IN015207

								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "deci_tooth_selected"){ // Deciduous Tooth case //Added EXFOLTH on 070208 by Sridevi Joshi
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "supr_tooth_selected" && show_exfolth!="show_exfolth"){ // SUPRTH condition for deciduous tooth // show_exfolth Added  by parul on 13/11/2009 for IN016204
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "EXFOLTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}else if(applicable_yn[z] == "supr_tooth_selected" && show_exfolth=="show_exfolth"){ // SUPRTH condition for deciduous tooth // show_exfolth Added  by parul on 13/11/2009 for IN016204
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "supr_normal_tooth" && show_exfolth != "show_exfolth" && super_cnt == "1"){ //Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To allow SUPRTH 2nd time.
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "supr_normal_tooth" && show_exfolth != "show_exfolth"){ // SUPRTH condition for permanent tooth //added by parul on 13/11/2009 for IN016204
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "supr_normal_tooth"  && show_exfolth == "show_exfolth" && super_cnt == "1"){ //Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To allow SUPRTH 2nd time.
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "supr_normal_tooth"  && show_exfolth == "show_exfolth"){ // SUPRTH condition for permanent tooth//added by parul on 13/11/2009 for IN016204
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "erup_applicable" && super_not_applcable != "super_not_applcable"){ // Erupted Case
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "erup_applicable" && super_not_applcable == "super_not_applcable"){ // Erupted Case
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "SUPRTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "mixed_parer_applicable"){ // Erupted Case
								//if(applicable_cond_types[i] == "PARERTH" || applicable_cond_types[i] == "ERUPTH"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "uner_applicable"){ // Un Erupted Case
								//if(applicable_cond_types[i] == "PARERTH" || applicable_cond_types[i] == "ERUPTH"){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH"&& applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							//Added by Sharon Crasta on 10/13/2009 for IN015312
							else if(applicable_yn[z] == "pulpinv_not_applicable" && display_menu_yn == "Y"){ // For Pulp Involvement Condition
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									//if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							} //End
							else if(applicable_yn[z] == "pulpinv_not_applicable"){ // For Pulp Involvement Condition
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									//Added by Sharon Crasta on 10/10/2009 for IN015207
									//Added to display Eruption menu option once any condition is recorded on the partially erupted condition(crown)
									if(!ispartially_erupted){
										//if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "CARIES"){ 
										//Removed EXFOLTH from condition by Sridevi Joshi on 4/8/2010 IN020566
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "CARIES"){ 
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{ //End
										//if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
							}
							//Added by Sharon Crasta on 10/13/2009 for IN015312
							//else if(applicable_yn[z] == "periinv_not_applicable" && display_menu_yn == "Y"){ // For Pulp Involvement Condition
							else if(applicable_yn[z] == "periinv_not_applicable" && show_exfolth == "show_exfolth"){ // For Pulp Involvement Condition
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									//if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN" ){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							} //End
							//else if(applicable_yn[z] == "periinv_not_applicable"){ // For Pulp Involvement Condition
							else if(applicable_yn[z] == "periinv_not_applicable" && show_exfolth != "show_exfolth"){ // For Pulp Involvement Condition
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									/*if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}*/
									if(ispartially_erupted==true){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}else{
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}									
									}
								}
							}
							//Added by Sharon Crasta on 10/13/2009 for IN015312
							//else if(applicable_yn[z] == "rootinvtooth_not_applicable" && display_menu_yn == "Y"){ // For Root Involvement Condition when menu select from Site TOOTH
							else if(applicable_yn[z] == "rootinvtooth_not_applicable" && show_exfolth == "show_exfolth"){ // For Root Involvement Condition when menu select from Site TOOTH
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									//if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN" ){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							} //End
							//else if(applicable_yn[z] == "rootinvtooth_not_applicable"){ // For Root Involvement Condition when menu select from Site TOOTH
							else if(applicable_yn[z] == "rootinvtooth_not_applicable" && show_exfolth != "show_exfolth"){ // For Root Involvement Condition when menu select from Site TOOTH
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									if(!ispartially_erupted){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){ 
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{ //End
										//if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
							}
							//Added by Sharon Crasta on 10/13/2009 for IN015312
							//else if(applicable_yn[z] == "cariestooth_not_applicable" && display_menu_yn == "Y"){ // For Caries Condition when menu select from Site TOOTH
							else if(applicable_yn[z] == "cariestooth_not_applicable" && show_exfolth == "show_exfolth"){ // For Caries Condition when menu select from Site TOOTH
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									//if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
									if(applicable_cond_types[i] != "PARERTH"  && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN" ){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							} //End
							//else if(applicable_yn[z] == "cariestooth_not_applicable"){ // For Caries Condition when menu select from Site TOOTH
							else if(applicable_yn[z] == "cariestooth_not_applicable" && show_exfolth != "show_exfolth"){ // For Caries Condition when menu select from Site TOOTH
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									//Added by Sharon Crasta on 10/10/2009 for IN015207
									//Added to display Eruption menu option once any condition is recorded on the partially erupted condition(crown)
									if(!ispartially_erupted){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){ 
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{ //End
										//if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
							}
							/*
							else if(applicable_yn[z] == "rootinv_not_applicable"){ // For Pulp Involvement Condition
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							*/
							else if(applicable_yn[z] == "parer_er_not_applicable"){ // For Crown and Root related Conditions
								//Added by Sharon Crasta on 10/10/2009 for IN015207
								ispartially_erupted=true;
								//
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "EXFOLTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else{
								if(applicable_yn[z] == "no_records"){ // No conditions are recorded.
								  //Commented and Added by Sharon Crasta on 3/13/2009 to accept the data entry for the first quadrant.
								  //if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
								   if((tooth_no == 2 && site_type == "TOOTH" ) || ( tooth_no == 3 && site_type == "TOOTH" ) || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
										//if(applicable_cond_types[i] == "PARERTH" || applicable_cond_types[i] == "ERUPTH"){ //unerrupted is applicable only for extream tooth
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH"&& applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{
										
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "EXFOLTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
								//Added by Sharon Crasta on 11/27/2009 for IN016114
								//When the tooth is extracted from the treatment tab, the condition type is taken as missing tooth.
								else{
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
								
							}
						}
					}
				}
				else{ // Other than Mixed Dentition case
					if(permanent_deciduous_flag == "D"){ // For Deciduous Chart
						if(applicable_cond_types[i] != "IMPACTN"){
							if(applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "RTDESTH"){
								if(applicable_yn[z] == "miss_uner_applicable"){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "UNERTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "missth_applicable"){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//added by parul on 21/04/2010 for IN020794
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "uner_applicable"){ // Un Erupted Case
									//if(applicable_cond_types[i] == "PARERTH" || applicable_cond_types[i] == "ERUPTH"){
										if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH"&& applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "parer_uner_applicable"){ //Partially Erupted Condition
									//if(applicable_cond_types[i] == "ERUPTH"){
										//Added by Sharon Crasta on 10/10/2009 for IN015207
										ispartially_erupted = true;
										//
										if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
											
									}
								}
								else if(applicable_yn[z] == "supr_tooth_selected"){ // Deciduous Tooth case
									//if(applicable_cond_types[i] == "EXFOLTH" || applicable_cond_types[i] == "ATRARER" || applicable_cond_types[i] == "TRUMTH"){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								} 
								else if(applicable_yn[z] == "supr_normal_tooth" && super_cnt == "1"){ //Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To allow SUPRTH 2nd time.
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								} 
								else if(applicable_yn[z] == "supr_normal_tooth"){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								} 
								else if(applicable_yn[z] == "trauma_applicable"){ // Deciduous Tooth case
									//if(applicable_cond_types[i] == "ATRARER" || applicable_cond_types[i] == "EXFOLTH" ){ //SUPRTH is added on 02/11/2007
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "PARERTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "mobility_applicable"){ // MOBILITY Tooth case for CRF#699 added by parul on 03/09/2009(If Mobility is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.)
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
								//If malposition condition is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.
								else if(applicable_yn[z] == "malposn_applicable"){
									if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MALPOSN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "malocclusion_applicable"){
								   if(applicable_cond_types[i] != "MALOCLN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}//End
								else if(applicable_yn[z] == "super_applicable"){ // Deciduous Tooth case
									if(applicable_cond_types[i] != "SUPRTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "atrarer_applicable"){ // Deciduous Tooth case
									//if(applicable_cond_types[i] == "TRUMTH" || applicable_cond_types[i] == "EXFOLTH"){
										if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "PARERTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "parer_er_applicable"){ // Exfoliated Case
									//Added by Sharon Crasta on 10/10/2009 for IN015207
									ispartially_erupted = true;
									//
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
											
								}
								else if(applicable_yn[z] == "erup_applicable"){ // Erupted Case
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" ){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "pulpinv_not_applicable"){ // For Pulp Involvement Condition
									//Added by Sharon Crasta on 10/10/2009 for IN015207
									//Added to display Eruption menu option once any condition is recorded on the partially erupted condition(crown)
									if(!ispartially_erupted){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{
										//if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
								else if(applicable_yn[z] == "periinv_not_applicable"){ // For Pulp Involvement Condition
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "rootinvtooth_not_applicable"){ // For Root Involvement Condition when menu select from Site TOOTH
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "cariestooth_not_applicable"){ // For Caries Condition when menu select from Site TOOTH
									//Added by Sharon Crasta on 10/10/2009 for IN015207
									//Added to display Eruption menu option once any condition is recorded on the partially erupted condition(crown)
									if(!ispartially_erupted){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{
										//if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
								/*
								else if(applicable_yn[z] == "rootinv_not_applicable"){ // For Pulp Involvement Condition
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								*/
								else if(applicable_yn[z] == "parer_er_not_applicable"){ // For Crown and Root related Conditions
									//Added by Sharon Crasta on 10/10/2009 for IN015207
									ispartially_erupted = true;
									//
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									if(applicable_yn[z] == "no_records"){ // No conditions are recorded.
										//if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"){
										if(applicable_cond_types[i] != "ERUPTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								//Added by Sharon Crasta on 11/27/2009 for IN016114
								//When the tooth is extracted from the treatment tab, the condition type is taken as missing tooth.
								else{
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
									
								}
							}
						}
					}

					else if(permanent_deciduous_flag == "P"){ //For Permanent Chart
						if(applicable_cond_types[i] != "DECITH"){
							if(applicable_yn[z] == "miss_uner_applicable"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}else if(applicable_yn[z] == "missth_applicable"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//added by parul on 21/04/2010 for IN020794
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "miss_uner_impact_applicable"){
							//Commented by Sharon Crasta on 6/17/2009 for IN011402
							//	if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "UNERTH"){
							//		temp_array[i] = applicable_cond_types[i];
							//		temp_array_desc[i] = applicable_cond_desc[i];
							//	}
							//
							//Condition added for 3rd molar also by Sridevi Joshi on 12/17/2009 for IN017296
							if(tooth_no == 6 || tooth_no == 11 || tooth_no == 22 || tooth_no == 27 || tooth_no == 1 || tooth_no == 16 || tooth_no == 17 || tooth_no == 32){
								 	if(applicable_cond_types[i] == "IMPACTN" || applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXTRACT"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];							
									}
								}else if(tooth_no != 6 || tooth_no != 11 || tooth_no != 22 || tooth_no != 27){
									if(applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXTRACT"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];		
									} 
								}
							}
							else if(applicable_yn[z] == "uner_applicable"){ // Un Erupted Case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH"&& applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "impact_applicable"){ // Impaction Condition Case it is only applicable in Permanent chart
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982) // 03 MAR Sridevi
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "parer_er_applicable" && display_menu_yn == "Y"){ // Exfoliated Case
								ispartially_erupted=true;//Added by Sharon Crasta on 10/10/2009 for IN015207

								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "parer_er_applicable"){ // Exfoliated Case
								ispartially_erupted=true;//Added by Sharon Crasta on 10/10/2009 for IN015207

								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							
							}
							else if(applicable_yn[z] == "parer_uner_applicable" && display_menu_yn != "D"){ //Partially Erupted Condition
								//Added by Sharon Crasta on 10/10/2009 for IN015207
								ispartially_erupted=true;

								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
										
								}
							}
							else if(applicable_yn[z] == "deci_tooth_selected"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" ){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "supr_tooth_selected"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "supr_normal_tooth" && super_cnt == "1"){ //Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To allow SUPRTH 2nd time.
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"  && applicable_cond_types[i] != "EXTRACT"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "supr_normal_tooth" ){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"  && applicable_cond_types[i] != "EXTRACT"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "trauma_applicable"){ // Trauma Tooth case
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "mobility_applicable"){ // MOBILITY Tooth case for CRF#699 added by aprul on 03/09/2009(If Mobility is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.)
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
							}
							//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
							//If malposition condition is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.
							else if(applicable_yn[z] == "malposn_applicable"){
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MALPOSN"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "malocclusion_applicable"){
							   if(applicable_cond_types[i] != "MALOCLN"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}//End
							else if(applicable_yn[z] == "super_applicable"){ // Supernumarary Tooth case
								if(applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "atrarer_applicable"){ // Attrition,Abrasion and Erosion case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "erup_applicable" && super_not_applcable != "super_not_applcable"){ // Erupted Case
								erupth_yn = "Y";
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "IMPACTN" ){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "erup_applicable" && super_not_applcable == "super_not_applcable"){ // Erupted Case
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "SUPRTH" ){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "pulpinv_not_applicable"){ // For Pulp Involvement Condition
								if((tooth_no == 1 || tooth_no == 16 || tooth_no == 17 || tooth_no == 32)&& erupth_yn != "Y"){//erupth_yn is to get the menu after ERUPTH. If it is 'N' menu will be poulated for PARERTH for the 3rd molars 
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "CARIES"){ //unerrupted is applicable only for extream tooth //added CARIES condition to remove CARIES menu once PULPINV is recorded
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									//Added by Sharon Crasta on 10/10/2009 for IN015207
									//Added to display Eruption menu option once any condition is recorded on the partially erupted condition(crown)
									if(!ispartially_erupted){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
							}
							else if(applicable_yn[z] == "periinv_not_applicable"){ // For Pulp Involvement Condition
								if((tooth_no == 1 || tooth_no == 16 || tooth_no == 17 || tooth_no == 32) && erupth_yn != "Y"){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "RTDESTH"){ //unerrupted is applicable only for extream tooth
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							}

							else if(applicable_yn[z] == "rootinvtooth_not_applicable"){ // For Root Involvement Condition when menu select from Site TOOTH
								if((tooth_no == 1 || tooth_no == 16 || tooth_no == 17 || tooth_no == 32)&& erupth_yn != "Y"){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "RTDESTH"){ //unerrupted is applicable only for extream tooth
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							}
							else if(applicable_yn[z] == "cariestooth_not_applicable"){ // For Caries Condition when menu select from Site TOOTH
								if((tooth_no == 1 || tooth_no == 16 || tooth_no == 17 || tooth_no == 32)&& erupth_yn != "Y"){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "RTDESTH"){ //unerrupted is applicable only for extream tooth
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									//Added by Sharon Crasta on 10/10/2009 for IN015207
									//Added to display Eruption menu option once any condition is recorded on the partially erupted condition(crown)
									if(!ispartially_erupted){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{
										//if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
							}
							else if(applicable_yn[z] == "parer_er_not_applicable"){ // For Crown and Root related Conditions
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							//Added by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
							else if(applicable_yn[z] == "abutment_applicable"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}//End
							else{
								if(applicable_yn[z] == "no_records"){ // No conditions are recorded.
									//if(tooth_no == 1 || tooth_no == 16 || tooth_no == 17 || tooth_no == 32){
									//Commented and Added by Sharon Crasta on 3/13/2009 to accept the data entry for the first quadrant.
									//if((tooth_no == 1 || tooth_no == 16 || tooth_no == 17 || tooth_no == 32){
									if((tooth_no == 1 && site_type =="TOOTH") || tooth_no == 16 || tooth_no == 17 || tooth_no == 32){
									//
										if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982) //unerrupted is applicable only for extream tooth
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else if(tooth_no == 6 || tooth_no == 11 || tooth_no == 22 || tooth_no == 27){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
										
									}
								}
							}
						}
					}
				}
			}
			applicable_cond_types = temp_array;
			applicable_cond_desc = temp_array_desc;
		}
	}

	return applicable_cond_types;
}


function applicableTrmtMenuOptions(applicable_trmt_types,tooth_no,patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,RD_Normal_yn,site,thrng_nos_ref,counter,len,no_of_tooth,super_tooth_ref,retained_tooth_no,flag_not_consecutive){
	var formObj = document.forms[0]; 
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var arr_prev = "";
	var miss_uner_applicable = "";
	var parer_uner_applicable = "";
	var missth_applicable = "";
	var rtd_decith_applicable = "";
	var parer_er_applicable = "";
	var uner_applicable = "";
	var erup_applicable = "";
	var mixed_parer_applicable = "";
	var decith_applicable = "";
	var impact_applicable = "";
	var trauma_applicable = "";
	var super_applicable = "";
	var atrarer_applicable = "";
	var display_menu_yn = "N";
	var deci_supr_tooth_selected = "";
	var parer_er_not_applicable = "";
	var pulpinv_not_applicable = "";
	var no_records = "";
	var retVal = "";
	//var return_surface_alert = true;

	var mixed_dent_num = "";

	var dentalChartFormObj = "";
	
	if(parent.parent.conditionDentalChartDetails == null || parent.parent.conditionDentalChartDetails == "null"){
		dentalChartFormObj = parent.trmtDentalChartDetails;
	}
	else{
		dentalChartFormObj = parent.parent.conditionDentalChartDetails;
	}

    var return_surface_alert = "N";
	//var trmt_arr = new Array();
	var applicable_trmt_types_arr = new Array();
	var applicable_trmt_types_arr1 = new Array();
	tooth_layer = "toothLayer"+tooth_no;
	root_layer = "rootLayer"+tooth_no;
	if(site == "THRNG"){ // For Tooth Range	
		if(len >1){ //This is exclusively for Bridge Treatment
			//added by parul on 29/01/2010 for CRF-442
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=ChkAllsurface&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_surface = localTrimString(xmlHttp.responseText);
			if (retVal_surface=="*A"){
				return_surface_alert = "Y";
			}//end
			
			//Added by Sharon Crasta on 3/17/2010 for IN019944
			//Added so that Bridge is not displayed when Implant, Denture, Impaction(condition) is recorded on a tooth.
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			params = "func_mode=checkForTrmtForMenu&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_trmt_menu = trimString(xmlHttp.responseText); 
			retVal_trmt_menu = localTrimString(retVal_trmt_menu); 

			//Added by Sharon Crasta on 3/23/2010 for IN019944
			//Bridge should not be displayed while Impaction Condition has been recorded.
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForImpactionCondForMenu&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_impactn = trimString(xmlHttp.responseText);
			retVal_impactn = localTrimString(retVal_impactn);
			//End
			
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			params = "func_mode=ChkOutComeTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;

			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_outcome = trimString(xmlHttp.responseText); 
			retVal_outcome = localTrimString(retVal_outcome); 
			if(retVal_outcome.length > 1){//block is for if outcome is not null
				var retVal_outcome_arr = retVal_outcome.split("~");
				for(var j=0;j<retVal_outcome_arr.length-1;j++){
					var code_desc_arr = retVal_outcome_arr[j].split("##");
					var trmt_type = code_desc_arr[0];
					var trmt_outcome = code_desc_arr[1];
					var denture_removable = code_desc_arr[2];
					//Added by Sharon Crasta on 3/23/2010 for IN019944
					//We are considering trmt_outcome as "S", when it is null.
					if(trmt_outcome == "" || trmt_outcome == "null" || trmt_outcome == null || trmt_outcome == "undefined" || trmt_outcome == undefined) {
						trmt_outcome = "S";
					}
					//End
					
				 	if(trmt_outcome=="F" || (trmt_outcome=="" || trmt_outcome=="null" || trmt_outcome==null) || trmt_outcome=="undefined" || trmt_outcome==undefined){
				 	//if(trmt_outcome=="F"){
						//   if (return_surface_alert=="Y") {	//added by parul on 29/01/2010 for CRF-442
							for(k=0;k<applicable_trmt_types.length;k++){

								//Added by Sharon Crasta on 3/10/2010 for SRR20056-CRF-0475
								// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt. 
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");					  	 xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForERUPTHForMenu&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_eruption = trimString(xmlHttp.responseText);
								retVal_eruption = localTrimString(retVal_eruption);
								//End
								if((counter == "0" || counter == len) && applicable_trmt_types[k] == "BRIDGE" && (trmt_type != "IMPACT" || retVal_impactn != "IMPACTN")){
									if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined"){
										//Added by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868)
										if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
											if(!flag_not_consecutive){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
											if(!flag_not_consecutive){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}								
										} //End
									}else if((dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined") && dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined"){
										   for(k=0;k<applicable_trmt_types.length;k++){//Added by Parul on 27/02/2010 for SRR20056-CRF-0477
												if (trmt_type=="BRIDGE"){
												  //Added mixed_dentition_YN , permanent_deciduous_flag by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868) - to make bridge applicable only for the permanent chart.
													if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
														if(applicable_trmt_types[k] == "BRIDGE" && !flag_not_consecutive){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
													}else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
														if(!flag_not_consecutive){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}								
													} //End
												}
										   }
									} 
									else{
										if(applicable_trmt_types[k] != "BRIDGE"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}
								else if((counter == "0" || counter == len) && applicable_trmt_types[k] == "DENTURE"){//Added by Sridevi Joshi on 4/5/2010 for IN020203
									if((dentalChartFormObj.document.getElementById(root_layer) == null || dentalChartFormObj.document.getElementById(root_layer) == "null" || dentalChartFormObj.document.getElementById(root_layer) == undefined || dentalChartFormObj.document.getElementById(root_layer) == "undefined") && (dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined")){
										if(applicable_trmt_types[k] == "DENTURE"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}
								else if(counter > 0  && counter < len && applicable_trmt_types[k] == "BRIDGE" && no_of_tooth == (parseInt(len)-1) && (trmt_type != "IMPACT" || retVal_impactn != "IMPACTN")){
									if((dentalChartFormObj.document.getElementById(root_layer) == null || dentalChartFormObj.document.getElementById(root_layer) == "null" || dentalChartFormObj.document.getElementById(root_layer) == undefined || dentalChartFormObj.document.getElementById(root_layer) == "undefined") && (dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined")){
										
										//Added by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868)
										if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
											if(!flag_not_consecutive){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
											if(!flag_not_consecutive){
											
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}								
										} //End
									}
									else{
										if(applicable_trmt_types[k] != "BRIDGE"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}
							else{
								if(return_surface_alert =="Y"){//if blk added by parul on 03/02/2010 for CRF-442
									for(k=0;k<applicable_trmt_types.length;k++){
											if((dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined") && (dentalChartFormObj.document.getElementById(root_layer) == null || dentalChartFormObj.document.getElementById(root_layer) == "null" || dentalChartFormObj.document.getElementById(root_layer) == undefined || dentalChartFormObj.document.getElementById(root_layer) == "undefined")){
												if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "BRIDGE"){ 
												//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}
											}else{
												if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){ 
												//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}
											}
										}		

								}
								else{
									if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined"){
										for(k=0;k<applicable_trmt_types.length;k++){
											if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}		
									}
									//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
									//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
									else if((dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined") && dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined"){
										   if (trmt_type=="BRIDGE"){
												//if(applicable_trmt_types[k] != "BRIDGE"){
												if(applicable_trmt_types[k] == "BRIDGE" && (trmt_type != "IMPACT" || retVal_impactn != "IMPACTN")){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
												}else{//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868) ---//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
												 if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													 }
												}
									}
									//Added by Sharon Crasta on 3/23/2010 for IN019944
									//Added so that Bridge is not seen when Impaction condition /trmt is recorded on a tooth.
									else if(trmt_type == "IMPACT" || retVal_impactn == "IMPACTN"){
									 for(y=0;y<applicable_trmt_types.length;y++){
											if(applicable_trmt_types[y] == "BRIDGE"){
												applicable_trmt_types = "";
												applicable_trmt_types_arr[y] = applicable_trmt_types[y];
											}
										}	
									}//End
									else{
										for(k=0;k<applicable_trmt_types.length;k++){
											if (trmt_type=="BRIDGE"){
												if(applicable_trmt_types[k] != "BRIDGE"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}
											}else{//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868) ---//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
											if(applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT" || applicable_trmt_types[k] == "DENTURE"){ //Denture is added by Sridevi JOshi on 2/27/2010
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}
											}
										}	
									}
								}
							}
						}
				//	}
					}else{
						 if(denture_removable=="Y"){
							for(k=0;k<applicable_trmt_types.length;k++){
								if(applicable_trmt_types[k] == "DENTURE" ){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
								}
							}
						}//Added by Sharon Crasta on 3/23/2010 for IN019944
						   //If the Denture is not removaable and is a success then Bridge should not be recorded on that range of tooth.
						   else if(denture_removable=="N"){
							  for(y=0;y<applicable_trmt_types.length;y++){
									if(applicable_trmt_types[y] == "BRIDGE"){
										applicable_trmt_types = "";
										applicable_trmt_types_arr[y] = applicable_trmt_types[y];
									}
								}
							
						   } //End
						  else{
							if(trmt_type=="EXTRACT" || trmt_type =="IMPLANT" || trmt_type=="MAXILLA" || trmt_type=="ORTHO"){
								//if(trmt_type=="EXTRACT" || trmt_type =="IMPLANT"){
									for(y=0;y<applicable_trmt_types.length;y++){
										//Added by Sharon Crasta on 3/10/2010 for SRR20056-CRF-0475
										// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt. 
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");					  	 xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForERUPTHForMenu&"+params,false);
										xmlHttp.send(xmlDoc);
										var retVal_eruption = trimString(xmlHttp.responseText);
										retVal_eruption = localTrimString(retVal_eruption);
										//End

										if((counter == "0" || counter == len) && applicable_trmt_types[y] == "BRIDGE" && (retVal_trmt_menu < 1)){
											if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined"){
												//Added by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868)
												if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
													if(!flag_not_consecutive){
														applicable_trmt_types_arr[y] = applicable_trmt_types[y];
													}
												} else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
													if(!flag_not_consecutive){
													
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}								
												} //End
											}
											else if((dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined") && dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined"){
												   for(k=0;k<applicable_trmt_types.length;k++){//Added by Parul on 27/02/2010 for SRR20056-CRF-0477
													
														if (trmt_type=="BRIDGE" && (retVal_trmt_menu < 1)){
														  //Added by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868) 
															if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
																if(applicable_trmt_types[k] == "BRIDGE" && !flag_not_consecutive){
																	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
																}
															}else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
																if(!flag_not_consecutive){
																
																	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
																}								
															} 
														}else{
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														} //End
												   }
											} 
											else if((dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined") && (dentalChartFormObj.document.getElementById(root_layer) == null || dentalChartFormObj.document.getElementById(root_layer) == "null" || dentalChartFormObj.document.getElementById(root_layer) == undefined || dentalChartFormObj.document.getElementById(root_layer) == "undefined")){//Added by Sridevi Jsohi on 3/5/2010 for SRR20056-CRF-0478
												for(k=0;k<applicable_trmt_types.length;k++){
													if(applicable_trmt_types[k] == "DENTURE"){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
												}
											}
											else{
												if(applicable_trmt_types[y] != "BRIDGE"){
													applicable_trmt_types_arr[y] = applicable_trmt_types[y];
												}
											}
										}
										else if((counter == "0" || counter == len) && applicable_trmt_types[y] == "DENTURE"){//Added by Sridevi Joshi on 4/5/2010 for IN020203
											if((dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined") && (dentalChartFormObj.document.getElementById(root_layer) == null || dentalChartFormObj.document.getElementById(root_layer) == "null" || dentalChartFormObj.document.getElementById(root_layer) == undefined || dentalChartFormObj.document.getElementById(root_layer) == "undefined")){//Added by Sridevi Jsohi on 3/5/2010 for SRR20056-CRF-0478
												for(k=0;k<applicable_trmt_types.length;k++){
													if(applicable_trmt_types[k] == "DENTURE"){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
												}
											}
										}
										else if(counter > 0  && counter < len && applicable_trmt_types[y] == "BRIDGE" && no_of_tooth == (parseInt(len)-1) && (retVal_trmt_menu < 1)){
											if((dentalChartFormObj.document.getElementById(root_layer) == null || dentalChartFormObj.document.getElementById(root_layer) == "null" || dentalChartFormObj.document.getElementById(root_layer) == undefined || dentalChartFormObj.document.getElementById(root_layer) == "undefined") && (dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined")){
												//Added tooth_no by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868) - not to display the bridge menu on the 3rd molars.
												if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
													if(!flag_not_consecutive){
														applicable_trmt_types_arr[y] = applicable_trmt_types[y];
													}
												}else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
													if(!flag_not_consecutive){
													
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}								
												} //End
											}
											else{
												if(applicable_trmt_types[y] != "BRIDGE"){
													applicable_trmt_types_arr[y] = applicable_trmt_types[y];
												}
											}
										}
										else if( applicable_trmt_types[y] != "ORTHO" && (retVal_trmt_menu < 1)){
											applicable_trmt_types_arr[y] = applicable_trmt_types[y];
										}
										//Added by Sharon Crasta on 3/23/2010 for IN019944
									   //If the Impaction,Implant,Denture are recorded and are a success then Bridge should not be recorded on that range of tooth.
										else if(retVal_trmt_menu > 1) {
											 applicable_trmt_types = "";
											 applicable_trmt_types_arr[y] = applicable_trmt_types[y];
										} //End
									}
								//}
							}
							//Added by Sharon Crasta on 3/3/2010 for SRR20056-CRF-0475(IN010868)
							if (trmt_type=="BRIDGE"){
								for(k=0;k<applicable_trmt_types.length;k++){
									if(applicable_trmt_types[k] != "BRIDGE"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}else{
									   //applicable_trmt_types = "";
									  // applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}
							}//End
						}
					}
					if(applicable_trmt_types_arr!=""){
						applicable_trmt_types=applicable_trmt_types_arr;
					}
				}
			}else{
				
				 // if (return_surface_alert=="Y"){	//added by parul on 29/01/2010 for CRF-442
						for(k=0;k<applicable_trmt_types.length;k++){
							//Added by Sharon Crasta on 3/3/2010 for SRR20056-CRF-0475(IN010868)
							//Bridge should not be displayed while Impaction Condition has been recorded.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForImpactionCondForMenu&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_impactn = trimString(xmlHttp.responseText);
							retVal_impactn = localTrimString(retVal_impactn);

							//Added by Sharon Crasta on 3/10/2010 for SRR20056-CRF-0475
							// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt. 
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");					  	 xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForERUPTHForMenu&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_eruption = trimString(xmlHttp.responseText);
							retVal_eruption = localTrimString(retVal_eruption);
							//End
								
							if((counter == "0" || counter == len) && applicable_trmt_types[k] == "BRIDGE" && retVal_impactn != "IMPACTN" && (retVal_trmt_menu < 1)){
								
								if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined"){
									//Added by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868)
									if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
										if(!flag_not_consecutive){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
										if(!flag_not_consecutive){
										
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}								
									} //End
								}
								else{
									if(applicable_trmt_types[k] != "BRIDGE"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}
							}
							else if(counter > 0  && counter < len && applicable_trmt_types[k] == "BRIDGE" && no_of_tooth == (parseInt(len)-1) && retVal_impactn != "IMPACTN" && (retVal_trmt_menu < 1)){
							
								if((dentalChartFormObj.document.getElementById(root_layer) == null || dentalChartFormObj.document.getElementById(root_layer) == "null" || dentalChartFormObj.document.getElementById(root_layer) == undefined || dentalChartFormObj.document.getElementById(root_layer) == "undefined") && (dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined")){
									
									//Added by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868)
									if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
										if(!flag_not_consecutive){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
										if(!flag_not_consecutive){
										
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}								
									} //End
								}
								else{
									if(applicable_trmt_types[k] != "BRIDGE"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}
							}
							else{
								if(return_surface_alert =="Y"){//if blk added by parul on 03/02/2010 for CRF-442
									for(k=0;k<applicable_trmt_types.length;k++){
											if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO" || applicable_trmt_types[k] == "DENTURE"){
											//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}		

								}else{
									if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined"){
										for(k=0;k<applicable_trmt_types.length;k++){
											if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
											//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}		
									}
									//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
									//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
									else if((dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined") && dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined"){
										//else if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined") {
									   for(k=0;k<applicable_trmt_types.length;k++){
											if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
											//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}
									} //End
									else{
										for(k=0;k<applicable_trmt_types.length;k++){
											//if(applicable_trmt_types_arr[k] != "EXTRACT" && applicable_trmt_types_arr[k] != "TOOTHTM" && applicable_trmt_types_arr[k] != "ORTHO"){
											if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}	
									}
									//applicable_trmt_types_arr[k] = applicable_trmt_types[k];
								}
							}
						}
				//  }
			
			}
		}
		else{ //Other than Bridge trmt
			 var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=ChkAllsurface&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_surface = localTrimString(xmlHttp.responseText);
			if (retVal_surface=="*A"){
				return_surface_alert = "Y";
			}//end


			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			params = "func_mode=ChkOutComeTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_outcome = trimString(xmlHttp.responseText); 
			retVal_outcome = localTrimString(retVal_outcome); 

			if(retVal_outcome.length > 1){
				var retVal_outcome_arr = retVal_outcome.split("~");
					for(var j=0;j<retVal_outcome_arr.length-1;j++){
					var code_desc_arr = retVal_outcome_arr[j].split("##");
					var trmt_type = code_desc_arr[0];
					var trmt_outcome = code_desc_arr[1];
					var denture_removable = code_desc_arr[2];
					//Added by Sharon Crasta on 3/23/2010 for IN019944
					//We are considering trmt_outcome as "S", when it is null.
					if(trmt_outcome == "" || trmt_outcome == "null" || trmt_outcome == null || trmt_outcome == "undefined" || trmt_outcome == undefined) {
						trmt_outcome = "S";
					}
					//End
					if(trmt_outcome=="F" || (trmt_outcome=="" || trmt_outcome=="null" || trmt_outcome==null) || trmt_outcome=="undefined" || trmt_outcome==undefined){
								if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined"){
									for(k=0;k<applicable_trmt_types.length;k++){
										if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
										//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}		
								}
						//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
						//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
							else if((dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined") && dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined"){
							   for(k=0;k<applicable_trmt_types.length;k++){
									if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
									//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}
							} //End
						else{
							if(return_surface_alert=="Y"){
								for(k=0;k<applicable_trmt_types.length;k++){
									if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO" || applicable_trmt_types[k] == "DENTURE"){ //Denture is added by Sridevi Joshi on 2/24/2010 for IN010871(SRR20056-CRF-0478)
									//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											
									}
								}
							}
							else{
								for(k=0;k<applicable_trmt_types.length;k++){
									//if(applicable_trmt_types_arr[k] != "EXTRACT" && applicable_trmt_types_arr[k] != "TOOTHTM" && applicable_trmt_types_arr[k] != "ORTHO"){

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
												if(code_desc_arr[0] == "PARERTH"){ //Added by Sridevi Joshi on 3/11/2010 for IN019961
													if(applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){ //Denture condition is added by Sridevi Joshi on 2/24/2010 for IN010871(SRR20056-CRF-0478)
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
													else{
														applicable_trmt_types_arr[k] = "";
													}
												}
												else{
													if(applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT" || applicable_trmt_types[k] == "DENTURE"){ //Denture condition is added by Sridevi Joshi on 2/24/2010 for IN010871(SRR20056-CRF-0478)
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
												}
											}
											else{
												if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}
											}
										}
									}
									else{
										if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}
							}
						}
					}else{
						 if(denture_removable=="Y"){
								for(k=0;k<applicable_trmt_types.length;k++){
									if(applicable_trmt_types[k] == "DENTURE" ){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}
							}else{
								if(trmt_type=="EXTRACT" || trmt_type =="IMPLANT"){
									for(k=0;k<applicable_trmt_types.length;k++){
										if( applicable_trmt_types[k] != "BRIDGE" && applicable_trmt_types[k] != "ORTHO"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}
								else if(trmt_type=="MAXILLA" || trmt_type=="ORTHO"){ //Added by Sridevi Joshi on 3/5/2010 for IN10871(CRF-478)

									if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined") && (document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" || document.getElementById(root_layer) == undefined || document.getElementById(root_layer) == "undefined")){
										for(y=0;y<applicable_trmt_types.length;y++){
											if(applicable_trmt_types[y] == "DENTURE"){
												applicable_trmt_types_arr[y] = applicable_trmt_types[y];
											}
										}
									}
								}
								//Added by Sharon Crasta on 3/3/2010 for SRR20056-CRF-0475(IN010868)
								else if(trmt_type == "BRIDGE"){
									for(var z = 0;z < applicable_trmt_types.length; z++){
										if(applicable_trmt_types[z] != "BRIDGE"){
											applicable_trmt_types_arr[z] = applicable_trmt_types[z];
										}
									}
								}//End
							}
						}
					}
			}else{
					if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined"){
					for(k=0;k<applicable_trmt_types.length;k++){
						if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
						//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
							applicable_trmt_types_arr[k] = applicable_trmt_types[k];
						}
					}		
				}
				else{
					if(return_surface_alert=="Y"){
						for(k=0;k<applicable_trmt_types.length;k++){
							if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
								applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									
							}
						}
					}
					else{
						for(k=0;k<applicable_trmt_types.length;k++){
							//if(applicable_trmt_types_arr[k] != "EXTRACT" && applicable_trmt_types_arr[k] != "TOOTHTM" && applicable_trmt_types_arr[k] != "ORTHO"){

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
										if(code_desc_arr[0] == "PARERTH"){ //Added by Sridevi Joshi on 3/11/2010 for IN019961
											if(applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){ //Denture condition is added by Sridevi Joshi on 3/2/2010 for IN010871(SRR20056-CRF-0478) to get the menu on range(one tooth Extracted and another impacted(cond))
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
											else{
												applicable_trmt_types_arr[k] = "";
											}
										}
										else{
											if(applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT" || applicable_trmt_types[k] == "DENTURE"){ //Denture condition is added by Sridevi Joshi on 3/2/2010 for IN010871(SRR20056-CRF-0478) to get the menu on range(one tooth Extracted and another impacted(cond))
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}
									}
									else{
										if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}
							}
							else{
								if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT" ||		applicable_trmt_types[k] == "IMPACT"){
									applicable_trmt_types_arr[k] = applicable_trmt_types[k];
								}
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

		var applicable_trmt_types_temp = applicable_trmt_types;//Added by Sridevi Joshi on 3/12/2010 for IN019934 only for Extraction case to get the Implant in the menu on Extraction failure--->Extraction Success

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		params = "func_mode=ChkOutComeTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;

		
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_outcome = trimString(xmlHttp.responseText); 
		retVal_outcome = localTrimString(retVal_outcome); 
		if(retVal_outcome.length > 1){
			var retVal_outcome_arr = retVal_outcome.split("~");
				for(var j=0;j<retVal_outcome_arr.length-1;j++){
					var code_desc_arr = retVal_outcome_arr[j].split("##");
					var trmt_type = code_desc_arr[0];
					var trmt_outcome = code_desc_arr[1];
						if(trmt_outcome!="F"){
							if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined"){
								for(k=0;k<applicable_trmt_types.length;k++){
										//if (trmt_type=="TOOTHTM" ){//if TOOTHTM is S ,should not populate on menu
										if (trmt_type=="TOOTHTM" && trmt_outcome=="S"){//if TOOTHTM is S ,should not populate on menu
											if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "ORTHO"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}else{
											if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}
									}		
							}
						//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0442(IN010838)
						//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
						else if((dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined") && dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined"){
									
						  for(k=0;k<applicable_trmt_types.length;k++){
									if (trmt_type=="TOOTHTM"){//if TOOTHTM is S ,should not populate on menu
										if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "ORTHO"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}else{
										if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}		
						} //End
						else{
							for(k=0;k<applicable_trmt_types.length;k++){
								//Commented by Sridevi Joshi on 3/2/2010
								/*var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=ChkOutComeTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_outcome = trimString(xmlHttp.responseText); 
								retVal_outcome = localTrimString(retVal_outcome); 

								if(retVal_outcome.length > 1){
									var retVal_outcome_arr = retVal_outcome.split("~");
										for(var m=0;m<retVal_outcome_arr.length-1;m++){
											var code_desc_arr = retVal_outcome_arr[m].split("##");
											var trmt_type = code_desc_arr[0];
											var trmt_outcome = code_desc_arr[1];
										}
								}*/
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
										var parerth_YN = "N"; //Added by Sridevi Joshi on 4/1/2010 for IN020441--for IMPACTION cond-->PARERTH-->IMPACTION cond-->IMPACTION trmt
										var retVal_arr = retVal.split("~");
										for(m=0;m<retVal_arr.length-1;m++){
											var code_desc_arr = retVal_arr[m].split("##");
											if(tooth_no == '1' || tooth_no == '16' || tooth_no == '17' || tooth_no == '32'){
												if(code_desc_arr[0] == "PARERTH"){ //Added by Sridevi Joshi on 3/11/2010 for IN019961
													if(trmt_type =="DENTURE"){
														if(applicable_trmt_types[k] == "BRIDGE"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
														else{
															 applicable_trmt_types_arr[k] = "";
														 }
													}
													else{
														if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
													}
													parerth_YN = "Y"; //Added by Sridevi Joshi on 4/1/2010 for IN020441--for IMPACTION cond-->PARERTH-->IMPACTION cond-->IMPACTION trmt
												}
												else{
													if(parerth_YN == "Y"){//Added by Sridevi Joshi on 4/1/2010 for IN020441--for IMPACTION cond-->PARERTH-->IMPACTION cond-->IMPACTION trmt
														if(trmt_type =="DENTURE"){
															if(applicable_trmt_types[k] == "BRIDGE"){
																	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}
															else{
																 applicable_trmt_types_arr[k] = "";
															 }
														}
														else{
															if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}
														}
													}
													else{
														if(trmt_type =="DENTURE"){
															if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
																	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}
															else{
																 applicable_trmt_types_arr[k] = "";
															 }
														}
														else{
															if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}
														}
													}
												}
											}
											else if(((code_desc_arr[0] == "UNERTH" && code_desc_arr[5] != "Z") || (code_desc_arr[0] == "PARERTH" && code_desc_arr[5] != "Z") || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){
												if(code_desc_arr[0] == "PARERTH"){ //Added by Sridevi Joshi on 3/11/2010 for IN019961
													if(trmt_type =="IMPACT" ){
														if(applicable_trmt_types[k] == "IMPLANT"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
														else{
															 applicable_trmt_types_arr[k] = "";
														 }
													
													}else if (trmt_type =="DENTURE"){
														if(applicable_trmt_types[k] == "BRIDGE"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
														else{
															 applicable_trmt_types_arr[k] = "";
														 }
													}else{
														if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
													}

													parerth_YN = "Y"; //Added by Sridevi Joshi on 4/1/2010 for IN020441--for IMPACTION cond-->PARERTH-->IMPACTION cond-->IMPACTION trmt
												}
												else{
													if(parerth_YN == "Y"){//Added by Sridevi Joshi on 4/1/2010 for IN020441--for IMPACTION cond-->PARERTH-->IMPACTION cond-->IMPACTION trmt
														if(trmt_type =="IMPACT" ){
															if(applicable_trmt_types[k] == "IMPLANT"){
																	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}
															else{
																 applicable_trmt_types_arr[k] = "";
															 }
														
														}else if (trmt_type =="DENTURE"){
															if(applicable_trmt_types[k] == "BRIDGE"){
																	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}
															else{
																 applicable_trmt_types_arr[k] = "";
															 }
														}else{
															if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}
														}
													}
													else{
														if(trmt_type =="IMPACT" ){
															if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT"){
																	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}
															else{
																 applicable_trmt_types_arr[k] = "";
															 }
														
														}else if (trmt_type =="DENTURE"){
															if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
																	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}
															else{
																 applicable_trmt_types_arr[k] = "";
															 }
														}else{
															if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}
														}
													}
												}
											}
											else{
												if(parerth_YN == "Y"){//Added by Sridevi Joshi on 4/1/2010 for IN020441--for IMPACTION cond-->PARERTH-->IMPACTION cond-->IMPACTION trmt
													if(trmt_type =="DENTURE" ){//Added by Sridevi Joshi on 2/26/2010 for IN010871(SRR20056-CRF-0478)
														if(applicable_trmt_types[k] == "BRIDGE"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}else{
														 applicable_trmt_types_arr[k] = "";
														}
													 }
													 else if(trmt_type =="IMPLANT" ){//Added by Sridevi Joshi on 2/26/2010 for IN010871(SRR20056-CRF-0478)
														if(applicable_trmt_types[k] == "BRIDGE"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}else{
															 applicable_trmt_types_arr[k] = "";
														}
													 }
													 else if (trmt_type =="TOOTHTM"){
														if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" ) && document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" ){//Addded by Sridevi Joshi on 3/30/2010 for IN020375
															if(applicable_trmt_types[k] == "EXTRACT"){
																	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}else{
																	applicable_trmt_types_arr[k]="";
															}
														}
														else{
															if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM"){
																	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}else{
																	applicable_trmt_types_arr[k]="";
															}
														}
														
													}
													else{
														if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){//IMPACT is added by Sridevi Joshi on 3/2/2010 for IN010871(SRR20056-CRF-0478)
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}else{
															 applicable_trmt_types_arr[k] = "";
														}
													}
												}
												else{
													if(trmt_type =="DENTURE" ){//Added by Sridevi Joshi on 2/26/2010 for IN010871(SRR20056-CRF-0478)
														if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}else{
														 applicable_trmt_types_arr[k] = "";
														}
													 }
													 else if(trmt_type =="IMPLANT" ){//Added by Sridevi Joshi on 2/26/2010 for IN010871(SRR20056-CRF-0478)
														if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}else{
															 applicable_trmt_types_arr[k] = "";
														}
													 }
													 else if (trmt_type =="TOOTHTM"){
														if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" ) && document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" ){//Addded by Sridevi Joshi on 3/30/2010 for IN020375
															if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "DENTURE"){
																	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}else{
																	applicable_trmt_types_arr[k]="";
															}
														}
														else{
															if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM"){
																	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}else{
																	applicable_trmt_types_arr[k]="";
															}
														}
														
													}
													else{
														if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){//IMPACT is added by Sridevi Joshi on 3/2/2010 for IN010871(SRR20056-CRF-0478)
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}else{
															 applicable_trmt_types_arr[k] = "";
														}
													}
												}
											}
										}
									}
									else{
										if(tooth_no == '1' || tooth_no == '16' || tooth_no == '17' || tooth_no == '32'){
											if (trmt_type =="IMPACT" ){
												if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}else{
													 applicable_trmt_types_arr[k] = "";
												 }

											}else if (trmt_type =="DENTURE"){
												if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}
												else{
													 applicable_trmt_types_arr[k] = "";
												 }
											}
											else{
												if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}
											}
										}
										else{
											 if (trmt_type =="IMPLANT" ){
												 if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												 }else{
													 applicable_trmt_types_arr[k] = "";
												 }
											 } 
											 else if(trmt_type =="DENTURE" ){//Added by Sridevi Joshi on 2/26/2010 for IN010871(SRR20056-CRF-0478)
												if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}else{
													 applicable_trmt_types_arr[k] = "";
												 }
											 }
											 else if (trmt_type =="EXTRACT" ){//Added by Sridevi Joshi on 3/12/2010 for IN019934
												 if(applicable_trmt_types_temp[k] == "DENTURE" || applicable_trmt_types_temp[k] == "BRIDGE" || applicable_trmt_types_temp[k] == "IMPLANT"){ 
													applicable_trmt_types_arr[k] = applicable_trmt_types_temp[k];
												 }
												 else{
													 applicable_trmt_types_arr[k] = "";
												 }
											 } 
											 else if (trmt_type == "BRIDGE" ){//Added by Sharon Crasta on 3/2/2010 for IN010868(SRR20056-CRF-0475)
											 
												 if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO" ){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												 } 
												 else if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];

												 }
											 }
											 else{
												if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}
											 }
										}
									}
							}
						}
					}else{

						for(k=0;k<applicable_trmt_types.length;k++){
								if(trmt_type=="EXTRACT" ){
									if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "TOOTHTM"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
									/*else{
											applicable_trmt_types_arr[k]="";
									}*/
								}
								else if (trmt_type =="ORTHO"){
									if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}else{
											applicable_trmt_types_arr[k]="";
									}
								
								}
								else if (trmt_type =="TOOTHTM" ){
									if((dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" ) && dentalChartFormObj.document.getElementById(root_layer) == null || dentalChartFormObj.document.getElementById(root_layer) == "null" ){ //Addded by Sridevi Joshi on 3/12/2010
										if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "DENTURE"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}else{
												applicable_trmt_types_arr[k]="";
										}
									}
									else{
										if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}else{
												applicable_trmt_types_arr[k]="";
										}
									}
								
								}
								else if(trmt_type=="IMPACT"){//added by parul on 11/03/2010 for IN19552
									if(applicable_trmt_types[k] == "IMPACT" || applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}
								/* commented by Sridevi Joshi on 3/5/2010 for EXtract failure-->Denture failure was not able to record Extract and toothtm
								else if(trmt_type =="DENTURE" ){//Added by Sridevi Joshi on 2/26/2010 for IN010871(SRR20056-CRF-0478)
									if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){//IMPACT is added by Sridevi Joshi on 3/2/2010 for IN010871(SRR20056-CRF-0478)
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
									//Commented by Sharon Crasta on 3/4/2010 for SRR20056-CRF-0475
									//Bridge(F)->Extract(F)->Denture(F) on Recording Extraction again getting not applicable message
									else{
										 applicable_trmt_types_arr[k] = "";
									 } 
								}*/
								else{
									if (trmt_type == "BRIDGE" ){//Added by Sharon Crasta on 3/2/2010 for IN010868(SRR20056-CRF-0475)
										 if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO" ){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										 } 
										 else if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];

										 }
									 }	//End
								  else if(tooth_no == '1' || tooth_no == '16' || tooth_no == '17' || tooth_no == '32'){
										if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
									//Commented and Added by Sharon Crasta on 3/3/2010 for SRR20056-CRF-0475(IN010868)
									//On Bridge Failure was getting Denture and Implant on the Abutment Tooth.
									//Copied from OHDentalChart.js
									/*else{
										if(trmt_type=="IMPLANT" && trmt_outcome != "F"){
											if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}
										else{
											if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}
									} */
									
									else{
										if((dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" ) && dentalChartFormObj.document.getElementById(root_layer) == null || dentalChartFormObj.document.getElementById(root_layer) == "null" ){
										   if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}else{
											if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}									
										}									
									}//End
								}
							}
						}
						if(applicable_trmt_types_arr!=""){
							applicable_trmt_types=applicable_trmt_types_arr;
						}
				}
		}else{
			if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined"){
				for(k=0;k<applicable_trmt_types.length;k++){
					if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
					//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
						applicable_trmt_types_arr[k] = applicable_trmt_types[k];
					}
				}		
			}
			//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0442(IN010838)
			//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
			else if((dentalChartFormObj.document.getElementById(tooth_layer) == null || dentalChartFormObj.document.getElementById(tooth_layer) == "null" || dentalChartFormObj.document.getElementById(tooth_layer) == undefined || dentalChartFormObj.document.getElementById(tooth_layer) == "undefined") && dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined"){
						
			   for(k=0;k<applicable_trmt_types.length;k++){
					if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
					//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
						applicable_trmt_types_arr[k] = applicable_trmt_types[k];
					}
				}
			} //End
			else{
				for(k=0;k<applicable_trmt_types.length;k++){
					//if(applicable_trmt_types_arr[k] != "EXTRACT" && applicable_trmt_types_arr[k] != "TOOTHTM" && applicable_trmt_types_arr[k] != "ORTHO"){
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
						var parerth_YN = "N"; //Added by Sridevi Joshi on 4/1/2010 for IN020441-- not to get denture menu if Impaction--->Parerth---> impaction is recorded
						var retVal_arr = retVal.split("~");
						for(m=0;m<retVal_arr.length-1;m++){
							var code_desc_arr = retVal_arr[m].split("##");
							/* Commented to add status != "Z" for unerruted tooth when retained deciduous tooth is recorded */
							//if((code_desc_arr[0] == "UNERTH" || code_desc_arr[0] == "PARERTH" || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){

							if(tooth_no == '1' || tooth_no == '16' || tooth_no == '17' || tooth_no == '32'){
								if(code_desc_arr[0] == "PARERTH"){
									if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
									else{
										applicable_trmt_types_arr[k] = "";
									}
									parerth_YN = "Y";//Added by Sridevi Joshi on 4/1/2010 for IN020441-- not to get denture menu if Impaction--->Parerth---> impaction is recorded
								}
								else{
									if(parerth_YN == "Y"){//Added by Sridevi Joshi on 4/1/2010 for IN020441-- not to get denture menu if Impaction--->Parerth---> impaction is recorded
										if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
									else{
										if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}
								
							}
							//else if(((code_desc_arr[0] == "UNERTH" && code_desc_arr[5] != "Z") || (code_desc_arr[0] == "PARERTH" && code_desc_arr[5] != "Z") || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){
							else if(((code_desc_arr[0] == "UNERTH") || (code_desc_arr[0] == "PARERTH") || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){//Removed condition for status 'Z' by sridevi Joshi on 5/18/2010 for IN021474
								if(code_desc_arr[0] == "PARERTH"){
									if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
									else{
										applicable_trmt_types_arr[k] = "";
									}
									parerth_YN = "Y";//Added by Sridevi Joshi on 4/1/2010 for IN020441(for Retained deciduous case)
								}
								else{
									if(parerth_YN == "Y"){//Added by Sridevi Joshi on 4/1/2010 for IN020441(for Retained deciduous case)
										if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
									else{
										if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}
							}
							else{
								if(parerth_YN == "Y"){//Added by Sridevi Joshi on 4/1/2010 for IN020441(for Retained deciduous case)
									if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}
								else{
									if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}
							}
						}
					}
					else{
						if(tooth_no == '1' || tooth_no == '16' || tooth_no == '17' || tooth_no == '32'){
							if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
								applicable_trmt_types_arr[k] = applicable_trmt_types[k];
							}
						}
						else{
							if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
								applicable_trmt_types_arr[k] = applicable_trmt_types[k];
							}
						}
					}
				}
			}	
		}
	}
	else{ // for site other than Tooth and THRNG
		for(k=0;k<applicable_trmt_types.length;k++){
			applicable_trmt_types_arr[k] = applicable_trmt_types[k];
		}
	}

	applicable_trmt_types = applicable_trmt_types_arr

	return applicable_trmt_types;
}

function resultTrmtMenuOptions(applicable_trmt_types,applicable_trmt_desc,tooth_no,mixed_dentition_YN,permanent_deciduous_flag,arch_quad,site){
	temp_array = new Array();
	temp_array_desc = new Array();
	//Added by Sharon Crasta on 2/4/2010 for SRR20056-CRF-0498(IN010982) to filter Denture when MAlOCLN is recorded on the Arch
	//for(i=0; i<applicable_trmt_types.length; i++ ){
		
		var patient_id= document.forms[0].patient_id.value;
		var chart_num= document.forms[0].chart_num.value;
		var oh_chart_level= document.forms[0].oh_chart_level.value;
		var other_chart_facility_id= document.forms[0].other_chart_facility_id.value;
		var dentalChartFormObj = "";
		if(parent.parent.conditionDentalChartDetails == null || parent.parent.conditionDentalChartDetails == "null"){
			dentalChartFormObj = parent.trmtDentalChartDetails;
		}
		else{
			dentalChartFormObj = parent.parent.conditionDentalChartDetails;
		}

		if(site == "ARCH"){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params_quad_arch = "func_mode=allConditionsRecordedForArchQuad&arch_quad="+arch_quad+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_quad_arch,false);
			xmlHttp.send(xmlDoc);
			var retVal_quad_arch = trimString(xmlHttp.responseText); 
			retVal_quad_arch = localTrimString(retVal_quad_arch);
			if(retVal_quad_arch.length > 1){
				var retVal_quad_arch_arr = retVal_quad_arch.split("~");
				for(m = 0; m < retVal_quad_arch_arr.length-1; m++){
					var code_desc_quad_arch_arr = retVal_quad_arch_arr[m].split("##");
					temp_array = new Array();
					temp_array_desc = new Array();
					for(i=0; i<applicable_trmt_types.length; i++ ){
					
					if(mixed_dentition_YN == "Y"){ // For Mixed Dentition Case
						if(permanent_deciduous_flag == "D"){ // For Mixed Dentition - Deciduous Chart
							if(code_desc_quad_arch_arr[m] == "MALOCLN" && applicable_trmt_types[i] != "DENTURE"){
								if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT"){
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
								}
							}
							else if(code_desc_quad_arch_arr[0] != "MALOCLN"){
								if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "DENTURE"){//Denture condition is added by Sridevi Joshi on 4/26/2010 for IN020926
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
								}
							}
						}
						else{ //For Mixed Dentition - Permanent Chart
							if(code_desc_quad_arch_arr[m] == "MALOCLN" && applicable_trmt_types[i] != "DENTURE"){
								if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT"){
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
								}
							}
							else if(code_desc_quad_arch_arr[0] != "MALOCLN"){
							  if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "DENTURE"){//Denture condition is added by Sridevi Joshi on 4/26/2010 for IN020926
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
								}
							}
						}
					}
					else{ // Other than Mixed Dentition case
						if(permanent_deciduous_flag == "D"){ // For Deciduous Chart
							if(code_desc_quad_arch_arr[m] == "MALOCLN" && applicable_trmt_types[i] != "DENTURE"){
								if(applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "BRIDGE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "ORTHO"){
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
										
								}
							}
							else if(code_desc_quad_arch_arr[0] != "MALOCLN"){
								if(applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "BRIDGE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "ORTHO"){
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
										
								}
							}
						}
						else if(permanent_deciduous_flag == "P"){ //For Permanent Chart
								if(code_desc_quad_arch_arr[0] == "MALOCLN" && applicable_trmt_types[i] != "DENTURE"){
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
								}
								else if(code_desc_quad_arch_arr[0] != "MALOCLN"){
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
								}
							}
						}
					}
					applicable_trmt_types = temp_array;
					applicable_trmt_desc = temp_array_desc;
				}
			}
			else{
				for(i=0; i<applicable_trmt_types.length; i++ ){
				  if(mixed_dentition_YN == "Y"){ // For Mixed Dentition Case
					if(permanent_deciduous_flag == "D"){ // For Mixed Dentition - Deciduous Chart
							if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "DENTURE"){//Denture condition is added by Sridevi Joshi on 4/26/2010 for IN020926
								temp_array[i] = applicable_trmt_types[i];
								temp_array_desc[i] = applicable_trmt_desc[i];
							}
						}
						else{ //For Mixed Dentition - Permanent Chart
							if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "DENTURE"){//Denture condition is added by Sridevi Joshi on 4/26/2010 for IN020926
								temp_array[i] = applicable_trmt_types[i];
								temp_array_desc[i] = applicable_trmt_desc[i];
							}
						}
					}
					else{ // Other than Mixed Dentition case
						if(permanent_deciduous_flag == "D"){ // For Deciduous Chart
							if(applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "BRIDGE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "ORTHO"){
								temp_array[i] = applicable_trmt_types[i];
								temp_array_desc[i] = applicable_trmt_desc[i];
									
							}
						}
						else if(permanent_deciduous_flag == "P"){ //For Permanent Chart
							temp_array[i] = applicable_trmt_types[i];
							temp_array_desc[i] = applicable_trmt_desc[i];
						}
					}
				}
			}
		} //End
		else{
			//Added by Sharon Crasta on 3/2/2010 for SRR20056-CRF-0475
			//Menu should be displayed once the pontic is cut or when the Bridge is marked as Failure.
			var pontic_tooth = new Array();
			var pontic_tooth_split_values = new Array();

			var flag_for_bridge = "";
			var flag_for_bridge_thrng_pontic = "";
			var flag_for_bridge_thrng_abutment = "";
			var return_surface_alert = "N";

			var abutment_tooth_values = new Array();
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
			xmlHttp.send(xmlDoc);
			var retVal_max_chart_line_num = trimString(xmlHttp.responseText); 
			retVal_max_chart_line_num = localTrimString(retVal_max_chart_line_num);

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params_bridge_extract = "func_mode=getOutcomeForExtraction&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
			xmlHttp.send(xmlDoc);
			var retVal_outcome_bridge = trimString(xmlHttp.responseText); 
			retVal_outcome_bridge = localTrimString(retVal_outcome_bridge);
			if(retVal_outcome_bridge == "" || retVal_outcome_bridge == "null" || retVal_outcome_bridge == null || retVal_outcome_bridge == "undefined" || retVal_outcome_bridge == undefined){
				retVal_outcome_bridge = "S";
			}
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params_bridge_extract = "func_mode=getTrmtCatCode&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
			xmlHttp.send(xmlDoc);
			var retVal_category_type = trimString(xmlHttp.responseText); 
			retVal_category_type = localTrimString(retVal_category_type);
			pontic_tooth = retVal_category_type.split(",") ;
			var j =0;

			for (var i = 0; i < pontic_tooth.length;i++)
			{
				pontic_tooth_split_values[i] = pontic_tooth[i].substring((pontic_tooth[i].lastIndexOf("$")+1),pontic_tooth[i].length) ;
			}
			var bridge_length =  pontic_tooth_split_values.length-1;
			/*if(site == "THRNG"){ // Tooth Range
				var nos_array = thrng_nos_ref.split(",");
				for(var k = 0; k < nos_array.length;k++){
					 if((pontic_tooth_split_values[0] == nos_array[k]) || (pontic_tooth_split_values[bridge_length] == nos_array[k])) 
					 { 
						flag_for_bridge_thrng_abutment = "A";
						break;
					 }
					 else{
						flag_for_bridge_thrng_pontic = "P";
					 }
					 
				}
				 flag_for_bridge_thrng = flag_for_bridge_thrng_abutment+"##"+flag_for_bridge_thrng_pontic;
			}
			else{*/
				for(var j = 0; j < pontic_tooth_split_values.length;j++){
					if((pontic_tooth_split_values[j] == tooth_no) && (j == 0 || j == pontic_tooth_split_values.length-1)) { 
						flag_for_bridge = "A";
						break;
					}else{
						flag_for_bridge = "P";
						 }		    
					} 
				//}
			var pontic_tooth_no = "";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params_pontic = "func_mode=getPonticValuesForMenu&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic,false);
			xmlHttp.send(xmlDoc);
			var retVal_pontic_arr = trimString(xmlHttp.responseText); 
			retVal_pontic_arr = localTrimString(retVal_pontic_arr);
			var retVal_pontic = retVal_pontic_arr.split("$$");
			for(var j =0; j < retVal_pontic.length; j++){
				if(retVal_pontic[j] == tooth_no){
					pontic_tooth_no = retVal_pontic[j];
					break;
				}
			}
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=ChkAllsurfaceForMenu&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_surface = localTrimString(xmlHttp.responseText);
			if (retVal_surface=="*A"){
				return_surface_alert = "Y";
			}
			var root_layer = "rootLayer"+tooth_no;
			var tooth_layer = "toothLayer"+tooth_no;
			
			//End
			for(i=0; i<applicable_trmt_types.length; i++ ){
				if(mixed_dentition_YN == "Y"){ // For Mixed Dentition Case
					if(permanent_deciduous_flag == "D"){ // For Mixed Dentition - Deciduous Chart
						if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "BRIDGE" && applicable_trmt_types[i] != "DENTURE"){ //Bridge is applicable only for permanent chart. Added by Sharon Crasta on 3/2/2010 for SRR20056-CRF-0475----Denture condition is added by Sridevi Jsohi on 4/26/2010 for IN020926
							temp_array[i] = applicable_trmt_types[i];
							temp_array_desc[i] = applicable_trmt_desc[i];
						}
					}
					else{ //For Mixed Dentition - Permanent Chart
						if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "BRIDGE" && applicable_trmt_types[i] != "DENTURE"){ //Bridge is applicable only for permanent chart. Added by Sharon Crasta on 3/2/2010 for SRR20056-CRF-0475----Denture condition is added by Sridevi Jsohi on 4/26/2010 for IN020926
							temp_array[i] = applicable_trmt_types[i];
							temp_array_desc[i] = applicable_trmt_desc[i];
						}
					}
				}
				else{ // Other than Mixed Dentition case
					if(permanent_deciduous_flag == "D"){ // For Deciduous Chart
						if(applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "BRIDGE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "ORTHO" && applicable_trmt_types[i] != "DENTURE"){//----Denture condition is added by Sridevi Jsohi on 4/26/2010 for IN020926
							temp_array[i] = applicable_trmt_types[i];
							temp_array_desc[i] = applicable_trmt_desc[i];
								
						}
					}
					else if(permanent_deciduous_flag == "P"){ //For Permanent Chart
						//Added by Sharon Crasta on 3/2/2010 for SRR20056-CRF-0475
						// Only if the pontic is cut, then the menu should be displayed for it.

						if(retVal_category_type.length != 0){ //Bridge recording done.
							if(flag_for_bridge == "A"){
								//Written this code so that if Bridge is recorded in Trmt Tab, then not showing Extraction in the menu for External Trmt Tab
							
								if((retVal_outcome_bridge != "F" && dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" && dentalChartFormObj.document.getElementById(tooth_layer) != null && dentalChartFormObj.document.getElementById(tooth_layer) != "null" && dentalChartFormObj.document.getElementById(tooth_layer) != undefined && dentalChartFormObj.document.getElementById(tooth_layer) != "undefined")  || return_surface_alert == "Y") {
									if(applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" &&  applicable_trmt_types[i] != "EXTRACT" ){
									  temp_array[i] = applicable_trmt_types[i];
									  temp_array_desc[i] = applicable_trmt_desc[i];
									}
								 }//End
								 else if(dentalChartFormObj.document.getElementById(root_layer) != null && dentalChartFormObj.document.getElementById(root_layer) != "null" && dentalChartFormObj.document.getElementById(root_layer) != undefined && dentalChartFormObj.document.getElementById(root_layer) != "undefined" ){
								   if(applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT"){
									  temp_array[i] = applicable_trmt_types[i];
									  temp_array_desc[i] = applicable_trmt_desc[i];
									}
								}
								else if(dentalChartFormObj.document.getElementById(root_layer) == null || dentalChartFormObj.document.getElementById(root_layer) == "null" || dentalChartFormObj.document.getElementById(root_layer) == undefined || dentalChartFormObj.document.getElementById(root_layer) == "undefined" ){
									//Commented for the 3rd molar. not getting impaction once bridge recorded and tooth no 1 extracted.
								  // if(applicable_trmt_types[i] != "ORTHO" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT"){
								  // if(applicable_trmt_types[i] != "ORTHO" && applicable_trmt_types[i] != "IMPLANT"){
								   if(applicable_trmt_types[i] != "ORTHO" ){
									  temp_array[i] = applicable_trmt_types[i];
									  temp_array_desc[i] = applicable_trmt_desc[i];
									}
								} 
							}else{
								
								/*if(pontic_tooth_no == tooth_no){  // Cut pontic
									if(applicable_trmt_types[i] != "ORTHO"){
											temp_array[i] = applicable_trmt_types[i];
											temp_array_desc[i] = applicable_trmt_desc[i];
										}
									} 
									else if(flag_for_bridge == "P"  && (pontic_tooth_no == tooth_no)) {
									if (applicable_trmt_types[i] != "ORTHO") {
										  temp_array[i] = applicable_trmt_types[i];
										  temp_array_desc[i] = applicable_trmt_desc[i];
										}
									}

									else if(retVal_outcome_bridge != "F" &&  flag_for_bridge == "P" && (pontic_tooth_no != tooth_no)) {
										if (applicable_trmt_types[i] != "ORTHO" && applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "IMPLANT") {
										  temp_array[i] = applicable_trmt_types[i];
										  temp_array_desc[i] = applicable_trmt_desc[i];
										}
									}
										
									else if(retVal_outcome_bridge == "F" &&  flag_for_bridge == "P" && (applicable_trmt_types[i] == "DENTURE" || applicable_trmt_types[i] == "IMPACT" || applicable_trmt_types[i] == "IMPLANT")){
										  temp_array[i] = applicable_trmt_types[i];
										  temp_array_desc[i] = applicable_trmt_desc[i];
						
										}
									else if(applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "ORTHO"){
										  temp_array[i] = applicable_trmt_types[i];
										  temp_array_desc[i] = applicable_trmt_desc[i];
									}
									else if(retVal_category_type.length == 0){	// Not Bridge
											  temp_array[i] = applicable_trmt_types[i];
											  temp_array_desc[i] = applicable_trmt_desc[i];
										
										}
									else if (applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT"){
										  temp_array[i] = applicable_trmt_types[i];
										  temp_array_desc[i] = applicable_trmt_desc[i];
									} */
									if(pontic_tooth_no == tooth_no){  // Cut pontic
										if(applicable_trmt_types[i] != "ORTHO" && applicable_trmt_types[i] != "EXTRACT" && applicable_trmt_types[i] != "TOOTHTM"){
											
												temp_array[i] = applicable_trmt_types[i];
												temp_array_desc[i] = applicable_trmt_desc[i];
											}
										} 
										
									else if(flag_for_bridge == "P"  && (pontic_tooth_no == tooth_no)) {
											//if (applicable_trmt_types[i] != "ORTHO" || applicable_trmt_types[i] == "DENTURE") {
											
											if (applicable_trmt_types[i] != "ORTHO") {
											  temp_array[i] = applicable_trmt_types[i];
											  temp_array_desc[i] = applicable_trmt_desc[i];
											}
										}
										//else if(flag_for_bridge_thrng.indexOf("A") != -1){
										
										else if(retVal_outcome_bridge != "F" &&  flag_for_bridge == "P" && (pontic_tooth_no != tooth_no)) {
											
											if (applicable_trmt_types[i] != "ORTHO" && applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "EXTRACT" && applicable_trmt_types[i] != "TOOTHTM") {
											  temp_array[i] = applicable_trmt_types[i];
											  temp_array_desc[i] = applicable_trmt_desc[i];
											}
										}
										
										else if(retVal_outcome_bridge == "F" &&  flag_for_bridge == "P" && applicable_trmt_types[i] != "EXTRACT" && applicable_trmt_types[i] != "TOOTHTM"  && (applicable_trmt_types[i] == "DENTURE" || applicable_trmt_types[i] == "IMPACT" || applicable_trmt_types[i] == "IMPLANT" || applicable_trmt_types[i] == "BRIDGE")) {
										
										  temp_array[i] = applicable_trmt_types[i];
										  temp_array_desc[i] = applicable_trmt_desc[i];		
										}
										else if(flag_for_bridge != "P" &&  applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "ORTHO"){
											
											  temp_array[i] = applicable_trmt_types[i];
											  temp_array_desc[i] = applicable_trmt_desc[i];
										}
										else if(retVal_category_type.length == 0){	// Not Bridge
											  temp_array[i] = applicable_trmt_types[i];
											  temp_array_desc[i] = applicable_trmt_desc[i];
										
										}
										else if (flag_for_bridge != "P" && applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT"){
											
										  temp_array[i] = applicable_trmt_types[i];
										  temp_array_desc[i] = applicable_trmt_desc[i];
									}
									
								}
						}else{  
						    temp_array[i] = applicable_trmt_types[i];
							temp_array_desc[i] = applicable_trmt_desc[i];
						}
						
					}
				}
			}
		}
		
	applicable_trmt_types = temp_array;
	applicable_trmt_desc = temp_array_desc;

	return applicable_trmt_types;
}

function hideToolTip(frame){
	if(frame == 'DentalChartTabSearch'){
		if(parent.frames[2].frames[1].frames[1] != null){
			parent.frames[2].frames[1].frames[1].document.getElementById("tooltiplayer").style.visibility = 'hidden';
		}
	}
	else{
		if(document.getElementById("tooltiplayer") != null){
			document.getElementById("tooltiplayer").style.visibility = 'hidden';
		}
	}
}

/*function hideSuperToolTip(frame){
	if(frame == 'DentalChartTabSearch'){
		if(parent.frames[2].frames[1].frames[1] != null){
			parent.frames[2].frames[1].frames[1].document.getElementById("tooltiplayer1").style.visibility = 'hidden';
		}
	}
	else{
		if(document.getElementById("tooltiplayer1") != null){
			document.getElementById("tooltiplayer1").style.visibility = 'hidden';
		}
	}
}*/

//This function is to hide submenu, if submenu looses focus. 
function hideMenuOnOutFocus(frame){
	//setTimeout("hideToolTip()", 1000);
	var e=window.event;
	if (!e.target){
		e.target=e.srcElement;
	}
	if(e.target)
	{	
		if(!(e.target.id=='menu_table' || e.target.id=='mouse' || e.target.id=='tooltiplayer' || e.target.id=='tooltiptable' || e.target.id=='tooltiprow' || e.target.id=='tooltiplink')){ //If taget.id is not equals to the menu table id(table linc)
			hideToolTip(frame)
		}
	}
}
//added by parul for CRF 701 on 23/09/2009
function getSurfaceLegendFromPage(obj){
	if(obj.value=="MAXFS"){
		 var formObj = document.forms[0];
			var surface_legend =getLabel("eOH.Parts.Label","OH");
			document.getElementById("surface_field").innerHTML ="<td><select name='oh_surface' id='oh_surface' onchange='populateSubParts(this);clearDentalcondition(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>&nbsp;<select name='oh_sub_parts' id='oh_sub_parts' onchange='clearDentalcondition(this);populateSelectedSubParts(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select></td>"	
            formObj.oh_surface.disabled=true;
            formObj.oh_sub_parts.disabled=true;
	}else{
			var surface_legend =getLabel("eOH.Surface.Label","OH");
			document.getElementById("surface_field").innerHTML ="<select name='oh_surface' id='oh_surface' onchange='populateCuspTip(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>"		
			}
		document.getElementById("change_surface").innerHTML = surface_legend;

	}
//added by parul for CRF 701 on 23/09/2009

function getSurfaceLegend(obj){
	if(obj.value=="MAXFS"){
		var surface_legend = getLabel("eOH.Parts.Label","OH");
		document.getElementById("surface_field").innerHTML ="<select name='oh_surface' id='oh_surface' onchange='populateSurfacesFromPage(this,oh_surface);countSurface();'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>"	
			
		//	document.getElementById("surface_field").innerHTML ="<td><select name='oh_surface' id='oh_surface' onchange='populateSubParts;countSurface();clearDentalcondition(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select>&nbsp;<select name='oh_sub_parts' id='oh_sub_parts' onchange='clearDentalcondition(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'></td>"	
	}else{
		var surface_legend =getLabel("eOH.Surface.Label","OH");
		document.getElementById("surface_field").innerHTML ="<select name='oh_surface' id='oh_surface' onchange='populateCuspTip(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>"	
		var surface_legend = getLabel("eOH.Surface.Label","OH");
		
		}
	document.getElementById("change_surface").innerHTML = surface_legend;

}

function populateSurfacesFromPage(obj,oh_surface){//added by parul for CRF 701 on 23/09/2009

    var formObj = document.forms[0];
	var dentalchartFormObj = parent.trmtDentalChartDetails;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var site_type_val = formObj.oh_site.value;
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var tooth_no_val = obj.value;
	var surface_applicable_yn = 'Y';
    var trmt_code="";

	if(formObj.header_tab.value!='C' ){
		trmt_code = formObj.oh_treatment.value;
	}

	clear_list(document.forms[0].oh_surface); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_surface.add(optSel);

	
	var retVal_applicable="";
	if(trmt_code != "" && trmt_code != "undefined" && trmt_code != undefined && trmt_code != null && trmt_code != "null"){//Added by Sridevi Joshi on 4/26/2010 for PE
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params_trmt = "trmt_code="+trmt_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkCrownApplicable&"+params_trmt,false);
		xmlHttp.send(xmlDoc);
		retVal_applicable = trimString(xmlHttp.responseText);
		retVal_applicable = localTrimString(retVal_applicable);
	}
	if(tooth_no_val=="MAXFS" || tooth_no_val=="E" || tooth_no_val=="I" ){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
	    var params = "area_val="+tooth_no_val;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateMaxilaSurfaces&"+params,false);
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
			 formObj.oh_surface.disabled = false;

		}
		else{
			document.getElementById("MandatorySurface").style.visibility = 'hidden';
		}
		populateSubParts(obj);
	}else{
		//Added by Sharon Crasta on 10/23/2009 for IN015637
		//When site_type is Mouth(Oral Cavity), the surface field should be disabled and the mandatory image should be hidden
		if(site_type_val == "MOUTH"){
			 formObj.oh_surface.disabled = true;
			 document.getElementById("MandatorySurface").style.visibility = 'hidden';
		}

		//added by parul on 21/01/2010 for CRF-422
		if (site_type_val=="CROWN"){
			if (retVal_applicable=="Y") {
				var retVal_surface=getLabel("eOH.AllSurfaces.Label","OH");
				document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" value=""><option value="">'+retVal_surface+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';
				formObj.surface_ref.value="All Surface";
				formObj.oh_surface.disabled = true;

			  }else{
				var surface_label=getLabel("eOH.DefaultSelect.Label","OH");
				document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" size=3 multiple  onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';

			  }
		}else{
			if(tooth_no_val == "" && site_type_val == "MAXFS"){//Added by Sridevi Joshi on 3/8/2010 for IN019736 to reset subparts and tooth no fields
				var select_label = getLabel("eOH.DefaultSelect.Label","OH");

				document.getElementById("surface_field").innerHTML ="<td><select name='oh_surface' id='oh_surface' onchange='populateSubParts(this);clearDentalcondition(this);'><option value=''>"+select_label+"</option></select>&nbsp;<select name='oh_sub_parts' id='oh_sub_parts' onchange='clearDentalcondition(this);populateSelectedSubParts(this);'><option value=''>"+select_label+"</option></select><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'></td>"	

				formObj.oh_sub_parts.value = "";
				formObj.oh_sub_parts.disabled = true;
			}
			else{
				formObj.oh_surface.disabled = true;
				document.getElementById("MandatorySurface").style.visibility = 'hidden';
			}
		}
	}
}

function populateSubParts(obj,maxila_parts){//added by parul for CRF 701 on 23/09/2009
    var formObj = document.forms[0];
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var site_type_val = formObj.oh_site.value;
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var tooth_no_val = obj.value;
	var dentalchartFormObj = parent.trmtDentalChartDetails;
	var tooth_layer = "toothLayer"+tooth_no_val;
	var root_layer = "rootLayer"+tooth_no_val;
	var surface_applicable_yn = 'Y';

	clear_list(document.forms[0].oh_sub_parts); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_sub_parts.add(optSel);
	var parts="";
	if (obj.value==""){
		parts=maxila_parts;
	}else{
		parts=obj.value;
	}	

   		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "parts="+parts;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSubParts&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);

		if(retVal.length>1){
			var retVal_arr = retVal.split("~");
			for(var i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				var element 	= document.createElement('OPTION') ;
				element.value 	= code_desc_arr[0];
				element.text 	= code_desc_arr[1] ;
				document.forms[0].oh_sub_parts.add(element);
			}
			 formObj.oh_sub_parts.disabled = false;// written by parul on 070109 
				if (formObj.called_from_viewchart_yn.value!="Y"){
					populateSelectedSubParts(obj,formObj.oh_sub_parts);
				}

		}else{
			
			if (formObj.called_from_viewchart_yn.value!="Y"){
					populateSelectedSubParts(obj,formObj.oh_sub_parts);
				}
			formObj.oh_sub_parts.disabled = true;
		}
	}

	function enableDisableSurfaceFromPage(obj){//added by parul for CRF 701 on 23/09/2009
		var formObj = document.forms[0];
		var oh_category = formObj.oh_category.value;
		if(obj.value != null ){
			if(obj.value == 'ROOT' || obj.value == 'CROWN'){
				//if condition added by parul for surface on 070109
					formObj.oh_surface.disabled = true;
					document.getElementById("MandatorySurface").style.visibility = 'visible';
			}else{
				document.forms[0].oh_surface.disabled = true;
			}
		}
	}

function populateSelectedSubParts(obj,maxila_parts,maxila_sub_parts,ref_tooth_no){
	var disply_tooth_no="";
	var formObj=document.forms[0].value;
	var oh_area_1=document.forms[0].oh_area.value;
	var oh_surface_1=document.forms[0].oh_surface.value;
	var oh_sub_parts_1=document.forms[0].oh_sub_parts.value;
//var oh_selected_sub_parts_1=document.forms[0].oh_selected_sub_parts.value;
	var tooth_numbering_system =document.forms[0].tooth_numbering_system.value;
	var mixed_dentition_YN =document.forms[0].mixed_dentition_YN.value;
	var permanent_deciduous_flag =document.forms[0].permanent_deciduous_flag.value;
	var oh_chart_level =document.forms[0].oh_chart_level.value;
	var other_chart_facility_id =document.forms[0].other_chart_facility_id.value;
	var patient_id =document.forms[0].patient_id.value;
	var chart_num =document.forms[0].chart_num.value;
	var RD_Normal_yn =document.forms[0].RD_Normal_yn.value;
	var ref_tooth_no = document.forms[0].ref_tooth_no.value
	var super_tooth_ref = document.forms[0].super_tooth_ref.value

	if (obj.value=="" || obj.value==null || obj.value=="null"){
		obj.value=maxila_sub_parts;
	}

	if(obj.value=="THAB" ||obj.value=="TNGAB" ||obj.value=="THGM" ||obj.value=="TNGGM" ||obj.value=="THAG" ||obj.value=="TNGAG" ||obj.value=="THGAM" ||obj.value=="TNGGAM" ||obj.value=="THMF" || obj.value=="TNGMF" ){
		if (oh_sub_parts_1=="" ||oh_sub_parts_1==null || oh_sub_parts_1=="null"){  
			oh_sub_parts_1=maxila_sub_parts;
		}
	if (oh_sub_parts_1=="THAB" || oh_sub_parts_1=="THGM" || oh_sub_parts_1=="THAG" || oh_sub_parts_1=="THMF" || oh_sub_parts_1=="THGAM"){ 
		document.getElementById("surface_field").innerHTML = "<select name='oh_surface' id='oh_surface' onChange='populateSubParts(this)'></select>&nbsp;<select name='oh_sub_parts' id='oh_sub_parts' onChange='populateSelectedSubParts(this)'></select>&nbsp;<select name='oh_selected_sub_parts' id='oh_selected_sub_parts' ></select><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>";
	}else if(oh_sub_parts_1=="TNGAB" || oh_sub_parts_1=="TNGGM" || oh_sub_parts_1=="TNGAG" || oh_sub_parts_1=="TNGGAM" || oh_sub_parts_1=="TNGMF"){ 
		document.getElementById("surface_field").innerHTML = "<select name='oh_surface' id='oh_surface' onChange='populateSubParts(this)'></select>&nbsp;<select name='oh_sub_parts' id='oh_sub_parts' onChange='populateSelectedSubParts(this)'></select>&nbsp;<select name='oh_selected_sub_parts' id='oh_selected_sub_parts' size=3 multiple onBlur='chkSelcetedForSuperRDyn(this);countSelectedTooth(this);'></select><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>";
}

	if (oh_surface_1=="" || oh_surface_1==null || oh_surface_1=="null"){
		oh_surface_1=maxila_parts;
	}
	//document.getElementById("surface_field").innerHTML = "<select name='oh_surface' id='oh_surface'></select>&nbsp;<select name='oh_sub_parts' id='oh_sub_parts' ></select>";
		clear_list(document.forms[0].oh_surface); 
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].oh_surface.add(optSel);

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
	    var params = "area_val="+oh_area_1;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateMaxilaSurfaces&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length>1){
			var retVal_arr = retVal.split("~");
			for(var i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				var element 	= document.createElement('OPTION') ;
				element.value 	= code_desc_arr[0];
				element.text 	= code_desc_arr[1] ;
				document.forms[0].oh_surface.add(element);
			}
			document.forms[0].oh_surface.value = oh_surface_1;
			
		}
		clear_list(document.forms[0].oh_sub_parts); 
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].oh_sub_parts.add(optSel);

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		if (oh_surface_1=="" || oh_surface_1=="null" || oh_surface_1==null){
			oh_surface_1=maxila_parts;
		}
	    var params = "parts="+oh_surface_1;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSubParts&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal1 = trimString(xmlHttp.responseText);

		if(retVal1.length>1){
			var retVal_arr = retVal1.split("~");
			for(var i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				var element 	= document.createElement('OPTION') ;
				element.value 	= code_desc_arr[0];
				element.text 	= code_desc_arr[1] ;
				document.forms[0].oh_sub_parts.add(element);
			}
			document.forms[0].oh_sub_parts.value = oh_sub_parts_1;

		}

		clear_list(document.forms[0].oh_selected_sub_parts); 
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].oh_selected_sub_parts.add(optSel);


		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
	    var params = "tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
	   // var params = "tooth_numbering_system="+tooth_numbering_system+"&dflt_mixed_dentition_chart="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateToothNoForMobility&"+params,false);
		//xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateMDToothNo&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal2 = trimString(xmlHttp.responseText);

		if(retVal2.length>1){
			var retVal_arr = retVal2.split("~");
			if ((permanent_deciduous_flag=="P" || permanent_deciduous_flag=="D") && mixed_dentition_YN=="N"){
				for(i=0;i<retVal_arr.length-1;i++){
					var tooth_no_arr = retVal_arr[i].split("##");	
					var element 	= document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent
					var element1 	= document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent
					var element2 	= document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent
										
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system;
				//	var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=localTrimString(retVal);
					if(retVal.length > 0){
						disply_tooth_no = retVal;
					}
					
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_RD = trimString(xmlHttp.responseText);
					retVal_RD = localTrimString(retVal_RD);
					var retVal_RD_arr = retVal_RD.split("##");
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&super_tooth_ref="+super_tooth_ref;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_condition = trimString(xmlHttp.responseText);
						if(retVal_condition.length > 1){
						var retVal_condition_arr = retVal_condition.split("~");
						for(var j=0;j<retVal_condition_arr.length-1;j++){
							var code_desc_arr = retVal_condition_arr[j].split("##");
							if(code_desc_arr[0] == "SUPRTH"){
								var super_text_value = tooth_no_arr[1] + "s";
								element.value 	= tooth_no_arr[0];
								element.text 	= tooth_no_arr[1];
								isSuperYN = true;
								isRetainedDeciduous = false;
								//document.forms[0].oh_selected_sub_parts.add(element);
							}
							else if(code_desc_arr[0] == "RTDESTH"){
								element.value 	= tooth_no_arr[0];
								element.text 	= retVal_RD_arr[0];
								isRetainedDeciduous = true;
								isSuperYN = false;
								//document.forms[0].oh_selected_sub_parts.add(element);
							}else if(code_desc_arr[2] == "N" && code_desc_arr[0] == "EXFOLTH"){//Exfoliated
								element.value 	= tooth_no_arr[0];
								element.text 	= retVal_RD_arr[0];
								isRetainedDeciduous = false;
								//document.forms[0].oh_selected_sub_parts.add(element);
							}
							else if((code_desc_arr[1] == "N" || code_desc_arr[1] == "" || code_desc_arr[1] == "null" || code_desc_arr[1] == null) && code_desc_arr[0] == "EXFOLTH"){//Exfoliated
								var super_text_value = "";
								//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_SuperKey = trimString(xmlHttp.responseText); 
								retVal_SuperKey = localTrimString(retVal_SuperKey); 
								var retVal_SuperKey_arr = retVal_SuperKey.split("~");

								if(retVal_SuperKey_arr.length > 1){
									for(var y=0;y<retVal_SuperKey_arr-1;y++){
										//super_text_value = tooth_no_arr[1] + "s";
										super_text_value = retVal_SuperKey_arr[z]+"["+tooth_no_arr[1]+"]";
										var super_element 	= document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent
										super_element.value 	= tooth_no_arr[0]+retVal_SuperKey_arr[z];
										super_element.text 	= super_text_value;
										document.forms[0].oh_selected_sub_parts.add(super_element);
									}
									 isSuperYN = true;	//Added by SRidevi Joshi on 2/12/2010 for IN010894(SRR20056-CRF-0481)
								}
								else{
									element.value 	= tooth_no_arr[0];
									element.text 	= tooth_no_arr[1];
									isSuperYN = false;
								}
                                isRetainedDeciduous = false;//Added by Sridevi Joshi on 5/18/2010 for IN021473							
                               							
							}
							else if(code_desc_arr[1] == "Y" && code_desc_arr[0] == "EXFOLTH"){//Exfoliated
								element.value 	= tooth_no_arr[0];
								element.text 	= tooth_no_arr[1];
                                //isSuperYN = false;
                                isSuperYN = true; //Added by SRidevi Joshi on 2/12/2010 for IN010894(SRR20056-CRF-0481)
								//document.forms[0].oh_selected_sub_parts.add(element);
								isRetainedDeciduous = false;//Added by Sridevi Joshi on 5/18/2010 for IN021473
							}
							else if(code_desc_arr[3] == "N" && code_desc_arr[0] == "PARERTH"){//Exfoliated
								element.value 	= tooth_no_arr[0];
								element.text 	= tooth_no_arr[1];
                                isSuperYN = false;
								isRetainedDeciduous = false;//Added by Sridevi Joshi on 5/18/2010 for IN021473
								//document.forms[0].oh_selected_sub_parts.add(element);
							}else{
								element.value 	= tooth_no_arr[0];
								element.text 	= tooth_no_arr[1];
									if (code_desc_arr[2]=="R"){
										isRetainedDeciduous = false;
									}else if (code_desc_arr[4]=="Y" && code_desc_arr[0]=="EXFOLTH"){
											 isSuperYN = false;
											 isRetainedDeciduous = false;//Added by Sridevi Joshi on 5/18/2010 for IN021473
									}
									//document.forms[0].oh_selected_sub_parts.add(element);
								}

							}
							if(element != null && element != "null"){
								document.forms[0].oh_selected_sub_parts.add(element);
							}

							 if(isSuperYN == true){
								//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_SuperKey = trimString(xmlHttp.responseText); 
								retVal_SuperKey = localTrimString(retVal_SuperKey); 
								var retVal_SuperKey_arr = retVal_SuperKey.split("~");

								for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
									//element1.value 	= tooth_no_arr[0] + "s";
									//element1.text 	= tooth_no_arr[1] + "s";

									var super_element = document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent

									super_element.value = tooth_no_arr[0]+retVal_SuperKey_arr[z];
									super_element.text	= retVal_SuperKey_arr[z]+"["+tooth_no_arr[1]+"]";
									document.forms[0].oh_selected_sub_parts.add(super_element);

									
								}
								//document.forms[0].oh_selected_sub_parts.add(element1);
							 }

							 if(isRetainedDeciduous == true){
								element1.value 	= tooth_no_arr[0] + "r";
								element1.text 	= retVal_RD_arr[0];
								document.forms[0].oh_selected_sub_parts.add(element1);
							 }
						}else{
							element.value 	= tooth_no_arr[0];
							element.text 	= tooth_no_arr[1];
							document.forms[0].oh_selected_sub_parts.add(element);
						}
						
         		}
				
			}else if(mixed_dentition_YN=="Y" && permanent_deciduous_flag=="P"){
				for(i=0;i<retVal_arr.length-1;i++){
					var tooth_no_arr = retVal_arr[i].split("##");	
					var element 	= document.createElement("OPTION");
					var element1 	= document.createElement("OPTION");
					var element2 	= document.createElement("OPTION");
					var element3 	= document.createElement("OPTION");
						if(tooth_no_arr[0] != "1" && tooth_no_arr[0] != "16" && tooth_no_arr[0] != "17" && tooth_no_arr[0] != "32" ){
						element.value 	= code_desc_arr[0];
						element.text 	= code_desc_arr[1] ;
						}else{	
							continue;
						}
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=localTrimString(retVal);
					if(retVal.length > 0){
						disply_tooth_no = retVal;
					}
					
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_RD = trimString(xmlHttp.responseText);
					var retVal_RD_arr = retVal_RD.split("##");
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_condition = trimString(xmlHttp.responseText);
						if(retVal_condition.length > 1){
						var retVal_condition_arr = retVal_condition.split("~");
						for(var j=0;j<retVal_condition_arr.length-1;j++){
							var code_desc_arr = retVal_condition_arr[j].split("##");	
							//DECITH####D##Y##N~SUPRTH####D##Y##N~
							
							if(code_desc_arr[0] == "SUPRTH" && code_desc_arr[2] == "D"){
								element.value 	= tooth_no_arr[0];
								element.text 	= retVal_RD_arr[0];
								isSuperYN = true;
								isRetainedDeciduous = false;
								isErupted = false;
							}else if(code_desc_arr[0] == "SUPRTH" && (code_desc_arr[2] != "" || code_desc_arr[2] != "null" || code_desc_arr[2] != null)){
								element.value 	= tooth_no_arr[0];
								element.text 	= tooth_no_arr[1];
								isSuperYN = true;
								isRetainedDeciduous = false;
								isDeciduousTooth = false;
								isErupted = false;	
							}
							else if(code_desc_arr[0] == "RTDESTH") {
								element.value 	= tooth_no_arr[0];
								element.text 	= retVal_RD_arr[0];
								isRetainedDeciduous = true;
								isSuperYN = false;
							}else if(code_desc_arr[2] == "R" && code_desc_arr[0] == "EXFOLTH"){//Exfoliated
								element.value 	= tooth_no_arr[0];
								element.text 	= tooth_no_arr[1];
								isRetainedDeciduous=false
							}else if(code_desc_arr[2] == "D" && code_desc_arr[0] == "EXFOLTH"){//Exfoliated
								var retVal_SuperKey_count = 0;
								var total_SuperKey_count =0;
								var exfolth_count = 0;
								//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+code_desc_arr[2];
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_SuperKey = trimString(xmlHttp.responseText); 
								retVal_SuperKey = localTrimString(retVal_SuperKey); 
								var retVal_SuperKey_arr = retVal_SuperKey.split("~");

								retVal_SuperKey_count = parseInt(retVal_SuperKey_arr.length)-1;
		
								total_SuperKey_count = parseInt(retVal_SuperKey_count)+1; //this is to include tooth_no count also

								//Added to count the number of Exfoliated conditions recorded in case of Retained.
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								
								var params = "tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+code_desc_arr[2];

								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfToothForSUPRTH&"+params,false);
								xmlHttp.send(xmlDoc);
								var count_Exf = trimString(xmlHttp.responseText);
								count_Exf = localTrimString(count_Exf);
								if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
									var exfolth_retVal_arr = count_Exf.split("##");
									exfolth_count = exfolth_retVal_arr[0];			
								}

								if(exfolth_count != total_SuperKey_count){
									if(retVal_SuperKey_arr.length > 1){
										for(var y=0;y<retVal_SuperKey_arr-1;y++){
											//super_text_value = tooth_no_arr[1] + "s";
											var super_element = document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent
											super_text_value = retVal_SuperKey_arr[y]+"["+retVal_RD_arr[0]+"]";
											super_element.value 	= tooth_no_arr[0]+retVal_SuperKey_arr[y];
											super_element.text 	= super_text_value;
											
											document.forms[0].oh_selected_sub_parts.add(super_element);
										}
										isSuperYN = true;
									}
									else{
										element.value 	= tooth_no_arr[0];
										element.text 	= retVal_RD_arr[0];
										isSuperYN = false;
									}
									isDeciduousTooth=true;
									
								}
								else{
									element.value 	= tooth_no_arr[0];
									element.text 	= tooth_no_arr[1];
									isSuperYN = false;
									isDeciduousTooth=false;
								}
								
								
							}else if((code_desc_arr[1] == "N" || code_desc_arr[1] == "" || code_desc_arr[1] == "null" || code_desc_arr[1] == null) && code_desc_arr[0] == "EXFOLTH"){//Exfoliated
								var super_text_value = "";
								//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_SuperKey = trimString(xmlHttp.responseText); 
								retVal_SuperKey = localTrimString(retVal_SuperKey); 
								var retVal_SuperKey_arr = retVal_SuperKey.split("~");
								if(retVal_SuperKey_arr.length > 1){
									for(var y=0;y<retVal_SuperKey_arr-1;y++){
										//super_text_value = tooth_no_arr[1] + "s";
										var super_element = document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent
										super_text_value = retVal_SuperKey_arr[y]+"["+tooth_no_arr[1]+"]";
										super_element.value 	= tooth_no_arr[0]+retVal_SuperKey_arr[y];
										super_element.text 	= super_text_value;
										document.forms[0].oh_selected_sub_parts.add(super_element);
									}
								}
								
								/*var super_text_value = tooth_no_arr[1] +"s";
								element.value 	= tooth_no_arr[0];
								element.text 	= super_text_value;*/
								
							}else if (code_desc_arr[2] == "D" &&  code_desc_arr[0]=="DECITH"){
								element.value 	= tooth_no_arr[0]+"d";
								element.text 	= retVal_RD_arr[0];
								isDeciduousTooth=true;
								isErupted=true;
							}else{
								if (code_desc_arr[0]=="UNERTH"){
									isErupted=true;
								}
								element.value 	= tooth_no_arr[0];
								element.text 	= tooth_no_arr[1];

								if(isDeciduousTooth==true && isSuperYN ==true){
									element.value 	= tooth_no_arr[0];
									element.text 	= retVal_RD_arr[0];
									
								}
							}
						}
							if(element != null && element != "null"){
								document.forms[0].oh_selected_sub_parts.add(element);
							}
							 if(isSuperYN == true && isDeciduousTooth!=true && isErupted!=true){
								//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+code_desc_arr[2];
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_SuperKey = trimString(xmlHttp.responseText); 
								retVal_SuperKey = localTrimString(retVal_SuperKey); 
								var retVal_SuperKey_arr = retVal_SuperKey.split("~");
								if(retVal_SuperKey_arr.length > 1){
									for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
										//element1.value 	= tooth_no_arr[0] + "s";
										//element1.text 	= tooth_no_arr[1] + "s";

										var super_element = document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent

										super_element.value = tooth_no_arr[0]+retVal_SuperKey_arr[z];
										super_element.text	= retVal_SuperKey_arr[z]+"["+tooth_no_arr[1]+"]";
										document.forms[0].oh_selected_sub_parts.add(super_element);
									}
								}
								/*element1.value 	= tooth_no_arr[0] + "s";
								element1.text 	= tooth_no_arr[1] + "s";
								document.forms[0].oh_selected_sub_parts.add(element1);*/
							
							 }
							  if(isSuperYN == true && isDeciduousTooth==true && isErupted!=true){	
								//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+code_desc_arr[2];
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_SuperKey = trimString(xmlHttp.responseText); 
								retVal_SuperKey = localTrimString(retVal_SuperKey); 
								var retVal_SuperKey_arr = retVal_SuperKey.split("~");
								for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
									//element1.value 	= tooth_no_arr[0] + "s";
									//element1.text 	= tooth_no_arr[1] + "s";

									var super_element = document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent

									super_element.value = tooth_no_arr[0]+retVal_SuperKey_arr[z];
									super_element.text	= retVal_SuperKey_arr[z]+"["+retVal_RD_arr[0]+"]";
									document.forms[0].oh_selected_sub_parts.add(super_element);

									
								}
								/*
								element3.value 	= tooth_no_arr[0] + "s";
								element3.text 	=  retVal_RD_arr[0]+ "s";
								document.forms[0].oh_selected_sub_parts.add(element3);
								*/
							 }
							 if(isRetainedDeciduous == true){
								element2.value 	= tooth_no_arr[0] + "r";
								element2.text 	= retVal_RD_arr[0];
								document.forms[0].oh_selected_sub_parts.add(element2);
							 }

						}else{
							element.value 	= tooth_no_arr[0];
							element.text 	= tooth_no_arr[1];
							document.forms[0].oh_selected_sub_parts.add(element);
						}
         			}
			
			} else if(mixed_dentition_YN=="Y" && permanent_deciduous_flag=="D"){
				for(i=0;i<retVal_arr.length-1;i++){
					var tooth_no_arr = retVal_arr[i].split("##");	
					var element 	= document.createElement("OPTION");
					var element1 	= document.createElement("OPTION");
					var element2 	= document.createElement("OPTION");
					if(tooth_no_arr[0] != "1" && tooth_no_arr[0] != "16" && tooth_no_arr[0] != "17" && tooth_no_arr[0] != "32" ){
						element.value 	= code_desc_arr[0];
						element.text 	= code_desc_arr[1] ;
					}else{	
						continue;
					}
					
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=localTrimString(retVal);
					if(retVal.length > 0){
						disply_tooth_no = retVal;
					}
					
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_RD = trimString(xmlHttp.responseText);

					var retVal_RD_arr = retVal_RD.split("##");
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_condition = trimString(xmlHttp.responseText);
					
					if(retVal_condition.length > 1){
						var retVal_condition_arr = retVal_condition.split("~");
						for(var j=0;j<retVal_condition_arr.length-1;j++){
							var code_desc_arr = retVal_condition_arr[j].split("##");	
							if(code_desc_arr[2] == "M" && code_desc_arr[0] == "EXFOLTH"){//Exfoliated
								var retVal_SuperKey_count = 0;
								var total_SuperKey_count =0;
								var exfolth_count = 0;
								//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+code_desc_arr[2];
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_SuperKey = trimString(xmlHttp.responseText); 
								retVal_SuperKey = localTrimString(retVal_SuperKey); 
								var retVal_SuperKey_arr = retVal_SuperKey.split("~");

								retVal_SuperKey_count = parseInt(retVal_SuperKey_arr.length)-1;
		
								total_SuperKey_count = parseInt(retVal_SuperKey_count)+1; //this is to include tooth_no count also

								//Added to count the number of Exfoliated conditions recorded in case of Retained.
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								
								var params = "tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+code_desc_arr[2];

								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfToothForSUPRTH&"+params,false);
								xmlHttp.send(xmlDoc);
								var count_Exf = trimString(xmlHttp.responseText);
								count_Exf = localTrimString(count_Exf);
								if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
									var exfolth_retVal_arr = count_Exf.split("##");
									exfolth_count = exfolth_retVal_arr[0];			
								}

								if(exfolth_count != total_SuperKey_count){
									if(retVal_SuperKey_arr.length > 1){
										/*for(var y=0;y<retVal_SuperKey_arr-1;y++){
											//super_text_value = tooth_no_arr[1] + "s";
											var super_element = document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent
											//super_text_value = retVal_SuperKey_arr[y]+"["+retVal_RD_arr[0]+"]";
											super_text_value = retVal_SuperKey_arr[y]+"["+tooth_no_arr[1]+"]";
											super_element.value 	= tooth_no_arr[0]+retVal_SuperKey_arr[y];
											super_element.text 	= super_text_value;
											
											document.forms[0].oh_selected_sub_parts.add(super_element);
										}*/

										element.value 	= tooth_no_arr[0];
										//element.text 	= tooth_no_arr[1];
										if(parseInt(exfolth_count) >= 3){
											element.text 	= retVal_RD_arr[0];
										}
										else{
											element.text 	= tooth_no_arr[1];
										}
										
										isSuperYN = true;
									}
									else{
										element.value 	= tooth_no_arr[0];
										//element.text 	= retVal_RD_arr[0];
										element.text 	= tooth_no_arr[1];
										isSuperYN = false;
										isErupted = false;
										isRetainedDeciduous=false;
									}
									isDeciduousTooth=true;
									
								}
								else{
									element.value 	= tooth_no_arr[0];
									//element.text 	= tooth_no_arr[1];
									element.text 	= retVal_RD_arr[0];
									isSuperYN = false;
									isErupted = false;
									isRetainedDeciduous=false;
									isExfoliated = true;
								}
								
								/*element.value 	= tooth_no_arr[0];
								element.text 	= retVal_RD_arr[0];
								 isExfoliated = true;
								 isRetainedDeciduous=false;
							  if(isSuperYN){
								 element.value 	= tooth_no_arr[0];
								  element.text 	= tooth_no_arr[1];
								   isSuperYN = false;
								   isErupted = false;
								   if (isExfoliated){
									   element.value 	= tooth_no_arr[0];
										element.text 	= retVal_RD_arr[0];
										isRetainedDeciduous=false;
										isErupted=false;
										 isSuperYN = true;
										 
								   }
							  }*/
							 
							}else if(code_desc_arr[0] == "ERUPTH" && (code_desc_arr[2] == "" || code_desc_arr[2] == "null" || code_desc_arr[2] == null) && isExfoliated!=true){
								//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+code_desc_arr[2];
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
										xmlHttp.send(xmlDoc);
										var retVal_SuperKey = trimString(xmlHttp.responseText); 
										retVal_SuperKey = localTrimString(retVal_SuperKey); 
										var retVal_SuperKey_arr = retVal_SuperKey.split("~");
										if(retVal_SuperKey_arr.length > 1){
											isSuperYN = true;
										}
										else{
											element.value 	= tooth_no_arr[0];
											element.text 	= retVal_RD_arr[0];
											isSuperYN = false; //Added by Sridevi Joshi on 2/17/2010
										}

										isErupted = true;//Added by Sridevi Joshi on 2/17/2010
									/*element.value 	= tooth_no_arr[0];
									element.text 	= retVal_RD_arr[0];*/
							}else if(code_desc_arr[0] == "SUPRTH"){
								if (isExfoliated){
									element.value 	= tooth_no_arr[0];
									//element.text 	= tooth_no_arr[1];
									element.text 	= retVal_RD_arr[0];//Added by Sridevi Joshi on 2/19/2010 for IN019368
									isSuperYN = true;
									isExfoliated = false;
									isRetainedDeciduous=false;									
								}else{
                                   if(code_desc_arr[2] == "M"){
										element.value 	= tooth_no_arr[0];
										//element.text 	= retVal_RD_arr[0];
										element.text 	= tooth_no_arr[1];
										isSuperYN = true;
								   }else{
									   if (isErupted){
										   if (isSuperYN){
												element.value 	= tooth_no_arr[0];
												element.text 	= retVal_RD_arr[0];
												isSuperYN = true;
												isRetainedDeciduous=false;
												isExfoliated=true;
												//isErupted = true; //Added by Sridevi Joshi on 2/17/2010 for IN019368
										
										   }else {
												element.value 	= tooth_no_arr[0];
												element.text 	= tooth_no_arr[1];
												//element.text 	= retVal_RD_arr[0];
												//isSuperYN = true;
												isSuperYN = false;//Added by Sridevi Joshi on 2/17/2010 for IN019368
												isRetainedDeciduous=false;
												isExfoliated=false;
												isErupted=false;
												//isErupted = true; //Added by Sridevi Joshi on 2/17/2010 for IN019368
										   }
									   }
									   else{
										   isSuperYN = true;//Added by Sridevi Joshi on 2/8/2010 for IN010894
									   }
								   }
								}
							}
							else if(code_desc_arr[2] == "R" && code_desc_arr[0] == "EXFOLTH"){//Exfoliated
								element.value 	= tooth_no_arr[0];
								element.text 	= retVal_RD_arr[0];
								isExfoliated = true;								
								isRetainedDeciduous = false;	
							}else if(code_desc_arr[0] == "RTDESTH"){
									element.value 	= tooth_no_arr[0];
									element.text 	= retVal_RD_arr[0];
									isRetainedDeciduous = true;
									isSuperYN = false;
							}else if(code_desc_arr[0] == "ERUPTH" && code_desc_arr[3]=="N" && code_desc_arr[4]=="Y"){
								element.value 	= tooth_no_arr[0];
								element.text 	= retVal_RD_arr[0];
								isErupted=true;	
								isExfoliated = false;
								
							}
							else{
								element.value 	= tooth_no_arr[0];
								element.text 	= tooth_no_arr[1];
									if (isExfoliated==true && isSuperYN==true){
										element.value 	= tooth_no_arr[0];
										element.text 	= retVal_RD_arr[0];
									}
							
								}
							}
							document.forms[0].oh_selected_sub_parts.add(element);
							 if(isSuperYN == true && isExfoliated==false && isRetainedDeciduous==false && isErupted==false){
								//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+code_desc_arr[2];
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_SuperKey = trimString(xmlHttp.responseText); 
								retVal_SuperKey = localTrimString(retVal_SuperKey); 
								var retVal_SuperKey_arr = retVal_SuperKey.split("~");

								for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
									//element1.value 	= tooth_no_arr[0] + "s";
									//element1.text 	= tooth_no_arr[1] + "s";

									var super_element = document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent

									super_element.value = tooth_no_arr[0]+retVal_SuperKey_arr[z];
									super_element.text	= retVal_SuperKey_arr[z]+"["+tooth_no_arr[1]+"]";
									document.forms[0].oh_selected_sub_parts.add(super_element);

									
								}
								/*
								element1.value 	= tooth_no_arr[0]+"s";
								element1.text 	= tooth_no_arr[1] +"s";
								document.forms[0].oh_selected_sub_parts.add(element1);
								*/
							 }

							 if(isSuperYN == true && isExfoliated==false && isRetainedDeciduous==false && isErupted==true){
								//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+code_desc_arr[2];
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_SuperKey = trimString(xmlHttp.responseText); 
								retVal_SuperKey = localTrimString(retVal_SuperKey); 
								var retVal_SuperKey_arr = retVal_SuperKey.split("~");

								for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
									//element1.value 	= tooth_no_arr[0] + "s";
									//element1.text 	= tooth_no_arr[1] + "s";

									var super_element = document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent

									super_element.value = tooth_no_arr[0]+retVal_SuperKey_arr[z];
									super_element.text	= retVal_SuperKey_arr[z]+"["+retVal_RD_arr[0]+"]";
									document.forms[0].oh_selected_sub_parts.add(super_element);

									
								}
								/*
								element1.value 	= tooth_no_arr[0]+"s";
								element1.text 	= tooth_no_arr[1] +"s";
								document.forms[0].oh_selected_sub_parts.add(element1);
								*/
							 }
							
							  if(isSuperYN == true && isExfoliated==true){
								 //Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+code_desc_arr[2];
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_SuperKey = trimString(xmlHttp.responseText); 
								retVal_SuperKey = localTrimString(retVal_SuperKey); 
								var retVal_SuperKey_arr = retVal_SuperKey.split("~");
								for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
									//element1.value 	= tooth_no_arr[0] + "s";
									//element1.text 	= tooth_no_arr[1] + "s";

									var super_element = document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent

									super_element.value = tooth_no_arr[0]+retVal_SuperKey_arr[z];
									super_element.text	= retVal_SuperKey_arr[z]+"["+retVal_RD_arr[0]+"]";
									document.forms[0].oh_selected_sub_parts.add(super_element);

									
								}
								/*
								element1.value 	= tooth_no_arr[0]+"s";
								element1.text 	= retVal_RD_arr[0] + "s";
								document.forms[0].oh_selected_sub_parts.add(element1);
								*/
							 }
							  if(isSuperYN == true && isExfoliated==false && isRetainedDeciduous==true){
								//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+code_desc_arr[2];
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_SuperKey = trimString(xmlHttp.responseText); 
								retVal_SuperKey = localTrimString(retVal_SuperKey); 
								var retVal_SuperKey_arr = retVal_SuperKey.split("~");
								for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
									//element1.value 	= tooth_no_arr[0] + "s";
									//element1.text 	= tooth_no_arr[1] + "s";

									var super_element = document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent

									super_element.value = tooth_no_arr[0]+retVal_SuperKey_arr[z];
									super_element.text	= retVal_SuperKey_arr[z]+"["+tooth_no_arr[1]+"]";
									document.forms[0].oh_selected_sub_parts.add(super_element);

									
								}

								/*element1.value 	= tooth_no_arr[0]+"s";
								element1.text 	= tooth_no_arr[1] +"s";
								document.forms[0].oh_selected_sub_parts.add(element1);
								*/
								
							 }

							 if(isRetainedDeciduous == true){
								element2.value 	= tooth_no_arr[0] + "r";
								element2.text 	= retVal_RD_arr[0];
								document.forms[0].oh_selected_sub_parts.add(element2);
							 }


						}else{
							element.value 	= tooth_no_arr[0];
							element.text 	= tooth_no_arr[1];
							document.forms[0].oh_selected_sub_parts.add(element);
						}

         		}
				
					/*var ref_tooth_no="";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateMixedDentToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_mixed = trimString(xmlHttp.responseText);
					retVal_mixed=localTrimString(retVal_mixed);
					var retVal_mixed_arr = retVal_mixed.split("~");
					for(k=0;k<retVal_mixed_arr.length-1;k++){
						var code_mixed = retVal_mixed_arr[k].split("##");
						if(code_mixed[1] != "0" && code_mixed[1] != "" && code_mixed[1] != null && code_mixed[1] != "null"){
							var element 	= document.createElement('OPTION') ;
							element.value 	= code_mixed[0];
							element.text 	= code_mixed[1] ;
							document.forms[0].oh_selected_sub_parts.add(element);
						}
					}*/

					//only for extreme tooth in MD-D case added by Sridevi Joshi on 2/17/2010 for IN019368
					var ref_tooth_no="";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+ref_tooth_no+"&numbering_system="+tooth_numbering_system;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateMixedDentToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_mixed = trimString(xmlHttp.responseText);

					retVal_mixed=localTrimString(retVal_mixed);
					var retVal_mixed_arr = retVal_mixed.split("~");
					for(k=0;k<retVal_mixed_arr.length-1;k++){
						var element 	= document.createElement("OPTION");
						var element1 	= document.createElement("OPTION");
						var element2 	= document.createElement("OPTION");
						var tooth_no_arr = retVal_mixed_arr[k].split("##");
						if(tooth_no_arr[1] != "0" && tooth_no_arr[1] != "" && tooth_no_arr[1] != null && tooth_no_arr[1] != "null"){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_condition = trimString(xmlHttp.responseText);
							
							if(retVal_condition.length > 1){
								var retVal_condition_arr = retVal_condition.split("~");
								for(var j=0;j<retVal_condition_arr.length-1;j++){
									var code_desc_arr = retVal_condition_arr[j].split("##");						
									if(code_desc_arr[0] == "ERUPTH" && (code_desc_arr[2] == "" || code_desc_arr[2] == "null" || code_desc_arr[2] == null)){
										//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+code_desc_arr[2];
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
										xmlHttp.send(xmlDoc);
										var retVal_SuperKey = trimString(xmlHttp.responseText); 
										retVal_SuperKey = localTrimString(retVal_SuperKey); 
										var retVal_SuperKey_arr = retVal_SuperKey.split("~");
										if(retVal_SuperKey_arr.length > 1){
											isSuperYN1 = true;
										}
										else{
											element.value 	= tooth_no_arr[0];
											element.text 	= tooth_no_arr[1];
											isSuperYN1 = false; //Added by Sridevi Joshi on 2/17/2010
										}

										isErupted1 = true;//Added by Sridevi Joshi on 2/17/2010
									
									}else if(code_desc_arr[0] == "SUPRTH"){
									   if (isErupted1){
										   if (isSuperYN1){
												element.value 	= tooth_no_arr[0];
												element.text 	= tooth_no_arr[1];
												isSuperYN1 = true;
										   }
										   else {
												element.value 	= tooth_no_arr[0];
												element.text 	= tooth_no_arr[1];
												isSuperYN1 = false;//Added by Sridevi Joshi on 2/17/2010 for IN019368
										   }
									   }
									}
									else if(code_desc_arr[0] == "ERUPTH" && code_desc_arr[3]=="N" && code_desc_arr[4]=="Y"){
										element.value 	= tooth_no_arr[0];
										element.text 	= tooth_no_arr[1];
										isErupted1=true;	
										isExfoliated1 = false;
										
									}
									else{
										element.value 	= tooth_no_arr[0];
										element.text 	= tooth_no_arr[1];
											if (isSuperYN1==true){
												element.value 	= tooth_no_arr[0];
												element.text 	= tooth_no_arr[1];
											}
									
										}
									}
									document.forms[0].oh_selected_sub_parts.add(element);

									if(isSuperYN1 == true){
										//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										params = "func_mode=checkSuperKey&tooth_no="+tooth_no_arr[0]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+code_desc_arr[2];
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
										xmlHttp.send(xmlDoc);
										var retVal_SuperKey = trimString(xmlHttp.responseText); 
										retVal_SuperKey = localTrimString(retVal_SuperKey); 
										var retVal_SuperKey_arr = retVal_SuperKey.split("~");
										for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
											var super_element = document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent
											super_element.value = tooth_no_arr[0]+retVal_SuperKey_arr[z];
											super_element.text	= retVal_SuperKey_arr[z]+"["+tooth_no_arr[1]+"]";
											document.forms[0].oh_selected_sub_parts.add(super_element);
										}
									 }
								}else{
									element.value 	= tooth_no_arr[0];
									element.text 	= tooth_no_arr[1];
									document.forms[0].oh_selected_sub_parts.add(element);
								}
						}
					}
			
				} 
		}
	}else{
			document.getElementById("surface_field").innerHTML = "<select name='oh_surface' id='oh_surface' onChange='populateSubParts(this)'></select>&nbsp;<select name='oh_sub_parts' id='oh_sub_parts' onChange='populateSelectedSubParts(this)'></select><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>";
		
			clear_list(document.forms[0].oh_surface); 
			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
			optSel.value= ''; 
			document.forms[0].oh_surface.add(optSel);

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "area_val="+oh_area_1;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateMaxilaSurfaces&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					var element 	= document.createElement('OPTION') ;
					element.value 	= code_desc_arr[0];
					element.text 	= code_desc_arr[1] ;
					document.forms[0].oh_surface.add(element);
				}
				document.forms[0].oh_surface.value = oh_surface_1;
				
			}
			clear_list(document.forms[0].oh_sub_parts); 
			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
			optSel.value= ''; 
			document.forms[0].oh_sub_parts.add(optSel);

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "parts="+oh_surface_1;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSubParts&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal1 = trimString(xmlHttp.responseText);
			if(retVal1.length>1){
				var retVal_arr = retVal1.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					var element 	= document.createElement('OPTION') ;
					element.value 	= code_desc_arr[0];
					element.text 	= code_desc_arr[1] ;
					document.forms[0].oh_sub_parts.add(element);
				}
				document.forms[0].oh_sub_parts.value = oh_sub_parts_1;
				
			}

	}

}

function chkSelcetedForSuperRDyn(obj) { 
		var formObj=document.forms[0];
		var count_maxlia_parts = 0;
		var patient_id=document.forms[0].patient_id.value;
		var chart_num=document.forms[0].chart_num.value;
		var thrng_nos_ref = formObj.thrng_nos_ref.value;
		var oh_area_1=document.forms[0].oh_area.value;
		var oh_surface_1=document.forms[0].oh_surface.value;
		var tab_name="";
		
		if(document.forms[0].name=='OHConditionForm'){//should go inside for Dental Condition only it was going in side for EXT trmt also 
		  if(formObj.oh_condition_type.value=='MXNTL'){
			  thrng_nos_ref="";
		  }
		}
			 if (thrng_nos_ref=="") {	
					for(var m=0;m<formObj.oh_selected_sub_parts.options.length;m++){						
						  if(formObj.oh_selected_sub_parts.options[m].selected==true){
							  if(thrng_nos_ref==""){
								 thrng_nos_ref=formObj.oh_selected_sub_parts.options[m].value;
							 }else{
								
								thrng_nos_ref=thrng_nos_ref+","+formObj.oh_selected_sub_parts.options[m].value;
								count_maxlia_parts = count_maxlia_parts+1;
								
							 }

						}						  
					}
				}else{
				   if(thrng_nos_ref.length>0){
					   for(var m=0;m<formObj.oh_selected_sub_parts.options.length;m++){						
						  if(formObj.oh_selected_sub_parts.options[m].selected==true){
							  if(thrng_nos_ref==""){
								 thrng_nos_ref=formObj.oh_selected_sub_parts.options[m].value;
							 }else{
								
								thrng_nos_ref=thrng_nos_ref+","+formObj.oh_selected_sub_parts.options[m].value;
								count_maxlia_parts = count_maxlia_parts+1;
								
							 }
						  }					  
					   }
				   }
				}
			if(count_maxlia_parts>0){
				var thrng_nos_ref_arr = thrng_nos_ref.split(",");
				for(i=0;i<thrng_nos_ref_arr.length;i++){
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var thrng_nos="";
					//commented by parul on 18/05/2010 for IN021473
					//var thrng_nos=thrng_nos_ref_arr[i].replace("s","");
					//var thrng_nos=thrng_nos_ref_arr[i].substring(0,thrng_nos_ref_arr[i].indexOf("s")); //Addedby SRidevi Joshi on 2/8/2010 for IN010894

					if (thrng_nos_ref_arr[i].indexOf("s")==1){
						thrng_nos=thrng_nos_ref_arr[i].substring(0,thrng_nos_ref_arr[i].indexOf("s"));
					}else if(thrng_nos_ref_arr[i].indexOf("r")==1){
						thrng_nos=thrng_nos_ref_arr[i].substring(0,thrng_nos_ref_arr[i].indexOf("r"));
					
					}

					var params = "tooth_no="+thrng_nos+"&patient_id="+patient_id+"&chart_num="+chart_num;
					//alert(params)
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=SuperRDyn&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText); 
					retVal = localTrimString(retVal); 
					if(retVal.length > 0){
						var retVal_arr = retVal.split("##");
						if(retVal_arr[0] == "Y"){ //SuperRDyn
							alert(getMessage("APP-OH00040","OH"));
							formObj.oh_selected_sub_parts.focus();
							break;
						}
					}
				}
			}
	}


function OHshowCalendar(id, date_format,time_format,modal_yn) 
		{
			var locn = window.location.href;
			// var el = eval("document.all."+id);
			var el = document.getElementById(id);
			 var isModal="isDiv";
			 var timeSet="";
			if ( (date_format==undefined) || (date_format=='') || (date_format==null) || (date_format=='null'))
			{
					timeSet="dd/mm/yyyy"
			}
			else 
			{
					timeSet=date_format
			}
			if ( (time_format!=undefined) && (time_format!='') && (time_format!=null) && (time_format!='null') )
			{

				timeSet = timeSet +' '+ time_format;
			}
/*			if(modal_yn=='modal')		
			{
					showInModal(el,timeSet)
					return false;
			}
*/
			//if ( ( ! document.getElementById("CACalanderFun") ) && (eval("document.all."+id+".type") !='hidden') )
			if (!document.getElementById("CACalanderFun") && document.getElementById(id) && document.getElementById(id).type !== 'hidden') 
			{
				 document.getElementById(id).blur();
			}

			if(enableFlag)
			{
					return false
			}
			else
			{
				enableFlag=true;
			}
			
			timeSet = timeSet+"&locn="+locn;
			OHshowInModal(el,timeSet);
			return false;
			// Only if we can show the dhtml calendar
			//if(document.body.offsetWidth>250 && document.body.offsetHeight > 250)
/*			if(document.body.offsetWidth>320 && document.body.offsetHeight > 320)
			{
					var x =event.x
					var y =  event.y;

					bodwidth = document.body.offsetWidth
					bodheight = document.body.offsetHeight
// Changed from 70 to 150 and 250 to 320
					var layerHeight = 150
					var layerWidth = 320

					var x =event.x
					var y =  event.y;

					x = x + layerWidth
					y = y +  layerHeight

					if(x<bodwidth)
						x =event.x
					else
						x = x - (layerWidth*2)

					if(y<bodheight)
						 y =event.y
					else
						y = y - (layerHeight*2)

					y+=document.body.scrollTop
					x+=document.body.scrollLeft

					var cal = callDHTMLCalendar(id,x,y,timeSet);
					return false;
			}
			// Display in the Modal window
			 else
			 {
					showInModal(el,timeSet)
					
					return false;
				}
*/
		}

		async function OHshowInModal(args,timeSet)
	{
			var dialogHeight= "40vh" ;
			var dialogWidth	= "55vw" ;
			var status = "no";
			//var arguments = "";
			var features	=  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
			var  dateValue=await window.showModalDialog('../../eCommon/jsp/CommonStaticCalenderGlad.jsp?timeSet='+timeSet,args, features);
		/*	var serverTime="";
			if( (timeSet=="dd/mm/yyyy") || (timeSet=="dd/mm/y") || (timeSet=="mm/y") )
			{
					serverTime=""
			}
			else 
			{
				Dt = new Date();
				serverTime=Dt.getHours()+':'+Dt.getMinutes();
			}
			
			var formatedDate=null;*/
			var formatedDate = dateValue;


	/*		if(serverTime.length==0)
				formatedDate= dateValue;
			else
				formatedDate= dateValue+" "+serverTime;
			//var formatedDate= dateValue+" "+serverTime*/

			if(formatedDate==undefined)
			{
					 args.value= "";
			}
			else
			{
					args.value =formatedDate;
			}
			if ( ( ! document.getElementById("CACalanderFun") ) && (args.type !='hidden') )
			args.focus();
			enableFlag=false;
    }

	//Imagereplace was here..



	function chkTreatment(obj){
	  var formObj=document.forms[0];
	  var oh_category=formObj.oh_category.value;
	  if (oh_category=="CROWN"){
		  populateSurfaces(formObj.oh_area.value);
	  }
	}

  function chkForSuper_RD(obj) {
	var formObj=document.forms[0];
	var count_maxlia_parts = 0;
	var patient_id=document.forms[0].patient_id.value;
	var chart_num=document.forms[0].chart_num.value;
	var thrng_nos_ref = formObj.thrng_nos_ref.value;
	var oh_area=document.forms[0].oh_area.value;
	var oh_surface_1=document.forms[0].oh_surface.value;
		 if (thrng_nos_ref=="") {	
				for(var m=0;m<formObj.oh_area.options.length;m++){						
					  if(formObj.oh_area.options[m].selected==true){
						  if(thrng_nos_ref==""){
							 thrng_nos_ref=formObj.oh_area.options[m].value;
						 }else{
							thrng_nos_ref=thrng_nos_ref+","+formObj.oh_area.options[m].value;
							count_maxlia_parts = count_maxlia_parts+1;
						 }

					}						  
				}
			}
		if(count_maxlia_parts>0){
			var thrng_nos_ref_arr = thrng_nos_ref.split(",");
			for(i=0;i<thrng_nos_ref_arr.length;i++){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+thrng_nos_ref_arr[i]+"&patient_id="+patient_id+"&chart_num="+chart_num;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=SuperRDyn&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText); 
				retVal = localTrimString(retVal); 
				if(retVal.length > 0){
					var retVal_arr = retVal.split("##");
					if(retVal_arr[0] == "Y"){ //SuperRDyn
						alert(getMessage("APP-OH00040","OH"));
						formObj.oh_area.focus();
						break;
					}
				}
			}
		}
	}
//added by parul on 22/02/2010 for CRF-477 & 496
function chkForFailureReason(obj){
   var formObj = document.forms[0];
   var trmt_category_type=formObj.oh_category.value;
   var trmt_category_text=formObj.oh_category.options[formObj.oh_category.options.selectedIndex].text;
  if(obj.value=="F"){
		document.getElementById("reason_field").style.visibility = 'visible';
		document.getElementById("change_reason").style.visibility = 'visible';
		document.getElementById("change_reason").style.display = 'block';
		document.getElementById("reason_field").innerHTML=" <input type=text name='oh_failure' id='oh_failure' onBlur=\"getFaliureLookUp('"+trmt_category_type+"','"+trmt_category_text+"')\"><input type=button value=?   onclick=\"getFaliureLookUp('"+trmt_category_type+"','"+trmt_category_text+"')\"><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>";
  }else{
		document.getElementById("reason_field").style.visibility = 'hidden';
		document.getElementById("change_reason").style.visibility = 'hidden';  
  }

}

function getFaliureLookUp(obj,target){
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql="";
	var frmObj=document.forms[0];
	 var trmt_category_type=frmObj.oh_category.value;


	  if (tit_flag="Failure Reason Search"){

		// sql="SELECT A.REASON_DESC DESCRIPTION,A.REASON_CODE CODE  FROM OH_REASON_LANG_VW A,OH_REASONS_DTLS B WHERE A.REASON_CODE = B.REASON_CODE AND  A.LANGUAGE_ID ='"+locale+"' AND NVL(A.EFF_STATUS,'E') = 'E' AND B.TRMT_CATEGORY_TYPE = '"+trmt_category_type+"' AND NVL(APPLICABLE_YN,'N') ='Y' AND UPPER(A.REASON_DESC)LIKE UPPER(?) AND UPPER(A.REASON_CODE) LIKE UPPER(?) ORDER BY 1";	
		 sql="SELECT A.REASON_CODE CODE,A.REASON_DESC DESCRIPTION FROM OH_REASON_LANG_VW A,OH_REASONS_DTLS B WHERE A.REASON_CODE = B.REASON_CODE AND  A.LANGUAGE_ID ='"+locale+"' AND NVL(A.EFF_STATUS,'E') = 'E' AND B.TRMT_CATEGORY_TYPE = '"+trmt_category_type+"' AND NVL(APPLICABLE_YN,'N') ='Y' AND UPPER(A.REASON_CODE)LIKE UPPER(?) AND UPPER(A.REASON_DESC) LIKE UPPER(?) ORDER BY 1";	
	}

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = document.forms[0].oh_failure.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
 	retVal = CommonLookup(tit_flag,argumentArray);
	if(retVal != null && retVal != "" ){
		//Commented by Sridevi Joshi on 5/24/2010 for IN021549
		/*var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		document.forms[0].oh_failure.value=arr[1];
		*/

		obj.value = retVal[0];//Added by Sridevi Joshi on 5/24/2010 for IN021549
		document.forms[0].oh_failure.value=retVal[1];//Added by Sridevi Joshi on 5/24/2010 for IN021549

	}else{
		target.value="";
		obj.value="";
	}
 }


