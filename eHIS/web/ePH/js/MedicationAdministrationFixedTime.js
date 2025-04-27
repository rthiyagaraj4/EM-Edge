/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
03/01/2018	IN065749		  Dinesh T	      01/02/2017	Ramesh G		EM run on window 10 and IE 11
																	                                Vaccine course display schedule before select, displayed wrong icon symbol, unscheduled displayed in pending Rx for MAR
10/07/2020      IN073378  Haribabu                                             MMS-DM-SCF-0705
31/8/2020	      IN073827	Shazana									                MMS-DM-CRF-0174.4/03- Enter Valid or Invalid Barcode no response from system																																
08/10/2020  	IN074068        	Manickavasagam J                                    SKR-SCF-1431
20/11/2020      7862      Shazana                                 SKR-SCF-1468
05/07/2021  	TFS:20163        	Manickavasagam J                                    ML-MMOH-SCF-1834
26/08/2021  	TFS:22145        	Manickavasagam J                                    ML-MMOH-SCF-1876
12/05/2023      TFS:43323           SREENADH           RAMESH.G                         NMC-JD-CRF-0186
11/10/2023       TFS:50766     Hariharan   12/10/2023  Ramesh Goli   GHL-SCF-1735
-------------------------------------------------------------------------------------------------------------------------------
*/

 //SRR20056-SCF-7371 IN027409 - Med admin for Iv when hold, resume with change flow rate then refresh page infusion period display incorrect.
//SRR20056-SCF-7402  IN27445 - Order dobutamine in nss from IV+drug (continuous ) then hold-resume and change  flowrate step change flow rate to 1.0 ml/min, Infusion period display NAN Hrs then can?t hold or complete drug (not reproduce)
var result     =   false ;
var message     =   "" ;
var flag        =   "" ;
 
function clearField(obj){ 
	obj.value="";
	obj.style.color="#330066";
}
async function pinAuthentication(obj,val){ 
	if(obj.checked && document.getElementById("userAuthPINYN").value!='Y'){	// Added for RUT-CRF-0035 [IN029926] - to suppress the drug level authentication
		if(val=="YP"){
			var return_val	=	false;
			var dialogHeight= "40vh" ;
			var dialogWidth	= "50vw" ;
			var dialogTop = "150" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			retVal = await window.showModalDialog("../../ePH/jsp/MedicationAdministrationAuthorize.jsp",arguments,features);
			if(retVal=="OK") {
				return_val	=	true;
			}
			else {
				obj.checked=false;
				return_val	=	false;
			}
		}
		else{					
			alert(getMessage("PIN_NOT_DEFINED_FOR_USER","PH"));
			obj.checked=false;
		}
	}
	
	
}
function validateAuthorization(from) {	
	var orig_user_pin	= document.frmDispMedicationAuthorize.orig_user_pin.value;
	var user_pin		= document.frmDispMedicationAuthorize.user_pin.value;
	if(from=="OK"){
		if(user_pin==""||user_pin==" "){		
			alert(getMessage("PIN_PWD_CANNOT_BE_BLANK","PH"));		
			document.frmDispMedicationAuthorize.user_pin.focus();
		}  
		else{
			if(orig_user_pin==user_pin){
				window.returnValue="OK";
				window.close();
			} 
			else {
				alert(getMessage("INVALID_PWD_PIN_NO","PH"));
				document.frmDispMedicationAuthorize.user_pin.focus();
			}
		}
	}
	else{
		window.close();
	}
	/*
	if(user_pin==""||user_pin==" ") 
	{		
		alert(getMessage("PIN_PWD_CANNOT_BE_BLANK","PH"));		
		document.frmDispMedicationAuthorize.user_pin.focus();

	}  
	else 
	{
		if(from=="OK") 
		{
			if(orig_user_pin==user_pin) 
			{
			window.returnValue="OK";
			window.close();
			} 
			else 
			{
				alert(getMessage("INVALID_PWD_PIN_NO","PH"));
				document.frmDispMedicationAuthorize.user_pin.focus();
			}
		} 
		else 
		{
			window.close();
		}
	}*/
}
function assignDisplayText(obj){
	if(obj.value == ""){
		if(obj.name=="patient_id"){
			obj.value=getLabel("ePH.EnterPatientIDTo.label",'PH');
		}
		else{
			obj.value="  "+getLabel("ePH.EnterBedNoto.label",'PH');
		}
		obj.style.color="red";
	}
}	


function expand(mode){
	var formDetailObj = parent.f_bedheader.MedicationAdministrationBedPatientHeader;
	var call_from_ca    =  formDetailObj.call_from_ca.value;
	var option_id    =  formDetailObj.option_id.value;

	parent.f_bedheader.document.getElementById("pat_links").style.display="none";
	tot_rec	=parent.f_bedheader.document.getElementById('patient_header_table').rows.length;
    if(parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.btnPrint!=undefined) // Added for GHL-CRF-0458 - Start
    	parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.btnPrint.style.visibility="hidden"; // Added for GHL-CRF-0458 - End
	for(i=1; i<(tot_rec-1); i++){
		//eval("parent.f_bedheader.MedicationAdministrationBedPatientHeader.tr_"+i+".style='display'");
		//eval("parent.f_bedheader.MedicationAdministrationBedPatientHeader.tr_"+i+".style.visibility='visible'");
		parent.f_bedheader.document.getElementById('tr_'+ i).style='display';  
		parent.f_bedheader.document.getElementById('tr_'+ i).style.visibility = 'visible';
		var formObj =parent.f_bedheader.document.getElementById('patient_header_table').rows[i];
		for(var k=0;k<formObj.cells.length;k++){
			formObj.cells[k].style.backgroundColor="";
		}		
		formObj.cells[1].style.color="blue";
		formObj.cells[1].style.cursor="hand";
	}

	if(mode!="NOTIME"){
		//parent.parent.MedicationAdministrationFixedTimeFrameSet.rows="15%,0%,0%,0%";
		parent.parent.document.getElementById("f_patient_details").style.height="19vh";
		parent.parent.document.getElementById("f_admin_chart").style.height="0vh";
		parent.parent.document.getElementById("f_admin_new_entry").style.height="0vh";
		parent.parent.document.getElementById("f_admin_button").style.height="0vh";
		if(call_from_ca==""||option_id=='PH_MAR_DESKTOP'){
		  // parent.f_patient_detail_frameset.rows="4%,65%";
			parent.document.getElementById("f_bed_patient").style.height="24vh";
			parent.document.getElementById("f_bedheader").style.height="70vh";
		}
		parent.f_bedheader.scrolling="auto";		
	}
	else{
		parent.parent.AdminDetailFrameSet.rows="22,0,0,0";
        if(call_from_ca==""||option_id=='PH_MAR_DESKTOP'){			
		   parent.f_patient_detail_frameset.rows="4%,65%";
		}
	}
	if(parent.f_bed_patient.MedicationAdministrationFTLocator != null){	
		parent.f_bed_patient.MedicationAdministrationFTLocator.btImg.style.display="none";
	}
	return false;
}

function collapse(rec,mode, MAR_sch_level_yn){
	var formDetailObj =  parent.f_bedheader.MedicationAdministrationBedPatientHeader;
	var call_from_ca  =  formDetailObj.call_from_ca.value;
	var option_id     =  formDetailObj.option_id.value;
	if(parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.btnPrint!=undefined ){ // Added for GHL-CRF-0458 - Start
    	parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.btnPrint.style.visibility="visible";  
    	if(formDetailObj != null){
    		parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.patient_id1.value =formDetailObj.patient_id.value;
    		parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.encounter_id1.value =formDetailObj.encounter_id.value;
    	}
	} // Added for GHL-CRF-0458 - End
	if(formDetailObj != null){
		parent.f_bedheader.document.getElementById('selected_patient_id_row').value=rec;
		tot_rec	=	parent.f_bedheader.document.getElementById('patient_header_table').rows.length;		
		for(i=1; i<tot_rec; i++){
			if(i!=rec){
				//eval("formDetailObj.tr_"+i+".style.display='none'");
			}
			else{
				var formObj = parent.f_bedheader.document.getElementById('patient_header_table').rows[i];
				for(var k=0;k<formObj.cells.length;k++){
					formObj.cells[k].style.backgroundColor="#fde6d0";				
				}
				formObj.cells[1].style.color="black";
				formObj.cells[1].style.cursor="auto";
			}	
		}
	}
	if(mode != "NOTIME"){
        if(call_from_ca==""||option_id=='PH_MAR_DESKTOP'){
			if(MAR_sch_level_yn!='Y'){
				//parent.f_patient_detail_frameset.rows="24%,*";
				parent.document.getElementById("f_bed_patient").style.height="24vh";
				parent.document.getElementById("f_bedheader").style.height="70vh";
				//parent.parent.MedicationAdministrationFixedTimeFrameSet.rows="15%,*,0%,13%";
				parent.parent.document.getElementById("f_patient_details").style.height="19vh";
				parent.parent.document.getElementById("f_admin_chart").style.height="60vh";
				parent.parent.document.getElementById("f_admin_new_entry").style.height="0vh";
				parent.parent.document.getElementById("f_admin_button").style.height="13vh";
				
			}
			else
				//parent.parent.MedicationAdministrationFixedTimeFrameSet.rows="15%,*,0%,11%";
			    parent.parent.document.getElementById("f_patient_details").style.height="19vh";
				parent.parent.document.getElementById("f_admin_chart").style.height="62vh";
				parent.parent.document.getElementById("f_admin_new_entry").style.height="0vh";
				parent.parent.document.getElementById("f_admin_button").style.height="16vh";
		}
		else{
			//parent.parent.MedicationAdministrationFixedTimeFrameSet.rows="15%,*,0%,13%";
			    parent.document.getElementById("f_bed_patient").style.display="none";
			    //parent.document.getElementById("f_bedheader").style.height="68vh";
			    parent.parent.document.getElementById("f_patient_details").style.height="20vh";
				parent.parent.document.getElementById("f_admin_chart").style.height="63vh";
				parent.parent.document.getElementById("f_admin_new_entry").style.height="0vh";
				parent.parent.document.getElementById("f_admin_button").style.height="13vh";
		}
		if(parent.f_bed_patient.MedicationAdministrationFTLocator != null &&parent.f_bed_patient.document.getElementById('btImg') != null){
			parent.f_bed_patient.document.getElementById('btImg').style='display';
			parent.f_bed_patient.document.getElementById('btImg').style.visibility="visible";
		}
		parent.f_bedheader.scrolling="no";
	}
	else {
        if(call_from_ca==""||option_id=='PH_MAR_DESKTOP'){
			if(MAR_sch_level_yn!='Y')
				//parent.f_patient_detail_frameset.rows="20%,65%";
			parent.document.getElementById("f_bed_patient").style.height="20vh";
			parent.document.getElementById("f_bedheader").style.height="65vh";
		}
		if(parent.f_bed_patient.MedicationAdministrationFTLocator != null){
			parent.f_bed_patient.document.getElementById('btImg').style='display';
			parent.f_bed_patient.document.getElementById('btImg').style.visibility="visible";
		}
	}
}

function locateBedNo(){

	var formLocateObj = parent.f_bed_patient.MedicationAdministrationFTLocator;
	var formDetailObj = parent.f_bedheader.MedicationAdministrationBedPatientHeader;
	var bed_no	=	formLocateObj.bed_no.value;
	var len		=   parent.f_bedheader.document.getElementById('patient_header_table').rows.length;
	var patientHeaderTable = parent.f_bedheader.document.getElementById('patient_header_table');
	for (var i=1;i<len ;i++ ){		
	  if(patientHeaderTable.rows[i].id.indexOf('tr_')==0){//Added for PH_GP004 BRUSIM Adhoc Testing	
		  if (parent.f_bedheader.document.getElementById('bed_no_' + i).innerText.trim().toUpperCase() === bed_no.trim().toUpperCase())
		  {						
			for(var j=1;j<len ;j++){
				patientHeaderTable.rows[j].style.display="none";
			}
			var formObj = patientHeaderTable.rows[i];
			for(var k=0;k<formObj.cells.length;k++){
					formObj.cells[k].style.backgroundColor="#fde6d0";
			}
			patientHeaderTable.rows[i].style="display";
			patientHeaderTable.rows[i].style.visibility="visible";			
			/*if(formLocateObj != null){
				formLocateObj.btImg.style.display="inline";
				formLocateObj.btImg.style.visibility="visible";
			}*/
			parent.f_bedheader.document.getElementById('patient_id_'+i).click();
			//formDetailObj.selected_patient_id.value=i;
			//alert(formLocateObj.bed_no.value);
			formLocateObj.bed_no.value ="   "+getLabel("ePH.EnterBedNoto.label",'PH');
			formLocateObj.bed_no.style.color="red";
			return false;
		}
	}
	}
	formLocateObj.patient_id.value = getLabel("ePH.EnterPatientIDTo.label",'PH');
	formLocateObj.patient_id.style.color="red";
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));
}

function locatePatientID(){
	var formLocateObj = parent.f_bed_patient.MedicationAdministrationFTLocator;
	var formDetailObj = parent.f_bedheader.MedicationAdministrationBedPatientHeader;
	var patient_id	=	formLocateObj.patient_id.value;
	var patient_header_table=parent.f_bedheader.document.getElementById('patient_header_table');
	var len		=  patient_header_table.rows.length;
	var patient_header_table = parent.f_bedheader.document.getElementById('patient_header_table');

	for (var i=1;i<len ;i++ ){
	  if(eval("patient_header_table.rows["+i+"].id.indexOf('tr_')==0")){//Added for PH_GP004 BRUSIM Adhoc Testing
	//	if (eval("formDetailObj.patient_id_"+i).innerText==trimString(patient_id)){
		  if (parent.f_bedheader.document.getElementById('patient_id_' + i).innerText == trimString(patient_id)){
			for(var j=1;j<len ;j++){
				patient_header_table.rows[j].style.display="none";

			}			
			var formObj =patient_header_table.rows[i];
			for(var k=0;k<formObj.cells.length;k++){
					formObj.cells[k].style.backgroundColor="#fde6d0";
			}
			patient_header_table.rows[i].style='display';
			patient_header_table.rows[i].style.visibility="visible";
			/*if(formLocateObj != null){
				formLocateObj.btImg.style.display="inline";
				formLocateObj.btImg.style.visibility="visible";
			}*/			
			eval(parent.f_bedheader.document.getElementById('patient_id_' + i)).click();
		
			//formDetailObj.selected_patient_id.value=i;
			formLocateObj.patient_id.value = getLabel("ePH.EnterPatientIDTo.label",'PH');
			formLocateObj.patient_id.style.color="red";
			return false;
		}
		}
	}
	formLocateObj.patient_id.value = getLabel("ePH.EnterPatientIDTo.label",'PH');
	formLocateObj.patient_id.style.color="red";
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));
}

function getDrugDetails(encounter_id,selected_row,assign_bed_num,nursing_unit,hold_discontinue_yn,from_time,to_time,admin_from_date,admin_to_date,administration_status,order_type,patient_id,display_order_by,called_form,route_admin,admin_route_categ,allergic_yn){
//,allergic_yn  added in getDrugDetails() method call fpr SKR-CRF-010

	//parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	if(route_admin=='undefined')
		 route_admin="";
	var MAR_sch_level_yn = document.MedicationAdministrationBedPatientHeader.MAR_sch_level_yn.value;
	//var formDetailObj = parent.f_bedheader.MedicationAdministrationBedPatientHeader.all;
	var formDetailObj = parent.f_bedheader.MedicationAdministrationBedPatientHeader;
	formDetailObj.patient_id.value =patient_id; //Added for  AAKH-SCF-0201 [IN:055223]
	formDetailObj.encounter_id.value =encounter_id;  //Added for  AAKH-SCF-0201 [IN:055223]
	for(i=1; i<parseInt(formDetailObj.tot_rec.value); i++) {
		if(i!=parseInt(selected_row)) {
			//eval("formDetailObj.tr_"+i+".style.display='none'");	
			parent.f_bedheader.document.getElementById('tr_' + i).style.display = 'none';			
		}
	}
	formDetailObj.selected_patient_id_row.value = selected_row;
	formDetailObj.pat_id_link.value	=	patient_id;
	if(MAR_sch_level_yn=='Y'){
		var viewBy = parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.viewBy.value;
		var patient_class = parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.patient_class.value;
		var mar_disc_dose_yn = parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.mar_disc_dose_yn.value;
		var mar_iv_compl_dt_ind = parent.parent.parent.f_search.document.MedicationAdministrationSearchForm.mar_iv_compl_dt_ind.value;
		if(viewBy=='W')
			parent.parent.f_admin_chart.location.href="../../ePH/jsp/MARSchLevelDrugDetails.jsp?hold_discontinue_yn="+hold_discontinue_yn+"&encounter_id="+encounter_id+"&from_time="+from_time+"&to_time="+to_time+"&assign_bed_num="+assign_bed_num+"&nursing_unit="+nursing_unit+"&administration_status="+administration_status+"&order_type="+order_type+"&patient_id="+patient_id+"&function_from="+called_form+"&display_order_by="+display_order_by+"&route_admin="+route_admin+"&admin_route_categ="+admin_route_categ+"&patient_class="+patient_class+"&mar_disc_dose_yn="+mar_disc_dose_yn+"&mar_iv_compl_dt_ind="+mar_iv_compl_dt_ind;
		else
			parent.parent.f_admin_chart.location.href="../../ePH/jsp/MARSchLevelDrugDetailsMonthly.jsp?hold_discontinue_yn="+hold_discontinue_yn+"&encounter_id="+encounter_id+"&from_time="+from_time+"&to_time="+to_time+"&assign_bed_num="+assign_bed_num+"&nursing_unit="+nursing_unit+"&administration_status="+administration_status+"&order_type="+order_type+"&patient_id="+patient_id+"&function_from="+called_form+"&display_order_by="+display_order_by+"&route_admin="+route_admin+"&admin_route_categ="+admin_route_categ+"&patient_class="+patient_class;
		parent.parent.f_admin_button.location.href="../../ePH/jsp/MedicationAdministrationFTButtons.jsp?alternate_drug=Y&patient_id="+patient_id+"&encounter_id="+encounter_id+"&nursing_unit="+nursing_unit+"&admin_to_date="+admin_to_date+"&MAR_sch_level_yn="+MAR_sch_level_yn+"&patient_class="+patient_class;
	}
	else{
		parent.f_bedheader.document.getElementById("pat_links").style='display';
		if(allergic_yn=='Y')//getting allergy existence detail - SKR-CRF-010
			parent.f_bedheader.document.getElementById("lblkwncaseAlgy").style='display';
		else
			parent.f_bedheader.document.getElementById("lblkwncaseAlgy").style.display="none";
		parent.parent.f_admin_chart.location.href="../../ePH/jsp/MedicationAdministrationFTDrugDtls.jsp?hold_discontinue_yn="+hold_discontinue_yn+"&admin_from_date="+admin_from_date+"&encounter_id="+encounter_id+"&from_time="+from_time+"&to_time="+to_time+"&assign_bed_num="+assign_bed_num+"&nursing_unit="+nursing_unit+"&administration_status="+administration_status+"&admin_to_date="+admin_to_date+"&order_type="+order_type+"&patient_id="+patient_id+"&function_from="+called_form+"&display_order_by="+display_order_by+"&route_admin="+route_admin+"&admin_route_categ="+admin_route_categ;

		parent.parent.f_admin_button.location.href="../../ePH/jsp/MedicationAdministrationFTButtons.jsp?alternate_drug=Y&patient_id="+patient_id+"&encounter_id="+encounter_id+"&nursing_unit="+nursing_unit+"&admin_to_date="+admin_to_date;
		//parent.parent.f_medn_admin_view.location.href	="../../ePH/jsp/MedicationAdministrationViewMAR.jsp?patient_id="+patient_id+"&nursing_unit="+nursing_unit+"&admin_to_time="+admin_to_date;
	}
}

async function enterRemarks(drug_name,drug_class,row_no,drug_code,mode,drugtype,mo,freq_code,dosage_seq,no_of_doses,order_id,order_line_num,encounter_id,medn_admn_dtl_reqd_yn,iv_prep_yn,admn_dose_chng_yn_obj,MfrYN,sch_date_time, admin_date_time, adminChk, assign_bed_num, nursing_unit, scheKey, administered, admin_recorded_yn, admin_discontinue,enter_remk_verify){
	var batch_disable =''; // Added for AAKH-CRF-0084 [IN060429] - Start
	var fromAdmin="";//added for mms-kh-crf-0010
	var mandCheck = "N";//added for 7862
	if(enter_remk_verify != 'Y'){//Added for AAKH-SCF-0296 IN062053

	if(document.MedicationAdministrationFTDrugDetails.verify_adm_drug!=undefined && document.MedicationAdministrationFTDrugDetails.verify_adm_drug.value=="true" ){//iv_prep_yn added for MMS-KH-CRF-0017    and iv_prep_yn!="0" && iv_prep_yn!="9" removed for MMS-KH-CRF-0017.1 and modified for MMS-KH-CRF-0017.1
		batch_disable = 'enabled';
		//eval(document.getElementById("pat_brought_med_"+row_no))!=undefined  and eval(document.getElementById("non_iv_shared_drug_"+row_no))!=undefined added for MMS-DM-SCF-441
		if(eval(document.getElementById("pat_brought_med_"+row_no))!=undefined && eval(document.getElementById("pat_brought_med_"+row_no)).checked || eval(document.getElementById("non_iv_shared_drug_"+row_no))!=undefined && eval(document.getElementById("non_iv_shared_drug_"+row_no)).checked){
	    batch_disable = 'disabled';
	    } 
	}
	}// Added for AAKH-CRF-0084 [IN060429] - End  Added for AAKH-SCF-0296  IN062053
	if(admin_discontinue==undefined)
		var admin_discontinue = 'N';
	if(admn_dose_chng_yn_obj!=undefined)
		var admn_dose_chng_yn = admn_dose_chng_yn_obj.value;
	else
		var admn_dose_chng_yn ="N"
	if(assign_bed_num ==undefined)
		assign_bed_num = "";
	if(drugtype ==undefined)
		drugtype = "";
	if(scheKey ==undefined)
		scheKey = "";

	var formObj		="";
	var doc_obj ;	
	drug_name = unescape(drug_name); 
	
	if(mode=="NOTIME"){
		formObj = parent.f_admin_detail.MedicationAdministrationFTDrugDetails;
		doc_obj	= parent.f_admin_detail.document;	
	}
	else if(mode=="CP"){
		formObj = document.MedicationAdministrationFTDrugDetails;
		doc_obj=document;
	}
	else if(mode=='SCH'){
		if(mo=='CNAD' )
			formObj = document.MedicationAdministrationSchLevelDrugDtls;
		else
			formObj = document.MedicationAdministrationFTDrugDetails;
		doc_obj=document;
	}
	else{
		formObj = parent.f_admin_chart.MedicationAdministrationFTDrugDetails;
		doc_obj	= parent.f_admin_chart.document;
	}
	var main_form	=	formObj;
	if(mode!='SCH'){
		if(drugtype=="IV"){
			if(mo == "A"){
				adminChk = eval("formObj.iv_chk_complete_"+row_no).checked;
			} 
			else{  
				adminChk = eval("formObj.iv_ch_comple_"+row_no).checked;
				document.MedicationAdministrationFTDrugDetails.admin_recorded.value="Y";
			}
		}
		else if(drugtype=="NEW"){
			var adminChk = eval("formObj.new_non_iv_chk_"+row_no).checked;
		}
		else{
			var adminChk = eval("formObj.non_iv_chk_"+row_no).checked
		}
	}

	var title = "";
	
	var auth_req_yn = "N";
	var dialogHeight= "50vh" ;
	if(medn_admn_dtl_reqd_yn=='Y'){
		auth_req_yn = "Y";		
	}
	else{
		dialogHeight= "50vh" ;
	}
	var couldNotAdmin ='N';
	if(adminChk==true || adminChk=='true'){
		fromAdmin="Y";//ADDED FOR FOR MMS-KH-CRF-0010
		
		title = encodeURIComponent(getLabel("ePH.AdministrationRemarks.label",'PH'));
	}
	else{
		 mandCheck = "Y";//modified for 7862
		title = encodeURIComponent(getLabel("ePH.ReasonfornotbeingAdministered.label",'PH'));
		couldNotAdmin = "Y";
	}

	var dialogWidth	= "50vw" ;
	var dialogTop = "15" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/MedicationAdministrationFTRemarks.jsp?title="+title+"&row_no="+row_no+"&mandCheck="+mandCheck+"&drug_code="+drug_code+"&auth_req_yn="+auth_req_yn+"&drug_name="+escape(drug_name)+"&drugtype="+drugtype+"&freq_code="+freq_code+"&dosage_seq="+dosage_seq+"&no_of_doses="+no_of_doses+"&order_id="+order_id+"&order_line_num="+order_line_num+"&encounter_id="+encounter_id+"&iv_prep_yn="+iv_prep_yn+"&admn_dose_chng_reason_yn="+admn_dose_chng_yn+"&MfrYN="+MfrYN+"&sch_date_time="+sch_date_time+"&admin_date_time="+admin_date_time+"&callFrom="+mode+"&assign_bed_num="+assign_bed_num+"&nursing_unit="+nursing_unit+"&scheKey="+scheKey+"&couldNotAdmin="+couldNotAdmin+"&administered="+administered+"&admin_recorded_yn="+admin_recorded_yn+"&admin_discontinue="+admin_discontinue+"&batch_disable="+batch_disable+"&fromAdmin="+fromAdmin,arguments,features); //added escale() for drug_name - to avoid spaces displaying as boxes --14/02/2011-- priya & sch_date_time & admin_date_time passed as query string added for SCF-7528 //AAKH-CRF-0024 [IN:038260] // batch_disable added for AAKH-CRF-0084 [IN060429]
	if(mode=='SCH' && retVal!=undefined ){
		// below flag indicates tht details are entered
		if(drugtype=="IV"){
			dtls_obj		=	eval("main_form.iv_dtls_yn"+row_no);
			dtls_obj.value	=	"Y";
			dtls_obj_remark	=	eval("main_form.iv_Remarks"+row_no);
			dtls_obj_remark.value	=	"Y";								
			eval("main_form.iv_end_date_"+row_no).value = retVal[0];
			main_form.iv_admin_remarks.value=retVal[1];
		} 
		else {
			dtls_obj		=	eval("main_form.non_iv_dtls_yn"+row_no);
			dtls_obj_remark	=	eval("main_form.Remarks"+row_no);
			dtls_obj.value	=	"Y";
			dtls_obj_remark.value	=	"Y";
			chng_reason_flag_obj = eval("main_form.non_iv_admin_chng_dtls_req_"+row_no);
			if(chng_reason_flag_obj!=undefined){
				if(chng_reason_flag_obj.value == "Y")
					chng_reason_flag_obj.value = "E";
			}

			if(eval("main_form.non_iv_scanned_batch_yn_"+row_no)!=undefined){ // if condition added for alpha reopen Issue MMS-DM-SCF-0458 - Start

			  //eval("main_form.non_iv_scanned_batch_yn_"+row_no) // commented for alpha reopen Issue MMS-DM-SCF-0458
			  eval("main_form.non_iv_scanned_batch_yn_"+row_no).value = "Y";//added for MMS-DM-SCF-0447
			} // if condition added for alpha reopen Issue MMS-DM-SCF-0458 - End
		}
		return retVal;
	}
		
	if(retVal!=null && retVal!="") {
		 if(retVal!="OK") {
			obj	=	eval("doc_obj.nxt_adm_"+row_no);
			if(obj!=null){
				dtls_obj_remark	=	eval("main_form.iv_Remarks"+row_no);
				dtls_obj_remark.value	=	"Y";
				obj.style='display';
				//obj.title	= getLabel("ePH.NextAdministrationDate/Time.label",'PH')+": "+retVal;
				eval("doc_obj.iv_end_date_"+row_no).value = retVal;
				if(eval("doc_obj.iv_end_date_"+eval(parseInt(row_no)+1))!=undefined)
				    eval("doc_obj.iv_end_date_"+eval(parseInt(row_no)+1)).value = retVal;
			}
		} 
		else {
			// below flag indicates tht details are entered
			if(drugtype=="IV"){
				dtls_obj		=	eval("main_form.iv_dtls_yn"+row_no);
				dtls_obj.value	=	"Y";
				dtls_obj_remark	=	eval("main_form.iv_Remarks"+row_no);
				dtls_obj_remark.value	=	"Y";
			} 
			else {
				dtls_obj		=	eval("main_form.non_iv_dtls_yn"+row_no);
				dtls_obj_remark	=	eval("main_form.Remarks"+row_no);
				dtls_obj.value	=	"Y";
				dtls_obj_remark.value	=	"Y";
				chng_reason_flag_obj = eval("main_form.non_iv_admin_chng_dtls_req_"+row_no);
				if(chng_reason_flag_obj!=undefined){
					if(chng_reason_flag_obj.value == "Y")
						chng_reason_flag_obj.value = "E";
				}
			}
		}
	}
	else {
		//Below Line Is Commented By The SureshKumar T For The Incident No :27444 [SCF No. SRR20056-SCF-7401] On 21/06/11
		/*obj	=	eval("doc_obj.nxt_adm_"+row_no);
		
		if(obj!=null) {
		obj.style.visibility =	"hidden";
		obj.style.display="none";
		}
		*/
		if(drugtype=="IV"){
			dtls_obj		=	eval("main_form.iv_dtls_yn"+row_no);
			dtls_obj.value	=	"N";
		} 
		else {
			dtls_obj		=	eval("main_form.non_iv_dtls_yn"+row_no);
			dtls_obj.value	=	"N";
		}
	}
}

