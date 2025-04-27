/*Created by Ashwini on 05-Apr-2024 for ML-MMOH-CRF-2060*/
function populatepract_from(Obj){
	var locationtype = document.getElementById('b_loc1').value;
	if(locationtype==""){
		var n=document.getElementById('b_loc2').options.length;
		for(var i=0;i<n;i++){
			document.getElementById('b_loc2').remove("clinic");
		}
		var opt=document.createElement("OPTION");
		opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
		opt.value="";
		document.getElementById('b_loc2').add(opt);  
	}

	var locationtype = document.getElementById('b_loc1').value;
	
	document.getElementById('resourceType1').value=document.getElementById('b_loc1').value;
	document.getElementById('specialty_code1').value=document.getElementById('speciality_from').value;
	document.getElementById('practitioner_name').value="";
	document.getElementById('practitioner').value="";
	document.getElementById('practitioner_name').disabled=true;
	document.getElementById('practitioner').disabled=true;
	document.getElementById('practitioner_name2').value="";
	document.getElementById('practitioner2').value="";
	document.getElementById('practitioner_name2').disabled=true;
	document.getElementById('practitioner2').disabled=true;
	if(Obj.value==null||Obj.value==""){
		document.getElementById('b_loc_val_from').value="";
		document.getElementById('from_locn').value="";
		document.getElementById('b_loc_val_from').disabled=true;
		document.getElementById('b_loc_search_from').disabled=true;
		document.getElementById('b_loc_val_to').value="";
		document.getElementById('to_locn').value="";
		document.getElementById('b_loc_val_to').disabled=true;
		document.getElementById('b_loc_search_to').disabled=true;
	}else{
		document.getElementById('b_loc_val_from').value="";
		document.getElementById('from_locn').value="";
		document.getElementById('b_loc_val_from').disabled=false;
		document.getElementById('b_loc_search_from').disabled=false;
		document.getElementById('b_loc_val_to').value="";
		document.getElementById('to_locn').value="";
		var to_splity=document.getElementById('speciality_to');
		if(to_splity.value==null || to_splity.value==""){
			document.getElementById('b_loc_val_to').disabled=true;
			document.getElementById('b_loc_search_to').disabled=true;
		}else{
			document.getElementById('b_loc_val_to').disabled=false;
			document.getElementById('b_loc_search_to').disabled=false;
		}
	}
	if(Obj.value=='C'){
		document.getElementById('resourceType').value='P';
	}else{
		document.getElementById('resourceType').value='';
	}
}

function clear_locations(obj){
	var CARE_LOCN_TYPE_IND = document.getElementById('b_loc1').value;
	document.getElementById('b_loc2').readonly=false;
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH steps='bulk_Loc' CARE_LOCN_TYPE_IND=\""+CARE_LOCN_TYPE_IND+"\" /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","MultiSelectionApptReschedulingValidation.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText) 
}

function populatepract_to(Obj){
	var locationtype = document.getElementById('b_loc1').value;
	document.getElementById('locationType1').value=document.getElementById('b_loc2').value;
	document.getElementById('specialty_code2').value=document.getElementById('speciality_to').value;
	document.getElementById('practitioner_name2').value="";
	document.getElementById('practitioner2').value="";
	document.getElementById('practitioner_name2').disabled=true;
	document.getElementById('practitioner2').disabled=true;
	if(Obj.value=='C'){
		document.getElementById('resourceType1').value="P";
	}else{
		document.getElementById('resourceType1').value='';
	}
}

