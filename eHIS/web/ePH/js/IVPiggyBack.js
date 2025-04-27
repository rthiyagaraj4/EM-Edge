/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/09/2019      IN070451		   B Haribabu   06/09/2019     Manickam                 ML-MMOH-CRF-1408
24/10/2019		INO71514			Shazana												SKR-SCF-1276
30/06/2020      IN:072715          Haribabu     30/06/2020     Manickavasagam J        MMS-DM-CRF-0165
28/10/2020		IN073670			Shazana		28/10/2020		Manickavasagam J 		MMS-KH-SCF-0096	
06/11/2020      IN:069887              Haribabu                 Manickavasagam J            MO-CRF-20152					
4/12/2020		    6041				Shazana						Manickam				NMC-JD-CRF-0063	
06/01/2021		TFS-7345          Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177				
1/3/2021		15129				Shazana						Manickavasagam			NMC-JD-CRF-0063
25-05-2022                    AAKH-CRF-0140                PRATHYUSHA
--------------------------------------------------------------------------------------------------------------
*/
var result		= false; 
var message		= "";

var flag		= "";   
var narcotic_yn		= "";
var print_ord_sht_rule_ind="";//Added for Bru-HIMS-CRF-393_1.0

function searchOrdersetPiggyBack(searchBasedOn, order_set_code,patient_class,drug_code,bean_id,bean_name,patient_id,encounter_id){
	var headerFrm		= "";

	if(parent.parent.parent.f_header!=undefined)
	   headerFrm= parent.parent.parent.f_header;
    else
	   headerFrm =parent.parent.f_header;
	patient_class = headerFrm.document.prescription_header_form.patient_class.value;
	var source_code					= headerFrm.document.prescription_header_form.source_code.value;
	var drug_db_interface_yn        = headerFrm.document.prescription_header_form.drug_db_interface_yn.value;
   	var drug_db_dosecheck_yn        = headerFrm.document.prescription_header_form.drug_db_dosecheck_yn.value;
	var drug_db_duptherapy_yn       = headerFrm.document.prescription_header_form.drug_db_duptherapy_yn.value;
   	var drug_db_interact_check_yn   = headerFrm.document.prescription_header_form.drug_db_interact_check_yn.value;
  	var drug_db_contraind_check_yn  = headerFrm.document.prescription_header_form.drug_db_contraind_check_yn.value;
   	var drug_db_allergy_check_yn    = headerFrm.document.prescription_header_form.drug_db_allergy_check_yn.value;
   	var take_home_medication		= headerFrm.document.prescription_header_form.take_home_medication.value;
   	var location_type		= headerFrm.document.prescription_header_form.location_type.value;
   	var location_code		= headerFrm.document.prescription_header_form.location_code.value;
   	var priority			= headerFrm.document.prescription_header_form.priority.value;
   	var iv_prep_yn			= headerFrm.document.prescription_header_form.iv_prep_default.value;
   	var pract_id			= headerFrm.document.prescription_header_form.pract_id.value;
   	var resp_id			= headerFrm.document.prescription_header_form.resp_id.value;
	   	var weight			 = headerFrm.document.prescription_header_form.weight.value;//Added for IN:070451 start
	        var bsa			 = headerFrm.document.prescription_header_form.bsa.value;//Added for IN:070451 start
	
	var act_patient_class			= headerFrm.actual_patient_class.value; //CRF-0062
	var xmlStr ="<root><SEARCH act_pat_class =\"" + act_patient_class + "\" /></root>";
	
	// RUT-CRF-0062 [IN029600] -- REVERTED
	var qryString			= bean_id+"&bean_name="+bean_name+"&validate=DRUGCODE&drugCodes="+drug_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dosecheck_yn="+drug_db_dosecheck_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&location_type="+location_type+"&location_code="+location_code+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code+"&pract_id="+pract_id+"&resp_id="+resp_id+"&weight="+weight+"&bsa="+bsa;//Modified for IN:070451 added weight,bsa
	//  var qryString			= bean_id+"&bean_name="+bean_name+"&validate=DRUGCODE&drugCodes="+drug_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dosecheck_yn="+drug_db_dosecheck_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&location_type="+location_type+"&location_code="+location_code+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code+"&pract_id="+pract_id+"&resp_id="+resp_id+"&source_code="+source_code+"&act_patient_class="+act_patient_class;
	
	submitXML(qryString, xmlStr); // CRF-0062
	
}

function searchOrdersetPiggyBackforVehicle(searchBasedOn, order_set_code,patient_class,fluid_code,bean_id,bean_name,patient_id,encounter_id,drug_code){   

   	var pract_id			= parent.parent.f_header.document.prescription_header_form.pract_id.value;
   	var resp_id			= parent.parent.f_header.document.prescription_header_form.resp_id.value;
   	var patient_class			= parent.parent.f_header.document.prescription_header_form.patient_class.value;

	var qryString			= bean_id+"&bean_name="+bean_name+"&validate=FLUIDCODE&fluidCodes="+fluid_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&drug_code="+drug_code+"&order_set_code="+order_set_code+"&pract_id="+pract_id+"&resp_id="+resp_id;
	submitXML(qryString, "");
	
}

async function searchIVDrug(frmObj,searchBasedOn, obj,rec_no){

	var frmObj			= document.formIVPiggyBackDrugDetails;	
	var patient_class	= frmObj.patient_class.value;
	var headerFrm		= "";

	if(parent.parent.parent.f_header!=undefined)
	   headerFrm= parent.parent.parent.f_header.document.prescription_header_form;
    else
	   headerFrm =parent.parent.f_header.document.prescription_header_form;
	
	patient_class = headerFrm.patient_class.value;

	var source_code					= headerFrm.source_code.value;
	var source_type					= headerFrm.source_type.value;
	var drug_db_interface_yn        = headerFrm.drug_db_interface_yn.value;
   	var drug_db_dosecheck_yn        = headerFrm.drug_db_dosecheck_yn.value;
	var drug_db_duptherapy_yn       = headerFrm.drug_db_duptherapy_yn.value;
   	var drug_db_interact_check_yn   = headerFrm.drug_db_interact_check_yn.value;
  	var drug_db_contraind_check_yn  = headerFrm.drug_db_contraind_check_yn.value;
   	var drug_db_allergy_check_yn    = headerFrm.drug_db_allergy_check_yn.value;
	var encounter_id				= headerFrm.encounter_id.value;
	var patient_id					= headerFrm.patient_id.value;
	var act_patient_class			= headerFrm.actual_patient_class.value;
	var discharge_yn				= headerFrm.take_home_medication.value;
	var priority					= headerFrm.priority.value;

	var location_type			= headerFrm.location_type.value;
	var location_code			= headerFrm.location_code.value;
	var take_home_medication	= headerFrm.take_home_medication.value;
	var date_of_birth			= headerFrm.date_of_birth.value;
	var gender					= headerFrm.gender.value;
   	var pract_id			= headerFrm.pract_id.value;
   	var resp_id			= headerFrm.resp_id.value;
	//var buildMAR_yn	=	frmObj.buildMAR_yn.value;
	var buildMAR_yn	=	getMAR_app_yn(headerFrm);
	var iv_prep_yn = "";
	var weight			 = headerFrm.weight.value;//Added for IN:070451 start
        var bsa			 = headerFrm.bsa.value;//Added for IN:070451 start
	if(frmObj.admixture.checked == true){
		iv_prep_yn = "4";
	}
	else{
		iv_prep_yn = "3";
	}

	var drug_code			= frmObj.drug_code.value; //Added for SRR20056-SCF-7374 Incident No. 27415  and the same(selected) drug_code is passed to "DrugSearchForIV" to control the selection of the same drug from drug search

	var retArray		= await DrugSearchForIV(searchBasedOn, obj, '', drug_code, 'DrugSearchBean', '', '', act_patient_class,priority, 'D',"N",discharge_yn,source_type, source_code, patient_id, encounter_id,date_of_birth,gender,iv_prep_yn);
		/*if(headerFrm.take_home_medication_op_chk!=undefined)
			headerFrm.take_home_medication_op_chk.disabled=true;//commented for NMC-JD-CRF-0063*/
	//added for NMC-JD-CRF-0063
	if(headerFrm.take_home_medication_op_chk!=undefined){
		if(retArray.length==0 || retArray==""){
			if(headerFrm.take_home_medication_op_chk.disabled==false){
				headerFrm.take_home_medication_op_chk.disabled=false;
			}
		}
		else{
				headerFrm.take_home_medication_op_chk.disabled=true;
		}
	}
	var starting_date = headerFrm.ref_sys_date.value;
	var disp_locn_code='';
	if (retArray != null && retArray != "" ){
		var drug_code   = retArray[0];
		var trade_code  = retArray[1];
		var trade_name  = retArray[2];
		var bean_id		= frmObj.bean_id.value;
		var bean_name	= frmObj.bean_name.value;
		
		var xmlStr ="<root><SEARCH act_pat_class =\"" + act_patient_class + "\" /></root>"
		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=DRUGCODE&drugCodes="+drug_code+"&patient_id="+frmObj.patient_id.value+"&encounter_id="+frmObj.encounter_id.value+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dosecheck_yn="+drug_db_dosecheck_yn+"&drug_db_duptherapy_yn="+drug_db_duptherapy_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&trade_code="+trade_code+"&trade_name="+trade_name+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn+"&pract_id="+pract_id+"&resp_id="+resp_id+"&buildMAR_yn="+buildMAR_yn+"&starting_date="+starting_date+"&weight="+weight+"&bsa="+bsa; //Modified for IN:070451 added weight,bsa
		submitXML(qryString,xmlStr); // CRF-0062
		disp_locn_code=getDispLocation(bean_id,bean_name);
		disp_locn_code=trimString(disp_locn_code);
	}
	parent.parent.f_ivbutton.document.location.href=parent.parent.f_ivbutton.document.location.href+"&disp_locn_code="+disp_locn_code;
}
function getDispLocation(bean_id,bean_name){
//	var xmlDoc	= new ActiveXObject("Microsoft.XMLDom"); //commented by Anbarasi
	var xmlDoc = ""; 
//	var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
	var xmlHttp = new XMLHttpRequest();
	//xmlDoc.loadXML("<root><SEARCH /></root>");
	var xmlStr="<root><SEARCH /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "IVPBValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=FINDDISPLOCATION", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	return responseText;
	
}

function clearFrequencyList()	{
	var len =parent.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.FREQUENCY.options.length;
	for(var i=0;i<len;i++) {
		parent.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.FREQUENCY.remove("FREQUENCY") ;
	}
}

function addFrequencyList(code,desc)	{

	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	parent.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.FREQUENCY.add(element);
}

function setdefFrequency(code,desc)	{

	parent.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.FREQUENCY.selectedIndex=0;
}

function setUOM(strength_uom,stock_value){
	var frmObj	    = parent.f_iv_pb.formIVPiggyBackVehicle;
	var frmAdminObj	= parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	var frmDrugObj  = parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
	parent.f_iv_pb_admin_dtls.document.getElementById("infusion_uom_display").innerHTML =  "<b>"+strength_uom+"/</b>";
	frmObj.volume.value			= stock_value; 
	frmAdminObj.STOCK_VALUE.value	= stock_value;
	frmDrugObj.f_i_flag.value = "Y";

	calInfusionRate();
} 

function assignDosageDetails(drug_code,objValue,strength,strength_uom,dosage,dosage_uom,freq_code,allergy_override,dose_override,currentrx_override,sRegRopt,drug_adr_count, pract_id, resp_id,buildMAR_yn,iv_fluid_yn,dur_val){ //iv_fluid_yn parameter added for "SRR20056-SCF-7374 IN27415"
	var frmDrugObj	= parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
	var frmAdminObj	= parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	var drugCodeFreq = "";
//	var patient_class = frmDrugObj.patient_class.value;

	//Added for SCF - SRR20056-SCF-7176
	frmAdminObj.DURN_VALUE.value = dur_val;
	calEndDate();
	calInfusionRate();//added for SCF-7176
	// Till here added 	for SCF - SRR20056-SCF-7176

	if(parent.parent.parent.f_header!=undefined)
	   headerFrm= parent.parent.parent.f_header.document.prescription_header_form;
    else
	   headerFrm =parent.parent.f_header.document.prescription_header_form;
	var patient_class = headerFrm.patient_class.value;
	document.location.href = "../jsp/IVPiggyBackDrugDetails.jsp?patient_id="+frmAdminObj.patient_id.value+"&encounter_id="+frmAdminObj.encounter_id.value+"&adr_count="+drug_adr_count+"&drugSelect=Y"+"&MAR_app_yn="+buildMAR_yn+"&act_patient_class="+patient_class;

/*	frmDrugObj.drug_code.value		= drug_code; 
	frmDrugObj.drug_name.value		= objValue;  
	if(frmDrugObj.drug_name != null){
		frmDrugObj.drug_name.disabled	= true;
	}
	if(frmDrugObj.drug_search != null){
		frmDrugObj.drug_search.disabled = true;    
    }
	if((frmDrugObj.order_set_code.value != null && frmDrugObj.order_set_code.value != "" && frmDrugObj.order_set_code.value!="undefined")){
		frmDrugObj.dosage.value = dosage;  
		frmDrugObj.dosage_unit.innerHTML = "<b>"+dosage_uom+"</b>";

		if(sRegRopt == "R") {
			frmDrugObj.drug_name.disabled	= true;
			frmDrugObj.drug_search.disabled = true;
		}else{
			frmDrugObj.drug_name.disabled	= false;
			frmDrugObj.drug_search.disabled = false;
		}
	}
	else{
		frmDrugObj.dosage.value = strength;      
		frmDrugObj.dosage_unit.innerHTML = "<b>"+strength_uom+"</b>";
	}
		*/	
	if(parent.f_iv_pb_drug_legend.document.getElementById('btn_override_reason')){
		if(allergy_override!="N"||dose_override!="N"||currentrx_override!="")
			parent.f_iv_pb_drug_legend.frmpiggybacklegends.btn_override_reason.style.display="inline";
	}

	if(drug_adr_count>0){

        // frmDrugObj.document.getElementById("ADR_img").style.visibility='visible';
	}
	else{
		//  frmDrugObj.document.getElementById("ADR_img").style.visibility='hidden';

	}
	parent.f_iv_pb_drug_legend.location.href		= "../jsp/IVPiggyBackLegends.jsp?patient_id="+frmAdminObj.patient_id.value+"&encounter_id="+frmAdminObj.encounter_id.value;
/*	The whole if block is commented for "SRR20056-SCF-7374 IN27415"
	if(iv_fluid_yn!='Y' &&( frmDrugObj.order_set_code.value==undefined || frmDrugObj.order_set_code.value == null || frmDrugObj.order_set_code.value == "")){ //condition iv_fluid_yn=='N' &&( frmDrugObj.order_set_code.value==undefined parameter added for "SRR20056-SCF-7374 IN27415"
		setDfltFluid(drug_code, pract_id, resp_id);
	}
*/
	setSchedule();
}

async function showOverRideRemarks(){
	var frmObj			= parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
	var patient_id		= frmObj.patient_id.value;
	var encounter_id	= frmObj.encounter_id.value;
	var generic_id		= frmObj.generic_id.value;
	var generic_name	= frmObj.generic_name.value;
	var drug_desc		= frmObj.drug_name.value;
	var daily_dose		= frmObj.daily_dose.value;
	var unit_dose		= frmObj.unit_dose.value;
	var mono_graph		= frmObj.mono_graph.value;
	var limit_ind		= frmObj.limit_ind.value;
	var allergy_yn		= frmObj.allergy_yn.value;
	var current_rx		= frmObj.current_rx.value;
	var drug_code		= frmObj.drug_code.value;
   	var srl_no			= frmObj.srl_no.value;
	var allergy			= frmObj.allergy_desc.value;
	var exceed_dose		= frmObj.exceed_dose_desc.value;
	var dup_drug		= frmObj.dup_drug_desc.value;
	var min_unit_dose	= frmObj.min_unit_dose.value;  
	var min_daily_dose	= frmObj.min_daily_dose.value;
	var dosage_std		= frmObj.dosage_std.value//Modified for IN:070451
	var dosage_unit		= frmObj.recom_dosage_unit.value;//Modified for IN:070451
	var bean_id			= frmObj.bean_id.value;
	var bean_name	    = frmObj.bean_name.value;
	var abuse_exists=frmObj.abuse_exists.value;//added for aakh-crf-0140
	var abuse_action=frmObj.abuse_action.value;//added for aakh-crf-0140	
	var abuse_override=frmObj.abuse_override.value;//added for aakh-crf-0140
	//Added for IN:070451 start
	var max_daily_ceeling_dose	= frmObj.max_daily_ceeling_dose.value;
	var min_daily_ceeling_dose	= frmObj.min_daily_ceeling_dose.value;
	var max_unit_ceeling_dose	= frmObj.max_unit_ceeling_dose.value;
	var min_unit_ceeling_dose	= frmObj.min_unit_ceeling_dose.value;
	//Added for IN:070451 end
	//Added for IN:072715 start
	var allergy_remarks_code=frmObj.allergy_remarks_code.value;
	var dose_remarks_code=frmObj.dose_remarks_code.value;
	var currentrx_remarks_code=frmObj.currentrx_remarks_code.value;
	var abuse_override_remarks=frmObj.abuse_override_remarks.value;//added for aakh-crf-0140
	
	//Added for IN:072715 end
	var dialogHeight	= "45vh";

	if(current_rx=="Y" && limit_ind=="N" && allergy_yn=="Y")
		dialogHeight	= "45vh";
	else if ( (current_rx=="Y" && limit_ind=="N") || (current_rx=="Y" && allergy_yn=="Y") || (limit_ind=="N" && allergy_yn=="Y" ))
		dialogHeight	= "45vh";
	else
		dialogHeight	= "35vh";

	var dialogWidth	= "45vw";
	var dialogTop	= "";
	var dialogLeft	= "";
	var center		= "0";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "";


	//retArray		= window.showModalDialog("../jsp/CompoundingOverRideReason.jsp?gen_id="+generic_id+"&gen_name="+escape(generic_name)+"&pat_id="+patient_id+"&enc_id="+encounter_id+"&drug_desc="+escape(drug_desc)+"&mono_graph="+escape(mono_graph)+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&limit_ind="+limit_ind+"&drug_code="+drug_code+"&srl_no="+srl_no+"&allergy="+escape(allergy)+"&exceed_dose="+escape(exceed_dose)+"&dup_drug="+escape(dup_drug)+"&min_unit_dose="+min_unit_dose+"&min_daily_dose="+min_daily_dose, arguments, features);
	//alert("../jsp/PrescriptionOverRideReason.jsp?gen_id="+generic_id+"&gen_name="+escape(generic_name)+"&pat_id="+patient_id+"&enc_id="+encounter_id+"&drug_desc="+escape(drug_desc)+"&mono_graph="+escape(mono_graph)+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&limit_ind="+limit_ind+"&drug_code="+drug_code+"&srl_no="+srl_no+"&allergy="+escape(allergy)+"&exceed_dose="+escape(exceed_dose)+"&dup_drug="+escape(dup_drug)+"&min_unit_dose="+min_unit_dose+"&min_daily_dose="+min_daily_dose+"&dosage_std="+dosage_std+"&dosage_unit="+dosage_unit, arguments, features);
//added for aakh-crf-0140
	retArray		= await top.window.showModalDialog("../../ePH/jsp/PrescriptionOverRideReason.jsp?gen_id="+generic_id+"&gen_name="+encodeURIComponent(generic_name,"UTF-8") +"&pat_id="+patient_id+"&enc_id="+encounter_id+"&drug_desc="+encodeURIComponent(drug_desc,"UTF-8") +"&mono_graph="+encodeURIComponent(mono_graph,"UTF-8") +"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&limit_ind="+limit_ind+"&drug_code="+drug_code+"&srl_no="+srl_no+"&allergy="+encodeURIComponent(allergy,"UTF-8")+"&exceed_dose="+ encodeURIComponent(exceed_dose,"UTF-8") +"&dup_drug="+encodeURIComponent(dup_drug,"UTF-8") +"&min_unit_dose="+min_unit_dose+"&min_daily_dose="+min_daily_dose+"&dosage_std="+dosage_std+"&dosage_unit="+dosage_unit+"&max_daily_ceeling_dose="+max_daily_ceeling_dose+"&min_daily_ceeling_dose="+min_daily_ceeling_dose+"&max_unit_ceeling_dose="+max_unit_ceeling_dose+"&min_unit_ceeling_dose="+min_unit_ceeling_dose+"&allergy_remarks_code="+allergy_remarks_code+"&dose_remarks_code="+dose_remarks_code+"&currentrx_remarks_code="+currentrx_remarks_code+"&abuse_exists="+abuse_exists+"&abuse_action="+abuse_action+"&abuse_override_remarks="+abuse_override_remarks, arguments, features);//Modified for IN:070451, Modified for IN:072715

	if ( retArray != null && retArray != "" ){

		var allergy_override    = "N";
		var dose_override	    = "N";
		var currentrx_override  = "N";
		var abuse_override="N";//added for aakh-crf-0140
		var split_vals	= retArray.split(":::");
		frmObj.allergy_desc.value		= split_vals[0];
		frmObj.exceed_dose_desc.value	= split_vals[1];
		frmObj.dup_drug_desc.value		= split_vals[2];
		//Added for IN:072715 start
		frmObj.allergy_remarks_code.value		= split_vals[3];
		frmObj.dose_remarks_code.value	= split_vals[4];
		frmObj.currentrx_remarks_code.value		= split_vals[5];
		frmObj.abuse_override.value	=split_vals[6];//added for aakh-crf-0140
		frmObj.abuse_override_remarks.value	=split_vals[7];//added for aakh-crf-0140
                //Added for IN:072715 end
		if(split_vals[0] !="") allergy_override = "Y"; 
		if(split_vals[1] !="") dose_override	 = "Y"; 
		if(split_vals[2] !="") currentrx_override = "Y"; 
		if(split_vals[6] !="") abuse_override="Y";//added for aakh-crf-0140
		if(srl_no == "")
			srl_no = 1;
		overrideImg(allergy_yn,allergy_override,limit_ind,dose_override,current_rx,currentrx_override,abuse_action,abuse_override);//modified for aakh-crf-0140

		drug_code		= frmObj.drug_code.value;
		//modified for aakh-crf-0140
		var qryString			=	bean_id+"&bean_name="+bean_name+"&validate=OVERRIDE_REASON&drug_code="+drug_code+"&srl_no="+srl_no+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&allergy="+split_vals[0]+"&exceed_dose="+split_vals[1]+"&dup_drug="+split_vals[2]+"&limit_ind="+limit_ind+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&allergy_remarks_code="+split_vals[3]+"&dose_remarks_code="+split_vals[4]+"&currentrx_remarks_code="+split_vals[5]+"&abuse_override="+split_vals[6]+"&abuse_override_remarks="+split_vals[7]; // Modified for IN:072715
		submitXML(qryString, "");  
	}
}


/*function searchIVVehicle(frmObj,searchBasedOn, obj,rec_no,lang_id) {

	var frmObj			= document.formIVPiggyBackVehicle;
	var frmAdminObj		= parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	var default_code	= frmObj.vehicle_code.value;
	var patient_class	= frmAdminObj.patient_class.value;
	var drug_codes		= parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.drug_code.value;
	//alert('drug codes ... '+parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.drug_code.value);
	var discharge_yn	="";
	var source_code     =""; 
	var encounter_id	="";
	var header_form;

	if(parent.parent.parent.f_header!=undefined)
		header_form = parent.parent.parent.f_header.document.prescription_header_form;
    else
		header_form = parent.parent.f_header.document.prescription_header_form;

	source_code					= header_form.source_code.value;
	source_type					= header_form.source_type.value;
	encounter_id				= header_form.encounter_id.value;
	patient_id					= header_form.patient_id.value;
	act_patient_class			= header_form.actual_patient_class.value;
	discharge_yn				= header_form.take_home_medication.value;
	priority					= header_form.priority.value;
	var location_type			= header_form.location_type.value;
	var location_code			= header_form.location_code.value;
	var take_home_medication	= header_form.take_home_medication.value;
	var date_of_birth			= header_form.date_of_birth.value;
	var gender					= header_form.gender.value;

	var iv_prep_yn = "";
	if(parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.admixture.checked == true){
		iv_prep_yn = "4";
	}
	else{
		iv_prep_yn = "3";
	}

	var retArray		= DrugSearchForIV(searchBasedOn, obj, '', drug_codes, 'DrugSearchBean', '', '', act_patient_class, priority, 'F',"N", discharge_yn, source_type, source_code, patient_id, encounter_id,date_of_birth,gender,iv_prep_yn);

	if(default_code != "" && default_code != retArray[0] && retArray != null && retArray != ""){
		frmObj.remarks.style.visibility='visible';
		frmObj.mandatory1.style.visibility='visible';
	}

	if (retArray != null && retArray != "" ){

		frmObj.vehicle_code.value	  = retArray[0];
		frmObj.vehicle_name.value     = retArray[1];
		frmObj.vehicle_name.disabled  = true;
		frmObj.vehicle_search.disabled= true;
		
		//setSchedule(frmAdminObj.FREQUENCY.value);
		var base_uom			= retArray[4];
		var trade_code			= retArray[5];
		var bean_id				= frmAdminObj.bean_id.value;
		var bean_name			= frmAdminObj.bean_name.value;
		var drg_code					  = parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.drug_code.value;

		var qryString			= bean_id+"&bean_name="+bean_name+"&validate=VEHILEDETAILS&drug_code="+frmObj.vehicle_code.value+"&base_uom="+base_uom+"&patient_id="+frmAdminObj.patient_id.value+"&encounter_id="+frmAdminObj.encounter_id.value+"&drg_code="+drg_code+"&lang_id="+lang_id+"&trade_code="+trade_code+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn;
		submitXML(qryString, "");
	}
}

function checkValidDrug(checkFor, objVal) {
	if (trimCheck(objVal) != "") {
		if (checkFor == "D")
			searchIVDrug(formIVPiggyBackDrugDetails,'D', document.formIVPiggyBackDrugDetails.drug_name);	
		else if (checkFor == "F")
			searchIVVehicle(formIVPiggyBackVehicle,'D', document.formIVPiggyBackVehicle.vehicle_name)
	}
}
*/
function setStockDetails(mode, stock_value, stock_uom_code, stock_uom_desc){
	var frmObj	    = parent.f_iv_pb.formIVPiggyBackVehicle;
	var frmAdminObj	= parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;

	infusion_uom_display = stock_uom_desc;

	if (mode == 1){
		parent.f_iv_pb.document.getElementById('volume').value			= stock_value;
		parent.f_iv_pb.document.getElementById('volume_reference').value = stock_value;// Added for CRF AAKH-CRF-0094
		parent.f_iv_pb_admin_dtls.document.getElementById('EQVL_UOM_CODE').value	= stock_uom_code;
//		frmObj.volume_unit_desc.innerHTML= "<b>"+stock_uom_code+"</b>";
		parent.f_iv_pb.document.getElementById('volume_unit_desc').innerHTML= "<b>"+stock_uom_desc+"</b>";
		parent.f_iv_pb_admin_dtls.document.getElementById('STOCK_UOM_CODE').value	= stock_uom_code;
		parent.f_iv_pb_admin_dtls.document.getElementById('STOCK_VALUE').value	= stock_value;
		parent.f_iv_pb.document.getElementById('BASE_VOLUME').value			= stock_value;
		parent.f_iv_pb.document.getElementById('volume_unit').value	= stock_uom_code;
//		frmObj.volume_unit_desc.innerHTML= "<b>"+stock_uom_code+"</b>";
//		frmAdminObj.infusion_uom_display.innerHTML =  "<b>"+stock_uom_code+"/</b>";
		parent.f_iv_pb_admin_dtls.document.getElementById('infusion_uom_display').innerHTML =  "<b>"+stock_uom_desc+"/</b>";		// Changed for SKR-SCF-0089 [Incident No. 028819]

	}
	else if (mode == 2) {
		alert(getMessage("PH_EQU_UOM_NOT_DEFINED","PH"));
	}
}

