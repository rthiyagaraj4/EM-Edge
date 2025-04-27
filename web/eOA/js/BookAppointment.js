/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var isNumber = new Boolean();
var LocalErrors = new String();
var from;
var patIdValidation='N';
function clear_func()
{

	parent.frames[2].document.forms[0].previous_encounter.disabled=true;

	if(document.getElementById("other_id1")!=null)

	document.getElementById("other_id1").style.visibility='hidden';

	if(parent.frames[2].document.forms[0].recurring)
	{
		parent.frames[2].document.forms[0].recurring.disabled=true;
	}

	if(parent.frames[0].document.forms[0].source !=null)
	{
		if(parent.frames[0].document.forms[0].allow_referral_yn.value =="Y")
		{
			parent.f_query_add_mod.document.Bkappt_form.source.readOnly=false;
			parent.f_query_add_mod.document.Bkappt_form.source.disabled=false;
			parent.f_query_add_mod.document.Bkappt_form.search1.disabled=false;
			parent.f_query_add_mod.document.Bkappt_form.search.disabled=false;
		}
	}	

	if  (!(parent.frames[0].document.forms[0].allow_referral_yn.value =="Y" && 
			parent.frames[0].document.forms[0].allow_non_referral_yn.value =="N"))
	{
		if(parent.frames[0].document.forms[0].national_id !=null)
		  parent.f_query_add_mod.document.Bkappt_form.national_id.readOnly=false;


		if(parent.frames[0].document.forms[0].patient_id !=null){
		  parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=false;
		  parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=false;}
	

				
		if(parent.frames[0].document.forms[0].name_prefix !=null)
		parent.f_query_add_mod.document.Bkappt_form.name_prefix.disabled=false;

		if(parent.frames[0].document.forms[0].first_name !=null)
		parent.f_query_add_mod.document.Bkappt_form.first_name.readOnly=false;
				
		if(parent.frames[0].document.forms[0].second_name !=null)
		parent.f_query_add_mod.document.Bkappt_form.second_name.readOnly=false;
				
		if(parent.frames[0].document.forms[0].third_name !=null)
		parent.f_query_add_mod.document.Bkappt_form.third_name.readOnly=false;			

		if(parent.frames[0].document.forms[0].family_name !=null)
		parent.f_query_add_mod.document.Bkappt_form.family_name.readOnly=false;			
			
		if(parent.frames[0].document.forms[0].name_suffix !=null)
		parent.f_query_add_mod.document.Bkappt_form.name_suffix.disabled=false;
				
		if(parent.frames[0].document.forms[0].sex !=null)
			parent.f_query_add_mod.document.Bkappt_form.sex.disabled=false;			

		if(parent.frames[0].document.forms[0].nationality!=null)
		parent.f_query_add_mod.document.Bkappt_form.nationality.disabled=false;

		if(parent.frames[0].document.forms[0].pat_cat!=null)
		parent.f_query_add_mod.document.Bkappt_form.pat_cat.disabled=false;	


		parent.f_query_add_mod.document.Bkappt_form.b_age.readOnly=false;  
		parent.f_query_add_mod.document.Bkappt_form.b_months.readOnly=false;
		parent.f_query_add_mod.document.Bkappt_form.b_days.readOnly=false;
		parent.f_query_add_mod.document.Bkappt_form.date_of_birth.readOnly=false;
		parent.f_query_add_mod.document.getElementById("dob").disabled=false;
 
	}
	if(document.getElementById("other_id1")!=null)
	document.getElementById("other_id1").style.visibility='hidden';


		loadEthnicSubGroup();
}

function clear_fun_all(xVal)
{		
		 parent.frames[2].document.forms[0].previous_encounter.disabled=true;
		 parent.frames[2].document.forms[0].Insupd.disabled=false;

		if(document.getElementById("other_id1")!=null)
		document.getElementById("other_id1").style.visibility='hidden';


		if(parent.frames[2].document.forms[0].recurring)
			parent.frames[2].document.forms[0].recurring.disabled=true;
		
		if(parent.frames[0].document.forms[0].source !=null)
		{
		  if(parent.frames[0].document.forms[0].allow_referral_yn.value =="Y" && 
			parent.frames[0].document.forms[0].allow_non_referral_yn.value =="Y")
		  {
			  parent.f_query_add_mod.document.Bkappt_form.source.readOnly=false;
			  parent.f_query_add_mod.document.Bkappt_form.source.disabled=false;
			  parent.f_query_add_mod.document.Bkappt_form.search1.disabled=false;
			  parent.f_query_add_mod.document.Bkappt_form.search.disabled=false;
		  }else if(parent.frames[0].document.forms[0].allow_referral_yn.value =="Y" && 
			parent.frames[0].document.forms[0].allow_non_referral_yn.value =="N")
		  {
			  parent.f_query_add_mod.document.Bkappt_form.source.disabled=true;
			  parent.f_query_add_mod.document.Bkappt_form.search1.disabled=true;
			  parent.f_query_add_mod.document.Bkappt_form.search.disabled=false;
		  }
		}	

		if (!(parent.frames[0].document.forms[0].allow_referral_yn.value =="Y" && 
			parent.frames[0].document.forms[0].allow_non_referral_yn.value =="N"))
		{
			if(parent.frames[0].document.forms[0].national_id !=null)
			  parent.f_query_add_mod.document.Bkappt_form.national_id.readOnly=false;

			if(parent.frames[0].document.forms[0].patient_id !=null){
			  parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=false;
			  parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=false;}
			


			if(parent.frames[0].document.forms[0].name_prefix !=null)
			parent.f_query_add_mod.document.Bkappt_form.name_prefix.disabled=false;

			if(parent.frames[0].document.forms[0].first_name !=null)
			parent.f_query_add_mod.document.Bkappt_form.first_name.readOnly=false;

			if(parent.frames[0].document.forms[0].bf!=null)
				parent.frames[0].document.forms[0].bf.disabled=false;

			if(parent.frames[0].document.forms[0].pat_names_in_oth_lang_yn.value=="Y" && parent.frames[0].document.forms[0].bfo!=null)
				parent.frames[0].document.forms[0].bfo.disabled=false;
					
			if(parent.frames[0].document.forms[0].second_name !=null)
			parent.f_query_add_mod.document.Bkappt_form.second_name.readOnly=false;

			if(parent.frames[0].document.forms[0].bs!=null)
				parent.frames[0].document.forms[0].bs.disabled=false;

			if(parent.frames[0].document.forms[0].pat_names_in_oth_lang_yn.value=="Y" && parent.frames[0].document.forms[0].bso!=null)
				parent.frames[0].document.forms[0].bso.disabled=false;
					
			if(parent.frames[0].document.forms[0].third_name !=null)
			parent.f_query_add_mod.document.Bkappt_form.third_name.readOnly=false;

			if(parent.frames[0].document.forms[0].bt!=null)
				parent.frames[0].document.forms[0].bt.disabled=false;

			if(parent.frames[0].document.forms[0].pat_names_in_oth_lang_yn.value=="Y" && parent.frames[0].document.forms[0].bto!=null)
				parent.frames[0].document.forms[0].bto.disabled=false;

			if(parent.frames[0].document.forms[0].family_name !=null)
			parent.f_query_add_mod.document.Bkappt_form.family_name.readOnly=false;

			if(parent.frames[0].document.forms[0].bfam!=null)
				parent.frames[0].document.forms[0].bfam.disabled=false;

			if(parent.frames[0].document.forms[0].pat_names_in_oth_lang_yn.value=="Y" && (parent.frames[0].document.forms[0].bfo!=null && parent.frames[0].document.forms[0].bfamo))
				parent.frames[0].document.forms[0].bfamo.disabled=false;

			if(parent.frames[0].document.forms[0].name_suffix !=null)
			parent.f_query_add_mod.document.Bkappt_form.name_suffix.disabled=false;
					
			if(parent.frames[0].document.forms[0].sex !=null)
				parent.f_query_add_mod.document.Bkappt_form.sex.disabled=true;

			if(parent.frames[0].document.forms[0].nationality!=null)
			parent.f_query_add_mod.document.Bkappt_form.nationality.disabled=false;

			if(parent.frames[0].document.forms[0].pat_cat!=null)
			parent.f_query_add_mod.document.Bkappt_form.pat_cat.disabled=false;	


			parent.f_query_add_mod.document.Bkappt_form.b_age.readOnly=false;  
			parent.f_query_add_mod.document.Bkappt_form.b_months.readOnly=false;
			parent.f_query_add_mod.document.Bkappt_form.b_days.readOnly=false;
			parent.f_query_add_mod.document.Bkappt_form.date_of_birth.readOnly=false;
			parent.f_query_add_mod.document.getElementById("dob").disabled=false;

		}

	if(parent.frames[0].document.forms[0].patient_id.value =="" && parent.frames[2].document.forms[0].no_show_appt)
	{
		parent.frames[2].document.forms[0].no_show_appt.style.visibility='hidden';
	}
}


	var max_dur_Array = new Array();
	var vis_code_Array = new Array(); 	
	var max_appt_slots_Array = new Array();