function enablepract_from(Obj){
	document.getElementById('practitioner_name').disabled=false;
	document.getElementById('search_pract').disabled=false;
	document.getElementById('practitioner_name').value="";
	var ObjVal=Obj.value;
	var arr=ObjVal.split("$");
	var clnc_cd=arr[1];
	var clinic_type=parent.frames[1].document.getElementById('b_loc1').value;
	var fac_id=parent.frames[1].document.getElementById('fac_id').value;

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH fac_id=\""+fac_id+"\" clinic_code=\""+clnc_cd+"\" action='getIdentAtCheckinVal' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../jsp/OAIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	var ident_at_checkin = trimString(responseText);

	var open_to_all_pract_yn =ObjVal.substring(0,1);
	if(ObjVal==''){
		document.getElementById('practitioner_name').value='';
		document.getElementById('practitioner_name').disabled=true;
		document.getElementById('search_pract').disabled=true;
	}else{
		document.getElementById('practitioner_name').value='';
		document.getElementById('practitioner_name').disabled=false;
		document.getElementById('search_pract').disabled=false;
	}
	if(open_to_all_pract_yn =="Y"){
		if(ident_at_checkin == "X"){
			document.getElementById('imgpract').style.visibility='hidden';
		}else{
			document.getElementById('imgpract').style.visibility='visible';
		}
	}else{
		document.getElementById('imgpract').style.visibility='hidden';
	}
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+clinic_type+"\" clinic_code1=\""+clnc_cd+"\"  location=\""+Obj.value+"\" speciality_code=\""+document.getElementById('speciality_from').value+"\" steps='bulk_enable_pract_from' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","MultiSelectionApptReschedulingValidation.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}

function enablepract_to(Obj){
	document.getElementById('practitioner_name2').disabled=false;
	document.getElementById('search_pract2').disabled=false;
	document.getElementById('practitioner_name2').value="";
	var ObjVal=Obj.value;
	var arr=ObjVal.split("$");
	var clnc_cd=arr[1];
	var clinic_type=parent.frames[1].document.getElementById('b_loc1').value;
	var fac_id=parent.frames[1].document.getElementById('fac_id').value;

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH fac_id=\""+fac_id+"\" clinic_code=\""+clnc_cd+"\" action='getIdentAtCheckinVal' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../jsp/OAIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	var ident_at_checkin = trimString(responseText);

	if(ObjVal==''){
		document.getElementById('practitioner_name2').value='';
		document.getElementById('practitioner_name2').disabled=true;
		document.getElementById('search_pract2').disabled=true;
	}else{
		document.getElementById('practitioner_name2').value='';
		document.getElementById('practitioner_name2').disabled=false;
		document.getElementById('search_pract2').disabled=false;
	}
	var open_to_all_pract_yn =ObjVal.substring(0,1);
	if(open_to_all_pract_yn == "Y"){
		if(ident_at_checkin == "X"){
			document.getElementById('imgpract2').style.visibility='hidden';
		}else{
			document.getElementById('imgpract2').style.visibility='visible';
		}
	}else{
		document.getElementById('imgpract2').style.visibility='hidden';
	}
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+clinic_type+"\" clinic_code1=\""+clnc_cd+"\" location=\""+Obj.value+"\" speciality_code=\""+document.getElementById('speciality_to').value+"\" steps='bulk_enable_pract_to' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","MultiSelectionApptReschedulingValidation.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}

function enable_lonc_type(obj){
	document.getElementById('b_loc1').value="";
	var n=document.getElementById('from_locn').options.length;
	for(var i=0;i<n;i++){
		document.getElementById('from_locn').remove("clinic");
	}
	var opt=document.createElement("OPTION");
	opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt.value="";
	document.getElementById('from_locn').add(opt);
	var m=document.getElementById('to_locn').options.length;
	for(var j=0;j<m;j++){
		document.getElementById('to_locn').remove("clinic");
	}
	var opt1=document.createElement("OPTION");
	opt1.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt1.value="";
	document.getElementById('to_locn').add(opt1);
	if(obj.value !=""){
		document.getElementById('b_loc1').disabled=false;
	}else{
		document.getElementById('b_loc1').disabled=true;
	}
}

function ValidateDate(obj){
	if(obj.value!=""){
		if(validDate(obj.value,'DMY',localeName)==false){
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.value="";
			obj.select();	
			return false;
		}else{
			return true;
		}
	}
}

function DateCompare_from(obj,sys_date){
	if(obj.value!=""){
		var obj1=convertDate(obj.value,"DMY",localeName,"en");
		if(isBefore(sys_date.value,obj1,'DMY',localeName)==false){
			alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
			obj.value="";
			obj.select();	
			return false;
		}else{
			return true;
		}
	}
}

function reset(){
	frames[1].location.reload();
	frames[2].location.href="../../eCommon/html/blank.html";
	frames[3].location.href="../../eCommon/html/blank.html";
}

function clearResult(){
	parent.frames[2].location.href = '../../eCommon/html/blank.html';	
	parent.frames[3].location.href = '../../eCommon/html/blank.html';
	parent.frames[4].location.href= "../../eCommon/jsp/error.jsp?err_num=";
}

function callResult(){
	var from_speciality="";
	var to_speciality="";
	var locn_type="";
	var from_locn="";
	var to_locn="";
	var from_resc="";
	var to_resc="";
	var from_date="";
	var to_date="";
	var from_res_class="";
	var to_res_class="";
	var oper_stn="";
	var visit_limit_rule="";
	var is_group_location = parent.frames[1].document.getElementById('is_group_location').value; 
	from_speciality=parent.frames[1].document.getElementById('speciality_from').value;
	to_speciality=parent.frames[1].document.getElementById('speciality_to').value;
	locn_type=parent.frames[1].document.getElementById('b_loc1').value;
	from_locn=parent.frames[1].document.getElementById('from_locn').value;
	to_locn=parent.frames[1].document.getElementById('to_locn').value;
	from_resc=parent.frames[1].document.getElementById('practitioner').value;
	to_resc=parent.frames[1].document.getElementById('practitioner2').value;
	from_date=parent.frames[1].document.getElementById('b_from_date').value;
	to_date=parent.frames[1].document.getElementById('b_to_date').value;
	from_res_class=parent.frames[1].document.getElementById('resourceType1').value;
	to_res_class=parent.frames[1].document.getElementById('resourceType3').value;
	oper_stn=parent.frames[1].document.getElementById('oper_stn').value;
	visit_limit_rule=parent.frames[1].document.getElementById('visit_limit_rule').value;
	var from_date_greg=convertDate(from_date,"DMY",localeName,"en");
	var to_date_greg=convertDate(to_date,"DMY",localeName,"en");	
	from_locn=from_locn.split("$");
	from_locn=from_locn[1];
	to_locn=to_locn.split("$");
	to_locn=to_locn[1];

	var fields = new Array ( parent.frames[1].document.getElementById('speciality_from'),
							 parent.frames[1].document.getElementById('speciality_to'),
							 parent.frames[1].document.getElementById('b_loc1'),
							 parent.frames[1].document.getElementById('b_loc2'),
							 parent.frames[1].document.getElementById('from_locn'),
						     parent.frames[1].document.getElementById('to_locn'),
							 parent.frames[1].document.getElementById('b_from_date'),
							 parent.frames[1].document.getElementById('b_to_date'),
							 parent.frames[1].document.getElementById('reason_code_revision')
							);
	var names = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("Common.speciality.label","Common"),
							getLabel("Common.to.label","Common")+" "+getLabel("Common.speciality.label","Common"),
							getLabel("Common.from.label","Common")+" "+getLabel("Common.locationtype.label","Common"),
							getLabel("Common.to.label","Common")+" "+getLabel("Common.locationtype.label","Common"),
							getLabel("Common.from.label","Common")+" "+getLabel("Common.Location.label","Common"),
							getLabel("Common.to.label","Common")+" "+getLabel("Common.Location.label","Common"),
							getLabel("Common.fromdate.label","Common"),
							getLabel("Common.todate.label","Common"),
							getLabel("Common.ReasonforRevision.label","Common")
							); 

	if(parent.frames[1].document.getElementById('imgpract')){		
		if(parent.frames[1].document.getElementById('imgpract').style.visibility == 'visible'){
			fields[fields.length]=parent.frames[1].document.getElementById('practitioner_name');
			names[names.length]=getLabel("Common.from.label","Common")+" "+getLabel("Common.resource.label","Common");
		}
	}
	if(parent.frames[1].document.getElementById('imgpract2')){		
		if(parent.frames[1].document.getElementById('imgpract2').style.visibility == 'visible'){
			fields[fields.length]=parent.frames[1].document.getElementById('practitioner_name2');
			names[names.length]=getLabel("Common.to.label","Common")+" "+getLabel("Common.resource.label","Common");
		}
	}
	if(parent.frames[1].checkFields( fields, names, parent.frames[4])){
		var flag=true;
		
		if(from_resc==to_resc && from_locn==to_locn && from_date==to_date){
			alert(getMessage("TRANS_SAME_LOCN_RESC_DATE_NOT_ALLOW","OA"));
		}else{
			if(from_res_class !=to_res_class){            
				alert(getMessage("PRIMARY_RESC_SAME_FROM_TO","OA"));
				parent.frames[1].document.getElementById('to_locn').options.selectedIndex=0;
				parent.frames[1].document.getElementById('practitioner_name2').value="";
				parent.frames[1].document.getElementById('practitioner2').value="";
			}else{
		
				var Sys_date=parent.frames[1].document.getElementById('Sys_date').value;
				var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()
				xmlStr ="<root><SEARCH clinic_type=\""+from_locn+"\" resc_code=\""+from_resc+"\" from_date =\""+from_date_greg+"\" resc_class=\""+from_res_class+"\" clinic_type_to=\""+to_locn+"\" resc_code_to=\""+to_resc+"\" to_date =\""+to_date_greg+"\" resc_class_to=\""+to_res_class+"\" locn_type=\""+locn_type+"\" Sys_date=\""+Sys_date+"\" steps='bulktransfer_sch_exists' /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","MultiSelectionApptReschedulingValidation.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				responseText = trimString(responseText)
				eval(responseText)

				if(schedule_extend_to > 0 || schedule_extend_from > 0)
				{
					alert(getMessage("EXTENDEDSCH_EXST_CNT_BULKTRANS","OA"));
					parent.frame2.location.href='../../eCommon/html/blank.html';
					parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
				}else 
				{
					if(flag==true && error==true){
					var xmlDoc = ""
					var xmlHttp = new XMLHttpRequest()
					xmlStr ="<root><SEARCH clinic_type=\""+from_locn+"\" resc_code=\""+from_resc+"\" from_date =\""+from_date_greg+"\" resc_class=\""+from_res_class+"\" clinic_type_to=\""+to_locn+"\" resc_code_to=\""+to_resc+"\" to_date =\""+to_date_greg+"\" resc_class_to=\""+to_res_class+"\" locn_type=\""+locn_type+"\" steps='bulktransfer_slot_slab_freeformat' /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","MultiSelectionApptReschedulingValidation.jsp",false)
					xmlHttp.send(xmlDoc)
					responseText=xmlHttp.responseText
					responseText = trimString(responseText)
					eval(responseText)
					if(flag2==true){
						if(flag1==true){

							var xmlDoc = ""
							var xmlHttp = new XMLHttpRequest()
							xmlStr ="<root><SEARCH clinic_type=\""+from_locn+"\" resc_code=\""+from_resc+"\" from_date =\""+from_date_greg+"\" resc_class=\""+from_res_class+"\" clinic_type_to=\""+to_locn+"\" resc_code_to=\""+to_resc+"\" to_date =\""+to_date_greg+"\" resc_class_to=\""+to_res_class+"\" locn_type=\""+locn_type+"\" Sys_date=\""+Sys_date+"\" action='bulktransfer_to_sch_exists' /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
							xmlHttp.open("POST","../jsp/OAIntermediate.jsp",false)
							xmlHttp.send(xmlDoc)
							var to_sch_yn = xmlHttp.responseText
							to_sch_yn = trimString(to_sch_yn)

							if(to_sch_yn == 'N'){
								alert(getMessage("NO_FREE_SLOT_AVAILABLE_TO","OA"));
								parent.frame2.location.href='../../eCommon/html/blank.html';
								parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
							}else{
							var max_pat_per_day_from1=max_pat_per_day_from;
							var tot_booked_from1=tot_booked_from;
							var max_forced_in_booking_from1=max_forced_in_booking_from;
							var max_pap_per_day_tot_from=parseInt(tot_booked_from1)+parseInt(max_forced_in_booking_from1);
						
							var total_booked_from=max_pat_per_day_from1-max_pap_per_day_tot_from;
							var total_first_visit_slots_booked_from1=total_first_visit_slots_booked_from;							
							var total_other_visit_slots_booked_from1=total_other_visit_slots_booked_from;
							var total_first_visit_slots_booked_to1=total_first_visit_slots_booked_to;
							var total_other_visit_slots_booked_to1=total_other_visit_slots_booked_to;
							var max_first_visits_to1=max_first_visits_to;
							var max_other_visits_to1=max_other_visits_to;	
							parent.frames[1].document.getElementById('max_first_visits_from').value=max_first_visits_from;
							parent.frames[1].document.getElementById('max_other_visits_from').value=max_other_visits_from;
							parent.frames[1].document.getElementById('max_from_slot').value=max_pap_per_day_tot_from;
							parent.frames[1].document.getElementById('total_first_visit_slots_booked_from1').value=total_first_visit_slots_booked_from1;
							parent.frames[1].document.getElementById('total_other_visit_slots_booked_from1').value=total_other_visit_slots_booked_from1;
							parent.frames[1].document.getElementById('total_first_visit_slots_booked_to1').value=max_first_visits_to1-total_first_visit_slots_booked_to1;
							parent.frames[1].document.getElementById('total_other_visit_slots_booked_to1').value=max_other_visits_to1-total_other_visit_slots_booked_to1;
							var max_pat_per_day1=max_pat_per_day;
							var tot_booked1=tot_booked;
							var max_forced_in_booking1=max_forced_in_booking;
							var total_forced_in_booked_to1=total_forced_in_booked_to;
							var forced_val=max_forced_in_booking1-total_forced_in_booked_to1;
							var max_pap_per_day_tot=parseInt(max_pat_per_day1)+parseInt(forced_val);
							var total_booked=max_pap_per_day_tot-tot_booked1;
							parent.frames[1].document.getElementById('max_to_slot').value=total_booked;
							var max_over_book_from=max_over_booking_from;
							var total_overbook_from=total_overbooked_from;
							var max_over_book_to=max_over_booking_to;
							var total_overbook_to=total_overbooked_to;
							var total_from_over_booked ="";

							if(max_over_booking_from > 0){
								total_from_over_booked=parseInt(max_over_booking_from) - parseInt(total_overbooked_from);
							}else{
								total_from_over_booked="0";
							}
							var total_to_over_booked	="";
							if(max_over_booking_to > 0){
								total_to_over_booked=	parseInt(max_over_booking_to) - parseInt(total_overbooked_to);
							}else{
								total_to_over_booked="0";
							}
							
							if(is_group_location=='Y'){
								if(from_locn!=to_locn){
									alert(getMessage("GROUP_APP_TRANS_TO_SAME_LOC",'OA'));
									parent.frame2.location.href='../../eCommon/html/blank.html';
									parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
									return false;
								}							
							}
							
							parent.frames[1].document.getElementById('total_from_over_booked').value=total_overbooked_from;
							parent.frames[1].document.getElementById('total_to_over_booked').value=total_to_over_booked;
							parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
							var url='../../eOA/jsp/MultiSelectionApptReschedulingResultFrame.jsp?from_speciality='+from_speciality+"&to_speciality="+to_speciality+"&from_page=true&locn_type="+locn_type+"&from_locn="+from_locn+"&to_locn="+to_locn+"&from_resc="+from_resc+"&to_resc="+to_resc+"&from_date="+from_date_greg+"&to_date="+to_date_greg+"&to_res_class="+to_res_class+"&from_res_class="+from_res_class+"&oper_stn="+oper_stn+"&visit_limit_rule="+visit_limit_rule;
							parent.frame2.location.href = url;
							parent.frame3submit.location.href = '../../eOA/jsp/MultiSelectionApptReschedulingSubmitPage.jsp?';
							}
						}else{
							if(scheduleStatusFlag){
								alert(getMessage("SCHEDULE_BLOCKED","OA"));
								parent.frame2.location.href='../../eCommon/html/blank.html';
								parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
							}else{
								if(TT_empty==true){
									alert(getMessage("SCH_NOT_AVAILABLE","OA"));
									parent.frame2.location.href='../../eCommon/html/blank.html';
									parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
								}else{
									alert(getMessage("TIME_TABLE_TYPE_NOT_MATCH","OA"));
									parent.frame2.location.href='../../eCommon/html/blank.html';
									parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
								}
							}
						}
					}else{
						alert(getMessage("TRANS_NOT_ALLOW_FREE_FORMAT","OA"));
						parent.frame2.location.href='../../eCommon/html/blank.html';
						parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
					}
				}else if(error==false){
					alert(getMessage("SCH_NOT_AVAILABLE","OA"));
					parent.frame2.location.href='../../eCommon/html/blank.html';
					parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
				}else if(flag==false){
					alert(getMessage("NO_APPTS_TO_TRANS","OA"));
					parent.frame2.location.href='../../eCommon/html/blank.html';
					parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
				}
				}
			}
		}
	}else{
		parent.frame2.location.href = "../../eCommon/html/blank.html";
		parent.frame3submit.location.href = '../../eCommon/html/blank.html';
	}
}

