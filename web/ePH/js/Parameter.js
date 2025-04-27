  var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;


function callPrescriptionRules(){

	document.getElementById('prescription_rules').style="display";
	document.getElementById('prescription_rules').style.visibility="visible";
	//document.parameter_detail_form.all.prescription_rules_tab.src='../../ePH/images/PrescriptionRules_click.gif';
	if (document.getElementById('licenceRights').value !="PHBASIC"){

		//document.parameter_detail_form.all.dispense_rules_tab.src='../../ePH/images/DispensingRules.gif';
		//document.parameter_detail_form.all.process_names_tab.src="../../ePH/images/Process Name.gif";
		document.getElementById('dispense_rules').style.display="none";
		document.getElementById('dispense_rules_op_pharm').style.display="none";
		document.getElementById('process_names').style.display="none";
	}
	//document.parameter_detail_form.all.drug_database_interface_tab.src="../../ePH/images/Drug Database Interface.gif";
	document.getElementById('drug_database_interface').style.display="none";
}
function callDispensingRules(source){
	//document.parameter_detail_form.all.prescription_rules_tab.src='../../ePH/images/PrescriptionRules.gif';
	//document.parameter_detail_form.all.dispense_rules_tab.src='../../ePH/images/DispensingRules_click.gif';
	//document.parameter_detail_form.all.process_names_tab.src="../../ePH/images/Process Name.gif";
	//document.parameter_detail_form.all.drug_database_interface_tab.src="../../ePH/images/Drug Database Interface.gif";
	document.getElementById('dispense_rules').style="display";
	document.getElementById('dispense_rules').style.visibility="visible";
	document.getElementById('dispense_rules_op_pharm').style="display";
	document.getElementById('dispense_rules_op_pharm').style.visibility="visible";
	document.getElementById('prescription_rules').style.display="none";
	document.getElementById('drug_database_interface').style.display="none";
	document.getElementById('process_names').style.display="none";
}

function reset(){
f_query_add_mod.document.location.href="../../ePH/jsp/ParameterAddModifyHeader.jsp";
f_query_details.document.location.href="../../ePH/jsp/ParameterAddModifyDetails.jsp";

}

function validateDrugItemRelation(obj){
 if(obj.value=="N"){

		clearRelationList();
		addRelationLIst(obj.value);
		document.parameter_header_form.drug_item_code_relation.disabled=true;
	}
	else if(obj.value=="Y") {
		clearRelationList();
		addRelationLIst(obj.value);
		document.parameter_header_form.drug_item_code_relation.disabled=true;
	}
	else{
		clearRelationList();
		addRelationLIst(obj.value);
		document.parameter_header_form.drug_item_code_relation.disabled=true;

	}
}

function clearRelationList(  ) {
	var len = document.parameter_header_form.drug_item_code_relation.options.length;
	for(var i=0;i<len;i++) {
		 document.parameter_header_form.drug_item_code_relation.remove("drug_item_code_relation");
	}

}