function setInfuseValue(infuse, call_mode,default_comp_fluid_falg) {	//default_comp_fluid_falg added for ML-MMOH-CRF-1223
	//call_mode="DRUGLOAD" added for SRR20056-SCF-7374 Incident No. 27415
	var val			= infuse.split("::");
	var frmAdminObj	= parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	if(val[0] != ""){
		frmAdminObj.INFUSION_PERIOD_VALUE.value = val[0];
		
		if(val[1]=="H"){
//			frmAdminObj.infuse_over_time.innerHTML	= "<b>Hour(s)</b>";
			parent.f_iv_pb_admin_dtls.document.getElementById('INFUSION_PERIOD_UOM').value	= "H";
			parent.f_iv_pb_admin_dtls.document.getElementById('infusion_time').value			= "H";		
			parent.f_iv_pb_admin_dtls.document.getElementById('infuse_over_str').innerHTML	= getHrsMinStr(val[0],'H');
		}
		else if(val[1]=="M"){
//			frmAdminObj.infuse_over_time.innerHTML	= "<b>Minute(s)</b>";
			parent.f_iv_pb_admin_dtls.document.getElementById('INFUSION_PERIOD_UOM').value	= "M";
			parent.f_iv_pb_admin_dtls.document.getElementById('infusion_time').value			= "M";
			parent.f_iv_pb_admin_dtls.document.getElementById('infuse_over_str').innerHTML	= getHrsMinStr(val[0],'M');
		}		
		parent.f_iv_pb_admin_dtls.document.getElementById('INFUSION_UOM').value =  parent.f_iv_pb_admin_dtls.document.getElementById('INFUSION_PERIOD_UOM').value;		
	}	
	freqChange(frmAdminObj.FREQUENCY,"",frmAdminObj);	
	if(val[0] != "") 
	{
//		alert("=setInfuseValue=val[0]="+ val[0]);
		 calInfusionRate();	  //commented for SCF-7176//Uncommented for ML-MMOH-CRF-1223
		//calInfuseOver(call_mode);
		calInfuseOver(call_mode,default_comp_fluid_falg);//default_comp_fluid_falg added for ML-MMOH-CRF-1223
	}
}
function calInfusionRate(){
   	var frmAdminObj	= parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	var frmObj	    = parent.f_iv_pb.formIVPiggyBackVehicle;
	var volume = frmObj.volume.value;

	var infusion_period_value		= frmAdminObj.INFUSION_PERIOD_VALUE.value;
	var infusion_period_value_min	= frmAdminObj.INFUSION_PERIOD_VALUE_MIN.value;
	if(volume!="" && parseFloat(volume) != 0 && ((infusion_period_value !="" && parseFloat(infusion_period_value) != 0) || (infusion_period_value_min !="" && parseFloat(infusion_period_value_min) != 0))){
		var InfuseOverInMin = getInfuseOverInMin(infusion_period_value,infusion_period_value_min); 
		var InfuseOverInHr = parseFloat(InfuseOverInMin/60); 

		InfuseOverInHr =Math.round(InfuseOverInHr*100)/100;

		if(frmAdminObj.infusion_time.value == "H")
			var infusion_value = (volume)*60/(InfuseOverInMin);		//added for SCF-7847 //var infusion_value = (volume)/(InfuseOverInHr); //commeted for SCF-7847
		else
			var infusion_value = (volume)/(InfuseOverInMin);

		frmAdminObj.infusion_over_insert_value.value = InfuseOverInHr;
		infusion_value = Math.round(infusion_value*100)/100;
		frmAdminObj.INFUSION_VALUE.value = infusion_value;
		var str = getHrsMinStr(InfuseOverInHr,frmAdminObj.infusion_time.value);
		parent.f_iv_pb_admin_dtls.document.getElementById('infuse_over_str').innerHTML	= str;
		var inf_over= frmAdminObj.INFUSION_PERIOD_VALUE.value;
		var infusion_time=frmAdminObj.infusion_time.value;
		var dur_val=parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.DURN_VALUE.value; 

		if(frmAdminObj.durn_unit.value == "H")
			dur_val = dur_val*60;
		if(frmAdminObj.durn_unit.value == "D")
			dur_val = dur_val*24*60;
		if(frmAdminObj.durn_unit.value == "W")
			dur_val = dur_val*7*24*60;
		if(frmAdminObj.durn_unit.value == "L")
			dur_val = dur_val*30*24*60;
		if(frmAdminObj.durn_unit.value == "Y")
			dur_val = dur_val*12*30*24*60;

		
		if(parseInt(frmAdminObj.INFUSION_PERIOD_VALUE_MIN.value)>59){
			alert(getMessage("INVALID_TIME_MINUTE","PH"));
			//frmAdminObj.INFUSION_PERIOD_VALUE_MIN.focus();

		}else if((parseFloat(InfuseOverInMin) )>( parseInt(dur_val))){			
				alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));			
				frmAdminObj.DURN_VALUE.focus();						
		}
		
	}    

	showAdminRate();	
}

function calInfuseOver(call_mode,default_comp_fluid_falg){//default_comp_fluid_falg added for ML-MMOH-CRF-1223
	//call_mode="DRUGLOAD" added for SRR20056-SCF-7374 Incident No. 27415
	var frmAdminObj	= parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	var frmObj	    = parent.f_iv_pb.formIVPiggyBackVehicle;
	var drugfrmObj = parent.f_iv_pb_drug.document.formIVPiggyBackDrugDetails;

	if(drugfrmObj.iv_fluid_yn.value == "Y" ){ // condition , code added for 24668
		setCalculatedQty(drugfrmObj.STRENGTH_VALUE,'frmCalInfuseOver');
	}

	var volume = frmObj.volume.value;
	var infusion_value = frmAdminObj.INFUSION_VALUE.value;
	var infusion_over; //infusion_over added for SRR20056-SCF-7374 Incident No. 27415 to avoid the confusion with infusion_value
	if(volume !="" && volume!="0" && frmAdminObj.INFUSION_VALUE.value!="" &&  parseFloat(infusion_value) > 0){

		if(parseInt(frmObj.volume.value)< parseInt(frmAdminObj.INFUSION_VALUE.value)){
			//alert(getMessage("INFUSION_RATE_CANNOT_GREATER","PH"));
			//frmAdminObj.INFUSION_VALUE.focus();
		}

		var unit = 	frmAdminObj.infusion_time.value;
		//If condition and else  added for SRR20056-SCF-7374 Incident No. 27415
		//alert("default_comp_fluid_falg===="+default_comp_fluid_falg+"INFUSION_PERIOD_VALUE=="+frmAdminObj.INFUSION_PERIOD_VALUE.value);
		if((call_mode!=undefined && call_mode == "DRUGLOAD") || default_comp_fluid_falg =="true"){
			infusion_over = frmAdminObj.INFUSION_PERIOD_VALUE.value;
			if(unit == "H"){
				infusion_over = infusion_over * 60;
			}
		}
		else{
			if(unit == "H"){
				infusion_over = volume * 60/infusion_value;
			}
			else{
				infusion_over = volume/infusion_value;
			}
		}
		var dur_val=parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.DURN_VALUE.value;
		if(frmAdminObj.durn_unit.value == "H")
			dur_val = dur_val*60;
		if(frmAdminObj.durn_unit.value == "D")
			dur_val = dur_val*24*60;
		if(frmAdminObj.durn_unit.value == "W")
			dur_val = dur_val*7*24*60;
		if(frmAdminObj.durn_unit.value == "L")
			dur_val = dur_val*30*24*60;
		if(frmAdminObj.durn_unit.value == "Y")
			dur_val = dur_val*12*30*24*60;


		infusion_over = infusion_over/60;
		infusion_over = Math.round(infusion_over*100)/100;		
		if((parseFloat(infusion_over)) >( parseInt(dur_val))){
			alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
		}

		HrsMinStr = getHrsMinStr(infusion_over,unit);
		parent.f_iv_pb_admin_dtls.document.getElementById('infusion_over_insert_value').value = infusion_over;
		parent.f_iv_pb_admin_dtls.document.getElementById('infuse_over_str').innerHTML	= HrsMinStr;
		
		hrs = HrsMinStr.substring(1,HrsMinStr.indexOf("H")-1);
		min = HrsMinStr.substring(HrsMinStr.indexOf("H")+4,HrsMinStr.indexOf("M")-1);

		frmAdminObj.INFUSION_PERIOD_VALUE.value = Math.floor(hrs);
		frmAdminObj.INFUSION_PERIOD_VALUE_MIN.value = Math.round(min);

	
	}
	showAdminRate();
}

function setOrderType(orderTypeCode) {
	if(document.formIVPiggyBackVehicle != undefined)
		var frmObj	    = document.formIVPiggyBackVehicle;
	else
		var frmObj	    = parent.f_iv_pb.formIVPiggyBackVehicle;
	       
	frmObj.ORDER_TYPE_CODE.value = orderTypeCode;
}

function ChangeInfuseOverTime(obj){
	var frmAdminObj	= parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	frmAdminObj.INFUSION_PERIOD_UOM.value		=	"H";
	if(obj.value=="H"){
		
		frmAdminObj.INFUSION_UOM.value				=	"H";
	//	frmAdminObj.infuse_over_str.innerHTML	= getHrsMinStr(frmAdminObj.INFUSION_PERIOD_VALUE.value,'H');
	}
	else if(obj.value=="M"){
		frmAdminObj.INFUSION_UOM.value				=	"M";
	//	frmAdminObj.infuse_over_str.innerHTML	= getHrsMinStr(frmAdminObj.INFUSION_PERIOD_VALUE.value,'M');
	}
}

function submitXML(qryString, xmlStr,eval_yn) {
//commented by Anbarasi	
//	var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
//	var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	
	if (xmlStr != "")
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "IVPBValidate.jsp?bean_id="+qryString, false);
	
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	
	eval(responseText); 
	
}

function calEndDate(){
	
	if(parent.f_iv_pb_admin_dtls != undefined)
	  var frmAdminObj	= parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	else
	  var frmAdminObj	= parent.f_detail.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail

	var durn_value	= frmAdminObj.DURN_VALUE.value;
	var start_date	= frmAdminObj.START_DATE.value;
	var encounter_id= frmAdminObj.encounter_id.value;
	var patient_id  = frmAdminObj.patient_id.value;

	var bean_id		= frmAdminObj.bean_id.value;
	var bean_name	= frmAdminObj.bean_name.value;
	var durn_unit	= "H";
	var durn_desc=frmAdminObj.durn_unit.value;
	var repeat_durn_type=frmAdminObj.repeat_durn_type.value;
	var freq_nature=frmAdminObj.freq_nature.value;
	repeat_durn_type=durn_desc;

/*	below if block commented for issue
	if( repeat_durn_type=="H" || repeat_durn_type=="M" ){
		repeat_durn_type="D";
		durn_value="1";
	}*/

	if(durn_value != "" && start_date!=""){

		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=populateEndDate&start_date="+start_date+"&durn_value="+durn_value+"&durn_unit="+durn_unit+"&patient_id="+frmAdminObj.patient_id.value+"&encounter_id="+frmAdminObj.encounter_id.value+"&repeat_durn_type="+repeat_durn_type+"&freq_nature="+freq_nature;


		submitXML(qryString, "");
	}
	else{
		frmAdminObj.END_DATE.value = "";
	}
}

function setEndDate(end_date){
/*	if(parent.f_iv_pb_admin_dtls != undefined)
	  var frmAdminObj	= parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	else
	  var frmAdminObj	= parent.f_detail.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail

	frmAdminObj.END_DATE.value = end_date;*/

}

async function DisplaySchedule(obj) {

	var frmAdminObj	= parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	var frmObj	    = parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
	var frmObjPB    = parent.f_iv_pb.formIVPiggyBackVehicle;

	var bean_id		= frmAdminObj.iv_bean_id.value;
	var bean_name	= frmAdminObj.iv_bean_name.value;
	var freq_code	= frmAdminObj.FREQUENCY.value;
	var facility_id	= frmAdminObj.facility_id.value;
	var drug_code	= frmObj.drug_code.value;

	if(drug_code ==""){
		alert(getMessage("DRUG_CANT_BE_BLANK","PH"));
		frmObj.drug_name.focus();
		return;
	}

	var row_value	= "1";
	var	max_qty			= 0;
	var	unit_qty		= 0;
	var split_dose_yn	= "N";

	var split_qty		= frmObjPB.volume.value;
	var qty_reqd_yn		= "N";
	var uom_desc		= parent.f_iv_pb_admin_dtls.volume_unit //replaced volume_unit_desc with volume_unit for IN25615 --22/12/2010-- priya
//	var uom_desc		= frmObjPB.volume_unit_desc.innerText;
	if(frmObj.iv_fluid_yn.value == "Y")
	{
		uom_desc =frmObj.STRENGTH_UOM.value;
	}
	uom_desc=encodeURIComponent(uom_desc,"UTF-8");

	var chk_max			= "N";
	var chk_unit		= "N";
	
	if(max_qty != "0"){
		chk_max = "Y";
	}
	if(unit_qty != "0"){
		chk_unit = "Y";
	}
	pr_duration_type = frmAdminObj.durn_unit.value;
	var durationType_P = frmAdminObj.repeat_durn_type.value; 
	pr_duration = frmAdminObj.DURN_VALUE.value;
	start_time_day_param = frmAdminObj.START_DATE.value;

	if(uom_desc !="" && split_qty != "") {
		var dialogTop		= "";
		var dialogHeight	= "55vh";
		var dialogWidth		= "55vw";
		var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
		var arguments		= "";

		var retVal 			=await top.window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?mode=1&bean_id="+bean_id+"&uom_desc="+uom_desc+"&bean_name="+bean_name+"&chk_max="+chk_max+"&chk_unit="+chk_unit+"&max_qty="+max_qty+"&split_dose_yn="+split_dose_yn+"&split_qty="+split_qty+"&qty_reqd_yn="+qty_reqd_yn+"&unit_qty="+unit_qty+"&code="+drug_code+"&row_value="+row_value+"&facility_id="+facility_id+"&freq_code="+freq_code+"&start_time_day_param="+start_time_day_param+"&pr_duration="+pr_duration+"&pr_duration_type="+pr_duration_type+"&org_drug_code="+drug_code+"&interval_durn_type="+durationType_P+"&module_id=PH&called_from=",arguments,features);
	
		if(retVal!=null)
		{
			frmAdminObj.sched_medn_yn.value = "Y";
			//======
			var split_vals = retVal[1].split('~~');	
			var len = frmAdminObj.FREQUENCY.options.length;			
			for(img=0;img<len;img++)
			{
				if(frmAdminObj.FREQUENCY.options[img].value==split_vals[0])
				{
					frmAdminObj.FREQUENCY.selectedIndex= img	;
					break;
				}
			}
			freqChange(frmAdminObj.FREQUENCY);
			var len1 = frmAdminObj.durn_unit.options.length;
			for(img1=0;img1<len1;img1++)
			{
				if(frmAdminObj.durn_unit.options[img1].value==retVal[3])
				{
					frmAdminObj.durn_unit.selectedIndex= img1	;
					break;
				}
			}
			frmAdminObj.DURN_VALUE.value=retVal[2];
			calEndDate();
			ExternalDosageCheck('','admndtl');
			//========
		}
		else
			frmAdminObj.sched_medn_yn.value	= "N";
	}
	autoschedule1();
}