function moveforward(result)
{
	
	var visit_limit_rule="";
	var from_speciality="";
	var to_speciality="";
	var locn_type="";
	var from_locn="";
	var to_locn="";
	var from_resc="";
	var to_resc="";
	var from_date="";
	var to_date="";
	var from_res_class="";
	var to_res_class="";
	var time_table_type="";
	var reason_code_revision="";
	var total_from_slot_count=0;
	var to_available_total_slots="";
	var to_available_first_visit_slots="";
	var to_available_other_visit_slots="";
	var total_to_srl_no="";
	
	visit_limit_rule=parent.parent.frames[1].document.getElementById('visit_limit_rule').value;
	from_speciality=parent.parent.frames[1].document.getElementById('speciality_from').value;
	to_speciality=parent.parent.frames[1].document.getElementById('speciality_to').value;
	locn_type=parent.parent.frames[1].document.getElementById('b_loc1').value;
	from_locn=parent.parent.frames[1].document.getElementById('from_locn').value;
	to_locn=parent.parent.frames[1].document.getElementById('to_locn').value;
	from_resc=parent.parent.frames[1].document.getElementById('practitioner').value;
	to_resc=parent.parent.frames[1].document.getElementById('practitioner2').value;
	from_date=parent.parent.frames[1].document.getElementById('b_from_date').value;
	from_date=parent.parent.frames[1].convertDate(from_date,"DMY",localeName,"en");
	to_date=parent.parent.frames[1].document.getElementById('b_to_date').value;
	to_date=parent.parent.frames[1].convertDate(to_date,"DMY",localeName,"en");
	from_res_class=parent.parent.frames[1].document.getElementById('resourceType1').value;
	to_res_class=parent.parent.frames[1].document.getElementById('resourceType3').value;
	time_table_type=parent.parent.frames[1].document.getElementById('time_table_type').value;
	reason_code_revision=parent.parent.frames[1].document.getElementById('reason_code_revision').value;
	total_from_slot_count=parent.frames[0].document.getElementById('total_from_slot_count').value;
	to_available_total_slots=parent.frames[2].document.getElementById('available_total_slots').value;
	to_available_first_visit_slots=parent.frames[2].document.getElementById('available_first_visit_slots').value;
	to_available_other_visit_slots=parent.frames[2].document.getElementById('available_other_visit_slots').value;
	total_to_srl_no=parent.frames[2].document.getElementById('total_to_srl_no').value;

	var from_date_greg=from_date;
	var to_date_greg=to_date;	
	from_locn=from_locn.split("$");
	from_locn=from_locn[1];
	to_locn=to_locn.split("$");
	to_locn=to_locn[1];
	
	var sel_from_no_of_slots="";
	var sel_from_appt_ref_no="";
	var sel_from_serial_no="";
	var sel_from_visit_type_ind="";
	var from_visit_type_ind="";
	var selected_appt_cnt=0;
	var from_total_first_vst_count=0;
	var from_total_other_vst_count=0;
	var finalval="";
	var serial_no="";
	var flag=true;

	if(time_table_type == 1){

		for (var i=0;i<total_from_slot_count;i++)
		{
			if(eval("parent.frames[0].document.forms[0].select_check_"+i))
			{  
				if(eval("parent.frames[0].document.forms[0].select_check_"+i).checked == true)
				{
					selected_appt_cnt++;

					sel_from_no_of_slots+=eval("parent.frames[0].document.forms[0].no_of_slots_"+i).value+"$";
					sel_from_appt_ref_no+=eval("parent.frames[0].document.forms[0].from_appt_ref_no_"+i).value+"$";
					sel_from_serial_no+=eval("parent.frames[0].document.forms[0].from_srl_no_"+i).value+"$";
					sel_from_visit_type_ind+=eval("parent.frames[0].document.forms[0].from_visit_type_ind_"+i).value+"$";
				}
			}
			
		
			
			/*if(eval("parent.frames[0].document.getElementById('select_check_"+i+"')"))
			{  
				if(eval("parent.frames[0].document.getElementById('select_check_"+i+"')").checked == true)
				{
					selected_appt_cnt++;

					sel_from_no_of_slots+=eval("parent.frames[0].document.getElementById('no_of_slots_"+i+"')").value+"$";
					sel_from_appt_ref_no+=eval("parent.frames[0].document.getElementById('from_appt_ref_no_"+i+"')").value+"$";
					sel_from_serial_no+=eval("parent.frames[0].document.getElementById('from_srl_no_"+i+"')").value+"$";
					sel_from_visit_type_ind+=eval("parent.frames[0].document.getElementById('from_visit_type_ind_"+i+"')").value+"$";
				}
			}
			*/
		}
		
		if(selected_appt_cnt > 0){
			var xmlDoc  = "";
			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH total_to_srl_no=\""+total_to_srl_no+"\" sel_from_no_of_slots=\""+sel_from_no_of_slots+"\"  sel_from_appt_ref_no=\""+sel_from_appt_ref_no+"\" sel_from_serial_no=\""+sel_from_serial_no+"\" sel_from_visit_type_ind=\""+sel_from_visit_type_ind+"\" action='to_sch_continuous_slots_chk' /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","OAIntermediate.jsp",false)
			xmlHttp.send(xmlDoc)
			var retval = xmlHttp.responseText
			retval = trimString(retval)

			if(retval == 'NOEMPTYSLOTS'){
				alert(getMessage("SELECTED_APPT_GREATER_THAN_AVAILABLE_SLOTS","OA"));
				flag=false;
			}else{
				retval = retval.split("||");
				var final_from_serial_no = retval[0];
				var final_from_appt_ref_no = retval[1];
				var final_from_visit_type_ind = retval[2];
				var tosrlresultList = retval[3];
				
				var result = processValues(total_to_srl_no, final_from_serial_no, final_from_appt_ref_no, final_from_visit_type_ind, tosrlresultList);

				var frmApptRefNo = result.frmApptRefNo;
				var frmSerialNo = result.frmSerialNo;
				var frmVisitTypeInd = result.frmVisitTypeInd;

				finalval = frmApptRefNo;
				serial_no = frmSerialNo;

				var counts = processCounts(frmApptRefNo, frmVisitTypeInd);

				selected_appt_cnt = counts.apptRefNoCount;
				from_total_first_vst_count = counts.fromTotalFirstVstCount;
				from_total_other_vst_count = counts.fromTotalOtherVstCount;
			}
		}

    }else{
		for (var i=0;i<total_from_slot_count;i++)
		{
			if(eval("parent.frames[0].document.forms(0).select_check_"+i))
			{  
				if(eval("parent.frames[0].document.forms(0).select_check_"+i).checked == true)
				{
					finalval+=eval("parent.frames[0].document.forms(0).from_appt_ref_no_"+i).value+"$";
					serial_no+=eval("parent.frames[0].document.forms(0).from_srl_no_"+i).value+"$";
					from_visit_type_ind=eval("parent.frames[0].document.forms(0).from_visit_type_ind_"+i).value;

					selected_appt_cnt++;

					if(from_visit_type_ind == "F"){
						from_total_first_vst_count++;
					}else{
						from_total_other_vst_count++;
					}
				}
			}
			
			/*if(eval("parent.frames[0].document.getElementById('select_check_"+i+"')"))
			{  
				if(eval("parent.frames[0].document.getElementById('select_check_"+i+"')").checked == true)
				{
					finalval+=eval("parent.frames[0].document.getElementById('from_appt_ref_no_"+i+"')").value+"$";
					serial_no+=eval("parent.frames[0].document.getElementById('from_srl_no_"+i+"')").value+"$";
					from_visit_type_ind=eval("parent.frames[0].document.getElementById('from_visit_type_ind_"+i+"')").value;

					selected_appt_cnt++;

					if(from_visit_type_ind == "F"){
						from_total_first_vst_count++;
					}else{
						from_total_other_vst_count++;
					}
				}
			}*/
			
		}
	}

	if(selected_appt_cnt <= 0){
		alert(getMessage("NO_SELECTED_APPOINTMENTS","OA"));
		flag=false;
	}
	
	if(flag==true){
		alert("flag:"+flag);
		if(selected_appt_cnt > 0){
			if(visit_limit_rule == 'N'){
				if(selected_appt_cnt > to_available_total_slots){
					alert(getMessage("SELECTED_APPT_GREATER_THAN_AVAILABLE_SLOTS","OA"));
					flag=false;
				}
			}else{
				if(from_total_first_vst_count > to_available_first_visit_slots || from_total_other_vst_count > to_available_other_visit_slots){
					alert(getMessage("SELECTED_APPT_GREATER_THAN_AVAILABLE_VISIT","OA"));
					flag=false;
				}
			}
		}
	}
	
	if(flag==true){ 
		var url='../../eOA/jsp/MultiSelectionApptReschedulingResult2.jsp?from_speciality='+from_speciality+"&to_speciality="+to_speciality+"&from_page='false'&locn_type="+locn_type+"&from_locn="+from_locn+"&to_locn="+to_locn+"&from_resc="+from_resc+"&to_resc="+to_resc+"&from_date="+from_date_greg+"&to_date="+to_date_greg+"&to_res_class="+to_res_class+"&from_res_class="+from_res_class+"&time_table_type="+time_table_type+"&reason_code_revision="+reason_code_revision+"&visit_limit_rule="+visit_limit_rule+"&from_selected_appt="+finalval+"&from_serial_no="+serial_no;
		parent.frames[2].location.href=url;
	}else{
		finalval = "";
		serial_no = "";
		var url='../../eOA/jsp/MultiSelectionApptReschedulingResult2.jsp?from_speciality='+from_speciality+"&to_speciality="+to_speciality+"&from_page='false'&locn_type="+locn_type+"&from_locn="+from_locn+"&to_locn="+to_locn+"&from_resc="+from_resc+"&to_resc="+to_resc+"&from_date="+from_date_greg+"&to_date="+to_date_greg+"&to_res_class="+to_res_class+"&from_res_class="+from_res_class+"&time_table_type="+time_table_type+"&reason_code_revision="+reason_code_revision+"&visit_limit_rule="+visit_limit_rule+"&from_selected_appt="+finalval+"&from_serial_no="+serial_no;
		parent.frames[2].location.href=url;
	}
}

