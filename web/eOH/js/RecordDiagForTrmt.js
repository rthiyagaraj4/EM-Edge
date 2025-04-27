async function recordDiagForTrmt(cat_code){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var encounter_id = formObj.encounter_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var ind_chart_line_num = formObj.ind_chart_line_num.value;//Indivisual chart_line_num of a tooth in case of Tooth Range
	var trmt_code = formObj.trmt_code.value;
	var practitioner_id = formObj.practitioner_id.value;
	var display_tooth_no = formObj.display_tooth_no.value;
	//var arch_quad = formObj.arch_quad.value;
	var thrng_nos_ref = formObj.thrng_nos_ref.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var super_tooth_ref = formObj.super_tooth_ref.value;//Added by Sridevi Joshi on 2/24/2010 for IN010894
	var area = formObj.oh_area.value;
	var site_type = formObj.oh_site.value;
	var site_type_desc = formObj.oh_site.options[formObj.oh_site.options.selectedIndex].text;
	var baseline_chart_yn = formObj.baseline_chart_yn.value;//Added by Sridevi Joshi on 5/27/2010 for IN021653
	var date_diff_flag = formObj.date_diff_flag.value;//Added by Sridevi Joshi on 5/27/2010 for IN021668

	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var tooth_no=formObj.oh_area.value;
	var tooth_numbering_system=formObj.tooth_numbering_system.value;

	if(site_type=="ROOT" || site_type=="CROWN"){
		if(formObj.oh_surface.value != "" && formObj.oh_surface.value != null && formObj.oh_surface.value != "null"){
			//var surface_desc = formObj.oh_surface.options[formObj.oh_surface.options.selectedIndex].text;
			var surface_desc = formObj.oh_surface.value;
			
		}
		else{
			var surface_desc = formObj.oh_surface.options[formObj.oh_surface.options.selectedIndex].text;
		}
	}else{
	     var surface_desc ="";
	}
	if(site_type == "QUAD" || site_type == "ARCH" || site_type == "MAXFS"){//Condition for MAXFS is added by Sridevi Joshi on 5/14/2010 for IN021358
		var area_desc = formObj.oh_area.options[formObj.oh_area.options.selectedIndex].text;
	}
	else{
		//var area_desc = display_tooth_no;//commented by parul on 120309 and added below lines(Wrong display for Tooth Number / area in â??Link Diagnosis / Conditionâ??(site issue))
		if (site_type=="TOOTH" || site_type=="ROOT" || site_type=="CROWN")
		{
			var area_desc = formObj.oh_area.options[formObj.oh_area.options.selectedIndex].text;
			display_tooth_no=area_desc;
		}else{
			var area_desc=formObj.oh_area.value;
			display_tooth_no=area_desc;
		}
	}

	var window_title = getLabel("eOH.LinkDiagnosis.Label","OH");
	var tooth_count = 0;
	/*
	if(display_tooth_no.indexOf(",") != -1){
		var tooth_no_arr = display_tooth_no.split(",");
		tooth_count = tooth_no_arr.length;	
	}
	*/
	if(thrng_nos_ref.indexOf(",") != -1){
		var tooth_no_arr = display_tooth_no.split(",");
		tooth_count = tooth_no_arr.length;	
	}
	else{
		tooth_count = 0;
	}

	//var params = 'patient_id='+patient_id+"&chart_num="+chart_num+"&encounter_id="+encounter_id+"&trmt_code="+trmt_code+"&practitioner_id="+practitioner_id+"&chart_line_num="+chart_line_num+"&trmt_category_code="+cat_code+"&ind_chart_line_num="+ind_chart_line_num+"&tooth_no="+display_tooth_no+"&tooth_count="+tooth_count+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&site_type_desc="+site_type_desc+"&surface_desc="+surface_desc+"&site_type="+site_type+"&window_title="+window_title+"&area_desc="+area_desc+"&area_param="+area+"&thrng_nos_ref="+thrng_nos_ref;
	var params = 'patient_id='+patient_id+"&chart_num="+chart_num+"&encounter_id="+encounter_id+"&trmt_code="+trmt_code+"&practitioner_id="+practitioner_id+"&chart_line_num="+chart_line_num+"&trmt_category_code="+cat_code+"&ind_chart_line_num="+ind_chart_line_num+"&display_tooth_no="+display_tooth_no+"&tooth_count="+tooth_count+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&site_type_desc="+site_type_desc+"&surface_desc="+surface_desc+"&site_type="+site_type+"&window_title="+window_title+"&area_desc="+area_desc+"&area_param="+area+"&thrng_nos_ref="+thrng_nos_ref+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&super_tooth_ref="+super_tooth_ref+"&tooth_no="+tooth_no+"&tooth_numbering_system="+tooth_numbering_system+"&baseline_chart_yn="+baseline_chart_yn+"&date_diff_flag="+date_diff_flag;
	
	var url	= "../../eOH/jsp/RecordDiagForTrmtMainFrames.jsp?"+params;
	/* Parameters are to be changed to the size of the Dental Chart.Commented on 19/02/08 by Sridevi Joshi*/
	var dialogHeight= "60vh" ;
	var dialogWidth	= "65vw" ;
	var dialogTop ="125";
	var dialogLeft ="525";
	
	/*
	var dialogHeight= "22" ;
	var dialogWidth	= "50" ;
	var dialogTop ="170";
	var dialogLeft ="15";
	*/
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
	var retVal = await window.showModalDialog(url,arguments,features);

	//Refresh Dental Chart
	ca_params = parent.trmtDentalChartDetails.document.forms[0].ca_params.value;
	parent.trmtDentalChartDetails.location.href = '../../eOH/jsp/OHDentalChart.jsp?'+ca_params;

	//Refresh OHTrmtDentalChartViewDetails
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
	formObj.diagcodeselected.value = retVal;

}
/*
function acceptOptions(){
	var concat_str = "";
	var arrObj = document.forms[0].elements;
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="checkbox"){
				if(arrObj[i].checked == true){
					if(concat_str != ""){
						concat_str = concat_str+"~"+arrObj[i].term_code+"##"+arrObj[i].term_set_id+"##"+arrObj[i].occur_srl_no+"##"+arrObj[i].diag_status;
					}
					else{
						concat_str = arrObj[i].term_code+"##"+arrObj[i].term_set_id+"##"+arrObj[i].occur_srl_no+"##"+arrObj[i].diag_status;
					}
				}
		}
	}
	window.returnValue = concat_str;
	window.close();
	
}
*/

