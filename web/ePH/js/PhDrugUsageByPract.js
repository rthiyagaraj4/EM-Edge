  
function run(){

	var frmObject = f_query_add_mod.document.formPhDrugUsageByPractCriteria;
	
	//var temp_qry_1=f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value+"'"+frmObject.p_language_id.value+"'";//commented for BRU-SCF-1185[45562]
	 var temp_qry_1=f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value;//Added for BRU-SCF-1185[45562]

	f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value="";
	if(f_query_add_mod.document.formPhDrugUsageByPractCriteria) {
		var fields= new Array (frmObject.dt_from1,frmObject.dt_to1,frmObject.p_group_by,frmObject.p_report_by);
		var names= new Array (getLabel("Common.periodfrom.label","Common"),getLabel("Common.todate.label","Common"), getLabel("Common.groupby.label","Common"),getLabel("Common.reporttype.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhDrugUsageByPractCriteria.dt_from1, f_query_add_mod.document.formPhDrugUsageByPractCriteria.dt_to1, messageFrame ) ) {
				if(f_query_add_mod.CheckString("Practitioner Id", f_query_add_mod.document.formPhDrugUsageByPractCriteria.pract_id, f_query_add_mod.document.formPhDrugUsageByPractCriteria.tpract_id, messageFrame) ){
					f_query_add_mod.document.formPhDrugUsageByPractCriteria.pract_name.value = replaceSpecialChar(f_query_add_mod.document.formPhDrugUsageByPractCriteria.pract_name.value);
					f_query_add_mod.document.formPhDrugUsageByPractCriteria.tpract_name.value = replaceSpecialChar(f_query_add_mod.document.formPhDrugUsageByPractCriteria.tpract_name.value);
					if(f_query_add_mod.CheckString(getLabel("Common.DrugName.label","Common"), f_query_add_mod.document.formPhDrugUsageByPractCriteria.drug_code, f_query_add_mod.document.formPhDrugUsageByPractCriteria.tdrug_code, messageFrame)){	
							var tmp_drug_desc = f_query_add_mod.document.formPhDrugUsageByPractCriteria.drug_name.value;
							var tmp_drug_desc1 = f_query_add_mod.document.formPhDrugUsageByPractCriteria.tdrug_name.value;

							if(tmp_drug_desc != '')
								f_query_add_mod.document.getElementById("drug_from").innerHTML = "&nbsp";
							if(tmp_drug_desc1 != '')	
								f_query_add_mod.document.getElementById("drug_to").innerHTML = "&nbsp";

							if(f_query_add_mod.CheckString("ATC Id",f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_atc_from, f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_atc_to, messageFrame)){
								var tmp_atc_desc= f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_atc_from_id.value;
								var tmp_atc_desc1=f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_atc_to_id.value;
								f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_atc_from_id.value = replaceSpecialChar(f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_atc_from_id.value);
								f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_atc_to_id.value = replaceSpecialChar(f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_atc_to_id.value);
								
								f_query_add_mod.document.formPhDrugUsageByPractCriteria.dt_from.value = convertDate(f_query_add_mod.document.formPhDrugUsageByPractCriteria.dt_from1.value,'DMY',f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_language_id.value,'en');
								f_query_add_mod.document.formPhDrugUsageByPractCriteria.dt_to.value = convertDate(f_query_add_mod.document.formPhDrugUsageByPractCriteria.dt_to1.value,'DMY',f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_language_id.value,'en');
								
								if(f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_atc_level.value != 'ALL'){
									f_query_add_mod.document.getElementById("atc_from").innerHTML = "&nbsp";
									f_query_add_mod.document.getElementById("atc_to").innerHTML = "&nbsp";
								}
							    f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
								f_query_add_mod.document.forms[0].target="messageFrame";
								f_query_add_mod.document.formPhDrugUsageByPractCriteria.submit();
								if(tmp_drug_desc != ''){
									f_query_add_mod.document.getElementById("drug_from").innerHTML = '&nbsp;<input type="text" name="drug_name" id="drug_name" readonly maxlength="30" size="30" value="'+tmp_drug_desc+'"><input type="button" class="button" value="?"  name="drug_search" id="drug_search" onClick="callDrugSearch(document.formPhDrugUsageByPractCriteria.drug_name, 1)" >';
								}
								if(tmp_drug_desc1 != ''){	
									f_query_add_mod.document.getElementById("drug_to").innerHTML = '&nbsp;<input type="text" name="tdrug_name" id="tdrug_name" readonly maxlength="30" size="30" value="'+tmp_drug_desc1+'"><input type="button" class="button" value="?" name="tdrug_search" id="tdrug_search" onClick="callDrugSearch(document.formPhDrugUsageByPractCriteria.tdrug_name, 2)">';
								}
								if(f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_atc_level.value != 'ALL'){
								f_query_add_mod.document.getElementById("atc_from").innerHTML = '&nbsp;<input type="text" name="p_atc_from_id" id="p_atc_from_id" readonly maxlength="30" size="30" value="'+tmp_atc_desc+'"><input type="button" class="button" value="?" name="narrationFrom" id="narrationFrom" onClick="search1(document.forms[0].p_atc_from_id,1)">';
								f_query_add_mod.document.getElementById("atc_to").innerHTML = '&nbsp;<input type="text" name="p_atc_to_id" id="p_atc_to_id" readonly maxlength="30" size="30" value="'+tmp_atc_desc1+'"><input type="button" class="button" value="?" name="narrationTo" id="narrationTo" onClick="search1(document.forms[0].p_atc_to_id,2)">';
								
								/*if(tmp_atc_desc =='')
									f_query_add_mod.document.formPhDrugUsageByPractCriteria.narrationFrom.disabled =true;
								if(tmp_atc_desc1 =='')
									f_query_add_mod.document.formPhDrugUsageByPractCriteria.narrationTo.disabled =true;
								*/
								}
							}
						}
				}
			}
		}
	}
	f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value = temp_qry_1;
}

// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formPhDrugUsageByPractCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}

function replaceSpecialChar(values) {
	var strCheck = new Array("@", "!", "~" ,"#" ,"$" ,"%" ,"^" ,"*" ,"(" ,")" ,"_" ,"-" ,"+" ,"=" ,"`" ,"?" ,";" ,":" ,"'","<" ,">","/","\\","|","{","]","[","}" ,".");
	var lenValue  = strCheck.length;
	for(var i=0;i<lenValue;i++){
		while(values.indexOf(strCheck[i]) != -1 ){
			while(values.indexOf(strCheck[i]) != -1){
				values = values.replace(strCheck[i],"");
			}
			i++;
		}
	}
	return values;
}

function reset() {
    f_query_add_mod.formPhDrugUsageByPractCriteria.reset();
	
	if(f_query_add_mod.formPhDrugUsageByPractCriteria.p_facility_code.value==""){
		f_query_add_mod.formPhDrugUsageByPractCriteria.drug_name.value='';
		f_query_add_mod.formPhDrugUsageByPractCriteria.tdrug_name.value='';
		f_query_add_mod.formPhDrugUsageByPractCriteria.pract_name.value='';
		f_query_add_mod.formPhDrugUsageByPractCriteria.pract_search.disabled=true;
		f_query_add_mod.formPhDrugUsageByPractCriteria.tpract_name.value='';
		f_query_add_mod.formPhDrugUsageByPractCriteria.tpract_search.disabled=true;
		f_query_add_mod.formPhDrugUsageByPractCriteria.p_job_title.value='';
		f_query_add_mod.formPhDrugUsageByPractCriteria.p_job_title.selectedIndex=0;
		f_query_add_mod.formPhDrugUsageByPractCriteria.p_job_title.disabled=true;
	}
	if(f_query_add_mod.formPhDrugUsageByPractCriteria.p_atc_level.value=="ALL"){
		f_query_add_mod.formPhDrugUsageByPractCriteria.drug_name.value='';
		f_query_add_mod.formPhDrugUsageByPractCriteria.tdrug_name.value='';
		f_query_add_mod.formPhDrugUsageByPractCriteria.p_atc_from.value='';
		f_query_add_mod.formPhDrugUsageByPractCriteria.narrationFrom.disabled=true;
		f_query_add_mod.formPhDrugUsageByPractCriteria.p_atc_from_id.value='';
		f_query_add_mod.formPhDrugUsageByPractCriteria.p_atc_to.value='';
		f_query_add_mod.formPhDrugUsageByPractCriteria.narrationTo.disabled=true;
		f_query_add_mod.formPhDrugUsageByPractCriteria.p_atc_to_id.value='';
		f_query_add_mod.formPhDrugUsageByPractCriteria.p_atc_level.value="ALL";
		f_query_add_mod.formPhDrugUsageByPractCriteria.p_atc_level.selectedIndex=0;
		//document.formPhDrugUsageByPractCriteria.p_atc_level.disabled=true;
	}
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function callResultPage() {
	var result	=	false;
	frm_obj		=	f_query_add_mod.document.formPhDrugUsageByPractCriteria.dt_from1;
	to_obj		=	f_query_add_mod.document.formPhDrugUsageByPractCriteria.dt_to1;

	msg_frame		=	messageFrame;

	if(doDateCheck(frm_obj,to_obj,msg_frame)) {
		result	=	true;
	}
	else {
		result  = false;
	}
	//alert(result);
	return result;
}

async function searchPractitionerName(target, mode) {

	var frm_obj		=	f_query_add_mod.document.formPhDrugUsageByPractCriteria;

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	
	/*if(mode == 1){ //commented for BRU-SCF-1185[45562] start
		f_query_add_mod.document.formPhDrugUsageByPractCriteria.pract_id.value='';
		f_query_add_mod.document.formPhDrugUsageByPractCriteria.pract_name.value='';
	}
	if(mode == 2){
		f_query_add_mod.document.formPhDrugUsageByPractCriteria.tpract_id.value='';
		f_query_add_mod.document.formPhDrugUsageByPractCriteria.tpract_name.value='';
	}*/ //commented for BRU-SCF-1185[45562] end

	dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_user_name.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_facility_code.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_facility_code.value;
	dataTypeArray[2]	= STRING ;
	dataNameArray[3]	= "PRACT_TYPE" ;
	dataValueArray[3]	= f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_job_title.value;
	dataTypeArray[3]	= STRING ;
	
	var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_language_id.value;
	argumentArray[0] = escape(f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value)+"'"+lan_id+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "5,6";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;

	var retArray = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );
	var ret1=unescape(retArray);
	var arr=ret1.split(",");
	if(retArray != null && retArray != "") {
			if (mode == 1){
			f_query_add_mod.document.formPhDrugUsageByPractCriteria.pract_id.value = arr[0];

		}
		else if (mode == 2){
			f_query_add_mod.document.formPhDrugUsageByPractCriteria.tpract_id.value = arr[0];

		}
		target.value = arr[1];

	}
}

