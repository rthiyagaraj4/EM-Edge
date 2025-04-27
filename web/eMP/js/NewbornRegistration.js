var LocalErrors = new String();
var callfromfunctionsucc=''; 
async function create() {	
     var patientid=await PatientSearchWithDefaultGender('F','N');
     if(patientid != null)
         self.location.href = '../../eMP/jsp/NewbornRegistrationFirst.jsp?patient_id='+patientid;
}
/*Below function modified for this CRF- HSA-CRF-0182*/
function enDisCompls(objVal,clearValYN) {  
	var MC_Dtls_YN=document.getElementById('MC_Dtls_YN').value; 
	var nb_mother_dtls_update_yn=document.getElementById('nb_mother_dtls_update_yn').value; 
    var calling_module_id=document.getElementById('calling_module_id').value; 
	var disable_button_yn=document.getElementById('disable_button_yn').value;
    var finalizeY=document.getElementById('finalize_yn').value;	
	var regnStatus=document.getElementById('regnStatus').value;	
    var callfromfunction = '';
	if(parent.parent.f_query_add_mod){	
		callfromfunction = parent.parent.f_query_add_mod.frames[2].document.forms[0].function_id_mg.value;
	}else{
		callfromfunction = f_query_add_mod.frames[2].document.forms[0].function_id_mg.value;
	}
	if(objVal!="" && nb_mother_dtls_update_yn=="N") { 
		objVal = objVal.split("$");
		deliveryInd = objVal[1]; 	
		if(deliveryInd=='N') { 
			if(clearValYN == 'Y') { 
				document.getElementById('comple_ofdel_newborn').value = '';					
				document.getElementById('complns_1st_stage_labour_code').value = '';
				document.getElementById('complns_2nd_stage_labour_code').value = '';
				document.getElementById('complns_3rd_stage_labour_code').value = '';
			}
			if(MC_Dtls_YN=="Y"){  
				document.getElementById('comple_ofdel_newborn').value = '';
				document.getElementById('comple_ofdel_newborn').disabled = true;
				document.getElementById('comple_of_button').disabled = true; 
			}else{ 
				document.getElementById('comple_ofdel_newborn').disabled = true;
				document.getElementById('comple_of_button').disabled = true; 	
                document.getElementById('nod_type').disabled = false;  //Added for this    				
				document.getElementById('complns_1st_stage_labour_code').disabled = false;
				document.getElementById('complns_2nd_stage_labour_code').disabled = false;
				document.getElementById('complns_3rd_stage_labour_code').disabled = false;
				if(document.getElementById('isMPMandatoryFieldsNewborn').value=="true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_first_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_second_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" )  && document.getElementById('mandate_third_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_yn').value == "Y")){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y")){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				}
			}
		}else if(deliveryInd=='C') {  
			if(clearValYN == 'Y') {  
				document.getElementById('comple_ofdel_newborn').value = '';					
				document.getElementById('complns_1st_stage_labour_code').value = '';
				document.getElementById('complns_2nd_stage_labour_code').value = '';
				document.getElementById('complns_3rd_stage_labour_code').value = '';
			}
			if(MC_Dtls_YN=="Y"){  
				document.getElementById('complns_1st_stage_labour_code').value = '';
				document.getElementById('complns_2nd_stage_labour_code').value = '';
				document.getElementById('complns_3rd_stage_labour_code').value = '';
				document.getElementById('complns_1st_stage_labour_code').disabled = true;
				document.getElementById('complns_2nd_stage_labour_code').disabled = true;
				document.getElementById('complns_3rd_stage_labour_code').disabled = true;
	
				if(document.getElementById('isMPMandatoryFieldsNewborn').value == "true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if(document.getElementById('mandate_first_newborn_yn').value == "Y" || document.getElementById('mandate_second_newborn_yn').value == "Y" || document.getElementById('mandate_third_newborn_yn').value == "Y" || document.getElementById('mandate_first_newborn_ip_yn').value == "Y" || document.getElementById('mandate_second_newborn_ip_yn').value == "Y" || document.getElementById('mandate_third_newborn_ip_yn').value == "Y" || document.getElementById('mandate_first_newborn_ae_yn').value == "Y" || document.getElementById('mandate_second_newborn_ae_yn').value == "Y" || document.getElementById('mandate_third_newborn_ae_yn').value == "Y" ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'hidden';
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'hidden';
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'hidden';
				}
				}
			}else{  
			    document.getElementById('nod_type').disabled = false;  //Added for this 
				document.getElementById('comple_ofdel_newborn').disabled = false;
				document.getElementById('comple_of_button').disabled = false;			
				document.getElementById('complns_1st_stage_labour_code').disabled = true;
				document.getElementById('complns_2nd_stage_labour_code').disabled = true;
				document.getElementById('complns_3rd_stage_labour_code').disabled = true;
				if(document.getElementById('isMPMandatoryFieldsNewborn').value == "true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if(document.getElementById('mandate_first_newborn_yn').value == "Y" || document.getElementById('mandate_second_newborn_yn').value == "Y" || document.getElementById('mandate_third_newborn_yn').value == "Y" || document.getElementById('mandate_first_newborn_ip_yn').value == "Y" || document.getElementById('mandate_second_newborn_ip_yn').value == "Y" || document.getElementById('mandate_third_newborn_ip_yn').value == "Y" || document.getElementById('mandate_first_newborn_ae_yn').value == "Y" || document.getElementById('mandate_second_newborn_ae_yn').value == "Y" || document.getElementById('mandate_third_newborn_ae_yn').value == "Y" ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'hidden';
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'hidden';
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'hidden';
				}
				}
				
			}

		} else if(deliveryInd=='O') {  
			if(clearValYN == 'Y') { 
				document.getElementById('comple_ofdel_newborn').value = '';					
				document.getElementById('complns_1st_stage_labour_code').value = '';
				document.getElementById('complns_2nd_stage_labour_code').value = '';
				document.getElementById('complns_3rd_stage_labour_code').value = '';
			}
			if(MC_Dtls_YN=="Y"){  
			}else{  
			    document.getElementById('nod_type').disabled = false;  //Added for this 
				document.getElementById('comple_ofdel_newborn').disabled = false;
				document.getElementById('comple_of_button').disabled = false;			
				document.getElementById('complns_1st_stage_labour_code').disabled = false;
				document.getElementById('complns_2nd_stage_labour_code').disabled = false;
				document.getElementById('complns_3rd_stage_labour_code').disabled = false;
			}

		} 
	} //else if((objVal!="")&&(nb_mother_dtls_update_yn=="Y") &&(calling_module_id=="CA") || (objVal!="")&&(nb_mother_dtls_update_yn=="Y") &&(calling_module_id=="MP") || (objVal!="")&&(nb_mother_dtls_update_yn=="Y") &&(calling_module_id=="") || (objVal!="")&&(nb_mother_dtls_update_yn=="Y") &&(calling_module_id=="IP")) { alert('78');
		//else if(((objVal!="")&&(nb_mother_dtls_update_yn=="Y") && (disable_button_yn=="N")) &&((calling_module_id=="CA") || (calling_module_id=="MP") || (calling_module_id=="") || (calling_module_id=="IP"))) { 
		else if(((objVal!="")&&(nb_mother_dtls_update_yn=="Y") && (disable_button_yn=="N")) &&((calling_module_id=="CA") || (calling_module_id=="MP") || (calling_module_id=="") || (calling_module_id=="IP") || (calling_module_id=="AE"))) { //Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148]
		objVal = objVal.split("$"); 
		deliveryInd = objVal[1]; 	  
		if(deliveryInd=='N') { 
			if(clearValYN == 'Y') {  
			    document.getElementById('comple_ofdel_newborn').disabled = true;
				document.getElementById('comple_of_button').disabled = true; 		
				document.getElementById('complns_1st_stage_labour_code').disabled = false;
				document.getElementById('complns_2nd_stage_labour_code').disabled = false;
				document.getElementById('complns_3rd_stage_labour_code').disabled = false;
				document.getElementById('comple_ofdel_newborn').value = '';					
				document.getElementById('complns_1st_stage_labour_code').value = '';
				document.getElementById('complns_2nd_stage_labour_code').value = '';
				document.getElementById('complns_3rd_stage_labour_code').value = '';
				if(document.getElementById('isMPMandatoryFieldsNewborn').value=="true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_first_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_second_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" )  && document.getElementById('mandate_third_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_yn').value == "Y")){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y")){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				}
				
			}else{  
				document.getElementById('comple_ofdel_newborn').disabled = true;
				document.getElementById('comple_of_button').disabled = true; 		
				document.getElementById('complns_1st_stage_labour_code').disabled = false;
				document.getElementById('complns_2nd_stage_labour_code').disabled = false;
				document.getElementById('complns_3rd_stage_labour_code').disabled = false;
				
				document.getElementById('vaginal_del_type_desc').disabled = false;
				document.getElementById('vaginal_del_type_search').disabled = false;
				document.getElementById('proc_class_desc').disabled = false;
				document.getElementById('proc_id').disabled = false;
				document.getElementById('del_serv_desc').disabled = false;
				document.getElementById('del_serv_id').disabled = false;
				document.getElementById('nod_type').disabled = false; //Added for HSA-CRF-0182
				if(document.getElementById('isMPMandatoryFieldsNewborn').value=="true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_first_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_second_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" )  && document.getElementById('mandate_third_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_yn').value == "Y")){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y")){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				}
			}
		}else if(deliveryInd=='C') {  
			if(clearValYN == 'Y') {  
			   	document.getElementById('comple_ofdel_newborn').disabled = false;
				document.getElementById('comple_of_button').disabled = false;			
				document.getElementById('complns_1st_stage_labour_code').disabled = true;
				document.getElementById('complns_2nd_stage_labour_code').disabled = true;
				document.getElementById('complns_3rd_stage_labour_code').disabled = true;
				if(document.getElementById('isMPMandatoryFieldsNewborn').value == "true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if(document.getElementById('mandate_first_newborn_yn').value == "Y" || document.getElementById('mandate_second_newborn_yn').value == "Y" || document.getElementById('mandate_third_newborn_yn').value == "Y" || document.getElementById('mandate_first_newborn_ip_yn').value == "Y" || document.getElementById('mandate_second_newborn_ip_yn').value == "Y" || document.getElementById('mandate_third_newborn_ip_yn').value == "Y" || document.getElementById('mandate_first_newborn_ae_yn').value == "Y" || document.getElementById('mandate_second_newborn_ae_yn').value == "Y" || document.getElementById('mandate_third_newborn_ae_yn').value == "Y" ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'hidden';
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'hidden';
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'hidden';
				}
				}
				document.getElementById('comple_ofdel_newborn').value = '';					
				document.getElementById('complns_1st_stage_labour_code').value = '';
				document.getElementById('complns_2nd_stage_labour_code').value = '';
				document.getElementById('complns_3rd_stage_labour_code').value = '';
				
				document.getElementById('vaginal_del_type_desc').disabled = false;
				document.getElementById('vaginal_del_type_search').disabled = false;
				document.getElementById('proc_class_desc').disabled = false;
				document.getElementById('proc_id').disabled = false;
				document.getElementById('del_serv_desc').disabled = false;
				document.getElementById('del_serv_id').disabled = false;
				
				
			}else{  
				document.getElementById('comple_ofdel_newborn').disabled = false;
				document.getElementById('comple_of_button').disabled = false;			
				document.getElementById('complns_1st_stage_labour_code').disabled = true;
				document.getElementById('complns_2nd_stage_labour_code').disabled = true;
				document.getElementById('complns_3rd_stage_labour_code').disabled = true;
				if(document.getElementById('isMPMandatoryFieldsNewborn').value == "true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if(document.getElementById('mandate_first_newborn_yn').value == "Y" || document.getElementById('mandate_second_newborn_yn').value == "Y" || document.getElementById('mandate_third_newborn_yn').value == "Y" || document.getElementById('mandate_first_newborn_ip_yn').value == "Y" || document.getElementById('mandate_second_newborn_ip_yn').value == "Y" || document.getElementById('mandate_third_newborn_ip_yn').value == "Y" || document.getElementById('mandate_first_newborn_ae_yn').value == "Y" || document.getElementById('mandate_second_newborn_ae_yn').value == "Y" || document.getElementById('mandate_third_newborn_ae_yn').value == "Y" ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'hidden';
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'hidden';
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'hidden';
				}
				}
				document.getElementById('vaginal_del_type_desc').disabled = false;
				document.getElementById('vaginal_del_type_search').disabled = false;
				document.getElementById('proc_class_desc').disabled = false;
				document.getElementById('proc_id').disabled = false;
				document.getElementById('del_serv_desc').disabled = false;
				document.getElementById('del_serv_id').disabled = false;
				document.getElementById('nod_type').disabled = false; //Added for HSA-CRF-0182
			}

		} else if(deliveryInd=='O') {  
			if(clearValYN == 'Y') {  
				document.getElementById('comple_ofdel_newborn').value = '';					
				document.getElementById('complns_1st_stage_labour_code').value = '';
				document.getElementById('complns_2nd_stage_labour_code').value = '';
				document.getElementById('complns_3rd_stage_labour_code').value = '';
				document.getElementById('complns_1st_stage_labour_code').disabled = false;
				document.getElementById('complns_2nd_stage_labour_code').disabled = false;
				document.getElementById('complns_3rd_stage_labour_code').disabled = false;
				document.getElementById('vaginal_del_type_desc').disabled = false;
				document.getElementById('vaginal_del_type_search').disabled = false;
				document.getElementById('proc_class_desc').disabled = false;
				document.getElementById('proc_id').disabled = false;
				document.getElementById('del_serv_desc').disabled = false;
				document.getElementById('del_serv_id').disabled = false;
				if(document.getElementById('isMPMandatoryFieldsNewborn').value=="true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_first_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_second_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" )  && document.getElementById('mandate_third_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_yn').value == "Y")){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y")){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				}
			}else{
				document.getElementById('comple_ofdel_newborn').disabled = false;
				document.getElementById('comple_of_button').disabled = false;			
				document.getElementById('complns_1st_stage_labour_code').disabled = false;
				document.getElementById('complns_2nd_stage_labour_code').disabled = false;
				document.getElementById('complns_3rd_stage_labour_code').disabled = false;
				
				document.getElementById('vaginal_del_type_desc').disabled = false;
				document.getElementById('vaginal_del_type_search').disabled = false;
				document.getElementById('proc_class_desc').disabled = false;
				document.getElementById('proc_id').disabled = false;
				document.getElementById('del_serv_desc').disabled = false;
				document.getElementById('del_serv_id').disabled = false;
				document.getElementById('nod_type').disabled = false; //Added for HSA-CRF-0182
				if(document.getElementById('isMPMandatoryFieldsNewborn').value=="true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_first_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_second_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" )  && document.getElementById('mandate_third_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_yn').value == "Y")){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y")){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				}
			}

		} 
	}else {  
    	if(disable_button_yn=="N"){  
			 if(clearValYN == 'Y') { 
				  document.getElementById('comple_ofdel_newborn').value = '';					
				  document.getElementById('complns_1st_stage_labour_code').value = '';
				  document.getElementById('complns_2nd_stage_labour_code').value = '';
				  document.getElementById('complns_3rd_stage_labour_code').value = '';
             }			
			  document.getElementById('comple_ofdel_newborn').disabled = false;
			  document.getElementById('comple_of_button').disabled = false;			
			  document.getElementById('complns_1st_stage_labour_code').disabled = false;
			  document.getElementById('complns_2nd_stage_labour_code').disabled = false;
			  document.getElementById('complns_3rd_stage_labour_code').disabled = false;
			  if(document.getElementById('isMPMandatoryFieldsNewborn').value=="true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_first_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_second_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" )  && document.getElementById('mandate_third_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_yn').value == "Y")){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y")){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				}
		}	
		if(objVal!=""&&disable_button_yn=="Y" && regnStatus=="R" ){ 
		        document.getElementById('nod_type').disabled = false;
		        objVal = objVal.split("$");
		        deliveryInd = objVal[1];		       
		        if(deliveryInd=='O'){
				if(clearValYN == 'Y') {  
				document.getElementById('comple_ofdel_newborn').value = '';					
				document.getElementById('complns_1st_stage_labour_code').value = '';
				document.getElementById('complns_2nd_stage_labour_code').value = '';
				document.getElementById('complns_3rd_stage_labour_code').value = '';
				
				document.getElementById('vaginal_del_type_desc').disabled = false;
				document.getElementById('vaginal_del_type_search').disabled = false;
				document.getElementById('proc_class_desc').disabled = false;
				document.getElementById('proc_id').disabled = false;
				document.getElementById('del_serv_desc').disabled = false;
				document.getElementById('del_serv_id').disabled = false;
			}else{
				document.getElementById('comple_ofdel_newborn').disabled = false;
				document.getElementById('comple_of_button').disabled = false;			
				document.getElementById('complns_1st_stage_labour_code').disabled = false;
				document.getElementById('complns_2nd_stage_labour_code').disabled = false;
				document.getElementById('complns_3rd_stage_labour_code').disabled = false;
				document.getElementById('vaginal_del_type_desc').disabled = false;
				document.getElementById('vaginal_del_type_search').disabled = false;
				document.getElementById('proc_class_desc').disabled = false;
				document.getElementById('proc_id').disabled = false;
				document.getElementById('del_serv_desc').disabled = false;
				document.getElementById('del_serv_id').disabled = false;
				if(document.getElementById('isMPMandatoryFieldsNewborn').value=="true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_first_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_second_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_third_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_yn').value == "Y")){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y")){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				}
              }				
				}if(deliveryInd=='N'){
				if(clearValYN == 'Y') {  
			    document.getElementById('comple_ofdel_newborn').disabled = true;
				document.getElementById('comple_of_button').disabled = true; 		
				document.getElementById('complns_1st_stage_labour_code').disabled = false;
				document.getElementById('complns_2nd_stage_labour_code').disabled = false;
				document.getElementById('complns_3rd_stage_labour_code').disabled = false;
				document.getElementById('comple_ofdel_newborn').value = '';					
				document.getElementById('complns_1st_stage_labour_code').value = '';
				document.getElementById('complns_2nd_stage_labour_code').value = '';
				document.getElementById('complns_3rd_stage_labour_code').value = '';
				
				document.getElementById('vaginal_del_type_desc').disabled = false;
				document.getElementById('vaginal_del_type_search').disabled = false;
				document.getElementById('proc_class_desc').disabled = false;
				document.getElementById('proc_id').disabled = false;
				document.getElementById('del_serv_desc').disabled = false;
				document.getElementById('del_serv_id').disabled = false;
				if(document.getElementById('isMPMandatoryFieldsNewborn').value=="true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_first_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_second_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" )  && document.getElementById('mandate_third_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_yn').value == "Y")){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y")){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				}
			}else{
				
		      	document.getElementById('comple_ofdel_newborn').disabled = true;
				document.getElementById('comple_of_button').disabled = true; 		
				document.getElementById('complns_1st_stage_labour_code').disabled = false;
				document.getElementById('complns_2nd_stage_labour_code').disabled = false;
				document.getElementById('complns_3rd_stage_labour_code').disabled = false;
				document.getElementById('vaginal_del_type_desc').disabled = false;
				document.getElementById('vaginal_del_type_search').disabled = false;
				document.getElementById('proc_class_desc').disabled = false;
				document.getElementById('proc_id').disabled = false;
				document.getElementById('del_serv_desc').disabled = false;
				document.getElementById('del_serv_id').disabled = false;
				if(document.getElementById('isMPMandatoryFieldsNewborn').value=="true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_first_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" ) && document.getElementById('mandate_second_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((callfromfunction == "REGISTER_NEWBORN" && (calling_module_id == "" || calling_module_id == "MP" )  && document.getElementById('mandate_third_newborn_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('mp_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_yn').value == "Y")){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_first_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_second_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "AE" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('emer_regn_nb').value == "Y" && document.getElementById('mandate_third_newborn_ae_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_first_newborn_ip_yn').value == "Y")){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_second_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'Visible';
				}
				if((calling_module_id == "IP" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") || (callfromfunction == "MAINTAIN_BIRTH" && document.getElementById('ip_regn_nb_yn').value == "Y" && document.getElementById('mandate_third_newborn_ip_yn').value == "Y") ){
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'Visible';
				}
				}
			}	
				
				}
				if(deliveryInd=='C'){
				if(clearValYN == 'Y') {  
			   	document.getElementById('comple_ofdel_newborn').disabled = false;
				document.getElementById('comple_of_button').disabled = false;			
				document.getElementById('complns_1st_stage_labour_code').disabled = true;
				document.getElementById('complns_2nd_stage_labour_code').disabled = true;
				document.getElementById('complns_3rd_stage_labour_code').disabled = true;
				if(document.getElementById('isMPMandatoryFieldsNewborn').value == "true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if(document.getElementById('mandate_first_newborn_yn').value == "Y" || document.getElementById('mandate_second_newborn_yn').value == "Y" || document.getElementById('mandate_third_newborn_yn').value == "Y" || document.getElementById('mandate_first_newborn_ip_yn').value == "Y" || document.getElementById('mandate_second_newborn_ip_yn').value == "Y" || document.getElementById('mandate_third_newborn_ip_yn').value == "Y" || document.getElementById('mandate_first_newborn_ae_yn').value == "Y" || document.getElementById('mandate_second_newborn_ae_yn').value == "Y" || document.getElementById('mandate_third_newborn_ae_yn').value == "Y" ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'hidden';
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'hidden';
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'hidden';
				}
				}
				document.getElementById('comple_ofdel_newborn').value = '';					
				document.getElementById('complns_1st_stage_labour_code').value = '';
				document.getElementById('complns_2nd_stage_labour_code').value = '';
				document.getElementById('complns_3rd_stage_labour_code').value = '';
				
				document.getElementById('vaginal_del_type_desc').disabled = false;
				document.getElementById('vaginal_del_type_search').disabled = false;
				document.getElementById('proc_class_desc').disabled = false;
				document.getElementById('proc_id').disabled = false;
				document.getElementById('del_serv_desc').disabled = false;
				document.getElementById('del_serv_id').disabled = false;			
				
			}else{
				document.getElementById('comple_ofdel_newborn').disabled = false;
				document.getElementById('comple_of_button').disabled = false;			
				document.getElementById('complns_1st_stage_labour_code').disabled = true;
				document.getElementById('complns_2nd_stage_labour_code').disabled = true;
				document.getElementById('complns_3rd_stage_labour_code').disabled = true;
				document.getElementById('vaginal_del_type_desc').disabled = false;
				document.getElementById('vaginal_del_type_search').disabled = false;
				document.getElementById('proc_class_desc').disabled = false;
				document.getElementById('proc_id').disabled = false;
				document.getElementById('del_serv_desc').disabled = false;
				document.getElementById('del_serv_id').disabled = false;
				if(document.getElementById('isMPMandatoryFieldsNewborn').value == "true" || document.getElementById('isMPMandatoryFieldsNewborn').value == true){
				if(document.getElementById('mandate_first_newborn_yn').value == "Y" || document.getElementById('mandate_second_newborn_yn').value == "Y" || document.getElementById('mandate_third_newborn_yn').value == "Y" || document.getElementById('mandate_first_newborn_ip_yn').value == "Y" || document.getElementById('mandate_second_newborn_ip_yn').value == "Y" || document.getElementById('mandate_third_newborn_ip_yn').value == "Y" || document.getElementById('mandate_first_newborn_ae_yn').value == "Y" || document.getElementById('mandate_second_newborn_ae_yn').value == "Y" || document.getElementById('mandate_third_newborn_ae_yn').value == "Y" ){
				document.getElementById('complns_1st_stage_labour_code_img').style.visibility = 'hidden';
				document.getElementById('complns_2nd_stage_labour_code_img').style.visibility = 'hidden';
				document.getElementById('complns_3rd_stage_labour_code_img').style.visibility = 'hidden';
				}
				}
			}	
				}
				
		
		}//Added for HSA-CRF-0182
	}
}
/*Added By Dharma on Nov 10th 2016 against MO-CRF-20108 Start*/
async function NeonatalResuscitation(){
	var mother_patient_id	= document.getElementById("mother_patient_id").value;
	var mother_encounter_id = document.getElementById("mother_encounter_id").value;
	var acc_number			= document.getElementById("sel_accession_num").value;
	var facility_id			= document.getElementById("facility_id").value;
	var unitofwtnb			= document.getElementById("unitofwtnb").value;//added by vijayan for EDGE work

	if(mother_encounter_id==""){
		alert(getMessage('NEONATAL_ENCOUNTER_CONTEXT','MP'));
	}else{

		var isShowEditWindow	= "Y";

		/* For IP & MP register new born start*/
		if(document.getElementById('disable_finalized_button_yn').value=="Y"){
			isShowEditWindow	= "N";
		}else if(document.getElementById('disable_finalized_button_yn').value=="N"){
			isShowEditWindow	= "Y";
		}
		/* For IP & MP register new born end*/
		
		/*For Maintain birth register start*/
		if(parent.parent.frames[0].document.getElementById('apply')){
			if(parent.parent.frames[0].document.getElementById('apply').disabled){
				isShowEditWindow	= "N";
			}else{
				isShowEditWindow	= "Y";
			}
		}
		/*For Maintain birth register end*/
		
		if(isShowEditWindow=="Y"){
			var action_url = "../../eCA/jsp/ViewMotherLinkedNotesMain.jsp?resp_id=CA&patient_id="+mother_patient_id+"&encounter_id="+mother_encounter_id+"&patient_class=IP&appl_task_id=CLINICAL_NOTES&sel_accession_num="+acc_number+"";
			var features =	"dialogHeight:41; dialogWidth:82; dialogTop:80  ; scroll=no; status:no";
			var  arguments = "";
			var returnValue=await window.showModalDialog(action_url,arguments,features); 

			if(typeof returnValue !="undefined"){ 
				document.getElementById('sel_accession_num').value = returnValue ;
			}
		}else{
			var title="";
			var dialogHeight ='30' ;
			var dialogWidth = '49' ;
			var dialogTop	= '129';
			var dialogLeft = '260' ;	
			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no; top=50';
			var arguments = "";
			var action_url="../../eCA/jsp/RecClinicalNotesSearchMain.jsp?operations_allowed=PRINT&accession_num="+acc_number+"&facility_id="+facility_id; 
			await window.showModalDialog(action_url,arguments,features);
		}
	}
}

/*Added By Dharma on Nov 10th 2016 against MO-CRF-20108 End*/




async function callPatSearch(){
    var patientid=await PatientSearchWithDefaultGender('M','N');
    if(patientid!=null){
        self.document.forms[0].father_patient_id.value = patientid;
        self.document.forms[0].father_patient_name.readOnly = true;
    }
    self.document.forms[0].father_patient_id.focus();
}
function ChangeInitCase(obj){
    var name=obj.value;
    var spltval = name.split(" ") ;
    var temp_name = ""
    for(var i=0;i<spltval.length;i++){
       var length= obj.value.length;
       var letter = spltval[i].substring(0,length-(length-1));
       var rest = spltval[i].substring(1,length);
       letter=letter.toUpperCase();
       rest=rest.toLowerCase();
       var  namenow= letter.concat(rest);
	   temp_name+= namenow+" ";
    }
    obj.value= temp_name.substring(0,temp_name.length-1);
}