function passvalues(){
	var time_table_type = parent.frames[2].frames[2].document.getElementById('time_table_type').value;
	var selected_appt_cnt = parent.frames[2].frames[2].document.getElementById('selected_appt_cnt').value;
	var fac_id = parent.frames[2].frames[2].document.getElementById('fac_id').value;
	var from_locn = parent.frames[2].frames[2].document.getElementById('from_locn').value;
	var from_resc = parent.frames[2].frames[2].document.getElementById('from_resc').value;
	var from_date = parent.frames[2].frames[2].document.getElementById('from_date').value;
	var to_locn = parent.frames[2].frames[2].document.getElementById('to_locn').value;
	var to_resc = parent.frames[2].frames[2].document.getElementById('to_resc').value;
	var to_date = parent.frames[2].frames[2].document.getElementById('to_date').value;
	var to_res_class = parent.frames[2].frames[2].document.getElementById('to_res_class').value;
	var reason_code_revision = parent.frames[2].frames[2].document.getElementById('reason_code_revision').value;
	var curr_user_id = parent.frames[2].frames[2].document.getElementById('curr_user_id').value;
	var workstation_id = parent.frames[2].frames[2].document.getElementById('workstation_id').value;
	var resch_status = "";

	if(selected_appt_cnt <= 0){
		alert(getMessage("NO_RECORD_INSERTION","OA"));
	}else{
		for(var i=0; i<selected_appt_cnt; i++){
			/*var from_srl_no = eval("parent.frames[2].frames[2].document.forms(0).from_srl_no_"+i).value;
			var to_srl_no = eval("parent.frames[2].frames[2].document.forms(0).to_srl_no_"+i).value;
			var trf_from_time = eval("parent.frames[2].frames[2].document.forms(0).trf_from_time_"+i).value;
			var trf_to_time = eval("parent.frames[2].frames[2].document.forms(0).trf_to_time_"+i).value;
			var selected_appt = eval("parent.frames[2].frames[2].document.forms(0).selected_appt_"+i).value;
			var no_of_slots = eval("parent.frames[2].frames[2].document.forms(0).no_of_slots_"+i).value;*/
			
			var from_srl_no = eval("parent.frames[2].frames[2].document.getElementById('from_srl_no_"+i+"')").value;
			var to_srl_no = eval("parent.frames[2].frames[2].document.getElementById('to_srl_no_"+i+"')").value;
			var trf_from_time = eval("parent.frames[2].frames[2].document.getElementById('trf_from_time_"+i+"')").value;
			var trf_to_time = eval("parent.frames[2].frames[2].document.getElementById('trf_to_time_"+i+"')").value;
			var selected_appt = eval("parent.frames[2].frames[2].document.getElementById('selected_appt_"+i+"')").value;
			var no_of_slots = eval("parent.frames[2].frames[2].document.getElementById('no_of_slots_"+i+"')").value;
			
			
			if(time_table_type == 2){
				no_of_slots = 1;
			}
			
			if(selected_appt != "~"){
				if (no_of_slots > 1) {
					var temp_to_srl_no = "";
					
					for(var j=0; j<no_of_slots; j++){
						var k = i+j;
						var tosrlnovalue = eval("parent.frames[2].frames[2].document.getElementById('to_srl_no_"+k+"')").value;
						temp_to_srl_no += tosrlnovalue;
						if (j < parseInt(no_of_slots)-1) {
							temp_to_srl_no += "-";
						}
					}
					to_srl_no = temp_to_srl_no;

					var tfrtotmitr = parseInt(i)+parseInt(no_of_slots)-1;
					trf_to_time = eval("parent.frames[2].frames[2].document.getElementById('trf_to_time_"+tfrtotmitr+"')").value;

					var xmlDoc = ""
					var xmlHttp = new XMLHttpRequest()
					xmlStr = "<root><SEARCH fac_id=\""+fac_id+"\" from_locn=\""+from_locn+"\" from_resc=\""+from_resc+"\" from_date=\""+from_date+"\" to_locn=\""+to_locn+"\" to_resc=\""+to_resc+"\" to_date=\""+to_date+"\" curr_user_id=\""+curr_user_id+"\" workstation_id=\""+workstation_id+"\" from_srl_no=\""+from_srl_no+"\" to_srl_no=\""+to_srl_no+"\" trf_from_time=\""+trf_from_time+"\" trf_to_time=\""+trf_to_time+"\" selected_appt=\""+selected_appt+"\" reason_code_revision=\""+reason_code_revision+"\" to_res_class=\""+to_res_class+"\" no_of_slots=\""+no_of_slots+"\" action='MultiSelectionApptRescheduling' /></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","../jsp/OAIntermediate.jsp",false)
					xmlHttp.send(xmlDoc)
					responseText = xmlHttp.responseText
					resch_status = trimString(responseText);

					i = parseInt(i)+parseInt(no_of_slots)-1;
				}else{
					var xmlDoc = ""
					var xmlHttp = new XMLHttpRequest()
					xmlStr = "<root><SEARCH fac_id=\""+fac_id+"\" from_locn=\""+from_locn+"\" from_resc=\""+from_resc+"\" from_date=\""+from_date+"\" to_locn=\""+to_locn+"\" to_resc=\""+to_resc+"\" to_date=\""+to_date+"\" curr_user_id=\""+curr_user_id+"\" workstation_id=\""+workstation_id+"\" from_srl_no=\""+from_srl_no+"\" to_srl_no=\""+to_srl_no+"\" trf_from_time=\""+trf_from_time+"\" trf_to_time=\""+trf_to_time+"\" selected_appt=\""+selected_appt+"\" reason_code_revision=\""+reason_code_revision+"\" to_res_class=\""+to_res_class+"\" no_of_slots=\""+no_of_slots+"\" action='MultiSelectionApptRescheduling' /></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","../jsp/OAIntermediate.jsp",false)
					xmlHttp.send(xmlDoc)
					responseText = xmlHttp.responseText
					resch_status = trimString(responseText);
				}
			}
		}
		
		if(resch_status == 'SUCCESS'){
			alert(getMessage("RECORD_INSERTED","SM"));
			parent.frames[1].location.reload();
			parent.frames[2].location.href="../../eCommon/html/blank.html";
			parent.frames[3].location.href="../../eCommon/html/blank.html";
		}
	}
}

