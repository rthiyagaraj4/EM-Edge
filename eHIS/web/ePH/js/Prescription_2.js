/***********saved on 25th Oct 2005 ******************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
26/07/2019      IN:070451           B Haribabu  27/07/2019      Manickavasagam           ML-MMOH-CRF-1408
07/08/2019      IN:071048           Manickavasagam J  07/08/2019  	Manickavasagam J			  SKR-SCF-1262
07/08/2019      IN:071108           B Haribabu                                           ML-MMOH-CRF-1408
13/09/2019      IN071370		    B Haribabu  13/09/2019                              ML-MMOH-CRF-1408
04/12/2019      IN071823		    Manickavasagam J                               ML-MMOH-CRF-1408
09/06/2020      IN:072715              Haribabu                                        MMS-DM-CRF-0165
2/07/2020  		IN073176           	Shazana                          					SKR-SCF-1337
28/07/2020      IN:073485                   Haribabu                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order
24/08/2020      IN073769		   B Haribabu                                           PHIS-PH-Alpha - Exceed Dosage Limit Icon not opening in CA place order
13/10/2020      IN:073110              Manickavasagam J             ML-MMOH-CRF-1531
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
18/11/2020      TFS:8027              Manickavasagam J                             ML-MMOH-CRF-1531
29/11/2020  	IN:7980	        	Manickavasagam J                                    ML-BRU-SCF-2069
30/11/2020		7539				Shazana												ML-BRU-SCF-2067	
28/02/2021		TFS-7506			Prabha       28/02/2021     Manickavasagam J    
25/05/2023		IN:44863			Sushant Tambe										MMS-DM-CRF-0239
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/  
var function_id		= "" ;
var result			= false ;
var message			= "" ;
var flag			= "" ;
var allergy_result	= false;
var availOrdCatCode	= false;
var DuplicateDrugCode =false;
var return_val		= true; 
var oldrepeatvalue;
var durn_type_list	=	new Array();

function loadAllOtherFrames(){
	var mode			=	"amend";
	var header_formObj =	 parent.f_header.document.prescription_header_form;
    var patient_id      = document.prescription_header_form.patient_id.value;
    var encounter_id    = document.prescription_header_form.encounter_id.value;
    var location_type   = document.prescription_header_form.location_type.value;
    var location_code   = document.prescription_header_form.location_code.value;
    var patient_class   = document.prescription_header_form.patient_class.value;
    var order_date_time = document.prescription_header_form.or_date_time.value;
    var scheduled_yn	= document.prescription_header_form.schedule_yn.value;
	var called_from		= document.prescription_header_form.called_from.value;
	var iv_prep_yn      = document.prescription_header_form.iv_prep_yn.value;
	var height			=document.prescription_header_form.height.value;
	var weight			=document.prescription_header_form.weight.value;
	var bsa				=document.prescription_header_form.bsa.value;
	var srl_no			="1";  
	var problem_ind		= document.prescription_header_form.problem_ind.value;
	var order_id		= document.prescription_header_form.order_id.value;
	var order_line_num	= document.prescription_header_form.order_line_num.value;
	var priority		= document.prescription_header_form.priority.value;
	var take_home_medication		= document.prescription_header_form.take_home_medi_val.value;
	var bl_install_yn			= document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	= document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var adr_count	 =  document.prescription_header_form.adr_count.value;
	var trade_display_yn	 =  document.prescription_header_form.trade_display_yn.value;

	var drug_db_duptherapy_check_yn = header_formObj.drug_db_duptherapy_yn.value;
	var drug_db_interact_check_yn  =  header_formObj.drug_db_interact_check_yn.value;
	var drug_db_contraind_check_yn =  header_formObj.drug_db_contraind_check_yn.value;
	var drug_db_allergy_check_yn    =  header_formObj.drug_db_allergy_check_yn.value;

	var act_pat_class   = document.prescription_header_form.actual_patient_class.value;  // RUT-CRF-0062 
	var MAR_app_yn	= getMAR_app_yn_1(document.prescription_header_form);

	//called_from="AMEND_ORDER"; 
	if(called_from=="RENEW_ORDER") {
		if(iv_prep_yn=="1" || iv_prep_yn=="2"){
			parent.f_detail.location.href		= "../jsp/IVPrescriptionDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&order_type_flag=Existing"+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_pat_class="+act_pat_class; //RUT-CRF-0062 Added to get the build MAR Rule 
		}
		else if(iv_prep_yn=="3" || iv_prep_yn=="4"){
			parent.f_detail.location.href		= "../jsp/IVPiggyBack.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&order_type_flag=Existing"+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&order_line_num="+order_line_num+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_pat_class="+act_pat_class;  //RUT-CRF-0062 
		}
		else if(iv_prep_yn=="5"){ 
			parent.f_detail.location.href		= "../jsp/IVFluidAdditives.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&start_date="+order_date_time+"&order_type_flag=Existing"+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_pat_class="+act_pat_class;  //RUT-CRF-0062 
		}
		else if(iv_prep_yn=="6"){
			parent.f_compound.location.href	= "../jsp/PrescriptionCompFrames.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&order_type_flag=Existing"+"&start_date="+order_date_time+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&mode="+called_from+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&weight="+weight+"&bsa="+bsa+"&priority="+priority+"&act_pat_class="+act_pat_class; //RUT-CRF-0062 
		} 
		else {
			parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn;
			parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_2.jsp?srl_no="+srl_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&trade_display_yn="+trade_display_yn;
			parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_2.jsp?patient_id="+patient_id+"&mode="+mode+"&scheduled_yn="+scheduled_yn+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn;
		}
	} 
	else if(called_from=="AMEND_ORDER"){
		mode	=	"amend";
	    if(document.prescription_header_form.administered_yn.value == 0){
			if(iv_prep_yn=="1" || iv_prep_yn=="2"){
				parent.f_detail.location.href		= "../jsp/IVPrescriptionDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&order_type_flag=Existing"+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&take_home_medication="+take_home_medication+"&priority="+priority+"&mode="+mode+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&weight="+weight+"&bsa="+bsa+"&act_pat_class="+act_pat_class; //RUT-CRF-0062 Added to get the build MAR Rule 
				//iv_prep_yn="+iv_prep_yn+"&take_home_medication="+take_home_medication+"&priority="+priority added for ml-mmoh-crf-0863
				parent.f_button.location.href		= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&iv_prep_yn="+iv_prep_yn+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&mode="+mode+"&order_id="+order_id+"&act_pat_class="+act_pat_class;//NMC-JD-CRF-0063
			}
			else if(iv_prep_yn=="3" || iv_prep_yn=="4"){
			
				parent.f_detail.location.href		= "../jsp/IVPiggyBack.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&order_type_flag=Existing"+"&mode="+mode+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&order_line_num="+order_line_num+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_pat_class="+act_pat_class; //RUT-CRF-0062 
				parent.f_button.location.href		= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&iv_prep_yn="+iv_prep_yn+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&trade_display_yn="+trade_display_yn+"&mode="+mode+"&order_id="+order_id+"&act_pat_class="+act_pat_class;//NMC-JD-CRF-0063
			}
			else if(iv_prep_yn=="5"){

				parent.f_detail.location.href		= "../jsp/IVFluidAdditives.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&order_type_flag=Existing"+"&start_date="+order_date_time+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&mode="+mode+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_pat_class="+act_pat_class;  //RUT-CRF-0062 
				parent.f_button.location.href		= "../jsp/IVPrescriptionButtons.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&iv_prep_yn="+iv_prep_yn+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&priority="+priority+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&mode="+mode+"&order_id="+order_id+"&act_pat_class="+act_pat_class;//NMC-JD-CRF-0063
			}
			else if(iv_prep_yn=="6"){
				parent.f_compound.location.href	= "../jsp/PrescriptionCompFrames.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&order_type_flag=Existing"+"&start_date="+order_date_time+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&mode="+mode+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication+"&weight="+weight+"&bsa="+bsa+"&priority="+priority+"&act_pat_class="+act_pat_class;  //RUT-CRF-0062

			}
			else if(iv_prep_yn=="7" || iv_prep_yn=="8"){
				parent.f_tpnregimenselect.location.href	="../../ePH/jsp/TPNRegimenOptions.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&order_type_flag=Existing"+"&start_date="+order_date_time+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&mode="+mode+"&weight="+weight+"&height="+height+"&priority="+priority+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&location_type="+location_type+"&location_code="+location_code+"&take_home_medication="+take_home_medication;
			}
			else if(iv_prep_yn=="9" || iv_prep_yn=="0"){
				parent.oncology_detail.location.href="../../ePH/jsp/OncologyRegimen.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&act_patient_class="+patient_class+"&order_type_flag=Existing"+"&start_date="+order_date_time+"&order_id="+order_id+"&iv_prep_yn="+iv_prep_yn+"&mode="+mode+"&weight="+weight+"&height="+height+"&problem_ind="+problem_ind+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&location_type="+location_type+"&location_code="+location_code+"&act_pat_class="+act_pat_class+"&take_home_medication="+take_home_medication+"&clearOrNot=Y";	//NMC-JD-CRF-0063
			}
			else{
				parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&adr_count="+adr_count;
				parent.f_detail.location.href="../../ePH/jsp/PrescriptionAmendDetail.jsp?srl_no="+srl_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&trade_display_yn="+trade_display_yn;
				parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_2.jsp?patient_id="+patient_id+"&mode="+mode+"&scheduled_yn="+scheduled_yn+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn;
			}
		}
		else{
			alert(getMessage("AMND_CANT_FR_THS_DRUG","PH"));
			window.close();
		}			
	}
}

function loadAllOtherFrames_1(){

	var mode			=	"amend";
    var patient_id      = document.prescription_header_form.patient_id.value;
    var encounter_id    = document.prescription_header_form.encounter_id.value;
    var location_type   = document.prescription_header_form.location_type.value;
    var location_code   = document.prescription_header_form.location_code.value;
    var patient_class   = document.prescription_header_form.patient_class.value;
    var order_date_time = document.prescription_header_form.or_date_time.value;
	var called_from		= document.prescription_header_form.called_from.value;
    var drug_db_interface_yn       =  document.prescription_header_form.drug_db_interface_yn.value;
	var drug_db_dose_check_yn =   document.prescription_header_form.drug_db_dosecheck_yn.value;
	var drug_db_duptherapy_check_yn       =   document.prescription_header_form.drug_db_duptherapy_yn.value;
	var drug_db_interact_check_yn  =   document.prescription_header_form.drug_db_interact_check_yn.value;
	var drug_db_contraind_check_yn =   document.prescription_header_form.drug_db_contraind_check_yn.value;
	var drug_db_allergy_check_yn    =   document.prescription_header_form.drug_db_allergy_check_yn.value;
	var bl_install_yn				=	document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	=	document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var adr_count					= document.prescription_header_form.adr_count.value;
	var trade_display_yn					= document.prescription_header_form.trade_display_yn.value;
	var priority				=	document.prescription_header_form.priority.value;

	var MAR_app_yn					= getMAR_app_yn_1(document.prescription_header_form);

	if(called_from=="RENEW_ORDER") {
		if(parent.f_button != null){
			parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_2.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn;
			parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count;
			parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_2.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&trade_display_yn="+trade_display_yn+"&priority="+priority;
		}
	}
	else if(called_from=="AMEND_ORDER"){
		if(parent.f_button != null){
			parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_2.jsp?patient_id="+patient_id+"&mode=blank&encounter_id="+encounter_id+"&patient_class="+patient_class+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn;
			parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&trade_display_yn="+trade_display_yn;
			parent.f_detail.location.href="../../ePH/jsp/PrescriptionAmendDetail.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode=blank&start_date="+order_date_time+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&MAR_app_yn="+MAR_app_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&trade_display_yn="+trade_display_yn;
		}
	}
}

function modifyDrug(scheduled_yn,drug_code,mode,srl_no,sliding_scale_yn,recomm_yn){
    var start_date	=	parent.parent.f_header.document.prescription_header_form.or_date_time.value;
    var priority	=	parent.parent.f_header.document.prescription_header_form.priority.value;
    var patient_id	=	parent.parent.f_header.document.prescription_header_form.patient_id.value;
    var encounter_id=	parent.parent.f_header.document.prescription_header_form.encounter_id.value;
    var mode		=	"amend";
	var called_from	=	parent.parent.f_header.document.prescription_header_form.called_from.value;
	var patient_class	=	parent.parent.f_header.document.prescription_header_form.patient_class.value;

    var drug_db_interface_yn       =  parent.parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var drug_db_dose_check_yn =   parent.parent.f_header.document.prescription_header_form.drug_db_dosecheck_yn.value;
	var drug_db_duptherapy_check_yn       =   parent.parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
	var drug_db_interact_check_yn  =   parent.parent.f_header.document.prescription_header_form.drug_db_interact_check_yn.value;
	var drug_db_contraind_check_yn =   parent.parent.f_header.document.prescription_header_form.drug_db_contraind_check_yn.value;
	var drug_db_allergy_check_yn    =   parent.parent.f_header.document.prescription_header_form.drug_db_allergy_check_yn.value;
	var bl_install_yn				=	parent.parent.f_header.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	=	parent.parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var trade_display_yn	=	parent.parent.f_header.document.prescription_header_form.trade_display_yn.value;
	var MAR_app_yn					= getMAR_app_yn_1(parent.parent.f_header.document.prescription_header_form); //added for SRR20056-SCF-7882 -29157

	if(called_from=="RENEW_ORDER") {
		parent.parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_2.jsp?srl_no="+srl_no+"&drug_code="+drug_code+"&priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&trade_display_yn="+trade_display_yn;
		parent.parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_2.jsp?patient_id="+patient_id+"&scheduled_yn="+scheduled_yn+"&mode="+mode+"&encounter_id="+encounter_id+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn;
	} 
	else if(called_from=="AMEND_ORDER"){
		if(sliding_scale_yn=="Y" && recomm_yn == 'N'){

			var patient_id		= parent.parent.f_header.document.prescription_header_form.patient_id.value;
			var encounter_id	= parent.parent.f_header.document.prescription_header_form.encounter_id.value;
		//	var bed_num		= parent.parent.f_header.document.prescription_header_form.bed_num.value;
		//	var room_num	= parent.parent.f_header.document.prescription_header_form.room_num.value;
			var patient_class	= parent.parent.f_header.document.prescription_header_form.patient_class.value;
			var bsa				= parent.parent.f_header.document.prescription_header_form.bsa.value;
			var drug_db_interface_yn            = parent.parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
			var bl_install_yn            = parent.parent.f_header.document.prescription_header_form.bl_install_yn.value;
			var bl_install_yn			= parent.parent.f_header.document.prescription_header_form.bl_install_yn.value;
			var bl_disp_charge_dtl_in_rx_yn	= parent.parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
			var take_home_medication	= parent.parent.f_header.document.prescription_header_form.take_home_medication.value;
			var MAR_app_yn	= getMAR_app_yn_1(parent.parent.f_header.document.prescription_header_form);
			var trade_display_yn	= parent.parent.f_header.document.prescription_header_form.trade_display_yn.value;
			parent.parent.f_detail.location.href="../../ePH/jsp/PrescriptionSlidingScaleFrame.jsp?srl_no="+srl_no+"&drug_code="+drug_code+"&priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&take_home_medication="+take_home_medication+"&trade_display_yn="+trade_display_yn+"&called_from_amend=Y";
			parent.parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_2.jsp?patient_id="+patient_id+"&scheduled_yn="+scheduled_yn+"&mode="+mode+"&encounter_id="+encounter_id+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&trade_display_yn="+trade_display_yn+"&patient_class="+patient_class+"&called_from_amend=Y";
		}
		else{
			parent.parent.f_detail.location.href="../../ePH/jsp/PrescriptionAmendDetail.jsp?srl_no="+srl_no+"&drug_code="+drug_code+"&priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&patient_class="+patient_class+"&MAR_app_yn="+MAR_app_yn; // MAR_app_yn added for SRR20056-SCF-7882 -29157
			parent.parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_2.jsp?patient_id="+patient_id+"&scheduled_yn="+scheduled_yn+"&mode="+mode+"&encounter_id="+encounter_id+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&trade_display_yn="+trade_display_yn+"&patient_class="+patient_class;
		}
	}
}

async function showAmendAllergyDetails(srl_no,remarks,title,mode){
	var patient_id = parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id= parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var order_id =  parent.parent.f_header.document.prescription_header_form.order_id.value;
	
	var dialogHeight= "40vh" ;
	var dialogWidth = "57vw" ;
	var dialogTop = "255" ;
	var dialogLeft = "203" ;
	var center = "1" ;
	var status="no";
	var scroll="yes";
	var features    = "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	retVal              = await window.showModalDialog("../../ePH/jsp/PrescriptionAmendRemarksFrames.jsp?srl_no="+srl_no+"&remarks="+remarks+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&order_id="+order_id+"&title="+title,arguments,features);
}

function disasbleamendToolTipDataChange(){
    document.getElementById('tooltiplayer').style.visibility = "hidden" ;
}

function displayamendToolTipDataChange(text){
    buildamendTableDataChange(text);
    bodwidth  = parent.parent.frames[1].document.body.offsetWidth
    bodheight = parent.parent.frames[1].document.body.offsetHeight
    var x     = event.clientX; //changed event.x to event.clientX for SKR-SCF-1262
    var y     = event.clientY; //changed event.y to event.clientY for SKR-SCF-1262 
    x     = x + (document.getElementById('tooltiplayer').offsetWidth)
    y     = y + (document.getElementById('tooltiplayer').offsetHeight)

    if(x<bodwidth)
        x = event.clientX //changed event.x to event.clientX for SKR-SCF-1262
    else
        x = x - (document.getElementById('tooltiplayer').offsetWidth*2)
    if(y<bodheight)
        y = event.clientY //changed event.y to event.clientY for SKR-SCF-1262
    else
        y = y - (document.getElementById('tooltiplayer').offsetHeight*2)
    y+=document.body.scrollTop
    x+=document.body.scrollLeft
    document.getElementById('tooltiplayer').style.posLeft= x-25;
    document.getElementById('tooltiplayer').style.posTop = y-50;
    document.getElementById('tooltiplayer').style.visibility='visible';
    }

function buildamendTableDataChange(text){   
    var tab_dat  = text ;
    document.getElementById('t').innerHTML = tab_dat;

}

/*function amendloadRefillDetails(){
    var end_date=document.prescription_amend_detail_form.end_date.value;
    var repeat_durn_type=document.prescription_amend_detail_form.repeat_durn_type.value;
    var durn_desc=document.prescription_amend_detail_form.durn_desc.value;
    //repeat_durn_type=durn_desc;
    var durn_value=document.prescription_amend_detail_form.durn_value.value;
    var refill_no=document.prescription_amend_detail_form.no_refill.value;
    var bean_id=document.prescription_amend_detail_form.bean_id.value;
    var bean_name=document.prescription_amend_detail_form.bean_name.value;
    
    if(end_date!=""){
        var dialogHeight= "10" ;
        var dialogWidth = "21" ;
        var dialogTop = "375" ;
        var dialogLeft = "425" ;
        var center = "1" ;
        var status="no";
        var scroll="yes";
        var features    = "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
        var arguments   = "" ;
		retVal = window.showModalDialog("../../ePH/jsp/PrescriptionRefillDetailsFrame.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&end_date="+end_date+"&repeat_durn_type="+repeat_durn_type+"&durn_value="+durn_value+"&refill_no="+refill_no,arguments,features);
    }
	else{
        alert(getMessages("PH_CURR_END_DATE", "PH"));
    }
}*/ //Commented b'z not used.

function validateamendDosageLimit(display_alert_flag, calling_mode){

	var ext_prod_id = document.prescription_amend_detail_form.ext_prod_id.value;
	var in_formulary_yn = document.prescription_amend_detail_form.in_formulary_yn.value;

	var frameobj;
	if(parent.f_header==null) {
		frameobj	=	parent.parent.f_header;
	}
	else {
		frameobj	=	parent.f_header;
	}
	var drug_db_dosecheck_yn=frameobj.document.prescription_header_form.drug_db_dosecheck_yn.value;
	var bl_install_yn	=frameobj.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	=frameobj.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;

	if(drug_db_dosecheck_yn == 'Y'  &&  ext_prod_id != ''){
		//return;
		extDosageCheck(calling_mode);
	}
	else{

		var qty_value   = document.prescription_amend_detail_form.qty_value.value;
		var drug_code   = document.prescription_amend_detail_form.drug_code.value;
		var prescribed_mode = document.prescription_amend_detail_form.prescribed_mode.value;
		var repeat_value= document.prescription_amend_detail_form.repeat_value.value;   
		var patient_id  = document.prescription_amend_detail_form.patient_id.value; 
		var bl_install_yn	=parent.f_header.document.prescription_header_form.bl_install_yn.value;
		var bl_disp_charge_dtl_in_rx_yn	=parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
		var fldString=" patient_id=\""+ patient_id + "\" ";
		var srl_no			=	document.prescription_amend_detail_form.srl_no.value;
		var freq_nature	=	document.prescription_amend_detail_form.freq_nature.value;
		//Added for IN:070451 start
		var weight =parent.f_header.document.prescription_header_form.weight.value;//Added for IN:071370
		var bsa =parent.f_header.document.prescription_header_form.bsa.value;//Added for IN:071370
		var temp_qty ="";
		if(parent.f_header.document.prescription_header_form.height.value.length > 0 && parent.f_header.document.prescription_header_form.weight.value.length > 0){
			 if(document.prescription_amend_detail_form.calc_by_ind!=undefined){
				 if(document.prescription_amend_detail_form.calc_by_ind.value=="W") {
					temp_qty	=	(parseFloat(qty_value)/parseFloat(parent.f_header.document.prescription_header_form.weight.value));
				}
				else if(document.prescription_amend_detail_form.calc_by_ind.value=="B") {
					temp_qty	=	(parseFloat(qty_value)/parseFloat(parent.f_header.document.prescription_header_form.bsa.value));
					
			   }else
				 temp_qty=qty_value;
			 }else
				 temp_qty=qty_value;
		 }
		 if(temp_qty=="")
			 temp_qty = qty_value;
		 //Added for IN:070451 end


		fldString += " qty_value=\""+ temp_qty + "\" ";//Modified for IN:070451
		fldString += " dosage_type=\""+ prescribed_mode + "\" ";
		fldString += " repeat_value=\""+ repeat_value + "\" ";
		fldString += " drug_code=\""+ drug_code + "\" ";
		fldString += " srl_no=\""+ srl_no + "\" ";
		fldString += " display_alert=\""+ display_alert_flag + "\" ";
		fldString += " freq_nature=\""+ freq_nature + "\" ";
		fldString += " weight=\""+ weight + "\" ";//Added for IN:071370
		fldString += " bsa=\""+ bsa + "\" ";//Added for IN:071370
		var formobj=document.prescription_amend_detail_form;
		var xmlStr=formXMLString(formobj,fldString);
		fieldValidation(xmlStr,"validateDosageLimit");
	}
	if(bl_install_yn=='Y' && bl_disp_charge_dtl_in_rx_yn=='Y')
		getChargeDetails(in_formulary_yn);
}

function fieldValidation(xmlStr,source){
	
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
    xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode="+source,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
    eval(responseText);
    return true;
}

//common for forming XML String
function formXMLString(formobj,fldString){
    var bean_id=formobj.bean_id.value;
    var bean_name=formobj.bean_name.value;
	if(formobj.presBean_id != undefined){
		var presBean_id=formobj.presBean_id.value;
		var presBean_name=formobj.presBean_name.value;
	}
    var mode=formobj.mode.value;
    var xmlStr ="<root><SEARCH ";
    xmlStr += " bean_id=\""+ bean_id + "\" ";
    xmlStr += " bean_name=\""+ bean_name + "\" ";
	if(formobj.presBean_id != undefined){
		xmlStr += " presBean_id=\""+ presBean_id + "\" ";
		xmlStr += " presBean_name=\""+ presBean_name + "\" ";
	}
    xmlStr += " mode=\""+ mode + "\" ";
    xmlStr +=fldString;
    xmlStr +=" /></root>";
    return xmlStr;
}

function enableDosageLimit(display_alert,limit_ind,daily_dose,unit_dose,mono_graph){
   // document.prescription_amend_detail_form.all.dosage_limit.style.display="inline";    
  //  document.prescription_amend_detail_form.all.dosage_limit.style.visibilty="visible";
	document.prescription_amend_detail_form.dosage_limit.style='display'; // Added for ML-MMOH-SCF-2514 [49131]
    document.prescription_amend_detail_form.override_remarks.value="Y";
    document.prescription_amend_detail_form.limit_ind.value=limit_ind;
    document.prescription_amend_detail_form.daily_dose.value=daily_dose;
    document.prescription_amend_detail_form.unit_dose.value=unit_dose;
    document.prescription_amend_detail_form.mono_graph.value=unescape(mono_graph);
	disableoverride(limit_ind);
}

function disableDosageLimit(){
	var current_rx= document.prescription_amend_detail_form.current_rx.value;
	var allergy_yn= document.prescription_amend_detail_form.allergy_yn.value;
	var abuse_exists= document.prescription_amend_detail_form.abuse_exists.value;
	var abuse_action= document.prescription_amend_detail_form.abuse_action.value;
	var interaction_exists= document.prescription_amend_detail_form.interaction_exists.value;
	document.prescription_amend_detail_form.limit_ind.value="Y";
	if(current_rx=="N" && allergy_yn=="N" && interaction_exists!='Y' && (abuse_exists!="Y" && abuse_action !="B")){
		document.getElementById('dosage_limit').style.display="none";
		//document.prescription_amend_detail_form.all.dosage_limit.style.visibilty="hidden";
		document.getElementById('override_remarks').value="N";
		document.prescription_amend_detail_form.daily_dose.value="";
		document.prescription_amend_detail_form.unit_dose.value="";
		document.prescription_amend_detail_form.mono_graph.value="";
	}
}

