function moveForward_date(){  
	var u1=parent.frames[0].document.forms[0].gggg.value;
	var u2=parent.frames[0].document.forms[0].changed_date.value;
	var valid_date=parent.frames[0].document.forms[0].valid_date.value;
	u2=valid_date;
	if(document.forms[0].hddTracker.value =='OP' || document.forms[0].hddTracker.value =='OR' || document.forms[0].hddTracker.value =='CA'){
		setTimeout('aaa1()',1000);
	}else{
		setTimeout('aaa()',1000);
	}
}

function moveBack(){
var u1=parent.frames[0].document.forms[0].gggg.value;
var u2=parent.frames[0].document.forms[0].changed_date.value;
setTimeout('aaa()',1000);
}



function aaa(){
	var or_catalogue_code=parent.frames[0].document.forms[0].or_catalogue_code.value;
	var mode_find=parent.frames[0].document.forms[0].mode_find.value;
	var pre_pat_alcn_catg_code=parent.frames[0].document.forms[0].pre_pat_alcn_catg_code.value;
	var clinic1=parent.frames[0].document.forms[0].clinic1.value;
	var practitioner1=parent.frames[0].document.forms[0].practitioner1.value;
	var clinic2=parent.frames[0].document.forms[0].clinic2.value;
	var practitioner2=parent.frames[0].document.forms[0].practitioner2.value;
	var clinic3=parent.frames[0].document.forms[0].clinic3.value;
	var practitioner3=parent.frames[0].document.forms[0].practitioner3.value;
	var value12=parent.frames[0].document.forms[0].reason_for_revise.value;
	var value13=parent.frames[0].document.forms[0].ref_no.value;
	var Date=parent.frames[0].document.forms[0].valid_date.value;
	var valid_date=parent.frames[0].document.forms[0].valid_date.value; 
	var date1=parent.frames[0].document.forms[0].valid_date1.value; 
	var date2=parent.frames[0].document.forms[0].valid_date2.value; 
	var res_type1=document.forms[0].res_type1.value;
	var clinic_type1=document.forms[0].clinic_type1.value;
	var res_type2=document.forms[0].res_type2.value;
	var clinic_type2=document.forms[0].clinic_type2.value;
	var res_type3=document.forms[0].res_type3.value;
	var clinic_type3=document.forms[0].clinic_type3.value;
	var oper_stn_id=document.forms[0].oper_stn_id.value;
	var alcn_criteria=document.forms[0].alcn_criteria.value;
	var visit_limit_rule=document.forms[0].visit_limit_rule.value;
	var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
	var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
	var install_yn_val=document.forms[0].install_yn_val.value;
	if(parent.frames[1].frames[0].document.forms[0].create_wait_list_yn){
	var create_wait_list_yn= parent.frames[1].frames[0].document.forms[0].create_wait_list_yn.value;
	}
	if(parent.frames[1].frames[0].document.forms[0].visit_flag_OP)
	var visit_flag_OP= parent.frames[1].frames[0].document.forms[0].visit_flag_OP.value;
	var capture_fin_dtls_yn=parent.frames[0].document.forms[0].capture_fin_dtls_yn.value;
	var Date_greg=convertDate(Date,"DMY",localeName,"en");
	var valid_date_greg=convertDate(valid_date,"DMY",localeName,"en");
	var date1_greg=convertDate(date1,"DMY",localeName,"en");
	var date2_greg=convertDate(date2,"DMY",localeName,"en");
	var from_facility_id= document.forms[0].from_facility_id.value;
	var from_encounter_id= document.forms[0].from_encounter_id.value;
	var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;
	var speciality= document.forms[0].speciality.value;
	var clinic_old=parent.frames[0].document.forms[0].clinic_old.value;
	var practitioner_old=parent.frames[0].document.forms[0].practitioner_old.value;
	var practitioner_type=parent.frames[0].document.forms[0].practitioner_type.value;
	var pref_start_date=parent.frames[0].document.forms[0].pref_start_date.value;
	var pref_end_date=parent.frames[0].document.forms[0].pref_end_date.value;
	var care_locn_ind=parent.frames[0].document.forms[0].care_locn_ind.value;
	var visittype=parent.frames[0].document.forms[0].visittype.value;
	var no_dwm=parent.frames[0].document.forms[0].no_dwm.value;
	var dwm_desc=parent.frames[0].document.forms[0].dwm_desc.value;
	var ca_patient_id =document.forms[0].ca_patient_id.value;
	var min_ela_per_resc_noshow_in_day	=document.forms[0].min_ela_per_resc_noshow_in_day.value;
	var noshow_ctrl_by_splty_or_clinic	=document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
	var no_of_noshow_appts_for_alert	=document.forms[0].no_of_noshow_appts_for_alert.value;
	var per_chk_for_no_show_alert		=document.forms[0].per_chk_for_no_show_alert.value;
	var rd_appt_yn		=document.forms[0].rd_appt_yn.value;
	
	var position=document.forms[0].position.value;
	var addtl_splty=document.forms[0].addtl_splty.value;
	var rule_appl_yn			= "";
	var patient_id_temp			= "";
	var name_prefix_temp		= "";
	var first_name_temp			= "";
	var second_name_temp		= "";
	var third_name_temp			= "";
	var family_name_temp		= "";
	var gender_temp				= "";
	var contact_no_temp			= "";
	var nationality_code_temp	= "";
	var language_code_temp		= "";
	var term_set_id				= "";
	var linking_code			= "";	
	
	if(parent.parent.tempStorageFrame && parent.parent.tempStorageFrame.tempStorageForm){
		rule_appl_yn			= parent.parent.tempStorageFrame.tempStorageForm.rule_appl_yn.value;
		patient_id_temp			= parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value;
		name_prefix_temp		= parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value;
		first_name_temp			= parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value;
		second_name_temp		= parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value;
		third_name_temp			= parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value;
		family_name_temp		= parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value;
		gender_temp				= parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value;
		contact_no_temp			= parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value;
		nationality_code_temp	= parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value;
		language_code_temp		= parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value;
		term_set_id				= parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value;
		linking_code			= parent.parent.tempStorageFrame.tempStorageForm.linking_code.value;
	}		
	parent.parent.frames[1].location.href="../../eOA/jsp/MultiPract3Vw.jsp?clinic_code1="+clinic1+"&practitioner_id1="+practitioner1+"&mode_find="+mode_find+"&pre_pat_alcn_catg_code="+pre_pat_alcn_catg_code+"&clinic_code2="+clinic2+"&practitioner_id2="+practitioner2+"&clinic_code3="+clinic3+"&practitioner_id3="+practitioner3+"&Date="+Date_greg+"&Date1="+date1_greg+"&Date2="+date2_greg+"&valid_date="+valid_date_greg+"&value12="+value12+"&value13="+value13+"&clinic_type1="+clinic_type1+"&res_type2="+res_type2+"&clinic_type2="+clinic_type2+"&clinic_type3="+clinic_type3+"&res_type1="+res_type1+"&res_type3="+res_type3+"&oper_stn_id="+oper_stn_id+"&alcn_criteria="+alcn_criteria+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&speciality="+speciality+"&clinic_old="+clinic_old+"&practitioner_old="+practitioner_old+"&practitioner_type="+practitioner_type+"&pref_start_date="+pref_start_date+"&pref_end_date="+pref_end_date+"&care_locn_ind="+care_locn_ind+"&visittype="+visittype+"&no_dwm="+no_dwm+"&dwm_desc="+dwm_desc+"&or_catalogue_code="+or_catalogue_code+"&ca_patient_id="+ca_patient_id+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&position="+position+"&addtl_splty="+addtl_splty+"&rule_appl_yn="+rule_appl_yn+"&patient_id_temp="+patient_id_temp+"&name_prefix_temp="+escape(name_prefix_temp)+"&first_name_temp="+first_name_temp+"&second_name_temp="+second_name_temp+"&third_name_temp="+third_name_temp+"&family_name_temp="+family_name_temp+"&gender_temp="+gender_temp+"&contact_no_temp="+contact_no_temp+"&nationality_code_temp="+nationality_code_temp+"&language_code_temp="+language_code_temp+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn;//file name modified for the incident 41037
}

var patient_id;
function aaa1(){
	var mode_find=document.forms[0].mode_find.value;
	var pre_pat_alcn_catg_code=document.forms[0].pre_pat_alcn_catg_code.value;
	var clinic1=document.forms[0].clinic1.value;
	var practitioner1=document.forms[0].practitioner1.value;
	var clinic2=document.forms[0].clinic2.value;
	var practitioner2=document.forms[0].practitioner2.value;
	var clinic3=document.forms[0].clinic3.value;
	var practitioner3=document.forms[0].practitioner3.value;
	var value12=document.forms[0].reason_for_revise.value;
	var value13=document.forms[0].ref_no.value;
	var callingMode=document.forms[0].hddTracker.value;
	patient_id=document.forms[0].ca_patient_id.value;
	var Date=document.forms[0].valid_date.value;
	var valid_date=document.forms[0].valid_date.value; 
	var date1=document.forms[0].valid_date1.value; 
	var date2=document.forms[0].valid_date2.value;
	var res_type1=document.forms[0].res_type1.value;
	var clinic_type1=document.forms[0].clinic_type1.value;
	var res_type2=document.forms[0].res_type2.value;
	var clinic_type2=document.forms[0].clinic_type2.value;
	var res_type3=document.forms[0].res_type3.value;
	var clinic_type3=document.forms[0].clinic_type3.value;
	var oper_stn_id=document.forms[0].oper_stn_id.value;
	var alcn_criteria=document.forms[0].alcn_criteria.value;
	var visit_limit_rule=document.forms[0].visit_limit_rule.value;
	var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
	var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
	var install_yn_val=document.forms[0].install_yn_val.value;
	var create_wait_list_yn='';
	if(parent.frames[1].frames[0].document.forms[0].create_wait_list_yn){
		create_wait_list_yn=parent.frames[1].frames[0].document.forms[0].create_wait_list_yn.value;
	}else if (parent.frames[1].frames[1].document.forms[0].create_wait_list_yn){
		create_wait_list_yn=parent.frames[1].frames[1].document.forms[0].create_wait_list_yn.value;
	}else{
		create_wait_list_yn=parent.frames[1].frames[2].document.forms[0].create_wait_list_yn.value;
	}
	var visit_flag_OP=''
	if(parent.frames[1].frames[0].document.forms[0].visit_flag_OP){
		visit_flag_OP= parent.frames[1].frames[0].document.forms[0].visit_flag_OP.value;
	}else if (parent.frames[1].frames[1].document.forms[0].visit_flag_OP){
		visit_flag_OP=parent.frames[1].frames[1].document.forms[0].visit_flag_OP.value;
	}else{
		visit_flag_OP=parent.frames[1].frames[2].document.forms[0].visit_flag_OP.value;
	}
	var capture_fin_dtls_yn=document.forms[0].capture_fin_dtls_yn.value;
	var from_facility_id= document.forms[0].from_facility_id.value;
	var from_encounter_id= document.forms[0].from_encounter_id.value;
	var Date_greg=convertDate(Date,"DMY",localeName,"en");
	var valid_date_greg=convertDate(valid_date,"DMY",localeName,"en");
	var date1_greg=convertDate(date1,"DMY",localeName,"en");
	var date2_greg=convertDate(date2,"DMY",localeName,"en");
	var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;
	var order_id=parent.frames[1].frames[2].document.forms[0].order_id.value;
	var order_line_num=parent.frames[1].frames[2].document.forms[0].order_line_num.value;
	var order_catalog_code=parent.frames[1].frames[2].document.forms[0].order_catalog_code.value;
	var min_ela_per_resc_noshow_in_day	 =document.forms[0].min_ela_per_resc_noshow_in_day.value;
	var noshow_ctrl_by_splty_or_clinic	 =document.forms[0].noshow_ctrl_by_splty_or_clinic.value;	
	var no_of_noshow_appts_for_alert	=document.forms[0].no_of_noshow_appts_for_alert.value;	
	var per_chk_for_no_show_alert		=document.forms[0].per_chk_for_no_show_alert.value;
	var rd_appt_yn		=document.forms[0].rd_appt_yn.value;
	
	var position=document.forms[0].position.value;
	var addtl_splty=document.forms[0].addtl_splty.value;
	var rule_appl_yn			= "";
	var patient_id_temp			= "";
	var name_prefix_temp		= "";
	var first_name_temp			= "";
	var second_name_temp		= "";
	var third_name_temp			= "";
	var family_name_temp		= "";
	var gender_temp				= "";
	var contact_no_temp			= "";
	var nationality_code_temp	= "";
	var language_code_temp		= "";
	var term_set_id				= "";
	var linking_code			= "";	
	
	if(parent.parent.tempStorageFrame && parent.parent.tempStorageFrame.tempStorageForm){
		rule_appl_yn			= parent.parent.tempStorageFrame.tempStorageForm.rule_appl_yn.value;
		patient_id_temp			= parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value;
		name_prefix_temp		= parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value;
		first_name_temp			= parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value;
		second_name_temp		= parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value;
		third_name_temp			= parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value;
		family_name_temp		= parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value;
		gender_temp				= parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value;
		contact_no_temp			= parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value;
		nationality_code_temp	= parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value;
		language_code_temp		= parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value;
		term_set_id				= parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value;
		linking_code			= parent.parent.tempStorageFrame.tempStorageForm.linking_code.value;
	}	
	parent.parent.frames[1].location.href="../../eOA/jsp/MultiPract3Vw.jsp?clinic_code1="+clinic1+"&practitioner_id1="+practitioner1+"&mode_find="+mode_find+"&pre_pat_alcn_catg_code="+pre_pat_alcn_catg_code+"&clinic_code2="+clinic2+"&practitioner_id2="+practitioner2+"&clinic_code3="+clinic3+"&practitioner_id3="+practitioner3+"&Date="+Date_greg+"&Date1="+date1_greg+"&Date2="+date2_greg+"&valid_date="+valid_date_greg+"&value12="+value12+"&value13="+value13+"&callingMode="+callingMode+"&ca_patient_id="+patient_id+"&clinic_type1="+clinic_type1+"&res_type2="+res_type2+"&clinic_type2="+clinic_type2+"&clinic_type3="+clinic_type3+"&res_type1="+res_type1+"&res_type3="+res_type3+"&oper_stn_id="+oper_stn_id+"&alcn_criteria="+alcn_criteria+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&position="+position+"&addtl_splty="+addtl_splty+"&patient_id_temp="+patient_id_temp+"&name_prefix_temp="+escape(name_prefix_temp)+"&first_name_temp="+first_name_temp+"&second_name_temp="+second_name_temp+"&third_name_temp="+third_name_temp+"&family_name_temp="+family_name_temp+"&gender_temp="+gender_temp+"&contact_no_temp="+contact_no_temp+"&language_code_temp="+language_code_temp+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn;
	parent.parent.frames[2].location.href="../../eOA/jsp/BrownCheckBoxDisplay.jsp";
}

function PopDay(obj){
	   strDate = obj.value;
	/*   strDateArray = strDate.split("/");
	   strDay		= strDateArray[0];
	   strMonth		= strDateArray[1];
	   strYear		= strDateArray[2]; 
	   Vdate		= new Date(strMonth+'/'+ strDay +'/'+ strYear)   */

		var greg_obj1 = convertDate(strDate,"DMY",localeName,"en");
		var dayOfWeek = getDayOfWeek(greg_obj1,"DMY", 'en');
		var Vdate= parseInt(dayOfWeek);

	   if(Vdate != "NaN")
	   {	   
	   	switch(Vdate)
	   	{
			
			case 1:
			  Vdate=getLabel("Common.mon.label","Common");
			  break;	  
			case 2:
			  Vdate=getLabel("Common.tue.label","Common");
			  break;
			case 3:
			  Vdate=getLabel("Common.wed.label","Common");
			  break;
			case 4:
			  Vdate=getLabel("Common.thu.label","Common");
			  break;
			case 5:
			  Vdate=getLabel("Common.fri.label","Common");
			  break;
			case 6:
			  Vdate=getLabel("Common.sat.label","Common");
			  break;  
			case 7:
			  Vdate=getLabel("Common.sun.label","Common");
			  break;
	   	}
	   }
	if (obj.name=="valid_date"){
		if(Vdate != "NaN")
		   document.getElementById('day1').innerHTML="<b>"+Vdate+"</b>";
		else
			document.getElementById('day1').innerHTML="<b>&nbsp;</b>";
	}else if(obj.name=="valid_date1"){
		if(Vdate != "NaN")
		   document.getElementById('day2').innerHTML="<b>"+Vdate+"</b>";
		else
			document.getElementById('day2').innerHTML="<b>&nbsp;</b>";
	}else if(obj.name=="valid_date2"){
		if(Vdate != "NaN")
		   document.getElementById('day3').innerHTML="<b>"+Vdate+"</b>";
		else
			document.getElementById('day3').innerHTML="<b>&nbsp;</b>";
	}

}

function hide()
{
	if (document.forms[0].mode_find)
	{
		if(document.forms[0].mode_find.value=='revise')				
			document.getElementById('ss').style.visibility="visible";
		else
			document.getElementById('ss').style.visibility="hidden";			
	}
}


function check_val(event)
{
	if(event.keyCode==13)
	return false;
}


function fc()
{
	document.forms[0].focus();
}

function blankdatechk(){
	if(document.forms[0].valid_date.value=="" || document.forms[0].valid_date1.value=="" || document.forms[0].valid_date2.value==""){
		var error=getMessage("TO_DT_NOT_BLANK","SM");
		var error1=error.substring	(0,11);
		var error2= error.substring(13 ,60);
		alert(error1 + getLabel("Common.Schedule.label","Common") +error2);
		document.forms[0].valid_date.focus();
	}else{
		moveForward_date();
	}
}
/*Script functions for Mp3DisplayLabels.jsp*/

function moveNext_labels0()
	{
	
		var value1=document.forms[0].clinic_code.value;
		var value2=document.forms[0].clinic_name.value;
		var value3=document.forms[0].pract_id.value;
		var value4=document.forms[0].pract_name.value;
		var value5=document.forms[0].appt_date.value;
		//var value6= document.forms[0].from_time.value;
		//var value7=document.forms[0].to_time.value;
		var value8=document.forms[0].over_booked_label.value;
		var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
		var value10=document.forms[0].patient_id.value;
		var value12=document.forms[0].reason_for_revise.value;
		var value13=document.forms[0].ref_no.value;
		var value6="";
		var value7="";
		if(value9 == '3' && value8 =='Y')
		{
			value6= document.forms[0].p_o_end_time.value;
			value7=document.forms[0].p_o_end_time.value;
		}

		var clinic_code2=document.forms[0].clinic_code2.value;
		var clinic_code3=document.forms[0].clinic_code3.value;
		var practitioner_id2=document.forms[0].pract_id2.value;
		var practitioner_id3=document.forms[0].pract_id3.value;	
		if(value13 != "hjjh"){
		var obook_appt_yn = book_appt_yn=document.forms[0].obook_appt_yn.value;
		if (obook_appt_yn=="N")
			{
		   alert(getMessage('OVER_BOOK_NOT_ALLOWED','OA'));       
			}else
			{
			callBookAppointment_labels0();
			}
		}
		else if( value13== "hjjh"){
		callBookAppointmentDetails_labels0();
		}
}

