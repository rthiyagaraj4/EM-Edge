function testone(){
}
function assignOverrideExclInclInd(obj, bl_included_IE, drug_index,locale){
	/*if(bl_included_IE=='I' && obj.checked == true){
		obj.value = "E";
	}
	else if(bl_included_IE=='E' && obj.checked == true){
		obj.value = "I";
	}
	else obj.value ="";*/
	if(obj.value !='SEL'  ){
		if(eval("document.chargeDetailForm.bl_override_reason_desc_"+drug_index).value=='' ){
				document.getElementById("bl_overriden_action_reason_img_"+drug_index).style.visibility='visible';
				eval("document.chargeDetailForm.bl_overriden_reason_lkp_"+drug_index).disabled=false;
				var formObj=document.chargeDetailForm;
				var argumentArray  = new Array();
				var dataNameArray  = new Array();
				var dataValueArray = new Array();
				var dataTypeArray  = new Array();
			//	var sql1 = "select  action_reason_code code,action_reason_desc description from bl_action_reason_lang a where nvl(status,'!') != 'S'  and exists (select b.action_type from bl_action_type b, bl_action_reason_by_type c where b.action_type = c.action_type and b.action_type = 'OV' and c.action_reason_code = a.action_reason_code and c.active_yn = 'Y') and upper(a.language_id) like Upper(?) AND Upper(a.action_reason_code) LIKE Upper(?) AND Upper(a.action_reason_desc) LIKE Upper(?) "
				var sql1 = formObj.sql_ph_prescription_bl_action_select_lookup.value;

				dataNameArray[0]	="a.language_id";
				dataValueArray[0]	=locale;
				dataTypeArray[0]	=STRING;

				argumentArray[0]	= sql1;
				argumentArray[1]    = dataNameArray ;
				argumentArray[2]    = dataValueArray ;
				argumentArray[3]    = dataTypeArray ;
				argumentArray[4]    = "2,3";
				argumentArray[5]    = eval("formObj.bl_override_reason_desc_"+drug_index).value;
				argumentArray[6]    = CODE_LINK ;
				argumentArray[7]    = CODE_DESC ;

				retVal = CommonLookup(getLabel("Common.search.label","Common"), argumentArray);
				if(retVal != null && retVal != "") {
					eval("formObj.bl_override_reason_code_"+drug_index).value = retVal[0];
					eval("formObj.bl_override_reason_desc_"+drug_index).value=retVal[1] ;
				}
		}
	}
	else{
		document.getElementById("bl_overriden_action_reason_img_"+drug_index).style.visibility='hidden';
		eval("document.chargeDetailForm.bl_overriden_reason_lkp_"+drug_index).disabled=true;
		eval("document.chargeDetailForm.bl_override_reason_code_"+drug_index).value = "";
		eval("document.chargeDetailForm.bl_override_reason_desc_"+drug_index).value = "" ;
	}
	getChargeDetails(drug_index);
}

function searchBLOverrideReason(locale, drug_index){
	var formObj=document.chargeDetailForm;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
//	var sql1 = "select  action_reason_code code,action_reason_desc description from bl_action_reason_lang a where nvl(status,'!') != 'S'  and exists (select b.action_type from bl_action_type b, bl_action_reason_by_type c where b.action_type = c.action_type and b.action_type = 'OV' and c.action_reason_code = a.action_reason_code and c.active_yn = 'Y') and upper(a.language_id) like Upper(?) AND Upper(a.action_reason_code) LIKE Upper(?) AND Upper(a.action_reason_desc) LIKE Upper(?) "
	var sql1 = formObj.sql_ph_prescription_bl_action_select_lookup.value;

	dataNameArray[0]	="a.language_id";
	dataValueArray[0]	=locale;
	dataTypeArray[0]	=STRING;

	argumentArray[0]	= sql1;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = eval("formObj.bl_override_reason_desc_"+drug_index).value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal = CommonLookup(getLabel("Common.search.label","Common"), argumentArray);
	if(retVal != null && retVal != "") {
		eval("formObj.bl_override_reason_code_"+drug_index).value = retVal[0];
		eval("formObj.bl_override_reason_desc_"+drug_index).value=retVal[1] ;
	}
	getChargeDetails(drug_index);
}

