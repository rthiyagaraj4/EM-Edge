

 //function "enableFields(Obj)" to enable / disable and set the values ofindicator mark field depending on the outcome field.
var currentLink = new String();
			currentLink = "M";
function enableFields(Obj,func_id){ 
	if(Obj.value=="L"){
		document.getElementById('stillbirth_dtlsID').style.visibility='hidden';
		if(document.forms[0].called_function.value=='IP'){
			if(document.forms[0].bed_number){
				document.forms[0].bed_number.disabled = false;
				document.forms[0].bed_lookup.disabled = false;
			}
		}
		

		//The below code is added for SRR20056-SCF-6095 [IN:025248] by suresh M on 26.10.2010
		if(document.getElementById('name_prefix')){ 
			if(self.document.forms[0].new_born_sex.value=="M"){
				if(document.getElementById('name_prefix_male_nb').value==""){
					document.getElementById('name_prefix')[1].value="";
				}else{
					document.getElementById('name_prefix')[1].value=document.getElementById('name_prefix_male_nb').value;
				}
				sel_prefix_gen(document.getElementById('name_prefix')[1],'NewbornDtls');
			}else if(self.document.forms[0].new_born_sex.value=="F"){
				if(document.getElementById('name_prefix_female_nb').value==""){
					document.getElementById('name_prefix')[1].value="";
				}else{
					document.getElementById('name_prefix')[1].value=document.getElementById('name_prefix_female_nb').value;
			   }
			   sel_prefix_gen(document.getElementById('name_prefix')[1],'NewbornDtls');
			}else if(self.document.forms[0].new_born_sex.value=="U") { 
				document.getElementById('name_prefix')[1].value="";
				sel_prefix_gen(document.getElementById('name_prefix')[1],'NewbornDtls');
			}else if(self.document.forms[0].new_born_sex.value=="") { 
				document.getElementById('name_prefix')[1].value="";
				sel_prefix_gen(document.getElementById('name_prefix')[1],'NewbornDtls');
			}					
		}
		// Ends SRR20056-SCF-6095 [IN:025248]
		chkumblookup(Obj,func_id);
		if (document.forms[0].indicator_mark.options.length < 3){
			while (document.forms[0].indicator_mark.options.length >0)
				document.forms[0].indicator_mark.remove(document.forms[0].indicator_mark.options[0]);	
			var opt = "";
			opt = document.createElement("OPTION");
			opt.text =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
			opt.value= '';
			document.forms[0].indicator_mark.add(opt)
			opt = document.createElement("OPTION");
			opt.text = getLabel("eMP.Fresh.label","MP");
			opt.value= 'F';
			document.forms[0].indicator_mark.add(opt)
			opt = document.createElement("OPTION");
			opt.text = getLabel("eMP.Macerated.label","MP");
			opt.value= 'M';
			document.forms[0].indicator_mark.add(opt);
		} 		
		document.forms[0].indicator_mark.value="";
		document.forms[0].indicator_mark.disabled=true;
		document.forms[0].feeding.disabled=false;
		document.forms[0].bcg_given_yn.disabled=false;
		document.forms[0].vitak_given_yn.disabled=false;
		document.forms[0].hep_given_yn.disabled=false;			 
		document.forms[0].stools.disabled=false; 		
		document.forms[0].Congenital_Anomalies_newborn.disabled=false;	
		document.forms[0].Congenital_Anomalies_search.disabled=false;
		document.forms[0].delivery_indication.disabled=false;

		document.forms[0].del_indica_newborn.disabled=false;			 
		document.forms[0].del_indica_button.disabled=false;	

		document.forms[0].birth_cert_no.disabled=false;


		document.forms[0].bcg_given_yn.value='Y';
		document.forms[0].vitak_given_yn.value='Y';
		document.forms[0].hep_given_yn.value='Y';		 

		document.forms[0].apgar_score.value = "";
		document.forms[0].apgar_score_five_min.value = "";
		document.forms[0].apgar_score_ten_min.value = "";

		document.forms[0].bcg_datetime.value='';
		document.getElementById('image1').disabled = true;
		document.forms[0].vitkdatetime.value='';
		document.getElementById('image2').disabled = true;
		document.forms[0].hepbdatetime.value='';
		document.getElementById('image3').disabled = true;
		if(document.forms[0].born_where.value=="I"){
			document.getElementById('heart_rate_in_1_min_sel').disabled = false;
			document.getElementById('breathing_in_1_min_sel').disabled = false;
			document.getElementById('grimace_in_1_min_sel').disabled = false;
			document.getElementById('activity_in_1_min_sel').disabled = false;
			document.getElementById('appearance_in_1_min_sel').disabled = false;
		}
		if(document.getElementById('patency_visibility').value == 'Y') {
			if(document.getElementById('PATENCY_OF_ANUS_YN_IMG')){
				if(document.forms[0].called_function.value!='AE'){//Added by Dharma on Aug 17th 2017 against ML-MMOH-CRF-0631 [IN:062148]
					document.getElementById('PATENCY_OF_ANUS_YN_IMG').style.visibility='visible';	
				}
			}
		}
		if(document.getElementById('apgar5_visibility').value == 'Y') {
			if(document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG') && document.forms[0].born_where.value=="I"){
				if(document.forms[0].called_function.value!='AE'){//Added by Dharma on Aug 17th 2017 against ML-MMOH-CRF-0631 [IN:062148]
					document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG').style.visibility='visible';
				}
				document.getElementById('heart_rate_in_5_min_sel').disabled = false;
				document.getElementById('breathing_in_5_min_sel').disabled = false;
				document.getElementById('grimace_in_5_min_sel').disabled = false;
				document.getElementById('activity_in_5_min_sel').disabled = false;
				document.getElementById('appearance_in_5_min_sel').disabled = false;
			}
		}
		if(document.forms[0].born_where.value=="I"){
			document.getElementById('heart_rate_in_10_min_sel').disabled = false;
			document.getElementById('breathing_in_10_min_sel').disabled = false;
			document.getElementById('grimace_in_10_min_sel').disabled = false;
			document.getElementById('activity_in_10_min_sel').disabled = false;
			document.getElementById('appearance_in_10_min_sel').disabled = false;
		}
		if(document.getElementById('apgar10_visibility').value == 'Y') {
			if(document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG')){
				if(document.forms[0].called_function.value!='AE'){//Added by Dharma on Aug 17th 2017 against ML-MMOH-CRF-0631 [IN:062148]
					document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG').style.visibility='visible';
				}
			}
		}
		/*added for CRF 689 & 695 Starts*/
		//if(document.forms[0].accept_names_for_live_birth_yn.value=="N" && document.forms[0].finalized_yn.value=="N"){
		if(document.forms[0].accept_names_for_live_birth_yn.value=="N"){
			if(document.forms[0].first_name!=null){
				document.forms[0].first_name[1].value="";
			}
			if(document.forms[0].second_name!=null){
				document.forms[0].second_name[1].value="";
			}
			if(document.forms[0].third_name!=null){
				document.forms[0].third_name[1].value="";
			}
			if(document.forms[0].family_name!=null){
				document.forms[0].family_name[1].value="";
			}
			if(document.forms[0].first_name_oth_lang){
				document.forms[0].first_name_oth_lang[1].value="";
			}
			if(document.forms[0].second_name_oth_lang){
				document.forms[0].second_name_oth_lang[1].value="";
			}
			if(document.forms[0].third_name_oth_lang){
				document.forms[0].third_name_oth_lang[1].value="";
			}
			if(document.forms[0].family_name_oth_lang){
				document.forms[0].family_name_oth_lang[1].value="";
			}
			putPatientName('','NewbornDtls');
			putLocalLangPatientName('',"NewbornDtls");
		//}else if(document.forms[0].accept_names_for_live_birth_yn.value=="Y" && document.forms[0].finalized_yn.value=="N"){
		}else if(document.forms[0].accept_names_for_live_birth_yn.value=="Y"){
			if(document.forms[0].first_name!=null){
				document.forms[0].first_name[1].value=document.forms[0].nb_first_name_hid.value;
			}
			if(document.forms[0].second_name!=null){
				document.forms[0].second_name[1].value=document.forms[0].nb_second_name_hid.value;
			}
			if(document.forms[0].third_name!=null){
				document.forms[0].third_name[1].value=document.forms[0].nb_third_name_hid.value;
			}
			if(document.forms[0].family_name!=null){
				document.forms[0].family_name[1].value=document.forms[0].nb_family_name_hid.value;
			}
			putPatientName('','NewbornDtls');
			if(document.forms[0].first_name_oth_lang){
				document.forms[0].first_name_oth_lang[1].value=document.forms[0].nb_first_name_hid_loc.value;
			}
			if(document.forms[0].second_name_oth_lang){
				document.forms[0].second_name_oth_lang[1].value=document.forms[0].nb_second_name_hid_loc.value;
			}
			if(document.forms[0].third_name_oth_lang){
				document.forms[0].third_name_oth_lang[1].value=document.forms[0].nb_third_name_hid_loc.value;
			}
			if(document.forms[0].family_name_oth_lang){
				document.forms[0].family_name_oth_lang[1].value=document.forms[0].nb_family_name_hid_loc.value;
			}
			putLocalLangPatientName('',"NewbornDtls");
		}
		document.forms[0].pract_id_still_birth.value="";
		document.forms[0].attendant_at_birth.value="";
		document.forms[0].autopsy_reqd_yn.value="";
		document.forms[0].mate_cond_main_cod.value="";
		document.forms[0].mate_cond_main_cod_dur.value="";
		document.forms[0].mate_cond_oth_cod.value="";
		document.forms[0].mate_cond_oth_cod_dur.value="";
		document.forms[0].mate_cond_preexist_cod.value="";
		document.forms[0].mate_cond_preexist_cod_dur.value="";
		document.forms[0].oth_rel_mate_cond_rel_cod.value="";
		document.forms[0].oth_rel_mate_cond_rel_cod_dur.value="";
		document.forms[0].cond_cau_dea_main_cod.value="";
		document.forms[0].cond_cau_dea_main_cod_dur.value="";
		document.forms[0].cond_cau_dea_oth_cod.value="";
		document.forms[0].cond_cau_dea_oth_cod_dur.value="";
		document.forms[0].cond_cau_dea_preexist_cod.value="";
		document.forms[0].cond_cau_dea_preexist_cod_dur.value="";
		document.forms[0].rel_cond_cau_dea_rel_cod.value="";
		document.forms[0].rel_cond_cau_dea_rel_cod_dur.value="";
		/*added for 689 & 695 ends*/
	}else if(Obj.value=="S"){

		document.getElementById('stillbirth_dtlsID').style.visibility='visible';		
		if(document.forms[0].called_function.value=='IP'){
			if(document.forms[0].bed_number){
				document.forms[0].bed_number.disabled = true;
				document.forms[0].bed_lookup.disabled = true;
				document.forms[0].bed_number.value = "";
			}
		}
		if(document.forms[0].still_born_prefix.value!=""){
			if(document.getElementById('name_prefix')){
				document.getElementById('name_prefix')[1].value=document.getElementById('still_born_prefix').value;
				sel_prefix_gen(document.getElementById('name_prefix')[1],'NewbornDtls');
				putPatientName(document.getElementById('name_prefix')[1],'NewbornDtls');
			}
		}
		document.forms[0].indicator_mark.disabled=false;
		while (document.forms[0].indicator_mark.options.length >0)
			document.forms[0].indicator_mark.remove(document.forms[0].indicator_mark.options[0]);	
		var opt = ""
		opt = document.createElement("OPTION");
		opt.text = getLabel("eMP.Fresh.label","MP");
		opt.value= 'F';
		document.forms[0].indicator_mark.add(opt)
		opt = document.createElement("OPTION");
		opt.text = getLabel("eMP.Macerated.label","MP");
		opt.value= 'M';
		document.forms[0].indicator_mark.add(opt);
		document.forms[0].indicator_mark.value="F";		
		if (document.forms[0].feeding.options.length > 0){
			while (document.forms[0].feeding.options.length >0)
			document.forms[0].feeding.remove(document.forms[0].feeding.options[0]);	
			var opt = "";
			opt = document.createElement("OPTION");
			opt.text =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
			opt.value= '';
			opt.selected=true;
			document.forms[0].feeding.add(opt)
			opt = document.createElement("OPTION");
			opt.text = getLabel("eMP.Breast.label","MP");
			opt.value= 'T';
			document.forms[0].feeding.add(opt)
			opt = document.createElement("OPTION");
			opt.text = getLabel("eMP.Bottle.label","MP");
			opt.value= 'B';
			document.forms[0].feeding.add(opt);
			opt = document.createElement("OPTION");
			opt.text = getLabel("Common.other.label","common");
			opt.value= 'O';
			document.forms[0].feeding.add(opt);
		}
		if(document.forms[0].stools.options.length > 0){
			while (document.forms[0].stools.options.length >0)
				document.forms[0].stools.remove(document.forms[0].stools.options[0]);	
			var opt = "";
			opt = document.createElement("OPTION");
			opt.text =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
			opt.value= '';
			opt.selected=true;
			document.forms[0].stools.add(opt)
			opt = document.createElement("OPTION");
			opt.text = getLabel("eMP.Meconium.label","MP");
			opt.value= 'M';
			document.forms[0].stools.add(opt)
			opt = document.createElement("OPTION");
			opt.text = getLabel("eMP.YellowSoft.label","MP");
			opt.value= 'Y';
			document.forms[0].stools.add(opt);
			opt = document.createElement("OPTION");
			opt.text = getLabel("Common.other.label","common");
			opt.value= 'O';
			document.forms[0].stools.add(opt);
		}
		//document.forms[0].Congenital_Anomalies.options[0].selected=true;			  
		document.forms[0].bcg_given_yn.checked=false;
		document.forms[0].vitak_given_yn.checked=false;
		document.forms[0].hep_given_yn.checked=false;

		document.forms[0].bcg_given_yn.disabled=true
		document.forms[0].vitak_given_yn.disabled=true
		document.forms[0].hep_given_yn.disabled=true

		document.forms[0].bcg_given_yn.value='N';
		document.forms[0].vitak_given_yn.value='N';
		document.forms[0].hep_given_yn.value='N';			
		document.forms[0].txtVaccSite.value="";
		document.forms[0].vitak_VaccSite.value="";
		document.forms[0].hepb_VaccSite.value="";
		document.forms[0].administeredBy.value="";
		document.forms[0].vitak_administeredBy.value="";
		document.forms[0].hepb_administeredBy.value="";
		document.forms[0].Designation.value="";
		document.forms[0].vitak_Designation.value="";
		document.forms[0].hepb_Designation.value="";
		document.forms[0].birth_cert_no.value="";
		document.forms[0].birth_cert_no.disabled=true;
		document.forms[0].feeding.disabled=true;
		document.forms[0].patency_of_anus_yn.options[0].selected=true;
		document.forms[0].patency_of_anus_yn.disabled=true;
		//Added by Rameswar on 19-Jan-16 for ML-MMOH-CRF-0382
		document.forms[0].PatencyofAnusCheckedBy.value='';
		document.forms[0].pract_id_search_patency_hidden.value='';
		document.forms[0].PatencyofAnusCheckedBy.disabled=true;
		document.forms[0].pract_id_search_patency.disabled=true;
		
		//document.forms[0].Congenital_Anomalies.disabled=true;
		document.forms[0].stools.disabled=true;
		document.forms[0].txtVaccSite.disabled=true;
		document.forms[0].vitak_VaccSite.disabled=true;
		document.forms[0].hepb_VaccSite.disabled=true;		
		document.forms[0].Designation.disabled=true;
		document.forms[0].vitak_Designation.disabled=true;
		document.forms[0].hepb_Designation.disabled=true;

		document.forms[0].administeredBy.disabled=true;
		document.forms[0].vitak_administeredBy.disabled=true;
		document.forms[0].hepb_administeredBy.disabled=true;			

		document.forms[0].apgar_score.value = "";
		document.forms[0].apgar_score_five_min.value = "";
		document.forms[0].apgar_score_ten_min.value = "";

		document.forms[0].apgar_score.disabled = true;
		document.forms[0].apgar_score_five_min.disabled = true;
		document.forms[0].apgar_score_ten_min.disabled = true;
		//document.forms[0].all.apg.innerHTML="&nbsp;";
		document.getElementById('apg').innerHTML="&nbsp;";
		//APGAR Score for 1 min values 
		document.getElementById('heart_rate_in_1_min_sel').value="";
		document.getElementById('heart_rate_in_1_min_sel').disabled = true;
		document.getElementById('breathing_in_1_min_sel').value="";
		document.getElementById('breathing_in_1_min_sel').disabled = true;
		document.getElementById('grimace_in_1_min_sel').value="";
		document.getElementById('grimace_in_1_min_sel').disabled = true;
		document.getElementById('activity_in_1_min_sel').value="";
		document.getElementById('activity_in_1_min_sel').disabled = true;
		document.getElementById('appearance_in_1_min_sel').value="";
		document.getElementById('appearance_in_1_min_sel').disabled = true;
		document.getElementById('heart_rate_in_1_min').value="";
		document.getElementById('breathing_in_1_min').value="";
		document.getElementById('grimace_in_1_min').value="";
		document.getElementById('activity_in_1_min').value="";
		document.getElementById('appearance_in_1_min').value="";
		/*		
		document.forms[0].all.apg1.innerHTML="&nbsp;";			
		document.getElementById("patency").style.visibility='hidden';
		if(document.getElementById("PATENCY_OF_ANUS_YN_IMG"))
			document.getElementById("PATENCY_OF_ANUS_YN_IMG").style.visibility='hidden';			
		document.forms[0].all.patency.innerHTML="&nbsp;";
		*/
			
		if(document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG')){
			document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG').style.visibility='hidden';
			document.getElementById('heart_rate_in_5_min_sel').value="";
			document.getElementById('heart_rate_in_5_min_sel').disabled = true;
			document.getElementById('breathing_in_5_min_sel').value="";
			document.getElementById('breathing_in_5_min_sel').disabled = true;
			document.getElementById('grimace_in_5_min_sel').value="";
			document.getElementById('grimace_in_5_min_sel').disabled = true;
			document.getElementById('activity_in_5_min_sel').value="";
			document.getElementById('activity_in_5_min_sel').disabled = true;
			document.getElementById('appearance_in_5_min_sel').value="";
			document.getElementById('appearance_in_5_min_sel').disabled = true;
			document.getElementById('heart_rate_in_5_min').value="";
			document.getElementById('breathing_in_5_min').value="";
			document.getElementById('grimace_in_5_min').value="";
			document.getElementById('activity_in_5_min').value="";
			document.getElementById('appearance_in_5_min').value="";
		}
		if(document.getElementById('PATENCY_OF_ANUS_YN_IMG')){
			document.getElementById('PATENCY_OF_ANUS_YN_IMG').style.visibility='hidden';	
		}
		if(document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG')){
			document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG').style.visibility='hidden';
			document.getElementById('heart_rate_in_10_min_sel').value="";
			document.getElementById('heart_rate_in_10_min_sel').disabled = true;
			document.getElementById('breathing_in_10_min_sel').value="";
			document.getElementById('breathing_in_10_min_sel').disabled = true;
			document.getElementById('grimace_in_10_min_sel').value="";
			document.getElementById('grimace_in_10_min_sel').disabled = true;
			document.getElementById('activity_in_10_min_sel').value="";
			document.getElementById('activity_in_10_min_sel').disabled = true;
			document.getElementById('appearance_in_10_min_sel').value="";
			document.getElementById('appearance_in_10_min_sel').disabled = true;
			document.getElementById('heart_rate_in_10_min').value="";
			document.getElementById('breathing_in_10_min').value="";
			document.getElementById('grimace_in_10_min').value="";
			document.getElementById('activity_in_10_min').value="";
			document.getElementById('appearance_in_10_min').value="";
		}
		document.forms[0].bcg_datetime.value='';
		document.getElementById('image1').disabled = true;
		document.forms[0].vitkdatetime.value='';
		document.getElementById('image2').disabled = true;
		document.forms[0].hepbdatetime.value='';
		document.getElementById('image3').disabled = true;			
		/*added for CRF 689 & 695 starts*/
		if(document.forms[0].first_name!=null){
			document.forms[0].first_name[1].value=document.forms[0].nb_first_name_hid.value;
		}
		if(document.forms[0].second_name!=null){
			document.forms[0].second_name[1].value=document.forms[0].nb_second_name_hid.value;
		}
		if(document.forms[0].third_name!=null){
			document.forms[0].third_name[1].value=document.forms[0].nb_third_name_hid.value;
		}
		if(document.forms[0].family_name!=null){
			document.forms[0].family_name[1].value=document.forms[0].nb_family_name_hid.value;
		}
		putPatientName('','NewbornDtls');
		if(document.forms[0].first_name_oth_lang){
			document.forms[0].first_name_oth_lang[1].value=document.forms[0].nb_first_name_hid_loc.value;
		}
		if(document.forms[0].second_name_oth_lang){
			document.forms[0].second_name_oth_lang[1].value=document.forms[0].nb_second_name_hid_loc.value;
		}
		if(document.forms[0].third_name_oth_lang){
			document.forms[0].third_name_oth_lang[1].value=document.forms[0].nb_third_name_hid_loc.value;
		}
		if(document.forms[0].family_name_oth_lang){
			document.forms[0].family_name_oth_lang[1].value=document.forms[0].nb_family_name_hid_loc.value;
		}
		
	//Added  ML-MMOH-CRF-0621	
	var isRegNewbornApplicable=document.forms[0].isRegNewbornApplicable.value;	
	
	
		
	if(isRegNewbornApplicable=="true" && document.forms[0].outcome.value!="L"){ 
		if(document.forms[0].LENGTH_IMG)document.forms[0].LENGTH_IMG.style.visibility = "hidden";
		if(document.forms[0].CIRCUMFERENCE_IMG)document.forms[0].CIRCUMFERENCE_IMG.style.visibility = "hidden";
			
				if(document.forms[0].length1) document.forms[0].length1.value = "";
				if(document.forms[0].circumference) document.forms[0].circumference.value = "";	
					
	}
	if(isRegNewbornApplicable=="true" && document.forms[0].outcome.value=="L"){
		if(document.forms[0].LENGTH_IMG){
			if(document.forms[0].called_function.value!='AE'){//Added by Dharma on Aug 17th 2017 against ML-MMOH-CRF-0631 [IN:062148]
				document.forms[0].LENGTH_IMG.style.visibility = "visible";
			}
		}
		if(document.forms[0].CIRCUMFERENCE_IMG){
			if(document.forms[0].called_function.value!='AE'){//Added by Dharma on Aug 17th 2017 against ML-MMOH-CRF-0631 [IN:062148]
				document.forms[0].CIRCUMFERENCE_IMG.style.visibility = "visible";
			}
		}
	
				if(document.forms[0].length1) document.forms[0].length1.value = "";
				if(document.forms[0].circumference) document.forms[0].circumference.value = "";	
				
	}
	//End ML-MMOH-CRF-0621
		
		
		putLocalLangPatientName('',"NewbornDtls");
		/*added for CRF 689 & 695 Ends*/


	}
}
    
    function chkValues(Obj)
    {
        if(Obj.checked )
        Obj.value='Y';
        else
        Obj.value='N';
    }
    function enableBirthField(Obj) //Function to set the no of births field properly.
    {
        if(Obj.checked)
		{
            document.forms[0].noOfBirths.disabled=false;
			document.forms[0].noOfBirths.focus();	
			//document.forms[0].all.img1.innerHTML="<img align=center src='../../eCommon/images/mandatory.gif'></font>";
			document.getElementById('img1').innerHTML="<img align=center src='../../eCommon/images/mandatory.gif'></font>";
			document.forms[0].noOfBirths.value ="";//Modified by Thamizh selvi on 10th Jan 2018 agains ML-MMOH-SCF-0904
		}
        else 
        {
            document.forms[0].noOfBirths.disabled=true;
			document.forms[0].noOfBirths.value =1;
			//document.forms[0].all.img1.innerHTML="&nbsp;";
			document.getElementById('img1').innerHTML="&nbsp;";
			document.forms[0].noOfBirths.style.backgroundColor = '';//Added by Thamizh selvi on 7th Dec 2017 against ML-MMOH-SCF-0891

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
    function setNum(Obj){
        document.forms[0].noOfBirths.value=Obj.value;    
    }

    function chkLength(Obj,max_value) //Function to check the length of remarks fields.
    {
		var str="";
        if(Obj.value.length >100)
        {            
			str = getMessage("REMARKS_CANNOT_EXCEED","Common");
			str = str.replace('$', Obj.name);
			str = str.replace('#', max_value);
			alert(str);
            Obj.focus();
        }
     }
    function CheckNumZero(obj) 
    {
        if(obj.value != "")
        {
            if(obj.value<= 0)
            {
               alert(getMessage("BT_WEIGHT_GR_ZERO","MP"));
                obj.select();
                obj.focus();
            }
            else
            CheckNum(obj);
        }
        return;
    }
	function CheckNumZero1(obj)
    {
        if(obj.value != "")
        {
            if(obj.value<= 0)
            {
                 alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));
                obj.select();
                obj.focus();
            }
            else
            CheckNum(obj);
        }
        return;
    }

	async function procClass(obj,target) //Function to obtain Procedure classification
		{
		var proc_class_desc_hd=document.forms[0].proc_class_desc_hd.value;
		var proc_class_desc=document.forms[0].proc_class_desc.value;
		if(proc_class_desc_hd!=proc_class_desc || proc_class_desc==''){
			
			var retVal =    new String();               
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;

                var tit="";				
              	var tit=getLabel("eMP.ProcedureClassification.label","MP")
		//		sql = "select compln_dely_code code, short_desc description from mp_compln_delivery where eff_status = 'E'	 and upper(compln_dely_code) like upper(?) and upper(short_desc) like upper(?) ";

				//Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
				sql="SELECT proc_class_code code, long_desc description FROM mp_proc_classification_lang_vw WHERE language_id = '"+localeName+"' AND eff_status = 'E' AND UPPER (long_desc) LIKE UPPER (?) AND UPPER (proc_class_code) LIKE UPPER (?) ";
			
			
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray;
				argumentArray[2] = dataValueArray;
				argumentArray[3] = dataTypeArray;
				argumentArray[4] = "2,1";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK;
				argumentArray[7] = DESC_CODE;

				retVal = await CommonLookup( tit, argumentArray );				
				if(retVal != null && retVal != "" )
                {		
					/*Modified by Ashwini on 03-Jun-2019 for ML-MMOH-SCF-1235*/
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					document.forms[0].proc_class_desc.value=arr[1];					
					document.forms[0].proc_class_code.value=arr[0];
					document.forms[0].proc_class_desc_hd.value=arr[1];
					/*End ML-MMOH-SCF-1235*/
				}
				else{
					document.forms[0].proc_class_desc.value="";					
					document.forms[0].proc_class_code.value="";
				}
		}
}
function chkprocclass() //Call procClass function if the description field is empty
{
	if(document.forms[0].proc_class_desc.value=="") {}
	else { procClass(document.forms[0].proc_id,document.forms[0].proc_class_desc); }
}