function callBookAppointment_labels0()
{				
				var value1=document.forms[0].clinic_code.value;
				var value2=document.forms[0].clinic_name.value;
				var value3="";
				var value4=document.forms[0].pract_name.value;
				var value5=document.forms[0].appt_date.value;
				var value6= document.forms[0].p_o_end_time.value;
				var value7=document.forms[0].p_o_end_time.value;
				var value8=document.forms[0].over_booked_label.value;
				var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
				var value10=document.forms[0].patient_id.value;
				var value12=document.forms[0].reason_for_revise.value;
				var value13=document.forms[0].ref_no.value;
				var clinic_code2=document.forms[0].clinic_code2.value;
				var clinic_code3=document.forms[0].clinic_code3.value;
				var practitioner_id1=document.forms[0].pract_id.value;
				var practitioner_id2=document.forms[0].pract_id2.value;
				var practitioner_id3=document.forms[0].pract_id3.value;	
				var book_appt_yn=document.forms[0].book_appt_yn.value;
				var book_appt_wo_pid_yn=document.forms[0].book_appt_wo_pid_yn.value;
				var obook_appt_yn=document.forms[0].obook_appt_yn.value;
				var book_appt_across_catg_yn=document.forms[0].book_appt_across_catg_yn.value;
				var tfr_appt_yn=document.forms[0].tfr_appt_yn.value;
				var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
				var canc_appt_yn=document.forms[0].canc_appt_yn.value;
				var alcn_criteria=document.forms[0].alcn_criteria.value;
				var ca_patient_id=parent.frames[1].document.forms[0].ca_patient_id.value;
			var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value;
				var retVal = 	new String();
				var dialogHeight= "42.5" ;
				var dialogTop = "83" ;
				var dialogWidth	= "65" ;
				var status = "no";				
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
				var obvisit_flag=document.forms[0].P_O_OBVISIT_FLAG.value;
				var res_type=document.forms[0].res_type1.value;
				var clinic_type=document.forms[0].clinic_type1.value;
				var or_catalogue_code=document.forms[0].or_catalogue_code.value;
				var oper_stn_id	=document.forms[0].oper_stn_id.value;
				var visit_limit_rule=document.forms[0].visit_limit_rule.value;
				var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;	
				var req_id= document.forms[0].req_id.value;
					var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
					var visit_flag_OP= document.forms[0].visit_flag_OP.value;
				var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
				var noshow_ctrl_by_splty_or_clinic= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
				var min_ela_per_resc_noshow_in_day = document.forms[0].min_ela_per_resc_noshow_in_day.value;
				var from_page= document.forms[0].from_page.value;
				var from_facility_id= document.forms[0].from_facility_id.value;
				var from_encounter_id= document.forms[0].from_encounter_id.value;
var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value; 
				if(document.forms[0].value_chk.value=="display1")
				{
					value3=practitioner_id1;
				}else if(document.forms[0].value_chk.value=="display2")
				{
					value3=practitioner_id2;
				}else
				{
					value3=practitioner_id3;
				}
var no_of_noshow_appts_for_alert	= document.forms[0].no_of_noshow_appts_for_alert.value;
var per_chk_for_no_show_alert		= document.forms[0].per_chk_for_no_show_alert.value;
var rd_appt_yn		= document.forms[0].rd_appt_yn.value;

var rule_appl_yn			= "";
var patient_id_temp			= "";
var name_prefix_temp		= "";
var first_name_temp			= "";
var second_name_temp		= "";
var third_name_temp			= "";
var family_name_temp		= "";
var name_suffix_temp         		= "";
var name_prefix_oth_lang_temp       = "";
var first_name_oth_lang_temp       	= "";
var second_name_oth_lang_temp       = "";
var third_name_oth_lang_temp        = "";
var family_name_oth_lang_temp       = "";
var name_suffix_oth_lang_temp       = "";
var gender_temp				= "";
var contact_no_temp			= "";
var nationality_code_temp	= "";
var language_code_temp		= "";
var term_set_id				= "";
var linking_code			= "";	

if(parent.parent.parent.tempStorageFrame && parent.parent.parent.tempStorageFrame.tempStorageForm){
	rule_appl_yn			= parent.parent.parent.tempStorageFrame.tempStorageForm.rule_appl_yn.value;
	patient_id_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value;
	name_prefix_temp 		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value;
	first_name_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value;
	second_name_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value;
	third_name_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value;
	family_name_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value;
	name_suffix_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_temp.value;
	name_prefix_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_oth_lang_temp.value;
	first_name_oth_lang_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_oth_lang_temp.value;
	second_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_oth_lang_temp.value;
	third_name_oth_lang_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_oth_lang_temp.value;
	family_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_oth_lang_temp.value;
	name_suffix_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_oth_lang_temp.value;
	
	
	
	gender_temp				= parent.parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value;
	contact_no_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value;
	nationality_code_temp	= parent.parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value;
	language_code_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value;
	term_set_id				= parent.parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value;
	linking_code			= parent.parent.parent.tempStorageFrame.tempStorageForm.linking_code.value;
}	
	
	
				var callurl="../../eOA/jsp/BookAppointment.jsp?i_clinic_code="+value1+"&i_clinic_name="+value2+"&i_practitioner_id="+value3+"&i_practitioner_name="+value4+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&i_over_booked="+value8+"&i_time_table_type="+value9+"&i_patient_id="+value10+"&book_appt_across_catg_yn="+book_appt_across_catg_yn+"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&obvisit_flag="+obvisit_flag+"&ca_patient_id="+ca_patient_id+"&res_type="+res_type+"&clinic_type="+clinic_type+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&"+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&create_wait_list_yn="+create_wait_list_yn+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_page1="+from_page+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&rule_appl_yn="+rule_appl_yn+"&patient_id_temp="+patient_id_temp+"&name_prefix_temp="+escape(name_prefix_temp)+"&first_name_temp="+escape(first_name_temp)+"&second_name_temp="+escape(second_name_temp)+"&third_name_temp="+escape(third_name_temp)+"&family_name_temp="+escape(family_name_temp)+"&name_suffix_temp="+escape(name_suffix_temp)+"&name_prefix_oth_lang_temp="+escape(name_prefix_oth_lang_temp)+"&first_name_oth_lang_temp="+escape(first_name_oth_lang_temp)+"&second_name_oth_lang_temp="+escape(second_name_oth_lang_temp)+"&third_name_oth_lang_temp="+escape(third_name_oth_lang_temp)+"&family_name_oth_lang_temp="+escape(family_name_oth_lang_temp)+"&name_suffix_oth_lang_temp="+escape(name_suffix_oth_lang_temp)+"&gender_temp="+gender_temp+"&contact_no_temp="+contact_no_temp+"&nationality_code_temp="+nationality_code_temp+"&language_code_temp="+language_code_temp+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn;
				retVal = parent.parent.document.frames[1].window.showModalDialog(callurl,arguments,features);
				if (retVal =="abort")
				{
				}else{
					setTimeout('aaa_labels0()',1000);
				}
}
	
function callBookAppointmentDetails_labels0()
{					
					var value1=document.forms[0].clinic_code.value;
					var value2=document.forms[0].clinic_name.value;
					var value3=document.forms[0].pract_id.value;
					var value4=document.forms[0].pract_name.value;
					var value5=document.forms[0].appt_date.value;
					var value6= document.forms[0].p_o_end_time.value;
					var value7=document.forms[0].p_o_end_time.value;
					var value8=document.forms[0].over_booked_label.value;
					var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
					var value10=document.forms[0].patient_id.value;
					var value12=document.forms[0].reason_for_revise.value;
					var value13=document.forms[0].ref_no.value;
					var clinic_code2=document.forms[0].clinic_code2.value;
					var clinic_code3=document.forms[0].clinic_code3.value;
					var practitioner_id2=document.forms[0].pract_id2.value;
					var practitioner_id3=document.forms[0].pract_id3.value;	
					var retVal = 	new String();
					var dialogHeight= "32" ;
					var dialogWidth	= "50" ;
					var dialogTop = "190" ;
					var center = "1" ;
					var status="no";
					var ca_patient_id=parent.frames[1].document.forms[0].ca_patient_id.value;
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var res_type=document.forms[0].res_type1.value;
					var clinic_type=document.forms[0].clinic_type1.value;
					var arguments	= "" ;
					retVal = parent.parent.document.frames[1].window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+value12+"&i_clinic_code="+value1+"&i_practitioner_id="+value3+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&over_booked="+value8+"&i_time_table_type="+value9+"&value13="+value13+"&ca_patient_id="+ca_patient_id+"&res_type="+res_type+"&clinic_type="+clinic_type ,arguments,features);
					if(retVal == "close")
					retVal="|";
					returnarray=retVal.split("|");
					var j1=returnarray[1];
					var j2=returnarray[0];					
					document.forms[0].value12.value=j2;
					document.forms[0].value13.value=j1;
					setTimeout('aaa_labels0()',1000);
	}
	
function aaa_labels0(mode_find)
{		
		var value1=document.forms[0].clinic_code.value;
		var value2=document.forms[0].clinic_name.value;
		var value3=document.forms[0].pract_id.value;
		var value4=document.forms[0].pract_name.value;
		var value5=document.forms[0].appt_date.value;
		var value6= document.forms[0].p_o_end_time.value;
		var value7=document.forms[0].p_o_end_time.value;
		var value8=document.forms[0].over_booked_label.value;
		var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
		var value10=document.forms[0].patient_id.value;
		//var value12=document.forms[0].value12.value;
		//var value13=document.forms[0].value13.value;	
		var clinic_code2=document.forms[0].clinic_code2.value;
		var clinic_code3=document.forms[0].clinic_code3.value;
		var practitioner_id2=document.forms[0].pract_id2.value;
		var practitioner_id3=document.forms[0].pract_id3.value;	
		var callingMode = document.forms[0].callingMode.value;
		var ca_patient_id=parent.frames[1].document.forms[0].ca_patient_id.value;
		var date1=parent.frames[1].document.forms[0].date1.value;
		var date2=parent.frames[1].document.forms[0].date2.value;

		var res_type1=document.forms[0].res_type1.value;
		var clinic_type1=document.forms[0].clinic_type1.value;
		var res_type2=document.forms[0].res_type2.value;
		var clinic_type2=document.forms[0].clinic_type2.value;
		var res_type3=document.forms[0].res_type3.value;
		var clinic_type3=document.forms[0].clinic_type3.value;
		var or_catalogue_code=document.forms[0].or_catalogue_code.value;
		var oper_stn_id = document.forms[0].oper_stn_id.value;
		var alcn_criteria =document.forms[0].alcn_criteria.value;
		var visit_limit_rule=document.forms[0].visit_limit_rule.value;
		var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
		var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
		var install_yn_val=document.forms[0].install_yn_val.value;
		var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
		var visit_flag_OP= document.forms[0].visit_flag_OP.value;
var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;
		var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value;
		var from_facility_id= document.forms[0].from_facility_id.value;
		var from_encounter_id = document.forms[0].from_encounter_id.value;
		var min_ela_per_resc_noshow_in_day	= document.forms[0].min_ela_per_resc_noshow_in_day.value;	
		var noshow_ctrl_by_splty_or_clinic	= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;			
		var no_of_noshow_appts_for_alert	= document.forms[0].no_of_noshow_appts_for_alert.value;	
		var per_chk_for_no_show_alert		= document.forms[0].per_chk_for_no_show_alert.value;
		var rd_appt_yn		= document.forms[0].rd_appt_yn.value;
		
		if(callingMode =="" || callingMode =="CA" )
		{
			
		var url="../../eOA/jsp/MultiPract3Vw.jsp?clinic_code1="+value1+"&practitioner_id1="+value3+"&Date="+value5+"&Date1="+date1+"&Date2="+date2+"&clinic_code2="+clinic_code2+"&practitioner_id2="+practitioner_id2+"&clinic_code3="+clinic_code3+"&practitioner_id3="+practitioner_id3+"&ca_patient_id="+ca_patient_id+"&mode_find="+mode_find+"&res_type1="+res_type1+"&clinic_type1="+clinic_type1+"&res_type2="+res_type2+"&clinic_type2="+clinic_type2+"&res_type3="+res_type3+"&clinic_type3="+clinic_type3+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&alcn_criteria="+alcn_criteria+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&callingMode="+callingMode+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&rd_appt_yn="+rd_appt_yn;
		parent.parent.parent.frames[1].location.href=url;

			
		}else if (parent.parent.parent.frames[0].document.forms[0].from_OR.value =="Y" && document.forms[0].ca_patient_id.value !="")
		{
		parent.parent.parent.frames[1].location.href='../../eOR/jsp/PendingOrdersSchedule.jsp';
		}
		else
			{
				parent.window.close();
			}
}

function show_allocation_details_labels0(alcn_criteria,clinic_code,practioner_id,appt_date,time_tab_type)
{
	var dialogHeight= "10" ;
	var dialogWidth	= "30" ;
	var dialogTop = "232" ;
	var center = "1" ;
	var status="no";
	var res_type=document.forms[0].res_type1.value;
	var clinic_type=document.forms[0].clinic_type1.value;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	window.showModalDialog("../../eOA/jsp/SchAllocationdetailsFrame.jsp?alcn_criteria="+alcn_criteria+"&clinic_code="+clinic_code+"&practioner_id="+practioner_id+"&time_tab_type="+time_tab_type+"&appt_date="+appt_date+"&res_type="+res_type+"&clinic_type="+clinic_type,arguments,features);

}

/*Script functions for Mp2DisplayLabels2.jsp*/

function moveNext_labels2()
{
			var value1=document.forms[0].clinic_code.value;
			var value2=document.forms[0].clinic_name.value;
			var value3=document.forms[0].pract_id.value;
			var value4=document.forms[0].pract_name.value;
			var value5=document.forms[0].appt_date.value;
			var value6= document.forms[0].from_time.value;
			var value7=document.forms[0].to_time.value;
			var value8=document.forms[0].over_booked.value;
			var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
			var value10=document.forms[0].patient_id.value;
			var value12=document.forms[0].value12.value;
			var value13=document.forms[0].value13.value;
			
			if(value9 == '3' && value8 =='Y')
			{
				value6= document.forms[0].p_o_end_time.value;
				value7=document.forms[0].p_o_end_time.value;
			}
			
				var clinic_code2=document.forms[0].clinic_code1.value;
				var clinic_code3=document.forms[0].clinic_code3.value;
				var practitioner_id2=document.forms[0].pract_id2.value;
				var practitioner_id3=document.forms[0].pract_id3.value;
				
		if(value13 != "hjjh")
		{
			var obook_appt_yn = book_appt_yn=document.forms[0].obook_appt_yn.value;
			if (obook_appt_yn=="N")
			   alert(getMessage('OVER_BOOK_NOT_ALLOWED','OA'));       
			else
				callBookAppointment_labels2();
		}
		else if( value13== "hjjh")
		{
			callBookAppointmentDetails_labels2();
		}
}

function callBookAppointment_labels2()
{				
				var	value1=document.forms[0].clinic_code.value;
				var	value2=document.forms[0].clinic_name.value;
				var	value3=document.forms[0].pract_id.value;
				var	value4=document.forms[0].pract_name.value;
				var	value5=document.forms[0].appt_date.value;
				var	value6= document.forms[0].from_time.value;
				var	value7=document.forms[0].to_time.value;
				var	value8=document.forms[0].over_booked.value;
				var	value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
				var	value10=document.forms[0].patient_id.value;
				var	value12=document.forms[0].value12.value;
				var	value13=document.forms[0].value13.value;
				var clinic_code2=document.forms[0].clinic_code1.value;
				var clinic_code3=document.forms[0].clinic_code3.value;
				var practitioner_id2=document.forms[0].pract_id2.value;
				var practitioner_id3=document.forms[0].pract_id3.value;
				var book_appt_yn=document.forms[0].book_appt_yn.value;
				var book_appt_wo_pid_yn=document.forms[0].book_appt_wo_pid_yn.value;
				var obook_appt_yn=document.forms[0].obook_appt_yn.value;
				var book_appt_across_catg_yn=document.forms[0].book_appt_across_catg_yn.value;
				var tfr_appt_yn=document.forms[0].tfr_appt_yn.value;
				var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
				var canc_appt_yn=document.forms[0].canc_appt_yn.value;
				var alcn_criteria=document.forms[0].alcn_criteria.value;
				var ca_patient_id=parent.frames[3].document.forms[0].ca_patient_id.value;
				var retVal = 	new String();
				var dialogHeight= "42.5" ;
				var dialogTop = "83" ;
				var dialogWidth	= "65" ;
				var status = "no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
				var obvisit_flag=document.forms[0].P_O_OBVISIT_FLAG.value;
				var res_type=document.forms[0].res_type2.value;
				var clinic_type=document.forms[0].clinic_type2.value;
				var or_catalogue_code=document.forms[0].or_catalogue_code.value;
				var oper_stn_id	=document.forms[0].oper_stn_id.value;
				var visit_limit_rule=document.forms[0].visit_limit_rule.value;
				var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
				var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
				var req_id= document.forms[0].req_id.value;
					var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
					var visit_flag_OP= document.forms[0].visit_flag_OP.value;
					var from_page= document.forms[0].from_page.value;
					var noshow_ctrl_by_splty_or_clinic= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
				var min_ela_per_resc_noshow_in_day= document.forms[0].min_ela_per_resc_noshow_in_day.value;
				var from_facility_id= document.forms[0].from_facility_id.value;
				var from_encounter_id= document.forms[0].from_encounter_id.value;
var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value; 
var capture_fin_dtls_yn	= document.forms[0].capture_fin_dtls_yn.value; 	
var no_of_noshow_appts_for_alert	= document.forms[0].no_of_noshow_appts_for_alert.value; 
var per_chk_for_no_show_alert= document.forms[0].per_chk_for_no_show_alert.value; 
var rd_appt_yn= document.forms[0].rd_appt_yn.value; 
	
var rule_appl_yn			= "";
var patient_id_temp			= "";
var name_prefix_temp		= "";
var first_name_temp			= "";
var second_name_temp		= "";
var third_name_temp			= "";
var family_name_temp		= "";
var name_suffix_temp         		= "";
var name_prefix_oth_lang_temp       = "";
var first_name_oth_lang_temp       	= "";
var second_name_oth_lang_temp       = "";
var third_name_oth_lang_temp        = "";
var family_name_oth_lang_temp       = "";
var name_suffix_oth_lang_temp       = "";
var gender_temp				= "";
var contact_no_temp			= "";
var nationality_code_temp	= "";
var language_code_temp		= "";
var term_set_id				= "";
var linking_code			= "";	

if(parent.parent.parent.tempStorageFrame && parent.parent.parent.tempStorageFrame.tempStorageForm){
	rule_appl_yn			= parent.parent.parent.tempStorageFrame.tempStorageForm.rule_appl_yn.value;
	patient_id_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value;
	name_prefix_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value;
	first_name_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value;
	second_name_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value;
	third_name_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value;
	family_name_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value;
	name_suffix_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_temp.value;
	name_prefix_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_oth_lang_temp.value;
	first_name_oth_lang_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_oth_lang_temp.value;
	second_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_oth_lang_temp.value;
	third_name_oth_lang_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_oth_lang_temp.value;
	family_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_oth_lang_temp.value;
	name_suffix_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_oth_lang_temp.value;
	
	gender_temp				= parent.parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value;
	contact_no_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value;
	nationality_code_temp	= parent.parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value;
	language_code_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value;
	term_set_id				= parent.parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value;
	linking_code			= parent.parent.parent.tempStorageFrame.tempStorageForm.linking_code.value;
}

				var callurl="../../eOA/jsp/BookAppointment.jsp?i_clinic_code="+value1+"&i_clinic_name="+value2+"&i_practitioner_id="+value3+"&i_practitioner_name="+value4+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&i_over_booked="+value8+"&i_time_table_type="+value9+"&i_patient_id="+value10+"&book_appt_across_catg_yn="+book_appt_across_catg_yn+"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&obvisit_flag="+obvisit_flag+"&ca_patient_id="+ca_patient_id+"&res_type="+res_type+"&clinic_type="+clinic_type+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&"+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&from_page1="+from_page+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&rule_appl_yn="+rule_appl_yn+"&patient_id_temp="+patient_id_temp+"&name_prefix_temp="+escape(name_prefix_temp)+"&first_name_temp="+escape(first_name_temp)+"&second_name_temp="+escape(second_name_temp)+"&third_name_temp="+escape(third_name_temp)+"&family_name_temp="+escape(family_name_temp)+"&name_suffix_temp="+escape(name_suffix_temp)+"&name_prefix_oth_lang_temp="+escape(name_prefix_oth_lang_temp)+"&first_name_oth_lang_temp="+escape(first_name_oth_lang_temp)+"&second_name_oth_lang_temp="+escape(second_name_oth_lang_temp)+"&third_name_oth_lang_temp="+escape(third_name_oth_lang_temp)+"&family_name_oth_lang_temp="+escape(family_name_oth_lang_temp)+"&name_suffix_oth_lang_temp="+escape(name_suffix_oth_lang_temp)+"&gender_temp="+gender_temp+"&contact_no_temp="+contact_no_temp+"&nationality_code_temp="+nationality_code_temp+"&language_code_temp="+language_code_temp+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn;
				retVal = parent.parent.document.frames[1].window.showModalDialog(callurl,arguments,features);
				if(retVal)
				{
				if (retVal!="abort")
				setTimeout('aaa_labels2()',1000);
				}
			
		}
		
