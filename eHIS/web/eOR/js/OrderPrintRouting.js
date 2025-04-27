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
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	?				?				created
29/04/2014    IN042962		Chowminya      									CRF:Print Order Sheet From Existing Orders		
19/05/2014	  IN049174		Chowminya										Link1:Pharmacy Order Print Option is defaulted wrongly if Order type is selected
---------------------------------------------------------------------------------------------------------------
*/
///////////////// Global Variable declaration ////////////////////////////////
var function_id = "" ;
var result = false;
var message = "" ;
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var detailDocUpdate=null;
var  formObjDetailUpdate=null	;
///////////////////////////////
function assignResult(_result, _message, _flag){
	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
}
////////////
// call back function
/*function beforePost(str)
	{
		alert(str);
	}*/
///////////
function apply() {



 	if (! checkIsValidForProceed() ) {
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	var ordertype		=  f_query_add_mod.document.or_print_routing.order_type_code.value;
	var patientclass	=	f_query_add_mod.document.or_print_routing.patient_class.value;
	if((ordertype==""||ordertype==null)&&(patientclass==""||patientclass==null)){
		var message=getMessage("ORDER_TYPE","OR");
		message+="<BR>"+getMessage("PATIENT_CLASS","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if(ordertype==""||ordertype==null){
		var message  = getMessage("ORDER_TYPE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if(patientclass==""||patientclass==null){
		var message  = getMessage("PATIENT_CLASS","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	/////////////////////
/*	if(f_query_add_mod.document.or_print_routing.print_consent_form.checked==true){
		if((f_query_add_mod.document.or_print_routing.consent_rout_loc1.value=="") && (f_query_add_mod.document.or_print_routing.consent_rout_loc2.value==""))//f_query_add_mod.document.or_print_routing.consent_urg_loc1,f_query_add_mod.document.or_print_routing.consent_urg_loc2);
		{
			var message =getOrMessage("ROUT_STATUS");
			alert(message);
			//var message ="Rotuine for Loc1 and Loc2 can not be blank..." ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
			return false ;
		}
		if((f_query_add_mod.document.or_print_routing.consent_urg_loc1.value=="") && (f_query_add_mod.document.or_print_routing.consent_urg_loc2.value==""))
		{
			var message =getOrMessage("URG_STATUS");
			alert(message);
			//var message ="Urg/Stat  for Loc1 and Loc2 can not be blank..." ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ "";
			return false ;
		}
	}
*/
	//////////////////////
	
	if(f_query_add_mod.document.or_print_routing.print_at_dest.checked==true){
		if((f_query_add_mod.document.or_print_routing.print_rout_loc1.value=="") && (f_query_add_mod.document.or_print_routing.print_rout_loc2.value==""))//f_query_add_mod.document.or_print_routing.consent_urg_loc1,f_query_add_mod.document.or_print_routing.consent_urg_loc2);
		{
			var message =getMessage("ROUT_STATUS","OR");
			//alert(message);
			alert(getMessage("PRINT_LOC1_AND_LOC2","OR"));
			f_query_add_mod.document.or_print_routing.print_rout_loc1.focus();
			//	var message ="Rotuine for Loc1 and Loc2 can not be blank..." ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
			return false ;
		}
		if((f_query_add_mod.document.or_print_routing.print_urg_loc1.value=="") && (f_query_add_mod.document.or_print_routing.print_urg_loc2.value==""))
		{
			var message =getMessage("URG_STATUS","OR");
			//alert(message);
			alert(getMessage("PRINT_LOC1_AND_LOC2","OR"));
			f_query_add_mod.document.or_print_routing.print_urg_loc1.focus();
			//var message ="Urg/Stat  for Loc1 and Loc2 can not be blank..." ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ "";
			return false ;
		}
	}
	/////////////
	if(f_query_add_mod.document.or_print_routing.print_at_dept_new1.checked==true){
		
		if((f_query_add_mod.document.or_print_routing.print_dept_loc1.value=="") && (f_query_add_mod.document.or_print_routing.print_dept_loc2.value==""))//f_query_add_mod.document.or_print_routing.consent_urg_loc1,f_query_add_mod.document.or_print_routing.consent_urg_loc2);
		{
			var message =getMessage("ROUT_STATUS","OR");
			//alert(message);
			alert(getMessage("PRINT_DEPT_AT_LOC1_LOC2","OR"));
			f_query_add_mod.document.or_print_routing.print_dept_loc1.focus();
			//	var message ="Rotuine for Loc1 and Loc2 can not be blank..." ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
			return false ;
		}
		if((f_query_add_mod.document.or_print_routing.print_urg_dept_loc1.value=="") && (f_query_add_mod.document.or_print_routing.print_urg_dept_loc2.value==""))
		{
			var message =getMessage("URG_STATUS","OR");
			//alert(message);
			alert(getMessage("PRINT_DEPT_AT_LOC1_LOC2","OR"));
			f_query_add_mod.document.or_print_routing.print_urg_dept_loc1.focus();
			//var message ="Urg/Stat  for Loc1 and Loc2 can not be blank..." ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ "";
			return false ;
		}
	}
	/////////////////////
	
	if(f_query_add_mod.document.or_print_routing.otherloc.value == "P"){
		if((f_query_add_mod.document.or_print_routing.print_dept_loc111.value=="") && (f_query_add_mod.document.or_print_routing.print_dept_loc211.value==""))
		{
			var message =getMessage("ROUT_STATUS","OR");
			//alert(message);
			alert(getMessage("PRINT_AT_OTHER_LOC","OR"));
			//	var message ="Rotuine for Loc1 and Loc2 can not be blank..." ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
			return false ;
		}
		if((f_query_add_mod.document.or_print_routing.print_urg_dept_loc111.value=="") && (f_query_add_mod.document.or_print_routing.print_urg_dept_loc211.value==""))
		{
			var message =getMessage("URG_STATUS","OR");
			//alert(message);
			alert(getMessage("PRINT_AT_OTHER_LOC","OR"));
			//var message ="Urg/Stat  for Loc1 and Loc2 can not be blank..." ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ "";
			return false ;
		}
	}
	if((f_query_add_mod.document.or_print_routing.otherloc.value=="S")&&(f_query_add_mod.document.or_print_routing.print_res_at_othloc.value=="")){
		var messages=getMessage("OTHER_LOC_PRINT","OR");//OTHER_LOC_PRINT
		f_query_add_mod.document.or_print_routing.print_res_at_othloc.focus();
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messages;
		return false ;
	}
	//alert("f_query_add_mod.document.or_print_routing.print_des_at_othloc.value :" + f_query_add_mod.document.or_print_routing.print_des_at_othloc.value);
	if((f_query_add_mod.document.or_print_routing.otherlocdis.value=="S")&&(f_query_add_mod.document.or_print_routing.print_des_at_othloc.value=="")){
		var messages=getMessage("DISCHARGE_LOC_PRINT","OR");// OTHER_LOC_PRINT
		alert("==="+messages);
		f_query_add_mod.document.or_print_routing.print_des_at_othloc.focus();
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messages;
		return false ;
	}
	//////////////////////
	setDefault();
	//////////////////////
	//alert("::  ord_dest_routine_queue_dflt  ::"+f_query_add_mod.document.or_print_routing.ord_dest_routine_queue_dflt.value);
	//alert("here1")
	eval(formApply (f_query_add_mod.document.or_print_routing , OR_CONTROLLER ));
//	alert("OR_CONTROLLER")
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
	if(resultGlobal) {
		onSuccess();
    }
	
}
////////////////////////////////////////////////
function setDefault(){
	//////////1
/*	if(f_query_add_mod.document.or_print_routing.consent_rout_loc_radio[0].checked==true){
		f_query_add_mod.document.or_print_routing.consent_routing_queue_dflt.value="1";

	}
	else if(f_query_add_mod.document.or_print_routing.consent_rout_loc_radio[1].checked==true){
		f_query_add_mod.document.or_print_routing.consent_routing_queue_dflt.value="2";

	}
	else{
		f_query_add_mod.document.or_print_routing.consent_routing_queue_dflt.value="";
	}
	/////////////////////
	if(f_query_add_mod.document.or_print_routing.consent_urg_loc_radio[0].checked==true){
		f_query_add_mod.document.or_print_routing.consent_urg_stat_queue_dflt.value="1";
	}
	else if(f_query_add_mod.document.or_print_routing.consent_urg_loc_radio[1].checked==true){
		f_query_add_mod.document.or_print_routing.consent_urg_stat_queue_dflt.value="2";
	}
	else{
		f_query_add_mod.document.or_print_routing.consent_urg_stat_queue_dflt.value="";
	}
*/
	//////////////////////////////5  // ord_dest_routine_queue_dflt
	if(f_query_add_mod.document.or_print_routing.print_rout_loc_radio[0].checked==true){
		f_query_add_mod.document.or_print_routing.ord_dest_routine_queue_dflt.value="1";
	}
	else if(f_query_add_mod.document.or_print_routing.print_rout_loc_radio[1].checked==true){
		f_query_add_mod.document.or_print_routing.ord_dest_routine_queue_dflt.value="2";
	}
	else{
		f_query_add_mod.document.or_print_routing.ord_dest_routine_queue_dflt.value="";
	}
	//////////////////6
	if(f_query_add_mod.document.or_print_routing.print_urg_loc_radio[0].checked==true){
		f_query_add_mod.document.or_print_routing.ord_dest_stat_queue_dflt.value="1";
	}
	else if(f_query_add_mod.document.or_print_routing.print_urg_loc_radio[1].checked==true){
		f_query_add_mod.document.or_print_routing.ord_dest_stat_queue_dflt.value="2";
	}
	else{
		f_query_add_mod.document.or_print_routing.ord_dest_stat_queue_dflt.value="";
	}
	///////////////////////

/*	if(f_query_add_mod.document.or_print_routing.print_rout_ref_loc_radio[0].checked==true){
		f_query_add_mod.document.or_print_routing.refusal_dest_rout_queue_dflt.value="1";
	}
	else if(f_query_add_mod.document.or_print_routing.print_rout_ref_loc_radio[1].checked==true){
		f_query_add_mod.document.or_print_routing.ord_dest_routine_queue_dflt.value="2";
	}
	else{
		f_query_add_mod.document.or_print_routing.refusal_dest_rout_queue_dflt.value="";
	}
 

	//////////////////////

	if(f_query_add_mod.document.or_print_routing.print_urg_loc_ref_radio[0].checked==true){
		f_query_add_mod.document.or_print_routing.refusal_dest_stat_queue_dflt.value="1";
	}
	else if(f_query_add_mod.document.or_print_routing.print_urg_loc_ref_radio[1].checked==true){
		f_query_add_mod.document.or_print_routing.refusal_dest_stat_queue_dflt.value="2";
	}
	else{
		f_query_add_mod.document.or_print_routing.refusal_dest_stat_queue_dflt.value="";
	}
*/
	////////added by Kavitha.K

/*	if(f_query_add_mod.document.or_print_routing.print_rout_referral_loc_radio[0].checked==true){
		f_query_add_mod.document.or_print_routing.referral_dest_rout_queue_dflt.value="1";
	}
	else if(f_query_add_mod.document.or_print_routing.print_rout_referral_loc_radio[1].checked==true){
		f_query_add_mod.document.or_print_routing.ord_dest_routine_queue_dflt.value="2";
	}
	else{
		f_query_add_mod.document.or_print_routing.referral_dest_rout_queue_dflt.value="";
	}


	//////////////////////

	if(f_query_add_mod.document.or_print_routing.print_urg_loc_referral_radio[0].checked==true){
		f_query_add_mod.document.or_print_routing.referral_dest_stat_queue_dflt.value="1";
	}
	else if(f_query_add_mod.document.or_print_routing.print_urg_loc_referral_radio[1].checked==true){
		f_query_add_mod.document.or_print_routing.referral_dest_stat_queue_dflt.value="2";
	}
	else{
		f_query_add_mod.document.or_print_routing.referral_dest_stat_queue_dflt.value="";
	}
*/
	/////////////////////end of added by Kavitha.K
	if(f_query_add_mod.document.or_print_routing.print_report_dept_loc_radio[0].checked==true){
		f_query_add_mod.document.or_print_routing.res_dept_routing_queue_dflt.value="1";
	}
	else if(f_query_add_mod.document.or_print_routing.print_report_dept_loc_radio[1].checked==true){
		f_query_add_mod.document.or_print_routing.res_dept_routing_queue_dflt.value="2";
	}
	else{
		f_query_add_mod.document.or_print_routing.res_dept_routing_queue_dflt.value="";
	}
	//////////////////////////8
	if(f_query_add_mod.document.or_print_routing.print_report_urg_dept_loc_radio[0].checked==true){
		f_query_add_mod.document.or_print_routing.res_dept_stat_queue_dflt.value="1";
	}
	else if(f_query_add_mod.document.or_print_routing.print_report_urg_dept_loc_radio[1].checked==true){
		f_query_add_mod.document.or_print_routing.res_dept_stat_queue_dflt.value="2";
	}
	else{
		f_query_add_mod.document.or_print_routing.res_dept_stat_queue_dflt.value="";
	}
}

////////////////////////////////////////////////
function setLocationDefaultFirst(thisObj){
	if(document.or_print_routing.print_consent_form.checked==true){
		if(document.or_print_routing.consent_rout_loc_radio[0].checked==true){
			//document.or_print_routing.consent_routing_queue_dflt.value="1";
		}else{
			//	document.or_print_routing.consent_routing_queue_dflt.value="2";
		}
		if(document.or_print_routing.consent_urg_loc_radio[0].checked==true){
			//	document.or_print_routing.consent_urg_stat_queue_dflt.value="1";
		}else{
			//document.or_print_routing.consent_urg_stat_queue_dflt.value="2";
		}
	}
	else{
		document.or_print_routing.consent_routing_queue_dflt.value="";
		document.or_print_routing.consent_urg_stat_queue_dflt.value="";
	}
}
//////////////////////////////////

function setrefusalLocationDefaultSecond(thisObj){
if(document.or_print_routing.print_at_refu_dest.checked==true){
		if(document.or_print_routing.print_rout_ref_loc_radio[0].checked==true){
			document.or_print_routing.refusal_dest_rout_queue_dflt.value="1";
		}else{
			document.or_print_routing.refusal_dest_rout_queue_dflt.value="2";
		}
		if(document.or_print_routing.print_urg_loc_ref_radio[0].checked==true){
			document.or_print_routing.refusal_dest_stat_queue_dflt.value="1";
		}else{
			document.or_print_routing.refusal_dest_stat_queue_dflt.value="2";
		}
	}
	else{
		document.or_print_routing.refusal_dest_rout_queue_dflt.value="";
		document.or_print_routing.refusal_dest_stat_queue_dflt="";
	}
}
///////////////added by Kavitha.K
function setreferralLocationDefaultSecond(thisObj){
if(document.or_print_routing.print_at_referral_dest.checked==true){
		if(document.or_print_routing.print_rout_referral_loc_radio[0].checked==true){
			document.or_print_routing.referral_dest_rout_queue_dflt.value="1";
		}else{
			document.or_print_routing.referral_dest_rout_queue_dflt.value="2";
		}
		if(document.or_print_routing.print_urg_loc_referral_radio[0].checked==true){
			document.or_print_routing.referral_dest_stat_queue_dflt.value="1";
		}else{
			document.or_print_routing.referral_dest_stat_queue_dflt.value="2";
		}
	}
	else{
		document.or_print_routing.referral_dest_rout_queue_dflt.value="";
		document.or_print_routing.referral_dest_stat_queue_dflt="";
	}
}

////////////////////////////////////////////////////
function setLocationDefaultSecond(thisObj){
	if(document.or_print_routing.print_at_dest.checked==true){
		if(document.or_print_routing.print_rout_loc_radio[0].checked==true){
			document.or_print_routing.ord_dest_routine_queue_dflt.value="1";
		}else{
			document.or_print_routing.ord_dest_routine_queue_dflt.value="2";
		}
		if(document.or_print_routing.print_urg_loc_radio[0].checked==true){
			document.or_print_routing.ord_dest_stat_queue_dflt.value="1";
		}else{
			document.or_print_routing.ord_dest_stat_queue_dflt.value="2";
		}
	}
	else{
		document.or_print_routing.ord_dest_routine_queue_dflt.value="";
		document.or_print_routing.ord_dest_stat_queue_dflt="";
	}
}
//////////////////////////////////////////////////
function setLocationDefaultThird(thisObj){
	if(document.or_print_routing.print_at_dept_new1.checked==true){
		if(document.or_print_routing.print_report_dept_loc_radio[0].checked==true){
			document.or_print_routing.res_dept_routing_queue_dflt.value="1";
		}else{
			document.or_print_routing.res_dept_routing_queue_dflt.value="2";
		}
		if(document.or_print_routing.print_report_urg_dept_loc_radio[0].checked==true){
			document.or_print_routing.res_dept_stat_queue_dflt.value="1";
		}
		else{
			document.or_print_routing.res_dept_stat_queue_dflt.value="2";
		}
	}
	else{
		document.or_print_routing.res_dept_routing_queue_dflt.value="";
		document.or_print_routing.res_dept_stat_queue_dflt.value="";
	}
}
/////////////////////////////////////
function checkIsValidForProceed()
{
	var url = f_query_add_mod.location.href;
 	url = url.toLowerCase();
 	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
  		return true;
 	else
  		return false;
}
/////////////////////////////////
function onSuccess()
{
//	var mode = f_query_add_mod.or_print_routing.mode.value;
//	if( mode == "1" )
	formReset ();
}
////////////////////////////////////////////////////////////////
function formReset () {
	//alert("in modify formreset function ");
	f_query_add_mod.location.reload();
}
//////////////////////////////////////////
function create() {
	//alert("in create()");
	f_query_add_mod.location.href = "../../eOR/jsp/OrderPrintRoutingAddModify.jsp?mode=1&function_id=Order_Print(Requistion)_Routing";
}
//////////////////////////////////////////
function query() {
	f_query_add_mod.location.href="../../eOR/jsp/OrderPrintRoutingQueryCriteria.jsp";
}
//////////////////////////////////////////
function deleterecord(){
	if (! checkIsValidForProceed() ) {
		var message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	
	if((f_query_add_mod.document.or_print_routing) && f_query_add_mod.document.or_print_routing.mode.value != MODE_INSERT){
		f_query_add_mod.document.or_print_routing.mode.value = MODE_DELETE;
		var confirm_val= window.confirm(getMessage("DELETE_CONFIRM","OR"));
		if(confirm_val){
			eval(formApply( f_query_add_mod.document.or_print_routing,OR_CONTROLLER));
			f_query_add_mod.location.href = "../../eOR/jsp/OrderPrintRoutingAddModify.jsp?mode=1&function_id=Order_Print(Requistion)_Routing";
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
			if( resultGlobal ) {
				f_query_add_mod.location.href = "../../eOR/jsp/OrderPrintRoutingAddModify.jsp?mode=1&function_id=Order_Print(Requistion)_Routing";
			}
		}else
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}else{
		var message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
}
//////////////////////////////////////////
function reset(){
	var url =f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")!=-1) || (url.indexOf("query")!=-1) ){
		f_query_add_mod.document.forms[0].reset();
		return ;
	}
	if(url.indexOf("blank")!=-1)return;
	if(f_query_add_mod.document.or_print_routing&&f_query_add_mod.document.or_print_routing.mode.value=="1"){
		create();
	}
	else if(f_query_add_mod.document.or_print_routing.mode.value=="2" || f_query_add_mod.document.or_print_routing.mode.value==MODE_DELETE){
		//alert(" in modify reset ");
		//f_query_add_mod.document.or_print_routing.reset();
		f_query_add_mod.location.reload();
	}

}
/////////////////////////////////////////
async function callOrderType(textVal) {
	var dialogHeight	= "19" ;
	var dialogWidth	= "26" ;
	var dialogTop		= "100" ;
	var dialogLeft		= "150" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
	var arguments		= "" ;
	var retVal				= await window.showModalDialog( "../../eOR/jsp/OrderPrintRoutingLookUp.jsp?textVal="+textVal, arguments, features );
	if((retVal!="")||(retVal!=null))
		parent.f_query_add_mod.document.or_print_routing.order_type_instruction.value=retVal;
	else
		parent.f_query_add_mod.document.or_print_routing.order_type_instruction.value="";
}
/////////////////////////////////
function fillLocation(itemObj){
	
	if(itemObj.value == ""||itemObj.value == "X"||itemObj.value=="P" ){
		if(itemObj.name=="otherloc"){
			if(itemObj.value=="")
			{
				parent.f_query_add_mod.document.getElementById("location_id").innerHTML="&nbsp;"
			}
			if(itemObj.value=="P"){
				parent.f_query_add_mod.document.getElementById("location_id").innerHTML="<INPUT type='button' class='button' value='"+getLabel("eOR.EnterLocation.label","OR")+"' onclick='showwindow()'></INPUT>";

			}
			if(itemObj.value=="X"){
				parent.f_query_add_mod.document.getElementById("location_id").innerHTML="&nbsp;";
			}
			//Added by Siva Kumar 20/8/2003
			//parent.f_query_add_mod.document.getElementById("location_type").innerHTML="&nbsp;";
			//parent.f_query_add_mod.document.getElementById("location_val").innerHTML="&nbsp;";
			//End of Addition
			//	parent.f_query_add_mod.document.getElementById("locationname1").innerHTML="&nbsp;";
		}
		else{

			parent.f_query_add_mod.document.getElementById("deafult_id").innerHTML="&nbsp;";
            //Added by Siva Kumar 20/8/2003
            //parent.f_query_add_mod.document.getElementById("default_type").innerHTML="&nbsp;";
            //parent.f_query_add_mod.document.getElementById("default_val").innerHTML="&nbsp;";
            //End of Addition
//			parent.f_query_add_mod.document.getElementById("locationname2").innerHTML="&nbsp;";
		}
		if(itemObj.name=="otherlocdis"){


			if(itemObj.value == "P")
			{
				parent.f_query_add_mod.document.getElementById("deafult_id").innerHTML= ""+getLabel("Common.Location.label","Common")+"<INPUT type='text'  maxlength='20' value='' name='disPatLoc' id='disPatLoc' ></INPUT>";
			}
			else
			{
				parent.f_query_add_mod.document.getElementById("deafult_id").innerHTML="&nbsp;";
			}

		}
		else
		{
		}

		return ;
	}

    if(itemObj.name=="otherloc"){

    //	parent.f_query_add_mod.document.getElementById("locationname1").innerHTML="Location Name";
		parent.f_query_add_mod.document.getElementById("location_id").innerHTML=""+getLabel("Common.Location.label","Common")+"<select name='loctype' id='loctype' onchange='fillTypeLocation(this);'><option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</option><option value='C'>"+getLabel("Common.clinic.label","Common")+"</option><option value='N'>"+getLabel("Common.nursingUnit.label","Common")+"</option></select><select name='print_res_at_othloc' id='print_res_at_othloc'><option value=''>---<fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/>---</option> </select><img src='../../eCommon/images/mandatory.gif' align=center></img>";
	}
	else if(itemObj.name=="otherlocdis"){
//		parent.f_query_add_mod.document.getElementById("locationname2").innerHTML="Location Name";

		parent.f_query_add_mod.document.getElementById("deafult_id").innerHTML="&nbsp;";
		parent.f_query_add_mod.document.getElementById("deafult_id").innerHTML=""+getLabel("Common.Location.label","Common")+"<select name='loctype1' id='loctype1' onchange='fillTypeLocation(this);'><option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</option><option value=''>"+getLabel("Common.clinic.label","Common")+"</option><option value=''>"+getLabel("Common.nursingUnit.label","Common")+"</option></select>&nbsp;<select name='print_des_at_othloc' id='print_des_at_othloc'><option value=''>---<fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/>---</option></select><img src='../../eCommon/images/mandatory.gif' align=center></img>";//<select name='loctype1' id='loctype1' onchange='fillTypeLocation(this);'><option value=''>---Select---</option><option value=''>Clinic</option><option value=''>Nursing Unit</option></select>
	}

	var bean_id = document.or_print_routing.bean_id.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += itemObj.name+"=\""+ itemObj.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(itemObj.name=="otherloc"){
		xmlHttp.open( "POST", "OrderPrintRoutingFillLocation.jsp?bean_id=Or_or_print_routing&itemName ="+itemObj.name,false ) ;}
	else {
		xmlHttp.open( "POST", "OrderPrintRoutingFillLocationBottom.jsp?bean_id=Or_or_print_routing&itemName ="+itemObj.name,false ) ;
	}
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	//alert(responseText);
	eval( responseText ) ;
}
///////////////////////////////////////////////////////////////////////////
function addLocation2List(code,value){
	var element = document.createElement('OPTION') ;
	element.value = code ;
	element.text  = value ;
	document.or_print_routing.print_res_at_othloc.add(element);
}
/////////////////////////////////////////////////////////////////////////////
function clearLocationList( docObj ) {
	var len = eval(docObj+".or_print_routing.print_res_at_othloc.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".or_print_routing.print_res_at_othloc.remove(\"print_res_at_othloc\")") ;
	}
	//alert("in create the of first element2");
	var tp = " --- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".or_print_routing.print_res_at_othloc.add(opt)") ;
}
////////////////////////////////////////////////////////////////////////////////
function clearLocationList1( docObj ) {
	var len = eval(docObj+".or_print_routing.print_des_at_othloc.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".or_print_routing.print_des_at_othloc.remove(\"print_des_at_othloc\")") ;
	}
	var tp = " --- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".or_print_routing.print_des_at_othloc.add(opt)") ;
}
////////////////////////////////////////////////////////////////////////////////
function addLocation2List1(code,value) {
	var element = document.createElement('OPTION') ;
	element.value = code ;
	element.text  = value ;
	document.or_print_routing.print_des_at_othloc.add(element);
}
/////////////////////////////
function setPriorityrefusal2(Obj){
if(Obj.checked==false&&document.or_print_routing.mode.value=="1"){
		document.or_print_routing.print_at_refu_dest1.value="N";
		document.or_print_routing.print_rout_ref_loc1.value="";
		document.or_print_routing.print_rout_ref_loc1.disabled=true;
		document.or_print_routing.print_rout_ref_loc2.value="";
		document.or_print_routing.print_rout_ref_loc2.disabled=true;
		document.or_print_routing.print_urg_ref_loc1.value="";
		document.or_print_routing.print_urg_ref_loc1.disabled=true;
		document.or_print_routing.print_urg_ref_loc2.value="";
		document.or_print_routing.print_urg_ref_loc2.disabled=true;
		document.or_print_routing.print_rout_ref_loc_radio[0].checked=false;
		document.or_print_routing.print_rout_ref_loc_radio[0].disabled=true;
		document.or_print_routing.print_rout_ref_loc_radio[1].checked=false;
		document.or_print_routing.print_rout_ref_loc_radio[1].disabled=true;
		document.or_print_routing.print_urg_loc_ref_radio[0].checked=false;
		document.or_print_routing.print_urg_loc_ref_radio[0].disabled=true;
		document.or_print_routing.print_urg_loc_ref_radio[1].checked=false;
		document.or_print_routing.print_urg_loc_ref_radio[1].disabled=true;
	}
	else if(Obj.checked==false&&document.or_print_routing.mode.value=="2"){
		document.or_print_routing.print_at_refu_dest1.value="N";
		document.or_print_routing.print_rout_ref_loc1.value="";
		document.or_print_routing.print_rout_ref_loc1.disabled=true;
		document.or_print_routing.print_rout_ref_loc2.value="";
		document.or_print_routing.print_rout_ref_loc2.disabled=true;
		document.or_print_routing.print_urg_ref_loc1.value="";
		document.or_print_routing.print_urg_ref_loc1.disabled=true;
		document.or_print_routing.print_urg_ref_loc2.value="";
		document.or_print_routing.print_urg_ref_loc2.disabled=true;
		document.or_print_routing.print_rout_ref_loc_radio[0].checked=false;
		document.or_print_routing.print_rout_ref_loc_radio[0].disabled=true;
		document.or_print_routing.print_rout_ref_loc_radio[1].checked=false;
		document.or_print_routing.print_rout_ref_loc_radio[1].disabled=true;
		document.or_print_routing.print_urg_loc_ref_radio[0].checked=false;
		document.or_print_routing.print_urg_loc_ref_radio[0].disabled=true;
		document.or_print_routing.print_urg_loc_ref_radio[1].checked=false;
		document.or_print_routing.print_urg_loc_ref_radio[1].disabled=true;
	}
	else {
		document.or_print_routing.print_at_refu_dest1.value="Y";
		document.or_print_routing.print_urg_ref_loc1.disabled=false;
		document.or_print_routing.print_urg_ref_loc2.disabled=false;
		document.or_print_routing.print_rout_ref_loc1.disabled=false;
		document.or_print_routing.print_rout_ref_loc2.disabled=false;
	}
}
//added by Kavitha.K
function setPriorityreferral2(Obj){
if(Obj.checked==false&&document.or_print_routing.mode.value=="1"){
		document.or_print_routing.print_at_referral_dest1.value="N";
		document.or_print_routing.print_rout_referral_loc1.value="";
		document.or_print_routing.print_rout_referral_loc1.disabled=true;
		document.or_print_routing.print_rout_referral_loc2.value="";
		document.or_print_routing.print_rout_referral_loc2.disabled=true;
		document.or_print_routing.print_urg_referral_loc1.value="";
		document.or_print_routing.print_urg_referral_loc1.disabled=true;
		document.or_print_routing.print_urg_referral_loc2.value="";
		document.or_print_routing.print_urg_referral_loc2.disabled=true;
		document.or_print_routing.print_rout_referral_loc_radio[0].checked=false;
		document.or_print_routing.print_rout_referral_loc_radio[0].disabled=true;
		document.or_print_routing.print_rout_referral_loc_radio[1].checked=false;
		document.or_print_routing.print_rout_referral_loc_radio[1].disabled=true;
		document.or_print_routing.print_urg_loc_referral_radio[0].checked=false;
		document.or_print_routing.print_urg_loc_referral_radio[0].disabled=true;
		document.or_print_routing.print_urg_loc_referral_radio[1].checked=false;
		document.or_print_routing.print_urg_loc_referral_radio[1].disabled=true;
	}
	else if(Obj.checked==false&&document.or_print_routing.mode.value=="2"){
		document.or_print_routing.print_at_referral_dest1.value="N";
		document.or_print_routing.print_rout_referral_loc1.value="";
		document.or_print_routing.print_rout_referral_loc1.disabled=true;
		document.or_print_routing.print_rout_referral_loc2.value="";
		document.or_print_routing.print_rout_referral_loc2.disabled=true;
		document.or_print_routing.print_urg_referral_loc1.value="";
		document.or_print_routing.print_urg_referral_loc1.disabled=true;
		document.or_print_routing.print_urg_referral_loc2.value="";
		document.or_print_routing.print_urg_referral_loc2.disabled=true;
		document.or_print_routing.print_rout_referral_loc_radio[0].checked=false;
		document.or_print_routing.print_rout_referral_loc_radio[0].disabled=true;
		document.or_print_routing.print_rout_referral_loc_radio[1].checked=false;
		document.or_print_routing.print_rout_referral_loc_radio[1].disabled=true;
		document.or_print_routing.print_urg_loc_referral_radio[0].checked=false;
		document.or_print_routing.print_urg_loc_referral_radio[0].disabled=true;
		document.or_print_routing.print_urg_loc_referral_radio[1].checked=false;
		document.or_print_routing.print_urg_loc_referral_radio[1].disabled=true;
	}
	else {
		document.or_print_routing.print_at_referral_dest1.value="Y";
		document.or_print_routing.print_urg_referral_loc1.disabled=false;
		document.or_print_routing.print_urg_referral_loc2.disabled=false;
		document.or_print_routing.print_rout_referral_loc1.disabled=false;
		document.or_print_routing.print_rout_referral_loc2.disabled=false;
	}
}

// setting the default one and others if that is checked and setting disabled if they r not checked
function setPriority2(Obj){
	if(Obj.checked==false&&document.or_print_routing.mode.value=="1"){
		document.or_print_routing.print_at_dest1.value="N";
		document.or_print_routing.print_rout_loc1.value="";
		document.or_print_routing.print_rout_loc1.disabled=true;
		document.or_print_routing.print_rout_loc2.value="";
		document.or_print_routing.print_rout_loc2.disabled=true;
		document.or_print_routing.print_urg_loc1.value="";
		document.or_print_routing.print_urg_loc1.disabled=true;
		document.or_print_routing.print_urg_loc2.value="";
		document.or_print_routing.print_urg_loc2.disabled=true;
		document.or_print_routing.print_rout_loc_radio[0].checked=false;
		document.or_print_routing.print_rout_loc_radio[0].disabled=true;
		document.or_print_routing.print_rout_loc_radio[1].checked=false;
		document.or_print_routing.print_rout_loc_radio[1].disabled=true;
		document.or_print_routing.print_urg_loc_radio[0].checked=false;
		document.or_print_routing.print_urg_loc_radio[0].disabled=true;
		document.or_print_routing.print_urg_loc_radio[1].checked=false;
		document.or_print_routing.print_urg_loc_radio[1].disabled=true;
	}
	else if(Obj.checked==false&&document.or_print_routing.mode.value=="2"){
		document.or_print_routing.print_at_dest1.value="N";
		document.or_print_routing.print_rout_loc1.value="";
		document.or_print_routing.print_rout_loc1.disabled=true;
		document.or_print_routing.print_rout_loc2.value="";
		document.or_print_routing.print_rout_loc2.disabled=true;
		document.or_print_routing.print_urg_loc1.value="";
		document.or_print_routing.print_urg_loc1.disabled=true;
		document.or_print_routing.print_urg_loc2.value="";
		document.or_print_routing.print_urg_loc2.disabled=true;
		document.or_print_routing.print_rout_loc_radio[0].checked=false;
		document.or_print_routing.print_rout_loc_radio[0].disabled=true;
		document.or_print_routing.print_rout_loc_radio[1].checked=false;
		document.or_print_routing.print_rout_loc_radio[1].disabled=true;
		document.or_print_routing.print_urg_loc_radio[0].checked=false;
		document.or_print_routing.print_urg_loc_radio[0].disabled=true;
		document.or_print_routing.print_urg_loc_radio[1].checked=false;
		document.or_print_routing.print_urg_loc_radio[1].disabled=true;
	}
	else {
		document.or_print_routing.print_at_dest1.value="Y";
		document.or_print_routing.print_urg_loc1.disabled=false;
		document.or_print_routing.print_urg_loc2.disabled=false;
		document.or_print_routing.print_rout_loc1.disabled=false;
		document.or_print_routing.print_rout_loc2.disabled=false;
	}
}
function setPriority1(Obj){
	if(Obj.checked==false&&document.or_print_routing.mode.value=="1"){
		document.or_print_routing.consent_rout_loc1.value="";
		document.or_print_routing.consent_rout_loc1.disabled=true;
		document.or_print_routing.consent_rout_loc2.value="";
		document.or_print_routing.consent_rout_loc2.disabled=true;
		document.or_print_routing.consent_urg_loc1.value="";
		document.or_print_routing.consent_urg_loc1.disabled=true;
		document.or_print_routing.consent_urg_loc2.value="";
		document.or_print_routing.consent_urg_loc2.disabled=true;
		document.or_print_routing.print_consent_form_order.value="N";
		document.or_print_routing.consent_rout_loc_radio[0].checked=false;
		document.or_print_routing.consent_rout_loc_radio[0].disabled=true;
		document.or_print_routing.consent_rout_loc_radio[1].checked=false;
		document.or_print_routing.consent_rout_loc_radio[1].disabled=true;
		document.or_print_routing.consent_urg_loc_radio[0].checked=false;
		document.or_print_routing.consent_urg_loc_radio[0].disabled=true;
		document.or_print_routing.consent_urg_loc_radio[1].checked=false;
		document.or_print_routing.consent_urg_loc_radio[1].disabled=true;
	}else if(Obj.checked==false&&document.or_print_routing.mode.value=="2"){
		document.or_print_routing.print_consent_form_order.value="N";
		document.or_print_routing.consent_rout_loc1.value="";
		document.or_print_routing.consent_rout_loc1.disabled=true;
        document.or_print_routing.consent_rout_loc2.value="";
		document.or_print_routing.consent_rout_loc2.disabled=true;
        document.or_print_routing.consent_urg_loc1.value="";
		document.or_print_routing.consent_urg_loc1.disabled=true;
        document.or_print_routing.consent_urg_loc2.value="";
		document.or_print_routing.consent_urg_loc2.disabled=true;
        //document.or_print_routing.print_consent_form_order.value="N";
		document.or_print_routing.consent_rout_loc_radio[0].checked=false;
		document.or_print_routing.consent_rout_loc_radio[0].disabled=true;
		document.or_print_routing.consent_rout_loc_radio[1].checked=false;
		document.or_print_routing.consent_rout_loc_radio[1].disabled=true;
		document.or_print_routing.consent_urg_loc_radio[0].checked=false;
		document.or_print_routing.consent_urg_loc_radio[0].disabled=true;
		document.or_print_routing.consent_urg_loc_radio[1].checked=false;
		document.or_print_routing.consent_urg_loc_radio[1].disabled=true;
 	}
	else{
		document.or_print_routing.print_consent_form_order.value="Y";
		document.or_print_routing.consent_rout_loc1.disabled=false;
		document.or_print_routing.consent_rout_loc2.disabled=false;
		document.or_print_routing.consent_urg_loc1.disabled=false;
		document.or_print_routing.consent_urg_loc2.disabled=false;
	}
}
function setPriority3(Obj){
	if(Obj.checked==false&&document.or_print_routing.mode.value=="1"){
		document.or_print_routing.print_at_dept_new.value="N";
    	document.or_print_routing.print_dept_loc1.value="";
		document.or_print_routing.print_dept_loc1.disabled=true;
    	document.or_print_routing.print_dept_loc2.value="";
		document.or_print_routing.print_dept_loc2.disabled=true;
    	document.or_print_routing.print_urg_dept_loc1.value="";
		document.or_print_routing.print_urg_dept_loc1.disabled=true;
    	document.or_print_routing.print_urg_dept_loc2.value="";
		document.or_print_routing.print_urg_dept_loc2.disabled=true;
    	document.or_print_routing.print_report_dept_loc_radio[0].checked=false;
		document.or_print_routing.print_report_dept_loc_radio[0].disabled=true;
    	document.or_print_routing.print_report_dept_loc_radio[1].checked=false;
		document.or_print_routing.print_report_dept_loc_radio[1].disabled=true;
    	document.or_print_routing.print_report_urg_dept_loc_radio[0].checked=false;
		document.or_print_routing.print_report_urg_dept_loc_radio[0].disabled=true;
    	document.or_print_routing.print_report_urg_dept_loc_radio[1].checked=false;
		document.or_print_routing.print_report_urg_dept_loc_radio[1].disabled=true;
	}
	else if(Obj.checked==false&&document.or_print_routing.mode.value=="2"){
		document.or_print_routing.print_at_dept_new.value="N";
    	document.or_print_routing.print_dept_loc1.value="";
		document.or_print_routing.print_dept_loc1.disabled=true;
    	document.or_print_routing.print_dept_loc2.value="";
		document.or_print_routing.print_dept_loc2.disabled=true;
    	document.or_print_routing.print_urg_dept_loc1.value="";
		document.or_print_routing.print_urg_dept_loc1.disabled=true;
    	document.or_print_routing.print_urg_dept_loc2.value="";
		document.or_print_routing.print_urg_dept_loc2.disabled=true;
    	document.or_print_routing.print_report_dept_loc_radio[0].checked=false;
		document.or_print_routing.print_report_dept_loc_radio[0].disabled=true;
    	document.or_print_routing.print_report_dept_loc_radio[1].checked=false;
		document.or_print_routing.print_report_dept_loc_radio[1].disabled=true;
    	document.or_print_routing.print_report_urg_dept_loc_radio[0].checked=false;
		document.or_print_routing.print_report_urg_dept_loc_radio[0].disabled=true;
    	document.or_print_routing.print_report_urg_dept_loc_radio[1].checked=false;
		document.or_print_routing.print_report_urg_dept_loc_radio[1].disabled=true;
	}
	else {
		document.or_print_routing.print_at_dept_new.value="Y";
		document.or_print_routing.print_dept_loc1.disabled=false;
		document.or_print_routing.print_dept_loc2.disabled=false;
		document.or_print_routing.print_urg_dept_loc1.disabled=false;
		document.or_print_routing.print_urg_dept_loc2.disabled=false;
	}
}
/////////////////////check for valid operation start here///////////////////
function setLocationThis1(textObj){
	if(textObj.value  !=""){
		document.or_print_routing.consent_rout_loc_radio[0].disabled=false;
   		if(document.or_print_routing.consent_rout_loc2.value!=""){
			if(document.or_print_routing.consent_rout_loc_radio[1].checked){
				document.or_print_routing.consent_routing_queue_dflt.value="2";
				document.or_print_routing.consent_rout_loc_radio[1].disabled=false;
			}else{
    			document.or_print_routing.consent_routing_queue_dflt.value="1";
			}
		}else{
			document.or_print_routing.consent_rout_loc_radio[1].checked=false;
			document.or_print_routing.consent_rout_loc_radio[1].disabled=true;
			document.or_print_routing.consent_rout_loc_radio[0].checked=true;
		}
	}else {
		if(document.or_print_routing.consent_rout_loc2.value!=""){
			document.or_print_routing.consent_rout_loc_radio[1].checked=true;
			document.or_print_routing.consent_rout_loc_radio[0].checked=false;
			document.or_print_routing.consent_rout_loc_radio[0].disabled=true;
			document.or_print_routing.consent_routing_queue_dflt.value="2";
		}else	{
    		document.or_print_routing.consent_routing_queue_dflt.value="1";
			document.or_print_routing.consent_rout_loc_radio[0].checked=false;
			document.or_print_routing.consent_rout_loc_radio[0].disabled=true;
			document.or_print_routing.consent_rout_loc_radio[1].disabled=true;
		}
	}
}
function setLocationThis2(textObj){
	if(textObj.value!=""){
		document.or_print_routing.consent_rout_loc_radio[1].disabled=false;
		if(document.or_print_routing.consent_rout_loc1.value==""){
			document.or_print_routing.consent_rout_loc_radio[0].checked=false;
			document.or_print_routing.consent_rout_loc_radio[0].disabled=true;
			document.or_print_routing.consent_rout_loc_radio[1].checked=true;
		}
		else{
			if(document.or_print_routing.consent_rout_loc_radio[0].checked){
				document.or_print_routing.consent_rout_loc_radio[1].checked=false;
				document.or_print_routing.consent_rout_loc_radio[0].checked=true;
				document.or_print_routing.consent_rout_loc_radio[0].disabled=false;
			}else{
				document.or_print_routing.consent_rout_loc_radio[0].checked=false;
				document.or_print_routing.consent_rout_loc_radio[1].checked=true;
			}
		}
	}else	{
		document.or_print_routing.consent_rout_loc_radio[1].checked=false;
		document.or_print_routing.consent_rout_loc_radio[1].disabled=true;
		if(document.or_print_routing.consent_rout_loc1.value!=""){
			document.or_print_routing.consent_rout_loc_radio[0].disabled=false;
			document.or_print_routing.consent_rout_loc_radio[0].checked=true;
		}else{
			document.or_print_routing.consent_rout_loc_radio[0].checked=false;
			document.or_print_routing.consent_rout_loc_radio[0].disabled=true;
		}
	}
}
function setLocationThis3(textObj){
	if(textObj.value  !=""){
		document.or_print_routing.consent_urg_loc_radio[0].disabled=false;
   		if(document.or_print_routing.consent_urg_loc2.value!=""){
			if(document.or_print_routing.consent_urg_loc_radio[1].checked){
				document.or_print_routing.consent_urg_stat_queue_dflt.value="2";
				document.or_print_routing.consent_urg_loc_radio[1].disabled=false;
			}else{
				document.or_print_routing.consent_urg_stat_queue_dflt.value="1";
			}
		}else{
			document.or_print_routing.consent_urg_loc_radio[1].checked=false;
			document.or_print_routing.consent_urg_loc_radio[1].disabled=true;
			document.or_print_routing.consent_urg_loc_radio[0].checked=true;
		}
	}else {
		if(document.or_print_routing.consent_urg_loc2.value!=""){
			document.or_print_routing.consent_urg_loc_radio[1].checked=true;
			document.or_print_routing.consent_urg_loc_radio[0].checked=false;
			document.or_print_routing.consent_urg_loc_radio[0].disabled=true;
			document.or_print_routing.consent_urg_stat_queue_dflt.value="2";
		}else	{
			document.or_print_routing.consent_urg_stat_queue_dflt.value="1";
			document.or_print_routing.consent_urg_loc_radio[0].checked=false;
			document.or_print_routing.consent_urg_loc_radio[0].disabled=true;
			document.or_print_routing.consent_urg_loc_radio[1].disabled=true;
		}
	}
}
function setLocationThis4(textObj){
	if(textObj.value!=""){
		document.or_print_routing.consent_urg_loc_radio[1].disabled=false;
		if(document.or_print_routing.consent_urg_loc1.value==""){
			document.or_print_routing.consent_urg_loc_radio[0].checked=false;
			document.or_print_routing.consent_urg_loc_radio[0].disabled=true;
			document.or_print_routing.consent_urg_loc_radio[1].checked=true;
			document.or_print_routing.consent_urg_stat_queue_dflt.value="2";
		}
		else{
			if(document.or_print_routing.consent_urg_loc_radio[0].checked){
				document.or_print_routing.consent_urg_loc_radio[1].checked=false;
				document.or_print_routing.consent_urg_loc_radio[0].checked=true;
				document.or_print_routing.consent_urg_loc_radio[0].disabled=false;
			}else{
				document.or_print_routing.consent_urg_loc_radio[0].checked=false;
				document.or_print_routing.consent_urg_loc_radio[1].checked=true;
				document.or_print_routing.consent_urg_stat_queue_dflt.value="1";
			}
		}
	}else	{
		document.or_print_routing.consent_urg_loc_radio[1].checked=false;
		document.or_print_routing.consent_urg_loc_radio[1].disabled=true;
		if(document.or_print_routing.consent_urg_loc1.value!=""){
			document.or_print_routing.consent_urg_loc_radio[0].disabled=false;
			document.or_print_routing.consent_urg_loc_radio[0].checked=true;
			document.or_print_routing.consent_urg_stat_queue_dflt.value="2";
		}else{
			document.or_print_routing.consent_urg_loc_radio[0].checked=false;
			document.or_print_routing.consent_urg_loc_radio[0].disabled=true;
		}
    }
}
////////////////
function setrefusalLocationThis5(textObj){
	if(textObj.value  !=""){
		document.or_print_routing.print_rout_ref_loc_radio[0].disabled=false;
   		if(document.or_print_routing.print_rout_ref_loc2.value!=""){
			if(document.or_print_routing.print_rout_ref_loc_radio[1].checked){
				document.or_print_routing.refusal_dest_rout_queue_dflt.value="2";
				document.or_print_routing.print_rout_ref_loc_radio[1].disabled=false;
			}else{
				document.or_print_routing.refusal_dest_rout_queue_dflt.value="1";
			}
		}else{
			document.or_print_routing.print_rout_ref_loc_radio[1].checked=false;
			document.or_print_routing.print_rout_ref_loc_radio[1].disabled=true;
			document.or_print_routing.print_rout_ref_loc_radio[0].checked=true;
		}
	}else {
		if(document.or_print_routing.print_rout_ref_loc2.value!=""){
			document.or_print_routing.print_rout_ref_loc_radio[1].checked=true;
			document.or_print_routing.print_rout_ref_loc_radio[0].checked=false;
			document.or_print_routing.print_rout_ref_loc_radio[0].disabled=true;
			document.or_print_routing.refusal_dest_rout_queue_dflt.value="2";
		}else	{
    		document.or_print_routing.refusal_dest_rout_queue_dflt.value="1";
			document.or_print_routing.print_rout_ref_loc_radio[0].checked=false;
			document.or_print_routing.print_rout_ref_loc_radio[0].disabled=true;
			document.or_print_routing.print_rout_ref_loc_radio[1].disabled=true;
		}
	}
}
///added by Kavitha.K
function setreferralLocationThis5(textObj){
	if(textObj.value  !=""){
		document.or_print_routing.print_rout_referral_loc_radio[0].disabled=false;
   		if(document.or_print_routing.print_rout_referral_loc2.value!=""){
			if(document.or_print_routing.print_rout_referral_loc_radio[1].checked){
				document.or_print_routing.referral_dest_rout_queue_dflt.value="2";
				document.or_print_routing.print_rout_referral_loc_radio[1].disabled=false;
			}else{
				document.or_print_routing.referral_dest_rout_queue_dflt.value="1";
			}
		}else{
			document.or_print_routing.print_rout_referral_loc_radio[1].checked=false;
			document.or_print_routing.print_rout_referral_loc_radio[1].disabled=true;
			document.or_print_routing.print_rout_referral_loc_radio[0].checked=true;
		}
	}else {
		if(document.or_print_routing.print_rout_referral_loc2.value!=""){
			document.or_print_routing.print_rout_referral_loc_radio[1].checked=true;
			document.or_print_routing.print_rout_referral_loc_radio[0].checked=false;
			document.or_print_routing.print_rout_referral_loc_radio[0].disabled=true;
			document.or_print_routing.referral_dest_rout_queue_dflt.value="2";
		}else	{
    		document.or_print_routing.referral_dest_rout_queue_dflt.value="1";
			document.or_print_routing.print_rout_referral_loc_radio[0].checked=false;
			document.or_print_routing.print_rout_referral_loc_radio[0].disabled=true;
			document.or_print_routing.print_rout_referral_loc_radio[1].disabled=true;
		}
	}
}
////////////////
function setLocationThis5(textObj){
	if(textObj.value  !=""){
		document.or_print_routing.print_rout_loc_radio[0].disabled=false;
   		if(document.or_print_routing.print_rout_loc2.value!=""){
			if(document.or_print_routing.print_rout_loc_radio[1].checked){
				document.or_print_routing.consent_routing_queue_dflt.value="2";
				document.or_print_routing.print_rout_loc_radio[1].disabled=false;
			}else{
				document.or_print_routing.consent_routing_queue_dflt.value="1";
			}
		}else{
			document.or_print_routing.print_rout_loc_radio[1].checked=false;
			document.or_print_routing.print_rout_loc_radio[1].disabled=true;
			document.or_print_routing.print_rout_loc_radio[0].checked=true;
		}
	}else {
		if(document.or_print_routing.print_rout_loc2.value!=""){
			document.or_print_routing.print_rout_loc_radio[1].checked=true;
			document.or_print_routing.print_rout_loc_radio[0].checked=false;
			document.or_print_routing.print_rout_loc_radio[0].disabled=true;
			document.or_print_routing.consent_routing_queue_dflt.value="2";
		}else	{
    		document.or_print_routing.consent_routing_queue_dflt.value="1";
			document.or_print_routing.print_rout_loc_radio[0].checked=false;
			document.or_print_routing.print_rout_loc_radio[0].disabled=true;
			document.or_print_routing.print_rout_loc_radio[1].disabled=true;
		}
	}
}
//////////////////////

function setrefusalLocationThis6(textObj){
	if(textObj.value!=""){
		document.or_print_routing.print_rout_ref_loc_radio[1].disabled=false;
		if(document.or_print_routing.print_rout_ref_loc1.value==""){
			document.or_print_routing.print_rout_ref_loc_radio[0].checked=false;
			document.or_print_routing.print_rout_ref_loc_radio[0].disabled=true;
			document.or_print_routing.print_rout_ref_loc_radio[1].checked=true;
		}
		else{
			if(document.or_print_routing.print_rout_ref_loc_radio[0].checked){
				document.or_print_routing.print_rout_ref_loc_radio[1].checked=false;
				document.or_print_routing.print_rout_ref_loc_radio[0].checked=true;
				document.or_print_routing.print_rout_ref_loc_radio[0].disabled=false;
			}else{
				document.or_print_routing.print_rout_ref_loc_radio[0].checked=false;
				document.or_print_routing.print_rout_ref_loc_radio[1].checked=true;
			}
		}
	}else	{
		document.or_print_routing.print_rout_ref_loc_radio[1].checked=false;
		document.or_print_routing.print_rout_ref_loc_radio[1].disabled=true;
		if(document.or_print_routing.print_rout_ref_loc1.value!=""){
			document.or_print_routing.print_rout_ref_loc_radio[0].disabled=false;
			document.or_print_routing.print_rout_ref_loc_radio[0].checked=true;
		}else{
			document.or_print_routing.print_rout_ref_loc_radio[0].checked=false;
			document.or_print_routing.print_rout_ref_loc_radio[0].disabled=true;
		}
	}
}
///added by Kavitha.K
function setreferralLocationThis6(textObj){
	if(textObj.value!=""){
		document.or_print_routing.print_rout_referral_loc_radio[1].disabled=false;
		if(document.or_print_routing.print_rout_referral_loc1.value==""){
			document.or_print_routing.print_rout_referral_loc_radio[0].checked=false;
			document.or_print_routing.print_rout_referral_loc_radio[0].disabled=true;
			document.or_print_routing.print_rout_referral_loc_radio[1].checked=true;
		}
		else{
			if(document.or_print_routing.print_rout_referral_loc_radio[0].checked){
				document.or_print_routing.print_rout_referral_loc_radio[1].checked=false;
				document.or_print_routing.print_rout_referral_loc_radio[0].checked=true;
				document.or_print_routing.print_rout_referral_loc_radio[0].disabled=false;
			}else{
				document.or_print_routing.print_rout_referral_loc_radio[0].checked=false;
				document.or_print_routing.print_rout_referral_loc_radio[1].checked=true;
			}
		}
	}else	{
		document.or_print_routing.print_rout_referral_loc_radio[1].checked=false;
		document.or_print_routing.print_rout_referral_loc_radio[1].disabled=true;
		if(document.or_print_routing.print_rout_referral_loc1.value!=""){
			document.or_print_routing.print_rout_referral_loc_radio[0].disabled=false;
			document.or_print_routing.print_rout_referral_loc_radio[0].checked=true;
		}else{
			document.or_print_routing.print_rout_referral_loc_radio[0].checked=false;
			document.or_print_routing.print_rout_referral_loc_radio[0].disabled=true;
		}
	}
}

function setLocationThis6(textObj){
	if(textObj.value!=""){
		document.or_print_routing.print_rout_loc_radio[1].disabled=false;
		if(document.or_print_routing.print_rout_loc1.value==""){
			document.or_print_routing.print_rout_loc_radio[0].checked=false;
			document.or_print_routing.print_rout_loc_radio[0].disabled=true;
			document.or_print_routing.print_rout_loc_radio[1].checked=true;
		}
		else{
			if(document.or_print_routing.print_rout_loc_radio[0].checked){
				document.or_print_routing.print_rout_loc_radio[1].checked=false;
				document.or_print_routing.print_rout_loc_radio[0].checked=true;
				document.or_print_routing.print_rout_loc_radio[0].disabled=false;
			}else{
				document.or_print_routing.print_rout_loc_radio[0].checked=false;
				document.or_print_routing.print_rout_loc_radio[1].checked=true;
			}
		}
	}else	{
		document.or_print_routing.print_rout_loc_radio[1].checked=false;
		document.or_print_routing.print_rout_loc_radio[1].disabled=true;
		if(document.or_print_routing.print_rout_loc1.value!=""){
			document.or_print_routing.print_rout_loc_radio[0].disabled=false;
			document.or_print_routing.print_rout_loc_radio[0].checked=true;
		}else{
			document.or_print_routing.print_rout_loc_radio[0].checked=false;
			document.or_print_routing.print_rout_loc_radio[0].disabled=true;
		}
	}
}
///////////////////
/////////////////////

function setrefusalLocationThis7(textObj){
	if(textObj.value  !=""){
		document.or_print_routing.print_urg_loc_ref_radio[0].disabled=false;
   		if(document.or_print_routing.print_urg_ref_loc2.value!=""){
			if(document.or_print_routing.print_urg_loc_ref_radio[1].checked){
				document.or_print_routing.refusal_dest_stat_queue_dflt.value="2";
				document.or_print_routing.print_urg_loc_ref_radio[1].disabled=false;
			}else{
				document.or_print_routing.refusal_dest_stat_queue_dflt.value="1";
			}
		}else{
			document.or_print_routing.print_urg_loc_ref_radio[1].checked=false;
			document.or_print_routing.print_urg_loc_ref_radio[1].disabled=true;
			document.or_print_routing.print_urg_loc_ref_radio[0].checked=true;
		}
	}else {
		if(document.or_print_routing.print_urg_ref_loc2.value!=""){
			document.or_print_routing.print_urg_loc_ref_radio[1].checked=true;
			document.or_print_routing.print_urg_loc_ref_radio[0].checked=false;
			document.or_print_routing.print_urg_loc_ref_radio[0].disabled=true;
			document.or_print_routing.refusal_dest_stat_queue_dflt.value="2";
		}else	{
    		document.or_print_routing.refusal_dest_stat_queue_dflt.value="1";
			document.or_print_routing.print_urg_loc_ref_radio[0].checked=false;
			document.or_print_routing.print_urg_loc_ref_radio[0].disabled=true;
			document.or_print_routing.print_urg_loc_ref_radio[1].disabled=true;
		}
	}
}
//////////////////added by Kavitha.K
function setreferralLocationThis7(textObj){
	if(textObj.value  !=""){
		document.or_print_routing.print_urg_loc_referral_radio[0].disabled=false;
   		if(document.or_print_routing.print_urg_referral_loc2.value!=""){
			if(document.or_print_routing.print_urg_loc_referral_radio[1].checked){
				document.or_print_routing.referral_dest_stat_queue_dflt.value="2";
				document.or_print_routing.print_urg_loc_referral_radio[1].disabled=false;
			}else{
				document.or_print_routing.referral_dest_stat_queue_dflt.value="1";
			}
		}else{
			document.or_print_routing.print_urg_loc_referral_radio[1].checked=false;
			document.or_print_routing.print_urg_loc_referral_radio[1].disabled=true;
			document.or_print_routing.print_urg_loc_referral_radio[0].checked=true;
		}
	}else {
		if(document.or_print_routing.print_urg_referral_loc2.value!=""){
			document.or_print_routing.print_urg_loc_referral_radio[1].checked=true;
			document.or_print_routing.print_urg_loc_referral_radio[0].checked=false;
			document.or_print_routing.print_urg_loc_referral_radio[0].disabled=true;
			document.or_print_routing.referral_dest_stat_queue_dflt.value="2";
		}else	{
    		document.or_print_routing.referral_dest_stat_queue_dflt.value="1";
			document.or_print_routing.print_urg_loc_referral_radio[0].checked=false;
			document.or_print_routing.print_urg_loc_referral_radio[0].disabled=true;
			document.or_print_routing.print_urg_loc_referral_radio[1].disabled=true;
		}
	}
}

function setLocationThis7(textObj){
	if(textObj.value  !=""){
		document.or_print_routing.print_urg_loc_radio[0].disabled=false;
   		if(document.or_print_routing.print_urg_loc2.value!=""){
			if(document.or_print_routing.print_urg_loc_radio[1].checked){
				document.or_print_routing.ord_dest_stat_queue_dflt.value="2";
				document.or_print_routing.print_urg_loc_radio[1].disabled=false;
			}else{
				document.or_print_routing.ord_dest_stat_queue_dflt.value="1";
			}
		}else{
			document.or_print_routing.print_urg_loc_radio[1].checked=false;
			document.or_print_routing.print_urg_loc_radio[1].disabled=true;
			document.or_print_routing.print_urg_loc_radio[0].checked=true;
		}
	}else {
		if(document.or_print_routing.print_urg_loc2.value!=""){
			document.or_print_routing.print_urg_loc_radio[1].checked=true;
			document.or_print_routing.print_urg_loc_radio[0].checked=false;
			document.or_print_routing.print_urg_loc_radio[0].disabled=true;
			document.or_print_routing.ord_dest_stat_queue_dflt.value="2";
		}else	{
    		document.or_print_routing.ord_dest_stat_queue_dflt.value="1";
			document.or_print_routing.print_urg_loc_radio[0].checked=false;
			document.or_print_routing.print_urg_loc_radio[0].disabled=true;
			document.or_print_routing.print_urg_loc_radio[1].disabled=true;
		}
	}
}
//////////////////

function setrefusalLocationThis8(textObj){
	if(textObj.value!=""){
		document.or_print_routing.print_urg_loc_ref_radio[1].disabled=false;
		if(document.or_print_routing.print_urg_ref_loc1.value==""){
			document.or_print_routing.print_urg_loc_ref_radio[0].checked=false;
			document.or_print_routing.print_urg_loc_ref_radio[0].disabled=true;
			document.or_print_routing.print_urg_loc_ref_radio[1].checked=true;
		}
		else{
			if(document.or_print_routing.print_urg_loc_ref_radio[0].checked){
				document.or_print_routing.print_urg_loc_ref_radio[1].checked=false;
				document.or_print_routing.print_urg_loc_ref_radio[0].checked=true;
				document.or_print_routing.print_urg_loc_ref_radio[0].disabled=false;
			}else{
				document.or_print_routing.print_urg_loc_ref_radio[0].checked=false;
				document.or_print_routing.print_urg_loc_ref_radio[1].checked=true;
			}
		}
	}else	{
		document.or_print_routing.print_urg_loc_ref_radio[1].checked=false;
		document.or_print_routing.print_urg_loc_ref_radio[1].disabled=true;
		if(document.or_print_routing.print_urg_ref_loc1.value!=""){
			document.or_print_routing.print_urg_loc_ref_radio[0].disabled=false;
			document.or_print_routing.print_urg_loc_ref_radio[0].checked=true;
		}else{
			document.or_print_routing.print_urg_loc_ref_radio[0].checked=false;
			document.or_print_routing.print_rout_ref_loc_radio[0].disabled=true;
		}
	}
}
////////added by Kavitha.K
function setreferralLocationThis8(textObj){
	if(textObj.value!=""){
		document.or_print_routing.print_urg_loc_referral_radio[1].disabled=false;
		if(document.or_print_routing.print_urg_referral_loc1.value==""){
			document.or_print_routing.print_urg_loc_referral_radio[0].checked=false;
			document.or_print_routing.print_urg_loc_referral_radio[0].disabled=true;
			document.or_print_routing.print_urg_loc_referral_radio[1].checked=true;
		}
		else{
			if(document.or_print_routing.print_urg_loc_referral_radio[0].checked){
				document.or_print_routing.print_urg_loc_referral_radio[1].checked=false;
				document.or_print_routing.print_urg_loc_referral_radio[0].checked=true;
				document.or_print_routing.print_urg_loc_referral_radio[0].disabled=false;
			}else{
				document.or_print_routing.print_urg_loc_referral_radio[0].checked=false;
				document.or_print_routing.print_urg_loc_referral_radio[1].checked=true;
			}
		}
	}else	{
		document.or_print_routing.print_urg_loc_referral_radio[1].checked=false;
		document.or_print_routing.print_urg_loc_referral_radio[1].disabled=true;
		if(document.or_print_routing.print_urg_referral_loc1.value!=""){
			document.or_print_routing.print_urg_loc_referral_radio[0].disabled=false;
			document.or_print_routing.print_urg_loc_referral_radio[0].checked=true;
		}else{
			document.or_print_routing.print_urg_loc_referral_radio[0].checked=false;
			document.or_print_routing.print_rout_referral_loc_radio[0].disabled=true;
		}
	}
}

function setLocationThis8(textObj){
	if(textObj.value!=""){
		document.or_print_routing.print_urg_loc_radio[1].disabled=false;
		if(document.or_print_routing.print_urg_loc1.value==""){
			document.or_print_routing.print_urg_loc_radio[0].checked=false;
			document.or_print_routing.print_urg_loc_radio[0].disabled=true;
			document.or_print_routing.print_urg_loc_radio[1].checked=true;
		}
		else{
			if(document.or_print_routing.print_urg_loc_radio[0].checked){
				document.or_print_routing.print_urg_loc_radio[1].checked=false;
				document.or_print_routing.print_urg_loc_radio[0].checked=true;
				document.or_print_routing.print_urg_loc_radio[0].disabled=false;
			}else{
				document.or_print_routing.print_urg_loc_radio[0].checked=false;
				document.or_print_routing.print_urg_loc_radio[1].checked=true;
			}
		}
	}else	{
		document.or_print_routing.print_urg_loc_radio[1].checked=false;
		document.or_print_routing.print_urg_loc_radio[1].disabled=true;
		if(document.or_print_routing.print_urg_loc1.value!=""){
			document.or_print_routing.print_urg_loc_radio[0].disabled=false;
			document.or_print_routing.print_urg_loc_radio[0].checked=true;
		}else{
			document.or_print_routing.print_urg_loc_radio[0].checked=false;
			//document.or_print_routing.consent_rout_loc_radio[0].disabled=true;
		}
	}
}
/////////////////////
function setLocationThis9(textObj){
	if(textObj.value  !=""){
		document.or_print_routing.print_report_dept_loc_radio[0].disabled=false;
   		if(document.or_print_routing.print_dept_loc2.value!=""){
			if(document.or_print_routing.print_report_dept_loc_radio[1].checked){
				document.or_print_routing.res_dept_routing_queue_dflt.value="2";
				document.or_print_routing.print_report_dept_loc_radio[1].disabled=false;
			}else{
				document.or_print_routing.res_dept_routing_queue_dflt.value="1";
			}
		}else{
			document.or_print_routing.print_report_dept_loc_radio[1].checked=false;
			document.or_print_routing.print_report_dept_loc_radio[1].disabled=true;
			document.or_print_routing.print_report_dept_loc_radio[0].checked=true;
		}
	}else {
		if(document.or_print_routing.print_dept_loc2.value!=""){
			document.or_print_routing.print_report_dept_loc_radio[1].checked=true;
			document.or_print_routing.print_report_dept_loc_radio[0].checked=false;
			document.or_print_routing.print_report_dept_loc_radio[0].disabled=true;
			document.or_print_routing.res_dept_routing_queue_dflt.value="2";
		}else	{
        	document.or_print_routing.res_dept_routing_queue_dflt.value="1";
			document.or_print_routing.print_report_dept_loc_radio[0].checked=false;
			document.or_print_routing.print_report_dept_loc_radio[0].disabled=true;
			document.or_print_routing.print_report_dept_loc_radio[1].disabled=true;
		}
	}
}
function setLocationThis10(textObj){
	if(textObj.value!=""){
		document.or_print_routing.print_report_dept_loc_radio[1].disabled=false;
		if(document.or_print_routing.print_dept_loc1.value==""){
			document.or_print_routing.print_report_dept_loc_radio[0].checked=false;
			document.or_print_routing.print_report_dept_loc_radio[0].disabled=true;
			document.or_print_routing.print_report_dept_loc_radio[1].checked=true;
		}
		else{
			if(document.or_print_routing.print_report_dept_loc_radio[0].checked){
				document.or_print_routing.print_report_dept_loc_radio[1].checked=false;
				document.or_print_routing.print_report_dept_loc_radio[0].checked=true;
				document.or_print_routing.print_report_dept_loc_radio[0].disabled=false;
			}else{
				document.or_print_routing.print_report_dept_loc_radio[0].checked=false;
				document.or_print_routing.print_report_dept_loc_radio[1].checked=true;
			}
		}
	}else	{
		document.or_print_routing.print_report_dept_loc_radio[1].checked=false;
		document.or_print_routing.print_report_dept_loc_radio[1].disabled=true;
		if(document.or_print_routing.print_dept_loc1.value!=""){
			document.or_print_routing.print_report_dept_loc_radio[0].disabled=false;
			document.or_print_routing.print_report_dept_loc_radio[0].checked=true;
		}else{
			document.or_print_routing.print_report_dept_loc_radio[0].checked=false;
			document.or_print_routing.print_report_dept_loc_radio[0].disabled=true;
		}
	}
}
//////////////////////
function setLocationThis11(textObj){
	if(textObj.value  !=""){
		document.or_print_routing.print_report_urg_dept_loc_radio[0].disabled=false;
   		if(document.or_print_routing.print_urg_dept_loc2.value!=""){
			if(document.or_print_routing.print_report_urg_dept_loc_radio[1].checked){
				document.or_print_routing.consent_routing_queue_dflt.value="2";
				document.or_print_routing.print_report_urg_dept_loc_radio[1].disabled=false;
			}else{
				document.or_print_routing.consent_routing_queue_dflt.value="1";
			}
		}else{
			document.or_print_routing.print_report_urg_dept_loc_radio[1].checked=false;
			document.or_print_routing.print_report_urg_dept_loc_radio[1].disabled=true;
			document.or_print_routing.print_report_urg_dept_loc_radio[0].checked=true;
			document.or_print_routing.print_report_urg_dept_loc_radio[0].disabled=false;
		}
	}else {
		if(document.or_print_routing.print_urg_dept_loc2.value!=""){
			document.or_print_routing.print_report_urg_dept_loc_radio[1].checked=true;
			document.or_print_routing.print_report_urg_dept_loc_radio[0].checked=false;
			document.or_print_routing.print_report_urg_dept_loc_radio[0].disabled=true;
			document.or_print_routing.consent_routing_queue_dflt.value="2";
		}else	{
    		document.or_print_routing.consent_routing_queue_dflt.value="1";
			document.or_print_routing.print_report_urg_dept_loc_radio[0].checked=false;
			document.or_print_routing.print_report_urg_dept_loc_radio[0].disabled=true;
			document.or_print_routing.print_report_urg_dept_loc_radio[1].disabled=true;
		}
	}
}
function setLocationThis12(textObj){
	if(textObj.value!=""){
		document.or_print_routing.print_report_urg_dept_loc_radio[1].disabled=false;
		if(document.or_print_routing.print_urg_dept_loc1.value==""){
			document.or_print_routing.print_report_urg_dept_loc_radio[0].checked=false;
			document.or_print_routing.print_report_urg_dept_loc_radio[0].disabled=true;
			document.or_print_routing.print_report_urg_dept_loc_radio[1].checked=true;
		}
		else{
			if(document.or_print_routing.print_report_urg_dept_loc_radio[0].checked){
				document.or_print_routing.print_report_urg_dept_loc_radio[1].checked=false;
				document.or_print_routing.print_report_urg_dept_loc_radio[0].checked=true;
				document.or_print_routing.print_report_urg_dept_loc_radio[0].disabled=false;
			}else{
				document.or_print_routing.print_report_urg_dept_loc_radio[0].checked=false;
				document.or_print_routing.print_report_urg_dept_loc_radio[1].checked=true;
			}
		}
	}else	{
		document.or_print_routing.print_report_urg_dept_loc_radio[1].checked=false;
		document.or_print_routing.print_report_urg_dept_loc_radio[1].disabled=true;
		if(document.or_print_routing.print_urg_dept_loc1.value!=""){
			document.or_print_routing.print_report_urg_dept_loc_radio[0].disabled=false;
			document.or_print_routing.print_report_urg_dept_loc_radio[0].checked=true;
		}else{
			document.or_print_routing.print_report_urg_dept_loc_radio[0].checked=false;
			document.or_print_routing.print_report_urg_dept_loc_radio[0].disabled=true;
		}
    }
}
//////////////////////
function setSource(checkObj) {
	if(checkObj.checked){
		document.or_print_routing.printatsource1.value='Y';
	}
	else{
		document.or_print_routing.printatsource1.value='N';
	}
}
///////////////////////////////////////
function setConsentSource(check1Obj1) {
	if(check1Obj1.checked){
		document.or_print_routing.printatconsentsource1.value='Y';
	}
	else{
		document.or_print_routing.printatconsentsource1.value='N';
	}
}

//////////////////////////////////////
function setRefusalSource(check2Obj2) {
	if(check2Obj2.checked){
		document.or_print_routing.printatrefusalsource1.value='Y';
	}
	else{
		document.or_print_routing.printatrefusalsource1.value='N';
	}
}
///////////////////////////////////////added by Kavitha.K
function setReferralSource(check2Obj2) {
	if(check2Obj2.checked){
		document.or_print_routing.printatreferralsource1.value='Y';
	}
	else{
		document.or_print_routing.printatreferralsource1.value='N';
	}
}
/////////////////////////////////////////
function fillLocation1(itemObj){
	if(itemObj.value == ""||itemObj.value == "X"||itemObj.value=="P" ) {
		if(itemObj.name=="otherloc"){
			f_query_add_mod.document.getElementById("location_id").innerHTML="&nbsp;";
			//f_query_add_mod.document.getElementById("locationname1").innerHTML="&nbsp;";
		}
		else{
			f_query_add_mod.document.getElementById("deafult_id").innerHTML="&nbsp;";
//			f_query_add_mod.document.getElementById("locationname2").innerHTML="&nbsp;";
		}
		return ;
	}
	if(itemObj.name=="otherloc"){
	//	f_query_add_mod.document.getElementById("locationname1").innerHTML="Location Name";
		f_query_add_mod.document.getElementById("location_id").innerHTML=""+getLabel("Common.LocationName.label","Common")+"<select name='print_res_at_othloc' id='print_res_at_othloc'> <option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</option> </select><img src='../../eCommon/images/mandatory.gif' align=center></img>";
	}
	else if(itemObj.name=="otherlocdis"){
	//	f_query_add_mod.document.getElementById("locationname2").innerHTML="Location Name";
		f_query_add_mod.document.getElementById("deafult_id").innerHTML=""+getLabel("Common.LocationName.label","Common")+"<select name='print_des_at_othloc' id='print_des_at_othloc'><option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</option></select><img src='../../eCommon/images/mandatory.gif' align=center></img>";
	}
	var bean_id = f_query_add_mod.document.or_print_routing.bean_id.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += itemObj.name+"=\""+ itemObj.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(itemObj.name=="otherloc"){
		xmlHttp.open( "POST", "OrderPrintRoutingFillLocation.jsp?bean_id=Or_or_print_routing&itemName ="+itemObj.name,false ) ;}
	else {
		xmlHttp.open( "POST", "OrderPrintRoutingFillLocation1.jsp?bean_id=Or_or_print_routing&itemName ="+itemObj.name,false ) ;
	}
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}
///////////////////Added by Siva Kumar 20-8-2003////////////////////////////////////////////////////
function populateOrderTypes(ord_cat){

    if( ord_cat.value == "" ) {
		clearList("document")
	}
	//IN042962 - Start
	if(ord_cat.value == "PH")
		document.or_print_routing.print_option.value='C';
	else if (document.or_print_routing.order_category.value != "PH") //Condition added for IN049174
		document.or_print_routing.print_option.value='S';	
	//IN042962 - End	
	var bean_id = document.or_print_routing.bean_id.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += ord_cat.name+"=\""+ ord_cat.value +"\" " ;
	xmlStr += document.or_print_routing.facility_id.name+"=\""+document.or_print_routing.facility_id.value+"\" ";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var validate = ord_cat.name;

	xmlHttp.open( "POST", "OrderPrintRoutingValidate.jsp?bean_id=" + bean_id + "&validate="+validate, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText ) ;
}
function clearList( docObj ) {
	var len = eval(docObj+".or_print_routing.order_type_code.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".or_print_routing.order_type_code.remove(\"atc_class_l2_code\")") ;
	}
	var tp = " --- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".or_print_routing.order_type_code.add(opt)") ;
}
function addOrderTypeList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.or_print_routing.order_type_code.add(element);
}
function clearPerformingLocnList( docObj ) {
	var len = eval(docObj+".or_print_routing.performing_location_code.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".or_print_routing.performing_location_code.remove(\"atc_class_l2_code\")") ;
	}
	var tp = " --- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".or_print_routing.performing_location_code.add(opt)") ;
}
function addPerformingLocnList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.or_print_routing.performing_location_code.add(element);
}
///////////////////////////////////////////////////////////////////////////////
function fillTypeLocation(itemObj){
    //alert("here in fillTypeLocation :" + itemObj.name);
	var selectedType = itemObj.value;
	var option1 = "<option value='' ";
    if (itemObj.value=='') option1 = option1 + "selected";
    option1 = option1 + ">---"+getLabel("Common.defaultSelect.label","Common")+"---</option>";
	var option2 = "<option value='C' ";
    if (itemObj.value=='C') option2 = option2 + "selected";
    option2 = option2 + ">"+getLabel("Common.clinic.label","Common")+"</option>";
	var option3 = "<option value='N' ";
    if (itemObj.value=='N') option3 = option3 + "selected";
    option3 = option3 + ">"+getLabel("Common.nursingUnit.label","Common")+"</option>";
    var html = option1 + option2 + option3;
    if(itemObj.name=="loctype"){
        parent.f_query_add_mod.document.getElementById("location_id").innerHTML="&nbsp;";
		//parent.f_query_add_mod.document.getElementById("location_type").innerHTML="&nbsp;";
		//if (parent.f_query_add_mod.document.getElementById("location_val") != null) {
		//	parent.f_query_add_mod.document.getElementById("location_val").innerHTML="&nbsp;";
		//}
        //parent.f_query_add_mod.document.getElementById("location_id").innerHTML="&nbsp;Location&nbsp;&nbsp;<select name='loctype' id='loctype' onchange='fillTypeLocation(this);'><option value=''>---Select---</option><option value='C'>Clinic</option><option value='N'>Nursing Unit</option></select>&nbsp;<select name='print_res_at_othloc' id='print_res_at_othloc'> <option value=''>&nbsp;&nbsp;&nbsp;---Select---&nbsp;&nbsp;&nbsp;</option> </select><img src='../../eCommon/images/mandatory.gif'></img>";
        parent.f_query_add_mod.document.getElementById("location_id").innerHTML=""+getLabel("Common.Location.label","Common")+"&nbsp;<select name='loctype' id='loctype' onChange='fillTypeLocation(this);'>" + html + "</select><select name='print_res_at_othloc' id='print_res_at_othloc'> <option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</option> </select><img src='../../eCommon/images/mandatory.gif' align=center></img>";
	}
	else if(itemObj.name=="loctype1"){
		parent.f_query_add_mod.document.getElementById("deafult_id").innerHTML="&nbsp;";
		//parent.f_query_add_mod.document.getElementById("default_type").innerHTML="&nbsp;";
		//if (parent.f_query_add_mod.document.getElementById("default_val") != null) {
		//	parent.f_query_add_mod.document.getElementById("default_val").innerHTML="&nbsp;";
		//}
		parent.f_query_add_mod.document.getElementById("deafult_id").innerHTML=""+getLabel("Common.Location.label","Common")+"<select name='loctype1' id='loctype1' onChange='fillTypeLocation(this);'>" + html + "</select><select name='print_des_at_othloc' id='print_des_at_othloc'><option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</option></select><img src='../../eCommon/images/mandatory.gif' align=center></img>";
	}
	var bean_id = document.or_print_routing.bean_id.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	if(itemObj.name=="loctype")
	    xmlStr += "otherloc=\""+ "S" +"\" " ;
	else
        xmlStr += "otherlocdis=\""+ "S" +"\" " ;
	//xmlStr += itemObj.name+"=\""+ itemObj.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(itemObj.name=="loctype"){
		xmlHttp.open( "POST", "OrderPrintRoutingFillLocation.jsp?bean_id=Or_or_print_routing&itemName =otherloc&locType="+selectedType,false ) ;
    }
	else
	{
		xmlHttp.open( "POST", "OrderPrintRoutingFillLocationBottom.jsp?bean_id=Or_or_print_routing&itemName =otherlocdis&locType="+selectedType,false ) ;
	}
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval( responseText ) ;
}

async function showwindow(){
	var dialogHeight	= "8" ;
	//var dialogHeight	= "24" ;
	var dialogWidth		= "700px" ;
	var dialogTop		= "270" ;
	var dialogLeft		= "400px" ;
	var center			= "0" ;
	var status			= "no";
	var retVal	= ""
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
	var arguments		= "" ;
	var mode = document.forms[0].mode.value;
	if(mode =="1")
	{
		
		retVal = await window.showModalDialog("../../eOR/jsp/OrderPrintRoutingLocationDtls.jsp?print_dept_loc111="+encodeURIComponent(document.forms[0].print_dept_loc111.value)+"&print_dept_loc211="+encodeURIComponent(document.forms[0].print_dept_loc211.value)+"&print_report_dept_loc_radio11="+document.forms[0].print_report_dept_loc_radio11.value+"&mode="+document.forms[0].mode.value+"&print_urg_dept_loc111="+encodeURIComponent(document.forms[0].print_urg_dept_loc111.value)+"&print_urg_dept_loc211="+encodeURIComponent(document.forms[0].print_urg_dept_loc211.value)+"&print_report_urg_dept_loc_radio11="+document.forms[0].print_report_urg_dept_loc_radio11.value,arguments, features );
	}
	else
	{
		retVal = await window.showModalDialog("../../eOR/jsp/OrderPrintRoutingLocationDtls.jsp?hidden1="+encodeURIComponent(document.forms[0].hidden1.value)+"&hidden2="+encodeURIComponent(document.forms[0].hidden2.value)+"&hidden3="+document.forms[0].hidden3.value+"&mode="+document.forms[0].mode.value+"&hidden4="+encodeURIComponent(document.forms[0].hidden4.value)+"&hidden5="+encodeURIComponent(document.forms[0].hidden5.value)+"&hidden6="+document.forms[0].hidden6.value,arguments, features );
	}

	var i = 0;
	var string = retVal.split("~")

			document.forms[0].print_dept_loc111.value = string[0]

			document.forms[0].print_dept_loc211.value = string[1]
			document.forms[0].print_report_dept_loc_radio11.value = string[2]
			document.forms[0].print_urg_dept_loc111.value = string[3]
			document.forms[0].print_urg_dept_loc211.value = string[4]
			document.forms[0].print_report_urg_dept_loc_radio11.value = string[5]

            document.forms[0].hidden1.value = string[0]
            document.forms[0].hidden2.value = string[1]
			document.forms[0].hidden3.value = string[2]
			document.forms[0].hidden4.value = string[3]
			document.forms[0].hidden5.value = string[4]
			document.forms[0].hidden6.value = string[5]
}