async function reasonlookup_revise(){
	var locale=document.getElementById('locale').value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var target="";

	var sql = "Select CONTACT_REASON_CODE code, CONTACT_REASON description from AM_CONTACT_REASON_LANG_VW where TRANSFER_APPOINTMENT_YN = 'Y' and Eff_Status = 'E' and language_id = '"+locale+"' and upper(CONTACT_REASON_CODE) like upper(?) and upper(CONTACT_REASON) like upper(?) Order by 1";

	argumentArray[0] = sql ;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = document.getElementById('reason_for_revision').value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC ; 

	retVal = await CommonLookup(getLabel("Common.reason.label","Common"), argumentArray );

	var arr=new Array();
	if (retVal != null && retVal != '' && retVal != "null"){
		var retVal=unescape(retVal);
		arr=retVal.split(",");
		var desc=arr[1];
		var code=arr[0];
		document.getElementById('reason_for_revision').value=desc;
		document.getElementById('reason_code_revision').value=code;
	}else{
		document.getElementById('reason_for_revision').value="";
		document.getElementById('reason_code_revision').value="";
	}
}

function Disable_loctype(){
	document.getElementById('speciality_from').focus();
	document.getElementById('b_loc1').value="";
	document.getElementById('b_loc1').disabled=true;
	document.getElementById('b_loc2').value="";
	document.getElementById('b_loc2').disabled=true;
	document.getElementById('b_loc_val_from').disabled=true;
	document.getElementById('b_loc_search_from').disabled=true;
	document.getElementById('b_loc_val_to').disabled=true;
	document.getElementById('b_loc_search_to').disabled=true;
}

