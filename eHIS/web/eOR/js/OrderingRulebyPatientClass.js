/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var qry_string = "";

function create() {	
	f_query_add_mod.location.href = "../../eOR/jsp/OrderingRulebyPatientClassAddModify.jsp?mode="+MODE_INSERT+"&function_id="+function_id ;
}

function query() {
	f_query_add_mod.location.href='../../eOR/jsp/OrderingRulebyPatientClassQueryCriteria.jsp?function_id='+function_id ;
}


function populatePatientClass(ord_cat){
	var order_category = document.OrderingRuleby_PatientClass.order_category.value ;
	if(order_category  == ""){
		parent.ordering_rule_bottom.location.href = "../../eCommon/html/blank.html";
	}else{
		parent.ordering_rule_bottom.location.href = "../../eOR/jsp/OrderingRulebyPatientClassAddModifyBottom.jsp?order_category="+order_category+"&mode=1&function_id="+parent.function_id ;
	}
}


function apply(){
	
	//alert("apply 36")
	
	if (!checkIsValidForProceed()) {
		
		//alert (" Inside OrderingRuleByPatientClass 38 : "+message);
		
		message  = getMessage("NOT_VALID","OR");	
		
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	//alert (" Inside OrderingRuleByPatientClass 45 : "+message);
	var formObj = f_query_add_mod.ordering_rule_top.document.OrderingRuleby_PatientClass;
	var formObj1 = f_query_add_mod.ordering_rule_bottom.document.OrderingRuleby_PatientClass1;
	var fields = new Array ( formObj.order_category );
	catagory_type = f_query_add_mod.ordering_rule_top.OrderingRuleby_PatientClass.order_category.value;

	if(catagory_type=="")
	{
		var msg = getMessage("ATLEAST_ONE_CATEGORY","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}
	else
	{
	var names = new Array (getLabel("Common.OrderCategory.label","Common") );
	if(f_query_add_mod.ordering_rule_top.checkFields( fields, names, messageFrame)) {		
		for(i=0; i<formObj1.totalLength.value; i++){
			if(eval("formObj1.time_based_rule"+i).value != " "){
				if (eval("formObj1.expiry_rule"+i).value == ""){
					var msg1 =  getMessage("EXPIRY_PERIOD","OR");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg1;
					//alert("Message67"+msg1)
					return false;
				}
			}

		}

		for(i=0; i<formObj1.totalLength.value; i++){
			if (eval("formObj1.expiry_rule"+i).value != ""){
				if(eval("formObj1.time_based_rule"+i).value == " "){
					var msg2 = getMessage("TIME_BASED_RULE","OR");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg2;
					//alert ("message2 79"+msg2)
					return false;					
				}
			}

		}
		for(i=0; i<formObj1.totalLength.value; i++){
			if (eval("formObj1.future_order"+i).value != ""){
				if(eval("formObj1.futureorderduration"+i).value == ""){
					var msg2 = getMessage("FUTURE_ORDER_DURATION","OR");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg2;
					//alert("Message90"+msg2)
					return false;					
				}
			}

		}
		for(i=0; i<formObj1.totalLength.value; i++){
			if (eval("formObj1.futureorderduration"+i).value != ""){
				if(eval("formObj1.future_order"+i).value == ""){
					var msg2 = getMessage("FUTURE_ORDER_DURATION","OR");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg2;
					//alert("Message101"+msg2)
					return false;					
				}
			}

		}

		var totalChk = formObj1.totalLength.value
		var checkedVal = "";
		var checkedVal2 = "";
		var finalPreselect  = "";
		var finalTimeBase  = "";
		var finalExpiry_rule = "";
		var finalPat_class = "";
		var finalfutureorder="";
		var finalfutureorderduration="";
		var finalfloortostartday="";

		for(i=0; i<totalChk; i++){
			finalPat_class += eval("formObj1.pat_class"+i).value+"~"

			checkedVal = "N"
			if(eval("formObj1.preselect_pr_type"+i).checked == true) {
				checkedVal = "Y"
			}
			finalPreselect  += checkedVal+"~"
			
			var tempTimeBase;
			tempTimeBase = eval("formObj1.time_based_rule"+i).value;
			if(tempTimeBase == "")
				tempTimeBase = " "
			finalTimeBase += tempTimeBase +"~"

			var tempexpRule;
			tempexpRule = eval("formObj1.expiry_rule"+i).value;
			if(tempexpRule == "")
				tempexpRule = " "
			finalExpiry_rule += tempexpRule +"~"
			var tempfutureorder;
			tempfutureorder=eval("formObj1.future_order"+i).value;
			if(tempfutureorder == "")
				tempfutureorder = " "
			finalfutureorder += tempfutureorder+"~"
			var tempfutureorderduration;
			tempfutureorderduration=eval("formObj1.futureorderduration"+i).value;
			if(tempfutureorderduration == "")
				tempfutureorderduration = " "
			finalfutureorderduration += tempfutureorderduration+"~"
			checkedVal2 = "N"
			if(eval("formObj1.floor_to_start_day_yn"+i).checked == true) {
				checkedVal2 = "Y"
			}
			finalfloortostartday  += checkedVal2+"~"
		}

		if(finalPreselect != ""){
			finalPreselect=finalPreselect.substring(0,finalPreselect.length-1);
		}
		if(finalTimeBase != ""){
			finalTimeBase=finalTimeBase.substring(0,finalTimeBase.length-1);
		}
		if(finalExpiry_rule != ""){
			finalExpiry_rule=finalExpiry_rule.substring(0,finalExpiry_rule.length-1);
		}
		if(finalPat_class != ""){
			finalPat_class=finalPat_class.substring(0,finalPat_class.length-1);
		}
		if(finalfutureorder != ""){
			finalfutureorder=finalfutureorder.substring(0,finalfutureorder.length-1);
		}
		if(finalfutureorderduration != ""){
			finalfutureorderduration=finalfutureorderduration.substring(0,finalfutureorderduration.length-1);
		}
		if(finalfloortostartday != ""){
			finalfloortostartday=finalfloortostartday.substring(0,finalfloortostartday.length-1);
		}
			
		qry_string = formObj.order_category.value;
		formObj1.order_category.value = formObj.order_category.value
		formObj1.patientClass.value = finalPat_class ;
		formObj1.preselect_ord_type.value = finalPreselect
		formObj1.time_based_rule.value = finalTimeBase
		formObj1.expiry_rule.value = finalExpiry_rule
		formObj1.future_order.value = finalfutureorder
		formObj1.futureorderduration.value = finalfutureorderduration
		formObj1.floor_to_start_day_yn.value = finalfloortostartday
		
			//alert("formObj1.order_category.value"+formObj1.order_category.value);
			//alert("formObj1.patientClass.value"+formObj1.patientClass.value);
			//alert("formObj1.preselect_ord_type.value"+formObj1.preselect_ord_type.value);
			//alert("formObj1.time_based_rule.value"+formObj1.time_based_rule.value);
			//alert("formObj1.expiry_rule.value"+formObj1.expiry_rule.value);
			//alert("finalfloortostartday"+finalfloortostartday);
		//alert("formObj1.floor_to_start_day_yn.value"+formObj1.floor_to_start_day_yn.value);

		eval(formApply( f_query_add_mod.ordering_rule_bottom.document.OrderingRuleby_PatientClass1,OR_CONTROLLER));
		//var formObj = f_query_add_mod.ordering_rule_top.document.OrderingRuleby_PatientClass;
		//var formObj1 = f_query_add_mod.ordering_rule_bottom.document.OrderingRuleby_PatientClass1;
		
		//alert(OR_CONTROLLER);
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message_global;
		//alert("msg200"+message);
		if( result ) {
			onSuccess();
		}
	}
	}
}



function reset(){
	
	var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if ( (url.indexOf("queryresult.jsp")!=-1) ||  (url.indexOf("blank")!=-1) )
		 return ;

	if(f_query_add_mod.ordering_rule_top){
		if(f_query_add_mod.ordering_rule_top.document.forms[0].name = "OrderingRuleby_PatientClass" ){
		 f_query_add_mod.ordering_rule_top.document.OrderingRuleby_PatientClass.reset();
		 f_query_add_mod.ordering_rule_bottom.location.href = "../../eCommon/html/blank.html";
//		 f_query_add_mod.ordering_rule_bottom.document.OrderingRuleby_PatientClass1.reset();
		}
	}else{
		f_query_add_mod.document.forms[0].reset();
	}

}


function onSuccess() {
	var mode = f_query_add_mod.ordering_rule_bottom.document.OrderingRuleby_PatientClass1.mode.value;
	if( mode == "1" ) {
		formReset();
//		f_query_add_mod.location.href = "../../eOR/jsp/OrderingRulebyPatientClassAddModify.jsp?mode="+MODE_INSERT; 
		f_query_add_mod.ordering_rule_bottom.location.href = "../../eOR/jsp/OrderingRulebyPatientClassAddModifyBottom.jsp?order_category="+qry_string+"&mode=2";
	}
	if(mode == "2"){
		f_query_add_mod.ordering_rule_bottom.location.href = "../../eOR/jsp/OrderingRulebyPatientClassAddModifyBottom.jsp?order_category="+qry_string+"&mode=2";
	}

}


function formReset () {
    formObj = f_query_add_mod.ordering_rule_top.document.OrderingRuleby_PatientClass;
}

function assignResult(_result, _message, _flag){
	//alert("assignResult");
	
	//alert (_result+_flag+" Inside OrderingRuleByPatientClass 245 : "+_message);
	
	result_apply = _result ;
	message_global  = _message ;
	flag_apply = _flag ;
}


//onKeyPress - 
function OrAllowPositiveNumber() {
   var key = window.event.keyCode;
   if( ! ( ( key>48 ) && ( key<58 ) ) ) {
       return false;
   }
}


//onBlur - 
function OrCheckPositiveNumber(obj) {
   var sequence = "123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;
   
   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			//alert(getMessage("ONLY_POSTIVE_INTEGERS","OR"));
			return false;
		}
   }
}

function ORChkPositiveNumber(obj,index) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {	
		var selectedIndex = eval('document.OrderingRuleby_PatientClass1.time_based_rule'+index+'.selectedIndex');
		if(selectedIndex == 0)
		eval(document.getElementById('time_based_'+index)).innerHTML = "<img src='../../eCommon/images/mandatory.gif'>";
    }
    else {
        if ( obj.value.length > 0 ) {

            //alert(getMessage("INVALID_POSITIVE_NUMBER", "Common"));
            obj.select();
            obj.focus();
        }
		else{
		   eval(document.getElementById('time_based_'+index)).innerHTML = '&nbsp;&nbsp;&nbsp;';
		   //eval('document.OrderingRuleby_PatientClass1.time_based_rule'+index).value = '';
		}
       // else if ( obj.value.length == 0 )
           // obj.value = 0;
    }
}
function onRuleChange(index)
{
	var selectedIndex = eval('document.OrderingRuleby_PatientClass1.time_based_rule'+index+'.selectedIndex');
	if(selectedIndex > 0)
	{	
		eval(document.getElementById('exp_rule_'+index)).innerHTML = "<img src='../../eCommon/images/mandatory.gif'>";

	}
	else 
	{	
		eval(document.getElementById("exp_rule_"+index)).innerHTML = '&nbsp;&nbsp;&nbsp;';		
		eval(document.getElementById("expiry_rule"+index)).value = '';
	}
	eval(document.getElementById('time_based_'+index)).innerHTML = '&nbsp;&nbsp;&nbsp;';
}
function onRuleChanges(index)
{
	var selectedIndex = eval('document.OrderingRuleby_PatientClass1.future_order'+index);
	if((selectedIndex.value==null)||(selectedIndex.value==""))
	{	
		var selVal=eval('document.OrderingRuleby_PatientClass1.futureorderduration'+index);		
			if(selVal.selectedIndex==0)
			{
				eval('document.getElementById("futureduration")'+index).innerHTML = '&nbsp;&nbsp;&nbsp;';
			}
			else
			{
				eval('document.getElementById("futureduration")'+index).innerHTML = "<img src='../../eCommon/images/mandatory.gif'>";
			}
		
	}else
	{
		if((selectedIndex.value>0)||(selectedIndex.value==0)) 
		{
			//alert("*1");
			var selVal=eval('document.OrderingRuleby_PatientClass1.futureorderduration'+index);
			if(selVal.selectedIndex==0)
			{
				//alert("*2");
					eval(document.getElementById('futureduration'+index)).innerHTML = "<img src='../../eCommon/images/mandatory.gif'>";
			}
		}
		else 
		{	
			eval('document.getElementById("futureduration")'+index).innerHTML = '&nbsp;&nbsp;&nbsp;';
			eval('document.OrderingRuleby_PatientClass1.futureorderduration'+index).value = '';
		}
	}
}

function chkFutureOrder(obj,index)
{
	var tempVal = eval('document.OrderingRuleby_PatientClass1.future_order'+index);
	if(obj.selectedIndex>0)
	{
		eval(document.getElementById('futureduration'+index)).innerHTML = "<img src='../../eCommon/images/mandatory.gif'>";
	}
	else if(obj.selectedIndex == 0 && tempVal.value != "")
	{			
		eval('document.getElementById("futureduration")'+index).innerHTML = "<img src='../../eCommon/images/mandatory.gif'>";			
	}
	else if(obj.selectedIndex == 0 && tempVal.value == "")
	{
		eval('document.getElementById("futureduration")'+index).innerHTML = '&nbsp;&nbsp;&nbsp;';
	}
}

/*****************************************************************************/
function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}



/*****************************************************************************/

