/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
---------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------

15/08/2020	IN071361	Nijitha S	15/08/2020	Ramesh G	AAKH-CRF-0116
29/01/2021	13628		Nijitha S	29/01/2021	Nijitha S	ML-MMOH-SCF-1720
---------------------------------------------------------------------------------------------------------------
*/ 
// Global Variables
var resultGlobal = false;

/*
Function called on click of Create button
*/
function create()
{  
	f_query_add_mod.location.href = "../../eOR/jsp/OrderingRuleByPractitionerAddModify.jsp?mode="+MODE_INSERT+"&function_id="+function_id ;
}

/*
Function called on click of Apply button
*/
function apply() 
{
	//alert("apply 34")
	var message;
	if (! checkIsValidForProceed() )
    {
		//alert("message 38")
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	// Getting the selected pract type
	var pract_type = f_query_add_mod.dept_only_Catalog_appl_header.document.forms[0].pract_type.value;

	if(pract_type=="")
	{
		var msg = getMessage("ATLEAST_ONE_PRACTITIONER_TYPE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}
	else
	{	  
		var tot_count= f_query_add_mod.dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle.tot_count.value;
		var pract_timebased_appli_yn= f_query_add_mod.dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle.tot_count.value;//13628
		for(var i=0;i<tot_count;i++)
		{
			if(eval("f_query_add_mod.dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle.dept_only"+i).checked)
				eval("f_query_add_mod.dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle.dept_only"+i).value="Y";
			/*Modified by Uma on 9/27/2009 for PMG - CRF -0641 if(eval("f_query_add_mod.dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle.force_auth"+i).checked);
			eval("f_query_add_mod.dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle.force_auth"+i).value="Y";
			Ends Here*/
			if(eval("f_query_add_mod.dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle.force_cosign"+i).checked)
				eval("f_query_add_mod.dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle.force_cosign"+i).value="Y";
		 
			//IN071361 Starts
			if(pract_timebased_appli_yn=="Y"){//13628
				if(eval("f_query_add_mod.dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle.time_based_rule"+i).value != " "){
						if (eval("f_query_add_mod.dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle.expiry_rule"+i).value == ""){
							var msg1 =  getMessage("EXPIRY_PERIOD","OR");
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg1;
							return false;
						}
					}

				if (eval("f_query_add_mod.dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle.expiry_rule"+i).value != ""){
						if(eval("f_query_add_mod.dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle.time_based_rule"+i).value == " "){
							var msg2 = getMessage("TIME_BASED_RULE","OR");
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg2;
							return false;	 				
						}
					}
			}//13628 

		}
		//IN071361 Ends
	//	alert("89")
		//var formObj =f_query_add_mod.dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle,OR_CONTROLLER;
		//alert("formObj value: "+formObj);
		//alert("dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle value :"+f_query_add_mod.document.dept_only_Catalog_appl_middle);
		eval( formApply(f_query_add_mod.dept_only_Catalog_appl_middle.document.dept_only_Catalog_appl_middle,OR_CONTROLLER) ) ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
		//alert("msg value: "+msg);
	
		if(resultGlobal)
		{
			onSuccess();
			//alert("sucess");
		}
	}

}
// Calling Create() on Success of the Apply

 function changeValue(chk)
{
	//alert();
	if(chk.checked)
		chk.value = 'Y';
	else 
		chk.value = 'N';
}
function onSuccess()
{
	create();
}

function assignResult(res,msg,mod)
{
	resultGlobal	= res ;
	messageGlobal	= msg ;
	flagGlobal		= mod;
}

function checkIsValidForProceed()
{
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
	{
		return true;
	}
	else
	{
		return false;
	}
}


/*
This Function is called on Click of Reset Button
*/
function reset()
{
	if(f_query_add_mod.location.href.indexOf(".jsp") != -1)
	{
		create();
	}
}
/*
This Function is called on change of Allowed type in Header Screen
*/
function loadPage(obj)
{
	if(obj.value=='')
	{
		parent.dept_only_Catalog_appl_middle.location.href = "../../eCommon/html/blank.html";
	}
	else
	{
		parent.dept_only_Catalog_appl_middle.location.href = "../../eOR/jsp/OrderingRuleByPractitionerlAddModifyMiddle.jsp?mode=1&function_id="+function_id+"&pract_type="+obj.value;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	}
}
//IN071361 Starts
function onRuleChange(index)
{
	var selectedIndex = eval('document.dept_only_Catalog_appl_middle.time_based_rule'+index+'.selectedIndex');
	if(selectedIndex > 0)
	{	
		eval(document.getElementById("exp_rule_"+index)).innerHTML = "<img src='../../eCommon/images/mandatory.gif'>";

	}
	else 
	{	
		eval(document.getElementById("exp_rule_"+index)).innerHTML = '&nbsp;&nbsp;&nbsp;';		
		eval('document.dept_only_Catalog_appl_middle.expiry_rule'+index).value = '';
	}
	eval(document.getElementById("time_based_"+index)).innerHTML = '&nbsp;&nbsp;&nbsp;';
}

function ORChkPositiveNumber(obj,index) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {	
		var selectedIndex = eval('document.dept_only_Catalog_appl_middle.time_based_rule'+index+'.selectedIndex');
		if(selectedIndex == 0)
		eval(document.getElementById("time_based_"+index)).innerHTML = "<img src='../../eCommon/images/mandatory.gif'>";
    }
    else {
        if ( obj.value.length > 0 ) {

            //alert(getMessage("INVALID_POSITIVE_NUMBER", "Common"));
            obj.select();
            obj.focus();
        }
		else{
		   eval(document.getElementById("time_based_"+index)).innerHTML = '&nbsp;&nbsp;&nbsp;';
		   //eval('document.OrderingRuleby_PatientClass1.time_based_rule'+index).value = '';
		}
       // else if ( obj.value.length == 0 )
           // obj.value = 0;
    }
}
//IN071361 Ends