/*function callDrugSearch(obj,mode) {
  	var arrCodeDesc = DrugSearch("D",obj);
	alert("stringreturn"+ arrCodeDesc);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		if (mode == 1)	
			f_query_add_mod.document.formPhDrugUsageByPractCriteria.drug_code.value = arrCodeDesc[0];
		else if (mode == 2)	
			f_query_add_mod.document.formPhDrugUsageByPractCriteria.tdrug_code.value = arrCodeDesc[0];
	    alert(arrCodeDesc[0]); 	
	//	document.formPhDrugUsageByPractCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
		alert(arrCodeDesc[1]);
	}
} */

async function callDrugSearch(obj,mode) {
	var arrCodeDesc = await DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		if (mode == 1){  
			document.formPhDrugUsageByPractCriteria.drug_code.value	=	arrCodeDesc[0];
		}
		if (mode == 2){		
			document.formPhDrugUsageByPractCriteria.tdrug_code.value	=	arrCodeDesc[0];
		}
		//document.formPhDrugUsageByPractCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}

function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	history.go(-1);
}

/*function ValidateFrom(from,to) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
		alert("Should be Greater than Current Time");
		to.select();
		result	=	false;
	}
	return result;
}

function ValidateFrom(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
		alert("Should be Greater than Current Time");
		to.select();
		result	=	false;
	}
	else{
		if(!ValidateDateTime(to,en)) {
			alert("Should be Less than Sysdate ");
        	to.select();
			result	=	false;
		}
	}
	return result;
}

function ValidateTo(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
		alert("Should be Greater than From Time");
		to.select();
		to.focus();
		result	=	false;
	}
	else{
		if(!ValidateDateTime(to,en)) {
			alert("Should be Less than Sysdate + 1 ");
        	to.select();
			result	=	false;
			to.focus();
		}
	}
	return result;
}


function search1(target ) {
	var frmObj= document.formPhDrugUsageByPractCriteria;
	var searchFor = frmObj.p_atc_level.value;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var retArray 		= new Array() ;

	if (searchFor == "") {
		alert("ATC Level must be selected");
		return false;
				
	}else if (searchFor == "ATC Level1") {
		argumentArray[0] = frmObj.sql_ph_reports_atc1_lookup.value;
				
	}else if (searchFor == "ATC Level2") {
		argumentArray[0] = frmObj.sql_ph_reports_atc2_lookup.value;
	}else if (searchFor == "ATC Level3") {
		argumentArray[0] = frmObj.sql_ph_reports_atc3_lookup.value;
	}else if (searchFor == "ATC Level4") {
		argumentArray[0] = frmObj.sql_ph_reports_atc4_lookup.value;
	}else if (searchFor == "ATC Level5") {
		argumentArray[0] = frmObj.sql_ph_reports_atc5_lookup.value;
	}
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	retArray = CommonLookup( searchFor, argumentArray );
	if(retArray != null && retArray != "" ) {
		target.value = retArray[0];	
		target.focus();
	}
}

function search1(target ) {
	var frmObj= document.formPhDrugUsageByPractCriteria;
	var searchFor = frmObj.p_atc_level.value;
	f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_atc_to_id.value='';
	f_query_add_mod.document.formPhDrugUsageByPractCriteria.p_atc_to.value='';
	

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var retArray 		= new Array() ;

	if (searchFor == "") {
		alert("ATC Level must be selected");
		return false;
				
	}else if (searchFor == "ATC1") {
			argumentArray[0] = frmObj.sql_ph_reports_atc1_lookup.value;
				
	}else if (searchFor == "ATC2") {
		argumentArray[0] = frmObj.sql_ph_reports_atc2_lookup.value;
	}else if (searchFor == "ATC3") {
		argumentArray[0] = frmObj.sql_ph_reports_atc3_lookup.value;
	}else if (searchFor == "ATC4") {
		argumentArray[0] = frmObj.sql_ph_reports_atc4_lookup.value;
	}else if (searchFor == "ATC5") {
		argumentArray[0] = frmObj.sql_ph_reports_atc5_lookup.value;
	}
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	retArray = CommonLookup( searchFor, argumentArray );
	if(retArray != null && retArray != "" ) {
		target.value = retArray[1];	
		if(target.name=="p_atc_from_id"){
			frmObj.p_atc_from.value=retArray[0];
		}
		else if(target.name=="p_atc_to_id"){
			frmObj.p_atc_to.value=retArray[0];	
		}
		target.focus();
	}
}*/

