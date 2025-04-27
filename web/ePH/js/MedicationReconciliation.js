/*
---------------------------------------------------------------------------------------------------------------
Date       	Edit History            Name        		             Description
---------------------------------------------------------------------------------------------------------------
28/05/2019	IN:067951	            Devindra			              MMS-KH-CRF-0016
18/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
06/08/2020  IN073464  		        Prabha		                  	 SKR-SCF-1394
---------------------------------------------------------------------------------------------------------------
*/
function reset() {
	document.frmMedicationReconciliationCriteria.reset();
}

function validateDate1(locale) {
	var from	=	document.frmMedicationReconciliationCriteria.order_date_from.value;
	var to		=	document.frmMedicationReconciliationCriteria.order_date_to.value;
	
	if(from==""){ // Added for INC#70594
		alert(getMessage("PH_ORD_DATE_FM_TO_NOT_BLANK", "PH"));
		document.frmMedicationReconciliationCriteria.order_date_from.focus();	
	}
	else if(to==""){
		alert(getMessage("PH_ORD_DATE_FM_TO_NOT_BLANK", "PH"));
		document.frmMedicationReconciliationCriteria.order_date_to.focus();	
	}
	else if(!isBefore(from,to,'DMY',locale)){
		alert(getMessage("TO_DATE_EQUAL_GREATER_FROM_DATE", "PH"));
		document.frmMedicationReconciliationCriteria.order_date_to.focus();
	}
	else {
		showMedicationRecResults(); 
	}
}

function showMedicationRecResults(){
	var patient_id	 =	document.frmMedicationReconciliationCriteria.patient_id.value;
	var encounter_id =	document.frmMedicationReconciliationCriteria.encounter_id.value;
	var dt_from	=	document.frmMedicationReconciliationCriteria.order_date_from.value;
	var dt_to   =	document.frmMedicationReconciliationCriteria.order_date_to.value;
	var patient_age = document.frmMedicationReconciliationCriteria.patient_age.value;
    var gender      = document.frmMedicationReconciliationCriteria.gender.value;
    var patient_name = document.frmMedicationReconciliationCriteria.patient_name.value;
    var pat_class    = document.frmMedicationReconciliationCriteria.patient_class.value;
    var ord_status   = document.frmMedicationReconciliationCriteria.ord_status.value;
    var rx_type      = document.frmMedicationReconciliationCriteria.iv_prep_yn.value;
    var log_pract_id = document.frmMedicationReconciliationCriteria.log_pract_id.value;
    var pract_id     = document.frmMedicationReconciliationCriteria.pract_id.value;
    var discharge_ind = document.frmMedicationReconciliationCriteria.discharge_ind.value; // discharge_ind Added for #70618
	parent.parent.med_reconc_results.location.href="../../ePH/jsp/MedicationReconciliationResultFrame.jsp?&patient_id="+patient_id+"&encounter_id="+encounter_id+"&dt_from="+dt_from+"&dt_to="+dt_to+"&patient_age="+patient_age+"&gender="+gender+"&patient_name="+patient_name+"&pat_class="+pat_class+"&ord_status="+ord_status+"&rx_type="+rx_type+"&log_pract_id="+log_pract_id+"&pract_id="+pract_id+"&discharge_ind="+discharge_ind; // discharge_ind Added for #70618
	
}

function objClick(pat_class,ord_status,order_from,order_to,patient_id,encounter_id,rx_type,log_pract_id,pract_id,discharge_ind,called_by){ // discharge_ind Added for #70618, called_by added for Inc#70652
		document.getElementById("ExternalDrugProfile_link").className = "tabA";
		document.getElementById("DrugProfile_link").className = "tabClicked";
		document.getElementById("ExternalDrugProfile_link_aspan").className = "tabAspan";
		document.getElementById("DrugProfile_link_aspan").className = "tabSpanclicked";
		
		var called_from = "Previous";
		
		showPrevOrdersResultsInReconciliation(pat_class,ord_status,order_from,order_to,patient_id,encounter_id,rx_type,log_pract_id,pract_id,discharge_ind,called_by); // discharge_ind Added for #70618, called_by added for Inc#70652
		
		callButtonFrame(called_from);

}

