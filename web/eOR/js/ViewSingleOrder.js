/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
12/08/2011	  IN027165		 Chowminya		Incident No: IN027165 - <Future order linked orders reschedule - started date update issue> 										
---------------------------------------------------------------------------------------------------------------
*/
async function viewHeaderComments(orderId){

		var dialogHeight ='11' ;
		var dialogWidth = '29' ;
		var dialogTop	= '120';
		var dialogLeft = '125' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "orderId="+ orderId;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewHeaderComment.jsp?"+finalString,arguments,features);

}

async function viewHeaderComments1(orderId,max_seq){

		var dialogHeight ='11' ;
		var dialogWidth = '29' ;
		var dialogTop	= '120';
		var dialogLeft = '125' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "orderId="+ orderId+"&max_seq="+ max_seq;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewHeaderComment.jsp?"+finalString,arguments,features);

}

async function showChildOrders(orderId,patient_id,encounter_id,patient_class,sex,image_ref,ord_facility_id,iv_prep_yn,ord_cat,function_id){
		var dialogHeight ='37.5' ;
		var dialogWidth = '50' ;
		var dialogTop	= '120';
		var dialogLeft = '125' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "orderId="+ orderId+"&patient_id="+ patient_id+"&encounter_id="+ encounter_id+"&patient_class="+ patient_class+"&sex="+ sex+"&image_ref="+ image_ref+"&ord_facility_id="+ ord_facility_id+"&iv_prep_yn="+ iv_prep_yn+"&ord_cat="+ ord_cat+"&function_id="+ function_id;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewOrderFrameSet.jsp?"+finalString,arguments,features);
		
}

async function viewInstructionMode(reason_code){

		var dialogHeight ='11' ;
		var dialogWidth = '29' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "reason_code="+ reason_code;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewHeaderInstructionsMode.jsp?"+finalString,arguments,features);

}
async function viewImageDetails(order_id){
		var bean_id					= document.view_order.bean_id.value;
		var bean_name				= document.view_order.bean_name.value;
   		var retVal 			= ""
		var dialogHeight 	= "28" ;
		var dialogWidth  	= "50" ;
		var dialogTop    	= "100";
		var dialogLeft		= "100" 
 		var status 			= "no";
		var arguments		= "";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; dialogLeft:"+dialogLeft+"; scroll=auto; status:no";
 		retVal				= await window.showModalDialog("../../eOR/jsp/MedPntredit.jsp?called_from=VIEW&bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&order_id="+escape(order_id),arguments,features);
		//ndow.open("../../eOR/jsp/MedPntredit.jsp?called_from=VIEW&bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&order_id="+escape(order_id));
}

async function viewOrderFormatLineCmts(can_reason,line,order_line_num,orderId){
		
		var dialogHeight ='14' ;
		var dialogWidth = '29' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		if(can_reason=="")
			can_reason = eval("parent.ViewOrderDtl.document.view_order.Can_Reason"+line+".value");
		if(can_reason=="Comments")
			var narration = eval("parent.ViewOrderDtl.document.view_order.Cmts"+line+".value");
		else
			var narration = eval("parent.ViewOrderDtl.document.view_order.Cancel"+line+".value");
		var arguments = "";
		var finalString	= "can_reason="+encodeURIComponent(can_reason)+'&order_line_num='+order_line_num+'&orderId='+orderId;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewLineComment.jsp?"+finalString,arguments,features);

}





async function viewPrepsData(line){

		var dialogHeight ='11' ;
		var dialogWidth = '29' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		//var preps_data = eval("parent.ViewOrderDtl.document.view_order.Preps"+line+".value");
	
		//var finalString	= 'preps_data='+encodeURIComponent(preps_data,"UTF-8");
		var finalString	= 'line='+line;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewPrepsData.jsp?"+finalString,arguments,features);

}


async function viewDeptData(line){
		var dialogHeight ='11' ;
		var dialogWidth = '29' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		//var dept_data = eval("parent.ViewOrderDtl.document.view_order.Depts"+line+".value");
		//var finalString	= 'dept_data='+ encodeURIComponent(dept_data);
		var finalString	= 'line='+line;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewDeptData.jsp?"+finalString,arguments,features);

}