async function showAmendOverRideRemarks(frmObj,obj) {
	generic_id		=	frmObj.generic_id.value;
	generic_name	=	encodeURIComponent(frmObj.generic_name.value);//Modified for IN:073769
	patient_id      =   frmObj.patient_id.value;
	encounter_id    =   frmObj.encounter_id.value;
	drug_desc       =   encodeURIComponent(frmObj.drug_name.value);//Modified for IN:073769
	daily_dose      =   frmObj.daily_dose.value;
	unit_dose       =   frmObj.unit_dose.value;
	mono_graph      =encodeURIComponent(frmObj.mono_graph.value);//Modified for IN:073769
	limit_ind       =   frmObj.limit_ind.value;
	drug_code       =   frmObj.drug_code.value;
	min_unit_dose	=	frmObj.min_unit_dose.value;
	min_daily_dose	=	frmObj.min_daily_dose.value;
	allergy_yn		=	frmObj.allergy_yn.value;
	current_rx		=	frmObj.current_rx.value;
	srl_no          =   frmObj.srl_no.value;
	dup_reason		=	frmObj.dup_reason.value;
	dsg_reason		=	frmObj.dsg_reason.value;
	alg_reason			=	frmObj.alg_reason.value;
	dosage_unit		=   frmObj.dosage_unit.value;
	dosage_std		=	frmObj.dosage_std.value;
	interaction_exists		=	frmObj.interaction_exists.value;
	//Added for IN:071108 start
	max_daily_ceeling_dose=frmObj.max_daily_ceeling_dose.value;
	min_daily_ceeling_dose=frmObj.min_daily_ceeling_dose.value;
	max_unit_ceeling_dose=frmObj.max_unit_ceeling_dose.value;
	min_unit_ceeling_dose=frmObj.min_unit_ceeling_dose.value;
	
	//Added for IN:071108 end
	//added for AAKH-CRF-0140 start
	abuse_override		=	frmObj.ABUSE_OVERRIDE.value;
	abuse_override_remarks		=	frmObj.abuse_drug_override_reason.value;
	abuse_exists=	frmObj.ABUSE_OVERRIDE.value;
	abuse_action=	frmObj.abuse_action.value;
	//alert(abuse_override+"abuse_exists"+abuse_exists);
	//alert(abuse_override_remarks+"abuse_action"+abuse_action);
	
	//added for aakh-crf-0140 end
	//Added for IN:072715 start
	allergy_remarks_code=frmObj.allergy_remarks_code.value;
	dose_remarks_code=frmObj.dose_remarks_code.value;
	currentrx_remarks_code=frmObj.currentrx_remarks_code.value;
	interaction_remarks_code=frmObj.interaction_remarks_code.value;
	food_interaction_remarks_code=frmObj.food_interaction_remarks_code.value;
	lab_interaction_remarks_code=frmObj.lab_interaction_remarks_code.value;
	//Added for IN:072715 end
	disease_interaction_remarks_code = "";//Added for MMS-DM-CRF-0229

	if(obj!="false"){
		var dialogWidth = "50vw" ;
		var dialogHeight= "30vh" ;
		var dialogTop = "285" ;
		var dialogLeft ="300";
		var center = "0" ;
		var status="no";
		var dialogHeight = "20";

		if(current_rx=="Y" && limit_ind=="N" && allergy_yn=="Y")
			dialogHeight= "35vh" ;
		else if ( (current_rx=="Y" && limit_ind=="N") || (current_rx=="Y" && allergy_yn=="Y") || (limit_ind=="N" && allergy_yn=="Y" ))
			dialogHeight= "38vh" ;
		else
			dialogHeight= "40vh" ;

		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; dialogLeft :"+dialogLeft;
		var arguments   = "" ;
		//modified for aakh-crf-0140
		retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionOverrideReasonFrameset.jsp?gen_id="+generic_id+"&gen_name="+generic_name+"&pat_id="+patient_id+"&enc_id="+encounter_id+"&drug_desc="+drug_desc+"&mono_graph="+mono_graph+"&daily_dose="+daily_dose+"&unit_dose="+unit_dose+"&allergy_yn="+allergy_yn+"&current_rx="+current_rx+"&limit_ind="+limit_ind+"&drug_code="+drug_code+"&srl_no="+srl_no+"&min_unit_dose="+min_unit_dose+"&min_daily_dose="+min_daily_dose+"&dosage_unit="+dosage_unit+"&dosage_std="+dosage_std+"&max_daily_ceeling_dose="+max_daily_ceeling_dose+"&min_daily_ceeling_dose="+min_daily_ceeling_dose+"&max_unit_ceeling_dose="+max_unit_ceeling_dose+"&min_unit_ceeling_dose="+min_unit_ceeling_dose+"&allergy_remarks_code="+allergy_remarks_code+"&dose_remarks_code="+dose_remarks_code+"&currentrx_remarks_code="+currentrx_remarks_code+"&interaction_remarks_code="+interaction_remarks_code+"&food_interaction_remarks_code="+food_interaction_remarks_code+"&lab_interaction_remarks_code="+lab_interaction_remarks_code+"&disease_interaction_remarks_code="+disease_interaction_remarks_code+"&called_from=OverrideReason&interaction_exists="+interaction_exists+"&abuse_override="+abuse_override+"&abuse_override_remarks="+abuse_override_remarks+"&abuse_exists="+abuse_exists+"&abuse_action="+abuse_action,arguments,features);//Modified for  IN:071108, Modified for IN:072715,Modified for IN:073769 disease_interaction_remarks_code added for MMS-DM-CRF-0229
		if(retVal=="OK")
			updateOverrideYN();
	}
	else{
		updateOverrideYN();
	}
}

function storeOverRideReason(frmObj) {	
    interaction_exists  =   frmObj.interaction_exists.value;
    current_rx  =   frmObj.current_rx.value;
    limit_ind   =   frmObj.limit_ind.value;
    allergy_yn  =   frmObj.allergy_yn.value;
    drug_code   =   frmObj.drug_code.value;
    srl_no      =   frmObj.srl_no.value;
    bean_id     =   frmObj.bean_id.value;
    bean_name   =   frmObj.bean_name.value;
    abuse_override= frmObj.abuse_override.value;//added for aakh-crf-0140
    
    
    alg_reason     =   "";
    dsg_reason =   "";
    dup_reason    =   "";

    if(frmObj.alg_reason!=null)
		alg_reason     =   frmObj.alg_reason.value;
    
    if(frmObj.dsg_reason!=null)
		dsg_reason =   frmObj.dsg_reason.value;

    if(frmObj.dup_reason!=null)
		dup_reason    =   frmObj.dup_reason.value;
	if(frmObj.interaction_remarks!=null)
		interaction_remarks	=	encodeURIComponent(frmObj.interaction_remarks.value);
	if(frmObj.abuse_override_remarks!=null)//added for aakh-crf-0140
		abuse_override_remarks=encodeURIComponent(frmObj.abuse_override_remarks.value);
        var xmlStr ="<root><SEARCH ";
        xmlStr+= "current_rx  =\"" + current_rx + "\" " ;
        xmlStr+= "limit_ind =\"" + limit_ind + "\" " ;
        xmlStr+= "allergy_yn  =\"" + allergy_yn + "\" " ;
        xmlStr+= "alg_reason =\"" + alg_reason + "\" " ;
        xmlStr+= "dsg_reason =\"" + dsg_reason + "\" " ;
        xmlStr+= "dup_reason =\"" + dup_reason + "\" " ;
		xmlStr+= "interaction_remarks =\"" + interaction_remarks + "\" " ;
		xmlStr+= "interaction_exists =\"" + interaction_exists + "\" " ;
        xmlStr+= "drug_code =\"" + drug_code + "\" " ;
        xmlStr+= "srl_no =\"" + srl_no + "\" " ;
        xmlStr+= "bean_id =\"" + bean_id + "\" " ;
        xmlStr+= "bean_name=\"" + bean_name + "\" " ;
        xmlStr+= "abuse_override =\"" + abuse_override + "\" " ;//added for aakh-crf-0140
        xmlStr+= "abuse_override_remarks=\"" + abuse_override_remarks + "\" " ;//added for aakh-crf-0140
        xmlStr +=" /></root>";
        var temp_jsp="PrescriptionValidation.jsp?func_mode=override_reason";//Relevent code moved from PrescriptionValidation_1 to PrescriptionValidation
        var xmlDoc = "" ;
        var xmlHttp = new XMLHttpRequest() ;
        xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
        xmlHttp.open("POST",temp_jsp,false);
        xmlHttp.send(xmlDoc);
        responseText=xmlHttp.responseText ;
        parent.window.close();
}

async function callAmendDiagText(diag_text){
	mode="test";
	var dialogHeight= "36vh" ;
	var dialogWidth = "57vw" ;
	var dialogTop = "255" ;
	var dialogLeft = "203" ;
	var center = "1" ;
	var status="no";
	var scroll="yes";
	var features    = "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionAmendDiagTextFrame.jsp?mode="+mode+"&diag_text="+encodeURIComponent(diag_text),arguments,features);
}

function callAmendOrderRemarks(or_mode){
	var patient_id = document.prescription_header_form.patient_id.value;
	var encounter_id= document.prescription_header_form.encounter_id.value;
	var order_id = document.prescription_header_form.order_id.value;
	var mode='remarks';
	
	var dialogHeight= "16" ;
	var dialogWidth = "37" ;
	var dialogTop = "255" ;
	var dialogLeft = "203" ;
	var center = "1" ;
	var status="no";
	var scroll="yes";
	var features    = "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	retVal = window.showModalDialog("../../ePH/jsp/PrescriptionAmendRemarks.jsp?or_mode="+or_mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&mode="+mode+"&order_id="+order_id,arguments,features);
}

function saveAmendRemarks(obj){
	
    var remarks=obj.order_remarks.value;
    var bean_id= obj.bean_id.value;
    var bean_name=obj.bean_name.value;
    var page_mode=obj.page_mode.value;
    var mode=obj.mode.value;
    var srl_no=obj.srl_no.value;
    
    var xmlStr ="<root><SEARCH ";
    xmlStr += " bean_id=\""+ bean_id + "\" ";
    xmlStr += " bean_name=\""+ bean_name + "\" ";
    xmlStr += " page_mode=\""+ page_mode + "\" ";
    xmlStr += " remarks=\""+ remarks + "\" ";
    xmlStr += " srl_no=\""+ srl_no + "\" ";
    xmlStr +=" /></root>";
    parent.window.close();
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=saveRemarks",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
    eval(responseText);
    return true;
}

function updateOverrideYN(){    
	parent.f_detail.document.prescription_amend_detail_form.override_yn.value="Y";
}

function validateAmend(obj){
    var remarks=obj.dsg_reason.value;
    var bean_id= obj.bean_id.value;
    var bean_name=obj.bean_name.value;
    var page_mode="over_dose";
    var mode=obj.mode.value;
    var srl_no=obj.srl_no.value;
    
    var xmlStr ="<root><SEARCH ";
    xmlStr += " bean_id=\""+ bean_id + "\" ";
    xmlStr += " bean_name=\""+ bean_name + "\" ";
    xmlStr += " page_mode=\""+ page_mode + "\" ";
    xmlStr += " remarks=\""+ remarks + "\" ";
    xmlStr += " srl_no=\""+ srl_no + "\" ";
    xmlStr +=" /></root>";
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=saveRemarks",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
    eval(responseText);
}

function callClose(retval) {
    window.returnValue = retval;
    parent.window.close();
}

function deleteDrug(){
	var frmObj			= parent.f_detail.document.prescription_amend_detail_form;
	var bean_id			= frmObj.bean_id.value;
	var bean_name		= frmObj.bean_name.value;
	var drug_code		= frmObj.drug_code.value;
	var srl_no			= frmObj.srl_no.value;	
	var patient_id      = frmObj.patient_id.value;
    var encounter_id    = frmObj.encounter_id.value;
    var patient_class   = frmObj.patient_class.value;
	var mode			= frmObj.mode.value;

	var xmlStr ="<root><SEARCH ";
    xmlStr += " bean_id=\""+ bean_id + "\" ";
    xmlStr += " bean_name=\""+ bean_name + "\" ";
    xmlStr += " drug_code=\""+ drug_code + "\" ";
    xmlStr += " srl_no=\""+ srl_no + "\" ";
    xmlStr +=" /></root>";
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=deleteDrug",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	 var mode			=	"amend";
	//parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class; //commented for  Bru-HIMS-CRF-400 [IN:044502]
	refreshFrames(); //Added for  Bru-HIMS-CRF-400 [IN:044502]
}

function amendDrug(){
	var retval = maxDurnValidation();
	if(retval == false)
		return;

	var sliding_scale_yn = "N";

	if(parent.f_detail.f_sliding_scale_remarks != undefined)
		sliding_scale_yn = "Y";

	if(sliding_scale_yn == "Y"){
		var called_from	=	""//parent.f_header.document.prescription_header_form;
	
	}
	else{
		var called_from	=	parent.f_detail.document.prescription_amend_detail_form.called_from.value;
		var frmObj = parent.f_detail.document.prescription_amend_detail_form;
	}

	if(sliding_scale_yn != "Y" && frmObj.bl_overriden_action_reason_img.style.visibility=="visible"){
		if(frmObj.bl_incl_excl_override_reason_code.value == ""){
			alert(getMessage("INCL_EXCL_OVERRIDE_REASON_CANNOT_BE_BLANK","PH"));
			return false;
		}
	}
	//added while fixing IN26429_reopen --15/02/2011-- priya 
	else if(sliding_scale_yn == "Y"){
		var sld_admin_frmObj =  parent.f_detail.f_sliding_scale_admin_dtls.document.prescription_detail_form;
		if(sld_admin_frmObj.bl_overriden_action_reason_img.style.visibility=="visible" && sld_admin_frmObj.bl_incl_excl_override_reason_code.value == ""){
			alert(getMessage("INCL_EXCL_OVERRIDE_REASON_CANNOT_BE_BLANK","PH"));
			return false;
		}
	}
	if(sliding_scale_yn == "Y"){	
		amendSlidingScaleNormal();
	}
	else{
		if(called_from=="RENEW_ORDER") {		
			amendRenew();
		}
		else{		 
			amendNormal();
		}
	}
}

function amendNormal(){

	var frmObj		=	parent.f_detail.document.prescription_amend_detail_form;
//	var headerFrame	=   parent.parent.f_header;
	
	if(frmObj.man_rem_on_prn_freq_yn != undefined && frmObj.man_rem_on_prn_freq_yn.value == 'Y'){
		if(frmObj.prn_remarks !=null || frmObj.prn_remarks!=undefined ){
			if(frmObj.prn_remarks.style.visibility=="visible" && frmObj.prn_remarks_flag.value == "false" ){
				if(frmObj.prn_yn.value=='Y'){
					alert(getMessage("PRN_REMARKS_CANNOT_BE_BLANK", "PH"));
					return false;
			   }
			}
		}
	}
	if(frmObj.drug_indication_mdry.value=="Y"){//jd-crf-0220 
		if(frmObj.DrugIndicationRemarks.value ==null || frmObj.DrugIndicationRemarks.value ==""){
			alert(getMessage("DRUG_INDICATION_REASON_NOT_BLANK", "PH"));
			return false;
		}
		
	}
	var all_durn_type_app = frmObj.all_durn_type_app.value;//ML-MMOH-CRF-1531



	if(frmObj.DrugRemarksMandatory.value == 'Y' && frmObj.DrugRemarksEntered.value != 'Y'){//Added for Antibiotic Screen using Order Entry Format ICN 29904 - start
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
	    msg = msg.replace('$', getLabel("ePH.DrugRemarks.label","PH"));
		alert(msg);
		frmObj.drug_remarks.click();
		return false;
	}//Added for Antibiotic Screen using Order Entry Format ICN 29904 -end

	var srl_no		=	frmObj.srl_no.value;

	if( eval(parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_img"+srl_no)) != undefined && eval(parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_img"+srl_no)).style.display==""){
	//	alert(getMessage("OVERRIDE_REASON_NOT_BLANK", "PH"));
		extDosageCheck('onConfirm')
	//	return false;
	}
	/*if((frmObj.dsg_reason_yn.value == 'N' && frmObj.dsg_reason.value=='') || ){
		alert(getMessage("OVERRIDE_REASON_NOT_BLANK", "PH"));
		extDosageCheck('onConfirm')
		return false;
	}*/

	var patient_id			=	frmObj.patient_id.value;
    var bean_id				=	frmObj.bean_id.value;
    var mode				=	frmObj.mode.value;
    var bean_name			=	frmObj.bean_name.value;
    var durn_value			=	frmObj.durn_value.value;
    var qty_value			=	frmObj.qty_value.value;
    var start_date			=	frmObj.start_date.value;
    var end_date			=	frmObj.end_date.value;
    var limit_ind			=	frmObj.limit_ind.value;//Added for IN:070451
    var drug_code			=	frmObj.drug_code.value;
	var drug_desc			=	frmObj.drug_name.value;
	var absol_qty			=   frmObj.absol_qty.value;
	var dosage_type			=   frmObj.dosage.value;
	var consider_stock_for_pres_yn	=  frmObj.consider_stock_for_pres_yn.value;
	var allow_pres_without_stock_yn	=  frmObj.allow_pres_without_stock_yn.value;
	var qty_desc			=	frmObj.qty_desc.options[frmObj.qty_desc.selectedIndex].text;
	var qty_desc_code		=	frmObj.qty_desc.options[frmObj.qty_desc.selectedIndex].value;
	var freq_desc			=	encodeURIComponent(frmObj.freq_desc.options[frmObj.freq_desc.selectedIndex].text);
	var freq_code			=   frmObj.freq_desc.value;
	var durn_desc			=   frmObj.durn_desc.options[frmObj.durn_desc.selectedIndex].text;
	var durn_type			=   frmObj.durn_desc.value;
	var pres_base_uom		=   frmObj.pres_base_uom.value;
	var repeat_value		=   frmObj.repeat_value.value;
	var interval_value		=   frmObj.interval_value.value;
	var freq_nature			=	frmObj.freq_nature.value;
	var disp_locn_code		=	frmObj.disp_locn_code.value;
	var split_dose_yn		=	frmObj.split_dose_yn.value;
	var strength_value		=	frmObj.init_qty.value;//Added for IN:070451
	var override_remarks	=	frmObj.override_remarks.value;
	var trade_code			=	frmObj.trade_code.value;
	var freq_durn_type		=	frmObj.freq_durn_type.value;
	var tmp_durn_value		=	frmObj.tmp_durn_value.value;
	var buildMAR_yn		=	frmObj.buildMAR_yn.value; //added for SRR20056-SCF-7882 -29157
	var DrugRemarksEntered		=	frmObj.DrugRemarksEntered.value; //Added for Antibiotic Screen using Order Entry Format ICN 29904
	var DrugIndicationRemarks		=	frmObj.DrugIndicationRemarks.value;
	var preg_remarks		=	frmObj.preg_remarks.value;
	var validate_overide_on_confirm_yn=frmObj.validate_overide_on_confirm_yn.value;//Added for IN:069887 

		if(freq_durn_type=="H"){
			if(durn_type=="M"){
			  alert("Duration type can be Hour/Day/Week/Month/Year ");
			  return false;
			}
		}else if(freq_durn_type=="D"){
			if(durn_type=="M" || durn_type=="H"){
			  alert("Duration type can be Day/Week/Month/Year ");
			  return false;
			}
		
		}else if(freq_durn_type=="W"){
			if(durn_type=="M" || durn_type=="H" || durn_type=="D"){
				 alert("Duration type can be Week/Month/Year ");
			  return false;	
			}
		}else if(freq_durn_type=="L"){
			if(durn_type=="M" || durn_type=="H" || durn_type=="D" || durn_type=="W"){
				 alert("Duration type can be Month/Year ");
			  return false;	
			}
		
		}else if(freq_durn_type=="Y"){
			if(durn_type=="M" || durn_type=="H" || durn_type=="D" || durn_type=="W" || durn_type=="L"){
				 alert("Duration type can be Year ");
			  return false;	
			}
		} 	 
//	}//commented for IN:069887 
//added for ML-MMOH-CRF-1531 - end
//commented by Naveen
	/*var bl_override_excl_incl_ind ="";
	if(frmObj.bl_override_excl_incl_ind.checked==true)
		bl_override_excl_incl_ind	=	"Y";
	else
		bl_override_excl_incl_ind = "N";
	*/

	var bl_def_override_excl_incl_ind	=	frmObj.bl_def_override_excl_incl_ind.value;
	var bl_incl_excl_override_reason_code	=	frmObj.bl_incl_excl_override_reason_code.value;
	var bl_incl_excl_override_reason_desc	=	frmObj.bl_incl_excl_override_reason_desc.value;
	//var route_code	=	frmObj.route_code.value;
	var route_code	=	frmObj.route.options[frmObj.route.selectedIndex].value;
	var route_desc	=	frmObj.route.options[frmObj.route.selectedIndex].text;
	var drug_db_dose_check_yn =   parent.f_header.document.prescription_header_form.drug_db_dosecheck_yn.value;
	var drug_db_interface_yn =   parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var drug_db_duptherapy_yn =   parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
	var ext_prod_id = frmObj.ext_prod_id.value;

	var xmlStr ="<root><SEARCH "; 
    xmlStr += " bean_id=\""+ bean_id + "\" ";
    xmlStr += " bean_name=\""+ bean_name + "\" ";
    xmlStr += " mode=\""+ mode + "\" ";
    xmlStr += " srl_no=\""+ srl_no + "\" ";
    xmlStr += " durn_value=\""+ durn_value + "\" ";
    xmlStr += " qty_value=\""+ qty_value + "\" ";
	xmlStr += " qty_desc=\""+ qty_desc + "\" ";		
	xmlStr += " qty_desc_code=\""+ qty_desc_code + "\" ";		
	xmlStr += " freq_code=\""+ freq_code + "\" ";
	xmlStr += " freq_desc=\""+ freq_desc + "\" ";
	xmlStr += " freq_nature=\""+ freq_nature + "\" ";	
    xmlStr += " start_date=\""+ start_date + "\" ";
    xmlStr += " end_date=\""+ end_date + "\" ";
    xmlStr += " drug_code=\""+ drug_code + "\" ";
	xmlStr += " absol_qty=\""+ absol_qty + "\" ";
    xmlStr += " dosage=\""+ dosage_type + "\" ";
	xmlStr += " durn_desc=\""+ durn_desc + "\" ";	
	xmlStr += " durn_type=\""+ durn_type + "\" ";	
	xmlStr += " split_dose_yn=\""+ split_dose_yn + "\" ";	
	xmlStr += " pres_base_uom=\""+ pres_base_uom + "\" ";	
	xmlStr += "consider_stock_for_pres_yn	=\""+ consider_stock_for_pres_yn + "\" ";
	xmlStr += "allow_pres_without_stock_yn	=\""+ allow_pres_without_stock_yn + "\" ";
	xmlStr += "repeat_value	=\""+ repeat_value + "\" ";
	xmlStr += "interval_value	=\""+ interval_value + "\" ";
	xmlStr += "disp_locn_code	=\""+ disp_locn_code + "\" ";
	xmlStr += "patient_id	=\""+ patient_id + "\" ";
	xmlStr += "strength_value	=\""+ strength_value + "\" ";
	xmlStr += "override_remarks	=\""+ override_remarks + "\" ";
	xmlStr += "bl_override_excl_incl_ind	=\""+ frmObj.bl_override_excl_incl_ind.value + "\" ";
	xmlStr += "bl_def_override_excl_incl_ind	=\""+ bl_def_override_excl_incl_ind + "\" ";
	xmlStr += "bl_incl_excl_override_reason_code	=\""+ bl_incl_excl_override_reason_code + "\" ";
	xmlStr += "bl_incl_excl_override_reason_desc	=\""+ encodeURIComponent(bl_incl_excl_override_reason_desc) + "\" ";
	xmlStr += "route_code	=\""+ route_code + "\" ";
	xmlStr += "route_desc	=\""+ route_desc + "\" ";
	xmlStr += "freq_durn_type	=\""+ freq_durn_type + "\" ";
	xmlStr += "tmp_durn_value	=\""+ tmp_durn_value + "\" ";
	xmlStr += "buildMAR_yn	=\""+ buildMAR_yn + "\" "; //added for SRR20056-SCF-7882 -29157
	xmlStr += "DrugRemarksEntered	=\""+ DrugRemarksEntered + "\" "; //Added for Antibiotic Screen using Order Entry Format ICN 29904
	xmlStr += "DrugIndicationRemarks	=\""+ DrugIndicationRemarks + "\" "; //Added for Antibiotic Screen using Order Entry Format ICN 29904
	xmlStr += "drug_db_dose_check_yn	=\""+ drug_db_dose_check_yn + "\" "; //Added for Antibiotic Screen using Order Entry Format ICN 29904
	xmlStr += "ext_prod_id	=\""+ ext_prod_id + "\" "; //Added for Antibiotic Screen using Order Entry Format ICN 29904
	xmlStr += "preg_remarks	=\""+ preg_remarks + "\" ";
	xmlStr += " drug_db_interface_yn=\""+ drug_db_interface_yn + "\" ";//Added for ML-BRU-SCF-1431 [IN:051136] 
	xmlStr += " drug_db_duptherapy_yn=\""+ drug_db_duptherapy_yn + "\" "; //Added for ML-BRU-SCF-1431 [IN:051136] 
	xmlStr += "limit_ind	=\""+ limit_ind + "\" ";//Added for IN:070451
	xmlStr += "validate_overide_on_confirm_yn	=\""+ validate_overide_on_confirm_yn + "\" ";//Added for IN:069887 
	xmlStr +=" /></root>"; 

    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=normal_amend",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
    eval(responseText);	
    return true; 
}

function amendSlidingScaleNormal(){

	var formObj = parent.f_prescription.f_prescription_form.prescription_form;
	var detailFormObj = parent.f_detail.f_sliding_scale_dtls.prescription_detail_form;
	var adminFormObj = parent.f_detail.f_sliding_scale_admin_dtls.prescription_detail_form;	
		//code added for PRN Remarks...
	var remarksFormObj = parent.f_detail.f_sliding_scale_remarks.f_sliding_scale_hdr.prescription_sliding_scale_remarks;
	var remarksDtlFormObj = parent.f_detail.f_sliding_scale_remarks.f_sliding_scale_dtls.prescription_sliding_scale_remarks_Dtl;

	var frmObj			= parent.f_detail.frames[0].document.prescription_detail_form;
		patient_id=formObj.patient_id.value; // changed frmObj to formObj for IN21609 --07/06/2010 -- priya
		encounter_id=formObj.encounter_id.value; // changed frmObj to formObj for IN21609 --07/06/2010 -- priya
		drug_code=frmObj.drug_code.value;
		srl_no=frmObj.srl_no.value; 

	if(override_remarks=frmObj.override_remarks.checked==true)
		frmObj.override_remarks.value='Y'; 
	else
		frmObj.override_remarks.value='N'; 
  
	override_remarks=frmObj.override_remarks.value; 
	checkEnabled=frmObj.checkEnabled.value; 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	if(adminFormObj.prn_remarks !=null || adminFormObj.prn_remarks!=undefined ){
		if(adminFormObj.prn_remarks.style.visibility=="visible" && adminFormObj.prn_remarks_flag.value == "false" ){
			if(adminFormObj.prn_yn.value=='Y'){
				alert(getMessage("PRN_REMARKS_CANNOT_BE_BLANK", "PH"));
				return false;
		   }
		}
	}
//Added for Antibiotic Screen using Order Entry Format ICN 29904 -start
		var drugRemarksMandatory = detailFormObj.DrugRemarksMandatory.value;
		var drugRemarksEntered		 = detailFormObj.DrugRemarksEntered.value;
		if(drugRemarksMandatory == 'Y' && drugRemarksEntered != 'Y'){
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("ePH.DrugRemarks.label","PH"));
			alert(msg);
			detailFormObj.drug_remarks.click();
			return false;
		}
//Added for Antibiotic Screen using Order Entry Format ICN 29904 -end
		var template_id = remarksDtlFormObj.template_id.value;
		var tmplDtlString= "";		
		var noOfTemplates= remarksDtlFormObj.noOfTemplates.value;	
		var range_to = "";
		var range_from = "";
		var admin_unit = "";
		var rem = "";
		for (var i=0; i<noOfTemplates; i++)
		{
			range_to = (eval("remarksDtlFormObj.range_to"+i).value);
			if(range_to == "" || range_to == " ")
				range_to = "0";
			range_from = (eval("remarksDtlFormObj.range_from"+i).value);
			if(range_from == "" || range_from == " ")
				range_from = "0";
			admin_unit = (eval("remarksDtlFormObj.admin_units"+i).value);
			if(admin_unit == "" || admin_unit == " ")
				admin_unit = "0";
			if((eval("remarksDtlFormObj.remarks"+i).value)=="")
				rem = " ";
			else
				rem = encodeURIComponent((eval("remarksDtlFormObj.remarks"+i).value),"UTF-8");
			tmplDtlString += (eval("remarksDtlFormObj.srl_no"+i).value)+"~"+range_from+"~"+range_to+"~"+admin_unit+"~"+rem+"~";
		}

		var range_uom = "";
		var admin_uom = "";
		if(noOfTemplates >0){
			range_uom = remarksDtlFormObj.range_uom0.value;
			admin_uom = remarksDtlFormObj.admin_uom0.value;
		}
/*=============================================================================================================*/
	//added while fixing IN26429_reopen --15/02/2011-- priya
	var bl_override_excl_incl_ind	=	adminFormObj.bl_override_excl_incl_ind.value;
	var bl_def_override_excl_incl_ind	=	adminFormObj.bl_def_override_excl_incl_ind.value;
	var bl_incl_excl_override_reason_code	=	adminFormObj.bl_incl_excl_override_reason_code.value;
	var bl_incl_excl_override_reason_desc	=	adminFormObj.bl_incl_excl_override_reason_desc.value;