function field(){ 
	if(document.forms[0].visit_type_cnt){
		document.getElementById("prior").style.visibility='hidden';
		if (document.forms[0].ip_bkgs.value!=0||document.forms[0].maxrecord.value!=0 ){
			parent.ButtonFrame.document.getElementById("other_id1").style.visibility='visible';		
		}else{
			parent.ButtonFrame.document.getElementById("other_id1").style.visibility='hidden';		
		}
		parent.f_query_add_mod.document.Bkappt_form.clinic_name.readOnly=true;
		parent.f_query_add_mod.document.Bkappt_form.practitioner_name.readOnly=true;
		parent.f_query_add_mod.document.Bkappt_form.appt_date.readOnly=true;

		if(document.getElementById("overbooked").value =="Y" || parent.f_query_add_mod.document.Bkappt_form.time_table_type.value!="3") {
			parent.f_query_add_mod.document.Bkappt_form.From_timeval.readOnly=true;
			parent.f_query_add_mod.document.Bkappt_form.To_timeval.readOnly=true;
		}	
		if(parent.f_query_add_mod.document.Bkappt_form.wtListControl.value=='B'){
			parent.f_query_add_mod.document.Bkappt_form.hddPat_id.value=parent.f_query_add_mod.document.Bkappt_form.patient_id.value;
			parent.f_query_add_mod.document.Bkappt_form.ca_patient_id_new.value=parent.f_query_add_mod.document.Bkappt_form.patient_id.value;
		}		
		if(parent.frames[0].document.forms[0].CallingMode.value=="" || parent.frames[0].document.forms[0].CallingMode.value=="N"){
			if(parent.f_query_add_mod.document.Bkappt_form.patient_id.value!="" || (parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="N" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N")){
				if(parent.frames[0].document.forms[0].patient_id !=null){ 
					parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=true;	
					parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
					disable_conrolls();
				}
			}else if(parent.f_query_add_mod.document.Bkappt_form.patient_id.value!="" || (parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" )){
				if(parent.frames[0].document.forms[0].patient_id !=null){ 
					parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=true;
					parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
					disable_conrolls();
				}
			}

		}
		/*if (parent.f_query_add_mod.document.Bkappt_form.patient_id.value!="" || parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N")
		{
				parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
				
		}*/
		var  hddPatid=parent.frames[0].document.forms[0].hddPat_id.value;
		if(hddPatid!=''){ 
			if(parent.frames[0].document.forms[0].CallingMode.value=='OP'){
				var wait_list_num=parent.f_query_add_mod.document.Bkappt_form.wait_list_num.value	
				if(wait_list_num==""){
					parent.frames[0].document.forms[0].patient_id.value=hddPatid;
				}
				parent.frames[0].document.forms[0].patient_id.disabled=true;
				parent.frames[0].document.forms[0].search.disabled=true;
				parent.frames[0].document.forms[0].search1.disabled=true;
				parent.frames[0].document.forms[0].pref_date.disabled=true;
				parent.frames[0].document.forms[0].priorty.disabled=true;
				parent.frames[0].document.forms[0].dob1.disabled=true;
				var ref_id=document.forms[0].hdd_referal.value;
				var p_speciality_code=document.forms[0].speciality_code.value;
				if(ref_id !='N'){ 
					parent.frames[0].document.forms[0].patient_id.value=hddPatid;
					if(parent.frames[0].document.forms[0].source.value!=""){
						validpatient_refral(parent.frames[0].document.forms[0].source,'nonmodel');
					}else{
						patIdValidation='Y';
						validatePatient(parent.frames[0].document.forms[0].patient_id);
					}
					parent.frames[0].document.forms[0].patient_id.disabled=true;
					parent.frames[0].document.forms[0].search.disabled=true;
				//	parent.frames[0].document.forms[0].search.disabled=true;
				//	parent.frames[0].document.forms[0].source.disabled=true;
				}else{	//if(wait_list_num =="" && document.forms[0].waitListNo.value=="")
				/*Below Lines Modified by Rameswar Against SKR-SCF-1099 on 3rd Sept 2015*/
					if(wait_list_num =="" && document.forms[0].waitListNo.value==""&& parent.f_query_add_mod.document.Bkappt_form.from_page.value !="modifyappt"&&parent.frames[0].document.forms[0].CallingMode.value!='OP'){ 
						parent.frames[0].document.forms[0].patient_id.value=hddPatid;	
						patIdValidation='Y';						
						validatePatient(parent.frames[0].document.forms[0].patient_id)
						parent.frames[0].document.forms[0].patient_id.disabled=true;
						parent.frames[0].document.forms[0].search.disabled=true;
					}
				}
			}else{
				if(parent.frames[0].document.forms[0].CallingMode.value!='MR' && parent.frames[0].document.forms[0].from_page.value!="modifyappt"){
					if(parent.frames[0].document.forms[0].Forced.value!='Y' && parent.frames[0].document.forms[0].CallingMode.value=='N' && parent.frames[0].document.forms[0].CallingMode1.value!='CA' && parent.frames[0].document.forms[0].ca_patient_id_new.value==""){ 
						var error1=getMessage("CONTINUE_WITH_PATIENT_YN","OA");
						error1=error1.replace('?', hddPatid);
						if(window.confirm(error1)){ 
							parent.frames[0].document.forms[0].MaxcancelAlert.value = "Y"; 	//fix for regression issue						
							parent.frames[0].document.forms[0].patient_id.value=hddPatid;
							if(parent.frames[0].document.forms[0].source.value!=""){
								validpatient_refral(parent.frames[0].document.forms[0].source,'nonmodel');
							}else{
								patIdValidation='Y';
								validatePatient(parent.frames[0].document.forms[0].patient_id);
							}
							parent.frames[0].document.forms[0].patient_id.disabled=true;
							parent.frames[0].document.forms[0].search.disabled=true;
							
						}else{							
							parent.frames[0].document.forms[0].search.disabled=false;
						}
					}else if(parent.frames[0].document.forms[0].CallingMode.value=='CA'){
						parent.frames[0].document.forms[0].patient_id.value=hddPatid;
						if(parent.frames[0].document.forms[0].source.value!=""){
							validpatient_refral(parent.frames[0].document.forms[0].source,'nonmodel');
						}else{
							patIdValidation='Y';
							validatePatient(parent.frames[0].document.forms[0].patient_id);
						}
						parent.frames[0].document.forms[0].patient_id.disabled=true;
						parent.frames[0].document.forms[0].search.disabled=true;
						parent.frames[0].document.forms[0].source.disabled=true;
						parent.frames[0].document.forms[0].search1.disabled=true;
					}else if(parent.frames[0].document.forms[0].CallingMode1.value=='CA' && parent.frames[0].document.forms[0].ca_patient_id_new.value ==""){
						var error1=getMessage("CONTINUE_WITH_PATIENT_YN","OA");
						error1=error1.replace('?', hddPatid);
						if(window.confirm(error1)){ 
							parent.frames[0].document.forms[0].MaxcancelAlert.value = "Y"; 	//fix for regression issue
							var ca_patient_id_new=parent.frames[0].document.forms[0].ca_patient_id_new.value
							parent.frames[0].document.forms[0].patient_id.value=hddPatid;
							if(parent.frames[0].document.forms[0].source.value!=""){
								validpatient_refral(parent.frames[0].document.forms[0].source,'nonmodel');
							}else{
								patIdValidation='Y';
								validatePatient(parent.frames[0].document.forms[0].patient_id);
							}
							parent.frames[0].document.forms[0].patient_id.disabled=true;
							parent.frames[0].document.forms[0].search.disabled=true;
						}
						else{							
							parent.frames[0].document.forms[0].search.disabled=false;//Added by Rameswar on 25th June 2015 Against SKR-SCF-1088 IN055576
						}
					}else if(parent.frames[0].document.forms[0].CallingMode1.value=='CA' && parent.frames[0].document.forms[0].ca_patient_id_new.value !=""){
						parent.frames[0].document.forms[0].patient_id.value=hddPatid;
						if(parent.frames[0].document.forms[0].source.value!=""){
							validpatient_refral(parent.frames[0].document.forms[0].source,'nonmodel');
						}else{
							patIdValidation='Y';
							validatePatient(parent.frames[0].document.forms[0].patient_id);
						}
						parent.frames[0].document.forms[0].patient_id.disabled=true;
						parent.frames[0].document.forms[0].search.disabled=true;
						parent.document.frames[2].document.forms[0].clear.disabled=true;
					}else if(parent.frames[0].document.forms[0].CallingMode.value=='OR'){
						parent.frames[0].document.forms[0].patient_id.value=hddPatid;
						if(parent.frames[0].document.forms[0].source.value!=""){
							validpatient_refral(parent.frames[0].document.forms[0].source,'nonmodel');
						}else{
							patIdValidation='Y';
							validatePatient(parent.frames[0].document.forms[0].patient_id);
						}
						parent.frames[0].document.forms[0].patient_id.disabled=true;
						parent.frames[0].document.forms[0].search.disabled=true;
						parent.frames[0].document.forms[0].source.disabled=true;
						parent.frames[0].document.forms[0].search1.disabled=true;
						parent.frames[0].document.forms[0].pref_date.disabled=true;
						parent.frames[0].document.forms[0].priorty.disabled=true;
						parent.frames[0].document.forms[0].dob1.disabled=true;
					}else if(parent.frames[0].document.forms[0].ca_patient_id_new.value !=""){
						if(parent.frames[0].document.forms[0].CallingMode.value=='RSCAPPT'){
							var xmlDoc = ""
							var xmlHttp = new XMLHttpRequest()
							xmlStr ="<root><SEARCH steps='OA_Modify_Appt' apptrefno=\""+parent.frames[0].document.forms[0].canldapptrefno.value+"\" callingMode=\""+parent.frames[0].document.forms[0].CallingMode.value+"\" clinic_id=\""+parent.frames[0].document.forms[0].clinic_code.value+"\"/></root>"
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
							xmlHttp.open("POST","../../eOA/jsp/getbookapptvalue.jsp",false)
							xmlHttp.send(xmlDoc);
							responseText=xmlHttp.responseText;
							
							responseText = trimString(responseText);
							
							eval(responseText)
							validateFirstVisit(parent.frames[0].document.forms[0].visit_type_short_desc);
							//setToTime(parent.frames[0].document.forms[0].time_table_type.value,parent.frames[0].document.forms[0].totime_value.value)
						}else{
							parent.frames[0].document.forms[0].patient_id.value=hddPatid;
							if(parent.frames[0].document.forms[0].source.value!=""){
								validpatient_refral(parent.frames[0].document.forms[0].source,'nonmodel');
							}else{
								patIdValidation='Y';
								validatePatient(parent.frames[0].document.forms[0].patient_id);
							}
							parent.frames[0].document.forms[0].patient_id.disabled=true;
							parent.frames[0].document.forms[0].search.disabled=true;
							parent.document.frames[2].document.forms[0].clear.disabled=true;
						}
					}
				}
			}
			// commented by Sudhakar as "validatePatient" is calling twice when booking appointment through CA  with order
			/*if(parent.frames[0].document.forms[0].CallingMode.value=='OR'){
				parent.frames[0].document.forms[0].patient_id.value=hddPatid;
				validatePatient(parent.frames[0].document.forms[0].patient_id)
				parent.frames[0].document.forms[0].patient_id.disabled=true;
				parent.frames[0].document.forms[0].search.disabled=true;
				parent.frames[0].document.forms[0].source.disabled=true;
				parent.frames[0].document.forms[0].search1.disabled=true;
				parent.frames[0].document.forms[0].pref_date.disabled=true;
				parent.frames[0].document.forms[0].priorty.disabled=true;
				parent.frames[0].document.getElementById("dob1").disabled=true;
			}*/
		}
		if(parent.frames[0].document.forms[0].hddPat_id_new.value !="" &&   parent.frames[0].document.forms[0].from_page.value=="modifyappt" && parent.frames[0].document.forms[0].referral_id.value==""){
			parent.frames[0].document.forms[0].patient_id.value=parent.frames[0].document.forms[0].hddPat_id_new.value;
			//validatePatient(parent.frames[0].document.forms[0].patient_id)
			parent.frames[0].document.forms[0].patient_id.disabled=true;
			parent.frames[0].document.forms[0].search.disabled=true;
			// The below lines are commented for PMG20089-CRF-0569 IN008823 by Suresh on 28.01.2010
			//parent.frames[0].document.forms[0].source.readonly=true;
			//parent.frames[0].document.forms[0].search1.disabled=true;
			parent.frames[0].document.forms[0].pref_date.disabled=true;
			parent.frames[0].document.forms[0].priorty.disabled=true;
			parent.frames[0].document.forms[0].dob1.disabled=true;
			if(parent.frames[0].document.forms[0].name_prefix_oth_lang)
			parent.frames[0].document.forms[0].name_prefix_oth_lang.disabled=true;
			parent.frames[0].document.forms[0].visit_type_short_desc.disabled=true;
			parent.frames[0].document.forms[0].ethnic_group.disabled=true;

			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH steps='OA_Modify_Appt' apptrefno=\""+parent.frames[0].document.forms[0].apptrefno.value+"\"/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eOA/jsp/getbookapptvalue.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText)
			//enable_conrolls();
			// The below lines are commented for PMG20089-CRF-0569 IN008823 by Suresh on 28.01.2010
			//parent.f_query_add_mod.document.Bkappt_form.source.disabled=true;
			//parent.f_query_add_mod.document.Bkappt_form.search1.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.pref_date.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.priorty.disabled=true;
		}

		if(parent.frames[0].document.forms[0].hddPat_id_new.value=="" && parent.frames[0].document.forms[0].from_page.value=="modifyappt" && document.forms[0].referral_id.value==""){
			parent.frames[0].document.forms[0].patient_id.disabled=true;
			parent.frames[0].document.forms[0].search.disabled=true;
		//	parent.frames[0].document.forms[0].source.disabled=true;
		//	parent.frames[0].document.forms[0].search1.disabled=true;
			parent.frames[0].document.forms[0].pref_date.disabled=true;
			parent.frames[0].document.forms[0].priorty.disabled=true;
			parent.frames[0].document.forms[0].dob1.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.pref_date.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.priorty.disabled=true;
			parent.f_query_add_mod.document.forms[0].dob1.disabled=true;
			if(parent.frames[0].document.forms[0].name_prefix_oth_lang)
			parent.frames[0].document.forms[0].name_prefix_oth_lang.disabled=true;
			parent.frames[0].document.forms[0].visit_type_short_desc.disabled=true;
			parent.frames[0].document.forms[0].nationality_id.disabled=false;
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH steps='OA_Modify_Appt' apptrefno=\""+parent.frames[0].document.forms[0].apptrefno.value+"\"/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eOA/jsp/getbookapptvalue.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText)
			enable_conrolls();
		//	parent.f_query_add_mod.document.Bkappt_form.source.disabled=true;
		//	parent.f_query_add_mod.document.Bkappt_form.search1.disabled=true;
		}
		if(document.forms[0].from_page.value=="modifyappt" &&  document.forms[0].referral_id.value!=""){ 				
			if( parent.frames[0].document.forms[0].hddPat_id_new.value=="" ||           parent.frames[0].document.forms[0].hddPat_id_new.value == "dummy_patinetID" ) {
				document.getElementById("source").disabled=true;
				document.getElementById("search1").disabled=true;				
			} else{						
					document.forms[0].source.disabled=false;					
					document.forms[0].search1.disabled=false;
			}
			document.forms[0].source.value=document.forms[0].referral_id.value;
		//	document.getElementById("search1").focus();
			//document.forms[0].reason.focus();
		//	if(document.forms[0].search1.disabled) 
		//		document.forms[0].search1.disabled=false;
		//	document.getElementById("search1").focus();
		//	document.getElementById("search1").disabled=true;
			
			var referral_id = document.forms[0].referral_id.value;
			var patient_id=parent.frames[0].document.forms[0].hddPat_id_new.value;	
			
			var clinic_code=parent.frames[0].document.forms[0].clinic_code.value;
			var flag=true;
			if(patient_id !=""){
				var xmlDoc= "" ;
				var xmlHttp= new XMLHttpRequest() ;
				xmlStr	="<root><SEARCH " ;
				xmlStr += "ref_id=\""+referral_id+"\"  ca_patient_id=\""+patient_id+"\" clinic_code=\""+clinic_code+"\" steps='validate_CA_referral'";
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");				
				xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				eval(responseText);	
				if(flag!="1"){
					alert(getMessage("MISMATCH_REFERRALID_PATIENTID","COMMON"));
					parent.frames[0].document.forms[0].source.value="";
					flag=false;
				}
			}
		//	parent.frames[0].document.forms[0].source.disabled=true;
			parent.frames[0].document.forms[0].visit_type_short_desc.disabled=true;
			if(flag==true){
				var calledFor="";
				var apptrefno="";
				if(parent.f_query_add_mod.document.Bkappt_form.from_page.value !="modifyappt"){
					calledFor="Referal";
				}else{
					calledFor="modify_appt";
					apptrefno=parent.f_query_add_mod.document.Bkappt_form.apptrefno.value;
				}
				var p_speciality_code=parent.f_query_add_mod.document.Bkappt_form.speciality_code.value;
				var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()
				xmlStr ="<root><SEARCH alcn_criteria_pop=\""+parent.f_query_add_mod.document.Bkappt_form.alcn_criteria.value+"\" ref_id=\""+parent.f_query_add_mod.document.Bkappt_form.source.value+"\" service_code=\""+parent.f_query_add_mod.document.Bkappt_form.service_code.value+"\" clinic_code=\""+parent.f_query_add_mod.document.Bkappt_form.clinic_code.value+"\" p_speciality_code=\""+p_speciality_code+"\" pract_id=\""+parent.f_query_add_mod.document.Bkappt_form.pract_id.value+"\" apptrefno=\""+apptrefno+"\" from_page=\""+parent.f_query_add_mod.document.Bkappt_form.from_page.value+"\" calledFor=\""+calledFor+"\" /></root>"
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","BookAppointmentReferral.jsp",false);
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				responseText = trimString(responseText)
				eval(responseText) 
			}
		
				
		}
		var wait_list_num=parent.f_query_add_mod.document.Bkappt_form.wait_list_num.value;
			
		if(hddPatid==""&& parent.frames[0].document.forms[0].hddPat_id_new.value=="")	{/*Added by Rameswar on 17th June 2015 Against SKR-SCF-1088 IN055576*/
		if(wait_list_num!=""){ 
			var error1=getMessage("EXISTING_WAIT_LIST","OA");
			if(window.confirm(error1)){				
				parent.f_query_add_mod.document.Bkappt_form.search1.disabled=true;
				parent.f_query_add_mod.document.Bkappt_form.source.disabled=true;
				parent.f_query_add_mod.document.getElementById("dob1").disabled=true;
				var wait_list_val="Y";
				var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()
				xmlStr ="<root><SEARCH wait_list_val=\""+wait_list_val+"\" wait_list_num=\""+wait_list_num+"\" clinic_id=\""+parent.f_query_add_mod.document.Bkappt_form.clinic_id.value+"\" prm_res_class=\""+parent.f_query_add_mod.document.getElementById("res_class").value+"\" alcn_criteria_pop=\""+parent.f_query_add_mod.document.getElementById("alcn_criteria").value+"\"  calledFor='WaitList'/></root>"
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","../../eOA/jsp/BookAppointmentReferral.jsp",false);
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				responseText = trimString(responseText)
				eval(responseText)
				parent.f_query_add_mod.document.Bkappt_form.from_wait_list.value='Y';
				parent.f_query_add_mod.document.Bkappt_form.waitListNo.value=wait_list_num;
				
			}else{
				 if(hddPatid !="" && parent.frames[0].document.forms[0].CallingMode.value=='OP' || parent.frames[0].document.forms[0].CallingMode.value=='CA'){
					parent.frames[0].document.forms[0].patient_id.value=hddPatid;
					patIdValidation='Y';
					validatePatient(parent.frames[0].document.forms[0].patient_id)
					parent.frames[0].document.forms[0].patient_id.disabled=false; /*Modified by Rameswar on 17th June 2015 Against SKR-SCF-1088 IN055576*/
					parent.frames[0].document.forms[0].search.disabled=false;	/*Modified by Rameswar on 17th June 2015 Against SKR-SCF-1088 IN055576*/
					
				}
				parent.f_query_add_mod.document.Bkappt_form.from_wait_list.value='N';		
			}
		}	
		}	/*Added by Rameswar on 17th June 2015 Against SKR-SCF-1088 IN055576 - Start*/
		else if(parent.frames[0].document.forms[0].CallingMode.value!='N' ){/*Added by Rameswar on 25th June 2015 Against SKR-SCF-1088 IN055576*/  //parent.f_query_add_mod.document.Bkappt_form.from_page.value !="modifyappt")
				
					/*Added by Rameswar Against SKR-SCF-1099 on 3rd Sept 2015- Start*/
					if (hddPatid=="")
					{
						parent.frames[0].document.forms[0].patient_id.value=parent.frames[0].document.forms[0].hddPat_id_new.value ;
					}else{ 
						/*if(hddPatid=="dummy_patinetID"){
						parent.frames[0].document.forms[0].patient_id.value="";
						}else{*/
						parent.frames[0].document.forms[0].patient_id.value=hddPatid; 
					//}
					}/*Added by Rameswar Against SKR-SCF-1099 on 3rd Sept 2015- End*/
					
					if(parent.frames[0].document.forms[0].CallingMode.value!='CA' && parent.f_query_add_mod.document.Bkappt_form.from_page.value !="modifyappt" && parent.frames[0].document.forms[0].CallingMode.value!='RSCAPPT' )/*Added by Rameswar Against SKR-SCF-1099 on 3rd Sept 2015- Start*/
						{
					patIdValidation='Y';
					
					validatePatient(parent.frames[0].document.forms[0].patient_id);
					parent.frames[0].document.forms[0].CallingMode.value="";
					parent.f_query_add_mod.document.Bkappt_form.priorty.disabled=false;	
					}
					parent.frames[0].document.forms[0].patient_id.disabled=true;
					parent.frames[0].document.forms[0].search.disabled=true;
					parent.f_query_add_mod.document.Bkappt_form.from_wait_list.value='N';	
					} 
		/*Added by Rameswar on 17th June 2015 Against SKR-SCF-1088 IN055576 -End*/			
	}else{
		alert(getMessage("VISIT_TYPE_NOT_LOCN","OA"));
		
		parent.window.close();
	}
	if(parent.frames[0].document.forms[0].patient_id && parent.frames[0].document.forms[0].patient_id.value !=""){ 
	/*Below Added by Rameswar 18-Sep-15 to handle Dummy patientid display in Patient ID Against IN057689 */
	if(document.getElementById("patient_id").value=='dummy_patinetID'){
		document.getElementById("patient_id").value="";
	}
		var xmlDoc= "" ;
		var xmlHttp= new XMLHttpRequest() ;
		
		xmlStr	="<root><SEARCH " ;
		xmlStr += "patient_id=\""+document.getElementById("patient_id").value+"\"  steps='No_Show_appt'";
		xmlStr +=" /></root>" ;
		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
			// comment this code regarding 17086-Re-open issue. modified by Venkat S (17-12-09)
		/*
		if(Flag==true){
			alert('111')
			var err_msg=getMessage("PATIENT_PREV_NOSHOW_APPTS","OA");
			alert(err_msg);
			parent.frames[2].document.forms[0].no_show_appt.style.visibility='visible';
		}else{
			parent.frames[2].document.forms[0].no_show_appt.style.visibility='hidden';
		}
		*/
	}
	if((parent.frames[0].document.forms[0].patient_id.value=='' && parent.frames[0].document.forms[0].ca_patient_id_new.value=='' && parent.frames[0].document.forms[0].hddPat_id.value=='' && parent.frames[0].document.forms[0].hddPat_id_new.value=='') && parent.frames[0].document.forms[0].source.value!=''){
		validpatient_refral(parent.frames[0].document.forms[0].source,'nonmodel');
	}
	if(parent.f_query_add_mod.document.Bkappt_form.rule_appl_yn.value == 'Y' && document.forms[0].from_page.value !="modifyappt"){
			if(parent.frames[0].document.forms[0].source.value!="" && document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y'){
				validpatient_refral(parent.frames[0].document.forms[0].source,'nonmodel');
			}else if(parent.frames[0].document.forms[0].patient_id_temp.value !=""){
			parent.frames[0].document.forms[0].patient_id.value=parent.frames[0].document.forms[0].patient_id_temp.value; 
			/*Below line modified for this incident*/
			
		//	if(patIdValidation=='N')
          if(patIdValidation=='N' && parent.frames[0].document.forms[0].CallingMode && parent.frames[0].document.forms[0].CallingMode.value!="OP")		
			validatePatient(parent.frames[0].document.forms[0].patient_id_temp)
				
			parent.frames[0].document.forms[0].patient_id.disabled=true;
			parent.frames[0].document.forms[0].search.disabled=true;
			parent.document.frames[2].document.forms[0].clear.disabled=true;
			if(document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y'){
				if(parent.frames[0].document.forms[0].source){
					parent.frames[0].document.forms[0].source.disabled=true;
					parent.frames[0].document.forms[0].search1.disabled=true;
				}				
			}
		}else{
			//if(parent.frames[0].document.forms[0].name_prefix !=null)
				//parent.f_query_add_mod.document.Bkappt_form.name_prefix.disabled=false;
			
			if(parent.frames[0].document.forms[0].name_prefix && parent.f_query_add_mod.document.Bkappt_form.name_prefix_temp.value !=""){
				parent.f_query_add_mod.document.Bkappt_form.name_prefix.value = parent.f_query_add_mod.document.Bkappt_form.name_prefix_temp.value;
				if((document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y'))
					parent.f_query_add_mod.document.Bkappt_form.name_prefix.disabled=true;
			}
			if(parent.frames[0].document.forms[0].first_name && parent.f_query_add_mod.document.Bkappt_form.first_name_temp.value !=""){
				parent.f_query_add_mod.document.Bkappt_form.first_name.value = parent.f_query_add_mod.document.Bkappt_form.first_name_temp.value;
				ChangeInitCase(parent.frames[0].document.forms[0].first_name);
				if((document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y'))
					parent.f_query_add_mod.document.Bkappt_form.first_name.readOnly=true;
			}

			if(parent.frames[0].document.forms[0].second_name && parent.f_query_add_mod.document.Bkappt_form.second_name_temp.value !=""){
				parent.f_query_add_mod.document.Bkappt_form.second_name.value = parent.f_query_add_mod.document.Bkappt_form.second_name_temp.value;
				ChangeInitCase(parent.frames[0].document.forms[0].second_name);
				if(document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y')
					parent.f_query_add_mod.document.Bkappt_form.second_name.readOnly=true;
			}

			if(parent.frames[0].document.forms[0].third_name && parent.f_query_add_mod.document.Bkappt_form.third_name_temp.value !=""){
				parent.f_query_add_mod.document.Bkappt_form.third_name.value = parent.f_query_add_mod.document.Bkappt_form.third_name_temp.value;
				ChangeInitCase(parent.frames[0].document.forms[0].third_name);
				if(document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y')
					parent.f_query_add_mod.document.Bkappt_form.third_name.readOnly=true;
			}

			if(parent.frames[0].document.forms[0].family_name && parent.f_query_add_mod.document.Bkappt_form.family_name_temp.value !=""){
				parent.f_query_add_mod.document.Bkappt_form.family_name.value = parent.f_query_add_mod.document.Bkappt_form.family_name_temp.value;
				ChangeInitCase(parent.frames[0].document.forms[0].family_name);
				if(document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y')
					parent.f_query_add_mod.document.Bkappt_form.family_name.readOnly=true;
			}
			if(parent.frames[0].document.forms[0].name_suffix && parent.f_query_add_mod.document.Bkappt_form.name_suffix_temp.value !=""){
				parent.f_query_add_mod.document.Bkappt_form.name_suffix.value = parent.f_query_add_mod.document.Bkappt_form.name_suffix_temp.value;
				if((document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y'))
					parent.f_query_add_mod.document.Bkappt_form.name_suffix.disabled=true;
			}
			
			if(parent.frames[0].document.forms[0].name_prefix_oth_lang && parent.f_query_add_mod.document.Bkappt_form.name_prefix_oth_lang_temp.value !=""){
				parent.f_query_add_mod.document.Bkappt_form.name_prefix_oth_lang.value = parent.f_query_add_mod.document.Bkappt_form.name_prefix_oth_lang_temp.value;
				if((document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y'))
					parent.f_query_add_mod.document.Bkappt_form.name_prefix_oth_lang.disabled=true;
			}
			if(parent.frames[0].document.forms[0].first_name_oth_lang && parent.f_query_add_mod.document.Bkappt_form.first_name_oth_lang_temp.value !=""){
				parent.f_query_add_mod.document.Bkappt_form.first_name_oth_lang.value = parent.f_query_add_mod.document.Bkappt_form.first_name_oth_lang_temp.value;
				ChangeInitCase(parent.frames[0].document.forms[0].first_name_oth_lang);
				if((document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y'))
					parent.f_query_add_mod.document.Bkappt_form.first_name_oth_lang.readOnly=true;
			}

			if(parent.frames[0].document.forms[0].second_name_oth_lang && parent.f_query_add_mod.document.Bkappt_form.second_name_oth_lang_temp.value !=""){
				parent.f_query_add_mod.document.Bkappt_form.second_name_oth_lang.value = parent.f_query_add_mod.document.Bkappt_form.second_name_oth_lang_temp.value;
				ChangeInitCase(parent.frames[0].document.forms[0].second_name_oth_lang);
				if(document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y')
					parent.f_query_add_mod.document.Bkappt_form.second_name_oth_lang.readOnly=true;
			}

			if(parent.frames[0].document.forms[0].third_name_oth_lang && parent.f_query_add_mod.document.Bkappt_form.third_name_oth_lang_temp.value !=""){
				parent.f_query_add_mod.document.Bkappt_form.third_name_oth_lang.value = parent.f_query_add_mod.document.Bkappt_form.third_name_oth_lang_temp.value;
				ChangeInitCase(parent.frames[0].document.forms[0].third_name_oth_lang);
				if(document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y')
					parent.f_query_add_mod.document.Bkappt_form.third_name_oth_lang.readOnly=true;
			}
			if(parent.frames[0].document.forms[0].family_name_oth_lang && parent.f_query_add_mod.document.Bkappt_form.family_name_oth_lang_temp.value !=""){
				parent.f_query_add_mod.document.Bkappt_form.family_name_oth_lang.value = parent.f_query_add_mod.document.Bkappt_form.family_name_oth_lang_temp.value;
				ChangeInitCase(parent.frames[0].document.forms[0].family_name_oth_lang);
				if(document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y')
					parent.f_query_add_mod.document.Bkappt_form.family_name_oth_lang.readOnly=true;
			}
			if(parent.frames[0].document.forms[0].name_suffix_oth_lang && parent.f_query_add_mod.document.Bkappt_form.name_suffix_oth_lang_temp.value !=""){
				parent.f_query_add_mod.document.Bkappt_form.name_suffix_oth_lang.value = parent.f_query_add_mod.document.Bkappt_form.name_suffix_oth_lang_temp.value;
				if((document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y'))
					parent.f_query_add_mod.document.Bkappt_form.name_suffix_oth_lang.disabled=true;
			}
			if(parent.frames[0].document.forms[0].sex && parent.f_query_add_mod.document.Bkappt_form.gender_temp.value !=""){
				parent.f_query_add_mod.document.Bkappt_form.sex.value = parent.f_query_add_mod.document.Bkappt_form.gender_temp.value;
				if(document.forms[0].rule_based_tr && document.forms[0].rule_based_tr.value=='Y')
					parent.f_query_add_mod.document.Bkappt_form.sex.disabled=true;
			}
			//putPatientName();
			//putLocalLangPatientName();
			if(parent.f_query_add_mod.document.Bkappt_form.contact_no_temp.value!="")
				parent.frames[0].document.Bkappt_form.contact2_no.value = parent.f_query_add_mod.document.Bkappt_form.contact_no_temp.value;
			if(parent.f_query_add_mod.document.Bkappt_form.rule_based_tr.value =="Y"){
				if(parent.frames[0].document.forms[0].patient_id){
					parent.frames[0].document.forms[0].patient_id.disabled = true;
					parent.frames[0].document.forms[0].search.disabled = true;
				}
				parent.frames[0].document.forms[0].source.disabled = true;
				parent.frames[0].document.forms[0].search1.disabled = true;
			}
			if(parent.f_query_add_mod.document.Bkappt_form.nationality_code_temp.value !="")
				parent.f_query_add_mod.document.Bkappt_form.nationality_code1.value = parent.f_query_add_mod.document.Bkappt_form.nationality_code_temp.value;
			if(parent.f_query_add_mod.document.Bkappt_form.nat_desc_temp.value !="")
			parent.f_query_add_mod.document.Bkappt_form.nationality_desc.value = parent.f_query_add_mod.document.Bkappt_form.nat_desc_temp.value;
			//if(parent.frames[0].document.forms[0].name_suffix !=null)
				//parent.f_query_add_mod.document.Bkappt_form.name_suffix.disabled=false;
		}
	}
	putPatientName();
	putLocalLangPatientName();
}


function validateDateTime(obj)
{
if(obj.value!="")
	{
	if(!validDateObj(obj,"DMYHM",localeName))
		{
			obj.value="";
			return ;
		}

		var sysdt = document.forms[0].sys_date_time.value;
		var obj2=convertDate(obj.value,"DMYHM",localeName,"en");
		
		if(isBefore(obj2,sysdt,'DMYHM','en')==false)//localName is changed to en by Rameswar on 05-Oct-15 for Leap Year Issue
			{
				alert(getMessage("REC_DT_NOT_GR_SYSDATE","OA"));
				obj.value="";
				obj.select();	
				return false;
			}

	}

}
function checkDt(date1)
{

    retval=true
    var date1arr=new Array()

    date1arr=date1.split("/")

    if(date1arr.length==3)
    {
        var date1d=date1arr[0]
        var date1m=date1arr[1]
        var date1y=date1arr[2]

        date1d=eval(date1d)
        date1m=eval(date1m)
        date1yy=eval(date1y);

		if(date1d==0)
			retval= false
		
		if(date1m==0)
			retval= false

		if(date1yy==0)
			retval= false

        if(date1m<=12)
        {

            if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
            {
            retval= false}

            if((date1m==4 || date1m==6 || date1m==9 || date1m==11 ) && (date1d>30))
            {
            retval= false}

    if ((date1y.length <4) || (date1y.length >4))
    {
    retval= false}
                }
        else
            {
            retval= false;}
    }
    else
        {retval= false;}
        return retval;
    }

function chkTime(time1)
{
	var retval=true;

	if( (time1.charAt(time1.length-1) )!=":")
	{
		var time1arr=new Array()
		time1arr=time1.split(":")

		if(time1arr.length==2)
		{
			var time1hr=time1arr[0]
			var time1min=time1arr[1]

			time1hr=parseInt(time1hr)
			time1min=parseInt(time1min)
			if(time1hr<=23)
			{
				if(time1min>59)
				{
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

	return retval
}


function enable_conrolls()
{
	if(parent.frames[0].document.forms[0].from_page.value =="")
	{
	if(parent.frames[0].document.Bkappt_form.patient_id)
		parent.frames[0].document.Bkappt_form.patient_id.disabled=false;
	}
	
	
	
	if(parent.frames[0].document.Bkappt_form.national_id_no)
		parent.frames[0].document.Bkappt_form.national_id_no.disabled=false;
	
	if(parent.frames[0].document.Bkappt_form.alt_id1_no)
		parent.frames[0].document.Bkappt_form.alt_id1_no.disabled=false;
	
	if(parent.frames[0].document.Bkappt_form.alt_id2_no)
		parent.frames[0].document.Bkappt_form.alt_id2_no.disabled=false;
	
	if(parent.frames[0].document.Bkappt_form.alt_id3_no)
		parent.frames[0].document.Bkappt_form.alt_id3_no.disabled=false;

	if(parent.frames[0].document.Bkappt_form.alt_id4_no)
		parent.frames[0].document.Bkappt_form.alt_id4_no.disabled=false;

	if(parent.frames[0].document.Bkappt_form.name_prefix)
		parent.frames[0].document.Bkappt_form.name_prefix.disabled=false;

	if(parent.frames[0].document.Bkappt_form.first_name)
		parent.frames[0].document.Bkappt_form.first_name.disabled=false;

	if(parent.frames[0].document.Bkappt_form.second_name)
		parent.frames[0].document.Bkappt_form.second_name.disabled=false;

	if(parent.frames[0].document.Bkappt_form.third_name)
		parent.frames[0].document.Bkappt_form.third_name.disabled=false;

	if(parent.frames[0].document.Bkappt_form.family_name)
		parent.frames[0].document.Bkappt_form.family_name.disabled=false;

	if(parent.frames[0].document.Bkappt_form.name_suffix)
		parent.frames[0].document.Bkappt_form.name_suffix.disabled=false;


if(parent.frames[0].document.Bkappt_form.name_prefix_oth_lang)
		parent.frames[0].document.Bkappt_form.name_prefix_oth_lang.disabled=false;

	if(parent.frames[0].document.Bkappt_form.first_name_oth_lang)
		parent.frames[0].document.Bkappt_form.first_name_oth_lang.disabled=false;

	if(parent.frames[0].document.Bkappt_form.second_name_oth_lang)
		parent.frames[0].document.Bkappt_form.second_name_oth_lang.disabled=false;

	if(parent.frames[0].document.Bkappt_form.third_name_oth_lang)
		parent.frames[0].document.Bkappt_form.third_name_oth_lang.disabled=false;

	if(parent.frames[0].document.Bkappt_form.family_name_oth_lang)
		parent.frames[0].document.Bkappt_form.family_name_oth_lang.disabled=false;

	if(parent.frames[0].document.Bkappt_form.name_suffix_oth_lang)
		parent.frames[0].document.Bkappt_form.name_suffix_oth_lang.disabled=false;


	if(parent.frames[0].document.Bkappt_form.sex)
		parent.frames[0].document.Bkappt_form.sex.disabled=false;

	if(parent.frames[0].document.Bkappt_form.date_of_birth)
		parent.frames[0].document.Bkappt_form.date_of_birth.disabled=false;

	if(parent.frames[0].document.Bkappt_form.contact1_no)
		parent.frames[0].document.Bkappt_form.contact1_no.disabled=false;

	if(parent.frames[0].document.Bkappt_form.contact2_no)
		parent.frames[0].document.Bkappt_form.contact2_no.disabled=false;

	if(parent.frames[0].document.Bkappt_form.email_id)
		parent.frames[0].document.Bkappt_form.email_id.disabled=false;

	if(parent.frames[0].document.Bkappt_form.nationality)
		parent.frames[0].document.Bkappt_form.nationality.disabled=false;

	if(parent.frames[0].document.Bkappt_form.alt_id1_exp_date)
	{
		parent.frames[0].document.Bkappt_form.alt_id1_exp_date.disabled=false;
		parent.frames[0].document.Bkappt_form.alt_id_exp_dt1.disabled=false;
	}

	if(parent.frames[0].document.Bkappt_form.alt_id2_exp_date)
	{
		parent.frames[0].document.Bkappt_form.alt_id2_exp_date.disabled=false;
		parent.frames[0].document.Bkappt_form.alt_id_exp_dt2.disabled=false;
	}

	if(parent.frames[0].document.Bkappt_form.contact_details)
		parent.frames[0].document.Bkappt_form.contact_details.disabled=false;

	if(parent.frames[0].document.Bkappt_form.alt_id3_exp_date)
	{
		parent.frames[0].document.Bkappt_form.alt_id3_exp_date.disabled=false;
		parent.frames[0].document.Bkappt_form.alt_id_exp_dt3.disabled=false;
	}

	if(parent.frames[0].document.Bkappt_form.alt_id4_exp_date)
	{
		parent.frames[0].document.Bkappt_form.alt_id4_exp_date.disabled=false;
		parent.frames[0].document.Bkappt_form.alt_id_exp_dt4.disabled=false;
	}

	if(parent.frames[0].document.Bkappt_form.b_age)
		parent.frames[0].document.Bkappt_form.b_age.disabled=false;

	if(parent.frames[0].document.Bkappt_form.b_months)
		parent.frames[0].document.Bkappt_form.b_months.disabled=false;

	if(parent.frames[0].document.Bkappt_form.b_days)
		parent.frames[0].document.Bkappt_form.b_days.disabled=false;
	
	if(parent.frames[0].document.Bkappt_form.other_alt_type)
		parent.frames[0].document.Bkappt_form.other_alt_type.disabled=false;

	if(parent.frames[0].document.Bkappt_form.other_alt_Id)
		parent.frames[0].document.Bkappt_form.other_alt_Id.disabled=false;

	if(parent.frames[0].document.Bkappt_form.citizen_yn[0])
		parent.frames[0].document.Bkappt_form.citizen_yn[0].disabled=false;

	if(parent.frames[0].document.Bkappt_form.citizen_yn[1])
		parent.frames[0].document.Bkappt_form.citizen_yn[1].disabled=false;

	if(parent.frames[0].document.Bkappt_form.citizen_yn[0].checked==true)
	{
		parent.frames[0].document.Bkappt_form.legal_yn.disabled=true;

	}

	if(parent.frames[0].document.Bkappt_form.nationality_desc)
		parent.frames[0].document.Bkappt_form.nationality_desc.disabled=false;

	if(parent.frames[0].document.Bkappt_form.contry_code)
		parent.frames[0].document.Bkappt_form.contry_code.disabled=false;

	if(parent.frames[0].document.Bkappt_form.ethnic_group)
		parent.frames[0].document.Bkappt_form.ethnic_group.disabled=false;

	/*
	if(parent.frames[0].document.Bkappt_form.race_code)
		parent.frames[0].document.Bkappt_form.race_code.disabled=false;
	*/

	if(parent.frames[0].document.Bkappt_form.race_desc)	{
		parent.frames[0].document.Bkappt_form.race_desc.disabled=false;
		parent.frames[0].document.Bkappt_form.race_desc_id.disabled=false;
	}

	if(parent.frames[0].document.Bkappt_form.source)
		parent.frames[0].document.Bkappt_form.source.disabled=false;

	parent.frames[0].document.Bkappt_form.date_of_birth.disabled=false;
	parent.frames[0].document.Bkappt_form.b_birth.disabled=false;
	parent.frames[0].document.Bkappt_form.dob.disabled=false;

	parent.frames[0].document.Bkappt_form.place_of_birth.disabled=false;
	
}

function disable_conrolls()
{
	
	if(parent.frames[0].document.Bkappt_form.patient_id)
	{	parent.frames[0].document.Bkappt_form.patient_id.disabled=true;
		parent.frames[0].document.Bkappt_form.patient_id.value="";
	}
	
	parent.frames[0].document.getElementById("patient_name1").innerHTML="&nbsp";
	
	if(parent.frames[0].document.Bkappt_form.national_id_no)
	{
		parent.frames[0].document.Bkappt_form.national_id_no.disabled=true;
		parent.frames[0].document.Bkappt_form.national_id_no.value="";
	}
	if(document.Bkappt_form.rule_based_tr.value !="Y"){
		if(parent.frames[0].document.Bkappt_form.alt_id1_no)
		{	parent.frames[0].document.Bkappt_form.alt_id1_no.disabled=true;
			parent.frames[0].document.Bkappt_form.alt_id1_no.value="";
		}
		if(parent.frames[0].document.Bkappt_form.alt_id2_no)
		{	parent.frames[0].document.Bkappt_form.alt_id2_no.disabled=true;
			parent.frames[0].document.Bkappt_form.alt_id2_no.value="";
		}
		if(parent.frames[0].document.Bkappt_form.alt_id3_no)
		{	parent.frames[0].document.Bkappt_form.alt_id3_no.disabled=true;
			parent.frames[0].document.Bkappt_form.alt_id3_no.value="";
		}
		if(parent.frames[0].document.Bkappt_form.alt_id4_no)
		{	parent.frames[0].document.Bkappt_form.alt_id4_no.disabled=true;
		parent.frames[0].document.Bkappt_form.alt_id4_no.value="";
		}
		if(parent.frames[0].document.Bkappt_form.name_prefix)
		{	parent.frames[0].document.Bkappt_form.name_prefix.disabled=true;
		parent.frames[0].document.Bkappt_form.name_prefix.value="";
		}
		if(parent.frames[0].document.Bkappt_form.first_name)
		{	parent.frames[0].document.Bkappt_form.first_name.disabled=true;
	parent.frames[0].document.Bkappt_form.first_name.value="";
		}
		if(parent.frames[0].document.Bkappt_form.second_name)
		{	parent.frames[0].document.Bkappt_form.second_name.disabled=true;
		parent.frames[0].document.Bkappt_form.second_name.value="";
		}
		if(parent.frames[0].document.Bkappt_form.third_name)
		{	parent.frames[0].document.Bkappt_form.third_name.disabled=true;
		parent.frames[0].document.Bkappt_form.third_name.value="";
		}
		if(parent.frames[0].document.Bkappt_form.family_name)
		{	parent.frames[0].document.Bkappt_form.family_name.disabled=true;
		parent.frames[0].document.Bkappt_form.family_name.value="";
		}
		if(parent.frames[0].document.Bkappt_form.name_suffix)
		{
			parent.frames[0].document.Bkappt_form.name_suffix.disabled=true;
		parent.frames[0].document.Bkappt_form.name_suffix.value="";
		}

		if(parent.frames[0].document.Bkappt_form.sex)
		{	parent.frames[0].document.Bkappt_form.sex.disabled=true;
		parent.frames[0].document.Bkappt_form.sex.value="";
		}
		if(parent.frames[0].document.Bkappt_form.date_of_birth)
		{
			parent.frames[0].document.Bkappt_form.date_of_birth.disabled=true;
		parent.frames[0].document.Bkappt_form.date_of_birth.value="";
		}
		if(parent.frames[0].document.Bkappt_form.contact1_no)
		{
			parent.frames[0].document.Bkappt_form.contact1_no.disabled=true;
		parent.frames[0].document.Bkappt_form.contact1_no.value="";
		}
		if(parent.frames[0].document.Bkappt_form.contact2_no)
		{
			parent.frames[0].document.Bkappt_form.contact2_no.disabled=true;
		parent.frames[0].document.Bkappt_form.contact2_no.value="";
		}

		if(parent.frames[0].document.Bkappt_form.email_id)
		{
			parent.frames[0].document.Bkappt_form.email_id.disabled=true;
		parent.frames[0].document.Bkappt_form.email_id.value="";
		}

		if(parent.frames[0].document.Bkappt_form.nationality_desc)
		{
			parent.frames[0].document.Bkappt_form.nationality_desc.disabled=true;
			//commented by N Munisekhar on 22-Feb-2013 against ML-BRU-SCF-0699 [IN:037972] 
		    //parent.frames[0].document.Bkappt_form.nationality_desc.value="";
		} 

		if(parent.frames[0].document.Bkappt_form.contry_code)
		parent.frames[0].document.Bkappt_form.contry_code.disabled=true;

		if(parent.frames[0].document.Bkappt_form.place_of_birth_desc)
		{
		parent.frames[0].document.Bkappt_form.place_of_birth_desc.disabled=true;
		parent.frames[0].document.Bkappt_form.place_of_birth_desc.value="";
		}

		if(parent.frames[0].document.Bkappt_form.birth_place_id)
		{
			parent.frames[0].document.Bkappt_form.birth_place_id.value="";
			parent.frames[0].document.Bkappt_form.birth_place_id.disabled=true;
		}

		if(parent.frames[0].document.Bkappt_form.contact_details)
			//parent.frames[0].document.Bkappt_form.contact_details.disabled=true;

		if(parent.frames[0].document.Bkappt_form.other_alt_type)
			parent.frames[0].document.Bkappt_form.other_alt_type.value="";

		if(parent.frames[0].document.Bkappt_form.other_alt_Id)
			parent.frames[0].document.Bkappt_form.other_alt_Id.value="";

		if(parent.frames[0].document.Bkappt_form.alt_id1_exp_date)
		{
			parent.frames[0].document.Bkappt_form.alt_id1_exp_date.disabled=true;
			parent.frames[0].document.Bkappt_form.alt_id_exp_dt1.disabled=true;
			parent.frames[0].document.Bkappt_form.alt_id1_exp_date.value="";
		}

		if(parent.frames[0].document.Bkappt_form.alt_id2_exp_date)
		{
			parent.frames[0].document.Bkappt_form.alt_id2_exp_date.disabled=true;
			parent.frames[0].document.Bkappt_form.alt_id_exp_dt2.disabled=true;
			parent.frames[0].document.Bkappt_form.alt_id2_exp_date.value="";
		}

		if(parent.frames[0].document.Bkappt_form.alt_id3_exp_date)
		{
			parent.frames[0].document.Bkappt_form.alt_id3_exp_date.disabled=true;
			parent.frames[0].document.Bkappt_form.alt_id_exp_dt3.disabled=true;
			parent.frames[0].document.Bkappt_form.alt_id3_exp_date.value="";
		}

		if(parent.frames[0].document.Bkappt_form.alt_id4_exp_date)
		{
			parent.frames[0].document.Bkappt_form.alt_id4_exp_date.disabled=true;
			parent.frames[0].document.Bkappt_form.alt_id_exp_dt4.disabled=true;
			parent.frames[0].document.Bkappt_form.alt_id4_exp_date.value="";
		}

		if(parent.frames[0].document.Bkappt_form.b_age)
		{
			parent.frames[0].document.Bkappt_form.b_age.disabled=true;
			parent.frames[0].document.Bkappt_form.b_age.value="";
		}

		if(parent.frames[0].document.Bkappt_form.b_months)
		{
			parent.frames[0].document.Bkappt_form.b_months.disabled=true;
			parent.frames[0].document.Bkappt_form.b_months.value="";
		}

		if(parent.frames[0].document.Bkappt_form.b_days)
		{
			parent.frames[0].document.Bkappt_form.b_days.disabled=true;
			parent.frames[0].document.Bkappt_form.b_days.value="";
		}

		if(parent.frames[0].document.getElementById("dateofbirth"))
			parent.frames[0].document.getElementById("dateofbirth").disabled=true;
			parent.frames[0].document.getElementById("dateofbirth").value="";
			parent.frames[0].document.Bkappt_form.b_birth.disabled=true;
			parent.frames[0].document.Bkappt_form.dob.disabled=true;


		if(parent.frames[0].document.Bkappt_form.other_alt_type)
			parent.frames[0].document.Bkappt_form.other_alt_type.disabled=true;

		if(parent.frames[0].document.Bkappt_form.other_alt_Id)
			parent.frames[0].document.Bkappt_form.other_alt_Id.disabled=true;

		if(parent.frames[0].document.Bkappt_form.citizen_yn[0])
			parent.frames[0].document.Bkappt_form.citizen_yn[0].disabled=true;

		if(parent.frames[0].document.Bkappt_form.legal_yn[0])
			parent.frames[0].document.Bkappt_form.legal_yn[0].disabled=true;

		if(parent.frames[0].document.Bkappt_form.citizen_yn[1])
			parent.frames[0].document.Bkappt_form.citizen_yn[1].disabled=true;

		if(parent.frames[0].document.Bkappt_form.legal_yn[1])
			parent.frames[0].document.Bkappt_form.legal_yn[1].disabled=true;

		parent.frames[0].document.Bkappt_form.ethnic_group.value="";
		parent.frames[0].document.Bkappt_form.race_code.value="";
		parent.frames[0].document.Bkappt_form.race_desc.value="";


		if(parent.frames[0].document.Bkappt_form.source)
	//		parent.frames[0].document.Bkappt_form.source.disabled=true;

	if(parent.f_query_add_mod.document.Bkappt_form.nationality)
	parent.f_query_add_mod.document.Bkappt_form.nationality.disabled=true;

		 parent.frames[0].document.Bkappt_form.place_of_birth.disabled=true;
	 parent.frames[0].document.Bkappt_form.place_of_birth.value="";

	 /***added***/

		if(parent.frames[0].document.Bkappt_form.name_suffix)
		{
			parent.frames[0].document.Bkappt_form.name_suffix.disabled=true;
		}

		/*
		if(parent.frames[0].document.Bkappt_form.ethnic_group)
		{
			parent.frames[0].document.Bkappt_form.ethnic_group.disabled=true;
		}
		*/

		if(parent.frames[0].document.Bkappt_form.race_desc)	{
			parent.frames[0].document.Bkappt_form.race_desc.disabled=true;
			parent.frames[0].document.Bkappt_form.race_desc_id.disabled=true;
		}

		/*
		if(parent.frames[0].document.Bkappt_form.race_code)
		{
			parent.frames[0].document.Bkappt_form.race_code.disabled=true;
		}
		*/

		if(parent.frames[0].document.forms[0].name_prefix_oth_lang)
		{
			parent.frames[0].document.forms[0].name_prefix_oth_lang.value="";
			parent.frames[0].document.forms[0].name_prefix_oth_lang.disabled=true;
		}
		if(parent.frames[0].document.forms[0].first_name_oth_lang)
		{
			parent.frames[0].document.forms[0].first_name_oth_lang.value="";
			parent.frames[0].document.forms[0].first_name_oth_lang.disabled=true;
		}
		if(parent.frames[0].document.forms[0].second_name_oth_lang)
		{
			parent.frames[0].document.forms[0].second_name_oth_lang.value="";
			parent.frames[0].document.forms[0].second_name_oth_lang.disabled=true;
		}
		if(parent.frames[0].document.forms[0].third_name_oth_lang)
		{
			parent.frames[0].document.forms[0].third_name_oth_lang.value="";
			parent.frames[0].document.forms[0].third_name_oth_lang.disabled=true;
		}
		if(parent.frames[0].document.forms[0].family_name_oth_lang)
		{
			parent.frames[0].document.forms[0].family_name_oth_lang.value="";
			parent.frames[0].document.forms[0].family_name_oth_lang.disabled=true;
		}
		if(parent.frames[0].document.forms[0].name_suffix_oth_lang)
		{
			parent.frames[0].document.forms[0].name_suffix_oth_lang.value="";
			parent.frames[0].document.forms[0].name_suffix_oth_lang.disabled=true;
		}
		if(parent.frames[0].document.forms[0].nationality_id)
		{
			parent.frames[0].document.forms[0].nationality_id.disabled=true;
			parent.frames[0].document.forms[0].nationality_desc.disabled=true;
		}
	
	}


}

function disable_notoa(){
	if(parent.frames[0].document.Bkappt_form.patient_id)
	{	parent.frames[0].document.Bkappt_form.patient_id.disabled=true;
	}
	
	if(parent.frames[0].document.Bkappt_form.national_id_no)
	{
	parent.frames[0].document.Bkappt_form.national_id_no.disabled=true;
	}
	if(parent.frames[0].document.Bkappt_form.alt_id1_no)
	{	parent.frames[0].document.Bkappt_form.alt_id1_no.disabled=true;
	}
	if(parent.frames[0].document.Bkappt_form.alt_id2_no)
	{	parent.frames[0].document.Bkappt_form.alt_id2_no.disabled=true;
	}
	if(parent.frames[0].document.Bkappt_form.alt_id3_no)
	{	parent.frames[0].document.Bkappt_form.alt_id3_no.disabled=true;
	}
	if(parent.frames[0].document.Bkappt_form.alt_id4_no)
	{	parent.frames[0].document.Bkappt_form.alt_id4_no.disabled=true;
	}
	if(parent.frames[0].document.Bkappt_form.name_prefix)
	{	parent.frames[0].document.Bkappt_form.name_prefix.disabled=true;
	}
	if(parent.frames[0].document.Bkappt_form.first_name)
	{	parent.frames[0].document.Bkappt_form.first_name.disabled=true;
	}
	if(parent.frames[0].document.Bkappt_form.second_name)
	{	parent.frames[0].document.Bkappt_form.second_name.disabled=true;
	}
	if(parent.frames[0].document.Bkappt_form.third_name)
	{	parent.frames[0].document.Bkappt_form.third_name.disabled=true;
	}
	if(parent.frames[0].document.Bkappt_form.family_name)
	{	parent.frames[0].document.Bkappt_form.family_name.disabled=true;
	}
	if(parent.frames[0].document.Bkappt_form.name_suffix)
	{
		parent.frames[0].document.Bkappt_form.name_suffix.disabled=true;
	}

	if(parent.frames[0].document.Bkappt_form.sex)
	{	parent.frames[0].document.Bkappt_form.sex.disabled=true;
	}
	if(parent.frames[0].document.Bkappt_form.date_of_birth)
	{
		parent.frames[0].document.Bkappt_form.date_of_birth.disabled=true;
	}
	if(parent.frames[0].document.Bkappt_form.contact1_no)
	{
		parent.frames[0].document.Bkappt_form.contact1_no.disabled=true;
	}
	if(parent.frames[0].document.Bkappt_form.contact2_no)
	{
		parent.frames[0].document.Bkappt_form.contact2_no.disabled=true;
	}

	if(parent.frames[0].document.Bkappt_form.email_id)
	{
		parent.frames[0].document.Bkappt_form.email_id.disabled=true;
	}

	if(parent.frames[0].document.Bkappt_form.nationality_desc)
	{
		parent.frames[0].document.Bkappt_form.nationality_desc.disabled=true;
	}

	if(parent.frames[0].document.Bkappt_form.contry_code)
	parent.frames[0].document.Bkappt_form.contry_code.disabled=true;

	if(parent.frames[0].document.Bkappt_form.place_of_birth_desc)
	{
	parent.frames[0].document.Bkappt_form.place_of_birth_desc.disabled=true;
	}

	if(parent.frames[0].document.Bkappt_form.birth_place_id)
		parent.frames[0].document.Bkappt_form.birth_place_id.disabled=true;

	if(parent.frames[0].document.Bkappt_form.contact_details)
		parent.frames[0].document.Bkappt_form.contact_details.disabled=false;


	if(parent.frames[0].document.Bkappt_form.alt_id1_exp_date)
	{
		parent.frames[0].document.Bkappt_form.alt_id1_exp_date.disabled=true;
		parent.frames[0].document.Bkappt_form.alt_id_exp_dt1.disabled=true;
	}

	if(parent.frames[0].document.Bkappt_form.alt_id2_exp_date)
	{
		parent.frames[0].document.Bkappt_form.alt_id2_exp_date.disabled=true;
		parent.frames[0].document.Bkappt_form.alt_id_exp_dt2.disabled=true;
	}

	if(parent.frames[0].document.Bkappt_form.alt_id3_exp_date)
	{
		parent.frames[0].document.Bkappt_form.alt_id3_exp_date.disabled=true;
		parent.frames[0].document.Bkappt_form.alt_id_exp_dt3.disabled=true;
	}

	if(parent.frames[0].document.Bkappt_form.alt_id4_exp_date)
	{
		parent.frames[0].document.Bkappt_form.alt_id4_exp_date.disabled=true;
		parent.frames[0].document.Bkappt_form.alt_id_exp_dt4.disabled=true;
	}

	if(parent.frames[0].document.Bkappt_form.b_age)
	{
		parent.frames[0].document.Bkappt_form.b_age.disabled=true;
	}

	if(parent.frames[0].document.Bkappt_form.b_months)
	{
		parent.frames[0].document.Bkappt_form.b_months.disabled=true;
	}

	if(parent.frames[0].document.Bkappt_form.b_days)
	{
		parent.frames[0].document.Bkappt_form.b_days.disabled=true;
	}

	if(parent.frames[0].document.getElementById("dateofbirth"))
		parent.frames[0].document.getElementById("dateofbirth").disabled=true;
		parent.frames[0].document.Bkappt_form.b_birth.disabled=true;
		parent.frames[0].document.Bkappt_form.dob.disabled=true;


	if(parent.frames[0].document.Bkappt_form.other_alt_type)
		parent.frames[0].document.Bkappt_form.other_alt_type.disabled=true;

	if(parent.frames[0].document.Bkappt_form.other_alt_Id)
		parent.frames[0].document.Bkappt_form.other_alt_Id.disabled=true;

	if(parent.frames[0].document.Bkappt_form.citizen_yn[0])
		parent.frames[0].document.Bkappt_form.citizen_yn[0].disabled=true;

	if(parent.frames[0].document.Bkappt_form.legal_yn[0])
		parent.frames[0].document.Bkappt_form.legal_yn[0].disabled=true;

	if(parent.frames[0].document.Bkappt_form.citizen_yn[1])
		parent.frames[0].document.Bkappt_form.citizen_yn[1].disabled=true;

	if(parent.frames[0].document.Bkappt_form.legal_yn[1])
		parent.frames[0].document.Bkappt_form.legal_yn[1].disabled=true;

	if(parent.frames[0].document.Bkappt_form.ethnic_group)
	{
		parent.frames[0].document.Bkappt_form.ethnic_group.disabled=true;
	}

	/*
	if(parent.frames[0].document.Bkappt_form.race_code)
	{
		parent.frames[0].document.Bkappt_form.race_code.disabled=true;
	}
	*/

	if(parent.frames[0].document.Bkappt_form.race_desc)	{
		parent.frames[0].document.Bkappt_form.race_desc.disabled=true;
		parent.frames[0].document.Bkappt_form.race_desc_id.disabled=true;
	}

	if(parent.frames[0].document.Bkappt_form.source)
		parent.frames[0].document.Bkappt_form.source.disabled=true;

if(parent.f_query_add_mod.document.Bkappt_form.nationality)
parent.f_query_add_mod.document.Bkappt_form.nationality.disabled=true;

	 parent.frames[0].document.Bkappt_form.place_of_birth.disabled=true;

}
function Apply()
{
	var startarray;
	var endarray;
	var fromarray;
	var toarray;
	var toSubmit = new Boolean();
	toSubmit=true;
	var chk1;
	parent.frames[2].document.forms[0].Insupd.disabled=true;

	parent.f_query_add_mod.document.Bkappt_form.gen.value=parent.f_query_add_mod.document.Bkappt_form.sex.value;
	
	if((parent.frames[0].document.forms[0].time_table_type.value=="3") && (parent.frames[0].document.forms[0].From_timeval.value=='')) {
	var err_from =getMessage("APPT_FROM_TIME_BLANK","OA") ;
	alert(err_from);
	toSubmit=false;
	parent.frames[2].document.forms[0].Insupd.disabled=false;
		}

		if((parent.frames[0].document.forms[0].time_table_type.value=="3") && (parent.frames[0].document.forms[0].To_timeval.value== '')) {
		var err_to =getMessage("APPT_TO_TIME_BLANK","SM") ;
		alert(err_to);
		toSubmit=false;
		parent.frames[2].document.forms[0].Insupd.disabled=false;
		}


		if ( parent.f_query_add_mod.document.Bkappt_form.name_prefix != null && parent.f_query_add_mod.document.Bkappt_form.sex !=null)
		{
			if ( parent.f_query_add_mod.document.Bkappt_form.name_prefix.value.length != 0 )
			{

				if(parent.f_query_add_mod.document.Bkappt_form.entered.value=='N'){
					canSave = checkPatSex1();
					if ( canSave == false ){
					toSubmit = false;
					}
				}
			}
		}

		if ( parent.f_query_add_mod.document.Bkappt_form.name_suffix != null && parent.f_query_add_mod.document.Bkappt_form.sex !=null)
		{
			if ( parent.f_query_add_mod.document.Bkappt_form.name_suffix.value.length != 0 )
			{
				canSave = checkPatSuffixSex1();
				if ( canSave == false ){
				toSubmit = false;
				}
			}
		}


			var starttime=parent.frames[0].document.forms[0].starttime.value;
			var endtime=parent.frames[0].document.forms[0].endtime.value;
			var fromtime=parent.frames[0].document.forms[0].From_timeval.value;
			var totime=parent.frames[0].document.forms[0].To_timeval.value;

			if(starttime.length >0 || endtime.length >0 || fromtime.lenght>0 || totime.length>0)
			{
				startarray=starttime.split(":");
				endarray=endtime.split(":");
				fromarray=fromtime.split(":");
				toarray=totime.split(":");


				var starttm=new Date(1,1,1,startarray[0],startarray[1],0,0);
			var endtm=new Date(1,1,1,endarray[0],endarray[1],0,0);
			var fromtm=new Date(1,1,1,fromarray[0],fromarray[1],0,0);
			var totm=new Date(1,1,1,toarray[0],toarray[1],0,0);



			if( ( Date.parse(fromtm) < Date.parse(starttm) ) || ( Date.parse(fromtm) > Date.parse(endtm)) ){
			var err_from1 =getMessage("FM_TM_NOT_VALID","OA");
			alert(err_from1);
			toSubmit=false;
			parent.frames[2].document.forms[0].Insupd.disabled=false;
			}

			else if((Date.parse(totm) < Date.parse(starttm)) || (Date.parse(totm) > Date.parse(endtm))) {
			var err_to1 =getMessage("TO_TM_NOT_VALID","OA");
			alert(err_to1);	
			parent.frames[2].document.forms[0].Insupd.disabled=false;
			toSubmit=false;
			}
			else if(Date.parse(fromtm) > Date.parse(totm)) {
			var err_ch =getMessage("FM_TIME_GR_TO_TIME","Common") ;
			alert(err_ch);
			parent.frames[2].document.forms[0].Insupd.disabled=false;
			toSubmit=false;
			}
			else if(Date.parse(totm) < Date.parse(fromtm)) {
			var err_ch1 =getMessage("TO_TIME_LESS_FM_TIME","Common") ;
			alert(err_ch1);	
			parent.frames[2].document.forms[0].Insupd.disabled=false;
			toSubmit=false;
			}
		}
		var fields="";
		var names="";
		var wait_list_reqd=parent.f_query_add_mod.document.Bkappt_form.from_wait_list.value;
		if(wait_list_reqd==null) wait_list_reqd="N";	
		
		if(parent.f_query_add_mod.document.Bkappt_form.from_wait_list.value =="N")
		{
				fields= new Array(  parent.f_query_add_mod.document.Bkappt_form.clinic_code,
						parent.f_query_add_mod.document.Bkappt_form.appt_date,
						parent.f_query_add_mod.document.Bkappt_form.patient_name1,
						parent.f_query_add_mod.document.Bkappt_form.sex,
						parent.f_query_add_mod.document.Bkappt_form.visit_type_short_desc,
						parent.f_query_add_mod.document.Bkappt_form.nationality,
						parent.f_query_add_mod.document.Bkappt_form.reason_for_contact
					);
		 names=new Array(getLabel("Common.clinic.label","Common")+""+getLabel("Common.code.label","Common"),
						getLabel("Common.apptdate.label","Common"),
						getLabel("Common.PatientName.label","Common"),
						getLabel("Common.gender.label","Common"),
						getLabel("Common.visittype.label","Common"),
						getLabel("Common.nationality.label","Common"),
						getLabel("Common.ReasonForContact.label","Common")
		 );
			 
		 
		 
	
	}else
	{

		fields= new Array(  parent.f_query_add_mod.document.Bkappt_form.clinic_code,
						parent.f_query_add_mod.document.Bkappt_form.appt_date,
						parent.f_query_add_mod.document.Bkappt_form.patient_name1,
						parent.f_query_add_mod.document.Bkappt_form.sex
						);

		 names=new Array(getLabel("Common.clinic.label","Common")+""+getLabel("Common.code.label","Common"),
						getLabel("Common.apptdate.label","Common"),
						getLabel("Common.PatientName.label","Common"),
						getLabel("Common.gender.label","Common")
					
		
					);
	}
		var len=names.length;
		if(parent.f_query_add_mod.document.Bkappt_form.id1)
			{
			fields[len]=parent.f_query_add_mod.document.Bkappt_form.name_suffix;
			names[len]=parent.f_query_add_mod.document.Bkappt_form.Name_Suffix_Prompt.value;
			len=len+1;
			}

		if(parent.f_query_add_mod.document.Bkappt_form.id2)
			{
			fields[len]=parent.f_query_add_mod.document.Bkappt_form.name_prefix;
			names[len]=parent.f_query_add_mod.document.Bkappt_form.Name_Prefix_Prompt.value;
			len=len+1;
			}

		if(parent.f_query_add_mod.document.Bkappt_form.fid)
			{
			fields[len]=parent.f_query_add_mod.document.Bkappt_form.first_name;
			names[len]=parent.f_query_add_mod.document.Bkappt_form.First_Name_Prompt.value;
			len=len+1;
			}

		if(parent.f_query_add_mod.document.Bkappt_form.sid)
			{
			fields[len]=parent.f_query_add_mod.document.Bkappt_form.second_name;
			names[len]=parent.f_query_add_mod.document.Bkappt_form.Second_Name_Prompt.value;
			len=len+1;
			}

		if(parent.f_query_add_mod.document.Bkappt_form.tid)
			{
			fields[len]=parent.f_query_add_mod.document.Bkappt_form.third_name;
			names[len]=parent.f_query_add_mod.document.Bkappt_form.Third_Name_Prompt.value;
			len=len+1;
			}


		if(parent.f_query_add_mod.document.Bkappt_form.faid)
			{
			fields[len]=parent.f_query_add_mod.document.Bkappt_form.family_name;
			names[len]=parent.f_query_add_mod.document.Bkappt_form.Family_Name_Prompt.value;
			len=len+1;
			}

		if(toSubmit==true) {
		if(parent.frames[0].checkFields1( fields, names)) {
						var chk_man=false;
						var chk_pat=false;
						if(parent.frames[0].document.Bkappt_form.alcn_criteria.value != '' ){
								if(parent.frames[0].document.Bkappt_form.pat_cat.value==''){
								chk_man=false;
								}
								else{
								chk_man=true;
								}
						}else{
						chk_man=true;
						}

						if(chk_man){
						if(parent.frames[0].document.Bkappt_form.book_appt_wo_pid_yn.value=='N'){
						if(parent.frames[0].document.Bkappt_form.patient_id.value==''){
						chk_pat=false;
						}else{
						chk_pat=true;
						}
						}else{
						chk_pat=true;
						}
						}
						
						if(chk_man){
								if(chk_pat){
									if(parent.f_query_add_mod.document.Bkappt_form.from_wait_list.value =="Y")
									{
									parent.frames[0].document.Bkappt_form.visit_type_short_desc.disabled=false;
									}
								parent.frames[0].document.Bkappt_form.patient_id.disabled=false;
								if (parent.frames[0].document.Bkappt_form.pat_cat)
								parent.frames[0].document.Bkappt_form.pat_cat.disabled=false;
								if (parent.frames[0].document.Bkappt_form.nationality)
								parent.frames[0].document.Bkappt_form.nationality.disabled=false;
								parent.frames[0].document.Bkappt_form.no_slots.disabled=false;						
								enable_conrolls();
								if(parent.frames[0].document.forms[0].from_page.value !="")
									{
										parent.frames[0].document.forms[0].source.disabled=false;
									}
									var patientid=parent.frames[0].document.Bkappt_form.patient_id.value;
									var emailid=parent.frames[0].document.Bkappt_form.email.value;
									var email_appl_yn=parent.frames[0].document.Bkappt_form.email_appl_yn.value;
									var email_appl_for_appt_wo_pid_yn=parent.frames[0].document.Bkappt_form.email_appl_for_appt_wo_pid_yn.value;
									var pat_email_appl_yn;
									if(patientid!=""){
									var xmlDoc=  "" ;
									var xmlHttp= new XMLHttpRequest() ;

									xmlStr	="<root><SEARCH " ;
									xmlStr += "patient_id=\""+patientid+"\"  steps='emailvalidation'";
									xmlStr +=" /></root>" ;
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									
									xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
									xmlHttp.send(xmlDoc);
									responseText=xmlHttp.responseText;
									responseText = trimString(responseText);
									pat_email_appl_yn=responseText;
									parent.frames[0].document.Bkappt_form.pat_email_appl_yn.value=pat_email_appl_yn.charAt(0);
									if(email_appl_yn=="Y" && parent.frames[0].document.Bkappt_form.pat_email_appl_yn.value =="Y"){
										if(emailid!=""){
											parent.frames[0].document.Bkappt_form.send_email_yn.value="Y";
											parent.frames[0].document.Bkappt_form.action="../../servlet/eOA.BookAppointmentServlet";
											parent.frames[0].document.Bkappt_form.target="messageFrame";
											parent.frames[0].document.Bkappt_form.submit();
										}else{
											if(window.confirm(getMessage("EMAIL_CAPTURE_CONFIRM","OA"))){
												parent.frames[0].document.Bkappt_form.send_email_yn.value="N";
												parent.frames[0].document.Bkappt_form.action="../../servlet/eOA.BookAppointmentServlet";
												parent.frames[0].document.Bkappt_form.target="messageFrame";
												parent.frames[0].document.Bkappt_form.submit();
											}else{
												parent.frames[2].document.forms[0].Insupd.disabled=false;
												return;
											}
										}
									}else{
										parent.frames[0].document.Bkappt_form.send_email_yn.value="N";
										parent.frames[0].document.Bkappt_form.action="../../servlet/eOA.BookAppointmentServlet";

										parent.frames[0].document.Bkappt_form.target="SubmitFrame";
										
										parent.frames[0].document.Bkappt_form.submit();
									}
									}else{
										if(email_appl_for_appt_wo_pid_yn=="Y"){
											if(emailid!=""){
												parent.frames[0].document.Bkappt_form.send_email_yn.value="Y";
												parent.frames[0].document.Bkappt_form.action="../../servlet/eOA.BookAppointmentServlet";
												parent.frames[0].document.Bkappt_form.target="messageFrame";
												parent.frames[0].document.Bkappt_form.submit();
											}else{
												if(window.confirm(getMessage("EMAIL_CAPTURE_CONFIRM","OA"))){
													parent.frames[0].document.Bkappt_form.send_email_yn.value="N";
													parent.frames[0].document.Bkappt_form.action="../../servlet/eOA.BookAppointmentServlet";
													parent.frames[0].document.Bkappt_form.target="messageFrame";
													parent.frames[0].document.Bkappt_form.submit();
												}else{
													parent.frames[2].document.forms[0].Insupd.disabled=false;
													return;
												}
											}
										}else{
											parent.frames[0].document.Bkappt_form.send_email_yn.value="N";
											parent.frames[0].document.Bkappt_form.action="../../servlet/eOA.BookAppointmentServlet";
											parent.frames[0].document.Bkappt_form.target="messageFrame";
											parent.frames[0].document.Bkappt_form.submit();
										}
									}
								//parent.frames[0].document.Bkappt_form.submit();
								}
								else{ 
								alert(getMessage("INVALID_PATIENT","MP"));
								parent.frames[2].document.forms[0].Insupd.disabled=false;
								}
						}
						else{
							var error = getMessage('CAN_NOT_BE_BLANK','Common');
							//error = error.replace('$','Allocation Category');
							//alert(error);
							parent.frames[2].document.forms[0].Insupd.disabled=false;
						}
						var fn_status = parent.f_query_add_mod.document.Bkappt_form.function_name.value ;
				}
		}

}




function checkFields1( fields, names)
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {

		if(fields[i]){
			if(trimCheck1(fields[i].value)) {
				fields[i].value = trimString1(fields[i].value);
				
			}else{ 
				var err = getMessage('CAN_NOT_BE_BLANK','Common');
				err = err.replace('$',names[i]);
				errors = errors + err + "\n";
			}
		}
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

function trimCheck1(inString)
{
	var startPos;
	var ch;
	startPos = 0;
	strlength = inString.length;

	for(var i=0;i<=strlength;i++) {
		ch = inString.charAt(startPos);
		if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
			startPos++;
		}
	}
	if(startPos == inString.length) return false;
	else return true;
}

function trimString1(inString)
{
	var outString;
	var startPos;
	var endPos;
	var ch;

	// where do we start?
	startPos = 0;
	ch = inString.charAt(startPos);
	while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
		startPos++;
		ch = inString.charAt(startPos);
	}

	// where do we end?
	endPos = inString.length - 1;
	ch = inString.charAt(endPos);
	while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
		endPos--;
		ch = inString.charAt(endPos);
	}

	// get the string
	outString = inString.substring(startPos, endPos + 1);

	return outString;
}



function checkPatSex1()
{
	var arLength = parent.f_query_add_mod.NamePrefixArray.length;
	var q = 0;
	var res = new Boolean(false);

	while ( q <= arLength  )
	{
		
	if ( ( parent.f_query_add_mod.document.getElementById("name_prefix").value!='')  && ( unescape( parent.f_query_add_mod.NamePrefixArray[q]) ==  parent.f_query_add_mod.document.getElementById("name_prefix").value ) )
	{
		if ( parent.f_query_add_mod.PrefixSexArray[q] != parent.f_query_add_mod.document.Bkappt_form.sex.value &&  parent.f_query_add_mod.PrefixSexArray[q] != 'B') 
		{
			/*alert(parent.f_query_add_mod.document.getElementById("name_prefix").value)
			alert(parent.f_query_add_mod.PrefixSexArray[q])
			alert(parent.f_query_add_mod.document.Bkappt_form.sex.value);
			Her checking for gender
			*/
			var msg = parent.f_query_add_mod.getMessage("PATIENT_SEX_MISMATCH",'MP');

			if(localeName=='en')
			{
            msg = msg.replace('$',parent.f_query_add_mod.document.Bkappt_form.name_prefix_prompt.value);
			}
			else
			{
			msg = msg.replace('$',parent.f_query_add_mod.document.Bkappt_form.name_prefix_oth_prompt.value);
			}
			alert(msg);
		res = false;
		}
		else{ 
			res = true;
		}
	}
	q++;
	}
	return res;
}


function checkPatSuffixSex1()  {


    var arLength = parent.f_query_add_mod.NameSuffixArray.length;
    var q = 0;
    var res = new Boolean(false);

        while ( q <= arLength  )
        {
			if ( (parent.f_query_add_mod.document.Bkappt_form.name_suffix.value!='')  && ( unescape(parent.f_query_add_mod.NameSuffixArray[q]) == parent.f_query_add_mod.document.Bkappt_form.name_suffix.value ) )

            {
              if(parent.f_query_add_mod.SuffixSexArray[q] != parent.f_query_add_mod.document.Bkappt_form.sex.value && parent.f_query_add_mod.SuffixSexArray[q] != 'B')

                {
					var msg = parent.f_query_add_mod.getMessage("PATIENT_SEX_MISMATCH",'MP');
					
					if(localeName=='en')
					{
                    msg = msg.replace('$',parent.f_query_add_mod.document.Bkappt_form.name_suffix_prompt.value);
					}
					else
					{
					 msg = msg.replace('$',parent.f_query_add_mod.document.Bkappt_form.name_suffix_oth_prompt.value);
					}
				
					alert(msg);
					res = false;
               }
               else
                   res = true;
            }
            q++;
       }
    return res;
}



function disableEnableDate()	
{
	if ( document.getElementById("age_or_dob").checked == true )
	{
		document.getElementById("b_age").disabled = false;
		document.getElementById("b_months").disabled = false;
		document.getElementById("b_days").disabled = false;
		document.getElementById("date_of_birth").readOnly = true;
	}
	else if ( document.getElementById("age_or_dob").checked == false )
	{
		document.getElementById("b_age").disabled = true;
		document.getElementById("b_months").disabled = true;
		document.getElementById("b_days").disabled = true;
		document.getElementById("date_of_birth").disabled = false;
	}
}



async function validate_allocation_criteria()
{
	parent.frames[0].document.Bkappt_form.entered.value='N';
	parent.frames[2].document.forms[0].Insupd.disabled=true;
	var sec_sel=parent.frames[0].document.Bkappt_form.sec_sel.value;
	
	var secc_sel=sec_sel;
	var tmp_str="";
	var flg="F";
	var pat_name_flag=false;
	if(sec_sel !='')
	{// not work
	   var sec_arr=sec_sel.split("@");
	   var sec_arr33=sec_sel.split("@");
	   for(var i=0;i<sec_arr.length;i++){
		   var sec_arr1=sec_arr[i].split(",");		
		   if(sec_arr1.length==10){
			   flg="T";
			   if(sec_arr1[9]=='Y'){
				   tmp_str=tmp_str+sec_arr33[i].substring(0,sec_arr33[i].length-2)+"@";
				}
		   }
	   }
	   if(flg=="T"){
		   parent.frames[0].document.Bkappt_form.sec_sel222.value=tmp_str;
	   }else{
		   parent.frames[0].document.Bkappt_form.sec_sel222.value='';
	   }
	}
	
	
	var pat_secur=	parent.frames[0].document.Bkappt_form.patient_SecurityLevel.value;
	var clinic_secur=	parent.frames[0].document.Bkappt_form.clinic_securityLevel.value;
	var secur_level='0';
	
	if(parseInt(pat_secur)>parseInt(clinic_secur))
	{
	
		secur_level=pat_secur;
	}else{
//	alert("secur_level  "+secur_level)
		secur_level=clinic_secur;
	}
	parent.frames[0].document.Bkappt_form.SecurityLevel.value=secur_level;
	var allow_next=false;
	var patient_id=parent.frames[0].document.Bkappt_form.patient_id.value;
	var ccode=parent.frames[0].document.Bkappt_form.clinic_code.value;
	var practitioner_id=parent.frames[0].document.Bkappt_form.practitioner_id.value;
	var appt_date=parent.frames[0].document.Bkappt_form.appt_date.value;
	var book_appt_across_catg_yn=parent.frames[0].document.Bkappt_form.book_appt_across_catg_yn.value;
	var pat_cat='';
	var overbooked=parent.frames[0].document.Bkappt_form.overbooked.value;
	var from_time=parent.frames[0].document.Bkappt_form.From_timeval.value;
	var to_time=parent.frames[0].document.Bkappt_form.To_timeval.value;
	var no_slots=parent.frames[0].document.Bkappt_form.no_slots.value;
	var time_table_type=parent.frames[0].document.Bkappt_form.time_table_type.value;
	var visit_type_short_desc=parent.frames[0].document.Bkappt_form.visit_type_short_desc.value;
	strVisitArray = visit_type_short_desc.split("~");
	var visit_type_short=strVisitArray[0];
	var visit_type_ind=strVisitArray[1];
	var startarray;
	var endarray;
	var fromarray;
	var toarray;
	parent.f_query_add_mod.document.Bkappt_form.gen.value=parent.f_query_add_mod.document.Bkappt_form.sex.value;
	var toSubmit = new Boolean();
	toSubmit=true;
	

	if(parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && visit_type_ind!="F"){
		parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=false;
		parent.f_query_add_mod.document.Bkappt_form.search.disabled=false;
	}
	if(visit_type_ind !="F" && parent.f_query_add_mod.document.Bkappt_form.source.value !="" ){
		var err_from=getMessage("FIRST_VISIT_REFERRAL","OA");
		if(parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && visit_type_ind!="F"){//Added on 15/03/2010 by Sudhakar for IN019814
			parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
		}
		alert(err_from);
		parent.frames[2].document.forms[0].Insupd.disabled=false;
		toSubmit=false;
		return false;
	}
	if(toSubmit){
		if(parent.frames[0].document.forms[0].bl_success.value=='N'){
			if(parent.frames[0].document.forms[0].bl_operational.value == 'Y' && parent.frames[0].document.forms[0].capture_fin_dtls_yn.value == 'Y'){
				alert(getMessage("FINANCIAL_DET_MANDATORY","MP"));
				parent.frames[2].document.forms[0].Insupd.disabled=false;
				toSubmit=false; 
				return false;
			}else{
				toSubmit=true;
			}
		}
	}
	if(parent.frames[0].document.forms[0].alt_id1_exp_date){
		if(parent.frames[0].document.forms[0].alt_id1_exp_date.value != ''){
			if(! checkDt(parent.frames[0].document.forms[0].alt_id1_exp_date.value)){
				var err_from =getMessage("INVALID_DATE_FMT","SM") ;
				alert(err_from);
				parent.frames[0].document.forms[0].alt_id1_exp_date.focus();
				parent.frames[2].document.forms[0].Insupd.disabled=false;
				toSubmit=false;
				return false;
			}
		}	
	}
	if(parent.frames[0].document.forms[0].alt_id2_exp_date){
		if(parent.frames[0].document.forms[0].alt_id2_exp_date.value != ''){
			if(! checkDt(parent.frames[0].document.forms[0].alt_id2_exp_date.value)){
				var err_from =getMessage("INVALID_DATE_FMT","SM") ;
				alert(err_from);
				parent.frames[0].document.forms[0].alt_id2_exp_date.focus();
				parent.frames[2].document.forms[0].Insupd.disabled=false;
				toSubmit=false;
				return false;
			}
		}
	}
	if(parent.frames[0].document.forms[0].alt_id3_exp_date){
		if(parent.frames[0].document.forms[0].alt_id3_exp_date.value != ''){
			if(! checkDt(parent.frames[0].document.forms[0].alt_id3_exp_date.value)){
				var err_from =getMessage("INVALID_DATE_FMT","SM") ;
				alert(err_from);
				parent.frames[0].document.forms[0].alt_id3_exp_date.focus();
				parent.frames[2].document.forms[0].Insupd.disabled=false;
				toSubmit=false;
				return false;
			}
		}
	}
	if(parent.frames[0].document.forms[0].alt_id4_exp_date){
		if(parent.frames[0].document.forms[0].alt_id4_exp_date.value != ''){
			if(! checkDt(parent.frames[0].document.forms[0].alt_id4_exp_date.value)){
				var err_from =getMessage("INVALID_DATE_FMT","SM") ;
				alert(err_from);
				parent.frames[0].document.forms[0].alt_id4_exp_date.focus();
				parent.frames[2].document.forms[0].Insupd.disabled=false;
				toSubmit=false;
				return false;
			}
		}
	}
	if((parent.frames[0].document.forms[0].time_table_type.value=="3") && (parent.frames[0].document.forms[0].From_timeval.value=='')){
		var err_from =getMessage("APPT_FROM_TIME_BLANK","OA") ;
		alert(err_from);
		toSubmit=false;
		parent.frames[2].document.forms[0].Insupd.disabled=false;
	}
	if((parent.frames[0].document.forms[0].time_table_type.value=="3") && (parent.frames[0].document.forms[0].To_timeval.value== '')){
		var err_to =getMessage("APPT_TO_TIME_BLANK","OA") ;
		alert(err_to);
		toSubmit=false;
		parent.frames[2].document.forms[0].Insupd.disabled=false;
	}
	if (parent.f_query_add_mod.document.Bkappt_form.name_prefix != null){
		if (parent.f_query_add_mod.document.Bkappt_form.name_prefix.value.length != 0){
			parent.f_query_add_mod.document.Bkappt_form.entered.value='Y';
			canSave = checkPatSex1();
			if ( canSave == false )
				toSubmit = false;
			parent.frames[2].document.forms[0].Insupd.disabled=false;
		}
	}
	// Modified against PMG20089-CRF-0885.3 - Removed the PatientID Validations on booking Radiology Appointment :
	var rd_appt_yn = parent.f_query_add_mod.document.Bkappt_form.rd_appt_yn.value;
	var patientid = parent.frames[0].document.forms[0].patient_id.value;
	if( (("Y" == rd_appt_yn) && (patientid != "")) || (rd_appt_yn == "N") )
	{
		if(document.forms[0].or_catalogue_code.value!="" && parent.frames[0].document.forms[0].patient_id.value==""){
			var err_to =getMessage("APPT_WITHOUT_PAT_ID_ORDER_CAT","OA") ;
			toSubmit = false;
			alert(err_to);
			parent.frames[2].document.forms[0].Insupd.disabled=false;
			return false;
		}
	}
	var pref_date_greg=convertDate(parent.frames[0].document.Bkappt_form.pref_date.value,"DMY",localeName,"en");
	var starttime=parent.frames[0].document.forms[0].starttime.value;
	var endtime=parent.frames[0].document.forms[0].endtime.value;
	var fromtime=parent.frames[0].document.forms[0].From_timeval.value;
	var totime=parent.frames[0].document.forms[0].To_timeval.value;
	if(starttime.length >0 || endtime.length >0 || fromtime.lenght>0 || totime.length>0){
		startarray=starttime.split(":");
		endarray=endtime.split(":");
		fromarray=fromtime.split(":");
		toarray=totime.split(":");
		var starttm=new Date(1,1,1,startarray[0],startarray[1],0,0);
		var endtm=new Date(1,1,1,endarray[0],endarray[1],0,0);
		var fromtm=new Date(1,1,1,fromarray[0],fromarray[1],0,0);
		var totm=new Date(1,1,1,toarray[0],toarray[1],0,0);
		if( (Date.parse(fromtm) < Date.parse(starttm) ) || ( Date.parse(fromtm) > Date.parse(endtm)) ){
			var err_from1 =getMessage("FM_TM_NOT_VALID","OA") ;
			alert(err_from1);
			parent.frames[0].document.forms[0].From_timeval.select();
			parent.frames[0].document.forms[0].From_timeval.focus();
			toSubmit=false;
			parent.frames[2].document.forms[0].Insupd.disabled=false;
		}else if((Date.parse(totm) < Date.parse(starttm)) || (Date.parse(totm) > Date.parse(endtm))) {
			var err_to1 =getMessage("TO_TM_NOT_VALID","OA") ;
			alert(err_to1);
			parent.frames[0].document.forms[0].To_timeval.select();
			parent.frames[0].document.forms[0].To_timeval.focus();
			toSubmit=false;
			parent.frames[2].document.forms[0].Insupd.disabled=false;
		}else if(Date.parse(fromtm) > Date.parse(totm)) {
			var err_ch =getMessage("FM_TIME_GR_TO_TIME","Common") ;
			alert(err_ch);
			parent.frames[0].document.forms[0].From_timeval.select();
			parent.frames[0].document.forms[0].From_timeval.focus();
			toSubmit=false;
			parent.frames[2].document.forms[0].Insupd.disabled=false;
		}else if(Date.parse(totm) < Date.parse(fromtm)) {
			var err_ch1 =getMessage("TO_TIME_LESS_FM_TIME","Common") ;
			alert(err_ch1);
			parent.frames[0].document.forms[0].To_timeval.select();
			parent.frames[0].document.forms[0].To_timeval.focus();
			toSubmit=false;
			parent.frames[2].document.forms[0].Insupd.disabled=false;
		}
	}
	if (toSubmit && document.forms[0].time_table_type.value=='3'){
		var currDate=document.forms[0].CurrentDate.value;
		var currDateArr=currDate.split('/');
		var givenDate=document.forms[0].apptdate.value;
		var givenDateArr=givenDate.split('/');
		var givenTime=document.forms[0].From_timeval.value;
		var curDate1 = new Date(currDateArr[2],parseInt(currDateArr[1])-1,currDateArr[0],0,0);
		var givenDate1= new Date(givenDateArr[2],parseInt(givenDateArr[1])-1,givenDateArr[0],0,0);
		if (Date.parse(curDate1)==Date.parse(givenDate1)){ 
			var xmlDoc= "" ;
			var xmlHttp= new XMLHttpRequest() ;
			xmlStr	="<root><SEARCH " ;
			xmlStr += "Time=\"" +givenTime + "\" steps='validateTime'";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);
			if (v_Flag==1){
				alert(getMessage("FR_TIME_CAN_NOT_SYS_TIME","OA"));
				document.forms[0].From_timeval.value="";
				document.forms[0].From_timeval.focus();
				toSubmit=false;
				parent.frames[2].document.forms[0].Insupd.disabled=false;
			}
			if (toSubmit){
				givenTime=document.forms[0].To_timeval.value;
				var xmlDoc= "" ;
				var xmlHttp= new XMLHttpRequest() ;
				xmlStr	="<root><SEARCH " ;
				xmlStr += "Time=\"" +givenTime + "\" steps='validateTime'";
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				
				responseText = trimString(responseText);
				eval(responseText);
				if (v_Flag==1){
					alert(getMessage("FR_TIME_CAN_NOT_SYS_TIME","OA"));
					document.forms[0].To_timeval.value="";
					document.forms[0].To_timeval.focus();
					toSubmit=false;
				}
			}
		}
	}
	var u=parent.frames[0].document.forms[0].visit_type_short_desc.value;
	strVisitArray = u.split("~");
	var u1=strVisitArray[0];
	var u2=strVisitArray[1];
	if((parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=="CA" && parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && parent.f_query_add_mod.document.Bkappt_form.ca_patient_id_new.value !="" && u2=="F" && parent.f_query_add_mod.document.Bkappt_form.source.value =="") || ( parent.f_query_add_mod.document.Bkappt_form.waitListNo.value !="" && u2=="F" && parent.f_query_add_mod.document.Bkappt_form.source.value =="" && parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N")){
		alert(getMessage("REFERRAL_FIRST_VISIT","OA"));
		toSubmit=false;
		parent.frames[2].document.forms[0].Insupd.disabled=false;
	}
	var patient_id =parent.frames[0].document.Bkappt_form.patient_id.value;
	var referral_id = parent.frames[0].document.Bkappt_form.source.value;
	var slot_appt_ctrl = parent.frames[0].document.Bkappt_form.slot_appt_ctrl.value;
	var i="";
	var names="";
	var fields="";
	//alert("parent.f_query_add_mod.document.Bkappt_form.date_of_birth-->"+parent.f_query_add_mod.document.Bkappt_form.date_of_birth.value);	
	
	if(document.forms[0].from_wait_list.value =="N"){ 		
		fields= new Array(  parent.f_query_add_mod.document.Bkappt_form.clinic_code,
							parent.f_query_add_mod.document.Bkappt_form.appt_date,
							parent.f_query_add_mod.document.Bkappt_form.patient_name1,
							parent.f_query_add_mod.document.Bkappt_form.sex,
							parent.f_query_add_mod.document.Bkappt_form.visit_type_short_desc,
							parent.f_query_add_mod.document.Bkappt_form.date_of_birth,
							parent.f_query_add_mod.document.Bkappt_form.reason_for_contact
							);
		names=new Array(	getLabel("Common.clinic.label","Common"),
							getLabel("Common.apptdate.label","Common"),
							getLabel("Common.PatientName.label","Common"),
							getLabel("Common.gender.label","Common"),
							getLabel("Common.visittype.label","Common"),
							getLabel("Common.birthDate.label","Common"),
							getLabel("Common.ReasonForContact.label","Common")
							);

		 i=8;

	}else{
		fields= new Array(	parent.f_query_add_mod.document.Bkappt_form.clinic_code,
								parent.f_query_add_mod.document.Bkappt_form.appt_date,
								parent.f_query_add_mod.document.Bkappt_form.patient_name1,
								parent.f_query_add_mod.document.Bkappt_form.sex,
								parent.f_query_add_mod.document.Bkappt_form.visit_type_short_desc, //Have to check from Manage wait list 
								parent.f_query_add_mod.document.Bkappt_form.date_of_birth,
								parent.f_query_add_mod.document.Bkappt_form.reason_for_contact
								);
				
		names=new Array(	getLabel("Common.clinic.label","Common"),
								getLabel("Common.apptdate.label","Common"),
								getLabel("Common.PatientName.label","Common"),
								getLabel("Common.gender.label","Common"),
								getLabel("Common.visittype.label","Common"),
								getLabel("Common.birthDate.label","Common"),
								getLabel("Common.ReasonForContact.label","Common")		 
							);
			i=8;
	}
	
	if(parent.f_query_add_mod.document.Bkappt_form.pre_admit_order_catalog_code.value!=''){
			fields[i]=parent.f_query_add_mod.document.Bkappt_form.patient_id;
			names[i]=getLabel("Common.patientId.label","Common");
			i++;
	}
	if(parent.f_query_add_mod.document.Bkappt_form.tmpCntrl){
		if(parent.f_query_add_mod.document.Bkappt_form.no_slots.value==''){
			fields[i]=parent.f_query_add_mod.document.Bkappt_form.no_slots;
			names[i]=getLabel("eOA.NoofSlots.label","OA");
			i++;
		}
	}
	if(parent.f_query_add_mod.document.Bkappt_form.or_catalogue_code.value != ""){
		if(parent.f_query_add_mod.document.Bkappt_form.ordPractDesc.value==''){
			fields[i]=parent.f_query_add_mod.document.Bkappt_form.ordPractDesc;
			names[i]=getLabel("Common.OrderingPractitioner.label","Common");
			i++;
		}
	}
	
	/*Below line added for this CRF GHL-CRF-0332 [IN:042060]*/ 						
			if(parent.f_query_add_mod.document.getElementById("alt_id1_reqd_yn").value == 'Y' && parent.f_query_add_mod.document.getElementById("alt_id1_man_non_ctz") && parent.f_query_add_mod.document.getElementById("alt_id1_man_non_ctz").value=="true")
			{
				if(parent.f_query_add_mod.document.getElementById("alt1_gif").style.visibility == 'visible') {	

					if(parent.f_query_add_mod.document.getElementById("alt_id1_no").value=="")
					{
						 fields[i]=parent.f_query_add_mod.document.getElementById("alt_id1_no");
						 names[i]=parent.f_query_add_mod.document.getElementById("alt_id1_desc").value
						 i++;
					}		 
				}
				
				
			}
			
			if(parent.f_query_add_mod.document.getElementById("alt_date1_reqd_yn").value == 'Y' && parent.f_query_add_mod.document.getElementById("alt_id1_man_non_ctz") && parent.f_query_add_mod.document.getElementById("alt_id1_man_non_ctz").value=="true")
			{
				if(parent.f_query_add_mod.document.getElementById("alt1_exp_date1").style.visibility == 'visible') {
					if(parent.f_query_add_mod.document.getElementById("altidexpdate1").value=="")
					{						
						 fields[i]=parent.f_query_add_mod.document.getElementById("altidexpdate1");
						 names[i]=getLabel('Common.expiryDate.label','common');
						 i++;
					   
					}		 
				}
				
			}
			
          //End this CRF GHL-CRF-0332 [IN:042060]		
	
	
	
	
	if (document.forms[0].from_wait_list.value=="Y"){
		if(document.getElementById("eth_gif").style.visibility=='visible'){
			/*
			if(parent.f_query_add_mod.document.Bkappt_form.race_code.value==''){
				fields[i]=parent.f_query_add_mod.document.Bkappt_form.race_code;
				names[i]=getLabel("Common.race.label","Common");
				i++;
			}
			*/
			if(parent.f_query_add_mod.document.Bkappt_form.race_desc.value==''){
				fields[i]=parent.f_query_add_mod.document.Bkappt_form.race_desc;
				names[i]=getLabel("Common.race.label","Common");
				i++;
			}
		}
	}else{
		if(parent.f_query_add_mod.document.getElementById("race_required_yn").value == 'Y'){			
				
				if(parent.f_query_add_mod.document.getElementById("race_desc").value==""){							
						fields[i]=parent.f_query_add_mod.document.Bkappt_form.race_desc;
						names[i]=getLabel("Common.race.label","Common");
						i++;		
				}
			
		}
	}
	if(parent.f_query_add_mod.document.Bkappt_form.sec_req.value!=''){
		var xx1=parent.f_query_add_mod.document.Bkappt_form.sec_req.value;
		if(xx1.indexOf("Y")>0){
			fields[i]=parent.f_query_add_mod.document.Bkappt_form.sec_sel;
			names[i]=getLabel("eOA.SecondaryResources.label","OA");
			i++;		
		}
	}
	if(parent.f_query_add_mod.document.Bkappt_form.name_prefix_reqd_yn){
		if(parent.f_query_add_mod.document.Bkappt_form.name_prefix_reqd_yn.value =='Y' ){
			if(parent.f_query_add_mod.document.Bkappt_form.name_prefix.value==''){
				fields[i]=parent.f_query_add_mod.document.Bkappt_form.name_prefix;
				names[i]=parent.f_query_add_mod.document.Bkappt_form.Name_Prefix_Prompt.value;
				i++;
			}
		}
	}
	if(parent.f_query_add_mod.document.Bkappt_form.first_name_reqd_yn){
		if(parent.f_query_add_mod.document.Bkappt_form.first_name_reqd_yn.value =='Y' ){
			if(parent.f_query_add_mod.document.Bkappt_form.first_name.value==''){
				parent.f_query_add_mod.document.Bkappt_form.first_name.value=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				parent.f_query_add_mod.document.Bkappt_form.patient_name.value +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				parent.frames[0].document.getElementById("patient_name1").innerHTML +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				pat_name_flag=true;

				if(parent.f_query_add_mod.document.Bkappt_form.first_name.value==''){
	
					fields[i]=parent.f_query_add_mod.document.Bkappt_form.first_name;
					names[i]=parent.f_query_add_mod.document.Bkappt_form.First_Name_Prompt.value;
					i++;
				}
			}

		}
	}
	if(parent.f_query_add_mod.document.Bkappt_form.second_name_reqd_yn){
		if(parent.f_query_add_mod.document.Bkappt_form.second_name_reqd_yn.value =='Y' ){
			if(parent.f_query_add_mod.document.Bkappt_form.second_name.value==''){
				//fields[i]=
				parent.f_query_add_mod.document.Bkappt_form.second_name.value=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				parent.f_query_add_mod.document.Bkappt_form.patient_name.value +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				parent.frames[0].document.getElementById("patient_name1").innerHTML +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				pat_name_flag=true;
				if(parent.f_query_add_mod.document.Bkappt_form.second_name.value==''){
	
					fields[i]=parent.f_query_add_mod.document.Bkappt_form.second_name;
					names[i]=parent.f_query_add_mod.document.Bkappt_form.Second_Name_Prompt.value;
					i++;
				}
			}
		}
	}
	if(parent.f_query_add_mod.document.Bkappt_form.third_name_reqd_yn){
		if(parent.f_query_add_mod.document.Bkappt_form.third_name_reqd_yn.value =='Y' ){
			if(parent.f_query_add_mod.document.Bkappt_form.third_name.value==''){
				//			fields[i]=
				parent.f_query_add_mod.document.Bkappt_form.third_name.value=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				parent.f_query_add_mod.document.Bkappt_form.patient_name.value +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				parent.frames[0].document.getElementById("patient_name1").innerHTML +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				pat_name_flag=true;
				if(parent.f_query_add_mod.document.Bkappt_form.third_name.value==''){
	
					fields[i]=parent.f_query_add_mod.document.Bkappt_form.third_name;
					names[i]=parent.f_query_add_mod.document.Bkappt_form.Third_Name_Prompt.value;
					i++;
				}
			}
		}
	}
	if(parent.f_query_add_mod.document.Bkappt_form.family_name_reqd_yn){
		if(parent.f_query_add_mod.document.Bkappt_form.family_name_reqd_yn.value =='Y' ){
			if(parent.f_query_add_mod.document.Bkappt_form.family_name.value==''){
				///fields[i]=
				parent.f_query_add_mod.document.Bkappt_form.family_name.value=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				parent.f_query_add_mod.document.Bkappt_form.patient_name.value +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				parent.frames[0].document.getElementById("patient_name1").innerHTML +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				pat_name_flag=true;
				if(parent.f_query_add_mod.document.Bkappt_form.family_name.value==''){
	
					fields[i]=parent.f_query_add_mod.document.Bkappt_form.family_name;
					names[i]=parent.f_query_add_mod.document.Bkappt_form.Family_Name_Prompt.value;
					i++;
				}
			}
		}
	}
	if(parent.f_query_add_mod.document.Bkappt_form.name_suffix_reqd_yn){
		if(parent.f_query_add_mod.document.Bkappt_form.name_suffix_reqd_yn.value =='Y' ){
			if(parent.f_query_add_mod.document.Bkappt_form.name_suffix.value==''){
				fields[i]=parent.f_query_add_mod.document.Bkappt_form.name_suffix;
				names[i]=parent.f_query_add_mod.document.Bkappt_form.Name_Suffix_Prompt.value;
				i++;
			}
		}
	}
	/***************oth lang changes starts hre *********************/
	if(parent.f_query_add_mod.document.Bkappt_form.name_prefix_oth){
		if(parent.f_query_add_mod.document.Bkappt_form.name_prefix_oth.style.visibility == 'visible' ){
			if(parent.f_query_add_mod.document.Bkappt_form.name_prefix_oth_lang != null && parent.f_query_add_mod.document.Bkappt_form.name_prefix_oth_lang.disabled ==false){
				fields[i]=parent.f_query_add_mod.document.Bkappt_form.name_prefix_oth_prompt;
				names[i]=parent.f_query_add_mod.document.Bkappt_form.name_prefix_oth_lang.value;
				i++;
			}else{
				if(parent.frames[0].document.forms[0].name_prefix_oth_lang){
					parent.f_query_add_mod.document.Bkappt_form.name_prefix_oth_lang.disabled=false;
				}
			}
		}
	}
	if(parent.f_query_add_mod.document.Bkappt_form.first_oth_name_reqd_yn){
		if(parent.f_query_add_mod.document.Bkappt_form.first_oth_name_reqd_yn.style.visibility == 'visible' ){
			if(parent.f_query_add_mod.document.Bkappt_form.first_name_oth_lang != null && parent.f_query_add_mod.document.Bkappt_form.first_name_oth_lang.disabled ==false){
				fields[i]=parent.f_query_add_mod.document.Bkappt_form.first_name_oth_prompt;
				names[i]=parent.f_query_add_mod.document.Bkappt_form.first_name_oth_lang.value;
				parent.f_query_add_mod.document.Bkappt_form.patient_name_local_lang.value +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				parent.f_query_add_mod.document.Bkappt_form.patient_name_local_lang1.innerHTML +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				i++;
			}else{
				parent.f_query_add_mod.document.Bkappt_form.first_name_oth_lang.disabled=false;
			}
		}
	}
	if(parent.f_query_add_mod.document.Bkappt_form.second_oth_name_reqd_yn){
		if(parent.f_query_add_mod.document.Bkappt_form.second_oth_name_reqd_yn.style.visibility == 'visible' ){
			if(parent.f_query_add_mod.document.Bkappt_form.second_name_oth_lang != null && parent.f_query_add_mod.document.Bkappt_form.second_name_oth_lang.disabled ==false){
				fields[i]=parent.f_query_add_mod.document.Bkappt_form.second_name_oth_prompt;
				names[i]=parent.f_query_add_mod.document.Bkappt_form.second_name_oth_lang.value;
				parent.f_query_add_mod.document.Bkappt_form.patient_name_local_lang.value +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				parent.f_query_add_mod.document.Bkappt_form.patient_name_local_lang1.innerHTML +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				i++;
			}else{
				parent.f_query_add_mod.document.Bkappt_form.second_name_oth_lang.disabled=false;
			}
		}
	}
	if(parent.f_query_add_mod.document.Bkappt_form.third_oth_name_reqd_yn){
		if(parent.f_query_add_mod.document.Bkappt_form.third_oth_name_reqd_yn.style.visibility == 'visible' ){
			if(parent.f_query_add_mod.document.Bkappt_form.third_name_oth_lang != null && parent.f_query_add_mod.document.Bkappt_form.third_name_oth_lang.disabled ==false){
				fields[i]=parent.f_query_add_mod.document.Bkappt_form.third_name_oth_prompt;
				names[i]=parent.f_query_add_mod.document.Bkappt_form.third_name_oth_lang.value;
				parent.f_query_add_mod.document.Bkappt_form.patient_name_local_lang.value +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				parent.f_query_add_mod.document.Bkappt_form.patient_name_local_lang1.innerHTML +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				i++;
			}else{
				parent.f_query_add_mod.document.Bkappt_form.third_name_oth_lang.disabled=false;
			}
		}
	}
	if(parent.f_query_add_mod.document.Bkappt_form.family_oth_name_reqd_yn ){
		if(parent.f_query_add_mod.document.Bkappt_form.family_oth_name_reqd_yn.style.visibility == 'visible' ){
			if(parent.f_query_add_mod.document.Bkappt_form.family_name_oth_lang != null && parent.f_query_add_mod.document.Bkappt_form.family_name_oth_lang.disabled ==false){
				fields[i]=parent.f_query_add_mod.document.Bkappt_form.family_name_oth_prompt;
				names[i]=parent.f_query_add_mod.document.Bkappt_form.family_name_oth_lang.value;
				parent.f_query_add_mod.document.Bkappt_form.patient_name_local_lang.value +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				parent.f_query_add_mod.document.Bkappt_form.patient_name_local_lang1.innerHTML +=parent.f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				i++;
			}else{
				parent.f_query_add_mod.document.Bkappt_form.family_name_oth_lang.disabled=false;
			}
		}
	}
	if(parent.f_query_add_mod.document.Bkappt_form.name_suffix_oth ){
		if(parent.f_query_add_mod.document.Bkappt_form.name_suffix_oth.style.visibility == 'visible' ){
			if(parent.f_query_add_mod.document.Bkappt_form.name_suffix_oth_lang != null && parent.f_query_add_mod.document.Bkappt_form.name_suffix_oth_lang.disabled ==false){
				fields[i]=parent.f_query_add_mod.document.Bkappt_form.name_suffix_oth_prompt;
				names[i]=parent.f_query_add_mod.document.Bkappt_form.name_suffix_oth_lang.value;
				i++;
			}
		}
	}
	if(parent.frames[0].document.Bkappt_form.pref_date.value!=""){
		var clinic_code= parent.f_query_add_mod.document.Bkappt_form.clinic_code.value;
		var pract_id=parent.frames[0].document.Bkappt_form.practitioner_id.value;
		var date_val=pref_date_greg;	
		var xmlDoc= "" ;
		var xmlHttp= new XMLHttpRequest() ;
		xmlStr	="<root><SEARCH " ;
		xmlStr += "locncode=\""+clinic_code+"\" practid=\""+pract_id+"\" date_val=\""+date_val+"\" steps='validatepref_date'";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
		if(wtlt_Flag==1){
			var error=getMessage( "WAIT_LIST_NOT_ALLW","OA");
			alert(error);
			toSubmit=false;
			parent.frames[0].document.Bkappt_form.pref_date.value="";
			parent.frames[0].document.Bkappt_form.priorty.value="";
			/*Added by Sathish.S for IN020163 on Monday, March 22, 2010 Starts here*/
			parent.frames[0].document.Bkappt_form.prior.style.visibility='hidden';			
			parent.frames[0].document.Bkappt_form.visit_type_short_desc.options.selectedIndex=0;
			parent.frames[0].document.Bkappt_form.sel_service_code.options.selectedIndex=0;
			/*Ends here*/
			clearAll1();
			toSubmit=false;
			
		}else{
			toSubmit=true;
			}
	}

	if(parent.frames[0].document.Bkappt_form.patient_id.value!="" ){
		var xmlDoc= "" ;
		var xmlHttp= new XMLHttpRequest() ;
		xmlStr	="<root><SEARCH " ;
		xmlStr += "patient_id=\""+patient_id+"\"  steps='chk_unknown_patient'";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
		if (flag ==true){
		toSubmit=true;
		}else{
			var error=getMessage( "NOT_KNOWN_PATIENT","AE");
			alert(error);
			clearAll1();
			toSubmit=false;
			
		}
		if(toSubmit ==true){
			if(flag1==true){
				toSubmit=true;
			}else{
				var error=getMessage( "OP_EMERG_PAT_NOT_ALLOWED","OP");
				alert(error);
				clearAll1();
				toSubmit=false;			
			}
		}
		var xmlDoc= "" ;
		var xmlHttp= new XMLHttpRequest() ;
		var appt_date=parent.f_query_add_mod.document.Bkappt_form.appt_date.value;
		var noshow_ctrl_by_splty_or_clinic=parent.f_query_add_mod.document.Bkappt_form.noshow_ctrl_by_splty_or_clinic.value;
		var min_ela_per_resc_noshow_in_day=parent.f_query_add_mod.document.Bkappt_form.min_ela_per_resc_noshow_in_day.value;
		var p_speciality_code=parent.f_query_add_mod.document.Bkappt_form.speciality_code.value;
		xmlStr	="<root><SEARCH " ;
		xmlStr += "patient_id=\""+patient_id+"\" appt_to_date=\""+appt_date+"\" clinic_code=\""+parent.f_query_add_mod.document.Bkappt_form.clinic_code.value+"\" min_ela_per_resc_noshow_in_day=\""+min_ela_per_resc_noshow_in_day+"\" noshow_ctrl_by_splty_or_clinic=\""+noshow_ctrl_by_splty_or_clinic+"\" p_speciality_code=\""+p_speciality_code+"\" steps='chk_noshow_appt'";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);	
		if(flag1==false){
			var error=getMessage("NO_SHOW_OA_PARAM","OA");
			error = error.replace('$',min_ela_per_resc_noshow_in_day);
			alert(error);
			clearAll1();
			toSubmit=false;
		}
	}
	if(toSubmit==true){
		if(parent.frames[0].document.Bkappt_form.contact1_no.value=="" && parent.frames[0].document.Bkappt_form.contact_num_reqd_yn.value=="Y"){
			var error=getMessage("CONTACT_NUM_REC_MAN","OA");
			alert(error);
			toSubmit=false;
			parent.frames[2].document.forms[0].Insupd.disabled=false;
		}		
	}
	/***************oth lang changes ends hre *********************/

	if(parent.f_query_add_mod.document.Bkappt_form.pref_date.value!=''){
		fields[i]=parent.f_query_add_mod.document.Bkappt_form.priorty;
		names[i]=getLabel("Common.priority.label","Common");
		i++;
	}
	if(parent.f_query_add_mod.document.Bkappt_form.nationality_desc.value==''){
		parent.f_query_add_mod.document.Bkappt_form.nationality_code1.value='';
	}

	if(parent.f_query_add_mod.document.Bkappt_form.nat_gif_yn.value='Y'){
		fields[i]=parent.f_query_add_mod.document.Bkappt_form.nationality_code1;
		names[i]=getLabel("Common.nationality.label","Common");
		i++;
	}
	var len=names.length;
	if(parent.f_query_add_mod.document.Bkappt_form.id1){
		fields[len]=parent.f_query_add_mod.document.Bkappt_form.name_suffix;
		names[len]=parent.f_query_add_mod.document.Bkappt_form.Name_Suffix_Prompt.value;
		len=len+1;
	}
	if(parent.f_query_add_mod.document.Bkappt_form.id2){
		fields[len]=parent.f_query_add_mod.document.Bkappt_form.name_prefix;
		names[len]=parent.f_query_add_mod.document.Bkappt_form.Name_Prefix_Prompt.value;
		len=len+1;
	}
	if(parent.f_query_add_mod.document.Bkappt_form.fid){
		fields[len]=parent.f_query_add_mod.document.Bkappt_form.first_name;
		names[len]=parent.f_query_add_mod.document.Bkappt_form.First_Name_Prompt.value;
		len=len+1;
	}
	if(parent.f_query_add_mod.document.Bkappt_form.sid){
		fields[len]=parent.f_query_add_mod.document.Bkappt_form.second_name;
		names[len]=parent.f_query_add_mod.document.Bkappt_form.Second_Name_Prompt.value;
		len=len+1;
	}
	if(parent.f_query_add_mod.document.Bkappt_form.tid){
		fields[len]=parent.f_query_add_mod.document.Bkappt_form.third_name;
		names[len]=parent.f_query_add_mod.document.Bkappt_form.Third_Name_Prompt.value;
		len=len+1;
	}
	if(parent.f_query_add_mod.document.Bkappt_form.faid){
		fields[len]=parent.f_query_add_mod.document.Bkappt_form.family_name;
		names[len]=parent.f_query_add_mod.document.Bkappt_form.Family_Name_Prompt.value;
		len=len+1;
	}
	
	if(parent.frames[0].document.Bkappt_form.rule_appl_yn.value=="Y" && parent.frames[0].document.Bkappt_form.mob_num_req_yn.value=="Y" &&  parent.frames[0].document.Bkappt_form.contact2_no.value=="" ){
		/*var error=getMessage("CONTACT_NUM_REC_MAN","OA");		
		error=error.replace('Contact number','Mobile Number');
		alert(error);
		toSubmit=false;
		parent.frames[2].document.forms[0].Insupd.disabled=false;*/
		fields[len]=parent.f_query_add_mod.document.Bkappt_form.contact2_no;
		names[len]=getLabel("Common.MobileNo.label","Common");
		len=len+1;
	}
	if(parent.frames[0].document.Bkappt_form.rule_appl_yn.value=="Y" && parent.frames[0].document.Bkappt_form.lang_mand &&  parent.frames[0].document.Bkappt_form.language_id.value=="" ){
		/*alert("Patient's Language is mndatory.");
		toSubmit=false;
		parent.frames[2].document.forms[0].Insupd.disabled=false;*/
		fields[len]=parent.f_query_add_mod.document.Bkappt_form.language_id;
		names[len]=getLabel("Common.Language.label","Common");
		len=len+1;		
	}
	if(parent.frames[0].document.Bkappt_form.pract_override_reason &&  parent.frames[0].document.Bkappt_form.pract_override_reason.value=="" ){
		/*alert("Patient's Language is mndatory.");
		toSubmit=false;
		parent.frames[2].document.forms[0].Insupd.disabled=false;*/
		fields[len]=parent.f_query_add_mod.document.Bkappt_form.pract_override_reason;
		names[len]=getLabel("eOA.ReasonForOverride.label","OA");
		len=len+1;		
	}
	
	if(toSubmit==true){ 
		if(parent.frames[0].checkFields1( fields, names)){ 
		
			var chk_man=false;
			var chk_pat=false;
			
		
			if(parent.frames[0].document.Bkappt_form.alcn_criteria.value != '' ){
				if(parent.frames[0].document.Bkappt_form.pat_cat.value==''){
					chk_man=false;
				}else{
					chk_man=true;
				}
			}else{
				chk_man=true;
			}
			
			if(chk_man){ 
			//parent.frames[0].document.Bkappt_form.book_appt_wo_pid_yn.value='N'
				if(parent.frames[0].document.Bkappt_form.book_appt_wo_pid_yn.value=='N'){
					if(parent.frames[0].document.Bkappt_form.patient_id.value==''){
						chk_pat=false;	
					}else{
						chk_pat=true;
					}
				}else{
					chk_pat=true;
				}
			}
			
			
			if(chk_man){
				if(chk_pat){  
					parent.frames[0].document.Bkappt_form.patient_id.disabled=false;
					allow_next=true;
				}else{
					var error = getMessage('CAN_NOT_BE_BLANK','Common');
					error = error.replace('$',getLabel("Common.patientId.label","Common"));
					alert(error);
				}
			}else{
				var error = getMessage('CAN_NOT_BE_BLANK','Common');
				//error = error.replace('$','Allocation Category');
				//alert(error);
			}
		}else{
			parent.frames[2].document.forms[0].Insupd.disabled=false;
		}
		var fn_status = parent.f_query_add_mod.document.Bkappt_form.function_name.value ;
	}
	/*if(if(parent.frames[0].document.Bkappt_form.patient_id.value=="")){
		if(parent.frames[0].document.Bkappt_form.citizen_yn[0].checked==true){
				parent.frames[0].document.Bkappt_form.legal_yn[0].disabled=false;
		}else{
			parent.frames[0].document.Bkappt_form.legal_yn[0].disabled=false;
			parent.frames[0].document.Bkappt_form.legal_yn[1].disabled=false;
		}
	}*/
	//alert("allow_next---->"+allow_next);

	if(parent.frames[0].document.Bkappt_form.language_id && allow_next==true){
			if((parent.frames[0].document.Bkappt_form.tempLangugaeID.value =='' && parent.frames[0].document.Bkappt_form.language_id.value!='') || (parent.frames[0].document.Bkappt_form.tempLangugaeID.value !='' && parent.frames[0].document.Bkappt_form.language_id.value !=parent.frames[0].document.Bkappt_form.tempLangugaeID.value)){
				var appt_date=parent.f_query_add_mod.document.Bkappt_form.appt_date.value;
				var xmlDoc= "" ;
				var xmlHttp= new XMLHttpRequest() ;
				xmlStr	="<root><SEARCH " ;
				xmlStr += "language_id=\""+parent.frames[0].document.Bkappt_form.language_id.value+"\" appt_date=\""+appt_date+"\" steps='trans_confg_check'";
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				eval(responseText); 	
				if(transFlag == 0){
					if(window.confirm(getMessage("APPTS_EXCEEDED_AVAILBL_TRANS","OA"))){
						var sql="select contact_reason description ,contact_reason_code code from am_contact_reason_lang_vw where nvl(trans_exceed_reason_yn,'N') = 'Y' and eff_status='E' 	and language_id='"+localeName+"' and upper(contact_reason_code) like upper(?) and upper(contact_reason) like upper(?) order by contact_reason ";
						var tit				= getLabel("Common.TransOverrideReason.label","Common");
						var retVal			= new String();
						var argumentArray	= new Array() ;
						var dataNameArray	= new Array() ;
						var dataValueArray	= new Array() ;
						var dataTypeArray	= new Array() ;

						argumentArray[0] =sql;
						argumentArray[1] = dataNameArray ;
						argumentArray[2] = dataValueArray ;
						argumentArray[3] = dataTypeArray ;
						argumentArray[4] = "1,2";
						argumentArray[5] = "";
						argumentArray[6] = DESC_LINK;
						argumentArray[7] = DESC_CODE;
						retVal = await CommonLookup( tit, argumentArray );
						if(retVal != null && retVal != "" ){
							var ret1=unescape(retVal);
							var index=ret1.indexOf(',');
							var arr1=ret1.substring(index+1,ret1.length)//ret1.split(",");
							var arr0=ret1.substring(0,index);
							document.forms[0].trans_exceed_reason_code.value=arr0;
							toSubmit=true;					
						}else{
							toSubmit=false;	
							//document.forms[0].pract_override_reason_desc.value="";
							//document.forms[0].pract_override_reason.value="";
						}					
					}else{
						toSubmit=false;	
					}
				}					
			}
		}
	/*Added by Dharma against GHL-SCF-999 [IN:058845] on Jan 14th 2016 Start*/
	var rd_appt_yn	= parent.frames[0].document.Bkappt_form.rd_appt_yn.value;
	if(rd_appt_yn	== "Y" && toSubmit && allow_next){
		if(confirm(getMessage("ENSURE_PATIENT_INSTRUCTIONS_EXPLAINED","OA"))){
			toSubmit	= true;
	
		}else{
			toSubmit	= false;
			parent.frames[2].document.forms[0].Insupd.disabled=false;
		}
	}
	/*Added by Dharma against GHL-SCF-999 [IN:058845] on Jan 14th 2016 End*/
	
	if(allow_next && toSubmit){
		
		

		if(parent.frames[0].document.Bkappt_form.citizen_yn[0].checked==true){
				parent.frames[0].document.Bkappt_form.legal_yn[0].disabled=false;
		}else{
			parent.frames[0].document.Bkappt_form.legal_yn[0].disabled=false;
			parent.frames[0].document.Bkappt_form.legal_yn[1].disabled=false;
		}
		if(parent.frames[0].document.Bkappt_form.from_page.value ==""){
			if(overbooked!='Y'){
				if (parent.frames[0].document.Bkappt_form.pat_cat)
					pat_cat=parent.frames[0].document.Bkappt_form.pat_cat.value;
				else
					pat_cat="";
				var forced=parent.frames[0].document.Bkappt_form.Forced.value;
				var care_locn_id = parent.frames[0].document.Bkappt_form.clinic_type.value;
				// modified form tag of id='form1'(new on) instead of name='form1'(old one) on 01/06/2011
				HTMLVal = "<html><BODY onKeyDown = 'lockKey()'>" +
						"<form id='form1' method='post'  action='../../eOA/jsp/AllocationCriteriaValidation.jsp'>" +
							"<input name='clinic_code' id='clinic_code' type='hidden' value='"+ccode+"'>" +
							"<input name='clinic_date' id='clinic_date' type='hidden' value='"+document.getElementById("appt_date").value+"'>" +
							"<input name='visit_type_ind' id='visit_type_ind'  type='hidden' value='"+visit_type_ind+"'>" +
							"<input name='visit_type_short_desc' id='visit_type_short_desc'  type='hidden' value='"+visit_type_short_desc+"'>" +
							"<input name='book_appt_across_catg_yn' id='book_appt_across_catg_yn'  type='hidden' value='"+book_appt_across_catg_yn+"'>" +
							"<input name='appt_date' id='appt_date'  type='hidden' value='"+appt_date+"'>" +
							"<input name='slot_appt_ctrl' id='slot_appt_ctrl'  type='hidden' value='"+slot_appt_ctrl+"'>" +
							"<input name='pat_cat' id='pat_cat'  type='hidden' value='"+pat_cat+"'>" +
							"<input name='from_time' id='from_time'  type='hidden' value='"+from_time+"'>" +
							"<input name='to_time' id='to_time'  type='hidden' value='"+to_time+"'>" +
							"<input name='practitioner_id' id='practitioner_id'  type='hidden' value='"+practitioner_id+"'>" +
							"<input name='patient_id' id='patient_id'  type='hidden' value='"+patient_id+"'>" +
							"<input name='no_slots' id='no_slots'  type='hidden' value='"+no_slots+"'>" +
							"<input name='time_table_type' id='time_table_type'  type='hidden' value='"+time_table_type+"'>" +
							"<input name='Forced' id='Forced' type='hidden' value='"+forced+"'>" +
							"<input name='clinic_type' id='clinic_type' type='hidden' value='"+care_locn_id+"'></form></BODY></HTML>";
				parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
                //parent.parent.frames[3].document.form1.submit() (previous one)
				parent.frames[3].document.getElementById("form1").submit();// modified by venkat on 01/06/2011 for incident 26464 (new one)

				//setTimeout("parallel_thread_submit('"+ccode+"','"+visit_type_ind+"','"+visit_type_short_desc+"','"+book_appt_across_catg_yn+"','"+appt_date+"','"+slot_appt_ctrl+"','"+pat_cat+"','"+from_time+"','"+practitioner_id+"','"+to_time+"','"+patient_id+"','"+no_slots+"','"+time_table_type+"','"+forced+"','"+care_locn_id+"');",100);

				//parallel_thread_submit(ccode,visit_type_ind,visit_type_short_desc,book_appt_across_catg_yn,appt_date,slot_appt_ctrl,pat_cat,from_time,practitioner_id,to_time,patient_id,no_slots,time_table_type,forced,care_locn_id);


			}else{
				checkagegender();
			}
		}else{
			checkagegender()
		}
	}
}

/*function parallel_thread_submit(ccode,visit_type_ind,visit_type_short_desc,book_appt_across_catg_yn,appt_date,slot_appt_ctrl,pat_cat,from_time,practitioner_id,to_time,patient_id,no_slots,time_table_type,forced,care_locn_id){

if(parent.parent.frames[3].document.form1){
	HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/AllocationCriteriaValidation.jsp'><input name='clinic_code' id='clinic_code' type='hidden' value='"+ccode+"'><input name='clinic_date' id='clinic_date' type='hidden' value='"+document.getElementById("appt_date").value+"'><input name='visit_type_ind' id='visit_type_ind'  type='hidden' value='"+visit_type_ind+"'><input name='visit_type_short_desc' id='visit_type_short_desc'  type='hidden' value='"+visit_type_short_desc+"'><input name='book_appt_across_catg_yn' id='book_appt_across_catg_yn'  type='hidden' value='"+book_appt_across_catg_yn+"'><input name='appt_date' id='appt_date'  type='hidden' value='"+appt_date+"'><input name='slot_appt_ctrl' id='slot_appt_ctrl'  type='hidden' value='"+slot_appt_ctrl+"'><input name='pat_cat' id='pat_cat'  type='hidden' value='"+pat_cat+"'><input name='from_time' id='from_time'  type='hidden' value='"+from_time+"'><input name='to_time' id='to_time'  type='hidden' value='"+to_time+"'><input name='practitioner_id' id='practitioner_id'  type='hidden' value='"+practitioner_id+"'><input name='patient_id' id='patient_id'  type='hidden' value='"+patient_id+"'><input name='no_slots' id='no_slots'  type='hidden' value='"+no_slots+"'><input name='time_table_type' id='time_table_type'  type='hidden' value='"+time_table_type+"'><input name='Forced' id='Forced' type='hidden' value='"+forced+"'><input name='clinic_type' id='clinic_type' type='hidden' value='"+care_locn_id+"'></form></BODY></HTML>";
	parent.parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	alert('bef submit')
	parent.parent.frames[3].document.form1.submit();
}else{
	
		setTimeout("parallel_thread_submit('"+ccode+"','"+visit_type_ind+"','"+visit_type_short_desc+"','"+book_appt_across_catg_yn+"','"+appt_date+"','"+slot_appt_ctrl+"','"+pat_cat+"','"+from_time+"','"+practitioner_id+"','"+to_time+"','"+patient_id+"','"+no_slots+"','"+time_table_type+"','"+forced+"','"+care_locn_id+"');",100);
}

}
*/	
function allowValidNumber(fld, e, maxInt, deci)
{
	var count=fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if(count>=maxInt)
	{
		if(count==maxInt)
		{
		    var dotOccurance = fld.value.indexOf('.');
			if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt))
			{
				if(whichCode!=46)
				{
					return false;
				}
			}
		}
		else if(count>maxInt)
		{
			var objectValue = fld.value;
		    var dotOccurance = objectValue.indexOf('.');
			if((objectValue.charAt(maxInt))!='.')
			{
				if(dotOccurance==-1)
				{
					fld.value = objectValue.substring(0,maxInt)+".";
					return false;
				}
			}
		}
	}
	if (parseInt(deci)==1)//For Minus,Decimal Point and 0-9
	  var strCheck = '.0123456789-';
	else if (parseInt(deci)==2) //For Decimal Point and 0-9
	{
	   var strCheck = '.0123456789';
	}
	else if (parseInt(deci)==0)//For Only Nos 0 - 9
	{
		var strCheck = '0123456789';
	}
	else if (parseInt(deci)==3)//For Minus and 0-9 Only
	{
		var strCheck = '0123456789-';
	}
	if (parseInt(deci)==1)
	{
		var fldvalue=fld.value;
		if (whichCode == 45 && (fldvalue.length==0)) return true;  // minus 
		if (whichCode == 45 && (fldvalue.length>0)) return false;  // minus 
	}

	var fldvalue=fld.value;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
	var pointCount=0;
	for(var i=0;i<fldvalue.length;i++)
	{
		if(fldvalue.charAt(i)=='.') pointCount++;
	}
	if (pointCount>0 && whichCode == 46) return false;

	var fldValue	=	fld.value;
	var dotIndex	=	fldValue.indexOf(".");
	var fldLength	=	fldValue.length;

	if(dotIndex!=-1)
		if( fldLength > (dotIndex+3) ) return false;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true;
}
function pop_allocation(obj)
{
var alcn_criteria = parent.frames[0].document.Bkappt_form.alcn_criteria.value;
if (parent.frames[0].document.Bkappt_form.pat_cat)
{
if (obj.value!=""&&alcn_criteria=="NG")
{
var HTMLVal = new String();
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH nationality_code=\""+obj.value+"\" steps='3' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","VisitValidation.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)

}
else
{
	parent.frames[0].document.Bkappt_form.pat_cat.value="";
}
}
}

function checkagegender(){
	var  clinic_code=parent.frames[0].document.forms[0].clinic_code.value;
	var  gen		=parent.frames[0].document.Bkappt_form.sex.value;
	var  dob1		=parent.frames[0].document.Bkappt_form.date_of_birth.value;
	var patient_id =parent.frames[0].document.Bkappt_form.patient_id.value;
	var referral_id = parent.frames[0].document.Bkappt_form.source.value;
	var Visit_type = parent.frames[0].document.Bkappt_form.visit_type_short_desc.value;
	strVisitArray = Visit_type.split("~");
	var vtype_value=strVisitArray[0];
	var vtype_ind  =strVisitArray[1];
	var date_of_birth=parent.frames[0].convertDate(parent.frames[0].document.Bkappt_form.date_of_birth.value,"DMY",localeName,"en");
	if (patient_id!=""&& vtype_ind!="F"){
		var service_code=parent.frames[0].document.forms[0].service_code.value;
		var sel_service_code=parent.frames[0].document.forms[0].sel_service_code.value;
		HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/AllocationCriteriaValidation.jsp'>"+
			  "<input name='vtype_ind' id='vtype_ind' type='hidden' value='"+vtype_ind+"'><input name='clinic_code' id='clinic_code' type='hidden' value='"+clinic_code+"'><input name='service_code' id='service_code' type='hidden' value='"+service_code+"'><input name='vtype_ind' id='vtype_ind'  type='hidden' value='"+vtype_ind+"'><input name='sel_service_code' id='sel_service_code'  type='hidden' value='"+sel_service_code+"'><input name='patient_id' id='patient_id'  type='hidden' value='"+patient_id+"'><input name='step' id='step'  type='hidden' value=4></form></BODY></HTML>";
		parent.frames[1].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[1].document.form1.submit();

	}else if(clinic_code !=""){
		HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' target='messageFrame' action='../../eOA/jsp/AllocationCriteriaValidation.jsp'>"+
			  "<input name='clinic_code' id='clinic_code' type='hidden' value='"+clinic_code+"'><input name='gender' id='gender'  type='hidden' value='"+gen+"'><input name='date_of_birth' id='date_of_birth'  type='hidden' value='"+date_of_birth+"'><input name='step' id='step'  type='hidden' value=3></form></BODY></HTML>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.form1.submit();
		}else{
		Apply();
	}
}

async function onSuccess(apptref,cliniccode) { 
	  if(parent.f_query_add_mod)
	
	parent.f_query_add_mod.location.href = '../eCommon/html/blank.html';
	var message =getMessage("OA_APPT_BOOKED","OA") ;
	var features    = "dialogHeight:7; dialogWidth:30; scroll=no; status:no";
	var arguments = '';
	
	var retVal =await window.showModalDialog('../../eOP/jsp/print_confirm_frame.jsp?call_from=OA_APPT&appt_ref_no='+apptref+'&message='+message+'&locn_code='+cliniccode+'&locn_type=C',arguments,features);
	

}

function Onsuccess_mr(){
	//parent.window.returnValue="MR";
	//parent.window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = "MR";
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}

function Onsuccess_ca(calling_mode1,ca_patient_id){
	parent.window.close();
}

function Onsuccess1(calling_mode1,patientid){
	

	parent.frames[0].document.Bkappt_form.patientid_CA.value=patientid;
	parent.frames[0].document.Bkappt_form.CallingMode1.value=calling_mode1;
	window.close();
	 //code added by Nandhini for Edge conversion changes
	//  const dialogTag = parent.parent.parent.document.getElementById("dialog_tag");    
    // dialogTag.close(); 
	//parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
}

function onblurcheck(obj,target,locale){
	if(target.value == ""){
		document.forms[0].reason_for_contact.value ="";
		return;
	}
	callReasonSearch(obj,target,locale)
}

async function callReasonSearch(Obj,reason,locale){

	var sql="select contact_reason description ,contact_reason_code code from am_contact_reason_lang_vw where nvl(book_appointment_yn,'N') = 'Y' and eff_status='E' and exclude_yn != 'Y' and language_id='"+locale+"' and upper(contact_reason_code) like upper(?) and upper(contact_reason) like upper(?) order by contact_reason ";
	var tit				= getLabel("Common.ContactReason.label","Common");
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = document.forms[0].reason.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )	{
		var ret1=unescape(retVal);
		var index=ret1.indexOf(',');
		var arr1=ret1.substring(index+1,ret1.length)//ret1.split(",");
		var arr0=ret1.substring(0,index);
		
		document.forms[0].reason.value=arr1;
		document.forms[0].reason_for_contact.value=arr0;
	
	}else{
		document.forms[0].reason.value="";
		document.forms[0].reason_for_contact.value="";
	}
}
function reasonForOverride(obj,target,locale){
	if(target.value == ""){
		document.forms[0].pract_override_reason.value ="";
		return;
	}
	reasonForOverrideLookup(obj,target,locale)
}

async function reasonForOverrideLookup(Obj,pract_override_reason_desc,locale){

	var sql="select contact_reason description ,contact_reason_code code from am_contact_reason_lang_vw where nvl(PRACT_OVERRIDE_REASON_YN,'N') = 'Y' and eff_status='E' 	and language_id='"+locale+"' and upper(contact_reason_code) like upper(?) and upper(contact_reason) like upper(?) order by contact_reason ";
	//var sql="select contact_reason description ,contact_reason_code code from am_contact_reason_lang_vw where nvl(over_riding_reason,'N') = 'Y' and eff_status='E' 	and language_id='"+locale+"' and upper(contact_reason_code) like upper(?) and upper(contact_reason) like upper(?) order by contact_reason ";
	var tit				= getLabel("Common.ContactReason.label","Common");
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = pract_override_reason_desc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )	{
		var ret1=unescape(retVal);
		var index=ret1.indexOf(',');
		var arr1=ret1.substring(index+1,ret1.length)//ret1.split(",");
		var arr0=ret1.substring(0,index);
		
		document.forms[0].pract_override_reason_desc.value=arr1;
		document.forms[0].pract_override_reason.value=arr0;
	
	}else{
		document.forms[0].pract_override_reason_desc.value="";
		document.forms[0].pract_override_reason.value="";
	}
}
/*function CheckDate(Object2,focusflag) {
    var datefield = Object2;
    if (ChkDate(Object2) == false) {
        
		alert(getMessage("INVALID_DATE_FMT","SM"));
		//alert("APP-SM0011 - Invalid Date Format");
        if(focusflag == null)
        {
            datefield.select();
            datefield.focus();
        }
        return false;
    }
    else {
        return true;
    }
}*/

function validateDateTime1(obj){

	if(obj.value!="") {
		if(!validDateObj(obj,"DMY",localeName)) {
			obj.value="";
			return ;
		}
		var sysdate=document.forms[0].hddDTTM.value;
		var obj2=convertDate(obj.value,"DMY",localeName,"en");
		if(isBefore(sysdate,obj2,'DMY','en')==false){//localeName is changed to en by Rameswar on 05-OCT-15 for Leap Year Issue 
		//alert(getMessage("PRF_DATE_NOT_GR_CURR_DATE","OA")); Commented and added the below code for IN023641 on 03.08.2010 by Suresh M
			alert(getMessage("PREF_FM_DT_VALIDATION","OA"));
			obj.value="";
			obj.select();	
			return false;
		}
	}
}

function clear_from_sess(){
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH steps='CLEAR_ALL_FROM_SESSION'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",true);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}

async function show_second()
{
	var fromTime	= document.getElementById("From_timeval").value;
	var toTime		= document.getElementById("To_timeval").value;
	var facility_id =parent.frames[0].document.forms[0].facilityid.value;
	var u			= document.getElementById("visit_type_short_desc").options[document.getElementById("visit_type_short_desc").selectedIndex].text;
	var clinic_code	= document.getElementById("clinic_code").value;
	var clinic_date	= document.getElementById("appt_date").value;
	var practitioner_id	= document.getElementById("practitioner_id").value;
	var clinic_name= document.getElementById("clinic_name").value;
	var practitioner_name= document.getElementById("pame").value;
	var visittypecode=document.getElementById("visit_type_short_desc").value;
	var clinic_name_sec=document.getElementById("clinic_name_sec").value;
	var care_locn_desc_sec=document.getElementById("care_locn_desc_sec").value;
	var res_pri_class_desc=document.getElementById("res_pri_class_desc").value;
	var pract_name_pri=document.getElementById("pract_name_pri").value;
	var visit_type_desc = document.getElementById("visit_type_short_desc").value;
	var sec_req=document.getElementById("sec_req").value;
	var pat_id=document.getElementById("patient_id").value

	var time_table_type=document.getElementById("time_table_type").value
	
	var dialogHeight= "35" ;
	var dialogTop = "125" ;
	var dialogWidth	= "50" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;

	var no_of_slots=document.getElementById("no_slots").value	
	var sec_req=document.getElementById("sec_req").value	
	var res_class=document.getElementById("res_class").value	
	var clinic_type=document.getElementById("clinic_type").value

	var sec_resorces='';
	var sec_resorces1='';
	var sec_resorces_req='';
	var secArr=sec_req.split("-");
	for(i=0;i<secArr.length;i++){
		
		var sec_req1=secArr[i];

		var sec_req2=sec_req1.split("*");

		sec_resorces=sec_resorces+"'"+sec_req2[0]+"',";
		sec_resorces1=sec_resorces1+sec_req2[0]+",";
		sec_resorces_req=sec_resorces_req+sec_req2[1]+",";
	}
sec_resorces=sec_resorces.substring(0,sec_resorces.length -1);
sec_resorces_req=sec_resorces_req.substring(0,sec_resorces_req.length -1);

	
var con_value=i;
	var sel_secondary=document.getElementById("sec_sel").value


	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()

					
	xmlStr ="<root><SEARCH sel_sec = \""+sel_secondary+"\" sec_req=\""+sec_resorces+"\" clinic_code=\""+clinic_code+"\" clinic_date=\""+clinic_date+"\" facility_id=\""+facility_id+"\" con_value=\""+con_value+"\" time_table_type=\""+time_table_type+"\" steps='ADD_SEC_TO_SESSION'/></root>"

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
var sec_res_value=document.forms[0].sec_value_count.value;
	if(sec_res_value=='N')	
	{
	
callurl="../../eOA/jsp/SecResFrame.jsp?Clinic_Code="+clinic_code+"&Practitioner_id="+practitioner_id+"&From_time="+fromTime+"&To_time="+toTime+"&VisitTypeCD="+visittypecode+"&Appt_date="+clinic_date+"&time_table_type="+time_table_type+"&patient_id="+pat_id+"&no_of_slots="+no_of_slots+"&res_class="+res_class+"&clinic_type="+clinic_type+"&sec_resorces="+escape(sec_resorces)+"&sec_resorces_req="+escape(sec_resorces_req)+"&sec_resorces1="+escape(sec_resorces1)+"&clinic_name_sec="+escape(clinic_name_sec)+" &care_locn_desc_sec="+escape(care_locn_desc_sec)+" &pract_name_pri="+escape(pract_name_pri)+" &res_pri_class_desc="+escape(res_pri_class_desc)+"&visit_type_des="+escape(u);


	var retVal = new String();

	retVal = await window.showModalDialog(callurl,arguments,features);


	if(retVal){
	}else{
		retVal='';
	}
	if(retVal==''){
	}else{
		document.getElementById("sec_sel").value=retVal;
	}
	}
	else if(sec_res_value=='Y')
{
	
	
callurl="../../eOA/jsp/SecondaryFrameset.jsp?Clinic_Code="+clinic_code+"&Practitioner_id="+practitioner_id+"&From_time="+fromTime+"&To_time="+toTime+"&VisitTypeCD="+visittypecode+"&Appt_date="+clinic_date+"&time_table_type="+time_table_type+"&patient_id="+pat_id+"&no_of_slots="+no_of_slots+"&res_class="+res_class+"&clinic_type="+clinic_type+"&sec_resorces="+escape(sec_resorces)+"&sec_resorces_req="+escape(sec_resorces_req)+"&sec_resorces1="+escape(sec_resorces1)+"&clinic_name_sec="+escape(clinic_name_sec)+" &care_locn_desc_sec="+escape(care_locn_desc_sec)+" &pract_name_pri="+escape(pract_name_pri)+" &res_pri_class_desc="+escape(res_pri_class_desc)+"&visit_type_des="+escape(u)+"&sec_req="+escape(sec_req);
		
		

	var retVal = new String();
	var retVal1 = new String();
	retVal =await window.showModalDialog(callurl,arguments,features);


	if(retVal){
	}else{
		retVal='';
	}
	if(retVal==''){
	}else{
		document.getElementById("sec_sel").value=retVal;
	}
	}else
	{
		alert(getMessage("NO_SEC_SCHEDULES_AVLBL","OA"));
		//alert("APP-OA0203 No Secondary Schedules Are Available ");
	}

}

 function callOnMouseClick(obj){
	 currClass = obj.className ;
	 if("H" == "H")
		obj.className = 'SECONDSELECTED';
	document.getElementById("patientDet").className = 'FIRSTNORMAL';
	if(document.getElementById("financial_dtl")){
		document.getElementById("financial_dtl").className= 'FIRSTNORMAL';
	}
}

function callOnMouseClick1(obj){
	currClass = obj.className ;
	if("H" == "H")
		obj.className = 'SECONDSELECTED';
	document.getElementById("SecResource").className= 'FIRSTNORMAL';
	if(document.getElementById("financial_dtl")){
		document.getElementById("financial_dtl").className= 'FIRSTNORMAL';
	}
}

function callOnMouseClick2(obj){
	currClass = obj.className ;
	if("H" == "H")
		obj.className = 'SECONDSELECTED';
	document.getElementById("SecResource").className= 'FIRSTNORMAL';
	document.getElementById("patientDet").className = 'FIRSTNORMAL';
}

function call_billing_func(){
	var blng_grp=document.forms[0].billing_group.value;
	var pat_id=document.getElementById("patient_id").value;
	var bl_operational=document.forms[0].bl_operational.value;
	var clinic_type=document.getElementById("clinic_type").value;
	var episode_type="";
		var calling_module_id="";
	if(clinic_type =="D"){
		episode_type="I";
		calling_module_id="DC";
	}else{
		episode_type="O";
		calling_module_id="OP";
	}
	document.forms[0].episode_type.value = episode_type;
	document.forms[0].Function_id.value = calling_module_id;
	var apptrefno=document.forms[0].apptrefno.value;
	var from_page=document.forms[0].from_page.value;
	
	/*

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()

					
	xmlStr ="<root><SEARCH blng_grp = \""+blng_grp+"\" episode_type=\""+episode_type+"\" bl_operational=\""+bl_operational+"\" pat_id = \""+pat_id+"\" steps='finacial_dtl'/></root>"

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)

		alert("final"+responseText);  */
	var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='bl_form' id='bl_form' method='post' action='../../eOA/jsp/OAbillingdetails.jsp'> <input type='hidden' name='patient_id' id='patient_id' value='"+pat_id+"'><input type='hidden' name='blng_grp' id='blng_grp' value='"+blng_grp+"'><input type='hidden' name='episode_type' id='episode_type' value='"+episode_type+"'><input type='hidden' name='calling_module_id' id='calling_module_id' value='"+calling_module_id+"'><input type='hidden' name='from_page' id='from_page' value='"+from_page+"'><input type='hidden' name='apptrefno' id='apptrefno' value='"+apptrefno+"'><input type=hidden name='from' id='from' value='finacial_dtl'></form></body></html>";
		parent.frames[3].document.write(HTMLVal);
		parent.frames[3].document.bl_form.submit();
		
}
function  grabFinancialDetails(){
	parent.frames[0].document.forms[0].bl_success.value = "N";
	var show_hide_blng_class = "HIDE";
	var patient_id     = parent.frames[0].document.getElementById("patient_id").value;
	var package_flag	= parent.frames[0].document.forms[0].package_flag.value;
	var upd_pat_flag	= "Y"; 
	var billing_group			= parent.frames[0].document.forms[0].billing_group.value;
	var bl_future_admn_YN		= parent.frames[0].document.forms[0].bl_future_admn_YN.value;
  	var billing_mode			= parent.frames[0].document.forms[0].billing_mode;
	var operation				= parent.frames[0].document.forms[0].bl_operation.value;
	var pkg_bill_type			=parent.frames[0].document.forms[0].pkg_bill_type;
	var pkg_bill_no				=parent.frames[0].document.forms[0].pkg_bill_no;
	var calling_module_id="";
	var	calling_function_id="BOOKING";
	var health_card_expired_yn1="";
	var clinic_code	= parent.frames[0].document.getElementById("clinic_code").value;
	var visittypecode=parent.frames[0].document.getElementById("visit_type_short_desc").value;
		strVisitArray = visittypecode.split("~");
	var vtype_value=strVisitArray[0];
	var vtype_ind  =strVisitArray[1];
	var clinic_type=parent.frames[0].document.getElementById("clinic_type").value;
	var bl_interface_yn =  parent.frames[0].document.forms[0].capture_fin_dtls_yn.value;
	var episode="";
	if(clinic_type =="D"){
		episode="I";
		calling_module_id="DC";
	}else{
		episode="O";
		calling_module_id="OP";
	}
	var record="";
	var Chg_to_Visitor_Grp="";
	var patient_class="";
	var facility_id =parent.frames[0].document.forms[0].facilityid.value;
	var referral_id = parent.frames[0].document.Bkappt_form.source.value;
	var p_order_catalog="";
	var practitioner_id	= parent.frames[0].document.getElementById("practitioner_id").value;
	var apptdate=parent.frames[0].document.forms[0].apptdate_time.value;
	
	var qryStr="billing_group="+billing_group+"&operation="+operation+"&package_flag="+package_flag+"&upd_pat_flag="+upd_pat_flag+"&pkg_bill_type="+pkg_bill_type+"&pkg_bill_no="+pkg_bill_no+"&billing_mode="+billing_mode.value;

	qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;
	qryStr += "&health_card_expired_yn="+health_card_expired_yn1+"&clinic_code="+clinic_code+"&visit_type_code="+vtype_value;
	qryStr += "&episode="+episode+"&record="+record+"&patient_id="+patient_id+"&show_hide_blng_class="+show_hide_blng_class+"&Chg_to_Visitor_Grp="+Chg_to_Visitor_Grp;
	qryStr += "&bl_interfaced_yn="+bl_interface_yn+"&facilityId="+facility_id+"&patient_class="+patient_class;
	qryStr +="&financial_detail_ref_id="+referral_id;
	qryStr+="&p_order_catalog="+p_order_catalog+"&practitioner_id="+practitioner_id+"&encounter_date_time="+apptdate;
	qryStr+="&practitioner_type_ind=P";
	qryStr+="&billingFlag="+parent.frames[0].document.forms[0].bl_success.value
	var returnArray = new Array();
	returnArray = getFinDtl(qryStr);
	if(returnArray.length>0){
		parent.frames[0].document.forms[0].billing_group.value     = returnArray[0];
		parent.frames[0].document.forms[0].billing_mode.value      = "Modify"
		parent.frames[0].document.forms[0].bl_success.value = "Y";
		parent.frames[0].document.forms[0].bl_operation.value	= "Update";
		//tab_click('booking_tab');
		//document.forms[0].pref_adm_date.focus();
	}else{
		//parent.frames[0].document.forms[0].billing_mode.value		= "Add";
		//parent.frames[0].document.forms[0].bl_operation.value		= "Insert";
		parent.frames[0].document.forms[0].bl_success.value = "N";
		//tab_click('booking_tab');
		return false;
	}
}

async function getFinDtl(qryStr){	
	var retVal;
	var dialogHeight= "100vh" ;
	var dialogWidth = "85vw" ;
	var dialogTop = "0" ;
	var center = "1" ;                                                         
	var status="no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	var url = "../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?"+qryStr;
	retVal = await window.showModalDialog(url,arguments,features);
	if(retVal==null) retVal="";
	return retVal;
}



var globalFlag=false;
var currClass = '';

function show_second1(){
	
	parent.frames[2].document.getElementById("ffgh").disabled=true;
	if (document.getElementById("SecResCheck").value=='Y'){
		var fromTime	= document.getElementById("From_timeval").value;
		var toTime		= document.getElementById("To_timeval").value;
		var facility_id =parent.frames[0].document.forms[0].facilityid.value;
		var u			= document.getElementById("visit_type_short_desc").options[document.getElementById("visit_type_short_desc").selectedIndex].text;
		var clinic_code	= document.getElementById("clinic_code").value;
		var clinic_date	= document.getElementById("appt_date").value;
		var practitioner_id	= document.getElementById("practitioner_id").value;
		var clinic_name= document.getElementById("clinic_name").value;
		var practitioner_name= document.getElementById("pame").value;
		var visittypecode=document.getElementById("visit_type_short_desc").value;
		var clinic_name_sec=document.getElementById("clinic_name_sec").value;
		var care_locn_desc_sec=document.getElementById("care_locn_desc_sec").value;
		var res_pri_class_desc=document.getElementById("res_pri_class_desc").value;
		var pract_name_pri=document.getElementById("pract_name_pri").value;
		var visit_type_desc = document.getElementById("visit_type_short_desc").value;
		var sec_req=document.getElementById("sec_req").value;
		var pat_id=document.getElementById("patient_id").value
		
		var time_table_type=document.getElementById("time_table_type").value
	
		var ServerTime =document.forms[0].ServerTime.value;
		var ServerDate =document.forms[0].Serverdate.value;
		var dialogHeight= "35" ;
		var dialogTop = "125" ;
		var dialogWidth	= "50" ;
		var status = "no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
		var no_of_slots=document.getElementById("no_slots").value;	
		var sec_req=document.getElementById("sec_req").value;	
		var res_class=document.getElementById("res_class").value;	
		var clinic_type=document.getElementById("clinic_type").value;
		var sec_resorces='';
		var sec_resorces1='';
		var sec_resorces_req='';
		var secArr=sec_req.split("-");

		for(i=0;i<secArr.length;i++){		
			var sec_req1=secArr[i];
			var sec_req2=sec_req1.split("*");
			sec_resorces=sec_resorces+"'"+sec_req2[0]+"',";
			sec_resorces1=sec_resorces1+sec_req2[0]+",";
			sec_resorces_req=sec_resorces_req+sec_req2[1]+",";
		}
		sec_resorces=sec_resorces.substring(0,sec_resorces.length -1);
		sec_resorces_req=sec_resorces_req.substring(0,sec_resorces_req.length -1);	
		var con_value=i;
		var sel_secondary=document.getElementById("sec_sel").value;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();					
		xmlStr ="<root><SEARCH sel_sec = \""+sel_secondary+"\" sec_req=\""+sec_resorces+"\" clinic_code=\""+clinic_code+"\" clinic_date=\""+clinic_date+"\" facility_id=\""+facility_id+"\" con_value=\""+con_value+"\" time_table_type=\""+time_table_type+"\" steps='ADD_SEC_TO_SESSION'/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
		var sec_res_value=document.forms[0].sec_value_count.value;
		
		//alert(parent.frames[1].document.forms[0] && globalFlag);
		//alert(document.forms[0].globalFlag.value);

		if (parent.frames[1].document.forms[0] && globalFlag){
			
			if(document.forms[0].globalFlag.value=="false"){
				
				//alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				callurl="../../eOA/jsp/SecondaryResources.jsp?Clinic_Code="+clinic_code+"&Practitioner_id="+practitioner_id+"&From_time="+fromTime+"&To_time="+toTime+"&VisitTypeCD="+visittypecode+"&Appt_date="+clinic_date+"&time_table_type="+time_table_type+"&patient_id="+pat_id+"&no_of_slots="+no_of_slots+"&res_class="+res_class+"&clinic_type="+clinic_type+"&sec_resorces="+escape(sec_resorces)+"&sec_resorces_req="+escape(sec_resorces_req)+"&sec_resorces1="+escape(sec_resorces1)+"&clinic_name_sec="+escape(clinic_name_sec)+" &care_locn_desc_sec="+escape(care_locn_desc_sec)+" &pract_name_pri="+escape(pract_name_pri)+" &res_pri_class_desc="+escape(res_pri_class_desc)+"&visit_type_des="+escape(u)+"&sec_req="+escape(sec_req)+"&ServerDate="+escape(ServerDate)+"&ServerTime="+escape(ServerTime);
				parent.frames[1].location.href=callurl;				
			   // parent.document.getElementById("mainFrame").rows = '15.4%,*,5%,0';
			   
			   /*Above line commented and below condtion added for this incident [43349] */
			   if(document.forms[0].or_catalogue_code && document.forms[0].or_catalogue_code.value!=""){
			    //parent.document.getElementById("mainFrame").rows = '17.8%,*,5%,0'; 
				parent.document.getElementById("f_query_add_mod").style.height='17.8vh'
				parent.document.getElementById("SecondaryFrame").style.height='77vh'
				parent.document.getElementById("ButtonFrame").style.height='5vh'
				parent.document.getElementById("messageFrame").style.height='0vh'
			   }else{
			   //parent.document.getElementById("mainFrame").rows = '14.4%,*,5%,0';
			   	parent.document.getElementById("f_query_add_mod").style.height='14.4vh'
				parent.document.getElementById("SecondaryFrame").style.height='80vh'
				parent.document.getElementById("ButtonFrame").style.height='5vh'
				parent.document.getElementById("messageFrame").style.height='0vh'
			   }
			   //End incident 43349
 			   
			    globalFlag=true;
			}else{ 
			    
				// parent.document.getElementById("mainFrame").rows = '15.4%,*,5%,0';
			     /*aboveline commented and below condtion Added for this IN43349*/  
				if(document.forms[0].or_catalogue_code && document.forms[0].or_catalogue_code.value!="") {
				//parent.document.getElementById("mainFrame").rows = '17.8%,*,5%,0';
				parent.document.getElementById("f_query_add_mod").style.height='17.8vh'
				parent.document.getElementById("SecondaryFrame").style.height='77vh'
				parent.document.getElementById("ButtonFrame").style.height='5vh'
				parent.document.getElementById("messageFrame").style.height='0vh'
				}
				else {
				//parent.document.getElementById("mainFrame").rows = '14.4%,*,5%,0';
				parent.document.getElementById("f_query_add_mod").style.height='14.4vh'
				parent.document.getElementById("SecondaryFrame").style.height='80vh'
				parent.document.getElementById("ButtonFrame").style.height='5vh'
				parent.document.getElementById("messageFrame").style.height='0vh'
				//End IN43349
				}
			}
		}else{
			
			callurl="../../eOA/jsp/SecondaryResources.jsp?Clinic_Code="+clinic_code+"&Practitioner_id="+practitioner_id+"&From_time="+fromTime+"&To_time="+toTime+"&VisitTypeCD="+visittypecode+"&Appt_date="+clinic_date+"&time_table_type="+time_table_type+"&patient_id="+pat_id+"&no_of_slots="+no_of_slots+"&res_class="+res_class+"&clinic_type="+clinic_type+"&sec_resorces="+escape(sec_resorces)+"&sec_resorces_req="+escape(sec_resorces_req)+"&sec_resorces1="+escape(sec_resorces1)+"&clinic_name_sec="+escape(clinic_name_sec)+" &care_locn_desc_sec="+escape(care_locn_desc_sec)+" &pract_name_pri="+escape(pract_name_pri)+" &res_pri_class_desc="+escape(res_pri_class_desc)+"&visit_type_des="+escape(u)+"&sec_req="+escape(sec_req)+"&ServerDate="+escape(ServerDate)+"&ServerTime="+escape(ServerTime);

			parent.frames[1].location.href=callurl;			
			//parent.document.getElementById("mainFrame").rows = '15.4%,*,5%,0';
			/*Above line commented and below line Added for this Incident IN43349*/
			if(document.forms[0].or_catalogue_code && document.forms[0].or_catalogue_code.value!=""){
			//parent.document.getElementById("mainFrame").rows = '17.8%,*,5%,0';
				parent.document.getElementById("f_query_add_mod").style.height='17.8vh'
				parent.document.getElementById("SecondaryFrame").style.height='77vh'
				parent.document.getElementById("ButtonFrame").style.height='5vh'
				parent.document.getElementById("messageFrame").style.height='0vh'
			}else{
			//parent.document.getElementById("mainFrame").rows = '14.4%,*,5%,0';
			parent.document.getElementById("f_query_add_mod").style.height='14.4vh'
			parent.document.getElementById("SecondaryFrame").style.height='80vh'
			parent.document.getElementById("ButtonFrame").style.height='5vh'
			parent.document.getElementById("messageFrame").style.height='0vh'
			}
			//End IN43349
			globalFlag=true;
		}	
	}else{		
		var error=getMessage("NO_SEC_SCHEDULES_AVLBL","OA");
		error=error.replace("Schedules",getLabel("Common.resource.label","Common"))
	}
}

function clear_recur(){
	document.getElementById("recurringdays").value='';
	document.getElementById("recurring_cur_select").value='';
}


async function open_date_select()
{
	var no_of_slots=document.getElementById("no_slots").value;
	if(no_of_slots >1){
		alert(getMessage("REC_APTS_BOOKING","OA"));
	}else{
		var fromTime	= document.getElementById("From_timeval").value;
		var toTime		= document.getElementById("To_timeval").value;
		var u			= document.getElementById("visit_type_short_desc").options[document.getElementById("visit_type_short_desc").selectedIndex].text;

		var clinic_code	= document.getElementById("clinic_code").value;
		var clinic_date	= document.getElementById("appt_date").value;
		var practitioner_id	= document.getElementById("practitioner_id").value;
		var clinic_name= document.getElementById("clinic_name").value;
		var practitioner_name= document.getElementById("pame").value;
		var visittypecode=document.getElementById("visit_type_short_desc").value;
			strVisitArray = u.split("~");
		var vtype_value=strVisitArray[0];
		var vtype_ind  =strVisitArray[1];

		var pat_id=document.getElementById("patient_id").value
	
		var time_table_type=document.getElementById("time_table_type").value
		var care_locn_ind	= document.getElementById("clinic_type").value;
		var res_class= document.getElementById("res_class").value;
		var service1_code=document.forms[0].service_code.value;
		var sel_service_code=document.forms[0].sel_service_code.value;
		var facilityid = document.forms[0].facilityid.value;
		var dialogHeight= "40" ;
		var dialogTop = "85" ;
		var dialogWidth	= "65" ;
		var status = "no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;

		//var no_of_slots=document.getElementById("no_slots").value;

		var recurring_cur_select=document.getElementById("recurring_cur_select").value;
		var recurringdays=document.getElementById("recurringdays").value;


		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		if(recurringdays!=''){
			xmlStr ="<root><SEARCH  recurringdays=\""+recurringdays+"\"  steps='ADD_RECC_TO_SESSION'/></root>"

			
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","ServerSide.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText)
			}else{
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH vtype_ind=\""+vtype_ind+"\"  service1_code=\""+service1_code+"\" clinic_code_rec = \""+clinic_code+"\" pat_id_rec=\""+pat_id+"\" facilityid_rec = \""+facilityid+"\" sel_service_code =\""+sel_service_code+"\" steps='CLEAR_REC_FROM_SESSION'/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","ServerSide.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText)
		}
		if(document.forms[0].REC_VALUE.value =="N")
		{
		var callurl="../../eOA/jsp/RecurringDaysFrame.jsp?Clinic_Code="+clinic_code+"&Clinic_Name="+encodeURIComponent(clinic_name)+"&Practitioner_id="+practitioner_id+"&Practitioner_name="+encodeURIComponent(practitioner_name)+"&From_time="+fromTime+"&To_time="+toTime+"&VisitTypeCD="+visittypecode+"&VisitTypeDesc="+encodeURIComponent(u)+"&Appt_date="+clinic_date+"&time_table_type="+time_table_type+"&patient_id="+pat_id+"&no_of_slots="+no_of_slots+"&care_locn_ind="+care_locn_ind+"&res_class="+res_class+"&recurring_cur_select="+escape(recurring_cur_select);

		var retVal = new String();
		retVal = await window.showModalDialog(callurl,arguments,features);

		if(retVal){
		}else{
			retVal='';
		}
		if(retVal==''){
		}else{
			var ret_arr=retVal.split('||');
			document.getElementById("recurringdays").value=ret_arr[0];
			document.getElementById("recurring_cur_select").value=ret_arr[1];
		}

		}
	}

}

function chk(obj) {
	var frm=document.forms[0];
	var sysDt1=frm.hddDTTM.value;
	sysDt1=sysDt1.substring(0,10)
	frm.sys_date.value=sysDt1;

	var sysDt=frm.sys_date;
	
	var msg;
	
	if(obj.name=='prefdate1'){
		if(obj.value==''){
			frm.prefenddate1.value='';
			frm.priorty.value='';
		}

		if(frm.prefenddate1.value=='')
			frm.prefenddate1.value=frm.prefdate1.value;
	}

	if(obj.name=='prefenddate1'){
		if(frm.prefdate1.value=='')
			frm.prefdate1.value=frm.prefenddate1.value;
	}
	
	if(validateDate(obj)){

		if(obj.name=='prefenddate1'){			
			if(frm.prefenddate1.value !=''){
				if(!DateCompare4(sysDt,obj)){
					msg=getMessage("TO_DATE_LESS_SYSDATE","SM");
					alert(msg)
					obj.focus();
					return;
				}
			}
			
			if(frm.prefdate1.value !=''){
				if(!DateCompare4(sysDt,frm.prefdate1)){
					msg=getMessage("FROM_DATE_LESS_SYSDATE","SM");
					alert(msg)
					frm.prefdate1.focus();
					return;
				}
			}
		

			if(frm.prefdate1.value !='' && frm.prefenddate1.value !=''){	
				sysDt=frm.prefdate1;
				if(!DateCompare4(sysDt,obj)){
					msg=getMessage("TO_DT_GR_EQ_FM_DT","SM");
					alert(msg)
					obj.focus();
				}
			}

		}else{
			if(frm.prefdate1.value !=''){
				if(!DateCompare4(sysDt,obj)){
					msg=getMessage("FROM_DATE_LESS_SYSDATE","SM");
					alert(msg)
					obj.focus();
					return;
				}
			}

			if(frm.prefenddate1.value !=''){
				if(!DateCompare4(obj,frm.prefenddate1)){
					msg=getMessage("TO_DT_GR_EQ_FM_DT","SM");
					alert(msg)
					frm.prefenddate1.focus();
				}
			}

		}

	}

}

function val_multi_slot(Obj){
	var fromTime	= document.getElementById("From_timeval").value;
	var toTime		= document.getElementById("totime_value").value;
	var u			= document.getElementById("visit_type_short_desc").value;
	var clinic_code	= document.getElementById("clinic_code").value;
	var clinic_date	= document.getElementById("appt_date").value;
	var practitioner_id	= document.getElementById("practitioner_id").value;
	var visit_limit_rule = document.getElementById("visit_limit_rule").value;
	var slot_appt_ctrl= document.getElementById("slot_appt_ctrl").value;
	strVisitArray = u.split("~");
	var u1=strVisitArray[0];
	var firstvisit=strVisitArray[1];
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_code=\""+clinic_code+"\" practitioner_id=\""+practitioner_id+"\" fromTime=\""+fromTime+"\" visit_limit_rule=\""+visit_limit_rule+"\" slot_appt_ctrl=\""+slot_appt_ctrl+"\" no_of_slots=\""+Obj.value+"\" firstvisit=\""+firstvisit+"\" toTime=\""+toTime+"\" clinic_date=\""+clinic_date+"\" steps='1' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","VisitValidation.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText) 
	globalFlag=false;
}

function clearAll1(){
	
	if(document.forms[0].hddPat_id.value =="" || parent.frames[0].document.forms[0].CallingMode.value=="N" ){
		var u=parent.frames[0].document.forms[0].visit_type_short_desc.value;
		strVisitArray = u.split("~");
		var u1=strVisitArray[0];
		var u2=strVisitArray[1];
		if(document.getElementById("sec_sel")){
			document.getElementById("sec_sel").value='';
		}
		parent.frames[2].document.forms[0].Insupd.disabled=false;
		parent.frames[0].document.forms[0].patient_id.value="";
		parent.frames[0].document.getElementById("patient_name1").innerHTML="";
		parent.frames[0].document.getElementById("patient_name_local_lang1").innerHTML="";
		if(parent.frames[0].document.forms[0].allow_non_referral_yn.value =="Y")
			parent.frames[0].document.forms[0].search.disabled=false;
		parent.frames[0].document.forms[0].patient_id.disabled=false;
		parent.frames[0].document.forms[0].source.value="";
		parent.frames[0].document.forms[0].source.disabled=false;			
		parent.frames[0].document.forms[0].patient_SecurityLevel.value="";
		parent.frames[0].document.forms[0].reason.value="";
		parent.frames[0].document.forms[0].reason_for_contact.value="";
		parent.frames[0].document.forms[0].remarks.value="";
		parent.frames[0].document.forms[0].rec_date.value="";
		parent.frames[0].document.forms[0].date_of_birth.value="";
		parent.frames[0].document.forms[0].date_of_birth.readOnly=false;
		parent.frames[0].document.getElementById("dob").disabled=true;
		parent.frames[0].document.forms[0].b_age.value="";
		parent.frames[0].document.forms[0].b_age.readOnly=false;
		parent.frames[0].document.forms[0].b_months.value="";
		parent.frames[0].document.forms[0].b_months.readOnly=false;
		parent.frames[0].document.getElementById("dob").disabled =false;
		parent.frames[0].document.forms[0].b_days.value="";
		parent.frames[0].document.forms[0].b_days.readOnly=false;	
		if(parent.frames[0].document.forms[0].allow_referral_yn.value =="Y")
			parent.frames[0].document.forms[0].search1.disabled=false;
		parent.frames[2].document.forms[0].previous_encounter.disabled=true;
		parent.frames[0].document.forms[0].place_of_birth.value="";
		parent.frames[0].document.forms[0].place_of_birth.disabled=false;
		if(parent.frames[0].document.forms[0].other_alt_type){
			parent.frames[0].document.forms[0].other_alt_type.value="";
			parent.frames[0].document.forms[0].other_alt_type.disabled=false;
		}
		if(parent.frames[0].document.forms[0].other_alt_Id){
			parent.frames[0].document.forms[0].other_alt_Id.value="";
			parent.frames[0].document.forms[0].other_alt_Id.disabled=false;
		}
		if(parent.frames[2].document.getElementById("other_id1")!=null )
			parent.frames[2].document.getElementById("other_id1").style.visibility='hidden';
		if(parent.frames[2].document.forms[0].recurring){
			parent.frames[2].document.forms[0].recurring.disabled=true;
		}
		if(parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u =="" &&( parent.f_query_add_mod.document.Bkappt_form.CallingMode.value==''|| parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='N')){
			parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.source.disabled=false;
			parent.f_query_add_mod.document.Bkappt_form.search1.disabled=false;
			disable_conrolls();
		}else if(parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u2!="F" && (parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='' || parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='N')){
			parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=false;
			parent.f_query_add_mod.document.Bkappt_form.search.disabled=false;
			parent.f_query_add_mod.document.Bkappt_form.source.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.search1.disabled=true;
			enable_conrolls();
		}else if(parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u2 =="F" &&( parent.f_query_add_mod.document.Bkappt_form.CallingMode.value==''|| parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='N')){
			parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.source.disabled=false;
			parent.f_query_add_mod.document.Bkappt_form.search1.disabled=false;
			disable_conrolls();
		}else if(parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='CA'  && parent.f_query_add_mod.document.Bkappt_form.ca_patient_id_new.value =="" && parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u2 =="F"){
			parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.source.disabled=false;
			parent.f_query_add_mod.document.Bkappt_form.search1.disabled=false;
			disable_conrolls();
			parent.f_query_add_mod.document.Bkappt_form.source.disabled=false;
		}else if(parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u2!="F" && parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='CA'  && parent.f_query_add_mod.document.Bkappt_form.ca_patient_id_new.value ==""){
			parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=false;
			parent.f_query_add_mod.document.Bkappt_form.search.disabled=false;	 
			if( parent.f_query_add_mod.document.Bkappt_form.patient_id.value ==""){
				enable_conrolls();
			}
			if(parent.f_query_add_mod.document.Bkappt_form.source.value !=""){
				clearAll();
				parent.f_query_add_mod.document.Bkappt_form.patient_id.value="";
			}
			parent.f_query_add_mod.document.Bkappt_form.source.value="";
			parent.f_query_add_mod.document.Bkappt_form.search1.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.source.disabled=true;
		}else if( parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='CA' && parent.f_query_add_mod.document.Bkappt_form.ca_patient_id_new.value !=""){
			parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.source.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.search1.disabled=true;
			disable_notoa();			
		}else if( parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='OP'){
			parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
			disable_notoa();
			parent.f_query_add_mod.document.Bkappt_form.source.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.search1.disabled=true;
		} 
		//setTimeout('disable_Legal_If_Citzen()', 250);
		//setTimeout('loadEthnicSubGroup()',50);
		
		clear_all_fun_alcn();
		
	}else{
		parent.frames[0].document.forms[0].reason_for_contact.value="";
		parent.frames[0].document.forms[0].reason.value="";
		parent.frames[0].document.forms[0].remarks.value="";
		parent.frames[0].document.forms[0].rec_date.value="";
		document.forms[0].mode.selectedIndex="3";
	}
	
	return false;
}

function clear_all_fun2(flag){
	parent.frames[0].document.forms[0].patient_id.value="";
	parent.frames[0].document.getElementById("patient_name1").innerHTML="&nbsp";
	clearAll();
}

function clear_all_fun1(flag)
{
	
	parent.frames[0].document.forms[0].patient_id.value="";
	parent.frames[0].document.getElementById("patient_name1").innerHTML="&nbsp";
	if(parent.frames[0].document.forms[0].national_id !=null)
	parent.frames[0].document.forms[0].national_id.value="";
	if(parent.frames[0].document.forms[0].name_prefix!=null)
	parent.frames[0].document.forms[0].name_prefix.value="";
	if(parent.frames[0].document.forms[0].first_name!=null)
	parent.frames[0].document.forms[0].first_name.value="";
	if(parent.frames[0].document.forms[0].second_name!=null)
	parent.frames[0].document.forms[0].second_name.value="";
	if(parent.frames[0].document.forms[0].third_name!=null)
	parent.frames[0].document.forms[0].third_name.value="";
	if(parent.frames[0].document.forms[0].family_name!=null)
	parent.frames[0].document.forms[0].family_name.value="";
	if(parent.frames[0].document.forms[0].name_suffix!=null)
	parent.frames[0].document.forms[0].name_suffix.value="";

	parent.frames[0].document.forms[0].sex.value="";
	parent.frames[0].document.forms[0].date_of_birth.value="";
	parent.frames[0].document.forms[0].b_age.value="";
	parent.frames[0].document.forms[0].b_months.value="";
	parent.frames[0].document.forms[0].b_days.value="";

	if(parent.frames[0].document.forms[0].national_id_no){
		parent.frames[0].document.forms[0].national_id_no.value="";
		parent.frames[0].document.forms[0].national_id_no.disabled=false;
	}

	if(parent.frames[0].document.forms[0].alt_id1_no){
		parent.frames[0].document.forms[0].alt_id1_no.value="";
		parent.frames[0].document.forms[0].alt_id1_no.disabled=false;
	}
	if(parent.frames[0].document.forms[0].alt_id2_no){
		parent.frames[0].document.forms[0].alt_id2_no.value="";
		parent.frames[0].document.forms[0].alt_id2_no.disabled=false;
	}
	if(parent.frames[0].document.forms[0].alt_id3_no){
		parent.frames[0].document.forms[0].alt_id3_no.value="";
		parent.frames[0].document.forms[0].alt_id3_no.disabled=false;
	}
	if(parent.frames[0].document.forms[0].alt_id4_no){
		parent.frames[0].document.forms[0].alt_id4_no.value="";
		parent.frames[0].document.forms[0].alt_id4_no.disabled=false;
	}
	if(parent.frames[0].document.forms[0].other_alt_type){
		parent.frames[0].document.forms[0].other_alt_type.value="";
		parent.frames[0].document.forms[0].other_alt_type.disabled=false;
	}
	if(parent.frames[0].document.forms[0].other_alt_Id){
		parent.frames[0].document.forms[0].other_alt_Id.value="";
		parent.frames[0].document.forms[0].other_alt_Id.disabled=false;
	}

	if(parent.frames[0].document.forms[0].family_name){
	parent.frames[0].document.forms[0].family_name.value="";
	parent.frames[0].document.forms[0].family_name.disabled=false;
	}

	parent.frames[2].document.forms[0].other_id1.style.visibility='hidden';
	
	clear_fun_all();
	if (flag=="P") 
	{
       	parent.frames[0].document.forms[0].patient_id.focus();
		clearAll();
	}
	else if (flag=="R")
		{
		parent.frames[0].document.forms[0].source.value="";
		parent.frames[0].document.forms[0].source.disabled=false;
		parent.frames[0].document.forms[0].search1.disabled=false;
		parent.frames[0].document.forms[0].source.focus();
		clearAll1();
		parent.frames[0].document.forms[0].source.disabled=false;
		parent.frames[0].document.forms[0].search1.disabled=false;
		//disable_conrolls();
		//parent.window.close();
		}

}
function validateFirstVisitDefault(){
	if(parent.f_query_add_mod.document.Bkappt_form.visit_ind_count && parent.f_query_add_mod.document.Bkappt_form.visit_ind_count.value=='1'){
		validateFirstVisit(parent.f_query_add_mod.document.Bkappt_form.visit_type_short_desc);
	}
}
function validateFirstVisit(Obj){
	var u=Obj.value;
	strVisitArray = u.split("~");
	var u1="";
	var u2="";
	if(strVisitArray.length==2){//Added on 15/03/2010 by Sudhakar for IN019814
		u1=strVisitArray[0];
		u2=strVisitArray[1];
	}
	var overbookedyn= document.getElementById("overbooked").value;
	var Forced = document.getElementById("Forced").value;
	var time_table_type=document.forms[0].time_table_type.value;
	if(parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u2!="" && u2!="F" && (parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='' || parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='N')){
		if(document.Bkappt_form.rule_based_tr.value !="Y"){
			parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=false
			parent.f_query_add_mod.document.Bkappt_form.search.disabled=false;
			if( parent.f_query_add_mod.document.Bkappt_form.patient_id.value ==""){
				enable_conrolls();
			}
			if(parent.f_query_add_mod.document.Bkappt_form.source.value !=""){
				clearAll();
				parent.f_query_add_mod.document.Bkappt_form.patient_id.value="";
			}
			parent.f_query_add_mod.document.Bkappt_form.source.value="";
			parent.f_query_add_mod.document.Bkappt_form.search1.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.source.disabled=true;
		}
	}else if(parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u2 =="F" &&( parent.f_query_add_mod.document.Bkappt_form.CallingMode.value==''|| parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='N')){
		if(document.Bkappt_form.rule_based_tr.value !="Y"){
			parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
			parent.f_query_add_mod.document.Bkappt_form.source.disabled=false;
			parent.f_query_add_mod.document.Bkappt_form.search1.disabled=false;
			if(parent.f_query_add_mod.document.Bkappt_form.source.value =="")
			disable_conrolls(); //changed by Sudhakar on 14/03/2010 For IN019814. Patient values are clearing when visit type(First Visit) is selected.
		}
	}else if(parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='CA'  && parent.f_query_add_mod.document.Bkappt_form.ca_patient_id_new.value =="" && parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u2 =="F"){
		parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=true;
		parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
		parent.f_query_add_mod.document.Bkappt_form.source.disabled=false;
		parent.f_query_add_mod.document.Bkappt_form.search1.disabled=false;
		disable_conrolls();
		parent.f_query_add_mod.document.Bkappt_form.source.disabled=false;
	}else if(parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u2!="F" && parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='CA'  && parent.f_query_add_mod.document.Bkappt_form.ca_patient_id_new.value ==""){
		parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=false;
		parent.f_query_add_mod.document.Bkappt_form.search.disabled=false;
		if( parent.f_query_add_mod.document.Bkappt_form.patient_id.value ==""){
			enable_conrolls();
		}
		if(parent.f_query_add_mod.document.Bkappt_form.source.value !=""){
			clearAll();
			parent.f_query_add_mod.document.Bkappt_form.patient_id.value="";
		}
		parent.f_query_add_mod.document.Bkappt_form.source.value="";
		parent.f_query_add_mod.document.Bkappt_form.search1.disabled=true;
		parent.f_query_add_mod.document.Bkappt_form.source.disabled=true;
	}else if(parent.f_query_add_mod.document.Bkappt_form.CallingMode.value!='OP' && parent.f_query_add_mod.document.Bkappt_form.waitListNo.value !="" && parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u2=="F"){
		parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=true;
		parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
		parent.f_query_add_mod.document.Bkappt_form.source.disabled=false;
		parent.f_query_add_mod.document.Bkappt_form.search1.disabled=false;
	}else if(parent.f_query_add_mod.document.Bkappt_form.waitListNo.value !="" && parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u2!="F"){
		parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=true;
		parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
		parent.f_query_add_mod.document.Bkappt_form.source.disabled=true;
		parent.f_query_add_mod.document.Bkappt_form.search1.disabled=true;
	}else if( parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='CA' && parent.f_query_add_mod.document.Bkappt_form.ca_patient_id_new.value !="" && parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u2 =="F"){
		parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=true;
		parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
		parent.f_query_add_mod.document.Bkappt_form.source.disabled=false;
		parent.f_query_add_mod.document.Bkappt_form.search1.disabled=false;
		//disable_notoa();
	}else if(parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='CA' && parent.f_query_add_mod.document.Bkappt_form.ca_patient_id_new.value !="" && parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u2 !="F"){
		parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=false;
		parent.f_query_add_mod.document.Bkappt_form.search.disabled=false;
	 	if( parent.f_query_add_mod.document.Bkappt_form.patient_id.value ==""){
			enable_conrolls();
		}
		if(parent.f_query_add_mod.document.Bkappt_form.source.value !=""){
			clearAll();
			parent.f_query_add_mod.document.Bkappt_form.patient_id.value="";
		}
		parent.f_query_add_mod.document.Bkappt_form.source.value="";
		parent.f_query_add_mod.document.Bkappt_form.search1.disabled=true;
		parent.f_query_add_mod.document.Bkappt_form.source.disabled=true;
	}else if( parent.f_query_add_mod.document.Bkappt_form.CallingMode.value=='OP'){
		parent.f_query_add_mod.document.Bkappt_form.patient_id.disabled=true;
		parent.f_query_add_mod.document.Bkappt_form.search.disabled=true;
		disable_notoa();
		parent.f_query_add_mod.document.Bkappt_form.source.disabled=true;
		parent.f_query_add_mod.document.Bkappt_form.search1.disabled=true;
	}
	if(u2!=='S'){
		if(parent.frames[2].document.forms[0].recurring)
		parent.frames[2].document.forms[0].recurring.style.visibility="hidden";
	}else{			
		if(overbookedyn=='Y' || Forced=='Y' || time_table_type=='3'){
			if(parent.frames[2].document.forms[0].recurring)
			parent.frames[2].document.forms[0].recurring.style.visibility="hidden";
		}else{
			if(parent.frames[2].document.forms[0].recurring)
			parent.frames[2].document.forms[0].recurring.style.visibility="visible";
			parent.frames[2].document.forms[0].recurring.disabled=true;
		}
	}
	if(parent.frames[0].document.forms[0].patient_id.value !="" && u2=='S'){
		parent.frames[2].document.forms[0].recurring.style.visibility="visible";
		parent.frames[2].document.forms[0].recurring.disabled=false;
	}
	var clinic_date		= document.getElementById("appt_date").value;
	j = document.getElementById("visit_type_short_desc").selectedIndex;
	var max_appt_slots = max_appt_slots_Array[j-1];
  	//Added by Kamatchi S for NMC-JD-CRF-0104
	var isSlotTimeAppl= parent.frames[0].document.Bkappt_form.isSlotTimeAppl.value;
	var or_appt_time = parent.frames[0].document.Bkappt_form.or_appt_time.value;
	var no_slot = parent.frames[0].document.forms[0].no_slots.value;
	if(isSlotTimeAppl=="true" && !no_slot=="" && !or_appt_time=="")
	{
	max_appt_slots = no_slot;
	}
	var first_visit_flag = document.getElementById("first_visit_flag").value;
	var other_visit_flag = document.getElementById("other_visit_flag").value;
	var only_fv_allowed_flag = document.getElementById("only_fv_allowed_flag").value;
	var visit_limit_rule = document.getElementById("visit_limit_rule").value;
	var slot_appt_ctrl = document.getElementById("slot_appt_ctrl").value;
	var slotsFromOrder = document.getElementById("slotsFromOrder").value;
	if(u2 == "F" && first_visit_flag=="Y"){
		alert(getMessage('MAX_FIRST_VISITS_REACHED','OA'));
		document.getElementById("visit_type_short_desc").value="";
	}else if (u2!="F" && other_visit_flag=="Y"){
		alert(getMessage('MAX_OTHER_VISITS_REACHED','OA'));
		document.getElementById("visit_type_short_desc").value="";
	}else{
		var fromTime = document.getElementById("From_timeval").value;
		var toTime = document.getElementById("totime_value").value;
		if(!(parent.f_query_add_mod.document.Bkappt_form.visit_ind_count && parent.f_query_add_mod.document.Bkappt_form.visit_ind_count.value=='1')){
			var len = document.getElementById("no_slots").length;
      //Added by kamatchi S for NMC-JD-CRF-0104
			if(isSlotTimeAppl=="true"){
				if(or_appt_time=="")
				{
				for(var k=0;k<len;k++)
				document.getElementById("no_slots").remove(1);
				}
			}
			else{
			for(var k=0;k<len;k++)
				document.getElementById("no_slots").remove(1);
			}
		}
		var time_table_type = document.getElementById("time_table_type").value;
		if(overbookedyn=="N"){
			if(time_table_type!=null && time_table_type=="1" && Forced=='N'){    
			
			  if(parent.f_query_add_mod.document.Bkappt_form.rd_appt_yn.value=='Y'){
			  if(parent.f_query_add_mod.document.Bkappt_form.follow_visit_type_yn.value=='Y'){
				if (max_appt_slots!="" && max_appt_slots !="1")	{
					if(!(parent.f_query_add_mod.document.Bkappt_form.visit_ind_count && parent.f_query_add_mod.document.Bkappt_form.visit_ind_count.value=='1')){
						var opt=parent.frames[1].document.createElement('OPTION');
						opt.value='';
						opt.text=''+getLabel("Common.defaultSelect.label","Common")+'';
						parent.frames[0].document.forms[0].no_slots.add(opt);
						parent.frames[0].document.forms[0].no_slots.remove(parent.frames[0].document.forms[0].no_slots.options[0]);
					}
					for(var i=1;i<=parseInt(max_appt_slots);i++){
						var element = parent.frames[0].document.createElement('OPTION');
						element.text = i;
						element.value= i;	
						/*Below line added for this CRF senthil*/
						if(parent.frames[0].document.forms[0].max_slot_default_yn.value=="Y") element.selected = true; 
					    //below line commented by senthil						
						//element.selected = true;   // Line Added for CRF Bru-HIMS-CRF-279 [IN:033084]
						//parent.frames[0].document.forms[0].no_slots.selectedIndex=1; // Commented for Bru-HIMS-CRF-279 [IN:033084]
						parent.frames[0].document.forms[0].no_slots.add(element);
					}
				}else if(max_appt_slots =="1"){
					var element = parent.frames[0].document.createElement('OPTION');
					element.text = 1;
					element.value= 1;
					parent.frames[0].document.forms[0].no_slots.add(element);
					parent.frames[0].document.forms[0].no_slots.options.selectedIndex=1;
					parent.frames[0].document.forms[0].no_slots.remove(parent.frames[0].document.forms[0].no_slots.options[0]);
				}
				}else{	
					
					//Condition  Changed against for CRF Bru-HIMS-CRF-279 [IN:033084]
					if ((slotsFromOrder!="0")&& (document.getElementById("visit_type_short_desc").selectedIndex !="0")){
					
					if(!(parent.f_query_add_mod.document.Bkappt_form.visit_ind_count && parent.f_query_add_mod.document.Bkappt_form.visit_ind_count.value=='1')){ 
						var opt=parent.frames[1].document.createElement('OPTION');
						opt.value='';
						opt.text=''+getLabel("Common.defaultSelect.label","Common")+'';
						parent.frames[0].document.forms[0].no_slots.add(opt);
						parent.frames[0].document.forms[0].no_slots.remove(parent.frames[0].document.forms[0].no_slots.options[0]);
					} 
					for(var i=1;i<=parseInt(slotsFromOrder);i++){
						var element = parent.frames[0].document.createElement('OPTION');
						element.text = i;
						element.value= i;
						element.selected = true;   // Line Added for CRF Bru-HIMS-CRF-279 [IN:033084]
						//parent.frames[0].document.forms[0].no_slots.selectedIndex=1; // Commented for Bru-HIMS-CRF-279 [IN:033084]
						parent.frames[0].document.forms[0].no_slots.add(element);
					}
				}
					// Condition Newly added against for CRF Bru-HIMS-CRF-279 [IN:033084]
					else if((slotsFromOrder=="0")&& (document.getElementById("visit_type_short_desc").selectedIndex !="0"))
					{
						var element = parent.frames[0].document.createElement('OPTION');
					element.text = 1;
					element.value= 1;
					parent.frames[0].document.forms[0].no_slots.add(element);
					parent.frames[0].document.forms[0].no_slots.options.selectedIndex=1;
					parent.frames[0].document.forms[0].no_slots.remove(parent.frames[0].document.forms[0].no_slots.options[0]);
					} 
					else
					{
						
						var opt = parent.frames[0].document.createElement('OPTION');
						opt.value='';
						opt.text=''+getLabel("Common.defaultSelect.label","Common")+'';
						parent.frames[0].document.forms[0].no_slots.add(opt);
						parent.frames[0].document.forms[0].no_slots.remove(parent.frames[0].document.forms[0].no_slots.options[0]);
						
						}
					
					}	//Condition End here
				 }else{
					if (max_appt_slots!="" && max_appt_slots !="1")	{
					//Added by kamatchi S for NMC-JD-CRF-0104
					if(isSlotTimeAppl=="true"){
						if(or_appt_time==""){
					if(!(parent.f_query_add_mod.document.Bkappt_form.visit_ind_count && parent.f_query_add_mod.document.Bkappt_form.visit_ind_count.value=='1')){
						var opt=parent.frames[1].document.createElement('OPTION');
						opt.value='';
						opt.text=''+getLabel("Common.defaultSelect.label","Common")+'';
						parent.frames[0].document.forms[0].no_slots.add(opt);
						parent.frames[0].document.forms[0].no_slots.remove(parent.frames[0].document.forms[0].no_slots.options[0]);
					}
					for(var i=1;i<=parseInt(max_appt_slots);i++){
						var element = parent.frames[0].document.createElement('OPTION');
						element.text = i;
						element.value= i;
						if(parent.frames[0].document.forms[0].max_slot_default_yn.value=="Y") element.selected = true; 
						parent.frames[0].document.forms[0].no_slots.add(element);
					}}}
					else{
					if(!(parent.f_query_add_mod.document.Bkappt_form.visit_ind_count && parent.f_query_add_mod.document.Bkappt_form.visit_ind_count.value=='1')){
						var opt=parent.frames[1].document.createElement('OPTION');
						opt.value='';
						opt.text=''+getLabel("Common.defaultSelect.label","Common")+'';
						parent.frames[0].document.forms[0].no_slots.add(opt);
						parent.frames[0].document.forms[0].no_slots.remove(parent.frames[0].document.forms[0].no_slots.options[0]);
					}
					for(var i=1;i<=parseInt(max_appt_slots);i++){
						var element = parent.frames[0].document.createElement('OPTION');
						element.text = i;
						element.value= i;
						/*Below line added for this CRF senthil*/
						if(parent.frames[0].document.forms[0].max_slot_default_yn.value=="Y") element.selected = true; 
					    //below line commented by senthil
					   //element.selected = true; // Line Added for CRF Bru-HIMS-CRF-279 [IN:033084]
						//parent.frames[0].document.forms[0].no_slots.selectedIndex=1; // Commented for Bru-HIMS-CRF-279 [IN:033084]
						parent.frames[0].document.forms[0].no_slots.add(element);
					}}
				}else if(max_appt_slots =="1"){
					if(isSlotTimeAppl=="true"){
						if(or_appt_time==""){
					var element = parent.frames[0].document.createElement('OPTION');
					element.text = 1;
					element.value= 1;
					parent.frames[0].document.forms[0].no_slots.add(element);
					parent.frames[0].document.forms[0].no_slots.options.selectedIndex=1;
					parent.frames[0].document.forms[0].no_slots.remove(parent.frames[0].document.forms[0].no_slots.options[0]);
				}}
				else
					{
					var element = parent.frames[0].document.createElement('OPTION');
					element.text = 1;
					element.value= 1;
					parent.frames[0].document.forms[0].no_slots.add(element);
					parent.frames[0].document.forms[0].no_slots.options.selectedIndex=1;
					parent.frames[0].document.forms[0].no_slots.remove(parent.frames[0].document.forms[0].no_slots.options[0]);
					}
				}
				}

				//if (document.forms[0].override_no_of_slots.value=="N")
				//	document.forms[0].no_slots.disabled=true;
			}
		}
		if(overbookedyn=="N"){
			var no_slots		= document.getElementById("no_slots").value;
			var fromTime		= document.getElementById("From_timeval").value;
			var toTime			= document.getElementById("totime_value").value;
			var u				= document.getElementById("visit_type_short_desc").value;
			var clinic_code		= document.getElementById("clinic_code").value;
			var practitioner_id	= document.getElementById("practitioner_id").value;
			var overbookedyn	= document.getElementById("overbooked").value;
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			if(document.forms[0].Forced.value=='Y'){
				xmlStr ="<root><SEARCH clinic_code=\""+clinic_code+"\" practitioner_id=\""+practitioner_id+"\" slot_appt_ctrl=\""+slot_appt_ctrl+"\" fromTime=\""+fromTime+"\" visit_limit_rule=\""+visit_limit_rule+"\" no_of_slots=\""+no_slots+"\" firstvisit=\""+u2+"\" toTime=\""+toTime+"\" clinic_date=\""+clinic_date+"\" visit_typ_cd = \""+u1+"\" visit_type_val=\""+u2+"\" overbookedyn = \""+overbookedyn+"\" Forced ='Y'/></root>"
			}else{
				xmlStr ="<root><SEARCH clinic_code=\""+clinic_code+"\" practitioner_id=\""+practitioner_id+"\" slot_appt_ctrl=\""+slot_appt_ctrl+"\" fromTime=\""+fromTime+"\" visit_limit_rule=\""+visit_limit_rule+"\" no_of_slots=\""+no_slots+"\" firstvisit=\""+u2+"\" toTime=\""+toTime+"\" clinic_date=\""+clinic_date+"\" visit_typ_cd = \""+u1+"\" overbookedyn = \""+overbookedyn+"\" Forced ='N'/></root>"
			}
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","VisitValidation.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText) 
		}
		if (Obj.value!=''){
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			var prm_res_class=document.getElementById("res_class").value;
			var res_typ=document.getElementById("res_type").value;
			if(time_table_type=='1' || time_table_type=='2'){
				if(document.forms[0].Forced.value=='N' && overbookedyn=='N'){
					//For checking secondary resources for a visit type.
					xmlStr ="<root><SEARCH visit_typ_cd = \""+u1+"\" prm_res_class = \""+prm_res_class+"\" res_typ = \""+res_typ+"\" overbookedyn = \""+overbookedyn+"\" Forced ='N' steps='RES'/></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","ServerSide.jsp",false)
					xmlHttp.send(xmlDoc)
					responseText=xmlHttp.responseText
					responseText = trimString(responseText)
					eval(responseText)
				}
				globalFlag=false;
				document.forms[0].globalFlag.value="";
			}
		}else{
			globalFlag=false;
			document.forms[0].globalFlag.value="";
			document.getElementById("SecResource").disabled=true;
			document.forms[0].SecResCheck.value='';
		}
	}
	//parent.document.getElementById("mainFrame").rows = '*,0,5%,0';
				parent.document.getElementById("f_query_add_mod").style.height='85vh'
				parent.document.getElementById("SecondaryFrame").style.height='0vh'
				parent.document.getElementById("ButtonFrame").style.height='5vh'
				parent.document.getElementById("messageFrame").style.height='0vh'
	callOnMouseClick1(document.getElementById("patientDet"));
	document.forms[0].sec_value_count.value="";
	document.forms[0].sec_sel.value='';
	document.forms[0].sec_sel222.value='';
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}


 	function exitval() {
		var v=getLabel("Common.Abort.label","Common");
		//parent.window.returnValue=v;
		//parent.window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = v;
    
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close(); 
	}

 	async function show_window(Val)
	{
		var patid=Bkappt_form.patient_id.value;
			if(Val=="One") {

			if(Bkappt_form.patient_name1.value!="") {
				var retVal = 	new String();
				var dialogHeight= "11.3" ;
				var dialogWidth	= "25" ;
				var status = "no";			
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; 	scroll=no; status:" + status; 
				retVal = await window.showModalDialog("../../eOA/jsp/BookAppointmentContact.jsp?patient_id="+patid+"&contactvals="+Bkappt_form.contactvals.value+"",arguments,features);
                if (retVal!=null) 
					Bkappt_form.contactvals.value=escape(retVal);
			}

		}
		else if(Val=="Two") {
		
			if(Bkappt_form.maxrecord.value!="0" || Bkappt_form.ipbookings.value!="0" || Bkappt_form.radbookings.value!="0") {
			
				var retVal = 	new String();
				var dialogHeight= "55vh" ;
				var dialogWidth	= "65vw" ;
				var status = "no";
				var dialogTop = "265" ;
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scrollWidth=yes; status: " + status+"; dialogTop :" + dialogTop ;
				var arguments	= "" ;
				retVal = await window.showModalDialog("../../eOA/jsp/BookAppointmentOther.jsp?patient_id="+patid+"",arguments,features);
			}

	     }

	}
/*Time validations related script functions*/

/*function CheckTime(obj,valt) 
{
var timefield = obj;
    var val1;
	if(parent.f_query_add_mod.document.Bkappt_form.time_table_type.value=="3") 
	{
	    if(obj.value!=''){
		if (chkTime(obj.value) == false) 
	    {			
			alert(getMessage("INVALID_TIME_FMT","SM"));
	    	timefield.select();
	    	timefield.focus();
	    	return false;
	    }
	    else
	    {
			if(valt=="FM") 
			{
				val1=valt;
			}else 
				if(valt=="TO") 
				{
					val1=valt;
				}
			if(document.getElementById("overbooked").value !="Y" && parent.frames[0].document.forms[0].time_table_type.value =="3")
			{
				timevalidation(val1);
			}
			return true;
	    }
	}
	}
	else
		return true;
}*/

function CheckTime(obj,valt) 
{
	var timefield = obj;

	if(parent.f_query_add_mod.document.Bkappt_form.time_table_type.value=="3") 
	{
	    if(obj.value!=''){
		if (chkTime(obj.value) == false) 
	    {			
			alert(getMessage("INVALID_TIME_FMT","SM"));
	    	timefield.select();
	    	timefield.focus();
	    	return false;
	    }
		}
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
	}else {
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

function timevalidation(val)
{
	
	var fromtimeh=parent.frames[0].document.forms[0].fromtimeh.value;
	var fromtime=parent.frames[0].document.forms[0].From_timeval.value;
	var totime=parent.frames[0].document.forms[0].To_timeval.value;
	var totimeh=parent.frames[0].document.forms[0].totimeh.value;
	var sys=parent.frames[0].document.forms[0].ServerDate.value;
	var apptdt=parent.frames[0].document.forms[0].appt_date.value;
	var syst=parent.frames[0].document.forms[0].ServerTime.value;
	var starttime = parent.frames[0].document.forms[0].starttime.value;
	
	fromtimeharray=fromtimeh.split(":");
	totimeharray=totimeh.split(":");
	fromtimearray=fromtime.split(":");
	totimearray=totime.split(":");
	sysarray=sys.split("/");
	apptarray=apptdt.split("/");
	systarray=syst.split(":");
	starttimearray = starttime.split(":");

	var fromhtm=new Date(1,1,1,fromtimeharray[0],fromtimeharray[1],0,0);
	var starthtm=new Date(1,1,1,starttimearray[0],starttimearray[1],0,0);
	var tohtm=new Date(1,1,1,totimeharray[0],totimeharray[1],0,0);
	var fromtm=new Date(1,1,1,fromtimearray[0],fromtimearray[1],0,0);
	var totm=new Date(1,1,1,totimearray[0],totimearray[1],0,0);
	var systm=new Date(1,1,1,systarray[0],systarray[1],0,0);
	var sysdt = new Date(sysarray[2],sysarray[1],sysarray[0]);
	var aptdt = new Date(apptarray[2],apptarray[1],apptarray[0]);
	var ob=parent.frames[0].document.forms[0].overbooked.value;
		
    if(val=="FM")
	{
		if(ob=="N")
		{
			if(Date.parse(aptdt) == Date.parse(sysdt))
			{
				if(document.getElementById("time_table_type").value =="3")
				{
					if(Date.parse(fromtm) < Date.parse(starthtm))
					{
						var err_fromtm1 =getMessage("OVERLAP_START_TIME","OA") ;
						alert(err_fromtm1);
						//document.getElementById("From_timeval").select();
						//document.getElementById("From_timeval").focus();
						document.getElementById("From_timeval").value = fromtimeh;
					}
					else if((Date.parse(fromtm) < Date.parse(fromhtm)) || (Date.parse(fromtm) > Date.parse(tohtm)))
					{
						var err_fromtm1 =getMessage("APPT_OVERLAP","OA") ;
						alert(err_fromtm1);
						//document.getElementById("From_timeval").select();
						//document.getElementById("From_timeval").focus();
						document.getElementById("From_timeval").value = fromtimeh;
					}
					else
					{
						parent.document.frames[1].window.location.href='../../eOA/jsp/ApptDetailsErr.jsp?err_num=';
					}
				 }
			  }
			  else
				{
				  if(Date.parse(fromtm) < Date.parse(starthtm))
				  {
					var err_fromtm1 =getMessage("OVERLAP_START_TIME","OA") ;
					alert(err_fromtm1);
					//document.getElementById("From_timeval").select();
					//document.getElementById("From_timeval").focus();
					document.getElementById("From_timeval").value = fromtimeh;
				 }
				  else if((Date.parse(fromtm) < Date.parse(fromhtm)) || (Date.parse(fromtm) > Date.parse(tohtm)))
				  {
					var err_fromtm1 =getMessage("APPT_OVERLAP","OA") ;
					alert(err_fromtm1);
					//document.getElementById("From_timeval").select();
					//document.getElementById("From_timeval").focus();
					document.getElementById("From_timeval").value = fromtimeh;
				  }
				else
				{
				parent.document.frames[1].window.location.href='../../eOA/jsp/ApptDetailsErr.jsp?err_num=';
				}
			}
		}
		
	}
	else if(val=="TO")
	{
		if(Date.parse(aptdt) == Date.parse(sysdt))
		{
			if(document.getElementById("time_table_type").value =="3")
			{
				if(Date.parse(totm) > Date.parse(tohtm))
				{
                   var break_flag = document.forms[0].break_flag.value;
				    var errs="";
				    if (break_flag=="Y")

					   errs=getMessage("OVERLAP_BRK_TIME","OA") ;
					else
					   errs=getMessage("OVERLAP_END_TIME","OA") ;
					alert(errs);
					document.getElementById("To_timeval").value = totimeh;
				}
				else
				{ 
					parent.document.frames[1].window.location.href='../../eOA/jsp/ApptDetailsErr.jsp?err_num=';
				}
			}		
			
		}
		else
		{
			if(document.getElementById("time_table_type").value =="3") 
			{
				if(Date.parse(totm) > Date.parse(tohtm))
				{
                    var break_flag = document.forms[0].break_flag.value;
				    var errs="";
				    if (break_flag=="Y")
					   errs=getMessage("OVERLAP_BRK_TIME","OA") ;
					else
					   errs=getMessage("OVERLAP_END_TIME","OA") ;
					alert(errs);
					document.getElementById("To_timeval").value = totimeh;
				}
				
				else
				{ 
					parent.document.frames[1].window.location.href='../../eOA/jsp/ApptDetailsErr.jsp?err_num=';
				}				
			}	
		}
	}
}

async function OpenModel_refral(){
				var retVal = 	new String();
				var dialogHeight= "90vh" ;
				var dialogTop = "0" ;
                var dialogWidth="80vw";
				var status = "no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;			
				var p_to_locn_code=document.forms[0].clinic_id.value;
				var p_to_pract_id=document.forms[0].pract_id.value;
				var p_to_pract_name=document.forms[0].practname.value;
				var p_speciality_code=document.forms[0].speciality_code.value;
				var p_service_code=document.forms[0].service_code.value;
				var resorce_type=document.forms[0].res_class.value;
				var p_to_locn_type=document.forms[0].clinic_type.value;
				var from_page=document.forms[0].from_page.value;				
				var ca_patient_id=parent.f_query_add_mod.document.Bkappt_form.ca_patient_id_new.value;
				var wait_patient_id=parent.frames[0].document.forms[0].patient_id.value;
				var waitListNo=parent.f_query_add_mod.document.Bkappt_form.waitListNo.value
				if (from_page == "modifyappt")
				{
				if(p_to_pract_id!=''){
				var 	callurl="../../eMP/jsp/ReferralSearchFrameset.jsp?p_to_locn_code="+p_to_locn_code+"&p_to_pract_id="+p_to_pract_id+"&p_to_pract_name="+encodeURIComponent(p_to_pract_name)+"&p_speciality_code="+p_speciality_code+"&resorce_type="+resorce_type+"&p_service_code="+p_service_code+"&p_calling_function=OA_MODIFY_APPT&p_select=YES&p_reg_patient=NO&p_to_locn_type="+p_to_locn_type+"&ca_patient_id="+ca_patient_id+"&p_patient_id="+wait_patient_id+"&waitListNo="+waitListNo;				
				retVal = await window.showModalDialog(callurl,arguments,features);
				}
				else{
				var callurl="../../eMP/jsp/ReferralSearchFrameset.jsp?p_to_locn_type="+p_to_locn_type+"&p_to_locn_code="+p_to_locn_code+"&p_speciality_code="+p_speciality_code+"&resorce_type="+resorce_type+"&p_service_code="+p_service_code+"&p_calling_function=OA_MODIFY_APPT&p_select=YES&p_reg_patient=NO&p_to_locn_type="+p_to_locn_type+"&ca_patient_id="+ca_patient_id+"&p_patient_id="+wait_patient_id+"&waitListNo="+waitListNo;
				retVal = await window.showModalDialog(callurl,arguments,features);						
				}
				if(retVal!=null){
					validpatient_refral(retVal,'modal')
				}
				} else {	
				if(p_to_pract_id!=''){
				var 	callurl="../../eMP/jsp/ReferralSearchFrameset.jsp?p_to_locn_code="+p_to_locn_code+"&p_to_pract_id="+p_to_pract_id+"&p_to_pract_name="+encodeURIComponent(p_to_pract_name)+"&p_speciality_code="+p_speciality_code+"&resorce_type="+resorce_type+"&p_service_code="+p_service_code+"&p_calling_function=OA_BOOK_APPT&p_select=YES&p_reg_patient=NO&p_to_locn_type="+p_to_locn_type+"&ca_patient_id="+ca_patient_id+"&p_patient_id="+wait_patient_id+"&waitListNo="+waitListNo;				
				retVal = await window.showModalDialog(callurl,arguments,features);
				}
				else{
				var callurl="../../eMP/jsp/ReferralSearchFrameset.jsp?p_to_locn_type="+p_to_locn_type+"&p_to_locn_code="+p_to_locn_code+"&p_speciality_code="+p_speciality_code+"&resorce_type="+resorce_type+"&p_service_code="+p_service_code+"&p_calling_function=OA_BOOK_APPT&p_select=YES&p_reg_patient=NO&p_to_locn_type="+p_to_locn_type+"&ca_patient_id="+ca_patient_id+"&p_patient_id="+wait_patient_id+"&waitListNo="+waitListNo;
				retVal = await window.showModalDialog(callurl,arguments,features);						
				}
				if(retVal!=null){
					validpatient_refral(retVal,'modal')
				}
				}

			var xmlHttp 	= new XMLHttpRequest();					xmlHttp.open("POST","../../eCommon/jsp/commonToolbar.jsp?menu_id=OA&module_id=OA&function_id=TRANSFER_CANCEL_APPT&function_name=Transfer%2FCancel%20Appointment&function_type=F&access=NNNNN&desktopFlag=N",false);
					xmlHttp.send(null);		
					responseText=xmlHttp.responseText;
}

function validpatient_refral1(obj,type){
	if(document.forms[0].patient_id.value==''){
		validpatient_refral(obj,type)
	}
}
function validpatient_refral(obj,type){
	var ref_id, chk_str;
	var facilityid=parent.frames[0].document.forms[0].facilityid.value;
	var p_speciality_code=document.forms[0].speciality_code.value;
	var flag=true;
	if(type!='modal'){
	var ref_id = obj.value;
	}
	else{
	ref_id=obj;	
	}

	chk_str = ref_id.substr(0,2);
		if(ref_id !='') {
			



			parent.frames[0].document.forms[0].source.value=ref_id;


	var from_page=parent.f_query_add_mod.document.Bkappt_form.from_page.value;

if(parent.f_query_add_mod.document.Bkappt_form.from_page.value !="modifyappt")
			{

			var u=parent.frames[0].document.forms[0].visit_type_short_desc.value;
					strVisitArray = u.split("~");
					var u1=strVisitArray[0];
					var u2=strVisitArray[1];
					if(parent.f_query_add_mod.document.Bkappt_form.waitListNo.value =="")
			{
					var ca_patient_id=parent.f_query_add_mod.document.Bkappt_form.ca_patient_id_new.value;
			}else
			{
				var ca_patient_id=parent.frames[0].document.forms[0].patient_id.value;

			}
		

if((parent.f_query_add_mod.document.Bkappt_form.ca_patient_id_new.value !="" && parent.f_query_add_mod.document.Bkappt_form.CallingMode.value =="CA" && parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value=="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u2=="F") 
	|| ( parent.f_query_add_mod.document.Bkappt_form.waitListNo.value !="" && parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value=="Y" && parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="N" && u2=="F")) 
{
		
		
		var xmlDoc= "" ;
			var xmlHttp= new XMLHttpRequest() ;

			xmlStr	="<root><SEARCH " ;
			xmlStr += "ref_id=\""+ref_id+"\"  ca_patient_id=\""+ca_patient_id+"\" steps='validate_CA_referral'";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);			
			if(flag!="1")
			{				
				alert(getMessage("PATIENT_ID_MISMATCH","OA"));
				parent.frames[0].document.forms[0].source.value="";
				flag=false;
			}
}
		}else
		{ 
			var referral_id = obj.value;
			var patient_id=parent.frames[0].document.forms[0].hddPat_id_new.value;	
			var clinic_code=parent.frames[0].document.forms[0].clinic_code.value;	
			
			if(patient_id !="")
			{
			var xmlDoc= "" ;
			var xmlHttp= new XMLHttpRequest() ;			
			xmlStr	="<root><SEARCH " ;
			xmlStr += "ref_id=\""+ref_id+"\"  ca_patient_id=\""+patient_id+"\" clinic_code=\""+clinic_code+"\" type=\""+type+"\" steps='validate_CA_referral'";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");			
			xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);					
			if(flag!="1")
			{				
				alert(getMessage("MISMATCH_REFERRALID_PATIENTID","COMMON"));
				parent.frames[0].document.forms[0].source.value="";
				flag=false;
			}
			}
		//	parent.frames[0].document.forms[0].source.disabled=true;
			parent.frames[0].document.forms[0].visit_type_short_desc.disabled=true
				
				
		}
			
		if(flag==true)
			{
			var calledFor="";
			var apptrefno="";
			if(parent.f_query_add_mod.document.Bkappt_form.from_page.value !="modifyappt")
			{
				calledFor="Referal";
			}else
			{
				calledFor="modify_appt";
				apptrefno=parent.f_query_add_mod.document.Bkappt_form.apptrefno.value;
			}
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH alcn_criteria_pop=\""+document.getElementById("alcn_criteria").value+"\" ref_id=\""+document.getElementById("source").value+"\" service_code=\""+document.getElementById("service_code").value+"\" clinic_code=\""+document.getElementById("clinic_code").value+"\" p_speciality_code=\""+p_speciality_code+"\" pract_id=\""+document.getElementById("pract_id").value+"\" apptrefno=\""+apptrefno+"\" from_page=\""+from_page+"\" calledFor=\""+calledFor+"\" /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","BookAppointmentReferral.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText) 
			}
			if(calledFor =="modify_appt")
			{
				parent.f_query_add_mod.document.Bkappt_form.pref_date.disabled=true;
				parent.f_query_add_mod.document.Bkappt_form.priorty.disabled=true;
				parent.f_query_add_mod.document.getElementById("dob1").disabled=true;
				if(parent.frames[0].document.forms[0].name_prefix_oth_lang){
				parent.frames[0].document.forms[0].name_prefix_oth_lang.disabled=true;
				}
			}			
			validpatient('P');
		}else{
			
			//clearAll1();
			parent.f_query_add_mod.document.Bkappt_form.source.disabled=false;
		}
	
	
}
async function past_visits_view(){
	var patient_id=parent.frames[0].document.forms[0].patient_id.value;
	var service_code=parent.frames[0].document.forms[0].service_code.value;
	var retVal = 	new String();
	var dialogHeight= "90vh" ;
	var dialogTop = "100" ;
	var dialogWidth	= "60vw" ;
	var status = "no";
	var scroll = "no";
	if(patient_id!=''){
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;

	var callurl="../../eMP/jsp/vwEncounterDetailFrames.jsp?patientid="+patient_id;

	retVal = await top.window.showModalDialog(callurl,arguments,features);
	}
} 

async function last_visits_view(){
				var patient_id=parent.frames[0].document.forms[0].patient_id.value;
				var retVal = 	new String();
			    var dialogHeight= "25" ;
			    var dialogWidth = "40" ;
			    var dialogTop = "100" ;
			    var status = "no";
				var scroll = "no";
				var encounter_id =parent.frames[0].document.forms[0].last_encounter_id.value;
				var last_service_encounter_id =parent.frames[0].document.forms[0].last_service_encounter_id.value;


				if(patient_id!=''){
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
				var callurl ="../../eOP/jsp/VisitRegistrationLastVisitDetails.jsp?encounter_id="+encounter_id+"&service_encounter_id="+last_service_encounter_id;
				retVal = await window.showModalDialog(callurl,arguments,features);
				}
}


function localValidations(inVal) {
	if(parent.frames[0].document.forms[0].bf!=null)
		parent.frames[0].document.forms[0].bf.disabled=true;

	if(parent.frames[0].document.forms[0].pat_names_in_oth_lang_yn.value=="Y" && parent.frames[0].document.forms[0].bfo!=null)
		parent.frames[0].document.forms[0].bfo.disabled=true;

	if(parent.frames[0].document.forms[0].bs!=null)
		parent.frames[0].document.forms[0].bs.disabled=true;

	if(parent.frames[0].document.forms[0].pat_names_in_oth_lang_yn.value=="Y" && parent.frames[0].document.forms[0].bso!=null)
		parent.frames[0].document.forms[0].bso.disabled=true;

	if(parent.frames[0].document.forms[0].bt!=null)
		parent.frames[0].document.forms[0].bt.disabled=true;

	if(parent.frames[0].document.forms[0].pat_names_in_oth_lang_yn.value=="Y" && parent.frames[0].document.forms[0].bto!=null)
		parent.frames[0].document.forms[0].bto.disabled=true;

	if(parent.frames[0].document.forms[0].bfam!=null)
		parent.frames[0].document.forms[0].bfam.disabled=true;

	if(parent.frames[0].document.forms[0].pat_names_in_oth_lang_yn.value=="Y" && parent.frames[0].document.forms[0].bfo!=null){
		if(parent.frames[0].document.forms[0].bfamo)
			parent.frames[0].document.forms[0].bfamo.disabled=true;
	}
	//validpatient('P');
	/*Commented above line and Below If Condition is added by Rameswar Against SKR-SCF-1099 on 3rd Sept 2015*/
	if (parent.f_query_add_mod.document.Bkappt_form.from_page.value !="modifyappt")
	{
		validpatient('P');
	}
	
}

function validpatient(inVal) {
	document.forms[0].reason.focus();
	parent.frames[2].document.getElementById("other_id1").style.visibility='hidden';
	if(document.getElementById("patient_id").value!=""){
		var HTMLVal = new String();
		parent.frames[0].document.forms[0].nationality_code1.disabled=false;
		var u=parent.frames[0].document.forms[0].visit_type_short_desc.value;
		strVisitArray = u.split("~");
		var u1=strVisitArray[0];
		var u2=strVisitArray[1];		
		if(u2 =='S'){
			if(parent.frames[2].document.forms[0].recurring){
				parent.frames[2].document.forms[0].recurring.disabled=false;
			}
		}
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		
		//xmlStr ="<root><SEARCH step=\""+inVal+"\" pat_id=\""+document.getElementById("patient_id").value+"\" alcn_criteria_pop=\""+document.getElementById("alcn_criteria").value+"\"  service_code=\""+document.getElementById("service_code").value+"\"  clinic_code=\""+document.getElementById("clinic_code").value+"\"  rad_installed_yn=\""+document.getElementById("rad_installed_yn").value+"\" ip_installed_yn=\""+document.getElementById("ip_installed_yn").value+"\"  visit_type_cd=\""+u2+"\"  age_group_code=\""+document.getElementById("age_group_code").value+"\" /></root>"
		
	
   //below line was added by venkatesh.S(4008) on 16-Mar-2012 anaginst Bru-HIMS-CRF-168 [IN030287]_0A
	xmlStr ="<root><SEARCH step=\""+inVal+"\" pat_id=\""+document.getElementById("patient_id").value+"\" alcn_criteria_pop=\""+document.getElementById("alcn_criteria").value+"\"  service_code=\""+document.getElementById("service_code").value+"\"  sel_service_code=\""+document.getElementById("sel_service_code").value+"\"  clinic_code=\""+document.getElementById("clinic_code").value+"\"  rad_installed_yn=\""+document.getElementById("rad_installed_yn").value+"\" dtl_msg_yn=\""+document.forms[0].dtl_msg_yn.value+"\" speciality_code=\""+document.forms[0].speciality_code.value+"\" ip_installed_yn=\""+document.getElementById("ip_installed_yn").value+"\"  visit_type_cd=\""+u2+"\"  age_group_code=\""+document.getElementById("age_group_code").value+"\" /></root>"
	//end  Bru-HIMS-CRF-168 [IN030287]_0A

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","BookAppointmentValidations.jsp",false);
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText;
		eval(responseText) ;
		if((document.forms[0].per_chk_for_no_show_alert.value !="" && document.forms[0].per_chk_for_no_show_alert.value > 0) && (document.forms[0].no_of_noshow_appts_for_alert.value !="") && document.forms[0].no_of_noshow_appts_for_alert.value >0){//added to check no show appointments only when we have a value in OA PARAM
			var xmlDoc= "" ;
			var xmlHttp= new XMLHttpRequest() ;
			xmlStr	="<root><SEARCH " ;
			xmlStr += "patient_id=\""+document.getElementById("patient_id").value+"\"  steps='No_Show_appt'";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);
			if(Flag==true){
				var err_msg=getMessage("PATIENT_PREV_NOSHOW_APPTS","OA");
				alert(err_msg);
				parent.frames[2].document.forms[0].no_show_appt.style.visibility='visible';
			}else{
				parent.frames[2].document.forms[0].no_show_appt.style.visibility='hidden';
			}
		}

	//Bru-HIMS-CRF- 169 changes start
		if(parent.frames[0].document.forms[0].CallingMode.value!='OP' && parent.frames[0].document.forms[0].CallingMode.value!='RSCAPPT'){			
			if(parent.frames[0].document.forms[0].MaxcancelAlert.value == 'N'){//fix for regression issue
				checkMaxPatCnclReason();
				}
		}
		//Bru-HIMS-CRF- 169 changes end

	}else{
		parent.frames[0].document.forms[0].patient_SecurityLevel.value="";
		parent.frames[2].document.forms[0].previous_encounter.disabled=true;
		if(document.getElementById("other_id1")!=null)
			document.getElementById("other_id1").style.visibility='hidden';
		if(parent.frames[2].document.forms[0].recurring){
			parent.frames[2].document.forms[0].recurring.disabled=true;
		}
		if(parent.frames[2].document.forms[0].no_show_appt){
			parent.frames[2].document.forms[0].no_show_appt.style.visibility='hidden';
		}
		if(document.getElementById("source").value==""){
			if (parent.f_query_add_mod.document.Bkappt_form.allow_referral_yn.value =="Y"){
				parent.frames[0].document.forms[0].source.disabled=false;
				parent.frames[0].document.forms[0].source.readonly=false;
				parent.frames[0].document.forms[0].search1.disabled=false;
			}
			parent.frames[2].document.forms[0].previous_encounter.disabled=true;	
			parent.frames[0].document.forms[0].contactvals.value="";	
			parent.frames[0].document.forms[0].patient_id.value="";
			parent.frames[0].document.getElementById("patient_name1").innerHTML="&nbsp";
			
			if(parent.f_query_add_mod.document.Bkappt_form.allow_non_referral_yn.value =="Y"){
				if(parent.frames[0].document.forms[0].national_id !=null){
					parent.frames[0].document.forms[0].national_id.value="";
					parent.frames[0].document.forms[0].national_id.disabled=false;
				}
				if(parent.frames[0].document.forms[0].name_prefix != null){
					parent.frames[0].document.forms[0].name_prefix.disabled=false;
					parent.frames[0].document.forms[0].name_prefix.value="";
					if(parent.frames[0].document.forms[0].name_prefix1 !=null){
						parent.frames[0].document.forms[0].name_prefix1.value="";
					}
				}
				if(parent.frames[0].document.forms[0].first_name !=null){
					parent.frames[0].document.forms[0].first_name.value="";
					parent.frames[0].document.forms[0].first_name.readOnly=false;
				}
				if(parent.frames[0].document.forms[0].second_name !=null){
					parent.frames[0].document.forms[0].second_name.value="";
					parent.frames[0].document.forms[0].second_name.readOnly=false;
				}
				if(parent.frames[0].document.forms[0].third_name !=null){
					parent.frames[0].document.forms[0].third_name.value="";
					parent.frames[0].document.forms[0].third_name.readOnly=false;
				}
				if(parent.frames[0].document.forms[0].family_name !=null){
					parent.frames[0].document.forms[0].family_name.value="";
					parent.frames[0].document.forms[0].family_name.readOnly=false;
				}
				if(parent.frames[0].document.forms[0].name_suffix !=null){
					parent.frames[0].document.forms[0].name_suffix.value="";
					if (parent.frames[0].document.forms[0].name_suffix != null){
						parent.frames[0].document.forms[0].name_suffix.value="";
						parent.frames[0].document.forms[0].name_suffix.disabled=false;
					}
				}
				parent.frames[0].document.forms[0].sex.value="";
				parent.frames[0].document.forms[0].sex.disabled=false;
				parent.frames[0].document.forms[0].date_of_birth.value="";
				parent.frames[0].document.forms[0].date_of_birth.readOnly=false;
				parent.frames[0].document.getElementById("dob").disabled=true;
				parent.frames[0].document.forms[0].b_age.value="";
				parent.frames[0].document.forms[0].b_age.readOnly=false;
				parent.frames[0].document.forms[0].b_months.value="";
				parent.frames[0].document.forms[0].b_months.readOnly=false;
				parent.frames[0].document.getElementById("dob").disabled =false;
				//parent.frames[0].document.forms[0].nationality_code1.value="";
				//parent.frames[0].document.forms[0].nationality_desc.value="";
				parent.frames[0].document.forms[0].nationality_desc.disabled=false;
				parent.frames[0].document.forms[0].b_days.value="";
				parent.frames[0].document.forms[0].b_days.readOnly=false;
				parent.frames[0].document.forms[0].date_of_birth.value="";
			}
			clear_func()

		}
		if(parent.frames[0].document.forms[0].national_id_no){
		//	parent.frames[0].document.forms[0].national_id_no.value=""; Commented By Dharma Against IN:050748 on 28th Aug 2014 
			parent.frames[0].document.forms[0].national_id_no.disabled=false;
		}
		if(parent.frames[0].document.forms[0].alt_id1_no){
			//parent.frames[0].document.forms[0].alt_id1_no.value=""; Commented By Dharma Against IN:050748 on 28th Aug 2014 
			parent.frames[0].document.forms[0].alt_id1_no.disabled=false;
		}
		if(parent.frames[0].document.forms[0].alt_id2_no){
			//parent.frames[0].document.forms[0].alt_id2_no.value=""; Commented By Dharma Against IN:050748 on 28th Aug 2014 
			parent.frames[0].document.forms[0].alt_id2_no.disabled=false;
		}
		if(parent.frames[0].document.forms[0].alt_id3_no){
			//parent.frames[0].document.forms[0].alt_id3_no.value=""; Commented By Dharma Against IN:050748 on 28th Aug 2014 
			parent.frames[0].document.forms[0].alt_id3_no.disabled=false;
		}
		if(parent.frames[0].document.forms[0].alt_id4_no){
			//parent.frames[0].document.forms[0].alt_id4_no.value=""; Commented By Dharma Against IN:050748 on 28th Aug 2014 
			parent.frames[0].document.forms[0].alt_id4_no.disabled=false;
		}
		if(parent.frames[0].document.forms[0].alt_id1_exp_date){
			//parent.frames[0].document.forms[0].alt_id1_exp_date.value=""; Commented By Dharma Against IN:050748 on 28th Aug 2014 
			parent.frames[0].document.forms[0].alt_id1_exp_date.disabled=false;
		}
		if(parent.frames[0].document.forms[0].alt_id2_exp_date){
			//parent.frames[0].document.forms[0].alt_id2_exp_date.value=""; Commented By Dharma Against IN:050748 on 28th Aug 2014 
			parent.frames[0].document.forms[0].alt_id2_exp_date.disabled=false;
		}
		if(parent.frames[0].document.forms[0].alt_id3_exp_date){
			//parent.frames[0].document.forms[0].alt_id3_exp_date.value=""; Commented By Dharma Against IN:050748 on 28th Aug 2014 
			parent.frames[0].document.forms[0].alt_id3_exp_date.disabled=false;
		}
		if(parent.frames[0].document.forms[0].alt_id4_exp_date){
			//parent.frames[0].document.forms[0].alt_id4_exp_date.value=""; Commented By Dharma Against IN:050748 on 28th Aug 2014 
			parent.frames[0].document.forms[0].alt_id4_exp_date.disabled=false;
		}
		if(parent.frames[0].document.forms[0].other_alt_type){
			//parent.frames[0].document.forms[0].other_alt_type.value=""; Commented By Dharma Against IN:050748 on 28th Aug 2014 
			parent.frames[0].document.forms[0].other_alt_type.disabled=false;
		}
		if(parent.frames[0].document.forms[0].other_alt_Id){
			//parent.frames[0].document.forms[0].other_alt_Id.value=""; Commented By Dharma Against IN:050748 on 28th Aug 2014 
			parent.frames[0].document.forms[0].other_alt_Id.disabled=false;
		}
	}
	loadEthnicSubGroup();
}



function prioritychk(obj){
	if(obj.value==""){
		document.getElementById("prior").style.visibility='hidden';
	}else{
		document.getElementById("prior").style.visibility='visible';
	}
}

function setToTime(val,limit)
{
	
	if (val=='3' && document.getElementById("overbooked").value !='Y'){
		j = document.getElementById("visit_type_short_desc").selectedIndex;
		if (j != 0){
			mins = max_dur_Array[j-1];
			fromTime = document.getElementById("From_timeval").value;
			fromTimeArray = fromTime.split(":");
			toTimeArray = limit.split(":");
			if (mins >0){
				hrs = mins / 60;
				mins = mins % 60;
				hrs = parseInt(hrs);
				if (fromTimeArray[0].indexOf("0") == 0)fromTimeArray[0] = fromTimeArray[0].substring(1,fromTimeArray[0].length);
				if (fromTimeArray[1].indexOf("0") == 0)fromTimeArray[1] = fromTimeArray[1].substring(1,fromTimeArray[1].length);
				if (toTimeArray[0].indexOf("0") == 0)toTimeArray[0] = toTimeArray[0].substring(1,fromTimeArray[0].length);
				if (toTimeArray[1].indexOf("0") == 0)toTimeArray[1] = toTimeArray[1].substring(1,fromTimeArray[1].length);
				hrs = parseInt(fromTimeArray[0])+hrs;
				mins = parseInt(fromTimeArray[1])+mins;
				if (mins >= 60){
					hrs++;
					mins =  mins % 60;
				}
				if ((hrs >= parseInt(toTimeArray[0]))&(mins > parseInt(toTimeArray[1]))){
					alert(getMessage("OVERLAP_END_TIME","OA"));
					document.getElementById("To_timeval").value = limit;	
				}else {
					if (hrs < 10)hrs ='0' + hrs;
					if (mins < 10)mins ='0' + mins;
					document.getElementById("To_timeval").value = hrs+':'+mins;
					
				}
			}else{
				document.getElementById("To_timeval").value = fromTime;
			}			
		}else document.getElementById("To_timeval").value = limit;
	}
	
		
}
/*Script function for BookApptButton.jsp*/

function calthis(fromWh)
{	
   
		var sec_resorces_req=top.frames[1].document.forms[0].sec_resorces_req.value;
		var sec_resorces=top.frames[1].document.forms[0].sec_resorces.value;
		var resourcesSelected=parent.frames[1].document.forms[0].selectedResources.value;
		var sec_req=parent.frames[1].document.forms[0].sec_req.value;
		var sel_mandatory=parent.frames[1].document.forms[0].selectMandatory.value;
		var sel_man="";
		var sel="N";
		var xarr=sec_resorces_req.split(",");
		var xarr1=sec_resorces.split(",");
		var msg="";
	
		var flgP=false;
		var flgE=false;
		var flgO=false;
		var flgR=false;
		var flag=false;
		
		var man='';
	    var ind1=sec_req.indexOf('E');
		if (ind1!=-1) {
			  ind1+=2;
			  man=sec_req.substr(ind1,1);
			 
			  if (man=='Y') {
				  if (sel_mandatory.indexOf('E')==-1)
				  flgE=true;
			  }
		  }
		  man='';
		 var ind2=sec_req.indexOf('P');
		  if (ind2!=-1) {
			  ind2+=2;
			  man=sec_req.substr(ind2,1);
			 
			  if (man=='Y') {if (sel_mandatory.indexOf('P')==-1) flgP=true;}
		  }
		  man='';
		 var ind3=sec_req.indexOf('O');
		  if (ind3!=-1) {
			  ind3+=2;
			  man=sec_req.substr(ind3,1);
			 
			  if (man=='Y') {if (sel_mandatory.indexOf('O')==-1) flgO=true;}
		  }
		  man='';
		  var ind4=sec_req.indexOf('R');
		  if (ind4!=-1) {
			  ind4+=2;
			  man=sec_req.substr(ind4,1);
			  
			  if (man=='Y') {if (sel_mandatory.indexOf('R')==-1) flgR=true;}
		  }
   
	if( (flgP || flgO || flgE || flgR) && fromWh=='Confirm'){
		
		return false;
	}else{
		
       
		top.frames[0].document.forms[0].sec_sel.value=resourcesSelected;
		return true;
		
	}
		


		
}
function freeFormateCheck()
{
	
	var sec_req=parent.frames[0].document.forms[0].sec_req.value;
	var from_time=parent.frames[0].document.forms[0].From_timeval.value;
	var to_time=parent.f_query_add_mod.document.Bkappt_form.To_timeval.value;
	var clinic_start_time=parent.frames[0].document.forms[0].starttime.value
	var clinic_end_time=parent.frames[0].document.forms[0].endtime.value;
	var clinic_code=parent.frames[0].document.Bkappt_form.clinic_code.value
	var clinic_date=parent.frames[0].document.Bkappt_form.apptdate.value
	var facilityid=parent.frames[0].document.Bkappt_form.facilityid.value
	var pract_id=parent.frames[0].document.Bkappt_form.practitioner_id.value;
	var apptrefno=parent.frames[0].document.Bkappt_form.apptrefno.value;
	var overbooked_yn=	parent.frames[0].document.Bkappt_form.overbooked.value;

	if(apptrefno==null || apptrefno=='')apptrefno="";

	if(to_time <= from_time && overbooked_yn == "N"){
		
	var error=getMessage("TO_TIME_GRT_FROM_TIME","OA");
	error=error.replace("$",getLabel('Common.totime.label','common_labels'));
	error=error.replace("#",getLabel('Common.fromtime.label','common_labels'));
   alert(error);
	} 
	
	else{
	
	var xmlDoc= "" ;
	var xmlHttp= new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH facilityid = \""+facilityid+"\" clinic_code=\""+clinic_code+"\" clinic_date=\""+clinic_date+"\" pract_id=\""+pract_id+"\" from_time=\""+from_time+"\" to_time=\""+to_time+"\" appt_ref_no=\""+apptrefno+"\" steps='free_formate_check'";
	xmlStr +=" /></root>" ;
   // alert("xmlStr==="+xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
	
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	
	responseText=eval(responseText);
	
	
	if(responseText=='1'){
	
		
		var error=getMessage("OVERLAP_WITH_BRK_TIME","OA");
		
			error=error.replace("$",getLabel('Common.totime.label','common_labels'));
			
			alert(error);
		parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}	
	//eval(responseText);
	if(responseText=='2'){
		
		var error=getMessage("OVERLAP_WITH_BRK_TIME","OA");
		
			error=error.replace("$",getLabel('Common.fromtime.label','common_labels'));
			
			alert(error);
		parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}	

	if(responseText=='3'){
		
		var error=getMessage("APPT_WITH_OVERLAP","OA");
		
			error=error.replace("$",getLabel('Common.fromtime.label','common_labels'));
			
			alert(error);
		parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}	
	if(responseText=='4'){
		
		var error=getMessage("APPT_WITH_OVERLAP","OA");
		
			error=error.replace("$",getLabel('Common.totime.label','common_labels'));
			
			alert(error);
		parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}
	if(responseText=='5'){
		
          var error=getMessage("APPT_OVERLAP","OA");
		alert(error);
		parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}	
	if(responseText=='6'){
		
		var error=getMessage("BREAK_TIME_OVERLAPS","OA");
		alert(error);
		parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}
	if(responseText=='7'){
		
		var error=getMessage("OVERLAP_WITH_START_TIME","OA");
		
			error=error.replace("$",getLabel('Common.fromtime.label','common_labels'));
			
			alert(error);
		parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}
	if(responseText=='8'){
		
		var error=getMessage("OVERLAP_WITH_END_TIME","OA");
		
			error=error.replace("$",getLabel('Common.fromtime.label','common_labels'));
			
			alert(error);
		parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}
	if(responseText=='9'){
		
		var error=getMessage("OVERLAP_WITH_START_TIME","OA");
		
			error=error.replace("$",getLabel('Common.totime.label','common_labels'));
			
			alert(error);
		parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}
	if(responseText=='10'){
		
		var error=getMessage("OVERLAP_WITH_END_TIME","OA");
		
			error=error.replace("$",getLabel('Common.totime.label','common_labels'));
			
			alert(error);
		parent.frames[2].document.forms[0].Insupd.disabled=false;
		return false;
	}
	if(responseText=='0'){
	
		//alert("Success");
		parent.frames[2].document.forms[0].Insupd.disabled=false;
		return true;
	}	
}

}
function callFuncs()
{  
	if(parent.frames[0].document.forms[0].isVirtualCons.value == 'true' && parent.frames[0].document.forms[0].isVCEnbl.value == 'E'){		
		if(parent.frames[0].document.forms[0].patient_id.value == ''){
			var err = getMessage("CAN_NOT_BE_BLANK","COMMON");
			err = err.replace('$', 'Patient ID');
			alert(err);
			return;
		}		
		if(parent.frames[0].document.forms[0].email.value == '' &&  parent.frames[0].document.forms[0].contact2_no.value == ''){
			var error=getMessage("UPDATE_MOB_NO_N_EMAIL","COMMON");
			error = error.replace('?', 'Email ID and Mobile No');
			alert(error);
			return ;
		}else if(parent.frames[0].document.forms[0].email.value == ''){
			var error=getMessage("UPDATE_MOB_NO_N_EMAIL","COMMON");
			error = error.replace('?', 'Email ID');
			alert(error);
			return ;
		}else if(parent.frames[0].document.forms[0].contact2_no.value == ''){
			var error=getMessage("UPDATE_MOB_NO_N_EMAIL","COMMON");
			error = error.replace('?', 'Mobile No');
			alert(error);
			return ;
		}
	}
	if(parent.frames[0].document.forms[0].isIncRemarksLengthAppl.value=='true'){
		var remObj = parent.frames[0].document.forms[0].remarks;	
		if(remObj.value.length > 1000){
			var error = getMessage("REMARKS_CANNOT_EXCEED","common");
			var remarks = getLabel("Common.remarks.label","common");
			error = error.replace("$",remarks);
			error = error.replace("#","1000")
			alert(error);
			return;
		}
	}
	
	//parent.frames[2].document.forms[0].Insupd.disabled=true;
	var SinMul=parent.frames[0].document.forms[0].sec_value_count.value;
	
	var secReses=parent.frames[0].document.forms[0].SecResCheck.value;
	var sec_req=parent.frames[0].document.forms[0].sec_req.value; // adde 12 sep 08 
	

	if(parent.frames[0].document.forms[0].time_table_type.value=="3"){
		
		var retFlag=freeFormateCheck();
		if(!retFlag){
			return;
		}
	}
	
	if (secReses=='Y')
	{ // work
		if(parent.frames[1].document.forms[0])
		{ 		//notworing
	
			if(parent.frames[1].document.forms[0].ret_value){
		
				var ret=parent.frames[1].validate() ;
				if (!calthis('Confirm')){
					alert(getMessage("ALL_MAN_RES_NT_SL","OA"));
					parent.frames[2].document.forms[0].Insupd.disabled=false;
				}else
				{
				
					if(parent.frames[0].document.forms[0].bl_success.value=='N')
					{ 
							if(parent.frames[0].document.forms[0].bl_operational.value == 'Y' && parent.frames[0].document.forms[0].capture_fin_dtls_yn.value == 'Y'){
								alert(getMessage("FINANCIAL_DET_MANDATORY","MP"));
								parent.frames[2].document.forms[0].Insupd.disabled=false;
								return;	
							}else{

								parent.frames[0].validate_allocation_criteria();
							}
						}else{

							parent.frames[0].validate_allocation_criteria();
						}
				}
			}else if(sec_req.indexOf('Y')!=-1){///////////////
				alert(getMessage("ALL_MAN_RES_NT_SL","OA"));
				parent.frames[2].document.forms[0].Insupd.disabled=false;
			}else{///

				parent.frames[0].validate_allocation_criteria();
			}
		}else if(sec_req.indexOf('Y')!=-1)
		{   //not working
				alert(getMessage("ALL_MAN_RES_NT_SL","OA"));
				parent.frames[2].document.forms[0].Insupd.disabled=false;
		}else{
		//working
			parent.frames[0].validate_allocation_criteria();
		}
	}else if(parent.frames[0].document.forms[0].bl_success.value=="N"){	
		if(parent.frames[0].document.forms[0].bl_operational.value == "Y" && parent.frames[0].document.forms[0].capture_fin_dtls_yn.value == "Y"){
			alert(getMessage("FINANCIAL_DET_MANDATORY","MP"));
			parent.frames[2].document.forms[0].Insupd.disabled=false;
			return;	
		}else{
			parent.frames[0].validate_allocation_criteria();
		}
	}else if (secReses=='N'){
		parent.frames[0].validate_allocation_criteria();
	}else{
		parent.frames[0].validate_allocation_criteria();
	}
}


/*Script function for Allocation criteria*/

function clear_all_fun_alcn()  
{
	
	//if()

	parent.frames[0].document.forms[0].patient_id.value="";
	//parent.frames[0].document.forms[0].patient_id.focus();
 parent.frames[2].document.forms[0].Insupd.disabled=false;
	if(parent.frames[0].document.forms[0].national_id){
	//	parent.frames[0].document.forms[0].national_id.focus();
	}else{
		if(parent.frames[0].document.forms[0].sex.disabled=true)
			parent.frames[0].document.forms[0].sex.disabled=false;
		//parent.frames[0].document.forms[0].sex.focus();
	}
	if(parent.frames[0].document.getElementById("patient_name1"))
	{
	parent.frames[0].document.getElementById("patient_name1").innerHTML="&nbsp";
	}
	if(parent.frames[0].document.forms[0].national_id !=null)
	{
	parent.frames[0].document.forms[0].national_id.value="";
	parent.frames[0].document.forms[0].national_id.disabled=false;
	}
	if(parent.frames[0].document.forms[0].name_prefix!=null)
	{
	parent.frames[0].document.forms[0].name_prefix.value="";
	parent.frames[0].document.forms[0].name_prefix.disabled=false;
	}
	if(parent.frames[0].document.forms[0].first_name!=null)
	{
	parent.frames[0].document.forms[0].first_name.value="";
	parent.frames[0].document.forms[0].first_name.disabled=false;
	}
	if(parent.frames[0].document.forms[0].second_name!=null)
	{
	parent.frames[0].document.forms[0].second_name.value="";
	parent.frames[0].document.forms[0].second_name.disabled=false;
	}
	if(parent.frames[0].document.forms[0].third_name!=null)
	{
	parent.frames[0].document.forms[0].third_name.value="";
	parent.frames[0].document.forms[0].third_name.disabled=false;
	}
	if(parent.frames[0].document.forms[0].family_name!=null)
	{
	parent.frames[0].document.forms[0].family_name.value="";
	parent.frames[0].document.forms[0].family_name.disabled=false;
	}
	if(parent.frames[0].document.forms[0].name_suffix)
	{
	parent.frames[0].document.forms[0].name_suffix.value="";
	parent.frames[0].document.forms[0].name_suffix.disabled=false;
	}
	if(parent.frames[0].document.forms[0].name_prefix_oth_lang)
	{
		parent.frames[0].document.forms[0].name_prefix_oth_lang.value="";
		parent.frames[0].document.forms[0].name_prefix_oth_lang.disabled=false;
	}
	if(parent.frames[0].document.forms[0].first_name_oth_lang)
	{
		parent.frames[0].document.forms[0].first_name_oth_lang.value="";
		parent.frames[0].document.forms[0].first_name_oth_lang.disabled=false;
	}
	if(parent.frames[0].document.forms[0].second_name_oth_lang)
	{
		parent.frames[0].document.forms[0].second_name_oth_lang.value="";
		parent.frames[0].document.forms[0].second_name_oth_lang.disabled=false;
	}
	if(parent.frames[0].document.forms[0].third_name_oth_lang)
	{
		parent.frames[0].document.forms[0].third_name_oth_lang.value="";
		parent.frames[0].document.forms[0].third_name_oth_lang.disabled=false;
	}
	if(parent.frames[0].document.forms[0].family_name_oth_lang)
	{
		parent.frames[0].document.forms[0].family_name_oth_lang.value="";
		parent.frames[0].document.forms[0].family_name_oth_lang.disabled=false;
	}
	if(parent.frames[0].document.forms[0].name_suffix_oth_lang)
	{
		parent.frames[0].document.forms[0].name_suffix_oth_lang.value="";
		parent.frames[0].document.forms[0].name_suffix_oth_lang.disabled=false;
	}
	if(parent.frames[0].document.forms[0].nationality_id)
	{
		parent.frames[0].document.forms[0].nationality_id.disabled=false;
		parent.frames[0].document.forms[0].nationality_desc.disabled=false;
	}
	if(parent.frames[0].document.forms[0].pat_cat)
	{
		parent.frames[0].document.forms[0].pat_cat.disabled=false;	
	}

	/*
	if(parent.frames[0].document.forms[0].race_code) {
		parent.frames[0].document.forms[0].race_code.value="";
	}
	*/

	if(parent.frames[0].document.forms[0].race_desc) {
		parent.frames[0].document.forms[0].race_desc.value="";
	}

	parent.frames[0].document.forms[0].b_birth.disabled=false;
	parent.frames[0].document.forms[0].dob.disabled=false;
	parent.frames[0].document.forms[0].place_of_birth.disabled=false;
	parent.frames[0].document.forms[0].sex.value="";
	parent.frames[0].document.forms[0].date_of_birth.value="";
	parent.frames[0].document.forms[0].date_of_birth.disabled=false;
	parent.frames[0].document.forms[0].b_age.value="";
	parent.frames[0].document.forms[0].b_age.disabled=false;
	parent.frames[0].document.forms[0].b_months.value="";
	parent.frames[0].document.forms[0].b_months.disabled=false;
	parent.frames[0].document.forms[0].b_days.value="";
	parent.frames[0].document.forms[0].b_days.disabled=false;
	parent.frames[0].document.forms[0].contact1_no.value="";
	parent.frames[0].document.forms[0].contact2_no.value="";
	parent.frames[0].document.forms[0].email.value="";	
	parent.frames[0].document.forms[0].addr_line1.value="";	
	parent.frames[0].document.forms[0].addr_line2.value="";	
	parent.frames[0].document.forms[0].addr_line3.value="";	
	parent.frames[0].document.forms[0].addr_line4.value="";	
	parent.frames[0].document.forms[0].res_town_code.value="";	
	parent.frames[0].document.forms[0].res_area_code.value="";	
	parent.frames[0].document.forms[0].postal_code.value="";	
	parent.frames[0].document.forms[0].region_code.value="";	
	parent.frames[0].document.forms[0].country_code.value="";	
	parent.frames[0].document.forms[0].mail_addr_line1.value="";	
	parent.frames[0].document.forms[0].mail_addr_line2.value="";	
	parent.frames[0].document.forms[0].mail_addr_line3.value="";	
	parent.frames[0].document.forms[0].mail_addr_line4.value="";	
	parent.frames[0].document.forms[0].mail_res_town_code.value="";	
	parent.frames[0].document.forms[0].mail_res_area_code.value="";	
	parent.frames[0].document.forms[0].mail_postal_code.value="";	
	parent.frames[0].document.forms[0].mail_region_code.value="";	
	parent.frames[0].document.forms[0].mail_country_code.value="";	
	parent.frames[0].document.forms[0].country_desc.value="";	
	parent.frames[0].document.forms[0].mail_country_desc.value="";	
	/*Added by Thamizh selvi on 5th Jan 2018 against ML-MMOH-CRF-0601 Start*/
	parent.frames[0].document.forms[0].alt_addr_line1.value="";	
	parent.frames[0].document.forms[0].alt_addr_line2.value="";	
	parent.frames[0].document.forms[0].alt_addr_line3.value="";	
	parent.frames[0].document.forms[0].alt_addr_line4.value="";	
	parent.frames[0].document.forms[0].alt_area_code.value="";	
	parent.frames[0].document.forms[0].alt_region_code.value="";	
	parent.frames[0].document.forms[0].alt_town_code.value="";	
	parent.frames[0].document.forms[0].alt_postal_code.value="";	
	parent.frames[0].document.forms[0].alt_country_code.value="";	
	/*End*/
     parent.frames[0].document.forms[0].birth_place.value="";
	//parent.frames[0].document.forms[0].patient_id.focus();
	if(parent.frames[0].document.forms[0].pat_cat!=null)
	{
	parent.frames[0].document.forms[0].pat_cat.value="";
	}


	if(parent.frames[0].document.forms[0].national_id_no){
		parent.frames[0].document.forms[0].national_id_no.value="";
		parent.frames[0].document.forms[0].national_id_no.disabled=false;
	}

	if(parent.frames[0].document.forms[0].alt_id1_no){
		parent.frames[0].document.forms[0].alt_id1_no.value="";
		parent.frames[0].document.forms[0].alt_id1_no.disabled=false;
	}
	if(parent.frames[0].document.forms[0].alt_id2_no){
		parent.frames[0].document.forms[0].alt_id2_no.value="";
		parent.frames[0].document.forms[0].alt_id2_no.disabled=false;
	}
	if(parent.frames[0].document.forms[0].alt_id3_no){
		parent.frames[0].document.forms[0].alt_id3_no.value="";
		parent.frames[0].document.forms[0].alt_id3_no.disabled=false;
	}
	if(parent.frames[0].document.forms[0].alt_id4_no){
		parent.frames[0].document.forms[0].alt_id4_no.value="";
		parent.frames[0].document.forms[0].alt_id4_no.disabled=false;
	}


	if(parent.frames[0].document.forms[0].alt_id1_exp_date){
		parent.frames[0].document.forms[0].alt_id1_exp_date.value="";
		parent.frames[0].document.forms[0].alt_id1_exp_date.disabled=false;
	}
	if(parent.frames[0].document.forms[0].alt_id2_exp_date){
		parent.frames[0].document.forms[0].alt_id2_exp_date.value="";
		parent.frames[0].document.forms[0].alt_id2_exp_date.disabled=false;
	}
	if(parent.frames[0].document.forms[0].alt_id3_exp_date){
		parent.frames[0].document.forms[0].alt_id3_exp_date.value="";
		parent.frames[0].document.forms[0].alt_id3_exp_date.disabled=false;
	}
	if(parent.frames[0].document.forms[0].alt_id4_exp_date){
		parent.frames[0].document.forms[0].alt_id4_exp_date.value="";
		parent.frames[0].document.forms[0].alt_id4_exp_date.disabled=false;
	}
	

	if(parent.frames[0].document.forms[0].other_alt_type){
		parent.frames[0].document.forms[0].other_alt_type.value="";
		parent.frames[0].document.forms[0].other_alt_type.disabled=false;
	}
	if(parent.frames[0].document.forms[0].other_alt_Id){
		parent.frames[0].document.forms[0].other_alt_Id.value="";
		parent.frames[0].document.forms[0].other_alt_Id.disabled=false;
	}

	if(parent.frames[0].document.forms[0].family_name){
	parent.frames[0].document.forms[0].family_name.value="";
	parent.frames[0].document.forms[0].family_name.disabled=false;
	}


	if(parent.frames[0].document.forms[0].ethnic_group)
		parent.frames[0].document.forms[0].ethnic_group.value='';

if(parent.frames[0].document.forms[0].other_id1)
	{
		parent.frames[0].document.forms[0].other_id1.style.visibility='hidden';
	}

	parent.frames[0].document.forms[0].from_clear.value="Y";
	

	
	}


function patientDetClick(){
	if(document.forms[0].from_clear.value !="Y"){
		/*Below if Condition is added by Rameswar on 14th Sept  2015 against IN057512*/
		if(parent.f_query_add_mod.document.Bkappt_form.from_page.value !="modifyappt" ){
		parent.frames[2].document.getElementById("ffgh").disabled=false;}
		var sec_res_value=document.forms[0].sec_value_count.value;
		if (sec_res_value=='Y'){
			if (parent.frames[1].document.forms[0]){
				var pq=parent.frames[1].validate();
			   parent.frames[2].calthis('bookAppt');	
			}
		}else if (sec_res_value=='N'){
			if(parent.frames[1].validate('bookAppt')){
			}
		}
		if(document.forms[0].from_wait_list.value=="Y"){
			parent.frames[2].document.forms[0].clear.disabled =true;
		}
	}
}

function validateDate(from){
	if(from.value!=""){
		if(!validDateObj(from,"DMY",localeName)){
			from.value="";
			return ;
		}
	}
}

function DateCompare4(from,to){
	var obj1=convertDate(to.value,"DMY",localeName,"en");
	if(from.value!="" && to.value!="" ){
		if(isBefore(from.value,obj1,'DMY',localeName)==false){
			return false;
		}else{
			return true;
		}
	}
}

async function show_noshow_appts()
{

var callurl="";
var retVal = 	new String();
var dialogHeight= "90vh" ;
	var dialogTop = "125" ;
	var dialogWidth	= "75vw" ;
var status = "no";
var scroll = "no";
var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
var patient_id=parent.frames[0].document.forms[0].patient_id.value;
callurl="../../eOA/jsp/Noshowappointment.jsp?patient_id="+patient_id;
//alert(callurl)		;
var retVal = new String();
var retVal1 = new String();
retVal = await window.showModalDialog(callurl,arguments,features);


}

function dftCountryGroup(){
	if(document.forms[0].alcn_criteria.value!=""){
		var xmlDoc=  "" ;
		var xmlHttp= new XMLHttpRequest() ;
		var Flag=true;
		xmlStr	="<root><SEARCH " ;
		xmlStr += "countryCode=\""+document.forms[0].nationality_code1.value+"\" clinic_code=\""+document.forms[0].clinic_id.value+"\" clinic_date=\""+document.forms[0].apptdate.value+"\" practitioner_id=\""+document.forms[0].pract_id.value+"\" steps='stat_grp_dft'";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
	}
}

function formatTimePerPatient(obj)
{
	if (obj.value.length == 2)
	{
		if (obj.value.substring(1,2) == ':')
		{
			obj.value = '0' + obj.value ;
		}
	}
	if (obj.value.length == 3)
	{
		if (obj.value.substring(0,1) == ':')
		{
			obj.value = '00' + obj.value ;
		}
	}

}

async function PatInsModalWindow(){//For patient Instructions modal window.
	var or_catalogue_code=document.forms[0].or_catalogue_code.value;//when we select from schedule appointment
	var pending_order_catalog_code=document.forms[0].order_catalog_code.value// From pending order schedule
	var order_id=document.forms[0].order_id.value// From pending order schedule
	var order_line_num=document.forms[0].order_line_num.value// From pending order schedule
	var order_catalog_criteria=document.forms[0].order_catalog_criteria.value;	//when we select from schedule appointment
	var clinicInsYN=document.forms[0].clinicInsYN.value;
	var orderInsYN=document.forms[0].orderInsYN.value;
	var orderInsStandardYN=document.forms[0].orderInsStandardYN.value;
	var patient_id=parent.frames[0].document.forms[0].patient_id.value;
	var years=parent.frames[0].document.Bkappt_form.b_age.value;
	var months=parent.frames[0].document.Bkappt_form.b_months.value;
	var days=parent.frames[0].document.Bkappt_form.b_days.value;
	//var features    = "dialogHeight:35; dialogWidth:40; scroll=no; status:no;help=no;";
	var features    = "dialogHeight:85vh; dialogWidth:50vw; scroll=no; status:no;";
	var arguments = '';	
	var date_of_birth=parent.frames[0].document.getElementById("date_of_birth").value;
	var gender=parent.frames[0].document.getElementById("sex").value;
	var clinic_code=document.forms[0].clinic_code.value;
	var windowFlag=true;
	var from_page;
	if(document.forms[0].from_page.value==""){
		from_page="book_appt";
		// Modified against PMG20089-CRF-0885.3 - Removed the PatientID Validations on booking Radiology Appointment :
		var rd_appt_yn = parent.f_query_add_mod.document.Bkappt_form.rd_appt_yn.value;
		var patientid = parent.frames[0].document.forms[0].patient_id.value;
		if( (("Y" == rd_appt_yn) && (patientid != "")) || (rd_appt_yn == "N") )
		{
			if(orderInsYN=="Y" && patient_id==""){
				alert(getMessage("PRC_INS_WITHOUT_PATIENTID","OA"));
				windowFlag=false;
			}
		}
	}else{
		from_page=document.forms[0].from_page.value;
	}
	
	var appt_refno=document.forms[0].apptrefno.value;
	if(windowFlag){
		var url="../../eOA/jsp/OAPatientInstructionsMain.jsp?from_page="+from_page+"&clinic_code="+clinic_code+"&or_catalogue_code="+or_catalogue_code+"&clinicInsYN="+clinicInsYN+"&orderInsYN="+orderInsYN+"&pending_order_catalog_code="+pending_order_catalog_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&orderInsStandardYN="+orderInsStandardYN+"&patient_id="+patient_id+"&date_of_birth="+date_of_birth+"&gender="+gender+"&appt_refno="+appt_refno+"&rd_appt_yn="+rd_appt_yn; //PMG20089-CRF-0885.3
		var retVal = await top.window.showModalDialog(url,arguments,features);
		document.forms[0].patInsSelectYN.value="Y";
		document.forms[0].procInsSelectYN.value="Y";
	}
}
function patientLanguage(target){
	if(target.value!=""){
		patientLanguageLookup(target);
	}else{
		document.forms[0].language_desc.value='';
		document.forms[0].language_id.value='';	
	}
}
async function patientLanguageLookup(target){
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;	
	var tit=getLabel("Common.Language.label","Common");

	sql="Select MP_LANGUAGE_ID code,LONG_DESC description from MP_LANGUAGE_LANG_VW where  eff_status='E' and  upper(LONG_DESC) like upper(?) and upper(LANGUAGE_ID) like upper(?) and language_id='"+localeName+"' order by 2";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.forms[0].language_desc.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].language_desc.value=arr[1];
		 document.forms[0].language_id.value=arr[0];
	}else{
		document.forms[0].language_desc.value='';
		document.forms[0].language_id.value='';
	}
}
function getValues(obj,target,targetId){
	var facilityid =document.forms[0].facilityid.value;
	target.value=trimString(target.value);
	if(target.value=="" && window.event.target == target){
		targetId.value="";
		return;
	}
	getPractitioner(obj,target,facilityid,'','','','','Q2');	
}
function PractLookupRetVal(retVal,objName){
	var arr;
	if(retVal != null && trimString(retVal) != ""){
		arr=retVal.split("~");
		document.forms[0].ordPractId.value=arr[0];
		document.forms[0].ordPractDesc.value=arr[1];			
	}else{
		document.forms[0].ordPractId.value="";	
		document.forms[0].ordPractDesc.value="";			
  	}
}
//Bru-HIMS-CRF 169 changes
function checkMaxPatCnclReason(){
	var ptcnclcnt=0;
	if (document.forms[0].patCnclCount){
		if(parent.frames[0].document.Bkappt_form.patient_id){
			if(parent.frames[0].document.Bkappt_form.patient_id.value!=""){
				var xmlDoc=  "" ;
				var xmlHttp= new XMLHttpRequest() ;
				var Flag=true;
				xmlStr	="<root><SEARCH " ;
				xmlStr += "pat_id=\""+document.forms[0].patient_id.value+"\" steps='CHK_PAT_CNCL'";
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				eval(responseText);
				
				if(ptcnclcnt!="0"){
					var confirm_message=getMessage("MAX_CANCEL_COUNT_EXCEEDED","OA");
					confirm_message=confirm_message.replace("#",ptcnclcnt);
					if (confirm(confirm_message)){
						parent.frames[0].document.forms[0].patCnclCount.value='0';
					}
				}
			}
		}
	}	
}

function ConfrimGrpAppt(){
	var IsSubmit	= true;
	var errorMsg	= "";
	var FrameName	= parent.frames[0].document.forms[0];
	var sstyle		= FrameName.style.value;
	var CommonError	= getMessage("CAN_NOT_BE_BLANK","Common");
	
	if(FrameName.visit_type_short_desc.value==""){
		 errorMsg	+=  CommonError.replace("$",getLabel("Common.visittype.label","Common"))+ '<br>'; ;
		 IsSubmit	= false;
	}	
	if(FrameName.group_name.value==""){
		 errorMsg	+=  CommonError.replace("$",getLabel("Common.GroupName.label","Common"))+ '<br>'; ;
		 IsSubmit	= false;
	}
	
	if(FrameName.reason.value==""){
		 errorMsg	+=  CommonError.replace("$",getLabel("Common.ReasonForContact.label","Common"))+ '<br>'; ;
		 IsSubmit	= false;
	}
	/* Added By Dharma againt 191 CRF on 18-09-2013 Start*/
	var visit_limit_rule		= FrameName.visit_limit_rule.value;
	var max_other_visits		= parseInt(FrameName.max_other_visits.value);
	var total_other_visits		= parseInt(FrameName.total_other_visits.value);
	var max_first_visits		= parseInt(FrameName.max_first_visits.value);
	var total_first_visit		= parseInt(FrameName.total_first_visit.value);
	var Existing_Group_Members	= parseInt(FrameName.Existing_Group_Members.value);
	var visit_type_short_desc	= FrameName.visit_type_short_desc.value;
	var visit_type_ind			= "";
	if(errorMsg==""){
		var visit_type_arr			= visit_type_short_desc.split("~");
		visit_type_ind				= visit_type_arr[1];
		if(visit_limit_rule!='N' && (max_first_visits!=0 || max_other_visits!=0)){
			var chkfirstvisit	= max_first_visits	- total_first_visit;
			if(visit_limit_rule=='E' && max_first_visits!=0){
				var chkothervisits	= max_first_visits	- total_other_visits;
			}else if(visit_limit_rule=='M'){
				var chkothervisits	= max_other_visits	- total_other_visits;
			}
			if(visit_limit_rule=='E' || visit_limit_rule=='M'){
				if((chkfirstvisit < Existing_Group_Members) && visit_type_ind == "F" ){
					errorMsg	= getMessage("GROUP_FIRST_VISIT_EXCEED","OA")+ '<br>';
					IsSubmit	= false;
				}else if((chkothervisits < Existing_Group_Members) && visit_type_ind == "L"){
					errorMsg	= getMessage("GROUP_OTHER_VISIT_EXCEED","OA")+ '<br>';
					IsSubmit	= false;
				}
			}
		}
	}
	/* Added By Dharma againt 191 CRF on 18-09-2013 End*/
	
	if(errorMsg!="" && IsSubmit==false){
		var s = "<html><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sstyle+"'></link><head><META HTTP-EQUIV='Content-Type' CONTENT='text/html; charset=windows-1256'>" +
		"</head><body onKeyDown = 'lockKey()'><form name='f' id='f' method='post' action='../../eCommon/jsp/error.jsp'>"+
		"<input type='hidden' name='err_num' id='err_num' value=\""+errorMsg+"\">"
		"</form></body></html>" ;
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',s);
		parent.frames[2].document.f.submit();
	}else{
		FrameName.submit();
	}

		//parent.frames[0].document.groupApptForm.submit();
}
/*Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058 Start*/
function imposeMaxLength(obj)
{
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	{
		var error = getMessage("REMARKS_CANNOT_EXCEED","common");
		var remarks = getLabel("Common.remarks.label","common");
		error = error.replace("$",remarks);
		error = error.replace("#","1000")
		alert(error);
		obj.value=obj.value.substring(0,mlength);
	}
}/*End*/
//Added by Kamatchi S for NMC-JD-CRF-0104
function slotTime()
{
var or_appt_time = parent.frames[0].document.Bkappt_form.or_appt_time.value;
if(or_appt_time!="")
	{
var slot = parent.frames[0].document.Bkappt_form.no_slots.value;
parent.frames[0].document.Bkappt_form.no_slots.onchange();
	}
}

function dynFrameSize() {
				parent.document.getElementById("f_query_add_mod").style.height='100vh'
				parent.document.getElementById("SecondaryFrame").style.height='0vh'
				parent.document.getElementById("ButtonFrame").style.height='5vh'
				parent.document.getElementById("messageFrame").style.height='0vh'
}