function putPatientName(from,CalledFromFunction){ 
	
    var logic = new String();
    logic = document.getElementById('name_drvn_logic').value;
	var pat_name_as_multipart_yn = document.getElementById('pat_name_as_multipart_yn').value;
	var  CalledFromFunction1=document.getElementById('CalledFromFunction').value;
	//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
	var isNameDervnLogicNBAppl = "";
	if(document.getElementById('isNameDervnLogicNBAppl')){
		isNameDervnLogicNBAppl = document.getElementById('isNameDervnLogicNBAppl').value;
	}
    var derievedName = "";
    derievedName = '';
    var logicElements = new Array();
    logicElements = logic.split('+');
    var i=0;
	/*Added By Dharma Start*/
	var called_function	= document.getElementById('called_function').value;
	var isNewBornChngsAppl	= "";
	if(document.getElementById('isNewBornChngsAppl')){
		isNewBornChngsAppl	= document.getElementById('isNewBornChngsAppl').value;
	}
	var fatherDtlsIndex			= 0;
	var newBornDtlsIndex		= 1;
	if(called_function=="IP" && isNewBornChngsAppl	=="true"){
		var fatherDtlsIndex		= 1;
		var newBornDtlsIndex	= 0;
	}
	/*Added By Dharma End*/
	
	 //Below line added for this CRF MMS-ME-CRF-0006
	var newborn_birth_order=document.getElementById('newborn_birth_order').value;
	var mutibirthderievedName="";
	var nameprefix="";
	var firstderievedName="";
	var familyNamederieved="";
	//End MMS-ME-CRF-0006
	
	if(CalledFromFunction=="FatherDtls") {
		for ( i=0;i<logicElements.length;i++){ 
			if(logicElements[i] == '1N'){
				if ((document.getElementById('first_name') && document.getElementById('first_name')[fatherDtlsIndex]!= null) && document.getElementById('first_name')[fatherDtlsIndex].value != '' )
					derievedName = derievedName + document.getElementById('first_name')[fatherDtlsIndex].value;	
			}else if ( logicElements[i] == '2N'){
				if ((document.getElementById('second_name') && document.getElementById('second_name')[fatherDtlsIndex]!= null) && document.getElementById('second_name')[fatherDtlsIndex].value != '' )
					derievedName = derievedName + document.getElementById('second_name')[fatherDtlsIndex].value;
			}else if ( logicElements[i] == '3N'){
				if ((document.getElementById('third_name') && document.getElementById('third_name')[fatherDtlsIndex]!= null) && document.getElementById('third_name')[fatherDtlsIndex].value != '' )
					derievedName = derievedName + document.getElementById('third_name')[fatherDtlsIndex].value;
			}else if ( logicElements[i] == 'FN' ){
				if ((document.getElementById('family_name') && document.getElementById('family_name')[fatherDtlsIndex]!= null) && document.getElementById('family_name')[fatherDtlsIndex].value != '' )
					derievedName = derievedName + document.getElementById('family_name')[fatherDtlsIndex].value;
			}else if ( logicElements[i] == 'PR'){
				if ((document.getElementById('name_prefix') && document.getElementById('name_prefix')[fatherDtlsIndex]!= null) && document.getElementById('name_prefix')[fatherDtlsIndex].value != '' )
					derievedName = derievedName + document.getElementById('name_prefix')[fatherDtlsIndex].value;					
			}else if ( logicElements[i] == 'SF'){
				if ((document.getElementById('name_suffix') && document.getElementById('name_suffix')[fatherDtlsIndex]!= null) && document.getElementById('name_suffix')[fatherDtlsIndex].value != '' )
					derievedName = derievedName + document.getElementById('name_suffix')[fatherDtlsIndex].value;
			}else{
				if ( logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' ){
					var arLen = logicElements[i].length;
					var tempVal = logicElements[i].substring(1,arLen - 1);
					if(derievedName == "")  tempVal="";
					derievedName = derievedName + tempVal;
				}
			}
		}
		var derievedName1 = derievedName.split(',');
		if(derievedName1[1] == ' '){
			derievedName = 	derievedName1[0];
		}
	    document.getElementById('father_patient_name').value = derievedName;
		if(document.getElementById('father_patient_name').value!='') {
			document.getElementById('father_patient_name').onblur();
		}else{  //Added the else part for IN023616 by Suresh M on 03.08.2010
			document.getElementById('father_patient_name').onblur();
		}
		//logic to be added...
		
		if(document.getElementById('name_drvn_logic_long')){
		
		var longNamelogic = new String();
		longNamelogic = document.getElementById('name_drvn_logic_long').value;
		
		var pat_name_as_multipart_yn = document.getElementById('pat_name_as_multipart_yn').value;
		var dervdName = '';
		var logicLongElements = new Array();
		logicLongElements = longNamelogic.split('+');
		i=0;
		for ( i=0;i<logicLongElements.length;i++)
		{	
			if(logicLongElements[i] == '1N')
			{
				if ((document.getElementById('first_name') && document.getElementById('first_name')[fatherDtlsIndex]!= null) && document.getElementById('first_name')[fatherDtlsIndex].value != '' )
				{
					dervdName = dervdName + document.getElementById('first_name')[fatherDtlsIndex].value;					
				}				
			}
			else if ( logicLongElements[i] == '2N' )
			{
				
				if ( (document.getElementById('second_name') && document.getElementById('second_name')[fatherDtlsIndex]!= null) && document.getElementById('second_name')[fatherDtlsIndex].value != ''  ){
					dervdName = dervdName + document.getElementById('second_name')[fatherDtlsIndex].value;
					
					}
			}
			else if ( logicLongElements[i] == '3N')
			{
				
				if ((document.getElementById('third_name') && document.getElementById('third_name')[fatherDtlsIndex]!= null) && document.getElementById('third_name')[fatherDtlsIndex].value != '' ){
					dervdName = dervdName + document.getElementById('third_name')[fatherDtlsIndex].value;
					
				}
			}
			else if ( logicLongElements[i] == 'FN')
			{
				
				  if ( (document.getElementById('family_name') && document.getElementById('family_name')[fatherDtlsIndex]!= null) && document.getElementById('family_name')[fatherDtlsIndex].value != '' ){

					dervdName = dervdName + document.getElementById('family_name')[fatherDtlsIndex].value;
					
				}
			}
			else if ( logicLongElements[i] == 'PR')
			{
				
				if ( (document.getElementById('name_prefix') && document.getElementById('name_prefix')[fatherDtlsIndex]!= null) && document.getElementById('name_prefix')[fatherDtlsIndex].value != '' )
				{
					dervdName = dervdName + document.getElementById('name_prefix')[fatherDtlsIndex].value;					
				}
			}
			else if ( logicLongElements[i] == 'SF' )
			{
			
				if ( (document.getElementById('name_suffix') && document.getElementById('name_suffix')[fatherDtlsIndex]!= null) && document.getElementById('name_suffix')[fatherDtlsIndex].value != '' ){
					dervdName = dervdName + document.getElementById('name_suffix')[fatherDtlsIndex].value;
					
				}
			}
			else
			{
				if ( logicLongElements[i] != '1N' &&  logicLongElements[i] != '2N' && logicLongElements[i] != '3N' && logicLongElements[i] != 'FN' && logicLongElements[i] != 'PR' && logicLongElements[i] != 'SF' )
				{
					var arrLen = logicLongElements[i].length;
					var tempVal = logicLongElements[i].substring(1,arrLen - 1);
					if(dervdName == "")  tempVal="";

					dervdName = dervdName + tempVal;
				}
			}
		}
		var derivedName1 = dervdName.split(',');
		
		if(derivedName1[1] == ' ')
		{
			dervdName = 	derivedName1[0];
		}		
	   document.getElementById('father_patient_long_name').value = dervdName;
   }
	}else if(CalledFromFunction=="NewbornDtls") {
		
		/*Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551*/
		var noOfBirths = document.getElementById('noOfBirths').value;
		var logic_nb = new String();

		var xmlDoc=""
		var xmlHttp = new XMLHttpRequest()
		xmlStr = "<root><SEARCH action='NBNameDervLogic'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../jsp/MPIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		var returnVal = trimString(responseText);
		var arr = returnVal.split("#");
		var name_dervn_logic_nb = arr[0];
		var name_dervn_logic_nb_sb = arr[1];

		if(noOfBirths > 1){
			logic_nb = name_dervn_logic_nb;
		}else
		{
			logic_nb = name_dervn_logic_nb_sb;
		}

		var logicElementsNB = new Array();
			logicElementsNB = logic_nb.split('+');

		var birth_order = document.getElementById('birth_order').value;
		var First_Name_Accpt_Yn = document.getElementById('First_Name_Accpt_Yn').value;
		var Second_Name_Accpt_Yn = document.getElementById('Second_Name_Accpt_Yn').value;
		var Third_Name_Accpt_Yn = document.getElementById('Third_Name_Accpt_Yn').value;
		var Family_Name_Accpt_Yn = document.getElementById('Family_Name_Accpt_Yn').value;

		var nmcnt = 0;

		if(First_Name_Accpt_Yn == "Y")
			nmcnt = nmcnt+1;
		if(Second_Name_Accpt_Yn == "Y")
			nmcnt = nmcnt+1;
		if(Third_Name_Accpt_Yn == "Y")
			nmcnt = nmcnt+1;
		if(Family_Name_Accpt_Yn == "Y")
			nmcnt = nmcnt+1;

		var nb_logic_proceed = "false";

		if(First_Name_Accpt_Yn == "Y")
		{
			for (i=0;i<logicElementsNB.length;i++){
			if(logicElementsNB[i] == '1N')
				nb_logic_proceed = "true";
			}
		}
		if(Second_Name_Accpt_Yn == "Y")
		{
			for (i=0;i<logicElementsNB.length;i++){
			if(logicElementsNB[i] == '2N')
				nb_logic_proceed = "true";
			}
		}
		if(Third_Name_Accpt_Yn == "Y")
		{
			for (i=0;i<logicElementsNB.length;i++){
			if(logicElementsNB[i] == '3N')
				nb_logic_proceed = "true";
			}
		}
		if(Family_Name_Accpt_Yn == "Y")
		{
			for (i=0;i<logicElementsNB.length;i++){
			if(logicElementsNB[i] == 'FN')
				nb_logic_proceed = "true";
			}
		}
		
		var birth_order_cnt = "";

		if (birth_order == "") birth_order_cnt = 1;
		if (birth_order == "1") birth_order_cnt = 2;
		if (birth_order == "2") birth_order_cnt = 3;
		if (birth_order == "3") birth_order_cnt = 4;
		if (birth_order == "4") birth_order_cnt = 5;
		if (birth_order == "5") birth_order_cnt = 6;
		if (birth_order == "6") birth_order_cnt = 7;
		if (birth_order == "7") birth_order_cnt = 8;
		if (birth_order == "8") birth_order_cnt = 9;
		if (birth_order == "9") birth_order_cnt = 10;

		if(isNameDervnLogicNBAppl == "true" && logic_nb != "" && nmcnt == 1 && nb_logic_proceed == "true" && birth_order_cnt <= noOfBirths && CalledFromFunction1 == 'REGISTER_NEWBORN'){
			
			for (i=0;i<logicElementsNB.length;i++){

			if(logicElementsNB[i] == '1N'){
				if ((document.getElementById('first_name') && document.getElementById('first_name')[newBornDtlsIndex]!= null) && document.getElementById('first_name')[newBornDtlsIndex].value != '' ) {
						derievedName = derievedName + document.getElementById('first_name')[newBornDtlsIndex].value;
				}						
			}else if (logicElementsNB[i] == '2N'){
				if ((document.getElementById('second_name') && document.getElementById('second_name')[newBornDtlsIndex]!= null) && document.getElementById('second_name')[newBornDtlsIndex].value != '' ) {
					derievedName = derievedName + document.getElementById('second_name')[newBornDtlsIndex].value;
				}	
			}else if(logicElementsNB[i] == '3N'){
				if ((document.getElementById('third_name') && document.getElementById('third_name')[newBornDtlsIndex]!= null) && document.getElementById('third_name')[newBornDtlsIndex].value != '') {
					derievedName = derievedName + document.getElementById('third_name')[newBornDtlsIndex].value;
				} 					
			}else if (logicElementsNB[i] == 'FN'){
				if ((document.getElementById('family_name') && document.getElementById('family_name')[newBornDtlsIndex]!= null) && document.getElementById('family_name')[newBornDtlsIndex].value != ''){
					derievedName = derievedName + document.getElementById('family_name')[newBornDtlsIndex].value;
				  }					
			}else if (logicElementsNB[i] == 'PR'){
				if ((document.getElementById('name_prefix') && document.getElementById('name_prefix')[newBornDtlsIndex]!= null) && document.getElementById('name_prefix')[newBornDtlsIndex].value != ''){
					derievedName = derievedName + document.getElementById('name_prefix')[newBornDtlsIndex].value;
				}
			}else if (logicElementsNB[i] == 'SF'){
				if ((document.getElementById('name_suffix') && document.getElementById('name_suffix')[newBornDtlsIndex]!= null) && document.getElementById('name_suffix')[newBornDtlsIndex].value != ''){
					derievedName = derievedName + document.getElementById('name_suffix')[newBornDtlsIndex].value;
				}
			}else if (logicElementsNB[i] == 'SE'){
				
					derievedName = derievedName + birth_order_cnt;

			}else if (logicElementsNB[i] == 'NU'){
				
				var birth_seq = "";
				if (birth_order_cnt == 1){
					birth_seq = "st";
				}else if (birth_order_cnt == 2){
					birth_seq = "nd";
				}else if (birth_order_cnt == 3){
					birth_seq = "rd";
				}else{
					birth_seq = "th";
				}
				
					derievedName = derievedName + birth_seq;

			}else if (logicElementsNB[i] == 'NT'){
				
					derievedName = derievedName + noOfBirths;

			}else if (logicElementsNB[i] == 'B/O'){
				
					derievedName = derievedName + "B/O";

			}else if (logicElementsNB[i] == 'TWIN'){
				
					derievedName = derievedName + "TWIN";

			}else if (logicElementsNB[i] == '< >'){
				
					derievedName = derievedName + " ";

			}else if (logicElementsNB[i] == '<, >'){
				
					derievedName = derievedName + ', ';

			}else if (logicElementsNB[i] == '<,>'){
				
					derievedName = derievedName + ',';

			}else if (logicElementsNB[i] == '<(>'){
				
					derievedName = derievedName + '(';

			}else if (logicElementsNB[i] == '<)>'){
				
					derievedName = derievedName + ')';

			}else if (logicElementsNB[i] == '</>'){
				
					derievedName = derievedName + '/';
			}
			else{
				if ( logicElementsNB[i] != '1N' &&  logicElementsNB[i] != '2N' && logicElementsNB[i] != '3N' && logicElementsNB[i] != 'FN' && logicElementsNB[i] != 'PR' && logicElementsNB[i] != 'SF' && logicElementsNB[i] != 'SE' && logicElementsNB[i] != 'NU' && logicElementsNB[i] != 'NT' && logicElementsNB[i] != 'B/O' && logicElementsNB[i] != 'TWIN' && logicElementsNB[i] != '< >' && logicElementsNB[i] != '<, >' && logicElementsNB[i] != '<,>' && logicElementsNB[i] != '<(>' && logicElementsNB[i] != '<)>' && logicElementsNB[i] != '</>'){
					var arLen = logicElementsNB[i].length;
					var tempVal = logicElementsNB[i].substring(1,arLen - 1);
					if(derievedName == "")  tempVal="";
					derievedName = derievedName + tempVal;
				}
			}

			}

			document.getElementById('nb_patient_name').value = derievedName;
			
			document.getElementById('nb_derv_logic_appl').value = "Y";
		}
		/*End ML-MMOH-CRF-1551*/
		else
		{
		for ( i=0;i<logicElements.length;i++){ 
			if(logicElements[i] == '1N'){
				if ((document.getElementById('first_name') && document.getElementById('first_name')[newBornDtlsIndex]!= null) && document.getElementById('first_name')[newBornDtlsIndex].value != '' ) {
						derievedName = derievedName + document.getElementById('first_name')[newBornDtlsIndex].value; 						
						/*Below line added for this CRF MMS-ME-CRF-0006*/
						if(newborn_birth_order=='true'){
						    //mutibirthderievedName = mutibirthderievedName +" "+ document.getElementById('first_name')[1].value; 
							firstderievedName = document.getElementById('first_name')[newBornDtlsIndex].value;
						}
						//End MMS-ME-CRF-0006
                }						
			}else if ( logicElements[i] == '2N'){
				if ((document.getElementById('second_name') && document.getElementById('second_name')[newBornDtlsIndex]!= null) && document.getElementById('second_name')[newBornDtlsIndex].value != '' ) {
					derievedName = derievedName + document.getElementById('second_name')[newBornDtlsIndex].value; 
					/*Below line added for this CRF MMS-ME-CRF-0006*/
						if(newborn_birth_order=='true'){
						    mutibirthderievedName = mutibirthderievedName +" "+ document.getElementById('second_name')[newBornDtlsIndex].value;
						}
						//End MMS-ME-CRF-0006
				}	
			}else if( logicElements[i] == '3N'){
				if ((document.getElementById('third_name') && document.getElementById('third_name')[newBornDtlsIndex]!= null) && document.getElementById('third_name')[newBornDtlsIndex].value != '') {
					derievedName = derievedName + document.getElementById('third_name')[newBornDtlsIndex].value; 					
					/*Below line added for this CRF MMS-ME-CRF-0006*/
						if(newborn_birth_order=='true'){
						    mutibirthderievedName = mutibirthderievedName +" "+ document.getElementById('third_name')[newBornDtlsIndex].value;
						}
						//End MMS-ME-CRF-0006
					
                } 					
			}else if ( logicElements[i] == 'FN'){
				if ((document.getElementById('family_name') && document.getElementById('family_name')[newBornDtlsIndex]!= null) && document.getElementById('family_name')[newBornDtlsIndex].value != ''){
					derievedName = derievedName + document.getElementById('family_name')[newBornDtlsIndex].value; 
					/*Below line added for this CRF MMS-ME-CRF-0006*/
						if(newborn_birth_order=='true'){
						    mutibirthderievedName = mutibirthderievedName+" "+ document.getElementById('family_name')[newBornDtlsIndex].value;
							familyNamederieved=document.getElementById('family_name')[newBornDtlsIndex].value;
						}
						//End MMS-ME-CRF-0006
                  }					
			}else if ( logicElements[i] == 'PR'){
				if ((document.getElementById('name_prefix') && document.getElementById('name_prefix')[newBornDtlsIndex]!= null) && document.getElementById('name_prefix')[newBornDtlsIndex].value != ''){
					derievedName = derievedName + document.getElementById('name_prefix')[newBornDtlsIndex].value;
                   /*Below line added for this CRF MMS-ME-CRF-0006*/
				    if(newborn_birth_order=='true'){
					    nameprefix = document.getElementById('name_prefix')[newBornDtlsIndex].value;
					}
					//End MMS-ME-CRF-0006
				}
			}else if ( logicElements[i] == 'SF'){
				if ((document.getElementById('name_suffix') && document.getElementById('name_suffix')[newBornDtlsIndex]!= null) && document.getElementById('name_suffix')[newBornDtlsIndex].value != '')
					derievedName = derievedName + document.getElementById('name_suffix')[newBornDtlsIndex].value;
			}else{
				if ( logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' ){
					var arLen = logicElements[i].length;
					var tempVal = logicElements[i].substring(1,arLen - 1);
					if(derievedName == "")  tempVal="";
					derievedName = derievedName + tempVal;
				}
			}
		}
		var derievedName1 = derievedName.split(',');
		if(derievedName1[1] == ' '){
			derievedName = 	derievedName1[0];
		}
		var birth_order_format=document.getElementById('birth_order_format').value;
		var noOfBirths=parent.frames[2].document.forms[0].noOfBirths.value;
		
		 //Below line added for this CRF MMS-ME-CRF-0006
		 
							
		 if(birth_order_format=='true')
		{
			if(CalledFromFunction1=='REGISTER_NEWBORN')
 				{
				document.getElementById('nb_patient_name').value = derievedName;
				}
		}else if(newborn_birth_order=='true')
		{
			if(CalledFromFunction1=='REGISTER_NEWBORN')
 				{
				document.getElementById('nb_patient_name').value = derievedName;
				document.getElementById('multiple_birth_patname').value = mutibirthderievedName;
				document.getElementById('nameprefix').value = nameprefix;
                document.getElementById('firstNamederieved').value = firstderievedName;
                document.getElementById('familyderievedName').value = familyNamederieved;   				
			    }
		}else {
			document.getElementById('nb_patient_name').value = derievedName;
			
		}
		  
        		

        //End this CRF MMS-ME-CRF-0006			
		if(document.getElementById('name_drvn_logic_long')){				
			var longNamelogic = new String();
			longNamelogic = document.getElementById('name_drvn_logic_long').value;
			
			var pat_name_as_multipart_yn = document.getElementById('pat_name_as_multipart_yn').value;
			var dervdName_newborn = '';
			var logicLongElements = new Array();
			logicLongElements = longNamelogic.split('+');
			i=0;
			
			for ( i=0;i<logicLongElements.length;i++)
			{	
				if(logicLongElements[i] == '1N')
				{
					if ((document.getElementById('first_name') && document.getElementById('first_name')[newBornDtlsIndex]!= null) && document.getElementById('first_name')[newBornDtlsIndex].value != '' )
					{
						dervdName_newborn = dervdName_newborn + document.getElementById('first_name')[newBornDtlsIndex].value;
					}
					
				}
				else if ( logicLongElements[i] == '2N' )
				{
					
					if ( (document.getElementById('second_name') && document.getElementById('second_name')[newBornDtlsIndex]!= null) && document.getElementById('second_name')[newBornDtlsIndex].value != ''  ){
						dervdName_newborn = dervdName_newborn + document.getElementById('second_name')[newBornDtlsIndex].value;
						}
				}
				else if ( logicLongElements[i] == '3N')
				{
					
					if ((document.getElementById('third_name') && document.getElementById('third_name')[newBornDtlsIndex]!= null) && document.getElementById('third_name')[newBornDtlsIndex].value != '' ){
						dervdName_newborn = dervdName_newborn + document.getElementById('third_name')[newBornDtlsIndex].value;
					}
				}
				else if ( logicLongElements[i] == 'FN')
				{
					
					  if ( (document.getElementById('family_name') && document.getElementById('family_name')[newBornDtlsIndex]!= null) && document.getElementById('family_name')[newBornDtlsIndex].value != '' ){

						dervdName_newborn = dervdName_newborn + document.getElementById('family_name')[newBornDtlsIndex].value;
						
					}
				}
				else if ( logicLongElements[i] == 'PR')
				{
					if ( (document.getElementById('name_prefix') && document.getElementById('name_prefix')[newBornDtlsIndex]!= null) && document.getElementById('name_prefix')[newBornDtlsIndex].value != '' )
					{
						dervdName_newborn = dervdName_newborn + document.getElementById('name_prefix')[newBornDtlsIndex].value;					
					}
				}
				else if ( logicLongElements[i] == 'SF' )
				{
				
					if ( (document.getElementById('name_suffix') && document.getElementById('name_suffix')[newBornDtlsIndex]!= null) && document.getElementById('name_suffix')[newBornDtlsIndex].value != '' ){
						dervdName_newborn = dervdName_newborn + document.getElementById('name_suffix')[newBornDtlsIndex].value;

					}
				}
				else
				{
					if ( logicLongElements[i] != '1N' &&  logicLongElements[i] != '2N' && logicLongElements[i] != '3N' && logicLongElements[i] != 'FN' && logicLongElements[i] != 'PR' && logicLongElements[i] != 'SF' )
					{
						var arrLen = logicLongElements[i].length;
						var tempVal = logicLongElements[i].substring(1,arrLen - 1);
						if(dervdName_newborn == "")  tempVal="";

						dervdName_newborn = dervdName_newborn + tempVal;
					}
				}
			}
			var derivedName2 = dervdName_newborn.split(',');
			
			if(derivedName2[1] == ' ')
			{
				dervdName_newborn = 	derivedName2[0];
			}
			
			/*if(((birth_order_format=='false')&&(noOfBirths<=1))||(document.getElementById("nb_patient_name").value==''))
			{
			document.getElementById("nb_patient_name_long").value = dervdName_newborn; 
			}*/		
		
	/*Below line added for this CRF MMS-ME-CRF-0006*/	
		
		if(birth_order_format=='true')
			{
			if(CalledFromFunction1=='REGISTER_NEWBORN')
 				{
				document.getElementById('nb_patient_name_long').value = dervdName_newborn;
				}
		}else if(newborn_birth_order=='true')
			{
			if(CalledFromFunction1=='REGISTER_NEWBORN')
 			{
				document.getElementById('nb_patient_name_long').value = dervdName_newborn;
				document.getElementById('multiple_birth_patname').value = mutibirthderievedName;
				document.getElementById('nameprefix').value =nameprefix;  
				document.getElementById('firstNamederieved').value = firstderievedName ;	
				document.getElementById('familyderievedName').value = familyNamederieved; 
			}
		}else
			{
			document.getElementById('nb_patient_name_long').value = dervdName_newborn;
			
		} 
		
		
		//End  MMS-ME-CRF-0006
			
			//document.getElementById('nb_patient_name_long').value = dervdName_newborn; 
		}
	} //Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
	}
}

function putLocalLangPatientName(from,CalledFromFunction) {	
	
	var language_direction= document.getElementById('language_direction').value;

    var logic = new String();	   
	logic = document.getElementById('name_drvn_logic_oth_lang').value;

	/*Added By Dharma Start*/
	var called_function	= document.getElementById('called_function').value;
	var isNewBornChngsAppl	= "";
	if(document.getElementById('isNewBornChngsAppl')){
		isNewBornChngsAppl	= document.getElementById('isNewBornChngsAppl').value;
	}
	var fatherDtlsIndex			= 0;
	var newBornDtlsIndex		= 1;
	if(called_function=="IP" && isNewBornChngsAppl	=="true"){
		var fatherDtlsIndex		= 1;
		var newBornDtlsIndex	= 0;
	}
	/*Added By Dharma End*/
	var pat_name_as_multipart_yn = document.getElementById('pat_name_as_multipart_yn').value;
    var derievedName = new String();
    derievedName = '';
    var logicElements = new Array();
    logicElements = logic.split('+');
    var i=0;
	
	if(CalledFromFunction=="FatherDtls") {	
		for ( i=0;i<logicElements.length;i++){				   
			if (logicElements[i] == '1N' && document.getElementById('first_name_oth_lang')){		
				if (document.getElementById("first_name_oth_lang"+[fatherDtlsIndex]).value != '' ){
					if(language_direction=='R'){
						derievedName = document.getElementById("first_name_oth_lang"+[fatherDtlsIndex]).value+derievedName;
					}else{
						derievedName =  derievedName+ document.getElementById("first_name_oth_lang"+[fatherDtlsIndex]).value  ;
					}
				}				
			}else if ( logicElements[i] == '2N' && document.getElementById('second_name_oth_lang')){
				if ( document.getElementById("second_name_oth_lang"+[fatherDtlsIndex]).value != '' ){
					if(language_direction=='R'){
						derievedName = document.getElementById("second_name_oth_lang"+[fatherDtlsIndex]).value+derievedName;
					}else{
						derievedName =  derievedName+ document.getElementById("second_name_oth_lang"+[fatherDtlsIndex]).value ;
					}
				}		
			}else if ( logicElements[i] == '3N' && document.getElementById('third_name_oth_lang')){
				if ( document.getElementById("third_name_oth_lang"+[fatherDtlsIndex]).value != '' ){
					if(language_direction=='R'){
						derievedName = document.getElementById("third_name_oth_lang"+[fatherDtlsIndex]).value+derievedName;
					}else{
						derievedName = derievedName+ document.getElementById("third_name_oth_lang"+[fatherDtlsIndex]).value ;
					}
				}			
			}else if ( logicElements[i] == 'FN' && document.getElementById('family_name_oth_lang')){
				if ( document.getElementById("family_name_oth_lang"+[fatherDtlsIndex]).value != '' ){
					if(language_direction=='R'){
						derievedName = document.getElementById("family_name_oth_lang"+[fatherDtlsIndex]).value+derievedName;
					}else{
						derievedName =  derievedName+ document.getElementById("family_name_oth_lang"+[fatherDtlsIndex]).value ;
					}
				}				
			}else if ( logicElements[i] == 'PR' && document.getElementById('name_prefix_oth_lang')){
				if ((document.getElementById("name_prefix_oth_lang"+[fatherDtlsIndex]))&&(document.getElementById("name_prefix_oth_lang"+[fatherDtlsIndex]).value != '')){
					
					var prefix_loc_lang = document.getElementById("name_prefix_oth_lang"+[fatherDtlsIndex]).value;
					if(language_direction=='R'){
						derievedName = prefix_loc_lang+derievedName;
					}else{
						derievedName =   derievedName+prefix_loc_lang ;	
					}
				}
			}else if ( logicElements[i] == 'SF' && document.getElementById('name_suffix_oth_lang')){
				 if ( document.getElementById('name_suffix_oth_lang')[fatherDtlsIndex].value != ''){
					var suffix_loc_lang = document.getElementById('name_suffix_oth_lang'+[fatherDtlsIndex]).value;
					if(language_direction=='R'){
						derievedName = suffix_loc_lang+derievedName;
					}else{
						derievedName =   derievedName + suffix_loc_lang ;
					}
				}
			}else{
				if(logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' ){
					var arLen = logicElements[i].length;
					var tempVal = logicElements[i].substring(1,arLen - 1);
					if(derievedName == "")  tempVal="";
					if(language_direction=='R'){
						derievedName = tempVal+derievedName;
					}else{
						derievedName = derievedName + tempVal;
					}
				}
			
			}
		
		}
		document.getElementById('father_patient_name_loc_lang').value = derievedName;
				
		if(document.getElementById('name_drvn_logic_oth_lang_long')){
		var localLongNamelogic = new String();	   
		localLongNamelogic = document.getElementById('name_drvn_logic_oth_lang_long').value;

		var pat_name_as_multipart_yn = document.getElementById('pat_name_as_multipart_yn').value;
		var derivedName = new String();
		derivedName = '';
		var logicElements = new Array();
		logicElements = localLongNamelogic.split('+');
		var i=0;	
			for ( i=0;i<logicElements.length;i++){				   
			if (logicElements[i] == '1N' && document.getElementById('first_name_oth_lang')){		
				if (document.getElementById("first_name_oth_lang"+[fatherDtlsIndex]).value != '' ){
					if(language_direction=='R'){
						derivedName = document.getElementById("first_name_oth_lang"+[fatherDtlsIndex]).value+derivedName;
					}else{
						derivedName =  derivedName+ document.getElementById("first_name_oth_lang"+[fatherDtlsIndex]).value  ;
					}
				}				
			}else if ( logicElements[i] == '2N' && document.getElementById('second_name_oth_lang')){
				if ( document.getElementById("second_name_oth_lang"+[fatherDtlsIndex]).value != '' ){
					if(language_direction=='R'){
						derivedName = document.getElementById("second_name_oth_lang"+[fatherDtlsIndex]).value+derivedName;
					}else{
						derivedName =  derivedName+ document.getElementById("second_name_oth_lang"+[fatherDtlsIndex]).value ;
					}
				}		
			}else if ( logicElements[i] == '3N' && document.getElementById('third_name_oth_lang')){
				if ( document.getElementById("third_name_oth_lang"+[fatherDtlsIndex]).value != '' ){
					if(language_direction=='R'){
						derivedName = document.getElementById("third_name_oth_lang"+[fatherDtlsIndex]).value+derivedName;
					}else{
						derivedName = derivedName+ document.getElementById("third_name_oth_lang"+[fatherDtlsIndex]).value ;
					}
				}			
			}else if ( logicElements[i] == 'FN' && document.getElementById('family_name_oth_lang')){
				if ( document.getElementById("family_name_oth_lang"+[fatherDtlsIndex]).value != '' ){
					if(language_direction=='R'){
						derivedName = document.getElementById("family_name_oth_lang"+[fatherDtlsIndex]).value+derivedName;
					}else{
						derivedName =  derivedName+ document.getElementById("family_name_oth_lang"+[fatherDtlsIndex]).value ;
					}
				}				
			}else if ( logicElements[i] == 'PR' && document.getElementById('name_prefix_oth_lang')){
				
				if ((document.getElementById("name_prefix_oth_lang"+[fatherDtlsIndex]))&&(document.getElementById("name_prefix_oth_lang"+[fatherDtlsIndex]).value != '')){
					var prefix_loc_lang = document.getElementById("name_prefix_oth_lang"+[fatherDtlsIndex]).value;
					if(language_direction=='R'){
						derivedName = prefix_loc_lang+derivedName;
					}else{
						derivedName =   derivedName+prefix_loc_lang ;	
					}
				}
			}else if ( logicElements[i] == 'SF' && document.getElementById('name_suffix_oth_lang')){
				 if ( document.getElementById("name_suffix_oth_lang"+[fatherDtlsIndex]).value != ''){
					var suffix_loc_lang = document.getElementById("name_suffix_oth_lang"+[fatherDtlsIndex]).value;
					if(language_direction=='R'){
						derivedName = suffix_loc_lang+derivedName;
					}else{
						derivedName =   derivedName + suffix_loc_lang ;
					}
				}
			}else{
				if(logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' ){
					var arLen = logicElements[i].length;
					var tempVal = logicElements[i].substring(1,arLen - 1);
					if(derivedName == "")  tempVal="";
					if(language_direction=='R'){
						derivedName = tempVal+derivedName;
					}else{
						derivedName = derivedName + tempVal;
					}
				}			
			}		
		}
		if(document.getElementById('father_patient_long_name_loc_lang'))
		{
			document.getElementById('father_patient_long_name_loc_lang').value = derivedName;
		}	
		
	}//ends

	} else if(CalledFromFunction=="NewbornDtls") {	
		for ( i=0;i<logicElements.length;i++){
			if ( logicElements[i] == '1N' && document.getElementById('first_name_oth_lang')){
				if ( document.getElementById("first_name_oth_lang"+[newBornDtlsIndex]) && document.getElementById("first_name_oth_lang"+[newBornDtlsIndex]).value != '' ){
					if(language_direction=='R'){
						derievedName = document.getElementById("first_name_oth_lang"+[newBornDtlsIndex]).value+derievedName;
					}else{
						derievedName =  derievedName+ document.getElementById("first_name_oth_lang"+[newBornDtlsIndex]).value  ;
					}
				}				
			}else if ( logicElements[i] == '2N' && document.getElementById('second_name_oth_lang')){
				if ( document.getElementById("second_name_oth_lang"+[newBornDtlsIndex]) && document.getElementById("second_name_oth_lang"+[newBornDtlsIndex]).value != '' ){
					if(language_direction=='R'){
						derievedName = document.getElementById("second_name_oth_lang"+[newBornDtlsIndex]).value+derievedName;
					}else{
						derievedName = derievedName+ document.getElementById("second_name_oth_lang"+[newBornDtlsIndex]).value ;
					}
				}			
			}else if ( logicElements[i] == '3N' && document.getElementById('third_name_oth_lang')){
				if ( document.getElementById("third_name_oth_lang"+[newBornDtlsIndex]) && document.getElementById("third_name_oth_lang"+[newBornDtlsIndex]).value != '' ){
					if(language_direction=='R'){
						derievedName = document.getElementById("third_name_oth_lang"+[newBornDtlsIndex]).value+derievedName;
					}else{
						derievedName = derievedName+ document.getElementById("third_name_oth_lang"+[newBornDtlsIndex]).value ;
					}
				}			
			}else if ( logicElements[i] == 'FN' && document.getElementById('family_name_oth_lang')){
				if ( document.getElementById("family_name_oth_lang"+[newBornDtlsIndex]) && document.getElementById("family_name_oth_lang"+[newBornDtlsIndex]).value != '' ){
					if(language_direction=='R'){
						derievedName = document.getElementById("family_name_oth_lang"+[newBornDtlsIndex]).value+derievedName;
					}else{
						derievedName =  derievedName+ document.getElementById("family_name_oth_lang"+[newBornDtlsIndex]).value ;
					}
				}				
			}else if ( logicElements[i] == 'PR' && document.getElementById('name_prefix_oth_lang')){
				if ( (document.getElementById("name_prefix_oth_lang"+[newBornDtlsIndex])) && (document.getElementById("name_prefix_oth_lang"+[newBornDtlsIndex]).value != '') ){
					var prefix_loc_lang = document.getElementById("name_prefix_oth_lang"+[newBornDtlsIndex]).value;
					if(language_direction=='R'){
						derievedName = prefix_loc_lang+derievedName;
					}else{
						derievedName =   derievedName+prefix_loc_lang ;	
					}
				}
			}else if ( logicElements[i] == 'SF' && document.getElementById('name_suffix_oth_lang')){
				 if ( document.getElementById("name_suffix_oth_lang"+newBornDtlsIndex).value != ''){
					var suffix_loc_lang = document.getElementById("name_suffix_oth_lang"+newBornDtlsIndex).value;
					if(language_direction=='R'){
						derievedName = suffix_loc_lang+derievedName;
					}else{
						derievedName =   derievedName + suffix_loc_lang ;
					}
				}
			}else{
				if ( logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' ){
					var arLen = logicElements[i].length;
					var tempVal = logicElements[i].substring(1,arLen - 1);
					if(derievedName == "")  tempVal="";
					if(language_direction=='R'){
						derievedName = tempVal+derievedName;
					}else{
						derievedName = derievedName + tempVal;
					}
				} 			
			}		
		}
		document.getElementById('nb_patient_name_loc_lang').value = derievedName;

		/*
		if(parent.patient_main.document.getElementById('patient_name_loc_lang'))
		{
			parent.patient_main.document.getElementById('patient_name_loc_lang').value = derievedName;
		}
		*/
				//alert(derievedName);

		if (document.getElementById('name_drvn_logic_oth_lang_long'))
		{
			var localLongNamelogic = new String();	   
			localLongNamelogic = document.getElementById('name_drvn_logic_oth_lang_long').value;

			var pat_name_as_multipart_yn = document.getElementById('pat_name_as_multipart_yn').value;
			var derivedName = new String();
			derivedName = '';
			var logicElements = new Array();
			logicElements = localLongNamelogic.split('+');
			var i=0;	
			for ( i=0;i<logicElements.length;i++){				   
				if (logicElements[i] == '1N' && document.getElementById('first_name_oth_lang')){		
					if (document.getElementById("first_name_oth_lang"+newBornDtlsIndex).value != '' ){
						if(language_direction=='R'){
							derivedName = document.getElementById("first_name_oth_lang"+newBornDtlsIndex).value+derivedName;
						}else{
						derivedName =  derivedName+ document.getElementById("first_name_oth_lang"+newBornDtlsIndex).value  ;
					}
				}				
			}else if ( logicElements[i] == '2N' && document.getElementById('second_name_oth_lang')){
				if ( document.getElementById("second_name_oth_lang"+newBornDtlsIndex).value != '' ){
					if(language_direction=='R'){
						derivedName = document.getElementById("second_name_oth_lang"+newBornDtlsIndex).value+derivedName;
					}else{
						derivedName =  derivedName+ document.getElementById("second_name_oth_lang"+newBornDtlsIndex).value ;
					}
				}		
			}else if ( logicElements[i] == '3N' && document.getElementById('third_name_oth_lang')){
				if ( document.getElementById("third_name_oth_lang"+newBornDtlsIndex).value != '' ){
					if(language_direction=='R'){
						derivedName = document.getElementById("third_name_oth_lang"+newBornDtlsIndex).value+derivedName;
					}else{
						derivedName = derivedName+ document.getElementById("third_name_oth_lang"+newBornDtlsIndex).value ;
					}
				}			
			}else if ( logicElements[i] == 'FN' && document.getElementById('family_name_oth_lang')){
				if ( document.getElementById("family_name_oth_lang"+newBornDtlsIndex).value != '' ){
					if(language_direction=='R'){
						derivedName = document.getElementById("family_name_oth_lang"+newBornDtlsIndex).value+derivedName;
					}else{
						derivedName =  derivedName+ document.getElementById("family_name_oth_lang"+newBornDtlsIndex).value ;
					}
				}				
			}else if ( logicElements[i] == 'PR' && document.getElementById('name_prefix_oth_lang')){
				if ((document.getElementById("name_prefix_oth_lang"+newBornDtlsIndex))&&(document.getElementById("name_prefix_oth_lang"+newBornDtlsIndex).value != '')){
					var prefix_loc_lang = document.getElementById("name_prefix_oth_lang"+newBornDtlsIndex).value;
					if(language_direction=='R'){
						derivedName = prefix_loc_lang+derivedName;
					}else{
						derivedName =   derivedName+prefix_loc_lang ;	
					}
				}
			}else if ( logicElements[i] == 'SF' && document.getElementById('name_suffix_oth_lang')){
				 if ( document.getElementById("name_suffix_oth_lang"+newBornDtlsIndex).value != ''){
					var suffix_loc_lang = document.getElementById("name_suffix_oth_lang"+newBornDtlsIndex).value;
					if(language_direction=='R'){
						derivedName = suffix_loc_lang+derivedName;
					}else{
						derivedName =   derivedName + suffix_loc_lang ;
					}
				}
			}else{
				if(logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' ){
					var arLen = logicElements[i].length;
					var tempVal = logicElements[i].substring(1,arLen - 1);
					if(derivedName == "")  tempVal="";
					if(language_direction=='R'){
						derivedName = tempVal+derivedName;
					}else{
						derivedName = derivedName + tempVal;
					}
				}
			
			}
		
		}
			
			if(document.getElementById('nb_patient_name_loc_lang_long')){
				document.getElementById('nb_patient_name_loc_lang_long').value = derivedName;
			}	
		}

	}
} 

async function onSuccess1(patient_id)
{
    parent.frames[2].document.forms[0].circumference_unit.disabled=true;
    parent.frames[2].document.forms[0].chest_circumference_unit.disabled=true;
    parent.frames[2].document.forms[0].length_unit.disabled=true;
    parent.frames[2].document.forms[0].weight_unit.disabled=true;
    parent.frames[2].document.forms[0].gestational_unit.disabled=true;


    parent.frames[2].document.forms[0].parity.readOnly=true;

    var multiple_birth = "";
	if(parent.frames[2].document.forms[0].multiple_birth_yn.checked==true)
	{
		multiple_birth = "Y";
	}
	else
	{
		multiple_birth = "N";
	}	 
	var accessRights=parent.frames[2].document.forms[0].accessRights.value;
	
	if(multiple_birth=="N")
    {
		var patientid=await PatientSearchWithDefaultGender('F','N');
        if(patientid!=null)
			parent.parent.f_query_add_mod.location.href = '../../eMP/jsp/NewbornRegistrationFirst.jsp?patient_id='+patientid+'&accessRights='+accessRights;
			else
             parent.parent.f_query_add_mod.location.href = '../../eCommon/html/blank.html';
    }
    else if(multiple_birth=="Y")
    {
        parent.frames[2].document.forms[0].noOfBirths.disabled=true;
		parent.frames[2].document.forms[0].gravida.disabled=true;
		parent.frames[2].document.forms[0].parity.disabled=true;
		parent.frames[2].document.forms[0].gestational_period.disabled=true;
		if(parent.frames[2].document.forms[0].gestational_period_days)
			parent.frames[2].document.forms[0].gestational_period_days.disabled=true;
		parent.frames[2].document.forms[0].nod_type.disabled=false;
		parent.frames[2].document.forms[0].pract_id_search1.disabled=false;
		parent.frames[2].document.forms[0].pract_id_search1.readonly=false;
		parent.frames[2].document.forms[0].att_nurse_newborn.disabled=false;
		parent.frames[2].document.forms[0].att_nurse_search.disabled=false;

		parent.frames[2].document.forms[0].comple_ofdel_newborn.disabled=false;
		parent.frames[2].document.forms[0].comple_of_button.disabled=false;
		parent.frames[2].document.forms[0].remarks.disabled=false;
		parent.frames[2].document.forms[0].del_indica_newborn.disabled=false;
		parent.frames[2].document.forms[0].del_indica_button.disabled=false;
		parent.frames[2].document.forms[0].proc_class_desc.disabled=false;
		parent.frames[2].document.forms[0].vaginal_del_type_desc.disabled=false;
		parent.frames[2].document.forms[0].del_serv_class.disabled=false;
		parent.frames[2].document.forms[0].father_patient_id.disabled=true;
		parent.frames[2].document.forms[0].pat_id_search.disabled=true;
		parent.frames[2].document.forms[0].pat_id_search.readonly=true;
		parent.frames[2].document.forms[0].father_patient_name.disabled=true;
		if(parent.frames[2].document.forms[0].National_id)
		parent.frames[2].document.forms[0].National_id.disabled=true;
		if(parent.frames[2].document.forms[0].cboOtherAltID)
		parent.frames[2].document.forms[0].cboOtherAltID.disabled=true;
		if(parent.frames[2].document.forms[0].txtOtherAltID)
		parent.frames[2].document.forms[0].txtOtherAltID.disabled=true;
		//parent.frames[2].document.forms[0].cboNationality.disabled=true;
        parent.frames[2].document.forms[0].cboNationality_desc.value='';
		parent.frames[2].document.forms[0].cboNationality.value='';
		parent.frames[2].document.forms[0].cboNationality_button.disabled=true;
		parent.frames[2].document.forms[0].cboNationality_desc.disabled=true;

		//parent.frames[2].document.forms[0].cboEthnicGroup.disabled=true;
		parent.frames[2].document.forms[0].cboEthnicGroupDesc.disabled=true;
		parent.frames[2].document.forms[0].cboEthnicGroupBtn.disabled=true;
		parent.frames[2].document.forms[0].fthGovtEmpl.disabled=true;
		parent.frames[2].document.forms[0].cboReligion.disabled=true;
		parent.frames[2].document.forms[0].cboOccupationClass.disabled=true;
		parent.frames[2].document.forms[0].cboOccupation.disabled=true;
		parent.frames[2].document.forms[0].Occupation_Desc.disabled=true;
		
        var patientid = parent.frames[2].document.forms[0].mother_patient_id.value;
        var noOfBirths= parent.frames[2].document.forms[0].noOfBirths.value;
        var func_id = parent.frames[2].document.forms[0].function_id.value;
		var father_patient_id = parent.frames[2].document.forms[0].father_patient_id.value;
        var father_patient_name = parent.frames[2].document.forms[0].father_patient_name.value;
        /*var father_patient_long_name = parent.frames[2].document.forms[0].father_patient_long_name.value;
        var father_patient_long_name_loc_lang = parent.frames[2].document.forms[0].father_patient_long_name_loc_lang.value;*/

        var attend_midwife_id = parent.frames[2].document.forms[0].attend_midwife_id.value;
        var attend_physician_id = parent.frames[2].document.forms[0].attend_physician_id.value;
		var gravida = parent.frames[2].document.forms[0].gravida.value;
		var parity = parent.frames[2].document.forms[0].parity.value;
		var gestational_period = parent.frames[2].document.forms[0].gestational_period.value;
		var gestational_period_days = "";
		if(parent.frames[2].document.forms[0].gestational_period_days)
			gestational_period_days = parent.frames[2].document.forms[0].gestational_period_days.value;
		var noOfBirths = parent.frames[2].document.forms[0].noOfBirths.value;
		
	    parent.parent.commontoolbarFrame.location.href = '../eCommon/jsp/commonToolbar.jsp?module_id=MP&function_id=NEWBORN_REG&function_name='+getLabel('eMP.RegNewBorn.label','MP')+'&function_type=F&access='+accessRights;
        parent.parent.messageFrame.location.href = '../eCommon/jsp/error.jsp';
		
		setData();
		
        parent.frames[2].document.forms[0].father_patient_id.value=father_patient_id;
        parent.frames[2].document.forms[0].father_patient_name.value = father_patient_name ;
        parent.frames[2].document.forms[0].attend_midwife_id.value= attend_midwife_id ;
        parent.frames[2].document.forms[0].attend_physician_id.value= attend_physician_id;
		parent.frames[2].document.forms[0].gravida.value = gravida;
		parent.frames[2].document.forms[0].parity.value = parity;
		parent.frames[2].document.forms[0].gestational_period.value = gestational_period; 
		if(parent.frames[2].document.forms[0].gestational_period_days)
			parent.frames[2].document.forms[0].gestational_period_days.value = gestational_period_days; 
		parent.frames[2].document.forms[0].noOfBirths.value = parseInt(noOfBirths);
	
		
		if (multiple_birth=="Y")
			parent.frames[2].document.forms[0].multiple_birth_yn.checked==true;
		else
			parent.frames[2].document.forms[0].multiple_birth_yn.checked==false;

		if(func_id!="")
		{		
			setTimeout('disable_home();',1000);
		}
    }
}

function onSuccess() 
{
	if(callfromfunctionsucc=='REGISTER_NEWBORN')
	{
		self.frames[1].frames[2].document.forms[0].add_records.disabled=true; 
		//setTimeout("changeToolBar()", 500);			
	}
	else
	{
		f_query_add_mod.location.href = '../../eMP/jsp/MaintainBirthRegisterFirst.jsp';
	}
	
}

/*
function changeToolBar() { 
	var accessRights = self.frames[1].frames[2].document.forms[0].accessRights.value;
	commontoolbarFrame.location.href = '../../eCommon/jsp/commonToolbar.jsp?module_id=MP&function_id=NEWBORN_REG&function_name='+getLabel('eMP.RegNewBorn.label','MP')+'&function_type=F&access='+accessRights;
    messageFrame.location.href = '../../eCommon/jsp/error.jsp';
}
*/

