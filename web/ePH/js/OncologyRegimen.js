/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date   	Rev.By 				Description
--------------------------------------------------------------------------------------------------------------------------------
23/07/2019	IN070451		Manickavasagam J			       			ML-MMOH-CRF-1408
25/07/2019	IN070451		Manickavasagam J			       			ML-MMOH-CRF-1408
12/08/2019	IN070451		B Haribabu  12/08/2019  Manickavasagam J	ML-MMOH-CRF-1408
18/05/2020  IN073000        SaiTeja P                  Place Order - No action on click of confirm
25/06/2020  IN:072715       Haribabu  25/06/2020     Manickavasagam     MMS-DM-CRF-0165
28/07/2020      IN:073485                   Haribabu                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
14/12/2020	6041			Shazana       			14/12/2020				Manickavasagam			NMC-JD-CRF-0063
28/2/2021	  TFS:15132		    Shazana										      NMC-JD-CRF-0063

-------------------------------------------------------------------------------------------------------------------------------
*/
var pres_vals	=	new Array(); 
var i			=	0;
var formatId	=	"";
var function_id =	"" ;
var result 		=	false ;
var message 	=	"" ;
var flag 		=	"" ;
var universalparams;
var durationOK=true;
var blError = false;
var rsns_flag   =  true;
var durn_type_list	=	new Array();    
var narcotic_yn	=	"";
var print_ord_sht_rule_ind="";//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0

function loadDrugDetails(obj){ 
	
	callClearAll(2);		// First clear the bean values
	if(obj.value!=""){
		
	    var frmObj			= document.onCologyOptions;
	    var frmHdr		    = parent.parent.f_header.prescription_header_form;
		var bean_id			= frmObj.bean_id.value;
		var bean_name		= frmObj.bean_name.value;
		var patient_id		= frmObj.patient_id.value; 
		var order_type_flag	= frmObj.order_type_flag.value;
		var order_id	    = frmObj.order_id.value;
		var ord_date		= frmHdr.sys_date.value;
		var adr_count       = frmHdr.adr_count.value;
		var bl_install_yn		= frmHdr.bl_install_yn.value;
		var bl_disp_charge_dtl_in_rx_yn		= frmHdr.bl_disp_charge_dtl_in_rx_yn.value;
		var atc_allergy_alert_level		= frmHdr.atc_allergy_alert_level.value;
		var preview_rx_yn		= frmHdr.preview_rx_yn.value; //added for ML-MMOH-CRF-0341 [IN:057179]
		var regimen_code	= obj.value;
		var drug_db_interface_yn = frmHdr.drug_db_interface_yn.value;
		// RUT-CRF-0062 [IN029600]  -- begin
		var priority       		  = frmHdr.priority.value;
		var source_code           = frmHdr.source_code.value;
		var act_pat_class         = frmHdr.actual_patient_class.value;
		var take_home_medication  = frmHdr.take_home_medication.value;
		// RUT-CRF-0062 [IN029600]  -- end
	//commented by Anbarasi
		//var xmlDoc			= new ActiveXObject("Microsoft.XMLDom");
		//var xmlHttp			= new ActiveXObject("Microsoft.XMLHTTP");
		var xmlDoc = ""; 
		var xmlHttp = new XMLHttpRequest();
		var xmlStr 			= "<root><SEARCH "
			xmlStr		   += "act_pat_class=\"" + act_pat_class + "\" ";  // RUT-CRF-0062  Added to get Build MAR Rule  - begin
			xmlStr		   += "source_code=\"" + source_code + "\" ";  
			xmlStr		   += "priority=\"" + priority + "\" ";  
			xmlStr		   += "take_home_medication=\"" + take_home_medication + "\" ";   // RUT-CRF-0062  - end
			xmlStr		   += "atc_allergy_alert_level=\"" + atc_allergy_alert_level + "\" ";   // RUT-CRF-0065  - end
			xmlStr		   += buildXMLString(frmObj)  + " /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "OncologyRegimenValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=DRUGCODES&drugCodes="+obj.value+"&patient_id="+patient_id+"&disable_yn=N"+"&order_id="+order_id+"&ord_date="+ord_date+"&order_type_flag="+order_type_flag, false );
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
		var params		= parent.oncology_options.document.onCologyOptions.params.value;
		var MAR_app_yn	= getMAR_app_yn(frmHdr);
		parent.oncology_drugs.f_oncology_regimen_drug_list.location.href="OncologyRegimenDrugList.jsp?"+params+"&regimen_code="+regimen_code+"&order_type_flag="+order_type_flag+"&order_id="+order_id+"&adr_count="+adr_count+"&MAR_app_yn="+MAR_app_yn;    	
		parent.oncology_drugs.f_preview_buttons.location.href="OncologyRegimenPreviewButtons.jsp?"+params+"&regimen_code="+regimen_code+"&disable_yn=N"+"&MAR_app_yn="+MAR_app_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&iv_prep_yn=9"+"&drug_db_interface_yn="+drug_db_interface_yn+"&preview_rx_yn="+preview_rx_yn; //added preview_rx_yn for ML-MMOH-CRF-0341 [IN:057179]
 	}
}