async function viewScheduleData(order_id, order_line_num, interval_type,ordering_facility_id,freq_code,order_category,formName,pr_duration,pr_duration_type,quantity,appl_sliding_scale_yn,start_time_day_param){

		var dialogHeight ='30' ;
		var dialogWidth = '40' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		var formobj = eval("document."+formName);
		var pr_duration = pr_duration; //formobj.pr_duration.value;
		var pr_duration_type =pr_duration_type; //formobj.pr_duration_type.value;
		//var start_time_day_param			= formobj.start_time_day_param.value;						
		var quantity			= quantity; //formobj.quantity.value;						

		//var finalString	= "order_id="+ order_id +"&order_line_num="+order_line_num+"&interval_type="+interval_type;		
		//var retVals = window.showModalDialog("../../eOR/jsp/ViewScheduleData.jsp?"+finalString,arguments,features);

		var bean_id = "Or_ViewOrder";
		var bean_name = "eOR.ViewOrder";
		var retVals = 	await window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&code="+order_id+"&row_value="+order_line_num+"&facility_id="+ordering_facility_id+"&freq_code="+freq_code+"&module_id=OR&mode=2&order_category="+order_category+"&pr_duration="+pr_duration+"&pr_duration_type="+pr_duration_type+"&start_time_day_param="+start_time_day_param+"&split_qty="+quantity+"&p_called_from=view&sliding_scale_yn="+appl_sliding_scale_yn,arguments,features);
}

async function viewApptData(line){
 		var dialogHeight ='27' ;
		var dialogWidth = '36' ;
		var dialogTop	= '190';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		var arguments = "";
		if(parent.ViewOrderDtl){
			var appt_ref_num 			= eval("parent.ViewOrderDtl.document.view_order.Appt"+line+".value");
			var appt_date 				= eval("parent.ViewOrderDtl.document.view_order.Appt_date"+line+".value");
			var appt_locn	 			= eval("parent.ViewOrderDtl.document.view_order.appt_locn"+line+".value");
			var appt_resched_yn			= eval("parent.ViewOrderDtl.document.view_order.appt_resched_yn"+line+".value");
			var appt_resched_reason		= eval("parent.ViewOrderDtl.document.view_order.appt_resched_reason"+line+".value");
			var no_of_reschedules		= eval("parent.ViewOrderDtl.document.view_order.no_of_reschedules"+line+".value");
			var order_category			= eval("parent.ViewOrderDtl.document.view_order.order_category"+line+".value");
			var cont_order_ind 			= eval("parent.ViewOrderDtl.document.view_order.cont_order_ind"+line+".value");
			var parent_order_id 		= eval("parent.ViewOrderDtl.document.view_order.parent_order_id"+line+".value");
			var parent_order_line_num 	= eval("parent.ViewOrderDtl.document.view_order.parent_order_line_num"+line+".value");
			var bean_id					= parent.ViewOrderDtl.document.view_order.bean_id.value;
			var bean_name				= parent.ViewOrderDtl.document.view_order.bean_name.value;
			var function_from			= parent.ViewOrderDtl.document.view_order.function_from.value;
			var patient_id			 	= parent.ViewOrderDtl.document.view_order.patient_id.value;
		} else {
			var appt_ref_num 			= eval("parent.ExistingOrderResult.document.existing_order_dtl.Appt"+line+".value");
			var appt_date 				= eval("parent.ExistingOrderResult.document.existing_order_dtl.Appt_date"+line+".value");
			var appt_locn	 			= eval("parent.ExistingOrderResult.document.existing_order_dtl.appt_locn"+line+".value");
			var appt_resched_yn			= eval("parent.ExistingOrderResult.document.existing_order_dtl.appt_resched_yn"+line+".value");
			var appt_resched_reason		= eval("parent.ExistingOrderResult.document.existing_order_dtl.appt_resched_reason"+line+".value");
			var no_of_reschedules		= eval("parent.ExistingOrderResult.document.existing_order_dtl.no_of_reschedules"+line+".value");
			var order_category			= eval("parent.ExistingOrderResult.document.existing_order_dtl.order_category"+line+".value");
			var cont_order_ind 			= eval("parent.ExistingOrderResult.document.existing_order_dtl.cont_order_ind"+line+".value");
			//var parent_order_id 		= eval("parent.ExistingOrderResult.document.existing_order_dtl.parent_order_id"+line+".value");//IN64543
			//var parent_order_line_num 	= eval("parent.ExistingOrderResult.document.existing_order_dtl.parent_order_line_num"+line+".value");//IN64543
			var parent_order_id 		= eval("parent.ExistingOrderResult.document.existing_order_dtl.ord_id"+line+".value");//IN64543
			var parent_order_line_num 	= eval("parent.ExistingOrderResult.document.existing_order_dtl.line_num"+line+".value");//IN64543
			var bean_id					= parent.ExistingOrderResult.document.existing_order_dtl.bean_id.value;
			var bean_name				= parent.ExistingOrderResult.document.existing_order_dtl.bean_name.value;
			var function_from			= parent.ExistingOrderResult.document.existing_order_dtl.function_from.value;
			var patient_id			 	= parent.ExistingOrderResult.document.existing_order_dtl.patient_id.value;
		}
 		var finalString					= "appt_ref_num="+ escape(appt_ref_num)+"&appt_date="+escape(appt_date)+"&cont_order_ind="+escape(cont_order_ind)+"&parent_order_id="+escape(parent_order_id)+"&parent_order_line_num="+escape(parent_order_line_num)+"&appt_locn="+escape(appt_locn)+"&appt_resched_yn="+escape(appt_resched_yn)+"&appt_resched_yn="+escape(appt_resched_yn)+"&appt_resched_reason="+escape(appt_resched_reason)+"&no_of_reschedules="+escape(no_of_reschedules)+"&order_category="+escape(order_category);
		finalString						+= "&bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&function_from="+escape(function_from)+"&patient_id="+patient_id
 		var retVals = await window.showModalDialog("../../eOR/jsp/ViewApptFrameset.jsp?"+finalString,arguments,features);

}

