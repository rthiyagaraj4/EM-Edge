var patient_id;
function moveForward(){ 
	var u1=parent.frames[0].document.forms[0].gggg.value;
	var u2=parent.frames[0].document.forms[0].changed_date.value;
	/*Below line commented for below incident[35071]*/
	//var check=parent.parent.parent.frames[1].name;
	var decide=parent.frames[0].document.forms[0].decide.value; 
	var valid_date=parent.frames[0].document.forms[0].valid_date.value;
	var valid_date_greg=convertDate(valid_date,"DMY",localeName,"en");
	if(parent.frames[1].document.forms[0].ca_patient_id){
		patient_id = parent.frames[1].document.forms[0].ca_patient_id.value;
	}
	var retVal = 	new String();
	var dialogHeight= "11" ;
	var dialogTop = "100" ;
	var dialogWidth	= "13" ;
	var status = "no";
	var scroll="no";
	u2=valid_date_greg;
	if(document.forms[0].hddTracker.value =='OR' ){
		if(decide == "Query"){
			HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/DateValidation.jsp'><input type='hidden' name='flag' id='flag' value='right'><input type='hidden' name='date' id='date' value='"+u1+"'><input type='hidden' name='changed_date' id='changed_date' value='"+u2+"'><input type='hidden' name='validate' id='validate' value='Update'><input type='hidden' name='callingMode' id='callingMode' value='OR'><input type='hidden' name='FrmNo' id='FrmNo' value='1'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();
			setTimeout('ccc1()',500);
		}else if(decide != "Query"){
			HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/DateValidation.jsp'><input type='hidden' name='flag' id='flag' value='right'><input type='hidden' name='date' id='date' value='"+u1+"'><input type='hidden' name='changed_date' id='changed_date' value='"+u2+"'><input type='hidden' name='validate' id='validate' value='Query'><input type='hidden' name='callingMode' id='callingMode' value='OR'><input type='hidden' name='FrmNo' id='FrmNo' value='1'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();
			setTimeout('aaa1()',500);
		}
	}else if(document.forms[0].hddTracker.value =='CA'){
		if(decide == "Query"){			
				HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/DateValidation.jsp'><input type='hidden' name='flag' id='flag' value='right'><input type='hidden' name='date' id='date' value='"+u1+"'><input type='hidden' name='changed_date' id='changed_date' value='"+u2+"'><input type='hidden' name='validate' id='validate' value='Update'><input type='hidden' name='callingMode' id='callingMode' value='CA'><input type='hidden' name='FrmNo' id='FrmNo' value='1'></form></BODY></HTML>";
				parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.frames[2].document.form1.submit();
				setTimeout('ccc1()',500);
			}else if(decide != "Query"){
				HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/DateValidation.jsp'><input type='hidden' name='flag' id='flag' value='right'><input type='hidden' name='date' id='date' value='"+u1+"'><input type='hidden' name='changed_date' id='changed_date' value='"+u2+"'><input type='hidden' name='validate' id='validate' value='Query'><input type='hidden' name='callingMode' id='callingMode' value='CA'><input type='hidden' name='FrmNo' id='FrmNo' value='1'></form></BODY></HTML>";
				parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.frames[2].document.form1.submit();				
				setTimeout('aaa1()',500);
			}
	}else if(document.forms[0].hddTracker.value =='OP'){
		if(decide == "Query"){
			HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/DateValidation.jsp'><input type='hidden' name='flag' id='flag' value='right'><input type='hidden' name='date' id='date' value='"+u1+"'><input type='hidden' name='changed_date' id='changed_date' value='"+u2+"'><input type='hidden' name='validate' id='validate' value='Update'><input type='hidden' name='callingMode' id='callingMode' value='OP'><input type='hidden' name='FrmNo' id='FrmNo' value='1'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();
			setTimeout('ccc1()',500);
		}else if(decide != "Query"){
			HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/DateValidation.jsp'><input type='hidden' name='flag' id='flag' value='right'><input type='hidden' name='date' id='date' value='"+u1+"'><input type='hidden' name='changed_date' id='changed_date' value='"+u2+"'><input type='hidden' name='validate' id='validate' value='Query'><input type='hidden' name='callingMode' id='callingMode' value='OP'><input type='hidden' name='FrmNo' id='FrmNo' value='1'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();
			setTimeout('aaa1()',500);
		}
	}else if(document.forms[0].hddTracker.value =='OH'){
		if(decide == "Query"){
			HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/DateValidation.jsp'><input type='hidden' name='flag' id='flag' value='right'><input type='hidden' name='date' id='date' value='"+u1+"'><input type='hidden' name='changed_date' id='changed_date' value='"+u2+"'><input type='hidden' name='validate' id='validate' value='Update'><input type='hidden' name='callingMode' id='callingMode' value='OP'><input type='hidden' name='FrmNo' id='FrmNo' value='1'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();
			setTimeout('ccc1()',500);
		}else if(decide != "Query"){
			HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/DateValidation.jsp'><input type='hidden' name='flag' id='flag' value='right'><input type='hidden' name='date' id='date' value='"+u1+"'><input type='hidden' name='changed_date' id='changed_date' value='"+u2+"'><input type='hidden' name='validate' id='validate' value='Query'><input type='hidden' name='callingMode' id='callingMode' value='OP'><input type='hidden' name='FrmNo' id='FrmNo' value='1'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();
			setTimeout('aaa1()',500);
		}
	}else{		
		if(decide == "Query"){			
			HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/DateValidation.jsp'><input type='hidden' name='flag' id='flag' value='right'><input type='hidden' name='date' id='date' value='"+u1+"'><input type='hidden' name='changed_date' id='changed_date' value='"+u2+"'><input type='hidden' name='validate' id='validate' value='Update'><input type='hidden' name='callingMode' id='callingMode' value='OTH'></form></BODY></HTML>";
			parent.parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.parent.frames[2].document.form1.submit();
			setTimeout('ccc()',1000);
		}else if(decide != "Query"){
			HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/DateValidation.jsp'><input type='hidden' name='flag' id='flag' value='right'><input type='hidden' name='date' id='date' value='"+u1+"'><input type='hidden' name='changed_date' id='changed_date' value='"+u2+"'><input type='hidden' name='validate' id='validate' value='Query'><input type='hidden' name='callingMode' id='callingMode' value='OTH'></form></BODY></HTML>";
			//parent.parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			//parent.parent.parent.frames[2].document.form1.submit();
			/*Above Line commented and below line for 35071*/
			parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.frames[2].document.form1.submit();
			document.forms[0].go.disabled=true;
			setTimeout('aaa()',1000);
		}
	}
}

function moveBack()
{
	
		var u1=parent.frames[0].document.forms[0].gggg.value;
		var u2=parent.frames[0].document.forms[0].changed_date.value;
		var decide=parent.frames[0].document.forms[0].decide.value;
		if(decide == "Query")
		{
		HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/DateValidation.jsp'><input type='hidden' name='flag' id='flag' value='left'><input type='hidden' name='date' id='date' value='"+u1+"'><input type='hidden' name='changed_date' id='changed_date' value='"+u2+"'><input type='hidden' name='validate' id='validate' value='Update'></form></BODY></HTML>";
		parent.parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.parent.frames[2].document.form1.submit();
		setTimeout('ccc()',500);
		}
		else
		{
		HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/DateValidation.jsp'><input type='hidden' name='flag' id='flag' value='left'><input type='hidden' name='date' id='date' value='"+u1+"'><input type='hidden' name='changed_date' id='changed_date' value='"+u2+"'><input type='hidden' name='validate' id='validate' value='Query'></form></BODY></HTML>";
		parent.parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);

		parent.parent.parent.frames[2].document.form1.submit();

		setTimeout('aaa()',500);
		}
}



function aaa(){	
	var clinic=parent.frames[0].document.forms[0].clinic.value;
	var practitioner=parent.frames[0].document.forms[0].practitioner.value;
	var Dates=parent.frames[0].document.forms[0].changed_date.value;
	var mode_find=parent.frames[0].document.forms[0].mode_find.value;
	var valid_date=parent.frames[0].document.forms[0].valid_date.value;
	var valid_date1=convertDate(valid_date,"DMY",localeName,"en");
	var value12=parent.frames[0].document.forms[0].reason_for_revise.value;
	var value13=parent.frames[0].document.forms[0].ref_no.value;
	var old_date=parent.frames[0].document.forms[0].old_date.value;
	var pre_pat_alcn_catg_code=parent.frames[0].document.forms[0].pre_pat_alcn_catg_code.value;
	var res_type=document.forms[0].res_type.value;
	var clinic_type=document.forms[0].clinic_type.value;
	var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
	var visit_limit_rule=document.forms[0].visit_limit_rule.value;
	var alcn_criteria=document.forms[0].alcn_criteria.value;
	var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
	var capture_fin_dtls_yn= parent.frames[1].document.forms[0].capture_fin_dtls_yn.value;
	var min_ela_per_resc_noshow_in_day= parent.frames[1].document.forms[0].min_ela_per_resc_noshow_in_day.value;
	var noshow_ctrl_by_splty_or_clinic= parent.frames[1].document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
	var contact_num_reqd_yn=  parent.frames[1].document.forms[0].contact_num_reqd_yn.value;
	var no_of_noshow_appts_for_alert=parent.frames[1].document.forms[0].no_of_noshow_appts_for_alert.value;
	var per_chk_for_no_show_alert=parent.frames[1].document.forms[0].per_chk_for_no_show_alert.value;
	var oper_stn_id=document.forms[0].oper_stn_id.value;
	var install_yn_val=document.forms[0].install_yn_val.value;
	var create_wait_list_yn= parent.frames[1].document.forms[0].create_wait_list_yn.value;
	var visit_flag_OP= parent.frames[1].document.forms[0].visit_flag_OP.value;
	var from_page= parent.frames[1].document.forms[0].from_page.value;
	var from_facility_id= parent.frames[1].document.forms[0].from_facility_id.value;
	var from_encounter_id= parent.frames[1].document.forms[0].from_encounter_id.value;
	var or_catalogue_code=parent.frames[1].document.forms[0].or_catalogue_code.value;
	var position=parent.frames[0].document.forms[0].position.value;
	var addtl_splty=parent.frames[0].document.forms[0].addtl_splty.value;
	var rd_appt_yn=parent.frames[0].document.forms[0].rd_appt_yn.value;

	parent.parent.frames[1].location.href="../../eOA/jsp/SinglePractVw.jsp?clinic_code="+clinic+"&practitioner_id="+practitioner+"&mode_find="+mode_find+"&pre_pat_alcn_catg_code="+pre_pat_alcn_catg_code+"&Date="+Dates+"&value12="+value12+"&value13="+value13+"&valid_date="+valid_date1+"&old_date="+old_date+"&res_type="+res_type+"&clinic_type="+clinic_type+"&alcn_criteria="+alcn_criteria+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&oper_stn_id="+oper_stn_id+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_page="+from_page+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&or_catalogue_code="+or_catalogue_code+"&ca_patient_id="+parent.frames[1].document.forms[0].ca_patient_id.value+"&position="+position+"&addtl_splty="+addtl_splty+"&rd_appt_yn="+rd_appt_yn;
}