function callClearAll(calledFrom, confirm1) {
	var chk_flag = false;
	if (calledFrom == 1 && confirm1 == undefined) {

		if (confirm(getMessage("PH_ALL_DETAILS_CLEAR","PH"))) {
			chk_flag = true;
		}
	}
	if(confirm1)
		chk_flag = true;
	if (calledFrom==2 || (calledFrom==1 && chk_flag) || calledFrom==3 || calledFrom==4) {
		var frmObj		= "";

		if(calledFrom==2 || calledFrom==4){			
			 frmObj			= parent.oncology_options.document.onCologyOptions;
		}
		else{
			frmObj			= parent.parent.oncology_options.document.onCologyOptions;
		}
		var presc_mode	= "";

		var bean_id		= frmObj.bean_id.value;
		var bean_name	= frmObj.bean_name.value;
		var patient_id	= frmObj.patient_id.value;
		//commented by Anbarasi
		//var xmlDoc		= new ActiveXObject("Microsoft.XMLDom");
		//var xmlHttp		= new ActiveXObject("Microsoft.XMLHTTP");
		var xmlDoc = ""; 
		var xmlHttp = new XMLHttpRequest();

		xmlHttp.open("POST", "OncologyRegimenValidate.jsp?patient_id="+patient_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&validate=CLEARBEAN&calledFrom="+calledFrom+"&presc_mode="+presc_mode, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
}

function reloadScreens(calledFrom, patient_id, encounter_id, order_date, pat_class,problem_ind) {

	if(calledFrom=='1')
		var frmHdr		    = parent.parent.parent.f_header.prescription_header_form;
	else
		var frmHdr		    = parent.parent.f_header.prescription_header_form;
	var bl_install_yn			= frmHdr.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	= frmHdr.bl_disp_charge_dtl_in_rx_yn.value;
	if (calledFrom == "1") {
		parent.parent.parent.f_prescription.location.href	= "../jsp/OncologyRegimen.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&problem_ind="+problem_ind+"&clearOrNot=Y"+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn;
	}
	else if (calledFrom == "4") {
		parent.parent.f_prescription.location.href	= "../jsp/OncologyRegimen.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&problem_ind="+problem_ind+"&clearOrNot=Y"+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn;
	}
	else if (calledFrom == "3") {
		var iv_option = "N";
		if (parent.oncology_options.document.onCologyOptions.iv_admixture.value == "Y")
			iv_option = "Y";
		parent.oncology_drugs.location.href	= "../jsp/OncologyRegimenDrugDetailFrames.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&iv_option="+iv_option+"&pat_class="+pat_class+"&problem_ind="+problem_ind;
		parent.oncology_button.location.href	= "../jsp/OncologyRegimenButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&iv_option="+iv_option+"&pat_class="+pat_class+"&problem_ind="+problem_ind+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&iv_prep_yn=9"+"&=order_type_flag="+parent.oncology_options.document.onCologyOptions.order_type_flag.value;
	}
}

function defaultDrug(serialNum,comp_freq_code,comp_durn_value,comp_durn_type,fluid_frame_display_yn,count) {
	var frmObj			= parent.parent.oncology_options.document.onCologyOptions;
	var patient_id		= frmObj.patient_id.value;
	var encounter_id	= frmObj.encounter_id.value;
	var patient_class	= frmObj.patient_class.value;
	var act_patient_class	= frmObj.act_patient_class.value;//Added for ML-MMOH-SCF-0414
	var start_date		= frmObj.start_date.value;
	var regimen_code	= frmObj.regimen.value;
	var stage			= frmObj.stage.value;
	var intention		= frmObj.intention.value;
	var problem_ind		= frmObj.problem_ind.value;
	var params			= frmObj.params.value;
	var iv_prep_default	= frmObj.iv_prep_default.value;
	var order_type_flag	= frmObj.order_type_flag.value;
	var order_id	    = frmObj.order_id.value;
	var height			= parent.parent.parent.f_header.prescription_header_form.height.value;
	var weight			= parent.parent.parent.f_header.prescription_header_form.weight.value;
	var bsa				= parent.parent.parent.f_header.prescription_header_form.bsa.value;
	var MAR_app_yn = getMAR_app_yn(parent.parent.parent.f_header.prescription_header_form);
	var bl_install_yn				= parent.parent.parent.f_header.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	= parent.parent.parent.f_header.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var iv_option		= "" 
	var drug_db_interface_yn = parent.parent.parent.f_header.prescription_header_form.drug_db_interface_yn.value;
	if(order_type_flag!="Existing"){
		//parent.parent.oncologyFrameSet.rows="20%,*";
		parent.parent.document.getElementById("oncology_options").style.height="20vh";
		parent.parent.document.getElementById("oncology_drugs").style.height="80vh";
	}
	else{
	    //parent.parent.oncologyFrameSet.rows="28%,*";
		parent.parent.document.getElementById("oncology_options").style.height="28vh";
		parent.parent.document.getElementById("oncology_drugs").style.height="72vh";
    }
	
	if(order_type_flag!='Existing'){

		parent.parent.oncology_options.location.href	="../jsp/OncologyRegimenOptions.jsp?serialNum="+serialNum+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&start_date="+start_date+"&regimen_code="+regimen_code+"&stage="+stage+"&intention="+intention+"&problem_ind="+problem_ind+"&height="+height+"&weight="+weight+"&bsa="+bsa+"&iv_prep_default="+iv_prep_default+"&order_id="+order_id+"&order_type_flag="+order_type_flag+"&drug_db_interface_yn="+drug_db_interface_yn+"&act_patient_class="+act_patient_class;//act_patient_class added for ML-MMOH-SCF-0414
    }
 universalparams="../jsp/OncologyRegimenOptions.jsp?serialNum="+serialNum+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&iv_option="+iv_option+"&start_date="+start_date+"&regimen_code="+regimen_code+"&stage="+stage+"&intention="+intention+"&problem_ind="+problem_ind+"&height="+height+"&weight="+weight+"&bsa="+bsa+"&order_id="+order_id+"&order_type_flag="+order_type_flag+"&drug_db_interface_yn="+drug_db_interface_yn+"&act_patient_class="+act_patient_class;//act_patient_class added for ML-MMOH-SCF-0414
	parent.f_oncology_sub_drugs.location.href	="../jsp/OncologyRegimenDrugDetails.jsp?serialNum="+serialNum+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&iv_option="+iv_option+"&start_date="+start_date+"&regimen_code="+regimen_code+"&stage="+stage+"&intention="+intention+"&problem_ind="+problem_ind+"&height="+height+"&weight="+weight+"&bsa="+bsa+"&fluid_frame_display_yn="+fluid_frame_display_yn+"&order_type_flag="+order_type_flag+"&order_id="+order_id+"&count="+count+"&MAR_app_yn="+MAR_app_yn;
	parent.oncology_button.location.href	="../jsp/OncologyRegimenButtons.jsp?"+params+"&serial_no="+serialNum+"&disable_yn=N"+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&iv_prep_yn=9&order_type_flag="+order_type_flag;
}

async function showAllergyDetails(generic_id, patient_id, encounter_id, generic_name, drug_name) {
	var dialogTop		= "";
 	var dialogHeight	= "32vh";
 	var dialogWidth		= "45vw";
	var dialogLeft		= "240";
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		= "";
 	var retVal 			= await window.showModalDialog("../jsp/PrescriptionAllergyDetailsFrames.jsp?generic_name="+generic_name+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&patient_id="+patient_id+"&drug_name="+ drug_name,arguments,features);
}

async function showMonoGraph(drug_desc,mono_graph,daily_dose,unit_dose,min_daily_dose,min_unit_dose,dosage_unit,dosage_std,dose_unit_desc,max_daily_ceeling_dose,min_daily_ceeling_dose,max_unit_ceeling_dose,min_unit_ceeling_dose,dose_unit_desc1){//Modified for IN:070451 added last 5 parameters
	var retVal;
	var dialogTop		= "";
 	var dialogHeight	= "30vh" ;
 	var dialogWidth		= "56vw" ;
	var dialogLeft		= "180" ;

 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
 	retVal 				=    await window.showModalDialog("../../ePH/jsp/PrescriptionDosageLimitMonoGraph.jsp?drug_desc="+drug_desc+"&mono_graph="+mono_graph+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&min_daily_dose="+min_daily_dose+"&min_unit_dose="+min_unit_dose+"&dosage_unit="+dosage_unit+"&dosage_std="+dosage_std+"&dose_unit_desc="+dose_unit_desc+"&max_daily_ceeling_dose="+max_daily_ceeling_dose+"&min_daily_ceeling_dose="+min_daily_ceeling_dose+"&max_unit_ceeling_dose="+max_unit_ceeling_dose+"&min_unit_ceeling_dose="+min_unit_ceeling_dose+"&dose_unit_desc1="+dose_unit_desc1,arguments,features);//Modified for IN:070451
}

async function callCurrentMedication(patient_id, encounter_id, generic_id) {
	if(generic_id == undefined)
		generic_id="";
	var dialogHeight	= "40vh";
	var dialogWidth		= "60vw";
	var dialogTop		= "250";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	var retVal			= await top.window.showModalDialog("../jsp/PrescriptionActiveOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&generic_id="+generic_id,arguments,features);
}

function changeCursor(obj) {
	obj.style.cursor = "hand";
}

function realCol(obj,classVal) {
	obj.className=classVal;
}

function changeCol(obj) {
	obj.className="FOCUSDRUGS";
}

function changeBorder(obj) {
	obj.className="CLICKDRUGS";
}

function chkAuthorization(src) {
	var allowed_click	= "";
	var formobj			= document.onCologyRegimenDrugDetails;

	if (src == "authorize") {
		if(confirm(getMessage("PH_AUTHAPPROVE_1","PH"))) {
			document.onCologyRegimenDrugDetails.auth_yn_val.value		= "Y";
			document.onCologyRegimenDrugDetails.auth_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Authorized.gif\" BORDER=\"0\"></IMG>&nbsp;<B>Authorized</B>";
		}
		else {
			document.onCologyRegimenDrugDetails.auth_yn_val.value		= "N";
			document.onCologyRegimenDrugDetails.auth_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Authorization.gif\" BORDER=\"0\"></IMG>&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization('authorize')\">Authorize</A>";
		}

	}
	else if (src=="approve") {
		if (confirm(getMessage("PH_AUTHAPPROVE_2","PH"))) {
			document.onCologyRegimenDrugDetails.approval_yn_val.value		= "Y";
			document.onCologyRegimenDrugDetails.spappl_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/SpecialApproval_click.gif\" BORDER=\"0\"></IMG>&nbsp;<B>Approved</B>";
		}
		else {
			document.onCologyRegimenDrugDetails.approval_yn_val.value		= "N";
			document.onCologyRegimenDrugDetails.spappl_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/SpecialApproval.gif\" BORDER=\"0\"></IMG>&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization('approve')\">Approve</A>";
		}
	}
	else if (src=="cosign") {
		if (confirm(getMessage("PH_AUTHAPPROVE_3","PH"))) {
			document.onCologyRegimenDrugDetails.cosign_yn_val.value			= "Y";
			document.onCologyRegimenDrugDetails.cosign_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Cosign.gif\" BORDER=\"0\"></IMG>&nbsp;<B>Cosigned</B>";
		}
		else {
			document.onCologyRegimenDrugDetails.cosign_yn_val.value			= "N";
			document.onCologyRegimenDrugDetails.cosign_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Cosign_click.gif\" BORDER=\"0\"></IMG>&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization('cosign')\">Cosign</A>";
		}
	}
}

function getFormatId(calledFrom,click_yn) {	
	var formObj			= "";
	var drug_code		= "";
	if (calledFrom == "Drug") {
		formObj		= document.onCologyRegimenDrugDetails;
		drug_code	= formObj.drug_code.value;
	}
	else if (calledFrom == "Fluid") {
		formObj		= document.oncologyRegimenFluidDetail;
		drug_code	= formObj.fluid_code.value;
	}
	if(drug_code != undefined && drug_code!=""){
		var order_type		= formObj.order_type_code.value;
		var drug_code		= formObj.drug_code.value;
		var ocurrance_num		= formObj.ocurrance_num.value;
		var form_code		= formObj.form_code.value;
		var route_code		= formObj.route_code.value;
		var bean_id			= formObj.bean_id.value;
		var bean_name		= formObj.bean_name.value;
		var patient_id		= formObj.patient_id.value;
//commented by Anbarasi
	//	var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
		//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
		var xmlDoc = ""; 
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", "OncologyRegimenValidate.jsp?patient_id="+patient_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&validate=GETFORMATID&order_type="+order_type+"&form_code="+form_code+"&route_code="+route_code+"&drug_code="+drug_code+"&ocurrance_num="+ocurrance_num+"&called_frm="+calledFrom+"&click_yn="+click_yn, false);
		
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;	
		eval(responseText);
	}

}
function prescriptionValues(vals)	{
	pres_vals[i++] = vals;
}

/*function validateRemarks(format_id, calledFrom)	{
	var format			= format_id.split("~");
	formatId			= format[1];
	var optionForm		= parent.parent.oncology_options.document.onCologyOptions;
    var order_type_flag =optionForm.order_type_flag.value;
	if(order_type_flag!='Existing')
	{
	   callOrder(calledFrom);
	}
}*/

function callOrder(format_id,calledFrom, catalog_code, ocurrance_num,form_code, route_code,click_yn) {
	var format			= format_id.split("~");
	formatId			= format[1];
	//added for [IN:039576]-start
	var mandatory	=	format[0];
	if(mandatory == undefined || mandatory== null || mandatory=='null' || mandatory=='')
		mandatory="N";
	 document.getElementById('DrugRemarksMandImg').style.display = 'none';
	 document.getElementById('DrugRemarksMandatory').value =mandatory;
	 //added for [IN:039576]-end
	var frmObj = "";
	/*var vals = "";
	var drug_code = "";
	for(i=0; i<pres_vals.length; i++)	{
		if(i==pres_vals.length)
			vals	+= pres_vals[i];
		else
			vals	+= pres_vals[i]+ "::";
	}*/
	if (calledFrom == "Drug") {
		frmObj = document.onCologyRegimenDrugDetails
		drug_code = document.onCologyRegimenDrugDetails.drug_code.value;
	}
	else if (calledFrom == "Fluid") {
		frmObj = document.oncologyRegimenFluidDetail
		drug_code = document.oncologyRegimenFluidDetail.drug_code.value;
		drug_code=drug_code+"Fluid";
	}
	//added for SKR-SCF-0140 -start
	if(format == null || format=='' || formatId==null || formatId=='')
		document.getElementById('drug_remarks').style.display = 'none';
	else{
		document.getElementById('drug_remarks').style.display = 'inline';
	    if(mandatory == 'Y'){//added if block for [IN:039576]
	    	document.getElementById('DrugRemarksMandImg').style.display = 'inline';
		}
	}
	//added for SKR-SCF-0140 -end
	if(click_yn =='Y'){
		//drug_code=drug_code+calledFrom
		callRemarks(frmObj, formatId,drug_code, catalog_code,ocurrance_num, 'PH', '0', 'PH', form_code, route_code);
	}
}

async function callRemarks(frmObj, format_id, drug_code,catalog_code, ocurrance_num,order_category, row_value, called_from, form_code, route_code) {
	patient_id		= frmObj.patient_id.value;
	encounter_id	= frmObj.encounter_id.value;
	DrugRemarksEntered	=frmObj.DrugRemarksEntered.value; //added for [IN:039576]
	bean_id			= "@orderentrybean"+patient_id+encounter_id;
	bean_name		= "eOR.OrderEntryBean";
	var dialogHeight= "60vh";
	var dialogWidth	= "59vw";
	var dialogTop	= "169";
	var center		= "1";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal		= await top.window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&format_id="+format_id+"&p_catalog_code="+catalog_code+"&catalog_code="+drug_code+ocurrance_num+"&p_form_code="+form_code+"&p_route_code="+route_code+"&order_category="+order_category+"&row_value=0&called_from=PH",arguments,features);
	if(retVal!=undefined ){
		var retVals = retVal.split('~');
		//if(retVal!=undefined && retVal=='Y' && DrugRemarksEntered!='Y') //added for [IN:039576]
		if(retVals[0]=='Y' && DrugRemarksEntered!='Y') //if block added for [IN:039576]
			document.onCologyRegimenDrugDetails.DrugRemarksEntered.value = 'Y';
	}
}

function confirmAndProceed(obj, obj1) {
//obj refers to the clicked object now.
	if (obj.value == "N") {
		obj.checked = false;
		if (confirm("Recorded Data will not be retained and will be lost. Do you really want to continue?")) {
			obj.value = "Y";
			obj1.value = "N";
			obj.checked = true;
			obj1.checked = false;
		
			callClearAll(3);

		}
		else {
			obj.value = "N";
			obj1.value = "Y";
			obj.checked = false;
			obj1.checked = true;
		}
	}
}

function checkValidDrug(checkFor, objVal,drug_code) {	
	
/*	if (trimCheck(objVal) != "") {  // condition commented for IN23523 to prevent drug lookup opening twice --27/08/2010-- priya
		if (checkFor == "D")			// and replaced else with if condition
			searchIVDrugs("D", document.oncologyRegimenFluidDetail.drug_name,drug_code);
		else if (checkFor == "F")
			searchIVFluid("D", document.oncologyRegimenFluidDetail.fluid_name,drug_code);
	}
	else { */
	if(trimCheck(objVal) == "")
	{
		if (checkFor == "F") {
			var frmObj = document.oncologyRegimenFluidDetail;
			
			frmObj.order_type_code.value	= "";
			frmObj.stock_value.value		= "";
			frmObj.stock_uom_code.value		= "";
			frmObj.stock_uom.innerHTML	= "";
			document.getElementById('fluid_remarks').style.visibility = "hidden";
		}
	}
}

function searchIVDrugs(searchBasedOn, obj,org_drug_code) {

	var frmObj			= document.onCologyRegimenDrugDetails;
	var drug_code		= frmObj.drug_code.value;
	var patient_class	= frmObj.patient_class.value;
	var patient_id		= frmObj.patient_id.value;
	var encounter_id		= frmObj.encounter_id.value;
	var frmHdr		        = parent.parent.parent.f_header.prescription_header_form;
	var act_patient_class	= frmHdr.actual_patient_class.value;
    var source_code         =frmHdr.source_code.value;
    var source_type         =frmHdr.source_type.value;
    var discharge_yn         =frmHdr.take_home_medication.value;
    var priority         =frmHdr.priority.value;
	var date_of_birth		= frmHdr.date_of_birth.value;
	var gender				= frmHdr.gender.value;
	var atc_allergy_alert_level	= frmHdr.atc_allergy_alert_level.value; // RUT-CRF-0065  - end

	var iv_prep_yn = "";
	if(parent.oncology_admin.oncologyRegimenAdminDetail.adMixture.checked == true)
		iv_prep_yn="0";
	else
		iv_prep_yn="9";
   
	var retArray = DrugSearchForIV(searchBasedOn, obj, '', drug_code, 'DrugSearchBean', '', '', act_patient_class, priority, 'D','',discharge_yn, source_type, source_code, patient_id, encounter_id,date_of_birth,gender, iv_prep_yn);
//	if(frmHdr.take_home_medication_op_chk!=undefined)
	//	frmHdr.take_home_medication_op_chk.disabled=true;//COMMENTED for NMC-JD-CRF-0063//
	if (retArray!=undefined && retArray != null && retArray != "") {
		frmObj.drug_code.value	= retArray;
		var bean_id				= frmObj.bean_id.value;
		var bean_name			= frmObj.bean_name.value;
//commented by Anbarasi
		//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
		//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
		var xmlDoc = ""; 
		var xmlHttp = new XMLHttpRequest();
		
		var xmlStr 			= "<root><SEARCH "
			xmlStr		   += "act_pat_class=\"" + act_patient_class + "\" ";  // RUT-CRF-0062  Added to get the Build MAR Rule - begin
			xmlStr		   += "source_code=\"" + source_code + "\" ";  
			xmlStr		   += "priority=\"" + priority + "\" ";  
			xmlStr		   += "take_home_medication=\"" + discharge_yn + "\" ";   // RUT-CRF-0062  - end
			xmlStr		   += "atc_allergy_alert_level=\"" + atc_allergy_alert_level + "\" ";   // RUT-CRF-0065  - end
			xmlStr 		   +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "OncologyRegimenValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=DRUGCODES&drugCodes="+retArray+"&patient_id="+patient_id, false );
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
	obj.value = "";
}

function searchIVFluid(searchBasedOn, obj, org_drug_code) {
	var frmOptnsObj			= parent.parent.oncology_options.document.onCologyOptions;
	
	if(frmOptnsObj.regimen.value != ''){	
		var frmObj				= document.oncologyRegimenFluidDetail;
		var patient_class		= frmObj.patient_class.value;
		var patient_id			= frmObj.patient_id.value;
		var encounter_id		= frmObj.encounter_id.value;
		var default_code		= frmObj.fluid_code.value;
		var default_fluidname	= frmObj.fluid_name.value;
		var frmHdr		        = parent.parent.parent.f_header.prescription_header_form;
		var act_patient_class	= frmHdr.actual_patient_class.value;
		var source_code         = frmHdr.source_code.value;
		var source_type         = frmHdr.source_type.value;
		var discharge_yn        = frmHdr.take_home_medication.value;
		var priority			= frmHdr.priority.value;
		var date_of_birth		= frmHdr.date_of_birth.value;
		var gender				= frmHdr.gender.value;

		var	drug_code			= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails.drug_code.value;
		var iv_prep_yn          = "";
		if(parent.oncology_admin.oncologyRegimenAdminDetail.adMixture.checked == true)
			iv_prep_yn="0";
		else
			iv_prep_yn="9";

		var retArray = DrugSearchForIV(searchBasedOn, obj, '', drug_code, 'DrugSearchBean', '', '', act_patient_class,priority ,  'F','N',discharge_yn, source_type, source_code, patient_id, encounter_id,date_of_birth,gender, iv_prep_yn);
	
		if (retArray!=undefined && retArray != null && retArray != "" )
		{
			var drugfrmObj			= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
			var ocurrance_num		= drugfrmObj.ocurrance_num.value;

			frmObj.fluid_code.value	= retArray[0];
			var drug_code			= retArray[0];
			obj.value				= retArray[1];
			frmObj.form_code.value	= retArray[2];
			frmObj.route_code.value	= retArray[3];
			frmObj.base_uom.value	= retArray[4];
			var base_uom			= retArray[4];
			var bean_id				= frmObj.bean_id.value;
			var bean_name			= frmObj.bean_name.value;
			var patient_id			= frmObj.patient_id.value;
			if(default_code != "" && default_code != retArray[0] && retArray != null && retArray != ""){
				frmObj.remarks.style.visibility='visible';
				frmObj.mandatory1.style.visibility='visible';
				frmObj.default_fluid_changed.value='Y';
				
				}
				//commented by Anbarasi
			//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
			//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
			var xmlDoc = ""; 
			var xmlHttp = new XMLHttpRequest();
			xmlHttp.open("POST", "OncologyRegimenValidate.jsp?patient_id="+patient_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&validate=STOCKDETAILS&drug_code="+drug_code+"&org_drug_code="+org_drug_code+"&base_uom="+base_uom+"&ocurrance_num="+ocurrance_num, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			eval(responseText);

			setSchedule();
		}
		else {
			obj.value = "";
			frmObj.fluid_code.value			= "";
			frmObj.order_type_code.value	= "";
			frmObj.stock_value.value		= "";
			frmObj.stock_uom_code.value		= "";
			frmObj.stock_uom.innerHTML		= "";

		}
		/*The Below Condition Is  Added By SureshKumar T For The Incident No SRR20056-SCF-7550[Inc:27593]*/
		
	if(frmObj.default_fluid_changed.value=='Y')
			calInfusionRate();
	}else{
		alert(getMessage("RGMN_CANT_BLANK","PH"));
	}
}
 
function setOrderType(orderTypeCode) {
	parent.oncology_fluid.document.oncologyRegimenFluidDetail.order_type_code.value = orderTypeCode;
}
function setInfuseOverValue(infuseovervalue,infuseoverdurntype) {

	var frmAdminObj=parent.oncology_admin.oncologyRegimenAdminDetail;
	parent.oncology_admin.document.oncologyRegimenAdminDetail.infusion_period_value.value = infuseovervalue;
    frmAdminObj.infuse_over_time_value.value=infuseoverdurntype;
	
	if(infuseoverdurntype=='M'){
       frmAdminObj.infuse_over_time.innerHTML	= "<b>"+getLabel("Common.Minutes.label","Common")+"</b>";
    }
	else  if(infuseoverdurntype=='H'){
		frmAdminObj.infuse_over_time.innerHTML	= "<b>"+getLabel("Common.hours.label","Common")+"</b>";
	}
	else  if(infuseoverdurntype=='D'){
		frmAdminObj.infuse_over_time.innerHTML	= "<b>"+getLabel("Common.days.label","Common")+"</b>";
	}
	else  if(infuseoverdurntype=='L'){
		frmAdminObj.infuse_over_time.innerHTML	= "<b>"+getLabel("Common.months.label","Common")+"</b>";
	}

	obj=parent.oncology_admin.document.oncologyRegimenAdminDetail.infusion_period_uom;
	for (i=0;i<obj.options.length ; i++){
		if (obj.options[i].value==infuseoverdurntype){
			obj.options[i].selected=true;
			break;
		}
	}
	calInfusionRate();
}

function calInfuseOver(){
	
	
	var frmAdminObj			= parent.oncology_admin.oncologyRegimenAdminDetail;
	var frmObj				= parent.oncology_fluid.oncologyRegimenFluidDetail;
	var drugformObj			= parent.f_oncology_sub_drugs.onCologyRegimenDrugDetails;
	var obj =  frmAdminObj.infusion_rate;
	if(CheckNum(obj)){
		if(parseFloat(obj.value)==0 || obj.value=="") {
			alert(getMessage("ZERO_NOT_ALLOWED","PH")+"Infusion Rate");
			obj.focus();
			return;
		}
		if(frmObj.stock_value!=undefined && frmObj.stock_value!=null){
			
			if(frmObj.stock_value.value!="" && frmAdminObj.infusion_rate.value!="" &&  trimString(frmAdminObj.infusion_rate.value)!="0"){
				temp = parseInt(frmObj.stock_value.value) / parseFloat(frmAdminObj.infusion_rate.value);
				temp = Math.round(temp*100)/100;
				frmAdminObj.infusion_period_value.value = temp;
				frmAdminObj.infuse_over_str.innerHTML	= getHrsMinStr(frmAdminObj.infusion_period_value.value,frmAdminObj.infusion_period_uom.value);
				
		/* var inf_over=frmAdminObj.INFUSION_PERIOD_VALUE.value;
		 
		 var dur_val=parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.DURN_VALUE.value;
		
			 if((parseInt(inf_over)) >( parseInt(dur_val)))
			{
				 if(frmAdminObj.infusion_time.value=='H')
				 {
				   alert(getMessage("DURATION_CANNOT_LESSTHAN"));
				 }
			}*/
			}
		}
		else{
				
			if(drugformObj.totalDose.value!="" && frmAdminObj.infusion_rate.value!="" &&  trimString(frmAdminObj.infusion_rate.value)!="0"){
				temp = parseInt(drugformObj.totalDose.value) / parseFloat(frmAdminObj.infusion_rate.value);
				temp = Math.round(temp*100)/100;
				frmAdminObj.infusion_period_value.value = temp;
			}
		} 
	}

}

function ChangeInfuseOverTime(obj){
	var frmAdminObj=parent.oncology_admin.oncologyRegimenAdminDetail;
	frmAdminObj.infuse_over_time_value.value=obj.value;
	if(obj.value=="H"){
		frmAdminObj.infuse_over_time.innerHTML	= "<b>"+getLabel("Common.hours.label","Common")+"</b>";
		frmAdminObj.infuse_over_str.innerHTML	= getHrsMinStr(frmAdminObj.infusion_period_value.value,'H');
	}
	else if(obj.value=="M"){
		frmAdminObj.infuse_over_time.innerHTML	= "<b>"+getLabel("Common.Minutes.label","Common")+"</b>";
		frmAdminObj.infuse_over_str.innerHTML	= getHrsMinStr(frmAdminObj.infusion_period_value.value,'M');
	}
	else if(obj.value=="D")
		frmAdminObj.infuse_over_time.innerHTML	= "<b>"+getLabel("Common.days.label","Common")+"</b>";
	else  if(obj.value=='L')
		frmAdminObj.infuse_over_time.innerHTML	= "<b>"+getLabel("Common.months.label","Common")+"</b>";
}

function calInfusionRate(){

   	var frmAdminObj=parent.oncology_admin.oncologyRegimenAdminDetail;
	var frmObj	    = parent.oncology_fluid.oncologyRegimenFluidDetail;
	var drugformObj		=parent.f_oncology_sub_drugs.onCologyRegimenDrugDetails;
	var obj=frmAdminObj.infusion_period_value;
		if(CheckNum(obj)){

		if(parseFloat(obj.value)==0 || obj.value=="") {
			alert(getMessage("ZERO_NOT_ALLOWED","PH")+"Infuse Over ");
			return;
		}

		if(frmObj.stock_value!=undefined && frmObj.stock_value!=null){
			if(frmObj.stock_value.value!="" && frmAdminObj.infusion_period_value.value!="" && trimString(frmAdminObj.infusion_period_value.value)!="0"){
				temp = parseInt(frmObj.stock_value.value)/parseFloat(frmAdminObj.infusion_period_value.value);
				temp = Math.round(temp*100)/100;
			  frmAdminObj.infusion_rate.value = temp;


			frmAdminObj.infuse_over_str.innerHTML	= getHrsMinStr(frmAdminObj.infusion_period_value.value,frmAdminObj.infusion_period_uom.value);
		  //var inf_over= frmAdminObj.INFUSION_PERIOD_VALUE.value;
		  //var infusion_time=frmAdminObj.infusion_time.value;
		 // var dur_val=parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.DURN_VALUE.value; 
		
			   /*if((parseInt(inf_over) )>( parseInt(dur_val)))
			   {		 
					if(frmAdminObj.infusion_time.value=='H')
					 {
					   alert(getMessage("DURATION_CANNOT_LESSTHAN"));
					 }
			 }*/
			}	 
		}
		else{	
			

			if(drugformObj.totalDose.value!="" && frmAdminObj.infusion_period_value.value!="" && trimString(frmAdminObj.infusion_period_value.value)!="0"){
				temp = parseInt(drugformObj.totalDose.value)/parseFloat(frmAdminObj.infusion_period_value.value);
				temp = Math.round(temp*100)/100;
				frmAdminObj.infusion_rate.value = temp;
				frmAdminObj.infuse_over_str.innerHTML	= getHrsMinStr(frmAdminObj.infusion_period_value.value,frmAdminObj.infusion_period_uom.value);
				//Math.ceil(parseInt(drugformObj.totalDose.value)/parseInt(frmAdminObj.infusion_period_value.value));
			}
		}
	}
}

function setStockDetails(mode, stock_value, stock_uom_code, stock_uom_desc,stock_uom) {
	
	
	
   	var frmAdminObj=parent.oncology_admin.oncologyRegimenAdminDetail;
	var frmObj = parent.oncology_fluid.document.oncologyRegimenFluidDetail;
		if(frmAdminObj.infuse_rate_uom!=undefined){
			
			
			frmAdminObj.infuse_rate_uom.innerHTML=stock_uom_desc;
			
		}
	if (mode == 1) {
		
		frmObj.stock_value.value	= stock_value;
		frmObj.default_stock_val.value = stock_value;//CRF-1014
		frmObj.stock_uom_code.value	= stock_uom_code;
		frmObj.stock_uom.innerHTML	= stock_uom_code;
		frmObj.stock_uom_val.value=stock_uom;

	}
	else if (mode == 2) {
		alert(getMessage("PH_EQU_UOM_NOT_DEFINED","PH"));
	}
}
/*
function setStockDetails(mode, stock_value, stock_uom_code, stock_uom_desc, eqvl_uom, eqvl_value, eqvl_uom_desc) {
	
	var frmAdminObj	=	parent.oncology_admin.oncologyRegimenAdminDetail;
	var frmObj		=	document.oncologyRegimenFluidDetail;
	frmAdminObj.infuse_rate_uom.innerHTML	=	stock_uom_code;
    frmObj.stock_uom_val.value	=	stock_uom_code;
	
	if (mode== 1) {
		if(frmObj.stock_value!=undefined){
		frmObj.stock_value.value	= stock_value;		
		frmObj.stock_uom_code.value	= stock_uom_code;
		frmObj.stock_uom.innerHTML	= stock_uom_code;
		}
	}
	else if (mode == 2) {
		alert(getMessage("PH_EQU_UOM_NOT_DEFINED","PH"));
		
	}
}
*/

function addData(code, desc, obj) {
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	code;
	opt.text = desc;
	obj.add(opt);
}

function clearData(obj, mode) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	var opt	= document.createElement('OPTION');
	if (mode == "1") {
		opt.value =	"";
		opt.text = "--- Select ---";
		obj.add(opt);
	}
}

function checkValue(obj) {
	if (checkWholeNumber(obj)) {
		var frmObj	= document.oncologyRegimenAdminDetail;
		var objVal = obj.value;
		if (trimCheck(objVal) == "") {
//			if (trimCheck(frmObj.def_inf_prd.value) != "" || trimCheck(frmObj.stock_value.value) != "") {
				//alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
				alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
				obj.focus();
//				parent.oncology_admin.document.oncologyRegimenAdminDetail.frequency.disabled = true;
//			}
		}
	}
}

function checkWholeNumber(obj) {
	var objVal=obj.value;
	var retStat = true;
	if (trimCheck(objVal) != "") {
		for ( i = 0; i < objVal.length; i++ ) {
			if (objVal.charAt(i)<'0' || objVal.charAt(i)>'9') {
				retStat = false;
				break;
			}
		}
	}
	return retStat;
}
function StatFrequencyorNot(freqnature){
	frmobj	=	document.oncologyRegimenAdminDetail;
	frmobj.freq_nature.value =freqnature;
	if (freqnature=="O"){
		frmobj.durn_value.value="1";
		frmobj.durn_value.disabled=true;
		frmobj.durn_unit.disabled=true;
		chkDuration(frmobj.durn_value);
	}
	else{
		frmobj.durn_value.disabled=false;
		frmobj.durn_unit.disabled=false;
	}
}

function callAmend() {
	if (chkMandatoryFlds("Amend")) {
		var frmObj 				= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
		var frmFluidObj 		= parent.oncology_fluid.document.oncologyRegimenFluidDetail;
		var frmAdminObj 		= parent.oncology_admin.document.oncologyRegimenAdminDetail;
		var optionForm			= parent.parent.oncology_options.document.onCologyOptions;
		var headerForm			= parent.parent.parent.f_header.document.prescription_header_form;
        var bl_install_yn		=headerForm.bl_install_yn.value;	   
        var bl_disp_charge_dtl_in_rx_yn		=headerForm.bl_disp_charge_dtl_in_rx_yn.value;	   

		var location_type			= headerForm.location_type.value;
		var location_code			= headerForm.location_code.value;
		var priority				= headerForm.priority.value;
		var take_home_medication	= headerForm.take_home_medication.value;
		//GHL-CRF-0549 start
		var diagnosis_found_yn=frmObj.diagnosis_found_yn.value;//added for mms-dm-crf-0204
		var ord_set_reqd_or_opt = frmObj.ord_set_reqd_or_opt.value;
		if(diagnosis_found_yn=="N"){
			alert(getMessage("REQ_DIAG_PRES_NOT_FOUND",'PH'));
          } 
		if(diagnosis_found_yn=="N" && ord_set_reqd_or_opt == 'R'){
			alert(getMessage("PH_CANCEL_ORDERSET_DRUG_FROM_RX", "PH"));
			return false;
		}
		
		var allow_alternate			= "N"; //GHL-CRF-0549 start
		if(frmObj.allow_alternate_yn!=undefined){
			if(frmObj.allow_alternate_yn.checked==true)
				allow_alternate = "Y";
		}
		//GHL-CRF-0549 end
		//ML-MMOH-CRF-1408 - start
		var temp_qty ="";
		var qty_value = frmObj.totalDose.value;

		 if(headerForm.height.value.length > 0 && headerForm.weight.value.length > 0){
			 if(frmObj.calc_by_ind!=undefined){ 
				 if(frmObj.calc_by_ind.value=="W") {
					temp_qty	=	(parseFloat(qty_value)/parseFloat(headerForm.weight.value));
				}
				else if(frmObj.calc_by_ind.value=="B") {
					temp_qty	=	(parseFloat(qty_value)/parseFloat(headerForm.bsa.value));
					
			   }else
				 temp_qty=qty_value;
			 }else
				 temp_qty=qty_value;
		 }

		 if(temp_qty=="") 
			 temp_qty = qty_value;
		//ML-MMOH-CRF-1408 - end
		
		if(bl_install_yn=="Y" && bl_disp_charge_dtl_in_rx_yn=="Y"){
			blError = false;
			getBLErrorDrugs();
			if(blError){
				return false;
			}
		}
        var order_type_flag		=optionForm.order_type_flag.value;	   
		if(frmAdminObj.adMixture!=undefined){
			var iv_prep_yn	= frmAdminObj.adMixture.value;
			
			var iv_presc_yn="9";
			if(iv_prep_yn=='Y')
				iv_presc_yn="0";
			else
				iv_presc_yn="9";
			if(frmAdminObj.adMixture.style.visibility!='visible'){
				iv_presc_yn="9";
			}
		} 
		if( frmAdminObj.adMixture==undefined){
			iv_presc_yn="9";
		}		

		fluid_frame_display_yn	= frmFluidObj.fluid_frame_display_yn.value;
		var infusion_period_value		="";
		var infusion_period_value_uom	="";
		var infusion_rate				="";
        if(frmAdminObj.infusion_period_value!=undefined){
			infusion_period_value= frmAdminObj.infusion_period_value.value;

			infusion_period_value_uom=frmAdminObj.infuse_over_time_value.value;
			if(infusion_period_value_uom!=undefined){
              infusion_period_value_uom=infusion_period_value_uom;
			}
			else{
              infusion_period_value_uom=""; 
			}
			infusion_rate= frmAdminObj.infusion_rate.value;

		 }
		  var stock_uom_code="";
		 if(frmAdminObj.infuse_rate_uom!=undefined){
		   stock_uom_code=frmAdminObj.infuse_rate_uom.innerText;
         }
		var mfr_yn = "N";//ML-MMOH-CRF-1014
		var xmlStr 		= "<root><SEARCH "
		if(fluid_frame_display_yn=="Y"){
			if(frmFluidObj.MFR_YN_chk!= undefined && frmFluidObj.MFR_YN_chk.checked == true){ //ML-MMOH-CRF-104 
				mfr_yn = "Y";
			}

			xmlStr		+= " amend_fluid_code=\""+ frmFluidObj.fluid_code.value + "\" ";
			xmlStr		+= " amend_fluid_name=\""+ encodeURIComponent(frmFluidObj.fluid_name.value) + "\" ";//encode added for emr icn IN010060, IN073000
			xmlStr		+= " amend_stock_value=\""+ frmFluidObj.stock_value.value + "\" ";
			xmlStr		+= " amend_stock_uom=\""+ frmFluidObj.stock_uom.innerHTML + "\" ";
			xmlStr		+= " amend_stock_uom_val=\""+ frmFluidObj.stock_uom_val.value + "\" ";	
			xmlStr		+= " mfr_yn=\""+ mfr_yn + "\" ";    //ML-MMOH-CRF-1014
			xmlStr		+= " default_stock_val=\""+ frmFluidObj.default_stock_val.value + "\" ";    //ML-MMOH-CRF-1014
			
			if (frmFluidObj.fluid_name.value == '' || frmFluidObj.fluid_code.value == '')
			{
				alert(getMessage("FLUID_NAME_CANNOT_BE_BLANK","PH"));
				return false;
			}
			
		}
		else{
			xmlStr		+= " amend_fluid_code= '' ";
			xmlStr		+= " amend_fluid_name= '' ";
			xmlStr		+= " amend_stock_value='' ";
			xmlStr		+= " amend_stock_uom='' ";			
			xmlStr		+= " amend_stock_uom_val=''";
		}

		xmlStr		+= " amend_infusion_period_value=\""+ infusion_period_value + "\" ";
		xmlStr		+= " amend_infusion_period_uom=\""+ infusion_period_value_uom + "\" ";
		xmlStr		+= " amend_infusion_rate=\""+ infusion_rate + "\" ";		
        xmlStr		+= " stock_uom_code=\""+ stock_uom_code + "\" ";
		xmlStr		+= " DefaultFluidchanged=\""+ frmFluidObj.default_fluid_changed.value + "\" ";
		//ML-MMOH-CRF-1014 - start
		var mfr_durn_value =  "1";
		var mfr_durn_unit =  "H";
		var mfr_freq_chng_durn_desc = "H";
		var amend_repeat_value	= "1";

		if(mfr_yn=="Y"){
			xmlStr		+= "amend_durn_value=\""+ mfr_durn_value+ "\" ";
			xmlStr		+= "amend_durn_unit=\""+ mfr_durn_unit + "\" ";
			xmlStr		+="	freq_chng_durn_desc=\""+ mfr_freq_chng_durn_desc+"\" " ;
			xmlStr		+= "amend_repeat_value=\""+ amend_repeat_value + "\" ";
		}else{
			xmlStr		+= " amend_durn_value=\""+ frmAdminObj.durn_value.value + "\" ";
			xmlStr		+= " amend_durn_unit=\""+ frmAdminObj.durn_unit.value + "\" ";
			xmlStr		+="freq_chng_durn_desc"+"=\""+ frmAdminObj.freq_chng_durn_desc.value+"\" " ;
			xmlStr		+= " amend_repeat_value=\""+ frmAdminObj.repeat_value.value + "\" ";
		}//ML-MMOH-CRF-1014 - end	
		xmlStr		+= " amend_end_date=\""+ frmAdminObj.end_date.value + "\" ";
		xmlStr		+= " amend_start_date=\""+ frmAdminObj.start_date.value + "\" ";
		
		xmlStr		+= " amend_frequency=\""+ frmAdminObj.frequency.value + "\" ";
		xmlStr		+= " amend_frequency_desc=\""+ frmAdminObj.frequency.options[frmAdminObj.frequency.selectedIndex].text + "\" ";
		xmlStr		+= " schedulereqdyn=\""+ frmAdminObj.schedulereqdyn.value + "\" ";
		xmlStr		+= " iv_presc_yn=\""+ iv_presc_yn + "\" ";
		xmlStr		+= " order_type_flag=\""+ order_type_flag + "\" ";
		xmlStr		+= " fluid_frame_display_yn=\""+ fluid_frame_display_yn + "\" ";
		xmlStr		+= " repeat_value=\""+  frmAdminObj.repeat_value.value  + "\" ";
		xmlStr		+="location_type"+"=\""+ location_type+"\" " ;
		xmlStr		+="location_code"+"=\""+ location_code+"\" " ;
		xmlStr		+="priority"+"=\""+ priority+"\" " ;
		xmlStr		+="take_home_medication"+"=\""+ take_home_medication+"\" " ;
	//	xmlStr		+="freq_chng_durn_desc"+"=\""+ frmAdminObj.freq_chng_durn_desc.value+"\" " ;
		xmlStr		+="buildMAR_yn"+"=\""+ frmAdminObj.buildMAR_yn.value+"\" " ;
		xmlStr		+="no_of_cycle"+"=\""+frmAdminObj.no_of_cycle.value+"\" " ;//added for ML-MMOH-CRF-0345
		xmlStr		+="amend_durn_type"+"=\""+frmAdminObj.repeat_durn_type.value+"\" " ;//added for ML-MMOH-CRF-0345
		xmlStr		+="allow_alternate"+"=\""+ allow_alternate+"\" " ;//added for GHL-CRF-0549
		xmlStr		+="temp_qty"+"=\""+ temp_qty+"\" " ; //added for ML-MMOH-CRF-1408

		xmlStr		+= buildXMLString(frmObj)  + " /></root>";
		var bean_id			= frmObj.bean_id.value;
		var bean_name		= frmObj.bean_name.value;
		var patient_id		= frmObj.patient_id.value;
		var DrugIndicationRemarks  = frmObj.DrugIndicationRemarks.value;
		var validate_overide_on_confirm_yn  = frmObj.validate_overide_on_confirm_yn.value;//Added for IN:069887 
//commented by Anbarasi
		//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
		//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
		var xmlDoc = ""; 
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "OncologyRegimenValidate.jsp?patient_id="+patient_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&DrugIndicationRemarks="+DrugIndicationRemarks+"&validate_overide_on_confirm_yn="+validate_overide_on_confirm_yn+"&validate=AMENDDRUG", false);// Modified for IN:069887
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
}

function chkMandatoryFlds(calledMode) {
	var retStat 			= true;
	var optionForm			= parent.parent.oncology_options.document.onCologyOptions;
	
	var drgdtlsForm			= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
	var fluidForm			= parent.oncology_fluid.document.oncologyRegimenFluidDetail;
	var adminForm			= parent.oncology_admin.document.oncologyRegimenAdminDetail;
	var frmHdr				= parent. parent.parent.f_header.prescription_header_form;
	var fluid_frame_display_yn	= fluidForm.fluid_frame_display_yn.value;
	var drugRemarksMandatory = drgdtlsForm.DrugRemarksMandatory.value;//added for [IN:039576]
	var drugRemarksEntered		 = drgdtlsForm.DrugRemarksEntered.value;//added for [IN:039576]
	var mfr_yn = "N"; //ML-MMOH-CRF-1014 - start

	if(fluidForm.MFR_YN_chk!=undefined && fluidForm.MFR_YN_chk.checked==true)  
		  mfr_yn = "Y";
//ML-MMOH-CRF-1014 - end
	if (calledMode == "Amend") {
		if(optionForm.regimen.value==null || optionForm.regimen.value==""){
			alert(getMessgae("RGMN_CANT_BLANK","PH"));
			retStat = false;
		}
		if(drgdtlsForm.totalDose.value==null || drgdtlsForm.totalDose.value==""||drgdtlsForm.totalDose.value=="0"){
			alert(getMessage("DS_CANT_ZERO_BLANK","PH"));
			retStat = false;
		}
		
		else if(fluid_frame_display_yn!=undefined &&fluid_frame_display_yn=="Y" && (fluidForm.fluid_code.value==null || fluidForm.fluid_code.value=="")){
			alert(getMessage("FLUID_NAME_CANNOT_BE_BLANK","PH"));
			fluidForm.fluid_name.focus();
			retStat = false;
		}
		else if((adminForm.frequency.value==null || adminForm.frequency.value=="" )&& mfr_yn!="Y"){
			alert(getMessage("FRQ_CANT_BLANK","PH"));
			adminForm.frequency.focus();
			retStat = false;
		}
		else if(adminForm.start_date.value==null || adminForm.start_date.value==""){
			alert(getMessage("PH_START_DATE","PH"));
			adminForm.start_date.focus();
			retStat = false;
		}
		else if(((adminForm.durn_value.value==null || adminForm.durn_value.value=="" || adminForm.durn_value.value=="0" || adminForm.durn_unit.value==null || adminForm.durn_unit.value=="")  && mfr_yn!="Y")){//mfr_yn added for ML-MMOH-CRF-1014 
			alert(getMessage("DURATION_CANT_BLANK","PH"));
			adminForm.durn_value.focus();
			retStat = false;
		}
		else if(drgdtlsForm.calc_by_ind.value !=null && drgdtlsForm.calc_by_ind.value=="B"){
			if(frmHdr.bsa.value==null || frmHdr.bsa.value==""){
				alert(getMessage("BSA_CANT_BLANK","PH"));
				retStat = false;
			}
		}
		else if(drgdtlsForm.calc_by_ind.value !=null && drgdtlsForm.calc_by_ind.value=="W"){
			if(frmHdr.weight.value==null || frmHdr.weight.value==""){
				alert(getMessage("WGT_CANT_BLANK","PH"));
				retStat = false;
			}
		}
		
		if(adminForm.infusion_period_value != undefined){
			if((adminForm.infusion_period_value.value==null || adminForm.infusion_period_value.value=="" || adminForm.infusion_period_uom.value==null || adminForm.infusion_period_uom.value=="" || adminForm.infusion_period_value.value=="0") && mfr_yn!="Y"){//mfr_yn added for ML-MMOH-CRF-1014 
				alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
				adminForm.infusion_period_value.focus();
				retStat = false;
			}
		}			
		if(drugRemarksMandatory == 'Y' && drugRemarksEntered!='Y'){//if block added for [IN:039576]
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("ePH.DrugRemarks.label","PH"));
			alert(msg);
			drgdtlsForm.drug_remarks.click();
			return false;
		}
	}
	return retStat;
}

function buildXMLString(frmObj) {
	var xmlStr = "";
	var arrObj = frmObj.elements;
	var frmObjs = new Array()
	if(frmObj.name == null)
		frmObjs = frmObj;
	else frmObjs[0] = frmObj;

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount]
		var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "";
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked) {
					val = "Y";
				}
				else {
					val ="N";
				}
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked) {
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
				}
			}
			else if(arrObj[i].type == "select-multiple") {
				for(var j=0; j<arrObj[i].options.length; j++) {
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substring(0,val.lastIndexOf('~'))
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
			}
			else {
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
			}
		}
	}
	return xmlStr;
}

function chkDuration(obj) {
	var frmObj	= document.oncologyRegimenAdminDetail;
	if (checkWholeNumber(obj) ) {
		var objVal		= obj.value;
		var totInfPrd	= "";
		var totDurn		= "";

		if (frmObj.durn_unit.value == "M")
			totDurn	= parseInt(objVal);
		if (frmObj.durn_unit.value == "H")
			totDurn	= parseInt(objVal)*60;

		if (totDurn < totInfPrd) {
			alert(getMessage("DRN_GRT_TOT_INFS_PRD","PH"));
		}
		else{   
			changeDate();
		}
	}
	else{
		alert(getMessage("PH_WHOLE_NUMS_ALLOWED","PH"));
		obj.focus();
	}
}

