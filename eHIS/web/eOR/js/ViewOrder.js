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
Date       		Edit History    Name        	Rev.Date	Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
?             	100            	?           								created
12/08/2011	  	IN027165		Chowminya									Incident No: IN027165 - <Future order linked orders 
																			reschedule - started date update issue> 										
05/10/2012	  	IN029174		DineshT										On Click of print button in the preview window, 
																			the patient charts are moving away from the focus
15/11/2012	  	IN030472		Ramesh G									Bru-HIMS-CRF-031[Patient instructions to be printed on demand]
09/04/2013    	IN039067      	Ramesh G    								RD result aligment  
03/07/2013    	IN039857		Chowminya G    								Print Button from result view page for LB order
17/07/2013    	IN041798		Chowminya G    								Print Button from result view page for LB order - 
																			Changes the function name
18/12/2013    	IN045729   		Chowminya	   								Appointments slip showing a blank page for radiology 
																			orders Multi-facility
14/03/2014	  	IN047658		Vijayakumar K	17/03/2014	Chowminya G		Clinician Access ? Webpage dialog Some webpage 
																			dialog displays button not proper.
21/04/2014	  	IN047658		Vijayakumar K	14/03/2014	Chowminya G		Reopen - Result Reporting > Result Entry ?Comments-webpage
																				dialog?, ?OK? button disappear from the screen.	
08/05/2015		IN048464		Karthi			09/05/2014	Ramesh			History added for clinical comments			
28/07/2014		IN049419		Karthi L		24/08/2014	Ramesh			An Audit Trail for Additional Information Amendment of Order	
16/09/2014		IN051127		Karthi L		16/09/2014	Ramesh			View Audit trail->All the text of entered reason is displayed in same line	
22/06/2015 		IN056017		Nijitha S									Alpha-OR-Existing Orders-System throws script error in Result window for order format item.
16/11/2015		IN057113		Karthi										ML-MMOH-CRF-0335 - IN057113
15/08/2016		IN059315		Raja S										When an appointment is given is RIS PACS for a radiology order placed from eHIS the order status in eHIS changes to Appointment Scheduled. But the actual appointment display is in order comments and in the Audit trail.
08/01/2018    		IN065844 		Sharanraj					Ramesh			ML-MMOH-CRF-1000
28/06/2018		IN065341		Prakash C		29/06/2018	Ramesh G		MMS-DM-CRF-0115
23/07/2018		IN64543			Dinesh T		23/07/2018	Ramesh G		ML-MMOH-CRF-0776
18/07/2018   	IN061961		sivabagyam M    18/07/2018	Ramesh G		GHL-CRF-0433
23/05/2019		IN068778		Selvin M		23/05/2019	Ramesh G		TBMC-CRF-0011
06/07/2020		IN072654		Nijitha S		06/07/2020	Ramesh G		MMS-KH-CRF-0029.4
24/02/2022	 	25671			Ramesh G									NMC-JD-CRF-0091.2 
02/11/2022      35142           Krishna Pranay  03/11/2022  Ramesh G        TH-KW-CRF-0020.6
---------------------------------------------------------------------------------------------------------------
*/

var isPrintPinValidationReq; //ML-MMOH-CRF-0335 - IN057113
async function viewHeaderComments(orderId){

		var dialogHeight ='40vh' ; // height increased form 11 to 13 for IN048464
		
		//IN047658 - reopen starts
		//var dialogWidth = '29' ;
		var dialogWidth = '49vw' ;
		//IN047658 - reopen ends
		var dialogTop	= '120';
		var dialogLeft = '125' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "orderId="+ orderId;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewHeaderComment.jsp?"+finalString,arguments,features);

}
async function viewHeaderComments1(orderId,max_seq){

		var dialogHeight ='50vh' ; // height increased form 11 to 13 for IN048464
		//IN047658 starts
		//var dialogWidth = '29' ;
		//IN047658 - reopen starts
		//var dialogWidth = '35' ;
		//IN047658 ends
		var dialogWidth = '60vw' ;
		//IN047658 - reopen ends
		var dialogTop	= '120';
		var dialogLeft = '125' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "orderId="+ orderId+"&max_seq="+ max_seq;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewHeaderComment.jsp?"+finalString,arguments,features);

}
async function showChildOrders(orderId,patient_id,encounter_id,patient_class,sex,image_ref,ord_facility_id,iv_prep_yn,ord_cat,function_id){
		var dialogHeight ='80vh' ;
		var dialogWidth = '70vw' ;
		var dialogTop	= '10px';
		var dialogLeft = '125' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "orderId="+ orderId+"&patient_id="+ patient_id+"&encounter_id="+ encounter_id+"&patient_class="+ patient_class+"&sex="+ sex+"&image_ref="+ image_ref+"&ord_facility_id="+ ord_facility_id+"&iv_prep_yn="+ iv_prep_yn+"&ord_cat="+ ord_cat+"&function_id="+ function_id;
		var retVals =await top.window.showModalDialog("../../eOR/jsp/ViewOrderFrameSet.jsp?"+finalString,arguments,features);
		
}

