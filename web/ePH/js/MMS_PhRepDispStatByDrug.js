
function run() {
	var frmObject = f_query_add_mod.document.formPhRepDispStatByDrugCriteria;
	var locale=frmObject.p_language_id.value;
	if(frmObject.p_dt_from.value==""){ 
		var msg=getLabel("ePH.ConsumptionDateFrom.label","PH")+" "+getLabel("Common.Cannotbeblank.label","PH");
		alert(msg);
		frmObject.p_dt_from.focus();
		return false;
	}
	else if(frmObject.p_dt_to.value==""){
		var msg=getLabel("ePH.Consumption.label","PH")+" "+getLabel("Common.DateTo.label","PH")+" "+getLabel("Common.Cannotbeblank.label","PH");
		alert(msg);
		frmObject.p_dt_to.focus();
		return false;
	}
	else if(f_query_add_mod.document.formPhRepDispStatByDrugCriteria) {
		var fields= new Array (frmObject.P_Report_By);
		var names= new Array (getLabel("Common.ReportBy.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_dt_from, f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_dt_to, messageFrame )){ 
				if(frmObject.P_Report_By.value=="PC"||frmObject.P_Report_By.value=="SO")
					frmObject.p_report_id.value="PHRDSBYDRPL";
				else
					frmObject.p_report_id.value="PHRDSBYDR";
				frmObject.dt_from.value=convertDate(frmObject.p_dt_from.value,'DMY',locale,"en");
				frmObject.dt_to.value=convertDate(frmObject.p_dt_to.value,'DMY',locale,"en");
				f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_drug_name.value="";//Added for MMS_ADHOC_0028
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.formPhRepDispStatByDrugCriteria.submit();
				f_query_add_mod.document.formPhRepDispStatByDrugCriteria.drug_code.value="";//Added for MMS_ADHOC_0028
			}
		}
	}
}

function reset() {
    f_query_add_mod.formPhRepDispStatByDrugCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	f_query_add_mod.document.getElementById('changelabel').innerText="";
	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_patient_id.value="";
	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_pract_id.value="";
	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_Locn_code.value="";
	//f_query_add_mod.document.getElementById('atc_drug_text').style.display='block';
	//f_query_add_mod.document.getElementById('atc_drug_but').style.display='block';
	//f_query_add_mod.document.getElementById('P_DRUG_CLASS').style.display='none';
	//f_query_add_mod.document.getElementById('drug_class1').style.display='none';
	f_query_add_mod.document.getElementById('pat_text').style.display='none';
	f_query_add_mod.document.getElementById('fld_drug_class').style.display='none';
	f_query_add_mod.document.getElementById('lbl_drug_class').style.display='none';
	f_query_add_mod.document.getElementById('lbl_ATC_level').style="display";
	f_query_add_mod.document.getElementById('fld_ATC_level').style="display";
	f_query_add_mod.document.getElementById('Locn_text').style.display='none';
}

async function callPatientSearch(target){
	var patient_id =await PatientSearch();
	if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;		
	}
}

async function CustomerGroupSearch(target){ 
	var frmObject = parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var lan_id=frmObject.p_language_id.value;
	var customer_group_query="SELECT  CUST_GROUP_CODE CODE,SHORT_DESC DESCRIPTION FROM AR_CUST_GROUP_LANG_VW WHERE upper(CUST_GROUP_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) AND LANGUAGE_ID=";
	argumentArray[0] = customer_group_query+"'"+lan_id+"' ORDER BY 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] =target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( getLabel("ePH.CustomerGroup.label","PH"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "") {
		frmObject.p_customer_group.value = arr[1];
		frmObject.P_CUST_GROUP_CODE.value = arr[0];
	}
}

async function CustomerSearch(target){
	var frm_obj = parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var lan_id=frm_obj.p_language_id.value;
	var customer_query="SELECT CUST_CODE CODE,SHORT_NAME DESCRIPTION FROM AR_CUSTOMER_LANG_VW WHERE upper(CUST_CODE) like upper(?) and upper(SHORT_NAME) like upper(?) AND LANGUAGE_ID=";//added for MMS CRF-0105 end
	argumentArray[0] = customer_query+"'"+lan_id+"' ORDER BY 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( getLabel("Common.Customer.label","PH"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "") {
		frm_obj.p_customer.value = arr[1];
		frm_obj.P_CUST_CODE.value = arr[0];
	}
}