async function saveRemarksForDrug(mand_check,row_no,drug_code,auth_req_yn,order_id,order_line_num, encounter_id,admn_dose_chng_reason_yn,batchid_disable,patient_id,act_patient_class,scan_count_required_yn,alert_required_yn,remarks_required_yn){ // batchid_disable added for AAKH-CRF-0084 [IN060429]patient_id,act_patient_class,scan_count_required_yn,alert_required_yn,remarks_required_yn added for MMS-DM-CRF-0170
	var formObj = document.MedicationAdministrationFTRemarks;
	var callFrom = document.MedicationAdministrationFTRemarks.callFrom.value;
	var nursing_unit = document.MedicationAdministrationFTRemarks.nursing_unit.value;
	var assign_bed_num = document.MedicationAdministrationFTRemarks.assign_bed_num.value;
	var sch_date_time = document.MedicationAdministrationFTRemarks.sch_date_time.value;
	var dosage_seq = document.MedicationAdministrationFTRemarks.dosage_seq.value;
	var scheKey = document.MedicationAdministrationFTRemarks.scheKey.value;
	var couldNotAdmin = document.MedicationAdministrationFTRemarks.couldNotAdmin.value;
	var admin_discontinue = document.MedicationAdministrationFTRemarks.admin_discontinue.value;
	//Adding start for MMS-DM-CRF-0157.1
	var bar_code_site_yn = document.MedicationAdministrationFTRemarks.bar_code_scan_site_YN.value;
	var reason_code_yn   = document.MedicationAdministrationFTRemarks.reason_code_yn.value; //ML-MMOH-SCF-1834

	var retval="";
	var entry_type ="";	//alert("bar_code_site_yn==="+bar_code_site_yn+"scan_count_required_yn=="+scan_count_required_yn+"patient_id==="+patient_id+"act_patient_class=="+act_patient_class+"alert_required_yn==="+alert_required_yn)
	 if(bar_code_site_yn=="Y" && scan_count_required_yn == 'Y' && document.MedicationAdministrationFTRemarks.bar_code_scaned_YN.value =="N" && alert_required_yn == 'Y'){
		 retval=callManualScanRemarks(encounter_id,patient_id,act_patient_class,remarks_required_yn);
	 }else if(bar_code_site_yn =="Y" && (document.MedicationAdministrationFTRemarks.bar_code_scaned_YN.value =="Y" ||   (scan_count_required_yn =='Y' && alert_required_yn == 'N'))  ){
		  if(document.MedicationAdministrationFTRemarks.bar_code_scaned_YN.value == 'Y' && scan_count_required_yn == 'Y')
				    entry_type = "S";
			 else
				    entry_type = "M";
	     retval= await scanBarcodeCount(encounter_id,patient_id,act_patient_class,entry_type);
	 }
	 if(retval!=undefined){//Adding end for MMS-DM-CRF-0157.1
	var fields  = new Array() ;
	var names   = new Array() ;
	var index=0;
	var batchId = "";	 // Added for AAKH-CRF-0084 [IN060429] - Start
	if(batchid_disable == "enabled"){
	    batchId = document.getElementById("non_iv_admin_batch_id");
	} 
	 //document.getElementById("consumption_recorded_checkbox") != undefined added for mms-kh-scf-0059
    if(batchid_disable=="enabled" && document.getElementById("consumption_recorded_checkbox") != undefined && !eval(document.getElementById("consumption_recorded_checkbox").checked)){
	fields[index]   = document.getElementById("non_iv_admin_batch_id");
	names[index++]   = getLabel("Common.BatchID.label",'Common') ;
    } // Added for AAKH-CRF-0084 [IN060429] - End
    
	fields[index]   = formObj.remarks ;
	names[index++]   = getLabel("Common.remarks.label",'Common') ;
	fields[index]   = formObj.administered_by ;
	names[index++]   = getLabel("Common.AdministeredBy.label",'Common') ;

	if(auth_req_yn=="Y" && mand_check!="Y"){// mand_check added for AAKH-CRF-0024 [IN:038260]
		fields[index]   = formObj.authorized_by ;
		names[index++]   = getLabel("ePH.Witnessedby.label",'PH') ;
		fields[index]   = formObj.user_pin ;
		names[index++]   = getLabel("Common.PIN.label",'Common') ;
		if(admn_dose_chng_reason_yn == "Y" || admn_dose_chng_reason_yn == "E"){
			fields[index] = formObj.chngd_admn_dose_reason;
			names[index++] =getLabel("ePH.ChangedAdminDosageReason.label",'PH');
		}
	}
	else{
		if(admn_dose_chng_reason_yn == "Y" || admn_dose_chng_reason_yn == "E"){
			fields[index] = formObj.chngd_admn_dose_reason;
			names[index++] =getLabel("ePH.ChangedAdminDosageReason.label",'PH');
		}
	}
	if(admin_discontinue=='Y'){
		fields[index] = formObj.reason_code;
		names[index++] =getLabel("ePH.Administered.label",'PH')+" "+getLabel("Common.reason.label",'Common');
	}
	
	if(!checkFlds( fields, names,'Y')){
		if(batchId.value=="" && batchid_disable=="enabled" && !eval(document.getElementById("consumption_recorded_checkbox").checked)){ // Added for AAKH-CRF-0084 [IN060429] - Start
			document.getElementById("non_iv_admin_batch_id").focus();
		} // Added for AAKH-CRF-0084 [IN060429] - End
		else if(formObj.remarks.value==""){
			formObj.remarks.focus();
		}
		else if(formObj.administered_by.value==""){
			formObj.administered_by.focus();
		}
		else if(auth_req_yn=="Y" && formObj.authorized_by.value==""){
			formObj.authorized_by.focus();
		}
		else if(auth_req_yn=="Y" && formObj.user_pin.value==""){
			formObj.user_pin.focus();
		}
		else if((admn_dose_chng_reason_yn == "Y" || admn_dose_chng_reason_yn == "E") && formObj.chngd_admn_dose_reason.value==""){
			formObj.chngd_admn_dose_reason.focus();
		}
		return false;
	}
	else{
		if(auth_req_yn=="Y" && mand_check!="Y"){// mand_check added for AAKH-CRF-0024 [IN:038260]
			var orig_user_pin	= formObj.orig_user_pin.value;
			var user_pin		= formObj.user_pin.value;		
			if(orig_user_pin!=user_pin){
				alert(getMessage("INVALID_PWD_PIN_NO","PH"));
				formObj.user_pin.focus();
				return false;
			}
			var administered_by_id =formObj.administered_by_id.value ;
			var authorized_by_id = formObj.authorized_by_id.value;
			if(administered_by_id!='' && authorized_by_id!='' && administered_by_id == authorized_by_id){ //if block added for SKR-SCF-0772 [IN:038262]
				alert(getMessage("PH_MAR_ADMIN_BY_WITNESS_BY_SAME_USER","PH"));
				formObj.authorized_by.select();
				formObj.authorized_by.focus();
				return false;
			}
		}
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		var next_admin	=	"";
		if(formObj.next_admin!=null) {
			next_admin	=	formObj.next_admin.value;
		}
		//ML-MMOH-SCF-1834 -start
		var reason_code= "";
		if(reason_code_yn!="Y"){
			reason_code= "";
		}else{
			reason_code = formObj.reason_code.value;
		}
		//ML-MMOH-SCF-1834 -end

		xmlStr	="<root><SEARCH " ;
		xmlStr += "row_no=\""+ row_no +"\" " ;
		xmlStr += "drug_code=\""+ drug_code +"\" " ;
		//xmlStr += "reason_code=\""+ formObj.reason_code.value +"\" " ;
		xmlStr += "reason_code=\""+ reason_code +"\" " ;
		xmlStr += "remarks=\""+ encodeURIComponent(formObj.remarks.value,"UTF-8") +"\" " ;
		if(admn_dose_chng_reason_yn == "Y" || admn_dose_chng_reason_yn == "E"){
			xmlStr += "admn_dose_chng_reason_code=\""+formObj.chngd_admn_dose_reason_code.value+"\" ";	
			xmlStr += "admn_dose_chng_reason=\""+formObj.chngd_admn_dose_reason.value+"\" ";
		}
		else{
			xmlStr +="admn_dose_chng_reason_code=\"\" ";
			xmlStr +="admn_dose_chng_reason=\"\" ";
		}
		xmlStr += "administered_by=\""+ formObj.administered_by_id.value +"\" " ;  //changed administered_by to administered_by_id for SCF-0093
		xmlStr += "order_id=\""+order_id +"\" " ;
		xmlStr += "order_line_num=\""+order_line_num+"\" " ;
		xmlStr += "encounter_id=\""+encounter_id+"\" " ;
		xmlStr += "callFrom=\""+callFrom+"\" " ;
		xmlStr += "nursing_unit=\""+nursing_unit+"\" " ;
		xmlStr += "assign_bed_num=\""+assign_bed_num+"\" " ;
		xmlStr += "sch_date_time=\""+sch_date_time+"\" " ;
		xmlStr += "dosage_seq=\""+dosage_seq+"\" " ;
		xmlStr += "scheKey=\""+scheKey+"\" " ;
		xmlStr += "couldNotAdmin=\""+couldNotAdmin+"\" " ;
		if(auth_req_yn=="Y")
			xmlStr += "authorized_by=\""+ formObj.authorized_by_id.value +"\" " ;
		else
			xmlStr += "authorized_by=\"\" " ;
		next_admin = convertDate(next_admin,"DMYHM",formObj.locale.value,"en"); // 26302::schedule_date_time for the next schedule when inserting was going wrong. ie. eng date time should be inserted but thai date time was getting inserted.
		xmlStr += "next_admin=\""+next_admin+"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
		xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity=saveRemarksForDrug", false ) ;
		xmlHttp.send( xmlDoc ) ;	
		eval(xmlHttp.responseText);

	}
	window.close();
	//parent.document.getElementById('dialog_tag').close();
  }
}
// clearDrgRemarks(); called to display error msg when the reason is not entered - 24705
function clearDrgRemarks(checkBoxObj,recNo,drugCode,rx){
	var formObj = document.MedicationAdministrationFTDrugDetails;
	if(checkBoxObj.checked == false){
		if(rx == "IV")
			eval("formObj.iv_Remarks"+recNo).value="N";
		if(rx == "NonIV")
			eval("formObj.Remarks"+recNo).value="N";
	}
}

function assignAdminTime(next_admin_time,remarks, callFrom) {
	if(callFrom=='SCH'){
		var retVal=new Array();
		retVal[0]=next_admin_time;
		retVal[1]=remarks;
		window.returnValue = retVal;
	}
	else{
		if(next_admin_time!="" && next_admin_time!=null)
			window.returnValue = next_admin_time;
		else
			window.returnValue = "OK";
	}
}

function validateFieldsForDrug(obj,rec,medn_admn_dtl_reqd_yn){
	
	var formObj = document.MedicationAdministrationFTDrugDetails;	
	if(obj.checked==false){
		//if(medn_admn_dtl_reqd_yn=="Y")
			eval("formObj.drug_remarks_mand_id_"+rec).style='display';
			eval("formObj.drug_remarks_mand_id_"+rec).style.visibility="visible";
	}
	else{
		/*if(eval("formObj.non_iv_drug_class"+rec)!=null && (eval("formObj.non_iv_drug_class"+rec).value=="C" || eval("formObj.non_iv_drug_class"+rec).value=="N")) { 
			
		} 
		else if(eval("formObj.iv_drug_class"+rec)!=null && (eval("formObj.iv_drug_class"+rec).value=="C" || eval("formObj.iv_drug_class"+rec).value=="N")) {
		}
		else 
		{*/
			//if(medn_admn_dtl_reqd_yn!="Y")
			var obj1=eval("formObj.pat_brought_med_"+rec);
			var ivPrepYN	= eval("formObj.iv_prep_yn_forNONIV"+rec).value;
			var non_iv_order_line_no= eval("formObj.non_iv_order_line_no_"+rec).value;			
			var onco_direct_drug_count=eval("formObj.onco_direct_drug_count_"+rec);
			var non_iv_admin_chng_dtls_req=eval("formObj.non_iv_admin_chng_dtls_req_"+rec);
			if(ivPrepYN=='9' && parseInt(onco_direct_drug_count.value)>1){												
				//var onco_rec_count=parseInt(rec)-parseInt(non_iv_order_line_no)+1;	
				var onco_medn_admin_dtl_reqd_yn=eval("formObj.medn_admn_dtl_reqd"+(parseInt(rec)+1)).value;
				var obj2=eval("formObj.pat_brought_med_"+(parseInt(rec)+1));
			}

			if(ivPrepYN!='9'||(ivPrepYN=='9' && onco_direct_drug_count.value=='1')){				
				if(medn_admn_dtl_reqd_yn!="Y" && !(obj1 != undefined &&(obj1.checked)) && non_iv_admin_chng_dtls_req.value=='N'){
					eval("formObj.drug_remarks_mand_id_"+rec).style.visibility="hidden";
					eval("formObj.drug_remarks_mand_id_"+rec).style.display="none";	
				}
			}
			else{
				if(medn_admn_dtl_reqd_yn!="Y" && !(onco_medn_admin_dtl_reqd_yn!= undefined && onco_medn_admin_dtl_reqd_yn=="Y") && !(obj1 != undefined &&(obj1.checked)) && !(obj2 != undefined &&(obj2.checked)) && non_iv_admin_chng_dtls_req.value=='N'){
					eval("formObj.drug_remarks_mand_id_"+rec).style.visibility="hidden";
					eval("formObj.drug_remarks_mand_id_"+rec).style.display="none";												
				}
			}
		//}
	}	
}

/*function openNewEntry(mode,row_no,drug_code,func_mode){
	var formObjDrugDetails = "";
	if(func_mode=="NOTIME"){
		parent.f_admin_chart.MedicationAdministrationFTDrugDetails;
	}else{
		parent.f_admin_chart.MedicationAdministrationFTDrugDetails;
	}
	if(mode !="update"){
		parent.f_admin_new_entry.location.href="../../ePH/jsp/MedicationAdministrationDetail.jsp?mode=entry";
		parent.f_admin_button.MedicationAdministrationButton.btnDelete.style.display="none";
		parent.f_admin_button.MedicationAdministrationButton.btnRecord.value= "Record";
	}
	else{
		if(func_mode=="NOTIME"){
			parent.f_admin_detail.location.href="../../ePH/jsp/MedicationAdministrationDetail.jsp?mode=entryAmend&drug_code="+drug_code+"&srl_no="+row_no;
			parent.f_button.location.href		="../../ePH/jsp/MedicationAdministrationButton.jsp?mode=entry";
			parent.AdminDetailFrameSet.rows="70,*,170,21";
		}else{
			parent.f_admin_button.MedicationAdministrationButton.btnDelete.style.display="inline";
			parent.f_admin_button.MedicationAdministrationButton.btnDelete.style.visibility="visible";
			parent.f_admin_new_entry.location.href="../../ePH/jsp/MedicationAdministrationDetail.jsp?mode=entryAmend&drug_code="+drug_code+"&srl_no="+row_no;
			parent.f_admin_button.MedicationAdministrationButton.btnRecord.value= "Amend";
		}
	}
	if(func_mode=="NOTIME"){
	}else{
		parent.MedicationAdministrationFixedTimeFrameSet.rows="22%,26%,46%,6%";
		parent.f_admin_button.MedicationAdministrationButton.btnRecord.style.display="inline";
		parent.f_admin_button.MedicationAdministrationButton.btnRecord.style.visibility="visible";
		parent.f_admin_button.MedicationAdministrationButton.btnCancel.style.display="inline";
		parent.f_admin_button.MedicationAdministrationButton.btnCancel.style.visibility="visible";
		parent.f_admin_button.MedicationAdministrationButton.btnAddEntry.style.display="none";
	}
}*/

function validateForMultiStrength(drug_code){
	var formObj		= parent.f_admin_chart.MedicationAdministrationFTDrugDetails;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
			
	xmlStr	="<root><SEARCH " ;
	xmlStr += "drug_code=\""+ drug_code +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&drug_code="+drug_code+"&identity=validateForMultiStrength", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	return xmlHttp.responseText;
}