async function viewInstructionMode(reason_code){

		var dialogHeight ='40vh' ;
		var dialogWidth = '40vw' ;
		var dialogTop	= '10';
		var dialogLeft = '10' ;
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
		
	if(parent.ViewOrderDtl!=null)
		instrn_type = eval("parent.ViewOrderDtl.document.view_order.instrn_type"+line+".value");
	else
		instrn_type = eval("document.complete_order_dtl.instrn_type"+line+".value");
	
	var dialogHeight ='35vh' ;
	//IN047658 starts
	//var dialogWidth = '29' ;
	//IN047658 - reopen starts
	//var dialogWidth = '35' ;
	//IN047658 ends
	var dialogWidth = '55vw' ;
	//IN047658 - reopen ends
	var dialogTop	= '0';
	var dialogLeft = '167' ;
	var title = ''
	
	//IN64543, start
	if("E" == instrn_type)
	{
		dialogHeight ='30vh' ;			
		dialogWidth = '40vw' ;
	}
	//IN64543, ends
	
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

	if(can_reason=="")
		can_reason = eval("parent.ViewOrderDtl.document.view_order.Can_Reason"+line+".value");
	/*if(can_reason=="Comments")
	{
		if(parent.ViewOrderDtl!=null)
			var narration = eval("parent.ViewOrderDtl.document.view_order.Cmts"+line+".value");
		else
			var narration = eval("parent.complete_order_dtl.document.view_order.Cmts"+line+".value");
	}*/
	else
	{
		//var narration = eval("parent.ViewOrderDtl.document.view_order.Cancel"+line+".value");
		if(parent.ViewOrderDtl!=null)
			var narration = eval("parent.ViewOrderDtl.document.view_order.Cancel"+line+".value");
		/*else
			var narration = eval("parent.complete_order_dtl.document.view_order.Cancel"+line+".value");*/
	}
		var arguments = "";
	//var finalString	= "can_reason="+encodeURIComponent(can_reason)+'&order_line_num='+order_line_num+'&orderId='+orderId;//IN64543
	var finalString	= "can_reason="+encodeURIComponent(can_reason)+'&order_line_num='+order_line_num+'&orderId='+orderId+"&instrn_type="+instrn_type;//IN64543
	var retVals = await window.showModalDialog("../../eOR/jsp/ViewLineComment.jsp?"+finalString,arguments,features);
}

async function viewPrepsData(line){
	if(parent.ViewOrderDtl!=null)
		instrn_type = eval("parent.ViewOrderDtl.document.view_order.instrn_type"+line+".value");
	else
		instrn_type = eval("document.complete_order_dtl.instrn_type"+line+".value");

		var dialogHeight ='11' ;
		//IN047658 starts
		//var dialogWidth = '29' ;
		//IN047658 - reopen starts
		//var dialogWidth = '35' ;
		//IN047658 ends
		var dialogWidth = '40' ;
		//IN047658 - reopen ends
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		//IN64543, starts
		if("E" == instrn_type)
		{
			dialogHeight ='30' ;			
			dialogWidth = '40' ;
		}
		//IN64543, ends
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		//var preps_data = eval("parent.ViewOrderDtl.document.view_order.Preps"+line+".value");
	
		//var finalString	= 'preps_data='+encodeURIComponent(preps_data,"UTF-8");
	//var finalString	= 'line='+line;//IN64543
	var finalString	= 'line='+line+"&instrn_type="+instrn_type;//IN64543
	var retVals =await  window.showModalDialog("../../eOR/jsp/ViewPrepsData.jsp?"+finalString,arguments,features);

}


async function viewDeptData(line){
	if(parent.ViewOrderDtl!=null)
		instrn_type = eval("parent.ViewOrderDtl.document.view_order.instrn_type"+line+".value");
	else
		instrn_type = eval("document.complete_order_dtl.instrn_type"+line+".value");
		var dialogHeight ='11' ;
		//IN047658 starts
		//var dialogWidth = '29' ;
		//IN047658 - reopen starts
		//var dialogWidth = '35' ;
		//IN047658 ends
		var dialogWidth = '40' ;
		//IN047658 - reopen ends
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		
		//IN64543, starts
		if("E"==instrn_type)
		{
			dialogHeight ='30' ;		
			dialogWidth = '40' ;
		}
		//IN64543, ends
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		var arguments = "";
		//var dept_data = eval("parent.ViewOrderDtl.document.view_order.Depts"+line+".value");
		//var finalString	= 'dept_data='+ encodeURIComponent(dept_data);
	//var finalString	= 'line='+line;//IN64543
	var finalString	= 'line='+line+"&instrn_type="+instrn_type;//IN64543
	var retVals = await window.showModalDialog("../../eOR/jsp/ViewDeptData.jsp?"+finalString,arguments,features);
}

async function viewScheduleData(order_id, order_line_num, interval_type,ordering_facility_id,freq_code,order_category,formName,pr_duration,pr_duration_type,quantity,appl_sliding_scale_yn,start_time_day_param){

		var dialogHeight ='75vh' ;
		var dialogWidth = '56vw' ;
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
		var retVals = 	await top.window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&code="+order_id+"&row_value="+order_line_num+"&facility_id="+ordering_facility_id+"&freq_code="+freq_code+"&module_id=OR&mode=2&order_category="+order_category+"&pr_duration="+pr_duration+"&pr_duration_type="+pr_duration_type+"&start_time_day_param="+start_time_day_param+"&split_qty="+quantity+"&p_called_from=view&sliding_scale_yn="+appl_sliding_scale_yn,arguments,features);
}