function changeDate(){
	var frmObj	= document.oncologyRegimenAdminDetail;
	var durn_value	= frmObj.durn_value.value;
	
	
	if (!checkWholeNumber(frmObj.durn_value)){
		return;
	}
	var durn_unit	= frmObj.durn_unit.value;

	if (trimCheck(durn_value) != "" && trimCheck(durn_unit) != "") {
		var bean_id		= frmObj.bean_id.value;
		var bean_name	= frmObj.bean_name.value;
		var start_date	= frmObj.start_date.value;		
		var amend_yn	= frmObj.amend_yn.value;//ADDED FOR ML-MMOH-SCF-1050
		var freq_nature	= frmObj.freq_nature.value;//ADDED FOR ML-MMOH-SCF-1050
		//commented by Anbarasi
	//	var xmlDoc		= new ActiveXObject("Microsoft.XMLDom");
	//	var xmlHttp		= new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();

		xmlHttp.open("POST", "OncologyRegimenValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=POPULATEENDDATE&start_date="+start_date+"&durn_value="+durn_value+"&durn_unit="+durn_unit+"&amend_yn="+amend_yn+"&freq_nature="+freq_nature, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	}
	else {
		frmObj.end_date.value = "";
	}
}

function setEndDate(end_date, obj) {
	
	obj = eval(obj);
	obj.value = end_date;
	
}

async function loadDrugInfo(prodid, drugdesc) {

	var dialogHeight	="85vh" ;
	var dialogWidth	="70vw";
	var dialogTop		= "110" ;
	var dialogLeft		= "70" ;
	var center			= "0" ;
	var status			="no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal 				= await top.window.showModalDialog("../../ePH/jsp/DisplayDrugInfoFrames.jsp?extprodid="+prodid+"&drugdesc="+drugdesc+"&JSFile=../../ePH/js/Prescription_1.js",arguments,features);
}

function checkScheduledYN(objVal, mode) {
	var formObj		= document.oncologyRegimenAdminDetail;
	if (mode == undefined)
		mode = "";

	if (mode == "1")
		formObj		= parent.oncology_admin.document.oncologyRegimenAdminDetail;

	var bean_id		= formObj.bean_id.value;
	var bean_name	= formObj.bean_name.value;
	var durn_value	= formObj.durn_value.value;
	var durn_type = formObj.durn_unit.value; //priya

	var srl_no     =  formObj.srlNo.value;
	//commented by Anbarasi
	//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
	//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();

	xmlHttp.open("POST", "OncologyRegimenValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=GETSCHEDULEDFREQORNOT&freq_code="+objVal+"&mode="+mode+"&srl_no="+srl_no+"&durn_value="+durn_value+"&durn_type="+durn_type, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

function setSchedFreqActivated(objVal, repeat_value, mode,repeat_durn_type) {

	var obj = "";
	if (eval(objVal)) {
		
		parent.oncology_admin.document.oncologyRegimenAdminDetail.schedulereqdyn.value="Y";
		if(parent.oncology_admin.document.oncologyRegimenAdminDetail.btn_schedule)
		parent.oncology_admin.document.oncologyRegimenAdminDetail.btn_schedule.disabled=false;
	}
	else {
		parent.oncology_admin.document.oncologyRegimenAdminDetail.schedulereqdyn.value="N";
		if(parent.oncology_admin.document.oncologyRegimenAdminDetail.btn_schedule)
		parent.oncology_admin.document.oncologyRegimenAdminDetail.btn_schedule.disabled=true;
	}

	if (mode == "1")
	{
		parent.oncology_admin.document.oncologyRegimenAdminDetail.repeat_value.value = repeat_value;
		parent.oncology_admin.document.oncologyRegimenAdminDetail.repeat_durn_type.value = repeat_durn_type; //added for IN26009 --20/01/2011-- priya
	}
	else
	{
		document.oncologyRegimenAdminDetail.repeat_value.value = repeat_value;
		document.oncologyRegimenAdminDetail.repeat_durn_type.value = repeat_durn_type; //added for IN26009 --20/01/2011-- priya
	}
}

function refreshLocation(patient_id, encounter_id, problem_ind, start_date,mode) {
	
    var frmObj			   = parent.parent.oncology_options.document.onCologyOptions;
	var order_type_flag   = frmObj.order_type_flag.value;
	var order_id	       = frmObj.order_id.value;
	var order_type_flag	       = frmObj.order_type_flag.value;
	var adr_count			= parent.parent.parent.f_header.prescription_header_form.adr_count.value;
	var bl_install_yn				= parent.parent.parent.f_header.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	= parent.parent.parent.f_header.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var preview_rx_yn	= parent.parent.parent.f_header.prescription_header_form.preview_rx_yn.value;//added for ML-MMOH-CRF-0341 [IN:057179]
	var MAR_app_yn	= getMAR_app_yn(parent.parent.parent.f_header.prescription_header_form);
	var drug_db_interface_yn = frmObj.drug_db_interface_yn.value;

	if (mode == "1") {
		parent.f_oncology_regimen_drug_list.location.href		= "../jsp/IVPrescriptionDrugList.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&adr_count="+adr_count+"&MAR_app_yn="+MAR_app_yn;
	}
	else {		
		parent.parent.oncology_drugs.f_oncology_regimen_drug_list.location.href	= "../jsp/OncologyRegimenDrugList.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&problem_ind="+problem_ind+"&start_date="+start_date+"&order_type_flag="+order_type_flag+"&order_id="+order_id+"&adr_count="+adr_count+"&MAR_app_yn="+MAR_app_yn;
		parent.f_oncology_sub_drugs.location.href="../jsp/OncologyRegimenDrugDetails.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&problem_ind="+problem_ind+"&start_date="+start_date+"&order_type_flag="+order_type_flag+"&order_id="+order_id+"&MAR_app_yn="+MAR_app_yn;
		parent.oncology_fluid.location.href		= "../jsp/OncologyRegimenFluidDetail.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&problem_ind="+problem_ind+"&start_date="+start_date+"&order_type_flag="+order_type_flag+"&order_id="+order_id+"&MAR_app_yn="+MAR_app_yn;
		parent.oncology_admin.location.href		= "../jsp/OncologyRegimenAdminDetail.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&problem_ind="+problem_ind+"&start_date="+start_date+"&order_type_flag="+order_type_flag+"&order_id="+order_id+"&MAR_app_yn="+MAR_app_yn;
		parent.oncology_button.location.href	= "../jsp/OncologyRegimenButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&MAR_app_yn="+MAR_app_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&iv_prep_yn=9+&order_type_flag="+order_type_flag;	
		parent.parent.oncology_drugs.f_preview_buttons.location.href="OncologyRegimenPreviewButtons.jsp?&disable_yn=Y"+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&drug_db_interface_yn="+drug_db_interface_yn+"&preview_rx_yn="+preview_rx_yn; //added preview_rx_yn for ML-MMOH-CRF-0341 [IN:057179]
	}
}

function checkDose(obj,low_dosage,high_dosage){
	if(CheckNum(obj)){
		getLimiInd();//Added for IN:070451
		if(obj.value=="" || parseFloat(obj.value)==0 ) { // 'parseInt(obj.value)==0 || obj.value==""' changed to 'obj.value=="" || parseFloat(obj.value)==0' for SRR20056-SCF-7772 ICN 28135 
			alert(getMessage("ZERO_NOT_ALLOWED","PH")+"Dose");
			obj.focus();
			return;
		}

		if(low_dosage!=null)
			low_dosage  	= Math.ceil(low_dosage);
		if(high_dosage!=null)
			high_dosage  	= Math.ceil(high_dosage);
		var frmObj			= parent.f_oncology_regimen_button
		var thisform		=parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
		var calc_by_ind	= thisform.calc_by_ind.value;
		/*if(checkWholeNumber(obj))
		{
			if(obj.value!="")
			{
				if((calc_by_ind=="B" || calc_by_ind=="W" ) && high_dosage!=0 && (obj.value > high_dosage))
				{
					 frmObj.over_ride.style.display 		= "block";
					 frmObj.over_ride_mand.style.display 	= "block";
					 thisform.exceedDosageReasonMand.value="Y";
				}
				else if((calc_by_ind=="B" || calc_by_ind=="W" ) && low_dosage!=0 && (obj.value < low_dosage))
				{
					frmObj.over_ride.style.display 		= "block";
					frmObj.over_ride_mand.style.display = "block";
					 thisform.exceedDosageReasonMand.value="Y";

				}
				else
				{
					frmObj.over_ride.style.display 		= "none";
					frmObj.over_ride_mand.style.display = "none";
				}
			}
			else
			{
				frmObj.over_ride.style.display 		= "none";
				frmObj.over_ride_mand.style.display = "none";
			}
		}*/
	}
}

async function ScreeningDetails(patient_id,encounter_id,note_type,patient_class,accession_num,oncology_screening_type,date_of_birth,sex){
	if(oncology_screening_type=="N")
	{
	 var function_id="SPCL_NOTE";
     BeforeCheckNoteType(encounter_id,note_type,patient_id)
	 var accession_num  =  document.onCologyOptions.accession_num.value;
	 window.open("../../eCA/jsp/RecClinicalNotesModal.jsp?patient_id="+escape(patient_id)+"&encounter_id="+encounter_id+"&note_type="+note_type+"&patient_class="+patient_class+"&accession_num="+accession_num+"&function_id="+function_id+"&appl_task_id=PH_NOTES",null,"height=650,width=1010,top=75,left=0,resizable=yes,status=yes,toolbar=no,menubar=no,location=no");
	}
	else if(oncology_screening_type=="D")
	{
	   BeforeCheckDiscrete(encounter_id,note_type,patient_id)
	   var test_observ_dt_tm  =  document.onCologyOptions.test_observ_dt_tm.value;
	   var mode="";
	   var module_id="PH";
	   var ca_practitioner_id="";
	   if(test_observ_dt_tm==''){mode="I";}
	   else{  mode="U";	 } 
	   var dialogHeight	= "50vh" ;
	   var dialogWidth	= "60vw" ;
	   var dialogTop	= "100" ;
	   var center		= "1" ;
	   var status		= "no";
	   var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	   var arguments	= "" ;
	   retVal			= await window.showModalDialog( "../../ePH/jsp/DisDataChartingFrame.jsp?date_of_birth="+date_of_birth+"&patient_id="+escape(patient_id)+"&sex="+sex+"&mode="+mode+"&last_record_date="+test_observ_dt_tm+"&encounter_id="+encounter_id+"&episode_id="+encounter_id+"&battery_id="+note_type+"&module_id="+module_id+"&patient_class="+patient_class+"&ca_practitioner_id="+ca_practitioner_id, arguments, features );

	 }
  	
}
  function BeforeCheckDiscrete(encounter_id,note_type,patient_id)
  {
	
	var bean_id="@OncologyRegimenBean"+patient_id+encounter_id;
	var bean_name="ePH.OncologyRegimenBean";
	
	var xmlStr 			="<root><SEARCH /></root>";
	var xmlDoc			= "";
    var xmlHttp			= new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","OncologyRegimenValidate.jsp?encounter_id="+encounter_id+"&note_type="+note_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&validate=Discrete",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
	//alert(responseText)
  }

function checkbeforeReleaseRx(encounter_id,note_type,patient_id){
	var bean_id="@OncologyRegimenBean"+patient_id+encounter_id;
	var bean_name="ePH.OncologyRegimenBean";
	
	var xmlStr 			="<root><SEARCH /></root>";
	var xmlDoc			= "";
    var xmlHttp			= new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","OncologyRegimenValidate.jsp?encounter_id="+encounter_id+"&note_type="+note_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&validate=beforeDiscrete",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
	//alert(responseText)
}

 function CheckbeforeDis(test_observ_dt_tm){
	var order_type_flag=parent.parent.oncology_options.document.onCologyOptions.order_type_flag.value;
	if(test_observ_dt_tm!= ''){
		if(order_type_flag=="Existing")
			amendreleaseOncology();     //for Amend order release
		else 
			newreleaseOncology();        //for New order release
	}
	else
		alert(getMessage('SCREENIN_GDETAILS','PH'));
}

function beforDiscrete(test_observ_dt_tm){
	document.onCologyOptions.test_observ_dt_tm.value=test_observ_dt_tm;  
}
    
function BeforeCheckNoteType(encounter_id,note_type,patient_id){	
	var bean_id="@OncologyRegimenBean"+patient_id+encounter_id;
	var bean_name="ePH.OncologyRegimenBean";
	
	var xmlStr 			="<root><SEARCH /></root>";
	var xmlDoc			= "";
    var xmlHttp			= new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","OncologyRegimenValidate.jsp?encounter_id="+encounter_id+"&note_type="+note_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&validate=before",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
	//alert(responseText)
}
  
function beforAccessionNumber(accession_num){
	document.onCologyOptions.accession_num.value=accession_num;  
}


function callPreviewButtons(encounter_id,note_type,patient_id) {	
	var bean_id="@OncologyRegimenBean"+patient_id+encounter_id;
	var bean_name="ePH.OncologyRegimenBean";	
	var xmlStr 			="<root><SEARCH /></root>";
	var xmlDoc			= "";
    var xmlHttp			= new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","OncologyRegimenValidate.jsp?encounter_id="+encounter_id+"&note_type="+note_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&validate=AccessionNumber",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
	//alert(responseText)
}

function CheckAccessionNumber(accession_num){
	if(accession_num!= '') 
		newreleaseOncology();        //for New order release
	else
		alert(getMessage('SCREENIN_GDETAILS','PH'));
}

function releaseOncology(){
	var frmObj			= parent.parent.oncology_options.document.onCologyOptions;
	var order_type_flag=frmObj.order_type_flag.value;
	var accession_num=document.OncologyRegimenPrescriptionButtons.accession_num.value;
	var encounter_id=document.OncologyRegimenPrescriptionButtons.encounter_id.value;
	var note_type=document.OncologyRegimenPrescriptionButtons.note_type.value;
	var patient_id=document.OncologyRegimenPrescriptionButtons.patient_id.value;
	var oncology_screening_type=document.OncologyRegimenPrescriptionButtons.oncology_screening_type.value;
	var dflt_disp_locn_lbl =parent.oncology_button.document.getElementById('dflt_disp_locn_lbl').innerText;//added for NMC-JD-CRF-0063 start
	var act_patient_class =frmObj.act_patient_class.value; 
	if(act_patient_class=="OP"){
		if(dflt_disp_locn_lbl=="" || dflt_disp_locn_lbl==null)
		{
			alert(getMessage("PH_MANDATORY", "PH"));
			return false;
		}
	}//END
	
	
	var bean_id			= frmObj.bean_id.value;
	var bean_name		= frmObj.bean_name.value;
	var patient_id		= frmObj.patient_id.value;

	var xmlStr		= "<root><SEARCH ";
		xmlStr			+= " /></root>";
		//commented by Anbarasi
	//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
	//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "OncologyRegimenValidate.jsp?patient_id="+patient_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&validate=OverRideReasonChecks", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);

	if(oncology_screening_type =="N"){
		callPreviewButtons(encounter_id,note_type,patient_id)
	}
	else if(oncology_screening_type =="D"){
		checkbeforeReleaseRx(encounter_id,note_type,patient_id)
	}

   	if(rsns_flag == 'true'){ //code changed  by kiran on 19/3/2010 changed to 'true' instead of true		
		if(order_type_flag=="Existing"){
			amendreleaseOncology();     //for Amend order release
		}
		else{
			if (accession_num == "" && oncology_screening_type =="") 
				newreleaseOncology();        //for New order release
	   }
	}//end if
}

function changeRsnStatus(rsnFlag){
	rsns_flag = rsnFlag;
}

function amendreleaseOncology(){
	var formObj		= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
	var frmHdr		= parent.parent.parent.f_header.prescription_header_form
	var bean_id		= formObj.bean_id.value;
	var bean_name	= formObj.bean_name.value;
	var optionForm		= parent.parent.oncology_options.document.onCologyOptions;
	var adminForm		= parent.oncology_admin.document.oncologyRegimenAdminDetail;
	//checkScheduledYN(adminForm.FREQUENCY.value, "1");
	var th_medn		= parent.parent.parent.f_header.prescription_header_form.take_home_medication.value;
	var height		=parent.parent.parent.f_header.prescription_header_form.height.value;
	var height_unit	= parent.parent.parent.f_header.prescription_header_form.height_unit.value;
	if (height_unit == "")
		height_unit	= "Cms";
	//var buildMAR_yn	= adminForm.buildMAR_yn.value;

	var weight		= parent.parent.parent.f_header.prescription_header_form.weight.value;
	var weight_unit	= parent.parent.parent.f_header.prescription_header_form.weight_unit.value;
	if (weight_unit == "")
		weight_unit	= "Kgs";
	var bsa			= parent.parent.parent.f_header.prescription_header_form.bsa.value;
	var bsa_unit	= "BSA";

	var priority	= parent.parent.parent.f_header.prescription_header_form.priority.value;
	var take_home_medication	= parent.parent.parent.f_header.prescription_header_form.take_home_medication.value;
	var bmi			= parent.parent.parent.f_header.prescription_header_form.bmi.value;

	var iv_presc_yn="0";		
	var bean_id		= adminForm.bean_id.value;
	var bean_name	= adminForm.bean_name.value;

	/* From the Header Frame */
	var pract_id	   = frmHdr.pract_id.value;
	var pract_name	   = frmHdr.pract_name.value;
	var locn_type	   = frmHdr.source_type.value;
	var locn_code	   = frmHdr.source_code.value;
	var order_date	   = frmHdr.sys_date.value;

	var regimen_code   =optionForm.regimen.value
	var Intention_code =optionForm.intention.value
	var stage_code     =optionForm.stage.value			
	/* End */
	var xmlStr		= "<root><SEARCH ";
	xmlStr			+= " priority=\""+ priority + "\" ";
	xmlStr			+= " height=\""+ height + "\" ";
	xmlStr			+= " height_unit=\""+ height_unit + "\" ";
	xmlStr			+= " weight=\""+ weight + "\" ";
	xmlStr			+= " weight_unit=\""+ weight_unit + "\" ";
	xmlStr			+= " bsa=\""+ bsa + "\" ";
	xmlStr			+= " bsa_unit=\""+ bsa_unit + "\" ";
	xmlStr			+= " bmi=\""+ bmi + "\" ";
	xmlStr			+= " iv_presc_yn=\""+ iv_presc_yn + "\" ";
	xmlStr			+= " take_home_medication=\""+ take_home_medication + "\" ";
	xmlStr			+= " pract_id=\""+ pract_id + "\" ";
	xmlStr			+= " pract_name=\""+ pract_name + "\" ";
	xmlStr			+= " locn_code=\""+ locn_code + "\" ";
	xmlStr			+= " locn_type=\""+ locn_type + "\" ";
	xmlStr			+= " order_date=\""+ order_date + "\" ";
	xmlStr			+= " regimen_code=\""+ regimen_code + "\" ";
	xmlStr			+= " Intention_code=\""+ Intention_code + "\" ";
	xmlStr			+= " stage_code=\""+ stage_code + "\" ";		
	//xmlStr			+= " buildMAR_yn=\""+ buildMAR_yn + "\" ";		
	xmlStr			+= " /></root>";
	var qryString	= bean_id+"&bean_name="+bean_name+"&validate=AMENDRELEASE";
	submitXML(qryString, xmlStr);

	if(result){   
		alert(getMessage("RECORD_INSERTED","PH"));
		onSuccess();
	}
	else{
		if (message != '')
			alert(message);
	}
}

async function newreleaseOncology() {
	var formObj			= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
	var frmHdr			= parent.parent.parent.f_header.prescription_header_form;
	var bean_id			= formObj.bean_id.value;
	var bean_name		= formObj.bean_name.value;
	var optionForm		= parent.parent.oncology_options.document.onCologyOptions;
	var adminForm		= parent.oncology_admin.document.oncologyRegimenAdminDetail;
	var th_medn		= parent.parent.parent.f_header.prescription_header_form.take_home_medication.value;
	var height		=parent.parent.parent.f_header.prescription_header_form.height.value;
	var height_unit	= parent.parent.parent.f_header.prescription_header_form.height_unit.value;
	if (height_unit == "")
		height_unit	= "Cms";

	var patient_class		= parent.parent.parent.f_header.prescription_header_form.patient_class.value;
	var weight		= parent.parent.parent.f_header.prescription_header_form.weight.value;
	var weight_unit	= parent.parent.parent.f_header.prescription_header_form.weight_unit.value;
	if (weight_unit == "")
		weight_unit	= "Kgs";

	var bsa			= parent.parent.parent.f_header.prescription_header_form.bsa.value;
	var bsa_unit	= "BSA";

	var priority	= parent.parent.parent.f_header.prescription_header_form.priority.value;
	var take_home_medication	= parent.parent.parent.f_header.prescription_header_form.take_home_medication.value;
	var bmi			= parent.parent.parent.f_header.prescription_header_form.bmi.value;
	
	var iv_presc_yn="0";		
	var bean_id		= adminForm.bean_id.value;
	var bean_name	= adminForm.bean_name.value;
	//var buildMAR_yn	= adminForm.buildMAR_yn.value;

	/* From the Header Frame */
	var pract_id	   = frmHdr.pract_id.value;
	var pract_name	   = frmHdr.pract_name.value;
	var locn_type	   = frmHdr.source_type.value;
	var locn_code	   = frmHdr.source_code.value;
	var order_date	   = frmHdr.sys_date.value;
	var regimen_code   =optionForm.regimen.value
	var Intention_code =optionForm.intention.value
	var stage_code     =optionForm.stage.value			
	/* End */
	var xmlStr		= "<root><SEARCH ";
	xmlStr			+= " priority=\""+ priority + "\" ";
	xmlStr			+= " height=\""+ height + "\" ";
	xmlStr			+= " height_unit=\""+ height_unit + "\" ";
	xmlStr			+= " weight=\""+ weight + "\" ";
	xmlStr			+= " weight_unit=\""+ weight_unit + "\" ";
	xmlStr			+= " bsa=\""+ bsa + "\" ";
	xmlStr			+= " bsa_unit=\""+ bsa_unit + "\" ";
	xmlStr			+= " bmi=\""+ bmi + "\" ";
	xmlStr			+= " iv_presc_yn=\""+ iv_presc_yn + "\" ";
	xmlStr			+= " take_home_medication=\""+ take_home_medication + "\" ";
	xmlStr			+= " pract_id=\""+ pract_id + "\" ";
	xmlStr			+= " pract_name=\""+ pract_name + "\" ";
	xmlStr			+= " locn_code=\""+ locn_code + "\" ";
	xmlStr			+= " locn_type=\""+ locn_type + "\" ";
	xmlStr			+= " order_date=\""+ order_date + "\" ";
	xmlStr			+= " regimen_code=\""+ regimen_code + "\" ";
	xmlStr			+= " Intention_code=\""+ Intention_code + "\" ";
	xmlStr			+= " stage_code=\""+ stage_code + "\" ";		
	//xmlStr			+= " buildMAR_yn=\""+ buildMAR_yn + "\" ";		
	xmlStr			+= " /></root>";
	var qryString	= bean_id+"&bean_name="+bean_name+"&validate=RELEASE";
	submitXML(qryString, xmlStr);
	if(result){   
		alert(getMessage("RECORD_INSERTED","PH"));
		if(patient_class=='OP' || patient_class=='EM'){
			var xmlStr 			="<root><SEARCH /></root>";
			var xmlDoc			= "";
			var xmlHttp			= new XMLHttpRequest();
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","OncologyRegimenValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=GET_TRNGROUPREF",false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			responseText=trimString(responseText);

			if(responseText != undefined && responseText!=null && responseText !=""){
				var dialogHeight	="15" ;
				var dialogWidth	="30";
				var dialogTop	= "300" ;
				var dialogLeft	= "300" ;
				var center			= "1" ;
				var status			="no";
				var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "";
				retVal = await window.showModalDialog("../../ePH/jsp/TokenListForOrders.jsp?trn_group_ref="+responseText,arguments,features);
			}
		}
		onSuccess();
	}
	else{
		if (message != '')
		{
			alert(message);
		}
	}
}

function callCancel(){
	
var diagnosis_found_yn=parent.f_oncology_sub_drugs.onCologyRegimenDrugDetails.diagnosis_found_yn.value;//added for mms-dm-crf-0204
var ord_set_reqd_or_opt = parent.f_oncology_sub_drugs.onCologyRegimenDrugDetails.ord_set_reqd_or_opt.value;
 
if(diagnosis_found_yn=="N" && ord_set_reqd_or_opt == 'R'){
	alert(getMessage("REQ_DIAG_PRES_NOT_FOUND",'PH'));
	alert(getMessage("PH_CANCEL_ORDERSET_DRUG_FROM_RX", "PH"));
	delete_confirm=false;
	return false;
}
else if(diagnosis_found_yn=="N"){
	alert(getMessage("REQ_DIAG_PRES_NOT_FOUND",'PH'));
	delete_confirm=true; 
}
	
	else {var delete_confirm=confirm(getMessage("CANCEL_SEL_DRUG","PH"))
	if(!delete_confirm)
		return;
	}
	var frmObj			= parent.f_oncology_sub_drugs.onCologyRegimenDrugDetails;
	var patient_class	= frmObj.patient_class.value;
	var drug_code		= frmObj.drug_code.value;
	var ocurrance_num		= frmObj.ocurrance_num.value;	
	var srl_no			= frmObj.srl_no.value;
	var bean_id			= frmObj.bean_id.value;
	var bean_name		= frmObj.bean_name.value;
	var patient_id		= frmObj.patient_id.value;
	var qryString		= bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&validate=DELETEDRUG&drug_code="+drug_code+"&srl_no="+srl_no+"&ocurrance_num="+ocurrance_num;
	submitXML(qryString, "");

	/*var frmObj1		= parent.parent.f_ivadmin.document.formIVPrescriptionAdminDetail;
	var drug_array	= frmObj.drug_codes.value.split(",");
	var num_drugs	= drug_array.length-1;

	if (num_drugs <= 1 && frmObj.FREQ_CODE.value == frmObj1.FREQUENCY.value) {
		frmObj1.FREQUENCY.value		= "";
		frmObj1.FREQUENCY.disabled	= true;
		frmObj1.REPEAT_VALUE.value	= "";
		frmObj1.FREQ_NATURE.value	= "";
	}
	*/
}

function submitXML(qryString, xmlStr) {
	//commented by Anbarasi
	//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
	//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();

	if (xmlStr != "")
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST", "OncologyRegimenValidate.jsp?bean_id="+qryString, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);
}

async function showOverRideRemarks(amend_serial_no, limit_ind) {
	getLimiInd();//Added for IN:070451
	var frmObj			= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
	var frmDrgList		= parent.parent.oncology_drugs.f_oncology_regimen_drug_list;
	var patient_id		= frmObj.patient_id.value;
	var encounter_id	= frmObj.encounter_id.value;
	var generic_id		= frmObj.generic_id.value;
	var generic_name	= frmObj.generic_name.value;
	var drug_desc		= encodeURIComponent(frmObj.drug_desc.value);//Modified for IN:073485 
	var daily_dose		= frmObj.daily_dose.value;
	var unit_dose		= frmObj.unit_dose1.value;//Modified for IN:070451
	var mono_graph		= frmObj.mono_graph.value;
	if(limit_ind == undefined || limit_ind=='')
		limit_ind		= frmObj.limit_ind.value;
	var allergy_yn		= frmObj.allergy_yn.value;
	var current_rx		= frmObj.current_rx.value;
	var drug_code		= frmObj.drug_code.value;
	var srl_no			= frmObj.srl_no.value;
	var allergy			= frmObj.allergy_desc.value;
	var exceed_dose		= frmObj.exceed_dose_desc.value;
	var dup_drug		= frmObj.dup_drug_desc.value;
	var min_unit_dose	= frmObj.min_unit_dose1.value;//Modified for IN:070451
	var min_daily_dose	= frmObj.min_daily_dose.value;
	var dosage_unit	    = frmObj.drug_unit.value;
  //Added for IN:070451 start
	var max_daily_ceeling_dose	= frmObj.max_daily_ceeling_dose.value;
	var min_daily_ceeling_dose	= frmObj.min_daily_ceeling_dose.value;
	var max_unit_ceeling_dose	= frmObj.max_unit_ceeling_dose.value;
	var min_unit_ceeling_dose	= frmObj.min_unit_ceeling_dose.value;
	var dose_unit_desc	= frmObj.dose_unit_desc.value;
	var dose_unit_desc1	= frmObj.dose_unit_desc1.value;
	var dosage_std	= frmObj.dosage_std.value;
	//Added for IN:070451 end
	//Added for IN:072715 start
	var allergy_remarks_code=frmObj.allergy_remarks_code.value;
	var dose_remarks_code=frmObj.dose_remarks_code.value;
	var currentrx_remarks_code=frmObj.currentrx_remarks_code.value;
	
	//Added for IN:072715 end
	var drug_db_interface_yn	= frmDrgList.document.oncologyRegimenDrugList.drug_db_interface_yn.value;
	var drug_db_duptherapy_flag = parent.parent.oncology_drugs.f_oncology_regimen_drug_list.document.getElementById("ext_med_alerts_fired_for_dup_check_yn"+srl_no).value;
	
	var drug_db_allergy_flag		= parent.parent.oncology_drugs.f_oncology_regimen_drug_list.document.getElementById("ext_med_alerts_fired_for_allergy_check_yn"+srl_no).value;

	var dialogHeight	= "20";
	if(current_rx=="Y" && limit_ind=="N" && allergy_yn=="Y")
		dialogHeight	= "25";
	else if ( (current_rx=="Y" && limit_ind=="N") || (current_rx=="Y" && allergy_yn=="Y") || (limit_ind=="N" && allergy_yn=="Y" ))
		dialogHeight	= "20";
	else
		dialogHeight	= "11";

	var dialogWidth	= "42";
	var dialogTop	= "285";
	var dialogLeft	= "290";
	var center		= "0";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "";


	retArray		= await window.showModalDialog("../../ePH/jsp/OncologyOverRideReason.jsp?gen_id="+generic_id+"&gen_name="+generic_name+"&pat_id="+patient_id+"&enc_id="+encounter_id+"&drug_desc="+drug_desc+"&mono_graph="+mono_graph+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&limit_ind="+limit_ind+"&drug_code="+drug_code+"&srl_no="+srl_no+"&allergy="+allergy+"&exceed_dose="+exceed_dose+"&dup_drug="+dup_drug+"&min_unit_dose="+min_unit_dose+"&min_daily_dose="+min_daily_dose+"&dosage_unit="+dosage_unit+"&amend_serial_no="+amend_serial_no+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_duptherapy_flag="+drug_db_duptherapy_flag+"&drug_db_allergy_flag="+drug_db_allergy_flag+"&max_daily_ceeling_dose="+max_daily_ceeling_dose+"&min_daily_ceeling_dose="+min_daily_ceeling_dose+"&max_unit_ceeling_dose="+max_unit_ceeling_dose+"&min_unit_ceeling_dose="+min_unit_ceeling_dose+"&dose_unit_desc="+dose_unit_desc+"&dose_unit_desc1="+dose_unit_desc1+"&dosage_std="+dosage_std+"&allergy_remarks_code="+allergy_remarks_code+"&dose_remarks_code="+dose_remarks_code+"&currentrx_remarks_code="+currentrx_remarks_code+"&atc_allergy_generic_id=", arguments, features);//Modified for IN:070451,Modified for IN:072715

	if (retArray!=undefined && retArray != null && retArray != "") {
		var retRemarks = retArray.split(":::");
		if(retRemarks[0] != ""){
			if(parent.parent.oncology_drugs.f_oncology_regimen_drug_list.document.getElementById("allergy"+srl_no) != undefined){
				parent.parent.oncology_drugs.f_oncology_regimen_drug_list.document.getElementById("allergy"+srl_no).style.visibility = "hidden";		
			}
		}

		if(retRemarks[2] != ""){
			if(parent.parent.oncology_drugs.f_oncology_regimen_drug_list.document.getElementById("duplicate"+srl_no) != undefined){
				parent.parent.oncology_drugs.f_oncology_regimen_drug_list.document.getElementById("duplicate"+srl_no).style.visibility = "hidden";		
			}
		}
		//Added for IN:072715 start to fix exsting bug
		frmObj.allergy_desc.value		= retRemarks[0];
		frmObj.exceed_dose_desc.value	= retRemarks[1];
		frmObj.dup_drug_desc.value		= retRemarks[2];
		frmObj.allergy_remarks_code.value		= retRemarks[3];
		frmObj.dose_remarks_code.value	= retRemarks[4];
		frmObj.currentrx_remarks_code.value		= retRemarks[5];
		//Added for IN:072715  end to fix exsting bug
	}

}
function callOnMouseOver(obj){
	obj.className = "CASECONDSELECTHORZ";
}

function callOnMouseOut(obj) {
	obj.className = "CAFIRSTSELECTHORZ";
}

function assignResult( _result, _message, _flag , _narcotic_yn, _print_ord_sht_rule_ind) {//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
	result = _result ;
	message  = _message ;
	flag = _flag ;
	narcotic_yn = _narcotic_yn;
	print_ord_sht_rule_ind=_print_ord_sht_rule_ind;
}

async function onSuccess(){
	
	var formObj			= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
	var hdrForm = parent.parent.parent.f_header.prescription_header_form;
	var narcotic_aprvl_form_req_yn = hdrForm.narcotic_aprvl_form_req_yn.value;
	var print_narcotic_form_by_default = hdrForm.print_narcotic_form_by_default.value;
	if(narcotic_yn == "N"){
		narcotic_aprvl_form_req_yn = "";
		print_narcotic_form_by_default="";
	}

	var dialogHeight	="12" ;
	var dialogWidth	="30";
	var dialogTop	= "300" ;
	var dialogLeft	= "300" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') || narcotic_aprvl_form_req_yn=="Y")//print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
		retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionPrintDialog.jsp?narcotic_aprvl_form_req_yn="+narcotic_aprvl_form_req_yn+"&print_narcotic_form_by_default="+print_narcotic_form_by_default+"&called_from=ONCO"+"&print_ord_sht_rule_ind="+print_ord_sht_rule_ind,arguments,features);//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0

	
	if(((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal != undefined && retVal[0] != "CANCEL") || print_ord_sht_rule_ind =='S'){//print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
		if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal.length >0){
			callReport(formObj,retVal[0],retVal[1],print_ord_sht_rule_ind);//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0 
		}
		else{
			if(print_ord_sht_rule_ind=="S"){
				callReport(formObj,"Y","N",print_ord_sht_rule_ind);
				if(narcotic_aprvl_form_req_yn=="Y"){
					callReport(formObj,"Y","Y",print_ord_sht_rule_ind); 
				}
			}
		}
	}

/*	var print_confirm=confirm("Do you want to print the Prescription")
	if(print_confirm){
		callReport(formObj);
	}*/
	
	var bean_id			= formObj.bean_id.value;
	var bean_name		= formObj.bean_name.value;
	var xmlStr 			="<root><SEARCH /></root>";
	var xmlDoc			= "";
    var xmlHttp			= new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","OncologyRegimenValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=clearData",false);
	
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	
	eval(responseText);

}
function printOnlinePrescription(formObj,okCancel,print_ord_sht_rule_ind){//pres_print,Added for Bru-HIMS-CRF-393_1.0

	 var retval= new Array();
	if(okCancel=='OK'){//If and Else If added for Bru-HIMS-CRF-393_1.0 
		if(print_ord_sht_rule_ind=="C" && formObj.prescriptionPrint.checked)
			retval[0]="Y";
		else if(print_ord_sht_rule_ind=="S")
			retval[0]="Y";
		else	
			retval[0]="N";
		if(formObj.NarcoticPrint != undefined && formObj.NarcoticPrint.checked)
			retval[1]="Y";
		else	
			retval[1]="N";
	}else{
        retval[0]='CANCEL';
	 
	}

//     window.returnValue=retval;
//	 window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = retVal;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
	
	
}
// For Drug Interactions
async function viewInteraction(patientid,orderid,encounterid){
	var dialogHeight	= "18" ;
	var dialogWidth		= "40";
	var dialogTop		= "270" ;
	var dialogLeft		= "200" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal			    = await window.showModalDialog("../../ePH/jsp/DisplayInteractionsFrames.jsp?patientid="+patientid+"&orderid="+orderid+"&encounterid="+encounterid+"&JSFile=../../ePH/js/OncologyRegimen.js",arguments,features);

}
function closeInteraction(){
	//this.window.close();
	
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}

function assignValue(obj) {
	if(obj.checked==true)
		obj.value="Y";
	else
		obj.value="N";
}

function mandateRemarks() {
	alert(getMessage("OVR_RDN_RSN-CANT_BLNK","PH"));
}

function reloadPage(){
	var frmObj			= parent.parent.oncology_options.document.onCologyOptions;

	var order_type_flag=frmObj.order_type_flag.value;
	
	if(order_type_flag=="Existing"){
		//parent.window.close();
		
	    
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();  
	}
	else{ 
		//parent.parent.parent.parent.criteriaCategoryButtonFrame.location.reload();
		parent.parent.parent.parent.parent.parent.location.reload();
					
    }
}

async function preview() {
	
	var optionForm		= parent.parent.oncology_options.document.onCologyOptions;
	var drgdtlsForm		= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
	var fluidForm		= parent.oncology_fluid.document.oncologyRegimenFluidDetail;
	var adminForm		= parent.oncology_admin.document.oncologyRegimenAdminDetail;
	var titletext		= "Oncology Preview";
	var patient_id		= drgdtlsForm.patient_id.value;
	var encounter_id	= drgdtlsForm.encounter_id.value;
	var date			= drgdtlsForm.start_date.value;
	var pract_name		= drgdtlsForm.pract_name.value;
	var patient_class	= drgdtlsForm.patient_class.value;
	var bean_id			= drgdtlsForm.bean_id.value;
	var bean_name		= drgdtlsForm.bean_name.value;
	var locn_code		= drgdtlsForm.locn_code.value;
	var site_spec_YN         =adminForm.site_spec_YN.value;//added for ml-mmoh-crf-1224
	var dialogHeight	= "50vh";
	var dialogWidth		= "70vw";//MODIFIED FROM 60 TO 70 FOR ML-MMOH-CRF-1224
	var dialogTop		= "220";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	var retVal			= await window.showModalDialog("../jsp/OncologyRegimenPreviewFrames.jsp?titletext="+titletext+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&locn_code="+locn_code+"&pract_name="+encodeURIComponent(pract_name)+"&actual_patient_class="+patient_class+"&date="+date+"&site_spec_YN="+site_spec_YN, arguments, features);
	if(retVal == 'R')
		document.OncologyRegimenPrescriptionButtons.RELEASE.click();
}

function validateDate(obj){
	res=doDateTimeChk(obj);
	if (!res ){
		alert(getMessage("INVALID_DATE_TIME","PH"));
		obj.focus();
		return false;
	}
	return true;
}

function makeoverrideReasonMandatory(){
	var frmObj			= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
	frmObj.exceedDosageReasonMand.value="Y";
}

async function callActiveOrders(patient_id,encounter_id,generic_id)	{
	if(generic_id==undefined)
		generic_id="";
	
	var dialogHeight	= "40vh" ;
	var dialogWidth		= "50vw" ;
	var dialogTop		= "250" ;
	var center			= "1" ;
	var status			="no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				= await window.showModalDialog("../../ePH/jsp/PrescriptionActiveOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&called_frm=PH",arguments,features);
}

async function callActiveOrders(patient_id,encounter_id,generic_id)	{
	if(generic_id==undefined)
		generic_id="";
	
	var dialogHeight	= "40vh" ;
	var dialogWidth		= "50vw" ;
	var dialogTop		= "250" ;
	var center			= "1" ;
	var status			="no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				= await window.showModalDialog("../../ePH/jsp/PrescriptionActiveOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&generic_id="+generic_id,arguments,features);
}

async function showDrugProfile(patient_id,called_frm,encounter_id){ // encounter_id added for AAKH-CRF-0088.2
	var pat_class		=	document.onCologyOptions.patient_class.value;
	var dialogHeight	= "40vh";//"36" ;
	var dialogWidth		= "60vw" ;
	var dialogTop		= "152" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				= await top.window.showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+escape(patient_id)+"&pat_class="+pat_class+"&called_frm=Prescription"+"&encounter_id="+encounter_id, arguments, features ); // encounter_id added for AAKH-CRF-0088.2
}

/*
function displaySchedule(obj) {
	if (obj.value == "Y") {
		var formObj		= document.oncologyRegimenAdminDetail;
		var drugFormObj = parent.oncology_drugs.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails
		var code		= drugFormObj.drug_code.value;
		var bean_id		= formObj.bean_id.value;
		var bean_name	= formObj.bean_name.value;
		var freq_code	= formObj.frequency.value;
		var drug_code	= parent.oncology_fluid.document.oncologyRegimenFluidDetail.fluid_code.value;
		var fluid_frame_display_yn = parent.oncology_fluid.document.oncologyRegimenFluidDetail.fluid_frame_display_yn.value;
		var facility_id		= parent.parent.f_header.document.prescription_header_form.facility_id.value;
		var	max_qty			= 0;
		var	unit_qty		= 0;
		var split_dose_yn	= "N";
		//var split_qty		= parent.oncology_fluid.document.oncologyRegimenFluidDetail.flow_value.value;
		var qty_reqd_yn		= "N";
		//var uom_desc		= parent.oncology_fluid.document.oncologyRegimenFluidDetail.eqvl_uom_code.value;
		var chk_max			= "N";
		var chk_unit		= "N";
		var uom_desc		= "";
		var split_qty		= "";

		if(max_qty != "0") {
			chk_max = "Y";
		}

		if(unit_qty != "0") {
			chk_unit = "Y";
		}
		if(fluid_frame_display_yn=="N")
		{	uom_desc	=          parent.oncology_drugs.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails.drug_unit.value;
			split_qty	= parent.oncology_drugs.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails.dose.value;
		}
		else
		{
			uom_desc	= parent.oncology_fluid.document.oncologyRegimenFluidDetail.stock_uom.innerHTML;
			split_qty	= parent.oncology_fluid.document.oncologyRegimenFluidDetail.stock_value.value;
		}
		var row_value	= "1";

		//if(uom_desc !="" && split_qty != "") {
			var dialogTop		= "260";
			var dialogHeight	= "14";
			var dialogWidth		= "28";
			var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
			var arguments		= "";
			var retVal 			= window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?mode=1&bean_id="+bean_id+"&uom_desc="+uom_desc+"&bean_name="+bean_name+"&chk_max="+chk_max+"&chk_unit="+chk_unit+"&max_qty="+max_qty+"&split_dose_yn="+split_dose_yn+"&split_qty="+split_qty+"&qty_reqd_yn="+qty_reqd_yn+"&unit_qty="+unit_qty+"&code="+code+"&row_value="+row_value+"&facility_id="+facility_id+"&freq_code="+freq_code+"&module_id=PH",arguments,features);

			if(retVal!=null) {
				document.getElementById("sched_link").innerHTML = "<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"displaySchedule(document.oncologyRegimenAdminDetail.sched_medn)\">Scheduled Medication</A>";
				formObj.sched_medn.checked	= true;
				formObj.sched_medn.value	= "Y";
				//formObj.sched_medn_yn.value = "Y";
				//formObj.frequency.disabled	= true;
				formObj.sched_medn.disabled	= true;
			}
			else {
				document.getElementById("sched_link").innerText	= "Scheduled Medication";
				formObj.sched_medn.checked			= false;
				formObj.sched_medn.value			= "N";
				//formObj.sched_medn_yn.value			= "N";
				formObj.sched_medn.disabled	= false;
			}
		//}
	}
}
*/

async function DisplaySchedule(obj) {	
	var frmAdminObj		= document.oncologyRegimenAdminDetail;	
	var frmObj			= parent.oncology_fluid.document.oncologyRegimenFluidDetail;
	var frmDrugObj		= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;	
	var bean_id			= frmAdminObj.bean_id.value;
	var bean_name		= frmAdminObj.bean_name.value;
	var freq_code		= frmAdminObj.frequency.value;
	var facility_id		= frmAdminObj.facility_id.value;
	var ocurrance_num	= frmDrugObj.ocurrance_num.value;
	var drug_code		= frmDrugObj.drug_code.value;

	if(drug_code =="") {
		alert(getMessage("DRUG_CANT_BE_BLANK","PH"));
		frmObj.drug_name.focus();
		return;
	}
	var row_value		= "1";
	var	max_qty			= 0;
	var	unit_qty		= 0;
	var split_dose_yn	= "N";
    var split_qty		= "";
	var  uom_desc		= "";
    if( parent.oncology_fluid.document.getElementById('stock_value')!=null ||parent.oncology_fluid.document.getElementById('stock_value')!=undefined){
	  split_qty			= parent.oncology_fluid.document.getElementById('stock_value').value;
	   uom_desc			= parent.oncology_fluid.document.getElementById('stock_uom').innerHTML;
	}
	else{
      split_qty			= parent.f_oncology_sub_drugs.document.getElementById('totalDose').value;
	   uom_desc			= parent.f_oncology_sub_drugs.document.getElementById('drug_unit_code').value; //  changed drug_unit to drug_unit_code for IN27290 -- 24/05/2011-- priya
	}

	uom_desc=encodeURIComponent(uom_desc,"UTF-8");
	var qty_reqd_yn		= "N";
	var chk_max			= "N";
	var chk_unit		= "N";
	if(max_qty != "0") {
		chk_max = "Y";
	}
	if(unit_qty != "0") {
		chk_unit = "Y";
	}

	var start_time_day_param = frmAdminObj.start_date.value;
	var pr_duration			 = frmAdminObj.durn_value.value;
	var pr_duration_type	 = frmAdminObj.durn_unit.value;
	var durationType_P		 = pr_duration_type ;//frmAdminObj.disp_durn_type.value;

   	if(uom_desc !="" && split_qty != "") {
		var dialogTop		= "260";
		var dialogHeight	= "59vh";
		var dialogWidth		= "69vw";
		var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
		var arguments		= "";
		var retVal 			=await  top.window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?mode=1&bean_id="+bean_id+"&uom_desc="+uom_desc+"&bean_name="+bean_name+"&chk_max="+chk_max+"&chk_unit="+chk_unit+"&max_qty="+max_qty+"&split_dose_yn="+split_dose_yn+"&split_qty="+split_qty+"&qty_reqd_yn="+qty_reqd_yn+"&unit_qty="+unit_qty+"&code="+drug_code+ocurrance_num+"&row_value="+row_value+"&facility_id="+facility_id+"&freq_code="+freq_code+"&module_id=PH&called_from="+"&start_time_day_param="+start_time_day_param+"&pr_duration="+pr_duration+"&pr_duration_type="+pr_duration_type+"&org_drug_code="+drug_code+"&interval_durn_type="+durationType_P,arguments,features);	

		if(retVal!=null)
		{
			var split_vals = retVal[1].split('~~');	
			var len = frmAdminObj.frequency.options.length;			
			for(img=0;img<len;img++)
			{
				if(frmAdminObj.frequency.options[img].value==split_vals[0])
				{
					frmAdminObj.frequency.selectedIndex= img	;
					break;
				}
			}
			checkScheduledYN(frmAdminObj.frequency.value);
			//setSchedule();
			var len1 = frmAdminObj.durn_unit.options.length;
			for(img1=0;img1<len1;img1++)
			{
				if(frmAdminObj.durn_unit.options[img1].value==retVal[3])
				{
					frmAdminObj.durn_unit.selectedIndex= img1	;
					break;
				}
			}
			frmAdminObj.durn_value.value=retVal[2];
			chkDuration(frmAdminObj.durn_value,true);

			ExternalDosageCheck('','admndtl',frmAdminObj.perform_external_database_checks_yn.value);
		}
	}	
}

function setSchedule() {
	deleteSchedule();
	makeAutoSchedule();
}
function deleteSchedule() {
	
    var frmObj			= document.oncologyRegimenAdminDetail;
	var formObj			= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;	
	var bean_id			= formObj.bean_id.value;
	var bean_name		= formObj.bean_name.value;
	var patient_id		= formObj.patient_id.value;
	var encounter_id	= formObj.encounter_id.value;	
	var drug_code		= formObj.drug_code.value;	
	var qryString		= bean_id+"&bean_name="+bean_name+"&validate=DELETESCHEDULE&drug_code="+drug_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id;
	submitXML(qryString, "");
}

function makeAutoSchedule() {
	// check schedule chkbox is enabled & freq is selected automatic scheduling
	
	var frmObj			= parent.oncology_admin.document.oncologyRegimenAdminDetail;
	var formObj			= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
    var formObj1		= parent.oncology_fluid.document.oncologyRegimenFluidDetail;	
	var bean_id			= formObj.bean_id.value;
	var bean_name		= formObj.bean_name.value;
	var patient_id		= formObj.patient_id.value;
	var encounter_id	= formObj.encounter_id.value;	
	var repeat_durn_type = frmObj.repeat_durn_type.value;
	
	if(frmObj.frequency.value!="") {
		start_date		= frmObj.start_date.value;
		if(formObj1.stock_value!=undefined){
			qty_value	= formObj1.stock_value.value;
		}
		else{
			qty_value	= formObj.totalDose.value;

		}
		freq_code		= frmObj.frequency.value;
		drug_code		= formObj.drug_code.value;	
		ocurrance_num		= formObj.ocurrance_num.value;	
		if(qty_value!="" && qty_value!=="0") {
			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=AUTOSCHEDULE&freq_code="+freq_code+"&start_date="+start_date+"&qty_value="+qty_value+"&drug_code="+drug_code+"&ocurrance_num="+ocurrance_num+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&repeat_durn_type="+repeat_durn_type;
			submitXML(qryString, "");
		}
	}
}

function setvalue(obj){
	var iv_prp_yn = "";
	if(obj.checked==true){
		obj.value="Y";
		iv_prp_yn = "0";
	}
	else{
        obj.value="N";
		iv_prp_yn = "9";
	}
	document.oncologyRegimenAdminDetail.iv_prep_yn.value=iv_prp_yn;
	displayDispLocation(iv_prp_yn);
}

function defaultIVFluid(existing) {

	var frmObj			= parent.oncology_fluid.document.oncologyRegimenFluidDetail;
	var drugfrmObj			= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
	var ocurrance_num = drugfrmObj.ocurrance_num.value;
	var fluid_code = frmObj.fluid_code.value;
	var org_drug_code =frmObj.drug_code.value
	var base_uom = frmObj.base_uom.value;
	
	if (fluid_code != null && fluid_code != "" ) {
 		
 		var bean_id			= frmObj.bean_id.value;
		var bean_name		= frmObj.bean_name.value;
		var patient_id		= frmObj.patient_id.value;
		//commented by Anbarasi
		//var xmlDoc			= new ActiveXObject("Microsoft.XMLDom");
		//var xmlHttp			= new ActiveXObject("Microsoft.XMLHTTP");
		var xmlDoc = ""; 
		var xmlHttp = new XMLHttpRequest();

		xmlHttp.open("POST", "OncologyRegimenValidate.jsp?patient_id="+patient_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&validate=STOCKDETAILS&drug_code="+fluid_code+"&org_drug_code="+org_drug_code+"&base_uom="+base_uom+"&ocurrance_num="+ocurrance_num, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);

		if(!existing)
			setSchedule();
	}
}

async function fluidRemarks(){

	var frmObj				= document.oncologyRegimenFluidDetail;	
    var bean_id				= frmObj.bean_id.value;
	var bean_name			= frmObj.bean_name.value;
	var patient_id			= frmObj.patient_id.value;
	var encounter_id		= frmObj.encounter_id.value;
	var default_fluid_name	= frmObj.default_fluid_name.value;
	var dialogHeight		= "42vh";
	var dialogWidth			= "50vw";
	var dialogTop			= "250";
	var center				= "1";
	var status				= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments			= "";
	var retVal				= await window.showModalDialog("../jsp/OncologyRegimenRemarks.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&default_fluid_name="+default_fluid_name, arguments, features);  
	if(retVal == 'Y'){
		frmObj.fluid_remarks.value = "1";
	}
	else {
		frmObj.fluid_remarks.value = "0";
	}
}
function storeFluidRemarks(obj,patient_id,encounter_id){
	var fluid_remarks = obj.value;
	var frmObj		  = document.OncologyFluidRemarksForm;
	var bean_id		  = frmObj.bean_id.value;
	var bean_name	  = frmObj.bean_name.value;
	var qryString	  =			bean_id+"&bean_name="+bean_name+"&validate=FLUIDREMARKS&patient_id="+patient_id+"&encounter_id="+encounter_id+"&fluid_remarks="+fluid_remarks;
	submitXML(qryString, "");
	//window.close();
	
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}

function defaultinfuseover(infuseovervalue,infuseoverdurntype){
	var frmObj			             = parent.oncology_fluid.document.oncologyRegimenFluidDetail;
	var frmAdminObj=parent.oncology_admin.oncologyRegimenAdminDetail;
    frmObj.infuseovervalue.value    =infuseovervalue;
	frmObj.infuseoverdurntype.value =infuseoverdurntype;
	frmAdminObj.infusion_period_value.value =infuseovervalue;//Added for ML-MMOH-CRF-1223
}

function setdurntype(durn_type){

	obj=parent.oncology_admin.document.oncologyRegimenAdminDetail.durn_unit;
	parent.oncology_admin.document.oncologyRegimenAdminDetail.disp_durn_type.value=durn_type;
	for (i=0;i<obj.options.length ; i++){
		if (obj.options[i].value==durn_type){
			obj.options[i].selected=true;
			break;
		}
	}
}

function checkadmixture(frmobj,site_spec,fluid_frame_display_yn){
	
		var time_flag				=parent.oncology_button.document.OncologyRegimenPrescriptionButtons.time_flag.value;
		var alert_practitioner_yn   =parent.oncology_button.document.OncologyRegimenPrescriptionButtons.alert_practitioner_yn.value;
		if(parent.oncology_admin.document.oncologyRegimenAdminDetail!=undefined){
			if(parent.oncology_admin.document.oncologyRegimenAdminDetail.adMixture.checked==true){
				if(time_flag!='X'  ){
					if(alert_practitioner_yn=='Y')
					alert(getMessage("PREPARATION_ALERT","PH"));
				}
			}
		}
		//alert("site_spec==>"+site_spec+"==fluid_frame_display_yn==>"+fluid_frame_display_yn);
		if(site_spec=="true" && fluid_frame_display_yn=="Y"){
			if(parent.oncology_admin.document.oncologyRegimenAdminDetail!=undefined){
				if(parent.oncology_admin.document.oncologyRegimenAdminDetail.adMixture.checked==false){
					parent.oncology_fluid.oncologyRegimenFluidDetail.MFR_YN.style.visibility = "visible";
				}else{
					parent.oncology_fluid.oncologyRegimenFluidDetail.MFR_YN.style.visibility = "hidden";
				}
			}
		}
	
}
function callReport(frmobj,prescriptionPrint,NarcoticPrint,print_ord_sht_rule_ind){//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
	var bean_id			= frmobj.bean_id.value ;
	var bean_name		= frmobj.bean_name.value ;
	var patient_class   = frmobj.patient_class.value ; 
	var order_id ="";
    if(frmobj.order_id != undefined ){
		order_id=frmobj.order_id.value;
	}
	var xmlDoc			= "";
	var xmlHttp			= new XMLHttpRequest();

	xmlStr					="<root><SEARCH " ;
	xmlStr				  +="patient_class"+"=\""+ patient_class+"\" " ;
	if(print_ord_sht_rule_ind=='C' || NarcoticPrint=='Y'){//If and Else If for print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
		xmlStr				  +="prescriptionPrint"+"=\""+ prescriptionPrint+"\" " ;
		xmlStr				  +="NarcoticPrint"+"=\""+ NarcoticPrint+"\" " ;
	}
	else if(print_ord_sht_rule_ind=='S')
		xmlStr				  +="prescriptionPrint"+"=\""+ "Y"+"\" " ;

	xmlStr				  +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OncologyRegimenValidate.jsp?validate=OnlineReport&bean_id=" + bean_id + "&bean_name=" + bean_name+ "&patient_class=" + patient_class+ "&order_id=" + order_id+"&prescriptionPrint="+prescriptionPrint+"&NarcoticPrint="+NarcoticPrint, false ) ;  
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
}
function validate(frmObj) {

	var fields	= new Array();
	var names	= new Array();
	var   i		= 0;

	if(frmObj.allergy!=null) {
		fields[i]	= frmObj.allergy;
		names[i]	= "Allergic Override Reason";
		i++;
	}

	if(frmObj.exceed_dose!=null) {
		fields[i]	= frmObj.exceed_dose;
		names[i]	= "Exceed Dosage Override Reason";
		i++;
	}

	if(frmObj.dup_drug!=null) {
		fields[i]	= frmObj.dup_drug;
		names[i]	= "Duplicate Drug Override Reason";
		i++;
	}
	if(checkFlds(fields,names))
		if(checkMaxSize(fields,names))
			storeOverRideReason(frmObj);
}

function storeOverRideReason(frmObj) {

	current_rx	=	frmObj.current_rx.value;
	limit_ind	=	frmObj.limit_ind.value;
	allergy_yn	=	frmObj.allergy_yn.value;
	drug_code	=	frmObj.drug_code.value;
	srl_no		=	frmObj.srl_no.value;
	bean_id		=	frmObj.bean_id.value;
	bean_name	=	frmObj.bean_name.value;
	allergy		=	"";
	exceed_dose	=	"";
	dup_drug	=	"";
	//Added for IN:072715  start
	dose_remarks_code = "";
	allergy_remarks_code = "";
	dup_drug_remarks_code = ""
	//Added for IN:072715  end
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
// Modified for IN:072715 end	
	var xmlDoc			= "";
	var xmlHttp			= new XMLHttpRequest();

	var xmlStr ="<root><SEARCH ";
	xmlStr+= "current_rx  =\"" + current_rx + "\" " ;
	xmlStr+= "limit_ind =\"" + limit_ind + "\" " ;
	xmlStr+= "allergy_yn  =\"" + allergy_yn + "\" " ;
	xmlStr+= "allergy =\"" + allergy + "\" " ;
	xmlStr+= "exceed_dose =\"" + exceed_dose + "\" " ;
	
	//Added for IN:072715 start
	xmlStr+= "dose_remarks_code =\"" + dose_remarks_code + "\" " ;
	xmlStr+= "allergy_remarks_code =\"" + allergy_remarks_code + "\" " ;
	xmlStr+= "dup_drug_remarks_code =\"" + dup_drug_remarks_code + "\" " ;
	//Added for IN:072715 end
	
	xmlStr+= "dup_drug =\"" + dup_drug + "\" " ;
	xmlStr+= "drug_code =\"" + drug_code + "\" " ;
	xmlStr+= "srl_no =\"" + srl_no + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OncologyRegimenValidate.jsp?validate=OVERRIDE_REASON&bean_id="+ bean_id + "&bean_name=" + bean_name,false);
	
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText)

//	window.returnValue = allergy + ":::" + exceed_dose + ":::" + dup_drug + ":::" +allergy_remarks_code + ":::" + dose_remarks_code + ":::" + dup_drug_remarks_code + ":::";// Modified for IN:072715
//	parent.window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = allergy + ":::" + exceed_dose + ":::" + dup_drug + ":::" +allergy_remarks_code + ":::" + dose_remarks_code + ":::" + dup_drug_remarks_code + ":::";
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
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
function checkMaxSize(fields,names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(fields[i].value.length > 255)
			errors = errors + "APP-000002 " + names[i] + " cannot exceed 255 characters" + "\n" ;
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

function callOrderAmend(calledFrom) {
	var vals		 = "";
	var drug_code	 = "";
	var form_code	 = "";
	var route_code	 = "";
	var frmObj		 = "";
	var srl_no = "";
	for(i=0; i<pres_vals.length; i++)	{
		if(i==pres_vals.length)
			vals	+= pres_vals[i];
		else
			vals	+= pres_vals[i]+ "::";
	}
	if (calledFrom == "Drug") {
		frmObj		= document.onCologyRegimenDrugDetails
		drug_code	= document.onCologyRegimenDrugDetails.drug_code.value;
		form_code	= document.onCologyRegimenDrugDetails.form_code.value;
		route_code	= document.onCologyRegimenDrugDetails.route_code.value;
		srl_no	= document.onCologyRegimenDrugDetails.SRL_NO.value;
	}
	else if (calledFrom == "Fluid") {
		frmObj		= document.oncologyRegimenFluidDetail
		drug_code	= document.oncologyRegimenFluidDetail.drug_code.value;
		form_code	= document.oncologyRegimenFluidDetail.form_code.value;
		route_code	= document.oncologyRegimenFluidDetail.route_code.value;
		srl_no		= document.oncologyRegimenFluidDetail.SRL_NO.value;
	}
	//drug_code=drug_code+calledFrom
	drug_codeSRLNO = drug_code+srl_no;
	callAmendRemarks(formatId, drug_code,drug_codeSRLNO, 'PH', '0', 'PH', vals, form_code, route_code);
}

async function callAmendRemarks(format_id,catalog_code,drug_codeSRLNO,order_category,row_value,called_from,pres_vals, form_code, route_code){
	
    patient_id			=	document.onCologyRegimenDrugDetails.patient_id.value;
    encounter_id		=	document.onCologyRegimenDrugDetails.encounter_id.value;
    srl_no				=	document.onCologyRegimenDrugDetails.srl_no.value;
	var pres_remarks	=	document.onCologyRegimenDrugDetails.pres_remarks.value;
	DrugRemarksEntered	=   document.onCologyRegimenDrugDetails.DrugRemarksEntered.value; //added for [IN:039576]
    order_id			=	document.onCologyRegimenDrugDetails.order_id.value;	 
    order_line_no		=	"2";
    bean_id				= "@orderentrybean"+patient_id+encounter_id;
    bean_name			= "eOR.OrderEntryBean";
    var dialogHeight	= "50vh" ;
    var dialogWidth		= "70vw" ;
    var dialogTop		= "169" ;
    var center			= "1" ;
    var status			="no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
    var arguments   = "" ;
	retVal = await window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&order_line_num="+order_line_no+"&format_id="+format_id+"&p_catalog_code="+catalog_code+"&catalog_code="+drug_codeSRLNO+"&p_form_code="+form_code+"&p_route_code="+route_code+"&order_category="+order_category+"&row_value=0&called_from=PH",arguments,features);
	if(retVal!=undefined ){
		var retVals = retVal.split('~');
		//if(retVal!=undefined && retVal=='Y' && DrugRemarksEntered!='Y') //added for [IN:039576]
		if(retVals[0]=='Y' && DrugRemarksEntered!='Y') //if block added for [IN:039576]
		document.onCologyRegimenDrugDetails.DrugRemarksEntered.value = 'Y';
	}
}

function resetscreens(){
	var order_type_flag	= parent.parent.oncology_options.document.onCologyOptions.order_type_flag.value;
	
    if(order_type_flag=='Existing'){
		parent.f_oncology_sub_drugs.onCologyRegimenDrugDetails.reset();	
		frmDrugObj=parent.f_oncology_sub_drugs.onCologyRegimenDrugDetails;
		if(frmDrugObj.CALC_DOSE_BASED_ON[1].checked)
		{
			setCalculateBy(frmDrugObj.CALC_DOSE_BASED_ON[1],"AMEND_RESET");
		}
		else
		{
			setCalculateBy(frmDrugObj.CALC_DOSE_BASED_ON[0],"AMEND_RESET");
		}
		durn_unit = parent.oncology_admin.oncologyRegimenAdminDetail.amend_durn_type.value;
		repeat_value = parent.oncology_admin.oncologyRegimenAdminDetail.amend_durn_value.value;

		parent.oncology_admin.oncologyRegimenAdminDetail.reset();
		parent.oncology_admin.oncologyRegimenAdminDetail.durn_unit.value=durn_unit;
		parent.oncology_admin.oncologyRegimenAdminDetail.repeat_value.value=repeat_value;
	}
	else{	
		parent.f_oncology_sub_drugs.location.reload();
	}	 
}
//function for displaying TDM Details
async function viewReasonforRequest(orderId,drug_code){
	var dialogHeight ='40vh' ;
	var dialogWidth = '60vw' ;
	var dialogTop	= '189';
	var dialogLeft = '167' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments = "";
	var finalString	= "&readonly=readOnly&orderId="+orderId;
	var retVals = await window.showModalDialog("../../eOR/jsp/TDMReasonforrequest.jsp?"+finalString,arguments,features);
}

// fdb checks related functions
function viewMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,called_from,external_dosage_override_reason,drug_code,srl_no,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason,drug_db_dosecheck_yn,drug_db_allergy_flag){
	if((drug_db_dosecheck_yn=="Y"&&called_from=='ONLOAD')){			  
	//	ExternalDosageCheck(called_from,'');
		/*if(called_from=='ONLOAD'){
			drug_db_dose_check_flag	=	drug_frmobj.drug_db_dose_check_flag.value;
		}*/
   }
   else if(called_from=='PRESPAD'){

	   external_dosage_override_reason		= eval("document.oncologyRegimenDrugList.external_dosage_override_reason"+srl_no).value;

	   drug_db_dose_check_flag	=	eval("document.oncologyRegimenDrugList.external_db_dose_check_"+srl_no).value;
	   external_duplicate_override_reason	= eval("document.oncologyRegimenDrugList.external_duplicate_override_reason"+srl_no).value;
	   external_interaction_override_reason	= eval("document.oncologyRegimenDrugList.external_interaction_override_reason"+srl_no).value;
	   external_contra_override_reason		= eval("document.oncologyRegimenDrugList.external_contra_override_reason"+srl_no).value;
	   external_alergy_override_reason		= eval("document.oncologyRegimenDrugList.external_alergy_override_reason"+srl_no).value;
   }
   if(drug_db_dose_check_flag==""){
		drug_db_dose_check_flag =drug_db_dose_check_flag;
   }

	if(called_from=='ONLOAD'){
		if(((drug_db_interact_check_flag=='Y') && (external_interaction_override_reason=="")) ||((drug_db_duptherapy_flag=='Y') && (external_duplicate_override_reason=""))||((drug_db_contraind_check_flag=='Y' )&& (external_contra_override_reason==""))||((drug_db_dose_check_flag=='Y')&& (external_dosage_override_reason=="")) || ((drug_db_allergy_flag=='Y')&& (external_alergy_override_reason==""))){
			callMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,external_dosage_override_reason,drug_code,srl_no,called_from,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason,drug_db_allergy_flag);
		}
	}
	else{
//alert("@2369 >>>>>>>>> drug_db_interact_check_flag = "+drug_db_interact_check_flag+" >>> drug_db_duptherapy_flag = "+drug_db_duptherapy_flag+" >>> drug_db_contraind_check_flag = "+drug_db_contraind_check_flag+" >>> drug_db_dose_check_flag = "+drug_db_dose_check_flag+ " >>> drug_db_allergy_flag = "+drug_db_allergy_flag);
		if((drug_db_interact_check_flag=='Y') ||(drug_db_duptherapy_flag=='Y')||(drug_db_contraind_check_flag=='Y')||(drug_db_dose_check_flag=='Y')||(drug_db_allergy_flag=='Y')){
			callMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,external_dosage_override_reason,drug_code,srl_no,called_from,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason,drug_db_allergy_flag);
		}
	}
}

async function callMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dosecheck_flag,external_dosage_override_reason,drug_code,srl_no,called_from,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason,drug_db_allergy_flag){
	var drug_frmobj	= document.formIVPrescriptionDrugDetails;
	var dialogHeight	= "35vh" ;
	var dialogWidth	    = "65vw";
	var dialogTop	    = "100" ;
	var dialogLeft	    = "100" ;
	var center			= "0" ;
	var status			= "no";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	retVal = await window.showModalDialog("../../ePH/jsp/MedicationAlerts.jsp?&patient_id="+patient_id+"&external_product_id="+ext_prod_id+"&drug_db_interact_check_flag="+drug_db_interact_check_flag+"&drug_db_duptherapy_flag="+drug_db_duptherapy_flag+"&drug_db_contraind_check_flag="+drug_db_contraind_check_flag+"&srl_no="+srl_no+"&drug_db_dosecheck_flag="+drug_db_dosecheck_flag+"&dsg_reason="+encodeURIComponent(external_dosage_override_reason,"UTF-8")+"&dup_reason="+encodeURIComponent(external_duplicate_override_reason,"UTF-8")+"&con_reason="+encodeURIComponent(external_contra_override_reason,"UTF-8")+"&int_reason="+encodeURIComponent(external_interaction_override_reason,"UTF-8")+"&alg_reason="+encodeURIComponent(external_alergy_override_reason,"UTF-8")+"&pract_name="+pract_name+"&drug_db_allergy_flag="+drug_db_allergy_flag,arguments,features);
   
	bean_id		=	document.forms[0].bean_id.value;
	bean_name	=	document.forms[0].bean_name.value;
	if(retVal!=null && retVal[0]!='CANCEL'){
		var external_dosage_override_reason		=	"";
		var external_duplicate_override_reason		=	"";
		var external_interaction_override_reason	=	"";
		var external_contra_override_reason		=	"";
		var external_alergy_override_reason		=	"";
		var reason		="";
		var indicator	="";
		for(i=0;i<retVal.length;i++){
			reason=retVal[i];

			indicator=reason.substring(0,5);
			reason=retVal[i].substring(5,retVal[i].length);
			if(indicator=='DSG_Y'){
				external_dosage_override_reason		=reason;
			}
			else if(indicator=='DUP_Y'){
				external_duplicate_override_reason	=reason;
			}
			else if(indicator=='CON_Y'){
				external_contra_override_reason		=reason;
			}
			else if(indicator=='ALG_Y'){
				external_alergy_override_reason		=reason;
			}
			else if(indicator=='INT_Y'){
				external_interaction_override_reason=reason;
			}
		 }
			
		 if(called_from=='ONLOAD'){
			 drug_frmobj.external_dosage_override_reason.value		=	external_dosage_override_reason;
			 drug_frmobj.external_duplicate_override_reason.value	=	external_duplicate_override_reason;
			 drug_frmobj.external_interaction_override_reason.value	=	external_interaction_override_reason;
			 drug_frmobj.external_contra_override_reason.value		=	external_contra_override_reason;
			 drug_frmobj.external_Alergy_override_reason.value		=	external_alergy_override_reason;		
		}
		else if(called_from=='PRESPAD'){
		  eval("document.oncologyRegimenDrugList.external_dosage_override_reason"+srl_no).value		=	external_dosage_override_reason;      
		  eval("document.oncologyRegimenDrugList.external_duplicate_override_reason"+srl_no).value		=	external_duplicate_override_reason;   
		  eval("document.oncologyRegimenDrugList.external_interaction_override_reason"+srl_no).value	=	external_interaction_override_reason; 
		  eval("document.oncologyRegimenDrugList.external_contra_override_reason"+srl_no).value		=	external_contra_override_reason;      
		  eval("document.oncologyRegimenDrugList.external_alergy_override_reason"+srl_no).value		=	external_alergy_override_reason; 
	   }
		if(((drug_db_interact_check_flag=="Y")&&(external_interaction_override_reason==""))||((drug_db_duptherapy_flag=="Y")&&(external_duplicate_override_reason==""))||((drug_db_contraind_check_flag=="Y")&&(external_contra_override_reason==""))||((drug_db_dosecheck_flag=="Y")&&(external_dosage_override_reason==""))||((drug_db_allergy_flag=="Y")&&(external_alergy_override_reason==""))){
			document.getElementById("ext_ddb_override_img"+srl_no).style.visibility='visible';
		}
		else{
			document.getElementById("ext_ddb_override_img"+srl_no).style.visibility='hidden';
		}
		var xmlStr ="<root><SEARCH ";					
		xmlStr+= "External_Dosage_Override_Reason =\"" + encodeURIComponent(external_dosage_override_reason,"UTF-8") + "\" " ;
		xmlStr+= "External_Duplicate_Override_Reason =\"" + encodeURIComponent(external_duplicate_override_reason,"UTF-8") + "\" " ;
		xmlStr+= "External_Interaction_Override_Reason =\"" + encodeURIComponent(external_interaction_override_reason,"UTF-8") + "\" " ;
		xmlStr+= "External_Contra_Override_Reason =\"" + encodeURIComponent(external_contra_override_reason,"UTF-8") + "\" " ;
		xmlStr+= "External_Alergy_Override_Reason =\"" + encodeURIComponent(external_alergy_override_reason,"UTF-8") + "\" " ;
		xmlStr+= "drug_code =\"" + drug_code + "\" " ;
		xmlStr+= "srl_no =\"" + srl_no + "\" " ;
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr +=" /></root>";

		var temp_jsp="OncologyRegimenValidate.jsp?validate=InsertExternalOverrideReason"+"&bean_id="+bean_id+"&bean_name="+bean_name;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
}

function ExternalDosageCheck(called_from,adm_prsc,perform_external_database_checks_yn){
	if(perform_external_database_checks_yn == "Y"){
		if(adm_prsc == 'presc'){
			var formObject			=  parent.parent.parent.parent.f_header.document.prescription_header_form;
			var drug_frmobj		    =  document.formIVPrescriptionDrugDetails;
			var adminObj			=  parent.parent.f_iv_admin.formIVPrescriptionAdminDetail;
		}
		else if(adm_prsc == 'admndtl'){
			var formObject			=  "";
				if(parent.parent.parent.f_header != undefined){
					formObject			=  parent.parent.parent.f_header.document.prescription_header_form;
				}
				else{
					formObject			=  parent.parent.f_header.document.prescription_header_form;
				}
			var drug_frmobj		    =  parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
			var adminObj			=  parent.oncology_admin.document.oncologyRegimenAdminDetail;
		}
		else{
			var formObject			=  parent.parent.parent.f_header.document.prescription_header_form;
			var drug_frmobj		    =  parent.f_iv_drug_details.f_sub_ivdrugs.formIVPrescriptionDrugDetails;
			var adminObj			=  parent.f_iv_admin.formIVPrescriptionAdminDetail;
		}

		var external_prod_id    = "";
		if(drug_frmobj.external_product_id != undefined){
			external_prod_id    = drug_frmobj.external_product_id.value;
		}
		var drug_db_dosechk_yn  = formObject.drug_db_dosecheck_yn.value;
		var route_code						= drug_frmobj.route_code.value ;// Added in January 2014 for CIMS dosage check -start
		var qty_desc_code					= drug_frmobj.qty_desc_code.value; 
		var repeat_durn_type				= adminObj.repeat_durn_type.value;
		var freq_nature						= adminObj.freq_nature.value;// Added in January 2014 for CIMS dosage check -End

		if((external_prod_id!='') && (drug_db_dosechk_yn=="Y")){
			var bean_id							= drug_frmobj.bean_id.value;
			var bean_name						= drug_frmobj.bean_name.value;
			var patient_id						= drug_frmobj.patient_id.value;

			var weight							= formObject.weight.value;
				if(weight=="")
					weight="0";
			var bsa								= formObject.bsa.value;
				if(bsa=="")
					bsa="0";
			/*=======================================================================================================*/
				//added for IN26007 --24/01/2011-- priya
			var dose							= drug_frmobj.totalDose.value;//drug_frmobj.STRENGTH_VALUE.value; //replaced
			var dosage_by = "S"; // initialized to S for IN26467 --11/02/2011-- priya
			var optionLength = drug_frmobj.CALC_DOSE_BASED_ON.length;
			if(optionLength != undefined){
				if(drug_frmobj.CALC_DOSE_BASED_ON_D.checked){
					dosage_by = drug_frmobj.dosage_type_list.value;
				}
			}
			//var dosage_by						= drug_frmobj.DOSAGE.value;
			var dose_uom						= "";
			if( drug_frmobj.PRES_BASE_UOM != undefined){
				dose_uom    =  drug_frmobj.PRES_BASE_UOM.value;
			}
			/*if(dosage_by=='S'){
			}
			else{
				 dose_uom   =  drug_frmobj.STRENGTH_UOM.value;
			}
			var repeat_value					= Math.ceil(parseInt(durn_value)/parseInt(inf_prd_value));*///Commented for IN26007 --24/01/2011-- priya

			var inf_prd_value = '1';	
			if(adminObj.INFUSION_PERIOD_VALUE != undefined){
				inf_prd_value = adminObj.INFUSION_PERIOD_VALUE.value;
			}
			var durn_value	  = adminObj.durn_value.value;
			var repeat_value					= adminObj.repeat_value.value;
				//durn_value = "1";
			var interval_value					=  "";
			if( drug_frmobj.interval_value != undefined){
				interval_value = drug_frmobj.interval_value.value;
			}
			  if(interval_value=="") interval_value="1";

			var drug_code						= drug_frmobj.drug_code.value; //DRUG_CODE//replaced for IN26007 --24/01/2011-- priya
			var srl_no							= drug_frmobj.srl_no.value; //SRL_NO	//replaced for IN26007 --24/01/2011-- priya

			var strength_per_pres_uom			= "";
			if( drug_frmobj.strength_per_pres_uom != undefined)	{
				strength_per_pres_uom = drug_frmobj.strength_per_pres_uom.value; 
			}
			var strength_per_value_pres_uom		= "";
			if( drug_frmobj.strength_per_value_pres_uom != undefined){
				strength_per_value_pres_uom = drug_frmobj.strength_per_value_pres_uom.value; 
			}
			var fract_dose_round_up_yn			= "";
			if( drug_frmobj.fract_dose_round_up_yn != undefined){
				fract_dose_round_up_yn = drug_frmobj.fract_dose_round_up_yn.value; 
			}
			var external_dosage_override_reason	= "";
			if( drug_frmobj.external_dosage_override_reason != undefined){
				external_dosage_override_reason = drug_frmobj.external_dosage_override_reason.value;
			}
			var startdate = drug_frmobj.start_date.value;// Added for ML-BRU-SCF-0811 [IN:039394]
			var enddate	  = drug_frmobj.end_date.value;// Added for ML-BRU-SCF-0811 [IN:039394]
			
			var pract_name						= drug_frmobj.pract_name.value

			var xmlStr ="<root><SEARCH ";					
			xmlStr+= "patient_id =\"" + patient_id + "\" " ;
			xmlStr+= "external_prod_id =\"" + external_prod_id + "\" " ;
			xmlStr+= "weight =\"" + weight + "\" " ;
			xmlStr+= "bsa =\"" + bsa + "\" " ;
			xmlStr+= "dose =\"" + dose + "\" " ;
			xmlStr+= "dosage_by =\"" + dosage_by + "\" " ;
			xmlStr+= "dose_uom =\"" + dose_uom + "\" " ;
			xmlStr+= "repeat_value =\"" + repeat_value + "\" " ;
			xmlStr+= "interval_value=\"" + interval_value + "\" " ;

			xmlStr+= "durn_value =\"" + durn_value + "\" " ;
			xmlStr+= "drug_code =\"" + drug_code + "\" " ;
			xmlStr+= "srl_no =\"" + srl_no + "\" " ;
			xmlStr+= "strength_per_pres_uom =\"" + strength_per_pres_uom + "\" " ;
			xmlStr+= "strength_per_value_pres_uom =\"" + strength_per_value_pres_uom + "\" " ;
			xmlStr+= "fract_dose_round_up_yn =\"" + fract_dose_round_up_yn + "\" " ;
			xmlStr+= "adm_prsc =\"" + adm_prsc + "\" " ;
			xmlStr+= "called_from =\"" + called_from + "\" " ;
			xmlStr+= "external_dosage_override_reason=\"" + external_dosage_override_reason + "\" " ;
			xmlStr+= "pract_name=\"" + pract_name + "\" " ;
			xmlStr += " startdate=\""+ startdate + "\" ";	// Added for ML-BRU-SCF-0811 [IN:039394]
			xmlStr += " enddate=\""+ enddate + "\" ";	// Added for ML-BRU-SCF-0811 [IN:039394]
			xmlStr+= "route_code=\"" + route_code + "\" " ; // Added in January 2014 for CIMS dosage check -start
			xmlStr+= "qty_desc_code=\"" + qty_desc_code + "\" " ;
			xmlStr+= "repeat_durn_type=\"" + repeat_durn_type + "\" " ;
			xmlStr+= "freq_nature=\"" + freq_nature + "\" " ;  //Added in January 2014, CIMS Dosage Check -end
			xmlStr +=" /></root>";

			var temp_jsp="OncologyRegimenValidate.jsp?validate=ExternalDoseCheck"+"&bean_id="+bean_id+"&bean_name="+bean_name;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}
		else if(drug_db_dosechk_yn=="Y"){
			var bean_id							= drug_frmobj.bean_id.value;
			var bean_name						= drug_frmobj.bean_name.value;
			var patient_id						= drug_frmobj.patient_id.value;
			var weight							= formObject.weight.value;
				if(weight=="")
					weight="0";
			var bsa								= formObject.bsa.value;
			if(bsa=="")
			bsa="0";
			var inf_prd_value = '1';	
			if(adminObj.INFUSION_PERIOD_VALUE != undefined){
				inf_prd_value = adminObj.INFUSION_PERIOD_VALUE.value;
			}
			var durn_value	  = adminObj.durn_value.value;
			var repeat_value					= Math.ceil(parseInt(durn_value)/parseInt(inf_prd_value));
			var drug_code						= drug_frmobj.drug_code.value; 
			var srl_no							= drug_frmobj.srl_no.value; 
			var dose							= drug_frmobj.totalDose.value;
			durn_value = "1";
			var interval_value="1";
			var pract_name						= formObject.pract_name.value

			var xmlStr ="<root><SEARCH ";					

			xmlStr+= "patient_id =\"" + patient_id + "\" " ;
			xmlStr+= "weight =\"" + weight + "\" " ;
			xmlStr+= "bsa =\"" + bsa + "\" " ;
			xmlStr+= "repeat_value =\"" + repeat_value + "\" " ;
			xmlStr+= "interval_value=\"" + interval_value + "\" " ;
			xmlStr+= "durn_value =\"" + durn_value + "\" " ;
			xmlStr+= "adm_prsc =\"" + adm_prsc + "\" " ;
			xmlStr+= "called_from =\"" + called_from + "\" " ;
			xmlStr+= "pract_name=\"" + pract_name + "\" " ;
			xmlStr+= "drug_code =\"" + drug_code + "\" " ;
			xmlStr+= "srl_no =\"" + srl_no + "\" " ;
			xmlStr+= "dose =\"" + dose + "\" " ;
			xmlStr+= "route_code=\"" + route_code + "\" " ; // Added in January 2014 for CIMS dosage check -start
			xmlStr+= "qty_desc_code=\"" + qty_desc_code + "\" " ;
			xmlStr+= "repeat_durn_type=\"" + repeat_durn_type + "\" " ;
			xmlStr+= "freq_nature=\"" + freq_nature + "\" " ;  //Added in January 2014, CIMS Dosage Check -end
			xmlStr +=" /></root>";

			var temp_jsp="OncologyRegimenValidate.jsp?validate=ExternalDoseCheck"+"&bean_id="+bean_id+"&bean_name="+bean_name;
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

function DisplayFDBOverrideImage(srl_no,called_from){	

	parent.f_oncology_regimen_drug_list.document.getElementById('ext_ddb_override_img'+srl_no).style.visibility="visible";
	parent.f_oncology_regimen_drug_list.document.getElementById("ext_ddb_override_indc"+srl_no).className="SHIFTTOTAL";

    if(called_from=='DOSAGE'){
		external_db_dose_check     = document.getElementById("external_db_dose_check_"+srl_no);
		if(external_db_dose_check != undefined){
			external_db_dose_check.value='Y';
		}else{
			parent.f_oncology_regimen_drug_list.document.getElementById("external_db_dose_check_"+srl_no).value = "Y";
		}
	}

}

function HideFDBOverrideImage(srl_no,called_from){

	try{
		var frmObj		= parent.f_oncology_regimen_drug_list.document.formIVPrescriptionDrugList;

		var ext_med_alerts_fired_for_dup_check_yn		=	eval("frmObj.ext_med_alerts_fired_for_dup_check_yn"+srl_no).value;
		var ext_med_alerts_fired_for_inte_check_yn		=	eval("frmObj.ext_med_alerts_fired_for_inte_check_yn"+srl_no).value;
		var ext_med_alerts_fired_for_contra_check_yn	=	eval("frmObj.ext_med_alerts_fired_for_contra_check_yn"+srl_no).value;
		var ext_med_alerts_fired_for_allergy_check_yn	=	eval("frmObj.ext_med_alerts_fired_for_allergy_check_yn"+srl_no).value;

		var external_db_dose_check			 = eval("frmObj.external_db_dose_check_"+srl_no);

		 if(called_from=='DOSAGE'){
				
				external_db_dose_check.value	 = 'N';

		 }
		 if(ext_med_alerts_fired_for_dup_check_yn=='N'&& ext_med_alerts_fired_for_inte_check_yn=='N'&&ext_med_alerts_fired_for_contra_check_yn=='N'&&external_db_dose_check.value=='N'&&ext_med_alerts_fired_for_allergy_check_yn=='N'){

			parent.f_oncology_regimen_drug_list.document.getElementById('ext_ddb_override_img'+srl_no).style.visibility="hidden";
			parent.f_oncology_regimen_drug_list.document.getElementById("ext_ddb_override_indc"+srl_no).className="SELECTEDRUGS";
		 }
	}
	catch (e){}
}

function displayDispLocation(iv_prp_yn){

	var header_form				= parent.parent.parent.f_header.prescription_header_form;
	var location_type			= header_form.source_type.value;
	var location_code			= header_form.source_code.value;
	var priority				= header_form.priority.value;
	var patient_id				= header_form.patient_id.value;
	var encounter_id			= header_form.encounter_id.value;
	var take_home_medication	= header_form.take_home_medication.value;
	
	var bean_id		= document.forms[0].bean_id.value;
	var bean_name	= document.forms[0].bean_name.value;
	//commented by Anbarasi
//	var xmlDoc			= "";
//	var xmlHttp			= new XMLHttpRequest();
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();

	xmlStr		="<root><SEARCH " ;
	xmlStr		+="location_type"+"=\""+ location_type+"\" " ;
	xmlStr		+="location_code"+"=\""+ location_code+"\" " ;
	xmlStr		+="priority"+"=\""+ priority+"\" " ;
	xmlStr		+="take_home_medication"+"=\""+ take_home_medication+"\" " ;
	xmlStr		+="iv_prep_yn"+"=\""+ iv_prp_yn+"\" " ;
	xmlStr		+="patient_id"+"=\""+ patient_id+"\" " ;
	xmlStr		+="encounter_id"+"=\""+ encounter_id+"\" " ;
	xmlStr		+=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OncologyRegimenValidate.jsp?validate=dfltDispLocn&bean_id=" + bean_id + "&bean_name=" + bean_name, false ) ; 
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText);

}

function paintDispLocn(dflt_disp_locn,time_flag){
	//try{
		if(parent.oncology_button != undefined && parent.oncology_button.document.OncologyRegimenPrescriptionButtons!=undefined){
			parent.oncology_button.document.getElementById('dflt_disp_locn_lbl').innerText = dflt_disp_locn;
		    parent.oncology_button.document.OncologyRegimenPrescriptionButtons.time_flag.value=time_flag;
		}
	//}
	//catch(e){
	//}
}


async function searchRegimen(){
	var formObj				=   document.onCologyOptions;
	var argumentArray		=   new Array() ;
	var dataNameArray		=   new Array() ;
	var dataValueArray		=   new Array() ;
	var dataTypeArray		=   new Array() ;  
    var facility_id		    =	formObj.facility_id_1.value;
    var locn_type		    =	formObj.locn_type.value; 
    var locn_code		    =	formObj.locn_code.value; 
    var service_code	    =	formObj.service_code_1.value;
    var pract_id		    =	formObj.pract_id.value;   
    var Pract_type          =	formObj.Pract_type_1.value;
    var patient_class       =	formObj.patient_class.value; 
    var patient_id          =	formObj.patient_id.value; 
    var Language_id         =	formObj.Language_id_1.value;  
	var sql_ph_oncology_regimen_select =formObj.sql_ph_oncology_regimen_select.value;
	var drug_priv_appln_yn =formObj.drug_priv_appln_yn.value;
    var resp_id				= parent.parent.f_header.prescription_header_form.resp_id.value;
//resp_id

	//argumentArray[0]		="SELECT distinct a.order_catalog_code CODE,b.catalog_synonym DESCRIPTION,a.order_category order_category FROM or_order_set_trans_vw a ,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c, or_order_catalog d WHERE a.order_catalog_code = b.order_catalog_code AND a.Order_catalog_code=d.order_catalog_code and a.order_catalog_code = c.order_catalog_code AND a.order_category ='PH'  and d.iv_prep_yn ='C' AND nvl(a.diagnosis_code,'XXX') = nvl(NULL,'XXX')"+" AND nvl(a.facility_id,'"+ facility_id +"')='"+facility_id+"' AND nvl(a.source_type,'"+locn_type+"') = '"+locn_type+"' AND nvl(a.source_code,'"+ locn_code  +"') = '"+locn_code+"' AND nvl(a.service_code,'"+ service_code +"') = '"+service_code+"' AND nvl(a.practitioner_id, '"+ pract_id +"') = '" +pract_id +"' AND catalog_synonym_type = OR_GET_SYNONYM_TYPE('"+Pract_type+"',a.order_catalog_code) AND c.patient_class = OR_PATIENT_ORDER_APPLICABLE( '"+patient_class+"', a.order_catalog_code,'"+ patient_id +"' ) AND b.language_id = '" +Language_id +"'  and  upper(a.order_catalog_code) like upper(?) and upper(b.catalog_synonym) like upper(?) ORDER BY 2";
//or_get_priv_appl_yn('"+ pract_id +"','"+ resp_id +"','OR',a.order_catalog_code,drug_priv_appln_yn,'','PH') ='Y'

	argumentArray[0]		=sql_ph_oncology_regimen_select +" AND nvl(a.facility_id,'"+ facility_id +"')='"+facility_id+"' AND nvl(a.source_type,'"+locn_type+"') = '"+locn_type+"' AND nvl(a.source_code,'"+ locn_code  +"') = '"+locn_code+"' AND nvl(a.service_code,'"+ service_code +"') = '"+service_code+"' AND nvl(a.practitioner_id, '"+ pract_id +"') = '" +pract_id +"' AND catalog_synonym_type = OR_GET_SYNONYM_TYPE('"+Pract_type+"',a.order_catalog_code) AND c.patient_class = OR_PATIENT_ORDER_APPLICABLE( '"+patient_class+"', a.order_catalog_code,'"+ patient_id +"' ) AND b.language_id = '" +Language_id +"'  and  upper(a.order_catalog_code) like upper(?) and upper(b.catalog_synonym) like upper(?)and  or_get_priv_appl_yn('"+ pract_id +"','"+ resp_id +"','OR',a.order_catalog_code,'"+drug_priv_appln_yn+"','','PH') ='Y' ORDER BY 2";

	//prompt("argumentArray==",argumentArray[0]);
	 
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "1,2";
	argumentArray[5]		= formObj.regimen_desc.value ;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 
	retVal = await CommonLookup( getLabel("ePH.Regimen.label","PH"), argumentArray );
	var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal.length==0){//added for NMC-JD-CRF-0063 start
		if(parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk!=undefined)
			parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled=false;
	}else{
		if(parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk!=undefined)
			parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled=true;
	}//end
	if(retVal != null && retVal != "" )  {
		formObj.regimen_desc.value		=  arr[1] ;
		formObj.regimen.value			=  arr[0];	

		//disable_facility1(formObj.referral_location_desc,formObj.referral_facility);
		loadDrugDetails(formObj.regimen);
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

function defaultRecomDose(){
	

	var drug_frmobj		    =  document.onCologyRegimenDrugDetails;
	var formObject			=  parent.parent.parent.f_header.document.prescription_header_form;

	if(formObject.height!=undefined && formObject.height!=null && formObject.weight!=null) {
 
		var weight		= formObject.weight.value;
		var bsa			= formObject.bsa.value;

		var dosage_std	=	drug_frmobj.dosage_std.value;
		var recomm_dosage_by	=	drug_frmobj.recomm_dosage_by.value;
		var dosage_by			=	drug_frmobj.dosage_type.value;

		if(recomm_dosage_by == dosage_by){
			//sri:onco crf
			drug_frmobj.totalDose.value = dosage_std;
			drug_frmobj.totalDose.focus();
		}
	}
}

async function displayChargeDetails(iv_prep_yn){

	var headerForm = parent.parent.parent.f_header.document.prescription_header_form;
	var drugForm	= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
	var fluidForm	= parent.oncology_fluid.document.oncologyRegimenFluidDetail;
	var frmAdminObj 		= parent.oncology_admin.document.oncologyRegimenAdminDetail;

	var bean_id = drugForm.bean_id.value;
	var bean_name = drugForm.bean_name.value
	var patient_id = headerForm.patient_id.value
	var encounter_id = headerForm.encounter_id.value
	var actual_patient_class = headerForm.actual_patient_class.value;
	var amend_fluid_code = "";
	var amend_stock_value ="";
	var take_home_medication	= headerForm.take_home_medication.value;

	if(fluidForm.fluid_frame_display_yn.value=='Y'){
		amend_fluid_code = fluidForm.fluid_code.value;
		amend_stock_value = fluidForm.stock_value.value;
	}

	var xmlStr ="<root><SEARCH ";					
	xmlStr+= "patient_id =\"" + patient_id+ "\" " ;
	xmlStr+= "encounter_id =\"" + encounter_id+ "\" " ;
	xmlStr+= "drug_code =\"" + drugForm.drug_code.value+ "\" " ;
	xmlStr+= "dose =\"" + drugForm.totalDose.value+ "\" " ;
	xmlStr+= "amend_fluid_code =\"" + amend_fluid_code+ "\" " ;
	xmlStr+= "amend_stock_value=\""+ amend_stock_value + "\" ";
	xmlStr+= "amend_durn_value=\""+ frmAdminObj.durn_value.value + "\" ";
	xmlStr+= "amend_repeat_value=\""+ frmAdminObj.repeat_value.value + "\" ";
	xmlStr+= "repeat_value=\""+  frmAdminObj.repeat_value.value  + "\" ";
	xmlStr+= "ocurrance_num=\""+  drugForm.ocurrance_num.value  + "\" ";
	xmlStr+="amend_durn_type=\""+ frmAdminObj.durn_unit.value + "\" ";

	xmlStr +=" /></root>";

	var temp_jsp="OncologyRegimenValidate.jsp?validate=SAVE_SCREEN_VALUES"+"&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;

	var dialogHeight= "45vh" ;
	var dialogWidth	= "65vw" ;
	var dialogTop	= "305" ;
	var dialogLeft	= "0" ;
	var center		= "1" ;
	var status		= "no";
	var scroll		= "yes";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/ChargeDetail.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&actual_patient_class="+actual_patient_class+"&iv_prep_yn="+iv_prep_yn+"&take_home_medication="+take_home_medication,arguments,features);

	if(retVal!= undefined && retVal!=null && retVal!="")
		alertBLErrorDrugs(retVal);
}

function getBLErrorDrugs(){

	var headerForm = parent.parent.parent.f_header.document.prescription_header_form;
	var drugForm 			= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
	var frmFluidObj 		= parent.oncology_fluid.document.oncologyRegimenFluidDetail;
	var frmAdminObj 		= parent.oncology_admin.document.oncologyRegimenAdminDetail;

	var bean_id = drugForm.bean_id.value;
	var bean_name = drugForm.bean_name.value
	var iv_prep_yn = document.forms[0].iv_prep_yn.value
	var patient_id = headerForm.patient_id.value
	var encounter_id = headerForm.encounter_id.value
	var actual_patient_class = headerForm.actual_patient_class.value;
	var	fluid_frame_display_yn	= frmFluidObj.fluid_frame_display_yn.value;
    var take_home_medication	= headerForm.take_home_medication.value;

	if (chkMandatoryFlds("Amend")) {
		
		var xmlStr ="<root><SEARCH ";					
		xmlStr+= "patient_id =\"" + patient_id+ "\" " ;
		xmlStr+= "encounter_id =\"" + encounter_id+ "\" " ;
		xmlStr+= "actual_patient_class =\"" + actual_patient_class+ "\" " ;
		xmlStr+= "drug_code =\"" + drugForm.drug_code.value+ "\" " ;
		xmlStr+= "dose =\"" + drugForm.totalDose.value+ "\" " ;
		if(fluid_frame_display_yn=="Y"){
			xmlStr+= "amend_fluid_code =\"" + frmFluidObj.fluid_code.value+ "\" " ;
			xmlStr+= "amend_stock_value=\""+ frmFluidObj.stock_value.value + "\" ";
			
		}
		else{
			xmlStr		+= " amend_fluid_code= '' ";
			xmlStr		+= " amend_stock_value='' ";
		}
		xmlStr+= "amend_durn_value=\""+ frmAdminObj.durn_value.value + "\" ";
		xmlStr+= "amend_repeat_value=\""+ frmAdminObj.repeat_value.value + "\" ";
		xmlStr+= "repeat_value=\""+  frmAdminObj.repeat_value.value  + "\" ";
		xmlStr+= "ocurrance_num=\""+  drugForm.ocurrance_num.value  + "\" ";
		xmlStr+= "iv_prep_yn =\"" + iv_prep_yn+ "\" " ;
		xmlStr+= "take_home_medication =\"" + take_home_medication+ "\" " ;

		xmlStr +=" /></root>";

		var temp_jsp="OncologyRegimenValidate.jsp?validate=GET_BL_ERROR_DRUGS"+"&bean_id="+bean_id+"&bean_name="+bean_name;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
	}
}

function alertBLErrorDrugs(blErrorDrugs){
	blError = true;
	blErrorDrugs = blErrorDrugs.substring(1,blErrorDrugs.length-2);
	blErrorDrugs = blErrorDrugs.split(',');
	var bl_alert_msg=getMessage("ERROR_IN_BILLING",'PH')+"\n\n";
	var count=0;
	var drug_of_fluid="";
	var drugfound=false;
	var drug_codes = new Array();

	for(var i=0; i<blErrorDrugs.length; i++){
		drug_of_fluid	= trimString(blErrorDrugs[i++]);
		drug_codes[count++]	= trimString(blErrorDrugs[i++]);
		drug_desc	= trimString(blErrorDrugs[i++]);
		bl_error_code = trimString(blErrorDrugs[i++]);
		bl_sys_message_id = trimString(blErrorDrugs[i++]);
		bl_error_text = trimString(blErrorDrugs[i]);

		if ((bl_error_code == "10" && bl_error_text =="") || bl_sys_message_id!=""){
			if(bl_sys_message_id!=""){
				bl_error_text = getMessage(bl_sys_message_id,'BL');
			}
		}
		bl_alert_msg += drug_desc+"  "+ bl_error_text+"\n";
		if(drug_of_fluid=='D')
			drugfound=true;
	}
	alert(bl_alert_msg);
	if(drugfound)
		callClearAll("1",true);
}

function calcDose(detailForm){
	if(detailForm.calc_yn.value == "Y"){
		weight = detailForm.weight.value;
		bsa = detailForm.bsa.value;
		tDose = detailForm.totalDose.value;
		totalDose=0;
		if((detailForm.doseUom.value).toUpperCase() != (detailForm.drug_unit.value).toUpperCase()){
			if(detailForm.doseUom.value == "G"){
				if(detailForm.g.value != "")	
					totalDose = Math.ceil(parseFloat(tDose) / parseFloat(detailForm.g.value));
				else
					alert(getMessage("PH_EQU_UOM_NOT_DEFINED","PH"));
			}
			else if(detailForm.doseUom.value == "MCG"){
				if(detailForm.mcg.value != "")	
					totalDose = Math.ceil(parseFloat(tDose) / parseFloat(detailForm.mcg.value));
				else
					alert(getMessage("PH_EQU_UOM_NOT_DEFINED","PH"));
			}
			else if(detailForm.doseUom.value == "NCG"){
				if(detailForm.ncg.value != "")	
					totalDose = Math.ceil(parseFloat(tDose) / parseFloat(detailForm.ncg.value));
				else
					alert(getMessage("PH_EQU_UOM_NOT_DEFINED","PH"));
			}
			else if(detailForm.doseUom.value == "MG"){
				if(detailForm.mg.value != "")	
					totalDose = Math.ceil(parseFloat(tDose) / parseFloat(detailForm.mg.value));
				else
					alert(getMessage("PH_EQU_UOM_NOT_DEFINED","PH"));
			}

		}else{
			
			totalDose = tDose ;
		}
		
		if(detailForm.caclDoseBy_unit.value == 'kg'){
			detailForm.dose.value =  Math.ceil(totalDose / weight);
		}
		else if (detailForm.caclDoseBy_unit.value == 'm2'){
			detailForm.dose.value =  Math.ceil(totalDose / bsa);
		}
	}
}

function calcTotalDose(detailForm){
	weight = detailForm.weight.value;
	bsa = detailForm.bsa.value;
	var dose = detailForm.dose.value;
	var totalDose;
	if(dose!="" && parseFloat(dose)!=0)
	{
		if(detailForm.caclDoseBy_unit.value == 'kg'){
			totalDose =  parseFloat(dose) * parseFloat(weight);
		}
		else if(detailForm.caclDoseBy_unit.value == 'm2'){
			totalDose =  parseFloat(dose) * parseFloat(bsa);			
		}
		else if(detailForm.caclDoseBy_unit.value == 'Ag'){ // Added for ML-MMOH-CRF-0345 [IN:057441] - Start
			totalDose =  dose;			
		} // Added for ML-MMOH-CRF-0345 [IN:057441] -End
		totalDose=Math.round(parseFloat(totalDose)*1000)/1000;
	}
	else{
		
		totalDose = detailForm.doseValue.value;
	}
	detailForm.totalDose.value = totalDose;
	detailForm.totalDose.focus();
}


async function openEDLDetails(DrugCode)
{

  if(DrugCode!=''&&DrugCode!=null){
	var dialogHeight	= "40vh";
	var dialogWidth		= "55vw";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status;
	var arguments		= "";
	
	await window.showModalDialog("../jsp/EDLAssociateListViewFrames.jsp?DrugCode="+DrugCode, arguments, features);
	}
 
}//end function

 function getHrsMinStr(HMvalue,HMunit ){
var val			= HMvalue.split(".");	

	if(val[1] == undefined){
	if( HMunit == 'H' ) {
		 hrs = Math.floor(HMvalue);
		 HMvalue = HMvalue * 60;
	 } 
	else {
		 hrs = HMvalue / 60;
	}
	}
	else{
	    hrs = Math.floor(HMvalue);
		 HMvalue = HMvalue * 60;
	}
	 min = HMvalue % 60;
	 return( '['+Math.floor(hrs) + ' Hrs ' + Math.round(min) + ' Mins]' );
 }

 function addNewDrug(){
	var patient_id			= parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id		= parent.parent.f_header.document.prescription_header_form.encounter_id.value;

//		parent.oncology_drugs.location.href = "../jsp/OncologyRegimenDrugDetails.jsp?";
		parent.oncology_drugs.f_oncology_sub_drugs.location.href = "../jsp/OncologyRegimenDrugDetails.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id;
		parent.oncology_drugs.oncology_fluid.location.href		= "../jsp/OncologyRegimenFluidDetail.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id;
			//+"&problem_ind="+problem_ind+"&start_date="+start_date+"&order_type_flag="+order_type_flag+"&order_id="+order_id+"&MAR_app_yn="+MAR_app_yn;
		parent.oncology_drugs.oncology_admin.location.href		= "../jsp/OncologyRegimenAdminDetail.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id;
			//+"&problem_ind="+problem_ind+"&start_date="+start_date+"&order_type_flag="+order_type_flag+"&order_id="+order_id+"&MAR_app_yn="+MAR_app_yn;
		parent.oncology_drugs.oncology_button.location.href	= "../jsp/OncologyRegimenButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id;
			//+"&MAR_app_yn="+MAR_app_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&iv_prep_yn=9+&order_type_flag="+order_type_flag;	
 }

 function drugSearch(drugCode){
	
	saveWtBsa();//Added for IN:070451
	var frmObj			= parent.parent.oncology_options.document.onCologyOptions;
	var drug_db_interface_yn = frmObj.drug_db_interface_yn.value;

	if(frmObj.regimen.value != ''){
		var service_search_yn	= parent.parent.parent.f_header.document.prescription_header_form.service_search_yn.value;
		var servide_code		= parent.parent.parent.f_header.document.prescription_header_form.servide_code.value;
		var patient_id			= parent.parent.parent.f_header.document.prescription_header_form.patient_id.value;
		var encounter_id		= parent.parent.parent.f_header.document.prescription_header_form.encounter_id.value;
		var discharge_yn		= parent.parent.parent.f_header.document.prescription_header_form.take_home_medication.value;

		/*if(discharge_yn=='Y')
			var patient_class = parent.f_header.document.prescription_header_form.patient_class.value;
		else*/
		var patient_class		= parent.parent.parent.f_header.document.prescription_header_form.actual_patient_class.value;
		var act_patient_class	= parent.parent.parent.f_header.document.prescription_header_form.actual_patient_class.value;

		var priority			= parent.parent.parent.f_header.document.prescription_header_form.priority.value;
		var source_code			= parent.parent.parent.f_header.document.prescription_header_form.source_code.value;
		var source_type			= parent.parent.parent.f_header.document.prescription_header_form.source_type.value;
		var date_of_birth		= parent.parent.parent.f_header.document.prescription_header_form.date_of_birth.value;
		var gender				= parent.parent.parent.f_header.document.prescription_header_form.gender.value;
		var preview_rx_yn				= parent.parent.parent.f_header.document.prescription_header_form.preview_rx_yn.value;//added for ML-MMOH-CRF-0341 [IN:057179]

		var bean_id="@DrugSearchBean"+patient_id+encounter_id;
		if(parent.parent.parent.f_header.document.prescription_header_form.order_type.value!="NO"){
			var order_type_code=parent.parent.parent.f_header.document.prescription_header_form.order_type.value;
		}
		else{
			var order_type_code="";
		}

		retVal = DrugSearchForPres("D",document.onCologyRegimenDrugDetails.drug_name,order_type_code,drugCode,bean_id,service_search_yn,servide_code,act_patient_class,priority,discharge_yn,patient_id,encounter_id,date_of_birth,gender,source_type,source_code,"",'9',"","","","","Y"); //added "",'9' for IN26040 --21/01/2011-- priya
		/*	if(parent.parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk!=undefined)
				parent.parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled=true;//added for NMC-JD-CRF-0063	*/
			//added for NMC-JD-CRF-0063 START
			if(parent.parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk!=undefined){
				if(retVal.length==0 || retVal==""){
					if(parent.parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled==false){
						parent.parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled=false;
					}
				}
				else{
					parent.parent.parent.f_header.document.prescription_header_form.take_home_medication_op_chk.disabled=true;
				}
			}//END
		var Drug_Codes =  new Array();
		var	Trade_Codes = new Array();
		var Trade_Names = new Array();
		var i=0;
		var index=0;
		if(retVal.length>0){
			while(i<retVal.length){
				Drug_Codes[index]=retVal[i++];
				Trade_Codes[index]=retVal[i++];
				Trade_Names[index++]=retVal[i++];
			}
		}
		
		if(Drug_Codes.length>0 )  {
			if(parent.parent.parent.f_header.document.prescription_header_form.order_type!=null){
				parent.parent.parent.f_header.document.prescription_header_form.order_type.disabled=true;
			}
			//updateOROrderType(parent.parent.parent.f_header.document.prescription_header_form.order_type.value);
			//updateOROrderCatalog(Drug_Codes);
			//chkDuplicateDrugCode(Drug_Codes, Trade_Codes, Trade_Names );
			parent.parent.parent.f_header.document.prescription_header_form.take_home_medication.disabled=true;
			
			var frmHdr		    = parent.parent.parent.f_header.prescription_header_form;
			//commented by Anbarasi
			//var xmlDoc			= new ActiveXObject("Microsoft.XMLDom");
			//var xmlHttp			= new ActiveXObject("Microsoft.XMLHTTP");
			var xmlDoc = ""; 
			var xmlHttp = new XMLHttpRequest();
			var xmlStr 			= "<root><SEARCH "
				xmlStr		   += "act_pat_class=\"" + act_patient_class + "\" ";  // RUT-CRF-0062  NEWLY ADDED
				xmlStr		   += "source_code=\"" + source_code + "\" ";  // RUT-CRF-0062  NEWLY ADDED
				xmlStr		   += "priority=\"" + priority + "\" ";  // RUT-CRF-0062  NEWLY ADDED
				xmlStr		   += "take_home_medication=\"" + discharge_yn + "\" ";    // RUT-CRF-0062  NEWLY ADDED
				xmlStr		   += buildXMLString(frmObj)  + " /></root>";
	//		   xmlStr		   +=  " /></root>";
	//		   buildXMLString(frmObj)  +
			   xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

			var onco_bean_id					=  document.onCologyRegimenDrugDetails.bean_id.value;
			var onco_bean_name					=  document.onCologyRegimenDrugDetails.bean_name.value;
			var adr_count						=  frmHdr.adr_count.value;
			var bl_install_yn					= frmHdr.bl_install_yn.value;
			var bl_disp_charge_dtl_in_rx_yn		= frmHdr.bl_disp_charge_dtl_in_rx_yn.value;

			xmlHttp.open("POST", "OncologyRegimenValidate.jsp?bean_id="+onco_bean_id+"&bean_name="+onco_bean_name+"&validate=addNewDrugToList&drugCodes="+Drug_Codes+"&patient_id="+patient_id+"&disable_yn=N", false );
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			
			eval(responseText);
			var params		= parent.parent.oncology_options.document.onCologyOptions.params.value;
			var MAR_app_yn	= getMAR_app_yn(frmHdr);
			parent.parent.oncology_drugs.f_oncology_regimen_drug_list.location.href="OncologyRegimenDrugList.jsp?"+params+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count;    	
			
	//		+"&regimen_code="+regimen_code+"&order_type_flag="+order_type_flag+"&order_id="+order_id   +"&regimen_code="+regimen_code
			parent.parent.oncology_drugs.f_preview_buttons.location.href="OncologyRegimenPreviewButtons.jsp?"+params+"&disable_yn=N"+"&MAR_app_yn="+MAR_app_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&iv_prep_yn=9"+"&drug_db_interface_yn="+drug_db_interface_yn+"&preview_rx_yn="+preview_rx_yn; //added preview_rx_yn for ML-MMOH-CRF-0341 [IN:057179]
		}
	}else{
		alert(getMessage("RGMN_CANT_BLANK","PH"));
	}
 }
function alredyInRegimen(){
	alert(getMessage("PH_DRUG_ALREADU_AVAIL","PH"));
}

function assignDurnTypeList(DurnDescDetails){
	
	durn_type_list = DurnDescDetails.substring(1,DurnDescDetails.length-1);
}

function reloadDurnTypeList(repeat_durn_type,def_repeat_durn_type){

if(def_repeat_durn_type=="null")
   def_repeat_durn_type =	repeat_durn_type;
//else
//	repeat_durn_type = def_repeat_durn_type;

	var durnTypeList = "";
		if(durn_type_list.length > 0){
			durnTypeList = durn_type_list.split(",");
			if(repeat_durn_type != ''){
				clearDurationTypeList();
			}
		}

	//clearDurationTypeList();
	var durn_type_value = "";
	var durn_type_code  = "";
	for(i=0;i<durnTypeList.length;i++){
		
		durn_type_value = durnTypeList[i].split("=");
		durn_type_code = trimString(durn_type_value[0]);
		if(def_repeat_durn_type == 'M'){
			if(durn_type_code == 'M' || durn_type_code == 'H' || durn_type_code == 'D' || durn_type_code == 'W' ){
				addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);			
				//|| durn_type_code == 'L' || durn_type_code == 'Y'
			}
		} else if(def_repeat_durn_type == 'H'){
			if(durn_type_code == 'H' || durn_type_code == 'D' || durn_type_code == 'W' ){
				addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);
				//|| durn_type_code == 'L' || durn_type_code == 'Y'
			}
		} else if(def_repeat_durn_type == 'D'){
			if(durn_type_code == 'D' || durn_type_code == 'W' || durn_type_code == 'L' || durn_type_code == 'Y'){

				addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);			
			}
		} else if(def_repeat_durn_type == 'W'){
			if(durn_type_code == 'W' || durn_type_code == 'L' || durn_type_code == 'Y'){
				addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);			
			}
		} else if(def_repeat_durn_type == 'L'){
			if(durn_type_code == 'L' || durn_type_code == 'Y'){
				addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);			
			}
		}
		else if(def_repeat_durn_type == 'Y'){
			if(durn_type_code == 'Y'){
				addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);			
			}
		}
	}

	dfltDurnDesc(repeat_durn_type);