function releaseRX(){	
	if(parent.f_ivdetails !=undefined)
		var adminForm	    = parent.f_ivdetails.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;			
	else
		var adminForm	= parent.f_detail.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;		
           
	var mode1        = adminForm.mode1.value;
	if(mode1!='amend')
		releaseRX1();
	else	
		releaseRX2();
}
async function releaseRX1(){
	var pat_class= parent.f_ivdetails.f_iv_pb_drug.document.formIVPiggyBackDrugDetails.patient_class.value; //added for the SKR-SCF-0536[Inc:33123] 
	if(parent.f_ivdetails !=undefined){
		var adminForm	= parent.f_ivdetails.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
		var frmObj	    = parent.f_ivdetails.f_iv_pb_drug.formIVPiggyBackDrugDetails;
		var fluidForm	= parent.f_ivdetails.f_iv_pb.formIVPiggyBackVehicle;
	}
	else{
		var adminForm	= parent.f_detail.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail
		var frmObj	    = parent.f_detail.f_iv_pb_drug.formIVPiggyBackDrugDetails;
		var fluidForm	= parent.f_detail.f_iv_pb.formIVPiggyBackVehicle;
	}
	var validate_overide_on_confirm_yn=frmObj.validate_overide_on_confirm_yn.value;//Added for IN:069887
    if(parent.parent.f_header!=undefined){
		var headerform=parent.parent.f_header.prescription_header_form;
	}
    else{
		var headerform=parent.f_header.prescription_header_form;
	}
    var act_patient_class = headerform.actual_patient_class.value;//NMC-JD-CRF-0063[TFS:15129]
    var dflt_disp_locn_lbl = parent.f_ivbutton.document.getElementById("dflt_disp_locn_lbl").innerText;
	if(act_patient_class == "OP"){
		if(dflt_disp_locn_lbl == "" || dflt_disp_locn_lbl== null)
		{
			alert(getMessage("PH_MANDATORY", "PH"));
			return false;
		}
	}//END
	headerform.buildMAR_yn.value = frmObj.buildMAR_yn.value; //added for  MMS-QH-CRF-0080 [IN:038064]
	if(validateFrequency( adminForm)){
		if(chkMandatoryFlds("Release")){
			var allergic_yn ="N";
			allergic_yn= headerform.allergic_yn.value ;
			if(headerform !=undefined){
				var th_medn		= "N";
				if(headerform.take_home_medication.checked==true)    //RUT-CRF-0062 Added to insert into OR_ORDER table
					th_medn="D";
				var height		= headerform.height.value;
				var weight		= headerform.weight.value;
				if(headerform != null){
					 var height_unit	= headerform.height_unit.value;
					 if (height_unit == "")
						height_unit	= "Cms";
					 var weight_unit	= headerform.weight_unit.value;
					 if (weight_unit == "")
						weight_unit	= "Kgs";
				}
				else{
					var height_unit	= "";
					var weight_unit = "";
				}
				var bsa			= headerform.bsa.value;
				var bmi			= headerform.bmi.value;
				var bsa_unit	= "BSA";

				var priority	= headerform.priority.value;
				if(parent.f_ivdetails ==undefined){
					parent.f_options.formIVPrescriptionOptions.type.disabled=false;
					frmObj.admixture.disabled=false;
				}
				var ord_date_time	= headerform.sys_date.value;	
			}  
			
			if(frmObj.admixture.checked==true){
				iv_presc_yn	=	"I";
			}
			else
				iv_presc_yn	=	"N";
			
			var bean_id		= adminForm.iv_bean_id.value;
			var bean_name	= adminForm.iv_bean_name.value;
	//		var dosage      = frmObj.dosage.value;
			var calc_dose_based_on;
			if(frmObj.CALC_DOSE_BASED_ON[0].checked)
				calc_dose_based_on=frmObj.CALC_DOSE_BASED_ON[0].value;
			else
				calc_dose_based_on=frmObj.CALC_DOSE_BASED_ON[1].value;

			//alert(calc_dose_based_on);
			var calc_dose_value = frmObj.CALC_DOSE_VALUE.value;
			var calc_dose_by = frmObj.CALC_DOSE_BY.value;
			var dosage="";
			if(calc_dose_based_on=="B"){
				dosage      = frmObj.strength_value_wt_bsa.value;
			}
			else{
				dosage      = frmObj.STRENGTH_VALUE.value;
			}
			var volume      =fluidForm.volume.value; 
			var patient_id      =adminForm.patient_id.value; 
			var encounter_id      =adminForm.encounter_id.value; 
			var discharge_yn	= headerform.take_home_medication.value;
			var lstInfusionRateDurnUnit	 = adminForm.infusion_time.options[adminForm.infusion_time.selectedIndex].value;//INO71514

			var bl_install_yn = headerform.bl_install_yn.value; 
			var bl_disp_charge_dtl_in_rx_yn = headerform.bl_disp_charge_dtl_in_rx_yn.value; 

			if(bl_install_yn == 'Y' && bl_disp_charge_dtl_in_rx_yn =='Y'){

				var actual_patient_class = headerform.actual_patient_class.value
				var fluid_code		  = fluidForm.vehicle.value;
				var infusion_over	  = adminForm.infusion_over_insert_value.value;
				var tot_inf_prd		= fluidForm.volume.value;
				var durn_value		= adminForm.DURN_VALUE.value;
				var iv_prep_yn		= document.formIVPrescriptionButtons.iv_prep_yn.value;
	//			durn_unit = 	adminForm.durn_unit.value;
				var xmlStr ="<root><SEARCH ";					

				xmlStr+= "patient_id =\"" + patient_id + "\" " ;
				xmlStr+= "fluid_code =\"" + fluid_code + "\" " ;
				xmlStr+= "infusion_over =\"" + infusion_over + "\" " ;
				xmlStr+= "tot_inf_prd =\"" + tot_inf_prd + "\" " ;
				xmlStr+= "durn_value =\"" + durn_value + "\" " ;
			//	xmlStr+= "durn_unit =\"" + durn_unit + "\" " ;
				xmlStr+= "actual_patient_class =\"" + actual_patient_class + "\" " ;
				xmlStr+= "discharge_yn =\"" + discharge_yn + "\" " ;
				xmlStr+= "INFUSE_OVER_UNIT =\"" + lstInfusionRateDurnUnit + "\" " ;//INO71514
				xmlStr +=" /></root>";

				var temp_jsp="IVPrescriptionValidate.jsp?validate=GET_BL_ERRORS_IVWA"+"&bean_id="+bean_id+"&bean_name="+bean_name+patient_id+"&encounter_id="+encounter_id+"&iv_prep_yn="+iv_prep_yn+"&infusion_over="+infusion_over+"&durn_value="+durn_value+"&discharge_yn="+discharge_yn;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText ;
				if(responseText != undefined){
					responseText = trimString(responseText);
					if(responseText != null && responseText !=""){
						if(!eval(responseText)){	
							return false;
						}
					}
				}
			}		

		//	adminForm.bean_id.value		= adminForm.iv_bean_id.value;
		//	adminForm.bean_name.value	= adminForm.iv_bean_name.value;
			adminForm.DURN_UNIT.value	= adminForm.durn_unit.value;
			DrugIndicationRemarks	= frmObj.DrugIndicationRemarks.value;
			var abuse_exists= frmObj.abuse_exists.value;//added for AAKH-CRF-0140
			var abuse_action= frmObj.abuse_action.value;//added for AAKH-CRF-0140
			//alert("abuse_exists in releaseRX1"+abuse_exists+"abuse_action"+abuse_action);
			abuse_override=frmObj.abuse_override.value;//added for akkh-crf0140
			abuse_override_remarks=frmObj.abuse_override_remarks.value;//added-for-aakh-crf-0140
			//alert("abuse_override in releaseRX1"+abuse_override+"abuse_override_remarks"+abuse_override_remarks);
			var dosagetype = frmObj.dosage.value;
			var AUTH_YN_VAL=frmObj.AUTH_YN_VAL.value;
			var APPROVAL_YN_VAL=frmObj.APPROVAL_YN_VAL.value;
			var COSIGN_YN_VAL= frmObj.COSIGN_YN_VAL.value;
//GHL-CRF-0549 - start
			var allow_alternate = "N";
			if(frmObj.allow_alternate_yn!=undefined){
				if(frmObj.allow_alternate_yn.checked==true)
					allow_alternate = "Y";
			}
//GHL-CRF-0549 - end	

			//ADDED FOR aakh-crf-0140 start
			
			var abuse_restric_trn=frmObj.abuse_restric_trn.value;
			
			if(abuse_restric_trn=="Y"){
	
	
	showAbuseDetails("", frmObj.patient_id.value, frmObj.encounter_id.value, "", frmObj.drug_code.value,"Alert")
	return false;
}
			var xmlStr		= "<root><SEARCH ";
			xmlStr			+= " PRIORITY=\""+ priority + "\" ";    
			xmlStr			+= " HEIGHT=\""+ height + "\" ";
			xmlStr			+= " HEIGHT_UNIT=\""+ height_unit + "\" ";
			xmlStr			+= " WEIGHT=\""+ weight + "\" ";
			xmlStr			+= " WEIGHT_UNIT=\""+ weight_unit + "\" ";
			xmlStr			+= " BSA=\""+ bsa + "\" ";
			xmlStr			+= " BSA_UNIT=\""+ bsa_unit + "\" ";
			xmlStr			+= " IV_PRESC_YN=\""+ iv_presc_yn + "\" ";
			xmlStr			+= " TH_MEDN=\""+ th_medn + "\" ";
			xmlStr			+= " allergic_yn=\""+ allergic_yn + "\" ";	
			xmlStr			+= " AUTH_YN_VAL=\""+ AUTH_YN_VAL + "\" ";	
			xmlStr			+= " APPROVAL_YN_VAL=\""+ APPROVAL_YN_VAL + "\" ";
			xmlStr			+= " COSIGN_YN_VAL=\""+ COSIGN_YN_VAL + "\" ";
			xmlStr			+= " ord_date_time=\""+ ord_date_time + "\" ";
			xmlStr			+= " buildMAR_yn=\""+ frmObj.buildMAR_yn.value + "\" ";
			xmlStr			+= " DRUG_QTY_UOM=\""+ frmObj.STRENGTH_UOM.value + "\" ";
			xmlStr			+= " BMI=\""+ bmi + "\" ";
			xmlStr			+= " DRUG_INDICATION=\""+ DrugIndicationRemarks + "\" ";
			xmlStr			+= " ROOM_NUM=\""+ headerform.room_num.value + "\" ";  //Added for MMS-QH-CRF-0080 [IN:038064] 
			xmlStr			+= " BED_NUM=\""+ headerform.bed_num.value + "\" ";    //Added for MMS-QH-CRF-0080 [IN:038064] 
			xmlStr			+= " allow_alternate=\""+ allow_alternate + "\" ";//GHL-CRF-0549
			xmlStr			+= " INFUSE_OVER_UNIT=\""+ lstInfusionRateDurnUnit + "\" ";//INO71514
			xmlStr			+= " validate_overide_on_confirm_yn=\""+ validate_overide_on_confirm_yn + "\" ";//Added for IN:069887
			xmlStr			+= " abuse_exists=\""+ abuse_exists + "\" ";    //Added for MMS-QH-CRF-0080 [IN:038064] 
			xmlStr			+= " abuse_action=\""+ abuse_action + "\" ";//GHL-CRF-0549
			xmlStr			+= " abuse_override=\""+ abuse_override + "\" ";//INO71514
			xmlStr			+= " abuse_override_remarks=\""+ abuse_override_remarks + "\" ";//Added for IN:069887
			
			xmlStr			+= buildXMLString(adminForm) + buildXMLString(fluidForm)+ " /></root>"; //+buildXMLString(frmObj)
			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=RELEASE&patient_id="+patient_id+"&encounter_id="+encounter_id+"&dosage="+dosage+"&volume="+volume+"&dosage_type="+dosagetype+"&calc_dose_based_on="+calc_dose_based_on+"&calc_dose_value="+calc_dose_value+"&calc_dose_by="+calc_dose_by+"&pat_class="+pat_class;  //+"&pat_class="+pat_class added for the SKR-SCF-0536[Inc:33123] 
			
			//ADDED FOR aakh-crf-0140 end
			submitXML(qryString, xmlStr);
			if (result) {
				reloadPage();
			}
			else if(flag=="INSUFFICIENT_STOCK") {
				var dialogHeight	= "12";
				var dialogWidth		= "45";
				var dialogTop		= "250";
				var dialogLeft		= "40";
				var center			= "0";
				var status			= "no";
				var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments		= "";

				retVal = await window.showModalDialog("../../ePH/jsp/IVPrescriptionStockDetails.jsp?bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
			}
		}
	}
}

function assignResult(_result, _message, _flag, _narcotic_yn, _print_ord_sht_rule_ind) {//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
	result		= _result;
	message		= _message;
	flag		= _flag;
	narcotic_yn = _narcotic_yn;
	print_ord_sht_rule_ind=_print_ord_sht_rule_ind;
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
				if(arrObj[i].checked)
					val = "Y";
				else 
					val ="N";
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
				val= val.substringing(0,val.lastIndexOf('~'))
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

/*function previewRX(){
	if (chkMandatoryFlds("Preview")) {

		var adminForm	 = parent.f_ivdetails.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
		var drgdtlsForm	 = parent.f_ivdetails.f_iv_pb_drug.formIVPiggyBackDrugDetails;
		var fluidForm	 = parent.f_ivdetails.f_iv_pb.formIVPiggyBackVehicle;

		var titletext		  = "IV Piggy Back";
		var patient_id		  = drgdtlsForm.patient_id.value;
		var encounter_id	  = drgdtlsForm.encounter_id.value;
		var date			  = adminForm.start_date.value;
		var pract_name		  = adminForm.pract_id.value;
		var patient_class	  = drgdtlsForm.patient_class.value;
		var bean_id			  = drgdtlsForm.bean_id.value;
		var bean_name		  = drgdtlsForm.bean_name.value;
		var fluid_code		  = fluidForm.vehicle_code.value;
		var fluid_name		  = fluidForm.vehicle_name.value;
		var infusion_rate	  = adminForm.infusion_value.value;
		var infusion_over	  = adminForm.infusion_period_value.value;
		var infusion_rate_uom = adminForm.infusion_uom_display.innerText+adminForm.infusion_time.options[adminForm.infusion_time.selectedIndex].innerText;
		var freq_desc		  = adminForm.frequency.options[adminForm.frequency.selectedIndex].innerText;
		var start_date		  = adminForm.start_date.value;
		var end_date		  = adminForm.end_date.value;
		var locn_code		  = adminForm.locn_code.value;
		var tot_inf_prd		  = fluidForm.volume.value;
		
		var dialogHeight= "20";
		var dialogWidth	= "50";
		var dialogTop	= "250";
		var center		= "1";
		var status		= "no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "";
		 alert("../jsp/IVPrescriptionPreviewFrames.jsp?titletext="+titletext+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+start_date+"&locn_code="+locn_code+"&pract_name="+pract_name+"&actual_patient_class="+patient_class+"&fluid_name="+escape(fluid_name)+"&fluid_flow_rate="+""+"&fluid_inf_prd="+""+"&tot_inf_prd="+tot_inf_prd+"&frequency="+""+"&start_date="+start_date+"&end_date="+end_date+"&tot_inf_uom="+""+"&fluid_volume_uom="+""+"&fluid_code="+fluid_code+"&infusion_rate="+infusion_rate+"&infusion_over="+infusion_over+"&infusion_rate_uom="+infusion_rate_uom+"&freq_desc="+freq_desc);
		var retVal		= window.showModalDialog("../jsp/IVPrescriptionPreviewFrames.jsp?titletext="+titletext+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+start_date+"&locn_code="+locn_code+"&pract_name="+pract_name+"&actual_patient_class="+patient_class+"&fluid_name="+escape(fluid_name)+"&fluid_flow_rate="+""+"&fluid_inf_prd="+""+"&tot_inf_prd="+tot_inf_prd+"&frequency="+""+"&start_date="+start_date+"&end_date="+end_date+"&tot_inf_uom="+""+"&fluid_volume_uom="+""+"&fluid_code="+fluid_code+"&infusion_rate="+infusion_rate+"&infusion_over="+infusion_over+"&infusion_rate_uom="+infusion_rate_uom+"&freq_desc="+freq_desc, arguments, features);
	}
}*/

function chkMandatoryFlds(calledMode) {
	var retStat = true;
	if (calledMode == "Preview" || calledMode == "Release") {
       if(parent.f_ivdetails !=undefined){
		  
			var frmAdminObj	= parent.f_ivdetails.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
			var frmObj	    = parent.f_ivdetails.f_iv_pb_drug.formIVPiggyBackDrugDetails;
			var frmObjPiggyBack	= parent.f_ivdetails.f_iv_pb.formIVPiggyBackVehicle;
		}
		else {
			
			var frmAdminObj	= parent.f_detail.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail
			var frmObj	    = parent.f_detail.f_iv_pb_drug.formIVPiggyBackDrugDetails;
			var frmObjPiggyBack	= parent.f_detail.f_iv_pb.formIVPiggyBackVehicle;
               
		}

		/*var frmAdminObj		= parent.f_ivdetails.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
		var frmObj			= parent.f_ivdetails.f_iv_pb_drug.formIVPiggyBackDrugDetails;
		var frmObjPiggyBack = parent.f_ivdetails.f_iv_pb.formIVPiggyBackVehicle;*/
		inf_value = frmAdminObj.INFUSION_VALUE.value;			
		if (frmAdminObj.INFUSION_VALUE.value == "" || parseFloat(inf_value) == 0) {
			
			alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
			frmAdminObj.INFUSION_VALUE.focus();
			retStat = false;
		}
		else if ((frmAdminObj.INFUSION_PERIOD_VALUE.value == "" || parseFloat(frmAdminObj.INFUSION_PERIOD_VALUE.value) == 0) && (frmAdminObj.INFUSION_PERIOD_VALUE_MIN.value == "" || parseFloat(frmAdminObj.INFUSION_PERIOD_VALUE_MIN.value) == 0)) {
			
			alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
			frmAdminObj.INFUSION_PERIOD_VALUE.focus();
			retStat = false;
		}
		else if (frmObj.drug_code.value == "") {
		
			alert(getMessage("DRUG_CANT_BE_BLANK","PH"));
			frmObj.drug_name.focus();
			retStat = false;
		}
//		else if (frmObj.dosage.value == "" || frmObj.dosage.value == "0") {
		else if (frmObj.CALC_DOSE_BASED_ON[0].checked && (frmObj.STRENGTH_VALUE.value == "" || parseFloat(frmObj.STRENGTH_VALUE.value) == 0)) {
	
			alert(getMessage("PRES_DOSAGE_CANNOT_ZERO","PH"));
			frmObj.dosage.focus();
			retStat = false;
		}else if (frmObj.CALC_DOSE_BASED_ON[1].checked && (frmObj.STRENGTH_VALUE.value == "" || parseFloat(frmObj.STRENGTH_VALUE.value) == 0)) {
	
			alert(getMessage("PRES_DOSAGE_CANNOT_ZERO","PH"));
			frmObj.strength_value_wt_bsa.focus();
			retStat = false;
		}else if (frmObj.STRENGTH_UOM.value == "") {

			alert(getMessage("STR_UOM_CANT_BLANK","PH"));
			frmObj.STRENGTH_UOM.focus();
			retStat = false;
		}
		else if (trimCheck(frmObjPiggyBack.vehicle.value) == "") {

			alert(getMessage("VHCLE_CANT_BLANK","PH"));
			frmObjPiggyBack.vehicle.focus();
			retStat = false;
		}
		else if (trimCheck(frmAdminObj.START_DATE.value) == "") {

			alert(getMessage("PH_START_DATE","PH"));
			retStat = false;
			frmAdminObj.START_DATE.focus();
		}
		else if (trimCheck(frmAdminObj.END_DATE.value) == "") {
	
			alert(getMessage("PH_CURR_END_DATE","PH"));
			retStat = false;
		}
		else if (trimCheck(frmAdminObj.FREQUENCY.value) == "") {

			alert(getMessage("FRQ_CANT_BLANK","PH"));
			retStat = false;
		}
		/*else if(parseInt(frmAdminObj.DURN_VALUE.value) < parseFloat(frmAdminObj.infusion_over_insert_value.value) ){
			
			if(frmAdminObj.infusion_time.value=='H')
			 {
				alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
				//frmAdminObj.DURN_VALUE.focus();
				retStat = false;
			 }
		}*/
		else if (document.getElementById('remarks') != null && parent.f_iv_pb.document.getElementById('remarks') != undefined && parent.f_iv_pb.document.getElementById('remarks') != ""){
			//alert(frmObjPiggyBack.remarks);
			if(document.getElementById('remarks').style.visibility == "visible" && parent.f_iv_pb.document.getElementById('fluid_remarks').value != "1") {
				alert(getMessage("FLD_RMRKS_CANT_BLANK","PH"));
				retStat = false;
			}		
		}else if(parseInt(frmAdminObj.INFUSION_PERIOD_VALUE_MIN.value)>59){
			alert(getMessage("INVALID_TIME_MINUTE","PH"));
			retStat = false;
			//frmAdminObj.INFUSION_PERIOD_VALUE_MIN.focus();
        
		}else{
			var dur_val = frmAdminObj.DURN_VALUE.value;
			if(frmAdminObj.durn_unit.value == "H")
				dur_val = dur_val*60;
			if(frmAdminObj.durn_unit.value == "D")
				dur_val = dur_val*24*60;
			if(frmAdminObj.durn_unit.value == "W")
				dur_val = dur_val*7*24*60;
			if(frmAdminObj.durn_unit.value == "L")
				dur_val = dur_val*30*24*60;
			if(frmAdminObj.durn_unit.value == "Y")
				dur_val = dur_val*12*30*24*60;


			
			infuseOver = getInfuseOverInMin(frmAdminObj.INFUSION_PERIOD_VALUE.value,frmAdminObj.INFUSION_PERIOD_VALUE_MIN.value);
			if(parseInt(dur_val) < parseInt(infuseOver)){
				//if(parseInt(adminForm.DURN_VALUE.value) < parseInt(adminForm.INFUSION_PERIOD_VALUE.value) ){
				alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));
				frmAdminObj.INFUSION_PERIOD_VALUE.focus();
				retStat = false;
			}
		}
	}	
	
	return retStat;
}
function callClearAll(mode, confirm_yn){
	var chk_flag = false;
	/* var drugDetailForm = parent.f_ivdetails.f_iv_pb_drug.document.formIVPiggyBackDrugDetails;
	patient_id = drugDetailForm.patient_id.value;
	encounter_id= drugDetailForm.encounter_id.value;
	pat_class= drugDetailForm.patient_class.value;
	MAR_app_yn= drugDetailForm.MAR_app_yn.value; */ //Commented for IN[033048]
	order_date = "";
	adr_count="";

	if(mode=="1"){
		if(parent.f_ivdetails!=null){
			if(confirm_yn)
				chk_flag = true;
			else{
				if(confirm(getMessage("PH_RECOREDED_DATA_LOST","PH"))) {
					chk_flag = true;
				}
			}
			if(chk_flag){
				adr_count="0";
				var frmObj	    = parent.f_ivdetails.f_iv_pb_drug.formIVPiggyBackDrugDetails;
				var hdrfrmObj	    = parent.parent.f_header.prescription_header_form;
// the below lines are moved from outside of if to this line for 33048 -start			
				var drugDetailForm = parent.f_ivdetails.f_iv_pb_drug.document.formIVPiggyBackDrugDetails;
				patient_id = drugDetailForm.patient_id.value;
				encounter_id= drugDetailForm.encounter_id.value;
				pat_class= drugDetailForm.patient_class.value;
				MAR_app_yn= drugDetailForm.MAR_app_yn.value;
//33048 -end

				var bean_id		= frmObj.bean_id.value;
				var bean_name	= frmObj.bean_name.value;
				var presc_mode	= 0;
			
				var qryString	= bean_id+"&bean_name="+bean_name+"&validate=CLEARBEAN&calledFrom=1"+"&presc_mode="+presc_mode;
				submitXML(qryString, "");

//				parent.f_ivdetails.location.href = parent.f_ivdetails.location.href+"&mode=blank";
				//replaced for IN23800 for reset --20/10/2010 -- sridevi
				order_date = hdrfrmObj.sys_date.value;
				parent.f_ivdetails.location.href = "../jsp/IVPiggyBack.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&mode=blank"; //&MAR_app_ynMAR_app_yn= corrected as &MAR_app_yn=
			}
		}
		else{
			
			parent.f_detail.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.reset();
			parent.f_detail.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.durn_unit.value=parent.f_detail.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.DURN_UNIT.value;
			if(parent.f_detail.f_iv_pb.document.formIVPiggyBackVehicle.amendmode!=undefined){
				if(parent.f_detail.f_iv_pb.document.formIVPiggyBackVehicle.amendmode.value=='amend'){
					parent.f_detail.f_iv_pb.document.formIVPiggyBackVehicle.reset();
					parent.f_detail.f_iv_pb.document.formIVPiggyBackVehicle.vehicle.disabled=false;
					//parent.f_detail.f_iv_pb.document.formIVPiggyBackVehicle.vehicle_search.disabled=false;
				}	
            }
			parent.f_detail.f_iv_pb_drug.document.formIVPiggyBackDrugDetails.reset();
			var frmDrugObj=parent.f_detail.f_iv_pb_drug.document.formIVPiggyBackDrugDetails;
			if(frmDrugObj.CALC_DOSE_BASED_ON[1].checked)
			{
				setCalculateBy(frmDrugObj.CALC_DOSE_BASED_ON[1],"AMEND_RESET");
			}
			else
			{
				setCalculateBy(frmDrugObj.CALC_DOSE_BASED_ON[0],"AMEND_RESET");
			}	
			calEndDate()
		}
	}


}
//added for mms-dm-crf-0204
function cancel(diagnosis_found_yn){

	
	var chk_flag = false;
	
	order_date = "";
	adr_count="";

		if(diagnosis_found_yn=="N"){
			alert(getMessage("REQ_DIAG_PRES_NOT_FOUND",'PH'));
			chk_flag=true;
		}
		if(parent.parent.f_ivdetails!=null){
			
			if(chk_flag){
				adr_count="0";
				var frmObj	    = parent.parent.f_ivdetails.f_iv_pb_drug.formIVPiggyBackDrugDetails;
				var hdrfrmObj	    = parent.parent.parent.f_header.prescription_header_form;
// the below lines are moved from outside of if to this line for 33048 -start			
				var drugDetailForm = parent.parent.f_ivdetails.f_iv_pb_drug.document.formIVPiggyBackDrugDetails;
				patient_id = drugDetailForm.patient_id.value;
				encounter_id= drugDetailForm.encounter_id.value;
				pat_class= drugDetailForm.patient_class.value;
				MAR_app_yn= drugDetailForm.MAR_app_yn.value;
//33048 -end

				var bean_id		= frmObj.bean_id.value;
				var bean_name	= frmObj.bean_name.value;
				var presc_mode	= 0;
			
				var qryString	= bean_id+"&bean_name="+bean_name+"&validate=CLEARBEAN&calledFrom=1"+"&presc_mode="+presc_mode;
				submitXML(qryString, "");

//				parent.f_ivdetails.location.href = parent.f_ivdetails.location.href+"&mode=blank";
				//replaced for IN23800 for reset --20/10/2010 -- sridevi
				order_date = hdrfrmObj.sys_date.value;
				parent.parent.f_ivdetails.location.href = "../jsp/IVPiggyBack.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&mode=blank"; //&MAR_app_ynMAR_app_yn= corrected as &MAR_app_yn=
			}
		
}
	



}

function freqChange(obj,flag,formObj) {

	var freq_code		=	obj.value;
	if(parent.parent.parent.f_header != undefined){
		f_header				= parent.parent.parent.f_header;
	}else{
		f_header				= parent.parent.f_header;
	}
	var patient_class	=	f_header.document.prescription_header_form.patient_class.value;
	if(patient_class=="IP"){
		if(f_header.document.prescription_header_form.take_home_medication.value=="Y")
			patient_class="OP";
	}

	if(formObj != "" && formObj != undefined) {
		var bean_id		= formObj.bean_id.value;
		var bean_name	= formObj.bean_name.value;
		var drug_code	=formObj.drug_code.value;
		formObj = "onload";
	}else{
		if(document.formIVPrescriptionAdminDetail != undefined){
		formObj = "";
			var bean_id		= document.formIVPrescriptionAdminDetail.bean_id.value;
			var bean_name	= document.formIVPrescriptionAdminDetail.bean_name.value;
			var drug_code=document.formIVPrescriptionAdminDetail.drug_code.value;
		}else{
			var bean_id		= parent.f_detail.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.bean_id.value;
			var bean_name	= parent.f_detail.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.bean_name.value;
			var drug_code=parent.f_detail.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.drug_code.value;
		}
	}




	var qryString	= bean_id+"&bean_name="+bean_name+"&validate=populateDurationDesc&drug_code="+drug_code+"&freq_code="+freq_code+"&formObj="+formObj;
	submitXML(qryString, "");


}

function validateFrequency(adminform)
{

	if(adminform == "" || adminform==undefined){
	if( document.formIVPrescriptionAdminDetail != undefined )
		fObj = document.formIVPrescriptionAdminDetail;
	else
		fObj = parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	}else{
		fObj = adminform;
	}
		var freq_nature = fObj.freq_nature.value;
		var interval_value = fObj.interval_value.value;
		var durn_value = fObj.DURN_VALUE.value;

		if(freq_nature=="F" && interval_value >1)
		{
			if((durn_value % interval_value) > 0)
			{
				var rem = durn_value % interval_value;
				var prev_day = parseInt(durn_value) - parseInt(rem);
				var nxt_day = parseInt(durn_value) - parseInt(rem) + parseInt(interval_value);
				var err_msg = getMessage("DURATION_VALUE_MULTIPLE","PH");
				if(prev_day == 0)
				{
					err_msg = err_msg.replace('$ or ',"");
				}
				else
					err_msg = err_msg.replace('$', prev_day);
				err_msg = err_msg.replace('#', nxt_day);
				err_msg = err_msg.replace('%', interval_value);
				alert(err_msg); //		alert("Duration value can be "+prev_day+" or "+nxt_day+" or a multiple of "+interval_value);
				fObj.DURN_VALUE.focus();
				return false;

			} 
			
			fObj.durn_unit.disabled = true;
			
		}
		return true;
}
function dfltDurnDesc(repeat_durn_type,freq_nature,formObj){
//	var freq_nature = document.formIVPrescriptionAdminDetail.freq_nature.value;

	if(formObj != "onload" && document.formIVPrescriptionAdminDetail != undefined )
		fObj = document.formIVPrescriptionAdminDetail;
	else
		fObj = parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;

	if(repeat_durn_type=="L"){
		fObj.durn_unit.value="L";
		fObj.durn_unit.disabled=true;
	}
	if(repeat_durn_type=="W"){
		fObj.durn_unit.value="W";
		fObj.durn_unit.disabled=true;
	}
	if(repeat_durn_type=="D"){
		fObj.durn_unit.value="D";
		fObj.durn_unit.disabled=true;
	}
	if(repeat_durn_type=="H"){
		fObj.durn_unit.value="H";
//		document.prescription_detail_form.durn_value.value="1";
		fObj.durn_unit.disabled=true;
		fObj.calcualted_durn_value.value="1";
	}
	if(repeat_durn_type=="M"){
		fObj.durn_unit.value="M";
//		document.prescription_detail_form.durn_value.value="1";
		fObj.durn_unit.disabled=true;
	}

	if(freq_nature != "P" || freq_nature != 'O'){
		fObj.durn_unit.disabled=false;
	}


}
function validateAllDates(){
	populateEndDate();
}
function assignDurnDesc(repeat_value,repeat_durn_type,freq_nature,interval_value,durn_desc,freq_value,schedule_yn,formObj,durn_value,durn_type){
	if(formObj != "onload"  )
		fObj = document.formIVPrescriptionAdminDetail;
	else
		fObj = parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	
	if(freq_value=="null" || freq_value==null) 
		freq_value=="0";

	if(repeat_durn_type=="L"){
		fObj.durn_unit.value="L";
		removeDurnDescList(formObj);
		populateDurnDesc(repeat_durn_type,formObj);
//		document.prescription_detail_form.durn_desc.disabled=true;
	}
	if(repeat_durn_type=="W"){
		fObj.durn_unit.value="W";
		removeDurnDescList(formObj);
		populateDurnDesc(repeat_durn_type,formObj);
//		document.prescription_detail_form.durn_desc.disabled=true;
	}

	if(repeat_durn_type=="D"){
		fObj.durn_unit.value="D";
		removeDurnDescList(formObj);
		populateDurnDesc(repeat_durn_type,formObj);
//		document.prescription_detail_form.durn_desc.disabled=true;
	}
	if(repeat_durn_type=="H"){
		fObj.durn_unit.value="D";  
		var durn_value = null;
		durn_value = fObj.DURN_VALUE.value;
		if ( durn_value == null || durn_value =="")
			fObj.DURN_VALUE.value="1";
		//document.prescription_detail_form.durn_value.disabled=true;
//		document.prescription_detail_form.durn_desc.disabled=true;

		fObj.calcualted_durn_value.value="1";
		removeDurnDescList(formObj);

		populateDurnDesc(repeat_durn_type,formObj);

	}
	if(repeat_durn_type=="M"){
		fObj.durn_unit.value="D";

		var durn_value = null;
		durn_value = fObj.DURN_VALUE.value;
		if ( durn_value == null || durn_value =="")
			fObj.DURN_VALUE.value="1";

 		fObj.calcualted_durn_value.value="1";
		removeDurnDescList(formObj);
		populateDurnDesc(repeat_durn_type,formObj);
	}

	if(freq_nature=='O'){
		if(fObj.in_durn_desc!=null) {
			fObj.in_durn_desc.value="";
			fObj.in_durn_value.value="";
		}
		fObj.durn_unit.value="D";
		fObj.DURN_VALUE.value="1";
		fObj.DURN_VALUE.disabled=true;
		fObj.END_DATE.disabled=true;
		fObj.calcualted_durn_value.value="1";
		interval_value="1";
		repeat_value="1";
	}

	if(durn_value != undefined && durn_type != undefined){
		fObj.durn_unit.value=durn_type;
		fObj.DURN_VALUE.value=durn_value;	
	}
	fObj.interval_value.value=interval_value;
	fObj.repeat_value.value=repeat_value;
	fObj.freq_nature.value=freq_nature;
	fObj.repeat_durn_type.value=repeat_durn_type;
	fObj.calcualted_durn_value.value=repeat_value;
	fObj.scheduled_yn.value=schedule_yn;
	
	

	populateEndDate(formObj);

}
function populateEndDate(formObj){


	var frmObj_pres_dtl = "";
	if(document.formIVPrescriptionAdminDetail != undefined){
		frmObj_pres_dtl		= document.formIVPrescriptionAdminDetail;
	}else if(parent.f_iv_pb_admin_dtls != undefined ){
		frmObj_pres_dtl = parent.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail;
	}else{
		frmObj_pres_dtl = parent.parent.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail;
	}

	var freq_nature=frmObj_pres_dtl.freq_nature.value;
	var start_date=frmObj_pres_dtl.START_DATE.value;
	var durn_value=frmObj_pres_dtl.DURN_VALUE.value;
	var durn_desc=frmObj_pres_dtl.durn_unit.value;
	var repeat_durn_type=frmObj_pres_dtl.repeat_durn_type.value;


	repeat_durn_type=durn_desc;

	/* below if block commented for issue
	if( repeat_durn_type=="H" || repeat_durn_type=="M" ){
		repeat_durn_type="D";
		durn_value="1";
	}*/

	if(durn_value!=''){
		var bean_id		= frmObj_pres_dtl.bean_id.value;
		var bean_name	= frmObj_pres_dtl.bean_name.value;


		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=populateEndDate&freq_nature="+freq_nature+"&start_date="+start_date+"&durn_value="+durn_value+"&repeat_durn_type="+repeat_durn_type;
		submitXML(qryString, ""); 
	}
}

function assignEndDate(end_date){

	if(parent.f_iv_pb_admin_dtls != undefined)
	  var frmAdminObj	= parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	else
	  var frmAdminObj	= parent.f_detail.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail

	frmAdminObj.END_DATE.value=end_date;
//	frmAdminObj.def_freq_found.value=true;
}