/*=============================================================================================================*/
		
		var freq_desc = "";
		var pract_name=	unescape(parent.f_header.document.prescription_header_form.pract_name.value);
		parent.f_header.document.prescription_header_form.pract_name.value
		if(adminFormObj.frequency.options.length !=0)
			freq_desc= encodeURIComponent(adminFormObj.frequency.options[adminFormObj.frequency.selectedIndex].text,"UTF-8");
		xmlStr	="<root><SEARCH " ;
		xmlStr += "patient_id=\""+ formObj.patient_id.value   +"\" " ;
		xmlStr += "encounter_id=\""+ formObj.encounter_id.value +"\" " ;		
		xmlStr += "freq_nature=\""+ adminFormObj.freq_nature.value +"\" " ;
		xmlStr += "qty_value=\""+ adminFormObj.qty_value.value +"\" " ;
		xmlStr += "repeat_value=\""+ adminFormObj.repeat_value.value +"\" " ;
		xmlStr += "absol_qty=\""+ adminFormObj.absol_qty.value +"\" " ;
		xmlStr += "qty_unit=\""+ adminFormObj.qty_unit.value +"\" " ;
		xmlStr += "frequency=\""+ adminFormObj.frequency.value +"\" " ;
		xmlStr += "freq_desc=\""+ freq_desc +"\" " ;
		xmlStr += "durn_value=\""+ adminFormObj.durn_value.value +"\" " ;
		xmlStr += "durn_unit=\""+ adminFormObj.durn_unit.value +"\" " ;
		xmlStr += "interval_value=\""+ adminFormObj.interval_value.value +"\" " ;
		xmlStr += "start_date=\""+ adminFormObj.start_date.value +"\" " ;
		xmlStr += "end_date=\""+ adminFormObj.end_date.value +"\" " ;
		xmlStr += "drug_code=\""+ drug_code +"\" " ;		
		xmlStr += "srl_no=\""+ adminFormObj.srl_no.value +"\" " ;		
		xmlStr += "override_remarks=\""+ override_remarks +"\" " ;		
		xmlStr += "checkEnabled=\""+ checkEnabled +"\" " ;		
		xmlStr += "pract_name=\""+ encodeURIComponent(pract_name) + "\" ";
		xmlStr += "template_id=\""+ template_id + "\" ";
		xmlStr += "rangeUom=\""+ range_uom + "\" ";
		xmlStr += "adminUom=\""+ admin_uom + "\" ";
		xmlStr += "tmplDtlString=\""+ tmplDtlString + "\" ";
		xmlStr += "bean_id=\"@PrescriptionBean_1"+patient_id+encounter_id+"\" ";
		xmlStr += "bean_name=\"ePH.PrescriptionBean_1\" " ;
		xmlStr += "repeat_durn_type=\""+ adminFormObj.tmp_durn_desc.value   +"\" " ; //// added for IN21609 --07/06/2010 -- priya
/*===============================================================================================================*/
		//added while fixing IN26429_reopen --15/02/2011-- priya
		xmlStr += "bl_override_excl_incl_ind=\""+ bl_override_excl_incl_ind + "\" ";
		xmlStr += "bl_def_override_excl_incl_ind=\""+ bl_def_override_excl_incl_ind + "\" ";
		xmlStr += "bl_incl_excl_override_reason_code=\""+ bl_incl_excl_override_reason_code + "\" ";
		xmlStr += "bl_incl_excl_override_reason_desc=\""+ bl_incl_excl_override_reason_desc + "\" ";
/*===============================================================================================================*/

		var remarks			= "";
		var remarks_codes	="";
		for (var i=1;i<remarksFormObj.no_of_remarks.value ;i++ ){
			if(eval("remarksFormObj.chk_select_"+i).checked){
				remarks			+= (eval("remarksFormObj.txt_remarks_"+i).value+" .. ");
				remarks_codes   += (eval("remarksFormObj.txt_remarks_code_"+i).value)+"||";
			}
		}
		for (var i=0;i<remarksDtlFormObj.noOfTemplates.value ;i++ ){ //code added for IN047654 --Start	 	
			remarks   += (eval("remarksDtlFormObj.remarks"+i).value)+" .. ";			
		}//code added for IN047654 --End  
		
	//	alert(remarks);
		xmlStr += "remarks=\""+ remarks +"\" " ;
		xmlStr += "remarks_codes=\""+ remarks_codes +"\" " ;
		xmlStr += "sliding_scale_yn=\""+ adminFormObj.sliding_scale_yn.value +"\" " ;
		xmlStr += "buildMAR_yn=\""+ detailFormObj.buildMAR_yn.value +"\" " ; //added for SRR20056-SCF-7882 -29157
		xmlStr += "DrugRemarksEntered=\""+ detailFormObj.DrugRemarksEntered.value +"\" " ; //Added for Antibiotic Screen using Order Entry Format ICN 29904
		xmlStr += "DrugIndicationRemarks=\""+ detailFormObj.DrugIndicationRemarks.value +"\" " ; //Added for Antibiotic Screen using Order Entry Format ICN 29904
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PrescriptionValidation_2.jsp?func_mode=confirmSlidingScale", false ) ;
		xmlHttp.send( xmlDoc ) ;	
		eval(xmlHttp.responseText);	
}	

function alertNoAvailStock(){
	alert(getMessage("PH_NO_STOCK_AVAIL_DRUG", "PH"));
	return_val=false;
}

function amendRenew(){
	var frmObj		=	parent.f_detail.document.prescription_amend_detail_form;
	var srl_no		=	frmObj.srl_no.value;
    var bean_id		=	frmObj.bean_id.value;
    var mode		=	frmObj.mode.value;
    var bean_name	=	frmObj.bean_name.value;
    var durn_value	=	frmObj.durn_value.value;
    var durn_desc	=	frmObj.durn_desc.value;//Added for ML-BRU-SCF-1843 on 22/06/2018
	
    var qty_value	=	frmObj.qty_value.value;
    var start_date	=	frmObj.start_date.value;
    var end_date	=	frmObj.end_date.value;
    var drug_code	=	frmObj.drug_code.value;
	var drug_desc	=	frmObj.drug_name.value;
	var dup_reason	=  frmObj.dup_reason.value;
	var absol_qty	=  frmObj.absol_qty.value;
	var dosage_type	=   frmObj.dosage_type.value;
	var patient_id	=   frmObj.patient_id.value;
	var consider_stock_for_pres_yn	=  frmObj.consider_stock_for_pres_yn.value;
	var allow_pres_without_stock_yn	=  frmObj.allow_pres_without_stock_yn.value;
	var bl_override_excl_incl_ind	=	frmObj.bl_override_excl_incl_ind.value;
	var bl_def_override_excl_incl_ind	=	frmObj.bl_def_override_excl_incl_ind.value;
	var bl_incl_excl_override_reason_code	=	frmObj.bl_incl_excl_override_reason_code.value;
	var bl_incl_excl_override_reason_desc	=	frmObj.bl_incl_excl_override_reason_desc.value;
	var buildMAR_yn		=	frmObj.buildMAR_yn.value; //added for SRR20056-SCF-7882 -29157
    var allow_amend	=	"Y";   
	if( dup_reason!="" ) {
		alert(getMessage("FUTURE_PRESCRIPTION_CONTAIN","PH")+" - "+drug_desc+" "+getMessage("FUTURE_PRESCRIPTION_CONTAIN_1","PH"));
		deleteDrug();
		return;
	} 

	if(parent.f_detail.document.prescription_amend_detail_form.dosage_limit.style.display!='none'){
        if(parent.f_detail.document.prescription_amend_detail_form.override_yn.value=="N"){
            allow_amend="N";        
        }
		else{
            allow_amend="Y";
        }
    }
	else{
	    allow_amend="Y";
    }
    
    if(allow_amend=="Y"){
		if(frmObj.man_rem_on_prn_freq_yn != undefined && frmObj.man_rem_on_prn_freq_yn.value == 'Y'){
			if(frmObj.prn_remarks !=null || frmObj.prn_remarks!=undefined ){
				if(frmObj.prn_remarks.style.visibility=="visible" && frmObj.prn_remarks_flag.value == "false" ){
					if(frmObj.prn_yn.value=='Y'){
						alert(getMessage("PRN_REMARKS_CANNOT_BE_BLANK", "PH"));
						return false;
				   }
				}
			}
		}
		if(qty_value!="" && durn_value!="" ){
			var xmlStr ="<root><SEARCH ";
			xmlStr += " bean_id=\""+ bean_id + "\" ";
			xmlStr += " bean_name=\""+ bean_name + "\" ";
			xmlStr += " mode=\""+ mode + "\" ";
			xmlStr += " srl_no=\""+ srl_no + "\" ";
			xmlStr += " durn_value=\""+ durn_value + "\" ";
			xmlStr += " durn_desc=\""+ durn_desc + "\" ";//Added for ML-BRU-SCF-1843 on 22/06/2018
			xmlStr += " qty_value=\""+ qty_value + "\" ";
			xmlStr += " start_date=\""+ start_date + "\" ";
			xmlStr += " end_date=\""+ end_date + "\" ";
			xmlStr += " drug_code=\""+ drug_code + "\" ";
			xmlStr += " absol_qty=\""+ absol_qty + "\" ";
			xmlStr += " dosage=\""+ dosage_type + "\" ";
			xmlStr += " patient_id=\""+ patient_id + "\" ";
			xmlStr += "consider_stock_for_pres_yn	=\""+ consider_stock_for_pres_yn + "\" ";
			xmlStr += "allow_pres_without_stock_yn	=\""+ allow_pres_without_stock_yn + "\" ";	
			xmlStr += "bl_override_excl_incl_ind	=\""+ bl_override_excl_incl_ind + "\" ";
			xmlStr += "bl_def_override_excl_incl_ind	=\""+ bl_def_override_excl_incl_ind + "\" ";
			xmlStr += "bl_incl_excl_override_reason_code	=\""+ bl_incl_excl_override_reason_code + "\" ";
			xmlStr += "bl_incl_excl_override_reason_desc	=\""+ encodeURIComponent(bl_incl_excl_override_reason_desc) + "\" ";
			xmlStr += "buildMAR_yn	=\""+ buildMAR_yn + "\" "; //added for SRR20056-SCF-7882 -29157
			xmlStr +=" /></root>";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=amendValues",false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			eval(responseText);
			return true;
		}
		else{
			alert(getMessage("PH_MANDATORY", "PH"));
			return false;
		}
    }
	else{
        alert(getMessage("OVERRIDE_REASON_NOT_BLANK", "PH"));
        return false;
    }
}

function refreshFrames(){
    var mode="amend";
    var drug_code="";
    var srl_no="";
	if(parent.f_detail.document.prescription_amend_detail_form == undefined){
		var patient_id      =parent.f_prescription.f_prescription_form.prescription_form.patient_id.value;
		var encounter_id    =parent.f_prescription.f_prescription_form.prescription_form.encounter_id.value;
		var patient_class   =parent.f_prescription.f_prescription_form.prescription_form.patient_class.value;
	}
	else{
		var patient_id      =parent.f_detail.document.prescription_amend_detail_form.patient_id.value;
		var encounter_id    =parent.f_detail.document.prescription_amend_detail_form.encounter_id.value;
		var patient_class   =parent.f_detail.document.prescription_amend_detail_form.patient_class.value;
		drug_code =parent.f_detail.document.prescription_amend_detail_form.drug_code.value;
		srl_no = parent.f_detail.document.prescription_amend_detail_form.srl_no.value;
	}
	var drug_db_interface_yn       =  parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var drug_db_dose_check_yn =   parent.f_header.document.prescription_header_form.drug_db_dosecheck_yn.value;
	var drug_db_duptherapy_check_yn       =   parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
	var drug_db_interact_check_yn  =   parent.f_header.document.prescription_header_form.drug_db_interact_check_yn.value;
	var drug_db_contraind_check_yn =   parent.f_header.document.prescription_header_form.drug_db_contraind_check_yn.value;
	var drug_db_allergy_check_yn    =   parent.f_header.document.prescription_header_form.drug_db_allergy_check_yn.value;
	var bl_install_yn    =   parent.f_header.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn    =   parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var trade_display_yn    =   parent.f_header.document.prescription_header_form.trade_display_yn.value;
	var adr_count						= parent.f_header.document.prescription_header_form.adr_count.value;
	var MAR_app_yn					= getMAR_app_yn_1(parent.f_header.document.prescription_header_form);
	var order_date_time="";
	parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&conf_drug_code="+drug_code+"&conf_srl_no="+srl_no;
	parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_2.jsp?srl_no="+srl_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode=blank&start_date="+order_date_time+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&trade_display_yn="+trade_display_yn;
	parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_2.jsp?patient_id="+patient_id+"&mode=blank&encounter_id="+encounter_id+"&patient_class="+patient_class+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn;	
}

function refreshSlidingScaleFrame(){
	
	var formObj						=   parent.f_prescription.f_prescription_form.prescription_form;
	patient_id						=	formObj.patient_id.value;
	encounter_id					=	formObj.encounter_id.value;
	
	bed_num							=	"";
	room_num						=	"";
	weight							=	parent.f_header.document.prescription_header_form.weight.value;
	bsa								=	parent.f_header.document.prescription_header_form.bsa.value;
	drug_db_interface_yn			=   parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var bl_install_yn				=   parent.f_header.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn =   parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var MAR_app_yn					=   getMAR_app_yn_1(parent.f_header.document.prescription_header_form);
	var adr_count					=   parent.f_header.document.prescription_header_form.adr_count.value;
	var patient_class				=   parent.f_header.document.prescription_header_form.patient_class.value;
	var act_patient_class			=   parent.f_header.document.prescription_header_form.actual_patient_class.value;
	var take_home_medication		=   parent.f_header.document.prescription_header_form.take_home_medication.value;
	var order_date_time				=   parent.f_header.document.prescription_header_form.sys_date.value;
	var pract_id				=   parent.f_header.document.prescription_header_form.pract_id.value;//ML-MMOH-CRF-01823
	var order_set_code				=   "";

	var mode;
	parent.f_prescription.f_prescription_form.location.href="../../ePH/jsp/PrescriptionForm_2.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&weight="+weight+"&bsa="+bsa+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&adr_count="+adr_count+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&order_set_code="+order_set_code+"&sliding_scale_yn=Y";
	var mode="blank";
	parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_1.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&start_date="+order_date_time+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&MAR_app_yn="+MAR_app_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&pract_id="+pract_id+"&sliding_scale_yn=Y";
	parent.f_button.location.href="../../ePH/jsp/PrescriptionButton_2.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bed_num="+bed_num+"&room_num="+room_num+"&drug_db_interface_yn="+drug_db_interface_yn+"&act_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&sliding_scale_yn=Y";

	/*parent.parent.f_detail.location.href="../../ePH/jsp/PrescriptionSlidingScaleFrame.jsp?srl_no="+srl_no+"&drug_code="+drug_code+"&priority="+priority+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&drug_db_interface_yn="+drug_db_interface_yn+"&drug_db_dose_check_yn="+drug_db_dose_check_yn+"&drug_db_duptherapy_check_yn="+drug_db_duptherapy_check_yn+"&drug_db_interact_check_yn="+drug_db_interact_check_yn+"&drug_db_contraind_check_yn="+drug_db_contraind_check_yn+"&drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&patient_class="+patient_class+"&called_from_amend=Y";*/

}
var pres_vals   =   new Array();
var i           =   0;
var formatId    =   "";
var drug_code   =   "";

function prescriptionValuesAmend(vals)  {
    pres_vals[i++] = vals;
}

function getFormatIdAmend(frm){
	
	var called_frm      =   "";
	var formobj         = document.prescription_amend_detail_form;
	var order_type      = document.prescription_amend_detail_form.order_type_code.value;
	var form_code       = document.getElementById('form_code').value;
	var route_code      = document.prescription_amend_detail_form.route_code.value;
	var drug_code       = document.prescription_amend_detail_form.drug_code.value;
	var srl_no			= document.prescription_amend_detail_form.srl_no.value;
	var patient_id      = document.prescription_amend_detail_form.patient_id.value;
	var encounter_id    = document.prescription_amend_detail_form.encounter_id.value;
//  document.prescription_amend_detail_form.route_code.disabled=true;

	if(frm!=undefined || frm!=null)
		called_frm=frm;
	code	=	drug_code+srl_no;

	var fldString=" drug_code=\""+ code + "\" ";
		fldString +=" order_type=\""+ order_type + "\" ";
		fldString +=" form_code=\""+ form_code + "\" ";
		fldString +=" route_code=\""+ route_code + "\" ";
		fldString +=" patient_id=\""+ patient_id + "\" ";
		fldString +=" encounter_id=\""+ encounter_id + "\" ";
		fldString +=" called_frm=\""+ called_frm + "\" ";
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"getFormatId");
}

function validateRemarksAmend(format_id)    {
	
    var format  =   format_id.split("~");
    var mandatory   =   format[0];
    formatId   =   format[1];
	//Added for Antibiotic Screen using Order Entry Format ICN 29904 - start
	if(mandatory == undefined || mandatory== null || mandatory=='null' || mandatory=='')
		mandatory="N";
	document.getElementById('DrugRemarksMandImg').style.display = 'none';
	document.getElementById('DrugRemarksMandatory').value =mandatory;
	//Added for Antibiotic Screen using Order Entry Format ICN 29904 -end
     drug_code  =   document.prescription_amend_detail_form.drug_code.value;
	//added for SKR-SCF-0140 -start
	if(format == null || format=='' || formatId==null || formatId=='')
		document.getElementById('drug_remarks').style.display = 'none';
	else{
		document.getElementById('drug_remarks').style='display';
		if(mandatory == 'Y'){ //if block Added for Antibiotic Screen using Order Entry Format ICN 29904
			document.getElementById('DrugRemarksMandImg').style='display';
		}
	}
	//added for SKR-SCF-0140 -end
}

function callOrderAmend()   {
    var vals="";
    for(i=0; i<pres_vals.length; i++)   {
        if(i==pres_vals.length) 
		  vals    += pres_vals[i];
        else
		  vals    += pres_vals[i]+ "::";
    }
	var drug_code       = document.prescription_amend_detail_form.drug_code.value;
	var srl_no			= document.prescription_amend_detail_form.srl_no.value;
	var taper_yn		= document.prescription_amend_detail_form.taper_yn.value;
	code	=	drug_code+srl_no;
    callAmendRemarks(formatId,drug_code,code,'PH','0','PH');
}

async function callAmendRemarks(format_id,catalog_code,catalog_codeSRLNO,order_category,row_value,called_from)    {
	
    patient_id			=	document.prescription_amend_detail_form.patient_id.value;
    encounter_id		=	document.prescription_amend_detail_form.encounter_id.value;
    srl_no				=	document.prescription_amend_detail_form.srl_no.value;
	form_code			=document.prescription_amend_detail_form.form_code.value;
	route_code			=document.prescription_amend_detail_form.route_code.value; 
	var patient_class       = parent.f_detail.document.prescription_amend_detail_form.patient_class.value; //Added for the ICN:34834_1
	DrugRemarksEntered	=document.prescription_amend_detail_form.DrugRemarksEntered.value; //Added for Antibiotic Screen using Order Entry Format ICN 29904
	//var pres_remarks	=	document.prescription_amend_detail_form.pres_remarks.value;
    order_id        =	parent.f_header.document.prescription_header_form.order_id.value;
    //order_line_no	=	srl_no; //Commented for for ICN:34834
	//Added for the ICN:34834_1-Start
	if(patient_class=="OP"){
		order_line_no	=	document.prescription_amend_detail_form.order_line_num.value;
	}
	else{
		 order_line_no=srl_no;
	 }//Added for the ICN:34834_1-End
    bean_id     = "@orderentrybean"+patient_id+encounter_id;
    bean_name   = "eOR.OrderEntryBean";
    srl_no      = "0";
    var dialogHeight= "50vh" ;
    var dialogWidth = "50vw" ;
    var dialogTop = "10" ;
    var center = "1" ;
    var status="no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
    var arguments   = "" ;
	//if(pres_remarks!="")
	//format_id="";
	retVal = await window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormatFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&order_line_num="+order_line_no+"&format_id="+format_id+"&p_catalog_code="+catalog_code+"&catalog_code="+catalog_codeSRLNO+"&order_category="+order_category+"&row_value=0&called_from=PH"+"&p_form_code="+form_code+"&p_route_code="+route_code,arguments,features);
	if(retVal!=undefined ){
		var retVals = retVal.split('~');
		//if(retVal!=undefined && retVal=='Y' && DrugRemarksEntered!='Y') //if block Added for Antibiotic Screen using Order Entry Format ICN 29904
		if(retVals[0]=='Y' && DrugRemarksEntered!='Y') //if block added for [IN:039576]
			document.prescription_amend_detail_form.DrugRemarksEntered.value = 'Y'
	}
}

function resetAmendDetails(){
    var start_date= parent.f_detail.document.prescription_amend_detail_form.start_date.value;
    var patient_id= parent.f_detail.document.prescription_amend_detail_form.patient_id.value;
    var encounter_id= parent.f_detail.document.prescription_amend_detail_form.encounter_id.value;
    var srl_no= parent.f_detail.document.prescription_amend_detail_form.srl_no.value;
    var mode='amend';
	var bl_install_yn				=	parent.f_header.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	=	parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var trade_display_yn	=	parent.f_header.document.prescription_header_form.trade_display_yn.value;
	parent.f_detail.location.href="../../ePH/jsp/PrescriptionDetail_2.jsp?srl_no="+srl_no+"&drug_code="+drug_code+"&start_date="+start_date+"&mode="+mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&trade_display_yn="+trade_display_yn;
}

function maxDurnValidation(durationChange){//durationChange added for ML-BRU-SCF-2069
	if( parent.f_detail.document.prescription_amend_detail_form!=null){
		var drug_code       = parent.f_detail.document.prescription_amend_detail_form.drug_code.value;
		var patient_class       = parent.f_detail.document.prescription_amend_detail_form.patient_class.value;
		var duration_value		= Math.abs(parent.f_detail.document.prescription_amend_detail_form.durn_value.value);
		parent.f_detail.document.prescription_amend_detail_form.durn_value.value = duration_value;
		var qty_value				=	parent.f_detail.document.prescription_amend_detail_form.qty_value.value;
		var abs_qty_value				=	parent.f_detail.document.prescription_amend_detail_form.absol_qty.value;//Added for BRU-HIMS-CRF-400
		var dosage_type	=   parent.f_detail.document.prescription_amend_detail_form.dosage_type.value;
		var repeat_value	=   parent.f_detail.document.prescription_amend_detail_form.repeat_value.value;
		var qty_desc	=   parent.f_detail.document.prescription_amend_detail_form.qty_desc.value;
		var pres_base_uom	=   parent.f_detail.document.prescription_amend_detail_form.pres_base_uom.value;
		var freq_nature	=   parent.f_detail.document.prescription_amend_detail_form.freq_nature.value;
		if(duration_value!=""){//added for ML-MMOH-SCF-0498 [IN061648] --chithra
			var patient_class=parent.f_header.document.prescription_header_form.actual_patient_class.value; 
			}//end 
		if(parseInt(duration_value)==0 || duration_value=="") {
			alert(getMessage("PRES_DURN_CANNOT_ZERO", "PH"));
			parent.f_detail.document.prescription_amend_detail_form.durn_value.focus();
			return;
		}
	
		var interval_value = parent.f_detail.document.prescription_amend_detail_form.interval_value.value;
		if(freq_nature=="F" && interval_value >1){
			if((duration_value % interval_value) > 0){
				var rem = duration_value % interval_value;
				var prev_day = duration_value - rem;
				//var nxt_day = duration_value + rem;
				var nxt_day = parseInt(duration_value) - parseInt(rem) + parseInt(interval_value);
				var err_msg = getMessage("DURATION_VALUE_MULTIPLE","PH");
				if(prev_day == 0 && rem!=duration_value){
					err_msg = err_msg.replace('$ or ',"");
				}
				
				else{ //Added for TFS-7506
					if(prev_day == 0){
						prev_day=nxt_day;
						nxt_day=nxt_day+nxt_day;
					}  //Added for TFS-7506
				err_msg = err_msg.replace('$', prev_day);
				err_msg = err_msg.replace('#', nxt_day);
				err_msg = err_msg.replace('%', interval_value);
				alert(err_msg); //	alert("Duration value can be "+prev_day+" or "+nxt_day+" or a multiple of "+interval_value);
				parent.f_detail.document.prescription_amend_detail_form.durn_value.focus();
				return false;  //Added for TFS-7506
				}
			}
		}
		if(patient_class=="IP" || patient_class =="DC"){ // || patient_class =="DC" added for ML-MMOH-SCF-0649.1
			if(parent.f_header.document.prescription_header_form.take_home_medication.checked) // parent.f_header.document.prescription_header_form.take_home_medication.value=="Y" changed to parent.f_header.document.prescription_header_form.take_home_medication.checked for ML-MMOH-SCF-0649
				patient_class="OP";
		}//end added for ML-MMOH-SCF-0498 --- chithra
//ML-BRU-SCF-2069 - start
		var called_from	=	""
		var repeat_durn_type = "D";
		var durn_type        = "D";
		if(parent.f_detail.document.prescription_amend_detail_form!=undefined){
	     	called_from	=	parent.f_detail.document.prescription_amend_detail_form.called_from.value;
		 repeat_durn_type		=	parent.f_detail.document.prescription_amend_detail_form.repeat_durn_type.value;
		 durn_type              =   parent.f_detail.document.prescription_amend_detail_form.durn_type.value;
		}
//ML-BRU-SCF-2069 - end
		var fldString=" patient_class=\""+ patient_class + "\" ";
		fldString += " drug_code=\""+ drug_code + "\" ";
		fldString += " duration_value=\""+ duration_value + "\" ";
		fldString += " qty_value=\""+ qty_value + "\" ";
		fldString += " abs_qty_value=\""+ abs_qty_value + "\" ";//Added for BRU-HIMS-CRF-400
		fldString += " dosage_type=\""+ dosage_type + "\" ";
		fldString += " repeat_value=\""+ repeat_value + "\" ";
		fldString += " qty_desc=\""+ qty_desc + "\" ";	
		fldString += " pres_base_uom=\""+ pres_base_uom + "\" ";	
		fldString += " freq_nature=\""+ freq_nature + "\" ";	
		//ML-BRU-SCF-2069 - start
		fldString += " called_from=\""+ called_from + "\" ";	
		fldString += " durationChange=\""+ durationChange + "\" ";	
		fldString += " repeat_durn_type=\""+ repeat_durn_type + "\" ";	
		fldString += " durn_type=\""+ durn_type + "\" ";	
		//ML-BRU-SCF-2069 - end
		var formobj=parent.f_detail.document.prescription_amend_detail_form;
		var xmlStr=formXMLString(formobj,fldString);
		//var retVal = fieldValidation(xmlStr,"maxDurnValidation");
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=maxDurnValidation",false);//ML-MMOH-SCF-0498
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		return eval(responseText);
	}
    /*var drug_code       = document.prescription_amend_detail_form.drug_code.value;
    var patient_class       = document.prescription_amend_detail_form.patient_class.value;
	var duration_value		= Math.abs(document.prescription_amend_detail_form.durn_value.value);
	document.prescription_amend_detail_form.durn_value.value = duration_value;
	var qty_value				=	document.prescription_amend_detail_form.qty_value.value;
	var dosage_type	=   parent.f_detail.document.prescription_amend_detail_form.dosage_type.value;
	var repeat_value	=   parent.f_detail.document.prescription_amend_detail_form.repeat_value.value;
	var qty_desc	=   parent.f_detail.document.prescription_amend_detail_form.qty_desc.value;
	var pres_base_uom	=   parent.f_detail.document.prescription_amend_detail_form.pres_base_uom.value;
	var freq_nature	=   parent.f_detail.document.prescription_amend_detail_form.freq_nature.value;

	if(parseInt(duration_value)==0 || duration_value=="") {
		alert(getMessage("PRES_DURN_CANNOT_ZERO", "PH"));
		document.prescription_amend_detail_form.durn_value.focus();
		return;
	}
    var fldString=" patient_class=\""+ patient_class + "\" ";
	fldString += " drug_code=\""+ drug_code + "\" ";
	fldString += " duration_value=\""+ duration_value + "\" ";
	fldString += " qty_value=\""+ qty_value + "\" ";
	fldString += " dosage_type=\""+ dosage_type + "\" ";
	fldString += " repeat_value=\""+ repeat_value + "\" ";
	fldString += " qty_desc=\""+ qty_desc + "\" ";	
	fldString += " pres_base_uom=\""+ pres_base_uom + "\" ";	
	fldString += " freq_nature=\""+ freq_nature + "\" ";	
	var formobj=document.prescription_amend_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"maxDurnValidation"); */
}

