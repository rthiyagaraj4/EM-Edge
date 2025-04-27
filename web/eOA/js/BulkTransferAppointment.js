/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function populatepract_from(Obj){
	
	//var locationtype = document.forms[0].all.b_loc1.value;
	var locationtype = document.getElementById("b_loc1").value;
	if(locationtype==""){
		var n=document.forms[0].b_loc2.options.length;
		for(var i=0;i<n;i++){
			document.forms[0].b_loc2.remove("clinic");
		}
		var opt=document.createElement("OPTION");
		opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
		opt.value="";
		document.forms[0].b_loc2.add(opt);  
	}
	/*var n=document.forms[0].from_locn.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].from_locn.remove("clinic");
		}*/
	//var locationtype = document.forms[0].all.b_loc1.value;
	var locationtype = document.getElementById("b_loc1").value;
	document.getElementById("resourceType1").value=document.getElementById("b_loc1").value;
	document.getElementById("specialty_code1").value=document.getElementById("speciality_from").value;
	document.getElementById("practitioner_name").value="";
	document.getElementById("practitioner").value="";
	document.getElementById("practitioner_name").disabled=true;
	document.getElementById("practitioner").disabled=true;
	document.getElementById("practitioner_name2").value="";
	document.getElementById("practitioner2").value="";
	document.getElementById("practitioner_name2").disabled=true;
	document.getElementById("practitioner2").disabled=true;
	if(Obj.value==null||Obj.value==""){
		document.forms[0].b_loc_val_from.value="";
		document.forms[0].from_locn.value="";
		document.forms[0].b_loc_val_from.disabled=true;
		document.forms[0].b_loc_search_from.disabled=true;
		document.forms[0].b_loc_val_to.value="";
		document.forms[0].to_locn.value="";
		document.forms[0].b_loc_val_to.disabled=true;
		document.forms[0].b_loc_search_to.disabled=true;
	}else{
		document.forms[0].b_loc_val_from.value="";
		document.forms[0].from_locn.value="";
		document.forms[0].b_loc_val_from.disabled=false;
		document.forms[0].b_loc_search_from.disabled=false;
		document.forms[0].b_loc_val_to.value="";
		document.forms[0].to_locn.value="";
		var to_splity=document.forms[0].speciality_to;
		if(to_splity.value==null || to_splity.value==""){
			document.forms[0].b_loc_val_to.disabled=true;
			document.forms[0].b_loc_search_to.disabled=true;
		}else{
			document.forms[0].b_loc_val_to.disabled=false;
			document.forms[0].b_loc_search_to.disabled=false;
		}
	}
	if(Obj.value=='C'){
		document.getElementById("resourceType").value='P';
	}else{
		document.getElementById("resourceType").value='';
	}
}

function clear_locations(obj){
	var CARE_LOCN_TYPE_IND = document.getElementById("b_loc1").value;
	document.getElementById('b_loc2').readonly=false;
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH steps='bulk_Loc' CARE_LOCN_TYPE_IND=\""+CARE_LOCN_TYPE_IND+"\" /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOA/jsp/BulkTransfervalidation.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText); 
}

function populatepract_to(Obj){
	/*var n=document.forms[0].to_locn.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].to_locn.remove("clinic");
	}*/
	var locationtype = document.getElementById("b_loc1").value;
	document.getElementById("locationType1").value=document.getElementById("b_loc2").value;
	document.getElementById("specialty_code2").value=document.getElementById("speciality_to").value;
	document.getElementById("practitioner_name2").value="";
	document.getElementById("practitioner2").value="";
	document.getElementById("practitioner_name2").disabled=true;
	document.getElementById("practitioner2").disabled=true;
	if(Obj.value=='C'){
		document.getElementById("resourceType1").value="P";
	}else{
		document.getElementById("resourceType1").value='';
	}
}