function addRelationLIst(val){
	if(val=="N"){
		var opt = document.createElement("OPTION");
		opt.text = "Not Applicable" ;
		opt.value = "X" ;
		document.parameter_header_form.drug_item_code_relation.add(opt);
		document.parameter_header_form.gen_drug_code.value="";
		document.parameter_header_form.gen_drug_code.disabled=false;
		var len = document.parameter_header_form.drug_item_set_up.options.length;
		for(var i=0;i<len;i++) {
		document.parameter_header_form.drug_item_set_up.remove("drug_item_set_up");
		}
		var opt = document.createElement("OPTION");
		opt.text = "Not Applicable" ;
		opt.value = "X" ;
		document.parameter_header_form.drug_item_set_up.add(opt);
		document.parameter_header_form.drug_item_set_up.disabled=true;
		document.parameter_header_form.drug_item_set_up.value="X";


		var len = document.parameter_header_form.gen_drug_code.options.length;
		for(var i=0;i<len;i++) {
			document.parameter_header_form.gen_drug_code.remove("gen_drug_code");
		}

		var opt0 = document.createElement("OPTION");
		opt0.text = "     ---Select---" ;
		opt0.value = "" ;
		document.parameter_header_form.gen_drug_code.add(opt0);
		var opt = document.createElement("OPTION");
		opt.text = "System Generated Sequence" ;
		opt.value = "G" ;
		document.parameter_header_form.gen_drug_code.add(opt);

		var opt1 = document.createElement("OPTION");
		opt1.text = "User Entrable" ;
		opt1.value = "E" ;
		document.parameter_header_form.gen_drug_code.add(opt1);
		document.parameter_header_form.gen_drug_code.value="";
		document.parameter_header_form.gen_drug_code.disabled=false;

	}
	else if(val=="Y"){

		var opt = document.createElement("OPTION");
		opt.text = "    Same    " ;
		opt.value = "S" ;
		document.parameter_header_form.drug_item_code_relation.add(opt);
		var opt1 = document.createElement("OPTION");
		opt1.text = "   Different  " ;
		opt1.value = "D" ;
		document.parameter_header_form.drug_item_code_relation.add(opt1);

		var opt3 = document.createElement("OPTION");
		opt3.text = "   ---Select---" ;
		opt3.value = "" ;
		document.parameter_header_form.drug_item_code_relation.disabled=true;
		document.parameter_header_form.drug_item_code_relation.add(opt3);
		document.parameter_header_form.drug_item_code_relation.value="";


		var len = document.parameter_header_form.drug_item_set_up.options.length;
		for(var i=0;i<len;i++) {
		document.parameter_header_form.drug_item_set_up.remove("drug_item_set_up");
		}

		var opt3 = document.createElement("OPTION");
		opt3.text = "   ---Select---" ;
		opt3.value = "" ;
		document.parameter_header_form.drug_item_set_up.add(opt3);
		document.parameter_header_form.drug_item_set_up.disabled=false;
		document.parameter_header_form.drug_item_set_up.value="";

		var opt = document.createElement("OPTION");
		opt.text = "One Drug to One Item" ;
		opt.value = "S" ;
		document.parameter_header_form.drug_item_set_up.add(opt);
		document.parameter_header_form.drug_item_set_up.disabled=false;
		document.parameter_header_form.drug_item_set_up.value="S";

		var opt1 = document.createElement("OPTION");
		opt1.text = "One Drug to Many Item" ;
		opt1.value = "D" ;
		document.parameter_header_form.drug_item_set_up.add(opt1);
		document.parameter_header_form.drug_item_set_up.disabled=false;
		document.parameter_header_form.drug_item_set_up.value="D";
		document.parameter_header_form.drug_item_set_up.options[0].selected=true;
		}
		else{
		var opt = document.createElement("OPTION");
		opt.text = "   ---- Select ----" ;
		opt.value = "" ;
		document.parameter_header_form.drug_item_code_relation.disabled=true;
		document.parameter_header_form.drug_item_code_relation.add(opt);

		var len = document.parameter_header_form.gen_drug_code.options.length;
		for(var i=0;i<len;i++) {
			document.parameter_header_form.gen_drug_code.remove("gen_drug_code");
		}

		var opt0 = document.createElement("OPTION");
		opt0.text = "    ---Select---" ;
		opt0.value = "" ;
		document.parameter_header_form.gen_drug_code.add(opt0);
		var opt = document.createElement("OPTION");
		opt.text = "System Generated Sequence" ;
		opt.value = "G" ;
		document.parameter_header_form.gen_drug_code.add(opt);

		var opt1 = document.createElement("OPTION");
		opt1.text = "User Entrable" ;
		opt1.value = "E" ;
		document.parameter_header_form.gen_drug_code.add(opt1);
		document.parameter_header_form.gen_drug_code.value="";

		var len = document.parameter_header_form.drug_item_set_up.options.length;
		for(var i=0;i<len;i++) {
		document.parameter_header_form.drug_item_set_up.remove("drug_item_set_up");
		}
		var opt1 = document.createElement("OPTION");
		opt1.text = "   --- Select ---" ;
		opt1.value = "" ;
		document.parameter_header_form.drug_item_set_up.add(opt1);

		var opt = document.createElement("OPTION");
		opt.text = "Not Applicable" ;
		opt.value = "X" ;
		document.parameter_header_form.drug_item_set_up.add(opt);
		document.parameter_header_form.drug_item_set_up.disabled=true;
		document.parameter_header_form.drug_item_set_up.value="";
	}

}