async function chkvagclass() //call bagclass if the description field is empty
{
	if (document.forms[0].vaginal_del_type_desc.value=="") {}
	else await vagClass(document.forms[0].vaginal_del_type_search, document.forms[0].vaginal_del_type_desc);
}

async function delSurgClass(obj,target) //Function to obtain Delivery Surgical Classification
{
	
	var del_serv_desc_hd=document.forms[0].del_serv_desc_hd.value;
	var del_serv_desc=document.forms[0].del_serv_desc.value;
	var isModifyLongShortDescAppl=document.forms[0].isModifyLongShortDescAppl.value;//Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
	if(del_serv_desc_hd!=del_serv_desc || del_serv_desc==''){
		var retVal =    new String();               
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		
		//Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
		if(isModifyLongShortDescAppl == "true")
		{
			var tit=getLabel("eMP.DeliverySurgClass.label","MP");	
		}
		else
		{
			var tit=getLabel("eMP.DeliverySurgicalClassification.label","MP");
		}

		sql="SELECT dely_surg_class_code code, long_desc description FROM mp_dely_surg_clfn_lang_vw WHERE language_id = '"+localeName+"' AND eff_status = 'E' AND UPPER (long_desc) LIKE UPPER (?) AND UPPER (dely_surg_class_code) LIKE UPPER (?) ";		
	
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
	  
		retVal = await CommonLookup( tit, argumentArray);				
		var ret1=unescape(retVal);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) 
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
		if(retVal != null && retVal != "" )
		{		
			/*Modified by Ashwini on 03-Jun-2019 for ML-MMOH-SCF-1235*/
			//var ret1=unescape(retVal);
			//arr=ret1.split(",");
			document.forms[0].del_serv_desc.value=arr[1];					
			document.forms[0].del_serv_class.value=arr[0];
			document.forms[0].del_serv_desc_hd.value=arr[1];
			/*End ML-MMOH-SCF-1235*/
		}
		else{
			document.forms[0].del_serv_desc.value="";					
			document.forms[0].del_serv_class.value="";
		}
	}
}

function chkdelsurgclass() //Call delSurgClass if the corresponding text field is empty
{
	if (document.forms[0].del_serv_desc.value=="") {}
	else { delSurgClass(document.forms[0].del_serv_id,document.forms[0].del_serv_desc); }
}



function parent_details_generate() //function to generate parent details from values sent back from the change patient details page. The 17 values passed back are taken into a string and splitted to 17 temporary variables.
{  //temp0 : no.of birth , temp2 : gestation , temp3 :	gravida, temp4 : parity, temp5 : father patient id, temp6 : father patient name, temp7 : father national id, temp8 : father other alternate id, temp9 : father other alternate id description, temp10 : father nationality, temp11 : father race, temp12 : father givernment employee yes/no, temp13 : father religion, temp14 : father occupation class,temp15 : father occupation, temp16 : father occupation description
	var parent_details = document.forms[0].parent_details1.value;
	var arr1= new Array();
	arr1=parent_details.split(":");
	if ((arr1[0]!="") && (arr1[0]!="0")) { temp0=arr1[0];}
	if (arr1[1]=="Y")  { 
						temp1=arr1[1];
					  }
	if ((arr1[2]!="") && (arr1[2]!="0")) { temp2=arr1[2];}
	if ((arr1[3]!="") && (arr1[3]!="0")) { temp3=arr1[3];}
	if ((arr1[4]!="") && (arr1[4]!="0")) { temp4=arr1[4];}
	if ((arr1[5]!="") && (arr1[5]!="0")) { temp5=arr1[5];}
	if ((arr1[6]!="") && (arr1[6]!="0")) { temp6=arr1[6];}
	if ((arr1[7]!="") && (arr1[7]!="0")) { temp7=arr1[7];}
	if ((arr1[8]!="") && (arr1[8]!="0")) { temp8=arr1[8];}
	if ((arr1[9]!="") && (arr1[9]!="0")) { temp9=arr1[9];}
	if ((arr1[10]!="") && (arr1[10]!="0")) { temp10=arr1[10];}
	if ((arr1[11]!="") && (arr1[11]!="0")) { temp11=arr1[11];}
	if (arr1[12]=="Y") {		
							temp12="true";							
					  }
					  else temp12="false";
	if ((arr1[13]!="") && (arr1[13]!="0")) { temp13=arr1[13];}
	if ((arr1[14]!="") && (arr1[14]!="0")) { temp14=arr1[14];}
	if ((arr1[15]!="") && (arr1[15]!="0")) { temp15=arr1[15];}
	if ((arr1[16]!="") && (arr1[16]!="0")) { temp16=arr1[16];}
	if ((arr1[17]!="") && (arr1[17]!="0")) { temp17=arr1[17];}
	if ((arr1[18]!="") && (arr1[18]!="0")) { temp18=arr1[18];}
	if ((arr1[19]!="") && (arr1[19]!="0")) { temp17=arr1[19];}
	if ((arr1[20]!="") && (arr1[20]!="0")) { temp17=arr1[20];}
}
	
