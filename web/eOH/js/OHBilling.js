function callBillingWindow(patient_id,chart_num,chart_line_num,trmt_code,task_code,key,key_line,practitioner_id,module_id,bill_str){
	var formObj = document.OHTreatmentForm; 
	var bl_total_charge = formObj.bl_total_payable_for_trmt.value;
	var bl_task_charge = formObj.bl_task_charge.value;
	var order_id = formObj.order_id.value;
	var order_line_num = formObj.order_line_num.value;
	var trmt_order_catalog_code = formObj.trmt_order_catalog_code.value;
	var task_order_catalog_code = formObj.task_order_catalog_code.value;
	var bl_data_exists_yn = formObj.bl_data_exists_yn.value;
	var total_existing_task_amount = formObj.total_existing_task_amount.value;
	//Commented by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	//var seq_no = formObj.seq_no.value;
	var task_seq_no = formObj.task_seq_no.value;
	var module_id = "OH";
	key=order_id+"_"+chart_num; // In case # is used, it will give issue. Use _
	//key=formObj.bl_key.value; // In case # is used, it will give issue. Use _
	key_line_no = order_line_num;
	var called_from="OH_KEY";
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&key="+key+"&key_line="+key_line_no+"&module_id="+module_id+"&bill_str="+bill_str+"&called_from="+called_from+"&order_id="+order_id+"&order_line_num="+order_line_num+"&trmt_order_catalog_code="+trmt_order_catalog_code+"&task_order_catalog_code="+task_order_catalog_code+"&bl_data_exists_yn="+bl_data_exists_yn;

	// get the bill_str from the bean....in this place... bhavani
//	var param = "key="+key+"&key_line_num="+key_line_no+"&module_id="+module_id+"&called_from="+called_from;
	var responseText=getPanelStr(params);
	var bill_str_arr = responseText.split("::");
//	var bl_total_charge = bill_str_arr[20]; // Get the total charge only once
	formObj.bl_total_charge.value = bl_total_charge;

	//Commented by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	//showBillingWindow(responseText,trmt_code,task_code,module_id,bill_str,params,bl_total_charge,bl_task_charge,"N",total_existing_task_amount,seq_no,chart_num,chart_line_num,practitioner_id,order_id,order_line_num);
	showBillingWindow(responseText,trmt_code,task_code,module_id,bill_str,params,bl_total_charge,bl_task_charge,"N",total_existing_task_amount,task_seq_no,chart_num,chart_line_num,practitioner_id,key,key_line_no,task_order_catalog_code);
	//
}

function getPanelStr(params){
	var xmlStr ="<root></root>";
	var temp_jsp="OHBLGetBillDetails.jsp?"+params;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	//validateTaskAndTotalCharge(); 
	responseText = localTrimString(responseText);
	return responseText;
}