function enable_fromloc(){
	var Spclty = document.getElementById('speciality_from').value;
	if(Spclty == ""){
		document.getElementById('b_loc1').value="";
		document.getElementById('b_loc1').disabled=true;
		document.getElementById('b_loc2').value="";
		var n=document.getElementById('b_loc2').options.length;
		for(var i=0;i<n;i++){
			document.getElementById('b_loc2').remove("clinic");
		}
		var opt=document.createElement("OPTION");
		opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
		opt.value="";
		document.getElementById('b_loc2').add(opt);  
		document.getElementById('from_locn').value="";
		document.getElementById('b_loc_val_from').disabled=true;
		document.getElementById('b_loc_search_from').disabled=true;
	}else{
		document.getElementById('b_loc1').disabled=false;
	}
}

function clearvalue(){
	var Spclty1 = document.getElementById('speciality_to').value;
	if(Spclty1 == ""){
		if(document.getElementById('b_loc1').value !=""){
			document.getElementById('b_loc2').value=document.getElementById('b_loc1').value;
		}else{
			var n = document.getElementById('b_loc2').options.length;
			for(var i=0;i<n;i++){
				document.getElementById('b_loc2').remove("clinic");
			}  
			var opt=document.createElement("OPTION");
			opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
			opt.value="";
			document.getElementById('b_loc2').add(opt);  
			document.getElementById('to_locn').value="";  
		}
	}else{
		document.getElementById('b_loc2').value=document.getElementById('b_loc1').value;
	}
}