function validateDrugItemSetUp(obj){
var dc_realation=document.parameter_header_form.drug_item_code_relation.value;
var dc_link=obj.value;

	if(dc_realation=="S"){
		if(document.parameter_header_form.st_install_yn.value=='Y'){
		var len = document.parameter_header_form.drug_item_set_up.options.length;
		for(var i=0;i<len;i++) {
		document.parameter_header_form.drug_item_set_up.remove("drug_item_set_up");
		}
		var opt = document.createElement("OPTION");
		opt.text = "One Drug to One Item" ;
		opt.value = "S" ;
		document.parameter_header_form.drug_item_set_up.add(opt);
		}
		document.parameter_header_form.drug_item_set_up.disabled=true;
		document.parameter_header_form.drug_item_set_up.value="S";

		var len = document.parameter_header_form.gen_drug_code.options.length;
		for(var i=0;i<len;i++) {
			document.parameter_header_form.gen_drug_code.remove("gen_drug_code");
		}

		var opt0 = document.createElement("OPTION");
		opt0.text = "    ---Select---" ;
		opt0.value = "" ;
		document.parameter_header_form.gen_drug_code.add(opt0);

		var opt01 = document.createElement("OPTION");
		opt01.text = "Not Applicable" ;
		opt01.value = "X" ;
		document.parameter_header_form.gen_drug_code.add(opt01);


		var opt = document.createElement("OPTION");
		opt.text = "System Generated Sequence" ;
		opt.value = "G" ;
		document.parameter_header_form.gen_drug_code.add(opt);

		var opt1 = document.createElement("OPTION");
		opt1.text = "User Entrable" ;
		opt1.value = "E" ;
		document.parameter_header_form.gen_drug_code.add(opt1);
		document.parameter_header_form.gen_drug_code.value="X";

	}
	else if(dc_realation=="D"){
		if(document.parameter_header_form.st_install_yn.value=='Y'){
		var len = document.parameter_header_form.drug_item_set_up.options.length;
		for(var i=0;i<len;i++) {
			document.parameter_header_form.drug_item_set_up.remove("drug_item_set_up");
		}
		var opt = document.createElement("OPTION");
		opt.text = "One Drug to One Item" ;
		opt.value = "S" ;
		document.parameter_header_form.drug_item_set_up.add(opt);
		var opt1 = document.createElement("OPTION");
		opt1.text = "One Drug to Many Item" ;
		opt1.value = "D" ;
		document.parameter_header_form.drug_item_set_up.add(opt1);
		}
		document.parameter_header_form.drug_item_set_up.disabled=false;
		document.parameter_header_form.drug_item_set_up.value="D";
		var len = document.parameter_header_form.gen_drug_code.options.length;
		for(var i=0;i<len;i++) {
			document.parameter_header_form.gen_drug_code.remove("gen_drug_code");
		}

		var opt = document.createElement("OPTION");
		opt.text = "System Generated Sequence" ;
		opt.value = "G" ;
		document.parameter_header_form.gen_drug_code.add(opt);

		var opt1 = document.createElement("OPTION");
		opt1.text = "User Entrable" ;
		opt1.value = "E" ;
		document.parameter_header_form.gen_drug_code.add(opt1);
		document.parameter_header_form.gen_drug_code.value="G";
		document.parameter_header_form.gen_drug_code.disabled=false;
	}
	else if(dc_realation=="X"){
		if(document.parameter_header_form.st_install_yn.value=='Y'){
		var len = document.parameter_header_form.drug_item_set_up.options.length;
		for(var i=0;i<len;i++) {
		document.parameter_header_form.drug_item_set_up.remove("drug_item_set_up");
		}
		var opt = document.createElement("OPTION");
		opt.text = "Not Applicable" ;
		opt.value = "X" ;
		document.parameter_header_form.drug_item_set_up.add(opt);
		}
		document.parameter_header_form.drug_item_set_up.disabled=true;
		document.parameter_header_form.drug_item_set_up.value="X";
	}
}