async function viewOAApptData(line){
 	var dialogHeight ='37.5' ;
	var dialogWidth = '50' ;
	var dialogTop	= '100';
	var dialogLeft = '30' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
	
	if(parent.ViewOrderDtl){
			var appt_ref_num 			= eval("parent.ViewOrderDtl.document.view_order.Appt"+line+".value");
			var appt_date 				= eval("parent.ViewOrderDtl.document.view_order.Appt_date"+line+".value");
			var cont_order_ind 			= eval("parent.ViewOrderDtl.document.view_order.cont_order_ind"+line+".value");
			var parent_order_id 		= eval("parent.ViewOrderDtl.document.view_order.parent_order_id"+line+".value");
			var parent_order_line_num 	= eval("parent.ViewOrderDtl.document.view_order.parent_order_line_num"+line+".value");
			var performing_facility_id 	= eval("parent.ViewOrderDtl.document.view_order.performing_facility_id"+line+".value");
			var bean_id					= parent.ViewOrderDtl.document.view_order.bean_id.value;
			var bean_name				= parent.ViewOrderDtl.document.view_order.bean_name.value;
			var function_from			= parent.ViewOrderDtl.document.view_order.function_from.value;
			var patient_id			 	= parent.ViewOrderDtl.document.view_order.patient_id.value;
	}else{
			var appt_ref_num 			= eval("parent.ExistingOrderResult.document.existing_order_dtl.Appt"+line+".value");
			var appt_date 				= eval("parent.ExistingOrderResult.document.existing_order_dtl.Appt_date"+line+".value");
			var cont_order_ind 			= eval("parent.ExistingOrderResult.document.existing_order_dtl.cont_order_ind"+line+".value");
			var parent_order_id 		= eval("parent.ExistingOrderResult.document.existing_order_dtl.parent_order_id"+line+".value");
			var parent_order_line_num 	= eval("parent.ExistingOrderResult.document.existing_order_dtl.parent_order_line_num"+line+".value");
			var performing_facility_id 	= eval("parent.ExistingOrderResult.document.existing_order_dtl.performing_facility_id"+line+".value");
			var bean_id					= parent.ExistingOrderResult.document.existing_order_dtl.bean_id.value;
			var bean_name				= parent.ExistingOrderResult.document.existing_order_dtl.bean_name.value;
			var function_from			= parent.ExistingOrderResult.document.existing_order_dtl.function_from.value;
			var patient_id			 	= parent.ExistingOrderResult.document.existing_order_dtl.patient_id.value;
	} 

	var date1=appt_date.split(" ");
	appt_date=date1[0];
	var finalString				= 'i_appt_ref_no='+ escape(appt_ref_num)+'&i_appt_date='+appt_date+'&cont_order_ind='+escape(cont_order_ind)+'&parent_order_id='+escape(parent_order_id)+'&parent_order_line_num='+escape(parent_order_line_num)+'&performing_facility_id='+performing_facility_id;
		finalString					+= '&bean_id='+escape(bean_id)+'&bean_name='+escape(bean_name)+'&function_from='+escape(function_from)+'&patient_id='+patient_id+'&flag=Visit_Reg'
		var retVals;
		if(parent.ViewOrderDtl){
		    retVals = await window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?"+finalString,arguments,features);
			reloadValues();//[IN033471]
		}else{
		   viewApptData(line);
		}
	//reloadValues(); // commented --[IN033471]//In existing order(it is used only for existing order)
 	//document.location.reload();

}