function changeLegend(){ 
	var formObj=document.formPhRepDispStatByDrugCriteria;

	if(formObj.P_Report_By.value=='PA'){
		label = getLabel("Common.patientId.label","Common");
		document.getElementById('changelabel').innerText=label;	
	}
	else if(formObj.P_Report_By.value=='SO'){
		label = getLabel("Common.Location.label","Common");
		document.getElementById('changelabel').innerText=label;
	}
	else if(formObj.P_Report_By.value=='PC'){
		label = getLabel("Common.practitioner.label","Common");
		document.getElementById('changelabel').innerText=label;
	}
		else{
		document.getElementById('changelabel').innerText="";
	}
	parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_patient_id.value="";
	parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_pract_id.value="";
	parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_Locn_code.value="";
	parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_pract_desc.value="";
	parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_locn_desc.value="";
	parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_ordering_locn.value="";
}


function ReportSearch(obj){
	var type=obj.value;
	var formObj = parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_patient_id;
	if(type=='PA'){
		callPatientSearch(formObj);
	}
	else if(type=='PC'){
		searchPractitionerName(formObj);
	}
	else if(type=='SO'){
		searchLocation(formObj);
	}
}

async function searchLocation(target) {
	var formObj = parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria;
	var lan_id=formObj.p_language_id.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var location_query="select code, description,facility_id,eff_status,language_id from (SELECT clinic_code code, long_desc description,facility_id,eff_status,language_id,clinic_type  FROM op_clinic_lang_vw op_clinic   UNION  SELECT nursing_unit_code code, long_desc description,facility_id,eff_status,language_id,'C' clinic_type  FROM ip_nursing_unit_lang_vw ip_nursing_unit)WHERE  UPPER (facility_id) LIKE UPPER (?)   AND UPPER (code) LIKE UPPER (?)   AND UPPER (description) LIKE UPPER (?) AND eff_status = 'E' AND clinic_type ='C'  AND language_id =";
	dataNameArray[0]   = "FACILITY_ID" ;
	dataValueArray[0]  = formObj.p_facility_id.value;
	dataTypeArray[0]   = STRING ;
	argumentArray[0]   =location_query+"'"+lan_id+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	var retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" )  {
		formObj.p_locn_desc.value = arr[1] ;
		formObj.p_patient_id.value = arr[1] ;
		formObj.p_Locn_code.value = arr[0] ;
	}	
}

async function callAssociateATC(){
	var formObj = parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria;
	var dialogHeight= "90vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop = "60" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal =await window.showModalDialog("../../ePH/jsp/ATCClassificationFrames.jsp?called_from=generic_atc&mode="+MODE_INSERT,arguments,features);
	var val="";
	var atccode="";
	var atcname="";
	if(retVal!="cancel" && retVal!=undefined){
		val=retVal.split("|");
		for(var i=0;i<val.length;i=i+2){
			if(val[i]!=undefined && val[i]!=="" &&val[i]!=" "){
				atccode=val[i];
				atcname=val[i+1];
			}
		}
	}
	formObj.p_ATC_class_desc.value=atcname;
	formObj.p_atc_level.value=atccode;
}