//	validateDuration(document.oncologyRegimenAdminDetail.durn_value);

	if(document.oncologyRegimenAdminDetail == undefined){
		parent.parent.oncology_drugs.oncology_admin.document.oncologyRegimenAdminDetail.freq_chng_durn_desc.value= repeat_durn_type;
	}else{
		document.oncologyRegimenAdminDetail.freq_chng_durn_desc.value = repeat_durn_type;
	}
}

function clearDurationTypeList(){
	var len =document.oncologyRegimenAdminDetail.durn_unit.options.length;
	for(var i=0;i<len;i++) {
		document.oncologyRegimenAdminDetail.durn_unit.remove("durn_desc") ;
	}
}

function addDurationTypeList(code,desc,default_val)	{

	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	if(default_val!=''){
		if(code==default_val)	{
			element.selected	=	true;
		}
		document.oncologyRegimenAdminDetail.durn_unit.add(element);
	}
}

function dfltDurnDesc(repeat_durn_type){

	if(document.oncologyRegimenAdminDetail != undefined){
		var freq_nature = document.oncologyRegimenAdminDetail.freq_nature.value;
		if(repeat_durn_type=="L"){
			document.oncologyRegimenAdminDetail.durn_unit.value="L";
			document.oncologyRegimenAdminDetail.durn_unit.disabled=true;
		}
		if(repeat_durn_type=="W"){
			document.oncologyRegimenAdminDetail.durn_unit.value="W";
			document.oncologyRegimenAdminDetail.durn_unit.disabled=true;
		}
		if(repeat_durn_type=="D"){
			document.oncologyRegimenAdminDetail.durn_unit.value="D";
			document.oncologyRegimenAdminDetail.durn_unit.disabled=true;
		}
		if(repeat_durn_type=="H"){
			document.oncologyRegimenAdminDetail.durn_unit.value="H";
	//		document.prescription_detail_form.durn_value.value="1";
			document.oncologyRegimenAdminDetail.durn_unit.disabled=true;
			//document.oncologyRegimenAdminDetail.calcualted_durn_value.value="1";
		}
		if(repeat_durn_type=="M"){
			document.oncologyRegimenAdminDetail.durn_unit.value="M";
	//		document.prescription_detail_form.durn_value.value="1";
			document.oncologyRegimenAdminDetail.durn_unit.disabled=true;
		}
		if(repeat_durn_type=="Y"){
			document.oncologyRegimenAdminDetail.durn_unit.value="Y";
	//		document.prescription_detail_form.durn_value.value="1";
			document.oncologyRegimenAdminDetail.durn_unit.disabled=true;
		}
		if(freq_nature != "P" && freq_nature != 'O'){
			document.oncologyRegimenAdminDetail.durn_unit.disabled=false;
		}
		else{
			document.oncologyRegimenAdminDetail.durn_unit.disabled=true;
		}
		checkScheduledYN(document.oncologyRegimenAdminDetail.frequency.value);
		changeDate();
	}
}