function populatepract_to_Spty(Obj){

	var locationtype = document.getElementById('b_loc1').value;
	document.getElementById('practitioner_name2').value="";
	document.getElementById('practitioner2').value="";
	document.getElementById('practitioner_name2').disabled=true;
	document.getElementById('practitioner2').disabled=true;
	var b_loc2_val=document.getElementById('b_loc2');

	if(Obj.value==null || Obj.value==""){
		document.getElementById('b_loc_val_to').value="";
		document.getElementById('to_locn').value="";
		document.getElementById('b_loc_val_to').disabled=true;
		document.getElementById('b_loc_search_to').disabled=true;
	}else{
		document.getElementById('b_loc_val_to').value="";
		document.getElementById('to_locn').value="";
		if(b_loc2_val.value==null || b_loc2_val.value==""){
			document.getElementById('b_loc_val_to').disabled=true;
			document.getElementById('b_loc_search_to').disabled=true;
		}else{
			document.getElementById('b_loc_val_to').disabled=false;
			document.getElementById('b_loc_search_to').disabled=false;
		}
	}
	if(Obj.value=='C'){
		document.getElementById('resourceType2').value='P';
	}else{
		document.getElementById('resourceType2').value='';
	}

	document.getElementById('resourceType2').value='';
}

function populatepract_from_Spty(Obj){

	var locationtype = document.getElementById('b_loc1').value;
	document.getElementById('practitioner_name').value="";
	document.getElementById('practitioner').value="";
	document.getElementById('practitioner_name').disabled=true;
	document.getElementById('practitioner').disabled=true;
	document.getElementById('b_loc_val_from').value="";
	document.getElementById('from_locn').value="";

	if(Obj.value=='C'){
		document.getElementById('resourceType').value='P';
	}else{
		document.getElementById('resourceType').value='';
	}

	document.getElementById('resourceType').value='';
}