function displayfields(){   
	var formObj = parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria;
	if(formObj.P_Report_By.value!=""){
		document.getElementById('pat_text').style="display";
	}
	else{
		document.getElementById('pat_text').style.display='none';
	}
		

	if(formObj.p_drug.value=="ATC"){
		document.getElementById('lbl_ATC_level').style="display";
		document.getElementById('fld_ATC_level').style="display";
		document.getElementById('lbl_drug_class').style.display='none';
		document.getElementById('fld_drug_class').style.display='none';
		formObj.P_DRUG_CLASS.value="";
	}
	else{
		parent.f_query_add_mod.document.getElementById('lbl_ATC_level').style.display='none';
		parent.f_query_add_mod.document.getElementById('fld_ATC_level').style.display='none';
		parent.f_query_add_mod.document.getElementById('lbl_drug_class').style="display";
		parent.f_query_add_mod.document.getElementById('fld_drug_class').style="display";
		formObj.p_ATC_class_desc.value="";
		formObj.p_atc_level.value="";
	}
	if(formObj.p_Ordering_Location.value=="A"){
		document.getElementById('Locn_text').style.display='none';
	}
	else{
		document.getElementById('Locn_text').style="display";
	}
}
async function searchPractitionerName(target) {
	var formObj = parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var pract_query="SELECT PRACTITIONER_ID CODE,PRACTITIONER_NAME  DESCRIPTION FROM AM_PRACTITIONER WHERE UPPER(PRACTITIONER_ID) LIKE UPPER(?)  AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND EFF_STATUS='E' ORDER BY 2";
	argumentArray[0]   =pract_query;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	var retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" ){
		formObj.p_pract_desc.value = arr[1];
		formObj.p_patient_id.value = arr[1] ;
		formObj.p_pract_id.value = arr[0];
	}
}

async function SearchDrugForm(){
	var formObj = parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var lan_id=formObj.p_language_id.value;
	var drug_form_query="SELECT FORM_CODE CODE, FORM_DESC DESCRIPTION FROM PH_FORM_LANG_VW PH_FORM WHERE EFF_STATUS='E' and upper(FORM_CODE) like upper(?) and upper(FORM_DESC) like upper(?) AND LANGUAGE_ID =";
	argumentArray[0]   = drug_form_query+"'"+lan_id+"' ORDER BY 2";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.p_form_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 	
	retVal =await CommonLookup(getLabel("ePH.Form.label","PH"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" )  {
		formObj.p_form_desc.value = arr[1] ;
		formObj.P_FORM_CODE.value = arr[0];
	}
}

async function callDrugSearch(obj) {
	var arrCodeDesc =await DrugSearch("D",obj);
	var str =unescape(arrCodeDesc);
	var arr = str.split(",");
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria.drug_code.value	=	arr[0]; 
		parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_drug_name.value =	arr[1]; 
	}
}
async function searchCodeDispenseLocation(obj) {
	var formObj = parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]  = "facility_id";
	dataValueArray[0]  = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.forms[0].disp_locn_sql_select1.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.forms[0].locale.value;
	dataTypeArray  [1]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("ePH.DispenseLocation.label","ph"), argumentArray );
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if((returnedValues != null) && (returnedValues != "") )  {
	 		obj.value = arr[1];
			formObj.P_DISP_LOCN_CODE.value = arr[0];
	} 
}
function LocationSearch(obj){
	var type=obj.value;
	var formObj = parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria.p_ordering_locn;
	if(type=='N'){
		searchNursingUnit(formObj);
	}
	else if(type=='C'){
		searchClinic(formObj);
	}
}
async function searchClinic(obj) {
	var formObj = parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]  = "facility_id";
	dataValueArray[0]  = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.forms[0].clinic_sql_select1.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.forms[0].locale.value;
	dataTypeArray  [1]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("Common.clinic.label","common"), argumentArray );
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if((returnedValues != null) && (returnedValues != "") )  {
			obj.value = arr[1];
			formObj.P_CLINIC_CODE.value = arr[0];
	} 
}
async function searchNursingUnit(obj) {
	var formObj = parent.f_query_add_mod.document.formPhRepDispStatByDrugCriteria;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]  = "facility_id";
	dataValueArray[0]  = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.forms[0].nursing_unit_sql_select1.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.forms[0].locale.value;
	dataTypeArray  [1]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues =await CommonLookup(getLabel("Common.nursingUnit.label","common"), argumentArray );
	var str =unescape(returnedValues);
	var arr = str.split(",");
	if((returnedValues != null) && (returnedValues != "") )  {
			obj.value = arr[1];
			formObj.P_NUR_UNIT_CODE.value = arr[0];
	} 
}