function validateForBatchID(item_code,batch_id,row_no,mode,drugtype){

	if(batch_id!=""){
		var formObj="";
		if(mode=="NOTIME"){
			formObj		= parent.f_admin_detail.MedicationAdministrationFTDrugDetails;
		}
		else{
			formObj		= parent.f_admin_chart.MedicationAdministrationFTDrugDetails;		
		}
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
				
		xmlStr	="<root><SEARCH " ;
		xmlStr += "item_code=\""+ item_code +"\" " ;
		xmlStr += "mode=\""+ mode +"\" " ;
		xmlStr += "batch_id=\""+ batch_id +"\" " ;
		xmlStr += "row_no=\""+ row_no +"\" " ;
		xmlStr += "drugtype=\""+ drugtype +"\" " ;		
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity=validateForBatchID", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
}

function validateNewEntryBatchID(obj_drug_code,batch_id,bean_id,bean_name){
	var batch_id = batch_id.value;
	if(batch_id != ""){
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
					
		xmlStr	="<root><SEARCH " ;
		xmlStr += "drug_code=\""+ obj_drug_code.value +"\" " ;
		xmlStr += "batch_id=\""+ batch_id +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?drug_code="+obj_drug_code.value+"&batch_id="+batch_id+"&bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity=validateNewEntryBatchID", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
}

function alertForInvalidBatch(row_no,mode,drugtype){
	alert(getMessage("INVALID_BATCH_ID",'Common'));
	if(row_no != ""){
		var formObj		= "";
		if(mode=='NOTIME'){
			formObj		= parent.f_admin_detail.MedicationAdministrationFTDrugDetails;
		}
		else{
			formObj		= parent.f_admin_chart.MedicationAdministrationFTDrugDetails;
		}
		if(drugtype=="IV"){
			eval("formObj.iv_batch_id_"+row_no).select();
		}
		else{
			eval("formObj.non_iv_batch_id_"+row_no).select();
		}
	}
	else{
		parent.f_admin_new_entry.MedicationAdministrationEntryForm.batch_id.select();
	}
}

function alertForExpiredBatch(row_no,mode,drugtype){
	alert(getMessage("EXPIRED_BATCH",'Common'));
	if(row_no != ""){
		if(mode=='NOTIME'){
			formObj		= parent.f_admin_detail.MedicationAdministrationFTDrugDetails;
		}
		else{
			formObj		= parent.f_admin_chart.MedicationAdministrationFTDrugDetails;
		}
		if(drugtype=="IV"){
			eval("formObj.iv_batch_id_"+row_no).select();
		}
		else{
			eval("formObj.non_iv_batch_id_"+row_no).select();
		}
	}
	else{
		parent.f_admin_new_entry.MedicationAdministrationEntryForm.batch_id.select();
	}
}

function assignTradeAndExpiryDate(trade_name,expiry_date,row_no,mode,drugtype){
	
	if(row_no!=""){
		if(mode=='NOTIME'){
			formObj		= parent.f_admin_detail.MedicationAdministrationFTDrugDetails;
		}
		else{
			formObj		= parent.f_admin_chart.MedicationAdministrationFTDrugDetails;
		}
		if(drugtype=="IV"){
			eval("formObj.iv_expiry_date_"+row_no).value=expiry_date;
			eval("formObj.iv_trade_name_"+row_no).value =trade_name;
		}
		else{
			eval("formObj.non_iv_expiry_date_"+row_no).value=expiry_date;
			eval("formObj.non_iv_trade_name_"+row_no).value =trade_name;
		}
	}
	else{
		if(parent.f_admin_new_entry != null){
			parent.f_admin_new_entry.MedicationAdministrationEntryForm.expiry_date.value=expiry_date;
			parent.f_admin_new_entry.MedicationAdministrationEntryForm.trade_name.value=trade_name;		
		}else{
			document.getElementById('MedicationAdministrationEntryForm').expiry_date.value=expiry_date;
			document.getElementById('MedicationAdministrationEntryForm').trade_name.value=trade_name;
		}
	}
}

function callCheckMaxLen(obj,noOfChars,Legend){
	makeValidString(obj);
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

function CheckTime(obj) {
	var formObj = document.MedicationAdministrationSearchForm.all;
	var timefield = obj;
	if (tmchk(obj) == false) {
		alert(getMessage("INVALID_TIME_FMT",'Common'));
		if(obj.name=='from_time'){
			formObj.from_time.focus();
			return false;
		}else{
			formObj.to_time.focus();
			return false;
		}
	}else {
		if(obj.name=='from_time'){
			formObj.to_time.value = "";
			formObj.to_time.focus();
		}
		if(trimString(formObj.from_time.value)!="" && trimString(formObj.to_time.value)!=""){
			var from_time_array = (formObj.from_time.value).split(":")
			var to_time_array = (formObj.to_time.value).split(":")
						
			if(parseInt(from_time_array[1])<parseInt(to_time_array[1])){
				if(parseInt(from_time_array[0])>parseInt(to_time_array[0])){
			
				//	formObj.to_time.focus();
					return false;
				}
			}else if(parseInt(from_time_array[1])>parseInt(to_time_array[1])){
				if(parseInt(from_time_array[0])>=parseInt(to_time_array[0])){
				
				//	formObj.to_time.focus();
					return false;
				}
			}else if(parseInt(from_time_array[1])==parseInt(to_time_array[1])){
				if(parseInt(from_time_array[0])>parseInt(to_time_array[0])){
			
				//	formObj.to_time.focus();
					return false;
				}
			}
		}
		return true;
	}
}

function tmchk(obj1) {

	var strTime;
	var strHr;
	var strMi;	

	var timefield = obj1;
	var strTimeArray = new Array();

	strTime = timefield.value;
	if (strTime.length == 0) return true;

	strTimeArray = strTime.split(":");
	if (strTimeArray.length != 2) {
	return false;
	}
	else {
		strHr = strTimeArray[0];
		strMi = strTimeArray[1];
	}
	if (strHr.length > 2) return false;
	if (strMi.length > 2) return false;
	if (isNaN(strHr) == true) return false;
	if (isNaN(strMi) == true) return false;
	if (strHr < 0 || strHr > 23) return false;
	if (strMi < 0 || strMi > 59) return false;
}

async function callMultiStrength(drug_code,drug_desc,patient_id,order_id,order_line_no,source,store_code,qty_reqd,eff_expiry,admin_due_date,encounter_id,time,row_no,mode,hold_discontinue_yn,selDateTime,to_time,admin_from_date,admin_to_date)	{
	var dialogHeight= "50vh" ;
	var dialogWidth	= "70vw" ;
	var dialogTop	= "150" ;
	var center		= "1" ;
	var status		="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
		var	retVal  = await top.window.showModalDialog("../../ePH/jsp/DispMedicationAltDrugsFrames.jsp?drug_code="+drug_code+"&drug_desc="+drug_desc+"&patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&source="+source+"&store_code="+store_code+"&qty_reqd="+qty_reqd+"&eff_expiry="+eff_expiry,arguments,features);
	if(mode=='NOTIME'){	
		parent.f_admin_detail.location.href="../../ePH/jsp/MedicationAdministrationFTDrugDtls.jsp?hold_discontinue_yn="+hold_discontinue_yn+"&mode="+mode+"&admin_due_date="+admin_due_date+"&encounter_id="+encounter_id+"&time="+time+"&patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&row_no="+row_no+"&drug_code="+drug_code+"&selDateTime="+selDateTime+"&to_time="+to_time+"&admin_from_date="+admin_from_date+"&admin_to_date="+admin_to_date+"&from_time="+time;	
	}else{
		parent.f_admin_button.location.href="../../ePH/jsp/MedicationAdministrationFTButtons.jsp?alternate_drug=Y&patient_id="+patient_id+"&order_line_no="+order_line_no+"&encounter_id="+encounter_id;
		parent.f_admin_chart.location.href="../../ePH/jsp/MedicationAdministrationFTDrugDtls.jsp?hold_discontinue_yn="+hold_discontinue_yn+"&admin_due_date="+admin_due_date+"&encounter_id="+encounter_id+"&time="+time+"&patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&row_no="+row_no+"&selDateTime="+selDateTime+"&to_time="+to_time+"&admin_from_date="+admin_from_date+"&admin_to_date="+admin_to_date+"&from_time="+time;
	}
}

function  validateAdminDate(obj,schedule_date_time,row_no,mode,alertCheck,drugtype,locale){
	var sys_date = "";
	if(mode=='NOTIME'){					
		sys_date=parent.f_admin_detail.MedicationAdministrationFTDrugDetails.current_date_time;	
	}else{
		sys_date=parent.f_admin_chart.MedicationAdministrationFTDrugDetails.current_date_time;	
	}
	
	if(obj.value!=""){
		//if(doDateTimeChk(obj)){
		if(validDate(obj.value, "DMYHM",locale)){
			if(ValidateDateTime(sys_date,obj)){
				if(alertCheck!="DONOTALERT"){
				
				}
				obj.focus();
				return false;
			}else{
				var a=schedule_date_time.split(" ")
				var splitscheduledate=a[0];
				var splitscheduletime=a[1];
				var aascheduledate=splitscheduledate.split("/");
				var aascheduletime=splitscheduletime.split(":");
				var scheduledatetime		=	new		Date(aascheduledate[2],aascheduledate[1]-1,aascheduledate[0],aascheduletime[0],aascheduletime[1]);

				var entered_date_time = obj.value;
				var b=entered_date_time.split(" ");
				var splitentereddate=b[0];
				var splitenteredtime=b[1];
				var bbentereddate= splitentereddate.split("/");
				var bbenteredtime= splitenteredtime.split(":");
				var entereddatetime		=	new Date(bbentereddate[2],bbentereddate[1]-1,bbentereddate[0],bbenteredtime[0],bbenteredtime[1]);

				if(entereddatetime<scheduledatetime){
					var formObj	="";
					if(mode=='NOTIME'){	
						formObj	=  parent.f_admin_detail.MedicationAdministrationFTDrugDetails.all;
					}
					else{	
						formObj	=  parent.f_admin_chart.MedicationAdministrationFTDrugDetails.all;
					}
					if(drugtype=="IV"){
						eval("formObj.iv_infusion_st_time_"+row_no).select();
					}
					else if(drugtype=="ALT"){
						eval("formObj.alt_time_"+row_no).select();
					}
					else if(drugtype=="NEW"){
						eval("formObj.new_non_iv_admin_date_"+row_no).select();
					}
					else{
						eval("formObj.non_iv_time_"+row_no).select();
					}
					if(alertCheck!="DONOTALERT"){
						alert(getMessage("PH_MEDN_ADMIN_DT_GREATER_THAN_SCHEDULE_DT",'PH'));
					}
					return false;
				}
			}	
		}
		else{
			if(alertCheck!="DONOTALERT"){
				alert(getMessage("INVALID_DATE_TIME",'PH'));
			}
			obj.focus;
			return false;
		}
	}
	return true;
}

function checkFlds( fields, names,show_alert) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else if(show_alert !="Y"){
			errors = errors + "APP-000001 " + names[i] +" "+ getLabel("Common.Cannotbeblank.label",'Common')+"..." + "<br>" ;						
		}else{
			errors = errors + "APP-000001 " + names[i] +" "+getLabel( "Common.Cannotbeblank.label",'Common')+"...\n" ;						
		}
	}
	if ( errors.length != 0 && show_alert != "Y") {		
		if(parent.parent.messageFrame != null)
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errors;	
		else 
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ errors;	
		return false ;
	}else if(errors.length != 0 && show_alert == "Y"){
		alert(errors);
		return false;
	}else{
		if(parent.parent.messageFrame != null){
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";	
		}else if(parent.messageFrame!=null){
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";	
		}
	}
	return true ;
}

function showToolTip(obj,pract_name,admin_route,freq){
	obj.title=getLabel("Common.OrderingPractitioner.label",'Common')+" : "+pract_name +"\n"+getLabel("ePH.AdminRoute.label",'PH')+" : "+admin_route+"\n"+getLabel("Common.Frequency.label",'Common')+" : "+freq;
}

function skipToNextPatient(){
	var formDetailObj = parent.f_bedheader.MedicationAdministrationBedPatientHeader.patient_header_table;
	//console.log(parent.f_bedheader.document.getElementById('patient_header_table'));
	var len = parent.f_bedheader.document.getElementById('patient_header_table').rows.length;
	var selectedRow = parseFloat(parent.f_bedheader.MedicationAdministrationBedPatientHeader.selected_patient_id_row.value)+1;

	if(selectedRow>=len){
		alert(getMessage("PH_MEDN_ADMIN_NO_MORE_PATIENT",'PH')); 
		return false;
	}else{		
		
		if( parent.parent.f_admin_button != null){
			var formButtonsObj = parent.parent.f_admin_button.MedicationAdministrationButton;
			if(formButtonsObj.btnRecord!=null){
				formButtonsObj.btnRecord.style.display="none";
				formButtonsObj.btnCancel.style.display="none";
				formButtonsObj.btnDelete.style.display="none";
				if(formButtonsObj.direct_admin != null){
					if(formButtonsObj.direct_admin.value=="Y"){
						formButtonsObj.btnAddEntry.style='display';
						formButtonsObj.btnAddEntry.style.visibility="visible";
					}
				}
			}
		}
	}
	for(var i=1;i<(len-1);i++){
		if(parseFloat(i)==parseFloat(selectedRow)){
			for(var j=1;j<len ;j++){
				formDetailObj.rows[j].style.display="none";
			}			
			var formObj = formDetailObj.rows[i];
			for(var k=0;k<formObj.cells.length;k++){
						formObj.cells[k].style.backgroundColor="#fde6d0";
			}
			formDetailObj.rows[i].style.display="inline";
			formDetailObj.rows[i].style.visibility="visible";
			eval("formDetailObj.patient_id_"+i).click();
			parent.f_bedheader.MedicationAdministrationBedPatientHeader.selected_patient_id_row.value=selectedRow;
		}
	}
}

function expandDrugDetails(obj){
	var formObj = parent.f_admin_button.MedicationAdministrationButton.all;
	if(obj=="Cancel"){
		parent.MedicationAdministrationFixedTimeFrameSet.rows="15%,*,0%,15%";
		formObj.btnRecord.style.display="none";
		formObj.btnCancel.style.display="none";
		formObj.btnDelete.style.display="none";
		if(formObj.direct_admin.value=="Y"){
			formObj.btnAddEntry.style.display="inline";
			formObj.btnAddEntry.style.visibility="visible";
		}
	}
	else if(obj=="Delete"){
		insertNewRow('Delete');		
		parent.MedicationAdministrationFixedTimeFrameSet.rows="15%,*,0%,15%";
		formObj.btnRecord.style.display="none";
		formObj.btnCancel.style.display="none";
		formObj.btnDelete.style.display="none";
		if(formObj.direct_admin.value=="Y"){
			formObj.btnAddEntry.style.display="inline";
			formObj.btnAddEntry.style.visibility="visible";
		}
	}
	else{
		if(validateForMandatoryFields()){
			insertNewRow();		
			parent.MedicationAdministrationFixedTimeFrameSet.rows="15%,*,0%,15%";
			formObj.btnRecord.style.display="none";
			formObj.btnCancel.style.display="none";
			formObj.btnDelete.style.display="none";
			if(formObj.direct_admin.value=="Y"){
				formObj.btnAddEntry.style.display="inline";
				formObj.btnAddEntry.style.visibility="visible";
			}
		}
	}
}

function validateForMandatoryFields(){
	var formEntryObj = parent.f_admin_new_entry.MedicationAdministrationEntryForm;
		
	var pract_name = formEntryObj.pract_name.value;
	var pract_code = formEntryObj.pract_code.value;	
	var drug_name  = formEntryObj.drug_name.value;	
	var drug_code  = formEntryObj.drug_code.value;	
	var route_code = formEntryObj.route.value;	
	var freq_code  = formEntryObj.freq.value;	
	var dose_qty   = formEntryObj.dose_qty.value;	
	var qty_desc   = formEntryObj.qty_desc.value;	
	var admin_date_time = formEntryObj.admin_date_time.value;
	var batch_id	= formEntryObj.batch_id.value;
	var expiry_date = formEntryObj.expiry_date.value;
	var trade_name	= formEntryObj.trade_name.value;
	var fields  = new Array() ;
	var names   = new Array() ;
	
	var i=0;
	var j=0;

	if(pract_name==""){
		fields[i]   = formEntryObj.pract_name ;
		names[j]   =getLabel("ePH.PractionerName.label",'PH') ;
	}
	if(drug_name=="") {
		fields[++i]   = formEntryObj.drug_name ;
		names[++j]   =getLabel( "Common.DrugName.label",'Common') ;
	}
	if(route_code==""){
		fields[++i]   = formEntryObj.route ;
		names[++j]   = getLabel("ePH.AdminRoute.label",'PH') ;
	}
	if(freq_code==""){
		fields[++i]   = formEntryObj.freq ;
		names[++j]   =getLabel( "Common.Frequency.label",'Common') ;
	}
	if(dose_qty==""){
		fields[++i]   = formEntryObj.dose_qty;
		names[++j]   = getLabel("ePH.DosageQuantity.label",'PH') ;
	}
	if(qty_desc==""){
		fields[++i]   = formEntryObj.qty_desc ;
		names[++j]   = getLabel("ePH.DosageQtyUOM.label",'PH') ;
	}
	if(admin_date_time==""){
		fields[++i]   = formEntryObj.admin_date_time ;
		names[++j]   =getLabel( "ePH.AdminDate/Time.label",'PH') ;
	}
	if(checkFlds( fields, names)){
		return true;
	}
}

function insertNewRow(obj){

	var formEntryObj = parent.f_admin_new_entry.MedicationAdministrationEntryForm;
	var pract_name	= formEntryObj.pract_name.value;
	var pract_code	= formEntryObj.pract_code.value;
	var drug_desc	= formEntryObj.drug_name.value;
	var drug_code	= formEntryObj.drug_code.value;
	var route_code	= formEntryObj.route.value;
	var freq_code	= formEntryObj.freq.value;
	var dose_qty	= formEntryObj.dose_qty.value;
	var qty_desc	= formEntryObj.qty_desc.value;
	var admin_date_time = formEntryObj.admin_date_time.value;
	if(formEntryObj.srl_no!=null)
		var srl_no		=	formEntryObj.srl_no.value;
	
	var route_desc	= formEntryObj.route.options(formEntryObj.route.selectedIndex).text;
	var freq_desc	= formEntryObj.freq.options(formEntryObj.freq.selectedIndex).text;
	var batch_id	= formEntryObj.batch_id.value;
	var expiry_date = formEntryObj.expiry_date.value;
	var trade_name	= formEntryObj.trade_name.value;
	
	var addAmendFlag = 	parent.f_admin_button.MedicationAdministrationButton.btnRecord.value;

	xmlStr	="<root><SEARCH " ;
	xmlStr += "pract_name=\""+ pract_name +"\" " ;
	xmlStr += "pract_id=\""+ pract_code +"\" " ;
	xmlStr += "drug_desc=\""+ drug_desc +"\" " ;
	xmlStr += "drug_code=\""+ drug_code +"\" " ;
	xmlStr += "route_code=\""+ route_code +"\" " ;
	xmlStr += "freq_code=\""+ freq_code +"\" " ;
	xmlStr += "dose_qty=\""+ dose_qty +"\" " ;
	xmlStr += "qty_desc=\""+ qty_desc +"\" " ;
	xmlStr += "admin_date_time=\""+ admin_date_time +"\" " ;
	xmlStr += "route_desc=\""+ route_desc +"\" " ;
	xmlStr += "freq_desc=\""+ freq_desc +"\" " ;	
	if(formEntryObj.srl_no!=null)
		xmlStr += "srl_no=\""+ srl_no +"\" " ;
	xmlStr += "batch_id=\""+ batch_id +"\" " ;
	xmlStr += "expiry_date=\""+ expiry_date +"\" " ;
	xmlStr += "trade_name=\""+ trade_name +"\" " ;
	xmlStr +=" /></root>" ;

	storeDrugDetails(xmlStr,addAmendFlag,obj);

	var multi_strength = validateForMultiStrength(drug_code);
	
	var admin_due_date=parent.f_admin_chart.MedicationAdministrationFTDrugDetails.admin_due_date.value;
	var encounter_id=parent.f_admin_chart.MedicationAdministrationFTDrugDetails.encounter_id.value;
	var time=parent.f_admin_chart.MedicationAdministrationFTDrugDetails.from_time.value;
	var to_time=parent.f_admin_chart.MedicationAdministrationFTDrugDetails.to_time.value;
	
	var patient_id=parent.f_admin_chart.MedicationAdministrationFTDrugDetails.patient_id.value;
	var order_id=parent.f_admin_chart.MedicationAdministrationFTDrugDetails.order_id.value;
	var order_line_no=parent.f_admin_chart.MedicationAdministrationFTDrugDetails.order_line_no.value;
	var row_no=parent.f_admin_chart.MedicationAdministrationFTDrugDetails.row_no.value;
	var hold_discontinue_yn = parent.f_admin_chart.MedicationAdministrationFTDrugDetails.hold_discontinue_yn.value;

	var assign_bed_num=parent.f_admin_chart.MedicationAdministrationFTDrugDetails.assign_bed_num.value;
	var nursing_unit=parent.f_admin_chart.MedicationAdministrationFTDrugDetails.nursing_unit.value;
	var selDateTime = parent.f_admin_chart.MedicationAdministrationFTDrugDetails.selDateTime.value;
	parent.f_admin_chart.location.href="../../ePH/jsp/MedicationAdministrationFTDrugDtls.jsp?assign_bed_num="+assign_bed_num+"&nursing_unit="+nursing_unit+"&hold_discontinue_yn="+hold_discontinue_yn+"&admin_due_date="+admin_due_date+"&encounter_id="+encounter_id+"&time="+time+"&patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&row_no="+row_no+"&new_drug_multi_strength="+multi_strength+"&selDateTime="+selDateTime;	
}

function storeDrugDetails(xmlStr,addAmendFlag,obj){

	var formObj		= parent.f_admin_chart.MedicationAdministrationFTDrugDetails;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(obj=="Delete"){
		var identity = "deleteDrugDetails";
	}else if(addAmendFlag=="Record"){
		var identity = "storeDrugDetails";
	}else{
		var identity = "amendDrugDetails";
	}
	xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity="+identity, false ) ;
	xmlHttp.send( xmlDoc ) ;
}
function beforePost(str){
	//alert("Medication Administration FIxed TIme::"+str);  
}

async function apply(){

	var fields  = new Array() ;
	var names   = new Array() ;
	commontoolbarFrame.document.getElementById("apply").disabled=true;
	if(f_search.document.MedicationAdministrationSearchForm.time_type[1].checked==true ){
		var formObj = document.f_query_add_mod.f_admin_chart.MedicationAdministrationFTDrugDetails;
		var frameObj = document.f_query_add_mod.f_admin_chart;
		var disa='N';
		if(f_search.MedicationAdministrationSearchForm!=undefined){
		    disa=f_search.MedicationAdministrationSearchForm.disa.value;
		}
		var non_iv_len		= frameObj.non_iv_records.value;
		var alt_non_iv_len	= frameObj.alt_non_iv_records.value;
		var new_non_iv_len	= frameObj.new_non_iv_records.value;
		var iv_len			= frameObj.iv_records.value;
				
		//var Mar_Admin_Dtl_Cont_Norc_Mand=f_search.document.MedicationAdministrationSearchForm.Mar_Admin_Dtl_Cont_Norc_Mand.value;//added for SKR-SCF-1043[051891]	
		var callFormApply = false;
		var selected = false;
		for(var i=1;i<=non_iv_len;i++){
			if(eval("formObj.chk_non_iv_select_"+i) != null){
				if(eval("formObj.chk_non_iv_select_"+i).checked){
					callFormApply=true;
					selected = true;
					if(eval("formObj.non_iv_chk_"+i) != null){
						if(eval("formObj.non_iv_chk_"+i).checked==true)	{						
							if (eval("formObj.non_iv_admin_qty_"+i).disabled ==false){
								if(eval("formObj.non_iv_admin_qty_"+i).value=="" ||  eval("formObj.non_iv_admin_qty_"+i).value==0)	{
									messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";	
									eval("formObj.non_iv_admin_qty_"+i).focus();
									fields[0]  = eval("formObj.non_iv_admin_qty_"+i) ;
									names[0]   = getLabel("Common.Dosage.label",'Common') ;
									checkFlds( fields, names);
									return false;
								}	

								if(eval("formObj.non_iv_time_"+i).value=="" ){
									messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";	
									eval("formObj.non_iv_time_"+i).focus();
									fields[0]  = eval("formObj.non_iv_time_"+i) ;
									names[0]   = getLabel("Common.Date/Time.label",'Common') ;
									checkFlds( fields, names);
									return false;
								}
							}					  
						}
						else{
							eval("formObj.non_iv_admin_qty_"+i).value=0;
							if(eval("formObj.medn_admn_dtl_reqd"+i).value=="N"){
								if(eval("formObj.non_iv_dtls_yn"+i).value=="N"||eval("formObj.Remarks"+i).value=="N"){	
									messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("REA_NOT_ADMIN_MAND",'PH');
									return false;
								}
							}
						}
					}
					if(eval("formObj.medn_admn_dtl_reqd"+i).value=="Y" || eval("formObj.pat_brought_med_"+i).value=="Y"){
						var iv_prep=eval("formObj.iv_prep_yn_forNONIV"+i).value;
						var orderLineNum=eval("formObj.non_iv_order_line_no_"+i).value;
						if(iv_prep=='9' &&  parseInt(orderLineNum)>1)
							newRecNum=i-parseInt(orderLineNum)+1;
						else
							newRecNum=i;
						if(eval("formObj.Remarks"+newRecNum).value=="Y"){
							if(eval("formObj.non_iv_admin_chng_dtls_req_"+i).value=="Y"){
								messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MANDATORY_ADMIN_DETAILS",'PH');
								return false;
							}
							if( (eval("formObj.non_iv_drug_class"+i).value=="C" || eval("formObj.non_iv_drug_class"+i).value=="N") && eval("formObj.non_iv_dtls_yn"+i).value=="N"){
								if(disa!='Y'){
									messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("DRUG_CLASS_ADMIN_DETAILS",'PH');
									//return false;//added for AAKH-CRF-0024 [IN:038260]   //Commented for SKR-SCF-1043 [IN:051891]
								}
						        else {
									alert(getMessage("DRUG_CLASS_ADMIN_DETAILS",'PH'));
									callfail();
									return false;
								}
							}
						}
						else{
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MANDATORY_ADMIN_DETAILS",'PH');
							return false;
				  		} 
					}
					else if(eval("formObj.medn_admn_dtl_reqd"+i).value=="N"){
						if(eval("formObj.non_iv_admin_chng_dtls_req_"+i).value=="Y"){
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MANDATORY_ADMIN_DETAILS",'PH');
							return false;
						}
					
						if( (eval("formObj.non_iv_drug_class"+i).value=="C" || eval("formObj.non_iv_drug_class"+i).value=="N") && eval("formObj.non_iv_dtls_yn"+i).value=="N"){
							if(disa!='Y') {
								messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("DRUG_CLASS_ADMIN_DETAILS",'PH');
								//return false;//added for AAKH-CRF-0024 [IN:038260] //Commented for SKR-SCF-1043 [IN:051891]
							}
							else {
								alert(getMessage("DRUG_CLASS_ADMIN_DETAILS",'PH'));
								callfail();
								return false;
							}
						}
					}
				}//ELSE IF
			} //OTTER IF
		}//for

		for(var i=1;i<=alt_non_iv_len;i++){
			if(eval("formObj.chk_alt_non_iv_select_"+i) != null){
				 if(eval("formObj.chk_alt_non_iv_select_"+i).checked){
					callFormApply=true;
					selected = true;
					if (eval("formObj.alt_admin_qty_"+i).disabled ==false){
						if(eval("formObj.alt_admin_qty_"+i).value=="" ||  eval("formObj.alt_admin_qty_"+i).value==0){
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";	
							eval("formObj.alt_admin_qty_"+i).focus();
							fields[0]  = eval("formObj.alt_admin_qty_"+i) ;
							names[0]   =getLabel( "Common.Dosage.label",'Common');
							checkFlds( fields, names);
							return false;
						}
						if(eval("formObj.alt_time_"+i).value=="" ){
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";	
							eval("formObj.alt_time_"+i).focus();
							fields[0]  = eval("formObj.alt_time_"+i) ;
							names[0]   =getLabel("Common.Date/Time.label",'Common') ;
							checkFlds( fields, names);
							return false;
						}
					}
				}
			}
		}
		
		for(var i=1;i<=new_non_iv_len;i++){
			if(eval("formObj.chk_new_non_iv_select_"+i) != null){
				if(eval("formObj.chk_new_non_iv_select_"+i).checked){
					callFormApply=true;
					selected = true;
					if (eval("formObj.new_non_iv_dose_qty_"+i).disabled ==false){
						if(eval("formObj.new_non_iv_dose_qty_"+i).value=="" ||  eval("formObj.new_non_iv_dose_qty_"+i).value==0){
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";	
							eval("formObj.new_non_iv_dose_qty_"+i).focus();
							fields[0]  = eval("formObj.new_non_iv_dose_qty_"+i) ;
							names[0]   = getLabel("Common.Dosage.label",'Common') ;
							checkFlds( fields, names);
							return false;
						}
						if(eval("formObj.new_non_iv_admin_date_"+i).value=="" ){
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";	
							eval("formObj.new_non_iv_admin_date_"+i).focus();
							fields[0]  = eval("formObj.new_non_iv_admin_date_"+i) ;
							names[0]   =getLabel("Common.Date/Time.label",'Common') ;
							checkFlds( fields, names);
							return false;
						}	
					}
					var xmlDoc="";
					var xmlHttp = new XMLHttpRequest();					
					xmlStr	="<root><SEARCH " ;
					xmlStr += "drug_code=\""+ eval("formObj.new_non_iv_drug_code_"+i).value +"\" " ;
					xmlStr += "row_no=\""+ i +"\" " ;
					xmlStr +=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?drug_code="+eval("formObj.new_non_iv_drug_code_"+i).value+"&bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity=validateRemarksForDrug&row_no="+i, false ) ;
					xmlHttp.send( xmlDoc ) ;
					if(trimString(xmlHttp.responseText)=="false"){
						alert(getMessage("REMARKS_CAN_NOT_BE_BLANK",'PH'));
						return false;
					}
				}
			}
		}
		//FOR IV DRUGS ===============
		 	 
		for(var i=1;i<=iv_len;i++){
			if(eval("formObj.chk_iv_select_"+i) != null){
				if(eval("formObj.chk_iv_select_"+i).checked){
					callFormApply=true;    //iv_batch_id_
					selected = true;
					if (eval("formObj.iv_admin_qty_"+i).disabled ==false)	{
						if(eval("formObj.iv_admin_qty_"+i).value=="" ||  eval("formObj.iv_admin_qty_"+i).value==0){
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";	
							eval("formObj.iv_admin_qty_"+i).focus();
							fields[0]  = eval("formObj.iv_admin_qty_"+i) ;
							names[0]   = getLabel("Common.Dosage.label",'Common') ;
							checkFlds( fields, names);
							return false;
						}
						  
						if(eval("formObj.iv_infusion_st_time_"+i).value=="" ){
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";	
							eval("formObj.iv_infusion_st_time_"+i).focus();
							fields[0]  = eval("formObj.iv_infusion_st_time_"+i) ;
							names[0]   =getLabel( "ePH.Infusion/Time.label",'PH') ;
							checkFlds( fields, names);
							return false;
						}				
					}
					if(eval("formObj.iv_chk_complete_"+i)!=null){
						if(!eval("formObj.iv_chk_complete_"+i).checked){							
							//eval("formObj.iv_admin_qty_"+i).value=0; // Added for SKR-SCF-0550[Inc:33338]
							if(eval("formObj.iv_Remarks"+i).value=="N"){
								messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("REA_NOT_ADMIN_MAND",'PH');
								return false;
							}
						}
						//else{ // else block Added for SKR-SCF-0550[Inc:33338]
						//	eval("formObj.iv_admin_qty_"+i).value=eval("formObj.iv_admin_qty_"+i).value;
						//}
					}

					if(( (eval("formObj.iv_drug_class"+i).value=="C" ||  eval("formObj.iv_drug_class"+i).value=="N") && eval("formObj.iv_dtls_yn"+i).value=="N" && eval("formObj.iv_order_line_no_"+i).value=="1" && eval("formObj.iv_Remarks"+i).value=="N")||(eval("formObj.iv_Remarks"+i).value=="N"&& eval("formObj.chk_iv_select_"+i).disabled ==false)){
						if(disa!='Y'){
						     messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MANDATORY_ADMIN_DETAILS",'PH');
							 callFormApply =false;
							 return false;
							 break;
						}
						else{
							alert(getMessage("DRUG_CLASS_ADMIN_DETAILS",'PH'));
							callfail();
							return false;
						  }
					   }//FOR CONTROL LOOP 
										
				} //INNER IF 
			}//OUTER IF
		}//FOR
//		======================IV DRUGS ENDS===================
		if(formObj.adr_recorded.value=="Y") {
			callFormApply	=	true;
		}
		if(formObj.admin_recorded.value=="Y") {
			callFormApply	=	true;
		}
		
		if(callFormApply){
			//commontoolbarFrame.document.getElementById("apply").disabled=true;
			
			//alert(formApply(formObj,PH_CONTROLLER));
			//calling formApply for Single Time
			var userAuthCheck = await callUserAuthVal();
			if(!userAuthCheck){//RUT-CRF-0035 [IN029926] Added for PIN Validation based on Parameter Facility Checkbox - begin
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("PIN_PWD_CANNOT_BE_BLANK","PH");
				return false;
			}
			eval(formApply(formObj,PH_CONTROLLER));
			if( result ) {
				commontoolbarFrame.document.getElementById("apply").disabled=false;
				f_search.document.MedicationAdministrationSearchForm.Search.disabled=false;
				f_search.document.MedicationAdministrationSearchForm.Search.click();
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			}
			else if(message=='MANDATORY_ADMIN_DETAILS'){	
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage(message,'PH');
			}
			else{
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;	
			}
		}
		else if(!callFormApply  && !selected){
		    if(disa!='Y'){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_NO_RECORDS_SELECTED_FOR_ADMIN",'PH');
		  }
		  else{
				alert(getMessage("PH_NO_RECORDS_SELECTED_FOR_ADMIN",'PH'));
				callfail();
				return false;
		    }
		}		
	}
	else{
		var formObj = f_search.MedicationAdministrationSearchForm;		
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += "bean_id=\""+ bean_id +"\" " ;
		xmlStr += "bean_name=\""+ bean_name +"\" " ;		
		xmlStr +=" /></root>" ;
		xmlHttp.open( "POST", "MedicationAdministrationValidation.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&func_mode=checkForRecords", false ) ;
		xmlHttp.send( xmlDoc ) ;
		if(xmlHttp.responseText != 0){
			if(!callUserAuthVal()){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
				return false;
			}
			eval(formApply(formObj,PH_CONTROLLER));
			if( result ) {
			
				f_query_add_mod.location.reload();
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
				clearBean();
				commontoolbarFrame.document.getElementById('apply').disabled=false;
				f_search.document.MedicationAdministrationSearchForm.Search.disabled=false;
				f_search.document.MedicationAdministrationSearchForm.Search.click();
			}
			else
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		}
		else{
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_NO_RECORDS_SELECTED_FOR_ADMIN",'PH');
		}
	}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
/*
function validateAdminDateTime(admin_due_date,admin_due_time,sys_date_time,rec_admin_within_hrs){

	var a=sys_date_time.split(" ")
	var split_sys_date=a[0];
	var split_sys_time=a[1];
	var aa_split_sys_date=split_sys_date.split("/");
	var aa_split_sys_time=split_sys_time.split(":");
	var sysdatetime		=	new		Date(aa_split_sys_date[2],aa_split_sys_date[1]-1,aa_split_sys_date[0],aa_split_sys_time[0],aa_split_sys_time[1]);
	
	var allowable_date_time = new		Date(aa_split_sys_date[2],aa_split_sys_date[1]-1,aa_split_sys_date[0],aa_split_sys_time[0]-rec_admin_within_hrs,aa_split_sys_time[1]);

	var b = admin_due_date.value + " "+admin_due_time.value;

	var admin_due_date_time = b.split(" ");
	var admin_due_date =admin_due_date_time[0];
	var admin_due_time =admin_due_date_time[1];
	

	var aa_split_admin_due_date=admin_due_date.split("/");
	var aa_split_admin_due_time=admin_due_time.split(":");
	
	var admindatetime		=	new		Date(aa_split_admin_due_date[2],aa_split_admin_due_date[1]-1,aa_split_admin_due_date[0],aa_split_admin_due_time[0],aa_split_admin_due_time[1]);

	
	if(admindatetime>sysdatetime){
		//alert(getMessage("PH_MEDN_ADMIN_DATE_LESS_THAN_SYS_DATE"));		
		return false;
	}
	else if(admindatetime < allowable_date_time ){
		//alert(getMessage("PH_MEDN_ADMINDATE_ELAPSED"));		
		return false;
	}
}
*/
function assignBatchDetails(mode,drug_type,obj,row_no,not_mfr,disp_drug_code,drug_code,qty,order_id,order_line_num,freq_nature,old_MAR_YN,disp_drugs){ //not_mfr added for AAKH-SCF-0276
//disp_drug_code,drug_code,qty,order_id,order_line_num,freq_nature,old_MAR_YN,disp_drugs added for BRU-CRF-399.1
	var batch_id = obj.value;
	var alt_multi_drug = false;//added for BRU-CRF-399.1
	if(batch_id != '' ){
		var formObj="";
		if(mode=="NOTIME"){
			formObj		= parent.f_admin_detail.MedicationAdministrationFTDrugDetails;
		}
		else if(mode=="MFR"){
			formObj=document.MedicationAdministrationMFRDetails;
		}
		else if(mode=="SCH" && not_mfr!="NOT_MFR"){ // && not_mfr!="NOT_MFR" added for AAKH-SCF-0276
			formObj=document.MedicationAdministrationFTMFRRemarks;
		}
		else{
			if(parent.f_admin_chart!=null && parent.f_admin_chart!=undefined){
			    formObj		= parent.f_admin_chart.MedicationAdministrationFTDrugDetails;	
			}
			else{
              formObj		= document.MedicationAdministrationFTDrugDetails;	
			}
		}
		//added for BRU-CRF-399.1 - start
		if(disp_drug_code==undefined)
			disp_drug_code = "";
		if(drug_code==undefined)
			drug_code = "";
		if(order_id==undefined)
			order_id = "";
		if(order_line_num==undefined)
			order_line_num = "";

		if(drug_type!="IV"){ //if added for SKR-SCF-1431
		var batch_id_select = eval("formObj.non_iv_batch_id_"+row_no);
			var batch_id_opts = batch_id_select.options;
			var len = batch_id_opts.length;	// ICN63694
			
			for(var j = 1; j<len; j++) {//ICN63694
				non_iv_alt_drug_code = eval("formObj.non_iv_alt_drug_code_"+row_no+"_"+j).value;
				non_iv_batch_id_alt  = eval("formObj.non_iv_batch_id_alt_"+row_no+"_"+j).value;
				non_iv_batch_order_id = eval("formObj.non_iv_batch_order_id_"+row_no+"_"+j).value; //GHL-CRF-0482
				non_iv_batch_order_line_no = eval("formObj.non_iv_batch_order_line_no_"+row_no+"_"+j).value; //GHL-CRF-0482
					
				if( non_iv_batch_id_alt==obj.value) {
					disp_drug_code = non_iv_alt_drug_code; 
					 eval("formObj.non_iv_batch_order_id_"+row_no).value = non_iv_batch_order_id; //GHL-CRF-0482
					 eval("formObj.non_iv_batch_order_line_no_"+row_no).value = non_iv_batch_order_line_no;//GHL-CRF-0482
					break;
				}
			}
			if(drug_code!=disp_drug_code){
				alt_multi_drug = true;
			}
			if(disp_drugs!=""){
				getAltDoseDetails(formObj,disp_drug_code,drug_code,order_id,order_line_num,row_no,freq_nature,old_MAR_YN,qty)
				
			}
		}
		//added for BRU-CRF-399.1 - end
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		
		var xmlHttp = new XMLHttpRequest();			
		xmlStr	="<root><SEARCH " ;
		xmlStr += "batch_id=\""+ batch_id +"\" " ;
		xmlStr +=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&batch_id="+batch_id+"&identity=getBatchDetails", false ) ;
		xmlHttp.send( xmlDoc ) ;	
		var batch_details = xmlHttp.responseText;
			
		var dtls = batch_details.split("$");
		if(dtls[0] == null || dtls[0] =="null")
			dtls[0] = "";	
		if(dtls[1] == null || dtls[1] =="null")
			dtls[1] = "";	
		if(dtls[2] == null || dtls[2] =="null")
			dtls[2] = "";	
		 if(mode=="SCH" && not_mfr!="NOT_MFR"){ // && not_mfr!="NOT_MFR" added for AAKH-SCF-0276 
			eval("formObj.non_iv_expiry_date").value=dtls[0];
			if(dtls[1]!="null")
				eval("formObj.non_iv_trade_id").value=dtls[1];
			if(dtls[2]!="null")
				eval("formObj.non_iv_trade_name").value=dtls[2];
		 }
		 else{
			if(drug_type=="NON_IV"){
				eval("formObj.non_iv_expiry_date_"+row_no).value=dtls[0];
				if(dtls[1]!="null")
					eval("formObj.non_iv_trade_id_"+row_no).value=dtls[1];
				if(dtls[2]!="null")
					eval("formObj.non_iv_trade_name_"+row_no).value=dtls[2];
			}
			else if(drug_type=="ALT_NON_IV"){
				eval("formObj.alt_expiry_date_"+row_no).value=dtls[0];
				if(dtls[1]!="null")
					eval("formObj.alt_trade_id_"+row_no).value=dtls[1];
				if(dtls[2]!="null")
					eval("formObj.alt_trade_name_"+row_no).value=dtls[2];
			}
			else if(drug_type=="IV"){
				eval("formObj.iv_expiry_date_"+row_no).value=dtls[0];
				if(dtls[1]!="null")
					eval("formObj.iv_trade_id_"+row_no).value=dtls[1];
				if(dtls[2]!="null")
					eval("formObj.iv_trade_name_"+row_no).value=dtls[2];
			}
			else if(drug_type=="LBL_BATCH"){
				eval("formObj.lbl_expiry_date"+row_no).innerText=dtls[0];
				if(dtls[2]!="null")
					eval("formObj.lbl_trade_name"+row_no).innerText=dtls[2];
			}
			else if(drug_type=="MFR"){
				eval("formObj.MFR_exp_dt_"+row_no).value=dtls[0];
			}
		 }
	}
	else{
		if(batch_id==""){ //BRU-CRF-399.1 - start
			if(disp_drugs!=""){
			eval(document.getElementById('id_dispdrugdesc_'+row_no)).innerHTML =disp_drugs;
			}
		}//BRU-CRF-399.1 - end
		var formObj1="";
		if(mode=="NOTIME"){
			formObj1		= parent.f_admin_detail.MedicationAdministrationFTDrugDetails;
		}
		else if(mode=="MFR"){
			formObj1=document.MedicationAdministrationMFRDetails;
		}
		else if(mode=="SCH" && not_mfr!="NOT_MFR"){
			formObj=document.MedicationAdministrationFTMFRRemarks;
		}
		else{
			if(parent.f_admin_chart!=null && parent.f_admin_chart!=undefined){//BRU-CRF-399.1 
			    formObj1		= parent.f_admin_chart.MedicationAdministrationFTDrugDetails;	
			}
			else{
              formObj1		= document.MedicationAdministrationFTDrugDetails;	
			}
			//formObj1		= parent.f_admin_chart.MedicationAdministrationFTDrugDetails;		
		}
		if(mode=="SCH" && not_mfr!="NOT_MFR"){ 
			eval("formObj1.non_iv_expiry_date").value="";
			eval("formObj1.non_iv_trade_id").value="";
			eval("formObj1.non_iv_trade_name").value="";
		}
		else{
			if(drug_type=="NON_IV"){
				eval("formObj1.non_iv_expiry_date_"+row_no).value="";
				eval("formObj1.non_iv_trade_id_"+row_no).value="";
				eval("formObj1.non_iv_trade_name_"+row_no).value="";
			}
			else if(drug_type=="ALT_NON_IV"){
				eval("formObj1.alt_expiry_date_"+row_no).value="";
				eval("formObj1.alt_trade_id_"+row_no).value="";
				eval("formObj1.alt_trade_name_"+row_no).value="";
			}
			else if(drug_type=="IV"){
				eval("formObj1.iv_expiry_date_"+row_no).value="";
				eval("formObj1.iv_trade_id_"+row_no).value="";
				eval("formObj1.iv_trade_name_"+row_no).value="";
			}
			else if(drug_type=="LBL_BATCH"){
				eval("formObj1.lbl_expiry_date"+row_no).innerText="";
				eval("formObj1.lbl_trade_name"+row_no).innerText="";
			}
			else if(drug_type=="MFR"){
				eval("formObj1.MFR_exp_dt_"+row_no).value="";
			}
		}
	}
}

async function callMednBatchSearchMFR(rec_no){
	var formMFR=document.MedicationAdministrationMFRDetails;
	var store_code	=	formMFR.store_code.value;
	var item_code	=	formMFR.drug_code.value;
	var locale		=   formMFR.locale.value;
	var batch_obj	=   eval("formMFR.MFR_batch_id_"+rec_no);
	var expiry_obj	=   eval("formMFR.MFR_exp_dt_"+rec_no);	
	var trade_id_obj=   eval("formMFR.iv_trade_id_"+rec_no);
	var bin_code_obj=   eval("formMFR.iv_bin_code_"+rec_no);
	var end_date	=	getCurrentDate('DMY',locale);
	var includeZeroStockBatches ="N";
	var includeExpiredBatches ="N";
	var includeSuspendedBatches ="N";
	var searchFunction ="Y";
	var multipleSelect ="N";
	var retval=await callBatchSearchWindowaa(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect,end_date);
	if(retval!=undefined && retval!="") {
		var stock_values	=	retval.split("`");
		var batch_id		=	stock_values[0];		
		var expiry_date		=	stock_values[6];
		var bin_code		=	stock_values[7];
		var trade_id		=	stock_values[9];		

		batch_obj.value		=	batch_id;
		expiry_obj.value	=	convertDate(expiry_date,"DMY","en",locale);
		trade_id_obj.value	=	trade_id;
		bin_code_obj.value	=	bin_code;
	}
}
async function callMednBatchSearch(batch_obj,expiry_obj,trade_obj,trade_id_obj,bin_code_obj,item_code,rec_no,end_date,store_code,iv_from,row) {
	var store_code	=	store_code;
	//alert(batch_obj+'=expiry_obj=='+expiry_obj+'==trade_obj='+trade_obj+'=trade_id_obj=='+trade_id_obj+'==bin_code_obj='+bin_code_obj+'=item_code=='+item_code+'=rec_no=='+rec_no+'==end_date='+end_date+'==store_code='+store_code+'=expiry_obj=='+iv_from+'=row='+row);
	var item_code	=	item_code;
	if(iv_from!='IVSCH'){
		var end_date	=   eval("document.MedicationAdministrationFTDrugDetails."+end_date+".value");
		var batch_obj	=   eval("document.MedicationAdministrationFTDrugDetails."+batch_obj);
		var expiry_obj	=   eval("document.MedicationAdministrationFTDrugDetails."+expiry_obj);
		var trade_obj	=   eval("document.MedicationAdministrationFTDrugDetails."+trade_obj);
		var trade_id_obj	=   eval("document.MedicationAdministrationFTDrugDetails."+trade_id_obj);
		var bin_code_obj	=   eval("document.MedicationAdministrationFTDrugDetails."+bin_code_obj);
	}
	else{
		var end_date	=   eval("document.MedicationAdministrationFTMFRRemarks."+end_date+".value");
		var batch_obj	=   eval("document.MedicationAdministrationFTMFRRemarks."+batch_obj);
		var expiry_obj	=   eval("document.MedicationAdministrationFTMFRRemarks."+expiry_obj);
		var trade_obj	=   eval("document.MedicationAdministrationFTMFRRemarks."+trade_obj);
		var trade_id_obj	=   eval("document.MedicationAdministrationFTMFRRemarks."+trade_id_obj);
		var bin_code_obj	=   eval("document.MedicationAdministrationFTMFRRemarks."+bin_code_obj);
	}

	var includeZeroStockBatches ="N";
	var includeExpiredBatches ="N";
	var includeSuspendedBatches ="N";
	var searchFunction ="Y";
	var multipleSelect ="N";
	var retval=await callBatchSearchWindowaa(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect,end_date);

	var qtyInDispUom="";
	var qtyInDispUomObj;
	if(retval!=undefined && retval!="") {
		if(iv_from=="NONIV"){
			qtyInDispUomObj=eval("document.MedicationAdministrationFTDrugDetails.non_iv_qty_in_disp_mode_"+row);
		}
		else if(iv_from=="IV"){
			qtyInDispUomObj=eval("document.MedicationAdministrationFTDrugDetails.iv_qty_in_disp_mode_"+row);
		}
		else if(iv_from =='IVSCH'){
			qtyInDispUomObj=eval("document.MedicationAdministrationFTMFRRemarks.iv_qty_in_disp_mode");
		}
		qtyInDispUom=qtyInDispUomObj.value;
		if (qtyInDispUom=="" || qtyInDispUom==null || qtyInDispUom==undefined){
			qtyInDispUom ="0";
		}
		qtyInDisp=parseInt(qtyInDispUom);
		var stock_values	=	retval.split("`");
		var availqty		=	stock_values[15];
		if (availqty=="" || availqty==null || availqty==undefined){
			availqty ="0";
		}

		if(parseInt(qtyInDispUom)>parseInt(availqty)){ // this is to prevent to select the less stock batches
			alert(getMessage("INSUFFICIENT_BATCH_QTY",'PH'));
			return false;
		}
		qtyInDispUomObj.value="0";
		var batch_id		=	stock_values[0];
		var item_code		=	stock_values[1];
		var item_desc		=	stock_values[2];
		var store_code		=	stock_values[3];
		var store_desc		=	stock_values[4];
		var expiry_date		=	stock_values[6];
		var bin_code		=	stock_values[7];
		var bin_name		=	stock_values[8];
		var trade_id		=	stock_values[9];
		var trade_name		=	stock_values[10];

		batch_obj.value		=	batch_id;
		expiry_obj.value	=	expiry_date;
		trade_obj.value		=	trade_name;
		trade_id_obj.value	=	trade_id;
		bin_code_obj.value	=	bin_code;
	}
}

async function callBatchSearchWindowaa(item_code,store_code,includeZeroStockBatches,includeExpiredBatches,includeSuspendedBatches,searchFunction,multipleSelect,end_date){
	var dialogHeight	= "500px" ;//30
	var dialogWidth		= "800px";//60
	var dialogTop		= "10px" ;//100
	var dialogLeft		= "20px" ;//200
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
     retVal=await top.window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code="+item_code+"&store_code="+store_code+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect="+multipleSelect+"&cuttOffDate=",arguments,features);
	//retVal=window.open("../jsp/ItemSearch.jsp?search_string="+search_string+"&store_code="+store_code+"&category="+category+"&sole_source="+sole_source+"&ps_item="+ps_item+"&mfg_item="+mfg_item+"&expiry="+expiry+"&item_class="+item_class,'','dialogHeight:30; dialogWidth:50; center:0; status: no; dialogLeft :200; dialogTop :100;');

	return retVal;
}

//code moved to DIspensing JS 
/* 
function displayInstructions(order_id,order_line_no,dialogheight){

	//var dialogHeight	= "18" ;
	var dialogHeight	= dialogheight ;
	var dialogWidth		= "55";
	var dialogTop		= "190" ;
	var dialogLeft		= "150" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	var retVal=window.showModalDialog("../../ePH/jsp/InstructionsFrame.jsp?order_id="+order_id+"&order_line_no="+order_line_no,arguments,features);

}
*/
async function callPrescription(site,count) {
	
	//added for ghl-crf-0509 start
	var site_vo=site;
	if(site_vo== "true" && count=="Y"){
		var	printReport = confirm(getMessage("STORE_SETUP_AVAILABLE","PH"));
		
	//alert("printReport"+printReport);
	if(printReport){
		
	}
	else
		{
		return false;
		}
	}
	//added for ghl-crf-0509 end

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();			
	xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "MedicationAdministrationValidation.jsp?func_mode=VO&yes_no=Y", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	
	//var formObj		=	parent.f_admin_chart.MedicationAdministrationFTDrugDetails; //commented for IN045025
	var formObj		=	parent.f_patient_details.f_bedheader.MedicationAdministrationBedPatientHeader; //Added for IN045025
	encounter_id	=	formObj.encounter_id.value;
	patient_id		=	formObj.patient_id.value;
	/*if(patient_id==null||patient_id==''){ //Commented for IN045025
		patient_id		=	formObj.patient_id.value;
	}*/
	locn_type		=	"N";
	locn_code		=	parent.parent.f_search.MedicationAdministrationSearchForm.nursing_unit.value;
	patientclass	=	parent.parent.f_search.MedicationAdministrationSearchForm.patient_class1.value;
	if(patientclass=="E")
		patientclass="EM";
	if(patientclass=="A")
		patientclass="OP";
	var dialogHeight ='37vh' ;
	var dialogWidth = '70vw' ;
	var dialogTop	= '105';
	var dialogLeft = '150' ;

	var title = 'rewe'
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments			= "";
//	var amend_called_from	= "existing_order";
	var amend_called_from	= "";
	var orderId				=	"";
	var pract_reln_id		=	"";

	var p_called_from_ca	=	"Y";
	//alert(p_called_from_ca);
	var finalString = "function_id=MEDICATION_ADMIN&ammend_called_from="+amend_called_from+"&order_id="+orderId+"&patient_id="+patient_id+"&episode_id="+encounter_id+"&pract_reln_id="+pract_reln_id+"&location_type="+locn_type+"&location_code="+locn_code+"&patient_class="+patientclass+"&p_called_from_ca="+p_called_from_ca+"&Sex=&Age=&Dob=&visit_adm_date=&iv_prep_yn=&function_from=";

	var retVals = await window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();			
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "MedicationAdministrationValidation.jsp?func_mode=VO&yes_no=N", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	if(parent.parent.f_search.document.MedicationAdministrationSearchForm.btnSearch != undefined){ //If block and else condition added for IN045025
		parent.parent.f_search.document.MedicationAdministrationSearchForm.btnSearch.click();
	}
	else{
		parent.parent.f_search.document.MedicationAdministrationSearchForm.Search.disabled=false;
		parent.parent.f_search.document.MedicationAdministrationSearchForm.Search.click();
	}
}

async function showDrugInfo(external_product_id,drug_desc){
	var dialogHeight	="85vh" ;
	var dialogWidth	="70vw";
	var dialogTop	= "270" ;
	var dialogLeft	= "200" ;
	var center		= "0" ;
	var status		= "no";
	drug_desc = unescape(drug_desc);
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	var retVal		= await top.window.showModalDialog("../../ePH/jsp/DisplayDrugInfoFrames.jsp?extprodid="+external_product_id+"&drugdesc="+drug_desc+"&JSFile=../../ePH/js/Prescription_1.js",arguments,features);
}

async function searchCode(target,objIdentify){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray[0] = "LANGUAGE_ID";
	dataValueArray[0]= document.getElementById('locale').value;
	dataTypeArray[0] = STRING;	
	argumentArray[0]   = document.getElementById('SQL_PH_MED_ADMIN_APPL_USERS').value;	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	var namelabel=getLabel("Common.AdministeredBy.label","Common");
	if(objIdentify=='W')
		namelabel=getLabel("ePH.Witnessedby.label",'PH');	
	var retVal =await CommonLookup(namelabel, argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	target.value = "";
	if(retVal != null && retVal != "" ){
		target.value = arr[1] ;
		//the below condition is added for RUT-SCF-0093
		if(document.MedicationAdministrationFTRemarks){
			var formObj =document.MedicationAdministrationFTRemarks;
			if(objIdentify=='A'){
				formObj.administered_by_id.value=arr[0];
			}
		}
		if(objIdentify=='W'){
			var formObj =document.MedicationAdministrationFTRemarks;
			formObj.authorized_by_id.value=arr[0];
			var bean_id		= formObj.bean_id.value ;
			var bean_name	= formObj.bean_name.value ;
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();			
			xmlStr	="<root><SEARCH " ;
			xmlStr += "user_id=\""+ arr[0] +"\" " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity=getPinNumberForRemarks", false ) ;
			xmlHttp.send( xmlDoc ) ;	
			var pin_number = xmlHttp.responseText;
			formObj.orig_user_pin.value=trimString(pin_number);
		}
	}	
}

function validateTime(obj,locale) {
	//if(!doDateTimeChk(obj)) {
	if(trimString(obj.value)==""){
		obj.value="";
		return false;
	}
	if(!validDate(obj.value, "DMYHM",locale)){
		alert(getMessage("INVALID_DATE_TIME",'PH'));
		obj.focus();
		return false;
	}
	// added for SCF-7528 -start
	if(document.MedicationAdministrationFTRemarks){
		var sch_date_time		=document.MedicationAdministrationFTRemarks.sch_date_time.value;// added for SCF-7528
		var admin_date_time_lim =document.MedicationAdministrationFTRemarks.admin_date_time_lim.value;// added for SCF-7528
		if(isBefore(obj.value,sch_date_time, "DMYHM",locale)){
			alert(getMessage("PH_NEXT_ADMIN_SCHEDULE_DATE", "PH"));
			obj.focus();
			return false;
		}
		if(isBetween(sch_date_time, admin_date_time_lim, obj.value, 'DMYHM', locale)){
			if(obj.value!=admin_date_time_lim){
				alert(getMessage("PH_NEXT_ADMIN_RANGE_DATE_LIM", "PH"));
				return false;
			}
		}
	}
	if(document.MedicationAdministrationFTMFRRemarks){
		var sch_date_time		=document.MedicationAdministrationFTMFRRemarks.sch_date_time.value;
		if(isBefore(obj.value,sch_date_time, "DMYHM",locale)){
			if(sch_date_time!=obj.value){
			alert(getMessage("PH_NEXT_ADMIN_START_DATE_LIM", "PH"));
			obj.focus();
			return false;
			}
		}
	}
	//for SCF-7528 - End
}

function validateAdminDateTime(fromDate, toDate, obj, locale,sch_date_time){
	currDate = obj.value;
	if(currDate!=""){
		if(!validDate(obj.value, "DMYHM",locale)){
			alert(getMessage("INVALID_DATE_TIME",'PH'));
			obj.value="";
			obj.focus();
			return false;
		}
		if(!isBetween(fromDate, toDate, currDate, 'DMYHM', locale)){
			//alert(getMessage("PH_ADMIN_DATE_TIME__BETWEEN_SCH_CURR_DATE_TIME",'PH'));
			var timeMsg=getMessage("PH_ADMIN_DATE_TIME_BETWEEN_CURR_DATE_TIME",'PH')
			timeMsg=timeMsg.replace('$',fromDate);
			timeMsg=timeMsg.replace('#',toDate);
			alert(timeMsg);
			obj.value = toDate;
		//Added for AAKH-SCF-0296 start IN062053
		obj.focus();
		return false;
		//Added for AAKH-SCF-0296 end IN062053
		}
		if(sch_date_time!=undefined){						//added for SCF-7528
			if(isBefore(obj.value,sch_date_time, "DMYHM",locale)){ 
				if(sch_date_time!=obj.value){	
				alert(getMessage("PH_NEXT_ADMIN_INFUSE_DATE_LIM", "PH"));
				obj.value="";
				obj.focus();
				return false;
				}
			}
		}
	}
}
function checkIVGroup(count,no_of_drugs,obj,sch_date_time){	
	if(obj.checked==false) {
		for(i=count;i<((parseInt(count)+parseInt(no_of_drugs)));i++){
			if(eval("document.MedicationAdministrationFTDrugDetails.chk_iv_select_"+i)!=null) {
				eval("document.MedicationAdministrationFTDrugDetails.chk_iv_select_"+i).checked = false;
			}
		}
	} 
	else{

		for(i=count;i<((parseInt(count)+parseInt(no_of_drugs)));i++){
			if(eval("document.MedicationAdministrationFTDrugDetails.chk_iv_select_"+i)!=null) {
				eval("document.MedicationAdministrationFTDrugDetails.chk_iv_select_"+i).checked = true;		
			}
		}
	}
}

function checkOncologyGroup(rec_count,no_of_drugs,obj,sch_date_time){	
	if(obj.checked==false) {
		for(i=rec_count;i<((parseInt(rec_count)+parseInt(no_of_drugs)));i++){
			if(eval("document.MedicationAdministrationFTDrugDetails.chk_non_iv_select_"+i)!=null) {
				eval("document.MedicationAdministrationFTDrugDetails.chk_non_iv_select_"+i).checked = false;
			}
		}
	} 
	else{

		for(i=rec_count;i<((parseInt(rec_count)+parseInt(no_of_drugs)));i++){
			if(eval("document.MedicationAdministrationFTDrugDetails.chk_non_iv_select_"+i)!=null) {
				eval("document.MedicationAdministrationFTDrugDetails.chk_non_iv_select_"+i).checked = true;		
			}
		}
	}
}
async function callMednDetails(patient_id,nursing_unit,admin_date) {

	var patient_class=parent.parent.f_search.document.MedicationAdministrationSearchForm.patient_class1.value

	/*var dialogHeight	= "40"; // commenteed for PMG2014-CRF-0026 [IN:052701]
	var dialogWidth		= "85";
	var dialogTop		= "80";
	var dialogLeft		= "20";
	var center			= "0";*/
	var dialogHeight	= "90vh";// Added for PMG2014-CRF-0026 [IN:052701] -start
	var dialogWidth		= "95vw";//85
	var dialogTop		= "10";
	//dialogWidth		= (window.innerHeight);
	win_width		= (window.innerWidth);	
	if(win_width==undefined){
		dialogHeight		= (document.documentElement.clientHeight);
		dialogWidth		= (document.documentElement.clientWidth);			
		if(dialogWidth==0){				
			dialogHeight		= (parseInt(document.body.clientHeight));
			dialogWidth		= (parseInt(document.body.clientWidth));				
		}			 
	}		
	dialogTop			= "0px"; // Added for PMG2014-CRF-0026 [IN:052701] -end
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight+ "; dialogWidth:" + dialogWidth  + "; status: " + status + "; dialogTop :" + dialogTop+";resizable=yes;maximize:yes;minimize:no;";// Added for PMG2014-CRF-0026 [IN:052701]
	//var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop; // commented for PMG2014-CRF-0026 [IN:052701]
	var arguments		= "";
	retVal 				= await window.showModalDialog1("../../ePH/jsp/QueryMednAdminChart.jsp?patient_id="+patient_id+"&nursing_unit="+nursing_unit+"&admin_date="+admin_date+"&patient_class="+patient_class+"&called_from=MEDADMIN",arguments,features);
	//retVal 				= window.open("../../ePH/jsp/QueryMednAdminChart.jsp?patient_id="+patient_id+"&nursing_unit="+nursing_unit+"&admin_date="+admin_date+"&patient_class="+patient_class+"&called_from=MEDADMIN",arguments,features);
}

async function callMednReport() {
	var dialogHeight	= "35";
	var dialogWidth		= "50";
	var dialogTop		= "170";
	var dialogLeft		= "200";
	var center			= "0";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal 				= await window.showModalDialog("../../ePH/jsp/PhMednAdminList.jsp?called_from=MEDNADMIN",arguments,features);
}

async function callLateMednReport() {
	var dialogHeight	= "35";
	var dialogWidth		= "50";
	var dialogTop		= "170";
	var dialogLeft		= "200";
	var center			= "0";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal 				= await window.showModalDialog("../../ePH/jsp/PhRepLateAdministration.jsp?called_from=MEDNADMIN",arguments,features);
}

function uppercase() {
	key = window.event.keyCode;
	if((key>0x60) && (key< 0x7B))
		window.event.keyCode=key-0x20;
}


function getAdminRemarks(formObj,fromAdmin){//fromAdmin added for MMS-KH-CRF-0010
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "reason_code=\"" + formObj.reason_code.value + "\" " ;
	if(fromAdmin == "Y")//IF CONDTION ADDED FOR MMS-KH-CRF-0010
	xmlStr+= "appl_trn_type='MR'" ;
	else
		xmlStr+= "appl_trn_type='M'" ;
	xmlStr +=" /></root>";
	var temp_jsp="MedicationAdministrationValidation.jsp?func_mode=getAdminRemarks";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert(xmlStr);
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	//alert(responseText);
	eval(responseText);
}

function setAdminRemarks(remarks) {
//	document.MedicationAdministrationFTRemarks.remarks.value = remarks;
	document.MedicationAdministrationFTRemarks.remarks.value = decodeURIComponent(remarks);
}

function callFunction(func_name,encounter_id) { // encounter_id added for AAKH-CRF-0088.2
	var patient_id	=	document.MedicationAdministrationBedPatientHeader.pat_id_link.value;
	if(func_name=="AL") {
		showAllergicDrug(patient_id);
	}
	else if(func_name=="PR") {
		showActiveProblems(patient_id);
	}
	else if(func_name=="DM") {
		showDemographics(patient_id);
	}
	else if(func_name=="DP") {
		showPatDrugProfile(patient_id,'Prescription',encounter_id); // encounter_id added for AAKH-CRF-0088.2
	}
	else if(func_name=="CR") {
		showCurrentRx(patient_id,'','','IP');
	}
}

async function showPatDrugProfile(patient_id,called_frm,encounter_id){ // encounter_id added for AAKH-CRF-0088.2
	var patient_class	= document.MedicationAdministrationBedPatientHeader.patient_class.value;
	if(patient_class==null || patient_class=="")
		patient_class="IP";
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var dialogTop		= "10" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				= await top.window.showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+escape(patient_id)+"&called_frm=Prescription&pat_class="+patient_class+"&encounter_id="+encounter_id, arguments, features );  // encounter_id added for AAKH-CRF-0088.2
}

//modified by uthra for the null value to be handled for PRN doses 
function displayDosage(obj,admin_qty,pres_dose,pres_unit,freq_nature,schedule_uom_desc,short_desc,fromDate, toDate, currDate, locale,recCount){
	if(obj.checked && freq_nature=="P") {			
		if(currDate!=""){					
			if(!isBetween(fromDate, toDate, currDate, 'DMYHM', locale)){
				//alert(getMessage("PH_ADMIN_DATE_TIME__BETWEEN_SCH_CURR_DATE_TIME",'PH'));
				var timeMsg=getMessage("PH_ADMIN_DATE_TIME_BETWEEN_CURR_DATE_TIME",'PH')
					timeMsg=timeMsg.replace('$',fromDate);
					timeMsg=timeMsg.replace('#',toDate);
				alert(timeMsg);
				eval("document.MedicationAdministrationFTDrugDetails.non_iv_time_"+recCount).value = toDate;
				obj.checked =false;
				return false;
			}
		}
		var bal_qty=0;
		var adm_qty=1;
		var temp_bal_qty=eval("document.MedicationAdministrationFTDrugDetails.non_iv_bal_qty_"+recCount).value;
		var temp_adm_qty=eval("document.MedicationAdministrationFTDrugDetails.non_iv_admin_qty_"+recCount).value;
		var non_iv_chk  =eval("document.MedicationAdministrationFTDrugDetails.non_iv_chk_"+recCount);
		var alt_MAR_YN = "N";//BRU-CRF-399.1 -start
		if(eval("document.MedicationAdministrationFTDrugDetails.alt_MAR_YN_"+recCount))
		 alt_MAR_YN  =eval("document.MedicationAdministrationFTDrugDetails.alt_MAR_YN_"+recCount).value;


		if(alt_MAR_YN=="Y"){
			pres_dose  =eval("document.MedicationAdministrationFTDrugDetails.alt_dosage_"+recCount).value;
			schedule_uom_desc  =eval("document.MedicationAdministrationFTDrugDetails.alt_dosage_uom_"+recCount).value;
			short_desc = schedule_uom_desc;
		}//BRU-CRF-399.1 -end
		bal_qty=parseInt(temp_bal_qty);
		adm_qty=parseInt(temp_adm_qty);

		if(bal_qty-adm_qty<0){
			alert(getMessage("PH_ADM_QTY_EXCEEDS_BAL_QTY","PH"));
			obj.checked =false;
			return false;
		}
		msg	=	getMessage("PRES_VS_ADM_DOSAGE",'PH');
		msg	=	msg.replace("&qty1",parseFloat(pres_dose)+" "+decodeURIComponent(schedule_uom_desc));

		if(admin_qty.value =="" || admin_qty.value == null || (non_iv_chk!=undefined && !(non_iv_chk.checked))){
			admin_qty.value = 0;
		}
		if(pres_dose == "" || pres_dose == null){
			pres_dose =0;
		}
		msg	=	msg.replace("&qty2",parseFloat(admin_qty.value)+" "+decodeURIComponent(short_desc));
		alert(msg);
	}else{//GHL-CRF-509 - start
		if(obj.checked==false){
			if(eval("document.MedicationAdministrationFTDrugDetails.placed_from_verbal_order_"+recCount)!=undefined){
				if(eval("document.MedicationAdministrationFTDrugDetails.placed_from_verbal_order_"+recCount).value=="Y"){
					if(eval("document.MedicationAdministrationFTDrugDetails.batch_assigned_verbal_order_"+recCount).value=="Y"){
							eval("document.MedicationAdministrationFTDrugDetails.non_iv_batch_id_"+recCount).value	   ="";
							eval("document.MedicationAdministrationFTDrugDetails.non_iv_expiry_date_"+recCount).value ="";
							eval("document.MedicationAdministrationFTDrugDetails.non_iv_trade_id_"+recCount).value	   ="";
							eval("document.MedicationAdministrationFTDrugDetails.non_iv_bin_code_"+recCount).value	   ="";
					}
				}
			}
		}//GHL-CRF-509 - end
	}
}

/*function displayDosage(obj,admin_qty,pres_dose,pres_unit,freq_nature){
	alert("=admin_qty=="+admin_qty.value+"=pres_dose==="+pres_dose+"=pres_unit=="+pres_unit+"=freq_nature=="+freq_nature); 

	if(obj.checked && freq_nature=="P") {
		msg	=	getMessage("PRES_VS_ADM_QTY");
		msg	=	msg.replace("&qty1",pres_dose+" "+pres_unit);
		if(admin_qty.value =="" || admin_qty.value == null )
			admin_qty.value = 0;
		if(pres_dose == "" || pres_dose == null)
			pres_dose =0;
		msg	=	msg.replace("&qty2",parseInt(admin_qty.value)*parseInt(pres_dose)+" "+pres_unit);
		alert(msg);

	}
}
*/

function clearBean(){
	var dummy="dummy";
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" dummy=\""+ dummy + "\" ";
	xmlStr +=" /></root>";
	//alert(xmlStr);
	return fieldValidation(xmlStr,"clearBean");
}

function changeDisplay(obj,ivRecCount,sch_infusion_per_unit, callFrom){	
	if(callFrom!='SCH')
		var mainFormObj=document.MedicationAdministrationFTDrugDetails;
	else
		var mainFormObj=document.MedicationAdministrationSchLevelDrugDtls;
	if(obj.name=='iv_admin_qty_'+ivRecCount)
		obj=eval("mainFormObj.iv_flow_rate_"+ivRecCount)
	var sch_infusion_rate=obj.value;
	var sch_infusion_in_min=roundDigits(sch_infusion_rate/60.0)+"";
	var tol_title=sch_infusion_in_min+" "+getLabel("ePH.ML/Minute.label",'PH'); 
	var iv_admin_qty=eval("mainFormObj.iv_admin_qty_"+ivRecCount).value;
	var completed_volume=eval("mainFormObj.completedFlow"+ivRecCount).value;
	//var completedMinutes=eval("mainFormObj.completedMinutes"+ivRecCount).value;
	iv_admin_qty=parseFloat(iv_admin_qty)-parseFloat(completed_volume);
	//eval("document.MedicationAdministrationFTDrugDetails.iv_flow_rate_"+ivRecCount).title=tol_title;
	var infusion_period="";
	if(sch_infusion_per_unit=="M") // this was "M" changed to H bshankar
		infusion_period=(iv_admin_qty/sch_infusion_rate)/60;
	else
		infusion_period=iv_admin_qty/sch_infusion_rate;	

/*	if(infusion_period=="0" || infusion_period=="00")
		infusion_period = "1";*/
	if(parseFloat(infusion_period)< 0.01)
			infusion_period = "0.01";
	eval("mainFormObj.iv_infusion_period_"+ivRecCount).value=infusion_period;
}

function roundDigits(a){
	var a=a+"";
	if (a.indexOf(".")==-1){
		bb=a.substr(0,a.length);
	}
	else{
		bb=a.substr(a.indexOf("."),a.length);
		if (bb.length>2){
			bb=a.substr(0,a.indexOf(".")+2);
		}
		else{
			bb=a;
		}
	}
	return bb;
}

async function callrecord(calledFrom){
	var fields  = new Array() ;
	var names   = new Array() ;
	var formObj = document.MedicationAdministrationFTDrugDetails;
	var non_iv_len		= document.getElementById("non_iv_records").value;
	var alt_non_iv_len	= document.getElementById("alt_non_iv_records").value;
	var new_non_iv_len	= document.getElementById("new_non_iv_records").value;
	var iv_len			= document.getElementById("iv_records").value;	
	if(calledFrom == undefined)
		calledFrom="";
	var callFormApply = false;
	var selected = false;
	for(var i=1;i<=non_iv_len;i++){
		if(eval("formObj.chk_non_iv_select_"+i) != null){
			if(eval("formObj.chk_non_iv_select_"+i).checked){
				callFormApply=true;
				selected = true;
								
				if(eval("formObj.non_iv_chk_"+i).checked==true) {
					if (eval("formObj.non_iv_admin_qty_"+i).disabled ==false){
						if(eval("formObj.non_iv_admin_qty_"+i).value=="" ||  eval("formObj.non_iv_admin_qty_"+i).value==0){
							eval("formObj.non_iv_admin_qty_"+i).focus();
							fields[0]  = eval("formObj.non_iv_admin_qty_"+i) ;
							names[0]   = getLabel("Common.Dosage.label",'Common') ;
							checkFlds( fields, names);
							return false;
						}
						if(eval("formObj.non_iv_time_"+i).value=="" ){
							eval("formObj.non_iv_time_"+i).focus();
							fields[0]  = eval("formObj.non_iv_time_"+i) ;
							names[0]   = getLabel("Common.Date/Time.label",'Common') ;
							checkFlds( fields, names);
							return false;
						}
					}
				}
				
				/*if( (eval("formObj.non_iv_drug_class"+i).value=="C" ||  eval("formObj.non_iv_drug_class"+i).value=="N") && eval("formObj.non_iv_dtls_yn"+i).value=="N") {
					alert(getMessage("DRUG_CLASS_ADMIN_DETAILS",'PH'));
					return false;
				}*/
				if((eval("formObj.medn_admn_dtl_reqd"+i).value=="Y"||eval("formObj.pat_brought_med_"+i).value=="Y")&& eval("formObj.non_iv_dtls_yn"+i).value=="N"){
					alert(getMessage("MANDATORY_ADMIN_DETAILS","PH"));					
					return false;
				}
				else if(document.getElementById('medn_admn_dtl_reqd'+i).value=="N"){ //added for ML-MMOH-SCF-1876
				if(document.getElementById('non_iv_admin_chng_dtls_req_'+i).value=="Y"){
					
						alert(getMessage("MANDATORY_ADMIN_DETAILS","PH"));					
						return false;
			}
			}
			else if(eval("formObj.medn_admn_dtl_reqd"+i).value=="Y"){
			var iv_prep=eval("formObj.iv_prep_yn_forNONIV"+i).value;
				var orderLineNum=eval("formObj.non_iv_order_line_no_"+i).value;
				if(iv_prep=='9' &&  parseInt(orderLineNum)>1)
					newRecNum=i-parseInt(orderLineNum)+1;
				else
					newRecNum=i;
				if(document.getElementById('Remarks'+newRecNum).value=="Y"){
					if(document.getElementById('non_iv_admin_chng_dtls_req_'+i).value=="Y"){
					alert(getMessage("MANDATORY_ADMIN_DETAILS","PH"));
						return false;
					}
			}
			}
			}
		}
	}

	for(var i=1;i<=alt_non_iv_len;i++){
		if(eval("formObj.chk_alt_non_iv_select_"+i) != null){
			if(eval("formObj.chk_alt_non_iv_select_"+i).checked){
				callFormApply=true;
				selected = true;
				if (eval("formObj.alt_admin_qty_"+i).disabled ==false){
					if(eval("formObj.alt_admin_qty_"+i).value=="" ||  eval("formObj.alt_admin_qty_"+i).value==0){
						eval("formObj.alt_admin_qty_"+i).focus();
						fields[0]  = eval("formObj.alt_admin_qty_"+i) ;
						names[0]   = getLabel("Common.Dosage.label",'Common') ;
						checkFlds( fields, names);
						return false;
					}
					if(eval("formObj.alt_time_"+i).value=="" ){
						eval("formObj.alt_time_"+i).focus();
						fields[0]  = eval("formObj.alt_time_"+i) ;
						names[0]   = getLabel("Common.Date/Time.label",'Common') ;
						checkFlds( fields, names);
						return false;
					}
				}
			}
			
		}
	}
	for(var i=1;i<=new_non_iv_len;i++){
		if(eval("formObj.chk_new_non_iv_select_"+i) != null){
			if(eval("formObj.chk_new_non_iv_select_"+i).checked){
				callFormApply=true;
				selected = true;
				if (eval("formObj.new_non_iv_dose_qty_"+i).disabled ==false){
					if(eval("formObj.new_non_iv_dose_qty_"+i).value=="" ||  eval("formObj.new_non_iv_dose_qty_"+i).value==0){
						eval("formObj.new_non_iv_dose_qty_"+i).focus();
						fields[0]  = eval("formObj.new_non_iv_dose_qty_"+i) ;
						names[0]   = getLabel("Common.Dosage.label",'Common') ;
						checkFlds( fields, names);
						return false;
					}
					if(eval("formObj.new_non_iv_admin_date_"+i).value=="" ){
						eval("formObj.new_non_iv_admin_date_"+i).focus();
						fields[0]  = eval("formObj.new_non_iv_admin_date_"+i) ;
						names[0]   = getLabel("Common.Date/Time.label",'Common') ;
						checkFlds( fields, names);
						return false;
					}	
				}
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();					
				xmlStr	="<root><SEARCH " ;
				xmlStr += "drug_code=\""+ eval("formObj.new_non_iv_drug_code_"+i).value +"\" " ;
				xmlStr += "row_no=\""+ i +"\" " ;
				xmlStr +=" /></root>" ;

				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?drug_code="+eval("formObj.new_non_iv_drug_code_"+i).value+"&bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity=validateRemarksForDrug&row_no="+i, false ) ;
				xmlHttp.send( xmlDoc ) ;
				if(trimString(xmlHttp.responseText)=="false"){
					alert(getMessage("REMARKS_CAN_NOT_BE_BLANK",'PH'));
					return false;
				}
			}
		}
	}

	for(var i=1;i<=iv_len;i++){
		if(eval("formObj.chk_iv_select_"+i) != null){
			if(eval("formObj.chk_iv_select_"+i).checked){
				callFormApply=true;    //iv_batch_id_
				selected = true;
				if (eval("formObj.iv_admin_qty_"+i).disabled ==false){
					if(eval("formObj.iv_admin_qty_"+i).value=="" ||  eval("formObj.iv_admin_qty_"+i).value==0){
						eval("formObj.iv_admin_qty_"+i).focus();
						fields[0]  = eval("formObj.iv_admin_qty_"+i) ;
						names[0]   = getLabel("Common.Dosage.label",'Common') ;
						checkFlds( fields, names);
						return false;
					}
					
					if(eval("formObj.iv_infusion_st_time_"+i).value=="" ){
					/*if(eval("formObj.iv_batch_id_"+i).value=="" ||  eval("formObj.iv_batch_id_"+i).value==0){*/
						eval("formObj.iv_infusion_st_time_"+i).focus();
						fields[0]  = eval("formObj.iv_infusion_st_time_"+i) ;
						names[0]   = getLabel("ePH.Infusion/Time.label",'PH') ;
						checkFlds( fields, names);
						return false;
					}

					// the whole if block added for incident 26422:sri			
					//	if(eval("document.getElementById("iv_chk_complete_")"+i) != undefined){//Rawther	 Fixed for SCF -- SRR20056-SCF-7399 [IN:027442]	
					if(document.getElementById("iv_chk_complete_"+i) != undefined && document.getElementById("iv_chk_complete_"+i) !=null){
						if(document.getElementById("iv_chk_complete_"+i).checked && eval("formObj.iv_remarks_mand_id_"+i).style.display == "inline"  && eval("formObj.iv_Remarks"+i).value == "N"){
							errors = "APP-000001 " + getLabel("Common.remarks.label",'Common') +" "+ getLabel("Common.Cannotbeblank.label",'Common')+"...";
							alert(errors);
							return false;
						}
					}
					//}
				}
				//chkforRemarks(formObj);
				if(( (document.getElementById("iv_drug_class"+i).value=="C" ||  document.getElementById("iv_drug_class"+i).value=="N") && document.getElementById("iv_dtls_yn"+i).value=="N" && document.getElementById("iv_order_line_no_"+i).value=="1" && document.getElementById("iv_Remarks"+i).value=="N")||(document.getElementById("iv_Remarks"+i).value=="N"&& document.getElementById("chk_iv_select_"+i).disabled ==false && document.getElementById("iv_order_line_no_"+i).value=="1")){//added for IN26422 reopen --16/02/2011-- priya && eval("formObj.iv_order_line_no_"+i).value=="1" Added for SKR-SCF-0832.1[Inc 44638]
					alert(getMessage("MANDATORY_ADMIN_DETAILS",'PH'));
					//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MANDATORY_ADMIN_DETAILS",'PH');
					callFormApply =false;
					return false;
					break;
				}

				if( (document.getElementById("iv_drug_class"+i).value=="C" ||  document.getElementById("iv_drug_class"+i).value=="N") && document.getElementById("iv_dtls_yn"+i).value=="N" && document.getElementById("iv_order_line_no_"+i).value=="1"){
					//return false;
				} 
			}			
		}
	}
	if(!selected){
		alert(getMessage("PH_NO_RECORDS_SELECTED_FOR_ADMIN",'PH'));
		return false;
	}
	if(formObj.adr_recorded.value=="Y") {
		callFormApply	=	true;
	}
	if(formObj.admin_recorded.value=="Y") {
		callFormApply	=	true;
	}
	if(callFormApply){		
		var retVal1="1";// RUT-CRF-0035 [IN029926] PIN Authentication -- begin  
		if(document.getElementById("userAuthPINYN").value=='Y'){
			var dialogHeight	= "400px";
			var dialogWidth		= "700px";
			var dialogTop		=  window.screen.availWidth - 1100;
			var dialogLeft		=  window.screen.availWidth - 1000;
			var center			= "0";
			var status			= "no";	
			var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			retVal1= await window.showModalDialog("../../ePH/jsp/UserPINAuthorization.jsp?call_from=MAR","",features);
			if(retVal1==undefined || retVal1=='C')
				 return false;
			else if(trimString(retVal1)!="0") // && trimString(retVal1)!="")
				storeUserinBean_MAR(trimString(retVal1),'TL');
		}
		if(retVal1!="0")  // RUT-CRF-0035 [IN029926] PIN Authentication  -- end
			eval(formApply(formObj,PH_CONTROLLER));
		if( result ) {
			alert(getMessage("ADMINISTERED_SUCCESSFULLY",'PH'));
			clearBean();
			window.returnValue="OK";
			window.close();								
		}
		else{
			alert(getMessage(message,"PH"));
			window.returnValue="OK";
		}
	}	
}	

function callCancel(){
	window.close();
}

function closeFunction() {
	top.window.close();
}

 function callfail(){
	commontoolbarFrame.location.reload();
 }

 function compareBeds(){
   var formObj = document.MedicationAdministrationSearchForm;
   var from_bed_no=formObj.from_bed_no.value;
   var to_bed_no=formObj.to_bed_no.value;
   if(from_bed_no > to_bed_no) {
	   parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num= "+getMessage("TO_BED_NO_MUST_GRT_THAN_FROM_BED_NO",'PH');	   
   }
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
 async function showDrug(drug_code){
	var dialogHeight= "400px" ;//30
	var dialogWidth	= "700px" ;//50
	var dialogTop = "10px" ;//111
	var center = "1" ;
	var status="no";
	if(drug_code == undefined)
		drug_code="";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;

	var retVal = await window.showModalDialog("../../ePH/jsp/ViewDrugInfo.jsp?DrugCode="+drug_code,arguments,features);

}
 async function locationSearchForIPandDC(patient_class,login_user,call_bed_flag){
	 //alert("inside locationSearchForIPandDC 2798");
	document.MedicationAdministrationSearchForm.patient_class1.value  =  patient_class;
	var argumentArray   = new Array() ;
	var dataNameArray   = new Array() ; 
	var dataValueArray  = new Array() ;
	var dataTypeArray   = new Array() ;
	var facility_id		=	document.MedicationAdministrationSearchForm.facility_id.value;
	var language_id		=	document.MedicationAdministrationSearchForm.locale.value;
	var sql				=	document.MedicationAdministrationSearchForm.SQL_PH_MED_ADMIN_SELECT17.value;
	
	sql=sql.replace('#',facility_id);
	sql=sql.replace('#',login_user);
	sql=sql.replace('#',facility_id);
	sql=sql.replace('#',patient_class);
	sql=sql.replace('#',language_id);
  
	argumentArray[0]   =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] =document.MedicationAdministrationSearchForm.nursing_unit_desc.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal =await CommonLookup(getLabel("Common.Location.label","Common"), argumentArray );
//	alert("inside locationSearchForIPandDC 2823 "+retVal);
	//var str =unescape(retVal);
	//var arr = str.split(",");
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "") {
		//alert("inside locationSearchForIPandDC 2834");
		document.MedicationAdministrationSearchForm.nursing_unit.value = arr[0];
		document.MedicationAdministrationSearchForm.nursing_unit_desc.value=arr[1];
		//alert("call_bed_flag ="+call_bed_flag);
		if(call_bed_flag=="Y"){
			//alert("inside flag if 2840");
		getbed_nos();
		}
	}
}