function enablepract_from(Obj){
	document.getElementById("practitioner_name").disabled=false;
	document.getElementById("search_pract").disabled=false;
	document.getElementById("practitioner_name").value="";
	var ObjVal=Obj.value;
	var arr=ObjVal.split("$");
	var clnc_cd=arr[1];
	var clinic_type=parent.frames[1].document.forms[0].b_loc1.value;
	var open_to_all_pract_yn =ObjVal.substring(0,1);
	if(ObjVal==''){
		document.forms[0].practitioner_name.value='';
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
	}else{
		document.forms[0].practitioner_name.value='';
		document.forms[0].practitioner_name.disabled=false;
		document.forms[0].search_pract.disabled=false;
	}
	if(open_to_all_pract_yn =="Y"){
		document.forms[0].imgpract.style.visibility='visible';
	}else{
		document.forms[0].imgpract.style.visibility='hidden';
	}
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+clinic_type+"\" clinic_code1=\""+clnc_cd+"\"  location=\""+Obj.value+"\" speciality_code=\""+document.forms[0].speciality_from.value+"\" steps='bulk_enable_pract_from' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","BulkTransfervalidation.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}

function enablepract_to(Obj){
	document.getElementById("practitioner_name2").disabled=false;
	document.getElementById("search_pract2").disabled=false;
	document.getElementById("practitioner_name2").value="";
	var ObjVal=Obj.value;
	var arr=ObjVal.split("$");
	var clnc_cd=arr[1];
	var clinic_type=parent.frames[1].document.forms[0].b_loc1.value;
	if(ObjVal==''){
		document.forms[0].practitioner_name2.value='';
		document.forms[0].practitioner_name2.disabled=true;
		document.forms[0].search_pract2.disabled=true;
	}else{
		document.forms[0].practitioner_name2.value='';
		document.forms[0].practitioner_name2.disabled=false;
		document.forms[0].search_pract2.disabled=false;
	}
	var open_to_all_pract_yn =ObjVal.substring(0,1);
	if(open_to_all_pract_yn =="Y"){
		document.forms[0].imgpract2.style.visibility='visible';
	}else{
		document.forms[0].imgpract2.style.visibility='hidden';
	}
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+clinic_type+"\" clinic_code1=\""+clnc_cd+"\" location=\""+Obj.value+"\" speciality_code=\""+document.forms[0].speciality_to.value+"\" steps='bulk_enable_pract_to' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","BulkTransfervalidation.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}

function enable_lonc_type(obj){
	document.forms[0].b_loc1.value="";
	var n=document.forms[0].from_locn.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].from_locn.remove("clinic");
	}
	var opt=document.createElement("OPTION");
	opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt.value="";
	document.forms[0].from_locn.add(opt);
	var m=document.forms[0].to_locn.options.length;
	for(var j=0;j<m;j++){
		document.forms[0].to_locn.remove("clinic");
	}
	var opt1=document.createElement("OPTION");
	opt1.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt1.value="";
	document.forms[0].to_locn.add(opt1);
	if(obj.value !=""){
		document.forms[0].b_loc1.disabled=false;
	}else{
		document.forms[0].b_loc1.disabled=true;
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

function DateCompare3(from,to){
	if(from.value!="" && to.value!="" ){
		if(isBefore(from.value,to.value,'DMY',localeName)==false){
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.select();	
			return false;
		}else{
			return true;
		}
	}
}

function DateCompare4(from,to){
	if(from.value!="" && to.value!="" ){
		if(isBefore(from.value,to.value,'DMY',localeName)==false){
			var msg = f_query_add_mod.getMessage('TO_DT_GR_EQ_FM_DT','SM');
			messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
			return false;
		}else{
			return true;
		}
	}
}

function reset(){
	frames[1].location.reload();
	//frames[2].location.reload();
	frames[2].location.href="../../eCommon/html/blank.html";
	frames[3].location.href="../../eCommon/html/blank.html";
}
function clearResult(){
	parent.frames[2].location.href = '../../eCommon/html/blank.html';	
	parent.frame3submit.location.href =  '../../eCommon/html/blank.html';
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
	var is_group_location = parent.frames[1].document.forms[0].is_group_location.value; 
	
	from_speciality=parent.frames[1].document.forms[0].speciality_from.value;
	
	to_speciality=parent.frames[1].document.forms[0].speciality_to.value;
	locn_type=parent.frames[1].document.forms[0].b_loc1.value;
	from_locn=parent.frames[1].document.forms[0].from_locn.value;
	to_locn=parent.frames[1].document.forms[0].to_locn.value;
	from_resc=parent.frames[1].document.forms[0].practitioner.value;
	to_resc=parent.frames[1].document.forms[0].practitioner2.value;
	from_date=parent.frames[1].document.forms[0].b_from_date.value;
	to_date=parent.frames[1].document.forms[0].b_to_date.value;
	from_res_class=parent.frames[1].document.forms[0].resourceType1.value;
	to_res_class=parent.frames[1].document.forms[0].resourceType3.value;
	oper_stn=parent.frames[1].document.forms[0].oper_stn.value;
	visit_limit_rule=parent.frames[1].document.forms[0].visit_limit_rule.value;
	var from_date_greg=convertDate(from_date,"DMY",localeName,"en");
	var to_date_greg=convertDate(to_date,"DMY",localeName,"en");	
	from_locn=from_locn.split("$");
	from_locn=from_locn[1];
	to_locn=to_locn.split("$");
	to_locn=to_locn[1];


	var fields = new Array ( parent.frames[1].document.forms[0].speciality_from,
							 parent.frames[1].document.forms[0].speciality_to,
							 parent.frames[1].document.forms[0].b_loc1,
							 parent.frames[1].document.forms[0].b_loc2,
							 parent.frames[1].document.forms[0].from_locn,
						     parent.frames[1].document.forms[0].to_locn,
							 parent.frames[1].document.forms[0].b_from_date,
							 parent.frames[1].document.forms[0].b_to_date,
							 parent.frames[1].document.forms[0].reason_code_revision
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
			fields[fields.length]=parent.frames[1].document.forms[0].practitioner_name;
			names[names.length]=getLabel("Common.from.label","Common")+" "+getLabel("Common.resource.label","Common");
		}
	}
	if(parent.frames[1].document.getElementById('imgpract2')){		
		if(parent.frames[1].document.getElementById('imgpract2').style.visibility == 'visible'){
			fields[fields.length]=parent.frames[1].document.forms[0].practitioner_name2;
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
				parent.frames[1].document.forms[0].to_locn.options.selectedIndex=0;
				parent.frames[1].document.forms[0].practitioner_name2.value="";
				parent.frames[1].document.forms[0].practitioner2.value="";
			}else{
		
				var Sys_date=parent.frames[1].document.forms[0].Sys_date.value;
				var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()
				xmlStr ="<root><SEARCH clinic_type=\""+from_locn+"\" resc_code=\""+from_resc+"\" from_date =\""+from_date_greg+"\" resc_class=\""+from_res_class+"\" clinic_type_to=\""+to_locn+"\" resc_code_to=\""+to_resc+"\" to_date =\""+to_date_greg+"\" resc_class_to=\""+to_res_class+"\" locn_type=\""+locn_type+"\" Sys_date=\""+Sys_date+"\" steps='bulktransfer_sch_exists' /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","BulkTransfervalidation.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				responseText = trimString(responseText)
				eval(responseText)
				
				//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
				if(schedule_extend_to > 0 || schedule_extend_from > 0)
				{
					alert(getMessage("EXTENDEDSCH_EXST_CNT_BULKTRANS","OA"));
					parent.frame2.location.href='../../eCommon/html/blank.html';
					parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
				}
				else 
				{
					if(flag==true && error==true){
					var xmlDoc = ""
					var xmlHttp = new XMLHttpRequest()
					xmlStr ="<root><SEARCH clinic_type=\""+from_locn+"\" resc_code=\""+from_resc+"\" from_date =\""+from_date_greg+"\" resc_class=\""+from_res_class+"\" clinic_type_to=\""+to_locn+"\" resc_code_to=\""+to_resc+"\" to_date =\""+to_date_greg+"\" resc_class_to=\""+to_res_class+"\" locn_type=\""+locn_type+"\" steps='bulktransfer_slot_slab_freeformat' /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","BulkTransfervalidation.jsp",false)
					xmlHttp.send(xmlDoc)
					responseText=xmlHttp.responseText
					responseText = trimString(responseText)
					eval(responseText)
					if(flag2==true){
						if(flag1==true){
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
							parent.frames[1].document.forms[0].max_first_visits_from.value=max_first_visits_from;
							parent.frames[1].document.forms[0].max_other_visits_from.value=max_other_visits_from;
							parent.frames[1].document.forms[0].max_from_slot.value=max_pap_per_day_tot_from;
							parent.frames[1].document.forms[0].total_first_visit_slots_booked_from1.value=total_first_visit_slots_booked_from1;
							parent.frames[1].document.forms[0].total_other_visit_slots_booked_from1.value=total_other_visit_slots_booked_from1;
							parent.frames[1].document.forms[0].total_first_visit_slots_booked_to1.value=max_first_visits_to1-total_first_visit_slots_booked_to1;
							parent.frames[1].document.forms[0].total_other_visit_slots_booked_to1.value=max_other_visits_to1-total_other_visit_slots_booked_to1;
							var max_pat_per_day1=max_pat_per_day;
							var tot_booked1=tot_booked;
							var max_forced_in_booking1=max_forced_in_booking;
							var total_forced_in_booked_to1=total_forced_in_booked_to;
							var forced_val=max_forced_in_booking1-total_forced_in_booked_to1;
							var max_pap_per_day_tot=parseInt(max_pat_per_day1)+parseInt(forced_val);
							var total_booked=max_pap_per_day_tot-tot_booked1;
							parent.frames[1].document.forms[0].max_to_slot.value=total_booked;
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
							
							parent.frames[1].document.forms[0].total_from_over_booked.value=total_overbooked_from;
							parent.frames[1].document.forms[0].total_to_over_booked.value=total_to_over_booked;
							parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
							var url='../../eOA/jsp/BulkTransferAppointmentResultFrame.jsp?from_speciality='+from_speciality+"&to_speciality="+to_speciality+"&from_page=true&locn_type="+locn_type+"&from_locn="+from_locn+"&to_locn="+to_locn+"&from_resc="+from_resc+"&to_resc="+to_resc+"&from_date="+from_date_greg+"&to_date="+to_date_greg+"&to_res_class="+to_res_class+"&from_res_class="+from_res_class+"&oper_stn="+oper_stn+"&visit_limit_rule="+visit_limit_rule;
							parent.frame2.location.href = url;
							parent.frame3submit.location.href = '../../eOA/jsp/BulkTransferAppointmentSubmitPage.jsp?';
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

function show_Reference_details_results(appt_no2,fac_id2){
	var dialogHeight= "23" ;
	var dialogWidth	= "54" ;
	var dialogTop = "190" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	window.showModalDialog("../../eOA/jsp/SecApptReferenceFrame.jsp?appt_no2="+appt_no2+"&fac_id2="+fac_id2,arguments,features);
}

function selectAll(obj){
	var cnt= parent.frames[0].document.forms[0].counter.value;
	if(obj.checked==true){
		for (var i=0;i<=cnt ;i++ ){
			if(eval("parent.frames[0].document.forms[0].chk"+i)){
				if(eval("parent.frames[0].document.forms[0].chk"+i).disabled ==false){
					eval("parent.frames[0].document.forms[0].chk"+i).checked=true;
				}
			}
		}
	}else{
		for (var j=0;j<=cnt ;j++ ){
			if(eval("parent.frames[0].document.forms[0].chk"+j)){
				if(eval("parent.frames[0].document.forms[0].chk"+j).disabled ==false){
					eval("parent.frames[0].document.forms[0].chk"+j).checked=false;
				}
			}
		}
	}
	Apply();
}

function scrollheader1(){
	var x = document.body.scrollTop;
	var from_page="<%=from_page%>";
	if(x == 0){
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
		if(from_page!="true"){
			if(document.getElementById('head7')){
				document.getElementById('head7').style.position='static';
			    document.getElementById('head7').style.posTop  = 0;
			}
		}
    }else{
		document.getElementById('head1').style.position = 'relative';
		document.getElementById('head1').style.posTop  = x;
		document.getElementById('head2').style.position = 'relative';
		document.getElementById('head2').style.posTop  = x;
		document.getElementById('head3').style.position = 'relative';
		document.getElementById('head3').style.posTop  = x;
		document.getElementById('head4').style.position = 'relative';
		document.getElementById('head4').style.posTop  = x;
		document.getElementById('head5').style.position = 'relative';
		document.getElementById('head5').style.posTop  = x;
		document.getElementById('head6').style.position = 'relative';
		document.getElementById('head6').style.posTop  = x;
		if(from_page!="true"){
			if(document.getElementById('head7')){
				document.getElementById('head7').style.position='relative';
				document.getElementById('head7').style.posTop  = x;
			}
		}
	}
}

async function show_second(obj,sec_resources,u,u1,patient_id1,appt_type_code,visit_type_short_desc,obj2,appt_ref_no){
	var sel_secondary="";
	var fromTime	= u;
	var toTime		=u1;
	var pat_id=patient_id1;
	var res_class_desc="";
	var care_locn_desc="";
	var srl_no_sel="";
	var facility_id = parent.frames[2].document.forms[0].fac_id.value;
	var u			= visit_type_short_desc;
	var clinic_code	= parent.frames[2].document.forms[0].to_locn.value;
	var clinic_date	= parent.frames[2].document.forms[0].to_date.value;
	var practitioner_id	=parent.parent.frames[1].document.forms[0].practitioner2.value;
	var visittypecode=appt_type_code;
	var time_table_type=parent.frames[2].document.forms[0].time_table_type.value;
	var locn_name =parent.parent.frames[1].document.forms[0].to_locn.value;
	locn_name=locn_name.split("$");
	var clinic_name_sec=locn_name[2];
	var pract_name_pri=parent.parent.frames[1].document.forms[0].practitioner_name2.value;
	var ServerTime =parent.frames[2].document.forms[0].sys_time.value;
	var ServerDate =parent.frames[2].document.forms[0].sys_date.value;
	var dialogHeight= "29" ;
	var dialogTop = "125" ;
	var dialogWidth	= "50" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var no_of_slots=parent.frames[2].document.forms[0].no_of_slots.value	
	var sec_req=sec_resources;	
	var res_class=parent.parent.frames[1].document.forms[0].resourceType2.value	;
	if(res_class=="P"){
		res_class_desc=getLabel("Common.practitioner.label","Common");
	}else if(res_class=="E"){
		res_class_desc=getLabel("Common.equipment.label","Common");
	}else if(res_class=="R"){
		res_class_desc=getLabel("Common.room.label","Common");
	}else if(res_class=="O"){
		res_class_desc=getLabel("Common.other.label","Common");
	}else if(res_class=="B"){
		res_class_desc=getLabel("Common.Bed.label","Common");
	}
	var clinic_type=parent.frames[2].document.forms[0].locn_type.value;
	if(clinic_type=="C"){
		care_locn_desc=getLabel("Common.clinic.label","Common");
	}else if(clinic_type=="E"){
		care_locn_desc=getLabel("Common.ProcedureUnit.label","Common");
	}else if(clinic_type=="D"){
		care_locn_desc=getLabel("Common.DaycareUnit.label","Common");
	}
	var flag=false;
	var prev_val;
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
    sel_secondary=parent.frames[2].document.forms[0].sec_sel.value;
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	var retVal="N";
	xmlStr ="<root><SEARCH sel_sec = \""+sel_secondary+"\" sec_req=\""+sec_resorces+"\" clinic_code=\""+clinic_code+"\" clinic_date=\""+clinic_date+"\" facility_id=\""+facility_id+"\" time_table_type=\""+time_table_type+"\"  steps='ADD_SEC_TO_SESSION'/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","BulkTransfervalidation.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
	var sec_res_value;
	sec_res_value=parent.frames[2].document.forms[0].sec_value_count.value;
	var newval;
	var current_val;
	current_val=obj2;
	if(obj.checked==true){
		if(sec_res_value!==''){
			callurl="../../eOA/jsp/SecResMain.jsp?from_page=bulk&Clinic_Code="+clinic_code+"&Practitioner_id="+practitioner_id+"&From_time="+fromTime+"&To_time="+toTime+"&VisitTypeCD="+visittypecode+"&Appt_date="+clinic_date+"&time_table_type="+time_table_type+"&patient_id="+pat_id+"&no_of_slots="+no_of_slots+"&res_class="+res_class+"&clinic_type="+clinic_type+"&sec_resorces="+escape(sec_resorces)+"&sec_resorces_req="+escape(sec_resorces_req)+"&sec_resorces1="+escape(sec_resorces1)+"&clinic_name_sec="+escape(clinic_name_sec)+" &care_locn_desc_sec="+escape(care_locn_desc)+" &pract_name_pri="+escape(pract_name_pri)+" &res_pri_class_desc="+escape(res_class_desc)+"&visit_type_des="+escape(u)+"&sec_req="+escape(sec_req)+"&ServerTime="+escape(ServerTime)+"&ServerDate="+escape(ServerDate)+"&row_cnt="+appt_ref_no;
			retVal = await window.showModalDialog(callurl,arguments,features);	
			if(retVal =="undefined" || retVal=="N" || retVal==null || retVal==""){
				selectvalue("false","",current_val);
			}
			if(retVal==null){
				retVal='';
			}
			if(retVal !=""){
				var retVal1=retVal.split("||");
				parent.frames[2].document.getElementById('sec_sel').value=retVal1[0];
				newval=retVal1[1];
				prev_val=retVal1[2];
				parent.parent.frames[1].document.forms[0].prev_values.value=prev_val;
				parent.parent.frames[1].document.forms[0].sec_values.value=newval;
				if(retVal1[2] =="N"){
					obj.checked=false;
				}
				parent.parent.frames[1].document.forms[0].sec_values.value=newval;
				srl_no_sel=retVal1[3];
			}
			var secval2=parent.parent.frames[1].document.forms[0].sec_values.value;
			var secval3=parent.frames[2].document.forms[0].sec_sel.value;
			var n=9;
			var arrlst2=secval2.split("@");
			var arrlst_srl_no=srl_no_sel.split("@");
			var arrlst3;
			var arrlst4;
			var chk_val_main="";
			var chk_val_srl_no="";
			var final_val="";
			for (var m=0;m<arrlst_srl_no.length-1;m++ ){
				chk_val_srl_no=arrlst_srl_no[m];
				for (i=0;i<arrlst2.length-1;i++){
					arrlst3=arrlst2[i].split(',');
					if(arrlst3[8] == chk_val_srl_no){
						final_val=arrlst2[i]+"@"+final_val;
					}
				}
			}
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH sel_sec = \""+final_val+"\"  steps='REMOVE_ADD_BULK_SEC_TO_SESSION'/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","BulkTransfervalidation.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText)
		}else{
			alert(getMessage("NO_SEC_SCHEDULES_AVLBL","OA"));
			obj.checked=false;
		
		}
	}else{
		sec_res_value=parent.frames[2].document.forms[0].sec_value_count.value;
		if(sec_res_value!==''){
			var secval2=parent.parent.frames[1].document.forms[0].sec_values.value;
			var secvalsize2=parent.parent.frames[1].document.forms[0].sec_values.size;
			var n=9;
			var m=8;
			var arrlst2=secval2.split("@");
			var arrlst3;
			var chk_val="";
			for (i=0;i<arrlst2.length-1;i++){
				arrlst3=arrlst2[i].split(',');
				if(arrlst3[n] == appt_ref_no){
					chk_val=chk_val+"|"+arrlst3[m]+"|";
				}
			}
			var error1=getMessage("BULK_TRANSFER_SECONDARY_RESOURCES","OA");
			if(window.confirm(error1)){
				obj.checked=true;
			}else{
				callurl="../../eOA/jsp/SecResMain.jsp?from_page=bulk&from_page_one=bulk_prompt&Clinic_Code="+clinic_code+"&Practitioner_id="+practitioner_id+"&From_time="+fromTime+"&To_time="+toTime+"&VisitTypeCD="+visittypecode+"&Appt_date="+clinic_date+"&time_table_type="+time_table_type+"&patient_id="+pat_id+"&no_of_slots="+no_of_slots+"&res_class="+res_class+"&clinic_type="+clinic_type+"&sec_resorces="+escape(sec_resorces)+"&sec_resorces_req="+escape(sec_resorces_req)+"&sec_resorces1="+escape(sec_resorces1)+"&clinic_name_sec="+escape(clinic_name_sec)+" &care_locn_desc_sec="+escape(care_locn_desc)+" &pract_name_pri="+escape(pract_name_pri)+" &res_pri_class_desc="+escape(res_class_desc)+"&visit_type_des="+escape(u)+"&sec_req="+escape(sec_req)+"&ServerTime="+escape(ServerTime)+"&ServerDate="+escape(ServerDate)+"&row_cnt="+appt_ref_no+"&chk_val="+chk_val;
				retVal = await window.showModalDialog(callurl,arguments,features);
				if(retVal =="undefined" || retVal=="N" || retVal==null || retVal==""){
					clear_from_sess();
					selectvalue("false","close",current_val);
				}else{
					var retVal1=retVal.split("||");
					var new_sec_val="";
					parent.frames[2].document.getElementById('sec_sel').value=retVal1[0];
					new_sec_val=retVal1[2];
					newval=retVal1[1];
					if(new_sec_val =="N"){
						obj.checked=false;

					}else if(new_sec_val ==""){
						obj.checked=false;

					}else if(new_sec_val =="undefined"){
						obj.checked=false;
					}else{
						obj.checked=true;
					}
					if(obj.checked==true){
						parent.parent.frames[1].document.forms[0].sec_values.value=newval;
						srl_no_sel=retVal1[3];
						var secval2=parent.parent.frames[1].document.forms[0].sec_values.value;
						var secval3=parent.frames[2].document.forms[0].sec_sel.value;
						var n=9;
						var arrlst2=secval2.split("@");
						var arrlst_srl_no=srl_no_sel.split("@");
						var arrlst3;
						var arrlst4;
						var chk_val_main="";
						var chk_val_srl_no="";
						var final_val="";
						for (var m=0;m<arrlst_srl_no.length-1;m++ ){
							chk_val_srl_no=arrlst_srl_no[m];
							for (i=0;i<arrlst2.length-1;i++){
								arrlst3=arrlst2[i].split(',');
								if(arrlst3[8] == chk_val_srl_no){
									final_val=arrlst2[i]+"@"+final_val;
								}
							}
						}
						var xmlDoc = ""
						var xmlHttp = new XMLHttpRequest()
						xmlStr ="<root><SEARCH sel_sec = \""+final_val+"\"  steps='REMOVE_ADD_BULK_SEC_TO_SESSION'/></root>"
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
						xmlHttp.open("POST","BulkTransfervalidation.jsp",false)
						xmlHttp.send(xmlDoc)
						responseText=xmlHttp.responseText
						responseText = trimString(responseText)
						eval(responseText)
					}			
				}
			}		
		}else{
			obj.checked=false;
		}
	}
}

function clear_from_sess(){
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH steps='CLEAR_SEC_FROM_SESSION'/></root>"
			
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}

function chkschedule(obj1,obj2){
	
}

function Apply(){
	var cnt= parent.frames[0].document.forms[0].counter.value;
	var finalval="";
	for (var i=0;i<=cnt ;i++ ){
		if(eval("parent.frames[0].document.forms[0].chk"+i)){
			if(eval("parent.frames[0].document.forms[0].chk"+i).checked ==true){
				finalval+= eval("parent.frames[0].document.forms[0].o_appt_ref_no"+i).value+ "$";
			}
		}
	}
}

function moveforward(result)
{	


	var total_first_visit_slots_booked_from="";

	var total_other_visit_slots_booked_from="";
	var total_first_visit_slots_booked_to="";
	var total_other_visit_slots_booked_to="";
	var max_first_visits_from="";
	var max_other_visits_from="";
	var visit_limit_rule="";
	var cnt= parent.frames[0].document.forms[0].counter.value;
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
	var time_table_type="";
	var reason_code_revision="";

	from_speciality=parent.parent.frames[1].document.forms[0].speciality_from.value;
	to_speciality=parent.parent.frames[1].document.forms[0].speciality_to.value;
	locn_type=parent.parent.frames[1].document.forms[0].b_loc1.value;
	from_locn=parent.parent.frames[1].document.forms[0].from_locn.value;
	to_locn=parent.parent.frames[1].document.forms[0].to_locn.value;
	from_resc=parent.parent.frames[1].document.forms[0].practitioner.value;
	to_resc=parent.parent.frames[1].document.forms[0].practitioner2.value;
	from_date=parent.parent.frames[1].document.forms[0].b_from_date.value;
	from_date=parent.parent.frames[1].convertDate(from_date,"DMY",localeName,"en");
	to_date=parent.parent.frames[1].document.forms[0].b_to_date.value;
	to_date=parent.parent.frames[1].convertDate(to_date,"DMY",localeName,"en");
	from_res_class=parent.parent.frames[1].document.forms[0].resourceType1.value;
	to_res_class=parent.parent.frames[1].document.forms[0].resourceType3.value;
	oper_stn=parent.parent.frames[1].document.forms[0].oper_stn.value;
	time_table_type=parent.parent.frames[1].document.forms[0].time_table_type.value;
	reason_code_revision=parent.parent.frames[1].document.forms[0].reason_code_revision.value;

	//var from_date_greg=parent.parent.frames[1].convertDate(from_date,"DMY",localeName,"en");
	var from_date_greg=from_date;
	//var to_date_greg=parent.parent.frames[1].convertDate(to_date,"DMY",localeName,"en");	
	var to_date_greg=to_date;	
	from_locn=from_locn.split("$");
	from_locn=from_locn[1];
	to_locn=to_locn.split("$");
	to_locn=to_locn[1];
	var finalval="";

	for (var i=0;i<=cnt ;i++ )
	{
		if(eval("parent.frames[0].document.forms[0].chk"+i))
		{  
			if(eval("parent.frames[0].document.forms[0].chk"+i).checked ==true)
			{
				finalval+= eval("parent.frames[0].document.forms[0].o_appt_ref_no"+i).value+ "$";
			}
		}
	}	
	total_first_visit_slots_booked_from=parent.parent.frames[1].document.forms[0].total_first_visit_slots_booked_from1.value;
	total_other_visit_slots_booked_from=parent.parent.frames[1].document.forms[0].total_other_visit_slots_booked_from1.value;
	total_first_visit_slots_booked_to=parent.parent.frames[1].document.forms[0].total_first_visit_slots_booked_to1.value;
	total_other_visit_slots_booked_to=parent.parent.frames[1].document.forms[0].total_other_visit_slots_booked_to1.value;
	max_first_visits_from=parent.parent.frames[1].document.forms[0].max_first_visits_from.value;
	max_other_visits_from=parent.parent.frames[1].document.forms[0].max_other_visits_from.value;
	visit_limit_rule=parent.parent.frames[1].document.forms[0].visit_limit_rule.value;

	var Max_Forced_slots=parent.frames[0].document.forms[0].Max_Forced.value;
	var Total_Forced_booked_slots=parent.frames[0].document.forms[0].Total_Forced.value;	
	var from_booked_normal_slots=parent.frames[0].document.forms[0].from_booked_normal_slots.value;
	var from_booked_over_slots=parent.frames[0].document.forms[0].from_booked_over_slots.value;	
	var from_max_slots=parent.frames[0].document.forms[0].from_max_slots.value;	
	var to_max_slots=parent.frames[2].document.forms[0].to_max_slots.value;

	var isSlotStartMidEndAppl=parent.frames[2].document.forms[0].isSlotStartMidEndAppl.value;
	var ext_all_slots_yn=parent.frames[2].document.forms[0].ext_all_slots_yn.value;
	var max_non_ext_to_slots=parent.frames[2].document.forms[0].max_non_ext_to_slots.value;

	if(isSlotStartMidEndAppl == 'true')
	{
		if(ext_all_slots_yn == 'Y')
		{
			to_max_slots = 0;
		}else
		{
			to_max_slots = max_non_ext_to_slots;
		}
	}

	var to_total_booked=parent.frames[2].document.forms[0].to_total_booked.value;
	var to_booked_over_slots=parent.frames[2].document.forms[0].to_booked_over_slots.value;
	var to_max_over_booking=parent.frames[2].document.forms[0].to_max_over_booking.value;	
	var total_from_over_booked=parent.parent.frames[1].document.forms[0].total_from_over_booked.value;
	var no_of_normal_first_visits=parent.frames[0].document.forms[0].no_of_normal_first_visits.value;
	var no_of_normal_other_visits=parent.frames[0].document.forms[0].no_of_normal_other_visits.value;
	var no_of_overbooked_first_visits=parent.frames[0].document.forms[0].no_of_overbooked_first_visits.value;
	var no_of_overbooked_other_visits=parent.frames[0].document.forms[0].no_of_overbooked_other_visits.value;


	var flag=true;
	var fvFlag=true;
	var ovFlag=true;	

	if(result == undefined){		
	
		if(Total_Forced_booked_slots > 0 && from_date != to_date){				
			alert(getMessage("FORCED_APP_FUTURE_DATE", "OA"));
			flag=false;
			result='false';
		}

		if(visit_limit_rule == "M" || visit_limit_rule == "E"){
		//if(visit_limit_rule == "E"){
				if(parseInt(from_booked_normal_slots) == 0 && parseInt(from_booked_over_slots) > 0){					
					alert(getMessage("FREE_SLOTS_EXISTS_FROM", "OA"));
					flag=false;
					result='false';
				}
				
				/*if((no_of_normal_first_visits > 0 && max_first_visits_from != no_of_normal_first_visits && no_of_overbooked_first_visits > 0) || (no_of_normal_first_visits == 0 && no_of_overbooked_first_visits > 0)){					
					alert(getMessage("FIRST_VISITS_FREE_OVER_EXISTS", "OA"));
					flag=false;
					result='false';
				}*/

				
				no_of_normal_first_visits=parseInt(no_of_normal_first_visits)+parseInt(parent.frames[0].document.forms[0].from_blocked_slots.value);

				// sep 2015 addnl-4
				
				//commented jit
				/*if(((no_of_normal_first_visits > 0 && max_first_visits_from != no_of_normal_first_visits && no_of_overbooked_first_visits > 0) && (from_max_slots!=(parseInt(no_of_normal_first_visits)+parseInt(no_of_normal_other_visits)))) || (no_of_normal_first_visits == 0 && no_of_overbooked_first_visits > 0)){					
					alert(getMessage("FIRST_VISITS_FREE_OVER_EXISTS", "OA"));
					flag=false;
					result='false';
				}*/


				// Commented the below validations against SRR20056-SCF-13820.1
				/*if(flag != 'false')
					if(time_table_type !="3") 
					{
						if(((no_of_normal_other_visits > 0 && max_other_visits_from != no_of_normal_other_visits && no_of_overbooked_other_visits > 0) && (from_max_slots!=(parseInt(no_of_normal_first_visits)+parseInt(no_of_normal_other_visits)))) || (no_of_normal_other_visits == 0 && no_of_overbooked_other_visits > 0)){						
							alert(getMessage("OTHER_VISITS_FREE_OVER_EXISTS", "OA")); 
							flag=false;
							result='false';
						}
					}*/
		}
		
		if(visit_limit_rule == "N")
		{					
		
		
				
				/*  This lines commented by venkatesh s on 11/Aug/2011 for the incident SRR20056-SCF-7380.1 [IN028088]  */
				/*if((parseInt(from_max_slots) != parseInt(from_booked_normal_slots)) && (parseInt(from_booked_over_slots) > 0)){					
					alert(getMessage("FREE_SLOTS_EXISTS_FROM", "OA"));
					result='false';		
				}*/
				
				if((parseInt(from_booked_normal_slots)+parseInt(to_total_booked) < parseInt(to_max_slots)) && (from_booked_over_slots > to_booked_over_slots) && result !='false' && to_max_over_booking != 0){					
					err1=getMessage("FREE_SLOTS_EXISTS_TO", "OA");
					if(window.confirm(err1)){
						flag=true;					
					}else{ 
						flag=false;
						result='false';
					}
				}
			}
	}
	//Added for IN019217 by Sathish.S on Tuesday, March 09, 2010 Starts here


	var proceed=true;
	if(result==undefined){		
		proceed=true;		
	}
	else{
		result=result;		
		proceed=false;	
	}
	if(proceed==true){	

	var HTMLVal="<html><body 'onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/BulkTransferValidations.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+from_locn+"'><input type='hidden' name='clinic_date' id='clinic_date' value='"+from_date+"'><input type='hidden' name='practitioner_id' id='practitioner_id' value='"+from_resc+"'></form></body></html>";

	parent.parent.messageFrame.document.write(HTMLVal);
    parent.parent.messageFrame.document.form1.submit();
	}
	//Ends here	

    if(result=='true'){
	if(visit_limit_rule !="N" && time_table_type =="1"){
	
		if(parseInt(total_first_visit_slots_booked_from) > parseInt(total_first_visit_slots_booked_to)){
			fvFlag=false;
			var message=getMessage("FROM_FIRST_VISITS_GRT_TO_FIRST_FIRST_VISITS", "OA");
			alert(message);
		}else{
		
			fvFlag=true;
		}
		if(parseInt(total_other_visit_slots_booked_from)>parseInt(total_other_visit_slots_booked_to)){
			ovFlag=false;
			var message=getMessage("FROM_OTHER_VISITS_GRT_TO_FIRST_OTHER_VISITS", "OA");
			alert(message);
		}else{
			ovFlag=true;
		}
	}	
		
	if(fvFlag && ovFlag){
		//sep 2015  isue 2
		if(parent.frames[2].document.forms[0].last_slot_status.value=='BN'){
			if(parent.frames[0].document.forms[0].no_of_overbooked_first_visits.value >0 || parent.frames[0].document.forms[0].no_of_overbooked_other_visits.value>0){
				alert(getMessage("OVER_BOOKING_TOSCHEDULE_BLOCKED", "OA"));				
				flag=false;
			}
		}

		if(flag){
			from_booked_normal_slots=parseInt(from_booked_normal_slots)-parseInt(parent.frames[0].document.forms[0].from_blocked_slots.value);
			//sep 2015  isue 1
			

			if((from_booked_normal_slots > 0) && (to_total_booked == to_max_slots) && 
				(to_max_over_booking == 0 || to_max_over_booking == to_booked_over_slots || total_from_over_booked == 0)){			
				alert(getMessage("NO_EMPTY_SLOTS", "OA"));
				flag=false;
			}
			else if((parseInt(from_booked_normal_slots)+parseInt(to_total_booked) > to_max_slots) && (parseInt(to_total_booked) != parseInt(to_max_slots))){
				var error1=getMessage("SLOT_SLAB_LIMIT","OA");
				if(window.confirm(error1)){ 
					flag=true;

				}else{
					flag=false;
				}
			}
			else{ 
				flag=true;
			}
		}

		if(flag){ 
		
			if(parseInt(total_from_over_booked) > 0 && parseInt(to_booked_over_slots) == parseInt(to_max_over_booking)){
				if(parseInt(from_booked_normal_slots) > 0 && (parseInt(to_max_slots) > parseInt(to_total_booked))){
					var error1=getMessage("OVER_BOOKING_LIMIT","OA");
					if(window.confirm(error1)){ 
						flag=true;
					}else{
						flag=false;
					}
			}else{
				flag=true;
			}
		}else{
				flag=true;
			}
		}
		

		if(flag==true){ 
			var url='../../eOA/jsp/BulkTransferAppointmentResult2.jsp?from_speciality='+from_speciality+"&to_speciality="+to_speciality+"&from_page='false'&locn_type="+locn_type+"&from_locn="+from_locn+"&to_locn="+to_locn+"&from_resc="+from_resc+"&to_resc="+to_resc+"&from_date="+from_date_greg+"&to_date="+to_date_greg+"&to_res_class="+to_res_class+"&from_res_class="+from_res_class+"&oper_stn="+oper_stn+"&time_table_type="+time_table_type+"&reason_code_revision="+reason_code_revision;
			parent.frames[2].location.href=url;
		}
	}
	}
}

function selectvalue_main(obj,sec_resources,cnt){//Check Box Function at destination Page whether forced appointment is there and uncheck and disable  forced appt if normal appointment is uncheckd
	
	if(cnt>0){
		var resultCounter=document.bulktransferapptresult1.counter.value;
		var o_appt_ref_no=eval("parent.frames[2].document.forms[0].o_appt_ref_no"+cnt).value;
		var o_appt_ref_no1=eval("parent.frames[2].document.forms[0].o_appt_ref_no"+(cnt-1)).value;
		var o_appt_ref_noArr=o_appt_ref_no.split("|");
		var o_appt_ref_no1Arr=o_appt_ref_no1.split("|");
		if(o_appt_ref_no1Arr[4]=="FR"){
			if(eval("parent.frames[2].document.forms[0].selectall"+cnt).checked){
				eval("parent.frames[2].document.forms[0].selectall"+(cnt-1)).disabled=false;
				eval("parent.frames[2].document.forms[0].selectall"+(cnt-1)).checked=true; // added to keep forced checked whne teh main is checked sep 2015
			}else{
				eval("parent.frames[2].document.forms[0].selectall"+(cnt-1)).checked=false;
				eval("parent.frames[2].document.forms[0].selectall"+(cnt-1)).disabled=true;
			}
		}

		if(o_appt_ref_noArr[4]=="FR"){	// added to keep the forced as checked . forced cant b euncleked alone in bulk
				eval("parent.frames[2].document.forms[0].selectall"+(cnt)).disabled=false;
				eval("parent.frames[2].document.forms[0].selectall"+(cnt)).checked=true;
		}

				
	}
}

function selectvalue(obj,sec_resources,obj2){
	var cnt= parent.frames[0].document.forms[0].counter.value;
	if(sec_resources !="close"){
		for (var i=0;i<=cnt;i++ ){
			if(eval("parent.frames[2].document.forms[0].selectall"+i)){
				if(eval("parent.frames[2].document.forms[0].selectall"+i).disabled ==false){
					eval("parent.frames[2].document.forms[0].selectall"+i).checked=false;
				}
			}
		}
	}else{
		for (var i=0;i<=cnt;i++ ){
			if(eval("parent.frames[2].document.forms[0].selectall"+i)){
				if(eval("parent.frames[2].document.forms[0].selectall"+i).checked ==true){
					eval("parent.frames[2].document.forms[0].selectall"+i).checked=false;
				}else{
					eval("parent.frames[2].document.forms[0].selectall"+i).checked=false;
				}
			}
		}
	}
	location.reload();
}

function spl_sec(){
	var sec_sel=document.forms[0].sec_sel.value;
	var secc_sel=sec_sel;
	var tmp_str="";
	var flg="F";
	var s_arr=secc_sel.split("||");
	if(s_arr.length > 1 ){
		sec_sel='';
		for(var i=0;i<s_arr.length;i++){
			var tm0=s_arr[i];
			var s_arr1=tm0.split("#");
			var tm1=s_arr1[0];
			var tm2=s_arr1[1];
			if(tm2=='*'){
				tm2='';
			}
			sec_sel=sec_sel+tm2;
		}
	}
	if(sec_sel !=''){
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
			document.forms[0].sec_sel222.value=tmp_str;
		}
	}else{
		document.forms[0].sec_sel222.value='';
	}
}

async function passvalues(){
	var clinic_type=parent.frames[1].document.forms[0].b_loc1.value;
	var is_group_location = parent.frames[1].document.forms[0].is_group_location.value;
	var all_group_ids	= 	parent.frame2.result2.document.forms[0].all_group_ids.value;
	var episode_type="";
	var calling_module_id="";
	if(clinic_type =="D"){
		episode_type="I";
		calling_module_id="DC";
	}else{
		episode_type="O";
		calling_module_id="OP";
	}
	parent.frames[2].frames[2].document.forms[0].episode_type.value = episode_type;
	var finalval="";
	var appt_ref_num="";
	var appt_ref_num1="";
	var appt_ref_num3="";
	var appt_ref_num2=new Array();
	var m=0;
	var cnt= parent.frames[2].frames[2].document.forms[0].counter.value;
	for (var i=0;i<=cnt ;i++ ){
		if(eval("parent.frames[2].frames[2].document.forms[0].selectall"+i)){
			if(eval("parent.frames[2].frames[2].document.forms[0].selectall"+i).checked ==true){
				var temp = 'o_appt_ref_no'+i;
				if(m==0){					
					finalval= eval("parent.frames[2].frames[2].document.getElementById(temp)").value;
				}else{
					finalval= finalval+"$"+ eval("parent.frames[2].frames[2].document.getElementById(temp)").value;
				}
				/*finalval= finalval+ eval("parent.frames[2].frames[2].document.forms[0].o_appt_ref_no"+i).value;
				alert(eval("parent.frames[2].frames[2].document.forms[0].o_appt_ref_no"+i).value)
				if(eval("parent.frames[2].frames[2].document.forms[0].selectall"+eval(i+1)) && eval("parent.frames[2].frames[2].document.forms[0].selectall"+eval(i+1)).checked ==true){
					finalval= finalval+"$" ;
				}*/
				m++;
			}
		}
	}
	if(finalval ==""){
		alert(getMessage("NO_RECORD_INSERTION","OA"));
	}else{
		//Below condition added by Dharma Start
		if(is_group_location=='Y'){
			if(all_group_ids!=""){
				var TotRec			= all_group_ids.split("|@|");
				var UniqueArray		= new Array();
				var ProceedArray	= new Array();
				$.each(TotRec,function(ind,val){
					if(FnInArray(val,UniqueArray)==false){
						UniqueArray.push(val);
					}
				});
				var GrpLength	= 0;
				var ChkCount	= 0;
				var isError		= false;
				$.each(UniqueArray,function(index,GroupId){
					ChkCount 	= 0;
					GrpLength	= $('[id='+GroupId+']',parent.frames[2].frames[2].document).length;
					$('[id='+GroupId+']',parent.frames[2].frames[2].document).filter(':checked').each(function() {
						ChkCount++;
					});
					if(GrpLength==ChkCount){
						ProceedArray.push("True");
					}else if(ChkCount==0){
						ProceedArray.push("True");
					}else{
						ProceedArray.push("False");
					}
				});
				if(FnInArray("False",ProceedArray)==true){
					alert(getMessage("ALL_PATIENT_GROUP_APP_TRANS","OA"));
					return false;
				}
			}
		}
		//End
		var revers_final="";
		var rev_final_split="";
		rev_final_split=finalval.split("$");
			for(var k=(rev_final_split.length-1);k>=0;k--){
				if(k==(rev_final_split.length-1)){
					revers_final=rev_final_split[k];
				}else{
					revers_final=revers_final+"$"+rev_final_split[k];
				}
			}
		finalval=revers_final;	
		appt_ref_num=finalval.split("$");
		for (var j=0;j<m;j++ ){
			appt_ref_num1=appt_ref_num[j].split("|");
			appt_ref_num2=appt_ref_num1[0];
			appt_ref_num3=appt_ref_num3+ appt_ref_num2+"$";
		}
		parent.frames[2].frames[2].document.getElementById('appt_ref_num').value=appt_ref_num3;
		parent.frames[2].frames[2].document.getElementById('final_value').value=finalval;
		parent.frames[2].frames[2].document.getElementById('sec_resc_selec_final').value=parent.frames[1].document.forms[0].sec_values.value;
		parent.frames[2].frames[2].document.forms[0].submit();
		
		parent.frames[3].document.getElementById('confirmrevision').disabled=true;
	}
}

async function reportPrints1(sql_select,s_param,s_param_values,locn_type,clinic_code_to,appt_ref_num) {
	var dialogHeight    = '25' ;
	var dialogWidth = '65vw' ;
	var dialogTop = '50vh';
	var arguments =   '';
	//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the Query String.
	//In below line appt_ref_num added by Venkatesh.S against 39756 on 02-may-2013
	var getUrl        =   "../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=TRANSFER_CANCEL_APPT&step=1&sqlString=" 
	+ encodeURIComponent(sql_select) + "&reportParamNames=" + s_param + "&reportParamValues=" + s_param_values+
	"&dest_locn_type="+locn_type+"&dest_locn_code="+clinic_code_to+"&appt_no="+appt_ref_num;
	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;
	retVal           =   await window.showModalDialog(getUrl,arguments,features);
	return retVal;
}

async function reportPrints(s4,s10,s11,s9,s6,s) {
	var dialogHeight    = '25' ;
	var dialogWidth = '65vw' ;
	var dialogTop = '50vh';
	var arguments =   '';
	//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the Query String.
	/*In below line appt_no added by Venkatesh.S against 39756 on 02-may-2013*/
	var getUrl        =   "../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=TRANSFER_CANCEL_APPT&step=1&sqlString="
	+ encodeURIComponent(s4) + "&reportParamNames=" + s10 + "&reportParamValues=" + s11 + "&Patient_ID=" + s9 + 
	"&dest_locn_type=C&dest_locn_code=" + s6 + "&appt_no="+s;
	var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;
	retVal            =  await window.showModalDialog(getUrl,arguments,features);
	return retVal;
}

async function reasonlookup_revise(){
	var locale=document.forms[0].locale.value;
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
	
	argumentArray[5] = document.forms[0].reason_for_revision.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC ; 

	retVal = await CommonLookup(getLabel("Common.reason.label","Common"), argumentArray );
	var arr=new Array();
	if (retVal != null && retVal != '' && retVal != "null"){
		var retVal=unescape(retVal);
		arr=retVal.split(",");
		var desc=arr[1];
		var code=arr[0];
		document.forms[0].reason_for_revision.value=desc;
		document.forms[0].reason_code_revision.value=code;
	}else{
		document.forms[0].reason_for_revision.value="";
		document.forms[0].reason_code_revision.value="";
	}
}

function onSuccess(obj,obj1){

	if (obj =="false"){
		var error = "";
		if(obj1=="1"){
		
			error = getMessage("APPT_OVERLAP_NOT_PROCEED","OA" );
			alert(error);
		}else if(obj1=="2"){
		
			error = getMessage("BDCL_NOT_ENTITLED","MP" );
			alert(error);
		}else if(obj1=="3"){
		
			error = getMessage("SPL_NOT_ENTITLED","MP" );
			alert(error);
		}else if(obj1=="4"){
		
			error = getMessage("LOC_NOT_ENTITLED","MP" );
			alert(error);
		}else if(obj1=="5"){
		
			error = getMessage("PAT_CAT_EXP","MP" );
			alert(error);
		}
		parent.frames[2].document.location.href='../eCommon/html/blank.html'
		parent.frames[3].document.location.href='../eCommon/html/blank.html'
		parent.frames[4].location.href="../eCommon/jsp/error.jsp?err_num=";
		parent.frames[1].location.reload();
	}else{
		parent.frames[2].document.location.href='../eCommon/html/blank.html'
		parent.frames[3].document.location.href='../eCommon/html/blank.html'
		parent.frames[1].location.reload();
	}
}

function Disable_loctype(){
	document.forms[0].speciality_from.focus();
	document.forms[0].b_loc1.value="";
	document.forms[0].b_loc1.disabled=true;
	document.forms[0].b_loc2.value="";
	document.forms[0].b_loc2.disabled=true;
	document.forms[0].b_loc_val_from.disabled=true;
	document.forms[0].b_loc_search_from.disabled=true;
	document.forms[0].b_loc_val_to.disabled=true;
	document.forms[0].b_loc_search_to.disabled=true;
}

function enable_fromloc(){
	//var Spclty = document.forms[0].all.speciality_from.value;
	var Spclty = document.getElementById('speciality_from').value;
	if(Spclty == ""){
		document.forms[0].b_loc1.value="";
		document.forms[0].b_loc1.disabled=true;
		document.forms[0].b_loc2.value="";
		var n=document.forms[0].b_loc2.options.length;
		for(var i=0;i<n;i++){
			document.forms[0].b_loc2.remove("clinic");
		}
		var opt=document.createElement("OPTION");
		opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
		opt.value="";
		document.forms[0].b_loc2.add(opt);  
		document.getElementById('from_locn').value="";
		document.forms[0].b_loc_val_from.disabled=true;
		document.forms[0].b_loc_search_from.disabled=true;
	}else{
		document.getElementById('b_loc1').disabled=false;
	}
}

function clearvalue(){
	var Spclty1 = document.getElementById('speciality_to').value;
	if(Spclty1 == ""){
		if(document.forms[0].b_loc1.value !=""){
			document.forms[0].b_loc2.value=document.forms[0].b_loc1.value;
		}else{
			//document.forms[0].b_loc2.value="";
			var n=document.forms[0].b_loc2.options.length;
			for(var i=0;i<n;i++){
				document.forms[0].b_loc2.remove("clinic");
			}  
			var opt=document.createElement("OPTION");
			opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
			opt.value="";
			document.forms[0].b_loc2.add(opt);  
			document.getElementById('to_locn').value="";  
		}
	}else{
		document.forms[0].b_loc2.value=document.forms[0].b_loc1.value;
	}
}

function populatepract_to_Spty(Obj){
	/*var n=document.forms[0].to_locn.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].to_locn.remove("clinic");
		}*/
	//var locationtype = document.forms[0].all.b_loc1.value;
	var locationtype = document.getElementById('b_loc1').value;
	document.getElementById('practitioner_name2').value="";
	document.getElementById('practitioner2').value="";
	document.getElementById('practitioner_name2').disabled=true;
	document.getElementById('practitioner2').disabled=true;
	/*var opt=document.createElement("OPTION");
	opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt.value="";
	document.forms[0].to_locn.add(opt);
	var oper_stn_id=document.forms[0].oper_stn.value;
	var locationtype = document.forms[0].all.b_loc1.value;
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+locationtype+"\" speciality_code=\""+Obj.value+"\" steps='bulktransfer_locn_to' /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","BulkTransfervalidation.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)*/ 
	var b_loc2_val=document.forms[0].b_loc2;
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
	/*var n=document.forms[0].from_locn.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].from_locn.remove("clinic");
		}*/
	var locationtype = document.getElementById('b_loc1').value;
	document.getElementById('practitioner_name').value="";
	document.getElementById('practitioner').value="";
	document.getElementById('practitioner_name').disabled=true;
	document.getElementById('practitioner').disabled=true;
	document.forms[0].b_loc_val_from.value="";
	document.forms[0].from_locn.value="";
	/*var opt=document.createElement("OPTION");
	opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt.value="";
	document.forms[0].from_locn.add(opt);
	var oper_stn_id=document.forms[0].oper_stn.value;
	var locationtype = document.forms[0].all.b_loc1.value;
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+locationtype+"\" speciality_code=\""+Obj.value+"\" steps='bulktransfer_locn_from' /></root>";	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","BulkTransfervalidation.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)*/ 
	if(Obj.value=='C'){
		
		document.getElementById('resourceType').value='P';
	}else{
		document.getElementById('resourceType').value='';
	}
	document.getElementById('resourceType').value='';
}

async function open_loc_lookup_from(){
	var location_val=document.forms[0].b_loc_val_from.value;
	var locn_type=document.forms[0].b_loc1.value;
	var care_locn_ind=document.forms[0].b_loc1.value;
	var speciality_code=document.forms[0].speciality_from.value;
	//var dialogTop = "60" ;
	//var dialogHeight= "37" ;
	//var dialogWidth	= "60" ;
	var dialogTop = "10px" ;
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
		document.forms[0].b_loc_val_from.value=desc;
		document.forms[0].from_locn.value=open_to_all_pract_yn+"$"+clinic_code+"$"+resource_type;
		enablepract_from(document.forms[0].from_locn);
		FnCheckIsGroupLocation(clinic_code);
	}else{
		document.forms[0].b_loc_val_from.value="";
		document.forms[0].from_locn.value="";
		enablepract_from(document.forms[0].from_locn);
	}
}

function ena_loc_lookup_from(obj){
	if(obj.value==null || obj.value==''){
		document.forms[0].b_loc_val_from.value="";
		document.forms[0].from_locn.value="";
		enablepract_from(document.forms[0].from_locn);
	}else{
		open_loc_lookup_from()
	}
}

async function open_loc_lookup_to(){	
	var location_val=document.forms[0].b_loc_val_to.value;
	var locn_type=document.forms[0].b_loc2.value;
	var care_locn_ind=document.forms[0].b_loc2.value;
	var speciality_code=document.forms[0].speciality_to.value;
	//var dialogTop = "60" ;
	//var dialogHeight= "37" ;
	//var dialogWidth	= "60" ;
	var dialogTop = "10px" ;
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
		document.forms[0].b_loc_val_to.value=desc;
		document.forms[0].to_locn.value=open_to_all_pract_yn+"$"+clinic_code+"$"+resource_type;
		enablepract_to(document.forms[0].to_locn);
	}else{
		document.forms[0].b_loc_val_to.value="";
		document.forms[0].to_locn.value="";
		enablepract_to(document.forms[0].to_locn);
	}
}

function ena_loc_lookup_to(obj){
		if(obj.value==null || obj.value==''){
		document.forms[0].b_loc_val_to.value="";
		document.forms[0].to_locn.value="";
		enablepract_to(document.forms[0].to_locn);
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
	          //alert("incoming Text " + jqXHR.responseText);
	      }
	});
}

function FnInArray(needle, haystack) {
    var length = haystack.length;
    for(var i = 0; i < length; i++) {
        if(haystack[i] == needle)
        	return true;
    }
    return false;
}