function reset(){

	invoked_from = f_query_add_mod.frames[2].document.getElementById('invoked_from').value;	
	called_function = f_query_add_mod.newbornmain_frame.document.getElementById('called_function').value;	
	var isNewBornChngsAppl = f_query_add_mod.newbornmain_frame.document.getElementById('isNewBornChngsAppl').value;	
	newTransactionYN = f_query_add_mod.newbornmain_frame.document.getElementById('newTransactionYN').value;	
	var mode = f_query_add_mod.frames[2].document.getElementById('mode').value;	



	var ip_install_yn = "";
	//Modified by Dharma on Aug 3rd 2017 against ML-MMOH-CRF-0631 [IN:062148]
	//if(called_function=='IP') {
	if(called_function=='IP' || called_function=='AE') {
		if(commontoolbarFrame.document.getElementById('reset'))
		commontoolbarFrame.document.getElementById('reset').disabled = true;
		// Introduced the below code and passes the Value by Suresh M on 16.08.2010. Since the close but gets vanished on click of Reset button in IP New Born Registration.
		ip_install_yn = "Y";
	}	
	
	
	if(mode=='Query' && invoked_from == "")	{
		
		f_query_add_mod.frames[1].location.reload();
		f_query_add_mod.frames[2].location.reload();

		called_function = f_query_add_mod.frames[2].document.getElementById('called_function').value;
		//Modified by Dharma on Aug 3rd 2017 against ML-MMOH-CRF-0631 [IN:062148]
		//if(called_function!='IP') {
		if(called_function!='IP' && called_function!='AE') {
			commontoolbarFrame.location.href = '../../eCommon/jsp/commonToolbar.jsp?menu_id=MP&module_id=MP&function_id=MP_MAIN_NB_REG&function_name=Maintain Birth Register&function_type=F&access=NYYNN';
		}

	} else {

		

		f_query_add_mod.frames[1].document.forms[0].reset();
		
		nursingunitcode = "";  	

		if(newTransactionYN=="Y") {
			if(f_query_add_mod.frames[2].document.getElementById('mother_patient_id'))
				mother_id = f_query_add_mod.frames[2].document.getElementById('mother_patient_id').value;
			invok_from = "";
		} else {
			if(f_query_add_mod.frames[2].document.getElementById('patient_id'))
				mother_id = f_query_add_mod.frames[2].document.getElementById('patient_id').value;
			invok_from = "servlet";	
		}
		var mother_patient_id=f_query_add_mod.frames[2].document.getElementById('mother_patient_id_2').value;
		var called_from_mothercare=f_query_add_mod.frames[2].document.getElementById('called_from_mothercare').value;

		parent_details = f_query_add_mod.frames[2].document.getElementById('parent_details').value;
		accessRights = f_query_add_mod.frames[2].document.getElementById('accessRights').value;
		function_name_nb = f_query_add_mod.frames[2].document.getElementById('function_name_nb').value;

		function_id = f_query_add_mod.frames[2].document.getElementById('function_id').value;
		encounterid = f_query_add_mod.frames[2].document.getElementById('mother_encounter_id').value;		
		unitofwtnb = f_query_add_mod.frames[2].document.getElementById('unitofwtnb').value;
		unitofcircumnb = f_query_add_mod.frames[2].document.getElementById('unitofcircumnb').value;
		unitofchestunit = f_query_add_mod.frames[2].document.getElementById('unitofchestunit').value;
		unitoflengthnb = f_query_add_mod.frames[2].document.getElementById('unitoflengthnb').value;
		unitofgestnb = f_query_add_mod.frames[2].document.getElementById('unitofgestnb').value;
		name_suffix_male_nb = f_query_add_mod.frames[2].document.getElementById('name_suffix_male_nb').value;
		name_suffix_female_nb = f_query_add_mod.frames[2].document.getElementById('name_suffix_female_nb').value;
		inhouse_birth_yn = f_query_add_mod.frames[2].document.getElementById('inhouse_birth_yn').value;
		nb_use_mother_ser = f_query_add_mod.frames[2].document.getElementById('nb_use_mother_ser').value;
		allownbregnwithindays = f_query_add_mod.frames[2].document.getElementById('allow_nb_regn_within_days').value;
		alt_id_type_desc = f_query_add_mod.frames[2].document.getElementById('alt_id_type_desc').value;
		function_invoked = f_query_add_mod.frames[2].document.getElementById('function_invoked').value;
		module_invoked = f_query_add_mod.frames[2].document.getElementById('module_invoked').value;
		mother_nursing_unit = f_query_add_mod.frames[2].document.getElementById('mother_nursing_unit_code').value;
		mother_bed_no = f_query_add_mod.frames[2].document.getElementById('mother_bed_no').value;
		invoke_adm_from_newborn_yn = f_query_add_mod.frames[2].document.getElementById('invoke_adm_from_newborn_yn').value;
		patient_id_length = f_query_add_mod.frames[2].document.getElementById('maxLength').value;
        siteId= f_query_add_mod.frames[2].document.getElementById('siteId').value;	

		var newbornpatsergrp = '';
		var nb_use_mother_ser = '';
		//var motherid = '';
		var exceedMaxBirthYN = 'N';

		if(f_query_add_mod.newborndtls_frame.document.getElementById('newbornpatsergrp'))
			newbornpatsergrp = f_query_add_mod.newborndtls_frame.document.getElementById('newbornpatsergrp').value;
		else 
			newbornpatsergrp = f_query_add_mod.newbornheader_frame.document.getElementById('pat_ser_grp_code').value;

		if(f_query_add_mod.newborndtls_frame.document.getElementById('nb_use_mother_ser'))
			nb_use_mother_ser = f_query_add_mod.newborndtls_frame.document.getElementById('nb_use_mother_ser').value;
		else 
			nb_use_mother_ser = f_query_add_mod.newbornheader_frame.document.getElementById('nb_use_mother_ser').value;
		/*
		if(f_query_add_mod.newborndtls_frame.document.getElementById('motherid'))
			motherid = f_query_add_mod.newborndtls_frame.document.getElementById('motherid').value; 		
		*/
		
		if(f_query_add_mod.newborndtls_frame.document.getElementById('exceedMaxBirthYN'))
			exceedMaxBirthYN = f_query_add_mod.newborndtls_frame.document.getElementById('exceedMaxBirthYN').value;

		

		var disable_button_yn = "N";

		if(exceedMaxBirthYN=="Y")
			disable_button_yn = "Y";
		else
			disable_button_yn = "N"; 				
		 
			f_query_add_mod.newbornheader_frame.location.href="../../eMP/jsp/NewbornRegistrationHeader.jsp?mother_id="+mother_id+"&function_id_new=REGISTER_NEWBORN&patient_id_length="+patient_id_length+"&new_born_pat_ser_grp="+newbornpatsergrp+"&nb_use_mother_ser="+nb_use_mother_ser+"&disable_button_yn="+disable_button_yn+"&calling_module_id="+called_function+"&mother_patient_id="+mother_patient_id+"&called_from_mothercare="+called_from_mothercare+"&siteId="+siteId+"&ip_install_yn="+ip_install_yn;
			
			var mainJspName	= "NewbornRegistrationMain.jsp";
			if(isNewBornChngsAppl=="true" && called_function=="IP"){
				mainJspName	= "NewbornRegistrationMainSLY.jsp";
			}

			f_query_add_mod.newbornmain_frame.location.href="../../eMP/jsp/"+mainJspName+"?mother_id="+mother_id+"&function_id="+function_id+"&function_id_new=REGISTER_NEWBORN&encounter_id="+encounterid+"&nursing_unit="+nursingunitcode+"&unit_of_wt_nb="+unitofwtnb+"&unit_of_circum_nb="+unitofcircumnb+"&unitofchestunit="+unitofchestunit+"&unit_of_length_nb="+unitoflengthnb+"&unit_of_gest_nb="+unitofgestnb+"&name_suffix_male_nb="+name_suffix_male_nb+"&name_suffix_female_nb="+name_suffix_female_nb+"&inhouse_birth_yn="+inhouse_birth_yn+"&nb_use_mother_ser="+nb_use_mother_ser+"&allow_nb_regn_within_days="+allownbregnwithindays+"&accessRights="+accessRights+"&parent_details="+parent_details+"&function_invoked="+function_invoked+"&module_invoked="+module_invoked+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&invoke_adm_from_newborn_yn="+invoke_adm_from_newborn_yn+"&disable_button_yn="+disable_button_yn+"&newTransactionYN="+newTransactionYN+"&invoked_from="+invok_from+"&calling_module_id="+called_function+"&mother_patient_id="+mother_patient_id+"&called_from_mothercare="+called_from_mothercare+"&siteId="+siteId+"&function_name="+function_name_nb+"&ip_install_yn="+ip_install_yn;  //Added ip_install_yn by Sangeetha for "BEDNO" vanishes on RESET
		
		//Modified by Dharma on Aug 3rd 2017 against ML-MMOH-CRF-0631 [IN:062148]
		if(called_function!='IP' && called_function!='AE') {
	//	if(called_function!='IP') {
	
			commontoolbarFrame.location.href = '../../eCommon/jsp/commonToolbar.jsp?menu_id=MP&module_id=MP&function_id=NEWBORN_REG&function_name=Register New Born&function_type=F&access=NNYNN';
		}
		
	} 	
	
	/*
	if((invoked_from == 'details_page' || invoked_from == 'servlet' || called_function == 'IP' || newTransactionYN=="Y") && (invoked_from!="" || mode!="Query")) {

		alert("Entering");

		f_query_add_mod.frames[1].document.forms[0].reset();
		
		nursingunitcode = "";  	

		if(newTransactionYN=="Y") {
			mother_id = f_query_add_mod.frames[2].document.getElementById('mother_patient_id').value;
			invok_from = "";
		} else {
			mother_id = f_query_add_mod.frames[2].document.getElementById('patient_id').value;
			invok_from = "servlet";	
		}

		parent_details = f_query_add_mod.frames[2].document.getElementById('parent_details').value;
		accessRights = f_query_add_mod.frames[2].document.getElementById('accessRights').value;
		function_name_nb = f_query_add_mod.frames[2].document.getElementById('function_name_nb').value;

		function_id = f_query_add_mod.frames[2].document.getElementById('function_id').value;
		encounterid = f_query_add_mod.frames[2].document.getElementById('mother_encounter_id').value;
		unitofwtnb = f_query_add_mod.frames[2].document.getElementById('unitofwtnb').value;
		unitofcircumnb = f_query_add_mod.frames[2].document.getElementById('unitofcircumnb').value;
		unitofchestunit = f_query_add_mod.frames[2].document.getElementById('unitofchestunit').value;
		unitoflengthnb = f_query_add_mod.frames[2].document.getElementById('unitoflengthnb').value;
		unitofgestnb = f_query_add_mod.frames[2].document.getElementById('unitofgestnb').value;
		name_suffix_male_nb = f_query_add_mod.frames[2].document.getElementById('name_suffix_male_nb').value;
		name_suffix_female_nb = f_query_add_mod.frames[2].document.getElementById('name_suffix_female_nb').value;
		inhouse_birth_yn = f_query_add_mod.frames[2].document.getElementById('inhouse_birth_yn').value;
		nb_use_mother_ser = f_query_add_mod.frames[2].document.getElementById('nb_use_mother_ser').value;
		allownbregnwithindays = f_query_add_mod.frames[2].document.getElementById('allow_nb_regn_within_days').value;
		alt_id_type_desc = f_query_add_mod.frames[2].document.getElementById('alt_id_type_desc').value;
		function_invoked = f_query_add_mod.frames[2].document.getElementById('function_invoked').value;
		module_invoked = f_query_add_mod.frames[2].document.getElementById('module_invoked').value;
		mother_nursing_unit = f_query_add_mod.frames[2].document.getElementById('mother_nursing_unit_code').value;
		mother_bed_no = f_query_add_mod.frames[2].document.getElementById('mother_bed_no').value;
		invoke_adm_from_newborn_yn = f_query_add_mod.frames[2].document.getElementById('invoke_adm_from_newborn_yn').value;
		patient_id_length = f_query_add_mod.frames[2].document.getElementById('maxLength').value;

		var newbornpatsergrp = '';
		var nb_use_mother_ser = '';
		var motherid = '';
		var exceedMaxBirthYN = 'N';

		if(f_query_add_mod.newborndtls_frame.document.getElementById('newbornpatsergrp'))
			newbornpatsergrp = f_query_add_mod.newborndtls_frame.document.getElementById('newbornpatsergrp').value;
		else 
			newbornpatsergrp = f_query_add_mod.newbornheader_frame.document.getElementById('pat_ser_grp_code').value;
		if(f_query_add_mod.newborndtls_frame.document.getElementById('nb_use_mother_ser'))
			nb_use_mother_ser = f_query_add_mod.newborndtls_frame.document.getElementById('nb_use_mother_ser').value;
		else 
			nb_use_mother_ser = f_query_add_mod.newbornheader_frame.document.getElementById('nb_use_mother_ser').value;
		if(f_query_add_mod.newborndtls_frame.document.getElementById('motherid'))
			motherid = f_query_add_mod.newborndtls_frame.document.getElementById('motherid').value; 		
		if(f_query_add_mod.newborndtls_frame.document.getElementById('exceedMaxBirthYN'))
			exceedMaxBirthYN = f_query_add_mod.newborndtls_frame.document.getElementById('exceedMaxBirthYN').value;

		var disable_button_yn = "N";

		if(exceedMaxBirthYN=="Y")
			disable_button_yn = "Y";
		else
			disable_button_yn = "N"; 				
		f_query_add_mod.newbornheader_frame.location.href="../../eMP/jsp/NewbornRegistrationHeader.jsp?mother_id="+motherid+"&function_id_new=REGISTER_NEWBORN&patient_id_length="+patient_id_length+"&new_born_pat_ser_grp="+newbornpatsergrp+"&nb_use_mother_ser="+nb_use_mother_ser+"&disable_button_yn="+disable_button_yn+"&calling_module_id="+called_function;

		//alert('mother_id-->'+mother_id);
		f_query_add_mod.newbornmain_frame.location.href="../../eMP/jsp/NewbornRegistrationMain.jsp?mother_id="+mother_id+"&function_id="+function_id+"&function_id_new=REGISTER_NEWBORN&encounter_id="+encounterid+"&nursing_unit="+nursingunitcode+"&unit_of_wt_nb="+unitofwtnb+"&unit_of_circum_nb="+unitofcircumnb+"&unitofchestunit="+unitofchestunit+"&unit_of_length_nb="+unitoflengthnb+"&unit_of_gest_nb="+unitofgestnb+"&name_suffix_male_nb="+name_suffix_male_nb+"&name_suffix_female_nb="+name_suffix_female_nb+"&inhouse_birth_yn="+inhouse_birth_yn+"&nb_use_mother_ser="+nb_use_mother_ser+"&allow_nb_regn_within_days="+allownbregnwithindays+"&accessRights="+accessRights+"&parent_details="+parent_details+"&alt_id_type_desc="+alt_id_type_desc+"&function_invoked="+function_invoked+"&module_invoked="+module_invoked+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&function_name="+function_name_nb+"&invoke_adm_from_newborn_yn="+invoke_adm_from_newborn_yn+"&disable_button_yn="+disable_button_yn+"&newTransactionYN="+newTransactionYN+"&invoked_from="+invok_from+"&calling_module_id="+called_function;
		
		if(called_function!='IP') {
			commontoolbarFrame.location.href = '../../eCommon/jsp/commonToolbar.jsp?menu_id=MP&module_id=MP&function_id=NEWBORN_REG&function_name=Register New Born&function_type=F&access=NNYNN';
		}

	} else {  		
	
		//if(callfromfunctionsucc!='REGISTER_NEWBORN')
		if(mode=='Query')
		{
			f_query_add_mod.frames[1].location.reload();
			f_query_add_mod.frames[2].location.reload();

			called_function = f_query_add_mod.frames[2].document.getElementById('called_function').value;
			if(called_function!='IP') {
				commontoolbarFrame.location.href = '../../eCommon/jsp/commonToolbar.jsp?menu_id=MP&module_id=MP&function_id=MP_MAIN_NB_REG&function_name=Maintain Birth Register&function_type=F&access=NYYNN';
			}

	} else if(mode == 'insert') {
		
	var temp5 = f_query_add_mod.frames[2].document.forms[0].number_of_births_recorded.value;
	var temp1=f_query_add_mod.frames[2].document.forms[0].gestational_period.value;
	var temp_days = "";
	if(f_query_add_mod.frames[2].document.forms[0].gestational_period_days)
		temp_days = f_query_add_mod.frames[2].document.forms[0].gestational_period_days.value;
	var temp2=f_query_add_mod.frames[2].document.forms[0].parity.value;
	var temp3=f_query_add_mod.frames[2].document.forms[0].gravida.value;
	var temp4=f_query_add_mod.frames[2].document.forms[0].noOfBirths.value;

	f_query_add_mod.frames[1].document.forms[0].reset();	
	f_query_add_mod.frames[2].document.forms[0].reset();	
	
	if(f_query_add_mod.frames[2].document.forms[0].cboOccupation.selectedIndex==0)
	{
		if(f_query_add_mod.frames[2].document.forms[0].txtOtherAltID){
		f_query_add_mod.frames[2].document.forms[0].txtOtherAltID.blur();
	    f_query_add_mod.frames[2].document.forms[0].txtOtherAltID.disabled = true;	 	 
	    f_query_add_mod.frames[2].document.forms[0].txtOtherAltID.readOnly = true;	 	 
		}
	}
		
		f_query_add_mod.frames[2].document.forms[0].noOfBirths.disabled = true;
		f_query_add_mod.frames[2].document.forms[0].noOfBirths.value =1;
    
	
  	if (f_query_add_mod.frames[2].document.forms[0].indicator_mark.options.length > 0)
 	{
		while(f_query_add_mod.frames[2].document.forms[0].indicator_mark.options.length >0)
					f_query_add_mod.frames[2].document.forms[0].indicator_mark.remove(f_query_add_mod.frames[2].document.forms[0].indicator_mark.options[0]);	
		var opt = "";
		opt = f_query_add_mod.frames[2].document.createElement("OPTION");
		opt.text = '---'+getLabel("Common.defaultSelect.label","Common")+'---';
		opt.value= '';
		f_query_add_mod.frames[2].document.forms[0].indicator_mark.add(opt)
		opt = document.createElement("OPTION");
		opt.text = getLabel("eMP.Fresh.label","MP");
		opt.value= 'F';
		f_query_add_mod.frames[2].document.forms[0].indicator_mark.add(opt)
		opt = document.createElement("OPTION");
		opt.text = getLabel("eMP.Macerated.label","MP");
		opt.value= 'M';
		f_query_add_mod.frames[2].document.forms[0].indicator_mark.add(opt);
	}

	f_query_add_mod.frames[2].document.forms[0].indicator_mark.disabled=true;
	f_query_add_mod.frames[2].document.forms[0].feeding.disabled=false;
	f_query_add_mod.frames[2].document.forms[0].bcg_given_yn.disabled=false;
	f_query_add_mod.frames[2].document.forms[0].vitak_given_yn.disabled=false;
	f_query_add_mod.frames[2].document.forms[0].hep_given_yn.disabled=false;
	f_query_add_mod.frames[2].document.forms[0].patency_of_anus_yn.disabled=false;
	f_query_add_mod.frames[2].document.forms[0].apgar_score.disabled=false;
	f_query_add_mod.frames[2].document.forms[0].apgar_score_five_min.disabled=false;
	f_query_add_mod.frames[2].document.forms[0].apgar_score_ten_min.disabled=false;
	f_query_add_mod.frames[2].document.getElementById('apg').innerHTML="<img align=center src='../../eCommon/images/mandatory.gif'></font>";
	if(f_query_add_mod.frames[2].document.getElementById('apg1'))
		f_query_add_mod.frames[2].document.getElementById('apg1').innerHTML="<img align=center src='../../eCommon/images/mandatory.gif'></font>";
	if(f_query_add_mod.frames[2].document.getElementById('patency')) {
		f_query_add_mod.frames[2].document.getElementById('patency').style.visibility='visible';
		f_query_add_mod.frames[2].document.getElementById('patency').innerHTML="<img align=center src='../../eCommon/images/mandatory.gif'></font>";
	}
			 		 
 	f_query_add_mod.frames[2].document.forms[0].stools.disabled=false;			 
 	f_query_add_mod.frames[2].document.forms[0].Congenital_Anomalies_newborn.disabled=false;			 
 	f_query_add_mod.frames[2].document.forms[0].Congenital_Anomalies_search.disabled=false;			 
 	f_query_add_mod.frames[2].document.forms[0].del_indica_button.disabled=false;			 
 	f_query_add_mod.frames[2].document.forms[0].del_indica_newborn.disabled=false;			 
  	f_query_add_mod.frames[2].document.forms[0].birth_cert_no.disabled=false;
	
	f_query_add_mod.frames[2].document.forms[0].txtVaccSite.value = '';
	f_query_add_mod.frames[2].document.forms[0].txtVaccSite.disabled=true;
	f_query_add_mod.frames[2].document.forms[0].vitak_VaccSite.value = '';
	f_query_add_mod.frames[2].document.forms[0].vitak_VaccSite.disabled=true;
	f_query_add_mod.frames[2].document.forms[0].hepb_VaccSite.value = '';
	f_query_add_mod.frames[2].document.forms[0].hepb_VaccSite.disabled=true;
	f_query_add_mod.frames[2].document.forms[0].administeredBy.value = '';
	f_query_add_mod.frames[2].document.forms[0].administeredBy.disabled=true;
	f_query_add_mod.frames[2].document.forms[0].vitak_administeredBy.value = '';
	f_query_add_mod.frames[2].document.forms[0].vitak_administeredBy.disabled=true;
	f_query_add_mod.frames[2].document.forms[0].hepb_administeredBy.value = '';
	f_query_add_mod.frames[2].document.forms[0].hepb_administeredBy.disabled=true;
	f_query_add_mod.frames[2].document.forms[0].Designation.value = '';
	f_query_add_mod.frames[2].document.forms[0].Designation.disabled=true;
	f_query_add_mod.frames[2].document.forms[0].vitak_Designation.value = '';
	f_query_add_mod.frames[2].document.forms[0].vitak_Designation.disabled=true;
	f_query_add_mod.frames[2].document.forms[0].hepb_Designation.value = '';
	f_query_add_mod.frames[2].document.forms[0].hepb_Designation.disabled=true;
	f_query_add_mod.frames[2].document.forms[0].bcg_datetime.value = '';
	f_query_add_mod.frames[2].document.forms[0].bcg_datetime.disabled=true;
	f_query_add_mod.frames[2].document.getElementById('image1').disabled=true;
	f_query_add_mod.frames[2].document.forms[0].vitk_datetime.value = '';
	f_query_add_mod.frames[2].document.forms[0].vitk_datetime.disabled=true;
	f_query_add_mod.frames[2].document.getElementById('image2').disabled=true;
	f_query_add_mod.frames[2].document.forms[0].hepb_datetime.value = '';
	f_query_add_mod.frames[2].document.forms[0].hepb_datetime.disabled=true;
	f_query_add_mod.frames[2].document.getElementById('image3').disabled=true;
	
	if(temp5>0 && f_query_add_mod.frames[2].document.NewbornRegistration_form.multiple_birth_yn.checked == true)
	{
		f_query_add_mod.frames[2].document.forms[0].gestational_period.value=temp1;
		if(f_query_add_mod.frames[2].document.forms[0].gestational_period_days)
			f_query_add_mod.frames[2].document.forms[0].gestational_period_days.value=temp_days;
		f_query_add_mod.frames[2].document.forms[0].parity.value =temp2;
		f_query_add_mod.frames[2].document.forms[0].gravida.value =temp3;
		f_query_add_mod.frames[2].document.forms[0].noOfBirths.value=temp4; 
	}

	if(f_query_add_mod.frames[2].document.forms[0].sltRelationship.options.length > 0)
 	{
		while(f_query_add_mod.frames[2].document.forms[0].sltRelationship.options.length >0)
				f_query_add_mod.frames[2].document.forms[0].sltRelationship.remove(f_query_add_mod.frames[2].document.forms[0].sltRelationship.options[0]);	
		var opt = "";
		opt = f_query_add_mod.frames[2].document.createElement("OPTION");
		opt.text =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
		opt.value= '';
		f_query_add_mod.frames[2].document.forms[0].sltRelationship.add(opt)
	}

	if(f_query_add_mod.frames[2].document.forms[0].cboOccupationClass.value=='')
	{
		if(f_query_add_mod.frames[2].document.forms[0].cboOccupation.options.length > 0)
 		{
			while (f_query_add_mod.frames[2].document.forms[0].cboOccupation.options.length >0)
				f_query_add_mod.frames[2].document.forms[0].cboOccupation.remove(f_query_add_mod.frames[2].document.forms[0].cboOccupation.options[0]);	
			var opt = "";
			opt = f_query_add_mod.frames[2].document.createElement("OPTION");
			opt.text =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
			opt.value= '';
			f_query_add_mod.frames[2].document.forms[0].cboOccupation.add(opt)
		}
	}
	
	f_query_add_mod.frames[2].document.forms[0].Occupation_Desc.disabled=false;
	f_query_add_mod.frames[2].document.forms[0].Occupation_Desc.value='';
	if(f_query_add_mod.frames[2].document.forms[0].born_where.value=='I')
	{
		f_query_add_mod.frames[2].document.forms[0].born_at_locn_type.disabled=false;
		f_query_add_mod.frames[2].document.forms[0].born_at_locn_code.disabled=false;
		var n = f_query_add_mod.frames[2].document.NewbornRegistration_form.born_at_locn_code.options.length;
		for(var i=0;i<n;i++)
		{
			f_query_add_mod.frames[2].document.forms[0].born_at_locn_code.remove("born_at_locn_code");
		}
		
		var tp = '---'+getLabel("Common.defaultSelect.label","Common")+'---';
		var opt=f_query_add_mod.frames[2].document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		f_query_add_mod.frames[2].document.forms[0].born_at_locn_code.add(opt);
	}
			f_query_add_mod.frames[1].document.forms[0].pat_ser_grp_code.focus();
			called_function = f_query_add_mod.frames[2].document.getElementById('called_function').value;
			if(called_function!='IP') {
				commontoolbarFrame.location.href = '../../eCommon/jsp/commonToolbar.jsp?menu_id=MP&module_id=MP&function_id=NEWBORN_REG&function_name=Register New Born&function_type=F&access=NNYNN';
			}

	}
}

*/		
}

/*
function callReset(){
	commontoolbarFrame.location.href = '../../eCommon/jsp/commonToolbar.jsp?menu_id=MP&module_id=MP&function_id=NEWBORN_REG&function_name=Register New Born&function_type=F&access=NNYNN';
}
*/

function setData() 
{


    if( parent.frames[2].document.forms[0].nb_use_mother_ser=="N")
    parent.frames[1].document.forms[0].pat_ser_grp_code.selectedIndex=0;
    parent.frames[1].document.forms[0].patient_id.value="";
    parent.frames[2].document.forms[0].new_born_sex.selectedIndex=0;
	parent.frames[2].document.forms[0].weight.value="";
    parent.frames[2].document.forms[0].circumference.value="";
    parent.frames[2].document.forms[0].chest_circumference.value='';
    parent.frames[2].document.forms[0].apgar_score_five_min.value='';
    parent.frames[2].document.forms[0].apgar_score_ten_min.value='';
	parent.frames[2].document.forms[0].birth_cert_no.value='';
    parent.frames[2].document.forms[0].Birth_place_code.selectedIndex=0;
	parent.frames[2].document.forms[0].length1.value="";
	parent.frames[2].document.forms[0].apgar_score.value="";
	parent.frames[2].document.forms[0].patency_of_anus_yn.checked=false;
    parent.frames[2].document.forms[0].multiple_birth_yn.checked=true;
    parent.frames[2].document.forms[0].multiple_birth_yn.disabled=true;
    parent.frames[2].document.forms[0].multiple_birth_yn.value='Y';
	parent.frames[2].document.forms[0].feeding.selectedIndex=0;
    parent.frames[2].document.forms[0].stools.selectedIndex=0;
}

/*function checkBirthDate(obj)
{
    
	var function_id = self.document.forms[0].function_id;
    var dat = obj;
    if(dat.value != '')
    {
        if(CheckDate(dat))
        {
            var dob = self.document.forms[0].date_of_birth;
            var sys = self.document.forms[0].system_date;
            var d   = self.document.forms[0].allow_nb_regn_within_days.value;
            var msgframe = parent.parent.frames[2];
                birthDateCheck(dob,sys,msgframe,d,function_id)
        }
    }
}*/

function getNewBornRegnValues(name){
	
	var val1 = '';
    var val2 = '';	
	var called_function	= document.getElementById('called_function').value;
	var isNewBornChngsAppl	= "";
	if(document.getElementById('isNewBornChngsAppl')){
		isNewBornChngsAppl	= document.getElementById('isNewBornChngsAppl').value;
	}
	var nameSuffixIndex	= 1;
	var namePrefixIndex	= 1;
	var fatherDtlsIndex	= 0;
	if(isNewBornChngsAppl=="true" && called_function=="IP"){
		nameSuffixIndex	= 0;
		namePrefixIndex	= 0;
		fatherDtlsIndex	= 1;
	}
    if(name == 'new_born_sex'){
		if(document.getElementById('name_prefix')){
			
			if(self.document.forms[0].new_born_sex.value=="M"){
				if(document.getElementById('name_prefix')){
					if(document.forms[0].outcome.value=="L"){
						if(document.getElementById('name_prefix_male_nb').value==""){
							document.getElementById('name_prefix')[namePrefixIndex].value="";
						}else{
							document.getElementById('name_prefix')[namePrefixIndex].value=document.getElementById('name_prefix_male_nb').value;
						}
					}else if(document.forms[0].still_born_prefix.value==""){
						if(document.getElementById('name_prefix_male_nb').value==""){
							document.getElementById('name_prefix')[namePrefixIndex].value="";
						}else{
							document.getElementById('name_prefix')[namePrefixIndex].value=document.getElementById('name_prefix_male_nb').value;
						}
					}
					sel_prefix_gen(document.getElementById('name_prefix')[namePrefixIndex],'NewbornDtls');
					putPatientName(document.getElementById('name_prefix')[namePrefixIndex],'NewbornDtls');
				}

				if(document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value=='Y'){
					getPatCategory();
				}
				/*if(document.getElementById("name_suffix")){
					if(document.getElementById("name_suffix_male_nb_default").value==""){
						document.getElementById("name_suffix")[1].value="";
					}else{
						document.getElementById("name_suffix")[1].value=document.getElementById("name_suffix_male_nb_default").value;
					}
					sel_suffix_gen(document.getElementById("name_suffix")[1],'NewbornDtls');
					putPatientName(document.getElementById("name_suffix")[1],'NewbornDtls');
				}*/
			}else if(self.document.forms[0].new_born_sex.value=="F"){
				if(document.getElementById("name_prefix")){
					if(document.forms[0].outcome.value=="L"){
						if(document.getElementById("name_prefix_female_nb").value==""){
							document.getElementById("name_prefix")[namePrefixIndex].value="";
						}else{
							document.getElementById("name_prefix")[namePrefixIndex].value=document.getElementById("name_prefix_female_nb").value;
						}
					}else if(document.forms[0].still_born_prefix.value==""){
						if(document.getElementById("name_prefix_female_nb").value==""){
							document.getElementById("name_prefix")[namePrefixIndex].value="";
						}else{
							document.getElementById("name_prefix")[namePrefixIndex].value=document.getElementById("name_prefix_female_nb").value;
						}
					}
					sel_prefix_gen(document.getElementById("name_prefix")[namePrefixIndex],'NewbornDtls');
					putPatientName(document.getElementById("name_prefix")[namePrefixIndex],'NewbornDtls');
				}
				if(document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value=='Y'){
					getPatCategory();
				}
				/*if(document.getElementById("name_suffix")){
					if(document.getElementById("name_suffix_male_nb_default").value==""){
						document.getElementById("name_suffix")[1].value="";
					}else{
						document.getElementById("name_suffix")[1].value=document.getElementById("name_suffix_male_nb_default").value;
					}
					sel_suffix_gen(document.getElementById("name_suffix")[1],'NewbornDtls');
					putPatientName(document.getElementById("name_suffix")[1],'NewbornDtls');
				}*/
			}
			//Started by Afruddin for ML-MMOH-CRF-1520 US 0002
			else if(self.document.forms[0].new_born_sex.value=="U"){
				
				if(document.getElementById("name_prefix")){
					
					if(document.forms[0].outcome.value=="L"){
						
						if(document.getElementById("name_prefix_unknown_nb").value==""){
							document.getElementById("name_prefix")[namePrefixIndex].value="";
						}else{
							document.getElementById("name_prefix")[namePrefixIndex].value=document.getElementById("name_prefix_unknown_nb").value;
						}
					}else if(document.forms[0].still_born_prefix.value==""){
						if(document.getElementById("name_prefix_unknown_nb").value==""){
							document.getElementById("name_prefix")[namePrefixIndex].value="";
						}else{
							document.getElementById("name_prefix")[namePrefixIndex].value=document.getElementById("name_prefix_unknown_nb").value;
						}
					}
					sel_prefix_gen(document.getElementById("name_prefix")[namePrefixIndex],'NewbornDtls');
					putPatientName(document.getElementById("name_prefix")[namePrefixIndex],'NewbornDtls');
				}
				if(document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value=='Y'){
					getPatCategory();
				}
				
			}
         //Ended by Afruddin for ML-MMOH-CRF-1520 US 0002
			
			else{
				if(document.getElementById("name_prefix")){
					if(document.forms[0].outcome.value=="L"){
						document.getElementById("name_prefix")[namePrefixIndex].value="";
					}else if(document.forms[0].still_born_prefix.value==""){
						document.getElementById("name_prefix")[namePrefixIndex].value="";
					}
					sel_prefix_gen(document.getElementById("name_prefix")[namePrefixIndex],'NewbornDtls');
					putPatientName(document.getElementById("name_prefix")[namePrefixIndex],'NewbornDtls');
				}
				/*if(document.getElementById("name_suffix")){
					document.getElementById("name_suffix")[1].value="";
					sel_suffix_gen(document.getElementById("name_suffix")[1],'NewbornDtls');
					putPatientName(document.getElementById("name_suffix")[1],'NewbornDtls');
				}*/
				if(document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value=='Y'){
					getPatCategory();
				}
			}
		}
		if(document.getElementById("name_suffix")){
			if(self.document.forms[0].new_born_sex.value=="M"){
				if(document.getElementById("name_suffix_male_nb").value==""){
					document.getElementById("name_suffix"+[nameSuffixIndex]).value="";
				}else{
					document.getElementById("name_suffix"+[nameSuffixIndex]).value=document.getElementById("name_suffix_male_nb").value;
				}
			}else if(self.document.forms[0].new_born_sex.value=="F"){
				if(document.getElementById("name_suffix_female_nb").value==""){
					document.getElementById("name_suffix"+[nameSuffixIndex]).value="";
				}else{
					document.getElementById("name_suffix"+[nameSuffixIndex]).value=document.getElementById("name_suffix_female_nb").value;
				}
			}else{
				document.getElementById("name_suffix"+[nameSuffixIndex]).value="";
			}
			sel_suffix_gen(document.getElementById("name_suffix"+[nameSuffixIndex]),'NewbornDtls');
			putPatientName(document.getElementById("name_suffix"+[nameSuffixIndex]),'NewbornDtls');
		}
        val1 = self.document.forms[0].new_born_sex.value+'`'+self.document.forms[0].name_suffix_male_nb.value+'`'+self.document.forms[0].name_suffix_female_nb.value;
        var i=1;
   }else if(name == 'father_patient_id'){
		if (self.document.forms[0].father_patient_id.value!=''){			
			if (!self.document.forms[0].father_patient_name.readOnly)
				self.document.forms[0].pat_ser_grp_code.focus();
			self.document.forms[0].father_patient_name.readOnly=true;
        }else{
			if (self.document.forms[0].multiple_birth_yn.checked==false && self.document.forms[0].multiple_birth_yn.disabled==false){
				/*
				if(document.forms[0].invoked_from.value != 'details_page')
					self.document.forms[0].father_patient_name.disabled=false;
				self.document.forms[0].father_patient_name.readOnly=false;				
				*/
			}
		}
        self.document.forms[0].father_patient_id.value=self.document.forms[0].father_patient_id.value.toUpperCase();
        val1 = self.document.forms[0].father_patient_id.value.toUpperCase();
    }else if(name == 'noOfBirths') {
        val1 = self.document.forms[0].noOfBirths.value;
        val2 = self.document.forms[0].mother_patient_id.value;
        if(val1!=''){
			//Below code commented by Thamizh selvi on 7th Dec 2017 against ML-MMOH-SCF-0891
            /*if(val1 <=1){
				if(document.forms[0].multiple_birth_yn.checked){
					alert(getMessage("BIRTH_ORDER_VAL","MP"));
					self.document.forms[0].noOfBirths.focus(); 
				}
			}else*/
			if(!CheckForNumber(val1)){
                self.document.forms[0].noOfBirths.focus();
                self.document.forms[0].noOfBirths.select();
            }
        }
		//Below code commented by Thamizh selvi on 7th Dec 2017 against ML-MMOH-SCF-0891
		/*if(val1=='')
			{ 
				if(document.forms[0].multiple_birth_yn.checked)
				{
				alert(getMessage('BIRTH_ORDER_VAL','MP'));
				self.document.forms[0].noOfBirths.focus(); 
				}
			}*/


    }else if(name=='Umb_cord_cut_by'){
		
        self.document.forms[0].Umb_cord_cut_by.value=self.document.forms[0].Umb_cord_cut_by.value.toUpperCase();
		if(self.document.forms[0].Umb_cord_cut_by_physician_id)
			val1 = self.document.forms[0].Umb_cord_cut_by_physician_id.value.toUpperCase();
		
		
	}
	else if(name=='cboOccupationClass'){
		document.NewbornRegistration_form.cboOccupation.disabled=false;
		var temp = self.document.forms[0].cboOccupationClass.value;
		if(temp=='')//done to reset the description box
		{
			self.document.forms[0].cboOccupation.options[0].selected=true;
			self.document.forms[0].Occupation_Desc.value='';
			self.document.forms[0].Occupation_Desc.disabled=true;
			
		}
		while (document.NewbornRegistration_form.cboOccupation.options.length >0)
			document.NewbornRegistration_form.cboOccupation.remove(document.NewbornRegistration_form.cboOccupation.options[0]);
			opt = document.createElement("OPTION");
			opt.text =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
			opt.value= '';
			document.NewbornRegistration_form.cboOccupation.add(opt);
			document.NewbornRegistration_form.cboOccupation.value = "";
			
			val1 = self.document.forms[0].cboOccupationClass.value;	
		}     
		else if(name == 'pat_id')
		{					
			var fid=document.forms[0].function_id_mg.value;
			if(self.document.forms[0].father_patient_id.value!='') {				
			if(!self.document.forms[0].father_patient_name.readOnly){
				if(fid=='REGISTER_NEWBORN')
				parent.frames[1].document.forms[0].pat_ser_grp_code.focus();			
			}
				self.document.forms[0].father_patient_name.readOnly=true;		
				document.getElementById('natImg').style.visibility = 'visible';	
				if(document.getElementById('race_required_yn')) {
					if(document.getElementById('race_required_yn').value=='Y') {
						document.getElementById('racImg').style.visibility = 'visible';	
					}
				}
				
			
			}else{

			if(self.document.forms[0].father_patient_name.value == '') 
			{	
				document.getElementById('natImg').style.visibility = 'hidden';	
				document.getElementById('racImg').style.visibility = 'hidden';
				self.document.forms[0].cboNationality_desc.value='';
				self.document.forms[0].cboNationality.value='';
				if(document.forms[0].invoked_from.value != 'details_page') {
					self.document.forms[0].cboNationality_button.disabled=false;
					self.document.forms[0].cboNationality_desc.disabled=false;
				}
				
			}

			if(self.document.forms[0].father_patient_id.value!='')
			{
				/*
				if(document.forms[0].invoked_from.value != 'details_page')
					self.document.forms[0].father_patient_name.disabled=false;
				*/
				self.document.forms[0].father_patient_name.value='';			
				if(self.document.forms[0].National_id){
					self.document.forms[0].National_id.value='';
					self.document.forms[0].National_id.disabled=false;	
				}
				if(self.document.forms[0].cboOtherAltID){
					self.document.forms[0].cboOtherAltID.options[0].selected=true;
					self.document.forms[0].cboOtherAltID.disabled=false;
				}
				self.document.forms[0].txtOtherAltID.value='';
				self.document.forms[0].txtOtherAltID.disabled=false;			
				//self.document.forms[0].cboNationality.options[0].selected=true;
				//self.document.forms[0].cboNationality.disabled=false;	
				self.document.forms[0].cboNationality_desc.value='';
				self.document.forms[0].cboNationality.value='';
				self.document.forms[0].cboNationality_desc.disabled=false;
				self.document.forms[0].cboNationality_button.disabled=false;
				//self.document.forms[0].cboEthnicGroup.options[0].selected=true;
				self.document.forms[0].cboEthnicGroupDesc.value="";
				//self.document.forms[0].cboEthnicGroup.disabled=false;			
				self.document.forms[0].cboEthnicGroupDesc.disabled=false;			
				self.document.forms[0].cboEthnicGroupBtn.disabled=false;			
				self.document.forms[0].cboReligion.options[0].selected=true;
				self.document.forms[0].cboReligion.disabled=false;			
				self.document.forms[0].cboOccupationClass.options[0].selected=true;
				self.document.forms[0].cboOccupationClass.disabled=false;			
				self.document.forms[0].cboOccupation.options[0].selected=true;
				self.document.forms[0].cboOccupation.disabled=false;			
				self.document.forms[0].Occupation_Desc.value="";
				self.document.forms[0].Occupation_Desc.disabled=false;			
				self.document.forms[0].fatherRemarks.value='';							
				self.document.forms[0].fatherRemarks.disabled=false;
				//self.document.forms[0].fthGovtEmpl.disabled=false;
				/*
				if (self.document.forms[0].multiple_birth_yn.checked==false && self.document.forms[0].multiple_birth_yn.disabled==false){
					if(document.forms[0].invoked_from.value != 'details_page')
						self.document.forms[0].father_patient_name.disabled=false;
					self.document.forms[0].father_patient_name.readOnly=false;				
				}
				*/
			}
			else
			{
				//self.document.forms[0].father_patient_name.readOnly=false;
				if(document.forms[0].invoked_from.value != 'details_page' && ((document.forms[0].mpDisableFieldsNBFather.value == true || document.forms[0].mpDisableFieldsNBFather.value == 'true') && document.forms[0].no_marital_status.checked == false))
				{
					//self.document.forms[0].father_patient_name.disabled=false;
					if(self.document.forms[0].father_alt_id1_no)
					self.document.forms[0].father_alt_id1_no.disabled=false;
					if(self.document.forms[0].father_alt_id2_no)
					self.document.forms[0].father_alt_id2_no.disabled=false;
					if(self.document.forms[0].father_alt_id3_no)
					self.document.forms[0].father_alt_id3_no.disabled=false;
					if(self.document.forms[0].father_alt_id4_no)
					self.document.forms[0].father_alt_id4_no.disabled=false;
				}
				else
				{
					if(document.forms[0].invoked_from.value != 'details_page' && (document.forms[0].mpDisableFieldsNBFather.value == false || document.forms[0].mpDisableFieldsNBFather.value == 'false'))
				{
					//self.document.forms[0].father_patient_name.disabled=false;
					if(self.document.forms[0].father_alt_id1_no)
					self.document.forms[0].father_alt_id1_no.disabled=false;
					if(self.document.forms[0].father_alt_id2_no)
					self.document.forms[0].father_alt_id2_no.disabled=false;
					if(self.document.forms[0].father_alt_id3_no)
					self.document.forms[0].father_alt_id3_no.disabled=false;
					if(self.document.forms[0].father_alt_id4_no)
					self.document.forms[0].father_alt_id4_no.disabled=false;
				}

				}
			}
		}        self.document.forms[0].father_patient_id.value=self.document.forms[0].father_patient_id.value.toUpperCase();
        val1 = self.document.forms[0].father_patient_id.value.toUpperCase();
	}


    if(val1!='' && name != 'noOfBirths')
    {
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMP/jsp/getNewBornRegnValues.jsp'>"+
                            " <input type='hidden' name='field1' id='field1' value=\""+name+"\">"+
                            " <input type='hidden' name='field2' id='field2' value=\""+val1+"\">"+
                            " <input type='hidden' name='field3' id='field3' value=\""+escape(val2)+"\">"+
							" <input type='hidden' name='fatherDtlsIndex' id='fatherDtlsIndex' value=\""+fatherDtlsIndex+"\">"+
		                     " </form></body></html>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.document.dum_form.action='../../eMP/jsp/getNewBornRegnValues.jsp'
		parent.parent.messageFrame.document.dum_form.target = "messageFrame";
		parent.parent.messageFrame.document.dum_form.submit();

    }
	
	/*Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551*/
	var isNameDervnLogicNBAppl = "";
	if(document.getElementById('isNameDervnLogicNBAppl'))
	{
		isNameDervnLogicNBAppl = document.getElementById('isNameDervnLogicNBAppl').value;
	}

	if(isNameDervnLogicNBAppl == 'true')
	{
		putPatientName('','NewbornDtls');
	}
	/*End ML-MMOH-CRF-1551*/
}