function objClick1(patient_id,encounter_id,dt_from,dt_to,log_pract_id){ // pat_class,encounter_id added for AAKH-CRF-0088.2//Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4
		
	parent.f_query_result1.location.href="../../ePH/jsp/MedicationReconciliationExternalDrugResult.jsp?patient_id="+patient_id+"&dt_from="+dt_from+"&dt_to="+dt_to+"&encounter_id="+encounter_id+"&log_pract_id="+log_pract_id;
	
	document.getElementById("DrugProfile_link").className = "tabA";
	document.getElementById("ExternalDrugProfile_link").className = "tabClicked";
	document.getElementById("DrugProfile_link_aspan").className = "tabAspan";
	document.getElementById("ExternalDrugProfile_link_aspan").className = "tabSpanclicked";
	
	var called_from = "External";
	
	callButtonFrame(called_from);
 }

function callButtonFrame(called_from){
	
	parent.parent.med_reconc_buttons.location.href   = "../../ePH/jsp/MedicationReconciliationButtons.jsp?&called_from="+called_from;
}

function copiedDrugs1(called_from) {
	
	if(called_from == "Previous")
		frmObj	=	parent.med_reconc_results.f_query_result1.document.frmPrescriptionPrevOrdersResult1;
	else
		frmObj	=	parent.med_reconc_results.f_query_result1.document.frmExternalOrdersResult1;
		
	
	if(frmObj == undefined){
		alert(getMessage("PH_ATLEAST_ONE_SELECTED","PH")); // =====Removed the comment on this line===========
		return;	
	}
	var bean_id			=	frmObj.bean_id;
	var bean_name		=	frmObj.bean_name;
	var flag = 0;
	if(bean_id == undefined && bean_name==undefined){
		alert(getMessage("PH_ATLEAST_ONE_SELECTED","PH")); // =====Removed the comment on this line===========
		return;
    }
	var arrObj	= frmObj.elements;
	var iv_prep_yn ="";
	var ord_id = "";
	var chk_obj_name = "";
	var discont = "";
	var answer = "";
	var call_from = "Copy";
	
	for(var i=0;i<arrObj.length;i++){
		if((arrObj[i].type=="checkbox")){
				if (arrObj[i].checked==true){
				flag=1;
				names	=	arrObj[i].name.split(",");
				ord_id=names[0];
					iv_prep_yn = "";//eval("parent.f_prev_orders_results.document.frmPrescriptionPrevOrdersResult1.iv_prep_yn"+ord_id).value;
			   }
		}
	}
	if(flag == 0 || frmObj.checkcount.value=='0'){
		alert(getMessage("PH_ATLEAST_ONE_SELECTED","PH"));
		return;
	} 
	
if(called_from == "Previous"){	
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id.value + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name.value + "\" " ;
	xmlStr+= "iv_prep_yn=\"" + iv_prep_yn+ "\" " ;
	xmlStr+= "order_id=\"" + ord_id+ "\" " ;
	xmlStr+= "answer=\"" + answer+ "\" " ; 
	xmlStr+= "call_from=\"" + call_from+ "\" " ;
	xmlStr+= "called_from=\"" + "Copy"+ "\" " ; 
	xmlStr +=" /></root>";
	var temp_jsp="PrescriptionValidation_2.jsp?func_mode=copied_drugs";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);	
	
	parent.med_reconc_criteria.document.frmMedicationReconciliationCriteria.reconciliation_done_yn.value='Y'; //SKR-SCF-1394
}
else{   
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id =\"" + bean_id.value + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name.value + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PrescriptionValidation_2.jsp?func_mode=RecExternal";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;	
		eval(responseText);
	}
}

