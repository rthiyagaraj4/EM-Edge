/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description 
--------------------------------------------------------------------------------------------------------------
? 				100					?           created
04/07/2017      ML-MMOH-SCF-0690  Devindra      Unable to select batch for alternate drug if the batch expiry is near/lesser than prescribed duration and only on batch exist for the item in the store.
05/17/2017      IN064158     Devindra    Change in barcode scanning functionality in Dispense Medication(in each scan one quantity need to add).
10/01/2019		IN068344	 Manickavasagam 		  						 GHL-CRF-0549 [IN068344] 
29/01/2019		IN068728	 Devindra           ML-MMOH-CRF-1266 [IN:068728]
05/07/2019      [IN:067952]     Devindra         MMS-KH-CRF-0013 [IN:067952] 
09/08/2019      IN070605		 prathyusha  MMS-KH-CRF-0028
13/08/2019      IN070605		 Devindra   MMS-KH-CRF-0028
13/08/2019      IN070451		 Manickavasagam J						ML-MMOH-CRF-1408
04/09/2019	  	IN070605	     	prathyusha 		  									 MMS-KH-CRF-0028
25/06/2020		IN:072409	        Manickavasagam J			     MMS-CRF-0030	
03/09/2020		IN:072409	        Manickavasagam J			     MMS-CRF-0030	
26/10/2020      IN074250    Prabha			 ML-MMOH-SCF-1634
19/8/2021		    TFS:9495	  Shazana					MOHE-CRF-0026.1
7/5/2022		TFS:30461		Shazana									MMS-MD-SCF-0204
---------------------------------------------------------------------------------------------------------------
*/  
var pinautharized_yn   ="";
var nursing_unit="";
var patient_name="";
var Ordering_Facility_id="";
var allow_disp_record_lock_yn="";
var hold_legend    = getLabel("ePH.Hold.label","PH");
var on_hold_legend = getLabel("ePH.OnHold.label","PH");
var lockedStatus = false;
var valid = false;
async function callReason(obj,order_id,drug_code,no,order_line_no,curr_stage,scope)	{
    if(obj.getAttribute('disabled') == null){
		var held="";
		if (obj.innerText==hold_legend){
			held="N";		
		}
		else{
			held="Y";
		}
		var dialogHeight	= "35vh" ;
		var dialogWidth		= "40vw";
		var dialogTop		= "10" ;
		var dialogLeft		= "10" ;
		var center			= "1" ;
		var status			="no";
		if(eval(document.getElementById("fromdb_"+no)) !=null)
			var fromdb=eval(document.getElementById("fromdb_"+no)).value;
		else
			var fromdb="";

		var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "";
		retVal =await top.window.showModalDialog("../../ePH/jsp/DispMedicationHoldReason.jsp?recno="+no+"&order_id="+order_id+"&drug_code="+drug_code+"&order_line_no="+order_line_no+"&fromdb="+fromdb+"&held="+held,arguments,features);
		
		if (retVal=="OK") {
			eval("document.DispMedicationAllStages.hold"+no+".checked=true");
			validateHold(no,curr_stage);
			eval("document.getElementById('hold_remarks_' + no).innerText = '" + on_hold_legend + "';");
			if(eval(document.getElementById("fromdb_"+no)) != null)
				eval(document.getElementById("fromdb_"+no)).value='N';
			if(eval(document.getElementById("hold"+no) != null))
				eval(document.getElementById("hold"+no)).value='Y' ;					
			
			if(scope!='H'){
				if(eval(document.getElementById("alloc_qty_"+no))!=null){
					eval("document.DispMedicationAllStages.alloc_qty_"+no).disabled=true;
					eval(document.getElementById("alloc_qty_"+no)).value="";
					if(eval(document.getElementById("allocateyn_"+no)!=null)){
						eval(document.getElementById("allocateyn_"+no)).value='N';
					}
				}
			}		
			
			if(eval(document.getElementById("CompleteOrder"+no))!=null){
				eval(document.getElementById("CompleteOrder"+no)).checked=false;
				eval(document.getElementById("CompleteOrder"+no)).disabled=true;
				eval(document.getElementById("CompleteOrder"+no)).value='N';
			}
			if(eval(document.getElementById("ComplteOrderReason"+no))!=null){
				eval(document.getElementById("ComplteOrderReason"+no)).disabled=true;
			}
			if(eval(document.getElementById("alloc_bms_chk_"+no))!=undefined){
				eval(document.getElementById("alloc_bms_chk_"+no)).disabled=true;
				eval(document.getElementById("alloc_bms_chk_"+no)).checked=false;
				eval(document.getElementById("alloc_bms_chk_"+no)).value='N';
			}
		}
		else if (retVal=="RELEASE") {
			eval("document.DispMedicationAllStages.hold"+no).checked=false;
			 validateHold(no,curr_stage);
			 eval("document.getElementById('hold_remarks_' + no).innerText = '" + hold_legend + "';");
			//eval(document.getElementById("hold_remarks_"+no).innerText='"+hold_legend+"');
			if(eval(document.getElementById("fromdb_"+no)) != null)
				eval(document.getElementById("fromdb_"+no)).value='N';
			if(eval(document.getElementById("hold"+no)) != null)
				eval(document.getElementById("hold"+no)).value='N';
			if(eval(document.getElementById("release_flag"+no))!=null)
			   eval(document.getElementById("release_flag"+no)).value='Y';			   
			
                       if(scope!='H' && scope!='A' ){ // (&& scope!='A') condition Added for ML-MMOH-CRF-0434 [IN057356]
				if(eval(document.getElementById("alloc_qty_"+no))!=null){
				  eval("document.DispMedicationAllStages.alloc_qty_"+no).disabled=false;
				}
			}
			if(eval(document.getElementById("CompleteOrder"+no))!=null){
				eval(document.getElementById("CompleteOrder"+no)).disabled=false;
				eval(document.getElementById("CompleteOrder"+no)).value='N';
			}

			if(eval(document.getElementById("ComplteOrderReason"+no))!=null){
				// eval("document.getElementById("ComplteOrderReason")"+no+".checked=false");
				eval(document.getElementById("ComplteOrderReason"+no)).disabled=false;
				// eval("document.getElementById("CompleteOrder")"+no).value='N';
			}
			if(eval(document.getElementById("alloc_bms_chk_"+no))!=undefined){
				eval(document.getElementById("alloc_bms_chk_"+no)).disabled=false;
				eval(document.getElementById("alloc_bms_chk_"+no)).checked=false;
			}
		}
		/*if(curr_stage=="AS") {
			//controlAllStagesButton();
		}
		else if(curr_stage=="A") {
			//controlAllocationButton();
		} 
		else if(curr_stage=="F") {
			//controlFillingButton();
		}*/
		
		/*if(retVal=="OK"){// For worksheet starts
			if(document.DispMedicationAllStages.ws_type != null){
				var ws_type = document.DispMedicationAllStages.ws_type.value;
				if(ws_type!=""){
					//parent.f_disp_medication_header.DispMedicationAllStages.alloc_but.disabled=true;
				}
			}
		}*/// For worksheet ends //Commented if condition b'z the statement inside if block was commented
	}
}
function close(){
	
	parent.document.getElementById('dialog_tag').close();
}
function CheckPatReqd(Obj){
				if(Obj.checked==true)
					Obj.value="C";
				else
					Obj.value="N";
}
function checkRemarksMaxLimit(obj,maxLeng, label) {  //function checkRemarksMaxLimit added for [IN:039007]
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("Common.remarks.label","Common"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,maxLeng);
		alert(msg);
		obj.focus();
		return false;
	} 
	else 
		return true;
}

function enableRelease(obj,formobj){
	if (obj.checked){
		formobj.BtnRelease.disabled=false;
		formobj.Releaseremarks.disabled=false;
	}
	else{
		formobj.BtnRelease.disabled=true;
		formobj.Releaseremarks.disabled=true;
	}
}

function validateHold(no,curr_stage) {
	frmObj	=	document.DispMedicationAllStages;

	var arrObj			=	frmObj.elements;
	var data			=	new Array();
	var hold_status		=	false;

	for(i=0; i<arrObj.length; i++){
		if(arrObj[i].name.substr(0,4)=="hold") {
			if(arrObj[i].name.substr(0,5)!="hold_"){
				hold_val	=	arrObj[i].checked;
				if(hold_val==true)	{
					hold_status	=	true;
				}
				else {
					hold_status	=	false;
					break;
				}
			}
		}
	}
	if(parent.f_disp_medication_header!=undefined){
		frmObj	=	parent.f_disp_medication_header.document.DispMedicationAllStages;
	}
	else{
		 frmObj	=	parent.f_header.document.DispMedicationAllStages;
	}
	if(hold_status) {
		if(frmObj.alloc_but!=null) {
			frmObj.alloc_but.disabled=true;
			frmObj.alloc_but.style.cursor='auto';
		}
		if(curr_stage!="AS") {
			if(frmObj.btnFill!=null) { /* 'fill_but' is replaced by 'btnFill' for  Alpha-PH-Hold Remarks[IN039007] --Start */
				frmObj.btnFill.disabled=true;
				frmObj.btnFill.style.cursor='auto';
			}
		}
	}
	/*else {
		if(frmObj.alloc_but!=null) {
			frmObj.alloc_but.disabled=false;
			frmObj.alloc_but.style.cursor='hand';
		}
		if(curr_stage!="AS") {
			if(frmObj.fill_but!=null) {
				frmObj.fill_but.disabled=false;
				frmObj.fill_but.style.cursor='hand';
			}

			if(frmObj.delivery_but!=null){
				frmObj.delivery_but.disabled = true;
				frmObj.delivery_but.style.cursor='auto';
			}
		}
	}*/
}

function callClose(retval) {
	window.returnValue=retval;
	window.close();
	/*if(parent.parent.document.querySelectorAll('#dialog-body'))
	{
		parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue=retval;
		parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
	}else
	{
		parent.document.getElementById('dialog-body').contentWindow.returnValue = retVal;  
		parent.document.getElementById('dialog_tag').close();
	}*/
}

function storeReasonValues(frmObj,no) {
	//means that the order is getting released now
	if (frmObj.reason.disabled){
		if(validate(frmObj)){
			callClose("RELEASE");
		}
	}
	else{    
		if(validate(frmObj))
			callClose("OK");		
	}
}

function validate(frmObj) {
	reason			    =	frmObj.reason.value;
	recno				=	frmObj.recno.value;
	drug_code			=	frmObj.drug_code.value;
	order_id			=	frmObj.order_id.value;
	order_line_no		=	frmObj.order_line_no.value;
	bean_id				=	frmObj.bean_id.value;
	bean_name			=	frmObj.bean_name.value;
	remarks				=	frmObj.remarks.value;

	if (frmObj.reason.disabled){
		//releaseremarks	=	frmObj.Releaseremarks.value;
		fromdb				=  frmObj.fromdb.value;
		//if (fromdb=="Y"){
				//release remarks is mandatory
				var fields  = new Array() ;
				var names   = new Array() ;
				//fields[0]   = frmObj.Releaseremarks ;
				//names[0]   = "Release Remarks" ;

				//if(checkFlds( fields, names)){
					 var xmlStr ="<root><SEARCH ";
					xmlStr+= "reason  =\"" + reason + "\" " ;
					xmlStr+= "remarks =\"" + encodeURIComponent(remarks,"UTF-8") + "\" " ;
					//xmlStr+= "releaseremarks =\"" + releaseremarks + "\" " ;
					xmlStr+= "recno =\"" + recno + "\" " ;
					xmlStr+= "drug_code =\"" + drug_code + "\" " ;
					xmlStr+= "order_id =\"" + order_id + "\" " ;
					xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
					xmlStr+= "bean_id =\"" + bean_id + "\" " ;
					xmlStr+= "bean_name=\"" + bean_name + "\" " ;
					xmlStr +=" /></root>";
					var temp_jsp="DispMedicationValidation1.jsp?func_mode=release";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,false); 
					xmlHttp.send(xmlDoc);
					responseText=xmlHttp.responseText ;
					eval(responseText);

				//}
				//else
					//return false;
	//	}
	//	return true;
	}
	else{
		var fields  = new Array() ;
		var names   = new Array() ;
		fields[0]   = frmObj.remarks ;
		names[0]   = "Remarks" ;

		if(checkFlds( fields, names)){
			 var xmlStr ="<root><SEARCH ";
			xmlStr+= "reason  =\"" + reason + "\" " ;
			xmlStr+= "remarks =\"" + encodeURIComponent(remarks,"UTF-8") + "\" " ;
			xmlStr+= "recno =\"" + recno + "\" " ;
			xmlStr+= "drug_code =\"" + drug_code + "\" " ;
			xmlStr+= "order_id =\"" + order_id + "\" " ;
			xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
			xmlStr+= "bean_id =\"" + bean_id + "\" " ;
			xmlStr+= "bean_name=\"" + bean_name + "\" " ;
			xmlStr +=" /></root>";
			var temp_jsp="DispMedicationValidation.jsp?func_mode=reason";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}
		else
			return false;
	}
}

async function showAllergyDetails(generic_id,patient_id,encounter_id,generic_name, drug_name,order_id,order_line_no,allergy_cnt,patient_class,disp_medication){
	//order_id,order_line_no,allergy_cnt,patient_class,disp_medication addded for IN070605
	var retVal;
	var dialogTop		= "325";
 	var dialogHeight	= "12" ;
 	var dialogWidth		= "25" ;
	var center			= "1" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		= "";
 	//order_id,order_line_no,allergy_cnt,patient_class,disp_medication addded for IN070605
 	retVal 				= await top.window.showModalDialog("../../ePH/jsp/PrescriptionAllergyDetailsFrames.jsp?generic_name="+generic_name+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&patient_id="+patient_id+"&drug_name="+drug_name+"&order_id="+order_id+"&order_line_no="+order_line_no+"&allergy_cnt="+allergy_cnt+"&patient_class="+patient_class+"&disp_medication="+disp_medication,arguments,features);
 	
 	//added for IN070605 start
 	if(retVal!="" && retVal != null){
 	
 		document.getElementById("ALLERGY"+allergy_cnt).innerHTML = "<img src='../../ePH/images/red.jpg'>";
 		document.getElementById("ALLERGY_VALUE"+allergy_cnt).value="Y";
 	}
 	//added for IN070605 end
}

async function callActiveOrders(patient_id,encounter_id,generic_id,order_id,order_line_no,allergy_cnt,patient_class,disp_medication)	{
	//order_id,order_line_no,allergy_cnt,patient_class,disp_medication addded for IN070605
	if(generic_id==undefined)
		generic_id	="";
	var dialogHeight	=	"20" ;
	var dialogWidth		=	"50" ;
	var dialogTop		=	"250" ;
	var center			=	"1" ;
	var status			=	"no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	//order_id,order_line_no,allergy_cnt,patient_class,disp_medication addded for IN070605
	retVal =await window.showModalDialog("../../ePH/jsp/PrescriptionActiveOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&allergy_cnt="+allergy_cnt+"&patient_class="+patient_class+"&disp_medication="+disp_medication,arguments,features);
	//added for IN070605 start
	if(retVal!="" && retVal != null){
	 	
	 	document.getElementById("CURRENTRX"+allergy_cnt).innerHTML = "<img src='../../ePH/images/blue.jpg'>";
		document.getElementById("CURRENTRX_VALUE"+allergy_cnt).value="Y";
	 	}
	//added for IN070605 end
}

async function showMonoGraph(drug_desc,mono_graph,daily_dose,unit_dose,min_unit_dose,min_daily_dose,dosage_unit,std_dose,dose_unit_desc,order_id,order_line_no,allergy_cnt,patient_class,disp_medication,max_daily_ceeling_dose,min_daily_ceeling_dose,max_unit_ceeling_dose,min_unit_ceeling_dose,dose_unit_desc1){//dose_unit_desc added for ML-MMOH-SCF-0863
	//order_id,order_line_no,allergy_cnt,patient_class,disp_medication addded for IN070605
	//max_daily_ceeling_dose,min_daily_ceeling_dose,max_unit_ceeling_dose,min_unit_ceeling_dose,dose_unit_desc1 added for ML-MMOH-CRF-1408
	var retVal;
	var dialogTop		= "310";
 	var dialogHeight	= "17" ;
 	var dialogWidth		= "36" ;
	var dialogLeft		= "180" ;	

 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
 	//order_id,order_line_no,allergy_cnt,patient_class,disp_medication addded for IN070605
 	retVal 				= await window.showModalDialog("../../ePH/jsp/PrescriptionDosageLimitMonoGraph.jsp?drug_desc="+drug_desc+"&&&mono_graph="+mono_graph+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&min_daily_dose="+min_daily_dose+"&min_unit_dose="+min_unit_dose+"&dosage_unit="+dosage_unit+"&dosage_std="+std_dose+"&dose_unit_desc="+dose_unit_desc+"&order_id="+order_id+"&order_line_no="+order_line_no+"&allergy_cnt="+allergy_cnt+"&patient_class="+patient_class+"&disp_medication="+disp_medication+"&max_daily_ceeling_dose="+max_daily_ceeling_dose+"&min_daily_ceeling_dose="+min_daily_ceeling_dose+"&max_unit_ceeling_dose="+max_unit_ceeling_dose+"&min_unit_ceeling_dose="+min_unit_ceeling_dose+"&dose_unit_desc1="+dose_unit_desc1, arguments, features);//dose_unit_desc added for ML-MMOH-SCF-0863
 	//added for IN070605 start
 	if(retVal!="" && retVal != null){
	 	document.getElementById("DOSELIMIT"+allergy_cnt).innerHTML = "<img src='../../ePH/images/yellow.jpg'>";
 		 	document.getElementById("DOSELIMIT_VALUE"+allergy_cnt).value="Y";
 		 	}
 	//added for IN070605 end
}

function clearRemarks(frmobj,no,order_line_no) {

	recno		=	no;
	bean_id		=	frmobj.bean_id.value;
	bean_name	=	frmobj.bean_name.value;
	order_id	=	frmobj.order_id.value;
	drug_code	=	eval("frmobj.drug_code"+no+".value");

		var xmlStr ="<root><SEARCH ";
		xmlStr+= "recno =\"" + recno + "\" " ;
		xmlStr+= "drug_code =\"" + drug_code + "\" " ;
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "order_id =\"" + order_id + "\" " ;
		xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="DispMedicationValidation.jsp?func_mode=clearRemarks";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		

}

function checkFlds( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "\n" ;
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

async function showDrugDetails(patient_class,locn_code,order_id,drug_code,ord_line_no,called_from,disp_locn_code,from_sliding_scale_yn,mfr_yn, patient_id,amend_Dtls,generic_id,order_line_status){  // patient_id  added for [IN:035667]  (AmendDtls,generic_id,order_line_status added for JD-CRF-0198 [IN058599])

	var disp_stage = "";  // added for JD-CRF-0198 [IN058599] - Start 
	var pract_id =  ""; 
	var allow_amend_alt_drug_dtl = "";
	
	if(amend_Dtls=="Y"){
	    disp_stage = document.getElementById("curr_stage").value;  
		pract_id =  document.getElementById("performing_pract_id").value; 
		allow_amend_alt_drug_dtl =  document.getElementById("allow_amend_alt_drug_dtl").value; 
	} // added for JD-CRF-0198 [IN058599] - End

	var retVal;
	if(called_from==undefined)
	called_from		=	"";
	var dialogTop		= "30vh";

	var dialogWidth		= "60vw" ;
	var center			= "1" ;
	if(from_sliding_scale_yn!=null && from_sliding_scale_yn==("Y")){
		var dialogHeight	= "30vh" ;
		var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + "; center: " + center +';  dialogTop:'+dialogTop +'; status=no';
	}
	else{
		var dialogHeight	= "30vh" ;
		var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + "; center: " + center +';  dialogTop:'+dialogTop +';scrolling=no; status=no';
	}
	var arguments		= "";

	retVal 				= await top.window.showModalDialog("../../ePH/jsp/DispMedicationDrugDetails.jsp?patient_class="+patient_class+"&locn_code="+locn_code+"&order_id="+order_id+"&drug_code="+drug_code+"&order_line_no="+ord_line_no+"&called_from="+called_from+"&disp_locn_code="+disp_locn_code+"&from_sliding_scale_yn="+from_sliding_scale_yn+"&mfr_yn="+mfr_yn+"&patient_id="+patient_id+"&disp_stage="+disp_stage+"&generic_id="+generic_id+"&allow_amend_alt_drug_dtl="+allow_amend_alt_drug_dtl+"&pract_id="+pract_id+"&order_line_status="+order_line_status,arguments,features);  //  patient_id added for [IN:035667]  //pract_id,generic_id,allow_amend_alt_drug_dtl and disp_stage added for JD-CRF-0198 [IN058599]
	if(retVal=="AMEND") {
		document.location.reload();
	}
	if(retVal=="ALTER") {
		if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria!=undefined){
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.patient_id.value=patient_id;
		parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.patient_id.value=""; 
		}else if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP!=undefined){
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.patient_id.value=patient_id;
		parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.patient_id.value=""; 
		}
	}
}

async function showOverRideReason(allergy,exceed_dose,duplicate) {
	var dialogHeight = "250px";//18

	if(allergy!="" && exceed_dose!="" && duplicate!="")
		dialogHeight= "250px" ;//18
	else if ( (allergy!="" && exceed_dose!="") || (exceed_dose!="" && duplicate!="") || (allergy!="" && duplicate!="" ))
		dialogHeight= "250px" ;//12
	else
		dialogHeight= "250px" ;//9
	var dialogTop		= "30px";
 	var dialogWidth		= "500px" ;
	var center			= "1" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + "; center: " + center +';  dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
 	retVal 				= await window.showModalDialog("../../ePH/jsp/DispMedicationOverRideReasons.jsp?allergy="+encodeURIComponent(allergy,"UTF-8")+"&exceed_dose="+encodeURIComponent(exceed_dose,"UTF-8")+"&duplicate="+encodeURIComponent(duplicate,"UTF-8"),arguments,features);
}


async function callFilling(patient_id,order_id,drug_code,disp_stage,sub_disp_stage) {

	var retVal;
	var dialogTop		= "";
 	var dialogHeight	= "" ;

	if(disp_stage=="F")
		source	=	"Fill";
	else if(disp_stage=="AS" && sub_disp_stage=="F")
		source	="Fill";

	frmObj				=	document.DispMedicationAllStages;
	if(frmObj.module_id.value=="2") {
		dialogTop		=	"90";
		dialogHeight	=	"40";
	}
	else {
		dialogTop		= "200";
		dialogHeight	= "23" ;
	}
 	var dialogWidth		= "80" ;
	var center			= "1" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +';  dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
 	retVal 				= await window.showModalDialog("../../ePH/jsp/DispMedicationAllocateFrames.jsp?patient_id="+patient_id+"&order_id="+order_id+"&chosen_drug="+drug_code+"&source=Fill",arguments,features);
	parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value="Changed";
	parent.f_disp_medication_all_stages.location.href="../../ePH/jsp/DispMedicationAllStages.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id;
	if(retVal != null){
		parent.f_disp_medication_header.document.DispMedicationAllStages.durationVal.value = retVal.split('@')[0];
		parent.f_disp_medication_header.document.DispMedicationAllStages.durnType.value = retVal.split('@')[1];
	}
}

async function callAllocate(patient_id,order_id,drug_code,disp_stage,sub_disp_stage) {
	var retVal;
	var dialogTop		= ""; 
 	var dialogHeight	= "" ;
	if(disp_stage=="A")
		source	=	"Alloc";
	else if(disp_stage=="F")
		source	=	"Fill"; 
	else if(disp_stage=="AS" && sub_disp_stage=="A")
		source	="Alloc";
	//Added for KDAH-CRF-0231 [IN-034551].
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=callAllocate";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	//Added for KDAH-CRF-0231 [IN-034551].	
	     frmObj			 =	document.DispMedicationAllStages;
	var  disp_locn_catg  =  frmObj.disp_locn_catg.value
//var durationVal =frmObj.durationVal.value; // Added for ML-MMOH-SCF-0690 if elseadded for fill withfilllist stage not working issue
	if(frmObj.durationVal)
		durationVal = frmObj.durationVal.value;
	else
		durationVal = "999";


	if(frmObj.module_id.value=="2") {
		dialogTop		=	"10";
		dialogHeight	=	"90vh";
	}
	else {
		dialogTop		= "10";
		dialogHeight	= "90vh" ;
	}
	var OrderIds = "";
	if(document.DispMedicationAllStages.OrderIds == undefined)
		OrderIds = parent.f_disp_medication_header.document.DispMedicationAllStages.OrderIds.value;
	else
		OrderIds = document.DispMedicationAllStages.OrderIds.value;

 	var dialogWidth		= "95vw" ;
	var center			= "1" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +';  dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
	//window.open("../../ePH/jsp/DispMedicationAllocateFrames.jsp?patient_id="+patient_id+"&order_id="+order_id+"&chosen_drug="+drug_code+"&source="+source+"&orderIDS_trxRefIDS="+OrderIds);
 	retVal 				= await top.window.showModalDialog("../../ePH/jsp/DispMedicationAllocateFrames.jsp?patient_id="+patient_id+"&order_id="+order_id+"&chosen_drug="+drug_code+"&source="+source+"&durationVal="+durationVal+"&orderIDS_trxRefIDS="+OrderIds,arguments,features); // "&durationVal="+durationVal Added for ML-MMOH-SCF-0690

	if(disp_stage=="AS") {
		frmObj	=	document.DispMedicationAllStages;
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value="Changed";
		//total	=	parseInt(parent.f_disp_medication_all_stages.DispMedicationAllStages.tot_rec.value);//commented for AMS-CRF-0068.1 [IN:050333]  as its not used
		parent.f_disp_medication_all_stages.location.href="../../ePH/jsp/DispMedicationAllStages.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id;
	}
	else if(disp_stage=="V") {
		parent.f_disp_medication_verification.location.href="../../ePH/jsp/DispMedicationVerification.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id;
	}
	else if(disp_stage=="A") {
       if(parent.parent.parent.f_query_criteria!=undefined){

			parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value="Changed";
			parent.f_disp_medication_allocation.location.href="../../ePH/jsp/DispMedicationAllocation.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id;
	   }
	   else{
            parent.f_stage.location.href="../../ePH/jsp/DispMedicationAllocation.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id; 
	   }
	}
	else if(disp_stage=="F") {
		if(parent.f_stage==undefined){
			 if(disp_locn_catg=='I'){
				  parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.change_status.value="Changed";
			 }
			 else if(disp_locn_catg=='O'){
                  parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value="Changed";
			 }

			if(parent.f_disp_medication_filling == null){	
				parent.f_disp_medication_allocation.location.href="../../ePH/jsp/DispMedicationFilling.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id;
			}
			else{
				parent.f_disp_medication_filling.location.href="../../ePH/jsp/DispMedicationFilling.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id;
			}
		}
		else{
            parent.f_stage.location.href="../../ePH/jsp/DispMedicationFilling.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id;
		}
	}
	if(retVal != null){
		parent.f_disp_medication_header.document.DispMedicationAllStages.durationVal.value = retVal.split('@')[0];
		parent.f_disp_medication_header.document.DispMedicationAllStages.durnType.value = retVal.split('@')[1];
		//parent.f_disp_medication_header.document.DispMedicationAllStages.durationVal.onblur();
	}
	//parent.f_disp_medication_header.location.href = "../../ePH/jsp/DispMedicationHeader.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id;
	//changeDurationValue('document.DispMedicationAllStages.duratoinVal','document.DispMedicationAllStages');
}

function callDrugEntry(patient_id,order_id,order_line_no,drug_code,drug_desc,multi_strength,alt_drug_code,alt_drug_desc,color,qty_uom,qty,source)	{
      parent.f_title2.location.href="../../ePH/jsp/DispMedicationAllocateEntryTitle.jsp?drug_desc="+unescape(drug_desc);
	  var resetQty = document.DispMedicationAllocateDetails.resetQty.value;
	  parent.f_drug_entry.location.href="../../ePH/jsp/DispMedicationAllocateDrugsWithoutStock.jsp?patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&drug_code="+drug_code+"&alt_drug_code="+alt_drug_code+"&drug_color="+escape(color)+"&qty_uom="+qty_uom+"&qty="+qty+"&source="+source;
	  parent.f_buttons2.location.href="../../ePH/jsp/DispMedicationAllocationButtons.jsp?drug_code="+drug_code+"&drug_desc="+unesacpe(drug_desc)+"&patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&alt_drug_status="+multi_strength+"&source="+source+"&resetQty="+resetQty;
}

function checkDuplicate(formObj,obj) {
	var arrObj			=	formObj.elements;
	var data			=	new Array();
	var	n				=	0;
	var alt_drug_code	=	formObj.alt_drug_code.value;
	var drug_code		=	formObj.drug_code.value;
	var item_code		=	"";

	if(alt_drug_code!="")
		drug_code		=	alt_drug_code;

	for(i=0; i<arrObj.length; i++){
		if(arrObj[i].name.substr(0,14)=="item_drug_code") {
			item_code	=	arrObj[i].value;
		} else if(arrObj[i].name.substr(0,8)=="batch_id") {
			batch_id	=	arrObj[i].value;
			if(batch_id!="" && item_code==drug_code)	{
			data[n]	=	batch_id;
			n++;
			}
		}
	}

	for(j=0; j<data.length; j++) {
			tmp	=	data[j];
			for(k=j+1; k<data.length; k++) {
				if(data[k]==tmp) {
					alert(getMessage("PH_DUP_BATCH_ID_NOT_ALLOWED","PH"));
					obj.select();
					break;
				}

			}
	}

}

function CompareDate(expiry_date)	{
if( CheckDate(expiry_date) ) {
			var sys_date	=	document.DispMedicationAllocateDrugsWithoutStock.sys_date;

			if(expiry_date.value!="") {
				if(!doDateCheckAlert(sys_date,expiry_date))	{
					alert(getMessage("PH_EXPDATE_GREATER_SYSDATE","PH"));
					expiry_date.select();
				}
			}
	}
}

function allowNumber(obj)	{
	if(CheckForNumber(obj.value)) {
		CheckPositiveNumber(obj);
	}
	else {
		if(obj.value!="")
		obj.select();
	}
}

function validateQty(obj) {
	var valid			=	true;
	var formObj			=	document.DispMedicationAllocateDrugsWithoutStock;
	var arrObj			=	formObj.elements;
	var	pres_qty		=	parseInt(formObj.qty.value);
	var	tot_qty			=	0;
	for(i=0; i<arrObj.length; i++){
		if(arrObj[i].name.substr(0,9)=="issue_qty"){
			issue_qty		=	arrObj[i].value;
			if(issue_qty!="")
			tot_qty		+=	parseInt(issue_qty);
			if(tot_qty > pres_qty) {
				valid = false;
				alert(getMessage("PH_ISSUEQTY_GREATER_PRESQTY","PH"));
				obj.select();
				break;
			}
		}
	}
	return valid;
}

function defaultUOM(obj,no) {
	frmObj	=	document.DispMedicationAllocateDrugsWithoutStock;
	num = parseInt(no)+1;
	if(obj.value !="") {
	unit	=	frmObj.uom.value;
	eval("frmObj.qty_uom"+num+".value=unit");
	eval("frmObj.batch_id"+num+".focus()");
	}

}

function callAdd(frm)	{
	formObj			=	parent.f_drug_entry.document.DispMedicationAllocateDrugsWithoutStock;
	var	result		=	validateFields(formObj);
	if (result){
		storeValues(frm);
	}
}

function checkTotQty(frmObj) {
	var arrObj	= frmObj.elements;
	var qty		=	0;
	var result	=	true;
	var tmp_qty	=	0;
/*	for(var i=0;i<arrObj.length;i++) { //Commented for MMS-SCF-0040 [IN:041888] added below logic for validation
		if(arrObj[i+1]!=null){
			if(arrObj[i+1].name.substr(0,9)=="issue_qty"){
				if(arrObj[i+8].name.substr(0,6)=="select" && arrObj[i+8].checked==true) {
					tmp_qty	=0;
					if(arrObj[i+1].value=="" || parseInt(arrObj[i+1].value)==0) {
						alert(getMessage("PH_ISSUE_QTY_BLANK","PH"));
						result	=	false;
						return false;
					}
					else if(arrObj[i].value!="") {
						qty	+=	parseInt(arrObj[i+1].value);
						tmp_qty	= parseInt(arrObj[i+1].value);
					}
				}
			}
		}

		if(arrObj[i].name.substr(0,9)=="alloc_qty"){
			if(arrObj[i].value!="") {
				avail_qty	=	parseInt(arrObj[i].value);

				if(tmp_qty > avail_qty) {
					alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH"));
					arrObj[i].select(); 
					result	=	false;
					return false;
				}
				tmp_qty	=0;
			}
		}
	}*/
	// added for MMS-SCF-0040 [IN:041888] - to replace the above logic
 	var	totalRecords	= frmObj.totalRecords.value;
	var alloc_qty = 0, disp_avail_qty=0;
	var selObj;
	for(var i=0;i<totalRecords; i++){
		selObj = eval("frmObj.select"+i);
		if(selObj.checked == true){
			alloc_qty = eval("frmObj.issue_qty"+i).value;
			if(alloc_qty == "" || parseInt(alloc_qty)==0){
				alert(getMessage("PH_ISSUE_QTY_BLANK","PH"));
				result	=	false;
				return false;
			}
			else if(alloc_qty !="") {
				qty	+=	parseInt(alloc_qty);
				tmp_qty	= parseInt(alloc_qty);
			}
			disp_avail_qty =  eval("frmObj.alloc_qty"+i).value;
			if(disp_avail_qty!=""){
				avail_qty	=	disp_avail_qty;
				if(parseInt(tmp_qty) > parseInt(avail_qty)) {
					alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH"));
					arrObj[i].select(); 
					result	=	false;
					return false;
				}
				tmp_qty	=0;
			}
		}
	} //// added for MMS-SCF-0040 [IN:041888] - end

	var issueUom_code_value			= parent.f_stock_dtls.DispMedicationStockDetails.issue_uom_select.value;
	var issueuomarray				= issueUom_code_value.split("_");
	var iss_qty_eq_val				= issueuomarray[3]; //Changed from 1 -> 3 for  MMS-SCF-0040 [IN:041888], AAKH-SCF-0113 [IN:048937] - change Issue UOM
	//var base_to_disp_uom_equl_val	= parent.f_stock_dtls.DispMedicationStockDetails.base_to_disp_uom_equl_val.value;//Commented for AAKH-SCF-0113[IN:048937]
	var base_to_def_uom_equl_val    = parent.f_stock_dtls.DispMedicationStockDetails.base_to_def_uom_equl_val.value;//Commented for AAKH-SCF-0113[IN:048937]
	var base_to_disp_uom_equl_val    = parent.f_stock_dtls.DispMedicationStockDetails.base_to_disp_uom_equl.value;// Added for AAKH-SCF-0113[IN:048937]
	
	//var base_to_def_uom_equl_val    = parent.f_stock_dtls.DispMedicationStockDetails.base_to_def_uom_equl.value;// Added for AAKH-SCF-0113[IN:048937]
	//var base_to_def_uom_equl_val    = parent.f_stock_dtls.DispMedicationStockDetails.base_to_def_uom_equl_val.value;// Added for AAKH-SCF-0285[IN:061125]
	var conv_factor                 = CalculateConversionfactor(base_to_def_uom_equl_val,iss_qty_eq_val,base_to_disp_uom_equl_val);
	if(issueUom_code_value != ""){//Added for  MMS-SCF-0040 [IN:041888], AAKH-SCF-0113 [IN:048937] 
		conv_factor =lcm(base_to_def_uom_equl_val, iss_qty_eq_val);
		conv_factor     =lcm(conv_factor, base_to_disp_uom_equl_val);
	}
	//var alloc_equl					=  Math.ceil(parseInt(qty)/parseInt(conv_factor));
	//var act_bms_qty_equl			=  Math.ceil(parseInt(frmObj.bms_qty.value)/parseInt(conv_factor));

   //--------------------------added by manickavasagam J for SCF-6259 start------------------------------------
	var	bms_strength_val			= parent.f_drug_detail.DispMedicationAllocateDetails.bms_strength_val.value;	
	var	prescribed_bms_strength_val = parent.f_drug_detail.DispMedicationAllocateDetails.prescribed_bms_strength_val.value;
	var	alt_strength_value			= parent.f_drug_detail.DispMedicationAllocateDetails.alt_strength_value.value;
	// added for  ML-BRU-SCF-0474[IN035407]--start
	var	alt_drug_line_no			= parent.f_drug_detail.DispMedicationAllocateDetails.alt_drug_line_no.value; 
	var	alt_drug_count			= parent.f_drug_detail.DispMedicationAllocateDetails.alt_drug_count.value;	
	var main_drug_line_no		= 	parent.f_drug_detail.DispMedicationAllocateDetails.main_drug_line_no.value;	

	if(alt_drug_line_no==null || alt_drug_line_no=='')
		alt_drug_line_no = 0;
	if(alt_drug_count==null || alt_drug_count=='')
		alt_drug_count=0;
	// added for  ML-BRU-SCF-0474[IN035407]--End
	var	tmp_alloc_val				= parent.f_drug_detail.DispMedicationAllocateDetails.tmp_alloc_val.value;

	if(alt_strength_value==""){
		alt_strength_value =0;
	}
	//------------------------------- for SCF-6259 end--------------------------------------------------------------
   var alloc_equl       =  Math.ceil((parseInt(qty)*parseInt(base_to_disp_uom_equl_val))/parseInt(conv_factor));
   var total_alt_strength_value=parseInt(alloc_equl)*parseInt(alt_strength_value);	// added by Manickavasagam J for SCF-6259 
   //var total_strength_value	= parseInt(total_alt_strength_value)+parseInt(tmp_alloc_val);	// added by Manickavasagam J for SCF-6259	//commented for  ML-BRU-SCF-0474[IN035407]
   var total_strength_value	= parseInt(total_alt_strength_value); //added for  ML-BRU-SCF-0474[IN035407]
   var act_bms_qty_equl =  Math.ceil((parseInt(frmObj.bms_qty.value)*parseInt(base_to_disp_uom_equl_val))/parseInt(conv_factor));
   	if( base_to_disp_uom_equl_val!=base_to_def_uom_equl_val){ //if block added for ML-BRU-SCF-1433 [IN:051291] 
	   	act_bms_qty_equl  =  Math.ceil((Math.ceil(parseInt(qty))*(conv_factor))/parseInt(base_to_def_uom_equl_val));  // qty Changed to frmObj.bms_qty.value for ML-BRU-SCF-1880
	}
	if((parseInt(alloc_equl)>parseInt(act_bms_qty_equl))){
		if(qty > parseFloat(frmObj.bms_qty.value)) {
			if(frmObj.AllowMoreThanPresQty.value =='Y'){
				if(eval("frmObj.pres_qty_alert").value != 'N'){//code added for AMS-CRF-0035[IN033551]
					if(confirm(getMessage("ALLOC_QTY_GRT_PRES_QTY","PH")))
						result = true;
					else{
						result = false;
						//obj.select();
					}
				}
				else // else block added for IN045021
					result = true;
			}
			else{
				alert(getMessage("PH_ALLOC_QTY_LESS_BMS_QTY","PH"));
				result	=	false;
				return false;
			}
		}
	}
	// added for  ML-BRU-SCF-0474[IN035407] -- start
	var tot_allocated_val = 0;
	for(var k=1;k<=alt_drug_count;k++){
		if(k!=alt_drug_line_no){
			if(eval("parent.f_drug_detail.DispMedicationAllocateDetails.alt_tmp_alloc_"+main_drug_line_no+"_"+k)!=undefined){
				tot_allocated_val+=parseInt(eval("parent.f_drug_detail.DispMedicationAllocateDetails.alt_tmp_alloc_"+main_drug_line_no+"_"+k+".value"));
			}
		}
	} 
	total_strength_value=parseInt(tot_allocated_val)+parseInt(total_alt_strength_value);
	// ML-BRU-SCF-0474[IN035407] -- end
		//-----------------------added by manickavasagam J for SCF-6259 start----------------------------------------------------------------------
	//&& (parseInt(alloc_equl)>parseInt(act_bms_qty_equl) added for ML-BRU-SCF-0474[IN035407]
	if(tmp_alloc_val>0 && total_strength_value>prescribed_bms_strength_val && frmObj.AllowMoreThanPresQty.value !='Y' && (parseInt(alloc_equl)>parseInt(act_bms_qty_equl))){
		alert(getMessage("PH_ALLOC_QTY_LESS_BMS_QTY","PH"));
		result	=	false;
		return false;
	}
	var allow_decimals_yn			= parent.f_drug_entry.DispMedicationAllocateDrugsWithStock.allow_decimals_yn.value;	// Added for AAKH-SCF-0113[IN:048937]	
	var disp_decimal_dtls_yn		= parent.f_drug_entry.DispMedicationAllocateDrugsWithStock.disp_decimal_dtls_yn.value;	// Added for AAKH-SCF-0113[IN:048937]
	if(issueUom_code_value != ""  && !(allow_decimals_yn =='Y' && disp_decimal_dtls_yn=='Y')){//Added by Ganga for  MMS-SCF-0040 [IN:041888] -Start // && !(allow_decimals_yn =='Y' && disp_decimal_dtls_yn=='Y') Added for  AAKH-SCF-0113 [IN:048937] 
		var conv_factor =lcm(base_to_def_uom_equl_val, iss_qty_eq_val);
		conv_factor     =lcm(conv_factor, base_to_disp_uom_equl_val);
		//if(base_to_disp_uom_equl_val!=base_to_def_uom_equl_val || conv_factor != 1){ //Commented MMS-SCF-0040 [IN:041888], AAKH-SCF-0113 [IN:048937] - change Issue UOM
		if(base_to_disp_uom_equl_val!=iss_qty_eq_val || conv_factor != 1){ //Added for  MMS-SCF-0040 [IN:041888], AAKH-SCF-0113 [IN:048937] - change Issue UOM
			//if(parseInt((qty*base_to_disp_uom_equl_val/base_to_def_uom_equl_val)%conv_factor) != 0 ){
			if(parseInt(qty%conv_factor) != 0 ){
				alert(getMessage("PH_ISSUE_UOM_MUL","PH")+conv_factor);				
				return false;
			}
		}
	} // added for MMS-SCF-0040 [IN:041888] -End
	return result;
}

function validateAuthorization(from) {
	var orig_user_pwd	= document.frmDispMedicationAuthorize.orig_user_pwd.value;
	var orig_user_pin	= document.frmDispMedicationAuthorize.orig_user_pin.value;
	var user_password	= document.frmDispMedicationAuthorize.user_password.value;
	var user_pin		= document.frmDispMedicationAuthorize.user_pin.value;
	chkPINautharizedYN(user_pin);

	if(user_password=="" || user_pin=="") {		
		alert(getMessage("PIN_PWD_CANNOT_BE_BLANK","PH"));
		if(user_password=="") {
			document.frmDispMedicationAuthorize.user_password.focus();
		} 
		else {
			document.frmDispMedicationAuthorize.user_pin.focus();
		}
	}  
	else {
		if(from=="OK") {
			if(pinautharized_yn=='Y'){
				window.returnValue="OK";
				window.close();
			}
			else if(orig_user_pwd==user_password && orig_user_pin==user_pin) {
				window.returnValue="OK";
				window.close();
			}
			else {
				alert(getMessage("INVALID_PWD_PIN_NO","PH"));
				document.frmDispMedicationAuthorize.user_password.focus();
			}
		} 
		else {
			window.close();
		}
	}
}

async function verifyAuthorization(drug_class,disp_narcotic_yn,disp_auth_yn, disp_controlled_yn) { // disp_controlled_yn added for SKR-SCF-0688 [IN:036036]
var return_val	=	true;
	//if( (drug_class=="N" || drug_class=="C") && disp_narcotic_yn=="N") {
	if( (drug_class=="N" && disp_narcotic_yn=="N") || (drug_class=="C" && disp_controlled_yn=="N")) { //if condition changed from above for SKR-SCF-0688 [IN:036036]
		alert(getMessage("NARCOTIC_CONT_NOT_AUTHORIZED","PH"));
		return_val	=	false;
	} 
	else if(disp_auth_yn=="Y"){		
		if( disp_narcotic_yn=="Y") {			  
			var dialogHeight= "40vh" ;
			var dialogWidth	= "40vw" ;
			var dialogTop = "150" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			retVal = await window.showModalDialog("../../ePH/jsp/DispMedicationAuthorize.jsp",arguments,features);
			if(retVal=="OK") {
				return_val	=	true;
			}
			else {
				return_val	=	false;
			}
		}
    }
	return return_val;
}

function callStockAdd(det,oper_mode) {
	frmObj			=	parent.f_drug_entry.document.DispMedicationAllocateDrugsWithStock;

	frmObj.oper_mode.value	= oper_mode;

	var disp_narcotic_yn	=	frmObj.disp_narcotic_yn.value;
	var drug_class			=	frmObj.drug_class.value;
    var disp_auth_yn        =	frmObj.disp_auth_yn.value; 
    var disp_controlled_yn        =	frmObj.disp_controlled_yn.value; //added for SKR-SCF-0688 [IN:036036]
    var userAuthPINYN        =	frmObj.userAuthPINYN.value; //added for RUT-CRF-0035 [IN029926]
	if(userAuthPINYN=="Y")  //added for RUT-CRF-0035 [IN029926] - To override the drug level authentication; Pin Authorization will be done during apply button click
		disp_auth_yn="N";
	if(verifyAuthorization(drug_class,disp_narcotic_yn,disp_auth_yn, disp_controlled_yn)) { // disp_controlled_yn added for SKR-SCF-0688 [IN:036036]
		if(checkTotQty(frmObj)) {
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			var frmObjs = new Array()
			if(frmObj.name == null)
				frmObjs = frmObj
			else
				frmObjs[0] = frmObj
			var xmlStr ="<root><SEARCH ";
			for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
				frmObj = frmObjs[frmCount]
				var arrObj = frmObj.elements;
				for(var i=0;i<arrObj.length;i++) {
					var val = "" ;
					if(arrObj[i].type == "checkbox") {
						if(arrObj[i].checked)	{
							arrObj[i].value="Y";
							val = arrObj[i].value;
						}
						else{
							arrObj[i].value="N";
							val = arrObj[i].value;
						}
					}
					else if(arrObj[i].type == "radio") {
						if(arrObj[i].checked)
							val = arrObj[i].value;
					}
					else if(arrObj[i].type == "select-multiple" ){
						for(var j=0; j<arrObj[i].options.length; j++){
							if(arrObj[i].options[j].selected)
								val+=arrObj[i].options[j].value +"~"
						}
						val= val.substring(0,val.lastIndexOf('~'))
					}
					else
						val = trimString(arrObj[i].value);
					val = checkSpl( val ) ;
					xmlStr+= arrObj[i].name+"=\"" + val + "\" " ;
				}
			}
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DispMedicationValidation01.jsp?func_mode=stock_items",false);
			xmlHttp.send(xmlDoc);
			eval(xmlHttp.responseText );
		}
		else{//Added for KDAH-CRF-0231 [IN-034551] - Start 
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DispMedicationValidation.jsp?func_mode=clear_allocate",false);
			xmlHttp.send(xmlDoc);
			return false;
		}//Added for KDAH-CRF-0231 [IN-034551] - End
	 }
	 else 
		 return false;
	 return true;
}

function storeValues(frm)	{
	var tot_record="";
	var func_mode	=	"";

	if(frm=="batch")	{
		func_mode	= "storeBatch";
		frmObj	=	parent.f_drug_entry.document.DispMedicationAllocateDrugsWithoutStock;
	}
	else{
		func_mode	= "storeMulti";
		frmObj	=	parent.f_alt_drugs.document.DispMedicationAltDrugDetails;
	}

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var arrObj = frmObj.elements;
	var barcode_scan_for_alt_app = ""; //MMS-KH-CRF-0030

	var xmlStr ="<root><SEARCH "; //added and commented below  fortuning during MMS-DM-CRF-0009 [IN:054440] -start
	if(frm=="batch"){
		xmlStr+= "alt_drug_code=\"" + frmObj.alt_drug_code.value + "\" " ;
		xmlStr+= "totalRecords=\"" + frmObj.totalRecords.value + "\" " ;
		xmlStr+= "source=\"" + frmObj.source.value + "\" " ;
		var tot_record = frmObj.totalRecords.value;
	}
	else{
		xmlStr+= "alt_drug_remarks_ind=\"" + frmObj.alt_drug_remarks_ind.value + "\" " ;
		xmlStr+= "tot_record=\"" + frmObj.tot_record.value + "\" " ;
		var tot_record = frmObj.tot_record.value;
//		 barcode_scan_for_alt_app = frmObj.barcode_scan_for_alt_app.value; //MMS-KH-CRF-0030
	}
	var barcode_scan_for_alt_yn="N"; //MMS-KH-CRF-0030
	
	//if(barcode_scan_for_alt_app=="true" || barcode_scan_for_alt_app == true) //MMS-KH-CRF-0030
	//	barcode_scan_for_alt_yn = "Y";

	xmlStr+= "patient_id=\"" + frmObj.patient_id.value + "\" " ;
	xmlStr+= "order_id=\"" + frmObj.order_id.value + "\" " ;
	xmlStr+= "order_line_no=\"" + frmObj.order_line_no.value + "\" " ;
	xmlStr+= "drug_code=\"" + frmObj.drug_code.value + "\" " ;
	xmlStr+= "bean_id=\"" + frmObj.bean_id.value + "\" " ;
	xmlStr+= "bean_name=\"" + frmObj.bean_name.value + "\" " ;
	//xmlStr+= "barcode_scan_for_alt_yn=\"" + barcode_scan_for_alt_yn + "\" " ; //MMS-KH-CRF-0030
	
	//MMS-KH-CRF-0030 - start

	/*if(barcode_scan_for_alt_yn=="Y"){

		valid_flag = true;
		for(var cunt=0; cunt<=parseInt(tot_record); cunt++) {
		var select_yn_1 = eval("frmObj.select"+cunt).checked;
			if(select_yn_1){
				alloc_qty = eval("frmObj.alloc_qty_"+cunt).value;			
				if(alloc_qty=="" || alloc_qty=="0")
					valid_flag = false;
					break;
					
			}
		}
		if(!valid_flag){
			alert(getMessage("ALLOC_QTY_CANNOT_BLANK_ZERO","PH"));		
			return false;
		}
	} */
	//MMS-KH-CRF-0030 - end

	var drugCount=0;
	for(var recCount=0; recCount<=parseInt(tot_record); recCount++) {
		var select_yn = eval("frmObj.select"+recCount).checked;
		if(select_yn){
			if(frm=="batch")	{
				xmlStr+= "item_drug_code"+drugCount+"=\"" + eval("frmObj.item_drug_code"+recCount).value + "\" " ;
				xmlStr+= "item_drug_color"+drugCount+"=\"" + eval("frmObj.item_drug_color"+recCount).value + "\" " ;
				xmlStr+= "batch_id"+drugCount+"=\"" + eval("frmObj.batch_id"+recCount).value + "\" " ;
				xmlStr+= "expiry_date"+drugCount+"=\"" + eval("frmObj.expiry_date"+recCount).value + "\" " ;
				xmlStr+= "issue_qty"+drugCount+"=\"" + eval("frmObj.issue_qty"+recCount).value + "\" " ;
				xmlStr+= "qty_uom"+drugCount+"=\"" + eval("frmObj.qty_uom"+recCount).value + "\" " ;
				xmlStr+= "select"+drugCount+"=\"" + "Y" + "\" " ;
			}
			else{
				xmlStr+= "alt_drug_code"+drugCount+"=\"" + eval("frmObj.alt_drug_code"+recCount).value + "\" " ;
				xmlStr+= "alt_drug_desc"+drugCount+"=\"" +encodeURIComponent( eval("frmObj.alt_drug_desc"+recCount).value ,"UTF-8") + "\" " ;
				xmlStr+= "form_code"+drugCount+"=\"" + eval("frmObj.form_code"+recCount).value + "\" " ;
				xmlStr+= "strength_value"+drugCount+"=\"" + eval("frmObj.strength_value"+recCount).value + "\" " ;
				xmlStr+= "strength_uom"+drugCount+"=\"" + eval("frmObj.strength_uom"+recCount).value + "\" " ;
				xmlStr+= "select"+drugCount+"=\"" +"Y" + "\" " ;
			}
			drugCount++;
		}
	}
	xmlStr+= "drugCount=\"" + drugCount + "\" " ; //added and commented below  fortuning during MMS-DM-CRF-0009 [IN:054440] -end
	/*var frmObjs = new Array() //commented for above tuning during MMS-DM-CRF-0009 [IN:054440]
	if(frmObj.name == null)
		frmObjs = frmObj
	else frmObjs[0] = frmObj
	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount]
		var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked)	{
					arrObj[i].value="Y";
					val = arrObj[i].value;
				}
				else{
					arrObj[i].value="N";
					val = arrObj[i].value;
				}
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked)
					val = arrObj[i].value;
			}
			else if(arrObj[i].type == "select-multiple" ){
				for(var j=0; j<arrObj[i].options.length; j++){
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substring(0,val.lastIndexOf('~'))
			}
			else
				val = arrObj[i].value;

			val = checkSpl( val ) ;

			xmlStr+= arrObj[i].name+"=\"" + val + "\" " ;
			if( arrObj[i].name=='tot_record')
				tot_record=val;
		}
	}*/ //commented for above tuning during MMS-DM-CRF-0009 [IN:054440]
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//if(tot_record!=0){
	xmlHttp.open("POST","DispMedicationValidation.jsp?func_mode="+func_mode+"&source="+frm,false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText );
	//}
}

function validateFields(formObj)	{
	var arrObj		=	formObj.elements;
	var data		=	new Array();
	var valid		=	true;
	var	n			=	0;

	for(i=0; i<arrObj.length; i++){
		if(arrObj[i].name.substr(0,8)=="batch_id"){
			obj_batch_id	=	arrObj[i];
			obj_expiry_date	=	arrObj[i+1];
			obj_issue_qty	=	arrObj[i+2];

			batch_id	=	arrObj[i].value;
			expiry_date	=	arrObj[i+1].value;
			issue_qty	=	arrObj[i+2].value;



			if(batch_id!="")	{
			data[n]	=	batch_id;
			n++;
			}

			if(batch_id=="" && expiry_date!="" && issue_qty!="")	{
				alert(getMessage("PH_BATCH_ID_BLANK","PH"));
				obj_batch_id.select();
				valid	=	false;
				break;
			}
			else if(batch_id!="" && expiry_date=="" && issue_qty!="")	{
				alert(getMessage("PH_EXPIRY_DATE_BLANK","PH"));
				obj_expiry_date.select();
				valid	=	false;
				break;
			}
			else if(batch_id!="" && expiry_date!="" && issue_qty=="")	{
				alert(getMessage("PH_ISSUE_QTY_BLANK","PH"));
				obj_issue_qty.select();
				valid	=	false;
				break;
			} 
			else if(batch_id=="" && expiry_date=="" && issue_qty!="") {
				alert(getMessage("PH_BATCHID_EXPDATE_BLANK","PH"));
				valid	=	false;
				break;
			}
			else if(batch_id=="" && expiry_date!="" && issue_qty=="")  {
				alert(getMessage("PH_BATCHID_ISSUEQTY_BLANK","PH"));
				valid	=	false;
				break;
			}
			else if(batch_id!="" && expiry_date=="" && issue_qty=="")	{
				alert(getMessage("PH_EXPDATE_ISSUEQTY_BLANK","PH"));
				valid	=	false;
				break;
			}
		}

	}
	return valid;
}

function refreshWindow(patient_id,order_id,drug_code,order_line_no,source)	{
//alert("=====1008 called====");	parent.f_drug_detail.location.href="../../ePH/jsp/DispMedicationAllocationDetails.jsp?patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&drug_code="+drug_code+"&source="+source;
	if(source !='MAR'){//if Added for Bru-HIMS-CRF-399 [IN:043767]
		parent.f_drug_entry.location.href="../../eCommon/html/blank.html";
		if(parent.f_buttons1!=null) {
			parent.f_buttons1.location.href="../../ePH/jsp/DispMedicationAllocationButtons.jsp?patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&called_frm=add&source="+source;
			parent.f_buttons2.location.href="../../eCommon/html/blank.html";
		}
	}
}

function refreshAllocation() {
	//Added for KDAH-CRF-0231 [IN-034551]
	frmObj1			=	parent.f_drug_entry.document.DispMedicationAllocateDrugsWithStock;
	frmObj			=	parent.f_drug_buttons.document.allocateDrugsButton;
	bean_id			=	frmObj.bean_id.value;
	bean_name		=	frmObj.bean_name.value;
	patient_id		=	frmObj.patient_id.value;
	var arrObj	= 0;//Added for KDAH-CRF-0231 [IN-034551] - Start
	if(frmObj1!="null" && frmObj1!=undefined){
		arrObj	= frmObj1.elements;
	}
	var qty		=	0;
	var result	=	true;
	var tmp_qty	=	0;
	for(var i=0;i<arrObj.length;i++) {
		if(arrObj[i+1]!=null){
			if(arrObj[i+1].name.substr(0,9)=="issue_qty"){
				if(arrObj[i+8].name.substr(0,6)=="select" && arrObj[i+8].checked==true) {
					tmp_qty	=0;
					if(arrObj[i+1].value=="" || parseInt(arrObj[i+1].value)==0) {
						alert(getMessage("PH_ISSUE_QTY_BLANK","PH"));
						result	=	false;
						return false;
					}
					else if(arrObj[i].value!="") {
						qty	+=	parseInt(arrObj[i+1].value);
						tmp_qty	= parseInt(arrObj[i+1].value);
					}
				}
			}
		}
	}
	var bms_tot_qty=0;
	
	if(frmObj1!="null" && frmObj1!=undefined){
		bms_tot_qty=frmObj1.bms_qty.value;
	} //Added for KDAH-CRF-0231 [IN-034551] - End
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr+= "patient_id=\"" + patient_id + "\" " ;
	xmlStr+= "alloc_tot_qty=\"" + qty + "\" " ;//Added for KDAH-CRF-0231 [IN-034551]
	xmlStr+= "bms_tot_qty=\"" + bms_tot_qty + "\" " ;//Added for KDAH-CRF-0231 [IN-034551]
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=storeAlloc";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	parent.window.close();//Added for KDAH-CRF-0231 [IN-034551]
}

function refreshFilling() {
	frmObj1			=	parent.f_drug_entry.document.DispMedicationAllocateDrugsWithStock;//Added for KDAH-CRF-0231 [IN-034551]
	frmObj			=	parent.f_drug_buttons.document.allocateDrugsButton;
	bean_id			=	frmObj.bean_id.value;
	bean_name		=	frmObj.bean_name.value;
	patient_id		=	frmObj.patient_id.value;
	order_id		=	frmObj.order_id.value;
	//Added for KDAH-CRF-0231 [IN-034551] - Start
	var arrObj	= 0;
	if(frmObj1 !="null" && frmObj1!=undefined){
		arrObj	= frmObj1.elements;
	}
	var qty		=	0;
	var result	=	true;
	var tmp_qty	=	0;
	for(var i=0;i<arrObj.length;i++) {
		if(arrObj[i+1]!=null){
			if(arrObj[i+1].name.substr(0,9)=="issue_qty"){

				if(arrObj[i+8].name.substr(0,6)=="select" && arrObj[i+8].checked==true) {

					tmp_qty	=0;
					if(arrObj[i+1].value=="" || parseInt(arrObj[i+1].value)==0) {
						alert(getMessage("PH_ISSUE_QTY_BLANK","PH"));
						result	=	false;
						return false;
					}
					else if(arrObj[i].value!="") {
						qty	+=	parseInt(arrObj[i+1].value);
						tmp_qty	= parseInt(arrObj[i+1].value);
					}
				}
			}
		}
	}
	var bms_tot_qty=0;
	
	if(frmObj1!="null" && frmObj1!=undefined){
		bms_tot_qty=frmObj1.bms_qty.value;
	} //Added for KDAH-CRF-0231 [IN-034551] - End
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "order_id=\"" + order_id + "\" " ;
	xmlStr+= "alloc_tot_qty=\"" + qty + "\" " ;//Added for KDAH-CRF-0231 [IN-034551]
	xmlStr+= "bms_tot_qty=\"" + bms_tot_qty + "\" " ;//Added for KDAH-CRF-0231 [IN-034551]
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=storeFill";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	parent.window.close();
}

async function callMultiStrength(drug_code,drug_desc,patient_id,order_id,order_line_no,source,store_code,qty_reqd,eff_expiry,main_strength_uom,rec_no, alt_drug_remarks_ind,expiry_date,patient_class,allow_aleternate_yn,item_type_site,strength_value,iv_prep_yn,disp_medication_alt,disp_stage,main_screen_yn)	{//main_screen_yn added for MMS-KH-CRF-0030
	//disp_medication_alt,disp_stage added for MMS-KH-CRF-0028
	var dialogHeight= "90vh" ;
	var dialogWidth	= "90vw" ;
	var dialogTop = "10" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;

	if(main_strength_uom == undefined){
		main_strength_uom = "";
	}
	if(expiry_date!="" && expiry_date!=null && expiry_date!="null"  && disp_medication_alt !="disp_medication_alt"){ // Added for ML-MMOH-SCF-0690 - Start	
		//disp_medication_alt !="disp_medication_alt" added for mms-kh-crf-0028
		if(isBefore(expiry_date,eff_expiry,"DMY","en")){ 
			eff_expiry = expiry_date;
		} 
	} // Added for ML-MMOH-SCF-0690 - End
	//window.open("../../ePH/jsp/DispMedicationAltDrugsFrames.jsp?drug_code="+drug_code+"&drug_desc="+ unescape(encodeURIComponent(drug_desc))+"&patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&source="+source+"&store_code="+store_code+"&qty_reqd="+qty_reqd+"&eff_expiry="+eff_expiry+"&main_strength_uom="+main_strength_uom,arguments,features);

	if(item_type_site=="true" && iv_prep_yn==""){ //GHL-CRF-0549 - start
		if(allow_aleternate_yn=="" || allow_aleternate_yn=="N"){
			var contiueYN = confirm(getMessage("ORD_PRAC_NOT_SUBSTITUTE", "PH")); 
			if(!contiueYN)
			return false;
		}
	}//GHL-CRF-0549 - end
//strength_value added for ghl-crf-0548
	retVal = await window.showModalDialog("../../ePH/jsp/DispMedicationAltDrugsFrames.jsp?drug_code="+drug_code+"&drug_desc="+ drug_desc+"&patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&source="+source+"&store_code="+store_code+"&qty_reqd="+qty_reqd+"&eff_expiry="+eff_expiry+"&main_strength_uom="+main_strength_uom+"&alt_drug_remarks_ind="+alt_drug_remarks_ind+"&strength_value="+strength_value+"&patient_class="+patient_class+"&iv_prep_yn="+iv_prep_yn+"&main_screen_yn="+main_screen_yn,arguments,features);//main_screen_yn added for MMS-KH-CRF-0030

	if(retVal==undefined) /* Added By SureshKumar T For The Incident No : 28957 On 26/09/11*/
		retVal = source;
		//ADDED FOR MMS-KH-CRF-0028 START
		 if(disp_medication_alt =="disp_medication_alt"){
	 
	 if(retVal=="Alloc" && disp_stage=="AS"){
	 parent.f_disp_medication_all_stages.location.href="../../ePH/jsp/DispMedicationAllStages.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id+"&resetQty=true";
	 }
	 if(retVal=="Alloc"){
	 parent.f_disp_medication_allocation.location.href="../../ePH/jsp/DispMedicationAllocation.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id+"&resetQty=true";
	 }
	 if(retVal=="Fill"){
		 parent.f_disp_medication_filling.location.href="../../ePH/jsp/DispMedicationFilling.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id+"&resetQty=true";
		 }
	 parent.window.close();
 }
 //ADDED FOR MMS-KH-CRF-0028  END

	if(retVal=="Alloc" || retVal=="Fill")
		retVal="stock";
   if(retVal=='stock'){
		//refreshStockWindow(patient_id,order_id,order_line_no,drug_code,unescape(drug_desc),'Y','','','','','',source,'');
	   if(disp_medication_alt !="disp_medication_alt"){//added for mms-kh-crf-0028
		refreshStockWindow(patient_id,order_id,order_line_no,drug_code,drug_desc,'Y','','','','','',source,rec_no,'','0','Y');
	   }
	}
	else if(retVal=="WORKSHEET"){
		refreshWSOrderDetailsWindow(patient_id,order_id,order_line_no);
	}
	else{
		 if(disp_medication_alt !="disp_medication_alt"){//added for mms-kh-crf-0028
		refreshWindow(patient_id,order_id,drug_code,order_line_no,source);
		 }
}

}

function evaluateBaseOnForm(obj,frmObj,disp_non_preference_rem_window,patient_id,encounter_id,alt_drug_code,order_id,order_line_no,barcode_scan_for_alt_app,drug_code,recCount)	{ //disp_non_preference_rem_window,patient_id,encounter_id,alt_drug_code added for GHl-ICN-075
	if(obj.checked==true)	{
		//GHL-ICN-0075
		if(disp_non_preference_rem_window==true || disp_non_preference_rem_window=="true"){
		  var allow_proc = formularyNonPreference(alt_drug_code,patient_id,encounter_id,order_id,order_line_no);
		  if(allow_proc==false){
			  obj.checked=false;
		    return false;
		  }
		}
		//MMS-KH-CRF-0030 - start
		if(barcode_scan_for_alt_app=="true" || barcode_scan_for_alt_app==true){
			var tot_record = frmObj.tot_record.value;
			if(drug_code==alt_drug_code){
				
				alert(getMessage("PH_SAME_DRUG_SELECT","PH"));
				eval("frmObj.select"+recCount).checked = false;
				return false;
			}else{
				var alt_flag = true;
				for(i=0;i<parseInt(tot_record);i++){
					if(i!=parseInt(recCount)){
						 if(eval("frmObj.select"+i).checked){
							alt_flag = false;
							break;

						 }
					 }
				}
				if(alt_flag!=true){
						alert(getMessage("PH_ONLY_ONE_ALT_DRUGS_ALLOWED_MAR","PH"));
						eval("frmObj.select"+recCount).checked = false;
						return false;
				}
			}
		}
		//MMS-KH-CRF-0030 - end

		obj_name	=	obj.name;
		len			=	obj_name.length;
		obj_no		=	obj_name.substr(6,len);
		form_desc	=	eval("frmObj.indicator"+obj_no+".value");
		var arrObj = frmObj.elements;
		var j		=	0;
		for(var i=0;i<arrObj.length;i++) {
			if(arrObj[i].name.substr(0,9)=="indicator")	{
				if( eval("frmObj.indicator"+j+".value")!=form_desc)
					eval("frmObj.select"+j+".checked=false");
				j++;
			}
		}

/*		if(barcode_scan_for_alt_app=="true" && drug_yn=="Y" && main_screen_yn=="Y"){ //added for MMS-KH-CRF-0030 - start
				eval("frmObj.alloc_qty_"+cunt).disabled = false;
		}
		}else{
		    if(barcode_scan_for_alt_app=="true" && drug_yn=="Y" && main_screen_yn=="Y"){
				eval("frmObj.alloc_qty_"+cunt).disabled = true;
		} //added for MMS-KH-CRF-0030 - end */
	}
}

function changeRowColor(no) {
    resetColor();
        var row = document.getElementById("tr_" + no);
        var len = row.cells.length;
        for (var i = 0; i < len; i++) {
        row.cells[i].style.backgroundColor = '#ffffcc'; 
    }
}


function resetColor() {
	for(i=0; i<document.getElementById("length"); i++){
		if(document.all(i).id!=null){
			obj		=	document.all(i);
			color	=	obj.style.backgroundColor;
			if(color=="#ffffcc") {
				obj.style.backgroundColor="";
			}
		}
	}
}

/*function clickNextDrug(recno,document,wind) {

	var i = 0;
	var found	=	false;

	for(i=0; i<document.getElementById("length"); i++){
		if(document.all(i).id!=null){
			obj		=	document.all(i);
			color	=	obj.style.backgroundColor;

			if(obj.id!=null) {
				if(obj.id.length > 9 ) {
				if(obj.id.substr(0,9)=="alte_drug")
				found	=	true;
				}
			}


			if(color=="#ffffcc") {
				obj.style.backgroundColor="";
				break;
			}
		}
	}

if(!found){
	if(eval("document.getElementById("drug_desc")"+recno)!=undefined && eval("document.getElementById("drug_desc")"+recno+".style.fontWeight")!="bold") {
		eval("document.getElementById("drug_desc")"+recno+".click()");
		
		if(parseInt(recno)>4) {
			document.body.scrollTop=document.body.scrollTop+25;
		} 
		
	}
	else {
	parent.parent.f_stock_dtls.location.href="../../ePH/jsp/DispMedicationStockDetails.jsp";
	}
} else {
parent.parent.f_stock_dtls.location.href="../../ePH/jsp/DispMedicationStockDetails.jsp";
}


}
*/
function clickNextDrug(recno,document,wind,alt_drg_no,patient_id,reload_yn,source) {
	var i = 0;
	var found	=	false;

	for(i=0; i<document.getElementById("length"); i++){
		if(document.all(i).id!=null){
			obj		=	document.all(i);
			color	=	obj.style.backgroundColor;

			if(obj.id!=null) {
				if(obj.id.length > 9 ) {
					if(obj.id.substr(0,9)=="alte_drug"){
						found	=	true;
					}
				}
			}
			if(color=="#ffffcc") {
				obj.style.backgroundColor="";
				break;
			}
		}
	}
	if(eval(document.getElementById("alte_drug_desc"+recno+"_"+alt_drg_no))!=undefined) {
		found	=	true;
	}
	else{
		found	=	false;
	}
	if(alt_drg_no=='99'){		    
		recno =recno-1;
		var durationVal =""; // Added for ML-MMOH-SCF-0690 - Start
		if(parent.frames[0].DispMedicationAllocateDrugsTitle!="undefined")
			durationVal = parent.frames[0].DispMedicationAllocateDrugsTitle.durationVal.value;  // Added for ML-MMOH-SCF-0690 - End
		parent.parent.f_drug_detail.location.href="../../ePH/jsp/DispMedicationAllocationDetails.jsp?patient_id="+patient_id+"&re_load_yn=N"+"&recno="+recno+"&source="+source+"&durationVal="+durationVal; // "&durationVal="+durationVal Added for ML-MMOH-SCF-0690 
		/*if(eval("document.getElementById("drug_desc")"+recno)!=undefined && eval("document.getElementById("drug_desc")"+recno+".style.fontWeight")!="bold"){
			recno =recno-1;
			eval("document.getElementById("drug_desc")"+recno+".click()");
		}*/
		return;
	}

	if(!found){
		//if (document.getElementById("drug_desc" + recno) !== undefined && document.getElementById("drug_desc" + recno).style.fontWeight !== "bold") {
		if (document.getElementById("drug_desc" + recno) !== null && document.getElementById("drug_desc" + recno).style.fontWeight !== "bold") {
			eval(document.getElementById("drug_desc"+recno).click());
			if(parseInt(recno)>4) {
				document.body.scrollTop=document.body.scrollTop+25;
			} 
		}
		else {
			//parent.parent.f_stock_dtls.location.href="../../ePH/jsp/DispMedicationStockDetails.jsp";
		  // if(reload_yn=='N'||reload_yn==undefined){
				parent.f_stock_dtls.location.href="../../ePH/jsp/DispMedicationStockDetails.jsp";
		  // }else{
			  // parent.parent.f_drug_detail.location.href="../../ePH/jsp/DispMedicationAllocationDetails.jsp?patient_id="+patient_id+"&re_load_yn=N";
		   //}
		}
	} 
	else {
		if(eval(document.getElementById("alte_drug_desc"+recno+"_"+alt_drg_no))!=undefined) {
			eval(document.getElementById("alte_drug_desc"+recno+"_"+alt_drg_no).click());	
		}
		else{
			parent.parent.f_stock_dtls.location.href="../../ePH/jsp/DispMedicationStockDetails.jsp";
		}
	}	
}


function resetForm()	{
	parent.f_drug_entry.document.DispMedicationAllocateDrugsWithoutStock.reset();
}

function resetStockForm() {
	parent.f_drug_entry.document.DispMedicationAllocateDrugsWithStock.reset();
}


function ClearDrugDetails() {
	frmObj		=	parent.f_drug_entry.document.DispMedicationAllocateDrugsWithoutStock;
	patient_id	=	frmObj.patient_id.value;
	order_id	=	frmObj.order_id.value;
	drug_code	=	frmObj.drug_code.value;
	order_line_no	=	frmObj.order_line_no.value;
	bean_id		=	frmObj.bean_id.value;
	bean_name	=	frmObj.bean_name.value

	var xmlStr ="<root><SEARCH ";
		xmlStr+= "patient_id  =\"" + patient_id + "\" " ;
		xmlStr+= "order_id =\"" + order_id + "\" " ;
		xmlStr+= "drug_code =\"" + drug_code + "\" " ;
		xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="DispMedicationValidation.jsp?func_mode=clearDrugDet";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
}

function apply() {
	//	if( f_disp_medication_all_stages.document.DispMedicationAllStages.formOfDrug.value!="" )	{
		eval( formApply(f_disp_medication_all_stages.document.DispMedicationAllStages,PH_CONTROLLER  ) ) ;
		if( result ) {
			onSuccess();
		}
	//	}
	//	else	{
	//	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
      //  return false;

	//	}
}

function onSuccess() {
	formObj	=	f_disp_medication_all_stages.document.DispMedicationAllStages;
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function controlAllocFillingButtons() {
	frmObj					=	document.DispMedicationAllStages;
	doc						=	parent.f_disp_medication_header.document;

	var tot_recs			=	frmObj.recCount.value;
	var	del_data			=	frmObj.del_data.value;
	var alloc_fill_found	=	false;
	var all_detail			=	true;
	var detail				=	false;

	if(frmObj.filling_status.value=="A") {
		next_button		=	"fill_but";
		next_but_name	=	"fill_detail";
		curr_button		=	"alloc_but";
		curr_but_name	=	"alloc_detail";
	}
	else {
		next_button		=	"alloc_but";
		next_but_name	=	"alloc_detail";
		curr_button		=	"fill_but";
		curr_but_name	=	"fill_detail";
	}

// To enable/disable next stage button
	for(i=1; i<tot_recs; i++){
		var val	=	trimString(eval(document.getElementById(curr_but_name+i).innerText));
		if(val=="Detail" || val=="Det"){
		alloc_fill_found	=	true;
		break;
		}
	}


	if(!alloc_fill_found) {
		 eval("doc."+next_button+".disabled=true");
	}
	else {
		 eval("doc."+next_button+".disabled=true");
	}

//Enable or Diable delivery button (if present )
	/*if(eval("doc."+next_button+".disabled==true")) {
		if(doc.delivery_but!=null)
			doc.delivery_but.disabled = true;
	}
	else {*/
		/*for(i=1; i<tot_recs; i++){
			var val	=	trimString(eval("document."+next_but_name+i+".innerText"));
			if(val=="Detail"){
			detail	=	true;
			break;
			}
		}
		if(detail) {*/
			if(doc.delivery_but!=null){
				doc.delivery_but.disabled = false;
				doc.delivery_but.style.cursor='hand';
			}
		/*}
		else	{
			if(doc.delivery_but!=null) {
				doc.delivery_but.disabled = true;
				doc.delivery_but.style.cursor='auto';
			}

		}*/


	/*if(del_data!="") {
	eval("doc."+next_button+".disabled=true");
	doc.delivery_but.disabled = false;
	doc.delivery_but.style.cursor='hand';
	}*/

	//}

	// Enable or disable the current stage button
	var	 all_record		=	false;
	for(i=1; i<tot_recs; i++){
		var val		=	trimString(eval(document.getElementById(curr_but_name+i).innerText));
		var st_yn	=	eval("frmObj.stock_yn"+i+".value");
		var hold_yn	=	eval("frmObj.hold"+i+".checked");

		if(val=="Det" || st_yn=="N" || hold_yn){
		all_record	=	true;
		}
		else{
			all_record	=	false;
			break;
		}
	}

	if(all_record) {
		 eval("doc."+curr_button+".disabled=true");
	}
	else {
		 eval("doc."+curr_button+".disabled=false");
	}

}

function notifyChange(obj) {
	if(obj!= null){
		if(obj.checked==true) {
		obj.value	=	"D";
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value="Changed";
		}
		else {
		obj.value	=	"E";
		parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value="Changed";
		}
	}
}

function updateValue(obj) {
	if(obj.checked==true)
		obj.value	="Y";
	else
		obj.value	="N";
}

function controlAllocButton() {
	frmObj					=	document.DispMedicationAllStages;
	doc						=	parent.f_disp_medication_header.document;

	var tot_recs			=	frmObj.recCount.value;
	var	del_data			=	frmObj.del_data.value;
	var alloc_found			=	false;
	var detail				=	false;

	//Enable or Diable delivery button (if present )
	for(i=1; i<tot_recs; i++){
		var val	=	trimString(document.getElementById("alloc_detail"+i).innerText);
		if(val=="Detail" || val=="Det"){
			detail	=	true;
			break;
		}
	}
	if(detail) {
		if(doc.delivery_but!=null){
			doc.delivery_but.disabled = false;
			doc.delivery_but.style.cursor='hand';
		}
	}
	else{
		if(doc.delivery_but!=null) {
			doc.delivery_but.disabled = true;
			doc.delivery_but.style.cursor='auto';
		}
		if(del_data!="") {
			doc.delivery_but.disabled = false;
			doc.delivery_but.style.cursor='hand';
		}
	}
}

function controlFillingButton(frmObj) {

	var tot_recs			=	frmObj.recCount.value;
	var filling_detail		=	false;
	var all_detail			=	true;
	for(i=1; i<tot_recs; i++){// To enable/disable DELIVERY button
		var val	=	trimString(eval(document.getElementById("fill_detail"+i).innerText));
		if(val=="Detail"){
		filling_detail	=	true;
		break;
		}
	}
	if(!filling_detail) {
		document.getElementById("delivery_but").disabled=true;
	}
	else {
		document.getElementById("delivery_but").disabled=false;
	}
	if(frmObj=="SB" || frmObj=="AB"){
		parent.f_disp_medication_all_stages_legends.document.getElementById("allocation_butt").disabled=false;
	}
}

async function callDelivery(patient_id,issue_token_on_regn_yn){

	var tokenNo = "";
	if(issue_token_on_regn_yn=="Y")
		if(	parent.parent.parent.f_query_criteria_token_info.document.frmDispMedicationQueryCriteriaTokenInfo.token_no != undefined)
			tokenNo = parent.parent.parent.f_query_criteria_token_info.document.frmDispMedicationQueryCriteriaTokenInfo.token_no.value;

	if(issue_token_on_regn_yn=="N")
		var dialogHeight= "30vh" ;
	else
		var dialogHeight= "30vh" ;

	var dialogWidth	= "50vw" ;
	var dialogTop = "300" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/DispMedicationCollectorDetails.jsp?patient_id="+patient_id+"&token_no="+tokenNo,arguments,features);

	if(retVal=="OK") {
		frmObj	=	document.DispMedicationAllStages;
		if(frmObj.alloc_but!=null) {
			frmObj.alloc_but.disabled=true;
			frmObj.alloc_but.style.cursor='auto';
		}
		if(frmObj.fill_but!=null) {
			frmObj.fill_but.disabled=true;
			frmObj.fill_but.style.cursor='auto';
		}
		if(parent.f_disp_medication_all_stages==null){
			if(parent.f_disp_medication_delivery==null||parent.f_disp_medication_delivery==undefined){
				frmObj				=	parent.f_stage.DispMedicationAllStages;
				doc					=	parent.f_stage.document;
				var tot_recs		=	frmObj.tot_rec.value;
			}
			else{
				frmObj				=	parent.f_disp_medication_delivery.DispMedicationAllStages;
				doc					=	parent.f_disp_medication_delivery.document;
				var tot_recs		=	frmObj.tot_rec.value;
			}
		}
		else{
			frmObj				=	parent.f_disp_medication_all_stages.DispMedicationAllStages;
			doc					=	parent.f_disp_medication_all_stages.document;
			var tot_recs		=	frmObj.recCount.value;
		}
		var filling_detail	=	false;

	// To Provide Delivered image
		var frmobjheader ="";
		if(parent.f_disp_medication_header!=undefined || parent.f_disp_medication_header!=null){
			frmobjheader=parent.f_disp_medication_header.document.DispMedicationAllStages;
		}
		else{
			 frmobjheader=parent.f_header.document.DispMedicationAllStages;
		}
		for(i=1; i<tot_recs; i++){
			if(eval("doc.fill_detail"+i) != null){
				var val	=	trimString(eval("doc.fill_detail"+i+".innerText"));
				if(val=="Detail"){
					eval("doc.del_detail"+i+".style.visibility='visible'")
					eval("doc.del_detail"+i+".value='Y'")
				}
			}else if(frmobjheader.fill_but==null && frmobjheader.alloc_but!=null) {
				var val	=	trimString(eval("doc.alloc_detail"+i+".innerText"));
				if(val=="Detail"){
					eval("doc.del_detail"+i+".style.visibility='visible'")
					eval("doc.del_detail"+i+".value='Y'")
				}
			}else {
				if(parent.f_disp_medication_all_stages_legends.document.getElementById("btnDelivery") != null){
					parent.f_disp_medication_all_stages_legends.document.getElementById("btnDelivery").disabled =false;
					eval("doc.del_detail"+i+".style.visibility='visible'");
					//eval("doc.del_detail"+i+".value='Y'");
				}
			}
		}
	}
}

function setFocus(frmObj)	{
	var arrObj			=	frmObj.elements;
	for(i=0; i<arrObj.length; i++){
		if(arrObj[i].name.substr(0,8)=="batch_id") {
			if(arrObj[i].disabled==false){
				arrObj[i].focus();
				break;
			}
		}
	}
}
function callStockEntry(patient_id,order_id,order_line_no,drug_code,drug_desc,multi_strength,alt_drug_code,alt_drug_desc,color,qty_uom,qty,source,no,drug_strength,alt_drug_strength,end_date,uom_code,drug_class,stk_qty,min_end_date,main_strength_per_value_pres_uom, PRNOrAbsOrder,alt_drg_no,alt_strength_uom,alt_drug_line_no,facility_id,disp_locn_code) {// alt_drug_line_no added for  ML-BRU-SCF-0474[IN035407]// facility_id,disp_locn_code parameters added for KDAH-CRF-0231 [IN-034551] .
	bms_strength	    =	eval("document.DispMedicationAllocateDetails.bms_strength"+no).value;
	prescribed_strength	=	eval("document.DispMedicationAllocateDetails.prescribed_strength"+no).value;
	if(eval("document.DispMedicationAllocateDetails.alt_drug_count_"+no) != undefined)
		alt_drug_count		= eval("document.DispMedicationAllocateDetails.alt_drug_count_"+no).value; // added for  ML-BRU-SCF-0474[IN035407]
	else
		alt_drug_count =0;
	document.DispMedicationAllocateDetails.bms_strength_val.value=bms_strength;  //added by manickavasagam J for SCF-6259
	document.DispMedicationAllocateDetails.alt_strength_value.value=alt_drug_strength;	//added by manickavasagam J for SCF-6259
	document.DispMedicationAllocateDetails.prescribed_bms_strength_val.value=prescribed_strength; //added by manickavasagam J for SCF-6259
	// added for  ML-BRU-SCF-0474[IN035407] --start
	document.DispMedicationAllocateDetails.main_drug_line_no.value=no;
	document.DispMedicationAllocateDetails.alt_drug_line_no.value=alt_drug_line_no;
	document.DispMedicationAllocateDetails.alt_drug_count.value=alt_drug_count;
	// added for  ML-BRU-SCF-0474[IN035407] --end

	var resetQty        = document.DispMedicationAllocateDetails.resetQty.value;
	oper_mode		    = document.DispMedicationAllocateDetails.oper_mode.value;
	var drg_code        = drug_code;
//added for ML-MMOH-SCF-1829
	if(alt_drug_code!=""){
		drug_code=alt_drug_code;
	}
		parent.f_stock_dtls.location.href="../../ePH/jsp/DispMedicationStockDetails.jsp?drug_code="+drug_code+"&drug_desc="+drug_desc+"&patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&alt_drug_status="+multi_strength+"&source="+source+"&alt_drug_code="+alt_drug_code+"&alt_drug_desc="+encodeURIComponent(alt_drug_desc,"UTF-8")+"&drug_color="+escape(color)+"&qty_uom="+escape(qty_uom)+"&qty="+qty+"&no="+no+"&drug_strength="+drug_strength+"&alt_drug_strength="+alt_drug_strength+"&end_date="+end_date+"&uom_code="+uom_code+"&bms_strength="+bms_strength+"&oper_mode="+oper_mode+"&drug_class="+drug_class+"&stk_qty="+stk_qty+"&min_end_date="+min_end_date+"&main_strength_per_value_pres_uom="+main_strength_per_value_pres_uom+"&resetQty="+resetQty+"&PrnAbs="+PRNOrAbsOrder+"&alt_drg_no="+alt_drg_no+"&alt_strength_uom="+alt_strength_uom+"&prescribed_strength="+prescribed_strength+"&facility_id="+facility_id+"&disp_locn_code="+disp_locn_code+"&drg_code="+drg_code;//facility_id,disp_locn_code parameters added for KDAH-CRF-0231 [IN-034551] 
	
	if(parent.f_drug_buttons.location.href.indexOf(".jsp")==-1){	
	      parent.f_drug_buttons.location.href="../../ePH/jsp/DispMedicationAllocationButtons.jsp?patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&drug_code="+drug_code+"&alt_drug_status="+multi_strength+"&source="+source+"&called_frm=stock"+"&no="+no+"&resetQty="+resetQty+"&PrnAbs="+PRNOrAbsOrder;
	}
}

function showItemDetail(drug_code,patient_id,order_id,order_line_no,drug_color,alt_drug_code,qty,uom,uom_code,source,recno,store_code,end_date,drug_strength,alt_drug_strength,called_from,bms_strength,oper_mode,drug_class,stk_qty,min_end_date,drug_desc,item_code,alt_drug_desc,main_strength_per_value_pres_uom,alt_drg_no,alt_strength_uom,prescribed_strength,barcode_flg) {//barcode_flg parameter added for KDAH-CRF-0231 [IN-034551] 
	parent.f_batch_title.location.href="../../ePH/jsp/DispMedicationStockBatchTitle.jsp?drug_code="+drug_code+"&item_code="+item_code+"&patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&drug_color="+encodeURIComponent(drug_color,"UTF-8")+"&alt_drug_code="+alt_drug_code+"&qty="+qty+"&uom="+encodeURIComponent(unescape(uom),"UTF-8")+"&uom_code="+encodeURIComponent(uom_code,"UTF-8")+"&source="+source+"&no="+recno+"&store_code="+store_code+"&end_date="+end_date+"&drug_strength="+drug_strength+"&alt_drug_strength="+alt_drug_strength+"&called_from="+called_from+"&bms_strength="+bms_strength+"&oper_mode="+oper_mode+"&drug_class="+drug_class+"&stk_qty="+stk_qty+"&min_end_date="+min_end_date+"&drug_desc="+encodeURIComponent(drug_desc,"UTF-8")+"&alt_drug_desc="+encodeURIComponent(alt_drug_desc,"UTF-8")+"&alt_strength_uom="+encodeURIComponent(alt_strength_uom,"UTF-8")+"&prescribed_strength="+prescribed_strength+"&barcode_flg="+barcode_flg+"&patient_id="+patient_id;//barcode_flg parameter added for KDAH-CRF-0231 [IN-034551]
	parent.f_drug_entry.location.href="../../ePH/jsp/DispMedicationAllocateDrugsWithStk.jsp?drug_code="+drug_code+"&item_code="+item_code+"&patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&drug_color="+escape(drug_color)+"&alt_drug_code="+alt_drug_code+"&qty="+qty+"&uom="+escape(uom)+"&uom_code="+escape(uom_code)+"&source="+source+"&no="+recno+"&store_code="+store_code+"&end_date="+end_date+"&drug_strength="+drug_strength+"&alt_drug_strength="+alt_drug_strength+"&called_from="+called_from+"&bms_strength="+bms_strength+"&oper_mode="+oper_mode+"&drug_class="+drug_class+"&stk_qty="+stk_qty+"&min_end_date="+min_end_date+"&drug_desc="+encodeURIComponent(drug_desc,"UTF-8")+"&alt_drug_desc="+encodeURIComponent(alt_drug_desc,"UTF-8")+"&main_strength_per_value_pres_uom="+main_strength_per_value_pres_uom+"&alt_drg_no="+alt_drg_no+"&prescribed_strength="+prescribed_strength+"&barcode_flg="+barcode_flg;//barcode_flg parameter added for KDAH-CRF-0231 [IN-034551]
	//parent.parent.f_buttons.location.href="../../ePH/jsp/DispMedicationAllocationButtons.jsp?"+params+"&called_frm=stock_add";
}

function clearItemDetail() {
	parent.f_batch_title.location.href="../../eCommon/html/blank.html";
	parent.f_drug_entry.location.href="../../eCommon/html/blank.html";
	parent.f_buttons.location.href="../../eCommon/html/blank.html";
}


async function displayDescription(obj,frmObj,drug_code,patient_id,order_id,order_line_no,drug_color,alt_drug_code,qty,uom,uom_code,source,recno,store_code,end_date,drug_strength,alt_drug_strength,called_from,bms_strength,oper_mode,drug_class,stk_qty,min_end_date,drug_desc,alt_drug_desc,main_strength_per_value_pres_uom,alt_drg_no,alt_strength_uom,prescribed_strength,barcode_flg) {//barcode_flg parameter added for KDAH-CRF-0231 [IN-034551]
	
	selectedText	=	obj.options[obj.selectedIndex].text;
	var item_description	=	obj.value;
	if(item_description.length>30) {
		document.getElementById("item_desc_1").innerText = item_description.substr(0,30);
		document.getElementById("item_desc_2").innerText = item_description.substr(30,item_description.length);
	}
	else {
		document.getElementById("item_desc_1").innerText = item_description;
	}

	if(obj.value!="")
		await showItemDetail(drug_code,patient_id,order_id,order_line_no,drug_color,alt_drug_code,qty,uom,uom_code,source,recno,store_code,end_date,drug_strength,alt_drug_strength,called_from,bms_strength,oper_mode,drug_class,stk_qty,min_end_date,drug_desc,selectedText,alt_drug_desc,main_strength_per_value_pres_uom,alt_drg_no,alt_strength_uom,prescribed_strength,barcode_flg);//barcode_flg parameter added for KDAH-CRF-0231 [IN-034551]
}

function checkSelect(obj,no) {
	frmObj	=	document.DispMedicationAllocateDrugsWithStock;
	if(obj.value!="")
		eval("frmObj.select"+no+".checked=true");
	else
		eval("frmObj.select"+no+".checked=false");
}
function completeDispensing(obj,label_display){//added for TH-KW-CRF-0020.3
	if(parent.f_disp_medication_header.document.DispMedicationAllStages.queue_pkid_appl.value==true || parent.f_disp_medication_header.document.DispMedicationAllStages.queue_pkid_appl.value=='true'){//added for TH-KW-CRF-0020.3
		// added
		// for
		// TH-KW-CRF-0020.3
if (parent.f_disp_medication_header.document.DispMedicationAllStages.quePkiId.value == "") {

if (confirm("Primary key of queue number is blank. Do you wish to proceed")) {
completeDispensingqpkid(obj, label_display);
} else{
	parent.f_disp_medication_header.document.DispMedicationAllStages.quePkiId.focus();
return false;
}

}else{
	completeDispensingqpkid(obj,label_display);
}


	}
	else{
		completeDispensingqpkid(obj,label_display);
	}
}

function completeDispensingqpkid(){//MODIFIED for TH-KW-CRF-0020.3
	var formObj =	parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_all_stages;
	var doc		=	parent.parent.DispMedicationPatDetFrame_3.f_disp_medication_all_stages.document;
	mainForm	=	parent.f_disp_medication_all_stages.document.DispMedicationAllStages;
	 var iqvia_integration_flag = false;//MOHE-CRF-0026.1 start
	 var iv_prep_value = ""; 
	 var patient_id = "";   
	 var encounter_id = "";
	 iqvia_integration_flag = mainForm.iqvia_integration_flag.value;
	 iv_prep_value = mainForm.iv_prep_yn.value;
	 patient_id = mainForm.patient_id.value;
	 encounter_id = mainForm.encounter_id.value; //end 	
	var equivalentNormalOrder = mainForm.EquivalentNormalOrder.value;
	var disp_locn_catg       =mainForm.disp_locn_catg.value;//added for MMS-QH-CRF-0201 [IN:052255]
	var total_rec="";
     total_rec=mainForm.tot_rec.value;
	 var rec_total		=	parseInt(total_rec);
	 var found  = false;
	 var found2 = false;
	 var scope="";
   var dispTmpNo = "";//MOHE-CRF-0026.1 
   var bean_id_1   = "DispMedicationBean";
	var bean_name_1 = "ePH.DispMedicationBean";//END 
	var patientClass = "";//MOHE-CRF-0026.1 [TFS:23589]
	var settlementId = "";
	var authStatusCompleted_yn ="";
	patientClass = mainForm.patient_class.value;
	settlementId= mainForm.settlement_id.value;
	authStatusCompleted_yn =mainForm.authStatusCompleted_yn.value;//END 
	
	 if ( iqvia_integration_flag!=undefined && (iqvia_integration_flag == true || iqvia_integration_flag == "true") && iv_prep_value== "" && patientClass=="O" && settlementId =="X" && authStatusCompleted_yn=="Y"){  //MOHE-CRF-0026.1 [TFS:23589]
		 var request_type = "PHDISP";
		   var facility_id = mainForm.facility_id.value; 
		   var added_by_id = mainForm.added_by_id.value;
		   var login_at_ws_no = mainForm.login_at_ws_no.value;  
		   for(var k=1;k<rec_total;k++){
			   if(eval("mainForm.authChecked_"+k).disabled == true){
				  if(eval("mainForm.authChecked_"+k).checked==true){
					   var drug_code = eval("mainForm.drug_code"+k).value; 		
						var order_line_num = eval("mainForm.order_line_num"+k).value;  	
						var alloc_qty = eval("mainForm.allocate_qty"+k).value;	
						if (alloc_qty== "0.0" || alloc_qty==""){
							alert("Qty not allocated for the item");
							frmObj.alloc_qty_check.value = "Z"; 
							return false;
						}
						
						var uom = eval("mainForm.uom"+k).value;
						var frequencyCode = eval("mainForm.frequencyCode"+k).value;						
						var repeatValue = eval("mainForm.repeatValue"+k).value;						 
						var durnValue = eval("mainForm.durnValue"+k).value;						
						var durationType = eval("mainForm.durationType"+k).value;						
						var routeCode = eval("mainForm.routeCode"+k).value;						 
						var qtyValue = eval("mainForm.qtyValue"+k).value;					
						var qtyUnit = eval("mainForm.qtyUnit"+k).value;  						
						var orderId = eval("mainForm.orderId"+k).value; 
						var xmlDoc="";
						var xmlHttp = new XMLHttpRequest();
						var xmlStr ="<root><SEARCH ";
						xmlStr += " patient_id=\""+patient_id+"\"";
						xmlStr += " encounter_id=\""+encounter_id+"\"";
						xmlStr += " orderId=\""+orderId+"\""; 
						xmlStr += " drug_code=\""+drug_code+"\""; 
						xmlStr += " order_line_num=\""+order_line_num+"\""; 
						xmlStr += " alloc_qty=\""+alloc_qty+"\""; 
						xmlStr += " uom=\""+uom+"\""; 
						xmlStr += " frequencyCode=\""+frequencyCode+"\""; 
						xmlStr += " repeatValue=\""+repeatValue+"\""; 
						xmlStr += " durnValue=\""+durnValue+"\""; 
						xmlStr += " durationType=\""+durationType+"\""; 
						xmlStr += " routeCode=\""+routeCode+"\""; 
						xmlStr += " qtyValue=\""+qtyValue+"\""; 
						xmlStr += " qtyUnit=\""+qtyUnit+"\"";  
						xmlStr += " dispTmpNo=\""+dispTmpNo+"\"";  
						xmlStr +=" /></root>" ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						//xmlHttp.open( "POST", "DispMedicationValidation.jsp?func_mode=callDispense", false ) ;	
						xmlHttp.open("POST","DispMedicationValidate.jsp?bean_id="+bean_id_1+"&bean_name="+bean_name_1+"&identity=callDispense",false); //MOHE-CRF-0026.1 
						xmlHttp.send(xmlDoc); 
						eval(xmlHttp.responseText);
				   }
			   }
		   }
	 }
	  
	 //MOHE-CRF-0026.1 END
	 
	    var deliveryChecked = true;  // Added for MMS-KH-CRF-0028 [IN070605] - Start
		
		for(var k=1;k<rec_total;k++){ 		   
		       if(eval("formObj.DispMedicationAllStages.deliveryChecked_"+k)!=undefined && eval("formObj.DispMedicationAllStages.deliveryChecked_"+k+".value")=='Y'){	    	  
		    	   deliveryChecked = true;
		    		 break;
		       }
		       else {
		    		  if(k==rec_total-1){
		    			  deliveryChecked = false;
		    		  }
		       }
		}
		
		     
		if(!deliveryChecked){
		   alert(getMessage("PH_ATLEAST_ONE_SELECTED",'PH'));
		   return;
		} // Added for MMS-KH-CRF-0028 [IN070605] - End
		//added for AAKH-CRF-0117 - start		
		var approval_no_appl_flag = mainForm.approval_no_flag.value;
		var approval_no_app_for_patient_class = mainForm.approval_no_app_for_patient_class.value;//AAKH-CRF-0117
	   if(approval_no_app_for_patient_class=="Y" && (approval_no_appl_flag==true || approval_no_appl_flag=="true")){
			approval_proceed_flag = getApprovalNoValidation("AS",mainForm);

			if(!approval_proceed_flag){
				alert(getMessage("PH_APPROVAL_NO_CANT_BE_BLANK","PH"));
				return false;
			}
	   }
   //added for AAKH-CRF-0117 - end
		if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria !=null){
			scope		=	parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_status.value;
			order_type	=	parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.order_type.value;


		 }else if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP !=null){
          
		   scope		=	parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.ip_scope.value;
		  order_type	=	parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.order_type.value;

		 }

      if(scope=='H'){
			for(i=1; i<rec_total; i++) {
			   if(eval("doc.release_flag"+i)!=undefined) {
				   val1=   eval("doc.release_flag"+i+".value"); 
				   if(val1=='Y'){
						found =true;
						break;
				   }				   
			   }
			}
	  }
	  else{
            /* for(i=1; i<rec_total; i++) {
			    if(eval("doc.DispMedicationAllStages.bms_qty"+i)!=undefined) {			 
					  val		=	eval("doc.DispMedicationAllStages.bms_qty"+i+".value");	
					  if(val!=undefined){
							if((!isNaN(parseInt(trimString(val))))){
								if((parseInt(trimString(val)))<0){								  
								    found2=true;
								    break;
								}
							}
					  }               
				  }
			 }*/
		  	  var alloc_bms_chk = "";	// Added for MO-GN-5434 [IN:043669] 
			  for(i=1; i<rec_total; i++) {
				  alloc_bms_chk ="";	// Added for MO-GN-5434 [IN:043669]
					if(order_type==('NOR') || equivalentNormalOrder ){						 
						if(eval("doc.DispMedicationAllStages.alloc_qty_"+i)!=undefined) {			 
							val		=	eval("doc.DispMedicationAllStages.alloc_qty_"+i+".value");							
							val3	=   eval("doc.allocateyn_"+i+".value");	// Added for MO-GN-5434 [IN:043669] start
							if(eval("doc.DispMedicationAllStages.alloc_bms_chk_"+i)!=undefined){
								if(eval("doc.DispMedicationAllStages.alloc_bms_chk_"+i+".checked") == true)
									alloc_bms_chk	= "Y"	;
								else
									alloc_bms_chk ="N";
							}
							else
								alloc_bms_chk ="N";		// // Added for MO-GN-5434 [IN:043669] end
							if(val!=undefined){
								if(( (!isNaN(parseInt(trimString(val)))) && (parseInt(trimString(val))>0) &&(val3=='Y') )|| alloc_bms_chk =="Y"){	// Added for MO-GN-5434 [IN:043669]
									if( eval("doc.del_detail"+i+".value")==("Y")&& eval("doc.del_detail"+i+".disabled")==false){
										found	= true;
										break;
									}
								}
							}               
						}

						if(eval("doc.alloc_qty"+i)!=undefined) {	 
							val1	=	eval("doc.alloc_qty"+i+".innerText")
							if(val1!=undefined){
								if((!isNaN(parseInt(trimString(val1))))){	
									if( eval("doc.del_detail"+i+".value")==("Y")&& eval("doc.del_detail"+i+".disabled")==false){
										found	= true;
										break;	
									}
								}
							}
						}
					}
					else{
						if(eval("doc.alloc_qty"+i)!=undefined) {
							val		=	eval("doc.alloc_qty"+i+".innerText");
							if(val!=undefined){
								if(!isNaN(parseInt(trimString(val)))){	
									found	= true;
									break;			
								}
							}
						}
					}
		   
				 if((eval("doc.CompleteOrder"+i)!=undefined) ) {
					val1=   eval("doc.CompleteOrder"+i+".value");           
					 if( val1=='Y'){
						 found	= true;
						 break;			
					 }
				  }	

				  if((eval("doc.hold"+i)!=undefined) ) {
					val2=   eval("doc.hold"+i+".value"); 
					
					 if( val2=='Y'){
						 found	= true;
						 break;			
					 }
				  }	
			 }
		}
      		var alertForOutStandingReturn = false;//added for MMS-QH-CRF-0201 [IN:052255] -start
		if(!found2){ 
		   if(found){
		   	retn_disp_med_for_outstanding = document.getElementById("retn_disp_med_for_outstanding").value;//added for MMS-QH-CRF-0201 [IN:052255] -start
			tot_groos_pat_payable = document.getElementById("tot_groos_pat_payable").value;
			patient_id = document.getElementById("patient_id").value;
			disp_locn_code = mainForm.disp_locn_code.value;
			disp_cash_coll_stage  =	document.getElementById("disp_cash_coll_stage").value;
			if(isNaN(tot_groos_pat_payable))
				tot_groos_pat_payable = 0;
			if(retn_disp_med_for_outstanding == 'Y' && disp_locn_catg == 'O' &&  disp_cash_coll_stage == 'D' && parseFloat(tot_groos_pat_payable)>0 ){
				alertForOutStandingReturn = true;
				if(!confirm(getMessage("PH_CONFIRM_PATIENT_PAYABLE_AMOUNT","PH").replace("$$",tot_groos_pat_payable))){
					return false;
				}
			}//added for MMS-QH-CRF-0201 [IN:052255] - end
			eval(formApply( formObj.DispMedicationAllStages,PH_CONTROLLER ));
		   }
		   else{
			  alert(getMessage("PH_NO_CHANGE","PH"));
		   }
		}
		else{
			  alert(getMessage("PH_ALLOC_QTY_LESS_BMS_QTY","PH"));
		}

		var reload	=	true;
		if(parent.parent.parent.document.frames.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo!=null) {
			token_form	=	parent.parent.parent.document.frames.f_query_criteria_token_info.frmDispMedicationQueryCriteriaTokenInfo;	
			token_form.token_no.disabled		=	false;
			token_form.token_no.value			=   "";
			token_form.token_series.disabled	=	false;
			reload	=	false;
		}
		parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;

		if(parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria !=null)
			parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value="";

		var currStage = mainForm.curr_stage.value; //MOHE-CRF-0026.1		
        if ( iqvia_integration_flag!=undefined && (iqvia_integration_flag == true || iqvia_integration_flag == "true") && iv_prep_value==""){   
        	callInterfacePostDispense(currStage);  
        }//MOHE-CRF-0026.1 END  
		if(result) {
			//alert("Hi 2461"+dispNos);
			//alert(parent.f_disp_medication_header.document.DispMedicationAllStages);
			//alert(parent.f_disp_medication_header.document.DispMedicationAllStages.queue_pkid_appl.value);
			//alert("2329");
			if(parent.f_disp_medication_header.document.DispMedicationAllStages.queue_pkid_appl.value==true || parent.f_disp_medication_header.document.DispMedicationAllStages.queue_pkid_appl.value=='true'){//added for TH-KW-CRF-0020.3
			//alert("2494"+dispNos);
			submitPKIDDetails(dispNos);
			}
			//alert("2497");
			parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			callPrintDialog(mainForm,doc);
		}
		else{
			if(message!=''){
				 alert(message);
			}
			parent.parent.DispMedicationPatDetFrame_1.location.reload();
			if(parent.parent.parent.f_query_criteria_buttons!=undefined){
				parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
			}
		}
		parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.disabled	=	false;
}

function beforePost(str){
	//alert("Disp Medication All Stages::"+str);
}


async function callBatchSearch(params,store_code,end_date,trade_code,allowchangetradenameyn,allowmultitradeyn,allow_short_expiry_drugs_yn) {
	frmObj			=	parent.f_stock_dtls.DispMedicationStockDetails;
	item_val		=	frmObj.item_select.value;
	if(item_val=="")
		alert(getMessage("ITEM_CANNOT_BE_BLANK","PH"));
	else {
		var store_code	=	store_code;
		var item_code	=	frmObj.item_select.options[frmObj.item_select.selectedIndex].text;
		var includeZeroStockBatches ="N";
		var includeExpiredBatches ="N";
		var includeSuspendedBatches ="N";
		var searchFunction ="Y";
		var multipleSelect ="Y";
		var retval= await callBatchSearchWindow(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect,trade_code,allowchangetradenameyn,allowmultitradeyn,end_date,allow_short_expiry_drugs_yn);
		if(retval!=undefined && retval!='') {
			parent.parent.f_drug_entry.location.href="../../ePH/jsp/DispMedicationAllocateDrugsWithStk.jsp?"+params+"&item_code="+item_code+"&called_from=stock";
		}
	}
}

async function callBatchSearchWindow(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect,trade_code,allowchangetradenameyn,allowmultitradeyn,end_date,allow_short_expiry_drugs_yn){
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw";
	var dialogTop		= "10" ;
	var dialogLeft		= "20" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
   if(allow_short_expiry_drugs_yn=='N'){
    	retVal= await window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code="+item_code+"&store_code="+store_code+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect="+multipleSelect+"&trade_code="+trade_code+"&p_list_all_trades_yn="+allowchangetradenameyn+"&p_multi_trade_select_yn="+allowmultitradeyn+"&cuttOffDate="+end_date,arguments,features);
   }
   else{
		retVal= await window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code="+item_code+"&store_code="+store_code+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect="+multipleSelect+"&trade_code="+trade_code+"&p_list_all_trades_yn="+allowchangetradenameyn+"&p_multi_trade_select_yn="+allowmultitradeyn,arguments,features);
   }
	//retVal=window.open("../jsp/ItemSearch.jsp?search_string="+search_string+"&store_code="+store_code+"&category="+category+"&sole_source="+sole_source+"&ps_item="+ps_item+"&mfg_item="+mfg_item+"&expiry="+expiry+"&item_class="+item_class,'','dialogHeight:30; dialogWidth:50; center:0; status: no; dialogLeft :200; dialogTop :100;');
	return retVal;
}

function refreshStockWindow(patient_id,order_id,order_line_no,drug_code,drug_desc,multi_strength,alt_drug_code,alt_drug_desc,color,qty_uom,qty,source,no,oper_mode,alt_drg_no,alt_drg_sel) {
	if(multi_strength=="Y") {
		var durationVal =parent.frames[0].DispMedicationAllocateDrugsTitle; // Added for ML-MMOH-SCF-0690 - Start
		if(parent.frames[0].DispMedicationAllocateDrugsTitle!="undefined")
			durationVal = parent.frames[0].DispMedicationAllocateDrugsTitle.durationVal.value; // // Added for ML-MMOH-SCF-0690 - End
		parent.f_drug_detail.location.href="../../ePH/jsp/DispMedicationAllocationDetails.jsp?patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&drug_code="+drug_code+"&source="+source+"&recno="+no+"&alt_drg_no="+alt_drg_no+"&alt_drg_sel="+alt_drg_sel+"&durationVal="+durationVal; // durationVal Added for ML-MMOH-SCF-0690
	} 
	else {
		if(qty!="" && qty!=0) {
			qty_uom_det=qty+" "+qty_uom;
			/*eval(parent.parent.f_drug_detail.document.getElementById('allocate_qty_'+no).innerText=qty_uom_det);
			var pres_qty =eval("parent.parent.f_drug_detail.document.DispMedicationAllocateDetails.pres_qty_"+no+".value");
			var act_bms_qty   =eval("parent.parent.f_drug_detail.document.DispMedicationAllocateDetails.bms_qty_"+no+".value");*/
			parent.f_drug_detail.document.getElementById('allocate_qty_' + no).innerText = qty_uom_det;
			var pres_qty = parent.f_drug_detail.document.getElementById('pres_qty_' + no).value;
			var act_bms_qty = parent.f_drug_detail.document.getElementById('bms_qty_' + no).value;

           
		   var bms_qty =parseInt(act_bms_qty)-parseInt(qty);
		   var bms_det = " "+pres_qty +"<B>("+bms_qty+")</B>"+" "+qty_uom;

			 parent.f_drug_detail.document.getElementById("bms_det_"+no).innerHTML=bms_det;
		}
		no = parseInt(no);
		parent.f_drug_detail.document.getElementById('oper_mode').value=oper_mode;
		clickNextDrug(++no,parent.f_drug_detail.document,window,alt_drg_no,patient_id,'',source);
	}
}

function displayQuanity(frmObj,obj,no) {
	
	name	=	obj.value;
	val		=	eval("frmObj.qty_"+name+".value");
	eval(document.getElementById("disp_"+no).innerText=val);
}

function validateQty(obj,no) {
	allowNumber(obj);
	checkSelect(obj,no);
	if(obj.value =="")
		obj.value=0;
	avail_qty	=	parseInt(eval("document.DispMedicationAllocateDrugsWithStock.alloc_qty"+no+".value"));
	alloc_qty	=	parseInt(obj.value);
	if(parseInt(alloc_qty) > parseInt(avail_qty)) {
		alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH"));
		//obj.select(); //Commented for ICN 29853
		return false;
	}
	return true;
}

async function callPreview(patient_id,order_id) {
	var dialogHeight	= "40vh" ;
	var dialogWidth		= "90vw";
	var dialogTop		= "10";
	var center			= "1" ;
	var status			="no";
	var features		= "dialogHeight:" + dialogHeight +";dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal = await window.showModalDialog("../../ePH/jsp/DispMedicationAllocatePreview.jsp?patient_id="+patient_id+"&order_id="+order_id,arguments,features);
}

function validateCheck(obj,no) {
	if(obj.checked==false) {
	obj	=	eval("document.DispMedicationAllocateDrugsWithStock.issue_qty"+no);
	obj.value	=	"";
	}
}


function controlStockImage(avail_qty,bms,params,barcode_flg,barcode_id,rec_no) {//barcode_flg,barcode_id,rec_no parameters added for KDAH-CRF-0231 [IN-034551]
   if(parseInt(avail_qty) < parseInt(bms)) {
	   try{
		   parent.f_batch_title.document.getElementById("stock_image").style.visibility="visible";
	   }
	   catch (e){}
		if((barcode_id=="" && barcode_flg=="N")|| barcode_flg=="Y" || avail_qty!=0) {//if barcode_flg=="Y" & barcode_id added for KDAH-CRF-0231 [IN-034551]
			parent.f_buttons.location.href="../../ePH/jsp/DispMedicationAllocationButtons.jsp?oper_mode=normal&"+params+"&called_frm=stock_add"+"&barcode_flg="+barcode_flg+"&rec_no="+rec_no;//KDAH-CRF-0231 & [IN-034551] - Barcode CRF Changes
		} 
		else {
			parent.f_buttons.location.href="../../eCommon/html/blank.html";
		}
   } 
   else {
	   	parent.f_buttons.location.href="../../ePH/jsp/DispMedicationAllocationButtons.jsp?"+params+"&called_frm=stock_add"+"&barcode_flg="+barcode_flg+"&rec_no="+rec_no;//barcode_flg parameter added for KDAH-CRF-0231 [IN-034551] 
	    try{
	        parent.f_batch_title.document.getElementById("stock_image").style.visibility="hidden";
	   }
	   catch (e){ }
   }
}

function controlFillingButton() {
	var tot_cnt = 0;
	var formObj ="";
	var frameObj ="";
	if(parent.f_stage==undefined){
		if(parent.f_disp_medication_filling ==null){
			formObj = parent.f_disp_medication_allocation.DispMedicationAllStages;
			frameObj = parent.f_disp_medication_allocation;
		}
		else{
			formObj = parent.f_disp_medication_filling.DispMedicationAllStages;
			frameObj = parent.f_disp_medication_filling;
		}
	}
	else{
       formObj = parent.f_stage.DispMedicationAllStages;
       frameObj = parent.f_stage;
	}
	try{
		tot_cnt	=	parseInt(formObj.tot_rec.value);
	}
	catch (e){
	}

	var found	=	false;
	for(i=1; i<tot_cnt; i++) {
		if(eval(frameObj.document.getElementById("alloc_qty"+i))!=undefined) {
			val	=	eval(frameObj.document.getElementById("alloc_qty"+i).innerText);
			hld_val	=	eval(frameObj.document.getElementById("hold_remarks_"+i).innerText);
			if(!isNaN(parseInt(trimString(val))) || hld_val==on_hold_legend){
				found	= true;
				break;
			}
		}
	}
	if(found){
		if(parent.f_disp_medication_all_stages_legends.document.getElementById("filling_butt") != null)
			parent.f_disp_medication_all_stages_legends.document.getElementById("filling_butt").disabled=false;
	}
}

function controlAllocationButton(obj) {
	var formObj="";
	var frameObj="";
	
   if(parent.f_stage==undefined){
		if(parent.f_disp_medication_allocation ==null){
			formObj = parent.f_disp_medication_filling.DispMedicationAllStages;
			frameObj= parent.f_disp_medication_filling;
		}
		else
		{
			formObj = parent.f_disp_medication_allocation.DispMedicationAllStages;
			frameObj=  parent.f_disp_medication_allocation;
		}
   }
   else{
	   formObj = parent.f_stage.DispMedicationAllStages;
	   frameObj=  parent.f_stage;
   }

	tot_cnt	=	parseInt(formObj.tot_rec.value);

	var found	=	false;
	for(i=1; i<tot_cnt; i++) {
		if(eval(frameObj.document.getElementById("alloc_qty"+i))!=undefined) {
			val	=	eval(frameObj.document.getElementById("alloc_qty"+i).innerText);
			if(eval(frameObj.document.getElementById("hold_remarks_"+i))!=undefined){
				hld_val	=	eval(formObj.document.getElementById("hold_remarks_"+i).innerText);
			}
			if(!isNaN(parseInt(trimString(val))) || hld_val==on_hold_legend){
				found	= true;
				break;
			}
		}
	}

	if(found){
		if(parent.f_disp_medication_all_stages_legends.document.getElementById("allocation_butt")!=null){
		   parent.f_disp_medication_all_stages_legends.document.getElementById("allocation_butt").disabled=false;
	   }
	}
	//else
		//parent.f_disp_medication_all_stages_legends.document.getElementById("allocation_butt").disabled=true;

	if(obj=="SB" || obj=="AB"){
		if(parent.f_disp_medication_all_stages_legends.document.getElementById("allocation_butt")!=null)
			 parent.f_disp_medication_all_stages_legends.document.getElementById("allocation_butt").disabled=false;
	}
}

function controlAllStagesButton() {
	var formObj;
	var frameObj;
	if(parent.f_disp_medication_all_stages!=null)
	{
		formObj = parent.f_disp_medication_all_stages.DispMedicationAllStages;
		frameObj =parent.f_disp_medication_all_stages;
	}
	var tot_cnt	=	parseInt(formObj.tot_rec.value);

	var found	=	false;
	for(i=1; i<tot_cnt; i++) {
		if(eval(frameObj.document.getElementById("alloc_qty"+i))!=undefined) {
			val		=	eval(frameObj.document.getElementById("alloc_qty"+i).innerText);
			hld_val	=	eval(frameObj.document.getElementById("hold_remarks_"+i).innerText);
			if(!isNaN(parseInt(trimString(val))) || hld_val==on_hold_legend){
			found	= true;
			break;
			}
		}
	}
	//if(found)
		//parent.f_disp_medication_all_stages_legends.document.getElementById("all_stages_butt").disabled=false;
	//else
	//	parent.f_disp_medication_all_stages_legends.document.getElementById("all_stages_butt").disabled=true;
}
// added for ML-BRU-CRF-0469 ,tot_gross_amount
function callLegendsFrame(patient_id,stage,tot_no_rec,tpn_finalize,order_id,billing_interface_yn,tot_gross_charge_amount,tot_groos_pat_payable,admixture_yn,DispDrugAuthYN,tot_gross_amount) {
	var bl_decimal_format_str ="";
	//if(admixture_yn=='Y'&&billing_interface_yn=='Y'){
	 if(admixture_yn=='Y'&& billing_interface_yn=='Y'){
		 var formobj							= parent.frames[1].document.DispMedicationAllStages;
		var gross_admx_prep_charge				= formobj.gross_admx_prep_charge.value
		var groos_pat_payable_admx_prep_charge	= formobj.groos_pat_payable_admx_prep_charge.value
		var mark_up_down						= formobj.mark_up_down.value
		var bl_decimal_format_str				= formobj.bl_decimal_format_str.value
		parent.f_disp_medication_all_stages_legends.location.href="../../ePH/jsp/DispMedicationAllStagesLegends.jsp?patient_id="+patient_id+"&stage="+stage+"&tot_no_rec="+tot_no_rec+"&TPN_FINALIZE="+tpn_finalize+"&order_id="+order_id+"&billing_interface_yn="+billing_interface_yn+"&tot_gross_charge_amount="+tot_gross_charge_amount+"&tot_groos_pat_payable="+tot_groos_pat_payable+"&admixture_yn="+admixture_yn+"&gross_admx_prep_charge="+gross_admx_prep_charge+"&groos_pat_payable_admx_prep_charge="+groos_pat_payable_admx_prep_charge+"&mark_up_down="+mark_up_down+"&bl_decimal_format_str="+escape(bl_decimal_format_str)+"&DispDrugAuthYN="+DispDrugAuthYN+"&tot_gross_amount="+tot_gross_amount;//added for ML-BRU-CRF-0469 +"&tot_gross_amount="+tot_gross_amount
	 }
	 else{
		parent.f_disp_medication_all_stages_legends.location.href="../../ePH/jsp/DispMedicationAllStagesLegends.jsp?patient_id="+patient_id+"&stage="+stage+"&tot_no_rec="+tot_no_rec+"&TPN_FINALIZE="+tpn_finalize+"&order_id="+order_id+"&billing_interface_yn="+billing_interface_yn+"&tot_gross_charge_amount="+tot_gross_charge_amount+"&tot_groos_pat_payable="+tot_groos_pat_payable+"&DispDrugAuthYN="+DispDrugAuthYN+"&tot_gross_amount="+tot_gross_amount;//added for ML-BRU-CRF-0469 +"&tot_gross_amount="+tot_gross_amount	
	 }
	if(parent.parent.DispMedicationPatFrame.patient_id_display.frmDispMedicationPatientIDDisplay.disp_locn_catg.value=='O'){
	     parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteria.change_status.value="Changed";
	}
	else{
		 parent.parent.parent.f_query_criteria.frmDispMedicationQueryCriteriaIP.change_status.value="Changed";
	}
	//parent.f_disp_medication_all_stages_legends.location.href="../../ePH/jsp/DispMedicationAllStagesLegends.jsp?patient_id="+patient_id+"&stage="+stage+"&tot_no_rec="+tot_no_rec+"&TPN_FINALIZE="+tpn_finalize+"&order_id="+order_id+"&billing_interface_yn="+billing_interface_yn+"&tot_gross_charge_amount="+tot_gross_charge_amount+"&tot_groos_pat_payable="+tot_groos_pat_payable;
}

function callAllStages(params) {
	parent.f_disp_medication_all_stages.location.href="../../ePH/jsp/DispMedicationAllStages.jsp?"+params+"&resetQty=true"; //resetQty added for MMS-SCF-0245 [IN:046655]
}

function refreshWSOrderDetailsWindow(patient_id,order_id,order_line_no){
	document.frames.location.href="../../ePH/jsp/DispMedicationWSOrderDetails.jsp?patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no;
}

function viewInteraction(patientid,orderid){
	parent.f_disp_medication_interactions.location.href="../../ePH/jsp/DisplayInteractionsFrames.jsp?patientid="+patientid+"&orderid="+orderid+"&encounterid=&JSFile=../../ePH/js/DispMedicationAllStages.js";
	parent.dispmednframeset.rows="10%,*,60%,0%";
}

function closeInteraction(){
	parent.parent.f_disp_medication_interactions.location.href="../../eCommon/html/blank.html";
	parent.parent.dispmednframeset.rows="10%,*,0%,10%";
}

async function showDrugInfo(external_product_id,drug_desc){
	var dialogHeight	="85" ;
	var dialogWidth	="70";
	var dialogTop		= "110" ;
	var dialogLeft		= "70" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	var retVal			= await window.showModalDialog("../../ePH/jsp/DisplayDrugInfoFrames.jsp?extprodid="+external_product_id+"&drugdesc="+drug_desc+"&JSFile=../../ePH/js/Prescription_1.js",arguments,features);
}

function closeInfo(){
	parent.parent.f_disp_medication_interactions.location.href="../../eCommon/html/blank.html";
	parent.parent.dispmednframeset.rows="10%,*,0%,10%";

	if (typeof(parent.parent.f_disp_medication_verification)=="object"){
		showAllOrderLine(parent.parent.f_disp_medication_verification.document);
	}
	else{
		showAllOrderLine(parent.parent.f_disp_medication_all_stages.document);
	}
}

function showSpecificOrderLine(linenum){

	hideAllOrderLine();
	rowobj=eval(document.getElementById("RECORD"+linenum));
	cols=rowobj.cells.length;
	for (i=0;i<cols ;i++ ){
		colobj=rowobj.cells[i];
		colobj.style.display="inline";
	}
}

function showAllOrderLine(doc){
	tab=doc.verificationTable;
	totalrows=tab.rows.length;
	for (i=0;i<totalrows-1;i++ ){
		rowobj=eval("doc.RECORD"+i);
		cols=rowobj.children.length;
		for (j=0;j<cols ;j++ ){
			colobj=rowobj.children[j];
			colobj.style.display="inline";
		}
	}
}

function hideAllOrderLine(){
	tab=document.getElementById("verificationTable");
	totalrows=tab.rows.length;
	for (i=0;i<totalrows-1 ;i++ ){
		rowobj=eval(document.getElementById("RECORD"+i));
		cols=rowobj.children.length;
		for (j=0;j<cols ;j++ ){
			colobj=rowobj.children[j];
			colobj.style.display="none";
		}
	}
}

function callAutoFill(oper_mode) {
	if(oper_mode=="auto")
		document.allocateDrugsButton.auto_alloc_butt.click();
}

async function callFillingRemarks(obj,order_id,drug_code,recno,order_line_no,chk,id){	// code added by senthil kumar j on 16/4/2004
	var dialogHeight	= "75vh" ;
	var dialogWidth		= "40vw";
	var dialogTop		= "10" ;
	var dialogLeft		= "10" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	if(chk=="F" ){
		retVal = await window.showModalDialog("../../ePH/jsp/DispMedicationFillingRemarks.jsp?title="+getLabel("ePH.FillingStageFindings.label","PH")+"&chk="+chk+"&order_id="+order_id+"&drug_code="+drug_code+"&recno="+recno+"&order_line_no="+order_line_no+"&obj="+obj,arguments,features);
	}
	else if(chk=="D" || chk=="A"){
		var title="";
		if(chk=="A"){
			title =getLabel("ePH.AllocateStageFindings.label","PH");
		}
		else{
            title =getLabel("ePH.DeliveryStageFindings.label","PH");
		}	
		retVal = await window.showModalDialog("../../ePH/jsp/DispMedicationFillingRemarks.jsp?title="+title+"&chk="+chk+"&order_id="+order_id+"&drug_code="+drug_code+"&recno="+recno+"&order_line_no="+order_line_no+"&obj="+obj,arguments,features);
	}
	if(retVal=="OK") {

		if(chk=="F")
		   eval("document.DispMedicationAllStages.finding_remarks_yn_"+recno).value = "Y"; //added for ML-MMOH-SCF-1871

		changeColor(obj);
	} 
	else {
		obj.style.color='blue';
	}
}

function setFocusRem(formObj){
	formObj.remarks.focus();
}

async function callFillVal(frmObj,obj){	
	if(frmObj.remarks.value.length < 500){
		if(frmObj.chk.value=="O"){
			await validateAmendReason(frmObj);
		}
		else{
			await validateFillRemarks(frmObj);
		}
	}
	else{
		var val=frmObj.remarks.value; //code added for ML-BRU-SCF-0971[IN042220]
		frmObj.remarks.value = val.substring(0,500);//code added for ML-BRU-SCF-0971[IN042220]
		alert(getMessage("PH_REMARKS_NOT_EXCEED","PH"));					
		frmObj.remarks.focus();//code added for ML-BRU-SCF-0971[IN042220]
	}
}

function validateFillRemarks(frmObj) {
	reason			    =	frmObj.reason.value;
	recno				=	frmObj.recno.value;
	drug_code			=	frmObj.drug_code.value;
	order_id			=	frmObj.order_id.value;
	order_line_no		=	frmObj.order_line_no.value;
	bean_id				=	frmObj.bean_id.value;
	bean_name			=	frmObj.bean_name.value;
	remarks				=	encodeURIComponent(frmObj.remarks.value);
	chk					=	frmObj.chk.value;
	var fields  = new Array() ;
	var names   = new Array() ;
	fields[1]   = frmObj.remarks ;
	fields[0]	= frmObj.reason;
	names[1]    = "Remarks" ;
	names[0]	= "Findings";

	if(checkFlds( fields, names)){
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "reason  =\"" + reason + "\" " ;
		xmlStr+= "remarks =\"" + remarks + "\" " ;
		xmlStr+= "recno =\"" + recno + "\" " ;
		xmlStr+= "drug_code =\"" + drug_code + "\" " ;
		xmlStr+= "order_id =\"" + order_id + "\" " ;
		xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr+= "chk=\"" + chk + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="DispMedicationValidation.jsp?func_mode=filling";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);
		callClose("OK");
	}
	else
		return false;

	//	}
	//	return true;
}

function callCancelFillVal(frmObj){
	
	reason			    =	frmObj.reason.value;
	recno				=	frmObj.recno.value;
	drug_code			=	frmObj.drug_code.value;
	order_id			=	frmObj.order_id.value;
	order_line_no		=	frmObj.order_line_no.value;
	bean_id				=	frmObj.bean_id.value;
	bean_name			=	frmObj.bean_name.value;
	remarks				=	frmObj.remarks.value;	
	chk					=	frmObj.chk.value;
				
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "reason  =\"" + reason + "\" " ;
	xmlStr+= "remarks =\"" + remarks + "\" " ;
	xmlStr+= "recno =\"" + recno + "\" " ;
	xmlStr+= "drug_code =\"" + drug_code + "\" " ;
	xmlStr+= "order_id =\"" + order_id + "\" " ;
	xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr+= "chk=\"" + chk + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=cancelFilling";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;					
	eval(responseText);
	callClose("OK");
}

function changeColor(obj){
	obj.style.color='green';
}

function ChkMaxLen(lab,obj,max,mode) {
	if(obj.value.length >= max) {
		alert("APP-SM0045 - " + lab + " cannot exceed " + max  + " characters" );
		obj.select();
		return false;
	} else return true;
}

var click = 1;
async function callEditDetails(obj,order_id,drug_code,recno,order_line_no,chk,id,patientid,order_date,pres_by,drug_code,drug_name,alt_drug_flag,pres_qty,uom){	// added alt_drug_flag for ML-BRU-SCF-0179 [IN:032578]
	
	var dialogHeight	= "95vh" ;
	var dialogWidth		= "75vw";
	var dialogTop		= "10" ;
	var dialogLeft		= "10" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	//document.getElementById("fill_remarks")(0).style.color='red';
	if(chk=="D" )
		retVal = await top.window.showModalDialog("../../ePH/jsp/DispMedicationEditLabelFrame.jsp?chk="+chk+"&order_id="+order_id+"&recno="+recno+"&order_line_no="+order_line_no+"&patientid="+patientid+"&order_date="+order_date+"&pres_by="+pres_by+"&drug_code="+drug_code+"&drug_name="+encodeURIComponent(drug_name,"UTF-8")+"&alt_drug_flag="+alt_drug_flag+"&pres_qty="+pres_qty+"&click="+click+"&uom="+uom,arguments,features); //added alt_drug_flag for ML-BRU-SCF-0179 [IN:032578]
		//window.open("../../ePH/jsp/DispMedicationEditLabelFrame.jsp?chk="+chk+"&order_id="+order_id+"&recno="+recno+"&order_line_no="+order_line_no+"&patientid="+patientid+"&order_date="+order_date+"&pres_by="+pres_by+"&drug_code="+drug_code+"&drug_name="+encodeURIComponent(drug_name)+"&pres_qty="+pres_qty+"&click="+click+"&uom="+uom,arguments,features);
	else if(chk=="ADetail")
		retVal = await top.window.showModalDialog("../../ePH/jsp/DispMedicationEditLabelFrame.jsp?chk="+chk+"&order_id="+order_id+"&recno="+recno+"&order_line_no="+order_line_no+"&patientid="+patientid+"&order_date="+order_date+"&pres_by="+pres_by+"&drug_code="+drug_code+"&drug_name="+encodeURIComponent(drug_name,"UTF-8")+"&alt_drug_flag="+alt_drug_flag+"&pres_qty="+pres_qty+"&click="+click+"&uom="+uom,arguments,features);//added alt_drug_flag for ML-BRU-SCF-0179 [IN:032578]
		//window.open("../../ePH/jsp/DispMedicationEditLabelFrame.jsp?chk="+chk+"&order_id="+order_id+"&recno="+recno+"&order_line_no="+order_line_no+"&patientid="+patientid+"&order_date="+order_date+"&pres_by="+pres_by+"&drug_code="+drug_code+"&drug_name="+encodeURIComponent(drug_name)+"&pres_qty="+pres_qty+"&click="+click+"&uom="+uom,arguments,features);
	if(retVal=="OK") {
		changeColor(obj);
	} 
	else {
		obj.style.color='blue';
	}

	click = 2;
}
function validateEditDetails(frmObj,calledFrom) {
	frmObj.calledFrom.value = calledFrom;
    //Code Added For RUT-CRF-0067 Start
	var noOfDrugs = frmObj.totalRecordds.value;
	var allow_edit_disp_label = frmObj.allow_edit_disp_label.value;//Added for Bru-HIMS-CRF-414 [IN045554]
	var IncludeZeroQtyForIP=frmObj.IncludeZeroQtyForIP.value;//Added for ML-BRU-CRF-0473
	var IncludeZeroQtyForOP=frmObj.IncludeZeroQtyForOP.value;//Added for ML-BRU-CRF-0473
	var patient_class=frmObj.patient_class.value;//Added for ML-BRU-CRF-0473
	for(var i=0;i<noOfDrugs;i++){
		//try{
			if(allow_edit_disp_label=='Y' && frmObj.document.getElementById('dispQty'+i)!=null ){// if block Added for Bru-HIMS-CRF-414 [IN045554] // && frmObj.document.getElementById('dispQty'+i)!=null added for ML-BRU-SCF-1497 [IN:052793] 
				var sCalledFrom = frmObj.document.DispMedicationEditLabel.sCalledFrom.value;
				var dispQty = frmObj.document.getElementById('dispQty'+i).value;
				var dosageDtl = frmObj.document.getElementById('dosageDtl_'+i).value;
				var drug_yn = frmObj.document.getElementById('drug_yn'+i).value;
				if(dosageDtl=='' && drug_yn=='Y'){ //drug_yn added for added for ML-BRU-SCF-1524 [IN:053164]
					msg = getMessage("CAN_NOT_BE_BLANK","Common");		
					alert(msg.replace('$', getLabel("ePH.DosageDetail.label","PH")));
					frmObj.document.getElementById('dosageDtl_'+i).focus();
					return false;
				}
				if(sCalledFrom=='PrintDialog' && (dispQty=='' || parseInt(dispQty)<1) && ((patient_class=='I' && IncludeZeroQtyForIP=="N") || (patient_class=='O' && IncludeZeroQtyForOP=="N")) ){
					msg = getMessage("PH_NOT_BLANK_ZERO_COMMON","PH");		
					alert(msg.replace('$',getLabel("ePH.DispensedQty.label","PH")));
					frmObj.document.getElementById('dispQty'+i).focus();
					return false;
				}
			}
			if(eval("frmObj.caution_1_"+i)!=null && eval("frmObj.caution_1_"+i).disabled == true)//Added for PH-HSA-CRF-0166 Linked Inc : 050750 and  [IN:052990]
				eval("frmObj.caution_1_"+i).disabled = false;
			if(eval("frmObj.special_1_"+i)!=null && eval("frmObj.special_1_"+i).disabled == true)//Added for PH-HSA-CRF-0166 Linked Inc : 050750 and  [IN:052990]
				eval("frmObj.special_1_"+i).disabled = false;
			/*if(sCalledFrom=='PrintDialog'){ //Commented to avoid duplicate alert //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271]
				var noOfPrint = frmObj.document.getElementById('noOfPrints'+i).value;
				var allocQty = frmObj.document.getElementById('allocQty'+i).value;
				var allow_label_zero = frmObj.document.getElementById('allow_label_zero'+i).value;//Added for ML-BRU-SCF-1122 [IN:044833]
				if(noOfPrint == "" || parseInt(noOfPrint)==0){
				  if(allow_label_zero!="Y"){//Added if and else if for ML-BRU-SCF-1122 [IN:044833]
					  alert(getMessage("PH_NO_OF_PRINT_CANNOT_BALNK","PH"));
					  frmObj.document.getElementById('noOfPrints'+i).value = allocQty; //Added for [IN:033288]
					  frmObj.document.getElementById('noOfPrints'+i).focus();
					  return false;
				   }
				  else if(noOfPrint==""){
					 alert(getMessage("PH_NO_OF_PRINT_CANNOT_BALNK","PH"));
					 frmObj.document.getElementById('noOfPrints'+i).value = allocQty; 
					 frmObj.document.getElementById('noOfPrints'+i).focus();
					 return false; 
				   }
				}
				else{
					if(parseInt(noOfPrint)> parseInt(allocQty) && parseInt(noOfPrint) <1000){
						var contiueYN = confirm(getMessage("PH_NO_OF_PRINTS_GREATER_THAN_DISP_QTY", "PH")); 
						if(!contiueYN){
							frmObj.document.getElementById('noOfPrints'+i).value = allocQty; //Added for [IN:033288]
							frmObj.document.getElementById('noOfPrints'+i).focus();
							return false;
						}
					}
					if (parseInt(noOfPrint) >999){
						if(parseInt(allocQty) >999){
							var contiueYN = confirm(getMessage("PH_NO_OF_PRINT_MORE_THAN_1000", "PH")); 
							if(!contiueYN){
								frmObj.document.getElementById('noOfPrints'+i).value = allocQty; //Added for [IN:033288]
								frmObj.document.getElementById('noOfPrints'+i).focus();
								return false;
							}
						}
						else{
							alert(getMessage("PH_NO_OF_PRINT_MORE_THAN_1000", "PH"));
							frmObj.document.getElementById('noOfPrints'+i).value = allocQty; //Added for [IN:033288]
							frmObj.document.getElementById('noOfPrints'+i).focus();
							return false;
						}
					}  
				}
			}*/
		//}
		//catch(e){}
	}
	//Code Added For RUT-CRF-0067 End 
	//Code Added For FD-Bru-HIMS-CRF-074 & FD-Bru-HIMS-CRF-075 Start 
	if(calledFrom!=undefined){ // added fi condition for incident No:33138
		var chkTabBMS = parent.printSelectFrame.document.getElementById("Bal_Med_table");
		if(chkTabBMS.style.display=="inline"){
			var lang = parent.printSelectFrame.document.DispMedicationPrintDialog.bmsTabLang.value;
			if(lang==""){
				alert(getMessage("PH_SELECT_LANGUAGE", "PH"));
				parent.printSelectFrame.document.DispMedicationPrintDialog.bmsTabLang.focus();
				return false;
			}
		}
		else{
			if(parent.printSelectFrame.document.DispMedicationPrintDialog.printDialogLang!=undefined){//added if condition for INcident No: 32749
				var lang = parent.printSelectFrame.document.DispMedicationPrintDialog.printDialogLang.value;
				if(lang==""){
					alert(getMessage("PH_SELECT_LANGUAGE", "PH"));
					parent.printSelectFrame.document.DispMedicationPrintDialog.printDialogLang.focus();
					return false;
				}
			}
		}
	}
	//Code Added For FD-Bru-HIMS-CRF-074 & FD-Bru-HIMS-CRF-075 End  
	var computeSetOrder = "false";
	if(parent.printSelectFrame != undefined && parent.printSelectFrame.document.DispMedicationPrintDialog != undefined){
		if(parent.printSelectFrame.document.DispMedicationPrintDialog.enable_tab != undefined && parent.printSelectFrame.document.DispMedicationPrintDialog.enable_tab.value == 'Y'){
			computeSetOrder = "true";
		}
	}
	frmObj.ComputeSetOrder.value = computeSetOrder;
	frmObj.submit();
	if(returnValue=="OK") {
		changeColor(frmObj);
	} 
	else {
		frmObj.style.color='blue';
	}
}

/*function validateEditDetails1(frmObj) {	// Commented by Anitha R - It is no where used
	recno				=	frmObj.recno.value;
	drug_code			=	frmObj.drug_code.value;
	order_id			=	frmObj.order_id.value;
	order_line_no		=	frmObj.order_line_no.value;
	bean_id				=	frmObj.bean_id.value;
	caution_1			=	frmObj.caution_1.value;
	
	caution_2			=	frmObj.caution_2.value;
	special_1			=	frmObj.special_1.value;
	special_2			=	frmObj.special_2.value;
	patient_int			=	frmObj.patient_int.value;
	loc_caution_1		=	frmObj.loc_caution_1.value;
	
	loc_caution_2		=	frmObj.loc_caution_2.value;
	loc_special_1		=	frmObj.loc_special_1.value;
	loc_special_2		=	frmObj.loc_special_2.value;
	loc_patient_int		=   frmObj.loc_patient_int.value;
	drug_ind			=   frmObj.drug_ind.value;//Added for  ML-BRU-CRF-072[Inc:29938] 
	bean_name			=	frmObj.bean_name.value;
	chk					=	frmObj.chk.value;
	 
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "recno =\"" + recno + "\" " ;
	xmlStr+= "drug_code =\"" + drug_code + "\" " ;
	xmlStr+= "order_id =\"" + order_id + "\" " ;
	xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr+= "caution_1=\"" + caution_1 + "\" " ;
	xmlStr+= "caution_2=\"" + caution_2 + "\" " ;
	xmlStr+= "special_1=\"" + special_1 + "\" " ;
	xmlStr+= "special_2=\"" + special_2 + "\" " ;
	xmlStr+= "patient_int=\"" + patient_int + "\" " ;
	xmlStr+= "loc_caution_1=\"" + loc_caution_1 + "\" " ;
	xmlStr+= "loc_caution_2=\"" + loc_caution_2 + "\" " ;
	xmlStr+= "loc_special_1=\"" + loc_special_1 + "\" " ;
	xmlStr+= "loc_special_2=\"" + loc_special_2 + "\" " ;
	xmlStr+= "loc_patient_int=\"" + loc_patient_int + "\" " ;
	xmlStr+= "drug_ind_=\"" + drug_ind_ + "\" " ;//Added for  ML-BRU-CRF-072[Inc:29938] 
	xmlStr+= "chk=\"" + chk + "\" " ;
			
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=editlabel";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;	
	//eval(responseText);
	callClose("OK");
}*/

function validateEditDetailsCancel(frmObj) {
/*	order_id			=	frmObj.order_id.value;
	order_line_no		=	frmObj.order_line_no.value;
	bean_id				=	frmObj.bean_id.value;
	bean_name			=	frmObj.bean_name.value;

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "order_id =\"" + order_id + "\" " ;
	xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	
	var temp_jsp="DispMedicationValidation.jsp?func_mode=editlabelcancel";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;	
	
	//eval(responseText);*/
	callClose("CANCEL");
}

function validateEditDetailsReset(frmObj){
	frmObj.reset();
	var sCalledFrom = frmObj.sCalledFrom.value;// if block Added for Bru-HIMS-CRF-414 [IN045554] -start
	var allow_edit_disp_label = frmObj.allow_edit_disp_label.value;
	if(allow_edit_disp_label=='Y'){
		var noOfDrugs = frmObj.totalRecordds.value;
		for(var i=0;i<noOfDrugs;i++){
			frmObj.document.getElementById('dosageDtl_'+i).value= decodeURIComponent(frmObj.document.getElementById('encodedDosageDtl_'+i).value);
		}
	}// if block Added for Bru-HIMS-CRF-414 [IN045554] -End
}
//ended.....
//code added for change dose  (Amend button).....on 29/4/2004
//code added for Amend Prescription....on 3/5/2004
async function callAmendReasonRemarks(obj,order_id,drug_code,order_line_no,chk,patient_id,encounter_id,locn_type,locn_code,patientclass,iv_prep_yn){	
   if(iv_prep_yn==null || iv_prep_yn=="null")
	   iv_prep_yn="";
	var dialogHeight	= "40vh" ;
	var dialogWidth		= "40vw";
	var dialogTop		= "10" ;
	var dialogLeft		= "10" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	if(chk=="O" ){
		retVal =await top.window.showModalDialog("../../ePH/jsp/DispMedicationFillingRemarks.jsp?title="+getLabel("ePH.ReasonforAmend.label","PH")+"&chk="+chk+"&order_id="+order_id+"&drug_code="+drug_code+"&order_line_no="+order_line_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id,arguments,features);
	}
	if(encounter_id=='null'){
		 encounter_id='';
	}		
	if(retVal=="OK"){
		if(iv_prep_yn == '-1')
			iv_prep_yn = '';
		await callAmmendFunctions1('Amend','','',order_id,'',order_line_no,drug_code,'',patient_id,encounter_id,'',locn_type,locn_code,patientclass,'PH','','','','','','',iv_prep_yn);
		window.returnValue="AMEND";
		window.close();
		Setmodified_date(order_id);
	}	
}

function Setmodified_date(order_id){
	var	bean_id				=	"DispMedicationAllStages" ;
	var	bean_name			=	"ePH.DispMedicationAllStages";

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "order_id  =\"" + order_id + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;						
	xmlStr +=" /></root>";
	var temp_jsp ="DispMedicationValidation.jsp?func_mode=Setmodified_date";
	/*var xmlDoc   = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp  = new ActiveXObject( "Microsoft.XMLHTTP" ) ;*/
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);
}

function setAmendRemarks(frmObj){
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "reason  =\"" + frmObj.reason.value + "\" " ;
	xmlStr+= "bean_id =\"" + frmObj.bean_id.value + "\" " ;
	xmlStr+= "bean_name=\"" + frmObj.bean_name.value + "\" " ;
	xmlStr+= "appl_trn_type=\"" + frmObj.chk.value + "\" " ;
	xmlStr+= "frmObj=\"" + frmObj.name + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=setAmendDetails";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);
}

function validateAmendReason(frmObj) {
	reason			    =	frmObj.reason.value;
	drug_code			=	frmObj.drug_code.value;
	order_id			=	frmObj.order_id.value;
	order_line_no		=	frmObj.order_line_no.value;
	bean_id_1			=	frmObj.bean_id_1.value;
	bean_name_1			=	frmObj.bean_name_1.value;
	remarks				=	frmObj.remarks.value;
	patient_id			=	frmObj.patient_id.value;
	encounter_id		=   frmObj.encounter_id.value;
	chk					=	frmObj.chk.value;
	
	var fields  = new Array() ;
	var names   = new Array() ;
	fields[1]   = frmObj.remarks ;
	fields[0]	= frmObj.reason;
	names[1]    = "Remarks" ;
	names[0]	= "Amend Reason";
	remarks = remarks.replace(/\&/g,"&amp;");
	if(checkFlds( fields, names)){
		
		var xmlStr ="<root><SEARCH ";
		xmlStr+= " bean_id =\"DispMedicationAllStages\" " ;
		xmlStr+= " bean_name=\"ePH.DispMedicationAllStages\" " ;
		xmlStr+= "reason  =\"" + reason + "\" " ;
		xmlStr+= "remarks =\"" + remarks + "\" " ;
		xmlStr+= "drug_code =\"" + drug_code + "\" " ;
		xmlStr+= "order_id =\"" + order_id + "\" " ;
		xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
		xmlStr+= "patient_id =\"" + patient_id + "\" " ;
		xmlStr+= "encounter_id =\"" + encounter_id + "\" " ;
		xmlStr+= "chk=\"" + chk + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="DispMedicationValidation.jsp?func_mode=amendReason";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);
		callClose("OK");
	}
	else
		return false;

	//	}
	//	return true;
}

function callAmendReason(frmObj){
	reason			    =	frmObj.reason.value;
	drug_code			=	frmObj.drug_code.value;
	order_id			=	frmObj.order_id.value;
	order_line_no		=	frmObj.order_line_no.value;
	bean_id_1			=	frmObj.bean_id_1.value;
	bean_name_1			=	frmObj.bean_name_1.value;
	remarks				=	frmObj.remarks.value;
	patient_id			=	frmObj.patient_id.value;
	encounter_id		=   frmObj.encounter_id.value;
	chk					=	frmObj.chk.value;				
	remarks = remarks.replace('&',"&amp;");			
	 var xmlStr ="<root><SEARCH ";
	xmlStr+= " bean_id =\"DispMedicationAllStages\" " ;
	xmlStr+= " bean_name=\"ePH.DispMedicationAllStages\" " ; 
	xmlStr+= "reason  =\"" + reason + "\" " ;
	xmlStr+= "remarks =\"" + remarks + "\" " ;
	xmlStr+= "drug_code =\"" + drug_code + "\" " ;
	xmlStr+= "order_id =\"" + order_id + "\" " ;
	xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "encounter_id =\"" + encounter_id + "\" " ;
	xmlStr+= "chk=\"" + chk + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=cancelAmendReason";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);	
}

async function viewInteraction(patientid,orderid,encounterid){
	var dialogHeight	="38vh" ;
	var dialogWidth	="40vw";
	var dialogTop	= "270" ;
	var dialogLeft	= "200" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	retVal = await window.showModalDialog("../../ePH/jsp/DispDisplayInteractions.jsp",arguments,features);
}

function getremarks(obj){
	var bean_id=document.getElementById("bean_id").value;
	var bean_name=document.getElementById("bean_name").value
	var reason=obj.value;
	
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "reason  =\"" + reason + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name =\"" + bean_name + "\" " ;					
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=GetRemarks";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);
}

function PaintRemark(remark){	
	document.getElementById("remarks").value=decodeURIComponent(remark); //decodeURIComponent added for  SKR-SCF-0155 -IN029192
}

function setcompleteorder(obj){
	
	if(obj.checked==true){
		obj.value	="Y";			
	}
	else{
		obj.value	="N";		
	}
}

function LockStatus(user_id,lock_status,login_user,patient_id,disp_locn_code,disp_stage,allow_disp_record_lock_yn){

	lockedStatus = false;
	if(allow_disp_record_lock_yn=='Y'){
		if(lock_status=='0'){
			var patient_id_status='N';
			var xmlStr ="<root><SEARCH ";
			xmlStr+= " bean_id =\"DispMedicationAllStages\" " ;
			xmlStr+= " bean_name=\"ePH.DispMedicationAllStages\" " ;
			xmlStr+= "LOCK_STATUS  =\"" + lock_status + "\" " ;
			xmlStr+= "LOGIN_USER  =\"" + login_user + "\" " ;
			xmlStr+= "PATIENT_ID  =\"" + patient_id + "\" " ;
			xmlStr+= "DISP_LOCN_CODE  =\"" + disp_locn_code + "\" " ;
			xmlStr+= "DISP_STAGE  =\"" + disp_stage + "\" " ;
			xmlStr+= "PATIENT_ID_STATUS  =\"" + patient_id_status + "\" " ;
			xmlStr +=" /></root>";
			var temp_jsp="DispMedicationValidation.jsp?func_mode=CHECKLOCK";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;		
			eval(responseText);	
	   } 
    }
 }

function lockedNormally(returnVal) {
	if (returnVal != "Y" && returnVal != "N") {
		alert(getMessage("PATIENT_RECORD_IS_OPENED_BY_ANOTHER_USER","PH")+" "+returnVal+".  "+getMessage("ACCESS_DENIED","PH"));
		lockedStatus = false;
		return;
	}
	if (returnVal == "N") {
		alert("APP-PH999 Unknown Exception.  Try selecting the patient again");
		lockedStatus = false;
		return;
	}
	lockedStatus = true;
}

function showToolTipLockStatus(obj,user_id,locked_date_time){
	obj.title=getLabel("Common.username.label",'Common')+" : "+user_id +"\n"+getLabel("Common.Date/Time.label",'Common')+" : "+locked_date_time;
}

function UnLockRecord(login_user,patient_id,disp_locn_code,disp_stage,Unlock_all_records_yn){
           
	var patient_id_status='Y';
	if(Unlock_all_records_yn=='Y'){
		var xmlStr ="<root><SEARCH ";
		xmlStr+= " bean_id =\"DispMedicationAllStages\" " ;
		xmlStr+= " bean_name=\"ePH.DispMedicationAllStages\" " ;
		xmlStr+= "LOGIN_USER  =\"" + login_user + "\" " ;
		xmlStr+= "PATIENT_ID  =\"" + patient_id + "\" " ;
		xmlStr+= "DISP_LOCN_CODE  =\"" + disp_locn_code + "\" " ;
		xmlStr+= "DISP_STAGE  =\"" + disp_stage + "\" " ;
		xmlStr+= "PATIENT_ID_STATUS  =\"" + patient_id_status + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="DispMedicationValidation.jsp?func_mode=CHECKUNLOCKRECORDS";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);	
	}
}

function Unlock_status_YN(Unlock_status_value_yn){
 	var tot_rec	=	parent.parent.DispMedicationPatFrame.patient_id_display.frmDispMedicationPatientIDDisplay.tot_rec.value;
	for(j=0; j<tot_rec; j++){
	    if(Unlock_status_value_yn=='N'){
			eval("parent.parent.DispMedicationPatFrame.patient_id_display.frmDispMedicationPatientIDDisplay.lock_status"+j).value='0';
			parent.document.frames.patient_id_display.frmDispMedicationPatientIDDisplay.Logout_gif.style.visibility="hidden";
		}
	}
}

function CheckAccessRights(login_user,patient_id,disp_locn_code,disp_stage,user_id,recCount,tmp_recCount,row_no,patient_name1,sex,age,nursing_unit1,allow_disp_record_lock_yn1, Ordering_FacilityID){
	if(patient_name1==""||patient_name1==null){
		patient_name=eval("document.frmDispMedicationPatientIDDisplay.patient_name_"+recCount+".value");
	}
	else{
		patient_name=patient_name1;
	}

	if(allow_disp_record_lock_yn1=='Y'){
		nursing_unit=nursing_unit1;
		Ordering_Facility_id = Ordering_FacilityID;
		allow_disp_record_lock_yn=allow_disp_record_lock_yn1;
		var xmlStr ="<root><SEARCH ";
		xmlStr+= " bean_id =\"DispMedicationAllStages\" " ;
		xmlStr+= " bean_name=\"ePH.DispMedicationAllStages\" " ;
		xmlStr+= "LOGIN_USER  =\"" + login_user + "\" " ;
		xmlStr+= "PATIENT_ID  =\"" + patient_id + "\" " ;
		xmlStr+= "DISP_LOCN_CODE  =\"" + disp_locn_code + "\" " ;
		xmlStr+= "DISP_STAGE  =\"" + disp_stage + "\" " ;
		xmlStr+= "USER_ID  =\"" + user_id + "\" " ;
		xmlStr+= "RECCOUNT  =\"" + recCount + "\" " ;
		xmlStr+= "TMP_RECCOUNT  =\"" + tmp_recCount + "\" " ;
		xmlStr+= "ROW_NO  =\"" + row_no + "\" " ;
		xmlStr+= "SEX  =\"" + sex + "\" " ;
		xmlStr+= "AGE  =\"" + age + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="DispMedicationValidation.jsp?func_mode=CHECKMESSAGE";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);
	}
	else if(allow_disp_record_lock_yn1=='N'){
	  collapse(recCount,tmp_recCount, patient_id);
	  displayOrdersForPatient(row_no,patient_id,patient_name,sex,age,nursing_unit, Ordering_FacilityID);
	}
}

function GetLockMessageStatus(GetMessageStatus,user_id,rec,tmp_rec,row_no,sex,age,login_user,patient_id,disp_locn_code,disp_stage){
	var retVal ;
	if(GetMessageStatus!='0'){
		alert(getMessage("PATIENT_RECORD_IS_OPENED_BY_ANOTHER_USER","PH")+" "+user_id+".  "+getMessage("ACCESS_DENIED","PH"));
		return false;
	}
	else if(GetMessageStatus=='0'){
		 LockStatus(user_id,GetMessageStatus,login_user,patient_id,disp_locn_code,disp_stage,allow_disp_record_lock_yn);
		if (lockedStatus) {
			collapse(rec,tmp_rec,patient_id);
			displayOrdersForPatient(row_no,patient_id,patient_name,sex,age,nursing_unit, Ordering_Facility_id);
			return true; 
		} 
		else
			return false;
	}
}

async function displayConst(nRow){
	formObj=document.DispMedicationAllStages;
	// var vDrug = eval("formObj.drug_code"+nRow);// commented for ML-MMOH-CRF-1266 [IN:068728]
	var vDrug = eval("formObj.drug_code_"+nRow); // Added for ML-MMOH-CRF-1266 [IN:068728]
	//var vDrugVal = vDrug.value; // commented for ML-MMOH-CRF-1266 [IN:068728]
	var vDrugVal = ""; // Added for ML-MMOH-CRF-1266 [IN:068728] - Start
	if(vDrug!=undefined){ 
		vDrugVal = vDrug.value;
	} // Added for ML-MMOH-CRF-1266 [IN:068728] - End
	var dialogHeight	 = "30vw";
	var dialogWidth	= "50vh";
	var dialogTop	= "199";
	var center		= "1";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	await window.showModalDialog("../../ePH/jsp/TPNRegStdRegConsFrame.jsp?RegimenCode="+vDrugVal,arguments,features);
}

function showToolTipsForChnFldRmks(obj,strCFldRmks){
	if(strCFldRmks != "" && strCFldRmks.length > 0 && strCFldRmks != null && strCFldRmks != "null")
		obj.title= strCFldRmks;
}

function chkPINautharizedYN(pin){				
	var xmlStr ="<root><SEARCH ";
	xmlStr+= " bean_id =\"DispMedicationAllStages\" " ;
	xmlStr+= " bean_name=\"ePH.DispMedicationAllStages\" " ;
	xmlStr+= "PIN  =\"" + pin + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=PINautharizedYN";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);			
}

function PINauthartized_yn(flag){
	pinautharized_yn=flag;
}

async function showTPNDetails(order_id){

	var dialogTop		= "150";
 	var dialogHeight	= "30vh" ;
 	var dialogWidth		= "40vw" ;
	var center			= "1" ;
	var title           ="aaaa";
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + "; center: " + center +';  dialogTop:'+dialogTop +';dialogTitle:'+title+'; scroll=yes; status=no';
 	var arguments		= "";
	
 	await window.showModalDialog("../../ePH/jsp/TPNConstituentDetails.jsp?order_id="+order_id,arguments,features);

}

function showTaperDetails(patient_id,order_id,drug_code){
	var dialogTop		= "300";
 	var dialogHeight	= "10" ;
 	var dialogWidth		= "30" ;
	var center			= "1" ;
	var title           = getLabel("ePH.TaperingDetails.label","PH");
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + "; center: " + center +';  dialogTop:'+dialogTop +';dialogTitle:'+title+'; scroll=yes; status=no';
 	var arguments		= "";
 	window.showModalDialog("../../ePH/jsp/DisplayTaperDrugDetail.jsp?patient_id="+patient_id+"&order_id="+order_id+"&drug_code="+drug_code,arguments,features);
}


async function displayInstructions(order_id,order_line_no,dialogheight,drug_name,from_disp){
	var dialogHeight	= "40vh" ;
	var dialogWidth		= "55vw";
	var dialogTop		= "10" ;
	var dialogLeft		= "10" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	//var retVal=window.showModalDialog("../../ePH/jsp/InstructionsFrame.jsp?order_id="+order_id+"&order_line_no="+order_line_no+"&drug_name="+unescape(encodeURIComponent(drug_name))+"&from_disp="+from_disp,arguments,features); Commented by Sandhya
	// Removed Unescape  to drugname for incident num:24786 on 24/11/2010 By Sandhya ===corrected 25276=16/DEC/2010
	var retVal= await top.window.showModalDialog("../../ePH/jsp/InstructionsFrame.jsp?order_id="+order_id+"&order_line_no="+order_line_no+"&drug_name="+drug_name+"&from_disp="+from_disp,arguments,features);
}

//code for billing interface 
function viewCharges(patient_id,encounter_id,patient_class,qty){	
	var bean_id		= "DispMedicationAllStages" ;
	var bean_name	= "ePH.DispMedicationAllStages";
	var  frmObj		 =	parent.parent.f_stock_dtls.document.DispMedicationStockDetails;
	var item_code    =  frmObj.item_select.options[frmObj.item_select.selectedIndex].text;
	var item_desc   = frmObj.item_select.options[frmObj.item_select.selectedIndex].value;
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name  =\"" + bean_name + "\" " ;
	xmlStr+= "patient_id  =\"" + patient_id + "\" " ;
	xmlStr+= "encounter_id  =\"" + encounter_id + "\" " ;
	xmlStr+= "sal_trn_type  =\"" + patient_class + "\" " ;
	xmlStr+= "item_code  =\"" + item_code + "\" " ;
	xmlStr+= "item_desc  =\"" + item_desc + "\" " ;
	xmlStr+= "qty  =\"" + qty + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=ITEMCHARGE_DTLS";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;				
	eval(responseText);
}

function displayErrorMsg(msg){
	alert(msg);
}

async function showchargedetails(message){
	if(message.length > 0){
		var insind			 =	"";
		var baseqty			 =	"";
		var baserate		 =	"";
		var basechargeamt	 =	"";
		var grosschargeamt	 =	"";
		var discountper		 =	"";
		var discountamt		 =	"";
		var daytypecode		 =	"";
		var daytypedesc		 =	"";
		var timetypecode	 =	"";
		var timetypedesc	 =	"";
		var addlfactor		 =	"";
		var ordercatalogcode =	"";
		var ordercatalogdesc =	"";
		var blngservcode	 =	"";
		var blngservdesc	 =	"";
		var netchargeamt	 =	"";
		var patgrosschargeamt =	"";
		var patdiscamt		 =	"";
		var patnetamt		 =	"";
		var custgrosschargeamt ="";
		var custdiscamt		 =	"";
		var custnewamt		 =	"";
		results = message.split(",");
		for(var i=0;i<23;i++){
			insind			=	results[0];
			baseqty			=	results[1];
			baserate		=	results[2];
			basechargeamt	=	results[3];
			grosschargeamt	=	results[4];
			discountper		=	results[5];
			discountamt		=	results[6];
			daytypecode		=	results[7];
			daytypedesc		=	results[8]; 
			timetypecode	=	results[9];
			timetypedesc	=	results[10];
			addlfactor		=	results[11];
			ordercatalogcode =	results[12];
			ordercatalogdesc =	results[13]; 
			blngservcode	=	results[14];
			blngservdesc	=	results[15];
			netchargeamt	=	results[16];
			patgrosschargeamt =	results[17];
			patdiscamt		=	results[18];
			patnetamt		=	results[19];
			custgrosschargeamt =results[20];
			custdiscamt		=	results[21];
			custnewamt		=	results[22];
		}
		var retVal;
		var dialogHeight= "40vh";
		var dialogWidth	= "50vw";
		var dialogTop = "225";
		var center = "1" ;
		var status="no";					   
		
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;

		var arguments	= "" ;	
		retVal = await window.showModalDialog("../../eBL/jsp/BLBillDetailsMain.jsp?insind"+insind+"&baseqty="+baseqty+"&baserate="+baserate+"&basechargeamt="+"&grosschargeamt="+grosschargeamt+"&discountper="+discountper+"&discountamt="+discountamt+"&daytypecode="+daytypecode+"&daytypedesc="+daytypedesc+"&timetypecode="+timetypecode+"&timetypedesc="+timetypedesc+"&addlfactor="+addlfactor+"&ordercatalogcode="+ordercatalogcode+"&ordercatalogdesc="+ordercatalogdesc+"&blngservcode="+blngservcode+"&blngservdesc="+blngservdesc+"&netchargeamt="+netchargeamt+"&patgrosschargeamt="+patgrosschargeamt+"&patdiscamt="+patdiscamt+"&patnetamt="+patnetamt+"&custgrosschargeamt="+custgrosschargeamt+"&custdiscamt="+custdiscamt+"&custnewamt="+custnewamt,arguments,features);
	}
	//end here		
}


async function callverifyremarks(order_id,order_line_no){

	var dialogHeight	= "50vh" ;
	var dialogWidth		= "35vw";
	var dialogTop		= "10" ;
	var dialogLeft		= "10" ;
	var center			= "1" ;
	var status			="no";
	
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	retVal =await window.showModalDialog("../../ePH/jsp/DispMedicationVerficationRemarks.jsp?&order_id="+order_id+"&order_line_no="+order_line_no,arguments,features);
	
}
function recordverificationremarks(obj,order_id,order_line_no){
	var bean_id		= "DispMedicationBean" ;
	var bean_name	= "ePH.DispMedicationBean";
	var disp_stage_global="s";

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "order_id  =\"" + order_id + "\" " ;
	xmlStr+= "order_line_no  =\"" + order_line_no + "\" " ;
	xmlStr+= "verify_remarks  =\"" + encodeURIComponent(obj.value,'UTF-8') + "\" " ;   //Removed escape before obj.value regarding incident num:24587 on 20/Oct/2010==By Sandhya
	xmlStr +=" /></root>";

	var temp_jsp="DispMedicationValidate.jsp?identity=VERIFY_REMARKS"+"&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;				
	eval(responseText);			
	
}
function setCheckBoxValue(obj1,obj2,obj3,recCount){
	
	if(obj1.value!=null&&obj1.value!=""){
	     obj2.checked=true;
	     obj2.value='Y';
		 if(obj3!=undefined && obj3!=null)
		     obj3.disabled=true;	
		 
         if(eval(document.getElementById("alloc_qty_"+recCount))!=null && eval(document.getElementById("alloc_qty_"+recCount)).value == ""){
			eval("document.DispMedicationAllStages.alloc_qty_"+recCount).disabled=true;
			eval(document.getElementById("alloc_qty_"+recCount)).value="";
			if(eval(document.getElementById("allocateyn_"+recCount))!=undefined)
		       eval(document.getElementById("allocateyn_"+recCount)).value='N';
		}
	}
	else{
         obj2.checked=false;
	     obj2.value='N';
		 if(obj3!=undefined && obj3!=null)
		      obj3.disabled=false;

		if(eval(document.getElementById("alloc_qty_"+recCount))!=null){
			eval("document.DispMedicationAllStages.alloc_qty_"+recCount).disabled=false;
		}
	}
}

function setCheckBoxValueInAllStages(obj1,obj2,obj3,recCount){
	
	if(obj1.value!=null&&obj1.value!=""){
	     obj2.checked=true;
	     obj2.value='Y';
		 if(obj3!=undefined && obj3!=null)
		     obj3.disabled=true;	
		 
         if(eval(document.getElementById("alloc_qty_"+recCount))!=null){
			if(eval(document.getElementById("allocateyn_"+recCount))!=undefined)
		       eval(document.getElementById("allocateyn_"+recCount)).value='Y';
		}
	}
	else{
         obj2.checked=false;
	     obj2.value='N';
		 if(obj3!=undefined && obj3!=null)
		      obj3.disabled=false;
	}
}

async function callIncludeExclude(called_from,recnum,drug_code,qty,batch_str,order_id,order_line_no){

		 var  patient_id			 =  document.DispMedicationAllStages.patient_id.value;
		 var  encounter_id			 =  document.DispMedicationAllStages.bl_encounter_id.value;
		 var  sal_trn_type			 =  document.DispMedicationAllStages.bl_patient_class.value;
		 var  sysdate				 =  document.DispMedicationAllStages.bl_sysdate.value;
		 var  store_code			 =  document.DispMedicationAllStages.disp_locn_code.value;	
		 var tot_gross_charge_amount =  document.DispMedicationAllStages.tot_gross_charge_amount.value;
		 var tot_groos_pat_payable   =  document.DispMedicationAllStages.tot_groos_pat_payable.value;
		
		  if(called_from!='V'){
			   var modDrugCode	    =   encryptDrugCode(drug_code);
				recnum	            =	order_id+order_line_no+modDrugCode;
		  }
		  
		  
		  var override_allowed_yn				 = eval("document.DispMedicationAllStages.override_allowed_yn_"+recnum).value;
		  var excl_incl_ind						 = eval("document.DispMedicationAllStages.excl_incl_ind_"+recnum).value;
		  var approval_reqd_yn					 = eval("document.DispMedicationAllStages.approval_reqd_yn_"+recnum).value;
		  var bl_incl_excl_override_reason_desc  = eval("document.DispMedicationAllStages.bl_incl_excl_override_reason_desc_"+recnum).value;
		  var bl_incl_excl_override_reason_code  = eval("document.DispMedicationAllStages.bl_incl_excl_override_reason_code_"+recnum).value;
		  var excl_incl_ind_default			     = eval("document.DispMedicationAllStages.excl_incl_ind_default_"+recnum).value;
          var old_gross_charge_amount            = eval("document.DispMedicationAllStages.gross_charge_amount_"+recnum).value;
		  var old_groos_pat_payable              = eval("document.DispMedicationAllStages.groos_pat_payable_"+recnum).value;


		  var dialogHeight	= "30vh" ;
		  var dialogWidth	= "50vw";
		  var dialogTop	    = "10" ;
		  var dialogLeft	= "10" ;
		  var center		= "0" ;
		  var status		= "no";
		  var scroll		= "no";
		  var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+ ";scroll "+scroll;
		  var arguments	    = "";
			retVal          =await top.window.showModalDialog("../../ePH/jsp/BillingIncludeExclude.jsp?override_allowed_yn="+override_allowed_yn+"&excl_incl_ind="+excl_incl_ind+"&approval_reqd_yn="+approval_reqd_yn+"&bl_incl_excl_override_reason_desc="+encodeURIComponent(bl_incl_excl_override_reason_desc)+"&bl_incl_excl_override_reason_code="+bl_incl_excl_override_reason_code+"&recnum="+recnum+"&excl_incl_ind_default="+excl_incl_ind_default+"&order_id="+order_id+"&order_line_no="+order_line_no+"&fromDisp=Y" ,arguments,features);


		/*if(retVal!=undefined && retVal!="") {
			   var billing_vals						 =	 retVal.split("::");
               var excl_incl_ind					 =   billing_vals[1];
			   var bl_incl_excl_override_reason_code =   billing_vals[2];
			   var bl_incl_excl_override_reason_desc =   billing_vals[3];
alert("==excl_incl_ind===="+excl_incl_ind+"==bl_incl_excl_override_reason_code===="+bl_incl_excl_override_reason_code+"=bl_incl_excl_override_reason_desc===="+bl_incl_excl_override_reason_desc);
                if(excl_incl_ind=='SEL')
					excl_incl_ind="";
alert("==excl_incl_ind===="+excl_incl_ind);

                eval("document.DispMedicationAllStages.excl_incl_ind_"+recnum).value	        		 = excl_incl_ind;
	            eval("document.DispMedicationAllStages.bl_incl_excl_override_reason_code_"+recnum).value = bl_incl_excl_override_reason_code;
				eval("document.DispMedicationAllStages.bl_incl_excl_override_reason_desc_"+recnum).value = bl_incl_excl_override_reason_desc;
               
               if(excl_incl_ind!=''){
					 var xmlStr ="<root><SEARCH ";	
					 
						//xmlStr+= "bean_id=\"" + document.DispMedicationAllStages.bean_id.value + "\" " ;
						//xmlStr+= "bean_name=\"" + document.DispMedicationAllStages.bean_name.value + "\" " ;	
                         if(called_from=='AS'){
							xmlStr+= "all_stages_bean_id=\"" + document.DispMedicationAllStages.bean_id.value + "\" " ;
						    xmlStr+= "all_stages_bean_name=\"" + document.DispMedicationAllStages.bean_name.value + "\" " ;
						 }else{
						    xmlStr+= "all_stages_bean_id=\"" + document.DispMedicationAllStages.bean_id_1.value + "\" " ;
						    xmlStr+= "all_stages_bean_name=\"" + document.DispMedicationAllStages.bean_name_1.value + "\" " ;	
						 }

						xmlStr+= "order_id=\"" + order_id + "\" " ;
						xmlStr+= "order_line_no=\"" + order_line_no + "\" " ;
						xmlStr+= "Srl_no=\"" + recnum + "\" " ;	
						xmlStr+= "drug_code=\"" + drug_code + "\" " ;	
						xmlStr+= "excl_incl_ind=\"" + excl_incl_ind + "\" " ;	
						xmlStr+= "bl_incl_excl_override_reason_code=\"" + bl_incl_excl_override_reason_code + "\" " ;	
						xmlStr+= "bl_incl_excl_override_reason_desc=\"" + encodeURIComponent(bl_incl_excl_override_reason_desc) + "\" " ;
						xmlStr+= "tot_alloc_qty=\"" + qty + "\" " ;
						xmlStr+= "patient_id=\"" + patient_id + "\" " ;
						xmlStr+= "encounter_id=\"" + encounter_id + "\" " ;
						xmlStr+= "sal_trn_type=\"" + sal_trn_type + "\" " ;
						xmlStr+= "sysdate=\"" + sysdate + "\" " ;
						xmlStr+= "store_code=\"" + store_code + "\" " ;
						xmlStr+= "batch_str=\"" + batch_str + "\" " ;
						xmlStr+= "tot_gross_charge_amount=\"" + tot_gross_charge_amount + "\" " ;
						xmlStr+= "tot_groos_pat_payable=\""   + tot_groos_pat_payable + "\" " ;
						xmlStr+= "old_gross_charge_amount=\"" + old_gross_charge_amount + "\" " ;
						xmlStr+= "old_groos_pat_payable=\""   + old_groos_pat_payable + "\" " ;
						xmlStr+= "called_from=\"" + called_from +"\" ";
						xmlStr +=" /></root>";	
						
                          var bean_id  = document.DispMedicationAllStages.bean_id.value;
						  var bean_name= document.DispMedicationAllStages.bean_name.value;
						 if(called_from=='AS'){
                             bean_id  = document.DispMedicationAllStages.bean_id_1.value;
							 bean_name= document.DispMedicationAllStages.bean_name_1.value;


						 }
						var temp_jsp="DispMedicationValidate.jsp?identity=StoreBillingDetails"+"&bean_id="+bean_id+"&bean_name="+bean_name;


						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST",temp_jsp,false);
						xmlHttp.send(xmlDoc);
						responseText=xmlHttp.responseText ;
						eval(responseText);
			   }
		}*/
}
function SetBmsQuantity(qty,recCount,act_bms_qty){
	var bms_qty=parseInt(act_bms_qty) ;
	if(qty != "" )
		bms_qty= parseInt(act_bms_qty)-parseInt(qty);
	if(parseInt(bms_qty)<0){
		bms_qty =0;
	}
	eval("document.DispMedicationAllStages.alloc_qty_"+recCount).value=parseInt(qty);
	eval("document.DispMedicationAllStages.bms_qty"+recCount).value=bms_qty;
	eval(document.getElementById("bms_qty_"+recCount)).innerHTML=""+bms_qty+"";
}

function getBillingDetails(flag,order_id,order_line_no,drug_code,qty,batch_str,recCount,act_bms_qty){
   // if(flag='Y'){
	var called_from					=  document.DispMedicationAllStages.disp_stage.value	
	var  patient_id					=  document.DispMedicationAllStages.patient_id.value;
	var  encounter_id					=  document.DispMedicationAllStages.bl_encounter_id.value;
	var  sal_trn_type					=  document.DispMedicationAllStages.bl_patient_class.value;
	var  sysdate						=  document.DispMedicationAllStages.bl_sysdate.value;
	var  store_code					=  document.DispMedicationAllStages.disp_locn_code.value;			 
	var tot_gross_charge_amount		=  document.DispMedicationAllStages.tot_gross_charge_amount.value;
	var tot_groos_pat_payable			=  document.DispMedicationAllStages.tot_groos_pat_payable.value;
	var displayGrossAmtYn               =  "";// Added for ML-BRU-CRF-0469 - Start
	var old_gross_amount                = "";
	if(document.DispMedicationAllStages.displayGrossAmtYn!=undefined){
		displayGrossAmtYn = document.DispMedicationAllStages.displayGrossAmtYn.value;
	}
	
	var tot_gross_amount               = "";
	if(displayGrossAmtYn==true || displayGrossAmtYn=="true"){
	     tot_gross_amount		        =  document.DispMedicationAllStages.tot_gross_amount.value;
	 if(tot_gross_amount==""){
		 tot_gross_amount = 0.00;
	 }
	}  // Added for ML-BRU-CRF-0469 - End
	var dischargeIND                 	=  eval("document.DispMedicationAllStages.dischargeIND"+recCount).value; 
	var issueuomarray 					=  eval("document.DispMedicationAllStages.issue_uom_select_"+recCount).value.split("_");// Added for AAKH-SCF-0103 [IN:047628]
	var iss_qty_eq_val 					=  issueuomarray[1];// Added for AAKH-SCF-0103 [IN:047628]
	var IssueByUOM						= document.DispMedicationAllStages.IssueByUOM.value;//  Added for [IN:051908] Linked with AAKH-SCF-0103 [IN:047628]
	var base_to_disp_uom_equl_val		=  eval("document.DispMedicationAllStages.base_to_disp_uom_equl_val"+recCount).value; // Added for AAKH-SCF-0103 [IN:047628]
	var modDrugCode					=  encryptDrugCode(drug_code);
	var recnum						    =  order_id+order_line_no+modDrugCode;
	 if(eval("document.DispMedicationAllStages.excl_incl_ind_"+recnum)!=undefined){
		 var excl_incl_ind					= "";
		 if(eval("document.DispMedicationAllStages.excl_incl_ind_"+recnum).value != '')
			 excl_incl_ind = eval("document.DispMedicationAllStages.excl_incl_ind_"+recnum).value;		 
		 var old_gross_charge_amount        =  eval("document.DispMedicationAllStages.gross_charge_amount_"+recnum).value;
		 var old_groos_pat_payable          =  eval("document.DispMedicationAllStages.groos_pat_payable_"+recnum).value;
		 if(displayGrossAmtYn==true || displayGrossAmtYn=="true"){  // Added for ML-BRU-CRF-0469 - Start
		   old_gross_amount               =  eval("document.DispMedicationAllStages.gross_amount_"+recnum).value;
		 } // Added for ML-BRU-CRF-0469 - End
		 var bl_incl_excl_override_reason_code =  eval("document.DispMedicationAllStages.bl_incl_excl_override_reason_code_"+recnum).value ;
		 var bl_incl_excl_override_reason_desc =  eval("document.DispMedicationAllStages.bl_incl_excl_override_reason_desc_"+recnum).value ;	
	 }
	 else{
		var old_gross_charge_amount         = 0;
		var old_groos_pat_payable           = 0;
		var old_gross_amount                = 0;//added for ML-BRU-CRF-0469
		var excl_incl_ind				    = "";
	 }       

	 if(bl_incl_excl_override_reason_code == undefined)
		 bl_incl_excl_override_reason_code = '';

	 if(bl_incl_excl_override_reason_desc == undefined)
		 bl_incl_excl_override_reason_desc = '';

	if(old_gross_charge_amount=='')
			old_gross_charge_amount ='0.0';
	 if(old_groos_pat_payable=='')
			old_groos_pat_payable ='0.0';
	 //added for ML-BRU-CRF-0469 strt
	 if(displayGrossAmtYn==true || displayGrossAmtYn=="true"){
	 if(old_gross_amount=='')
		 old_gross_amount ='0.0';   
	 }
	 //added for ML-BRU-CRF-0469 end
	 // Uncommented for JD-CRF-0179 [IN:41211] start
	/* var bms_qty = parseInt(act_bms_qty)-parseInt(qty);
	 if(parseInt(bms_qty)<0 || (IssueByUOM=='I' && parseInt(iss_qty_eq_val)!=parseInt(base_to_disp_uom_equl_val))){//IssueByUOM=='I' && parseInt(iss_qty_eq_val)!=parseInt(base_to_disp_uom_equl_val) Added for AAKH-SCF-0103 [IN:047628]
		bms_qty =0;
	 }
	 eval("document.DispMedicationAllStages.bms_qty"+recCount).value=bms_qty;
	 eval("document.getElementById("bms_qty_")"+recCount).innerHTML=""+bms_qty+""; commented for ML-BRU-SCF-1433 [IN:051291] */  //Uncommented for JD-CRF-0179 [IN:41211] end     

	var xmlStr ="<root><SEARCH ";		 
	if(called_from=='AS'){
		xmlStr+= "all_stages_bean_id=\"" + document.DispMedicationAllStages.bean_id.value + "\" " ;
		xmlStr+= "all_stages_bean_name=\"" + document.DispMedicationAllStages.bean_name.value + "\" " ;
	}
	else{
		xmlStr+= "all_stages_bean_id=\"" + document.DispMedicationAllStages.bean_id_1.value + "\" " ;
		xmlStr+= "all_stages_bean_name=\"" + document.DispMedicationAllStages.bean_name_1.value + "\" " ;	
	}

	xmlStr+= "order_id=\"" + order_id + "\" " ;
	xmlStr+= "order_line_no=\"" + order_line_no + "\" " ;
	xmlStr+= "Srl_no=\"" + recnum + "\" " ;	
	xmlStr+= "drug_code=\"" + drug_code + "\" " ;	
	xmlStr+= "excl_incl_ind=\"" + excl_incl_ind + "\" " ;	
	xmlStr+= "bl_incl_excl_override_reason_code=\"" + bl_incl_excl_override_reason_code + "\" " ;	
	xmlStr+= "bl_incl_excl_override_reason_desc=\"" + encodeURIComponent(bl_incl_excl_override_reason_desc) + "\" " ;
	xmlStr+= "tot_alloc_qty=\"" + qty + "\" " ;
	xmlStr+= "patient_id=\"" + patient_id + "\" " ;
	xmlStr+= "encounter_id=\"" + encounter_id + "\" " ;
	xmlStr+= "sal_trn_type=\"" + sal_trn_type + "\" " ;
	xmlStr+= "sysdate=\"" + sysdate + "\" " ;
	xmlStr+= "store_code=\"" + store_code + "\" " ;
	xmlStr+= "batch_str=\"" + batch_str + "\" " ;
	xmlStr+= "tot_gross_charge_amount=\"" + tot_gross_charge_amount + "\" " ;
	xmlStr+= "tot_groos_pat_payable=\""   + tot_groos_pat_payable + "\" " ;
	xmlStr+= "tot_gross_amount=\"" + tot_gross_amount + "\" " ;//added for ML-BRU-CRF-0469
	xmlStr+= "old_gross_charge_amount=\"" + old_gross_charge_amount + "\" " ;
	xmlStr+= "old_groos_pat_payable=\""   + old_groos_pat_payable + "\" " ;
	xmlStr+= "old_gross_amount=\"" + old_gross_amount + "\" " ;//added for ML-BRU-CRF-0469
	xmlStr+= "called_from=\"" + called_from +"\" ";
	xmlStr+= "dischargeIND=\"" + dischargeIND +"\" ";
	xmlStr +=" /></root>";	
	var bean_id  = document.DispMedicationAllStages.bean_id.value;
	var bean_name= document.DispMedicationAllStages.bean_name.value;
	if(called_from=='AS'){
		 bean_id  = document.DispMedicationAllStages.bean_id_1.value;
		 bean_name= document.DispMedicationAllStages.bean_name_1.value;
	 }
	var temp_jsp="DispMedicationValidate.jsp?identity=StoreBillingDetails"+"&bean_id="+bean_id+"&bean_name="+bean_name+"&dischargeIND="+dischargeIND;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);

	/*}else{           
		   alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH"));

	}*/
}
// added for ML-BRU-CRF-0469 ,gross_amount,tot_gross_amount
function setBillingAmounts(srl_no,gross_charge_amount,groos_pat_payable,tot_gross_charge_amount,tot_groos_pat_payable,gross_amount,tot_gross_amount){
	var drug_color = "";
	try{
		eval(document.getElementById("drug_color_"+srl_no)).value;
	}
	catch(e){}

	if(eval(document.getElementById("gross_charge_amount_"+srl_no))!=undefined){
		eval(document.getElementById("gross_charge_amount_"+srl_no)).value=gross_charge_amount;
		eval(document.getElementById("groos_pat_payable_"+srl_no)).value=groos_pat_payable;
		if(eval(document.getElementById("gross_amount_"+srl_no))!=undefined){
			eval(document.getElementById("gross_amount_"+srl_no)).value=gross_amount;//adde for ML-BRU-CRF0469
		}
		document.DispMedicationAllStages.tot_gross_charge_amount.value	=	tot_gross_charge_amount;
		document.DispMedicationAllStages.tot_groos_pat_payable.value	=	tot_groos_pat_payable;
		if(document.DispMedicationAllStages.tot_gross_amount!=undefined)
		document.DispMedicationAllStages.tot_gross_amount.value	        =	tot_gross_amount;//adde for ML-BRU-CRF0469
		
		eval(document.getElementById("gross_charge_amount_str_"+srl_no)).innerHTML	="<center><label style='font-size:9;color:"+drug_color+"'>"+gross_charge_amount+"</label></center>";
		eval(document.getElementById("groos_pat_payable_str_"+srl_no)).innerHTML	="<center><label style='font-size:9;color:"+drug_color+"'>"+groos_pat_payable+"</label></center>";
		if(eval(document.getElementById("gross_amount_str_"+srl_no))!=undefined){
			eval(document.getElementById("gross_amount_str_"+srl_no)).innerHTML	="<center><label style='font-size:9;color:"+drug_color+"'>"+gross_amount+"</label></center>";//adde for ML-BRU-CRF-0469
		}
	}
	var total_payable   = getLabel("ePH.TotalChargeAmount.label","PH");
	var patient_payable = getLabel("ePH.TotalPayableAmount.label","PH");
	var total_gross_amount   = getLabel("ePH.TotalGrossAmount.label","PH");//added  for ML-BRU-CRF-0469
 if(parent.f_disp_medication_all_stages_legends.document.getElementById("total_gross_amount")!=undefined){
	parent.f_disp_medication_all_stages_legends.document.getElementById("total_gross_amount").innerHTML	="<label >"+total_gross_amount+"      : "+tot_gross_amount+"</label>";//added  for ML-BRU-CRF-0469
 } //added  for ML-BRU-CRF-0469 - End
	parent.f_disp_medication_all_stages_legends.document.getElementById("total_payable").innerHTML	="<label >"+total_payable+"      : "+tot_gross_charge_amount+"</label>";
	parent.f_disp_medication_all_stages_legends.document.getElementById("patient_payable").innerHTML	="<label >"+patient_payable+"       : "+tot_groos_pat_payable+"</label>";
	parent.f_disp_medication_all_stages_legends.document.getElementById("tot_groos_pat_payable").value = tot_groos_pat_payable;//added for MMS-QH-CRF-0201 [IN:052255]
}

async function showImage(drug_code, trade_code){
	var dialogHeight= "30vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "111" ;
	var center = "1" ;
	var status="no";
	if(drug_code == undefined)
		drug_code="";
	if(trade_code == undefined)
		trade_code="";

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/DrugTradeImage.jsp?drug_code="+drug_code+"&trade_code="+trade_code,arguments,features);
}

function setbatchdetails(obj,store_code,base_uom,end_date,item_code,trade_code,patient_id,order_id,order_line_no,uom,billing_interface_yn,drug_code,act_bms_qty,qty,recCount,updateStock,barcode_color,approval_no){ //base_uom, added for SKR-SCF-0377 [IN:030453] // barcode_color Added for MMS-DM-SCF-0488 and added approval_no for AAKH-CRF-0117
	var formObj	= document.DispMedicationAllStages;
	if(formObj.patient_class!=undefined && formObj.patient_class.value!=null)//Addign start for ML-BRU-CRF-0473
	   var patient_class =formObj.patient_class.value;
	else
       var patient_class="";//Adding end for ML-BRU-CRF-0473
	var alloc_qty	=obj.value;
	var temp_act_bms_qty =act_bms_qty;//Added for MMS-DM-SCF-0567
    if(alloc_qty==undefined)
		alloc_qty = eval("formObj.alloc_qty_"+recCount).value;
	if(alloc_qty==""){
		alloc_qty="0";
	}
	if(qty==""){
		qty="0";
	}
	/*if(alloc_qty=="0" && formObj.IssueByUOM.value=="I"){ //Added for  MMS-SCF-0040 [IN:041888], AAKH-SCF-0113 [IN:048937] - change Issue UOM //commented for ML-BRU-SCF-1617 [IN:055655]
		alloc_qty = qty;
		obj.value = alloc_qty;
	}*/
	var iss_qty_eq_val				= eval("formObj.issue_uom_equl"+recCount).value;				
	var base_to_disp_uom_equl_val	= eval("formObj.base_to_disp_uom_equl_val"+recCount).value; 
	var base_to_def_uom_equl_val    = eval("formObj.base_to_def_uom_equl_val"+recCount).value; 
	var allow_decimals_yn    = eval("formObj.allow_decimals_yn"+recCount).value; 	// Added for AAKH-SCF-0113[IN:048937]
	var disp_decimal_dtls_yn    = formObj.disp_decimal_dtls_yn.value; 	// Added for AAKH-SCF-0113[IN:048937]
	var issue_uom_select				= eval("formObj.issue_uom_select_"+recCount).value;//Added for  ML-BRU-SCF-1433 [IN:051291]		//Added for  ML-BRU-SCF-1433 [IN:051291] 
	var issueuomarray = issue_uom_select.split("_");//Added for  ML-BRU-SCF-1433 [IN:051291] 
	var iss_quantity_uom    = issueuomarray[0];//Added for  ML-BRU-SCF-1433 [IN:051291] 
	if(formObj.IssueByUOM.value=="I"){// && base_to_disp_uom_equl_val == base_to_def_uom_equl_val)//if else Added for AAKH-SCF-0103 [IN:047628] //&& base_to_disp_uom_equl_val == base_to_def_uom_equl_val Added for AAKH-SCF-0113[IN:048937]
		
		var issue_to_disp_issue_qty_eq_val = iss_qty_eq_val; // Added for ICN-8611 - Start
		
		if(base_to_def_uom_equl_val!=base_to_disp_uom_equl_val){
		   issue_to_disp_issue_qty_eq_val = lcm(base_to_def_uom_equl_val, iss_qty_eq_val); 
		} // Added for ICN-8611 - End
		
		var conv_factor = CalculateConversionfactor(issue_to_disp_issue_qty_eq_val,iss_qty_eq_val,base_to_disp_uom_equl_val); // iss_qty_eq_val changed to issue_to_disp_issue_qty_eq_val changed for ICN-8611
	}
	else//commented for 55174 //removed for ML-BRU-SCF-1433 [IN:051291] 
		var conv_factor = CalculateConversionfactor(base_to_def_uom_equl_val,iss_qty_eq_val,base_to_disp_uom_equl_val);
	if(parseInt(alloc_qty) !=0){ // moved from down AAKH-SCF-0113 [IN:048937]
		setQtyBsdOnIssueUOMinFrontScreen(obj,recCount,conv_factor);	//Moved from down for update back billing details when qty auto reverted for AAKH-SCF-0113 [IN:048937]
		alloc_qty   =obj.value;
		if(alloc_qty==undefined)
			alloc_qty = eval("formObj.alloc_qty_"+recCount).value;
	} //moved down for to revert the display of qty interms of issue UOM when chaning issue UOM failed*/ //moved from down for  AAKH-SCF-0113 [IN:048937] -end
	var alloc_equl       =  Math.ceil(parseInt(alloc_qty*base_to_disp_uom_equl_val)/parseInt(conv_factor));
	var act_bms_qty_equl =  Math.ceil(parseInt(act_bms_qty*base_to_disp_uom_equl_val)/parseInt(conv_factor));
	if(uom!=base_uom && parseInt(alloc_qty)>0){  //if block added for SKR-SCF-0377 [IN:030453]	// Uncommented, && parseInt(alloc_qty)>0 added for JD-CRF-0179 [IN:41211]
		/*if(formObj.IssueByUOM.value=="I"){//if block added for MMS-SCF-0040 [IN:041888], AAKH-SCF-0113 [IN:048937] - change Issue UOM
			alloc_qty=alloc_qty*iss_qty_eq_val;
			act_bms_qty=act_bms_qty*iss_qty_eq_val;
		}
		else{*/ //Commented  for IN055174
			alloc_qty=alloc_qty*base_to_disp_uom_equl_val;
			act_bms_qty=act_bms_qty*base_to_disp_uom_equl_val;
		//}
	}//JD-CRF-0179 [IN:41211] end
	//Added for Dispense more qty than ordered or BMS qty-----
	var allowMoreQty = false;
	var showMoreQtyMsg = false;
	if(eval("formObj.AllowMoreThanPresQty"+recCount).value =='Y'){
		if (parseInt(alloc_qty) > parseInt(act_bms_qty) && (parseInt(alloc_equl) > parseInt(act_bms_qty_equl)) && barcode_color!="Y"){ // && barcode_color!="Y" Added for GHL-SCF-1293
			if(eval("formObj.pres_qty_alert").value != 'N'){//code added for AMS-CRF-0035[IN033551]				
				if(confirm(getMessage("ALLOC_QTY_GRT_PRES_QTY","PH"))){ 
					allowMoreQty = true; 	
					if(!(allow_decimals_yn =='Y' && disp_decimal_dtls_yn=='Y')){// if Added for AAKH-SCF-0113[IN:048937]
						if(parseInt(base_to_def_uom_equl_val)!=0 &&parseInt(base_to_disp_uom_equl_val)!=0){ // Commented for AAKH-SCF-0103 [IN:047628] // Uncommented for AAKH-SCF-0113[IN:048937]
							if(base_to_def_uom_equl_val!=base_to_disp_uom_equl_val){
								if(((alloc_qty*base_to_disp_uom_equl_val)%conv_factor) != '0' )
									alert(getMessage("PH_ISSUE_UOM_MUL","PH")+(conv_factor/base_to_disp_uom_equl_val));
								alloc_qty  = Math.ceil(((Math.ceil((alloc_qty*base_to_disp_uom_equl_val)/conv_factor))*(conv_factor))/base_to_disp_uom_equl_val);
								obj.value  = alloc_qty;	
							}
						}
					}
				}
				else{	
					showMoreQtyMsg = false;	
					allowMoreQty   = true;
					obj.value  = qty;	
					alloc_qty  = qty;						
					obj.focus();
				}
			}
			else{// else block added for IN045021
				allowMoreQty = true;		
			}
		}
		else{// Commented for AAKH-SCF-0103 [IN:047628] // Uncommented for AAKH-SCF-0113[IN:048937]
			if(!(allow_decimals_yn =='Y' && disp_decimal_dtls_yn=='Y')){//if Added for AAKH-SCF-0113[IN:048937]
				if(parseInt(base_to_def_uom_equl_val)!=0 &&parseInt(base_to_disp_uom_equl_val)!=0 ){
					if(base_to_def_uom_equl_val!=base_to_disp_uom_equl_val && ((alloc_qty*base_to_disp_uom_equl_val)%conv_factor) != '0' ){
						alert(getMessage("PH_ISSUE_UOM_MUL","PH")+(conv_factor/base_to_disp_uom_equl_val));
						alloc_qty  = Math.ceil(((Math.ceil((alloc_qty*base_to_disp_uom_equl_val)/conv_factor))*(conv_factor))/base_to_disp_uom_equl_val);
						obj.value  = alloc_qty;	
					}
				}
			}
		}
	}
	else{
		if (parseInt(alloc_qty) > parseInt(act_bms_qty) &&  (parseInt(alloc_equl) > parseInt(act_bms_qty_equl))){
			showMoreQtyMsg = true;
		}
		if(parseInt(base_to_def_uom_equl_val)!=0 &&parseInt(base_to_disp_uom_equl_val)!=0 ){//added for 55174 Start
			if(base_to_def_uom_equl_val!=base_to_disp_uom_equl_val && ((alloc_qty*base_to_disp_uom_equl_val)%conv_factor) != '0' ){
				alert(getMessage("PH_ISSUE_UOM_MUL","PH")+(conv_factor/base_to_disp_uom_equl_val));
				alloc_qty  = Math.ceil(((Math.ceil((alloc_qty*base_to_disp_uom_equl_val)/conv_factor))*(conv_factor))/base_to_disp_uom_equl_val);
				obj.value  = alloc_qty;	
			}
		}//added for 55174 End
	
	}
	var alloc_fromBarCode = formObj.alloc_fromBarCode.value;
	if(formObj.barcode_scan_yn!=undefined && formObj.barcode_scan_yn.value=="Y"){ // if condition Added for MMS-DM-SCF-0488 - Start
		if(barcode_color!="Y"){ 
			obj.style.backgroundColor = "";
			barcode_color ="N";
		}
	} // if condition Added for MMS-DM-SCF-0488 - End
	if(alloc_qty!=0 &&  alloc_fromBarCode =='Y' && formObj.barcode_scan_yn.value=="Y"){ 
	  if(barcode_color!="Y"){ // if condition Added for MMS-DM-SCF-0488
		obj.style.backgroundColor = ""; //added for GHL-CRF-0413.1 [IN:061794]
		barcode_color ="N"; // Added for MMS-DM-SCF-0488
	  }
		 //alert(getMessage("PH_DEFAULTBATCH_ALLOCATE","PH")) // commented for GHL-CRF-0463
			formObj.alloc_fromBarCode.value = 'N';
			alloc_fromBarCode = "N"
	}	
	if(alloc_qty!=0 && (formObj.barcode_scan_yn!=undefined && formObj.barcode_scan_yn.value=="Y") && (eval("formObj.last_scanned_"+recCount) !=undefined && eval("formObj.last_scanned_"+recCount).value=="") && barcode_color!="Y"){  // Added for GHL-CRF-0463 - Start // last_scanned chnaged to eval("formObj.last_scanned_"+recCount).value for MMS-DM-SCF-0488 // barcode_color!="Y" Added for AAKH-SCF-0374		  		
		alert(getMessage("AS_PER_FEFO_DEFAULT_BATCH","PH"))
	} // Added for GHL-CRF-0463 - End
	formObj.alloc_fromBarCode.value = 'N';
	if(alloc_qty==0 && (eval("formObj.last_scanned_"+recCount)!=undefined) && eval("formObj.last_scanned_"+recCount).value!=""){ // Added for GHL-CRF-0463 - Start
		alloc_fromBarCode = "N"
	} // Added for GHL-CRF-0463 - End
//-- For issue qty should be the multiples of def UOM ---- end -----
	if(updateStock == undefined && ((parseInt(alloc_qty) <= parseInt( act_bms_qty)) || (parseInt(alloc_equl)<=parseInt(act_bms_qty_equl)) || allowMoreQty == true) && alloc_fromBarCode!='Y') {
		if(end_date.length>10){
			end_date= end_date.substring(0,10);
		}
		var bean_id	 	= "DispMedicationAllStages" ;
		var bean_name	= "ePH.DispMedicationAllStages";			
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name  =\"" + bean_name + "\" " ;
		xmlStr+= "item_code  =\"" + item_code + "\" " ;
		xmlStr+= "trade_code  =\"" + trade_code + "\" " ;
		xmlStr+= "req_qty  =\"" + alloc_qty + "\" " ;
		xmlStr+= "store_code  =\"" + store_code + "\" " ;
		xmlStr+= "end_date  =\"" + end_date + "\" " ;
		xmlStr+= "patient_id  =\"" + patient_id + "\" " ;
		xmlStr+= "order_id  =\"" + order_id + "\" " ;
		xmlStr+= "order_line_no  =\"" + order_line_no + "\" " ;
		xmlStr+= "uom  =\"" + uom + "\" " ;
		xmlStr+= "billing_interface_yn  =\"" + billing_interface_yn + "\" " ;
		xmlStr+= "drug_code  =\"" + drug_code + "\" " ;	
		xmlStr+= "recCount  =\"" + recCount + "\" " ;	
		xmlStr+= "act_bms_qty  =\"" + act_bms_qty + "\" " ;
		xmlStr+= "iss_quantity_uom  =\"" + iss_quantity_uom + "\" " ;//Added for  ML-BRU-SCF-1433 [IN:051291] 
		xmlStr+= "base_uom  =\"" + base_uom + "\" " ;	// added for SKR-SCF-0377 [IN:030453] -start
		/*if(formObj.IssueByUOM.value=="I") //if block and else condition Added for  MMS-SCF-0040 [IN:041888], AAKH-SCF-0113 [IN:048937] - change Issue UOM
			xmlStr+= "base_to_disp_uom_equl_val  =\"" + iss_qty_eq_val + "\" " ;	
		else*///commented for ML-BRU-SCF-1433 [IN:051291] 
		xmlStr+= "base_to_disp_uom_equl_val  =\"" + base_to_disp_uom_equl_val + "\" " ;	
        xmlStr+= "base_to_def_uom_equl_val  =\"" + base_to_def_uom_equl_val + "\" " ;	//Added for MMS-DM-SCF-0567(sen 3)
		xmlStr+= "conv_factor  =\"" + conv_factor + "\" " ;	//added for SKR-SCF-0377 [IN:030453] -end
		xmlStr+= "barcodeColorYn  =\"" + barcode_color + "\" " ;	//added for MMS-DM-SCF-0488 
		xmlStr +=" /></root>";
		var temp_jsp="DispMedicationValidation.jsp?&alloc_fromBarCode="+alloc_fromBarCode+"&func_mode=STORE_BATCH_DET"; // &alloc_fromBarCode="+alloc_fromBarCode  Added for [IN:064158]
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;	
		eval(responseText);	
	}
	else{
		if(parseInt(alloc_qty)>0  && showMoreQtyMsg ){
			alert(getMessage("PH_ALLOC_QTY_LESS_BMS_QTY","PH"));
			alloc_qty=qty;//added for SKR-SCF-0377 [IN:030453]
			SetBmsQuantity(alloc_qty,recCount,temp_act_bms_qty);//replaced act_bms_qty with temp_act_bms_qty for MMS-DM-SCF-0567
			obj.focus();
		}
	}
	setQtyBsdOnIssueUOMinFrontScreen(obj,recCount,conv_factor,"FROMBATCH");	//Added for to revert the display of qty interms of issue UOM when chaning issue UOM failed
  	if(parseInt(alloc_qty)==0 ){
		includeToBms(obj,recCount,act_bms_qty); // ,act_bms_qty added for KAUH-SCF-0096 [IN:035355]
		includeBMSDefCheck_yn=document.DispMedicationAllStages.includeBMSDefCheck_yn.value;// added for [IN:045055](Bru-HIMS-CRF-281[IN:033166])
		if(eval(document.getElementById("divIncludeZeroQty"+recCount))!= undefined && eval("document.DispMedicationAllStages.IncludeZeroQty").value== 'N'){
			eval("document.DispMedicationAllStages.alloc_bms_chk_"+recCount).checked=false; //added for Bru-HIMS-CRF-281 [IN:033166] -start
			eval("document.DispMedicationAllStages.alloc_bms_chk_"+recCount).value= 'N';
			eval(document.getElementById("divIncludeZeroQty"+recCount)).style.display ="none";
			eval(document.getElementById("divOtherEditLables"+recCount)).style.display ="inline";
			if(eval(document.getElementById("allocateyn_"+recCount))!= undefined){ //if condition added for ML-MMOH-SCF-1634
			  eval(document.getElementById("allocateyn_"+recCount)).value = "N";
			}
		}
		else if(eval(document.getElementById("divIncludeZeroQty"+recCount))!= undefined && eval("document.DispMedicationAllStages.IncludeZeroQty").value== 'Y'){ // Added for [IN:045700]
			if(includeBMSDefCheck_yn=='Y'){
				eval("document.DispMedicationAllStages.alloc_bms_chk_"+recCount).checked=true; 
				eval("document.DispMedicationAllStages.alloc_bms_chk_"+recCount).value= 'Y';
				eval("document.DispMedicationAllStages.ComplteOrderReason"+recCount).value="";
				eval("document.DispMedicationAllStages.ComplteOrderReason"+recCount).disabled = true;  
			}
			else{
				
				eval("document.DispMedicationAllStages.alloc_bms_chk_"+recCount).checked=false; 
				eval("document.DispMedicationAllStages.alloc_bms_chk_"+recCount).value= 'N';
			}
			eval(document.getElementById("divIncludeZeroQty"+recCount)).style.display ="inline";
			eval(document.getElementById("divOtherEditLables"+recCount)).style.display ="none";
		}
		if(patient_class=="IP"){//Adding start for ML-BRU-CRF-0473
			if(eval("document.DispMedicationAllStages.IncludeZeroQtyForIP")!=undefined && eval("document.DispMedicationAllStages.IncludeZeroQtyForIP").value== 'Y'){
                eval("document.DispMedicationAllStages.alloc_bms_chk_"+recCount).value= 'Y';
			}                                          
		}//Adding end for ML-BRU-CRF-0473
	}
	else{
		if(eval(document.getElementById("ComplteOrderReason"+recCount))!=null){
			
			eval(document.getElementById("ComplteOrderReason"+recCount)).disabled=true;
		}
		if(parseInt(alloc_qty) < act_bms_qty && eval("document.DispMedicationAllStages.strAutoCompletePartialDisp").value== 'Y'){//if block added for KAUH-SCF-0096 [IN:035355] // && eval("document.DispMedicationAllStages.strAutoCompletePartialDisp").value== 'Y' Added for JD-CRF-0179 [IN:41211]
			includeToBms(obj,recCount,act_bms_qty); 
			if(parseInt(alloc_qty)>0 && eval(document.getElementById("divIncludeZeroQty"+recCount))!= undefined && !eval("document.DispMedicationAllStages.alloc_bms_chk_"+recCount).checked){
				eval("document.DispMedicationAllStages.alloc_bms_chk_"+recCount).checked=false; //added for Bru-HIMS-CRF-281 [IN:033166] -start
				eval("document.DispMedicationAllStages.alloc_bms_chk_"+recCount).value= 'N';
				eval(document.getElementById("divIncludeZeroQty"+recCount)).style.display ="inline";//Changed inline for JD-CRF-0179 [IN:41211]	
			}
			if(eval(document.getElementById("ComplteOrderReason"+recCount))!=null){
			  eval(document.getElementById("ComplteOrderReason"+recCount)).disabled=false;
			}
			if(eval(document.getElementById("divOtherEditLables"+recCount))!= undefined)//Added for JD-CRF-0179 [IN:41211]
				eval(document.getElementById("divOtherEditLables"+recCount)).style.display ="none";//Added for JD-CRF-0179 [IN:41211]
		}
		else{
			if(eval(document.getElementById("ComplteOrderReason"+recCount))!=null){
				eval(document.getElementById("ComplteOrderReason"+recCount)).value="";
				eval(document.getElementById("CompleteOrder"+recCount)).value="";// Added for ML-MMOH-SCF-0356 [IN:059479]
			}
			if(eval(document.getElementById("divOtherEditLables"+recCount))!= undefined)//Added for JD-CRF-0179 [IN:41211] start
				eval(document.getElementById("divOtherEditLables"+recCount)).style.display ="inline";
			if(eval(document.getElementById("divIncludeZeroQty"+recCount))!= undefined)
				eval(document.getElementById("divIncludeZeroQty"+recCount)).style.display ="none";//Added for JD-CRF-0179 [IN:41211] end
		}
		if(eval(document.getElementById("lblIncludeExclude"+recCount))!=undefined)
			eval(document.getElementById("lblIncludeExclude"+recCount)).style.visibility='visible';
		if(eval(document.getElementById("hold_remarks_"+recCount))!=undefined && (eval(document.getElementById("hold"+recCount)).checked ==false)){
			eval(document.getElementById("hold_remarks_"+recCount)).disabled=true;
			eval(document.getElementById("hold_remarks_"+recCount)).style.color='black';
			eval(document.getElementById("hold_remarks_"+recCount)).style.cursor='';
		}	
		if(eval(document.getElementById("allocateyn_"+recCount))!=null){
		  eval(document.getElementById("allocateyn_"+recCount)).value="Y";
		}

		if(eval(document.getElementById("alloc_status"+recCount))!=null){
		  eval(document.getElementById("alloc_status"+recCount)).value="P";
		}
		if(eval(document.getElementById("fill_status"+recCount))!=null){
		  eval(document.getElementById("fill_status"+recCount)).value="P";
		}
		//setQtyBsdOnIssueUOMinFrontScreen(obj,recCount,conv_factor);	//moved up AAKH-SCF-0113 [IN:048937]

		/* Commented for JD-CRF-0179 [IN:41211]
		if(eval("document.getElementById("divOtherEditLables")"+recCount)!= undefined)
			eval("document.getElementById("divOtherEditLables")"+recCount).style.display ="";
	
		if(eval("document.getElementById("divIncludeZeroQty")"+recCount)!= undefined)
			eval("document.getElementById("divIncludeZeroQty")"+recCount).style.display ="none";*/						
	}	
			//added for AAKH-CRF-0117 - start
		if(formObj.approval_no_flag.value=="true"){
		var approval_no_app_for_patient_class = formObj.approval_no_app_for_patient_class.value;//AAKH-CRF-0117		 
		if(obj.value==0){  
				 if(eval("formObj.approval_no_"+recCount) !=undefined){
					  eval("formObj.approval_no_"+recCount).value="";
				   eval("formObj.approval_no_"+recCount).disabled=true;
				   if(approval_no_app_for_patient_class=="Y") //added for AAKH-CRF-0117
					eval("formObj.imgForWithin_"+recCount).style.visibility="hidden";
						//formObj.imgForWithin.style.visibility="hidden";
				 }		
		}else{ 
			 recnum	            =	order_id+order_line_no+modDrugCode;
				order_id = eval("formObj.order_id_"+recCount).value;
				order_line_no = eval("formObj.order_line_num_"+recCount).value;
				drug_code     = eval("formObj.drug_code_"+recCount).value;
				if(barcode_color!="Y"){ //added for AAKH-CRF-0117
				 approval_no   = eval("formObj.approval_no_"+recCount).value;
				}
				var modDrugCode	    =   encryptDrugCode(drug_code);
			  var cunt = order_id+order_line_no+modDrugCode;
				if(eval(document.getElementById("gross_charge_amount_"+cunt))!=undefined){
				 gross_charge_amount = eval(document.getElementById("gross_charge_amount_"+cunt)).value;
				 groos_pat_payable = eval(document.getElementById("groos_pat_payable_"+cunt)).value;
				 if(gross_charge_amount!=groos_pat_payable){
					if(approval_no==""){
						eval("formObj.approval_no_"+recCount).disabled=false;
						eval("formObj.approval_no_"+recCount).value = formObj.approval_no.value;
					}else{ //AAKH-CRF-0117
					if(barcode_color=="Y"){
					eval("formObj.approval_no_"+recCount).value =approval_no; 
					}
					}
					if(approval_no_app_for_patient_class=="Y"){ //added for AAKH-CRF-0117
						eval("formObj.imgForWithin_"+recCount).style.visibility="visible";
//						formObj.imgForWithin.style.visibility="visible";
					
					}
				 }
			}
		 }
	} //added for AAKH-CRF-0117 - end
}

async function callbatchdetails(patient_id,order_id,order_line_no,drug_code,alt_drug_yn,drug_name){

	var dialogHeight	= "30vh" ;
	var dialogWidth	    = "90vw";
	var dialogTop	    = "10" ;
	var dialogLeft	    = "10" ;
	var center			= "0" ;
	var status			= "no";
	var scroll			= "no";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+ ";scroll "+scroll;
	var arguments	    = "";
	retVal          = await top.window.showModalDialog("../../ePH/jsp/BatchDetails.jsp?order_id="+order_id+"&order_line_no="+order_line_no+"&drug_code="+drug_code+"&alt_drug_yn="+alt_drug_yn+"&patient_id="+patient_id+"&drug_name="+drug_name ,arguments,features);
}

async function CallPreparationChargeDetails(gross_admx_prep_charge,groos_pat_payable_admx_prep_charge,obj3,obj4,disp_stage){

	var dialogHeight	= "40vh" ;
	var dialogWidth	    = "60vw";
	var dialogTop	    = "650" ;
	var dialogLeft	    = "30" ;
	var center			= "0" ;
	var status			= "no";
	var scroll			= "no";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+ ";scroll "+scroll;
	var arguments	    = "";
	retVal          = await window.showModalDialog("../../ePH/jsp/AdmixturePreparationChargeDetails.jsp?gross_admx_prep_charge="+gross_admx_prep_charge+"&groos_pat_payable_admx_prep_charge="+groos_pat_payable_admx_prep_charge+"&MarkupDown="+obj3.value+"&BL_decimal_format_str="+escape(obj4.value)+"&disp_stage="+disp_stage,arguments,features);
	//window.open("../../ePH/jsp/AdmixturePreparationChargeDetails.jsp?gross_admx_prep_charge="+gross_admx_prep_charge+"&groos_pat_payable_admx_prep_charge="+groos_pat_payable_admx_prep_charge+"&MarkupDown="+obj3.value+"&BL_decimal_format_str="+escape(obj4.value)+"&disp_stage="+disp_stage,arguments,features);
	 if(retVal!=undefined) {
		var admix_prep_vals	=	retVal.split("::");
		obj3.value			=   admix_prep_vals[0];
		document.getElementById("gross_admx_prep_charge_legend").innerHTML				=   admix_prep_vals[1];
		document.getElementById("groos_pat_payable_admx_prep_charge_legend").innerHTML	=   admix_prep_vals[2];
		document.getElementById("prep_charges").innerText = getLabel("ePH.PreparationCharges.label","PH")+"("+admix_prep_vals[0]+")";
		Calculatetotalamounts(admix_prep_vals[1],admix_prep_vals[2]);
	 }
}

function Calculatetotalamounts(val1,val2){
   tot_gross_charge_amount       = document.DispMedicationAllStages.tot_gross_charge_amount.value;
   tot_groos_pat_payable         = document.DispMedicationAllStages.tot_groos_pat_payable.value;	
   tot_gross_amount       = document.DispMedicationAllStages.tot_gross_amount.value;// Added for ML-BRU-CRF-0469 [IN:065426]
	var  bl_decimal_format_str   = document.DispMedicationAllStages.bl_decimal_format_str.value;
	var bean_id		= "DispMedicationBean" ;
	var bean_name	= "ePH.DispMedicationBean";		
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "tot_gross_charge_amount  =\"" + tot_gross_charge_amount + "\" " ;
	xmlStr+= "tot_groos_pat_payable  =\"" + tot_groos_pat_payable + "\" " ;
	xmlStr+= "calc_markup_gross_admx_prep_charge  =\"" + val1 + "\" " ;	
	xmlStr+= "calc_markup_groos_pat_payable_admx_prep_charge  =\"" + val2 + "\" " ;	
	xmlStr+= "bl_decimal_format_str  =\"" + encodeURIComponent(bl_decimal_format_str)+ "\" " ;			
	xmlStr+= "tot_gross_charge_amount_payable  =\"" + tot_gross_amount + "\" " ;// Added for ML-BRU-CRF-0469 [IN:065426]
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidate.jsp?identity=GETTOTALAMOUNTS"+"&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;	
	eval(responseText);
}
function displaytotalamounts(tot_gross_charge_amount,tot_groos_pat_payable,tot_gross_amount){  // tot_gross_amount  Added for ML-BRU-CRF-0469 [IN:065426]
	var total_payable   = getLabel("ePH.TotalChargeAmount.label","PH");
	var patient_payable = getLabel("ePH.TotalPayableAmount.label","PH");
	var tot_gross_amount_lbl = getLabel("ePH.TotalGrossAmount.label","PH"); // Added for ML-BRU-CRF-0469 [IN:065426]

    parent.f_disp_medication_all_stages_legends.document.getElementById("total_payable").innerHTML	="<label >"+total_payable+"      : "+tot_gross_charge_amount+"</label>";
    parent.f_disp_medication_all_stages_legends.document.getElementById("patient_payable").innerHTML	="<label >"+patient_payable+"       : "+tot_groos_pat_payable+"</label>";
    parent.f_disp_medication_all_stages_legends.document.getElementById("total_gross_amount").innerHTML	="<label >"+tot_gross_amount_lbl+"       : "+tot_gross_amount+"</label>"; // Added for ML-BRU-CRF-0469 [IN:065426]
}

function calculateAmounts(obj,gross_admx_prep_charge,groos_pat_payable_admx_prep_charge,bl_decimal_format_Str){
    
		var bean_id		= "DispMedicationBean" ;
	    var bean_name	= "ePH.DispMedicationBean";		
		
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "mark_up_down  =\"" + obj.value + "\" " ;
		xmlStr+= "gross_admx_prep_charge  =\"" + gross_admx_prep_charge + "\" " ;
		xmlStr+= "groos_pat_payable_admx_prep_charge  =\"" + groos_pat_payable_admx_prep_charge + "\" " ;	
		xmlStr+= "bl_decimal_format_Str  =\"" + bl_decimal_format_Str.value + "\" " ;	
		xmlStr +=" /></root>";
		var temp_jsp="DispMedicationValidate.jsp?identity=getCalculatedamounts"+"&bean_id="+bean_id+"&bean_name="+bean_name;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;	
		eval(responseText);		
}


function DisplayAmounts(cal_gross_admx_prep_charge,cal_groos_pat_payable_admx_prep_charge){
    document.getElementById("markup_gross_admx_prep_charge").innerHTML								= "<b>"+ cal_gross_admx_prep_charge +"</b>";
	document.getElementById("markup_groos_pat_payable_admx_prep_charge").innerHTML					= "<b>"+ cal_groos_pat_payable_admx_prep_charge +"</b>";
    document.admixturepreparationchargesform.calc_markup_gross_admx_prep_charge.value	= cal_gross_admx_prep_charge;
	document.admixturepreparationchargesform.calc_markup_groos_pat_payable_admx_prep_charge.value = cal_groos_pat_payable_admx_prep_charge;

}
function formclose(){
	window.returnValue= document.admixturepreparationchargesform.mark_up_down.value+"::"+document.admixturepreparationchargesform.calc_markup_gross_admx_prep_charge.value+"::"+document.admixturepreparationchargesform.calc_markup_groos_pat_payable_admx_prep_charge.value;
	window.close();
}

async function callMedicalItemdetails(patient_id,encounter_id,disp_stage,billing_interface_yn,disp_locn_code,bl_patient_class,orderIDS_trxRefIDS,sysdate,store_desc){
	var dialogHeight	= "90vh" ;
	var dialogWidth	    = "90vw";
	var dialogTop	    = "10" ;
	var dialogLeft	    = "10" ;
	var center			= "0" ;
	var status			= "no";
	var scroll			= "no";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+ ";scroll "+scroll;
	var arguments	    = "";
	//window.open("../../ePH/jsp/DispensingConsumables.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&disp_stage="+disp_stage+"&billing_interface_yn="+billing_interface_yn+"&disp_locn_code="+disp_locn_code+"&bl_patient_class="+bl_patient_class+"&orderIDS_trxRefIDS="+orderIDS_trxRefIDS+"&sysdate="+sysdate+"&store_desc="+unescape(encodeURIComponent(store_desc)) ,arguments,features);
	//alert("patient_id="+patient_id+"encounter_id="+encounter_id+"disp_stage="+disp_stage+"billing_interface_yn="+billing_interface_yn+"disp_locn_code="+disp_locn_code+"bl_patient_class="+bl_patient_class+"orderIDS_trxRefIDS="+orderIDS_trxRefIDS+"sysdate="+sysdate+"store_desc="+unescape(encodeURIComponent(store_desc)));
	retVal          = await top.window.showModalDialog("../../ePH/jsp/DispensingConsumables.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&disp_stage="+disp_stage+"&billing_interface_yn="+billing_interface_yn+"&disp_locn_code="+disp_locn_code+"&bl_patient_class="+bl_patient_class+"&orderIDS_trxRefIDS="+orderIDS_trxRefIDS+"&sysdate="+sysdate+"&store_desc="+encodeURIComponent(store_desc,"UTF-8") ,arguments,features);
}
async function showDrug(drug_code){
	var dialogHeight= "50vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "11" ;
	var center = "1" ;
	var status="no";
	if(drug_code == undefined)
		drug_code="";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;

	var retVal = await top.window.showModalDialog("../../ePH/jsp/ViewDrugInfo.jsp?DrugCode="+drug_code,arguments,features);
}

function validmaxlength(obj){
	var 	field_label = getLabel("ePH.PatientEducation.label","PH");
	if(!SPCheckMaxLen(field_label,obj,150)){
		obj.select();
		obj.focus();
	}
}

function showDrugMasterValues(obj){
	loadPage(obj);
}

async function loadPage(obj){
	var dialogHeight= "90vh" ;
	var dialogWidth	= "90vw" ;
	var status = "no" ;
	var drug_code = obj;
	var title = getLabel("ePH.DrugDetail.label", "Common");
	var dialogUrl		= "../../ePH/jsp/DrugDetailFrames.jsp?drug_code="+drug_code+"&title="+title;
	var dialogFeatures	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	await top.window.showModalDialog(dialogUrl,"",dialogFeatures);	
}

function lcm(frm_tmp, to_tmp) {
	var lowest = frm_tmp < to_tmp ? frm_tmp : to_tmp;
	var hcd = 1;
	for (var i = lowest; i > 1; i--) {
		if (frm_tmp % i == 0 && to_tmp % i == 0) {
			hcd = i;
			break;
		}
	}
	var lcm = (frm_tmp * to_tmp) / hcd;
	return lcm;
}

function issueUOM(obj,qty){
	var formObj						= parent.f_drug_entry.DispMedicationAllocateDrugsWithStock;
	var	totalRecords				= formObj.totalRecords.value;
	var issuebyuom					= formObj.issuebyuom.value;
	var base_to_disp_uom_equl_val	= parent.f_stock_dtls.DispMedicationStockDetails.base_to_disp_uom_equl_val.value;
	var base_to_def_uom_equl_val	= parent.f_stock_dtls.DispMedicationStockDetails.base_to_def_uom_equl_val.value;

	var issue_qty		= '';
	var issue_qty_old	= '';
	var	issue_uom_lbl	= ''; 
	var issue_uom_qty	= ''; 
	var	issue_uom_uom	= ''; 
	var issue_qty_val   = '';
	var issue_btch_qty  = '';
	var issue_qty_val_1 = '';

	var issueUom_code_value = obj.value;

	var issueuomarray = issueUom_code_value.split("_");
	var iss_qty_uom    = issueuomarray[0];
	var iss_qty_eq_val = issueuomarray[1];
	var iss_qty_uom_desc = issueuomarray[2];
	var act_stk_equval_value = issueuomarray[3];

	for(i=0;i<totalRecords;i++){
		issue_qty	   =  eval("formObj.issue_qty"+i);
		//issue_qty_old  =  parent.f_stock_dtls.document.DispMedicationStockDetails.stk_qty;
		issue_qty_old  =  eval(parent.f_drug_entry.document.getElementById("issue_qty_old"+i));
		issue_uom_lbl  =  eval(parent.f_drug_entry.document.getElementById("issue_uom_lbl"+i));
		issue_uom_qty  =  eval("formObj.issue_uom_qty"+i);
		issue_uom_uom  =  eval("formObj.issue_uom_uom"+i);
		issue_uom_desc =  eval("formObj.issue_uom_desc"+i);
		issue_uom_equl =  eval("formObj.issue_uom_equl"+i);

		issue_btch_qty = issue_qty_old.value;
		if(issueUom_code_value != ""){
			
			
			if(base_to_def_uom_equl_val!=base_to_disp_uom_equl_val){
			
				issue_qty_val				= Math.ceil(issue_btch_qty*base_to_disp_uom_equl_val);
				var conv_factor				= lcm(base_to_def_uom_equl_val, iss_qty_eq_val);
				conv_factor					= lcm(conv_factor, base_to_disp_uom_equl_val);
				issue_qty_val_2				= Math.ceil(((Math.ceil(issue_qty_val/conv_factor))*(conv_factor))/base_to_disp_uom_equl_val);
				issue_qty.value				= issue_qty_val_2; 
				issue_qty_val_1				= Math.ceil(((Math.ceil(issue_qty_val/conv_factor))*(conv_factor))/act_stk_equval_value);
			}
			else if(iss_qty_eq_val != base_to_disp_uom_equl_val){//else if Added for AAKH-SCF-0113[IN:048937]
				issue_qty_val				= Math.ceil(issue_btch_qty*base_to_disp_uom_equl_val);
				var conv_factor				= lcm(issue_qty_val, act_stk_equval_value);////changed parameters for MMS-ICN-0128 point 6
				conv_factor					= lcm(conv_factor, base_to_disp_uom_equl_val);
			if(issue_btch_qty==0)//Added of condition for MMS-ICN-0128 point 6
                    issue_qty_val_2 =0;
			else
				issue_qty_val_2				= Math.ceil(((Math.ceil(issue_qty_val/conv_factor))*(conv_factor))/base_to_disp_uom_equl_val);
				issue_qty.value				= issue_qty_val_2; 
				if(issue_btch_qty==0)//Added of condition for MMS-ICN-0128 point 6
                    issue_qty_val_1 =0;
				else
				    issue_qty_val_1				= Math.ceil(((Math.ceil(issue_qty_val/conv_factor))*(conv_factor))/act_stk_equval_value);
				
			}
			else{
				issue_qty_val_2 =issue_btch_qty;
				issue_qty_val_1 =issue_btch_qty;
			}
			if(isNaN(issue_qty_val_1))
				issue_qty_val_1 = 0;

			/*if(issuebyuom=='I'){
				issue_uom_lbl.innerHTML		=  "<b>( "+issue_qty_val_1+" "+iss_qty_uom_desc+" )</b>";
			}*/// Commented for  MMS-SCF-0040 [IN:041888]
			issue_uom_qty.value			= issue_qty_val_1;
			issue_uom_uom.value			= iss_qty_uom;
			issue_uom_desc.value		= iss_qty_uom_desc;
			issue_uom_equl.value        = iss_qty_eq_val;
		}
		else{
		
			issue_qty.value				= issue_btch_qty;
			issue_uom_lbl.innerText		=  '';
			issue_uom_qty.value			=  '';
			issue_uom_uom.value			=  '';
			issue_uom_desc.value		=  '';
			issue_uom_equl.value        =  '';
		}
	}	
}

function setQtyBsdOnIssueUOM(obj,no){
	var qty					= obj.value;
	var formObj			    = document.DispMedicationAllocateDrugsWithStock;
	var issueUom_code_value = parent.f_stock_dtls.DispMedicationStockDetails.issue_uom_select.value;
	var issueuomarray		= issueUom_code_value.split("_");
	var iss_qty_uom			= issueuomarray[0];
	var iss_qty_eq_val		= issueuomarray[1];
	var iss_qty_uom_desc	= issueuomarray[2];
	var act_stk_equval_value = issueuomarray[3];

	var base_to_disp_uom_equl_val	= parent.f_stock_dtls.DispMedicationStockDetails.base_to_disp_uom_equl_val.value;
	var base_to_def_uom_equl_val    = parent.f_stock_dtls.DispMedicationStockDetails.base_to_def_uom_equl_val.value;
    var issuebyuom					= formObj.issuebyuom.value;

	var issue_qty	  = eval("formObj.issue_qty"+no);
	var issue_qty_old = eval("formObj.issue_qty_old"+no);
	var issue_uom_lbl = eval(document.getElementById("issue_uom_lbl"+no));
	var issue_uom_qty = eval("formObj.issue_uom_qty"+no);
	var issue_uom_uom = eval("formObj.issue_uom_uom"+no);
	var issue_uom_desc =eval("formObj.issue_uom_desc"+no);
	avail_qty	   =parseInt(eval("document.DispMedicationAllocateDrugsWithStock.alloc_qty"+no+".value"));
	if(issueUom_code_value != ""){
        	var conv_factor =lcm(base_to_def_uom_equl_val, iss_qty_eq_val); 
	    	conv_factor     =lcm(conv_factor, base_to_disp_uom_equl_val);
	     	if(base_to_disp_uom_equl_val!=iss_qty_eq_val){ 
				if(((qty*base_to_disp_uom_equl_val)%conv_factor) != '0'){
					alert(getMessage("PH_ISSUE_UOM_MUL","PH")+(conv_factor/base_to_disp_uom_equl_val));
					obj.focus();
					return false;
				}
				var alloc_qty = Math.ceil(((Math.ceil((qty*base_to_disp_uom_equl_val)/conv_factor))*(conv_factor))/base_to_disp_uom_equl_val);       
				var issue_qty_val_1			= Math.ceil(((Math.ceil((qty*base_to_disp_uom_equl_val)/conv_factor))*(conv_factor))/act_stk_equval_value);
			}
	     	/*else if(base_to_disp_uom_equl_val!=base_to_def_uom_equl_val){//MMS-MD-SCF-0204
			if(((qty*base_to_disp_uom_equl_val)%conv_factor) != '0'){
				alert(getMessage("PH_ISSUE_UOM_MUL","PH")+(conv_factor/base_to_disp_uom_equl_val));
				obj.focus();
				return false;
			} 
			var alloc_qty = Math.ceil(((Math.ceil((qty*base_to_disp_uom_equl_val)/conv_factor))*(conv_factor))/base_to_disp_uom_equl_val);       
			var issue_qty_val_1			= Math.ceil(((Math.ceil((qty*base_to_disp_uom_equl_val)/conv_factor))*(conv_factor))/act_stk_equval_value);
		}*///END
		else{ //Comented for  MMS-SCF-0040 [IN:041888] -end
           issue_qty_val_1 =qty;
		   alloc_qty=qty;
		} //Commented for  MMS-SCF-0040 [IN:041888]

		if(isNaN(issue_qty_val_1))
			issue_qty_val_1 = 0;
		if(parseInt(alloc_qty) > parseInt(avail_qty)) {
			alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH"));
			//obj.select(); //Commented for ICN 29853
		}
		else{
		    issue_qty.value				= alloc_qty;
			/* if(issuebyuom=='I'){
			    issue_uom_lbl.innerHTML		= "<b>( "+issue_qty_val_1+" "+iss_qty_uom_desc+" )</b>";
			}*/// Commented for MMS-SCF-0040 [IN:041888]
			issue_uom_qty.value			= issue_qty_val_1;
			issue_uom_uom.value			= iss_qty_uom;
			issue_uom_desc.value		= iss_qty_uom_desc;
		}
	}
}

function setQtyBsdOnIssueUOMinFrontScreen(obj,no,conv_factor,called_from){
	var qty							= obj.value;
	var formObj						= document.DispMedicationAllStages;
	var IssueByUOM					= formObj.IssueByUOM.value;
	var iss_qty_eq_val				= eval("formObj.issue_uom_equl"+no).value;
	var issue_uom_uom				= eval("formObj.issue_uom_uom"+no).value;
	var iss_qty_uom_desc			= eval("formObj.issue_uom_desc"+no).value;
	var base_to_disp_uom_equl_val	= eval("formObj.base_to_disp_uom_equl_val"+no).value; 
	var base_to_def_uom_equl_val    = eval("formObj.base_to_def_uom_equl_val"+no).value; 
	var issue_qty					= '';
	var issue_qty_old				= '';
	var	issue_uom_lbl				= ''; 
	var issue_uom_qty				= ''; 
	var	issue_uom_uom				= ''; 
	var issue_uom_desc				= '';
	issue_qty					= eval("formObj.alloc_qty_"+no);
	issue_qty_old = eval("formObj.issue_qty_old"+no);
	issue_uom_lbl = eval(document.getElementById("issue_uom_lbl"+no));
	issue_uom_qty = eval("formObj.issue_uom_qty"+no);
	issue_uom_uom = eval("formObj.issue_uom_uom"+no);
	issue_uom_desc =eval("formObj.issue_uom_desc"+no);
	var issueUom_code_value = eval("formObj.issue_uom_select_"+no).value;
	var issueuomarray = issueUom_code_value.split("_");
	//var iss_qty_uom    = issueuomarray[0];
	var iss_qty_eq_val = issueuomarray[1];// Uncommented for AAKH-SCF-0103 [IN:047628]
	//var iss_qty_uom_desc = issueuomarray[2];
	var act_stk_equval_value = issueuomarray[3];
	if(qty !='' && qty!=undefined){			
		if(parseInt(iss_qty_eq_val)!=0 &&parseInt(base_to_disp_uom_equl_val)!=0){//Changed base_to_def_uom_equl_val to iss_qty_eq_val for AAKH-SCF-0103 [IN:047628]
			if(parseInt(iss_qty_eq_val)!=parseInt(base_to_disp_uom_equl_val)){//Changed base_to_def_uom_equl_val to iss_qty_eq_val for AAKH-SCF-0103 [IN:047628]
				/*if(((qty*base_to_disp_uom_equl_val)%conv_factor) != '0'){
					alert(getMessage("PH_ISSUE_UOM_MUL","PH")+(conv_factor/base_to_disp_uom_equl_val));		
					obj.focus();  
				}*/ //Commented for  MMS-SCF-0040 [IN:041888]
				var alloc_qty     = Math.ceil(((Math.ceil((qty*base_to_disp_uom_equl_val)/conv_factor))*(conv_factor))/base_to_disp_uom_equl_val);  
				if(called_from != "FROMBATCH"){
				  issue_qty.value	= parseInt(alloc_qty);
				 }
				//var issue_qty_val_1			= Math.ceil(((Math.ceil((qty*base_to_disp_uom_equl_val)/conv_factor))*(conv_factor))/iss_qty_eq_val);
				var issue_qty_val_1		= Math.ceil(((Math.ceil((qty*base_to_disp_uom_equl_val)/conv_factor))*(conv_factor))/act_stk_equval_value);
			}
			else{
				issue_qty_val_1 =qty;
				issue_qty.value =parseInt(qty);
			}
			
			if(isNaN(issue_qty_val_1))
				issue_qty_val_1 = 0;
			if(IssueByUOM=='I'){
			   issue_uom_lbl.innerHTML		= "<b>( "+issue_qty_val_1+" "+iss_qty_uom_desc+" )</b>";
			} // Uncommented for AAKH-SCF-0103 [IN:047628] //Commented MMS-SCF-0040 [IN:041888]
			issue_uom_qty.value			= issue_qty_val_1;	
		}
		else{
			alert(getMessage("PH_ITEM_UOM_DEF_NOT_FOUND","PH"));
			issue_qty.value	="";
			if(!obj.disabled)
				obj.focus();
		}
	}
}

function CalculateConversionfactor(base_to_def_uom_equl_val,iss_qty_eq_val,base_to_disp_uom_equl_val){
  var conv_factor=1; //def to 1 to avoid NaN in Fill against Fill list
	if(parseInt(base_to_def_uom_equl_val)!=0 && parseInt(base_to_disp_uom_equl_val)!=0 && parseInt(base_to_def_uom_equl_val)!=parseInt(base_to_disp_uom_equl_val)){ //Added && parseInt(base_to_def_uom_equl_val)!=parseInt(base_to_disp_uom_equl_val) to avoid NaN in Fill against Fill list
	    var conv_factor = lcm(base_to_def_uom_equl_val, iss_qty_eq_val);
		conv_factor = lcm(conv_factor, base_to_disp_uom_equl_val);
		if(isNaN(conv_factor) || conv_factor=='0')
			conv_factor = 1;
	}			
	return conv_factor;
}

function changeDurationValue(obj, formObj, calledFrom){
	var bean_id		= "DispMedicationBean" ;
	var bean_name	= "ePH.DispMedicationBean";
	if(calledFrom == undefined)
		calledFrom="";

	var orgDurnPrdVal	= obj.value;
	var durnPrdVal		=  orgDurnPrdVal;
	var drunHrVal		= "";
	var durnPrdType		=  formObj.durnType.value;

	window.returnValue = orgDurnPrdVal+'@'+durnPrdType;

	if(durnPrdType == "W"){
		durnPrdVal = durnPrdVal * 7;
	}
	else if(durnPrdType == "M"){
		durnPrdVal = durnPrdVal * 30;
	}
	else if(durnPrdType == "H"){
		drunHrVal	= durnPrdVal;
		durnPrdVal = Math.ceil(durnPrdVal/24);
	}

	if(obj.value == '' || obj.value == '0'){
		alert(getMessage("DURATION_CANT_BLANK","PH"));
		obj.focus();	
	}

	if(obj.value != '' && obj.value != '0'){
//		if(durnPrdType == "H"){
//			durnPrdVal = drunHrVal;
//		}

		var xmlStr ="<root><SEARCH ";
		xmlStr+= "durnPrdVal =\"" + durnPrdVal + "\" " ;
		xmlStr+= "durnPrdType =\"" + durnPrdType + "\" " ;
		xmlStr+= "calledFrom =\"" + calledFrom + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="../../ePH/jsp/DispMedicationValidate.jsp?identity=chngDurnValue"+"&bean_id="+bean_id+"&bean_name="+bean_name+"&orgDurnPrdVal="+orgDurnPrdVal;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		if(formObj == document.DispMedicationAllocateDrugsTitle){
			parent.f_drug_detail.location.href="../../ePH/jsp/DispMedicationAllocationDetails.jsp?"+document.DispMedicationAllocateDrugsTitle.QueryString.value+"&durnPrdVal="+durnPrdVal+"&resetQty=true"; // "&durnPrdVal="+durnPrdVal Added for ML-MMOH-SCF-0690
			clickNextDrug(1,document,window,0);
		}
		else if(formObj.disp_stage.value == "F"){
			parent.f_disp_medication_filling.location.href="../../ePH/jsp/DispMedicationFilling.jsp?patient_id="+document.DispMedicationAllStages.patient_id.value+"&encounter_id=DUMMYENCOUNTERID&order_id="+document.DispMedicationAllStages.order_id.value+"&resetQty=true";
		}
		else if(formObj.disp_stage.value == "A"){
			parent.f_disp_medication_allocation.location.href="../../ePH/jsp/DispMedicationAllocation.jsp?patient_id="+document.DispMedicationAllStages.patient_id.value+"&encounter_id=DUMMYENCOUNTERID&order_id="+document.DispMedicationAllStages.order_id.value+"&resetQty=true";
		}
		else if(formObj.disp_stage.value == "AS"){
			parent.f_disp_medication_all_stages.location.href="../../ePH/jsp/DispMedicationAllStages.jsp?patient_id="+document.DispMedicationAllStages.patient_id.value+"&encounter_id=DUMMYENCOUNTERID&order_id="+document.DispMedicationAllStages.order_id.value+"&resetQty=true";
		}	
	}
}

function reloadFillPage(){
	parent.f_disp_medication_filling.location.href="../../ePH/jsp/DispMedicationFilling.jsp?patient_id="+document.DispMedicationAllStages.patient_id.value+"&encounter_id=DUMMYENCOUNTERID&order_id="+document.DispMedicationAllStages.order_id.value;
}

function resetQtyValue(){
	try	{
		document.DispMedicationAllocateDetails.resetQty.value='false';
	}
	catch (e){
	}
}

function calculateIssueUOM(obj,i,key,updateStock,approval_no){//approval_no added for AAKH-CRF-0117
	var formObj			= document.DispMedicationAllStages;
    var base_to_disp_uom_equl_val	= eval("formObj.base_to_disp_uom_equl_val"+i).value;
	var base_to_def_uom_equl_val    = eval("formObj.base_to_def_uom_equl_val"+i).value;
	var issuebyuom					= formObj.IssueByUOM.value;
	/*if(updateStock == undefined)//Commented for AAKH-SCF-0103 [IN:047628]
		updateStock = '';*/
	var issue_qty		= '';
	var issue_qty_old	= '';
	var	issue_uom_lbl	= ''; 
	var issue_uom_qty	= ''; 
	var	issue_uom_uom	= ''; 
	var issue_qty_val   = '';
	var issue_btch_qty  = '';
	var issue_qty_val_1 = '';
	var issue_qty_val_2 = '';

	var issueUom_code_value = obj.value;
	var issueuomarray = issueUom_code_value.split("_");
	var iss_qty_uom    = issueuomarray[0];
	var iss_qty_eq_val = issueuomarray[1];
	var iss_qty_uom_desc = issueuomarray[2];
	var act_stk_equval_value = issueuomarray[3];

	issue_qty	   =  eval("formObj.alloc_qty_"+i);
	issue_qty_old  =  eval("formObj.issue_qty_old"+i);
	issue_uom_lbl  =  eval(document.getElementById("issue_uom_lbl"+i));
	issue_uom_qty  =  eval("formObj.issue_uom_qty"+i);
	issue_uom_uom  =  eval("formObj.issue_uom_uom"+i);
	issue_uom_desc =  eval("formObj.issue_uom_desc"+i);
	issue_uom_equl =  eval("formObj.issue_uom_equl"+i);

	try{
		issue_btch_qty = issue_qty_old.value;
	}
	catch(e){}

	if(issueUom_code_value != ""){
		if(base_to_disp_uom_equl_val!=base_to_def_uom_equl_val){
			issue_qty_val				= Math.ceil(issue_btch_qty*base_to_disp_uom_equl_val);
			var conv_factor					= lcm(base_to_def_uom_equl_val, iss_qty_eq_val);
			conv_factor					= lcm(conv_factor, base_to_disp_uom_equl_val);
			issue_qty_val_2				= Math.ceil(((Math.ceil(issue_qty_val/conv_factor))*(conv_factor))/base_to_disp_uom_equl_val);

			try{
				if(isNaN(issue_qty_val_2))
					issue_qty_val_2 = 0;
				issue_qty.value				= parseInt(issue_qty_val_2); 
			}
			catch(e){
			}
			issue_qty_val_1				= Math.ceil(((Math.ceil(issue_qty_val/conv_factor))*(conv_factor))/act_stk_equval_value);
			eval("formObj.bms_qty"+i).value=0;// Added for AAKH-SCF-0103 [IN:047628]
		if( eval(document.getElementById("bms_qty_"+i)).value<=0) // if condition Added for MMS-DM-SCF-0488   /* Always it was defaulting Balance Quantity with Zero quantity */
			eval(document.getElementById("bms_qty_"+i)).innerHTML=""+0+"";// Added for AAKH-SCF-0103 [IN:047628]
		}
		else{
			issue_qty_val_1 =issue_btch_qty;
			issue_qty_val_2 =issue_btch_qty;
		}
		if(isNaN(issue_qty_val_1)){
			issue_qty_val_1 = 0;
			issue_qty_val_2 = 0;
		}

		if(issue_uom_lbl == undefined)
			return;
		if(issuebyuom=='I'){
			issue_uom_lbl.innerHTML		= "<b>( "+issue_qty_val_1+" "+iss_qty_uom_desc+" )</b>";
		}// Uncommented for AAKH-SCF-0103 [IN:047628] //Commented for MMS-SCF-0040 [IN:041888]
		try{
			issue_uom_qty.value			= issue_qty_val_1;
			issue_uom_uom.value			= iss_qty_uom;
			issue_uom_desc.value		= iss_qty_uom_desc;
			issue_uom_equl.value        = iss_qty_eq_val;
			// eval("formObj.base_to_def_uom_equl_val"+i).value =iss_qty_eq_val;
		}
		catch (e){}
	}
	else{
		try{
			if(isNaN(issue_btch_qty))
				issue_btch_qty = 0;
			issue_qty.value				= parseInt(issue_btch_qty);
			issue_uom_lbl.innerText		=  '';
			issue_uom_qty.value			=  '';
			issue_uom_uom.value			=  '';
			issue_uom_desc.value		=  '';
			issue_uom_equl.value        =  '';
		}
		catch (e){	}
	}

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"DispMedicationAllStages\" " ;
	xmlStr+= "bean_name=\"ePH.DispMedicationAllStages\" " ;
	xmlStr+= "DefaultIssueUOM=\"" + iss_qty_uom + "\" " ;
	xmlStr+= "Key=\"" + key + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=ChangeDefaultUOM";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);		
	if(eval("formObj.alloc_qty_"+i) != undefined  && eval("formObj.alloc_qty_hidden_"+i) != undefined){ // this is to check to reset batches.
		var args =  eval("formObj.alloc_qty_hidden_"+i).value.split("~");
		//setbatchdetails(eval(args[0]),args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],issue_uom_uom.value,args[10],args[11],args[12],args[13],args[14],updateStock); //changed arg[9] to issue_uom_uom.value for MMS-SCF-0040 [IN:041888], AAKH-SCF-0113 [IN:048937] - change Issue UOM
	setbatchdetails(eval(args[0]),args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11],args[12],args[13],args[14],updateStock,"Y",approval_no);//removed for ML-BRU-SCF-1433 [IN:051291] ,AAKH-SCF-0195[IN054909]  // "Y" Added for MMS-DM-SCF-0488 and approval_no added for AAKH-CRF-0117
	}
}
//added for AAKH-SCF-338
function setIssueUom(obj,key){

	var issueUom_code_value = obj.value;
	
	var issueuomarray = issueUom_code_value.split("_");
	var iss_qty_uom    = issueuomarray[0];
	


	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"DispMedicationAllStages\" " ;
	xmlStr+= "bean_name=\"ePH.DispMedicationAllStages\" " ;
	xmlStr+= "DefaultIssueUOM=\"" + iss_qty_uom + "\" " ;
	xmlStr+= "Key=\"" + key + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=setIssueUom";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);		
}

function setEnableDsbleCOR(obj,count){
	if(obj.checked == true){
		eval("document.DispMedicationAllStages.ComplteOrderReason"+count).value="";
		eval("document.DispMedicationAllStages.ComplteOrderReason"+count).disabled = true; 
	}
	else if(obj.checked == false){
		eval("document.DispMedicationAllStages.ComplteOrderReason"+count).disabled = false;
	}
}

function assignValue(obj){
	if(obj.checked==true){
		obj.value='Y';
	}
	else{
		obj.value='N';
	}
}

async function viewTokenDetails(patientId){

	var dialogHeight= "15" ;//"29"
	var dialogWidth	= "42" ;//"42"
	var dialogTop	= "200";
	var dialogLeft	= "200";//"85"
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=yes; status:no ";

	//window.open("../../eCA/jsp/PatientProfileMain.jsp?<%=request.getQueryString()%>",arguments,features);	
	await window.showModalDialog("../../ePH/jsp/DispMedicationTokenDeatilsl.jsp?patient_id="+patientId,arguments,features);	
}

function encryptDrugCode(drugCode){
	drugCode = drugCode.replace(/_/g,"zXd1");
	drugCode = drugCode.replace(/-/g,"zXd3");
	while (drugCode.indexOf(".")>-1) {
		pos= drugCode.indexOf(".");
		drugCode = "" + (drugCode.substring(0, pos) + "zXd2" + 
		drugCode.substring((pos + 1), drugCode.length));
	}
	return drugCode;
}

function includeToBms(obj,recCount,act_bms_qty){//KAUH-SCF-0096 [IN:035355]. Added Prescribed Quantiy parameter.
	if(obj.value == '' || parseInt(obj.value) == 0){
		//if(eval("document.DispMedicationAllStages.allocateyn_"+recCount)!=undefined)
		//	  eval("document.DispMedicationAllStages.allocateyn_"+recCount).value = 'N';
		if( parseInt(obj.value) != 0){//if condotion added for  MO-GN-5434 [IN:004099]
			if(eval("document.DispMedicationAllStages.alloc_status"+recCount)!=undefined)
			  	eval("document.DispMedicationAllStages.alloc_status"+recCount).value = '';

			if(eval("document.DispMedicationAllStages.fill_status"+recCount)!=undefined)
			  	eval("document.DispMedicationAllStages.fill_status"+recCount).value = '';
		}
		if(eval(document.getElementById("hold_remarks_"+recCount))!=undefined){
			eval(document.getElementById("hold_remarks_"+recCount)).disabled=false;
			eval(document.getElementById("hold_remarks_"+recCount)).style.color='blue';
			eval(document.getElementById("hold_remarks_"+recCount)).style.cursor='hand';
		}
        if(eval(document.getElementById("alloc_bms_chk_"+recCount))!=undefined && eval(document.getElementById("alloc_bms_chk_"+recCount)).checked==false){
			if(eval(document.getElementById("ComplteOrderReason"+recCount))!=null){
				eval(document.getElementById("ComplteOrderReason"+recCount)).disabled=false;
			}
		}
		if(document.getElementById("IncludeZeroQty") != undefined && document.getElementById("IncludeZeroQty").value == 'Y' && eval(document.getElementById("alloc_bms_chk_"+recCount))!=undefined ){//&& eval("document.getElementById("alloc_bms_chk_")"+recCount).checked==false){ //commented for Bru-HIMS-CRF-281 [IN:033166]
			if(eval(document.getElementById("divOtherEditLables"+recCount))!= undefined)
				eval(document.getElementById("divOtherEditLables"+recCount)).style.display ="none";
		
			if(eval(document.getElementById("divIncludeZeroQty"+recCount))!= undefined){
				eval(document.getElementById("divIncludeZeroQty"+recCount)).style.display ="inline";
				includeBMSDefCheck_yn=document.DispMedicationAllStages.includeBMSDefCheck_yn.value;// added for [IN:045055](Bru-HIMS-CRF-281[IN:033166])
				if(eval("document.DispMedicationAllStages.ComplteOrderReason"+recCount).value=="" && includeBMSDefCheck_yn=='Y'){
					eval("document.DispMedicationAllStages.alloc_bms_chk_"+recCount).checked=true; //added for Bru-HIMS-CRF-281 [IN:033166] -start
					eval("document.DispMedicationAllStages.alloc_bms_chk_"+recCount).value= 'Y';
					eval("document.DispMedicationAllStages.ComplteOrderReason"+recCount).value="";
					eval("document.DispMedicationAllStages.ComplteOrderReason"+recCount).disabled = true;  //added for Bru-HIMS-CRF-281 [IN:033166] - end
				}
			}
			obj.value = 0;
			//alert(getMessage("SEL_BMS_CHK_BOX_TO_PROCEED","PH")); Commented for Bru-HIMS-CRF-281 [IN:033166] //Commented for Bru-HIMS-CRF-281 [IN:033166]
		}
		if(eval("document.DispMedicationAllStages.allocateyn_"+recCount)!=undefined && (eval(document.getElementById("alloc_bms_chk_"+recCount)).checked==false || eval("document.DispMedicationAllStages.ComplteOrderReason"+recCount).value!=""))
				  eval("document.DispMedicationAllStages.allocateyn_"+recCount).value = 'N';
		if(document.DispMedicationAllStages.patient_class!= undefined && document.DispMedicationAllStages.patient_class.value=="IP"){//Adding start for ML-BRU-CRF-0473
			if(eval("document.DispMedicationAllStages.IncludeZeroQtyForIP")!=undefined && eval("document.DispMedicationAllStages.IncludeZeroQtyForIP").value== 'Y'){
               if(eval(document.getElementById("alloc_bms_chk_"+recCount0))!=undefined){
				   eval("document.DispMedicationAllStages.alloc_bms_chk_"+recCount).checked=true;
                   eval("document.DispMedicationAllStages.alloc_bms_chk_"+recCount).value= 'Y';
				   eval("document.DispMedicationAllStages.allocateyn_"+recCount).value = 'Y';
			  }
			}                                          
		}//Adding end for ML-BRU-CRF-0473
	}
	else if(parseInt(obj.value) < act_bms_qty){//KAUH-SCF-0096 [IN:035355]. Enabled the CompleteOrder. 
		eval(document.getElementById("ComplteOrderReason"+recCount)).disabled=false;
	}
	else{
		alert(getMessage("PH_DIRECT_DISPENCING_NO_STOCK","PH"));
		obj.value =0;
	}
}

async function searchPrdCode(){
	var formObj = document.fromDispMedicationWSLabel;
	if(formObj.OrderType.disabled == false){
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
		
		var admxType		= "''";
		if(formObj.OrderType != undefined)
			admxType		= "('"+formObj.OrderType.value+"','A')";

		argumentArray[0]	= formObj.searchSQL.value+' '+admxType;
		argumentArray[1]	= dataNameArray ;
		argumentArray[2]	= dataValueArray ;
		argumentArray[3]	= dataTypeArray ;
		argumentArray[4]	= "1,2";
		argumentArray[5]	= formObj.mfg_unit.value ;
		argumentArray[6]	= DESC_LINK ;
		argumentArray[7]	= DESC_CODE ;
		
		retVal = await CommonLookup( getLabel("Common.ProductName.label","Common"), argumentArray );
		if(retVal != undefined && retVal != "" )  
			formObj.mfg_unit.value	= retVal[1];
	}
}

function checkValidDecimal(obj){
	mystring = obj.value;

	if (mystring.match(/\.\d{2}$/ ) || mystring.match(/\.\d{3}$/ ) || mystring.match(/\.\d{0}$/ )||mystring.indexOf(".")==0){
		alert("Only numeric value with single decimal is allowed");
		obj.focus();
		return false;
	}
}

async function openEditLabel(patientId,mode, patient_class){
	if(patient_class==undefined)
		patient_class = '';
	var dialogHeight	= "95vh" ;
	var dialogWidth		= "95vw";
	var dialogTop		= "10" ;
	var dialogLeft		= "10" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	retVal = await top.window.showModalDialog("../../ePH/jsp/DispMedicationEditLabelFrame.jsp?patientid="+patientId+"&mode="+mode+"&patient_class="+patient_class,arguments,features);
	//window.open("../../ePH/jsp/DispMedicationEditLabelFrame.jsp?patientid="+patientId+"&mode="+mode,arguments,features);
}


function closePrintDialogWindow(){
	var nextColDateRecorded = true;

	if(parent.printSelectFrame != undefined && parent.printSelectFrame.document.DispMedicationPrintDialog != undefined)	{

		if(parent.printSelectFrame.document.DispMedicationPrintDialog.enable_tab != undefined && parent.printSelectFrame.document.DispMedicationPrintDialog.enable_tab.value == 'Y'){
			nextColDateRecorded = setOrOrder(parent.printSelectFrame.document.DispMedicationPrintDialog);
		}
	}
	var xmlStr ="<root><SEARCH ";
	xmlStr+= " bean_id =\"DispMedicationAllStages\" " ;
	xmlStr+= " bean_name=\"ePH.DispMedicationAllStages\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=clearAlBMSOrderIds";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);			

	parent.window.returnValue='OK';
	parent.window.close()
}

function validateRecordMandatory(){
	var formObj			= parent.printSelectFrame.document.DispMedicationPrintDialog;
	var currentStage	= formObj.curr_stage.value;
	var validate		= true;
	var currentFacility	= "C";
	var fields			= new Array() ;
	var names			= new Array() ;		

	if(formObj.curr_facility != undefined && formObj.curr_facility[1].checked == true)
		currentFacility	= "E";

	if(formObj.enable_tab != undefined && formObj.enable_tab.value == 'Y'){
		if(currentFacility=='C'){
			fields[0]   = formObj.next_collection_date1 ;	
			names[0]    = getLabel("ePH.NextCollectionDate.label","Common")+' ';				
			fields[1]   = formObj.disp_locations ;	
			names[1]    = getLabel("ePH.NextCollectionFrom.label","Common")+' '; 
		}
		else if(currentFacility=='E'){
			var cnt	=	0;

			if(formObj.referral_location.value =="" && formObj.referral_facility.value ==""){ 
				fields[cnt]   = formObj.referral_location ;	
				names[cnt]    = getLabel("Common.FacilityName.label","Common")+' ';
				cnt++;
			}

			fields[cnt]   = formObj.next_collectiondate ;	
			names[cnt]    = getLabel("ePH.NextCollectionDate.label","PH")+' ';	
			cnt++;

			fields[cnt]   = formObj.referral_remarks ;	
			names[cnt]    = getLabel("Common.remarks.label","Common")+' ';
			cnt++;

			fields[cnt]   = formObj.practioner_name ;	
			names[cnt]    = getLabel("ePH.ReferedBy.label","PH")+' ';
		}
		if(currentStage == 'D' || currentStage =='AS'){
			validate =  checkFlds( fields, names);
		}
	}
	return validate;
}


function check(box) { 
	var val = box.value/1 
	// limit to 2 dec places (rounding up, if needed) 
	box.value = Math.round(val*100)/100 
	// check <7 after dec point 
	if(!(val<1000000)) 
		alert("APP-PH999 More than 6 figures after decimal point") 
} 

async function dispDrugAuthCheck(checkYN){
	if(document.getElementById("userAuthPINYN").value=='Y'){   //RUT-CRF-0035 [IN029926] -- begin
		checkYN='N';
		
		var dialogHeight	= "40vh";
		var dialogWidth		= "50vw";
		var dialogTop		=  window.screen.availWidth - 1100;
		var dialogLeft		=  window.screen.availWidth - 1000;
		var center			= "0";
		var status			= "no";	
		var stage			= document.getElementById("disp_stage").value;	
		var disp_locn_catg	= document.getElementById("disp_locn_catg").value;	
		var disp_locn_code	= document.getElementById("disp_locn_code").value;	
		var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;

		var retVal=await window.showModalDialog("../../ePH/jsp/UserPINAuthorization.jsp?call_from="+stage+"&disp_category="+disp_locn_catg+"&disp_locn_code="+disp_locn_code,"",features);
		if(retVal==undefined || retVal=='C')
			return;
		else{
			retVal=trimString(retVal);
			if(retVal!="0"){
				storeUserinBean(retVal);
			}
		}
	}//RUT-CRF-0035 [IN029926] -- end
	if(checkYN == 'Y'){
		var dialogHeight= "40vh" ;
		var dialogWidth	= "50vw" ;
		var dialogTop = "150" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../ePH/jsp/DispMedicationAuthorize.jsp",arguments,features);
		if(retVal=="OK") {
			return	true;
		} 
		else {
			return false;
		}
	}
	else
		return true;
}

function disableFillOrAllocate(){
	formObj = document.DispMedicationAllStages;
	var count = formObj.tot_rec.value;
	for(var i=1;i<count;i++){
		if(eval("formObj.alloc_qty_"+i)!= null && eval("formObj.alloc_qty_"+i)!= undefined)
			eval("formObj.alloc_qty_"+i).disabled = true;
		if(eval("formObj.alloc_qty_"+i)!= null && eval("formObj.alloc_qty_"+i)!= undefined)
			eval("formObj.alloc_qty_"+i).disabled = true;
		if(eval("formObj.issue_uom_select_"+i)!= null && eval("formObj.issue_uom_select_"+i)!= undefined)
			eval("formObj.issue_uom_select_"+i).disabled = true;			
		if(eval(document.getElementById("alloc_detail"+i))!= null && eval(document.getElementById("alloc_detail"+i))!= undefined)
			eval(document.getElementById("alloc_detail"+i)).disabled = true;			
		if(eval("formObj.alloc_bms_chk_"+i)!= null && eval("formObj.alloc_bms_chk_"+i)!= undefined)
			eval("formObj.alloc_bms_chk_"+i).disabled = true;			
	}
	parentForm = parent.f_disp_medication_header.document.DispMedicationAllStages;
	if(parentForm != undefined && parentForm !=null){
		if( parentForm.barcode_id!=null && parentForm.barcode_id!= undefined)//if block added for KDAH-CRF-0231 [IN-034551] 
			parentForm.barcode_id.disabled = true;
		if(parentForm.alloc_but != null && parentForm.alloc_but!= undefined)
			parentForm.alloc_but.disabled = true;
		if(parentForm.btnFill != null && parentForm.btnFill!= undefined)
			parentForm.btnFill.disabled = true;
		if(parentForm.durnType != null && parentForm.durnType!= undefined)
			parentForm.durnType.disabled = true;
		if(parentForm.durationVal != null && parentForm.durationVal!= undefined)
			parentForm.durationVal.disabled = true;
	}
}

function checkAllocBmsSecondStage(recCount, obj){
	value = obj.value;
	formObj = document.DispMedicationAllStages;
	if(value == '0' || parseInt(value) == 0){
		if(eval("formObj.allocBmsSecondStage_"+recCount)!= undefined){	
			if(eval("formObj.allocBmsSecondStage_"+recCount).value != 'Y'){
				alert(getMessage("ALLOC_QTY_CANNOT_BLANK_ZERO","PH"));
				act_bms_qty = eval("formObj.act_bms_qty"+recCount).value; //Added for  [IN:038227] -start
				bms_qty = eval("formObj.bms_qty"+recCount).value;
				alloc_qty = parseInt(act_bms_qty)-parseInt(bms_qty);
				obj.value=alloc_qty;//Added for  [IN:038227] -end
				return false;
			}
		}
		else	// else codition add for RUT-SCF-0101[32227]
			eval(document.getElementById("ComplteOrderReason"+recCount)).disabled=false;
	}
	return true;
}

function changeLocalInstr(obj,locale,iLabelPairs,instr_type){
	bean_id		=	document.DispMedicationEditLabel.bean_id.value;
	bean_name	=	document.DispMedicationEditLabel.bean_name.value;
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "locale =\"" + locale + "\" " ;
	xmlStr+= "formObj =\"" + document.DispMedicationEditLabel.name + "\" " ;
	xmlStr+= "instr =\"" + obj.value + "\" " ;
	xmlStr+= "instr_type =\"" + instr_type + "\" " ;
	xmlStr+= "iLabelPairs =\"" + iLabelPairs + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=changeLocalInstr";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function assignLocaltxt(instr_type, iLabelPairs, loc_text){
	if(instr_type=='C')
		eval('document.DispMedicationEditLabel.loc_caution_1_'+iLabelPairs).value=decodeURIComponent(loc_text);
	else
		eval('document.DispMedicationEditLabel.loc_special_1_'+iLabelPairs).value=decodeURIComponent(loc_text);
}

function CheckAltDrugCount(flag, count, order_id, order_line_no, alt_drug_remarks_ind,source,alt_drug_code,alt_drug_desc){//, count, order_id, order_line_no, alt_drug_remarks_ind -Added For Bru-HIMS-CRF-082 [IN:029948]//source,alt_drug_code,alt_drug_desc Added for Bru-HIMS-CRF-399 [IN:043767] 
	if(flag=='Y'){
		if(source=='MAR')//if else Added for Bru-HIMS-CRF-399 [IN:043767]
			alert(getMessage("PH_ONLY_ONE_ALT_DRUGS_ALLOWED_MAR","PH"));
		else
			alert(getMessage("PH_ONLY_THREE_ALT_DRUGS_ALLOWED","PH"));
	    return false; // Added for [IN-041161]
	}
	if(flag=='SameDrug'){
	    alert(getMessage("PH_SAME_DRUG_SELECT","PH"));
	}
	else{
		if(source=='MAR')//if Added for Bru-HIMS-CRF-399 [IN:043767]
			parent.window.returnValue=alt_drug_code+"~"+alt_drug_desc;
		var remEntered = "Y";
		if(count>0 && alt_drug_remarks_ind == 'M')
			remEntered = openAltDrugRemarks(order_id, order_line_no, alt_drug_remarks_ind );
		if(remEntered =='Y')
			parent.window.close();
	}
}

function checkValue(obj) { //Added for  IP -> Fill -> Accepts Decimal value. [IN:030101]
	if(obj.value=="" || isNaN(parseInt(obj.value)) || parseInt(obj.value)==0)
		obj.value="0"; 
	else	 
		obj.value=parseInt(obj.value);    
}

function setValueChanged() { 
	document.DispMedicationAllStages.ValuesChanged.value = "true";
}

async function callADRdetails(patient_id,drug_code){//newly added for RUT-SCF-0144 [IN:033371]
	var dialogHeight= "60" ;
	var dialogWidth	= "60" ;
	var dialogTop = "305" ;
	var dialogLeft = "180" ;
	var center = "1" ;
	var status="no";
	var scroll="no";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/AdrReportingFrame_1.jsp?type=query "+"&status=S"+"&drug_code="+drug_code+"&patient_id="+patient_id ,arguments,features);
}

function CopyDrugRemarksValue(frmObj,iLabelPairs){/*Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] start*/
	var noOfDrugs = frmObj.totalRecordds.value;
	//for(var i=0;i<noOfDrugs;i++){
	var patient_ins =eval('document.DispMedicationEditLabel.patient_int_'+iLabelPairs).value+eval("document.DispMedicationEditLabel.remarks_new_"+iLabelPairs).value;
	eval('document.DispMedicationEditLabel.patient_int_'+iLabelPairs).value=patient_ins;
	var patient_ins_loc=eval('document.DispMedicationEditLabel.loc_patient_int_'+iLabelPairs).value+eval("document.DispMedicationEditLabel.remarks_new_"+iLabelPairs).value;
	eval('document.DispMedicationEditLabel.loc_patient_int_'+iLabelPairs).value=patient_ins_loc;
	//}
}

function checkDrugIndMaxLimit(obj,maxLeng) { 
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("ePH.DrugIndications.label","PH"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,maxLeng);
		alert(msg);
		obj.focus();
		return false;
	} 
	else 
		return true;
}/*Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] end*/

function setfldFocus(barcode_flg){//New field focus method added for KDAH-CRF-0231 [IN-034551]

	/*if (parent.f_disp_medication_header.document.DispMedicationAllStages.queue_pkid_appl.value == true
			|| parent.f_disp_medication_header.document.DispMedicationAllStages.queue_pkid_appl.value == 'true') {
		
		parent.f_disp_medication_header.document.DispMedicationAllStages.quePkiId.focus();
	}*/

	if(parent.f_disp_medication_header!=undefined && parent.f_disp_medication_header.document.DispMedicationAllStages.barcode_id!=null){
		if(barcode_flg=="Y")
			parent.f_disp_medication_header.document.DispMedicationAllStages.barcode_id.focus();
		
	}
	else{
		if(parent.parent.f_batch_title!=undefined && parent.parent.f_batch_title.DispMedicationAllocationBatchTitle.barcode_id!=null){
		 if(barcode_flg=="Y")
			 parent.parent.f_batch_title.DispMedicationAllocationBatchTitle.barcode_id.focus();
		}
	}

	var DispMedicationAllStagesForm;
	try{
		DispMedicationAllStagesForm = parent.f_disp_medication_header.DispMedicationAllStages;
	}catch(e){
		DispMedicationAllStagesForm = parent.parent.content.f_query_add_mod.f_query_result.DispMedicationPatDetFrame_3.f_disp_medication_header.DispMedicationAllStages;
	}
	if (DispMedicationAllStagesForm.queue_pkid_appl.value == true
			|| DispMedicationAllStagesForm.queue_pkid_appl.value == 'true' && barcode_flg!="Y") {
		
				DispMedicationAllStagesForm.quePkiId.focus();
	}
}

function callBarcodeflg(event,patient_id,order_id,disp_stage,alt_drug_code,scanMoreQty,moreThanPresBarcode_id){//New barcode value search method added for KDAH-CRF-0231 [IN-034551] // scanMoreQty,barcode_id Added for GHL-SCF-1293//event added for MMS-Dm-CRF-0157.1
	var barcode_id;
	var allowMoreQtyConfirmed="";
	valid = 'false';
	//Adding start for MMS-DM-CRF-0157.1
	var entry_type ="";
	var keyVal	= parseInt(event.keyCode);
	 var bar_code_site_yn = document.DispMedicationAllStages.bar_code_scan_site_YN.value;
	 var act_patient_episode_type =document.DispMedicationAllStages.act_patient_episode_type.value;//Added for MMS-DM-CRF-170
	if(bar_code_site_yn =="Y" ){
	   if(bar_code_site_yn =="Y" && keyVal==17){
	         entry_type="S";
	   }else{
	         entry_type="M";
		   }
	}
		 
		 //alert("entry_type==="+entry_type)
	//Adding end for MMS-DM-CRF-0157.1

	if(scanMoreQty== undefined || scanMoreQty==""){ // Added for GHL-SCF-1293 - Start
		scanMoreQty = "N";
	} // Added for GHL-SCF-1293 - End
	if(parent.f_disp_medication_header!=undefined){
		barcode_id	= parent.f_disp_medication_header.document.DispMedicationAllStages.barcode_id.value;
		if(moreThanPresBarcode_id!=undefined && barcode_id==""){ // Added for GHL-SCF-1293 - Start
			barcode_id = moreThanPresBarcode_id;
		} // Added for GHL-SCF-1293 - End
		parent.f_disp_medication_header.document.DispMedicationAllStages.barcode_id.value="";
		if(barcode_id!=""){
			if(disp_stage=="A"){
				var xmlStr ="<root><SEARCH ";
				var bean_all_id		= "DispMedicationAllStages" ;
				var bean_all_name	= "ePH.DispMedicationAllStages";
				xmlStr+= "bean_all_id  =\"" + bean_all_id + "\" " ;	
				xmlStr+= "bean_all_name  =\"" + bean_all_name + "\" " ;
				xmlStr+= "patient_id  =\"" + patient_id + "\" " ;	
				xmlStr+= "barcode_id  =\"" + barcode_id + "\" " ;	
				xmlStr+= "scanMoreQty  =\"" + scanMoreQty + "\" " ; // Added for GHL-SCF-1293
				xmlStr+= "disp_stage  =\"" + disp_stage + "\" " ; // Added for GHL-SCF-1293
                xmlStr+= "entry_type  =\"" + entry_type + "\" " ; // Added for MMS-DM-CRF-0157.1
                xmlStr+= "act_patient_episode_type  =\"" + act_patient_episode_type + "\" " ;//Added for MMS-DM-CRF-0170
				xmlStr +=" /></root>";
				var temp_jsp="DispMedicationValidation.jsp?func_mode=GET_VALID_BARCODE";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText ;	
				allowMoreQtyConfirmed = eval(responseText);
				if(allowMoreQtyConfirmed){
					var xmlStr1 ="<root><SEARCH ";
					xmlStr1+= "bean_all_id  =\"" + bean_all_id + "\" " ;	
					xmlStr1+= "bean_all_name  =\"" + bean_all_name + "\" " ;
					xmlStr1+= "patient_id  =\"" + patient_id + "\" " ;	
					xmlStr1+= "barcode_id  =\"" + barcode_id + "\" " ;	
					xmlStr1+= "allowMoreQtyConfirmed  =\"" + allowMoreQtyConfirmed + "\" " ;	
					xmlStr+= "scanMoreQty=\"" + scanMoreQty + "\" " ; // Added for GHL-SCF-1293
					xmlStr+= "disp_stage  =\"" + disp_stage + "\" " ; // Added for GHL-SCF-1293
					xmlStr+= "entry_type  =\"" + entry_type + "\" " ; // Added for MMS-DM-CRF-0157.1
					xmlStr+= "act_patient_episode_type  =\"" + act_patient_episode_type + "\" " ;//Added for MMS-DM-CRF-0170
					xmlStr1 +=" /></root>";
					var temp_jsp="DispMedicationValidation.jsp?func_mode=GET_VALID_BARCODE";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc.loadXML(xmlStr1);
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					responseText=xmlHttp.responseText ;	
					eval(responseText);
				}
				if(valid=="true"){
					parent.f_disp_medication_allocation.location.href="../../ePH/jsp/DispMedicationAllocation.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id+"&barcode_id="+barcode_id+"&dup_count="+dup_count1;
				}
			}
			else if(disp_stage=="F"){
				var xmlStr ="<root><SEARCH ";
				var bean_all_id		= "DispMedicationAllStages" ;
				var bean_all_name	= "ePH.DispMedicationAllStages";
				xmlStr+= "bean_all_id  =\"" + bean_all_id + "\" " ;	
				xmlStr+= "bean_all_name  =\"" + bean_all_name + "\" " ;
				xmlStr+= "patient_id  =\"" + patient_id + "\" " ;	
				xmlStr+= "barcode_id  =\"" + barcode_id + "\" " ;	
				xmlStr+= "scanMoreQty  =\"" + scanMoreQty + "\" " ; // Added for GHL-SCF-1293
				xmlStr+= "disp_stage  =\"" + disp_stage + "\" " ; // Added for GHL-SCF-1293
				xmlStr+= "entry_type  =\"" + entry_type + "\" " ; // Added for MMS-DM-CRF-0157.1
				xmlStr+= "act_patient_episode_type  =\"" + act_patient_episode_type + "\" " ;//Added for MMS-DM-CRF-0170
				xmlStr +=" /></root>";
				var temp_jsp="DispMedicationValidation.jsp?func_mode=GET_VALID_BARCODE";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText ;	
				allowMoreQtyConfirmed = eval(responseText);
				if(allowMoreQtyConfirmed){
					var xmlStr1 ="<root><SEARCH ";
					xmlStr1+= "bean_all_id  =\"" + bean_all_id + "\" " ;	
					xmlStr1+= "bean_all_name  =\"" + bean_all_name + "\" " ;
					xmlStr1+= "patient_id  =\"" + patient_id + "\" " ;	
					xmlStr1+= "barcode_id  =\"" + barcode_id + "\" " ;	
					xmlStr1+= "allowMoreQtyConfirmed  =\"" + allowMoreQtyConfirmed + "\" " ;	
					xmlStr+= "scanMoreQty  =\"" + scanMoreQty + "\" " ; // Added for GHL-SCF-1293
					xmlStr+= "disp_stage  =\"" + disp_stage + "\" " ; // Added for GHL-SCF-1293
					xmlStr+= "entry_type  =\"" + entry_type + "\" " ; // Added for MMS-DM-CRF-0157.1
					xmlStr+= "act_patient_episode_type  =\"" + act_patient_episode_type + "\" " ;//Added for MMS-DM-CRF-0170
					xmlStr1 +=" /></root>";
					var temp_jsp="DispMedicationValidation.jsp?func_mode=GET_VALID_BARCODE";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc.loadXML(xmlStr1);
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					responseText=xmlHttp.responseText ;	
					eval(responseText);
				}
				if(valid=="true"){
					parent.f_disp_medication_filling.location.href="../../ePH/jsp/DispMedicationFilling.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id+"&barcode_id="+barcode_id;
				}
			}
			else if(disp_stage=="AS"){
				var xmlStr ="<root><SEARCH ";
				var bean_all_id		= "DispMedicationAllStages" ;
				var bean_all_name	= "ePH.DispMedicationAllStages";
				xmlStr+= "bean_all_id  =\"" + bean_all_id + "\" " ;	
				xmlStr+= "bean_all_name  =\"" + bean_all_name + "\" " ;	
				xmlStr+= "patient_id  =\"" + patient_id + "\" " ;	
				xmlStr+= "barcode_id  =\"" + barcode_id + "\" " ;	
				xmlStr+= "scanMoreQty  =\"" + scanMoreQty + "\" " ; // Added for GHL-SCF-1293
				xmlStr+= "disp_stage  =\"" + disp_stage + "\" " ; // Added for GHL-SCF-1293
				xmlStr+= "entry_type  =\"" + entry_type + "\" " ; // Added for MMS-DM-CRF-0157.1
				xmlStr+= "act_patient_episode_type  =\"" + act_patient_episode_type + "\" " ;//Added for MMS-DM-CRF-0170
				xmlStr +=" /></root>";
				var temp_jsp="DispMedicationValidation.jsp?func_mode=GET_VALID_BARCODE";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText ;	
				allowMoreQtyConfirmed = eval(responseText);
				if(allowMoreQtyConfirmed){
					var xmlStr1 ="<root><SEARCH ";
					xmlStr1+= "bean_all_id  =\"" + bean_all_id + "\" " ;	
					xmlStr1+= "bean_all_name  =\"" + bean_all_name + "\" " ;
					xmlStr1+= "patient_id  =\"" + patient_id + "\" " ;	
					xmlStr1+= "barcode_id  =\"" + barcode_id + "\" " ;	
					xmlStr+= "scanMoreQty  =\"" + scanMoreQty + "\" " ; // Added for GHL-SCF-1293
					xmlStr+= "disp_stage  =\"" + disp_stage + "\" " ; // Added for GHL-SCF-1293
					xmlStr1+= "allowMoreQtyConfirmed  =\"" + allowMoreQtyConfirmed + "\" " ;	
					xmlStr+= "entry_type  =\"" + entry_type + "\" " ; // Added for MMS-DM-CRF-0157.1
					xmlStr+= "act_patient_episode_type  =\"" + act_patient_episode_type + "\" " ;//Added for MMS-DM-CRF-0170
					xmlStr1 +=" /></root>";
					var temp_jsp="DispMedicationValidation.jsp?func_mode=GET_VALID_BARCODE";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc.loadXML(xmlStr1);
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					responseText=xmlHttp.responseText ;	
					eval(responseText);
				}
				if(valid=="true"){
					parent.f_disp_medication_all_stages.location.href="../../ePH/jsp/DispMedicationAllStages.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id+"&barcode_id="+barcode_id;
				}
			}
		}
	}
}
	
function callBarcodesearch(patient_id, order_id, order_line_num, alt_drug_code, prescribed_strength, bms_strength,alt_drug_strength, drug_desc,alt_drug_desc,alt_drg_no,source,event){//New barcode value search method added for KDAH-CRF-0231 [IN-034551] // alt_drg_no,source Added for MMS-DM-SCF-0083, event added for MMS-DM-CRF-0157.1
	var	barcode_id	= parent.parent.f_batch_title.DispMedicationAllocationBatchTitle.barcode_id.value;
	parent.parent.f_batch_title.DispMedicationAllocationBatchTitle.barcode_id.value="";
	var entry_type ="";//Added for MMS-DM-CRF-0157.1
	if(barcode_id!=""){
		//Adding start for MMS-DM-CRF-0157.1
		var keyVal	= parseInt(event.keyCode);
	 var bar_code_site_yn = parent.parent.f_batch_title.DispMedicationAllocationBatchTitle.bar_code_scan_site_YN.value;
	   if(bar_code_site_yn =="Y" && keyVal==17){
	         entry_type="S";
	   }else{
	         entry_type="M";
		   }
		   //Adding end for MMS-DM-CRF-0157.1
		var xmlStr ="<root><SEARCH ";
		var bean_all_id		= "DispMedicationAllStages" ;
		var bean_all_name	= "ePH.DispMedicationAllStages";
		xmlStr+= "bean_all_id  =\"" + bean_all_id + "\" " ;	
		xmlStr+= "bean_all_name  =\"" + bean_all_name + "\" " ;	
		xmlStr+= "patient_id  =\"" + patient_id + "\" " ;	
		xmlStr+= "barcode_id  =\"" + barcode_id + "\" " ;	
		xmlStr+= "order_id  =\"" + order_id + "\" " ;	
		xmlStr+= "order_line_num  =\"" + order_line_num + "\" " ;	
		xmlStr+= "calledFrom  =\"" + 'REALLOCATE' + "\" " ;	
		xmlStr+= "alt_drug_code  =\"" +alt_drug_code + "\" " ;	
		xmlStr+= "prescribed_strength  =\"" +prescribed_strength + "\" " ;	
		xmlStr+= "bms_strength  =\"" +bms_strength + "\" " ;	
		xmlStr+= "alt_drug_strength  =\"" +alt_drug_strength + "\" " ;	
		xmlStr+= "allowMoreQtyConfirmed  =\"" +'true' + "\" " ;	
		xmlStr+= "entry_type  =\"" +entry_type + "\" " ;	//Added for MMS-DM-CRF-0157.1
		xmlStr +=" /></root>";
		var temp_jsp="DispMedicationValidation.jsp?func_mode=GET_VALID_BARCODE";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;	
		eval(responseText);
		if(valid=="true"){
			parent.parent.f_stock_dtls.location.href="../../ePH/jsp/DispMedicationStockDetails.jsp?barcode_id="+barcode_id+"&alt_drug_code="+alt_drug_code+"&prescribed_strength="+prescribed_strength+"&bms_strength="+bms_strength+"&alt_drug_strength="+alt_drug_strength+"&drug_desc="+drug_desc+"&alt_drug_desc="+alt_drug_desc; // alt_drug_desc Added for MMS-DM-SCF-0083
		if(alt_drug_code!=""){ // MMS-DM-SCF-0083 - Start
			refreshStockWindow(patient_id,order_id,order_line_num,alt_drug_code,alt_drug_desc,'Y','','','','','',source,alt_drg_no,'','0','Y');
		} // MMS-DM-SCF-0083 - End
		}
	}
}

function validbarcode(result,dup_count,called_from,scan_key,entry_type,bar_code_site_yn,call_remarks,act_patient_class,scan_count_required_yn,alert_required_yn,remarks_required_yn,patient_id,encounter_id,disp_stage){ // called_from added for MMS-DM-SCF-0083//event_type and bar_code_site_yn,call_remarks added for MMS-Dm-CRF-157.1 act_patient_class,scan_count_required_yn,alert_required_yn,remarks_required_yn added for MMS-DM-CRF-0170
 	valid=result;
	if(result == 'false'){
		if(dup_count =='INSUFFICIENTBATCH')
			dup_count = getMessage("INSUFFICIENT_BATCH_QTY","PH") ;
		else if(dup_count == 'false')
			dup_count=getMessage("PH_ALLOC_QTY_LESS_BMS_QTY","PH");
		else
			dup_count = getMessage("PH_NOTMATCHING_BAR_CODE","PH") ;//changed from PH_INVALID_BAR_CODE to PH_NOTMATCHING_BAR_CODE for GHL-CRF-413.1[62326]
	     	alert(dup_count);
		if(called_from!="REALLOCATE" && parent.f_disp_medication_header.document.DispMedicationAllStages.barcode_id!=undefined){ // Added for Focusing the barcode field - Start
			 parent.f_disp_medication_header.document.DispMedicationAllStages.barcode_id.focus();
		} // Added for Focusing the barcode field - End
		return false;
	}//added for MMS-DM-CRF-0157.1 START
	else{
		   var retval ="";
		  if( bar_code_site_yn =='Y' && call_remarks  =='Y' && scan_count_required_yn == 'Y'){//Added scan_count_required_yn for MMS-DM-CRF-0170
			  //var patient_id=parent.f_disp_medication_header.document.DispMedicationAllStages.patient_id.value;
			  //var encounter_id =parent.f_disp_medication_header.document.DispMedicationAllStages.encounter_id.value;
			  //var disp_stage = parent.f_disp_medication_header.document.DispMedicationAllStages.disp_stage.value;
				  if(scan_key!=undefined || scan_key !="")
			  var order_id=(scan_key.split("~"))[0];
			  var order_line_no=(scan_key.split("~"))[1];
			  var item_code=(scan_key.split("~"))[2];
			  var batch_id =(scan_key.split("~"))[3];
			 	  //alert("order_id==="+order_id+"order_line_no=="+order_line_no+"item_code=="+item_code+"batch_id=="+batch_id+"patient_id=="+patient_id+"encounter_id=="+encounter_id+"disp_stage=="+disp_stage);
			  if(entry_type =='M' && alert_required_yn =='Y' ){//act_patient_class,remarks_required_yn added for MMS-DM--CRF-0170
                   retval=callManualScanRemarks(patient_id,encounter_id,disp_stage,order_id,order_line_no,item_code,batch_id,act_patient_class,remarks_required_yn);
			  }else if(entry_type=='S' || (entry_type =='M' && alert_required_yn =='N') ){
				  retval= scanBarcodeCount(patient_id,encounter_id,disp_stage,order_id,order_line_no,item_code,batch_id,entry_type,act_patient_class);
			  }
		  }

        if(retval != undefined)
		  dup_count1=dup_count;
	}//ADDED FOR MMS-DM-CRF-0157.1 END
}//KDAH-CRF-0231 & [IN-034551] - Barcode CRF Changes - End

async function GetLookup(target, call_from){//RUT-CRF-0035 [IN029926] Added for PIN Validation  - begin
	var sql="";			
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;			
	var tit				= getLabel("Common.user.label",'Common');
	if(call_from =='MAR' )
		sql = document.frmUserPINAuthorization.sqlForMARUsers.value;
	else
		sql = document.frmUserPINAuthorization.sqlForDispensingUsers.value;
	
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	= target.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	document.forms[0].user_id.value="";
	target.value="";
	if(retVal != null && retVal != "" )	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		document.forms[0].user_id.value=arr[0];
	}
}

function GetLookupBlur(target,call_from){
	if(target.value != ""){
		GetLookup(target,call_from);
	}
	else{
		document.forms[0].user_id.value="";
		//parent.result.location.href="../../eCommon/html/blank.html";
	}
	document.frmUserPINAuthorization.user_pin.value="";	// Added for [IN:045580] 
}

function validateUserAuthPIN(call_from){
	var bean_id		=	document.frmUserPINAuthorization.bean_id.value;
	var bean_name	=	document.frmUserPINAuthorization.bean_name.value;
	var locale		=	document.frmUserPINAuthorization.locale.value;
	var user_name	=	encodeURIComponent(document.frmUserPINAuthorization.user_name.value);
	var PIN			=	document.frmUserPINAuthorization.user_pin.value;
	var user_id		=	document.frmUserPINAuthorization.user_id.value;
	var witness		=	document.frmUserPINAuthorization.witness.value;		// Added for AAKH-CRF-0023[IN:038259]
	var patient_id		=	document.frmUserPINAuthorization.patient_id.value;		// Added for AAKH-CRF-0023[IN:038259]
	var encounter_id	=	document.frmUserPINAuthorization.encounter_id.value;		// Added for AAKH-CRF-0023[IN:038259]
	var labelStr	=	document.getElementById("user_id1").innerText;
	var disp_locn_code	=	document.frmUserPINAuthorization.disp_locn_code.value;
	var disp_category	=	document.frmUserPINAuthorization.disp_category.value;
	labelStr=document.getElementById("user_id1").innerText;
	if(trimString(user_name)==""){
		alert(getMessage("CAN_NOT_BE_BLANK","Common").replace('$',labelStr));
		document.frmUserPINAuthorization.user_name.focus();
		return;
	}
	if(PIN==""){
		alert(getMessage("PIN_PWD_CANNOT_BE_BLANK","PH"));
		document.frmUserPINAuthorization.user_pin.focus();
		return;
	}
	PIN         =encodeURIComponent(PIN,"UTF-8");	
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "locale =\"" + locale + "\" " ;
	xmlStr+= "call_from =\"" + call_from + "\" " ;
	xmlStr+= "witness =\"" + witness + "\" " ;	// Added for AAKH-CRF-0023[IN:038259]
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;	// Added for AAKH-CRF-0023[IN:038259]
	xmlStr+= "encounter_id =\"" + encounter_id + "\" " ;	// Added for AAKH-CRF-0023[IN:038259]
	xmlStr+= "user_id =\"" + user_id + "\" " ;
	xmlStr+= "user_name =\"" + user_name + "\" " ;
	xmlStr+= "PIN =\"" + PIN + "\" " ;
	xmlStr+= "disp_locn_code =\"" + disp_locn_code + "\" " ;
	xmlStr+= "disp_category =\"" + disp_category + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=userPINAuthValidation";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	if(trimString(responseText)=="0"){
		alert(getMessage("PH_INVALID_USER_PIN","PH").replace('#',labelStr));
		document.frmUserPINAuthorization.user_pin.focus();
		return false;
	}
	else{
		window.returnValue=responseText;
		window.close();
	}
}

function storeUserinBean(auth_user_id){
	var xmlStr ="<root><SEARCH ";
	xmlStr+= " bean_id =\"DispMedicationAllStages\" " ;
	xmlStr+= " bean_name=\"ePH.DispMedicationAllStages\" " ;
	xmlStr+= "auth_user_id =\"" + auth_user_id + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=storeAuthUserInBean";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}//RUT-CRF-0035 [IN029926] Added for PIN Validation  - end

async function openAltDrugRemarks(order_id, order_line_num, alt_drug_remarks_ind,callFrom ){// Added For Bru-HIMS-CRF-082 [IN:029948]-start
	var dialogHeight= "15" ;
	var dialogWidth	= "40" ;
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retRem = await window.showModalDialog("../../ePH/jsp/DispMedicationRemarks.jsp?alt_drug_remarks_ind="+alt_drug_remarks_ind+"&order_id="+order_id+"&order_line_num="+order_line_num,arguments,features);
	if(callFrom!='LINK'){
		if(retRem!="Y" && alt_drug_remarks_ind=='M' )
			openAltDrugRemarks(order_id, order_line_num, alt_drug_remarks_ind, callFrom );
		return retRem;
	}
	//if(retRem!="Y" && alt_drug_remarks_ind=='M')
	//	openAltDrugRemarks(order_id, order_line_num, alt_drug_remarks_ind );
}

function saveRemarks(){
	var forObj = document.DispMedicationRemarks;
	var alt_drug_remarks_ind = forObj.alt_drug_remarks_ind.value;
	if(forObj.alt_drug_remarks.value=="" && alt_drug_remarks_ind=='M'){
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
	    msg = msg.replace('$', getLabel("ePH.AltDrugRemarks.label","PH"));
		alert(msg);
		return false;
	}
	var order_id = forObj.order_id.value;
	var order_line_num = forObj.order_line_num.value;
	var alt_drug_remarks =encodeURIComponent(forObj.alt_drug_remarks.value,"UTF-8") ;
	var xmlStr ="<root><SEARCH ";
	xmlStr+= " bean_id =\"DispMedicationAllStages\" " ;
	xmlStr+= " bean_name=\"ePH.DispMedicationAllStages\" " ;
	xmlStr+= "order_id =\"" + order_id + "\" " ;
	xmlStr+= "order_line_num =\"" + order_line_num + "\" " ;
	xmlStr+= "alt_drug_remarks =\"" + alt_drug_remarks + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=storeAltDrugRemarks";
	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	forObj.alt_drug_remarks_yn.value = "Y";
	window.returnValue="Y";
	window.close();
}// Added For Bru-HIMS-CRF-082 [IN:029948]-end

function displayPayeeIndicator(display_yn){ //function added for Bru-HIMS-CRF-094-DD1 [IN:047224]
	var lblpayingPatient = parent.parent.frames[1].patient_details.document.getElementById("payingPatient");
	if(display_yn=='Y')
		lblpayingPatient.style.display='inline';
	else
		lblpayingPatient.style.display='none';
}

async function callMedicationPlanner(patient_id,encounter_id,med_plan_check,mediplan_seq_no){//Added for Bru-HIMS-CRF-072.1[IN 049144] start
	var dialogHeight	= "70vh" ;
	var dialogWidth	    = "70vw";
	var dialogTop	    = "10" ;
	var dialogLeft	    = "10" ;
	var center			= "0" ;
	var status			= "no";
	var scroll			= "yes";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+ ";scroll "+scroll;
	var arguments	    = "";
	var retVal          = await top.window.showModalDialog("../../ePH/jsp/MedicationPlannerFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&med_plan_check="+med_plan_check+"&mediplan_seq_no="+mediplan_seq_no,arguments,features);
}
async function callActiveOrders_Plan(patient_id,encounter_id,generic_id,patient_class,med_plan_check)	{
	var sel_lang = parent.f_medication_plan.document.formMedicationPlanner.sel_Language.value;
	var dialogHeight= "22" ;
	var dialogWidth	= "60" ;
	var dialogTop = "250" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionActiveOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&called_frm=PH"+"&patient_class="+patient_class+"&called_from=MediPlan",arguments,features);
	if(retVal=='OK'){
		parent.f_medication_plan.document.location.href="../../ePH/jsp/MedicationPlanner.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&med_plan_check="+med_plan_check+"&sel_lang="+sel_lang;
	}
}
async function recordMediPlan(called_from,mediplan_seq_no){
	formObj	=	parent.f_medication_plan.document.formMedicationPlanner;
	var curr_drug_count = false;	
	for(var i=0;i<eval("formObj.chkdrug").length;i++){
		if(eval("formObj.chkdrug")[i].checked == true && (formObj.link.value==eval("formObj.locale")[i].value)){
			if(trimString(eval("formObj.txt_qty")[i].value)==""){
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_QTY_ISSUE","PH");
				eval("formObj.txt_qty")[i].focus();
				return ;
			}
			/*val1 = trimString(eval("formObj.txt_morning")[i].value);// Commented for ML-BRU-SCF-1465[IN:052640] Remove this validation for all cases
			val2 = trimString(eval("formObj.txt_afternoon")[i].value);
			val3 = trimString(eval("formObj.txt_evening")[i].value);
			val4 = trimString(eval("formObj.txt_night")[i].value);
			if(val1=="" && val2=="" && val3=="" && val4==""){
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_DOSAGE","PH");
				eval("formObj.txt_morning")[i].focus();
				return ;
			}*/
		}
	}
	var record 	= new Array();
	for(var i=0;i<eval("formObj.chkdrug").length;i++){
		if(eval("formObj.chkdrug")[i].checked == true){
			eval("formObj.chkdrug")[i].value = 'E';
			if(formObj.link.value==eval("formObj.locale")[i].value)
				record[i] = "Y";
			else 
				record[i] = "N";
		}
		else{
			eval("formObj.chkdrug")[i].value = 'D';
			record[i] = "N";
		}
		if(eval("formObj.curr_disp_yn")[i].value=="Y" && record[i] == "Y")
			curr_drug_count = true;
	}
	if(curr_drug_count){
		for(var i=0;i<eval("formObj.chkdrug").length;i++){
				var xmlStr = "<root><SEARCH ";
				xmlStr+= "pres_drug_code  =\"" + eval("formObj.pres_drug_code")[i].value+ "\" " ;
				xmlStr+= "disp_drug_code  =\"" + eval("formObj.disp_drug_code")[i].value+ "\" " ;
				xmlStr+= "order_id =\"" + eval("formObj.order_id")[i].value + "\" " ;
				xmlStr+= "order_line_no  =\"" + eval("formObj.order_line_no")[i].value + "\" " ;
				xmlStr+= "drug_name =\"" + encodeURIComponent(eval("formObj.drug_name")[i].value) + "\" " ;
				xmlStr+= "drug_name_local =\"" + encodeURIComponent(eval("formObj.drug_name")[i].value) + "\" " ;
				xmlStr+= "drug_code =\"" + eval("formObj.disp_drug_code")[i].value + "\" " ;
				xmlStr+= "qty_issue  =\"" + encodeURIComponent(eval("formObj.txt_qty")[i].value) + "\" " ;
				xmlStr+= "qty_issuelocal  =\"" + encodeURIComponent(eval("formObj.txt_qty")[i].value) + "\" " ;
				xmlStr+= "morning =\"" + encodeURIComponent(eval("formObj.txt_morning")[i].value) + "\" " ;
				xmlStr+= "afternoon =\"" + encodeURIComponent(eval("formObj.txt_afternoon")[i].value) + "\" " ;
				xmlStr+= "evening =\"" + encodeURIComponent(eval("formObj.txt_evening")[i].value) + "\" " ;
				xmlStr+= "night =\"" + encodeURIComponent(eval("formObj.txt_night")[i].value) + "\" " ;
				xmlStr+= "morninglocal =\"" + encodeURIComponent(eval("formObj.txt_morning")[i].value) + "\" " ;
				xmlStr+= "afternoonlocal =\"" + encodeURIComponent(eval("formObj.txt_afternoon")[i].value) + "\" " ;
				xmlStr+= "eveninglocal =\"" + encodeURIComponent(eval("formObj.txt_evening")[i].value) + "\" " ;
				xmlStr+= "nightlocal =\"" + encodeURIComponent(eval("formObj.txt_night")[i].value) + "\" " ;
				xmlStr+= "howtotake =\"" + encodeURIComponent(eval("formObj.txt_howtotake")[i].value) + "\" " ;
				xmlStr+= "howtotakelocal =\"" + encodeURIComponent(eval("formObj.txt_howtotake")[i].value) + "\" " ;
				xmlStr+= "impnote =\"" + encodeURIComponent(eval("formObj.txt_imp_note")[i].value) + "\" " ;
				xmlStr+= "impnotelocal =\"" + encodeURIComponent(eval("formObj.txt_imp_note")[i].value) + "\" " ;
				xmlStr+= "chkdrug =\"" + eval("formObj.chkdrug")[i].value + "\" " ;
				xmlStr+= "disp_no =\"" + eval("formObj.disp_no")[i].value + "\" " ;
				xmlStr+= "disp_srl_no =\"" + eval("formObj.disp_srl_no")[i].value + "\" " ;
				xmlStr+= "curr_disp_yn  =\"" + eval("formObj.curr_disp_yn")[i].value + "\" " ;
				xmlStr+= "merge_yn  =\"" + eval("formObj.merged_yn")[i].value + "\" " ;
				xmlStr+= "merged_med_plan_id  =\"" + eval("formObj.merged_med_plan_id")[i].value + "\" " ;
				xmlStr+= "lang_id  =\"" + eval("formObj.locale")[i].value + "\" " ;
				xmlStr+= "encounter_id  =\"" + eval("formObj.encounter_id").value + "\" " ;
				xmlStr+= "patient_id  =\"" + eval("formObj.patient_id").value + "\" " ;
				xmlStr+= "recorded  =\"" + record[i] + "\" " ;
				xmlStr+= "link  =\"" + formObj.link.value + "\" " ;
				xmlStr+= "bean_id =\"DispMedicationAllStages\" " ;
				xmlStr+= "bean_name=\"ePH.DispMedicationAllStages\" " ;
				xmlStr +=" /></root>";
				var temp_jsp="DispMedicationValidation.jsp?func_mode=recordDrug";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false); 
				xmlHttp.send(xmlDoc);
		}
		if(called_from=="printDialog"){
			await updateMedPlan(mediplan_seq_no,eval("formObj.patient_id").value,eval("formObj.encounter_id").value);
		}
		else if(called_from=="Print"){
			await updateMedPlan(mediplan_seq_no,eval("formObj.patient_id").value,eval("formObj.encounter_id").value);
			
			var dialogHeight	= "30" ;
			var dialogWidth	    = "80";
			var dialogTop	    = "150" ;
			var dialogLeft	    = "30" ;
			var center			= "0" ;
			var status			= "no";
			var scroll			= "yes";
			var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+ ";scroll "+scroll;
			var arguments	    = "";
			retVal          = await window.showModalDialog("../../ePH/jsp/MedicationPlannerPrint.jsp?patient_id="+formObj.patient_id.value,arguments,features);
		}
		window.close();
	}
	else{
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_CURR_DRUG","PH");
		return ;
	}
}
function enablelocale(label){	
	if(label!=""){
		formObj	=	parent.f_medication_plan.document.formMedicationPlanner;
		var mergecount_primary = formObj.mergecount_primary.value;
		var mergecount_local = formObj.mergecount_local.value;
		if(label=="en"){
			formObj.document.getElementById("table_locale_eng").style.display="inline";
			formObj.document.getElementById("table_locale_loc").style.display="none";
			formObj.link.value = label;
			formObj.document.getElementById("Hospname").innerHTML = formObj.strname.value;
			formObj.document.getElementById("facility_displocn").innerHTML = formObj.facility_disp.value;
			formObj.document.getElementById("mediplan").innerHTML = "Medication Plan Sheet";
			formObj.document.getElementById("tdMergeLocal").style.display="none";// Added for [IN:051822] 
			if(parseInt(mergecount_primary)>0)
				formObj.document.getElementById("tdMerge").style.display="inline";
		}
		else{
			formObj.document.getElementById("table_locale_eng").style.display="none";
			formObj.document.getElementById("table_locale_loc").style.display="inline";
			formObj.link.value = label;
			formObj.document.getElementById("Hospname").innerHTML = formObj.strnamelocal.value;
			formObj.document.getElementById("facility_displocn").innerHTML = formObj.facility_displocal.value;
			formObj.document.getElementById("mediplan").innerHTML = "Pelan Medikasi";
			formObj.document.getElementById("tdMerge").style.display="none";// Added for [IN:051822]
			if(parseInt(mergecount_local)>0)
				formObj.document.getElementById("tdMergeLocal").style.display="inline";
		}	
	}	
}

function loadHeader(label){
	if(label!=""){
		formObj	=	parent.f_medication_plan;
		if(label=="en"){
			formObj.document.getElementById("Hospname").innerHTML = formObj.strname.value;
			formObj.document.getElementById("facility_displocn").innerHTML = formObj.facility_disp.value;
			formObj.document.getElementById("mediplan").innerHTML = "Medication Plan Sheet";
		}else{
			formObj.document.getElementById("Hospname").innerHTML = formObj.strnamelocal.value;
			formObj.document.getElementById("facility_displocn").innerHTML = formObj.facility_displocal.value;
			formObj.document.getElementById("mediplan").innerHTML = "Pelan Medikasi";
		}
	}
}

async function callMedplanCheck(formObj,patient_id,patient_class){
	if(formObj.med_plan!=null || formObj.med_plan!=undefined){
		if(formObj.med_plan.checked==true && patient_class=="OP")
			await callMedicationPlanner(patient_id,'','Y', ''); // ,'' ML-BRU-SCF-1490 [IN:052770]
	}
}
async function callMergeMedPlan(patient_id,encounter_id,med_plan_id_max,med_plan_check){
	var sel_lang = parent.f_medication_plan.document.formMedicationPlanner.sel_Language.value;
	var dialogHeight= "25" ;
	var dialogWidth	= "75" ;
	var dialogTop = "200" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/MedicationPlannerMerge.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&med_plan_id_max="+med_plan_id_max+"&sel_lang="+sel_lang,arguments,features);
	if(retVal=='OK'){
		parent.f_medication_plan.document.location.href="../../ePH/jsp/MedicationPlanner.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&med_plan_check="+med_plan_check+"&sel_lang="+sel_lang;
	}
}

function recordMergeMedPlan(){
	var formObj=parent.document.formMergeMedicationPlanner;
	var checked=false;
	for(var i=0;i<eval("formObj.totalrecords").value;i++){
		if(eval("formObj.chkdrug"+i).checked==true){
			checked=true;
			var xmlStr = "<root><SEARCH ";
			xmlStr+= "drug_code  =\"" + eval("formObj.disp_drug_code"+i).value+ "\" " ;
			xmlStr+= "pres_drug_code  =\"" + eval("formObj.pres_drug_code"+i).value+ "\" " ;
			xmlStr+= "disp_drug_code  =\"" + eval("formObj.disp_drug_code"+i).value+ "\" " ;
			xmlStr+= "order_id =\"" + eval("formObj.order_id"+i).value + "\" " ;
			xmlStr+= "order_line_no  =\"" + eval("formObj.order_line_no"+i).value + "\" " ;
			xmlStr+= "drug_name =\"" + encodeURIComponent(eval("formObj.drug_name"+i).value) + "\" " ;
			xmlStr+= "drug_name_local =\"" + encodeURIComponent(eval("formObj.drug_name_local"+i).value) + "\" " ;
			xmlStr+= "qty_issue  =\"" + encodeURIComponent(eval("formObj.qty_issue"+i).value) + "\" " ;
			xmlStr+= "qty_issuelocal  =\"" + encodeURIComponent(eval("formObj.qty_issuelocal"+i).value) + "\" " ;
			xmlStr+= "lang_id  =\"" + eval("formObj.locale"+i).value + "\" " ;
			xmlStr+= "encounter_id  =\"" + eval("formObj.encounter_id").value + "\" " ;
			xmlStr+= "patient_id  =\"" + eval("formObj.patient_id").value + "\" " ;
			xmlStr+= "morning =\"" + encodeURIComponent(eval("formObj.morning"+i).value) + "\" " ;
			xmlStr+= "afternoon =\"" + encodeURIComponent(eval("formObj.afternoon"+i).value) + "\" " ;
			xmlStr+= "evening =\"" + encodeURIComponent(eval("formObj.evening"+i).value) + "\" " ;
			xmlStr+= "night =\"" + encodeURIComponent(eval("formObj.night"+i).value) + "\" " ;
			xmlStr+= "morninglocal =\"" + encodeURIComponent(eval("formObj.morninglocal"+i).value) + "\" " ;
			xmlStr+= "afternoonlocal =\"" + encodeURIComponent(eval("formObj.afternoonlocal"+i).value) + "\" " ;
			xmlStr+= "eveninglocal =\"" + encodeURIComponent(eval("formObj.eveninglocal"+i).value) + "\" " ;
			xmlStr+= "nightlocal =\"" + encodeURIComponent(eval("formObj.nightlocal"+i).value) + "\" " ;
			xmlStr+= "howtotake =\"" + encodeURIComponent(eval("formObj.howtotake"+i).value) + "\" " ;
			xmlStr+= "howtotakelocal =\"" + encodeURIComponent(eval("formObj.howtotakelocal"+i).value) + "\" " ;
			xmlStr+= "impnote =\"" + encodeURIComponent(eval("formObj.impnote"+i).value) + "\" " ;
			xmlStr+= "impnotelocal =\"" + encodeURIComponent(eval("formObj.impnotelocal"+i).value) + "\" " ;
			xmlStr+= "chkdrug =\"" + eval("formObj.chkdrug"+i).value + "\" " ;
			xmlStr+= "disp_no =\"" + eval("formObj.disp_no"+i).value + "\" " ;
			xmlStr+= "disp_srl_no =\"" + eval("formObj.disp_srl_no"+i).value + "\" " ;
			xmlStr+= "curr_disp_yn  =\"N\" " ;
			xmlStr+= "merge_yn  =\"Y\" " ;
			xmlStr+= "merged_med_plan_id  =\"" + eval("formObj.merged_med_plan_id"+i).value + "\" " ;
			xmlStr+= "bean_id =\"DispMedicationAllStages\" " ;
			xmlStr+= "bean_name=\"ePH.DispMedicationAllStages\" " ;
			xmlStr +=" /></root>";
			var temp_jsp="DispMedicationValidation.jsp?func_mode=recordDrug";
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
}

function updateMedPlan(mediplan_seq_no,patient_id){
	if(mediplan_seq_no == undefined) //Added for ML-BRU-SCF-1490 [IN:052770]
		mediplan_seq_no ='';
	var xmlStr = "<root><SEARCH ";
	xmlStr+= "mediplan_seq_no  =\"" + mediplan_seq_no + "\" " ;
	xmlStr+= "patient_id  =\"" + patient_id + "\" " ;
	xmlStr+= "bean_id =\"DispMedicationAllStages\" " ;
	xmlStr+= "bean_name=\"ePH.DispMedicationAllStages\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=updateMedPlan";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false); 
	xmlHttp.send(xmlDoc);
}

function selectDrug(orderid,orderlineno,drugcode,obj,index){
	var compare = orderid+"~"+orderlineno+"~"+drugcode;
	formObj	=	parent.f_medication_plan.document.formMedicationPlanner;
	if(formObj.link.value=="Both"){
		for(var i=0;i<eval("formObj.chkdrug").length;i++){
			value = eval("formObj.order_id")[i].value+"~"+eval("formObj.order_line_no")[i].value+"~"+eval("formObj.disp_drug_code")[i].value;
			if(compare==value && i!=index){
				if(obj.checked==true)
					eval("formObj.chkdrug")[i].checked=true;
				else
					eval("formObj.chkdrug")[i].checked=false;
				break;
			}
		}
	}
	
}
function doCancel(){
	var xmlStr = "<root><SEARCH ";
	xmlStr+= "bean_id =\"DispMedicationAllStages\" " ;
	xmlStr+= "bean_name=\"ePH.DispMedicationAllStages\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="DispMedicationValidation.jsp?func_mode=cancelDrug";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false); 
	xmlHttp.send(xmlDoc);
	window.close();
}
function checkMaxLimit_textarea(obj,maxLeng,label) { 
	var value = obj.value;
	if(obj.value.length > maxLeng){
		var msg="";
		msg= label +" " +getLabel("ePH.Cannotexceed.label","PH") + " "+maxLeng + " " + getLabel("ePH.characters.label","PH");
		alert(msg);
		obj.value = value.substr(0,maxLeng);
	}
}//Added for Bru-HIMS-CRF-072.1[IN 049144] end
function checkMaxLimitTextarea(obj,maxLeng) { 
	var value = obj.value;
	if(obj.value.length > maxLeng){
		var msg="";
		msg= getLabel("ePH.Cannotexceed.label","PH") + " "+maxLeng + " " + getLabel("ePH.characters.label","PH");
		alert(msg);
		obj.select();
		obj.focus();		
	}
}
function setlabelLangId(obj, callFrom){ //added for Bru-HIMS-CRF-414 [IN:045554]
	var formObj, labelLangId;
	if(callFrom == 'PRINT'){
		formObj = document.DispMedicationPrintDialog;
		labelLangId = formObj.printDialogLang.value;
	}
	else{
		formObj = document.DispMedicationEditLabel;
		labelLangId = formObj.labelLanguageId.value;
	}
	var allow_edit_disp_label = formObj.allow_edit_disp_label.value;
	if(allow_edit_disp_label =='Y'){
		var xmlStr ="";
		xmlStr ="<root><SEARCH " ;
		xmlStr			+= " labelLangId=\""+ labelLangId + "\" ";
		xmlStr +=" /></root>" ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DispMedicationValidation.jsp?func_mode=setlabelLangId", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		if(callFrom == 'PRINT'){
			var params = formObj.params.value;
			parent.editLabelFrame.location.href = "../../ePH/jsp/DispMedicationEditLabel.jsp?"+params+"&callLangChange=Y";
		}
		else{
			var params = formObj.params.value;
			document.location.href = "../../ePH/jsp/DispMedicationEditLabel.jsp?"+params+"&callLangChange=Y";
		}
	}
}


async function amendAltDrug(order_id,order_line_no,drug_code,patient_id,encounter_id,locn_type,locn_code,patientclass,iv_prep_yn){ // Added for JD-CRF-0198 [IN058599] - Start              	 
	if(iv_prep_yn==null || iv_prep_yn=="null")
          iv_prep_yn="";

		var dialogHeight       = "90vh" ;
		var dialogWidth        = "90vw";
		var dialogTop          = "10" ;
		var dialogLeft         = "10" ;
		var center             = "1" ;
		var status             = "no";
		var dialogHeight	   = '90vh' ; 
		var dialogWidth		   = '90vw' ;
		var dialogTop          = '10';
		var dialogLeft         = '10' ;

		var title			   = 'rewe';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var arguments          = "";
		var p_called_from_ca   = "Y";
		var amend_called_from  = "existing_order";
		var pract_reln_id      = "";
		var features           = "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var finalString		   = "function_from=ALTERNATE_ORDER&function_id=ALTERNATE_ORDER&ammend_called_from="+amend_called_from+"&order_id="+order_id+"&patient_id="+patient_id+"&episode_id="+encounter_id+"&pract_reln_id="+pract_reln_id+"&location_type="+locn_type+"&location_code="+locn_code+"&patient_class="+patientclass+"&p_called_from_ca="+p_called_from_ca+"&Sex=&Age=&Dob=&visit_adm_date=&iv_prep_yn=";

		var retVals = await top.window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);
		window.returnValue="ALTER";
		 window.close();
}  // Added for JD-CRF-0198[IN058599] - End

//added for ml-mmoh-crf-0468 start
function bachChange(obj){
	
	    var x =document.fromDispMedicationWSLabel.batch_id.selectedIndex;
	   
	    document.fromDispMedicationWSLabel.expiry_date.selectedIndex=x;
}
function clearlastScanned(recCount){ // Added for GHL-CRF-0463 - Start
	if(eval("document.DispMedicationAllStages.last_scanned_"+recCount)!=undefined ) // document.DispMedicationAllStages.last_scanned!=undefined  chnaged to eval("formObj.last_scanned_"+recCount).value!=undefined for MMS-DM-SCF-0488
		eval("document.DispMedicationAllStages.last_scanned_"+recCount).value=""; //document.DispMedicationAllStages.last_scanned.value chnaged to eval("document.DispMedicationAllStages.last_scanned_"+recCount).value for MMS-DM-SCF-0488
} // Added for GHL-CRF-0463 - End
//added for ml-mmoh-crf-0468 end
function scanMoreThanPresc(patient_id,order_id,disp_stage,alt_drug_code,barcode_id){ // Added for GHL-SCF-1293 - Start
	if(confirm(getMessage("ALLOC_QTY_GRT_PRES_QTY","PH"))){
		callBarcodeflg('',patient_id,order_id,disp_stage,alt_drug_code,"Y",barcode_id);//'' added for MMS-DM-CRF-157.1
    }
	else{
		valid = false;
	}
	
} // Added for GHL-SCF-1293 -End

function printDispenseFocus(){//KDAH-SCF-0558
if(document.frmPrintDialogButtons.disp_sheet!=undefined)
document.frmPrintDialogButtons.disp_sheet.focus();
}

async function showDispInractionDtl(patient_id,encounter_id,drug_code,form_code,generic_id,start_date,end_date,drug_name,form_desc,order_id,order_line_no,allergy_cnt,patient_class,disp_medication){ // Added for  MMS-KH-CRF-0013 [IN:067952] - Start	
	//order_id,order_line_no,allergy_cnt,patient_class,disp_medication addded for IN070605
	var retVal;
	var dialogTop		= "170";
 	var dialogHeight	= "32" ;
 	var dialogWidth		= "50" ;
	var dialogLeft		= "375" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		=getLabel("Common.DrugInteraction.label",'Common'); 
 	retVal 				=    await window.showModalDialog("../../ePH/jsp/DispDrugInteractionFrameset.jsp?called_from=normal&calledFrom=DISPINTRACTIONDTLS"+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&drug_code="+drug_code+"&form_code="+form_code+"&generic_id="+generic_id+"&start_date="+start_date+"&end_date="+end_date+"&drug_name="+drug_name+"&form_desc="+form_desc+"&order_id="+order_id+"&order_line_no="+order_line_no+"&allergy_cnt="+allergy_cnt+"&patient_class="+patient_class+"&disp_medication="+disp_medication,arguments,features);

 	//added for IN070605 start
 	if(retVal!="" && retVal != null){
 	
 		document.getElementById("INTARACTION"+allergy_cnt).innerHTML = "<img src='../../ePH/images/Pink.jpg'>";
 		document.getElementById("INTARACTION_VALUE"+allergy_cnt).value="Y";
 	}
 	//added for IN070605 end
} // Added for  MMS-KH-CRF-0013 [IN:067952] - End
//Adding start for MMS-DM-CRF-0157.1
async function callManualScanRemarks(patient_id,encounter_id,disp_stage,order_id,order_line_no,item_code,batch_id,act_patient_class,remarks_required_yn){
	//alert("option_lisvar bean_id      =  formObj.bean_id.value;
	var module_id    = "PH";
	var menu_id      = "DISPENSE_MEDICATION"
	var entry_type   ="M";
	var sub_menu_id  ="";
    if(disp_stage =="A")
        sub_menu_id ='ALLOCATION'
	else if(disp_stage =="AS")
        sub_menu_id ='ALL STAGES'
	else if(disp_stage =="F")
         sub_menu_id ='FILL STAGE'
	var	bean_id				=	"DispMedicationBean" ;
	var	bean_name			=	"ePH.DispMedicationBean";

	//alert("formObj=="+formObj)
	var retVal = new String();
	var dialogHeight= "17" ;                                                 
	
	var dialogWidth              = "40" ;

	var status = "no";                                             
	var features       = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto; status:" + status; 
	retVal =await window.showModalDialog("../../eOR/jsp/BarCodeManualEntryReason.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&module_id="+module_id+"&menu_id="+menu_id+"&sub_menu_id="+sub_menu_id+"&entry_type="+entry_type+"&order_id="+order_id+"&order_line_no="+order_line_no+"&item_code="+item_code+"&batch_id="+batch_id+"&remarks_mandetory_yn="+remarks_required_yn+"&patient_class="+act_patient_class,arguments,features);
	//alert("retVal@@@111==="+retVal)//+"&encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&module_id="+module_id+"&sub_menu_id="+sub_menu_id
		return retVal;

}
function scanBarcodeCount(patient_id,encounter_id,disp_stage,order_id,order_line_no,item_code,batch_id,entry_type,act_patient_class,remarks_required_yn){
	var module_id    = "PH";
	var menu_id      = "DISPENSE_MEDICATION"
	//var entry_type   ="S";//commented for MMs-DM-CRF-0170
	var sub_menu_id  ="";
    if(disp_stage =="A")
        sub_menu_id ='ALLOCATION'
	else if(disp_stage =="AS")
        sub_menu_id ='ALL STAGES'
	else if(disp_stage =="F")
         sub_menu_id ='FILL STAGE'
	var	bean_id				=	"DispMedicationBean" ;
	var	bean_name			=	"ePH.DispMedicationBean";


		var xmlDoc  = "";
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " patient_id=\""+patient_id+"\"";
		xmlStr += " encounter_id=\""+encounter_id+"\"";
		xmlStr += " menu_id=\""+menu_id+"\"";
		xmlStr += " module_id=\""+module_id+"\"";
        xmlStr += " entry_type=\""+entry_type+"\"";
		xmlStr += " sub_menu_id=\""+sub_menu_id+"\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
        xmlStr += " order_id=\""+order_id+"\"";
		xmlStr += " order_line_no=\""+order_line_no+"\"";
		xmlStr += " item_code=\""+item_code+"\"";
		xmlStr += " batch_id=\""+batch_id+"\"";
		xmlStr += " patient_class=\""+act_patient_class+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
		xmlHttp.open("POST","../../eOR/jsp/BarCodeManualEntryReasonSave.jsp?",false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText;
		return true;
}
//Adding end for MMS-DM-CRF-157.1

//added and removed for dgb issue and code moved to Prescriptiontest.js for IN070605 END
/*
function drugindication_remarks_disp(calling_func,order_id,order_line_no,allergy_cnt){
	var formobj		=	document.prescription_close_form;
	var formobj1		=	document.prescription_dosage_monograph;
	var ReviewRemarks;
	if(calling_func=="doselimit"){
		
		 ReviewRemarks	=	formobj1.ReviewRemarks.value;	
	}else{
		 ReviewRemarks	=	formobj.ReviewRemarks.value;	
	}
	
	var dialogHeight= "12" ;
	var dialogWidth	= "35" ;
	var dialogTop = "300" ;
	var dialogLeft ="10";
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "" ;
	retVal = window.showModalDialog("../../ePH/jsp/ReviewApproveRemarks.jsp?ReviewRemarks="+encodeURIComponent(ReviewRemarks)+"&calling_func="+calling_func+"&order_id="+order_id+"&order_line_no="+order_line_no+"&allergy_cnt="+allergy_cnt,arguments,features);
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
	var temp_jsp="DispMedicationValidation.jsp?func_mode=updateReviewDetails&order_id="+order_id+"&order_line_no="+order_line_no+"&allergy_cnt="+allergy_cnt+"&alergy_details="+alergy_details+"&duplicate_details="+duplicate_details+"&dosage_details="+dosage_details+"&intaraction_details="+intaraction_details;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false); 
	xmlHttp.send(xmlDoc);
	window.close();

}

function checkDrugIndMaxLimit(obj,maxLeng) { 
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("ePH.DrugIndications.label","PH"));
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
	window.returnValue=drug_indication_new;
}
*/
//added and removed for dgb issue and code moved to Prescriptiontest.js for IN070605 END

//MMS-KH-CRF-0030 - start
function getAlternateDrug(drug_code,drug_desc,patient_id,order_id,order_line_no,source,store_code,qty_reqd,eff_expiry, main_strength_uom,rec_no, alt_drug_remarks_ind,expiry_date,patient_class,allow_aleternate_yn,item_type_site, strength_value, iv_prep_yn,disp_medication_alt,disp_stage,main_screen_yn,classvalue,generic_id,barcode_flg){

	var prescribed_strength = eval("document.DispMedicationAllStages.prescribed_strength_"+rec_no).value;
	//var bms_strength = eval("document.DispMedicationAllStages.bms_strength_"+rec_no).value;
	
	var bean_id		= "DispMedicationBean" ;
	var bean_name	= "ePH.DispMedicationBean";	
		
	if(eval(document.getElementById("alternate_"+rec_no)).style.display=="none"){

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "store_code =\"" + store_code + "\" " ;
	xmlStr+= "qty_reqd =\"" + qty_reqd + "\" " ;
	xmlStr+= "eff_expiry =\"" + eff_expiry + "\" " ;
	xmlStr+= "generic_id =\"" + generic_id + "\" " ;
	xmlStr+= "drug_code =\"" + drug_code + "\" " ;
	xmlStr+= "strength_value =\"" + strength_value + "\" " ;
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "rec_no =\"" + rec_no + "\" " ;
	xmlStr+= "order_id =\"" + order_id + "\" " ;
	xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
	xmlStr+= "disp_stage =\"" + disp_stage + "\" " ;
	xmlStr+= "prescribed_strength=\"" + prescribed_strength + "\" " ;
	xmlStr+= "classvalue =\"" + classvalue + "\" " ;
	xmlStr+= "barcode_flg =\"" + barcode_flg + "\" " ;

	
	xmlStr +=" /></root>";
	
	var temp_jsp="DispMedicationValidate.jsp?identity=getAlternateDrug&bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;

	eval(responseText);
	return true;
	}
}

function displayAlternateHeader(recCount){
	eval(document.getElementById("alternate_"+recCount)).style.display ="inline";
}
function displayAlternateHeaderBarcode(rec_no,classvalue,barcode_flg,drug_code,order_id,order_line_no){
	 var table = document.getElementById("alternate_header_"+rec_no);
	 
	 if(barcode_flg=="Y"){
	 var row = table.insertRow(0);
	 var cell1 = row.insertCell(0);
	 }
	 var col1 = getLabel("ePH.AlternateDrugNames.label","PH");
	 var col2 = getLabel("Common.item.label","Common");
	 var col3 = getLabel("eST.AvailableQty.label","ST");
	 var col4 = getLabel("Common.defaultSelect.label","Common");
	 var col5 = getLabel("ePH.AllocatedQuantity.label","PH");

	
	if(barcode_flg=="Y"){
	 var row1 = table.insertRow(1);
	}else{
	 var row1 = table.insertRow(0);
	}
	 var cell2 = row1.insertCell(0);
	 cell2.className=classvalue;
	 cell2.width = '200px'
	 var cell3 = row1.insertCell(1);
	 cell3.className=classvalue;
	 cell3.width = '200px'
	 var cell4 = row1.insertCell(2);
	 cell4.className=classvalue;
	 cell4.width = '50px'
	 var cell5 = row1.insertCell(3);
	 cell5.className=classvalue;
	 cell5.width = '50px'
	 var cell6 = row1.insertCell(4);
	 cell6.className=classvalue;
	 cell6.width = '50px'

	 var barcode="barcode_id_"+rec_no;

	if(barcode_flg=="Y")
	{	
	 cell1.innerHTML ="<font style='font-size:10;vertical-align: text-top;'>Barcode</font> <input type='text' maxlength='100' class='fields' name ='"+barcode+"' onkeydown=\"if(event.keyCode==13){validateBarcodeNR(this,'"+rec_no+"','"+order_id+"','"+order_line_no+"','"+drug_code+"')} \" ></td>";

	 
	}
	 cell2.innerHTML ="<td>"+col1+"</td>";
 	 cell3.innerHTML ="<td>"+col2+"</td>";
	 cell4.innerHTML ="<td>"+col3+"</td>";
	 cell5.innerHTML ="<td>"+col4+"</td>";
	 cell6.innerHTML ="<td>"+col5+"</td>";


}

function validateBarcodeNR(obj,rec_no,order_id,order_line_no,drug_code){

  	var bean_id		= "DispMedicationBean" ;
        var bean_name	= "ePH.DispMedicationBean";	
var  store_code			 =  document.DispMedicationAllStages.disp_locn_code.value;//Added for MMS-DM-CRF-0174.5
        var xmlStr ="<root><SEARCH ";
	xmlStr+= "barcode_id =\"" + obj.value + "\" " ;
	xmlStr+= "order_id =\"" + order_id + "\" " ;
	xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
	xmlStr+= "drug_code =\"" + drug_code + "\" " ;
	xmlStr+= "rec_no =\"" + rec_no + "\" " ;
	xmlStr+= "store_code =\"" + store_code + "\" " ;//Added for MMS-DM-CRF-0174.5
		
	
	xmlStr +=" /></root>";
	
	var temp_jsp="DispMedicationValidate.jsp?identity=validateBarcode&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;

	eval(responseText);

}

function displayAlternateFooter(order_id,order_line_no,tot_rec,patient_id,rec_no,disp_stage,store_code,end_date,barcode_flg,drug_code){
	 var table = document.getElementById("alternate_dtl_footer_"+rec_no);
	 var row = table.insertRow(0);
	 var cell1 = row.insertCell(0);
	 
 	 
	 cell1.innerHTML ="<tr><td align='center'><input type='button' value='OK' onClick=\"validateEmptyCheck('"+order_id+"','"+order_line_no+"','"+patient_id+"','"+disp_stage+"','"+store_code+"','"+end_date+"','"+drug_code+"') \">&nbsp;<input type='button' value='Cancel' onClick=\"hideAlternateScreen('"+rec_no+"','"+tot_rec+"','"+barcode_flg+"')\"><input type='hidden' name='total_alt_rec_"+order_id+order_line_no+"' id='total_alt_rec_"+order_id+order_line_no+"' value='"+tot_rec+"' ></td>";


}
function hideAlternateScreen(recCount,tot_rec,barcode_flg){

	for (var i=0;i<parseInt(tot_rec);i++ ){
		document.getElementById("alternate_dtl_header_"+recCount).deleteRow(0);
	}
	 document.getElementById("alternate_dtl_footer_"+recCount).deleteRow(0);
 	 document.getElementById("alternate_header_"+recCount).deleteRow(0);
	 if(barcode_flg=="Y")
	  document.getElementById("alternate_header_"+recCount).deleteRow(0);
	 //document.getElementById("alternate_header_"+recCount).deleteRow(1);
	 
	 eval(document.getElementById("alternate_"+recCount)).style.display ="none";
}

function validateEmptyCheck(order_id,order_line_no,patient_id,disp_stage,store_code,end_date,drug_code){
		valid_flag = true;
		var tot_record = eval("document.DispMedicationAllStages.total_alt_rec_"+order_id+order_line_no).value;
		var alloc_qty="";
		var alt_drug_code="";
		var form_code="";
		var strength_value="";
		var strength_uom="";
		var alt_drug_desc = "";
		for(var cunt=0; cunt<parseInt(tot_record); cunt++) {
		var select_yn = eval("document.DispMedicationAllStages.alt_select_"+order_id+order_line_no+cunt).checked;
			if(select_yn){
				alloc_qty = eval("document.DispMedicationAllStages.alt_alloc_qty_"+order_id+order_line_no+cunt).value;	
				alt_drug_code = eval("document.DispMedicationAllStages.alt_drug_code_"+order_id+order_line_no+cunt).value;	
				form_code = eval("document.DispMedicationAllStages.form_code_"+order_id+order_line_no+cunt).value;	
				strength_value = eval("document.DispMedicationAllStages.strength_value_"+order_id+order_line_no+cunt).value;	
				strength_uom = eval("document.DispMedicationAllStages.strength_uom_"+order_id+order_line_no+cunt).value;	
				alt_drug_desc = eval("document.DispMedicationAllStages.alt_drug_desc_"+order_id+order_line_no+cunt).value;	
				
				if(alloc_qty=="" || alloc_qty=="0")
					valid_flag = false;
					break;
					
			}
		}
		if(!valid_flag){
			alert(getMessage("ALLOC_QTY_CANNOT_BLANK_ZERO","PH"));		
			return false;
		}else{
		
			setAlterDrugDetail(order_id,order_line_no,patient_id,alloc_qty,alt_drug_code,form_code,strength_value,strength_uom,alt_drug_desc,store_code,end_date,drug_code);
			if(disp_stage=="A"){
			parent.f_disp_medication_allocation.location.href="../../ePH/jsp/DispMedicationAllocation.jsp?patient_id="+document.DispMedicationAllStages.patient_id.value+"&encounter_id=DUMMYENCOUNTERID&order_id="+document.DispMedicationAllStages.order_id.value+"&resetQty=true";
			}else if(disp_stage=="F"){
				parent.f_disp_medication_filling.location.href="../../ePH/jsp/DispMedicationFilling.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id;
			}else{
				parent.f_disp_medication_all_stages.location.href="../../ePH/jsp/DispMedicationAllStages.jsp?patient_id="+patient_id+"&encounter_id=DUMMYENCOUNTERID&order_id="+order_id;
			}
		}
	}
function setAlterDrugDetail(order_id,order_line_no,patient_id,alloc_qty,alt_drug_code,form_code,strength_value,strength_uom,alt_drug_desc,store_code,end_date,drug_code){
      
	  	var bean_id		= "DispMedicationBean" ;
	    var bean_name	= "ePH.DispMedicationBean";	

        var xmlStr ="<root><SEARCH ";
		xmlStr+= "alt_drug_code =\"" + alt_drug_code + "\" " ;
		xmlStr+= "patient_id =\"" + patient_id + "\" " ;
		xmlStr+= "alloc_qty =\"" + alloc_qty + "\" " ;
		xmlStr+= "form_code =\"" + form_code + "\" " ;
		xmlStr+= "strength_value =\"" + strength_value + "\" " ;
		xmlStr+= "strength_uom =\"" + strength_uom + "\" " ;
		xmlStr+= "order_id =\"" + order_id + "\" " ;
		xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
		xmlStr+= "store_code =\"" + store_code + "\" " ;
		xmlStr+= "end_date =\"" + end_date + "\" " ;
		xmlStr+= "alt_drug_desc =\"" + encodeURIComponent(alt_drug_desc,"UTF-8") + "\" " ;
		xmlStr+= "drug_code =\"" + drug_code + "\" " ;

	
	xmlStr +=" /></root>";
	
	var temp_jsp="DispMedicationValidate.jsp?identity=setAltDrugDtl&bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;

	eval(responseText);

}


function enableAllocQty(obj,order_id,order_line_no,alt_drug_code,cunt,drug_code){
	if(obj.checked==true){
		var tot_rec = eval("document.DispMedicationAllStages.total_alt_rec_"+order_id+order_line_no).value;
		var alt_flag = true;

		for(i=0;i<parseInt(tot_rec);i++){
			if(i!=parseInt(cunt)){
			 if(eval("document.DispMedicationAllStages.alt_select_"+order_id+order_line_no+i).checked){
				alt_flag = false;
				break;
			 }
			 }
		}
		if(alt_flag){
		  eval("document.DispMedicationAllStages.alt_alloc_qty_"+order_id+order_line_no+cunt).disabled =false; 
		  tot_alt_drug_qty = eval("document.DispMedicationAllStages.tot_alt_drug_qty_"+order_id+order_line_no+cunt).value;			
		}
		else{
		 alert(getMessage("PH_ONLY_ONE_ALT_DRUGS_ALLOWED_MAR","PH"));
		eval("document.DispMedicationAllStages.alt_select_"+order_id+order_line_no+cunt).checked = false;
		 return false;
		}
	}
	else{
		clearBarcodeQty(order_id,order_line_no,drug_code);
		eval("document.DispMedicationAllStages.alt_alloc_qty_"+order_id+order_line_no+cunt).value ="";
		eval("document.DispMedicationAllStages.alt_alloc_qty_"+order_id+order_line_no+cunt).disabled =true; 
	}
}


function displayAlternateDrugDtls(drug_name,alt_drug_code,fmtQty,order_id,order_line_no,cunt,recCount,strength_value, strength_uom,tot_alt_drug_qty,form_code,strength_uom,classvalue,allow_more_qty,drug_code){
	
	
   var table = document.getElementById("alternate_dtl_header_"+recCount);
   var row = table.insertRow(parseInt(cunt));
   var cell1 = row.insertCell(0);
	cell1.className=classvalue;
	cell1.width = '200px'
   var cell2 = row.insertCell(1);
   	cell2.className=classvalue;
   	cell2.width = '200px'
   var cell3 = row.insertCell(2);
   	cell3.className=classvalue;
   	cell3.width = '50px'
   var cell4 = row.insertCell(3);
   	cell4.className=classvalue;
   	cell4.width = '50px'
   var cell5 = row.insertCell(4);
   	cell5.className=classvalue;
	cell5.width = '50px'

	cell1.innerHTML ="<td>"+decodeURIComponent(drug_name,"UTF-8")+" "+strength_value +" " +strength_uom+ "</td>";
    cell2.innerHTML = "<td>"+decodeURIComponent(drug_name,"UTF-8")+"</td>";
    cell3.innerHTML = "<td>"+fmtQty+"</td>";
    cell4.innerHTML = "<td><input type='checkbox' name='alt_select_"+order_id+order_line_no+cunt+"' id='alt_select_"+order_id+order_line_no+cunt+"'  onClick=\"enableAllocQty(this,'"+order_id+"','"+order_line_no+"','"+alt_drug_code+"','"+cunt+"','"+drug_code+"') \"></td>";
    cell5.innerHTML = "<td><input type='text' size='5%' onKeyPress='if(event.keyCode!=13) {return allowValidNumber(this,event,6,0);}else{return false;}' oncopy='return false' onpaste='return false'   name='alt_alloc_qty_"+order_id+order_line_no+cunt+"' id='alt_alloc_qty_"+order_id+order_line_no+cunt+"' disabled onchange=\"validateAltQty(this,'"+order_id+"','"+order_line_no+"','"+alt_drug_code+"','"+cunt+"','"+fmtQty+"','"+drug_code+"') \"><input type='hidden' name='tot_alt_drug_qty_"+order_id+order_line_no+cunt+"' id='tot_alt_drug_qty_"+order_id+order_line_no+cunt+"' value='"+tot_alt_drug_qty+"'><input type='hidden' name='alt_drug_code_"+order_id+order_line_no+cunt+"' id='alt_drug_code_"+order_id+order_line_no+cunt+"' value='"+alt_drug_code+"'><input type='hidden' name='alt_drug_desc_"+order_id+order_line_no+cunt+"' id='alt_drug_desc_"+order_id+order_line_no+cunt+"' value='"+decodeURIComponent(drug_name,"UTF-8")+"'><input type='hidden' name='form_code_"+order_id+order_line_no+cunt+"' id='form_code_"+order_id+order_line_no+cunt+"' value='"+form_code+"'><input type='hidden' name='strength_uom_"+order_id+order_line_no+cunt+"' id='strength_uom_"+order_id+order_line_no+cunt+"' value='"+strength_uom+"'><input type='hidden' name='strength_value_"+order_id+order_line_no+cunt+"' id='strength_value_"+order_id+order_line_no+cunt+"' value='"+strength_value+"'><input type='hidden' name='allow_more_qty_"+order_id+order_line_no+cunt+"' id='allow_more_qty_"+order_id+order_line_no+cunt+"' value='"+allow_more_qty+"'></td>";

}
function validateAltQty(obj,order_id,order_line_no,alt_drug_code,cunt,avail_qty,drug_code){

	if(obj.value!=""){
	  var alloc_qty = parseInt(obj.value);
	  var max_allowed_qty = eval("document.DispMedicationAllStages.tot_alt_drug_qty_"+order_id+order_line_no+cunt).value;

	  var allow_more_qty = eval("document.DispMedicationAllStages.allow_more_qty_"+order_id+order_line_no+cunt).value;

	  if(alloc_qty>parseInt(avail_qty)){
	  alert(getMessage("INSUFFICIENT_BATCH_QTY","PH"));
  	   eval("document.DispMedicationAllStages.alt_alloc_qty_"+order_id+order_line_no+cunt).focus();
	  return false;
	  }
	  else if(alloc_qty>parseInt(max_allowed_qty)){
	
		   if(allow_more_qty!="Y"){
			   alert(getMessage("PH_ALLOC_QTY_LESS_BMS_QTY","PH"));
	  		   eval("document.DispMedicationAllStages.alt_alloc_qty_"+order_id+order_line_no+cunt).value = 0;
	 		   eval("document.DispMedicationAllStages.alt_alloc_qty_"+order_id+order_line_no+cunt).focus();
			return false;
			}else{
			   if(confirm(getMessage("ALLOC_QTY_GRT_PRES_QTY","PH"))){
				   eval("document.DispMedicationAllStages.alt_alloc_qty_"+order_id+order_line_no+cunt).value = obj.value;
			   }else{
				   eval("document.DispMedicationAllStages.alt_alloc_qty_"+order_id+order_line_no+cunt).value = 0;
				   eval("document.DispMedicationAllStages.alt_alloc_qty_"+order_id+order_line_no+cunt).focus();
				   return false;
			   }
	   
			}
	   
	  }
		clearBarcodeQty(order_id,order_line_no,drug_code);
	}
}
function clearBarcodeQty(order_id,order_line_no,drug_code){
	var bean_id		= "DispMedicationBean" ;
        var bean_name	= "ePH.DispMedicationBean";	
	var xmlStr	="<root><SEARCH " ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;

	xmlStr += "drug_code=\""+drug_code +"\" " ;
	xmlStr += "order_id=\""+order_id +"\" " ;
	xmlStr += "order_line_no=\""+order_line_no +"\" " ;
	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?identity=clearBarcodeQty"+"&bean_id="+bean_id+"&bean_name="+bean_name, false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);

}

function displayAlertForNoRecords(){
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}
//MMS-KH-CRF-0030 - end
async function formularyNonPreference(drug_code,patient_id,encounter_id,order_id,order_line_no){

		var dialogHeight= "12" ;
		var dialogWidth	= "32" ;
		var dialogTop = "195" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scroll:no";
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../ePH/jsp/PhNonPreferableRemarks.jsp?item_code="+drug_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&called_from=A"+"&order_id="+order_id+"&order_line_no="+order_line_no,arguments,features);


		if(retVal!=undefined && retVal==true){
			return true;
		}else{
			return false;
		}


} 

function saveNonPreRemForDispAlternate(drug_code,patient_id,encounter_id,order_id,order_line_no){

	var bean_id		= "DispMedicationBean" ;
	var bean_name	= "ePH.DispMedicationBean";	


	var formobj = document.formNonPreferenceRemarks;
	var remarks_code = formobj.non_prefered_item_remarks.value;

	var xmlStr	="<root><SEARCH " ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "patient_id=\""+patient_id +"\" " ;
	xmlStr += "encounter_id=\""+encounter_id +"\" " ;
	xmlStr += "drug_code=\""+drug_code +"\" " ;

	xmlStr += "order_id=\""+order_id +"\" " ;
	xmlStr += "order_line_no=\""+order_line_no +"\" " ;
	xmlStr += "remarks_code=\""+remarks_code +"\" " ;
	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DispMedicationValidate.jsp?identity=nonPreferenceRemarks"+"&bean_id="+bean_id+"&bean_name="+bean_name, false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);

}

function closeRemarksWindowForDrug(){
	window.returnValue = true;
	window.close();
}
//MMS-KH-CRF-0030 - start
function clearBarcodeScreen(rec_no){
	eval(document.getElementById("barcode_id_"+rec_no)).value="";
}
function alertForInvalidBarcode(rec_no){
 alert(getMessage("PH_NOTMATCHING_BAR_CODE","PH")); 

 eval(document.getElementById("barcode_id_"+rec_no)).value="";
}

function displayAlertForMoreRecords(){
	alert(getMessage("PH_ONLY_ONE_ALT_DRUGS_ALLOWED_MAR","PH"));
	return false;
}
function insufficientBatchQty(){
	alert(getMessage("INSUFFICIENT_BATCH_QTY","PH"));
	return false;
}

function assignAltDrugQty(order_id,order_line_no,item_code,alt_qty){
	

		var tot_record = eval("document.DispMedicationAllStages.total_alt_rec_"+order_id+order_line_no).value;
		var alloc_qty="";
		var alt_drug_code="";
		var form_code="";
		var strength_value="";
		var strength_uom="";
		var alt_drug_desc = "";
		for(var cunt=0; cunt<parseInt(tot_record); cunt++) {
			alt_drug_code = eval("document.DispMedicationAllStages.alt_drug_code_"+order_id+order_line_no+cunt).value;
			if(item_code==alt_drug_code){
			var select_yn = eval("document.DispMedicationAllStages.alt_select_"+order_id+order_line_no+cunt).checked;
			if(select_yn){
				eval("document.DispMedicationAllStages.alt_alloc_qty_"+order_id+order_line_no+cunt).value = alt_qty;
				eval("document.DispMedicationAllStages.alt_alloc_qty_"+order_id+order_line_no+cunt).disabled = false;
			}else{
				eval("document.DispMedicationAllStages.alt_select_"+order_id+order_line_no+cunt).checked = true;
				eval("document.DispMedicationAllStages.alt_alloc_qty_"+order_id+order_line_no+cunt).disabled = false;
				eval("document.DispMedicationAllStages.alt_alloc_qty_"+order_id+order_line_no+cunt).value = alt_qty;	
			}	
					
			break;
			}
		}
}
//MMS-KH-CRF-0030 - end

//added for aakh-crf-0140
async function showAbuseDetails(generic_id, patient_id, encounter_id, generic_name, drug_code,calledFro){
	//alert(drug_code);
	//alert(calledFro);
	var dialogTop		= "200";
 	var dialogHeight	= "20";
 	var dialogWidth		= "40";
	var dialogLeft		= "240";
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		= "";
 	var retVal 			= await window.showModalDialog("../jsp/PrescriptionAbuseDetailsFrames.jsp?generic_name="+generic_name+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&patient_id="+patient_id+"&CalledFro="+calledFro+"&drug_code="+drug_code,arguments,features);


} 
//added for AAKH-CRF-0140 end

function chaneBMSINeditlabel(){//added for jd-crf-0221
	// alert("chaneBMSINeditlabel()");
	var totalRecords=parent.editLabelFrame.document.DispMedicationEditLabel.totalRecordds.value;
	var printValue=parent.printSelectFrame.document.DispMedicationPrintDialog.CurbmsReason.value;
	for(var i=0; i<totalRecords; i++){
		if(eval("parent.editLabelFrame.document.DispMedicationEditLabel.line_bms_remarks_code_"+i) != null && eval("parent.editLabelFrame.document.DispMedicationEditLabel.line_bms_remarks_code_"+i) != undefined)
			eval("parent.editLabelFrame.document.DispMedicationEditLabel.line_bms_remarks_code_"+i).value = printValue;
	}
}

function setAutoRefresh(){//Added this function for TH-KW-CRF-0011
	if(document.frmDispMedicationPatientIDDisplay.refresh_pat_details ==undefined){
       var auto_refresh_yn ="YES";
	}else{
       var auto_refresh_yn =document.frmDispMedicationPatientIDDisplay.refresh_pat_details.value;
	}
	 if(auto_refresh_yn=="YES"){
	    parent.parent.parent.document.frames.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
     }
}
function blinkImage(){
				var e;
				var formObj =document.DispMedicationAllStages;
				var total_records =document.DispMedicationAllStages.tot_rec.value;
				try{
					for(var w=1;w<=total_records;w++){
						if(eval("formObj.expiry_aler_lb_"+w)!=undefined){
						    e = eval("formObj.expiry_aler_lb_"+w);
					    if(e.style.display=='inline'){
						    e.style.visibility = ( e.style.visibility == 'visible' )? 'hidden' : 'visible';
					     }
					   }
					}
					
				}
				catch(e){}
			}
			function blinkPatExp(){
				var e;
				var formObj =document.DispMedicationAllStages;
				var total_records =document.DispMedicationAllStages.tot_rec.value;
				try{
					for(var w=1;w<=total_records;w++){
						if(eval("formObj.expiry_aler_lb_"+w)!=undefined){
							e = eval("formObj.expiry_aler_lb_"+w);
					        e.style.color = ( e.style.color == 'darkred' )? '#ff0000' : 'darkred';
						}
					}
				}
				catch(e){}
			}
		