function callBookAppointmentDetails_labels2()
{		
						var	value1=document.forms[0].clinic_code.value;
						var	value2=document.forms[0].clinic_name.value;
						var	value3=document.forms[0].pract_id.value;
						var	value4=document.forms[0].pract_name.value;
						var	value5=document.forms[0].appt_date.value;
						var	value6= document.forms[0].from_time.value;
						var	value7=document.forms[0].to_time.value;
						var	value8=document.forms[0].over_booked.value;
						var	value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
						var	value10=document.forms[0].patient_id.value;
						var	value12=document.forms[0].value12.value;
						var	value13=document.forms[0].value13.value;
						var clinic_code2=document.forms[0].clinic_code1.value;
						var clinic_code3=document.forms[0].clinic_code3.value;
						var practitioner_id2=document.forms[0].pract_id2.value;
						var practitioner_id3=document.forms[0].pract_id3.value;
						var retVal = 	new String();
						var dialogHeight= "32" ;
						var dialogWidth	= "50" ;
						var dialogTop = "190" ;
						var center = "1" ;
						var status="no";
						var ca_patient_id=parent.frames[3].document.forms[0].ca_patient_id.value;
						var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
						var arguments	= "" ;
						var res_type=document.forms[0].res_type2.value;
						var clinic_type=document.forms[0].clinic_type2.value;
						retVal = parent.parent.document.frames[1].window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+value12+"&i_clinic_code="+value1+"&i_practitioner_id="+value3+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&over_booked="+value8+"&i_time_table_type="+value9+"&value13="+value13+"&ca_patient_id="+ca_patient_id+"&res_type="+res_type+"&clinic_type="+clinic_type ,arguments,features);
						if(retVal == "close")
						retVal="|";
						returnarray=retVal.split("|");
						var j1=returnarray[1];
						var j2=returnarray[0];
						
						document.forms[0].value12.value=j2;
						document.forms[0].value13.value=j1;
						setTimeout('aaa_labels2()',1000);
		}
		
function aaa_labels2()
{		
			
				var	value1=document.forms[0].clinic_code.value;
				var	value2=document.forms[0].clinic_name.value;
				var	value3=document.forms[0].pract_id.value;
				var	value4=document.forms[0].pract_name.value;
				var	value5=document.forms[0].appt_date.value;
				var	value6= document.forms[0].from_time.value;
				var	value7=document.forms[0].to_time.value;
				var	value8=document.forms[0].over_booked.value;
				var	value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
				var	value10=document.forms[0].patient_id.value;
				var	value12=document.forms[0].value12.value;
				var	value13=document.forms[0].value13.value;
				var clinic_code2=document.forms[0].clinic_code1.value;
				var clinic_code3=document.forms[0].clinic_code3.value;
				var practitioner_id2=document.forms[0].practitioner_id1.value;
				var practitioner_id3=document.forms[0].practitioner_id3.value;
				var callingMode = document.forms[0].callingMode.value;
				var ca_patient_id=parent.frames[3].document.forms[0].ca_patient_id.value;
				var date1= parent.frames[3].document.forms[0].date1.value;
				var date2=parent.frames[3].document.forms[0].date2.value;
				var res_type1=document.forms[0].res_type1.value;
				var clinic_type1=document.forms[0].clinic_type1.value;
				var res_type2=document.forms[0].res_type2.value;
				var clinic_type2=document.forms[0].clinic_type2.value;
				var res_type3=document.forms[0].res_type3.value;
				var clinic_type3=document.forms[0].clinic_type3.value;
				var or_catalogue_code=document.forms[0].or_catalogue_code.value;
				var oper_stn_id = document.forms[0].oper_stn_id.value;
				var install_yn_val=document.forms[0].install_yn_val.value;
	var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
	var visit_flag_OP= document.forms[0].visit_flag_OP.value;

	var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value;
var from_facility_id= document.forms[0].from_facility_id.value;
				var from_encounter_id= document.forms[0].from_encounter_id.value;
var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;

var slot_appt_ctrl	= document.forms[0].slot_appt_ctrl.value;		
var visit_limit_rule= document.forms[0].visit_limit_rule.value;		
var alcn_criteria	= document.forms[0].alcn_criteria.value;		
var override_no_of_slots_yn	= document.forms[0].override_no_of_slots_yn.value;	
var min_ela_per_resc_noshow_in_day= document.forms[0].min_ela_per_resc_noshow_in_day.value;	
var noshow_ctrl_by_splty_or_clinic	= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
var no_of_noshow_appts_for_alert	= document.forms[0].no_of_noshow_appts_for_alert.value;
var per_chk_for_no_show_alert= document.forms[0].per_chk_for_no_show_alert.value;
var rd_appt_yn= document.forms[0].rd_appt_yn.value;

			if(callingMode =="" || callingMode =="CA" )
			{
				
				
				var url="../../eOA/jsp/MultiPract3Vw.jsp?clinic_code2="+value1+"&practitioner_id2="+value3+"&Date1="+value5+"&Date="+date1+"&Date2="+date2+"&clinic_code1="+clinic_code2+"&practitioner_id1="+practitioner_id2+"&clinic_code3="+clinic_code3+"&practitioner_id3="+practitioner_id3+"&ca_patient_id="+ca_patient_id+"&res_type1="+res_type1+"&clinic_type1="+clinic_type1+"&res_type2="+res_type2+"&clinic_type2="+clinic_type2+"&res_type3="+res_type3+"&clinic_type3="+clinic_type3+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&install_yn_val="+install_yn_val+"&callingMode="+callingMode+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&alcn_criteria="+alcn_criteria+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&rd_appt_yn="+rd_appt_yn;

				parent.parent.parent.frames[1].location.href=url;
			}else if (parent.parent.parent.frames[0].document.forms[0].from_OR.value =="Y" && document.forms[0].ca_patient_id.value !="")
		{
		parent.parent.parent.frames[1].location.href='../../eOR/jsp/PendingOrdersSchedule.jsp';
		}
			else
			{
				parent.window.close();
			}
}

function show_allocation_details_labels2(alcn_criteria,clinic_code,practioner_id,appt_date,time_tab_type)
{
		var dialogHeight= "10" ;
		var dialogWidth	= "30" ;
		var dialogTop = "232" ;
		var center = "1" ;
		var status="no";
		var res_type=document.forms[0].res_type2.value;
		var clinic_type=document.forms[0].clinic_type2.value;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		window.showModalDialog("../../eOA/jsp/SchAllocationdetailsFrame.jsp?alcn_criteria="+alcn_criteria+"&clinic_code="+clinic_code+"&practioner_id="+practioner_id+"&time_tab_type="+time_tab_type+"&appt_date="+appt_date+"&res_type="+res_type+"&clinic_type="+clinic_type,arguments,features);

}

/*Script function for Mp3DisplayLabels3.jsp*/

function moveNext_labels3()
{
			var value1=document.forms[0].clinic_code.value;
			var value2=document.forms[0].clinic_name.value;
			var value3=document.forms[0].pract_id.value;
			var value4=document.forms[0].pract_name.value;
			var value5=document.forms[0].appt_date.value;
			var value6= document.forms[0].from_time.value;
			var value7=document.forms[0].to_time.value;
			var value8=document.forms[0].over_booked.value;
			var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
			var value10=document.forms[0].patient_id.value;
			var value12=document.forms[0].value12.value;
			var value13=document.forms[0].value13.value;
				
				if(value9 == '3' && value8 =='Y')
				{
				value6= document.forms[0].p_o_end_time.value;
				value7=document.forms[0].p_o_end_time.value;
				}
				
				var clinic_code1=document.forms[0].clinic_code1.value;
				var clinic_code2=document.forms[0].clinic_code2.value;
				var practitioner_id1=document.forms[0].practitioner_id1.value;
				var practitioner_id2=document.forms[0].practitioner_id2.value;
				
				
				
		if(value13 != "hjjh"){
		var obook_appt_yn = book_appt_yn=document.forms[0].obook_appt_yn.value;
		if (obook_appt_yn=="N")
		   alert(getMessage('OVER_BOOK_NOT_ALLOWED','OA'));       
		else
		callBookAppointment_labels3();
		}
		else if( value13== "hjjh"){
		callBookAppointmentDetails_labels3();
		}
	}
function callBookAppointment_labels3()
{
				var value1=document.forms[0].clinic_code.value;
				var value2=document.forms[0].clinic_name.value;
				var value3=document.forms[0].pract_id.value;
				var value4=document.forms[0].pract_name.value;
				var value5=document.forms[0].appt_date.value;
				var value6= document.forms[0].from_time.value;
				var value7=document.forms[0].to_time.value;
				var value8=document.forms[0].over_booked.value;
				var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
				var value10=document.forms[0].patient_id.value;
				var value12=document.forms[0].value12.value;
				var value13=document.forms[0].value13.value;
				var value6= document.forms[0].p_o_end_time.value;
				var value7=document.forms[0].p_o_end_time.value;
				var clinic_code1=document.forms[0].clinic_code1.value;
				var clinic_code2=document.forms[0].clinic_code2.value;
				var practitioner_id1=document.forms[0].practitioner_id1.value;
				var practitioner_id2=document.forms[0].practitioner_id2.value;		
				var book_appt_yn=document.forms[0].book_appt_yn.value;
				var book_appt_wo_pid_yn=document.forms[0].book_appt_wo_pid_yn.value;
				var obook_appt_yn=document.forms[0].obook_appt_yn.value;
				var book_appt_across_catg_yn=document.forms[0].book_appt_across_catg_yn.value;
				var tfr_appt_yn=document.forms[0].tfr_appt_yn.value;
				var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
				var canc_appt_yn=document.forms[0].canc_appt_yn.value;
				var alcn_criteria=document.forms[0].alcn_criteria.value;
				var ca_patient_id=parent.frames[5].document.forms[0].ca_patient_id.value;
				var retVal = 	new String();
				var dialogHeight= "42.5" ;
				var dialogTop = "83" ;
				var dialogWidth	= "65" ;
				var status = "no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
				var obvisit_flag=document.forms[0].P_O_OBVISIT_FLAG.value;

				var res_type=document.forms[0].res_type3.value;
				var clinic_type=document.forms[0].clinic_type3.value;
				var or_catalogue_code=document.forms[0].or_catalogue_code.value;
				var oper_stn_id	=document.forms[0].oper_stn_id.value;
				var visit_limit_rule=document.forms[0].visit_limit_rule.value;
				var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
				var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
				var req_id= document.forms[0].req_id.value;
				var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
				var visit_flag_OP= document.forms[0].visit_flag_OP.value;
				var from_page= document.forms[0].from_page.value;
				var noshow_ctrl_by_splty_or_clinic= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
				var min_ela_per_resc_noshow_in_day= document.forms[0].min_ela_per_resc_noshow_in_day.value;
				var from_facility_id= document.forms[0].from_facility_id.value;
				var from_encounter_id= document.forms[0].from_encounter_id.value;
				var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;
				var capture_fin_dtls_yn	= document.forms[0].capture_fin_dtls_yn.value; 	
				var no_of_noshow_appts_for_alert	= document.forms[0].no_of_noshow_appts_for_alert.value; 
				var per_chk_for_no_show_alert = document.forms[0].per_chk_for_no_show_alert.value; 
				var rd_appt_yn = document.forms[0].rd_appt_yn.value; 

				
				
				var rule_appl_yn			= "";
				var patient_id_temp			= "";
				var name_prefix_temp		= "";
				var first_name_temp			= "";
				var second_name_temp		= "";
				var third_name_temp			= "";
				var family_name_temp		= "";
				var name_suffix_temp         		= "";
				var name_prefix_oth_lang_temp       = "";
				var first_name_oth_lang_temp       	= "";
				var second_name_oth_lang_temp       = "";
				var third_name_oth_lang_temp        = "";
				var family_name_oth_lang_temp       = "";
				var name_suffix_oth_lang_temp       = "";
				var gender_temp				= "";
				var contact_no_temp			= "";
				var nationality_code_temp	= "";
				var language_code_temp		= "";
				var term_set_id				= "";
				var linking_code			= "";	

				if(parent.parent.parent.tempStorageFrame && parent.parent.parent.tempStorageFrame.tempStorageForm){
					rule_appl_yn			= parent.parent.parent.tempStorageFrame.tempStorageForm.rule_appl_yn.value;
					patient_id_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value;
					name_prefix_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value;
					first_name_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value;
					second_name_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value;
					third_name_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value;
					family_name_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value;
					name_suffix_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_temp.value;
					name_prefix_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_oth_lang_temp.value;
					first_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_oth_lang_temp.value;
					second_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_oth_lang_temp.value;
					third_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_oth_lang_temp.value;
					family_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_oth_lang_temp.value;
					name_suffix_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_oth_lang_temp.value;
					gender_temp				= parent.parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value;
					contact_no_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value;
					nationality_code_temp	= parent.parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value;
					language_code_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value;
					term_set_id				= parent.parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value;
					linking_code			= parent.parent.parent.tempStorageFrame.tempStorageForm.linking_code.value;
				}				
				var callurl="../../eOA/jsp/BookAppointment.jsp?i_clinic_code="+value1+"&i_clinic_name="+value2+"&i_practitioner_id="+value3+"&i_practitioner_name="+value4+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&i_over_booked="+value8+"&i_time_table_type="+value9+"&i_patient_id="+value10+"&book_appt_across_catg_yn="+book_appt_across_catg_yn+"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&obvisit_flag="+obvisit_flag+"&ca_patient_id="+ca_patient_id+"&res_type="+res_type+"&clinic_type="+clinic_type+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&"+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&from_page1="+from_page+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&rule_appl_yn="+rule_appl_yn+"&patient_id_temp="+patient_id_temp+"&name_prefix_temp="+escape(name_prefix_temp)+"&first_name_temp="+escape(first_name_temp)+"&second_name_temp="+escape(second_name_temp)+"&third_name_temp="+escape(third_name_temp)+"&family_name_temp="+escape(family_name_temp)+"&name_suffix_temp="+escape(name_suffix_temp)+"&name_prefix_oth_lang_temp="+escape(name_prefix_oth_lang_temp)+"&first_name_oth_lang_temp="+escape(first_name_oth_lang_temp)+"&second_name_oth_lang_temp="+escape(second_name_oth_lang_temp)+"&third_name_oth_lang_temp="+escape(third_name_oth_lang_temp)+"&family_name_oth_lang_temp="+escape(family_name_oth_lang_temp)+"&name_suffix_oth_lang_temp="+escape(name_suffix_oth_lang_temp)+"&gender_temp="+gender_temp+"&contact_no_temp="+contact_no_temp+"&nationality_code_temp="+nationality_code_temp+"&language_code_temp="+language_code_temp+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn;
				retVal = parent.parent.document.frames[1].window.showModalDialog(callurl,arguments,features);
				
				if(retVal)
				{
				if (retVal!="abort")
				setTimeout('aaa_labels3()',1000);
				}
			
}
		