async function showBillingWindow(str,trmt_code,task_code,module_id,bill_str,callwindow_params,bl_total_charge,bl_task_charge,called_second_time_yn,total_existing_task_amount,task_seq_no,chart_num,chart_line_num,practitioner_id,order_id,order_line_no,task_order_catalog_code){
		//var module_id = (rows.order==1)?"OH":"OR"
		var arr = str.split("::");
		//var order_id="";
	    //var order_line_no="";
		var key=arr[0];
		var key_line_no=arr[1];
		//var order_catalog_code=arr[2];
		var order_catalog_code=task_order_catalog_code;
		var patient_id = arr[3];
        var episode_type = arr[4];
		var episode_id=arr[5];
        var visit_id=arr[6];
        var encounter_id=arr[7];
		var service_date=arr[8];
		var pract_staff_ind=arr[9];
        var pract_staff_id=arr[10];
        var service_panel_ind=arr[11];
        var service_panel_code=arr[12];
        var bean_id="";
        var dialogTop = "100";
        var dialogHeight = "40vh" ;
        var dialogWidth = "75vw" ;
        var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
        var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
		var arguments = "" ;
        var column_sizes = "";
        var column_descriptions ="";
        var param = "title="+title+"&"+"column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&episode_type="+episode_type+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&service_panel_code="+service_panel_code+"&service_panel_ind="+service_panel_ind+"&service_date="+service_date+"&order_catalog_code="+order_catalog_code+"&module_id="+module_id+"&encounter_id="+encounter_id+"&key="+key+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no+"&bean_id="+bean_id;

		//keep a hidden variable (total_existing_task_amount)in DentalTreatment.jsp 
		//var total_existing_task_amount = formObj.total_existing_task_amount.value;
		if(total_existing_task_amount=="" && task_seq_no > 1){
			// NEW PROCEDURE TO BE INVOKED HERE. This will return the total_payable for all the previous tasks.
			// parseInt(patient_paid) has to be added to this amount and then to be compared with the bl_total_charge_int.
				var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&task_seq_no="+task_seq_no+"&trmt_code="+trmt_code+"&practitioner_id="+practitioner_id;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eOH/jsp/BillingCommonValidation.jsp?func_mode=getTotalBillAmount&"+params,false);
			xmlHttp.send(xmlDoc);
			var total_existing_task_amount = trimString(xmlHttp.responseText);
			total_existing_task_amount = localTrimString(total_existing_task_amount);
			document.forms[0].total_existing_task_amount.value = total_existing_task_amount;
		}
	
			var retVal = await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
		
		if((retVal!=null) || (retVal==null && called_second_time_yn=="Y")){
		//if( (retVal != null && retVal != "" && retVal!="undefined" && retVal!="null" && retVal!=undefined) || ((retVal==null || retVal == "" || retVal=="undefined" || retVal=="null" || retVal==undefined) && called_second_time_yn=="Y")){
			
			if(retVal==null && called_second_time_yn=="Y"){
				//Commented by Sharon Crasta on 9/26/2009 for IN014899
				//Entire amount should be taken including the decimal point.
				//if(parseInt(patient_paid)>bl_total_charge_int){
				if(parseFloat(patient_paid)>bl_total_charge_int){
					msg = getMessage("APP-OH00069","OH");
					var msg_arr =  msg.split("#");
				
					alert(msg_arr[0]+"["+patient_paid+"]"+msg_arr[1]+"["+bl_total_charge_int+"]"+trimString(msg_arr[2]));
				//Commented by Sharon Crasta on 9/26/2009 for IN014899
				//Entire amount should be taken including the decimal point.
				//}else if(parseInt(patient_paid)+parseInt(total_existing_task_amount)>bl_total_charge_int){
				}else if(parseFloat(patient_paid)+parseFloat(total_existing_task_amount)>bl_total_charge_int){
				//End
					msg = getMessage("APP-OH00071","OH");
					var msg_arr =  msg.split("#");
					alert(msg_arr[0]+"["+patient_paid+"]"+msg_arr[1]+"["+total_existing_task_amount+"]"+msg_arr[2]+"["+bl_total_charge_int+"]"+trimString(msg_arr[3]));
				}
						
			
				//Commented by Sharon Crasta on 9/26/2009 for IN014899
				//Added order_id,order_line_no,task_order_catalog_code since the Billing Window wasnt capturing the billing details the second time.
				//showBillingWindow(str,trmt_code,task_code,module_id,bill_str,callwindow_params,bl_total_charge,bl_task_charge,"Y",total_existing_task_amount,task_seq_no,chart_num,chart_line_num,practitioner_id);
				//if(retVal!=undefined)
				showBillingWindow(str,trmt_code,task_code,module_id,bill_str,callwindow_params,bl_total_charge,bl_task_charge,"Y",total_existing_task_amount,task_seq_no,chart_num,chart_line_num,practitioner_id,order_id,order_line_no,task_order_catalog_code);
				//End

			}else{
				var retArray  = retVal;
				//total_payable::patient_payable::patient_paid::charged_yn
		
				var patient_paid = retArray[1];
				
				if(patient_paid==null || patient_paid=="null")
					patient_paid="0";

				var TmpPractId = practitioner_id
				if(retArray[10] != null && retArray[10] != '')
					TmpPractId = retArray[10];

				//var modified_bl_str =  getPanelStr(callwindow_params);
				//var panel_arr = modified_bl_str.split("::");
				//bl_total_charge=trimString(bl_total_charge);
				var bl_total_charge_int = parseInt(bl_total_charge);
				if(total_existing_task_amount==""){
					total_existing_task_amount="0";
				}
				//Commented by Sharon Crasta on 9/26/2009 for IN014899
				//Entire amount should be taken including the decimal point.
				//if(parseInt(patient_paid)+parseInt(total_existing_task_amount)>bl_total_charge_int){
				if(parseFloat(patient_paid)+parseFloat(total_existing_task_amount)>bl_total_charge_int){
				//if(parseInt(patient_paid)>bl_total_charge_int){
					if(parseFloat(patient_paid)>bl_total_charge_int){
					//End
						msg = getMessage("APP-OH00069","OH");
						var msg_arr =  msg.split("#");
						alert(msg_arr[0]+"["+patient_paid+"]"+msg_arr[1]+"["+bl_total_charge_int+"]"+trimString(msg_arr[2]));
					//Commented by Sharon Crasta on 9/26/2009 for IN014899
					//Entire amount should be taken including the decimal point.
					//}else if(parseInt(patient_paid)+parseInt(total_existing_task_amount)>bl_total_charge_int){
					}else if(parseFloat(patient_paid)+parseFloat(total_existing_task_amount)>bl_total_charge_int){
					//
						msg = getMessage("APP-OH00071","OH");
						var msg_arr =  msg.split("#");
						alert(msg_arr[0]+"["+patient_paid+"]"+msg_arr[1]+"["+total_existing_task_amount+"]"+msg_arr[2]+"["+bl_total_charge_int+"]"+trimString(msg_arr[3]));
					}
				
					//Commented by Sharon Crasta on 9/26/2009 for IN014899
					//Added order_id,order_line_no,task_order_catalog_code since the Billing Window wasnt capturing the billing details the second time.
					//showBillingWindow(str,trmt_code,task_code,module_id,bill_str,callwindow_params,bl_total_charge,bl_task_charge,"Y",total_existing_task_amount,task_seq_no,chart_num,chart_line_num,practitioner_id);
					showBillingWindow(str,trmt_code,task_code,module_id,bill_str,callwindow_params,bl_total_charge,bl_task_charge,"Y",total_existing_task_amount,task_seq_no,chart_num,chart_line_num,practitioner_id,order_id,order_line_no,task_order_catalog_code);
					//End
				}
				
				bill_str = retArray[1]+"::"+retArray[2]+"::"+retArray[3]+"::"+"N";

				var formObj = document.OHTreatmentForm;
				formObj.override_inc_exl.value	= retArray[6];
				formObj.reason_override_inc_exl.value = retArray[7];
				
			}
// moved after the below assigning of bl values		}
			var modified_bl_str =  getPanelStr(callwindow_params);
			var formObj = document.OHTreatmentForm;

			var bill_str_arr			= modified_bl_str.split("::");
			var  key					= bill_str_arr[0]; 
			var  key_line_no			= bill_str_arr[1]; 
			var  task_code				= bill_str_arr[2]; 
			var  patient_id				= bill_str_arr[3]; 
			var  episode_type			= bill_str_arr[4]; 
			var  episode_id				= bill_str_arr[5]; 
			var  visit_id				= bill_str_arr[6]; 
			var  encounter_id			= bill_str_arr[7]; 
			var  service_date			= bill_str_arr[8]; 
			//var  P = bill_str_arr[9]; // This value will be always 'P'
			var  pract_staff_id			= bill_str_arr[10]; 
			var  serv_panel_ind			= bill_str_arr[11]; 
			var  serv_panel_code		= bill_str_arr[12]; 
			var  bl_panel_str			= bill_str_arr[13]; 
			var  total_payable			= bill_str_arr[14]; 
			var  patient_payable		= bill_str_arr[15]; 
			var  preapp_yn				= bill_str_arr[16]; 
			var  patient_paid_amt		= bill_str_arr[17]; 
			var  charged_yn				= bill_str_arr[18];
			var  quantity				= bill_str_arr[19]; 
			var  total_payable_for_trmt = bl_total_charge_int;//bill_str_arr[20]; 
			formObj.bl_key.value					= key;
			formObj.bl_key_line_no.value			= key_line_no;
			formObj.bl_task_code.value				= task_code;
			formObj.bl_patient_id.value				= patient_id;
			formObj.bl_episode_type.value			= episode_type;
			formObj.bl_episode_id.value				= episode_id;
			formObj.bl_visit_id.value				= visit_id;
			formObj.bl_encounter_id.value			= encounter_id;
			formObj.bl_service_date.value			= service_date;
			//formObj.bl_P.value = P;
			if(service_panel_ind=="L")
				formObj.bl_pract_staff_id.value			= pract_staff_id;
			else
				formObj.bl_pract_staff_id.value			= TmpPractId;
			
			formObj.bl_serv_panel_ind.value			= serv_panel_ind;
			formObj.bl_serv_panel_code.value		= serv_panel_code;
			formObj.bl_panel_str.value				= bl_panel_str;
			formObj.bl_total_payable.value			= total_payable;
			formObj.bl_patient_payable.value		= patient_payable;
			formObj.bl_preapp_yn.value				= preapp_yn;
			formObj.bl_patient_paid_amt.value		= patient_paid_amt;
			formObj.bl_charged_yn.value				= charged_yn;
			formObj.bl_quantity.value				= quantity;
			formObj.bl_total_payable_for_trmt.value = total_payable_for_trmt;

		}
		/*
		if(retVal!=null){
			var retArray  = retVal;
			var arr = bill_str.split("::");
			bill_str = retArray[1]+"::"+retArray[2]+"::"+retArray[3]+"::"+arr[3];
			if(db_mode!="I"){
				db_mode = (order_id==1 || order_id==null || order_id=="")?"U":"I";
			}
			if(service_panel_ind=="L"){
				var pnl_str =  getPanelStr(patient_id,index);
				panel_str =pnl_str.split("::")[13];
			}
		}
		*/
}