function populateDurnDesc(repeat_durn_type,formObj){
	if(formObj != "onload"  )
		fObj = document.formIVPrescriptionAdminDetail;
	else
		fObj = parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;

	var bean_id		= fObj.bean_id.value;
	var bean_name	= fObj.bean_name.value;

	var qryString	= bean_id+"&bean_name="+bean_name+"&validate=populateDurnDesc&repeat_durn_type="+repeat_durn_type+"&formObj="+formObj;
	submitXML(qryString, ""); 

}
function addDurnDescList(code,desc,formObj)	{
	if(formObj != "onload"  )
		fObj = document.formIVPrescriptionAdminDetail;
	else
		fObj = parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	fObj.durn_unit.add(element);
}
function removeDurnDescList(formObj)	{
	if(formObj != "onload"  )
		fObj = document.formIVPrescriptionAdminDetail;
	else
		fObj = parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	var len = fObj.durn_unit.length;
	for (var i=0; i<=len; i++) {
		fObj.durn_unit.remove("");
	}
}
async function reloadPage() {

	if(parent.f_ivdetails !=undefined){ 
		var frmAdminObj	= parent.f_ivdetails.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;		
		var formObj	=	parent.f_ivdetails.f_iv_pb_drug.formIVPiggyBackDrugDetails;
	}
	else{	
		var frmAdminObj	= parent.f_detail.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail		
		var formObj	=	parent.f_detail.f_iv_pb_drug.formIVPiggyBackDrugDetails;
	}
	var bean_id			= frmAdminObj.iv_bean_id.value;
	var bean_name		= frmAdminObj.iv_bean_name.value;
	var patient_class	= frmAdminObj.patient_class.value;
	var locn_code		= frmAdminObj.LOCN_CODE.value;
	var qryString		= "";
	var retVal= new Array();//code added for IN49320
	
	var headerform ="";
	var order_set_code  = "";
	if(parent.parent.f_header!=undefined){
		headerform=parent.parent.f_header.prescription_header_form;
		order_set_code  = headerform.order_set_code.value;
		patient_class = headerform.patient_class.value;
	}
	else{
		if(parent.f_header!=undefined){
			headerform=parent.f_header.prescription_header_form;
		}
	}

	var narcotic_aprvl_form_req_yn=headerform.narcotic_aprvl_form_req_yn.value;
	var print_narcotic_form_by_default=headerform.print_narcotic_form_by_default.value;
	var print_mar_label_yn = headerform.print_mar_label_yn.value; //added for MMS-QH-CRF-0080 [IN:038064]
	var buildMAR_yn = headerform.buildMAR_yn.value; //added for MMS-QH-CRF-0080 [IN:038064]
	if(formObj.admixture.checked == true){ //added for MMS-QH-CRF-0080 [IN:038064]
		print_mar_label_yn="N";
	}
	if(narcotic_yn == "N"){
		narcotic_aprvl_form_req_yn = "";
		print_narcotic_form_by_default="";
	}

	if(top.content != null)
		top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
	else{
		for(i=0;i<message.length;i++){
			if(message.charAt(i) == ".") 
				break;
		}
		alert(message.substring(0,i+3));
	}

	if(patient_class=='OP' || patient_class=='EM'){
		var xmlStr 			="<root><SEARCH /></root>";
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		xmlHttp.open("POST","IVPBValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=GET_TRNGROUPREF",false);
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
			retVal =await window.showModalDialog("../../ePH/jsp/TokenListForOrders.jsp?trn_group_ref="+responseText,arguments,features);
		}
	}
	var dialogHeight	="12" ;
	var dialogWidth	="30";
	var dialogTop	= "300" ;
	var dialogLeft	= "300" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') || (print_mar_label_yn=="Y" && buildMAR_yn=="Y") || (narcotic_aprvl_form_req_yn=="Y" || narcotic_aprvl_form_req_yn=="y"))//print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
		retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionPrintDialog.jsp?narcotic_aprvl_form_req_yn="+narcotic_aprvl_form_req_yn+"&print_narcotic_form_by_default="+print_narcotic_form_by_default+"&called_from=IVPB"+"&buildMAR_yn="+buildMAR_yn+"&print_mar_label_yn="+print_mar_label_yn+"&print_ord_sht_rule_ind="+print_ord_sht_rule_ind,arguments,features);//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
	if(((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal != undefined && retVal[0] != "" && retVal[0] != "CANCEL") || print_ord_sht_rule_ind =='S'){//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0  && code '&& retVal != ""' added for IN49320 AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "locn_code =\"" + locn_code + "\" " ;
		xmlStr+= "patient_class =\"" + patient_class + "\" " ;
		xmlStr+= "order_set_code =\"" + order_set_code + "\" " 
		if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal.length >0){//If and Else If  Added for Bru-HIMS-CRF-393_1.0 AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
			xmlStr+=" prescriptionPrint=\""+ retVal[0] + "\" ";
			xmlStr+=" NarcoticPrint=\""+ retVal[1] + "\" ";
			xmlStr+=" MARLabelPrint=\""+ retVal[2] + "\" "; //added for MMS-QH-CRF-0080 [IN:038064]
		 }
		else if(print_ord_sht_rule_ind =='S')
			xmlStr+=" prescriptionPrint=\""+ "Y"+ "\" ";
	/*	if (confirm(getMessage("PH_PRINT_PRESCRIPTION","PH")))
			xmlStr+= "print_yn='Y'" ;
		else
			xmlStr+= "print_yn='N'" ;*/

		xmlStr +=" /></root>";
		var temp_jsp="IVPrescriptionValidate.jsp?validate=PRINT&bean_id="+bean_id+"&bean_name="+bean_name;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,true);
		xmlHttp.send(xmlDoc);
	}
	if(frmAdminObj.mode1.value!="amend")
	{
		if(parent.parent.parent.parent.parent.parent.orderMainTab !=null){
			var locnDet = parent.parent.parent.parent.parent.parent.orderMainTab.location.href;
			// if its a amend order then close the window or reload the window
			if(locnDet.indexOf('ammend') != -1)
				//window.close();
				
		    
				parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close(); 
			else{			
				parent.parent.parent.parent.parent.parent.orderMainTab.location.reload();
				/*  Below code added for SKR-SCF-0503 [IN032732] -- Start*/ 
				var isPopup = (window.location.href == window.parent.location.href);
				
					if(window.dialogArguments != null)					
						//window.close();
						
						parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
					else{				
						parent.parent.parent.parent.parent.parent.orderMainTab.location.reload();
						window.location.reload();
						}
				/*  code added for SKR-SCF-0503 [IN032732] -- End*/ 			
				}
		}
		else if(parent.parent.parent.criteriaCategoryButtonFrame !=null){
			parent.parent.parent.criteriaCategoryButtonFrame.location.reload();
		}
	}
	else
	//	window.close();
		
    
		parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close(); 
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
		if(formObj.MARLabel != undefined && formObj.MARLabel.checked) //if & else block added for MMS-QH-CRF-0080 [IN:038064]
			retval[2]="Y";
		else	
			retval[2]="N";
	}
	else{
        retval[0]='CANCEL';
	 
	}
//     window.returnValue=retval;
//	 window.close();
	let dialogBody = parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = retval;
    
    const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}
function setSchedule() {
	
	deleteSchedule();
	makeAutoSchedule();

}

function deleteSchedule() {

	if(document.formIVPrescriptionAdminDetail != undefined)
		var frmObj	= document.formIVPrescriptionAdminDetail;
	else
		var frmObj	    = parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;

	var formObj	=	parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;

	if((document.formIVPrescriptionAdminDetail != undefined ||parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail!=undefined)&&(parent.f_iv_pb_drug.formIVPiggyBackDrugDetails!=undefined)){
		var bean_id			= frmObj.bean_id.value;
		var bean_name		= frmObj.bean_name.value;
		var patient_id		= frmObj.patient_id.value;
		var encounter_id	= frmObj.encounter_id.value;	
		var drug_code		= formObj.drug_code.value;	
		frmObj.querySelectorAll('#btn_schedule').disabled=true;
		frmObj.querySelectorAll('#dosage_label').innerHTML="";
		var qryString	= bean_id+"&bean_name="+bean_name+"&validate=DELETESCHEDULE&drug_code="+drug_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id;
		submitXML(qryString, "");
	}

}

function makeAutoSchedule() {
	// check schedule chkbox is enabled & freq is selected
	// automatic scheduling

	if(document.formIVPrescriptionAdminDetail != undefined){
		var frmObj	= document.formIVPrescriptionAdminDetail;
	}
	else{
		var frmObj	    = parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	}
	


	
	if(document.formIVPrescriptionAdminDetail != undefined ||parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail!=undefined){
	
			var bean_id			= frmObj.bean_id.value;
			var bean_name		= frmObj.bean_name.value;
			var patient_id		= frmObj.patient_id.value;
			var encounter_id	= frmObj.encounter_id.value;	

			if(frmObj.FREQUENCY.value!="") {
				frmObj.btn_schedule.disabled=false;
			var formObj			=	parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;	
				if(formObj != undefined && (formObj.iv_fluid_yn.value == "Y" || formObj.iv_fluid_yn.value == "y")){
					frmObj.STOCK_VALUE.value = formObj.STRENGTH_VALUE.value;
				}

				start_date		= frmObj.START_DATE.value;
				qty_value		= frmObj.STOCK_VALUE.value;
				freq_code		= frmObj.FREQUENCY.value;
				drug_code		= frmObj.drug_code.value;
				
				

				if(drug_code == null || drug_code == "")
					drug_code		= parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.drug_code.value;	

				if(qty_value!="" && qty_value!=="0" && frmObj.freq_nature.value !="I") {

					var qryString	= bean_id+"&bean_name="+bean_name+"&validate=AUTOSCHEDULE&freq_code="+freq_code+"&start_date="+start_date+"&qty_value="+qty_value+"&drug_code="+drug_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id;
					submitXML(qryString, "");
				}else if(frmObj.freq_nature.value =="I"){
					frmObj.btn_schedule.disabled=true;
				}
			}
		
	}


}
function setAdmixtureValue(formObj){
	var iv_prep_yn = "";
	var take_home_medication_ckk_val ="";//added for NMC-JD-CRF-0063 START
	var take_home_medication_op = "";//END
	if(formObj.admixture.checked == true){
		formObj.admixture.value = "Y";
		iv_prep_yn = "4";
	}
	else{
		formObj.admixture.value = "N";
		iv_prep_yn = "3";
	}
	var bean_id					= formObj.iv_bean_id.value;
	var bean_name				= formObj.iv_bean_name.value;
	var f_header				= "";
	if(parent.parent.parent.f_header != undefined){
		f_header				= parent.parent.parent.f_header;
	}else{
		f_header				= parent.parent.f_header;
	}

	var location_type			= f_header.prescription_header_form.location_type.value;
	var location_code			= f_header.prescription_header_form.location_code.value;
	var take_home_medication	= f_header.prescription_header_form.take_home_medication.value;
	var priority				= f_header.prescription_header_form.priority.value;
	if(f_header.prescription_header_form.take_home_medication_ckk_val!=undefined){//Added for NMC-JD-CRF-0063 START
		take_home_medication_ckk_val = f_header.prescription_header_form.take_home_medication_ckk_val.value ;
	}
	if(f_header.prescription_header_form.take_home_medication_op!=undefined){
		take_home_medication_op = f_header.prescription_header_form.take_home_medication_op.value ;
	}//END
	
	var xmlStr ="<root><SEARCH ";					
	xmlStr+= "location_type =\"" + location_type + "\" " ;
	xmlStr+= "location_code =\"" + location_code + "\" " ;
	xmlStr+= "take_home_medication =\"" + take_home_medication + "\" " ;
	xmlStr+= "priority =\"" + priority + "\" " ;
	xmlStr+= "iv_prep_yn =\"" + iv_prep_yn + "\" " ;
	xmlStr+= "take_home_medication_op =\"" + take_home_medication_op + "\" " ;//ADDED FOR NMC-JD-CRF-0063 START
	xmlStr+= "take_home_medication_ckk_val =\"" + take_home_medication_ckk_val + "\" " ;//end
	xmlStr +=" /></root>";

	var temp_jsp="IVPrescriptionValidate.jsp?validate=OrdDispenseLocation"+"&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function setDfltFluid(drug_code, pract_id, resp_id){ //hope this function is not used ("SRR20056-SCF-7374 IN27415")
	var frmObj		= document.formIVPiggyBackDrugDetails;
	var bean_id		= frmObj.bean_id.value;
	var bean_name	= frmObj.bean_name.value;

	var qryString	= bean_id+"&bean_name="+bean_name+"&validate=GETVEHICLE&drug_code="+drug_code+"&patient_id="+frmObj.patient_id.value+"&encounter_id="+frmObj.encounter_id.value+"&pract_id="+pract_id+"&resp_id="+resp_id;
	submitXML(qryString, "");
}

function assignDfltVehicle(fluid_code,dflt_drug_desc, volume_of_drug, default_yn, trade_code, trade_name, fluid_adr_count){ 

	var frmVehicleObj	= parent.f_iv_pb.formIVPiggyBackVehicle;
	var element = document.createElement('OPTION') ;

	element.value		=  fluid_code ;
	element.volume_of_drug		= volume_of_drug ;
	element.trade_code				= trade_code;
	if(trade_name!= "")
		trade_name = "  ("+decodeURIComponent(trade_name)+")";
	element.text		= decodeURIComponent(dflt_drug_desc) +trade_name;
	if(default_yn =='Y'){

		element.selected	=	true;
		frmVehicleObj.default_fluid_name.value	= decodeURIComponent(dflt_drug_desc);
		frmVehicleObj.volume.value				= volume_of_drug;
		frmVehicleObj.vehicle_code.value				= fluid_code;
		if(parseInt(fluid_adr_count)>0)
			frmVehicleObj.document.getElementById("fluid_ADR_img").style.visibility='visible';
		else{
		//	console.log(parent.f_iv_pb.formIVPiggyBackVehicle);
			parent.f_iv_pb.document.getElementById("fluid_ADR_img").style.visibility='hidden';
		}
	}
	frmVehicleObj.vehicle.add(element);
	if(parent.f_iv_pb.document.getElementById('eldImg').style.visibility=="hidden")
		parent.f_iv_pb.document.getElementById('eldImg').style.visibility="visible";
	setSchedule();
}

function clearDfltVehicle(){
	var frmVehicleObj	= parent.f_iv_pb.formIVPiggyBackVehicle;
	if(frmVehicleObj == undefined)
		frmVehicleObj = parent.parent.f_ivdetails.f_iv_pb.formIVPiggyBackVehicle;
	var len =frmVehicleObj.vehicle.options.length;
	for(var i=0;i<len;i++) {
		frmVehicleObj.vehicle.remove("frequency") ;
	}
}

function changeVehicle(obj,param_volume_cal,pres_drug_code){ // param_volume_cal added for AAKH-CRF-0094 //pres_drug_code added for ML-MMOH-CRF-1223
	var frmObj			= document.formIVPiggyBackVehicle;
	var frmAdminObj		= parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	if(parent.parent.parent.f_header!=undefined)
		header_form = parent.parent.parent.f_header.document.prescription_header_form;
    else
		header_form = parent.parent.f_header.document.prescription_header_form;

	var vehicle_code		= frmObj.vehicle.value;
	var trade_code			= frmObj.vehicle.trade_code;
	var default_comp_fluid_falg = frmAdminObj.default_comp_fluid_falg.value;//Added for ML-MMOH-CRF-1223
	if(trade_code == undefined)
		trade_code="";
	var bean_id				= frmAdminObj.bean_id.value;
	var bean_name			= frmAdminObj.bean_name.value;
	var priority				= header_form.priority.value;
	var location_type			= header_form.location_type.value;
	var location_code			= header_form.location_code.value;
	var take_home_medication	= header_form.take_home_medication.value;
	var pract_id	= header_form.pract_id.value;
	var resp_id	= header_form.resp_id.value;
	var iv_prep_yn = "";
	if(parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.admixture.checked == true){
		iv_prep_yn = "4";
	}
	else{
		iv_prep_yn = "3";
	}
    //added for AAKH-CRF-0094 Start
   if(param_volume_cal=="N")
	{
	frmAdminObj.INFUSION_VALUE.value="";
	}//AAKH-CRF-0094 End
	var pres_drug_code		    = parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.drug_code.value;//Added for ML-MMOH-CRF-1223
//alert("vehicle_code@@@==="+vehicle_code+"drug_code=="+ parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.drug_code.value)
	var qryString			= bean_id+"&bean_name="+bean_name+"&validate=VEHILEDETAILS&drug_code="+vehicle_code+"&patient_id="+frmAdminObj.patient_id.value+"&encounter_id="+frmAdminObj.encounter_id.value+"&lang_id="+frmObj.language_id.value+"&trade_code="+trade_code+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&iv_prep_yn="+iv_prep_yn+"&pract_id="+pract_id+"&resp_id="+resp_id+"&pres_drug_code="+pres_drug_code+"&default_comp_fluid_falg="+default_comp_fluid_falg;//Added pres_drug_code,default_comp_fluid_falg for ML-MMOH-CRF-1223
	submitXML(qryString, "");
	frmObj.vehicle_code.value				= vehicle_code;

}
/*function assignDfltVehicle(dflt_drug_code,dflt_drug_desc,volume_of_drug,fluid_adr_count){ 
	var frmVehicleObj	= parent.f_iv_pb.formIVPiggyBackVehicle;
	
	frmVehicleObj.vehicle_code.value		= dflt_drug_code; 
	frmVehicleObj.vehicle_name.value		= dflt_drug_desc;
	frmVehicleObj.default_fluid_name.value	= dflt_drug_desc;
	frmVehicleObj.volume.value				= volume_of_drug;
    //alert("==fluid_adr_count====="+fluid_adr_count+"========");
	if(parseInt(fluid_adr_count)>0){
         frmVehicleObj.document.getElementById("fluid_ADR_img").style.visibility='visible';
	}
	else{
		  frmVehicleObj.document.getElementById("fluid_ADR_img").style.visibility='hidden';
	}
	setSchedule();
}*/

function disableall(){
	var frmObj		= document.formIVPiggyBackDrugDetails;
	frmObj.admixture.checked=false;
	frmObj.admixture.disabled=true; 
	document.getElementById("iv_admixture").visibility="hidden";
	parent.f_iv_pb.document.getElementById("vehicle_det").style.display="none";
} 

function assignDfltVehicleWithAdmin(dflt_drug_code,dflt_drug_desc,volume_of_drug,base_uom,infuse,sRegRopt){
	var frmVehicleObj	= parent.f_iv_pb.formIVPiggyBackVehicle;
	var len =frmVehicleObj.vehicle.options.length;
	for(i=0; i<len;i++){
		if( frmVehicleObj.vehicle.options[i].value == dflt_drug_code)
			frmVehicleObj.vehicle.selectedIndex= i;
	}
		//frmVehicleObj.vehicle_code.value		= dflt_drug_code; 
		//frmVehicleObj.vehicle_name.value		= dflt_drug_desc;
	frmVehicleObj.volume.value				= volume_of_drug;

	parent.f_iv_pb.document.getElementById("volume_unit_desc").innerHTML =  "<b>"+base_uom+"</b>";
	// For Time Delay

	if(sRegRopt == "R") {
		frmVehicleObj.vehicle.disabled		= true;
		//frmVehicleObj.vehicle_search.disabled	= true;
	}

	var aa="";
}

function makeScheduleLink(admin_time,admin_qty,total_qty,freq_size,split_chk,repeat_value){
	var legend	=	"";
	legend	=	"Scheduled Dose";

	parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.repeat_value.value=repeat_value;
	if(parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.btn_schedule && parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.freq_nature.value != "I"){
		parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.btn_schedule.disabled=false;

		var title="<table border=1 cellpadding=0 cellspacing=0 align=center>"+admin_time+admin_qty+"</table>";
	parent.f_iv_pb_admin_dtls.document.getElementById('dosage_label').innerHTML="<label nowrap style='color:red;font-size:10' onmouseover='displayToolTipDataChange(\"" + title + "\");' onmouseout='disasbleToolTipDataChange();'>"+legend+"</label>";
	}
	
}

function displayToolTipDataChange(text){
		 
    buildTableDataChange(text);
    bodwidth  = parent.parent.parent.frames[1].document.body.offsetWidth
    bodheight = parent.parent.parent.frames[1].document.body.offsetHeight
	
    var x     = event.x;
    var y     = event.y;
    x     = x + (document.getElementById("tooltiplayer").offsetWidth)
    y     = y + (document.getElementById("tooltiplayer").offsetHeight)

    if(x<bodwidth)
        x = event.x
    else
        x = x - (document.getElementById("tooltiplayer").offsetWidth*2)
    if(y<bodheight)
        y = event.y
    else
        y = y - (document.getElementById("tooltiplayer").offsetHeight*2)

    y+=document.body.scrollTop
    x+=document.body.scrollLeft
    document.getElementById("tooltiplayer").style.posLeft= x-25;
    document.getElementById("tooltiplayer").style.posTop = y-50;
    document.getElementById("tooltiplayer").style.visibility='visible';
}

function buildTableDataChange(text){
     var tab_dat  = text ;
    document.getElementById("t").innerHTML = tab_dat;

}

function disasbleToolTipDataChange(){
    document.getElementById("tooltiplayer").style.visibility = "hidden" ;
}

function autoschedule1(){

         if(document.formIVPrescriptionAdminDetail != undefined)
		     var frmObj     	= document.formIVPrescriptionAdminDetail;
	     else
		     var frmObj	        = parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;

	     var formObj			=	parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
		 var bean_id			= frmObj.bean_id.value;
	     var bean_name			= frmObj.bean_name.value;
	     var patient_id			= frmObj.patient_id.value;
	     var encounter_id		= frmObj.encounter_id.value;

		 var drug_code		    = formObj.drug_code.value;	
		 var qryString	= bean_id+"&bean_name="+bean_name+"&validate=AUTOSCHEDULE1&drug_code="+drug_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id;
				
		submitXML(qryString, "");
}