function setValue(obj){
	
	clear_from_beds();
	clear_to_beds();
	//clearbed();
	//clearbed2();
	parent.f_query_add_mod.location.href="../../eCommon/html/blank.html"	
	document.MedicationAdministrationSearchForm.nursing_unit_desc.value="";
	document.MedicationAdministrationSearchForm.nursing_unit.value="";
	if(obj.value=="IP" || obj.value=="DC"){
		document.MedicationAdministrationSearchForm.from_bed_no.disabled=false;
		document.MedicationAdministrationSearchForm.to_bed_no.disabled=false;
	}
	else{
		document.MedicationAdministrationSearchForm.from_bed_no.disabled=true;
		document.MedicationAdministrationSearchForm.to_bed_no.disabled=true;
	}
}

async function locationSearch(obj1,login_user){
	var frmObj=document.MedicationAdministrationSearchForm;
	var patient_class =frmObj.patient_class.value;
	var call_bed_flag ='N';

	 if(patient_class ==''||patient_class ==undefined) {
		if(frmObj.patient_class[0].checked==true)
			patient_class=frmObj.patient_class[0].value;
		
		else if(frmObj.patient_class[1].checked==true)
			patient_class=frmObj.patient_class[1].value;
		
		else if(frmObj.patient_class[2].checked==true)
			patient_class=frmObj.patient_class[2].value;
		
	 else if(frmObj.patient_class[3].checked==true)
	 patient_class=frmObj.patient_class[3].value;
	// alert("patient_class[3] 2880"+patient_class[3]);
	 //alert("call_bed_flag 2881"+call_bed_flag);
		
	 
	 call_bed_flag ='Y';
	}
	if(patient_class=="IP" || patient_class=="DC"){
		//alert("call_bed_flag 2885 "+call_bed_flag);
		call_bed_flag ='Y';
		await locationSearchForIPandDC(patient_class,login_user,call_bed_flag);
	}
	else{
		if(patient_class=='OP')	{
			patient_class='A';
		}
		else if(patient_class=='EM'){
			patient_class='E';
		}
		await locationSearchForOPandEM(patient_class,login_user);

	}
}