async function viewApptData(line){
		var dialogHeight ='80vh' ;
		var dialogWidth = '80vw' ;
		var dialogTop	= '10';
		var dialogLeft = '10' ;
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
			var performing_facility_id  = eval("parent.ViewOrderDtl.document.view_order.performing_facility_id"+line+".value");//IN045729
			//var item_narration          = eval("parent.ViewOrderDtl.document.view_order.item_narration"+line+".value"); //IN059315//IN64543
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
			var performing_facility_id  = eval("parent.ExistingOrderResult.document.existing_order_dtl.performing_facility_id"+line+".value");//IN045729
			//var item_narration          = eval("parent.ExistingOrderResult.document.existing_order_dtl.item_narration"+line+".value"); //IN059315//IN64543
			var bean_id					= parent.ExistingOrderResult.document.existing_order_dtl.bean_id.value;
			var bean_name				= parent.ExistingOrderResult.document.existing_order_dtl.bean_name.value;
			var function_from			= parent.ExistingOrderResult.document.existing_order_dtl.function_from.value;
			var patient_id			 	= parent.ExistingOrderResult.document.existing_order_dtl.patient_id.value;


			
		}
 		var finalString					= "appt_ref_num="+ escape(appt_ref_num)+"&appt_date="+escape(appt_date)+"&cont_order_ind="+escape(cont_order_ind)+"&parent_order_id="+escape(parent_order_id)+"&parent_order_line_num="+escape(parent_order_line_num)+"&appt_locn="+escape(appt_locn)+"&appt_resched_yn="+escape(appt_resched_yn)+"&appt_resched_yn="+escape(appt_resched_yn)+"&appt_resched_reason="+escape(appt_resched_reason)+"&no_of_reschedules="+escape(no_of_reschedules)+"&order_category="+escape(order_category);
		//finalString						+= "&bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&function_from="+escape(function_from)+"&patient_id="+patient_id //IN045729 to add performing_facility_id //Commented for IN059315
		//finalString						+= "&bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&function_from="+escape(function_from)+"&patient_id="+patient_id+"&performing_facility_id="+performing_facility_id+"&item_narration="+item_narration  //Added for IN059315//IN64543
 		finalString						+= "&bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&function_from="+escape(function_from)+"&patient_id="+patient_id+"&performing_facility_id="+performing_facility_id;  //Added for IN059315//IN64543
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
		var retVals = await window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?"+finalString,arguments,features);
	reloadValues(); //In existing order(it is used only for existing order)
 	//document.location.reload();

}

// Transfer Appointment from existing order and View order, call a file to query and then open the modal window transfer appointment
function viewReSchedule(line){
	 var appt_ref_num 			= eval("parent.ExistingOrderResult.document.existing_order_dtl.Appt"+line+".value");
 	 var start_date_time			= eval("parent.ExistingOrderResult.document.existing_order_dtl.start_date_time"+line+".value");
	 var order_id			= eval("parent.ExistingOrderResult.document.existing_order_dtl.ord_id"+line+".value");
	 //--[IN027165]--
	var localeName=parent.ExistingOrderResult.document.existing_order_dtl.locale.value;
 	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr	+= "start_date_time=\"" + start_date_time + "\" " ;
	xmlStr	+= "appt_ref_num=\"" + appt_ref_num + "\" " ;
	xmlStr	+= "order_id=\"" + order_id + "\" " ; 
 	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eOR/jsp/ExistingOATransferDetails.jsp?validate=OA_APPT_DETAILS&localeName="+localeName, false ) ;
 	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText)
}

// open the modal window with the OA Transfer
async function viewTransferDetails(appt_ref_num, start_date_time, order_id,alcn_criteria, appt_slab_from_time, appt_slab_to_time, clinic_code, practitioner_id, appt_date, appt_type_code, team_id, overbooked_yn, forced_appt_yn, care_locn_type_ind, resource_class, visit_type_ind, appt_day){
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
  	// commented below line & included next line of code by akbar as per the mail request from sudhakara rao mail dt. 18/4/2012
	//retVal 	 	 = window.showModalDialog("../../eOA/jsp/TransferAppointmentFrame.jsp?"+finalString,arguments,features)
	retVal           = await window.showModalDialog("../../eOA/jsp/OATransferAppointmentWrapper.jsp?"+finalString,arguments,features)
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
			/* changes by akbar for  RUT CRF005.
				height & width increased
			var dialogHeight 	= "35" ;
			var dialogWidth  	= "50" ;
			*/
			var dialogHeight 	= "90vh" ;
			var dialogWidth  	= "80vw" ;			
			
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
					returnVal		=await window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+oa_query_string,arguments,features);
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
				//* changes by akbar for  RUT CRF005 - start
				else{
					returnVal = retVal;
					}
				// RUT CRF005 - end
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
	
	var instrn_type;

	if(parent.ViewOrderDtl!=null)
		instrn_type = eval("parent.ViewOrderDtl.document.view_order.instrn_type"+line+".value");
	else
		instrn_type = eval("document.complete_order_dtl.instrn_type"+line+".value");
		var dialogHeight ='12' ;
		//IN047658 starts
		//var dialogWidth = '29' ;
		//IN047658 - reopen starts
		//var dialogWidth = '35' ;
		//IN047658 ends
		var dialogWidth = '40' ;
		//IN047658 - reopen ends
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		//IN64543, start
		if("E"==instrn_type)
		{
			var dialogHeight ='30' ;	
			var dialogWidth = '40' ;
		}
		//IN64543, ends
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
	//var finalString	= "orderId="+ orderId+"&order_line_num="+order_line_num;//IN64543
	var finalString	= "orderId="+ orderId+"&order_line_num="+order_line_num+"&instrn_type="+instrn_type;//IN64543
		var retVals =await  window.showModalDialog("../../eOR/jsp/viewPatientData.jsp?"+finalString,arguments,features);

}
 