function callBookAppointmentDetails_labels3()
{		
						var value1=document.forms[0].clinic_code.value;
						var value2=document.forms[0].clinic_name.value;
						var value3=document.forms[0].pract_id.value;
						var value4=document.forms[0].pract_name.value;
						var value5=document.forms[0].appt_date.value;
						var value6= document.forms[0].from_time.value;
						var value7=document.forms[0].to_time.value;
						var value8=document.forms[0].over_booked.value;
						var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
						var value10=document.forms[0].patient_id.value;
						var value12=document.forms[0].value12.value;
						var value13=document.forms[0].value13.value;
						var value6= document.forms[0].p_o_end_time.value;
						var value7=document.forms[0].p_o_end_time.value;
						var clinic_code1=document.forms[0].clinic_code1.value;
						var clinic_code2=document.forms[0].clinic_code2.value;
						var practitioner_id1=document.forms[0].practitioner_id1.value;
						var practitioner_id2=document.forms[0].practitioner_id2.value;
						var retVal = 	new String();
						var dialogHeight= "32" ;
						var dialogWidth	= "50" ;
						var dialogTop = "190" ;
						var center = "1" ;
						var status="no";
						var ca_patient_id=parent.frames[5].document.forms[0].ca_patient_id.value;

						var res_type=document.forms[0].res_type3.value;
						var clinic_type=document.forms[0].clinic_type3.value;
		
						var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
						var arguments	= "" ;
						retVal = parent.parent.document.frames[1].window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+value12+"&i_clinic_code="+value1+"&i_practitioner_id="+value3+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&over_booked="+value8+"&i_time_table_type="+value9+"&value13="+value13+"&ca_patient_id"+ca_patient_id+"&res_type="+res_type+"&clinic_type="+clinic_type ,arguments,features);
						if(retVal == "close")
						retVal="|";
						returnarray=retVal.split("|");
						var j1=returnarray[1];
						var j2=returnarray[0];
						
						document.forms[0].value12.value=j2;
						document.forms[0].value13.value=j1;
						if(retVal == '|') ;
					else{
					mode_find="revise";
					setTimeout("aaa_labels3('"+mode_find+"');",1000);
					}
					if( cc == 'closed'){
					mode_find="dummy";
					setTimeout('aaa_labels3()',1000);
					}
}
		
function aaa_labels3()
{
				var value1=document.forms[0].clinic_code.value;
				var value2=document.forms[0].clinic_name.value;
				var value3=document.forms[0].pract_id.value;
				var value4=document.forms[0].pract_name.value;
				var value5=document.forms[0].appt_date.value;
				var value6= document.forms[0].from_time.value;
				var value7=document.forms[0].to_time.value;
				var value8=document.forms[0].over_booked.value;
				var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
				var value10=document.forms[0].patient_id.value;
				var value12=document.forms[0].value12.value;
				var value13=document.forms[0].value13.value;
				var value6= document.forms[0].p_o_end_time.value;
				var value7=document.forms[0].p_o_end_time.value;
				var clinic_code1=document.forms[0].clinic_code1.value;
				var clinic_code2=document.forms[0].clinic_code2.value;
				var practitioner_id1=document.forms[0].practitioner_id1.value;
				var practitioner_id2=document.forms[0].practitioner_id2.value;
				var callingMode =document.forms[0].callingMode.value;
				var ca_patient_id=parent.frames[5].document.forms[0].ca_patient_id.value;
				var date1=parent.frames[5].document.forms[0].date1.value;
				var date2=parent.frames[5].document.forms[0].date2.value;
				var res_type1=document.forms[0].res_type1.value;
				var clinic_type1=document.forms[0].clinic_type1.value;
				var res_type2=document.forms[0].res_type2.value;
				var clinic_type2=document.forms[0].clinic_type2.value;
				var res_type3=document.forms[0].res_type3.value;
				var clinic_type3=document.forms[0].clinic_type3.value;
				var or_catalogue_code=document.forms[0].or_catalogue_code.value;
				var oper_stn_id=document.forms[0].oper_stn_id.value;
				var alcn_criteria=document.forms[0].alcn_criteria.value;
				var visit_limit_rule=document.forms[0].visit_limit_rule.value;
				var slot_appt_ctrl = document.forms[0].slot_appt_ctrl.value;
				var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
var install_yn_val=document.forms[0].install_yn_val.value;
	var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
	var visit_flag_OP= document.forms[0].visit_flag_OP.value;

	var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value;
var from_facility_id= document.forms[0].from_facility_id.value;
				var from_encounter_id= document.forms[0].from_encounter_id.value;
				var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;

var min_ela_per_resc_noshow_in_day	= document.forms[0].min_ela_per_resc_noshow_in_day.value;
var noshow_ctrl_by_splty_or_clinic	= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
var no_of_noshow_appts_for_alert	= document.forms[0].no_of_noshow_appts_for_alert.value;
var per_chk_for_no_show_alert		= document.forms[0].per_chk_for_no_show_alert.value;
var rd_appt_yn		= document.forms[0].rd_appt_yn.value;



		if(callingMode =="" || callingMode =="CA" )
		{
			
		var url="../../eOA/jsp/MultiPract3Vw.jsp?clinic_code3="+value1+"&practitioner_id3="+value3+"&Date2="+value5+"&Date="+date1+"&Date1="+date2+"&clinic_code1="+clinic_code1+"&practitioner_id1="+practitioner_id1+"&clinic_code2="+clinic_code2+"&practitioner_id2="+practitioner_id2+"&ca_patient_id="+ca_patient_id+"&res_type1="+res_type1+"&clinic_type1="+clinic_type1+"&res_type2="+res_type2+"&clinic_type3="+clinic_type3+"&res_type3="+res_type3+"&clinic_type2="+clinic_type2+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&alcn_criteria="+alcn_criteria+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&callingMode="+callingMode+"&create_wait_list_yn="+create_wait_list_yn+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&rd_appt_yn="+rd_appt_yn;
			
			parent.parent.parent.frames[1].location.href=url;
			}else if (parent.parent.parent.frames[0].document.forms[0].from_OR.value =="Y" && document.forms[0].ca_patient_id.value !="")
		{
		parent.parent.parent.frames[1].location.href='../../eOR/jsp/PendingOrdersSchedule.jsp';
		}
		
				else
			
			{
				parent.window.close();
			}
}
	

function show_allocation_details_labels3(alcn_criteria,clinic_code,practioner_id,appt_date,time_tab_type)
{
	var dialogHeight= "10" ;
	var dialogWidth	= "30" ;
	var dialogTop = "232" ;
	var center = "1" ;
	var status="no";
	var res_type=document.forms[0].res_type3.value;
	var clinic_type=document.forms[0].clinic_type3.value;

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	window.showModalDialog("../../eOA/jsp/SchAllocationdetailsFrame.jsp?alcn_criteria="+alcn_criteria+"&clinic_code="+clinic_code+"&practioner_id="+practioner_id+"&time_tab_type="+time_tab_type+"&appt_date="+appt_date+"&res_type="+res_type+"&clinic_type="+clinic_type,arguments,features);

}

/*Script functions for Mp3DisplayResults.jsp*/

function show_Reference_details_results0(appt_no2,fac_id2)
{
	var dialogHeight= "23" ;
	var dialogWidth	= "54" ;
	var dialogTop = "190" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	window.showModalDialog("../../eOA/jsp/SecApptReferenceFrame.jsp?appt_no2="+appt_no2+"&fac_id2="+fac_id2,arguments,features);
}
async function callBookAppointment_results0(x)
{

		var Forced='N';
		if(x=='F')
		{
			Forced='Y';
		}
		var value_chk=document.forms[0].value_chk.value;
		var	value1;
		var value2=document.forms[0].clinic_name.value;
		var value3;
		var value4=document.forms[0].pract_name.value;
		var value5;
		var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
		var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
		var value8=document.forms[0].over_booked.value;
		var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
		var value10=document.forms[0].patient_id.value;
		var value11=document.forms[0].elements[u1].value;
		var value12=document.forms[0].clinic_code2.value;
		var value13=document.forms[0].pract_id2.value;
		var value14=document.forms[0].clinic_code3.value;
		var value15=document.forms[0].pract_id3.value;
		var value16=document.forms[0].reason_for_revise.value;
		var value17=document.forms[0].ref_no.value;
		var value20= document.forms[0].old_from_time.value;
		var value21= document.forms[0].old_to_time.value;
			old_date=document.forms[0].old_date.value;
			
			if(value_chk =="display1")
			{
					value1=document.forms[0].clinic_code.value;
					value3=document.forms[0].pract_id.value;
					value5=document.forms[0].appt_date.value;

			}else if(value_chk =="display2")
			{
					value1=document.forms[0].clinic_code2.value;
					value3=document.forms[0].pract_id2.value;
					value5=document.forms[0].date1.value;

			}else if(value_chk =="display3")
			{
					value1=document.forms[0].clinic_code3.value;
					value3=document.forms[0].pract_id3.value;
					value5=document.forms[0].date2.value;
			}
				var book_appt_yn=document.forms[0].book_appt_yn.value;
				var book_appt_wo_pid_yn=document.forms[0].book_appt_wo_pid_yn.value;
				var obook_appt_yn=document.forms[0].obook_appt_yn.value;
				var book_appt_across_catg_yn=document.forms[0].book_appt_across_catg_yn.value;
				var tfr_appt_yn=document.forms[0].tfr_appt_yn.value;
				var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
				var canc_appt_yn=document.forms[0].canc_appt_yn.value;
				var alcn_criteria=document.forms[0].alcn_criteria.value;
				var ca_patient_id=document.forms[0].ca_patient_id.value;
				var retVal = 	new String();
				var dialogHeight= "90vh" ;
				var dialogTop = "83" ;
				var dialogWidth	= "70vw" ;
				var status = "no";

				//var res_type=document.forms[0].res_type1.value;
				//var clinic_type=document.forms[0].clinic_type1.value;
				if(value_chk =="display1")
				{
				var res_type=document.forms[0].res_type1.value;
				var clinic_type=document.forms[0].clinic_type1.value;
				}else if(value_chk =="display2")
				{
					var res_type=document.forms[0].res_type2.value;
					var clinic_type=document.forms[0].clinic_type2.value;
				}else if(value_chk =="display3")
				{
					var res_type=document.forms[0].res_type3.value;
					var clinic_type=document.forms[0].clinic_type3.value;
				}
				var or_catalogue_code=document.forms[0].or_catalogue_code.value;
				var oper_stn_id	=document.forms[0].oper_stn_id.value;
				var visit_limit_rule=document.forms[0].visit_limit_rule.value;
				var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
				var order_id=document.forms[0].order_id.value;
				var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
				var order_line_num=document.forms[0].order_line_num.value;
				var order_catalog_code=document.forms[0].order_catalog_code.value;
				var req_id= document.forms[0].req_id.value;
					var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
					var visit_flag_OP= document.forms[0].visit_flag_OP.value;
					var from_page= document.forms[0].from_page.value;
					var noshow_ctrl_by_splty_or_clinic= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
				var min_ela_per_resc_noshow_in_day= document.forms[0].min_ela_per_resc_noshow_in_day.value;
				var from_facility_id= document.forms[0].from_facility_id.value;
				var from_encounter_id= document.forms[0].from_encounter_id.value;
				var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value; 
				var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value; 

var no_of_noshow_appts_for_alert	= document.forms[0].no_of_noshow_appts_for_alert.value; 
var per_chk_for_no_show_alert		= document.forms[0].per_chk_for_no_show_alert.value;
var rd_appt_yn		= document.forms[0].rd_appt_yn.value;

			
				var rule_appl_yn			= "";
				var patient_id_temp			= "";
				var name_prefix_temp		= "";
				var first_name_temp			= "";
				var second_name_temp		= "";
				var third_name_temp			= "";
				var family_name_temp		= "";
				var name_suffix_temp         		= "";
				var name_prefix_oth_lang_temp       = "";
				var first_name_oth_lang_temp       	= "";
				var second_name_oth_lang_temp       = "";
				var third_name_oth_lang_temp        = "";
				var family_name_oth_lang_temp       = "";
				var name_suffix_oth_lang_temp       = "";
				var gender_temp				= "";
				var contact_no_temp			= "";
				var nationality_code_temp	= "";
				var language_code_temp		= "";
				var term_set_id				= "";
				var linking_code			= "";	
				var apptrefno				= "";

				if(parent.parent.parent.tempStorageFrame && parent.parent.parent.tempStorageFrame.tempStorageForm){
					rule_appl_yn			= parent.parent.parent.tempStorageFrame.tempStorageForm.rule_appl_yn.value;
					patient_id_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value;
					name_prefix_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value;
					first_name_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value;
					second_name_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value;
					third_name_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value;
					family_name_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value;
					name_suffix_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_temp.value;
					name_prefix_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_oth_lang_temp.value;
					first_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_oth_lang_temp.value;
					second_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_oth_lang_temp.value;
					third_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_oth_lang_temp.value;
					family_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_oth_lang_temp.value;
					name_suffix_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_oth_lang_temp.value;
					gender_temp				= parent.parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value;
					contact_no_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value;
					nationality_code_temp	= parent.parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value;
					language_code_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value;
					term_set_id				= parent.parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value;
					linking_code			= parent.parent.parent.tempStorageFrame.tempStorageForm.linking_code.value;
					canldapptrefno			= parent.parent.parent.tempStorageFrame.tempStorageForm.apptrefno.value;
				}
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
				var callurl="../../eOA/jsp/BookAppointment.jsp?i_clinic_code="+value1+"&i_clinic_name="+escape(value2)+"&i_practitioner_id="+value3+"&i_practitioner_name="+escape(value4)+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&i_over_booked="+value8+"&i_time_table_type="+value9+"&i_patient_id="+value10+"&book_appt_across_catg_yn="+book_appt_across_catg_yn+"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&ca_patient_id="+ca_patient_id+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&Forced="+Forced+"&res_type="+res_type+"&clinic_type="+clinic_type+"&or_catalogue_code="+or_catalogue_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code+"&oper_stn_id="+oper_stn_id+"&"+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&from_page1="+from_page+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&rule_appl_yn="+rule_appl_yn+"&patient_id_temp="+patient_id_temp+"&name_prefix_temp="+escape(name_prefix_temp)+"&first_name_temp="+escape(first_name_temp)+"&second_name_temp="+escape(second_name_temp)+"&third_name_temp="+escape(third_name_temp)+"&family_name_temp="+escape(family_name_temp)+"&name_suffix_temp="+escape(name_suffix_temp)+"&name_prefix_oth_lang_temp="+escape(name_prefix_oth_lang_temp)+"&first_name_oth_lang_temp="+escape(first_name_oth_lang_temp)+"&second_name_oth_lang_temp="+escape(second_name_oth_lang_temp)+"&third_name_oth_lang_temp="+escape(third_name_oth_lang_temp)+"&family_name_oth_lang_temp="+escape(family_name_oth_lang_temp)+"&name_suffix_oth_lang_temp="+escape(name_suffix_oth_lang_temp)+"&gender_temp="+gender_temp+"&contact_no_temp="+contact_no_temp+"&nationality_code_temp="+nationality_code_temp+"&language_code_temp="+language_code_temp+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&canldapptrefno="+canldapptrefno+"&rd_appt_yn="+rd_appt_yn;

				// calling page check is opened as global booking can be done from any fucntion.
				//if(document.forms[0].calling_mode.value=='OP' && document.forms[0].refID.value!='N' && from_page ==""){	
				if(document.forms[0].LocGlbChk.value=='Y'){

					if(document.forms[0].GlobalAllowed.value=='Y'){
						if(parseInt(document.forms[0].maxGlobal.value) >0 ){
							if(parseInt(document.forms[0].totGlobal.value) < parseInt(document.forms[0].maxGlobal.value)){
								callurl=callurl+"&Global=Y";
								retVal = await top.window.showModalDialog(callurl,arguments,features);
							
								if(retVal == 'abort') ;
								else{
								if(parent.parent.parent.tempStorageFrame && parent.parent.parent.tempStorageFrame.tempStorageForm){
									parent.parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value="";
									parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value="";
									parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value="";
									parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value="";
									parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value="";
									parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value="";
									parent.parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value="";
									parent.parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value="";
									parent.parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value="";
									parent.parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value="";
									parent.parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value="";
									parent.parent.parent.tempStorageFrame.tempStorageForm.linking_code.value="";
								}									
									setTimeout('dummmmmmyyy()',1000);
									aaa_results0(retVal)
								}
							}else{
								alert(getMessage('GLOBAL_BOOKING_OVER','OA'));								
							}
						}else{
							alert(getMessage('GLOBAL_NOT_SCHEDULE','OA'));
						}
					}else{
						alert(getMessage('GLOBAL_NOT_USER','OA'));
					}
				}else{		
					callurl=callurl+"&Global=N";
					retVal = await top.window.showModalDialog(callurl,arguments,features);

					if(retVal == 'abort') ;
					else{
						if(parent.parent.parent.tempStorageFrame && parent.parent.parent.tempStorageFrame.tempStorageForm){
							parent.parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.linking_code.value="";
						}
						setTimeout('dummmmmmyyy()',1000);
						aaa_results0(retVal)
					}
				}


	}