function checkPatGenYN()    {
    var arLength = PSGCodeArray.length;
    var q = 0;
    parent.frames[1].document.forms[0].patient_id.readOnly = true;
    while ( q <= arLength  )
    {
    if ( PSGCodeArray[q] == document.getElementById('pat_ser_grp_code').value )
    {
        if ( PSGYNArray[q] == 'N' )
        {
            alert(getMessage("ENTER_PAT_ID_SER_GRP","MP"));
            parent.frames[1].document.forms[0].patient_id.readOnly = false;
            parent.frames[1].document.forms[0].patient_id.value = '';
            parent.frames[1].document.forms[0].patient_id.focus();
            document.getElementById('pat_no_gen_yn').value  = 'N';
        }
        else
        {
            document.getElementById('pat_no_gen_yn').value  = 'Y';
            parent.frames[1].document.forms[0].patient_id.readOnly = true;
            parent.frames[1].document.forms[0].patient_id.value = '';
        }
    }
    q++;
    }
}


function validateApgar(obj)
{
	var outcome;
	//var function_id=docume
	if(document.forms[0].outcome.value=="L")
		outcome="L";
	else
		outcome="S";
	
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value != 0  && outcome =="S")  {
				
                alert(getMessage('APGAR_SCORE_NOT_GR_ZERO','MP'));
                obj.select();
                obj.focus();
                return false;
            
    }
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
            if ((outcome =="L")&&(eval(obj.value) <=0 || eval(obj.value) >10))
            {
                alert(getMessage('INVALID_APGAR_SCORE','MP'));
                obj.select();
                obj.focus();
                return false;
            }
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("NUM_ALLOWED","SM"));
            obj.select();
            obj.focus();
            return false;
        }
    }
    return true;
}


function chkTime(obj)
{
    var retval=true;
    var time1 = obj.value;

    var func_id = self.document.forms[0].function_id.value
    if(checkField( self.document.forms[0].date_of_birth, getLabel("Common.birthDate.label","common") ) )
    {
    if(time1 != '')
    {
        if( (time1.charAt(time1.length-1) )!=".")
        {
			if( (time1.charAt(time1.length-1) )!=":")
			{
				var time1arr=new Array()
				time1arr=time1.split(":")

				if(time1arr.length==2)
				{
					var time1hr=time1arr[0]
					var time1min=time1arr[1]
					if(isNaN(time1hr)||isNaN(time1min))
						retval=false;
					else
					{
						time1hr=eval(time1hr)
						time1min=eval(time1min)
						if(time1hr>=0 && time1hr<=23)
						{
							if(time1min<0 || time1min>59)
								retval=false;
						}
						else
								retval=false;
					}
				}
				else
					retval=false;
			}
			else
					retval=false;
		}
		else
			retval=false;

            if(!retval)
            {
                alert(getMessage('INVALID_TIME_FMT','SM'));				
                obj.focus();
                obj.select();
				obj.value='';
            }
        }
    }
}

function checkForNull(fieldName)
{
	
    LocalErrors = LocalErrors +'APP-000001 '+ fieldName+' cannot be blank <br>';
    return false;
}

function checkForNull2(Obj,fieldName,val,obj1)    {

    if ( Obj.value == '' || Obj.value == null || Obj.value.length == 0 ) {
		if (val=="Y" && (obj1 == "true" || obj1 == true)) {
		   Obj.style.backgroundColor='';
		}
		return true;
    }
    else {

		if (val=="Y" && (obj1 == "true" || obj1 == true)) {

		     Obj.style.backgroundColor='';
		}
        return true;
	}
}

function checkForOne(Obj,fieldName)
{
	var msg = getMessage('CANNOT_BE_LT','MP');
	msg = msg.replace('$',fieldName);
	msg = msg.replace('#',2);
    LocalErrors = LocalErrors + msg +'<br>';
	Obj.style.backgroundColor='#FFFF66';
    return false;
}
function birthTimeCheck(){
	if(parent.parent.f_query_add_mod){// Register New Born Starts here
	var dtVal=parent.parent.f_query_add_mod.frames[2].document.forms[0].date_of_birth.value;	
	var hddDTTM=parent.parent.f_query_add_mod.frames[2].getCurrentDate('DMYHM',localeName)
	var dt=dtVal.substring(0,dtVal.indexOf(" " ));
	var tm=dtVal.substring(dtVal.indexOf(" " )+1);
	var hr=tm.substring(0,tm.indexOf(":" ));
	var mt=tm.substring(tm.indexOf(":" )+1);

	var dt1=hddDTTM.substring(0,hddDTTM.indexOf(" " ));
	var tm1=hddDTTM.substring(hddDTTM.indexOf(" " )+1);
	var hr1=tm1.substring(0,tm1.indexOf(":" ));
	var mt1=tm1.substring(tm1.indexOf(":" )+1);

	parent.parent.f_query_add_mod.frames[2].document.forms[0].hddDate.value=dt1;
	parent.parent.f_query_add_mod.frames[2].document.forms[0].hddBDate.value=dt;

	if(parseInt(dt.substring(dt.indexOf("/")+1,dt.lastIndexOf("/")))==2){
		if(parseInt(dt.substring(0,dt.indexOf("/")))>29){
			/*
			LocalErrors = getMessage('INVALID_DATE_TIME',"SM");			
			parent.parent.f_query_add_mod.frames[2].document.forms[0].date_of_birth.value='';
			parent.parent.f_query_add_mod.frames[2].document.forms[0].date_of_birth.focus();	
			*/
			LocalErrors = getMessage('INVALID_DATE_FMT',"SM");			
			parent.parent.f_query_add_mod.frames[2].document.forms[0].birth_date.value='';
			parent.parent.f_query_add_mod.frames[2].document.forms[0].birth_date.focus();	
			return false;
		}
		else { return true; }
		if(parseInt(dt.substring(0,dt.indexOf("/")))==29){
			if(!leapyear(dt.substring(dt.lastIndexOf("/")+1))){
				/*
				LocalErrors = getMessage('INVALID_DATE_TIME',"SM");			
				parent.parent.f_query_add_mod.frames[2].document.forms[0].date_of_birth.value='';
				parent.parent.f_query_add_mod.frames[2].document.forms[0].date_of_birth.focus();		
				*/
				LocalErrors = getMessage('INVALID_DATE_FMT',"SM");			
				parent.parent.f_query_add_mod.frames[2].document.forms[0].birth_date.value='';
				parent.parent.f_query_add_mod.frames[2].document.forms[0].birth_date.focus();		
				return false;
			}
			else {return true;}
		}
	}

	if(Date.parse(dt1) == Date.parse(dt)){
		if(eval(hr) > eval(hr1)){     
			/*
			LocalErrors = getMessage('BIRTH_TIME_GREATER_SYSTIME',"MP");		
			parent.parent.f_query_add_mod.frames[2].document.forms[0].date_of_birth.value='';
			parent.parent.f_query_add_mod.frames[2].document.forms[0].date_of_birth.focus();
			*/
			LocalErrors = getMessage('BIRTH_TIME_GREATER_SYSTIME',"MP");		
			parent.parent.f_query_add_mod.frames[2].document.forms[0].birth_time.value='';
			parent.parent.f_query_add_mod.frames[2].document.forms[0].birth_time.focus();
			return false;
		}else if(eval(hr) == eval(hr1)){
			if(eval(mt)>eval(mt1)){	  
				/*
				LocalErrors = getMessage('BIRTH_TIME_GREATER_SYSTIME',"MP");		
				parent.parent.f_query_add_mod.frames[2].document.forms[0].date_of_birth.value='';
				parent.parent.f_query_add_mod.frames[2].document.forms[0].date_of_birth.focus();
				*/
				LocalErrors = getMessage('BIRTH_TIME_GREATER_SYSTIME',"MP");		
				parent.parent.f_query_add_mod.frames[2].document.forms[0].birth_time.value='';
				parent.parent.f_query_add_mod.frames[2].document.forms[0].birth_time.focus();
				return false;
			}
			else {return true;}
		}
		else {return true;}
	}
	return true;// Register New Born Ends Here 
	}else{// Maintain Birth Register Starts  Here
	var dtVal=f_query_add_mod.frames[2].document.forms[0].date_of_birth.value;	
	var hddDTTM=f_query_add_mod.frames[2].document.forms[0].hddDTTM.value;	
	
	var dt=dtVal.substring(0,dtVal.indexOf(" " ));
	var tm=dtVal.substring(dtVal.indexOf(" " )+1);
	var hr=tm.substring(0,tm.indexOf(":" ));
	var mt=tm.substring(tm.indexOf(":" )+1);

	var dt1=hddDTTM.substring(0,hddDTTM.indexOf(" " ));
	var tm1=hddDTTM.substring(hddDTTM.indexOf(" " )+1);
	var hr1=tm1.substring(0,tm1.indexOf(":" ));
	var mt1=tm1.substring(tm1.indexOf(":" )+1);

	f_query_add_mod.frames[2].document.forms[0].hddDate.value=dt1;
	f_query_add_mod.frames[2].document.forms[0].hddBDate.value=dt;

	if(parseInt(dt.substring(dt.indexOf("/")+1,dt.lastIndexOf("/")))==2){
		if(parseInt(dt.substring(0,dt.indexOf("/")))>29){ 
			/*
			LocalErrors = getMessage('INVALID_DATE_TIME',"SM");			
			f_query_add_mod.frames[2].document.forms[0].date_of_birth.value='';
			f_query_add_mod.frames[2].document.forms[0].date_of_birth.focus();	
			*/
			LocalErrors = getMessage('INVALID_DATE_FMT',"SM");			
			f_query_add_mod.frames[2].document.forms[0].birth_date.value='';
			f_query_add_mod.frames[2].document.forms[0].birth_date.focus();	
			return false;
		}
		else { return true; }
		if(parseInt(dt.substring(0,dt.indexOf("/")))==29){
			if(!leapyear(dt.substring(dt.lastIndexOf("/")+1))){
				/*
				LocalErrors = getMessage('INVALID_DATE_TIME',"SM");			
				f_query_add_mod.frames[2].document.forms[0].date_of_birth.value='';
				f_query_add_mod.frames[2].document.forms[0].date_of_birth.focus();		
				*/
				LocalErrors = getMessage('INVALID_DATE_FMT',"SM");			
				f_query_add_mod.frames[2].document.forms[0].birth_date.value='';
				f_query_add_mod.frames[2].document.forms[0].birth_date.focus();		
				return false;
			}
			else {return true;}
		}
	}

	if(Date.parse(dt1) == Date.parse(dt)){
		if(eval(hr) > eval(hr1)){ 
			/*
			LocalErrors = getMessage('BIRTH_TIME_GREATER_SYSTIME',"MP");		
			f_query_add_mod.frames[2].document.forms[0].date_of_birth.value='';
			f_query_add_mod.frames[2].document.forms[0].date_of_birth.focus();
			*/
			LocalErrors = getMessage('BIRTH_TIME_GREATER_SYSTIME',"MP");		
			f_query_add_mod.frames[2].document.forms[0].birth_time.value='';
			f_query_add_mod.frames[2].document.forms[0].birth_time.focus();
			return false;
		}else if(eval(hr) == eval(hr1)){
			if(eval(mt)>eval(mt1)){ 
				/*
				LocalErrors = getMessage('BIRTH_TIME_GREATER_SYSTIME',"MP");		
				f_query_add_mod.frames[2].document.forms[0].date_of_birth.value='';
				f_query_add_mod.frames[2].document.forms[0].date_of_birth.focus();
				*/
				LocalErrors = getMessage('BIRTH_TIME_GREATER_SYSTIME',"MP");		
				f_query_add_mod.frames[2].document.forms[0].birth_time.value='';
				f_query_add_mod.frames[2].document.forms[0].birth_time.focus();
				return false;
			}
			else {return true;}
		}
		else {return true;}
	}
	return true;
	}//Maintain Birth Register Starts  Here

}