function validateGenDrugCode(obj){
	if(obj.value=="S"){

		var len = document.parameter_header_form.drug_item_code_relation.options.length;
		for(var i=0;i<len;i++) {
			document.parameter_header_form.drug_item_code_relation.remove("drug_item_code_relation");
		}

		var opt = document.createElement("OPTION");
		opt.text = "    Same   " ;
		opt.value = "S" ;
		document.parameter_header_form.drug_item_code_relation.add(opt);
		document.parameter_header_form.drug_item_code_relation.disabled=true;

		var len = document.parameter_header_form.gen_drug_code.options.length;
		for(var i=0;i<len;i++) {
			document.parameter_header_form.gen_drug_code.remove("gen_drug_code");
		}

		var opt0 = document.createElement("OPTION");
		opt0.text = "   ---Select---" ;
		opt0.value = "" ;
		document.parameter_header_form.gen_drug_code.add(opt0);

		var opt01 = document.createElement("OPTION");
		opt01.text = "Not Applicable" ;
		opt01.value = "X" ;
		document.parameter_header_form.gen_drug_code.add(opt01);


		var opt = document.createElement("OPTION");
		opt.text = "System Generated Sequence" ;
		opt.value = "G" ;
		document.parameter_header_form.gen_drug_code.add(opt);

		var opt1 = document.createElement("OPTION");
		opt1.text = "User Entrable" ;
		opt1.value = "E" ;
		document.parameter_header_form.gen_drug_code.add(opt1);

		document.parameter_header_form.gen_drug_code.value="E";

	}
	else if(obj.value=="D"){
		var len = document.parameter_header_form.drug_item_code_relation.options.length;
		for(var i=0;i<len;i++) {
			document.parameter_header_form.drug_item_code_relation.remove("drug_item_code_relation");
		}

		var opt = document.createElement("OPTION");
		opt.text = "    Different   " ;
		opt.value = "D" ;
		document.parameter_header_form.drug_item_code_relation.add(opt);
		document.parameter_header_form.drug_item_code_relation.disabled=true;

		var len = document.parameter_header_form.gen_drug_code.options.length;
		for(var i=0;i<len;i++) {
			document.parameter_header_form.gen_drug_code.remove("gen_drug_code");
		}

		var opt = document.createElement("OPTION");
		opt.text = "System Generated Sequence" ;
		opt.value = "G" ;
		document.parameter_header_form.gen_drug_code.add(opt);

		var opt1 = document.createElement("OPTION");
		opt1.text = "User Entrable" ;
		opt1.value = "E" ;
		document.parameter_header_form.gen_drug_code.add(opt1);
		document.parameter_header_form.gen_drug_code.disabled=false;

		}
		else{
		var len = document.parameter_header_form.drug_item_code_relation.options.length;
		for(var i=0;i<len;i++) {
			document.parameter_header_form.drug_item_code_relation.remove("drug_item_code_relation");
		}

		var opt = document.createElement("OPTION");
		opt.text = "   --- Select ---  " ;
		opt.value = "" ;
		document.parameter_header_form.drug_item_code_relation.add(opt);
		var opt1 = document.createElement("OPTION");
		opt1.text = "    Same   " ;
		opt1.value = "S" ;
		document.parameter_header_form.drug_item_code_relation.add(opt1);
		var opt2 = document.createElement("OPTION");
		opt2.text = "    Same   " ;
		opt2.value = "S" ;
		document.parameter_header_form.drug_item_code_relation.add(opt2);
		document.parameter_header_form.drug_item_code_relation.value="";
		document.parameter_header_form.drug_item_code_relation.disabled=true;



		var len = document.parameter_header_form.gen_drug_code.options.length;
		for(var i=0;i<len;i++) {
			document.parameter_header_form.gen_drug_code.remove("gen_drug_code");
		}

		var opt0 = document.createElement("OPTION");
		opt0.text = "    ---Select---" ;
		opt0.value = "" ;
		document.parameter_header_form.gen_drug_code.add(opt0);

		var opt01 = document.createElement("OPTION");
		opt01.text = "Not Applicable" ;
		opt01.value = "X" ;
		document.parameter_header_form.gen_drug_code.add(opt01);


		var opt = document.createElement("OPTION");
		opt.text = "System Generated Sequence" ;
		opt.value = "G" ;
		document.parameter_header_form.gen_drug_code.add(opt);

		var opt1 = document.createElement("OPTION");
		opt1.text = "User Entrable" ;
		opt1.value = "E" ;
		document.parameter_header_form.gen_drug_code.add(opt1);

		document.parameter_header_form.gen_drug_code.value="";

		}

}