function dummmmmmyyy(){
}

	
function callBookAppointmentDetails_results0(pVal){  
	var maxForced=document.forms[0].maxForced.value;
	var totForced=document.forms[0].totForced.value;
	var from_date=document.forms[0].old_date.value;
	var sys_date=document.forms[0].sys_date.value;
	var	value1=document.forms[0].clinic_code.value;
	var value2=document.forms[0].clinic_name.value;
	var value3=document.forms[0].pract_id.value;
	var value4=document.forms[0].pract_name.value;
	var value5=document.forms[0].appt_date.value;
	if(pVal!='NF'){
		var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
		var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
	}else{
		var value6= document.getElementById('results0').rows[u1].cells[u2].innerText;
		var value7=document.getElementById('results0').rows[u1].cells[u2+1].innerText;
	}
	var value8=document.forms[0].over_booked.value;
	var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
	var value10=document.forms[0].patient_id.value;
	var value11=document.forms[0].elements[u1].value;
	var value12=document.forms[0].clinic_code2.value;
	var value13=document.forms[0].pract_id2.value;
	var value14=document.forms[0].clinic_code3.value;
	var value15=document.forms[0].pract_id3.value;
	var value16=document.forms[0].reason_for_revise.value;
	var value17=document.forms[0].ref_no.value;
	var value20= document.forms[0].old_from_time.value;
	var value21= document.forms[0].old_to_time.value;
	var end_to_time=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
	var appt_date_value="";
	if(document.forms[0].value_chk.value=="display1"){
		appt_date_value=document.forms[0].appt_date.value;
	}else if(document.forms[0].value_chk.value=="display2"){
		appt_date_value=document.forms[0].date1.value;
	}else if(document.forms[0].value_chk.value=="display3"){
		appt_date_value=document.forms[0].date2.value;
	}
		if(document.forms[0].P_O_TIME_TAB_TYPE.value!='2'){
			if(pVal=='F' || pVal=='NF'){
				if(pVal=='F'){
					callBookAppointmentDetailsDum_results0('F');
				}else{
					callBookAppointmentDetailsDum_results0('N','NF');
				}			
			}else{
				if(document.forms[0].ForcedAllowed.value=='Y'){
					if(document.forms[0].refID.value=='N'){
						if(parseInt(maxForced)>0 && (parseInt(totForced)<parseInt(maxForced))){

							if(document.forms[0].calling_mode.value==""){
								if(Date.parse(appt_date_value) == Date.parse(sys_date) ){
									if(document.forms[0].LocGlbChk.value=='Y' || end_to_time == "23:59"){
										callBookAppointmentDetailsDum_results0('N');
									}else{
										if(window.confirm(getMessage('CONFIRM_FORCED_BOOKING','OA'))){
											callBookAppointment_results0('F');
										}else{
											callBookAppointmentDetailsDum_results0('N');
										}
									}
								}else{
						if(end_to_time != "23:59"){
					if(window.confirm(getMessage('FORCED_BOOK_FUTURE_DATE','OA')))
					{
					}else
          {
          callBookAppointmentDetailsDum_results0('N');
          					}}
					else
					{
								callBookAppointmentDetailsDum_results0('N');
					}
							}
							
							
							
						} else 
						{
							callBookAppointmentDetailsDum_results0('N');
						}
						}else{
							callBookAppointmentDetailsDum_results0('N');
						}
					}else{
						callBookAppointmentDetailsDum_results0('N');
					}
				}else{
					callBookAppointmentDetailsDum_results0('N');
				}
			}
		}else{	
			if(pVal=='F' || pVal=='NF'){
				if(pVal=='F'){
					callBookAppointmentDetailsDum_results0('F');
				}else{
					callBookAppointmentDetailsDum_results0('N');
				}			
			}else{
				if(pVal=='M'){
					if(document.forms[0].ForcedAllowed.value=='Y'){
						if(document.forms[0].refID.value=='N'){
							if(parseInt(maxForced)>0 && (parseInt(totForced)<parseInt(maxForced))){
									if(document.forms[0].calling_mode.value=="") {
									if(Date.parse(appt_date_value) == Date.parse(sys_date) ){
										if(document.forms[0].LocGlbChk.value=='Y' || end_to_time == "23:59"){
											callBookAppointmentDetailsDum_results0('N');
										}else{
											if(window.confirm(getMessage('CONFIRM_FORCED_BOOKING','OA'))){
												callBookAppointment_results0('F');
											}else{
												callBookAppointmentDetailsDum_results0('N');
											}
										}
							}else
							{
								if(end_to_time != "23:59"){
					if(window.confirm(getMessage('FORCED_BOOK_FUTURE_DATE','OA')))
					{
					}else
					{
								callBookAppointmentDetailsDum_results0('N');
					}}else
					{
								callBookAppointmentDetailsDum_results0('N');
					}
					}
							} else
							{
								callBookAppointmentDetailsDum_results0('N');
							}
							}else{
								callBookAppointmentDetailsDum_results0('N');
							}
						}else{
							callBookAppointmentDetailsDum_results0('N');
						}
					}else{
						callBookAppointmentDetailsDum_results0('N');
					}
				}else{
					callBookAppointmentDetailsDum_results0('N');
				}
			}			
		}
	}


async function callBookAppointmentDetailsDum_results0(pVal,pValPass){  
	var	value1="";
	/*Added by Thamizh selvi on 16th July 2018 against ML-MMOH-CRF-1058 Start*/
	var isIncRemarksLengthAppl = "";
	if(document.forms[0].isIncRemarksLengthAppl)
		isIncRemarksLengthAppl = document.forms[0].isIncRemarksLengthAppl.value;
	/*End*/
	old_date=document.forms[0].old_date.value;
	var book_appt_yn=document.forms[0].book_appt_yn.value;
	var book_appt_wo_pid_yn=document.forms[0].book_appt_wo_pid_yn.value;
	var obook_appt_yn=document.forms[0].obook_appt_yn.value;
	var book_appt_across_catg_yn=document.forms[0].book_appt_across_catg_yn.value;
	var tfr_appt_yn=document.forms[0].tfr_appt_yn.value;
	var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
	var canc_appt_yn=document.forms[0].canc_appt_yn.value;
	var alcn_criteria=document.forms[0].alcn_criteria.value;
	var pre_pat_alcn_catg_code=document.forms[0].pre_pat_alcn_catg_code.value;
	//var	value1=document.forms[0].clinic_code.value;
	var value2=document.forms[0].clinic_name.value;
	var value3=document.forms[0].pract_id.value;
	var value4=document.forms[0].pract_name.value;
	var value5=document.forms[0].appt_date.value;
	if(pValPass=='NF'){
		var value6= document.getElementById('results0').rows[u1].cells[u2].innerText;
		var value7=document.getElementById('results0').rows[u1].cells[u2+1].innerText;
	}else{
		var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
		var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
	}
	var value_chk=document.forms[0].value_chk.value;
	if(value_chk =="display1"){
		value1=document.forms[0].clinic_code.value;
		value3=document.forms[0].pract_id.value;
	}else if(value_chk =="display2"){
		value1=document.forms[0].clinic_code2.value;
		value3=document.forms[0].pract_id2.value;
	}else if(value_chk =="display3"){
		value1=document.forms[0].clinic_code3.value;
		value3=document.forms[0].pract_id3.value;
	}
	var value8=document.forms[0].over_booked.value;
	var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
	var value10=document.forms[0].patient_id.value;
	var value11=document.forms[0].elements[u1].value;
	var value12=document.forms[0].clinic_code2.value;
	var value13=document.forms[0].pract_id2.value;
	var value14=document.forms[0].clinic_code3.value;
	var value15=document.forms[0].pract_id3.value;
	var value16=document.forms[0].reason_for_revise.value;
	var value17=document.forms[0].ref_no.value;
	var value20= document.forms[0].old_from_time.value;
	var value21= document.forms[0].old_to_time.value;
	var mode_find="";
	var Forced=pVal;
	if( value16.length > 0 && value17 != null ) value11=value17;
	var retVal = 	new String();
	var dialogHeight= "32" ;
	var dialogWidth	= "50" ;
	var dialogTop = "190" ;
	/*Added by Thamizh selvi on 16th July 2018 against ML-MMOH-CRF-1058 Start*/
	if(isIncRemarksLengthAppl == "true")
		dialogHeight = "50" ;
		dialogWidth	 = "65" ;
	/*End*/
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var res_type=document.forms[0].res_type1.value;
	var clinic_type=document.forms[0].clinic_type1.value;
	var calling_mode=document.forms[0].calling_mode.value;
	var call="../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+eval('document.forms[0].o_appt_ref_no'+u1).value+"&i_clinic_code="+value1+"&i_practitioner_id="+value3+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&value13="+value16+"&over_booked="+value8+"&i_time_table_type="+value9+"&old_from_time="+document.forms[0].old_from_time.value+"&old_to_time="+document.forms[0].old_to_time.value+"&old_date="+old_date+"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&Forced="+Forced+"&res_type="+res_type+"&calling_mode="+calling_mode+"&clinic_type="+clinic_type;		
	retVal = await window.showModalDialog(call ,arguments,features);
	var cc=retVal;
	if(retVal == 'close')
	retVal="|";
	if(retVal == 'closed') retVal="|";
	if(retVal == '|'){
	}else{
		mode_find="dummy";
		setTimeout("aaa_results0('"+mode_find+"');",1000);
	}
	if(cc == 'closed'){
		mode_find="dummy";
		setTimeout('aaa_results0()',1000);
	}
}

function aaa_results0(mode_find)
{

		var	value1=document.forms[0].clinic_code.value;
		var value2=document.forms[0].clinic_name.value;
		var value3=document.forms[0].pract_id.value;
		var value4=document.forms[0].pract_name.value;
		var value5=document.forms[0].appt_date.value;
		var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
		var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
		var value8=document.forms[0].over_booked.value;
		var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
		var value10=document.forms[0].patient_id.value;
		var value11=document.forms[0].elements[u1].value;
		var value12=document.forms[0].clinic_code2.value;
		var value13=document.forms[0].pract_id2.value;
		var value14=document.forms[0].clinic_code3.value;
		var value15=document.forms[0].pract_id3.value;
		var value16=document.forms[0].reason_for_revise.value;
		var value17=document.forms[0].ref_no.value;
		var value20= document.forms[0].old_from_time.value;
		var value21= document.forms[0].old_to_time.value;
		var callingMode = document.forms[0].callingMode.value;


		if(callingMode =="" || callingMode =="CA" )
		{
	

			var ca_mode=document.forms[0].ca_mode.value;
			var ca_patient_id=document.forms[0].ca_patient_id.value;
			value16=document.forms[0].reason_for_revise.value;
			value17=document.forms[0].ref_no.value;
			var old_clinic=document.forms[0].old_clinic.value;
			var old_practitioner=document.forms[0].old_practitioner.value;
			var date1=document.forms[0].date1.value;
			var date2=document.forms[0].date2.value;
			var old_date=document.forms[0].old_date.value;

			var res_type1=document.forms[0].res_type1.value;
			var clinic_type1=document.forms[0].clinic_type1.value;
			var res_type2=document.forms[0].res_type2.value;
			var clinic_type2=document.forms[0].clinic_type2.value;

			var res_type3=document.forms[0].res_type3.value;
			var clinic_type3=document.forms[0].clinic_type3.value;
			var or_catalogue_code=document.forms[0].or_catalogue_code.value;
			var oper_stn_id = document.forms[0].oper_stn_id.value;
			var alcn_criteria =document.forms[0].alcn_criteria.value;
			var visit_limit_rule=document.forms[0].visit_limit_rule.value;
			var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
			var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
			var install_yn_val=document.forms[0].install_yn_val.value;
				var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
		var visit_flag_OP= document.forms[0].visit_flag_OP.value;

		var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value;
var from_facility_id= document.forms[0].from_facility_id.value;
				var from_encounter_id= document.forms[0].from_encounter_id.value;
				var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;

var min_ela_per_resc_noshow_in_day	= document.forms[0].min_ela_per_resc_noshow_in_day.value;
var noshow_ctrl_by_splty_or_clinic	= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
var no_of_noshow_appts_for_alert	= document.forms[0].no_of_noshow_appts_for_alert.value;
var per_chk_for_no_show_alert		= document.forms[0].per_chk_for_no_show_alert.value;
var rd_appt_yn		= document.forms[0].rd_appt_yn.value;

			var u="clinic_code1="+value1+"&practitioner_id1="+value3+"&clinic_code2="+value12+"&practitioner_id2="+value13+"&clinic_code3="+value14+"&practitioner_id3="+value15+"&Date="+value5+"&Date1="+date1+"&Date2="+date2+"&value12="+value17+"&value13="+value16+"&old_clinic="+old_clinic+"&old_practitioner="+old_practitioner+"&Param=first&old_from_time="+document.forms[0].old_from_time.value+"&old_to_time="+document.forms[0].old_to_time.value+"&old_date="+old_date+"&pre_pat_alcn_catg_code="+document.forms[0].pre_pat_alcn_catg_code.value+"&mode_find="+mode_find+"&ca_patient_id="+ca_patient_id+"&ca_mode="+ca_mode+"&res_type1="+res_type1+"&clinic_type1="+clinic_type1+"&res_type2="+res_type2+"&clinic_type2="+clinic_type2+"&res_type3="+res_type3+"&clinic_type3="+clinic_type3+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&alcn_criteria="+alcn_criteria+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&callingMode="+callingMode+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&rd_appt_yn="+rd_appt_yn;

			var url="../../eOA/jsp/MultiPract3Vw.jsp?"+u;

			parent.parent.parent.frames[1].location.href=url; 
	}else if (parent.parent.parent.frames[0].document.forms[0].from_OR.value =="Y" && document.forms[0].ca_patient_id.value !="")
		{
		parent.parent.parent.frames[0].selectTab('order_tab');
		parent.parent.parent.frames[0].document.getElementById('day_tab').className="tabA";
		parent.parent.parent.frames[0].document.getElementById('day_tabspan').className="tabAspan";
		parent.parent.parent.frames[1].location.href='../../eOR/jsp/PendingOrdersSchedule.jsp';
		}else
	{
		if(mode_find)
		{
			parent.window.returnValue=mode_find;
		}
		parent.window.close();
	}
}

function visiblelity_results0()
{
	setTimeout('cc_results0()',0);
}

function cc_results0()
{
	if(document.forms[0].reason_for_revise.value.length == 0 || document.forms[0].reason_for_revise.value =="undefined" ){}
	else{
	parent.parent.frames[0].document.forms[0].ref_no.value=document.forms[0].ref_no.value;
	parent.parent.frames[0].document.forms[0].reason_for_revise.value=document.forms[0].reason_for_revise.value;
	parent.parent.frames[0].document.getElementById('ss').style.visibility="visible";
	parent.parent.frames[0].document.forms[0].decide.value='one';
	}
}

async function callBookAppointmentDetails2_results0()
{
	
		old_date=document.forms[0].old_date.value;
		var	value1=document.forms[0].clinic_code.value;
		var value2=document.forms[0].clinic_name.value;
		var value3=document.forms[0].pract_id.value;
		var value4=document.forms[0].pract_name.value;
		var value5=document.forms[0].appt_date.value;
		var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
		var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
		var value8=document.forms[0].over_booked.value;
		var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
		var value10=document.forms[0].patient_id.value;
		var value11=document.forms[0].elements[u1].value;
		var value12=document.forms[0].clinic_code2.value;
		var value13=document.forms[0].pract_id2.value;
		var value14=document.forms[0].clinic_code3.value;
		var value15=document.forms[0].pract_id3.value;
		var value16=document.forms[0].reason_for_revise.value;
		var value17=document.forms[0].ref_no.value;
		var value20= document.forms[0].old_from_time.value;
		var value21= document.forms[0].old_to_time.value;
		if( value16.length > 0 && value17 != null ) value11=value17;
				var retVal = 	new String();
				var dialogHeight= "32" ;
				var dialogWidth	= "50" ;
				var dialogTop = "190" ;
				var center = "1" ;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				var res_type=document.forms[0].res_type1.value;
				var clinic_type=document.forms[0].clinic_type1.value;
				var calling_mode=document.forms[0].calling_mode.value;
				var call="../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+value11+"&i_clinic_code="+value1+"&i_practitioner_id="+value3+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&value13="+value12+"&over_booked="+value8+"&i_time_table_type="+value9+"&flag=Visit_Reg&old_date="+old_date+"&res_type="+res_type+"&clinic_type="+clinic_type+"&calling_mode="+calling_mode;
				
				retVal = await window.showModalDialog(call ,arguments,features);
				var cc=retVal;
				if(retVal == 'close')
				retVal="|";
				if(retVal == 'closed') retVal="|";

				if(retVal == '|') ;
				else{
					setTimeout('aaa_results0()',1000);
					}
				if( cc == 'closed')
				setTimeout('aaa_results0()',1000);
				
}

/*Script functions for Mp3DisplayResults2.jsp*/

async function callBookAppointment_results2(x)
{

				var Forced='N';
				if(x=='F'){
					Forced='Y';
				}
				var value1=document.forms[0].clinic_code.value;
				var value2=document.forms[0].clinic_name.value;
				var value3=document.forms[0].pract_id.value;
				var value4=document.forms[0].pract_name.value;
				var value5=document.forms[0].appt_date.value;
				var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
				var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
				var value8=document.forms[0].over_booked.value;
				var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
				var value10=document.forms[0].patient_id.value;
				var value11=document.forms[0].elements[u1].value;
				var value12=document.forms[0].clinic_code1.value;
				var value13=document.forms[0].pract_id1.value;
				var value14=document.forms[0].clinic_code3.value;
				var value15=document.forms[0].pract_id3.value;
				var value16=document.forms[0].reason_for_revise.value;
				var value17=document.forms[0].ref_no.value;
				var value20= document.forms[0].old_from_time.value;
				var value21= document.forms[0].old_to_time.value;
				old_date=document.forms[0].old_date.value;
				var book_appt_yn=document.forms[0].book_appt_yn.value;
				var book_appt_wo_pid_yn=document.forms[0].book_appt_wo_pid_yn.value;
				var obook_appt_yn=document.forms[0].obook_appt_yn.value;
				var book_appt_across_catg_yn=document.forms[0].book_appt_across_catg_yn.value;
				var tfr_appt_yn=document.forms[0].tfr_appt_yn.value;
				var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
				var canc_appt_yn=document.forms[0].canc_appt_yn.value;
				var alcn_criteria=document.forms[0].alcn_criteria.value;
				var ca_patient_id=document.forms[0].ca_patient_id.value;

				var res_type=document.forms[0].res_type2.value;
				var clinic_type=document.forms[0].clinic_type2.value;
				var or_catalogue_code=document.forms[0].or_catalogue_code.value;
				var order_id=document.forms[0].order_id.value;
				var order_line_num=document.forms[0].order_line_num.value;
				var order_catalog_code=document.forms[0].order_catalog_code.value;
				var oper_stn_id	=document.forms[0].oper_stn_id.value;
				var visit_limit_rule=document.forms[0].visit_limit_rule.value;
				var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
				var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
				var retVal = 	new String();
				var dialogHeight= "42.5" ;
				var dialogTop = "83" ;
				var dialogWidth	= "65" ;
				var status = "no";
				
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
				var req_id= document.forms[0].req_id.value;
					var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
					var visit_flag_OP= document.forms[0].visit_flag_OP.value;
					var from_page= document.forms[0].from_page.value;
					var noshow_ctrl_by_splty_or_clinic= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
				var min_ela_per_resc_noshow_in_day= document.forms[0].min_ela_per_resc_noshow_in_day.value;
				var from_facility_id= document.forms[0].from_facility_id.value;
				var from_encounter_id= document.forms[0].from_encounter_id.value;
				var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value; 

var capture_fin_dtls_yn		= document.forms[0].capture_fin_dtls_yn.value;
var no_of_noshow_appts_for_alert	= document.forms[0].no_of_noshow_appts_for_alert.value;
var per_chk_for_no_show_alert= document.forms[0].per_chk_for_no_show_alert.value;
var rd_appt_yn= document.forms[0].rd_appt_yn.value;



				var rule_appl_yn			= "";
				var patient_id_temp			= "";
				var name_prefix_temp		= "";
				var first_name_temp			= "";
				var second_name_temp		= "";
				var third_name_temp			= "";
				var family_name_temp		= "";
				var name_suffix_temp         		= "";
				var name_prefix_oth_lang_temp       = "";
				var first_name_oth_lang_temp       	= "";
				var second_name_oth_lang_temp       = "";
				var third_name_oth_lang_temp        = "";
				var family_name_oth_lang_temp       = "";
				var name_suffix_oth_lang_temp       = "";
				var gender_temp				= "";
				var contact_no_temp			= "";
				var nationality_code_temp	= "";
				var language_code_temp		= "";
				var term_set_id				= "";
				var linking_code			= "";	

				if(parent.parent.parent.tempStorageFrame && parent.parent.parent.tempStorageFrame.tempStorageForm){
					rule_appl_yn			= parent.parent.parent.tempStorageFrame.tempStorageForm.rule_appl_yn.value;
					patient_id_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value;
					name_prefix_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value;
					first_name_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value;
					second_name_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value;
					third_name_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value;
					family_name_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value;
					name_suffix_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_temp.value;
					name_prefix_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_oth_lang_temp.value;
					first_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_oth_lang_temp.value;
					second_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_oth_lang_temp.value;
					third_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_oth_lang_temp.value;
					family_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_oth_lang_temp.value;
					name_suffix_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_oth_lang_temp.value;					
					gender_temp				= parent.parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value;
					contact_no_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value;
					nationality_code_temp	= parent.parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value;
					language_code_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value;
					term_set_id				= parent.parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value;
					linking_code			= parent.parent.parent.tempStorageFrame.tempStorageForm.linking_code.value;
				}


				var callurl="../../eOA/jsp/BookAppointment.jsp?i_clinic_code="+value1+"&i_clinic_name="+escape(value2)+"&i_practitioner_id="+value3+"&i_practitioner_name="+escape(value4)+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&i_over_booked="+value8+"&i_time_table_type="+value9+"&i_patient_id="+value10+"&book_appt_across_catg_yn="+book_appt_across_catg_yn+"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&ca_patient_id="+ca_patient_id+"&alcn_criteria="+alcn_criteria+"&Forced="+Forced+"&res_type="+res_type+"&clinic_type="+clinic_type+"&or_catalogue_code="+or_catalogue_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code+"&oper_stn_id="+oper_stn_id+"&"+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&from_page1="+from_page+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&rule_appl_yn="+rule_appl_yn+"&patient_id_temp="+patient_id_temp+"&name_prefix_temp="+escape(name_prefix_temp)+"&first_name_temp="+escape(first_name_temp)+"&second_name_temp="+escape(second_name_temp)+"&third_name_temp="+escape(third_name_temp)+"&family_name_temp="+escape(family_name_temp)+"&name_suffix_temp="+escape(name_suffix_temp)+"&name_prefix_oth_lang_temp="+escape(name_prefix_oth_lang_temp)+"&first_name_oth_lang_temp="+escape(first_name_oth_lang_temp)+"&second_name_oth_lang_temp="+escape(second_name_oth_lang_temp)+"&third_name_oth_lang_temp="+escape(third_name_oth_lang_temp)+"&family_name_oth_lang_temp="+escape(family_name_oth_lang_temp)+"&name_suffix_oth_lang_temp="+escape(name_suffix_oth_lang_temp)+"&gender_temp="+gender_temp+"&contact_no_temp="+contact_no_temp+"&nationality_code_temp="+nationality_code_temp+"&language_code_temp="+language_code_temp+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn;
				// calling page check is opened as global booking can be done from any fucntion.
				//if(document.forms[0].calling_mode.value=='OP' && document.forms[0].refID.value!='N' && from_page ==""){	
				if(document.forms[0].LocGlbChk.value=='Y'){

					if(document.forms[0].GlobalAllowed.value=='Y'){
						if(parseInt(document.forms[0].maxGlobal.value) >0 ){
							if(parseInt(document.forms[0].totGlobal.value) < parseInt(document.forms[0].maxGlobal.value)){
								callurl=callurl+"&Global=Y";
								retVal = await window.showModalDialog(callurl,arguments,features);
								
								if(retVal == 'abort') ;
								else{
									if(parent.parent.parent.tempStorageFrame && parent.parent.parent.tempStorageFrame.tempStorageForm){
										parent.parent.parent.tempStorageFrame.tempStorageForm.rule_appl_yn.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.linking_code.value ="";
									}
									setTimeout('dummmmmmyyy()',1000);
									aaa_results2(retVal)
								}
							}else{
								alert(getMessage('REF_GLOBAL_OVER','OA'));								
							}
						}else{
							alert(getMessage('REF_GLOBAL_NOT_SCHEDULE','OA'));
						}
					}else{
						alert(getMessage('REF_GLOBAL_NOT_USER','OA'));
					}
				}else{		
					callurl=callurl+"&Global=N";
					retVal = await window.showModalDialog(callurl,arguments,features);

					if(retVal == 'abort') ;
					else{
						setTimeout('dummmmmmyyy()',1000);
						aaa_results2(retVal)
					}
				}


	}
	