function assignDurnvalueAmend(total_durn_value,max_durn_value,chk_for_max_durn_action,prompt_msg, new_qty,max_durn_type){
    var durn_value	=	parseInt(Math.abs(parent.f_detail.document.prescription_amend_detail_form.durn_value.value));
	parent.f_detail.document.prescription_amend_detail_form.durn_value.value = durn_value;
	var called_from			=	parent.f_detail.document.prescription_amend_detail_form.called_from.value;
	var ord_auth_reqd_yn	= "";
	var durn_desc			= parent.f_detail.document.prescription_amend_detail_form.durn_desc.value;
	var repeat_durn_type    = parent.f_detail.document.prescription_amend_detail_form.repeat_durn_type.value;
	var temp_max_durn_val	= "";
	var disp_durn = "";

	if(max_durn_type == "")
		max_durn_type = "D";

	if(parseInt(max_durn_value)==0 || max_durn_value==''){//added for ML-MMOH-SCF-0498 [IN061648] --chithra
		var pat_class	=	parent.f_header.document.prescription_header_form.patient_class.value;
		if(parent.f_header.document.prescription_header_form.take_home_medication.checked){ 
			max_durn_value = parent.f_header.document.prescription_header_form.max_durn_for_dm_pres.value;
			chk_for_max_durn_action = parent.f_header.document.prescription_header_form.chk_for_dm_max_durn_action.value;
		}//end ML-MMOH-SCF-0498 
		else if(pat_class=='IP'){
			max_durn_value = parent.f_header.document.prescription_header_form.max_durn_for_ip_pres.value;
			chk_for_max_durn_action = parent.f_header.document.prescription_header_form.chk_for_ip_max_durn_action.value;
		}
		else{
			max_durn_value = parent.f_header.document.prescription_header_form.max_durn_for_op_pres.value;
			chk_for_max_durn_action = parent.f_header.document.prescription_header_form.chk_for_op_max_durn_action.value;
		}
		//document.prescription_amend_detail_form.max_durn_value.value=max_durn_value;
		//document.prescription_amend_detail_form.chk_for_max_durn_action.value=chk_for_max_durn_action;
	}

	if(repeat_durn_type != durn_desc){
		if(repeat_durn_type == 'M'){
			if(durn_desc == 'H'){
				durn_value = parseInt(durn_value) * 60;	
			}else if(durn_desc == 'D'){
				durn_value = parseInt(durn_value) * (24 * 60);	
			}else if(durn_desc == 'W'){
				durn_value = parseInt(durn_value) * (7 * 24 * 60);	
			}else if(durn_desc == 'L'){
				durn_value = parseInt(durn_value) * (30  * 24 * 60);	
			}else if(durn_desc == 'Y'){
				durn_value = parseInt(durn_value) * (365 * 24 * 60);	
			}
	   }
	   else if(repeat_durn_type == 'H'){
			if(durn_desc == 'M'){
				durn_value = Math.ceil(parseInt(durn_value)/60) ;	
			}else if(durn_desc == 'D'){
				durn_value = parseInt(durn_value) * 24;	
			}else if(durn_desc == 'W'){
				durn_value = parseInt(durn_value) * 7 * 24;	
			}else if(durn_desc == 'L'){
				durn_value = parseInt(durn_value) * 30 * 24;	
			}else if(durn_desc == 'Y'){
				durn_value = parseInt(durn_value) * 365 * 24;	
			}
	   }
	   else if(repeat_durn_type == 'D'){
			if(durn_desc == 'M'){
				durn_value = Math.ceil(parseInt(durn_value)/(24*60));	
			}else if(durn_desc == 'H'){
				durn_value = Math.ceil(parseInt(durn_value)/24);	
			}else if(durn_desc == 'W'){
				durn_value = parseInt(durn_value) * 7 ;	
			}else if(durn_desc == 'L'){
				durn_value = parseInt(durn_value) * 30 ;	
			}else if(durn_desc == 'Y'){
				durn_value = parseInt(durn_value) * 365 ;	
			}
		}
		else if(repeat_durn_type == 'W'){
			if(durn_desc == 'M'){
				durn_value = Math.ceil(parseInt(durn_value)/(7*24*60));
			}else if(durn_desc == 'H'){
				durn_value = Math.ceil(parseInt(durn_value)/(7*24));	
			}else if(durn_desc == 'D'){
				durn_value = Math.ceil(parseInt(durn_value)/7);	
			}else if(durn_desc == 'L'){
				durn_value = parseInt(durn_value) * 4;	
			}else if(durn_desc == 'Y'){
				durn_value = parseInt(durn_value) * 52;	
			}
		}
		else if(repeat_durn_type == 'L'){   // else if condition added  -- 03/02/2010-- shyampriya
			if(durn_desc == 'M'){
				durn_value = Math.ceil(parseInt(durn_value)/(30*24*60));
			}else if(durn_desc == 'H'){
				durn_value = Math.ceil(parseInt(durn_value)/(30*24));	
			}else if(durn_desc == 'D'){
				durn_value = Math.ceil(parseInt(durn_value)/30);	
			}else if(durn_desc == 'W'){
				durn_value = parseInt(durn_value)/4;	
			}else if(durn_desc == 'Y'){
				durn_value = parseInt(durn_value) * 12;	
			}
	   }	
	} 
	
	disp_durn = max_durn_value;
	if(max_durn_type != repeat_durn_type && repeat_durn_type!=''){// && added for ICN65249 
	   if(max_durn_type == 'M'){
			if(repeat_durn_type == 'H'){
				temp_max_durn_val	   = parseInt(max_durn_value)/60;
			}else if(repeat_durn_type == 'D'){
				temp_max_durn_val	   = parseInt(max_durn_value)/(24*60);
			}else if(repeat_durn_type == 'W'){
				temp_max_durn_val	   = parseInt(max_durn_value)/(7*24*60);
			}else if(repeat_durn_type == 'L'){
				temp_max_durn_val	   = parseInt(max_durn_value)/(30*24*60); 
			}else if(repeat_durn_type == 'Y'){
				temp_max_durn_val	   = parseInt(max_durn_value)/(365*24*60);
			}
	   }
	   else if(max_durn_type == 'H'){
			if(repeat_durn_type == 'M'){
	  			temp_max_durn_val = parseInt(max_durn_value) * 60;	
			}else if(repeat_durn_type == 'D'){
				temp_max_durn_val	   = parseInt(max_durn_value)/24;
			}else if(repeat_durn_type == 'W'){
				temp_max_durn_val	   = parseInt(max_durn_value)/(7*24);
			}else if(repeat_durn_type == 'L'){
				temp_max_durn_val	   = parseInt(max_durn_value)/(30*24); 
			}else if(repeat_durn_type == 'Y'){
				temp_max_durn_val	   = parseInt(max_durn_value)/(365*24);
			}
	   }
	   else if(max_durn_type == 'D'){
			if(repeat_durn_type == 'M'){
				temp_max_durn_val = parseInt(max_durn_value) * 24 * 60;	
			}else if(repeat_durn_type == 'H'){
				temp_max_durn_val = parseInt(max_durn_value) * 24;	
			}else if(repeat_durn_type == 'W'){
				temp_max_durn_val	   = parseInt(max_durn_value)/7;	
			}else if(repeat_durn_type == 'L'){
					temp_max_durn_val	   = parseInt(max_durn_value)/30;
			}else if(repeat_durn_type == 'Y'){
					temp_max_durn_val	   = parseInt(max_durn_value)/365;
			}
	   }
	   else if(max_durn_type == 'W'){
			if(repeat_durn_type == 'M'){
				temp_max_durn_val = parseInt(max_durn_value) * 7 * 24 * 60;	
			}else if(repeat_durn_type == 'H'){
				temp_max_durn_val = parseInt(max_durn_value) * 7 * 24;	
			}else if(repeat_durn_type == 'D'){
				temp_max_durn_val = parseInt(max_durn_value) * 7;	
			}else if(repeat_durn_type == 'L'){
					temp_max_durn_val	   = parseInt(max_durn_value)/4;
			}else if(repeat_durn_type == 'Y'){
					temp_max_durn_val	   = parseInt(max_durn_value)/52;
			}
		}
		else if(max_durn_type == 'L'){    // else if condition added -- 03/02/2010-- shyampriya
			if(repeat_durn_type == 'M'){
				temp_max_durn_val = parseInt(max_durn_value) * 30 * 24 * 60;	
			}else if(repeat_durn_type == 'H'){
				temp_max_durn_val = parseInt(max_durn_value) * 30 * 24;	
			}else if(repeat_durn_type == 'D'){
				temp_max_durn_val = parseInt(max_durn_value) * 30;	
			}else if(repeat_durn_type == 'W'){
					temp_max_durn_val	   = parseInt(max_durn_value) * 4;
			}else if(repeat_durn_type == 'Y'){
					temp_max_durn_val	   = parseInt(max_durn_value)/12;
			}
	   }
		//max_durn_value = Math.ceil(temp_max_durn_val) ;
		max_durn_value = temp_max_durn_val ;
	}
	
	var append_max_durn_type = "";
	if(max_durn_type=="M")
		append_max_durn_type=getLabel("Common.Minute(s).label",'Common');
	if(max_durn_type=="H")
		append_max_durn_type=getLabel("Common.Hour(s).label",'Common');
	if(max_durn_type=="D")
		append_max_durn_type=getLabel("Common.Day(s).label",'Common');
	if(max_durn_type=="W")
		append_max_durn_type=getLabel("ePH.WEEKS.label",'PH');
	if(max_durn_type=="L")
		append_max_durn_type=getLabel("ePH.MONTHS.label",'PH');
	if(max_durn_type=="Y")
		append_max_durn_type=getLabel("ePH.years.label",'PH');
	
	if(called_from=="RENEW_ORDER") {
	//	disp_durn = " - "+max_durn_value+" "+document.prescription_amend_detail_form.durn_value.value;
		
	}
	else{
//		disp_durn = " - "+max_durn_value+" "+document.prescription_amend_detail_form.durn_desc.options[document.prescription_amend_detail_form.durn_desc.selectedIndex].text;
	//	disp_durn = " - "+max_durn_value+" "+getLabel("Common.Day(s).label",'Common');
	}
	if(parent.f_detail.document.prescription_amend_detail_form.force_auth_yn!=undefined){//added if  ICN65249
	if(parent.f_detail.document.prescription_amend_detail_form.force_auth_yn!= undefined && parent.f_detail.document.prescription_amend_detail_form.force_auth_yn.value!="Y"){//added for ML-MMOH-SCF-0498 [IN061648]
		ord_auth_reqd_yn=parent.f_detail.document.prescription_amend_detail_form.ord_auth_reqd_yn.value;//added for ML-MMOH-SCF-0498 [IN061648] --chithra
		var durn_found=false; //added ICN65249
		if(durn_value>parseInt(max_durn_value)){// changed parseInt(max_durn_value) to parseInt(disp_durn) ICN65249
			if(chk_for_max_durn_action=="R") {
				alert(getMessage("PH_MAX_DURN", "PH")+" "+disp_durn+" "+append_max_durn_type);//[IN 62090]-- chithra
				document.prescription_amend_detail_form.durn_value.value=disp_durn;// changed max_durn_value to disp_durn ICN65249
				if(document.prescription_amend_detail_form.durn_desc.value != max_durn_type){
					var len1 = document.prescription_amend_detail_form.durn_desc.options.length;
					
					for(indx=0;indx<len1;indx++){
						if(document.prescription_amend_detail_form.durn_desc.options[indx].value==max_durn_type){
							document.prescription_amend_detail_form.durn_desc.selectedIndex= indx;
							durn_found =true;
							break;
						}
				}
				//document.prescription_amend_detail_form.durn_value.focus();
			}
				if(durn_found)
					document.prescription_amend_detail_form.durn_value.focus();
					//populateAmendEndDate();
				else
				//	document.prescription_amend_detail_form.frequency.focus();//commanted ICN65249
					populateAmendEndDate();
				//return false;//end for ML-MMOH-SCF-0498 [IN061648]commanted ICN65249
			}
			else if(chk_for_max_durn_action=="W")	{

				alert(getMessage("PH_WARN_DURN", "PH")+" "+disp_durn+" "+append_max_durn_type);//[IN 62090]-- chithra
				if(called_from=="RENEW_ORDER") {
					populateRenewEndDate(new_qty);
				}
				else {
					populateAmendEndDate();
				}
			}
			else if(chk_for_max_durn_action=="A"){
				ord_auth_reqd_yn = "Y";
				alert(getMessage("PH_AUTH_DURN", "PH")+" "+disp_durn+" "+append_max_durn_type);//[IN 62090]-- chithra
				parent.f_detail.document.getElementById('lbl_authorize').style.visibility='visible';
				if(parent.f_detail.document.prescription_amend_detail_form.ord_authorized_prev_yn.value!='Y'){
					parent.f_detail.document.getElementById('lbl_authorize').style.color="red";
					parent.f_detail.document.prescription_amend_detail_form.authroize_yn_val.value="N";
				}
				else if(parent.f_detail.document.prescription_amend_detail_form.ord_authorized_prev_yn.value=='Y'){
					parent.f_detail.document.getElementById('lbl_authorize').style.color="green";
					parent.f_detail.document.prescription_amend_detail_form.authroize_yn_val.value="Y";
				}
				//ADDED FOR MO-SCF-5533 start
				if(parent.f_detail.document.getElementById('lbl_authorize').style.color == 'red'){
					
					
					if(parent.f_detail.document.prescription_amend_detail_form.ord_authorized_yn_durn.value=='Y'){
						parent.f_detail.document.getElementById('lbl_authorize').style.color="green";
						parent.f_detail.document.prescription_amend_detail_form.authroize_yn_val.value="Y";
					}
				}
				//ADDED FOR MO-SCF-5533 end
			//	document.getElementById("requires_auth_gif").style.visibility='visible';
			//	document.getElementById("auth_yn").innerText="Requires Authorization";
				if(called_from=="RENEW_ORDER") {
					populateRenewEndDate(new_qty);
				}
				else {
					populateAmendEndDate();
				}
			}
			else {
				if(called_from=="RENEW_ORDER") {
					populateRenewEndDate(new_qty);
				}
				else {
					populateAmendEndDate();
				}
			}
		}
		/*else{
			
			

			if(called_from=="RENEW_ORDER") {
				populateRenewEndDate(new_qty);
			}
			else {
				populateAmendEndDate();
			}
		}*/
		var drug_code	=	parent.f_detail.document.prescription_amend_detail_form.drug_code.value;		
		var fldString	=" ord_authorized_prev_yn=\""+ parent.f_detail.document.prescription_amend_detail_form.ord_authorized_prev_yn.value + "\" ";
		fldString  +=" ord_auth_reqd_yn=\""+ ord_auth_reqd_yn + "\" ";
		fldString  +=" ord_authorized_yn=\""+ parent.f_detail.document.prescription_amend_detail_form.authroize_yn_val.value + "\" ";
		fldString  +=" srl_no=\""+ parent.f_detail.document.prescription_amend_detail_form.srl_no.value + "\" ";
		fldString  +=" drug_code=\""+ drug_code + "\" ";
		var xmlStr      =formXMLString(parent.f_detail.document.prescription_amend_detail_form,fldString);
		fieldValidation(xmlStr,"setDurationAction");
		populateAmendEndDate();//added for ML-MMOH-SCF-0498 [IN061648] --chithra
	}
	}//end if ICN65249
	else{//added for ML-MMOH-SCF-0498 [IN061648] --chithra
		ord_auth_reqd_yn = "N";
		if(parent.f_detail.document.getElementById('lbl_authorize')!=undefined && parent.f_detail.document.getElementById('lbl_authorize')!=null)// Added for IN:65249
			parent.f_detail.document.getElementById('lbl_authorize').style.visibility='hidden';
		if(durn_value>parseInt(max_durn_value)){//added for  ICN65249 start
			if(chk_for_max_durn_action=="R") {
				alert(getMessage("PH_MAX_DURN", "PH")+" "+disp_durn+" "+append_max_durn_type);
				document.prescription_amend_detail_form.durn_value.value=max_durn_value;
			}else if(chk_for_max_durn_action=="W")	{

				alert(getMessage("PH_WARN_DURN", "PH")+" "+disp_durn+" "+append_max_durn_type);
			}else if(chk_for_max_durn_action=="A"){
				alert(getMessage("PH_AUTH_DURN", "PH")+" "+disp_durn+" "+append_max_durn_type);
			}
			}//end  ICN65249
		if(called_from=="RENEW_ORDER") {
			populateRenewEndDate(new_qty);
		}
		else {
			populateAmendEndDate();
		}
	}
}

function populateAmendStartDate(obj){
	var source=obj.name;
	var mode=document.prescription_amend_detail_form.mode.value;
	var or_date_time=parent.f_header.document.prescription_header_form.or_date_time.value;
	if(document.prescription_amend_detail_form.start_date.value==''){
		document.prescription_amend_detail_form.start_date.value=or_date_time;
	}       
	var start_date=document.prescription_amend_detail_form.start_date.value;
	var fldString=" start_date=\""+ start_date + "\" ";
	fldString += " source=\""+ source + "\" ";
	var formobj=document.prescription_amend_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	return fieldValidation(xmlStr,"populateStartDate");
}

function assignAmendStartDate(source,start_date,future_date,back_date){
    document.prescription_amend_detail_form.start_date.value=start_date;
    if(source=="qty_value"){
		document.prescription_amend_detail_form.end_date.value=start_date;
		populateAmendEndDate();
	}
	else if(source=="durn_value"){
        populateAmendEndDate(); 
    }
}

function populateAmendEndDate(){
	var start_date		=	parent.f_detail.document.prescription_amend_detail_form.start_date.value;
	var durn_value		=	parent.f_detail.document.prescription_amend_detail_form.durn_value.value;
	var repeat_durn_type	=	parent.f_detail.document.prescription_amend_detail_form.repeat_durn_type.value;
	var durn_desc		=	parent.f_detail.document.prescription_amend_detail_form.durn_desc.value;
	var freq_nature		=	parent.f_detail.document.prescription_amend_detail_form.freq_nature.value;
	repeat_durn_type=durn_desc;
/*	if( repeat_durn_type=="H" || repeat_durn_type=="M" ){
		repeat_durn_type="D";
		durn_value="1";     
	}*/
//alert("start_date="+start_date+",durn_value="+durn_value+",repeat_durn_type="+repeat_durn_type+",freq_nature="+freq_nature);
	if(durn_value!=''){
		var fldString="  start_date=\""+ start_date + "\" ";
		fldString += " durn_value=\""+ durn_value + "\" ";
		fldString += " repeat_durn_type=\""+ repeat_durn_type + "\" ";
		fldString += " freq_nature=\""+ freq_nature + "\" ";
		var formobj=parent.f_detail.document.prescription_amend_detail_form;
		var xmlStr=formXMLString(formobj,fldString);
		return fieldValidation(xmlStr,"populateEndDate");
	}
}

function populateRenewEndDate(new_qty) {
	var start_date			=	parent.f_detail.document.prescription_amend_detail_form.start_date.value;
	var durn_value			=	parent.f_detail.document.prescription_amend_detail_form.durn_value.value;
	var repeat_durn_type	=	parent.f_detail.document.prescription_amend_detail_form.repeat_durn_type.value;
	var dup_start_date		=	parent.f_detail.document.prescription_amend_detail_form.dup_start_date.value;
	var dup_end_date		=	parent.f_detail.document.prescription_amend_detail_form.dup_end_date.value;
	var drug_code	=	parent.f_detail.document.prescription_amend_detail_form.drug_code.value;
	var patient_id	=	parent.f_detail.document.prescription_amend_detail_form.patient_id.value;
	var encounter_id	=	parent.f_detail.document.prescription_amend_detail_form.encounter_id.value;
// added for ML-BRU-SCF-2069 - start
	var durn_type	=	parent.f_detail.document.prescription_amend_detail_form.durn_type.value;
	if(durn_type=="W")
		durn_value = parseInt(durn_value)*7;
	else if(durn_type=="L")
		durn_value = parseInt(durn_value)*30;
	else if(durn_type=="Y")
		durn_value = parseInt(durn_value)*365;
// added for ML-BRU-SCF-2069 - end
	/*if( repeat_durn_type=="H" || repeat_durn_type=="M" ){
		repeat_durn_type="D";
		durn_value="1";     
	}*/
	if(durn_value!=''){
		var fldString="  start_date=\""+ start_date + "\" ";
		fldString += " durn_value=\""+ durn_value + "\" ";
		fldString += " dup_start_date=\""+ dup_start_date + "\" ";
		fldString += " dup_end_date=\""+ dup_end_date + "\" ";
		fldString += " repeat_durn_type=\""+ repeat_durn_type + "\" ";
		fldString += " new_qty=\""+ new_qty + "\" ";
		fldString += " patient_id=\""+ patient_id + "\" ";
		fldString += " encounter_id=\""+ encounter_id + "\" ";
		fldString += " drug_code=\""+ drug_code + "\" ";
		var formobj=parent.f_detail.document.prescription_amend_detail_form;
		var xmlStr=formXMLString(formobj,fldString);
		return fieldValidation(xmlStr,"renewEndDate");
	}
}

function assignAmendEndDate(end_date){
    parent.f_detail.document.prescription_amend_detail_form.end_date.value=end_date;
}

async function callPreviewOrdersAmend()   {
	var patient_id              = parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id            = parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var date                    = parent.parent.f_header.document.prescription_header_form.or_date_time.value;
	var locn_code               = parent.parent.f_header.document.prescription_header_form.location_code.value;
	var pract_name              = unescape(parent.parent.f_header.document.prescription_header_form.pract_name.value);
	var actual_patient_class    = parent.parent.f_header.document.prescription_header_form.patient_class.value;
	var bl_install_yn			= parent.parent.f_header.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	= parent.parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var dialogHeight= "75vh" ;
	var dialogWidth	= "75vw" ;
	var dialogTop = "10" ;
    var center = "1" ;
    var status="no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
    var arguments   = "" ;
    retVal =await top.window.showModalDialog("../../ePH/jsp/PrescriptionAmendPreviewOrderFrames.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&date="+date+"&locn_code="+locn_code+"&pract_name="+encodeURIComponent(pract_name)+"&actual_patient_class="+actual_patient_class+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn,arguments,features);
	// added below if condition for ICN NO:32735 By chandrashekar raju
	if(retVal!= undefined && retVal=='R')
		document.amendPreviewForm.release_butt.click();
}

function releaseRx(){
	var patient_id              = parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id            = parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var order_id				= parent.parent.f_header.document.prescription_header_form.order_id.value;
	var called_from				= parent.parent.f_header.document.prescription_header_form.called_from.value;
	var srl_no					=parent.f_prescription_form.document.prescription_form.srl_no.value
	if(called_from!="RENEW_ORDER") {	
		var fldString=" patient_id=\""+ patient_id + "\" ";
		fldString += " encounter_id=\""+ encounter_id + "\" ";
		fldString += " order_id=\""+ order_id + "\" ";
		var formobj=parent.parent.f_header.document.prescription_header_form;
	
		if( eval(parent.f_prescription_form.document.getElementById("ext_ddb_override_img"+srl_no)) != undefined && eval(parent.f_prescription_form.document.getElementById("ext_ddb_override_img"+srl_no)).style.display=="inline"){
			alert(getMessage("OVERRIDE_REASON_NOT_BLANK", "PH"));
			return false;
		}	
		var xmlStr=formXMLString(formobj,fldString);
		fieldValidation(xmlStr,"groupRemarks");
	}
	else {		
		if(findDuplicateDrug()) {
			formGrouping();
		}
	}
}

function showRecords(){
	var formarray  =new Array(parent.parent.f_header.document.prescription_header_form);
	 eval(formApply( formarray,PH_CONTROLLER));
	if( result ){
		onSuccess(parent.parent.f_header.document.prescription_header_form);
	}
	else{
		alert(getMessages("TRANSACTION_FAILED","PH"));
	}   
}

async function showOrderComments(order_id){
	var dialogHeight= "15.5" ;
	var dialogWidth	= "25" ;
	var dialogTop = "270" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scrolling :no";
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/DispMedicationOrderComments.jsp?order_id="+order_id,arguments,features);
}

async function showOrderRemarks(order_id,patient_id,encounter_id,drug_code) {
	var dialogHeight= "15.5" ;
	var dialogWidth	= "25" ;
	var dialogTop = "270" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scrolling :no";
	var arguments	= "" ;
	retVal =await window.showModalDialog("../../ePH/jsp/DispMedicationOrderComments.jsp?order_id="+order_id+"&patient_id="+patient_id+"&encounter_id"+encounter_id+"&drug_code="+drug_code+"&called_from=remarks",arguments,features);
}

function releaseMedicalOrder(narcotic_yn){
	var formarray  =new Array(parent.parent.f_header.document.prescription_header_form);
	eval( formApply( formarray,PH_CONTROLLER) ) ;
	if( result ){
		onSuccess(parent.parent.f_header.document.prescription_header_form,narcotic_yn);
	}
	else{
		if(message=="ORDER_PROC_BY_OTHER_USER") //added for ML-MMOH-SCF-1776
			alert(getMessage("ORDER_PROC_BY_OTHER_USER","PH"));
		else
			alert(getMessage("TRANSACTION_FAILED","PH"));
	}   
}

function assignResult( _result, _message, _flag, code ) {
    result = _result ;
    message  = _message ;
    flag = _flag ;
}

