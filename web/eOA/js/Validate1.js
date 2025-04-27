var u=0;
var v=0;
function moveBack(){	
	setTimeout('bbb()',500);
}

function bbb(){		
	var or_catalogue_code="";
	var clinic=parent.parent.frames[1].document.forms[0].clinic1.value;
	var practitioner=parent.parent.frames[1].document.forms[0].practitioner1.value;
	var speciality=parent.parent.frames[1].document.forms[0].speciality1.value;
	var  visittype=parent.parent.frames[1].document.forms[0].visittype1.value
	var oper_stn_id=parent.parent.frames[1].document.forms[0].oper_stn_id.value
	var end_date=parent.parent.frames[1].document.forms[0].p_to.value;
	var Date=parent.parent.frames[1].document.forms[0].p_from.value;
	var practitioner_type=parent.parent.frames[1].document.forms[0].practitioner_type1.value;	
	var pref_start_date=parent.parent.frames[1].document.forms[0].prefdate1.value;
	var pref_end_date=parent.parent.frames[1].document.forms[0].prefenddate1.value;
	var call_date_yn = parent.parent.frames[1].document.forms[0].call_date_yn.value;
	var call_date_yn = parent.parent.frames[1].document.forms[0].call_date_yn.value;
	var start_sch_date = parent.parent.frames[1].document.forms[0].start_sch_date.value;	
	var disp_ear_sch="";
	if (parent.parent.frames[1].document.forms[0].disp_next.checked==true)
		disp_ear_sch="Y";
	else
		disp_ear_sch ="N";
	var trker=parent.parent.frames[1].document.forms[0].fromTracker.value;	
	var ca_patient_id= parent.parent.frames[1].document.forms[0].ca_patient_id.value;			
	var hddSpeclty=parent.parent.frames[1].document.forms[0].hddSpeciality.value;
	var callingMode = parent.parent.frames[1].document.forms[0].callingMode.value;
	var from_OR = parent.parent.frames[1].document.forms[0].from_OR.value;//Maheshwaran K added as on 27/02/2014
	var ca_md=parent.parent.frames[1].document.forms[0].ca_mode.value
	var order_id=parent.parent.frames[1].document.forms[0].order_id.value;
	var order_line_num=parent.parent.frames[1].document.forms[0].order_line_num.value;
	var order_catalog_code=parent.parent.frames[1].document.forms[0].order_catalog_code.value;
	var specialty_codema1 =parent.parent.frames[1].document.forms[0].specialty_codema1.value;
	parent.arrows.document.forms[0].forward.disabled=false;
	 if(trker==''){
		//Condition Added  by Jithesh on 18-Nov-03 to handle from  CA 
		if(ca_md != '' ){
			top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}else{
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
	 }
	var care_locn_ind=parent.parent.frames[1].document.forms[0].location_type.value;
	var res_class=parent.parent.frames[1].document.forms[0].resourceType1.value;		
	if(parent.parent.frames[1].document.forms[0].or_catalogue_code){
		or_catalogue_code=parent.parent.frames[1].document.forms[0].or_catalogue_code.value;
	}
	var create_wait_list_yn= parent.parent.frames[1].document.forms[0].create_wait_list_yn.value; 
	var visit_flag_OP= parent.parent.frames[1].document.forms[0].visit_flag_OP.value; 
	var from_page= parent.parent.frames[1].document.forms[0].from_page.value; 
	var from_facility_id= parent.parent.frames[1].document.forms[0].from_facility_id.value; 
	var from_encounter_id= parent.parent.frames[1].document.forms[0].from_encounter_id.value; 
	var install_yn_val=parent.parent.frames[1].document.forms[0].install_yn_val.value;
	pref_start_date=convertDate(pref_start_date,"DMY",localeName,"en");//@UAT-3
	pref_end_date=convertDate(pref_end_date,"DMY",localeName,"en");//@UAT-3
	var rd_appt_yn="N"
	if(parent.parent.frames[1].document.forms[0].rd_oa_integration_yn.value=="Y"){	
		if(parent.parent.frames[1].document.forms[0].rd_appt_yn.checked){
			rd_appt_yn ="Y";
		}else{
			rd_appt_yn ="N";
		}
	}
	//Maheshwaran K added 'from_OR' as on 27/02/2014
	var url="../../eOA/jsp/ScheduleResult.jsp?week=no&month=yes&days=no&clinic="+clinic+"&practitioner="+practitioner+"&visittype="+visittype+"&oper_stn_id="+oper_stn_id+"&Date="+Date+"&end_date="+end_date+"&speciality="+speciality+"&call_date_yn="+call_date_yn+"&pref_start_date="+pref_start_date+"&pref_end_date="+pref_end_date+"&practitioner_type="+practitioner_type+"&Difference=-1"+"&start_sch_date="+start_sch_date+"&from_OR="+from_OR+"&callingMode="+callingMode+"&hddSpeclty="+hddSpeclty+"&ca_patient_id="+ca_patient_id+"&ca_mode="+ca_md+"&care_locn_ind="+care_locn_ind+"&res_class="+res_class+"&or_catalogue_code="+or_catalogue_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code+"&specialty_codema1="+specialty_codema1+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&from_page="+from_page+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&install_yn_val="+install_yn_val+"&rd_appt_yn="+rd_appt_yn;
	parent.frames[1].location.href=url;
	parent.frames[2].location.href="../../eOA/jsp/CheckBoxDisplay.jsp"
			
}
	
	
function moveForward(){
	setTimeout('aaa()',500);
}

function aaa(){	
	var or_catalogue_code="";
	var clinic=parent.parent.frames[1].document.forms[0].clinic1.value;
	var practitioner=parent.parent.frames[1].document.forms[0].practitioner1.value;
	var speciality=parent.parent.frames[1].document.forms[0].speciality1.value;
	var visittype=parent.parent.frames[1].document.forms[0].visittype1.value
	var oper_stn_id=parent.parent.frames[1].document.forms[0].oper_stn_id.value
	var end_date=parent.parent.frames[1].document.forms[0].p_to.value;
	var Date=parent.parent.frames[1].document.forms[0].p_from.value;
	var practitioner_type=parent.parent.frames[1].document.forms[0].practitioner_type1.value;	
	var pref_start_date=parent.parent.frames[1].document.forms[0].prefdate1.value;
	var pref_end_date=parent.parent.frames[1].document.forms[0].prefenddate1.value;
	var start_sch_date=parent.parent.frames[1].document.forms[0].start_sch_date.value;
	var call_date_yn = parent.parent.frames[1].document.forms[0].call_date_yn.value;
	var order_id=parent.parent.frames[1].document.forms[0].order_id.value;
	var order_line_num=parent.parent.frames[1].document.forms[0].order_line_num.value;
	var order_catalog_code=parent.parent.frames[1].document.forms[0].order_catalog_code.value;
	var specialty_codema1 =parent.parent.frames[1].document.forms[0].specialty_codema1.value;			
	var trker=parent.parent.frames[1].document.forms[0].fromTracker.value;
	var ca_patient_id= parent.parent.frames[1].document.forms[0].ca_patient_id.value;
	var hddSpeclty=parent.parent.frames[1].document.forms[0].hddSpeciality.value;
	var callingMode = parent.parent.frames[1].document.forms[0].callingMode.value;
	var from_OR = parent.parent.frames[1].document.forms[0].from_OR.value;//Maheshwaran K added as on 27/02/2014
	var ca_md=parent.parent.frames[1].document.forms[0].ca_mode.value;
	var install_yn_val=parent.parent.frames[1].document.forms[0].install_yn_val.value;
	if(trker=='') {
		//Condition Added  by Jithesh on 18-Nov-03 to handle from  CA 
		if(ca_md != '' ){
				top.content.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}else{
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
	}		
	var care_locn_ind=parent.parent.frames[1].document.forms[0].location_type.value;	
	var res_class=parent.parent.frames[1].document.forms[0].resourceType1.value;
	if(parent.parent.frames[1].document.forms[0].or_catalogue_code){
		or_catalogue_code=parent.parent.frames[1].document.forms[0].or_catalogue_code.value;
	}
	var create_wait_list_yn= parent.parent.frames[1].document.forms[0].create_wait_list_yn.value; 
	var visit_flag_OP= parent.parent.frames[1].document.forms[0].visit_flag_OP.value;
	var from_page= parent.parent.frames[1].document.forms[0].from_page.value; 
	var from_facility_id= parent.parent.frames[1].document.forms[0].from_facility_id.value; 
	var from_encounter_id= parent.parent.frames[1].document.forms[0].from_encounter_id.value;
	pref_start_date=convertDate(pref_start_date,"DMY",localeName,"en");//@UAT-3
	pref_end_date=convertDate(pref_end_date,"DMY",localeName,"en");//@UAT-3
	var rd_appt_yn="N"
	if(parent.parent.frames[1].document.forms[0].rd_oa_integration_yn.value=="Y"){	
		if(parent.parent.frames[1].document.forms[0].rd_appt_yn.checked){
			rd_appt_yn ="Y";
		}else{
			rd_appt_yn ="N";
		}
	}
	//Maheshwaran K added 'from_OR' as on 27/02/2014
	var url="../../eOA/jsp/ScheduleResult.jsp?week=no&month=yes&days=no&clinic="+clinic+"&practitioner="+practitioner+"&visittype="+visittype+"&oper_stn_id="+oper_stn_id+"&Date="+Date+"&end_date="+end_date+"&practitioner_type="+practitioner_type+"&speciality="+speciality+"&call_date_yn="+call_date_yn+"&pref_start_date="+pref_start_date+"&pref_end_date="+pref_end_date+"&Difference=1"+"&start_sch_date="+start_sch_date+"&from_OR="+from_OR+"&callingMode="+callingMode+"&hddSpeclty="+hddSpeclty+"&ca_patient_id="+ca_patient_id+"&ca_mode="+ca_md+"&care_locn_ind="+care_locn_ind+"&res_class="+res_class+"&or_catalogue_code="+or_catalogue_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code+"&specialty_codema1="+specialty_codema1+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&from_page="+from_page+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&install_yn_val="+install_yn_val+"&rd_appt_yn="+rd_appt_yn;
	parent.frames[1].location.href=url;			
}

function assign(){
	alert("in validate1 line 138");
	if (parent.frames[1].document.forms[2] != null){
		parent.parent.frames[1].document.forms[0].prefenddate.value=parent.frames[1].document.forms[2].p_to.value;
	}
	if (parent.frames[1].document.forms[2] != null){
		parent.parent.frames[1].document.forms[0].prefdate.value=parent.frames[1].document.forms[2].p_from.value;
	}
}
var u=null;
var u1=0;
var t=0;
var u2=0;
var o=0;
var arr1=new Array() ;
var v=new Array();

function aaa1(Obj){
	t=Obj.rowIndex;
	u1=t-1;
}

function bbb1(Obj){
	u2=Obj.cellIndex;
}

function scrollTitle(obj){
		alert("in validate1 line 164");
	var x = document.body.scrollTop;
	var x1=document.getElementById("divTitleTable").style.posTop;
	if(x == 0){
		document.getElementById("divTitleTable").style.position = 'static';
		document.getElementById("divTitleTable").style.posTop  = 0;
	}else{
		document.getElementById("divTitleTable").style.position = 'relative';
		document.getElementById("divTitleTable").style.posTop  = x-5;
	}
}



function anyCheck(form){
	var total = 0;
	var max = document.forms[1].counter.value;
	var t=0;
	for (var idx = 0; idx < max; idx++) {
	if (eval("document.forms[1].check"+idx+".checked") == true) {
		total=total+1;
    	u=idx;
    	o++;
    	t="  "+t;
    	}
   	t++;
   }
   if(total > 3) {
		var h=parseInt(u);
		eval("document.forms[1].check"+u).checked=false;
		alert(getMessage('PRACT_SELECT_VALIDATION','OA'));
   }
}

function moveNext(obj,obj1,obj2,obj3,obj4){
	// passing the patient values when rele based is applicable Starts
		var rule_appl_yn	="";
		var patient_id		="";
		var name_prefix		="";
		var first_name		="";
		var second_name		="";
		var third_name		="";
		var family_name		="";
		var name_suffix="";
		var name_prefix_oth_lang="";	
		var first_name_oth_lang="";
		var second_name_oth_lang="";
		var third_name_oth_lang="";
		var family_name_oth_lang="";
		var name_suffix_oth_lang="";
		var gender			="";
		var contact_no		="";
		var nationality_code="";
		var language_code	="";
		var term_set_id		="";
		var linking_code	="";
		rule_appl_yn = parent.parent.querying.document.schedule_appointment.rule_appl_yn.value;
		if(rule_appl_yn =="Y"){
			if(document.calender3.patient_id_temp){
				patient_id = document.calender3.patient_id_temp.value;
			}
			if(document.calender3.name_prefix){
				name_prefix = encodeURIComponent(document.calender3.name_prefix.value);
			}
			if(document.calender3.first_name){
				first_name = encodeURIComponent(document.calender3.first_name.value);
			}
			if(document.calender3.second_name){
				second_name = encodeURIComponent(document.calender3.second_name.value);
			}
			if(document.calender3.third_name){
				third_name = encodeURIComponent(document.calender3.third_name.value);
			}
			if(document.calender3.family_name){
				family_name = encodeURIComponent(document.calender3.family_name.value);
			}
			
			
			if(document.calender3.name_suffix){
				name_suffix=encodeURIComponent(document.calender3.name_suffix.value);
			}
			
			if(document.calender3.name_prefix_oth_lang){
				name_prefix_oth_lang=encodeURIComponent(document.calender3.name_prefix_oth_lang.value);
			}
			if(document.calender3.first_name_oth_lang){
				first_name_oth_lang = encodeURIComponent(document.calender3.first_name_oth_lang.value);
			}
			if(document.calender3.second_name_oth_lang){
				second_name_oth_lang = encodeURIComponent(document.calender3.second_name_oth_lang.value);
			}
			if(document.calender3.third_name_oth_lang){
				third_name_oth_lang = encodeURIComponent(document.calender3.third_name_oth_lang.value);
			}
			if(document.calender3.family_name_oth_lang){
				family_name_oth_lang = encodeURIComponent(document.calender3.family_name_oth_lang.value);
			}
			if(document.calender3.name_suffix_oth_lang){
				name_suffix_oth_lang = encodeURIComponent(document.calender3.name_suffix_oth_lang.value);
			}
			if(document.calender3.gender){
				gender = document.calender3.gender.value;
			}
			if(document.calender3.contact_no){
				contact_no = document.calender3.contact_no.value;
			}
			if(document.calender3.nationality_code_temp){
				nationality_code= document.calender3.nationality_code_temp.value;
			}
			if( document.calender3.language_code_temp){
				language_code	= document.calender3.language_code_temp.value;
			}
			if(document.calender3.term_set_id)
				term_set_id = document.calender3.term_set_id.value;
			if(document.calender3.linking_code)
				linking_code = document.calender3.linking_code.value;
		}
		// passing the patient values when rele based is applicable ends

	var callingMode=document.forms[2].callingMode.value;
	var calledFrom=document.forms[2].calledFrom.value; //Added by Sathish.S for IN020026 onMonday, March 22, 2010
	var rd_appt_yn= document.forms[2].rd_appt_yn.value; 
	var order_id= document.forms[2].order_id.value; 
	
	var or_catalogue_code=document.forms[2].or_catalogue_code.value;
	var date=obj;
	//document.forms[0].elements(u2).value;
	var max = document.forms[1].counter.value;
	if( max == null ) max =1;
	var f=new Array();
	var j=0;
	for (var idx=0; idx<max; idx++){
		if (eval("document.forms[1].check"+idx+".checked")){
			if (eval("document.forms[1].check"+idx+".checked ")== true){
				f[j]=idx;
				j++;
			}
		}
	}
	u1=u1+1;

	var slot_appt_ctrl=document.forms[2].slot_appt_ctrl.value;
	var visit_limit_rule=document.forms[2].visit_limit_rule.value;
	var alcn_criteria=document.forms[2].alcn_criteria.value;
	var override_no_of_slots_yn=document.forms[2].override_no_of_slots_yn.value;
	var capture_fin_dtls_yn= document.forms[2].capture_fin_dtls_yn.value;
	var min_ela_per_resc_noshow_in_day=document.forms[2].min_ela_per_resc_noshow_in_day.value;
	var noshow_ctrl_by_splty_or_clinic=document.forms[2].noshow_ctrl_by_splty_or_clinic.value;
	var contact_num_reqd_yn= document.forms[2].contact_num_reqd_yn.value; 
	var no_of_noshow_appts_for_alert=document.forms[2].no_of_noshow_appts_for_alert.value;
	var per_chk_for_no_show_alert=document.forms[2].per_chk_for_no_show_alert.value;
	
	//Added for CRF-595 starts
	var position=document.forms[2].position.value;
	var addtl_splty=document.forms[2].addtl_splty.value;
	//Added for CRF-595 Ends
	if(f.length == 1 || f.length == 0){
		if(u == null){
			var h=parseInt(u1)*3;
			//eval("document.forms[1].check"+u1).checked=false;
		}else{
			var h=parseInt(u)*3;
			//eval("document.forms[1].check"+u).checked=false;
		}
		var h1=h+1;
		var clinic=obj1;
		var practitioner=obj2;
		//var clinic_arr=obj;
		var clinic_type=obj3;
		//clinic=clinic_arr[0];
		//var practitioner_arr=practitioner.split("||");
		var res_type=obj4;
		//practitioner=practitioner_arr[0];
		var ca_mode=document.forms[2].ca_mode.value;
		var ca_patient_id=document.forms[2].ca_patient_id.value;
		if (practitioner=="on") practitioner="";
		var order_id=document.forms[2].order_id.value;
		var order_line_num=document.forms[2].order_line_num.value;
		var order_catalog_code=document.forms[2].order_catalog_code.value;//Pending order catalog
		var oper_stn_id = document.forms[2].oper_stn_id.value;
		var req_id =document.forms[2].req_id.value;
		var install_yn_val =document.forms[2].install_yn_val.value;
		var from_OR= document.forms[2].from_OR.value;
		var create_wait_list_yn= document.forms[2].create_wait_list_yn.value;
		var visit_flag_OP= document.forms[2].visit_flag_OP.value; 
		var speciality=document.forms[2].speciality.value;;
		var no_dwm=document.forms[2].no_dwm.value;
		var dwm_desc=document.forms[2].dwm_desc.value;
		var visittype=document.forms[2].visittype.value;
		var practitioner_old=document.forms[2].practitioner.value;
		var clinic_old=document.forms[2].clinic.value;
		var practitioner_type=document.forms[2].practitioner_type.value;
		var or_catalogue_code=document.forms[2].or_catalogue_code.value;//order catalog selected in schedule appointment
		var pref_start_date=document.forms[2].pref_start_date.value;
		var pref_end_date=document.forms[2].pref_end_date.value;
		var care_locn_ind=document.forms[2].care_locn_ind.value;
		var from_page=document.forms[2].from_page.value;
		var from_facility_id= document.forms[2].from_facility_id.value; 
		var from_encounter_id= document.forms[2].from_encounter_id.value; 
		var practitioner1=practitioner;
		if(practitioner1==" " || practitioner1=="" || practitioner1=="null" ){
			practitioner1="*";
		}
		//alert(flag)
		var first_val=clinic_type+"|"+clinic+"|"+res_type+"|"+practitioner1;
		var final_val=first_val+"$";
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH clinic_type=\""+clinic_type+"\" clinic_code1=\""+clinic+"\" res_type=\""+res_type+"\" practitioner=\""+practitioner+"\" clinic_date=\""+date+"\" final_val=\""+final_val+"\" steps='slot_slab' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
		
		if(flag=="1"){
			//Added for Checkout Function for Book Appointment
			if(f==0) f=1;
			if ((callingMode=="OP")||(callingMode=="CA_WIDGET")||(callingMode=="IP")|| (callingMode=="OR")||(callingMode=="MR")||(callingMode=="OP_RV") || (callingMode=="OH")){
				var retVal="practitioner_id="+practitioner+"&clinic_code="+clinic+"&Date="+date+"&ca_patient_id="+ca_patient_id+"&ca_mode="+ca_mode+"&callingMode="+callingMode+"&clinic_type="+clinic_type+"&res_type="+res_type+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code+"&oper_stn_id="+oper_stn_id+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&alcn_criteria="+alcn_criteria+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&from_OR="+from_OR+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&speciality="+speciality+"&practitioner_old="+practitioner_old+"&clinic_old="+clinic_old+"&practitioner_type="+practitioner_type+"&or_catalogue_code="+or_catalogue_code+"&pref_start_date="+pref_start_date+"&pref_end_date="+pref_end_date+"&care_locn_ind="+care_locn_ind+"&no_dwm="+no_dwm+"&visittype="+visittype+"&dwm_desc="+dwm_desc+"&from_page="+from_page+"&install_yn_val="+install_yn_val+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&calledFrom="+calledFrom+"&position="+position+"&addtl_splty="+addtl_splty+"&patient_id_temp="+patient_id+"&name_prefix_temp="+name_prefix+"&first_name_temp="+first_name+"&second_name_temp="+second_name+"&third_name_temp="+third_name+"&family_name_temp="+family_name+"&name_suffix_temp="+name_suffix+"&name_prefix_oth_lang_temp="+name_prefix_oth_lang+"&first_name_oth_lang_temp="+first_name_oth_lang+"&second_name_oth_lang_temp="+second_name_oth_lang+"&third_name_oth_lang_temp="+third_name_oth_lang+"&family_name_oth_lang_temp="+family_name_oth_lang+"&name_suffix_oth_lang_temp="+name_suffix_oth_lang+"&gender_temp="+gender+"&contact_no_temp="+contact_no+"&rule_appl_yn="+rule_appl_yn+"&nationality_code_temp="+nationality_code+"&language_code_temp="+language_code+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn;
				if(from_OR==null || from_OR=="N"){
					parent.parent.window.returnValue= "1"+"^"+retVal;
					parent.parent.window.close();
			
					/*let dialogBody = parent.parent.parent.document.getElementById("dialog-body");
				    dialogBody.contentWindow.returnValue = "1"+"^"+retVal;
					const dialogTag = parent.parent.parent.document.getElementById("dialog_tag");    
				    dialogTag.close(); */
					
				}else{
					parent.parent.window.location.href="../../eOA/jsp/SinglePractVwNew.jsp?"+retVal;
				}
				
			}else{
				var url="../../eOA/jsp/SinglePractVwNew.jsp?clinic_code="+clinic+"&practitioner_id="+practitioner+"&ca_mode="+ca_mode+"&ca_patient_id="+ca_patient_id+"&Date="+date+"&clinic_type="+clinic_type+"&res_type="+res_type+"&callingMode="+callingMode+"&or_catalogue_code="+or_catalogue_code+"&order_id="+order_id+"&oper_stn_id="+oper_stn_id+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&alcn_criteria="+alcn_criteria+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&speciality="+speciality+"&practitioner_old="+practitioner_old+"&clinic_old="+clinic_old+"&practitioner_type="+practitioner_type+"&or_catalogue_code="+or_catalogue_code+"&pref_start_date="+pref_start_date+"&pref_end_date="+pref_end_date+"&care_locn_ind="+care_locn_ind+"&no_dwm="+no_dwm+"&visittype="+visittype+"&dwm_desc="+dwm_desc+"&from_page="+from_page+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&calledFrom="+calledFrom+"&position="+position+"&addtl_splty="+addtl_splty+"&patient_id_temp="+patient_id+"&name_prefix_temp="+name_prefix+"&first_name_temp="+first_name+"&second_name_temp="+second_name+"&third_name_temp="+third_name+"&family_name_temp="+family_name+"&name_suffix_temp="+name_suffix+"&name_prefix_oth_lang_temp="+name_prefix_oth_lang+"&first_name_oth_lang_temp="+first_name_oth_lang+"&second_name_oth_lang_temp="+second_name_oth_lang+"&third_name_oth_lang_temp="+third_name_oth_lang+"&family_name_oth_lang_temp="+family_name_oth_lang+"&name_suffix_oth_lang_temp="+name_suffix_oth_lang+"&gender_temp="+gender+"&contact_no_temp="+contact_no+"&rule_appl_yn="+rule_appl_yn+"&nationality_code_temp="+nationality_code+"&language_code_temp="+language_code+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn;
				if(callingMode=="RSCAPPT"){
					parent.parent.location.href=url+"&apptrefno="+parent.parent.querying.document.forms[0].apptrefno.value;
				}else{
					parent.parent.window.location.href=url;
				}
			}
		}else{
			alert(getMessage('SCHEDULE_NOT_GENERATED','OA'));
		}
	}else if(f.length == 2){
		var value1=f[0];
		var value2=f[1];
		var h1=parseInt(value1)*3;
		var h2=h1+1;
		/*Code commented by Sethu for EDGE Compatible on 05/11/2024
		var clinic1=document.forms[1].elements(h1).value;
		var practitioner1=document.forms[1].elements(h2).value; */
		var clinic1=document.forms[1].elements[h1].value;
		var practitioner1=document.forms[1].elements[h2].value;
		var clinic_arr=clinic1.split("||");
		var clinic_type1=clinic_arr[1];
		clinic1=clinic_arr[0];
		var practitioner_arr=practitioner1.split("||");
		var res_type1=practitioner_arr[1];
		practitioner1=practitioner_arr[0];
		var h3=parseInt(value2)*3;
		var h4=h3+1;
		/*Code commented by Sethu for EDGE Compatible on 05/11/2024
		var clinic2=document.forms[1].elements(h3).value;
		var practitioner2=document.forms[1].elements(h4).value;*/
		var clinic2=document.forms[1].elements[h3].value;
		var practitioner2=document.forms[1].elements[h4].value;
		var clinic_arr2=clinic2.split("||");
		var clinic_type2=clinic_arr2[1];
		clinic2=clinic_arr2[0];
		var practitioner_arr2=practitioner2.split("||");
		var res_type2=practitioner_arr2[1];
		practitioner2=practitioner_arr2[0];
		var order_id=document.forms[2].order_id.value;
		var order_line_num=document.forms[2].order_line_num.value;
		var order_catalog_code=document.forms[2].order_catalog_code.value;
		var oper_stn_id = document.forms[2].oper_stn_id.value;
		var req_id =document.forms[2].req_id.value;
		var install_yn_val =document.forms[2].install_yn_val.value;
		var ca_mode=document.forms[2].ca_mode.value;
		var ca_patient_id=document.forms[2].ca_patient_id.value;
		var visit_flag_OP= document.forms[2].visit_flag_OP.value; 
		var speciality=document.forms[2].speciality.value;;
		var from_facility_id= document.forms[2].from_facility_id.value; 
		var from_encounter_id= document.forms[2].from_encounter_id.value; 
		var practitioner_old=document.forms[2].practitioner.value;
		var clinic_old=document.forms[2].clinic.value;
		var practitioner_type=document.forms[2].practitioner_type.value;
		var or_catalogue_code=document.forms[2].or_catalogue_code.value;
		var pref_start_date=document.forms[2].pref_start_date.value;
		var pref_end_date=document.forms[2].pref_end_date.value;
		var care_locn_ind=document.forms[2].care_locn_ind.value;
		var no_dwm=document.forms[2].no_dwm.value;
		var dwm_desc=document.forms[2].dwm_desc.value;
		var visittype=document.forms[2].visittype.value;
		if (practitioner1=="on") practitioner1="";
		if (practitioner2=="on") practitioner2="";
		var from_OR= document.forms[2].from_OR.value;
		var practitioner3=practitioner1;
		var practitioner4=practitioner2;
		if(practitioner3==" " || practitioner3=="" || practitioner3=="null" ) 
		{
			practitioner3="*";
		}
		if(practitioner4==" " || practitioner4=="" || practitioner4=="null" ) 
		{
			practitioner4="*";
		}
		var first_val=clinic_type1+"|"+clinic1+"|"+res_type1+"|"+practitioner3;
		var second_val=clinic_type2+"|"+clinic2+"|"+res_type2+"|"+practitioner4;
		var final_val=first_val+"$"+second_val+"$";
		var from_page=document.forms[2].from_page.value;
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH clinic_date=\""+date+"\" final_val=\""+final_val+"\" steps='slot_slab' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
		//var flag="1";
		if(flag=="1"){
			//Added for Checkout Function for Book Appointment
			var create_wait_list_yn= document.forms[2].create_wait_list_yn.value;
			if ((callingMode=="OP")||(callingMode=="CA_WIDGET")||(callingMode=="IP")|| (callingMode=="OR")||  (callingMode=="MR")||(callingMode=="OP_RV") || (callingMode=="OH")){
				var retVal="practitioner_id1="+practitioner1+"&practitioner_id2="+practitioner2+"&clinic_code1="+clinic1+"&clinic_code2="+clinic2+"&Date="+date+"&ca_patient_id="+ca_patient_id+"&ca_mode="+ca_mode+"&callingMode="+callingMode+"&clinic_type1="+clinic_type1+"&res_type1="+res_type1+"&clinic_type2="+clinic_type2+"&res_type2="+res_type2+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code+"&oper_stn_id="+oper_stn_id+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&alcn_criteria="+alcn_criteria+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&from_OR="+from_OR+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&speciality="+speciality+"&practitioner_old="+practitioner_old+"&clinic_old="+clinic_old+"&practitioner_type="+practitioner_type+"&or_catalogue_code="+or_catalogue_code+"&pref_start_date="+pref_start_date+"&pref_end_date="+pref_end_date+"&care_locn_ind="+care_locn_ind+"&no_dwm="+no_dwm+"&visittype="+visittype+"&dwm_desc="+dwm_desc+"&from_page="+from_page+"&install_yn_val="+install_yn_val+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&calledFrom="+calledFrom+"&position="+position+"&addtl_splty="+addtl_splty+"&patient_id_temp="+patient_id+"&name_prefix_temp="+name_prefix+"&first_name_temp="+first_name+"&second_name_temp="+second_name+"&third_name_temp="+third_name+"&family_name_temp="+family_name+"&name_suffix_temp="+name_suffix+"&name_prefix_oth_lang_temp="+name_prefix_oth_lang+"&first_name_oth_lang_temp="+first_name_oth_lang+"&second_name_oth_lang_temp="+second_name_oth_lang+"&third_name_oth_lang_temp="+third_name_oth_lang+"&family_name_oth_lang_temp="+family_name_oth_lang+"&name_suffix_oth_lang_temp="+name_suffix_oth_lang+"&gender_temp="+gender+"&contact_no_temp="+contact_no+"&rule_appl_yn="+rule_appl_yn+"&nationality_code_temp="+nationality_code+"&language_code_temp="+language_code+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn;
				if(from_OR==null || from_OR=="N"){
					parent.parent.window.returnValue= "2"+"^"+retVal;
					parent.parent.window.close();
					
					/*let dialogBody = parent.parent.document.getElementById('dialog-body');
				    dialogBody.contentWindow.returnValue = "2"+"^"+retVal;
					const dialogTag = parent.parent.document.getElementById("dialog_tag");    
				    dialogTag.close(); */
				}else{
					parent.parent.window.location.href="../../eOA/jsp/MultiPract2VwMain.jsp?" +retVal;
				}
			}else{
				var url="../../eOA/jsp/MultiPract2VwMain.jsp?clinic_code1="+clinic1+"&practitioner_id1="+practitioner1+"&clinic_code2="+clinic2+"&practitioner_id2="+practitioner2+"&ca_mode="+ca_mode+"&callingMode="+callingMode+"&ca_patient_id="+ca_patient_id+"&Date="+date+"&clinic_type1="+clinic_type1+"&order_id="+order_id+"&res_type1="+res_type1+"&clinic_type2="+clinic_type2+"&res_type2="+res_type2+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&alcn_criteria="+alcn_criteria+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&speciality="+speciality+"&practitioner_old="+practitioner_old+"&clinic_old="+clinic_old+"&practitioner_type="+practitioner_type+"&or_catalogue_code="+or_catalogue_code+"&pref_start_date="+pref_start_date+"&pref_end_date="+pref_end_date+"&care_locn_ind="+care_locn_ind+"&no_dwm="+no_dwm+"&visittype="+visittype+"&dwm_desc="+dwm_desc+"&from_page="+from_page+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&calledFrom="+calledFrom+"&position="+position+"&addtl_splty="+addtl_splty+"&patient_id_temp="+patient_id+"&name_prefix_temp="+name_prefix+"&first_name_temp="+first_name+"&second_name_temp="+second_name+"&third_name_temp="+third_name+"&family_name_temp="+family_name+"&name_suffix_temp="+name_suffix+"&name_prefix_oth_lang_temp="+name_prefix_oth_lang+"&first_name_oth_lang_temp="+first_name_oth_lang+"&second_name_oth_lang_temp="+second_name_oth_lang+"&third_name_oth_lang_temp="+third_name_oth_lang+"&family_name_oth_lang_temp="+family_name_oth_lang+"&name_suffix_oth_lang_temp="+name_suffix_oth_lang+"&gender_temp="+gender+"&contact_no_temp="+contact_no+"&rule_appl_yn="+rule_appl_yn+"&nationality_code_temp="+nationality_code+"&language_code_temp="+language_code+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn;
				if(callingMode=="RSCAPPT"){
					parent.parent.window.location.href=url+"&apptrefno="+parent.parent.querying.document.forms[0].apptrefno.value;
				}else{
					parent.parent.window.location.href=url;
				}				
			}
		}else{
			alert(getMessage('SCHEDULE_NOT_GENERATED','OA'));
		}
	}else if(f.length == 3){
		var value1=f[0];
		var value2=f[1];
		var value3=f[2];
		var h1=parseInt(value1)*3;
		var h2=h1+1;
		/*Code commented by Sethu for EDGE Compatible on 05/11/2024
		var clinic1=document.forms[1].elements(h1).value;
		var practitioner1=document.forms[1].elements(h2).value;*/
		var clinic1=document.forms[1].elements[h1].value;
		var practitioner1=document.forms[1].elements[h2].value;
		var clinic_arr=clinic1.split("||");
		var clinic_type1=clinic_arr[1];
		clinic1=clinic_arr[0];
		var practitioner_arr=practitioner1.split("||");
		var res_type1=practitioner_arr[1];
		practitioner1=practitioner_arr[0];
		var h3=parseInt(value2)*3;
		var h4=h3+1;
		/*Code commented by Sethu for EDGE Compatible on 05/11/2024
		var clinic2=document.forms[1].elements(h3).value;
		var practitioner2=document.forms[1].elements(h4).value;*/
		var clinic2=document.forms[1].elements[h3].value;
		var practitioner2=document.forms[1].elements[h4].value;
		var clinic_arr2=clinic2.split("||");
		var clinic_type2=clinic_arr2[1];
		clinic2=clinic_arr2[0];
		var practitioner_arr2=practitioner2.split("||");
		var res_type2=practitioner_arr2[1];
		practitioner2=practitioner_arr2[0];
		var h5=parseInt(value3)*3;
		var h6=h5+1;
		/*Code commented by Sethu for EDGE Compatible on 05/11/2024
		var clinic3=document.forms[1].elements(h5).value;
		var practitioner3=document.forms[1].elements(h6).value;*/
		var clinic3=document.forms[1].elements[h5].value;
		var practitioner3=document.forms[1].elements[h6].value;
		var clinic_arr3=clinic3.split("||");
		var clinic_type3=clinic_arr3[1];
		clinic3=clinic_arr3[0];
		var practitioner_arr3=practitioner3.split("||");
		var res_type3=practitioner_arr3[1];
		practitioner3=practitioner_arr3[0];
		var req_id =document.forms[2].req_id.value;
		var install_yn_val =document.forms[2].install_yn_val.value;
		//document.forms[1].check[value1].checked=false;
		////document.forms[1].check[value2].checked=false;
		//document.forms[1].check[value3].checked=false;
		var ca_mode=document.forms[2].ca_mode.value;
		var ca_patient_id=document.forms[2].ca_patient_id.value;
		var order_id=document.forms[2].order_id.value;
		var order_line_num=document.forms[2].order_line_num.value;
		var order_catalog_code=document.forms[2].order_catalog_code.value;
		var oper_stn_id =document.forms[2].oper_stn_id.value;
		var speciality=document.forms[2].speciality.value;;
		var from_page=document.forms[2].from_page.value;
		var practitioner_old=document.forms[2].practitioner.value;
		var clinic_old=document.forms[2].clinic.value;
		var practitioner_type=document.forms[2].practitioner_type.value;
		var or_catalogue_code=document.forms[2].or_catalogue_code.value;
		var pref_start_date=document.forms[2].pref_start_date.value;
		var pref_end_date=document.forms[2].pref_end_date.value;
		var care_locn_ind=document.forms[2].care_locn_ind.value;
		var no_dwm=document.forms[2].no_dwm.value;
		var dwm_desc=document.forms[2].dwm_desc.value;
		var visittype=document.forms[2].visittype.value;
		var from_facility_id= document.forms[2].from_facility_id.value; 
		var from_encounter_id= document.forms[2].from_encounter_id.value; 
		if (practitioner1=="on") practitioner1="";
		if (practitioner2=="on") practitioner2="";
		if (practitioner3=="on") practitioner3="";
		var from_OR= document.forms[2].from_OR.value;
		var create_wait_list_yn= document.forms[2].create_wait_list_yn.value;
		var visit_flag_OP= document.forms[2].visit_flag_OP.value; 
		var practitioner_3=practitioner1;
		var practitioner4=practitioner2;
		var practitioner5=practitioner3;
		if(practitioner_3==" " || practitioner_3=="" || practitioner_3=="null" ){
			practitioner_3="*";
		}
		if(practitioner4==" " || practitioner4=="" || practitioner4=="null" ){
			practitioner4="*";
		}
		if(practitioner5==" " || practitioner5=="" || practitioner5=="null" ){
			practitioner5="*";
		}
		var first_val=clinic_type1+"|"+clinic1+"|"+res_type1+"|"+practitioner_3;
		var second_val=clinic_type2+"|"+clinic2+"|"+res_type2+"|"+practitioner4;
		var third_val=clinic_type3+"|"+clinic3+"|"+res_type3+"|"+practitioner5;
		var final_val=first_val+"$"+second_val+"$"+third_val+"$";
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH final_val=\""+final_val+"\" clinic_date=\""+date+"\" steps='slot_slab' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
		if(flag=="1"){
			if ((callingMode=="OP")||(callingMode=="CA_WIDGET")||(callingMode=="IP") || (callingMode=="OR")||  (callingMode=="MR")||(callingMode=="OP_RV")|| (callingMode=="OH")){
				var retVal="practitioner_id1="+practitioner1+"&practitioner_id2="+practitioner2+"&practitioner_id3="+practitioner3+"&clinic_code1="+clinic1+"&clinic_code2="+clinic2+"&clinic_code3="+clinic3+"&Date="+date+"&ca_patient_id="+ca_patient_id+"&ca_mode="+ca_mode+"&callingMode="+callingMode+"&clinic_type1="+clinic_type1+"&res_type1="+res_type1+"&clinic_type2="+clinic_type2+"&res_type2="+res_type2+"&clinic_type3="+clinic_type3+"&res_type3="+res_type3+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code+"&oper_stn_id="+oper_stn_id+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&alcn_criteria="+alcn_criteria+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&from_OR="+from_OR+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&speciality="+speciality+"&practitioner_old="+practitioner_old+"&clinic_old="+clinic_old+"&practitioner_type="+practitioner_type+"&or_catalogue_code="+or_catalogue_code+"&pref_start_date="+pref_start_date+"&pref_end_date="+pref_end_date+"&care_locn_ind="+care_locn_ind+"&no_dwm="+no_dwm+"&visittype="+visittype+"&dwm_desc="+dwm_desc+"&from_page="+from_page+"&install_yn_val="+install_yn_val+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&calledFrom="+calledFrom+"&position="+position+"&addtl_splty="+addtl_splty+"&patient_id_temp="+patient_id+"&name_prefix_temp="+name_prefix+"&first_name_temp="+first_name+"&second_name_temp="+second_name+"&third_name_temp="+third_name+"&family_name_temp="+family_name+"&name_suffix_temp="+name_suffix+"&name_prefix_oth_lang_temp="+name_prefix_oth_lang+"&first_name_oth_lang_temp="+first_name_oth_lang+"&second_name_oth_lang_temp="+second_name_oth_lang+"&third_name_oth_lang_temp="+third_name_oth_lang+"&family_name_oth_lang_temp="+family_name_oth_lang+"&name_suffix_oth_lang_temp="+name_suffix_oth_lang+"&gender_temp="+gender+"&contact_no_temp="+contact_no+"&rule_appl_yn="+rule_appl_yn+"&nationality_code_temp="+nationality_code+"&language_code_temp="+language_code+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn;
				if(from_OR==null || from_OR=="N"){
					parent.parent.window.returnValue= "3"+"^"+retVal;
					parent.parent.window.close();
					/*let dialogBody = parent.parent.document.getElementById('dialog-body');
				    dialogBody.contentWindow.returnValue = "3"+"^"+retVal;
					const dialogTag = parent.parent.document.getElementById("dialog_tag");    
				    dialogTag.close(); */
				}else{
					parent.parent.window.location.href="../../eOA/jsp/MultiPract3VwMain.jsp?" +retVal;
				}
			}else{
				var url="../../eOA/jsp/MultiPract3VwMain.jsp?clinic_code1="+clinic1+"&practitioner_id1="+practitioner1+"&clinic_code2="+clinic2+"&practitioner_id2="+practitioner2+"&clinic_code3="+clinic3+"&callingMode="+callingMode+"&ca_patient_id="+ca_patient_id+"&practitioner_id3="+practitioner3+"&ca_mode="+ca_mode+"&order_id="+order_id+"&Date="+date+"&clinic_type1="+clinic_type1+"&res_type1="+res_type1+"&clinic_type2="+clinic_type2+"&res_type2="+res_type2+"&clinic_type3="+clinic_type3+"&res_type3="+res_type3+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&slot_appt_ctrl="+slot_appt_ctrl+"&visit_limit_rule="+visit_limit_rule+"&alcn_criteria="+alcn_criteria+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&install_yn_val="+install_yn_val+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&speciality="+speciality+"&practitioner_old="+practitioner_old+"&clinic_old="+clinic_old+"&practitioner_type="+practitioner_type+"&or_catalogue_code="+or_catalogue_code+"&pref_start_date="+pref_start_date+"&pref_end_date="+pref_end_date+"&care_locn_ind="+care_locn_ind+"&no_dwm="+no_dwm+"&visittype="+visittype+"&dwm_desc="+dwm_desc+"&from_page="+from_page+"&noshow_ctrl_by_splty_or_clinic="+noshow_ctrl_by_splty_or_clinic+"&min_ela_per_resc_noshow_in_day="+min_ela_per_resc_noshow_in_day+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&contact_num_reqd_yn="+contact_num_reqd_yn+"&no_of_noshow_appts_for_alert="+no_of_noshow_appts_for_alert+"&per_chk_for_no_show_alert="+per_chk_for_no_show_alert+"&calledFrom="+calledFrom+"&position="+position+"&addtl_splty="+addtl_splty+"&patient_id_temp="+patient_id+"&name_prefix_temp="+name_prefix+"&first_name_temp="+first_name+"&second_name_temp="+second_name+"&third_name_temp="+third_name+"&family_name_temp="+family_name+"&name_suffix_temp="+name_suffix+"&name_prefix_oth_lang_temp="+name_prefix_oth_lang+"&first_name_oth_lang_temp="+first_name_oth_lang+"&second_name_oth_lang_temp="+second_name_oth_lang+"&third_name_oth_lang_temp="+third_name_oth_lang+"&family_name_oth_lang_temp="+family_name_oth_lang+"&name_suffix_oth_lang_temp="+name_suffix_oth_lang+"&gender_temp="+gender+"&contact_no_temp="+contact_no+"&rule_appl_yn="+rule_appl_yn+"&nationality_code_temp="+nationality_code+"&language_code_temp="+language_code+"&term_set_id="+term_set_id+"&linking_code="+linking_code+"&rd_appt_yn="+rd_appt_yn;
				parent.parent.window.location.href=url;
				if(callingMode=="RSCAPPT"){
					parent.parent.window.location.href=url+"&apptrefno="+parent.parent.querying.document.forms[0].apptrefno.value;
				}else{
					parent.parent.window.location.href=url;
				}
			}
		}else{
			alert(getMessage('SCHEDULE_NOT_GENERATED','OA'));
		}
	}
}
function Disable_opco(){
	 var mode=parent.parent.frames[1].document.forms[0].callingMode.value;
	 if (mode=='OP'){
		 parent.arrows.document.forms[0].forward.disabled=true;
		parent.arrows.document.forms[0].back.disabled=true;
	}
}