function callBookAppointmentDetails_results2(pVal)
{
		var maxForced=document.forms[0].maxForced.value;
		var totForced=document.forms[0].totForced.value;
		var from_date=document.forms[0].old_date.value;
		var sys_date=document.forms[0].sys_date.value;
		var value1=document.forms[0].clinic_code.value;
		var value2=document.forms[0].clinic_name.value;
		var value3=document.forms[0].pract_id.value;
		var value4=document.forms[0].pract_name.value;
		var value5=document.forms[0].appt_date.value;
		var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
		var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
		var value8=document.forms[0].over_booked.value;
		var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
		var value10=document.forms[0].patient_id.value;
		var value11=document.forms[0].elements[u1].value;
		var value12=document.forms[0].clinic_code1.value;
		var value13=document.forms[0].pract_id1.value;
		var value14=document.forms[0].clinic_code3.value;
		var value15=document.forms[0].pract_id3.value;
		var value16=document.forms[0].reason_for_revise.value;
		var value17=document.forms[0].ref_no.value;
		var value20= document.forms[0].old_from_time.value;
		var value21= document.forms[0].old_to_time.value;
		var end_to_time=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
		if(document.forms[0].P_O_TIME_TAB_TYPE.value!='2'){
			if(pVal=='F' || pVal=='NF'){
				if(pVal=='F'){
					callBookAppointmentDetailsDum_results2('F');
				}else{
					callBookAppointmentDetailsDum_results2('N');
				}			
			}else{
				if(document.forms[0].ForcedAllowed.value=='Y'){
					if(document.forms[0].refID.value=='N'){
						if(parseInt(maxForced)>0 && (parseInt(totForced)<parseInt(maxForced))){
								if(document.forms[0].calling_mode.value=="") {
								if(Date.parse(from_date) == Date.parse(sys_date) )
							{
									if(document.forms[0].LocGlbChk.value=='Y' || end_to_time == "23:59"){
										callBookAppointmentDetailsDum_results2('N');
									}else{
										if(window.confirm(getMessage('CONFIRM_FORCED_BOOKING','OA'))){
											callBookAppointment_results2('F');
										}else{
											callBookAppointmentDetailsDum_results2('N');
										}
									}
							}else{
							if(end_to_time != "23:59"){
							if(window.confirm(getMessage('FORCED_BOOK_FUTURE_DATE','OA')))
							{
							}else
							{
								callBookAppointmentDetailsDum_results2('N');
							}}else
							{
								callBookAppointmentDetailsDum_results2('N');
							}
					}
							
						} else {
						callBookAppointmentDetailsDum_results2('N');
						}
						}else{
							callBookAppointmentDetailsDum_results2('N');
						}
					}else{
						callBookAppointmentDetailsDum_results2('N');
					}
				}else{
					callBookAppointmentDetailsDum_results2('N');
				}
			}
		}else{	
			if(pVal=='F' || pVal=='NF'){
				if(pVal=='F'){
					callBookAppointmentDetailsDum_results2('F');
				}else{
					callBookAppointmentDetailsDum_results2('N');
				}			
			}else{
				if(pVal=='M'){
					if(document.forms[0].ForcedAllowed.value=='Y'){
						if(document.forms[0].refID.value=='N'){
							if(parseInt(maxForced)>0 && (parseInt(totForced)<parseInt(maxForced))){
									if(document.forms[0].calling_mode.value=="") {
									if(Date.parse(from_date) == Date.parse(sys_date) )
							{
										if(document.forms[0].LocGlbChk.value=='Y' || end_to_time == "23:59"){
											callBookAppointmentDetailsDum_results2('N');
										}else{
											if(window.confirm(getMessage('CONFIRM_FORCED_BOOKING','OA'))){
												callBookAppointment_results2('F');
											}else{
												callBookAppointmentDetailsDum_results2('N');
											}
										}
							}else
							{
								if(window.confirm(getMessage('FORCED_BOOK_FUTURE_DATE','OA')))
							{
							}else
							{
								callBookAppointmentDetailsDum_results2('N');
							}
					}
							
							} else 
							{
								callBookAppointmentDetailsDum_results2('N');
							}
							}else{
								callBookAppointmentDetailsDum_results2('N');
							}
						}else{
							callBookAppointmentDetailsDum_results2('N');
						}
					}else{
						callBookAppointmentDetailsDum_results2('N');
					}
				}else{
					callBookAppointmentDetailsDum_results2('N');
				}
			}			
		}
	}


async function callBookAppointmentDetailsDum_results2(pVal)
{

				var value1=document.forms[0].clinic_code.value;
				var value2=document.forms[0].clinic_name.value;
				var value3=document.forms[0].pract_id.value;
				var value4=document.forms[0].pract_name.value;
				var value5=document.forms[0].appt_date.value;
				var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
				var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
				var value8=document.forms[0].over_booked.value;
				var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
				var value10=document.forms[0].patient_id.value;
				var value11=document.forms[0].elements[u11].value;
				var value12=document.forms[0].clinic_code1.value;
				var value13=document.forms[0].pract_id1.value;
				var value14=document.forms[0].clinic_code3.value;
				var value15=document.forms[0].pract_id3.value;
				var value16=document.forms[0].reason_for_revise.value;
				var value17=document.forms[0].ref_no.value;
				var value20= document.forms[0].old_from_time.value;
				var value21= document.forms[0].old_to_time.value;
				old_date=document.forms[0].old_date.value;
				var book_appt_yn=document.forms[0].book_appt_yn.value;
				var book_appt_wo_pid_yn=document.forms[0].book_appt_wo_pid_yn.value;
				var obook_appt_yn=document.forms[0].obook_appt_yn.value;
				var book_appt_across_catg_yn=document.forms[0].book_appt_across_catg_yn.value;
				var tfr_appt_yn=document.forms[0].tfr_appt_yn.value;
				var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
				var canc_appt_yn=document.forms[0].canc_appt_yn.value;
				var alcn_criteria=document.forms[0].alcn_criteria.value;
				var pre_pat_alcn_catg_code=document.forms[0].pre_pat_alcn_catg_code.value;
				var mode_find="";

				var res_type=document.forms[0].res_type2.value;
				var clinic_type=document.forms[0].clinic_type2.value;
				 var calling_mode=document.forms[0].calling_mode.value;	
				if( value16.length > 0 && value17 != null ) value11=value17;
				var retVal = 	new String();
				var dialogHeight= "32" ;
				var dialogWidth	= "50" ;
				var dialogTop = "190" ;
				var center = "1" ;
				var Forced=pVal;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				retVal = await window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+value11+"&i_clinic_code="+value1+"&i_practitioner_id="+value3+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&value13="+value16+"&over_booked="+value8+"&i_time_table_type="+value9+"&old_from_time="+document.forms[0].old_from_time.value+"&old_to_time="+document.forms[0].old_to_time.value+"&old_date="+old_date+"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&Forced="+Forced+"&res_type="+res_type+"&calling_mode="+calling_mode+"&clinic_type="+clinic_type,arguments,features);
				var cc=retVal;
				if(retVal == 'close')
				retVal="|";
				if(retVal == 'closed') retVal="|";

				if(retVal == '|') ;
				else{
				mode_find="dummy";
				setTimeout("aaa_results2('"+mode_find+"');",1000);
				}
				if( cc == 'closed'){
				mode_find="dummy";
				setTimeout('aaa_results2()',1000);
				}
	}

function aaa_results2(mode_find)
{
	var value1=document.forms[0].clinic_code.value;
	var value2=document.forms[0].clinic_name.value;
	var value3=document.forms[0].pract_id.value;
	var value4=document.forms[0].pract_name.value;
	var value5=document.forms[0].appt_date.value;
	var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
	var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
	var value8=document.forms[0].over_booked.value;
	var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
	var value10=document.forms[0].patient_id.value;
	var value11=document.forms[0].elements[u1].value;
	var value12=document.forms[0].clinic_code1.value;
	var value13=document.forms[0].pract_id1.value;
	var value14=document.forms[0].clinic_code3.value;
	var value15=document.forms[0].pract_id3.value;
	var value16=document.forms[0].reason_for_revise.value;
	var value17=document.forms[0].ref_no.value;
	var value20= document.forms[0].old_from_time.value;
	var value21= document.forms[0].old_to_time.value;
	var callingMode =document.forms[0].callingMode.value;
	var install_yn_val=document.forms[0].install_yn_val.value;


		if(callingMode =="" || callingMode =="CA" )
		{
	
	var ca_mode=document.forms[0].ca_mode.value;
	var ca_patient_id=document.forms[0].ca_patient_id.value;
	value16=document.forms[0].reason_for_revise.value;
	value17=document.forms[0].ref_no.value;
	var old_clinic=document.forms[0].old_clinic.value;
	var old_practitioner=document.forms[0].old_practitioner.value;
	var date1=document.forms[0].date1.value;
	var date2=document.forms[0].date2.value;

	var res_type2=document.forms[0].res_type2.value;
	var clinic_type2=document.forms[0].clinic_type2.value;
	var res_type1=document.forms[0].res_type1.value;
	var clinic_type1=document.forms[0].clinic_type1.value;
	var res_type3=document.forms[0].res_type3.value;
	var clinic_type3=document.forms[0].clinic_type3.value;
	var or_catalogue_code=document.forms[0].or_catalogue_code.value;
	var oper_stn_id =document.forms[0].oper_stn_id.value;

	var old_date=document.forms[0].old_date.value;
	var alcn_criteria =document.forms[0].alcn_criteria.value;
	var visit_limit_rule=document.forms[0].visit_limit_rule.value;
	var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
	var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
	
	var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
	var visit_flag_OP= document.forms[0].visit_flag_OP.value;

	var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value;
var from_facility_id= document.forms[0].from_facility_id.value;
				var from_encounter_id= document.forms[0].from_encounter_id.value;
				var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;

var min_ela_per_resc_noshow_in_day	= document.forms[0].min_ela_per_resc_noshow_in_day.value;
var noshow_ctrl_by_splty_or_clinic	= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
var no_of_noshow_appts_for_alert	= document.forms[0].no_of_noshow_appts_for_alert.value;
var per_chk_for_no_show_alert		= document.forms[0].per_chk_for_no_show_alert.value;
var rd_appt_yn		= document.forms[0].rd_appt_yn.value;

	var u="clinic_code2="+value1+"&practitioner_id2="+value3+"&clinic_code1="+value12+"&practitioner_id1="+value13+"&clinic_code3="+value14+"&practitioner_id3="+value15+"&Date1="+value5+"&Date="+date1+"&Date2="+date2+"&value12="+value17+"&value13="+value16+"&old_clinic="+old_clinic+"&old_practitioner="+old_practitioner+"&Param=second&old_from_time="+document.forms[0].old_from_time.value+"&old_to_time="+document.forms[0].old_to_time.value+"&old_date="+old_date+"&pre_pat_alcn_catg_code="+document.forms[0].pre_pat_alcn_catg_code.value+"&mode_find="+mode_find+"&ca_patient_id="+ca_patient_id+"&ca_mode="+ca_mode+"&res_type1="+res_type1+"&clinic_type1="+clinic_type1+"&res_type2="+res_type2+"&clinic_type2="+clinic_type2+"&res_type3="+res_type3+"&clinic_type3="+clinic_type3+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&alcn_criteria="+alcn_criteria+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&callingMode="+callingMode+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&rd_appt_yn="+rd_appt_yn;
	
	var url="../../eOA/jsp/MultiPract3Vw.jsp?"+u;
	parent.parent.parent.frames[1].location.href=url;
	}else if (parent.parent.parent.frames[0].document.forms[0].from_OR.value =="Y" && document.forms[0].ca_patient_id.value !="" && callingMode=="OR")
		{
		parent.parent.parent.frames[1].location.href='../../eOR/jsp/PendingOrdersSchedule.jsp';
		}else if(parent.parent.frames[0].document.forms[0].from_OR.value =="Y" && callingMode=="OP" )
		{
			parent.frames[1].location.href='../../eCommon/html/blank.html';
			parent.parent.frames[0].location.href='../../eOA/jsp/DisplayPendingReferraltab.jsp?install_yn_val='+install_yn_val;
			parent.parent.frames[1].location.href='../../eMP/jsp/ReferralSearchFrameset.jsp?function_id=OA_PENDING_REFERRAL_BOOKING';
		}else{
		if(mode_find){
			parent.window.returnValue=mode_find;
		}
		parent.window.close();
	}
}



function visiblelity_results2()
{
	setTimeout('cc_results2()',0);
}

function cc_results2()
{
	if(document.forms[0].reason_for_revise.value.length == 0 || document.forms[0].reason_for_revise.value =="undefined" ){}
	else{
	
	parent.parent.frames[0].document.forms[0].reason_for_revise.value=document.forms[0].reason_for_revise.value;
	parent.parent.frames[0].document.getElementById('ss').style.visibility="visible";
	parent.parent.frames[0].document.forms[0].decide.value='two';
	}
}	

async function callBookAppointmentDetails2_results2()
{
		var value1=document.forms[0].clinic_code.value;
		var value2=document.forms[0].clinic_name.value;
		var value3=document.forms[0].pract_id.value;
		var value4=document.forms[0].pract_name.value;
		var value5=document.forms[0].appt_date.value;
		var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
		var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
		var value8=document.forms[0].over_booked.value;
		var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
		var value10=document.forms[0].patient_id.value;
		var value11=document.forms[0].elements[u1].value;
		var value12=document.forms[0].clinic_code1.value;
		var value13=document.forms[0].pract_id1.value;
		var value14=document.forms[0].clinic_code3.value;
		var value15=document.forms[0].pract_id3.value;
		var value16=document.forms[0].reason_for_revise.value;
		var value17=document.forms[0].ref_no.value;
		var value20= document.forms[0].old_from_time.value;
		var value21= document.forms[0].old_to_time.value;
	if( value16.length > 0 && value17 != null ) value11=value17;
				var retVal = 	new String();
				var dialogHeight= "32" ;
				var dialogWidth	= "50" ;
				var dialogTop = "190" ;
				var center = "1" ;
				var status="no";
				var  old_date=document.forms[0].old_date.value;
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				var res_type=document.forms[0].res_type2.value;
				var clinic_type=document.forms[0].clinic_type2.value;
				var calling_mode=document.forms[0].calling_mode.value;
				var call="../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+value11+"&i_clinic_code="+value1+"&i_practitioner_id="+value3+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&value13="+value12+"&over_booked="+value8+"&i_time_table_type="+value9+"&flag=Visit_Reg&old_date="+old_date+"&res_type="+res_type+"&clinic_type="+clinic_type+"&calling_mode="+calling_mode;

				
				retVal = await window.showModalDialog(call ,arguments,features);
				var cc=retVal;
				if(retVal == 'close')
				retVal="|";
				if(retVal == 'closed') retVal="|";
  
				if(retVal == '|') ;
				else{
					setTimeout('aaa_results2()',1000);
					}
				if( cc == 'closed')
				setTimeout('aaa_results2()',1000);
				
}
function show_Reference_details_results2(appt_no2,fac_id2)
{
		var dialogHeight= "23" ;
		var dialogWidth	= "54" ;
		var dialogTop = "190" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		window.showModalDialog("../../eOA/jsp/SecApptReferenceFrame.jsp?appt_no2="+appt_no2+"&fac_id2="+fac_id2,arguments,features);
}