function findValuesRange(obj,no){
	formObj			= document.MedicationAdministrationFTDrugDetails;
	var rangeFrom;
	var rangeTo;
	var currentValue=parseInt(obj.value);
	var srlno =parseInt(eval("formObj.sliding_scale_srl_no_"+no).value);
	if(srlno==undefined||srlno==null){
		srlno=15;
	}
	var assign;
	for(i=1;i<=srlno;i++){
		if(eval("formObj.sliding_scale_ranges_from_"+no+"_"+i)!=undefined){
			rangeFrom=parseInt(eval("formObj.sliding_scale_ranges_from_"+no+"_"+i).value);
			rangeTo=parseInt(eval("formObj.sliding_scale_ranges_to_"+no+"_"+i).value);
			assign=eval("formObj.sliding_scale_adm_qty_"+no+"_"+i).value;
			if(rangeTo!=0){
				if(currentValue<=rangeTo){
					if(currentValue>=rangeFrom){
						eval("formObj.non_iv_admin_qty_"+no).value=assign;
						return;
					}
					else
						eval("formObj.non_iv_admin_qty_"+no).value=0;
				}
			}
			else{
				if(currentValue>=rangeFrom){
					eval("formObj.non_iv_admin_qty_"+no).value=assign;
				}
			}		
		}
	}
}

async function locationSearchForOPandEM(patient_class,login_user){
	document.MedicationAdministrationSearchForm.patient_class1.value=patient_class;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var facility_id=document.MedicationAdministrationSearchForm.facility_id.value;
	var language_id=document.MedicationAdministrationSearchForm.locale.value;


	var sql	=document.MedicationAdministrationSearchForm.SQL_PH_MED_ADMIN_SELECT18.value;

	sql=sql.replace('#',facility_id);
	sql=sql.replace('#',login_user);
	sql=sql.replace('#',facility_id);
	sql=sql.replace('#',patient_class);
	sql=sql.replace('#',language_id);
  	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] =document.MedicationAdministrationSearchForm.nursing_unit_desc.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal =await CommonLookup(getLabel("Common.Location.label","Common"), argumentArray );
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	//var str =unescape(retVal);
	//var arr = str.split(",");
	if(retVal != null && retVal != "") {
		document.MedicationAdministrationSearchForm.nursing_unit.value = arr[0];
		document.MedicationAdministrationSearchForm.nursing_unit_desc.value=arr[1];
	
	}
}

function getHrsMinStr(HMvalue,HMunit,rec_count, callFrom){	
	if(callFrom=='SCH')
		var mainFormObj=document.MedicationAdministrationSchLevelDrugDtls;
	else
		var mainFormObj=document.MedicationAdministrationFTDrugDetails;
	var completedMinutes=eval("mainFormObj.completedMinutes"+rec_count).value;
	var holdedMinutes=eval("mainFormObj.sfrHOLD_DURN_IN_MINS"+rec_count).value;
	var sch_infusion_per_unit=eval("mainFormObj.sch_infusion_per_unit_"+rec_count).value
	var completedFlow=eval("mainFormObj.completedFlow"+rec_count).value
	if(HMvalue == 'TAKE'){
		HMvalue=parseFloat(eval(document.getElementById("iv_infusion_period_"+rec_count)).value);	
	}
	else {
//26092 inf period was wrongly displaying. hence we r recalculating HMvalue sri:26th jan.
		flow_rate = eval("mainFormObj.iv_flow_rate_"+rec_count).value;
		admin_dose = eval("mainFormObj.iv_admin_qty_"+rec_count).value;
		//Added for SRR20056-SCF-7371 IN027409 -start
		if( parseFloat(admin_dose) > parseFloat(completedFlow)){
			if(completedFlow!=undefined && parseFloat(completedFlow)!=0)
				admin_dose = parseFloat(admin_dose) - parseFloat(completedFlow);
			HMvalue = parseFloat(admin_dose)/parseFloat(flow_rate);
		}
		else{
			if(sch_infusion_per_unit=="H") 
				HMvalue = parseFloat(completedMinutes)/60;
			else
				HMvalue = parseFloat(completedMinutes)
		}
		//Added for SRR20056-SCF-7371 IN027409 -End
		//HMvalue = parseFloat(admin_dose)/parseFloat(flow_rate); //commented for SRR20056-SCF-7371 IN027409
		if(sch_infusion_per_unit=="H"){
			HMvalue =  Math.round(HMvalue*100)/100;
			HMvalue=parseFloat(HMvalue);
			//HMvalue=parseFloat(HMvalue)+parseFloat(parseInt(completedMinutes)/60); //24296  //commented for SRR20056-SCF-7371 IN027409
		}
		else{
			HMvalue =  Math.round(HMvalue*100)/100;
			HMvalue=parseFloat(HMvalue/60);
			//HMvalue=parseFloat(HMvalue/60)+parseInt(completedMinutes);  // / 60 added for inc : 26785 9/03/11 //commented for SRR20056-SCF-7371 IN027409
		}
	}
//	HMvalue = Math.round(HMvalue); // done for 26425 when dose is 20 and flow rate is 6.67 inf period was displaying wrong (precision problem)
	eval("mainFormObj.iv_infusion_period_"+rec_count).value = HMvalue;// this line added for issue 26299
	 if( HMunit == 'H' ) {
		 hrs = Math.floor(HMvalue);
		 HMvalue = HMvalue * 60;
	 } 
	 else {
		 hrs = HMvalue / 60;
	 }
	 min = HMvalue % 60;
	 var hh=Math.floor(hrs)+"";
	 var mm=Math.round(min)+"";

// this is done coz in case that infuse over is 1 hr, inf rate is 1.67, we get HMvalue as 0.998 hence u get hrs as 0 and min as 60
	if(mm >= 60){
		hh = (hh+1)+"";
		mm = (mm - 60)+"";
	}

	 if(hh==0 && mm==0) mm="1";

	 if(hh.length==1) 
		 hh="0"+hh;
	 if(mm.length==1) 
		 mm="0"+mm;
	
	if(callFrom!='SCH'){
		var objlabel=document.getElementById("sch_inf_per_"+rec_count);
		var objText =eval("mainFormObj.iv_infusion_period_txt"+rec_count);
		 objlabel.innerText='['+hh + ' Hrs ' + mm + ' Mins]';
		 objText.value=hh + ':' + mm;
	}
	 eval("mainFormObj.inf_prd_hrs"+rec_count).value=hh;
	 eval("mainFormObj.inf_prd_min"+rec_count).value=mm;
}

function getHrsMinStrForAdminYES(HMvalue,HMunit){

	var hrs=0;
	var min=0;
	 if( HMunit == 'H' ) {
		 hrs = Math.floor(HMvalue);
		 HMvalue = HMvalue * 60;
	 } 
	 else {
		 hrs = HMvalue / 60;
	 }
	 min = HMvalue % 60;	
	 var hh=Math.floor(hrs)+"";
	 var mm=Math.round(min)+"";
	 if(hh.length==1) hh="0"+hh;
	 if(mm.length==1) mm="0"+mm;
	 return hh + ':' + mm;
}

function updateNonIvAdminQuantity(obj,rec_count,drug_strength,dosage_by,content_in_pres_base_uom,strength_per_value_pres_uom,disp_with_alt){//disp_with_alt added for BRU-CRF-399.1
	var tempval=obj.value;
	
	var obj1=eval("document.MedicationAdministrationFTDrugDetails.non_iv_admin_qty_"+rec_count);
	
	var obj3=eval("document.MedicationAdministrationFTDrugDetails.non_iv_admin_qty1_"+rec_count);
	var obj2=eval("document.MedicationAdministrationFTDrugDetails.non_iv_bal_qty_"+rec_count);
	if(disp_with_alt=="false"){ //BRU-CRF-399.1
	if(tempval!=null && tempval!=""){  
		if(dosage_by=="S"){
			if(obj1!=null)
				obj1.value=((parseFloat(tempval)/parseFloat(drug_strength))*parseFloat(strength_per_value_pres_uom))/parseFloat(content_in_pres_base_uom);
		}
		else{			
			obj1.value=parseFloat(tempval)/parseFloat(content_in_pres_base_uom);
		}
		var bal_qty=0;
		var adm_qty=0;
		var tmp_bal_qty=obj2.value;
		var tmp_adm_qty=obj1.value;
		
		//		if(parseFloat(tmp_bal_qty)-parseFloat(tmp_adm_qty)<0)
		//rounding to 3 decimal places
		if(!(((Math.round(parseFloat(tmp_bal_qty)*1000)/1000)-(Math.round(parseFloat(tmp_adm_qty)*1000)/1000))>=0))	{
			alert(getMessage("PH_ADM_QTY_EXCEEDS_BAL_QTY","PH"));
			eval("document.MedicationAdministrationFTDrugDetails.chk_non_iv_select_"+rec_count).checked=false;
			obj3.focus();
			return false;
		}
	}
	}
	else	{
		return false;
	}
}

function enableDisableTextbox(rec_count,medn_admin_dtl_reqd_yn,pat_lookbut_enabled,iv_prep,or_line_num,verify_adm_drug){ // verify_adm_drug added for AAKH-CRF-0084 [IN060429]
	var formobj=document.MedicationAdministrationFTDrugDetails;
	var onco_flag=false;
	var onco_rec_count=1;
	var obj2;
	var onco_medn_admin_dtl_reqd_yn;
	var non_iv_admin_chng_dtls_req;
	var non_iv_chk;
	if(iv_prep=='9' && parseInt(or_line_num)>1)	{
		onco_flag=true;
		onco_rec_count=parseInt(rec_count)-parseInt(or_line_num)+1;	
		objMandImage=eval("formobj.drug_remarks_mand_id_"+onco_rec_count);
		obj2=eval("formobj.pat_brought_med_"+onco_rec_count);
		onco_medn_admin_dtl_reqd_yn=eval("formobj.medn_admn_dtl_reqd"+onco_rec_count).value;
		non_iv_admin_chng_dtls_req=eval("formobj.non_iv_admin_chng_dtls_req_"+onco_rec_count); 
		non_iv_chk=eval("formobj.non_iv_chk_"+onco_rec_count);		
	}
	else if(iv_prep=='9' && or_line_num=='1')	{
		objMandImage=eval("formobj.drug_remarks_mand_id_"+rec_count); 	
		non_iv_admin_chng_dtls_req=eval("formobj.non_iv_admin_chng_dtls_req_"+rec_count); 
		onco_direct_drug_count=eval("formobj.onco_direct_drug_count_"+rec_count); 
		non_iv_chk=eval("formobj.non_iv_chk_"+rec_count);
		if(parseInt(onco_direct_drug_count.value)>1){
			onco_medn_admin_dtl_reqd_yn=eval("formobj.medn_admn_dtl_reqd"+(parseInt(rec_count)+1)).value;
			obj2=eval("formobj.pat_brought_med_"+(parseInt(rec_count)+1));
		}
	}
	else{
		objMandImage=eval("formobj.drug_remarks_mand_id_"+rec_count); 	
		non_iv_admin_chng_dtls_req=eval("formobj.non_iv_admin_chng_dtls_req_"+rec_count); 
		non_iv_chk=eval("formobj.non_iv_chk_"+rec_count);
	}
	non_iv_sliding_scale=eval("formobj.non_iv_sliding_scale_"+rec_count).value;
	obj1=eval("formobj.pat_brought_med_"+rec_count);
	objText=eval("formobj.non_iv_batch_id_"+rec_count);
	if(pat_lookbut_enabled!='NOT')
		objButton=eval("formobj.non_iv_batch_id_but_"+rec_count);
	objExpiry=eval("formobj.non_iv_expiry_date_"+rec_count);	
	objCal=eval("formobj.exp_dt_cal_"+rec_count);
	objSelect=eval("formobj.chk_non_iv_select_"+rec_count);//NMC-JD-CRF-0186 - [43323]
	if(obj1.checked){
		if(verify_adm_drug=="true"){ // Added for AAKH-CRF-0084 [IN060429]
			eval("formobj.batch_id_mand_"+rec_count).style.visibility="visible"; // Added for AAKH-CRF-0084 [IN060429]
		    eval("formobj.exp_dt_mand_"+rec_count).style.visibility="visible"; // Added for AAKH-CRF-0084 [IN060429]
		}
		objText.disabled=false;
		if(pat_lookbut_enabled!='NOT')
			objButton.disabled=true;		
		obj1.value="Y";
		objMandImage.style='display';
		objCal.style='display';
		objMandImage.style.visibility="visible";
		objExpiry.disabled=false;
		objCal.style.visibility="visible";
		objSelect.disabled=false; //NMC-JD-CRF-0186 - [43323]
		if(non_iv_sliding_scale=="Y"){
			eval("formobj.chk_non_iv_select_"+rec_count).disabled=false;
		}
		if(iv_prep==''){ //added for GHL-CRF-0482 - start
		var isSite_spec_patient_stock = formobj.isSite_spec_patient_stock.value;
			if(isSite_spec_patient_stock=="true"){
				eval("formobj.non_iv_patient_stock_"+rec_count).disabled = true;

				eval("formobj.chk_non_iv_select_"+rec_count).disabled = false;//GHL-CRF-0482
				eval("formobj.patient_brgt_medn_"+rec_count).value = "Y";//GHL-CRF-0482
				
			}//added for GHL-CRF-0482 - end
		}
	}
	else{
		objText.disabled=true;
		if(pat_lookbut_enabled!='NOT' && pat_lookbut_enabled !='N')
			objButton.disabled=false;		
		obj1.value="N";
		
		if(medn_admin_dtl_reqd_yn!="Y" && !(non_iv_chk!=undefined && !(non_iv_chk.checked)) && !(obj2 != undefined &&(obj2.checked)) && (non_iv_admin_chng_dtls_req!=undefined && non_iv_admin_chng_dtls_req.value=='N') && !(onco_medn_admin_dtl_reqd_yn != undefined && onco_medn_admin_dtl_reqd_yn=="Y")){
			objMandImage.style.display="none";
			objMandImage.style.visibility="hidden";
		}		
		objExpiry.disabled=true;
		objCal.style.display="none";
		objSelect.disabled=true; //NMC-JD-CRF-0186 - [43323]
		objCal.style.visibility="hidden";
		if(pat_lookbut_enabled!='NOT'){
			objText.value="";
			objExpiry.value="";
		}
		if(non_iv_sliding_scale=="Y"){
			eval("formobj.chk_non_iv_select_"+rec_count).checked=false; //added by rawther for scf : inc:28432
			eval("formobj.chk_non_iv_select_"+rec_count).disabled=true;
		}
		if((verify_adm_drug=="true") && !eval(document.getElementById("non_iv_shared_drug_"+rec_count)).checked){ // Added for AAKH-CRF-0084 [IN060429]
			eval("formobj.batch_id_mand_"+rec_count).style.visibility="hidden"; // Added for AAKH-CRF-0084 [IN060429]
			eval("formobj.exp_dt_mand_"+rec_count).style.visibility="hidden"; // Added for AAKH-CRF-0084 [IN060429]
		}
		if(iv_prep==''){ //added for GHL-CRF-0482 - start
		var isSite_spec_patient_stock = formobj.isSite_spec_patient_stock.value;
			if(isSite_spec_patient_stock=="true"){
				eval("formobj.non_iv_patient_stock_"+rec_count).disabled = false;
				eval("formobj.chk_non_iv_select_"+rec_count).checked = false; //GHL-CRF-0482
				eval("formobj.chk_non_iv_select_"+rec_count).disabled = true;//GHL-CRF-0482
				eval("formobj.patient_brgt_medn_"+rec_count).value = "N";//GHL-CRF-0482
			}//added for GHL-CRF-0482 - end
		}
	}
}

function ExpiryDateValidationForPatBroughtMedn(obj){
	expDate=obj.value;
	if(expDate!="" && CheckDate(obj)){
	
		splitdate1 =expDate.split("/")
		expDate1=new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]));
		currentday=new Date();
		if(currentday<expDate1){	
			return true;
		}
		else{
			alert(getMessage("PH_EXPDATE_GREATER_SYSDATE","PH"));
			obj.value="";
			return false;
		}
	}
	else {
		return false;
	}
}

function makeDtlsMandatory(obj,row_no,drug_code,from,freq_nature){ //Add freq_nature SKR-SCF-0304[29563]
	var 	formObj = MedicationAdministrationFTDrugDetails;	
	var mand_symbol_obj = "";
	var h_obj ="";
	var img_obj = "";
	var mand_obj = "";
	
	if(from=="iv"){
		mand_symbol_obj=eval("formObj.iv_mand_symbol_"+row_no);
		h_obj=eval("formObj.h_iv_admin_qty_"+row_no);
		iv_order_line_no=eval("formObj.iv_order_line_no_"+row_no).value;
		newreccount=parseInt(row_no)-parseInt(iv_order_line_no)+1
		img_obj=eval("formObj.iv_remarks_mand_id_"+newreccount);
		mand_obj=eval("formObj.iv_admin_chng_dtls_req_"+newreccount);

		//Add this condition for SKR-SCF-0304[29563]
		if(eval("formObj.iv_admin_qty_"+row_no).value=="" ||  eval("formObj.iv_admin_qty_"+row_no).value==0){
			alert(getMessage("PH_NOT_BLANK_ZERO","PH")); 
            eval("formObj.iv_admin_qty_"+row_no).value = eval("formObj.h_iv_admin_qty_"+row_no).value;			 
		}

	}
	else if(from=="alt"){
		mand_symbol_obj=eval("formObj.alt_mand_symbol_"+row_no);
		h_obj=eval("formObj.h_alt_admin_qty_"+row_no);
		img_obj=eval("formObj.alt_drug_remarks_mand_id_"+row_no);
		mand_obj=eval("formObj.alt_admin_chng_dtls_req_"+row_no);
	}
	else if(from=="noniv"){
		var ivPrepYN	= eval("formObj.iv_prep_yn_forNONIV"+row_no).value;
		var non_iv_order_line_no= eval("formObj.non_iv_order_line_no_"+row_no).value;
		var pat_brought_med= eval("formObj.pat_brought_med_"+row_no).value;
		var medn_admn_dtl_reqd=document.getElementById("medn_admn_dtl_reqd"+row_no).value;
		var pat_brought_med_obj_2= eval("formObj.pat_brought_med_"+(parseInt(row_no)+1));
		var medn_admn_dtl_reqd_obj_2=document.getElementById("medn_admn_dtl_reqd"+(parseInt(row_no)+1));
		var pat_brought_med_obj_2;
		var medn_admn_dtl_reqd_obj_2;
		var newRecCount='';
		var nextrowflag=false;
		//Add this conditions for SKR-SCF-0304[29563]		
		if (freq_nature=="P" && (eval("formObj.non_iv_admin_qty1_"+row_no).value=="" ||  eval("formObj.non_iv_admin_qty1_"+row_no).value==0) ){
			 alert(getMessage("PH_NOT_BLANK_ZERO","PH"));	
			 eval("formObj.non_iv_admin_qty1_"+row_no).value = eval("formObj.h_non_iv_admin_qty_"+row_no).value;
		}
		else if(eval("formObj.non_iv_admin_qty_"+row_no).value=="" ||  eval("formObj.non_iv_admin_qty_"+row_no).value==0){
			alert(getMessage("PH_NOT_BLANK_ZERO","PH"));	
            eval("formObj.non_iv_admin_qty_"+row_no).value = eval("formObj.h_non_iv_admin_qty_"+row_no).value;
		}

		if(ivPrepYN=='9' && parseInt(non_iv_order_line_no)>1){
			newRecCount=row_no-parseInt(non_iv_order_line_no)+1;
			var pat_brought_med_obj_2= eval("formObj.pat_brought_med_"+newRecCount);
			var medn_admn_dtl_reqd_obj_2=document.getElementById("medn_admn_dtl_reqd"+newRecCount);
			var obj_2=eval("formObj.non_iv_admin_qty_"+newRecCount);
			var h_obj_2=eval("formObj.h_non_iv_admin_qty_"+newRecCount);
			
			if(obj_2 != undefined && h_obj_2 != undefined && parseFloat(obj_2.value)!= parseFloat(h_obj_2.value)){
					nextrowflag=true;
			}
		}
		else if(ivPrepYN=='9' && parseInt(non_iv_order_line_no)==1){
			newRecCount=row_no;
			onco_direct_drug_count=eval("formObj.onco_direct_drug_count_"+row_no); 
			if(parseInt(onco_direct_drug_count.value)>1){
				var pat_brought_med_obj_2= eval("formObj.pat_brought_med_"+(parseInt(row_no)+1));
				var medn_admn_dtl_reqd_obj_2=document.getElementById("medn_admn_dtl_reqd"+(parseInt(row_no)+1));
				var obj_2=eval("formObj.non_iv_admin_qty_"+(parseInt(row_no)+1));
				var h_obj_2=eval("formObj.h_non_iv_admin_qty_"+(parseInt(row_no)+1));
				
				if(obj_2 != undefined && h_obj_2 != undefined && parseFloat(obj_2.value)!= parseFloat(h_obj_2.value)){
					nextrowflag=true;
				}
			}
		}
		else{
			newRecCount=row_no;
		}
		mand_symbol_obj=eval("formObj.non_iv_mand_symbol_"+row_no);
		h_obj=eval("formObj.h_non_iv_admin_qty_"+row_no);
		img_obj=eval("formObj.drug_remarks_mand_id_"+newRecCount);
		mand_obj=eval("formObj.non_iv_admin_chng_dtls_req_"+newRecCount);
		non_iv_chk=eval("formObj.non_iv_chk_"+newRecCount);
	}
	
/* mand_obj -- hidden variable to indicate whether change admin_details reason is required, not required or already entered
						N -- not required
						Y -- required
						E -- already entered */

	if(parseFloat(obj.value) != parseFloat(h_obj.value)){
		img_obj.style.visibility='visible';
		img_obj.style.display='inline';
		mand_obj.value = "Y";			
	}
	else{
		if(mand_obj!=undefined && mand_obj.value=="E"){
			var bean_id		= formObj.bean_id.value ;
			var bean_name	= formObj.bean_name.value ;
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
	
			xmlStr	="<root><SEARCH " ;
			xmlStr += "row_no=\""+ row_no +"\" " ;
			xmlStr += "drug_code=\""+ drug_code +"\" " ;

			/*if(admn_dose_chng_reason_yn == "Y" || admn_dose_chng_reason_yn == "E"){
				xmlStr += "admn_dose_chng_reason_code=\""+formObj.chngd_admn_dose_reason_code.value+"\" ";	
				xmlStr += "admn_dose_chng_reason=\""+formObj.chngd_admn_dose_reason.value+"\" ";
			}
			else{   
				xmlStr +="admn_dose_chng_reason_code=\"\" ";
				xmlStr +="admn_dose_chng_reason=\"\" ";
			}*/

			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity=deleteRemarksForDrug", false ) ;
			xmlHttp.send( xmlDoc ) ;	
			eval(xmlHttp.responseText);
		}
//this condition is to check whether the mandatory symbol was initially displayed or not
// img_obj --- mandatory symbol image object
		if(from=='noniv'){
			if(ivPrepYN=='9'&& parseInt(non_iv_order_line_no)>1){
				if(pat_brought_med!='Y' && (non_iv_chk!=undefined && non_iv_chk.checked) && medn_admn_dtl_reqd!='Y' && (pat_brought_med_obj_2!= undefined && pat_brought_med_obj_2.value!='Y') && (medn_admn_dtl_reqd_obj_2!= undefined && medn_admn_dtl_reqd_obj_2.value!='Y')  && (obj_2!= undefined && obj_2.value!='Y') && !nextrowflag ){
					img_obj.style.visibility='hidden';
					img_obj.style.display='none'; 									
				}
				if(!nextrowflag)
					mand_obj.value = "N";
			}
			else if(ivPrepYN=='9'&& parseInt(non_iv_order_line_no)==1){
				if(pat_brought_med!='Y' && (non_iv_chk!=undefined && non_iv_chk.checked) && medn_admn_dtl_reqd!='Y' && (pat_brought_med_obj_2!= undefined && pat_brought_med_obj_2.value!='Y') && (medn_admn_dtl_reqd_obj_2!= undefined && medn_admn_dtl_reqd_obj_2.value!='Y')  && (obj_2!= undefined && obj_2.value!='Y') && !nextrowflag ){
					img_obj.style.visibility='hidden';
					img_obj.style.display='none'; 									
				}
				if(!nextrowflag)
					mand_obj.value = "N";	
			}
			else{
				
				if(pat_brought_med!='Y' && medn_admn_dtl_reqd!='Y' && (non_iv_chk!=undefined && non_iv_chk.checked)){
					img_obj.style.visibility='hidden';
					img_obj.style.display='none'; 								
				}
				mand_obj.value = "N";	
			}
		}
		else if(from=='iv'){
			var drug_count_iv=eval("formObj.iv_no_of_drug_per_order_"+row_no).value;
			if(parseInt(drug_count_iv)>1){
				var oldValue;
				var newValue;
				var notEqual=false;
				for(drugIndex=newreccount;drugIndex<(newreccount+parseInt(drug_count_iv));drugIndex++){
					oldValue=eval("formObj.h_iv_admin_qty_"+drugIndex).value;
					newValue=eval("formObj.iv_admin_qty_"+drugIndex).value;
					
					if(parseFloat(oldValue)!=parseFloat(newValue)){
						notEqual=true;
						break;
					}
				}
				if(!notEqual)
					mand_obj.value = "N";
			}
			else{
				mand_obj.value = "N";
			}
		}
	}
}

async function searchReason(chngd_admn_dose_reason, chngd_admn_dose_reason_code){
	
   var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//dataNameArray[0] = "LANGUAGE_ID";
	//dataValueArray[0]= document.getElementById("locale").value;
	//dataTypeArray[0] = STRING;	
	argumentArray[0]   = document.getElementById('ADMIN_DOSAGE_CHNG_REASON_CODES').value+"'"+document.getElementById('locale').value+"'";	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = chngd_admn_dose_reason.value;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	var namelabel=getLabel("ePH.ChangedAdminDosageReason.label",'PH');
	var retVal =await CommonLookup(namelabel, argumentArray );	
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" ) {
		chngd_admn_dose_reason_code.value = arr[0];
		chngd_admn_dose_reason.value = arr[1] ;
	}
	else
		chngd_admn_dose_reason.value = "" ;
}

function mandSymbolDisplayForOncology(flag,record_count,ord_lin_num){
	var formObj =document.MedicationAdministrationFTDrugDetails;
	if(flag=='ONLOAD'){
		var rec_count=parseInt(record_count)-parseInt(ord_lin_num)+1;		
		objMandImage=document.getElementByIdlementById('drug_remarks_mand_id_'+rec_count);
		objMandImage.style.display="inline";				
	}
}

async function linkVaccine(from,rowno, callFrom){
	if(callFrom=='SCH')
		var fObj=document.MedicationAdministrationSchLevelDrugDtls;
	else
		var fObj=document.MedicationAdministrationFTDrugDetails;
	
	if(from=="noniv"){
		var target=eval("fObj.link_vaccine_desc_"+rowno);
		var targetcode=eval("fObj.link_vaccine_code_"+rowno);
		//var targettooltip=eval("fObj.link_vaccine_label_"+rowno);
	}
	else{
		var target=eval("fObj.iv_link_vaccine_desc_"+rowno);
		var targetcode=eval("fObj.iv_link_vaccine_code_"+rowno);
		//var targettooltip=eval("fObj.iv_link_vaccine_label_"+rowno);
	}

	var patient_id=fObj.patient_id.value;	
	var dob=fObj.dob.value;//IN065749

	if(patient_id=="")
		patient_id=fObj.patient_id_selected.value;
	var dialogHeight	= "60vh" ;
	var dialogWidth		= "50vw";
	var dialogTop		= "150" ;
	var dialogLeft		= "350" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	//var retVal = window.showModalDialog("../../eCA/jsp/linkedVaccinescheduleMain.jsp?patient_id="+patient_id+"&vacc_category_link="+targetcode.value,arguments,features);//IN065749
	var retVal = await window.showModalDialog("../../eCA/jsp/linkedVaccinescheduleMain.jsp?patient_id="+patient_id+"&vacc_category_link="+targetcode.value+"&Dob="+dob,arguments,features);//IN065749
	if(retVal != undefined ) {
		if(retVal[0] != undefined ) 
			targetcode.value=retVal[0];
		if(retVal[1] != undefined ) 
			target.value=retVal[1];
		//targettooltip.title=retVal[2];
	}
}