function callLocation(Obj){
	if(document.formPhDrugUsageByPractCriteria.p_facility_code.value!=""){
		document.formPhDrugUsageByPractCriteria.pract_search.disabled=false;
		document.formPhDrugUsageByPractCriteria.tpract_search.disabled=false;
		document.formPhDrugUsageByPractCriteria.p_job_title.disabled=false;
	}
	else{
		document.formPhDrugUsageByPractCriteria.pract_name.value='';
		document.formPhDrugUsageByPractCriteria.pract_search.disabled=true;
		document.formPhDrugUsageByPractCriteria.tpract_name.value='';
		document.formPhDrugUsageByPractCriteria.tpract_search.disabled=true;
		document.formPhDrugUsageByPractCriteria.p_job_title.value='';
		document.formPhDrugUsageByPractCriteria.p_job_title.selectedIndex=0;
		document.formPhDrugUsageByPractCriteria.p_job_title.disabled=true;
	}
}

function callATC(Obj){
	if(document.formPhDrugUsageByPractCriteria.p_atc_level.value!="ALL"){
		document.formPhDrugUsageByPractCriteria.narrationFrom.disabled=false;
		document.formPhDrugUsageByPractCriteria.narrationTo.disabled=false;
		document.formPhDrugUsageByPractCriteria.p_atc_from_id.value='';
		document.formPhDrugUsageByPractCriteria.p_atc_to_id.value='';
		document.formPhDrugUsageByPractCriteria.p_atc_level.disabled=false;
	}
	else{
		document.formPhDrugUsageByPractCriteria.p_atc_from.value='';
		document.formPhDrugUsageByPractCriteria.p_atc_from_id.value='';
		document.formPhDrugUsageByPractCriteria.narrationFrom.disabled=true;
		document.formPhDrugUsageByPractCriteria.p_atc_to.value='';
		document.formPhDrugUsageByPractCriteria.p_atc_to_id.value='';
		document.formPhDrugUsageByPractCriteria.narrationTo.disabled=true;
		document.formPhDrugUsageByPractCriteria.p_atc_level.value="ALL";
		document.formPhDrugUsageByPractCriteria.p_atc_level.selectedIndex=0;
		//document.formPhDrugUsageByPractCriteria.p_atc_level.disabled=true;
	}
}