async function searchCountry(obj,target) //Function to obtain Birth Place code and description.
{
    var birthplace_desc_hd=document.forms[0].birthplace_desc_hd.value;
	var birthplace_desc=target.value;
	if(birthplace_desc!=birthplace_desc_hd || birthplace_desc==''){
	var retVal =    new String();               
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	if(obj.name=="contry_code")
	{					
		 tit=getLabel("Common.birthPlace.label","Common")	
		sql="SELECT birth_place_code code, long_desc description FROM mp_birth_place_lang_vw WHERE language_id = '"+localeName+"' AND eff_status = 'E' AND UPPER (long_desc) LIKE UPPER (?) AND UPPER (birth_place_code) LIKE UPPER (?) ";				
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );	
	
	if(retVal != null && retVal != "" )
	{					
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		document.forms[0].birthplace_desc_hd.value=arr[1];
		
		if(target.name == 'Birth_place_desc')
			document.forms[0].Birth_place_code.value= arr[0];
		}
		else
		{
			target.value='';
		}
	}
}
function validateMinMax(obj,min_value,max_value,curr_value) //Function to validate the minimum and maximum values with the current values for gestation, birth weight, length , height and chest circumference.  
{
	if(obj.value != "") {		
		var str = "";
		//if(min_value==0) min_value="";
		//if(max_value==0) max_value="";
		if ((parseFloat(curr_value.value) < parseFloat(min_value)) || (parseFloat(curr_value.value) > parseFloat(max_value)))	{
				str = getMessage("RANGE_CHK_FOR_MIN_MAX","MP");		
				str = str.replace('$', min_value);
				str = str.replace('@', max_value);
				alert(str);
				//obj.select();
				obj.value='';
				obj.focus();				
					
		} else {
			if(obj.name == "gestational_period") {
				if(document.NewbornRegistration_form.gestational_period_days) {
					document.NewbornRegistration_form.gestational_period_days.disabled = false;				
					document.NewbornRegistration_form.gestational_period_days.focus();					
				}
			} 
		}
	} else {
		if(obj.name == "gestational_period") {
			if(document.NewbornRegistration_form.gestational_period_days) {
				document.NewbornRegistration_form.gestational_period_days.value = "";
				document.NewbornRegistration_form.gestational_period_days.disabled = true;
			}
		}
	}
}

// Function  to enable the textboxes only if atleast 1 check box is clicked.
//		var chkCount = 3;
function	enableBcg(obj) //Function to enable text fields corresponding to BCG fields if The bcg checkbox is checked  
{			
	if(obj.checked == true)
		{
			document.forms[0].txtVaccSite.disabled = false;
			document.forms[0].administeredBy.disabled = false;
			document.forms[0].Designation.disabled = false;
			document.forms[0].bcg_datetime.disabled = false;
			document.getElementById('image1').disabled = false;

		}
		else
		{
			document.forms[0].txtVaccSite.disabled = true;
			document.forms[0].administeredBy.disabled = true;
			document.forms[0].Designation.disabled = true;
			document.forms[0].bcg_datetime.disabled = true;
			document.getElementById('image1').disabled = true;
			document.forms[0].txtVaccSite.value = "";
			document.forms[0].administeredBy.value = "";
			document.forms[0].Designation.value = "";
			document.forms[0].bcg_datetime.value = "";			
		}
}

function	enableVitak(obj) //Function to enable text fields corresponding to Vitamin K fields if The Vitamin K checkbox is checked  
{			
	if(obj.checked == true)
	{
		document.forms[0].vitak_VaccSite.disabled = false;
		document.forms[0].vitak_administeredBy.disabled = false;
		document.forms[0].vitak_Designation.disabled = false;
		document.forms[0].vitk_datetime.disabled = false;
		document.getElementById('image2').disabled = false;

	}
	else
	{
		document.forms[0].vitak_VaccSite.disabled = true;
		document.forms[0].vitak_administeredBy.disabled = true;
		document.forms[0].vitak_Designation.disabled = true;
		document.forms[0].vitk_datetime.disabled = true;
		document.getElementById('image2').disabled = true;
		document.forms[0].vitak_VaccSite.value = "";
		document.forms[0].vitak_administeredBy.value = "";
		document.forms[0].vitak_Designation.value = "";
		document.forms[0].vitk_datetime.value = "";		
	}
}

function	enableHepb(obj)//Function to enable text fields corresponding to Hepatitis fields if The Hepatitis checkbox is checked  
{			
	if(obj.checked == true)
	{
		document.forms[0].hepb_VaccSite.disabled = false;
		document.forms[0].hepb_administeredBy.disabled = false;
		document.forms[0].hepb_Designation.disabled = false;
		document.forms[0].hepb_datetime.disabled = false;
		document.getElementById('image3').disabled = false;

	}
	else
	{
		document.forms[0].hepb_VaccSite.disabled = true;
		document.forms[0].hepb_administeredBy.disabled = true;
		document.forms[0].hepb_Designation.disabled = true;
		document.forms[0].hepb_datetime.disabled = true;
		document.getElementById('image3').disabled = true;
		document.forms[0].hepb_VaccSite.value = "";
		document.forms[0].hepb_administeredBy.value = "";
		document.forms[0].hepb_Designation.value = "";
		document.forms[0].hepb_datetime.value = "";
	}
}
async function bed_search()
{
	var retVal = 	new String();
	var nursing_unit_code = document.forms[0].mother_nursing_unit_code.value;
	var bed_no = document.forms[0].mother_bed_no.value;
	var dialogHeight= "42.4" ;
	var dialogWidth	= "65" ;
	var dialogTop	= "65" ;
	var status = "no";
	var arguments	= "" ;	
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?nursing_unit_code="+nursing_unit_code+"&main_bed_no="+bed_no+"&call_function=NEW_BORN_REGN&disable_field=NursingUnit&bed_type=baby",arguments,features);
	if(retVal!=null)
	{
		var arr = retVal.split("^");
		if(arr.length > 2)
		{
		document.forms[0].bed_number.value = arr[1];		
		}
	}
}


var currentTab = new String();
currentTab = "M";
var previousTab = new String();
previousTab = "M";
var prefixReqd;

function tab_click(objName) //Functions to simulate tabbed pane for Mother, Child and Father
{   
	// FIRST CHANGE THE CURRENT SELECTED TAB
    changeTab(objName);
}