async function openMFRDetails(rowno,drugname,drug_code,Store_locn_code,called_from,order_id, from_time, auto_admin, callFrom,  schCount, schDayCount,fromOldMAR,newMAROncoMFR ){
	var frmObj="";
	if(callFrom!='SCH')
		frmObj=document.MedicationAdministrationFTDrugDetails;
	else
		frmObj=document.MedicationAdministrationSchLevelDrugDtls;
	var dialogHeight	= "400px" ;
	var dialogWidth		= "700px";
	var dialogTop		= "150" ;
	var dialogLeft		= "350" ;
	var center			= "1" ;
	var status			="no";
	var non_iv_mfr		= false;
	if(from_time==undefined)
		from_time		="";
	if(auto_admin==undefined)
		auto_admin		="";
	if(called_from!="MednAdminChart" && callFrom!='SCH'){
		if(fromOldMAR!="Y"){//ML-MMOH-CRF-1014
		var orderId			= eval("frmObj.iv_order_id_"+rowno).value;
		var orderLineNumber	= eval("frmObj.iv_order_line_no_"+rowno).value;	
		//from_time			= frmObj.from_time.value;	
		//auto_admin			= eval("frmObj.non_iv_Auto_Admin_"+rowno).value; //frmObj.Auto_Admin.value; changed for ICN : 27233
		auto_admin			= eval("frmObj.iv_Auto_Admin_"+rowno).value; //non_iv_Auto_Admin_ is changed to  iv_Auto_Admin_ for ML-BRU-SCF-0417 [IN:035080] 
		}else{//ML-MMOH-CRF-1014 - start

			 orderId			= eval("frmObj.non_iv_order_id_"+rowno).value;
			 orderLineNumber	= eval("frmObj.non_iv_order_line_no_"+rowno).value;	
			auto_admin			= eval("frmObj.non_iv_Auto_Admin_"+rowno).value;
			non_iv_mfr			= true;
		}
		from_time			= frmObj.from_time.value;	
	}
	else{
		var orderId	=order_id;
		var orderLineNumber	= "1";
	}
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	returnArray = await window.showModalDialog("../../ePH/jsp/MedicationAdministrationMFRDetails.jsp?orderId="+orderId+"&orderLineNumber="+orderLineNumber+"&drug_code="+drug_code+"&from_time="+from_time+"&called_from="+called_from+"&store_code="+Store_locn_code+"&auto_admin="+auto_admin+"&drug_desc="+drugname,arguments,features);

	if(returnArray!=undefined && (called_from=="NotAdmin" || callFrom=='SCH')){
		var labelToUpdateStatus			= eval(document.getElementById('MFR_status_column_'+rowno));
		var nursing_unit				= frmObj.nursing_unit.value;
		var checkboxToUpdateStatus		= "";
		var nxtScheduledDate			= "";
		var sch_infusion_vol_str_unit	= "";
		if(callFrom!='SCH'){
			if(non_iv_mfr==true)
				 checkboxToUpdateStatus		= eval("frmObj.chk_non_iv_select_"+rowno);
			else
				 checkboxToUpdateStatus		= eval("frmObj.chk_iv_select_"+rowno);
			if(eval("frmObj.next_schd_date_"+rowno))
				nxtScheduledDate			= eval("frmObj.next_schd_date_"+rowno).value;
			if(eval("frmObj.sch_infusion_vol_str_unit_"+rowno))
				sch_infusion_vol_str_unit	= eval("frmObj.sch_infusion_vol_str_unit_"+rowno).value;
		}
		else{
			if(eval("frmObj.next_schd_date_"+rowno+"_"+ schCount+"_"+schDayCount))
			nxtScheduledDate			= eval("frmObj.next_schd_date_"+rowno+"_"+ schCount+"_"+schDayCount).value;
		if(eval("frmObj.sch_infusion_vol_str_unit_"+rowno+"_"+ schCount+"_"+schDayCount))//ML-MMOH-CRF-1014
			sch_infusion_vol_str_unit	= eval("frmObj.sch_infusion_vol_str_unit_"+rowno+"_"+ schCount+"_"+schDayCount).value;
		}
		var obj2		=returnArray[2]
		var bean_id		= "" ;
		var bean_name	= "" ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();				
		xmlStr	="<root><SEARCH " ;	
		xmlStr += "order_id=\""+ returnArray[1] +"\" ";
		xmlStr += "totalNoOfRows=\""+ returnArray[0] +"\" ";
		xmlStr += "store_code=\""+ Store_locn_code +"\" ";
		xmlStr += "drug_code=\""+ drug_code +"\" ";
		xmlStr += "nxtScheduledDate=\""+ nxtScheduledDate +"\" ";		
		xmlStr += "sch_infusion_vol_str_unit=\""+ sch_infusion_vol_str_unit +"\" ";
		xmlStr += "nursing_unit=\""+ nursing_unit +"\" ";
		xmlStr += "callFrom=\""+ callFrom +"\" ";
		if(obj2!=undefined){
			var serialNum=1;
			for(val1=0;val1<obj2.length;val1+=20){				
				xmlStr += "MARStatus"+serialNum+"=\""+ obj2[val1] +"\" " ;
				xmlStr += "srl_no"+serialNum+"=\""+ obj2[val1+1] +"\" " ;
				xmlStr += "holdMinutes"+serialNum+"=\""+ obj2[val1+2] +"\" " ;
				xmlStr += "gaphours"+serialNum+"=\""+ obj2[val1+3] +"\" " ;
				xmlStr += "holdDateTime"+serialNum+"=\""+ obj2[val1+4] +"\" " ;
				xmlStr += "infusion_date_time"+serialNum+"=\""+ obj2[val1+5] +"\" " ;
				xmlStr += "infusion_end_date"+serialNum+"=\""+ obj2[val1+6] +"\" " ;
				xmlStr += "inf_prd"+serialNum+"=\""+ obj2[val1+7] +"\" " ;
				
				xmlStr += "MFR_flow_rate"+serialNum+"=\""+ obj2[val1+8] +"\" " ;
				xmlStr += "MFR_batch_id_"+serialNum+"=\""+ obj2[val1+9] +"\" " ;
				xmlStr += "MFR_exp_dt_"+serialNum+"=\""+ obj2[val1+10] +"\" " ;
				xmlStr += "resumeDateTime"+serialNum+"=\""+ obj2[val1+11] +"\" " ;
				xmlStr += "completedMinutes"+serialNum+"=\""+ obj2[val1+12] +"\" " ;
				xmlStr += "completedFlow"+serialNum+"=\""+ obj2[val1+13] +"\" " ;
				xmlStr += "Newly_Admin_"+serialNum+"=\""+ obj2[val1+14] +"\" " ;
				xmlStr += "iv_trade_id_"+serialNum+"=\""+ obj2[val1+15] +"\" " ;
				xmlStr += "iv_bin_code_"+serialNum+"=\""+ obj2[val1+16] +"\" " ;
				xmlStr += "inf_volume_"+serialNum+"=\""+ obj2[val1+17] +"\" " ;
				xmlStr += "tot_strength_uom"+serialNum+"=\""+ obj2[val1+18] +"\" " ;
				xmlStr += "iv_flow_rate"+serialNum+"=\""+ obj2[val1+19] +"\" " ;
				serialNum++;
			}
		}
		xmlStr += "serialNum=\""+ (serialNum-1) +"\" " ;
		xmlStr +=" /></root>" ;
		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=&bean_name=&identity=updateMFRDetails", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);	
		if( callFrom =='SCH'){
			if(newMAROncoMFR=="Y"){
			var non_iv_MFR_dtls			= eval(document.getElementById('non_iv_MFR_dtls_'+rowno));
			non_iv_MFR_dtls.innerHTML = getLabel("ePH.MFRDetails.label",'PH')+"<br>"+assignMFRStatusString;
			}else{
			var iv_MFR_dtls			= eval(document.getElementById('iv_MFR_dtls_'+rowno));
			iv_MFR_dtls.innerHTML = getLabel("ePH.MFRDetails.label",'PH')+"<br>"+assignMFRStatusString;
			}
		}
		else{
			if(fromOldMAR!="Y"){//ML-MMOH-CRF-1014
			labelToUpdateStatus.innerHTML="<label name='iv_MFR_dtls_"+rowno+"' style='font-size:10;color:blue;cursor:pointer;align:center;' onClick=openMFRDetails('"+rowno+"','"+drugname+"','"+drug_code+"','"+Store_locn_code+"','NotAdmin','');> "+getLabel("ePH.MFRDetails.label",'PH')+"<br>"+assignMFRStatusString+"</label>&nbsp;&nbsp;&nbsp;&nbsp <a href='#'  onMouseOver='changeCursor(this);' onClick=showMFRRemarks('"+eval("frmObj.iv_mfrRemarks"+rowno).value+"'); id='mfrRemarksLink_"+rowno+"'>&nbsp;&nbsp;&nbsp;<font color='red'><b>"+getLabel("ePH.MFRRemarks.label",'PH')+"</b></font></a>";
			}else{//ML-MMOH-CRF-1014
				labelToUpdateStatus			= eval(document.getElementById('non_iv_MFR_status_column_'+rowno));
				
			labelToUpdateStatus.innerHTML="<label name='non_iv_MFR_dtls_"+rowno+"' style='font-size:10;color:blue;cursor:pointer;align:center;' onClick=openMFRDetails('"+rowno+"','"+drugname+"','"+drug_code+"','"+Store_locn_code+"','NotAdmin','','','','','','','Y');> "+getLabel("ePH.MFRDetails.label",'PH')+"<br>"+assignMFRStatusString+"</label>&nbsp;&nbsp;&nbsp;&nbsp <a href='#'  onMouseOver='changeCursor(this);' onClick=showMFRRemarks('"+eval("frmObj.non_iv_mfrRemarks"+rowno).value+"'); id='mfrRemarksLink_"+rowno+"'>&nbsp;&nbsp;&nbsp;<font color='red'><b>"+getLabel("ePH.MFRRemarks.label",'PH')+"</b></font></a>";
			}


			if(enableMFRselect=="true")
				checkboxToUpdateStatus.disabled=false;
		}
	}
	else{
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();				
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=&bean_name=&identity=clearMFRLog", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);	
	}
}

var assignMFRStatusString;
var enableMFRselect;

function assignMFRDetailsToParentWindow(firstvalue,secondvalue){
	assignMFRStatusString=firstvalue
	enableMFRselect = secondvalue
}

function calculateInfusionPeriodMFR(row_num){
	formMFR=document.MedicationAdministrationMFRDetails;
	var locale = formMFR.locale.value;
	var flow_volume=eval("formMFR.inf_volume_"+row_num).value;
	var flow_rate=eval("formMFR.MFR_flow_rate_"+row_num).value;	
	if(flow_rate==""){
		alert(getMessage("PH_ENTER_FLOW_RATE","PH"));
		eval("formMFR.MFR_flow_rate_"+row_num).focus();
		return false;
	}
	else{
		if(parseFloat(eval("formMFR.MFR_flow_rate_"+row_num).value)==0){
			alert(getMessage("PH_ENTER_VALID_FLOW_RATE","PH"));
			eval("formMFR.MFR_flow_rate_"+row_num).focus();
			return false;
		}
	}
	var flowRateDurationUnit=eval("formMFR.flowRateDurationUnit"+row_num).value;	
	var stDate=eval("formMFR.MFR_inf_date_time_"+row_num).value;
	
	var compFlow=eval("formMFR.completedFlow"+row_num).value;
	flow_volume=(parseFloat(flow_volume)-parseFloat(compFlow))+"";
	var compMinutes=eval("formMFR.completedMinutes"+row_num).value;	
	var totNoOfRows=formMFR.totalNoOfRows.value;	
	//var result=(parseFloat(flow_volume)/parseFloat(flow_rate))+parseFloat(parseInt(compMinutes)/60);  //commented "+parseFloat(parseInt(compMinutes)/60)" for SRR20056-SCF-7371 IN027409
	var result=parseFloat(flow_volume)/parseFloat(flow_rate);

	result=Math.round(result*100)/100;
	if(flowRateDurationUnit=="M")
		eval("formMFR.inf_prd"+row_num).value=Math.round((result/60)*100)/100;
	else
		eval("formMFR.inf_prd"+row_num).value=result;
//sri:
	result = (parseFloat(flow_volume)/parseFloat(flow_rate));
	getHrsMinStrMFR(result,eval("formMFR.inf_prd"+row_num).value,flowRateDurationUnit,row_num);
	calcDatesForMFR(row_num,stDate,totNoOfRows);
}

function getHrsMinStrMFR(HMvalue,actualValue,HMunit,rec_count){	
	var objlabel=eval(document.getElementById('sch_inf_per_MFR_'+rec_count));
	var objText =eval("document.MedicationAdministrationMFRDetails.MFR_inf_prd_"+rec_count);
	 if( HMunit == 'H' ) {
		 hrs = Math.floor(HMvalue);
		 HMvalue = HMvalue * 60;
	 } 
	 else {
		 hrs = HMvalue / 60;
	 }
	 min = HMvalue % 60;
	 if(Math.round(min)==60){
         hrs =hrs+1;
		 min=0;
	 }
	 var hh=Math.floor(hrs)+"";
	 var mm=Math.round(min)+"";
	 objlabel.innerText='['+Math.floor(hrs) + ' Hrs ' + Math.round(min) + ' Mins]';
	 if(hh.length==1) hh="0"+hh;
	 if(mm.length==1) mm="0"+mm;
	 objText.value=hh + ':' + mm;

	 if( HMunit == 'H' ) {
		 hrs = Math.floor(actualValue);
		 actualValue = actualValue * 60;
	 } 
	 else {
		 hrs = actualValue / 60;
	 }
	 min = actualValue % 60;
	 if(Math.round(min)==60){
         hrs =hrs+1;
		 min=0;
	 }
	 hh=Math.floor(hrs)+"";
	 mm=Math.round(min)+"";
	 eval("document.MedicationAdministrationMFRDetails.inf_prd_hrs"+rec_count).value=hh;
	 eval("document.MedicationAdministrationMFRDetails.inf_prd_min"+rec_count).value=mm;
}

function displayToolTip(rowcount){	
	var frmObjMFR=document.MedicationAdministrationMFRDetails;
	status1=eval(document.getElementById('FlowStatus'+rowcount)).value;
	currentRow=document.getElementById('currentRowNumber').value;
	if(rowcount!=currentRow)
		return false;
	imgobj="imgArrow"+rowcount;
	obj=eval(document.getElementById('orderctl'+rowcount));
	callMouseOverOnTD(obj,imgobj);
	var val="";
	if(status1=="NS")
		val="ST";
	else if(status1=="ST")
		val="HO,CO";
	else if(status1=="HO")
		val="RE";
	else if(status1=="RE")
		val="HO,CO";	
	buildTable(status1,val,'MFR');
	resizeWindow(obj);
}
var prevObjID;
var prevImgObj;

function callMouseOverOnTD(obj,imgObj){
	if (prevObjID != null && prevObjID != obj.id){			 
		 document.getElementById(prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";			 
	}		 
	 document.getElementById(imgObj).src = "../../eCommon/images/activeArrow.gif";
	prevObjID = obj.id;
	prevImgObj = imgObj;		
}

function buildTable(status,val,callfrom) {
	var rowval   = val.split (",");		
	var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>"
	var descval="";
	for( var i=0; i<rowval.length; i++ ) {
		var colval  = rowval[i]
		if (colval != ""){
			if(colval=="ST")
				descval=getLabel("ePH.START.label",'PH');
			else if(colval=="HO")
				descval=getLabel("ePH.HOLD.label",'PH');
			else if(colval=="RE")
				descval=getLabel("ePH.RESUME.label",'PH');
			else if(colval=="CO")
				descval=getLabel("ePH.COMPLETE.label",'PH');
			
			tab_dat = tab_dat+"<tr>"
			if(callfrom=="MFR")
				tab_dat=tab_dat+ "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);' onClick=callMenuFunctions('"+colval+"');>"+descval+" </td>"
			else
				tab_dat=tab_dat+ "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);' onClick=callMenuFunctionsSFR('"+colval+"','"+callfrom+"');>"+descval+" </td>"
			tab_dat=tab_dat+ "</tr> "
		}
	}
	tab_dat=tab_dat+ "</table> "
	document.getElementById('t').innerHTML = tab_dat
}	
		
function resizeWindow(orderctlHDR){
	var orderctlHDR1 = orderctlHDR.id;		
	var wdth = document.getElementById(orderctlHDR1).offsetWidth;
	var hght1 =document.getElementById(orderctlHDR1).offsetHeight;		
	
	var wdth1 = getPos(orderctlHDR).x +wdth;
	var hght = getPos(orderctlHDR).y ;	

	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight

	var z = bodwidth- (event.x + wdth);	
	
	var x 	  = event.x;
	var y 	  = event.y;	

	x 	  = x + (document.getElementById('tooltiplayer').offsetWidth);
	y 	  = hght + (document.getElementById('tooltiplayer').offsetHeight);	

	if(x<bodwidth){
		x= wdth1;			
	}
	else{			
		x = getPos(orderctlHDR).x;
	}
	if(y<bodheight){			
		y = hght;
	}
	else{
		y = y - (document.getElementById('tooltiplayer').offsetHeight*2) + hght1 ;	
	}
	document.getElementById('tooltiplayer').style.left= x+"px";
	document.getElementById('tooltiplayer').style.top = y+"px";
	document.getElementById('tooltiplayer').style.visibility='visible'
}

function getPos(inputElement){
	var coords =  new Object();
	coords.x = 0;
	coords.y = 0;
	try{
		targetElement = inputElement;
		if(targetElement.x && targetElement.y){
			coords.x = targetElement.x;
			coords.y = targetElement.y;
		}
		else{
			if(targetElement.offsetParent){
				coords.x += targetElement.offsetLeft;
				coords.y += targetElement.offsetTop;
				while(targetElement = targetElement.offsetParent){
					coords.x += targetElement.offsetLeft;
					coords.y += targetElement.offsetTop;
				}
			}
		}
		return coords;
	}
	catch(error){
		return coords;
	}
}
function callOnMouseOut(obj){
	obj.className = 'contextMenuItem';
}
function callMouseOver(obj){
	currClass = obj.className ;
	obj.className = 'selectedcontextMenuItem';
}

function hideToolTip(row){
	obj=document.getElementById('orderctl'+row);
	imgObj="imgArrow"+row;
	dynamichide(obj, window.event,row);
}
function dynamichide(m, e,row)
{
	
	if (!this.isContained(m, e))
	{
		this.delayhidemenu(row)
	}
}
function isContained(m, e)
{

	var e=window.event || e
	var c=e.relatedTarget || ((e.type=="mouseover")? e.fromElement : e.toElement)
	while (c && c!=m)try {c=c.parentNode} catch(e){c=m}
	if (c==m)
		return true
	else
		return false
}
function delayhidemenu(row){

	this.delayhide=setTimeout("hidemenu()", this.disappeardelay) //hide menu
	if(document.getElementById("imgArrow"+row))
		document.getElementById("imgArrow"+row).src = "../../eCommon/images/inactiveArrow.gif";
}
function hidemenu(){
	document.getElementById('tooltiplayer').style.visibility = 'hidden';
}

async function callMenuFunctions(colvalue){
	hidemenu();
	var formMFR=document.MedicationAdministrationMFRDetails;
	var cuRowNo=document.getElementById("currentRowNumber").value;
	var order_id=document.getElementById("order_id").value;
	var drug_desc=document.getElementById("drug_desc").value;
	var locale = formMFR.locale.value;
	var current_date_time="";
	var validateTime1="";
	var validateTime2="";
	var current_date_time="";
	var MFR_flow_rate="";
	var sch_infusion_vol_str_unit_desc=""; // sch_infusion_vol_str_unit chanegd to sch_infusion_vol_str_unit_desc for SKR-SCF-0215 [IN:029303]
	var flowRateDurationUnitDesc="";
	document.getElementById('current_date_time').value=getCurrentDate('DMYHM','en');

	h_iv_admin_qty = "";
	if(eval("formMFR.h_iv_admin_qty_"+cuRowNo) != undefined)
		h_iv_admin_qty = eval("formMFR.h_iv_admin_qty_"+cuRowNo).value;

	if(colvalue=="CO"){
		current_date_time=convertDate(eval("formMFR.MFR_end_date_time_"+cuRowNo).value,"DMYHM",locale,"en");
		validateTime2=document.getElementById('current_date_time').value;
	}
	else if(colvalue=="ST"){
		current_date_time=eval("formMFR.MFR_inf_date_time_"+cuRowNo).value;
		current_date_time=convertDate(current_date_time,"DMYHM",locale,"en");
		if(eval("formMFR.MFR_end_date_time_"+(parseInt(cuRowNo)-1))!=undefined){
			validateTime1=eval("formMFR.MFR_end_date_time_"+(parseInt(cuRowNo)-1)).value;
			validateTime1=convertDate(validateTime1,"DMYHM",locale,"en");
		}
		else{
			if(formMFR.from_time!=undefined)
				validateTime1=formMFR.from_time.value;
		}
		validateTime2=document.getElementById('current_date_time').value;		
	}
	else if(colvalue=="RE"){
		prevHoldTime=eval("formMFR.holdDateTime"+cuRowNo).value;
		if(prevHoldTime!="")
			validateTime1=prevHoldTime;
		else{
			validateTime1= eval("formMFR.MFR_inf_date_time_"+cuRowNo).value;
			validateTime1=convertDate(validateTime1,"DMYHM",locale,"en");
		}
		current_date_time=document.getElementById('current_date_time').value;
		validateTime2= document.getElementById('current_date_time').value;
		
		MFR_flow_rate=eval("formMFR.MFR_flow_rate_"+cuRowNo).value;
		flowRateDurationUnitDesc=eval("formMFR.flowRateDurationUnitDesc"+cuRowNo).value;
		//infusion_vol_str_unit=eval("formMFR.infusion_vol_str_unit"+cuRowNo).value; //commented for SKR-SCF-0215 [IN:029303]
		sch_infusion_vol_str_unit_desc=encodeURIComponent(eval("formMFR.infusion_vol_str_unit_desc"+cuRowNo).value); // infusion_vol_str_unit chanegd to infusion_vol_str_unit_desc for SKR-SCF-0215 [IN:029303]
	}
	else if(colvalue=="HO"){
		prevResumedTime=eval("formMFR.resumeDateTime"+cuRowNo).value;		
		if(prevResumedTime!="")
			validateTime1=prevResumedTime;
		else{
			validateTime1= eval("formMFR.MFR_inf_date_time_"+cuRowNo).value;	
			validateTime1=convertDate(validateTime1,"DMYHM",locale,"en");
		}
		current_date_time=document.getElementById('current_date_time').value;
		validateTime2= eval("formMFR.MFR_end_date_time_"+cuRowNo).value;
		validateTime2=convertDate(validateTime2,"DMYHM",locale,"en");
	}
	var totNoOfRows=document.getElementById("totalNoOfRows").value;
	var srl_no=eval(document.getElementById("srl_no"+cuRowNo)).value;		
	var dialogWidth	= "700px" ;
	var dialogHeight= "400px" ;
	var dialogTop = "10" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var returnvalues= await window.showModalDialog("../../ePH/jsp/MedicationAdministrationFTMFRRemarks.jsp?linkValue="+colvalue+"&current_date_time="+current_date_time+"&validateTime1="+validateTime1+"&validateTime2="+validateTime2+"&MFR_flow_rate="+MFR_flow_rate+"&flowRateDurationUnitDesc="+flowRateDurationUnitDesc+"&sch_infusion_vol_str_unit_desc="+sch_infusion_vol_str_unit_desc+"&drugdesc="+drug_desc+"&h_iv_admin_qty="+h_iv_admin_qty,arguments,features);	 //// sch_infusion_vol_str_unit chanegd to sch_infusion_vol_str_unit_desc for SKR-SCF-0215 [IN:029303]
	
	if(returnvalues != undefined ){
		var returnStatusString="";
		var returnedAdminId =returnvalues[1];
		var returnedDate =returnvalues[2];
		var returnedRemarks =returnvalues[3];
		if(returnedRemarks!=null && !(returnedRemarks=="")){
			returnedRemarks = encodeURIComponent(returnedRemarks);
		}
		var returnedMFR_flow_rate="";
		if(returnvalues[0]=="ST"){	
			var localeReturnedDate=convertDate(returnedDate,"DMYHM","en",locale)
			returnStatusString=getLabel("ePH.STARTED.label",'PH');
			returnStatus="ST";
			eval("formMFR.MFR_inf_date_time_"+cuRowNo).value=localeReturnedDate;
			eval("formMFR.MFR_flow_rate_"+cuRowNo).disabled=true;
			calcDatesForMFR(cuRowNo,localeReturnedDate,totNoOfRows);
		}
		else if(returnvalues[0]=="HO"){
			returnStatusString=getLabel("ePH.HOLD.label",'PH');
			returnStatus="HO";
			eval("formMFR.holdDateTime"+cuRowNo).value=returnedDate;
			CalculateCompletedFlowOnHoldMFR(cuRowNo, returnedDate ); //Added for SRR20056-SCF-7137.1 IN027409
			calculateInfusionPeriodMFR(cuRowNo);		//Added for SRR20056-SCF-7137.1 IN028154, PH-Incident No.# 28218						
		}
		else if(returnvalues[0]=="RE"){
			returnedMFR_flow_rate=returnvalues[4];
			returnStatusString=getLabel("ePH.RESUMED.label",'PH');
			returnStatus="RE";
			eval("formMFR.resumeDateTime"+cuRowNo).value=returnedDate;
			var holdedMinutes=eval("formMFR.holdMinutes"+cuRowNo).value;
			var holdedDuration=minutesBetween(eval("formMFR.holdDateTime"+cuRowNo).value,returnedDate,"DMYHM",locale)
			eval("formMFR.holdMinutes"+cuRowNo).value=parseInt(holdedMinutes)+parseInt(holdedDuration);
			//if(returnedMFR_flow_rate!=MFR_flow_rate){ // if condition & its else part are commented for SRR20056-SCF-7371 IN027409
				eval("formMFR.MFR_flow_rate_"+cuRowNo).value=returnedMFR_flow_rate;
				CalculateCompletedFlowOnChangeOfFlowRate(cuRowNo,MFR_flow_rate,returnedDate);
				calculateInfusionPeriodMFR(cuRowNo);								
			/*}
			else	{	
				calcDatesForMFR(cuRowNo,eval("formMFR.MFR_inf_date_time_"+cuRowNo).value,totNoOfRows);
			}*/
		}
		else if(returnvalues[0]=="CO"){
			returnStatusString=getLabel("ePH.COMPLETED.label",'PH');
			returnStatus="CO";
			var newcuRowNo=parseInt(cuRowNo)+1;
			document.getElementById('currentRowNumber').value=newcuRowNo;
			if(eval(document.getElementById('orderctl'+newcuRowNo))!=undefined){
				var newflowstatus=eval(document.getElementById('FlowStatus'+newcuRowNo)).value
					if(newflowstatus=="NS")
						newflowstatus="NOT STARTED";
					else
						newflowstatus="";
				eval(document.getElementById('orderctl'+newcuRowNo)).innerHTML="<B><label style='font-size:10;color:blue;align:center;'>"+newflowstatus+"</label></B><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+newcuRowNo+"' id='imgArrow"+newcuRowNo+"'>";
				eval(document.getElementById('MFR_flow_rate_'+newcuRowNo)).disabled=false;
				if(eval("formMFR.batch_id"+newcuRowNo).value==""){	
					if(eval("formMFR.MFR_batch_id_but_"+newcuRowNo)!=undefined){
						if(formMFR.auto_admin.value!="N"){
							eval("formMFR.MFR_batch_id_but_"+newcuRowNo).disabled=false;
						}
					}
					else{
						eval("formMFR.MFR_batch_id_"+newcuRowNo).disabled=false;
					}
				}
				eval("formMFR.MFR_flow_rate_"+newcuRowNo).disabled=false;
			}
		}
		eval(document.getElementById('FlowStatus'+cuRowNo)).value=returnStatus;
		if(returnStatus!="CO"){
			eval(document.getElementById('orderctl'+cuRowNo)).innerHTML="<B><label style='font-size:10;color:blue;align:center;'>"+returnStatusString+"</label></B><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+cuRowNo+"' id='imgArrow"+cuRowNo+"'>";
		}
		else{
			
			eval(document.getElementById('orderctl'+cuRowNo)).innerHTML="<B><label style='font-size:10;align:center;'>"+returnStatusString+"</label></B><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+cuRowNo+"' id='imgArrow"+cuRowNo+"'>";
			eval(document.getElementById('MFR_flow_rate_'+cuRowNo)).disabled=true;
			if(eval("formMFR.MFR_batch_id_but_"+cuRowNo)!=undefined){
				eval(document.getElementById('MFR_batch_id_but_'+cuRowNo)).disabled=true;
			}
			else{
				eval(document.getElementById('MFR_batch_id_'+cuRowNo)).disabled=true;
			}
		}

		var bean_id		= "" ;
		var bean_name	= "" ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();				
		xmlStr	="<root><SEARCH " ;		
		xmlStr += "iv_flow_rate=\""+eval("formMFR.MFR_flow_rate_"+cuRowNo).value+"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=&bean_name=&identity=updateMFR&order_id="+order_id+"&srl_no="+srl_no+"&mfr_status="+returnStatus+"&actionBy="+returnedAdminId+"&actionTime="+returnedDate+"&actionRemarks="+returnedRemarks, false ) ;
		xmlHttp.send( xmlDoc );
		eval(xmlHttp.responseText);	
	}
}

async function searchUser(target,objIdentify){	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray[0] = "LANGUAGE_ID";
	dataValueArray[0]= document.getElementById('locale').value;
	dataTypeArray[0] = STRING;	
	argumentArray[0]   = document.getElementById('SQL_PH_MED_ADMIN_APPL_USERS').value;	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	var namelabel="";
	if(objIdentify=='HO')
		namelabel=getLabel("Common.Hold.label",'Common')+" "+getLabel("ePH.By.label",'PH');
	else if(objIdentify=='RE')
		namelabel=getLabel("ePH.Resume.label",'PH')+" "+getLabel("ePH.By.label",'PH');
	else if(objIdentify=='CO')
		namelabel=getLabel("Common.complete.label",'Common')+" "+getLabel("ePH.By.label",'PH');
	else
		namelabel=getLabel("Common.Start.label",'Common')+" "+getLabel("ePH.By.label",'PH');
	var retVal =await CommonLookup(namelabel, argumentArray );	
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" ){
		target.value = arr[1] ;
		//target.disabled=true;
		document.getElementById("administered_by_id").value = arr[0] ;
	}
	else{ //else condition added for IN24890 --15/11/2010-- priya
		target.value = "";
		document.getElementById("administered_by_id").value = "";
	}
}

function calcDatesForMFR(curRowNumber,stDate,totNoOfRows){
	currentRowNumber=parseInt(curRowNumber);
	var startdate=stDate;
	totalNoOfRows=parseInt(totNoOfRows);
	var frmObjMfr=document.MedicationAdministrationMFRDetails;
	var locale = frmObjMfr.locale.value;	
	for(index=currentRowNumber;index<totalNoOfRows;index++){
		if(eval("frmObjMfr.MFR_end_date_time_"+index)!=undefined){
			if(index!=currentRowNumber){
				eval("frmObjMfr.MFR_inf_date_time_"+index).value=startdate;
			}
			var holdMinutes=eval("frmObjMfr.holdMinutes"+index).value;
			var inf_hrs=eval("frmObjMfr.inf_prd_hrs"+index).value;
			var inf_min=eval("frmObjMfr.inf_prd_min"+index).value;			
			inf_in_mins=parseInt(inf_min)+(parseInt(inf_hrs)*60);
			var totalMins=inf_in_mins+parseInt(holdMinutes);
			var endDate=plusDate(startdate,'DMYHM',locale,totalMins,'m');	

			eval("frmObjMfr.MFR_end_date_time_"+index).value=endDate;
			var gaphours1=eval("frmObjMfr.gaphours"+index).value;
			var gaphours=Math.round(parseFloat(gaphours1)*60);
			startdate = plusDate(endDate,'DMYHM',locale,gaphours,'m');
		}
	}
}