async function viewOrderFormat(orderId){
		var dialogHeight ='76vh' ;
		var dialogWidth = '70vw' ;
		var dialogTop	= '0px';
		var dialogLeft = '0px' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";	
		var finalString = "orderId=" + orderId;
		//IN056017 Starts
		//	IN049419 Start.
		/*if(parent.ViewOrderTop!=undefined){
			finalString = finalString+"&orderFormatAuditTrailYN="+parent.ViewOrderTop.document.view_order_top.orderFormatAuditTrailYN.value;
		}*/	
		//	IN049419 End.
		if(parent.ViewOrderTop!=undefined && parent.ViewOrderTop.document!=undefined && parent.ViewOrderTop.document.view_order_top!=undefined && parent.ViewOrderTop.document.view_order_top.orderFormatAuditTrailYN!=undefined){
			finalString = finalString+"&orderFormatAuditTrailYN="+parent.ViewOrderTop.document.view_order_top.orderFormatAuditTrailYN.value;
		}
		else if(parent.ViewOrderTop!=undefined &&parent.ViewOrderTop.orderFormatAuditTrailYN!=undefined )
		{
			finalString = finalString+"&orderFormatAuditTrailYN="+parent.ViewOrderTop.orderFormatAuditTrailYN.value;
		}
		//IN056017 Ends
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewOrderFormatFrame.jsp?"+finalString,arguments,features);

}

async function viewOrderFormatLineDtl(orderId,lineId){

		var dialogHeight ='59vh' ;
		var dialogWidth = '48vw' ;
		var dialogTop	= '0';
		var dialogLeft = '0px' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";	
		var finalString = "orderId=" + orderId+ "&lineId=" + lineId;
		//	IN049419 Start.
		if(parent.ViewOrderTop!=undefined){
			finalString = finalString+"&orderFormatAuditTrailYN="+parent.ViewOrderTop.document.view_order_top.orderFormatAuditTrailYN.value;
		}	
		//	IN049419 End.
		var retVals = await top.window.showModalDialog("../../eOR/jsp/ViewOrderFormatFrame.jsp?"+finalString,arguments,features);


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
			var retVals =await  window.showModalDialog("../../eOR/jsp/ViewBillFrameset.jsp?"+finalString,arguments,features);
			//alert(retVals);
			//eval(retVals);
		} else {
	    	billDetails(finalString);
	    }
    }
}

function billDetails(finalString) {
	//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
	var xmlDoc = "";
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
	
	//35142 Start.
	var printProceed=true;
	var pkiSiteSpecificYN=parent.framePrint.document.getElementById("pkiSiteSpecificYN").value;
	if(pkiSiteSpecificYN=="Y"){
		if(parent.framePrint.document.getElementById("quePkiToken").value==""){
			var confVal=confirm("Primary key of queue number is blank. Do you wish to proceed");
			if(!confVal){
				printProceed=false;
			}
		}
	}	
	
	if(printProceed){
	//35142 End.	
		//WSHShell=new ActiveXObject("WScript.Shell");
		//myheader=WSHShell.RegRead("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header");
		//myfooter=WSHShell.RegRead("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer");	
		//WSHShell.RegWrite("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header", myheader);
		//WSHShell.RegWrite("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer", myfooter);
	 

		parent.frames[0].focus();//IN029174  //IN035635
		//if (document.all) 
		//{
			var i = 0;
			
				while( i < document.applets.length ) 
				{
					var j = 0 ;
					while ( !document.applets[i].isActive() && j++ <=75000 ) 
					window.status = i;
					i++;
				}
			window.print();	
		//}
		//35142 Start
		onSuccess(pkiSiteSpecificYN);	
	}
	
	
}
function onSuccess(obj){
	
	if(obj=="Y"){		
		var facility_id=parent.framePrint.document.getElementById("ordFacilityId").value;		
		var queue_pkid=parent.framePrint.document.getElementById("quePkiId").value;
		var token_num=parent.framePrint.document.getElementById("quePkiNumber").value;
		var issued_date_time=parent.framePrint.document.getElementById("quePkiIsueDateTime").value;
		var called_date_time=parent.framePrint.document.getElementById("quePkiCallDateTime").value;
		var patient_id=parent.framePrint.document.getElementById("patientId").value;
		var encounter_id=parent.framePrint.document.getElementById("encounterId").value;
		var reference_id=parent.framePrint.document.getElementById("referenceId").value;
		var status_code=parent.framePrint.document.getElementById("quePkiStatus").value;
		var status_text=parent.framePrint.document.getElementById("quePkiStatusText").value;
		var user_id=parent.framePrint.document.getElementById("userId").value;
		insertIntoXhQmsTable ("RADRPT",
				facility_id,
				queue_pkid,
				token_num,
				issued_date_time,
				called_date_time,
				patient_id,
				encounter_id,
				reference_id,
				status_code,
				status_text,
				user_id);
		
		
	}	
}