// Transfer Appointment from existing order and View order, call a file to query and then open the modal window transfer appointment
function viewReSchedule(appt_ref_num,line,start_date_time,order_id){
//alert("st========="+st)
//alert(eval("parent.ExistingSingleOrderResult.document.existing_order_dtl"))
	if(parent.ExistingSingleOrderResult.document.existing_order_dtl)
	{
		//var appt_ref_num 			= eval("parent.ExistingSingleOrderResult.document.existing_order_dtl.Appt"+line+".value");
		//var start_date_time			= eval("parent.ExistingSingleOrderResult.document.existing_order_dtl.start_date_time"+line+".value");
		//var order_id			= eval("parent.ExistingSingleOrderResult.document.existing_order_dtl.ord_id"+line+".value");
		var appt_ref_num 			= appt_ref_num;
		var start_date_time			= start_date_time;
		var order_id			= order_id;
		var localeName = parent.ExistingSingleOrderResult.document.existing_order_dtl.locale.value;
	}
	else if(parent.ExistingContinuousOrderResult.document.existing_order_dtl)
	{
		var appt_ref_num 			= appt_ref_num
		//var appt_ref_num 			= eval("parent.ExistingContinuousOrderResult.document.existing_order_dtl.Appt"+line+".value");
		//var start_date_time			= eval("parent.ExistingContinuousOrderResult.document.existing_order_dtl.start_date_time"+line+".value");
		//var order_id			= eval("parent.ExistingContinuousOrderResult.document.existing_order_dtl.ord_id"+line+".value");
		var start_date_time			= start_date_time;
		var order_id			= order_id;
		var localeName = parent.ExistingContinuousOrderResult.document.existing_order_dtl.locale.value;
		//var appt_ref_num 			= parent.ExistingContinuousOrderResult.document.existing_order_dtl.elements["Appt"+line].value;
	}
	 //--[IN027165]--
	alert("appt_ref_num============"+appt_ref_num)
	alert("start_date_time============"+start_date_time)
	alert("order_id============"+order_id)
	alert("localeName============"+localeName)
 	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr	+= "start_date_time=\"" + start_date_time + "\" " ;
	xmlStr	+= "appt_ref_num=\"" + appt_ref_num + "\" " ;
	xmlStr	+= "order_id=\"" + order_id + "\" " ; 
 	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eOR/jsp/ExistingOATransferDetails.jsp?validate=OA_APPT_DETAILS&localeName="+localeName, false ) ;
	//alert("283")
 	xmlHttp.send( xmlDoc ) ;
	//alert("285")
	responseText=xmlHttp.responseText ;
	eval(responseText)
}

// open the modal window with the OA Transfer
async function viewTransferDetails(appt_ref_num, start_date_time, order_id,alcn_criteria, appt_slab_from_time, appt_slab_to_time, clinic_code, practitioner_id, appt_date, appt_type_code, team_id, overbooked_yn, forced_appt_yn, care_locn_type_ind, resource_class, visit_type_ind, appt_day){
alert("293")
   	var dialogHeight ='35' ;
	var dialogWidth = '55' ;
	var dialogTop	= '100';
	var dialogLeft	= '30' ; 
	var title		= ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
 	// no need to pass the time
	if(start_date_time!="" && start_date_time.length>10)
		start_date_time  =  start_date_time.substring(0,10);
  	var finalString				= "alcn_criteria="+alcn_criteria+"&i_from_time="+appt_slab_from_time+"&i_to_time="+appt_slab_to_time+"&i_appt_ref_no="+appt_ref_num+"&i_clinic_code="+clinic_code+"&i_practitioner_id="+practitioner_id+"&new_appt_date="+start_date_time+"&i_appt_date="+appt_date+"&appt_day1="+appt_day+"&visit_type_ind="+visit_type_ind+"&i_team_id="+team_id+"&over_booked="+overbooked_yn+"&Forced="+forced_appt_yn+"&clinic_type="+care_locn_type_ind+"&res_type="+resource_class+"&order_id="+order_id 
 	// null values - Modified -[IN027165]
	finalString	  += "&tfr_appt_across_catg_yn=Y" // Since always transfer is required
  	retVal 	 	 = await window.showModalDialog("../../eOA/jsp/TransferAppointmentFrame.jsp?"+finalString,arguments,features)
	reloadValues(); //In existing order(it is used only for existing order)
	//document.location.reload();
}