function ValidateRefill(obj){

	if(obj.checked){
			document.parameter_header_form.allow_refill.value="Y";
			document.parameter_header_form.refill_prescription.disabled=false;
			document.parameter_header_form.print_refill.disabled=false;
			document.parameter_header_form.refill_allowed.disabled=false;
			document.getElementById('refill_prescription_man').style.visibility="visible";
			document.parameter_header_form.getElementById('refill_allowed_man').style.visibility="visible";

	}else{
			document.parameter_header_form.allow_refill.value="N";
			document.parameter_header_form.refill_prescription.value="";
			document.parameter_header_form.refill_prescription.disabled=true;

			document.parameter_header_form.print_refill.checked=false;
			document.parameter_header_form.print_refill.value="N";
			document.parameter_header_form.print_refill.disabled=true;

			document.parameter_header_form.refill_allowed.value="";
			document.parameter_header_form.refill_allowed.disabled=true;
			document.getElementById('refill_prescription_man').style.visibility="hidden";
			document.parameter_header_form.getElementById('refill_allowed_man').style.visibility="hidden";

	}

}
function ValidateUptoDays(obj){
	if(obj.checked){

			document.parameter_detail_form.allow_past_dispense.value="Y";
			document.parameter_detail_form.upto_days.disabled=false;	document.parameter_detail_form.document.getElementById('upto_days_man').style.visibility="visible";
	}
	else{
			document.parameter_detail_form.allow_past_dispense.value="N";
			document.parameter_detail_form.upto_days.value="";
			document.parameter_detail_form.upto_days.disabled=true;	document.parameter_detail_form.document.getElementById('upto_days_man').style.visibility="hidden";

	}

}
function ValidateNoofDaysAhead(obj){
	if(obj.checked){
			document.parameter_detail_form.allow_dispense.value="Y";
			document.parameter_detail_form.no_days_ahead.disabled=false;	document.parameter_detail_form.document.getElementById('no_days_ahead_man').style.visibility="visible";
	}
	else{
			document.parameter_detail_form.allow_dispense.value="N";
			document.parameter_detail_form.no_days_ahead.value="";
			document.parameter_detail_form.no_days_ahead.disabled=true;	document.parameter_detail_form.document.getElementById('no_days_ahead_man').style.visibility="hidden";
	}
}
function validatePrescriptionDuration(val) {
	if(val=="Y"){
		document.parameter_detail_form.prescription_duration.disabled=false;
		document.getElementById('prescription_duration_man').style.visibility="visible";
	}else{
		document.parameter_detail_form.prescription_duration.disabled=true;
		document.getElementById('prescription_duration_man').style.visibility="hidden";
	}
}
function validateRefillPrescription(val) {
	if(val=="Y"){
		document.parameter_header_form.refill_prescription.disabled=false;
		document.getElementById('refill_prescription_man').style.visibility="visible";
	}else{
		document.parameter_header_form.refill_prescription.disabled=true;
		document.getElementById('refill_prescription_man').style.visibility="hidden";
	}
}
function validateRefillAllowed(val) {
	if(val=="Y"){
		document.parameter_header_form.refill_allowed.disabled=false;
		document.getElementById('refill_allowed_man').style.visibility="visible";
	}else{
		document.parameter_header_form.refill_allowed.disabled=true;
		document.getElementById('refill_allowed_man').style.visibility="hidden";
	}
}

function assignValue(obj){

	if(obj.checked){
		obj.value="Y";
	}
	else{
		obj.value="N";
	}


}

function validateNoDaysAhead(obj){
	if(obj.checked){
		document.parameter_detail_form.no_days_ahead.disabled=false;
		document.getElementById('no_days_ahead_man').style.visibility="visible";

	}
	else{
		document.parameter_detail_form.no_days_ahead.value="";
		document.parameter_detail_form.no_days_ahead.disabled=true;
		document.getElementById('no_days_ahead_man').style.visibility="hidden";
	}

}

function validateNoDaysAheadMandatory(val){
if(val=="Y")document.getElementById('no_days_ahead_man').style.visibility="visible";
else if(val=="N") document.getElementById('no_days_ahead_man').style.visibility="hidden";

}

function validateUptoDays(obj){
	if(obj.checked){
		document.parameter_detail_form.upto_days.disabled=false;
		document.getElementById('upto_days_man').style.visibility="visible";
	}
	else{
		document.parameter_detail_form.upto_days.value="";
		document.parameter_detail_form.upto_days.disabled=true;
		document.getElementById('upto_days_man').style.visibility="hidden";
	}

}

function validateUptoDaysMandatory(val){
if(val=="Y")document.getElementById('upto_days_man').style.visibility="visible";
else if(val=="N") document.getElementById('upto_days_man').style.visibility="hidden";

}


function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function onSuccess() {
	reset();
}

function beforePost( str ) {
	//alert( str );
}

function validateMultiStrength(obj){
	if(obj.checked){
		//commented for GHL-CRF-0548 START
		//document.parameter_detail_form.dispense_value_strength.checked=true;
		//document.parameter_detail_form.dispense_value_strength.disabled=true;
		//document.parameter_detail_form.dispense_value_strength.value="Y";
		//commented for GHL-CRF-0548 END
		 
		document.parameter_detail_form.dispense_value_strength.disabled=false;//ADDED for GHL-CRF-0548 
		
	}
	else{
		//commented for GHL-CRF-0548 START
		//	document.parameter_detail_form.dispense_value_strength.checked=false;
	//	document.parameter_detail_form.dispense_value_strength.disabled=false;
	//	document.parameter_detail_form.dispense_value_strength.value="N";
		//commented for GHL-CRF-0548 END
		
		var strengt_type=document.parameter_detail_form.dispense_value_strength.value;
		if(strengt_type=="S"){
		document.parameter_detail_form.dispense_value_strength.selectedIndex=1;
		
		if(document.parameter_detail_form.dispense_value_strength.value=="S"){
			document.parameter_detail_form.dispense_value_strength.selectedIndex=0;
			}
		}
		document.parameter_detail_form.dispense_value_strength.disabled=true;//ADDED for GHL-CRF-0548
	}

}