function addRecords(){
	var isLabelChangeApplicable= parent.parent.f_query_add_mod.frames[2].document.forms[0].isLabelChangeApplicable.value;//Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
	var callfromfunction = '';
	var called_function	 = "";	
	var isNewBornChngsAppl	= "";
	if(parent.parent.f_query_add_mod){//From MP Register New Born	
		callfromfunction = parent.parent.f_query_add_mod.frames[2].document.forms[0].function_id_mg.value;
		callfromfunctionsucc = callfromfunction;
		called_function	= parent.parent.f_query_add_mod.frames[2].document.forms[0].called_function.value
		if(parent.parent.f_query_add_mod.frames[2].document.getElementById('isNewBornChngsAppl')){
			isNewBornChngsAppl	= parent.parent.f_query_add_mod.frames[2].document.getElementById('isNewBornChngsAppl').value;
		}
	}else{
		callfromfunction = f_query_add_mod.frames[2].document.forms[0].function_id_mg.value;
		callfromfunctionsucc = callfromfunction;
		called_function	= f_query_add_mod.frames[2].document.forms[0].called_function.value
		if(f_query_add_mod.frames[2].document.getElementById('isNewBornChngsAppl')){
			isNewBornChngsAppl	= f_query_add_mod.frames[2].document.isNewBornChngsAppl.value;
		}
	}
	/*Added By Dharma Start*/
	var fatherDtlsIndex			= 0;
	var newBornDtlsIndex		= 1;
	var restrictMntryFields		= "N";
	if(called_function=="IP" && isNewBornChngsAppl	=="true"){
		var fatherDtlsIndex		= 1;
		var newBornDtlsIndex	= 0;
		restrictMntryFields		= "Y";
	}
	/*Added By Dharma End*/

	if(parent.parent.f_query_add_mod.frames[1].document.forms[0].add_records){
		parent.parent.f_query_add_mod.frames[1].document.forms[0].add_records.disabled = true;
	} 
	var temp = 2;
	/*
	if(callfromfunction=='REGISTER_NEWBORN')
		temp=2;
	else
		temp=2;	
	*/	
	var frm = parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form;		
	//if(callfromfunction=='REGISTER_NEWBORN' || callfromfunction=='MAINTAIN_BIRTH') {
	if(frm.fthGovtEmpl.checked==true){
	   frm.fthGovtEmpl.value='Y';
	}else{
       frm.fthGovtEmpl.value='N';
	}
	if(frm.complications_delivery_text.value==''){
		frm.complications_delivery_nb.value=''
	}
	if(frm.Congenital_Anomalies_newborn.value==''){
		frm.Congenital_Anomalies.value=''
	}	
	if(frm.att_nurse_newborn.value==''){
		frm.attend_midwife_id.value=''
	}
	if(frm.comple_ofdel_newborn.value==''){
		frm.complications_delivery.value=''
	}
	if(frm.del_indica_newborn.value==''){
		frm.delivery_indication.value=''
	}
	if(frm.cboNationality_desc.value==''){
		frm.cboNationality.value=''
	}
    LocalErrors = '';
    var canSave = new Boolean(true);
	var errorsThere = new Boolean(false);
	if(frm.complications_delivery_text.value==''){
		frm.complications_delivery_nb.value=''
	}
	if(frm.Congenital_Anomalies_newborn.value==''){
		frm.Congenital_Anomalies.value=''
	}
	if(frm.att_nurse_newborn.value==''){
		frm.attend_midwife_id.value=''
	}
	if(frm.comple_ofdel_newborn.value==''){
		frm.complications_delivery.value=''
	}
	if(frm.del_indica_newborn.value==''){
		frm.delivery_indication.value=''
	}
			
	if(frm.name_prefix) {		
		frm.father_name_prefix.value=frm.name_prefix[fatherDtlsIndex].value;
	}
	if(frm.first_name) {	
		frm.father_first_name.value=frm.first_name[fatherDtlsIndex].value;
	}
	if(frm.second_name) {		
		frm.father_second_name.value=frm.second_name[fatherDtlsIndex].value;
	}
	if(frm.third_name) {		
		frm.father_third_name.value=frm.third_name[fatherDtlsIndex].value;
	}
	if(frm.family_name) {		
		frm.father_family_name.value=frm.family_name[fatherDtlsIndex].value; 
	}
	if(frm.name_suffix) {		
		frm.father_name_suffix.value=frm.name_suffix[fatherDtlsIndex].value;
	} 
	/*if (frm.name_prefix != null ){				
		if (frm.name_prefix_reqd_yn!=null && frm.name_prefix_reqd_yn[fatherDtlsIndex].value=='Y'){
			canSave = checkForNull1(frm.name_prefix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_prefix_prompt[fatherDtlsIndex].value,'Y');
		}
		if(canSave == false )
			errorsThere = true;
	}
	if (frm.first_name != null ){
		if (frm.first_name_reqd_yn != null )
			if (frm.first_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.first_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.first_name_prompt[fatherDtlsIndex].value,'Y');
            if ( canSave == false )
                errorsThere = true;              
	}
	if (frm.second_name != null ){
		if(frm.second_name_reqd_yn != null )
			if (frm.second_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.second_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.second_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}

	if (frm.third_name != null ){
		if (frm.third_name_reqd_yn != null )
			if (frm.third_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.third_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.third_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	if (frm.family_name != null ){
		if (frm.family_name_reqd_yn != null)
			if (frm.family_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.family_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.family_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	if (frm.name_suffix != null ){
		if (frm.name_suffix_reqd_yn != null)
			if (frm.name_suffix_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.name_suffix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_suffix_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}*/
	//Above condition commented and below condition added for ML-MMOH-CRF-2097 by Kamatchi S
	if (frm.name_prefix != null && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y') ){//nb_father_name_mandatory_yn newborn father checkbox checked
		if(frm.enable_marital_status.value == 'Y'){//enable_marital_status checkbox checked 
	if(frm.no_marital_status.checked == false){
		if (frm.name_prefix_reqd_yn!=null && frm.name_prefix_reqd_yn[fatherDtlsIndex].value=='Y'){
			canSave = checkForNull1(frm.name_prefix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_prefix_prompt[fatherDtlsIndex].value,'Y');
			if(canSave == false )
			errorsThere = true;
			}
		}
		if(frm.no_marital_status.checked == true){
		if (frm.name_prefix_reqd_yn!=null && frm.name_prefix_reqd_yn[fatherDtlsIndex].value=='Y'){
			canSave = checkForNull2(frm.name_prefix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_prefix_prompt[fatherDtlsIndex].value,'Y',true);
			if(canSave == false )
			errorsThere = true;
			}
		}
		}
		else
		{
			if (frm.name_prefix_reqd_yn!=null && frm.name_prefix_reqd_yn[fatherDtlsIndex].value=='Y'){
			canSave = checkForNull1(frm.name_prefix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_prefix_prompt[fatherDtlsIndex].value,'Y');
			if(canSave == false )
			errorsThere = true;
			}
		}
	}
	else{
		if (frm.name_prefix != null && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false')){
		if (frm.name_prefix_reqd_yn!=null && frm.name_prefix_reqd_yn[fatherDtlsIndex].value=='Y'){
			canSave = checkForNull1(frm.name_prefix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_prefix_prompt[fatherDtlsIndex].value,'Y');
			if(canSave == false )
			errorsThere = true;
			}
			}
		}
	if (frm.first_name != null && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y')  ){
		if(frm.enable_marital_status.value == 'Y'){
		if(frm.no_marital_status.checked == false){
		if (frm.first_name_reqd_yn != null )
			if (frm.first_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.first_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.first_name_prompt[fatherDtlsIndex].value,'Y');
            if ( canSave == false )
                errorsThere = true;              
	}
	if(frm.no_marital_status.checked == true){
		if (frm.first_name_reqd_yn != null )
			if (frm.first_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull2(frm.first_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.first_name_prompt[fatherDtlsIndex].value,'Y',true);
            if ( canSave == false )
                errorsThere = true;              
	}
		}
		else
		{
			if (frm.first_name_reqd_yn != null )
			if (frm.first_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.first_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.first_name_prompt[fatherDtlsIndex].value,'Y');
            if ( canSave == false )
                errorsThere = true;   
		}
	}
	else
	{
		if (frm.first_name != null && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false')){
		if (frm.first_name_reqd_yn != null)
			if (frm.first_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.first_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.first_name_prompt[fatherDtlsIndex].value,'Y');
            if ( canSave == false )
                errorsThere = true;              
	}
	}
	if (frm.second_name != null && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y') ){
		if(frm.enable_marital_status.value == 'Y'){
		if(frm.no_marital_status.checked == false){
		if(frm.second_name_reqd_yn != null )
			if (frm.second_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.second_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.second_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	if(frm.no_marital_status.checked == true){
		if(frm.second_name_reqd_yn != null )
			if (frm.second_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull2(frm.second_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.second_name_prompt[fatherDtlsIndex].value,'Y',true);
		if ( canSave == false )
			errorsThere = true;              
	}
		}
		else{
			if(frm.second_name_reqd_yn != null )
			if (frm.second_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.second_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.second_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
		}
	}
	else{
		if (frm.second_name != null  && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false') ){
		if(frm.second_name_reqd_yn != null )
			if (frm.second_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.second_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.second_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	}

	if (frm.third_name != null && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y')){
		if(frm.enable_marital_status.value == 'Y'){
		if(frm.no_marital_status.checked == false){
		if (frm.third_name_reqd_yn != null )
			if (frm.third_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.third_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.third_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	if(frm.no_marital_status.checked == true){
		if (frm.third_name_reqd_yn != null )
			if (frm.third_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull2(frm.third_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.third_name_prompt[fatherDtlsIndex].value,'Y',true);
		if ( canSave == false )
			errorsThere = true;              
	}
		}
		else{
			if (frm.third_name_reqd_yn != null )
			if (frm.third_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.third_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.third_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
		}
	}
	else
	{
	if (frm.third_name != null && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false')){
		if (frm.third_name_reqd_yn != null )
			if (frm.third_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.third_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.third_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	}
	if (frm.family_name != null && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y')){
		if(frm.enable_marital_status.value == 'Y'){
		if(frm.no_marital_status.checked == false){
		if (frm.family_name_reqd_yn != null)
			if (frm.family_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.family_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.family_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	if(frm.no_marital_status.checked == true){
		if (frm.family_name_reqd_yn != null)
			if (frm.family_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull2(frm.family_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.family_name_prompt[fatherDtlsIndex].value,'Y',true);
		if ( canSave == false )
			errorsThere = true;              
	}
		}
		else{
			if (frm.family_name_reqd_yn != null)
			if (frm.family_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.family_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.family_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;  
		}
	}
	else
	{
		if (frm.family_name != null && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false')){
		if (frm.family_name_reqd_yn != null)
			if (frm.family_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.family_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.family_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	}
	if (frm.name_suffix != null && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y') ){
		if(frm.enable_marital_status.value == 'Y'){
		if(frm.no_marital_status.checked == false){
		if (frm.name_suffix_reqd_yn != null)
			if (frm.name_suffix_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.name_suffix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_suffix_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}
	if(frm.no_marital_status.checked == true){
		if (frm.name_suffix_reqd_yn != null)
			if (frm.name_suffix_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull2(frm.name_suffix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_suffix_prompt[fatherDtlsIndex].value,'Y',true);
		if ( canSave == false )
			errorsThere = true;
	}
		}
		else
		{
			if (frm.name_suffix_reqd_yn != null)
			if (frm.name_suffix_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.name_suffix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_suffix_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}
	}
	else{
	if (frm.name_suffix != null && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false')){
		if (frm.name_suffix_reqd_yn != null)
			if (frm.name_suffix_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.name_suffix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_suffix_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}
	}
	if((frm.invoke_mens_hist_mand.value)=='Y' && (frm.ca_mens_trans_dtl_avail.value == 'false'))
	{
		 var errMsg = getLabel('eMP.RecordMenstrualHistoryDetails.label','MP')+" Must Be Recorded";
		 canSave = false;
		 alert(errMsg);
		 if ( canSave == false ){
			 errorsThere = true;
		 }
	}

	if(frm.name_prefix_oth_lang) {	
		frm.father_name_prefix_loc_lang.value=frm.name_prefix_oth_lang[fatherDtlsIndex].value;
	}
	if(frm.first_name_oth_lang) {	
		frm.father_first_name_loc_lang.value=frm.first_name_oth_lang[fatherDtlsIndex].value;
	}
	if(frm.second_name_oth_lang) {	
		frm.father_second_name_loc_lang.value=frm.second_name_oth_lang[fatherDtlsIndex].value;
	}
	if(frm.third_name_oth_lang) {	
		frm.father_third_name_loc_lang.value=frm.third_name_oth_lang[fatherDtlsIndex].value;
	}
	if(frm.family_name_oth_lang) {	
		frm.father_family_name_loc_lang.value=frm.family_name_oth_lang[fatherDtlsIndex].value;
	}
	if(frm.name_suffix_oth_lang) {	
		frm.father_name_suffix_loc_lang.value=frm.name_suffix_oth_lang[fatherDtlsIndex].value;
	}
	if (frm.first_name != null ){
		if (frm.first_oth_name_reqd_yn != null)
			if (frm.first_oth_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.first_name_oth_lang[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.first_name_oth_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}
	if (frm.second_name != null ){
		if (frm.second_oth_name_reqd_yn != null)
			if (frm.second_oth_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.second_name_oth_lang[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.second_name_oth_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}
	if (frm.third_name != null ){
		if (frm.third_oth_name_reqd_yn != null)
			if (frm.third_oth_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave =checkForNull1(frm.third_name_oth_lang[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.third_name_oth_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}
	if (frm.family_name != null ){
		if (frm.family_oth_name_reqd_yn != null)
			if (frm.family_oth_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave =checkForNull1(frm.family_name_oth_lang[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.family_name_oth_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}
	if (frm.name_suffix != null ){
		if (frm.name_suffix_oth_name_reqd_yn != null )
			if (frm.name_suffix_oth_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.name_suffix_oth_lang[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_suffix_oth_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}
	if (frm.name_prefix_oth_lang != null ){
		if (frm.name_prefix_oth_name_reqd_yn != null )
			if (frm.name_prefix_oth_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.name_prefix_oth_lang[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_prefix_oth_prompt[fatherDtlsIndex].value,'Y');
			
		if ( canSave == false )
			errorsThere = true;
	}
	if(frm.name_prefix) {		
		frm.nb_name_prefix.value=frm.name_prefix[newBornDtlsIndex].value;
	}
	if(frm.first_name) {		
		frm.nb_first_name.value=frm.first_name[newBornDtlsIndex].value;
	}
	if(frm.second_name) {		
		frm.nb_second_name.value=frm.second_name[newBornDtlsIndex].value;
	}
	if(frm.third_name) {		
		frm.nb_third_name.value=frm.third_name[newBornDtlsIndex].value;
	}
	if(frm.nb_family_name) {
	//Monday, December 27, 2010
		if(frm.family_name)
		{  //Monday, December 27, 2010
		frm.nb_family_name.value=frm.family_name[newBornDtlsIndex].value;  
		}
	}
	if(frm.name_suffix) {		
		frm.nb_name_suffix.value=frm.name_suffix[newBornDtlsIndex].value;
	} 	

	if (frm.name_prefix != null ){				
		if (frm.name_prefix_reqd_yn!=null && frm.name_prefix_reqd_yn[newBornDtlsIndex].value=='Y'){
			canSave = checkForNull1(frm.name_prefix[newBornDtlsIndex],getLabel('eMP.NewBorn.label','MP')+" "+frm.name_prefix_prompt[newBornDtlsIndex].value,'Y');
		}
		if ( canSave == false )
			errorsThere = true;
	}
	if(frm.first_name != null ){
		if (frm.first_name_reqd_yn != null )
			if (frm.first_name_reqd_yn[newBornDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.first_name[newBornDtlsIndex],getLabel('eMP.NewBorn.label','MP')+" "+frm.first_name_prompt[newBornDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	if (frm.second_name != null ){
		if (frm.second_name_reqd_yn != null )
			if (frm.second_name_reqd_yn[newBornDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.second_name[newBornDtlsIndex],getLabel('eMP.NewBorn.label','MP')+" "+frm.second_name_prompt[newBornDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	if (frm.third_name != null ){
		if (frm.third_name_reqd_yn != null )
			if (frm.third_name_reqd_yn[newBornDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.third_name[newBornDtlsIndex],getLabel('eMP.NewBorn.label','MP')+" "+frm.third_name_prompt[newBornDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	/*if (frm.family_name != null ){
		if (frm.family_name_reqd_yn != null)
			if (frm.family_name_reqd_yn[1].value == 'Y' )
				canSave = checkForNull1(frm.family_name[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.family_name_prompt[1].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}*/
	//Monday, December 27, 2010 
	if (frm.family_name != null ){
  if (frm.family_name_reqd_yn != null)
   if (frm.family_name_reqd_yn[newBornDtlsIndex].value == 'Y' )
		{
	   	   
				if(frm.family_name_reqd_yn[fatherDtlsIndex].value=='Y' && frm.family_name_reqd_yn[newBornDtlsIndex].value=='Y')
			{
				
				canSave = checkForNull1(frm.family_name[newBornDtlsIndex],getLabel('eMP.NewBorn.label','MP')+" "+frm.family_name_prompt[newBornDtlsIndex].value,'Y');
			}
			else
			{
				//Modified by Dharma on Aug 10th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start
				 //canSave = checkForNull1(frm.family_name[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.family_name_prompt.value,'Y');
				 var legFN	= "";
				 if(frm.family_name_prompt.value!='"undefined"'){
						 legFN = frm.family_name_prompt.value;
				 }else{
					 legFN = frm.family_name_prompt[newBornDtlsIndex].value;
				 }
				 canSave = checkForNull1(frm.family_name[newBornDtlsIndex],getLabel('eMP.NewBorn.label','MP')+" "+legFN,'Y');
				//Modified by Dharma on Aug 10th 2017 against ML-MMOH-CRF-0631 [IN:062148] End
			}
   
		}
  if ( canSave == false )
   errorsThere = true;              
 } //Monday, December 27, 2010 
	if (frm.name_suffix != null ){
		if (frm.name_suffix_reqd_yn != null)
			if (frm.name_suffix_reqd_yn[newBornDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.name_suffix[newBornDtlsIndex],getLabel('eMP.NewBorn.label','MP')+" "+frm.name_suffix_prompt[newBornDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}
	if(frm.name_prefix_oth_lang) {
	frm.nb_name_prefix_loc_lang.value=frm.name_prefix_oth_lang[newBornDtlsIndex].value;
	}
	if(frm.first_name_oth_lang) {	
		frm.nb_first_name_loc_lang.value=frm.first_name_oth_lang[newBornDtlsIndex].value;
	}
	if(frm.second_name_oth_lang) { 	
		frm.nb_second_name_loc_lang.value=frm.second_name_oth_lang[newBornDtlsIndex].value;
	}
	if(frm.third_name_oth_lang) { 	
		frm.nb_third_name_loc_lang.value=frm.third_name_oth_lang[newBornDtlsIndex].value;
	}
	if(frm.family_name_oth_lang) { 	
		frm.nb_family_name_loc_lang.value=frm.family_name_oth_lang[newBornDtlsIndex].value;
	}
	if(frm.name_suffix_oth_lang) {	
		frm.nb_name_suffix_loc_lang.value=frm.name_suffix_oth_lang[newBornDtlsIndex].value;
	}
	if (frm.first_name != null ){
		if (frm.first_oth_name_reqd_yn != null)
			if (frm.first_oth_name_reqd_yn[newBornDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.first_name_oth_lang[newBornDtlsIndex],getLabel('eMP.NewBorn.label','MP')+" "+frm.first_name_oth_prompt[newBornDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}
	if (frm.second_name != null ){
		if (frm.second_oth_name_reqd_yn != null)
			if (frm.second_oth_name_reqd_yn[newBornDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.second_name_oth_lang[newBornDtlsIndex],getLabel('eMP.NewBorn.label','MP')+" "+frm.second_name_oth_prompt[newBornDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}

	if (frm.third_name != null ){
		if (frm.third_oth_name_reqd_yn != null)
			if (frm.third_oth_name_reqd_yn[newBornDtlsIndex].value == 'Y' )
				canSave =checkForNull1(frm.third_name_oth_lang[newBornDtlsIndex],getLabel('eMP.NewBorn.label','MP')+" "+frm.third_name_oth_prompt[newBornDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}
	if (frm.family_name != null ){
		if (frm.family_oth_name_reqd_yn != null)
			if (frm.family_oth_name_reqd_yn[newBornDtlsIndex].value == 'Y' )
				canSave =checkForNull1(frm.family_name_oth_lang[newBornDtlsIndex],getLabel('eMP.NewBorn.label','MP')+" "+frm.family_name_oth_prompt[newBornDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}
	if (frm.name_suffix != null ){
		if (frm.name_suffix_oth_name_reqd_yn != null )
			if (frm.name_suffix_oth_name_reqd_yn[newBornDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.name_suffix_oth_lang[newBornDtlsIndex],getLabel('eMP.NewBorn.label','MP')+" "+frm.name_suffix_oth_prompt[newBornDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}

	if (frm.name_prefix_oth_lang != null ){
		if (frm.name_prefix_oth_name_reqd_yn != null )
			if (frm.name_prefix_oth_name_reqd_yn[newBornDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.name_prefix_oth_lang[newBornDtlsIndex],getLabel('eMP.NewBorn.label','MP')+" "+frm.name_prefix_oth_prompt[newBornDtlsIndex].value,'Y');
		if ( canSave == false )
		errorsThere = true;
	}
	
	if (  frm.name_prefix != null) {
		if ( frm.name_prefix[fatherDtlsIndex].value.length != 0 ){                    
			canSave = checkFatherSex(parent.parent.f_query_add_mod.frames[2]);					
		}
	}
	if ( canSave == false )
		errorsThere = true;
	if (frm.name_prefix != null ){
		if ( frm.name_prefix[newBornDtlsIndex].value.length != 0 ){
			if( frm.new_born_sex.value != '' ){	
				canSave = checkPatSex(parent.parent.f_query_add_mod.frames[2]);
			}
		}
	}
	if ( canSave == false )
		errorsThere = true;

	if ( frm.name_suffix != null ){
		if (  frm.name_suffix[newBornDtlsIndex].value.length != 0 ){
			if( frm.new_born_sex.value != '' ){	
				canSave = checkPatSuffixSex(parent.parent.f_query_add_mod.frames[2]);
			}
		}
	}
	if ( canSave == false )
		errorsThere = true;
    var patnogenyn = frm.pat_no_gen_yn.value;
    var function_id=frm.function_id.value;
    var calling_module_id=frm.calling_module_id.value;
    var fields = new Array ();
    var names = new Array ();    
	if(callfromfunction=='REGISTER_NEWBORN'){
		if(parent.parent.f_query_add_mod.frames[1].document.NewbornRegistration_form.patient_id.readOnly == false){
			patnogenyn = "N";		
			parent.parent.f_query_add_mod.frames[1].document.NewbornRegistration_form.pat_no_gen_yn.value = "N";
			frm.pat_no_gen_yn.value = "N"; 			frm.patient_id.value=parent.parent.f_query_add_mod.frames[1].document.NewbornRegistration_form.patient_id.value;
		}
	}

	
	/*Added for CRF 689 & 695 Starts*/
	var isRegNewbornApplicable=frm.isRegNewbornApplicable.value; //Added for this CRF ML-MMOH-CRF-0621
	if(frm.called_function.value != 'AE' && restrictMntryFields=="N"){//Added by Dharma on Aug 10th 2017 against ML-MMOH-CRF-0631 [IN:062148]
		if(callfromfunction=='REGISTER_NEWBORN' && isRegNewbornApplicable=="false"){  //modified for this CRF ML-MMOH-CRF-0621
			if(frm.outcome.value=="S"){
				if(frm.pract_id_still_birth.value=="" || frm.cond_cau_dea_main_cod.value=="" || frm.cond_cau_dea_main_cod_dur.value==""){
					frm.still_brith_dtls_mand.value="";
					canSave = checkForNull1(frm.still_brith_dtls_mand,getLabel("eMP.StillBirthDtls.label","MP"),'Y');
					if ( canSave == false )
						errorsThere = true;

				}
			}
		}
	}
		
	if(callfromfunction=='MAINTAIN_BIRTH' && isRegNewbornApplicable=="false" ){  //modified for this CRF ML-MMOH-CRF-0621
		if(frm.outcome.value=="S"){
			if(frm.pract_id_still_birth.value=="" || frm.cond_cau_dea_main_cod.value=="" || frm.cond_cau_dea_main_cod_dur.value==""){
				frm.still_brith_dtls_mand.value="";
				canSave = checkForNull1(frm.still_brith_dtls_mand,getLabel("eMP.StillBirthDtls.label","MP"),'Y');
				if ( canSave == false )
					errorsThere = true;

			}
		}
	}
	/*Added for CRF 689 & 695 Ends*/
    //Newly added for Child and Category mandatory checking
	
	if(frm.called_function.value != 'AE' && restrictMntryFields=="N"){//Added by Dharma on Aug 10th 2017 against ML-MMOH-CRF-0631 [IN:062148]
		if (frm.child_mandatoryfield.value == 'mandatory'){		
			if(frm.relation_child!=null){			
				canSave = checkForNull1(frm.relation_child,getLabel("eMP.child.label","MP"),'Y');			
			}
		}
		if ( canSave == false )
			errorsThere = true;
		if (frm.cat_mandatoryfield.value == 'mandatory'){
			if(frm.relation_child11!=null){
				canSave = checkForNull1(frm.relation_child11,getLabel("Common.category.label","Common"),'Y');
			}
		}
	}
	if ( canSave == false )
		errorsThere = true;

	//end  
	var splField = new Array (frm.patient_id);
	var splFieldName = new Array (getLabel("Common.patientId.label","common"));

	if(frm.called_function.value == 'IP' && restrictMntryFields=="N" ){
		if(frm.invoke_menstrual_history.value == "Y"){
			if(frm.gestn_day_from_lmp.value!=null){
				canSave = checkForNull1(frm.gestn_day_from_lmp,getLabel("eMP.Gestation.label","MP"),'Y');
				if(canSave == false) 
					errorsThere = true;
			}	
		}else{
		if(frm.gestational_period.value!=null){
			canSave = checkForNull1(frm.gestational_period,getLabel("eMP.Gestation.label","MP"),'Y');
			if(canSave == false) 
				errorsThere = true;
			}
		}
		if(frm.gravida.value!=null){
			if(isLabelChangeApplicable=='true'){
				canSave = checkForNull1(frm.gravida,getLabel("eMP.GravidaOnAdmission.label","MP"),'Y');//Modified by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
			}else{
				canSave = checkForNull1(frm.gravida,getLabel("eMP.Gravida.label","MP"),'Y');}
			if(canSave == false) 
				errorsThere = true;
		}
		if(frm.parity.value!=null){
			if(isLabelChangeApplicable=='true'){	
			canSave = checkForNull1(frm.parity,getLabel("eMP.ParityOnAdmission.label","MP"),'Y');//Modified by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
			}else{
				canSave = checkForNull1(frm.parity,getLabel("eMP.Parity.label","MP"),'Y'); 
			}
			if(canSave == false) 
				errorsThere = true;
		}
		//start 68508 by Twinkle
		if(frm.invoke_menstrual_history.value=="Y"){
		if(frm.parity1.value!=null){
			if(isLabelChangeApplicable=='true'){	
			canSave = checkForNull1(frm.parity1,getLabel("eMP.ParityOnAdmission.label","MP"),'Y');//Modified by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
			}else{
				canSave = checkForNull1(frm.parity1,getLabel("eMP.Parity.label","MP"),'Y'); 
			}
			if(canSave == false) 
				errorsThere = true;
		}
		}
	}
	if(frm.invokeMenstrualHistYN.value == 'Y' && frm.called_function.value == 'MP'){
	if(frm.mandParityNewBornYN.value== 'Y'){
	if(frm.parity1.value!=null){
			canSave = checkForNull1(frm.parity1,getLabel("eMP.Parity.label","MP"),'Y'); 
		if(canSave == false) 
			errorsThere = true;
	}
	if(frm.parity.value!=null){
		canSave = checkForNull1(frm.parity,getLabel("eMP.Parity.label","MP"),'Y'); 
	if(canSave == false) 
		errorsThere = true;
}
}
}
	if(frm.invokeMenstrualHistYN.value == 'Y' && frm.called_function.value == 'AE'){
		if(frm.mandParityNewBornAE_YN.value== 'Y'){
		if(frm.parity1.value!=null){
				canSave = checkForNull1(frm.parity1,getLabel("eMP.Parity.label","MP"),'Y'); 
			if(canSave == false) 
				errorsThere = true;
		}
		if(frm.parity.value!=null){
			canSave = checkForNull1(frm.parity,getLabel("eMP.Parity.label","MP"),'Y'); 
		if(canSave == false) 
			errorsThere = true;
	}
	}
	}
	//end 68508
	
	/* end of checking for mandatory fileds (Gestation, Gravida, and Parity), when called from IP Module */

	if(callfromfunction=='REGISTER_NEWBORN'){
		if(frm.multiple_birth_yn.checked){
			frm.multiple_birth_yn.value = "Y";
			if (frm.noOfBirths.value <= 1){
				canSave =  checkForOne(frm.noOfBirths,getLabel("eMP.noofmultiplebirths.label","MP"));
				if ( canSave == false ) errorsThere = true;//Added by Thamizh selvi on 7th Dec 2017 against ML-MMOH-SCF-0891
			}
			/*Added by Thamizh selvi on 7th Dec 2017 against ML-MMOH-SCF-0891 Start*/
			else{
				frm.noOfBirths.style.backgroundColor = '';
			}/*End*/
		}else{
			frm.noOfBirths.style.backgroundColor = '';//Added by Thamizh selvi on 7th Dec 2017 against ML-MMOH-SCF-0891
			frm.multiple_birth_yn.value = "N";
		}
	}	
	if(patnogenyn == 'Y'){
		// The below line is commented for the Incident IN017813 on 05/01/2010 by Suresh.
	//	if (frm.nb_use_mother_ser.value=='Y'){
			if(callfromfunction=='REGISTER_NEWBORN'){
				if(frm.pat_ser_grp_code!=null)	{
					canSave = checkForNull1(parent.parent.f_query_add_mod.frames[1].document.NewbornRegistration_form.pat_ser_grp_code,getLabel("eMP.PatientSeries.label","MP"),'Y');
				} 
				if ( canSave == false )
					errorsThere = true;
			}
		//}
		/*
		if (frm.date_of_birth.value == '')
        {
            canSave = checkForNull(getLabel("Common.birthDate.label","Common"));
        }
		*/
		if (frm.birth_date !=null){
            canSave = checkForNull1(frm.birth_date,getLabel("Common.birthDate.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

		if (frm.birth_time !=null){
            canSave = checkForNull1(frm.birth_time,getLabel("eMP.Birth.label","MP")+" "+getLabel("Common.time.label","Common"),'Y');
        }

		if ( canSave == false )
			errorsThere = true;
		if (frm.new_born_sex !=null){
			 canSave = checkForNull1(frm.new_born_sex,getLabel("Common.gender.label","Common"),'Y'); 			 
		}
		
		if(frm.called_function.value != 'AE' && restrictMntryFields=="N"){//Added by Dharma on Aug 10th 2017 against ML-MMOH-CRF-0631 [IN:062148]

			if ( canSave == false )
				errorsThere = true;
			if (frm.born_where !=null){
				canSave = checkForNull1(frm.born_where,getLabel("eMP.BornWhere.label","MP"),'Y');
			}

		}

		if ( canSave == false )
			errorsThere = true;
		//Newly added for NewbornRegistration Through IP  previusly frm.captureAntenatalDtlsYN.value == 'IP'

		// below code added for the  18677
		if(frm.called_function.value=='IP' && (frm.isMPMandatoryFieldsNewborn.value== 'false' || frm.isMPMandatoryFieldsNewborn.value == false)) {			
			if(frm.captureAntenatalDtlsYN.value == 'Y'){			
				if(frm.antenatal_care.checked==true)
					canSave = checkForNull1(frm.ate_born_where,getLabel("eMP.AnteNatalCare.label","MP")+ " " +getLabel("eMP.given.label","MP")+ " " +getLabel("Common.Location.label","common"),'Y'); 			
			}
		}
	
		if ( canSave == false )
            errorsThere = true;
		//end of Addition
		if (frm.mother_patient_id!=null){
            canSave = checkForNull1(frm.mother_patient_id,getLabel("Common.patientId.label","Common"),'Y');
        }
      
		if ( canSave == false )
            errorsThere = true;
		
		//Added by Kamatchi S for ML-MMOH-CRF-2095
		if(frm.length_of_baby_yn.value == "Y"){
		if (frm.length1!=null && frm.LENGTH_IMG.style.visibility=='visible'){
				canSave = checkForNull1(frm.length1,getLabel("eMP.LengthofBaby.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}		
		if(frm.head_circumference_of_baby_yn.value == "Y"){
			if (frm.circumference!=null && frm.CIRCUMFERENCE_IMG.style.visibility=='visible'){
				canSave = checkForNull1(frm.circumference,getLabel("Common.HeadCircumference.label","Common"),'Y');
			}
			if ( canSave == false )
				errorsThere = true;		
		}
		
		if(frm.isMPMandatoryFieldsNewborn.value=="true" || frm.isMPMandatoryFieldsNewborn.value == true){
		if((callfromfunction == "REGISTER_NEWBORN" || callfromfunction == "MAINTAIN_BIRTH") && (calling_module_id == "" || calling_module_id == "MP" ) && frm.mandate_first_newborn_yn.value == "Y"){
		if (frm.complns_1st_stage_labour_code!=null && frm.complns_1st_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_1st_stage_labour_code,getLabel("eMP.Complicationsin1stStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if((callfromfunction == "REGISTER_NEWBORN" || callfromfunction == "MAINTAIN_BIRTH") && (calling_module_id == "" || calling_module_id == "MP" ) && frm.mandate_second_newborn_yn.value == "Y"){
		if (frm.complns_2nd_stage_labour_code!=null && frm.complns_2nd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_2nd_stage_labour_code,getLabel("eMP.Complicationsin2ndStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if((callfromfunction == "REGISTER_NEWBORN" || callfromfunction == "MAINTAIN_BIRTH") && (calling_module_id == "" || calling_module_id == "MP" )  && frm.mandate_third_newborn_yn.value == "Y"){
		if (frm.complns_3rd_stage_labour_code!=null && frm.complns_3rd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_3rd_stage_labour_code,getLabel("eMP.Complicationsin3rdStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if( (callfromfunction == "REGISTER_NEWBORN" || callfromfunction == "MAINTAIN_BIRTH") && (calling_module_id == "" || calling_module_id == "MP" ) && frm.mand_antenatal_newborn_yn.value == "Y"){
		if (frm.ate_born_where!=null){
				canSave = checkForNull1(frm.ate_born_where,getLabel("eMP.AnteNatalCare.label","MP")+ " " +getLabel("eMP.given.label","MP")+ " " +getLabel("Common.Location.label","common"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "AE" && frm.mandate_first_newborn_ae_yn.value == "Y"){
		if (frm.complns_1st_stage_labour_code!=null && frm.complns_1st_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_1st_stage_labour_code,getLabel("eMP.Complicationsin1stStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "AE" && frm.mandate_second_newborn_ae_yn.value == "Y"){
		if (frm.complns_2nd_stage_labour_code!=null && frm.complns_2nd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_2nd_stage_labour_code,getLabel("eMP.Complicationsin2ndStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "AE" && frm.mandate_third_newborn_ae_yn.value == "Y"){
		if (frm.complns_3rd_stage_labour_code!=null && frm.complns_3rd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_3rd_stage_labour_code,getLabel("eMP.Complicationsin3rdStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "AE" && frm.mand_antenatal_newborn_ae_yn.value == "Y"){
		if (frm.ate_born_where!=null){
				canSave = checkForNull1(frm.ate_born_where,getLabel("eMP.AnteNatalCare.label","MP")+ " " +getLabel("eMP.given.label","MP")+ " " +getLabel("Common.Location.label","common"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "IP" && frm.mandate_first_newborn_ip_yn.value == "Y"){
		if (frm.complns_1st_stage_labour_code!=null && frm.complns_1st_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_1st_stage_labour_code,getLabel("eMP.Complicationsin1stStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "IP" && frm.mandate_second_newborn_ip_yn.value == "Y"){
		if (frm.complns_2nd_stage_labour_code!=null && frm.complns_2nd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_2nd_stage_labour_code,getLabel("eMP.Complicationsin2ndStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "IP" && frm.mandate_third_newborn_ip_yn.value == "Y"){
		if (frm.complns_3rd_stage_labour_code!=null && frm.complns_3rd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_3rd_stage_labour_code,getLabel("eMP.Complicationsin3rdStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "IP" && frm.mand_antenatal_newborn_ip_yn.value == "Y"){
		if (frm.ate_born_where!=null){
				canSave = checkForNull1(frm.ate_born_where,getLabel("eMP.AnteNatalCare.label","MP")+ " " +getLabel("eMP.given.label","MP")+ " " +getLabel("Common.Location.label","common"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		}

		if(frm.called_function.value != 'AE'  && restrictMntryFields=="N"){//Added by Dharma on Aug 10th 2017 against ML-MMOH-CRF-0631 [IN:062148]
			if(frm.isRegNewbornApplicable.value=="true" || frm.isRegNewbornApplicable.value == true ){//Condition added by kamatchi S for ML-MMOH-CRF-2095
			if (frm.length1!=null && frm.LENGTH_IMG.style.visibility=='visible'){
				canSave = checkForNull1(frm.length1,getLabel("eMP.LengthofBaby.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
						
			if (frm.circumference!=null && frm.CIRCUMFERENCE_IMG.style.visibility=='visible'){
				canSave = checkForNull1(frm.circumference,getLabel("Common.HeadCircumference.label","Common"),'Y');
			}
			if ( canSave == false )
				errorsThere = true;	
			}
				/*
				if(frm.ip_install_yn.value=='Y')
				{		
					
					if (frm.invoke_adm_from_newborn_yn.value!='Y')
					{	


						if(frm.bed_number)
						{
							var outcome=frm.outcome.value;
							var born=frm.born_where.value;
							//var bed_num_mand=frm.mand_gif1.style.visibility;
							var pseudo_bed_yn=frm.pseudo_bed_yn.value;
							
							if (frm.bed_number.value == '' && outcome=='L' && born=='I' && pseudo_bed_yn=='N')
							{

							 canSave = checkForNull(getLabel("Common.bedno.label","Common"));
							}
							if ( canSave == false )
								errorsThere = true;
						}
				}
			}
			*/

			if(frm.outcome.value=='L'&& frm.born_where.value=='I'){
				if (frm.apgar_score!=null){
				   var errmsg =getLabel("Common.ApgarScore.label","Common") 
				   errmsg=errmsg+" "+getLabel("eMP.in1Min.label","MP") 		
					canSave =checkForNull1(frm.apgar_score,errmsg,'Y');
				}
				if ( canSave == false )
					errorsThere = true;

				canSave =checkForNull1(frm.heart_rate_in_1_min,(getLabel("eMP.HeartRateAtMin.label","MP").replace('#','1')),'Y'); 
				if ( canSave == false )
					errorsThere = true;
				canSave =checkForNull1(frm.breathing_in_1_min,(getLabel("eMP.BreathingAtMin.label","MP").replace('#','1')),'Y'); 
				if ( canSave == false )
					errorsThere = true;
				canSave =checkForNull1(frm.grimace_in_1_min,(getLabel("eMP.GrimaceAtMin.label","MP").replace('#','1')),'Y'); 
				if ( canSave == false )
					errorsThere = true;
				canSave =checkForNull1(frm.activity_in_1_min,(getLabel("eMP.ActivityAtMin.label","MP").replace('#','1')),'Y'); 
				if ( canSave == false )
					errorsThere = true;
				canSave =checkForNull1(frm.appearance_in_1_min,(getLabel("eMP.AppearanceAtMin.label","MP").replace('#','1')),'Y');
				if ( canSave == false )
					errorsThere = true;

				if (frm.apgar_score_five_min!=null && frm.APGAR_SCORE_IN_5_MINS_YN_IMG.style.visibility=='visible'){
					canSave =checkForNull1(frm.apgar_score_five_min,getLabel("Common.ApgarScore.label","Common")+" "+getLabel("eMP.in5Min.label","MP"),'Y'); 

					canSave =checkForNull1(frm.heart_rate_in_5_min,(getLabel("eMP.HeartRateAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.breathing_in_5_min,(getLabel("eMP.BreathingAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.grimace_in_5_min,(getLabel("eMP.GrimaceAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.activity_in_5_min,(getLabel("eMP.ActivityAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.appearance_in_5_min,(getLabel("eMP.AppearanceAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
				}
				if ( canSave == false )
					errorsThere = true;

				


				if (frm.apgar_score_ten_min.value!=null && frm.APGAR_SCORE_IN_10_MINS_YN_IMG.style.visibility=='visible'){
					canSave =checkForNull1(frm.apgar_score_ten_min,getLabel("Common.ApgarScore.label","Common")+" "+ getLabel("eMP.in10Min.label","MP"),'Y')

					canSave =checkForNull1(frm.heart_rate_in_10_min,(getLabel("eMP.HeartRateAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.breathing_in_10_min,(getLabel("eMP.BreathingAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.grimace_in_10_min,(getLabel("eMP.GrimaceAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.activity_in_10_min,(getLabel("eMP.ActivityAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.appearance_in_10_min,(getLabel("eMP.AppearanceAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
				}
				if ( canSave == false )
					errorsThere = true;			
			
				if (frm.patency_of_anus_yn!=null && frm.PATENCY_OF_ANUS_YN_IMG.style.visibility=='visible'){
					 canSave = checkForNull1(frm.patency_of_anus_yn,getLabel("eMP.PatencyofAnus.label","MP"),'Y');
				}
				if ( canSave == false )
					errorsThere = true;
				//Added on 27/12/2004 to check for umb cord cut by mandatory check
				if (frm.Umb_cord_cut_by1!=null){
					canSave = checkForNull1(frm.Umb_cord_cut_by1,getLabel("eMP.UmbCordCutBy.label","MP"),'Y');
				}
				if ( canSave == false )
					errorsThere = true;
				}
				//Newly added
				
				if(frm.outcome.value=='S'&& frm.born_where.value=='I'){
					/*if (frm.Umb_cord_cut_by1!=null){
						canSave = checkForNull1(frm.Umb_cord_cut_by1,getLabel("eMP.UmbCordCutBy.label","MP"),'Y');
					}
					if ( canSave == false )
						errorsThere = true;*/
				}
				var allow_ext_nb_regn_within_days = frm.allow_ext_nb_regn_within_days.value;
				var isAllow_External_Newborn = frm.isAllow_External_Newborn.value;
				var born_where = frm.born_where.value;	 			
				if (frm.practid_desc!=null){
					if(isNewBornChngsAppl=="true"){
						canSave = checkForNull1(frm.practid_desc,getLabel("Common.ConductedBy.label","Common"),'Y');
					}else {
						if(isAllow_External_Newborn =="true" && born_where =='I' && allow_ext_nb_regn_within_days!='' && allow_ext_nb_regn_within_days !=null )
						{
						canSave = checkForNull1(frm.practid_desc,getLabel("Common.AttendingPractitioner.label","Common"),'Y');
						}
						else if(isAllow_External_Newborn =="true" && born_where !='I' && allow_ext_nb_regn_within_days!='' && allow_ext_nb_regn_within_days !=null ){
							//canSave = false;
						}
						else
						{
							canSave = checkForNull1(frm.practid_desc,getLabel("Common.AttendingPractitioner.label","Common"),'Y');	
						}
					}

				}
				if ( canSave == false )
					errorsThere = true;
			

				if (frm.weight!=null){
					canSave = checkForNull1(frm.weight,getLabel("eMP.BirthWeight.label","MP"),'Y');
				}
				if ( canSave == false )
					errorsThere = true;

				if (frm.nod_type!=null){
					canSave = checkForNull1(frm.nod_type,getLabel("eMP.natureofdelivery.label","MP"),'Y');
				} 
				if ( canSave == false )
					errorsThere = true;
		}
    }else{
		// The below line is commented for the Incident IN017813 on 05/01/2010 by Suresh.
	//	if (frm.nb_use_mother_ser.value=='Y'){
			if(callfromfunction=='REGISTER_NEWBORN'){				
				if (parent.parent.f_query_add_mod.frames[1].document.NewbornRegistration_form.pat_ser_grp_code!=null){
					canSave = checkForNull1(parent.parent.f_query_add_mod.frames[1].document.NewbornRegistration_form.pat_ser_grp_code,getLabel("eMP.PatientSeries.label","MP"),'Y');
				} 
				if ( canSave == false )
					errorsThere = true;
			}
	//	}
        if (frm.patient_id!=null){
            canSave = checkForNull1(frm.patient_id,getLabel("Common.patientId.label","Common"),'Y');
        }
        if ( canSave == false ){
            errorsThere = true;
		}else{
			if(frm.patient_id.value.length != frm.maxLength.value){
				var msg = getMessage("HEAD_PATID_CHAR","MP");
				msg = msg.replace('@', document.getElementById('patient_id').maxLength);
				LocalErrors = LocalErrors+msg+' <br>';
				frm.patient_id.style.backgroundColor='#FFFF66';
				canSave = false;
				errorsThere = true;
			}else if(frm.duplicate.value=="Y"){
				LocalErrors = LocalErrors +getMessage("DUPL_PAT_ID","MP")+' <br>';
				frm.patient_id.style.backgroundColor='#FFFF66';
				canSave = false;
				errorsThere = true;
			}
        }
		/*
        if (frm.date_of_birth.value == 0)
        {
            canSave = checkForNull(getLabel("Common.birthDate.label","Common"));
        }
        if ( canSave == false )
            errorsThere = true;
		*/

		if (frm.birth_date!=null){
            canSave = checkForNull1(frm.birth_date,getLabel("Common.birthDate.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

		if (frm.birth_time!=null){
            canSave = checkForNull1(frm.birth_time,getLabel("eMP.Birth.label","MP")+" "+getLabel("Common.time.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;
		if(frm.called_function.value != 'AE'){//Added by Dharma on Aug 10th 2017 against ML-MMOH-CRF-0631 [IN:062148]
			if (frm.new_born_sex!=null){
				canSave = checkForNull1(frm.new_born_sex,getLabel("Common.gender.label","Common"),'Y');
			}
			if ( canSave == false )
				errorsThere = true;

			if (frm.born_where!=null){
				   canSave = checkForNull1(frm.born_where,getLabel("eMP.BornWhere.label","MP"),'Y');
			}
			if ( canSave == false )
				errorsThere = true;
		}
	
		if (frm.mother_patient_id!=null){
            canSave = checkForNull1(frm.mother_patient_id,getLabel("Common.patientId.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

		//Added by Kamatchi S for ML-MMOH-CRF-2095
		if(frm.length_of_baby_yn.value == "Y"){
		if (frm.length1!=null && frm.LENGTH_IMG.style.visibility=='visible'){
				canSave = checkForNull1(frm.length1,getLabel("eMP.LengthofBaby.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}		
		if(frm.head_circumference_of_baby_yn.value == "Y"){
			if (frm.circumference!=null && frm.CIRCUMFERENCE_IMG.style.visibility=='visible'){
				canSave = checkForNull1(frm.circumference,getLabel("Common.HeadCircumference.label","Common"),'Y');
			}
			if ( canSave == false )
				errorsThere = true;		
		}

		if(frm.isMPMandatoryFieldsNewborn.value=="true" || frm.isMPMandatoryFieldsNewborn.value == true){
		if((callfromfunction == "REGISTER_NEWBORN" || callfromfunction == "MAINTAIN_BIRTH") && (calling_module_id == "" || calling_module_id == "MP" ) && frm.mandate_first_newborn_yn.value == "Y"){
		if (frm.complns_1st_stage_labour_code!=null && frm.complns_1st_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_1st_stage_labour_code,getLabel("eMP.Complicationsin1stStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if((callfromfunction == "REGISTER_NEWBORN" || callfromfunction == "MAINTAIN_BIRTH") && (calling_module_id == "" || calling_module_id == "MP" ) && frm.mandate_second_newborn_yn.value == "Y"){
		if (frm.complns_2nd_stage_labour_code!=null && frm.complns_2nd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_2nd_stage_labour_code,getLabel("eMP.Complicationsin2ndStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if((callfromfunction == "REGISTER_NEWBORN" || callfromfunction == "MAINTAIN_BIRTH") && (calling_module_id == "" || calling_module_id == "MP" ) && frm.mandate_third_newborn_yn.value == "Y"){
		if (frm.complns_3rd_stage_labour_code!=null && frm.complns_3rd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_3rd_stage_labour_code,getLabel("eMP.Complicationsin3rdStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if( (callfromfunction == "REGISTER_NEWBORN" || callfromfunction == "MAINTAIN_BIRTH") && (calling_module_id == "" || calling_module_id == "MP" ) && frm.mand_antenatal_newborn_yn.value == "Y"){
		if (frm.ate_born_where!=null){
				canSave = checkForNull1(frm.ate_born_where,getLabel("eMP.AnteNatalCare.label","MP")+ " " +getLabel("eMP.given.label","MP")+ " " +getLabel("Common.Location.label","common"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "AE" && frm.mandate_first_newborn_ae_yn.value == "Y"){
		if (frm.complns_1st_stage_labour_code!=null && frm.complns_1st_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_1st_stage_labour_code,getLabel("eMP.Complicationsin1stStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "AE" && frm.mandate_second_newborn_ae_yn.value == "Y"){
		if (frm.complns_2nd_stage_labour_code!=null && frm.complns_2nd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_2nd_stage_labour_code,getLabel("eMP.Complicationsin2ndStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "AE" && frm.mandate_third_newborn_ae_yn.value == "Y"){
		if (frm.complns_3rd_stage_labour_code!=null && frm.complns_3rd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_3rd_stage_labour_code,getLabel("eMP.Complicationsin3rdStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "AE" && frm.mand_antenatal_newborn_ae_yn.value == "Y"){
		if (frm.ate_born_where!=null){
				canSave = checkForNull1(frm.ate_born_where,getLabel("eMP.AnteNatalCare.label","MP")+ " " +getLabel("eMP.given.label","MP")+ " " +getLabel("Common.Location.label","common"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "IP" && frm.mandate_first_newborn_ip_yn.value == "Y"){
		if (frm.complns_1st_stage_labour_code!=null && frm.complns_1st_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_1st_stage_labour_code,getLabel("eMP.Complicationsin1stStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "IP" && frm.mandate_second_newborn_ip_yn.value == "Y"){
		if (frm.complns_2nd_stage_labour_code!=null && frm.complns_2nd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_2nd_stage_labour_code,getLabel("eMP.Complicationsin2ndStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "IP" && frm.mandate_third_newborn_ip_yn.value == "Y"){
		if (frm.complns_3rd_stage_labour_code!=null && frm.complns_3rd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_3rd_stage_labour_code,getLabel("eMP.Complicationsin3rdStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(calling_module_id == "IP" && frm.mand_antenatal_newborn_ip_yn.value == "Y"){
		if (frm.ate_born_where!=null){
				canSave = checkForNull1(frm.ate_born_where,getLabel("eMP.AnteNatalCare.label","MP")+ " " +getLabel("eMP.given.label","MP")+ " " +getLabel("Common.Location.label","common"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		}

		if(frm.called_function.value != 'AE' && restrictMntryFields=="N"){//Added by Dharma on Aug 10th 2017 against ML-MMOH-CRF-0631 [IN:062148]
			if(frm.isRegNewbornApplicable.value=="true" || frm.isRegNewbornApplicable.value == true ){//Condition added by kamatchi S for ML-MMOH-CRF-2095
			if (frm.length1!=null && frm.LENGTH_IMG.style.visibility=='visible'){
				 canSave = checkForNull1(frm.length1,getLabel("eMP.LengthofBaby.label","MP"),'Y');
			}
			if ( canSave == false )
				errorsThere = true;

			if (frm.circumference!=null && frm.CIRCUMFERENCE_IMG.style.visibility=='visible'){
				canSave = checkForNull1(frm.circumference,getLabel("Common.HeadCircumference.label","Common"),'Y');
			}
			if ( canSave == false )
				errorsThere = true;
			}

			/*

			if(frm.ip_install_yn.value=='Y')
			{	
			if (frm.invoke_adm_from_newborn_yn.value!='Y')
			{	

			if(frm.bed_number)
			{	
				var outcome=frm.outcome.value;
			if (frm.bed_number.value == '' && outcome=='L')
			{

				  canSave = checkForNull(getLabel("Common.bedno.label","Common"));
			}
			if ( canSave == false )
				errorsThere = true;
			}
			}
			}
			*/

			if(frm.outcome.value=='L'&& frm.born_where.value=='I'){
				if (frm.apgar_score!=null){
					  canSave =checkForNull1(frm.apgar_score,getLabel("Common.ApgarScore.label","Common")+" "+ getLabel("eMP.in1Min.label","MP"),'Y')
				}
				if ( canSave == false )
					errorsThere = true;

				canSave =checkForNull1(frm.heart_rate_in_1_min,(getLabel("eMP.HeartRateAtMin.label","MP").replace('#','1')),'Y'); 
				if ( canSave == false )
					errorsThere = true;
				canSave =checkForNull1(frm.breathing_in_1_min,(getLabel("eMP.BreathingAtMin.label","MP").replace('#','1')),'Y'); 
				if ( canSave == false )
					errorsThere = true;
				canSave =checkForNull1(frm.grimace_in_1_min,(getLabel("eMP.GrimaceAtMin.label","MP").replace('#','1')),'Y'); 
				if ( canSave == false )
					errorsThere = true;
				canSave =checkForNull1(frm.activity_in_1_min,(getLabel("eMP.ActivityAtMin.label","MP").replace('#','1')),'Y'); 
				if ( canSave == false )
					errorsThere = true;
				canSave =checkForNull1(frm.appearance_in_1_min,(getLabel("eMP.AppearanceAtMin.label","MP").replace('#','1')),'Y');
				if ( canSave == false )
					errorsThere = true;

				if (frm.apgar_score_five_min!=null && frm.APGAR_SCORE_IN_5_MINS_YN_IMG.style.visibility=='visible'){
					canSave =checkForNull1(frm.apgar_score_five_min,getLabel("Common.ApgarScore.label","Common")+" "+ getLabel("eMP.in5Min.label","MP"),'Y')

					canSave =checkForNull1(frm.heart_rate_in_5_min,(getLabel("eMP.HeartRateAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.breathing_in_5_min,(getLabel("eMP.BreathingAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.grimace_in_5_min,(getLabel("eMP.GrimaceAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.activity_in_5_min,(getLabel("eMP.ActivityAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.appearance_in_5_min,(getLabel("eMP.AppearanceAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
				}

				if ( canSave == false )
					errorsThere = true;

				if (frm.apgar_score_ten_min.value!=null && frm.APGAR_SCORE_IN_10_MINS_YN_IMG.style.visibility=='visible'){
					canSave =checkForNull1(frm.apgar_score_ten_min,getLabel("Common.ApgarScore.label","Common")+" "+ getLabel("eMP.in10Min.label","MP"),'Y')

					canSave =checkForNull1(frm.heart_rate_in_10_min,(getLabel("eMP.HeartRateAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.breathing_in_10_min,(getLabel("eMP.BreathingAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.grimace_in_10_min,(getLabel("eMP.GrimaceAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.activity_in_10_min,(getLabel("eMP.ActivityAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.appearance_in_10_min,(getLabel("eMP.AppearanceAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
				}
				if ( canSave == false )
					errorsThere = true;

				if (frm.patency_of_anus_yn!=null && frm.PATENCY_OF_ANUS_YN_IMG.style.visibility=='visible'){
				  canSave = checkForNull1(frm.patency_of_anus_yn,getLabel("eMP.PatencyofAnus.label","MP"),'Y');
				}
				if ( canSave == false )
				errorsThere = true;
			}

			if (frm.practid_desc!=null){
				if(isNewBornChngsAppl=="true"){
					 canSave = checkForNull1(frm.practid_desc,getLabel("Common.ConductedBy.label","Common"),'Y');
				}else {
						if(isAllow_External_Newborn =="true" && born_where =='I' && allow_ext_nb_regn_within_days!='' && allow_ext_nb_regn_within_days !=null)
						{
						canSave = checkForNull1(frm.practid_desc,getLabel("Common.AttendingPractitioner.label","Common"),'Y');
						}
						else if(isAllow_External_Newborn =="true" && born_where !='I' && allow_ext_nb_regn_within_days!='' && allow_ext_nb_regn_within_days !=null){
							//canSave = false;
						}
						else
						{
							canSave = checkForNull1(frm.practid_desc,getLabel("Common.AttendingPractitioner.label","Common"),'Y');	
						}
					}
				}

			if ( canSave == false )
				errorsThere = true;
			
			if (frm.weight!=null){
				canSave = checkForNull1(frm.weight,getLabel("eMP.BirthWeight.label","MP"),'Y');
			}
			if ( canSave == false )
				errorsThere = true;

			if (frm.nod_type!=null){
				canSave = checkForNull1(frm.nod_type,getLabel("eMP.natureofdelivery.label","MP"),'Y');
			} 
			if ( canSave == false )
			errorsThere = true;
			if(frm.outcome.value=='L'&& frm.born_where.value=='I'){
				if (frm.Umb_cord_cut_by1!=null){
					canSave = checkForNull1(frm.Umb_cord_cut_by1,getLabel("eMP.UmbCordCutBy.label","MP"),'Y');
				}
				if ( canSave == false )
					errorsThere = true;
			}

		}
	}

	if(restrictMntryFields=="Y"){
			if (frm.nod_type!=null){
				canSave = checkForNull1(frm.nod_type,getLabel("eMP.natureofdelivery.label","MP"),'Y');
			} 
			if ( canSave == false )
			errorsThere = true;
	}
	
	if(frm.called_function.value == 'AE'  && restrictMntryFields=="N"){
	if((frm.father_patient_id.value != '' || frm.father_patient_name.value != '') && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y')){
			if(frm.enable_marital_status.value == 'Y'){
			if( frm.no_marital_status.checked == false ){
			if(frm.cboNationality_desc!=null)
				canSave = checkForNull1(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y');
			if(canSave == false) errorsThere = true;
			}
			if( frm.no_marital_status.checked == true ){
			if(frm.cboNationality_desc!=null )
				canSave = checkForNull2(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y',true);
			if(canSave == false) errorsThere = true;	
			}
			}
			else
			{
				if(frm.cboNationality_desc!=null )
				canSave = checkForNull1(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y');
			if(canSave == false) errorsThere = true;
			}
		}
		else if((frm.father_patient_id.value != '' || frm.father_patient_name.value != '') && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'N')){
			if(frm.cboNationality_desc!=null )
				canSave = checkForNull1(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y');
			if(canSave == false) errorsThere = true;	
		}
		else
		{
			if(frm.cboNationality_desc!=null &&  frm.natImg.style.visibility == 'visible' )
				canSave = checkForNull1(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y');
			if(canSave == false) errorsThere = true;	
		}
		if(((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y')) {
			if(frm.enable_marital_status.value == 'Y'){
			if( frm.no_marital_status.checked == false ){
				if(frm.racImg.style.visibility == 'visible'){
			if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull1(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y');
				if(canSave == false) errorsThere = true;
				}
			}
			if( frm.no_marital_status.checked == true ){
			if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull2(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y',true);
				if(canSave == false) errorsThere = true;
			}
			}
			else
			{
				if(frm.racImg.style.visibility == 'visible'){
				if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull1(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y');
				if(canSave == false) errorsThere = true;
				}
			}

		}
		else if(frm.racImg.style.visibility == 'visible' && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'N')) {
			if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull1(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y');
				if(canSave == false) errorsThere = true;
		}
		else{
		if(frm.racImg.style.visibility == 'visible' && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false') ) {
			if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull1(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y');
				if(canSave == false) errorsThere = true;
		}
		}
}
	if(frm.called_function.value != 'AE'  && restrictMntryFields=="N"){//Added by Dharma on Aug 10th 2017 against ML-MMOH-CRF-0631 [IN:062148]
		if(frm.outcome.value=='S'&& frm.born_where.value=='I'){
			if (frm.Umb_cord_cut_by1!=null){
				canSave = checkForNull1(frm.Umb_cord_cut_by1,getLabel("eMP.UmbCordCutBy.label","MP"),'Y');
			}
			if ( canSave == false )
				errorsThere = true;
		}
	
		/*if(frm.father_patient_id.value != '' || frm.father_patient_name.value != ''){
			if(frm.cboNationality_desc!=null)
				canSave = checkForNull1(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y');
			if(canSave == false) errorsThere = true;}*/
		//Above condition commented and below condition added for ML-MMOH-CRF-2097 by kamatchi S
		if((frm.father_patient_id.value != '' || frm.father_patient_name.value != '') && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y')){
			if(frm.enable_marital_status.value == 'Y'){
			if( frm.no_marital_status.checked == false ){
			if(frm.cboNationality_desc!=null)
				canSave = checkForNull1(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y');
			if(canSave == false) errorsThere = true;
			}
			if( frm.no_marital_status.checked == true ){
			if(frm.cboNationality_desc!=null )
				canSave = checkForNull2(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y',true);
			if(canSave == false) errorsThere = true;	
			}
			}
			else
			{
				if(frm.cboNationality_desc!=null )
				canSave = checkForNull1(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y');
			if(canSave == false) errorsThere = true;
			}
		}
		else if((frm.father_patient_id.value != '' || frm.father_patient_name.value != '') && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'N')){
			if(frm.cboNationality_desc!=null )
				canSave = checkForNull1(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y');
			if(canSave == false) errorsThere = true;	
		}
		else
		{
			if((frm.father_patient_id.value != '' || frm.father_patient_name.value != '') && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false') ){
			if(frm.cboNationality_desc!=null )
				canSave = checkForNull1(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y');
			if(canSave == false) errorsThere = true;	
		}
		}
		if(((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y')) {
			if(frm.enable_marital_status.value == 'Y'){
			if( frm.no_marital_status.checked == false ){
				if(frm.racImg.style.visibility == 'visible'){
			if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull1(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y');
				if(canSave == false) errorsThere = true;
				}
			}
			if( frm.no_marital_status.checked == true ){
			if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull2(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y',true);
				if(canSave == false) errorsThere = true;
			}
			}
			else
			{
				if(frm.racImg.style.visibility == 'visible'){
				if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull1(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y');
				if(canSave == false) errorsThere = true;
				}
			}

		}
		else if(frm.racImg.style.visibility == 'visible' && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'N')) {
			if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull1(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y');
				if(canSave == false) errorsThere = true;
		}
		else{
		if(frm.racImg.style.visibility == 'visible' && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false') ) {
			if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull1(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y');
				if(canSave == false) errorsThere = true;
		}
		}
	}
    if(canSave == true && errorsThere == false){
        if(!birthTimeCheck())
        {
           canSave = false;
            errosThere = true;
       }
		if (!checkMinMax())
		{
			canSave = false;
          errosThere = true;
		}
    }else{
        if(function_id!="") {}
  
    }

//	var dtVal=frm.date_of_birth.value;	
//Commented the above line the added the below line for IN031143 on 20.02.2012 by Suresh M

if(localeName=="en"){
	var dtVal=frm.date_of_birth.value;	 
}else{
	var dtVal = convertDate(frm.date_of_birth.value,"DMYHM",localeName,"en");	
}
//IN031143 Ends
	var hddDTTM=parent.parent.f_query_add_mod.frames[2].getCurrentDate('DMYHM',localeName)
    
	var dt=dtVal.substring(0,dtVal.indexOf(" " ));
	var tm=dtVal.substring(dtVal.indexOf(" " )+1);
	var hr=tm.substring(0,tm.indexOf(":" ));
	var mt=tm.substring(tm.indexOf(":" )+1);

	var dt1=hddDTTM.substring(0,hddDTTM.indexOf(" " ));
	var tm1=hddDTTM.substring(hddDTTM.indexOf(" " )+1);
	var hr1=tm1.substring(0,tm1.indexOf(":" ));
	var mt1=tm1.substring(tm1.indexOf(":" )+1);
	frm.hddDate.value=dt1;
	frm.hddBDate.value=dt;
	
	if(parseInt(dt.substring(dt.indexOf("/")+1,dt.lastIndexOf("/")))==2){
		if(parseInt(dt.substring(0,dt.indexOf("/")))>29){
			
			
			alert(getMessage("INVALID_DATE_FMT","SM"));		
			frm.birth_date.value='';	
			frm.birth_date.focus();	

			canSave = false;
            errosThere = true;
		}
		if(parseInt(dt.substring(0,dt.indexOf("/")))==29){
			if(!leapyear(dt.substring(dt.lastIndexOf("/")+1))){
			
			alert(getMessage("INVALID_DATE_FMT","SM"));		
			frm.birth_date.value='';	
			frm.birth_date.focus();	
			
				canSave = false;
	            errosThere = true;
			}
		}
	}	
	
	if(Date.parse(dt1) == Date.parse(dt)){	
		if(frm.birth_time.value!="" && frm.birth_date.value !=""){
			var tempDtVal = frm.birth_date.value+" "+frm.birth_time.value;
			if(parent.newbornmain_frame.isBeforeNow(tempDtVal,"DMYHM",localeName)){
			}else{   
				var msg = self.getMessage("BIRTH_TIME_GREATER_SYSTIME","MP");			
				alert(msg);
				canSave = false;
				errosThere = true;
			}
		}
		/*if(eval(hr) > eval(hr1)){		
			var msg = self.getMessage("BIRTH_TIME_GREATER_SYSTIME","MP");			
			alert(msg);
			/*
			parent.parent.f_query_add_mod.frames[temp].document.forms[0].date_of_birth.value='';	
			parent.parent.f_query_add_mod.frames[temp].document.forms[0].date_of_birth.focus();
			*/
			/*frm.birth_time.value='';	
			frm.birth_time.focus();
			canSave = false;
            errosThere = true;
		}else if(eval(hr) == eval(hr1)){
			if(eval(mt)>eval(mt1)){	  	
				var msg = self.getMessage("BIRTH_TIME_GREATER_SYSTIME","MP");
				alert(msg);					
				/*
				parent.parent.f_query_add_mod.frames[temp].document.forms[0].date_of_birth.value='';	
				parent.parent.f_query_add_mod.frames[temp].document.forms[0].date_of_birth.focus();
				*/
				/*frm.birth_time.value='';	
				frm.birth_time.focus();
				canSave = false;
	            errosThere = true;
			}
		}*/
	}

	/* Validation for validating the condition Birth Date <= Adm Date/Time <= System Date / Time
		- Vinod 4/10/2006
	*/	   
	var birth_date = frm.date_of_birth;
	var to = 	frm.bcg_datetime;
	if( (to.value!='') && (birth_date.value!='') ){	
		if(!ValidateBDateTime(birth_date,to)){
			var str = self.getMessage("CANNOT_LESSER","MP");
			str = str.replace('#', getLabel("eMP.BCG.label","MP") +' '+getLabel("Common.AdmissionDateTime.label","common"));
			str = str.replace('$', getLabel("Common.birthDate.label","common") + "/" + getLabel("Common.time.label","common"));
			alert(str);	
			obj.select();
			obj.focus();	
			canSave = false;
			errosThere = true;
		}
	}
		
	var to =frm.vitk_datetime;
	if((to.value!='') && (birth_date.value!='') ){
		if(!ValidateBDateTime(birth_date,to)){
			var str = self.getMessage("CANNOT_LESSER","MP");
			str = str.replace('#', getLabel("eMP.VitaminK.label","MP") +' '+ getLabel("Common.AdmissionDateTime.label","common"));
			str = str.replace('$', getLabel("Common.birthDate.label","common") + "/" + getLabel("Common.time.label","common"));
			alert(str);	
			obj.select();
			obj.focus();	
			canSave = false;
			errosThere = true;
		}
	}

	var to = frm.hepb_datetime;
	if((to.value!='') && (birth_date.value!='')){
		if(!ValidateBDateTime(birth_date,to)){
			var str = self.getMessage("CANNOT_LESSER","MP");
			str = str.replace('#', getLabel("eMP.HepatitisB.label","MP") +' '+ getLabel("Common.AdmissionDateTime.label","common"));
			str = str.replace('$', getLabel("Common.birthDate.label","common") + "/" + getLabel("Common.time.label","common"));
			alert(str);	
			obj.select();
			obj.focus();			
			canSave = false;
			errosThere = true;
		}
	}
	
	if(canSave == true && errorsThere == false){
		var isSubmit	= "Y";
		if((frm.isNeonatalApplicable&&frm.isNeonatalApplicable.value=="true"&&frm.sel_accession_num &&frm.sel_accession_num.value ==""&&parent.parent.f_query_add_mod.frames[1].document.NewbornRegistration_form.add_records&&parent.parent.f_query_add_mod.frames[1].document.NewbornRegistration_form.add_records.value=="Finalize") || (frm.isNeonatalApplicable&&frm.isNeonatalApplicable.value=="true"&&frm.sel_accession_num &&frm.sel_accession_num.value =="" && frm.single_stage_appl_yn&&frm.single_stage_appl_yn.value=="Y")) {
			if(parent.parent.f_query_add_mod.frames[1].document.forms[0].add_records)
				parent.parent.f_query_add_mod.frames[1].document.forms[0].add_records.disabled = false;	
				if(confirm(getMessage('ACCESSION_NUMBER','MP'))){
					isSubmit	= "Y";
				}else{
					isSubmit	= "N";
				}
			}

		if(isSubmit=="Y"){
			frm.multiple_birth_yn.disabled=false;
			frm.remarks.disabled = false;
			if(frm.invoked_from.value != 'details_page'){
				if(frm.father_alt_id1_no)
					frm.father_alt_id1_no.disabled = false;
				if(frm.father_alt_id2_no)
					frm.father_alt_id2_no.disabled = false;
				if(frm.father_alt_id3_no)
					frm.father_alt_id3_no.disabled = false;
				if(frm.father_alt_id4_no)
					frm.father_alt_id4_no.disabled = false;
			}

			frm.pat_ser_grp_code.value=parent.parent.f_query_add_mod.frames[1].document.NewbornRegistration_form.pat_ser_grp_code.value;
			frm.patient_id.value=parent.parent.f_query_add_mod.frames[1].document.NewbornRegistration_form.patient_id.value;
			frm.new_born_sex.disabled	= false;
			frm.date_of_birth.disabled	= false;
			frm.outcome.disabled	= false;
			var sStyle =  frm.sStyle.value;
			if(frm.called_function.value == 'IP' && (frm.isMPMandatoryFieldsNewborn.value== 'false' || frm.isMPMandatoryFieldsNewborn.value == false)) {
				if(frm.captureAntenatalDtlsYN.value == 'Y'){				
					frm.antenatal_care.disabled = false;
				}
			}
			if(function_id == ""){ 

				en_Able();
				frm.circumference_unit.disabled=false;
				frm.chest_circumference_unit.disabled=false;
				frm.length_unit.disabled=false;
				frm.weight_unit.disabled=false;
				frm.gestational_unit.disabled=false; 			

			if(frm.father_alt_id1_no){
				if(frm.father_alt_id1_no.disabled == true){
				    if(frm.invoked_from.value != 'details_page'){	
					if(frm.father_alt_id1_no)
					frm.father_alt_id1_no.disabled=false;
					}
				}
			}
			if(frm.father_alt_id2_no){
				if(frm.father_alt_id2_no.disabled == true){
				    if(frm.invoked_from.value != 'details_page'){ 
					if(frm.father_alt_id2_no)	
					frm.father_alt_id2_no.disabled=false;
					}
				}
			}
			if(frm.father_alt_id3_no){
				if(frm.father_alt_id3_no.disabled == true){
				    if(frm.invoked_from.value != 'details_page'){	
					if(frm.father_alt_id3_no)
					frm.father_alt_id3_no.disabled=false;
					}
				}
			}
			if(frm.father_alt_id4_no){
				if(frm.father_alt_id4_no.disabled == true){
				    if(frm.invoked_from.value != 'details_page'){
					if(frm.father_alt_id4_no)
					frm.father_alt_id4_no.disabled=false;
					}
				}
			}
			enable_flds(temp); 

			frm.complns_1st_stage_labour_code.disabled = false;
			frm.complns_2nd_stage_labour_code.disabled = false;
			frm.complns_3rd_stage_labour_code.disabled = false;	
			frm.action = "../../servlet/eMP.NewbornRegistrationServlet";
			frm.target = "messageFrame";
				frm.submit();   

			}else{
				frm.circumference_unit.disabled=false;
				frm.chest_circumference_unit.disabled=false;
				frm.length_unit.disabled=false;
				frm.weight_unit.disabled=false;
				frm.gestational_unit.disabled=false;

			en_Able();

			enable_flds(temp);

		    var s = "<html><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><head>" ;

			s+="</head><body class='message' onKeyDown='lockKey()'><form name='NewbornRegistration_form' id='NewbornRegistration_form' method='post'  action='../../servlet/eMP.NewbornRegistrationServlet' target='messageFrame'>";

	        //var frm1 = frames[1].frames[temp].document.forms[0]
	        var frm1 = parent.parent.frames[1].frames[temp].document.forms[0]
		    for(i=0;i<frm1.elements.length;i++){
				if(frm1.elements[i].type=='checkbox'){
			        if(frm1.elements[i].checked){
				        s += "<input type='hidden' name='"+frm1.elements[i].name+"' id='"+frm1.elements[i].name+"' value='Y'>"
					}else{
						s += "<input type='hidden' name='"+frm1.elements[i].name+"' id='"+frm1.elements[i].name+"' value='N'>"
					}
				 }else{
					s += "<input type='hidden' name='"+frm1.elements[i].name+"' id='"+frm1.elements[i].name+"' value=\""+frm1.elements[i].value+"\">"
				 }
			}
			s+="</body></html>"
			parent.parent.messageFrame.document.open();
			parent.parent.messageFrame.document.write(s); 

			frm.complns_1st_stage_labour_code.disabled = false;
			frm.complns_2nd_stage_labour_code.disabled = false;
			frm.complns_3rd_stage_labour_code.disabled = false;
               parent.parent.messageFrame.document.NewbornRegistration_form.action = "../../servlet/eMP.NewbornRegistrationServlet";
			   parent.parent.messageFrame.document.NewbornRegistration_form.target = "messageFrame";
				parent.parent.messageFrame.document.NewbornRegistration_form.submit();
				frm.sltRelationship.disabled=true;	
                  
			}

		}
	}else{
		if(parent.parent.f_query_add_mod.frames[1].document.forms[0].add_records){
			parent.parent.f_query_add_mod.frames[1].document.forms[0].add_records.disabled = false;
		}
		/*
		var accessRights=frm.accessRights.value; 
		parent.parent.commontoolbarFrame.location.href = '../../eCommon/jsp/commonToolbar.jsp?module_id=MP&function_id=NEWBORN_REG&function_name='+getLabel('eMP.RegNewBorn.label','MP')+'&function_type=F&access='+accessRights;
        parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num='+LocalErrors;
		*/
		
		parent.parent.messageFrame.location = '../../eCommon/jsp/error.jsp?err_num='+LocalErrors;
	}
} 

function enable_flds (temp) {
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.multiple_birth_yn) {
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.multiple_birth_yn.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.noOfBirths) {
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.noOfBirths.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.gestational_period) {
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.gestational_period.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.gestational_period_days)
	{																													parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.gestational_period_days.disabled 
		= false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.gestational_unit) 	{
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.gestational_unit.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.nod_type) {
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.nod_type.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.gravida) {							parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.gravida.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.parity)			 	{
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.parity.disabled = false;
	}
	/*Below line added for this CRF ML-MMOH-CRF-0621*/
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.parity_on_admission){
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.parity_on_admission.disabled = false;
	}	
	//End ML-MMOH-CRF-0621
	
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.practid_desc) {
	   parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.practid_desc.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.att_nurse_newborn)		 	{
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.att_nurse_newborn.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.att_nurse_search) {          	      parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.att_nurse_search.disabled =          false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.comple_ofdel_newborn)		{
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.comple_ofdel_newborn.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.comple_of_button) {                   parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.comple_of_button.disabled =          false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.del_indica_newborn)	{
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.del_indica_newborn.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.del_indica_button)	{
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.del_indica_button.disabled = 
			false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.proc_class_desc) {
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.proc_class_desc.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.del_indica_newborn) {
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.del_indica_newborn.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.del_indica_button) {
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.del_indica_button.disabled = false;
	}
	if(document.forms[0].proc_class_desc) {		 
		document.forms[0].proc_class_desc.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.proc_id) {
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.proc_id.disabled = false; 
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.vaginal_del_type_desc) {   			parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.vaginal_del_type_desc.disabled = 	false;
	}
	if(document.forms[0].vaginal_del_type_search) {
		document.forms[0].vaginal_del_type_search.disabled = false;		
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.del_serv_desc)         	{
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.del_serv_desc.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.del_serv_id){
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.del_serv_id.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.remarks) {
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.remarks.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.father_patient_id) {
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.father_patient_id.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.pat_id_search){
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.pat_id_search.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.father_patient_name) {
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.father_patient_name.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.nb_patient_name) {
		parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.nb_patient_name.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.National_id) {
		 parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.National_id.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboOtherAltID){
		 parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboOtherAltID.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.txtOtherAltID) {
		 parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.txtOtherAltID.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboNationality_desc){
		 parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboNationality_desc.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboNationality_button) {
		 parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboNationality_button.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboEthnicGroup) {
		 parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboEthnicGroup.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboEthnicGroupDesc) {
		 parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboEthnicGroupDesc.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboEthnicGroupBtn) {
		 parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboEthnicGroupBtn.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.fthGovtEmpl) {
		 parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.fthGovtEmpl.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboReligion){
		 parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboReligion.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboOccupationClass) {
		 parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboOccupationClass.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboOccupation) {
		 parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.cboOccupation.disabled = false;
	}
	if(parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.fatherRemarks) {
		 parent.parent.f_query_add_mod.frames[temp].document.NewbornRegistration_form.fatherRemarks.disabled = false;
	}
}

function apply() {
		
	//  Maintain Birth Register Function starts here 
	var temp = 2;
	callfromfunctionsucc=callfromfunction
	
	var callfromfunction=f_query_add_mod.frames[2].document.forms[0].function_id_mg.value;
	callfromfunctionsucc=callfromfunction

	var called_function	= f_query_add_mod.frames[2].document.forms[0].called_function.value;
	var isNewBornChngsAppl	= "";
	if(f_query_add_mod.frames[2].document.forms[0].isNewBornChngsAppl){
		isNewBornChngsAppl	= f_query_add_mod.frames[2].document.forms[0].isNewBornChngsAppl.value;
	}
	var fatherDtlsIndex			= 0;
	var newBornDtlsIndex		= 1;
	var attPracLegend			= getLabel("Common.AttendingPractitioner.label","Common");
	if(called_function=="IP" && isNewBornChngsAppl	=="true"){
		var fatherDtlsIndex		= 1;
		var newBornDtlsIndex	= 0;
	}
	if(isNewBornChngsAppl=="true"){
		attPracLegend	=  getLabel("Common.ConductedBy.label","Common");
	}
	/*
	if(callfromfunction=='REGISTER_NEWBORN')
             temp=2;
		else{
             temp=2;
		}
	*/

	var frm = f_query_add_mod.frames[temp].document.NewbornRegistration_form;
	if(frm.invokeMenstrualHistYN.value == 'Y' && frm.called_function.value == 'MP'){
		if(frm.mandParityNewBornYN.value== 'Y'){
		if(frm.parity1.value!=null){
				canSave = checkForNull1(frm.parity1,getLabel("eMP.Parity.label","MP"),'Y'); 
			if(canSave == false) 
				errorsThere = true;
		}
		if(frm.parity.value!=null){
			canSave = checkForNull1(frm.parity,getLabel("eMP.Parity.label","MP"),'Y'); 
		if(canSave == false) 
			errorsThere = true;
	}
	}
	}
	//end 68508
	
	if(frm.fthGovtEmpl.checked==true)
	   frm.fthGovtEmpl.value='Y';
	else
       frm.fthGovtEmpl.value='N';
	if(frm.complications_delivery_text.value=='')
	{
       frm.complications_delivery_nb.value=''
	}
	if(frm.Congenital_Anomalies_newborn.value=='')
	{
       frm.Congenital_Anomalies.value=''
	}
	
	if(frm.att_nurse_newborn.value=='')
	{
       frm.attend_midwife_id.value=''
	}
	if(frm.comple_ofdel_newborn.value=='')
	{
       frm.complications_delivery.value=''
	}
	if(frm.del_indica_newborn.value=='')
	{
       frm.delivery_indication.value=''
	}
	if(frm.cboNationality_desc.value=='')
	{
      frm.cboNationality.value=''
	}


    LocalErrors = '';

    var canSave = new Boolean(true);
	var errorsThere = new Boolean(false);
	if(frm.complications_delivery_text.value=='')
	{
       frm.complications_delivery_nb.value=''
	}
	if(frm.Congenital_Anomalies_newborn.value=='')
	{
       frm.Congenital_Anomalies.value=''
	}

	if(frm.att_nurse_newborn.value=='')
	{
       frm.attend_midwife_id.value=''
	}
	if(frm.comple_ofdel_newborn.value=='')
	{
      frm.complications_delivery.value=''
	}
	if(frm.del_indica_newborn.value=='')
	{
       frm.delivery_indication.value=''
	}

	if(frm.name_prefix) {		
		frm.father_name_prefix.value=frm.name_prefix[0].value;
	}

	if(frm.first_name) {		
		frm.father_first_name.value=frm.first_name[0].value;
	}

	if(frm.second_name) {		
		frm.father_second_name.value=frm.second_name[0].value;
	}

	if(frm.third_name) {		
		frm.father_third_name.value=frm.third_name[0].value;
	}

	if(frm.family_name) {		
		frm.father_family_name.value=frm.family_name[0].value;
	
		
	}

	if(frm.name_suffix) {		
		frm.father_name_suffix.value=frm.name_suffix[0].value;
	} 
	
	
	
	var isRegNewbornApplicable=frm.isRegNewbornApplicable.value; //Added for this CRF ML-MMOH-CRF-0621
	
	if(frm.outcome.value=="S" && isRegNewbornApplicable=="false"){ //Modified for this CRF ML-MMOH-CRF-0621
		if(frm.pract_id_still_birth.value=="" || frm.cond_cau_dea_main_cod.value=="" || frm.cond_cau_dea_main_cod_dur.value==""){
			frm.still_brith_dtls_mand.value="";
			canSave = checkForNull1(frm.still_brith_dtls_mand,getLabel("eMP.StillBirthDtls.label","MP"),'Y');
			if ( canSave == false )
				errorsThere = true;
		}
	}

			/*if (frm.name_prefix != null )
			{				
				if (frm.name_prefix_reqd_yn!=null && frm.name_prefix_reqd_yn[0].value=='Y')
				{
					canSave = checkForNull1(frm.name_prefix[0],getLabel('eMP.Father.label','MP')+" "+frm.name_prefix_prompt[0].value,'Y');
				}
				if ( canSave == false )
					errorsThere = true;
			}

			if (frm.first_name != null )
			{
				if (frm.first_name_reqd_yn != null )
                if (frm.first_name_reqd_yn[0].value == 'Y' )
                    canSave = checkForNull1(frm.first_name[0],getLabel('eMP.Father.label','MP')+" "+frm.first_name_prompt[0].value,'Y');
                if ( canSave == false )
                    errorsThere = true;              
            }

			if (frm.second_name != null )
            {
				if (frm.second_name_reqd_yn != null )
                if (frm.second_name_reqd_yn[0].value == 'Y' )
                    canSave = checkForNull1(frm.second_name[0],getLabel('eMP.Father.label','MP')+" "+frm.second_name_prompt[0].value,'Y');
                if ( canSave == false )
                    errorsThere = true;              
            }

			if (frm.third_name != null )
            {
				if (frm.third_name_reqd_yn != null )
                if (frm.third_name_reqd_yn[0].value == 'Y' )
                    canSave = checkForNull1(frm.third_name[0],getLabel('eMP.Father.label','MP')+" "+frm.third_name_prompt[0].value,'Y');
                if ( canSave == false )
                    errorsThere = true;              
            }

			if (frm.family_name != null )
            {
				if (frm.family_name_reqd_yn != null)
                if (frm.family_name_reqd_yn[0].value == 'Y' )
                      canSave = checkForNull1(frm.family_name[0],getLabel('eMP.Father.label','MP')+" "+frm.family_name_prompt[0].value,'Y');
                  
                
				if ( canSave == false )
                    errorsThere = true;              
            }

			if (frm.name_suffix != null )
			{
				if (frm.name_suffix_reqd_yn != null)
				if (frm.name_suffix_reqd_yn[0].value == 'Y' )
					canSave = checkForNull1(frm.name_suffix[0],getLabel('eMP.Father.label','MP')+" "+frm.name_suffix_prompt[0].value,'Y');
				if ( canSave == false )
					errorsThere = true;
			} 	*/
			//Above condition commented and below condition added for ML-MMOH-CRF-2097 by Kamatchi S
	if (frm.name_prefix != null && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y') ){//nb_father_name_mandatory_yn newborn father checkbox checked
		if(frm.enable_marital_status.value == 'Y'){//enable_marital_status checkbox checked 
	if(frm.no_marital_status.checked == false){
		if (frm.name_prefix_reqd_yn!=null && frm.name_prefix_reqd_yn[fatherDtlsIndex].value=='Y'){
			canSave = checkForNull1(frm.name_prefix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_prefix_prompt[fatherDtlsIndex].value,'Y');
			if(canSave == false )
			errorsThere = true;
			}
		}
		if(frm.no_marital_status.checked == true){
		if (frm.name_prefix_reqd_yn!=null && frm.name_prefix_reqd_yn[fatherDtlsIndex].value=='Y'){
			canSave = checkForNull2(frm.name_prefix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_prefix_prompt[fatherDtlsIndex].value,'Y',true);
			if(canSave == false )
			errorsThere = true;
			}
		}
		}
		else
		{
			if (frm.name_prefix_reqd_yn!=null && frm.name_prefix_reqd_yn[fatherDtlsIndex].value=='Y'){
			canSave = checkForNull1(frm.name_prefix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_prefix_prompt[fatherDtlsIndex].value,'Y');
			if(canSave == false )
			errorsThere = true;
			}
		}
	}
	else{
		if (frm.name_prefix != null && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false')){
		if (frm.name_prefix_reqd_yn!=null && frm.name_prefix_reqd_yn[fatherDtlsIndex].value=='Y'){
			canSave = checkForNull1(frm.name_prefix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_prefix_prompt[fatherDtlsIndex].value,'Y');
			if(canSave == false )
			errorsThere = true;
			}
			}
		}
	if (frm.first_name != null && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y')  ){
		if(frm.enable_marital_status.value == 'Y'){
		if(frm.no_marital_status.checked == false){
		if (frm.first_name_reqd_yn != null )
			if (frm.first_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.first_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.first_name_prompt[fatherDtlsIndex].value,'Y');
            if ( canSave == false )
                errorsThere = true;              
	}
	if(frm.no_marital_status.checked == true){
		if (frm.first_name_reqd_yn != null )
			if (frm.first_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull2(frm.first_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.first_name_prompt[fatherDtlsIndex].value,'Y',true);
            if ( canSave == false )
                errorsThere = true;              
	}
		}
		else
		{
			if (frm.first_name_reqd_yn != null )
			if (frm.first_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.first_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.first_name_prompt[fatherDtlsIndex].value,'Y');
            if ( canSave == false )
                errorsThere = true;   
		}
	}
	else
	{
		if (frm.first_name != null && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false')){
		if (frm.first_name_reqd_yn != null)
			if (frm.first_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.first_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.first_name_prompt[fatherDtlsIndex].value,'Y');
            if ( canSave == false )
                errorsThere = true;              
	}
	}
	if (frm.second_name != null && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y') ){
		if(frm.enable_marital_status.value == 'Y'){
		if(frm.no_marital_status.checked == false){
		if(frm.second_name_reqd_yn != null )
			if (frm.second_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.second_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.second_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	if(frm.no_marital_status.checked == true){
		if(frm.second_name_reqd_yn != null )
			if (frm.second_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull2(frm.second_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.second_name_prompt[fatherDtlsIndex].value,'Y',true);
		if ( canSave == false )
			errorsThere = true;              
	}
		}
		else{
			if(frm.second_name_reqd_yn != null )
			if (frm.second_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.second_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.second_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
		}
	}
	else{
		if (frm.second_name != null  && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false') ){
		if(frm.second_name_reqd_yn != null )
			if (frm.second_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.second_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.second_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	}

	if (frm.third_name != null && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y')){
		if(frm.enable_marital_status.value == 'Y'){
		if(frm.no_marital_status.checked == false){
		if (frm.third_name_reqd_yn != null )
			if (frm.third_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.third_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.third_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	if(frm.no_marital_status.checked == true){
		if (frm.third_name_reqd_yn != null )
			if (frm.third_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull2(frm.third_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.third_name_prompt[fatherDtlsIndex].value,'Y',true);
		if ( canSave == false )
			errorsThere = true;              
	}
		}
		else{
			if (frm.third_name_reqd_yn != null )
			if (frm.third_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.third_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.third_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
		}
	}
	else
	{
	if (frm.third_name != null && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false')){
		if (frm.third_name_reqd_yn != null )
			if (frm.third_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.third_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.third_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	}
	if (frm.family_name != null && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y')){
		if(frm.enable_marital_status.value == 'Y'){
		if(frm.no_marital_status.checked == false){
		if (frm.family_name_reqd_yn != null)
			if (frm.family_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.family_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.family_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	if(frm.no_marital_status.checked == true){
		if (frm.family_name_reqd_yn != null)
			if (frm.family_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull2(frm.family_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.family_name_prompt[fatherDtlsIndex].value,'Y',true);
		if ( canSave == false )
			errorsThere = true;              
	}
		}
		else{
			if (frm.family_name_reqd_yn != null)
			if (frm.family_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.family_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.family_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;  
		}
	}
	else
	{
		if (frm.family_name != null && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false')){
		if (frm.family_name_reqd_yn != null)
			if (frm.family_name_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.family_name[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.family_name_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;              
	}
	}
	if (frm.name_suffix != null && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y') ){
		if(frm.enable_marital_status.value == 'Y'){
		if(frm.no_marital_status.checked == false){
		if (frm.name_suffix_reqd_yn != null)
			if (frm.name_suffix_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.name_suffix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_suffix_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}
	if(frm.no_marital_status.checked == true){
		if (frm.name_suffix_reqd_yn != null)
			if (frm.name_suffix_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull2(frm.name_suffix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_suffix_prompt[fatherDtlsIndex].value,'Y',true);
		if ( canSave == false )
			errorsThere = true;
	}
		}
		else
		{
			if (frm.name_suffix_reqd_yn != null)
			if (frm.name_suffix_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.name_suffix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_suffix_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
		}
	}
	else{
	if (frm.name_suffix != null && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false')){
		if (frm.name_suffix_reqd_yn != null)
			if (frm.name_suffix_reqd_yn[fatherDtlsIndex].value == 'Y' )
				canSave = checkForNull1(frm.name_suffix[fatherDtlsIndex],getLabel('eMP.Father.label','MP')+" "+frm.name_suffix_prompt[fatherDtlsIndex].value,'Y');
		if ( canSave == false )
			errorsThere = true;
	}
	}

	if(frm.name_prefix_oth_lang) {	frm.father_name_prefix_loc_lang.value=frm.name_prefix_oth_lang[0].value;
	}

	if(frm.first_name_oth_lang) {	frm.father_first_name_loc_lang.value=frm.first_name_oth_lang[0].value;
	}

	if(frm.second_name_oth_lang) {	frm.father_second_name_loc_lang.value=frm.second_name_oth_lang[0].value;
	}

	if(frm.third_name_oth_lang) {	frm.father_third_name_loc_lang.value=frm.third_name_oth_lang[0].value;
	}

	if(frm.family_name_oth_lang) {	frm.father_family_name_loc_lang.value=frm.family_name_oth_lang[0].value;
	}

	if(frm.name_suffix_oth_lang) {	frm.father_name_suffix_loc_lang.value=frm.name_suffix_oth_lang[0].value;
	}

			if (frm.first_name != null )
            {
                if (frm.first_oth_name_reqd_yn != null)
                    if (frm.first_oth_name_reqd_yn[0].value == 'Y' )
                        canSave = checkForNull1(frm.first_name_oth_lang[0],getLabel('eMP.Father.label','MP')+" "+frm.first_name_oth_prompt[0].value,'Y');
                    if ( canSave == false )errorsThere = true;
            }

            if (frm.second_name != null )
            {
                if (frm.second_oth_name_reqd_yn != null)
                if (frm.second_oth_name_reqd_yn[0].value == 'Y' )
                    canSave = checkForNull1(frm.second_name_oth_lang[0],getLabel('eMP.Father.label','MP')+" "+frm.second_name_oth_prompt[0].value,'Y');
                if ( canSave == false )
                    errorsThere = true;
            }

            if (frm.third_name != null )
            {
                if (frm.third_oth_name_reqd_yn != null)
                if (frm.third_oth_name_reqd_yn[0].value == 'Y' )
                    canSave =checkForNull1(frm.third_name_oth_lang[0],getLabel('eMP.Father.label','MP')+" "+frm.third_name_oth_prompt[0].value,'Y');
                if ( canSave == false )
                    errorsThere = true;
            }

            if (frm.family_name != null )
            {
                if (frm.family_oth_name_reqd_yn != null)
                if (frm.family_oth_name_reqd_yn[0].value == 'Y' )
                    canSave =checkForNull1(frm.family_name_oth_lang[0],getLabel('eMP.Father.label','MP')+" "+frm.family_name_oth_prompt[0].value,'Y');
                if ( canSave == false )
                    errorsThere = true;
            }

            if (frm.name_suffix != null )
            {
                if (frm.name_suffix_oth_name_reqd_yn != null )
                if (frm.name_suffix_oth_name_reqd_yn[0].value == 'Y' )
                    canSave = checkForNull1(frm.name_suffix_oth_lang[0],getLabel('eMP.Father.label','MP')+" "+frm.name_suffix_oth_prompt[0].value,'Y');
                if ( canSave == false )
                    errorsThere = true;
            }

            if (frm.name_prefix_oth_lang != null )
            {
				 if (frm.name_prefix_oth_name_reqd_yn != null )
                if (frm.name_prefix_oth_name_reqd_yn[0].value == 'Y' )
                    canSave = checkForNull1(frm.name_prefix_oth_lang[0],getLabel('eMP.Father.label','MP')+" "+frm.name_prefix_oth_prompt[0].value,'Y');
                if ( canSave == false )
                    errorsThere = true;
            }

	if(frm.name_prefix) {		
		frm.nb_name_prefix.value=frm.name_prefix[1].value;
	}

	if(frm.first_name) {		
		frm.nb_first_name.value=frm.first_name[1].value;
	}

	if(frm.second_name) {		
		frm.nb_second_name.value=frm.second_name[1].value;
	}

	if(frm.third_name) {		
		frm.nb_third_name.value=frm.third_name[1].value;
	}

	if(frm.family_name) {		
		  frm.nb_family_name.value=frm.family_name[1].value;
	
		}

	if(frm.name_suffix) {		
		frm.nb_name_suffix.value=frm.name_suffix[1].value;
	} 	

			if (frm.name_prefix != null )
			{				
				if (frm.name_prefix_reqd_yn!=null && frm.name_prefix_reqd_yn[1].value=='Y')
				{
					canSave = checkForNull1(frm.name_prefix[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.name_prefix_prompt[1].value,'Y');
				}
				if ( canSave == false )
					errorsThere = true;
			}

			if (frm.first_name != null )
			{
				if (frm.first_name_reqd_yn != null )
                if (frm.first_name_reqd_yn[1].value == 'Y' )
                    canSave = checkForNull1(frm.first_name[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.first_name_prompt[1].value,'Y');
                if ( canSave == false )
                    errorsThere = true;              
            }

			if (frm.second_name != null )
            {
				if (frm.second_name_reqd_yn != null )
                if (frm.second_name_reqd_yn[1].value == 'Y' )
                    canSave = checkForNull1(frm.second_name[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.second_name_prompt[1].value,'Y');
                if ( canSave == false )
                    errorsThere = true;              
            }

			if (frm.third_name != null )
            {
				if (frm.third_name_reqd_yn != null )
                if (frm.third_name_reqd_yn[1].value == 'Y' )
                    canSave = checkForNull1(frm.third_name[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.third_name_prompt[1].value,'Y');
                if ( canSave == false )
                    errorsThere = true;              
            }

			if (frm.family_name != null )
            {
				if (frm.family_name_reqd_yn != null)
                if (frm.family_name_reqd_yn[1].value == 'Y' ){
					if(frm.family_name_reqd_yn[0].value=='Y' && frm.family_name_reqd_yn[1].value=='Y'){				
						canSave = checkForNull1(frm.family_name[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.family_name_prompt[1].value,'Y');
					}else{
						canSave = checkForNull1(frm.family_name[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.family_name_prompt.value,'Y');
					}
				}

                 //   canSave = checkForNull1(frm.family_name[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.family_name_prompt[1].value,'Y'); //33085
                if ( canSave == false )
                    errorsThere = true;              
            }

			if (frm.name_suffix != null )
			{
				if (frm.name_suffix_reqd_yn != null)
				if (frm.name_suffix_reqd_yn[1].value == 'Y' )
					canSave = checkForNull1(frm.name_suffix[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.name_suffix_prompt[1].value,'Y');
				if ( canSave == false )
					errorsThere = true;
			} 	

	if(frm.name_prefix_oth_lang) {	frm.nb_name_prefix_loc_lang.value=frm.name_prefix_oth_lang[1].value;
	}

	if(frm.first_name_oth_lang) {	frm.nb_first_name_loc_lang.value=frm.first_name_oth_lang[1].value;
	}

	if(frm.second_name_oth_lang) { 	frm.nb_second_name_loc_lang.value=frm.second_name_oth_lang[1].value;
	}

	if(frm.third_name_oth_lang) { 	frm.nb_third_name_loc_lang.value=frm.third_name_oth_lang[1].value;
	}

	if(frm.family_name_oth_lang) { 	frm.nb_family_name_loc_lang.value=frm.family_name_oth_lang[1].value;
	}

	if(frm.name_suffix_oth_lang) {	frm.nb_name_suffix_loc_lang.value=frm.name_suffix_oth_lang[1].value;
	}

			if (frm.first_name != null )
            {
                if (frm.first_oth_name_reqd_yn != null)
                    if (frm.first_oth_name_reqd_yn[1].value == 'Y' )
                        canSave = checkForNull1(frm.first_name_oth_lang[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.first_name_oth_prompt[1].value,'Y');
                    if ( canSave == false )errorsThere = true;
            }

            if (frm.second_name != null )
            {
                if (frm.second_oth_name_reqd_yn != null)
                if (frm.second_oth_name_reqd_yn[1].value == 'Y' )
                    canSave = checkForNull1(frm.second_name_oth_lang[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.second_name_oth_prompt[1].value,'Y');
                if ( canSave == false )
                    errorsThere = true;
            }

            if (frm.third_name != null )
            {
                if (frm.third_oth_name_reqd_yn != null)
                if (frm.third_oth_name_reqd_yn[1].value == 'Y' )
                    canSave =checkForNull1(frm.third_name_oth_lang[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.third_name_oth_prompt[1].value,'Y');
                if ( canSave == false )
                    errorsThere = true;
            }

            if (frm.family_name != null )
            {
                if (frm.family_oth_name_reqd_yn != null)
                if (frm.family_oth_name_reqd_yn[1].value == 'Y' )
                    canSave =checkForNull1(frm.family_name_oth_lang[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.family_name_oth_prompt[1].value,'Y');
                if ( canSave == false )
                    errorsThere = true;
            }

            if (frm.name_suffix != null )
            {
                if (frm.name_suffix_oth_name_reqd_yn != null )
                if (frm.name_suffix_oth_name_reqd_yn[1].value == 'Y' )
                    canSave = checkForNull1(frm.name_suffix_oth_lang[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.name_suffix_oth_prompt[1].value,'Y');
                if ( canSave == false )
                    errorsThere = true;
            }

            if (frm.name_prefix_oth_lang != null )
            {
				 if (frm.name_prefix_oth_name_reqd_yn != null )
                if (frm.name_prefix_oth_name_reqd_yn[1].value == 'Y' )
                    canSave = checkForNull1(frm.name_prefix_oth_lang[1],getLabel('eMP.NewBorn.label','MP')+" "+frm.name_prefix_oth_prompt[1].value,'Y');
                if ( canSave == false )
                    errorsThere = true;
            }     

    var patnogenyn = frm.pat_no_gen_yn.value;
    var function_id=frm.function_id.value;

    var fields = new Array ();
    var names = new Array ();

    //var frm = f_query_add_mod.frames[temp].document.NewbornRegistration_form;
if(callfromfunction=='REGISTER_NEWBORN'){
    if(f_query_add_mod.frames[1].document.NewbornRegistration_form.patient_id.readOnly == false)
    {
        patnogenyn = "N";		
        f_query_add_mod.frames[1].document.NewbornRegistration_form.pat_no_gen_yn.value = "N";
		frm.pat_no_gen_yn.value = "N";
		frm.patient_id.value=f_query_add_mod.frames[1].document.NewbornRegistration_form.patient_id.value;
    }
}

    //Newly added for Child and Category mandatory checking
	if (frm.child_mandatoryfield.value == 'mandatory')
	 {
		if(frm.relation_child!=null){
				canSave = checkForNull1(frm.relation_child,getLabel("eMP.child.label","MP"),'Y');
		}
	}
	if ( canSave == false )
	errorsThere = true;
	if (frm.cat_mandatoryfield.value == 'mandatory')
        {
            if(frm.relation_child11!=null){
				canSave = checkForNull1(frm.relation_child11,getLabel("Common.category.label","Common"),'Y');
			}
        }
        if ( canSave == false )
            errorsThere = true;

	var splField = new Array (frm.patient_id);
	var splFieldName = new Array (getLabel("Common.patientId.label","common"));

//** checking for mandatory fileds (Gestation, Gravida, and Parity), when called from IP Module. **//
		if(frm.called_function.value == 'IP')
		{
			if(frm.invoke_menstrual_history.value == "Y"){
				if(frm.gestn_day_from_lmp.value!=null){
					canSave = checkForNull1(frm.gestn_day_from_lmp,getLabel("eMP.Gestation.label","MP"),'Y');
					if(canSave == false) 
						errorsThere = true;
				}	
			}else{
			if(frm.gestational_period!=null)
			{
				canSave = checkForNull1(frm.gestational_period,getLabel("eMP.Gestation.label","MP"),'Y');
				if(canSave == false) errorsThere = true;
					}
			}
			if(frm.gravida!=null)
			{
				canSave = checkForNull1(frm.gravida,getLabel("eMP.Gravida.label","MP"),'Y');
				if(canSave == false) errorsThere = true;
			}
			if(frm.parity!=null)
			{
				canSave = checkForNull1(frm.parity,getLabel("eMP.Parity.label","MP"),'Y');
				if(canSave == false) errorsThere = true;
			}
			
		}

/* end of checking for mandatory fileds (Gestation, Gravida, and Parity), when called from IP Module */

		if(callfromfunction=='REGISTER_NEWBORN'){
			if(frm.multiple_birth_yn.checked) 
			{
				frm.multiple_birth_yn.value = "Y";
				if (frm.noOfBirths.value <= 1)
				{
					canSave =  checkForOne(frm.noOfBirths,getLabel("eMP.noofmultiplebirths.label","MP"),'Y');
					if ( canSave == false ) errorsThere = true;//Added by Thamizh selvi on 7th Dec 2017 against ML-MMOH-SCF-0891
				}
				/*Added by Thamizh selvi on 7th Dec 2017 against ML-MMOH-SCF-0891 Start*/
				else{
					frm.noOfBirths.style.backgroundColor = '';
				}/*End*/

			}
			else{
				frm.noOfBirths.style.backgroundColor = '';//Added by Thamizh selvi on 7th Dec 2017 against ML-MMOH-SCF-0891
				frm.multiple_birth_yn.value = "N";
			}
		}

	if(patnogenyn == 'Y')
    {
        // The below line is commented for the Incident IN017813 on 05/01/2010 by Suresh.
	//	if (frm.nb_use_mother_ser.value=='Y')	{
			if(callfromfunction=='REGISTER_NEWBORN'){
			if(f_query_add_mod.frames[1].document.NewbornRegistration_form.pat_ser_grp_code!=null)
			{
				canSave = checkForNull1(f_query_add_mod.frames[1].document.NewbornRegistration_form.pat_ser_grp_code,getLabel("eMP.PatientSeries.label","MP"),'Y');
			} 
			if ( canSave == false )
				errorsThere = true;
			}
	//	}

		/*
		if (frm.date_of_birth.value == '')
        {
            canSave = checkForNull(getLabel("Common.birthDate.label","Common"));
        }
        if ( canSave == false )
            errorsThere = true;
		*/
// 68508
        if (frm.parity!=null)
        {
            canSave = checkForNull1(frm.parity,getLabel("eMP.Parity.label","MP"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;
		if (frm.parity1!=null)
        {
            canSave = checkForNull1(frm.parity1,getLabel("eMP.Parity.label","MP"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;
		
		//68508
		if (frm.birth_date!=null)
        {
            canSave = checkForNull1(frm.birth_date,getLabel("Common.birthDate.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

		if (frm.birth_time!=null)
        {
            canSave = checkForNull1(frm.birth_time,getLabel("eMP.Birth.label","MP")+" "+getLabel("Common.time.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;


        if (frm.new_born_sex!=null)
        {
             canSave = checkForNull1(frm.new_born_sex,getLabel("Common.gender.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

		if (frm.born_where!=null)
        {
            canSave = checkForNull1(frm.born_where,getLabel("eMP.BornWhere.label","MP"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

		if(frm.captureAntenatalDtlsYN.value == 'Y' && (frm.isMPMandatoryFieldsNewborn.value== 'false' || frm.isMPMandatoryFieldsNewborn.value == false))
		{
			//if(callfromfunction=='REGISTER_NEWBORN'){

			if(frm.antenatal_care.checked==true)
               canSave = checkForNull1(frm.ate_born_where,getLabel("eMP.AnteNatalCare.label","MP")+ " " +getLabel("eMP.given.label","MP")+ " " +getLabel("Common.Location.label","common"),'Y');
			//}
		}
		if ( canSave == false )
            errorsThere = true;


		if (frm.mother_patient_id!=null)
        {
            canSave = checkForNull1(frm.mother_patient_id,getLabel("Common.patientId.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;
		if(frm.isMPMandatoryFieldsNewborn.value=="true" || frm.isMPMandatoryFieldsNewborn.value == true){
		if(callfromfunction == "MAINTAIN_BIRTH" && frm.mp_regn_nb_yn.value == "Y" && frm.mandate_first_newborn_yn.value == "Y"){
		if (frm.complns_1st_stage_labour_code!=null && frm.complns_1st_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_1st_stage_labour_code,getLabel("eMP.Complicationsin1stStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(callfromfunction == "MAINTAIN_BIRTH" && frm.mp_regn_nb_yn.value == "Y" && frm.mandate_second_newborn_yn.value == "Y"){
		if (frm.complns_2nd_stage_labour_code!=null && frm.complns_2nd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_2nd_stage_labour_code,getLabel("eMP.Complicationsin2ndStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(callfromfunction == "MAINTAIN_BIRTH" && frm.mp_regn_nb_yn.value == "Y" && frm.mandate_third_newborn_yn.value == "Y"){
		if (frm.complns_3rd_stage_labour_code!=null && frm.complns_3rd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_3rd_stage_labour_code,getLabel("eMP.Complicationsin3rdStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(callfromfunction == "MAINTAIN_BIRTH" && frm.mp_regn_nb_yn.value == "Y" && frm.mand_antenatal_newborn_yn.value == "Y"){
		if (frm.ate_born_where!=null){
				canSave = checkForNull1(frm.ate_born_where,getLabel("eMP.AnteNatalCare.label","MP")+ " " +getLabel("eMP.given.label","MP")+ " " +getLabel("Common.Location.label","common"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(callfromfunction == "MAINTAIN_BIRTH" && frm.emer_regn_nb.value == "Y" && frm.mandate_first_newborn_ae_yn.value == "Y"){
		if (frm.complns_1st_stage_labour_code!=null && frm.complns_1st_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_1st_stage_labour_code,getLabel("eMP.Complicationsin1stStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(callfromfunction == "MAINTAIN_BIRTH" && frm.emer_regn_nb.value == "Y" && frm.mandate_second_newborn_ae_yn.value == "Y"){
		if (frm.complns_2nd_stage_labour_code!=null && frm.complns_2nd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_2nd_stage_labour_code,getLabel("eMP.Complicationsin2ndStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(callfromfunction == "MAINTAIN_BIRTH" && frm.emer_regn_nb.value== "Y" && frm.mandate_third_newborn_ae_yn.value == "Y"){
		if (frm.complns_3rd_stage_labour_code!=null && frm.complns_3rd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_3rd_stage_labour_code,getLabel("eMP.Complicationsin3rdStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(callfromfunction == "MAINTAIN_BIRTH" && frm.emer_regn_nb.value == "Y" && frm.mand_antenatal_newborn_ae_yn.value == "Y"){
		if (frm.ate_born_where!=null){
				canSave = checkForNull1(frm.ate_born_where,getLabel("eMP.AnteNatalCare.label","MP")+ " " +getLabel("eMP.given.label","MP")+ " " +getLabel("Common.Location.label","common"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(callfromfunction == "MAINTAIN_BIRTH" && frm.ip_regn_nb_yn.value == "Y" && frm.mandate_first_newborn_ip_yn.value == "Y"){
		if (frm.complns_1st_stage_labour_code!=null && frm.complns_1st_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_1st_stage_labour_code,getLabel("eMP.Complicationsin1stStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(callfromfunction == "MAINTAIN_BIRTH" && frm.ip_regn_nb_yn.value == "Y" && frm.mandate_second_newborn_ip_yn.value == "Y"){
		if (frm.complns_2nd_stage_labour_code!=null && frm.complns_2nd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_2nd_stage_labour_code,getLabel("eMP.Complicationsin2ndStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(callfromfunction == "MAINTAIN_BIRTH" && frm.ip_regn_nb_yn.value == "Y" && frm.mandate_third_newborn_ip_yn.value == "Y"){
		if (frm.complns_3rd_stage_labour_code!=null && frm.complns_3rd_stage_labour_code_img.style.visibility=='visible'){
				canSave = checkForNull1(frm.complns_3rd_stage_labour_code,getLabel("eMP.Complicationsin3rdStage.label","MP"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		if(callfromfunction == "MAINTAIN_BIRTH" && frm.ip_regn_nb_yn.value == "Y" && frm.mand_antenatal_newborn_ip_yn.value == "Y"){
		if (frm.ate_born_where!=null){
				canSave = checkForNull1(frm.ate_born_where,getLabel("eMP.AnteNatalCare.label","MP")+ " " +getLabel("eMP.given.label","MP")+ " " +getLabel("Common.Location.label","common"),'Y');
			}	
			if ( canSave == false )
				errorsThere = true;
		}
		}
		
		if (frm.length1.value!=null && frm.LENGTH_IMG.style.visibility=='visible')
        {
            canSave = checkForNull1(frm.length1,getLabel("eMP.LengthofBaby.label","MP"),'Y');
        }	
		 if ( canSave == false )
            errorsThere = true;

		if (frm.circumference!=null && frm.CIRCUMFERENCE_IMG.style.visibility=='visible')
        {
            canSave = checkForNull1(frm.circumference,getLabel("Common.HeadCircumference.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

		if(frm.outcome.value=='L'&& frm.born_where.value=='I'){
			if (frm.apgar_score!=null)
			{
			   var errmsg =getLabel("Common.ApgarScore.label","Common") 
			   errmsg=errmsg+" "+getLabel("eMP.in1Min.label","MP") 		
				canSave =checkForNull1(frm.apgar_score,errmsg,'Y');
			}
			if ( canSave == false )
				errorsThere = true;
			/*Added for CRF 689 & 695 Starts*/
			if(frm.apgar_score_changedYN.value=="Y"){
				canSave =checkForNull1(frm.heart_rate_in_1_min,(getLabel("eMP.HeartRateAtMin.label","MP").replace('#','1')),'Y'); 
				if ( canSave == false )
					errorsThere = true;
				canSave =checkForNull1(frm.breathing_in_1_min,(getLabel("eMP.BreathingAtMin.label","MP").replace('#','1')),'Y'); 
				if ( canSave == false )
					errorsThere = true;
				canSave =checkForNull1(frm.grimace_in_1_min,(getLabel("eMP.GrimaceAtMin.label","MP").replace('#','1')),'Y'); 
				if ( canSave == false )
					errorsThere = true;
				canSave =checkForNull1(frm.activity_in_1_min,(getLabel("eMP.ActivityAtMin.label","MP").replace('#','1')),'Y'); 
				if ( canSave == false )
					errorsThere = true;
				canSave =checkForNull1(frm.appearance_in_1_min,(getLabel("eMP.AppearanceAtMin.label","MP").replace('#','1')),'Y');
				if ( canSave == false )
					errorsThere = true;
			}
			/*Added for CRF 689 & 695 Starts Ends*/

			if (frm.apgar_score_five_min!=null && frm.APGAR_SCORE_IN_5_MINS_YN_IMG.style.visibility=='visible'){
				canSave =checkForNull1(frm.apgar_score_five_min,getLabel("Common.ApgarScore.label","Common")+" "+getLabel("eMP.in5Min.label","MP"),'Y'); 				
				if ( canSave == false )
					errorsThere = true;
				/*Added for CRF 689 & 695 Starts*/
				//if(frm.apgar_score_changedYN.value=="Y"){ commented by santhosh for ML-MMOH-CRF-1895
					canSave =checkForNull1(frm.heart_rate_in_5_min,(getLabel("eMP.HeartRateAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.breathing_in_5_min,(getLabel("eMP.BreathingAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.grimace_in_5_min,(getLabel("eMP.GrimaceAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.activity_in_5_min,(getLabel("eMP.ActivityAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.appearance_in_5_min,(getLabel("eMP.AppearanceAtMin.label","MP").replace('#','5')),'Y');
					if ( canSave == false )
						errorsThere = true;
				//} commented by santhosh for ML-MMOH-CRF-1895
				/*Added for CRF 689 & 695 Starts Ends*/
			}
			
			if (frm.apgar_score_ten_min.value!=null && frm.APGAR_SCORE_IN_10_MINS_YN_IMG.style.visibility=='visible'){
				canSave =checkForNull1(frm.apgar_score_ten_min,getLabel("Common.ApgarScore.label","Common")+" "+ getLabel("eMP.in10Min.label","MP"),'Y')				
				if ( canSave == false )
					errorsThere = true;
				/*Added for CRF 689 & 695 Starts*/
				if(frm.apgar_score_changedYN.value=="Y"){
					canSave =checkForNull1(frm.heart_rate_in_10_min,(getLabel("eMP.HeartRateAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.breathing_in_10_min,(getLabel("eMP.BreathingAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.grimace_in_10_min,(getLabel("eMP.GrimaceAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.activity_in_10_min,(getLabel("eMP.ActivityAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.appearance_in_10_min,(getLabel("eMP.AppearanceAtMin.label","MP").replace('#','10')),'Y');
					if ( canSave == false )
						errorsThere = true;
				}
				/*Added for CRF 689 & 695 Starts Ends*/
			}
			if (frm.patency_of_anus_yn!=null && frm.PATENCY_OF_ANUS_YN_IMG.style.visibility=='visible')
			{
				 canSave = checkForNull1(frm.patency_of_anus_yn,getLabel("eMP.PatencyofAnus.label","MP"),'Y');
			}
	        if ( canSave == false )
            errorsThere = true;
			
			if (frm.Umb_cord_cut_by1!=null)
			{
				canSave = checkForNull1(frm.Umb_cord_cut_by1,getLabel("eMP.UmbCordCutBy.label","MP"),'Y');
			}
			if ( canSave == false )
				errorsThere = true;
			}
        //Below line commeneted for Maintain Birth Register function two times message display when outcome "S" and bornwhere "I" then click apply
		/*if(frm.outcome.value=='S'&& frm.born_where.value=='I'){
			if (frm.Umb_cord_cut_by1!=null)
			{
				canSave = checkForNull1(frm.Umb_cord_cut_by1,getLabel("eMP.UmbCordCutBy.label","MP"),'Y');
			}
			if ( canSave == false )
				errorsThere = true;
		}*/
		//End 
		var allow_ext_nb_regn_within_days = frm.allow_ext_nb_regn_within_days.value;
		var isAllow_External_Newborn = frm.isAllow_External_Newborn.value;
		var born_where = frm.born_where.value;	
		if (frm.practid_desc!=null){
		if(isAllow_External_Newborn =="true" && born_where =='I' && allow_ext_nb_regn_within_days!='' && allow_ext_nb_regn_within_days !=null )
		{
		canSave = checkForNull1(frm.practid_desc,getLabel("Common.AttendingPractitioner.label","Common"),'Y');
		}
		else if(isAllow_External_Newborn =="true" && born_where !='I' && allow_ext_nb_regn_within_days!='' && allow_ext_nb_regn_within_days !=null ){
		//canSave = false;
		}
		else
		{
		canSave = checkForNull1(frm.practid_desc,attPracLegend,'Y');
		}
		}
		/* if (frm.practid_desc!=null)
        { alert(90)
			//canSave = checkForNull1(frm.practid_desc,getLabel("Common.AttendingPractitioner.label","Common"),'Y');
			canSave = checkForNull1(frm.practid_desc,attPracLegend,'Y');
        } */
        if ( canSave == false )
            errorsThere = true;
		

        if (frm.weight!=null)
        {
			canSave = checkForNull1(frm.weight,getLabel("eMP.BirthWeight.label","MP"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

        if (frm.nod_type!=null)
        {
			canSave = checkForNull1(frm.nod_type,getLabel("eMP.natureofdelivery.label","MP"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

    }
    else
    {
		// The below line is commented for the Incident IN017813 on 05/01/2010 by Suresh.

	//	if (frm.nb_use_mother_ser.value=='Y'){
			if(callfromfunction=='REGISTER_NEWBORN'){
			if (f_query_add_mod.frames[1].document.NewbornRegistration_form.pat_ser_grp_code!=null)
			{
				canSave = checkForNull1(f_query_add_mod.frames[1].document.NewbornRegistration_form.pat_ser_grp_code,getLabel("eMP.PatientSeries.label","MP"),'Y');
			}
			
			if ( canSave == false )
				errorsThere = true;
			}
		//}
        if (frm.patient_id!=null)
        {
            canSave = checkForNull1(frm.patient_id,getLabel("Common.patientId.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;
        else
        {
            if(frm.patient_id.value.length != frm.maxLength.value)
            {
                var msg = getMessage("HEAD_PATID_CHAR","MP");
				msg = msg.replace('@', document.getElementById('patient_id').maxLength);
				LocalErrors = LocalErrors+msg+' <br>';
				frm.patient_id.style.backgroundColor='#FFFF66';
                canSave = false;
                errorsThere = true;
            }
            else if(frm.duplicate.value=="Y")
            {
                    LocalErrors = LocalErrors +getMessage("DUPL_PAT_ID","MP")+' <br>';
					frm.patient_id.style.backgroundColor='#FFFF66';
                    canSave = false;
                    errorsThere = true;
            }
        }

		/*
        if (frm.date_of_birth.value == 0)
        {
            canSave = checkForNull(getLabel("Common.birthDate.label","Common"));
        }
        if ( canSave == false )
            errorsThere = true;
		*/

		if (frm.birth_date!=null)
        {
            canSave = checkForNull1(frm.birth_date,getLabel("Common.birthDate.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

		if (frm.birth_time!=null)
        {
            canSave = checkForNull1(frm.birth_time,getLabel("eMP.Birth.label","MP")+" "+getLabel("Common.time.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

        if (frm.new_born_sex!=null)
        {
            canSave = checkForNull1(frm.new_born_sex,getLabel("Common.gender.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

		if (frm.born_where!=null)
        {
               canSave = checkForNull1(frm.born_where,getLabel("eMP.BornWhere.label","MP"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

		if (frm.mother_patient_id!=null)
        {
            canSave = checkForNull1(frm.mother_patient_id,getLabel("Common.patientId.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

		if (frm.length1!=null && frm.LENGTH_IMG.style.visibility=='visible')
        {
             canSave = checkForNull1(frm.length1,getLabel("eMP.LengthofBaby.label","MP"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

		if (frm.circumference!=null && frm.CIRCUMFERENCE_IMG.style.visibility=='visible')
        {
            canSave = checkForNull1(frm.circumference,getLabel("Common.HeadCircumference.label","Common"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

		if(frm.outcome.value=='L'&& frm.born_where.value=='I'){
			if (frm.apgar_score!=null){
				canSave =checkForNull1(frm.apgar_score,getLabel("Common.ApgarScore.label","Common")+" "+ getLabel("eMP.in1Min.label","MP"),'Y')
				if ( canSave == false )
					errorsThere = true;
				/*Added for CRF 689 & 695 Starts*/
				if(frm.apgar_score_changedYN.value=="Y"){
					canSave =checkForNull1(frm.heart_rate_in_1_min,(getLabel("eMP.HeartRateAtMin.label","MP").replace('#','1')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.breathing_in_1_min,(getLabel("eMP.BreathingAtMin.label","MP").replace('#','1')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.grimace_in_1_min,(getLabel("eMP.GrimaceAtMin.label","MP").replace('#','1')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.activity_in_1_min,(getLabel("eMP.ActivityAtMin.label","MP").replace('#','1')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.appearance_in_1_min,(getLabel("eMP.AppearanceAtMin.label","MP").replace('#','1')),'Y');
					if ( canSave == false )
						errorsThere = true;
				}
				/*Added for CRF 689 & 695 Starts Ends*/
				
			}

			if (frm.apgar_score_five_min!=null && frm.APGAR_SCORE_IN_5_MINS_YN_IMG.style.visibility=='visible'){
				canSave =checkForNull1(frm.apgar_score_five_min,getLabel("Common.ApgarScore.label","Common")+" "+ getLabel("eMP.in5Min.label","MP"),'Y')
				if ( canSave == false )
					errorsThere = true;
				/*Added for CRF 689 & 695 Starts*/
				if(frm.apgar_score_changedYN.value=="Y"){
					canSave =checkForNull1(frm.heart_rate_in_5_min,(getLabel("eMP.HeartRateAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.breathing_in_5_min,(getLabel("eMP.BreathingAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.grimace_in_5_min,(getLabel("eMP.GrimaceAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.activity_in_5_min,(getLabel("eMP.ActivityAtMin.label","MP").replace('#','5')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.appearance_in_5_min,(getLabel("eMP.AppearanceAtMin.label","MP").replace('#','5')),'Y');
					if ( canSave == false )
						errorsThere = true;
				}
				/*Added for CRF 689 & 695 Starts Ends*/
			}

			if (frm.apgar_score_ten_min.value!=null && frm.APGAR_SCORE_IN_10_MINS_YN_IMG.style.visibility=='visible'){
				canSave =checkForNull1(frm.apgar_score_ten_min,getLabel("Common.ApgarScore.label","Common")+" "+ getLabel("eMP.in10Min.label","MP"),'Y')
				if ( canSave == false )
					errorsThere = true;
				/*Added for CRF 689 & 695 Starts*/
				if(frm.apgar_score_changedYN.value=="Y"){
					canSave =checkForNull1(frm.heart_rate_in_10_min,(getLabel("eMP.HeartRateAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.breathing_in_10_min,(getLabel("eMP.BreathingAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.grimace_in_10_min,(getLabel("eMP.GrimaceAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.activity_in_10_min,(getLabel("eMP.ActivityAtMin.label","MP").replace('#','10')),'Y'); 
					if ( canSave == false )
						errorsThere = true;
					canSave =checkForNull1(frm.appearance_in_10_min,(getLabel("eMP.AppearanceAtMin.label","MP").replace('#','10')),'Y');
					if ( canSave == false )
						errorsThere = true;
				}
				/*Added for CRF 689 & 695 Starts Ends*/
			}
			if ( canSave == false )
				errorsThere = true;

			if (frm.patency_of_anus_yn!=null && frm.PATENCY_OF_ANUS_YN_IMG.style.visibility=='visible')
			{
			  canSave = checkForNull1(frm.patency_of_anus_yn,getLabel("eMP.PatencyofAnus.label","MP"),'Y');
			}
	        if ( canSave == false )
            errorsThere = true;

		}
		
		if (frm.practid_desc!=null){
		if(isAllow_External_Newborn =="true" && born_where =='I' && allow_ext_nb_regn_within_days!='' && allow_ext_nb_regn_within_days !=null )
		{
		canSave = checkForNull1(frm.practid_desc,getLabel("Common.AttendingPractitioner.label","Common"),'Y');
		}
		else if(isAllow_External_Newborn =="true" && born_where !='I' && allow_ext_nb_regn_within_days!='' && allow_ext_nb_regn_within_days !=null ){
		//canSave = false;
		}
		else
		{ 
		canSave = checkForNull1(frm.practid_desc,attPracLegend,'Y');
		}
		}

		/* if (frm.practid_desc!=null)
        { alert(91)
			 //canSave = checkForNull1(frm.practid_desc,getLabel("Common.AttendingPractitioner.label","Common"),'Y');
			 canSave = checkForNull1(frm.practid_desc,attPracLegend,'Y');
        } */
        if ( canSave == false )
            errorsThere = true;
		
        if (frm.weight!=null)
        {
            canSave = checkForNull1(frm.weight,getLabel("eMP.BirthWeight.label","MP"),'Y');
        }
        if ( canSave == false )
            errorsThere = true;

        if (frm.nod_type!=null)
        {
			canSave = checkForNull1(frm.nod_type,getLabel("eMP.natureofdelivery.label","MP"),'Y');
        }
        if ( canSave == false )
        errorsThere = true;
if(frm.outcome.value=='L'&& frm.born_where.value=='I'){
			if (frm.Umb_cord_cut_by1!=null)
			{
				canSave = checkForNull1(frm.Umb_cord_cut_by1,getLabel("eMP.UmbCordCutBy.label","MP"),'Y');
			}
			if ( canSave == false )
				errorsThere = true;
			}
	}
		if(frm.outcome.value=='S'&& frm.born_where.value=='I'){
			if (frm.Umb_cord_cut_by1!=null)
			{
				canSave = checkForNull1(frm.Umb_cord_cut_by1,getLabel("eMP.UmbCordCutBy.label","MP"),'Y');
			}
			if ( canSave == false )
				errorsThere = true;
}

	/*if(frm.father_patient_id.value != '' || frm.father_patient_name.value != ''){
			if(frm.cboNationality_desc!=null)
				canSave = checkForNull1(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y');
			if(canSave == false) errorsThere = true;
			/*
		if(frm.cboEthnicGroup!=null)
			canSave = checkForNull1(frm.cboEthnicGroup,getLabel("Common.race.label","Common"),'Y');
		if(canSave == false) errorsThere = true;
		
			}*/
		//Above condition commented and below condition added for ML-MMOH-CRF-2097 by kamatchi S
	if((frm.father_patient_id.value != '' || frm.father_patient_name.value != '') && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y')){
			if(frm.enable_marital_status.value == 'Y'){
			if( frm.no_marital_status.checked == false ){
			if(frm.cboNationality_desc!=null)
				canSave = checkForNull1(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y');
			if(canSave == false) errorsThere = true;
			}
			if( frm.no_marital_status.checked == true ){
			if(frm.cboNationality_desc!=null )
				canSave = checkForNull2(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y',true);
			if(canSave == false) errorsThere = true;	
			}
			}
			else
			{
				if(frm.cboNationality_desc!=null )
				canSave = checkForNull1(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y');
			if(canSave == false) errorsThere = true;
			}
		}
		else if((frm.father_patient_id.value != '' || frm.father_patient_name.value != '') && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'N')){
			if(frm.cboNationality_desc!=null )
				canSave = checkForNull1(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y');
			if(canSave == false) errorsThere = true;	
		}
		else
		{
			if((frm.father_patient_id.value != '' || frm.father_patient_name.value != '') && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false') ){
			if(frm.cboNationality_desc!=null )
				canSave = checkForNull1(frm.cboNationality_desc,getLabel("Common.nationality.label","Common"),'Y');
			if(canSave == false) errorsThere = true;	
		}
		}
		if(((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'Y')) {
			if(frm.enable_marital_status.value == 'Y'){
			if( frm.no_marital_status.checked == false ){
				if(frm.racImg.style.visibility == 'visible'){
			if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull1(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y');
				if(canSave == false) errorsThere = true;
				}
			}
			if( frm.no_marital_status.checked == true ){
			if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull2(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y',true);
				if(canSave == false) errorsThere = true;
			}
			}
			else
			{
				if(frm.racImg.style.visibility == 'visible'){
				if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull1(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y');
				if(canSave == false) errorsThere = true;
				}
			}

		}
		else if(frm.racImg.style.visibility == 'visible' && ((frm.mpDisableFieldsNBFather.value == true || frm.mpDisableFieldsNBFather.value == 'true') && frm.nb_father_name_mandatory_yn.value == 'N')) {
			if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull1(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y');
				if(canSave == false) errorsThere = true;
		}
		else{
		if(frm.racImg.style.visibility == 'visible' && (frm.mpDisableFieldsNBFather.value == false || frm.mpDisableFieldsNBFather.value == 'false') ) {
			if(frm.cboEthnicGroupDesc!=null)
					canSave = checkForNull1(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y');
				if(canSave == false) errorsThere = true;
		}
		}

	/*if(frm.racImg.style.visibility == 'visible') {
		if(frm.cboEthnicGroupDesc!=null)
				canSave = checkForNull1(frm.cboEthnicGroupDesc,getLabel("Common.race.label","Common"),'Y');
			if(canSave == false) errorsThere = true;
	}*/
	
    if(canSave == true && errorsThere == false)
    {
        if(!birthTimeCheck())
        {
           canSave = false;
            errosThere = true;
       }
		if (!checkMinMax())
		{
			canSave = false;
          errosThere = true;
		}
    }
    else
    {
        if(function_id!="") {}
  
    }

	/*Below Added by Rameswar on 30-Sep-15 for Leap Year Issue*/ 
if(localeName=="en"){
	var dtVal=frm.date_of_birth.value;	 
	
}else{
		
	var dtVal = convertDate(frm.date_of_birth.value,"DMYHM",localeName,"en");	
}
	var hddDTTM=frm.hddDTTM.value;	  
    
	var dt=dtVal.substring(0,dtVal.indexOf(" " ));
	var tm=dtVal.substring(dtVal.indexOf(" " )+1);
	var hr=tm.substring(0,tm.indexOf(":" ));
	var mt=tm.substring(tm.indexOf(":" )+1);

	var dt1=hddDTTM.substring(0,hddDTTM.indexOf(" " ));
	var tm1=hddDTTM.substring(hddDTTM.indexOf(" " )+1);
	var hr1=tm1.substring(0,tm1.indexOf(":" ));
	var mt1=tm1.substring(tm1.indexOf(":" )+1);
	frm.hddDate.value=dt1;
	frm.hddBDate.value=dt;

	
	if(parseInt(dt.substring(dt.indexOf("/")+1,dt.lastIndexOf("/")))==2){
		if(parseInt(dt.substring(0,dt.indexOf("/")))>29){
			

			alert(getMessage("INVALID_DATE_FMT","SM"));			
			frm.birth_date.value='';	
			frm.birth_date.focus();	
		
			canSave = false;
            errosThere = true;
		}
		if(parseInt(dt.substring(0,dt.indexOf("/")))==29){
			if(!leapyear(dt.substring(dt.lastIndexOf("/")+1))){
			
				

				alert(getMessage("INVALID_DATE_FMT","SM"));			
				frm.birth_date.value='';	
				frm.birth_date.focus();	
			
				canSave = false;
	            errosThere = true;
			}
		}
	}
	if(Date.parse(dt1) == Date.parse(dt)){		
		if(eval(hr) > eval(hr1)){		
			var msg = self.getMessage("BIRTH_TIME_GREATER_SYSTIME","MP");			
			alert(msg);
			/*
			f_query_add_mod.frames[temp].document.forms[0].date_of_birth.value='';	
			f_query_add_mod.frames[temp].document.forms[0].date_of_birth.focus();
			*/
			frm.birth_time.value='';	
			frm.birth_time.focus();
			canSave = false;
            errosThere = true;
		}else if(eval(hr) == eval(hr1)){
			if(eval(mt)>eval(mt1)){	  	
				var msg = self.getMessage("BIRTH_TIME_GREATER_SYSTIME","MP");
				alert(msg);
				/*
				f_query_add_mod.frames[temp].document.forms[0].date_of_birth.value='';	
				f_query_add_mod.frames[temp].document.forms[0].date_of_birth.focus();
				*/
				frm.birth_time.value='';	
				frm.birth_time.focus();
				canSave = false;
	            errosThere = true;
			}
		}
	}


		var birth_date = frm.date_of_birth;
		var to = 	frm.bcg_datetime;
		if( (to.value!='') && (birth_date.value!='') )
		{	
			if(!ValidateBDateTime(birth_date,to))
			{
				var str = self.getMessage("CANNOT_LESSER","MP");
				str = str.replace('#', getLabel("eMP.BCG.label","MP") +' '+getLabel("Common.AdmissionDateTime.label","common"));
				str = str.replace('$', getLabel("Common.birthDate.label","common") + "/" + getLabel("Common.time.label","common"));
				alert(str);	
				obj.select();
				obj.focus();	
				canSave = false;
	            errosThere = true;
			}
		}
		
		var to =frm.vitk_datetime;
		if((to.value!='') && (birth_date.value!='') )
		{
			if(!ValidateBDateTime(birth_date,to))
			{
				var str = self.getMessage("CANNOT_LESSER","MP");
				str = str.replace('#', getLabel("eMP.VitaminK.label","MP") +' '+ getLabel("Common.AdmissionDateTime.label","common"));
				str = str.replace('$', getLabel("Common.birthDate.label","common") + "/" + getLabel("Common.time.label","common"));
				alert(str);	
				obj.select();
				obj.focus();	
				canSave = false;
	            errosThere = true;
			}
		}

		var to = frm.hepb_datetime;
		if((to.value!='') && (birth_date.value!='') )
		{
			if(!ValidateBDateTime(birth_date,to))
			{
				var str = self.getMessage("CANNOT_LESSER","MP");
				str = str.replace('#', getLabel("eMP.HepatitisB.label","MP") +' '+ getLabel("Common.AdmissionDateTime.label","common"));
				str = str.replace('$', getLabel("Common.birthDate.label","common") + "/" + getLabel("Common.time.label","common"));
				alert(str);	
				obj.select();
				obj.focus();			
				canSave = false;
	            errosThere = true;
			}
		}
	
	if(canSave == true && errorsThere == false)
	{
		
		frm.multiple_birth_yn.disabled=false;
		frm.remarks.disabled = false;
		if(frm.invoked_from.value != 'details_page')
		{    
		         
		
			/* alert(frm.father_alt_id2_no.value)
			 alert(frm.father_alt_id3_no.value)
			 alert(frm.father_alt_id4_no.value)*/
			/*Modified By dharma on May 6th 2015 against AAKH-SCF-0202 [IN:055235] Start*/
			/*frm.father_alt_id1_no.disabled = false;
			frm.father_alt_id2_no.disabled = false;
			frm.father_alt_id3_no.disabled = false;
			frm.father_alt_id4_no.disabled = false;*/
			if(frm.father_alt_id1_no)
				frm.father_alt_id1_no.disabled = false;
			if(frm.father_alt_id2_no)
				frm.father_alt_id2_no.disabled = false;
			if(frm.father_alt_id3_no)
				frm.father_alt_id3_no.disabled = false;
			if(frm.father_alt_id4_no)
				frm.father_alt_id4_no.disabled = false;
			/*Modified By dharma on May 6th 2015 against AAKH-SCF-0202 [IN:055235] End*/



		}
		
		frm.pat_ser_grp_code.value=f_query_add_mod.frames[1].document.NewbornRegistration_form.pat_ser_grp_code.value;
		frm.patient_id.value=f_query_add_mod.frames[1].document.NewbornRegistration_form.patient_id.value;
		frm.new_born_sex.disabled	= false;
		frm.date_of_birth.disabled	= false;
		frm.outcome.disabled	= false;

		var sStyle =  frm.sStyle.value;
		if(frm.called_function.value == 'IP' && (frm.isMPMandatoryFieldsNewborn.value== 'false' || frm.isMPMandatoryFieldsNewborn.value == false)) {
			if(frm.captureAntenatalDtlsYN.value == 'Y') {				
				frm.antenatal_care.disabled = false;
			}
		}
		//Added by Ashwini for MO-CRF-20108
		var isSubmit	= "Y";
		if((frm.isNeonatalApplicable.value=="true") && frm.sel_accession_num.value =="" ){
			if(confirm(getMessage('ACCESSION_NUMBER','MP'))){
				isSubmit	= "Y";
			}else{
				isSubmit	= "N";
			}

		}

		if(isSubmit=="Y"){
			if(function_id == "")
			{
		
				en_Able();
				frm.circumference_unit.disabled=false;
				frm.chest_circumference_unit.disabled=false;
				frm.length_unit.disabled=false;
				frm.weight_unit.disabled=false;
				frm.gestational_unit.disabled=false;
				
				if(frm.father_alt_id1_no)
				{
					if(frm.father_alt_id1_no.disabled == true)
					{
						if(frm.invoked_from.value != 'details_page')
						{						
							frm.father_alt_id1_no.disabled=false;
						}
					}
				}
				if(frm.father_alt_id2_no)
				{
					if(frm.father_alt_id2_no.disabled == true)
					{
						if(frm.invoked_from.value != 'details_page')
						{						
							frm.father_alt_id2_no.disabled=false;
						}
					}
				}
				if(frm.father_alt_id3_no)
				{
					if(frm.father_alt_id3_no.disabled == true)
					{
						if(frm.invoked_from.value != 'details_page')
						{						
							frm.father_alt_id3_no.disabled=false;
						}
					}
				}
				if(frm.father_alt_id4_no)
				{
					if(frm.father_alt_id4_no.disabled == true)
					{
						if(frm.invoked_from.value != 'details_page')
						{						
							frm.father_alt_id4_no.disabled=false;
						}
					}
				}
				
				frm.complns_1st_stage_labour_code.disabled = false;
				frm.complns_2nd_stage_labour_code.disabled = false;
				frm.complns_3rd_stage_labour_code.disabled = false;
				frm.action = "../../servlet/eMP.NewbornRegistrationServlet";
				frm.target = "messageFrame";
				frm.submit();
				
			}
			else
			{
			
				frm.circumference_unit.disabled=false;
				frm.chest_circumference_unit.disabled=false;
				frm.length_unit.disabled=false;
				frm.weight_unit.disabled=false;
				frm.gestational_unit.disabled=false;

			en_Able();

		    var s = "<html><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><head>" ;

			s+="</head><body class='message' onKeyDown='lockKey()'><form name='NewbornRegistration_form' id='NewbornRegistration_form' method='post'  action='../../servlet/eMP.NewbornRegistrationServlet' target='parent.parent.messageFrame'>";

	        var frm1 = frames[1].frames[temp].document.forms[0]
		    for(i=0;i<frm1.elements.length;i++)
			{
				if(frm1.elements[i].type=='checkbox')
				{
			        if(frm1.elements[i].checked)
				        s += "<input type='hidden' name='"+frm1.elements[i].name+"' id='"+frm1.elements[i].name+"' value='Y'>"
					else
						s += "<input type='hidden' name='"+frm1.elements[i].name+"' id='"+frm1.elements[i].name+"' value='N'>"
				 }
		         else
					s += "<input type='hidden' name='"+frm1.elements[i].name+"' id='"+frm1.elements[i].name+"' value=\""+frm1.elements[i].value+"\">"
			}
			s+="</body></html>"

			parent.parent.messageFrame.document.open();
			parent.parent.messageFrame.document.write(s);

				frm.complns_1st_stage_labour_code.disabled = false;
				frm.complns_2nd_stage_labour_code.disabled = false;
				frm.complns_3rd_stage_labour_code.disabled = false;
				messageFrame.document.NewbornRegistration_form.action = action='../../servlet/eMP.NewbornRegistrationServlet';
				messageFrame.document.NewbornRegistration_form.target = 'messageFrame';
				messageFrame.document.NewbornRegistration_form.submit();
				frm.sltRelationship.disabled=true;	
				frm.sltRelationship.value="";	
			}
		

		}else{
			messageFrame.location.href= '../../eCommon/jsp/error.jsp?err_num=';
		}



	} else {
		//alert('Coming'+LocalErrors);
		//parent.parent.messageFrame.location = '../../eCommon/jsp/error.jsp?err_num='+LocalErrors;
		messageFrame.location.href= '../../eCommon/jsp/error.jsp?err_num='+LocalErrors;
	}
	//}
    //  Maintain Birth Register Function ends here 
}

/*
function dis_home()
{
//	parent.frames[0].document.forms[0].home.disabled = true;
	if (parent.parent.frames[0].document.forms[0].home)	 //If called from eIP
	{
		parent.parent.frames[0].document.forms[0].home.disabled = true;
	}
	else
	if (parent.parent.frames[2].frames[0].document.forms[0].home)	  //If called from MP
	{
		parent.parent.frames[2].frames[0].document.forms[0].home.disabled = true;
	}
}
*/
function chkForAltID1Length(obj)
{
	var ald_id_desc = document.forms[0].fatherAltId1Desc.value;
	if((obj.value.length > 0) && (obj.value.length != obj.maxLength))
	{
		 msg = getMessage("ALT_ID_CHARS","MP");
		 msg =msg.replace('$',ald_id_desc);
		 msg =msg.replace('@',obj.maxLength);
		 alert(msg);
		 obj.value = '';
	}
}

function chkFatherLength(Obj,max_value) //Function to check the length of remarks fields.
{
	var str="";
	if(Obj.value.length >100)
	{            
		str = getMessage("REMARKS_CANNOT_EXCEED","Common");
		str = str.replace('$', getLabel("eMP.fatherremarks.label","MP"));
		str = str.replace('#', max_value);
		alert(str);
		Obj.focus();
	}	
}

function chkMotherLength(Obj,max_value) //Function to check the length of remarks fields.
{
	var str="";
	if(Obj.value.length >100)
	{            
		str = getMessage("REMARKS_CANNOT_EXCEED","Common");
		str = str.replace('$', getLabel("eMP.motherremarks.label","MP"));
		str = str.replace('#', max_value);
		alert(str);
		Obj.focus();		
	}
}

function makeMandatory(obj,obj1)
{
	var restrictMntryFields		= "N";
	var called_function			= document.getElementById('called_function').value;
	var isNewBornChngsAppl		= "";
	
	if(document.getElementById('isNewBornChngsAppl'))
	 isNewBornChngsAppl			= document.getElementById('isNewBornChngsAppl').value;

	if(called_function=="IP" && isNewBornChngsAppl	=="true"){
		restrictMntryFields		= "Y";
	}
	var maritalval = false;
	if((document.forms[0].mpDisableFieldsNBFather.value == true || document.forms[0].mpDisableFieldsNBFather.value == 'true') && document.forms[0].nb_father_name_mandatory_yn.value == 'Y' && document.forms[0].enable_marital_status.value == 'Y' ){
	if(obj1 =="FatherDtls" &&  (document.getElementById('function_id').value == "" || document.getElementById('function_id').value == 'PAT_REG' || document.getElementById('function_id').value == 'NEWBORN_REG'))
	{
		maritalval = document.forms[0].no_marital_status.checked;
	}
	else
	{
		maritalval = false;
	}
	}
	if(obj.value != '') 
	{
		//below condition added by kamatchi s ML-MMOH-CRF-2097
		if((document.forms[0].mpDisableFieldsNBFather.value == true || document.forms[0].mpDisableFieldsNBFather.value == 'true') && maritalval == false){
		if(restrictMntryFields=="N"){
			document.getElementById('natImg').style.visibility = 'visible';	
			if(document.getElementById('race_required_yn')) {
				if(document.getElementById('race_required_yn').value=='Y') {
					document.getElementById('racImg').style.visibility = 'visible';	
				}
			}	
		}
		}
		else
		{
		if(document.forms[0].mpDisableFieldsNBFather.value == false || document.forms[0].mpDisableFieldsNBFather.value == 'false'){
		if(restrictMntryFields=="N"){
			document.getElementById('natImg').style.visibility = 'visible';	
			if(document.getElementById('race_required_yn')) {
				if(document.getElementById('race_required_yn').value=='Y') {
					document.getElementById('racImg').style.visibility = 'visible';	
				}
			}	
		}
		}
		}
	}
	else if(obj.value == '' && document.forms[0].father_patient_id.value == '') 
	{
		document.getElementById('natImg').style.visibility = 'hidden';	
		document.getElementById('racImg').style.visibility = 'hidden';	
	}
}

function ValidateBDateTime (from,to)
{
    from = from.value
    to      = to.value
   if ( (from=='') || (to=='') )
   {
	   return false
   }
    var a=  from.split(" ")
    splitdate=a[0];
    splittime=a[1]

    var splitdate1 =splitdate.split("/")
    var splittime1= splittime.split(":")

     var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

     a=  to.split(" ")
    splitdate=a[0];
    splittime=a[1]

     splitdate1 =splitdate.split("/")
     splittime1= splittime.split(":")

     var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

     if(Date.parse(to_date) < Date.parse(from_date))
    {
        return false
    }
    else
        return true;
}

function CheckForCharsNatID(event){
    var strCheck = '0123456789X';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function validateNationality(Nat_Id,Site,def_nat_id_pat_ser_grp,chk_routine,routine_name,nat_id_check_digit_id,validate_len_yn,validate_dup)    { 

var isNumber = new Boolean();
isNumber = true;
var ind = -1;

if ( Nat_Id.value.length > 0 )
{
	if ( !CheckSplCharsNatID(Nat_Id) )
	{
		return false;
	}
	if ( (nat_id_check_digit_id=='M11') && ( (ind = Nat_Id.value.indexOf('X')) != -1) )
	{
		if (ind < 12)           // X can be entered only at 13th position
		{
			msg = getMessage('INVALID_NAT_ID','MP');
			msg = msg.replace("#",document.forms[0].nat_id_prompt.value);
			//Nat_Id.select();
			Nat_Id.value = '';
			Nat_Id.focus();
			alert(msg);
			return false;
		}
	}
}

if ( isNumber )
{
	
    var nid = new String();
    nid = trimString(Nat_Id.value);
    Nat_Id.value = nid;

    if(validate_len_yn == "Y")
        if ( nid.length == Nat_Id.maxLength )   isNumber = true
        else
        {
            isNumber = false

        }
	
    if(isNumber && Nat_Id.value!='')
    {
		if ( validate_dup==null || validate_dup=='')
		{
			validate_dup = 'N';
		}	
		
		var HTMLVal = new String();
        HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/checkNationality.jsp'><input type='hidden' name='nat_id_no' id='nat_id_no' value=\""+Nat_Id.value+"\"><input type='hidden' name='group' id='group' value='N'><input type='hidden' name='Site' id='Site' value=\""+Site+"\"><input type='hidden' name='def_nat_id' id='def_nat_id' value=\""+def_nat_id_pat_ser_grp+"\"><input type='hidden' name='output' id='output' value='A'><input type='hidden' name='nat_id_name' id='nat_id_name' value=\""+Nat_Id.name+"\"><input type='hidden' name='validate_dup' id='validate_dup' value=\""+validate_dup+"\">";

        //chk_routine,routine_name
        if(document.getElementById('national_id_no_dup') !=null)
        HTMLVal +="<input type='hidden' name='dup_nat_id' id='dup_nat_id' value=\""+document.getElementById('national_id_no_dup').value+"\">";
		
	/*	if(document.getElementById('pat_ser_grp_code') !=null)
        HTMLVal +="<input type='hidden' name='selected_id' id='selected_id' value=\""+pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex]+"\">";
		*/
        if(chk_routine == "Y")
             HTMLVal +="<input type='hidden' name='routine_name' id='routine_name' value=\""+routine_name+"\">";
		
        if(nat_id_check_digit_id !=''&& nat_id_check_digit_id !='null')
            HTMLVal +="<input type='hidden' name='nat_id_check_digit_id' id='nat_id_check_digit_id' value=\""+nat_id_check_digit_id+"\">";

        HTMLVal +="<input type='hidden' name='step' id='step' value='second'><input type='hidden' name='from_pat' id='from_pat' value='Y'><input type='hidden' name='from_newBorn' id='from_newBorn' value='Y'></form></body></html>";
       

		if (parent.frames[1].document.forms[0].nat_id_val)
	        parent.frames[1].document.forms[0].nat_id_val.value='G';
		parent.parent.messageFrame.document.write(HTMLVal);
		parent.parent.messageFrame.document.form1.submit();
    }
    else
    {
        if ( Nat_Id.value != '' )
        {
            var val = getMessage("NAT_ID_CHARS",'MP');
            val = val.replace("@",document.getElementById('National_id').maxLength)
            val = val.replace("#",document.getElementById('nat_id_prompt').value)
            alert(val)
			Nat_Id.value = '';
            document.getElementById('National_id').focus();
        }
    }
}
}

function CheckSplCharsNatID(Obj){
		var nat_id_accept_alphanumeric_yn = document.forms[0].nat_id_accept_alphanumeric_yn.value;
        var str = Obj.value;
        var specCharsExist = true;
		if(nat_id_accept_alphanumeric_yn=="Y")
			strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
		else
			strCheck = '0123456789X';
        for (i=0;i<str.length;i++){
            if (strCheck.indexOf(str.charAt(i)) == -1) 
			{
				alert(getMessage("NAT_ID_SPL_NOT_ALLOWED",'MP'));
				Obj.value = '';
				Obj.focus();
				return false;  
			}
        }
        return specCharsExist;
}

function CheckForAlphaCharsNatID(event){

	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
	
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function validateGestDays(obj) {	
	if(obj.value>6) {
		alert(getMessage("GESTATION_DAYS_EXCEED","MP"));
		obj.value = "";
		document.NewbornRegistration_form.gestational_period.focus();
	}
}

/*Added for CRF 689 & 695 Starts*/
function disabledFields(){

	var data_upd_allowed_aft_final_yn=document.NewbornRegistration_form.data_upd_allowed_aft_final_yn.value;
	var finalized_yn=document.NewbornRegistration_form.finalized_yn.value;//proceeding for finalizing the new born
	var q_finalized_yn=document.NewbornRegistration_form.q_finalized_yn.value;//New born record finalized check
	var modify_delivery_type=document.NewbornRegistration_form.modify_delivery_type.value;//New born record finalized check
	var refreshFramesYN=document.NewbornRegistration_form.refreshFramesYN.value;
	var function_id=document.NewbornRegistration_form.function_id_mg.value;
		var called_function	= document.NewbornRegistration_form.called_function.value;
	var isNewBornChngsAppl	= "";
	if(document.NewbornRegistration_form.isNewBornChngsAppl){
		isNewBornChngsAppl	=document.NewbornRegistration_form.isNewBornChngsAppl.value;
	}
	var newBornDtlsIndex		= 1;
	
	if(called_function=="IP" && isNewBornChngsAppl	=="true"){
		var newBornDtlsIndex	= 0;
	}
	if((finalized_yn=="Y" && refreshFramesYN=="Y")||function_id=="MAINTAIN_BIRTH"){
	
		document.NewbornRegistration_form.nb_calander.disabled=true;
		if (document.NewbornRegistration_form.name_prefix != null ){	
			document.NewbornRegistration_form.name_prefix[newBornDtlsIndex].disabled=true;
		}
		if (document.NewbornRegistration_form.first_name != null ){
			document.NewbornRegistration_form.first_name[newBornDtlsIndex].disabled=true;
			if(document.NewbornRegistration_form.bf){
				document.NewbornRegistration_form.bf[newBornDtlsIndex].disabled=true;
			}
		}
		if (document.NewbornRegistration_form.second_name != null ){
			document.NewbornRegistration_form.second_name[newBornDtlsIndex].disabled=true;
			if(document.NewbornRegistration_form.bs){
				document.NewbornRegistration_form.bs[newBornDtlsIndex].disabled=true;
			}
		}
		if (document.NewbornRegistration_form.third_name != null ){
			document.NewbornRegistration_form.third_name[newBornDtlsIndex].disabled=true;
			document.NewbornRegistration_form.bt[newBornDtlsIndex].disabled=true;
		}
		if (document.NewbornRegistration_form.family_name != null ){
			document.NewbornRegistration_form.family_name[newBornDtlsIndex].disabled=true;
			if(document.NewbornRegistration_form.bfam){
				document.NewbornRegistration_form.bfam[newBornDtlsIndex].disabled=true;
			}
		}
		if (document.NewbornRegistration_form.name_suffix != null ){
			document.NewbornRegistration_form.name_suffix[newBornDtlsIndex].disabled=true;
		}
		if (document.NewbornRegistration_form.name_prefix != null ){	
			document.NewbornRegistration_form.name_prefix[newBornDtlsIndex].disabled=true;
		}
		//Local Name Component
		if (document.NewbornRegistration_form.name_suffix_oth_lang != null ){
			document.NewbornRegistration_form.name_suffix_oth_lang[newBornDtlsIndex].disabled=true;
		}
		if (document.NewbornRegistration_form.first_name_oth_lang != null ){
			document.NewbornRegistration_form.first_name_oth_lang[newBornDtlsIndex].disabled=true;
			if(document.NewbornRegistration_form.bfo){
				document.NewbornRegistration_form.bfo[newBornDtlsIndex].disabled=true;
			}
		}
		if (document.NewbornRegistration_form.second_name_oth_lang != null ){
			document.NewbornRegistration_form.second_name_oth_lang[newBornDtlsIndex].disabled=true;
			if(document.NewbornRegistration_form.bso){
				document.NewbornRegistration_form.bso[newBornDtlsIndex].disabled=true;
			}
		}
		if (document.NewbornRegistration_form.third_name_oth_lang != null ){
			document.NewbornRegistration_form.third_name_oth_lang[newBornDtlsIndex].disabled=true;
			if(document.NewbornRegistration_form.bto){
				document.NewbornRegistration_form.bto[newBornDtlsIndex].disabled=true;
			}
		}
		if (document.NewbornRegistration_form.family_name_oth_lang != null ){
			document.NewbornRegistration_form.family_name_oth_lang[newBornDtlsIndex].disabled=true;
			if(document.NewbornRegistration_form.bfamo){
				document.NewbornRegistration_form.bfamo[newBornDtlsIndex].disabled=true;
			}
		}
		if (document.NewbornRegistration_form.name_prefix_oth_lang != null ){
			document.NewbornRegistration_form.name_prefix_oth_lang[newBornDtlsIndex].disabled=true;
		}
		if(document.NewbornRegistration_form.outcome.value=="S"){
			//document.NewbornRegistration_form.all.stillbirth_dtlsID.style.visibility='visible';
			document.getElementById('stillbirth_dtlsID').style.visibility='visible';
		}
	}
	// Code Fix Against Incident Number 34853 Dated on 10/09/2012 By Saanthaakumar
	
   if(q_finalized_yn=="Y") 
	{ 
	 	 if(parent.frames[2].document.forms[0].noOfBirths.value == parent.frames[2].document.forms[0].birth_order.value)
		{
			if(document.NewbornRegistration_form.nod_type) 
			{
				document.NewbornRegistration_form.nod_type.disabled = true;
			}
			
		}
	}
		if(modify_delivery_type=="Y" && q_finalized_yn=="N") 
	{
		
		document.NewbornRegistration_form.nod_type.disabled = false;
	}
	 // 34853 Fix Over
	if(q_finalized_yn=="Y" && data_upd_allowed_aft_final_yn=="N" && function_id == 'MAINTAIN_BIRTH'){
	
		if(parent.parent.frames[0].document.getElementById('apply')){
			parent.parent.frames[0].document.getElementById('apply').disabled=true;
			/*Added by Dharma against MO-CRF-20108 on 7th Nov 2016 Start*/
			if(document.NewbornRegistration_form.sel_accession_num.value==""){ 
				if(document.getElementById('linkNeonatalResuscitation'))document.getElementById('linkNeonatalResuscitation').style.visibility="hidden";
				
			}
			/*Added by Dharma against MO-CRF-20108 on 7th Nov 2016 End*/
		}
		document.NewbornRegistration_form.nb_calander.disabled=true;
		for(count=0;count<document.NewbornRegistration_form.elements.length;count++){
			if(document.NewbornRegistration_form.elements[count].type=="text" || document.NewbornRegistration_form.elements[count].type=="button" || document.NewbornRegistration_form.elements[count].type=="select-one" || document.NewbornRegistration_form.elements[count].type=="checkbox" || document.NewbornRegistration_form.elements[count].type=="image"){
				if(document.NewbornRegistration_form.elements[count].name=='nb_button' || document.NewbornRegistration_form.elements[count].name=='vacc_button' || document.NewbornRegistration_form.elements[count].name=='mother_button' || document.NewbornRegistration_form.elements[count].name=='father_button' || document.NewbornRegistration_form.elements[count].name=='apgar_dtls_name'){
					document.NewbornRegistration_form.elements[count].disabled=false;
				}else{
					document.NewbornRegistration_form.elements[count].disabled=true;
				}
			}
		}
	}
}
/*Added for CRF 689 & 695 Starts Ends*/

/*Added by Dharma on Aug 10th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
function emerRegnNBValidations(){
	var calling_module_id	= document.NewbornRegistration_form.calling_module_id.value;
	var called_function	= document.NewbornRegistration_form.called_function.value
	var isNewBornChngsAppl	= "";
	if(document.NewbornRegistration_form.isNewBornChngsAppl)
		isNewBornChngsAppl	= document.NewbornRegistration_form.isNewBornChngsAppl.value;
	
	var restrictMntryFields		= "N";
	if(called_function=="IP" && isNewBornChngsAppl	=="true"){
		restrictMntryFields		= "Y";
	}
	
	var length_of_baby_yn = document.NewbornRegistration_form.length_of_baby_yn.value;
	var head_circumference_of_baby_yn = document.NewbornRegistration_form.head_circumference_of_baby_yn.value;
	var born_where = document.NewbornRegistration_form.born_where.value;
	var isAllow_External_Newborn = document.NewbornRegistration_form.isAllow_External_Newborn.value;
	var allow_ext_nb_regn_within_days = document.NewbornRegistration_form.allow_ext_nb_regn_within_days.value;
	if(isAllow_External_Newborn=="true" && allow_ext_nb_regn_within_days!='' && allow_ext_nb_regn_within_days !=null){
		if(born_where!= 'I'){
	document.getElementById('practid_desc_MandImg').style.visibility= "hidden";
		}else{document.getElementById('practid_desc_MandImg').style.visibility= "visible";}
	}
	if(calling_module_id=='AE' || restrictMntryFields=="Y" ){
		//'new_born_sex_MandImg',
		
		//Condition added by kamatchi S for ML-MMOH-CRF-2095
		if(calling_module_id == 'AE' && (length_of_baby_yn == 'Y' || head_circumference_of_baby_yn == 'Y') ){
		var fields = new Array ('DeliveryTypeMandImg','practid_desc_MandImg','natImg','racImg','relation_child_MandImg','relation_child11_MandImg','born_where_MandImg','weight_unit_MandImg','apgar_score_MandImg','APGAR_SCORE_IN_5_MINS_YN_IMG','APGAR_SCORE_IN_10_MINS_YN_IMG','umb_mand','PATENCY_OF_ANUS_YN_IMG');
		}
		else
		{
		var fields = new Array ('DeliveryTypeMandImg','practid_desc_MandImg','locngif','natImg','racImg','relation_child_MandImg','relation_child11_MandImg','born_where_MandImg','weight_unit_MandImg','LENGTH_IMG','CIRCUMFERENCE_IMG','apgar_score_MandImg','APGAR_SCORE_IN_5_MINS_YN_IMG','APGAR_SCORE_IN_10_MINS_YN_IMG','umb_mand','PATENCY_OF_ANUS_YN_IMG');
		}
		if(calling_module_id!="AE"){
			fields.splice(0, 1);
		}
		for(i=0;i<fields.length;i++){
			//if(eval('document.all.'+fields[i])){	
			//	eval('document.all.'+fields[i]+'.style.visibility= "hidden"') ;
			if (document.getElementById(fields[i])) {
				document.getElementById(fields[i]).style.visibility = "hidden";
			}
		}
	}
	//Added by Sangeetha for ML-MMOH-CRF-0631 on 14/Aug/17 Start
	var emer_regn_nb_yn	= document.forms[0].emer_regn_nb_yn.value;
	var function_id	= document.forms[0].function_id_mg.value;
	if(emer_regn_nb_yn == "Y") 
		document.NewbornRegistration_form.nod_type.disabled = false;
	//Added by Sangeetha for ML-MMOH-CRF-0631 on 14/Aug/17 End
}
/*Added by Dharma on Aug 10th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/

function noMaritalStatus(obj,CalledFromFunction,function_id)
{
var First_Name_Accept_Yn = document.getElementById('First_Name_Accpt_Yn').value;
var Second_Name_Accept_Yn = document.getElementById('Second_Name_Accpt_Yn').value;
var Third_Name_Accept_Yn = document.getElementById('Third_Name_Accpt_Yn').value;
var Family_Name_Accept_Yn = document.getElementById('Family_Name_Accpt_Yn').value;
var First_Name_Reqd_Yn = document.getElementById('First_Name_Reqd_Yn').value;
var Second_Name_Reqd_Yn = document.getElementById('Second_Name_Reqd_Yn').value;
var Third_Name_Reqd_Yn = document.getElementById('Third_Name_Reqd_Yn').value;
var Family_Name_Reqd_Yn = document.getElementById('Family_Name_Reqd_Yn').value;
var Name_Prefix_Accept_Yn = document.getElementById('Name_Prefix_Accept_Yn').value;
var Name_Prefix_Reqd_Yn = document.getElementById('Name_Prefix_Reqd_Yn').value;
var Name_Suffix_Accept_Yn = document.getElementById('Name_Suffix_Accept_Yn').value;
var Name_Suffix_Reqd_Yn = document.getElementById('Name_Suffix_Reqd_Yn').value;
var dflt_father_first_name_prompt = document.getElementById('dflt_father_first_name_prompt').value;
var dflt_father_Second_name_prompt = document.getElementById('dflt_father_Second_name_prompt').value;
var dflt_father_third_name_prompt = document.getElementById('dflt_father_third_name_prompt').value;
var dflt_father_family_name_prompt = document.getElementById('dflt_father_family_name_prompt').value;
var names_in_oth_lang_yn = document.getElementById('names_in_oth_lang_yn').value;
var i=0;
var fatherDtlsIndex			= 0;
var frm=parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form;
if(obj.checked){
if(CalledFromFunction=="FatherDtls") {
		if( First_Name_Accept_Yn == 'Y' || First_Name_Reqd_Yn == 'Y' ){
		document.getElementById('first_name')[fatherDtlsIndex].value = dflt_father_first_name_prompt;
		document.getElementById('first_name')[fatherDtlsIndex].disabled = true;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('first_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('first_name_oth_lang')[fatherDtlsIndex].disabled = true;}
		}
		if( Second_Name_Accept_Yn == 'Y' || Second_Name_Reqd_Yn == 'Y' ){
		document.getElementById('second_name')[fatherDtlsIndex].value = dflt_father_Second_name_prompt;
		document.getElementById('second_name')[fatherDtlsIndex].disabled = true;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('second_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('second_name_oth_lang')[fatherDtlsIndex].disabled = true;}
		}
		if( Third_Name_Accept_Yn == 'Y' || Third_Name_Reqd_Yn == 'Y' ){
		document.getElementById('third_name')[fatherDtlsIndex].value = dflt_father_third_name_prompt;
		document.getElementById('third_name')[fatherDtlsIndex].disabled = true;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('third_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('third_name_oth_lang')[fatherDtlsIndex].disabled = true;}
		}
		if( Family_Name_Accept_Yn == 'Y' || Family_Name_Reqd_Yn == 'Y' ){
		document.getElementById('family_name')[fatherDtlsIndex].value = dflt_father_family_name_prompt;
		document.getElementById('family_name')[fatherDtlsIndex].disabled = true;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('family_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('family_name_oth_lang')[fatherDtlsIndex].disabled = true;}
		}
		if( Name_Prefix_Accept_Yn == 'Y' || Name_Prefix_Reqd_Yn == 'Y' ){
		document.getElementById('name_prefix')[fatherDtlsIndex].value = '';
		document.getElementById('name_prefix')[fatherDtlsIndex].disabled = true;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('name_prefix_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('name_prefix_oth_lang')[fatherDtlsIndex].disabled = true;}
		}
		if( Name_Suffix_Accept_Yn == 'Y' || Name_Suffix_Reqd_Yn == 'Y' ){
		document.getElementById('name_suffix')[fatherDtlsIndex].value = '';
		document.getElementById('name_suffix')[fatherDtlsIndex].disabled = true;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('name_suffix_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('name_suffix_oth_lang')[fatherDtlsIndex].disabled = true;}
		}
		document.getElementById('natImg').style.visibility = 'hidden';	
		document.getElementById('racImg').style.visibility = 'hidden';
		}
		if(frm.father_alt_id1_no)
		frm.father_alt_id1_no.disabled = true;
		if(frm.father_alt_id2_no)
		frm.father_alt_id2_no.disabled = true;
		if(frm.father_alt_id3_no)
		frm.father_alt_id3_no.disabled = true;
		if(frm.father_alt_id4_no)
		frm.father_alt_id4_no.disabled = true;
		document.getElementById('father_patient_id').disabled = true;
		document.getElementById('pat_id_search').disabled = true;
		document.getElementById('cboOtherAltID').disabled = true;
		document.getElementById('txtOtherAltID').disabled = true;
		document.getElementById('cboNationality_desc').disabled = true;
		document.getElementById('cboNationality_desc').value="";
		document.getElementById('cboNationality_button').disabled = true;
		document.getElementById('cboEthnicGroupDesc').disabled = true;
		document.getElementById('cboEthnicGroupDesc').value="";
		document.getElementById('cboEthnicGroupBtn').disabled = true;
		document.getElementById('fthGovtEmpl').disabled = true;
		document.getElementById('cboReligion').disabled = true;
		document.getElementById('cboOccupationClass').disabled = true;
		document.getElementById('cboOccupation').disabled = true;
		document.getElementById('Occupation_Desc').disabled = true;
		document.getElementById('fatherRemarks').disabled = true;
		if(frm.national_id_no.value != "") document.getElementById('National_id').disabled = true;
		putPatientName(obj,CalledFromFunction);
}
else
{
		if(CalledFromFunction=="FatherDtls") {
		if( First_Name_Accept_Yn == 'Y' || First_Name_Reqd_Yn == 'Y' ){
		document.getElementById('first_name')[fatherDtlsIndex].value = '';
		document.getElementById('first_name')[fatherDtlsIndex].disabled = false;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('first_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('first_name_oth_lang')[fatherDtlsIndex].disabled = false;}
		}
		if( Second_Name_Accept_Yn == 'Y' || Second_Name_Reqd_Yn == 'Y' ){
		document.getElementById('second_name')[fatherDtlsIndex].value = '';
		document.getElementById('second_name')[fatherDtlsIndex].disabled = false;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('second_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('second_name_oth_lang')[fatherDtlsIndex].disabled = false;}
		}
		if( Third_Name_Accept_Yn == 'Y' || Third_Name_Reqd_Yn == 'Y' ){
		document.getElementById('third_name')[fatherDtlsIndex].value = '';
		document.getElementById('third_name')[fatherDtlsIndex].disabled = false;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('third_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('third_name_oth_lang')[fatherDtlsIndex].disabled = false;}
		}
		if( Family_Name_Accept_Yn == 'Y' || Family_Name_Reqd_Yn == 'Y' ){
		document.getElementById('family_name')[fatherDtlsIndex].value = '';
		document.getElementById('family_name')[fatherDtlsIndex].disabled = false;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('family_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('family_name_oth_lang')[fatherDtlsIndex].disabled = false;}
		}
		if( Name_Prefix_Accept_Yn == 'Y' || Name_Prefix_Reqd_Yn == 'Y' ){
		document.getElementById('name_prefix')[fatherDtlsIndex].value = '';
		document.getElementById('name_prefix')[fatherDtlsIndex].disabled = false;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('name_prefix_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('name_prefix_oth_lang')[fatherDtlsIndex].disabled = false;}
		}
		if( Name_Suffix_Accept_Yn == 'Y' || Name_Suffix_Reqd_Yn == 'Y' ){
		document.getElementById('name_suffix')[fatherDtlsIndex].value = '';
		document.getElementById('name_suffix')[fatherDtlsIndex].disabled = false;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('name_suffix_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('name_suffix_oth_lang')[fatherDtlsIndex].disabled = false;}
		}
		}
		if(frm.father_alt_id1_no)
		frm.father_alt_id1_no.disabled = false;
		if(frm.father_alt_id2_no)
		frm.father_alt_id2_no.disabled = false;
		if(frm.father_alt_id3_no)
		frm.father_alt_id3_no.disabled = false;
		if(frm.father_alt_id4_no)
		frm.father_alt_id4_no.disabled = false;
		document.getElementById('father_patient_id').disabled = false;
		document.getElementById('father_patient_name').value = "";
		document.getElementById('pat_id_search').disabled = false;
		document.getElementById('cboOtherAltID').disabled = false;
		document.getElementById('txtOtherAltID').disabled = false;
		document.getElementById('cboNationality_desc').disabled = false;
		document.getElementById('cboNationality_button').disabled = false;
		document.getElementById('cboEthnicGroupDesc').disabled = false;
		document.getElementById('cboEthnicGroupBtn').disabled = false;
		document.getElementById('fthGovtEmpl').disabled = false;
		document.getElementById('cboReligion').disabled = false;
		document.getElementById('cboOccupationClass').disabled = false;
		document.getElementById('cboOccupation').disabled = false;
		document.getElementById('Occupation_Desc').disabled = false;
		document.getElementById('fatherRemarks').disabled = false;
		if(frm.national_id_no.value != "") document.getElementById('National_id').disabled = false;
		//putPatientName(obj,CalledFromFunction);
}

}

function noMaritalStatusload(obj,CalledFromFunction,function_id)
{
	
var First_Name_Accept_Yn = document.getElementById('First_Name_Accpt_Yn').value;
var Second_Name_Accept_Yn = document.getElementById('Second_Name_Accpt_Yn').value;
var Third_Name_Accept_Yn = document.getElementById('Third_Name_Accpt_Yn').value;
var Family_Name_Accept_Yn = document.getElementById('Family_Name_Accpt_Yn').value;
var First_Name_Reqd_Yn = document.getElementById('First_Name_Reqd_Yn').value;
var Second_Name_Reqd_Yn = document.getElementById('Second_Name_Reqd_Yn').value;
var Third_Name_Reqd_Yn = document.getElementById('Third_Name_Reqd_Yn').value;
var Family_Name_Reqd_Yn = document.getElementById('Family_Name_Reqd_Yn').value;
var Name_Prefix_Accept_Yn = document.getElementById('Name_Prefix_Accept_Yn').value;
var Name_Prefix_Reqd_Yn = document.getElementById('Name_Prefix_Reqd_Yn').value;
var Name_Suffix_Accept_Yn = document.getElementById('Name_Suffix_Accept_Yn').value;
var Name_Suffix_Reqd_Yn = document.getElementById('Name_Suffix_Reqd_Yn').value;
var dflt_father_first_name_prompt = document.getElementById('dflt_father_first_name_prompt').value;
var dflt_father_Second_name_prompt = document.getElementById('dflt_father_Second_name_prompt').value;
var dflt_father_third_name_prompt = document.getElementById('dflt_father_third_name_prompt').value;
var dflt_father_family_name_prompt = document.getElementById('dflt_father_family_name_prompt').value;
var names_in_oth_lang_yn = document.getElementById('names_in_oth_lang_yn').value;
var i=0;
var fatherDtlsIndex			= 0;
var frm=parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form;
var objVal = obj.value;
if(objVal == undefined || objVal == 'undefined') objVal = obj ;
if(objVal == 'Y'){
if(CalledFromFunction=="FatherDtls") {
		if( First_Name_Accept_Yn == 'Y' || First_Name_Reqd_Yn == 'Y' ){
		document.getElementById('first_name')[fatherDtlsIndex].value = dflt_father_first_name_prompt;
		document.getElementById('first_name')[fatherDtlsIndex].disabled = true;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('first_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('first_name_oth_lang')[fatherDtlsIndex].disabled = true;}
		}
		if( Second_Name_Accept_Yn == 'Y' || Second_Name_Reqd_Yn == 'Y' ){
		document.getElementById('second_name')[fatherDtlsIndex].value = dflt_father_Second_name_prompt;
		document.getElementById('second_name')[fatherDtlsIndex].disabled = true;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('second_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('second_name_oth_lang')[fatherDtlsIndex].disabled = true;}
		}
		if( Third_Name_Accept_Yn == 'Y' || Third_Name_Reqd_Yn == 'Y' ){
		document.getElementById('third_name')[fatherDtlsIndex].value = dflt_father_third_name_prompt;
		document.getElementById('third_name')[fatherDtlsIndex].disabled = true;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('third_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('third_name_oth_lang')[fatherDtlsIndex].disabled = true;}
		}
		if( Family_Name_Accept_Yn == 'Y' || Family_Name_Reqd_Yn == 'Y' ){
		document.getElementById('family_name')[fatherDtlsIndex].value = dflt_father_family_name_prompt;
		document.getElementById('family_name')[fatherDtlsIndex].disabled = true;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('family_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('family_name_oth_lang')[fatherDtlsIndex].disabled = true;}
		}
		if( Name_Prefix_Accept_Yn == 'Y' || Name_Prefix_Reqd_Yn == 'Y' ){
		document.getElementById('name_prefix')[fatherDtlsIndex].value = '';
		document.getElementById('name_prefix')[fatherDtlsIndex].disabled = true;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('name_prefix_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('name_prefix_oth_lang')[fatherDtlsIndex].disabled = true;}
		}
		if( Name_Suffix_Accept_Yn == 'Y' || Name_Suffix_Reqd_Yn == 'Y' ){
		document.getElementById('name_suffix')[fatherDtlsIndex].value = '';
		document.getElementById('name_suffix')[fatherDtlsIndex].disabled = true;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('name_suffix_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('name_suffix_oth_lang')[fatherDtlsIndex].disabled = true;}
		}
		document.getElementById('natImg').style.visibility = 'hidden';	
		document.getElementById('racImg').style.visibility = 'hidden';
		}
		if(frm.father_alt_id1_no)
		frm.father_alt_id1_no.disabled = true;
		if(frm.father_alt_id2_no)
		frm.father_alt_id2_no.disabled = true;
		if(frm.father_alt_id3_no)
		frm.father_alt_id3_no.disabled = true;
		if(frm.father_alt_id4_no)
		frm.father_alt_id4_no.disabled = true;
		document.getElementById('father_patient_id').disabled = true;
		document.getElementById('pat_id_search').disabled = true;
		document.getElementById('cboOtherAltID').disabled = true;
		document.getElementById('txtOtherAltID').disabled = true;
		document.getElementById('cboNationality_desc').disabled = true;
		document.getElementById('cboNationality_desc').value="";
		document.getElementById('cboNationality_button').disabled = true;
		document.getElementById('cboEthnicGroupDesc').disabled = true;
		document.getElementById('cboEthnicGroupDesc').value="";
		document.getElementById('cboEthnicGroupBtn').disabled = true;
		document.getElementById('fthGovtEmpl').disabled = true;
		document.getElementById('cboReligion').disabled = true;
		document.getElementById('cboOccupationClass').disabled = true;
		document.getElementById('cboOccupation').disabled = true;
		document.getElementById('Occupation_Desc').disabled = true;
		document.getElementById('fatherRemarks').disabled = true;
		if(frm.national_id_no.value != "") document.getElementById('National_id').disabled = true;
		putPatientName(obj,CalledFromFunction);
}
else
{
	if((document.forms[0].invoked_from.value != "servlet" || document.forms[0].invoked_from.value != "details_page") && function_id != "MAINTAIN_BIRTH" ) {
		if(CalledFromFunction=="FatherDtls" && frm.father_patient_name == "") {
		if( First_Name_Accept_Yn == 'Y' || First_Name_Reqd_Yn == 'Y' ){
		document.getElementById('first_name')[fatherDtlsIndex].value = '';
		document.getElementById('first_name')[fatherDtlsIndex].disabled = false;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('first_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('first_name_oth_lang')[fatherDtlsIndex].disabled = false;}
		}
		if( Second_Name_Accept_Yn == 'Y' || Second_Name_Reqd_Yn == 'Y' ){
		document.getElementById('second_name')[fatherDtlsIndex].value = '';
		document.getElementById('second_name')[fatherDtlsIndex].disabled = false;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('second_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('second_name_oth_lang')[fatherDtlsIndex].disabled = false;}
		}
		if( Third_Name_Accept_Yn == 'Y' || Third_Name_Reqd_Yn == 'Y' ){
		document.getElementById('third_name')[fatherDtlsIndex].value = '';
		document.getElementById('third_name')[fatherDtlsIndex].disabled = false;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('third_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('third_name_oth_lang')[fatherDtlsIndex].disabled = false;}
		}
		if( Family_Name_Accept_Yn == 'Y' || Family_Name_Reqd_Yn == 'Y' ){
		document.getElementById('family_name')[fatherDtlsIndex].value = '';
		document.getElementById('family_name')[fatherDtlsIndex].disabled = false;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('family_name_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('family_name_oth_lang')[fatherDtlsIndex].disabled = false;}
		}
		if( Name_Prefix_Accept_Yn == 'Y' || Name_Prefix_Reqd_Yn == 'Y' ){
		document.getElementById('name_prefix')[fatherDtlsIndex].value = '';
		document.getElementById('name_prefix')[fatherDtlsIndex].disabled = false;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('name_prefix_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('name_prefix_oth_lang')[fatherDtlsIndex].disabled = false;}
		}
		if( Name_Suffix_Accept_Yn == 'Y' || Name_Suffix_Reqd_Yn == 'Y' ){
		document.getElementById('name_suffix')[fatherDtlsIndex].value = '';
		document.getElementById('name_suffix')[fatherDtlsIndex].disabled = false;
		if(names_in_oth_lang_yn == 'Y'){
		document.getElementById('name_suffix_oth_lang')[fatherDtlsIndex].value = "";
		document.getElementById('name_suffix_oth_lang')[fatherDtlsIndex].disabled = false;}
		}
		}
		if(frm.father_alt_id1_no)
		frm.father_alt_id1_no.disabled = false;
		if(frm.father_alt_id2_no)
		frm.father_alt_id2_no.disabled = false;
		if(frm.father_alt_id3_no)
		frm.father_alt_id3_no.disabled = false;
		if(frm.father_alt_id4_no)
		frm.father_alt_id4_no.disabled = false;
		document.getElementById('father_patient_id').disabled = false;
		//document.getElementById('father_patient_name').value = "";
		document.getElementById('pat_id_search').disabled = false;
		document.getElementById('cboOtherAltID').disabled = false;
		document.getElementById('txtOtherAltID').disabled = false;
		document.getElementById('cboNationality_desc').disabled = false;
		document.getElementById('cboNationality_button').disabled = false;
		document.getElementById('cboEthnicGroupDesc').disabled = false;
		document.getElementById('cboEthnicGroupBtn').disabled = false;
		document.getElementById('fthGovtEmpl').disabled = false;
		document.getElementById('cboReligion').disabled = false;
		document.getElementById('cboOccupationClass').disabled = false;
		document.getElementById('cboOccupation').disabled = false;
		document.getElementById('Occupation_Desc').disabled = false;
		document.getElementById('fatherRemarks').disabled = false;
		if(frm.national_id_no.value != "")  document.getElementById('National_id').disabled = false;
		//putPatientName(obj,CalledFromFunction);
	}
}
}