// Code from OA Module ,
async function BookAppointment(line){
	
		
	var curr_sys_date			= "";
	var start_date_obj			= "";var curr_sys_date_obj			= "";
	if(parent.ViewOrderDtl){
 		var patient_id 			= parent.ViewOrderDtl.document.view_order.patient_id.value
		var location_code		= eval("parent.ViewOrderDtl.document.view_order.location_code"+line+".value");
		var start_date_time		= eval("parent.ViewOrderDtl.document.view_order.start_date_time"+line+".value");
		var order_catalog_code	= eval("parent.ViewOrderDtl.document.view_order.catalog_code"+line+".value");
		var order_id			= eval("parent.ViewOrderDtl.document.view_order.ord_id"+line+".value");
 	} else {
			curr_sys_date		= parent.ExistingOrderResult.document.existing_order_dtl.curr_sys_date.value
		var patient_id 			= parent.ExistingOrderResult.document.existing_order_dtl.patient_id.value
		var location_code		= eval("parent.ExistingOrderResult.document.existing_order_dtl.location_code"+line+".value");
		var start_date_time		= eval("parent.ExistingOrderResult.document.existing_order_dtl.start_date_time"+line+".value");
		var order_catalog_code	= eval("parent.ExistingOrderResult.document.existing_order_dtl.catalog_code"+line+".value");
		var order_id			= eval("parent.ExistingOrderResult.document.existing_order_dtl.ord_id"+line+".value");
  	}
		order_line_num			= 1; // Always  to be 1

		if(start_date_time!=null && start_date_time.length>10 &&  start_date_time.length==16) { // (with time truncate it ) 
			  start_date_time  	= start_date_time.substring(0,10); 
		}
 		if(curr_sys_date!=null && curr_sys_date!="" && start_date_time!=null && start_date_time!="") {
			//Check for the start_date_time (dd/mm/yyyy), if it is less than sysdate (dd/mm/yyyy), then pass the sysdate

		if(!parent.ViewOrderDtl){
			parent.ExistingOrderResult.document.existing_order_dtl.start_date_obj.value	= start_date_time;
			start_date_obj			= parent.ExistingOrderResult.document.existing_order_dtl.start_date_obj;
			curr_sys_date_obj		= parent.ExistingOrderResult.document.existing_order_dtl.curr_sys_date;
 			if(doDateCheckAlert(curr_sys_date_obj,start_date_obj)==false)
				start_date_time		= curr_sys_date;
		}
	}
	 	var referral_id = "";  
		var condition	=  "i_practitioner_id=&practitioner_id=" 
			 condition	+= "&patient_id="+patient_id+"&i_clinic_code=" 
			condition	+= "&clinic_code=&recall_date="+start_date_time;
			condition	+= "&location_code="+location_code+"&care_locn_ind="; 
			condition	+= "&specialty_code=&selectedPractId="//+ordering_practitioner;
			condition	+= "&selectedLocnCode=&referral_id="; 
			condition	+= "&order_id="+order_id+"&order_line_num="+order_line_num+"&order_catalog_code="+order_catalog_code; 
			condition	+= "&callingMode=OR&from_AE=N";
			//alert("condition"+condition);
  			var retVal 			= "";
  			var returnVal 			= "";
			var dialogHeight 	= "35" ;
			var dialogWidth  	= "50" ;
			var dialogTop    	= "100";
			var status 			= "no";
			var arguments		= "";
			var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
			retVal				= await window.showModalDialog("../../eOA/jsp/CAOAAppointment.jsp?"+condition,arguments,features);
			//alert("retVal"+retVal);
			if(retVal != null && retVal != "")
			{
				var Val				= retVal.split("^");
				var mode			= Val[0];
				var oa_query_string	= Val[1];
				oa_query_string		+= "&title="+getLabel("Common.bookappointment.label","Common")+"";
				if (mode=="1"){
					returnVal		= await window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+oa_query_string,arguments,features);
					if((returnVal != null && returnVal != "")&&returnVal!="OP"){
						var Val1	= returnVal.split("^");
						var mode1	= Val1[0];
						if (mode1=="1"){
							BookAppointment(line)
						}
					}
				} else if (mode=="2"){
					returnVal		= await window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+oa_query_string,arguments,features);
					if((returnVal != null && returnVal != "")&&returnVal!="OP"){
						var Val1	= returnVal.split("^");
						var mode1	= Val1[0];
						if (mode1=="1"){
							BookAppointment(line)
						}
					}
				} else if (mode=="3"){
					returnVal		= await window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+oa_query_string,arguments,features);
					if((returnVal != null && returnVal != "")&&returnVal!="OP"){
						var Val1	= returnVal.split("^");
						var mode1	= Val1[0];
						if (mode1=="1"){
							BookAppointment(line)
						}
					}
				}
				if(returnVal != null && returnVal != "")
				{
					if(returnVal=="OP")
					{ 
						BookAppointment(line)
						//OABookAppointment(patient_id, location_code, location_type, ordering_practitioner, specialty_code, order_id, order_line_num, order_catalog_code, start_date_time)
					}
					else if(returnVal != null && returnVal != "")
					{
						var result	= returnVal.split("*");
						if(result[0] != "OP")
						{
							var ApptNo		= result[0];
							if(parent.ExistingOrderResult){//Added on 15/03/2010 By sudhakar for IN019794
								parent.ExistingOrderResult.location.reload();
							}
 						}
					} // End of else 
				} // End of returnVal
					
			} // End of retVal
} // End of  OABookAppointment

//function viewPatientData(catalog_code,orderId, order_line_num,patient_id,sex){
async function viewPatientData(orderId,order_line_num,line){

		var dialogHeight ='12' ;
		var dialogWidth = '29' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		/*var instruction = "";
 		 if(parent.ViewOrderDtl)
 			instruction = eval("parent.ViewOrderDtl.document.view_order.Instruction"+line+".value"); 
		 else if(parent.CompleteOrderDtl)
			 instruction = eval("parent.CompleteOrderDtl.document.complete_order_dtl.Instruction"+line+".value"); 
		 else if(parent.CancelOrderDtl)s
		 	instruction = eval("parent.CancelOrderDtl.document.cancel_order_dtl.Instruction"+line+".value"); 
		 else 
	
			 instruction = eval("parent.frames[2].document.forms[0].Instruction"+line+".value"); 
	
		var finalString	= 'instruction='+ encodeURIComponent(instruction);*/
		var finalString	= "orderId="+ orderId+"&order_line_num="+order_line_num;
		var retVals = await window.showModalDialog("../../eOR/jsp/viewPatientData.jsp?"+finalString,arguments,features);

}
 
