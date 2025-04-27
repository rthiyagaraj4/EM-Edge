/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
----------------------------------------------------------------------------------------------------------------------------------
Date      	 Edit History      Name        Description
----------------------------------------------------------------------------------------------------------------------------------           
26/05/2017    IN061962       Mukesh M    For MMS-DM-CRF-0093
										  
----------------------------------------------------------------------------------------------------------------------------------
-->
*/
/* MMS-DM-CRF-0093 starts*/ 

//This will call common patient search
function callPatientSearch(){
	var formObj=document.frames.frmPHPrescriptionPayer;
	var patient_id = PatientSearch();
	if (patient_id!= "" && patient_id != undefined){
		formObj.p_patient_id.value = patient_id;
		formObj.p_patient_id.disabled = false;
		formObj.btnPatientID.disabled = false;
		resetValues(); //Modified for MMS-DM-CRF-0093
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PhRepPrescriptionValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id, false ) ;
		xmlHttp.send( xmlDoc ) ;		
		eval(xmlHttp.responseText);
	}
}

function reset() {
	f_query_add_mod.document.frmPHPrescriptionPayer.reset();
	f_query_add_mod.document.frmPHPrescriptionPayer.p_patient_id.disabled=false;
	f_query_add_mod.document.frmPHPrescriptionPayer.btnPatientID.disabled=false;
}

function lockbackSpace()
{
	   var mode = document.mode.value;
	   if(mode=='modify' && window.event.keyCode==8)
	   	{
		   //return false;
	   	}
}


// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.frmPHPrescriptionPayer.p_language_id.value;
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

function Duplicatecheck(){   
	var patientId = document.frmPHPrescriptionPayer.p_patient_id.value;
	if((patientId.value != null) && (patientId.value !="")){
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId.value + "\" " ;	
		xmlStr+= "chkPatientID=\"true\" " ;	
		xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "QueryPatientDrugProfileValidation.jsp?func_mode=Duplicate&bean_id=" + bean_id + "&bean_name=" +bean_name+"&patientId="+patientId, false ) ;	
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);	
	}	
}

function encounterIdLookup()
{
var fieldLegend;
	fieldLegend = new Array() ;
	fieldLegend["CODE_LEGEND"] = "EncounterId"
	fieldLegend["DESC_LEGEND"] = "EpisodeId"
	var episodeType= document.frmPHPrescriptionPayer.p_episode_type.value;
	var partsql = '';
	if(episodeType == 'O' || episodeType == 'E'){
		partsql = "SELECT EPISODE_ID DESCRIPTION, ENCOUNTER_ID CODE FROM BL_VISIT_FIN_DTLS WHERE upper(EPISODE_ID) like upper(?) and upper(ENCOUNTER_ID) like upper(?) AND OPERATING_FACILITY_ID = ";
	}
	else{
		partsql = "SELECT EPISODE_ID DESCRIPTION, ENCOUNTER_ID CODE FROM bl_episode_fin_dtls WHERE upper(EPISODE_ID) like upper(?) and upper(ENCOUNTER_ID) like upper(?) AND OPERATING_FACILITY_ID = ";
	}
	var sql;
	sql											=	partsql+" '" +document.frmPHPrescriptionPayer.p_facility_id.value+ "'";
	var title									= 	getLabel("Common.encounterid.label", 'common');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
	var patientId								=	document.getElementById('p_patient_id').value; 
	
	if(patientId != undefined && patientId != null && patientId != '')
	{
		sql										=	sql+" AND PATIENT_ID ="+" '"+patientId+"'";
	}
	if(episodeType != undefined && episodeType != null && episodeType != '')
	{
		sql										=	sql+" AND EPISODE_TYPE ="+" '"+episodeType+"'";
	}
	var encounterId								=	document.getElementById('p_encounter_id');
	argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	encounterId.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		encounterId.value 						= 	retVal[0];
	}
	else
	{
		encounterId.value			  			=	"";	
	}    
}

