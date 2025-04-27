async function callBookAppointment(clinic_code,pract_id,start_time,end_time,time_table_type,clinic_type,prefPractYN,maxGlobalBooking,totalGlobalBooking){	
		var transfer_YN = document.rule_sch_appt_form.transfer_YN.value;
		document.rule_sch_appt_form.prefPractYN.value = prefPractYN;
		document.rule_sch_appt_form.clinic_type.value = clinic_type;
		document.rule_sch_appt_form.maxGlobalBooking.value = maxGlobalBooking;
		document.rule_sch_appt_form.totalGlobalBooking.value = totalGlobalBooking;
		if(transfer_YN != 'Y'){
			var clinic_date	= document.rule_sch_appt_form.prefdate.value;
			var oper_stn_id	= parent.querying.document.schedule_appointment.oper_stn_id.value;
			var from_page_new=parent.querying.document.schedule_appointment.from_page_new.value;
			var HTML="<html><body onKeyDown = 'lockKey()'><form name='rule_based_appt' id='rule_based_appt' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='rule_based_appt'><input type=hidden name='oper_stn_id' id='oper_stn_id' value='"+oper_stn_id+"'><input type=hidden name='clinic_code' id='clinic_code' value='"+clinic_code+"'><input type=hidden name='clinic_date' id='clinic_date' value='"+clinic_date+"'><input type=hidden name='pract_id' id='pract_id' value='"+pract_id+"'><input type=hidden name='start_time' id='start_time' value='"+start_time+"'><input type=hidden name='end_time' id='end_time' value='"+end_time+"'><input type=hidden name='time_table_type' id='time_table_type' value='"+time_table_type+"'><input type=hidden name='from_page_new' id='from_page_new' value='"+from_page_new+"'></form></body></html>";
			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
			parent.parent.messageFrame.document.rule_based_appt.submit();
		}else{
			var from_appt_date = parent.RuleBasedTransfer_criteria.document.forms[0].apptdate.value;
			var from_practitioner_id = parent.RuleBasedTransfer_criteria.document.forms[0].practitionerid.value;
			var from_clinic_code= parent.RuleBasedTransfer_criteria.document.forms[0].cliniccode.value;
			var fromTimeTableType = parent.RuleBasedTransfer_criteria.document.forms[0].time_table_type.value;
			var no_of_slots_value= parent.RuleBasedTransfer_criteria.document.forms[0].no_of_slots_value.value;
			var clinic_date	= document.rule_sch_appt_form.prefdate.value;
			//var oper_stn_id	= document.rule_sch_appt_form.oper_stn_id.value;
			var sys_date=document.rule_sch_appt_form.sys_date.value;
			var sys_time=document.rule_sch_appt_form.sys_time.value;			
			var day=document.rule_sch_appt_form.day.value;	
			var toTimeTableType = time_table_type;	
			var appt_date=clinic_date;			
			var systotime=sys_time.split(":");
			var tosystime=new Date(1,1,1,systotime[0],systotime[1],0,0);
			var apptfromtime=start_time.split(":");
			var appttotime=end_time.split(":");
			var fromappttime=new Date(1,1,1,apptfromtime[0],apptfromtime[1],0,0);
			var toappttime=new Date(1,1,1,appttotime[0],appttotime[1],0,0);
			var tfr_allowed = "N";
			if(compare_date(sys_date,appt_date)){		
				tfr_allowed = "Y";
			}else{
				if(compareDateEqual(appt_date,appt_date,sys_date)){
					if(toappttime<tosystime){
						tfr_allowed = "N";
						alert(getMessage('TRANS_TIME_IS_LESS_SYSTIME','OA'));
					}else{
						tfr_allowed = "Y";
					}
				}else{
					tfr_allowed = "N";
				}
			}
			if(fromTimeTableType =='1' && no_of_slots_value > 1){
				if(toTimeTableType == '2' || toTimeTableType == '3'){
					alert(getMessage('TRANS_NOT_FOR_MULTI_TO_OTHER','OA'));
					tfr_allowed = "N";
				}
			}				
			if(tfr_allowed == "Y"){
				var prefPractYN		= document.rule_sch_appt_form.prefPractYN.value;
				//var oper_stn_id	= document.rule_sch_appt_form.oper_stn_id.value;
				var appt_ref_no = parent.RuleBasedTransfer_criteria.document.forms[0].apptrefno.value;	
				var clinic_code =	clinic_code;
				var pract_id=pract_id;
				var appt_date	=clinic_date;				
				var old_date = from_appt_date;					
				var team_id = parent.RuleBasedTransfer_criteria.document.forms[0].team_id.value;		
				var visit_type_ind 	= parent.RuleBasedTransfer_criteria.document.forms[0].visit_type_ind.value;		
				var slot_appt_ctrl 	= document.forms[0].slot_appt_ctrl.value;
				var prefPractID		= document.rule_sch_appt_form.prefPractID.value;				
				var Forced = "N";
				var clinic_type = clinic_type;	
				var res_type = "P"
				var overbookedyn ="N";
				var over_booked="0";
				var alcn_criteria="";				 
				var call_transfer_flag="Y";
				var retVal = 	new String();
				var dialogHeight= "39" ;
				var dialogTop = "82" ;
				var dialogWidth	= "70" ;
				var dialogLeft   = "0";
				var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
				var arguments    = "" ;
		
				var patient_id= parent.RuleBasedTransfer_criteria.document.forms[0].patient_id.value;
				var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()
				xmlStr ="<root><SEARCH clinic_code=\""+clinic_code+"\" practitioner_id=\""+pract_id+"\" fromTime=\""+start_time+"\" no_of_slots=\""+no_of_slots_value+"\"  toTime=\""+end_time+"\" clinic_date=\""+appt_date+"\" visit_type_ind=\""+visit_type_ind+"\" slot_appt_ctrl=\""+slot_appt_ctrl+"\" appt_ref_no=\""+appt_ref_no+"\"   steps='1' calling_from='TRANSFER' function='RuleBasedTransfer' from_appt_date ='"+from_appt_date+"' from_practitioner_id ='"+from_practitioner_id+"' from_clinic_code ='"+from_clinic_code+"'/></root>";
				//alert(xmlStr)
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","VisitValidation.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				responseText = trimString(responseText)
				eval(responseText) 				
				if (responseText.length==2)
					call_transfer_flag="Y";
				else call_transfer_flag="N";
				if (parseInt(no_of_slots_value) < 0 || call_transfer_flag=="Y"){
					if (patient_id==""){
						//var Forced=document.forms[0].Forced.value;
						var url = "../../eOA/jsp/TransferAppointmentDetailsFrame.jsp?i_appt_ref_no="+appt_ref_no+"&i_clinic_code="+clinic_code+"&i_practitioner_id="+pract_id+"&i_appt_date="+appt_date+"&i_from_time="+start_time+"&i_to_time="+end_time+"&team_id="+team_id+"&over_booked="+over_booked+"&overbooked_yn="+overbookedyn+"&new_day="+day+"&i_time_table_type="+time_table_type+"&old_date="+old_date+"&Forced="+Forced+"&clinic_type="+clinic_type+"&res_type="+res_type+"&alcn_criteria="+alcn_criteria+"&sys_date="+sys_date+"&rule_based_tr=Y"+"&prefPractYN="+prefPractYN;
						retVal = await window.showModalDialog(url,arguments,features);
					}else{
						var xmlDoc = ""
						var xmlHttp = new XMLHttpRequest()
						xmlStr ="<root><SEARCH patient_id=\""+patient_id+"\"  fromTime=\""+start_time+"\"  toTime=\""+end_time+"\" clinic_date=\""+appt_date+"\" appt_ref_no=\""+appt_ref_no+"\" steps='4' alcn_criteria=\""+alcn_criteria+"\" res_type=\""+res_type+"\" clinic_type=\""+clinic_type+"\"  /></root>"
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
						xmlHttp.open("POST","VisitValidation.jsp",false)
						xmlHttp.send(xmlDoc)
						responseText=xmlHttp.responseText
						responseText = trimString(responseText)
						eval(responseText)
						if (responseText.length==2){
						//var Forced=document.forms[0].Forced.value;
						var url="../../eOA/jsp/TransferAppointmentDetailsFrame.jsp?i_appt_ref_no="+appt_ref_no+"&i_clinic_code="+clinic_code+"&i_practitioner_id="+pract_id+"&i_appt_date="+appt_date+"&i_from_time="+start_time+"&i_to_time="+end_time+"&new_day="+day+"&over_booked="+over_booked+"&team_id="+team_id+"&overbooked_yn="+overbookedyn+"&i_time_table_type="+time_table_type+"&old_date="+old_date+"&Forced="+Forced+"&clinic_type="+clinic_type+"&res_type="+res_type+"&alcn_criteria="+alcn_criteria+"&sys_date="+sys_date+"&rule_based_tr=Y"+"&prefPractYN="+prefPractYN;
						//alert(url)
						retVal = await window.showModalDialog(url,arguments,features);
						}
					}
					//alert('@ RulBasedAppointment :'+retVal)
				}
				if(retVal=='closed' && transfer_YN != 'Y'){
					parent.window.returnValue='closed';
					parent.window.close();
					parent.frames[2].location.reload();
				}else{
					window.close();
				}
			}
		}
}