function acceptOptions(){
	var diag_flag = 0;
	var close_cond_flag = 0;
	var link_cond_flag = 0;
	var delete_flag = 0;
	DiagFormObj = parent.RecordDiagDetail.document.forms[0];

	var trmt_code = DiagFormObj.trmt_code.value;
	var patient_id = DiagFormObj.patient_id.value;
	var encounter_id = DiagFormObj.encounter_id.value;
	var chart_num = DiagFormObj.chart_num.value;
	var chart_line_num = DiagFormObj.chart_line_num.value;
	var oh_chart_level = document.forms[0].oh_chart_level.value;
	var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
	var concat_str = "";
	var close_cond_concat_str = "";
	var duplicate_yn = "N";

	var diag_trmt_code = "";
	var trmt_chart_num = "";
	var trmt_chart_line_num = "";
	var term_code = "";
	var term_set_id = "";
	var occur_srl_no = "";
	var diag_status = "";
	var deleted_success = 'N';

	//params from RecordDiagLinkedCondition.jsp
	if(parent.RecordDiagLinkedCondition.recordDiagLinkedCondition != "undefined" && parent.RecordDiagLinkedCondition.recordDiagLinkedCondition != undefined && parent.RecordDiagLinkedCondition.recordDiagLinkedCondition != "null" && parent.RecordDiagLinkedCondition.recordDiagLinkedCondition != null){
		var LinkedCondFormObj = parent.RecordDiagLinkedCondition.recordDiagLinkedCondition.document.forms[0];
		var diag_trmt_code = LinkedCondFormObj.trmt_code.value;
		var trmt_chart_num = LinkedCondFormObj.trmt_chart_num.value;
		var trmt_chart_line_num = LinkedCondFormObj.trmt_chart_line_num.value;
		var term_code = LinkedCondFormObj.term_code.value;
		var term_set_id = LinkedCondFormObj.term_set_id.value;
		var occur_srl_no = LinkedCondFormObj.occur_srl_no.value;
		var diag_status = LinkedCondFormObj.diag_status.value;
	}
	//Link Conditions to Diagnosis
	var hash = new Hashtable(); // Include Hashtable.js in your jsp file before defining this line...
	hash = parent.hidden_frame.hash; //Frames(5) To link Diag to the treatment

	var keys_arr = hash.keys();
	for(k=0;k<=keys_arr.length;k++){
		deleted_success = 'N';
		
		if(hash.get(keys_arr[k])!=null){
			if(hash.get(keys_arr[k])[4]=="N"){
				// To retrieve all recorded Diag_codes
				var record_count = "";
				var cond_chart_num = hash.get(keys_arr[k])[5];
				var cond_chart_line_num = hash.get(keys_arr[k])[6];
				var tooth_range_count_for_order = 0;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "patient_id="+patient_id+"&trmt_chart_num="+trmt_chart_num+"&trmt_chart_line_num="+trmt_chart_line_num+"&term_set_id="+term_set_id+"&term_code="+term_code+"&cond_chart_num="+cond_chart_num+"&cond_chart_line_num="+cond_chart_line_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","RecordLinkCondDiagValidation.jsp?func_mode=checkAndDeleteLinkedConditions&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				if(retVal.length >0){
					delete_flag = retVal;
					if(delete_flag != "0" || parseInt(delete_flag) != 0){
						deleted_success = 'Y';
					}
				}
			}
		}
	}

	if(deleted_success == 'Y'){
		alert(getMessage("RECORD_INSERTED","SM"));
	}

	var keys_arr = hash.keys();
	for(k=0;k<keys_arr.length;k++){
		if(hash.get(keys_arr[k])!=null){
			if(hash.get(keys_arr[k])[4]!="N"){
				// To retrieve all recorded Diag_codes
				var DB_term_code = "";
				var tooth_range_count_for_order = 0;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "trmt_code="+trmt_code+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=populateDiagRecorded&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				if(retVal.length >1){
					var retVal_arr = retVal.split("##");
					DB_term_code = retVal_arr[0];
					if(DB_term_code != term_code){
						// Insert Diagnosis in to the table 
						diag_flag = insertDiagnosisForTrmt(patient_id,trmt_chart_num,trmt_chart_line_num,diag_trmt_code,term_set_id,term_code,occur_srl_no,diag_status,tooth_range_count_for_order,oh_chart_level,other_chart_facility_id);
					}
				}
				else{
					// Insert Diagnosis in to the table 
					diag_flag = insertDiagnosisForTrmt(patient_id,trmt_chart_num,trmt_chart_line_num,diag_trmt_code,term_set_id,term_code,occur_srl_no,diag_status,tooth_range_count_for_order,oh_chart_level,other_chart_facility_id);
				}

				//Link Conditions to Diagnosis
				var hash = new Hashtable(); // Include Hashtable.js in your jsp file before defining this line...
				hash = parent.hidden_frame.hash; //Frames(5) To link Diag to the treatment
				var keys_arr = hash.keys();

				for(k=0;k<keys_arr.length;k++){
					
					if(hash.get(keys_arr[k])!=null){
						if(hash.get(keys_arr[k])[4]=="Y"){
							if(concat_str != ""){
								concat_str = concat_str+"~"+hash.get(keys_arr[k])[0]+"##"+hash.get(keys_arr[k])[1]+"##"+hash.get(keys_arr[k])[2]+"##"+hash.get(keys_arr[k])[3]+"##"+hash.get(keys_arr[k])[5]+"##"+hash.get(keys_arr[k])[6]+"##"+hash.get(keys_arr[k])[7];
							}
							else{
								concat_str = hash.get(keys_arr[k])[0]+"##"+hash.get(keys_arr[k])[1]+"##"+hash.get(keys_arr[k])[2]+"##"+hash.get(keys_arr[k])[3]+"##"+hash.get(keys_arr[k])[5]+"##"+hash.get(keys_arr[k])[6]+"##"+hash.get(keys_arr[k])[7];
							}
						}
					}
				}

				if(concat_str != ""){
					var tooth_range_count_for_order = 0;
					// Insert Linked Conditions in to the table 
					if(concat_str!=null && concat_str!="null" && concat_str!=""){
						var diagcodeselected_arr = concat_str.split("~");
						for(i=0;i<diagcodeselected_arr.length;i++){
							diag_code_desc_arr = diagcodeselected_arr[i].split("##");
							var term_code = diag_code_desc_arr[0] // Diagnosis code
							var term_set_id = diag_code_desc_arr[1] // Term Set Id
							var occur_srl_no = diag_code_desc_arr[2] // Occurance Serial Number
							var diag_status = diag_code_desc_arr[3] // Diagnosis status
							var cond_chart_num = diag_code_desc_arr[4] // Diagnosis status
							var cond_chart_line_num = diag_code_desc_arr[5] // Diagnosis status
							var cond_code = diag_code_desc_arr[6] // Diagnosis status
								link_cond_flag = insertLinkedConditions(patient_id,trmt_chart_num,trmt_chart_line_num,diag_trmt_code,term_set_id,term_code,occur_srl_no,diag_status,tooth_range_count_for_order,cond_chart_num,cond_chart_line_num,cond_code);
						}
					}

					hash.clear();
				}

				//Update Closed Conditions
				var close_cond_hash = new Hashtable(); // Include Hashtable.js in your jsp file before defining this line...
				close_cond_hash = parent.close_hash_frame.hash; //Frames(5) To close condition against the treatment
				var keys_arr = close_cond_hash.keys();

				for(k=0;k<keys_arr.length;k++){
					if(close_cond_hash.get(keys_arr[k])!=null){
						if(close_cond_hash.get(keys_arr[k])[10]=="Y"){
							if(close_cond_concat_str != ""){
								close_cond_concat_str = close_cond_concat_str+"~"+close_cond_hash.get(keys_arr[k])[0]+"##"+close_cond_hash.get(keys_arr[k])[1]+"##"+close_cond_hash.get(keys_arr[k])[2]+"##"+close_cond_hash.get(keys_arr[k])[3]+"##"+close_cond_hash.get(keys_arr[k])[4]+"##"+close_cond_hash.get(keys_arr[k])[5]+"##"+close_cond_hash.get(keys_arr[k])[6]+"##"+close_cond_hash.get(keys_arr[k])[7]+"##"+close_cond_hash.get(keys_arr[k])[8]+"##"+close_cond_hash.get(keys_arr[k])[9];
							}
							else{
								close_cond_concat_str = close_cond_hash.get(keys_arr[k])[0]+"##"+close_cond_hash.get(keys_arr[k])[1]+"##"+close_cond_hash.get(keys_arr[k])[2]+"##"+close_cond_hash.get(keys_arr[k])[3]+"##"+close_cond_hash.get(keys_arr[k])[4]+"##"+close_cond_hash.get(keys_arr[k])[5]+"##"+close_cond_hash.get(keys_arr[k])[6]+"##"+close_cond_hash.get(keys_arr[k])[7]+"##"+close_cond_hash.get(keys_arr[k])[8]+"##"+close_cond_hash.get(keys_arr[k])[9];
							}
						}
					}
				}

				if(close_cond_concat_str != ""){
					var tooth_range_count_for_order = 0;
					// Close Condition
					if(close_cond_concat_str!=null && close_cond_concat_str!="null" && close_cond_concat_str!=""){
						var condselected_arr = close_cond_concat_str.split("~");
						for(i=0;i<condselected_arr.length;i++){
							cond_code_desc_arr = condselected_arr[i].split("##");

							var term_code = cond_code_desc_arr[0] // Diagnosis code
							var term_set_id = cond_code_desc_arr[1] // Term Set Id
							var occur_srl_no = cond_code_desc_arr[2] // Occurance Serial Number
							var diag_status = cond_code_desc_arr[3] // Diagnosis status
							var trmt_code = cond_code_desc_arr[4] // Diagnosis status
							var trmt_chart_num = cond_code_desc_arr[5] // Diagnosis status
							var trmt_chart_line_num = cond_code_desc_arr[6] // Diagnosis status
							var cond_chart_num = cond_code_desc_arr[7] // Diagnosis status
							var cond_chart_line_num = cond_code_desc_arr[8] // Diagnosis status
							var cond_code = cond_code_desc_arr[9] // Diagnosis status
							
								close_cond_flag = closeConditionAgainstTrmt(patient_id,term_code,term_set_id,occur_srl_no,diag_status,trmt_code,trmt_chart_num,trmt_chart_line_num,cond_chart_num,cond_chart_line_num,cond_code,tooth_range_count_for_order,other_chart_facility_id,oh_chart_level);
						}
					}
					close_cond_hash.clear();
					
				}
				if(diag_flag != 0 || link_cond_flag != 0 || close_cond_flag != 0){
					alert(getMessage("RECORD_INSERTED","SM"));
				}
			}
		}
	}

	
	var params = document.forms[0].params.value;
	parent.parent.RecordDiagForTrmtFrames.document.location.href="../../eOH/jsp/RecordDiagForTrmtFrames.jsp?"+params;
	
}