function changeTab(TabName) {	
	// RESET THE OLD TAB WHICH IS SELECTED FIRST .............
	if(TabName=='M')
	{
		/*
		 if(document.forms[0].ip_install_yn.value == 'Y' && document.forms[0].called_function.value == 'IP')
		  {
				if( (document.forms[0].outcome.value=='L') || (document.forms[0].pseudo_bed_yn.value=="Y") )
				{
						document.forms[0].mand_gif1.style.visibility = "hidden";
				}
		 }
		 */
         //document.forms[0].umb_mand.style.visibility = "hidden";
	}
	else if(TabName=='F') 
	{
		 /*
		 if(document.forms[0].ip_install_yn.value == 'Y' && document.forms[0].called_function.value == 'IP')
		  {
				if( (document.forms[0].outcome.value=='L') || (document.forms[0].pseudo_bed_yn.value=="Y") )
				{
					document.forms[0].mand_gif1.style.visibility = "hidden";
				}
		  }
		  */
		 // document.forms[0].umb_mand.style.visibility = "hidden";
	}
	else if(TabName=='N')
	{
		if(document.forms[0].ip_install_yn.value == 'Y' && document.forms[0].called_function.value == 'IP')
		{

				if( (document.forms[0].outcome.value=='L') && (document.forms[0].born_where.value=='I') && (document.forms[0].pseudo_bed_yn.value=="N"))
				{
					/*
					document.forms[0].mand_gif1.style.visibility = "visible";
						if (document.forms[0].invoke_adm_from_newborn_yn.value=='Y')
								{
										document.forms[0].mand_gif1.style.visibility='hidden';
								}
					*/

				}
				else if( (document.forms[0].outcome.value=='S'))
				{
					if(document.forms[0].bed_number){
						document.forms[0].bed_number.disabled = true;
						document.forms[0].bed_lookup.disabled = true;
					}
				}
		}
		//document.forms[0].umb_mand.style.visibility = "visible";
	}

    if (currentTab == 'M'){		
        
		document.forms[0].pract_id_search.style.visibility='hidden';
		/*
		document.getElementById("patency").style.visibility='hidden';
		if(document.getElementById("PATENCY_OF_ANUS_YN_IMG"))
				document.getElementById("PATENCY_OF_ANUS_YN_IMG").style.visibility='hidden';
		*/
		document.getElementById('apg').style.visibility='hidden';
		//document.getElementById('apg1').style.visibility='hidden';
		
		if(document.forms[0].multiple_birth_yn.checked==false)
		{
			if(document.getElementById('img1'))
				document.getElementById('img1').innerHTML="&nbsp;";
			//document.getElementById('img1').style.visibility='hidden';
		}
			
    }else if (currentTab == 'N'){	
		
		if(document.forms[0].born_where.value=='I')
		{
			document.forms[0].pract_id_search.style.visibility='visible';
		}
		/*
		document.getElementById("patency").style.visibility='visible';		
		if(document.getElementById("PATENCY_OF_ANUS_YN_IMG"))
				document.getElementById("PATENCY_OF_ANUS_YN_IMG").style.visibility='visible';		
		*/
		document.getElementById('apg').style.visibility='visible';
		//document.getElementById('apg1').style.visibility='visible';

		if(document.getElementById('img1'))
		{
			document.getElementById('img1').innerHTML="&nbsp;";
		}	

    }else if (currentTab == 'F'){	
		
		document.forms[0].pract_id_search.style.visibility='hidden';
		/*
		document.getElementById("patency").style.visibility='hidden';
		if(document.getElementById("PATENCY_OF_ANUS_YN_IMG"))
				document.getElementById("PATENCY_OF_ANUS_YN_IMG").style.visibility='hidden';
		*/
		document.getElementById('apg').style.visibility='hidden';
		//document.getElementById('apg1').style.visibility='hidden';
		if(document.getElementById('img1')){
		document.getElementById('img1').innerHTML="&nbsp;";}
		if(document.forms[0].father_patient_id.value != '' || document.forms[0].father_patient_name.value != '' )
		{ 
			document.getElementById('natImg').style.visibility = 'visible';	
			if(document.getElementById('race_required_yn')) {
				if(document.getElementById('race_required_yn').value=='Y') {
					document.getElementById('racImg').style.visibility = 'visible';	
				}
			}			
		}
		else
		{
			document.getElementById('natImg').style.visibility = 'hidden';			
			document.getElementById('racImg').style.visibility = 'hidden';			
		}
	}
	// CHANGE THE CURRENT TAB WHICH IS SELECTED NOW...............

    if (TabName == 'M'){		
      
		document.forms[0].pract_id_search.style.visibility='hidden';
		/*
		document.getElementById("patency").style.visibility='hidden';
		if(document.getElementById("PATENCY_OF_ANUS_YN_IMG"))
				document.getElementById("PATENCY_OF_ANUS_YN_IMG").style.visibility='hidden';
		*/
		document.getElementById('apg').style.visibility='hidden';
		//document.getElementById('apg1').style.visibility='hidden';
		if(document.forms[0].multiple_birth_yn.checked==false)
		{
		if(document.getElementById('img1'))
		document.getElementById('img1').innerHTML="&nbsp;";
		}
		
    }else if (TabName == 'N'){		
       
		if(document.forms[0].born_where.value=='I')
		{document.forms[0].pract_id_search.style.visibility='visible';}
		/*
		document.getElementById("patency").style.visibility='visible';
		if(document.getElementById("PATENCY_OF_ANUS_YN_IMG"))
				document.getElementById("PATENCY_OF_ANUS_YN_IMG").style.visibility='visible';
		*/
		document.getElementById('apg').style.visibility='visible';
		//document.getElementById('apg1').style.visibility='visible';
		if(document.getElementById('img1')){
		document.getElementById('img1').innerHTML="&nbsp;";}
		
    }else if (TabName == 'F'){		
       
		document.forms[0].pract_id_search.style.visibility='hidden';
		/*
		document.getElementById("patency").style.visibility='hidden';
		if(document.getElementById("PATENCY_OF_ANUS_YN_IMG"))
				document.getElementById("PATENCY_OF_ANUS_YN_IMG").style.visibility='hidden';
		*/
		document.getElementById('apg').style.visibility='hidden';
		//document.getElementById('apg1').style.visibility='hidden';
		if(document.getElementById('img1')){
		document.getElementById('img1').innerHTML="&nbsp;";}
		if(document.forms[0].father_patient_id.value != '' || document.forms[0].father_patient_name.value != '' )
		{ 
			if(document.forms[0].father_patient_id_hd.value != "")
			{
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
			document.getElementById('natImg').style.visibility = 'hidden';	
			document.getElementById('racImg').style.visibility = 'hidden';	
		}
	}
	//Newly added

	//  
		changeLink(TabName);
		moveToLink(TabName);
  
	// FINALY SET THE CURRENT TAB TO THE PASSED PARAMETER
	/*if (TabName == currentTab)
	{ previousTab = 'M';}
	else
	{ previousTab = currentTab;} 
    currentTab = TabName;*/
}

//
function moveToLink(LinkIndex) {	

	if(document.forms[0].function_id_mg.value == 'MAINTAIN_BIRTH')
		frame_ref = "parent.parent.frames[1].frames[2]";
	else
		frame_ref = "parent.parent.frames[1].frames[2]";
	
	if(LinkIndex=='M')
	{
			eval(frame_ref).document.getElementById('mothergrp1_tab').scrollIntoView();			
			
	}
	else if(LinkIndex=='N')
	{
			eval(frame_ref).document.getElementById('newborngrp_tab1').scrollIntoView();			
	}
	else if(LinkIndex=='F')
	{
			//eval(frame_ref).document.getElementById("fathergrp_tab1").scrollIntoView();
			//parent.frames[1].document.forms[1].degree1.focus();
	}
}
//
function changeLink(LinkName) 
	{		
		if (currentLink=='M'){
			
			document.getElementById('mothergrp_tab_a').src='../../eMP/images/Mother Details_click.gif';
		}
		else if (currentLink=='N'){			
			document.getElementById('newborngrp_tab_a').src = '../../eMP/images/New Born.gif';
		}
		else if (currentLink=='F')
			//document.getElementById('fathergrp_tab_a').src = '../../eMP/images/Father Details.gif';

		if(LinkName=='M')
			document.getElementById('mothergrp_tab_a').src='../../eMP/images/Mother Details.gif';
		else if(LinkName=='N'){			
			document.getElementById('newborngrp_tab_a').src='../../eMP/images/New Born.gif';
		}
		else if(LinkName=='F')
			//document.getElementById('fathergrp_tab_a').src='../../eMP/images/Father Details.gif';
		currentLink = LinkName;
	}
//
function calldoDateTimeChk(obj)
{
	if(obj.value!='')
	{
	if(!parent.frames[2].validDate(obj.value,'DMYHM',localeName))
	{
		alert(getMessage("INVALID_DATE_TIME","SM"));			
		obj.value='';
		obj.focus();
	}
	}
}
function Valid_DT(event){
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 

function Valid_TM(event){
	var strCheck = '0123456789:';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 

function selectFunction(obj){
			var val=obj;
			var nb_use_mother_ser = document.forms[0].nb_use_mother_ser.value;
			var  mother_id = document.forms[0].mother_patient_id.value; 
			var page_colour = val;			
			
			location.href='../../eMP/jsp/NewbornRegistrationMain.jsp?page_show='+val+'&nb_use_mother_ser='+nb_use_mother_ser+'&mother_id='+mother_id+'&page_colour='+page_colour;				
		  }//End of Function
	
/*function getpat_category(obj)
{
	var membership_yn=document.forms[0].family_org_id_accept_yn_hd.value;
	var patient_id=document.forms[0].patient_id.value;
	var prefix=obj.value;
	var varSex=document.forms[0].new_born_sex.value;
	var relation_child=document.forms[0].relation_child.value;
	var sStyle =	document.forms[0].sStyle.value;
	prefix=escape(prefix);
	var entitlement_by_pat_cat_ynhd=document.forms[0].entitlement_by_pat_cat_ynhd.value;
	if(membership_yn!='N' && entitlement_by_pat_cat_ynhd!='N'){
		var HTMLVal = new String();
		HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE'><form name='form1' id='form1' method='post' action='../../eMP/jsp/GetRelationship.jsp?callfunction=patcatprefix&Sex=" + varSex + "&relation_child="+relation_child+"&prefix="+prefix+"&patient_id11="+patient_id+"'></form></BODY></HTML>";
		
		parent.parent.frames[2].document.write(HTMLVal);
		parent.parent.frames[2].document.form1.submit()

	}

}*/
function callfun_exp_catdate(obj)
{  
  var function_id_mg = document.forms[0].function_id_mg.value;
  var id=obj.value; 
  var HTMLVal="<html><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eMP/jsp/GetRelationship.jsp'><input type='hidden' name=callfunction value='expcatdate'><input type='hidden' name=cat_code value="+id+"><input type='hidden' name=expdate_from value=maintain><input type='hidden' name='function_id_mg' id='function_id_mg' value = '"+function_id_mg+"'></form></body></html>";
		parent.parent.frames[2].document.write(HTMLVal);
		parent.parent.frames[2].document.tempform1.submit()
}

function getpat_catrel()
{
	var function_id_mg = document.forms[0].function_id_mg.value;
	var membership_yn=document.forms[0].family_org_id_accept_yn_hd.value;
	var patient_id=document.forms[0].patient_id.value;
	var prefix=document.forms[0].sltRelationship.value;
	var varSex=document.forms[0].new_born_sex.value;	
	var callfromfunction =document.forms[0].function_id_mg.value;
	var sStyle =	document.forms[0].sStyle.value;
    	if(callfromfunction!='REGISTER_NEWBORN'){
 		var mother_patient_id1=document.forms[0].mother_patient_id.value;
         patient_id=mother_patient_id1;
		}
	prefix=escape(prefix);
	var entitlement_by_pat_cat_ynhd=document.forms[0].entitlement_by_pat_cat_ynhd.value;
	if(membership_yn!='N' && entitlement_by_pat_cat_ynhd!='N'){
		var relation_child=document.forms[0].relation_child.value;
		var HTMLVal = new String();
		HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/GetRelationship.jsp?callfunction=patcatprefix&Sex=" + varSex + "&relation_child="+relation_child+"&prefix="+prefix+"&patient_id11="+patient_id+"&function_id_mg="+function_id_mg+"'></form></BODY></HTML>";
		
		parent.parent.frames[2].document.write(HTMLVal);
		parent.parent.frames[2].document.form1.submit()

	}

}

function getRelationShip(obj,callgetNewBornRegnFn) //Function for obtaining relation to gender which in turn submits to Getrelationship.jsp for populating the values.
{
		//alert('getRelationShip');
		if(callgetNewBornRegnFn == undefined || callgetNewBornRegnFn == "undefined")
			callgetNewBornRegnFn = "N";

		var varSex = obj.value ;
		
		var nbmalerelationship = document.forms[0].def_nb_male_relationship.value;
		var nbfemalerelationship = document.forms[0].def_nb_female_relationship.value;
		
		var nbunknownrelationship =document.forms[0].def_nb_unknown_relationship.value;
		var callfromfunction =document.forms[0].function_id_mg.value;
		var function_id_mg = callfromfunction; 
		
		var entitlement_by_pat_cat_ynhd=document.forms[0].entitlement_by_pat_cat_ynhd.value;
		var mother_patient_id1='';
		
		if(callfromfunction=='REGISTER_NEWBORN'){
             callfromfunction='NEWBORN';
		}else{
			callfromfunction='';
			if(document.forms[0].mother_patient_id1)
				mother_patient_id1=document.forms[0].mother_patient_id1.value;
			else
				mother_patient_id1=document.forms[0].mother_patient_id.value;					
		}				
		var nbunknownrelationship =document.forms[0].function_id_mg.value;
		var patient_id=document.forms[0].patient_id.value;
		var sStyle =	document.forms[0].sStyle.value;
		var membership_yn=document.forms[0].family_org_id_accept_yn_hd.value;
		
		if(varSex != "")
		{		
				if(membership_yn=='N'){
					if(document.forms[0].invoked_from.value!='details_page'){
						if(document.NewbornRegistration_form.data_upd_allowed_aft_final_yn.value=="Y" && document.NewbornRegistration_form.q_finalized_yn.value=="Y")
						document.forms[0].sltRelationship.disabled=false;
					}
					var HTMLVal = new String();
					HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/GetRelationship.jsp?from=Birth&Sex=" + varSex + "&nbmalerelnship="+nbmalerelationship+"&patient_id="+patient_id+"&nbfemalerelnship="+nbfemalerelationship+"&callfunction=Membership&nbunknownrelnship="+nbunknownrelationship+"&function_id_mg="+function_id_mg+"&callgetNewBornRegnFn="+callgetNewBornRegnFn+"'></form></BODY></HTML>";					
					parent.parent.frames[2].document.write(HTMLVal);
					parent.parent.frames[2].document.form1.submit()
				}else{
						if(document.forms[0].invoked_from.value!='details_page'){
							if(document.NewbornRegistration_form.data_upd_allowed_aft_final_yn.value=="Y" && document.NewbornRegistration_form.q_finalized_yn.value=="Y")
							document.forms[0].sltRelationship.disabled=false;
						}
						var HTMLVal = new String();
						HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/GetRelationship.jsp?from="+callfromfunction+"&Sex=" + varSex + "&nbmalerelnship="+nbmalerelationship+"&nbfemalerelnship="+nbfemalerelationship+"&nbunknownrelnship="+nbunknownrelationship+"&entitlement_by_pat_cat_ynhd="+entitlement_by_pat_cat_ynhd+"&mother_patient_id1="+mother_patient_id1+"&patient_id="+patient_id+"&function_id_mg="+function_id_mg+"&callgetNewBornRegnFn="+callgetNewBornRegnFn+"'></form></BODY></HTML>";
						parent.parent.frames[2].document.write(HTMLVal);
						parent.parent.frames[2].document.form1.submit()
				 }
		}
		else
		{
			document.forms[0].sltRelationship.disabled=true;			
			document.forms[0].sltRelationship.selectedIndex=0;
			var n = document.forms[0].sltRelationship.options.length;
			for(var i=0;i<n;i++)
			{
				document.forms[0].sltRelationship.remove("sltRelationship");		
			}
			var tp = '---'+getLabel("Common.defaultSelect.label","Common")+'---';
			var opt=document.createElement("OPTION");
			opt.text=tp;
			opt.value="";
			document.forms[0].sltRelationship.add(opt);
		}//end else
}
function enableOtherAlt(obj) //Enable other alternate ids.  
	{
		
		if (document.forms[0].cboOtherAltID.value!='')
		{	document.forms[0].txtOtherAltID.disabled=false;
			document.forms[0].txtOtherAltID.readOnly=false;
			document.forms[0].txtOtherAltID.value = "";		
		}
		else
		{
			document.forms[0].txtOtherAltID.disabled=true;
			document.forms[0].txtOtherAltID.readOnly=true;
			document.forms[0].txtOtherAltID.value = "";		
		}

	}
function onchange_antenatal(selobj,func_id,captureAntenatalDtlsYN){
	
	if(selobj.value != 'I') 
	{
		//if(document.forms[0].ip_install_yn.value == 'Y' && document.forms[0].called_function.value == 'IP')
		if(captureAntenatalDtlsYN == 'Y')
		{	
			document.forms[0].ate_born_at_locn_type.value = '';
			document.forms[0].ate_born_at_locn_type.disabled = true;
			document.forms[0].ate_born_at_locn_code.value = '';
			document.forms[0].ate_born_at_locn_code.disabled = true;
			
			//if(func_id=='REGISTER_NEWBORN') {

				var n = parent.frames[2].document.NewbornRegistration_form.ate_born_at_locn_code.options.length;
				
				for(var i=0;i<n;i++)
				{
					parent.frames[2].document.forms[0].ate_born_at_locn_code.remove(0);		
				}
				
				var tp =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
				var opt=parent.frames[2].document.createElement("OPTION");
				opt.text=tp;
				opt.value="";
				parent.frames[2].document.forms[0].ate_born_at_locn_code.add(opt);
				
			//}
		}
	}
	else
	{
		//if(document.forms[0].ip_install_yn.value == 'Y' && document.forms[0].called_function.value == 'IP')
		if(captureAntenatalDtlsYN == 'Y')
		{
			document.forms[0].ate_born_at_locn_type.disabled = false;				  
			document.forms[0].ate_born_at_locn_code.disabled = false;
			
			/*
			if(func_id=='REGISTER_NEWBORN') {
				document.forms[0].ate_born_at_locn_type.disabled = false;				  
				document.forms[0].ate_born_at_locn_code.disabled = false;
			} else {
				document.forms[0].ate_born_at_locn_type.value = document.forms[0].ant_born_locn_type.value;		document.forms[0].ate_born_at_locn_code.value = document.forms[0].ant_born_locn_code.value;	
			}
			*/
		}
	}

}
//Added by Kamatchi S for ML-MMOH-CRF-1757
function onchange_antenatal1(selobj,function_id){
	var selval = selobj.value;
	if(function_id == 'MAINTAIN_BIRTH') { selval = selobj;}
	if(selval != 'I' && (selval !=  undefined || selval != 'undefined')) 
	{
			document.forms[0].ate_born_at_locn_type1.value = '';
			document.forms[0].ate_born_at_locn_type1.disabled = true;
			document.forms[0].ate_born_at_locn_code1.value = '';
			document.forms[0].ate_born_at_locn_code1.disabled = true;
				var n = parent.frames[2].document.NewbornRegistration_form.ate_born_at_locn_code1.options.length;
				
				for(var i=0;i<n;i++)
				{
					parent.frames[2].document.forms[0].ate_born_at_locn_code1.remove(0);		
				}
				
				var tp =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
				var opt=parent.frames[2].document.createElement("OPTION");
				opt.text=tp;
				opt.value="";
				parent.frames[2].document.forms[0].ate_born_at_locn_code1.add(opt);
	}
	else
	{ 
			if(document.forms[0].ate_born_where1.disabled == true){
			document.forms[0].ate_born_at_locn_type1.disabled = true;				  
			document.forms[0].ate_born_at_locn_code1.disabled = true;
			}
			else{
			document.forms[0].ate_born_at_locn_type1.disabled = false;				  
			document.forms[0].ate_born_at_locn_code1.disabled = false;
			}
	}

}

function chkumblookup(selobj,func_id) //Displaying the umblical cord cut by field designation.
{ 
	var allow_ext_nb_regn_within_days			= document.getElementById('allow_ext_nb_regn_within_days').value;
	var isAllow_External_Newborn			= document.getElementById('isAllow_External_Newborn').value;
	
	if(selobj.value != 'I') 
	{
		//if(document.forms[0].ip_install_yn.value == 'Y' && document.forms[0].called_function.value == 'IP')
		if(document.forms[0].captureAntenatalDtlsYN.value == 'Y')
		{	
			document.forms[0].ate_born_at_locn_type.value = '';
			document.forms[0].ate_born_at_locn_type.disabled = true;
			document.forms[0].ate_born_at_locn_code.value = '';
			document.forms[0].ate_born_at_locn_code.disabled = true;
			
			if(func_id=='REGISTER_NEWBORN') {

				var n = parent.frames[2].document.NewbornRegistration_form.ate_born_at_locn_code.options.length;
				for(var i=0;i<n;i++)
				{
					parent.frames[2].document.forms[0].ate_born_at_locn_code.remove("ate_born_at_locn_code");		
				}
				
				var tp =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
				var opt=parent.frames[2].document.createElement("OPTION");
				opt.text=tp;
				opt.value="";
				parent.frames[2].document.forms[0].ate_born_at_locn_code.add(opt);
			}
		}
	}
	else
	{
		//if(document.forms[0].ip_install_yn.value == 'Y' && document.forms[0].called_function.value == 'IP')
		if(document.forms[0].captureAntenatalDtlsYN.value == 'Y')
		{
			if(func_id=='REGISTER_NEWBORN') {
				document.forms[0].ate_born_at_locn_type.disabled = false;				  
				document.forms[0].ate_born_at_locn_code.disabled = false;
			} else {
				document.forms[0].ate_born_at_locn_type.value = document.forms[0].ant_born_locn_type.value;		document.forms[0].ate_born_at_locn_code.value = document.forms[0].ant_born_locn_code.value;	
			}
		}
	}
	if(document.forms[0].born_where.value != 'I'){		
		//document.forms[0].pract_id_search.style.visibility='hidden';
		document.forms[0].pract_id_search.style.visibility='hidden';
		document.forms[0].Umb_cord_cut_by_desig.style.visibility='hidden';
	if(isAllow_External_Newborn=="true" && allow_ext_nb_regn_within_days!='' && allow_ext_nb_regn_within_days !=null){
		document.forms[0].practid_desc_MandImg.style.visibility='hidden';
		}
		
		//document.getElementById("patency").style.visibility='hidden';
		
		if(document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG'))
			document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG').style.visibility='hidden';
		if(document.getElementById('PATENCY_OF_ANUS_YN_IMG'))
			document.getElementById('PATENCY_OF_ANUS_YN_IMG').style.visibility='hidden';	
		if(document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG'))
			document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG').style.visibility='hidden';  	
		
		if(selobj.name == 'born_where') {
			document.forms[0].Umb_cord_cut_by1.value="";
			document.forms[0].Umb_cord_cut_by_physician_id.value="";
			document.forms[0].Umb_cord_cut_by_desig.value="";		 
			document.forms[0].Umb_cord_cut_by.value="";
		}
        
		document.getElementById('nmdesig').innerHTML="";
		document.forms[0].umb_mand.style.visibility = "hidden";
		
		document.getElementById('apg').innerHTML="&nbsp;";
		//document.getElementById('apg1').innerHTML="&nbsp;";
		//document.getElementById('patency').innerHTML="&nbsp;";			


		var n = document.forms[0].born_at_locn_code.options.length;
		for(var i=0;i<n;i++)
		{
			document.forms[0].born_at_locn_code.remove("born_at_locn_code");		
		}
		var tp = '---'+getLabel("Common.defaultSelect.label","Common")+'---';
		var opt=document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		document.forms[0].born_at_locn_code.add(opt);

		document.forms[0].born_at_locn_type.options[0].selected=true;
		document.forms[0].born_at_locn_code.options[0].selected=true;
		document.forms[0].patency_of_anus_yn.options[0].selected=true;
		document.forms[0].patency_of_anus_yn.disabled=true;
		//Added by Rameswar on 19-Jan-16 for ML-MMOH-CRF-0382
		document.forms[0].PatencyofAnusCheckedBy.value='';
		document.forms[0].pract_id_search_patency_hidden.value='';
		document.forms[0].PatencyofAnusCheckedBy.disabled=true;
		document.forms[0].pract_id_search_patency.disabled=true;

		document.forms[0].born_at_locn_type.disabled=true;
		document.forms[0].born_at_locn_code.disabled=true;
		document.forms[0].apgar_score.value = "";
		document.forms[0].apgar_score_five_min.value = "";
		document.forms[0].apgar_score_ten_min.value = "";
		
		/*Below line added for this CRF ML-MMOH-CRF-0621*/
		var isRegNewbornApplicable=document.forms[0].isRegNewbornApplicable.value;	
		
	if(isRegNewbornApplicable=="true" && document.forms[0].born_where.value!="I"){
		if(document.forms[0].LENGTH_IMG)document.forms[0].LENGTH_IMG.style.visibility = "hidden";
		if(document.forms[0].CIRCUMFERENCE_IMG)document.forms[0].CIRCUMFERENCE_IMG.style.visibility = "hidden";
			if(selobj.name == 'born_where'){
				if(document.forms[0].length1) document.forms[0].length1.value = "";
				if(document.forms[0].circumference) document.forms[0].circumference.value = "";	
			}		
	}
	//End ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="false")document.forms[0].apgar_score.disabled = true; //added for this CRF ML-MMOH-CRF-0621
		if(isRegNewbornApplicable=="false")document.forms[0].apgar_score_five_min.disabled = true; //added for this CRF ML-MMOH-CRF-0621
		if(isRegNewbornApplicable=="false")document.forms[0].apgar_score_ten_min.disabled = true;  //added for this CRF ML-MMOH-CRF-0621
		/*Added for CRF 689 & 695 Starts*/
		
		/*Below line added for this CRF ML-MMOH-CRF-0621*/
		
		
			
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L"){
		if(document.forms[0].apgar_score.disabled)document.forms[0].apgar_score.disabled = false;
		if(document.forms[0].apgar_score_five_min.disabled)document.forms[0].apgar_score_five_min.disabled = false;
		if(document.forms[0].apgar_score_ten_min.disabled)document.forms[0].apgar_score_ten_min.disabled = false;		
		}
		
		//End  ML-MMOH-CRF-0621
		
		document.forms[0].heart_rate_in_1_min.value="";
		document.forms[0].heart_rate_in_1_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].heart_rate_in_1_min_sel.disabled = true; //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L")document.forms[0].heart_rate_in_1_min_sel.disabled = false; //added for this CRF ML-MMOH-CRF-0621
		
		document.forms[0].breathing_in_1_min.value="";
		document.forms[0].breathing_in_1_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].breathing_in_1_min_sel.disabled = true; //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L") document.forms[0].breathing_in_1_min_sel.disabled = false; //added for this CRF ML-MMOH-CRF-0621
		
		document.forms[0].grimace_in_1_min.value="";
		document.forms[0].grimace_in_1_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].grimace_in_1_min_sel.disabled = true;  //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L")document.forms[0].grimace_in_1_min_sel.disabled = false;  //added for this CRF ML-MMOH-CRF-0621
		
		document.forms[0].activity_in_1_min.value="";
		document.forms[0].activity_in_1_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].activity_in_1_min_sel.disabled = true;  //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L")document.forms[0].activity_in_1_min_sel.disabled = false;  //added for this CRF ML-MMOH-CRF-0621
		
		document.forms[0].appearance_in_1_min.value="";
		document.forms[0].appearance_in_1_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].appearance_in_1_min_sel.disabled = true;  //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L")document.forms[0].appearance_in_1_min_sel.disabled = false;  //added for this CRF ML-MMOH-CRF-0621 
		
		document.forms[0].heart_rate_in_5_min.value="";
		document.forms[0].heart_rate_in_5_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].heart_rate_in_5_min_sel.disabled = true;  //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L")document.forms[0].heart_rate_in_5_min_sel.disabled = false;  //added for this CRF ML-MMOH-CRF-0621
		
		document.forms[0].breathing_in_5_min.value="";
		document.forms[0].breathing_in_5_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].breathing_in_5_min_sel.disabled = true;  //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L") document.forms[0].breathing_in_5_min_sel.disabled = false;  //added for this CRF ML-MMOH-CRF-0621
		
		document.forms[0].grimace_in_5_min.value="";
		document.forms[0].grimace_in_5_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].grimace_in_5_min_sel.disabled = true;    //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L")document.forms[0].grimace_in_5_min_sel.disabled = false;    //added for this CRF ML-MMOH-CRF-0621 
		
		document.forms[0].activity_in_5_min.value="";
		document.forms[0].activity_in_5_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].activity_in_5_min_sel.disabled = true;   //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true"&& document.forms[0].outcome && document.forms[0].outcome.value=="L") document.forms[0].activity_in_5_min_sel.disabled = false;   //added for this CRF ML-MMOH-CRF-0621
		
		document.forms[0].appearance_in_5_min.value="";
		document.forms[0].appearance_in_5_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].appearance_in_5_min_sel.disabled = true;  //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L") document.forms[0].appearance_in_5_min_sel.disabled = false;  //added for this CRF ML-MMOH-CRF-0621
		
		document.forms[0].heart_rate_in_10_min.value="";
		document.forms[0].heart_rate_in_10_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].heart_rate_in_10_min_sel.disabled = true;  //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L") document.forms[0].heart_rate_in_10_min_sel.disabled = false;  //added for this CRF ML-MMOH-CRF-0621
		
		document.forms[0].breathing_in_10_min.value="";
		document.forms[0].breathing_in_10_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].breathing_in_10_min_sel.disabled = true;  //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L")document.forms[0].breathing_in_10_min_sel.disabled = false;  //added for this CRF ML-MMOH-CRF-0621
		
		document.forms[0].grimace_in_10_min.value="";
		document.forms[0].grimace_in_10_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].grimace_in_10_min_sel.disabled = true;    //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L")document.forms[0].grimace_in_10_min_sel.disabled = false;    //added for this CRF ML-MMOH-CRF-0621
		
		document.forms[0].activity_in_10_min.value="";
		document.forms[0].activity_in_10_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].activity_in_10_min_sel.disabled = true;   //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L")document.forms[0].activity_in_10_min_sel.disabled = false;   //added for this CRF ML-MMOH-CRF-0621
		
		document.forms[0].appearance_in_10_min.value="";
		document.forms[0].appearance_in_10_min_sel.value="";
		if(isRegNewbornApplicable=="false")document.forms[0].appearance_in_10_min_sel.disabled = true;  //added for this CRF ML-MMOH-CRF-0621
		
		if(isRegNewbornApplicable=="true" && document.forms[0].outcome && document.forms[0].outcome.value=="L")document.forms[0].appearance_in_10_min_sel.disabled = false;  //added for this CRF ML-MMOH-CRF-0621
		
		//End  ML-MMOH-CRF-0621
		
		/*Added for CRF 689 & 695 Starts Ends*/
		

		if(document.forms[0].ip_install_yn.value == 'Y' && document.forms[0].called_function.value == 'IP')
		{
			//document.forms[0].mand_gif1.style.visibility = "hidden";
			if(document.forms[0].outcome.value == ' ' )//&& document.forms[0].born_where.value != 'I'
			{
				if(document.forms[0].bed_number){
					document.forms[0].bed_number.disabled = true;
					document.forms[0].bed_lookup.disabled = true;
				}
				//document.forms[0].ate_born_at_locn_code.disabled = true;
			}
		}
	}
	else 
	{		
		document.forms[0].born_at_locn_code.disabled = false;
		document.forms[0].born_at_locn_type.disabled = false;
		document.forms[0].Umb_cord_cut_by_desig.style.visibility='visible';
		if(isAllow_External_Newborn=="true" && allow_ext_nb_regn_within_days!='' && allow_ext_nb_regn_within_days !=null){
		document.forms[0].practid_desc_MandImg.style.visibility='visible';
		}
		document.forms[0].pract_id_search.style.visibility='visible';
		if(document.forms[0].called_function.value!='AE'){//Added by Dharma on Aug 17th 2017 against ML-MMOH-CRF-0631 [IN:062148]
			document.forms[0].umb_mand.style.visibility = "visible";
		}
       
		if(selobj.name == 'born_where') {
			document.forms[0].Umb_cord_cut_by1.value="";
			document.forms[0].Umb_cord_cut_by_physician_id.value="";
			document.forms[0].Umb_cord_cut_by_desig.value="";		 
			document.forms[0].Umb_cord_cut_by.value="";
		}
		
	/*Added for this CRF ML-MMOH-CRF-0621*/
	
	var isRegNewbornApplicable=document.forms[0].isRegNewbornApplicable.value;		
	if(isRegNewbornApplicable=="true" && document.forms[0].outcome.value=="L" && document.forms[0].born_where.value=="I"){

		if(document.forms[0].LENGTH_IMG){
			if(document.forms[0].called_function.value!='AE'){//Added by Dharma on Aug 17th 2017 against ML-MMOH-CRF-0631 [IN:062148]
				document.forms[0].LENGTH_IMG.style.visibility = "visible";
			}
		}
		if(document.forms[0].CIRCUMFERENCE_IMG){
			if(document.forms[0].called_function.value!='AE'){//Added by Dharma on Aug 17th 2017 against ML-MMOH-CRF-0631 [IN:062148]
				document.forms[0].CIRCUMFERENCE_IMG.style.visibility = "visible";
			}
		}
			if(selobj.name == 'born_where'){
				if(document.forms[0].length1) document.forms[0].length1.value = "";
				if(document.forms[0].circumference) document.forms[0].circumference.value = "";	
			}		
	}
	//End ML-MMOH-CRF-0621
		
		
		if(document.forms[0].outcome.value == 'L')
		{
			if(document.getElementById('patency_visibility').value == 'Y') {
				if(document.getElementById('PATENCY_OF_ANUS_YN_IMG')){
					if(document.forms[0].called_function.value!='AE'){//Added by Dharma on Aug 17th 2017 against ML-MMOH-CRF-0631 [IN:062148]
						document.getElementById('PATENCY_OF_ANUS_YN_IMG').style.visibility='visible';	
					}
				}
			}

			if(document.getElementById('apgar5_visibility').value == 'Y') {
				if(document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG')){
					if(document.forms[0].called_function.value!='AE'){//Added by Dharma on Aug 17th 2017 against ML-MMOH-CRF-0631 [IN:062148]
						document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG').style.visibility='visible';
					}
				}
			}

			if(document.getElementById('apgar10_visibility').value == 'Y') {
				if(document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG')){
					if(document.forms[0].called_function.value!='AE'){//Added by Dharma on Aug 17th 2017 against ML-MMOH-CRF-0631 [IN:062148]
						document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG').style.visibility='visible';
					}
				}
			}			
			/*
			document.getElementById("patency").style.visibility='visible';
			document.getElementById("PATENCY_OF_ANUS_YN_IMG").style.visibility='visible';
			*/
			document.forms[0].patency_of_anus_yn.disabled=false;

			//Added by Rameswar on 19-Jan-16 for ML-MMOH-CRF-0382
			if(document.forms[0].patency_of_anus_yn.value!=""){
			document.forms[0].PatencyofAnusCheckedBy.disabled=false;
			document.forms[0].pract_id_search_patency.disabled=false;}

			document.forms[0].apgar_score.value = "";
			document.forms[0].apgar_score_five_min.value = "";
			document.forms[0].apgar_score_ten_min.value = "";
			document.forms[0].apgar_score.disabled = false;
			document.forms[0].apgar_score_five_min.disabled = false;
			document.forms[0].apgar_score_ten_min.disabled = false;
			if(document.forms[0].called_function.value!='AE'){//Added by Dharma on Aug 17th 2017 against ML-MMOH-CRF-0631 [IN:062148]
				document.getElementById('apg').innerHTML="<img align=center src='../../eCommon/images/mandatory.gif'></font>";
				document.getElementById('apg').style.visibility='visible';
			}
			//document.getElementById('apg1').innerHTML="<img align=center src='../../eCommon/images/mandatory.gif'></font>";
			//document.getElementById('patency').innerHTML="<img align=center src='../../eCommon/images/mandatory.gif'></font>";
			if(document.forms[0].ip_install_yn.value == 'Y' && document.forms[0].called_function.value == 'IP' &&
			document.forms[0].pseudo_bed_yn.value=="N" && document.forms[0].outcome.value == 'L' ) {

				//document.forms[0].mand_gif1.style.visibility = "visible";

				if (document.forms[0].invoke_adm_from_newborn_yn.value=='Y') {
					//document.forms[0].mand_gif1.style.visibility='hidden';
				}

				//document.forms[0].bed_number.disabled = false;
				//document.forms[0].bed_lookup.disabled = false;
			}
		/*Added for CRF 689 & 695 Starts*/
		document.forms[0].heart_rate_in_1_min_sel.disabled = false;
		document.forms[0].breathing_in_1_min_sel.disabled = false;
		document.forms[0].grimace_in_1_min_sel.disabled = false;
		document.forms[0].activity_in_1_min_sel.disabled = false;
		document.forms[0].appearance_in_1_min_sel.disabled = false;
		document.forms[0].heart_rate_in_5_min_sel.disabled = false;
		document.forms[0].breathing_in_5_min_sel.disabled = false;
		document.forms[0].grimace_in_5_min_sel.disabled = false;
		document.forms[0].activity_in_5_min_sel.disabled = false;
		document.forms[0].appearance_in_5_min_sel.disabled = false;
		document.forms[0].heart_rate_in_10_min_sel.disabled = false;
		document.forms[0].breathing_in_10_min_sel.disabled = false;
		document.forms[0].grimace_in_10_min_sel.disabled = false;
		document.forms[0].activity_in_10_min_sel.disabled = false;
		document.forms[0].appearance_in_10_min_sel.disabled = false;
		/*Added for CRF 689 & 695 Starts Ends*/
		}
		
		if(document.forms[0].ip_install_yn.value == 'Y' && document.forms[0].called_function.value == 'IP' && document.forms[0].outcome.value != 'S')
		{				
			//document.forms[0].mand_gif1.style.visibility = "visible";
			if(document.forms[0].bed_number){
				document.forms[0].bed_number.disabled = false;
				document.forms[0].bed_lookup.disabled = false;
			}
		}
	}
	mp_parm_reqdate(selobj); 
	
}
function enableDesc(obj)
{
	
	if (obj.selectedIndex != 0)
	{
	document.forms[0].Occupation_Desc.disabled=false;
	}
	else 
	{
	document.forms[0].Occupation_Desc.disabled=true;
	}
}
function clearData(obj)
{
	
	if(obj.value=='' && document.forms[0].father_patient_id_hd.value != "")
	{
		document.forms[0].father_patient_name.value='';
		/*Modified By dharma on May 6th 2015 against AAKH-SCF-0202 [IN:055235] Start*/
		/*document.forms[0].father_alt_id1_no.value='';
		document.forms[0].father_alt_id2_no.value='';
		document.forms[0].father_alt_id3_no.value='';
		document.forms[0].father_alt_id4_no.value='';*/
		if(document.forms[0].father_alt_id1_no)
			document.forms[0].father_alt_id1_no.value='';
		if(document.forms[0].father_alt_id2_no)
			document.forms[0].father_alt_id2_no.value='';
		if(document.forms[0].father_alt_id3_no)
			document.forms[0].father_alt_id3_no.value='';
		if(document.forms[0].father_alt_id4_no)
			document.forms[0].father_alt_id4_no.value='';
		/*Modified By dharma on May 6th 2015 against AAKH-SCF-0202 [IN:055235] End*/
		if(document.forms[0].invoked_from.value != 'details_page')
		{
			//document.forms[0].father_patient_name.disabled=false;
			/*Modified By dharma on May 6th 2015 against AAKH-SCF-0202 [IN:055235] Start*/
			/*document.forms[0].father_alt_id1_no.disabled=false;
			document.forms[0].father_alt_id2_no.disabled=false;
			document.forms[0].father_alt_id3_no.disabled=false;
			document.forms[0].father_alt_id4_no.disabled=false;*/
			if(document.forms[0].father_alt_id1_no)
				document.forms[0].father_alt_id1_no.disabled=false;
			if(document.forms[0].father_alt_id2_no)
			document.forms[0].father_alt_id2_no.disabled=false;
			if(document.forms[0].father_alt_id3_no)
				document.forms[0].father_alt_id3_no.disabled=false;
			if(document.forms[0].father_alt_id4_no)
				document.forms[0].father_alt_id4_no.disabled=false;


			/*Modified By dharma on May 6th 2015 against AAKH-SCF-0202 [IN:055235] End*/
		}
		//document.forms[0].father_patient_name.readOnly=false;
        if(document.forms[0].National_id){
		document.forms[0].National_id.value='';
		document.forms[0].National_id.disabled=false;
		}

		if(document.forms[0].cboOtherAltID){
		document.forms[0].cboOtherAltID.selectedIndex=0;
		document.forms[0].cboOtherAltID.disabled=false;
		}

		if(document.forms[0].txtOtherAltID){
		document.forms[0].txtOtherAltID.value='';
		document.forms[0].txtOtherAltID.disabled=false;
		}

		document.forms[0].cboNationality_desc.disabled=false;
		document.forms[0].cboNationality_button.disabled=false;
		document.forms[0].cboNationality.value='';
		document.forms[0].cboNationality_desc.value='';

		document.forms[0].cboEthnicGroupDesc.value="";
		document.forms[0].cboEthnicGroupDesc.disabled=false;
		document.forms[0].cboEthnicGroupBtn.disabled=false;

		document.forms[0].fthGovtEmpl.checked=false;
		document.forms[0].fthGovtEmpl.disabled=false;

		document.forms[0].cboReligion.selectedIndex=0;
		document.forms[0].cboReligion.disabled=false;

		document.forms[0].cboOccupationClass.selectedIndex=0;
		document.forms[0].cboOccupationClass.disabled=false;

		document.forms[0].cboOccupation.disabled=false;
		while (document.forms[0].cboOccupation.options.length >0)		document.forms[0].cboOccupation.remove(document.forms[0].cboOccupation.options[0]);
		opt = document.createElement("OPTION");
		opt.text =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
		opt.value= '';
		document.forms[0].cboOccupation.add(opt);
		document.forms[0].cboOccupation.value = "";
		document.forms[0].cboOccupation.selectedIndex=0;


		document.forms[0].Occupation_Desc.value='';
		document.forms[0].Occupation_Desc.disabled=false;

		document.forms[0].fatherRemarks.value='';
		document.forms[0].fatherRemarks.disabled=false;
	 
		if(document.forms[0].name_prefix) {
			document.forms[0].name_prefix[0].value='';
			document.forms[0].name_prefix[0].disabled = false;
		}
		if(document.forms[0].first_name) {
			document.forms[0].first_name[0].value='';
			document.forms[0].first_name[0].disabled = false;
			if(document.forms[0].bf){
				document.forms[0].bf[0].disabled = false;
			}
		}
		if(document.forms[0].second_name) {
			document.forms[0].second_name[0].value='';
			document.forms[0].second_name[0].disabled = false;
			if(document.forms[0].bs){
				document.forms[0].bs[0].disabled = false;
			}
		}
		if(document.forms[0].third_name) {
			document.forms[0].third_name[0].value='';
			document.forms[0].third_name[0].disabled = false;
			if(document.forms[0].bt){
				document.forms[0].bt[0].disabled = false;
			}
		}
		if(document.forms[0].family_name) {
			document.forms[0].family_name[0].value='';
			document.forms[0].family_name[0].disabled = false;
			if(document.forms[0].bfam){
				document.forms[0].bfam[0].disabled = false;
			}
		}
		if(document.forms[0].name_suffix) {
			document.forms[0].name_suffix[0].value='';
			document.forms[0].name_suffix[0].disabled = false;
		}
				
		if(document.forms[0].name_prefix_oth_lang) {
			document.forms[0].name_prefix_oth_lang[0].value='';
			document.forms[0].name_prefix_oth_lang[0].disabled = false;
		}
		if(document.forms[0].first_name_oth_lang) {
			document.forms[0].first_name_oth_lang[0].value='';
			document.forms[0].first_name_oth_lang[0].disabled = false;
			if(document.forms[0].bfo){
				document.forms[0].bfo[0].disabled = false;
			}
		}
		if(document.forms[0].second_name_oth_lang) {	
			document.forms[0].second_name_oth_lang[0].value='';
			document.forms[0].second_name_oth_lang[0].disabled = false;
			if(document.forms[0].bso){
				document.forms[0].bso[0].disabled = false;
			}
		}
		if(document.forms[0].third_name_oth_lang) {
			document.forms[0].third_name_oth_lang[0].value='';
			document.forms[0].third_name_oth_lang[0].disabled = false;
			if(document.forms[0].bto){
				document.forms[0].bto[0].disabled = false;
			}
		}
		if(document.forms[0].family_name_oth_lang) {
			document.forms[0].family_name_oth_lang[0].value='';
			document.forms[0].family_name_oth_lang[0].disabled = false;
			if(document.forms[0].bfamo){
				document.forms[0].bfamo[0].disabled = false;
			}
		}
		if(document.forms[0].name_suffix_oth_lang) {	
			document.forms[0].name_suffix_oth_lang[0].value='';
			document.forms[0].name_suffix_oth_lang[0].disabled = false;
		}
		if(document.forms[0].father_patient_id_hd)
			document.forms[0].father_patient_id_hd.value="";

	}
	if(obj.value!=''){
		document.forms[0].father_patient_id_hd.value = "clear";

	}
}