async function open_loc_lookup_from(){
	var location_val=document.getElementById('b_loc_val_from').value;
	var locn_type=document.getElementById('b_loc1').value;
	var care_locn_ind=document.getElementById('b_loc1').value;
	var speciality_code=document.getElementById('speciality_from').value;
	var dialogTop = "90vh" ;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments = "" ;
	var tit="locn_Srch";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var retVal = "";
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&speciality_code="+speciality_code+"&care_locn_ind="+care_locn_ind+"&function_id=BULK_TRANSFER",arguments,features);
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var clinic_code=rvalues[0];
		var desc=rvalues[1];		
		var open_to_all_pract_yn=rvalues[2];
		var resource_type=rvalues[3];
		document.getElementById('b_loc_val_from').value=desc;
		document.getElementById('from_locn').value=open_to_all_pract_yn+"$"+clinic_code+"$"+resource_type;
		enablepract_from(document.getElementById('from_locn'));
		FnCheckIsGroupLocation(clinic_code);
	}else{
		document.getElementById('b_loc_val_from').value="";
		document.getElementById('from_locn').value="";
		enablepract_from(document.getElementById('from_locn'));
	}
}

function ena_loc_lookup_from(obj){
	if(obj.value==null || obj.value==''){
		document.getElementById('b_loc_val_from').value="";
		document.getElementById('from_locn').value="";
		enablepract_from(document.getElementById('from_locn'));
	}else{
		open_loc_lookup_from()
	}
}

async function open_loc_lookup_to(){	
	var location_val=document.getElementById('b_loc_val_to').value;
	var locn_type=document.getElementById('b_loc2').value;
	var care_locn_ind=document.getElementById('b_loc2').value;
	var speciality_code=document.getElementById('speciality_to').value;
	var dialogTop = "60vh" ;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var retVal="";
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&speciality_code="+speciality_code+"&care_locn_ind="+care_locn_ind+"&function_id=BULK_TRANSFER",arguments,features);
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var clinic_code=rvalues[0];
		var desc=rvalues[1];
		var open_to_all_pract_yn=rvalues[2];
		var resource_type=rvalues[3];
		document.getElementById('b_loc_val_to').value=desc;
		document.getElementById('to_locn').value=open_to_all_pract_yn+"$"+clinic_code+"$"+resource_type;
		enablepract_to(document.getElementById('to_locn'));
	}else{
		document.getElementById('b_loc_val_to').value="";
		document.getElementById('to_locn').value="";
		enablepract_to(document.getElementById('to_locn'));
	}
}

function ena_loc_lookup_to(obj){
		if(obj.value==null || obj.value==''){
			document.getElementById('b_loc_val_to').value="";
			document.getElementById('to_locn').value="";
		enablepract_to(document.getElementById('to_locn'));
	}else{
	open_loc_lookup_to();
	}
}

function FnCheckIsGroupLocation(locnCode){
	$.ajax({  
	      url:'../../eOA/jsp/GetGroupLocation.jsp',  
	      type:'post',  
	      data:{'action':'chk_is_group_location','locnCode':locnCode},
	      dataType: 'json',
	      success: function(data) {
				if(data.isJsonResults==1){
					 if(data.IsGroupLocation > 0){
						$("#is_group_location").val("Y");
				 	 }else{
				 		$("#is_group_location").val("N");
				 	 }
				}	 
	      },
	      error: function(jqXHR, textStatus, errorThrown) {
	          alert("incoming Text " + jqXHR.responseText);
	      }
	});
}

function checkbox_value(obj)
{
	if (obj.checked == true)
		obj.value='Y';
	else
		obj.value='N';
}

function processValues(total_to_srl_no, final_from_serial_no, final_from_appt_ref_no, final_from_visit_type_ind, tosrlresultList) {
	var toTotalSrlNo = total_to_srl_no.split('$');
    var fromSerialNo = final_from_serial_no.split('$');
	if(final_from_appt_ref_no==undefined)
		final_from_appt_ref_no = "";
	if(final_from_visit_type_ind==undefined)
		final_from_visit_type_ind ="";
	if(tosrlresultList==undefined)
		tosrlresultList = "";
    var fromApptRefNo = final_from_appt_ref_no.split('$');
    var fromVisitTypeInd = final_from_visit_type_ind.split('$');
    var toSrlResultList = tosrlresultList.split('$');

	for (var i = 0; i < toSrlResultList.length; i++) {
        toSrlResultList[i] = toSrlResultList[i].split('^');
    }

    var frmserialNoList = [];
	var frmapptRefNoList = [];
    var frmvisitTypeIndList = [];

     for (var tIndex = 0; tIndex < toTotalSrlNo.length; tIndex++) {
        var srlNo = toTotalSrlNo[tIndex];
        var matched = false;

        for (var i = 0; i < toSrlResultList.length; i++) {
            for (var j = 0; j < toSrlResultList[i].length; j++) {
                if (toSrlResultList[i][j] == srlNo) {
                    frmserialNoList[tIndex] = fromSerialNo[i];
                    frmapptRefNoList[tIndex] = fromApptRefNo[i];
                    frmvisitTypeIndList[tIndex] = fromVisitTypeInd[i];
                    matched = true;
                    break;
                }
            }
            if (matched) {
                break;
            }
        }

        if (!matched) {
            frmserialNoList[tIndex] = '~';
            frmapptRefNoList[tIndex] = '~';
            frmvisitTypeIndList[tIndex] = '~';
        }
    }
    
    var serialNoResult = frmserialNoList.join('$');
    var apptRefNoResult = frmapptRefNoList.join('$');
    var visitTypeIndResult = frmvisitTypeIndList.join('$');

    return {
		frmSerialNo: serialNoResult,
        frmApptRefNo: apptRefNoResult,
        frmVisitTypeInd: visitTypeIndResult
    };
}

function processCounts(frmApptRefNo, frmVisitTypeInd) {
    var apptRefNoArray = frmApptRefNo.split('$');
    var visitTypeIndArray = frmVisitTypeInd.split('$');
    
    var apptRefNoCount = 0;
    var fromTotalFirstVstCount = 0;
    var fromTotalOtherVstCount = 0;

    for (var i = 0; i < apptRefNoArray.length; i++) {
        if (apptRefNoArray[i] !== '~') {
            apptRefNoCount++;
        }
    }

    for (var j = 0; j < visitTypeIndArray.length; j++) {
        if (visitTypeIndArray[j] === 'F') {
            fromTotalFirstVstCount++;
        } else if (visitTypeIndArray[j] !== '~') {
            fromTotalOtherVstCount++;
        }
    }

    return {
        apptRefNoCount: apptRefNoCount,
        fromTotalFirstVstCount: fromTotalFirstVstCount,
        fromTotalOtherVstCount: fromTotalOtherVstCount
    };
}