async function openAuditLogWindow(rowNo,from, callFrom, dosage_seq_no, schCount,iv_sch_date_tim,sch_infusion_per_unit_table_data,sch_inf_vol_str_unit_desc){	// Modified for IN073378

	var flowRateDurationUnitDesc="";
	var sch_infusion_vol_str_unit_desc="";
	if(from!=undefined && from=="SFR"){
		if(callFrom!='SCH'){
			var frmObjSfr=document.MedicationAdministrationFTDrugDetails;
			srlNo=eval("frmObjSfr.iv_dosage_seq_no_"+rowNo).value;
			sch_date_time=eval("frmObjSfr.iv_admin_date_time_"+rowNo).value;
			flowRateDurationUnitDesc=eval("frmObjSfr.sch_infusion_per_unit_"+rowNo).value;
			sch_infusion_vol_str_unit_desc=encodeURIComponent(eval("frmObjSfr.sch_infusion_vol_str_unit_desc"+rowNo).value); 
		}
		else{
			var frmObjSfr=document.MedicationAdministrationSchLevelDrugDtls;
			var drugCount = 1;
			// Modified for IN073378 start
			if(eval("frmObjSfr.iv_dosage_seq_no_"+rowNo+"_"+schCount+"_"+dosage_seq_no+"_"+drugCount) !=undefined){
			srlNo=eval("frmObjSfr.iv_dosage_seq_no_"+rowNo+"_"+schCount+"_"+dosage_seq_no+"_"+drugCount).value;
			}
			else{
				srlNo=dosage_seq_no;
			}
			if(eval("frmObjSfr.iv_sch_date_tim_"+rowNo+"_"+schCount+"_"+dosage_seq_no+"_"+drugCount) !=undefined){
			sch_date_time=eval("frmObjSfr.iv_sch_date_tim_"+rowNo+"_"+schCount+"_"+dosage_seq_no+"_"+drugCount).value;
			}
			else{
				sch_date_time=iv_sch_date_tim;
			}
			if(eval("frmObjSfr.sch_infusion_per_unit_"+rowNo+"_"+schCount+"_"+dosage_seq_no+"_"+drugCount) !=undefined){
			flowRateDurationUnitDesc=eval("frmObjSfr.sch_infusion_per_unit_"+rowNo+"_"+schCount+"_"+dosage_seq_no+"_"+drugCount).value;
			}
			else{
				flowRateDurationUnitDesc=sch_infusion_per_unit_table_data;
			}
			if(eval("frmObjSfr.sch_infusion_vol_str_unit_desc"+rowNo+"_"+schCount+"_"+dosage_seq_no+"_"+drugCount) !=undefined){
			sch_infusion_vol_str_unit_desc=encodeURIComponent(eval("frmObjSfr.sch_infusion_vol_str_unit_desc"+rowNo+"_"+schCount+"_"+dosage_seq_no+"_"+drugCount).value); 
			}
			else{
				sch_infusion_vol_str_unit_desc=encodeURIComponent(sch_inf_vol_str_unit_desc);
			}
			// Modified for IN073378 end
		}
		orderId=eval("frmObjSfr.iv_order_id_"+rowNo).value;
	}
	else{
		var frmObjMfr=document.MedicationAdministrationMFRDetails;
		orderId=frmObjMfr.order_id.value;
		srlNo=eval("frmObjMfr.srl_no"+rowNo).value;
		sch_date_time="";
	}
	if(flowRateDurationUnitDesc=="H")
		flowRateDurationUnitDesc="Hrs";
	else
		flowRateDurationUnitDesc="Min";
	
	var dialogWidth	= "50vw" ;
	var dialogHeight= "50vh" ;
	var dialogTop = "0" ;
	var dialogLeft		= "0";
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; dialogLeft :" + dialogLeft;
	var arguments	= "" ;
	var returnvalues= await top.window.showModalDialog("../../ePH/jsp/MedicationAdministrationFTMFRAuditLog.jsp?flow_rate_sl_no="+srlNo+"&orderId="+orderId+"&sch_date_time="+sch_date_time+"&sch_infusion_vol_str_unit_desc="+sch_infusion_vol_str_unit_desc+"&flowRateDurationUnitDesc="+flowRateDurationUnitDesc,arguments,features);	
}

function calcQuantityInDispensingUOM(iv,row_no){
	var frmObj=document.MedicationAdministrationFTDrugDetails;
	if(iv=="NONIV")	{
		order_id=eval("frmObj.non_iv_order_id_"+row_no).value;
		drug_code=eval("frmObj.non_iv_drug_code_"+row_no).value;
		admin_qty=eval("frmObj.non_iv_admin_qty_"+row_no).value;
		admin_qty_uom=eval("frmObj.non_iv_admin_qty_uom_"+row_no).value;
		order_line_no=eval("frmObj.non_iv_order_line_no_"+row_no).value;
		dosage_type=eval("frmObj.non_iv_dosage_type_"+row_no).value;
	}
	else if(iv=='IVSCH'){
		var frmObj=document.MedicationAdministrationFTMFRRemarks;
		order_id=eval("frmObj.order_id").value;
		drug_code=eval("frmObj.drug_code").value;
		admin_qty=eval("frmObj.iv_admin_qty").value;
		admin_qty_uom=eval("frmObj.iv_qty_uom").value;
		order_line_no=eval("frmObj.order_line_num").value;
		dosage_type=eval("frmObj.iv_dosage_type").value;
	}
	else{
		order_id=eval("frmObj.iv_order_id_"+row_no).value;
		drug_code=eval("frmObj.iv_drug_code_"+row_no).value;
		admin_qty=eval("frmObj.iv_admin_qty_"+row_no).value;
		admin_qty_uom=eval("frmObj.iv_qty_uom_"+row_no).value;
		order_line_no=eval("frmObj.iv_order_line_no_"+row_no).value;
		dosage_type=eval("frmObj.iv_dosage_type_"+row_no).value;
	}
	var bean_id		= "" ;
	var bean_name	= "" ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();				
	xmlStr	="<root><SEARCH " ;		
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=&bean_name=&identity=calcQtyInDispUOM&drug_code="+drug_code+"&qty="+admin_qty+"&qtyUom="+admin_qty_uom+"&prescribeMode="+dosage_type+"&order_id="+order_id+"&order_line_no="+order_line_no+"&iv="+iv+"&row_no="+row_no, false ) ;
	xmlHttp.send( xmlDoc );
	eval(xmlHttp.responseText);	
}

function AssignQuantityInDispensingMode(val1,iv,row_no){
	
	if(iv=='IVSCH'){
		var frmObj=document.MedicationAdministrationFTMFRRemarks;
		eval("frmObj.iv_qty_in_disp_mode").value=val1;
	}
	else{
		var frmObj=document.MedicationAdministrationFTDrugDetails;
		if(iv=="NONIV")	
			eval("frmObj.non_iv_qty_in_disp_mode_"+row_no).value=val1;
		
		else
			eval("frmObj.iv_qty_in_disp_mode_"+row_no).value=val1;
	}
}

async function showMFRRemarks(mfr_remarks,mfr_yn){
	var dialogTop		= "400";
	var dialogHeight	= "40vh";
	var dialogWidth		= "60vw";
	var dialogLeft		= "500";
	var features		= "Width:" + dialogWidth + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogLeft:" + dialogLeft +"; dialogTop:" + dialogTop +"; scroll=NO; status=no";
	var arguments		= "";
	var retVal 			= await window.showModalDialog("../jsp/IVPrescriptionMFRRemarks.jsp?read_property=readonly&mfr_yn="+mfr_yn+"&mfr_remarks="+mfr_remarks,arguments,features);		
}

function CalculateCompletedFlowOnChangeOfFlowRate(cuRowNo,previous_flow_rate,resumed_date_time, callFrom){
	var formMFR=document.MedicationAdministrationMFRDetails;
	var locale = formMFR.locale.value;
	var start_date_time=convertDate(eval("formMFR.MFR_inf_date_time_"+cuRowNo).value,"DMYHM",locale,"en");
	var holded_time_in_min=eval("formMFR.holdMinutes"+cuRowNo).value;
	var flowRateDurationUnit=eval("formMFR.flowRateDurationUnit"+cuRowNo).value;
	var completedMinutes=eval("formMFR.completedMinutes"+cuRowNo).value;
	var completedFlow=eval("formMFR.completedFlow"+cuRowNo).value;
	var total_running_mints=minutesBetween(start_date_time,resumed_date_time,"DMYHM",locale)
		
	total_running_mints=total_running_mints-(parseInt(holded_time_in_min)+parseInt(completedMinutes));
	if(flowRateDurationUnit=="H"){
		completed_flow=parseFloat(previous_flow_rate)*(total_running_mints/60);
	}
	else{
		completed_flow=parseFloat(previous_flow_rate)*total_running_mints;
	}
	eval("formMFR.completedMinutes"+cuRowNo).value=parseInt(completedMinutes)+total_running_mints;
	eval("formMFR.completedFlow"+cuRowNo).value=parseFloat(completedFlow)+completed_flow;
}

//function CalculateCompletedFlowOnHold(cuRowNo,holded_date_time) Added for SRR20056-SCF-7371 IN027409
function CalculateCompletedFlowOnHold(cuRowNo,holded_date_time, callFrom){
	if(callFrom!='SCH')
		var formMain=document.MedicationAdministrationFTDrugDetails;
	else
		var formMain=document.MedicationAdministrationSchLevelDrugDtls;
	var locale = formMain.locale.value;
	var resumed_date_time = convertDate(eval("formMain.sfrRESUME_DATE_TIME"+cuRowNo).value,"DMYHM",locale,"en");
	var start_date_time=convertDate(eval("formMain.iv_infusion_st_time_"+cuRowNo).value,"DMYHM",locale,"en");
	var flowRateDurationUnit=eval("formMain.sch_infusion_per_unit_"+cuRowNo).value;
	var completedMinutes=parseInt(eval("formMain.completedMinutes"+cuRowNo).value);
	var completedFlow=parseFloat(eval("formMain.completedFlow"+cuRowNo).value);
	var flow_rate=eval("formMain.iv_flow_rate_"+cuRowNo).value;
	if(resumed_date_time == undefined || resumed_date_time == "")
		resumed_date_time = start_date_time;
	var current_running_mints=minutesBetween(resumed_date_time,holded_date_time,"DMYHM",'en')//locale

	if(flowRateDurationUnit=="H"){
		completed_flow=parseFloat(completedFlow) + parseFloat(flow_rate)*(parseFloat(current_running_mints)/60);
	}
	else{
		completed_flow=parseFloat(completedFlow) + parseFloat(flow_rate)*parseFloat(current_running_mints);
	}
	completedMinutes += parseInt(current_running_mints);
	eval("formMain.completedMinutes"+cuRowNo).value=completedMinutes;
	eval("formMain.completedFlow"+cuRowNo).value=completed_flow;
}
//Added for SRR20056-SCF-7371 IN027409 - END

//function CalculateCompletedFlowOnHoldMFR(cuRowNo,holded_date_time) Added for SRR20056-SCF-7137.1 IN028154, PH-Incident No.# 28218 (SRR20056-SCF-7371 IN027409) -Start

function CalculateCompletedFlowOnHoldMFR(cuRowNo,holded_date_time, callFrom){
	if(callFrom!='SCH')
		var formMain=document.MedicationAdministrationMFRDetails;
	else
		var formMain=document.MedicationAdministrationSchLevelDrugDtls;
	var locale = formMain.locale.value;
	var resumed_date_time = convertDate(eval("formMain.resumeDateTime"+cuRowNo).value,"DMYHM",locale,"en");
	var start_date_time=convertDate(eval("formMain.MFR_inf_date_time_"+cuRowNo).value,"DMYHM",locale,"en");
	var flowRateDurationUnit=eval("formMain.infusionPeriodUnit"+cuRowNo).value;
	var completedMinutes=parseInt(eval("formMain.completedMinutes"+cuRowNo).value);
	var completedFlow=parseFloat(eval("formMain.completedFlow"+cuRowNo).value);
	var flow_rate=eval("formMain.MFR_flow_rate_"+cuRowNo).value;
	
	if(resumed_date_time == undefined || resumed_date_time == "")
		resumed_date_time = start_date_time;
	var current_running_mints=minutesBetween(resumed_date_time,holded_date_time,"DMYHM",locale)

	if(flowRateDurationUnit=="H"){
		completed_flow=parseFloat(completedFlow) + parseFloat(flow_rate)*(parseFloat(current_running_mints)/60);
	}
	else{
		completed_flow=parseFloat(completedFlow) + parseFloat(flow_rate)*parseFloat(current_running_mints);
	}
	completedMinutes += parseInt(current_running_mints);
	eval("formMain.completedMinutes"+cuRowNo).value=completedMinutes;
	eval("formMain.completedFlow"+cuRowNo).value=completed_flow;
}
//function CalculateCompletedFlowOnHoldMFR(cuRowNo,holded_date_time) Added for SRR20056-SCF-7137.1 IN028154, PH-Incident No.# 28218 (SRR20056-SCF-7371 IN027409) - END

function CalculateCompletedFlowOnChangeOfFlowRateSFR(cuRowNo,previous_flow_rate,resumed_date_time, calledFrom){
	if(calledFrom!='SCH')
		var formMain=document.MedicationAdministrationFTDrugDetails;
	else
		var formMain=document.MedicationAdministrationSchLevelDrugDtls;
	var locale = formMain.locale.value;
	var start_date_time=convertDate(eval("formMain.iv_infusion_st_time_"+cuRowNo).value,"DMYHM",locale,"en");
	var holded_time_in_min=eval("formMain.sfrHOLD_DURN_IN_MINS"+cuRowNo).value;
	var flowRateDurationUnit=eval("formMain.sch_infusion_per_unit_"+cuRowNo).value;
	var completedMinutes=eval("formMain.completedMinutes"+cuRowNo).value;
	var completedFlow=eval("formMain.completedFlow"+cuRowNo).value;
	var total_running_mints=minutesBetween(start_date_time,resumed_date_time,"DMYHM",'en')//locale

	total_running_mints=total_running_mints-(parseInt(holded_time_in_min)+parseInt(completedMinutes));

	if(flowRateDurationUnit=="H"){
		completed_flow=parseFloat(previous_flow_rate)*(total_running_mints/60);
	}
	else{
		completed_flow=parseFloat(previous_flow_rate)*total_running_mints;
	}
	eval("formMain.completedMinutes"+cuRowNo).value=parseInt(completedMinutes)+total_running_mints;
	eval("formMain.completedFlow"+cuRowNo).value=parseFloat(completedFlow)+completed_flow;
}

async function callMenuFunctionsSFR(colvalue,row){  
	hidemenu();
	var formMain=document.MedicationAdministrationFTDrugDetails;
	var iv_prep_yn=eval("formMain.iv_prep_yn"+row).value;
	var order_id=eval("formMain.iv_order_id_"+row).value;
	var drug_desc=eval("formMain.iv_drug_desc"+row).value;
	var srl_no=eval("formMain.iv_dosage_seq_no_"+row).value;
	var MFR_flow_rate=eval("formMain.iv_flow_rate_"+row).value;
	var iv_sch_admin_date_time=eval("formMain.iv_admin_date_time_"+row).value;
	var flowRateDurationUnitDesc1=eval("formMain.sch_infusion_per_unit_"+row).value;
	var locale = formMain.locale.value;
	var flow_rate_changed_YN = "N";
	var h_iv_admin_qty = eval("formMain.h_iv_admin_qty_"+row).value;
	iv_sch_admin_date_time=convertDate(iv_sch_admin_date_time,'DMYHM',locale,"en");	
	
	if(flowRateDurationUnitDesc1=="H")
		flowRateDurationUnitDesc="Hrs";
	else
		flowRateDurationUnitDesc="Min";
	//var infusion_vol_str_unit=eval("formMain.sch_infusion_vol_str_unit_"+row).value; //commented for SKR-SCF-0215 [IN:029303] 
	var sch_infusion_vol_str_unit_desc=encodeURIComponent(eval("formMain.sch_infusion_vol_str_unit_desc"+row).value); // sch_infusion_vol_str_unit chanegd to sch_infusion_vol_str_unit_desc for SKR-SCF-0215 [IN:029303]
	
	formMain.current_date_time.value=getCurrentDate('DMYHM','en');

	var validateTime1 ="";
	var validateTime2 ="";
	if(colvalue=="CO"){
		current_date_time=eval("formMain.sfrACT_END_DATE_TIME"+row).value;
//		current_date_time=convertDate(current_date_time,'DMYHM',locale,"en");
		validateTime2=formMain.current_date_time.value;
	}
	else if(colvalue=="ST"){		
		current_date_time=eval("formMain.iv_infusion_st_time_"+row).value;
		current_date_time=convertDate(current_date_time,'DMYHM',locale,"en")
		validateTime1=formMain.from_time.value;	
		//validateTime2=convertDate(formMain.current_date_time.value,'DMYHM',"en",locale);
		validateTime2=formMain.current_date_time.value;
	}
	else{
		prevHoldTime=eval("formMain.sfrHOLD_DATE_TIME"+row).value;
		prevResumedTime=eval("formMain.sfrRESUME_DATE_TIME"+row).value;
		if(colvalue=="RE" && prevHoldTime!="")
			validateTime1=prevHoldTime;
		else if(colvalue=="HO" && prevResumedTime!="")
			validateTime1=prevResumedTime;
		else{
			validateTime1= eval("formMain.iv_infusion_st_time_"+row).value	
			validateTime1=convertDate(validateTime1,'DMYHM',locale,"en")
		}
		current_date_time=formMain.current_date_time.value;

		if(colvalue=="RE"){
			validateTime2= formMain.current_date_time.value;
		}
		else{
			validateTime2= document.getElementById("sfrACT_END_DATE_TIME"+row).value;		
			if(!isBefore(validateTime2,current_date_time,"DMYHM",'en'))//locale
				validateTime2=current_date_time;	
		}	
	}
	var dialogWidth	= "30vw" ;
	var dialogHeight= "55vh" ;
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var holdMinutes=eval("formMain.sfrHOLD_DURN_IN_MINS"+row).value;
	var inf_hrs=eval("formMain.inf_prd_hrs"+row).value;
	var inf_min=eval("formMain.inf_prd_min"+row).value;

	var returnvalues= await window.showModalDialog("../../ePH/jsp/MedicationAdministrationFTMFRRemarks.jsp?linkValue="+colvalue+"&current_date_time="+current_date_time+"&validateTime1="+validateTime1+"&validateTime2="+validateTime2+"&MFR_flow_rate="+MFR_flow_rate+"&flowRateDurationUnitDesc="+flowRateDurationUnitDesc+"&sch_infusion_vol_str_unit_desc="+sch_infusion_vol_str_unit_desc+"&h_iv_admin_qty="+h_iv_admin_qty+"&drugdesc="+encodeURIComponent(drug_desc,"UTF-8")+"&sch_date_time="+iv_sch_admin_date_time+"&iv_prep_yn="+iv_prep_yn,arguments,features);	//added for SCF-7528 // sch_infusion_vol_str_unit chanegd to sch_infusion_vol_str_unit_desc for SKR-SCF-0215 [IN:029303]

	if(returnvalues != undefined ) {
		var returnStatusString="";
		var returnStatus=returnvalues[0];
		var returnedAdminId =returnvalues[1];
		var returnedDate =returnvalues[2];
		var returnedRemarks =returnvalues[3];
		eval("formMain.sfrFLOW_STATUS"+row).value=returnStatus;
		if(returnStatus=="ST"){
			returnStatusString=getLabel("ePH.STARTED.label",'PH');			
			eval("formMain.iv_infusion_st_time_"+row).value=convertDate(returnedDate,"DMYHM","en",locale);
			eval("formMain.iv_infusion_st_time_"+row).disabled=true;
			eval("formMain.iv_admin_qty_"+row).disabled=true;
			eval("formMain.iv_flow_rate_"+row).disabled=true;
			eval("formMain.chk_iv_select_"+row).disabled=true;
			calcDatesForSFR(returnedDate,row);
		}
		else if(returnStatus=="HO"){
			returnStatusString=getLabel("ePH.HOLD.label",'PH');
			eval("formMain.sfrHOLD_DATE_TIME"+row).value=returnedDate;
			CalculateCompletedFlowOnHold(row, returnedDate );//Added for SRR20056-SCF-7371 IN027409 -Start
			changeDisplay(eval("formMain.iv_flow_rate_"+row),row,flowRateDurationUnitDesc1);
			getHrsMinStr('TAKE',eval("formMain.sch_infusion_period_unit_"+row).value,row);//Added for SRR20056-SCF-7371 IN027409 -End
		}
		else if(returnStatus=="RE"){
			returnStatusString=getLabel("ePH.RESUMED.label",'PH');
			returnedFlowRate=returnvalues[4];
			eval("formMain.sfrRESUME_DATE_TIME"+row).value=returnedDate;//convertDate(returnedDate,"DMYHM","en",locale);;
			var holdedMinutes=eval("formMain.sfrHOLD_DURN_IN_MINS"+row).value;

			if(returnedFlowRate != eval("formMain.iv_flow_rate_"+row).value)
				flow_rate_changed_YN = "Y";
			
// take value b/w start date time and hold date time to get the duration administered before holding:// new field added durn_bw_std_resumed for SRR UAT3 : sri
// converting iv_infusion_st_time_ from location to english to calculate duration properly

			eng_st_time = convertDate(eval("formMain.iv_infusion_st_time_"+row).value,"DMYHM",locale,"en");

			var already_administered_duration=minutesBetween(eng_st_time,eval("formMain.sfrHOLD_DATE_TIME"+row).value,"DMYHM",'en'); //locale //sri
			var holdedDuration=minutesBetween(eval("formMain.sfrHOLD_DATE_TIME"+row).value,returnedDate,"DMYHM",'en'); //locale
			// new var durn_bw_std_resumed for SRR UAT3 : sri
			var durn_bw_std_resumed = parseInt(holdedDuration) +  parseInt(already_administered_duration)+parseInt(holdedMinutes);//sri
			eval("formMain.sfrHOLD_DURN_IN_MINS"+row).value=parseInt(holdedMinutes)+parseInt(holdedDuration);
			// new field added durn_bw_std_resumed_ and flow_rate_changed_YN for SRR UAT3 : sri  25962
			eval("formMain.durn_bw_std_resumed_"+row).value=durn_bw_std_resumed;	
			eval("formMain.flow_rate_changed_YN"+row).value = flow_rate_changed_YN;
			//if(MFR_flow_rate != returnedFlowRate) //Commented for SRR20056-SCF-7371 IN027409
			//{
				eval("formMain.iv_flow_rate_"+row).value=returnedFlowRate;	
				CalculateCompletedFlowOnChangeOfFlowRateSFR(row,MFR_flow_rate,returnedDate);
				changeDisplay(eval("formMain.iv_flow_rate_"+row),row,flowRateDurationUnitDesc1);
				getHrsMinStr('TAKE',eval("formMain.sch_infusion_period_unit_"+row).value,row);
			//}
			calcDatesForSFR(convertDate(eval("formMain.iv_infusion_st_time_"+row).value,"DMYHM",locale,"en"),row,"RE");
		}
		else if(returnStatus=="CO"){
			returnStatusString=getLabel("ePH.COMPLETED.label",'PH');
			eval("formMain.chk_iv_select_"+row).disabled=false;
		}
		 if(returnStatus!="CO"){
			document.getElementById('orderctl'+row).innerHTML="<label style='font-size:8;color:blue;align:center;cursor:pointer;'><b>"+returnStatusString+"<b><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+row+"' id='imgArrow"+row+"'></label>";
		}
		else{
			document.getElementById('orderctl'+row).innerHTML="<label style='font-size:8;color:black;align:center;'><b>"+returnStatusString+"<b><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+row+"' id='imgArrow"+row+"'></label>";
		}
		var bean_id		= "" ;
		var bean_name	= "" ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();				
		xmlStr	="<root><SEARCH " ;				
		xmlStr += "holdMinutes=\""+eval("formMain.sfrHOLD_DURN_IN_MINS"+row).value+"\" " ;
		xmlStr += "holdDateTime=\""+eval("formMain.sfrHOLD_DATE_TIME"+row).value+"\" " ;
		xmlStr += "infusion_date_time=\""+eval("formMain.iv_infusion_st_time_"+row).value+"\" " ;
		xmlStr += "infusion_end_date=\""+eval("formMain.sfrACT_END_DATE_TIME"+row).value+"\" " ;		

		xmlStr += "resumeDateTime=\""+eval("formMain.sfrRESUME_DATE_TIME"+row).value+"\" " ;
		xmlStr += "completed_durn_in_mins=\""+eval("formMain.completedMinutes"+row).value+"\" " ;
		xmlStr += "completed_volume=\""+eval("formMain.completedFlow"+row).value+"\" " ;
		xmlStr += "iv_infusion_period=\""+eval("formMain.iv_infusion_period_"+row).value+"\" " ;
		xmlStr += "iv_flow_rate=\""+eval("formMain.iv_flow_rate_"+row).value+"\" " ;
		xmlStr += "iv_sch_admin_date_time=\""+iv_sch_admin_date_time+"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=&bean_name=&identity=updateSFR&order_id="+order_id+"&srl_no="+srl_no+"&sfr_status="+returnStatus+"&actionBy="+returnedAdminId+"&actionTime="+returnedDate+"&actionRemarks="+returnedRemarks, false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);	
	}
}

function calcDatesForSFR(stDate,rowno,action, callFrom){
	var startdate=stDate;
	var frmObjMain;
	if(callFrom=='SCH')
		frmObjMain=document.MedicationAdministrationSchLevelDrugDtls;
	else
		frmObjMain=document.MedicationAdministrationFTDrugDetails;
	var locale = frmObjMain.locale.value;
	flow_rate_changed_YN = eval("frmObjMain.flow_rate_changed_YN"+rowno).value;
	if(eval("frmObjMain.sfrACT_END_DATE_TIME"+rowno)!=undefined){
		var holdMinutes=eval("frmObjMain.sfrHOLD_DURN_IN_MINS"+rowno).value;
		var inf_hrs=eval("frmObjMain.inf_prd_hrs"+rowno).value;
		var inf_min=eval("frmObjMain.inf_prd_min"+rowno).value;
		inf_in_mins=parseFloat(inf_min)+(parseFloat(inf_hrs)*60);
		var totalMins=inf_in_mins+parseFloat(holdMinutes);
// whole of if part added for SRR UAT3 : sri
		//if(action=="RE" && flow_rate_changed_YN == "Y"){ //if condition is commented for SRR20056-SCF-7371 IN027409
			totalMins = eval("frmObjMain.durn_bw_std_resumed_"+rowno).value // this field contains value ( duration in min from start date time to hold time + hold duration)
			if(totalMins == undefined || totalMins=="") //if condition is added for SRR20056-SCF-7371 IN027409
				totalMins=0;

			totalMins = parseFloat(totalMins) + parseFloat(inf_in_mins);
		//}
		var endDate=plusDate(startdate,'DMYHM','en',totalMins,'m');
		eval("frmObjMain.sfrACT_END_DATE_TIME"+rowno).value=endDate;			
	}
}

function displayToolTipSFR(rowcount){
	var frmObjSFR=document.MedicationAdministrationFTDrugDetails;
	status1=eval("frmObjSFR.sfrFLOW_STATUS"+rowcount).value;	
	imgobj="imgArrow"+rowcount;
	obj=document.getElementById('orderctl'+rowcount);
	callMouseOverOnTD(obj,imgobj);
	var val="";
	if(status1=="NS")
		val="ST";
	else if(status1=="ST")
		val="HO,CO";
	else if(status1=="HO")
		val="RE";
	else if(status1=="RE")
		val="HO,CO";	
	else if(status1=="CO"){
		return false;
	}
	buildTable(status1,val,rowcount);
	resizeWindow(obj);
}
async function callMednDetailsFromHist(patient_id,encounterid,p_called) {
	/*var dialogHeight	= "40"; // commented for PMG2014-CRF-0026 [IN:052701]
	var dialogWidth		= "70";
	var dialogTop		= "125";
	var dialogLeft		= "200";
	var center			= "0";*/
	var dialogHeight	= "60vh"; // Added for PMG2014-CRF-0026 [IN:052701] -start
	var dialogWidth		= "50vh";
	var dialogTop		= "0";
	dialogWidth		= (window.innerHeight);
	win_width		= (window.innerWidth);	
	if(win_width==undefined){
		dialogWidth		= (document.documentElement.clientHeight);
		dialogHeight		= (document.documentElement.clientWidth);			
		if(dialogWidth==0){				
			dialogHeight		= (parseInt(document.body.clientHeight));
			dialogWidth		= (parseInt(document.body.clientWidth));				
		}			 
	}		
	dialogTop			= "0px"; // Added for PMG2014-CRF-0026 [IN:052701] -end
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight+ "; dialogWidth:" + dialogWidth  + "; status: " + status + "; dialogTop :" + dialogTop+";resizable=yes;maximize:yes;minimize:no;"; // Added for PMG2014-CRF-0026 [IN:052701]
	//var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop; // commented for PMG2014-CRF-0026 [IN:052701]
	var arguments		= "";
	retVal 				= await window.showModalDialog("../../ePH/jsp/QueryMednAdminChart.jsp?patient_id="+patient_id+"&encounterid="+encounterid+"&called_from="+p_called,arguments,features);
  	try{
		if(window.name=='' || window.name=='FlowSheetTextMainFrame')window.close();
	}catch(e){}
}
//RUT-CRF-0035 [IN029926] Added for PIN Validation  - begin

async function callUserAuthVal(callFrom, userAuthPINYN){
	if(callFrom!='SCH')
		userAuthPINYN = f_search.document.MedicationAdministrationSearchForm.userAuthPINYN.value;
	if(userAuthPINYN=='Y'){
		var dialogHeight	= "30vh";
		var dialogWidth		= "25vw";
		//var dialogTop		=  window.screen.availWidth - 1100;
		//var dialogLeft		=  window.screen.availWidth - 1000;
		var dialogTop		=  "0";
		var dialogLeft		=  "0";
		var center			= "0";
		var status			= "no";	
		var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var retVal= await window.showModalDialog("../../ePH/jsp/UserPINAuthorization.jsp?call_from=MAR","",features);
		if(retVal==undefined || retVal=='C')
			return false;
		else{
			retVal=trimString(retVal);
			if(retVal!="0"){
				await storeUserinBean_MAR(retVal, callFrom);
			}
			return true;
		}
	}
	else
		return true;
}

function storeUserinBean_MAR(auth_user_id,call_flag){
	if(call_flag=='TL'){
		var bean_id=document.MedicationAdministrationFTDrugDetails.bean_id.value;
		var bean_name=document.MedicationAdministrationFTDrugDetails.bean_name.value;
	}
	else if(call_flag=='SCH'){
		var bean_id=document.MedicationAdministrationSchLevelDrugDtls.bean_id.value;
		var bean_name=document.MedicationAdministrationSchLevelDrugDtls.bean_name.value;
	}
	else{
		var bean_id		= f_search.document.MedicationAdministrationSearchForm.ft_bean_id.value ;
		var bean_name	= f_search.document.MedicationAdministrationSearchForm.ft_bean_name.value ;
	}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;
	xmlStr += "auth_user_id=\""+ auth_user_id +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?identity=storeAuthUserInBean&bean_id=" + bean_id + "&bean_name=" + bean_name, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText;
	eval( responseText ) ;
}// RUT-CRF-0035 [IN029926] PIN Authentication  -- end