async function attendingNurse(target)
{
	 var att_nurse_newborn_hd=document.forms[0].att_nurse_newborn_hd.value;
		var att_nurse_newborn=document.forms[0].att_nurse_newborn.value;
	    if((target.type=='text' && target.value!='' && att_nurse_newborn_hd!=att_nurse_newborn) || target.type=='button' && (att_nurse_newborn_hd!=att_nurse_newborn || att_nurse_newborn=='')){
		var facility_id=document.forms[0].facility_id.value;
		var retVal =    new String();
	    var argumentArray  = new Array() ;
	    var dataNameArray  = new Array() ;
	    var dataValueArray = new Array() ;
	    var dataTypeArray  = new Array() ;
		var isNewBornChngsAppl	= document.forms[0].isNewBornChngsAppl.value;
		var tit=getLabel("eMP.AttendingNurse.label","MP");
		if(isNewBornChngsAppl=="true"){
			tit=getLabel("eIP.AssistedBy.label","IP");
		}
       
sql = "SELECT a.practitioner_id code, b.practitioner_name description FROM am_pract_for_facility a, am_practitioner_lang_vw b WHERE language_id = '"+localeName+"' AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.facility_id = '"+facility_id+"' AND pract_type IN ('MW','NS') AND a.practitioner_id = b.practitioner_id AND UPPER (b.practitioner_name) LIKE UPPER (?) AND UPPER (a.practitioner_id) LIKE UPPER (?) ";	

	//	sql = "select Practitioner_Id code, practitioner_name description from am_pract_for_facility_vw where eff_status = 'E'	and operating_facility_id = '"+facility_id+"'AND pract_type IN ('MW','NS') and upper(Practitioner_Id) like upper(?) and upper(practitioner_name) like upper(?) and language_id='"+localeName+"'";	
       
		
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
        if(target.type=='button')
		argumentArray[5] = document.forms[0].att_nurse_newborn.value;
		else
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
	    var arr=new Array();

		if(retVal != null && retVal != "" )
		{

			var retVal=unescape(retVal);
			
		   	 arr=retVal.split(",");
			 document.forms[0].att_nurse_newborn.value=arr[1];
			 document.forms[0].attend_midwife_id.value=arr[0];
			 document.forms[0].att_nurse_newborn_hd.value=arr[1];

			
		}
		else
			{
			document.forms[0].att_nurse_newborn.value=''
			document.forms[0].attend_midwife_id.value=''
			}
		}

}