async function viewOrderFormat(orderId){
		var dialogHeight ='30' ;
		var dialogWidth = '50' ;
		var dialogTop	= '129';
		var dialogLeft = '120' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "orderId="+ orderId;
//		alert(finalString)
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewOrderFormatFrame.jsp?"+finalString,arguments,features);

}

async function viewOrderFormatLineDtl(orderId,lineId){

		var dialogHeight ='30' ;
		var dialogWidth = '50' ;
		var dialogTop	= '129';
		var dialogLeft = '120' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "orderId="+ orderId+"&lineId="+lineId;

		var retVals = await window.showModalDialog("../../eOR/jsp/ViewOrderFormatFrame.jsp?"+finalString,arguments,features);


}

async function viewBillingDetails(line) {
	var dialogHeight ='14' ;
	var dialogWidth = '30' ;
	var dialogTop	= '249';
	var dialogLeft = '167' ;
	var title = ''
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

	var arguments = "";
    var function_from			= parent.ViewOrderDtl.document.view_order.function_from.value;
    if (function_from == "View") {
		var parent_order_id 		= eval("parent.ViewOrderDtl.document.view_order.parent_order_id"+line+".value");
		var parent_order_line_num 	= eval("parent.ViewOrderDtl.document.view_order.parent_order_line_num"+line+".value");
		var cont_order_ind 			= eval("parent.ViewOrderDtl.document.view_order.cont_order_ind"+line+".value");
		var catalog_code			= eval("parent.ViewOrderDtl.document.view_order.catalog_code"+line+".value");
		var catalog_desc			= eval("parent.ViewOrderDtl.document.view_order.catalog_desc"+line+".value");
		var ordering_facility_id 	= parent.ViewOrderDtl.document.view_order.ordering_facility_id.value;
		var bean_id					= parent.ViewOrderDtl.document.view_order.bean_id.value;
		var bean_name				= parent.ViewOrderDtl.document.view_order.bean_name.value;

		var finalString				= 'ordering_facility_id='+ escape(ordering_facility_id)+'&parent_order_id='+escape(parent_order_id)+'&parent_order_line_num='+escape(parent_order_line_num);
		finalString					+= '&bean_id='+escape(bean_id)+'&bean_name='+escape(bean_name)+'&function_from='+escape(function_from)+'&validate=viewBill'+'&cont_order_ind='+cont_order_ind
		finalString					+='&catalog_code='+escape(catalog_code)+'&catalog_desc='+escape(catalog_desc)
		if (cont_order_ind == 'CR' || cont_order_ind == 'DR'){
			var retVals = await window.showModalDialog("../../eOR/jsp/ViewBillFrameset.jsp?"+finalString,arguments,features);
			//alert(retVals);
			//eval(retVals);
		} else {
	    	billDetails(finalString);
	    }
    }
}