function chkShrdDrug(obj,index,verify_adm_drug){//Added for HSA-CRF-0090--start // 'verify_adm_drug' Added for AAKH-CRF-0084 [IN060429]
	var non_iv_obj="";
	var alt_obj="";
	var iv_obj="";
	if(eval("document.MedicationAdministrationFTDrugDetails.non_iv_shared_drug_"+index))
		non_iv_obj=eval("document.MedicationAdministrationFTDrugDetails.non_iv_shared_drug_"+index) ;
	if(eval("document.MedicationAdministrationFTDrugDetails.alt_shared_drug_"+index))
		alt_obj=eval("document.MedicationAdministrationFTDrugDetails.alt_shared_drug_"+index) ;
	if(eval("document.MedicationAdministrationFTDrugDetails.iv_shared_drug_"+index))
		iv_obj=eval("document.MedicationAdministrationFTDrugDetails.iv_shared_drug_"+index) ;
	if(obj.checked==true){//Added if and else for PH-48901
		obj.value="Y";
		if(verify_adm_drug=="true"){ // Added for AAKH-CRF-0084 [IN060429] - Start
			eval("document.MedicationAdministrationFTDrugDetails.batch_id_mand_"+index).style.visibility="visible"; 
		    eval("document.MedicationAdministrationFTDrugDetails.exp_dt_mand_"+index).style.visibility="visible"; // Added for AAKH-CRF-0084 [IN060429] - End
		}
	}
	else{
		obj.value="N";
		if((verify_adm_drug=="true") && !eval(document.getElementById("pat_brought_med_"+index)).checked){ // Added for AAKH-CRF-0084 [IN060429] - Start
			eval("document.MedicationAdministrationFTDrugDetails.batch_id_mand_"+index).style.visibility="hidden"; 
		    eval("document.MedicationAdministrationFTDrugDetails.exp_dt_mand_"+index).style.visibility="hidden"; // Added for AAKH-CRF-0084 [IN060429] - End
		}
	}
		if(non_iv_obj!=null && obj.name==non_iv_obj.name){
			eval("document.MedicationAdministrationFTDrugDetails.non_iv_batch_id_"+index).value=""; 
			eval("document.MedicationAdministrationFTDrugDetails.non_iv_batch_id_"+index).disabled=true; 
			eval("document.MedicationAdministrationFTDrugDetails.non_iv_expiry_date_"+index).value="" ;
			eval("document.MedicationAdministrationFTDrugDetails.non_iv_expiry_date_"+index).disabled=true; 
		}
		else if (alt_obj!=null && obj.name==alt_obj.name){
				eval("document.MedicationAdministrationFTDrugDetails.alt_batch_id_"+index).value=""; 
				eval("document.MedicationAdministrationFTDrugDetails.alt_batch_id_"+index).disabled=true; 
				eval("document.MedicationAdministrationFTDrugDetails.alt_expiry_date_"+index).value="" ;
				eval("document.MedicationAdministrationFTDrugDetails.alt_expiry_date_"+index).disabled=true; 
		}
		else if (iv_obj!=null && obj.name==iv_obj.name){
			eval("document.MedicationAdministrationFTDrugDetails.iv_batch_id_"+index).value=""; 
			eval("document.MedicationAdministrationFTDrugDetails.iv_batch_id_"+index).disabled=true; 
			eval("document.MedicationAdministrationFTDrugDetails.iv_expiry_date_"+index).value="" ;
			eval("document.MedicationAdministrationFTDrugDetails.iv_expiry_date_"+index).disabled=true; 
		}
	//}
}//Added for HSA-CRF-0090--end
function validateBatchId(batch_id,order_id,order_line_no,site_spec_yn,drug_code,iv_prep_yn){ // Added for AAKH-CRF-0084 [IN060429] - Start and iv_prep_yn added for MMS-KH-CRF-0017
	if(batch_id.value!=""){
//PMG2017-MMS-CRF-0002 - start
		var	item_code = "";
		var batch_id_1 = batch_id.value;
		var patient_id="";//MMS-KH-CRF-0017

		if(site_spec_yn=="true"){
				var bat_ids= batch_id.value;
			if(bat_ids.indexOf("$")!=-1){
				var item_code = bat_ids.split("$")[1];
				batch_id_1  =  bat_ids.split("$")[0];
				//MMS-KH-CRF-0017 - start
				if( iv_prep_yn=="2" || iv_prep_yn=="4" || iv_prep_yn=="6" || iv_prep_yn=="0" || iv_prep_yn=="8"){//MMS-KH-CRF-0017.1
					patient_id = bat_ids.split("$")[1];
				}
				if(iv_prep_yn=="" || iv_prep_yn=="1" || iv_prep_yn=="3" ||  iv_prep_yn=="5" ||  iv_prep_yn=="7" ||  iv_prep_yn=="9" ){ // MMS-KH-CRF-0017 - end and  iv_prep_yn=="0" || iv_prep_yn=="9" added for modified for MMS-KH-CRF-0017.1
				
				if(item_code==""){ //added for raising demo for PMG2017-MMS-CRF-0002
					var msg = getMessage("NOT_VALID_BARCODE","PH");
					alert(msg);
					
					parent.parent.document.getElementById('non_iv_admin_batch_id').select();
					return false;
			}
			}else{//MMS-KH-CRF-0017 - start
				if(patient_id==""){
					var msg = getMessage("NOT_VALID_BARCODE","PH");
					alert(msg);
					parent.parent.document.getElementById('non_iv_admin_batch_id').select();
					return false;
				}//MMS-KH-CRF-0017 - end
			}
			}
	
		}

////PMG2017-MMS-CRF-0002  - end
	   var xmlDoc="";
	   var xmlHttp = new XMLHttpRequest();
           xmlStr	="<root><SEARCH " ;
	   xmlStr += "batch_id=\""+ batch_id_1 +"\" " ;//Changed batch_id to batch_id_1 for PMG2017-mms-crf-0002
	   xmlStr += "order_id=\""+ order_id +"\" " ;
	   xmlStr += "order_line_no=\""+ order_line_no +"\" " ;
	   xmlStr += "item_code=\""+ item_code +"\" " ;//PMG2017-MMS-CRF-0002 
	   xmlStr += "drug_code=\""+ drug_code+"\" " ;//PMG2017-MMS-CRF-0002 
	   xmlStr += "iv_prep_yn=\""+ iv_prep_yn+"\" " ;  //MMS-KH-CRF-0017
	   xmlStr += "patient_id=\""+ patient_id+"\" " ; //MMS-KH-CRF-0017
	   xmlStr +=" /></root>" ;
	   xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
	   xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?identity=ValidBatchId", false ) ;
	   xmlHttp.send( xmlDoc ) ;
	   eval(xmlHttp.responseText);
   } 
}
function validBatchidYn(validBatchId){
	if(validBatchId!="" && validBatchId=="false"){
	   var msg = getMessage("NOT_VALID_BARCODE","PH");
	   alert(msg);
	   document.getElementById('non_iv_admin_batch_id').value="";
	   document.getElementById('non_iv_admin_batch_id').focus();
	}
	else{
	   document.getElementById('non_iv_admin_batch_id').blur();
	}		 
} // Added for AAKH-CRF-0084 [IN060429] - End



function disable_yn(order_line_status){
                if(order_line_status!=undefined || order_line_status!=""){
                   if(order_line_status=="DF"|| order_line_status=="DP")
                                  return true;
                   else 
                                return false;
                }
				}

//added for CRF-413.8
function barcodeScan(obj){
		if(obj.value!=""){
		var formObj = parent.frames[2].frames[1].document.MedicationAdministrationFTDrugDetails;
		var frameObj = parent.frames[2].frames[1].document.MedicationAdministrationFTDrugDetails;
		if(frameObj.non_iv_records!=undefined || frameObj.iv_records!=undefined){
		var non_iv_len		= frameObj.non_iv_records.value;
		var iv_len			= frameObj.iv_records.value;	
		var sys_date        = frameObj.current_date_time.value;
		var locale			= frameObj.locale.vaue;
	
		var multi_batch_flag = false;
		var batch_id_size = "" ;
		var sch_date ="";
		var barcode_id = "";
		var placed_from_verbal_order = "";//GHL-CRF-509
		var valid_flag = false; 
		var verbal_order_flag = false;//GHL-CRF-509
		for(var i=1;i<=non_iv_len;i++){
			if(eval("formObj.chk_non_iv_select_"+i) != null){
				if(eval("formObj.chk_non_iv_select_"+i).checked==false){
					if(eval("formObj.batch_ids_size_"+i) != null){ 
						batch_id_size = eval("formObj.batch_ids_size_"+i).value; 
						if(batch_id_size!=null && batch_id_size!="" && batch_id_size>0){
							 sch_date = eval("formObj.non_iv_sch_date_time_"+i).value; 
								if(parseInt(batch_id_size)==9){//6 changed to 7 2/1/2018  and 7 to 9 for GHL-CRF-0482
								  barcode_id = eval("formObj.non_iv_barcode_id_"+i).value; 	
									if(obj.value==barcode_id ){
										//if(isAfter(sch_date,sys_date,"DMYHM",locale)){GHL_SCF_1735
											valid_flag = true;
											eval("formObj.non_iv_batch_id_"+i).style.backgroundColor = "green";;//"#00ff00";
											eval("formObj.chk_non_iv_select_"+i).checked = true;
											break;
										//}
									}
								}else if(parseInt(batch_id_size)>9){//6 changed to 7 2/1/2018 and 7 to 9 for GHL-CRF-0482
									var sch_date = eval("formObj.non_iv_sch_date_time_"+i).value; 
										var batch_id_select = eval("formObj.non_iv_batch_id_"+i);
										var batch_id_opts = batch_id_select.options;
										var len = batch_id_opts.length;	// ICN63694
										
										for(var j = 1; j<len; j++) {//ICN63694
											barcode_id = eval("formObj.non_iv_barcode_id_"+i+"_"+j).value;
											
											if( barcode_id==obj.value) {
												eval("formObj.non_iv_batch_id_"+i).selectedIndex = j;// ICN63694
												multi_batch_flag = true;
												break;
											}
										}
										if(multi_batch_flag==true){
											//if(isAfter(sch_date,sys_date,"DMYHM",locale)){GHL_SCF_1735
												valid_flag = true;
												eval("formObj.chk_non_iv_select_"+i).checked = true;
												eval("formObj.non_iv_batch_id_"+i).onchange();
												eval("formObj.non_iv_batch_id_"+i).style.backgroundColor = "green";//"#00ff00";
												break;
											//}
										}
						   }
							
						}
					}else{//GHL-CRF-509
							verbal_order_flag = true;
							placed_from_verbal_order = false;
							if(eval("formObj.placed_from_verbal_order_"+i))
							placed_from_verbal_order =eval("formObj.placed_from_verbal_order_"+i).value;
							var store_code = eval("formObj.non_iv_store_code_"+i).value;
							var item_code  = eval("formObj.non_iv_item_code_"+i).value;
							var order_id   = 	eval("formObj.non_iv_order_id_"+i).value;
							var order_line_no	= eval("formObj.non_iv_order_line_no_"+i).value;
							if(placed_from_verbal_order){
							var bean_id		= formObj.bean_id.value ;
							var bean_name	= formObj.bean_name.value ;
							var xmlDoc="";
							var xmlHttp = new XMLHttpRequest();
						
							xmlStr	="<root><SEARCH " ;
							xmlStr += "store_code=\""+ store_code +"\" " ;
							xmlStr += "barcode_id=\""+ obj.value+"\" " ;
							xmlStr += "item_code=\""+ item_code +"\" " ;
							xmlStr += "order_id=\""+ order_id+"\" " ;
							xmlStr += "order_line_no=\""+ order_line_no +"\" " ;
							xmlStr +=" /></root>" ;
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity=barcode_validation", false ) ;
							xmlHttp.send( xmlDoc ) ;	
						
							if(trimString(xmlHttp.responseText)!="N"){
							eval("formObj.chk_non_iv_select_"+i).checked = true;	
							 valid_flag = true;
							// calcQuantityInDispensingUOM("NONIV",i);

							var stock_values	=	trimString(xmlHttp.responseText).split("~");
							var batch_id		=	stock_values[0];		
							var expiry_date		=	stock_values[1];
							var bin_code		=	stock_values[2];
							var trade_id		=	stock_values[3];		

							eval("formObj.non_iv_batch_id_"+i).value	=	batch_id;
							eval("formObj.non_iv_expiry_date_"+i).value	=	expiry_date
							eval("formObj.non_iv_trade_id_"+i).value	=	trade_id;
							eval("formObj.non_iv_bin_code_"+i).value	=	bin_code;
							eval("formObj.batch_assigned_verbal_order_"+i).value = "Y";
 						    break;
							}
						}
						}//GHL-CRF-509 - end
				}
			}
		}
		var start_flag;
		var drug_count="";
		var barcode_id1 = ""
		var sfr_flow = "";
		multi_batch_flag = false;
		
		for(var i=1;i<=iv_len;i++){
			if(eval("formObj.sfrFLOW_STATUS"+i)!=undefined ){
			 sfr_flow=eval("formObj.sfrFLOW_STATUS"+i).value; 
			 drug_count     = parseInt(eval("formObj.drug_count_"+i).value); 
			 start_flag	   = true;
 			 if(eval("formObj.iv_batch_ids_"+i) != null){ 	
				var batch_id_size   = eval("formObj.iv_batch_ids_"+i).value; 
					if(batch_id_size==9){ // 7 to 9 for GHL-CRF-0482
						 barcode_id1     = eval("formObj.iv_barcode_id_"+i).value; 
						 iv_order_id    = eval("formObj.iv_order_id_"+i).value;
							if(barcode_id1 == obj.value ){
								valid_flag = true;//ICN63763
								eval("formObj.iv_batch_id_"+i).style.backgroundColor = "green";//ICN63763
								eval("formObj.barcode_check_"+iv_order_id+"_"+i).click();
							}
					
					}else if(batch_id_size>9){//6 changed to 7 2/1/2018 and 7 to 9 for GHL-CRF-0482
						var sch_date = eval("formObj.iv_sch_date_time_"+i).value; 
						 iv_order_id    = eval("formObj.iv_order_id_"+i).value;
						var batch_id_select = eval("formObj.iv_batch_id_"+i);
						var batch_id_opts = batch_id_select.options;
						var len = batch_id_opts.length;	
						if(eval("formObj.barcode_check_"+iv_order_id+"_"+i).checked==false){
						//	for(var opt, j = 0; opt = batch_id_opts[j]; j++) {//commented for ICN63694
							for(var j=1;j<len;j++){
									barcode_id = eval("formObj.iv_barcode_id_"+i+"_"+j).value;
								if( barcode_id==obj.value) {
									batch_id_select.selected	=	true;
									eval("formObj.iv_batch_id_"+i).selectedIndex = j;
									valid_flag = true;
									//eval("formObj.iv_batch_id_"+i).value = batch_id_select.options[j].value;
									multi_batch_flag = true;
									break;
								}
							}
						}
						if(multi_batch_flag==true){
							//if(isAfter(sch_date,sys_date,"DMYHM",locale)){//GHL_SCF_1735
								valid_flag = true;
								eval("formObj.iv_batch_id_"+i).style.backgroundColor = "green";//"#00ff00";
								eval("formObj.iv_batch_id_"+i).onchange();
								eval("formObj.barcode_check_"+iv_order_id+"_"+i).checked=true;
								eval("formObj.barcode_check_"+iv_order_id+"_"+i).click();
								break;
							//}//GHL-SCF-1735
						}
				  }
				}
			  }
			}
			
			if(valid_flag==false ){
				alert(getMessage("NOT_A_VALID_BARCODE_MAR","PH"));
			}
			obj.value="";//ICN63725
			if(verbal_order_flag==true){ //GHL-CRF-509 - start
			var bean_id		= formObj.bean_id.value ;
			var bean_name	= formObj.bean_name.value ;
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
	
			xmlStr	="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity=barcode_clear", false ) ;
			xmlHttp.send( xmlDoc ) ;	
			eval(xmlHttp.responseText);
		}//GHL-CRF-509 - end
	}
	}

}
//added for CRF-413.8
function openBarcodeSFRWidow(count,rowno,locale,sys_date,iv_order_id){

		var formObj = document.MedicationAdministrationFTDrugDetails;
		var iv_len	= formObj.iv_records.value;	
		eval("formObj.barcode_check_"+iv_order_id+"_"+rowno).checked = true;
		sch_date = eval("formObj.iv_sch_date_time_"+rowno).value;
		sfr_flow=eval("formObj.sfrFLOW_STATUS"+rowno).value; 
		drug_count     = parseInt(eval("formObj.drug_count_"+rowno).value);
		start_flag = false;
		var iv_order_id1 ="";
		var check_count = 0;
		if(isAfter(sch_date,sys_date,"DMYHM",locale)){
		for(i=1;i<iv_len;i++){
				iv_order_id1 = eval("formObj.iv_order_id_"+i).value;

				if(iv_order_id1==iv_order_id){
					if(eval("formObj.barcode_check_"+iv_order_id+"_"+i).checked==true){
						check_count++;
					}
				}
		}
		if(check_count==drug_count){
				start_flag=true;
				for(j=1;j<iv_len;i++){
				iv_order_id1 = eval("formObj.iv_order_id_"+j).value;
				if(iv_order_id1==iv_order_id){
				
				rowno=j;
				break;
				}
				}
		}
			if(sfr_flow =="NS" && start_flag==true){
			  callMenuFunctionsSFR("ST",rowno);
			}
		}
}
//GHL-CRF-0458 - start
function validateQtyAck(obj,recCount,order_id,order_line_num,item_code,isSiteSpecMARPrint,patient_id,iv_prep_yn,patient_class_ord,batch_id_size,patient_stock_yn,encounter_id,patient_brgt_medn){
	

	//patient_class_ord added for ICN66152
	if(isSiteSpecMARPrint=="true" ){ //&& patient_class_ord=="IP" condition removed for alpha raised IN68336 //GHL-CRF-0482
	patient_brgt_medn = eval("document.MedicationAdministrationFTDrugDetails.patient_brgt_medn_"+recCount).value; //GHL-CRF-0482

	if(patient_brgt_medn!="Y"){ //GHL-CRF-0482
	var batch_id = eval("document.MedicationAdministrationFTDrugDetails.non_iv_batch_id_"+recCount).value;
	var expiry_date  = eval("document.MedicationAdministrationFTDrugDetails.non_iv_expiry_date_"+recCount).value;
	var trade_id   = eval("document.MedicationAdministrationFTDrugDetails.non_iv_trade_id_"+recCount).value;
	var non_iv_admin_qty =eval("document.MedicationAdministrationFTDrugDetails.non_iv_admin_quaty_"+recCount).value; //GHL-CRF-0458.1
	
// added for GHL-CRF-0482 - start
	var non_iv_batch_order_id = eval("document.MedicationAdministrationFTDrugDetails.non_iv_batch_order_id_"+recCount).value;
	var	non_iv_batch_order_line_no = eval("document.MedicationAdministrationFTDrugDetails.non_iv_batch_order_line_no_"+recCount).value;
	if(patient_stock_yn=="Y" || parseInt(batch_id_size)>0){
		order_id =	non_iv_batch_order_id;
		order_line_num=	non_iv_batch_order_line_no;
	}
// added for GHL-CRF-0482 - end			
	if(parseInt(batch_id_size)>0){
		if(batch_id==""){
			alert(getMessage("PH_ATLEAST_ONE_BATCH","PH"));
				obj.checked = false;
			return false;
		}
	}
	var placed_from_verbal_order = "N";
if(eval("document.MedicationAdministrationFTDrugDetails.placed_from_verbal_order_"+recCount))
	placed_from_verbal_order =eval("document.MedicationAdministrationFTDrugDetails.placed_from_verbal_order_"+recCount).value;//ADDED FOR GHL-CRF-0509
	var	formObj		= document.MedicationAdministrationFTDrugDetails;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	
//	alert("order_id==>"+order_id+"==order_line_num==>"+order_line_num+"==item_code==>"+item_code+"==isSiteSpecMARPrint==>"+isSiteSpecMARPrint);

		xmlStr	="<root><SEARCH " ;
		xmlStr += "order_id=\""+ order_id +"\" " ;
		xmlStr += "order_line_no=\""+ order_line_num +"\" " ;
		xmlStr += "item_code=\""+ item_code +"\" " ;
		xmlStr += "batch_id=\""+ batch_id +"\" " ;
		xmlStr += "expiry_date=\""+ expiry_date +"\" " ;
		xmlStr += "trade_id=\""+ trade_id +"\" " ;
		xmlStr += "patient_id=\""+ patient_id +"\" " ;
		xmlStr += "encounter_id=\""+ encounter_id +"\" " ;//GHL-CRF-0482
		xmlStr += "recCount=\""+ recCount +"\" " ;
		xmlStr += "non_iv_admin_qty=\""+ non_iv_admin_qty +"\" " ;//GHL-CRF-0458.1
		xmlStr += "non_iv_checked=\""+ obj.checked +"\" " ;//GHL-CRF-0458.1
		xmlStr += "placed_from_verbal_order=\""+ placed_from_verbal_order +"\" " ;//ADDED FOR GHL-CRF-0509
		
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity=validateQtyAck", false ) ;
		xmlHttp.send( xmlDoc ) ;	
		eval(xmlHttp.responseText);
	} //GHL-CRF-0482
	}
}

function displayAlert(recCount,disp_req_yn){ //disp_req_yn added for GHL-CRF-0458.1
	var placed_from_verbal_order = "N";
	
	if(eval("document.MedicationAdministrationFTDrugDetails.placed_from_verbal_order_"+recCount))
	placed_from_verbal_order = eval("document.MedicationAdministrationFTDrugDetails.placed_from_verbal_order_"+recCount).value;//ADDED FOR GHL-CRF-0509
	if(eval("document.MedicationAdministrationFTDrugDetails.chk_non_iv_select_"+recCount)){
		 if(placed_from_verbal_order!="Y") {
		eval("document.MedicationAdministrationFTDrugDetails.chk_non_iv_select_"+recCount).checked = false;
		 }
		 }
	 if(placed_from_verbal_order!="Y") {// if condition Added FOR GHL-CRF-0509
	if(disp_req_yn=="N")  //added for GHL-CRF-0458.1
		alert(getMessage("PH_NOT_ACKNOWLEDGED","PH"));
	else
		alert(getMessage("PH_NOT_DISPENSED","PH"));
	

	return false;
		}
}
function adminAllowYN(recCount,adminAllowYN){
//	alert("adminAllowYN==>"+adminAllowYN);
		//var allow_admin_yn = eval("document.MedicationAdministrationFTDrugDetails.allowed_yn_"+recCount).value;
	if(eval("document.MedicationAdministrationFTDrugDetails.allowed_yn_"+recCount)){//recCount added for IN066062
		
		eval("document.MedicationAdministrationFTDrugDetails.allowed_yn_"+recCount).value = adminAllowYN;//recCount added for IN066062
	}

}
//GHL-CRF-0458 - end
//added for BRU-CRF-399.1 - start
function getAltDoseDetails(formObj,disp_drug_code,drug_code,order_id,order_line_num,row_no,freq_nature,old_MAR_YN,qty){

		var bean_id		= formObj.bean_id.value ;
		var bean_name		= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();			
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "MedicationAdministrationFTValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&identity=getAltDoseDetails&disp_drug_code="+disp_drug_code+"&drug_code="+drug_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&row_no="+row_no+"&freq_nature="+freq_nature+"&old_MAR_yn="+old_MAR_YN+"&qty="+qty, false ) ;
		xmlHttp.send( xmlDoc ) ;	
		eval(xmlHttp.responseText);
}
//added for BRU-CRF-399.1 - end
//GHL-CRF-0482 -start
function PatientStockCheck(obj,order_id,order_line_no,new_MAR_YN,recCount){

	var non_iv_len			= document.getElementById('non_iv_records').value;
	var non_iv_order_id	= "";
	var non_iv_or_order_line = "";
	if(new_MAR_YN=="Y"){
		
		if(obj.checked==true)
			eval("document.MedicationAdministrationFTDrugDetails.non_iv_patient_stock_"+recCount).value="Y";
		else
			eval("document.MedicationAdministrationFTDrugDetails.non_iv_patient_stock_"+recCount).value="N";
	}else{
	
	if(obj.checked==true){
		for(var i=1;i<=non_iv_len;i++){
		 non_iv_order_id		= eval("document.MedicationAdministrationFTDrugDetails.non_iv_order_id_"+i).value;
		 non_iv_or_order_line= eval("document.MedicationAdministrationFTDrugDetails.non_iv_order_line_no_"+i).value;		
		 
		 if(order_id==non_iv_order_id && order_line_no==non_iv_or_order_line){
			 if(eval("document.MedicationAdministrationFTDrugDetails.non_iv_patient_stock_"+i)){
				eval("document.MedicationAdministrationFTDrugDetails.non_iv_patient_stock_"+i).checked=true;
				eval("document.MedicationAdministrationFTDrugDetails.non_iv_patient_stock_"+i).value="Y";
			 }
		 }
		}
	}else{
		for(var i=1;i<=non_iv_len;i++){
		
		 non_iv_order_id		= eval("document.MedicationAdministrationFTDrugDetails.non_iv_order_id_"+i).value;
		 non_iv_or_order_line= eval("document.MedicationAdministrationFTDrugDetails.non_iv_order_line_no_"+i).value;		
		 
		 if(order_id==non_iv_order_id && order_line_no==non_iv_or_order_line){
			 if(eval("document.MedicationAdministrationFTDrugDetails.non_iv_patient_stock_"+i)){
				eval("document.MedicationAdministrationFTDrugDetails.non_iv_patient_stock_"+i).checked=false;
				eval("document.MedicationAdministrationFTDrugDetails.non_iv_patient_stock_"+i).value="N";
			 }
		 }
		}
	}
	}
}
//GHL-CRF-0482 -end
//added for JD-CRF-0200 START
function openAuditLogWindowIV(rowNo,from, callFrom, dosage_seq_no, schCount,cancelYn,admin_by_name,drug_desc,scheKey,qty,admin_date_time,strength_per_value_pres_uom,drug_code,order_id,order_line_num,iv_prep_yn,sch_date_time,patient_id_test,encounter_id,sch_infusion_per_unit_table_data,sch_infusion_vol_str_unit_desc){// Modified for IN073378
	var	calval="";
		if(cancelYn =="Y" &&(iv_prep_yn=="" || iv_prep_yn==null || iv_prep_yn=="1" || iv_prep_yn=="3" ||iv_prep_yn=="5" || iv_prep_yn=="9" )){
			var	calval="VAD,CAN";
		}
		else{
			var	calval="VAD";
		}
	
	obj=eval(document.getElementById('order')+scheKey);
	openAuditLogWindowIVview( calval,rowNo,from, callFrom, dosage_seq_no, schCount,admin_by_name,drug_desc,qty,admin_date_time,strength_per_value_pres_uom,drug_code,order_id,order_line_num,iv_prep_yn,sch_date_time,patient_id_test,encounter_id,sch_infusion_per_unit_table_data,sch_infusion_vol_str_unit_desc);// Modified for IN073378
	resizeWindowSch(obj);

}
function openAuditLogWindowIVview(colvals,rowNo,from, callFrom, dosage_seq_no, schCount,admin_by_name,drug_desc,qty,admin_date_time,strength_per_value_pres_uom,drug_code,order_id,order_line_num,iv_prep_yn,sch_date_time,patient_id_test,encounter_id,sch_infusion_per_unit_table_data,sch_infusion_vol_str_unit_desc){// Modified for IN073378
	
	var rowval   = colvals.split (",");	
	var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='left'>"
	var descval="";
	for( var i=0; i<rowval.length; i++ ) {
		var colval  = rowval[i]
		if (colval != ""){
		
				 if(colval=="VAD")
					descval=getLabel("ePH.ViewAdminDetails.label",'PH');
					else if(colval=="CAN")//added for JD-CRF-0200
					descval="Cancel Admin";
			
		}	
		
			tab_dat = tab_dat+"<tr>"
			//Modified for IN073378 
			tab_dat=tab_dat+ "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOverSch(this)' onMouseOut='callOnMouseOutSch(this);' onClick=callMenuFunctionsSchopenAuditLogWindowIV('"+colval+"','"+rowNo+"','"+ from+"','"+callFrom+"','"+dosage_seq_no+"','"+schCount+"','"+admin_by_name+"','"+encodeURIComponent(drug_desc,"UTF-8")+"','"+qty+"','"+encodeURIComponent(admin_date_time,"UTF-8")+"','"+strength_per_value_pres_uom+"','"+encodeURIComponent(drug_code,"UTF-8")+"','"+order_id+"','"+order_line_num+"','"+iv_prep_yn+"','"+encodeURIComponent(sch_date_time,"UTF-8")+"','"+patient_id_test+"','"+encounter_id+"','"+sch_infusion_per_unit_table_data+"','"+encodeURIComponent(sch_infusion_vol_str_unit_desc,"UTF-8")+"');>"+descval+" </td>" 
			tab_dat=tab_dat+ "</tr> " 
//'"+drugdesc+"','"+ord_drug_code+"','"+disp_locn_code+"','"+calledFrom+"','"+order_id+"','','"+iv_Auto_Admin+"','"+oncoMFR+ added for ML-MMOH-CRF-1014
		}
	
	tab_dat=tab_dat+ "</table> ";
	document.getElementById('tooltiptd').innerHTML = tab_dat;
}
function callMenuFunctionsSchopenAuditLogWindowIV(colvals,rowNo,from, callFrom, dosage_seq_no, schCount,admin_by_name,drug_desc,qty,admin_date_time,strength_per_value_pres_uom,drug_code,order_id,order_line_num,iv_prep_yn,sch_date_time,patient_id_test,encounter_id,sch_infusion_per_unit_table_data,sch_infusion_vol_str_unit_desc){// Modified for IN073378

	hidemenuSch();
	 if(colvals=="VAD"){
		openAuditLogWindow(rowNo,from, callFrom, dosage_seq_no, schCount,sch_date_time,sch_infusion_per_unit_table_data,sch_infusion_vol_str_unit_desc);// Modified for IN073378
	}
	
	else if(colvals=='CAN'){//added for JD-CRF-0200
		
	//cancelAdminstration(drug_desc,admin_by_name);
		cancelAdminstration(drug_desc,admin_by_name,drug_code,order_id,order_line_num,iv_prep_yn,sch_date_time,dosage_seq_no,qty,patient_id_test,encounter_id,admin_date_time,strength_per_value_pres_uom);
		
	}
}
//added for JD-CRF-0200 END
//Adding start for MMS-DM-CRF-0157.1,changed method name for IN073827

function barcodeScanApp_YN(evnt,barcode){ 
	var bar_code_scaned_YN = "";
	var keyVal	= parseInt(evnt.keyCode);
	var bar_code_site_yn = document.MedicationAdministrationFTRemarks.bar_code_scan_site_YN.value;
	   if(bar_code_site_yn =="Y" && barcode.value!="" && barcode.value.length>1 && keyVal==17){
		 document.MedicationAdministrationFTRemarks.bar_code_scaned_YN.value="Y";	
	   }else{
		   document.MedicationAdministrationFTRemarks.bar_code_scaned_YN.value="N";	
		  
	   }
		 
}
async function callManualScanRemarks(encounter_id,patient_id,patient_class,remarks_required_yn){//,patient_id,patient_class,remarks_required_yn added for MMS-DM-CRF-0170
	var patient_id   =  "";
	var bean_id      =  document.MedicationAdministrationFTRemarks.bean_id.value;
	var bean_name    =  document.MedicationAdministrationFTRemarks.bean_name.value;
	var module_id    = "PH";
	var menu_id      = "MEDICATION_ADMINISTRATION"
	var sub_menu_id  = "";
	var entry_type   ="M";
	var retVal = new String();
	var dialogHeight= "40vh" ;                                                 
	
	var dialogWidth              = "60vw" ;

	var status = "no";                                             
	var features       = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto; status:" + status; 
	retVal =await window.showModalDialog("../../eOR/jsp/BarCodeManualEntryReason.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&module_id="+module_id+"&menu_id="+menu_id+"&sub_menu_id="+sub_menu_id+"&entry_type="+entry_type+"&patient_id="+patient_id+"&patient_class="+patient_class+"&remarks_mandetory_yn="+remarks_required_yn,arguments,features);

     if(remarks_required_yn == 'N'){
		 if(retVal == undefined)
		     retVal ="";
	 }
		return retVal;

}

function scanBarcodeCount(encounter_id,patient_id,patient_class,entry_type){//,patient_id,patient_class added for MMS-DM-CRF-170
	var retVal = "";
	var menu_id ="MEDICATION_ADMINISTRATION";
	var module_id ="PH";
	var patient_id   =  "";
	//var encounter_id  =	encounter_id;
	var bean_id      =  document.MedicationAdministrationFTRemarks.bean_id.value;
	var bean_name    =  document.MedicationAdministrationFTRemarks.bean_name.value;
	var entry_type   ="S";
	var sub_menu_id="";


		var xmlDoc  = "";//new ActiveXObject( "Microsoft.XMLDom" ) ;
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
		xmlStr += " patient_class=\""+patient_class+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
		xmlHttp.open("POST","../../eOR/jsp/BarCodeManualEntryReasonSave.jsp?",false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText;
		return true;
}
//Adding end for MMS-DM-CRF-0157.1
function pressKeyLocatePatientID(e){ // added for MOHE-CRF-0167 
	if(e.keyCode== 13){
		locatePatientID();
	}
}