async function compDelievary(target)
{
	    var complications_delivery_hd=document.forms[0].complications_delivery_hd.value;
		var complications_delivery=document.forms[0].comple_ofdel_newborn.value;
		var isModifyLongShortDescAppl=document.forms[0].isModifyLongShortDescAppl.value;//Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
		if((target.type=='text' && target.value!='' && complications_delivery_hd!=complications_delivery) || target.type=='button' && (complications_delivery_hd!=complications_delivery || complications_delivery=='')){
		var facility_id=document.forms[0].facility_id.value;
		var retVal =    new String();
	    var argumentArray  = new Array() ;
	    var dataNameArray  = new Array() ;
	    var dataValueArray = new Array() ;
	    var dataTypeArray  = new Array() ;

		//Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
		if(isModifyLongShortDescAppl == "true")
		{
			var tit=getLabel("eMP.OperativeComplications.label","MP")
		}else
		{
			var tit=getLabel("eMP.CompofDelivery.label","MP")
		}

		sql = "SELECT compln_dely_code code, long_desc description FROM mp_compln_delivery_lang_vw WHERE language_id = '"+localeName+"' AND eff_status = 'E' AND UPPER (long_desc) LIKE UPPER (?) AND UPPER (compln_dely_code) LIKE UPPER (?) AND compln_dely_type = 'M' ";


        //SELECT compln_dely_code, short_desc FROM mp_compln_delivery WHERE eff_status = 'E'	
       
		
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
        if(target.type=='button')
		argumentArray[5] =  document.forms[0].comple_ofdel_newborn.value
		else
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
	    //var arr=new Array();
		var ret1=unescape(retVal);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) 
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
		if(retVal != null && retVal != "" )
		{
			
			/*Modified by Ashwini on 03-Jun-2019 for ML-MMOH-SCF-1235*/
			//var retVal=unescape(retVal);
			
		   	 //arr=retVal.split(",");
			 document.forms[0].comple_ofdel_newborn.value=arr[1];
			 document.forms[0].complications_delivery.value=arr[0];
			 document.forms[0].complications_delivery_hd.value=arr[1];
			 /*End ML-MMOH-SCF-1235*/

			
		}
		else
			{
			document.forms[0].comple_ofdel_newborn.value=''
			document.forms[0].complications_delivery.value=''
			}
		}

}

async function getCompPregnancy(target)
{
	    var compln_pregnancy_desc = document.forms[0].compln_pregnancy_desc.value; 
		var compln_pregnancy_code = document.forms[0].compln_pregnancy_code.value;
		if((target.type=='text' && target.value!='' && compln_pregnancy_desc!=compln_pregnancy_code) || target.type=='button' && (compln_pregnancy_code!=compln_pregnancy_desc || compln_pregnancy_desc == '')){
		var facility_id=document.forms[0].facility_id.value;
		var retVal =    new String();
	    var argumentArray  = new Array() ;
	    var dataNameArray  = new Array() ;
	    var dataValueArray = new Array() ;
	    var dataTypeArray  = new Array() ;
		var tit=getLabel("eMP.ComplicationsRelatedPregnancy.label","MP");
        //SELECT compln_dely_code, short_desc FROM mp_compln_delivery WHERE eff_status = 'E'

		//sql = "select compln_dely_code code, short_desc description from mp_compln_delivery_lang_vw where eff_status = 'E'	 and upper(compln_dely_code) like upper(?) and upper(short_desc) like upper(?)  and  language_id='"+localeName+"'";		
		
		//Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
		sql = "SELECT compln_pregnancy_code code, long_desc description FROM mp_compln_pregnancy_lang_vw WHERE language_id = '"+localeName+"' AND eff_status = 'E' AND related_to_pregnacy_yn = 'Y' AND UPPER (long_desc) LIKE UPPER (?) AND UPPER (compln_pregnancy_code) LIKE UPPER (?) ";
		
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
        if(target.type=='button')
			argumentArray[5] =  document.forms[0].compln_pregnancy_desc.value;
		else
			argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
	    var arr=new Array();
		
		if(retVal != null && retVal != "" )	{  

			/*Modified by Ashwini on 03-Jun-2019 for ML-MMOH-SCF-1235*/
			var retVal=unescape(retVal); 	
		   	arr=retVal.split(",");
			document.forms[0].compln_pregnancy_desc.value=arr[1];
			document.forms[0].compln_pregnancy_code.value=arr[0];
			/*End ML-MMOH-SCF-1235*/
			 //document.forms[0].complications_delivery_hd.value=arr[1]; 			
		} else {
			document.forms[0].compln_pregnancy_desc.value='';
			document.forms[0].compln_pregnancy_code.value='';
		}
	}
}

async function getCompNotRltdPregnancy(target)
{
	    var compln_nr_pregnancy_desc = document.forms[0].compln_nr_pregnancy_desc.value; 
		var compln_nr_pregnancy_code = document.forms[0].compln_nr_pregnancy_code.value;
		if((target.type=='text' && target.value!='' && compln_nr_pregnancy_desc!=compln_nr_pregnancy_code) || target.type=='button' && (compln_nr_pregnancy_code!=compln_nr_pregnancy_desc || compln_nr_pregnancy_desc == '')){
		var facility_id=document.forms[0].facility_id.value;
		var retVal =    new String();
	    var argumentArray  = new Array() ;
	    var dataNameArray  = new Array() ;
	    var dataValueArray = new Array() ;
	    var dataTypeArray  = new Array() ;

		var tit=getLabel("eMP.ComplicationsNotRelatedPregnancy.label","MP");
       	
		//Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
		sql = "SELECT compln_pregnancy_code code, long_desc description FROM mp_compln_pregnancy_lang_vw WHERE language_id = '"+localeName+"' AND eff_status = 'E' AND related_to_pregnacy_yn = 'N' AND UPPER (long_desc) LIKE UPPER (?) AND UPPER (compln_pregnancy_code) LIKE UPPER (?) ";
		
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
        if(target.type=='button')
			argumentArray[5] =  document.forms[0].compln_nr_pregnancy_desc.value;
		else
			argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
	    var arr=new Array();

		if(retVal != null && retVal != "" )	{  

			/*Modified by Ashwini on 03-Jun-2019 for ML-MMOH-SCF-1235*/
			var retVal=unescape(retVal); 			
		   	arr=retVal.split(",");
			document.forms[0].compln_nr_pregnancy_desc.value=arr[1];
			document.forms[0].compln_nr_pregnancy_code.value=arr[0];	
			/*End ML-MMOH-SCF-1235*/
		} else {
			document.forms[0].compln_nr_pregnancy_desc.value='';
			document.forms[0].compln_nr_pregnancy_code.value='';
		}
	}
}

