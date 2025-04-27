/*
--------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------
08/05/2019		IN69027			Ramesh G			?				?				MMS-DM-CRF-0150
24/12/2021		6868			Ramesh G			24/12/2021		Ramesh G 		AAKH-CRF-0125
--------------------------------------------------------------------------------------------------------
*/

function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/MDSForDiagnosisMandatoryMain.jsp";
}
function reset(){
	f_query_add_mod.location.href = "../../eOR/jsp/MDSForDiagnosisMandatoryMain.jsp";
}
function apply(){	
	if (parseInt(f_query_add_mod.MDSForDiagnosisMandatoryResult.document.forms[0].selectedRec.value)==0 )
    {
		var message  = "";
		if((f_query_add_mod.MDSForDiagnosisMandatoryResult.document.forms[0].minimumData.value)=="S"){
			message  = getMessage("ATLEAST_ONE_SPECIALTY_TO_BE_SELECTED","OR");
		}else if((f_query_add_mod.MDSForDiagnosisMandatoryResult.document.forms[0].minimumData.value)=="O"){
			message  = getMessage("ATLEAST_ONE_ORDER_CATEGORY_TO_BE_SELECTED","OR");
		}else if((f_query_add_mod.MDSForDiagnosisMandatoryResult.document.forms[0].minimumData.value)=="P"){
			message  = getMessage("ATLEAST_ONE_PATIENT_CLASS_TO_BE_SELECTED","OR");
		}
		var confValue = confirm(message+" ,Still Do you want to continue");
		if(!confValue){
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
		}else{
			f_query_add_mod.MDSForDiagnosisMandatoryResult.document.MDSForDiagnosisMandatoryHdrFrom.submit();
		}
	}else{
		f_query_add_mod.MDSForDiagnosisMandatoryResult.document.MDSForDiagnosisMandatoryHdrFrom.submit();
	}
}
function showResultData(){
	var minimumData = document.forms[0].minimumData.value;
	var termsetId  = document.forms[0].termsetId.value;
	if(minimumData!="" && termsetId!=""){		
		parent.MDSForDiagnosisMandatoryResult.document.location.href= "../../eOR/jsp/MDSForDiagnosisMandatoryResult.jsp?minimumData="+minimumData+"&termsetId="+termsetId;
	}else{
		parent.MDSForDiagnosisMandatoryResult.document.location.href= "../../eCommon/html/blank.html";
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
}
function setCheckValue(obj){
	if(obj.checked){
		obj.value="Y";
		document.forms[0].selectedRec.value = parseInt(document.forms[0].selectedRec.value)+1;
	}else{
		obj.value="N";
		document.forms[0].selectedRec.value = parseInt(document.forms[0].selectedRec.value)-1;
		document.forms[0].totalCheck.checked = false;
	}
}
function checkedAll(obj){
	if(obj.checked){
		var len = document.forms[0].totalRec.value;
		for(var i=0;i<len;i++){
			document.getElementById("CV_"+i).checked = true;
			document.getElementById("CV_"+i).value = "Y";
		}
		document.forms[0].selectedRec.value =parseInt(document.forms[0].totalRec.value);
	}else{
		var len = document.forms[0].totalRec.value;
		for(var i=0;i<len;i++){
			document.getElementById("CV_"+i).checked = false;
			document.getElementById("CV_"+i).value = "N";
		}
		document.forms[0].selectedRec.value =0;
	
	}
	
}
//6868 Start.
function setPrimaryDiagnosisValue(obj){
	if(obj.checked){
		obj.value = "Y";
		document.forms[0].primaryDiagnosisYN.value = "Y";
	}else{
		obj.value = "N";
		document.forms[0].primaryDiagnosisYN.value = "N";
	}	
}
//6868 End.