function close_main_wind(){
	parent.window.returnValue='closed';
	parent.window.close();
	

}

function BookAppointmentModalWindow(clinic_code,pract_id,start_time,end_time,time_table_type){
	// OA PARAM Values
	var slot_appt_ctrl 					= document.rule_sch_appt_form.slot_appt_ctrl.value;
	var visit_limit_rule 				= document.rule_sch_appt_form.visit_limit_rule.value;
	var alcn_criteria 					= document.rule_sch_appt_form.alcn_criteria.value;
	var override_no_of_slots_yn 		= document.rule_sch_appt_form.override_no_of_slots_yn.value;
	var capture_fin_dtls_yn 			= document.rule_sch_appt_form.capture_fin_dtls_yn.value;
	var min_ela_per_resc_noshow_in_day 	= document.rule_sch_appt_form.min_ela_per_resc_noshow_in_day.value;
	var noshow_ctrl_by_splty_or_clinic 	= document.rule_sch_appt_form.noshow_ctrl_by_splty_or_clinic.value;
	var contact_num_reqd_yn 			= document.rule_sch_appt_form.contact_num_reqd_yn.value;
	var no_of_noshow_appts_for_alert 	= document.rule_sch_appt_form.no_of_noshow_appts_for_alert.value;
	var per_chk_for_no_show_alert 		= document.rule_sch_appt_form.per_chk_for_no_show_alert.value;
	var patient_id 						= document.rule_sch_appt_form.patient_id.value;
	var oper_stn_id 					= parent.querying.document.schedule_appointment.oper_stn_id.value;
	var speciality 						= parent.querying.document.schedule_appointment.speciality.value;
	var prefdate 						= document.rule_sch_appt_form.prefdate.value;
	var facility_id 					= document.rule_sch_appt_form.facility_id.value;
	var book_appt_yn 					= document.rule_sch_appt_form.book_appt_yn.value;
	var book_appt_wo_pid_yn 			= document.rule_sch_appt_form.book_appt_wo_pid_yn.value;
	var tfr_appt_yn 					= document.rule_sch_appt_form.tfr_appt_yn.value;
	var tfr_appt_across_catg_yn 		= document.rule_sch_appt_form.tfr_appt_across_catg_yn.value;
	var canc_appt_yn 					= document.rule_sch_appt_form.canc_appt_yn.value;
	var book_appt_across_catg_yn 		= document.rule_sch_appt_form.book_appt_across_catg_yn.value;
	var obook_appt_yn 					= document.rule_sch_appt_form.obook_appt_yn.value;
	var retVal 							= new String();
	var dialogHeight					= "43.2" ;
	var dialogTop 						= "83" ;
	var dialogWidth						= "65" ;
	var status 							= "no";
	var name_prefix_temp				= "";
	var first_name_temp					= "";
	var second_name_temp				= "";
	var third_name_temp					= "";
	var family_name_temp				= "";
	var name_suffix_temp            	= "";
	var name_prefix_oth_lang_temp       = "";
	var first_name_oth_lang_temp       	= "";
	var second_name_oth_lang_temp       = "";
	var third_name_oth_lang_temp        = "";
	var family_name_oth_lang_temp       = "";
	var name_suffix_oth_lang_temp       = "";
	var gender_temp						= document.rule_sch_appt_form.gender.value;
	var contact_no_temp					= document.rule_sch_appt_form.contact_no.value;
	var i_over_booked					= "N";
	var i_time_table_type				= time_table_type;
	var create_wait_list_yn				= parent.querying.document.schedule_appointment.create_wait_list_yn.value;
	var visit_flag_OP					= parent.querying.document.schedule_appointment.visit_flag_OP.value;
	var callingMode						= parent.querying.document.schedule_appointment.callingMode.value;
	var prefPractYN						= document.rule_sch_appt_form.prefPractYN.value;
	var rule_appl_yn 					= parent.querying.document.schedule_appointment.rule_appl_yn.value;
	var nationality_code_temp 			= document.rule_sch_appt_form.nationality_code.value;
	var language_code_temp 				= document.rule_sch_appt_form.language_code.value;
	var term_set_id 					= document.rule_sch_appt_form.term_set_id.value;
	var linking_code 					= document.rule_sch_appt_form.linking_code.value;
	var order_id 						= document.forms[0].order_id.value;
	var order_line_num  				= document.forms[0].order_line_num.value;
	var order_catalog_code				= document.forms[0].order_catalog_code.value;
	var clinic_type						= document.forms[0].clinic_type.value;	
	if(document.rule_sch_appt_form.name_prefix)
		name_prefix_temp = document.rule_sch_appt_form.name_prefix.value;
	if(document.rule_sch_appt_form.first_name)
		first_name_temp = document.rule_sch_appt_form.first_name.value;
	if(document.rule_sch_appt_form.second_name)
		second_name_temp = document.rule_sch_appt_form.second_name.value;
	if(document.rule_sch_appt_form.third_name)
		third_name_temp = document.rule_sch_appt_form.third_name.value;
	if(document.rule_sch_appt_form.family_name)
		family_name_temp = document.rule_sch_appt_form.family_name.value;
	if(document.rule_sch_appt_form.name_suffix)
		name_suffix_temp = document.rule_sch_appt_form.name_suffix.value;
		
	if(document.rule_sch_appt_form.name_prefix_oth_lang)
		name_prefix_oth_lang_temp = document.rule_sch_appt_form.name_prefix_oth_lang.value;
	if(document.rule_sch_appt_form.first_name_oth_lang)
		first_name_oth_lang_temp = document.rule_sch_appt_form.first_name_oth_lang.value;
	if(document.rule_sch_appt_form.second_name_oth_lang)
		second_name_oth_lang_temp = document.rule_sch_appt_form.second_name_oth_lang.value;
	if(document.rule_sch_appt_form.third_name_oth_lang)
		third_name_oth_lang_temp = document.rule_sch_appt_form.third_name_oth_lang.value;
	if(document.rule_sch_appt_form.family_name_oth_lang)
		family_name_oth_lang_temp = document.rule_sch_appt_form.family_name_oth_lang.value;
	if(document.rule_sch_appt_form.name_suffix_oth_lang)
		name_suffix_oth_lang_temp = document.rule_sch_appt_form.name_suffix_oth_lang.value;

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var callurl="../../eOA/jsp/BookAppointment.jsp?i_clinic_code="+clinic_code+"&i_clinic_name=&i_practitioner_id="+pract_id+"&i_practitioner_name=&i_appt_date="+prefdate+"&i_from_time="+start_time+"&i_to_time="+end_time+"&i_over_booked="+i_over_booked+"&i_time_table_type="+i_time_table_type+"&i_patient_id="+patient_id+"&book_appt_across_catg_yn="+book_appt_across_catg_yn+"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&Forced=N&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&obvisit_flag=&ca_patient_id="+patient_id+"&patient_id_temp="+patient_id+"&name_prefix_temp="+encodeURIComponent(name_prefix_temp,'UTF-8')+"&first_name_temp="+encodeURIComponent(first_name_temp,'UTF-8')+"&second_name_temp="+encodeURIComponent(second_name_temp,'UTF-8')+"&third_name_temp="+encodeURIComponent(third_name_temp,'UTF-8')+"&family_name_temp="+encodeURIComponent(family_name_temp,'UTF-8')+"&name_suffix_temp="+encodeURIComponent(name_suffix_temp,'UTF-8')+"&name_prefix_oth_lang_temp="+encodeURIComponent(name_prefix_oth_lang_temp,'UTF-8')+"&first_name_oth_lang_temp="+encodeURIComponent(first_name_oth_lang_temp,'UTF-8')+"&second_name_oth_lang_temp="+encodeURIComponent(second_name_oth_lang_temp,'UTF-8')+"&third_name_oth_lang_temp="+encodeURIComponent(third_name_oth_lang_temp,'UTF-8')+"&family_name_oth_lang_temp="+encodeURIComponent(family_name_oth_lang_temp,'UTF-8')+"&name_suffix_oth_lang_temp="+encodeURIComponent(name_suffix_oth_lang_temp,'UTF-8')+"&gender_temp="+gender_temp+"&contact_no_temp="+contact_no_temp+"&clinic_type="+clinic_type+"&res_type=P&or_catalogue_code=&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code+"&oper_stn_id="+oper_stn_id+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id=&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&from_page1=&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+facility_id+"&from_encounter_id=&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&rule_based_tr=Y&prefPractYN="+prefPractYN+"&rule_appl_yn="+rule_appl_yn+"&nationality_code_temp="+nationality_code_temp+"&language_code_temp="+language_code_temp+"&term_set_id="+term_set_id+"&linking_code="+linking_code;
	var bookApptFlag = true;
	if(document.forms[0].global_locn_yn.value=='Y'){
		if(document.forms[0].global_book_appt_yn.value=='Y'){
			if(parseInt(document.forms[0].maxGlobalBooking.value) >0 ){
				if(parseInt(document.forms[0].totalGlobalBooking.value) < parseInt(document.forms[0].maxGlobalBooking.value)){
					callurl=callurl+"&Global=Y";
				}else{
					alert(getMessage('GLOBAL_BOOKING_OVER','OA'));
					bookApptFlag = false;
				}
			}else{
				alert(getMessage('GLOBAL_NOT_SCHEDULE','OA'));
				bookApptFlag = false;
			}
		}else{
			alert(getMessage('GLOBAL_NOT_USER','OA'));
			bookApptFlag = false;
		}
	}else{
		bookApptFlag =true;
	}
	if(bookApptFlag){
	retVal = parent.querying.window.showModalDialog(callurl,arguments,features);
	if(!(retVal == 'abort' || retVal == undefined)){
		if((parent.querying.document.forms[0] && (parent.querying.document.forms[0].callingMode.value == 'OP' && parent.querying.document.forms[0].from_AE.value == 'N'))){
			//parent.frames[2].document.location.reload();
			window.returnValue=retVal;
			window.close();
		}else if((parent.querying.document.forms[0] && ((parent.querying.document.forms[0].callingMode.value == 'OR' && parent.querying.document.forms[0].from_AE.value == 'N') && parent.querying.document.forms[0].from_OR.value == "N"))){
			window.returnValue=retVal;
			window.close();
		}else{
			var url ='../../eOA/jsp/ScheduleAppointment.jsp?callingMode='+callingMode+'&create_wait_list_yn='+create_wait_list_yn+'&visit_flag_OP='+visit_flag_OP;
			parent.querying.location.href = url;
			parent.dummy.location.href="../../eCommon/html/blank.html";
			parent.result.location.href="../../eCommon/html/blank.html";
			}
		}
	}
}