function validate_date(Obj,ref) {
	if(document.forms[0].dt_from1.value=='' || document.forms[0].dt_to1.value==''){ 
		return false;
	}
	else{
		if(!isBefore(document.forms[0].dt_from1.value,document.forms[0].dt_to1.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			alert(errors);
			return false;
		}
	}
	return true;
}

function DateCheck(from,to) {
    if(from.value=="" || to.value==""){ 
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(errors);
			return false;
		}
	}
	return true;
}

async function search1(target ,mode) {
	
	var frmObj= document.formPhDrugUsageByPractCriteria;
	var lan_id=frmObj.p_language_id.value;
	if(mode == "1"){
	
		frmObj.p_atc_from_id.value='';
		frmObj.p_atc_from.value='';
	}
	if(mode == "2"){
		var frmObj= document.formPhDrugUsageByPractCriteria;
		frmObj.p_atc_to_id.value='';
		frmObj.p_atc_to.value='';
	}	
	var searchFor = frmObj.p_atc_level.value;

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var retArray 		= new Array() ;

	if (searchFor == "") {
		alert(getLabel("ePH.ATCLevelmustbeselected.label","PH"));
		return false;
	}
	else if (searchFor == "ATC1") {
		//var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
		argumentArray[0] = document.getElementById("sql_ph_reports_atc1_lookup").value+"'"+lan_id+"'";
				
	}
	else if (searchFor == "ATC2") {
		//var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
		argumentArray[0] = f_query_add_mod.document.getElementById("sql_ph_reports_atc2_lookup").value+"'"+lan_id+"'";
	}
	else if (searchFor == "ATC3") {
	//	var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
		argumentArray[0] = f_query_add_mod.document.getElementById("sql_ph_reports_atc3_lookup").value+"'"+lan_id+"'";
	}
	else if (searchFor == "ATC4") {
	//	var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
		argumentArray[0] = f_query_add_mod.document.getElementById("sql_ph_reports_atc4_lookup").value+"'"+lan_id+"'";
	}
	else if (searchFor == "ATC5") {
	//	var lan_id=f_query_add_mod.document.formPhDrugUsageByPractCriteria.Language_id.value;
		argumentArray[0] = f_query_add_mod.document.getElementById("sql_ph_reports_atc5_lookup").value+"'"+lan_id+"'";
	}
	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	retArray = await CommonLookup( searchFor, argumentArray );
	var ret1=unescape(retArray);
	var arr=ret1.split(",");		
	if(retArray != null && retArray != "" ) {
		target.value = arr[1];	
		if(target.name=="p_atc_from_id"){
			frmObj.p_atc_from.value=arr[0];
		}
		else if(target.name=="p_atc_to_id"){
			frmObj.p_atc_to.value=arr[0];	
		}
		target.focus();
	}
}

function clear1(obj){
	if(document.formPhDrugUsageByPractCriteria.p_job_title.value==""){
		document.formPhDrugUsageByPractCriteria.narrationFrom.disabled=false;
		document.formPhDrugUsageByPractCriteria.narrationTo.disabled=false;
		document.formPhDrugUsageByPractCriteria.pract_name.value='';
		document.formPhDrugUsageByPractCriteria.tpract_name.value='';
		document.formPhDrugUsageByPractCriteria.pract_id.value='';
		document.formPhDrugUsageByPractCriteria.tpract_id.value='';
	}
	else{
		document.formPhDrugUsageByPractCriteria.pract_name.value='';
		document.formPhDrugUsageByPractCriteria.tpract_name.value='';
		document.formPhDrugUsageByPractCriteria.pract_id.value='';
		document.formPhDrugUsageByPractCriteria.tpract_id.value='';
	}
}