function insertDiagnosisForTrmt(patient_id,trmt_chart_num,trmt_chart_line_num,diag_trmt_code,term_set_id,term_code,occur_srl_no,diag_status,tooth_range_count_for_order,oh_chart_level,other_chart_facility_id){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+trmt_chart_num+"&chart_line_num="+trmt_chart_line_num+"&trmt_code="+diag_trmt_code+"&term_set_id="+term_set_id+"&term_code="+term_code+"&occur_srl_no="+occur_srl_no+"&diag_status="+diag_status+"&tooth_range_count_for_order="+tooth_range_count_for_order;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST","../../eOH/jsp/DentalTrmtCommonValidation.jsp?func_mode=insertDiagnosis&"+params,false);
	xmlHttp.send(xmlDoc);
	//xmlHttp.responseText;
	var retVal = trimString(xmlHttp.responseText);

	return retVal;
}

function insertLinkedConditions(patient_id,trmt_chart_num,trmt_chart_line_num,diag_trmt_code,term_set_id,term_code,occur_srl_no,diag_status,tooth_range_count_for_order,cond_chart_num,cond_chart_line_num,cond_code){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+trmt_chart_num+"&chart_line_num="+trmt_chart_line_num+"&trmt_code="+diag_trmt_code+"&term_set_id="+term_set_id+"&term_code="+term_code+"&occur_srl_no="+occur_srl_no+"&diag_status="+diag_status+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&cond_chart_num="+cond_chart_num+"&cond_chart_line_num="+cond_chart_line_num+"&cond_code="+cond_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST","../../eOH/jsp/RecordLinkCondDiagValidation.jsp?func_mode=insertLinkedConditions&"+params,false);
	xmlHttp.send(xmlDoc);
	//xmlHttp.responseText;
	var retVal = trimString(xmlHttp.responseText);

	return retVal;
}