function ccc()
{
		
	var clinic=parent.frames[0].document.forms[0].clinic.value;
	var practitioner=parent.frames[0].document.forms[0].practitioner.value;
	var mode_find=parent.frames[0].document.forms[0].mode_find.value;
	var Dates=parent.frames[0].document.forms[0].changed_date.value;
	var value12=parent.frames[0].document.forms[0].reason_for_revise.value;
	var value13=parent.frames[0].document.forms[0].ref_no.value;
	var old_date=parent.frames[0].document.forms[0].old_date.value;
	var valid_date=parent.frames[0].document.forms[0].valid_date.value; 
	var valid_date1=convertDate(valid_date,"DMY",localeName,"en");
	var pre_pat_alcn_catg_code=parent.frames[0].document.forms[0].pre_pat_alcn_catg_code.value;
	var res_type=document.forms[0].res_type.value;
	var clinic_type=document.forms[0].clinic_type.value;
	var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
	var visit_limit_rule=document.forms[0].visit_limit_rule.value;
	var alcn_criteria=document.forms[0].alcn_criteria.value;
	var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
	var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value;
	var min_ela_per_resc_noshow_in_day= document.forms[0].min_ela_per_resc_noshow_in_day.value;
	var noshow_ctrl_by_splty_or_clinic= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
	var contact_num_reqd_yn=  parent.frames[1].document.forms[0].contact_num_reqd_yn.value;
	var no_of_noshow_appts_for_alert=parent.frames[1].document.forms[0].no_of_noshow_appts_for_alert.value;
	var per_chk_for_no_show_alert=parent.frames[1].document.forms[0].per_chk_for_no_show_alert.value;
	var oper_stn_id=document.forms[0].oper_stn_id.value;
	var install_yn_val=document.forms[0].install_yn_val.value;
	var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
	var visit_flag_OP= document.forms[0].visit_flag_OP.value;
	var from_page= parent.frames[1].document.forms[0].from_page.value;
	var from_facility_id= parent.frames[1].document.forms[0].from_facility_id.value;
	var from_encounter_id= parent.frames[1].document.forms[0].from_encounter_id.value;	
	var position=parent.frames[0].document.forms[0].position.value;
	var addtl_splty=parent.frames[0].document.forms[0].addtl_splty.value;	
	var rd_appt_yn=parent.frames[0].document.forms[0].rd_appt_yn.value;	
	
		parent.parent.frames[1].location.href="../../eOA/jsp/SinglePractVw.jsp?clinic_code="+clinic+"&practitioner_id="+practitioner+"&mode_find="+mode_find+"&pre_pat_alcn_catg_code="+pre_pat_alcn_catg_code+"&Date="+Dates+"&value12="+value12+"&valid_date="+valid_date1+"&value13="+value13+"&old_date="+old_date+"&decide=Query"+"&res_type="+res_type+"&clinic_type="+clinic_type+"&alcn_criteria="+alcn_criteria+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&oper_stn_id="+oper_stn_id+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_page="+from_page+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&position="+position+"&addtl_splty="+addtl_splty+"&rd_appt_yn="+rd_appt_yn;
}

function aaa1(){
	var clinic=document.forms[0].clinic.value;
	var practitioner=document.forms[0].practitioner.value;
	var Dates=document.forms[0].changed_date.value;
	var mode_find=document.forms[0].mode_find.value;
	var valid_date=document.forms[0].valid_date.value;
	var valid_date1=convertDate(valid_date,"DMY",localeName,"en");
	var value12=document.forms[0].reason_for_revise.value;
	var value13=document.forms[0].ref_no.value;
	var old_date=document.forms[0].old_date.value;
	var pre_pat_alcn_catg_code=document.forms[0].pre_pat_alcn_catg_code.value;
	var res_type=document.forms[0].res_type.value;
	var clinic_type=document.forms[0].clinic_type.value;
	var callingMode=document.forms[0].hddTracker.value;
	var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
	var visit_limit_rule=document.forms[0].visit_limit_rule.value;
	var alcn_criteria=document.forms[0].alcn_criteria.value;
	var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
	var capture_fin_dtls_yn= parent.frames[1].document.forms[0].capture_fin_dtls_yn.value;
	var min_ela_per_resc_noshow_in_day= document.forms[0].min_ela_per_resc_noshow_in_day.value;
	var noshow_ctrl_by_splty_or_clinic= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
	var contact_num_reqd_yn=  parent.frames[1].document.forms[0].contact_num_reqd_yn.value;
	var no_of_noshow_appts_for_alert=parent.frames[1].document.forms[0].no_of_noshow_appts_for_alert.value;
	var per_chk_for_no_show_alert=parent.frames[1].document.forms[0].per_chk_for_no_show_alert.value;
	var oper_stn_id=document.forms[0].oper_stn_id.value;
	var install_yn_val=document.forms[0].install_yn_val.value;
	var create_wait_list_yn= parent.frames[1].document.forms[0].create_wait_list_yn.value;
	var visit_flag_OP= parent.frames[1].document.forms[0].visit_flag_OP.value;

	var from_page= parent.frames[1].document.forms[0].from_page.value;
	var from_facility_id= parent.frames[1].document.forms[0].from_facility_id.value;
	var from_encounter_id= parent.frames[1].document.forms[0].from_encounter_id.value;

	var order_id=parent.frames[1].document.forms[0].order_id.value;
	var order_line_num=parent.frames[1].document.forms[0].order_line_num.value;
	var order_catalog_code=parent.frames[1].document.forms[0].order_catalog_code.value;
	var position=parent.frames[0].document.forms[0].position.value;
	var addtl_splty=parent.frames[0].document.forms[0].addtl_splty.value;
	var rd_appt_yn=parent.frames[0].document.forms[0].rd_appt_yn.value;
	
	
	var url="../../eOA/jsp/SinglePractVw.jsp?clinic_code="+clinic+"&practitioner_id="+practitioner+"&mode_find="+mode_find+"&pre_pat_alcn_catg_code="+pre_pat_alcn_catg_code+"&Date="+Dates+"&value12="+value12+"&value13="+value13+"&valid_date="+valid_date1+"&old_date="+old_date+"&callingMode="+callingMode+"&ca_patient_id="+patient_id+"&res_type="+res_type+"&clinic_type="+clinic_type+"&alcn_criteria="+alcn_criteria+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&oper_stn_id="+oper_stn_id+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_page="+from_page+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code+"&position="+position+"&addtl_splty="+addtl_splty+"&rd_appt_yn="+rd_appt_yn;
	parent.parent.frames[1].location.href=url;

}

function ccc1(){
	var clinic=document.forms[0].clinic.value;
	var practitioner=document.forms[0].practitioner.value;
	var mode_find=document.forms[0].mode_find.value;
	var Dates=document.forms[0].changed_date.value;
	var value12=document.forms[0].reason_for_revise.value;
	var value13=document.forms[0].ref_no.value;
	var old_date=document.forms[0].old_date.value;
	var valid_date=document.forms[0].valid_date.value;
	var valid_date1=convertDate(valid_date,"DMY",localeName,"en");
	var pre_pat_alcn_catg_code=document.forms[0].pre_pat_alcn_catg_code.value;
	var res_type=document.forms[0].res_type.value;
	var clinic_type=document.forms[0].clinic_type.value;
	var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
	var visit_limit_rule=document.forms[0].visit_limit_rule.value;
	var alcn_criteria=document.forms[0].alcn_criteria.value;
	var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
	var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value;
	var min_ela_per_resc_noshow_in_day= document.forms[0].min_ela_per_resc_noshow_in_day.value;
	var noshow_ctrl_by_splty_or_clinic= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
	var contact_num_reqd_yn=  document.forms[0].contact_num_reqd_yn.value; 
	var no_of_noshow_appts_for_alert=document.forms[0].no_of_noshow_appts_for_alert.value;
	var per_chk_for_no_show_alert=document.forms[0].per_chk_for_no_show_alert.value;
	var oper_stn_id=document.forms[0].oper_stn_id.value;
	var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
	var visit_flag_OP= document.forms[0].visit_flag_OP.value;
	var from_page= parent.frames[1].document.forms[0].from_page.value;

	var callingMode=document.forms[0].hddTracker.value;
	var install_yn_val=document.forms[0].install_yn_val.value;	
	var from_facility_id= document.forms[0].from_facility_id.value;
	var from_encounter_id=document.forms[0].from_encounter_id.value;
	var position=parent.frames[0].document.forms[0].position.value;
	var addtl_splty=parent.frames[0].document.forms[0].addtl_splty.value;
	var rd_appt_yn=parent.frames[0].document.forms[0].rd_appt_yn.value;
		
		
			parent.parent.frames[1].location.href="../../eOA/jsp/SinglePractVw.jsp?clinic_code="+clinic+"&practitioner_id="+practitioner+"&mode_find="+mode_find+"&pre_pat_alcn_catg_code="+pre_pat_alcn_catg_code+"&Date="+Dates+"&value12="+value12+"&valid_date="+valid_date1+"&value13="+value13+"&old_date="+old_date+"&callingMode="+callingMode+"&ca_patient_id="+patient_id+"&res_type="+res_type+"&clinic_type="+clinic_type+"&alcn_criteria="+alcn_criteria+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&oper_stn_id="+oper_stn_id+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_page="+from_page+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&position="+position+"&addtl_splty="+addtl_splty+"&rd_appt_yn="+rd_appt_yn;
}

function back(objname){
	var callingMode = document.forms[0].callingMode.value;
	var cmd=document.forms[0].caMod.value;
	var qStr=document.forms[0].qStr.value;
	var from_wait_list=document.forms[0].from_wait_list.value;
	var install_yn_val=document.forms[0].install_yn_val.value;
	var oper_stn_id=document.forms[0].oper_stn_id.value;
	var book_appt_yn=document.forms[0].book_appt_yn.value;
	var create_wait_list_yn=document.forms[0].create_wait_list_yn.value;
	if (callingMode==""   || callingMode=="CA" ){
		if(cmd=='Y'){
			parent.location.href='../../eOA/jsp/CAOAAppointment.jsp?'+qStr;
		}else{
			parent.location.href="../../eOA/jsp/Appointment.jsp?CA=N&install_yn_val="+install_yn_val+"&oper_stn_id="+oper_stn_id+"&book_appt_yn="+book_appt_yn+"&create_wait_list_yn="+create_wait_list_yn;
		}
	}else {
		parent.window.returnValue="OP";
		parent.window.close();
	}
}
function callOR(objname)
{
	var install_yn_val=document.forms[0].install_yn_val.value;
	var url="../../eOA/jsp/DisplayPendingSchedule.jsp?install_yn_val="+install_yn_val;
	parent.parent.frames[1].location.href=url;
	
}

var clinic;
var practitioner;
var date;
var ref_no;

/* ----Comment By Rajendra...............
   This popDay function is called in DateCheck function To Dispay the Day of the week.*/
function PopDay()
{
	/*   strDate = document.forms[0].valid_date.value;
	   strDateArray = strDate.split("/");
	   strDay		= strDateArray[0];
	   strMonth		= strDateArray[1];
	   strYear		= strDateArray[2]; 
	   Vdate		= new Date(strMonth+'/'+ strDay +'/'+ strYear)   */


	var d_dates = document.forms[0].valid_date.value;
	var greg_obj1 = convertDate(d_dates,"DMY",localeName,"en");
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


	if(Vdate != "NaN")
	   document.getElementById('day1').innerHTML="<b>"+Vdate+"</b>";
	else
		document.getElementById('day1').innerHTML="<b>&nbsp;</b>";
}


/* This DateCheck funtion first validates the from and to dates and validates whether the to date is valid or not. if it valids it proceeds other wise it returns false.if it is true then it compares the from date and to date and throws an alert if from date is grater than to date and makes the Go button disabled*/