function billDetails(finalString) {
	//var xmlDoc	= new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDoc	= "";
	//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
	var xmlHttp = new XMLHttpRequest();
	//alert(finalString);
	xmlHttp.open("POST", "ExistingOrderValidate1.jsp?"+finalString, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	//alert('responseText='+responseText);
	eval(responseText);
}

async function loadBillingDetails(day_type_code,day_type_desc,time_type_code,time_type_desc,base_qty,base_rate,addl_factor,base_charge_amt,gross_charge_amt,disc_amt,net_charge_amt,disc_perc,pat_gross_charge_amt,pat_disc_amt,pat_net_charge_amt,cust_gross_charge_amt,cust_disc_amt,cust_net_charge_amt,split_ind,curr_availed,credit_auth_ref, catalog_code, cat_desc,serv_panel_ind,serv_panel_code,service_panel_name,error_text)
{
	//alert('here,'+error_text);
	if(error_text!=null && error_text!="")
	{
		alert(error_text);
	}
	else
	{
		var query_string = "insind="+escape(split_ind)+"&baseqty="+base_qty+"&basechargeamt="+base_charge_amt+"&grosschargeamt="+gross_charge_amt+"&discountper="+disc_perc+"&discountamt="+disc_amt+"&daytypecode="+escape(day_type_code)+"&daytypedesc="+escape(day_type_desc)+"&timetypecode="+time_type_code+"&timetypedesc="+time_type_desc+"&addlfactor="+addl_factor+"&patgrosschargeamt="+pat_gross_charge_amt+"&patdiscamt="+pat_disc_amt+"&patnetamt="+pat_net_charge_amt+"&custgrosschargeamt="+cust_gross_charge_amt+"&custdiscamt="+cust_disc_amt+"&custnetamt="+cust_net_charge_amt+"&ordercatalogcode="+escape(catalog_code)+"&ordercatalogdesc="+escape(cat_desc)+"&netchargeamt="+net_charge_amt+"&blngrule="+escape(serv_panel_ind)+"&blngservcode="+escape(serv_panel_code)+"&blngservdesc="+escape(service_panel_name)
		var retVal;
		var dialogTop   = "260";
		var dialogHeight= "37.5" ;
		var dialogWidth = "50" ;
		var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
		var arguments	= "";
		//alert(query_string);
		retVal 			= await window.showModalDialog("../../eBL/jsp/BLBillDetailsMain.jsp?"+query_string,arguments,features);
	} // End of Else
}

function printit() 
{
	/*parent.frames[0].focus();
	alert("522"+parent.frames[0].name);
 	t=new ActiveXObject("WScript.Shell");
	t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header", "&bPage &p of &P");
    t.RegWrite("HKCU\\Software\Microsoft\\Internet Explorer\\PageSetup\\footer", "&b&d");
    t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_left", "0.75");
    t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_right", "0.75");
   // t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_top", "0.75");*/
	//parent.frames[0].print();
	//return false;
	//setTimeout("dummy()",2000000);
	//window.close();

	WSHShell=new ActiveXObject("WScript.Shell");
	myheader=WSHShell.RegRead("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header");
	myfooter=WSHShell.RegRead("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer");	
	WSHShell.RegWrite("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header", myheader);
    WSHShell.RegWrite("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer", myfooter);
 

	parent.frames[0].focus();
	if (document.all) 
	{
		var i = 0;
		
			while( i < document.applets.length ) 
			{
				var j = 0 ;
				while ( !document.applets[i].isActive() && j++ <=75000 ) 
				window.status = i;
				i++;
			}
		window.print();	
	}
	
}




async function printing(){
	//alert("In printing() script");
	var dialogHeight ='37.5' ;
	var dialogWidth = '60' ;
	var dialogTop	= '129';
	var dialogLeft = '11' ;
	var screen_width=screen.width;

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
	var arguments	= "";
    //var bean_id					= parent.ViewOrderDtl.document.view_order.bean_id.value;
	//var bean_name				= parent.ViewOrderDtl.document.view_order.bean_name.value;
	//var orderId					= parent.ViewOrderDtl.document.view_order.orderId.value;
	//var resp_id					= parent.ViewOrderDtl.document.view_order.resp_id.value;

	//var finalString				= "bean_id="+ escape(bean_id)+"&bean_id="+escape(bean_id)+"&resp_id="+escape(resp_id)+"&orderId="+orderId;

	// Have used document.all instead of form name because if the result is html and completed,
	// then in the result already it will have html format with all the <body><form> tags
	// then will get the script error. when accessing the hidden fields.
	var finalString				= parent.ViewOrderDtl.document.getElementById("querystring").value;
	finalString=finalString+"&screen_width="+screen_width;
		
	retVals = await window.showModalDialog("../../eOR/jsp/ViewPrintFrameset.jsp?"+finalString,arguments,features);
	
	
}

async function viewExternalDetails(ref_facility_id,ref_date_time,ref_sent_pract_id,ref_report_pract_id,ref_report_date_time,ref_recieved_date_time,ref_recieved_pract_id,order_id,bean_id,bean_name){

		var dialogHeight ='25' ;
		var dialogWidth = '35' ;
		var dialogTop	= '145';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "ref_facility_id="+ encodeURIComponent(ref_facility_id);
		finalString	+= "&ref_date_time="+ encodeURIComponent(ref_date_time);
		finalString	+= "&ref_sent_pract_id="+ encodeURIComponent(ref_sent_pract_id);
		//finalString	+= "&ref_sent_remarks="+ escape(document.getElementById("ref_sent_remarks").value);
		finalString	+= "&ref_report_pract_id="+ encodeURIComponent(ref_report_pract_id);
		finalString	+= "&ref_report_date_time="+ encodeURIComponent(ref_report_date_time);
		finalString	+= "&ref_recieved_date_time="+ encodeURIComponent(ref_recieved_date_time);
		finalString	+= "&ref_recieved_pract_id="+ encodeURIComponent(ref_recieved_pract_id);
		finalString	+= "&order_id="+ escape(order_id);
		finalString	+= "&bean_id="+ escape(bean_id);
		finalString	+= "&bean_name="+ escape(bean_name);
		//finalString	+= "&ref_recieved_remarks="+ escape(document.getElementById("ref_recieved_remarks").value);
		//alert('here'+finalString);
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewExternalDtls.jsp?"+finalString,arguments,features);

}

// Used for Viewing the History Results.
async function showHistory(accssion_num){
	// Have used document.all instead of form name because if the result is html and completed,
	// then in the result already it will have html format with all the <body><form> tags
	// then will get the script error. when accessing the hidden fields.
	bean_id		=  parent.ViewOrderDtl.document.getElementById("view_bean_id").value;
	bean_name	=  parent.ViewOrderDtl.document.getElementById("view_bean_name").value;
	patient_id	=  parent.ViewOrderDtl.document.getElementById("patient_id").value;
	orderId		=  parent.ViewOrderDtl.document.getElementById("orderId").value;
	var finalString = "bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&orderId="+orderId+"&accssion_num="+accssion_num;
	alert("finalString=>"+finalString);
	
	var dialogHeight ='36' ;
	var dialogWidth = '48' ; 
	var dialogTop	= '129';
	var dialogLeft = '110' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	var retVals = await window.showModalDialog("../../eOR/jsp/ViewOrderHistoryFrameset.jsp?"+finalString,arguments,features);
	document.location.reload();
} 

function showHistoryResults()
{
 	 query_string = document.frmMenu.query_string.value;
	 //alert("query_string=>"+query_string+",document=>"+document.location.href);
	 parent.ViewOrderHistoryResult.location.href =  "../../eOR/jsp/ViewOrderHistoryResults.jsp?"+query_string;
}


async function viewRemarks(order_id,action_seq_num,order_line_num){
		
		var bean_id		= document.viewHistory.bean_id.value;
		var bean_name	= document.viewHistory.bean_name.value;
		var dialogHeight ='250px' ;
		var dialogWidth = '300px' ;
		var dialogTop	= '189';
		var dialogLeft	= '167' ;
		var title		= ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		 
		var arguments = "";
		var finalString	= "bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&action_seq_num="+ action_seq_num+"&order_line_num="+order_line_num;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewOrderHistoryRemarks.jsp?"+finalString,arguments,features);

}


function callRDOTApptprinting(){
 	appt_ref_num	= parent.SpecimenCollectionDate.document.Appointment.appt_ref_num.value;
	order_category  = parent.SpecimenCollectionDate.document.Appointment.order_category.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr	+= "order_category=\"" + order_category + "\" " ;
	xmlStr	+= "appt_ref_num=\"" + appt_ref_num + "\" " ;
 	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eOR/jsp/RDOTApptPrinting.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText)
}