async function onSuccess(header_form , narcotic_yn ){
	message= message.replace("<br>","\n");
	alert(message);
	
	var narcotic_aprvl_form_req_yn=header_form.narcotic_aprvl_form_req_yn.value;
	var print_narcotic_form_by_default=header_form.print_narcotic_form_by_default.value;
	var print_mar_label_yn = header_form.print_mar_label_yn.value; //added for MMS-QH-CRF-0080 [IN:038064]
	var buildMAR_yn = header_form.buildMAR_yn.value; //added for MMS-QH-CRF-0080 [IN:038064]
//alert("==narcotic_yn==="+narcotic_yn+"==narcotic_aprvl_form_req_yn=="+narcotic_aprvl_form_req_yn+"==print_narcotic_form_by_default=="+print_narcotic_form_by_default);
	if(narcotic_yn == "N"){
		narcotic_aprvl_form_req_yn = "";
		print_narcotic_form_by_default="";
	}
	var print_ord_sht_rule_ind=""; 	//Added for HSA-SCF-0036[IN 50011]-Start
	var patient_id=header_form.patient_id.value;
	var encounter_id=header_form.encounter_id.value;
	var fldString=" patient_id=\""+ patient_id + "\" ";
	fldString+=" encounter_id=\""+ encounter_id + "\" ";
	var xmlStr=formXMLString(header_form,fldString);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=Get_PrintOrderInd",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	responseText=trimString(responseText);
	print_ord_sht_rule_ind=responseText;	//Added for HSA-SCF-0036[IN 50011]-End
	var dialogHeight	="12" ;
	var dialogWidth	="30";
	var dialogTop	= "300" ;
	var dialogLeft	= "300" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') || (print_mar_label_yn=="Y" && buildMAR_yn=="Y") || narcotic_aprvl_form_req_yn=="Y"){//print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
		retVal =await window.showModalDialog("../../ePH/jsp/PrescriptionPrintDialog.jsp?narcotic_aprvl_form_req_yn="+narcotic_aprvl_form_req_yn+"&print_narcotic_form_by_default="+print_narcotic_form_by_default+"&called_from=NRX2"+"&buildMAR_yn="+buildMAR_yn+"&print_mar_label_yn="+print_mar_label_yn+"&print_ord_sht_rule_ind="+print_ord_sht_rule_ind,arguments,features);//print_ord_sht_rule_ind,Added for Bru-HIMS-CRF-393_1.0
	}
	if(((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal != undefined && retVal[0] != "CANCEL") || print_ord_sht_rule_ind =='S'){//print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
	//var print_confirm=confirm(getMessage("PH_PRINT_PRESCRIPTION", "PH"))
//	if(print_confirm){
		print_yn="Y";
		var fldString=" patient_id=\""+ header_form.patient_id.value + "\" ";
		fldString+=" encounter_id=\""+ header_form.encounter_id.value + "\" ";
		fldString+=" print_yn=\""+ print_yn + "\" ";
		fldString+=" patient_class=\""+ header_form.patient_class.value + "\" ";
		fldString+=" locn_code=\""+ header_form.location_code.value + "\" ";
		if((print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='') && retVal.length >0){//If and Else if for Bru-HIMS-CRF-393_1.0 AND print_ord_sht_rule_ind=="C" || print_ord_sht_rule_ind=='' added for Inc : 049877
			fldString+=" prescriptionPrint=\""+ retVal[0] + "\" ";
			fldString+=" NarcoticPrint=\""+ retVal[1] + "\" ";
			fldString+=" MARLabelPrint=\""+ retVal[2] + "\" "; //added for MMS-QH-CRF-0080 [IN:038064]
		}
		else if(print_ord_sht_rule_ind =='S')
			fldString+=" prescriptionPrint=\""+ "Y"+ "\" ";

		var xmlStr=formXMLString(header_form,fldString);
		var source="onLinePrinting";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrescriptionValidation_1.jsp?func_mode="+source,true);
		xmlHttp.send(xmlDoc);
	}
    parent.window.close();    
}
function printOnlinePrescription(formObj,okCancel,print_ord_sht_rule_ind){
	var retval= new Array();
	if(okCancel=='OK'){
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
     window.returnValue=retval;
	 window.close();
}

function alertForOverrideReason(){
	alert(getMessages("OVERRIDE_REASON_NOT_BLANK","PH"));
}

function formGrouping(){
	var patient_id=parent.parent.f_header.document.prescription_header_form.patient_id.value;
	var encounter_id=parent.parent.f_header.document.prescription_header_form.encounter_id.value;
	var height="";
	var weight="";
	var height_unit="";
	var weight_unit="";
	var bsa_unit="BSA";

	var priority = parent.parent.f_header.document.prescription_header_form.priority.value;
	var order_date_time = parent.parent.f_header.document.prescription_header_form.sys_date.value;
	var take_home_medication = parent.parent.f_header.document.prescription_header_form.take_home_medication.value;
	var patient_class=parent.parent.f_header.document.prescription_header_form.patient_class.value;
	if(height_unit=="")
		height_unit="Cms";
	if(weight_unit=="")
		weight_unit="Kgs";
	var location_type=parent.parent.f_header.document.prescription_header_form.location_type.value;
	var location_code=parent.parent.f_header.document.prescription_header_form.location_code.value;
	var facility_id=parent.parent.f_header.document.prescription_header_form.facility_id.value;
	var attend_pract_id=parent.parent.f_header.document.prescription_header_form.attend_pract_id.value;
	var ord_pract_id=parent.parent.f_header.document.prescription_header_form.pract_id.value;
	var bmi			=parent.parent.f_header.document.prescription_header_form.bmi.value;
	var bsa			=parent.parent.f_header.document.prescription_header_form.bmi.value;
	var fldString=" patient_class=\""+ patient_class + "\" ";
	fldString+=" patient_id=\""+ patient_id + "\" ";
	fldString+=" encounter_id=\""+ encounter_id + "\" ";
	fldString+=" height=\""+ height + "\" ";
	fldString+=" weight=\""+ weight + "\" ";
	fldString+=" bsa=\""+ bsa + "\" ";
	fldString+=" height_unit=\""+ height_unit + "\" ";
	fldString+=" weight_unit=\""+ weight_unit + "\" ";
	fldString+=" bsa_unit=\""+ bsa_unit + "\" ";
	fldString+=" order_date_time=\""+ order_date_time + "\" ";
	fldString+=" priority=\""+ priority + "\" ";
	fldString+=" take_home_medication=\""+ take_home_medication + "\" ";
	fldString+=" source_type=\""+ location_type + "\" ";
	fldString+=" source_code=\""+ location_code + "\" ";
	fldString+=" facility_id=\""+ facility_id + "\" ";
	fldString+=" attend_pract_id=\""+ attend_pract_id + "\" ";
	fldString+=" ord_pract_id=\""+ ord_pract_id + "\" ";
	fldString+=" bmi=\""+ bmi + "\" ";	
	var formobj=parent.parent.f_header.document.prescription_header_form;
	var xmlStr=formXMLString(formobj,fldString);
	var source="formGrouping";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PrescriptionValidation_1.jsp?func_mode="+source,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
    eval(responseText);
}

function findDuplicateDrug(){

	var frmObj			= parent.f_prescription_form.document.prescription_form;
	var bean_id			= frmObj.bean_id.value;
	var bean_name		= frmObj.bean_name.value;
	var drug_code		= frmObj.dup_drug_code.value;
	var drug_desc		= frmObj.dup_drug_desc.value;
	var srl_no			= frmObj.dup_srl_no.value;	
	var patient_id      = frmObj.patient_id.value;
    var encounter_id    = frmObj.encounter_id.value;
    var patient_class   = frmObj.patient_class.value;
	var mode			= frmObj.mode.value;
	var result			=	false;

	var bl_install_yn				=	parent.parent.f_header.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	=	parent.parent.f_header.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;

	if(drug_desc!="" && drug_code!="" && srl_no!="") {
		alert(getMessage("FUTURE_PRESCRIPTION_CONTAIN")+" - "+drug_desc+" "+getMessage("FUTURE_PRESCRIPTION_CONTAIN_1"));
		var xmlStr ="<root><SEARCH ";
		xmlStr += " bean_id=\""+ bean_id + "\" ";
		xmlStr += " bean_name=\""+ bean_name + "\" ";
		xmlStr += " drug_code=\""+ drug_code + "\" ";
		xmlStr += " srl_no=\""+ srl_no + "\" ";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=deleteDrug",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		var mode			=	"amend";
		parent.parent.f_prescription.location.href="../../ePH/jsp/PrescriptionFormFrame.jsp?patient_id="+patient_id+"&mode="+mode+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn;
	}
	else {
		result	= true;
	}
	return result;
}

function assignRenewalDate(end_date,dup_reason, new_qty) {
	parent.f_detail.document.prescription_amend_detail_form.end_date.value		=	end_date;
	parent.f_detail.document.prescription_amend_detail_form.dup_reason.value	=	dup_reason;
	parent.f_detail.document.prescription_amend_detail_form.absol_qty.value	=	new_qty;
}

function StockWarning(avl_stock,uom){
	alert(getMessage("PH_NO_STOCK_AVAIL_DRUG","PH"));
	return false;
}

function enableRelease() {	
	if(parent.f_preview.document.amendPreviewForm!=null) {
		var preview_rx_yn = parent.f_preview.document.amendPreviewForm.preview_rx_yn.value; //added if for ML-MMOH-CRF-0341 [IN:057179]
		if(preview_rx_yn=='Y'){//if block and else condition added if for ML-MMOH-CRF-0341 [IN:057179]
			parent.f_preview.document.amendPreviewForm.previewReleaseRx.disabled=false;
			parent.f_preview.document.amendPreviewForm.release_butt.disabled=false;
		}
		else{
			if(parent.f_preview.document.amendPreviewForm.release_butt!=null) {		
				parent.f_preview.document.amendPreviewForm.release_butt.disabled=false;
				parent.f_preview.document.amendPreviewForm.preview_butt.disabled=false;
			}
		}
	}
}

function enableAmendRelease() {
	try{	   
		var preview_rx_yn = document.amendPreviewForm.preview_rx_yn.value;//added for ML-MMOH-CRF-0341 [IN:057179]
		if(parent.f_prescription_form.prescription_form!=null && parent.f_prescription_form.prescription_form.all_amended.value=='true') {	
			if(preview_rx_yn=='Y'){//added if for ML-MMOH-CRF-0341 [IN:057179]
				document.amendPreviewForm.previewReleaseRx.disabled=false;
				document.amendPreviewForm.release_butt.disabled=false;
			}
			else{
				document.amendPreviewForm.release_butt.disabled=false;
				document.amendPreviewForm.preview_butt.disabled=false;
			}
		}/* code Added for ML-BRU-SCF-0190[32621]  --Start  */
		else if(parent.f_prescription_form.prescription_form!=null && parent.f_prescription_form.prescription_form.any_amend.value=='true' &&  parent.f_prescription_form.prescription_form.tmp_patient_class.value=='OP'   ) {			
			if(preview_rx_yn=='Y'){//added for ML-MMOH-CRF-0341 [IN:057179]
				document.amendPreviewForm.previewReleaseRx.disabled=false;
				document.amendPreviewForm.release_butt.disabled=false;
			}else{
				document.amendPreviewForm.release_butt.disabled=false;
				document.amendPreviewForm.preview_butt.disabled=false;
			}
		}/* code Added for ML-BRU-SCF-0190[32621]  --End  */
	}
	catch(e){
	}
}

function populateQtyDesc(form_code, default_qty_desc_code){
	var formobj		=	document.prescription_amend_detail_form;
	var drug_code	=	document.prescription_amend_detail_form.drug_code.value;
	var form_code	=	document.prescription_amend_detail_form.form_code.value;
	var qty_desc_dis = document.prescription_amend_detail_form.qty_desc_dis.value; //added for IN21601reopen --03/06/2010 -- priya
	var fldString	=	" form_code=\""+ form_code + "\" ";
		fldString	+= " drug_code=\""+ drug_code + "\" ";
		fldString	+= " default_qty_desc_code=\""+ default_qty_desc_code + "\" ";
		fldString	+= " qty_desc_dis=\""+ qty_desc_dis + "\" "; //added for IN21601reopen --03/06/2010 -- priya
	var xmlStr		=	formXMLString(formobj,fldString);
	return fieldValidation(xmlStr,"populateQtyDesc");
}

function clearQtyDescList(){
	var len =	document.prescription_amend_detail_form.qty_desc.options.length;
	for(var i=0;i<len;i++) {
		document.prescription_amend_detail_form.qty_desc.remove("qty_desc") ;
	}
	var tp = "  ---Select---  " ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
}

function addQtyDescList(code,desc,selected)	{
	var element			= document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.prescription_amend_detail_form.qty_desc.add(element);
}

function dfltQtyDesc(){
	var dosage_type	=	document.prescription_amend_detail_form.dosage.value;
	if(dosage_type=="S"){
		document.prescription_amend_detail_form.qty_desc.value	=	document.prescription_amend_detail_form.strength_uom.value;
	}
	else if(dosage_type=="Q"){		
		document.prescription_amend_detail_form.qty_desc.value	=	document.prescription_amend_detail_form.dflt_qty_uom.value;
		var rx_qty_by_pres_base_uom_yn	=	parent.f_header.document.prescription_header_form.rx_qty_by_pres_base_uom_yn.value;
		if(rx_qty_by_pres_base_uom_yn=="Y"){
			document.prescription_amend_detail_form.qty_desc.disabled=true;
		}
		else{
			document.prescription_amend_detail_form.qty_desc.disabled=false;
		}
	}
	else if(dosage_type=="A"){		
		//document.prescription_amend_detail_form.qty_desc.value	=	document.prescription_amend_detail_form.pres_base_uom.value;
		document.prescription_amend_detail_form.qty_desc.value		=	document.prescription_amend_detail_form.dflt_qty_uom.value;
		var rx_qty_by_pres_base_uom_yn	=	parent.f_header.document.prescription_header_form.rx_qty_by_pres_base_uom_yn.value; //added for IN21338 ====13-05-2010 ===priya -start
		if(rx_qty_by_pres_base_uom_yn=="Y")	{
			document.prescription_amend_detail_form.qty_desc.disabled=true;
		}
		else{
			document.prescription_amend_detail_form.qty_desc.disabled=false;
		} //added for IN21338 ====13-05-2010 ===priya -end
	}
}

function setdfltQtyUom(code,default_qty_yn){
	if(default_qty_yn=='Y')
		document.prescription_amend_detail_form.dflt_qty_uom.value=code;
	else if(document.prescription_amend_detail_form.dflt_qty_uom.value==""){
		document.prescription_amend_detail_form.dflt_qty_uom.value=code;
	}
}

function dosageChange(obj) {
	if(obj.value!="") {
		if(obj.value=="A") {
			deleteScheduleLink();
			DisableSchedule();			
		} 
		else {
		//	deleteScheduleLink(); //check
			DisableSchedule1();

			if(obj.value=="S") {
				dfltStrnQtyDescList();
			} 
			else {
				populateQtyDesc();
			}
			validateQtyDesc(obj.value,'');
			validateamendDosageLimit('true', 'dosageCheck');
			storeSchedule();
		}
	}
}

function storeSchedule() {
	var start_date		= document.prescription_amend_detail_form.start_date.value;
	var split_dose_yn	= document.prescription_amend_detail_form.split_dose_yn.value;
	var qty_value		= document.prescription_amend_detail_form.qty_value.value;
	if(qty_value!="")
		qty_value = Math.abs(qty_value); ////added for IN25920 --28/01/2011-- priya
	var freq_code		= document.prescription_amend_detail_form.freq_desc.value;	
	var freq_nature		= document.prescription_amend_detail_form.freq_nature.value;	
	var freq_desc		= encodeURIComponent(document.prescription_amend_detail_form.freq_desc.options[document.prescription_amend_detail_form.freq_desc.selectedIndex].text);	
	var drug_code		= document.prescription_amend_detail_form.drug_code.value;	
	var srl_no			= document.prescription_amend_detail_form.srl_no.value;		
	var rowVal			= document.prescription_amend_detail_form.srl_no.value;		
	var taper_yn		= document.prescription_amend_detail_form.taper_yn.value;
	var scheduled_yn	= document.prescription_amend_detail_form.scheduled_yn.value;
	var fldString=" start_date=\""+ start_date + "\" ";
		fldString+=" split_dose_yn=\""+ split_dose_yn + "\" ";
		fldString+=" qty_value=\""+ qty_value + "\" ";
		fldString+=" freq_code=\""+ freq_code + "\" ";
		fldString += "freq_nature=\""+ freq_nature +"\" " ;
		fldString += "freq_desc=\""+ freq_desc +"\" " ;
		fldString+=" drug_code=\""+ drug_code + "\" ";
		fldString+=" srl_no=\""+ srl_no + "\" ";
		fldString+=" rowVal=\""+ rowVal + "\" ";
		fldString+=" scheduled_yn=\""+ scheduled_yn + "\" ";			
	var formobj=document.prescription_amend_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"storeSchedule");
	code	=	drug_code + srl_no;
	var fldString=" drug_code=\""+ code + "\" ";
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"makeScheduleLink");
}

function makeScheduleLink(admin_time,admin_qty,total_qty,freq_size,split_chk, calling_mode){
	
	var legend	=	"";

	if(split_chk=="true") {
		legend	=	getLabel("ePH.SplitDose.label",'PH');
		document.prescription_amend_detail_form.split_dose_yn.value = "Y"; //added for IN21602 --26/05/2010 -- priya
	}
	else {
		legend	=getLabel("ePH.ScheduledDose.label",'PH');		
		document.prescription_amend_detail_form.split_dose_yn.value = "N"; //added for IN21602 --26/05/2010 -- priya
	}
	if( document.prescription_amend_detail_form.freq_status.value=="")//if condition added for ML-BRU-SCF-0725 [IN:038336]
		document.prescription_amend_detail_form.split_dose.disabled=false;
	if(parseFloat(admin_qty)<1){
		admin_qty = parseFloat(admin_qty);
	}

	var title="<table border=1 cellpadding=0 cellspacing=0 align=center>"+admin_time+admin_qty+"</table>";
	
	if(!(total_qty==null || total_qty=="")){ //modified to prevent Nan from appearing in quantity window priya 19/02/2010
		if(parseFloat(total_qty) < 1)
			total_qty = parseFloat(total_qty);
		
		document.prescription_amend_detail_form.qty_value.value=total_qty;
	}
	document.getElementById('dosage_label').innerHTML="<label nowrap style='color:red;font-size:10' onMouseOver='displayamendToolTipDataChange(\"" + title + "\");' onmouseout='disasbleamendToolTipDataChange();'>"+legend+"</label>";
	document.prescription_amend_detail_form.admin_time.value=admin_time;
	document.prescription_amend_detail_form.admin_qty.value=admin_qty;
	//validateamendDosageLimit('true', 'makeScheduleLink' );

	if(calling_mode!='onLoad'){
		if(!validateamendDosageLimit('true',calling_mode)){
			return false;
		}
	}
}

function hideScheduleLink(){
	validateamendDosageLimit('true', 'hideSchedulelink');
}

function lookForChange(obj) {
	var curr_val	=	obj.value;
    var init_val	=	document.prescription_amend_detail_form.init_qty.value;
	if(obj.value==''){
		obj.value='0';
	}
	//Added for 34834 - start
	var qty_value=document.prescription_amend_detail_form.qty_value.value;
	if( qty_value==""|| parseFloat(qty_value)==0 ) {
		alert(getMessage("PRES_DOSAGE_CANNOT_ZERO", "PH"));
		document.prescription_amend_detail_form.qty_value.value='0';
		document.prescription_amend_detail_form.qty_value.focus();
		return false ;
	}
	//Added for 34834 - end

	if(obj.value!="" && parseFloat(curr_val)!=parseFloat(init_val)) {
		if(document.prescription_amend_detail_form.freq_nature.value=="P" ) {//removed 'A' for ML-BRU-SCF-2067
			deleteScheduleLink();
			DisableSchedule();
		}
		else {
			deleteScheduleLink();
			DisableSchedule();
			storeSchedule();
			//validateamendDosageLimit('true','lookForchange');
			CheckPositiveNumber(obj);
		}
	}
}
function lookForChange1(obj) {
	if(obj.value==''){
		obj.value='0';
	}
	var curr_val	=	parseInt(obj.value);
    var init_val	=	parseInt(document.prescription_amend_detail_form.init_qty.value);
	if(curr_val!=init_val) {
		if(document.prescription_amend_detail_form.dosage.value=="A" || document.prescription_amend_detail_form.freq_nature.value=="P" ) {
			deleteScheduleLink();
			DisableSchedule();
		} 
		else {
		//	deleteScheduleLink(); //check
			DisableSchedule1();
			storeSchedule();
			validateamendDosageLimit('true','lookforchecge111');
			CheckPositiveNumber(obj);
		}
	}
}

function dfltStrnQtyDescList(){
	clearQtyDescList();
	var opt1	= document.createElement("OPTION") ;
	opt1.text	= document.prescription_amend_detail_form.strength_uom_desc.value ;
	opt1.value	= document.prescription_amend_detail_form.strength_uom.value;
	document.prescription_amend_detail_form.qty_desc.add(opt1);
	document.prescription_amend_detail_form.qty_desc.value=document.prescription_amend_detail_form.strength_uom.value;
}

function deleteScheduleLink(){
	//document.prescription_amend_detail_form.sch_over_yn.value="Y";
	document.prescription_amend_detail_form.split_dose.disabled=true;
	var dosage_type	=	document.prescription_amend_detail_form.dosage.value;
	validateQtyDesc(dosage_type,"R");			
}

function validateQtyDesc(mode,status){

	document.prescription_amend_detail_form.dosage_type.value	=	mode;
	if(mode=="S"){
		document.prescription_amend_detail_form.dosage_label.innerText=getLabel("Common.Strength.label",'Common');	
		document.prescription_amend_detail_form.qty_desc.value	=	document.prescription_amend_detail_form.strength_uom.value;
		if(status!="R")
			document.prescription_amend_detail_form.qty_value.value=document.prescription_amend_detail_form.strength_value.value;
	}
	else if(mode=="Q"){
		document.getElementById('dosage_label').innerText	=getLabel("ePH.Dose.label",'PH');	
		//document.prescription_amend_detail_form.qty_desc.value	=	document.prescription_amend_detail_form.dflt_qty_uom.value;
		if(status!="R")
			document.prescription_amend_detail_form.qty_value.value=document.prescription_amend_detail_form.tab_qty_value.value;
	}
	else if(mode=="A" ) {
	//else if(mode=="A" && document.prescription_amend_detail_form.patient_class.value=="IP" && document.prescription_amend_detail_form.freq_nature.value=="P") {
		document.prescription_amend_detail_form.dosage_label.innerText=getLabel("Common.Quantity.label",'Common');	
	}
}

function DisableSchedule(){
	var drug_code		= document.prescription_amend_detail_form.drug_code.value;
	var srl_no			= document.prescription_amend_detail_form.srl_no.value;
	var taper_yn	= document.prescription_amend_detail_form.taper_yn.value;
	code	=	drug_code+srl_no;
	var fldString	=	" drug_code=\""+ code + "\" ";
	var formobj		=	document.prescription_amend_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"disableScheduleLink");
}

function DisableSchedule1(){
	var drug_code		= document.prescription_amend_detail_form.drug_code.value;
	var srl_no			= document.prescription_amend_detail_form.srl_no.value;
	var taper_yn	= document.prescription_amend_detail_form.taper_yn.value;
	code	=	drug_code+srl_no;
	var fldString	=	" drug_code=\""+ code + "\" ";
	var formobj		=	document.prescription_amend_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	fieldValidation(xmlStr,"disableScheduleLink1");
}

async function DisplaySchedule(called_from) {

	var frmObj=document.prescription_amend_detail_form;
	var patient_id		= frmObj.patient_id.value;
	var encounter_id	= frmObj.encounter_id.value;
	var bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	var bean_name		= "ePH.PrescriptionBean_1";
	var drug_code		= frmObj.drug_code.value;
	var srl_no			= frmObj.srl_no.value;
 	var freq_code		= frmObj.freq_desc.value;
	var row_value       = frmObj.srl_no.value;
	var facility_id		= parent.f_header.document.prescription_header_form.facility_id.value;
 	var	max_qty		    = frmObj.daily_dose.value;
	var	unit_qty		= frmObj.unit_dose.value;
	var split_dose_yn   = frmObj.split_dose_yn.value;
	var split_qty       = frmObj.qty_value.value;
	var qty_reqd_yn     = "Y";
	var taper_yn		= frmObj.taper_yn.value;
	var chk_max			= "N";
	var chk_unit		= "N";

	if(max_qty!='0'){
		chk_max = "Y";
	}
	if(unit_qty!='0'){
		chk_unit = "Y";
	}
	var uom_desc			= frmObj.qty_desc.value;
	var uom_description		= frmObj.qty_desc[frmObj.qty_desc.selectedIndex].text;
	var start_time_day_param = frmObj.start_date.value;
	var pr_duration			 = frmObj.durn_value.value;
	var pr_duration_type	 = frmObj.durn_desc.value;
	var durationType_P		 = frmObj.repeat_durn_type.value;
	var fract_dose_appl_yn		 = frmObj.fract_dose_appl_yn.value;

	 uom_desc=encodeURIComponent(uom_desc,"UTF-8");
	
	if(uom_desc!=""){
		var retVal;
		var dialogTop		= "10";
		var dialogHeight	= "85vh" ;
		var dialogWidth		= "90vw" ;
		var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
		var arguments		= "";
		code	=	drug_code+srl_no;

		retVal 				= await window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?mode=1&bean_id="+bean_id+"&uom_desc="+uom_desc+"&bean_name="+bean_name+"&chk_max="+chk_max+"&chk_unit="+chk_unit+"&max_qty="+max_qty+"&split_dose_yn="+split_dose_yn+"&split_qty="+split_qty+"&qty_reqd_yn="+qty_reqd_yn+"&unit_qty="+unit_qty+"&code="+code+"&row_value="+row_value+"&facility_id="+facility_id+"&freq_code="+freq_code+"&module_id=PH&called_from="+called_from+"&start_time_day_param="+start_time_day_param+"&pr_duration="+pr_duration+"&pr_duration_type="+pr_duration_type+"&org_drug_code="+drug_code+"&interval_durn_type="+durationType_P+"&fract_value_yn="+fract_dose_appl_yn,arguments,features);
		if(retVal!=null){
			oldrepeatvalue=frmObj.repeat_value.value;
			//frmObj.repeat_value.value="1";
			if( frmObj.freq_status.value=="") //if condition added for ML-BRU-SCF-0725 [IN:038336]
				frmObj.split_dose.disabled=false;
			var split_vals = retVal[1].split('~~');			
			var len = frmObj.freq_desc.options.length;			
			for(img=0;img<len;img++){
				if(frmObj.freq_desc.options[img].value==split_vals[0]){
					frmObj.freq_desc.selectedIndex= img	;
					break;
				}
			}
			freqChange(frmObj.freq_desc,'M');
			var drug_code = frmObj.drug_code.value;
			var fldString=" drug_code=\""+ code + "\" ";
			var xmlStr=formXMLString(frmObj,fldString);
			fieldValidation(xmlStr,"makeScheduleLink");
			var len1 = frmObj.durn_desc.options.length;

			for(img1=0;img1<len1;img1++){
				if(frmObj.durn_desc.options[img1].value==retVal[3]){
					frmObj.durn_desc.selectedIndex= img1;
					break;
				}
			}

			if(retVal[2]==""){
				frmObj.durn_value.value = "1";
			}
			else{
				frmObj.durn_value.value=retVal[2];
			}
			
			durationConversn(frmObj.durn_desc);
			maxDurnValidation();
			extDosageCheck('Modify');
			getChargeDetails(frmObj.in_formulary_yn.value);			
		}
		else{
			frmObj.qty_value.disabled=false;
			//frmObj.qty_value.focus(); // commented for IN21601reopen -- 03/06/2010 -- priya
		}
		if(	frmObj.qty_value.value!="")
			frmObj.qty_value.value = Math.abs(frmObj.qty_value.value );
	}
	else{
		alert(getMessage("PH_QTY_DESC","PH"));
		frmObj.split_dose.disabled=true;
		frmObj.sch_over_yn.value="Y";
		frmObj.qty_desc.focus();
		return false;
	}
}

function freqChange(obj,flag,calledFrom) { //calledFrom added for SKR-SCF-1302
	if(document.prescription_amend_detail_form==undefined)
		frmobj = document.prescription_detail_form;
	else
		frmobj = document.prescription_amend_detail_form;
//ML-MMOH-CRF-1531 - start
	var def_durn_desc = frmobj.durn_desc.value;
	var all_durn_type_app = frmobj.all_durn_type_app.value;
	
	if(all_durn_type_app="true")
		def_durn_type = def_durn_desc;
	
//ML-MMOH-CRF-1531 - end

	if(frmobj.qty_value.value==''){
		frmobj.qty_value.value='0';
	}
	var qty_value=frmobj.qty_value.value;
	if(parseFloat(qty_value)==0 || qty_value=="") {
		alert(getMessage("PRES_DOSAGE_CANNOT_ZERO","PH"));
		frmobj.qty_value.value='0';
		frmobj.qty_value.focus();
		return ;
	}
	frmobj.qty_value.value = parseFloat(qty_value);// Math.abs(parseFloat(qty_value));
	populateDurationDesc(obj);
	checkForPRN(obj);
	if( calledFrom == 'ChangeFreq' ) 
		checkDuplicateDrug();//Added for IN:073485
//	validateamendDosageLimit('true','feqchange');
	if(flag=="M"){
		flag="Y";
	}
	else{
		if(frmobj.dosage.value=="A" || frmobj.freq_nature.value=="P" ) {
		//	deleteScheduleLink(); //check
			DisableSchedule1();
			storeSchedule();
			//Added If else condition for the incident number  22437 for prn remarks mandatory symbol(Onchange of frequency symbol is not coming) on 01-July-2010
			if(document.prescription_amend_detail_form.man_rem_on_prn_freq_yn.value == 'Y'){
				document.getElementById('prn_remarks_image').style.visibility	= "visible";
			}		
			else{
				document.getElementById('prn_remarks_image').style.visibility	= "hidden";
			}
		}
		else { 
		//	deleteScheduleLink(); //check
			DisableSchedule1();
			storeSchedule();
		}
	}
/*	if(flag=='Y'){
		if(!(document.getElementById('prescription_amend_detail_form').strength_value.value==null || document.getElementById('prescription_amend_detail_form').strength_value.value=='')){
			document.getElementById('prescription_amend_detail_form').qty_value.value=document.getElementById('prescription_amend_detail_form').strength_value.value;
		}
	}*/

	if(document.prescription_amend_detail_form.tmp_durn_value != undefined){
		//reloadDurnTypeList();  //commented for reloading durntypelist ---08/07/2010-- priya
		populateAmendEndDate();
	}
	//added for SKR-SCF-1302 -start
	if(calledFrom=='ChangeFreq'){
			
			if( document.prescription_amend_detail_form.freq_nature.value=="O" ){ 
				document.prescription_amend_detail_form.priority.value=getLabel("Common.urgent.label","Common");
			}else{
				document.prescription_amend_detail_form.priority.value=getLabel("Common.routine.label","Common");
			}
	}	
		//added for SKR-SCF-1302 - end
	if(document.prescription_amend_detail_form.freq_nature.value=="P" || document.prescription_amend_detail_form.freq_nature.value=="O"){
		document.prescription_amend_detail_form.durn_desc.disabled = true;
		document.prescription_amend_detail_form.tmp_durn_value.value = document.prescription_amend_detail_form.durn_value.value; // added for IN22686 -- 16/07/2010-- priya -to calc qty when freq changed from prn to stat
	}
//ML-MMOH-CRF-1531 - start
	if(calledFrom=='ChangeFreq'){
		var durn_desc_found = false;
		var freqDurntype = document.prescription_amend_detail_form.durn_desc.value;
	
	 if(all_durn_type_app="true" && document.prescription_amend_detail_form.freq_nature.value!="O" && document.prescription_amend_detail_form.freq_nature.value!="P"){
		var interval_value = frmobj.interval_value.value;
		 if(document.prescription_amend_detail_form.freq_nature.value=="F" && interval_value>1){
			durn_desc_found = false;
		 }else{
			 var len1 = document.prescription_amend_detail_form.durn_desc.options.length;
			for(indx=0;indx<len1;indx++){
				if(document.prescription_amend_detail_form.durn_desc.options[indx].value==def_durn_desc){
					document.prescription_amend_detail_form.durn_desc.selectedIndex= indx;
					durn_desc_found =true;
					break;
				}
			}
		 }
			if(durn_desc_found && freqDurntype!=def_durn_desc){
	
				document.prescription_amend_detail_form.durn_desc.onchange();
			}
	 }
	}
//ML-MMOH-CRF-1531 - end
}