//35142 End.
async function printing(){
	//alert("In printing() script");
	//ML-MMOH-CRF-0335 - IN057113 - Start
	var conf_pin_req_yn = document.view_order_btn.l_conf_pin_req_yn.value;
	if(conf_pin_req_yn == 'Y') {
		isPinValidationReq();
		if(isPrintPinValidationReq == 'Y') {
			retVal =  validatePintoPrint();
			if(retVal == 'X')
				return false;
		}
	}
	//ML-MMOH-CRF-0335 - IN057113 - End
	var dialogHeight ='100vh' ;
	var dialogWidth = '70vw' ;  //IN039067
	var dialogTop	= '0vh';
	var dialogLeft = '0vh' ;
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
	//35142 Start.
	finalString=finalString+"&pkiSiteSpecificYN="+parent.ViewOrderTop.document.getElementById("pkiSiteSpecificYN").value;
	if("Y"==(parent.ViewOrderTop.document.getElementById("pkiSiteSpecificYN").value)){
		finalString=finalString+"&quePkiStatus="+parent.ViewOrderTop.document.getElementById("quePkiStatus").value;
		finalString=finalString+"&quePkiStatusText="+parent.ViewOrderTop.document.getElementById("quePkiStatusText").value;
		finalString=finalString+"&quePkiId="+parent.ViewOrderTop.document.getElementById("quePkiId").value;
		finalString=finalString+"&quePkiToken="+parent.ViewOrderTop.document.getElementById("quePkiToken").value;
		finalString=finalString+"&quePkiNumber="+parent.ViewOrderTop.document.getElementById("quePkiNumber").value;
		finalString=finalString+"&quePkiIsueDateTime="+parent.ViewOrderTop.document.getElementById("quePkiIsueDateTime").value;
		finalString=finalString+"&quePkiCallDateTime="+parent.ViewOrderTop.document.getElementById("quePkiCallDateTime").value;
		finalString=finalString+"&ordFacilityId="+parent.ViewOrderTop.document.getElementById("ordFacilityId").value;
		finalString=finalString+"&patientId="+parent.ViewOrderTop.document.getElementById("patientId").value;
		finalString=finalString+"&encounterId="+parent.ViewOrderTop.document.getElementById("encounterId").value;
		finalString=finalString+"&referenceId="+parent.ViewOrderTop.document.getElementById("referenceId").value;
		finalString=finalString+"&userId="+parent.ViewOrderTop.document.getElementById("userId").value;
	}
	//35142 End.
		
	retVals = await top.window.showModalDialog("../../eOR/jsp/ViewPrintFrameset.jsp?"+finalString,arguments,features);
	
}

async function viewExternalDetails(ref_facility_id,ref_date_time,ref_sent_pract_id,ref_report_pract_id,ref_report_date_time,ref_recieved_date_time,ref_recieved_pract_id,order_id,bean_id,bean_name){

		var dialogHeight ='75vh' ;
		var dialogWidth = '65vw' ;
		var dialogTop	= '0px';
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
		var retVals = await top.window.showModalDialog("../../eOR/jsp/ViewExternalDtls.jsp?"+finalString,arguments,features);

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
	order_catalog_code =document.getElementById('order_catalog_code').value;//IN061961
	view_by = document.getElementById('view_by').value;//IN061961
	order_line_num =document.getElementById('order_line_num').value;//IN061961
	var ordCatElement = parent.ViewOrderBtn.document.getElementById("ord_cat_code");
	if (ordCatElement && ordCatElement.value) {
    order_category = ordCatElement.value;
	}
	else
	{
		order_category = parent.ViewOrderTop.document.getElementById("ord_cat_code").value;
	}
	//IN061961 
	var finalString="";//IN061961
	if(order_category=="LB"&&view_by=="L")//IN061961
		finalString = "bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&orderId="+orderId+"&accssion_num="+accssion_num+"&order_catalog_code="+order_catalog_code+"&order_line_num="+order_line_num+"&view_by="+view_by+"&order_category="+order_category;//IN061961
	else
		 finalString = "bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&orderId="+orderId+"&accssion_num="+accssion_num;
	var dialogHeight ='65vh' ;
	var dialogWidth = '61vw' ; 
	var dialogTop	= '1';
	var dialogLeft = '110' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	var retVals = await top.window.showModalDialog("../../eOR/jsp/ViewOrderHistoryFrameset.jsp?"+finalString,arguments,features);
	//document.location.reload();
} 

function showHistoryResults()
{
 	 query_string = document.frmMenu.query_string.value;

	 parent.ViewOrderHistoryResult.location.href =  "../../eOR/jsp/ViewOrderHistoryResults.jsp?"+query_string;
}