function showTotalBilling(total_amt,patient_payable,patient_paid,cont_order_ind)
{
	parent.ViewOrderBtn.document.getElementById("bill_dtl").style.display	  = "inline";
	parent.ViewOrderBtn.document.getElementById("actual_").innerText		  = total_amt;
	parent.ViewOrderBtn.document.getElementById("payable_").innerText		  = patient_payable;
	if((cont_order_ind=="DR")||(cont_order_ind=="CR"))
	{
		if(parent.ViewOrderBtn.document.getElementById("pat_paid_"))
			parent.ViewOrderBtn.document.getElementById("pat_paid_").style.visibility = "hidden";
	}
	else
	{
		if(parent.ViewOrderBtn.document.getElementById("pat_paid_"))
			parent.ViewOrderBtn.document.getElementById("pat_paid_").style.visibility = "visible";
		if(parent.ViewOrderBtn.document.getElementById("pat_payable_"))
			parent.ViewOrderBtn.document.getElementById("pat_payable_").innerText	  = patient_paid;
	}
}

async function callBilling(row_value,order_id,patient_id,performing_facility_id,encounter_id,patient_class,order_category,sex,colval1,colval,order_set_id)
{

	var dialogTop   = "100";
	var dialogLeft   = "30";
	var dialogHeight= "45" ;
	var dialogWidth = "60" ;
	var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +';dialogLeft:'+dialogLeft +'; scroll=yes; status=no';

	var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&sex="+ sex+"&patient_id="+ patient_id+"&order_category="+order_category;
		finalString += "&encounter_id=" + encounter_id;
		finalString += "&row_value=" + row_value;
		finalString += "&patient_class=" + patient_class;
		finalString += "&orderId=" + order_id;
		finalString += "&performing_facility_id=" + performing_facility_id;
		finalString += "&order_set_id=" + order_set_id;
		var arguments	= "";
		var retVal 			= await window.showModalDialog("../../eOR/jsp/OrderEntryBillingFrameset.jsp?"+finalString,arguments,features);

}

function enableAuditTrail()
{
	if(parent.ViewOrderBtn.document.getElementById("showhistory"))
		parent.ViewOrderBtn.document.getElementById("showhistory").disabled=false;
	if(parent.ViewOrderBtn.document.getElementById("close"))
		parent.ViewOrderBtn.document.getElementById("close").disabled=false;
}