function checkForPRN(obj) {
	var curr_freq_nature = document.prescription_amend_detail_form.freq_nature.value;
	var def_freq_nature = document.prescription_amend_detail_form.prev_freq_nature.value;
	if(curr_freq_nature=="P") {
		document.prescription_amend_detail_form.absol_qty.disabled	=	false;
		document.prescription_amend_detail_form.absol_qty.value		=	document.prescription_amend_detail_form.prn_dose.value;
		document.prescription_amend_detail_form.absol_qty.style.visibility ="visible";
		document.getElementById('ord_qty_lbl').style.visibility	= "visible";
		document.getElementById('ord_qty_uom').style.visibility	= "visible";
			document.getElementById('prn_remarks').style.visibility	= "visible";
			if(document.prescription_amend_detail_form.prn_yn.value =='Y'){
			  document.getElementById('prn_remarks_image').style.visibility	= "visible";
			}
			else{
               document.getElementById('prn_remarks_image').style.visibility	= "hidden";
			}
			document.getElementById('dis_split_dose').style.visibility	= "hidden";
	}
	else {
		if(document.prescription_amend_detail_form.dosage.value!="A") {
			document.prescription_amend_detail_form.absol_qty.value		=	"";		
			document.prescription_amend_detail_form.absol_qty.style.visibility ="hidden";
			document.getElementById('ord_qty_lbl').style.visibility	= "hidden";
			document.getElementById('ord_qty_uom').style.visibility	= "hidden";
				document.getElementById('prn_remarks').style.visibility	= "hidden";
				document.getElementById('prn_remarks_image').style.visibility	= "hidden";
				document.getElementById('dis_split_dose').style.visibility	= "visible";
		}
	}
}

//function added for PRN Remarks
async function callPRNDetails(prn_remarks_code,prn_remarks_dtl){	
	
	var dialogHeight	= "70vh" ;
	var dialogWidth		= "70vw";
	var dialogTop		= "200" ;
	var dialogLeft		= "255" ;
	var center			= "1" ;
	var status			="no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";		
	var prn_yn					=  document.prescription_amend_detail_form.prn_yn.value
	var man_rem_on_prn_freq_yn  =  document.prescription_amend_detail_form.man_rem_on_prn_freq_yn.value;
	var	max_length_prn_reason   = parent.f_header.document.prescription_header_form.max_length_prn_reason.value
	
	
	retVal				= await window.showModalDialog("../../ePH/jsp/PrescriptionRemarksFrame.jsp?drug="+escape(document.prescription_amend_detail_form.drug_name.value)+"&patient_id="+document.prescription_amend_detail_form.patient_id.value+"&encounter_id="+document.prescription_amend_detail_form.encounter_id.value+"&drug_code="+document.prescription_amend_detail_form.drug_code.value+"&prn_yn="+prn_yn+"&called_from=PRNamend"+"&man_rem_on_prn_freq_yn="+man_rem_on_prn_freq_yn+"&max_length_prn_reason="+max_length_prn_reason,arguments,features);
	if(retVal=='OK'){
		document.prescription_amend_detail_form.prn_remarks_flag.value = "true";
    }
	else{
        document.prescription_amend_detail_form.prn_remarks_flag.value = "false";
	}
}

function validatePRNRemarkAmend() {
	
	
	drug_name			=	parent.frames[0].document.PrescriptionPRNRemarksForm.drug_code.value;
	drug				=	parent.frames[0].document.PrescriptionPRNRemarksForm.drug.value;
	bean_id				=	parent.frames[0].document.PrescriptionPRNRemarksForm.bean_id.value;
	bean_name			=	parent.frames[0].document.PrescriptionPRNRemarksForm.bean_name.value;
	remarks				=	parent.frames[0].document.PrescriptionPRNRemarksForm.remarks.value;	
	prn_yn				=	parent.frames[0].document.PrescriptionPRNRemarksForm.prn_yn.value;	
	man_rem_on_prn_freq_yn	= parent.frames[0].document.PrescriptionPRNRemarksForm.man_rem_on_prn_freq_yn.value;
	max_length_prn_reason   = parent.frames[0].document.PrescriptionPRNRemarksForm.max_length_prn_reason.value;	
	
	remarks_code = "";
	if(parent.frames[0].document.PrescriptionPRNRemarksForm.prnRemCode.disabled == false)
		remarks_code			=	parent.frames[0].document.PrescriptionPRNRemarksForm.prnRemCode.value;	
	if(remarks.length > max_length_prn_reason){
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",'Remarks');
		msg = msg.replace("#",max_length_prn_reason); 
		alert(msg);
		parent.frames[0].document.PrescriptionPRNRemarksForm.remarks.select();
		parent.frames[0].document.PrescriptionPRNRemarksForm.remarks.focus();
		return;
	}

	var fields			= new Array() ;
	var names			= new Array() ;


	if(man_rem_on_prn_freq_yn=='Y' || man_rem_on_prn_freq_yn=='N'){ //added condition on 01/july/2010 for the incident number 22437 sandhya
		//if(prn_yn=='Y'){ //commented on 1/july/2010 for the incident 22437 sandhya
		 fields[0]			= parent.frames[0].document.PrescriptionPRNRemarksForm.remarks ;
		 names[0]			= "Remarks" ;
	}
	

	
//if(trimCheck(remarks)) {
//	if(checkFlds( fields, names)){
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "remarks =\"" +encodeURIComponent(remarks) + "\" " ;
		xmlStr+= "drug_code =\"" + drug_name + "\" " ;
		xmlStr+= "remarks_code =\"" + remarks_code + "\" " ;
//		xmlStr+= "drug =\"" + drug + "\" " ;
		xmlStr+= "bean_id =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PrescriptionValidation_2.jsp?func_mode=PRNRemarks";//PrescriptionValidation_1.jsp  to PrescriptionValidation_2.jsp for SKR-SCF-1183
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);

//	}

   if(!trimCheck(fields[0].value)) {
		//if(trimCheck(remarks)) { commented on july 1st 2010
			if(man_rem_on_prn_freq_yn == 'Y'){
				alert(getMessage("REMARKS_CANNOT_BLANK","PH"));
				return false;
			}else{
				window.close();	
				window.returnValue="OK";
			}
		//} commented on july 1st 2010
   }else{
		window.close();	
		window.returnValue="OK";
	}
}

function setPrevFreqNature(freq_nature){
	if(document.prescription_amend_detail_form.prev_freq_nature.value==""){
		document.prescription_amend_detail_form.prev_freq_nature.value=freq_nature;
	}
}

function populateDurationDesc(obj){
	var freq_code		=	obj.value;
	var patient_class	=	parent.f_header.document.prescription_header_form.patient_class.value;

	if(patient_class=="IP"){
		if(parent.f_header.document.prescription_header_form.take_home_medication.value=="Y")
			patient_class="OP";
	}
	var drug_code=document.prescription_amend_detail_form.drug_code.value;
	var fldString=" freq_code=\""+ freq_code + "\" ";
	var formobj=document.prescription_amend_detail_form;
	var xmlStr=formXMLString(formobj,fldString);
	return fieldValidation(xmlStr,"populateDurationDesc");
}

function dfltDurnDesc(repeat_durn_type){
	var frmobj = "";
	if(document.prescription_amend_detail_form == undefined)
		frmobj = document.prescription_detail_form;
	else
		frmobj = document.prescription_amend_detail_form;

	if(repeat_durn_type=="L"){
		frmobj.durn_desc.value="L";
//		frmobj.durn_desc.disabled=true;
	}
	if(repeat_durn_type=="W"){
		frmobj.durn_desc.value="W";
//		frmobj.durn_desc.disabled=true;
	}
	if(repeat_durn_type=="D"){
		frmobj.durn_desc.value="D";
//		frmobj.durn_desc.disabled=true;
	}
	if(repeat_durn_type=="H"){
		frmobj.durn_desc.value="H";
//		frmobj.durn_value.value="1";
//		frmobj.durn_desc.disabled=true;
	//	frmobj.calcualted_durn_value.value="1";
	}
	if(repeat_durn_type=="M"){
		frmobj.durn_desc.value="M";
	//	frmobj.durn_value.value="1";
//		frmobj.durn_desc.disabled=true;
	}
	if(repeat_durn_type=="Y"){
		frmobj.durn_desc.value="Y";
	//	frmobj.durn_value.value="1";
//		frmobj.durn_desc.disabled=true;
	}

	durationConversn(document.prescription_amend_detail_form.durn_desc);//uncommented for reloading durntypelist ---08/07/2010-- priya
/*=================================================================================================================*/
var interval_value = frmobj.interval_value.value; //added 
var freq_nature = frmobj.freq_nature.value;
	if(freq_nature=="F" && interval_value>1 ){ 
		//ML-MMOH-CRF-1531 - start
		var all_durn_type_app = frmobj.all_durn_type_app.value;
		if(all_durn_type_app=="true")
		frmobj.durn_desc.value = repeat_durn_type;
		//ML-MMOH-CRF-1531 - end
		frmobj.durn_desc.disabled=true; 

		frmobj.durn_value.focus(); //added 
	}
/*=================================================================================================================*/

}

function assignDurnDesc(repeat_value,repeat_durn_type,freq_nature,interval_value,durn_desc,freq_value,schedule_yn){
	document.prescription_amend_detail_form.repeat_durn_type.value = repeat_durn_type; //added for reloading durntypelist ---08/07/2010-- priya
	document.prescription_amend_detail_form.freq_durn_type.value = repeat_durn_type;
	document.prescription_amend_detail_form.interval_value.value = interval_value; //Added for TFS-7506
	if(freq_value=="null" || freq_value==null) 
		freq_value=="0";
	
	if(document.prescription_amend_detail_form == undefined)
		frmobj = document.prescription_detail_form;
	else
		frmobj = document.prescription_amend_detail_form;
	frmobj.freq_nature.value=freq_nature;
	var split_dose_yn	=	frmobj.split_dose_yn.value;
	var allow_chk		=	"Y";

	if(freq_nature=="O" || freq_nature=="P") 
		allow_chk="N";

	if(allow_chk=="Y" && schedule_yn=="Y"){
		if(frmobj.dosage.value=="A"){
			frmobj.split_dose.disabled=true;
		}
		else {
			if( frmobj.freq_status.value=="") //if condition added for ML-BRU-SCF-0725 [IN:038336]
				frmobj.split_dose.disabled=false;
		}
	}
	else {
		frmobj.split_dose.disabled=true;
	}
	frmobj.durn_value.disabled=false;
	reloadDurnTypeList(); //added for reloading durntypelist ---08/07/2010-- priya
	if(repeat_durn_type=="L"){
		frmobj.durn_desc.value="L";
//		frmobj.durn_desc.disabled=true;
	}
	if(repeat_durn_type=="W"){
		frmobj.durn_desc.value="W";
//		frmobj.durn_desc.disabled=true;
	}
	if(repeat_durn_type=="D"){
		frmobj.durn_desc.value="D";
//		frmobj.durn_desc.disabled=true;
	}
	if(repeat_durn_type=="H"){
		frmobj.durn_desc.value="H";  //priya
	//	frmobj.durn_value.value="1"; //priya
		//frmobj.durn_value.disabled=true;
//		frmobj.durn_desc.disabled=true;
		//frmobj.calcualted_durn_value.value="1";
	}
	if(repeat_durn_type=="M"){
		frmobj.durn_desc.value="M"; //priya
	//	frmobj.durn_value.value="1"; //priya
//		frmobj.durn_desc.disabled=true;
	}
	if(freq_nature=='O'){
		frmobj.durn_desc.value="D";
		frmobj.durn_value.value="1";
//		frmobj.durn_desc.disabled=true;
		frmobj.durn_value.disabled=true;
		interval_value="1";
		repeat_value="1";
	}
	else if(freq_nature=='P'){
		frmobj.durn_desc.value="D";
//		frmobj.durn_desc.disabled=true;
		frmobj.durn_value.disabled=false;
		interval_value	=	"1";
		repeat_value	=	"1";
	}
	frmobj.interval_value.value=interval_value;
	frmobj.repeat_value.value=repeat_value;
	

	if(repeat_durn_type!=null && repeat_durn_type!="") {
		frmobj.repeat_durn_type.value=repeat_durn_type;
	}
	else {
		frmobj.repeat_durn_type.value=frmobj.durn_desc.value;
	}
	frmobj.scheduled_yn.value=schedule_yn;
	populateAmendEndDate();
	//alert("@659 in js >>> freq_nature = "+freq_nature+" >>> interval_value = "+interval_value);
/*============================================================================================================*/
	if(freq_nature == "F" && interval_value > 1){
	//ML-MMOH-CRF-1531 - start
	var all_durn_type_app = frmobj.all_durn_type_app.value;	
	
	if(all_durn_type_app=="true") 
	 frmobj.durn_desc.value = frmobj.repeat_durn_type.value;
	//ML-MMOH-CRF-1531 - end			
			frmobj.durn_desc.disabled = true;
	}
/*============================================================================================================*/
}

function checkWtAndHt(frmObj){

	var formObject  = parent.f_header.document.prescription_header_form;
	var drug_db_dosecheck_yn = formObject.drug_db_dosecheck_yn.value;
	var ext_prod_id = document.prescription_amend_detail_form.ext_prod_id.value;

	if(drug_db_dosecheck_yn!="Y" || ext_prod_id==""){
	
		if(formObject.height!=undefined && formObject.height!=null && formObject.weight!=null) {
			var weight		= formObject.weight.value;
			var bsa			= formObject.bsa.value;

			if( formObject.weight.value.length > 0){// formObject.height.value.length > 0 && REMOVED FOR ML-MMOH-SCF-1142
				if(frmObj.recomm_yn.value=="Y") {
					document.getElementById('rec_legend').style.visibility='visible';
				}

				var dosage_std	=	frmObj.dosage_std.value;
				//var dosage_unit	=	frmObj.dosage_unit.value;//commented for ml-mmoh-crf-0978
				var dosage_unit	=	frmObj.dosage_unit_uom.value;//added for ml-mmoh-crf-0978
        
				if(frmObj.calc_by_ind.value=="A") {
					document.getElementById('rec_value').innerHTML	= dosage_std;
					document.getElementById('rec_uom').innerHTML		= dosage_unit;
				}
				else if(frmObj.calc_by_ind.value=="W") {
					var calc_value	=	parseInt(parseFloat(weight)*parseFloat(dosage_std));
					document.getElementById('rec_value').innerHTML	= calc_value;
					var dos_unit = dosage_unit.split("/");
					document.getElementById('rec_uom').innerHTML		= dos_unit[0];
				} 
				else if(formObject.height.value.length > 0 && frmObj.calc_by_ind.value=="B") {//formObject.height.value.length > 0 && ADDED FOR ML-MMOH-SCF-1142
					var calc_value	=	parseInt(parseFloat(bsa)*parseFloat(dosage_std));
					document.getElementById('rec_value').innerHTML	= calc_value;
					var dos_unit = dosage_unit.split("/");
					document.getElementById('rec_uom').innerHTML		= dos_unit[0];
				}
			}
		}
	}
}

async function showDrugProfile(patient_id,called_frm,encounter_id){//called_frm,encounter_id added for AAKH-CRF-0088.2/04 IN[62870]
	var patient_class   = parent.f_header.document.prescription_header_form.patient_class.value;//Added for AAKH-CRF-0088.2/04 IN[62870]
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "95vw" ;
	var dialogTop		= "10" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				=await top.window.showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+encodeURIComponent(patient_id)+"&pat_class="+patient_class+"&encounter_id="+encounter_id+"&called_frm=Prescription", arguments, features );//+"&pat_class="+pat_class+"encounter_id="+encounter_id+ added for AAKH-CRF-0088.2/04 IN[62870]
}

function setRecommendDosage(){
	
	document.prescription_amend_detail_form.qty_value.value = document.getElementById('rec_value').innerHTML;
	document.prescription_amend_detail_form.qty_value.focus();
	changedoseoverridevalue();
}

function changedoseoverridevalue(){
	//deleteScheduleLink(); // check
	//added for 34834 - start
	var qty_value=document.prescription_amend_detail_form.qty_value.value;
	if( qty_value==""|| parseFloat(qty_value)==0 ) {
		alert(getMessage("PRES_DOSAGE_CANNOT_ZERO", "PH"));
		document.prescription_amend_detail_form.qty_value.value='0';
		document.prescription_amend_detail_form.qty_value.focus();
		return false ;
	}
	//added for 34834 - end

	DisableSchedule1();
	storeSchedule();
	var ext_prod_id = document.prescription_amend_detail_form.ext_prod_id.value;
	var frameobj;
	if(parent.f_header==null) {
		frameobj	=	parent.parent.f_header;
	}
	else {
		frameobj	=	parent.f_header;
	}
	var drug_db_dosecheck_yn=frameobj.document.prescription_header_form.drug_db_dosecheck_yn.value;

	if(drug_db_dosecheck_yn != 'Y' || (ext_prod_id=="")){

		if(document.prescription_amend_detail_form.recomm_yn.value=="Y") {
			var patient_id=document.prescription_amend_detail_form.patient_id.value;
			var recc_dose	=document.getElementById('rec_value').innerHTML;
			var qty_value	=document.prescription_amend_detail_form.qty_value.value;
			var drug_code	= document.prescription_amend_detail_form.drug_code.value;
			var dosage_type = document.prescription_amend_detail_form.dosage_type.value;
			var srl_no		= document.prescription_amend_detail_form.srl_no.value;
			var bean_id		=	document.prescription_amend_detail_form.bean_id.value;
			var bean_name	=	document.prescription_amend_detail_form.bean_name.value;
			var freq_nature	=	document.prescription_amend_detail_form.freq_nature.value;
			var repeat_value= "";
			if(oldrepeatvalue==undefined)
				repeat_value = document.prescription_amend_detail_form.repeat_value.value;
			else
				repeat_value =oldrepeatvalue;
			//Added for IN:070451 start
			var temp_qty ="";
			if(parent.f_header.document.prescription_header_form.height.value.length > 0 && parent.f_header.document.prescription_header_form.weight.value.length > 0){
				 if(document.prescription_amend_detail_form.calc_by_ind!=undefined){
					 if(document.prescription_amend_detail_form.calc_by_ind.value=="W") {
						temp_qty	=	(parseFloat(qty_value)/parseFloat(parent.f_header.document.prescription_header_form.weight.value));
					}
					else if(document.prescription_amend_detail_form.calc_by_ind.value=="B") {
						temp_qty	=	(parseFloat(qty_value)/parseFloat(parent.f_header.document.prescription_header_form.bsa.value));
						
				   }else
					 temp_qty=qty_value;
				 }else
					 temp_qty=qty_value;
			 }
			 if(temp_qty=="")
				 temp_qty = qty_value;
			 //Added for IN:070451 end

			var xmlStr ="<root><SEARCH ";
			xmlStr += " bean_id=\""+ bean_id + "\" ";
			xmlStr += " bean_name=\""+ bean_name + "\" ";
			//xmlStr += " limit_ind=\""+ limit_ind + "\" ";
			xmlStr += " drug_code=\""+ drug_code + "\" ";
			xmlStr += " srl_no=\""+ srl_no + "\" ";
			xmlStr+=" patient_id=\""+ patient_id + "\" ";
			xmlStr += " qty_value=\""+ temp_qty + "\" ";//Modified for IN:070451
			xmlStr += " dosage_type=\""+ dosage_type + "\" ";
			xmlStr += " repeat_value=\""+ repeat_value + "\" ";
			xmlStr += " freq_nature=\""+ freq_nature + "\" ";		
			xmlStr +=" /></root>";
			fieldValidation(xmlStr,"changeoverridevalue");
		}
	}
}

function disableoverride(limit_ind){
	dsg_reason = document.prescription_amend_detail_form.dsg_reason.value;
	dup_reason = document.prescription_amend_detail_form.dup_reason.value;
	alg_reason = document.prescription_amend_detail_form.alg_reason.value;
	interaction_exists = document.prescription_amend_detail_form.interaction_exists.value;
	interaction_remarks = document.prescription_amend_detail_form.interaction_remarks.value;
	abuse_exists = document.prescription_amend_detail_form.abuse_exists.value;
	abuse_action = document.prescription_amend_detail_form.abuse_action.value;
	abuse_remarks=document.prescription_amend_detail_form.abuse_override_remarks.value;
	if((limit_ind=='Y') &&(document.prescription_amend_detail_form.allergy_yn.value =='N')&& (document.prescription_amend_detail_form.current_rx.value == 'N') && interaction_exists!='Y'){
		//document.prescription_amend_detail_form.all.dosage_limit.style.visibility='hidden';
		document.prescription_amend_detail_form.dosage_limit.style.display="none"; 
		document.prescription_amend_detail_form.override_remarks.value="N";
	}
	else if((limit_ind=='N' && dsg_reason=="")||(document.prescription_amend_detail_form.allergy_yn.value =='Y' && alg_reason=="")|| (document.prescription_amend_detail_form.current_rx.value == 'Y' && dup_reason=="")||(interaction_exists=='Y' && interaction_remarks=='')|| (abuse_exists=='Y' && abuse_action=='B' && abuse_remarks=="" ) ){
		//document.prescription_amend_detail_form.all.dosage_limit.style.visibility='visible';
		document.prescription_amend_detail_form.dosage_limit.style='display'; 
		document.prescription_amend_detail_form.override_remarks.value="Y";
	}
}

function changeschedule(){
	    
	//deleteScheduleLink(); //check
	DisableSchedule1();
	storeSchedule();
	changedoseoverridevalue();
		
 }

 //function for displaying TDM Details
async function viewReasonforRequest(orderId,drug_code){
	
	var dialogHeight ='40vh' ;
	var dialogWidth = '60vh' ;
	var dialogTop	= '189';
	var dialogLeft = '167' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';		
	var arguments = "";
	var finalString	= "&readonly=readOnly&orderId="+orderId;
	var retVals = await window.showModalDialog("../../eOR/jsp/TDMReasonforrequest.jsp?"+finalString,arguments,features);
		
}

function ValidateAbs(obj) {
	if(parseInt(obj.value)==0 || obj.value=="") {
		alert(getMessage("ABS_QTY_CANNOT_ZERO","PH"));
		obj.focus();
		return;
		}
}
//functions related to FDB check
function extDosageCheck(callfrom){

	if(callfrom == 'onConfirm'){
		var formObj		=	parent.f_detail.document.prescription_amend_detail_form;
	}
	else{
		var formObj =	  document.prescription_amend_detail_form;
	}

	var header_formObj =	 parent.f_header.document.prescription_header_form;
	var drug_db_interface_yn =  header_formObj.drug_db_interface_yn.value;

	var drug_db_dosecheck_yn =  header_formObj.drug_db_dosecheck_yn.value;
	var drug_db_duptherapy_yn       =  header_formObj.drug_db_duptherapy_yn.value;
	var drug_db_interact_check_yn  =  header_formObj.drug_db_interact_check_yn.value;
	var drug_db_contraind_check_yn =  header_formObj.drug_db_contraind_check_yn.value;
	var drug_db_allergy_check_yn    =  header_formObj.drug_db_allergy_check_yn.value;

	if(drug_db_interface_yn == 'Y' ){
		var ext_prod_id = formObj.ext_prod_id.value;
		if(ext_prod_id != ""){
			var weight					=		header_formObj.weight.value;
			var bsa							=		header_formObj.bsa.value;
			var pract_name	=	encodeURIComponent(header_formObj.pract_name.value);

			var patient_id			=		formObj.patient_id.value;
			var encounter_id	=		formObj.encounter_id.value;
			var drug_code			=		formObj.drug_code.value;
			var srl_no					=		formObj.srl_no.value;
			var bean_id				=		formObj.bean_id.value;
			var bean_name		=		formObj.bean_name.value;
			var dosage					=		formObj.qty_value.value;
		//	var dose_uom			=		formObj.qty_desc.options[formObj.qty_desc.selectedIndex].value;
		//	var dosage_by			=		formObj.dosage.options[formObj.dosage.selectedIndex].value;
			var dose_uom			=		formObj.qty_desc.value;
			var dosage_by			=		formObj.dosage.value;
			var repeat_value		=		formObj.repeat_value.value;
			var interval_value	=		formObj.interval_value.value;
			var duration				=		formObj.durn_value.value;
			var split_dose_yn	=		formObj.split_dose_yn.value;

			var fract_dose_round_up_yn				= formObj.fract_dose_round_up_yn.value;
			var strength_per_pres_uom					= formObj.strength_per_pres_uom.value;
			var strength_per_value_pres_uom	= formObj.strength_per_value_pres_uom.value;
			//var ext_override_reason						= encodeURIComponent(formObj.ext_override_reason.value);
			var dsg_reason						= encodeURIComponent(formObj.dsg_reason.value);
			var dup_reason						= encodeURIComponent(formObj.dup_reason.value);
			var con_reason						= encodeURIComponent(formObj.con_reason.value);
			var int_reason						= encodeURIComponent(formObj.int_reason.value);
			var alg_reason						= encodeURIComponent(formObj.alg_reason.value);

			var repeat_durn_type = formObj.repeat_durn_type.value;//Code added for IN23562  --08/09/2010-- priya -start
			var tmp_durn_value = formObj.tmp_durn_value.value;
			var durn_type = formObj.tmp_durn_desc.value;
			var freq_nature =  formObj.freq_nature.value;//Code added for IN23562  --08/09/2010-- priya -end

			if(dosage_by.substring(0,1) == "S"){
				dose_uom = formObj.pres_base_uom.value;
			}

			if(weight == '' || weight == null)
				weight='0';
			if(bsa == '' || bsa == null)
				bsa='0';
			var route_code = formObj.route_code.value; //Added in January 2014 for Dosage check
			var qty_desc_code = formObj.qty_desc.value; //Added in January 2014 for Dosage check

			var xmlStr ="<root><SEARCH ";
			xmlStr += " patient_id=\""+ patient_id + "\" ";
			xmlStr += " encounter_id=\""+ encounter_id + "\" ";
			xmlStr += " drug_code=\""+ drug_code + "\" ";
			xmlStr += " srl_no=\""+ srl_no + "\" ";
			xmlStr += " bean_id=\""+ bean_id + "\" ";
			xmlStr += " bean_name=\""+ bean_name + "\" ";
			xmlStr += " ext_prod_id=\""+ ext_prod_id + "\" ";
			xmlStr += " weight=\""+ weight + "\" ";
			xmlStr += " bsa=\""+ bsa + "\" ";
			xmlStr += " dosage=\""+ dosage+ "\" ";
			xmlStr += " dose_uom=\""+ dose_uom + "\" ";
			xmlStr += " dosage_by=\""+ dosage_by + "\" ";
			xmlStr += " repeat_value=\""+ repeat_value + "\" ";
			xmlStr += " interval_value=\""+ interval_value + "\" ";
			xmlStr += " duration=\""+ duration + "\" ";
			xmlStr += " fract_dose_round_up_yn=\""+ fract_dose_round_up_yn + "\" ";
			xmlStr += " split_dose_yn=\""+ split_dose_yn + "\" ";
			xmlStr += " strength_per_pres_uom=\""+ strength_per_pres_uom + "\" ";
			xmlStr += " strength_per_value_pres_uom=\""+ strength_per_value_pres_uom + "\" ";
			//xmlStr += " ext_override_reason=\""+ ext_override_reason + "\" ";
			xmlStr += " pract_name=\""+ pract_name + "\" ";
			xmlStr += " dsg_reason=\""+ dsg_reason + "\" ";
			xmlStr += "dup_reason=\""+ dup_reason + "\" ";
			xmlStr += " con_reason=\""+ con_reason + "\" ";
			xmlStr += " int_reason=\""+ int_reason + "\" ";
			xmlStr += " alg_reason=\""+ alg_reason + "\" ";
			xmlStr += " repeat_durn_type=\""+ repeat_durn_type + "\" ";//Code added for IN23562 --08/09/2010-- priya -start
			xmlStr += " durn_type=\""+ durn_type + "\" ";
			xmlStr += " freq_nature=\""+ freq_nature + "\" ";
			xmlStr += " tmp_durn_value=\""+ tmp_durn_value + "\" ";//Code added for IN23562 --08/09/2010-- priya -end
			xmlStr += " drug_db_dosecheck_yn=\""+ drug_db_dosecheck_yn + "\" ";
			xmlStr += " drug_db_duptherapy_yn=\""+ drug_db_duptherapy_yn + "\" ";
			xmlStr += " drug_db_interact_check_yn=\""+ drug_db_interact_check_yn + "\" ";
			xmlStr += " drug_db_contraind_check_yn=\""+ drug_db_contraind_check_yn + "\" ";
			xmlStr += " drug_db_allergy_check_yn=\""+ drug_db_allergy_check_yn + "\" ";
			xmlStr += " callfrom=\""+ callfrom + "\" ";
			xmlStr += " route_code=\""+ route_code + "\" ";	  // Added in January 2014 for CIMS Dosage checks
 			xmlStr += " qty_desc_code=\""+ qty_desc_code + "\" ";	  // Added in January 2014 for CIMS Dosage checks
			xmlStr +=" /></root>";
			fieldValidation(xmlStr,"extDosageCheck");
		}
	}
}