function payerGroupLookup()
{	
	var sql;
	var facility_id = document.frmPHPrescriptionPayer.p_facility_id.value;
	var locale = document.frmPHPrescriptionPayer.p_language_id.value;
	var patientId								=	document.getElementById('p_patient_id').value;
	var episodeType= document.frmPHPrescriptionPayer.p_episode_type.value;
	var encounterID= document.frmPHPrescriptionPayer.p_encounter_id.value;
	if(patientId == null || patientId == undefined){
		patientId="";
	}
	if(episodeType==''){
		var	errors=getMessage("PH_EPISODE_TYPE","PH") ; //Modified For MMS-DM-CRF-0093
		alert(errors);
		document.frmPHPrescriptionPayer.payergroup.value=""; //Modified for MMS-DM-CRF-0093
		return false;
	}
	sql= "SELECT description, code FROM (SELECT long_desc description, cust_group_code code FROM ar_cust_group_lang_vw a WHERE status IS NULL AND EXISTS ( SELECT 1 FROM bl_cust_by_cust_group b WHERE a.cust_group_code = b.cust_group_code AND EXISTS ( SELECT 1 FROM ar_customer_lang_vw c WHERE c.cust_code = b.cust_code AND c.acc_entity_code IN ( SELECT acc_entity_code FROM sy_acc_entity WHERE acc_entity_id = '"+facility_id+"') AND UPPER (language_id) = UPPER ('"+locale+"') AND NVL (patient_flag, 'N') = 'Y' AND NVL (insurance_yn, 'N') = 'Y')) AND acc_entity_code IN (SELECT acc_entity_code FROM sy_acc_entity WHERE acc_entity_id = '"+facility_id+"') AND UPPER (language_id) = UPPER ('"+locale+"') AND ( ( '"+patientId+"' IS NOT NULL AND EXISTS ( SELECT 1 FROM bl_encounter_payer_priority d WHERE d.operating_facility_id = '"+facility_id+"' AND d.patient_id = '"+patientId+"' AND d.episode_type = '"+episodeType+"' AND d.cust_group_code = a.cust_group_code AND d.cust_code IS NOT NULL AND ( ( '"+episodeType+"' IN ('O', 'E') AND EXISTS ( SELECT 1 FROM bl_visit_fin_dtls e WHERE e.operating_facility_id = '"+facility_id+"' AND e.patient_id = '"+patientId+"' AND e.episode_type = '"+episodeType+"' AND e.encounter_id = d.encounter_id AND e.visit_id = d.visit_id AND e.cur_acct_seq_no = d.acct_seq_no) ) OR ( '"+episodeType+"' IN ('I', 'D') AND EXISTS ( SELECT 1 FROM bl_episode_fin_dtls f WHERE f.operating_facility_id = d.operating_facility_id AND f.patient_id = d.patient_id AND f.episode_type = d.episode_type AND f.encounter_id = d.encounter_id AND f.cur_acct_seq_no = d.acct_seq_no) ) OR ( '"+episodeType+"' IN ('R') AND d.episode_type = '"+episodeType+"' ) ) AND ( ( '"+encounterID+"' IS NOT NULL AND d.encounter_id = '"+encounterID+"' ) OR '"+encounterID+"' IS NULL )) ) OR ( '"+patientId+"' IS NULL AND '"+encounterID+"' IS NOT NULL AND EXISTS ( SELECT 1 FROM bl_encounter_payer_priority d WHERE d.encounter_id = '"+encounterID+"' AND d.cust_group_code = a.cust_group_code AND d.cust_code IS NOT NULL AND ( ( '"+episodeType+"' IN ('O', 'E') AND EXISTS ( SELECT 1 FROM bl_visit_fin_dtls e WHERE e.operating_facility_id = d.operating_facility_id AND e.patient_id = d.patient_id AND e.episode_type = d.episode_type AND e.encounter_id = d.encounter_id AND e.visit_id = d.visit_id AND e.cur_acct_seq_no = d.acct_seq_no) ) OR ( '"+episodeType+"' IN ('I', 'D') AND EXISTS ( SELECT 1 FROM bl_episode_fin_dtls f WHERE f.operating_facility_id = d.operating_facility_id AND f.patient_id = d.patient_id AND f.episode_type = d.episode_type AND f.encounter_id = d.encounter_id AND f.cur_acct_seq_no = d.acct_seq_no) ) OR ( '"+episodeType+"' IN ('R') AND d.episode_type = '"+episodeType+"' ) ) AND ( ( '"+encounterID+"' IS NOT NULL AND d.encounter_id = '"+encounterID+"' ) OR '"+encounterID+"' IS NULL )) ) OR ('"+patientId+"' IS NULL AND '"+encounterID+"' IS NULL) )) WHERE UPPER (description) LIKE UPPER (?) AND UPPER (code) LIKE UPPER (?) ORDER BY 2";
	var title									= 	getLabel("eBL.PAYER_GROUP.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
	var payerGroup								=	document.getElementById('payergroup'); 
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"2,1";
	argumentArray[5]   							= 	payerGroup.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		payerGroup.value 						= 	retVal[1];
		document.frmPHPrescriptionPayer.p_payergroup.value = retVal[0];
	}
	else
	{
		payerGroup.value			  			=	"";	
		document.frmPHPrescriptionPayer.p_payergroup.value = "";
	}    
}

