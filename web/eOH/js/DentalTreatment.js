var function_id = "" ;
var result = false; 
var message = "" ;
var flag = "" ;
var qry_string = "";
var tab_name = "T";
var area_legend;
var refresh_yn="Y";
var hasChanged = false;
var schedule_yn_flag=false;
var isPartiallyErupted = false;
var isErupted = false;


function setValuesFromMenu(type,site,code,arch_quad,thrng_nos,ref_tooth_no,tooth_numbering_system,permanent_deciduous_flag,status,outcome,surface,billed_yn,billing_appl_yn,flag,oh_chart_level,cusp_tip_code,maxila_area,maxila_parts,maxila_sub_parts,failure_remarks){
	var formObj = document.forms[0];

	//alert("contextPath:=="+contextPath);
	//alert("retieveSesion:=="+retieveSesion);
	var super_tooth_ref = formObj.super_tooth_ref.value;
	var date_diff_flag = "";
	if(formObj.date_diff_flag != null && formObj.date_diff_flag != "null"){
		date_diff_flag = formObj.date_diff_flag.value;
	}
	else{
		date_diff_flag ="";
	}

	formObj.oh_category.value = type;			  
	populateTreatments(formObj.oh_category);

	if(code != null && code != "null" && code != "undefined"){
		formObj.oh_treatment.value = code;
	}

	populateConditionCode(formObj.oh_category,formObj.oh_treatment)//Added by Sridevi Joshi on 2/10/2010 for IN010871(SRR20056-CRF-0478)
	populateSiteOptions(formObj.oh_category);
	formObj.oh_site.value = site;
	
	
	getAreaLegend(formObj.oh_site,thrng_nos);
	if(formObj.oh_site.value == "THRNG" || formObj.oh_site.value == "TOOTH" || formObj.oh_site.value == "MAXFS"){//if condition added by parul(when u click on CROWN/ROOT trmt from RHS tooth no is coming null after recording of tooth range)
		var MD_area =  populateArea(formObj.oh_site,tooth_numbering_system,permanent_deciduous_flag,ref_tooth_no,thrng_nos,flag,formObj.thrng_nos_ref.value,'',super_tooth_ref);
	}else{
		var thrng_nos="";
		var MD_area =  populateArea(formObj.oh_site,tooth_numbering_system,permanent_deciduous_flag,ref_tooth_no,thrng_nos,flag,formObj.thrng_nos_ref.value,'',super_tooth_ref);
	}

	//added by parul for CRF 701 on 23/09/2009
	if(formObj.oh_site.value == "MAXFS"){
		var surface_legend = getLabel("eOH.Parts.Label","OH");
		document.getElementById("surface_field").innerHTML ="<td><select name='oh_surface' id='oh_surface' onchange='populateSubParts(this);countSurface();clearDentalcondition(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select>&nbsp;<select name='oh_sub_parts' id='oh_sub_parts' onchange='clearDentalcondition(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select>&nbsp;<img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'></td>"
		
		document.getElementById("change_surface").innerHTML = surface_legend;
	
	}
	if(formObj.oh_site.value == "ARCH" || formObj.oh_site.value == "QUAD"){
		formObj.oh_area.value = arch_quad;

		//These values for the hidden variables
		formObj.area.value = arch_quad;
	}
	else if(formObj.oh_site.value == "THRNG"){
		formObj.oh_area.value = thrng_nos;

		//These values for the hidden variables
		formObj.area.value = thrng_nos;
	}else if(formObj.oh_site.value == "MAXFS"){
		formObj.oh_area.value = maxila_area;

		//These values for the hidden variables
		formObj.area.value = maxila_area;
	}
	else{
		formObj.oh_area.value = ref_tooth_no;

		//These values for the hidden variables
		formObj.area.value = ref_tooth_no;
	}

	if(MD_area != ""){
		formObj.oh_area.value = MD_area;
		//formObj.oh_area.value = thrng_nos

		//These values for the hidden variables
		formObj.area.value = MD_area;
	}
	

	if(formObj.oh_site.value == "MAXFS"){//added by parul for CRF 701 on 23/09/2009
		if(maxila_sub_parts!="" || maxila_sub_parts!="null" || maxila_sub_parts!=null){
			populateSurfaces(formObj.oh_area);
			populateSubParts(formObj.oh_surface,maxila_parts);
			populateSelectedSubParts(formObj.oh_sub_parts,maxila_parts,maxila_sub_parts,ref_tooth_no);
			formObj.oh_surface.value = maxila_parts;
			formObj.oh_sub_parts.value = maxila_sub_parts;
			if ((maxila_sub_parts=="THAB" || maxila_sub_parts=="THGM" || maxila_sub_parts=="THAG" || maxila_sub_parts=="THMF" || maxila_sub_parts=="THGAM") &&(maxila_sub_parts!="" || maxila_sub_parts!="null" && maxila_sub_parts!=null)){

				formObj.oh_selected_sub_parts.value = ref_tooth_no;
			}else {
				if (maxila_sub_parts=="TNGAB" || maxila_sub_parts=="TNGGM" || maxila_sub_parts=="TNGAG" || maxila_sub_parts=="TNGGAM" || maxila_sub_parts=="TNGMF"){
					document.getElementById("surface_field").innerHTML = "<select name='oh_surface' id='oh_surface' onChange='populateSubParts(this)'></select>&nbsp;<select name='oh_sub_parts' id='oh_sub_parts' onChange='populateSelectedSubParts(this)'></select>&nbsp;<input type='text' name='oh_selected_sub_parts' id='oh_selected_sub_parts' onBlur='chkSelcetedForSuperRDyn(this);' value='"+thrng_nos+"'><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>";
				}else{

					document.getElementById("surface_field").innerHTML = "<select name='oh_surface' id='oh_surface' onChange='populateSubParts(this)'></select>&nbsp;<select name='oh_sub_parts' id='oh_sub_parts' onChange='populateSelectedSubParts(this)'></select><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>";
				
				}

			clear_list(document.forms[0].oh_surface); 
			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
			optSel.value= ''; 
			document.forms[0].oh_surface.add(optSel);

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "area_val="+maxila_area;
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
				document.forms[0].oh_surface.value = maxila_parts;
				
			}


			clear_list(document.forms[0].oh_sub_parts); 
			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
			optSel.value= ''; 
			document.forms[0].oh_sub_parts.add(optSel);

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			/*if (oh_surface_1=="" || oh_surface_1=="null" || oh_surface_1==null){
				oh_surface_1=maxila_parts;
			}*/
			var params = "parts="+maxila_parts;
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
					document.forms[0].oh_sub_parts.value = maxila_sub_parts;

				}
		
			}
		}else{
			populateSurfaces(formObj.oh_area);
			populateSubParts(formObj.oh_surface,maxila_parts);
			formObj.oh_surface.value = maxila_parts;
		}
	}else{
		if(formObj.oh_area.value != "" && formObj.oh_area.value != "undefined" && formObj.oh_area.value != undefined){ //Added by Sridevi Joshi on 4/26/2010 for PE..Surface has to be populated only when area value is not null
			populateSurfaces(formObj.oh_area);//commented by parul forCRF-442 on 20/01/2010
		}
		formObj.oh_surface.value = surface;
	}
	enableDisableSurface(formObj.oh_site);

	if(formObj.oh_surface.value != "" && formObj.oh_surface.value != "undefined" && formObj.oh_surface.value != undefined){ //Added by Sridevi Joshi on 4/26/2010 for PE..Cusptip has to be populated only when surface value is not null 
		populateCuspTip(formObj.oh_surface);
	}

	formObj.oh_cusp_tip.value = cusp_tip_code;
	enableDisableCuspTip(formObj.oh_site);

	if(status == "25" && (outcome == "" || outcome == null || outcome == "null") && document.getElementById("outcome_label") != null){
		var success = getLabel("Common.Success.label","Common");
		var failure = getLabel("Common.Failure.label","Common");
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

	if(status == "60" || status == "85" &&( formObj.oh_task == null || formObj.oh_task == "null")){
		if(formObj.oh_outcome != null && formObj.oh_outcome != "null"){
			formObj.oh_outcome.value = outcome;
			if (outcome=="F"){//added by parul on 17/02/2010 for CRf-477
				formObj.oh_outcome.disabled=true;
				//added by parul on 28/02/2010 for CRF-477
				document.getElementById("reason_field").style.visibility = 'visible';
				document.getElementById("change_reason").style.visibility = 'visible'; 
				document.getElementById("reason_field").innerHTML="<textarea name='oh_failure' rows='3' cols='50' >"+failure_remarks+"</textarea>";
				formObj.oh_failure.readOnly = true;

			}
		}
	}

	if(formObj.oh_site.value == "MAXFS"){//added by parul for CRF 701 on 23/09/2009
			surface = maxila_parts;
	}
	
	if(formObj.called_from_viewchart_yn.value == 'Y' || date_diff_flag == "disable"){
	
		if (surface=="*A"){
			var retVal_surface=getLabel("eOH.AllSurfaces.Label","OH");
			document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" ><option value="">'+retVal_surface+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';
			
		}else{
			
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "surface_code="+surface;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=displaySurfacesDescription&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_surface = trimString(xmlHttp.responseText);
				var retVal_surface_arr1 = new Array();
				if(retVal_surface.length>1){
					if(retVal_surface.indexOf("~")!=-1){
						/*var retVal_surface_arr=retVal_surface.replace("~",",");
						var retVal_surface_arr1=retVal_surface_arr.replace("~",",");
						var retVal_surface_arr3=retVal_surface_arr1.replace("~",",");
						var val_surface=retVal_surface_arr3.substring(0,retVal_surface_arr3.length-1);
						var retVal_surface_arr2=val_surface.substring(0,val_surface.lastIndexOf(','));*/


						//var retVal_surface_arr=retVal_surface.split("~");

						// added for incident 19678 on 01/03/2010

						var retVal_surface_arr = retVal_surface.split("~");
						var len = retVal_surface_arr.length
						var j = 0;
						for(var i=1; i < len; i++){
							if(len > 1){
								retVal_surface_arr1[j] = retVal_surface_arr[j];
								j++;
							}
						}


						document.getElementById("surface_field").innerHTML="<input type='text' name='oh_surface' id='oh_surface'  value='"+retVal_surface_arr1+"'><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>";
					
					}else{

						//document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" value=""><option value="">'+retVal_surface+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';

						document.getElementById("surface_field").innerHTML="<input type='text' size='10' name='oh_surface' id='oh_surface'  value='"+retVal_surface+"'><img id='MandatorySurface'  src='../../eCommon/images/mandatory.gif'>";
					}
				}
	//end
		}
		if(formObj.oh_site.value == "MAXFS"){//added by parul for CRF 701 on 23/09/2009
			formObj.oh_surface.value = maxila_parts;
			formObj.oh_sub_parts.value = maxila_sub_parts;
			if  (maxila_sub_parts=="THAB" || maxila_sub_parts=="THGM" || maxila_sub_parts=="THAG" || maxila_sub_parts=="THMF" || maxila_sub_parts=="THGAM"){
				formObj.oh_selected_sub_parts.value = ref_tooth_no;
				formObj.oh_selected_sub_parts.disabled = true;

			}else if(maxila_sub_parts=="TNGAB" || maxila_sub_parts=="TNGGM" || maxila_sub_parts=="TNGAG" || maxila_sub_parts=="TNGGAM" || maxila_sub_parts=="TNGMF"){
				formObj.oh_selected_sub_parts.value = thrng_nos;
				formObj.oh_selected_sub_parts.disabled = true;

			}
			formObj.oh_sub_parts.disabled = true;
		}

		if(cusp_tip_code != "" && cusp_tip_code != "undefined" && cusp_tip_code != undefined){ //Added by Sridevi Joshi on 4/26/2010 for PE ---cusp tip has to be displyed only when cusp_tip_code is not null
		//added by parul for CRF#0483 on 24/08/2009
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "cusp_tip_code="+cusp_tip_code;

			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=displayCuspTip&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			var retVal_cupsTips_arr1 = new Array();
			if(retVal.length>1){
				if(retVal.indexOf("~")!=-1){
				/*	var retVal_arr=retVal.replace("~",",");
					var retVal_arr1=retVal_arr.replace("~",",");
					var retVal_arr3=retVal_arr1.replace("~",",");
					var val=retVal_arr3.substring(0,retVal_arr3.length-1);
					var retVal_arr2=val.substring(0,val.lastIndexOf(','))*/

					// added on 09/03/2010 for incident 19854
					
					var retVal_arr=retVal.split("~");
					var retVal_cupsTips_arr = retVal.split("~");
					var len = retVal_cupsTips_arr.length
					var j = 0;
					for(var i=1; i < len; i++){
						if(len > 1){
							retVal_cupsTips_arr1[j] = retVal_cupsTips_arr[j];
							j++;
						}
					}

					document.getElementById("cusp_field").innerHTML="<input type='text' name='oh_cusp_tip' id='oh_cusp_tip' size='40' value='"+retVal_cupsTips_arr1+"'>";
				
				}else{
					document.getElementById("cusp_field").innerHTML="<input type='text' name='oh_cusp_tip' id='oh_cusp_tip' maxlength='1' value='"+retVal+"'>";			
				}
			}
		}

		if (cusp_tip_code=="" || cusp_tip_code=="null" ||cusp_tip_code==null){
			var cusp_label=getLabel("eOH.DefaultSelect.Label","OH");
			document.getElementById("cusp_field").innerHTML ='<select name="oh_cusp_tip" id="oh_cusp_tip"  size=3 multiple value=""><option value="">'+cusp_label+'</option></select>';
		}
		
		formObj.oh_category.disabled = true;
		formObj.oh_area.disabled = true;
		formObj.oh_site.disabled = true;
		formObj.oh_treatment.disabled = true;
		formObj.oh_surface.disabled = true;
		
		formObj.oh_cusp_tip.disabled = true;
		//formObj.oh_cusp_tip.readOnly = true;//added by parul for CRF#0483 on 24/08/2009
		if(formObj.called_from_viewchart_yn.value == 'Y' && formObj.oh_task != null && formObj.oh_task != "null"){
			formObj.oh_task.disabled = true;
		}
	}

	//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	var treatment_flag = formObj.treatment_flag.value;

	//Remove mandatory image when called from RHS menu
	if(type == "OTHERS" && formObj.called_from_viewchart_yn.value == 'Y'){ // For Trmt type OTHERS 
		if(document.getElementById("AreaMandatory")!=null){
			document.getElementById("AreaMandatory").style.visibility = 'hidden';
		}
	}

	//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	var row = document.getElementById("add_data");
	if(row != null){
		if (row.style.display == '') {
			row.style.display = 'none';	
		}
		else 
		{
			row.style.display = '';  
		}
	}
	
	if(formObj.trmt_done_yn.value != "Y" && formObj.baseline_chart_yn.value != "Y" && formObj.date_diff_flag.value != "disable"){//Condition for baseline_chart_yn is added by Sridevi Joshi on 5/31/2010 for IN021668
		formObj.treatment_status.disabled = false;
	}

	//Added by Sridevi Joshi for IN014258 ---- to make Remarks for some of the trmts mandatory.It was coming when selected from dataentry but not from menu
	var mand_area = formObj.area.value;
	checkForMaxilla(formObj.oh_category,mand_area); //mand_area added by Sridevi Joshi on 10/29/2009 for IN015842
	
	//Added by Sharon Crasta on 10/22/2009 for IN012603(PMG20089-CRF-0700)
	var patient_id = formObj.patient_id.value; 
	var other_chart_facility_id = formObj.other_chart_facility_id.value; 
	var chart_num = formObj.chart_num.value;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getDentistComments&"+params,false);
	xmlHttp.send(xmlDoc);
	var dentist_comments_retVal = localTrimString(xmlHttp.responseText);
	formObj.dentist_comments.value = dentist_comments_retVal;

	//Added by Sharon Crasta on 12/11/2009 for IN016953
	var trmt_status_extraction = formObj.trmt_status_param_extraction.value;
	if(trmt_status_extraction == "E"){
		formObj.treatment_status.value = trmt_status_extraction;
	 	clear_list(document.forms[0].treatment_status); 
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("Common.cancel.label","Common");
		optSel.value= "E"; 
		document.forms[0].treatment_status.add(optSel);
		document.getElementById("showCancelForReason").style.visibility = 'visible';
		document.getElementById("mandatoryReason").style.visibility = 'visible';
		if(status == "15"){
			document.getElementById("edit_charges").style.visibility = 'hidden';
		}
		var save_legend = getLabel("Common.record.label","common_labels");
		var reset_legend = getLabel("Common.reset.label","common_labels");
		document.getElementById("save_reset_button").innerHTML = '<input type="button" class="button" name="save" id="save" value="'+save_legend+'" onclick ="actionToServlet(\''+formObj.treatment_status.value+'\');">&nbsp;<input type="button" class="button" name="'+reset_legend+'" id="'+reset_legend+'" value="Reset" onclick="Treatment_Reset(document.forms[0])">';
	  }	//End
	
}

function changeStatus(obj){
	var save_legend = "";
	var reset_legend = getLabel("Common.reset.label","common_labels");
	//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
	var formObj = document.forms[0];
	var treatment_status_param = formObj.treatment_status_param.value;
	var treatment_flag = formObj.treatment_flag.value;
	var record_trmt_button_disabled = formObj.record_trmt_button_disabled.value;
	var billing_appl_yn = formObj.billing_appl_yn.value;
	
	var appt_reqd_yn = formObj.appt_reqd_yn.value;// Added by Sharon Crasta on 10/16/2008 To retrieve the schedule appointment required value set in Order Catalog.
	if((obj.value == "E" ||obj.value == "A") || treatment_flag == "Y" ) {
		var edit_charges_text =  document.getElementById("edit_charges");
		if(edit_charges_text != "" && edit_charges_text != "null" && edit_charges_text != null){
			 document.getElementById("edit_charges").style.visibility = 'hidden';
		}
		
	}
	
	if(obj.value == "E"){
		save_legend = getLabel("Common.record.label","common_labels");
		document.getElementById("add_data").style.visibility = 'hidden';
		document.getElementById("add_data").style.display = 'none';
		document.getElementById("showCancelForReason").style.visibility = 'visible';
		document.getElementById("showCancelForReason").style.display = 'block';
		document.getElementById("mandatoryReason").style.visibility = 'visible';
	}

	//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	else if(obj.value == "A"){
		save_legend = getLabel("Common.record.label","common_labels");
		var row1 = document.getElementById("start_end_add_data");
		if(treatment_status_param>=25){//added by parul on 08/06/2010 for IN021923
			document.getElementById("performed_ot").style.visibility = 'hidden';
			document.getElementById("performed_ot_chk").style.visibility = 'hidden';
		}//end
		if(row1 != null){
			row1.style.display = 'none';
			document.getElementById("add_data").style.visibility = 'visible';
			document.getElementById("add_data").style.display = 'block';
			document.getElementById("showCancelForReason").style.visibility = 'hidden';
			document.getElementById("mandatoryReason").style.visibility = 'hidden';

			


		}
		else
		{
			row1.style.display = '';    
		}
	}
//	else if(obj.value == "10" && appt_reqd_yn == "Y" ){
	else if(obj.value == "10" && appt_reqd_yn == "Y" && treatment_status_param == "10" ){
		save_legend = getLabel("Common.Schedule.label","common_labels");
		document.getElementById("showCancelForReason").style.visibility = 'hidden';
		document.getElementById("mandatoryReason").style.visibility = 'hidden';
		
		document.getElementById("add_data").style.visibility = 'hidden';//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	}
	//Added by Sharon Crasta on 2/27/2010 for SRR20056-CRF-0485(IN010920)
	else if(obj.value == "10" && appt_reqd_yn == "Y"  && treatment_status_param == "15" ){
		save_legend = getLabel("Common.Register.label","common_labels");
		document.getElementById("showCancelForReason").style.visibility = 'hidden';
		document.getElementById("mandatoryReason").style.visibility = 'hidden';
		
		document.getElementById("add_data").style.visibility = 'hidden';//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	}
	else if (obj.value == "10" && appt_reqd_yn == "N"){//  Added by Sharon Crasta on 10/16/2008 If the Schedule is not applicable, then the Register legend should be displayed after a task is recorded.
		save_legend = getLabel("Common.Register.label","common_labels");
		document.getElementById("showCancelForReason").style.visibility = 'hidden';
		document.getElementById("mandatoryReason").style.visibility = 'hidden';
		
		document.getElementById("add_data").style.visibility = 'hidden';//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	}
	else if(obj.value == "15"){
		if(treatment_flag != "Y"){
			save_legend = getLabel("Common.Register.label","common_labels");
		}else{
			save_legend = getLabel("Common.record.label","common_labels");
		}
		document.getElementById("showCancelForReason").style.visibility = 'hidden';
		document.getElementById("mandatoryReason").style.visibility = 'hidden';

		document.getElementById("add_data").style.visibility = 'hidden';//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
		if(treatment_status_param != "" && treatment_status_param != "null" && treatment_status_param != null){
			if(treatment_flag != "Y"){
				document.getElementById("edit_charges").style.visibility = 'visible';
				document.getElementById("edit_charges").style.display = 'block';
			}
		}
	}
	else if(obj.value == "25" ||obj.value == "52" || obj.value == "55" || obj.value == "60" || obj.value == "80"){
		save_legend = getLabel("eOR.ResultEntry.label","or_labels");
		document.getElementById("showCancelForReason").style.visibility = 'hidden';
		document.getElementById("mandatoryReason").style.visibility = 'hidden';
		
		document.getElementById("add_data").style.visibility = 'hidden';//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
		//added by parul on 08/06/2010 for IN021923
		document.getElementById("performed_ot").style.visibility = 'visible';
		document.getElementById("performed_ot_chk").style.visibility = 'visible';
		var row = document.getElementById("add_data");
		if(row != null){
			
			row.style.display = 'none';
			document.getElementById("start_end_add_data").style.visibility = 'visible';
			document.getElementById("start_end_add_data").style.display = 'block';
			if(billing_appl_yn=="Y"){//added by parul on 02/06/2010 for IN021703(is task is billable than only it shloud it come)
				document.getElementById("edit_charges").style.visibility = 'visible';
				document.getElementById("edit_charges").style.display = 'block';
			}
		}
		else{
			row.style.display = '';    
		}
   	}
	else{
		save_legend = getLabel("Common.record.label","common_labels");
		document.getElementById("showCancelForReason").style.visibility = 'hidden';
		document.getElementById("mandatoryReason").style.visibility = 'hidden';
		
		document.getElementById("add_data").style.visibility = 'hidden';//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	}

	if(obj.value == "A" || obj.value == "E"){//Added on  6/21/2010 by Sridevi joshi for IN022260
		document.getElementById("save_reset_button").innerHTML = '<input type="button" class="button" name="save" id="save" value="'+save_legend+'" onclick ="actionToServlet(\''+obj.value+'\');">&nbsp;<input type="button" class="button" name="'+reset_legend+'" id="'+reset_legend+'" value="Reset" onclick="Treatment_Reset(document.forms[0])">';
	}
	else{
		//obj.value is replaced by treatment_status_param on 6/21/2010 by Sridevi joshi for IN022260
		document.getElementById("save_reset_button").innerHTML = '<input type="button" class="button" name="save" id="save" value="'+save_legend+'" onclick ="actionToServlet(\''+treatment_status_param+'\');">&nbsp;<input type="button" class="button" name="'+reset_legend+'" id="'+reset_legend+'" value="Reset" onclick="Treatment_Reset(document.forms[0])">';
	}
	
	// Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480) Inorder to disable the button on change from Cancel to the <order status> on click of treatment.
	if(treatment_flag == "Y" && obj.value != "E"){
		 formObj.save.disabled = true;
	}
	
}

function checkForMaxilla(obj,MD_area){//MD_area added by Sridevi Joshi on 10/29/2009 for IN015842
	if((obj.value=="ORALCVT" || obj.value=="PERIO") && MD_area != ""){//MD_area added by Sridevi Joshi on 10/29/2009 for IN015842
		if(document.getElementById("AreaMandatory") != null){
			document.getElementById("AreaMandatory").style.visibility = 'visible';
		}
	}

	if(MD_area != ""){//Added by Sridevi Joshi on 10/29/2009 for IN015842
		if(document.getElementById("AreaMandatory") != null){
			document.getElementById("AreaMandatory").style.visibility = 'visible';
		}
	}
	else{//Added by Sridevi Joshi on 10/29/2009 for IN015842
		if(document.getElementById("AreaMandatory") != null){
			document.getElementById("AreaMandatory").style.visibility = 'hidden';
		}
	}

	if(obj.value == "MAXILLA" || obj.value=="ORALCVT" || obj.value=="PERIO" || obj.value=="OTHERS"){
		if(document.getElementById("MandatoryRemarks") != null && document.getElementById("MandatoryRemarks") != "null"){
			document.getElementById("MandatoryRemarks").style.visibility = 'visible';
		}
	}else{
		if(document.getElementById("MandatoryRemarks") != null && document.getElementById("MandatoryRemarks") != "null"){//Added by Sridevi Joshi for IN014258 ---- getting script error when we select trmt from dataentry for which Remarks is not mandatory.
			document.getElementById("MandatoryRemarks").style.visibility = 'hidden';
		}
	}
}

async function showOperRemarks(title,locale){
	var readOnlyYN = "N";
	var remarks = document.forms[0].remarks.value;
	var remarks_hid = document.forms[0].remarks.value;
	remarks = encodeURIComponent(remarks);

	var called_from_viewchart_yn = document.forms[0].called_from_viewchart_yn.value;
	var date_diff_flag = document.forms[0].date_diff_flag.value;

	if(called_from_viewchart_yn == "Y" || date_diff_flag == "disable"){
		readOnlyYN = "Y";
	}else{
		readOnlyYN = "N";
	}
	
	remarks = encodeURIComponent(remarks);

	title = encodeURIComponent(title);
	
	var retVal =await window.showModalDialog("../../eOH/jsp/TextArea.jsp?heading="+title+"&remarks="+remarks+"&readOnlyYN="+readOnlyYN,window,"dialogHeight: 50vh; dialogWidth:65vw; center: yes; help: no; resizable: no; status: no;");
	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM"){ // This when the user closed the TeaxtArea window with above 'X' 
		document.forms[0].remarks.value = remarks_hid;
	}
	else{
		document.forms[0].remarks.value = retVal;
	}

} 

async function showReasonForCancel(title){
	var reasonforcancel = document.forms[0].reasonforcancel.value;
	var remarks_hid = document.forms[0].reasonforcancel.value;

	reasonforcancel = encodeURIComponent(reasonforcancel);
	title = encodeURIComponent(title);

	var retVal = await window.showModalDialog('../../eOH/jsp/TextArea.jsp?heading='+title+'&remarks='+reasonforcancel+'&readOnlyYN=N',window,"dialogHeight: 50vh; dialogWidth:65vw; center: yes; help: no; resizable: no; status: no;");

//	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM"){ // This when the user closed the TeaxtArea window with above 'X' 
//		document.forms[0].reasonforcancel.value = remarks_hid;
//	}
//	else{
//		document.forms[0].reasonforcancel.value = retVal;
//	}

	retVal = encodeURIComponent(retVal);
	var retVal1 = decodeURIComponent(retVal);

	retVal1 = trimString(retVal1);
	if( retVal1 == "undefined" || retVal1 == "CL_REM" || retVal1 == "" || retVal1 == undefined || retVal1 == " "){ // This when the user closed the TeaxtArea window with above 'X' 
		document.forms[0].reasonforcancel.value = remarks_hid;
	}
	else{
		document.forms[0].reasonforcancel.value = retVal;
	}
	
}

//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700
async function showDentistComments(locale){
	var readOnlyYN = "N";
	var dentistComments = document.forms[0].dentist_comments.value;
	var dentistComments_hid = document.forms[0].dentist_comments.value;
	dentistComments = encodeURIComponent(dentistComments);
	var called_from_viewchart_yn = document.forms[0].called_from_viewchart_yn.value;
	var date_diff_flag = document.forms[0].date_diff_flag.value;

	if(called_from_viewchart_yn == "Y" || date_diff_flag == "disable"){
		readOnlyYN = "Y";
	}else{
		readOnlyYN = "N";
	}
	
	
	dentistComments = encodeURIComponent(dentistComments);

	title = getLabel("eOH.DentistComments.Label","OH");
	
	var retVal = await window.showModalDialog("../../eOH/jsp/TextArea.jsp?heading="+title+"&remarks="+dentistComments+"&readOnlyYN="+readOnlyYN+"&flagForPrint=Y",window,"dialogHeight: 50vh; dialogWidth:65vw; center: yes; help: no; resizable: no; status: no;");
	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM"){ // This when the user closed the TeaxtArea window with above 'X' 
		document.forms[0].dentist_comments.value = dentistComments_hid;
	}
	else{
		document.forms[0].dentist_comments.value = retVal;
	}
}	

//commented by parul on 070109 for multiple surface
/*function enableDisableSurface(obj){
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
*/

function enableDisableSurface(obj){
	var formObj = document.forms[0];
	var oh_category = formObj.oh_category.value;
	if(obj.value != null ){
		if(obj.value == 'ROOT' || obj.value == 'CROWN'){
			
           if(oh_category == "ROOTTMT" ){//if condition added by parul for surface on 070109
			    if (document.forms[0].oh_surface.options.length==1) {
					formObj.oh_surface.disabled = true;
					document.getElementById("MandatorySurface").style.visibility = 'hidden';
			}
		}
			else{
				formObj.oh_surface.disabled = false;
				document.getElementById("MandatorySurface").style.visibility = 'visible';
			}
		}else{
			document.forms[0].oh_surface.disabled = true;
		}
	}
}

function populateSiteOptions(obj,called_from){
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

		//To clear thrng_nos_ref once the trmt category is changes
		document.forms[0].thrng_nos_ref.value = "";
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
	}

	if(called_from == "onSelectCategory"){
		parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	}
}