/*
function validateCheckBox(obj){
	var formObj = document.forms[0];
	formObj.modified_flag.value="false";
	if(obj.checked==true){
		obj.select_yn="Y";
	}else{
		obj.select_yn="N";
	}
	var arrObj = document.forms[0].elements;
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="checkbox"){
	    	if(arrObj[i].value==arrObj[i].select_yn){
				arrObj[i].db_change="N";
				continue;
			}else{
				formObj.modified_flag.value="true";
				arrObj[i].db_change="Y";
			}
		}
	}
 }
*/


function validateCheckBox(obj,close_disabled,row_count,mode){
	var record= new Array();
	var frmObj = parent.parent.hidden_frame; //Hashtable Frame
	var formObj = document.forms[0];
	var DiagFrameObj = parent.parent.RecordDiagDetail.document.forms[0];
	if(mode == "modify"){
		var term_code = formObj.term_code.value;
		var term_set_id = formObj.term_set_id.value;
		var occur_srl_no = formObj.occur_srl_no.value;
		var diag_status = formObj.diag_status.value;
	}
	else{
		var diag_select=DiagFrameObj.diag_select.value;
		var diag_select_arr = diag_select.split("##");
		var term_code = diag_select_arr[0]
		var term_set_id=diag_select_arr[3]
		var occur_srl_no=diag_select_arr[4]
		var diag_status=diag_select_arr[5]
	}

	var cond_chart_num = obj.cond_chart_num;
	var cond_chart_line_num = obj.cond_chart_line_num;
	var cond_code = obj.cond_code;

	var hash = new Hashtable(); // Include Hashtable.js in your jsp file before defining this line...
	hash = frmObj.hash;
    var indx = obj.name.replace("chk_select" , "");
	if(obj.checked==true ){
			record[0]=term_code;
			record[1]=term_set_id;
			record[2]=occur_srl_no;
			record[3]=diag_status;
			record[4]="Y";
			record[5]=cond_chart_num;
			record[6]=cond_chart_line_num;
			record[7]=cond_code;
			
	}else{
			record[0]=term_code;
			record[1]=term_set_id;
			record[2]=occur_srl_no;
			record[3]=diag_status;
			record[4]="N";
			record[5]=cond_chart_num;
			record[6]=cond_chart_line_num;
			record[7]=cond_code;
	}
	if(hash.get(indx)!=null){
		hash.remove(indx);	
	}else{
		hash.put(indx,record);	
	}

	if(close_disabled != "disabled" && obj.checked==true){
		eval("formObj.close_cond"+row_count).disabled = false;
	}
	else{
		eval("formObj.close_cond"+row_count).checked = false;
		eval("formObj.close_cond"+row_count).disabled = true;
		
	}
}