function checkIsNotZero(obj, appendObj){
/*	if (obj.value == "0") {
		alert(getMessage("ZERO_NOT_ALLOWED","PH") + appendObj);
		obj.select();
	}*/
	 if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0){
			    return true;
	}
	else {
        if ( obj.value.length > 0 && obj.value==0){
			alert(getMessage("ZERO_NOT_ALLOWED","PH") + appendObj);
			obj.select();
			obj.focus();
			return false;
		}
	}
}


function callDrugDatabaseInterface(){
	//alert("alert");
	//document.parameter_detail_form.all.drug_database_interface_tab.src='../../ePH/images/Drug Database Interface_click.gif';
	document.getElementById('drug_database_interface').style.display="inline";
	document.getElementById('drug_database_interface').style.visibility="visible";
	document.getElementById('prescription_rules').style.display="none";
	if (document.getElementById('licenceRights').value !="PHBASIC"){
		document.getElementById('dispense_rules').style.display="none";
		document.getElementById('dispense_rules_op_pharm').style.display="none";
		document.getElementById('process_names').style.display="none";
		//document.parameter_detail_form.all.dispense_rules_tab.src="../../ePH/images/DispensingRules.gif";
		//document.parameter_detail_form.all.process_names_tab.src="../../ePH/images/Process Name.gif";
	}
	//document.parameter_detail_form.all.prescription_rules_tab.src="../../ePH/images/PrescriptionRules.gif";
}

function callProcessNames(){

	//document.parameter_detail_form.all.process_names_tab.src='../../ePH/images/Process Name_click.gif';
	document.getElementById('process_names').style.display="inline";
	document.getElementById('process_names').style.visibility="visible";
	document.getElementById('drug_database_interface').style.display="none";
	document.getElementById('prescription_rules').style.display="none";
	if (document.getElementById('licenceRights').value !="PHBASIC"){
		document.getElementById('dispense_rules').style.display="none";
		document.getElementById('dispense_rules_op_pharm').style.display="none";
		//document.parameter_detail_form.all.dispense_rules_tab.src="../../ePH/images/DispensingRules.gif";
	}

	//document.parameter_detail_form.all.prescription_rules_tab.src="../../ePH/images/PrescriptionRules.gif";
	//document.parameter_detail_form.all.drug_database_interface_tab.src="../../ePH/images/Drug Database Interface.gif";
}




function checkSplChars(obj)	{
	if(!CheckChars(obj))	{
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.select();
	}
}

function CheckForNumbers(event){
   
   	if( (event.keyCode >= 48) && (event.keyCode <= 57) )
		return false;
	else
		return true ;
}