async function delIndiaction(target)
{
	    var delivery_indication_hd=document.forms[0].delivery_indication_hd.value;
		var del_indica_newborn=document.forms[0].del_indica_newborn.value;
		var isModifyLongShortDescAppl=document.forms[0].isModifyLongShortDescAppl.value;//Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
		if((target.type=='text' && target.value!='' && delivery_indication_hd!=del_indica_newborn) || (target.type=='button' && (delivery_indication_hd!=del_indica_newborn || del_indica_newborn==''))){
		var facility_id=document.forms[0].facility_id.value;
		var retVal =    new String();
	    var argumentArray  = new Array() ;
	    var dataNameArray  = new Array() ;
	    var dataValueArray = new Array() ;
	    var dataTypeArray  = new Array() ;
		
		//Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
		if(isModifyLongShortDescAppl == "true")
		{
			var tit=getLabel("eMP.IndicationsForOperativeDelivery.label","MP")			
		}else
		{
			var tit=getLabel("eMP.DeliveryIndication.label","MP")
		}

		sql = "SELECT dely_ind_code code, long_desc description FROM mp_dlvry_indication_lang_vw WHERE language_id = '"+localeName+"' AND eff_status = 'E' AND UPPER (long_desc) LIKE UPPER (?) AND UPPER (dely_ind_code) LIKE UPPER (?) ";
        	
       
		
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
        if(target.type=='button')
		argumentArray[5] = document.forms[0].del_indica_newborn.value;
		else
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
	    //var arr=new Array();
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retVal != null && retVal != "" )
		{
			
			/*Modified by Ashwini on 03-Jun-2019 for ML-MMOH-SCF-1235*/
			//var retVal=unescape(retVal);
			
		   	 //arr=retVal.split(",");
			 document.forms[0].del_indica_newborn.value=arr[1];
			 document.forms[0].delivery_indication.value=arr[0];
			 document.forms[0].delivery_indication_hd.value=arr[1];
			 /*End ML-MMOH-SCF-1235*/

			
		}
		else
			{
			document.forms[0].del_indica_newborn.value=''
			document.forms[0].delivery_indication.value=''
			}

		}

}

//function for Cong Anomalies
async function Congenital_Ano(target)
{
    var Congenital_Anomalies_hd=document.forms[0].Congenital_Anomalies_hd.value;
	var Congenital_Anomalies_newborn=document.forms[0].Congenital_Anomalies_newborn.value;
	if((target.type=='text' && target.value!='' && Congenital_Anomalies_newborn!=Congenital_Anomalies_hd) || (target.type=='button' && (Congenital_Anomalies_newborn!=Congenital_Anomalies_hd || Congenital_Anomalies_newborn=='' ))){
		var facility_id=document.forms[0].facility_id.value;
		var retVal =    new String();
	    var argumentArray  = new Array() ;
	    var dataNameArray  = new Array() ;
	    var dataValueArray = new Array() ;
	    var dataTypeArray  = new Array() ;
	    var tit=getLabel("eMP.CongenitalAnomalies.label","MP")

		//SELECT cong_anomalies_code, short_desc FROM mp_congenital_anomalies WHERE eff_status = 'E'
        
		//Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
		sql = "SELECT cong_anomalies_code code, long_desc description FROM mp_cong_anomalies_lang_vw WHERE language_id = '"+localeName+"' AND eff_status = 'E' AND UPPER (long_desc) LIKE UPPER (?) AND UPPER (cong_anomalies_code) LIKE UPPER (?) ";
       
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
        if(target.type=='button')
		argumentArray[5] =  document.forms[0].Congenital_Anomalies_newborn.value;
		else
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
	    var arr=new Array();

		if(retVal != null && retVal != "" )
		{
			
			/*Modified by Ashwini on 03-Jun-2019 for ML-MMOH-SCF-1235*/
			var retVal=unescape(retVal);
			
		   	arr=retVal.split(",");
			document.forms[0].Congenital_Anomalies_newborn.value=arr[1];
			document.forms[0].Congenital_Anomalies.value=arr[0];
			document.forms[0].Congenital_Anomalies_hd.value=arr[1];
			/*End ML-MMOH-SCF-1235*/			
		}
		else
		{
			document.forms[0].Congenital_Anomalies_newborn.value=''
			document.forms[0].Congenital_Anomalies.value=''
		}
	}
}


async function comp_delivery(target){
	var complications_delivery_hd1=document.forms[0].complications_delivery_hd1.value;
	var complications_delivery_text=document.forms[0].complications_delivery_text.value;
	if((target.type=='text' && target.value!='' && complications_delivery_hd1!=complications_delivery_text) || (target.type=='button' && (complications_delivery_hd1!=complications_delivery_text || complications_delivery_text==''))){
		var facility_id=document.forms[0].facility_id.value;
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel("eMP.FetusCompofDelivery.label","MP")
		
			//Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
			sql = "select compln_dely_code code, long_desc description from mp_compln_delivery_lang_vw where eff_status = 'E'	 and  upper(long_desc) like upper(?) and upper(compln_dely_code) like upper(?) and language_id='"+localeName+"' and COMPLN_DELY_TYPE='F' ";
	
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
		if(target.type=='button'){
			argumentArray[5] = document.forms[0].complications_delivery_text.value;
		}else{
			argumentArray[5] = target.value;
		}
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
		var arr=new Array();
		if(retVal != null && retVal != "" ){
	
			/*Modified by Ashwini on 03-Jun-2019 for ML-MMOH-SCF-1235*/
			var retVal=unescape(retVal);			
			arr=retVal.split(",");
			document.forms[0].complications_delivery_text.value=arr[1];
			document.forms[0].complications_delivery_nb.value=arr[0];
			document.forms[0].complications_delivery_hd1.value=arr[1];	
			/*End ML-MMOH-SCF-1235*/
	
		}
		else
		{
			document.forms[0].complications_delivery_text.value=''
			document.forms[0].complications_delivery_nb.value=''
		}
	}
}

async function get_Nationality(target)
{
    var cboNationality_hd=document.forms[0].cboNationality_hd.value;
	var cboNationality_desc=document.forms[0].cboNationality_desc.value;
	
	if((target.type=='text' && target.value!='' && cboNationality_hd!=cboNationality_desc) || (target.type=='button' && (cboNationality_hd!=cboNationality_desc || cboNationality_desc==''))){
		var facility_id=document.forms[0].facility_id.value;
		var retVal =    new String();
	    var argumentArray  = new Array() ;
	    var dataNameArray  = new Array() ;
	    var dataValueArray = new Array() ;
	    var dataTypeArray  = new Array() ;
	    var tit=getLabel("Common.nationality.label","Common")

		      //SELECT country_code, long_desc FROM mp_country WHERE country_code = '"+temp10+"' ORDER BY 2'

		sql = "SELECT country_code code, long_desc description FROM mp_country_lang_vw WHERE language_id = '"+localeName+"' AND eff_status = 'E' AND UPPER (long_desc) LIKE UPPER (?) AND UPPER (country_code) LIKE UPPER (?) ";	
       
		
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
        if(target.type=='button')
		argumentArray[5] = document.forms[0].cboNationality_desc.value;
		else
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
	    var arr=new Array();

		if(retVal != null && retVal != "" )
		{
			var retVal=unescape(retVal);
			
		   	 arr=retVal.split(",");
			 document.forms[0].cboNationality_desc.value=arr[1];
			 document.forms[0].cboNationality.value=arr[0];
			 document.forms[0].cboNationality_hd.value=arr[1];			
		}
		else
		{
			document.forms[0].cboNationality_desc.value=''
			document.forms[0].cboNationality.value=''
		}
	}
}

async function vagClass(obj,target) //Function to populate vaginal delivery type
{
	var vaginal_del_type_desc_hd=document.forms[0].vaginal_del_type_desc_hd.value;
	var vaginal_del_type_desc=document.forms[0].vaginal_del_type_desc.value;
	if(vaginal_del_type_desc_hd!=vaginal_del_type_desc || vaginal_del_type_desc=='' ){
		var retVal =    new String();               
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
	
		var tit=getLabel("eMP.VaginalDeliveryType.label","MP")
		
		//Added by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109
		sql="SELECT vag_dely_type code, long_desc description FROM mp_vaginal_dely_type_lang_vw WHERE language_id = '"+localeName+"' AND eff_status = 'E' AND UPPER (long_desc) LIKE UPPER (?) AND UPPER (vag_dely_type) LIKE UPPER (?) ";	
		
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
	
		retVal = await CommonLookup( tit, argumentArray );	
		var ret1=unescape(retVal);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) 
		{
	 		arr[0]="";	
	 		arr[1]="";	
		}
		if(retVal != null && retVal != "" )
		{	
			/*Modified by Ashwini on 03-Jun-2019 for ML-MMOH-SCF-1235*/
			//var ret1=unescape(retVal);
			//arr=ret1.split(",");
			document.forms[0].vaginal_del_type_desc.value=arr[1];					
			document.forms[0].vaginal_del_type_code.value=arr[0];
			document.forms[0].vaginal_del_type_desc_hd.value=arr[1];
			/*End ML-MMOH-SCF-1235*/
		}
		else
		{
			document.forms[0].vaginal_del_type_desc.value="";					
			document.forms[0].vaginal_del_type_code.value="";
		}
	}
}
///Newly added by shyam
async function callPatientSearch(source)
{
	//alert("2426");
	var func_idpassed = document.getElementById("func_idpassed").value;
	var retVal = 	new String();
	var dialogTop	= "10%";
	var dialogHeight= "95%" ; 
	var dialogWidth	= "85%" ;	
	/*var dialogHeight= "400px" ;
	var dialogTop = "10px" ;
	var dialogWidth	= "700px" ; */
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:" + dialogTop + "; scroll=no; status:" + status;
	retVal = await top.window.showModalDialog("../../eMP/jsp/ViewBirthRegisterMain.jsp?view=modal&func_idpassed="+func_idpassed,arguments,features);
	//parent.frames[0].location.href='<%=source%>'
	parent.frames[0].location.href=source

	if (retVal!=null)  
       parent.frames[1].location.href='../../eMP/jsp/MaintainBirthRegistrationFrames.jsp?child_id='+retVal
} 	


function newbornbabyNames(){
	var accept_names_for_live_birth_yn = "";
	if(document.forms[0].accept_names_for_live_birth_yn)
		accept_names_for_live_birth_yn = document.forms[0].accept_names_for_live_birth_yn.value;
	var function_id_mg=document.forms[0].function_id_mg.value;
	var finalized_yn=document.forms[0].finalized_yn.value;
	var invoked_from=document.forms[0].invoked_from.value;
	//if(finalized_yn=="N"){
		if(document.forms[0].first_name!=null){
			document.forms[0].nb_first_name_hid.value=document.forms[0].first_name[1].value;
		}
		if(document.forms[0].second_name!=null){
			document.forms[0].nb_second_name_hid.value=document.forms[0].second_name[1].value;
		}
		if(document.forms[0].third_name!=null){
			document.forms[0].nb_third_name_hid.value=document.forms[0].third_name[1].value;
		}
		if(document.forms[0].family_name!=null){
			document.forms[0].nb_family_name_hid.value=document.forms[0].family_name[1].value;
		}
		if(document.forms[0].first_name_oth_lang && document.forms[0].first_name_oth_lang[1]!=null){
			document.forms[0].nb_first_name_hid_loc.value=document.forms[0].first_name_oth_lang[1].value;
		}
		if(document.forms[0].second_name_oth_lang && document.forms[0].second_name_oth_lang[1]!=null){
			document.forms[0].nb_second_name_hid_loc.value=document.forms[0].second_name_oth_lang[1].value;
		}
		if(document.forms[0].third_name_oth_lang && document.forms[0].third_name_oth_lang[1]!=null){
			document.forms[0].nb_third_name_hid_loc.value=document.forms[0].third_name_oth_lang[1].value;
		}
		if(document.forms[0].family_name_oth_lang && document.forms[0].family_name_oth_lang[1]!=null){
			document.forms[0].nb_family_name_hid_loc.value=document.forms[0].family_name_oth_lang[1].value;
		}
		if(function_id_mg=="REGISTER_NEWBORN" && accept_names_for_live_birth_yn=="N"){
			if(document.forms[0].first_name!=null){
				document.forms[0].first_name[1].value="";
			}
			if(document.forms[0].second_name!=null){
				document.forms[0].second_name[1].value="";
			}
			if(document.forms[0].third_name!=null){
				document.forms[0].third_name[1].value="";
			}
			if(document.forms[0].family_name!=null){
				document.forms[0].family_name[1].value="";
			}
			if(document.forms[0].first_name_oth_lang){
				document.forms[0].first_name_oth_lang[1].value="";
			}
			if(document.forms[0].second_name_oth_lang){
				document.forms[0].second_name_oth_lang[1].value="";
			}
			if(document.forms[0].third_name_oth_lang){
				document.forms[0].third_name_oth_lang[1].value="";
			}
			if(document.forms[0].family_name_oth_lang){
				document.forms[0].family_name_oth_lang[1].value="";
			}
		}
		putPatientName('','NewbornDtls');
		putLocalLangPatientName('',"NewbornDtls");
		if(invoked_from != "servlet" && function_id_mg=="REGISTER_NEWBORN" && document.forms[0].nod_type.value!=""){
			enDisCompls(document.forms[0].nod_type.value,"N");
		}
	//}
}

async function viewAuditTrail(){

      
    var dialogTop	= "10px";//65
	var dialogHeight= "300px" ; //20
	var dialogWidth	= "900px" ;	//62
	var status = "no";
	var arguments	= "" ;
	var patient_id = document.forms[0].chd_id.value;
	var queryStr="";

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:" + dialogTop + "; scroll=no; status:" + status;
	retVal = await top.window.showModalDialog("../../eMP/jsp/ViewBirthRegisterAuditTrial.jsp?patient_id="+patient_id,arguments,features);

}

function visibleAudit()
{
	// var chd_id = document.forms[0].chd_id.value;
	var chd_id = document.getElementById('chd_id').value;
	 if (chd_id !='')
	  {
		  parent.frames[1].document.getElementById("auditTrial").style.visibility="visible";
		  //parent.f_query_add_mod.document.getElementById("auditButton").style.visibility="visible";
	  }
	  else 
	  {
		 parent.frames[1].document.getElementById("auditTrial").style.visibility="hidden";
		  //parent.f_query_add_mod.document.getElementById("auditButton").style.visibility="hidden";
	  }
}

function DummyRef(){ 	}