/*function DateCheck(from,to)
{
	if(to.value !='')
	{
		document.forms[0].go.disabled=false;
	if (ChkDate(to) == false) 
	{
		alert(getMessage("INVALID_DATE_FMT","SM"));
		document.forms[0].go.disabled=true;
		to.select();
		to.focus();
		return false;
	}
	else 
	{

		var fromarray; var toarray;
		var fromdate = from;
		var todate = to.value ;

		if(fromdate.length > 0 && todate.length > 0 )
		{

			fromarray = fromdate.split("/");
			toarray = todate.split("/");

			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	


			if(!DateCompare4(document.forms[0].cur_dt,to))
			{
				
				alert(getMessage("SCH_DATE_NOT_GREAT_TODAY","OA"));
				to.select();
				to.focus();
				document.forms[0].go.disabled=true;
				return false;

			}else if(Date.parse(todt) >= Date.parse(fromdt))
			{
				document.forms[0].go.disabled=false;
				PopDay();
				document.forms[0].go.focus();
				return true;			
			}
		 }
			document.forms[0].go.disabled=false;
			PopDay();
			return true;
	  }
	}else {
		document.forms[0].go.disabled=true;
	}
}
*/

/*This alert function gets called when Go button gets Focus.. */
function alt_fn()
{		
	DateCheck_new(document.forms[0].cur_dt.value,document.forms[0].valid_date)
	PopDay();
}

/*when ever user presses key in valid_date text box this function gets called and on pressing enter key it displays calender*/
function check_val(event)
{
		if(event.keyCode==13)
		return  showCalendar('date_of_expiry',null);
}
/* This Function BlankDateChk is called on click of Go button and it throws an alert of Date is blnk of valid_date text box and finally valid_date text box gets the focus*/

function blankdatechk()
{
	if(document.forms[0].valid_date.value =="")
	{

		var error =getMessage("TO_DT_NOT_BLANK","SM");
		var error1 =error.substring	(0,11);
		var error2= error.substring(13 ,60);
		alert(error1 + getLabel("Common.Schedule.label","Common") +error2);
		document.forms[0].valid_date.focus();
	}else{
		moveForward();
	}
}

function enabgo(obj)
{
	if(obj.value=="")
	{
		document.forms[0].go.disabled=true;
	}else
	{
		document.forms[0].go.disabled=false;

	}
}

/*Script functions of DisplayLabels.jsp*/
	
async function allocationDetails(clinicCode,clinicDate,practID){
		var dialogTop = "60" ;
		var dialogHeight= "20" ;
		var dialogWidth	= "40" ;
		var status = "no";
		var arguments	= "" ;
		var tit="locn_Srch";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var retVal = await window.showModalDialog("../../eOA/jsp/ClinicAllocationDetails.jsp?clinic_code="+clinicCode+"&clinic_date="+clinicDate+"&practitioner_id="+practID,arguments,features);	
}
	

function moveNextlabels(){//OverBooking Link in DaySchedule
	
	var value1;
	var value2;
	var value3;
	var value4;
	var value5;
	var value6;
	var value7;
	var value8;
	var value9;
	var value10;
	var value11;
	var value12;
	var value13;

		value1=document.forms[0].clinic_code.value;
		value2=document.forms[0].clinic_name.value;
		value3=document.forms[0].pract_id.value;
		value4=document.forms[0].pract_name.value;
		value5=document.forms[0].appt_date.value;
		value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
		value8=document.forms[0].over_booked.value;
		//value6= document.forms[0].from_time.value;
		//value7=document.forms[0].to_time.value;
		
		if(value9 == '3' && value8 =='Y')
		
		{
		value6= document.forms[0].p_o_end_time.value;
		value7=document.forms[0].p_o_end_time.value;
		}
			
		value10=document.forms[0].patient_id.value;
		value12=document.forms[0].reason_for_revise.value;
		value13=document.forms[0].ref_no.value;
		//value12=document.forms[0].value12.value;
		//value13=document.forms[0].value13.value;
		

		if(value13 != "hjjh"){
		var obook_appt_yn = document.forms[0].obook_appt_yn.value;
			if (obook_appt_yn=="N"){
			   alert(getMessage('OVER_BOOK_NOT_ALLOWED','OA'));       
			}else{
				callBookAppointmentlabels();

			}
		}
		else if( value13== "hjjh"){
		callBookAppointmentDetailslabels();
		}
}


async function callBookAppointmentlabels(){
	//alert("callBookAppointmentlabels");
		// called for over booking
		var value1=document.forms[0].clinic_code.value;
		var value2=document.forms[0].clinic_name.value;
		var value3=document.forms[0].pract_id.value;
		var value4=document.forms[0].pract_name.value;
		var value5=document.forms[0].appt_date.value;
		var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
		var value8=document.forms[0].over_booked_label.value;
		//var value6= document.forms[0].from_time.value;
		//var value7=document.forms[0].to_time.value;
		var value6= document.forms[0].p_o_end_time.value;
		var value7=document.forms[0].p_o_end_time.value;
		var value10=document.forms[0].patient_id.value;
		//var value12=document.forms[0].value12.value;
		//var value13=document.forms[0].value13.value;
		var book_appt_yn=document.forms[0].book_appt_yn.value;
		var book_appt_wo_pid_yn=document.forms[0].book_appt_wo_pid_yn.value;
		var obook_appt_yn=document.forms[0].obook_appt_yn.value;
		var book_appt_across_catg_yn=document.forms[0].book_appt_across_catg_yn.value;
		var tfr_appt_yn=document.forms[0].tfr_appt_yn.value;
		var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
		var canc_appt_yn=document.forms[0].canc_appt_yn.value;
		var obvisit_flag=document.forms[0].p_o_obvisit_flag.value;
		var ca_patient_id=document.forms[0].ca_patient_id.value
		var res_type=document.forms[0].res_type.value;
		var clinic_type=document.forms[0].clinic_type.value;
		var req_id= document.forms[0].req_id.value;
		var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
		var visit_flag_OP= document.forms[0].visit_flag_OP.value;
		var or_catalogue_code=document.forms[0].or_catalogue_code.value;//Normal Order
		var order_catalog_code=document.forms[0].order_catalog_code.value;//Pending Order Added for 19821 by Sudhakar
		var order_id=document.forms[0].order_id.value;//Pending Order Added for 19821 by Sudhakar
		var order_line_num=document.forms[0].order_line_num.value;//Pending Order Added for 19821 by Sudhakar
		var oper_stn_id= document.forms[0].oper_stn_id.value;
		var slot_appt_ctrl = document.forms[0].slot_appt_ctrl.value;
		var visit_limit_rule = document.forms[0].visit_limit_rule.value;
		var alcn_criteria=document.forms[0].alcn_criteria.value;
		var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
		var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value;
		var min_ela_per_resc_noshow_in_day= document.forms[0].min_ela_per_resc_noshow_in_day.value;
		var noshow_ctrl_by_splty_or_clinic= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
		var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;
		var no_of_noshow_appts_for_alert=document.forms[0].no_of_noshow_appts_for_alert.value;
		var per_chk_for_no_show_alert=document.forms[0].per_chk_for_no_show_alert.value;
		var from_page= document.forms[0].from_page.value;
		var from_facility_id= document.forms[0].from_facility_id.value;
		var from_encounter_id= document.forms[0].from_encounter_id.value;
		var rd_appt_yn= document.forms[0].rd_appt_yn.value;
		
			
	var rule_appl_yn			= "";
	var patient_id_temp			= "";
	var name_prefix_temp		="";
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
	var wtListControl 		    =  document.forms[0].wtListControl.value;
	var waitListNo	 		    =  document.forms[0].waitListNo.value;
	
	if(parent.parent.tempStorageFrame && parent.parent.tempStorageFrame.tempStorageForm){
		rule_appl_yn			= parent.parent.tempStorageFrame.tempStorageForm.rule_appl_yn.value;
		patient_id_temp			= parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value;
		name_prefix_temp		= parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value;
		first_name_temp			= parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value;
		second_name_temp		= parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value;
		third_name_temp			= parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value;
		family_name_temp		= parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value;
		name_suffix_temp		= parent.parent.tempStorageFrame.tempStorageForm.name_suffix_temp.value;
		name_prefix_oth_lang_temp		= parent.parent.tempStorageFrame.tempStorageForm.name_prefix_oth_lang_temp.value;
		first_name_oth_lang_temp			= parent.parent.tempStorageFrame.tempStorageForm.first_name_oth_lang_temp.value;
		second_name_oth_lang_temp		= parent.parent.tempStorageFrame.tempStorageForm.second_name_oth_lang_temp.value;
		third_name_oth_lang_temp			= parent.parent.tempStorageFrame.tempStorageForm.third_name_oth_lang_temp.value;
		family_name_oth_lang_temp		= parent.parent.tempStorageFrame.tempStorageForm.family_name_oth_lang_temp.value;
		name_suffix_oth_lang_temp		= parent.parent.tempStorageFrame.tempStorageForm.name_suffix_oth_lang_temp.value;
		gender_temp				= parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value;
		contact_no_temp			= parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value;
		nationality_code_temp	= parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value;
		language_code_temp		= parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value;
		term_set_id				= parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value;
		linking_code			= parent.parent.tempStorageFrame.tempStorageForm.linking_code.value;
	}		

		var retVal = 	new String();
		var dialogHeight= "42.5" ;
		var dialogTop = "83" ;
		var dialogWidth	= "65" ;
		var status = "no";		
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
		var callurl="../../eOA/jsp/BookAppointment.jsp?i_clinic_code="+value1+"&i_clinic_name="+value2+"&i_practitioner_id="+value3+"&i_practitioner_name="+value4+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&i_over_booked="+value8+"&i_time_table_type="+value9+"&i_patient_id="+value10+"&book_appt_across_catg_yn="+book_appt_across_catg_yn+"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&obvisit_flag="+obvisit_flag+"&ca_patient_id="+ca_patient_id+"&clinic_type="+clinic_type+"&res_type="+res_type+"&or_catalogue_code="+or_catalogue_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code+"&oper_stn_id="+oper_stn_id+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_page1="+from_page+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&patient_id_temp="+patient_id_temp+"&name_prefix_temp="+escape(name_prefix_temp)+"&first_name_temp="+escape(first_name_temp)+"&second_name_temp="+escape(second_name_temp)+"&third_name_temp="+escape(third_name_temp)+"&family_name_temp="+escape(family_name_temp)+"&name_suffix_temp="+escape(name_suffix_temp)+"&name_prefix_oth_lang_temp="+escape(name_prefix_oth_lang_temp)+"&first_name_oth_lang_temp="+escape(first_name_oth_lang_temp)+"&second_name_oth_lang_temp="+escape(second_name_oth_lang_temp)+"&third_name_oth_lang_temp="+escape(third_name_oth_lang_temp)+"&family_name_oth_lang_temp="+escape(family_name_oth_lang_temp)+"&name_suffix_oth_lang_temp="+escape(name_suffix_oth_lang_temp)+"&gender_temp="+gender_temp+"&contact_no_temp="+contact_no_temp+"&rule_appl_yn="+rule_appl_yn+"&nationality_code_temp="+nationality_code_temp+"&language_code_temp="+language_code_temp+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&wtListControl="+wtListControl+"&waitListNo="+waitListNo+"&rd_appt_yn="+rd_appt_yn; //Pending Order Added for 19821 by Sudhakar
		retVal = await parent.parent.document.frames[1].window.showModalDialog(callurl,arguments,features);
		if(retVal == 'Abort' || retVal == undefined)
		{
		}else{
			if(document.getElementById('wtListControl').value=='B'){
				window.close();
			}
			setTimeout('aaalabels()',1000);
		}
}