function populateSurfaces(obj){
    var formObj = document.forms[0];
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var ext_perm_loc_param = formObj.ext_perm_loc_param.value;
	var status_for_ext_loc = formObj.treatment_status_param.value;
	var status_for_ext_loc_int = parseInt(status_for_ext_loc);
	var trmt_yn = formObj.treatment_flag.value;
	var trmt_done_yn = formObj.trmt_done_yn.value;
	var trmt_code = formObj.oh_treatment.value;
	var surface_label=getLabel("eOH.DefaultSelect.Label","OH");
	
	if(ext_perm_loc_param == "Y" || (status_for_ext_loc_int >=25 && trmt_yn !="Y" && trmt_done_yn != "Y")){//Added by Sridevi Joshi for CRF-702(IN012606)
		var dentalchartFormObj = parent.parent.trmtDentalChartDetails;
	}else{
		if(parent.trmtDentalChartDetails != "undefined" && parent.trmtDentalChartDetails != undefined && parent.trmtDentalChartDetails != null){
			var dentalchartFormObj = parent.trmtDentalChartDetails;	//Commented above and added by Sridevi Joshi for IN016707 on 11/30/2009	
		}else{
			var dentalchartFormObj = parent.parent.trmtDentalChartDetails;//Commented above and added by Sridevi Joshi for IN016707 on 11/30/2009	
		}
	}
	var site_type_val = formObj.oh_site.value;
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	
	var tooth_no_val = obj.value;
	var tooth_layer = "toothLayer"+tooth_no_val;
	var root_layer = "rootLayer"+tooth_no_val;
	var surface_applicable_yn = 'Y';
	var retVal_surface="";
	
	if(site_type_val == "CROWN"){
	/*	 var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_val;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=ChkAllsurfacePopulation&"+params,false);
			xmlHttp.send(xmlDoc);
			retVal_surface = trimString(xmlHttp.responseText);
			retVal_surface = localTrimString(retVal_surface);
	
		if(retVal_surface=="*A" && (dentalchartFormObj.document.getElementById(tooth_layer) == null || dentalchartFormObj.document.getElementById(tooth_layer) == "" || dentalchartFormObj.document.getElementById(tooth_layer) == "null" ||dentalchartFormObj.document.getElementById(tooth_layer) == "undefined")){
		   surface_applicable_yn = "N";
		
		}else if(retVal_surface=="*A" && (dentalchartFormObj.document.getElementById(tooth_layer) != null || dentalchartFormObj.document.getElementById(tooth_layer) != "" || dentalchartFormObj.document.getElementById(tooth_layer) != "null" ||dentalchartFormObj.document.getElementById(tooth_layer) != "undefined")){
			 surface_applicable_yn = "Y";
		}else{
		   surface_applicable_yn = "N";
		
		}*/

			/*//Commented by Sridevi Joshi on 2/19/2010 for IN019472
			if(dentalchartFormObj.document.getElementById(tooth_layer) == null || dentalchartFormObj.document.getElementById(tooth_layer) == "" || dentalchartFormObj.document.getElementById(tooth_layer) == "null" ||		dentalchartFormObj.document.getElementById(tooth_layer) == "undefined"){
				surface_applicable_yn = "N";
			}*/


	}
	/*//Commented by Sridevi Joshi on 2/19/2010 for IN019472
	else if(site_type_val == "ROOT"){ 
		if(dentalchartFormObj.document.getElementById(root_layer) == null || dentalchartFormObj.document.getElementById(root_layer) == "" || dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == "undefined"){
			surface_applicable_yn = "N";
		}
	} */

	/* By Sridevi Joshi for IN009202(SRR20056-CRF-0454-OH) on 04/08/09.....To Remove surfaces from the list box when Deciduous tooth EXFOLTH and Permanent tooth ERUPTH.Applicable only for tooth 33,34,41,42,43,44,51,52 */
	if(site_type_val == "ROOT" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
		if(tooth_no_val == "33" || tooth_no_val == "34" || tooth_no_val == "41" || tooth_no_val == "42" || tooth_no_val == "43" || tooth_no_val == "44" || tooth_no_val == "51" || tooth_no_val == "52"){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_val;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkROOTINVOnDecth&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal = localTrimString(retVal);
			if(retVal.length > 0 && retVal == "Y"){
				surface_applicable_yn = "N";
			}
		}
	}
	/* End */
	clear_list(document.forms[0].oh_surface); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_surface.add(optSel);
	var retVal="";
	var retVal_applicable="";
	if (surface_applicable_yn=="Y"){
		if(trmt_code != "" && trmt_code != "undefined" && trmt_code != undefined){//Added by Sridevi Joshi on 4/26/2010 for PE
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
		//added by parul on 20/01/2010 for CRF-422
		if (retVal_applicable=="Y"){	
			var retVal_surface=getLabel("eOH.AllSurfaces.Label","OH");
			document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" ><option value="">'+retVal_surface+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';
			formObj.surface_ref.value="*A";
			formObj.oh_surface_hid.value="*A";//Added by Sridevi Joshi on 8/20/2010 for IN023363
			populateCuspTip();
			formObj.oh_surface.disabled = true;
		}else{
			if (trmt_code!=""){
				if(site_type_val == "MAXFS"){ //Added by Sridevi Joshi on 3/3/2010 for IN019598
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "site_type_val="+site_type_val+"&tooth_no_val="+tooth_no_val;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSurfaces&"+params,false);
					xmlHttp.send(xmlDoc);
					retVal = trimString(xmlHttp.responseText);
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
						 formObj.oh_surface.disabled = false;// written by parul on 070109 
					}
					else{
						formObj.oh_surface.disabled = true;// written by Sridevi on 20/10/09 if there is no value in surface than it should be disable
						document.getElementById("MandatorySurface").style.visibility = 'hidden';
					}
				}
				else{
					var surface_label=getLabel("eOH.DefaultSelect.Label","OH");
					document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" size=3 multiple  onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "site_type_val="+site_type_val+"&tooth_no_val="+formObj.oh_area.value;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSurfaces&"+params,false);
					xmlHttp.send(xmlDoc);
					retVal = trimString(xmlHttp.responseText);
					tooth_layer = "toothLayer"+formObj.oh_area.value;
					if(retVal.length>1){
						 if (site_type_val=="CROWN"){
							document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" size=3 multiple  onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';

						}else{
							document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';	
						}					
						document.getElementById("MandatorySurface").style.visibility = 'visible';
						var retVal_arr = retVal.split("~");
						
						for(var i=0;i<retVal_arr.length-1;i++){
							var code_desc_arr = retVal_arr[i].split("##");
							var element 	= document.createElement('OPTION') ;
							element.value 	= code_desc_arr[0];
							element.text 	= code_desc_arr[1] ;
							document.forms[0].oh_surface.add(element);
						}
						 formObj.oh_surface.disabled = false;// written by parul on 070109 

						 document.getElementById("cusp_field").innerHTML ='<select name="oh_cusp_tip" id="oh_cusp_tip" size=3 multiple ><option value="">'+surface_label+'</option></select>';

					}else{
						if (site_type_val=="CROWN"){
							document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" size=3 multiple  onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';	
							document.getElementById("cusp_field").innerHTML ='<select name="oh_cusp_tip" id="oh_cusp_tip" size=3 multiple ><option value="">'+surface_label+'</option></select>';

						}else{
							document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';

							document.getElementById("cusp_field").innerHTML ='<select name="oh_cusp_tip" id="oh_cusp_tip" size=3 multiple ><option value="">'+surface_label+'</option></select>';
							formObj.oh_surface.disabled = true;
							formObj.oh_cusp_tip.disabled = true;

						}
						document.getElementById("MandatorySurface").style.visibility = 'hidden';
					}
				}
				
			}else{
				 if (site_type_val=="CROWN"){
						document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" size=3 multiple  onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';	
						
				}else{
					document.getElementById("surface_field").innerHTML ='<select name="oh_surface" id="oh_surface" onChange="populateCuspTip(this)"><option value="">'+surface_label+'</option></select><img id="MandatorySurface"  src="../../eCommon/images/mandatory.gif">';	

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "site_type_val="+site_type_val+"&tooth_no_val="+tooth_no_val;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSurfaces&"+params,false);
					xmlHttp.send(xmlDoc);
					 retVal = trimString(xmlHttp.responseText);
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
						 formObj.oh_surface.disabled = false;// written by parul on 070109 
					}
					else{
						formObj.oh_surface.disabled = true;// written by Sridevi on 20/10/09 if there is no value in surface than it should be disable
						document.getElementById("MandatorySurface").style.visibility = 'hidden';
					}
				}
				
			}
		}
	}else{
		formObj.oh_surface.disabled = true;// written by parul on 070109 if there is no value in surface than it should be disable
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
		optSel.text = getLabel("Common.Ordered.label","Common");
		optSel.value= '10'; 
		document.forms[0].treatment_status.add(optSel);
		//document.forms[0].treatment_status.disabled = true; //Commented by Sridevi Joshi for IN014258---Status was disabled when selecting from dataentry but when we select from menu it was enabled.

	}
	else{

		clear_list(document.forms[0].treatment_status); 
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
		optSel.value= ''; 
		document.forms[0].treatment_status.add(optSel);
		document.forms[0].treatment_status.disabled = false;
	}
}

/*function populateConditionCode(obj){
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
}*/

function populateConditionCode(obj,obj1){
	var trmt_category_type = obj.value;
	var trmt_code = obj1.value; //Added by Sridevi Joshi on 2/10/2010 for IN010871(SRR20056-CRF-0478)

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "condition_type="+trmt_category_type+"&trmt_code="+trmt_code;
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

	return retVal;
}