function payerLookup()
{
	var sql;
	var facility_id = document.frmPHPrescriptionPayer.p_facility_id.value;
	var locale 	= document.frmPHPrescriptionPayer.p_language_id.value;
	var cust_code 	= document.frmPHPrescriptionPayer.p_payergroup.value;
	var episodeType	= document.frmPHPrescriptionPayer.p_episode_type.value;
	if(episodeType==''){
		var	errors=getMessage("PH_EPISODE_TYPE","PH") ;//Modified For MMS-DM-CRF-0093
		alert(errors);
		document.frmPHPrescriptionPayer.payer_code.value="";  //Modified for MMS-DM-CRF-0093
		return false;
	}
	if(cust_code==""){
		var	errors=getMessage("PH_PAYER_GRP","PH") ;//Modified For MMS-DM-CRF-0093
		alert(errors);
		return false;
	}
	sql = "SELECT description, code FROM (SELECT long_name description, cust_code code FROM ar_customer_lang_vw WHERE cust_code IN ( SELECT cust_code FROM bl_cust_by_cust_group WHERE cust_group_code = DECODE ('"+cust_code+"', '**', cust_group_code, '"+cust_code+"')) AND acc_entity_code IN (SELECT acc_entity_code FROM sy_acc_entity WHERE acc_entity_id = '"+facility_id+"') AND NVL (patient_flag, 'N') = 'Y' AND NVL (pat_com_flag, 'N') = 'N' AND NVL (insurance_yn, 'N') = 'Y' AND status IS NULL AND UPPER (language_id) = UPPER ('"+locale+"') ) WHERE UPPER (description) LIKE UPPER (?) AND UPPER (code) LIKE UPPER (?)";

	var title									= 	getLabel("Common.Payer.label", 'common');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
	var payer									=	document.getElementById('payer_code'); 
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"2,1";
	argumentArray[5]   							= 	payer.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		payer.value 							= 	retVal[1];
		document.frmPHPrescriptionPayer.p_payer_code.value = retVal[0];
	}
	else
	{
		payer.value			  					=	"";	
		document.frmPHPrescriptionPayer.p_payer_code.value = "";
	}   
}

function policyLookup()
{

	var sql;
	var facility_id 	= document.frmPHPrescriptionPayer.p_facility_id.value;
	var locale 		= document.frmPHPrescriptionPayer.p_language_id.value;
	var payer_group_code 	= document.frmPHPrescriptionPayer.p_payergroup.value;
	var payer_code       	= document.frmPHPrescriptionPayer.p_payer_code.value;
	var episodeType		= document.frmPHPrescriptionPayer.p_episode_type.value;
	if(episodeType==''){
		var	errors=getMessage("PH_EPISODE_TYPE","PH") ;//Modified For MMS-DM-CRF-0093 start
		alert(errors);
		document.frmPHPrescriptionPayer.policy_code.value="";//Modified For MMS-DM-CRF-0093 end
		return false;
	}
	if(payer_group_code==""){
		var	errors=getMessage("PH_PAYER_GRP","PH") ;//Modified For MMS-DM-CRF-0093
		alert(errors);///Modified For MMS-DM-CRF-0093 
		return false;
	}
	sql="SELECT long_desc description, policy_type_code code FROM bl_ins_policy_types_lang_vw a WHERE NVL (status, 'A') != 'S' AND operating_facility_id = '"+facility_id+"' AND UPPER (language_id) = UPPER ('"+locale+"') AND policy_type_code IN ( SELECT b.policy_type_code FROM bl_ins_policy_type_hdr b WHERE a.policy_type_code = b.policy_type_code AND cust_group_code = '"+payer_group_code+"' AND ( '"+payer_code+"' IS NULL OR ( '"+payer_code+"' IS NOT NULL AND cust_code = '"+payer_code+"') )) AND UPPER (long_desc) LIKE UPPER (?) AND UPPER (policy_type_code) LIKE UPPER (?) ORDER BY 2";

	var title									= 	getLabel("ePH.Policy.label", 'ph');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
	var policy									=	document.getElementById('policy_code'); 
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"2,1";
	argumentArray[5]   							= 	policy.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		policy.value 							= 	retVal[1];
		document.frmPHPrescriptionPayer.p_policy_code.value = retVal[0];
	}
	else
	{
		policy.value			  					=	"";
		document.frmPHPrescriptionPayer.p_policy_code.value = "";
	}    
}