function validateDeleteCheckBox(obj){
	var record= new Array();
	var frmObj = window.parent.hidden_frame;
	var formObj = document.forms[0];
	var diag_code=obj.diag_code;
	var term_set_id=obj.term_set_id;
	var trmt_code=obj.trmt_code;
	var diag_chart_line_num=obj.diag_chart_line_num;
	
	var hash = new Hashtable(); // Include Hashtable.js in your jsp file before defining this line...
	
	hash = frmObj.hash;
    var indx = obj.name.replace("chk_select" , "");
	
	if(obj.checked==true ){
			record[0]=diag_code;
			record[1]=trmt_code;
			record[2]=diag_chart_line_num;
			record[3]="Y";
			record[4]=term_set_id;
			
	}else{
			record[0]=diag_code;
			record[1]=trmt_code;
			record[2]=diag_chart_line_num;
			record[3]="N";
			record[4]=term_set_id;
	}
	if(hash.get(indx)!=null){
		hash.remove(indx);	
	}else{
		hash.put(indx,record);	
	}
	
}

function validateCloseCondCheckBox(obj,mode){
	var record= new Array();
	var frmObj = parent.parent.close_hash_frame; //Hashtable Frame
	var formObj = document.forms[0];
	var trmt_code = formObj.trmt_code.value;
	var trmt_chart_num = formObj.trmt_chart_num.value;
	var trmt_chart_line_num = formObj.trmt_chart_line_num.value;

	var DiagFrameObj = parent.parent.RecordDiagDetail.document.forms[0];
	if(mode == "modify"){
		var term_code = formObj.term_code.value;
		var term_set_id = formObj.term_set_id.value;
		var occur_srl_no = formObj.occur_srl_no.value;
		var diag_status = formObj.diag_status.value;
	}
	else{
		var diag_select=DiagFrameObj.diag_select.value;
		var diag_select_arr = diag_select.split("##");
		var term_code = diag_select_arr[0]
		var term_set_id=diag_select_arr[3]
		var occur_srl_no=diag_select_arr[4]
		var diag_status=diag_select_arr[5]
	}

	var cond_chart_num = obj.cond_chart_num;
	var cond_chart_line_num = obj.cond_chart_line_num;
	var cond_code = obj.cond_code;
	
	var hash = new Hashtable(); // Include Hashtable.js in your jsp file before defining this line...
	hash = frmObj.hash;
    var indx = obj.name.replace("close_cond" , "");
	if(obj.checked==true ){
			record[0]=term_code;
			record[1]=term_set_id;
			record[2]=occur_srl_no;
			record[3]=diag_status;
			record[4]=trmt_code;
			record[5]=trmt_chart_num;
			record[6]=trmt_chart_line_num;
			record[7]=cond_chart_num;
			record[8]=cond_chart_line_num;
			record[9]=cond_code;
			record[10]="Y";
			
	}else{
			record[0]=term_code;
			record[1]=term_set_id;
			record[2]=occur_srl_no;
			record[3]=diag_status;
			record[4]=trmt_code;
			record[5]=trmt_chart_num;
			record[6]=trmt_chart_line_num;
			record[7]=cond_chart_num;
			record[8]=cond_chart_line_num;
			record[9]=cond_code;
			record[10]="N";
	}
	if(hash.get(indx)!=null){
		hash.remove(indx);	
	}else{
		hash.put(indx,record);	
	}
}

 function previous(){
	//var frm=window.parent.frames[0].document.forms[0];
	var formObj = document.forms[0];

	var patient_id = formObj.patient_id.value;
	var encounter_id = formObj.encounter_id.value;
	var chart_num = formObj.chart_num.value;
	var trmt_code = formObj.trmt_code.value;
	var practitioner_id = formObj.practitioner_id.value;
	
	var start = formObj.start.value;
	formObj.start.value=start-7;
	var end = formObj.end.value;
	formObj.end.value=end-7;
	start = formObj.start.value;
	end = formObj.end.value;
 
	var hash = new Hashtable(); // Include Hashtable.js in your jsp file before defining this line...
	hash = window.parent.hidden_frame.hash;
	var keys = hash.keys();
	parent.RecordDiagDetail.location.href='../../eOH/jsp/RecordDiagForTrmt.jsp?from='+start+'&to='+end+'&patient_id='+patient_id+"&chart_num="+chart_num+"&encounter_id="+encounter_id+"&trmt_code="+trmt_code+"&practitioner_id="+practitioner_id+"&totalselected="+keys;

	//parent.frames[3].location.href='../../eOH/jsp/RecordDiagForTrmtTitle.jsp?from='+start+'&to='+end+'&patient_id='+patient_id+"&chart_num="+chart_num+"&encounter_id="+encounter_id+"&trmt_code="+trmt_code+"&practitioner_id="+practitioner_id+"&totalselected="+keys;
	
}