function compareDateEqual(from,to,sys)
{	
	

	if(from!="" && to!="" )
		{

	
	if(isBetween(from, to, sys,'DMY',localeName)==true)
	{
		
	return true;
	}
	else
			{
		
		return false;
			}
	
}
}

function compare_date(sys,to)
{
	
	
if(sys!="" && to!="" )
		{
			
			if(isBefore(sys,to,'DMY',localeName))
				{
					
					if(isBetween(to, to, sys,'DMY',localeName)==true)
		{
		
		return false;
		}
		else
			{
		
		return true;
			}
				
				
			}
			else
			{
				
				return false;
				
				
			}
		}
}

function CheckTime(obj,valt){
	var timefield = obj;
	if (obj.value!=""){
		var timefield = obj;
		var val1;
		if(chkTime(obj.value) == false){
			alert(getMessage("INVALID_TIME_FMT","SM"));
			timefield.select();
			timefield.focus();
			return false;
		}else{
			// Added the below code for IN032011 by Suresh M on 27.03.2012
			if(document.forms[0].From_timeval.value!="" && document.forms[0].To_timeval.value){			
				var frmTime = Date.parse('27 Mar 2012 ' +document.forms[0].From_timeval.value);
				var toTime = Date.parse('27 Mar 2012 ' +document.forms[0].To_timeval.value);					 
				if(frmTime > toTime){				 
					alert(getMessage("FM_TIME_GR_TO_TIME","Common"));					 
					document.forms[0].To_timeval.select();
					document.forms[0].To_timeval.focus();
				}		
			} // Ends
		}
	}
}