/*Script functions for Mp3DisplayResults3.jsp*/

async function callBookAppointment_results3(x)
{

	var value1=document.forms[0].clinic_code.value;
	var value2=document.forms[0].clinic_name.value;
	var value3=document.forms[0].pract_id.value;
	var value4=document.forms[0].pract_name.value;
	var value5=document.forms[0].appt_date.value;
	var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
	var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
	var value8=document.forms[0].over_booked.value;
	var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
	var value10=document.forms[0].patient_id.value;
	var value11=document.forms[0].elements[u1].value;
	var value12=document.forms[0].clinic_code1.value;
	var value13=document.forms[0].pract_id1.value;
	var value14=document.forms[0].clinic_code2.value;
	var value15=document.forms[0].pract_id2.value;
	var value16=document.forms[0].reason_for_revise.value;
	var value17=document.forms[0].ref_no.value;
	var value20= document.forms[0].old_from_time.value;
	var value21= document.forms[0].old_to_time.value;
	var Forced='N';
	if(x=='F'){
		Forced='Y';
	}
	old_date=document.forms[0].old_date.value;
	var book_appt_yn=document.forms[0].book_appt_yn.value;
	var book_appt_wo_pid_yn=document.forms[0].book_appt_wo_pid_yn.value;
	var obook_appt_yn=document.forms[0].obook_appt_yn.value;
	var book_appt_across_catg_yn=document.forms[0].book_appt_across_catg_yn.value;
	var tfr_appt_yn=document.forms[0].tfr_appt_yn.value;
	var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
	var canc_appt_yn=document.forms[0].canc_appt_yn.value;
	var alcn_criteria=document.forms[0].alcn_criteria.value;
	var ca_patient_id=document.forms[0].ca_patient_id.value;
	var order_id=document.forms[0].order_id.value;
	var order_line_num=document.forms[0].order_line_num.value;
	var order_catalog_code=document.forms[0].order_catalog_code.value;
	var retVal = 	new String();
	var dialogHeight= "42.5" ;
	var dialogTop = "83" ;
	var dialogWidth	= "65" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
				
	var res_type=document.forms[0].res_type3.value;
	var clinic_type=document.forms[0].clinic_type3.value;
	var or_catalogue_code=document.forms[0].or_catalogue_code.value;
	var oper_stn_id	=document.forms[0].oper_stn_id.value;
	var visit_limit_rule=document.forms[0].visit_limit_rule.value;
	var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;	
	var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
	var req_id= document.forms[0].req_id.value;
		var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
		var visit_flag_OP= document.forms[0].visit_flag_OP.value;
		var from_page= document.forms[0].from_page.value;
		var noshow_ctrl_by_splty_or_clinic= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
				var min_ela_per_resc_noshow_in_day= document.forms[0].min_ela_per_resc_noshow_in_day.value;
				var from_facility_id= document.forms[0].from_facility_id.value;
				var from_encounter_id= document.forms[0].from_encounter_id.value;
				var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;
				
var capture_fin_dtls_yn		= document.forms[0].capture_fin_dtls_yn.value;
var no_of_noshow_appts_for_alert= document.forms[0].no_of_noshow_appts_for_alert.value;	
var per_chk_for_no_show_alert	= document.forms[0].per_chk_for_no_show_alert.value;
var rd_appt_yn	= document.forms[0].rd_appt_yn.value;

		var rule_appl_yn			= "";
		var patient_id_temp			= "";
		var name_prefix_temp		= "";
		var first_name_temp			= "";
		var second_name_temp		= "";
		var third_name_temp			= "";
		var family_name_temp		= "";
		var name_suffix_temp         		= "";
		var name_prefix_oth_lang_temp       = "";
		var first_name_oth_lang_temp       	= "";
		var second_name_oth_lang_temp       = "";
		var third_name_oth_lang_temp        = "";
		var family_name_oth_lang_temp       = "";
		var name_suffix_oth_lang_temp       = "";
		var gender_temp				= "";
		var contact_no_temp			= "";
		var nationality_code_temp	= "";
		var language_code_temp		= "";
		var term_set_id				= "";
		var linking_code			= "";	

		if(parent.parent.parent.tempStorageFrame && parent.parent.parent.tempStorageFrame.tempStorageForm){
			rule_appl_yn			= parent.parent.parent.tempStorageFrame.tempStorageForm.rule_appl_yn.value;
			patient_id_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value;
			name_prefix_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value;
			first_name_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value;
			second_name_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value;
			third_name_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value;
			family_name_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value;
			name_suffix_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_temp.value;
			
			name_prefix_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_oth_lang_temp.value;
			first_name_oth_lang_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_oth_lang_temp.value;
			second_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_oth_lang_temp.value;
			third_name_oth_lang_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_oth_lang_temp.value;
			family_name_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_oth_lang_temp.value;
			name_suffix_oth_lang_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_oth_lang_temp.value;
			
			
			
			gender_temp				= parent.parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value;
			contact_no_temp			= parent.parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value;
			nationality_code_temp	= parent.parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value;
			language_code_temp		= parent.parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value;
			term_set_id				= parent.parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value;
			linking_code			= parent.parent.parent.tempStorageFrame.tempStorageForm.linking_code.value;
		}
	var callurl="../../eOA/jsp/BookAppointment.jsp?i_clinic_code="+value1+"&i_clinic_name="+escape(value2)+"&i_practitioner_id="+value3+"&i_practitioner_name="+escape(value4)+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&i_over_booked="+value8+"&i_time_table_type="+value9+"&i_patient_id="+value10+"&book_appt_across_catg_yn="+book_appt_across_catg_yn+"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&ca_patient_id="+ca_patient_id+"&alcn_criteria="+alcn_criteria+"&Forced="+Forced+"&res_type="+res_type+"&clinic_type="+clinic_type+"&or_catalogue_code="+or_catalogue_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code+"&oper_stn_id="+oper_stn_id+"&"+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&from_page1="+from_page+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&rule_appl_yn="+rule_appl_yn+"&patient_id_temp="+patient_id_temp+"&name_prefix_temp="+escape(name_prefix_temp)+"&first_name_temp="+escape(first_name_temp)+"&second_name_temp="+escape(second_name_temp)+"&third_name_temp="+escape(third_name_temp)+"&family_name_temp="+escape(family_name_temp)+"&name_suffix_temp="+escape(name_suffix_temp)+"&name_prefix_oth_lang_temp="+escape(name_prefix_oth_lang_temp)+"&first_name_oth_lang_temp="+escape(first_name_oth_lang_temp)+"&second_name_oth_lang_temp="+escape(second_name_oth_lang_temp)+"&third_name_oth_lang_temp="+escape(third_name_oth_lang_temp)+"&family_name_oth_lang_temp="+escape(family_name_oth_lang_temp)+"&name_suffix_oth_lang_temp="+escape(name_suffix_oth_lang_temp)+"&gender_temp="+gender_temp+"&contact_no_temp="+contact_no_temp+"&nationality_code_temp="+nationality_code_temp+"&language_code_temp="+language_code_temp+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn;
				
				// calling page check is opened as global booking can be done from any fucntion.
				//if(document.forms[0].calling_mode.value=='OP' && document.forms[0].refID.value!='N' && from_page ==""){	
				if(document.forms[0].LocGlbChk.value=='Y'){

					if(document.forms[0].GlobalAllowed.value=='Y'){
						if(parseInt(document.forms[0].maxGlobal.value) >0 ){
							if(parseInt(document.forms[0].totGlobal.value) < parseInt(document.forms[0].maxGlobal.value)){
								callurl=callurl+"&Global=Y";
								retVal = await window.showModalDialog(callurl,arguments,features);
							
								if(retVal == 'abort') ;
								else{
									if(parent.parent.parent.tempStorageFrame && parent.parent.parent.tempStorageFrame.tempStorageForm){
										parent.parent.parent.tempStorageFrame.tempStorageForm.rule_appl_yn.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_oth_lang_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_oth_lang_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_oth_lang_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_oth_lang_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_oth_lang_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_oth_lang_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value ="";
										parent.parent.parent.tempStorageFrame.tempStorageForm.linking_code.value ="";
									}
									setTimeout('dummmmmmyyy()',1000);
									aaa_results3(retVal)
								}
							}else{
								alert(getMessage('REF_GLOBAL_OVER','OA'));								
							}
						}else{
							alert(getMessage('REF_GLOBAL_NOT_SCHEDULE','OA'));
						}
					}else{
						alert(getMessage('REF_GLOBAL_NOT_USER','OA'));
					}
				}else{		
					callurl=callurl+"&Global=N";
					retVal = await window.showModalDialog(callurl,arguments,features);

					if(retVal == 'abort') ;
					else{
						if(parent.parent.parent.tempStorageFrame && parent.parent.parent.tempStorageFrame.tempStorageForm){
							parent.parent.parent.tempStorageFrame.tempStorageForm.rule_appl_yn.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value ="";						
							parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.name_prefix_oth_lang_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.first_name_oth_lang_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.second_name_oth_lang_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.third_name_oth_lang_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.family_name_oth_lang_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.name_suffix_oth_lang_temp.value ="";		
							parent.parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value ="";
							parent.parent.parent.tempStorageFrame.tempStorageForm.linking_code.value ="";
						}
						setTimeout('dummmmmmyyy()',1000);
						aaa_results3(retVal)
					}
				}
	}

function callBookAppointmentDetails_results3(pVal)
{
		var value1=document.forms[0].clinic_code.value;
		var value2=document.forms[0].clinic_name.value;
		var value3=document.forms[0].pract_id.value;
		var value4=document.forms[0].pract_name.value;
		var value5=document.forms[0].appt_date.value;
		var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
		var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
		var value8=document.forms[0].over_booked.value;
		var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
		var value10=document.forms[0].patient_id.value;
		var value11=document.forms[0].elements[u1].value;
		var value12=document.forms[0].clinic_code1.value;
		var value13=document.forms[0].pract_id1.value;
		var value14=document.forms[0].clinic_code2.value;
		var value15=document.forms[0].pract_id2.value;
		var value16=document.forms[0].reason_for_revise.value;
		var value17=document.forms[0].ref_no.value;
		var value20= document.forms[0].old_from_time.value;
		var value21= document.forms[0].old_to_time.value;
		var maxForced=document.forms[0].maxForced.value;
		var totForced=document.forms[0].totForced.value;
		var from_date=document.forms[0].old_date.value;
		var sys_date=document.forms[0].sys_date.value;
		var end_to_time=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
		if(document.forms[0].P_O_TIME_TAB_TYPE.value!='2'){
			if(pVal=='F' || pVal=='NF'){
				if(pVal=='F'){
					callBookAppointmentDetailsDum_results3('F');
				}else{
					callBookAppointmentDetailsDum_results3('N');
				}			
			}else{
				if(document.forms[0].ForcedAllowed.value=='Y'){
					if(document.forms[0].refID.value=='N'){
						if(parseInt(maxForced)>0 && (parseInt(totForced)<parseInt(maxForced))){
								if(document.forms[0].calling_mode.value=="") {
								if(Date.parse(from_date) == Date.parse(sys_date) )
							{
									if(document.forms[0].LocGlbChk.value=='Y' || end_to_time == "23:59"){
										callBookAppointmentDetailsDum_results3('N');
									}else{
										if(window.confirm(getMessage('CONFIRM_FORCED_BOOKING','OA'))){
											callBookAppointment_results3('F');
										}else{
											callBookAppointmentDetailsDum_results3('N');
										}
									}
							}else
							{
							if(window.confirm(getMessage('FORCED_BOOK_FUTURE_DATE','OA')))
							{
							}else
							{
								callBookAppointmentDetailsDum_results3('N');
							}
						}
							
						} else
						{
							callBookAppointmentDetailsDum_results3('N');
						}
						}else{
							callBookAppointmentDetailsDum_results3('N');
						}
					}else{
						callBookAppointmentDetailsDum_results3('N');
					}
				}else{
					callBookAppointmentDetailsDum_results3('N');
				}
			}
		}else{	
			if(pVal=='F' || pVal=='NF'){
				if(pVal=='F'){
					callBookAppointmentDetailsDum_results3('F');
				}else{
					callBookAppointmentDetailsDum_results3('N');
				}			
			}else{
				if(pVal=='M'){
					if(document.forms[0].ForcedAllowed.value=='Y'){
						if(document.forms[0].refID.value=='N'){
							if(parseInt(maxForced)>0 && (parseInt(totForced)<parseInt(maxForced))){
								if(document.forms[0].calling_mode.value=="") {
									if(Date.parse(from_date) == Date.parse(sys_date) )
							{
										if(document.forms[0].LocGlbChk.value=='Y' || end_to_time == "23:59"){
											callBookAppointmentDetailsDum_results3('N');
										}else{
											if(window.confirm(getMessage('CONFIRM_FORCED_BOOKING','OA'))){
												callBookAppointment_results3('F');
											}else{
												callBookAppointmentDetailsDum_results3('N');
											}
										}
							}else
							{
							if(window.confirm(getMessage('FORCED_BOOK_FUTURE_DATE','OA')))
							{
							}else
							{
								callBookAppointmentDetailsDum_results3('N');
							}
					}
							
							} else 
							{
								callBookAppointmentDetailsDum_results3('N');
							}
							}else{
								callBookAppointmentDetailsDum_results3('N');
							}
						}else{
							callBookAppointmentDetailsDum_results3('N');
						}
					}else{
						callBookAppointmentDetailsDum_results3('N');
					}
				}else{
					callBookAppointmentDetailsDum_results3('N');
				}
			}			
		}
	}

async function callBookAppointmentDetailsDum_results3(pVal)
{
				var value1=document.forms[0].clinic_code.value;
				var value2=document.forms[0].clinic_name.value;
				var value3=document.forms[0].pract_id.value;
				var value4=document.forms[0].pract_name.value;
				var value5=document.forms[0].appt_date.value;
				var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
				var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
				var value8=document.forms[0].over_booked.value;
				var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
				var value10=document.forms[0].patient_id.value;
				var value11=document.forms[0].elements[u11].value;
				var value12=document.forms[0].clinic_code1.value;
				var value13=document.forms[0].pract_id1.value;
				var value14=document.forms[0].clinic_code2.value;
				var value15=document.forms[0].pract_id2.value;
				var value16=document.forms[0].reason_for_revise.value;
				var value17=document.forms[0].ref_no.value;
				var value20= document.forms[0].old_from_time.value;
				var value21= document.forms[0].old_to_time.value;
				old_date=document.forms[0].old_date.value;
				var book_appt_yn=document.forms[0].book_appt_yn.value;
				var book_appt_wo_pid_yn=document.forms[0].book_appt_wo_pid_yn.value;
				var obook_appt_yn=document.forms[0].obook_appt_yn.value;
				var book_appt_across_catg_yn=document.forms[0].book_appt_across_catg_yn.value;
				var tfr_appt_yn=document.forms[0].tfr_appt_yn.value;
				var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
				var canc_appt_yn=document.forms[0].canc_appt_yn.value;
				var alcn_criteria=document.forms[0].alcn_criteria.value;
				var pre_pat_alcn_catg_code=document.forms[0].pre_pat_alcn_catg_code.value;
				var mode_find="";
				var Forced=pVal;
				var res_type=document.forms[0].res_type3.value;
				var clinic_type=document.forms[0].clinic_type3.value;
				var calling_mode=document.forms[0].calling_mode.value;
				if( value16.length > 0 && value17 != null ) value11=value17;
				var retVal = 	new String();
				var dialogHeight= "32" ;
				var dialogWidth	= "50" ;
				var dialogTop = "190" ;
				var center = "1" ;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				retVal = await window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+value11+"&i_clinic_code="+value1+"&i_practitioner_id="+value3+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&value13="+value16+"&over_booked="+value8+"&i_time_table_type="+value9+"&old_from_time="+document.forms[0].old_from_time.value+"&old_to_time="+document.forms[0].old_to_time.value+"&old_date="+old_date +"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&Forced="+Forced+"&res_type="+res_type+"&calling_mode="+calling_mode+"&clinic_type="+clinic_type,arguments,features);
				var cc=retVal;
				if(retVal == 'close')
				retVal="|";
				if(retVal == 'closed') retVal="|";

				if(retVal == '|') ;
				else{
				mode_find="dummy";
				setTimeout("aaa_results3('"+mode_find+"');",1000);
				}
				if( cc == 'closed'){
				mode_find="dummy";
				setTimeout('aaa_results3()',1000);
				}
}

async function callBookAppointmentDetails2_results3()
{

		var value1=document.forms[0].clinic_code.value;
		var value2=document.forms[0].clinic_name.value;
		var value3=document.forms[0].pract_id.value;
		var value4=document.forms[0].pract_name.value;
		var value5=document.forms[0].appt_date.value;
		var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
		var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
		var value8=document.forms[0].over_booked.value;
		var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
		var value10=document.forms[0].patient_id.value;
		var value11=document.forms[0].elements[u1].value;
		var value12=document.forms[0].clinic_code1.value;
		var value13=document.forms[0].pract_id1.value;
		var value14=document.forms[0].clinic_code2.value;
		var value15=document.forms[0].pract_id2.value;
		var value16=document.forms[0].reason_for_revise.value;
		var value17=document.forms[0].ref_no.value;
		var value20= document.forms[0].old_from_time.value;
		var value21= document.forms[0].old_to_time.value;
		if( value16.length > 0 && value17 != null ) value11=value17;
				var  old_date=document.forms[0].old_date.value;
				var retVal = 	new String();
				var dialogHeight= "32" ;
				var dialogWidth	= "50" ;
				var dialogTop = "190" ;
				var center = "1" ;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				var res_type=document.forms[0].res_type3.value;
				var clinic_type=document.forms[0].clinic_type3.value;
				var calling_mode=document.forms[0].calling_mode.value;
				var call="../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+value11+"&i_clinic_code="+value1+"&i_practitioner_id="+value3+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&value13="+value12+"&over_booked="+value8+"&i_time_table_type="+value9+"&flag=Visit_Reg&old_from_time="+document.forms[0].old_from_time.value+"&old_to_time="+document.forms[0].old_to_time.value+"&old_date="+old_date+"&res_type="+res_type+"&clinic_type="+clinic_type+"&calling_mode="+calling_mode;
				
				retVal = await window.showModalDialog(call ,arguments,features);
				var cc=retVal;
				if(retVal == 'close')
				retVal="|";
				if(retVal == 'closed') retVal="|";

				if(retVal == '|') ;
				else{
					setTimeout('aaa_results3()',1000);
					}
				if( cc == 'closed')
				setTimeout('aaa_results3()',1000);
				
}