function recordCharges(){
	var formObj = document.OHTreatmentForm;
	var ext_perm_loc_param = formObj.ext_perm_loc_param.value;
	var status_for_ext_loc = formObj.treatment_status_param.value;
	var status_for_ext_loc_int = parseInt(status_for_ext_loc);
	var trmt_yn = formObj.treatment_flag.value;
	var trmt_done_yn = formObj.trmt_done_yn.value;
	if(ext_perm_loc_param == "Y" || (status_for_ext_loc_int >=25 && trmt_yn !="Y" && trmt_done_yn != "Y")){//Added by Sridevi Joshi for CRF-702(IN012606)
		var DentalChartFormObj = parent.parent.trmtDentalChartDetails.document.forms[0];
	}else{
		var DentalChartFormObj = parent.trmtDentalChartDetails.document.forms[0];
	}
	
	var order_id = formObj.order_id.value;
	var order_line_num = formObj.order_line_num.value;
	var encounter_id = formObj.encounter_id.value;
	var practitioner_id = formObj.ca_practitioner_id.value;
	var facility_id = formObj.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var patient_class = formObj.patient_class.value;
	var trmt_code = formObj.trmt_code.value;
	var task_code = formObj.task_code.value;
	var order_status_type = formObj.treatment_status.value;

	var bl_episode_id = formObj.bl_episode_id.value;
	var bl_encounter_id = formObj.bl_encounter_id.value ; 
	//var bl_encounter_id = formObj.encounter_id.value ;
	var bl_visit_id = formObj.bl_visit_id.value;
	var bl_episode_type = formObj.bl_episode_type.value ;
	var dc_bl_episode_type = formObj.dc_bl_episode_type.value ;
	var surgeon_code = formObj.bl_pract_staff_id.value;

	if(surgeon_code =='undefined' || surgeon_code == '' || surgeon_code == ' ')
		surgeon_code=	practitioner_id;

	var task_desc = formObj.task_desc.value ;
	var bl_key = formObj.bl_key.value;
	var bl_key_line_no = formObj.bl_key_line_no.value;
	var bl_panel_str = escape(formObj.bl_panel_str.value);
	var bl_service_date = formObj.bl_service_date.value;
	var billing_appl_yn	= formObj.billing_appl_yn.value;
	var task_order_catalog_code	= formObj.task_order_catalog_code.value;
	var bl_total_payable_for_trmt	= formObj.bl_total_payable_for_trmt.value;
	var seq_no	= formObj.seq_no.value;
	var bl_serv_panel_code	= formObj.bl_serv_panel_code.value;
	var bl_serv_panel_ind	= formObj.bl_serv_panel_ind.value;
	var task_status_for_billing	= formObj.treatment_status.value;
	var site_type	= formObj.oh_site.value;
	var thrng_nos_ref	= formObj.thrng_nos_ref.value;
	var charging_stage	= formObj.charging_stage.value;
	var override_inc_exl	= formObj.override_inc_exl.value;
	var reason_override_inc_exl	= formObj.reason_override_inc_exl.value;

	// History Building Parameters
	var header_tab = DentalChartFormObj.header_tab.value;
	var tooth_numbering_system = DentalChartFormObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = DentalChartFormObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN = DentalChartFormObj.mixed_dentition_YN.value;
	var upper_arch_desc = DentalChartFormObj.upper_arch_desc.value;
	var lower_arch_desc = DentalChartFormObj.lower_arch_desc.value;
	var Q1_id = DentalChartFormObj.Q1_id.value;
	var Q2_id = DentalChartFormObj.Q2_id.value;
	var Q3_id = DentalChartFormObj.Q3_id.value;
	var Q4_id = DentalChartFormObj.Q4_id.value;
	var Q1_desc = DentalChartFormObj.Q1_desc.value;
	var Q2_desc = DentalChartFormObj.Q2_desc.value;
	var Q3_desc = DentalChartFormObj.Q3_desc.value;
	var Q4_desc = DentalChartFormObj.Q4_desc.value;

	var other_chart_facility_id=formObj.other_chart_facility_id.value;
	
	//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	var task_seq_no	= formObj.task_seq_no.value;
	//
	//Added by Sharon Crasta on 10/14/2008
	//end_date_time and start_date_time									   
	var start_date_time = "";
	var end_date_time = "";
	var start_time = "";
	var end_time = "";
	if(formObj.strtDate != null && formObj.strtDate != "null" && formObj.endDate != null && formObj.endDate != "null"){
		start_date_time = formObj.strtDate.value;
		end_date_time = formObj.endDate.value;
	}

	if(formObj.strtTime != null && formObj.strtTime != "null" && formObj.endTime != null && formObj.endTime != "null"){
		start_time = formObj.strtTime.value;
		end_time = formObj.endTime.value;
	}

	var start_date = start_date_time + " " + start_time;
	var end_date = 	end_date_time + " " + end_time;

	// Fields added for Null Check of Start Date and End Date.
	if(ext_perm_loc_param == "Y" || (status_for_ext_loc_int >=25 && trmt_yn !="Y" && trmt_done_yn != "Y")){//Added by Sridevi Joshi for CRF-702(IN012606)
		var messageFrame = parent.parent.parent.parent.parent.messageFrame;
	}else{
		var messageFrame = parent.parent.parent.parent.messageFrame;
	}
	var start_date_title = getLabel("eOH.StartDate.Label","OH");
	var end_date_title = getLabel("eOH.EndDate.Label","OH");

	formObj.oh_status.value = formObj.treatment_status.value;
	var status = formObj.oh_status.value;
	var status_int_for_strt_end_date = parseInt(status);
   
	//

	var order_set_bill_yn ="Y";
	var order_catalog_bill_yn = formObj.order_catalog_bill_yn.value;

	var history_params = "patient_id="+patient_id+"&encounter_id="+encounter_id+"&header_tab="+header_tab+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&order_id="+order_id+"&order_line_num="+order_line_num;
	//var history_params = "&header_tab="+header_tab+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc;

	var complete_charges_yn = "N";
	if(formObj.complete_charges != null && formObj.complete_charges != "null"){
		if(formObj.complete_charges.checked == true){
			complete_charges_yn = "Y";
		}else{
			complete_charges_yn="N";
		}
	}

	if(complete_charges_yn=="N" && bl_panel_str==""){
		//alert(getMessage("APP-OH00070","OH"));
		//return;
	}

	var fields = "";
	var names = "";
	//Added by Sharon Crasta on 10/14/2008
	// Start Date and End Date are added for Null Check only once the task is Registered.
	 //Added ext_perm_loc_param condition for IN015620 by sridevi joshi on 23/20/09
	 if(status_int_for_strt_end_date >= 25 && ext_perm_loc_param != "Y"){ 
		fields = new Array (formObj.strtDate,formObj.endDate);
		names = new Array (start_date_title,end_date_title);			 
	 } 

	 if(checkFieldsofMst( fields, names, messageFrame))	{
		if(status_int_for_strt_end_date >= 25 && ext_perm_loc_param != "Y"){ 
			fields = new Array (formObj.strtTime,formObj.endTime);
			names = new Array (start_date_title,end_date_title);
		}	

		if(status_int_for_strt_end_date >= 25){ 
			if(checkFieldsofMst( fields, names, messageFrame)){	 
				// Validations to check for Start Date/Time and End Date/Time on click of Record Charges
				if(checkDateGreaterThanRegDate(formObj.regn_date_time1.value) && 
					checkStartDateNotGreaterThanSysDate() && 
					 checkEndDateNotGreaterThanSysDate() && 
						 checkDates()){
				}else{
					return false;
				}
			} else{
				return false;
			}
		}
	 }else{
		return false;
	 }

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&order_status_type="+order_status_type+"&order_id="+order_id+"&trmt_code="+trmt_code+"&task_code="+task_code+"&encounter_id="+encounter_id+"&order_line_num="+order_line_num+"&start_date_time="+start_date+"&end_date_time="+end_date;
	//Commented by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
	//var bl_params = "&bl_episode_id="+bl_episode_id+"&bl_encounter_id="+bl_encounter_id+"&bl_visit_id="+bl_visit_id+"&bl_episode_type="+bl_episode_type+"&patient_class="+patient_class+"&surgeon_code="+surgeon_code+"&task_desc="+task_desc+"&bl_key="+bl_key+"&bl_key_line_no="+bl_key_line_no+"&bl_panel_str="+bl_panel_str+"&bl_service_date="+bl_service_date+"&billing_appl_yn="+billing_appl_yn+"&task_order_catalog_code="+task_order_catalog_code+"&complete_charges_yn="+complete_charges_yn+"&bl_total_payable_for_trmt="+bl_total_payable_for_trmt+"&seq_no="+seq_no+"&bl_serv_panel_ind="+bl_serv_panel_ind+"&task_status_for_billing="+task_status_for_billing+"&thrng_nos_ref="+thrng_nos_ref+"&site_type="+site_type+"&charging_stage="+charging_stage;
	//var bl_params = "&bl_episode_id="+bl_episode_id+"&bl_encounter_id="+bl_encounter_id+"&bl_visit_id="+bl_visit_id+"&bl_episode_type="+bl_episode_type+"&patient_class="+patient_class+"&surgeon_code="+surgeon_code+"&task_desc="+task_desc+"&bl_key="+bl_key+"&bl_key_line_no="+bl_key_line_no+"&bl_panel_str="+bl_panel_str+"&bl_service_date="+bl_service_date+"&billing_appl_yn="+billing_appl_yn+"&task_order_catalog_code="+task_order_catalog_code+"&complete_charges_yn="+complete_charges_yn+"&bl_total_payable_for_trmt="+bl_total_payable_for_trmt+"&seq_no="+seq_no+"&bl_serv_panel_ind="+bl_serv_panel_ind+"&task_status_for_billing="+task_status_for_billing+"&thrng_nos_ref="+thrng_nos_ref+"&site_type="+site_type+"&charging_stage="+charging_stage+"&task_seq_no="+task_seq_no+"&reason_override_inc_exl="+reason_override_inc_exl+"&override_inc_exl="+override_inc_exl; 
	var bl_params = "&bl_episode_id="+bl_episode_id+"&bl_encounter_id="+bl_encounter_id+"&bl_visit_id="+bl_visit_id+"&bl_episode_type="+dc_bl_episode_type+"&patient_class="+patient_class+"&surgeon_code="+surgeon_code+"&task_desc="+task_desc+"&bl_key="+bl_key+"&bl_key_line_no="+bl_key_line_no+"&bl_panel_str="+bl_panel_str+"&bl_service_date="+bl_service_date+"&billing_appl_yn="+billing_appl_yn+"&task_order_catalog_code="+task_order_catalog_code+"&complete_charges_yn="+complete_charges_yn+"&bl_total_payable_for_trmt="+bl_total_payable_for_trmt+"&seq_no="+seq_no+"&bl_serv_panel_ind="+bl_serv_panel_ind+"&task_status_for_billing="+task_status_for_billing+"&thrng_nos_ref="+thrng_nos_ref+"&site_type="+site_type+"&charging_stage="+charging_stage+"&task_seq_no="+task_seq_no+"&reason_override_inc_exl="+reason_override_inc_exl+"&override_inc_exl="+override_inc_exl; 


	/*
	//Added by Sharon Crasta on 7/14/2009 for IN011250
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
   	xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getOrderSetBillDetails&trmt_code="+trmt_code,false);
	xmlHttp.send(xmlDoc);
	var msg = "";
	var retValue = trimString(xmlHttp.responseText);
	retValue = localTrimString(retValue);
	if(retValue == "N"){
		order_set_bill_yn = "N";
		if(order_set_bill_yn == "N" && order_catalog_bill_yn == "N"){
			alert("Order Set and Order Catalog Bill_YN flags should be set");
		}
		else if(order_set_bill_yn == "N"){
			alert("Order Set Bill_YN flag is not set");
		}else{
			alert("Order Catalog Bill_YN flag is not set");	
		}
		return false;
	}
	*/
	//

//	alert( "Billing params " + params);
//	alert( "Billing params " + bl_params);
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
   	//xmlHttp.open("POST","BillingCommonValidation.jsp?func_mode=recordCharges&"+params+bl_params+history_params,false);
	//alert("build_history_yn:=="+build_history_yn);
	xmlHttp.open("POST","BillingCommonValidation.jsp?func_mode=recordCharges&"+params+bl_params,false);
	xmlHttp.send(xmlDoc);
	var msg = "";
	var retValue = trimString(xmlHttp.responseText);
	retValue = localTrimString(retValue);
	if(retValue!=null && retValue!="" && retValue.length>0){
		var retValue_arr = retValue.split("::");
			if(retValue_arr[0]=="CHARGES_FAILED"){
			msg = trimString(getMessage(retValue_arr[1],"OH"));
			var msg_arr =  msg.split("#");
			if(retValue_arr[1]=="APP-OH00069"){
					alert(msg_arr[0]+"["+retValue_arr[2]+"]"+msg_arr[1]+"["+retValue_arr[3]+"]"+trimString(msg_arr[2]));
			}else if(retValue_arr[1]=="APP-OH00071"){
				alert(msg_arr[0]+"["+retValue_arr[2]+"]"+msg_arr[1]+"["+retValue_arr[4]+"]"+msg_arr[2]+"["+retValue_arr[3]+"]"+trimString(msg_arr[3]));
				//Amount [#] and previous tasks amount [#], exceeds the total Cost of Treatment [#]!
			}
			return false;
		}
		else if(retValue_arr[0]=="CALL_HISTORY"){
			//storeImageClob();
			var retVal = getImageForHistory();
			//retVal = escape(retVal);
			//retVal = encodeURIComponent(retVal);
			//history_params = history_params+"&applyTrmts="+retVal;
			var chart_line_num_int = parseInt(chart_line_num);

			if(site_type == "THRNG" || (site_type == "MAXFS" && thrng_nos_ref.indexOf(",") != -1)){//Condition for MAXFS is added by Sridevi Joshi on 4/30/2010 for IN021072..RESULT_TEXT was getting updated only for 1st tooth incase of THRNG
			//if(site_type == "THRNG"){//Condition for MAXFS is added by Sridevi Joshi on 4/30/2010 for IN021072..RESULT_TEXT was getting updated only for 1st tooth incase of THRNG
				thrng_nos_ref_arr = thrng_nos_ref.split(",");
				for(var k=0;k<thrng_nos_ref_arr.length;k++){
					history_params = "patient_id="+patient_id+"&encounter_id="+encounter_id+"&header_tab="+header_tab+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num_int+"&trmt_code="+trmt_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&other_chart_facility_id="+other_chart_facility_id+"&thrng_nos_ref="+thrng_nos_ref;

					storeImageClob(history_params);
					chart_line_num_int++;
				}
			}
			else{
				history_params = "patient_id="+patient_id+"&encounter_id="+encounter_id+"&header_tab="+header_tab+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num_int+"&trmt_code="+trmt_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&other_chart_facility_id="+other_chart_facility_id;

				storeImageClob(history_params);
			}
		}
	}

	if(ext_perm_loc_param == "Y" || (status_for_ext_loc_int >=25 && trmt_yn !="Y" && trmt_done_yn != "Y")){//Added by Sridevi Joshi for CRF-702(IN012606)
		var dentalChartFormObj = parent.parent.trmtDentalChartDetails;
	}
	else{
		var dentalChartFormObj = parent.trmtDentalChartDetails;
	}
	var site_type = formObj.oh_site.value;
	var trmt_category_type = formObj.oh_category.value;
	var thrng_nos_ref = formObj.thrng_nos_ref.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var order_id = formObj.order_id.value;
	var order_line_num = formObj.order_line_num.value;
	var super_key_num = formObj.super_key_num.value;
	var super_tooth_ref = formObj.super_tooth_ref.value;
	//var status = formObj.oh_status.value;

	// To get Treatment Status not the task status
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&order_id="+order_id+"&order_line_num="+order_line_num;
	
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=getTaskStatus&"+params,false);
	xmlHttp.send(xmlDoc);
	var status = trimString(xmlHttp.responseText);
	status = localTrimString(status);

	//var status = formObj.treatment_status.value;
	var status_int = parseInt(status);
	if(status_int >= 25){
		if(site_type == "THRNG" && thrng_nos_ref != ""){
			tooth_no = formObj.thrng_nos_ref.value;
			var thrng_nos_ref_arr = thrng_nos_ref.split(",");
			
			tooth_range_count_for_order = thrng_nos_ref_arr.length 
		}
		else if(site_type == "THRNG" && thrng_nos_ref == ""){
			tooth_range_count_for_order = formObj.oh_area.options.length 
			for (var m=0;m<formObj.oh_area.options.length-1; m++) {
				if (formObj.oh_area.options[m].selected == true) {
					if(thrng_nos_ref == ""){
						thrng_nos_ref = formObj.oh_area.options[m].value; 
					}
					else{
						thrng_nos_ref = thrng_nos_ref+","+formObj.oh_area.options[m].value; 
					}
				}
			}
			formObj.thrng_nos_ref.value = thrng_nos_ref;
			tooth_no = thrng_nos_ref;
		}
		else{
			tooth_no = formObj.oh_area.value;
		}

		//var exfolth_count = "";
		//var retained_tooth_no = "";
		var super_tooth_ref = super_key_num;

		imageReplace(trmt_category_type,tooth_no,dentalChartFormObj,site_type,status,document.forms[0],'','','','','',super_key_num);
		getImageFromDB(tooth_no,site_type,chart_num,'T',document.forms[0],dentalChartFormObj,'',super_tooth_ref);
	}
	/* Uncomment only if 'Record Charges' button is used for billing
	parent.frames[2].expandMenu('menu1',parent.frames[2].document.forms[0].T_arrow);
	var el_menu1 = parent.frames[2].document.getElementById("menu1");
	if ( el_menu1.style.display != "none" ) {
		el_menu1.style.display = 'none';
		parent.frames[2].document.forms[0].T_arrow.src = "../../eOH/images/arrow-down.gif";
	}
	else {
		el_menu1.style.display = '';
		parent.frames[2].document.forms[0].T_arrow.src = "../../eOH/images/arrow-up.gif";
	}

	parent.frames[2].expandMenu('menu5',parent.frames[2].document.forms[0].T_arrow);
	var el = parent.frames[2].document.getElementById("menu5");
	if ( el.style.display != "none" ) {
		el.style.display = 'none';
		parent.frames[2].document.forms[0].T_arrow.src = "../../eOH/images/arrow-down.gif";
	}
	else {
		el.style.display = '';
		parent.frames[2].document.forms[0].T_arrow.src = "../../eOH/images/arrow-up.gif";
	}

	//Refreshing the form values with the original params
	//var old_params = parent.frames[2].document.forms[0].params.value;

	//document.location.href = "../../eOH/jsp/DentalTreatment.jsp?"+old_params;
	//messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
	*/
	return true;
}

function storeImageClob(params){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","HistDentalTreatment.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	
}

function getImageForHistory(){
	var formObj = document.forms[0];
	var imgDisplay_arch_quad = "";
	var imgDisplay_tooth_thrng = "";
	var crown_concat = ""; // Crown
	var concat = ""; //For Tooth_Range, Tooth
	var concat_val = "";
	var code_desc_arr;
	var concat_cond_val = "";
	var concat_cond_type = "";
	var cond_type = "";
	var rootLineDisplayParams = new Array();
	var root_count = 0;
	var chart_num  = formObj.chart_num.value;
	var patient_id = formObj.patient_id.value;
	//var locale = formObj.locale.value;
	var baseline_chart_yn = "N";
	var status_int = 0;
	var j = 0;
	

	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var treatment_condition_tab_flag = "T";//formObj.header_tab.value;
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_numbering_system="+tooth_numbering_system+"&treatment_condition_tab_flag="+treatment_condition_tab_flag+"&baseline_chart_yn="+baseline_chart_yn;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getAllImagesForHistory&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText); 

	return retVal;
	
}