async function actionToServlet(treatment_status_param){
	var tooth_no ;
	var retained_tooth_no = "";
	var exfolth_count = 0;
	var retVal_SuperKey_count=0;
	var total_SuperKey_count=0;
	var super_recorded = "N";
	var check_cat_type = ""; //Added by Sridevi Jsohi on 2/12/2010 for IN010871(SRR20056-CRF-0478)
	var diff_den_tooth = "N";//Added by Sridevi Jsohi on 2/12/2010 for IN010871(SRR20056-CRF-0478)
	var failure_yn = "N";//Added by Sridevi Jsohi on 2/12/2010 for IN010871(SRR20056-CRF-0478)
	/* Added by Sridevi Joshi on 2/21/2010 for IN019472 */
	var unerth_rec = "";
	var parerth_rec = "";
	var erupth_rec = "";
	var exfolth_rec = "";
	var missth_rec = "";
	var impactn_rec = "";
	var impactn_rec = "";
	var extract_rec = "";
	var implant_rec = "";
	var denture_rec = "";
	var bridge_rec = "";
	var db_cond_type = "";
	var db_trmt_type = "";
	/* end for IN019472 */

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
	var result_entry_status = formObj.treatment_status_param.value;
	var chart_num = formObj.chart_num.value;
	var surface_code = formObj.oh_surface.value;
	var status_for_ext_loc = formObj.treatment_status_param.value;
	var status_for_ext_loc_int = parseInt(status_for_ext_loc);
	var trmt_yn = formObj.treatment_flag.value;
	var trmt_done_yn = formObj.trmt_done_yn.value;
	var ext_perm_loc_param = formObj.ext_perm_loc_param.value; //Added by Sridevi Joshi for CRF-702(IN012606)
	

	if(ext_perm_loc_param == "Y" || (status_for_ext_loc_int >=25 && trmt_yn !="Y" && trmt_done_yn != "Y")){//Added by Sridevi Joshi for CRF-702(IN012606)
		var dentalChartFormObj = parent.parent.trmtDentalChartDetails; //Added for CRF-702(IN012606) by Sridevi Joshi
	}else{
		var dentalChartFormObj = parent.trmtDentalChartDetails;
	}

	var thrng_nos_ref = formObj.thrng_nos_ref.value;

	var billing_appl_yn = formObj.billing_appl_yn.value;
	var diagcodeselected = formObj.diagcodeselected.value;//This is the string of selected diagnosis information...
	var comp_code_selected = formObj.comp_code_selected.value;//This is the string of selected materials information...
	var order_catalog_bill_yn = formObj.order_catalog_bill_yn.value;

	//Added by Sharon Crasta on 2/3/2009 - Variables passed to call Billing Window.
	var task_code = formObj.task_code.value;
	var bill_sub_regn_num = formObj.bill_sub_regn_num.value;
	var bill_sub_regn_line_num = formObj.bill_sub_regn_line_num.value;
	var ca_practitioner_id = formObj.ca_practitioner_id.value;
   	var facility_id = formObj.facility_id.value;
   	var called_from_viewchart_yn = formObj.called_from_viewchart_yn.value;
	var trmt_category_code = formObj.cat_code.value;//Added by Sridevi joshi on 2/11/2010 for IN010871(SRR20056-CRF-0478)
	var trmt_code = formObj.oh_treatment.value;//Added by Sridevi joshi on 2/11/2010 for IN010871(SRR20056-CRF-0478)

	var numbering_system = document.forms[0].tooth_numbering_system.value;
	var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
	var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
	var tooth_num = "";
	var tooth_name = "";
	var mapped_tooth_no = "";
	var oh_chart_level = document.forms[0].oh_chart_level.value;
	var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
	var super_tooth_ref = formObj.super_tooth_ref.value; //Added By Sridevi Joshi on 12/14/2009 for SUPRTH new Changes CRF-481(IN010894)
	var super_key_num = formObj.super_key_num.value; //Added By Sridevi Joshi on 12/14/2009 for SUPRTH new Changes CRF-481(IN010894)
	var surface_ref = formObj.surface_ref.value;//added by parul on 21/01/2010 for CRF-442
    //Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
	var location_code = document.forms[0].location_code.value;
	var location_type = document.forms[0].location_type.value;
	var task_seq_no = document.forms[0].task_seq_no.value;
	formObj.category.value = formObj.oh_category.value;
	formObj.site.value = formObj.oh_site.value;
	formObj.area.value = formObj.oh_area.value;
	formObj.treatment.value = formObj.oh_treatment.value;
	var tooth_range_count_for_order = 0;

	//added by parul on 23/08/2009 for CRF#483
	var oh_cusp_tip = formObj.oh_cusp_tip.value;
	var cusptip_ref = formObj.cusptip_ref.value;

	//added by parul on 11/02/2010 for CRF#477 & 496
	var treatments_outcome ="";
	if(status == "60" || status == "85" &&( formObj.oh_task == null || formObj.oh_task == "null")){
		if(formObj.oh_outcome != null && formObj.oh_outcome != "null"){
		     treatments_outcome = formObj.oh_outcome.value;
			  formObj.oh_outcome.value=treatments_outcome;
		}
	}//end 
    if (treatments_outcome=="F") {
		 var oh_failure=formObj.oh_failure.value;
     }
	
	if(called_from_viewchart_yn == "Y"){
		surface_code = formObj.surface_hid.value;  //Surface from RHS menu
		status = formObj.oh_status.value;
		cusptip_ref = formObj.cusp_tip_code_hid.value;
		surface_ref = formObj.surface_hid.value;//added by parul on 21/01/2010 for CRF-442
	}

	if(site_type == "THRNG" && thrng_nos_ref != ""){
		if(formObj.oh_area.value == ""){ 
			formObj.oh_area.options[0].selected =false;//added by parul for reopen 15725 on 03/11/2009
		}
		tooth_no = formObj.thrng_nos_ref.value;
		var thrng_nos_ref_arr = thrng_nos_ref.split(",");
		tooth_range_count_for_order = thrng_nos_ref_arr.length 
	}
	else if(site_type == "THRNG" && thrng_nos_ref == ""){
		tooth_range_count_for_order = formObj.oh_area.options.length 
		for (var m=0;m<formObj.oh_area.options.length; m++) {
			if (formObj.oh_area.options[m].selected == true) {
				formObj.oh_area.options[0].selected =false;     // unselecting   --select---  for 15725
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
		
	if(site_type == "MAXFS" && thrng_nos_ref != ""){
		if(typeof formObj.oh_selected_sub_parts!="undefined"&& formObj.oh_selected_sub_parts.value == ""){ 
			formObj.oh_selected_sub_parts.options[0].selected =false;// unselecting   --select---  for 15725
		}
		tooth_no = formObj.thrng_nos_ref.value;
		var thrng_nos_ref_arr = thrng_nos_ref.split(",");
		tooth_range_count_for_order = thrng_nos_ref_arr.length 
	}
	else if (site_type == "MAXFS"){
		if(formObj.oh_sub_parts.value=="TNGAB" || formObj.oh_sub_parts.value=="TNGGM" || formObj.oh_sub_parts.value=="TNGAG" ||			formObj.oh_sub_parts.value=="TNGGAM" || formObj.oh_sub_parts.value=="TNGMF"){
			if(thrng_nos_ref=="") {
				if(called_from_viewchart_yn != "Y"){
					for(var m=0;m<formObj.oh_selected_sub_parts.options.length;m++){
						formObj.oh_selected_sub_parts.options[0].selected =false;     // unselecting   --select---  for 15725
						if(formObj.oh_selected_sub_parts.options[m].selected==true){
							if(thrng_nos_ref==""){
								thrng_nos_ref=formObj.oh_selected_sub_parts.options[m].value;
							}else{
								thrng_nos_ref=thrng_nos_ref+","+formObj.oh_selected_sub_parts.options[m].value;
							}
						}
					}
					formObj.thrng_nos_ref.value = thrng_nos_ref;
					tooth_no = thrng_nos_ref;
				}
			}else{
				tooth_no = formObj.oh_selected_sub_parts.value;
			}
		}
		else{//Added by Sridevi Joshi on 4/5/2010 for IN020465 to get the tooth_no for tooth for Maxilla Treatment .tooth_no was coming as subparts
			if(formObj.oh_selected_sub_parts != null && formObj.oh_selected_sub_parts != "null"){//Added by Sridevi Joshi on 4/6/2010.. Was not able to record Maxilla for other than tooth and tooth range 
				tooth_no = formObj.oh_selected_sub_parts.value;
			}
		}
	}
	 //added by parul for SRR-CRF20056-0442 on 21/01/2010
	if(called_from_viewchart_yn != "Y"){
		//surface_ref="";//Commented this by Sridevi Joshi on 8/30/2010 for IN023363
		 if (surface_ref=="" || surface_ref=="null" || surface_ref==null || surface_ref=="undefined" || surface_ref==undefined){		
			for(var m=0;m<formObj.oh_surface.options.length;m++){
				 formObj.oh_surface.options[0].selected =false;  
			   if(formObj.oh_surface.options[m].selected==true){
				  
				  if(surface_ref==""){
				  surface_ref=formObj.oh_surface.options[m].value;

				 } else{
				  surface_ref=surface_ref+","+formObj.oh_surface.options[m].value;
				  }
			   }
		   }
		 formObj.surface_ref.value=surface_ref;
	   }else{
		  surface_ref=formObj.oh_surface.value;
	   }//end
	}

	 //written by parul for multiple cusp tip CRF#0483 on 23/08/2009
	      if (cusptip_ref=="") {		
	        for(var m=0;m<formObj.oh_cusp_tip.options.length;m++){
				formObj.oh_cusp_tip.options[0].selected =false;  
			   if(formObj.oh_cusp_tip.options[m].selected==true){
				   
			      if(cusptip_ref==""){
				  cusptip_ref=formObj.oh_cusp_tip.options[m].value;

                 } else{
				  cusptip_ref=cusptip_ref+","+formObj.oh_cusp_tip.options[m].value;
				 
				  }
			   }
           }
			formObj.cusptip_ref.value=cusptip_ref;
	   }else{
	      cusptip_ref=formObj.oh_cusp_tip.value;
		  if (cusptip_ref=="" || cusptip_ref==null || cusptip_ref=="null"){
			   cusptip_ref=formObj.cusp_tip_code_hid.value;
		  }
		 if (formObj.called_from_viewchart_yn.value=="Y") {//added by parul 14726 

			 var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_line_num="+chart_line_num+"&chart_num="+chart_num;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=displayCuspTipName&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = localTrimString(xmlHttp.responseText);
				cusptip_ref=retVal;
		   }
	   }

	//end

	if(ext_perm_loc_param == "Y" || (status_for_ext_loc_int >=25 && trmt_yn !="Y" && trmt_done_yn != "Y")){//Added by Sridevi Joshi for CRF-702(IN012606)
		var messageFrame = parent.parent.parent.parent.parent.messageFrame;//Added for CRF-702(IN012606) by Sridevi Joshi
	}else{
		var messageFrame = parent.parent.parent.parent.messageFrame;
	}

	//Added to count the number of Exfoliated conditions recorded in case of Retained.
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+RD_Normal_yn;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfToothForSUPRTH&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal);
	if(retVal.length > 0 && parseInt(retVal) > 0){ 
		var retVal_arr = retVal.split("##");
		exfolth_count = retVal_arr[0];			
	}

	//Added by SRidevi Joshi on 1/27/2010 for IN010894(SRR20056-CRF-0481). To get super_key_val
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;

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
		super_recorded = "Y";
	}
	if(formObj != null){
		var category_title=getLabel("Common.category1.label","Common");
		var site_title = getLabel("Common.Site.label","Common");
		var area_title = area_legend;
		var status_title = getLabel("Common.status.label","Common");
		var treatment_title = getLabel("Common.Treatment.label","Common");
		var surface_title = getLabel("eOH.Surface.Label","OH");
		var parts_title = getLabel("eOH.Parts.Label","OH");
		var outcome_title = getLabel("Common.outcome.label","Common");
		var remarks_title = getLabel("Common.remarks.label","Common");
		var cancel_reason_title = getLabel("eOR.CancelReason.label","OR");
		//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
		var tasks_applicable_title = getLabel("eOH.TasksApplicable.Label","OH");		
		var sequence_title = getLabel("eOH.Sequence.Label","OH");		

		// Fields added for Null Check of Start Date and End Date. Added by Sharon Crasta on 10/7/2008
		var start_date_title = getLabel("eOH.StartDate.Label","OH");
		var end_date_title = getLabel("eOH.EndDate.Label","OH");
		var failure_title = getLabel("eOH.FailureReason.Label","OH");


		if(trmt_category_type == "OTHERS" && status != "E" && status != "A"){
			if(formObj.oh_outcome!="null" && formObj.oh_outcome!=null){
				if(formObj.oh_outcome.value=="F" && (formObj.oh_outcome.value!="" && formObj.oh_outcome.value!="null" && formObj.oh_outcome.value!=null)){
					var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.remarks,formObj.oh_failure);
					var names = new Array ( category_title,status_title,treatment_title,remarks_title,failure_title);

				}else{
				   	var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.remarks);
					var names = new Array ( category_title,status_title,treatment_title,remarks_title);
				
				}
			}else{
				var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.remarks);
				var names = new Array ( category_title,status_title,treatment_title,remarks_title);
			}
		}
		else if(trmt_category_type == "OTHERS" &&  status == "E"){
			var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.reasonforcancel);
			var names = new Array ( category_title,status_title,treatment_title,cancel_reason_title);
		}
		else if(trmt_category_type == "OTHERS" &&  status == "A"){//Added by Sridevi Joshi on 10/29/2009 for IN015842
       
			var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.tasks_applicable,formObj.row_seq);
			var names = new Array ( category_title,status_title,treatment_title,tasks_applicable_title,sequence_title);
		}
		else if(trmt_category_type == "ORALCVT" && site_type=="MOUTH" && status != "E" && status != "A" ){

			  if(formObj.oh_outcome!="null" && formObj.oh_outcome!=null){
				if(formObj.oh_outcome.value=="F" && (formObj.oh_outcome.value!="" && formObj.oh_outcome.value!="null" && formObj.oh_outcome.value!=null)){
					var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.remarks,formObj.oh_failure);
					var names = new Array ( category_title,status_title,treatment_title,site_title,remarks_title,failure_title);

				}else{
					var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.remarks);
					var names = new Array ( category_title,status_title,treatment_title,site_title,remarks_title);
				
				}
			}else{
				var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.remarks);
				var names = new Array ( category_title,status_title,treatment_title,site_title,remarks_title);
			}
		}
		else if(trmt_category_type == "ORALCVT" && site_type=="MOUTH" && status == "E"){
			var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.reasonforcancel);
			var names = new Array ( category_title,status_title,treatment_title,site_title,cancel_reason_title); 
		}
		else if(trmt_category_type == "ORALCVT" && site_type=="MOUTH" && status == "A"){//Added by Sridevi Joshi on 10/29/2009 for IN015842
			var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.tasks_applicable,formObj.row_seq);
			var names = new Array ( category_title,status_title,treatment_title,site_title,tasks_applicable_title,sequence_title); 
		}
		else if((trmt_category_type == "ORALCVT" || trmt_category_type == "PERIO") && status != "E" && status != "A"){

			  if(formObj.oh_outcome!="null" && formObj.oh_outcome!=null){
				if(formObj.oh_outcome.value=="F" && (formObj.oh_outcome.value!="" && formObj.oh_outcome.value!="null" && formObj.oh_outcome.value!=null)){
					var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.oh_area,formObj.remarks,formObj.oh_failure);
					var names = new Array ( category_title,status_title,treatment_title,site_title,area_title,remarks_title,failure_title);

				}else{
					var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.oh_area,formObj.remarks);
				var names = new Array ( category_title,status_title,treatment_title,site_title,area_title,remarks_title);
				
				}
			}else{
				var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.oh_area,formObj.remarks);
				var names = new Array ( category_title,status_title,treatment_title,site_title,area_title,remarks_title);
			}
		}
		else if((trmt_category_type == "ORALCVT" || trmt_category_type == "PERIO") && status == "E"){
			var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.oh_area,formObj.reasonforcancel);
			var names = new Array ( category_title,status_title,treatment_title,site_title,area_title,cancel_reason_title);
		}
		else if((trmt_category_type == "ORALCVT" || trmt_category_type == "PERIO") && status == "A"){//Added by Sridevi Joshi on 10/29/2009 for IN015842
			var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.oh_area,formObj.tasks_applicable,formObj.row_seq);
			var names = new Array ( category_title,status_title,treatment_title,site_title,area_title,tasks_applicable_title,sequence_title);
		}
		else if((trmt_category_type == "MAXILLA" || site_type=="MOUTH") && status != "E" && status != "A"){
			if(formObj.oh_area.value=="I" || formObj.oh_area.value=="E" || formObj.site.value=="MAXFS"){//added by parul for CRF 701 on 23/09/2009
			 if ((formObj.oh_sub_parts.value=="" || formObj.oh_sub_parts.value=="null" || formObj.oh_sub_parts.value==null )&& formObj.oh_area.value!=""){
				 if(formObj.oh_sub_parts.disabled==false){
					 if(formObj.oh_outcome!="null" && formObj.oh_outcome!=null){
						if(formObj.oh_outcome.value=="F" && (formObj.oh_outcome.value!="" && formObj.oh_outcome.value!="null" && formObj.oh_outcome.value!=null)){
							var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_sub_parts,formObj.treatment_status,formObj.oh_treatment,formObj.remarks,formObj.oh_failure);
							var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,remarks_title,failure_title);

						}else{
							 var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_sub_parts,formObj.treatment_status,formObj.oh_treatment,formObj.remarks);
							var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,remarks_title);
						}
					 }else{
						var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_sub_parts,formObj.treatment_status,formObj.oh_treatment,formObj.remarks);
						var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,remarks_title);
					 }
				 }else{	
					 if(formObj.oh_outcome!="null" && formObj.oh_outcome!=null){
						if(formObj.oh_outcome.value=="F" && (formObj.oh_outcome.value!="" && formObj.oh_outcome.value!="null" && formObj.oh_outcome.value!=null)){
							var fields = new Array	(formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_surface,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks,formObj.oh_failure);
							var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,parts_title,remarks_title,failure_title);

						}else{
							var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_surface,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks);
							var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,parts_title,remarks_title);
						}
					 }else{

						var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_surface,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks);
						var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,parts_title,remarks_title);

					 }
				 }
						
			 }else{
				var count=0;
				if(formObj.oh_sub_parts.disabled==false && (formObj.oh_surface.value=="AB" || formObj.oh_surface.value=="GING" || formObj.oh_surface.value=="MBF") && (formObj.oh_area.value=="I" || formObj.oh_area.value=="E")){
					if (formObj.oh_sub_parts.value=="THAB" || formObj.oh_sub_parts.value=="THGM" || formObj.oh_sub_parts.value=="THAG" || formObj.oh_sub_parts.value=="THMF" || formObj.oh_sub_parts.value=="THGAM"){
						 if(formObj.oh_outcome!="null" && formObj.oh_outcome!=null){
							if(formObj.oh_outcome.value=="F" && (formObj.oh_outcome.value!="" && formObj.oh_outcome.value!="null" && formObj.oh_outcome.value!=null)){

								var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_selected_sub_parts,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks,formObj.oh_failure);
								var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,parts_title,remarks_title,failure_title);

							}else{
								var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_selected_sub_parts,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks);
								var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,parts_title,remarks_title);
							}
						 }else{

							var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_selected_sub_parts,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks);
							var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,parts_title,remarks_title);
					
						 }
					}else if(formObj.oh_sub_parts.value=="TNGAB" || formObj.oh_sub_parts.value=="TNGGM" || formObj.oh_sub_parts.value=="TNGAG" || formObj.oh_sub_parts.value=="TNGGAM" || formObj.oh_sub_parts.value=="TNGMF"){
						for (var k=0;k<formObj.oh_selected_sub_parts.value+1; k++) {
									count++;
						}
						if (count==1 || count==0){
							 if(formObj.oh_outcome!="null" && formObj.oh_outcome!=null){
									if(formObj.oh_outcome.value=="F" && (formObj.oh_outcome.value!="" && formObj.oh_outcome.value!="null" && formObj.oh_outcome.value!=null)){

										var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_selected_sub_parts,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks,formObj.oh_failure);
										var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,parts_title,remarks_title,failure_title);

									}else{
										var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_selected_sub_parts,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks);
										var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,parts_title,remarks_title);
									}
							 }else{
									var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.oh_selected_sub_parts,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks);
									var names = new Array ( category_title,site_title,area_title,parts_title,status_title,treatment_title,parts_title,remarks_title);

							 }
						}else{
                            if(formObj.oh_outcome!="null" && formObj.oh_outcome!=null){
									if(formObj.oh_outcome.value=="F" && (formObj.oh_outcome.value!="" && formObj.oh_outcome.value!="null" && formObj.oh_outcome.value!=null)){

										var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks,formObj.oh_failure);
										var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,parts_title,remarks_title,failure_title);

									}else{
										var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks);
										var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,parts_title,remarks_title);
									}
							}else{
								var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks);
								var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,parts_title,remarks_title);

							}
						
						}
					}else{

						if(formObj.oh_outcome!="null" && formObj.oh_outcome!=null){
							if(formObj.oh_outcome.value=="F" && (formObj.oh_outcome.value!="" && formObj.oh_outcome.value!="null" && formObj.oh_outcome.value!=null)){
								var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks,formObj.oh_failure);
								var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,parts_title,remarks_title,failure_title);
							}else{
									var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks);
									var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,parts_title,remarks_title);
							}
						}else{
							var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks);
							var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,parts_title,remarks_title);
						}
					}
				}else{
					if(formObj.oh_outcome!="null" && formObj.oh_outcome!=null){
						if(formObj.oh_outcome.value=="F" && (formObj.oh_outcome.value!="" && formObj.oh_outcome.value!="null" && formObj.oh_outcome.value!=null)){
							  var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks,formObj.oh_failure);
								var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,parts_title,remarks_title,failure_title);
						}else{
							var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks);
							var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,parts_title,remarks_title);
						}
					}else{
						var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.remarks);
						var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,parts_title,remarks_title);
					}
				}
			 }
			}else{
				var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.treatment_status,formObj.oh_treatment,formObj.remarks);
				var names = new Array ( category_title,site_title,status_title,treatment_title,remarks_title);
			}
		}
		else if((trmt_category_type == "MAXILLA" || site_type=="MOUTH") && status == "E"){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.treatment_status,formObj.oh_treatment,formObj.reasonforcancel);
			var names = new Array ( category_title,site_title,status_title,treatment_title,cancel_reason_title);
		}
		else if((trmt_category_type == "MAXILLA" || site_type=="MOUTH") && status == "A"){//Added by Sridevi Joshi on 10/29/2009 for IN015842
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.treatment_status,formObj.oh_treatment,formObj.tasks_applicable,formObj.row_seq);
			var names = new Array ( category_title,site_title,status_title,treatment_title,tasks_applicable_title,sequence_title);
		}

		else if(formObj.oh_surface.disabled == false && ((site_type=="CROWN" && formObj.oh_surface.value =="" ) || (formObj.oh_surface.value =="" && site_type=="ROOT")) && status != "E" && status != "A"){
               if(formObj.oh_outcome!="null" && formObj.oh_outcome!=null){
				if(formObj.oh_outcome.value=="F" && (formObj.oh_outcome.value!="" && formObj.oh_outcome.value!="null" && formObj.oh_outcome.value!=null)){
					var fields = new Array (formObj.oh_category,formObj.treatment_status,formObj.oh_treatment,formObj.oh_site,formObj.oh_area,formObj.remarks,formObj.oh_failure);
					var names = new Array ( category_title,status_title,treatment_title,site_title,area_title,remarks_title,failure_title);

					var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface);
				var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,surface_title,failure_title);

				}else{
					var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface);
					var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,surface_title);
				
				}
			}else{
				var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface);
				var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,surface_title);
			}

		}else if(formObj.oh_surface.disabled == false && ((site_type=="CROWN" && formObj.oh_surface.value =="" ) || (formObj.oh_surface.value ==""  && site_type=="ROOT")) && status == "E"){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.reasonforcancel);
		    var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,surface_title,cancel_reason_title);

		}else if(formObj.oh_surface.disabled == false && ((site_type=="CROWN" && formObj.oh_surface.value =="" ) || (formObj.oh_surface.value ==""  && site_type=="ROOT")) && status == "A"){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_surface,formObj.tasks_applicable,formObj.row_seq);
			var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,surface_title,tasks_applicable_title,sequence_title);
		}
		else if(status == "E"){
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.reasonforcancel);
			var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,cancel_reason_title);
		}
		else if(status == "A"){//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
			var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.tasks_applicable,formObj.row_seq);
			var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,tasks_applicable_title,sequence_title);
		}
		else{
			if(formObj.oh_outcome!="null" && formObj.oh_outcome!=null){
				if(formObj.oh_outcome.value=="F" && (formObj.oh_outcome.value!="" && formObj.oh_outcome.value!="null" && formObj.oh_outcome.value!=null)){
					var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment,formObj.oh_failure);
					var names = new Array ( category_title,site_title,area_title,status_title,treatment_title,failure_title);

				}else{
				   var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment);
					var names = new Array ( category_title,site_title,area_title,status_title,treatment_title);
				
				}
			}else{
				var fields = new Array (formObj.oh_category,formObj.oh_site,formObj.oh_area,formObj.treatment_status,formObj.oh_treatment);
				var names = new Array ( category_title,site_title,area_title,status_title,treatment_title);
			//}
			}
		}

		if(checkFieldsofMst( fields, names, messageFrame)){
			 //Added by Sharon Crasta on 10/7/2008
			 // Start Date and End Date are added for Null Check only once the task is Registered.

			 //Added ext_perm_loc_param condition for IN015620 by sridevi joshi on 23/20/09
			
			 var status_int_for_strt_end_date = parseInt(status);
			 if((status_int_for_strt_end_date == 25 || status_int_for_strt_end_date == 52 || 
				 status_int_for_strt_end_date == 55 || status_int_for_strt_end_date == 80 || status_int_for_strt_end_date == 85) && ext_perm_loc_param != "Y"){
				var fields = new Array (formObj.strtDate,formObj.endDate);
				var names = new Array (start_date_title,end_date_title);			 
			 }

			 if(checkFieldsofMst( fields, names, messageFrame))	{
				if((status_int_for_strt_end_date == 25 || status_int_for_strt_end_date == 52 || 
				 status_int_for_strt_end_date == 55 || status_int_for_strt_end_date == 80 || status_int_for_strt_end_date == 85) && ext_perm_loc_param != "Y"){ 
					 var fields = new Array (formObj.strtTime,formObj.endTime);
					 var names = new Array (start_date_title,end_date_title);
				}
				var treatment_status=formObj.treatment_status.value;

				if(checkFieldsofMst( fields, names, messageFrame)){ 
					if(ext_perm_loc_param == "Y" || (status_for_ext_loc_int >=25 && trmt_yn !="Y" && trmt_done_yn != "Y")){//Added by Sridevi Joshi for CRF-702(IN012606)
						var dentalchartFormObj = parent.parent.trmtDentalChartDetails.document.forms[0];
					}
					else{
						var dentalchartFormObj = parent.trmtDentalChartDetails.document.forms[0];
					}
					var thrng_nos = formObj.thrng_nos.value;
					
					formObj.chart_hdr_insert_yn.value  = dentalchartFormObj.chart_hdr_insert_yn.value;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					 var super_tooth_no="";
					 var retained_tooth_no="";
					 if (super_tooth_ref!="" && super_tooth_ref!="" && super_tooth_ref!="" && super_tooth_ref!="RD"  && super_tooth_ref!="undefined" && super_tooth_ref!=undefined) {
						 super_tooth_no=tooth_no+""+super_tooth_ref.substring(super_tooth_ref.length-1,super_tooth_ref.length);

					 }
					var isRetainedYN="";
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
					if(condition_type_ref == "RTDESTH"){
					isRetainedYN = "Y";
					}
					 if (mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
					  if (isRetainedYN=="Y" && (super_tooth_ref != "RD" && (super_tooth_ref == "" || super_tooth_ref == "undefined" || super_tooth_ref == undefined))){
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
					 if(super_tooth_ref == "RD"){//Added by parul on 12/17/2009 for RTDESTH new changes
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

				/* if(site_type == "CROWN"){ //Added by Sridevi Joshi on 4/27/2010 for PE..This block has to be executed only for CRown
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&super_tooth_no="+super_tooth_no+"&retained_tooth_no="+retained_tooth_no+"&treatment_int_ext=I";				
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=ChkAllsurfaceOnsuper&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_surface = localTrimString(xmlHttp.responseText);
					var msg = getMessage("APP-OH000105","OH");
					var msgArray = msg.split("##");
					if(retVal_surface.length>1){
						var retVal_trmt_arr = retVal_surface.split("~");
						for(var m=0;m<retVal_trmt_arr.length-1;m++){
							var code_trmt_arr = retVal_trmt_arr[m].split("##");
							var code_surface=code_trmt_arr[0];
							var code_outcome=code_trmt_arr[1];
						}
					}


					if( (formObj.called_from_viewchart_yn.value != 'Y') && site_type == "CROWN"){
						if (code_surface=="*A" && (code_outcome!="F" && (code_outcome == "" || code_outcome == "null" || code_outcome == null || code_outcome == "undefined" || code_outcome == undefined))) {
							alert(msgArray[0]+site_type+msgArray[1]);
							  return;
						}else if (code_surface=="*A" && formObj.oh_surface.value!="*A" && (formObj.oh_surface.value!="" && formObj.oh_surface.value!="null" && formObj.oh_surface.value!=null) )
						{  
							alert(msgArray[0]+site_type+msgArray[1]);
							  return;
						}
					}
				 }*/

					/* Block that will check for the applicable condition types and allow only those condition types recording*/
					if(treatment_status_param == "PLAN" || treatment_status_param == ""){
						populateAllTrmtCategories(site_type);

						// get the list of function_id's (menu_id)
						var function_id_list = formObj.function_id_list.value;
						var function_id_list_array  = function_id_list.split("##"); // the functions are separated by ##
						var menu_id_list = "";
						for (var i=0;i<function_id_list_array.length-1;i++ ){
							if(i==0)
								menu_id_list = function_id_list_array[i];
							else{
								menu_id_list += "~";
								menu_id_list += function_id_list_array[i];
							}
						}

						// get the list of function_names (menu_names)
						var function_name_list = formObj.function_name_list.value;
						var function_name_list_array  = function_name_list.split("##"); // the functions are separated by ##
						var menu_name_list = "";
						for (var i=0;i<function_name_list_array.length-1;i++ ){
							if(i==0)
								menu_name_list = function_name_list_array[i];
							else{
								menu_name_list += "~";
								menu_name_list += function_name_list_array[i];
							}
						}

						// get the list of function_types for each menu
						var function_type_list = formObj.function_type_list.value;
						var function_type_list_array  = function_type_list.split("##"); // the functions are separated by ##
						var menu_type_list = "";
						for (var i=0;i<function_type_list_array.length-1;i++ ){
							if(i==0)
								menu_type_list = function_type_list_array[i];
							else{
								menu_type_list += "~";
								menu_type_list += function_type_list_array[i];
							}
						}

						// get the list of function_types_desc for each menu
						var function_type_desc_list = formObj.function_type_desc_list.value;
						var function_type_desc_list_array  = function_type_desc_list.split("##"); // the functions are separated by ##
						var menu_type_desc_list = "";
						for (var i=0;i<function_type_desc_list_array.length-1;i++ ){
							if(i==0)
								menu_type_desc_list = function_type_desc_list_array[i];
							else{
								menu_type_desc_list += "~";
								menu_type_desc_list += function_type_desc_list_array[i];
							}
						}

						// get the list of function_cat_code for each menu
						var function_cat_code_list = formObj.function_cat_code_list.value;
						var function_cat_code_list_array  = function_cat_code_list.split("##"); // the functions are separated by ##
						var menu_cat_code_list = "";
						for (var i=0;i<function_cat_code_list_array.length-1;i++ ){
							if(i==0)
								menu_cat_code_list = function_cat_code_list_array[i];
							else{
								menu_cat_code_list += "~";
								menu_cat_code_list += function_cat_code_list_array[i];
							}
						}
						
						menu_id_list		= trimString(menu_id_list);
						menu_name_list		= trimString(menu_name_list);
						menu_type_list	    = trimString(menu_type_list);
						menu_type_desc_list	    = trimString(menu_type_desc_list);
						menu_cat_code_list	    = trimString(menu_cat_code_list);

						var id_rowval		= menu_id_list.split ("~"); // function_id
						var id_name_rowval  = menu_name_list.split ("~"); // function_name
						var id_type_rowval  = menu_type_list.split ("~"); // function_type
						var id_type_desc_rowval  = menu_type_desc_list.split ("~"); // function_type_desc
						var id_cat_code_rowval  = menu_cat_code_list.split ("~"); // function_cat_code

						var applicable_trmt_types = id_type_rowval;
						var applicable_trmt_desc = id_type_desc_rowval;
						
						if((site_type == "TOOTH" && tooth_no != null && tooth_no != "" && tooth_no.indexOf(",") == -1) || (site_type == "ROOT" || site_type == "CROWN" || site_type == "ARCH" || site_type == "QUAD")){ // This code is for single tooth selection 
							//This function is to check the applicable menu options..
							var applicable_trmt_types_arr = applicableTrmtMenuOptions(applicable_trmt_types,tooth_no,patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,"",site_type,thrng_nos_ref,'','','',super_tooth_ref,retained_tooth_no);
							//Added formObj.area.value,site_type by Sharon Crasta on 2/4/2010 for SRR20056-CRF-0498(IN010982)
							applicable_trmt_types = resultTrmtMenuOptions(applicable_trmt_types_arr,applicable_trmt_desc,tooth_no,mixed_dentition_YN,permanent_deciduous_flag,formObj.area.value,site_type);
							
						}
						else if(site_type == "THRNG" && tooth_no.indexOf(",") != -1){ // This code is for multiple tooth selection 
							var nors_arr = thrng_nos_ref.split(",");
							var flag_not_consecutive = false;
							for(j=0;j<nors_arr.length;j++){
								// Added flag_not_consecutive by Sharon Crasta on 3/3/2010 for SRR20056-CRF-0475(IN010868) for Bridge Trmt to check if consecutive tooth are selected.
								
								var nos_length = nors_arr.length;
								var tooth1 = parseInt(nors_arr[j]);
								var tooth2 = parseInt(nors_arr[j+1]);
								var tooth_add = parseInt(tooth1 + 1);

								if(nors_arr[j+1] != "" && nors_arr[j+1] != "undefined" && nors_arr[j+1] != "null" && nors_arr[j+1] != null && nors_arr[j+1] <= nors_arr[nos_length-1]){
								//if(parseInt(nors_arr[j+1]) != ((parseInt(nors_arr[j]) + 1))) {
									if(tooth_add != tooth2) {
									   flag_not_consecutive = true;
									}
								}//End
								var len = nors_arr.length;
								var no_of_tooth = parseInt(nors_arr[len-1])-parseInt(nors_arr[0])-1;
								
								//This function is to check the applicable menu options..
								var applicable_trmt_types_arr = applicableTrmtMenuOptions(applicable_trmt_types,nors_arr[j],patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,"",site_type,thrng_nos_ref,j,nors_arr.length-1,no_of_tooth,'',super_tooth_ref,retained_tooth_no,flag_not_consecutive);
								
								applicable_trmt_types = resultTrmtMenuOptions(applicable_trmt_types_arr,applicable_trmt_desc,nors_arr[j],mixed_dentition_YN,permanent_deciduous_flag);

							}
						}
					
						var count_trmts = 0; // This count is to count the conditions available. If this count = 0 then dont show the menu.
						var return_menu_flag = "N";
						
						for(j=0;j<applicable_trmt_types.length;j++){
							if(applicable_trmt_types[j] != "undefined" && applicable_trmt_types[j] != undefined){
								count_trmts++;
								/*if(document.forms[0].oh_category.value!="OTHERS"){// if condition is added by parul on 7/21/2009 for IN012545(System was not allowing to record Others Treatment)
									if(applicable_trmt_types[j] == (document.forms[0].oh_category.value)){
										return_menu_flag = "Y";
										break;
									}
									else{
										return_menu_flag = "N";
									}
								}else{
									return_menu_flag = "Y";
								}*/
								if(document.forms[0].oh_category.value == "OTHERS"){ //if condition is added by parul on 7/21/2009 for IN012545(System was not allowing to record Others Treatment)
									return_menu_flag = "Y";
								}
								else{//Added by Sridevi joshi on 3/3/2010 for IN010871(SRR20056-CRF-0478)
								
									var show_menu = "Y";//Added by Sridevi joshi on 3/4/2010 for IN010871(SRR20056-CRF-0478)
									//Added by Sharon Crasta on 3/12/2010 for IN019874
									//If the Bridge trmt is a success, then you should not be able to record Bridge on it again.
									if(thrng_nos_ref != null && thrng_nos_ref != "" && thrng_nos_ref.indexOf(",") != -1 && (document.forms[0].oh_category.value == "BRIDGE")){ // This code is for multiple tooth selection 
									
									var nors_arr = thrng_nos_ref.split(",");
									for(var d=0;d<nors_arr.length;d++){
										//check_cat_type = populateConditionCode(formObj.oh_category,formObj.oh_treatment);
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										params = "func_mode=checkForTreatments&tooth_no="+nors_arr[d]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type="+applicable_trmt_types[j]+"&header_tab=T"+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
										
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
										xmlHttp.send(xmlDoc);
										
										var retVal_trmt1 = trimString(xmlHttp.responseText); 
										retVal_trmt1 = localTrimString(retVal_trmt1); 
										if(retVal_trmt1.length > 1){
											var retVal_trmt1_arr = retVal_trmt1.split("~");
											for(var h=0;h<retVal_trmt1_arr.length-1;h++){
												var thrng_val = "";
												var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
												var denture_removable = rec_trmt_arr[1];
												var trmt_outcome = rec_trmt_arr[2];
												var tooth_range = rec_trmt_arr[4];
												var treatments_status = rec_trmt_arr[5];
											
												if(tooth_range != "" && tooth_range != "null" && tooth_range != null){
													var tooth_chart_arr = tooth_range.split(",");
													for(var g=0;g<tooth_chart_arr.length;g++){
														var tooth_range_arr = tooth_chart_arr[g].split("$$");
														
														if(thrng_val == ""){
															thrng_val = tooth_range_arr[1];
														}
														else{
															thrng_val = thrng_val+","+tooth_range_arr[1];
														}
														
													}
													
													if(applicable_trmt_types[j] == "DENTURE"){//Added by Sridevi Joshi on 3/4/2010 for CRF-478
														if(parseInt(treatments_status) < 25){//Addded by Sridevi Joshi on 3/10/2010 for IN019920
															show_menu = "N"; 
															return_menu_flag = "N";
														}
														else if(thrng_val != nors_arr && trmt_outcome != "F" ){
															show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
															return_menu_flag = "N";
														}
														else if(thrng_val == nors_arr && trmt_outcome != "F" && denture_removable != "Y"){ // denture_removable is added by Sridevi Joshi on 3/4/2010 for CRF-478
															show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
															return_menu_flag = "N";
														}
														else{
															show_menu = "Y"; //If Denture is recorded on any one of the tooth in case of range
															return_menu_flag = "Y";
														}
													}
													else{
														if(thrng_val != nors_arr && trmt_outcome != "F" ){
															//show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
														}
														//else if(thrng_val == nors_arr && trmt_outcome != "F" ){
														else if(thrng_val == nors_arr && trmt_outcome != "F" && trmt_outcome != "" && treatments_outcome_ext != "null" && treatments_outcome_ext == null) {
															show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
															return_menu_flag = "N";
														}
														else{
															show_menu = "Y"; //If Denture is recorded on any one of the tooth in case of range
															return_menu_flag = "Y";
														}
													}
												}
												else{
													thrng_val = nors_arr;
													if(trmt_outcome != "F"){
														show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
														return_menu_flag = "N";
													}
													else{
														show_menu = "Y"; //If Denture is recorded on any one of the tooth in case of range
														return_menu_flag = "Y";
													}
												}										
											}
										}
										else{
											show_menu = "N"; //If Denture is not recorded on any one of the tooth in case of range
											//return_menu_flag = "Y";
										}
									}
																											
								} //End 
								if((document.forms[0].oh_category.value != "BRIDGE") && site_type=="THRNG" || site_type=="TOOTH" || site_type == "ARCH" || site_type == "QUAD"){
									
										if(applicable_trmt_types[j] == (document.forms[0].oh_category.value)){
											if (site_type == "THRNG" && tooth_no.indexOf(",") != -1){
												var nors_arr = thrng_nos_ref.split(",");
													for(var u=0;u<nors_arr.length;u++){
														//Added by Sridevi Joshi on 3/12/2010 for IN019935
														var xmlDoc = "" ;
														var xmlHttp = new XMLHttpRequest();
														params = "func_mode=checkCondTrmtRecorded&tooth_no="+nors_arr[u]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&arch_quad="+tooth_no+"&site="+site_type+"&header_tab=T&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
														var xmlStr ="<root><SEARCH ";
														xmlStr +=" /></root>";
														xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
														xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
														xmlHttp.send(xmlDoc);
														var retVal_trmt2 = trimString(xmlHttp.responseText); 
														retVal_trmt2 = localTrimString(retVal_trmt2);

														if(retVal_trmt2.length>1){
															var retVal_trmt2_arr = retVal_trmt2.split("~");
															for(var m=0;m<retVal_trmt2_arr.length-1;m++){
																var code_trmt_arr = retVal_trmt2_arr[m].split("##");
																if(code_trmt_arr[6]=="THRNG" || code_trmt_arr[6]=="TOOTH" || code_trmt_arr[6] == "ARCH" || code_trmt_arr[6] == "QUAD"){ // Addded by Sridevi Joshi on 3/18/2010

																	var xmlDoc = "" ;
																	var xmlHttp = new XMLHttpRequest();
																	//commented by parul on 15/04/2010 for IN020573,
																	//params = "func_mode=checkForTreatments&tooth_no="+nors_arr[u]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&trmt_category_type="+code_trmt_arr[4]+"&other_chart_facility_id="+other_chart_facility_id+"&header_tab=T&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
																	params = "func_mode=checkForTreatments&tooth_no="+nors_arr[u]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&trmt_category_type="+applicable_trmt_types[j]+"&other_chart_facility_id="+other_chart_facility_id+"&header_tab=T&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;

																	var xmlStr ="<root><SEARCH ";
																	xmlStr +=" /></root>";
																	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
																	xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
																	xmlHttp.send(xmlDoc);
																	var retVal_trmt1 = trimString(xmlHttp.responseText); 
                                                                     
																	retVal_trmt1 = localTrimString(retVal_trmt1);
																	var retVal_trmt1_arr = retVal_trmt1.split("~");
																	for(var h=0;h<retVal_trmt1_arr.length-1;h++){
																		var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
																		var denture_removable = rec_trmt_arr[1];
																		var treatments_outcome_ext = rec_trmt_arr[2];
																		var treatments_status = rec_trmt_arr[5];
																		if(treatments_outcome_ext != "F" && denture_removable != "Y" && (document.forms[0].oh_category.value == code_trmt_arr[4])){//commented by Sridevi on 3/12/2010 for IN019935
																			show_menu = "N"; 
																			break;
																		}
																		else if((document.forms[0].oh_category.value != code_trmt_arr[4]) && show_menu == "Y" && treatments_outcome_ext != "F"){//by parul on 15/04/2010 for IN020573,bridge register-->ortho planned-->ortho
																		   show_menu = "N"; 
																			break;
																		}

																	}
																																	
																	if(retVal_trmt1.length > 1){
																		var retVal_trmt1_arr = retVal_trmt1.split("~");
																		for(var h=0;h<retVal_trmt1_arr.length-1;h++){
																		var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
																		var denture_removable = rec_trmt_arr[1];
																		var treatments_outcome_ext = rec_trmt_arr[2];
																		if((denture_removable == "Y" || treatments_outcome_ext == "F" || treatments_outcome_ext == "" || treatments_outcome_ext == null || treatments_outcome_ext == "null" || (document.forms[0].oh_category.value != code_trmt_arr[4])) && show_menu == "Y"){//commented by Sridevi on 3/12/2010 for IN019935
																				return_menu_flag = "Y";
																				//break;
																			}
																			else{
																				return_menu_flag = "N";
																				//show_menu == "N";
																			}
																		}
                   
																		if(return_menu_flag == "Y"){
																			break;
																		}
																	}
																	else{
																		return_menu_flag = "Y";
																		break; 
																	}
																}
																else{
																	return_menu_flag = "Y";
																}
															}

															if(return_menu_flag == "Y"){
																break;
															}
															break;//added by parul on 14/04/2010 for IN020573 
														}else{
															return_menu_flag = "Y";
															//break;
														}
													}
											}else{
											   	//Added by Sridevi Joshi on 3/12/2010 for IN019935
												var xmlDoc = "" ;
												var xmlHttp = new XMLHttpRequest();
												params = "func_mode=checkCondTrmtRecorded&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&arch_quad="+tooth_no+"&site="+site_type+"&header_tab=T&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
												var xmlStr ="<root><SEARCH ";
												xmlStr +=" /></root>";
												xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
												xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
												xmlHttp.send(xmlDoc);
												var retVal_trmt2 = trimString(xmlHttp.responseText); 
												retVal_trmt2 = localTrimString(retVal_trmt2);
												if(retVal_trmt2.length>1){
													var retVal_trmt2_arr = retVal_trmt2.split("~");
													for(var m=0;m<retVal_trmt2_arr.length-1;m++){
														var code_trmt_arr = retVal_trmt2_arr[m].split("##");
														if(code_trmt_arr[6]=="THRNG" || code_trmt_arr[6]=="TOOTH" || code_trmt_arr[6] == "ARCH" || code_trmt_arr[6] == "QUAD"){ // Addded by Sridevi Joshi on 3/18/2010
															var xmlDoc = "" ;
															var xmlHttp = new XMLHttpRequest();
											
															params = "func_mode=checkForTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&trmt_category_type="+code_trmt_arr[4]+"&other_chart_facility_id="+other_chart_facility_id+"&header_tab=T&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;

															var xmlStr ="<root><SEARCH ";
															xmlStr +=" /></root>";
															xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
															xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
															xmlHttp.send(xmlDoc);
															var retVal_trmt1 = trimString(xmlHttp.responseText); 
													
															retVal_trmt1 = localTrimString(retVal_trmt1);
															var retVal_trmt1_arr = retVal_trmt1.split("~");
															for(var h=0;h<retVal_trmt1_arr.length-1;h++){
																var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
																var denture_removable = rec_trmt_arr[1];
																var treatments_outcome_ext = rec_trmt_arr[2];
																var treatments_status = rec_trmt_arr[5];
																if(treatments_outcome_ext != "F" && treatments_outcome_ext != "" && denture_removable != "Y" && (document.forms[0].oh_category.value == code_trmt_arr[4])){//commented by Sridevi on 3/12/2010 for IN019935
																	show_menu = "N"; 
																	break;
																}
															}
															
															if(retVal_trmt1.length > 1){
																var retVal_trmt1_arr = retVal_trmt1.split("~");
																for(var h=0;h<retVal_trmt1_arr.length-1;h++){
																	var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
																	var denture_removable = rec_trmt_arr[1];
																	var treatments_outcome_ext = rec_trmt_arr[2];
																	if((denture_removable == "Y" || treatments_outcome_ext == "F" || treatments_outcome_ext == "" || treatments_outcome_ext == null || treatments_outcome_ext == "null" || (document.forms[0].oh_category.value != code_trmt_arr[4])) && show_menu == "Y"){//commented by Sridevi on 3/12/2010 for IN019935
																		return_menu_flag = "Y";
																		//break;
																	}
																	else{
																		return_menu_flag = "N";
																		//show_menu == "N";
																	}
																}

																if(return_menu_flag == "Y"){
																	break;
																}
															}
															else{
																return_menu_flag = "Y";
																break;
															}
														}
														else{
															return_menu_flag = "Y";
														}
													}

													if(return_menu_flag == "Y"){
														break;
													}
												}else{
													return_menu_flag = "Y";
													break;
												}
												
											}
										}//end 
										else{
											return_menu_flag = "N";
										}
										
									}else{
										
										if(applicable_trmt_types[j] == (document.forms[0].oh_category.value)){
											/*
											var xmlDoc = "" ;
											var xmlHttp = new XMLHttpRequest();
											 if (formObj.surface_ref.value=="*A"){
												surface_ref="*A"
											}
											var surface_ref_arr=surface_ref.split(",");
											if (surface_ref_arr.length>1){
												for(var u=0;u<surface_ref_arr.length;u++){	
													params = "func_mode=checkForTreatmentsOnCrown&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&trmt_category_type="+applicable_trmt_types[j]+"&other_chart_facility_id="+other_chart_facility_id+"&surface_code="+surface_ref_arr[u]+"&header_tab=ET&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
												}
											}else{
												params = "func_mode=checkForTreatmentsOnCrown&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&trmt_category_type="+applicable_trmt_types[j]+"&other_chart_facility_id="+other_chart_facility_id+"&surface_code="+surface_ref+"&header_tab=ET&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
											
											}
											var xmlStr ="<root><SEARCH ";
											xmlStr +=" /></root>";
											xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
											xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
											xmlHttp.send(xmlDoc);
											var retVal_trmt1 = trimString(xmlHttp.responseText); 
											retVal_trmt1 = localTrimString(retVal_trmt1); */
												var xmlDoc = "" ;
												var xmlHttp = new XMLHttpRequest();
												 if (formObj.surface_ref.value=="*A"){
													surface_ref="*A"
												}
												var surface_ref_arr=surface_ref.split(",");
												if (surface_ref_arr.length>1){
													for(var u=0;u<surface_ref_arr.length;u++){	
														params = "func_mode=checkForTreatmentsOnCrown&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&trmt_category_type="+applicable_trmt_types[j]+"&other_chart_facility_id="+other_chart_facility_id+"&surface_code="+surface_ref_arr[u]+"&header_tab=ET&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
													}
												}else{
													params = "func_mode=checkForTreatmentsOnCrown&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&trmt_category_type="+applicable_trmt_types[j]+"&other_chart_facility_id="+other_chart_facility_id+"&surface_code="+surface_ref+"&header_tab=ET&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
												
												}
												var xmlStr ="<root><SEARCH ";
												xmlStr +=" /></root>";
												xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
												xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
												xmlHttp.send(xmlDoc);
												var retVal_trmt1 = trimString(xmlHttp.responseText); 
												retVal_trmt1 = localTrimString(retVal_trmt1); 
												if(retVal_trmt1.length > 1){
													var retVal_trmt1_arr = retVal_trmt1.split("~");
													for(var h=0;h<retVal_trmt1_arr.length-1;h++){
														var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
														//var denture_removable = rec_trmt_arr[1];
														var treatments_outcome_ext = rec_trmt_arr[1];

														if(treatments_outcome_ext == "S"){
															show_menu = "N"; 
															break;
														}
													}
												}
												
												if(retVal_trmt1.length > 1){
													var retVal_trmt1_arr = retVal_trmt1.split("~");
													for(var h=0;h<retVal_trmt1_arr.length-1;h++){
														var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
														//var denture_removable = rec_trmt_arr[1];
														var treatments_outcome_ext = rec_trmt_arr[1];
														
														if((treatments_outcome_ext == "F" || treatments_outcome_ext == "" ) && show_menu == "Y"){
															return_menu_flag = "Y";
															//break;
														}
														else{
															return_menu_flag = "N";
															//show_menu == "N";
														}
													}

													if(return_menu_flag == "Y"){
														break;
													}
												}
												else{
													return_menu_flag = "Y";
													break;
												}
										
											}
										else{
											return_menu_flag = "N";
										}
									}
								}
							}							 
						}
						
						var msg = getMessage("APP-OH000105","OH");
						var msgArray = msg.split("##");
											
						var trmt_cat_desc = document.forms[0].oh_category.options[document.forms[0].oh_category.selectedIndex].text;
						if(called_from_viewchart_yn != "Y"){ //Added by Sridevi Joshi on 4/1/2010 for IN020470---> System should not display Treatment not applicable msg when recording from RHS menu.
							if(parseInt(count_trmts) > 0){
								if(return_menu_flag == "N"){
									alert(msgArray[0]+trmt_cat_desc+msgArray[1]); 
									//Commented by Sharon Crasta on 12/18/2009 for IN017397
									//Since the tooth range value is made null, the menu check does not happen for the tooth range. i.e., for the second time when the bridge/denture trmt is recorded on the same tooth range, tooth_no.indexOf(",") was going as -1
									//To clear thrng_nos_ref once the trmt category is changes
									//document.forms[0].thrng_nos_ref.value = "";
									//End
									return;
								}
							}
							else{
								if(return_menu_flag == "N"){
									alert(msgArray[0]+trmt_cat_desc+msgArray[1]);
									//Commented by Sharon Crasta on 12/18/2009 for IN017397
									//Since the tooth range value is made null, the menu check does not happen for the tooth range. i.e., for the second time when the bridge/denture trmt is recorded on the same tooth range, tooth_no.indexOf(",") was going as -1
									//To clear thrng_nos_ref once the trmt category is changes
									//document.forms[0].thrng_nos_ref.value = "";
									//End
									return;
								}
							}
						}
						/* Ends here */

						var tooth_layer = "toothLayer"+tooth_no;
						var root_layer = "rootLayer"+tooth_no;
						var ref_tooth_no = formObj.ref_tooth_no.value;//Added by Sridevi Joshi on 2/21/2010 for IN019472

						if(status != "E"){
							if(super_tooth_ref == "RD"){//Added by Sridei Joshi on 2/23/2010 IN019485
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

							if(site_type == "CROWN" || site_type == "ROOT"){ //Added by Sridevi Joshi on 2/21/2010 for IN019472
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tab_code=T";
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateCondTrmtsRecorded&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);
								retVal=localTrimString(retVal);

								if(retVal.length > 1){
									var retVal_arr_cond_trmt = retVal.split("~");
									for(var m=0;m<retVal_arr_cond_trmt.length-1;m++){
										var cond_trmt_arr = retVal_arr_cond_trmt[m].split("##");
										db_cond_type = cond_trmt_arr[0];
										db_trmt_type = cond_trmt_arr[1];
										if(db_cond_type == "UNERTH"){
											unerth_rec = "Y";
										}
										else if(db_cond_type == "PARERTH"){
											parerth_rec = "Y";
										}

										if(db_cond_type == "ERUPTH"){
											erupth_rec = "Y";
										}

										if(db_cond_type == "EXFOLTH"){
											exfolth_rec = "Y";
										}
										
										if(db_cond_type == "MISSTH"){
											missth_rec = "Y";
										}
										
										if(db_cond_type == "IMPACTN"){
											impactn_rec = "Y";
										}
										
										if(db_trmt_type == "EXTRACT"){
											extract_rec = "Y";
										}
										
										if(db_trmt_type == "IMPLANT"){
											implant_rec = "Y";
										}
										
										if(db_trmt_type == "DENTURE"){
											denture_rec = "Y";
										}
										
										if(db_trmt_type == "BRIDGE"){
											bridge_rec = "Y";
										} 

									}
								}
								
								if(site_type == "CROWN"){
									if(mixed_dentition_YN == "Y" && (tooth_no =="2" || tooth_no =="3" || tooth_no =="14" || tooth_no =="15" || tooth_no =="18" || tooth_no =="19" || tooth_no =="30" || tooth_no =="31")){
										if(parerth_rec != "Y" && erupth_rec != "Y" && (super_tooth_ref == "" || super_tooth_ref == undefined || super_tooth_ref == "undefined")){// super_tooth_ref is added by Sridevi Joshi on 3/15/2010 for IN019963
											alert(getMessage("APP-OH000106","OH"));
											return;
										}
									}
									else if(permanent_deciduous_flag=="P" && (tooth_no =="1" || tooth_no =="16" || tooth_no =="17" || tooth_no =="32")){
										if(parerth_rec != "Y" && erupth_rec != "Y" && (super_tooth_ref == "" || super_tooth_ref == undefined || super_tooth_ref == "undefined")){// super_tooth_ref is added by Sridevi Joshi on 3/15/2010 for IN019963
											alert(getMessage("APP-OH000106","OH"));
											return;
										}
									}
									//else if(unerth_rec == "Y" && erupth_rec != "Y" ){
									else if(unerth_rec == "Y" && erupth_rec != "Y" && parerth_rec != "Y" ){// erupth_rec condition is Added by Sridevi Joshi on 31/03/2010 for IN020459
										alert(getMessage("APP-OH000106","OH"));
										return;
									}
									else if(impactn_rec == "Y" && parerth_rec != "Y" && erupth_rec != "Y"){
										alert(getMessage("APP-OH000106","OH"));
										return;
									}
									else if(exfolth_rec == "Y" && erupth_rec != "Y" && parerth_rec != "Y"){ //erupth_rec & parerth_rec is added by Sridevi Joshi on 4/6/2010 for IN020513. This is for MD-P case DECITH-->EXFOLTH-->ERUPT-->Caries
										alert(getMessage("APP-OH000106","OH"));
										return;
									}
									else if(missth_rec == "Y"){
										alert(getMessage("APP-OH000106","OH"));
										return;
									}
									else if(extract_rec == "Y" || implant_rec == "Y" || denture_rec == "Y" || bridge_rec == "Y"){
										alert(getMessage("APP-OH000106","OH"));
										return;
									}
								}
								else if(site_type == "ROOT"){
									if(mixed_dentition_YN == "Y" && (tooth_no =="2" || tooth_no =="3" || tooth_no =="14" || tooth_no =="15" || tooth_no =="18" || tooth_no =="19" || tooth_no =="30" || tooth_no =="31")){
										if(erupth_rec != "Y" && (super_tooth_ref == "" || super_tooth_ref == undefined || super_tooth_ref == "undefined")){// super_tooth_ref is added by Sridevi Joshi on 3/15/2010 for IN019963
											alert(getMessage("APP-OH000107","OH"));
											return;
										}
									}
									else if(permanent_deciduous_flag=="P" && (tooth_no =="1" || tooth_no =="16" || tooth_no =="17" || tooth_no =="32")){
										if(erupth_rec != "Y" && (super_tooth_ref == "" || super_tooth_ref == undefined || super_tooth_ref == "undefined")){// super_tooth_ref is added by Sridevi Joshi on 3/15/2010 for IN019963
											alert(getMessage("APP-OH000107","OH"));
											return;
										}
									}
									else if((unerth_rec == "Y" || parerth_rec == "Y") && erupth_rec != "Y" ){
										alert(getMessage("APP-OH000107","OH"));
										return;
									}
									else if(impactn_rec == "Y" && erupth_rec != "Y"){
										alert(getMessage("APP-OH000107","OH"));
										return;
									}
									else if(exfolth_rec == "Y" && erupth_rec != "Y" ){ //erupth_rec is added by Sridevi Joshi on 4/6/2010 for IN020513. This is for MD-P case DECITH-->EXFOLTH-->ERUPT-->Caries
										alert(getMessage("APP-OH000107","OH"));
										return;
									}
									else if(missth_rec == "Y"){
										alert(getMessage("APP-OH000107","OH"));
										return;
									}
									//Commented by Sharon Crasta on 3/4/2010 for SRR20056-CRF-0475(IN010868)
									//Should not be applicable for Root since for Abutment tooth we have the Root available.
									//else if(extract_rec == "Y" || implant_rec == "Y" || denture_rec == "Y" || bridge_rec == "Y"){
									else if(extract_rec == "Y" || implant_rec == "Y" || denture_rec == "Y"){//End
										alert(getMessage("APP-OH000107","OH"));
										return;
									}
								}
							}
						}

					//Added by Sharon Crasta on 2/9/2010 for SRR20056-CRF-0475(IN010868)
					var modalReturnedVal = "";
					var pontic_tooth = new Array();
					var pontic_tooth_split_values = new Array();
					var abutment_tooth_values = "";
					var title_desc = getLabel("eOH.PonticToothDtls.Label","OH");
					var retVal_bridge_extract = "";

					if(status != "E" && trmt_category_type == "BRIDGE"){
						var nors_arr = thrng_nos_ref.split(",");
						if(nors_arr.length >= 6){
							alert(getMessage("APP-OH000170","OH"));
							return;
						}
						
					}
					//if(status != "E" && trmt_category_type == "EXTRACT" && treatments_outcome == "S"){
					if(status != "E" && trmt_category_type == "EXTRACT"){
						
						var flag_for_pontic_tooth =  false;
						var j =0;
						
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
						pontic_tooth = retVal_bridge_extract.split(",") ;
										
						if(tooth_no == (retVal_bridge_extract.substring(retVal_bridge_extract.lastIndexOf("$")+1,retVal_bridge_extract.length))){	// toothno == to the last number in the bridge 
							for(i = pontic_tooth.length-1;i >= 0;i--,j++){

								pontic_tooth_split_values[j] = pontic_tooth[i].substring((pontic_tooth[i].lastIndexOf("$")+1),pontic_tooth[i].length) ;

							} 
						}else{
							for(i = 0; i < pontic_tooth.length;i++){
								pontic_tooth_split_values[i] = pontic_tooth[i].substring((pontic_tooth[i].lastIndexOf("$")+1),pontic_tooth[i].length) ;
							} 
						}
						
						abutment = pontic_tooth_split_values.length-1;
						abutment_tooth_values = pontic_tooth_split_values[abutment];

						/*var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						
						var params_abutment_extract = "func_mode=getAbutmentToothExtraction&tooth_no="+abutment_tooth_values+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;

						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_abutment_extract,false);
						xmlHttp.send(xmlDoc);
						var retVal_abutment_extract = trimString(xmlHttp.responseText); 
						retVal_abutment_extract = localTrimString(retVal_abutment_extract);

						if(retVal_abutment_extract > 0){
							alert(getMessage("APP-OH000168","OH"));	
							return;
						} */
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params_abutment_extract = "func_mode=getAbutmentToothExtraction&tooth_no="+abutment_tooth_values+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_abutment_extract,false);
						xmlHttp.send(xmlDoc);
						var retVal_abutment_extract = trimString(xmlHttp.responseText); 
						retVal_abutment_extract = localTrimString(retVal_abutment_extract);
						
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
						var params_pontic_tooth = "func_mode=getPonticCutToothValues&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&trmt_category_type=BRIDGE";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_tooth,false);
						xmlHttp.send(xmlDoc);
						var retVal_bridge = trimString(xmlHttp.responseText); 
						retVal_bridge = localTrimString(retVal_bridge);
						
						if(retVal_bridge.length > 0){
							var retVal_pontic = retVal_bridge.split("##");
							
							formObj.pontic_tooth_values.value = retVal_pontic[0]; 
						}
					
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
						var retVal_pontic_arr = retVal_pontic[0].split("$$"); // Pontic Values
						var pontic_cut_length = 0;
						
						for(var j = 0; j< retVal_pontic_arr.length;j++){
							if(retVal_pontic_arr[j].length > 0){
								pontic_cut_length++;
							}
						}
						
						var pontic_length = 0;
						
						for(var i = 1; i< pontic_tooth_split_values.length-1;i++){
							pontic_length++;
						}
					
						if(retVal_abutment_extract > 0 &&  retVal_outcome_bridge == "S" && (pontic_cut_length != pontic_length)){
							alert(getMessage("APP-OH000168","OH"));	
							return;
						}
					}
					
					if(status == "E" && trmt_category_type == "EXTRACT"){
						var l = 0;
						var modalReturnedVal = "";	 // While mark Error marking the PONTIC_TOOTH_DTLS as null.
						var pontic_tooth_split_values_err = new Array();
						var pontic_tooth_err = new Array();

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params_bridge_extract = "func_mode=getTrmtCatCode&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
						xmlHttp.send(xmlDoc);
						var retVal_bridge_extract_err = trimString(xmlHttp.responseText); 
						retVal_bridge_extract_err = localTrimString(retVal_bridge_extract_err);
						pontic_tooth_err = retVal_bridge_extract_err.split(",") ;
										
						if(tooth_no == (retVal_bridge_extract_err.substring(retVal_bridge_extract_err.lastIndexOf("$")+1,retVal_bridge_extract_err.length))){	// toothno == to the last number in the bridge 
							for(i = pontic_tooth_err.length-1;i >= 0;i--,l++){

								pontic_tooth_split_values_err[l] = pontic_tooth_err[i].substring((pontic_tooth_err[i].lastIndexOf("$")+1),pontic_tooth_err[i].length) ;

							} 
						}else{
							for(i = 0; i < pontic_tooth_err.length;i++){
								pontic_tooth_split_values_err[i] = pontic_tooth_err[i].substring((pontic_tooth_err[i].lastIndexOf("$")+1),pontic_tooth_err[i].length) ;
							} 
						}

						/*var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params_pontic_tooth = "func_mode=getPonticCutToothValues&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&trmt_category_type=EXTRACT";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_tooth,false);
						xmlHttp.send(xmlDoc);
						var retVal_extract_pontics = trimString(xmlHttp.responseText); 
						retVal_extract_pontics = localTrimString(retVal_extract_pontics);
						retVal_extract_pontics = retVal_extract_pontics.split("##");*/

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
						xmlHttp.send(xmlDoc);
						var retVal_max_chart_line_num_err = trimString(xmlHttp.responseText); 
						retVal_max_chart_line_num_err = localTrimString(retVal_max_chart_line_num_err);

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params_pontic_tooth = "func_mode=getPonticCutToothValues&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num_err+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&trmt_category_type=BRIDGE";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_tooth,false);
						xmlHttp.send(xmlDoc);
						var retVal_bridge = trimString(xmlHttp.responseText); 
						retVal_bridge = localTrimString(retVal_bridge);

						if(retVal_bridge.length > 0){
							var retVal_pontic = retVal_bridge.split("##");
							formObj.pontic_tooth_values.value = retVal_pontic[0];
								for(var j =0; j < pontic_tooth_split_values_err.length; j++){
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+pontic_tooth_split_values_err[j]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
									xmlHttp.send(xmlDoc);
									var retVal_max_chart_line_num_err = trimString(xmlHttp.responseText); 
									retVal_max_chart_line_num_err = localTrimString(retVal_max_chart_line_num_err);

									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									var params_pontic_bridge_update = "func_mode=updateCutPonticTooth&tooth_no="+pontic_tooth_split_values_err[j]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num_err+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&tooth_nos="+modalReturnedVal+"&treatments_outcome="+treatments_outcome+"&trmt_category_type=BRIDGE";
																
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_bridge_update,false);
									xmlHttp.send(xmlDoc);
									var retVal_pontic_bridge_tooth = trimString(xmlHttp.responseText); 
									retVal_pontic_bridge_tooth = localTrimString(retVal_pontic_bridge_tooth);
									
								}
							}  
						}//End
					}

					//Added by Sridevi joshi on 2/11/2010 for IN010871(SRR20056-CRF-0478) to allow denture trmt of same category is recorded denture is removable.
					//if(trmt_category_type == "DENTURE" && status != "E" && formObj.called_from_viewchart_yn.value != 'Y'){
					if(status != "E" && formObj.called_from_viewchart_yn.value != 'Y'){
						if(site_type == "THRNG"){ 
							var upper_arch_yn = "N";
							var lower_arch_yn = "N";
							var tooth_no_arr = tooth_no.split(",");
							for (var k=0;k<tooth_no_arr.length; k++){
								
								if(tooth_no_arr[k] == "1"  || tooth_no_arr[k] == "16"){
									upper_arch_yn = "Y";
								}

								if(tooth_no_arr[k] == "17" || tooth_no_arr[k] == "32"){
									lower_arch_yn = "Y";
								}

								if(lower_arch_yn == "Y" && upper_arch_yn == "Y" && trmt_category_type == "DENTURE"){
									alert(getMessage("APP-OH000175","OH"));
									return;
								}
                               
								check_cat_type = populateConditionCode(formObj.oh_category,formObj.oh_treatment);

								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkCondTrmtRecorded&tooth_no="+tooth_no_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_trmt2 = trimString(xmlHttp.responseText); 
								retVal_trmt2 = localTrimString(retVal_trmt2);

								if(retVal_trmt2.length>1){
									var retVal_trmt2_arr = retVal_trmt2.split("~");
									for(var m=0;m<retVal_trmt2_arr.length-1;m++){
										var code_trmt_arr = retVal_trmt2_arr[m].split("##");
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										//params = "func_mode=checkForTreatments&tooth_no="+tooth_no_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=DENTURE&header_tab=T&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
										params = "func_mode=checkForTreatments&tooth_no="+tooth_no_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type="+code_trmt_arr[4]+"&header_tab=T&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
										xmlHttp.send(xmlDoc);
										var retVal_trmt_cat_code = trimString(xmlHttp.responseText); 
										retVal_trmt_cat_code = localTrimString(retVal_trmt_cat_code); 

										if(retVal_trmt_cat_code.length > 1){
											var retVal_trmt_cat_code_arr = retVal_trmt_cat_code.split("~");
											for(var h=0;h<retVal_trmt_cat_code_arr.length-1;h++){
												var thrng_val = "";
												var rec_trmt_arr = retVal_trmt_cat_code_arr[h].split("##");
												var denture_removable = rec_trmt_arr[1];
												var trmt_outcome = rec_trmt_arr[2];
												var rec_cat_code = rec_trmt_arr[3];
												var tooth_range = rec_trmt_arr[4];
												var treatments_status = rec_trmt_arr[5];

												if(code_trmt_arr[4] == "DENTURE"){
												//if(rec_cat_code != check_cat_type && denture_removable != "Y"){
													if(rec_cat_code != check_cat_type && denture_removable == "Y" && trmt_outcome != "F"){ //If recoding Denture with diffrent category on removable denture 
														if(trmt_category_type == "DENTURE"){//Added by Sridevi Joshi on 4/5/2010 for IN020492.This validation was firing for all treatments 
															alert(getMessage("APP-OH000173","OH"));
															return;
														}
													}
													else{
														//tooth_range:==6$$23,7$$24
														if(tooth_range != "" && tooth_range != "null" && tooth_range != null){
															var tooth_chart_arr = tooth_range.split(",");
															for(var g=0;g<tooth_chart_arr.length;g++){
																var tooth_range_arr = tooth_chart_arr[g].split("$$");
																if(thrng_val == ""){
																	thrng_val = tooth_range_arr[1];
																}
																else{
																	thrng_val = thrng_val+","+tooth_range_arr[1];
																}
															}

															
															if(thrng_val != tooth_no && trmt_outcome != "F"){
																diff_den_tooth = "Y";
															}
															else if(thrng_val == tooth_no && trmt_outcome != "F" && parseInt(treatments_status) < 25 && denture_removable != "Y"){
																failure_yn = "Y";
																diff_den_tooth = "N";
															}
															else if(thrng_val == tooth_no && trmt_outcome != "F" && parseInt(treatments_status) >= 25  && denture_removable != "Y" && denture_removable != "Y"){
																failure_yn = "Y";
																diff_den_tooth = "N";
															}
															else{
																failure_yn = "N";
																diff_den_tooth = "N";
															}
														}
														else{
															thrng_val = tooth_no;

															if(parseInt(treatments_status) < 25){
																diff_den_tooth = "N";
																failure_yn = "Y";
															}

															//if(trmt_outcome != "F" && parseInt(treatments_status) < 25){
															else if(trmt_outcome != "F"){
																diff_den_tooth = "N";
																failure_yn = "Y";
															}
														}
													}
												}
												else{ //Added by Sridevi Joshi on 3/3/2010 for CRF-477
													if(trmt_outcome != "F" && parseInt(treatments_status) < 25){
														diff_den_tooth = "N";
														failure_yn = "Y";
													}
												}
											}
													
											//if(diff_den_tooth == "Y" && failure_yn != "Y" ){
											if(diff_den_tooth == "Y" && trmt_category_type == "DENTURE"){//Denture cond is added by Sridevi Joshi on 4/5/2010 for IN020492.This validation was firing for all treatments 
												alert(getMessage("APP-OH000172","OH"));
												return;
											}

											if(failure_yn == "Y" && trmt_category_type == "DENTURE"){
												alert(getMessage("APP-OH000174","OH"));
												return;
											}
										}
									}
								}
							}
						}
						else if(site_type == "TOOTH" || site_type == "QUAD" || site_type == "ARCH"){
							check_cat_type = populateConditionCode(formObj.oh_category,formObj.oh_treatment);

							//Added by Sridevi Joshi on 3/3/2010 for IN010871(SRR20056-CRF-0478)
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=checkCondTrmtRecorded&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&arch_quad="+tooth_no+"&site="+site_type+"&header_tab=T&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_trmt2 = trimString(xmlHttp.responseText); 
							retVal_trmt2 = localTrimString(retVal_trmt2);

							if(retVal_trmt2.length>1){
								var retVal_trmt2_arr = retVal_trmt2.split("~");
								for(var m=0;m<retVal_trmt2_arr.length-1;m++){
									var code_trmt_arr = retVal_trmt2_arr[m].split("##");
									if(code_trmt_arr[6] == "THRNG" || code_trmt_arr[6] == "TOOTH" || code_trmt_arr[6] == "QUAD" || code_trmt_arr[6] == "ARCH"){ //Added by Sridevi Joshi on 3/18/2010---THRNG is added by Sridevi Joshi on 5/4/2010 for IN020148
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										//params = "func_mode=checkForTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&arch_quad="+tooth_no+"&site="+site_type+"&trmt_category_type=DENTURE&header_tab=T&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
										params = "func_mode=checkForTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&arch_quad="+tooth_no+"&site="+site_type+"&trmt_category_type="+code_trmt_arr[4]+"&header_tab=T&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;

										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
										xmlHttp.send(xmlDoc);
										var retVal_trmt_cat_code = trimString(xmlHttp.responseText); 
										retVal_trmt_cat_code = localTrimString(retVal_trmt_cat_code); 
										if(retVal_trmt_cat_code.length > 1){
											var retVal_trmt_cat_code_arr = retVal_trmt_cat_code.split("~");
											for(var h=0;h<retVal_trmt_cat_code_arr.length-1;h++){
												var thrng_val = "";
												var rec_trmt_arr = retVal_trmt_cat_code_arr[h].split("##");
												var denture_removable = rec_trmt_arr[1];
												var trmt_outcome = rec_trmt_arr[2];
												var rec_cat_code = rec_trmt_arr[3];
												var tooth_range = rec_trmt_arr[4];
												var treatments_status = rec_trmt_arr[5];

												//if(rec_cat_code != check_cat_type && denture_removable != "Y"){
												if(code_trmt_arr[4] == "DENTURE"){//Added by Sridevi Joshi on 3/3/2010 for IN010871(SRR20056-CRF-0478)
													if(rec_cat_code != check_cat_type && denture_removable == "Y" && trmt_outcome != "F"){
														if(trmt_category_type == "DENTURE"){//Added by Sridevi Joshi on 4/5/2010 for IN020492.This validation was firing for all treatments 
															alert(getMessage("APP-OH000173","OH"));
															return;
														}
													}
													else{
														//tooth_range:==6$$23,7$$24
														if(tooth_range != "" && tooth_range != "null" && tooth_range != null){
															var tooth_chart_arr = tooth_range.split(",");
															for(var g=0;g<tooth_chart_arr.length;g++){
																var tooth_range_arr = tooth_chart_arr[g].split("$$");
																if(thrng_val == ""){
																	thrng_val = tooth_range_arr[1];
																}
																else{
																	thrng_val = thrng_val+","+tooth_range_arr[1];
																}
															}
														}
														else{
															thrng_val = tooth_no;
															
														}
														if(thrng_val != tooth_no && trmt_outcome != "F" && trmt_category_type == "DENTURE"){//Denture cond is added by Sridevi Joshi on 4/5/2010 for IN020492.This validation was firing for all treatments 
															alert(getMessage("APP-OH000172","OH"));
															return;
														}
													}
													
													if(parseInt(treatments_status) < 25 && trmt_category_type == "DENTURE"){
														alert(getMessage("APP-OH000174","OH"));
														return;
													}
													else if(trmt_outcome != "F" && denture_removable != "Y" && trmt_category_type == "DENTURE"){
														alert(getMessage("APP-OH000174","OH"));
														return;
													}
												}
												else{//Added by Sridevi Joshi on 3/3/2010 for IN010870(SRR20056-CRF-0477)
													var msg = getMessage("APP-OH000105","OH");
													var msgArray = msg.split("##");
													var trmt_cat_desc_1 = document.forms[0].oh_category.options[document.forms[0].oh_category.selectedIndex].text;//Added by Sridevi Joshi on 3/30/2010 for IN020367
												//if condition commented by parul on 29/04/2010 for IN020998
												//	if(code_trmt_arr[4] == trmt_category_type){//Added by Sridevi Joshi on 3/30/2010 for IN020375 
														if(parseInt(treatments_status) < 25){ //Added by Sridevi Joshi on 3/5/2010 for IN010871(CRF-478)
															alert(msgArray[0]+trmt_cat_desc_1+msgArray[1]);//Commented above and added by Sridevi Joshi on 3/30/2010 for IN020367
															return;
														}
														else if(trmt_outcome != "F" && trmt_category_type == code_trmt_arr[4]){
															alert(msgArray[0]+trmt_cat_desc_1+msgArray[1]);//Commented above and added by Sridevi Joshi on 3/30/2010 for IN020367
															return;
														}
												//	}
												}
											}
										}
									}
								}
							}
						}
						else{//Added by Sridevi Joshi on 3/3/2010 for IN010870(SRR20056-CRF-0477)
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=checkCondTrmtRecorded&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_trmt = trimString(xmlHttp.responseText); 
							retVal_trmt = localTrimString(retVal_trmt);
							if(retVal_trmt.length>1){
								var retVal_trmt_arr = retVal_trmt.split("~");
								for(var m=0;m<retVal_trmt_arr.length-1;m++){
									var code_trmt_arr = retVal_trmt_arr[m].split("##");
									check_cat_type = populateConditionCode(formObj.oh_category,formObj.oh_treatment);
							
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();

									var surface_ref_arr=surface_ref.split(",");
									if (surface_ref_arr.length>1){
										for(var u=0;u<surface_ref_arr.length;u++){	
											params = "func_mode=checkForTreatmentsOnCrown&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&arch_quad="+tooth_no+"&site="+site_type+"&trmt_category_type="+code_trmt_arr[4]+"&surface_code="+surface_ref_arr[u]+"&header_tab=T";
										}
									}else{
										 params = "func_mode=checkForTreatmentsOnCrown&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&arch_quad="+tooth_no+"&site="+site_type+"&trmt_category_type="+code_trmt_arr[4]+"&header_tab=T";

									}

									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
									xmlHttp.send(xmlDoc);
									var retVal_trmt_cat_code = trimString(xmlHttp.responseText); 
									retVal_trmt_cat_code = localTrimString(retVal_trmt_cat_code); 
									if(retVal_trmt_cat_code.length > 1){
										var retVal_trmt_cat_code_arr = retVal_trmt_cat_code.split("~");
										for(var h=0;h<retVal_trmt_cat_code_arr.length-1;h++){
											var thrng_val = "";
											var rec_trmt_arr = retVal_trmt_cat_code_arr[h].split("##");
											var denture_removable = rec_trmt_arr[1];
											var trmt_outcome = rec_trmt_arr[2];
											var rec_cat_code = rec_trmt_arr[3];
											var tooth_range = rec_trmt_arr[4];
											var treatments_status = rec_trmt_arr[5];
											if(trmt_outcome != "F" && parseInt(treatments_status) < 25){
												alert(msgArray[0]+trmt_category_type+msgArray[1]);
												return;
											}
											else if(trmt_outcome != "F"  && parseInt(treatments_status) >= 25){
												alert(msgArray[0]+trmt_category_type+msgArray[1]);
												return;
											}
										}
									}
								}
							}
						}
					}
					
				//}
					//End 
					//return;

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
					//Added by Sharon Crasta on 3/24/2010 for IN019999
					// If a particular Order Set has got no enabled Order Catalogs associated with it, then display this message.
					else {
					   	// To check wheter the enabled catalogs are associated with a treatment or not...
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "trmt_code="+trmt_code;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getEnabledTasks&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						var enabled_tasks_count = localTrimString(retVal);
						if(enabled_tasks_count == 0){
							alert(getMessage("APP-OH000182","OH"));
							return;
						}
					} //End
				    
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
							//Added by Sharon Crasta on 2/22/2010 for SRR20056-CRF-0475(10868)
							var pontic_tooth_split_values = new Array();
							var k = 0;
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
							var params_pontic_tooth = "func_mode=getPonticCutToothValues&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&trmt_category_type=BRIDGE";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_tooth,false);
							xmlHttp.send(xmlDoc);
							var retVal_bridge = trimString(xmlHttp.responseText); 
							retVal_bridge = localTrimString(retVal_bridge);
							 
							if(retVal_bridge.length > 0){
								var retVal_pontic = retVal_bridge.split("##");
								formObj.pontic_tooth_values.value = retVal_pontic[0]; 
							}
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

							pontic_tooth = retVal_bridge_extract.split(",") ;
							if(tooth_no == (retVal_bridge_extract.substring(retVal_bridge_extract.lastIndexOf("$")+1,retVal_bridge_extract.length))){	// toothno == to the last number in the bridge 
								for(var j = pontic_tooth.length-1;j >= 0;j--,k++){

									pontic_tooth_split_values[k] = pontic_tooth[j].substring((pontic_tooth[j].lastIndexOf("$")+1),pontic_tooth[j].length) ;

								} 
							}else{
								for(j = 0; j < pontic_tooth.length;j++,k++){
									pontic_tooth_split_values[k] = pontic_tooth[j].substring((pontic_tooth[j].lastIndexOf("$")+1),pontic_tooth[j].length) ;
								} 
							}
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

							var oh_chart_level = document.forms[0].oh_chart_level.value;
							var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&treatment_int_ext=I"+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getStatusForBridge&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_status_for_bridge = localTrimString(xmlHttp.responseText);
				
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=EXTRACT";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
							xmlHttp.send(xmlDoc);
							var retVal_max_chart_line_num_ext = trimString(xmlHttp.responseText); 
							retVal_max_chart_line_num_ext = localTrimString(retVal_max_chart_line_num_ext);

							if(retVal_outcome_bridge == "" || retVal_outcome_bridge == "null" || retVal_outcome_bridge == null || retVal_outcome_bridge == "undefined" || retVal_outcome_bridge == undefined){
								retVal_outcome_bridge = "S";
							}
							
							if(retVal_bridge_extract.length > 0 && retVal_outcome_bridge == "S" && (document.forms[0].oh_category.value == "EXTRACT") && (retVal_status_for_bridge == "60" || retVal_status_for_bridge == "85") && retVal_max_chart_line_num_ext > retVal_max_chart_line_num) {
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=EXTRACT";
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
								xmlHttp.send(xmlDoc);
								var retVal_max_chart_line_num = trimString(xmlHttp.responseText); 
								retVal_max_chart_line_num = localTrimString(retVal_max_chart_line_num);

								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params_bridge_extract = "func_mode=getOutcomeForExtraction&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=EXTRACT";
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
								xmlHttp.send(xmlDoc);
								var retVal_outcome_ext = trimString(xmlHttp.responseText); 
								retVal_outcome_ext = localTrimString(retVal_outcome_ext);
								//Extraction Trmt - Success, Call from RHS record Success again for the same trmt, then the pontic window should not be called.If recording failure after success then it should be called.
								if(formObj.called_from_viewchart_yn.value == "Y" && ((retVal_outcome_ext == "" || retVal_outcome_ext == "null" || retVal_outcome_ext == null || retVal_outcome_ext == "undefined" || retVal_outcome_ext == undefined) || ( retVal_outcome_ext == "S" && treatments_outcome == "F"))) {

									 var params = "&patient_id="+patient_id+"&site_type="+site_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&pontic_tooth="+pontic_tooth_split_values+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&title_desc="+title_desc+"&numbering_system="+numbering_system;
									 
									 var url	= "../../eOH/jsp/PonticTooth.jsp?"+params;
										
									 var dialogHeight   = "35vh" ;
									 var dialogWidth	= "55vw" ;
									 var dialogTop      = "170";
									 var dialogLeft     = "300";  		
										
									 var status = "no";
									 var arguments	= "" ;
									 var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
									 modalReturnedVal = await window.showModalDialog(url,arguments,features);

								}else if(formObj.called_from_viewchart_yn.value != "Y") {
									
									 var params = "&patient_id="+patient_id+"&site_type="+site_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&pontic_tooth="+pontic_tooth_split_values+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&title_desc="+title_desc+"&numbering_system="+numbering_system;
									 
									 var url	= "../../eOH/jsp/PonticTooth.jsp?"+params;
										
									 var dialogHeight   = "35vh" ;
									 var dialogWidth	= "55vw" ;
									 var dialogTop      = "170";
									 var dialogLeft     = "300";  	
										
									 var status = "no";
									 var arguments	= "" ;
									 var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
									 modalReturnedVal =await window.showModalDialog(url,arguments,features);
								}
							}

						}
					}

					var order_id = formObj.order_id.value;
					var order_line_num = formObj.order_line_num.value;
					var treatment_flag = formObj.treatment_flag.value;

					if(formObj.called_from_viewchart_yn.value != 'Y'){
						//check for duplicate record...
						if(site_type == "MAXFS"){
							if(formObj.oh_selected_sub_parts != null){ //Added by Sridevi Joshi on 3/11/2010 
								tooth_no = formObj.oh_selected_sub_parts.value;
							}
						}

						var duplicate_record = checkForDuplicateTrmtRecord(status,patient_id,chart_num,tooth_no,trmt_category_type,surface_code,site_type,treatments_outcome);
						//var duplicate_record = true;
						
						if(!duplicate_record){
								return;
						}
					}

					if(treatment_status_param == 'E' && treatment_flag != "Y"){
						var task_code = formObj.task_code.value;
						var reasonforcancel = formObj.reasonforcancel.value;
						
						var task_order_catalog_code	= formObj.task_order_catalog_code.value;

						var bl_episode_id = formObj.bl_episode_id.value;
						var bl_encounter_id = formObj.bl_encounter_id.value ;
						var bl_visit_id = formObj.bl_visit_id.value;
						var bl_episode_type = formObj.bl_episode_type.value ;
						var surgeon_code = formObj.bl_pract_staff_id.value;
						var task_desc = formObj.task_desc.value ;
						var bl_key = formObj.bl_key.value;
						var bl_key_line_no = formObj.bl_key_line_no.value;
						var bl_panel_str = formObj.bl_panel_str.value;
						var bl_service_date = formObj.bl_service_date.value;
						var billing_appl_yn	= formObj.billing_appl_yn.value;
						var patient_class	= formObj.patient_class.value;

						if(order_id != ""){
							var status_for_filling	= updateTreatmentStatus(site_type,thrng_nos_ref,patient_id,chart_num,chart_line_num,'E',parseInt(chart_line_num),order_id,trmt_code,task_code,reasonforcancel,encounter_id,trmt_code,order_line_num,task_order_catalog_code, task_seq_no,bl_episode_id,bl_encounter_id,bl_visit_id,bl_episode_type,patient_class,surgeon_code,task_desc,bl_key,bl_key_line_no,escape(bl_panel_str),bl_service_date,billing_appl_yn,task_order_catalog_code,"","",ext_perm_loc_param,trmt_yn,trmt_done_yn);
						}//Added by Sharon Crasta on 2/15/2010 for IN019319
						//This block is used to cancel the teask when the order is not placed from OR and only placed from OH.
						else
						{
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&order_status_type=E"+"&trmt_code="+trmt_code+"&task_code="+task_code+"&reasonforcancel="+reasonforcancel+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&task_seq_no="+task_seq_no;
						   
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","../../eOH/jsp/DentalTrmtValidation.jsp?func_mode=updateTaskStatusForNullOrderId&"+params,false);
							xmlHttp.send(xmlDoc);
							var trmt_task_status = trimString(xmlHttp.responseText);
							trmt_task_status = localTrimString(trmt_task_status);
							var frame_msg = trmt_task_status;

							var msg = getMessage("RECORD_INSERTED", "SM");
							
							if(frame_msg == "GET_MSG"){
								messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;			
							} 
						}  //End
						//Cancel the OA appt on cancellation of a task 
						/*var appt_ref_no = formObj.appt_ref_num0.value;
						if(appt_ref_no != "" ){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&appt_ref_no="+appt_ref_no+"&reason_for_cancel="+reasonforcancel;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=cancelOAAppt&"+params,false);
							xmlHttp.send(xmlDoc);
							var retValue_oaappt_cancel = trimString(xmlHttp.responseText); 
						}  */
						//End
						
					}
					else if(treatment_status_param == 'E' && treatment_flag == "Y"){//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
						var reasonforcancel = formObj.reasonforcancel.value;
						if(site_type == "THRNG" || site_type == "MAXFS"){ 
							var tooth_no_arr = tooth_no.split(",");
							var chart_line_num_insert = parseInt(chart_line_num);  
							for (var k=0;k<tooth_no_arr.length; k++){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "facility_id="+facility_id+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num_insert+"&trmt_code="+trmt_code+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id=="+other_chart_facility_id;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getTaskStatusForTrmtCancel&"+params,false);
								xmlHttp.send(xmlDoc);
								var flag_for_cancel = trimString(xmlHttp.responseText);
								flag_for_cancel = localTrimString(flag_for_cancel);
								if(flag_for_cancel == "Y"){
									//Added by Sharon Crasta on 2/15/2010 for IN019319
									//This block is used to cancel the teask when the order is not placed from OR and only placed from OH.
									if(order_id == ""){
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num_insert+"&order_status_type=E"+"&trmt_code="+trmt_code+"&reasonforcancel="+reasonforcancel+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","../../eOH/jsp/DentalTrmtValidation.jsp?func_mode=updateTrmtStatusForNullOrderId&"+params,false);
										xmlHttp.send(xmlDoc);
										var trmt_task_status = trimString(xmlHttp.responseText);
										trmt_task_status = localTrimString(trmt_task_status);
									}
									else{ //End
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&order_status_type=E"+"&order_id="+order_id+"&trmt_code="+trmt_code+"&encounter_id="+encounter_id+"&order_line_num="+order_line_num+"&reasonforcancel="+reasonforcancel;
															
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","../../eOH/jsp/DentalTrmtValidation.jsp?func_mode=updateTrmtStatus&"+params,false);
										xmlHttp.send(xmlDoc);
										var trmt_task_status = trimString(xmlHttp.responseText);
										trmt_task_status = localTrimString(trmt_task_status);
										
									}
									var frame_msg = trmt_task_status;
									var msg = getMessage("RECORD_INSERTED", "SM");
									
									if(frame_msg == "GET_MSG"){
										messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;			
									}
								}else{
									alert(getMessage("APP-OH000118", "OH"));
									return;
								}
								chart_line_num_insert = parseInt(chart_line_num_insert) + 1; 
							}
						}else{
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "facility_id="+facility_id+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id=="+other_chart_facility_id;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getTaskStatusForTrmtCancel&"+params,false);
							xmlHttp.send(xmlDoc);
							var flag_for_cancel = trimString(xmlHttp.responseText);
							flag_for_cancel = localTrimString(flag_for_cancel);
							if(flag_for_cancel == "Y"){
								//Added by Sharon Crasta on 2/15/2010 for IN019319
								//This block is used to cancel the teask when the order is not placed from OR and only placed from OH.
								if(order_id == ""){
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&order_status_type=E"+"&trmt_code="+trmt_code+"&reasonforcancel="+reasonforcancel+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","../../eOH/jsp/DentalTrmtValidation.jsp?func_mode=updateTrmtStatusForNullOrderId&"+params,false);
									xmlHttp.send(xmlDoc);
									var trmt_task_status = trimString(xmlHttp.responseText);
									trmt_task_status = localTrimString(trmt_task_status);
								}
								else{ //End
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&order_status_type=E"+"&order_id="+order_id+"&trmt_code="+trmt_code+"&encounter_id="+encounter_id+"&order_line_num="+order_line_num+"&reasonforcancel="+reasonforcancel;
														
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","../../eOH/jsp/DentalTrmtValidation.jsp?func_mode=updateTrmtStatus&"+params,false);
									xmlHttp.send(xmlDoc);
									var trmt_task_status = trimString(xmlHttp.responseText);
									trmt_task_status = localTrimString(trmt_task_status);
									
								}
								var frame_msg = trmt_task_status;
								var msg = getMessage("RECORD_INSERTED", "SM");
								
								if(frame_msg == "GET_MSG"){
									messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;			
								}
							}else{
								alert(getMessage("APP-OH000118", "OH"));
								return;
							}
						}
						
					}
					else if(treatment_status_param == 'A'){
						var episode_id = formObj.episode_id.value;
						var encounter_id = formObj.encounter_id.value ;
						var visit_id = formObj.bl_visit_id.value;
						var episode_type = formObj.bl_episode_type.value ;
						var patient_class	= formObj.patient_class.value;

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getOrderSetId&"+params,false);
						xmlHttp.send(xmlDoc);
						var order_set_id_retVal = trimString(xmlHttp.responseText);
						order_set_id_retVal = localTrimString(order_set_id_retVal);

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getMaxSeqNoOfTask&"+params,false);
						xmlHttp.send(xmlDoc);
						var seq_no_retVal = trimString(xmlHttp.responseText);
						seq_no_retVal = localTrimString(seq_no_retVal);
						seq_no_retVal = parseInt(seq_no_retVal) + 1;

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&order_id="+order_id;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getSeqNoOfTask&"+params,false);
						xmlHttp.send(xmlDoc);
						var task_seq_no_retVal = trimString(xmlHttp.responseText);
						task_seq_no_retVal = localTrimString(task_seq_no_retVal);
						task_seq_no_retVal_arr = task_seq_no_retVal.split("##");

						task_seq_no = task_seq_no_retVal_arr[1];

						var row_seq =	formObj.row_seq.value;

						if(row_seq == "RB" ){
							task_seq_no = parseInt(task_seq_no) + 1;						
						}

						var task_code =	formObj.tasks_applicable.value;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();

						episode_id = encounter_id.substring(0,8);
						visit_id = encounter_id.substring(8,encounter_id.length);
						//Added by Sharon Crasta on 2/28/2010 for IN019744
						//In the DB, the number of tooth, that many tasks should be added while adding a new task.
												
						if(site_type == "THRNG" || site_type == "MAXFS"){ 
							var tooth_no_arr = tooth_no.split(",");
							var chart_line_num_insert = parseInt(chart_line_num) + 1;  
							for (var k=0;k<tooth_no_arr.length; k++){
								if(k == 0){
									var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&order_set_id="+order_set_id_retVal+"&order_set_line_num=1"+"&encounter_id="+encounter_id+"&episode_id="+episode_id+"&visit_id="+visit_id+"&patient_class="+patient_class+"&seq_no="+seq_no_retVal+"&task_seq_no="+task_seq_no+"&location_code="+location_code+"&location_type="+location_type;
							
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=insertNewTask&"+params,false);
									xmlHttp.send(xmlDoc);
									var retValue = trimString(xmlHttp.responseText);
								}
								else{
									//var chart_line_num_insert = parseInt(chart_line_num) + 1;
									var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&order_set_id="+order_set_id_retVal+"&order_set_line_num=1"+"&encounter_id="+encounter_id+"&episode_id="+episode_id+"&visit_id="+visit_id+"&patient_class="+patient_class+"&seq_no="+seq_no_retVal+"&task_seq_no="+task_seq_no+"&location_code="+location_code+"&location_type="+location_type+"&chart_line_num_insert="+chart_line_num_insert;

									chart_line_num_insert = parseInt(chart_line_num_insert) + 1;

									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=insertTaskForToothRange&"+params,false);
									xmlHttp.send(xmlDoc);
									var retValue = trimString(xmlHttp.responseText);
								} 
							}
						}else{	//End
								var params = 	"patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&order_set_id="+order_set_id_retVal+"&order_set_line_num=1"+"&encounter_id="+encounter_id+"&episode_id="+episode_id+"&visit_id="+visit_id+"&patient_class="+patient_class+"&seq_no="+seq_no_retVal+"&task_seq_no="+task_seq_no+"&location_code="+location_code+"&location_type="+location_type;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=insertNewTask&"+params,false);
								xmlHttp.send(xmlDoc);
								var retValue = trimString(xmlHttp.responseText);
						}

						var msg = getMessage("RECORD_INSERTED", "SM");
						messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
					} 
					else{
						if(treatment_status_param=="10" && appt_reqd_yn=="Y"){// this condition is added by bshankar on 09FEB2008. If appt_reqd_yn is YES, scheduling is applicable
							var tFormObj = document.OHTreatmentForm;
							var schedule_yn = getApptDetails('', '', tFormObj.patient_id.value, '',tFormObj.ca_practitioner_id.value,tFormObj.location_code.value,'',tFormObj.location_code.value,tFormObj.location_type.value,'',tFormObj.ca_practitioner_id.value,tFormObj.location_code.value,"OH","OH",'','','',tFormObj.chart_num.value,tFormObj.chart_line_num.value,trmt_category_type,tooth_no,dentalchartFormObj,site_type,surface_code,tFormObj.oh_area.value,tFormObj.oh_area.value,thrng_nos_ref,formObj.order_id.value,formObj.order_line_num.value,formObj.trmt_code.value,formObj.task_code.value,formObj.task_seq_no.value);
							
							if(schedule_yn){
								var seq_no = formObj.seq_no.value;
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&seq_no="+task_seq_no;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=updateFacilityId&"+params,false);
								xmlHttp.send(xmlDoc);
								var returnVal = trimString(xmlHttp.responseText);
								schedule_yn_flag = true;
							}
						}else if( (treatment_status_param=="10" && appt_reqd_yn=="N") || (treatment_status_param=="15")){// this condition is added by bshankar on 09FEB2008. If appt_reqd_yn is NO, scheduling is not applicable and directly REGISTER function to be invoked
							// Invoke the Register Order
							// Check getStatusOfPrevTask here
							var seq_no = formObj.seq_no.value;
							var task_seq_no = formObj.task_seq_no.value;
							// Added by yadav  for CRF-443 on 1/21/2010
							var regDateTime="";
							var rVal="";
							var reg_date="";
							var reg_time="";
							if(parseInt(treatment_status_param)>=15){
								reg_date=formObj.regDate.value;
								var regDateObj=formObj.regDate;
								reg_time=formObj.regTime.value;
								var locale=formObj.locale.value;
								var orderDate=formObj.orderDate.value;

								if(orderDate=='undefined'||orderDate=="null"||orderDate==null) orderDate=""
									
								regDateTime=reg_date+" "+reg_time;
							}

							if(reg_date!="" && orderDate!=""){
								var flagOne=checkRegDateNotGraterThanSysDate(regDateTime);
								if (flagOne==true){ 
									rVal=compareDates(orderDate,regDateTime);
								}
								else{
									//formObj.regDate.value="";
									//formObj.regTime.value="";
									rVal=false;
									return false;
								}
							
							}
							else {
								rVal=true;
							}

							if(rVal==true){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&seq_no="+task_seq_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id=="+other_chart_facility_id+"&reg_date_time="+regDateTime;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getScheduledDateTime&"+params,false);
								xmlHttp.send(xmlDoc);
								var returnVal = localTrimString(xmlHttp.responseText);
								//if(checkDateGreaterThanScheduleDate(returnVal,messageFrame)){
								if(parseInt(task_seq_no)>1){
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									//yadav
									//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&seq_no="+seq_no+"&task_seq_no="+task_seq_no+"&order_id="+order_id+"&order_line_num="+order_line_num+"&billing_appl_yn="+billing_appl_yn+"&reg_date_time="+regDateTime;
									var task_status_orig = formObj.task_status_orig.value;
									var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&seq_no="+seq_no+"&task_seq_no="+task_seq_no+"&order_id="+order_id+"&order_line_num="+order_line_num+"&billing_appl_yn="+billing_appl_yn+"&reg_date_time="+regDateTime+"&treatment_status_param="+task_status_orig;
																					
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=getStatusOfPrevTask&"+params,false);
									xmlHttp.send(xmlDoc);
									var prev_task_resulted_yn = trimString(xmlHttp.responseText);
									prev_task_resulted_yn = localTrimString(prev_task_resulted_yn);
									//  commented  By yadav For CRF-443
									if(prev_task_resulted_yn != "Y"){
										alert(getMessage("APP-OH000157","OH"));
										return ;
									}
								}
								if(checkDateGreaterThanScheduleDate(returnVal,messageFrame)){
									var return_status_flag = showRegisterOrder('register');//Commented for IN010893(SRR20056-CRF-0480)	
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									var params = "facility_id="+facility_id+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&seq_no="+task_seq_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id=="+other_chart_facility_id+"&reg_date_time="+regDateTime+"&treatment_status_param="+task_status_orig;
									//
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getTaskStatus&"+params,false);
									xmlHttp.send(xmlDoc);
									var returnVal = trimString(xmlHttp.responseText);
									
									if(!return_status_flag){//Added by Sharon Crasta on 7/14/2009 for IN011250
										if(returnVal != "" || returnVal!=null || returnVal!="undefined" || returnVal!="null" ){
											if(parseInt(returnVal) != "25"){
												callBillingWindow(patient_id,chart_num,chart_line_num,trmt_code,task_code,bill_sub_regn_num,bill_sub_regn_line_num,ca_practitioner_id);
												refresh_yn = "N";
											}
										}
									}
								}
							} 
							else{
								return false;
							}
						} 
						else if((treatment_status_param=="25" || treatment_status_param == "52"|| treatment_status_param =="55"|| treatment_status_param=="80" || treatment_status_param =="70") && (result_entry_status != "85" && result_entry_status != "60")){
							// Invoke the Result Entry Screen
							var seq_no = formObj.seq_no.value;
							var task_seq_no = formObj.task_seq_no.value;
							if(parseInt(task_seq_no)>1){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								//yadav
								//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&seq_no="+seq_no+"&task_seq_no="+task_seq_no+"&order_id="+order_id+"&order_line_num="+order_line_num+"&billing_appl_yn=="+billing_appl_yn;
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&seq_no="+seq_no+"&task_seq_no="+task_seq_no+"&order_id="+order_id+"&order_line_num="+order_line_num+"&billing_appl_yn=="+billing_appl_yn+"&treatment_status_param="+treatment_status_param;

								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=getStatusOfPrevTask&"+params,false);
								xmlHttp.send(xmlDoc);
								var prev_task_resulted_yn = trimString(xmlHttp.responseText);
								prev_task_resulted_yn = localTrimString(prev_task_resulted_yn);
								if(prev_task_resulted_yn != "Y"){
									alert(getMessage("APP-OH000166","OH"));
									return;
								}
							}
							
							
							//Added by Sharon Crasta on 10/13/2008
							// Functions called to check 
							//if Treatment Start Date is < Registration Date, Treatment Start Date/End Date is greater than sysdate,Treatment End Date is < Start Date.
							if(checkDateGreaterThanRegDate(formObj.regn_date_time1.value) && checkStartDateNotGreaterThanSysDate() && checkEndDateNotGreaterThanSysDate() && checkDates() && checkProgressNotesComplYN()){
								status_for_filling = showRegisterOrder('result');
								
							} else {
								return false;
							}
						}
						else if(treatment_status_param == "PO" || status == "PO"){
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
								order_catalog_code = retVal_arr[0];
								order_type_code = retVal_arr[1];
							}

							var multiple_surfaces_applicable="N";
							if (surface_code.length>2 && surface_code!="*A"){
								multiple_surfaces_applicable="Y";
							}												
							placeOrder(patient_id,chart_num,chart_line_num,tooth_range_count_for_order,ca_practitioner_id,formObj.encounter_id.value,formObj.location_type.value,formObj.location_code.value,formObj.patient_class.value,order_catalog_code,order_type_code,formObj.facility_id.value,trmt_code,"RHS_MENU",trmt_category_type,site_type,surface_code,tFormObj.oh_area.value,thrng_nos_ref,tFormObj.oh_area.value,tFormObj.oh_area.value,cusptip_ref,RD_Normal_yn,super_tooth_ref,exfolth_count,retained_tooth_no,surface_code,multiple_surfaces_applicable);

						}else{
							if(trmt_category_type == "IMPLANT" ){//Added By Sridevi Joshi on 12/23/2009 for IN017540 to restrict the Implant trmt on extraction if it is not completed yet.
							   	var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
								
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForExtract&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_extract_type = trimString(xmlHttp.responseText);
								retVal_extract_type = localTrimString(retVal_extract_type);

								if(retVal_extract_type.length > 0){
									if(retVal_extract_type != "60" && retVal_extract_type != "85"){
										//Commented and Added by Sharon Crasta on 2/27/2010 for SRR20056-CRF-0475(IN010868)
										var msg =  getMessage("APP-OH000147",'OH');
										var msg_arr = msg.split("##");
										alert(msg_arr[0] + trmt_category_type + msg_arr[1]);
										return;
									}
								}
							}
							//Added by Sharon Crasta on 2/27/2010 for SRR20056-CRF-0475(IN010868) to restrict the Bridge trmt on extraction if it is not completed.
							if(trmt_category_type == "BRIDGE"){
								if(formObj.called_from_viewchart_yn.value != "Y"){
									var nors_arr = thrng_nos_ref.split(",");
									for(var j=0;j<nors_arr.length;j++){
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "tooth_no="+nors_arr[j]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForExtract&"+params,false);
										xmlHttp.send(xmlDoc);
										var retVal_extract_type = trimString(xmlHttp.responseText);
										retVal_extract_type = localTrimString(retVal_extract_type);

										if(retVal_extract_type.length > 0){
											if(retVal_extract_type != "60" && retVal_extract_type != "85"){
												//Commented and Added by Sharon Crasta on 2/27/2010 for SRR20056-CRF-0475(IN010868)
												var msg =  getMessage("APP-OH000147",'OH');
												var msg_arr = msg.split("##");
												alert(msg_arr[0] + trmt_category_type + msg_arr[1]);
												return;
											}
										}
									}
								}
							}
							//Added by Sharon Crasta on 2/27/2010 for SRR20056-CRF-0475(IN010868)
							//Once Bridge is Ordered, cannot record Extraction on it.
							if(trmt_category_type == "EXTRACT"){
								if(formObj.called_from_viewchart_yn.value != "Y"){
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForBridge&"+params,false);
									xmlHttp.send(xmlDoc);
									var retVal_bridge_type = trimString(xmlHttp.responseText);
									retVal_bridge_type = localTrimString(retVal_bridge_type);

									if(retVal_bridge_type.length > 0){
										if(retVal_bridge_type != "60" && retVal_bridge_type != "85"){
											alert(getMessage("APP-OH000171",'OH'));
											return;
										}
									}
								}
							}//End
							var RD_Normal_yn=document.forms[0].RD_Normal_yn.value;

							 if(super_tooth_ref == "RD"){//Added by parul on 08/01/2010 for RTDESTH new changes
							//Added by parul on 08/01/2010 for RTDESTH new changes TO GET mapped tooth no
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
						//	if(status != "E"){
						if(status != "E" && formObj.called_from_viewchart_yn.value != 'Y'){ 

								if(ref_tooth_no == "" || ref_tooth_no == "null" || ref_tooth_no == null){ //This block is addded to clear the ROOT and crown images while marking error any condition.. added by Sridevi joshi on 12/21/2009 for IN010894(CRF-481)
									if(permanent_deciduous_flag == "D" && mixed_dentition_YN == "Y"){
										//To retrieve chart_line_num if ERUPTH is recorded
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=ERUPTH";
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
										xmlHttp.send(xmlDoc);
										var erupth_chart_line_num = trimString(xmlHttp.responseText);
										erupth_chart_line_num = localTrimString(erupth_chart_line_num);

										if(erupth_chart_line_num.length > 0){ //This is to change the ROOT image if tooth is Erupted(specially when we click on super tooth)
											if(tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31"){
												var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
											}else{
												var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
											}
										}
										else{
											if(tooth_no == "33" || tooth_no == "34"){
												var imageSrc = "../../eOH/images/R3.gif";
											}
											else if(tooth_no == "41" || tooth_no == "42"){
												var imageSrc = "../../eOH/images/R14.gif";
											}
											else if(tooth_no == "43" || tooth_no == "44"){
												var imageSrc = "../../eOH/images/R19.gif";
											}
											else if(tooth_no == "51" || tooth_no == "52"){
												var imageSrc = "../../eOH/images/R30.gif";
											}
											else{
												if(tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31"){
													var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
												}else{
													var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
												}
											}
										}
									}
									else if(permanent_deciduous_flag == "D" && mixed_dentition_YN == "N"){
										if(tooth_no == "33" || tooth_no == "34"){
											var imageSrc = "../../eOH/images/R3.gif";
										}
										else if(tooth_no == "41" || tooth_no == "42"){
											var imageSrc = "../../eOH/images/R14.gif";
										}
										else if(tooth_no == "43" || tooth_no == "44"){
											var imageSrc = "../../eOH/images/R19.gif";
										}
										else if(tooth_no == "51" || tooth_no == "52"){
											var imageSrc = "../../eOH/images/R30.gif";
										}
										else{
											if(tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31"){
												var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
											}else{
												var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
											}
										}
									}
									else{
										var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
									}

									if((site_type != "" && site_type != "null" && site_type != null && site_type != "undefined" && site_type != undefined) && site_type != "ARCH" && site_type != "QUAD" && site_type != "THRNG" && site_type != "MAXFS" && site_type != "MOUTH"){ //Added by Sridevi Joshi on 1/21/2010 for IN010894--Mouth condition is added by Sridevi Joshi on 3/11/2010
										var imageId = "R"+tooth_no;
										dentalChartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','','"+super_tooth_ref+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";

										var imageId = "T"+tooth_no;
										dentalChartFormObj.document.getElementById(imageId).innerHTML = "<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','','"+super_tooth_ref+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'></div>";

										dentalChartFormObj.document.getElementById(tooth_no).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_no+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table>";

										if((permanent_deciduous_flag=="P" && (tooth_no =="1" || tooth_no =="16" || tooth_no =="17" || tooth_no =="32")) || (mixed_dentition_YN == "Y" && (tooth_no =="2" || tooth_no =="3" || tooth_no =="14" || tooth_no =="15" || tooth_no =="18" || tooth_no =="19" || tooth_no =="30" || tooth_no =="31"))){
											if(super_tooth_ref == "" || super_tooth_ref == "undefined" || super_tooth_ref == undefined){ //Added by Sridevi Joshi on 1/29/2010 for IN010894 ...SUPRTH-->Record Some comdition on super tooth, root and crown images were not displayed.
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
												var tooth_sn = tooth_no;

												var imageId = "T"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
									
												var imageId = "R"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>"

												var imageId = tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="&nbsp;";
											}
										}
									}
								}
							}
                            //commented change is for IN021288 done by parul on 12/05/2010

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "trmt_code="+trmt_code;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getLongDescofTasks&"+params,false);
							xmlHttp.send(xmlDoc);
							var gettasks_count = trimString(xmlHttp.responseText);
							gettasks_count = localTrimString(gettasks_count);
							var gettasks_count_arr = gettasks_count.split("~");
							var task_name="";
								for(var p=0;p<gettasks_count_arr.length-1;p++){
									if(task_name == ""){
										task_name =gettasks_count_arr[p]; 
									}
									else{
										task_name = task_name+","+gettasks_count_arr[p]; 
									}
								}

							
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "trmt_code="+trmt_code;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=chkTASKCODE&"+params,false);
							xmlHttp.send(xmlDoc);
							var retval_task = trimString(xmlHttp.responseText);
							retval_task = localTrimString(retval_task);
							var retval_task_arr = retval_task.split("~");
							var task_codevalue="";
							for(var z=0;z<retval_task_arr.length-1;z++){
								task_codevalue=retval_task_arr[z];
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "task_code="+task_codevalue;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForEFF_STATUS&"+params,false);
								xmlHttp.send(xmlDoc);
								var retval_status = trimString(xmlHttp.responseText);
								retval_status = localTrimString(retval_status);	
                               
								if(gettasks_count.length>1){//if more than one task is associated with trmt
									if (retval_status!="E"){//when Order Catalogs(EFF_STATUS) is not  Enabled
										var msg = getMessage("APP-OH000184","OH");
										var msg_arr = msg.split("##");
										if ((confirm_msg==undefined || confirm_msg=="undefined") &&(status != "60" && status != "85")){
											var confirm_msg=window.confirm(msg_arr[0]+"'"+task_name+"'"+msg_arr[1]);
										}
									
									if(status != "60" && status != "85"){
										
										if(confirm_msg==true){
											var xmlDoc = "" ;
											var xmlHttp = new XMLHttpRequest();
											var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
											var xmlStr ="<root><SEARCH ";
											xmlStr +=" /></root>";
											xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
											xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateTrmtCatType&"+params,false);
											xmlHttp.send(xmlDoc);
											var retVal_type = trimString(xmlHttp.responseText);
											retVal_type = localTrimString(retVal_type);
											if(retVal_type.length>1){
												var retVal_type_arr = retVal_type.split("~")
												for(k=0;k<=retVal_type_arr.length;k++){
													if(retVal_type_arr[k] != "EXTRACT" && trmt_category_type == retVal_type_arr[k]){
														var moblty_flag="";
														var xmlDoc = "" ;
														var xmlHttp = new XMLHttpRequest();
														var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&site_type="+site_type;
														var xmlStr ="<root><SEARCH ";
														xmlStr +=" /></root>";
														xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
														xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateCheckMobility&"+params,false);
														xmlHttp.send(xmlDoc);
														var retVal = trimString(xmlHttp.responseText);
														retVal = localTrimString(retVal);
														if(retVal.length > 0){
															moblty_flag = retVal;
															if(moblty_flag=="Y" ){
																var xmlDoc = "" ;
																var xmlHttp = new XMLHttpRequest();
																var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
																var xmlStr ="<root><SEARCH ";
																xmlStr +=" /></root>";
																xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
																xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateMobilityDisplayCondition&"+params,false);
																xmlHttp.send(xmlDoc);
																var retVal1 = trimString(xmlHttp.responseText);
																retVal1 = localTrimString(retVal1);
																if(retVal1!='Y'){
																	var confirm_msg=window.confirm(getMessage("APP-OH000123","OH"));
																	if(confirm_msg==true){
																		formObj.submit();
																	}
																}else{
																	formObj.submit();
																}
																}else{
																	formObj.submit();
																}
															}else{
																formObj.submit();
															}
														}
													else{
														
													}
												}
											}

											if(trmt_category_type == "EXTRACT"){
												formObj.submit();
												 break;
											}
											
										}else{
										   break;
										}
									}else{
											formObj.submit();
										}
                                        break;
									}
								}else{
								//when Order Catalogs(EFF_STATUS) is Enabled or we clicked on cancel tab
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateTrmtCatType&"+params,false);
									xmlHttp.send(xmlDoc);
									var retVal_type = trimString(xmlHttp.responseText);
									retVal_type = localTrimString(retVal_type);
									if(retVal_type.length>1){
										var retVal_type_arr = retVal_type.split("~")
										for(k=0;k<=retVal_type_arr.length;k++){
											if(retVal_type_arr[k] != "EXTRACT" && trmt_category_type == retVal_type_arr[k]){
												var moblty_flag="";
												var xmlDoc = "" ;
												var xmlHttp = new XMLHttpRequest();
												var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
												var xmlStr ="<root><SEARCH ";
												xmlStr +=" /></root>";
												xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
												xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateCheckMobility&"+params,false);
												xmlHttp.send(xmlDoc);
												var retVal = trimString(xmlHttp.responseText);
												retVal = localTrimString(retVal);
												if(retVal.length > 0){
													moblty_flag = retVal;
													if(moblty_flag=="Y" ){
														var xmlDoc = "" ;
														var xmlHttp = new XMLHttpRequest();
														var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
														var xmlStr ="<root><SEARCH ";
														xmlStr +=" /></root>";
														xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
														xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateMobilityDisplayCondition&"+params,false);
														xmlHttp.send(xmlDoc);
														var retVal1 = trimString(xmlHttp.responseText);
														retVal1 = localTrimString(retVal1);
														if(retVal1!='Y'){
															var confirm_msg=window.confirm(getMessage("APP-OH000123","OH"));
															if(confirm_msg==true){
																formObj.submit();
															}
														}else{
															formObj.submit();
														}
														}else{
																formObj.submit();
														}
													}else{
														formObj.submit();
													}
												}
											else{
												
											}
										}
									}

									if(trmt_category_type == "EXTRACT"){
										formObj.submit();
										break;
									}
								  break;
								}

									/*	var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateTrmtCatType&"+params,false);
										xmlHttp.send(xmlDoc);
										var retVal_type = trimString(xmlHttp.responseText);
										retVal_type = localTrimString(retVal_type);
										if(retVal_type.length>1){
											var retVal_type_arr = retVal_type.split("~")
											for(k=0;k<=retVal_type_arr.length;k++){
												if(retVal_type_arr[k] != "EXTRACT" && trmt_category_type == retVal_type_arr[k]){
													var moblty_flag="";
													var xmlDoc = "" ;
													var xmlHttp = new XMLHttpRequest();
													var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
													var xmlStr ="<root><SEARCH ";
													xmlStr +=" /></root>";
													xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
													xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateCheckMobility&"+params,false);
													xmlHttp.send(xmlDoc);
													var retVal = trimString(xmlHttp.responseText);
													retVal = localTrimString(retVal);
													if(retVal.length > 0){
														moblty_flag = retVal;
														if(moblty_flag=="Y" ){
															var xmlDoc = "" ;
															var xmlHttp = new XMLHttpRequest();
															var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
															var xmlStr ="<root><SEARCH ";
															xmlStr +=" /></root>";
															xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
															xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateMobilityDisplayCondition&"+params,false);
															xmlHttp.send(xmlDoc);
															var retVal1 = trimString(xmlHttp.responseText);
															retVal1 = localTrimString(retVal1);
															if(retVal1!='Y'){
																var confirm_msg=window.confirm(getMessage("APP-OH000123","OH"));
																if(confirm_msg==true){
																	formObj.submit();
																}
															}else{
																formObj.submit();
															}
															}else{
																formObj.submit();
															}
														}else{
															formObj.submit();
														}
													}
												else{
													
												}
											}
										}

										if(trmt_category_type == "EXTRACT"){
											formObj.submit();
										}*/

							}
						}
					}
					//Added by Sharon Crasta on 2/22/2010 for IN019266
					//Added to enable the Print Chart icon when directly a trmt is recorded for a new patient
					if(treatment_status_param != "A"){
						if(treatment_status_param=="25" || treatment_status_param == "52"|| treatment_status_param =="55"|| treatment_status_param=="80" || treatment_status_param =="70" && result_entry_status == "85" && result_entry_status == "60") {
							parent.parent.parent.parent.frames[0].document.getElementById("print_img").disabled = false;						
						}else{

							parent.parent.parent.frames[0].document.getElementById("print_img").disabled = false;
						}
					}
					//End
					var treatment_status_param_for_refresh = formObj.treatment_status_param.value;
					if(refresh_yn == "Y" || treatment_status_param_for_refresh=="52" || treatment_status_param_for_refresh=="55" || treatment_status_param_for_refresh=="80" || treatment_status_param_for_refresh=="60"){
						if(ext_perm_loc_param == "Y" || (status_for_ext_loc_int >=25 && trmt_yn !="Y" && trmt_done_yn != "Y")){//Added by Sridevi Joshi for CRF-702(IN012606)
							parent.parent.frames[2].expandMenu('menu1',parent.parent.frames[2].document.forms[0].T_arrow);
							var el_menu1 = parent.parent.frames[2].document.getElementById("menu1");
							var refresh_form_obj = parent.parent.frames[2].document.forms[0];
						}
						else{
							parent.frames[2].expandMenu('menu1',parent.frames[2].document.forms[0].T_arrow);
							var el_menu1 = parent.frames[2].document.getElementById("menu1");
							var refresh_form_obj = parent.frames[2].document.forms[0];
						}
						
						if ( el_menu1.style.display != "none" ) {
							el_menu1.style.display = 'none';
							refresh_form_obj.T_arrow.src = "../../eOH/images/arrow-down.gif";
						}
						else {
							el_menu1.style.display = '';
							refresh_form_obj.T_arrow.src = "../../eOH/images/arrow-up.gif";
						}

						if(ext_perm_loc_param == "Y" || (status_for_ext_loc_int >=25 && trmt_yn !="Y" && trmt_done_yn != "Y")){//Added by Sridevi Joshi for CRF-702(IN012606)
							parent.parent.frames[2].expandMenu('menu5',parent.parent.frames[2].document.forms[0].T_arrow);
							var el = parent.parent.frames[2].document.getElementById("menu5");
						}else{
							parent.frames[2].expandMenu('menu5',parent.frames[2].document.forms[0].T_arrow);
							var el = parent.frames[2].document.getElementById("menu5");
						}

						if ( el.style.display != "none" ) {
							el.style.display = 'none';
							refresh_form_obj.T_arrow.src = "../../eOH/images/arrow-down.gif";
						}
						else {
							el.style.display = '';
							refresh_form_obj.T_arrow.src = "../../eOH/images/arrow-up.gif";
						}
					}

					//Added by Sridevi Joshi on 1/19/2010 for IN010939(SRR20056-CRF-0490).To refresh the Summary Menu once GS is recorded.
					/*if(ext_perm_loc_param == "Y" || (status_for_ext_loc_int >=25 && trmt_yn !="Y" && trmt_done_yn != "Y")){//Added by Sridevi Joshi for CRF-702(IN012606)
						parent.parent.frames[2].expandMenu('menuSummary',parent.parent.frames[2].document.forms[0].GS_arrow);
						var el_menu1 = parent.parent.frames[2].document.getElementById("menuSummary");
						var refresh_form_obj = parent.parent.frames[2].document.forms[0];
					}
					else{
						parent.frames[2].expandMenu('menuSummary',parent.frames[2].document.forms[0].GS_arrow);
						var el_menu1 = parent.frames[2].document.getElementById("menuSummary");
						var refresh_form_obj = parent.frames[2].document.forms[0];
					}
					
					if ( el_menu1.style.display != "none" ) {
						el_menu1.style.display = 'none';
						refresh_form_obj.T_arrow.src = "../../eOH/images/arrow-down.gif";
					}
					else {
						el_menu1.style.display = '';
						refresh_form_obj.T_arrow.src = "../../eOH/images/arrow-up.gif";
					}*/

					if(treatment_status_param =="60"){
						//Refreshing the form values with the original params
						if(ext_perm_loc_param == "Y" || (status_for_ext_loc_int >=25 && trmt_yn !="Y" && trmt_done_yn != "Y")){//Added by Sridevi Joshi for CRF-702(IN012606)
							var old_params = parent.parent.frames[2].document.forms[0].params.value;
						}
						else{
							var old_params = parent.frames[2].document.forms[0].params.value;
						}
						document.location.href = "../../eOH/jsp/DentalTreatment.jsp?"+old_params;
					}

					//Added by Sharon Crasta on 2/9/2010 for SRR20056-CRF-0475(IN010868)
					//Added becoz the Extraction should be inserted 1st and then the pontic tooth should be updated against the extracted record.
					if(status != "E" && trmt_category_type == "EXTRACT" && modalReturnedVal != "undefined" && modalReturnedVal != undefined && modalReturnedVal != "" && modalReturnedVal != "null" && modalReturnedVal != null){
						if(formObj.pontic_tooth_values.value != ""){
							var modalReturnedValForBridge = formObj.pontic_tooth_values.value+"$$"+modalReturnedVal;
						} else{
							var modalReturnedValForBridge = modalReturnedVal;
						}
			
							
						var modalReturnedVal_arr = modalReturnedVal.split("$$");
						for(k = 0; k < modalReturnedVal_arr.length; k++){
							 var imageId = "T"+modalReturnedVal_arr[k];
							 dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						 }
					} 
					//End
					var status_int = parseInt(status);

					var super_tooth_selected = "N";
					var super_normal_tooth_selected = "N";
					var normal_tooth_selected = "N";

					if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined && status == "E"){//Added by Sridevi Joshi on 2/22/2010 for IN010894
						if(eval("dentalchartFormObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no+"')") != null){
							super_tooth_selected = "Y";
						}
					}
					else if(super_tooth_ref == "" && status == "E"){
						if(eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')") != null){//Added by Sridevi Joshi on 2/22/2010 for IN010894
							super_normal_tooth_selected = "Y";
						}
						else{
							if(retVal_SuperKey_arr.length > 1){//Added by SRidevi Joshi on 2/24/2010 for IN010894(SRR20056-CRF-0481)
								for(var f=0;f<=retVal_SuperKey_arr-1;f++){
									if(eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[f]+"_super_font"+tooth_no+"')") != null){
										super_tooth_selected = "Y";
									}
								}
							}
							else{
								normal_tooth_selected = "Y";
							}
						}
					}
					else if(super_tooth_ref == "undefined" || super_tooth_ref == undefined || status != "E"){
						normal_tooth_selected = "Y";
					}
					
					if(status == "E" || (order_catalog_bill_yn != "Y" && status_int >= 25) || (billing_appl_yn != "Y" && status_int >= 25)){ // Only for Mark Error Cases and for non billable order catalogs. For other casese it calls the functions in the DentalTreatmentStages.js
						if(site_type == "TOOTH" || site_type == "THRNG" || site_type == "ARCH" || site_type == "QUAD" ||(site_type=="CROWN" && surface_code=="*A")){
							//added by parul on 05/02/2010 for CRF-442
							//imageReplace(trmt_category_type,tooth_no,dentalChartFormObj,site_type,status,document.forms[0],'','','','',super_key_num,'',surface_code);
							imageReplace(trmt_category_type,tooth_no,dentalChartFormObj,site_type,status,document.forms[0],'','','','','',super_key_num,'',surface_code,'','','','')
						}

						//if(super_tooth_selected == "Y" || super_normal_tooth_selected == "Y" || normal_tooth_selected == "Y"){//Added by Sridevi Joshi on 2/22/2010 for IN010894  ---uncomment for screen changes
							if(site_type == "CROWN" && surface_ref!="*A"){										    
								var surface_ref_arr=surface_ref.split(",");
								if (surface_ref_arr.length>1){
									for(var i=0;i<surface_ref_arr.length;i++){										
										if(status_int==60 || status_int==85){
											fillCrownImages('toothLayer'+tooth_no,surface_ref_arr[i],dentalChartFormObj,trmt_category_type,status_for_filling,tooth_no,'',super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,formObj.oh_outcome.value);
											drawCircleForCusp(tooth_no,dentalChartFormObj,status,cusptip_ref,surface_ref_arr[i],tab_name,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,formObj.oh_outcome.value);//added by parul for CRF#0483 on 27/08/2009
										}else{
										    fillCrownImages('toothLayer'+tooth_no,surface_ref_arr[i],dentalChartFormObj,trmt_category_type,status_for_filling,tooth_no,'',super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);
											drawCircleForCusp(tooth_no,dentalChartFormObj,status,cusptip_ref,surface_ref_arr[i],tab_name,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);//added by parul for CRF#0483 on 27/08/2009
										
										}
									}
								 }
								 else{	
									if(status_int==60 || status_int==85){
										fillCrownImages('toothLayer'+tooth_no,surface_code,dentalChartFormObj,trmt_category_type,status_for_filling,tooth_no,'',super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,formObj.oh_outcome.value);
										drawCircleForCusp(tooth_no,dentalChartFormObj,status,cusptip_ref,surface_code,tab_name,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,formObj.oh_outcome.value);//added by parul for CRF#0483 on 27/08/2009
									}else{
									   fillCrownImages('toothLayer'+tooth_no,surface_code,dentalChartFormObj,trmt_category_type,status_for_filling,tooth_no,'',super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);
										drawCircleForCusp(tooth_no,dentalChartFormObj,status,cusptip_ref,surface_code,tab_name,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);//added by parul for CRF#0483 on 27/08/2009
									
									}
								 }
							}
							else if(site_type == "ROOT"){
									if(status_int==60 || status_int==85){
										drawLineForRootImage('rootLayer'+tooth_no,surface_code,dentalChartFormObj,trmt_category_type,"T",tooth_no,status_for_filling,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,formObj.oh_outcome.value);
									}else{
										drawLineForRootImage('rootLayer'+tooth_no,surface_code,dentalChartFormObj,trmt_category_type,"T",tooth_no,status_for_filling,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);

									}
							}
							else{
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
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

										var imageId = "R"+tooth_no_arr[k];
										if(permanent_deciduous_flag == "D"){
											var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
										}
										else{
											var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
										}
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"

										var imageId = tooth_no_arr[k];
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="&nbsp;";

										var imageId = tooth_no_arr[k];
										var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="&nbsp;";
									}
								}
							}
						//}
					}

					if(super_tooth_ref == "RD"){//Added by Sridevi Joshi on 2/17/2010 outside if condition of tooth for IN019368
						//Added by Sridevi Joshi on 12/17/2009 for RTDESTH new changes TO GET mapped tooth no
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retained_tooth_no = trimString(xmlHttp.responseText); 
						retained_tooth_no = localTrimString(retained_tooth_no); 
					}

					//if(super_tooth_selected == "Y" || super_normal_tooth_selected == "Y" || normal_tooth_selected == "Y"){//Added by Sridevi Joshi on 2/22/2010 for IN010894 ---uncomment for screen changes
					
					//Coomented by Sridevi Joshi on 5/5/2010 for IN021153...Wrong number of parameters were passed
					//getImageFromDB(tooth_no,site_type,chart_num,tab_name,document.forms[0],dentalChartFormObj,'',super_tooth_ref,exfolth_count,retained_tooth_no,'','',total_SuperKey_count,super_recorded,'','');//Added by Sridevi Joshi on 2/17/2010 outside if condition of tooth for IN019368 
					getImageFromDB(tooth_no,site_type,chart_num,tab_name,document.forms[0],dentalChartFormObj,'',super_tooth_ref,exfolth_count,retained_tooth_no,'',total_SuperKey_count,super_recorded,'','');//Added by Sridevi Joshi on 2/17/2010 outside if condition of tooth for IN019368

					//}
					if((refresh_yn == "Y" && treatment_status_param == "A") || (refresh_yn == "Y" && treatment_status_param_for_refresh =="25") || (treatment_status_param_for_refresh=="10" && appt_reqd_yn=="Y") || (refresh_yn == "Y" && treatment_status_param_for_refresh =="52") || (refresh_yn == "Y" && treatment_status_param_for_refresh =="55") || (treatment_status_param_for_refresh=="15" && appt_reqd_yn=="Y" && refresh_yn == "Y") || (treatment_status_param_for_refresh!="10" && treatment_status_param_for_refresh!="15" && treatment_status_param_for_refresh!="25" && treatment_status_param_for_refresh!="52" && treatment_status_param_for_refresh!="55" && treatment_status_param_for_refresh!="80")){
						Treatment_Reset(formObj,site_type,tooth_no,thrng_nos);
					}

					if(order_catalog_bill_yn != "Y" || billing_appl_yn != "Y" || (order_catalog_bill_yn == "Y" &&  billing_appl_yn != "Y")){
						Treatment_Reset(formObj,site_type,tooth_no,thrng_nos);
					}

					refresh_yn="Y";	
					dentalchartFormObj.chart_hdr_insert_yn.value = "N";	
				 }
			 }
		}
	}
}

	
//function imageReplace(trmt_category_type,tooth_no,dentalchartFormObj,site_type,status,obj,super_before,show_RTDESTH_EXFOLTH_image_flag,hide_image_yn,mixed_dent_deciduous_yn){// added by parul(added mixed_dent_deciduous_yn becoz when u record tooth trmt,supernum,Deciduoud now tooth no is D,Ds if u mark tooth trmt as error that tooth no is gong to change as 6,6s..it should be D,Ds so that we added mixed_dent_deciduous_yn in  imageReplace function )

