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
Date       		Edit History      Name        	Rev.Date	Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
?             	100            	?           		?			?			created

14/03/2014	  	IN047658		Vijayakumar K	17/03/2014	Chowminya G		Clinician Access ? Webpage dialog Some webpage 
																			dialog displays button not proper.
21/04/2014	  IN047658		Vijayakumar K		14/03/2014		Chowminya G		Reopen - Result Reporting > Result Entry ?Comments-webpage
---------------------------------------------------------------------------------------------------------------
*/
var resultGlobal	     = false;
var messageGlobal	     = "" ;
var invalidCodeGlobal	 = "" ;
var flagGlobal		     = true;


// this function is called on clicking of the checkbox to select all the checkboxes
// in the page where all the records getiing displayed
function clickAll(){
	if(document.review_status_hdg.select_all.checked == true){
		for(cnt=0; cnt<parent.ReviewStatusDtl.document.review_status_dtl.total_recs.value; cnt++)
		{
			val = eval("parent.ReviewStatusDtl.document.review_status_dtl.chk"+cnt);
			val.checked = true;
		}
		//clickHeader();
	}else{
		for(cnt=0; cnt<parent.ReviewStatusDtl.document.review_status_dtl.total_recs.value; cnt++)
		{
			val = eval("parent.ReviewStatusDtl.document.review_status_dtl.chk"+cnt);
			val.checked = false;
		}
	}

}

async function viewOrderFormatLineCmts1(can_reason,line,order_line_num,orderId){
var instrn_type = eval("document.review_status_dtl.instrn_type"+line+".value");
		var dialogHeight ='50vh' ;
		//IN047658 reopen starts
		//var dialogWidth = '29' ;
		var dialogWidth = '70vw' ;
		//IN047658 reopen starts
		var dialogTop	= '189px';
		var dialogLeft = '167px' ;
		var title = ''
			
		if("E"==instrn_type)
		{
			var dialogHeight ='30vh' ;	
			var dialogWidth = '40vw' ;
		}
		
		//IN047658 reopen starts
		//var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		//IN047658 reopen ends

		var arguments = "";
		//var line_narration = eval("parent.ReviewStatusDtl.document.review_status_dtl.Cmts"+line+".value");
		//var finalString	= "&can_reason="+can_reason+"&order_line_num="+order_line_num+"&orderId="+orderId;
		var finalString	= "&can_reason="+can_reason+"&order_line_num="+order_line_num+"&orderId="+orderId+'&instrn_type='+instrn_type;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewLineComment.jsp?"+finalString,arguments,features);

}


function clickHeader(){
	var ord_cat = parent.ReviewStatusDtl.document.review_status_dtl.ord_category.value;
	var completed_at = "header"
	var reason_desc = parent.ReviewStatusHeader.review_status_hdg.complete_all_desc.value
	addCompleteComments(ord_cat,completed_at,reason_desc)

}


function clickLine(){
	var ord_cat = parent.ReviewStatusDtl.document.review_status_dtl.ord_category.value;
	var completed_at = "line"

	var reason_desc = parent.ReviewStatusHeader.review_status_hdg.complete_all_desc.value
	addCompleteComments(ord_cat,completed_at,reason_desc)

}

async function addCompleteComments(ord_cat,completed_at,reason_desc){
		var dialogHeight ='50vh' ;
		var dialogWidth = '70vw' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "ord_cat="+ord_cat+"&completed_at="+completed_at+"&reason_desc="+reason_desc;

		var retVals = await window.showModalDialog("../../eOR/jsp/CompleteComment.jsp?"+finalString,arguments,features);
		parent.ReviewStatusHeader.review_status_hdg.complete_all_desc.value = retVals
}


async function viewAllCompleteComments(){
		var all_cmnts = parent.ReviewStatusHeader.review_status_hdg.complete_all_desc.value
		var dialogHeight ='50vh' ;
		var dialogWidth = '70vw' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "all_cmnts="+escape(all_cmnts);

		var retVals = await window.showModalDialog("../../eOR/jsp/ReviewStatusAllCmts.jsp?"+finalString,arguments,features);

}

function displayDesc(obj){
	document.complete_comment.reason_desc.value = obj.value;
}


function CheckMaxLength(obj,max) {
	if(obj.value.length >= max) {
		alert(getMessage("TEXT_CANT_EXCEED_255","OR"));
		return false;
	} else return true;
}

function selectReason(){
	if(document.complete_comment.reason_desc.value == ""){
		msg1 = getMessage("CANNOT_BE_BLANK","OR");
		alert(msg1.replace("@","Reason "));
		return false;
	}
	if(document.complete_comment.reason_desc.value.length >= 255) {
		alert(getMessage("REMARK_CANT_EXCEED_255_CHAR","OR"));
		return false;
	}
	window.returnValue = document.complete_comment.reason_desc.value;
	window.close();
}