function next(){
	//var frm=window.parent.frames[0].document.forms[0];    //.frames[0].document.forms[0];
	var formObj = document.forms[0];

	var patient_id = formObj.patient_id.value;
	var encounter_id = formObj.encounter_id.value;
	var chart_num = formObj.chart_num.value;
	var trmt_code = formObj.trmt_code.value;
	var practitioner_id = formObj.practitioner_id.value;
	
	
	var start = formObj.start.value;
	formObj.start.value=parseInt(start)+7;
	start = formObj.start.value;
	var end = formObj.end.value;
	formObj.end.value=parseInt(end)+7;
	end = formObj.end.value;

	var hash = new Hashtable(); // Include Hashtable.js in your jsp file before defining this line...
	hash = window.parent.hidden_frame.hash;
	var keys = hash.keys();
	//parent.frames[3].location.href='../../eOH/jsp/RecordDiagForTrmtTitle.jsp?from='+start+'&to='+end+'&patient_id='+patient_id+"&chart_num="+chart_num+"&encounter_id="+encounter_id+"&trmt_code="+trmt_code+"&practitioner_id="+practitioner_id+"&totalselected="+keys;
	parent.RecordDiagDetail.location.href='../../eOH/jsp/RecordDiagForTrmt.jsp?from='+start+'&to='+end+'&patient_id='+patient_id+"&chart_num="+chart_num+"&encounter_id="+encounter_id+"&trmt_code="+trmt_code+"&practitioner_id="+practitioner_id+"&totalselected="+keys;
	
}

 function assingListItemValue(key){
	var formObj = document.forms[0];
	var hash = new Hashtable(); // Include Hashtable.js in your jsp file before defining this line...
	hash = parent.hidden_frame.hash;
	if(hash.get(key)!=null){
		if(hash.get(key)[4]=="Y")
			eval("formObj.chk_select"+key).checked=true;
		else
			eval("formObj.chk_select"+key).checked=false;
	}
}

function assignDeleteListValue(key){
	var formObj = document.forms[0];
	var hash = new Hashtable(); // Include Hashtable.js in your jsp file before defining this line...
	hash = parent.hidden_frame.hash;
	if(hash.get(key)!=null){
		if(hash.get(key)[3]=="Y")
			eval("formObj.chk_select"+key).checked=true;
		else
			eval("formObj.chk_select"+key).checked=false;
	}
}

function showRecords(count){
	var formObj = document.forms[0];

	var patient_id = formObj.patient_id.value;
	var encounter_id = formObj.encounter_id.value;
	var chart_num = formObj.chart_num.value;
	var ind_chart_line_num = formObj.ind_chart_line_num.value;//Indivisual chart_line_num of a tooth in case of Tooth Range
	var trmt_code = formObj.trmt_code.value;
	var practitioner_id = formObj.practitioner_id.value;
	var tooth_no = formObj.tooth_no.value;
	var tooth_count = formObj.tooth_count.value;

	var start = count;
	var end = count+6;

	var hash = new Hashtable(); // Include Hashtable.js in your jsp file before defining this line...
	hash = window.parent.hidden_frame.hash;
	var keys = hash.keys();
	//document.location.href='../../eOH/jsp/RecordDiagForTrmtHeader.jsp?from='+start+'&to='+end+'&patient_id='+patient_id+"&chart_num="+chart_num+"&encounter_id="+encounter_id+"&trmt_code="+trmt_code+"&practitioner_id="+practitioner_id;
	parent.RecordDiagHeader.location.href='../../eOH/jsp/RecordDiagForTrmtHeader.jsp?from='+start+'&to='+end+'&patient_id='+patient_id+"&chart_num="+chart_num+"&encounter_id="+encounter_id+"&trmt_code="+trmt_code+"&practitioner_id="+practitioner_id+"&ind_chart_line_num="+ind_chart_line_num+"&tooth_no="+tooth_no+"&tooth_count="+tooth_count+"&totalSelected="+keys;
}