function showPrevOrdersResultsInReconciliation(pat_class,ord_status,order_from,order_to,patient_id,encounter_id,rx_type,log_pract_id,pract_id,discharge_ind,called_by){ // discharge_ind Added for #70618, called_by added for Inc#70652
	
	parent.parent.document.getElementById('discharerows').rows = '22%,70%,7%,0%';

	if(order_from=="" || order_to=="") {
		alert(getMessage("PH_ORD_DATE_FM_TO_NOT_BLANK", "PH"));
	} 
	else {
		
		parent.f_query_result1.location.href = "../../ePH/jsp/MedicationReconciliationPreviousOrdersResult.jsp?pat_class="+pat_class+"&ord_status="+ord_status+"&order_from="+order_from+"&order_to="+order_to+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&rx_type="+rx_type+"&log_pract_id="+log_pract_id+"&pract_id="+pract_id+"&discharge_ind="+discharge_ind+"&call_from=SEARCH"+"&called_by="+called_by; // discharge_ind Added for #70618, called_by added for Inc#70652
	}
}

function checkDuplicate1(obj,priv,called_from) { 
	
	obj_code	=	obj.value;
	
	var frmObj = "";
	
	if(called_from=="Previous"){
		frmObj=document.frmPrescriptionPrevOrdersResult1;
	}
	else{
		frmObj=document.frmExternalOrdersResult1;
	}
	
	var arrObj	= frmObj.elements;
	var end_date;     // Added for #70618 - Start
	var chk_obj_name;
	var end_date_obj; // Added for #70618 - End
	var drug_code;
	var ord_status_obj; // Added for #70618
	var discont;    // Added for #70618
	if(priv == "N"){
		alert(getMessage("INSUFFICIENT_PRIVILEGE_FOR_ORDERING_THE_DRUG","PH"));
		return false;
	}

	if(obj.checked==true) {
	  if(called_from=="Previous"){ // Added for #70618 - Start
		for(var i=0; i<arrObj.length; i++) {
			if(arrObj[i].type=="hidden"){
				end_dates	=	arrObj[i].name.split(",");
				if(end_dates.length>2) {
					chk_obj_name = end_dates[0]+","+end_dates[1];
					if(obj.name==chk_obj_name && end_dates[2]=="end_date"){
						end_date = arrObj[i].value; 
	
						for(var j=0; j<arrObj.length; j++) {
							if(arrObj[j].type=="hidden"){
								discont	=	arrObj[j].name.split(",");
								if(discont.length>2) {
									chk_obj_name = discont[0]+","+discont[1];
									if(obj.name==chk_obj_name && discont[2]=="ord_status"){
										ord_status_obj = arrObj[j].value;
										break;
									}
								}
							}
						} 
						checkCurrentMedn(frmObj.system_date.value,end_date,end_dates[0],end_dates[1],ord_status_obj);
						break;
					}
				} 
			}
		}
	 } // Added for #70618 - End
	
		for(var i=0;i<arrObj.length;i++) {
			if(arrObj[i].type=="checkbox"){					
				drug_code	=	arrObj[i].value;
				 if( (arrObj[i].name!=obj.name) && obj_code==drug_code ){
					 arrObj[i].disabled=true;
				 }
			}
		}
		
		frmObj.checkcount.value=parseInt(frmObj.checkcount.value)+1;
	} 
	else {
		for(var i=0;i<arrObj.length;i++) {
			if(arrObj[i].type=="checkbox"){
				drug_code	=	arrObj[i].value;
				 if( (arrObj[i].name!=obj.name) && obj_code==drug_code){
					 arrObj[i].disabled=false;
				 }
			}
		}
		frmObj.checkcount.value=parseInt(frmObj.checkcount.value)-1;
	}
	storeChecked1(obj,called_from);
	return true;
}