function checkRemark(obj){

	if(obj.value == ""){
		msg1 = getMessage("CANNOT_BE_BLANK","OR");
		alert(msg1.replace("@","Remark "));
		return false;
	}
	if(obj.value.length >= 255) {
		alert(getMessage("REMARK_CANT_EXCEED_255_CHAR","OR"));
		return false;
	}
	window.returnValue = obj.value;
	window.close();
}

function checkLineStatus(obj1, obj2)
{
	//var selectObj = document.review_status_line_remark.order_status;
	if(obj1.value == "")
	{
		alert(getMessage("SELECT_STATUS","OR"));
		obj1.focus()
		return false;
	}

	if(obj2.value == ""){
		msg1 = getMessage("CANNOT_BE_BLANK","OR");
		alert(msg1.replace("@","Status Remark"));
		obj2.focus();
		return false;
	}

	if(obj2.value.length >= 255) {
		alert(getMessage("REMARK_CANT_EXCEED_255_CHAR","OR"));
		return false;
	}

	window.returnValue = obj1.value+'~'+obj2.value;
	window.close();
}

function onOrderStatusChange(obj)
{
	if(obj.value!="")
		viewOrderStatusRemark("");
}

async function viewOrderStatusRemark(line_narration){

		
		var dialogHeight ='30vh' ;
		//IN047658 starts
		//var dialogWidth = '24' ;
		//IN047658 - reopen starts
		//var dialogWidth = '28' ;
		//IN047658 ends
		var dialogWidth = '41vw' ;
		//IN047658 - reopen ends
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		//IN047658 - reopen starts
		//var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		//IN047658 - reopen ends

		var arguments = "";
		var finalString	= "line_narration="+ encodeURIComponent(line_narration);

		var retVals = await window.showModalDialog("../../eOR/jsp/ReviewStatusOrderRemark.jsp?"+finalString,arguments,features);
		//alert("js = "+retVals);
		//if(retVals == null) alert("caught3333");
		if((retVals != null)&&(retVals != "")){
			parent.ReviewStatusTop.document.review_order_status.orderRemark.value = retVals
			document.getElementById("id_remarkLink").innerHTML = getLabel("eOR.Remark.label","OR");
		}
}

async function viewLineStatusRemark(lineStatus, lineStatusRemark, function_id){


		var dialogHeight ='90vh' ;
		//IN047658 starts
		//var dialogWidth = '25' ;
		//IN047658 - reopen starts
		//var dialogWidth = '28' ;
		//IN047658 ends
		var dialogWidth = '80vw' ;
		//IN047658 - reopen ends
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = lineStatusRemark.value;
		var finalString	= "lineStatus="+escape(lineStatus.value)+"&lineStatusRemark="+escape(lineStatusRemark.value)+"&function_id"+function_id;
		//alert(finalString)
		var retVals = await window.showModalDialog("../../eOR/jsp/ReviewStatusLineRemark.jsp?"+finalString,arguments,features);
		if((retVals != null)&&(retVals != "")){
			index = retVals.search('~');
			lineStatus.value = retVals.substr(0,index);
			lineStatusRemark.value = retVals.substr(index+1, retVals.length-1);
		}
}

