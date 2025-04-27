/*
---------------------------------------------------------------------------------------------------------------
Date       	Edit History            Name        		             Description
---------------------------------------------------------------------------------------------------------------
04/01/2019	IN:068345	            Devindra			              Required changes in item substitute mapping setup
07/08/2019  IN:071108               B Haribabu                       ML-MMOH-CRF-1408
04/09/2019  IN:071108               Manickavasagam                      ML-MMOH-CRF-1408
14/11/2019  IN:070606              Manickavasagam                      MMS-KH-CRF-0029
21/01/2020  IN:071595              Manickavasagam                      MO-CRF-20159
09/06/2020  IN:072715              Haribabu                           MMS-DM-CRF-0165
16/07/2020  IN:073201               Prabha                            SKR-SCF-1342
21/07/2020  IN073372			    Prabha							Discontinue/Cancel Orders button not working
06/11/2020  IN:069887              Haribabu                           MO-CRF-20152
10/11/2020		6041				Shazana       							NMC-JD-CRF-0063
---------------------------------------------------------------------------------------------------------------
*/
var currClass="";
var i=parseInt(0);
var order_id_prev = ""; 
/*function callPreviewOrders()	{ 

	patient_id				= parent.parent.f_header.document.prescription_header_form.patient_id.value;
	encounter_id			= parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	date					= parent.parent.f_header.document.prescription_header_form.sys_date.value;
	locn_code				= parent.parent.f_header.document.prescription_header_form.location_code.value;
	pract_name				= parent.parent.f_header.document.prescription_header_form.pract_name.value;
	actual_patient_class	= parent.parent.f_header.document.prescription_header_form.actual_patient_class.value;

	var dialogHeight= "28" ;
	var dialogWidth	= "50" ;
	var dialogTop = "169" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = window.showModalDialog("../../ePH/jsp/PrescriptionPreviewOrderFrames.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+date+"&locn_code="+locn_code+"&pract_name="+pract_name+"&actual_patient_class="+actual_patient_class,arguments,features);
}*/
function closeWindow(){
	//const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    //dialogTag.close();
	window.close();

	}
async function callActiveOrders(patient_id,encounter_id,generic_id,patient_class)	{
	
	if(generic_id==undefined)
		generic_id="";
	if(patient_class==undefined)
		patient_class="";

	var dialogHeight= "75vh" ;
	var dialogWidth	= "75vw" ;
	var dialogTop = "10" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await top.window.showModalDialog("../../ePH/jsp/PrescriptionActiveOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&called_frm=PH"+"&patient_class="+patient_class,arguments,features);

}