function getChargeDetails(drug_index){
	var formObj = document.chargeDetailForm;
	var bean_id = formObj.bean_id.value;
	var bean_name = formObj.bean_name.value
	var patient_id = formObj.patient_id.value
	var take_home_medication = formObj.take_home_medication.value
	var encounter_id = formObj.encounter_id.value
	var episode_type = formObj.episode_type.value
	var rx_order_type = formObj.rx_order_type.value
	var iv_prep_yn = formObj.iv_prep_yn.value

	var drug_code					  = eval("formObj.drug_code_"+drug_index).value;
	var fluid_yn					  = eval("formObj.fluid_yn_"+drug_index).value;
	//var bl_overide_yn		          = eval("formObj.bl_overide_yn_"+drug_index).value;

	var bl_overide_yn		          = eval("formObj.bl_overide_yn_"+drug_index).options[eval("formObj.bl_overide_yn_"+drug_index).selectedIndex].value;

	var bl_override_reason_code		  = eval("formObj.bl_override_reason_code_"+drug_index).value;
	var bl_override_reason_desc		  = encodeURIComponent(eval("formObj.bl_override_reason_desc_"+drug_index).value);

	var ocurrance_num = "";
	if(((eval("formObj.ocurrance_num_"+drug_index))!=undefined )&& ((eval("formObj.ocurrance_num_"+drug_index))!=null)){
	
	    ocurrance_num =eval("formObj.ocurrance_num_"+drug_index).value;
	
	}


	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	var temp_jsp="ChargeDetailsValidate.jsp?validate=getChargeDetails"+"&bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&rx_order_type="+rx_order_type+"&drug_code="+drug_code+"&fluid_yn="+fluid_yn+"&bl_incl_excl_override_value="+bl_overide_yn+"&bl_override_reason_code="+bl_override_reason_code+"&bl_override_reason_desc="+bl_override_reason_desc+"&drug_index="+drug_index+"&iv_prep_yn="+iv_prep_yn+"&ocurrance_num="+ocurrance_num+"&take_home_medication="+take_home_medication;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function assignChargeDetails(bl_charge_amt, bl_patient_payable, bl_included_IE, bl_apprvl_reqd_yn, bl_override_allowed_yn, bl_error_code, bl_sys_message_id, bl_error_text,drug_index,bl_decimal_format_string){

	var formObj = document.chargeDetailForm;
	var bean_id = formObj.bean_id.value;
	var bean_name = formObj.bean_name.value
	var bl_included_IE_gif = "&nbsp;";

	if(bl_included_IE=="I")
		bl_included_IE_gif ="<img src='../../eCommon/images/enabled.gif'></img>";
	else if(bl_included_IE=="E")
		bl_included_IE_gif = "<img src='../../eCommon/images/disabled.gif'></img>";

	eval("formObj.bl_included_IE_gif_"+drug_index).innerHTML = bl_included_IE_gif;
	
	
	//if(bl_override_allowed_yn == 'Y')
	if(bl_override_allowed_yn != '')
		eval("formObj.bl_overide_yn_"+drug_index).disabled=false;
	else{
		eval("formObj.bl_overide_yn_"+drug_index).disabled=true;
		//eval("formObj.bl_overide_yn_"+drug_index).checked=false;
	}
	var bl_old_charge_amt = eval("formObj.bl_charge_amt_"+drug_index).innerText;
	var bl_old_patient_payable = eval("formObj.bl_patient_payable_"+drug_index).innerText;
	var bl_old_tot_charge_amt = formObj.bl_tot_charge_amt.innerText;
	var bl_old_tot_patient_payable = formObj.bl_tot_patient_payable.innerText;

	var bl_tot_charge_amt =bl_old_tot_charge_amt;
	var bl_tot_patient_payable = bl_old_tot_patient_payable;
	if (bl_error_code == "10" || bl_error_text !="" || bl_sys_message_id!=""){
		bl_charge_amt = getLabel("Common.Error.label","Common");
		bl_patient_payable = getLabel("Common.Error.label","Common");
		if(!isNaN(parseFloat(bl_old_charge_amt))){
			bl_tot_charge_amt = parseFloat(bl_old_tot_charge_amt) - parseFloat(bl_old_charge_amt);
			bl_tot_patient_payable = parseFloat(bl_old_tot_patient_payable) - parseFloat(bl_old_patient_payable);
		}
	}
	else{
		if(!isNaN(parseFloat(bl_old_charge_amt))){
			bl_tot_charge_amt = parseFloat(bl_old_tot_charge_amt) - parseFloat(bl_old_charge_amt);
			bl_tot_patient_payable = parseFloat(bl_old_tot_patient_payable) - parseFloat(bl_old_patient_payable);
		}
		bl_tot_charge_amt = parseFloat(bl_tot_charge_amt) + parseFloat(bl_charge_amt);
		bl_tot_patient_payable = parseFloat(bl_tot_patient_payable) + parseFloat(bl_patient_payable);
	}

	eval("formObj.bl_charge_amt_"+drug_index).innerHTML=bl_charge_amt+"&nbsp&nbsp;";
	eval("formObj.bl_patient_payable_"+drug_index).innerHTML=bl_patient_payable+"&nbsp;&nbsp;";
//	formObj.all.bl_tot_charge_amt.innerHTML=bl_tot_charge_amt+"&nbsp;&nbsp;&nbsp;";
//	formObj.all.bl_tot_patient_payable.innerHTML=bl_tot_patient_payable+"&nbsp;&nbsp;&nbsp;";

	var bl_apprvl_reqd_gif = "&nbsp;";
	if(bl_apprvl_reqd_yn=="Y")
		bl_apprvl_reqd_gif ="<img src='../../eCommon/images/enabled.gif'></img>";
	else if(bl_apprvl_reqd_yn=="N")
		bl_apprvl_reqd_gif = "<img src='../../eCommon/images/disabled.gif'></img>";
	eval("formObj.bl_apprvl_reqd_gif_"+drug_index).innerHTML = bl_apprvl_reqd_gif; //replaced bl_included_IE_gif with bl_apprvl_reqd_gif for IN24925 --24/11/2010-- priya

	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";

	var temp_jsp="ChargeDetailsValidate.jsp?validate=getTotalAmount"+"&bean_id="+bean_id+"&bean_name="+bean_name+"&bl_decimal_format_string="+bl_decimal_format_string+"&bl_tot_charge_amt="+bl_tot_charge_amt+"&bl_tot_patient_payable="+bl_tot_patient_payable;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function assignTotalAmount(bl_tot_charge_amt, bl_tot_patient_payable){
	var formObj = document.chargeDetailForm;
	formObj.bl_tot_charge_amt.innerHTML=bl_tot_charge_amt+"&nbsp;&nbsp;&nbsp;";
	formObj.bl_tot_patient_payable.innerHTML=bl_tot_patient_payable+"&nbsp;&nbsp;&nbsp;";
}

function clearDrugdetails(drug_index){
	var formObj = document.chargeDetailForm;
}

function storeOverrideDetail(){
	var formObj = document.chargeDetailForm;
	var tot_drugs = parseInt(formObj.tot_drugs.value);
	var blErrorDrugs = formObj.blErrorDrugs.value
	for(i=0; i<tot_drugs; i++){
		if(eval("formObj.bl_overide_yn_"+i)!=undefined && eval("formObj.bl_override_reason_code_"+i)!=undefined){
			if(eval("formObj.bl_overide_yn_"+i).checked == true && eval("formObj.bl_override_reason_code_"+i).value==''){
				alert(getMessage('OVERRIDE_REASON_NOT_BLANK','PH'));
				return false;
			}
		}
	}
	//parent.window.returnValue = blErrorDrugs;
	//parent.window.close();
	parent.parent.document.querySelectorAll("#dialog-body")[parent.parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue =blErrorDrugs;
	parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();  
}

function cancelOverrideDetail(){
	var formObj = document.chargeDetailForm;
	var bean_id = formObj.bean_id.value;
	var bean_name = formObj.bean_name.value
	var patient_id = formObj.patient_id.value
	var take_home_medication = formObj.take_home_medication.value
	var encounter_id = formObj.encounter_id.value
	var episode_type = formObj.episode_type.value
	var rx_order_type = formObj.rx_order_type.value
	var iv_prep_yn = formObj.iv_prep_yn.value
	var blErrorDrugs = formObj.blErrorDrugs.value
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	var temp_jsp="ChargeDetailsValidate.jsp?validate=cancelOverrideDetail"+"&bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&rx_order_type="+rx_order_type+"&iv_prep_yn="+iv_prep_yn+"&take_home_medication="+take_home_medication;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
//	parent.window.returnValue = blErrorDrugs;
//	parent.window.close();
	parent.parent.document.querySelectorAll("#dialog-body")[parent.parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = blErrorDrugs;
	parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close(); 
}