function setChngdDose(chngd_dose_value){

	if(parent.parent.frames[1].frames[3].document.forms[0].fluid_frame_display_yn.value == 'N'){
		var bean_id				= document.forms[0].bean_id.value;
		var bean_name			= document.forms[0].bean_name.value;
		var drug_code			= document.forms[0].drug_code.value;
		var ocurrance_num       = document.forms[0].ocurrance_num.value;
//commented by Anbarasi
		//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
		//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
		var xmlDoc = ""; 
		var xmlHttp = new XMLHttpRequest();
		var xmlStr		= "<root><SEARCH ";
		xmlStr			+= " drug_code=\""+ drug_code + "\" ";
		xmlStr			+= " ocurrance_num=\""+ ocurrance_num + "\" ";
		xmlStr			+= " chngd_dose_value=\""+ chngd_dose_value + "\" ";

		xmlStr +=" /></root>";

		var temp_jsp="OncologyRegimenValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=setChangedDosage";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert(responseText);
	}
}
function setCalculateBy(obj1,mode)
{
	if(mode==undefined || mode!="AMEND_RESET" )
	{
		var frmobj=document.onCologyRegimenDrugDetails;
		var frmobj1=document;
	}
	else if(mode=="AMEND_RESET")
	{
		var frmobj=parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
		var frmobj1=parent.f_oncology_sub_drugs.document;
	}

	if(frmobj.CALC_DOSE_BASED_ON[0].checked)
	{
		frmobj.dosage_type_list.style.display="inline";
		frmobj.dose.style.display="none";
		frmobj.doseUom.style.display="none";
		frmobj1.slashLabel.style.display="none";
		frmobj.caclDoseBy_unit.style.display="none";
		//frmobj1.equalLabel.style.display="none";
		frmobj.totalDose.value=frmobj.doseValue.value;
		frmobj.totalDose.focus(); //added for IN26467 --11/02/2011-- priya
		//frmobj.
		if(frmobj.or_dose_type!=undefined && frmobj.or_dose_type.value!=""){ // Added for ML-MMOH-CRF-0345 [IN:057441] -Start
			setDosageUOM(); 
			frmobj.totalDose.disabled = false; 
		}// Added for ML-MMOH-CRF-0345 [IN:057441] - End
	}
	else
	{
		frmobj.dosage_type_list.style.display="none";
		frmobj.dose.style.display="inline";
		frmobj.doseUom.style.display="inline";
		frmobj1.slashLabel.style.display="inline";
		frmobj.caclDoseBy_unit.style.display="inline";
	//	frmobj1.equalLabel.style.display="inline";
		frmobj.dosage_type_list.value="S";
		setDosageUOM();
		calcTotalDose(frmobj);
		frmobj.dose.focus(); //added for IN26467 --11/02/2011-- priya
		if(frmobj.or_dose_type!=undefined && frmobj.or_dose_type.value!=""){ // Added for ML-MMOH-CRF-0345 [IN:057441] -Start
		  frmobj.totalDose.disabled = true; 
		}// Added for ML-MMOH-CRF-0345 [IN:057441] - End
	}
}
function setDosageUOM()
{
	if(document.onCologyRegimenDrugDetails!=undefined)
	{
		frmobj=document.onCologyRegimenDrugDetails;
		frmobj1=document;
	}
	else
	{
		frmobj=parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
		frmobj1=parent.f_oncology_sub_drugs.document;
	}
	var drug_code = frmobj.drug_code.value; 
	var strength_uom_code=frmobj.uom_code.value;
	var strength_uom_desc=frmobj.strength_uom_desc.value;
	var pres_base_uom=frmobj.pres_base_uom.value;
	var pres_base_uom_desc=frmobj.pres_base_uom_desc.value;
	if(frmobj.dosage_type_list.value=='Q')
	{
		frmobj1.totaldoseUOM.innerText=pres_base_uom_desc;
		frmobj.drug_unit_code.value =pres_base_uom;
		frmobj.drug_unit.value =pres_base_uom_desc;
		frmobj.totalDose.value =frmobj.pres_qty_value.value;		
	}
	else
	{
		frmobj1.totaldoseUOM.innerText=strength_uom_desc;
		frmobj.drug_unit_code.value =strength_uom_code;
		frmobj.drug_unit.value =strength_uom_desc;		
		frmobj.totalDose.value =frmobj.qty_value.value; //'doseValue' replaced by 'qty_value' for IN032142
	}
	/*=======================================================================================================*/
	//added for IN27290 --24/05/2011-- priya
		var bean_id				=frmobj.bean_id.value;
		var bean_name			= frmobj.bean_name.value;
		var xmlDoc	= "";
		var xmlHttp	= new XMLHttpRequest();
		var xmlStr		= "<root><SEARCH ";
		xmlStr			+= " drug_code=\""+ drug_code + "\" ";
		xmlStr			+= " drug_unit_code=\""+ frmobj.drug_unit_code.value + "\" ";

		xmlStr +=" /></root>";
		var temp_jsp="OncologyRegimenValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=setChangedUom";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
	/*=======================================================================================================*/
	frmobj.dosage_type.value =frmobj.dosage_type_list.value;
	frmobj.totalDose.focus();
}
/* Added for  ML-BRU-CRF-072[Inc:29938] start */
async function drugindication_remarks(){
	var drugformObj		= document.onCologyRegimenDrugDetails;
	var bean_id			= drugformObj.bean_id.value;
	var bean_name		= drugformObj.bean_name.value;
    var patient_id		= drugformObj.patient_id.value; 
	var encounter_id	= drugformObj.encounter_id.value;	
    var DrugIndicationRemarks = drugformObj.DrugIndicationRemarks.value;
	var drug_code =	drugformObj.drug_code.value;
	var dialogHeight= "35vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "300" ;
	var dialogLeft ="450";
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "" ;
	retVal = await top.window.showModalDialog("../../ePH/jsp/DrugIndicationRemarks.jsp?&DrugIndicationRemarks="+encodeURIComponent(DrugIndicationRemarks)+"&drug_code="+drug_code+"&bean_id="+bean_id+"&bean_name="+bean_name+"&iv_prep_yn=9",arguments,features);//remove escape and add encodeURIComponent for MMS Adhoc Testing
	if(retVal!= undefined && retVal!=null)
		drugformObj.DrugIndicationRemarks.value=retVal;		
}

