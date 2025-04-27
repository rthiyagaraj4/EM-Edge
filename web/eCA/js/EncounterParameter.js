/*
---------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
01/04/2015	IN048704		Karthi L							 				Bed Side Referral
07/11/2017  IN063819		Prakash C			07/11/2017		Ramesh G		ML-MMOH-CRF-0805
---------------------------------------------------------------------------------------------------------------
*/
function show() 
{
	parent.window.document.title =getLabel("eCA.EncounterParameter.label","CA");
}

function apply() {
	var chk_val = f_query_add_mod.document.encounter_param_form.reln_reqd_yn.checked;
	// IN048704 - Start
	var assign_chk_val = f_query_add_mod.document.encounter_param_form.assign_confirm_referral_yn.checked;
	if(assign_chk_val){
		f_query_add_mod.document.encounter_param_form.assign_confirm_referral_yn.value = "Y";
	}
	else {
		f_query_add_mod.document.encounter_param_form.assign_confirm_referral_yn.value = "N";
	}
	// IN048704 - End
	//start-0605
	var remarks_chk_val = f_query_add_mod.document.encounter_param_form.remarks_relationships_yn.checked;
	if(remarks_chk_val){
		f_query_add_mod.document.encounter_param_form.remarks_relationships_yn.value = "Y";
	}
	else {
		f_query_add_mod.document.encounter_param_form.remarks_relationships_yn.value = "N";
	}
	//end-0605
	if(chk_val){
		f_query_add_mod.document.encounter_param_form.reln_reqd_yn.value = "Y";
	}else{
		f_query_add_mod.document.encounter_param_form.reln_reqd_yn.value = "N";
	}
	var fields = new Array ( f_query_add_mod.document.encounter_param_form.days_bkwd_visit,
						f_query_add_mod.document.encounter_param_form.days_bkwd_dischg
					    );
	
	var names = new Array ( f_query_add_mod.getLabel("eCA.BackwardVisits.label",'CA'),
							f_query_add_mod.getLabel("eCA.BackwardDischarge.label",'CA')
					      );
	var splField = new Array (f_query_add_mod.document.encounter_param_form.days_bkwd_visit,
							  f_query_add_mod.document.encounter_param_form.days_bkwd_dischg
							);
	var splFieldName = new Array ( f_query_add_mod.getLabel("eCA.BackwardVisits.label",'CA'),
							f_query_add_mod.getLabel("eCA.BackwardDischarge.label",'CA')
					      );
	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			f_query_add_mod.document.encounter_param_form.submit();
		}
	}
}

function checkSequence(objSequence)
{
	var errorMessage =""
	 if(parseInt(objSequence.value) <= 0)
			{
				errorMessage= getMessage("SEQUENCE_NOT_ZERO",'CA');
				alert(errorMessage);
				objSequence.value=''
				objSequence.focus()
				return false
			}
}


function CheckPositiveNumberLocal(obj) {
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) 
	{		
	}
	else {
  		if ( obj.value.length > 0 ) 
		{
  			alert(getMessage("POSITIVE_NUMBER_ALLOWED",'CA'));
  			obj.select();
  			obj.focus();
  		}
  	}
}

function reset() {
	//	if(f_query_add_mod.document.encounter_param_form.name == "encounter_param_form") f_query_add_mod.document.encounter_param_form.reset() ;
		//else 
		//f_query_add_mod.document.query_form.reset() ;
			//f_query_add_mod.location.href ="../../eCA/jsp/addEncounterParam.jsp";
			f_query_add_mod.document.forms[0].reset();
}

function onSuccess() 
{
	f_query_add_mod.location.reload();
}
function assignVal(obj){
	var chk = obj.checked;
	if(chk){
		document.encounter_param_form.reln_reqd_yn.value = "Y";
	}else{
		document.encounter_param_form.reln_reqd_yn.value = "N";
	}
}
//IN048704 - Start  
function assignConfirm(obj){
	if(obj.checked){
		document.encounter_param_form.assign_confirm_referral_yn.value = "Y";
	}
	else {
		document.encounter_param_form.assign_confirm_referral_yn.value = "N";
	}
}
// End
//start-0605
function remarksConfirm(obj){
	if(obj.checked){
		document.encounter_param_form.remarks_relationships_yn.value = "Y";
	}
	else {
		document.encounter_param_form.remarks_relationships_yn.value = "N";
	}
}
//end-0605
function checkForMinus(obj)
{
	if(obj.value != '')
	{
		if(obj.value.indexOf("-") > -1)
		{
			//alert("APP-CA00034 Negative values are not allowed");
			alert(getMessage("POSITIVE_NUMBER_ALLOWED","CA"))
			obj.select();
			return false;
		}
		if(parseInt(obj.value,10)  == 0)
		{
				//alert("APP-CA00035  values should be greater than zero");
				alert(getMessage("INVALID_POSITIVE_NUMBER","Common"));
				obj.select();
				return false;
		}
	}
	CaCheckTime(obj); //IN063819
}
//IN063819 starts
function CaCheckTime(obj) {
   var sequence = "1234567890:";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			//alert("ONLY_POSITIVE_NUM");
			alert(parent.getMessage('ONLY_POSITIVE_NUM','OR'));
			obj.focus();
			return false;
		}
   }
}
//IN063819 ends