function record()
{
	topFormObj = parent.ReviewStatusTop.document.review_order_status
	detailFormObj = parent.ReviewStatusDtl.document.review_status_dtl
	task_type = topFormObj.task_type.value;
//alert(task_type);


	if(topFormObj.order_status != null && topFormObj.order_status != undefined){
		if(topFormObj.order_status.value ==  ""){
		   msg1 = getMessage("CANNOT_BE_BLANK","OR");
			alert(msg1.replace("@","Order Status"));
			topFormObj.order_status.focus();
			return false;
		}
	}

	if(task_type=="UpdateOrder"){

	   if(topFormObj.order_status != null && topFormObj.order_status != undefined){
		if(topFormObj.orderRemark.value ==  ""){
		   msg1 = getMessage("CANNOT_BE_BLANK","OR");
			alert(msg1.replace("@","Remark "));
			topFormObj.order_status.focus();
			return false;
		}
	   }

		eval(formApply(topFormObj,OR_CONTROLLER));
		parent.window.returnValue = messageGlobal;
		parent.window.close();
	}
	else
	{
		eval(formApply(detailFormObj,OR_CONTROLLER));
		parent.window.returnValue = messageGlobal;
		parent.window.close();
	}

	if(resultGlobal)
	{
		//detailDoc.location.href="../../eCommon/html/blank.html" ;
		//onSuccess();
		parent.window.returnValue = messageGlobal;
		parent.window.close();
	}
	else
	{
		if(invalidCodeGlobal != "" && invalidCodeGlobal != "null"){
		var msg = messageGlobal + invalidCodeGlobal;
		//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	}
}
}
/*****************assign result function*************************************/
function assignResult(res,msg,mod ,invcode){
//	alert(res+"'"+msg+"'"+mod+"'"+invcode)
	resultGlobal			=res ;
	messageGlobal			=msg ;
	flagGlobal				=mod;
	invalidCodeGlobal		=invcode ;
}

//this function will give the final xml string on click of apply
/*function beforePost(str) {
	alert(str)
}*/

function onBodyLoad()
{
	if(document.review_order_status.order_status)
		if(document.review_order_status.order_status.selectedIndex > 0)
			document.getElementById("id_remarkLink").innerHTML = getLabel("eOR.Remark.label","OR");
}


async function viewReviewDeptData(line){
	var instrn_type = eval("document.review_status_dtl.instrn_type"+line+".value");
		var dialogHeight ='50vh' ;
		//IN047658 starts
		//var dialogWidth = '30' ;
		//IN047658 - reopen starts
		//var dialogWidth = '33' ;
		//IN047658 starts
		var dialogWidth = '70vw' ;
		//IN047658 - reopen ends
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		
		if("E" == instrn_type)
		{
			dialogHeight ='30' ;			
			dialogWidth = '40' ;
		}
		//IN047658 - reopen starts
		//var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		//IN047658 - reopen ends

		var arguments = "";
		//var dept_data = eval("parent.ReviewStatusDtl.document.review_status_dtl.Depts"+line+".value");
		//var finalString	= 'dept_data='+ encodeURIComponent(dept_data);
		//var finalString	= 'line='+line;
		var finalString	= 'line='+line+'&instrn_type='+instrn_type;

		var retVals = await window.showModalDialog("../../eOR/jsp/ViewDeptData.jsp?"+finalString,arguments,features);

}


async function viewReviewPrepsData(line){
	var instrn_type = eval("document.review_status_dtl.instrn_type"+line+".value");
		var dialogHeight ='50vh' ;
		//IN047658 starts
		//var dialogWidth = '30' ;
		//IN047658 - reopen starts
		//var dialogWidth = '33' ;
		//IN047658 starts
		var dialogWidth = '70vw' ;
		//IN047658 - reopen ends
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		
		if("E" == instrn_type)
		{
			dialogHeight ='30vh' ;			
			dialogWidth = '40vw' ;
		}
		//IN047658 - reopen starts
		//var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		//IN047658 - reopen ends

		var arguments = "";
		//var preps_data = eval("parent.ReviewStatusDtl.document.review_status_dtl.Preps"+line+".value");
		//var finalString	= 'preps_data='+ escape(preps_data);
		//var finalString	= 'line='+line;
		var finalString	= 'line='+line+'&instrn_type='+instrn_type;

		var retVals = await window.showModalDialog("../../eOR/jsp/ViewPrepsData.jsp?"+finalString,arguments,features);

}

async function viewReviewApptData(line){
		var dialogHeight ='50vh' ;
		var dialogWidth = '70vw' ;
		var dialogTop	= '249';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var appt_ref_num = eval("parent.ReviewStatusDtl.document.review_status_dtl.Appt"+line+".value");
		var appt_date = eval("parent.ReviewStatusDtl.document.review_status_dtl.Appt_date"+line+".value");
		var appt_locn	 			= eval("parent.ReviewStatusDtl.document.review_status_dtl.appt_locn"+line+".value");
		var appt_resched_yn			= eval("parent.ReviewStatusDtl.document.review_status_dtl.appt_resched_yn"+line+".value");
		var appt_resched_reason		= eval("parent.ReviewStatusDtl.document.review_status_dtl.appt_resched_reason"+line+".value");
		var no_of_reschedules		= eval("parent.ReviewStatusDtl.document.review_status_dtl.no_of_reschedules"+line+".value");
		var order_category			= eval("parent.ReviewStatusDtl.document.review_status_dtl.order_category"+line+".value");
		var cont_order_ind = eval("parent.ReviewStatusDtl.document.review_status_dtl.cont_order_ind"+line+".value");
		var parent_order_id = eval("parent.ReviewStatusDtl.document.review_status_dtl.parent_order_id"+line+".value");
		var parent_order_line_num = eval("parent.ReviewStatusDtl.document.review_status_dtl.parent_order_line_num"+line+".value");
		var bean_id = parent.ReviewStatusDtl.document.review_status_dtl.bean_id.value;
		var bean_name = parent.ReviewStatusDtl.document.review_status_dtl.bean_name.value;
		var function_from = parent.ReviewStatusDtl.document.review_status_dtl.function_from.value;
		//Modifed by Uma on 3/17/2010 for IN020017
		var finalString				= "appt_ref_num="+ escape(appt_ref_num)+"&appt_date="+escape(appt_date)+"&cont_order_ind="+escape(cont_order_ind)+"&parent_order_id="+escape(parent_order_id)+"&parent_order_line_num="+escape(parent_order_line_num)+"&appt_locn="+escape(appt_locn)+"&appt_resched_yn="+escape(appt_resched_yn)+"&appt_resched_reason="+escape(appt_resched_reason)+"&no_of_reschedules="+escape(no_of_reschedules)+"&order_category="+escape(order_category);
		finalString					+= "&bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&function_from="+escape(function_from)


		var retVals = await window.showModalDialog("../../eOR/jsp/ViewApptFrameset.jsp?"+finalString,arguments,features);

}

async function viewOAApptData(line){
	var dialogHeight ='50vh' ;
	var dialogWidth = '60vw' ;
	var dialogTop	= '100';
	var dialogLeft = '30' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
 

	var appt_ref_num = eval("parent.ReviewStatusDtl.document.review_status_dtl.Appt"+line+".value");
	var appt_date = eval("parent.ReviewStatusDtl.document.review_status_dtl.Appt_date"+line+".value");
	var cont_order_ind = eval("parent.ReviewStatusDtl.document.review_status_dtl.cont_order_ind"+line+".value");
	var parent_order_id = eval("parent.ReviewStatusDtl.document.review_status_dtl.parent_order_id"+line+".value");
	var parent_order_line_num = eval("parent.ReviewStatusDtl.document.review_status_dtl.parent_order_line_num"+line+".value");
	var bean_id = parent.ReviewStatusDtl.document.review_status_dtl.bean_id.value;
	var bean_name = parent.ReviewStatusDtl.document.review_status_dtl.bean_name.value;
	var function_from = parent.ReviewStatusDtl.document.review_status_dtl.function_from.value;
	var patient_id	  = parent.ReviewStatusDtl.document.review_status_dtl.patient_id.value;	

	var finalString				= 'i_appt_ref_no='+ escape(appt_ref_num)+'&i_appt_date='+escape(appt_date)+'&cont_order_ind='+escape(cont_order_ind)+'&parent_order_id='+escape(parent_order_id)+'&parent_order_line_num='+escape(parent_order_line_num);
		finalString					+= '&bean_id='+escape(bean_id)+'&bean_name='+escape(bean_name)+'&function_from='+escape(function_from)+'&patient_id='+patient_id+'&flag=Visit_Reg'
		var retVals = await window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?"+finalString,arguments,features);

}



//function viewPatientData(catalog_code,orderId,order_line_num, patient_id){
	async function viewPatientData(orderId,order_line_num,line){
		var instrn_type = eval("document.review_status_dtl.instrn_type"+line+".value");
		var dialogHeight ='60vh' ;
		//IN047658 starts
		//var dialogWidth = '29' ;
		//IN047658 - reopen starts
		//var dialogWidth = '33' ;
		//IN047658 ends
		var dialogWidth = '70vw' ;
		//IN047658 - reopen ends
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = '';
		if("E"==instrn_type)
		{
			var dialogHeight ='50vh' ;	
			var dialogWidth = '70vw' ;
		}
		
		//IN047658 - reopen starts		
		//var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		//IN047658 - reopen ends

		var arguments = "";
		//var instruction = eval("parent.ReviewStatusDtl.document.review_status_dtl.Instruction"+line+".value");
		//var finalString	= 'instruction='+ escape(instruction);
		//var finalString	= "orderId="+ orderId+"&order_line_num="+order_line_num;
		var finalString	= "orderId="+ orderId+"&order_line_num="+order_line_num+'&instrn_type='+instrn_type;


		var retVals = await window.showModalDialog("../../eOR/jsp/viewPatientData.jsp?"+finalString,arguments,features);

	}

function alignHeading()
{
	var totalRows =  document.getElementById("detailTab").rows.length;
	if(totalRows>0)
	{
		if(parent.ReviewStatusHeader.document.getElementById("titleTab") != null) 
		{
			parent.ReviewStatusHeader.document.getElementById("titleTab").width =	eval(document.getElementById("detailTab").offsetWidth);

			for (j=0; j < document.getElementById("detailTab").rows[0].cells.length; j++) 
			{
				var wid=eval(document.getElementById("detailTab").rows[0].cells[j].offsetWidth);
				if(parent.ReviewStatusHeader.document.getElementById("titleTab").rows[0].cells[j] != null)
				{
					parent.ReviewStatusHeader.document.getElementById("titleTab").rows[0].cells[j].width=wid;
				}
			}
		}
	}
}