function savedrugIndicationRemarks(drug_indicate){
	var drug_indication_new = encodeURIComponent(drug_indicate.value);
//	window.returnValue=drug_indication_new;
//	window.close();
	parent.document.querySelectorAll("#dialog-body")[parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = drug_indication_new;
    
	parent.document.querySelectorAll("#dialog_tag")[parent.document.querySelectorAll("#dialog_tag").length -1].close();


}
function checkDrugIndMaxLimit(obj,maxLeng) { 
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("ePH.DrugIndications.label","PH"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,(val.length)-1);
		alert(msg);
		obj.focus();
		return false;
	} 
	else 
		return true;
}
/* Added for  ML-BRU-CRF-072[Inc:29938] End*/

//ML-MMOH-CRF-0345 - start
async function DisplayCycle(drug_code,srl_no){
		
		var frmAdminObj		= document.oncologyRegimenAdminDetail;
		var start_date		= frmAdminObj.start_date.value;
		var bean_id			= frmAdminObj.bean_id.value;
		var bean_name		= frmAdminObj.bean_name.value;
		var repeat_durn_type= frmAdminObj.repeat_durn_type.value;
		var no_of_cycle     = frmAdminObj.no_of_cycle.value;
		var order_type_flag	= frmAdminObj.order_type_flag.value;
		var dialogTop		= "";
		var dialogHeight	= "35vh";
		var dialogWidth		= "50vw";
		var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
		var arguments		= "";

		var retVal 			= await window.showModalDialog("../../ePH/jsp/OncologyCycleScheduleFreq.jsp?&start_date="+start_date+"&drug_code="+drug_code+"&srl_no="+srl_no+"&bean_id="+bean_id+"&bean_name="+bean_name+"&no_of_cycle="+no_of_cycle+"&repeat_durn_type="+repeat_durn_type+"&order_type_flag="+order_type_flag,arguments,features);	

		if(retVal!=undefined ){
			var retVals = retVal.split('|');
			frmAdminObj.start_date.value = retVals[0];
			frmAdminObj.end_date.value	 = retVals[1];
		}

}