//function viewRemarks(order_id,action_seq_num,order_line_num){//IN065341
async function viewRemarks(order_id,action_seq_num,order_line_num,RepDb){	//IN065341
		var bean_id		= document.viewHistory.bean_id.value;
		var bean_name	= document.viewHistory.bean_name.value;
		var dialogHeight ='25vh' ;
		//IN047658 reopen starts
		//var dialogWidth = '28.2' ;
		var dialogWidth = '37vw' ;
		//IN047658 reopen starts
		var dialogTop	= '189';
		var dialogLeft	= '167' ;
		var title		= ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		 
		var arguments = "";
		//var finalString	= "bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&action_seq_num="+ action_seq_num+"&order_line_num="+order_line_num;//IN065341
		var finalString	= "bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&action_seq_num="+ action_seq_num+"&order_line_num="+order_line_num+"&RepDb="+RepDb;//IN065341--added RepDb
		var retVals = await top.window.showModalDialog("../../eOR/jsp/ViewOrderHistoryRemarks.jsp?"+finalString,arguments,features);

}


function callRDOTApptprinting(){
 	appt_ref_num	= parent.SpecimenCollectionDate.document.Appointment.appt_ref_num.value;
	order_category  = parent.SpecimenCollectionDate.document.Appointment.order_category.value;
	performing_facility_id  = parent.SpecimenCollectionDate.document.Appointment.performing_facility_id.value;//IN045729
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr	+= "order_category=\"" + order_category + "\" " ;
	xmlStr	+= "appt_ref_num=\"" + appt_ref_num + "\" " ;
	xmlStr	+= "performing_facility_id=\"" + performing_facility_id + "\" " ; //IN045729
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

	var dialogTop   = "10";
	var dialogLeft   = "10";
	var dialogHeight= "90vh" ;
	var dialogWidth = "90vw" ;
	var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +';dialogLeft:'+dialogLeft +'; scroll=yes; status=no';

	var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&sex="+ sex+"&patient_id="+ patient_id+"&order_category="+order_category;
		finalString += "&encounter_id=" + encounter_id;
		finalString += "&row_value=" + row_value;
		finalString += "&patient_class=" + patient_class;
		finalString += "&orderId=" + order_id;
		finalString += "&performing_facility_id=" + performing_facility_id;
		finalString += "&order_set_id=" + order_set_id;
		var arguments	= "";
		var retVal 			= await top.window.showModalDialog("../../eOR/jsp/OrderEntryBillingFrameset.jsp?"+finalString,arguments,features);

}

function enableAuditTrail()
{
	if(parent.ViewOrderBtn.document.getElementById("showhistory"))
		parent.ViewOrderBtn.document.getElementById("showhistory").disabled=false;
	if(parent.ViewOrderBtn.document.getElementById("close"))
		parent.ViewOrderBtn.document.getElementById("close").disabled=false;
}
//IN030472 Start.	
async function instructionsPrintPreview(){
	var dialogHeight ='95vh' ;
	var dialogWidth = '63vw' ;
	var dialogTop	= '70';
	var dialogLeft = '30' ;
	var title = "";
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
	var arguments = "";
	var finalString	= document.forms[0].queryString.value;
	await top.window.showModalDialog("../../eOR/jsp/PatientInstructionsPrintPreviewFrameSet.jsp?"+finalString,arguments,features);
}
//IN030472 End.	
//IN039857 - Start
function printLBValues() //Renamed from printValues to printLBValues - IN041798
{
	
	//ML-MMOH-CRF-0335 - IN057113 - Start
	var conf_pin_req_yn = document.view_order_btn.l_conf_pin_req_yn.value;
	if(conf_pin_req_yn == 'Y') {
		isPinValidationReq();
		if(isPrintPinValidationReq == 'Y') {
			retVal =  validatePintoPrint();

			if(retVal == 'X')
				return false;
		}	
	}	
	//ML-MMOH-CRF-0335 - IN057113 - End
	var no_of_checked = 0;
	var formObj = "";
	if(parent.ViewOrderDtl && parent.ViewOrderDtl.document.view_order)
	{
		formObj = parent.ViewOrderDtl.document.view_order;
	}	
	//25671 Start.
	var eSignatureYN= document.view_order_btn.eSignatureYN.value;
	var ordCat =document.view_order_btn.ord_cat.value;
	var includeESignature = false;
	if("Y"==eSignatureYN && "LB"==ordCat){
		includeESignature=confirm("Do you want to include E-stamp while printing LAB: Specimen Result Report");
		if(formObj.includeESignature!=undefined){
			if(includeESignature)
				formObj.includeESignature.value="Y";
			else
				formObj.includeESignature.value="N";
		}
	}
	//25671 End.
	
		
	eval(formApply(parent.ViewOrderDtl.document.view_order,"../../eOR/jsp/ExistingOrderPrintValidateLab.jsp"));	
	onSuccessLB();//Renamed from onSuccess to onSuccessLB -IN041798
	
}