function run(){
	var frmObject = f_query_add_mod.document.frmPHPrescriptionPayer;		
	var fields= new Array (frmObject.fm_ord_date,frmObject.to_ord_date);
	var names= new Array (getLabel("Common.from.label","Common"),getLabel("Common.to.label","Common"));		 
	var episodeType= frmObject.p_episode_type.value;
	var report_id="";
	var order_type = frmObject.order_type.value;
	if(episodeType==null || episodeType==undefined){
		episodeType="";
	}
	if(checkFields(fields,names,messageFrame)) { 
		
		if(episodeType==""){
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_EPISODE_TYPE_MSG","PH"); //Modified For MMS-DM-CRF-0093
			return false;
		}
		if(frmObject.payergroup.value=="" ) { 
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_PAYER_GRP_MSG","PH");////Modified For MMS-DM-CRF-0093
			return false;
	 	}
		if(!isBefore(frmObject.to_ord_date.value,frmObject.sys_date.value,"DMY",frmObject.p_language_id.value)) {
	 		 	var	errors=getMessage("TO_DATE_LESS_THAN_SYSDATE","PH") ;
				alert(errors);
				return false;
		}
		if(!isBefore(frmObject.fm_ord_date.value,frmObject.to_ord_date.value,"DMY",frmObject.p_language_id.value)) {
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
				alert(errors);
				return false;			
		 }
	 	var max_days=daysBetween(frmObject.fm_ord_date.value,frmObject.to_ord_date.value,"DMY",frmObject.p_language_id.value);
	 	if(max_days>31){
				var errors=getMessage('PH_MAX_DATE_DIFFERENCE','PH');//Modified For MMS-DM-CRF-0093
				alert(errors);
				return false;
	 	}
	 	if(order_type=="")
		{
			if(episodeType == 'I'||episodeType == 'D')
			{
				report_id="PHBOPPRS_IP";
			}
			else if (episodeType == 'O'||episodeType == 'E')
			{
				report_id = "PHBOPPRS";
			}
		}
		else if(order_type=="1" || order_type=="2" || order_type=="3" || order_type=="4" || order_type=="5")
		{
			report_id="PHPRDPRESIVCONT";
		}
	    else if(order_type=="6")
		{
			report_id="PHPRDPRESCOMP";
		}
		else if(order_type=="7" || order_type=="8")
		{
			report_id="PHBOPPTPN";
		}
		else if(order_type=="9" || order_type=="0" || order_type=="C"){
			report_id="PHBOPPCYTO";
		}
	 	
	frmObject.p_iv_prep_yn.value=order_type;
	frmObject.p_fm_ord_date.value =	frmObject.fm_ord_date.value;	
	frmObject.p_to_ord_date.value =	frmObject.to_ord_date.value;
	frmObject.p_report_id.value=report_id;
	var payer_name =frmObject.payer_code.value;//Added for MMS-DM-SCF-0502
	if(payer_name=="")//Added for MMS-DM-SCF-0502
		frmObject.p_payer_code.value="";//Added for MMS-DM-SCF-0502

	frmObject.payer_code.value="";//Added for MMS-DM-SCF-0502
	//f_query_add_mod.document.frmPHPrescriptionPayer.action="../../eCommon/jsp/report_options.jsp";//Removed For MMS-DM-CRF-0093 
	f_query_add_mod.document.frmPHPrescriptionPayer.submit();
	frmObject.payer_code.value=payer_name;//Added for MMS-DM-SCF-0502
	}
}
//Modified for MMS-DM-CRF-0093 start
function resetValues(status){	//status added for MMS-DM-CRF-0093
	var formObj	=document.frames.frmPHPrescriptionPayer;
	var patient_id 	=formObj.p_patient_id.value;
	var payergroup 	=formObj.payergroup.value;	
	//else {   //Commented for MMS-DM-CRF-0093
		if(payergroup !="" && (status==undefined || status!="Y")){	// (status==undefined || status!="Y") added for MMS-DM-CRF-0093 //patient_id removed for MMS-DM-CRF-0093
			formObj.payer_code.value = "";
			formObj.policy_code.value = "";
		}
		else if(payergroup !="" && status=="Y"){//alert("payergroup"); Commented for MMS-DM-CRF-0093
		formObj.order_type.value = "";
		formObj.p_episode_type.value = "";
		formObj.p_encounter_id.value = "";
		formObj.payergroup.value = "";
		formObj.payer_code.value = "";
		formObj.policy_code.value = "";

	}
//	}	
	
	 
}
/*MMS-DM-CRF-0093 ends*/