function setChangedCycleAdminTime(){

	var frmObj = document.onCologyCycleScheduleFreq;
	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value;
	var no_of_cyle = parseInt(frmObj.no_of_cycle.value);
	var repeat_value = parseInt(frmObj.repeat_value.value);
	var repeat_drun_type = frmObj.repeat_durn_type.value;
	var drug_code	= frmObj.drug_code.value;
	var srl_no		= frmObj.srl_no.value;
	var allow_flag  = true;//ML-MMOH-CRF-1004 - start
	//alert("no_of_cyle==>"+no_of_cyle+"==repeat_value===>"+repeat_value+"==srl_no===>"+srl_no+"==drug_code==>"+drug_code);
		for(var k=0;k<no_of_cyle;k++){
			if(repeat_drun_type=="W" || repeat_drun_type=="L")
		      admin_day = eval("frmObj.cycle_"+k).value;
			else
			  admin_day = eval("frmObj.admin_day_"+k).value;
			if(admin_day==null || admin_day ==""){
				allow_flag = false;
				break;
			}
			
		}
		if(allow_flag==false){
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			if(repeat_drun_type=="W")
				msg = msg.replace('$', "Cycle Week");
			else if(repeat_drun_type=="L")
				msg = msg.replace('$', "Cycle Month");
			else
				msg = msg.replace('$', "Cycle Day");

			alert(msg);

			return false;
		}

		/*for(var kk=0;kk<no_of_cyle;kk++){
			if(repeat_drun_type=="W" || repeat_drun_type=="L"){
		      admin_day = eval("frmObj.cycle_"+kk).value;
			  next_admin_day = eval("frmObj.cycle_"+(kk+1)).value;
			}
			else{
			  admin_day = eval("frmObj.admin_day_"+kk).value;
			  next_admin_day = eval("frmObj.admin_day_"+(kk+1)).value;
			}
		} */

		var alert_flag = false;
		if(no_of_cyle>1){
			for(kk=0;kk<no_of_cyle;kk++){
				if(repeat_drun_type=="W" || repeat_drun_type=="L")
					prev_admin_day = eval("frmObj.cycle_"+kk).value;
				else
					prev_admin_day = eval("frmObj.admin_day_"+kk).value;

				for(jj=kk+1;jj<no_of_cyle;jj++){

					if(repeat_drun_type=="W" || repeat_drun_type=="L")
						next_admin_time = eval("frmObj.cycle_"+jj).value;
					else
						next_admin_time = eval("frmObj.admin_day_"+jj).value;
				
					if(parseInt(prev_admin_day) > parseInt(next_admin_time)){
						alert_flag = true;
					}
				
				
				if(alert_flag ==true)
					break;
				}
				if(alert_flag == true)
					break;
			}
			if(alert_flag==true){

			msg = getMessage("PH_CYCLE_INC_ORDER","PH");
			if(repeat_drun_type=="W")
				msg = msg.replace('$', "Cycle Week");
			else if(repeat_drun_type=="L")
				msg = msg.replace('$', "Cycle Month");
			else
				msg = msg.replace('$', "Cycle Day");

			alert(msg);

			return false;
			}
		}
//ML-MMOH-CRF-1004

		if(compareCycleDay(frmObj,repeat_drun_type)){
				alert("Repeated day/time entries");
				return false;
		}			
	
		if(compareAdminTime(frmObj)){
			alert("Time Value should be entered in increasing order ");
			return false;					
		}
		var xmlStr ="<root><SEARCH ";	
		
		xmlStr+= "no_of_cyle=\"" + frmObj.no_of_cycle.value+ "\" " ;
		xmlStr+= "repeat_value=\"" + frmObj.repeat_value.value+ "\" " ;
		xmlStr+= "drug_code=\"" + frmObj.drug_code.value+ "\" " ;
		xmlStr+= "srl_no=\"" + srl_no+ "\" " ;

		for(var i=0; i<no_of_cyle; i++){
			if(repeat_drun_type=="W" || repeat_drun_type=="L")
			xmlStr+= "cycle_"+i+"=\"" + eval("frmObj.cycle_"+i).value+ "\" " ;
			
			
			xmlStr+= "admin_day_"+i+"=\"" + eval("frmObj.admin_day_"+i).value+ "\" " ;

			xmlStr+= "cycle_start_date_"+i+"=\"" + eval("frmObj.cycle_start_date_"+i).value+ "\" " ;
			xmlStr+= "cycle_end_date_"+i+"=\"" + eval("frmObj.cycle_end_date_"+i).value+ "\" " ;
			xmlStr+= "cycle_checked_yn_"+i+"=\"" + eval("frmObj.cycle_checked_yn_"+i).value+ "\" " ;//ML-MMOH-CRF-1004
			for (var j=0;j<repeat_value;j++ ){
				xmlStr+= "time_"+i+"_"+j+"=\"" + eval("frmObj.time_"+i+"_"+j).value+ "\" " ;
			}
		}
		xmlStr+= "repeat_drun_type=\"" + repeat_drun_type+ "\" " ;
		
		xmlStr +=" /></root>";

		var temp_jsp="OncologyRegimenValidate.jsp?validate=SAVECYCLESCHEDULE&bean_id="+bean_id+"&bean_name="+bean_name;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
		//window.close();
		
	    
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();  
}

function changeScheduleStartDates(obj,index){

	var frmObj     = document.onCologyCycleScheduleFreq;
	var bean_id	   = frmObj.bean_id.value;
	var bean_name  = frmObj.bean_name.value;
	var start_date = frmObj.bean_name.value;
	var no_of_cyle = parseInt(frmObj.no_of_cycle.value);
	var repeat_durn_type = frmObj.repeat_durn_type.value;

	var start_date = "";
	var admin_day  = "";
	var cycle_no   = "";

	for(var i=0; i<no_of_cyle; i++){
		if(i==index){
			if(i!=0){
				start_date = eval("frmObj.cycle_start_date_"+(i-1)).value;
				admin_day  = eval("frmObj.admin_day_"+i).value;
				prev_cycle_no   = eval("frmObj.cycle_"+(i-1)).value;
				curr_cycle_no  = eval("frmObj.cycle_"+i).value;
				//alert("admin_day==>"+admin_day+"==start_date==>"+start_date+"==cycle_no==>"+cycle_no);
				
			}else{
				start_date = eval("frmObj.start_date_time"+i).value;
				admin_day  = eval("frmObj.admin_day_"+i).value;
				prev_cycle_no   = eval("frmObj.cycle_"+i).value;
				curr_cycle_no = prev_cycle_no;
			}
			break;
		}
	}
	if(repeat_durn_type=="W"){
		if(index!=0)
			admin_day = ((parseInt(curr_cycle_no) - parseInt(prev_cycle_no))*7)+parseInt(admin_day);
	}else{
		if(index!=0)
			admin_day = ((parseInt(curr_cycle_no) - parseInt(curr_cycle_no))*30)+parseInt(admin_day);
	}
	getStartDateForCycle(admin_day,start_date,index);
	//alert("OncologyRegimen.js===3643==no_of_cycle==>"+frmObj.no_of_cycle.value+"===drug_code=>"+frmObj.drug_code.value+"==obj.value==>"+obj.value+"==start_date===>"+start_date);
	/*	var xmlStr ="<root><SEARCH ";	
		xmlStr+= "no_of_cyle=\"" + frmObj.no_of_cycle.value+ "\" " ;
		xmlStr+= "drug_code=\"" + frmObj.drug_code.value+ "\" " ;
		xmlStr+= "day_list=\"" + obj.value+ "\" " ;
		xmlStr +=" /></root>";

		var temp_jsp="OncologyRegimenValidate.jsp?validate=CHANGESCHEDULESTARTDATE&bean_id="+bean_id+"&bean_name="+bean_name;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText); */
}
function changeStartDate(obj,index,locale){
	var formObj     = document.onCologyCycleScheduleFreq;

	var no_of_cyle = parseInt(formObj.no_of_cycle.value);
	var repeat_durn_type = formObj.repeat_durn_type.value;

	if(validDate(obj.value, "DMYHM",locale )){ //added for ML-MMOH-CRF-0345
	if(repeat_durn_type=="W" || repeat_durn_type=="L")
		calcStartDateForWeek(obj,index,"Y",'');
	else
		calcStartDateForDay(obj,index,'N');
	}else{
			alert(getMessage("INVALID_DATE_TIME", "PH"));
			obj.focus();
			return false;
	}

}


function displayCycleToolTip(drug_code,srl_no){
		
		if(drug_code!=""){
		var frmAdminObj		= document.oncologyRegimenAdminDetail;
		var drugformObj		= parent.f_oncology_sub_drugs.onCologyRegimenDrugDetails;
		//var qty_value		= drugformObj.qty_value.value;
		var qty_value		= drugformObj.totalDose.value;
		var bean_id			= frmAdminObj.bean_id.value;
		var bean_name		= frmAdminObj.bean_name.value;
		var strength_uom_desc=drugformObj.strength_uom_desc.value;//ML-MMOH-CRF-1004 - start
		var pres_base_uom_desc=drugformObj.pres_base_uom_desc.value;
		if(drugformObj.dosage_type_list.value=='Q')
			dose_uom = pres_base_uom_desc;
		else
			dose_uom = strength_uom_desc;//ML-MMOH-CRF-1004 - end
		var xmlDoc	= "";
		var xmlHttp	= new XMLHttpRequest();
		var xmlStr		= "<root><SEARCH ";
		
		xmlStr			+= " no_of_cycle=\""+ frmAdminObj.no_of_cycle.value + "\" ";
		xmlStr			+= " srl_no=\""+ srl_no + "\" ";
		xmlStr			+= " drug_code=\""+ drug_code + "\" ";
		xmlStr			+= " qty_value=\""+ qty_value + "\" ";
		xmlStr			+= " dose_uom=\""+ dose_uom + "\" ";//ML-MMOH-CRF-1004

		xmlStr +=" /></root>";
		//alert("xmlStr==>"+xmlStr);
		var temp_jsp="OncologyRegimenValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=getToolTipData";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);
		}
	
}
function displayCycleToolTip1(admin_time,admin_qty){
	//alert("admin_time+admin_qty==>"+admin_time+admin_qty);
	//var title="<table border=1 cellpadding=0 cellspacing=0 align=center>"+admin_time+admin_qty+"</table>";
	displayToolTipDataChange1(admin_time);
}


function displayToolTipDataChange1(text){

    buildTableDataChange(text);
    bodwidth  = parent.parent.frames[1].document.body.offsetWidth
    bodheight = parent.parent.frames[1].document.body.offsetHeight
    var x     = event.clientX; //event.x changed to event.clientX IE_11 Issue 
    var y     = event.clientY; //event.y changed to event.clientY IE_11 Issue 	
    x     = x + (document.getElementById("tooltiplayer").offsetWidth)
    y     = y + (document.getElementById("tooltiplayer").offsetHeight)
    if(x<bodwidth)
        x = event.clientX; //event.x changed to event.clientX IE_11 Issue 
    else
        x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

    if(y<bodheight)
        y = event.clientY; //event.y changed to event.clientY IE_11 Issue 	
    else
        y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
    y+=document.body.scrollTop
    x+=document.body.scrollLeft

	document.getElementById("tooltiplayer").style.posLeft= x-70;
	

	if(x > 600 )
		document.getElementById("tooltiplayer").style.posTop = y+15;
	else
		document.getElementById("tooltiplayer").style.posTop = y-15;

	
	document.getElementById("tooltiplayer").style.visibility='visible';
}


function disasbleToolTipDataChange1(){
    document.getElementById("tooltiplayer").style.visibility = "hidden" ;
}
function buildTableDataChange(text){
	var tab_dat  = text ;
	document.getElementById("t").innerHTML = tab_dat;
}
function calcStartAndEndDate(obj,curr_cycle_no){
	var frmObj     = document.onCologyCycleScheduleFreq;
	var no_of_cyle = parseInt(frmObj.no_of_cycle.value);
	var start_date_time = frmObj.start_date_time.value
	//alert("no_of_cyle==>"+no_of_cyle+"==start_date_time==>"+start_date_time);
	var start_date = "";
	for(var i=0; i<no_of_cyle; i++){
		if(i==curr_cycle_no){
			getStartDateForCycle(parseInt(obj.value)-1,start_date_time,i);
			
		}/*else{
			if(i>curr_cycle_no){
				admin_day = eval("frmObj.admin_day_"+i).value;
				getStartDateForCycle(parseInt(admin_day)-1,start_date_time,i);
				
			}
		}*/
	}
}
function calcStartDateForDay(obj,curr_cycle_no,admin_day_changed_yn){//admin_day_changed_yn added for ML-MMOH-CRF-1228
	var frmObj     = document.onCologyCycleScheduleFreq;
	var no_of_cyle = parseInt(frmObj.no_of_cycle.value);
	var start_date_time = frmObj.start_date_time.value;
	var locale			= frmObj.locale.value;//ML-MMOH-CRF-1228
	//alert("no_of_cyle==>"+no_of_cyle+"==start_date_time==>"+start_date_time);
	var start_date = "";
	if(obj.value =="" || obj.value==null){//ML-MMOH-CRF-1004 - start
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace('$', "Cycle Day");
		alert(msg);
		obj.focus();
		return false;
	}

	if(obj.value!=""){//ML-MMOH-CRF-1004 - end
		for(var i=0; i<no_of_cyle; i++){
			if(i==0){
				start_date_time = frmObj.cycle_start_date_0.value;
//ML-MMOH-CRF-1228 - start
				first_start_date= frmObj.first_start_date.value;
				if(admin_day_changed_yn!="Y"){
					no_of_day = daysBetween(first_start_date,start_date_time,"DMYHM",locale);
					admin_day = parseInt(eval("frmObj.admin_day_"+i).value);
					if(admin_day+parseInt(no_of_day)==0)
						eval("frmObj.admin_day_"+i).value = 1;
					else
						eval("frmObj.admin_day_"+i).value = admin_day+parseInt(no_of_day) ;
				}else{
					day_list = parseInt(eval("frmObj.admin_day_"+i).value);
					def_admin_day = parseInt(eval("frmObj.def_admin_day_"+i).value);
					if(day_list>def_admin_day)
					{
						start_date = plusDate(start_date_time, "DMYHM", locale,(day_list-def_admin_day) , "d");
					}else{
						start_date = minusDate(start_date_time, "DMYHM", locale,(def_admin_day-day_list) , "d");
					}
					frmObj.cycle_start_date_0.value=start_date ;
					frmObj.cycle_end_date_0.value=plusDate(start_date, "DMYHM", locale,1, "d") ;
					frmObj.first_start_date.value=start_date;
				}
//ML-MMOH-CRF-1228 - end
				
			}else{
				pre_admin_day = eval("frmObj.admin_day_"+(i-1)).value
				admin_day = eval("frmObj.admin_day_"+i).value;
				start_date_time = eval("frmObj.cycle_start_date_"+(i-1)).value;
				if(admin_day!= null && admin_day!="" && pre_admin_day!=null && pre_admin_day!=""){//ML-MMOH-CRF-1004
					getStartDateForCycle((parseInt(admin_day)-parseInt(pre_admin_day)),start_date_time,i);
				}
			}
				
				eval("frmObj.def_admin_day_"+i).value = eval("frmObj.admin_day_"+i).value;//added for ML-MMOH-CRF-1228
		}
				frmObj.first_start_date.value=eval("frmObj.cycle_start_date_0").value;//added for ML-MMOH-CRF-1228

	}
}


function calcStartDateForWeek(obj,index,select_date,change_cycle){

	var frmObj     = document.onCologyCycleScheduleFreq;
	var bean_id	   = frmObj.bean_id.value;
	var bean_name  = frmObj.bean_name.value;
	var start_date = frmObj.bean_name.value;
	var no_of_cyle = parseInt(frmObj.no_of_cycle.value);
	var repeat_durn_type = frmObj.repeat_durn_type.value;
	var locale     = frmObj.locale.value; //ML-MMOH-CRF-1228


	var start_date = "";
	var admin_day  = "";
	var cycle_no   = "";
	if(obj.value==null || obj.value==""){//ML-MMOH-CRF-1004 - start
		var msg = getMessage("CAN_NOT_BE_BLANK","Common");
		if(repeat_durn_type=="W")
			msg = msg.replace('$', "Cycle Week");
		else if(repeat_durn_type=="L")
			msg = msg.replace('$', "Cycle Month");

		alert(msg);
		obj.focus();
		return false;
	}
//ML-MMOH-CRF-1004 - end
//ML-MMOH-CRF-1228 - start
var cycle_week;
var cycle_month_week;
if(repeat_durn_type=="W")
	cycle_month_week =7;
else
	cycle_month_week =30;
//ML-MMOH-CRF-1228 - end
	for(var i=0; i<no_of_cyle; i++){

		if(i==index && i==0 && change_cycle!="C"){
			if(select_date=="Y"){
				frmObj.cycle_start_date_0.value = obj.value;
				//ML-MMOH-CRF-1228 - start				
				first_start_date=frmObj.first_start_date.value;
				no_of_day = daysBetween(first_start_date,obj.value,"DMYHM",locale);
					admin_day = parseInt(eval("frmObj.admin_day_"+i).value);
					cycle_week = eval("frmObj.cycle_"+i).value ;
						if(repeat_durn_type=="W" || repeat_durn_type=="L"){
						 if(admin_day+parseInt(no_of_day)>cycle_month_week){
							 cycle_week = parseInt(cycle_week)+parseInt(Math.floor((admin_day+parseInt(no_of_day))/cycle_month_week));
							 admin_day  = Math.ceil((admin_day+parseInt(no_of_day))%cycle_month_week);
						 }else{
							 if(no_of_day<-cycle_month_week){
									cycle_week = parseInt(cycle_week)-parseInt(Math.floor((parseInt(Math.abs(no_of_day)))/cycle_month_week));
							 }else
							  admin_day  = (admin_day+parseInt(no_of_day));
						 }
						}
						eval("frmObj.admin_day_"+i).value = admin_day;
						eval("frmObj.cycle_"+i).value = cycle_week;
					frmObj.first_start_date.value = obj.value;
					frmObj.cycle_end_date_0.value=plusDate(obj.value, "DMYHM", locale,1, "d") ;
			} //ML-MMOH-CRF-1228 - end
			else{
				//start_date_time = frmObj.start_date_time.value;
				start_date_time = frmObj.cycle_start_date_0.value;
				admin_day  = eval("frmObj.admin_day_"+i).value;
				def_admin_day = eval("frmObj.def_admin_day_"+i).value;//ML-MMOH-CRF-1228 - start
				eval("frmObj.def_admin_day_"+i).value = admin_day;
					if(admin_day>def_admin_day)
					{
						start_date = plusDate(start_date_time, "DMYHM", locale,(admin_day-def_admin_day) , "d");
					}else{
						start_date = minusDate(start_date_time, "DMYHM", locale,(def_admin_day-admin_day) , "d");
					}
					frmObj.cycle_start_date_0.value=start_date ;
					frmObj.cycle_end_date_0.value=plusDate(start_date, "DMYHM", locale,1, "d") ;
					frmObj.first_start_date.value=start_date;
					frmObj.start_date_time.value = start_date;
				//ML-MMOH-CRF-1228 - end
			}
			
		}else{
			curr_cycle_no = eval("frmObj.cycle_"+i).value;//ML-MMOH-CRF-1228 
				if(i>0){
				start_date	  = eval("frmObj.cycle_start_date_"+(i-1)).value;
				prev_cycle_no = eval("frmObj.cycle_"+(i-1)).value;
			//	curr_cycle_no = eval("frmObj.cycle_"+i).value;
				if(i==index)
					admin_day = obj.value;
				else
					admin_day  = eval("frmObj.admin_day_"+i).value;

				if(repeat_durn_type=="W" || repeat_durn_type=="L")
					 admin_day = (((parseInt(curr_cycle_no) - parseInt(prev_cycle_no))*cycle_month_week)+(parseInt(admin_day)));
/*				else
					 admin_day = (((parseInt(curr_cycle_no) - parseInt(prev_cycle_no))*cycle_month_week)+(parseInt(admin_day)));*/

			getStartDateForCycle(admin_day,start_date,i);
			}else{ //added for ML-MMOH-CRF-1228 - start
				if(index==0){
				def_cycle_no = eval("frmObj.def_cycle_"+i).value;
				
				start_date	  = eval("frmObj.cycle_start_date_"+i).value;
				admin_day  = eval("frmObj.admin_day_"+i).value;
				if(repeat_durn_type=="W" || repeat_durn_type=="L"){
					if(parseInt(def_cycle_no)>parseInt(curr_cycle_no))
					{
					 admin_day = -(((parseInt(def_cycle_no) - parseInt(curr_cycle_no))*cycle_month_week));
					}else{
						admin_day = (((parseInt(curr_cycle_no) - parseInt(def_cycle_no))*cycle_month_week));
					}

				}
			/*	else{
					if(parseInt(def_cycle_no)>parseInt(curr_cycle_no))
					{
						 admin_day = -(((parseInt(def_cycle_no) - parseInt(curr_cycle_no))*cycle_month_week)+(parseInt(admin_day)));
					}else{
						admin_day = (((parseInt(curr_cycle_no) - parseInt(def_cycle_no))*cycle_month_week)+(parseInt(admin_day)));
					}
				} */

				getStartDateForCycle(admin_day,start_date,i);
				eval("frmObj.def_cycle_"+i).value = curr_cycle_no;
				} //added for ML-MMOH-CRF-1228 - end
			}
		}
		}
}