function deleteOptions(){
	var delete_flag = 0;
	var formObj = document.forms[0];
	var params = formObj.params.value;
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var ind_chart_line_num = formObj.ind_chart_line_num.value;
	var tooth_no = formObj.tooth_no.value;
	var tooth_count = formObj.tooth_count.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var concat_str = "";
	var hash = new Hashtable(); // Include Hashtable.js in your jsp file before defining this line...
	hash = parent.hidden_frame.hash;
	var keys_arr = hash.keys();
	if(hash == ""){
		alert(getMessage("APP-OH00081","OH"));
	}
	else{
		for(k=0;k<keys_arr.length;k++){
			if(hash.get(keys_arr[k])!=null){
				if(hash.get(keys_arr[k])[3]=="Y"){
					
					var term_code = hash.get(keys_arr[k])[0];
					var term_set_id = hash.get(keys_arr[k])[4];
					var trmt_code = hash.get(keys_arr[k])[1];

					// check for linked conditions
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&trmt_chart_num="+chart_num+"&trmt_chart_line_num="+chart_line_num+"&term_set_id="+term_set_id+"&term_code="+term_code+"&trmt_code="+trmt_code+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","RecordLinkCondDiagValidation.jsp?func_mode=checkLinkedConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					if(retVal.length >0){
						delete_flag = retVal;
						if(delete_flag != "0" || parseInt(delete_flag) != 0){
							alert(getMessage("APP-OH00080","OH"));
							
						}
					}

					if(delete_flag == 0 || parseInt(delete_flag) == 0){
						// To delete the selected record
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+hash.get(keys_arr[k])[2]+"&diag_code="+hash.get(keys_arr[k])[0]+"&trmt_code="+hash.get(keys_arr[k])[1]+"&tooth_count="+tooth_count+"&tooth_no="+tooth_no+"&ind_chart_line_num="+ind_chart_line_num+"&term_set_id="+hash.get(keys_arr[k])[4]+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=deleteDiagRecorded&"+params,false);
						xmlHttp.send(xmlDoc);
					}
				}
			}
		}
		hash.clear();
		if(delete_flag == 0 || parseInt(delete_flag) == 0){
			params = formObj.params.value;
			parent.parent.RecordDiagForTrmtFrames.location.href = '../../eOH/jsp/RecordDiagForTrmtMainFrames.jsp?'+params;	
		}
	}
	

}

function showDiagDetails(obj){//on selection of list item
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var trmt_code = formObj.trmt_code.value;
	var site_type = formObj.site_type.value;
	var area_param = formObj.area_param.value;
	var thrng_nos_ref = formObj.thrng_nos_ref.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var baseline_chart_yn = formObj.baseline_chart_yn.value;//Added by Sridevi Joshi on 5/31/2010 for IN021668		
	var date_diff_flag = formObj.date_diff_flag.value;//Added by Sridevi Joshi on 5/31/2010 for IN021668		
	var term_code_desc = "";
	var term_code = "";
	var accuracy = "";
	var onsetdate = "";

	var diag_code_label = getLabel("Common.DiagnosisCode.label","Common");
	var diag_desc_label = getLabel("Common.DiagnosisDescription.label","Common");
	var accuracy_label = getLabel("Common.Accuracy.label","Common");
	var onsetdate_label = getLabel("Common.onsetdate.label","Common");
	
	if(obj.value != ""){
		obj_arr = obj.value.split("##");
		term_code = obj_arr[0];
		accuracy = obj_arr[1];
		onsetdate = obj_arr[2];
		term_set_id = obj_arr[3];
		occur_srl_no = obj_arr[4];
		diag_status = obj_arr[5];

		term_code_desc = obj.options[obj.options.selectedIndex].text;
	}
	
	document.getElementById("diag_details").innerHTML = "<table align='center' cellpadding='3' cellspacing='0' border='0' width='100%'><tr><td class='label' width='25%'>"+diag_code_label+"</td><td class='label' width='25%'>"+term_code+"</td><td class='label' width='25%'>"+diag_desc_label+"</td><td class='label' width='25%'>"+term_code_desc+"</td></tr><tr><td class='label' width='20%'>"+accuracy_label+"</td><td class='label' width='20%'>"+accuracy+"</td><td class='label' width='20%'>"+onsetdate_label+"</td><td class='label' width='20%'>"+onsetdate+"</td></tr></table>";

	var params = "term_code="+term_code+"&term_code_desc="+term_code_desc+"&accuracy="+accuracy+"&onsetdate="+onsetdate+"&patient_id="+patient_id+"&tooth_numbering_system="+tooth_numbering_system+"&chart_num="+chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&site_type="+site_type+"&trmt_code="+trmt_code+"&chart_line_num="+chart_line_num+"&term_set_id="+term_set_id+"&occur_srl_no="+occur_srl_no+"&diag_status="+diag_status+"&area_param="+area_param+"&thrng_nos_ref="+thrng_nos_ref+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&baseline_chart_yn="+baseline_chart_yn+"&date_diff_flag="+date_diff_flag;
	
	parent.RecordDiagLinkedCondition.document.location.href = "../../eOH/jsp/RecordDiagLinkedConditionFrame.jsp?"+params;
	
}