function onSuccessLB() 
{
	alert(getMessage("RPT_SUBMIT_TO_PRINTER","OR"));
	
}
//IN039857 - End
// IN048464 - Start
function highLightLink(curr_seq, max_seq){
	for(var i=1;i<=max_seq;i++){
		if(i==curr_seq){
			document.getElementById('a'+i).innerHTML = "<U>"+((document.getElementById('a'+i).innerHTML).replace("<U>","")).replace("</U>","")+"</U>";
		}else{
			document.getElementById('a'+i).innerHTML = ((document.getElementById('a'+i).innerHTML).replace("<U>","")).replace("</U>","");
		}
	}
}
// IN048464 - End
// IN049419 Start.
async function orderFormatAuditTrails(order_id,lineId) {

	var dialogHeight = '75vh';
	var dialogWidth = '60vw';
	var dialogTop = '0px';
	var dialogRight = '65vh';
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:'
			+ dialogWidth + ';dialogTop:' + dialogTop + ';dialogRight:'
			+ dialogRight + ';dialogTitle:' + title + '; scroll=no; status=no';

	var arguments = "";
	
	var finalString = "orderId=" + order_id+"&lineId="+lineId;
	var retVal =await top.window.showModalDialog("../../eOR/jsp/OrderEntryOrderFormateAuditTrailFrameSet.jsp?"+ finalString, arguments, features);
	
}
function viewOrderFormatAuditTrail(order_id, action_seq_num,lineId) {
	var tbl=document.getElementById("auditTrailList");	
	if (tbl != null) {
		var totalRows = tbl.getElementsByTagName('tr');
		for (var i = 2; i < totalRows.length; i++) {
			
			 if(action_seq_num==totalRows[i].id){
				var totalCells=totalRows[i].cells;
				for(var j=0;j<totalCells.length;j++){
					totalCells[j].className="gridDataSelect";
				}				
			 }else{		
				var totalCells=totalRows[i].cells;
				for(var j=0;j<totalCells.length;j++){
					totalCells[j].className="gridData";
				}
			 }
		}
	}
	parent.orderFormatAuditTrailDtls.document.location.href = "../../eOR/jsp/ViewOrderFormat.jsp?orderId="
			+ order_id + "&action_seq_num=" + action_seq_num +"&lineId="+lineId+ "&auditTrail=Y";

}
async function viewOrderLineAuditData(order_id, order_line_num, field_mnemonic, line){
	var instrn_type = eval("parent.ViewOrderDtl.document.view_order.instrn_type"+line+".value");//IN64543
	var dialogHeight ='15vh' ;
	var dialogWidth = '40vw' ;
	var dialogTop	= '189';
	var dialogLeft = '167' ;
	var title = ''
	//IN64543, starts
	if("E" == instrn_type)
	{
		var dialogHeight ='40vh' ;
		var dialogWidth = '40vh' ;				
	}		
	//IN64543, ends
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
	var arguments = "";	
	//var finalString	= 'order_id='+order_id+'&order_line_num='+order_line_num+'&field_mnemonic='+field_mnemonic+'&line='+line;//IN64543
	var finalString	= 'order_id='+order_id+'&order_line_num='+order_line_num+'&field_mnemonic='+field_mnemonic+'&line='+line+"&instrn_type="+instrn_type;//IN64543
	var retVals = await window.showModalDialog("../../eOR/jsp/ViewOrderLineInstructions.jsp?"+finalString,arguments,features);

}
//IN051127 - Start
async function ShowComments(order_id, act_seq_num)
{
	var comments;
	var retVal;
	var dialogHeight ='21vh' ;
	var dialogWidth = '28vw' ;
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments = "";
	var finalString	= 'order_id='+order_id+'&act_seq_num='+act_seq_num;
	retVal 			= await window.showModalDialog('../../eOR/jsp/OrderAmendReasonDialog.jsp?'+finalString,arguments,features);
}
//IN051127 - End
// IN049419 End.
//ML-MMOH-CRF-0335 - IN057113
async function validatePintoPrint() {
	var retVal = 	new String();
	var dialogHeight= "9vh" ;
	var dialogWidth	= "25vw" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eCA/jsp/AuthorizePinAccess.jsp?"+"",arguments,features);
	if(retVal == undefined || retVal == 'undefined') retVal = "X";
	return retVal;
	//alert(' 941. ViewOrder.js ' + retVal);
}
function disallowEnterKey()
{
	var keyVal = parseInt(event.keyCode);
	if(keyVal == 13)
		return false;
}
function chkpasswd() {
	var appl_pwd = document.Authorize_form.appl_user_passwd.value;
	var screen_pwd = document.Authorize_form.screen_passwd.value;
	
	if (appl_pwd != screen_pwd){
		alert(getMessage("PWD_MISMATCH","CA"));
		top.window.returnValue = "X" ;
		top.window.close();
	 
		
	}else{
		top.window.returnValue = "T" ;
		top.window.close();
 
	}

}
function closeAuthorization(){
	top.window.returnValue = "X";
	top.window.close();
	 
	
}
function isPinValidationReq(){
	var patient_id =  parent.ViewOrderDtl.document.view_order.patient_id.value; 
	var order_id = parent.ViewOrderDtl.document.view_order.orderId.value;
	var localeName = '';
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrintConfidentPinValidate.jsp?p_patient_id=" + patient_id +"&p_order_id="+order_id+"&p_localeName="+localeName+"&p_validate=CONF_PIN_VALIDATE", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )
}
function isPinForPrintRequired(pinRequired) {
	isPrintPinValidationReq = pinRequired;
	
}
//ML-MMOH-CRF-0335 - IN057113
//IN065844 starts
async function viewAmend(orderId,orgid)
{
	var dialogHeight = '35vh';
	var dialogWidth = '60vw';
	var dialogTop = '129';
	var dialogLeft = '120';
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:'
			+ dialogWidth + ';dialogTop:' + dialogTop + ';dialogLeft:'
			+ dialogLeft + ';dialogTitle:' + title + '; scroll=yes; status=no';

	var arguments = "";
	orgid
	var finalString = "orderId=" + orderId+"&orgid="+orgid;
	var retVal = await window.showModalDialog("../../eOR/jsp/ViewAmendReason.jsp?"+ finalString, arguments, features);

}
//IN065844 ends
async function showDetails(order_id, order_line_num,action_seq_num,action)
{	
	var dialogHeight ='30vh' ;
	var dialogWidth = '40vw' ;
	var dialogTop	= '189';
	var dialogLeft = '167' ;
	var title = ''	
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

	var arguments = "";
	var finalString	= 'order_id='+order_id+'&order_line_num='+order_line_num+'&action_seq_num='+action_seq_num+'&action='+action;
	var retVals = await window.showModalDialog("../../eOR/jsp/ViewData.jsp?"+finalString,arguments,features);
}