async function callBookAppointmentDetailslabels()
{	//alert('callBookAppointmentDetailslabels');
		var value1=document.forms[0].clinic_code.value;
		var value2=document.forms[0].clinic_name.value;
		var value3=document.forms[0].pract_id.value;
		var value4=document.forms[0].pract_name.value;
		var value5=document.forms[0].appt_date.value;
		var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
		var value8=document.forms[0].over_booked.value;
		//var value6= document.forms[0].from_time.value;
		//var value7=document.forms[0].to_time.value;
		var value6= document.forms[0].p_o_end_time.value;
		var value7=document.forms[0].p_o_end_time.value;
		var value10=document.forms[0].patient_id.value;
		var value12=document.forms[0].value12.value;
		var value13=document.forms[0].value13.value;
	var book_appt_yn=document.forms[0].book_appt_yn.value;
	var book_appt_wo_pid_yn=document.forms[0].book_appt_wo_pid_yn.value;
	var obook_appt_yn=document.forms[0].obook_appt_yn.value;
	var book_appt_across_catg_yn=document.forms[0].book_appt_across_catg_yn.value;
	var tfr_appt_yn=document.forms[0].tfr_appt_yn.value;
	var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
	var canc_appt_yn=document.forms[0].canc_appt_yn.value;
	var alcn_criteria=document.forms[0].alcn_criteria.value;
	var pre_pat_alcn_catg_code=document.forms[0].pre_pat_alcn_catg_code.value;
	var ca_patient_id=parent.frames[2].document.forms[0].ca_patient_id.value
	var res_type=document.forms[0].res_type.value;
	var clinic_type=document.forms[0].clinic_type.value;

	var mode_find='';
	var retVal = 	new String();
	var dialogHeight= "100vh" ;
	var dialogTop = "0" ;
	var dialogWidth	= "65vw" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await parent.parent.document.frames[1].window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+value12+"&i_clinic_code="+value1+"&i_practitioner_id="+value3+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&over_booked="+value8+"&i_time_table_type="+value9+"&value13="+value13+"&pre_pat_alcn_catg_code="+pre_pat_alcn_catg_code+"&old_to_time="+value15+"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&ca_patient_id="+ca_patient_id+"&clinic_type="+clinic_type+"&res_type="+res_type+"&wtListControl="+document.forms[0].wtListControl.value,arguments,features);
	if(retVal == "close")
	retVal="|";
	returnarray=retVal.split("|");
	var j1=returnarray[1];
	var j2=returnarray[0];
	var pre_pat_alcn_catg_code=returnarray[6];
	document.forms[0].pre_pat_alcn_catg_code.value=pre_pat_alcn_catg_code;				
	document.forms[0].value12.value=j2;
	document.forms[0].value13.value=j1;
		if(retVal == '|') ;
		else
		{
			mode_find="revise";
			setTimeout("aaalabels('"+mode_find+"');",1000);
		}
		if( cc == 'closed')
		{
			mode_find="dummy";
			setTimeout('aaalabels()',1000);
		}
}

	
function aaalabels(mode_find){ 
	//alert("mode_find---->"+mode_find);
		var value1=document.forms[0].clinic_code.value;
		var value2=document.forms[0].clinic_name.value;
		var value3=document.forms[0].pract_id.value;
		var value4=document.forms[0].pract_name.value;
		var value5=document.forms[0].appt_date.value;
		var value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
		var value8=document.forms[0].over_booked.value;
		//var value6= document.forms[0].from_time.value;
		//var value7=document.forms[0].to_time.value;
		var value6= document.forms[0].p_o_end_time.value;
		var value7=document.forms[0].p_o_end_time.value;
		var value10=document.forms[0].patient_id.value;
		//var value12=document.forms[0].value12.value;
		//var value13=document.forms[0].value13.value;
		var res_type=document.forms[0].res_type.value;
		var clinic_type=document.forms[0].clinic_type.value;
		var or_catalogue_code=document.forms[0].or_catalogue_code.value;
		var oper_stn_id=document.forms[0].oper_stn_id.value;
		var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
		var visit_limit_rule=document.forms[0].visit_limit_rule.value;
		var alcn_criteria=document.forms[0].alcn_criteria.value;
		var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
		var install_yn_val=document.forms[0].install_yn_val.value;
		var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
		var visit_flag_OP=document.forms[0].visit_flag_OP.value;
		var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value;
		var from_facility_id= document.forms[0].from_facility_id.value;
		var from_encounter_id= document.forms[0].from_encounter_id.value;
		var min_ela_per_resc_noshow_in_day= document.forms[0].min_ela_per_resc_noshow_in_day.value;
		var noshow_ctrl_by_splty_or_clinic= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
		var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;
		var no_of_noshow_appts_for_alert=document.forms[0].no_of_noshow_appts_for_alert.value;
		var per_chk_for_no_show_alert=document.forms[0].per_chk_for_no_show_alert.value;
		var calling_mode=document.forms[0].calling_mode.value; //added by Sathish.S on Wednesday, March 10, 2010 for IN019820

		if(document.getElementById('wtListControl').value=='' && parent.parent.frames[1].frames[2].name=='checkbox')
		{
			if(document.forms[0].ca_patient_id.value=='')
				{			
					var url="../../eOA/jsp/SinglePractVw.jsp?clinic_code="+value1+"&practitioner_id="+value3+"&Date="+value5+"&pre_pat_alcn_catg_code="+document.forms[0].pre_pat_alcn_catg_code.value+"&mode_find="+mode_find+"&clinic_type="+clinic_type+"&res_type="+res_type+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&alcn_criteria="+alcn_criteria+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic;
					parent.parent.frames[1].location.href=url;
				}else if(calling_mode=='' || calling_mode=='OR'){//added by Sathish.S on Wednesday, March 10, 2010 for IN019820 Starts here	
					var url="../../eOA/jsp/SinglePractVw.jsp?clinic_code="+value1+"&practitioner_id="+value3+"&Date="+value5+"&pre_pat_alcn_catg_code="+document.forms[0].pre_pat_alcn_catg_code.value+"&mode_find="+mode_find+"&clinic_type="+clinic_type+"&res_type="+res_type+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&alcn_criteria="+alcn_criteria+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic;
					parent.parent.frames[1].location.href=url;		//Ends here			
				}else{					
					window.close();
				}

			}else if(document.getElementById('wtListControl').value=='' && parent.parent.frames[1].frames[2].name=='dummy')
			{				
					var url="../../eOA/jsp/SinglePractVw.jsp?clinic_code="+value1+"&practitioner_id="+value3+"&Date="+value5+"&pre_pat_alcn_catg_code="+document.forms[0].pre_pat_alcn_catg_code.value+"&mode_find="+mode_find+"&clinic_type="+clinic_type+"&res_type="+res_type+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&alcn_criteria="+alcn_criteria+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic;
					parent.parent.frames[1].location.href=url;
				
			}else if(document.getElementById('wtListControl').value=='')
			{
			if(create_wait_list_yn !="Y")
			{
			var tmp1=parent.parent.frames[1].frames[2].document.forms[0].hddUrl.value;
			var tmp2=document.forms[0].hddur.value;
			var url="../../eOA/jsp/DisplayResults.jsp?"+tmp1;
			var url2="../../eOA/jsp/DisplayLabels.jsp?"+tmp2;
			parent.parent.frames[1].frames[1].location.href=url2;
			parent.parent.frames[1].frames[2].location.href=url;
			}
		}
}

async function show_allocation_details_labels(alcn_criteria,clinic_code,practioner_id,appt_date,time_tab_type)
{
	var dialogHeight= "10" ;
	var dialogWidth	= "30" ;
	var dialogTop = "232" ;
	var center = "1" ;
	var status="no";
	var res_type=document.forms[0].res_type.value;
	var clinic_type=document.forms[0].clinic_type.value;

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	await window.showModalDialog("../../eOA/jsp/SchAllocationdetailsFrame.jsp?alcn_criteria="+alcn_criteria+"&clinic_code="+clinic_code+"&practioner_id="+practioner_id+"&time_tab_type="+time_tab_type+"&appt_date="+appt_date+"&clinic_type="+clinic_type+"&res_type="+res_type,arguments,features);

}

/*Script functions of DisplayResults.jsp*/


async function show_Reference_details_results(appt_no2,fac_id2)
{
	var dialogHeight= "23" ;
	var dialogWidth	= "54" ;
	var dialogTop = "190" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	await window.showModalDialog("../../eOA/jsp/SecApptReferenceFrame.jsp?appt_no2="+appt_no2+"&fac_id2="+fac_id2,arguments,features);
}

	var u1;
	var u2;
function row(Obj)
{
	u1=Obj.rowIndex;
}

function col(Obj)
{
	u2=Obj.cellIndex;
}

	 var value1;
	 var value2;
	 var value3;
	 var value4;
	 var value5;
	 var value6;
	 var value7;
	 var value8;
	 var value9;
	 var value10;
	 var value11;
	 var sys_date;
	 var sys_time;
	 var pre_pat_alcn_catg_code;
	 var value12;
	 var value13;
	 var value14;
	 var value15;


function moveNext_results(pVal,refno){
	 
	var latter=document.getElementById('results1').rows[u1].cells[3].innerText ;
	value1=document.getElementById('clinic_code').value;
	value2=document.forms[0].clinic_name.value;
	value3=document.forms[0].pract_id.value;
	value4=document.forms[0].pract_name.value;
	value5=document.forms[0].appt_date.value;
	value6= document.getElementById('results1').rows[u1].cells[u2].innerText;

	/* Added for ML-BRU-CRF-0628.1 */
	ext_slot=document.forms[0].p_o_ext_slot_status.value;
	var s_arr=ext_slot.split("|");
	if (s_arr[u1-1] == 'Y' && refno == "~") {
		alert(getMessage("BRU_HEALTH_SLOT_SELECTED","OA"));

	}else{

			var s = value6.substr(0,5);
			value6 = s;	
			if(u2){
			}else{
				u2=0;
			}
			var recall_time=document.forms[0].recall_time.value;
			var cont_flg=true;	
			if(recall_time!='N'){
				var dt1  =new Date(value5+" "+value6);
				var dt2  =new Date(value5+" "+recall_time);		
				if(Date.parse(dt1) < Date.parse(dt2)){
					alert(getMessage("FRM_LS_REC_TIME","OA"));
					cont_flg=false;
				}
			}
			if(cont_flg){
				value7=document.getElementById('results1').rows[u1].cells[u2+1].innerText;
				value8=document.forms[0].over_booked.value;
				value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
				value10=document.forms[0].patient_id.value;
				value11=refno
				//value11=document.forms[0].elements(u1+1).value;
				value12=document.forms[0].reason_for_revise.value;
				//
				value13=document.forms[0].ref_no.value;
				value14= document.forms[0].old_from_time.value;
				value15= document.forms[0].old_to_time.value;
				pre_pat_alcn_catg_code=document.forms[0].pre_pat_alcn_catg_code.value;
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
				var  old_date=document.forms[0].old_date.value;
				if( old_date.length == 0) document.forms[0].old_date.value=value5;
				if(!pVal) pVal='NO';
				//alert(document.forms[0].elements(u1+1).value	)
				if(refno == "~"){
					if(DateCompare4(document.forms[0].appt_date ,document.forms[0].sys_date)){
						if(value9 == "1"){
							/*if(( Date.parse(tohtm) < Date.parse(fromhtm) )  ){
								alert(getMessage("FR_TIME_CAN_NOT_SYS_TIME"));
							}else*/		
								
							if(( Date.parse(fromhtm) >= Date.parse(to_displayed))){
								alert(getMessage("FR_TIME_CAN_NOT_SYS_TIME","OA"));
							}else{
								if( document.forms[0].r_appt_status.value == "Revise"){
									callBookAppointmentDetails_results(pVal);
								}else{
									if(value12.length == 0){
										if(pVal=='BL' || pVal=='BR'){										
											callBookAppointment_results(pVal);
										}else{										
											callBookAppointment_results();//calling book appointment page from OP->Register Visit->Appointment Details 
										}
									}else{		
										callBookAppointmentDetails_results(pVal);
									}
								}
							}
						}
						if(value9 == "2" || value9 == "3"){
							if(( Date.parse(to_displayed) < Date.parse(fromhtm))){
								if(latter.length != 1){
										
									callBookAppointmentDetails2_results();
								}else
									alert(getMessage('ST_TM_LESS_SY_TM','OA'));
							}else{
								if( document.forms[0].r_appt_status.value == "Revise"){
										
									callBookAppointmentDetails_results(pVal);
								}else{
									if(value12.length == 0){
										if(pVal=='BL' || pVal=='BR'){
																			
											callBookAppointment_results(pVal);
										}else{
											
											callBookAppointment_results();
										}
									}else{
										
										callBookAppointmentDetails_results(pVal);
									}
								}
							}
						} 
			}else{
				if(document.forms[0].r_appt_status.value == "Revise"){
					callBookAppointmentDetails_results(pVal);
				}else{
					if(value12.length == 0){
						callBookAppointment_results();
					}else{
						callBookAppointmentDetails_results(pVal);
					}
				}

			}
		}else{
			if( DateCompare4(document.forms[0].appt_date ,document.forms[0].sys_date)){
				if(value9 == "1"){
					if(( Date.parse(tohtm) < Date.parse(fromhtm) )  ){
						if(latter.length != 1){
							
							callBookAppointmentDetails2_results();
						}else
							alert(getMessage('FR_TIME_CAN_NOT_SYS_TIME','OA'));	
					}else{
						if( document.forms[0].r_appt_status.value == "Revise"){
							alert(getMessage('REVISION_NOT_ALLOWED','OA'));
						}else{//calling for forced appointment
						
							callBookAppointmentDetails_results( pVal);
						}
					}
				}
				if(value9 == "2" || value9 == "3"){
					if(( Date.parse(to_displayed) < Date.parse(fromhtm) )  ){
						if(latter.length != 1){
							
							callBookAppointmentDetails2_results();
						}else
							alert(getMessage('ST_TM_LESS_SY_TM','OA'));
					}else{
						if( document.forms[0].r_appt_status.value == "Revise"){
							alert(getMessage('REVISION_NOT_ALLOWED','OA'));
						}else{
						
							callBookAppointmentDetails_results(pVal );
						}
					}
				}

		}else{		
			if( document.forms[0].r_appt_status.value == "Revise"){
				alert(getMessage('REVISION_NOT_ALLOWED','OA'));
			}else{
				
				callBookAppointmentDetails_results(pVal );
			}
		}
		}
		}
	}
}