function getStartDateForCycle(admin_day,start_date_time,cycle_row){
	var frmObj     = document.onCologyCycleScheduleFreq;
	var bean_id	   = frmObj.bean_id.value;
	var bean_name  = frmObj.bean_name.value;
	//commented by Anbarasi
	//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
	//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	var xmlStr		= "<root><SEARCH ";
	xmlStr			+= " admin_day=\""+ admin_day + "\" ";
	xmlStr			+= " start_date_time=\""+ start_date_time + "\" ";
	xmlStr			+= " cycle_row=\""+ cycle_row + "\" ";
	xmlStr +=" /></root>";
	var temp_jsp="OncologyRegimenValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=getStartDateForCycle";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);

}

function assignStartEndDate(start_date,end_date,cycle_row){
	var frmObj     = document.onCologyCycleScheduleFreq;
//	alert("start_date"+start_date+"end_date"+end_date+"cycle_row"+(cycle_row-1));
	//if  condtion added for ml-mmoh-scf-1050
	//if(cycle_row == 1)
	//eval("frmObj.cycle_end_date_"+(cycle_row-1)).value = end_date;
	
	eval("frmObj.cycle_start_date_"+cycle_row).value = start_date;
	eval("frmObj.cycle_end_date_"+cycle_row).value = end_date;
}

function setCycleFreqDetails(obj,site_spec){
	var frmAdminObj		= document.oncologyRegimenAdminDetail;

	var freq_code		 = obj.value;
	var repeat_durn_type = frmAdminObj.repeat_durn_type.value;
	var repeat_value	 = frmAdminObj.repeat_value.value;
	var start_date       = frmAdminObj.start_date.value;
	var drug_code		 = frmAdminObj.drug_code.value;
	var srlNo			 = frmAdminObj.srlNo.value;
	var bean_id			 = frmAdminObj.bean_id.value;
	var bean_name		 = frmAdminObj.bean_name.value;
	var xmlDoc			 = "";
	var xmlHttp			 = new XMLHttpRequest();

	if( site_spec=="true"){ //added for ICN66351
		if(freq_code=="" && frmAdminObj.btn_schedule_cycle!=undefined){
			frmAdminObj.btn_schedule_cycle.disabled=true;
		}else{
			frmAdminObj.btn_schedule_cycle.disabled=false;
		}
	}
	//alert("freq_code==>"+freq_code+"==obj.value==>"+obj.value+"==repeat_durn_type==>"+repeat_durn_type+"=repeat_value="+repeat_value+"==start_date==>"+start_date+"==drug_code===>"+drug_code+"==srlNo==>"+srlNo);
	var xmlStr			 = "<root><SEARCH ";
	xmlStr			+= " freq_code=\""+ obj.value + "\" ";
	xmlStr			+= " repeat_durn_type=\""+ repeat_durn_type + "\" ";
	xmlStr			+= " repeat_value=\""+ repeat_value + "\" ";
	xmlStr			+= " start_date=\""+ start_date + "\" ";
	xmlStr			+= " drug_code=\""+ drug_code + "\" ";
	xmlStr			+= " srlNo=\""+ srlNo + "\" ";
	xmlStr +=" /></root>";
	var temp_jsp="OncologyRegimenValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=getCycleFreqDetails";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);
}

function assignNoOfCycle(no_of_cycle,repeat_durn_type,end_date){
	var frmAdminObj		= document.oncologyRegimenAdminDetail;
	//alert("no_of_cycle=3828=>"+no_of_cycle);
	frmAdminObj.no_of_cycle.value = no_of_cycle;
	var len1 = frmAdminObj.durn_unit.options.length;
	for(img1=0;img1<len1;img1++)
	{
		if(frmAdminObj.durn_unit.options[img1].value==repeat_durn_type)
		{
			frmAdminObj.durn_unit.selectedIndex= img1	;
			frmAdminObj.durn_unit.disabled = true;
			frmAdminObj.durn_value.value =1;
			frmAdminObj.durn_value.disabled = true;
			break;
		}
	}
	frmAdminObj.end_date.value = end_date;
}


function compareCycleDay(formObj,repeat_drun_type){

	var no_of_cycle = parseInt(formObj.no_of_cycle.value);
	if(repeat_drun_type=="D")
		var pres_cycle_day = formObj.admin_day_0.value;
	else
		var pres_cycle_day = formObj.cycle_0.value;
	var alert_flag = false;
	for(k=1;k<no_of_cycle;k++){
		if(repeat_drun_type=="D")
		  next_cycle_day =eval("formObj.admin_day_"+k).value;
		else
			next_cycle_day =eval("formObj.cycle_"+k).value;

		if(parseInt(pres_cycle_day)<parseInt(next_cycle_day)){
			pres_cycle_day = next_cycle_day;
		}else{
			alert_flag = true;
		}
		if(alert_flag ==true)
		break;
	}

	return alert_flag;
}

function compareAdminTime(formObj){

	var no_of_cycle = parseInt(formObj.no_of_cycle.value);
	var repeat_value = parseInt(formObj.repeat_value.value)

	var alert_flag = false;
	if(repeat_value>1){
	for(k=0;k<no_of_cycle;k++){
		prev_admin_time = eval("formObj.time_"+k+"_"+0).value;
		for(j=1;j<repeat_value;j++){
		next_admin_time = eval("formObj.time_"+k+"_"+j).value;
		if(compareTime(prev_admin_time,next_admin_time)){
			alert_flag = true;
		}
		
		
		if(alert_flag ==true)
			break;
		}
		if(alert_flag == true)
			break;
	}
	}
	
	return alert_flag;
}

function compareTime(time1,time2){//if time1 > time2  true or else false
	var t1 = time1.replace(":",".");
	var t2 = time2.replace(":",".");
	return parseFloat(t1) >= parseFloat(t2);
}

function windowReturn(start_date,end_date){
	//alert("start_date==>"+start_date+"==end_date==>"+end_date);
//window.returnValue = start_date+'|'+end_date;
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = start_date+'|'+end_date;
    
    
//window.close();
}
function timeChk(time1){

var time = time1.value;

var	retFlag = true ;

if(time == "" || time ==null){
var	msg = getMessage("CAN_NOT_BE_BLANK","Common");//ML-MMOH-CRF-1004 - start
	msg = msg.replace('$', getLabel("Common.time.label","Common"));
	alert(msg);

	time1.focus();
	return false;//ML-MMOH-CRF-1004 - end

}

if(!chkTime(time))
	retFlag = false	;

if(!retFlag){
	time1.value="";	
	time1.focus();
	alert(getMessage("INVALID_TIME_FMT","SM")); 
}

}
//ML-MMOH-CRF-0345 - end
//ML-MMOH-CRF-1004 - start
function assignValueSchFreq(obj,rowNum){

	frmObj = document.onCologyCycleScheduleFreq;
	var no_of_cyle = parseInt(frmObj.no_of_cycle.value);
	if(obj.checked ==true){
		obj.value="Y";
	}else{
		obj.value="N";
		var check_flag = false
		for(var i=0; i<no_of_cyle; i++){
			
			if(eval("frmObj.cycle_checked_yn_"+i).checked==true){	
				check_flag = true;
				break;
			}
		
		}

		if(check_flag==false){
			alert(getMessage("PH_ATLEAST_ONE_SELECTED", "PH"));
			eval("frmObj.cycle_checked_yn_"+rowNum).checked = true;
			eval("frmObj.cycle_checked_yn_"+rowNum).value = "Y";
			return false;
		}
	}
}//ML-MMOH-CRF-1004 - end
function assignMfrValueforOngo(obj,call)
{

    var formObj				    = document.oncologyRegimenFluidDetail;
    var adminObj			    = parent.oncology_admin.oncologyRegimenAdminDetail;
	var bean_id                 = adminObj.bean_id.value;
	var bean_name               = adminObj.bean_name.value;
    var	Def_freq_code           = adminObj.Def_freq_code.value;
	var order_type_flag         = adminObj.order_type_flag.value;
	var amend_yn                = adminObj.amend_yn.value;
	var def_durn_type           = adminObj.def_durn_type.value;  
	var def_durn_value          = adminObj.def_durn_value.value;  
	var drug_code				= adminObj.drug_code.value;  //added ML-MMOH-CRF-1014 ICN-66762
	var srl_no					=  adminObj.srlNo.value;//added ML-MMOH-CRF-1014 ICN-66762

	var fluid_code              = "";

	if(obj.checked == true) 
	{
		
				obj.value = "Y";
				formObj.DfltVolume.disabled                       = true;

				//adminObj.Frequency_lbl.style.visibility           = "hidden";
				//adminObj.frequency_selection.style.visibility     ="hidden";
				adminObj.durn_mand.style.visibility				 ="hidden";
				adminObj.freq_mand.style.visibility				 ="hidden";
				adminObj.inf_rate_mand.style.visibility			 ="hidden";
				adminObj.start_date_mand.style.visibility		 ="hidden";

			var len = adminObj.frequency.options.length;
			for(var i=0;i<len;i++){ 
				if(adminObj.frequency.options[i].value == "")
				{

				    adminObj.frequency.selectedIndex = i;
					adminObj.frequency.disabled= true;
				}
			} 

				if(adminObj.dosage_label_cycle!=undefined){
					adminObj.dosage_label_cycle.style.visibility     ="hidden";
				}
				adminObj.mfr_yn_value.value						  = "Y"; 
				adminObj.durn_value.value						  = "";
				adminObj.durn_unit.value						  = "";
				adminObj.durn_value.disabled                      = true;
				adminObj.durn_unit.disabled                       = true;
				adminObj.duration_lbl.disabled                    = true;
				adminObj.StartDateLbl.disabled                    = true;
				adminObj.start_date.disabled                      = true;
				adminObj.end_date_lbl.disabled                    = true;
				adminObj.infusion_period_value.value			  = "";
				adminObj.infusion_period_value.value				  = "";
				adminObj.infusion_rate.value					  = "";
				adminObj.InfusionRate.disabled                    = true;
				adminObj.InfusionOver.disabled                    = true;
				adminObj.adMixture.disabled                       = true;
				adminObj.Calendar.disabled                        = true;
				adminObj.infuse_over_str.innerHTML				  = "[24 Hrs 0 Mins]"; 
				adminObj.btn_schedule_cycle.disabled				  = true;
			
		
		}else{
		    obj.value = "N";
			if(obj.value !="1"){
				formObj.DfltVolume.disabled                       = false;
				formObj.stock_value.disabled					  = false;
				formObj.stock_value.value						  = formObj.default_stock_val.value;
				adminObj.btn_schedule_cycle.disabled				  = false;
				adminObj.Frequency_lbl.style.visibility           = "visible";
				adminObj.frequency_selection.style.visibility     ="visible";
				if(adminObj.dosage_label_cycle!=undefined){
					adminObj.dosage_label_cycle.style.visibility     ="visible";
				}
				adminObj.Frequency_lbl.disabled                   = false;
				adminObj.frequency_selection.disabled             = false;
				adminObj.frequency.disabled							  = false;
				
				adminObj.durn_value.disabled                      = false;
				adminObj.duration_lbl.disabled                    = false;
				if(adminObj.freq_nature.value!="O"){  
					adminObj.StartDateLbl.disabled                    = false;
					adminObj.start_date.disabled                      = false;
				}
				adminObj.end_date_lbl.disabled                    = false;
				adminObj.InfusionRate.disabled                    = false;
				adminObj.InfusionOver.disabled                    = false;
				adminObj.adMixture.disabled                       = false;
				adminObj.Calendar.disabled                        = false;
				adminObj.durn_unit.disabled                       = false;
				adminObj.durn_value.value = adminObj.def_durn_value.value; 
				    //  
				adminObj.durn_mand.style.visibility				 ="visible";
				adminObj.freq_mand.style.visibility				 ="visible";
				adminObj.inf_rate_mand.style.visibility			 ="visible";
				adminObj.start_date_mand.style.visibility		 ="visible";
				

			if(formObj.MFR_YN_chk !=null && formObj.MFR_YN_chk.checked) 
				formObj.MFR_YN_chk.click(); 

			var len = adminObj.frequency.options.length;
			
			for(var i=0;i<len;i++){ 
				if(adminObj.frequency.options[i].value == Def_freq_code)
				{

				    adminObj.frequency.selectedIndex = i;
					
				}
			} 

			var durn_unit_len = adminObj.durn_unit.options.length;   

			for(var i=0;i<durn_unit_len;i++){ 
				if(adminObj.durn_unit.options[i].value == def_durn_type)
				{
				    adminObj.durn_unit.selectedIndex = i;
					break;
					
				}
			}
			adminObj.disp_durn_type.value=def_durn_type; 
			document.getElementById('MFR_Indicator').src="../../eCommon/images/disabled.gif";
			document.getElementById('mfrRemarksLink').style.visibility ="hidden";
			formObj.MFR_YN_chk.disabled = true;//added ML-MMOH-CRF-1014
            if(adminObj.infusion_rate.value ==""){

		  }else{    
		  
			  setInfuseOverValueNew();
		  }	
		  setSchedule(); 
      }
	  	    var bean_id				    = adminObj.bean_id.value;
	        var bean_name			    = adminObj.bean_name.value;
		    var qryString	= bean_id+"&bean_name="+bean_name+"&validate=MFR_RECS_CLEAR&MFR_YN=N&drug_code="+drug_code+"&srl_no="+srl_no;//added ML-MMOH-CRF-1014 ICN-66762
		    submitXML(qryString, "");

	}
         
}


function setInfuseOverValueNew(){
	var frmAdminObj=parent.oncology_admin.oncologyRegimenAdminDetail;
	var frmObj = parent.oncology_fluid.document.oncologyRegimenFluidDetail;
	var drugformObj		=parent.f_oncology_sub_drugs.onCologyRegimenDrugDetails;
	var volume = null;

	if(frmObj.stock_value != undefined)
		 volume		   = parseFloat(frmObj.stock_value.value); 
	else
		volume = parseFloat(drugformObj.totalDose.value);
	if(frmAdminObj.infusion_rate.value !=""){
		var infusion_value = frmAdminObj.infusion_rate.value;
		var unit = 	frmAdminObj.infusion_period_uom.value;
		if(infusion_value!="" && parseFloat(infusion_value)!=0) {
			if(unit == "H"){
				infusion_value = parseFloat(volume) * 60/parseFloat(infusion_value);
			}
			else{
				infusion_value = parseFloat(volume)/parseFloat(infusion_value);
			}
			infusion_value = infusion_value/60;
			infusion_value = Math.round(infusion_value*100)/100;
			infusion_value =  (infusion_value*100)/100; // rounding causing problem in the qty calculation
			HrsMinStr = getHrsMinStr(infusion_value,frmAdminObj.infusion_period_uom.value);
			frmAdminObj.infusion_over_insert_value.value = infusion_value;
			frmAdminObj.infuse_over_str.innerHTML	= HrsMinStr;
			hrs = HrsMinStr.substring(1,HrsMinStr.indexOf("H")-1);
			min = HrsMinStr.substring(HrsMinStr.indexOf("H")+4,HrsMinStr.indexOf("M")-1);
			frmAdminObj.infusion_period_value.value = Math.floor(hrs);
			frmAdminObj.infusion_period_value_mi.value = Math.round(min);
			}else{
			alert(getMessage("PRES_IV_INF_RATE_NOT_BLANK","PH"));
		}

	}

}

 async function showMultipleFlowRate(patient_id,encounter_id,mode,amend_fluid_code,drug_code){
	 
		var formObj		    = document.oncologyRegimenFluidDetail;
		var adminObj	    = parent.oncology_admin.oncologyRegimenAdminDetail;
		var volume			= formObj.stock_value.value;
		var base_volume		= volume; 
		
		var stock_uom_code	= formObj.stock_uom_val.value;
		var fluid = "";
			fluid			= formObj.fluid_code.value;

		if(fluid =="")
			 fluid = amend_fluid_code;
		var inf_rate		= "";
		var inf_over_hr		= "";
		var inf_over_min	= "";
		var start_date		= "";
		var end_date		= "";
		var InfRateHrMin	= "";
		var infusion_over_insert_value = "";
		
		var ocurrance_num = adminObj.ocurrance_num.value;
	    if(fluid != ""){
		   if(mode != 'amend'){

			 inf_rate		= adminObj.infusion_rate.value;
			 inf_over_hr	= adminObj.infusion_period_value.value;
			 //inf_over_min	= adminObj.infusion_period_value_mi.value;
			 inf_over_min = 0;
			 start_date		= adminObj.start_date.value;
			 end_date		= adminObj.end_date.value;
			 InfRateHrMin	= adminObj.infusion_period_uom.value;
			 infusion_over_insert_value = adminObj.infusion_over_insert_value.value;
			 header_form		= parent.parent.parent.f_header.document.prescription_header_form;
		 }else{
			 header_form	= parent.parent.f_header.document.prescription_header_form;
		 }
		 var height			= header_form.height.value;
		 var weight			= header_form.weight.value;
		 var bean_id			= adminObj.bean_id.value;
		 var bean_name		= adminObj.bean_name.value

		 var dialogTop		= "";
		 var dialogHeight	= "50vh";
		 var dialogWidth		= "80vw";
		 var dialogLeft		= "30";
		 var features		= "Width:" + dialogWidth + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogLeft:" + dialogLeft +"; dialogTop:" + dialogTop +"; scroll=auto; status=no";
		 var arguments		= "";

		if(inf_over_hr==null || inf_over_hr=="")
			inf_over_hr = 1;
		if(inf_over_min==null || inf_over_min=="")
			inf_over_min = 00;

		 var retVal 			= await top.window.showModalDialog("../jsp/OncologyRegimenMFR.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&height="+height+"&weight="+weight+"&volume="+volume+"&inf_rate="+inf_rate+"&inf_over_hr="+inf_over_hr+"&inf_over_min="+inf_over_min+"&start_date="+start_date+"&end_date="+end_date+"&stock_uom_code="+stock_uom_code+"&InfRateHrMin="+InfRateHrMin+"&ivType=ivd"+"&mode="+mode+"&infusion_over_insert_value="+infusion_over_insert_value+"&bean_id="+bean_id+"&bean_name="+bean_name+"&base_volume="+base_volume+"&drug_code="+drug_code+"&ocurrance_num="+ocurrance_num,arguments,features);
		
		if( retVal != undefined && retVal[1] > 1){
				if(mode != 'amend'){
					document.getElementById('MFR_Indicator').src="../../eCommon/images/enabled.gif";
					document.getElementById('mfrRemarksLink').style.visibility="visible"; //SetadminrateValue(bean_id,bean_name,adminObj.infusion_rate.value,adminObj.infusion_period_value.value); 
					adminObj.infusion_rate.value = "";
					adminObj.infusion_period_value.value = "";
					
					formObj.stock_value.value = retVal[0]; 
					document.getElementById('MFR_YN_chk').disabled = false;

					adminObj.start_date.disabled=true;
					adminObj.Calendar.disabled=true;
					adminObj.end_date.disabled=true;
					adminObj.start_date.value=retVal[2];
					adminObj.end_date.value=retVal[3];


                if(document.getElementById('MFR_YN_chk').checked != true)
				   document.getElementById('MFR_YN_chk').click();
			}
			
		}
  }
}
function getDefaultMFRvalue(bean_id,bean_name,order_id,drug_code,ocurrance_num){
	var adminObj	    = parent.oncology_admin.oncologyRegimenAdminDetail;
//	var srlNo			= adminObj.ocurrance_num.value; 
		var srlNo		= ocurrance_num;
	//alert("srlNo==>"+srlNo);
	  var qryString	= bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&drug_code="+drug_code+"&validate=DEFAULT_MFR_AT_LOADING"+"&srlNo="+srlNo;
	  submitXML(qryString, "");

 }

async function showMFRRemarks(drug_code)
{

	var frmObj	= document.oncologyRegimenFluidDetail;
	var adminObj	    = parent.oncology_admin.oncologyRegimenAdminDetail;
	var ocurrance_num   = adminObj.ocurrance_num.value; 
	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value;
	var mfr_remarks=frmObj.mfr_remarks.value;
	var dialogTop		= "";
	var dialogHeight	= "50vh";
	var dialogWidth		= "70vw";
	var dialogLeft		= "";
	var features		= "Width:" + dialogWidth + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogLeft:" + dialogLeft +"; dialogTop:" + dialogTop +"; scroll=NO; status=no";
	var arguments		= "";
	var retVal 			= await top.window.showModalDialog("../jsp/OncologyRegimenMFRRemarks.jsp?mfr_remarks="+mfr_remarks+"&bean_id="+bean_id+"&bean_name="+bean_name+"&drug_code="+drug_code+"&ocurrance_num="+ocurrance_num,arguments,features);		
	if(retVal != undefined )
	{		
		//alert("retVal[0]==>"+retVal[0]);
		frmObj.mfr_remarks.value= retVal[0];		
	}
}
function callCheckMaxLen(obj,noOfChars,Legend){	
	if(trimCheck(obj.value)==""){
		return false;
	}
	if(obj.value.length > noOfChars) {
        alert("APP-SM0045 - " + Legend + " "+getLabel("ePH.Cannotexceed.label",'PH')+" " + noOfChars  + getLabel("ePH.characters.label",'PH')) ;
		obj.focus();
	}else{		
		return true;
	}
}
function savedetails(bean_id,bean_name,drug_code,srlNo)
   {
		var frmobjRem=document.ongoIVPrescriptionMFRRemarks;
		var rem=frmobjRem.mfr_remarks.value;
		if(rem!="")
		rem=encodeURIComponent(rem,"UTF-8");
		var qryString=bean_id+"&bean_name="+bean_name+"&validate=SAVE_MFR_REMARKS&mfr_remark="+rem+"&drug_code="+drug_code+"&srlNo="+srlNo; 
		submitXML(qryString, "");
		//window.close();
		
	    
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();  
   }
   //Added for IN:070451 start
function saveWtBsa(){
  var frmObj	= document.onCologyRegimenDrugDetails;
	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value;
	var bsa=parent.parent.parent.f_header.prescription_header_form.bsa.value;;
	var weight=parent.parent.parent.f_header.prescription_header_form.weight.value;;
  if( (bsa!="") && (weight!="") ){
	  //commented by Anbarasi
   // var xmlDoc		= new ActiveXObject("Microsoft.XMLDom");
		//var xmlHttp		= new ActiveXObject("Microsoft.XMLHTTP");
var xmlDoc = ""; 
var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", "OncologyRegimenValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&bsa="+bsa+"&validate=setWtBsa&weight="+weight, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
}
	else {
		document.prescription_header_form.bsa.value	=	"";
		document.prescription_header_form.bmi.value	=	"";
		document.getElementById("bsa_lbl").innerHTML	=	"";
		document.getElementById("bmi_lbl").innerHTML	=	"";
	}
}
function getLimiInd(){
	var frmObj 				= parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails;
	var headerForm			= parent.parent.parent.f_header.document.prescription_header_form;
	var frmAdminObj 		= parent.oncology_admin.document.oncologyRegimenAdminDetail;
	var drug_frmobj		    =  parent.f_oncology_sub_drugs.onCologyRegimenDrugDetails;
	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value;
	var temp_qty ="";
	var qty_value = frmObj.totalDose.value;
  var dosage_type			=	drug_frmobj.dosage_type.value;	
	var drug_code			= drug_frmobj.drug_code.value;

	 if(headerForm.height.value.length > 0 && headerForm.weight.value.length > 0){
		 if(frmObj.calc_by_ind!=undefined){ 
			 if(frmObj.calc_by_ind.value=="W") {
				temp_qty	=	(parseFloat(qty_value)/parseFloat(headerForm.weight.value));
			}
			else if(frmObj.calc_by_ind.value=="B") {
				temp_qty	=	(parseFloat(qty_value)/parseFloat(headerForm.bsa.value));
				
		   }else
			 temp_qty=qty_value;
		 }else
			 temp_qty=qty_value;
	 }

	 if(temp_qty=="") 
		 temp_qty = qty_value;
	 repeat_value=  frmAdminObj.repeat_value.value;
	    var xmlStr 			="<root><SEARCH /></root>";
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../ePH/jsp/OncologyRegimenValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&temp_qty=" + temp_qty + "&repeat_value=" + repeat_value +"&dosage_type=" + dosage_type + "&drug_code=" + drug_code + "&validate=LMITIND", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
  	eval(responseText);
	
}
//Added for IN:070451 end
//Added for IN:072715 START
function checkOverrideRemarks(reason_code,trn_type,frmObj,frmObj1,field){
	
	var reason_code=reason_code.value;
	if(reason_code==""){
		frmObj1.value="";
		frmObj1.readOnly = true;
	}
	else if(reason_code=="OTHR"){
		frmObj1.value="";
		frmObj1.readOnly = false;
	}
	else{
		bean_id		=	frmObj.bean_id.value;
		bean_name	=	frmObj.bean_name.value;
		var xmlDoc	= "";
		var xmlHttp	= new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "reason_code  =\"" + reason_code + "\" " ;
		xmlStr+= "trn_type =\"" + trn_type + "\" " ;
		xmlStr+= "field =\"" + field + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="OncologyRegimenValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=override_remarks";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);

	}
	
}
//Added for IN:072715 end
//Added for IN:069887  start
function showOverideMandAlert(allergy_remarks_yn, dup_remarks_yn, dose_remarks_yn){
	
	
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
//Added for IN:069887  end