function showPatChartSummary(motherEncounterID,patient_id,contextPath){
	var HTMLVal  = "<html>";
	HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '"+contextPath+"/eCA/jsp/OpenChartWrapper.jsp'>";
	HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + motherEncounterID + "'>";
	HTMLVal  += "<input type='hidden' name='patient_id' id='patient_id' value='" + patient_id + "'>";
	HTMLVal  += "<input type='hidden' name='patient_class' id='patient_class' value='IP'>";
	HTMLVal  += "</form>";
	HTMLVal  += "</html>";
	
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
	parent.parent.messageFrame.document.OpenChartWrapperForm.submit();	
}
/*function showPatChartSummary(motherEncounterID,patient_id,contextPath){
	alert(contextPath)
	var cnt=top.ObjectCollect.cnt;
	var HTML = "<html>";
	
	if(cnt==0){
		HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp'>";
	}else{
		HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../eCA/jsp/OpenChartWrapper.jsp'>";
	}

	HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + motherEncounterID + "'>";
	HTMLVal  += "<input type='hidden' name='patient_id' id='patient_id' value='" + patient_id + "'>";
	HTMLVal  += "<input type='hidden' name='patient_class' id='patient_class' value='IP'>";
	HTMLVal  += "</form>";
	HTMLVal  += "</html>";
	parent.parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
	parent.parent.parent.messageFrame.document.OpenChartWrapperForm.submit();	
}*/
async function stillBirthWindowQuery(){
    var patient_id = document.forms[0].patient_id.value;
	var dialogTop	= "65";
	var dialogHeight= "42" ; 
	var dialogWidth	= "62" ;	
	var status		= "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:" + dialogTop + "; scroll=no; status:" + status;
	retVal =await window.showModalDialog("../../eMP/jsp/MPStillBirthDetailsQuery.jsp?patient_id="+patient_id,arguments,features);
}



async function stillBirthWindow1(){
	//var retVal = 	new String();
	var dialogTop	= "";
	var dialogHeight= "80vh" ; 
	var dialogWidth	= "70vw" ;	
	var status = "no";
	var q_finalized_yn = document.forms[0].q_finalized_yn.value;
	var data_upd_allowed_aft_final_yn= document.forms[0].data_upd_allowed_aft_final_yn.value;
	var arguments	= "" ;
	if(document.forms[0].pract_id_still_birth.value==""){
		document.forms[0].pract_id_still_birth.value=document.forms[0].attend_physician_id.value;
	}
	/*var queryStr="pract_id_still_birth="+document.forms[0].pract_id_still_birth.value+"&attendant_at_birth="+document.forms[0].attendant_at_birth.value+"&autopsy_reqd_yn="+document.forms[0].autopsy_reqd_yn.value+"&mate_cond_main_cod="+encodeURIComponent(document.forms[0].mate_cond_main_cod.value)+"&mate_cond_main_cod_dur="+document.forms[0].mate_cond_main_cod_dur.value+"&mate_cond_oth_cod="+encodeURIComponent(document.forms[0].mate_cond_oth_cod.value)+"&mate_cond_oth_cod_dur="+document.forms[0].mate_cond_oth_cod_dur.value+"&mate_cond_preexist_cod="+encodeURIComponent(document.forms[0].mate_cond_preexist_cod.value)+"&mate_cond_preexist_cod_dur="+document.forms[0].mate_cond_preexist_cod_dur.value+"&oth_rel_mate_cond_rel_cod="+encodeURIComponent(document.forms[0].oth_rel_mate_cond_rel_cod.value)+"&oth_rel_mate_cond_rel_cod_dur="+document.forms[0].oth_rel_mate_cond_rel_cod_dur.value+"&cond_cau_dea_main_cod="+encodeURIComponent(document.forms[0].cond_cau_dea_main_cod.value)+"&cond_cau_dea_main_cod_dur="+document.forms[0].cond_cau_dea_main_cod_dur.value+"&cond_cau_dea_oth_cod="+encodeURIComponent(document.forms[0].cond_cau_dea_oth_cod.value)+"&cond_cau_dea_oth_cod_dur="+document.forms[0].cond_cau_dea_oth_cod_dur.value+"&cond_cau_dea_preexist_cod="+encodeURIComponent(document.forms[0].cond_cau_dea_preexist_cod.value)+"&cond_cau_dea_preexist_cod_dur="+document.forms[0].cond_cau_dea_preexist_cod_dur.value+"&rel_cond_cau_dea_rel_cod="+encodeURIComponent(document.forms[0].rel_cond_cau_dea_rel_cod.value)+"&rel_cond_cau_dea_rel_cod_dur="+document.forms[0].rel_cond_cau_dea_rel_cod_dur.value+"&q_finalized_yn="+document.forms[0].q_finalized_yn.value+"&data_upd_allowed_aft_final_yn="+document.forms[0].data_upd_allowed_aft_final_yn.value;*/
				var mate_cond_main_cod				=	document.forms[0].mate_cond_main_cod.value;
				mate_cond_main_cod			=	replaceAll(mate_cond_main_cod,'<','&lt;');
				var mate_cond_oth_cod				=	document.forms[0].mate_cond_oth_cod.value;
				mate_cond_oth_cod				=	replaceAll(mate_cond_oth_cod,'<','&lt;');
				var mate_cond_preexist_cod		=	document.forms[0].mate_cond_preexist_cod.value;
				mate_cond_preexist_cod		=	replaceAll(mate_cond_preexist_cod,'<','&lt;');
				var oth_rel_mate_cond_rel_cod	=	document.forms[0].oth_rel_mate_cond_rel_cod.value;
				oth_rel_mate_cond_rel_cod	 =	replaceAll(oth_rel_mate_cond_rel_cod,'<','&lt;');
				var cond_cau_dea_main_cod		=	document.forms[0].cond_cau_dea_main_cod.value;
				cond_cau_dea_main_cod		=	replaceAll(cond_cau_dea_main_cod,'<','&lt;');
				var cond_cau_dea_oth_cod			=	document.forms[0].cond_cau_dea_oth_cod.value;
				cond_cau_dea_oth_cod		=	replaceAll(cond_cau_dea_oth_cod,'<','&lt;');
				var cond_cau_dea_preexist_cod	=	document.forms[0].cond_cau_dea_preexist_cod.value;
				cond_cau_dea_preexist_cod	=	replaceAll(cond_cau_dea_preexist_cod,'<','&lt;');
				var rel_cond_cau_dea_rel_cod		=	document.forms[0].rel_cond_cau_dea_rel_cod.value;
				rel_cond_cau_dea_rel_cod	=	replaceAll(rel_cond_cau_dea_rel_cod,'<','&lt;');

				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr += " pract_id_still_birth=\"" +document.forms[0].pract_id_still_birth.value+ "\"";
				xmlStr += " attendant_at_birth=\"" +document.forms[0].attendant_at_birth.value+ "\"";
				xmlStr += " autopsy_reqd_yn=\"" +document.forms[0].autopsy_reqd_yn.value+ "\"";
				xmlStr += " mate_cond_main_cod=\"" +mate_cond_main_cod+ "\"";
				xmlStr += " mate_cond_main_cod_dur=\"" +document.forms[0].mate_cond_main_cod_dur.value+ "\"";
				xmlStr += " mate_cond_oth_cod=\"" +mate_cond_oth_cod+ "\"";
				xmlStr += " mate_cond_oth_cod_dur=\"" +document.forms[0].mate_cond_oth_cod_dur.value+ "\"";
				xmlStr += " mate_cond_preexist_cod=\"" +mate_cond_preexist_cod+ "\"";
				xmlStr += " mate_cond_preexist_cod_dur=\"" +document.forms[0].mate_cond_preexist_cod_dur.value+ "\"";
				xmlStr += " oth_rel_mate_cond_rel_cod=\"" +oth_rel_mate_cond_rel_cod+ "\"";
				xmlStr += " oth_rel_mate_cond_rel_cod_dur=\"" +document.forms[0].oth_rel_mate_cond_rel_cod_dur.value+ "\"";
				xmlStr += " cond_cau_dea_main_cod=\"" +cond_cau_dea_main_cod+ "\"";
				xmlStr += " cond_cau_dea_main_cod_dur=\"" +document.forms[0].cond_cau_dea_main_cod_dur.value+ "\"";
				xmlStr += " cond_cau_dea_oth_cod=\"" +cond_cau_dea_oth_cod+ "\"";
				xmlStr += " cond_cau_dea_oth_cod_dur=\"" +document.forms[0].cond_cau_dea_oth_cod_dur.value+ "\"";
				xmlStr += " cond_cau_dea_preexist_cod=\"" +cond_cau_dea_preexist_cod+ "\"";
				xmlStr += " cond_cau_dea_preexist_cod_dur=\"" +document.forms[0].cond_cau_dea_preexist_cod_dur.value+ "\"";
				xmlStr += " rel_cond_cau_dea_rel_cod=\"" +rel_cond_cau_dea_rel_cod+ "\"";
				xmlStr += " rel_cond_cau_dea_rel_cod_dur=\"" +document.forms[0].rel_cond_cau_dea_rel_cod_dur.value+ "\"";
				xmlStr += " q_finalized_yn=\"" +document.forms[0].q_finalized_yn.value+ "\"";
				xmlStr += " data_upd_allowed_aft_final_yn=\"" +document.forms[0].data_upd_allowed_aft_final_yn.value+ "\"";
				xmlStr += " function_name='NewBorn'";
				xmlStr += " process_id='234'";
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eMP/jsp/ServerValidation.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
//				var getVal=eval(responseText);	
		if(responseText=="MAP_UPDATED"){
				var values="dummy=Y";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:" + dialogTop + ";scroll=no; status:" + status;
				retVal = await top.window.showModalDialog("../../eMP/jsp/MPStillBirthDetailsMain.jsp?"+values,arguments,features);
			
				if(retVal){
					var ret_array = retVal.split("^");
					if(ret_array[0]=='@') ret_array[0]='';
					if(ret_array[1]=='@') ret_array[1]='';
					if(ret_array[2]!='Y') ret_array[2]='N';
					if(ret_array[3]=='@') ret_array[3]='';
					if(ret_array[4]=='@') ret_array[4]='';
					if(ret_array[5]=='@') ret_array[5]='';
					if(ret_array[6]=='@') ret_array[6]='';
					if(ret_array[7]=='@') ret_array[7]='';
					if(ret_array[8]=='@') ret_array[8]='';
					if(ret_array[9]=='@') ret_array[9]='';
					if(ret_array[10]=='@') ret_array[10]='';
					if(ret_array[11]=='@') ret_array[11]='';
					if(ret_array[12]=='@') ret_array[12]='';
					if(ret_array[13]=='@') ret_array[13]='';
					if(ret_array[14]=='@') ret_array[14]='';
					if(ret_array[15]=='@') ret_array[15]='';
					if(ret_array[16]=='@') ret_array[16]='';
					if(ret_array[17]=='@') ret_array[17]='';
					if(ret_array[18]=='@') ret_array[18]='';
					document.forms[0].pract_id_still_birth.value=ret_array[0];
					document.forms[0].attendant_at_birth.value=ret_array[1];
					document.forms[0].autopsy_reqd_yn.value=ret_array[2];
					document.forms[0].mate_cond_main_cod.value=ret_array[3];
					document.forms[0].mate_cond_main_cod_dur.value=ret_array[4];
					document.forms[0].mate_cond_oth_cod.value=ret_array[5];
					document.forms[0].mate_cond_oth_cod_dur.value=ret_array[6];
					document.forms[0].mate_cond_preexist_cod.value=ret_array[7];
					document.forms[0].mate_cond_preexist_cod_dur.value=ret_array[8];
					document.forms[0].oth_rel_mate_cond_rel_cod.value=ret_array[9];
					document.forms[0].oth_rel_mate_cond_rel_cod_dur.value=ret_array[10];
					document.forms[0].cond_cau_dea_main_cod.value=ret_array[11];
					document.forms[0].cond_cau_dea_main_cod_dur.value=ret_array[12];
					document.forms[0].cond_cau_dea_oth_cod.value=ret_array[13];
					document.forms[0].cond_cau_dea_oth_cod_dur.value=ret_array[14];
					document.forms[0].cond_cau_dea_preexist_cod.value=ret_array[15];
					document.forms[0].cond_cau_dea_preexist_cod_dur.value=ret_array[16];
					document.forms[0].rel_cond_cau_dea_rel_cod.value=ret_array[17];
					document.forms[0].rel_cond_cau_dea_rel_cod_dur.value=ret_array[18];
				}
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr += " function_name='NewBorn'";
				xmlStr += " process_id='123'";
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eMP/jsp/ServerValidation.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
	}
}

function replaceAll(strChk, strFind, strReplace) {
  var strOut = strChk;
  while (strOut.indexOf(strFind) > -1) {
    strOut = strOut.replace(strFind, strReplace);
  }
  return strOut;
}

//Added by Jeyachitra ML-MMOH-CRF-1759.1 recommitting
async function viewMenstrualHistoryDtl(option_id,mother_patient_id, patient_gender, patient_age, function_id,module_id)
{
	var calledForm = "PAS_TRANSCATION_INVOKING";
	var dialogTop	= "65";
	var dialogHeight= "90"; 
	var dialogWidth	= "90";	
	var status		= "no";
	var arguments	= "";
	var finalize_yn	= document.getElementById('finalize_yn').value;
	var multibirthvalue	= document.getElementById('multibirthvalue').value;
	var finalized_prev	= document.getElementById('finalized_prev').value;
	var number_of_births_recorded = document.getElementById('number_of_births_recorded').value;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:" + dialogTop + "; scroll=no; status:" + status;
	retVal =await window.showModalDialog("../../eCA/jsp/CAMenstrualHistDtlPatient.jsp?option_id="+option_id+"&patient_id="+mother_patient_id+"&Sex="+patient_gender+"&Age="+patient_age+"&encounter_id="+function_id+"&module_id="+module_id+"&called_form="+calledForm+"&finalize_yn="+finalize_yn+"&multibirthvalue="+multibirthvalue+"&finalized_prev="+finalized_prev,arguments,features);
	updateMensHistDtl(mother_patient_id,function_id,module_id,finalize_yn);
}
//Added by Ajay Hatwate for ML-MMOH-CRF-1759.1 recommitted
function updateMensHistDtl(mother_patient_id,function_id,module_id,finalize_yn){
	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH mother_patient_id=\""+mother_patient_id+"\"  action='ValidateMensHistDtl' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../jsp/MPIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	var returnVal = trimString(responseText);
	var tit=getLabel("eMP.ViewModifyMenstrualHistoryDetails.label","MP");
	var Week=getLabel("Common.weeks.label","COMMON");
		var anchor = document.getElementById('mens_hist_dtl_anchor');
		var anchor_mand_img = document.getElementById('mens_hist_dtl_anchor_mand_img');
		var gest_day_value_label = document.getElementById('gest_day_value_label');
		var gest_week_value_label = document.getElementById('gest_week_value_label');
	if(returnVal != "0"){
		var ret_array = returnVal.split("_"); 
		if(finalize_yn == "Y"){
			anchor.innerHTML = getLabel("eMP.ViewMenstrualHistoryDetails.label","MP")
		}else{
		anchor.innerHTML = tit;	
		}
		gest_day_value_label.innerHTML = ret_array[0];	
		var week_count = ret_array[1];
		gest_week_value_label.innerHTML = week_count+" "+Week;	
		document.getElementById('invoke_mens_hist_mand').value="N";
		document.getElementById('gestn_day_from_lmp').value=week_count;
	}else{
		tit = getLabel("eMP.RecordMenstrualHistoryDetails.label","MP");
		anchor.innerHTML = tit + " <img id=\"mens_hist_dtl_anchor_mand_img\" src=\"../../eCommon/images/mandatory.gif\" align=center/>"
		gest_day_value_label.innerHTML = " ";	
		gest_week_value_label.innerHTML = " "+Week;	
		document.getElementById('invoke_mens_hist_mand').value="Y";
		document.getElementById('gestn_day_from_lmp').value="";
	}
}