function visiblelity()
{
	setTimeout('cc_results()',0);
}

function cc_results()
{
	if(document.forms[0].reason_for_revise)
	{
	if(document.forms[0].reason_for_revise.value.length == 0 || document.forms[0].reason_for_revise.value =="undefined" ) ;
	else{
	parent.frames[0].document.forms[0].ref_no.value=document.forms[0].ref_no.value;
	parent.frames[0].document.forms[0].reason_for_revise.value=document.forms[0].reason_for_revise.value;
	parent.frames[0].document.getElementById('ss').style.visibility="visible";
	}
	}
}

async function callBookAppointment_results(x,y){//calling bookappointment modal window
	
	if(x=='BL' || x=='BR'){
		callBForced(x);
	}else{
		var Forced='N';
		if(x=='F'){
			Forced='Y';
		}

		var block_break_appt='N'
		if(y){
			block_break_appt=y;
		}
		var book_appt_yn=document.forms[0].book_appt_yn.value;
		var book_appt_wo_pid_yn=document.forms[0].book_appt_wo_pid_yn.value;
		var obook_appt_yn=document.forms[0].obook_appt_yn.value;
		var book_appt_across_catg_yn=document.forms[0].book_appt_across_catg_yn.value;
		var tfr_appt_yn=document.forms[0].tfr_appt_yn.value;
		var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
		var canc_appt_yn=document.forms[0].canc_appt_yn.value;
		old_date=document.forms[0].old_date.value;
		var ca_patient_id=document.forms[0].ca_patient_id.value;
		var res_type=document.forms[0].res_type.value;
		var clinic_type=document.forms[0].clinic_type.value;
		var or_catalogue_code=document.forms[0].or_catalogue_code.value;
		var order_id=document.forms[0].order_id.value;
		var order_line_num=document.forms[0].order_line_num.value;
		var order_catalog_code=document.forms[0].order_catalog_code.value;
		var oper_stn_id =document.forms[0].oper_stn_id.value;
		var slot_appt_ctrl = document.forms[0].slot_appt_ctrl.value;
		var visit_limit_rule = document.forms[0].visit_limit_rule.value;
		var alcn_criteria=document.forms[0].alcn_criteria.value;
		var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
		var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value;
		var min_ela_per_resc_noshow_in_day= document.forms[0].min_ela_per_resc_noshow_in_day.value;	
		var noshow_ctrl_by_splty_or_clinic= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
		var contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;
		var no_of_noshow_appts_for_alert=document.forms[0].no_of_noshow_appts_for_alert.value;
		var per_chk_for_no_show_alert=document.forms[0].per_chk_for_no_show_alert.value;
		var req_id= document.forms[0].req_id.value;
		var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
		var visit_flag_OP= document.forms[0].visit_flag_OP.value;
		var from_page= document.forms[0].from_page.value;
		var from_facility_id= document.forms[0].from_facility_id.value;
		var from_encounter_id= document.forms[0].from_encounter_id.value;

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
		var wtListControl 		    =  document.forms[0].wtListControl.value;
		var waitListNo	 		    =  document.forms[0].waitListNo.value;
		var apptrefno				= "";
		var canldapptrefno          ="";
		
		if(parent.parent.tempStorageFrame && parent.parent.tempStorageFrame.tempStorageForm){ 
			rule_appl_yn			= parent.parent.tempStorageFrame.tempStorageForm.rule_appl_yn.value;
			patient_id_temp			= parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value;
			name_prefix_temp		= parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value;
			first_name_temp			= parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value;
			second_name_temp		= parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value;
			third_name_temp			= parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value;
			family_name_temp		= parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value;
			name_suffix_temp		= parent.parent.tempStorageFrame.tempStorageForm.name_suffix_temp.value;			
			name_prefix_oth_lang_temp		= parent.parent.tempStorageFrame.tempStorageForm.name_prefix_oth_lang_temp.value;
			first_name_oth_lang_temp			= parent.parent.tempStorageFrame.tempStorageForm.first_name_oth_lang_temp.value;
			second_name_oth_lang_temp		= parent.parent.tempStorageFrame.tempStorageForm.second_name_oth_lang_temp.value;
			third_name_oth_lang_temp			= parent.parent.tempStorageFrame.tempStorageForm.third_name_oth_lang_temp.value;
			family_name_oth_lang_temp		= parent.parent.tempStorageFrame.tempStorageForm.family_name_oth_lang_temp.value;
			name_suffix_oth_lang_temp		= parent.parent.tempStorageFrame.tempStorageForm.name_suffix_oth_lang_temp.value;		
			gender_temp				= parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value;
			contact_no_temp			= parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value;
			nationality_code_temp	= parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value;
			language_code_temp		= parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value;
			term_set_id				= parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value;
			linking_code			= parent.parent.tempStorageFrame.tempStorageForm.linking_code.value;
			canldapptrefno			= parent.parent.tempStorageFrame.tempStorageForm.apptrefno.value;
		}


		var retVal = 	new String();
		var dialogHeight= "90vh" ;
		var dialogTop = "0vh"  ;
		var dialogWidth	= "90vw" ;
		var status = "no";				
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
		var url="../../eOA/jsp/BookAppointment.jsp?i_clinic_code="+value1+"&i_clinic_name="+encodeURIComponent(value2)+"&i_practitioner_id="+value3+"&i_practitioner_name="+encodeURIComponent(value4)+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&i_over_booked="+value8+"&i_time_table_type="+value9+"&i_patient_id="+value10+"&book_appt_across_catg_yn="+book_appt_across_catg_yn+"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&ca_patient_id="+ca_patient_id+"&alcn_criteria="+alcn_criteria+"&Forced="+Forced+"&block_break_appt="+block_break_appt+"&clinic_type="+clinic_type+"&res_type="+res_type+"&or_catalogue_code="+or_catalogue_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code+"&oper_stn_id="+oper_stn_id+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_page1="+from_page+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&patient_id_temp="+patient_id_temp+"&name_prefix_temp="+escape(name_prefix_temp)+"&first_name_temp="+escape(first_name_temp)+"&second_name_temp="+escape(second_name_temp)+"&third_name_temp="+escape(third_name_temp)+"&family_name_temp="+escape(family_name_temp)+"&name_suffix_temp="+escape(name_suffix_temp)+"&name_prefix_oth_lang_temp="+escape(name_prefix_oth_lang_temp)+"&first_name_oth_lang_temp="+escape(first_name_oth_lang_temp)+"&second_name_oth_lang_temp="+escape(second_name_oth_lang_temp)+"&third_name_oth_lang_temp="+escape(third_name_oth_lang_temp)+"&family_name_oth_lang_temp="+escape(family_name_oth_lang_temp)+"&name_suffix_oth_lang_temp="+escape(name_suffix_oth_lang_temp)+"&gender_temp="+gender_temp+"&contact_no_temp="+contact_no_temp+"&rule_appl_yn="+rule_appl_yn+"&nationality_code_temp="+nationality_code_temp+"&language_code_temp="+language_code_temp+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&wtListControl="+wtListControl+"&waitListNo="+waitListNo+"&canldapptrefno="+canldapptrefno+"&rd_appt_yn="+rd_appt_yn;
		
		var callurl=url;
		// calling page check is opened as global booking can be done from any fucntion.
		//if(document.forms[0].calling_mode.value=='OP' && document.forms[0].refID.value!='N' && from_page ==""){
		if(document.forms[0].LocGlbChk.value=='Y'){
			if(document.forms[0].GlobalAllowed.value=='Y'){ 
				if(parseInt(document.forms[0].maxGlobal.value) >0 ){
					if(parseInt(document.forms[0].totGlobal.value) < parseInt(document.forms[0].maxGlobal.value)){
						callurl=callurl+"&Global=Y";	
						retVal = await window.showModalDialog(callurl,arguments,features);						
						if(retVal == 'abort' || retVal == undefined){
						}else{
							if(document.forms[0].calling_mode.value=='OP' && document.forms[0].refID.value!='N' && from_page ==""){
								setTimeout('dummmmmmyyy()',1000);
								bbb(retVal)
							}else{
								if(parent.parent.tempStorageFrame && parent.parent.tempStorageFrame.tempStorageForm){
									parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.name_suffix_temp.value = "";									
									parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.name_suffix_temp.value = "";
									
									parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value = "";
									parent.parent.tempStorageFrame.tempStorageForm.linking_code.value = "";	
									parent.parent.tempStorageFrame.tempStorageForm.apptrefno.value = "";	
								}								
								setTimeout('dummmmmmyyy()',1000);
								bbb_results(retVal)
							}
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
			retVal = await top.window.showModalDialog(callurl,arguments,features);//calling book appointment window when global value is unchecked			
			if(retVal == 'Abort' || retVal == undefined){ 
			}else{
				if(retVal=='MR' || document.forms[0].calling_mode.value=='RSCAPPT'){
					window.close();
					//const dialogTag = parent.parent.document.getElementById("dialog_tag");    
					//dialogTag.close();
				}else{
					if(parent.parent.tempStorageFrame && parent.parent.tempStorageFrame.tempStorageForm){		
						parent.parent.tempStorageFrame.tempStorageForm.patient_id_temp.value = "";					
						parent.parent.tempStorageFrame.tempStorageForm.name_prefix_temp.value = "";					
						parent.parent.tempStorageFrame.tempStorageForm.first_name_temp.value = "";
						parent.parent.tempStorageFrame.tempStorageForm.second_name_temp.value = "";
						parent.parent.tempStorageFrame.tempStorageForm.third_name_temp.value = "";
						parent.parent.tempStorageFrame.tempStorageForm.family_name_temp.value = "";
						parent.parent.tempStorageFrame.tempStorageForm.name_suffix_temp.value = "";
						
						
						parent.parent.tempStorageFrame.tempStorageForm.name_prefix_oth_lang_temp.value = "";				
						parent.parent.tempStorageFrame.tempStorageForm.first_name_oth_lang_temp.value = "";
						parent.parent.tempStorageFrame.tempStorageForm.second_name_oth_lang_temp.value = "";
						parent.parent.tempStorageFrame.tempStorageForm.third_name_oth_lang_temp.value = "";
						parent.parent.tempStorageFrame.tempStorageForm.family_name_oth_lang_temp.value = "";
						parent.parent.tempStorageFrame.tempStorageForm.name_suffix_oth_lang_temp.value = "";				
						parent.parent.tempStorageFrame.tempStorageForm.gender_temp.value = "";
						parent.parent.tempStorageFrame.tempStorageForm.contact_no_temp.value = "";
						parent.parent.tempStorageFrame.tempStorageForm.nationality_code_temp.value = "";
						parent.parent.tempStorageFrame.tempStorageForm.language_code_temp.value = "";
						parent.parent.tempStorageFrame.tempStorageForm.term_set_id.value = "";
						parent.parent.tempStorageFrame.tempStorageForm.linking_code.value = "";	
						parent.parent.tempStorageFrame.tempStorageForm.apptrefno.value = "";	
					}
					setTimeout('dummmmmmyyy()',1000);
					bbb_results(retVal)
				}
			}
		}
	}	

}

function dummmmmmyyy()
{
	
}

function bbb(pVal){
	var callingMode = '<%=callingMode%>';
	if(callingMode =="" || callingMode =="CA" || callingMode =="OR"){
		var ca_mode=document.forms[0].ca_mode.value;
		var ca_patient_id=document.forms[0].ca_patient_id.value;
		value12=document.forms[0].reason_for_revise.value;
		value13=document.forms[0].ref_no.value;
		var res_type=document.forms[0].res_type.value;
		var clinic_type=document.forms[0].clinic_type.value;
		var or_catalogue_code=document.forms[0].or_catalogue_code.value;
		var oper_stn_id=document.forms[0].oper_stn_id.value;
		var alcn_criteria=document.forms[0].alcn_criteria.value;
		var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
		var visit_limit_rule=document.forms[0].visit_limit_rule.value;
		var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
		var install_yn_val=document.forms[0].install_yn_val.value;
		var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
		var visit_flag_OP= document.forms[0].visit_flag_OP.value;
		var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value;
		var min_ela_per_resc_noshow_in_day= document.forms[0].min_ela_per_resc_noshow_in_day.value;
		var noshow_ctrl_by_splty_or_clinic= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
		var from_page= parent.frames[1].document.forms[0].from_page.value;
		var from_facility_id= parent.frames[1].document.forms[0].from_facility_id.value;
		var from_encounter_id= parent.frames[1].document.forms[0].from_encounter_id.value;
		var contact_num_reqd_yn=  parent.frames[1].document.forms[0].contact_num_reqd_yn.value; 
		var no_of_noshow_appts_for_alert=parent.frames[1].document.forms[0].no_of_noshow_appts_for_alert.value;
		var per_chk_for_no_show_alert=parent.frames[1].document.forms[0].per_chk_for_no_show_alert.value;
		var urls="../../eOA/jsp/SinglePractVw.jsp?clinic_code="+value1+"&practitioner_id="+value3+"&Date="+value5+"&value12="+value12+"&value13="+value13+"&old_date="+old_date+"&old_from_time="+document.forms[0].old_from_time.value+"&old_to_time="+document.forms[0].old_to_time.value+"&ca_patient_id="+ca_patient_id+"&ca_mode="+ca_mode+"&clinic_type="+clinic_type+"&res_type="+res_type+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&alcn_criteria="+alcn_criteria+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_page="+from_page+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&override_no_of_slots_yn="+override_no_of_slots_yn;
		parent.parent.frames[1].location.href=urls;
		}else{	
			if(pVal){
				parent.frames[2].document.location.reload();
				parent.window.returnValue=pVal;
			}			
		parent.window.close();
		}
}
function callBForced(pVal){
	var maxForced=document.forms[0].maxForced.value;
	var totForced=document.forms[0].totForced.value;
	var from_date=document.forms[0].appt_date.value;
	var sys_date=document.forms[0].sys_date.value;
	var calling_mode=document.forms[0].calling_mode.value;
	ext_slot=document.forms[0].p_o_ext_slot_status.value;
	var s_arr=ext_slot.split("|");
	if(document.forms[0].ForcedAllowed.value=='Y'){
		if(document.forms[0].P_O_TIME_TAB_TYPE.value!='2'){
			if(document.forms[0].refID.value=='N'){
				if(parseInt(maxForced)>0 && (parseInt(totForced)<parseInt(maxForced))){					
					if(document.forms[0].calling_mode.value =="") {
						if(document.forms[0].calling_mode_new.value ==""){
							if(Date.parse(from_date) == Date.parse(sys_date) ){
								if(document.forms[0].LocGlbChk.value=='Y'){
									alert(getMessage('FORCED_NOT_APPL','OA'));
								}else{
									if (s_arr[u1-1] != 'Y'){
										if(window.confirm(getMessage('CONFIRM_FORCED_BOOKING','OA'))){
											callBookAppointment('F',pVal);
										}
									}
								}
							}else{
								alert(getMessage('FORCED_BOOK_FUTURE_DATE','OA'));
							}
						}
					}
				}
			}
		}else{
			if(document.forms[0].refID.value=='N'){
				if(parseInt(maxForced)>0 && (parseInt(totForced)<parseInt(maxForced))){
					if(document.forms[0].calling_mode.value =="") {
						if(document.forms[0].calling_mode_new.value ==""){
							if(Date.parse(from_date) == Date.parse(sys_date) ){
								if(document.forms[0].LocGlbChk.value=='Y'){
									alert(getMessage('FORCED_NOT_APPL','OA'));
								}else{
									if (s_arr[u1-1] != 'Y'){
										if(window.confirm(getMessage('CONFIRM_FORCED_BOOKING','OA'))){
											callBookAppointment_results('F',pVal);
										}
									}
								}
							}else{
								alert(getMessage('FORCED_BOOK_FUTURE_DATE','OA'));
							}
						}
					}
				}
			}
		}
	}
}

function callBookAppointmentDetails_results(pVal){
	var maxForced=document.forms[0].maxForced.value;
	var totForced=document.forms[0].totForced.value;
	var from_date=document.forms[0].appt_date.value;
	var sys_date=document.forms[0].sys_date.value;
	var calling_mode=document.forms[0].calling_mode.value;
	var end_to_time=document.getElementById('results1').rows[u1].cells[1].innerText;
	ext_slot=document.forms[0].p_o_ext_slot_status.value;
	var s_arr=ext_slot.split("|");
	if(document.forms[0].P_O_TIME_TAB_TYPE.value!='2'){
		if(pVal=='F' || pVal=='NF'){
			if(pVal=='F'){
				callBookAppointmentDetailsDum_results('F');
			}else{
				callBookAppointmentDetailsDum_results('N');
			}			
		}else{
			if(document.forms[0].ForcedAllowed.value=='Y'){
				if(document.forms[0].refID.value=='N'){
					if(parseInt(maxForced)>0 && (parseInt(totForced)<parseInt(maxForced))){
						//The below conditions are added against HSA-SCF-0045 for calling_mode-RSCAPPT
						if(document.forms[0].calling_mode.value=="" ||document.forms[0].calling_mode.value == "RSCAPPT"){ 
							if(document.forms[0].calling_mode_new.value =="" ||document.forms[0].calling_mode_new.value == "RSCAPPT"){
								if(Date.parse(from_date) == Date.parse(sys_date) ){	
									if(document.forms[0].LocGlbChk.value=='Y' || end_to_time == "23:59"){
										//alert(getMessage('FORCED_NOT_APPL','OA'));
										callBookAppointmentDetailsDum_results('N');
									}else{
										if (s_arr[u1-1] != 'Y'){
											if(window.confirm(getMessage('CONFIRM_FORCED_BOOKING','OA'))){
												callBookAppointment_results('F');
											}else{
												callBookAppointmentDetailsDum_results('N');
											}
										}else{
											callBookAppointmentDetailsDum_results('N');
										}
									}
								}else{
									if(end_to_time != "23:59"){
									if(window.confirm(getMessage('FORCED_BOOK_FUTURE_DATE','OA'))){
									}else{
										callBookAppointmentDetailsDum_results('N');
									}
									}
									else{
										callBookAppointmentDetailsDum_results('N');
									}
								}
							}else{
								callBookAppointmentDetailsDum_results('F');
							}
						}else{
							callBookAppointmentDetailsDum_results('N');
						}
					}else{
						callBookAppointmentDetailsDum_results('N');
					}
				}else{
					callBookAppointmentDetailsDum_results('N');
				}
			}else{
				callBookAppointmentDetailsDum_results('N');
			}
		}
	}else{
		if(pVal=='F' || pVal=='NF'){
			if(pVal=='F'){
				callBookAppointmentDetailsDum_results('F');
			}else{
				callBookAppointmentDetailsDum_results('N');
			}			
		}else{
			if(pVal=='M'){
				if(document.forms[0].ForcedAllowed.value=='Y'){
					if(document.forms[0].refID.value=='N'){
						if(parseInt(maxForced)>0 && (parseInt(totForced)<parseInt(maxForced))){
							if(document.forms[0].calling_mode.value==""){
								if(document.forms[0].calling_mode_new.value ==""){
									if(Date.parse(from_date) == Date.parse(sys_date) ){
										if(document.forms[0].LocGlbChk.value=='Y' || end_to_time == "23:59" ){
											//alert(getMessage('FORCED_NOT_APPL','OA'));
											callBookAppointmentDetailsDum_results('N');
										}else{
											if (s_arr[u1-1] != 'Y'){
												if(window.confirm(getMessage('CONFIRM_FORCED_BOOKING','OA'))){
													callBookAppointment_results('F');
												}else{
													callBookAppointmentDetailsDum_results('N');
												}
											}else
											{
												callBookAppointmentDetailsDum_results('N');
											}
										}
									}else{
										if(end_to_time != "23:59"){
									if(window.confirm(getMessage('FORCED_BOOK_FUTURE_DATE','OA'))){
									}else{
										callBookAppointmentDetailsDum_results('N');
									}
									}else{
											callBookAppointmentDetailsDum_results('N');
										}
									}
								}else{
									callBookAppointmentDetailsDum_results('F');
								}
							}else{
								callBookAppointmentDetailsDum_results('N');
							}
						}else{
							callBookAppointmentDetailsDum_results('N');
						}
					}else{
						callBookAppointmentDetailsDum_results('N');
					}
				}else{
					callBookAppointmentDetailsDum_results('N');
				}
			}else{
				callBookAppointmentDetailsDum_results('N');
			}
		}			
	}
}

async function callBookAppointmentDetailsDum_results(pVal){
	old_date=document.forms[0].old_date.value;
	var book_appt_yn=document.forms[0].book_appt_yn.value;
	/*Added by Thamizh selvi on 16th July 2018 against ML-MMOH-CRF-1058 Start*/
	var isIncRemarksLengthAppl = "";
	if(document.forms[0].isIncRemarksLengthAppl)
		isIncRemarksLengthAppl = document.forms[0].isIncRemarksLengthAppl.value;
	/*End*/
	var book_appt_wo_pid_yn=document.forms[0].book_appt_wo_pid_yn.value;
	var obook_appt_yn=document.forms[0].obook_appt_yn.value;
	var book_appt_across_catg_yn=document.forms[0].book_appt_across_catg_yn.value;
	var tfr_appt_yn=document.forms[0].tfr_appt_yn.value;
	var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
	var canc_appt_yn=document.forms[0].canc_appt_yn.value;
	var alcn_criteria=document.forms[0].alcn_criteria.value;
	var pre_pat_alcn_catg_code=document.forms[0].pre_pat_alcn_catg_code.value;
	var Forced=pVal;
	var res_type=document.forms[0].res_type.value;
	var clinic_type=document.forms[0].clinic_type.value;
	var calling_mode=document.forms[0].calling_mode.value;
	//var from_page=document.forms[0].from_page.value;
	//alert("from_page=>" +from_page);
	if( value12.length > 0 && value11 != null ) value11=value13;
	//alert("val12"+value12)
	//	alert("val11"+value11)
	var retVal = 	new String();
	var dialogHeight= "100vh" ;
	var dialogTop = "75" ;
	var dialogWidth	= "75vw" ;
	/*Added by Thamizh selvi on 16th July 2018 against ML-MMOH-CRF-1058 Start*/
	if(isIncRemarksLengthAppl == "true")
		dialogHeight = "50" ;
	/*End*/
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var mode_find="";
	retVal = await top.window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+value11+"&i_clinic_code="+value1+"&i_practitioner_id="+value3+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&value13="+value12+"&over_booked="+value8+"&i_time_table_type="+value9+"&old_date="+old_date+"&old_from_time="+value14+"&pre_pat_alcn_catg_code="+pre_pat_alcn_catg_code+"&old_to_time="+value15+"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&Forced="+Forced+"&clinic_type="+clinic_type+"&calling_mode="+calling_mode+"&res_type="+res_type+"&wtListControl="+document.forms[0].wtListControl.value,arguments,features);
	var cc=retVal;
	if(retVal == null){
		retVal='close'
	}
	if(retVal == 'close')
		retVal="|";
	if(retVal == 'closed') retVal="|";
	if(retVal == '|') ;
	else{
		mode_find="dummy";
		setTimeout("aaa_results('"+mode_find+"');",1000);
	}
	if( cc == 'closed'){
		mode_find="dummy";
		setTimeout('aaa_results()',1000);
	}
}



async function callBookAppointmentDetails2_results()
{//alert('r3')
//alert("1400")
				var mode_find="";
				old_date=document.forms[0].old_date.value;
				var book_appt_yn=document.forms[0].book_appt_yn.value;
				var book_appt_wo_pid_yn=document.forms[0].book_appt_wo_pid_yn.value;
				var obook_appt_yn=document.forms[0].obook_appt_yn.value;
				var book_appt_across_catg_yn=document.forms[0].book_appt_across_catg_yn.value;
				var tfr_appt_yn=document.forms[0].tfr_appt_yn.value;
				var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
				var canc_appt_yn=document.forms[0].canc_appt_yn.value;
				var alcn_criteria=document.forms[0].alcn_criteria.value;
				var res_type=document.forms[0].res_type.value;
				var clinic_type=document.forms[0].clinic_type.value;
					var calling_mode=document.forms[0].calling_mode.value;
//					alert("Calling Mode=>" +calling_mode);
				if( value12.length > 0 && value11 != null ) value11=value13;
				var retVal = 	new String();
				var dialogHeight= "100vh" ;
				var dialogTop = "75" ;
				var dialogWidth	= "75vw" ;
				var center = "1" ;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				retVal = await top.window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+value11+"&i_clinic_code="+value1+"&i_practitioner_id="+value3+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&value13="+value12+"&over_booked="+value8+"&i_time_table_type="+value9+"&old_date="+old_date+"&flag=Visit_Reg&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&calling_mode="+calling_mode+"&clinic_type="+clinic_type+"&res_type="+res_type+"&wtListControl="+document.forms[0].wtListControl.value,arguments,features ,arguments,features);
				var cc=retVal;
//				alert("retVal==>" +retVal);
				if(retVal == 'close')
				retVal="|";
				if(retVal == 'closed') retVal="|";
				if(retVal == '|'){
//					alert("in 1431")
				mode_find="dummy";
				setTimeout("aaa_results('"+mode_find+"');",1000);
				}
				else{
				mode_find="dummy";
				setTimeout("aaa_results('"+mode_find+"');",1000);
				}
				if( cc == 'closed'){
				mode_find="dummy";
				setTimeout('aaa_results()',1000);
				}
	}

function aaa_results(mode_find){
	//	alert("mode_find==>" +mode_find);
	var ca_mode=document.forms[0].ca_mode.value;
	var ca_patient_id=document.forms[0].ca_patient_id.value;
	value12=document.forms[0].reason_for_revise.value;
	value13=document.forms[0].ref_no.value;
	var res_type=document.forms[0].res_type.value;
	var clinic_type=document.forms[0].clinic_type.value;
	var or_catalogue_code=document.forms[0].or_catalogue_code.value;
	var oper_stn_id=document.forms[0].oper_stn_id.value;
	var alcn_criteria=document.forms[0].alcn_criteria.value;
	var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
	var visit_limit_rule=document.forms[0].visit_limit_rule.value;
	var override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;
	var install_yn_val=document.forms[0].install_yn_val.value;
	var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
	var from_page= document.forms[0].from_page.value;
	//alert("from_page==>" +from_page)
	var visit_flag_OP= document.forms[0].visit_flag_OP.value;
	var capture_fin_dtls_yn=document.forms[0].capture_fin_dtls_yn.value;
	var min_ela_per_resc_noshow_in_day=document.forms[0].min_ela_per_resc_noshow_in_day.value;
	var noshow_ctrl_by_splty_or_clinic=document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
	var from_facility_id=document.forms[0].from_facility_id.value;
	var from_encounter_id= document.forms[0].from_encounter_id.value;
	var contact_num_reqd_yn=document.forms[0].contact_num_reqd_yn.value; 
	var no_of_noshow_appts_for_alert=document.forms[0].no_of_noshow_appts_for_alert.value;
	var per_chk_for_no_show_alert=document.forms[0].per_chk_for_no_show_alert.value;
	var rd_appt_yn=document.forms[0].rd_appt_yn.value;
	
	var urls="../../eOA/jsp/SinglePractVw.jsp?clinic_code="+value1+"&practitioner_id="+value3+"&Date="+value5+"&value12="+value12+"&value13="+value13+"&old_date="+old_date+"&old_from_time="+document.forms[0].old_from_time.value+"&old_to_time="+document.forms[0].old_to_time.value+"&pre_pat_alcn_catg_code="+document.forms[0].pre_pat_alcn_catg_code.value+"&mode_find="+mode_find+"&ca_patient_id="+ca_patient_id+"&ca_mode="+ca_mode+"&clinic_type="+clinic_type+"&res_type="+res_type+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&alcn_criteria="+alcn_criteria+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_page="+from_page+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&callingMode="+document.forms[0].calling_mode.value+"&rd_appt_yn="+rd_appt_yn;
	
	parent.parent.frames[1].location.href=urls;
}


function bbb_results(pVal){//alert("coming inside");
	var callingMode = document.forms[0].callingMode.value;
	var install_yn_val=document.forms[0].install_yn_val.value;
	var wtListControl =  document.forms[0].wtListControl.value;
	if(wtListControl=='B'){
		parent.window.close();
		// const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		// dialogTag.close();
	}else if(callingMode =="" || callingMode =="CA" || callingMode =="CA_WIDGET"){
		var ca_mode=document.forms[0].ca_mode.value;
		var ca_patient_id=document.forms[0].ca_patient_id.value;
		value12=document.forms[0].reason_for_revise.value;
		value13=document.forms[0].ref_no.value;
		var res_type=document.forms[0].res_type.value;
		var clinic_type=document.forms[0].clinic_type.value;
		var or_catalogue_code=document.forms[0].or_catalogue_code.value;
		var oper_stn_id=document.forms[0].oper_stn_id.value;
		var alcn_criteria=document.forms[0].alcn_criteria.value;
		var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
		var visit_limit_rule=document.forms[0].visit_limit_rule.value;
		var override_no_of_slots_yn =document.forms[0].override_no_of_slots_yn.value;
		var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
		var visit_flag_OP= document.forms[0].visit_flag_OP.value;
		var capture_fin_dtls_yn= document.forms[0].capture_fin_dtls_yn.value;
		var min_ela_per_resc_noshow_in_day= document.forms[0].min_ela_per_resc_noshow_in_day.value;
		var noshow_ctrl_by_splty_or_clinic= document.forms[0].noshow_ctrl_by_splty_or_clinic.value;
		var from_page= parent.frames[1].document.forms[0].from_page.value;
		var from_facility_id= parent.frames[1].document.forms[0].from_facility_id.value;
		var from_encounter_id= parent.frames[1].document.forms[0].from_encounter_id.value;
		var contact_num_reqd_yn=  parent.frames[1].document.forms[0].contact_num_reqd_yn.value; 
		var no_of_noshow_appts_for_alert=parent.frames[1].document.forms[0].no_of_noshow_appts_for_alert.value;
		var per_chk_for_no_show_alert=parent.frames[1].document.forms[0].per_chk_for_no_show_alert.value;
		var rd_appt_yn=parent.frames[1].document.forms[0].rd_appt_yn.value;
		var urls="../../eOA/jsp/SinglePractVw.jsp?clinic_code="+value1+"&practitioner_id="+value3+"&Date="+value5+"&value12="+value12+"&value13="+value13+"&old_date="+old_date+"&old_from_time="+document.forms[0].old_from_time.value+"&old_to_time="+document.forms[0].old_to_time.value+"&ca_patient_id="+ca_patient_id+"&ca_mode="+ca_mode+"&clinic_type="+clinic_type+"&res_type="+res_type+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&alcn_criteria="+alcn_criteria+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_page="+from_page+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&callingMode="+document.forms[0].calling_mode.value+"&rd_appt_yn="+rd_appt_yn;
		parent.parent.frames[1].location.href=urls;
	}else if(parent.parent.frames[0].document.forms[0].from_OR.value =="Y" && document.forms[0].ca_patient_id.value !="" && callingMode=="OR"){
		parent.frames[1].location.href='../../eCommon/html/blank.html';		
		parent.parent.frames[1].location.href='../../eOR/jsp/PendingOrdersSchedule.jsp';
		parent.parent.frames[0].selectTab('order_tab');
		parent.parent.frames[0].document.getElementById('day_tab').className="tabA";
		parent.parent.frames[0].document.getElementById('day_tabspan').className="tabAspan";
	}else if(parent.parent.frames[0].document.forms[0].from_OR.value =="Y" && callingMode=="OP" ){
		parent.frames[1].location.href='../../eCommon/html/blank.html';
		parent.parent.frames[0].location.href='../../eOA/jsp/DisplayPendingReferraltab.jsp?install_yn_val='+install_yn_val;
		parent.parent.frames[1].location.href='../../eMP/jsp/ReferralSearchFrameset.jsp?function_id=OA_PENDING_REFERRAL_BOOKING';
	}else{
		if(pVal){
			parent.frames[2].document.location.reload();
			//parent.window.returnValue=pVal; Commented Based on Mediciti Issue For book Appoinment through OP and below code added
			//if(callingMode=='OP_RV' || (parent.parent.frames[0].document.forms[0].from_OR.value =="N" && document.forms[0].ca_patient_id.value !=""  && callingMode!="OP")){
			if(callingMode=='OP_RV'){
			}else{
				parent.window.returnValue=pVal;
				// let dialogBody = parent.parent.document.getElementById('dialog-body');
				// dialogBody.contentWindow.returnValue = pVal;
			}//End of code added
		}
		parent.window.close();
		// const dialogTag = top.document.getElementById("dialog_tag");    
		// dialogTag.close();
	}
}

function scrollheader()
{
	
	 var x = document.body.scrollTop;
 // var x1=document.getElementById('divTitleTable').style.posTop;
  if(x == 0){
	  document.getElementById('labeldiv2').style.position='static';
	  document.getElementById('labeldiv2').style.posTop  = 0;
/*   document.getElementById('header').style.position='static';
   document.getElementById('header').style.posTop  = 0;  */
  }else
  {
		document.getElementById('labeldiv2').style.position = 'relative';
		document.getElementById('labeldiv2').style.posTop  = x-2;
	/*	document.getElementById('header').style.position = 'relative';
		document.getElementById('header').style.posTop  = x-2;  */
  }
}


function scrollTitle()
{
	var pageId = document.getElementById('page1');
	var mode='';
	if(pageId) 
		mode=pageId.value;
	else 
		mode='';
	
  var x = document.body.scrollTop;

  if(x == 0){
	 
 //  document.getElementById('header').style.position='static';
 //  document.getElementById('header').style.posTop  = 0;
  document.getElementById('head1').style.position='static';
   document.getElementById('head1').style.posTop  = 0;
   document.getElementById('head2').style.position='static';
   document.getElementById('head2').style.posTop  = 0;
   document.getElementById('head3').style.position='static';
   document.getElementById('head3').style.posTop  = 0;
   document.getElementById('head4').style.position='static';
   document.getElementById('head4').style.posTop  = 0;
   document.getElementById('head5').style.position='static';
   document.getElementById('head5').style.posTop  = 0;
   document.getElementById('head6').style.position='static';
   document.getElementById('head6').style.posTop  = 0;
   document.getElementById('head7').style.position='static';
   document.getElementById('head7').style.posTop  = 0;
   /*Below line added for this ML-MMOH-CRF-0606*/
   document.getElementById('head11').style.position='static';
   document.getElementById('head11').style.posTop  = 0;
   document.getElementById('head12').style.position='static';
   document.getElementById('head12').style.posTop  = 0;
   document.getElementById('head13').style.position='static';
   document.getElementById('head13').style.posTop  = 0;
   //End ML-MMOH-CRF-0606
   
   if(mode!="")
	  {
   document.getElementById('head8').style.position='static';
   document.getElementById('head8').style.posTop  = 0;
   document.getElementById('head9').style.position='static';
   document.getElementById('head9').style.posTop  = 0;
	  }
   
  }else{

	document.getElementById('head1').style.position = 'relative';
	document.getElementById('head1').style.posTop  = x-20;
	document.getElementById('head2').style.position = 'relative';
	document.getElementById('head2').style.posTop  = x-20;
	document.getElementById('head3').style.position = 'relative';
	document.getElementById('head3').style.posTop  = x-20;
	document.getElementById('head4').style.position = 'relative';
	document.getElementById('head4').style.posTop  = x-20;
	document.getElementById('head5').style.position = 'relative';
	document.getElementById('head5').style.posTop  = x-20;
	document.getElementById('head6').style.position = 'relative';
	document.getElementById('head6').style.posTop  = x-20;
	document.getElementById('head7').style.position = 'relative';
	document.getElementById('head7').style.posTop  = x-20;
	
	/*Below line added for this ML-MMOH-CRF-0606*/
	document.getElementById('head11').style.position = 'relative';
	document.getElementById('head11').style.posTop  = x-20;
	document.getElementById('head12').style.position = 'relative';
	document.getElementById('head12').style.posTop  = x-20;
	document.getElementById('head13').style.position = 'relative';
	document.getElementById('head13').style.posTop  = x-20;	 
	//End this CRF ML-MMOH-CRF-0606
	
	if(mode!="")
	  {
	document.getElementById('head8').style.position = 'relative';
	document.getElementById('head8').style.posTop  = x-20;
	document.getElementById('head9').style.position = 'relative';
	document.getElementById('head9').style.posTop  = x-20;
	  }
  }

}


/*******Date********/


function DateCheck_new(sys,from)
{
	//alert(" changed_date :"+parent.frames[0].document.forms[0].changed_date.value);
	//alert("valid_date :"+parent.frames[0].document.forms[0].valid_date.value);

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
			if(isBefore(sys,from1,'DMY',"en")==false)//localName is changed to en by Rameswar on 05-OCT-16 for Leap Year Issue
				{
				alert(getMessage("SCH_DATE_NOT_GREAT_TODAY","OA"));
				from.value="";
				from.select();
				document.forms[0].go.disabled=true;
				return false;
			}
			else
			{
				document.forms[0].go.disabled=false;
				PopDay();
				document.forms[0].go.focus();
				return true;
			}
		}
}else
	{
		document.forms[0].go.disabled=false;
			PopDay();
			return true;
	}

}



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
function show_patinstructions(appt_refno){
	var dialogHeight = "35" ;
	var dialogWidth	= "40" ;
	var dialogTop = "100" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var rd_appt_yn=parent.frames[0].document.forms[0].rd_appt_yn.value;
	window.showModalDialog("../../eOA/jsp/OAPatientInstructionsMain.jsp?appt_refno="+appt_refno+"&from_page=view_dtls&rd_appt_yn="+rd_appt_yn,arguments,features); //PMG20089-CRF-0885.3
}
/*added for Bru-HIMS-CRF-173*/
async function viewWaitList(obj){	
	var dialogHeight = "100vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop = "0" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	
	var url = "../../eOA/jsp/OAWaitListWrapper.jsp?clinnic_code="+document.forms[0].clinic.value+"&rd_appt_yn="+document.forms[0].rd_appt_yn.value+"&clinic_name_sec="+parent.frames[1].document.forms[0].clinic_name.value+"&wtListControl=V";
	await top.window.showModalDialog(url,arguments,features);
}


/*Below line Added for this CRF Bru-HIMS-CRF-191 [IN:030391]*/
function GroupappointmentSelect(pVal,refno){	
      
	  	var latter=document.getElementById('results1').rows[u1].cells[3].innerText ;
		value6= document.getElementById('results1').rows[u1].cells[u2].innerText;	
		value7=document.getElementById('results1').rows[u1].cells[u2+1].innerText;
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
		value9=document.forms[0].P_O_TIME_TAB_TYPE.value;	
		max_patients_per_slab=document.forms[0].max_patients_per_slab.value;	 			
    	
if(DateCompare4(document.forms[0].appt_date ,document.forms[0].sys_date)){ 									
		if((Date.parse(fromhtm) >= Date.parse(to_displayed))){
				alert(getMessage("FR_TIME_CAN_NOT_SYS_TIME","OA"));
        }else{
	   if(confirm(getMessage("GROUP_APPT","OA"))){
		    Groupappointment(pVal,refno);
	    }else{
		    moveNext_results(pVal,refno);		
	      }
	 }
  }else{
  if(confirm(getMessage("GROUP_APPT","OA"))){
		    Groupappointment(pVal,refno);
	    }else{
		    moveNext_results(pVal,refno);		
	      }
  }
	
}

async function Groupappointment(pVal,refno){ 
	 
	var latter=document.getElementById('results1').rows[u1].cells[3].innerText ;
	value1=document.forms[0].clinic_code.value;
	value2=document.forms[0].clinic_name.value;
	value3=document.forms[0].pract_id.value;
	value4=document.forms[0].pract_name.value;
	value5=document.forms[0].appt_date.value;
	value6= document.getElementById('results1').rows[u1].cells[u2].innerText;	
	//var timetabletype=document.forms[0].P_O_TIME_TAB_TYPE.value;
	//var oa_parm_check=document.forms[0].oa_parm_check.value;
	//var group_check=document.forms[0].group_check.value;
	
	
	
	var s = value6.substr(0,5); 
	value6 = s;	
	value7=document.getElementById('results1').rows[u1].cells[u2+1].innerText;
	value8=document.forms[0].over_booked.value;
	value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
	value10=document.forms[0].patient_id.value;
	var max_patients_per_slab=document.forms[0].max_patients_per_slab.value;
	
	//Start
	var res_type=document.forms[0].res_type.value;
	var clinic_type=document.forms[0].clinic_type.value;
	var or_catalogue_code=document.forms[0].or_catalogue_code.value;
	var order_id=document.forms[0].order_id.value;
	var order_line_num=document.forms[0].order_line_num.value;
	var order_catalog_code=document.forms[0].order_catalog_code.value;
	var create_wait_list_yn= document.forms[0].create_wait_list_yn.value;
	var entitlement_by_pat_cat_yn	= document.forms[0].entitlement_by_pat_cat_yn.value;
	var calling_mode	= document.forms[0].calling_mode.value;
	
	//End	 	

   
	var retVal		=    new String();
	var dialogHeight= "20";	
	var dialogWidth = "55";
//	var dialogTop	= "50";
	var center		= "1";
	var status		= "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status ;
	var arguments   = "" ;
	var getUrl = "../../eOA/jsp/AddModifyGroupAppointment.jsp?i_clinic_code="+value1+"&i_clinic_name="+encodeURIComponent(value2)+"&i_practitioner_id="+value3+"&i_practitioner_name="+encodeURIComponent(value4)+"&i_appt_date="+value5+"&i_from_time="+value6+"&i_to_time="+value7+"&i_time_table_type="+value9+"&i_patient_id="+value10+"&res_type="+res_type+"&clinic_type="+clinic_type+"&or_catalogue_code="+or_catalogue_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code+"&create_wait_list_yn="+create_wait_list_yn+"&entitlement_by_pat_cat_yn="+entitlement_by_pat_cat_yn+"&max_patients_per_slab="+max_patients_per_slab+"&calling_mode="+calling_mode;

	
	retVal = await window.showModalDialog(getUrl,arguments,features);
	
	if(retVal != null && retVal != ""){
		if(parent.window) parent.window.close();
		parent.parent.frames[1].location.reload();			
	}	
	
}
//End this CRF Bru-HIMS-CRF-191 [IN:030391]



/*Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]*/

async function show_order_select(pVal,refno,facilityid,cliniccode,apptstatus){ 

  
	 
	var latter=document.getElementById('results1').rows[u1].cells[3].innerText ;	
	value6= document.getElementById('results1').rows[u1].cells[u2].innerText;	
	var s = value6.substr(0,5); 
	value6 = s;	
	//value7=document.getElementById('results1').rows[u1].cells(u2+1).innerText;
	value7=document.getElementById('results1').rows[u1].cells[1].innerText;
	value8=document.forms[0].over_booked.value;
	value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
	value10=document.forms[0].patient_id.value;
	
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
	
	
	//End
	
	var Mode="Record";		
	
	if(!pVal) pVal='NO';	
	if(refno != ""){
		if(DateCompare4(document.forms[0].appt_date ,document.forms[0].sys_date)){									
				if(( Date.parse(fromhtm) >= Date.parse(to_displayed))){					
					Mode="View";
				}else if(apptstatus=="VT"){
				    Mode="View";
				}
    
          }
	}
	
   
	var retVal		=    new String();
	var dialogHeight= "70vh";	
	var dialogWidth = "60vw";
	var dialogTop	= "70";
	var center		= "1";
	var status		= "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	
	var getUrl = "../../eOR/jsp/ORApptRefCatalogAddModifyView.jsp?appt_ref_no="+refno+"&Mode="+Mode+"&facilityid="+facilityid+"&p_clinic_code="+cliniccode;		
	
	retVal = await top.window.showModalDialog(getUrl,arguments,features);     
	if(retVal != null && retVal != ""){
	
	}	
	
}
//End this CRF Bru-HIMS-CRF-165.1 [IN:035659]

