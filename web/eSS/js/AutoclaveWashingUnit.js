/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name			INC Number       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------

12/11/2014				AAKH_CRF_0057			Sakti Sankar		52312											Autoclaving function, option to select
																													Biological indicator , BMS Pass / Fail 
																													Both in Master as wel as Transaction function.
01/03/2015				IN054240				Ramesh Goli			IN054240										Disabled record should not allow to change the values																										
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

function create() {
	
	f_query_add_mod.location.href="../../eSS/jsp/AutoclaveWashingUnitAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ; 	
}

function query() {
	f_query_add_mod.location.href="../../eSS/jsp/AutoclaveWashingUnitQueryCriteria.jsp?function_id="+function_id+"&mode="+MODE_MODIFY ;
}


function apply() {
	
if(!proceedOnApply())
    {
	
        messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
        return false;
    }
	var formObj = f_query_add_mod.document.forms[0] ;

    if(f_query_add_mod.document.forms[0].unit_type.value=="W")
    {
	var fields = new Array (
		                    formObj.autoclave_wash_unit_code, 
							formObj.long_desc,
							formObj.short_desc,
							formObj.service_location_code
							);

	var names = new Array ( 
		                    getLabel("eSS.AutoclaveWashUnitCode.label","SS"),
							getLabel("Common.longdescription.label","Common"),
							getLabel("Common.shortdescription.label","Common"),
							getLabel("eSS.ServiceLocation.label","SS")
						  );
    }
	else{
		  fields = new Array(
      			            f_query_add_mod.document.forms[0].sterile_type,
		                    formObj.autoclave_wash_unit_code, 
							formObj.long_desc,
							formObj.short_desc,
							formObj.service_location_code
							);

		  names = new Array ( 
			                getLabel("eSS.SterilizationType.label","SS"),
		                    getLabel("Common.code.label","Common"),
							getLabel("Common.longdescription.label","Common"),
							getLabel("Common.shortdescription.label","Common"),
							getLabel("eSS.ServiceLocation.label","SS")
						  );
	}
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	if(checkSSFields( fields, names, messageFrame,errorPage)) {
		eval(formApply(formObj,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
		messageFrame.location.href = errorPage+"?err_num="+ message;
		if( result ) {
			onSuccess();
		}
	}
}
function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("autoclavewashingunitquery")==-1) )
        return true;
    else
        return false;
}

function reset() {
	if(f_query_add_mod.document.formAutoclaveWashingUnit!=null){
		f_query_add_mod.document.formAutoclaveWashingUnit.reset();
		//Added by suresh.r on 10-12-2014 against AAKH_CRF_0057 beg
		//f_query_add_mod.document.formAutoclaveWashingUnit.sterile_type.disabled=false;  //Commited for IN054240
		f_query_add_mod.document.getElementById("span1").style.visibility="visible";
		f_query_add_mod.document.getElementById("id_b_indi_pass").style.visibility="visible";
		//f_query_add_mod.document.formAutoclaveWashingUnit.b_indicator_test.disabled=false; //Commited for IN054240
		//f_query_add_mod.document.formAutoclaveWashingUnit.bms_pass_fail.disabled=false; //Commited for IN054240
		//Added by suresh.r on 10-12-2014 against AAKH_CRF_0057 end
	}
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
}

function onSuccess() {
	var mode = f_query_add_mod.document.formAutoclaveWashingUnit.mode.value;
	if( mode == MODE_INSERT ) 
		reset();
	else 
		f_query_add_mod.document.location.reload();
}

function Modify(obj){
	var autoclave_wash_unit_code=obj.cells[0].innerText;
	document.location.href="../../eSS/jsp/AutoclaveWashingUnitAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&autoclave_wash_unit_code="+autoclave_wash_unit_code;
}

function checkSterilizationType(unit_type){
	if(unit_type.value=="W"){
		document.formAutoclaveWashingUnit.sterile_type.value="";
		document.getElementById("span1").style.visibility="hidden";
		document.formAutoclaveWashingUnit.sterile_type.disabled=true;

		//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
		document.formAutoclaveWashingUnit.b_indicator_test.value="X";
		document.formAutoclaveWashingUnit.b_indicator_test.disabled=true;
		document.formAutoclaveWashingUnit.bms_pass_fail.value="X";
		document.formAutoclaveWashingUnit.bms_pass_fail.disabled=true;
		document.getElementById("id_b_indi_pass").style.visibility="hidden";//Added by suresh.r on 10-12-2014 against AAKH_CRF_0057

	}
	else{
		document.formAutoclaveWashingUnit.sterile_type.disabled=false;
		document.getElementById("span1").style.visibility="visible";

		//document.formAutoclaveWashingUnit.b_indicator_test.value="Y";
		document.formAutoclaveWashingUnit.b_indicator_test.disabled=false;
		//document.formAutoclaveWashingUnit.bms_pass_fail.value="Y";
		document.formAutoclaveWashingUnit.bms_pass_fail.disabled=false;
		document.getElementById("id_b_indi_pass").style.visibility="visible";//Added by suresh.r on 10-12-2014 against AAKH_CRF_0057
	}
}

function checkSterilizationTypeinQuery(){
	if(varUnitType=="W"){
		document.formAutoclaveWashingUnit.sterile_type.value="";
		document.getElementById("span1").style.visibility="hidden";
		//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
		document.formAutoclaveWashingUnit.b_indicator_test.value="X";
		document.formAutoclaveWashingUnit.b_indicator_test.disabled=true;
		document.formAutoclaveWashingUnit.bms_pass_fail.value="X";
		document.formAutoclaveWashingUnit.bms_pass_fail.disabled=true;
	}
	else{
		document.getElementById("span1").style.visibility="visible";

	}
}

function CheckForSpecCharsTemp(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