function formatTimePerPatient(obj){
	if (obj.value.length == 2){
		if (obj.value.substring(1,2) == ':'){
			obj.value = '0' + obj.value ;
		}
	}
	if (obj.value.length == 3){
		if (obj.value.substring(0,1) == ':'){
			obj.value = '00' + obj.value ;
		}
	}
}

function chkTime(time1){
	var retval=true;
	if( (time1.charAt(time1.length-1) )!=":"){
		var time1arr=new Array()
		time1arr=time1.split(":")
		if(time1arr.length==2){
			var time1hr=time1arr[0]
			var time1min=time1arr[1]
			time1hr=parseInt(time1hr)
			time1min=parseInt(time1min)
			if(time1hr<=23){
				if(time1min>59){
					retval=false;
				}
			}else{
				retval=false;
			}
		}else{
			retval=false;
		}
	}else{
		retval=false;
	}
	return retval
}

function checkDateAlert(obj)
{	
			var obj1=obj.value;		
			if(obj1 != "")
			{	
				if(!isAfterNow(obj1,"DMY", localeName))
				{
				//  alert(getMessage("DATE_GT_EQ_SYS_DATE",'FM'));
				alert(getMessage("PREF_FM_DT_VALIDATION","OA"));
				  obj.focus();
				  obj.value="";
				}
			}	
  }

  

  function clearFields(){
	  document.RuleBasedTransfer_criteria.pref_date.value="";
	  document.RuleBasedTransfer_criteria.From_timeval.value="";
	  document.RuleBasedTransfer_criteria.To_timeval.value="";
	  parent.RuleBasedTransfer_result.location.href='../../eCommon/html/blank.html';
  }
  async function open_loc_lookup_rule(){
    var location_val=document.forms[0].b_loc_val.value;
	var locn_type=document.forms[0].locn_type.value;
	var care_locn_ind=document.forms[0].locn_type.value;
	var specialty=document.forms[0].specialty.value;
	var dialogTop = "60" ;
	var dialogHeight= "37" ;
	var dialogWidth	= "60" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var retVal="";
	var url ="../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&speciality_code="+specialty+"&function_id=SCH_APPT";
	retVal = await window.showModalDialog(url,arguments,features);
	if(retVal!=null){	
		var rvalues=retVal.split("~");
		var clinic_code=rvalues[0];
		var desc=rvalues[1];
		var open_to_all_pract_yn=rvalues[2];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].clinic.value=clinic_code;
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].clinic.value="";
	}

}
function ena_loc_lookup_rule(obj){	
	if(obj.value==null || obj.value==''){
		document.forms[0].b_loc_val.value="";
	    document.forms[0].clinic.value="";
	}else{
		open_loc_lookup_rule()
	}
}

