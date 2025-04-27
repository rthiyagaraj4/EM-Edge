/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create() {
	f_query_add_mod.location.href="../../eSS/jsp/AutoclaveWashingTestAdd.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function query() {
	f_query_add_mod.location.href="../../eSS/jsp/AutoclaveWashingTestQueryCriteria.jsp?function_id="+function_id+"&mode="+MODE_MODIFY ;
}

function apply() 
{
		if(!proceedOnApply())
		{
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			return false;
		}
		var arrPKFieldNames     =   new Array();
		arrPKFieldNames[0]      =   "code_";

		var formObj = f_query_add_mod.document.formAutoclaveWashingTest ;
		var errorPage	=	"../../eCommon/jsp/error.jsp";
		var obj=null;
	
		if (f_query_add_mod.document.formAutoclaveWashingTest.mode.value == MODE_MODIFY) 
		{
		var formObj = f_query_add_mod.document.formAutoclaveWashingTest ;

		var fields = new Array (formObj.code_0, 
								formObj.long_desc_0,
								formObj.short_desc_0
								);

		var names = new Array (getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),	getLabel("Common.shortdescription.label","Common"));
		var blankObject = null;
		var errorPage	=	"../../eCommon/jsp/error.jsp";
		
			 if (f_query_add_mod.checkSSFields( fields, names, messageFrame))
			 {
				eval(formApply(formObj,SS_CONTROLLER));
				messageFrame.location.href = errorPage+"?err_num="+ message;
				if( result ) 
				{
							onSuccess();
				}
			}
			return;
		}

	var arrFieldName = new Array();
	var arrLegends = new Array();
	var arrPKFieldNames =	new Array();
	arrFieldName[0] =	"code_";
	arrFieldName[1] =	"long_desc_";
	arrFieldName[2] =	"short_desc_";
	arrLegends[0] =getLabel("Common.code.label","Common"); 
	arrLegends[1] =getLabel("Common.longdescription.label","Common");    
	arrLegends[2] = getLabel("Common.shortdescription.label","Common");   
	arrPKFieldNames[0] = "code_";
	resetDuplicateClass( formObj, arrPKFieldNames);
	if(formObj.mode.value==MODE_INSERT) {
		var validateResult = validateSSMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
		if(validateResult) {
			eval(formApply(f_query_add_mod.document.formAutoclaveWashingTest,SS_CONTROLLER));
			if( result ) {
				onSuccess();
			}				
			if( invalidCode != "null" && invalidCode != "" ){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message+":-"+invalidCode;
				return; //Added By Sakti Sankar against Inc#28682

				//Commented by Sakti Sankar against inc#28682 
				//showDuplicates(formObj, arrPKFieldNames, invalidCode,'0',messageFrame); 
			}
			else {
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			}
		}
	}
}

  
function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("autoclavewashingtestquery")==-1) )
        return true;
    else
        return false;
}
function reset() {
	if(f_query_add_mod.document.formAutoclaveWashingTest!=null)
		f_query_add_mod.document.location.reload();
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();

}

function onSuccess() {
	var mode = f_query_add_mod.document.formAutoclaveWashingTest.mode.value;
	if( mode == MODE_INSERT ) 
		reset();
	else 
		f_query_add_mod.document.location.reload();
}

function Modify(obj){
	var test_code=obj.cells[0].innerText;
	document.location.href="../../eSS/jsp/AutoclaveWashingTestAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&test_code="+test_code;
}

function resetColorCode(obj){
    var arrPKFieldNames = new Array();
    var formObj = parent.f_query_add_mod.document.formAutoclaveWashingTest;
    arrPKFieldNames[0] = "code_";
    resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}

//Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
function checkBiBmsType(unit_type,index){
		
	if(unit_type.value=="W"){
		
		eval("document.formAutoclaveWashingTest.biological_indicator_"+index).value="X";
		eval("document.formAutoclaveWashingTest.biological_indicator_"+index).disabled=true;
		eval("document.formAutoclaveWashingTest.bms_pass_fail_"+index).value="X";
		eval("document.formAutoclaveWashingTest.bms_pass_fail_"+index).disabled=true;

	}
	else{
		
		//eval("document.formAutoclaveWashingTest.biological_indicator_"+index).value="X";
		eval("document.formAutoclaveWashingTest.biological_indicator_"+index).disabled=false;
		//eval("document.formAutoclaveWashingTest.bms_pass_fail_"+index).value="X";
		eval("document.formAutoclaveWashingTest.bms_pass_fail_"+index).disabled=false;
	}
}

function checkcheckBiBmsTypeQuery(){
	if(varUnitType=="W"){
		
		document.formAutoclaveWashingTest.biological_indicator_0.value="X";
		document.formAutoclaveWashingTest.biological_indicator_0.disabled=true;
		document.formAutoclaveWashingTest.bms_pass_fail_0.value="X";
		document.formAutoclaveWashingTest.bms_pass_fail_0.disabled=true;
	}
	
}
//Added ends