function apply(){
	var formObj_1 = f_query_add_mod.document.parameter_header_form ;
	var formObj_2 = f_query_details.document.parameter_detail_form ;
	var inpatient_yn =formObj_2.inpatient_yn.value;
	var fields  = new Array() ;
	var names   = new Array() ;

	fields[0]   = formObj_1.drug_item_code_link ;
	fields[1]   = formObj_1.drug_item_code_relation ;
	fields[2]   = formObj_1.gen_drug_code ;
	fields[3]   = formObj_1.drug_item_set_up ;
	fields[4]   = formObj_1.route_transfusion ;
	
	//fields[6]   = formObj_2.dispense_duration ;
	names[0]   = getLabel("ePH.DrugandItemCodeLinkRequired.label","PH");
	names[1]   = getLabel("ePH.DrugandItemCodeRelationship.label","PH");
	names[2]   = getLabel("ePH.GenerationofDrugCode.label","PH");
	names[3]   = getLabel("ePH.Drug/ItemSetUp.label","PH");
	names[4]   = getLabel("ePH.RouteforIVTransfusion.label","PH");
	
	if(inpatient_yn=="Y"){
	   fields[5]   = formObj_2.prescription_duration ;
	   names[5]   = getLabel("ePH.MaxPrescriptionDurationforInpatients.label","PH");
	   var count_fld=6;
	   var count_name=6;
	}
	else{
       var count_fld=5;
	   var count_name=5;    
	}
	//names[6]   = getLabel("ePH.MaxDispenseDuration.label","PH");
	
	if(f_query_add_mod.document.parameter_header_form.allow_refill.checked==true){
		fields[parseInt(count_fld++)]   = formObj_1.refill_allowed ;
		fields[parseInt(count_fld++)]   = formObj_1.refill_prescription ;
		names[parseInt(count_name++)]   = "Max No of refills allowed" ;
		names[parseInt(count_name++)]   = "Max Days for Refill Prescription" ;
	}
	if(f_query_details.document.parameter_detail_form.inpatient_yn.value=="Y"){
		fields[parseInt(count_fld++)]   = formObj_2.max_pres_duration ;
		names[parseInt(count_name++)]   = "Max Prescription Duration" ;
	}

	if(f_query_details.document.parameter_detail_form.max_durn_for_dm_pres.value==""){
		fields[parseInt(count_fld++)]   = formObj_2.max_durn_for_dm_pres ;
		names[parseInt(count_name++)]   = "Max Prescription Duration for Discharge Medication" ;
	}

	if (formObj_2.licenceRights.value !="PHBASIC"){
		if(f_query_details.document.parameter_detail_form.allow_dispense.checked==true){
			fields[parseInt(count_fld++)]   = formObj_2.no_days_ahead ;
			names[parseInt(count_name++)]   = "No of days Ahead" ;
		}
		if(f_query_details.document.parameter_detail_form.allow_past_dispense.checked==true){
			fields[parseInt(count_fld++)]   = formObj_2.upto_days ;
			names[parseInt(count_name++)]   = "Up to No. of days" ;
		}
	}

	if (formObj_2.licenceRights.value !="PHBASIC"){
		if(f_query_details.document.parameter_detail_form.iv_with_additives){
			fields[parseInt(count_fld++)]   = formObj_2.iv_with_additives ;
			names[parseInt(count_name++)]   = "IV With Additives" ;
		}
		if(f_query_details.document.parameter_detail_form.iv_with_additives){
			fields[parseInt(count_fld++)]   = formObj_2.iv_intermittent ;
			names[parseInt(count_name++)]   = "IV Intermittent" ;
		}
		if(f_query_details.document.parameter_detail_form.iv_without_additives){
			fields[parseInt(count_fld++)]   = formObj_2.iv_without_additives ;
			names[parseInt(count_name++)]   = "IV Without Additives" ;
		}
	}
	if(formObj_2.first_trimster_from.value!="" ){
		fields[parseInt(count_fld++)]   = formObj_2.first_trimster_to ;
		names[parseInt(count_name++)]   = getLabel("ePH.FirstTrimester.label","PH") +" "+getLabel("Common.to.label","Common") ;
	}
	if(formObj_2.second_trimster_from.value!="" ){
		fields[parseInt(count_fld++)]   = formObj_2.second_trimster_to ;
		names[parseInt(count_name++)]   = getLabel("ePH.SecondTrimester.label","PH")+" "+getLabel("Common.to.label","Common");
	}
	if(formObj_2.third_trimster_from.value!="" ){
		fields[parseInt(count_fld++)]   = formObj_2.third_trimster_to ;
		names[parseInt(count_name++)]   = getLabel("ePH.ThirdTrimester.label","PH")+" "+getLabel("Common.to.label","Common") ;
	}
	if(f_query_add_mod.checkFields( fields, names, messageFrame)) {
		var formarray  =new Array(formObj_1,formObj_2);
		//alert("PH_CONTROLLER =" + PH_CONTROLLER) ;
		eval(formApply( formarray,PH_CONTROLLER)) ;
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		if(result) {
			onSuccess();
		}		
	}
}

function checkAuditLog(obj, display_audit_log_button_yn){
	if(obj.checked == true ){
		obj.value="Y";
		if(display_audit_log_button_yn == "Y")
			document.parameter_header_form.audit_log.style.visibility = "visible";
	}
	else{
		obj.value="N";
		document.parameter_header_form.audit_log.style.visibility = "hidden";
	}
}

function validatePRNRemarksLength(obj){
	Objval= obj.value;
	if(isNaN(Objval) || (Objval.indexOf(".")!= -1)){
		alert(getMessage("ONLY_NUMBER_ALLOWED","PH"));
		obj.select();
		obj.focus();
	}
	else if((parseFloat(Objval) < 1) || (parseFloat(Objval) > 255)){
		alert(getMessage("MAX_LENGTH_PRN_REMARKS_BETN_1_255","PH"));
		obj.select();
		obj.focus();
	}
}