function extDosageCheckFromPad(drug_code, srl_no, ext_prod_id, callfrom){
	if(callfrom == 'PAD')
		if(eval(document.getElementById("ext_ddb_override_indc"+srl_no)).className != "SHIFTTOTAL")
			return false;

	var header_formObj =	parent.parent.f_header.document.prescription_header_form;
    var drug_db_interface_yn       = header_formObj.drug_db_interface_yn.value;
	var drug_db_product_id = header_formObj.drug_db_product_id.value;
	var drug_db_dosecheck_yn =  header_formObj.drug_db_dosecheck_yn.value;
	var drug_db_duptherapy_yn       =  header_formObj.drug_db_duptherapy_yn.value;
	var drug_db_interact_check_yn  =  header_formObj.drug_db_interact_check_yn.value;
	var drug_db_contraind_check_yn =  header_formObj.drug_db_contraind_check_yn.value;
	var drug_db_allergy_check_yn    =  header_formObj.drug_db_allergy_check_yn.value;

	if(drug_db_interface_yn == 'Y' ){
		if(ext_prod_id != ""){
			var patient_id = header_formObj.patient_id.value;
			var encounter_id = header_formObj.encounter_id.value;
			var weight = header_formObj.weight.value;
			var bsa = header_formObj.bsa.value;
			
			var pract_name	=	encodeURIComponent(header_formObj.pract_name.value);

			if(weight == "")
				weight="0";
			if(bsa == "")
				bsa="0";
			var bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
			var bean_name		= "ePH.PrescriptionBean_1";
			var xmlStr ="<root><SEARCH ";
			xmlStr += " patient_id=\""+ patient_id + "\" ";
			xmlStr += " encounter_id=\""+ encounter_id + "\" ";
			xmlStr += " bean_id=\""+ bean_id + "\" ";
			xmlStr += " bean_name=\""+ bean_name + "\" ";
			xmlStr += " weight=\""+ weight + "\" ";
			xmlStr += " bsa=\""+ bsa + "\" ";

			xmlStr += " pract_name=\""+ pract_name + "\" ";
			xmlStr += " drug_code=\""+ drug_code + "\" ";
			xmlStr += " srl_no=\""+ srl_no + "\" ";
			xmlStr += " ext_prod_id=\""+ ext_prod_id + "\" ";
			xmlStr += " drug_db_product_id=\""+ drug_db_product_id + "\" ";
			xmlStr += " drug_db_dosecheck_yn=\""+ drug_db_dosecheck_yn + "\" ";
			xmlStr += " drug_db_duptherapy_yn=\""+ drug_db_duptherapy_yn + "\" ";
			xmlStr += " drug_db_interact_check_yn=\""+ drug_db_interact_check_yn + "\" ";
			xmlStr += " drug_db_contraind_check_yn=\""+ drug_db_contraind_check_yn + "\" ";
			xmlStr += " drug_db_allergy_check_yn=\""+ drug_db_allergy_check_yn + "\" ";
			xmlStr += " callfrom=\""+ callfrom + "\" ";
			xmlStr +=" /></root>";

			fieldValidation(xmlStr,"extDosageCheckFromPad");
		}
	}
}