function storeChecked1(obj,called_from) {

	var frmObj = "";
	
	if(called_from=="Previous"){
		frmObj=document.frmPrescriptionPrevOrdersResult1;
	}
	else{
		frmObj=document.frmExternalOrdersResult1;
	}
	
 if(called_from=="Previous"){
	keys		=	(obj.name).split(",");
	order_id	=	keys[0];
	order_line	=	keys[1];
	if(obj.checked){
		chk_status	=	"Y";
	} else {
		chk_status	=	"N";
	}

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "order_id  =\"" + order_id+ "\" " ;
	xmlStr+= "order_line =\"" + order_line + "\" " ;
	xmlStr+= "drug_code =\"" + obj.value + "\" " ;
	xmlStr+= "chk_status  =\"" + chk_status + "\" " ;
	xmlStr+= "bean_id =\"" + frmObj.bean_id.value + "\" " ;
	xmlStr+= "bean_name=\"" + frmObj.bean_name.value + "\" " ;
	xmlStr +=" /></root>";

	 var temp_jsp="PrescriptionValidation_1.jsp?func_mode=copy_orders";
	 var xmlDoc = "" ;
	 var xmlHttp = new XMLHttpRequest() ;
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	 xmlHttp.open("POST",temp_jsp,false);
	 xmlHttp.send(xmlDoc);
	 responseText=xmlHttp.responseText ;

	 eval(responseText);
}
else{
	if(obj.checked){
		chk_status	=	"Y";
	} else {
		chk_status	=	"N";
	}
	var name=obj.name;//added for IN070786
	var name1=name.split(",");//added for IN070786
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "drug_code =\"" + obj.value + "\" " ;
	xmlStr+= "srl_no =\"" + name1[1] + "\" " ;//added for IN070786
	xmlStr+= "chk_status  =\"" + chk_status + "\" " ;
	xmlStr+= "bean_id =\"" + frmObj.bean_id.value + "\" " ;
	xmlStr+= "bean_name=\"" + frmObj.bean_name.value + "\" " ;
	xmlStr +=" /></root>";

	 var temp_jsp="PrescriptionValidation_1.jsp?func_mode=copy_orders_external";
	 var xmlDoc = "" ;
	 var xmlHttp = new XMLHttpRequest() ;
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	 xmlHttp.open("POST",temp_jsp,false);
	 xmlHttp.send(xmlDoc);
	 responseText=xmlHttp.responseText ;
}
}

function returnDrugs(drugs,order_id,mode){
  if(mode=="RecExternal"){
	top.window.returnValue = drugs+"!,"+mode;
  }
  else{
	  top.window.returnValue = drugs+order_id+","+mode;
  }
  
  window.close();  
}

function discCancelOrders(obj){
	
	var frmObj=document.frmPrescriptionPrevOrdersResult1;
	
	var pract_id = frmObj.pract_id.value;
	var encounter_id = frmObj.encounter_id.value;
	var patient_id = frmObj.patient_id.value;
	
	names	=	obj.name.split(",");
	var order_status = names[0];
	var drug_code = names[1];
	var pres_drug_code = names[1];
	var pres_generic_id  = names[2];
	var order_id = names[3];
	var order_line_no = names[4];
	
	
	var disc_vals="", cancel_vals = "",clearDupYN="N";
	
	if(order_status >= 25){
		if(disc_vals !="")
			disc_vals=disc_vals+"^"+order_id+"~"+pract_id+"~"+drug_code+"~"+order_line_no+"~"+pres_drug_code+"~"+pres_generic_id;
		else	
			disc_vals=order_id+"~"+pract_id+"~"+drug_code+"~"+order_line_no+"~"+pres_drug_code+"~"+pres_generic_id; 
	}
	else if(order_status < 25){
		if(cancel_vals != "")
			cancel_vals=cancel_vals+"^"+order_id+"~"+pract_id+"~"+drug_code+"~"+order_line_no+"~"+pres_drug_code+"~"+pres_generic_id; 
		else
			cancel_vals=order_id+"~"+pract_id+"~"+drug_code+"~"+order_line_no+"~"+pres_drug_code+"~"+pres_generic_id; 
	}
	
	var retVal = recordDiscCanValue(disc_vals,cancel_vals, patient_id,pres_generic_id,encounter_id, clearDupYN );
	
	
	if(retVal=='true'){
		updateCurrentRx(patient_id, encounter_id, pres_generic_id);
		parent.f_query_result.previousOrders.onclick();
	}
}