//IN068778 starts
async function dispImageVideos(orderId,order_line_num){
	var patient_id =  ""; 
	var called_from = "View";
	var encounterId = "";						
	var accession_num="";
	var note_type="";
	window_id = await window.showModalDialog("../../eOR/jsp/ImageVideosFileUploadMain.jsp?accession_num="+accession_num+"&note_type="+note_type+"&call_from=window&patient_id="+patient_id+"&encounter_id="+encounterId+"&p_order_id="+orderId+"&p_order_line_num="+order_line_num+"&called_from="+called_from,'Document1',"height=550,width=650,top=80,left=130,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");
}
//IN068778 ends
async function viewInteractionDtls(catalog_code,patient_id,encounter_id){//IN072654 Starts
	
	var dialogHeight   = "37.5vh" ;
	var dialogWidth    = "65vw" ;
	var dialogTop      = "100";
	var dialogLeft     = "100";


	var features       = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments;

	
	
	//var retVal = window.showModalDialog("../../eOR/jsp/OrderEntryDrugInteractionLine.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&druginter_called_from="+druginter_called_from,arguments,features);
 	
 	var retVal=await window.showModalDialog("../../eOR/jsp/OROrderDrugInteractionDetails.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&catalog_code="+catalog_code,arguments,features);
}//IN072654 Ends

//35142 Start.
function getQUEPKICode(obj){
	
	if(obj.value!=null && obj.value!=""){
		//var responseToken = "S$!^SUCCESS$!^1$!^105$!^09/11/2022 10:05:00$!^ 9/11/2022 10:05:00"; 
		var responseToken = getTokenDetails("RADRPT", document.getElementById("ordFacilityId").value, document.getElementById("quePkiId").value, document.getElementById("patientId").value,document.getElementById("encounterId").value,document.getElementById("userId").value)
		document.getElementById("quePkiToken").value=responseToken;
		var queArr=responseToken.split("$!^");
		document.getElementById("quePkiStatus").value=queArr[0];
		document.getElementById("quePkiStatusText").value=queArr[1];
		document.getElementById("quePkiNumber").value=queArr[3];
		document.getElementById("quePkiIsueDateTime").value=queArr[4];
		document.getElementById("quePkiCallDateTime").value=queArr[5];	
		if(queArr[0]=="S"){
			document.getElementById("quePkiIdMessage").innerHTML="<B style='color:green;'> ( Info : Token dispensed details received successfully )</B>";
		}else if(queArr[0]=="F"){
			document.getElementById("quePkiIdMessage").innerHTML="<B style='color:red;'> ( Info : Invalid primary key. Token dispensed details could not be received )</B>";
		}
	}else{
		document.getElementById("quePkiStatus").value="";
		document.getElementById("quePkiStatusText").value="";
		document.getElementById("quePkiToken").value="";
		document.getElementById("quePkiNumber").value="";
		document.getElementById("quePkiIsueDateTime").value="";
		document.getElementById("quePkiCallDateTime").value="";
		document.getElementById("quePkiIdMessage").innerHTML="<B style='color:red;'> ( Info : Token dispensed details could not be received )</B>";
		alert ("Token dispensed details cannot be captured as primary key of queue no is blank.");
	}
}
function closeChildWin(){
var diagElement = parent.parent.document.getElementsByTagName("dialog");
								var i = 0; var j = 0;
	    						for (i = 0; i < diagElement.length; i++) {
	    							for (j = 0; j < diagElement[i].children.length; j++) {
	    								var element = diagElement[i].children[j];
	    								let dialogSrc = element.src;
	    								if (typeof dialogSrc !== "undefined")
	    								{ 
											if (dialogSrc.includes("ViewOrderFrameSet.jsp") || dialogSrc.includes("ScheduleFrequency.jsp")
												|| dialogSrc.includes("OrderEntryBillingFrameset.jsp")) 
											{
		        								var dialogTag = diagElement[i];    
												dialogTag.close(); 
											}
	    								}    		
	    							} 
								}
}
//35142 end.