async function displayDosageCheckResult(patient_id, pract_name, encounter_id, ext_prod_id, drug_code, srl_no, drug_db_dosage_check_flag, drug_db_duptherapy_flag, drug_db_contraind_check_flag, drug_db_interact_check_flag,  drug_db_allergy_flag, dsg_reason, dup_reason, con_reason, int_reason, alg_reason, callFrom){

	var dialogHeight	= "85vh" ;
	var dialogWidth	    = "70vw";
	var dialogTop	    = "100" ;
	var dialogLeft	    = "100" ;
	var center			= "0" ;
	var status			= "no";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	if(callFrom == 'onConfirm'){
		var formObj		=	parent.f_detail.document.prescription_amend_detail_form;
	}
	else{
		var formObj =	  document.prescription_amend_detail_form;
	}

	if(callFrom =='PADLOAD'){
		if(eval(document.getElementById("ext_ddb_override_indc"+srl_no)) != undefined){
			eval(document.getElementById("ext_ddb_override_indc"+srl_no)).className="SHIFTTOTAL";
			if( (drug_db_dosage_check_flag=="Y" && dsg_reason=="") || (drug_db_duptherapy_flag=="Y" && dup_reason=="")|| (drug_db_contraind_check_flag=="Y" && con_reason=="") || (drug_db_interact_check_flag=="Y" && int_reason=="")  || (drug_db_allergy_flag=="Y" && alg_reason=="")){
				eval(document.getElementById("ext_ddb_override_img"+srl_no)).style='display';
			}
			else
				eval(document.getElementById("ext_ddb_override_img"+srl_no)).style.display ="none";
		}
	}
	else if(callFrom !='PAD'){
		eval(parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_indc"+srl_no)).className="SHIFTTOTAL";
		eval(parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_img"+srl_no)).style='display';
		formObj.dsg_reason_yn.value = "N";

	}
//	if(drug_db_dosage_check_flag=='Y'){
	if(drug_db_dosage_check_flag=="Y" || drug_db_duptherapy_flag=="Y"||drug_db_contraind_check_flag=="Y"||drug_db_interact_check_flag=="Y"||drug_db_allergy_flag=="Y"){
//		if(callFrom =='PAD' || callFrom == 'onConfirm'){
		if(callFrom =='PAD'){

			retVal = await top.window.showModalDialog("../../ePH/jsp/MedicationAlerts.jsp?patient_id="+patient_id+"&pract_name="+pract_name+"&encounter_id="+encounter_id+"&external_product_id="+ext_prod_id+"&srl_no="+srl_no+"&drug_db_dosecheck_flag="+drug_db_dosage_check_flag+"&drug_db_interact_check_flag="+drug_db_interact_check_flag+"&drug_db_duptherapy_flag="+ drug_db_duptherapy_flag+"&drug_db_contraind_check_flag="+ drug_db_contraind_check_flag+"&drug_db_allergy_flag="+drug_db_allergy_flag+"&dsg_reason="+escape(dsg_reason)+"&dup_reason="+escape(dup_reason)+"&con_reason="+escape(con_reason)+"&int_reason="+escape(int_reason)+"&alg_reason="+escape(alg_reason),arguments,features);

			if(retVal != undefined && retVal[0] != 'CANCEL' ){

				var dsg_yn = "";
				var dsg_reason ="";
				var dup_yn = "";
				var dup_reason ="";
				var int_yn = "";
				var int_reason = ""; 
				var con_yn = "";
				var con_reason = "";
				var alg_yn = "";
				var alg_reason = "";

				for(var i=0;  i<retVal.length; i++){

					if( retVal[i].substring(0,3) == "DSG"){
						dsg_yn = retVal[i].substring(0,5);
						dsg_reason = retVal[i].substring(5);
					}
					else if( retVal[i].substring(0,3) == "DUP"){
						dup_yn = retVal[i].substring(0,5);
						dup_reason = retVal[i].substring(5);
					}
					else if( retVal[i].substring(0,3) == "INT"){
						int_yn = retVal[i].substring(0,5);
						int_reason = retVal[i].substring(5);
					}
					else if( retVal[i].substring(0,3) == "CON"){
						con_yn = retVal[i].substring(0,5);
						con_reason = retVal[i].substring(5);
					}
					else if( retVal[i].substring(0,3) == "ALG"){
						alg_yn = retVal[i].substring(0,5);
						alg_reason = retVal[i].substring(5);
					}
				}

				if( (dsg_yn=="DSG_Y" && dsg_reason=="") || (dup_yn=="DUP_Y" && dup_reason=="") || (int_yn=="INT_Y" && int_reason=="") || (con_yn=="CON_Y" && con_reason=="") || (alg_yn=="ALG_Y" && alg_reason=="")){
					if(callFrom !='PAD'){
						eval(parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_indc"+srl_no)).className ="SHIFTTOTAL";
						eval(parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_img"+srl_no)).style='display';
						formObj.dsg_reason_yn.value = "N";
						//extDosageCheck(callFrom)
					}
					else{
						eval(document.getElementById("ext_ddb_override_img"+srl_no)).style='display';
						alert(getMessage("OVERRIDE_REASON_NOT_BLANK","PH"));
						extDosageCheckFromPad(drug_code, srl_no, ext_prod_id, 'PAD')
						//return;
					}
				}
				else{
					if(callFrom !='PAD'){
						eval(parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_img"+srl_no)).style.display ="none";
						formObj.dsg_reason_yn.value = "Y";
					}
					else{
						eval(document.getElementById("ext_ddb_override_img"+srl_no)).style.display ="none";
					}
				}
				if(callFrom !='PAD'){
					var bean_id		=	formObj.bean_id.value;
					var bean_name	=	formObj.bean_name.value;
					formObj.dsg_reason.value = dsg_reason;
					formObj.dup_reason.value = dup_reason;
					formObj.int_reason.value = int_reason;
					formObj.con_reason.value = con_reason;
					formObj.alg_reason.value = alg_reason;
				}
				else{
					var bean_id		=	document.prescription_form.bean_id.value;
					var bean_name	=	document.prescription_form.bean_name.value;
				}

				var xmlStr ="<root><SEARCH ";					
				xmlStr+= "dsg_reason =\"" + encodeURIComponent(dsg_reason) + "\" " ;
				xmlStr+= "dup_reason =\"" + encodeURIComponent(dup_reason) + "\" " ;
				xmlStr+= "int_reason =\"" + encodeURIComponent(int_reason) + "\" " ;
				xmlStr+= "con_reason =\"" + encodeURIComponent(con_reason) + "\" " ;
				xmlStr+= "alg_reason =\"" + encodeURIComponent(alg_reason) + "\" " ;
				xmlStr+= "drug_db_dosage_check_flag =\"" +drug_db_dosage_check_flag + "\" " ;
				xmlStr+= "drug_db_interact_check_flag =\"" + drug_db_interact_check_flag+ "\" " ;
				xmlStr+= "drug_db_duptherapy_flag =\"" +drug_db_duptherapy_flag+ "\" " ;
				xmlStr+= "drug_db_contraind_check_flag =\"" + drug_db_contraind_check_flag+ "\" " ;
				xmlStr+= "drug_code =\"" + drug_code + "\" " ;
				xmlStr+= "srl_no =\"" + srl_no + "\" " ;
				xmlStr+= "bean_id =\"" + bean_id + "\" " ;
				xmlStr+= "bean_name=\"" + bean_name + "\" " ;
				xmlStr +=" /></root>";
				fieldValidation(xmlStr,"extDosageCheckResult");
			}
			else{
				if(callFrom =='PAD'){
					if(dsg_reason ==""){
						eval("document.prescription_form.ext_ddb_override_img"+srl_no).display="";
					}
					else{
						eval("document.prescription_form.ext_ddb_override_img"+srl_no).display="none";
					}
				}
				else if(dsg_reason ==""){
					eval(parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_indc"+srl_no)).className ="SHIFTTOTAL";
					eval(parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_img"+srl_no)).style='display';
					formObj.dsg_reason_yn.value='N';
				}

			}
		}
	}
}

function hideDosageCheckIcon(drug_code, srl_no){
	try{
		eval(parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_indc"+srl_no)).className = eval("parent.f_prescription.f_prescription_form.document."+drug_code+srl_no).className;
		eval(parent.f_prescription.f_prescription_form.document.getElementById("ext_ddb_override_img"+srl_no)).style.display ="none";
		var formObj =	  document.prescription_amend_detail_form;
		formObj.dsg_reason_yn.value='Y';
		formObj.dsg_reason.value = "";
	}
	catch (e){}
}

function changeCursor1(obj){
	if(obj.className == "SHIFTTOTAL")
		changeCursor(obj);
}

/******************************BILLING RELATED FUNCTIONS *********************************/
function getChargeDetails(in_formulary_yn, called_from,bl_override_excl_incl_ind_DB){

	if(in_formulary_yn=='N' || in_formulary_yn=='')
		return false;

	var frameobj;
	if(parent.f_header==null) {
		frameobj	=	parent.parent.f_header;
	}
	else {
		frameobj	=	parent.f_header;
	}
	var bl_install_yn				= frameobj.document.prescription_header_form.bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn	= frameobj.document.prescription_header_form.bl_disp_charge_dtl_in_rx_yn.value;
	var item_code					= document.prescription_amend_detail_form.item_code.value;
	//added for ML-MMOH-CRF-1531 - start
	var freq_durn_type		=	document.prescription_amend_detail_form.freq_durn_type.value;
	var durn_type			=   document.prescription_amend_detail_form.durn_desc.value;
	//added for ML-MMOH-CRF-1531 - end


	if(bl_install_yn!='Y' || bl_disp_charge_dtl_in_rx_yn!='Y' || item_code=='')
		return false;

	var patient_id      = frameobj.document.prescription_header_form.patient_id.value;
	var encounter_id	= frameobj.document.prescription_header_form.encounter_id.value;
	var order_Date      = frameobj.document.prescription_header_form.sys_date.value;
	/*var discharge_yn  = frameobj.document.prescription_header_form.take_home_medication.value;
	var episode_type = "";
	if(discharge_yn=='Y')
		episode_type = frameobj.document.prescription_header_form.patient_class.value;
	else*/
	var episode_type    = frameobj.document.prescription_header_form.actual_patient_class.value;

	if(episode_type!='')
		episode_type    = episode_type.substring(0,1);
	var durn_value	=	document.prescription_amend_detail_form.durn_value.value;// uncommented for SKR-SCF-1337
	//var durn_value	    = document.prescription_amend_detail_form.tmp_durn_value.value; commented for SKR-SCF-1337	
	if(durn_value == "")
		 durn_value	=	document.prescription_amend_detail_form.tmp_durn_value.value;//MODIFIED for SKR-SCF-1337
	//var qty_desc_code	= document.prescription_amend_detail_form.qty_desc.options[document.prescription_amend_detail_form.qty_desc.selectedIndex].value;
	var qty_desc_code	= document.prescription_amend_detail_form.qty_desc.value;
	var bl_override_excl_incl_ind	="";
	if(called_from =='ON_LOAD'){
	    bl_override_excl_incl_ind	=	bl_override_excl_incl_ind_DB;
	}else{
		bl_override_excl_incl_ind	=	document.prescription_amend_detail_form.bl_override_excl_incl_ind.value;

	}
	var bl_overriden_action_reason	= document.prescription_amend_detail_form.bl_incl_excl_override_reason_code.value;
	var qty_value					= document.prescription_amend_detail_form.qty_value.value;
	var drug_code					= document.prescription_amend_detail_form.drug_code.value;
	var dosage_type					= document.prescription_amend_detail_form.dosage_type.value;
	var srl_no						= document.prescription_amend_detail_form.srl_no.value;
	var repeat_value				= document.prescription_amend_detail_form.repeat_value.value;
	var interval_value				= document.prescription_amend_detail_form.interval_value.value;
	var billable_item_yn			= document.prescription_amend_detail_form.billable_item_yn.value;
	//var take_home_medication	=  frameobj.document.prescription_header_form.take_home_medication.value;//commented for  [IN:051852]
	var take_home_medication	= "N";//added for  [IN:051852] -start
	if(frameobj.document.prescription_header_form.take_home_medication.checked) 
		take_home_medication = "Y";//added for  [IN:051852] -End
	if((called_from!=undefined && called_from=="ABS_QTY")|| document.prescription_amend_detail_form.absol_qty.style.visibility== 'visible'){
		qty_value		= document.prescription_amend_detail_form.absol_qty.value;
		dosage_type		= "A";
	}

	var fldString=" patient_id=\""+ patient_id + "\" ";
		fldString += " encounter_id=\""+ encounter_id + "\" ";
		fldString += " episode_type=\""+ episode_type + "\" ";
		fldString += " qty_value=\""+ qty_value + "\" ";
		fldString += " qty_desc_code=\""+ qty_desc_code + "\" ";
		fldString += " dosage_type=\""+ dosage_type + "\" ";
		fldString += " repeat_value=\""+ repeat_value + "\" ";
		fldString += " interval_value=\""+ interval_value + "\" ";
		fldString += " drug_code=\""+ drug_code + "\" ";
		fldString += " srl_no=\""+ srl_no + "\" ";
		fldString += " durn_value=\""+ durn_value + "\" ";		
		fldString += " order_Date=\""+ order_Date + "\" ";		
		fldString += " bl_override_excl_incl_ind=\""+ bl_override_excl_incl_ind + "\" ";		
		fldString += " bl_overriden_action_reason=\""+ bl_overriden_action_reason + "\" ";		
		fldString += " called_from=\""+ called_from + "\" ";		
		fldString += " bl_override_excl_incl_ind_DB=\""+ bl_override_excl_incl_ind_DB + "\" ";	
		fldString += " billable_item_yn=\""+ billable_item_yn + "\" ";
		fldString +=" take_home_medication=\""+ take_home_medication+ "\" ";
		fldString +=" freq_durn_type=\""+ freq_durn_type+ "\" ";  //added for ML-MMOH-CRF-1531
		fldString +=" durn_type=\""+ durn_type+ "\" ";   //added for ML-MMOH-CRF-1531
		
	var formobj=document.prescription_amend_detail_form;
	var xmlStr=formXMLString(formobj,fldString);	
	fieldValidation(xmlStr,"getChargeDetails");
	return true;
}

/*function assignChargeDetails(bl_total_charge_amt, bl_patient_payable_amt, bl_def_excl_incl_ind, bl_approval_reqd_yn, bl_override_allowed_yn, bl_error_code, bl_sys_message_id, bl_error_text){
	if(bl_error_code=='' && bl_sys_message_id=='' && bl_error_text ==''){
		var bl_override_excl_incl_ind = bl_def_excl_incl_ind;
		document.getElementById("BL_HEADER").style.display='inline';
		document.getElementById("BL_VALUES").style.display='inline';
		document.getElementById("BL_HEADERBAR").style.display='inline';
		document.prescription_amend_detail_form.bl_def_override_excl_incl_ind.value =bl_def_excl_incl_ind;

		if(bl_override_allowed_yn !='Y'){
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.disabled=true;
		}
		else{
			if(document.prescription_amend_detail_form.bl_override_excl_incl_ind.value == ''){
				document.prescription_amend_detail_form.bl_override_excl_incl_ind.value = bl_def_excl_incl_ind;
			}
			bl_override_excl_incl_ind = document.prescription_amend_detail_form.bl_override_excl_incl_ind.value;
		}
		document.prescription_amend_detail_form.bl_override_excl_incl_ind.value = bl_override_excl_incl_ind;

		/*if(bl_override_excl_incl_ind == 'I'){
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.checked =true;
			//document.getElementById("bl_overriden_action_reason_img").style.visibility='visible';
		}*/
		/*document.getElementById("bl_total_charge_amt").innerHTML = bl_total_charge_amt;
		document.getElementById("bl_patient_payable_amt").innerHTML = bl_patient_payable_amt;

		document.prescription_amend_detail_form.bl_override_excl_incl_ind.style.display="inline";

		if(bl_approval_reqd_yn=='Y')
			document.getElementById("bl_approval_reqd_yn").innerHTML = "<img src='../../eCommon/images/enabled.gif'></img>";
		else if(bl_approval_reqd_yn=='N')
			document.getElementById("bl_approval_reqd_yn").innerHTML = "<img src='../../eCommon/images/disabled.gif'></img>" ;
		else
			document.getElementById("bl_approval_reqd_yn").innerHTML = "&nbsp" ;

		if(bl_def_excl_incl_ind=='I'){
			document.getElementById("bl_def_override_excl_incl_ind_gif").innerHTML = "<img src='../../eCommon/images/enabled.gif'></img>";
			document.getElementById("bl_override_excl_incl_ind_lbl").innerText = getLabel("Common.Exclude.label","Common")+"?";
		}
		else if(bl_def_excl_incl_ind=='E'){
			document.getElementById("bl_def_override_excl_incl_ind_gif").innerHTML = "<img src='../../eCommon/images/disabled.gif'></img>" ;
			document.getElementById("bl_override_excl_incl_ind_lbl").innerText = getLabel("Common.Include.label","Common")+"?";
		}
		else{
			document.getElementById("bl_def_override_excl_incl_ind_gif").innerHTML = "--" ;
			document.getElementById("bl_override_excl_incl_ind_lbl").innerText = getLabel("Common.Exclude.label","Common")+"?";
			//document.prescription_amend_detail_form.bl_override_excl_incl_ind.style.display="none";
			document.getElementById("td_bl_override_excl_incl_ind").innerHTML ="<input type='checkbox' name='bl_override_excl_incl_ind' id='bl_override_excl_incl_ind' value='' onclick='assignOverrideExclInclInd(this)' style='display:none;'>--" ;
		}
	}

}*/


function assignChargeDetails(gross_charge_amt,bl_total_charge_amt, bl_patient_payable_amt, bl_def_excl_incl_ind, bl_approval_reqd_yn, bl_override_allowed_yn, bl_error_code, bl_sys_message_id, bl_error_text,bl_override_excl_incl_ind_changed,called_from,bl_override_excl_incl_ind_DB){

	//gross_charge_amt added for ML-BRU-CRF-0469
	if(bl_error_code=='' && bl_sys_message_id=='' && bl_error_text ==''){
		var bl_override_excl_incl_ind = bl_def_excl_incl_ind;
		document.getElementById('BL_HEADER').style='display';
		document.getElementById('BL_VALUES').style='display';
		document.getElementById('BL_HEADERBAR').style='display';
		document.prescription_amend_detail_form.bl_def_override_excl_incl_ind.value =bl_def_excl_incl_ind;

        if(bl_override_allowed_yn =='I'){
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options.length =2;
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[0].value = 'SEL';
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[0].text = '----- '+getLabel("Common.defaultSelect.label", "Common")+' -----';
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[1].value = 'I';
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[1].text = getLabel("Common.Include.label", "Common");
		}
		else if(bl_override_allowed_yn =='E'){
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options.length =2;
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[0].value = 'SEL';
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[0].text = '----- '+getLabel("Common.defaultSelect.label", "Common")+' -----';
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[1].value = 'E';
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[1].text = getLabel("Common.Exclude.label", "Common");
		}
		else if(bl_override_allowed_yn =='B'){
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options.length =3;
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[0].value = 'SEL';
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[0].text = '----- '+getLabel("Common.defaultSelect.label", "Common")+' -----';
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[1].value = 'I';
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[1].text = getLabel("Common.Include.label", "Common");
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[2].value = 'E';
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[2].text = getLabel("Common.Exclude.label", "Common");
		}
		else{
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options.length =1;
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[0].value = 'SEL';
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.options[0].text = '----- '+getLabel("Common.defaultSelect.label", "Common")+' -----';
		}

		//if(bl_override_allowed_yn !='Y'){ //bl_override_allowed_yn == 'N' //commented By Naveen
		if(bl_override_allowed_yn ==''){ //bl_override_allowed_yn == 'N'
			document.prescription_amend_detail_form.bl_override_excl_incl_ind.disabled=true;
		}
		else{
			/*	//commented By Naveen
           if(document.prescription_detail_form.bl_override_excl_incl_ind.value == 'SEL'){
				document.prescription_detail_form.bl_override_excl_incl_ind.value = bl_def_excl_incl_ind;
			}
			bl_override_excl_incl_ind = document.prescription_detail_form.bl_override_excl_incl_ind.value;
			*/
					
           if(bl_override_excl_incl_ind_changed=='')
	             bl_override_excl_incl_ind_changed =bl_override_excl_incl_ind ;

            if(called_from =='ON_LOAD'){
				if((bl_override_allowed_yn=='I' && bl_override_excl_incl_ind_DB =='I') ||(bl_override_allowed_yn=='E' && bl_override_excl_incl_ind_DB =='E')||(bl_override_allowed_yn=='B' && bl_override_excl_incl_ind_DB =='I')){
					document.prescription_amend_detail_form.bl_override_excl_incl_ind.selectedIndex = 1;
				}else if(bl_override_allowed_yn=='B' && bl_override_excl_incl_ind_DB =='E'){
					document.prescription_amend_detail_form.bl_override_excl_incl_ind.selectedIndex = 2;
				}else{
					document.prescription_amend_detail_form.bl_override_excl_incl_ind.selectedIndex = 0;	
				}
			}
		}
		//document.prescription_detail_form.bl_override_excl_incl_inyd.value = bl_override_excl_incl_ind;
		if(document.getElementById('billable_item_yn').value == "N"){
			bl_total_charge_amt = "--";
			gross_charge_amt="--";//gross_charge_amt added for ML-BRU-CRF-0469
			bl_patient_payable_amt = "--";
		} 
		document.getElementById('gross_charge_amt').innerHTML    = gross_charge_amt;//gross_charge_amt added for ML-BRU-CRF-0469
		document.getElementById('bl_total_charge_amt').innerHTML    = bl_total_charge_amt;
		document.getElementById('bl_patient_payable_amt').innerHTML = bl_patient_payable_amt;
		document.prescription_amend_detail_form.bl_override_excl_incl_ind.style='display';

		if(bl_approval_reqd_yn=='Y')
			document.getElementById('bl_approval_reqd_yn').innerHTML = "<img src='../../eCommon/images/enabled.gif'></img>";
		else if(bl_approval_reqd_yn=='N')
			document.getElementById('bl_approval_reqd_yn').innerHTML = "<img src='../../eCommon/images/disabled.gif'></img>" ;
		else
			document.getElementById('bl_approval_reqd_yn').innerHTML = "&nbsp" ;
		// commented By Naveen
		if(bl_def_excl_incl_ind=='I'){
			document.getElementById('bl_def_override_excl_incl_ind_gif').innerHTML = "<img src='../../eCommon/images/enabled.gif'></img>";
			document.getElementById('bl_override_excl_incl_ind_lbl').innerText     = getLabel("Common.Exclude.label","Common")+"?";
			//document.getElementById("bl_override_excl_incl_ind").checked=false;
		}
		else if(bl_def_excl_incl_ind=='E'){
			document.getElementById('bl_def_override_excl_incl_ind_gif').innerHTML = "<img src='../../eCommon/images/disabled.gif'></img>" ;
			document.getElementById('bl_override_excl_incl_ind_lbl').innerText     = getLabel("Common.Include.label","Common")+"?";
		}
		/*else{
			document.getElementById('bl_def_override_excl_incl_ind_gif').innerHTML = "--" ;
			document.getElementById('bl_override_excl_incl_ind_lbl').innerText = getLabel("Common.Exclude.label","Common")+"?";
			document.getElementById('td_bl_override_excl_incl_ind').innerHTML ="<input type='checkbox' name='bl_override_excl_incl_ind' id='bl_override_excl_incl_ind' value='' onclick='assignOverrideExclInclInd(this)' style='display:none;'>--" ;
		}*/
		//assignOverrideExclInclInd(document.getElementById("bl_override_excl_incl_ind"));//priya
	}
}

function assignOverrideExclInclInd(obj){
	var bl_def_override_excl_incl_ind = document.prescription_amend_detail_form.bl_def_override_excl_incl_ind.value;
	/*if(bl_def_override_excl_incl_ind=='I' && obj.checked == true){
		obj.value = "E";
	}
	else if(bl_def_override_excl_incl_ind=='E' && obj.checked == true){
		obj.value = "I";
	}
	else 
		obj.value ="";*/
	 if(bl_def_override_excl_incl_ind != obj.value){
		document.getElementById('bl_overriden_action_reason_img').style.visibility='visible';
		document.prescription_amend_detail_form.bl_overriden_action_reason_lkp.disabled=false;
	}
	else{
		document.getElementById('bl_overriden_action_reason_img').style.visibility='hidden';
		document.prescription_amend_detail_form.bl_overriden_action_reason_lkp.disabled=true;
		document.prescription_amend_detail_form.bl_incl_excl_override_reason_code.value = "";
		document.prescription_amend_detail_form.bl_incl_excl_override_reason_desc.value = "" ;
	}

	getChargeDetails("Y");

/*	if(obj.checked == true){
		obj.value = "I";
	}
	else{
		obj.value = "E";
	}
	var bl_def_override_excl_incl_ind = document.prescription_amend_detail_form.bl_def_override_excl_incl_ind.value
	if(bl_def_override_excl_incl_ind != obj.value){
		document.getElementById('bl_overriden_action_reason_img').style.visibility='visible';
		document.prescription_amend_detail_form.bl_overriden_action_reason_lkp.disabled=false;
	}
	else{
		document.getElementById('bl_overriden_action_reason_img').style.visibility='hidden';
		document.prescription_amend_detail_form.bl_overriden_action_reason_lkp.disabled=true;
		document.prescription_amend_detail_form.bl_incl_excl_override_reason_code.value = "";
		document.prescription_amend_detail_form.bl_incl_excl_override_reason_desc.value = "" ;
	}
	getChargeDetails('Y');*/
}

async function searchBLOverrideReason(locale){

	var formObj=document.prescription_amend_detail_form;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
//	var sql1= "select action_reason_desc, action_reason_code from bl_action_reason_lang where Upper(action_reason_code) LIKE Upper(?) AND Upper(action_reason_desc) LIKE Upper(?) and nvl(status,'!') != 'S'"; 
	//var sql1 = "select  action_reason_code code,action_reason_desc description from bl_action_reason_lang a where nvl(status,'!') != 'S'  and exists (select b.action_type from bl_action_type b, bl_action_reason_by_type c where b.action_type = c.action_type and b.action_type = 'OV' and c.action_reason_code = a.action_reason_code and c.active_yn = 'Y') and upper(a.language_id) like Upper(?) AND Upper(a.action_reason_code) LIKE Upper(?) AND Upper(a.action_reason_desc) LIKE Upper(?) "
	var sql1 = formObj.sql_ph_prescription_bl_action_select_lookup.value;
   	
	dataNameArray[0]	="a.language_id";
	dataValueArray[0]	=locale;
	dataTypeArray[0]	=STRING;

	argumentArray[0]	= sql1;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = formObj.bl_incl_excl_override_reason_desc.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
	bean_id			   = formObj.bean_id.value;
	bean_name		   = formObj.bean_name.value;

	retVal = await CommonLookup(getLabel("Common.search.label","Common"), argumentArray);
	if(retVal != null && retVal != "") {
		document.prescription_amend_detail_form.bl_incl_excl_override_reason_code.value = retVal[0];
		document.prescription_amend_detail_form.bl_incl_excl_override_reason_desc.value =retVal[1] ;
	}
}

function getBLErrorDrugs(){

	var	frameobj	=	parent.parent.f_header.document.prescription_header_form;
	
	var patient_id=frameobj.patient_id.value;
	var encounter_id	=frameobj.encounter_id.value;
	var order_Date  = frameobj.sys_date.value;
	/*var discharge_yn  = frameobj.take_home_medication.value;
	var episode_type = "";
	if(discharge_yn=='Y')
		episode_type = frameobj.patient_class.value;
	else*/
	var episode_type = frameobj.actual_patient_class.value;

	if(episode_type!='')
		episode_type = episode_type.substring(0,1);

	var fldString=" patient_id=\""+ patient_id + "\" ";
	fldString += " encounter_id=\""+ encounter_id + "\" ";
	fldString += " episode_type=\""+ episode_type + "\" ";
	fldString += " order_Date=\""+ order_Date + "\" ";		
	
	var xmlStr			= formXMLString(frameobj,fldString);
	return fieldValidation(xmlStr,"getBLErrorDrugs");
}

function alertBLErrorDrugs(blErrorDrugs, mode){
	blErrorDrugs = blErrorDrugs.substring(1,blErrorDrugs.length-2);
	blErrorDrugs = blErrorDrugs.split(',');
	var BL_alert_msg="";
	for(var i=0; i<blErrorDrugs.length; i++){
		drug_code	= trimString(blErrorDrugs[i++]);
		srl_no		= trimString(blErrorDrugs[i++]);
		drug_desc	= trimString(blErrorDrugs[i++]);
		bl_error_code = trimString(blErrorDrugs[i++]);
		bl_sys_message_id = trimString(blErrorDrugs[i++]);
		bl_error_text = trimString(blErrorDrugs[i]);

		if ((bl_error_code == "10" && bl_error_text!="") || bl_sys_message_id!=""){
			if(bl_sys_message_id!=""){
				bl_error_text = getMessage(bl_sys_message_id,'BL');
			}
		}
		BL_alert_msg += drug_desc+"  "+ bl_error_text+"\n";
	}

	alert(BL_alert_msg);
	parent.window.close();
}
/****************************** BILLING RELATED FUNCTIONS END *********************************/

function getMAR_app_yn_1(headerFormObj){

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
/*******************************/

function routeChange(routeObj){
	document.prescription_amend_detail_form.route_code.value = routeObj.value;
}

function durationConversn(obj){

	var durn_value = document.prescription_amend_detail_form.durn_value.value;
	document.prescription_amend_detail_form.tmp_durn_value.value = document.prescription_amend_detail_form.durn_value.value; // added for IN22686 --16/07/2010-- priya
	var freq_nature = document.prescription_amend_detail_form.freq_nature.value;
	var repeat_durn_type = "";
	var tmp_durn_value   = "";

	if(freq_nature != "P" || freq_nature != 'O'){
//		repeat_durn_type = document.prescription_amend_detail_form.repeat_durn_type.value;
		repeat_durn_type = document.prescription_amend_detail_form.freq_durn_type.value;//tmp_durn_desc changed to freq_durn_type for tbmc-scf-0051 and SKR-SCF-1237
	// added for tbmc-scf-0051 and SKR-SCF-1237
		if(repeat_durn_type == null || repeat_durn_type == ""){
			repeat_durn_type = document.prescription_amend_detail_form.tmp_durn_desc.value;
		}
		if(repeat_durn_type == obj.value){
			tmp_durn_value = durn_value;
		}
		if(repeat_durn_type == 'M'){
			if(obj.value == 'H'){
				tmp_durn_value   = (durn_value * 60);	
			}else if(obj.value == 'D'){
				tmp_durn_value   = (durn_value * 24 * 60);	
			}else if(obj.value == 'W'){
				tmp_durn_value   = (durn_value * 7 * 24 * 60);	
			}else if(obj.value == 'L'){
				tmp_durn_value   = (durn_value * 30 * 24 * 60);	
			}else if(obj.value == 'Y'){
				tmp_durn_value   = (durn_value * 365 * 24 * 60);	
			}
		}else if(repeat_durn_type == 'H'){
			if(obj.value == 'D'){
				tmp_durn_value   = (durn_value * 24);	
			}else if(obj.value == 'W'){
				tmp_durn_value   = (durn_value * 7 * 24);	
			}else if(obj.value == 'L'){
				tmp_durn_value   = (durn_value * 30 * 24);	
			}else if(obj.value == 'Y'){
				tmp_durn_value   = (durn_value * 365 * 24);	
			}
		}else if(repeat_durn_type == 'D'){
			if(obj.value == 'W'){
				tmp_durn_value   = (durn_value * 7);	
			} else if(obj.value == 'L'){
				tmp_durn_value   = (durn_value * 30);	
			} else if(obj.value == 'Y'){
				tmp_durn_value   = (durn_value * 365);	
			}
		}else if(repeat_durn_type == 'W'){
			if(obj.value == 'L'){
				tmp_durn_value   = (durn_value * 4);	
			}else if(obj.value == 'Y'){
				tmp_durn_value   = (durn_value * 52);	
			}
		}else if(repeat_durn_type == 'L'){
			if(obj.value == 'Y'){
				tmp_durn_value   = (durn_value * 12);	
			}
		}

		document.prescription_amend_detail_form.tmp_durn_value.value = tmp_durn_value; 
		document.prescription_amend_detail_form.tmp_durn_desc.value = document.prescription_amend_detail_form.repeat_durn_type.value; //// priya 23/02/2010
		//validateDuration(document.prescription_detail_form.durn_value);
		validateamendDosageLimit('true', 'dosageCheck');// added for IN23562  --08/09/2010-- priya
	}
}

function assignDurnTypeList(DurnDescDetails){
	
	qty_val = document.prescription_amend_detail_form.qty_value.value;
	if(qty_val <1)
		document.prescription_amend_detail_form.qty_value.value = parseFloat(qty_val);
	durn_type_list = DurnDescDetails.substring(1,DurnDescDetails.length-1);

}

function reloadDurnTypeList(){
	var repeat_durn_type = document.prescription_amend_detail_form.repeat_durn_type.value;
	var freq_durn_type   = document.prescription_amend_detail_form.freq_durn_type.value;
	var all_durn_type_app = document.prescription_amend_detail_form.all_durn_type_app.value; //added for ML-MMOH-CRF-1531
	var freq_nature = document.prescription_amend_detail_form.freq_nature.value;
		repeat_durn_type =	freq_durn_type;

	var durnTypeList = durn_type_list.split(",");
	clearDurationTypeList();
	var durn_type_value = "";
	var durn_type_code  = "";
	if(repeat_durn_type == "" || repeat_durn_type == null || repeat_durn_type == "null" ){ // if block added for IN22686 --15/07/2010-- priya
		for(i=0;i<durnTypeList.length;i++){
			durn_type_value = durnTypeList[i].split("=");
			durn_type_code = trimString(durn_type_value[0]);
	
			if(freq_nature == 'P'){
				if(durn_type_code == 'D' || durn_type_code == 'W' || durn_type_code == 'L' || durn_type_code == 'Y'){
					addDurationTypeList(durn_type_code,durn_type_value[1],'D');			
				}
			}
			if(freq_nature == 'O'){
				if(durn_type_code == 'D'){
					addDurationTypeList(durn_type_code,durn_type_value[1],'D');			
				}
			}
		}
		document.prescription_amend_detail_form.durn_desc.value="D";	
		document.prescription_amend_detail_form.durn_desc.disabled=true;
		document.prescription_amend_detail_form.tmp_durn_value.value = document.prescription_amend_detail_form.durn_value.value; 
		return;
	}

	for(i=0;i<durnTypeList.length;i++){
	
		durn_type_value = durnTypeList[i].split("=");
		durn_type_code = trimString(durn_type_value[0]);

		if(repeat_durn_type == 'M'){
			if(durn_type_code == 'M' || durn_type_code == 'H' || durn_type_code == 'D' || durn_type_code == 'W' || (all_durn_type_app=="true" && (durn_type_code == 'L' || durn_type_code == 'Y'))){ //|| durn_type_code == 'L' || durn_type_code == 'Y' // commented for reloading durntypelist ---08/07/2010-- priya //modified for ML-MMOH-CRF-1531
				
				addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);			
			}
		} 
		else if(repeat_durn_type == 'H'){
			if(durn_type_code == 'H' || durn_type_code == 'D' || durn_type_code == 'W' || (all_durn_type_app=="true" && (durn_type_code == 'L' || durn_type_code == 'Y')) ){ //|| durn_type_code == 'L' || durn_type_code == 'Y' // commented for reloading durntypelist ---08/07/2010-- priya //modified for ML-MMOH-CRF-1531
				
				addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);			
			}
		} 
		else if(repeat_durn_type == 'D' ){
			if(durn_type_code == 'D' || durn_type_code == 'W' || durn_type_code == 'L' || durn_type_code == 'Y' || (all_durn_type_app=="true" && (durn_type_code == 'M' || durn_type_code == 'H'))){ //modified for ML-MMOH-CRF-1531
				
				
				addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);			
			}
		} 
		else if(repeat_durn_type == 'W' ){
			if(durn_type_code == 'W' || durn_type_code == 'L' || durn_type_code == 'Y' || (all_durn_type_app=="true" && (durn_type_code == 'M' || durn_type_code == 'H' || durn_type_code == 'D'))){ //modified for ML-MMOH-CRF-1531
				
				addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);			
			}
		}
		else if(repeat_durn_type == 'L' ){
			if(durn_type_code == 'L' || durn_type_code == 'Y' || (all_durn_type_app=="true" && (durn_type_code == 'M' || durn_type_code == 'H' || durn_type_code == 'D'))){ //modified for ML-MMOH-CRF-1531

				
				addDurationTypeList(durn_type_code,durn_type_value[1],repeat_durn_type);			
			}
		}
	}
	
	dfltDurnDesc(repeat_durn_type);
	if(document.prescription_amend_detail_form.taper_disabled.value=="" && document.prescription_amend_detail_form.freq_status.value=="") //for tapered & NPB_Drug_yn 
		document.prescription_amend_detail_form.durn_desc.disabled = false;
	maxDurnValidation(document.prescription_amend_detail_form.durn_value);
}

function clearDurationTypeList(){
	
	var len =document.prescription_amend_detail_form.durn_desc.options.length;
	for(var i=0;i<len;i++) {
		document.prescription_amend_detail_form.durn_desc.remove("durn_desc") ;
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
		document.prescription_amend_detail_form.durn_desc.add(element);
	}
}

function setFreqDurnType(freq_durn_type){
  if(document.prescription_amend_detail_form.calling_mode.value!="amend"){  // if condition added for ML-MMOH-SCF-0348 [IN-59190]
	document.prescription_amend_detail_form.freq_durn_type.value = freq_durn_type;
	document.prescription_amend_detail_form.tmp_durn_desc.value = freq_durn_type;
	dfltDurnDesc(freq_durn_type);
  }
}

//function assignValue added for SRR20056-SCF-7882 -29157
function assignValue(obj){
	if(obj.checked==true)
		obj.value="Y";		
	else
		obj.value="N";
}
function getActionText(route_code,form_code) //Add this function for SKR-CRF-0006[IN029561]	
{   
	var route_code = route_code.value;	
  	var bean_id				=	document.prescription_amend_detail_form.bean_id.value;
	var bean_name			=	document.prescription_amend_detail_form.bean_name.value;
	var xmlStr ="<root><SEARCH ";	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name =\"" + bean_name + "\" " ;	
	xmlStr += "form_code=\""+form_code +"\" " ;
	xmlStr += "route_code=\""+ route_code +"\" " ;			
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;	
	xmlHttp.open("POST","PrescriptionValidation_2.jsp?func_mode=getActiontext",false);
	xmlHttp.send( xmlDoc ) ;	
	eval(xmlHttp.responseText);	
}


function assignActionText(actionText){ //Add this function for SKR-CRF-0006[IN029561]
	document.getElementById('actionTextval').innerText=actionText;		 	
}
function getTotalTaperQty(in_formulary_yn, called_from){
	var tapperedYN				=	document.prescription_detail_form.tappered_over.value;
	if(tapperedYN!='Y')
		return false;
	if(called_from=='TAPER_QTY'){
		var totTapperQty	=	document.prescription_detail_form.totTapperQty.value;
		assignTotalTaperQty(totTapperQty)
		getChargeDetails(in_formulary_yn, 'TAPER_QTY');
		return;
	}
	var drug_code				=	document.prescription_detail_form.drug_code.value;
	var srl_no					=	document.prescription_detail_form.srl_no.value;
	var repeat_value			=	document.prescription_detail_form.repeat_value.value;
	var tmp_durn_value					=	document.prescription_detail_form.tmp_durn_value.value;
	var interval_value					=	document.prescription_detail_form.interval_value.value;
	var qty_desc_code					=   document.prescription_detail_form.qty_desc.value;	
	var qty_value						=   document.prescription_detail_form.qty_value.value;
	var dosage_type						=   document.prescription_detail_form.dosage_type.value;
  	var bean_id				=	document.prescription_detail_form.bean_id.value;
	var bean_name			=	document.prescription_detail_form.bean_name.value;
	var xmlStr ="<root><SEARCH ";	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	if(called_from == undefined)
		called_from = "ONCHANGE";
	xmlStr	="<root><SEARCH " ;
	xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name =\"" + bean_name + "\" " ;	
	xmlStr += " drug_code=\""+ drug_code + "\" ";
	xmlStr += " srl_no=\""+ srl_no + "\" ";
	xmlStr += " qty_value=\""+ qty_value + "\" ";
	//xmlStr += " qty_desc_code=\""+ qty_desc_code + "\" ";
	xmlStr += " repeat_value=\""+ repeat_value + "\" ";
	xmlStr += " durn_value=\""+ tmp_durn_value + "\" ";		
	xmlStr += " interval_value=\""+ interval_value + "\" ";		
	xmlStr += " called_from=\""+ called_from + "\" ";		
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;	
	xmlHttp.open("POST","PrescriptionValidation_1.jsp?func_mode=getTotalTaperQty",false);
	xmlHttp.send( xmlDoc ) ;	
	var validQty = eval(xmlHttp.responseText);	
	if(validQty){
		getChargeDetails(in_formulary_yn, 'TAPER_QTY');
	}
}

function assignTotalTaperQty(totTapperQty){
	var prevTotalTaperQty	=	document.prescription_detail_form.prevTotalTaperQty.value;
	var calc_dosg_by_freq_durn_yn = document.prescription_detail_form.calc_dosg_by_freq_durn_yn.value; //added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]
	if(calc_dosg_by_freq_durn_yn=='Y' && parseInt(totTapperQty)<parseInt(prevTotalTaperQty)){ //calc_dosg_by_freq_durn_yn=='Y' && --added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]
		document.prescription_detail_form.totTapperQty.value=prevTotalTaperQty;
		return false;
	}
	else{
		document.prescription_detail_form.totTapperQty.value=totTapperQty;
		return true;
	}
}
//Added for  ML-BRU-CRF-072[Inc:29938] start
async function drugindication_remarksAmend(){
	var formobj		=	document.prescription_amend_detail_form;
	var patient_id			=	document.prescription_amend_detail_form.patient_id.value;
	var encounter_id		=	document.prescription_amend_detail_form.encounter_id.value;
	var bean_id         = "@PrescriptionBean_1"+patient_id+encounter_id;		
	var bean_name		=parent.f_header. document.prescription_header_form.bean_name.value;
	var DrugIndicationRemarks	=	formobj.DrugIndicationRemarks.value;
	var drug_code	=	formobj.drug_code.value;		
	var dialogHeight= "50vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "10" ;
	var dialogLeft ="10";
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "" ;
	retVal =await window.showModalDialog("../../ePH/jsp/DrugIndicationRemarks.jsp?&DrugIndicationRemarks="+encodeURIComponent(DrugIndicationRemarks)+"&drug_code="+drug_code+"&bean_id="+bean_id+"&bean_name="+bean_name+"&mode=Amend",arguments,features);
	if(retVal!= undefined && retVal!=null)
		formobj.DrugIndicationRemarks.value=retVal;
}

function savedrugIndicationRemarks(drug_indicate){
	var drug_indication_new = encodeURIComponent(drug_indicate.value);
	window.returnValue=drug_indication_new;
	window.close();
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
//Added for ML-BRU-CRF-072[Inc:29938] end
async function chkPregnencyAlertForAmend(){
	var formobj=document.prescription_amend_detail_form;
	var pregnency_yn=document.prescription_amend_detail_form.pregnency_yn.value;
	var preg_effect=document.prescription_amend_detail_form.preg_effect.value;
	var pregnency_cat=document.prescription_amend_detail_form.pregnency_cat.value;
	var pregnency_cat_desc=document.prescription_amend_detail_form.pregnency_cat_desc.value;
	var preg_category_code=formobj.preg_category_code.value;
	var preg_warn_req_yn=formobj.preg_warn_req_yn.value;
	var trimester=formobj.trimester.value;
	var drug_desc=formobj.drug_name.value;
	var preg_remarks="";
	preg_remarks=document.prescription_amend_detail_form.preg_remarks.value;
	//preg_remarks= decodeURIComponent(preg_remarks,"UTF-8");
	if(pregnency_yn=="Y"){
		var dialogHeight= "45vh" ;
		var dialogWidth	= "55vw" ;
		var dialogTop	= "169" ;
		var center		= "1" ;
		var status		="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../ePH/jsp/PregnencyDrugEffectAlert.jsp?pregnency_cat="+pregnency_cat+"&preg_effect="+encodeURIComponent(preg_effect)+"&pregnency_cat_desc="+pregnency_cat_desc+"&preg_remarks="+preg_remarks+"&drug_desc="+drug_desc+"&preg_category_code="+preg_category_code+"&trimester="+trimester,arguments,features);
		if(retVal!=undefined || retVal!=null){
			pregRemarks = retVal;
			document.prescription_amend_detail_form.preg_remarks.value=pregRemarks;
		}
	}
}

function savePregRemarks(obj){
	var remarks		= encodeURIComponent(obj.preg_remarks.value);
	var retval="";
	if(remarks==""){
		alert(getMessage('PH_SELECT_PREG_OVERRIDE_RESONE','PH'));
		return;
	}
	window.returnValue=remarks;
}

function checkPregRemarksMaxLimit(obj,maxLeng) { 
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("ePH.OverrideReason.label","PH"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,maxLeng-1);
		alert(msg);
		obj.focus();
		return false;
	} 
	else 
		return true;
}// added for CRF RUT-CRF-0063[29601]--end

function assignBuildMAR(buildMAR_yn){ //Added for MMS-QH-CRF-0080 [IN:038064]
	 parent.parent.f_header.document.prescription_header_form.buildMAR_yn.value = buildMAR_yn;
}
function assignHomeDuration(){//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
	document.prescription_amend_detail_form.durn_value.onblur();
	var bean_id				=	document.prescription_amend_detail_form.bean_id.value;
	var bean_name			=	document.prescription_amend_detail_form.bean_name.value;
	var form_obj = parent.f_header.document.prescription_header_form;
	if(form_obj.home_leave_medication!=undefined && form_obj.home_leave_medication.checked && document.prescription_amend_detail_form.freq_nature.value != 'O'){
		var take_home_start = document.forms[0].take_home_start_date.value;
		var take_home_end = document.forms[0].take_home_end_date.value;
		var currstart_date = document.forms[0].start_date.value;
		var currend_date = document.forms[0].end_date.value;
		if(currend_date!=take_home_end || take_home_start!=currstart_date){
			var xmlStr	="<root><SEARCH " ;
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
			xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
			xmlStr += "take_home_start=\""+take_home_start +"\" " ;
			xmlStr += "currstart_date=\""+currstart_date +"\" " ;
			xmlStr += "take_home_end=\""+take_home_end +"\" " ;
			xmlStr += "currend_date=\""+currend_date +"\" " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "PrescriptionValidation_2.jsp?func_mode=calcHomeMedDurationAmend", false ) ;
			xmlHttp.send( xmlDoc ) ;	
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}
	}		
}//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end

function checkDuplicateDrug(){//Added for ML-BRU-SCF-1431 [IN:051136] -start
	var start_date		=	parent.f_detail.document.prescription_amend_detail_form.start_date.value;
	var durn_value		=	parent.f_detail.document.prescription_amend_detail_form.durn_value.value;
	var end_date		=	parent.f_detail.document.prescription_amend_detail_form.end_date.value;
	var patient_id	=	parent.f_detail.document.prescription_amend_detail_form.patient_id.value;
	var drug_code		=	parent.f_detail.document.prescription_amend_detail_form.drug_code.value;
	var srlNo			=	parent.f_detail.document.prescription_amend_detail_form.srl_no.value;
	var drug_db_interface_yn	=	parent.f_header.document.prescription_header_form.drug_db_interface_yn.value;
	var drug_db_duptherapy_yn	=	parent.f_header.document.prescription_header_form.drug_db_duptherapy_yn.value;
	var freq_code	=	parent.f_detail.document.prescription_amend_detail_form.freq_desc.value;//Added for IN:073485 
	if(durn_value!=''){
		var fldString="  start_date=\""+ start_date + "\" ";
		fldString += " durn_value=\""+ durn_value + "\" ";
		fldString += " end_date=\""+ end_date + "\" ";
		fldString += " patient_id=\""+ patient_id + "\" "; 
		fldString += " drug_code=\""+ drug_code + "\" ";
		fldString += " srlNo=\""+ srlNo + "\" ";
		fldString += " drug_db_interface_yn=\""+ drug_db_interface_yn + "\" ";
		fldString += " drug_db_duptherapy_yn=\""+ drug_db_duptherapy_yn + "\" "; 
		fldString += " freq_code=\""+ freq_code + "\" ";//Added for IN:073485 
		var formobj=parent.f_detail.document.prescription_amend_detail_form;
		var xmlStr=formXMLString(formobj,fldString);
		return fieldValidation(xmlStr,"checkDuplicateDrug");
	}
}

function showDuplicateInd(srlNo, currentrx, slidingScale_yn, drug_code, callFrom){
	var formDtlObj = document.prescription_amend_detail_form;
	var formFormObj = parent.f_prescription.f_prescription_form;
	if(currentrx == 'R'){ 
		formDtlObj.current_rx.value='Y';
		formDtlObj.dosage_limit.style='display';
		formDtlObj.override_remarks.style='display';
		eval(formFormObj.document.getElementById("currentrx"+srlNo)).innerHTML ="<img src='../../ePH/images/exceed1.gif'></img>";
		eval(formFormObj.document.getElementById("currentrx"+srlNo)).className = "CURRENTRX";
	}
	else{
		if(slidingScale_yn==undefined || slidingScale_yn=='N'){
			formDtlObj.current_rx.value='N';
			var doseOverride = formDtlObj.limit_ind.value; 
			var allergy = formDtlObj.allergy_yn.value; 
			var interaction_exists = formDtlObj.interaction_exists.value; 
			var abuse_exists = formDtlObj.abuse_override_remarks.value; 
			if( doseOverride!="N" && allergy!="Y" && interaction_exists!="Y" && abuse_exists!="Y"){
				formDtlObj.dosage_limit.style.display = "none";
				formDtlObj.override_remarks.style.display = "none";
			}
			eval(formFormObj.document.getElementById("currentrx"+srlNo)).innerHTML ="&nbsp;";
			//eval("formFormObj.document.getElementById("currentrx")"+srlNo).className = eval("formFormObj.document.all."+drug_code+srlNo).className;//commented for  IN51910
			eval(formFormObj.document.getElementById("currentrx"+srlNo)).className = formFormObj.document.getElementById(drug_code+srlNo).className;//added for  IN51910
		}
	}
} //Added for ML-BRU-SCF-1431 [IN:051136] -end
//added for AAKH-CRF-0140 start
async function showAbuseDtl(drug_code, srl_no, patient_id, encounter_id, intr_restric_trn,order_id,order_line_no){
	var retVal;
	var dialogTop		= "170"; 
 	var dialogHeight	= "62vh" ;
 	var dialogWidth		= "70vw" ;
	var dialogLeft		= "375" ;

	  if(order_id==undefined){
	   order_id = "";
	   order_line_no = "";
	  }

 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments		=getLabel("Common.DrugInteraction.label",'Common'); 
 	retVal 				=    await window.showModalDialog("../../ePH/jsp/PrescriptionOverrideReasonFrameset.jsp?called_from=normal&calledFrom=ABUSEDTLS&drug_code="+drug_code+"&srl_no="+srl_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&order_id="+order_id+"&order_line_no="+order_line_no,arguments,features);
}
//added for AAKH-CRF-0140 end

//Added for MMS-DM-CRF-0239 start
function showDiagnosisAlert()
{
	alert(getMessage("REQ_DIAG_PRES_NOT_FOUND",'PH'));
	deleteDrug();
	return;
}//Added for MMS-DM-CRF-0239 end