//added for IN070786 start
function ExternalDrug(obj){
	var formobj=document.frmExternalOrdersResult1;
	var formobjqry=parent.parent.med_reconc_criteria.frmMedicationReconciliationCriteria;
	if(obj.checked){
			
		formobj.ADDDRUGS.disabled=true;
		obj.value="Y";
	}
	else{
		formobj.ADDDRUGS.disabled=false;
		obj.value="N";
	}
	if(obj.checked){
		chk_status	=	"Y";
	} 
	else {
		chk_status	=	"N";
	}
	bean_id="@PrescriptionBean_1";
	bean_name="ePH.PrescriptionBean_1";
	
	formobjqry.no_ext_drug1.value=obj.value;
	
	
	
}

async function AddDrugsPage(patient_id){
	var url="../../ePH/jsp/QueryPatientDrugProfileExternalDrug.jsp?patient_id="+patient_id;
	var dialogHeight  = "900vh" ;
    var dialogWidth = "800vw" ;
	var dialogTop	= '210';
	var dialogLeft = '8' ;

	var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=no; status=no;";
    var reportURL   = await window.showModalDialog( url, arguments, features ) ;
	onSuccess(patient_id);
	parent.f_query_result.location.href=parent.f_query_result.location.href;
	 //parent.f_query_result1.location.href="../../ePH/jsp/MedicationReconciliationExternalDrugResult.jsp?patient_id="+patient_id;
}
function onSuccess(patient_id){
	 parent.f_query_result.location.href="../../ePH/jsp/MedicationReconciliationExternalDrugResult.jsp?patient_id="+patient_id;
	 
	 
}

function AddDrugRecord(){
		
	var formObj = parent.parent.document.PatientExternalDrug;
	var patient_id=formObj.patient_id.value;
	if(formObj.drug_desc.value==""){
	  alert(getMessage("DRUG_CANT_BE_BLANK","PH")); 
	  return;
	}
 	//commented for IN070786
	/*else if (formObj.pract_name.value == "") {
		alert(getMessage("PH_PRACT_NAME_CANT_RIGHTS", "PH"));
		return;
	}*/
	else if(formObj.dt_from.value==""){			
	   alert(getMessage("PH_START_DATE","PH")); 
		return;
		
	}
	else if(formObj.Instructions.value==""){
		alert(getMessage("PH_INST_CANT_RIGHTS","PH"));
		 return;
	}
	var mode=formObj.mode.value;
	eval(formApply(formObj,PH_CONTROLLER ));
	if( result ) {
		alert(getMessage("RECORD_INSERTED","PH"))
		window.close();
	}
}
function ExternalDrugInsert(){
	var formobj	=	document.frmMedicationReconciliationCriteria;
	var no_ext_drug=formobj.no_ext_drug.value;
	var no_ext_drug1=formobj.no_ext_drug1.value;
	var reconciliation_done_yn=formobj.reconciliation_done_yn.value;
	called_from=formobj.called_from.value;
		
	
	
	
	bean_id="@PrescriptionBean_1";
	bean_name="ePH.PrescriptionBean_1";
	if(no_ext_drug =="Y" && no_ext_drug1==""){
		no_ext_drug1="Y";
	}
	
	if( no_ext_drug1 == "Y" && (called_from != "recn_button" )){
	
		reconciliation_done_yn="Y";
	}
	

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "patient_id  =\"" + formobj.patient_id.value+ "\" " ;
	xmlStr+= "encounter_id =\"" + formobj.encounter_id.value + "\" " ;
	xmlStr+= "no_extrnal_drug =\"" + no_ext_drug1 + "\" " ;
	xmlStr+= "recn_yn  =\"" + reconciliation_done_yn + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	
	 var temp_jsp="PrescriptionValidation_1.jsp?func_mode=UPDATE_EXTERNAL_DETAILS_STATUS";
	 var xmlDoc = "" ;
	 var xmlHttp = new XMLHttpRequest() ;
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	 xmlHttp.open("POST",temp_jsp,false);
	 xmlHttp.send(xmlDoc);
	 responseText=xmlHttp.responseText ;   

	 eval(responseText);
	
}
//added for IN070786 end