function aaa_results3(mode_find)
{
		var value1=document.forms[0].clinic_code.value;
		var value2=document.forms[0].clinic_name.value;
		var value3=document.forms[0].pract_id.value;
		var value4=document.forms[0].pract_name.value;
		var value5=document.forms[0].appt_date.value;
		var value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
		var value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
		var value8=document.forms[0].over_booked.value;
		var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
		var value10=document.forms[0].patient_id.value;
		var value11=document.forms[0].elements[u1].value;
		var value12=document.forms[0].clinic_code1.value;
		var value13=document.forms[0].pract_id1.value;
		var value14=document.forms[0].clinic_code2.value;
		var value15=document.forms[0].pract_id2.value;
		var value16=document.forms[0].reason_for_revise.value;
		var value17=document.forms[0].ref_no.value;
		var value20= document.forms[0].old_from_time.value;
		var value21= document.forms[0].old_to_time.value;
		var callingMode = document.forms[0].callingMode.value;

		if(callingMode =="" || callingMode =="CA" )
		{
			value16=document.forms[0].reason_for_revise.value;
			value17=document.forms[0].ref_no.value;
			var old_clinic=document.forms[0].old_clinic.value;
			var old_practitioner=document.forms[0].old_practitioner.value;
			var date1=document.forms[0].date1.value;
			var date2=document.forms[0].date2.value;

			var old_date=document.forms[0].old_date.value;

			var res_type3=document.forms[0].res_type3.value;
			var clinic_type3=document.forms[0].clinic_type3.value;
			var res_type2=document.forms[0].res_type2.value;
			var clinic_type2=document.forms[0].clinic_type2.value;
			var res_type1=document.forms[0].res_type1.value;
			var clinic_type1=document.forms[0].clinic_type1.value;
			var or_catalogue_code=document.forms[0].or_catalogue_code.value;
			var oper_stn_id =document.forms[0].oper_stn_id.value;
			var alcn_criteria =document.forms[0].alcn_criteria.value;
			var visit_limit_rule=document.forms[0].visit_limit_rule.value;
			var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
			var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
var install_yn_val=document.forms[0].install_yn_val.value;
	var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
	var visit_flag_OP= document.forms[0].visit_flag_OP.value;

	var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value;
var from_facility_id= document.forms[0].from_facility_id.value;
				var from_encounter_id= document.forms[0].from_encounter_id.value;
				var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;

var min_ela_per_resc_noshow_in_day	= document.forms[0].min_ela_per_resc_noshow_in_day.value;
var noshow_ctrl_by_splty_or_clinic	= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
var no_of_noshow_appts_for_alert	= document.forms[0].no_of_noshow_appts_for_alert.value;
var per_chk_for_no_show_alert		= document.forms[0].per_chk_for_no_show_alert.value;
var rd_appt_yn		= document.forms[0].rd_appt_yn.value;

			var u="clinic_code3="+value1+"&practitioner_id3="+value3+"&clinic_code1="+value12+"&practitioner_id1="+value13+"&clinic_code2="+value14+"&practitioner_id2="+value15+"&Date2="+value5+"&Date="+date1+"&Date1="+date2+"&value12="+value17+"&value13="+value16+"&old_clinic="+old_clinic+"&old_practitioner="+old_practitioner+"&Param=third&old_from_time="+document.forms[0].old_from_time.value+"&old_to_time="+document.forms[0].old_to_time.value+"&old_date="+old_date+"&pre_pat_alcn_catg_code="+document.forms[0].pre_pat_alcn_catg_code.value+"&mode_find="+mode_find+"&res_type1="+res_type1+"&clinic_type1="+clinic_type1+"&res_type2="+res_type2+"&clinic_type2="+clinic_type2+"&res_type3="+res_type3+"&clinic_type3="+clinic_type3+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&alcn_criteria="+alcn_criteria+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&callingMode="+callingMode+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&rd_appt_yn="+rd_appt_yn;
		
			var url="../../eOA/jsp/MultiPract3Vw.jsp?"+u;
			parent.parent.parent.frames[1].location.href=url;
		}	else if (parent.parent.parent.frames[0].document.forms[0].from_OR.value =="Y" && document.forms[0].ca_patient_id.value !="")
		{
		parent.parent.parent.frames[1].location.href='../../eOR/jsp/PendingOrdersSchedule.jsp';
		}else{

		if(mode_find){
			parent.window.returnValue=mode_find;
		}
				parent.window.close();
			}
}
	

function visiblelity_results3()
{
	setTimeout('cc_results3()',0);
}

function cc_results3()
{
	if(document.forms[0].reason_for_revise.value.length == 0 || document.forms[0].reason_for_revise.value =="undefined" ){}
	else{
	parent.parent.frames[0].document.forms[0].ref_no.value=document.forms[0].ref_no.value;
	parent.parent.frames[0].document.forms[0].reason_for_revise.value=document.forms[0].reason_for_revise.value;
	parent.parent.frames[0].document.getElementById('ss').style.visibility="visible";
	parent.parent.frames[0].document.forms[0].decide.value='three';
	}
}

function show_Reference_details_results3(appt_no2,fac_id2)
{
		var dialogHeight= "23" ;
		var dialogWidth	= "54" ;
		var dialogTop = "190" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		window.showModalDialog("../../eOA/jsp/SecApptReferenceFrame.jsp?appt_no2="+appt_no2+"&fac_id2="+fac_id2,arguments,features);
}

function scrollheader()
{
	 var x = document.body.scrollTop;
 // var x1=document.getElementById('divTitleTable').style.posTop;
  if(x == 0){
   if(document.forms[0].P_O_MAX_PAT.value =="")
	  {
   document.getElementById('labeldiv_one').style.position='static';
  document.getElementById('labeldiv_one').style.posTop  = 0;
	  }else
	  {
   document.getElementById('labeldiv2').style.position='static';
   document.getElementById('labeldiv2').style.posTop  = 0;
//   document.getElementById('header').style.position='static';
 //  document.getElementById('header').style.posTop  = 0;
	  }
  }else
  {
	  	 
   if(document.forms[0].P_O_MAX_PAT.value =="")
	  {
	  document.getElementById('labeldiv_one').style.position = 'relative';
		document.getElementById('labeldiv_one').style.posTop  = x-2;
		}else
	  {
		document.getElementById('labeldiv2').style.position = 'relative';
		document.getElementById('labeldiv2').style.posTop  = x-2;
	//	document.getElementById('header').style.position = 'relative';
	//	document.getElementById('header').style.posTop  = x-2;
	  }
		
		
  }
}


function scrollTitle()
{
	
  var x = document.body.scrollTop;
  if(x == 0){
	 
	 if(document.forms[0].P_O_MAX_PAT.value !="")
	  {
 
   document.getElementById('head1').style.position='static';
   document.getElementById('head1').style.posTop  = 0;
   document.getElementById('head2').style.position='static';
   document.getElementById('head2').style.posTop  = 0;
   document.getElementById('head3').style.position='static';
   document.getElementById('head3').style.posTop  = 0;
   document.getElementById('head4').style.position='static';
   document.getElementById('head4').style.posTop  = 0;
   
   /*Below line added for this CRF ML-MMOH-CRF-0606*/
   document.getElementById('head12').style.position='static';
   document.getElementById('head12').style.posTop  = 0;   
   //End this CRF ML-MMOH-CRF-0606
   
	  }
  
  }else{

	   if(document.forms[0].P_O_MAX_PAT.value !="")
	  {

	document.getElementById('head1').style.position = 'relative';
	document.getElementById('head1').style.posTop  = x-20;
	document.getElementById('head2').style.position = 'relative';
	document.getElementById('head2').style.posTop  = x-20;
	document.getElementById('head3').style.position = 'relative';
	document.getElementById('head3').style.posTop  = x-20;
	document.getElementById('head4').style.position = 'relative';
	document.getElementById('head4').style.posTop  = x-20;
	
	 /*Below line added for this CRF ML-MMOH-CRF-0606*/
	 document.getElementById('head12').style.position = 'relative';
	 document.getElementById('head12').style.posTop  = x-20;	 
	 //End this CRF ML-MMOH-CRF-0606
	
	  }
	
  }

}


/**********Date*********/


function DateCheck_new1(sys,from)
{
		if(from.value!="")
		{
		document.forms[0].go.disabled=false;

		if(!validDateObj(from,"DMY",localeName))
		{
			from.value="";
			return ;
		}

		var from1=convertDate(from.value,"DMY",localeName,"en");

		if(sys!="" && from.value!="" )
		{
			if(isBefore(sys,from1,'DMY',localeName)==false)
				{
				alert(getMessage("SCH_DATE_NOT_GREAT_TODAY","OA"));
				from.value="";
				from.select();
				document.forms[0].go.disabled=true;
				return false;
			}
			else
			{
				if(document.forms[0].go)
					document.forms[0].go.disabled=false;

				PopDay(from);

				if(document.forms[0].go)
					document.forms[0].go.focus();

				return true;
			}
		}
}else
	{
		document.forms[0].go.disabled=false;
			PopDay(from);
			return true;
	}

}

function DateCheck_new2(sys,from)
{
		if(from.value!="")
		{
		document.forms[0].go.disabled=false;

		if(!validDateObj(from,"DMY",localeName))
		{
			from.value="";
			return ;
		}
		var from2=convertDate(from.value,"DMY",localeName,"en");
		if(sys!="" && from.value!="" )
		{
			if(isBefore(sys,from2,'DMY',localeName)==false)
				{
				alert(getMessage("SCH_DATE_NOT_GREAT_TODAY","OA"));
				from.value="";
				from.select();
				document.forms[0].goY.disabled=true;
				return false;
			}
			else
			{
				if(document.forms[0].goY)
					document.forms[0].goY.disabled=false;

				PopDay(from);
				
				if(document.forms[0].goY)
					document.forms[0].goY.focus();

				return true;
			}
		}
}else
	{
		document.forms[0].goY.disabled=false;
			PopDay(from);
			return true;
	}

}

function DateCheck_new3(sys,from)
{
		if(from.value!="")
		{
		document.forms[0].go.disabled=false;

		if(!validDateObj(from,"DMY",localeName))
		{
			from.value="";
			return ;
		}
		var from3=convertDate(from.value,"DMY",localeName,"en");

		if(sys!="" && from.value!="" )
		{
			if(isBefore(sys,from3,'DMY',localeName)==false)
				{
				alert(getMessage("SCH_DATE_NOT_GREAT_TODAY","OA"));
				from.value="";
				from.select();
				document.forms[0].goX.disabled=true;
				return false;
			}
			else
			{
				if(document.forms[0].goX)
					document.forms[0].goX.disabled=false;

				PopDay(from);

				if(document.forms[0].goX)
					document.forms[0].goX.focus();
				return true;
			}
		}
}else
	{
		document.forms[0].goX.disabled=false;
			PopDay(from);
			return true;
	}

}

function GroupappointmentSelect(pVal,refno){	
      
	var latter=document.getElementById('results0').rows[u1].cells[2].innerText ;
	var old_practitioner=document.forms[0].old_practitioner.value;
	var appt_date="";
	if(document.forms[0].value_chk.value=="display1"){
		value1=document.forms[0].clinic_code.value;
		value2=document.forms[0].clinic_name.value;
		value3=document.forms[0].pract_id.value;
		value4=document.forms[0].pract_name.value;
		value5=document.forms[0].appt_date.value;
		appt_date=document.forms[0].appt_date.value;
	}else if(document.forms[0].value_chk.value=="display2"){
		value1=document.forms[0].clinic_code2.value;
		value2=document.forms[0].clinic_name.value;
		value3=document.forms[0].pract_id2.value;
		value4=document.forms[0].pract_name.value;
		value5=document.forms[0].date1.value;
		appt_date=document.forms[0].date1.value;
	}else if(document.forms[0].value_chk.value=="display3"){
		value1=document.forms[0].clinic_code3.value;
		value2=document.forms[0].clinic_name.value;
		value3=document.forms[0].pract_id3.value;
		value4=document.forms[0].pract_name.value;
		value5=document.forms[0].date2.value;
		appt_date=document.forms[0].date2.value;
	}	
	var old_clinic=document.forms[0].old_clinic.value;
	value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
	value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
	value8=document.forms[0].over_booked.value;
	value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
	value10=document.forms[0].patient_id.value;
	value11=document.forms[0].elements[u1].value;
	value12=document.forms[0].clinic_code2.value;
	value13=document.forms[0].pract_id2.value;	
	value14=document.forms[0].clinic_code3.value;
	value15=document.forms[0].pract_id3.value;	
	value16=document.forms[0].reason_for_revise.value;
	value17=document.forms[0].ref_no.value;	
	value20= document.forms[0].old_from_time.value;
	value21= document.forms[0].old_to_time.value;	
	var old_date=document.forms[0].old_date.value;
	if(old_date.length == 0) 
		document.forms[0].old_date.value=value5;
	old_clinic=document.forms[0].old_clinic.value;
	sys_date=document.forms[0].sys_date.value;
	sys_time=document.forms[0].sys_time.value;
	fromtimeharray=sys_time.split(":");
	from_time=value6.split(":");
	to_displayed_time=value7.split(":");

	if(to_displayed_time == "00,00")
	{
		to_displayed_time[0] = "23";
		to_displayed_time[1] = "59";
	}

	var fromhtm=new Date(1,1,1,fromtimeharray[0],fromtimeharray[1],0,0);
	var tohtm=new Date(1,1,1,from_time[0],from_time[1],0,0);
	var to_displayed=new Date(1,1,1,to_displayed_time[0],to_displayed_time[1],0,0);	
	if(!pVal) pVal='NO';
	if(old_clinic.length == 0 || old_clinic ==null || old_clinic== "undefined")
		old_clinic =value1;
	if(old_practitioner.length == 0 || old_practitioner ==null || old_practitioner== "undefined")
		old_practitioner = value3;
		var errorsThere = new Boolean(false); 
		
		if(DateCompare4(document.forms[0].appt_date ,document.forms[0].sys_date)){ 									
		if((Date.parse(fromhtm) >= Date.parse(to_displayed))){
				alert(getMessage("FR_TIME_CAN_NOT_SYS_TIME","OA"));
        }else{
	   if(confirm(getMessage("GROUP_APPT","OA"))){
		    Groupappointment(pVal,refno);
	    }else{
		     moveNext_results0(pVal,refno);		
	      }
	 }
  }else{
  if(confirm(getMessage("GROUP_APPT","OA"))){
		    Groupappointment(pVal,refno);
	    }else{
		    moveNext_results0(pVal,refno);		
	      }
  }
		
		
	    	 
	  /*if(confirm(getMessage("GROUP_APPT","OA"))){
		    Groupappointment(pVal,refno);
	    }else{
		    moveNext_results0(pVal,refno);		
	    } */
	
}

async function Groupappointment(pVal,refno){ 
	 
	var latter=document.getElementById('results0').rows[u1].cells[2].innerText ;
	var old_practitioner=document.forms[0].old_practitioner.value;
	var appt_date="";
	if(document.forms[0].value_chk.value=="display1"){
		value1=document.forms[0].clinic_code.value;
		value2=document.forms[0].clinic_name.value;
		value3=document.forms[0].pract_id.value;
		value4=document.forms[0].pract_name.value;
		value5=document.forms[0].appt_date.value;
		appt_date=document.forms[0].appt_date.value;
	}else if(document.forms[0].value_chk.value=="display2"){
		value1=document.forms[0].clinic_code2.value;
		value2=document.forms[0].clinic_name.value;
		value3=document.forms[0].pract_id2.value;
		value4=document.forms[0].pract_name.value;
		value5=document.forms[0].date1.value;
		appt_date=document.forms[0].date1.value;
	}else if(document.forms[0].value_chk.value=="display3"){
		value1=document.forms[0].clinic_code3.value;
		value2=document.forms[0].clinic_name.value;
		value3=document.forms[0].pract_id3.value;
		value4=document.forms[0].pract_name.value;
		value5=document.forms[0].date2.value;
		appt_date=document.forms[0].date2.value;
	}	
	var old_clinic=document.forms[0].old_clinic.value;
	value6= document.getElementById('results0').rows[u1+1].cells[u2].innerText;
	value7=document.getElementById('results0').rows[u1+1].cells[u2+1].innerText;
	value8=document.forms[0].over_booked.value;
	value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
	value10=document.forms[0].patient_id.value;
	value11=document.forms[0].elements[u1].value;
	value12=document.forms[0].clinic_code2.value;
	value13=document.forms[0].pract_id2.value;	
	value14=document.forms[0].clinic_code3.value;
	value15=document.forms[0].pract_id3.value;	
	value16=document.forms[0].reason_for_revise.value;
	value17=document.forms[0].ref_no.value;	
	value20= document.forms[0].old_from_time.value;
	value21= document.forms[0].old_to_time.value;	
	var old_date=document.forms[0].old_date.value;
	if(old_date.length == 0) 
		document.forms[0].old_date.value=value5;
	old_clinic=document.forms[0].old_clinic.value;
	sys_date=document.forms[0].sys_date.value;
	sys_time=document.forms[0].sys_time.value;
	var max_patients_per_slab=document.forms[0].max_patients_per_slab.value;
	var calling_mode=document.forms[0].calling_mode.value;
	
	//Start
	var res_type=document.forms[0].res_type1.value;
	var clinic_type=document.forms[0].clinic_type1.value;	
	//End	 	

   
	var retVal		=    new String();
	var dialogHeight= "20";	
	var dialogWidth = "55";
//	var dialogTop	= "50";
	var center		= "1";
	var status		= "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status ;
	var arguments   = "" ;
	var getUrl = "../../eOA/jsp/AddModifyGroupAppointment.jsp?i_clinic_code="+value1+"&i_clinic_name="+encodeURIComponent(value2)+"&i_practitioner_id="+value3+"&i_practitioner_name="+encodeURIComponent(value4)+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&i_time_table_type="+value9+"&i_patient_id="+value10+"&res_type="+res_type+"&clinic_type="+clinic_type+"&max_patients_per_slab="+max_patients_per_slab+"&calling_mode="+calling_mode;
	alert(getUrl);
	
	retVal = await window.showModalDialog(getUrl,arguments,features);  
	alert(retVal)
	if(retVal != null && retVal != ""){
			if(parent.window) parent.window.close();
			parent.parent.parent.frames[1].location.reload();
	}	
	
}/*Below line Added for this CRF  Bru-HIMS-CRF-165.1 [IN:035659]*/

function DateCompare4(from,to)
{ 	
	if(from.value!="" && to.value!="" )
		{
	
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
						
				return false;
			}
			else
				return true;
		}else
	{
			return true;
	}

}

//End this CRF  Bru-HIMS-CRF-165.1 [IN:035659]