async function showOverRideRemarks(frmObj) {
	if(checkReasonDuplicate(frmObj)) {
		generic_id		=	frmObj.generic_id.value;
		generic_name	=	encodeURIComponent(frmObj.generic_name.value);
		patient_id		=	frmObj.patient_id.value;
		encounter_id	=	frmObj.encounter_id.value;
		drug_desc		=	encodeURIComponent(frmObj.drug_name.value);
		daily_dose		=	frmObj.daily_dose.value;
		unit_dose		=	frmObj.unit_dose.value;
		dosage_std		=	frmObj.dosage_std.value;
		mono_graph		=	encodeURIComponent(frmObj.monograph.value);
		limit_ind		=	frmObj.limit_ind.value;
		allergy_yn		=	frmObj.allergy_yn.value;
		current_rx		=	frmObj.current_rx.value;
		drug_code		=	frmObj.drug_code.value;
		//var start_date 	= frmObj.start_date.value;//Commented for ARYU-SCF-0033 not using
		//var end_date 	= frmObj.end_date.value;//Commented for ARYU-SCF-0033 not using
		srl_no			=	frmObj.srl_no.value;
		min_unit_dose	=	frmObj.min_unit_dose.value;
		min_daily_dose	=	frmObj.min_daily_dose.value;
		interaction_exists	=	frmObj.interaction_exists.value;
		abuse_exists=frmObj.abuse_exists.value;//added for aakh-crf-0140
		abuse_action=frmObj.abuse_action.value;//added for aakh-crf-0140
		abuse_override=frmObj.abuse_override.value;//added for akkh-crf0140
		abuse_override_remarks=frmObj.abuse_override_remarks.value;//added-for-aakh-crf-0140
    //Added for IN:071108 start
		max_daily_ceeling_dose=frmObj.max_daily_ceeling_dose.value;
		min_daily_ceeling_dose=frmObj.min_daily_ceeling_dose.value;
		max_unit_ceeling_dose=frmObj.max_unit_ceeling_dose.value;
		min_unit_ceeling_dose=frmObj.min_unit_ceeling_dose.value;	
		//Added for IN:071108 end
		
		//Added for IN:072715 start
		allergy_remarks_code=frmObj.allergy_remarks_code.value;
		dose_remarks_code=frmObj.dose_remarks_code.value;
		currentrx_remarks_code=frmObj.currentrx_remarks_code.value;
		interaction_remarks_code=frmObj.interaction_remarks_code.value;
		food_interaction_remarks_code=frmObj.food_interaction_remarks_code.value;
		lab_interaction_remarks_code=frmObj.lab_interaction_remarks_code.value;
		//Added for IN:072715 end
		disease_interaction_remarks_code=frmObj.disease_interaction_remarks_code.value;//Added for MMS-DM-CRF-0229
		
		if(frmObj.dosage_unit!=undefined){
		   dosage_unit		=	frmObj.dosage_unit.value;
		}
		else{
			dosage_unit		=	document.prescription_detail_form.qty_unit.value;
		}
		var dialogHeight = "60vh";

		if(current_rx=="Y" && limit_ind=="N" && allergy_yn=="Y" && abuse_action=="B")//modified for aakh-crf-0140
			dialogHeight= "400px" ;
		else if ( (current_rx=="Y" && limit_ind=="N") || (current_rx=="Y" && allergy_yn=="Y") || (limit_ind=="N" && allergy_yn=="Y" ))
			dialogHeight= "60vh" ;
		else
			dialogHeight= "60vh" ;

		var dialogWidth	= "45vw" ;
		var dialogTop = "" ;
		var dialogLeft ="";
		var center = "0" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; dialogLeft :"+dialogLeft;
		var arguments	= "" ;
		//modified for aakh-crf-0140
		retVal = await top.window.showModalDialog("../../ePH/jsp/PrescriptionOverrideReasonFrameset.jsp?abuse_override="+abuse_override+"&abuse_override_remarks="+abuse_override_remarks+"&abuse_exists="+abuse_exists+"&abuse_action="+abuse_action+"&gen_id="+generic_id+"&gen_name="+generic_name+"&pat_id="+patient_id+"&enc_id="+encounter_id+"&drug_desc="+drug_desc+"&mono_graph="+encodeURIComponent(mono_graph)+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&limit_ind="+limit_ind+"&drug_code="+drug_code+"&srl_no="+srl_no+"&min_unit_dose="+min_unit_dose+"&min_daily_dose="+min_daily_dose+"&dosage_unit="+dosage_unit+"&dosage_std="+dosage_std+"&max_daily_ceeling_dose="+max_daily_ceeling_dose+"&min_daily_ceeling_dose="+min_daily_ceeling_dose+"&max_unit_ceeling_dose="+max_unit_ceeling_dose+"&min_unit_ceeling_dose="+min_unit_ceeling_dose+"&allergy_remarks_code="+allergy_remarks_code+"&dose_remarks_code="+dose_remarks_code+"&currentrx_remarks_code="+currentrx_remarks_code+"&interaction_remarks_code="+interaction_remarks_code+"&food_interaction_remarks_code="+food_interaction_remarks_code+"&lab_interaction_remarks_code="+lab_interaction_remarks_code+"&disease_interaction_remarks_code="+disease_interaction_remarks_code+"&called_from=OverrideReason&interaction_exists="+interaction_exists,arguments,features);//Modified for  IN:071108, Modified for IN:072715 disease_interaction_remarks_code added for MMS-DM-CRF-0229

		if(retVal != undefined){
			frmObj.override_remarks.checked=true;
			frmObj.override_remarks.value='Y';
		}
		//Added for IN:072715 
		else{
			frmObj.override_remarks.checked=false;
			frmObj.override_remarks.value='N';
		}
		//Added for IN:072715 
	}
}

function validate(frmObj) {
	if(frmObj == null)
		frmObj = parent.f_overrideReason.document.DispQueueMgmtHoldReason;
	var Override_called_from = frmObj.Override_called_from.value;
	
	if(Override_called_from == "RENEW_ORDER"){
		window.close();
	}
	else{
		//alert("else--->");
		var fields	= new Array();
		var names	= new Array();
		var   i		= 0;

		if(frmObj.allergy!=null) {
			fields[i]	= frmObj.allergy;
			//alert("fields[i]--->" +fields[i].value);
		//	names[i]	= "Allergic Override Reason";
			names[i]	=getLabel("ePH.AllergicOverrideReason.label", "PH");
			i++;
		}

		if(frmObj.exceed_dose!=null) {
			fields[i]	= frmObj.exceed_dose;
			//names[i]	= "Exceed Dosage Override Reason";
			names[i]	=getLabel("ePH.ExceedDosageOverrideReason.label", "PH");
			i++;

		}

		if(frmObj.dup_drug!=null) {
			fields[i]	= frmObj.dup_drug;
			//names[i]	= "Duplicate Drug Override Reason";
			names[i]	=getLabel("ePH.DuplicateDrugOverrideReason.label", "PH");
			i++;
		}
		//modified for MMS-KH-CRF-0029[IN070606] - start
		if(frmObj.interaction_remarks!=null && frmObj.interaction_remarks!=undefined && frmObj.drug_drug_display!=null && frmObj.drug_drug_display!=undefined && frmObj.drug_drug_display.value=="") {
			fields[i]	= frmObj.interaction_remarks;
			//names[i]	= "Duplicate Drug Override Reason";
			names[i]	=getLabel("ePH.Drug-DrugInteractionOverrideReason.label", "PH");
			i++;
		}
		if(frmObj.lab_interaction_remarks!=null && frmObj.lab_interaction_remarks!=undefined && frmObj.drug_lab_display!=null && frmObj.drug_lab_display!=undefined && frmObj.drug_lab_display.value=="") {
			fields[i]	= frmObj.lab_interaction_remarks;
			//names[i]	= "Duplicate Drug Override Reason";
			names[i]	=getLabel("ePH.Drug-LabInteractionOverrideReason.label", "PH");
			i++;
		}
		if(frmObj.food_interaction_remarks!=null && frmObj.food_interaction_remarks!=undefined && frmObj.drug_food_display!=null && frmObj.drug_food_display!=undefined && frmObj.drug_food_display.value=="") {
			fields[i]	= frmObj.food_interaction_remarks;
			//names[i]	= "Duplicate Drug Override Reason";
			names[i]	=getLabel("ePH.Drug-FoodInteractionOverrideReason.label", "PH");
			i++;
		}
		//modified for MMS-KH-CRF-0029[IN070606] - end
		if(frmObj.abuse_override_remarks!=null) {//added for aakh-crf-0140
			fields[i]	= frmObj.abuse_override_remarks;
			//names[i]	= "Duplicate Drug Override Reason";
			names[i]	="Drug Abuse Override Reason"; 
			i++;
		}
    if(frmObj.disease_interaction_remarks!=null && frmObj.disease_interaction_remarks!=undefined && frmObj.drug_disease_display!=null && frmObj.drug_disease_display!=undefined && frmObj.drug_disease_display.value=="") {//Added for MMS-DM-CRF-0229
			fields[i]	= frmObj.disease_interaction_remarks;
			names[i]	=getLabel("ePH.Drug-DiseaseOverrideReason.label", "PH");
			i++;
		}//Adding end for MMS-DM-CRF-0229
		if(checkFlds1(fields,names)){
			if(checkMaxSize(fields,names)){
				storeOverRideReason(frmObj);
				//modified for aakh-crf-0140
				window.returnValue = allergy + ":::" + exceed_dose + ":::" + dup_drug + ":::" + allergy_remarks_code + ":::" + dose_remarks_code + ":::" + dup_drug_remarks_code + ":::"+abuse_exists+":::"+abuse_override_remarks+":::";// Modified for IN:072715
				window.close();
			}
		}
	}
}

function storeOverRideReason(frmObj) {
	current_rx	=	frmObj.current_rx.value;
	limit_ind	=	frmObj.limit_ind.value;
	allergy_yn	=	frmObj.allergy_yn.value;
	interaction_exists	=	frmObj.interaction_exists.value;
	abuse_exists	=	frmObj.abuse_exists.value;//added for aakh-crf-0140
	abuse_action	=	frmObj.abuse_action.value;//added for aakh-crf-0140
	//abuse_override_remarks   =frmObj.abuse_override_remarks.value;//added for aakh-crf-0140
	drug_code	=	frmObj.drug_code.value;
	srl_no		=	frmObj.srl_no.value;
	bean_id		=	frmObj.bean_id.value;
	bean_name	=	frmObj.bean_name.value;
	allergy		=	"";
	exceed_dose	=	"";
	dup_drug	=	"";
	interaction_remarks = "";
	lab_interaction_remarks = ""; //MMS-KH-CRF-0029[IN070606]
	food_interaction_remarks = "";//MMS-KH-CRF-0029[IN070606]
	//Added for IN:072715  start
	dose_remarks_code = "";
	allergy_remarks_code = "";
	dup_drug_remarks_code = "";
	interaction_remarks_code = "";
	lab_interaction_remarks_code = "";
	food_interaction_remarks_code = "";
	abuse_override_remarks="";//added for aakh-crf-0140
	//Added for IN:072715  end
	disease_interaction_remarks = "";//Added for MMS-DM-CRF-0229
	disease_interaction_remarks_code = "";//Added for MMS-DM-CRF-0229
	// Modified for IN:072715 start

	if(frmObj.allergy!=null){
		allergy		=	encodeURIComponent(frmObj.allergy.value);
		if(frmObj.allergy_remarks_code!=null && frmObj.allergy_remarks_code!=undefined)
			allergy_remarks_code=encodeURIComponent(frmObj.allergy_remarks_code.value);
	}
	
	if(frmObj.exceed_dose!=null){
		exceed_dose	=	encodeURIComponent(frmObj.exceed_dose.value);
		if(frmObj.dose_remarks_code!=null && frmObj.dose_remarks_code!=undefined)
			dose_remarks_code=encodeURIComponent(frmObj.dose_remarks_code.value);
	}

	if(frmObj.dup_drug!=null){
		dup_drug	=	encodeURIComponent(frmObj.dup_drug.value);
		if(frmObj.dup_drug_remarks_code!=null && frmObj.dup_drug_remarks_code!=undefined)
			dup_drug_remarks_code=encodeURIComponent(frmObj.dup_drug_remarks_code.value);
	}
		
	if(frmObj.interaction_remarks!=null){
		interaction_remarks	=	encodeURIComponent(frmObj.interaction_remarks.value);
		if(frmObj.interaction_remarks_code!=null && frmObj.interaction_remarks_code!=undefined)
			interaction_remarks_code=encodeURIComponent(frmObj.interaction_remarks_code.value);
	}
//MMS-KH-CRF-0029[IN070606] - start
	if(frmObj.food_interaction_remarks!=null){
		food_interaction_remarks	=	encodeURIComponent(frmObj.food_interaction_remarks.value);
		if(frmObj.food_interaction_remarks_code!=null && frmObj.food_interaction_remarks_code!=undefined)
			food_interaction_remarks_code=encodeURIComponent(frmObj.food_interaction_remarks_code.value);
	}
	if(frmObj.lab_interaction_remarks!=null){
		lab_interaction_remarks	=	encodeURIComponent(frmObj.lab_interaction_remarks.value);
		if(frmObj.lab_interaction_remarks_code!=null && frmObj.lab_interaction_remarks_code!=undefined)
			lab_interaction_remarks_code=encodeURIComponent(frmObj.lab_interaction_remarks_code.value);
	}
	// Modified for IN:072715 end	
//MMS-KH-CRF-0029[IN070606] - end
//	alert("274"+frmObj.abuse_action.value+"<---");
	
	if(frmObj.abuse_action!=null && frmObj.abuse_action.value=="B" ){//added for aakh-crf-0140
	//	alert("278"+frmObj.abuse_override_remarks);
	//	alert("278"+frmObj.abuse_override_remarks.value);
		abuse_remarks		=	encodeURIComponent(frmObj.abuse_override_remarks.value);
		
		if(frmObj.abuse_override_remarks!=null && frmObj.abuse_override_remarks!=undefined)
			{
			abuse_override_remarks=encodeURIComponent(frmObj.abuse_override_remarks.value);
			//alert("279abuse_override_remarks"+abuse_override_remarks);
			}
	}
  if(frmObj.disease_interaction_remarks!=null){//Added for MMS-DM-CRF-0229
		disease_interaction_remarks	=	encodeURIComponent(frmObj.disease_interaction_remarks.value);
		if(frmObj.disease_interaction_remarks_code!=null && frmObj.disease_interaction_remarks_code!=undefined)
			disease_interaction_remarks_code=encodeURIComponent(frmObj.disease_interaction_remarks_code.value);
	}//Adding end for MMS-DM-CRF-0229

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "current_rx  =\"" + current_rx + "\" " ;
	xmlStr+= "limit_ind =\"" + limit_ind + "\" " ;
	xmlStr+= "allergy_yn  =\"" + allergy_yn + "\" " ;
	xmlStr+= "allergy =\"" + allergy + "\" " ;
	xmlStr+= "exceed_dose =\"" + exceed_dose + "\" " ;
	xmlStr+= "dup_drug =\"" + dup_drug + "\" " ;
	xmlStr+= "interaction_remarks =\"" + interaction_remarks + "\" " ;
	xmlStr+= "interaction_exists =\"" + interaction_exists + "\" " ;
	
	xmlStr+= "food_interaction_remarks =\"" + food_interaction_remarks + "\" " ; //MMS-KH-CRF-0029[IN070606]
	xmlStr+= "lab_interaction_remarks =\"" + lab_interaction_remarks + "\" " ;//MMS-KH-CRF-0029[IN070606]
	//Added for IN:072715 start
	xmlStr+= "dose_remarks_code =\"" + dose_remarks_code + "\" " ;
	xmlStr+= "allergy_remarks_code =\"" + allergy_remarks_code + "\" " ;
	xmlStr+= "dup_drug_remarks_code =\"" + dup_drug_remarks_code + "\" " ;
	xmlStr+= "interaction_remarks_code =\"" + interaction_remarks_code + "\" " ;
	xmlStr+= "lab_interaction_remarks_code =\"" + lab_interaction_remarks_code + "\" " ;
	xmlStr+= "food_interaction_remarks_code =\"" + food_interaction_remarks_code + "\" " ;
	//Added for IN:072715 end
    xmlStr+= "disease_interaction_remarks =\"" + disease_interaction_remarks + "\" " ;//Added for MMS-DM-CRF-0229
	xmlStr+= "disease_interaction_remarks_code =\"" + disease_interaction_remarks_code + "\" " ;//Added for MMS-DM-CRF-0229
//alert("disease_interaction_remarks=="+disease_interaction_remarks+"disease_interaction_remarks_code=="+disease_interaction_remarks_code+"dose_remarks_code=="+dose_remarks_code)
	xmlStr+= "drug_code =\"" + drug_code + "\" " ;
	xmlStr+= "srl_no =\"" + srl_no + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	//added for aakh-crf-0140 start
	xmlStr+= "abuse_exists =\"" + abuse_exists + "\" " ;
	xmlStr+= "abuse_action =\"" + abuse_action + "\" " ;
	//alert("abuse_override_remarks"+abuse_override_remarks);
	xmlStr+= "abuse_override_remarks =\"" + abuse_override_remarks + "\" " ;
	//added for aakh-crf-0140 end
	xmlStr +=" /></root>";
	//alert("xmlStr-->" +xmlStr);
	var temp_jsp="PrescriptionValidation.jsp?func_mode=override_reason";//Relevent code moved from PrescriptionValidation_1 to PrescriptionValidation
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	//alert("xmlDoc-->" +xmlDoc);
	//alert("xmlHttp-->" +xmlHttp);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	
	responseText=xmlHttp.responseText ;
	//alert("responseText---> " +responseText);

}

function checkFlds1( fields, names) {
	//alert("checkFlds1---->");

/*	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else{
			errors = getMessage("CAN_NOT_BE_BLANK","Common")+"\n";
			alert("ssserrors=="+errors);
//			errors = getLabel("ePH.CAN_NOT_BE_BLANK.label","PH")+"\n";
			errors = errors.replace("$", fields[i]);
			alert("ssserrors=after append="+errors);
		}
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;*/
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	
			errors = errors + "APP-000001 " + names[i] +" "+ getLabel("ePH.CANT_BE_BLANK.label","PH") + "\n" ;
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

function checkMaxSize(fields,names) { 
	var errors = "" ;
	var errorsmsg = "" ;
	for(var i=0; i<fields.length; i++ ){
		if(fields[i].value.length > 255){
			errorsmsg = getMessage("REMARKS_CANNOT_EXCEED","Common");
			errorsmsg = errorsmsg.replace("$", names[i]);
			errorsmsg = errorsmsg.replace("#","255");
			errors=errors+errorsmsg;
		}
	}
	if(errors.length!= 0){
		alert(errors) ;
		return false ;
	}
	return true ;
}

async function sub_showMonoGraphDetail(drug_desc,mono_graph,daily_dose,unit_dose) {
	var retVal;
	var dialogTop		= "";
 	var dialogHeight	= "40vh" ;
 	var dialogWidth		= "60vw" ;
	var dialogLeft		= "240" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
 	retVal 				= await window.showModalDialog("../../ePH/jsp/PrescriptionDosageLimitMonoGraph.jsp?drug_desc="+drug_desc+"&mono_graph="+mono_graph+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose,arguments,features);
}

function callCurrentMedication(patient_id,encounter_id,generic_id) {
	callActiveOrders(patient_id,encounter_id,generic_id);
}

function callActiveProblems(patient_id,encounter_id,params) {

	var bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	var bean_name		= "ePH.PrescriptionBean_1";
	var params			=	params;

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr+= "params=\"" + params + "\" " ;
	xmlStr +=" /></root>";

	var temp_jsp="../../ePH/jsp/PrescriptionValidation_1.jsp?func_mode=diag_text";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function datafound(isdata,diag_size) {
	if(isdata=='true') {
		//alert(parent.frames[1].name)
		diag_text	=	parent.frames[1].frames[0].frames[1].criteriaPlaceOrderFrame.f_header.document.getElementById("diag_text");
		parent.frames[1].frames[0].frames[1].criteriaPlaceOrderFrame.f_header.document.prescription_header_form.diag_size.value=diag_size;
		diag_text.style.visibility='visible';
		diag_text.style.cursor='Hand';
		diag_text.style.color='blue';
	}
	else {
		diag_text	=	parent.frames[1].frames[0].frames[1].criteriaPlaceOrderFrame.f_header.document.getElementById("diag_text");
		if(diag_text!=null&&diag_text!=undefined){
			diag_text.style.visibility='hidden';
		}
	}
}

async function callDiagText(patient_id,encounter_id,called_frm) {
	var dialogHeight= "40vh";
	var dialogWidth	= "50vw" ;
	var dialogTop = "169" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionDiagTextFrames.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&called_frm="+encodeURIComponent(called_frm),arguments,features);
}

async function callFreqDet(patient_id,encounter_id,order_id,order_line_no,freq_desc,start_date,sliding_scale_yn,iv_prep_yn) {
	if(iv_prep_yn == undefined)
		iv_prep_yn='';
	var dialogHeight= "50vh";
	var dialogWidth	= "50vw" ;
	var dialogTop = "30" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await top.window.showModalDialog("../../ePH/jsp/PrescriptionFreqFrames.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&freq_desc="+encodeURIComponent(freq_desc,'UTF-8')+"&start_date="+unescape(start_date)+"&sliding_scale_yn="+sliding_scale_yn+"&iv_prep_yn="+iv_prep_yn,arguments,features);
}

async function showReasons(allergy,dosage,duplicate) {
//alert("showReasons---->");
	var dialogHeight="";
	if(allergy!="" && dosage!="" && duplicate!="")
		dialogHeight= "18" ;
	else if ( (allergy!=""  && dosage!="") || (allergy!="" && duplicate!="") || (dosage!="" && duplicate!=""))
		dialogHeight= "13" ;
	else
		dialogHeight= "9" ;

		dialogHeight= "20vh" ;
	var dialogWidth	= "60vw" ;
	var dialogTop = "285" ;
	var dialogLeft ="300";
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionDrugReasons.jsp?allergy="+allergy+"&dosage="+dosage+"&duplicate="+duplicate,arguments,features);
}

async function callOrderRemarks(){
	var patient_id=document.prescription_header_form.patient_id.value;
	var encounter_id=document.prescription_header_form.encounter_id.value;
	var bean_id="@PrescriptionBean_1"+patient_id+encounter_id;
	var bean_name=document.prescription_header_form.bean_name.value;
	var order_remarks=document.prescription_header_form.order_remarks.value;
	var dialogHeight= "50vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "10" ;
	var dialogLeft = "10" ;
	var center = "1" ;
	var status="no";
	var scroll="yes";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =await window.showModalDialog("../../ePH/jsp/PrescriptionRemarksFrame.jsp?order_remarks="+order_remarks+"&bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
	if(retVal!=null)
		document.prescription_header_form.order_remarks.value=retVal;
}

function changeButtonColor(obj,from_name){

	if(from_name=="PH_BUTTONS"){
		cellref = parent.f_header.document.prescription_header_form.tab.rows(0).cells
		version_no = parent.f_header.document.prescription_header_form.version_no.value;
	}
	else if(from_name=="COMMON")
		cellref = document.getElementById("tab").rows[0].cells
	if(version_no==3) 
		check_val = 7; 
	else 
		check_val = 2;
	for(i=0; i<cellref.length; i++){
		if(i!=check_val && i!=(check_val+1)){
			if(cellref[i].id!="dummy")
				cellref[i].className = 'CAFIRSTSELECTHORZ'
		}
	}
	obj.className = "CASECONDSELECTHORZ"
	currClass ="CASECONDSELECTHORZ";
}

function callOnMouseOver(obj){
	//alert(obj.className);
	currClass = obj.className ;
	obj.className = 'CASECONDSELECTHORZ';
}

function callOnMouseOut(obj){
	obj.className = currClass;
}

function change_tab_buttons(str){

	var hdr_formObj = document.prescription_header_form;

	var patient_id			= hdr_formObj.patient_id.value;
	var encounter_id		= hdr_formObj.encounter_id.value;
	var bed_num				= hdr_formObj.bed_num.value;
	var room_num			= hdr_formObj.room_num.value;
	var location_type		= hdr_formObj.location_type.value;
	var location_code		= hdr_formObj.location_code.value;
	var patient_class		= hdr_formObj.patient_class.value;
	var act_patient_class	= hdr_formObj.actual_patient_class.value;
	var order_date_time		= hdr_formObj.sys_date.value;
	var problem_ind			= hdr_formObj.problem_ind.value;
	var height				= hdr_formObj.height.value;
	var weight				= hdr_formObj.weight.value;
	var pract_id			= hdr_formObj.pract_id.value;
	var resp_id				= hdr_formObj.resp_id.value;
	var ph_default_tab		= hdr_formObj.ph_default_tab.value;
	var priority			= hdr_formObj.priority.value;
	var bl_install_yn		= hdr_formObj.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn		= hdr_formObj.bl_disp_charge_dtl_in_rx_yn.value;
	var bl_disp_charge_dtl_in_drug_lkp_yn		= hdr_formObj.disp_charge_dtl_in_drug_lkp_yn.value;
	var disp_price_type_in_drug_lkp		= hdr_formObj.disp_price_type_in_drug_lkp.value;
	var take_home_medication		    = hdr_formObj.take_home_medication.value;
	var drug_db_interface_yn	= hdr_formObj.drug_db_interface_yn.value;
	var MAR_app_yn						= getMAR_app_yn(document.prescription_header_form);
	var adr_count						= hdr_formObj.adr_count.value;
	
	var height_uom		=hdr_formObj.height_unit.value;  
	var weight_uom		=hdr_formObj.weight_unit.value;
	
	var bsa				= hdr_formObj.bsa.value;
	var bsa_uom			= getLabel("Common.BSA.label","Common");
	var bmi				= hdr_formObj.bmi.value;
	var facility_id		= hdr_formObj.facility_id.value ;
	var order_set_code		= hdr_formObj.order_set_code.value ;
	var atc_allergy_alert_level		= hdr_formObj.atc_allergy_alert_level.value ;
	var allergy_conf_reqd_yn =hdr_formObj.allergy_conf_reqd_yn.value; //added for RUT-CRF-0064.1 [IN:041799] -Start
	var excludeADRAllergyAlert_yn	 = hdr_formObj.excludeADRAllergyAlert_yn.value; //Added for HSA-SCF-0011 [IN:042444]
	var preview_rx_yn	=	hdr_formObj.preview_rx_yn.value;//added for ML-MMOH-CRF-0341 [IN:057179]
	var allergyConf = true;
	if(allergy_conf_reqd_yn=='true'){
		allergyConf = getAllergyConf(allergy_conf_reqd_yn);
	} //added for RUT-CRF-0064.1 [IN:041799] -end
	if(allergyConf){ //if condition alone added for RUT-CRF-0064.1 [IN:041799]
		if(str=="nonivrx" && (ph_default_tab=="R" || ph_default_tab==null || ph_default_tab=="" )){
			document.prescription_header_form.iv_prep_yn.value='';
//			parent.PrescriptionDetailFrameSet.setAttribute("rows","");
//			parent.PrescriptionDetailFrameSet.setAttribute("cols","27%,*");
//			parent.PrescriptionDetailFrameSet.cols="27%,*";
			
			parent.PrescriptionDetailFrameSet.style.display="flex";
			
			parent.document.getElementById("f_prescription").style.width="";
			parent.document.getElementById("f_detail").style.height="92vh";
			parent.document.getElementById("f_button").style.height="5vh";
			
			var mode="blank";
			parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn;
			parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&bed_num="+bed_num+"&room_num="+room_num+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&priority="+priority+"&frm_rx_button_yn=Y"+"&excludeADRAllergyAlert_yn="+excludeADRAllergyAlert_yn;    //added frm_rx_button_yn for the incident number 21598
			parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication;
		}
		else if(str=="ivrx"){
			//document.prescription_header_form.iv_prep_yn.value=str;
//			parent.PrescriptionDetailFrameSet.setAttribute("cols","");
//			parent.PrescriptionDetailFrameSet.setAttribute("rows","100%,0%");
//			parent.PrescriptionDetailFrameSet.rows="100%,0%";
			
			parent.PrescriptionDetailFrameSet.style.display="none";
			
			parent.document.getElementById("f_prescription").style.width="99vw";
			parent.f_prescription.classValue="IV";
			parent.f_prescription.location.href="../../ePH/jsp/IVPrescription.jsp?act_patient_class="+act_patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&bed_num="+bed_num+"&room_num="+room_num+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&take_home_medication="+take_home_medication+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&atc_allergy_alert_level="+atc_allergy_alert_level+"&excludeADRAllergyAlert_yn="+excludeADRAllergyAlert_yn+"&preview_rx_yn="+preview_rx_yn;
		}
		else if(str=="oncology_regimen" ){
			if(height!="" && weight!=""){
				//document.prescription_header_form.iv_prep_yn.value=str;
				document.prescription_header_form.weight_rec_appl_age_group_check_flag.value = 'Y';
//				parent.PrescriptionDetailFrameSet.setAttribute("cols","");
//				parent.PrescriptionDetailFrameSet.setAttribute("rows","100%,0%");
//				parent.PrescriptionDetailFrameSet.rows="100%,0%";
//				parent.document.getElementById("f_detail").style.height="92vh";
//				parent.document.getElementById("f_button").style.height="5vh";
				
				parent.PrescriptionDetailFrameSet.style.display="none";
				
				parent.document.getElementById("f_prescription").style.width="99vw";
				parent.f_prescription.classValue="IV";
				parent.f_prescription.location.href="../../ePH/jsp/OncologyRegimen.jsp?act_patient_class="+act_patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&problem_ind="+problem_ind+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&take_home_medication="+take_home_medication+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&clearOrNot=Y"+"&atc_allergy_alert_level="+atc_allergy_alert_level+"&excludeADRAllergyAlert_yn="+excludeADRAllergyAlert_yn+"&preview_rx_yn="+preview_rx_yn;
			}
			else{
				document.prescription_header_form.weight_rec_appl_age_group_check_flag.value = 'Y';
				alert(getMessage("PH_WEIGHT_REQUIRED", "PH"));
				parent.f_prescription.location.href="../../eCommon/html/blank.html"
				parent.f_detail.location.href="../../eCommon/html/blank.html"
				parent.f_button.location.href="../../eCommon/html/blank.html"
			}
		}
		else if(str=="tpn_regimen")	{
			if(height!="" && weight!=""){
				document.prescription_header_form.weight_rec_appl_age_group_check_flag.value = '';
				//document.prescription_header_form.iv_prep_yn.value=str;
//				parent.PrescriptionDetailFrameSet.setAttribute("cols","");
				
//				parent.PrescriptionDetailFrameSet.setAttribute("rows","100%,0%");
//				parent.PrescriptionDetailFrameSet.rows="100%,0%";
				/*parent.document.getElementById("f_detail").style.height="92vh";
				parent.document.getElementById("f_button").style.height="5vh";*/
				parent.PrescriptionDetailFrameSet.style.display="none";
				
				parent.document.getElementById("f_prescription").style.width="99vw";
				parent.f_prescription.classValue="IV";
				parent.f_prescription.location.href="../../ePH/jsp/TPNRegimen.jsp?priority="+priority+"&location_code="+location_code+"&location_type="+location_type+"&pract_id="+pract_id+"&act_patient_class="+act_patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&problem_ind="+problem_ind+"&height="+height+"&weight="+weight+"&take_home_medication="+take_home_medication+"&MAR_app_yn="+MAR_app_yn+"&take_home_medication="+take_home_medication+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&atc_allergy_alert_level="+atc_allergy_alert_level+"&bed_num="+bed_num;   //bed_num added for ML-MMOH-CRF-1089
			}
			else{
				document.prescription_header_form.weight_rec_appl_age_group_check_flag.value = 'Y';
				alert(getMessage("PH_WEIGHT_REQUIRED", "PH"));
				parent.f_prescription.location.href="../../eCommon/html/blank.html"
				parent.f_detail.location.href="../../eCommon/html/blank.html"
				parent.f_button.location.href="../../eCommon/html/blank.html"
			}
		}
		else if(str=="comprx"){
			//document.prescription_header_form.iv_prep_yn.value=str;
//			parent.PrescriptionDetailFrameSet.setAttribute("cols","");
//			parent.PrescriptionDetailFrameSet.setAttribute("rows","100%,0%");
//			parent.PrescriptionDetailFrameSet.rows="100%,0%";
			
			parent.PrescriptionDetailFrameSet.style.display="none";
			
			parent.document.getElementById("f_prescription").style.width="99vw";
			/*parent.document.getElementById("f_detail").style.height="92vh";
			parent.document.getElementById("f_button").style.height="5vh";*/
			
			parent.f_prescription.classValue="IV";
			var mode="new";
		 	parent.f_prescription.location.href="../../ePH/jsp/PrescriptionCompFrames.jsp?act_patient_class="+act_patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&take_home_medication="+take_home_medication+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&atc_allergy_alert_level="+atc_allergy_alert_level+"&excludeADRAllergyAlert_yn="+excludeADRAllergyAlert_yn+"&preview_rx_yn="+preview_rx_yn+"&height="+height+"&weight="+weight+"&bsa="+bsa;
			//weight and height and bsa added for ML-MMOH-CRF-1408
		}
		else if(str == "tdm"){
			//document.prescription_header_form.iv_prep_yn.value=str;
//			parent.PrescriptionDetailFrameSet.setAttribute("cols","");
//			parent.PrescriptionDetailFrameSet.setAttribute("rows","100%,0%");
//			parent.PrescriptionDetailFrameSet.rows="100%,0%";
			
//			parent.document.getElementById("f_detail").style.height="92vh";
//			parent.document.getElementById("f_button").style.height="5vh";
			parent.PrescriptionDetailFrameSet.style.display="none";
			parent.document.getElementById("f_prescription").style.width="99vw";
			
			parent.f_prescription.classValue="IV";
			var mode = "blank";
			parent.f_prescription.location.href="../../ePH/jsp/PrescriptionTDMFrames.jsp?priority="+priority+"&location_code="+location_code+"&location_type="+location_type+"&pract_id="+pract_id+"&act_patient_class="+act_patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&problem_ind="+problem_ind+"&height="+height+"&weight="+weight+"&MAR_app_yn="+MAR_app_yn+"&take_home_medication="+take_home_medication+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&atc_allergy_alert_level="+atc_allergy_alert_level;
		}
		else if(str == "medicalItem"){
			//document.prescription_header_form.iv_prep_yn.value=str;
//		    parent.PrescriptionDetailFrameSet.setAttribute("cols","");
//			parent.PrescriptionDetailFrameSet.setAttribute("rows","100%,0%");
//			parent.PrescriptionDetailFrameSet.rows="100%,0%";
			
			
			parent.PrescriptionDetailFrameSet.style.display="none";
			
			parent.document.getElementById("f_prescription").style.width="99vw";
//			parent.document.getElementById("f_detail").style.height="92vh";
//			parent.document.getElementById("f_button").style.height="5vh";
			
			parent.f_prescription.classValue="IV";
			var mode = "blank";
			var called_from = "TAB";
			if(order_set_code!=undefined && order_set_code !="")
				called_from = "ORDERSET";
			var allow_alt_for_med_item		    = document.prescription_header_form.allow_alt_for_med_item.value; // Added for GHL-CRF-0548 [IN:068345] - Devindra			
			parent.f_prescription.location.href="../../ePH/jsp/ConsumableOrder.jsp?priority="+priority+"&location_code="+location_code+"&location_type="+location_type+"&pract_id="+pract_id+"&resp_id="+resp_id+"&act_patient_class="+act_patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&order_date_time="+order_date_time+"&height="+height+"&weight="+weight+"&take_home_medication="+take_home_medication+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&bl_disp_charge_dtl_in_drug_lkp_yn="+bl_disp_charge_dtl_in_drug_lkp_yn+"&bl_disp_price_type_in_drug_lkp="+disp_price_type_in_drug_lkp+"&weight_unit="+weight_uom+"&bsa="+bsa+"&bsa_unit="+bsa_uom+"&bmi="+bmi+"&facility_id="+facility_id+"&bed_num="+bed_num+"&room_num="+room_num+"&call_mode=new"+"&called_from="+called_from+"&allow_alt_for_med_item="+allow_alt_for_med_item+"&height_unit="+height_uom; // allow_alt_for_med_item Added for GHL-CRF-0548 [IN:068345] - Devindra // height added at end for SKR-SCF-1342
		}
		else if(str == "NPBRequest"){
//			parent.PrescriptionDetailFrameSet.setAttribute("cols","");
//			parent.PrescriptionDetailFrameSet.setAttribute("rows","100%,0%");
//			parent.PrescriptionDetailFrameSet.rows="100%,0%";
//			parent.document.getElementById("f_detail").style.height="92vh";
//			parent.document.getElementById("f_button").style.height="5vh";
			parent.PrescriptionDetailFrameSet.style.display="none";
			parent.document.getElementById("f_prescription").style.width="99vw";
			
			var mode = "blank";
			var called_from = "TAB";
			if(order_set_code!=undefined && order_set_code !="")
				called_from = "ORDERSET";
			parent.f_prescription.location.href="../../ePH/jsp/NPBRequest.jsp?priority="+priority+"&location_code="+location_code+"&location_type="+location_type+"&pract_id="+pract_id+"&resp_id="+resp_id+"&act_patient_class="+act_patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&order_date_time="+order_date_time+"&height="+height+"&weight="+weight+"&take_home_medication="+take_home_medication+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&bl_disp_charge_dtl_in_drug_lkp_yn="+bl_disp_charge_dtl_in_drug_lkp_yn+"&bl_disp_price_type_in_drug_lkp="+disp_price_type_in_drug_lkp+"&height_unit="+height_uom+"&weight_unit="+weight_uom+"&bsa="+bsa+"&bsa_unit="+bsa_uom+"&bmi="+bmi+"&facility_id="+facility_id+"&bed_num="+bed_num+"&room_num="+room_num+"&call_mode=new"+"&called_from="+called_from;
			top
		}
		if(top.content != null)
			top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
}

function checkDuplicate(obj,priv) { 
	obj_code	=	obj.value;
	var frmObj = document.frmPrescriptionPrevOrdersResult;
	var arrObj	= frmObj.elements;
	var prescription	=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.group_by[0].checked;
	var end_date;
	var chk_obj_name;
	var end_date_obj;
	var drug_code;
	var ord_status_obj;
	var discont;
	if(priv == "N"){
		alert(getMessage("INSUFFICIENT_PRIVILEGE_FOR_ORDERING_THE_DRUG","PH"));
		return false;
	}

	if(obj.checked==true) {
		for(var i=0; i<arrObj.length; i++) {
			if(arrObj[i].type=="hidden"){
				end_dates	=	arrObj[i].name.split(",");
				if(end_dates.length>2) {
					chk_obj_name = end_dates[0]+","+end_dates[1];
					if(obj.name==chk_obj_name && end_dates[2]=="end_date"){
						end_date = arrObj[i].value; 
	
						for(var j=0; j<arrObj.length; j++) {// Code added to get  the order_status object and it is passed to checkCurrentMedn() for IN22804 --22/07/2010-- priya
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
						}// Code added to get  the order_status object and it is passed to checkCurrentMedn() for IN22804 --End 
						checkCurrentMedn(frmObj.system_date.value,end_date,end_dates[0],end_dates[1],ord_status_obj);
						break;
					}
				} 
			}
		}
	
/*	str="frmObj."+obj.name+",end_date";
	alert("str = "+str);
	end_date =eval(str).value;*/
		for(var i=0;i<arrObj.length;i++) {
			if(arrObj[i].type=="checkbox"){					
				drug_code	=	arrObj[i].value;
				 if( (arrObj[i].name!=obj.name) && obj_code==drug_code ){
					 arrObj[i].disabled=true;
				 }
			}
		}
		
		if(prescription==true) {
			disableHeader(arrObj);
			checkHeader(arrObj,obj);
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
		if(prescription==true) {
			disableHeader(arrObj);
			checkHeader(arrObj,obj);
		}
		frmObj.checkcount.value=parseInt(frmObj.checkcount.value)-1;
	}
	storeChecked(obj);
	return true;
}

function disableHeader(arrObj) {
	var header_obj;
	for(var i=0; i<arrObj.length; i++) {
		if(arrObj[i].type=="checkbox"){
			line_det	=	arrObj[i].name.split(",");
			if(line_det.length==1) {
				header_obj	=	arrObj[i];	
				checkAllLines(arrObj,header_obj);
			} 
			
		}
	}
}

function checkAllLines(arrObj,header_obj) {
	var disable_header	=	false;
	for(var j=0; j<arrObj.length; j++) {
		if(arrObj[j].type=="checkbox"){
			line_det	=	arrObj[j].name.split(",");
			if(line_det.length>1 && line_det[0]==header_obj.name) {
				if(arrObj[j].disabled==true  || eval("document.frmPrescriptionPrevOrdersResult.TaperCount"+line_det[0]).value>1) { // TaperCount condition added for [IN:048140]
					disable_header	=	true;
					break;
				}
			}
		}
	}
	if(disable_header) {
		header_obj.disabled	=	true;
	}
	else {
		header_obj.disabled	=	false;
	}
}

function checkHeader(arrObj,obj) {
	var header_obj;
	var det_obj;
	var check_header = true;
	var entered		 = false;
	var head_or_det  = obj.name.split(",");

	if(head_or_det.length>1) {

		for(var j=0; j<arrObj.length; j++) {
			if(arrObj[j].type=="checkbox"){
				line_det	=	arrObj[j].name.split(",");
				if(line_det.length==1 && line_det==head_or_det[0]) {
					header_obj = arrObj[j];
					
				}
				else if(line_det.length>1 && line_det[0]==head_or_det[0]) {
					if(arrObj[j].checked==false) {
						check_header = false;
						entered		 = true;
					}
				}
			}
		}
		if(!entered) {
			check_header = true;	
		}
	}
	if(check_header) {
		if(header_obj)
			header_obj.checked = true;
	}
	else {
			if(header_obj)
				header_obj.checked = false;
	}

}

function checkDuplicateAfterLoad() {
	var frmObj = document.frmPrescriptionPrevOrdersResult;
	var arrObj	= frmObj.elements;

	for(var i=0;i<arrObj.length;i++) {
		if(arrObj[i].type=="checkbox" && arrObj[i].checked){	
			disableOthers(frmObj,arrObj[i]);					
		}
	}
	disableHeader(arrObj);				
}

function disableOthers(frmObj,chkd_obj){
	var arrObj	= frmObj.elements;
	for(var i=0;i<arrObj.length;i++) {
		if(arrObj[i].type=="checkbox" && arrObj[i].name!=chkd_obj.name && arrObj[i].value==chkd_obj.value){	
			arrObj[i].disabled=true;					
		 }
	}

}

function storeChecked(obj) {

	var frmObj = document.frmPrescriptionPrevOrdersResult;
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

async function prevOrdersPreview(){
	var pat_class		=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.patient_class.value;
	var self			=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.orders[0].checked;
	var ord_status		=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.ord_status.value;
	var order_from		=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.order_date_from.value;
	var order_to		=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.order_date_to.value;
	var patient_id		=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.patient_id.value;
	var encounter_id	=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.encounter_id.value;
	var prescription	=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.group_by[0].checked;
	var order_id		=	document.frmPrescriptionPrevOrdersButton.order_id.value;
	var pract_id		=	"";
	var rx_type			=  parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.rx_type.value;

	if(self==true)
		pract_id		= parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.pract_id.value;
	else
		pract_id		= "";

	if(prescription==true)
		group_by	=	"PR";
	else
		group_by	=	"DR";


	var dialogHeight= "67vh" ;
	var dialogWidth	= "47vw" ;
	var dialogTop = "180" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	
	retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionPrevOrdersPreviewFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&pat_class="+pat_class+"&ord_status="+ord_status+"&order_from="+order_from+"&order_to="+order_to+"&pract_id="+pract_id+"&order_id="+order_id+"&rx_type="+rx_type+"&call_from=COPYPREVORDERS",arguments,features);
}

function copiedDrugs(frmObj, called_from) {
	if(frmObj == undefined)
		frmObj	=	parent.f_prev_orders_results.document.frmPrescriptionPrevOrdersResult;
	if(called_from == undefined)
		called_from = "Copy";
	var bean_id			=	frmObj.bean_id;
	var bean_name		=	frmObj.bean_name;
	var flag = 0;
	var arrObj	= frmObj.elements;
	var iv_prep_yn ="";
	var ord_id = "";
	var chk_obj_name = "";
	var discont = "";
	var answer = "";
	var call_from = "Copy";
	for(var i=0;i<arrObj.length;i++){
		if((arrObj[i].type=="checkbox")){
			var classname= parent.f_prev_orders_results.document.getElementById('ord_'+arrObj[i].name.className);
			
			if((arrObj[i].checked==true)&&(classname=="CURRTEXT")){
				flag=1;
				ord_id = arrObj[i].name;
				iv_prep_yn = eval("parent.f_prev_orders_results.document.frmPrescriptionPrevOrdersResult.iv_prep_yn"+ord_id).value;
				for(var j=0; j<arrObj.length; j++){
					if(arrObj[j].type=="hidden"){
						discont	=	arrObj[j].name.split(",");
						if(discont.length>1){
							chk_obj_name = discont[0];
							if(ord_id==chk_obj_name && discont[1]=="answer_iv"){
								if(arrObj[j].value == "Y")
									answer = "Y";
								else
									answer = "N";
								break;
							}
						}
					}
				}
			}
			else if (arrObj[i].checked==true){
				flag=1;
				names	=	arrObj[i].name.split(",");
				ord_id=names[0];
				//	iv_prep_yn = eval("parent.f_prev_orders_results.document.frmPrescriptionPrevOrdersResult.iv_prep_yn"+ord_id).value;
			}
		}
	}
	if(flag == 0 && called_from =='Copy' && frmObj.checkcount.value=='0'){
		alert(getMessage("PH_ATLEAST_ONE_SELECTED","PH")); // =====Removed the comment on this line===========
		return;
	} 
	
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id.value + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name.value + "\" " ;
	xmlStr+= "iv_prep_yn=\"" + iv_prep_yn+ "\" " ;
	xmlStr+= "order_id=\"" + ord_id+ "\" " ;
	xmlStr+= "answer=\"" + answer+ "\" " ; 
	xmlStr+= "call_from=\"" + call_from+ "\" " ;
	xmlStr+= "called_from=\"" + called_from+ "\" " ; 
	xmlStr +=" /></root>";
	var temp_jsp="PrescriptionValidation_2.jsp?func_mode=copied_drugs";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);	
}

function returnDrugs(drugs,order_id,mode){
	top.window.returnValue = drugs+order_id+","+mode;
	window.close();
}

function returnOrder(order_id,answer){
	top.window.returnValue = order_id+","+answer; //passed answer for IN24251 --16/12/2010-- priya
	window.close();
}

function controlLines() {
	var frmObj		= document.frmPrescriptionPrevOrdersResult;
	var arrObj		= frmObj.elements;
	var order_id	= "";
	var line_obj	= new Array();
	var chkBoxes	= new Array();
	var line_cnt	=	0;
	var cnt			=	0;
	for(var i=0;i<arrObj.length;i++) {
		if(arrObj[i].type=="checkbox"){	
			chkBoxes[cnt++]	=	arrObj[i];
		}
	}
	for(var j=0;j<chkBoxes.length;j++) {	
		names	=	chkBoxes[j].name.split(",");

		if(names.length==1) {
			line_cnt	=	0;
			order_id	=	names;
			if(line_obj.length==1) {
				line_obj[0].style.visibility="hidden";
			}
			line_obj	=	new Array();
		} 
		else {
			line_obj[line_cnt]=chkBoxes[j];
			line_cnt++;	
		//	alert("j>>"+j+"==chkBoxes.length>>"+chkBoxes.length+"==line_obj.length>>"+line_obj.length+"==frmObj.group_by>>"+frmObj.group_by.value);
			if( (j==(chkBoxes.length)-1) && line_obj.length==1 && frmObj.group_by.value=="PR"){
				line_obj[0].style.visibility="hidden";
			}
		}
	}
}

function checkLines(obj,i) {
	var frmObj		= document.frmPrescriptionPrevOrdersResult;
	var arrObj		= frmObj.elements;
	var priv;
  
	 var s;
	//xmlStr+= "iv_prep_yn  =\"" + iv_prep_yn + "\" " ;
	if(obj.checked==true) {
		for(var i=0;i<arrObj.length;i++) {
			if(arrObj[i].type=="checkbox"){	
				names	=	arrObj[i].name.split(",");
				if(names.length>1 && obj.name==names[0]){
					if(arrObj[i].checked==false) {
						arrObj[i].checked=true;
						s=arrObj[i-1].name;
						priv=eval(arrObj[i-1]).value;
						//alert("i==="+i);	
						/*		if(i==5)
									priv ="N";
								else
									priv = "Y";    */
						if(checkDuplicate(arrObj[i],priv)==false){
							arrObj[i].checked=false;
							obj.checked=false;
							checkHeader(arrObj,obj);
						}
					}
				}
			}
		}
	} 
	else {
		for(var i=0;i<arrObj.length;i++) {
			if(arrObj[i].type=="checkbox"){	
				names	=	arrObj[i].name.split(",");
				if(names.length>1 && obj.name==names[0]){
					if(arrObj[i].checked==true) {
						arrObj[i].checked=false;
						//s=arrObj[i].name+",priv";
						//priv=eval(s).value;
						s=arrObj[i-1].name;
						priv=eval(arrObj[i-1]).value;
						checkDuplicate(arrObj[i],priv);
						checkHeader(arrObj,obj);
					}
				}
			}
		}
	}
}

function storeLines(obj) {
	var frmObj  = document.frmPrescriptionPrevOrdersResult;

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "order_id  =\"" + obj.name+ "\" " ;
	xmlStr+= "bean_id =\"" + frmObj.bean_id.value + "\" " ;
	xmlStr+= "bean_name=\"" + frmObj.bean_name.value + "\" " ;
	xmlStr +=" /></root>";

	 var temp_jsp="PrescriptionValidation_1.jsp?func_mode=copy_child";
	 var xmlDoc = "" ;
	 var xmlHttp = new XMLHttpRequest() ;
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	 xmlHttp.open("POST",temp_jsp,false);
	 xmlHttp.send(xmlDoc);
	 responseText=xmlHttp.responseText ;

	 eval(responseText);
}

function deleteLines(obj) {
	var frmObj  = document.frmPrescriptionPrevOrdersResult;

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "order_id  =\"" + obj.name+ "\" " ;
	xmlStr+= "bean_id =\"" + frmObj.bean_id.value + "\" " ;
	xmlStr+= "bean_name=\"" + frmObj.bean_name.value + "\" " ;
	xmlStr +=" /></root>";

	 var temp_jsp="PrescriptionValidation_1.jsp?func_mode=delete_child";
	 var xmlDoc = "" ;
	 var xmlHttp = new XMLHttpRequest() ;
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	 xmlHttp.open("POST",temp_jsp,false);
	 xmlHttp.send(xmlDoc);
	 responseText=xmlHttp.responseText ;
	 eval(responseText);
}

function resetCriteria() {
	document.frmPrescriptionPrevOrdersCriteria.reset();
}

function validateDate(locale) {
	from	=	document.frmPrescriptionPrevOrdersCriteria.order_date_from.value;
	to		=	document.frmPrescriptionPrevOrdersCriteria.order_date_to.value;
	if(!isBefore(from,to,'DMY',locale)){
		alert(getMessage("TO_DATE_EQUAL_GREATER_FROM_DATE", "PH"));
		document.frmPrescriptionPrevOrdersCriteria.order_date_to.focus();
	}
	else {
		showPrevOrdersResults();
	}
}

function checkForDischarge(obj) {
	var take_medication_yn_chk	=	document.prescription_header_form.take_medication_yn_chk.value;

	if(take_medication_yn_chk!="checked" && obj.checked==true) {
		alert(getMessage("PH_DISCHARGE_ADVICE_NOT_PREP", "PH"));
		obj.value	=	"N";
		obj.checked = false;
		return false;
	} 
	if(take_medication_yn_chk=="checked" && obj.checked==false) {
			document.prescription_header_form.patient_class.value="IP";
	}
	else {
		document.prescription_header_form.patient_class.value="OP";
	}
 	var buildMAR_rule=parent.f_detail.document.prescription_detail_form.buildMAR_rule_org.value;
	var buildMAR_yn=parent.f_detail.document.prescription_detail_form.buildMAR_yn.value;
	if(buildMAR_rule == "CE" || buildMAR_rule== "CD"){
		 parent.f_detail.document.prescription_detail_form.buildMAR_yn.disabled=false;
		parent.f_detail.document.prescription_detail_form.buildMAR_yn.checked=true;
		parent.f_detail.document.prescription_detail_form.buildMAR_yn.value="Y";
	}
	else if(buildMAR_rule =="UE" || buildMAR_rule =="UD"){
   parent.f_detail.document.prescription_detail_form.buildMAR_yn.checked=false;
   parent.f_detail.document.prescription_detail_form.buildMAR_yn.disabled=true;
		parent.f_detail.document.prescription_detail_form.buildMAR_yn.value="N";
	}
	if(obj.value =="Y"){
		 parent.f_detail.document.prescription_detail_form.buildMAR_yn.checked=false;
		   parent.f_detail.document.prescription_detail_form.buildMAR_yn.disabled=true;
				parent.f_detail.document.prescription_detail_form.buildMAR_yn.val
	}
		//return true;
}
//added for NMC-JD-CRF-0063
function checkOpDischargeMed(obj) {
	//alert("checkOpDischargeMed()");  
	var patient_id = document.prescription_header_form.patient_id.value;
	var encounter_id = document.prescription_header_form.encounter_id.value;
	var dischMedcheck = "";
	if(obj.checked==true){
		dischMedcheck ="Y";
	}
	else{
		dischMedcheck ="N";
	}
	
	 var bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	 var bean_name		= "ePH.PrescriptionBean_1";
	

		var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr+= "dischMedcheck =\"" + dischMedcheck + "\" " ;
		xmlStr +=" /></root>";

		var temp_jsp="../../ePH/jsp/PrescriptionValidation_1.jsp?func_mode=checkOpDischargeMed";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
}


function checkReasonDuplicate(frmObj){
	var frequency;
	var current_rx		=	frmObj.current_rx.value;
	var allow_duplicate	=	frmObj.allow_duplicate.value;
	var patient_class	=	frmObj.patient_class.value;
	var take_home		=	frmObj.take_home.value;
	var sliding_scale	=	false;
	if(frmObj.frequency==null) {
		frequency		=	parent.f_sliding_scale_admin_dtls.prescription_detail_form.frequency.value;
		sliding_scale	=	true;
	} else {
		frequency		=	frmObj.frequency.value;
	}
    var freq_nature		=	frmObj.freq_nature.value;
	var result			=	true;
	if(current_rx=="Y" && allow_duplicate=="N" && (patient_class=="IP" || parseInt(take_home)>0) && freq_nature!="O" ) {
		result		=	false;
	}
	
	if(sliding_scale) {
		result	=	true;
	}
	return result;
}

function checkonce(obj,order_id){
	var frmObj = document.frmPrescriptionPrevOrdersResult;
	var frmObj_button = parent.f_prev_orders_buttons.document.frmPrescriptionPrevOrdersButton;
	var rx_type = frmObj.rx_type.value;
	if(obj.checked==true)
		order_id_prev = order_id;
	else
		order_id_prev = "";
	
	frmObj_button.order_id.value="";

	var arrObj	= frmObj.elements;
	var name=obj.name;
	var k=parseInt(0);
	if(rx_type!="") {
	frmObj_button.order_id.value=order_id;
		if(obj.checked==true){
			checkDuplicateIV(obj); //added for IN24251 --16/12/2010-- priya
			for(var i=0;i<arrObj.length;i++){
				if(arrObj[i].type=="checkbox"){
				   if((arrObj[i].name)!=name){
					   arrObj[i].disabled=true;
					}
				}
			}
			frmObj.checkcount.value=1;
		}
		else if(obj.checked==false){
			frmObj_button.order_id.value="";
			for(var i=0;i<arrObj.length;i++){
				if(arrObj[i].type=="checkbox"){
					   arrObj[i].disabled=false;
				}
			}
			frmObj.checkcount.value=0;
		}
	}
}

function getMAR_app_yn(headerFormObj){
	var patient_class = headerFormObj.actual_patient_class.value;
	var take_home_med = headerFormObj.take_home_medication.value;
	var MAR_app_yn="";
	if(take_home_med=='Y')
		MAR_app_yn =  headerFormObj.disch_med_mar_appl_yn.value; 
	else if(patient_class == 'DC')
		MAR_app_yn =  headerFormObj.dc_mar_appl_yn.value; 
	else if(patient_class == 'EM')
		MAR_app_yn =  headerFormObj.em_mar_appl_yn.value; 
	else if(patient_class == 'IP')
		MAR_app_yn =  headerFormObj.ip_mar_appl_yn.value; 
	else if(patient_class == 'OP')
		MAR_app_yn =  headerFormObj.op_mar_appl_yn.value; 
	return MAR_app_yn;
}


async function callADRdetails(patient_id){

	var dialogHeight= "95vh" ;
	var dialogWidth	= "90vw" ;
	var dialogTop = "" ;
	var dialogLeft = "" ;
	var center = ""  ;
	var status="no";
	var scroll="no";

	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await top.window.showModalDialog("../../ePH/jsp/AdrReportingFrame_1.jsp?type=query "+"&status=S"+"&patient_id="+patient_id ,arguments,features);
	
}
async function openEDLDetails(DrugCode){
 // alert("DrugCode---->"+DrugCode)
	if(DrugCode!=''&&DrugCode!=null){
		var dialogHeight	= "94vh";
		var dialogWidth		= "41vw";
		var center			= "1";
		var status			= "no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status;
		var arguments		= "";
		
		await top.window.showModalDialog("../../ePH/jsp/EDLAssociateListViewFrames.jsp?DrugCode="+DrugCode, arguments, features);
	}
 
}//end function

function checkHeaderonLoad(){
	
	var frmObj = document.frmPrescriptionPrevOrdersResult;
	var arrObj=frmObj.elements;
	var names;
	 for(var i=0;i<arrObj.length;i++) {
			if(arrObj[i].type=="checkbox"){	
				names	=	arrObj[i].name.split(",");
				if(names.length>1){
					checkHeader(arrObj,arrObj[i]);
				}
			}
	}
}

function checkCurrentMedn(system_date,end_date,order_id,order_line_num,ord_status_obj){
	var answer;
	var frmObj  = document.frmPrescriptionPrevOrdersResult;
	//var discharge_ind = parent.f_prev_orders_criteria.frmPrescriptionPrevOrdersCriteria.discharge_ind.value;//Added for BRU-HIMS-CRF-403 // commented for #70618
	var discharge_ind = ""; // Added for #70618 - Start
	if(frmObj==undefined){
		frmObj = document.frmPrescriptionPrevOrdersResult1;
		discharge_ind = frmObj.discharge_ind.value;
	}
	else{
	    discharge_ind = parent.f_prev_orders_criteria.frmPrescriptionPrevOrdersCriteria.discharge_ind.value;//Added for BRU-HIMS-CRF-403
	} // Added for #70618 - End
	 
	if(ord_status_obj!="DC" && ord_status_obj!="CN"){ //if condition added for IN22804 --22/07/2010-- priya
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id =\"" + frmObj.bean_id.value + "\" " ;
		xmlStr+= "bean_name=\"" + frmObj.bean_name.value + "\" " ;
		xmlStr+= "system_date=\""	+ system_date + "\" " ;
		xmlStr+= "discharge_ind=\""	+ discharge_ind + "\" " ;//Added for BRU-HIMS-CRF-403 
		xmlStr+= "end_date=\"" +end_date + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PrescriptionValidation_1.jsp?func_mode=validateDateTime1";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;	
		answer = eval(responseText);
	}
	else{
		answer = true;
	}
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "answer =\"" + answer + "\" " ;
	xmlStr+= "bean_id =\"" + frmObj.bean_id.value + "\" " ;
	xmlStr+= "bean_name=\"" + frmObj.bean_name.value + "\" " ;
	xmlStr+= "curr_date_order_id=\""	+ order_id + "\" " ;
	xmlStr+= "curr_date_order_line_num=\""	+order_line_num + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="PrescriptionValidation_1.jsp?func_mode=curr_medn_drugs";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;	
	eval(responseText);
}

function showAlert(msg){
	alert(getMessage(msg,'PH'));	
}
/*=============================================================================================================*/
//added for IN24251 --16/12/2010-- priya
function checkDuplicateIV(obj){
	obj_code	=	obj.value;
	var frmObj = document.frmPrescriptionPrevOrdersResult;
	var arrObj	= frmObj.elements;
	var prescription	=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.group_by[0].checked;
	var end_date;
	var chk_obj_name;
	var end_date_obj;
	var drug_code;
	var ord_status_obj;
	var discont;
	var end_dates = "";

	if(obj.checked==true) {
		for(var i=0; i<arrObj.length; i++) {
			if(arrObj[i].type=="hidden"){
				end_dates	=	arrObj[i].name.split(",");
				if(end_dates.length>1){
					chk_obj_name = end_dates[0];
					if(obj.name==chk_obj_name && end_dates[1]=="end_date_iv"){
						end_date = arrObj[i].value; 
						for(var j=0; j<arrObj.length; j++) {
							if(arrObj[j].type=="hidden"){
								discont	=	arrObj[j].name.split(",");
								if(discont.length>1){
									chk_obj_name = discont[0];
									if(obj.name==chk_obj_name && discont[1]=="ord_status_iv"){
										ord_status_obj = arrObj[j].value;
										break;
									}
								}
							}
						}
						checkCurrentMednIV(frmObj.system_date.value,end_date,end_dates[0],ord_status_obj,chk_obj_name);
						break;
					}
				} 
			}
		 }
	}
}

function checkCurrentMednIV(system_date,end_date,end_dates_0,ord_status_obj,ord_id){
	var frmObj  = document.frmPrescriptionPrevOrdersResult;
	var arrObj	= frmObj.elements;
	var chk_obj_name;
	var discont;
	if(ord_status_obj!="DC" && ord_status_obj!="CN"){
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id =\"" + frmObj.bean_id.value + "\" " ;
		xmlStr+= "bean_name=\"" + frmObj.bean_name.value + "\" " ;
		xmlStr+= "system_date=\""	+ system_date + "\" " ;
		xmlStr+= "end_date=\"" +end_date + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PrescriptionValidation_1.jsp?func_mode=validateDateTime1";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;	

		var answer = eval(responseText);
	}
	else{
			var answer = true;
	}

	for(var j=0; j<arrObj.length; j++){
		if(arrObj[j].type=="hidden"){
			discont	=	arrObj[j].name.split(",");
			if(discont.length>1){
				chk_obj_name = discont[0];
				if(ord_id==chk_obj_name && discont[1]=="answer_iv"){
					if(answer == true)
						arrObj[j].value = "Y";
					else
						arrObj[j].value = "N";
					break;
				}
			}
		}
	}				

}
/*=============================================================================================================*/
// added for Bru-HIMS-CRF-0265 [IN032315] -- begin
async function enableDiscCancelOrders(patient_id,encounter_id,generic_id,start_date,end_date,freq_code,drug_code,srlNo,drug_db_interface_yn,ext_prod_id,mode,sliding_flag){
	var btnDiscOrders;
	if(mode == 'C'){
		btnDiscOrders = document.prescription_button.btnDiscOrders
	}
	else if(mode =='R'){
		btnDiscOrders = parent.parent.f_button.document.prescription_button.btnDiscOrders
	}
	
	if(btnDiscOrders!= undefined && btnDiscOrders.style.display == 'none'){//btnDiscOrders!= undefined added for icn after click on confirm system not responding
		btnDiscOrders.style.display = "";
		callDiscCancelOrders(patient_id,encounter_id,generic_id,start_date,end_date,freq_code,drug_code,srlNo,drug_db_interface_yn,ext_prod_id,mode,sliding_flag,"N");//last parameter added for MO-CRF-0029
	}
}

async function callDiscCancelOrders(patient_id,encounter_id,generic_id,start_date,end_date,freq_code,drug_code,srlNo,drug_db_interface_yn,ext_prod_id,mode,sliding_flag,skip_duplicte_alert,ph_drug_overlap_period,locale,previous_order_date,cancel_exit_yn){ // skip_duplicte_alert,ph_drug_overlap_period,locale,previous_order_date Added for MO-CRF-20085.1 [IN057392] and cancel_exit_yn  added for MO-CRF-20159
	var con=true;
	if(sliding_flag=="Y" )
	{
		if(parent.parent.f_header)
			frmObj=parent.parent.f_header.prescription_header_form;
		else
			frmObj=parent.f_header.prescription_header_form;
		
	}//if & else block moved from down for ML-BRU-SCF-1587 [IN:054876] 
	else
	{
		if(parent.parent.f_header)
			frmObj=parent.parent.f_header.prescription_header_form;
		else
			frmObj=parent.f_header.prescription_header_form;
	}
	var take_home_medication =  frmObj.take_home_medication.value; //added for ML-BRU-SCF-1587 [IN:054876]
	
//	var frmObj = parent.f_detail.document.prescription_detail_form;  // added for IN073372   and commented for ML-BRU-SCF-2080
	var disc_cancel_flag = frmObj.disc_cancel_flag.value;//MO-CRF-20159
	if(mode != "buttons"){
		var msg = getMessage("PH_CAN_DISCON_DUP_DRUG", "PH");
		if(skip_duplicte_alert == "Y" && previous_order_date!="" && ph_drug_overlap_period!="") { // condition Added for MO-CRF-20085.1 [IN057392] - Start
			if(daysBetween(previous_order_date, start_date, "DMYHM", locale)<=ph_drug_overlap_period){
			vbC=false;
			document.prescription_detail_form.override_remarks.checked=true;
			}				
		} // condition Added for MO-CRF-20085.1 [IN057392]  - End
		else{
			if(cancel_exit_yn!="Y") {//if added for MO-CRF-20159
			//	alert("1");
			vbC= jsConfirm(msg);
			}
		}
		
		if(vbC==true) con=true;
		else {
			
			con=false;
		if(disc_cancel_flag==true || disc_cancel_flag=="true"){//if addedf or MO-CRF-20159
			
			await addDrug('delete',"Y");//added for MO-CRF-20159
		}
		}
	}
	else{
		if(sliding_flag!="Y"){
			generic_id	= parent.frames[2].document.forms[0].generic_id.value;
			start_date	= parent.frames[2].document.forms[0].start_date.value;
			end_date	= parent.frames[2].document.forms[0].end_date.value;
			freq_code	= parent.frames[2].document.forms[0].freq_code.value;
			drug_code	= parent.frames[2].document.forms[0].drug_code.value;
			ext_prod_id = parent.frames[2].document.forms[0].ext_prod_id.value;
		}
		else{
			return;
		}
	}
	
	if(con){
		if(generic_id==undefined)
			generic_id="";
		
		var dialogHeight= "80vh" ;
		var dialogWidth	= "80vw" ;
		var dialogTop = "0" ;
		var dialogLeft = "70" ;
		var center = "0" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+';dialogLeft:'+dialogLeft;
		var arguments	= "" ;
		retVal = await top.window.showModalDialog("../../ePH/jsp/PrescriptionDiscCancelOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&start_date="+start_date+"&end_date="+end_date+"&call_from="+mode+"&take_home_medication="+take_home_medication,arguments,features);// added take_home_medication for ML-BRU-SCF-1587 [IN:054876]
		
		if((retVal==undefined || retVal=="false") && disc_cancel_flag=="true" ){ //added for MO-CRF-20159 and modified for MO-CRF-20159
			await callDiscCancelOrders(patient_id,encounter_id,generic_id,start_date,end_date,freq_code,drug_code,srlNo,drug_db_interface_yn,ext_prod_id,mode,sliding_flag,skip_duplicte_alert,ph_drug_overlap_period,locale,previous_order_date,"Y");
	}
		if(retVal=="reload")
			window.close();
			
		var bed_num				= frmObj.bed_num.value;
		var room_num			= frmObj.room_num.value;
		var patient_class		= frmObj.patient_class.value;
		var order_date_time		= frmObj.sys_date.value;
		var mode				= "blank";
		var drug_db_duptherapy_yn = frmObj.drug_db_duptherapy_yn.value;
		var drug_db_product_id = frmObj.drug_db_product_id.value;

		var bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
		var bean_name		= "ePH.PrescriptionBean_1";

		var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr+= "patient_id=\"" + patient_id + "\" " ;
		xmlStr+= "generic_id=\"" + generic_id + "\" " ;
		xmlStr+= "start_date=\"" + start_date + "\" " ;
		xmlStr+= "freq_code=\"" + freq_code + "\" " ;
		xmlStr+= "drug_code=\"" + drug_code + "\" " ;
		xmlStr+= "srlNo=\"" + srlNo + "\" " ;
		xmlStr+= "drug_db_interface_yn=\"" + drug_db_interface_yn + "\" " ;
		xmlStr+= "drug_db_duptherapy_yn=\"" + drug_db_duptherapy_yn + "\" " ;
		xmlStr+= "ext_prod_id=\"" + ext_prod_id + "\" " ;
		xmlStr+= "drug_db_product_id=\"" + drug_db_product_id + "\" " ;
		
		xmlStr +=" /></root>";
		var temp_jsp="PrescriptionValidation_2.jsp?func_mode=discCancelDrug";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		if(retVal == 'true'){
			if(sliding_flag=="Y"){
				parent.parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num;
				parent.f_sliding_scale_dtls.location.href="../../ePH/jsp/PrescriptionSlidingScaleDetail.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&mode=modify&patient_class="+patient_class+"&start_date="+encodeURIComponent(order_date_time)+"&bed_num="+bed_num+"&room_num="+room_num+"&srl_no="+srlNo+"&drug_code="+drug_code;
				//parent.parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&sliding_scale_yn=Y";
			}
			else{
				parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num;
				parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+encodeURIComponent(order_date_time)+"&bed_num="+bed_num+"&room_num="+room_num;
				parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_1.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num;
			}
		}
	}
}
//------------------------cancel , pharmacy
async  function callMenuFunctions(colval1,colval,patient_id,encounter_id,orderId,order_line_num,order_status,cont_order_ind,ord_cat,catalog_code,generic_id,sex,ord_typ_code,source_accession_type){

	var dialogHeight   = "70vh" ;
	var dialogWidth    = "70vw" ;
	var dialogTop	   = '';
	var dialogLeft     = '' ;		
	var title = 'rewe'
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments = "";
	var finalString	= "from=line&colval1="+colval1+"&colval="+colval+"&orderId="+orderId+"&val1="+ord_cat+"&patient_id="+patient_id+"&cont_order_ind="+cont_order_ind+"&order_status="+order_status+"&sex="+sex+"&ord_cat="+colval+"&ord_typ_code="+ord_typ_code+"&catalog_code="+catalog_code+"&ord_cat_id="+ord_cat+"&source_accession_type="+source_accession_type+"&order_line_num="+order_line_num+"&catalog_code="+catalog_code;
	var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}

async function recordDiscCanValue(disc_vals,cancel_vals,patient_id,generic_id,encounter_id,alternate_amend_yn){//added alternate_amend_yn for JD-CRF-0198 [IN058599]
	var title = 'rewe'
	if(disc_vals!='' && cancel_vals!=''){
		var dialogHeight ='40vh' ;
		var dialogWidth = '40vw' ;
		var dialogTop	= '10';
		var dialogLeft = '10' ;
	}
	else{
		var dialogHeight ='40vh' ;
		var dialogWidth = '40vw' ;
		var dialogTop	= '10';
		var dialogLeft = '10' ;
	}
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments = "";
	var finalString = "from=line&colval1=Discontinue"+"&colval=Pharmacy&ord_cat_id=PH&disc_vals="+disc_vals+"&cancel_vals="+cancel_vals+"&generic_id="+generic_id+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&alternate_amend_yn="+alternate_amend_yn;//added alternate_amend_yn for  JD-CRF-0198 [IN058599]
	var retVals =await top.window.showModalDialog("../../ePH/jsp/DuplicateDiscCancReason.jsp?"+finalString,arguments,features);
	return retVals;
}

function displayDesc(obj, called_from){
	if(called_from == 'D')
		document.forms[0].disc_reason_desc.value = obj.value;
	else
		document.forms[0].cancel_reason_desc.value = obj.value;
}

async function discCancValue(patient_id,patient_class,order_date,take_home,curr_generic_id,encounter_id){
	var formObj = document.DiscCancelOrderDetailsForm;
	var tot_rec_count = formObj.tot_rec_count.value;
	var disc_vals="", cancel_vals = "", performType, sel_count=0, clearDupYN="N", generic_id_vals=""; 
	var genericIdsCount = formObj.genericIdsCount.value; //added for HSA-CRF-0151 [IN:048468]
	var genericRecCount=0; //added for HSA-CRF-0151 [IN:048468]
	var generic_id =""; //added for HSA-CRF-0151 [IN:048468]
	var genericSelSount  =0;
	var refreshScreen = false;
	for (var generic=0;  generic<parseInt(genericIdsCount); generic++){ // tot_rec_count changed to genericIdsCount for HSA-CRF-0151 [IN:048468]
		generic_id = eval("formObj.genericId_"+generic).value //added for HSA-CRF-0151 [IN:048468]
		genericRecCount = eval("formObj.genericRecCount_"+generic_id).value //added for HSA-CRF-0151 [IN:048468]
		genericSelSount = 0;
		for (var i=0; i<parseInt(genericRecCount);i++) { //added for HSA-CRF-0151 [IN:048468]
			var selectObj = eval("formObj.select_"+generic_id+"_"+i);
			if(selectObj.checked==true){
				performType = eval("formObj.performType_"+generic_id+"_"+i).value;
				order_id = eval("formObj.order_id_"+generic_id+"_"+i).value;
				pract_id = eval("formObj.pract_id_"+generic_id+"_"+i).value;
				drug_code = eval("formObj.drug_code_"+generic_id+"_"+i).value;
				order_line_no = eval("formObj.order_line_no_"+generic_id+"_"+i).value;
				pres_drug_code = eval("formObj.pres_drug_code"+generic_id+"_"+i).value;  //Added for HSA-CRF-0138 [IN:048414]
				pres_generic_id = eval("formObj.pres_generic_id"+generic_id+"_"+i).value;  //Added for HSA-CRF-0138 [IN:048414]
				sel_count++;
				genericSelSount ++;
				if(performType == 'D'){
					if(disc_vals !="")
						disc_vals=disc_vals+"^"+order_id+"~"+pract_id+"~"+drug_code+"~"+order_line_no+"~"+pres_drug_code+"~"+pres_generic_id;  //+"~"+pres_drug_code Added for HSA-CRF-0138 [IN:048414]
					else	
						disc_vals=order_id+"~"+pract_id+"~"+drug_code+"~"+order_line_no+"~"+pres_drug_code+"~"+pres_generic_id;  // +"~"+pres_drug_code Added for HSA-CRF-0138 [IN:048414]
				}
				else{
					if(cancel_vals != "")
						cancel_vals=cancel_vals+"^"+order_id+"~"+pract_id+"~"+drug_code+"~"+order_line_no+"~"+pres_drug_code+"~"+pres_generic_id;  // +"~"+pres_drug_code Added for HSA-CRF-0138 [IN:048414]
					else
						cancel_vals=order_id+"~"+pract_id+"~"+drug_code+"~"+order_line_no+"~"+pres_drug_code+"~"+pres_generic_id;  // +"~"+pres_drug_code Added for HSA-CRF-0138 [IN:048414]
				}
			}
		}
		if(parseInt(genericRecCount) == parseInt(genericSelSount)){ //if block added for HSA-CRF-0151 [IN:048468]
			if(generic_id_vals !="")
				generic_id_vals = generic_id_vals+"~"+generic_id;
			else
				generic_id_vals = generic_id;
			refreshScreen = true;
		}
	}
	if( sel_count==0){
		alert(getMessage('PH_ATLEAST_ONE_DISC_CANCEL_SELECTED','PH'));
		document.forms[0].cancel.disabled=false;
		return;
	}
	/*if(tot_rec_count == sel_count) //Commented for HSA-CRF-0151 [IN:048468]
		clearDupYN = "Y";*/
	genericRecCount = eval("formObj.genericRecCount_"+curr_generic_id).value //added for HSA-CRF-0151 [IN:048468] -start
	var retVal = await recordDiscCanValue(disc_vals,cancel_vals, patient_id,generic_id,encounter_id, clearDupYN );
	if(refreshScreen){
		updateCurrentRx(patient_id, encounter_id, generic_id_vals);
		clearDupYN = "Y"; //added for HSA-CRF-0151 [IN:048468] -end
	}
	var retVal1 = retVal;
	if(retVal=='true' && clearDupYN =='Y')
		retVal1='true';
	else 
		retVal1 = 'false';
	window.returnValue=retVal1;
	if(retVal == 'true')
		window.close();
}

function ChkMaxLen(lab,obj,max) {
	var val = "";
	val = obj.value;
	if(obj.value.length > max){
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",lab);
		msg = msg.replace("#",max);
		alert(msg);
		return false;
		//obj.value = val.substring(0,max);
	}
}

function checkDrugIndMaxLimit(obj,maxLeng) { 
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("Common.remarks.label","Common"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,maxLeng);
		return false;
	} 
	else 
		return true;
}

function discCancelLineRecord(disc_vals,cancel_vals){
	var frmObj=document.discontinue_line;
	var discOrdersYN	=	frmObj.discOrdersYN.value;
	var cancelOrdersYN	=	frmObj.cancelOrdersYN.value;
	var disc_reason	=	frmObj.disc_reason.value;
	var cancel_reason	=	frmObj.cancel_reason.value;
	if((discOrdersYN=='Y' && disc_reason =='')||(cancelOrdersYN=='Y' && cancel_reason=="")){
		alert(getMessage('PH_REASON_NOT_SELECTED','PH'));
		return;
	}
	else{	
		var pract_id		=	frmObj.pract_id.value;
		var bean_id			=	frmObj.bean_id1.value;
		var bean_name		=	frmObj.bean_name1.value;
		var generic_id		=	frmObj.generic_id.value;
		var encounter_id	=	frmObj.encounter_id.value;
		var patient_id		=	frmObj.patient_id.value;
		var disc_reason_desc		=	frmObj.disc_reason_desc.value;
		var cancel_reason_desc		=	frmObj.cancel_reason_desc.value;
		if(discOrdersYN=='Y' && disc_reason_desc == '')
			disc_reason_desc = frmObj.disc_reason.options[frmObj.disc_reason.selectedIndex].text;
		if(cancelOrdersYN=='Y' && cancel_reason_desc == '')
			cancel_reason_desc = frmObj.cancel_reason.options[frmObj.cancel_reason.selectedIndex].text;

		var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr+= "pract_id=\"" + pract_id + "\" " ;
		xmlStr+= "disc_vals=\"" + disc_vals + "\" " ;
		xmlStr+= "cancel_vals=\"" + cancel_vals + "\" " ;
		xmlStr+= "disc_reason=\"" + disc_reason + "\" " ;
		xmlStr+= "cancel_reason=\"" + cancel_reason + "\" " ;
		xmlStr+= "disc_reason_desc=\"" + encodeURIComponent( disc_reason_desc,"UTF-8") + "\" " ; 
		xmlStr+= "cancel_reason_desc=\"" +  encodeURIComponent( cancel_reason_desc,"UTF-8") + "\" " ;
		xmlStr+= "generic_id=\"" + generic_id + "\" " ;
		xmlStr+= "encounter_id=\"" + encounter_id + "\" " ;
		xmlStr+= "patient_id=\"" + patient_id + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PrescriptionValidation_2.jsp?func_mode=recordDiscCanc";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
}

function getResult(_result, _message, _flag, _val){
	if(_message!="Discontinue")  // if condition added for JD-CRF-0198 [IN058599]
		alert(_message);
	if(_result){
		onSuccess1();
	}
	//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
}

function onSuccess1() {
	window.returnValue="true";
	window.close();
}

function closeReason(){
	window.retuvnValue="false";
	window.close();
}//added for Bru-HIMS-CRF-265 [IN:032315] -- end

function copiedDischargeDrugs() {//Added for Bru-HIMS-CRF-403--START
	var frmObj	=	parent.f_prev_orders_results.document.frmPrescriptionPrevOrdersResult;
	var bean_id			=	frmObj.bean_id.value;
	var bean_name		=	frmObj.bean_name;
	var flag = 0;
	var arrObj	= frmObj.elements;
	var iv_prep_yn ="";
	var ord_id = "";
	var chk_obj_name = "";
	var discont = "";
	var answer = "";
	for(var i=0;i<arrObj.length;i++){
		if((arrObj[i].type=="checkbox")){
			var classname= parent.f_prev_orders_results.document.getElementById('ord_'+arrObj[i]).name.className;

			if((arrObj[i].checked==true)&&(classname=="CURRTEXT")){
				flag=1;
				ord_id = arrObj[i].name;
				iv_prep_yn = eval("parent.f_prev_orders_results.document.frmPrescriptionPrevOrdersResult.iv_prep_yn"+ord_id).value;
				for(var j=0; j<arrObj.length; j++){
					if(arrObj[j].type=="hidden"){
						discont	=	arrObj[j].name.split(",");
						if(discont.length>1){
							chk_obj_name = discont[0];
							if(ord_id==chk_obj_name && discont[1]=="answer_iv"){
								if(arrObj[j].value == "Y")
									answer = "Y";
								else
									answer = "N";
								break;
							}
						}
					}
				}
			}
			else if (arrObj[i].checked==true){
				flag=1;
				names	=	arrObj[i].name.split(",");
				ord_id=names[0];
			}
		}
	}
	if(flag == 0  && frmObj.checkcount.value=='0'){
		alert(getMessage("PH_ATLEAST_ONE_SELECTED","PH")); 
		return;
	}
	var pat_id=document.forms[0].patient_id.value;
	var enc_id=document.forms[0].enc_id.value;
	var called_from="disc";
	var pat_class		=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.patient_class.value;
	var self			=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.orders[0].checked;
	var ord_status		=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.ord_status.value;
	var order_from		=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.order_date_from.value;
	var order_to		=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.order_date_to.value;
	var prescription	=	parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.group_by[0].checked;
	var order_id		=	document.frmPrescriptionPrevOrdersButton.order_id.value;
	var pract_id		=	"";
	var rx_type			=  parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.rx_type.value;

	if(self==true)
		pract_id		= parent.f_prev_orders_criteria.document.frmPrescriptionPrevOrdersCriteria.pract_id.value;
	else
		pract_id		= "";

	if(prescription==true)
		group_by	=	"PR";
	else
		group_by	=	"DR";
	
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="PrescriptionValidation_2.jsp?func_mode=copy_selected_drugs";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);

	parent.document.getElementById('discharerows').rows = '22%,0%,0%,78%';
	parent.f_prev_orders_disc.location.href="../../ePH/jsp/PrescriptionPrevOrdersFramesDischargeMed.jsp?pat_id="+pat_id+"&enc_id="+enc_id+"&pat_class="+pat_class+"&ord_status="+ord_status+"&order_from="+order_from+"&order_to="+order_to+"&pract_id="+pract_id+"&order_id="+order_id+"&rx_type="+rx_type+"&called_from="+called_from;
}

function chktoRestore(){
	var frmObj	=	parent.f_prev_orders_disc_results.document.frmdischPrescriptionPrevOrdersResult;
	var bean_id			=	frmObj.bean_id.value;
	var bean_name		=	frmObj.bean_name;
	parent.parent.document.getElementById('discharerows').rows = '22%,70%,7%,0%';
	//parent.parent.f_prev_orders_criteria.frmPrescriptionPrevOrdersCriteria.btnCriteriaSearch.click();
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="PrescriptionValidation_2.jsp?func_mode=empty_values";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);

}

function copieddiscDrugs(frmObj,called_from) {
	if(frmObj == undefined)
		frmObj	=	parent.f_prev_orders_disc_results.document.frmdischPrescriptionPrevOrdersResult;
	if(called_from == undefined)
		called_from = "Copy";
	var bean_id			=	frmObj.bean_id.value;
	var bean_name		=	frmObj.bean_name.value;
	var flag = 0;
	var arrObj	= frmObj.elements;
	var iv_prep_yn ="";
	var ord_id = "";
	var chk_obj_name = "";
	var discont = "";
	var answer = "";
	var call_from = "disc";

	for(var i=0;i<arrObj.length;i++){
		if((arrObj[i].type=="checkbox")){
			var classname= parent.f_prev_orders_disc_results.document.getElementById('ord_'+arrObj[i]).name.className;
			if((arrObj[i].checked==true)&&(classname=="CURRTEXT")){
				flag=1;
				ord_id = arrObj[i].name;
				for(var j=0; j<arrObj.length; j++){
					if(arrObj[j].type=="hidden"){
						discont	=	arrObj[j].name.split(",");
						if(discont.length>1){
							chk_obj_name = discont[0];
							if(ord_id==chk_obj_name && discont[1]=="answer_iv"){
								if(arrObj[j].value == "Y")
									answer = "Y";
								else
									answer = "N";
								break;
							}
						}
					}
				}
			}
			else if (arrObj[i].checked==true){
				flag=1;
				names	=	arrObj[i].name.split(",");
				ord_id=names[0];
			}
		}
	}
	if(flag == 0 ){
		alert(getMessage("PH_ATLEAST_ONE_SELECTED","PH")); 
		return;
	}
	var durn_value=document.forms[0].durn_value.value;
	var order_date_from=document.forms[0].order_date_from.value;
	var order_date_to=document.forms[0].order_date_to.value;
	var dupOverRideReason;
	var durn_desc = document.getElementById("durn_desc").value;

	if(durn_value=='' || order_date_to==''|| order_date_from==''){
	   alert(getMessage("ALL_MANDATORY_FIELDS","Common"));
	   return false;
	}
	if(parseInt(durn_value)==0){
		alert(getMessage("PRES_DURN_CANNOT_ZERO", "PH"));
		document.forms[0].durn_value.value="";
		return false;
	}
	if(document.forms[0].dupOverRideReason!=undefined){
		dupOverRideReason=document.forms[0].dupOverRideReason.value;
		if(dupOverRideReason==''){
			alert(getMessage("OVERRIDE_REASON_NOT_BLANK", "PH"));//Modified for BRU-HIMS-CRF-403 
			return false;
		}
		else if(dupOverRideReason!='' && dupOverRideReason.length>255){//Added for IN047995--START
			var errors = getMessage("REMARKS_CANNOT_EXCEED","Common");
			errors = errors.replace("$", "Duplicate drug override reason");
			errors = errors.replace("#","255");
			alert(errors);
			return false;
		}
		else{
			dupOverRideReason = encodeURIComponent( dupOverRideReason,"UTF-8");
		}//Added for IN047995--end
	}

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr+= "order_date_from=\"" + order_date_from+ "\" " ;
	xmlStr+= "order_date_to=\"" + order_date_to+ "\" " ;
	xmlStr+= "dupOverRideReason=\"" + dupOverRideReason+ "\" " ;
	xmlStr+= "durn_value=\"" + durn_value+ "\" " ;
	xmlStr+= "durn_desc=\"" + durn_desc+ "\" " ;
	xmlStr+= "iv_prep_yn=\"" + iv_prep_yn+ "\" " ;
	xmlStr+= "order_id=\"" + ord_id+ "\" " ;
	xmlStr+= "answer=\"" + answer+ "\" " ;
	xmlStr+= "call_from=\"" + call_from+ "\" " ;
	xmlStr+= "called_from=\"" + called_from+ "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="PrescriptionValidation_2.jsp?func_mode=copied_drugs";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

async function showDisccancel(patient_id,encounter_id,generic_id,start_date,end_date,freq_code,drug_code,srlNo,drug_db_interface_yn,ext_prod_id,mode,sliding_flag){
	
	var con=true;
	var called_from="dateschange";
	if(mode != "buttons"){
		var msg = getMessage("PH_CAN_DISCON_DUP_DRUG", "PH");
		vbC=jsConfirm(msg);
		if(vbC==true) 
			con=true;
		else
			con=false;
	}
	if(con){
		if(generic_id==undefined)
			generic_id="";

		var dialogHeight= "27" ;
		var dialogWidth	= "75" ;
		var dialogTop = "220" ;
		var dialogLeft = "70" ;
		var center = "0" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+';dialogLeft:'+dialogLeft;
		var arguments	= "" ;
		retVal =await  window.showModalDialog("../../ePH/jsp/PrescriptionDiscCancelOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&start_date="+start_date+"&end_date="+end_date,arguments,features);
		if(retVal!=undefined && retVal=="true"){
			var formobjbut=parent.f_prev_orders_disc_buttons.frmdischPrescriptionPrevButtons;
			var start_date = formobjbut.order_date_from.value;
			var end_date = formobjbut.order_date_to.value;
			var durn_value = formobjbut.durn_value.value;
			var durn_desc = formobjbut.durn_desc.value;
			var formobj = parent.f_prev_orders_disc_results.frmdischPrescriptionPrevOrdersResult;
			var patient_id= formobj.patient_id.value;
			var encounter_id= formobj.encounter_id.value;
			var pat_class= formobj.pat_class.value;
			var ord_status= formobj.ord_status.value;
			var order_from= formobj.order_from.value;
			var pract_id= formobj.pract_id.value;
			var order_id= formobj.order_id.value;
			var order_to= formobj.order_to.value;
			var rx_type= formobj.rx_type.value;
			var bean_id			=	formobj.bean_id.value;
			var bean_name		=	formobj.bean_name.value;
			called_from="dateschange";
			/*var xmlStr ="<root><SEARCH ";//Commented for IN048127--start
			xmlStr+= "bean_id =\"" + bean_id + "\" " ;
			xmlStr+= "bean_name=\"" + bean_name + "\" " ;
			xmlStr +=" /></root>";
			var temp_jsp="PrescriptionValidation_2.jsp?func_mode=copy_selected_drugs_refresh";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);*///Commented for IN048127--end
			parent.f_prev_orders_disc_results.location.href="../../ePH/jsp/PrescriptionPrevOrdersDischargeMed.jsp?pat_id="+patient_id+"&enc_id="+encounter_id+"&pat_class="+pat_class+"&pat_class="+pat_class+"&order_from="+order_from+"&pract_id="+pract_id+"&order_id="+order_id+"&order_to="+order_to+"&rx_type="+rx_type+"&called_from="+called_from+"&ord_status="+ord_status+"&start_date="+start_date+"&end_date="+end_date;
			parent.f_prev_orders_disc_buttons.location.href="../../ePH/jsp/PrescriptionPrevButtonsDischargeMed.jsp?pat_id="+patient_id+"&enc_id="+encounter_id+"&pat_class="+pat_class+"&pat_class="+pat_class+"&order_from="+order_from+"&pract_id="+pract_id+"&order_id="+order_id+"&order_to="+order_to+"&rx_type="+rx_type+"&called_from="+called_from+"&ord_status="+ord_status+"&start_date="+start_date+"&end_date="+end_date+"&dur_val="+durn_value+"&durn_desc="+durn_desc;
		}
	}
}

function populateEndDateDisc(){
	var frmObj_pres_dtl;
	frmObj_pres_dtl	= document.frmdischPrescriptionPrevButtons;
	var dur_val = frmObj_pres_dtl.durn_value.value;
	var start_date = frmObj_pres_dtl.order_date_from.value;
	var end_date = frmObj_pres_dtl.order_date_to.value;
	var durn_desc = document.getElementById("durn_desc").value;
	var bean_id			=	frmObj_pres_dtl.bean_id.value;
	var bean_name		=	frmObj_pres_dtl.bean_name.value;
	if(dur_val=='')
		return false;
	if(parseInt(dur_val)==0){
		alert(getMessage("PRES_DURN_CANNOT_ZERO", "PH"));
		frmObj_pres_dtl.durn_value.value="";
		return false;
	}
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr+= "durn_desc=\"" + durn_desc+ "\" " ;
	xmlStr+= "dur_val=\"" + dur_val+ "\" " ;
	xmlStr+= "start_date=\"" + start_date+ "\" " ;
	xmlStr+= "end_date=\"" + end_date+ "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="PrescriptionValidation_2.jsp?func_mode=dates_populate";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function returnChangedDate(changeddate){
	var	frmObj_pres_dtl	= document.frmdischPrescriptionPrevButtons;
	frmObj_pres_dtl.order_date_to.value=changeddate;
}

function checkduplicatedisc(){
	var formobjbut=document.frmdischPrescriptionPrevButtons;
	var start_date = formobjbut.order_date_from.value;
	var end_date = formobjbut.order_date_to.value;
	var formobj = parent.f_prev_orders_disc_results.frmdischPrescriptionPrevOrdersResult;
	var bean_id			=	formobj.bean_id.value;
	var bean_name		=	formobj.bean_name.value;
	var patient_id= formobj.patient_id.value;
	var overrideflag = formobj.overrideflag.value;
	var encounter_id= formobj.encounter_id.value;
	var durn_value = formobjbut.durn_value.value;
	if(durn_value=='')
		return false;

	var durn_desc = formobjbut.durn_desc.value;
	var pat_class= formobj.pat_class.value;
	var ord_status= formobj.ord_status.value;
	var order_from= formobj.order_from.value;
	var pract_id= formobj.pract_id.value;
	var order_id= formobj.order_id.value;
	var order_to= formobj.order_to.value;
	var rx_type= formobj.rx_type.value;
	var called_from="dateschange";
	/*var xmlStr ="<root><SEARCH ";//Commented for IN048127--start
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="PrescriptionValidation_2.jsp?func_mode=copy_selected_drugs_refresh";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);*///Commented for IN048127--end
	parent.f_prev_orders_disc_results.location.href="../../ePH/jsp/PrescriptionPrevOrdersDischargeMed.jsp?pat_id="+patient_id+"&enc_id="+encounter_id+"&pat_class="+pat_class+"&pat_class="+pat_class+"&order_from="+order_from+"&pract_id="+pract_id+"&order_id="+order_id+"&order_to="+order_to+"&rx_type="+rx_type+"&called_from="+called_from+"&ord_status="+ord_status+"&start_date="+start_date+"&end_date="+end_date;
 	parent.f_prev_orders_disc_buttons.location.href="../../ePH/jsp/PrescriptionPrevButtonsDischargeMed.jsp?pat_id="+patient_id+"&enc_id="+encounter_id+"&pat_class="+pat_class+"&pat_class="+pat_class+"&order_from="+order_from+"&pract_id="+pract_id+"&order_id="+order_id+"&order_to="+order_to+"&rx_type="+rx_type+"&called_from="+called_from+"&ord_status="+ord_status+"&start_date="+start_date+"&end_date="+end_date+"&dur_val="+durn_value+"&durn_desc="+durn_desc;
}

function validDateFormatDisc(obj, locale){
	if(obj.value){
		if(!validDate(obj.value, 'DMYHM',locale)){
			alert(getMessage("INVALID_DATE_TIME", "PH"));
			obj.select();
			//obj.focus(); //Commented for ML-BRU-SCF-1349 [IN:049402]
			return false;
		}
		else if(validateStartDatedisc(obj, locale)){//if condition Added for IN047958
			//dur_calc(obj,"startdate",locale);  //Added for IN047958//Commented for ML-BRU-SCF-1349[IN049402]
			populateEndDateDisc();
			checkduplicatedisc();
		}
	}	
}

function validateEndDatedisc(dateObj, locale){
	if(dateObj.value!=""){
		if(validDate(dateObj.value, "DMYHM",locale )){
			var start_date=document.frmdischPrescriptionPrevButtons.order_date_from.value;
			if(!isBefore(start_date,dateObj.value, "DMYHM",locale)){
				alert(getMessage("END_DATE_GTR_THAN_START_DATE", "PH"));
				dateObj.select();//Added for IN047958
				//dateObj.focus();//Added for IN047958 //Commented for ML-BRU-SCF-1349 [IN:049402]
				return false;//Added for IN047958
			}
			else{//Added for BRU-HIMS-CRF-403 --start
				dur_calc(dateObj,"enddate",locale);
				//checkduplicatedisc();//Commented for ML-BRU-SCF-1349[IN049402]
			}//Added for BRU-HIMS-CRF-403 --end
		}
		else{//Added for IN047958--start
			alert(getMessage("INVALID_DATE_TIME", "PH"));
			dateObj.select();
			//dateObj.focus(); //Commented for ML-BRU-SCF-1349 [IN:049402]
			return false;
		}//Added for IN047958--end
	}
	else{
		alert(getMessage("PH_END_DATE", "PH"));
		//document.frmdischPrescriptionPrevButtons.order_date_to.focus(); //Commented for ML-BRU-SCF-1349 [IN:049402]
		return false;
	}
}

function validateStartDatedisc(dateObj, locale){
	if(dateObj.value!=""){
		if(validDate(dateObj.value, "DMYHM",locale )){
			var end_date=document.frmdischPrescriptionPrevButtons.order_date_to.value;
			/*if(isBefore(end_date,dateObj.value, "DMYHM",locale)){ //isAfter changed to isBefore for IN047958//Commented for ML-BRU-SCF-1349[IN049402]
				alert(getMessage("END_DATE_GTR_THAN_START_DATE", "PH"));
				dateObj.select();//Added for IN047958
				dateObj.focus();//Added for IN047958
				return false;
			}
			else
				return true;	*/
			return true;
		}
	}
	else{
		alert(getMessage("PH_START_DATE", "PH"));
		//document.frmdischPrescriptionPrevButtons.order_date_from.focus(); //Commented for ML-BRU-SCF-1349 [IN:049402]
		return false;
	}
}

function discCancel(){
	window.close();
}

function checkLinesDisc(obj) {
	var frmObj		= document.frmdischPrescriptionPrevOrdersResult;
	var arrObj		= frmObj.elements;
	var priv;

	var s;
	if(obj.checked==true) {
		for(var i=0;i<arrObj.length;i++) {
			if(arrObj[i].type=="checkbox"){
				names	=	arrObj[i].name.split(",");

				if(names.length>1 && obj.name==names[0]){
					if(arrObj[i].checked==false) {
						arrObj[i].checked=true;
						s=arrObj[i-1].name;
						priv=eval(arrObj[i-1]).value;
						storeCheckeddisc(arrObj[i]);
					}
				}
			}
		}
	}
	else {
		for(var i=0;i<arrObj.length;i++) {
			if(arrObj[i].type=="checkbox"){
				names	=	arrObj[i].name.split(",");
				if(names.length>1 && obj.name==names[0]){
					if(arrObj[i].checked==true) {
						arrObj[i].checked=false;
						s=arrObj[i-1].name;
						priv=eval(arrObj[i-1]).value;
						storeCheckeddisc(arrObj[i]);
					}
				}
			}
		}
	}
}

function storeCheckeddisc(obj) {
	var obj_code	=	obj.value;
	var frmObj = document.frmdischPrescriptionPrevOrdersResult;
	keys		=	(obj.name).split(",");
	order_id	=	keys[0];
	order_line	=	keys[1];
	if(obj.checked){
		chk_status	=	"Y";
	} 
	else {
		chk_status	=	"N";
	}
	var xmlStr = "<root><SEARCH ";
	xmlStr+= "order_id  =\"" + order_id+ "\" " ;
	xmlStr+= "order_line =\"" + order_line + "\" " ;
	xmlStr+= "drug_code =\"" + obj.value + "\" " ;
	xmlStr+= "chk_status  =\"" + chk_status + "\" " ;
	xmlStr+= "bean_id =\"" + frmObj.bean_id.value + "\" " ;
	xmlStr+= "bean_name=\"" + frmObj.bean_name.value + "\" " ;
	xmlStr +=" /></root>";

	var temp_jsp="PrescriptionValidation_2.jsp?func_mode=copy_disc_orders";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	var formobjbut=parent.f_prev_orders_disc_buttons.frmdischPrescriptionPrevButtons;//Added for IN048127--start
	var start_date = formobjbut.order_date_from.value;
	var end_date = formobjbut.order_date_to.value;
	var formobj = document.frmdischPrescriptionPrevOrdersResult;
	var bean_id			=	formobj.bean_id.value;
	var bean_name		=	formobj.bean_name.value;
	var patient_id= formobj.patient_id.value;
	var overrideflag = formobj.overrideflag.value;
	var encounter_id= formobj.encounter_id.value;
	var durn_value = formobjbut.durn_value.value;
	var durn_desc = formobjbut.durn_desc.value;
	var pat_class= formobj.pat_class.value;
	var ord_status= formobj.ord_status.value;
	var order_from= formobj.order_from.value;
	var pract_id= formobj.pract_id.value;
	var order_id= formobj.order_id.value;
	var order_to= formobj.order_to.value;
	var rx_type= formobj.rx_type.value;
	parent.f_prev_orders_disc_buttons.location.href="../../ePH/jsp/PrescriptionPrevButtonsDischargeMed.jsp?pat_id="+patient_id+"&enc_id="+encounter_id+"&pat_class="+pat_class+"&pat_class="+pat_class+"&order_from="+order_from+"&pract_id="+pract_id+"&order_id="+order_id+"&order_to="+order_to+"&rx_type="+rx_type+"&ord_status="+ord_status+"&start_date="+start_date+"&end_date="+end_date+"&dur_val="+durn_value+"&durn_desc="+durn_desc;
	//Added for IN048127--end
}

function checkheaderdisc(obj){
	var frmObj = document.frmdischPrescriptionPrevOrdersResult;
	var arrObj	= frmObj.elements;
	checkHeader(arrObj,obj);
}//Added for Bru-HIMS-CRF-403--END

function dur_calc(dateObj,from,locale){//Added for IN047995--START
	var frmObj_pres_dtl;
	frmObj_pres_dtl	= document.frmdischPrescriptionPrevButtons;
	var dur_val 	= frmObj_pres_dtl.durn_value.value;
	if(from =="startdate"){
		var end_date 	= frmObj_pres_dtl.order_date_to.value;
		var start_date	= dateObj.value;
	}
	else{
		var start_date 	= frmObj_pres_dtl.order_date_from.value;
		var end_date 	= dateObj.value;
	}
	var durn_desc 	= document.getElementById("durn_desc").value;
	var bean_id			=	frmObj_pres_dtl.bean_id.value;
	var bean_name		=	frmObj_pres_dtl.bean_name.value;
	if(durn_desc=='w')
		var durn = daysBetween(start_date,end_date,"DMYHM",locale)/7;
	else if(durn_desc=='M')
		var durn = daysBetween(start_date,end_date,"DMYHM",locale)/30;
	else if(durn_desc=='Y')
		var durn = daysBetween(start_date,end_date,"DMYHM",locale)/365;				
	else
		var durn = daysBetween(start_date,end_date,"DMYHM",locale);
	if(durn%1 !=0){//Added for IN047995--START
		frmObj_pres_dtl.durn_value.value=dur_val;
		durn = dur_val;
		frmObj_pres_dtl.order_date_to.value=end_date;
		frmObj_pres_dtl.order_date_from.value=start_date;
		return false;
	}
	else{//Added for IN047995--end
		frmObj_pres_dtl.durn_value.value=durn;
		var xmlStr = "<root><SEARCH ";
		xmlStr+= "dur_val  =\"" + durn+ "\" " ;
		xmlStr+= "start_date =\"" + start_date + "\" " ;
		xmlStr+= "end_date =\"" + end_date + "\" " ;
		xmlStr+= "durn_desc  =\"" + durn_desc + "\" " ;
		xmlStr+= "bean_id =\"" + frmObj_pres_dtl.bean_id.value + "\" " ;
		xmlStr+= "bean_name=\"" + frmObj_pres_dtl.bean_name.value + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PrescriptionValidation_2.jsp?func_mode=dur_populate";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);//Modified for ML-BRU-SCF-1349[IN049402] 
		xmlHttp.send(xmlDoc);
		if(from =="enddate")//Added for ML-BRU-SCF-1349[IN049402]
			checkduplicatedisc();
		//return true;
	}
}//Added for IN047995--end

function selectAllRec(obj){ //added for HSA-CRF-0151 [IN:048468]
	var formObj = document.DiscCancelOrderDetailsForm;
	var tot_rec_count = formObj.tot_rec_count.value;
	var genericIdsCount = formObj.genericIdsCount.value;
	var generic_id="";
	for (var g=0; g<parseInt(genericIdsCount);g++) {
		generic_id = eval("formObj.genericId_"+g).value;
		var selectObj = eval("formObj.select_Gen_"+generic_id);
		if(obj.checked==true)
			selectObj.checked=true;
		else
			selectObj.checked=false;
		var genericRecCount = eval("formObj.genericRecCount_"+generic_id).value;
		for (var i=0; i<parseInt(genericRecCount);i++) {
			selectObj = eval("formObj.select_"+generic_id+"_"+i);
			if(obj.checked==true)
				selectObj.checked=true;
			else
				selectObj.checked=false;
		}
	}
}

function selectGeneric(obj, generic_id){ //added for HSA-CRF-0151 [IN:048468]
	var formObj = document.DiscCancelOrderDetailsForm;
	var genericCount = eval("formObj.genericRecCount_"+generic_id).value;
	for (var i=0; i<parseInt(genericCount);i++) {
		var selectObj = eval("formObj.select_"+generic_id+"_"+i);
		if(obj.checked==true)
			selectObj.checked=true;
		else
			selectObj.checked=false;
	}
	var genericIdsCount = formObj.genericIdsCount.value;
	var tmp_generic_id = "";
	var selectAll = true;
	for (var g=0; g<parseInt(genericIdsCount) ; g++ ){
		tmp_generic_id = eval("formObj.genericId_"+g).value;
		var selectObj = eval("formObj.select_Gen_"+tmp_generic_id);
		if(selectObj.checked == false)
			selectAll = false;
	}
	if(selectAll)
		 formObj.selectAll.checked = true;
	else
		 formObj.selectAll.checked = false;
}

function updateCurrentRx(patient_id, encounter_id,generic_id_vals ){ //added for HSA-CRF-0151 [IN:048468]
	var bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	var bean_name		= "ePH.PrescriptionBean_1";
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr+= "generic_id_vals=\"" + generic_id_vals + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="PrescriptionValidation_2.jsp?func_mode=UPDATE_CURR_RX";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
}

function checkSelectAll(obj, generic_id, callFrom){//added for HSA-CRF-0151 [IN:048468]
	var formObj = document.DiscCancelOrderDetailsForm;
	if(obj.checked == false){
		eval("formObj.select_Gen_"+generic_id).checked = false;
		formObj.selectAll.checked = false;
	}
	else{
		var genericCount = eval("formObj.genericRecCount_"+generic_id).value;
		var selectGenAll = true;
		for (var i=0; i<parseInt(genericCount);i++) {
			var selectObj = eval("formObj.select_"+generic_id+"_"+i);
			if(selectObj.checked==false){
				selectGenAll=false;
				break
			}
		}
		if(selectGenAll){
			eval("formObj.select_Gen_"+generic_id).checked = true;
			var genericIdsCount = formObj.genericIdsCount.value;
			var tmp_generic_id = "";
			var selectGenAll = true;
			var selectAll = true;
			for (var g=0; g<parseInt(genericIdsCount) ; g++ ){
				tmp_generic_id = eval("formObj.genericId_"+g).value;
				var genericCount = eval("formObj.genericRecCount_"+tmp_generic_id).value;
				if(tmp_generic_id != generic_id ){
					for (var i=0; i<parseInt(genericCount);i++) {
						var selectObj = eval("formObj.select_"+tmp_generic_id+"_"+i);
						if(selectObj.checked==false){
							selectGenAll=false;
							selectAll = false;
							break
						}
					}
					if(!selectAll){
						 formObj.selectAll.checked = false;
						 break
					}
				}
			}
			if(selectAll)
				 formObj.selectAll.checked = true;
		}
	}
}

function addActiveDrugs(){//Added for Bru-HIMS-CRF-072.1[IN 049144] start
	var formObj=parent.f_active_order_details.document.activeOrderDetailsForm;
	var checked=false;
	for(var i=0;i<eval("formObj.totalrecords").value;i++){
		if(eval("formObj.chk_drugselect"+i).checked==true && eval("formObj.chk_drugselect"+i).disabled==false){//&& condition Added for [IN:051785]
			checked=true;
			var xmlStr = "<root><SEARCH ";
			xmlStr+= "drug_code  =\"" + eval("formObj.drug_code"+i).value+ "\" " ;
			xmlStr+= "pres_drug_code  =\"" + eval("formObj.drug_code"+i).value+ "\" " ;
			xmlStr+= "disp_drug_code  =\"" + eval("formObj.drug_code"+i).value+ "\" " ;
			xmlStr+= "order_id =\"" + eval("formObj.order_id"+i).value + "\" " ;
			xmlStr+= "order_line_no  =\"" + eval("formObj.order_line_no"+i).value + "\" " ;
			xmlStr+= "drug_name =\"" + encodeURIComponent(eval("formObj.drug_name"+i).value) + "\" " ;
			xmlStr+= "qty_issue  =\"" + encodeURIComponent(eval("formObj.qty_issue"+i).value) + "\" " ;
			xmlStr+= "qty_issuelocal  =\"" + encodeURIComponent(eval("formObj.qty_issuelocal"+i).value) + "\" " ;
			xmlStr+= "howtotake =\"" + encodeURIComponent(eval("formObj.howtotake"+i).value) + "\" " ;
			xmlStr+= "howtotakelocal =\"" + encodeURIComponent(eval("formObj.howtotakelocal"+i).value) + "\" " ;
			xmlStr+= "impnote =\"" + encodeURIComponent(eval("formObj.impnote"+i).value) + "\" " ;
			xmlStr+= "impnotelocal =\"" + encodeURIComponent(eval("formObj.impnotelocal"+i).value) + "\" " ;
			xmlStr+= "drug_name_local =\"" + encodeURIComponent(eval("formObj.drug_name_local"+i).value) + "\" " ;
			xmlStr+= "curr_disp_yn  =\"N\" " ;
			xmlStr+= "merge_yn  =\"N\" " ;
			xmlStr+= "chkdrug  =\"E\" " ;
			xmlStr+= "bean_id =\"DispMedicationAllStages\" " ;
			xmlStr+= "bean_name=\"ePH.DispMedicationAllStages\" " ;
			xmlStr +=" /></root>";
			var temp_jsp="DispMedicationValidation1.jsp?func_mode=addActiveDrug";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false); 
			xmlHttp.send(xmlDoc);
		}
	}
	if(checked){
		window.returnValue="OK";
		window.close();
	}
	else{
		alert("APP-PH060 Atleast one record should be selected");
		return false;
	}
}//Added for Bru-HIMS-CRF-072.1[IN 049144] end
//added for IN070605 START
async function drugindication_remarks_disp(calling_func,order_id,order_line_no,allergy_cnt){
	var formobj		=	document.prescription_close_form;
	var formobj1		=	document.prescription_dosage_monograph;
	var ReviewRemarks;
	if(calling_func=="doselimit"){
		
		 ReviewRemarks	=	formobj1.ReviewRemarks.value;	
	}else{
		 ReviewRemarks	=	formobj.ReviewRemarks.value;	
	}
	
	var dialogHeight= "42vh" ;
	var dialogWidth	= "55vw" ;
	var dialogTop = "300" ;
	var dialogLeft ="10";
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/ReviewApproveRemarks.jsp?ReviewRemarks="+encodeURIComponent(ReviewRemarks)+"&calling_func="+calling_func+"&order_id="+order_id+"&order_line_no="+order_line_no+"&allergy_cnt="+allergy_cnt,arguments,features);
	if(retVal!= undefined && retVal!=null)
		if(calling_func=="doselimit"){
			formobj1.ReviewRemarks.value=retVal;	
	}
		else
			{
		formobj.ReviewRemarks.value=retVal;	
			}
	
}

function savedrugIndicationRemarks(drug_indicate,calling_func,order_id,order_line_no,allergy_cnt){
	var formobj		=	document.ReviewRemarks;
	var drug_indication_new = encodeURIComponent(drug_indicate.value);
	var alergy_details;var dosage_details;var duplicate_details;var intaraction_details;
	if(calling_func=="alergy")
	{
		alergy_details=drug_indication_new;
	}
	else
		{
		alergy_details=formobj.alergy_details.value;
		}
	if(calling_func=="diagnosis")
	{
		duplicate_details=drug_indication_new;
	}
	else
		{
		duplicate_details=formobj.duplicate_details.value;
		}
	if(calling_func=="doselimit")
	{
		dosage_details=drug_indication_new;
	}
	else
		{
		dosage_details=formobj.dosage_details.value;
		}
	if(calling_func=="intaraction")
	{
		intaraction_details=drug_indication_new;
	}
	else
		{
		intaraction_details=formobj.intaraction_details.value;
		}
	
	if(drug_indication_new==""){
		alert("Review Remarks Required");
		return false;
	}
	if(drug_indication_new.length >200){
		
	var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("ePH.ReviewComments.label","PH"));
		msg = msg.replace("#","200");
		alert(msg);
	return false;
	}
	window.returnValue=drug_indication_new;
	var xmlStr = "<root><SEARCH ";
	xmlStr+= "drug_indicate  =\"" +drug_indicate+ "\" " ;
	xmlStr+= "calling_func  =\"" + calling_func + "\" " ;
	xmlStr+= "reviewed_by  =\"" +formobj.reviewed_by.value+ "\" " ;
	xmlStr+= "review_date  =\"" +formobj.review_date.value+ "\" " ;
	xmlStr+= "alergy_details  =\"" +alergy_details+ "\" " ;
	xmlStr+= "dosage_details  =\"" +dosage_details+ "\" " ;
	xmlStr+= "duplicate_details  =\"" +duplicate_details+ "\" " ;
	xmlStr+= "intaraction_details  =\"" +intaraction_details+ "\" " ;
	xmlStr+= "order_id  =\"" +formobj.order_id.value+ "\" " ;
	xmlStr+= "order_line_no  =\"" +formobj.order_line_no.value+ "\" " ;
	xmlStr+= "bean_id =\"DispMedicationAllStages\" " ;
	xmlStr+= "bean_name=\"ePH.DispMedicationAllStages\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation1.jsp?func_mode=updateReviewDetails&order_id="+order_id+"&order_line_no="+order_line_no+"&allergy_cnt="+allergy_cnt+"&alergy_details="+alergy_details+"&duplicate_details="+duplicate_details+"&dosage_details="+dosage_details+"&intaraction_details="+intaraction_details;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false); 
	xmlHttp.send(xmlDoc);
	window.close();

}

function checkDrugIndMaxLimit_disp(obj,maxLeng) { 
	if(encodeURIComponent(obj.value).length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("ePH.ReviewComments.label","PH"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,maxLeng-1);
		alert(msg);
		obj.focus();
		return false;
	} 
	else 
		return true;
}
function savedrugIndicationRemarksClose(drug_indicate){
	
	
	var drug_indication_new = encodeURIComponent(drug_indicate.value);
	//window.returnValue=drug_indication_new;
	parent.parent.document.getElementById('dialog-body').contentWindow.returnValue=drug_indication_new;
}
//added for IN070605 END
//Added for IN:069887 

function validateOnConfirm(frmObj) {
	//var frmObj=parent.f_detail.document.prescription_detail_form;
	
	patient_id		=	frmObj.patient_id.value;
	encounter_id	=	frmObj.encounter_id.value;
	limit_ind		=	frmObj.limit_ind.value;
	allergy_yn		=	frmObj.allergy_yn.value;
	current_rx		=	frmObj.current_rx.value;
	drug_code		=	frmObj.drug_code.value;
	srl_no			=	frmObj.srl_no.value;
	interaction_exists			=	frmObj.interaction_exists.value;
	
	bean_id		=	frmObj.bean_id.value;
	bean_name	=	frmObj.bean_name.value;
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "drug_code  =\"" + drug_code + "\" " ;
	xmlStr+= "srl_no =\"" + srl_no + "\" " ;
	xmlStr+= "allergy_yn  =\"" + allergy_yn + "\" " ;
	xmlStr+= "current_rx =\"" + current_rx + "\" " ;
	xmlStr+= "limit_ind  =\"" + limit_ind + "\" " ;
	xmlStr+= "interaction_exists  =\"" + interaction_exists + "\" " ;
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "encounter_id =\"" + encounter_id + "\" " ;
	
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="PrescriptionValidation.jsp?func_mode=override_mand_check_on_confirm";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	
	responseText=xmlHttp.responseText ;
	eval(responseText);
	
	
}
function showOverideMandAlert(allergy_remarks_yn, dup_remarks_yn, dose_remarks_yn, drug_drug_remarks_yn, drug_lab_remarks_yn,drug_food_remarks_yn){
	
	//alert("showOverideMandAlert");
	var names	= new Array();
	var   i		= 0;

	if(allergy_remarks_yn==='Y') {
		names[i]	=getLabel("ePH.AllergicOverrideReason.label", "PH");
		i++;
	}
	if(dose_remarks_yn==='Y') {
		names[i]	=getLabel("ePH.ExceedDosageOverrideReason.label", "PH");
		i++;
	}
	if(dup_remarks_yn==='Y') {
		names[i]	=getLabel("ePH.DuplicateDrugOverrideReason.label", "PH");
		i++;
	}
	if(drug_drug_remarks_yn==='Y') {
		names[i]	=getLabel("ePH.Drug-DrugInteractionOverrideReason.label", "PH");
		i++;
	}
	if(drug_lab_remarks_yn==="Y") {
		names[i]	=getLabel("ePH.Drug-LabInteractionOverrideReason.label", "PH");
		i++;
	}
	if(drug_food_remarks_yn==='Y') {
		names[i]	=getLabel("ePH.Drug-FoodInteractionOverrideReason.label", "PH");
		i++;
	}
	var errors = "" ;
	for( var i=0; i<names.length; i++ ) {
			
			errors = errors + "APP-000001 " + names[i] +" "+ getLabel("ePH.CANT_BE_BLANK.label","PH") + "\n" ;
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}
async function AlertSupportDrug(drug_code){//Adding start for TH-KW-CRF-0007
	    var retVal =new Array();
        var patient_id		= document.prescription_detail_form.patient_id.value;
	    var encounter_id	= document.prescription_detail_form.encounter_id.value;
		var bean_id				=	document.prescription_detail_form.bean_id.value;
	    var bean_name			=	document.prescription_detail_form.bean_name.value;
	    var presBean_id				=	document.prescription_detail_form.presBean_id.value;
	    var presBean_name			=	document.prescription_detail_form.presBean_name.value;
	    var addConfirm =confirm("Supportive Drugs exists. Do you like to continue in placing the order");
         if(addConfirm){
		    var dialogHeight= "35vh" ;
			var dialogWidth	= "41vw" ;
			var dialogTop	= "300" ;
			var dialogLeft	= "325" ;
			var center		= "1" ;
			var status		= "no";
			var scroll		= "yes";
			var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionSupportiveDrugFrame.jsp?drug_code="+drug_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&presBean_id="+presBean_id+"&presBean_name="+presBean_name,arguments,features);
		  var drug_codes=new Array();;
		  var trade_codes=new Array();;
		  var trade_names=new Array();;
		 	
		  var Drug_Codes =  new Array();
	      var Trade_Codes = new Array();
	      var Trade_Names = new Array();
		  
			 if(retVal!=undefined){				
                 drug_codes = retVal[0];
				 for(i=0;i<drug_codes.length;i++){
					 Drug_Codes[i] = drug_codes[i];
					 Trade_Codes[i]   = Trade_Codes[i];
					 Trade_Names[i]   = trade_names[i];
				 }
                loadDrugDetails1(Drug_Codes,Trade_Codes,Trade_Names);   
			 }
			    
		 }
}

function formclose(){
	var total_records       =   parent.supp_detail.supportdrugsdetails.total_records.value;
	var bean_id				=	parent.supp_detail.supportdrugsdetails.bean_id.value;
	var bean_name			=	parent.supp_detail.supportdrugsdetails.bean_name.value;
	var presBean_id			=	parent.supp_detail.supportdrugsdetails.presBean_id.value;
	var presBean_name		=	parent.supp_detail.supportdrugsdetails.presBean_name.value;
	var checked_drug ="";
	var selected_drugs="";
	var Drug_Codes =  new Array();
	var	Trade_Codes = new Array();
	var Trade_Names = new Array();
	var return_arr  =new Array();
	var k=0;
	 for(var i=1;i<=total_records;i++){
		 if(eval("parent.supp_detail.supportdrugsdetails.check_"+i+".checked")){
			  checked_drug =eval("parent.supp_detail.supportdrugsdetails.drug_code_"+i).value;
		      selected_drugs =selected_drugs+checked_drug+"~";
			  Drug_Codes[k]=checked_drug;
			  Trade_Codes[k]="";
			  Trade_Names[k]="";
           k++;
		 }
		 
	 }
           return_arr[0]=Drug_Codes;
		   return_arr[1]=Trade_Codes;
		   return_arr[2]=Trade_Names;
	
	    var presBean_id		=	parent.supp_detail.supportdrugsdetails.presBean_id.value;
		var presBean_name	=	parent.supp_detail.supportdrugsdetails.presBean_name.value;
		var bean_id ="PrescriptionBean_1";
		var bean_name ="ePH.PrescriptionBean_1";
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "selected_drugs  =\"" + selected_drugs + "\" " ;
		xmlStr+= "main_drug  =\"" + parent.supp_detail.supportdrugsdetails.main_drug.value + "\" " ;
		xmlStr+= "bean_id=\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr+= "presBean_id=\"" + presBean_id + "\" " ;
		xmlStr+= "presBean_name=\"" + presBean_name + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PrescriptionValidation.jsp?func_mode=setSelSuppDrugs";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		
		responseText=xmlHttp.responseText ;
		eval(responseText);
		window.returnValue=return_arr;
		window.close();
}
function deleteSuppDrugs(drug_code){
	 var formobj	           = parent.f_detail.document.prescription_detail_form;
     var bean_id               = formobj.bean_id.value;
	 var bean_name             = formobj.bean_name.value;
	 var presBean_id		   = formobj.presBean_id.value;
	 var presBean_name		   = formobj.presBean_name.value;
	 var patient_id            = formobj.patient_id.value;
	 var encounter_id          = formobj.encounter_id.value;
	 var drug_db_interface_yn  = "";
	 var xmlStr ="<root><SEARCH ";
	    xmlStr+=" patient_id=\""+ patient_id + "\" ";
		xmlStr+=" encounter_id=\""+ encounter_id + "\" ";
		xmlStr+=" drug_code=\""+ drug_code + "\" ";
		xmlStr+=" bean_id=\""+ bean_id + "\" ";
		xmlStr+=" bean_name=\""+ bean_name + "\" ";
		xmlStr+= "presBean_id=\"" + presBean_id + "\" " ;
		xmlStr+= "presBean_name=\"" + presBean_name + "\" " ;
		xmlStr+=" drug_db_interface_yn=\""+ drug_db_interface_yn + "\" ";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrescriptionValidation.jsp?func_mode=deleteSuppDrugs",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
}//Adding end for TH-KW-CRF-0007