async function releaseRX2(){
	
	if(parent.f_ivdetails !=undefined){
		var adminForm	= parent.f_ivdetails.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
		var frmObj	    = parent.f_ivdetails.f_iv_pb_drug.formIVPiggyBackDrugDetails;
		var fluidForm	= parent.f_ivdetails.f_iv_pb.formIVPiggyBackVehicle;
	}
	else{			
		var adminForm	= parent.f_detail.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail
		var frmObj	    = parent.f_detail.f_iv_pb_drug.formIVPiggyBackDrugDetails;
		var fluidForm	= parent.f_detail.f_iv_pb.formIVPiggyBackVehicle;
	}
	var lstInfusionRateDurnUnit	 = adminForm.infusion_time.options[adminForm.infusion_time.selectedIndex].value;//INO71514
	var validate_overide_on_confirm_yn=frmObj.validate_overide_on_confirm_yn.value;//Added for IN:069887
	if(parent.parent.f_header!=undefined){
		var headerform=parent.parent.f_header.prescription_header_form;
	}
	else{
		var headerform=parent.f_header.prescription_header_form;
	}
	var abuse_override_remarks=frmObj.abuse_override_remarks.value;
	var abuse_override=frmObj.abuse_override.value;
	var abuse_exists=frmObj.abuse_exists.value;
	var abuse_action=frmObj.abuse_action.value;
	var buildMAR_yn = frmObj.CALC_DOSE_VALUE.value;
	if(validateFrequency( adminForm)){
		if(chkMandatoryFlds("Release")){
			
			var allergic_yn ="N";
			allergic_yn = headerform.allergic_yn.value;
		
			if(headerform !=undefined){
				var th_medn		= "N";
				var height		= headerform.height.value;
				var weight		= headerform.weight.value;
				if(headerform != null)	{
					 var height_unit	= headerform.height_unit.value;
					 if (height_unit == "")
						height_unit	= "Cms";
					 var weight_unit	= headerform.weight_unit.value;
					 if (weight_unit == "")
						weight_unit	= "Kgs";
				}
				else  {
					var height_unit	= "";
					var weight_unit = "";
				}
				var bsa			= headerform.bsa.value;
				var bsa_unit	= "BSA";

				var priority	= headerform.priority.value;
				if(parent.f_ivdetails ==undefined){
				   parent.f_options.formIVPrescriptionOptions.type.disabled=false;
				   frmObj.admixture.disabled=false;
				}
			}  
			
			if(frmObj.admixture.checked==true){
				iv_presc_yn	=	"I";
			}
			else{
				iv_presc_yn	=	"N";
			}
			if(frmObj.buildMAR_yn.checked==true){
				buildMAR_yn = "Y";
			}
			else{
				buildMAR_yn = "N";
			}
			headerform.buildMAR_yn.value = buildMAR_yn; //added for  MMS-QH-CRF-0080 [IN:038064]
			var bean_id		= adminForm.iv_bean_id.value;
			var bean_name	= adminForm.iv_bean_name.value;
			var mode1="";
			if(adminForm.mode1.value!=undefined)
				mode1       = adminForm.mode1.value;
	//		var dosage      = frmObj.STRENGTH_VALUE.value;
			var calc_dose_based_on;
			if(frmObj.CALC_DOSE_BASED_ON[0].checked)
				calc_dose_based_on=frmObj.CALC_DOSE_BASED_ON[0].value;
			else
				calc_dose_based_on=frmObj.CALC_DOSE_BASED_ON[1].value;

			var calc_dose_value = frmObj.CALC_DOSE_VALUE.value;
			var calc_dose_by = frmObj.CALC_DOSE_BY.value;
			var dosage="";
			if(calc_dose_based_on=="B"){
				dosage      = frmObj.strength_value_wt_bsa.value;
			}
			else{
				dosage      = frmObj.STRENGTH_VALUE.value;
			}
			dosage_type = frmObj.dosage.value;

			var volume      = fluidForm.volume.value;      
			var order_id    =	frmObj.order_id.value;		 
			adminForm.bean_id.value		= adminForm.iv_bean_id.value;
			adminForm.bean_name.value	= adminForm.iv_bean_name.value;
			adminForm.DURN_UNIT.value	= adminForm.durn_unit.value; // added ---priya
			adminForm.STOCK_VALUE.value = fluidForm.volume.value;
		// dosage_type added for issue 24668
			var xmlStr		= "<root><SEARCH ";
			xmlStr			+= " dosage_type=\""+ dosage_type + "\" ";
			xmlStr			+= " PRIORITY=\""+ priority + "\" ";
			xmlStr			+= " HEIGHT=\""+ height + "\" ";
			xmlStr			+= " HEIGHT_UNIT=\""+ height_unit + "\" ";
			xmlStr			+= " WEIGHT=\""+ weight + "\" ";
			xmlStr			+= " WEIGHT_UNIT=\""+ weight_unit + "\" ";
			xmlStr			+= " BSA=\""+ bsa + "\" ";
			xmlStr			+= " BSA_UNIT=\""+ bsa_unit + "\" ";
			xmlStr			+= " IV_PRESC_YN=\""+ iv_presc_yn + "\" ";
			xmlStr			+= " TH_MEDN=\""+ th_medn + "\" ";
			xmlStr			+= " allergic_yn=\""+ allergic_yn + "\" ";	
			xmlStr			+= " pract_id=\""+ headerform.pract_id.value + "\" ";	
			xmlStr			+= " resp_id=\""+ headerform.resp_id.value + "\" ";	
			xmlStr			+= " DRUG_QTY_UOM=\""+ frmObj.STRENGTH_UOM.value + "\" ";
			xmlStr			+= " DRUG_INDICATION=\""+ frmObj.DrugIndicationRemarks.value + "\" ";
			xmlStr			+= " validate_overide_on_confirm_yn=\""+ validate_overide_on_confirm_yn + "\" ";//Added for IN:069887
			xmlStr			+= " abuse_override_remarks=\""+ abuse_override_remarks + "\" ";	
			xmlStr			+= " abuse_override=\""+ abuse_override + "\" ";
			xmlStr			+= " abuse_exists=\""+ abuse_exists + "\" ";
			xmlStr			+= " abuse_action=\""+abuse_action + "\" ";
			
			xmlStr			+= buildXMLString(adminForm) + buildXMLString(fluidForm) + " /></root>";

			var qryString	= bean_id+"&bean_name="+bean_name+"&validate=AMENDRELEASE&patient_id="+adminForm.patient_id.value+"&encounter_id="+adminForm.encounter_id.value+"&order_id="+order_id+"&dosage="+dosage+"&volume="+volume+"&pract_id="+headerform.pract_id.value+"&resp_id="+headerform.resp_id.value+"&buildMAR_yn="+buildMAR_yn+"&calc_dose_based_on="+calc_dose_based_on+"&calc_dose_value="+calc_dose_value+"&calc_dose_by="+calc_dose_by;

			submitXML(qryString, xmlStr);

			if (result) {
				reloadPage();
			}
			else if(flag=="INSUFFICIENT_STOCK") {

				var dialogHeight	= "12";
				var dialogWidth		= "45";
				var dialogTop		= "250";
				var dialogLeft		= "40";
				var center			= "0";
				var status			= "no";
				var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments		= "";
				retVal 				=await window.showModalDialog("../../ePH/jsp/IVPrescriptionStockDetails.jsp?bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
			}
		}
	}
}

function checkadmixture(frmobj){
		
	//var time_flag=frmobj.time_flag.value;
	var time_flag=parent.parent.f_ivbutton.document.formIVPrescriptionButtons.time_flag.value;
	var alert_practitioner_yn=frmobj.alert_practitioner_yn.value;
	if(frmobj.admixture.checked==true){
		if(time_flag!='X'  ){
			if(alert_practitioner_yn=='Y')
				alert(getMessage("PREPARATION_ALERT","PH"));
		}
	}
}

// The following function is to call the Admin Rate jsp to diplay  admin rate of a drug for IV Piggy Back  -- srijagadeesh 22/11/2004

async function adminRate(){
     if(parent.parent.parent.f_header!=undefined) {
	        hdrForm = parent.parent.parent.f_header.document.prescription_header_form;
	 }
	 else{
			hdrForm = parent.parent.f_header.document.prescription_header_form;
	 }

	var weight		= hdrForm.weight.value;
	infuse_over_hr = document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value;
	infuse_over_min = document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE_MIN.value;

//	var infuse_over = document.formIVPrescriptionAdminDetail.infusion_over_insert_value.value; // sri 26189:had precision error in admin rate page hence converted infuse over in min.

	if(infuse_over_min == "")
		infuse_over_min = 0;
	if(infuse_over_hr == "")
		infuse_over_min = 0;
	var infuse_over_in_min = parseInt(infuse_over_hr*60)+parseInt(infuse_over_min);

	var patient_id		  = parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.patient_id.value;
	var encounter_id	  =
		parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.encounter_id.value;
	var infustion_uom = parent.f_iv_pb_admin_dtls.INFUSION_UOM.value;
	var dosage = parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.STRENGTH_VALUE.value;
	var dialogHeight= "50vh";
	var dialogWidth	= "50vw";
	var dialogTop	= "";
	var center		= "1";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var dosage_type="";
	if(parent.f_iv_pb_drug.formIVPiggyBackDrugDetails != undefined)
		dosage_type = parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.dosage.value;
	
	var retVal		=await top.window.showModalDialog("../../ePH/jsp/IVPrescriptionAdminRate.jsp?weight="+weight+"&infuse_over="+infuse_over_in_min+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&infustion_uom=M"+"&dosage="+dosage+"&dosage_type="+dosage_type, arguments, features);  
}

function changeCursor(obj) {
	obj.style.cursor = "pointer";
}

function showAdminRate(){
	
	if(document.formIVPrescriptionAdminDetail != undefined)
		var frmObj	= document.formIVPrescriptionAdminDetail;
	else
		var frmObj	    = parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;


	var infuse_over = trimString(frmObj.infusion_over_insert_value.value);
	if (infuse_over!="" && parseFloat(infuse_over) > 0) {
		parent.f_iv_pb_admin_dtls.document.getElementById("adminrate").style.visibility = 'visible'; 
	}else{
		parent.f_iv_pb_admin_dtls.document.getElementById("adminrate").style.visibility = 'hidden'; 
	}
}

async function fluidRemarks(){
	var patient_id		  = parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.patient_id.value;
	var encounter_id	  =
		parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.encounter_id.value;
	var bean_id = parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.bean_id.value;
	var bean_name = parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.bean_name.value;
	var default_fluid_name = parent.f_iv_pb.formIVPiggyBackVehicle.default_fluid_name.value;
	
	var dialogHeight= "10";
	var dialogWidth	= "25";
	var dialogTop	= "250";
	var center		= "1";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal		= await window.showModalDialog("../jsp/IVPiggyBackRemarks.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&default_fluid_name="+escape(default_fluid_name), arguments, features);  
	if(retVal == 'Y'){
		parent.f_iv_pb.formIVPiggyBackVehicle.fluid_remarks.value = "1";
	}else {
		//parent.f_iv_pb.formIVPiggyBackVehicle.fluid_remarks.value = "0";
	}

}

function storeFluidRemarks(obj,patient_id,encounter_id){
		
		var fluid_remarks = obj.value;
		var frmObj			= document.IVPiggyBackFluidRemarksForm;
		var bean_id		= frmObj.bean_id.value;
		var bean_name	= frmObj.bean_name.value;
		var default_fluid_name	= frmObj.default_fluid_name.value;
		
		var qryString	=			bean_id+"&bean_name="+bean_name+"&validate=FLUIDREMARKS&patient_id="+patient_id+"&encounter_id="+encounter_id+"&fluid_remarks="+escape(fluid_remarks)+"&default_fluid_name="+escape(default_fluid_name);
			submitXML(qryString, "");
	    
	//	window.close();
		
		    
		    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		    dialogTag.close();  
}

function addOption(code, desc,sel) {

	obj=parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.FREQUENCY;
	var opt	= eval(document.createElement('OPTION'));

	opt.value =	trimString(code);
	opt.text = desc;
	if(sel == "selected") opt.selected = true; 
	obj.add(opt);
}

function clearData() {

	obj=parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.FREQUENCY;
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	//var opt	= document.createElement('OPTION');
	//opt.value =	"";
	//opt.text = "   ---- Select ----    ";
	//obj.add(opt);
}
function clearData(obj, mode) {
	if(obj == undefined )
			obj=parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.FREQUENCY;
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
function assignMonoGraphdetails(drug_desc, mono_graph, daily_dose, unit_dose, min_daily_dose, min_unit_dose,dosage_unit,recomm_yn, dosage_std,recomm_dosage_by, calc_by_ind,limit_ind,dosage_by){

  var formobj =parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;

	document.formIVPiggyBackDrugDetails.rec_legend.style.display='inline';
	document.formIVPiggyBackDrugDetails.rec_value.style.display='inline';
	document.formIVPiggyBackDrugDetails.rec_uom.style.display='inline';
	document.formIVPiggyBackDrugDetails.rec_value.innerText=dosage_std;
	document.formIVPiggyBackDrugDetails.rec_uom.innerText=dosage_unit;
	formobj.mono_graph.value	= mono_graph;
	formobj.daily_dose.value			= daily_dose;
	formobj.unit_dose.value			= unit_dose;
	formobj.min_daily_dose.value		= min_daily_dose;
	formobj.min_unit_dose.value		= min_unit_dose;
	formobj.recom_dosage_unit.value   = dosage_unit;
	formobj.drug_desc.value			= unescape(drug_desc);
	formobj.recomm_yn.value			= recomm_yn;
	formobj.dosage_std.value		= dosage_std;
	formobj.recomm_dosage_by.value	= recomm_dosage_by;
	formobj.calc_by_ind.value		= calc_by_ind;
	formobj.limit_ind.value			= limit_ind;
	formobj.dosage_by.value			= dosage_by;
}

function defaultRecomDose(){

	var drug_frmobj		    =  document.formIVPiggyBackDrugDetails;
	var mode = drug_frmobj.mode.value;
	if(mode == 'amend'){
		if(document.getElementById("default_recm_dose_yn").value == "Y" )
			var formObject			=  parent.parent.f_header.document.prescription_header_form;
		//return;
	}
	else
		var formObject			=  parent.parent.parent.f_header.document.prescription_header_form;

	if(formObject.height!=undefined && formObject.height!=null && formObject.weight!=null) {
 
		var weight		= formObject.weight.value;
		var bsa			= formObject.bsa.value;

		var dosage_std	=	drug_frmobj.dosage_std.value;
		var recom_dosage_unit	=	drug_frmobj.recom_dosage_unit.value;
		var recomm_dosage_by	=	drug_frmobj.recomm_dosage_by.value;
		var dosage_by			=	drug_frmobj.dosage_by.value;
		var dosage_unit	=	drug_frmobj.dosage_unit_uom.value;
		if( document.getElementById("default_recm_dose_yn").value == "Y" ) {
			if(!document.getElementById("rec_legend").disabled) {
			
			 if(document.formIVPiggyBackDrugDetails.calc_by_ind.value=="A") {
				 
			  if(recomm_dosage_by == dosage_by){
				
				  if(document.getElementById("calc_by_row2").style.display == "inline")
						{
					  drug_frmobj.strength_value_wt_bsa.value = dosage_std;
						 drug_frmobj.strength_value_wt_bsa.focus();
						 
						}
				
					else
						{
						drug_frmobj.STRENGTH_VALUE.value = dosage_std;
						drug_frmobj.STRENGTH_VALUE.focus();
						}
				}
			  
						}
			else if(formObject.height.value.length > 0 && formObject.weight.value.length > 0){
				 if(drug_frmobj.calc_by_ind.value=="W") {
					 var calc_value	=	parseInt(parseFloat(weight)*parseFloat(dosage_std));
					 document.getElementById("rec_value").innerHTML = calc_value;
					 drug_frmobj.strength_value_wt_bsa.value = calc_value;
					 if(document.getElementById("calc_by_row2").style.display == "inline")
						{
					  drug_frmobj.strength_value_wt_bsa.value = calc_value;
						 drug_frmobj.strength_value_wt_bsa.focus();
						 
						}
				
					else
						{
						drug_frmobj.STRENGTH_VALUE.value = calc_value;
						drug_frmobj.STRENGTH_VALUE.focus();
						}
						 
					 
				 }
				 else if(drug_frmobj.calc_by_ind.value=="B") {
					 var calc_value	=	parseInt(parseFloat(bsa)*parseFloat(dosage_std));
					 document.getElementById("rec_value").innerHTML = calc_value;
					 //drug_frmobj.strength_value_wt_bsa.value = calc_value;
					 if(document.getElementById("calc_by_row2").style.display == "inline")
						{
					  drug_frmobj.strength_value_wt_bsa.value = calc_value;
						 drug_frmobj.strength_value_wt_bsa.focus();
						 
						}
				
					else
						{
						drug_frmobj.STRENGTH_VALUE.value = calc_value;
						drug_frmobj.STRENGTH_VALUE.focus();
						}
				 }
				
			}
		}
	}
		 else{
			
				
				if(recomm_dosage_by == dosage_by){
					drug_frmobj.STRENGTH_VALUE.value = dosage_std;
						drug_frmobj.strength_value_wt_bsa.value = dosage_std;
						if(drug_frmobj.calc_by_row2.style.display == "inline")
					drug_frmobj.strength_value_wt_bsa.focus();
				
						else
						drug_frmobj.STRENGTH_VALUE.focus();
					}
		 }
	}
}

function DosageLimitCheck(obj){
	if(obj.value == "" || parseInt(obj.value) ==0)
		return false;

	//var formObject			=  parent.parent.parent.parent.f_header.document.prescription_header_form;
	var drug_frmobj		    =  document.formIVPiggyBackDrugDetails;
	//var adminObj			=  parent.parent.f_iv_admin.formIVPrescriptionAdminDetail;
	var mode = drug_frmobj.mode.value;

	if(mode=='amend'){
		var formObject			=  parent.parent.f_header.document.prescription_header_form;
		var adminObj			=  parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	}
	else{
		var formObject			= parent.parent.parent.f_header.document.prescription_header_form;
		var adminObj			=  parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	}

	var inf_prd_value = adminObj.infusion_over_insert_value.value;
	var durn_value	  = adminObj.DURN_VALUE.value;
	durn_value = Math.ceil(durn_value/24);
	if((inf_prd_value=='' || inf_prd_value=='0') && (drug_frmobj.drug_code.value != "")){
		alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
		adminObj.INFUSION_VALUE.focus();
		return false;
	}
	var repeat_value					= Math.ceil(parseInt(durn_value)/parseInt(inf_prd_value));

	var external_prod_id    = "";
    if(drug_frmobj.external_product_id != undefined){
		external_prod_id    = drug_frmobj.external_product_id.value;
	}
    var drug_db_dosechk_yn  = formObject.drug_db_dosecheck_yn.value;
	var drug_db_interface_yn = formObject.drug_db_interface_yn.value;
	if(drug_db_interface_yn == "Y"){
		if((external_prod_id!='') && (drug_db_dosechk_yn=="Y")){

			ExternalDosageCheck('','presc');
			return;
		}
	}
	var iv_bean_id = drug_frmobj.iv_bean_id.value;
	var iv_bean_name = drug_frmobj.iv_bean_name.value;
	var patient_id = drug_frmobj.patient_id.value;
	var drug_code = drug_frmobj.drug_code.value;
	var srl_no = drug_frmobj.srl_no.value;
	var qty_value = drug_frmobj.STRENGTH_VALUE.value;
	//var dosage_type = drug_frmobj.dosage_by.value;
	var dosage_type = drug_frmobj.dosage.value;
        //ML-MMOH-CRF-1408 - start
	var weight			 = formObject.weight.value;
	var bsa			 = formObject.bsa.value;
	var calc_by_ind =drug_frmobj.calc_by_ind.value;
	var factor;
	var mode="1";
	var temp_qty ="";
	 if(formObject.bsa.value.length > 0){
		 if(drug_frmobj.calc_by_ind!=undefined){ 
			 if(calc_by_ind=="W") {
				temp_qty	=	(parseFloat(qty_value)/parseFloat(weight));
				factor=weight;
			}
			else if(calc_by_ind=="B") {
				temp_qty	=	(parseFloat(qty_value)/parseFloat(bsa));
				factor=bsa;
				
		   }else{
			 temp_qty=qty_value;
			 factor="1";
		   }
		 }else{
			 temp_qty=qty_value;
		 factor="1";
		 }
	 }

	 if(temp_qty==""){ 
		 temp_qty = qty_value;
		 factor="1";
	 }
      //ML-MMOH-CRF-1408 - end
	var xmlStr ="<root><SEARCH ";					

	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "drug_code =\"" + drug_code + "\" " ;
	xmlStr+= "srl_no =\"" + srl_no + "\" " ;
	xmlStr+= "repeat_value =\"" + repeat_value + "\" " ;
	xmlStr+= "qty_value =\"" + temp_qty + "\" " ;//Modified for IN:070451
	xmlStr+= "factor =\"" + factor + "\" " ;//Added for IN:070451
	xmlStr+= "dosage_type =\"" + dosage_type + "\" " ;
	xmlStr+= "mode =\"" + mode + "\" " ;//Added for IN:070451
	xmlStr +=" /></root>";

	var temp_jsp="IVPrescriptionValidate.jsp?validate=DosageLimitCheck"+"&bean_id="+iv_bean_id+"&bean_name="+iv_bean_name;
	//var temp_jsp="IVPBValidate.jsp?validate=DosageLimitCheck"+"&bean_id="+bean_id+"&bean_name="+bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function enableDosageLimit(limit_ind,daily_dose,unit_dose,mono_graph, min_daily_dose, min_unit_dose,mode){//Modified for IN:070451 added mode
	//Added for IN:070451 start
	if(mode=="1"){
		var drug_frmobj		    =  document.formIVPiggyBackDrugDetails;
	}
	else{
		var drug_frmobj		    =  parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
	}
	//Added for IN:070451 end
	drug_frmobj.limit_ind.value=limit_ind;
	drug_frmobj.daily_dose.value=daily_dose;
	drug_frmobj.unit_dose.value=unit_dose;
	drug_frmobj.mono_graph.value=unescape(mono_graph);
	drug_frmobj.min_daily_dose.value=min_daily_dose;
	drug_frmobj.min_unit_dose.value=min_unit_dose;
	drug_frmobj.dosage_limit.style.visibility="visible";
}

function disableDosageLimit(mode){//Modified for IN:070451 added mode
	//try{
	//Added for IN:070451 start
	if(mode=="1"){
		var drug_frmobj		    =  document.formIVPiggyBackDrugDetails;
	}
	else{
		var drug_frmobj		    =  parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
	}
	var abuse_exists=drug_frmobj.abuse_exists.value;//added for aakh-crf-0140
	var abuse_action=drug_frmobj.abuse_action.value;//added for aakh-crf-0140
//	alert(abuse_exists+"abuse_exists"+abuse_action);
	
	//Added for IN:070451 end
		var current_rx= drug_frmobj.current_rx.value;
		var allergy_yn= drug_frmobj.allergy_yn.value;
		drug_frmobj.limit_ind.value="Y";
		if(current_rx=="N" && allergy_yn=="N"){
			drug_frmobj.daily_dose.value="";
			drug_frmobj.unit_dose.value="";
			drug_frmobj.mono_graph.value="";
			drug_frmobj.min_daily_dose.value="";
			drug_frmobj.min_unit_dose.value="";
   if(abuse_exists=="Y" && abuse_action=="B"){
	drug_frmobj.dosage_limit.style.visibility="visible";	
   }else
	drug_frmobj.dosage_limit.style.visibility="hidden";		
		}
	//}catch(e){
	//}
}

async function showMonoGraph() {
     var formobj        = parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
	 var recomm_yn     = formobj.recomm_yn.value;	
	 var mono_graph     = formobj.mono_graph.value;	
	 if(recomm_yn ='Y')	{
			
		var daily_dose     = formobj.daily_dose.value;		
		var unit_dose      = formobj.unit_dose.value;	    
		var min_daily_dose = formobj.min_daily_dose.value ;   
		var min_unit_dose  = formobj.min_unit_dose.value ;
		var dosage_unit    = formobj.recom_dosage_unit.value  ;  
		var drug_desc      = formobj.drug_desc.value    ;    
		var dosage_std      = formobj.dosage_std.value    ;    

		var dialogTop		= "310";
		var dialogHeight	= "15";
		var dialogWidth		= "36";
		var dialogLeft		= "180";
		var features		= "Width:" + dialogWidth + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogLeft:" + dialogLeft +"; dialogTop:" + dialogTop +"; scroll=no; status=no";
		var arguments		= "";
		var retVal 			= await window.showModalDialog("../jsp/PrescriptionDosageLimitMonoGraph.jsp?drug_desc="+escape(drug_desc)+"&mono_graph="+mono_graph+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&min_daily_dose="+min_daily_dose+"&min_unit_dose="+min_unit_dose+"&dosage_unit="+dosage_unit+"&dosage_std="+dosage_std,arguments,features);
	}
}
function assignAuthorization(ord_auth_reqd_yn,auth_yn_val,ord_spl_appr_reqd_yn,approval_yn_val,ord_cosign_reqd_yn,cosign_yn_val,consent_reqd_yn,disp_locn_code){
	
    var formObj	=	parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
    var patient_id    =formObj.patient_id.value;
	var encounter_id  =formObj.encounter_id.value;
	//disp_locn_code added for ml-mmoh-crf-0863
	parent.f_iv_pb_approval.location.href="../../ePH/jsp/IVPiggyBackApproval.jsp?ord_auth_reqd_yn="+ord_auth_reqd_yn+"&auth_yn_val="+auth_yn_val+"&ord_spl_appr_reqd_yn="+ord_spl_appr_reqd_yn+"&approval_yn_val="+approval_yn_val+"&ord_cosign_reqd_yn="+ord_cosign_reqd_yn+"&cosign_yn_val="+cosign_yn_val+"&consent_reqd_yn="+consent_reqd_yn+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&disp_locn_code="+disp_locn_code;
}
function chkAuthorization(src) {
	
	var allowed_click	= "";
	var formobj			= parent.f_iv_pb_drug.document.formIVPiggyBackDrugDetails;
	var formobj1		= parent.f_iv_pb_approval.document.frmpiggybackApproval;

	if (src == "authorize") {
		if(confirm(getMessage("PH_AUTHAPPROVE_1","PH"))) {

			formobj.AUTH_YN_VAL.value			= "Y";
			formobj1.auth_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Authorized.gif\" BORDER=\"0\"></IMG>&nbsp;<B>Authorized</B>";
		}
		else {
			formobj.AUTH_YN_VAL.value			= "N";
			formobj1.auth_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Authorization.gif\" BORDER=\"0\"></IMG>&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization('authorize')\">Authorize</A>";
		}

	}
	else if (src=="approve") {
		
		if (confirm(getMessage("PH_AUTHAPPROVE_2","PH"))) {
			formobj.APPROVAL_YN_VAL.value		= "Y";
			formobj1.spappl_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/SpecialApproval_click.gif\" BORDER=\"0\"></IMG>&nbsp;<B>Approved</B>";
		}
		else {
			formobj.APPROVAL_YN_VAL.value		= "N";
			formobj1.spappl_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/SpecialApproval.gif\" BORDER=\"0\"></IMG>&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization('approve')\">Approve</A>";
		}
	}
	else if (src=="cosign") {
		if (confirm(getMessage("PH_AUTHAPPROVE_3","PH"))) {
			formobj.COSIGN_YN_VAL.value			= "Y";
			formobj1.cosign_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Cosign.gif\" BORDER=\"0\"></IMG>&nbsp;<B>Cosigned</B>";
		}
		else {
			formobj.COSIGN_YN_VAL.value			= "N";
			formobj1.cosign_yn_img.innerHTML	= "&nbsp;<IMG SRC=\"../../eOR/images/Cosign_click.gif\" BORDER=\"0\"></IMG>&nbsp;<A HREF onMouseOver=\"changeCursor(this)\" onClick=\"chkAuthorization('cosign')\">Cosign</A>";
		}
	}
}//modified for aakh-crf-0140
function overrideImg(allergy_yn,allergy_override,limit_ind,dose_override,current_rx,currentrx_override,abuse_action,abuse_override){
	var frmDrugObj	= parent.f_iv_pb_drug;

	if(allergy_yn == "Y"){
		frmDrugObj.document.getElementById("allergy").style.visibility='visible';
		if(allergy_override == "Y"){
			frmDrugObj.document.getElementById("allergy_img").style.visibility='hidden';
		}
		else{
			frmDrugObj.document.getElementById("allergy_img").style.visibility='visible';
		}
	}else{
		frmDrugObj.document.getElementById("allergy").style.visibility='hidden';
		frmDrugObj.document.getElementById("allergy_img").style.visibility='hidden';
	}
	if(limit_ind == "N"){
		frmDrugObj.document.getElementById("ovr_dosage").style.visibility='visible';
		if(dose_override == "Y"){
			frmDrugObj.document.getElementById("ovr_dosage_img").style.visibility='hidden';
		}
		else{
			frmDrugObj.document.getElementById("ovr_dosage_img").style.visibility='visible'; 
		}
	}else{
		frmDrugObj.document.getElementById("ovr_dosage").style.visibility='hidden';
		frmDrugObj.document.getElementById("ovr_dosage_img").style.visibility='hidden';
	}
	if(current_rx == "Y"){
		frmDrugObj.document.getElementById("currentrx").style.visibility='visible';
		if(currentrx_override == "Y"){ 
			frmDrugObj.document.getElementById("currentrx_img").style.visibility='hidden';
		}
		else{
			frmDrugObj.document.getElementById("currentrx_img").style.visibility='visible';
		}
	}else{
		frmDrugObj.document.getElementById("currentrx").style.visibility='hidden';	
		frmDrugObj.document.getElementById("currentrx_img").style.visibility='hidden';
	}//added for aakh-crf-0140 start
	if(abuse_action=="B"){
		if(abuse_override == "Y"){ 
			frmDrugObj.document.getElementById("abuse_img").style.visibility='hidden';
		}
		else{
			frmDrugObj.document.getElementById("abuse_img").style.visibility='visible';
		}
	}
	else{
		frmDrugObj.document.getElementById("currentrx").style.visibility='hidden';	
//		frmDrugObj.document.getElementById("abuse_img").style.visibility='hidden';
	
	}//added for aakh-crf-0140 end
	frmDrugObj.document.getElementById("dosage_limit").style.visibility='visible';
	
}

/*function showOverRideRemarks(patient_id,encounter_id,generic_id,generic_name,drug_desc,daily_dose,unit_dose,mono_graph,limit_ind,allergy_yn,current_rx,drug_code,srl_no,allergy_remarks,dose_remarks,currentrx_remarks,min_unit_dose,min_daily_dose){
	
	var allergy_override    = "N";
	var dose_override	    = "N";
	var currentrx_override  = "N";
/*
	if(document.getElementById("ALLERGY_DESC").value!="")
		allergy_remarks = document.getElementById("ALLERGY_DESC").value;

	if(document.getElementById("EXCEED_DOSE_DESC").value!="")
		dose_remarks = document.getElementById("EXCEED_DOSE_DESC").value;

	if(document.getElementById("DUP_DRUG_DESC").value!="")
		currentrx_remarks = document.getElementById("DUP_DRUG_DESC").value;

	var dialogHeight	= "18";

	if(current_rx=="Y" && limit_ind=="N" && allergy_yn=="Y")
		dialogHeight	= "21";
	else if ( (current_rx=="Y" && limit_ind=="N") || (current_rx=="Y" && allergy_yn=="Y") || (limit_ind=="N" && allergy_yn=="Y" ))
		dialogHeight	= "16";
	else
		dialogHeight	= "12";

	var dialogWidth	= "40";
	var dialogTop	= "285";
	var dialogLeft	= "100";
	var center		= "0";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "";
	retArray		= window.showModalDialog("../jsp/CompoundingOverRideReason.jsp?gen_id="+generic_id+"&gen_name="+escape(generic_name)+"&pat_id="+patient_id+"&enc_id="+encounter_id+"&drug_desc="+escape(drug_desc)+"&mono_graph="+escape(mono_graph)+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&limit_ind="+limit_ind+"&drug_code="+drug_code+"&srl_no="+srl_no+"&allergy="+escape(allergy_remarks)+"&exceed_dose="+escape(dose_remarks)+"&dup_drug="+escape(currentrx_remarks)+"&min_unit_dose="+min_unit_dose+"&min_daily_dose="+min_daily_dose, arguments, features);

	if ( retArray != null && retArray != "" ) {
		var split_vals	= retArray.split(":::");
		eval("document.getElementById("ALLERGY_DESC")"+rec_no).value		= split_vals[0];
		eval("document.getElementById("EXCEED_DOSE_DESC")"+rec_no).value	= split_vals[1];
		eval("document.getElementById("DUP_DRUG_DESC")"+rec_no).value		= split_vals[2];
		
		if(split_vals[0] !="") allergy_override = "Y"; 
		if(split_vals[1] !="") dose_override = "Y"; 
		if(split_vals[2] !="") currentrx_override = "Y"; 

		overrideImg(allergy_yn,allergy_override,limit_ind,dose_override,current_rx,currentrx_override);
	}
} */

function dtlsForOverride(generic_id,generic_name,drug_name,limit_ind,allergy_yn,current_rx,drug_code,srl_no,allergy_desc,exceed_dose_desc,dup_drug_desc){
	
	var frmDrugObj	= parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
			
			frmDrugObj.generic_id.value=generic_id;
			frmDrugObj.generic_name.value=generic_name;
		//	frmDrugObj.drug_name.value=drug_name;
			frmDrugObj.limit_ind.value=limit_ind;
			frmDrugObj.allergy_yn.value=allergy_yn;
			frmDrugObj.current_rx.value=current_rx;
			//frmDrugObj.drug_code.value=drug_code;
			frmDrugObj.srl_no.value=srl_no;
			frmDrugObj.allergy_desc.value=allergy_desc;
			frmDrugObj.exceed_dose_desc.value=exceed_dose_desc;
			frmDrugObj.dup_drug_desc.value=dup_drug_desc;
			
			
}
async function showOverrideReason(order_id,order_line_num){

    var frmObj			= parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
	
	var limit_ind		= frmObj.limit_ind.value;
	var allergy_yn		= frmObj.allergy_yn.value;
	var current_rx		= frmObj.current_rx.value; 
	var dialogHeight	= "18";

	if(current_rx=="Y" && limit_ind=="N" && allergy_yn=="Y")
		dialogHeight	= "21";
	else if ( (current_rx=="Y" && limit_ind=="N") || (current_rx=="Y" && allergy_yn=="Y") || (limit_ind=="N" && allergy_yn=="Y" ))
		dialogHeight	= "16";
	else
		dialogHeight	= "12";

	var dialogWidth	= "40";
	var dialogTop	= "285";
	var dialogLeft	= "100";
	var center		= "0";
	var status		= "no"; 
	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "";
	retArray		= await window.showModalDialog("../jsp/CompoundingOverRideReason.jsp?order_id="+order_id+"&order_line_num="+order_line_num, arguments, features);
}

function setFluidVolume(obj){
	if(obj.value != "0" && obj.value != ""){
		/*if(parseInt(obj.value)  > parseInt(document.formIVPiggyBackVehicle.BASE_VOLUME.value) ){
			alert(getMessage("VHCLE_VOL_CANTGRT_BASE_VOL","PH")+"("+document.formIVPiggyBackVehicle.BASE_VOLUME.value+")");
			document.formIVPiggyBackVehicle.volume.focus();
		}
		else{*/
			document.formIVPiggyBackVehicle.volume.value = obj.value;
			parent.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.STOCK_VALUE.value = obj.value;
		//}
	}
	else{
		alert(getMessage("VHCLE_CANT_BLANK","PH"));
		document.formIVPiggyBackVehicle.volume.focus();
	}
}

function assignTdmOrderid(tdmOrderId){
	document.formIVPiggyBackDrugDetails.tdmOrderId.value = tdmOrderId;
	document.getElementById("tdmRslt").style.visibility	='visible';
}

async function viewReasonforRequest(orderId){
	
		var dialogHeight = '9' ;
		var dialogWidth  = '25' ;
		var dialogTop	 = '189';
		var dialogLeft   = '167' ;
		var title		 = '';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		
		var arguments = "";
		var finalString	= "&readonly=readOnly&orderId="+orderId;

		var retVals = await window.showModalDialog("../../eOR/jsp/TDMReasonforrequest.jsp?"+finalString,arguments,features);
		
}

function volume_focus(){
	if(parent.f_iv_pb.document.getElementById("vehicle_det").style.display != 'none'){
		parent.f_iv_pb.formIVPiggyBackVehicle.vehicle.focus();
	}
}

function setVolume(obj){
	if(parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.f_i_flag.value == 'Y'){
		parent.f_iv_pb.formIVPiggyBackVehicle.volume.value = obj.value;
		parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.STOCK_VALUE.value = obj.value;
		calInfuseOver();
		calSchedule();
	}
}

function calSchedule(){
	if(parent.f_iv_pb_drug.formIVPiggyBackDrugDetails.f_i_flag.value == 'Y'){
		setSchedule(parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.FREQUENCY.value);
	}
}

function viewMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,called_from,external_dosage_override_reason,drug_code,srl_no,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason,drug_db_dosecheck_yn,drug_db_allergy_check_flag){
	var drug_frmobj	= document.formIVPiggyBackDrugDetails;
       if((drug_db_dosecheck_yn=="Y"&&called_from=='ONLOAD')){			  
		//	ExternalDosageCheck(called_from,'');
			if(called_from=='ONLOAD'){
				drug_db_dose_check_flag	=	drug_frmobj.drug_db_dose_check_flag.value;
			}
	   }
	   else{
// if(called_from=='PRESPAD')
		   drug_frmobj	 =	parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
           external_dosage_override_reason		= drug_frmobj.external_dosage_override_reason.value;
		   external_duplicate_override_reason	= drug_frmobj.external_duplicate_override_reason.value;
		   external_interaction_override_reason	= drug_frmobj.external_interaction_override_reason.value;
		   external_contra_override_reason		= drug_frmobj.external_contra_override_reason.value;
		   external_alergy_override_reason		= drug_frmobj.external_alergy_override_reason.value;

	   }
	   if(drug_db_dose_check_flag==""){
		    drug_db_dose_check_flag =drug_db_dose_check_flag;

	   }

      if(called_from=='ONLOAD'){
            if(((drug_db_interact_check_flag=='Y') && (external_interaction_override_reason=="")) ||((drug_db_duptherapy_flag=='Y') && (external_duplicate_override_reason=""))||((drug_db_contraind_check_flag=='Y' )&& (external_contra_override_reason==""))||((drug_db_dose_check_flag=='Y')&& (external_dosage_override_reason==""))||(drug_db_allergy_check_flag=='Y' && external_alergy_override_reason=="")){
				//callMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,external_dosage_override_reason,drug_code,srl_no,called_from,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason);
			}
	  }
	  else{
           if((drug_db_interact_check_flag=='Y') ||(drug_db_duptherapy_flag=='Y')||(drug_db_contraind_check_flag=='Y')||(drug_db_dose_check_flag=='Y') ||(drug_db_allergy_check_flag=='Y')){ //||(drug_db_allergy_check_flag=='Y') added for  SRR20056-SCF-7635 IN027714
				callMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,external_dosage_override_reason,drug_code,srl_no,called_from,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason,drug_db_allergy_check_flag);

		   }
	  }

}

async function callMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,external_dosage_override_reason,drug_code,srl_no,called_from,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason,drug_db_allergy_check_flag){

	  var pract_name = "";
	  if(parent.parent.parent.f_header != undefined){	  
		pract_name = parent.parent.parent.f_header.document.prescription_header_form.pract_name.value;
	  }
	  else{
		pract_name = parent.parent.f_header.document.prescription_header_form.pract_name.value;
	  }
	  var drug_obj	 = "";	
  
	if(called_from=='ONLOAD'){
		drug_obj	 = parent.f_iv_pb_drug;
	}
	else{
		drug_obj	 = parent.f_iv_pb_drug;
	}	
	if(drug_db_interact_check_flag=="Y"||drug_db_duptherapy_flag=="Y"||drug_db_contraind_check_flag=="Y"||drug_db_dose_check_flag=="Y" || drug_db_allergy_check_flag=="Y"){
		if(called_from=='ONLOAD'){
			document.getElementById("ext_med_alerts_fired_for_dup_check_yn").value		=	drug_db_duptherapy_flag;
			document.getElementById("ext_med_alerts_fired_for_inte_check_yn").value		=	drug_db_interact_check_flag;
			document.getElementById("ext_med_alerts_fired_for_contra_check_yn").value		=	drug_db_contraind_check_flag;
			document.getElementById("ext_med_alerts_fired_for_allergy_check_yn").value		=	drug_db_allergy_check_flag;
			document.getElementById("external").style.visibility		=  'visible';
			document.getElementById("external_img").style.visibility	=  'visible';
			document.getElementById("external_product_id").value		=  ext_prod_id;
		}
	}
	
		var dialogHeight	= "85" ;
		var dialogWidth	    = "70";
		var dialogTop	    = "100" ;
		var dialogLeft	    = "100" ;
		var center			= "0" ;
		var status			= "no";
		var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "";
		//replaced escape with encodeURIComponent in the below line and encoded pract_name for IN23093 --05/08/2010-- priya

		retVal = await window.showModalDialog("../../ePH/jsp/MedicationAlerts.jsp?&patient_id="+patient_id+"&external_product_id="+ext_prod_id+"&drug_db_interact_check_flag="+drug_db_interact_check_flag+"&drug_db_duptherapy_flag="+drug_db_duptherapy_flag+"&drug_db_allergy_flag="+drug_db_allergy_check_flag+"&drug_db_contraind_check_flag="+drug_db_contraind_check_flag+"&drug_db_dosecheck_flag="+drug_db_dose_check_flag+"&srl_no="+srl_no+"&pract_name="+encodeURIComponent(pract_name)+"&dsg_reason="+encodeURIComponent(external_dosage_override_reason)+"&dup_reason="+encodeURIComponent(external_duplicate_override_reason)+"&con_reason="+encodeURIComponent(external_contra_override_reason)+"&int_reason="+encodeURIComponent(external_interaction_override_reason)+"&alg_reason="+encodeURIComponent(external_alergy_override_reason) ,arguments,features);

		if(retVal!=null && retVal[0]!='CANCEL'){

			 var external_dosage_override_reason		=	"";
			 var external_duplicate_override_reason		=	"";
			 var external_interaction_override_reason	=	"";
			 var external_contra_override_reason		=	"";
			 var external_alergy_override_reason		=	"";
			 var external_database_overrided_reason		=	"";
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
			if(((drug_db_interact_check_flag=="Y")&&(external_interaction_override_reason==""))||((drug_db_duptherapy_flag=="Y")&&(external_duplicate_override_reason==""))||((drug_db_contraind_check_flag=="Y")&&(external_contra_override_reason==""))||((drug_db_dose_check_flag=="Y")&&(external_dosage_override_reason==""))||(drug_db_allergy_check_flag=="Y" && external_alergy_override_reason=="")){

				dosage_img				    = drug_obj.document.getElementById("external_img");
				dosage_img.style.visibility ='visible';

			}
			else{
				drug_obj.document.getElementById("external").style.visibility ='visible';
				drug_obj.document.getElementById("external_img").style.visibility ='hidden';
				external_database_overrided_reason = "Y";
			}   

			if(called_from=='DOSAGE'){
				external_db_dose_check     = drug_obj.document.getElementById("drug_db_dose_check_flag");
				external_db_dose_check.value='Y';
			}

			bean_id		=	drug_obj.document.formIVPiggyBackDrugDetails.iv_bean_id.value;
			bean_name	=	drug_obj.document.formIVPiggyBackDrugDetails.iv_bean_name.value;

            drug_obj.document.getElementById("external_dosage_override_reason").value		=	external_dosage_override_reason;
			if(called_from !='DOSAGE'){
				drug_obj.document.getElementById("external_interaction_override_reason").value	=	external_interaction_override_reason;
				drug_obj.document.getElementById("external_duplicate_override_reason").value		=	external_duplicate_override_reason;
				drug_obj.document.getElementById("external_contra_override_reason").value		=	external_contra_override_reason;
				drug_obj.document.getElementById("external_alergy_override_reason").value		=	external_alergy_override_reason;
			}
			
			var patient_id = drug_obj.document.formIVPiggyBackDrugDetails.patient_id.value;
			var encounter_id = drug_obj.document.formIVPiggyBackDrugDetails.encounter_id.value;
//replaced escape with encodeURIComponent in the following lines for IN23093 --05/08/2010-- priya
			var xmlStr ="<root><SEARCH ";					
				xmlStr+= "External_Dosage_Override_Reason =\"" + encodeURIComponent(external_dosage_override_reason,"UTF-8") + "\" " ;
				xmlStr+= "External_Duplicate_Override_Reason =\"" + encodeURIComponent(external_duplicate_override_reason,"UTF-8") + "\" " ;
				xmlStr+= "External_Interaction_Override_Reason =\"" +encodeURIComponent(external_interaction_override_reason,"UTF-8") + "\" " ;
				xmlStr+= "External_Contra_Override_Reason =\"" + encodeURIComponent(external_contra_override_reason,"UTF-8") + "\" " ;
				xmlStr+= "External_Alergy_Override_Reason =\"" + encodeURIComponent(external_alergy_override_reason,"UTF-8") + "\" " ;
				xmlStr+= "External_Database_Overrided_Reason =\"" + external_database_overrided_reason + "\" " ;
				xmlStr+= "drug_code =\"" + drug_code + "\" " ;
				xmlStr+= "srl_no =\"" + srl_no + "\" " ; 
				xmlStr+= "called_from =\"" + called_from + "\" " ;
				xmlStr +=" /></root>";

			 var qryString	= bean_id+"&bean_name="+bean_name+"&validate=InsertExternalOverrideReason&patient_id="+patient_id+"&encounter_id="+encounter_id;
				 

			 submitXML(qryString, xmlStr);
		}
}

function HideFDBOverrideImage(srl_no,called_from){
	var drug_obj = parent.f_iv_pb_drug;

    var ext_med_alerts_fired_for_dup_check_yn		=	drug_obj.document.getElementById("ext_med_alerts_fired_for_dup_check_yn").value;
	var ext_med_alerts_fired_for_inte_check_yn		=	drug_obj.document.getElementById("ext_med_alerts_fired_for_inte_check_yn").value;
	var ext_med_alerts_fired_for_contra_check_yn	=	drug_obj.document.getElementById("ext_med_alerts_fired_for_contra_check_yn").value;
  
     var external_db_dose_check				 = drug_obj.document.getElementById("drug_db_dose_check_flag");
	 if(called_from=='DOSAGE'){
	//		external_db_dose_check.value	 = 'N';
	 }

	 if(ext_med_alerts_fired_for_dup_check_yn=='N'&& ext_med_alerts_fired_for_inte_check_yn=='N'&&ext_med_alerts_fired_for_contra_check_yn=='N'&&external_db_dose_check.value=='N'){
			dosage_img					= drug_obj.document.getElementById("external_img");
			dosage						= drug_obj.document.getElementById("external");
			dosage_img.style.visibility	='hidden';
			dosage.style.visibility		='hidden';
	 }

}

function displayDosageCheckResult(srl_no,called_from ){
	var ext_med_alerts_fired_for_dup_check_yn		=	document.getElementById("ext_med_alerts_fired_for_dup_check_yn").value;
	var ext_med_alerts_fired_for_inte_check_yn		=	document.getElementById("ext_med_alerts_fired_for_inte_check_yn").value;
	var ext_med_alerts_fired_for_contra_check_yn	=	document.getElementById("ext_med_alerts_fired_for_contra_check_yn").value;
	var ext_med_alerts_fired_for_allergy_check_yn	=	document.getElementById("ext_med_alerts_fired_for_allergy_check_yn").value;

    var patient_id									=	document.formIVPiggyBackDrugDetails.patient_id.value;
	var drug_code									=   document.getElementById("drug_code").value;
	var ext_prod_id									=	document.getElementById("external_product_id").value;
	 var external_dosage_override_reason		=	document.getElementById("external_dosage_override_reason").value;
	 var external_duplicate_override_reason		=	document.getElementById("external_duplicate_override_reason").value;
	 var external_interaction_override_reason	=	document.getElementById("external_interaction_override_reason").value;
	 var external_contra_override_reason		=	document.getElementById("external_contra_override_reason").value;
	 var external_alergy_override_reason		=	document.getElementById("external_alergy_override_reason").value;

	//var external_override_reason =  eval("document.getElementById("external_override_reason_")"+srl_no).value;
	var external_db_dose_check   =  document.getElementById("drug_db_dose_check_flag").value;
   	 if(ext_med_alerts_fired_for_dup_check_yn=='Y'|| ext_med_alerts_fired_for_inte_check_yn=='Y'||ext_med_alerts_fired_for_contra_check_yn=='Y'||external_db_dose_check=='Y' || ext_med_alerts_fired_for_allergy_check_yn == 'Y'){
		viewMedicationAlert(patient_id,ext_prod_id,ext_med_alerts_fired_for_inte_check_yn,ext_med_alerts_fired_for_dup_check_yn,ext_med_alerts_fired_for_contra_check_yn,external_db_dose_check,called_from,external_dosage_override_reason,drug_code,srl_no,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,'',external_alergy_override_reason,external_db_dose_check,ext_med_alerts_fired_for_allergy_check_yn);

//		viewMedicationAlert(patient_id,ext_prod_id,drug_db_interact_check_flag,drug_db_duptherapy_flag,drug_db_contraind_check_flag,drug_db_dose_check_flag,called_from,external_dosage_override_reason,drug_code,srl_no,external_duplicate_override_reason,external_interaction_override_reason,external_contra_override_reason,pract_name,external_alergy_override_reason,drug_db_dosecheck_yn){
	 }
}

function ExternalDosageCheck(called_from,adm_prsc){
	if(adm_prsc == 'presc'){
		if(parent.parent.parent.f_header!=undefined)
		   var formObject			=  parent.parent.parent.f_header.document.prescription_header_form;
		else
		   var formObject			=  parent.parent.f_header.document.prescription_header_form;
		var drug_frmobj		    =  document.formIVPiggyBackDrugDetails;
		var adminObj			=  parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	}
	else if(adm_prsc == 'admndtl'){
		var formObject			=  "";
		if(parent.parent.parent.f_header != undefined){
			formObject			= parent.parent.parent.f_header.document.prescription_header_form;
		}
		else{
			formObject			= parent.parent.f_header.document.prescription_header_form;
		}
		var drug_frmobj		    =  parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
		var adminObj			=  parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	}
	else{
		var formObject			=  parent.parent.parent.f_header.document.prescription_header_form;
		var drug_frmobj		    =  parent.f_iv_pb_drug.f_sub_ivdrugs.formIVPrescriptionDrugDetails;
		var adminObj			=  parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	}

	var drug_db_interface_yn = formObject.drug_db_interface_yn.value;
	 if(drug_db_interface_yn == "Y"){
		var external_prod_id    = drug_frmobj.external_product_id.value;
		var drug_db_dosechk_yn  = formObject.drug_db_dosecheck_yn.value;
			drug_db_dosechk_yn = "Y";
		var encounter_id		= formObject.encounter_id.value;

		var inf_prd_value = adminObj.infusion_over_insert_value.value;
		var durn_value	  = adminObj.DURN_VALUE.value;
		if(inf_prd_value=='' || inf_prd_value=='0'){
			alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
			//frmAdminObj.INFUSION_VALUE.focus();
			return false;
		}
		var dosage_type = drug_frmobj.dosage.value;
		var route_code						= drug_frmobj.route_code.value ;// Added in January 2014 for CIMS dosage check -start
		var qty_desc_code					= drug_frmobj.QTY_DESC_CODE.value; 
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
			var dose							= drug_frmobj.STRENGTH_VALUE.value;
			//var dose_uom						= drug_frmobj.dosage_unit.innerText;
			var dose_uom						= drug_frmobj.rec_uom.innerText;
			//var repeat_value					= Math.ceil(parseInt(durn_value)/parseInt(inf_prd_value));
			var repeat_value					= adminObj.repeat_value.value;
			
				durn_value = Math.ceil(durn_value/24);
			var interval_value="1";

			var drug_code						= drug_frmobj.drug_code.value; 
			var srl_no							= drug_frmobj.srl_no.value; 
			var external_dosage_override_reason	= drug_frmobj.external_dosage_override_reason.value;
			var pract_name						= formObject.pract_name.value
            
			var xmlStr ="<root><SEARCH ";					
			//xmlStr+= "patient_id =\"" + patient_id + "\" " ;
			xmlStr+= "external_prod_id =\"" + external_prod_id + "\" " ;
			xmlStr+= "weight =\"" + weight + "\" " ;
			xmlStr+= "bsa =\"" + bsa + "\" " ;
			xmlStr+= "dose =\"" + dose + "\" " ;
			xmlStr+= "dose_uom =\"" + dose_uom + "\" " ;
			xmlStr+= "repeat_value =\"" + repeat_value + "\" " ;
			xmlStr+= "interval_value=\"" + interval_value + "\" " ;
			xmlStr+= "durn_value =\"" + durn_value + "\" " ;
			xmlStr+= "drug_code =\"" + drug_code + "\" " ;
			xmlStr+= "adm_prsc =\"" + adm_prsc + "\" " ;
			xmlStr+= "called_from =\"" + called_from + "\" " ;
			xmlStr+= "external_dosage_override_reason=\"" + external_dosage_override_reason + "\" " ;
			xmlStr+= "pract_name=\"" + pract_name + "\" " ;
			xmlStr+= "DOSAGE_TYPE=\"" + dosage_type + "\" " ;
			xmlStr+= "route_code=\"" + route_code + "\" " ; // Added in January 2014 for CIMS dosage check -start
			xmlStr+= "qty_desc_code=\"" + qty_desc_code + "\" " ;
			xmlStr+= "repeat_durn_type=\"" + repeat_durn_type + "\" " ;
			xmlStr+= "freq_nature=\"" + freq_nature + "\" " ;  //Added in January 2014, CIMS Dosage Check -end
			xmlStr +=" /></root>";
			var temp_jsp="IVPBValidate.jsp?validate=ExternalDoseCheck"+"&bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id;
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

			var repeat_value					= Math.ceil(parseInt(durn_value)/parseInt(inf_prd_value));
			durn_value = "1";
			var interval_value="1";
			var pract_name						= formObject.pract_name.value
			var dose							= drug_frmobj.STRENGTH_VALUE.value;
			var dose_uom						= drug_frmobj.rec_uom.innerText;
			var xmlStr ="<root><SEARCH ";					

			//xmlStr+= "patient_id =\"" + patient_id + "\" " ;
			//xmlStr+= "encounter_id=\"" + encounter_id + "\" " ;
			xmlStr+= "weight =\"" + weight + "\" " ;
			xmlStr+= "bsa =\"" + bsa + "\" " ;
			xmlStr+= "dose =\"" + dose + "\" " ;
			xmlStr+= "dose_uom =\"" + dose_uom + "\" " ;
			xmlStr+= "repeat_value =\"" + repeat_value + "\" " ;
			xmlStr+= "interval_value=\"" + interval_value + "\" " ;
			xmlStr+= "durn_value =\"" + durn_value + "\" " ;
			xmlStr+= "adm_prsc =\"" + adm_prsc + "\" " ;
			xmlStr+= "called_from =\"" + called_from + "\" " ;
			xmlStr+= "pract_name=\"" + pract_name + "\" " ;
			xmlStr+= "DOSAGE_TYPE=\"" + dosage_type + "\" " ;
			xmlStr+= "route_code=\"" + route_code + "\" " ; // Added in January 2014 for CIMS dosage check -start
			xmlStr+= "qty_desc_code=\"" + qty_desc_code + "\" " ;
			xmlStr+= "repeat_durn_type=\"" + repeat_durn_type + "\" " ;
			xmlStr+= "freq_nature=\"" + freq_nature + "\" " ;  //Added in January 2014, CIMS Dosage Check -end
			xmlStr +=" /></root>";
			var temp_jsp="IVPBValidate.jsp?validate=ExternalDoseCheck"+"&bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id;
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

function DisplayFDBOverrideImage(external_product_id){
	//var drug_obj = "parent.f_iv_pb_drug";
	parent.f_iv_pb_drug.document.getElementById("external_product_id").value = external_product_id;
	dosage_img					= parent.f_iv_pb_drug.document.getElementById("external_img");
	dosage						= parent.f_iv_pb_drug.document.getElementById("external");
	dosage_img.style.visibility	='visible';
	dosage.style.visibility		='visible';
}

function setextdoseflag(drug_db_dose_check_flag){
	var drug_frmobj	    = parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
	drug_frmobj.drug_db_dose_check_flag.value	=	drug_db_dose_check_flag;
}

function displayDispLocn(ord_disp_location,time_flag){
	if(parent.parent.f_ivbutton != undefined){
		parent.parent.f_ivbutton.document.formIVPrescriptionButtons.time_flag.value =time_flag;
		parent.parent.f_ivbutton.document.getElementById("dflt_disp_locn_lbl").innerText = ord_disp_location;
	}
	else{
		parent.parent.frames[3].document.getElementById("dflt_disp_locn_lbl").innerText = ord_disp_location;
	}

}


function displayADRimage(count){

	var frmVehicleObj	= parent.f_iv_pb.formIVPiggyBackVehicle;	

	if(parseInt(count)>0){
         frmVehicleObj.document.getElementById("fluid_ADR_img").style.visibility='visible';
	}else{
		  frmVehicleObj.document.getElementById("fluid_ADR_img").style.visibility='hidden';

	}
}

function assignValue(obj){
	if(obj.checked==true)
		obj.value="Y";
	else
		obj.value="N";
}


async function displayChargeDetails(iv_prep_yn){
	if(parent.parent.f_header)
	     var headerForm = parent.parent.f_header.document.prescription_header_form;
	else
		 var headerForm = parent.f_header.document.prescription_header_form;
    if(parent.f_ivdetails){
	   var drugForm     = parent.f_ivdetails.f_iv_pb_drug.document.formIVPiggyBackDrugDetails;
	   var adminForm    = parent.f_ivdetails.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail;
	   var fluidForm	= parent.f_ivdetails.f_iv_pb.document.formIVPiggyBackVehicle;
	}
	else{
       var drugForm     = parent.f_detail.f_iv_pb_drug.document.formIVPiggyBackDrugDetails;
	    var adminForm   = parent.f_detail.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail;
		var fluidForm	= parent.f_detail.f_iv_pb.document.formIVPiggyBackVehicle;
	}
   
	if(validateFrequency( adminForm)){
	
	var iv_bean_id = drugForm.iv_bean_id.value;
	var iv_bean_name = drugForm.iv_bean_name.value
	var patient_id = headerForm.patient_id.value
	var encounter_id = headerForm.encounter_id.value
	var	take_home_medication =  headerForm.take_home_medication.value
	var mode       = drugForm.mode.value;
	var actual_patient_class = headerForm.actual_patient_class.value

	var fluid_code		  = fluidForm.vehicle.value;
	var infusion_over	  = adminForm.infusion_over_insert_value.value;
	var tot_inf_prd		= adminForm.STOCK_VALUE.value;
	var durn_value		= adminForm.DURN_VALUE.value;
	var repeat_value    = adminForm.repeat_value.value;
	var durn_unit_val    = adminForm.durn_unit.value;



	var infusion_period_value		= adminForm.INFUSION_PERIOD_VALUE.value;
	var infusion_period_value_min	= adminForm.INFUSION_PERIOD_VALUE_MIN.value;
	var freq_code = adminForm.FREQUENCY.value;
	var InfuseOverInMin             = getInfuseOverInMin(infusion_period_value,infusion_period_value_min); 
	var dur_val=adminForm.DURN_VALUE.value; 
//		dur_val = dur_val*60;
	if(adminForm.durn_unit.value == "H")
		dur_val = dur_val*60;
	if(adminForm.durn_unit.value == "D")
		dur_val = dur_val*24*60;
	if(adminForm.durn_unit.value == "W")
		dur_val = dur_val*7*24*60;
	if(adminForm.durn_unit.value == "L")
		dur_val = dur_val*30*24*60;
	if(adminForm.durn_unit.value == "Y")
		dur_val = dur_val*12*30*24*60;

	if (drugForm.drug_code.value == "") {
		alert(getMessage("DRUG_CANT_BE_BLANK","PH"));
		drugForm.drug_name.focus();
		return false;
	}		
	else if (drugForm.STRENGTH_VALUE.value == "" || drugForm.STRENGTH_VALUE.value == "0") {
		alert(getMessage("PRES_DOSAGE_CANNOT_ZERO","PH"));
		drugForm.STRENGTH_VALUE.focus();
		return false;
	}else if (drugForm.STRENGTH_UOM.value == "") {
		alert(getMessage("STR_UOM_CANT_BLANK","PH"));
		drugForm.STRENGTH_UOM.focus();
		return false;
	}
	else if (trimCheck(fluidForm.vehicle.value) == "") {
		alert(getMessage("VHCLE_CANT_BLANK","PH"));
		fluidForm.vehicle.focus();
		return false;
	}
	else if (adminForm.INFUSION_VALUE.value == "" || parseFloat(adminForm.INFUSION_VALUE.value) == 0) {
		alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
		adminForm.INFUSION_VALUE.focus();
		return false;
	}
	else if (drugForm.STRENGTH_VALUE.value == "" || drugForm.STRENGTH_VALUE.value == "0") {
		alert(getMessage("PRES_DOSAGE_CANNOT_ZERO","PH"));
		drugForm.STRENGTH_VALUE.focus();
		return false;
	}
	else if (trimCheck(adminForm.END_DATE.value) == "") {
		alert(getMessage("FRQ_CANT_BLANK","PH"));
		return false;
	}
	else if ((adminForm.INFUSION_PERIOD_VALUE.value == "" || parseFloat(adminForm.INFUSION_PERIOD_VALUE.value) == 0)&&(adminForm.INFUSION_PERIOD_VALUE_MIN.value == "" || parseFloat(adminForm.INFUSION_PERIOD_VALUE_MIN.value) == 0)) {
		alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
		adminForm.INFUSION_PERIOD_VALUE.focus();
		return false;
	}else  if(parseInt(adminForm.INFUSION_PERIOD_VALUE_MIN.value)>59){
			alert(getMessage("INVALID_TIME_MINUTE","PH"));
			//frmAdminObj.INFUSION_PERIOD_VALUE_MIN.focus();
			return false;

	}else  if((parseFloat(InfuseOverInMin) )>( parseInt(dur_val))){

			alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));	
			return false;
		
	}

	var dosage      = drugForm.STRENGTH_VALUE.value;
	var volume      =fluidForm.volume.value; 

	var xmlStr ="<root><SEARCH ";					

	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "encounter_id =\"" + encounter_id + "\" " ;
	xmlStr+= "fluid_code =\"" + fluid_code + "\" " ;
	xmlStr+= "infusion_over =\"" + infusion_over + "\" " ;
	xmlStr+= "tot_inf_prd =\"" + tot_inf_prd + "\" " ;
	xmlStr+= "durn_value =\"" + durn_value + "\" " ;
	xmlStr+= "drug_dosage =\"" + dosage + "\" " ;
	xmlStr+= "fluid_volume =\"" + volume + "\" " ;
	xmlStr+= "repeat_value =\"" + repeat_value + "\" " ;
	xmlStr+= "durn_unit =\"" + durn_unit_val + "\" " ;
	xmlStr+= "drug_code =\"" + drugForm.drug_code.value + "\" " ;
	xmlStr+= "freq_code =\"" + freq_code + "\" " ;
	xmlStr+= "freq_nature =\"" + adminForm.freq_nature.value + "\" " ;
	xmlStr+= "mode =\"" + mode + "\" " ;
	if(mode=="amend"){
	   // var or_date_time = headerForm.or_date_time.value;
	   xmlStr+= "or_date_time =\"" +  headerForm.or_date_time.value + "\" " ;
   }
	xmlStr +=" /></root>";

	var temp_jsp="IVPBValidate.jsp?validate=SAVE_FLUIDDETAILS"+"&bean_id="+iv_bean_id+"&bean_name="+iv_bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
    eval(responseText);

	var dialogHeight= "40vh" ;
	var dialogWidth	= "70vw" ;
	var dialogTop	= "" ;
	var dialogLeft	= "" ;
	var center		= "" ;
	var status		= "no";
	var scroll		= "yes";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;

	retVal = await top.window.showModalDialog("../../ePH/jsp/ChargeDetail.jsp?bean_id="+iv_bean_id+"&bean_name="+iv_bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&actual_patient_class="+actual_patient_class+"&iv_prep_yn="+iv_prep_yn+"&fluid_code="+fluid_code+"&infusion_over="+infusion_over+"&durn_value="+durn_value+"&durn_unit="+durn_unit_val+"&freq_code="+freq_code+"&take_home_medication="+take_home_medication+"&freq_nature="+adminForm.freq_nature.value,arguments,features);
	if(retVal!= undefined && retVal!=null && retVal!="")
		alertBLErrorDrugs(retVal);
	}
}

function alertBLErrorDrugs(blErrorDrugs, called_from){
	blErrorDrugs = blErrorDrugs.substring(1,blErrorDrugs.length-2);
	blErrorDrugs = blErrorDrugs.split(',');
	var bl_alert_msg=getMessage("ERROR_IN_BILLING",'PH')+"\n";
	var drug_or_fluid="";
	for(var i=0; i<blErrorDrugs.length; i++){
		if(drug_or_fluid == "")
			drug_or_fluid	= trimString(blErrorDrugs[i++]);
		else
			i++;

		drug_desc	= decodeURIComponent(trimString(blErrorDrugs[i++]));
		bl_error_code = trimString(blErrorDrugs[i++]);
		bl_sys_message_id = trimString(blErrorDrugs[i++]);
		bl_error_text = trimString(blErrorDrugs[i]);

		if ((bl_error_code == "10" && bl_error_text =="") || bl_sys_message_id!=""){
			if(bl_sys_message_id!=""){
				bl_error_text = getMessage(bl_sys_message_id,'BL');
			}
		}
		bl_alert_msg += drug_desc+" --> "+ bl_error_text+"\n";
	}
	alert(bl_alert_msg);
	/*if(drug_or_fluid == "F")
		document.formIVPrescriptionButtons.reset();
		//parent.f_sub_ivdrugs.document.formIVPrescriptionDrugDetails.reset();
	else if (drug_or_fluid == "D"){*/
		//parent.f_ivdetails.f_iv_drug_details.f_drug_button.document.formIVPrescriptionDrugDetailButtons.CLEAR.click()
	//}
	callClearAll(1, true);
	return false;
}

function reloadScreens(calledFrom, patient_id, encounter_id, order_date, pat_class,order_id,or_mode) {

	MAR_app_yn = parent.frames[0].document.forms[0].MAR_app_yn.value;

	var location_type		 = parent.parent.f_header.prescription_header_form.location_type.value;
	var location_code		 = parent.parent.f_header.prescription_header_form.location_code.value;
	var take_home_medication = parent.parent.f_header.prescription_header_form.take_home_medication.value; 
	var priority			 = parent.parent.f_header.prescription_header_form.priority.value;
	var bed_num				 = parent.parent.f_header.prescription_header_form.bed_num.value;
	var room_num			 = parent.parent.f_header.prescription_header_form.room_num.value;
	var adr_count			 = parent.parent.f_header.prescription_header_form.adr_count.value;
	var bl_install_yn		 = parent.parent.f_header.prescription_header_form.bl_install_yn.value; 
	var bl_disp_charge_dtl_in_rx_yn = parent.parent.f_header.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value; 
	var pat_class			= parent.parent.f_header.prescription_header_form.patient_class.value; 

	var iv_option            = parent.frames[0].document.formIVPrescriptionOptions.type.value;
	var iv_prep_yn = "";
	if(iv_option=='IVD')
		iv_prep_yn='1';
	else if(iv_option=='IVPB')
		iv_prep_yn='3';
	else if(iv_option=='IVWA')
		iv_prep_yn='5';

	if (calledFrom == "1") {
		parent.location.href = "../jsp/IVPrescription.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&clearOrNot=Y"+"&MAR_app_yn="+MAR_app_yn+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&MAR_app_yn="+MAR_app_yn+"&iv_prep_yn="+"&bed_num="+bed_num+"&room_num="+room_num+"&adr_count="+adr_count;
		//iv_prep_yn is passed as null to avoid the disabling the iv type select box.
	}
	else if (calledFrom == "2") {
		var iv_option = "N";
		if (document.formIVPrescriptionOptions.type!=null && document.formIVPrescriptionOptions.type.value == "IVD")
			iv_option = "Y";

		if(document.formIVPrescriptionOptions.type == "IVD"){
			iv_prep_yn='1';
			parent.f_ivdetails.location.href = "../jsp/IVPrescriptionDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&iv_option="+iv_option+"&MAR_app_yn="+MAR_app_yn;
		}
		else if(document.formIVPrescriptionOptions.type.value=="IVPB"){
			iv_prep_yn = '3';
			parent.f_ivdetails.location.href		= "../jsp/IVPiggyBack.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&iv_option="+iv_option+"&MAR_app_ynMAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count;
		}
		else{
			iv_prep_yn = '5'
			parent.f_ivdetails.location.href = "../jsp/IVFluidAdditives.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&iv_option="+iv_option+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count;
		}
		parent.f_ivbutton.location.href  = "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&start_date="+order_date+"&iv_option="+iv_option+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&MAR_app_yn="+MAR_app_yn+"&iv_prep_yn="+iv_prep_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn;
		
	}
	else if (calledFrom == "3") {
		if(parent.parent.parent.parent.parent.parent.orderMainTab !=null){
			var locnDet = parent.parent.parent.parent.parent.parent.orderMainTab.location.href;
			// if its a amend order then close the window or reload the window
			if(locnDet.indexOf('ammend') != -1)
			//	window.close();
				
		    
				parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
			else
				parent.parent.parent.parent.parent.parent.orderMainTab.location.reload();
		}
		else if(parent.parent.parent.criteriaCategoryButtonFrame !=null){
			parent.parent.parent.criteriaCategoryButtonFrame.location.reload();
		}
		else
		//	window.close();
		
	    
			parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
		
	}
	else if(calledFrom=="4"){
		document.location.href = "../jsp/IVPrescription.jsp?order_id="+order_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+pat_class+"&patient_class="+pat_class+"&start_date="+order_date+"&clearOrNot=N&or_mode=amend"+"&MAR_app_yn="+MAR_app_yn;;
	}
}

function changeScrDetails(objVal) {
	var frmObj		= document.formIVPiggyBackDrugDetails;
	/*===============================================================================================================*/
	//Code added  and passed rx_qty_by_pres_base_uom_yn and pres_base_uom values to validate page for IN23357 -- 31/08/2010-- priya
		if(parent.parent.parent.parent.f_header!=undefined)
			f_header			 = parent.parent.parent.parent.f_header;
		else if(parent.parent.parent.parent.parent.f_header!=undefined)
			f_header			 = parent.parent.parent.parent.parent.f_header;
		else if( parent.parent.parent.f_header!=undefined)
			f_header			 = parent.parent.parent.f_header;
		else
			f_header			 = parent.parent.f_header;
		var rx_qty_by_pres_base_uom_yn		= f_header.prescription_header_form.rx_qty_by_pres_base_uom_yn.value;
		var pres_base_uom					= frmObj.PRES_BASE_UOM.value;
/*===============================================================================================================*/

	if(frmObj.mode.value != "amend"){
		if (objVal == "S") {
			
				document.getElementById("DOSAGE_LABEL").innerHTML = "Strength&nbsp;";
//				var uom_code		 = frmObj.UOM_CODE.value;
				var uom_code		 = frmObj.STRENGTH_UOM_CODE.value;
				var uom_desc		 = frmObj.STRENGTH_UOM_DESC.value;
				var str_value		 = frmObj.drug_strength_value.value; //changed STR_VAL to drug_strength_value for IN23745 --16/09/2010-- priya
		//		var order_set_code	 = parent.parent.f_iv_fluid.document.formIVPrescriptionDetails.order_set_code.value;
		//		var order_set_code	 =	parent.f_iv_pb.document.formIVPiggyBackVehicle.order_set_code.value;
				var order_set_code	 =	frmObj.order_set_code.value;
				var orderSetStrength = frmObj.ORDERSET_STRENGTH.value;
				clearData(frmObj.STRENGTH_UOM, "2");

				addData(uom_code, uom_desc, frmObj.STRENGTH_UOM);
				frmObj.STRENGTH_UOM.disabled	= true;

				if(order_set_code != null && order_set_code != ""){
					frmObj.STRENGTH_VALUE.value		= orderSetStrength;
				}
				else{
					frmObj.STRENGTH_VALUE.value		= str_value;
				}
			setDrugDosageDetails();
		}
		else if (objVal == "Q") {
			document.getElementById("DOSAGE_LABEL").innerHTML = "Dose&nbsp;";
			var form_code						= frmObj.FORM_CODE.value;
			var drug_code						= frmObj.DRUG_CODE.value;
			// if condition added  for IN23745 --16/09/2010-- priya
			if(frmObj.drug_strength_value.value != "0" && frmObj.drug_strength_value.value != "")
				frmObj.STRENGTH_VALUE.value			= frmObj.strength_per_value_pres_uom.value; // changed PRES_QTY_VALUE to strength_per_value_pres_uom for IN23745 --16/09/2010-- priya

			//above one line is commented because while copy orders this code overwrites the existing value with pres_qty_value-Abdul-25/08/10. // uncommented for IN23745 --16/09/2010-- priya

			frmObj.STRENGTH_UOM.disabled		= false;
			var bean_id							= frmObj.bean_id.value;
			var bean_name						= frmObj.bean_name.value;
			var qryString						= bean_id+"&bean_name="+bean_name+"&validate=QUANTITY&form_code="+form_code+"&drug_code="+drug_code+"&pres_base_uom="+pres_base_uom+"&rx_qty_by_pres_base_uom_yn="+rx_qty_by_pres_base_uom_yn;
			submitXML(qryString, "");
			

			setDrugDosageDetails();
			if(rx_qty_by_pres_base_uom_yn=="Y")  //if condition added for IN23357 -- 31/08/2010-- priya
				frmObj.STRENGTH_UOM.disabled=true;
			else
				frmObj.STRENGTH_UOM.disabled=false;
		}
	}
	else{

		if (objVal == "S") {
			document.getElementById("DOSAGE_LABEL").innerHTML = "Strength&nbsp;";
		}else if (objVal == "Q") {
			document.getElementById("DOSAGE_LABEL").innerHTML = "Dose&nbsp;";
		
		}
			var bean_id							= document.formIVPiggyBackDrugDetails.bean_id.value;
			var bean_name						= document.formIVPiggyBackDrugDetails.bean_name.value;
			var patient_id						= document.formIVPiggyBackDrugDetails.patient_id.value;
			var encounter_id					= document.formIVPiggyBackDrugDetails.encounter_id.value;
			clearData(frmObj.STRENGTH_UOM, "2");
			var qryString	= 	bean_id+"&bean_name="+bean_name+"&validate=loadDoseDetails&&patient_id="+patient_id+"&encounter_id="+encounter_id+"&dosage_type="+objVal+"&drug_code="+frmObj.DRUG_CODE.value+"&pres_base_uom="+pres_base_uom+"&rx_qty_by_pres_base_uom_yn="+rx_qty_by_pres_base_uom_yn;
			submitXML(qryString, "");

			if(rx_qty_by_pres_base_uom_yn=="Y")  //if condition added for IN23357 -- 31/08/2010-- priya
				frmObj.STRENGTH_UOM.disabled=true;
			else
				frmObj.STRENGTH_UOM.disabled=false; 

 //if condition added coz - qty value is loaded as 1, when u change from strength to qty in amend mode instead of default qty value.
 //added during  IN23745 --16/09/2010-- priya
		 if (objVal == "Q") 
			 {
				frmObj.STRENGTH_VALUE.value	 = frmObj.strength_per_value_pres_uom.value;
			  }
			setDrugDosageDetails();
		
	}
	if(frmObj.recomm_yn.value=="Y") {
		var dosage_std	=	frmObj.dosage_std.value;
		var recomm_dosage_by	=	frmObj.recomm_dosage_by.value;
		var dosage_by	=	frmObj.dosage.value;
		if(recomm_dosage_by == dosage_by){
			frmObj.rec_legend.disabled =false;//added for ML-MMOH-CRF-0978
			frmObj.rec_legend.innerHTML = "<font class='HYPERLINK' onmouseover='changeCursor(this);'>"+getLabel("ePH.Recom.Dose.label","PH")+'&nbsp;</font>';
		}
		else {
			frmObj.rec_legend.disabled =true;//ADDED FOR ML-MMOH-CRF-0978
			frmObj.rec_legend.innerHTML = getLabel("ePH.Recom.Dose.label","PH")+'&nbsp;';
			}
	
		if(frmObj.recomm_yn.value=="Y" &&  document.getElementById("default_recm_dose_yn").value == "Y" && frmObj.rec_legend.disabled == false) {
			defaultRecomDose();//added for ml-mmoh-crf-0978
		}
	}
	frmObj.STRENGTH_VALUE.focus();

}

function setDosageDetails(dose,defUomcode){
	var frmObj		= document.formIVPiggyBackDrugDetails;
	frmObj.STRENGTH_VALUE.value = dose;
	frmObj.STRENGTH_UOM.value = defUomcode;

	if(frmObj.dosage.value=="S")
		frmObj.STRENGTH_UOM.disabled=true;
	else
		frmObj.STRENGTH_UOM.disabled=false;
}

function addData(code, desc, obj) {
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	code;
	opt.text = desc;
	obj.add(opt);
}

function setDefaultData(code, frmObj, mode) {
	
	//added for the incident no SKR-SCF-0066 by chandrashekar raju
	if(document.formIVPiggyBackDrugDetails == undefined)
		frmObj =  parent.f_sub_ivPiggyBackdrugs.document.formIVPiggyBackDrugDetails;

	frmObj = eval(frmObj);
	if (mode == 1) {
		frmObj.STRENGTH_UOM.value = code;
	/*if (mode == 1) {
		if (frmObj.QTY_DESC_CODE.value == "")
		{
			frmObj.STRENGTH_UOM.value = code;
		}
		/*else
		{
			frmObj.STRENGTH_UOM.value = frmObj.QTY_DESC_CODE.value;
		} */
	}
}

function setCalculatedQty(obj,caldfrm) {

	var frmObj = document.formIVPiggyBackDrugDetails;
	if(frmObj == undefined)
		frmObj = parent.f_iv_pb_drug.document.formIVPiggyBackDrugDetails;
	if (CheckPositiveNumber(obj)){

		if (frmObj.DOSAGE.value == "S") {
			var objVal				= obj.value;
			frmObj.BMS_QTY.value	= Math.ceil(objVal/frmObj.STR_VAL.value);
			setInfusionPeriod(frmObj.INFUSION_VALUE);
		}
	}
	if(frmObj.iv_fluid_yn.value == "Y" || frmObj.iv_fluid_yn.value == "y"){
			// its a ready to use iv drug, no fluid is required
			if(parent.parent.f_ivdetails == undefined){
				if(parent.formIVPiggyBackVehicle == undefined)
					fluidForm = 	parent.f_iv_pb.document.formIVPiggyBackVehicle;
				else	
					fluidForm	= parent.formIVPiggyBackVehicle;
			}else{
				
					fluidForm	= parent.parent.f_ivdetails.f_iv_pb.document.formIVPiggyBackVehicle;
			}
			if(frmObj.dosage.value == "S"){
				strengthValue = frmObj.STRENGTH_VALUE.value;
				drug_strength_value  = frmObj.drug_strength_value.value;
				strengthPerPresUom = frmObj.strength_per_value_pres_uom.value;

				valueInPresBaseUom = strengthValue * strengthPerPresUom / drug_strength_value;
			}
			else{
				fluidForm.volume.value=frmObj.STRENGTH_VALUE.value;
			}
			
			if(caldfrm != 'frmCalInfuseOver')//this if condition added for 24668
				calInfuseOver();

			setSchedule();
	}
}
async function openEDLDetails(DrugCode)
{
  if(DrugCode!=''&&DrugCode!=null){
	var dialogHeight	= "40";
	var dialogWidth		= "35";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status;
	var arguments		= "";
	
	await window.showModalDialog("../jsp/EDLAssociateListViewFrames.jsp?DrugCode="+DrugCode, arguments, features);
	}
 
}//end function
function setDrugDosageDetails(){

		var bean_id							= document.formIVPiggyBackDrugDetails.bean_id.value;
		var bean_name						= document.formIVPiggyBackDrugDetails.bean_name.value;
		var patient_id						= document.formIVPiggyBackDrugDetails.patient_id.value;
		var encounter_id					= document.formIVPiggyBackDrugDetails.encounter_id.value;
		var strengthUom                     = document.formIVPiggyBackDrugDetails.STRENGTH_UOM.value;
		var drug_dosage                     = document.formIVPiggyBackDrugDetails.STRENGTH_VALUE.value;
		var dosage_type                     = document.formIVPiggyBackDrugDetails.dosage.value;

		var qryString	= 	bean_id+"&bean_name="+bean_name+"&validate=SETUOM&strengthUom="+strengthUom+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&drug_dosage="+drug_dosage+"&dosage_type="+dosage_type;
		submitXML(qryString, "");

}

 function getHrsMinStr(HMvalue,HMunit ){
	// if( HMunit == 'H' ) {
		 hrs = Math.floor(HMvalue);
		 HMvalue = HMvalue * 60;
/*	 } 
	 else {
		 hrs = HMvalue / 60;
	 }*/
	 min = HMvalue % 60;
	 return( '['+Math.floor(hrs) + ' Hrs ' + Math.round(min) + ' Mins]' );
 }

 async function showAllergyDetails(generic_id, patient_id, encounter_id, generic_name, drug_name) {
	
	var dialogTop		= "310";
 	var dialogHeight	= "12";
 	var dialogWidth		= "25";
	var dialogLeft		= "240";
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		= "";
 	var retVal 			= await window.showModalDialog("../jsp/PrescriptionAllergyDetailsFrames.jsp?generic_name="+generic_name+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&patient_id="+patient_id+"&drug_name="+drug_name,arguments,features);
}
async function showDosageLimit(drug_desc, monograph, daily_dose, unit_dose, min_daily_dose, min_unit_dose,dosage_unit, dosage_std,dose_unit_desc,max_daily_ceeling_dose,min_daily_ceeling_dose,max_unit_ceeling_dose,min_unit_ceeling_dose,dose_unit_desc1) {//Modified for IN:070451, IN073670
	var dialogTop		= "310";
 	var dialogHeight	= "17";
 	var dialogWidth		= "36";
	var dialogLeft		= "180";
 	var features		= "Width:" + dialogWidth + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogLeft:" + dialogLeft +"; dialogTop:" + dialogTop +"; scroll=no; status=no";
 	var arguments		= "";
 	var frmObj			= parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;//Added for IN:070451
 	var mono_graph		= frmObj.mono_graph.value;//Added for IN:070451 
 	//added for IN073670
 	if(mono_graph==null || mono_graph==""){
 		mono_graph = monograph;
 	}else{
 		mono_graph= encodeURIComponent(mono_graph,"UTF-8");
 	}
 	var retVal 			= await window.showModalDialog("../jsp/PrescriptionDosageLimitMonoGraph.jsp?drug_desc="+escape(drug_desc)+"&mono_graph="+mono_graph+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&min_daily_dose="+min_daily_dose+"&min_unit_dose="+min_unit_dose+"&dosage_unit="+dosage_unit+"&dosage_std="+dosage_std+"&dose_unit_desc="+dose_unit_desc+"&max_daily_ceeling_dose="+max_daily_ceeling_dose+"&min_daily_ceeling_dose="+min_daily_ceeling_dose+"&max_unit_ceeling_dose="+max_unit_ceeling_dose+"&min_unit_ceeling_dose="+min_unit_ceeling_dose+"&dose_unit_desc1="+dose_unit_desc1,arguments,features);//Modified for IN:070451 & IN073670
}
async function callCurrentMedication(patient_id, encounter_id, generic_id, patient_class) {
		
	if(generic_id == undefined)
		generic_id="";
	var dialogHeight	= "30vh";
	var dialogWidth		= "50vw";
	var dialogTop		= "250";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	var retVal			= await window.showModalDialog("../jsp/PrescriptionActiveOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&patient_class="+patient_class+"&called_frm=PH",arguments,features);
}
 function getInfuseOverInMin(hr, mi){
	if(hr == "")
		hr = 0;
	if(mi == "")
		mi = 0;
	tot = parseFloat(hr*60)+parseFloat(mi);
	return tot;
 }

 function dfltFreq(default_val){

	 if(default_val!='')
	 {
		parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.FREQUENCY.value=default_val;
	 }
	 else
	 {
		 var element = document.createElement('OPTION') ;
		 element.value		=  "" ;
	     element.text		= "---Select---";
		 element.selected	=true;

		 parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.FREQUENCY.add(element);
	 }

}
function addFrequencyList(code,desc,default_val)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	if(default_val!=''){
		if(code==default_val){
			element.selected	=	true;
		}		
	}

	parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.FREQUENCY.add(element);
}

function setCalculateBy(obj,mode)
{
	val1=obj.value;
	if(mode!="AMEND_RESET")
	{
		frmobj=document.formIVPiggyBackDrugDetails;
	}
	else
	{
		frmobj=parent.f_detail.f_iv_pb_drug.document.formIVPiggyBackDrugDetails
	}
	if(mode=="amend")
	{
		var headerfrmobj=	parent.parent.f_header.prescription_header_form;
	}
	else if(mode=="AMEND_RESET")
	{
		var headerfrmobj=	parent.f_header.prescription_header_form;
	}
	else
	{
		var headerfrmobj=	parent.parent.parent.f_header.prescription_header_form;
	}
	var weight		=	headerfrmobj.weight.value;
    var height		=	headerfrmobj.height.value;

	if(val1 == frmobj.current_CALC_DOSE_BASED_ON.value)
		return;
	else{
		if((obj.value=="B" && !(weight=="" || weight=="0" || height=="" || height=="0")) || obj.value=="D")
			frmobj.current_CALC_DOSE_BASED_ON.value = val1;
	}
	if(obj.value=="B")
	{		
		if(weight=="" || weight=="0" || height=="" || height=="0")
		{
			alert(getMessage("PAT_HEIGHT_WEIGHT_BLANK","PH"));
			frmobj.CALC_DOSE_BASED_ON_D.checked=true;
			frmobj.CALC_DOSE_BASED_ON_B.checked=false;
			frmobj.current_CALC_DOSE_BASED_ON.value = "D";
			return false;
		}
		if(frmobj.dosage.value=="Q")
		{
			frmobj.dosage.value= "S";
			changeScrDetails("S");
		}
		frmobj.calc_by_row2.style.display="inline";
		frmobj.calc_by_row1.style.display="none";		
		calculateDosage_By_BSA_or_Weight(mode);
		//frmobj.strength_value_wt_bsa.value=frmobj.STR_VAL.value;
		
	}
	else
	{
		frmobj.calc_by_row1.style.display="inline";
		frmobj.calc_by_row2.style.display="none";
		//frmobj.STRENGTH_VALUE.value=frmobj.strength_value_wt_bsa.value;
		//frmobj.STRENGTH_VALUE.value=frmobj.ORDERSET_STRENGTH.value;
		 frmobj.STRENGTH_VALUE.value=frmobj.STR_VAL.value;
	}
	if(frmobj.recomm_yn.value=="Y" &&  document.getElementById("default_recm_dose_yn").value == "Y") {
		defaultRecomDose();//added for ml-mmoh-crf-0978
	}
}
function calculateDosage_By_BSA_or_Weight(mode)
{
	if(mode!="AMEND_RESET")
	{
		frmobj=document.formIVPiggyBackDrugDetails;
	}
	else
	{
		frmobj=parent.f_detail.f_iv_pb_drug.document.formIVPiggyBackDrugDetails
	}
	if(mode=="amend")
	{
		var headerfrmobj=	parent.parent.f_header.prescription_header_form;
	}
	else if(mode=="AMEND_RESET")
	{
		var headerfrmobj=	parent.f_header.prescription_header_form;
	}
	else
	{
		var headerfrmobj=	parent.parent.parent.f_header.prescription_header_form;
	}

	var baseDoseValue=	frmobj.CALC_DOSE_VALUE.value;
	var kg_m2_value	=	frmobj.CALC_DOSE_BY.value;
	var weight		=	headerfrmobj.weight.value;
    var bsa			=	headerfrmobj.bsa.value;
	if(baseDoseValue!="" && baseDoseValue!="0")	{
		totDoseValue="";
		if(kg_m2_value=="KG"){
			totDoseValue=parseFloat(baseDoseValue)*parseFloat(weight);
		}
		else{
			totDoseValue=parseFloat(baseDoseValue)*parseFloat(bsa);
		}
		if(isNaN(totDoseValue)){
			//totDoseValue="0";
			frmobj.strength_value_wt_bsa.value=frmobj.STR_VAL.value;
		}
		else
			frmobj.strength_value_wt_bsa.value=Math.round(parseFloat(totDoseValue)*1000)/1000;
	}
	else{
		frmobj.strength_value_wt_bsa.value=frmobj.STR_VAL.value;
	}
	
	frmobj.STRENGTH_VALUE.value=frmobj.strength_value_wt_bsa.value;
	frmobj.strength_value_wt_bsa.focus();
	setDrugDosageDetails();
//alert("3482-frmobj.strength_value_wt_bsa.value="+frmobj.strength_value_wt_bsa.value);
}

async function previewRX(title_display) {
   if(!CalculateOrderQuantity()){
	   return false;
   }
   // var headerForm	      = parent.parent.f_header.prescription_header_form;
	if(parent.parent.f_header)
		 var headerForm = parent.parent.f_header.document.prescription_header_form;
	else
		 var headerForm = parent.f_header.document.prescription_header_form;

	//var headerForm	      = parent.parent.f_header.prescription_header_form;

	if(parent.f_ivdetails !=undefined){
		var adminForm	= parent.f_ivdetails.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
		var fluidForm	= parent.f_ivdetails.f_iv_pb.formIVPiggyBackVehicle;
		var adminForm1	=parent.f_ivdetails.f_iv_pb_admin_dtls;
		var drugDetailFrom = parent.f_ivdetails.f_iv_pb_drug.formIVPiggyBackDrugDetails;
	}
	else{
		var adminForm	= parent.f_detail.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail
		var fluidForm	= parent.f_detail.f_iv_pb.formIVPiggyBackVehicle;
		var adminForm1	= parent.f_detail.f_iv_pb_admin_dtls;
		var drugDetailFrom = parent.f_detail.f_iv_pb_drug.formIVPiggyBackDrugDetails
	}
	
	var mode = drugDetailFrom.mode.value; //Added for MMS-DM-CRF-0177

	if(validateFrequency( adminForm)){
		var patient_id		  = headerForm.patient_id.value;
		var encounter_id	  = headerForm.encounter_id.value;
		var ord_date		  = headerForm.sys_date.value;
		var locn_code		  = headerForm.location_code.value;
		var pract_name		  = headerForm.pract_name.value;
		var patient_class	  = headerForm.actual_patient_class.value;
		var fluid_code		  = fluidForm.vehicle.options[fluidForm.vehicle.selectedIndex].value;
		var fluid_name		  = fluidForm.vehicle.options[fluidForm.vehicle.selectedIndex].text;		
		var infusion_rate 	  = adminForm.INFUSION_VALUE.value;
		var infusion_over	  = adminForm.infusion_over_insert_value.value;
		var infusion_over_uom = "H";
		var durn_value		  = adminForm.DURN_VALUE.value;
		var durn_unit		  = adminForm.durn_unit.value;
		var infusion_rate_uom = adminForm.STOCK_UOM_CODE.value; //added for SKR-SCF-0089 [Incident No. 028819]
		//var DrugIndicationRemarks=drugDetailFrom.DrugIndicationRemarks.value;//added for MMS Adhoc Testing
		//var infusion_rate_uom = adminForm1.document.getElementById("infusion_uom_display").innerText; //Commented for SKR-SCF-0089 [Incident No. 028819]
		//	if(drugDetailFrom.iv_fluid_yn.value == "Y")
		//	infusion_rate_uom = drugDetailFrom.STRENGTH_UOM.options[drugDetailFrom.STRENGTH_UOM.selectedIndex].text;

		//var split_vals	      = infusion_rate_uom.split("/"); //Commented for SKR-SCF-0089 [Incident No. 028819]
		//    infusion_rate_uom = split_vals[0]; //Commented for SKR-SCF-0089 [Incident No. 028819]

		var tot_inf_volume	  = fluidForm.volume.value;// //replaced BASE_VOLUME with volume for IN25538 --25/02/2011-- priya

		//FREQUENCY
		var freq_desc		  = adminForm.FREQUENCY.options[adminForm.FREQUENCY.selectedIndex].text;
		var freq_code		  = adminForm.FREQUENCY.value;
		var start_date		  = adminForm.START_DATE.value;
		var end_date		  = adminForm.END_DATE.value;
		var lstInfusionRateDurnUnit	 = adminForm.infusion_time.options[adminForm.infusion_time.selectedIndex].value;
		var dialogHeight= "87vh";
		var dialogWidth	= "66vw";
		var dialogTop	= "";
		var center		= "1";
		var status		= "no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "";
		var retVal		= await top.window.showModalDialog("../../ePH/jsp/IVPiggyBackPreviewDrugDetails.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&ord_date="+ord_date+"&locn_code="+locn_code+"&pract_name="+encodeURIComponent(pract_name,"UTF-8")+"&patient_class="+patient_class+"&fluid_code="+fluid_code+"&fluid_name="+encodeURIComponent(fluid_name,"UTF-8")+"&infusion_rate="+infusion_rate+"&infusion_over="+infusion_over+"&infusion_over_uom="+infusion_over_uom+"&infusion_rate_uom="+infusion_rate_uom+"&tot_inf_volume="+tot_inf_volume+"&durn_value="+durn_value+"&durn_unit="+durn_unit+"&freq_desc="+encodeURIComponent(freq_desc,"UTF-8")+"&freq_code="+freq_code+"&start_date="+start_date+"&end_date="+end_date+"&title_display="+encodeURIComponent(title_display,"UTF-8")+"&lstInfusionRateDurnUnit="+lstInfusionRateDurnUnit+"&mode="+mode, arguments, features);// DrugIndicationRemarks added for MMS Adhoc Testing //mode added for MMS-DM-CRF-0177
		if(retVal!= undefined && retVal=='R') //if block added for ML-BRU-SCF-0533 [IN:036030]
			document.formIVPrescriptionButtons.RELEASE.click();
	}
}

function CalculateOrderQuantity(){
    if(parent.parent.f_header)
	     var headerForm = parent.parent.f_header.document.prescription_header_form;
	else
		 var headerForm = parent.f_header.document.prescription_header_form;
    if(parent.f_ivdetails){
	   var drugForm     = parent.f_ivdetails.f_iv_pb_drug.document.formIVPiggyBackDrugDetails;
	   var adminForm    = parent.f_ivdetails.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail;
	   var fluidForm	= parent.f_ivdetails.f_iv_pb.document.formIVPiggyBackVehicle;
	}
	else{
       var drugForm     = parent.f_detail.f_iv_pb_drug.document.formIVPiggyBackDrugDetails;
	    var adminForm   = parent.f_detail.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail;
		var fluidForm	= parent.f_detail.f_iv_pb.document.formIVPiggyBackVehicle;
	}
   
	
	
	var iv_bean_id = drugForm.iv_bean_id.value;
	var iv_bean_name = drugForm.iv_bean_name.value
	var patient_id = headerForm.patient_id.value
	var encounter_id = headerForm.encounter_id.value
	var mode       = drugForm.mode.value;
	var actual_patient_class = headerForm.actual_patient_class.value

	var fluid_code		  = fluidForm.vehicle.value;
	var infusion_over	  = adminForm.infusion_over_insert_value.value;
	var tot_inf_prd		= adminForm.STOCK_VALUE.value;
	var durn_value		= adminForm.DURN_VALUE.value;
	var repeat_value    = adminForm.repeat_value.value;
	var durn_unit_val    = adminForm.durn_unit.value;

	var infusion_period_value		= adminForm.INFUSION_PERIOD_VALUE.value;
	var infusion_period_value_min	= adminForm.INFUSION_PERIOD_VALUE_MIN.value;
	var freq_code	= adminForm.FREQUENCY.value;
	var InfuseOverInMin             = getInfuseOverInMin(infusion_period_value,infusion_period_value_min); 
	var dur_val=adminForm.DURN_VALUE.value; 
//		dur_val = dur_val*60;
	if(adminForm.durn_unit.value == "H")
		dur_val = dur_val*60;
	if(adminForm.durn_unit.value == "D")
		dur_val = dur_val*24*60;
	if(adminForm.durn_unit.value == "W")
		dur_val = dur_val*7*24*60;
	if(adminForm.durn_unit.value == "L")
		dur_val = dur_val*30*24*60;
	if(adminForm.durn_unit.value == "Y")
		dur_val = dur_val*12*30*24*60;

	if (drugForm.drug_code.value == "") {
		alert(getMessage("DRUG_CANT_BE_BLANK","PH"));
		drugForm.drug_name.focus();
		return false;
	}		
	else if (drugForm.STRENGTH_VALUE.value == "" || drugForm.STRENGTH_VALUE.value == "0") {
		alert(getMessage("PRES_DOSAGE_CANNOT_ZERO","PH"));
		drugForm.STRENGTH_VALUE.focus();
		return false;
	}else if (drugForm.STRENGTH_UOM.value == "") {
		alert(getMessage("STR_UOM_CANT_BLANK","PH"));
		drugForm.STRENGTH_UOM.focus();
		return false;
	}
	else if (trimCheck(fluidForm.vehicle.value) == "") {
		alert(getMessage("VHCLE_CANT_BLANK","PH"));
		fluidForm.vehicle.focus();
		return false;
	}
	else if (adminForm.INFUSION_VALUE.value == "" || parseFloat(adminForm.INFUSION_VALUE.value) == 0) {
		alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
		adminForm.INFUSION_VALUE.focus();
		return false;
	}
	else if (drugForm.STRENGTH_VALUE.value == "" || drugForm.STRENGTH_VALUE.value == "0") {
		alert(getMessage("PRES_DOSAGE_CANNOT_ZERO","PH"));
		drugForm.STRENGTH_VALUE.focus();
		return false;
	}
	else if (trimCheck(adminForm.FREQUENCY.value) == "") { //added for SRR20056-SCF-7374 Incident No. 27415
		alert(getMessage("FRQ_CANT_BLANK","PH"));
		return false;
	}
	else if (trimCheck(adminForm.END_DATE.value) == "" || trimCheck(adminForm.DURN_VALUE.value) == "" || trimCheck(adminForm.durn_unit.value) == "") {  //added for SRR20056-SCF-7374 Incident No. 27415
		alert(getMessage("DURATION_CANT_BLANK","PH"));
		return false;
	}
	else if ((adminForm.INFUSION_PERIOD_VALUE.value == "" || parseFloat(adminForm.INFUSION_PERIOD_VALUE.value) == 0)&&(adminForm.INFUSION_PERIOD_VALUE_MIN.value == "" || parseFloat(adminForm.INFUSION_PERIOD_VALUE_MIN.value) == 0)) {
		alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
		adminForm.INFUSION_PERIOD_VALUE.focus();
		return false;
	}else  if(parseInt(adminForm.INFUSION_PERIOD_VALUE_MIN.value)>59){
			alert(getMessage("INVALID_TIME_MINUTE","PH"));
			//frmAdminObj.INFUSION_PERIOD_VALUE_MIN.focus();
			return false;

	}else  if((parseFloat(InfuseOverInMin) )>( parseInt(dur_val))){

			alert(getMessage("DURATION_CANNOT_LESSTHAN","PH"));	
			return false;
		
	}

	var dosage      = drugForm.STRENGTH_VALUE.value;
	var volume      =fluidForm.volume.value; 

	var xmlStr ="<root><SEARCH ";					

	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "encounter_id =\"" + encounter_id + "\" " ;
	xmlStr+= "fluid_code =\"" + fluid_code + "\" " ;
	xmlStr+= "infusion_over =\"" + infusion_over + "\" " ;
	xmlStr+= "tot_inf_prd =\"" + tot_inf_prd + "\" " ;
	xmlStr+= "durn_value =\"" + durn_value + "\" " ;
	xmlStr+= "drug_dosage =\"" + dosage + "\" " ;
	xmlStr+= "fluid_volume =\"" + volume + "\" " ;
	xmlStr+= "repeat_value =\"" + repeat_value + "\" " ;
	xmlStr+= "durn_unit =\"" + durn_unit_val + "\" " ;
	xmlStr+= "drug_code =\"" + drugForm.drug_code.value + "\" " ;
	xmlStr+= "freq_code =\"" + freq_code + "\" " ;
	xmlStr+= "freq_nature =\"" + adminForm.freq_nature.value + "\" " ;
	xmlStr+= "mode =\"" + mode + "\" " ;
	if(mode=="amend"){
	   // var or_date_time = headerForm.or_date_time.value;
	   xmlStr+= "or_date_time =\"" +  headerForm.or_date_time.value + "\" " ;
   }
	xmlStr +=" /></root>";
	var temp_jsp="IVPBValidate.jsp?validate=SAVE_FLUIDDETAILS"+"&bean_id="+iv_bean_id+"&bean_name="+iv_bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
    eval(responseText);
	return true;
}
function assignStrengthForBSA()
{
	var frmobj		=	document.formIVPiggyBackDrugDetails;
	frmobj.STRENGTH_VALUE.value=frmobj.strength_value_wt_bsa.value;

}

function setBackFutureDate(back_date, future_date,durn_value,called_from) {//durn_value and called_from added for ML-MMOH-CRF-1223
	parent.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.back_date.value=back_date ;
	parent.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.future_date.value=future_date;
	if(called_from =="DRUGLOAD")//Added for ML-MMOH-CRF-1223
		parent.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.DURN_VALUE.value = durn_value;//Added for ML-MMOH-CRF-1223(For SCF-7176)
	
}

function chkBackFutureDate(obj, locale){
	if(parent.f_iv_pb_admin_dtls != undefined)
	  var frmAdminObj	= parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	else
	  var frmAdminObj	= parent.f_detail.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail
	
	var start_date_chk = frmAdminObj.START_DATE.value;	
	if(start_date_chk!=""){
		var back_date=parent.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.back_date.value;
	
		var future_date=parent.f_iv_pb_admin_dtls.document.formIVPrescriptionAdminDetail.future_date.value
		if(validDate(start_date_chk, "DMYHM",locale )){
			if(future_date!=null && future_date!='null' && future_date!="0" && future_date!=""){ //newly added future_date!="" for incident 33048
				if(isBefore(start_date_chk,future_date, "DMYHM",locale)){
					populateEndDate();
				}
				else{
					alert(getMessage("PH_BACK_DATE", "PH"));
					obj.focus();
					return false;
				}
			}
			
			if(back_date!=null &&  back_date!='null' && back_date!="0" && back_date!=""){  //newly added back_date!="" for incident 33048
				if(isAfter(start_date_chk,back_date, "DMYHM",locale)){
					populateEndDate();
				}
				else{
					alert(getMessage("PH_BACK_DATE", "PH"));
					obj.focus();
					return false;
				}
			}
			
		}
		else{
			alert(getMessage("INVALID_DATE_TIME", "PH"));
			document.formIVPrescriptionAdminDetail.START_DATE.focus();
			
			return false;
		}
	}
	else{
		alert(getMessage("PH_START_DATE", "PH"));
		document.formIVPrescriptionAdminDetail.Calendar.click();
		return false;
	}
}
//Added for  ML-BRU-CRF-072[Inc:29938] Start
async function drugindication_remarks(){
	var formobj		=	document.formIVPiggyBackDrugDetails;
	var drug_code = formobj.DRUG_CODE.value;
	if(drug_code ==""){
		return false;
	}
	var bean_id		= formobj.bean_id.value;
	var bean_name	= formobj.bean_name.value;
	var iv_prep_yn	= formobj.iv_prep_yn.value;
	var DrugIndicationRemarks	=	formobj.DrugIndicationRemarks.value;
	var dialogHeight= "50vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "" ;
	var dialogLeft ="";
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "" ;
	retVal = await top.window.showModalDialog("../../ePH/jsp/DrugIndicationRemarks.jsp?&DrugIndicationRemarks="+encodeURIComponent(DrugIndicationRemarks)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&iv_prep_yn="+iv_prep_yn,arguments,features);//remove escape and add encodeURIComponent for MMS Adhoc Testing
	if(retVal!=null)
		formobj.DrugIndicationRemarks.value=retVal;
}
function savedrugIndicationRemarks(drug_indicate){
	var drug_indication_new = encodeURIComponent(drug_indicate.value);
//	window.returnValue=drug_indication_new;
//	window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = drug_indication_new;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
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
}//Added for  ML-BRU-CRF-072[Inc:29938] End

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

//AAKH-CRF-0089 starts
function setEmptyDose(){
	var dosage_applicable=document.formIVPiggyBackDrugDetails.def_dosage_yn.value;
	if(dosage_applicable=="N"){
		document.formIVPiggyBackDrugDetails.STRENGTH_VALUE.value="";
	}
	
}
//AAKH-CRF-0089 ends


// Added for CRF AAKH-CRF-0094 Start

function calVolumeInfuseOver(call_mode) {
	var frmAdminObj = parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	var frmObj = parent.f_iv_pb.formIVPiggyBackVehicle;
	var drugfrmObj = parent.f_iv_pb_drug.document.formIVPiggyBackDrugDetails;
	var volume_reference = frmObj.volume_reference.value;
	var infusion_value = frmAdminObj.INFUSION_VALUE.value;
	var infusion_over;
	var INFUSION_PERIOD_VALUE = frmAdminObj.INFUSION_PERIOD_VALUE.value;
	INFUSION_PERIOD_VALUE = Math.floor(INFUSION_PERIOD_VALUE);
	var INFUSION_PERIOD_VALUE_MIN = frmAdminObj.INFUSION_PERIOD_VALUE_MIN.value;
	INFUSION_PERIOD_VALUE_MIN = Math.round(INFUSION_PERIOD_VALUE_MIN);
	var temp_volume;
	var InfuseOverInMin = getInfuseOverInMin(INFUSION_PERIOD_VALUE,INFUSION_PERIOD_VALUE_MIN); // Added for aakh-crf-0094
	
	if(infusion_value == "" || infusion_value == 0){
		alert(getMessage("INF_RATE_CANT_BLANK_ZERO","PH"));
		 frmAdminObj.INFUSION_VALUE.focus();
	}
		else if ((INFUSION_PERIOD_VALUE == "" ||  INFUSION_PERIOD_VALUE == 0) && (INFUSION_PERIOD_VALUE_MIN == "" && INFUSION_PERIOD_VALUE_MIN == 0)) {
	
		alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
		 frmAdminObj.INFUSION_PERIOD_VALUE.focus();
		
	} else {
		frmAdminObj.infusion_over_insert_value.value = InfuseOverInMin;
	    var unit = frmAdminObj.infusion_time.value;
		if (unit == "H") {
			
			var infusion_over_min = INFUSION_PERIOD_VALUE_MIN / 60;

			temp_volume = infusion_value * (INFUSION_PERIOD_VALUE + infusion_over_min);
			var volume = (Math.ceil(temp_volume / volume_reference)) * volume_reference;
			frmObj.volume.value = volume;
		} else {
			infusion_over = (INFUSION_PERIOD_VALUE * 60) + INFUSION_PERIOD_VALUE_MIN;
			temp_volume = Math.ceil((infusion_value * infusion_over) / volume_reference);
			frmObj.volume.value = temp_volume * volume_reference;
		}
		frmAdminObj.STOCK_VALUE.value = volume;
		var str =   '['+Math.floor(INFUSION_PERIOD_VALUE) + ' Hrs ' + Math.round(INFUSION_PERIOD_VALUE_MIN) + ' Mins]' ;
		frmAdminObj.infuse_over_str.innerHTML	= str;
		var dur_val = parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.DURN_VALUE.value;
		if (frmAdminObj.durn_unit.value == "H")
			dur_val = dur_val * 60;
		if (frmAdminObj.durn_unit.value == "D")
			dur_val = dur_val * 24 * 60;
		if (frmAdminObj.durn_unit.value == "W")
			dur_val = dur_val * 7 * 24 * 60;
		if (frmAdminObj.durn_unit.value == "L")
			dur_val = dur_val * 30 * 24 * 60;
		if (frmAdminObj.durn_unit.value == "Y")
			dur_val = dur_val * 12 * 30 * 24 * 60;

		infusion_over = infusion_over / 60;
		infusion_over = Math.round(infusion_over * 100) / 100;
		if ((parseFloat(infusion_over)) > (parseInt(dur_val))) {
			alert(getMessage("DURATION_CANNOT_LESSTHAN", "PH"));
		}
	}
	showAdminRate();
}
function calVolumeInfuseRate() {
	
	var frmAdminObj = parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	var frmObj = parent.f_iv_pb.formIVPiggyBackVehicle;
	var infusion_value = frmAdminObj.INFUSION_VALUE.value;
	
	var volume_reference = frmObj.volume_reference.value;
	var infusion_over;
	var INFUSION_PERIOD_VALUE = frmAdminObj.INFUSION_PERIOD_VALUE.value;
	INFUSION_PERIOD_VALUE = Math.floor(INFUSION_PERIOD_VALUE);
	var INFUSION_PERIOD_VALUE_MIN = frmAdminObj.INFUSION_PERIOD_VALUE_MIN.value;
	INFUSION_PERIOD_VALUE_MIN = Math.round(INFUSION_PERIOD_VALUE_MIN);
	var temp_volume;var volume;
	var InfuseOverInMin = getInfuseOverInMin(INFUSION_PERIOD_VALUE,
			INFUSION_PERIOD_VALUE_MIN);
	
	  if((INFUSION_PERIOD_VALUE == "" ||  INFUSION_PERIOD_VALUE == 0) && (INFUSION_PERIOD_VALUE_MIN == "" && INFUSION_PERIOD_VALUE_MIN == 0)) {
			alert(getMessage("INFS_OVR_CANT_BLANK_ZERO", "PH"));
			 frmAdminObj.INFUSION_PERIOD_VALUE.focus();
		}
		else if(infusion_value == "" || infusion_value == 0)
			{
			alert(getMessage("INF_RATE_CANT_BLANK_ZERO", "PH"));
			 frmAdminObj.INFUSION_VALUE.focus();
			}

		else {//alert("4507"+InfuseOverInMin/60);
			frmAdminObj.infusion_over_insert_value.value = InfuseOverInMin/60;
		var unit = frmAdminObj.infusion_time.value;
			
if (unit == "H") {
			
			var infusion_over_min = INFUSION_PERIOD_VALUE_MIN / 60;

			temp_volume = infusion_value * (INFUSION_PERIOD_VALUE + infusion_over_min);
			 volume = (Math.ceil(temp_volume / volume_reference)) * volume_reference;
			frmObj.volume.value = volume;
		} else {
			infusion_over = (INFUSION_PERIOD_VALUE * 60) + INFUSION_PERIOD_VALUE_MIN;
			temp_volume = Math.ceil((infusion_value * infusion_over) / volume_reference);
			volume=temp_volume * volume_reference;
			frmObj.volume.value =volume;
		}

			frmAdminObj.STOCK_VALUE.value = volume;
			

		var dur_val = parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.DURN_VALUE.value;
		if (frmAdminObj.durn_unit.value == "H")
			dur_val = dur_val * 60;
		if (frmAdminObj.durn_unit.value == "D")
			dur_val = dur_val * 24 * 60;
		if (frmAdminObj.durn_unit.value == "W")
			dur_val = dur_val * 7 * 24 * 60;
		if (frmAdminObj.durn_unit.value == "L")
			dur_val = dur_val * 30 * 24 * 60;
		if (frmAdminObj.durn_unit.value == "Y")
			dur_val = dur_val * 12 * 30 * 24 * 60;

		if (parseInt(frmAdminObj.INFUSION_PERIOD_VALUE_MIN.value) > 59) {
			alert(getMessage("INVALID_TIME_MINUTE", "PH"));
			 frmAdminObj.INFUSION_PERIOD_VALUE_MIN.focus();

		} else if ((parseFloat(InfuseOverInMin)) > (parseInt(dur_val))) {
			alert(getMessage("DURATION_CANNOT_LESSTHAN", "PH"));
			frmAdminObj.DURN_VALUE.focus();
		}
	}	var str =   '['+Math.floor(INFUSION_PERIOD_VALUE) + ' Hrs ' + Math.round(INFUSION_PERIOD_VALUE_MIN) + ' Mins]' ;
	frmAdminObj.infuse_over_str.innerHTML	= str;
	showAdminRate();
}
// Added for CRF AAKH-CRF-0094 end

async function loadDrugInfo(prodid, drugdesc) { // Added for PMG2018-COMN-CRF-0002 - Start
	var dialogHeight	="85" ;
	var dialogWidth	="70";
	var dialogTop		= "110";
	var dialogLeft		= "70";
	var center			= "0";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal 				= await window.showModalDialog("../../ePH/jsp/DisplayDrugInfoFrames.jsp?extprodid="+prodid+"&drugdesc="+drugdesc+"&JSFile=../../ePH/js/Prescription_1.js",arguments,features);
} // Added for PMG2018-COMN-CRF-0002 - End
//ML-MMOH-CRF-1408 - start
function dosageCheck(){
	var formObject			=  "";
	if(parent.parent.parent.f_header != undefined){
		formObject			= parent.parent.parent.f_header.document.prescription_header_form;
	}
	else{
		formObject			= parent.parent.f_header.document.prescription_header_form;
	}
	var drug_frmobj		    =  parent.f_iv_pb_drug.formIVPiggyBackDrugDetails;
	var adminObj			=  parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail;
	var iv_bean_id = drug_frmobj.iv_bean_id.value;
	var iv_bean_name = drug_frmobj.iv_bean_name.value;
	var patient_id = drug_frmobj.patient_id.value;
	var drug_code = drug_frmobj.drug_code.value;
	var srl_no = drug_frmobj.srl_no.value;
	var dosage_type = drug_frmobj.dosage.value;
	var qty_value							= drug_frmobj.STRENGTH_VALUE.value;
	var repeat_value				= adminObj.repeat_value.value;
	var bsa								= formObject.bsa.value;
	var weight							= formObject.weight.value;
	var calc_by_ind =drug_frmobj.calc_by_ind.value;
	//alert(calc_by_ind);
	var factor;
	var mode="2";
	var temp_qty ="";
	 if(formObject.bsa.value.length > 0){
		 if(drug_frmobj.calc_by_ind!=undefined){ 
			 if(calc_by_ind=="W") {
				temp_qty	=	(parseFloat(qty_value)/parseFloat(weight));
				factor=weight;
			}
			else if(calc_by_ind=="B") {
				temp_qty	=	(parseFloat(qty_value)/parseFloat(bsa));
				factor=bsa;
				
		   }else{
			 temp_qty=qty_value;
			 factor="1";
		   }
		 }else{
			 temp_qty=qty_value;
		 factor="1";
		 }
	 }
	 if(temp_qty==""){ 
		 temp_qty = qty_value;
		 factor="1";
	 }
	var xmlStr ="<root><SEARCH ";					
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;
	xmlStr+= "drug_code =\"" + drug_code + "\" " ;
	xmlStr+= "srl_no =\"" + srl_no + "\" " ;
	xmlStr+= "repeat_value =\"" + repeat_value + "\" " ;
	xmlStr+= "qty_value =\"" + temp_qty + "\" " ;
	xmlStr+= "factor =\"" + factor + "\" " ;
	xmlStr+= "dosage_type =\"" + dosage_type + "\" " ;
	xmlStr+= "mode =\"" + mode + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="IVPrescriptionValidate.jsp?validate=DosageLimitCheck"+"&bean_id="+iv_bean_id+"&bean_name="+iv_bean_name;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
	
}
//ML-MMOH-CRF-1408 - end
//Added for IN:069887 start
function showOverideMandAlert(allergy_remarks_yn, dup_remarks_yn, dose_remarks_yn,abuse_remarks_yn){
	
	
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
	if(abuse_remarks_yn==='Y') {
		names[i]	="Drug Abuse Override Reason";
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
//Added for IN:069887 end

//Added for TFS-13907
function mandateRemarks() {
	alert(getMessage("OVR_RDN_RSN-CANT_BLNK","PH"));
  }
//Added for TFS-13907
//added for AAKH-CRF-0140
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
  