function imageReplace(trmt_category_type,tooth_no,dentalchartFormObj,site_type,status,formObj,super_before,show_RTDESTH_EXFOLTH_image_flag,hide_image_yn,mixed_dent_deciduous_yn,supernumerary_yn,super_key_num,isSuprthError,surface_code,isExfolthError,retained_tooth_no,treatments_outcome,image_source,treatment_int_ext){// added by parul(added mixed_dent_deciduous_yn becoz when u record tooth trmt,supernum,Deciduoud now tooth no is D,Ds if u mark tooth trmt as error that tooth no is gong to change as 6,6s..it should be D,Ds so that we added mixed_dent_deciduous_yn in  imageReplace function )

	var numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var tooth_num = "";
	var tooth_name = "";
	var mapped_tooth_no = "";
	var status_int = 0;
	var RD_Normal_yn=formObj.RD_Normal_yn.value;
	
	
	if(trmt_category_type != null && trmt_category_type != "null" && trmt_category_type != "" && trmt_category_type != "undefined"){
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
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

						var imageId = "R"+tooth_no_arr[k];
						if(permanent_deciduous_flag == "D"){
							if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
						}

						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"
					}
					else if(trmt_category_type == "IMPLANT"){
						var imageId = "T"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

						var imageId = "R"+tooth_no_arr[k];
						if(permanent_deciduous_flag == "D"){
							if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
						}

						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"
					}
					else if(trmt_category_type == "DENTURE"){
						if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null")){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						}
						else{
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

							var imageId = "R"+tooth_no_arr[k];
							if(permanent_deciduous_flag == "D"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}

							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"
						}
					}
					else if(trmt_category_type == "BRIDGE"){
						if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null")){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						}
						else{
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

							var imageId = "R"+tooth_no_arr[k];
							if(permanent_deciduous_flag == "D"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}

							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"
						}
					}
				}
				else{
					status_int = parseInt(status);
					if(trmt_category_type == "EXTRACT"){
					if (treatment_int_ext=="I"){
							status_int = parseInt(status);
							if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){ // planned
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownYellow.gif'>";

								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootYellow.gif'>";
							}
							else if(status_int == 60){
								if (treatments_outcome=="F"){
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='40' height='25'  src='../../eOH/images/Extraction-CrownGreen_F.gif'>";                          


									var imageId = "R"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_F.gif'>";

								}else{
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen.gif'>";

									var imageId = "R"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen.gif'>";
								
								}
							}
						}else{			
							if (treatment_int_ext=="E"){
								if (treatments_outcome=="F"){
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen_EF.gif'>";

									var imageId = "R"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_EF.gif'>";
								}else{
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen_E.gif'>";

									var imageId = "R"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_E.gif'>";
								}
							}
						}
						
					}
					else if(trmt_category_type == "IMPLANT"){
							if (treatment_int_ext=="I"){
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
							var imageId = "R"+tooth_no_arr[k];
							if(treatments_outcome=="F"){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_F.gif' width='45' height=34'/>";
							}else{
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root.gif' width='45' height=34'/>";						
							}
						}else  if (treatment_int_ext=="E"){
							 if (treatments_outcome=="F"){
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_EF.gif'>";
							  
								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_EF.gif'/>";
							}else{
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_E.gif'>";

								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_E.gif'>";
							}
						}
					}
					else if(trmt_category_type == "DENTURE"){
						if (treatment_int_ext=="I"){
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src=' "+image_source+" '>";
									var imageId = "R"+tooth_no_arr[k];
									if(treatments_outcome=="F"){
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_F.gif'>";
									}else{
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root.gif'>";
									}
							}else if (treatment_int_ext=="E"){
								 if (treatments_outcome=="F"){
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_EF.gif'>";
									var imageId = "R"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_EF.gif'>";

								}else{
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_E.gif'>";

									var imageId = "R"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_E.gif'>";
								}
							}
					}
					//Commented and Added by Sharon Crasta on 2/24/2010 for SRR20056-CRF-0475(IN010868)
					/*else if(trmt_category_type == "BRIDGE" && hide_image_yn == "Y"){
						var imageId = "T"+tooth_no_arr[k];
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
						var imageId = "R"+tooth_no_arr[k];
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='34' src=' "+image_source+" '>";

					} */
					else if(trmt_category_type == "BRIDGE" && hide_image_yn == "Y"){
						if (treatment_int_ext=="I"){
							if(treatments_outcome=="F"){
								var imageId = "T"+tooth_no_arr[k];
								//Commented and Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
								//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_F.gif' width='45' height='25'/>";
							
								/*var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";*/

								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}else{
								var imageId = "T"+tooth_no_arr[k];
								//Commented and Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
								//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic.gif' width='45' height='25'/>";
							
								/*var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";*/

								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}
						}else if (treatment_int_ext=="E"){
                              if(treatments_outcome=="F"){
								var imageId = "T"+tooth_no_arr[k];
							
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
							
								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img  src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}else{
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif' width='45' height='25'/>";
							
								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img  src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}

						}
					}
					else if(trmt_category_type == "BRIDGE" && hide_image_yn == "N"){
						if (treatment_int_ext=="I"){
							if(treatments_outcome=="F"){
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_F.gif' width='45' height='25'/>";
							}else{
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment.gif' width='45' height='25'/>";
							}
						  }else if (treatment_int_ext=="E"){
								if (treatments_outcome == "F"){
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_EF.gif' width='45' height='25'/>";
							}else{
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_E.gif' width='45' height='25'/>";
							}
						  }
					} //End
				}
			}
		}
		else if(site_type == "TOOTH"){
			var tooth_sn = tooth_no;
			var RD_Normal_yn = formObj.RD_Normal_yn.value;
			var header_tab = formObj.header_tab.value

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

			status_int = parseInt(status);
			if(status == 'E'){
			
				if( trmt_category_type == "EXTRACT"){
					var imageId = "T"+tooth_no;
					//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";
					/* tooth_sn has changed to tooth_no for toothLayer by Sridevi Joshi on 011009 for IN014419*/
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

					var imageId = "R"+tooth_no;
					if(permanent_deciduous_flag == "D"){
						if(tooth_no == "33" || tooth_no == "34"){
							var imageSrc = "../../eOH/images/R3.gif";
						}
						else if(tooth_no == "41" || tooth_no == "42"){
							var imageSrc = "../../eOH/images/R14.gif";
						}
						else if(tooth_no == "43" || tooth_no == "44"){
							var imageSrc = "../../eOH/images/R19.gif";
						}
						else if(tooth_no == "51" || tooth_no == "52"){
							var imageSrc = "../../eOH/images/R30.gif";
						}
						else{
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
					}
					else{
						var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
					}

					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"

					//Added by Sharon Crasta on 2/23/2010 for SRR20056-CRF-0475 (IN010868)
					var pontic_tooth_split_values = new Array();
					var modalReturnedVal = "";
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
						if(treatments_outcome=="F"){
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_F.gif' width='45' height='25'/>";
						}else{
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment.gif' width='45' height='25'/>";
						
						}
					}
					pontic_tooth = retVal_bridge_extract.split(",") ;
					if(tooth_no == (retVal_bridge_extract.substring(retVal_bridge_extract.lastIndexOf("$")+1,retVal_bridge_extract.length))){	// toothno == to the last number in the bridge 
						for(i = pontic_tooth.length-1;i >= 0;i--,j++){

							pontic_tooth_split_values[j] = pontic_tooth[i].substring((pontic_tooth[i].lastIndexOf("$")+1),pontic_tooth[i].length) ;

						} 
					}else{
						for(i = 0; i < pontic_tooth.length;i++){
							pontic_tooth_split_values[i] = pontic_tooth[i].substring((pontic_tooth[i].lastIndexOf("$")+1),pontic_tooth[i].length) ;
						} 
					}
					if(retVal_bridge_extract.length > 0){
						
						var retVal_pontic = document.forms[0].pontic_tooth_values.value;
						var code_desc_arr = retVal_pontic.split("$$");
						var code_desc_arr_str = code_desc_arr.join("~~");
						
						if(code_desc_arr_str.length > 0){
						   for(var k=0;k<code_desc_arr.length;k++){
							   	if(treatments_outcome=="F"){
									var imageId = "T"+code_desc_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_F.gif' width='45' height='25'/>";
															
									var imageId = "R"+code_desc_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								}else{
									var imageId = "T"+code_desc_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic.gif' width='45' height='25'/>";
															
									var imageId = "R"+code_desc_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								
								}
						   }
						}
					} //End
				}
				else if(trmt_category_type == "IMPLANT"){
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

					var imageId = "R"+tooth_no;
					if(permanent_deciduous_flag == "D"){
						if(tooth_no == "33" || tooth_no == "34"){
							var imageSrc = "../../eOH/images/R3.gif";
						}
						else if(tooth_no == "41" || tooth_no == "42"){
							var imageSrc = "../../eOH/images/R14.gif";
						}
						else if(tooth_no == "43" || tooth_no == "44"){
							var imageSrc = "../../eOH/images/R19.gif";
						}
						else if(tooth_no == "51" || tooth_no == "52"){
							var imageSrc = "../../eOH/images/R30.gif";
						}
						else{
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
					}
					else{
						var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
					}

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
				if(trmt_category_type == "EXTRACT"){
					status_int = parseInt(status);
					if (treatment_int_ext!="E"){						
						if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){ // planned
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownYellow.gif'>";

							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootYellow.gif'>";
						}
						else if(status_int == 60){
							if (treatments_outcome=="F"){
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='40' height='25'  src='../../eOH/images/Extraction-CrownGreen_F.gif'>";                          


								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_F.gif'>";

							}else{
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen.gif'>";

								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen.gif'>";
							
							}
						}
					}else{			
						if (treatment_int_ext=="E"){
							if (treatments_outcome=="F"){
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen_EF.gif'>";

								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_EF.gif'>";
							}else{
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen_E.gif'>";

								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_E.gif'>";
							}
						}
					}
				}
				else if(trmt_category_type == "IMPLANT"){
					if (treatment_int_ext!="E"){
						//var imageId = "T"+tooth_no;
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
						
						if(treatments_outcome=="F"){
                            var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_F.gif'>";

							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_F.gif' width='45' height=34'/>";
						}else{
                            var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";

							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root.gif' width='45' height=34'/>";						
						}
					}else  if (treatment_int_ext=="E"){
                         if (treatments_outcome=="F"){
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_EF.gif'>";
						  
							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_EF.gif'/>";
						}else{
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_E.gif'>";

							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_E.gif'>";
						}
					}
				}else if(trmt_category_type == "DENTURE"){
						if (treatment_int_ext!="E"){
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src=' "+image_source+" '>";
								var imageId = "R"+tooth_no;
								if(treatments_outcome=="F"){
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_F.gif'>";
								}else{
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root.gif'>";
								}
						}else if (treatment_int_ext=="E"){
							 if (treatments_outcome=="F"){
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_EF.gif'>";
								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_EF.gif'>";

							}else{
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_E.gif'>";

								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_E.gif'>";
							}
						}
				}

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
		}else if (surface_code=="*A" && site_type=="CROWN"){//Added by parul on 21/01/2010 for CRF-422
				var imageId = "T"+tooth_no;
					if(permanent_deciduous_flag=="P"){
						if (tooth_no>=1 && tooth_no<=16){
							if(treatments_outcome=="F"){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_F.gif' width='45' height='25'/>";
							}else{
							   	dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown.gif' width='45' height='25'/>";
							}
						}else{
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
						}
					}else{
						if (tooth_no>=33 && tooth_no<=42){
							if(treatments_outcome=="F"){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_F.gif' width='45' height='25'/>";
							}else{
							   	dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown.gif' width='45' height='25'/>";
							}
						}else{
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
						}
					}
			}
	}	
	else{
		status_int = parseInt(status);
		if(site_type == "ARCH"){
			
			var imageId = "COLORA"+tooth_no;
			if(status == "E" || status == "undefined" || status == "" || status == "null" || status == null){
				fill_color = "#99ddee";
			}
			else if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
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
			else if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
				fill_color = "yellow";
			}
			else{
				fill_color = "lightgreen";
			}
			dentalchartFormObj.document.getElementById(imageId).style.backgroundColor = fill_color;
		}
		else{
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

			if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null" || mapped_tooth_no == "")){ //This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
				var imageId = "T"+tooth_no;
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

				var imageId = "R"+tooth_no;
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
			}
			else{				
				if(permanent_deciduous_flag == "D"){
					//if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
						if(tooth_no == "33" || tooth_no == "34"){
							var imageSrc = "../../eOH/images/R3.gif";
						}
						else if(tooth_no == "41" || tooth_no == "42"){
							var imageSrc = "../../eOH/images/R14.gif";
						}
						else if(tooth_no == "43" || tooth_no == "44"){
							var imageSrc = "../../eOH/images/R19.gif";
						}
						else if(tooth_no == "51" || tooth_no == "52"){
							var imageSrc = "../../eOH/images/R30.gif";
						}
						else{
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
					//}
					//else{
						//var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
					//}
					
				}
				else{
					var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
				}
				var imageId = "R"+tooth_no;
				if(dentalchartFormObj.document.getElementById(imageId) != null){
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";
				}


				var imageId = "T"+tooth_no;
				if(dentalchartFormObj.document.getElementById(imageId) != null){
					/* tooth_sn has changed to tooth_no for toothLayer by Sridevi Joshi on 011009 for IN014419*/
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";
				}
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
	var locale = formObj.locale.value;
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
	var ext_perm_loc_param = formObj.ext_perm_loc_param.value;
	var trmt_yn = formObj.treatment_flag.value;
	var trmt_done_yn = formObj.trmt_done_yn.value;
	var reg_date=formObj.regDate.value;
	var reg_time=formObj.regTime.value;
	var reg_date_time=reg_date+" "+reg_time;
	var oh_chart_level = document.forms[0].oh_chart_level.value;
	var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
	//Added  by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	var seq_no = document.forms[0].seq_no.value;
	var task_seq_no = document.forms[0].task_seq_no.value;
   //
	//Added by Sharon Crasta on 10/7/2008
	//Start Date and End Date Values can be retrieved only once the status is 25 or Registered.
	formObj.oh_status.value = formObj.treatment_status.value;
	var status_int = formObj.oh_status.value;
	if(status_int == "25" || status_int == "52" || status_int == "55" || status_int == "85"){
		var start_date_time = convertDate(formObj.strtDate.value,'DMY',locale,"en");
		var end_date_time = convertDate(formObj.endDate.value,'DMY',locale,"en");
		var start_time = formObj.strtTime.value;
		var end_time = formObj.endTime.value;
		var start_date = start_date_time + " " + start_time;
		var end_date = 	end_date_time + " " + end_time;


		// On load of the Register Order the Start Date and End Date fields should be disabled.
	/*	if(start_date_time != null && start_date_time != "null" && start_date_time != "undefined" && start_date_time != ""){
			formObj.strtDate.value = start_date_time;
		//	formObj.strtDate.disabled = true;
		} 
		if(end_date_time != null && end_date_time != "null" && end_date_time != "undefined" && end_date_time != ""){
			formObj.endDate.value = end_date_time;
		//	formObj.endDate.disabled = true;
		}  */

	}
	//
	
	var bl_episode_id = formObj.bl_episode_id.value;
	var bl_encounter_id = formObj.bl_encounter_id.value ;
	var bl_visit_id = formObj.bl_visit_id.value;
	var bl_episode_type = formObj.bl_episode_type.value ;
	
	var surgeon_code = formObj.bl_pract_staff_id.value;
	var task_desc = formObj.task_desc.value ;
	var bl_key = formObj.bl_key.value;
	var bl_key_line_no = formObj.bl_key_line_no.value;
	var bl_panel_str = formObj.bl_panel_str.value;
	var bl_service_date = formObj.bl_service_date.value;
	var billing_appl_yn	= formObj.billing_appl_yn.value;
	var task_order_catalog_code	= formObj.task_order_catalog_code.value;
	var order_catalog_bill_yn	= formObj.order_catalog_bill_yn.value;
	//Added by Sharon Crasta on 2/6/2009 to call billing window on result entry.
	var bill_sub_regn_num = formObj.bill_sub_regn_num.value;
	var bill_sub_regn_line_num = formObj.bill_sub_regn_line_num.value;
	var ca_practitioner_id = formObj.ca_practitioner_id.value;
	//
	var reg_date=convertDate(formObj.regDate.value,'DMY',locale,"en");
	var reg_time=formObj.regTime.value;
	var reg_date_time=reg_date+" "+reg_time;
	if(param=="register"){

		/* Added registerOrder method insted of calling OR Bean
			var retVal = formApply(formObj,OR_CONTROLLER);
			retVal=trimString(retVal);
			eval(retVal);
			if(message!=""){		
				var return_status = updateTreatmentStatus(site_type,thrng_nos_ref,patient_id,chart_num,chart_line_num,"25",parseInt(chart_line_num),order_id,trmt_code,task_code,'','','',order_line_num,task_order_catalog_code);
			}
		
		*/
		//To register Order
		var registered_yn = registerOrder(chart_num,chart_line_num,order_id,order_line_num);
		var return_status = "";
		if(registered_yn){
			var message = recordCharges();
			if(message){
				//var return_status	= updateTreatmentStatus(site_type,thrng_nos_ref,patient_id,chart_num,chart_line_num,"25",parseInt(chart_line_num),order_id,trmt_code,task_code,'','','',order_line_num,task_order_catalog_code);
				//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
				//return_status	= updateTreatmentStatus(site_type,thrng_nos_ref,patient_id,chart_num,chart_line_num,"25",parseInt(chart_line_num),order_id,trmt_code,task_code,'','','',order_line_num,task_order_catalog_code);
				
				return_status	= updateTreatmentStatus(site_type,thrng_nos_ref,patient_id,chart_num,chart_line_num,"25",parseInt(chart_line_num),order_id,trmt_code,task_code,'','','',order_line_num,task_order_catalog_code,task_seq_no,"","","","","","","","","","","","","","","",ext_perm_loc_param,trmt_yn,trmt_done_yn,reg_date_time);

			} else{
				return_status = false;	
				
			}
		}

		//Added by Sharon Crasta on 2/3/2009
		//return message;
	}
	else if(param=="result"){
		/*
		Arguments whic are passed when Result entry is being called from CA screen
		var params = "p_called_from_ca =Y&option_id=ORDER_REPORTING1&module_id=OH&access=NNYNN&child_window=N&limit_function_id=&chartTitle=&reln_req_yn=N&limit_function_id=";
		*/	
		var seq_no = formObj.seq_no.value;
		var performed_In_OT = formObj.performed_In_OT.value;
		if(performed_In_OT==undefined||performed_In_OT== " "||performed_In_OT==null)performed_In_OT='N';
		formObj.charging_stage.value = "REG";
		var reg_date=convertDate(formObj.regDate.value,'DMY',locale,"en");
		var reg_time=formObj.regTime.value;
		var reg_date_time=reg_date+" "+reg_time;
		var message = recordCharges();
		if(!message){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
			//var params = "facility_id="+facility_id+"&patient_id="+patient_id+"&chart_num="+chart_num+"&order_id="+order_id+"&order_line_num="+order_line_num;
			var params = "facility_id="+facility_id+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&seq_no="+task_seq_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id=="+other_chart_facility_id;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getTaskStatus&"+params,false);
			xmlHttp.send(xmlDoc);
			var returnVal = trimString(xmlHttp.responseText);
			var return_value = parseInt(returnVal);
			if(return_value != "" && return_value!=null && return_value!="undefined"){
				//if(return_value == "25" || return_value == "52" || return_value == "55" ){
				callBillingWindow(patient_id,chart_num,chart_line_num,trmt_code,task_code,bill_sub_regn_num,bill_sub_regn_line_num,ca_practitioner_id);
				refresh_yn = "N";
			//	}
			}  
		}
		else{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "task_order_catalog_code="+task_order_catalog_code;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getChartApplicableYN&"+params,false);
			xmlHttp.send(xmlDoc);
			var returnVal_chrt_appl = trimString(xmlHttp.responseText);
			returnVal_chrt_appl = localTrimString(returnVal_chrt_appl); 
			if(returnVal_chrt_appl == "Y"){
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
				finalString += "&encounter_id="+encounter_id;
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

				//var url	= "../../eOR/jsp/ResultEntry.jsp?"+finalString;
				var url	= "../../eOH/jsp/ResultEntry.jsp?"+finalString;
				//var url	= "../../eOH/jsp/OHResultEntry.jsp?"+finalString;
				var dialogHeight= "55vh" ;
				var dialogWidth = "70vw" ;
				var dialogTop  = "71";
				var center  = "1" ;
				var status  = "no";				
				var arguments	= "" ;
				var features = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var retval = await window.showModalDialog(url,arguments,features);
			}
			else{
				retval = "complete";
			}

			if(retval != "" && retval!=null && retval!="undefined"){

				//retval=="1" - In Progress
				//retval=="2" - Partially
				//retval=="3" - Completed

				/* Billing params
					bl_episode_id,bl_encounter_id,bl_visit_id,bl_episode_type,patient_class,surgeon_code,task_desc,bl_key,bl_key_line_no,bl_panel_str,bl_service_date,billing_appl_yn
				*/
				
				if(retval == "complete"){
					//var return_status = updateStatusComplete(site_type,thrng_nos_ref,formObj.patient_id.value,formObj.chart_num.value,formObj.chart_line_num.value,"60",parseInt(chart_line_num),order_id,trmt_code,task_code,'','','',order_line_num,task_order_catalog_code,task_seq_no,bl_episode_id,bl_encounter_id,bl_visit_id,bl_episode_type,patient_class,surgeon_code,task_desc,bl_key,bl_key_line_no,escape(bl_panel_str),bl_service_date,billing_appl_yn,start_date,end_date,order_catalog_bill_yn,ext_perm_loc_param,trmt_yn,trmt_done_yn);

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "order_id="+order_id+"&order_line_num="+order_line_num;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=updateStatusComplete&"+params,false);
					xmlHttp.send(xmlDoc);
					var returnVal_complete = trimString(xmlHttp.responseText);
				}

				var reg_date=convertDate(formObj.regDate.value,'DMY',locale,"en");
				var reg_time=formObj.regTime.value;
				var reg_date_time=reg_date+" "+reg_time;
				//Returns the status of the tasks once recorded.
				//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
				//var return_status	= updateTreatmentStatus(site_type,thrng_nos_ref,formObj.patient_id.value,formObj.chart_num.value,formObj.chart_line_num.value,"60",parseInt(chart_line_num),order_id,trmt_code,task_code,'','','',order_line_num,task_order_catalog_code,bl_episode_id,bl_encounter_id,bl_visit_id,bl_episode_type,patient_class,surgeon_code,task_desc,bl_key,bl_key_line_no,escape(bl_panel_str),bl_service_date,billing_appl_yn,start_date,end_date,order_catalog_bill_yn);	
				var return_status	= updateTreatmentStatus(site_type,thrng_nos_ref,formObj.patient_id.value,formObj.chart_num.value,formObj.chart_line_num.value,"60",parseInt(chart_line_num),order_id,trmt_code,task_code,'','','',order_line_num,task_order_catalog_code,task_seq_no,bl_episode_id,bl_encounter_id,bl_visit_id,bl_episode_type,patient_class,surgeon_code,task_desc,bl_key,bl_key_line_no,escape(bl_panel_str),bl_service_date,billing_appl_yn,start_date,end_date,order_catalog_bill_yn,ext_perm_loc_param,trmt_yn,trmt_done_yn,reg_date_time,performed_In_OT);
				
				var task_status = document.forms[0].treatment_status_param.value;
				
				if(retval == "3" || retval == "complete"){
					formObj.charging_stage.value = "RST";
				}
				else{
					formObj.charging_stage.value = "REG";
				}

				recordCharges();

				 //if condition added by parul on 10/12/2009 for  IN017113  if trmt is non billable on that case "result_text" in dtl table was insertng as null so that chart was not coming in cilnical event history.
                if (return_status=="60" || return_status=="85"){
					//var retVal = getImageForHistory();
					var chart_line_num_int = parseInt(chart_line_num);
					var DentalChartFormObj = parent.parent.trmtDentalChartDetails.document.forms[0];
					var header_tab = DentalChartFormObj.header_tab.value;
					var tooth_numbering_system = DentalChartFormObj.tooth_numbering_system.value;
					var permanent_deciduous_flag = DentalChartFormObj.permanent_deciduous_flag.value;
					var mixed_dentition_YN = DentalChartFormObj.mixed_dentition_YN.value;
					var upper_arch_desc = DentalChartFormObj.upper_arch_desc.value;
					var lower_arch_desc = DentalChartFormObj.lower_arch_desc.value;
					var Q1_id = DentalChartFormObj.Q1_id.value;
					var Q2_id = DentalChartFormObj.Q2_id.value;
					var Q3_id = DentalChartFormObj.Q3_id.value;
					var Q4_id = DentalChartFormObj.Q4_id.value;
					var Q1_desc = DentalChartFormObj.Q1_desc.value;
					var Q2_desc = DentalChartFormObj.Q2_desc.value;
					var Q3_desc = DentalChartFormObj.Q3_desc.value;
					var Q4_desc = DentalChartFormObj.Q4_desc.value;

					if(site_type == "THRNG"){
						
						thrng_nos_ref_arr = thrng_nos_ref.split(",");
						for(var k=0;k<thrng_nos_ref_arr.length;k++){

							history_params = "patient_id="+patient_id+"&encounter_id="+encounter_id+"&header_tab="+header_tab+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num_int+"&trmt_code="+trmt_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&thrng_nos_ref="+thrng_nos_ref;

							storeImageClob(history_params);
							chart_line_num_int++;
						}
					}
					else{
						history_params = "patient_id="+patient_id+"&encounter_id="+encounter_id+"&header_tab="+header_tab+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num_int+"&trmt_code="+trmt_code+"&order_id="+order_id+"&order_line_num="+order_line_num;
						storeImageClob(history_params);
					}
				}//end

				//var task_status = document.forms[0].treatment_status_param.value;
				//if(task_status == "60" || task_status == "85"){
					//recordCharges();
				//}
			 
				
				//Added by Sharon Crasta on 10/23/2008
				// Added to display the status based on the event status(IM,IR,RS) changed on record.
				// Option Texts for In Progress, Partially, Completed.
				var status_in_progress_label = getLabel("Common.InProgress.label","Common"); 
				var status_partial_result_label = getLabel("eOR.PartiallyResulted.label","OR");
				var status_performed_label = getLabel("Common.Performed.label","Common"); 

				//var opt=parent.document.frames[3].document.createElement("OPTION");

				clear_list(formObj.treatment_status);
				var opt	= document.createElement("OPTION");
				
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
				//var params = "facility_id="+facility_id+"&patient_id="+patient_id+"&chart_num="+chart_num+"&order_id="+order_id+"&order_line_num="+order_line_num;
				var params = "facility_id="+facility_id+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&seq_no="+task_seq_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id=="+other_chart_facility_id;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getTaskStatus&"+params,false);
				xmlHttp.send(xmlDoc);
				
				var returnVal = trimString(xmlHttp.responseText);
				var return_value = parseInt(returnVal);
				if(return_value != "" && return_value!=null && return_value!="undefined"){
				
					if(return_value == 52){
						opt.text=status_in_progress_label;
						opt.value=return_value;
					}

					if(return_value == 55 || return_value == 80){
						opt.text=status_partial_result_label;
						opt.value=return_value;
					}
					if(return_value == 53 || return_value == 75 || return_value == 90 || return_value == 60 || return_value == 85){
						opt.text=status_performed_label;
						opt.value=return_value;
					}
					if(formObj.treatment_status != null){
							formObj.treatment_status.add(opt);
					} 

				}
						 
				// return_status is the status of restorative_chart_dtl table. 
				if(return_status=="60" || return_status == "85"){
					if(ext_perm_loc_param == "Y" || (trmt_yn !="Y" && trmt_done_yn != "Y")){//Added by Sridevi Joshi for CRF-702(IN012606)
						parent.parent.frames[2].expandMenu('menu5',parent.parent.frames[2].document.forms[0].T_arrow);
						parent.parent.frames[2].expandMenu('menu5',parent.parent.frames[2].document.forms[0].T_arrow);
					}
					else{ 
						parent.frames[2].expandMenu('menu5',parent.frames[2].document.forms[0].T_arrow);
						parent.frames[2].expandMenu('menu5',parent.frames[2].document.forms[0].T_arrow);
					}
				}
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

	if(site == "THRNG") { // For Tooth Range
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
					//if(((code_desc_arr[0] == "UNERTH" )|| (code_desc_arr[0] == "PARERTH" ) || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){
					if(((code_desc_arr[0] == "UNERTH" && code_desc_arr[5] != "Z")|| (code_desc_arr[0] == "PARERTH" && code_desc_arr[5] != "Z") || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){
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
/*
function setDuplicateCheck(obj){
	if(obj.checked = true){
	}
}
*/

async function retieveHistory(patient_id,chart_num,chart_line_num){
	var params = '&patient_id='+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;
	var url	= "../../eOH/jsp/OHHistory.jsp?"+params;
	
	var dialogHeight= "35vh" ;
	var dialogWidth	= "55vw" ;
	var dialogTop ="215";
	var dialogLeft ="29";
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
	await window.showModalDialog(url,arguments,features);
	
}

//Added by Sharon Crasta on 10/3/2008

//This function is used to Compare the Start and End Dates with the Registered Date.


function checkDateGreaterThanRegDate(regn_date_time){
	var formObj = document.forms[0];
	var locale = formObj.locale.value;
	var fromDate = convertDate(formObj.strtDate.value,'DMY',locale,"en");
	var fromTime = formObj.strtTime.value;

	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var trmt_code = formObj.trmt_code.value;
	var task_code = formObj.task_code.value;
	var task_seq_no = formObj.task_seq_no.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&task_seq_no="+task_seq_no;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OHTrmtSendOutAckValidation.jsp?func_mode=getRegDateTime&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal);
	var retVal_arr = retVal.split("##");
	var regn_date_time = convertDate(retVal_arr[0],'DMYHM',locale,"en");
	var sendout_date_time = convertDate(retVal_arr[1],'DMYHM',locale,"en");
	var ack_date_time = convertDate(retVal_arr[2],'DMYHM',locale,"en");
	var rcv_date_time = retVal_arr[3];
//	var rcv_date_time = convertDate(retVal_arr[3],'DMYHM',locale,"en");
	if(fromTime == "") fromTime = "00:00"
	var validate_date = fromDate+" "+fromTime
	
	if(validate_date != ""){
		if(sendout_date_time != ""){
			var grater_yn = ValidateDateTime (sendout_date_time,validate_date);
			if(!grater_yn){
				alert(getMessage("APP-OH000141","OH")+" "+sendout_date_time);
				formObj.strtDate.focus();
				//obj.select();
				return false;
			}
		}

		if(rcv_date_time != ""){
			var grater_yn = ValidateDateTime (validate_date,rcv_date_time);
			if(!grater_yn){
				//Added by rajesh for displaying the Thai Date conversion while displaying.... 19604
				var ack_date_time_temp = convertDate(retVal_arr[2],'DMYHM',"en",locale);
				alert(getMessage("APP-OH000142","OH")+" "+ack_date_time_temp);
				formObj.strtDate.focus();
				//obj.select();
				return false;
			}
		}

	}

	// if(checkDateNotGreaterThanSysDate1()){
	if(fromDate.length > 0 && fromTime.length > 0 && regn_date_time.length > 0 ) {
	      fromDateArray = fromDate.split("/");
		  fromTimeArray	= fromTime.split(":");
		 
		  regnarray1 = regn_date_time.split(" "); 
		  regnSplitDate = regnarray1[0];
		  regnSplitTime = regnarray1[1];

	      splitdate1 =regnSplitDate.split("/")
          splittime1= regnSplitTime.split(":")

		  var from_date  =new Date(eval(fromDateArray[2]), eval(fromDateArray[1])-1, eval(fromDateArray[0]), eval(fromTimeArray[0]), eval(fromTimeArray[1]));
		  var regn_date = new Date(eval(splitdate1[2]),eval(splitdate1[1]-1),eval(splitdate1[0]),eval(splittime1[0]),eval(splittime1[1]));
			
		if(Date.parse(regn_date) > Date.parse(from_date)) {
			 alert(getMessage("APP-OH00096" , "OH") + " " + regn_date_time);
		   	 formObj.strtDate.focus();
			// formObj.strtDate.select();
			 return false;
		    }
			else if(Date.parse(regn_date) <= Date.parse(from_date)) return true;
		 }
	// }
	return true;

}

// Used to check if the Start Date is less than the System Date.

function checkStartDateNotGreaterThanSysDate() 
{
	
	 var formObj = document.forms[0];
	 var locale = formObj.locale.value;
	 var startDate = convertDate(formObj.strtDate.value,'DMY',locale,"en");
	 var startTime = formObj.strtTime.value;
	 if(startTime == "") startTime = "00:00"
	 var entered_date = startDate + " " + startTime;
 	 var sys_date = new Date();
	
	 var month = sys_date.getMonth();
	 var year = sys_date.getFullYear();
	 var date = sys_date.getDate();
	 var hours = sys_date.getHours();
	 var mins = sys_date.getMinutes();
	
	 if(entered_date != ""){
		 var startDateArray = startDate.split("/");
		 var startTimeArray	= startTime.split(":");
		  
		 var enteredDateObject =new Date(eval(startDateArray[2]), eval(startDateArray[1])-1, 
			 eval(startDateArray[0]), eval(startTimeArray[0]), eval(startTimeArray[1]));
		 var sysDateObject = new Date(eval(year),eval(month),eval(date),eval(hours),eval(mins));
		 if(Date.parse(sysDateObject) >= Date.parse(enteredDateObject)){
				return true;
		}
		else if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) {
			alert(getMessage("APP-OH00099","OH"));
			formObj.strtDate.focus();
			//formObj.strtDate.select();
			return false;
		}
	}
	return true;
}


// Used to check if the End Date is less than the System Date.
function checkEndDateNotGreaterThanSysDate() 
{
	 var formObj = document.forms[0];
	 var locale=formObj.locale.value;
	 var endDate = convertDate(formObj.endDate.value,'DMY',locale,"en");
	 var endTime = formObj.endTime.value;
	  if(endTime == "") endTime = "00:00"

	 var entered_date = endDate + " " + endDate;
 	 var sys_date = new Date();
	
	 var month = sys_date.getMonth();												
	 var year = sys_date.getFullYear();
	 var date = sys_date.getDate();
	 var hours = sys_date.getHours();
	 var mins = sys_date.getMinutes();
	
	 if(entered_date != ""){
		 var endDateArray = endDate.split("/");
		 var endTimeArray	= endTime.split(":");
		  
		 var enteredDateObject =new Date(eval(endDateArray[2]), eval(endDateArray[1])-1, 
			 eval(endDateArray[0]), eval(endTimeArray[0]), eval(endTimeArray[1]));
		 var sysDateObject = new Date(eval(year),eval(month),eval(date),eval(hours),eval(mins));
		
		 if(Date.parse(sysDateObject) >= Date.parse(enteredDateObject)){
				return true;
		}
		else if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) {
			alert(getMessage("APP-OH000100","OH"));
			formObj.endDate.focus();
			//formObj.endDate.select();
			return false;
		}
	  }
		
	return true;
}

// Used to check if the Start Date is greater than or equal to the End Date.
function checkDates(){

	var formObj = document.forms[0]; 
	var startDate = formObj.strtDate.value;
	var endDate = formObj.endDate.value;
	var startTime = formObj.strtTime.value;
	var endTime = formObj.endTime.value;

	var start_date_time = startDate + " " + startTime;
	var end_date_time = endDate + " " + endTime;

 		if(startDate.length > 0 || endDate.length > 0 || startTime.length > 0 || endTime.length > 0){
			//if(doDateCheckAlert(formObj.strtDate,formObj.endDate)){
				if(ValidateDateTime(start_date_time,end_date_time)){
					return true;
		}else{
			alert(getMessage("APP-OH00097","OH"));
			formObj.endDate.focus();
		//	formObj.endDate.select();
			return false;
			}
		}

	return true;
}

//Date Validation Check
function checkDateValidity(obj){
	if(obj.value!=null && obj.value!=""){
		var retVal = CheckDate(obj.value);
		if(retVal==false){
			obj.focus();
			obj.select();
			//return false;
			return false;
		}
	}
	return true;
}

//Time Validation check
function checkTimeValidity(obj){
	if(obj.value!=null && obj.value!=""){
		var retVal = chkTime(obj.value);
		if(retVal==false){
			alert(getMessage("APP-OH00098","OH"));		
			obj.focus();
			obj.select();
			return false;
		}
	}
	return true;
}
 // To allow only 0-9 and : while entering time.
 function NumberTimeCheck(obj){ 
	if ((event.keyCode < 48) || (event.keyCode > 58))
	{
		event.keyCode=0;
	}
}

// To clear the Status combo box once recorded.
function clear_list(obj){
	while(obj.options.length > 0){
		obj.remove(obj.options[0]);
	}
}

//To register Order.. 
function registerOrder(chart_num,chart_line_num,order_id,order_line_num){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	params = "order_id="+order_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&order_line_num="+order_line_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=registerOrder&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText); 
	retVal = localTrimString(retVal); 
	var retVal_arr = retVal.split("##");
	if(retVal_arr[0] != "1" && retVal_arr[1] != "1"){
		return false;
	}
	return true;
}


function populateAllTrmtCategories(site){
	//selected_tooth_count = 0; // commented on 08/10/07 by sridevi (count was bcoming zero when u select 2 tooth and click on the tooth no(after populating menu) and if u try to select 3 rd tooth count was becoming 0)
	var formObj = document.forms[0];
	var params = "";
	var tab_name = "T";

	// get the Menu Items
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	params = "func_mode=getMenu&tab_name="+tab_name+"&site="+site;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalRules.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText); 
	clearBean();
}

function assignFunctionIDList(function_id_list){
	var formObj = document.forms[0];
	formObj.function_id_list.value = function_id_list;
}
function assignFunctionNameList(function_name_list){
	var formObj = document.forms[0];
	formObj.function_name_list.value = function_name_list;
}
function assignFunctionTypeList(function_type_list){
	var formObj = document.forms[0];
	formObj.function_type_list.value = function_type_list;
}
function assignFunctionTypeDescList(function_type_desc_list){
	var formObj = document.forms[0];
	formObj.function_type_desc_list.value = function_type_desc_list;
}
function assignFunctionCatCodeList(function_cat_code_list){
	var formObj = document.forms[0];
	formObj.function_cat_code_list.value = function_cat_code_list;
}

function clearBean(){
	var dummy="dummy";
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" dummy=\""+ dummy + "\" ";
	xmlStr +=" /></root>";
	return fieldValidation(xmlStr,"clearBean");
}

function fieldValidation(xmlStr,source){
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalRules.jsp?func_mode="+source,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(trimString(responseText));
    return true;
}

//Function to validate the Date in yyyy/MM/DD

 function CheckDate(Object2,focusflag) {
	var datefield = Object2;
	if (Object2.value != undefined)
    {
		Object2 = Object2.value;
    }
	else
	{
		Object2 = Object2;
	}

	hasChanged= true;
    if (ChkDate(Object2) == false) {
		if(hasChanged){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			if (datefield.value != undefined && focusflag == null)
			{
				datefield.select();
				datefield.focus();
			}
			hasChanged = false;
			return false;
		}
	}
    else {
        return true;
    }
}

function ChkDate(Object3) {

	if (Object3.value != undefined)
    {
		Object3 = Object3.value;
    }
	else
	{
		Object3 = Object3;
	}
    var strDate;
    var strDay;
    var strMonth;
    var strYear;
    var datefield = Object3;
    var strDateArray = new Array();

    strDate = datefield;
    if (strDate.length == 0) return true;

if(Object3.indexOf('.') > 0) return false;

    strDateArray = strDate.split("/");
    if (strDateArray.length != 3) {
        return false;
    }
    else {
        strDay = trimString(strDateArray[0]);
        strMonth = trimString(strDateArray[1]);
        strYear = trimString(strDateArray[2]);
    }


    if (strYear.length < 4 || strYear.length > 4) return false;

    if (isNaN(strDay)==true) return false;
    if (isNaN(strMonth)==true) return false;
    if (isNaN(strYear)==true) return false;

    if (strYear < 1800) return false;

        if (strMonth>12 || strMonth<1)  return false;

    if ((strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12) && (strDay > 31 || strDay < 1)) return false;

    if ((strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11) && (strDay > 30 || strDay < 1)) return false;

    if (strMonth == 2) {
        if (strDay < 1) return false;

        if (LeapYear(strYear) == true) {
            if (strDay > 29) return false;
        }
        else {
            if (strDay > 28) return false;
        }
    }
    return true;
}

//Function to check for LeapYear
function LeapYear(strYear) {
    if (strYear % 100 == 0) {
        if (strYear % 400 == 0)  return true;
    }
    else {
        if ((strYear % 4) == 0)  return true;
    }
    return false;
}

function checkDateGreaterThanScheduleDate(schedule_date_time,messageFrame){
	 var sys_date = new Date();
	 var month = sys_date.getMonth();												
	 var year = sys_date.getFullYear();
	 var date = sys_date.getDate();
	 var hours = sys_date.getHours();
	 var mins = sys_date.getMinutes();

	 var formObj = document.forms[0];
	 var task_desc = formObj.task_desc.value;
	
	 var msg = getMessage("APP-OH000111","OH");
	 var msgArray = msg.split("##");
	 if(schedule_date_time != "" && schedule_date_time != "null" && schedule_date_time != null){
		 var schedule_date_time_array = schedule_date_time.split(" "); 
		 var schedule_split_date = schedule_date_time_array[0];
		 var schedule_split_time = schedule_date_time_array[1];

	      schedule_split_date =schedule_split_date.split("-");
          schedule_split_time= schedule_split_time.split(":");

	     var schedule_date_display = schedule_split_date[2] + "-" + schedule_split_date[1] + "-" + schedule_split_date[0];
		 var schedule_time_display = schedule_split_time[0] + ":" + schedule_split_time[1];
		  
		 var scheduledObject =new Date(eval(schedule_split_date[0]), eval(schedule_split_date[1]-1), 
			 eval(schedule_split_date[2]), eval(schedule_split_time[0]), eval(schedule_split_time[1]));
		 var sysDateObject = new Date(eval(year),eval(month),eval(date),eval(hours),eval(mins));
	
		if(Date.parse(sysDateObject) >= Date.parse(scheduledObject)){
				return true;
		}
		else if(Date.parse(sysDateObject) < Date.parse(scheduledObject)) {
			var appt_ref_no = document.forms[0].appt_ref_num0.value;
			var reasonforcancel = document.forms[0].reasonforcancel.value;
			var patient_id = document.forms[0].patient_id.value;
			var chart_num = document.forms[0].chart_num.value;
			var chart_line_num = document.forms[0].chart_line_num.value;
			if(appt_ref_no != "" ){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "patient_id="+patient_id+"&appt_ref_no="+appt_ref_no+"&reason_for_cancel="+reasonforcancel+"&status=10"+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=cancelOAAppt&"+params,false);
				xmlHttp.send(xmlDoc);
				var retValue_oaappt_cancel = trimString(xmlHttp.responseText); 
				retValue_oaappt_cancel = localTrimString(retValue_oaappt_cancel); 
				if(retValue_oaappt_cancel != "") {
					messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+retValue_oaappt_cancel;	
					return false;
				}
			}  
			
		}
	  }
		
	return true;

}
//written by parul on 24/08/2009 for CRf 0483

function populateCuspTip(obj){
	var formObj = document.forms[0];
	var tooth_num="";
	var tooth_name="";
	var mapped_tooth_no="";
	var mixed_dent_tooth_no="";
	var condition_type="";
	var condition_type1="";
	var disply_tooth_no="";
	var surface_ref="";
	var tooth_no_hid=formObj.oh_area.value;
	var chart_num=formObj.chart_num.value;
	var patient_id=formObj.patient_id.value;
	var permanent_deciduous_flag=formObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN=formObj.mixed_dentition_YN.value;
	var tooth_numbering_system=formObj.tooth_numbering_system.value;
	var super_tooth_ref=formObj.super_tooth_ref.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no_hid+"&patient_id="+patient_id+"&chart_num="+chart_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDisplayCondition&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal1 = trimString(xmlHttp.responseText);
	retVal1 = localTrimString(retVal1);
	if(retVal1.length > 1){
		var retVal_arr1 = retVal1.split("~");
		for(var i=0;i<retVal_arr1.length-1;i++){
			condition_type1 = retVal_arr1[i];
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no_hid+"&numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
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
				mixed_dent_tooth_no = retVal_arr[3];
			}

			if((permanent_deciduous_flag=="D" || permanent_deciduous_flag=="P") && mixed_dentition_YN=="Y"){
				if (super_tooth_ref=="RD"){
					if(permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y"){
						tooth_no_hid=formObj.oh_area.value;
						break;
					}else{ 
						tooth_no_hid=mapped_tooth_no;
						break;
					}
				}else{
					if (condition_type1=="DECITH" || condition_type1=="ERUPTH" ){
						tooth_no_hid=mapped_tooth_no;
						if (mapped_tooth_no=="" || mapped_tooth_no=="null" || mapped_tooth_no==null) {
							tooth_no_hid=formObj.oh_area.value;	
						}
					}else if (permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y" ){
						if (condition_type1=="ERUPTH" || condition_type1=="PARERTH") {
							tooth_no_hid=mapped_tooth_no;
							if (mapped_tooth_no=="" || mapped_tooth_no=="null" || mapped_tooth_no==null) {
							  tooth_no_hid=formObj.oh_area.value;	
							}
							break;
						}
					}else{
						tooth_no_hid=formObj.oh_area.value;	
						break;
					}
				}
			}
			else{
				if(super_tooth_ref=="RD"){
					tooth_no_hid=mapped_tooth_no;
					break;
				}else{
					tooth_no_hid=formObj.oh_area.value;	
					break;
				}
			}
		}
	}
	
	clear_list(document.forms[0].oh_cusp_tip); 
	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	document.forms[0].oh_cusp_tip.add(optSel);
	//var surface_code_val = obj.value;

	 //added by parul for CRF#0483 on 21/01/2010
	 for(var m=0;m<formObj.oh_surface.options.length;m++){
		 formObj.oh_surface.options[0].selected =false;  
		if(formObj.oh_surface.options[m].selected==true){

			if(surface_ref==""){
				surface_ref=formObj.oh_surface.options[m].value;
			}else{
				surface_ref=surface_ref+","+formObj.oh_surface.options[m].value;
			}
	   }
   }
   
   var surface_ref_all="";
    for(var m=0;m<formObj.oh_surface.options.length;m++){
		 if(!formObj.oh_surface.options[0].selected){
		     document.forms[0].surface_ref.value="";
		 }else{
		     surface_ref_all=document.forms[0].surface_ref.value;
		 }
	}

   if (surface_ref_all=="*A"  && formObj.called_from_viewchart_yn.value != 'Y' && surface_ref==""){
	   surface_ref="*A";
	    tooth_no_hid="";
	    //document.forms[0].surface_ref.value="";
   }
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "surface_code_val="+surface_ref+"&tooth_no_hid="+tooth_no_hid;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateCuspTip&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length>1){
		var retVal_arr = retVal.split("~");
		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			var element 	= document.createElement('OPTION') ;
			element.value 	= code_desc_arr[0];
			element.text 	= code_desc_arr[1] ;
			document.forms[0].oh_cusp_tip.add(element);
			
		}
		
		formObj.oh_cusp_tip.disabled=false;
	}else{
		formObj.oh_cusp_tip.disabled=true;

	}
}

//written by parul on 24/08/2009 for CRf 0483
function enableDisableCuspTip(obj){
	if(obj.value != null ){
		if(obj.value == 'ROOT' || obj.value == 'CROWN'){
			if (document.forms[0].oh_cusp_tip.options.length==1){
				document.forms[0].oh_cusp_tip.disabled = true;
			}
			else{
				document.forms[0].oh_cusp_tip.disabled = false;
			}
		}
		else{
			document.forms[0].oh_cusp_tip.disabled = true;

		}
	}
}

function setValue(obj){
	if(obj.checked==true){document.getElementById("performed_In_OT").value="Y";}
	else{document.getElementById("performed_In_OT").value="N";}

}

function checkForDuplicateTrmtRecord(status,patient_id,chart_num,tooth_no,trmt_category_type,surface_code,site_type,treatments_outcome){
	if(status != "E"){
		var formObj = document.forms[0];
		var trmt_code = formObj.oh_treatment.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var RD_Normal_yn  = document.forms[0].RD_Normal_yn.value;
		var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
		var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
		var header_tab = formObj.header_tab.value
		var super_tooth_ref = formObj.super_tooth_ref.value
		var retained_tooth_no="";
		var isRetainedYN="";
		var numbering_system = formObj.tooth_numbering_system.value;

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
			if(condition_type_ref == "RTDESTH"){
				isRetainedYN = "Y";
			}

		 if (mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
			
				  if (isRetainedYN=="Y" && (super_tooth_ref != "RD" && (super_tooth_ref == "" || super_tooth_ref == "undefined" || super_tooth_ref == undefined))){
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
				 if(super_tooth_ref == "RD"){//Added by parul on 12/17/2009 for RTDESTH new changes
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


		//added by parul for IN16418 on 27/11/2009
        var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForRTDESTH&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_Rtdesth = trimString(xmlHttp.responseText);
		retVal_Rtdesth = localTrimString(retVal_Rtdesth); 
		//Added by Sharon Crasta on 2/20/2010 for IN019270
		if(site_type == "THRNG"){
			var tooth_no_range = tooth_no.split(",");
			var tooth_no_range_txt = new Array();
			if(site_type == "THRNG"){
				if(formObj.oh_area.options == "" || formObj.oh_area.options == "null" || formObj.oh_area.options == null || formObj.oh_area.options.length == "undefined" || formObj.oh_area.options == undefined){
					var tooth_no_range_values = formObj.oh_area.value;
					tooth_no_range_txt = tooth_no_range_values.split(",");
				}else{
					for(var tr=0;tr<tooth_no_range.length; tr++) {
						for (var m=0;m<formObj.oh_area.options.length; m++) {
							if(tooth_no_range[tr] == formObj.oh_area.options[m].value){
									tooth_no_range_txt[tr] = formObj.oh_area.options[m].text;
							}
						
						}	
					}
				}
			}

			var k = 0;
			var display_tooth_no_text = new Array();
			var numbering_system = formObj.tooth_numbering_system.value;
			var retVal = "";
			var msg = getMessage("APP-OH00076","OH");
			var msg_arr = msg.split("##");

			var msg_count = 0;
			var mapped_tooth_no ="";
			for(var j = 0;j < tooth_no_range.length; j++){
				var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_range[j]+"&trmt_category_type="+trmt_category_type+"&surface_code="+surface_code+"&trmt_code="+trmt_code+"&site_type="+site_type+"&RD_Normal_yn="+RD_Normal_yn+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&header_tab="+header_tab+"&chart_line_num_Rtdesth=0"+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForDuplicateTrmtRecord&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal=localTrimString(retVal);

				if(retVal.length > 0 && parseInt(retVal) > 0){ //Record Already Present
					msg_count++;
					var trmt_desc_text = formObj.oh_treatment.options[formObj.oh_treatment.options.selectedIndex].text;
					display_tooth_no_text[k] = tooth_no_range_txt[k];
					k++;
				}
			}

			if(msg_count > 0){
				alert(msg_arr[0]+"'"+trmt_desc_text+"'"+msg_arr[1]+display_tooth_no_text+msg_arr[2]);
				return false;
			}
		}
		/*else if (site_type == "MAXFS"){
		   var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&trmt_category_type="+trmt_category_type+"&surface_code="+surface_code+"&trmt_code="+trmt_code+"&site_type="+site_type+"&RD_Normal_yn="+RD_Normal_yn+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&header_tab="+header_tab+"&chart_line_num_Rtdesth="+retVal_Rtdesth+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&treatments_outcome="+treatments_outcome;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForDuplicateTrmtRecord&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 0 && parseInt(retVal) > 0){ //Record Already Present
				
				var trmt_desc_text = formObj.oh_treatment.options[formObj.oh_treatment.options.selectedIndex].text;
				var display_tooth_no_text = formObj.oh_area.options[formObj.oh_area.options.selectedIndex].text;
				if(site_type == "ARCH" || site_type == "QUAD"){
					var msg = getMessage("APP-OH00077","OH");
				}
				else{
					var msg = getMessage("APP-OH00076","OH");
				}
				var msg_arr = msg.split("##");
				//Added by SRidevi Joshi on 2/17/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_SuperKey = trimString(xmlHttp.responseText); 
				retVal_SuperKey = localTrimString(retVal_SuperKey); 
				var retVal_SuperKey_arr = retVal_SuperKey.split("~");
				if(retVal_SuperKey_arr.length > 1){
					for(var d=0;d<retVal_SuperKey_arr.length-1;d++){
						if(retVal_SuperKey_arr[d] == super_tooth_ref){
							display_tooth_no_text = retVal_SuperKey_arr[d]+"["+display_tooth_no_text+"]";
						}
					}
				}
				alert(msg_arr[0]+"'"+trmt_desc_text+"'"+msg_arr[1]+display_tooth_no_text+msg_arr[2]);
				return false;
			}

		}*/else{ //End 
		   if (site_type == "MAXFS"){
			var tooth_no1=tooth_no;
			var organ_code=formObj.oh_surface.value;
			var sub_organ_code=formObj.oh_sub_parts.value;
			var intraoral_extraoral=formObj.oh_area.value;
			var called_from_viewchart_yn=formObj.called_from_viewchart_yn.value;
		
			if(typeof formObj.oh_selected_sub_parts!="undefined"){
			//var tooth_no=formObj.oh_selected_sub_parts.value;
			var tooth_no="";
			var thrng_nos_ref="";
            	if(formObj.oh_sub_parts.value=="TNGAB" || formObj.oh_sub_parts.value=="TNGGM" || formObj.oh_sub_parts.value=="TNGAG" ||			formObj.oh_sub_parts.value=="TNGGAM" || formObj.oh_sub_parts.value=="TNGMF"){
						if(thrng_nos_ref=="") {
							if(called_from_viewchart_yn != "Y"){
								for(var m=0;m<formObj.oh_selected_sub_parts.options.length;m++){
									formObj.oh_selected_sub_parts.options[0].selected =false;     
									if(formObj.oh_selected_sub_parts.options[m].selected==true){
										if(thrng_nos_ref==""){
											thrng_nos_ref=formObj.oh_selected_sub_parts.options[m].value;
										}else{
											thrng_nos_ref=thrng_nos_ref+","+formObj.oh_selected_sub_parts.options[m].value;
										}
									}
								}
								formObj.thrng_nos_ref.value = thrng_nos_ref;
								tooth_no = thrng_nos_ref;
							}
						}else{
							tooth_no = formObj.oh_selected_sub_parts.value;
						}
					}else{
							tooth_no = formObj.oh_selected_sub_parts.value;
					}
					
			}
            if (tooth_no.indexOf("s")>=0){
				super_tooth_ref=tooth_no.substring(tooth_no.indexOf("s"),tooth_no.length);
				tooth_no=tooth_no.substring(0,tooth_no.indexOf("s"));
            }

			if (tooth_no.indexOf("r")>=0){
				retained_tooth_no=tooth_no.substring(0,tooth_no.indexOf("r"));
				tooth_no=tooth_no.substring(0,tooth_no.indexOf("r"));
			}

			if(typeof formObj.oh_selected_sub_parts!="undefined"){
				var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&trmt_category_type="+trmt_category_type+"&surface_code="+surface_code+"&trmt_code="+trmt_code+"&site_type="+site_type+"&RD_Normal_yn="+RD_Normal_yn+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&header_tab="+header_tab+"&chart_line_num_Rtdesth="+retVal_Rtdesth+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&treatments_outcome="+treatments_outcome+"&organ_code="+organ_code+"&sub_organ_code="+sub_organ_code+"&intraoral_extraoral="+intraoral_extraoral+"&numbering_system="+numbering_system;
			}else{
				var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&trmt_category_type="+trmt_category_type+"&surface_code="+surface_code+"&trmt_code="+trmt_code+"&site_type="+site_type+"&RD_Normal_yn="+RD_Normal_yn+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&header_tab="+header_tab+"&chart_line_num_Rtdesth="+retVal_Rtdesth+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&treatments_outcome="+treatments_outcome+"&organ_code="+organ_code+"&sub_organ_code="+sub_organ_code+"&intraoral_extraoral="+intraoral_extraoral+"&numbering_system="+numbering_system;
			}

			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForDuplicateTrmtRecord&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal1 = trimString(xmlHttp.responseText);
			retVal1=localTrimString(retVal1);
			
			if(retVal1.indexOf("$$")>=0){
				retVal1=retVal1.split("$$");
				for(var j=1;j<retVal1.length;j++){
					if(j==1) {
						display_tooth_no_text=retVal1[j];
					}else{
						display_tooth_no_text=display_tooth_no_text+","+retVal1[j];
					}
			
				}
				var retVal=retVal1[0];	
			}else{
				if(typeof formObj.oh_selected_sub_parts!="undefined"){
					display_tooth_no_text = formObj.oh_selected_sub_parts.options[formObj.oh_selected_sub_parts.options.selectedIndex].text;
					retVal=retVal1;
				}else{
					retVal=retVal1;
					display_tooth_no_text = formObj.oh_sub_parts.options[formObj.oh_sub_parts.options.selectedIndex].text;
				}
			}
			
			if(retVal.length > 0 && parseInt(retVal) > 0){ //Record Already Present
				var trmt_desc_text = formObj.oh_treatment.options[formObj.oh_treatment.options.selectedIndex].text;
				
				/*if (site_type == "MAXFS"){
					
				var display_tooth_no_text = formObj.oh_selected_sub_parts.options[formObj.oh_selected_sub_parts.options.selectedIndex].text;
				}else{
				var display_tooth_no_text = formObj.oh_area.options[formObj.oh_area.options.selectedIndex].text;
				}*/
				if(site_type == "ARCH" || site_type == "QUAD" || typeof formObj.oh_selected_sub_parts=="undefined"){
					var msg = getMessage("APP-OH00077","OH");
				}
				else{
					var msg = getMessage("APP-OH00076","OH");
				}

				var msg_arr = msg.split("##");
				//Added by SRidevi Joshi on 2/17/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_SuperKey = trimString(xmlHttp.responseText); 
				retVal_SuperKey = localTrimString(retVal_SuperKey); 
				var retVal_SuperKey_arr = retVal_SuperKey.split("~");
				/*if(retVal_SuperKey_arr.length > 1){
					for(var d=0;d<retVal_SuperKey_arr.length-1;d++){
						if(retVal_SuperKey_arr[d] == super_tooth_ref){
							display_tooth_no_text = retVal_SuperKey_arr[d]+"["+display_tooth_no_text+"]";
						}
					}
				}*/
				alert(msg_arr[0]+"'"+trmt_desc_text+"'"+msg_arr[1]+display_tooth_no_text+msg_arr[2]);
				return false;
			}
		   }else{
			   var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&trmt_category_type="+trmt_category_type+"&surface_code="+surface_code+"&trmt_code="+trmt_code+"&site_type="+site_type+"&RD_Normal_yn="+RD_Normal_yn+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&header_tab="+header_tab+"&chart_line_num_Rtdesth="+retVal_Rtdesth+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&treatments_outcome="+treatments_outcome;		   
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForDuplicateTrmtRecord&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);

			if(retVal.length > 0 && parseInt(retVal) > 0){ //Record Already Present
				var trmt_desc_text = formObj.oh_treatment.options[formObj.oh_treatment.options.selectedIndex].text;
				
				if (site_type == "MAXFS"){
					
				var display_tooth_no_text = formObj.oh_selected_sub_parts.options[formObj.oh_selected_sub_parts.options.selectedIndex].text;
				}else{
				var display_tooth_no_text = formObj.oh_area.options[formObj.oh_area.options.selectedIndex].text;
				}
				if(site_type == "ARCH" || site_type == "QUAD"){
					var msg = getMessage("APP-OH00077","OH");
				}
				else{
					var msg = getMessage("APP-OH00076","OH");
				}

				var msg_arr = msg.split("##");
				//Added by SRidevi Joshi on 2/17/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_SuperKey = trimString(xmlHttp.responseText); 
				retVal_SuperKey = localTrimString(retVal_SuperKey); 
				var retVal_SuperKey_arr = retVal_SuperKey.split("~");
				if(retVal_SuperKey_arr.length > 1){
					for(var d=0;d<retVal_SuperKey_arr.length-1;d++){
						if(retVal_SuperKey_arr[d] == super_tooth_ref){
							display_tooth_no_text = retVal_SuperKey_arr[d]+"["+display_tooth_no_text+"]";
						}
					}
				}
					var surface_ref="";
			  if (surface_ref=="") {		
				for(var m=0;m<formObj.oh_surface.options.length;m++){
					formObj.oh_surface.options[0].selected =false;  
				   if(formObj.oh_surface.options[m].selected==true){
					  if(surface_ref==""){
					  surface_ref=formObj.oh_surface.options[m].value;

					 } else{
					  surface_ref=surface_ref+","+formObj.oh_surface.options[m].value;
					  }
				   }
			   }
			 formObj.surface_ref.value=surface_ref;
		   }else{
			  surface_ref=formObj.oh_surface.value;
		   }

		var Surface_label=getLabel("eOH.Surface.Label","OH");

		 if ((surface_code!="")){
				var retVal_surface_arr2="";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "surface_code="+surface_ref;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=displaySurfacesDescription&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_surface = trimString(xmlHttp.responseText);
				retVal_surface = localTrimString(retVal_surface);

				if(retVal_surface.length>1){
					if(retVal_surface.indexOf("~")!=-1){
						var retVal_surface_arr=retVal_surface.replace("~",",");
						var retVal_surface_arr1=retVal_surface_arr.replace("~",",");
						var retVal_surface_arr3=retVal_surface_arr1.replace("~",",");
						var val_surface=retVal_surface_arr3.substring(0,retVal_surface_arr3.length-1);
						 retVal_surface_arr2=val_surface.substring(0,val_surface.lastIndexOf(','));						

					}else{
						retVal_surface_arr2=retVal_surface;
					}
				}
            
				  alert(msg_arr[0]+"'"+trmt_desc_text+"'"+msg_arr[1]+display_tooth_no_text+msg_arr[2]+"("+Surface_label+"#"+retVal_surface_arr2+")");

              }else{
				alert(msg_arr[0]+"'"+trmt_desc_text+"'"+msg_arr[1]+display_tooth_no_text+msg_arr[2]);
			  }
				return false;
			}
		  }
		}
		
	}
	return true;
}

// Time validation  added by Yadav 1/13/2010
//===============================================
function verify(timeBox){
	if(parseInt(timeBox.value.length)<=parseInt(5))
	{
		if(timeBox.value!=""){
		time=timeBox.value
		   time1=time.split(':')
		   if (!/\d{2}:\d{2}/.test(time)){ 
				alert(getMessage("APP-OH000143","OH"));
				timeBox.value='';
				timeBox.focus();
		      return false;
		   }
		   else if (time1[0] >23 || time1[1]>59) {
				alert(getMessage("APP-OH000143","OH"));
        timeBox.value='';
        timeBox.focus();
        return false;
		}else return true;
			

		}else
		{
			timeBox.value='';
				alert(getMessage("APP-OH000143","OH"));
				 timeBox.focus();
					return false;
		}
		}
		else
		{
			timeBox.value='';
				alert(getMessage("APP-OH000143","OH"));
				 timeBox.focus();
					return false;
		}
}

// Time validation  added by Yadav 1/21/2010
function compareDates(fromdate,todate){
    var fromArr=fromdate.split(" ");
	var startDate =convertDate(fromArr[0],'DMYHM',locale,"en");
	var startTime=fromArr[1];
	 var toArr=todate.split(" ");
	var endDate =convertDate(toArr[0],'DMYHM',locale,"en");
	var endTime=toArr[1];
	var formObj = document.forms[0]; 
	var start_date_time = convertDate(fromdate,'DMYHM',locale,"en");
	//var end_date_time = todate;
	var end_date_time =convertDate(todate,'DMYHM',locale,"en");


 		if(startDate.length > 0 || endDate.length > 0 || startTime.length > 0 || endTime.length > 0){
			
			if(ValidateDateTime(start_date_time,end_date_time)){
					return true;
				}else{
						var message=getMessage("APP-OH000155",'OH')+" "+fromdate;
						alert(message);
						//formObj.regDate.value="";
						//formObj.regTime.value="";
						return false;
					}
		}

}

// Time validation  added by Yadav 1/21/2010
function checkRegDateNotGraterThanSysDate(obj) 
{

		var currDate = new Date();
		var date = currDate.getDate();
		var mon = currDate.getMonth();
		var hrNow = currDate.getHours();
		var mnNow = currDate.getMinutes();
		scNow = currDate.getSeconds();
		mon = mon+1;
		var year = currDate.getYear();
		if(date <10)
			date = "0"+date;
		if(mon <10)
			mon = "0"+mon;
		var convert1= date + "/" + mon + "/" + year;
		if(hrNow<10)
				hrNow="0"+hrNow;
		if(mnNow<10)
				mnNow="0"+mnNow;
		
		var sysdateTime=convert1+" "+hrNow+ ":" +mnNow;
			if(sysdateTime.length > 0 || obj.length > 0 ){
			
				if(ValidateDateTime(obj,sysdateTime)){
					return true;
				}else{
						var message=getMessage("APP-OH000154",'OH');
						alert(message);
						//formObj.regDate.value="";
						//formObj.regTime.value="";
						return false;
					}
		}

			
}

 /* Below Code is added by sathish against CRF-0487 on 24-02-2010*/
async function openNotes(patient_id,chart_num,chart_line_num,trmt_code,task_code,progress_note_group){
		var formObj = document.OHTreatmentForm;
		var params = formObj.params.value;
        var contr_mod_acession_num=chart_num+"$$"+trmt_code+"$$"+chart_line_num;
		var contr_mod_acession_num="";
		var oh_chart_level          =formObj.oh_chart_level.value;
		var other_chart_facility_id =formObj.other_chart_facility_id.value;
		var trmt_done_yn            =formObj.trmt_done_yn.value;
		var progression_ref         ="";
		var task_seq_no             =formObj.task_seq_no.value;
		var baseline_chart_yn       =formObj.baseline_chart_yn.value;
		var tooth_range             =formObj.tooth_range.value;
        
		/* Below Code is for getting progression_ref_num  from OH_RESTORATIVE_CHART_DTL table*/
		//var xmlDoc =  new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest();
		var params1 = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOH/jsp/DentalTrmtValidation.jsp?func_mode=getProgression_Ref&"+params1,false);
		xmlHttp.send(xmlDoc);
		var retVal_ref_num = trimString(xmlHttp.responseText);
		if(retVal_ref_num!='undefined')
        retVal_ref_num=localTrimString(retVal_ref_num);
		progression_ref=retVal_ref_num;		 
        if(trmt_done_yn=='Y' || baseline_chart_yn=='Y')
	    {
		if(progression_ref=='')
		{
		alert(getMessage("APP-OH000178",'OH'));
		return;
		}
		params="&title="+"Progress Notes"+"&level="+"PN"+"&note_group="+progress_note_group+"&progression_ref="+progression_ref+"&called_from=OH_TREATMENT"+"&"+params;
		var title = getLabel("eOH.ProgressNotes.Label","OH");
		var url="../../eOH/jsp/OHProgressNotesView.jsp?title="+title+"&module_id=OH&appl_task_id=PROGRESS_NOTES"+params;
		var dialogHeight = "80vh" ;
		var dialogWidth  = "80vw" ;
		//var dialogWidth  		= window.screen.availWidth;
		var dialogTop    = "10";
		var dialogLeft   = "50";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" + ";title:" +title ;
		var retVal=await window.showModalDialog(url,"CAWindow",features);
		}
	    else
	    {
		 if(progress_note_group=='')
		 {
		 alert(getMessage("APP-OH000177",'OH'));
		 return;
		 }
		params="&note_group="+progress_note_group+"&progression_ref="+progression_ref+"&called_from=OH_TREATMENT"+"&"+params;
		var title = getLabel("eOH.ProgressNotes.Label","OH");
		var url="../../eCA/jsp/ProgressNotesModal.jsp?title="+title+"&module_id=OH&appl_task_id=PROGRESS_NOTES"+params;
		var dialogHeight = "80vh" ;
		var dialogWidth  = "80vw" ;
		//var dialogWidth  		= window.screen.availWidth;
		var dialogTop    = "10";
		var dialogLeft   = "50";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" + ";title:" +title ;
		var retVal=await window.showModalDialog(url,"CAWindow",features);
		
        if(typeof retVal=='undefined') retVal='';
		retVal=localTrimString(retVal);
		progression_ref=retVal;
		if(progression_ref!='undefined' && progression_ref!='')
	    {
	
		var xmlDoc =  "";
		var xmlHttp = new XMLHttpRequest();
		var params2 = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&progression_ref="+progression_ref+"&tooth_range="+tooth_range;
					
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOH/jsp/DentalTrmtValidation.jsp?func_mode=update_Progression_ref&"+params2,false);
		xmlHttp.send(xmlDoc);
		var flag = trimString(xmlHttp.responseText);
		}
	}
}
/* Added code by sathish ends here*/

function CurrTime(){
		var formObj = document.forms[0];
		//var locale=formObj.locale.value;
		var treatment_status_param = formObj.treatment_status_param.value;
		var treatment_flag = formObj.treatment_flag.value;
		var currDate = new Date();
		var date = currDate.getDate();
		var mon = currDate.getMonth();
		var hrNow = currDate.getHours();
		var mnNow = currDate.getMinutes();
		scNow = currDate.getSeconds();
		mon = mon+1;
		var year = currDate.getYear();
		if(date <10)
			date = "0"+date;
		if(mon <10)
			mon = "0"+mon;
			
		if(hrNow<10)
				hrNow="0"+hrNow;
		if(mnNow<10)
				mnNow="0"+mnNow;
		var convert1= date + "/" + mon + "/" + year;
		var  time=hrNow+":"+mnNow;
		if(treatment_status_param >= 15 && treatment_flag != "Y") {
			if(document.getElementById("regTime").value == ""){
				document.getElementById("regTime").value = time;
			}
		}
	}

	 function checkProgressNotesComplYN()
   {    
        var formobj=document.OHTreatmentForm;
	    var chart_num=formobj.chart_num.value;
	    var chart_line_num=formobj.chart_line_num.value;
	    var patient_id=formobj.patient_id.value;
	    var trmt_code =formobj.trmt_code.value;
	    var oh_chart_level =formobj.oh_chart_level.value;
	    var other_chart_facility_id =formobj.other_chart_facility_id.value;
	    var other_chart_facility_id =formobj.other_chart_facility_id.value;
	    var task_seq_no =formobj.task_seq_no.value;
	    var progression_ref =formobj.progression_ref.value;
	    var flag=true;
		var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
		
	    var xmlDoc =  "";
	    var xmlHttp = new XMLHttpRequest();
	   
				
	    var xmlStr ="<root><SEARCH ";
	    xmlStr +=" /></root>";
	    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	    xmlHttp.open("POST","../../eOH/jsp/DentalTrmtValidation.jsp?func_mode=getMaxSeqNoOfTask&"+params,false);
	    xmlHttp.send(xmlDoc);
	    var retVal = trimString(xmlHttp.responseText);
        retVal=localTrimString(retVal);

        if(retVal==task_seq_no)
	    {
	    var xmlDoc =  "" ;
	    var xmlHttp = new XMLHttpRequest();
	    var xmlStr ="<root><SEARCH ";
	    xmlStr +=" /></root>";
	    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	    xmlHttp.open("POST","../../eOH/jsp/DentalTrmtValidation.jsp?func_mode=checkProgressNotesComplYN&"+params,false);
	    xmlHttp.send(xmlDoc);
	    var retVal2 = trimString(xmlHttp.responseText);
	    retVal2=localTrimString(retVal2);

	    if(retVal2=='1')
	    {
	     alert(getMessage("APP-OH000179",'OH'));
	    flag=false;
	    }
	    else{
		flag=true;
	     }
	    }
		return flag;
	

   }