function chkweeks(objFrom, objTo, calledFrom){ //Added for  RUT-CRF-0063 [IN:029601] - start
	var formobj =document.parameter_detail_form;
	var first_trim_from =formobj.first_trimster_from.value;
	var frist_trim_to   =formobj.first_trimster_to.value;
	var second_trim_from=formobj.second_trimster_from.value;
	var second_trim_to  =formobj.second_trimster_to.value;
	var third_trim_from  =formobj.third_trimster_from.value;
	var third_trim_to   =formobj.third_trimster_to.value;
	var fromValue = objFrom.value;
	var toValue = objTo.value;
	var msg ="";
	var overLap=false;
	if(fromValue!="" & toValue!="" &&  parseInt(toValue) <= parseInt(fromValue)){
		msg = getMessage("PH_TO_VALUE_CAN_NOT_LESS_FROM_VALUE", "PH");
		overLap = true;
	}
	else{
		msg = getMessage("PH_RANGE_WEEK_ORDER", "PH"); 
		if( first_trim_from== "" && frist_trim_to!=""){
			overLap = true;
			formobj.first_trimster_to.value="";
		}
		else if((first_trim_from== "" || frist_trim_to=="" )&& second_trim_from!=""){
			overLap = true;
			formobj.second_trimster_from.value="";
		}
		else if((first_trim_from== "" || frist_trim_to=="" || second_trim_from=="" )&& second_trim_to!=""){
			overLap = true;
			formobj.second_trimster_to.value="";
		}
		else if((first_trim_from== "" || frist_trim_to=="" || second_trim_from=="" || second_trim_to=="") && third_trim_from!=""){
			overLap = true;
			formobj.third_trimster_from.value="";
		}
		else if((first_trim_from== "" || frist_trim_to=="" || second_trim_from=="" || second_trim_to=="" || third_trim_from=="" )&& third_trim_to!=""){
			overLap = true;
			formobj.third_trimster_to.value="";
		}
		if(overLap==false){
			msg= getMessage("PH_SAME_RANGE_WEEK_SELECT", "PH");
			if( parseInt(second_trim_from)>= parseInt(first_trim_from) && parseInt(second_trim_from)<= parseInt(frist_trim_to)){
				if(objFrom.name=='second_trimster_from')
					msg = msg.replace('$', getLabel("ePH.FirstTrimester.label","PH"));
				else
					msg = msg.replace('$', getLabel("ePH.SecondTrimester.label","PH"));
				overLap = true;
			}
			else if( parseInt(third_trim_from) >= parseInt(first_trim_from) && parseInt(third_trim_from) <= parseInt(frist_trim_to)) {
				if(objFrom.name=='third_trimster_from')
					msg = msg.replace('$', getLabel("ePH.FirstTrimester.label","PH"));
				else
					msg = msg.replace('$', getLabel("ePH.ThirdTrimester.label","PH"));
				overLap = true;
			}
			else if( parseInt(third_trim_from) >= parseInt(second_trim_from) && parseInt(third_trim_from) <= parseInt(second_trim_to)){
				if(objFrom.name=='third_trimster_from')
					msg = msg.replace('$', getLabel("ePH.SecondTrimester.label","PH"));
				else
					msg = msg.replace('$', getLabel("ePH.ThirdTrimester.label","PH"));
				overLap = true;
			}
		}
		if(overLap==false){
			msg= getMessage("PH_INVALID_RANGE_WEEK", "PH");
			if(parseInt(second_trim_from)- parseInt(frist_trim_to) >1 || (parseInt(second_trim_from)< parseInt(first_trim_from))){
				overLap = true;
			}
			else if(parseInt(third_trim_from)- parseInt(second_trim_to) >1 ||  (parseInt(third_trim_from)< parseInt(first_trim_from))){
				overLap = true;
			}
		}
	}
	if(overLap){
		alert(msg);
		if(calledFrom =='F')
			objFrom.value="";
		else
			objTo.value="";
		return false;
	}
}	// added for RUT-CRF-0063 [IN:029601] 

function checkBlank(obj){ // Added for ML-MMOH-SCF-0410[IN:005009] - Start
	if(obj == null || obj.value == ""){
		alert(getMessage("PH_ELAPSE_PERIOD_OF_ORDER_FOR_ADR","PH"));
		document.parameter_header_form.elapsed_period_of_orders_adr.value="0";
	}				
}                        // Added for ML-MMOH-SCF-0410[IN:005009] - End


function ValidatePresCont(obj){ //added for MMS-DM-CRF-0169
      if(obj.checked)
      {
			obj.value="Y";
			
		}
		else{
			obj.value="N";
			
		}


	}