function specialtyChange(){
	document.forms[0].clinic.value="";
	document.forms[0].b_loc_val.value="";
	//document.forms[0].locn_type.value="";
}

function locnChange(){
	document.forms[0].clinic.value="";
	document.forms[0].b_loc_val.value="";
}

function getRuleBasedResult(){
		var patient_id			= document.RuleBasedTransfer_criteria.patient_id.value;
		var speciality_code		= document.RuleBasedTransfer_criteria.specialty.value;
		var prefdate1			= document.RuleBasedTransfer_criteria.pref_date.value;
		var From_timeval		= document.RuleBasedTransfer_criteria.From_timeval.value;
		var To_timeval			= document.RuleBasedTransfer_criteria.To_timeval.value; 
		var clinic_code 		= document.RuleBasedTransfer_criteria.clinic.value;
		var term_set_id			= document.RuleBasedTransfer_criteria.term_set_id.value;
		var linking_code		= document.RuleBasedTransfer_criteria.linking_code.value; 
		var language_code 		= document.RuleBasedTransfer_criteria.language_code.value;
		var sys_date			= document.RuleBasedTransfer_criteria.sys_date.value;
		var order_catalog_code	= document.RuleBasedTransfer_criteria.order_catalog_code.value;
		var care_locn_ind		= document.RuleBasedTransfer_criteria.locnType.value;
		if(prefdate1 == "" || From_timeval == "" || To_timeval == ""){
			var error = getMessage("PREF_DATE_TIME","OA");
			alert(error)
			return;
		}else{
			var prefDate_is_sysDate = "N";
			if(prefdate1 == sys_date){
				prefDate_is_sysDate = 'Y';
			}
			var url="../../eOA/jsp/RuleScheduleResultMain.jsp?speciality="+speciality_code+"&care_locn_ind="+care_locn_ind+"&prefdate1="+prefdate1+"&From_timeval="+From_timeval+"&To_timeval="+To_timeval+"&transfer_YN=Y&clinic_code="+clinic_code+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&language_code="+language_code+"&prefDate_is_sysDate="+prefDate_is_sysDate+"&order_catalog_code="+order_catalog_code+"&patient_id="+patient_id;
			parent.RuleBasedTransfer_result.location.href=url;
		}
  }