function closeConditionAgainstTrmt(patient_id,term_code,term_set_id,occur_srl_no,diag_status,trmt_code,trmt_chart_num,trmt_chart_line_num,cond_chart_num,cond_chart_line_num,cond_code,tooth_range_count_for_order,other_chart_facility_id,oh_chart_level){
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&trmt_chart_num="+trmt_chart_num+"&trmt_chart_line_num="+trmt_chart_line_num+"&trmt_code="+trmt_code+"&term_set_id="+term_set_id+"&term_code="+term_code+"&occur_srl_no="+occur_srl_no+"&diag_status="+diag_status+"&tooth_range_count_for_order="+tooth_range_count_for_order+"&cond_chart_num="+cond_chart_num+"&cond_chart_line_num="+cond_chart_line_num+"&cond_code="+cond_code+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST","../../eOH/jsp/RecordLinkCondDiagValidation.jsp?func_mode=closeConditionAgainstTrmt&"+params,false);
	xmlHttp.send(xmlDoc);
	//xmlHttp.responseText;
	var retVal = trimString(xmlHttp.responseText);

	return retVal;
}

function showDiagAndLinkedCond(term_code,accuracy,onset_date,term_code_desc,term_set_id,occur_srl_no){
	var formObj = document.forms[0];
	var params = formObj.params.value;
	var patient_id = formObj.patient_id.value;
	var trmt_chart_num = formObj.chart_num.value;
	var trmt_chart_line_num = formObj.chart_line_num.value;
	var trmt_code = formObj.trmt_code.value;
/*
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&trmt_chart_num="+trmt_chart_num+"&trmt_chart_line_num="+trmt_chart_line_num+"&trmt_code="+trmt_code+"&term_set_id="+term_set_id+"&term_code="+term_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST","../../eOH/jsp/RecordLinkCondDiagValidation.jsp?func_mode=populateLinkedConditions&"+params,false);
	xmlHttp.send(xmlDoc);
	//xmlHttp.responseText;
	var retVal = trimString(xmlHttp.responseText);
	*/

	params = params+"&term_code="+term_code+"&mode=modify&accuracy="+accuracy+"&onset_date="+onset_date+"&term_code_desc="+term_code_desc+"&term_set_id="+term_set_id+"&occur_srl_no="+occur_srl_no;
	parent.RecordDiagDetail.document.location.href = "../../eOH/jsp/RecordDiagForTrmt.jsp?"+params;
	parent.RecordDiagLinkedCondition.document.location.href = "../../eOH/jsp/RecordDiagLinkedConditionFrame.jsp?"+params;

}

function assignDBValue(term_code,accuracy,onset_date,term_code_desc,mode){
	if(mode == "modify"){
	var formObj = document.forms[0];
	//var term_code = formObj.term_code.value;
	//var accuracy = formObj.accuracy.value;
	//var onsetdate = formObj.onsetdate.value;
	//var term_code_desc = formObj.term_code_desc.value;

	var diag_code_label = getLabel("Common.DiagnosisCode.label","Common");
	var diag_desc_label = getLabel("Common.DiagnosisDescription.label","Common");
	var accuracy_label = getLabel("Common.Accuracy.label","Common");
	var onsetdate_label = getLabel("Common.onsetdate.label","Common");
	
	//document.getElementById("diagnosis_options").innerHTML = "";

	document.getElementById("diag_details").innerHTML = "<table align='center' cellpadding='3' cellspacing='0' border='0' width='100%'><tr><td class='label' width='25%'>"+diag_code_label+"</td><td class='label' width='25%'>"+term_code+"</td><td class='label' width='25%'>"+diag_desc_label+"</td><td class='label' width='25%'>"+term_code_desc+"</td></tr><tr><td class='label' width='20%'>"+accuracy_label+"</td><td class='label' width='20%'>"+accuracy+"</td><td class='label' width='20%'>"+onsetdate_label+"</td><td class='label' width='20%'>"+onset_date+"</td></tr></table>";

	}
	
}

function clearOptions(){
	var params = document.forms[0].params.value;

	parent.parent.RecordDiagForTrmtFrames.document.location.href="../../eOH/jsp/RecordDiagForTrmtFrames.jsp?"+params;
}


async function showLinkedDiagDetails(url){
	var dialogHeight= "35vh" ;
	var dialogWidth	= "55vw" ;
	var dialogTop ="170";
	var dialogLeft ="15";
	
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
	var retVal =await window.showModalDialog(url,arguments,features);

}
