/*Created by Ashwini on 07-Jul-2017 for ML-MMOH-CRF-0702*/
function create() {
	med_rec_rep_id.location.href = "../../eMR/jsp/MedRecRequestId.jsp" ;
}

function query() {
	med_rec_rep_id.location.href = "../../eMR/jsp/MedRecRequestIdQuery.jsp" ;
}

function apply() {	
	if(med_rec_rep_id.document.request_id_form!=null){
	var fields = new Array ( med_rec_rep_id.document.request_id_form.req_year,
						med_rec_rep_id.document.request_id_form.start_no,
						med_rec_rep_id.document.request_id_form.max_no
					    );	
	var names = new Array ( med_rec_rep_id.getLabel('Common.year.label','common'), 
						med_rec_rep_id.getLabel('Common.StartSerialNo.label','common'),
						med_rec_rep_id.getLabel('Common.maxserialno.label','common')
					      );	
		if(med_rec_rep_id.checkFieldsofMst( fields, names, messageFrame)) {
			med_rec_rep_id.document.request_id_form.submit() ;
		}
	} else {
		frames[0].location.reload();
	    return false;
	}
}

function reset() {
	if(med_rec_rep_id.document.forms[0].name == "request_id_form") med_rec_rep_id.document.request_id_form.reset() ;
	else med_rec_rep_id.document.MedRecRequestIdQueryForm.reset() ;
}

function onSuccess() {
	med_rec_rep_id.location.reload() 
}

function NumChkForReqId(event)
{
	var strCheck = '1234567890';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 

function ZeroChkForReqId(obj1){	
	var message1 = getMessage('VALUE_SHOULD_BE_GR_ZERO',"Common");
	message1 = message1.replace("ZERO", 0);
	if(obj1.value!=""){
		if(obj1.name == "req_year"){
		message1 = message1.replace("Value", getLabel("Common.year.label","Common"));
		}else if(obj1.name == "start_no"){
		message1 = message1.replace("Value", getLabel("Common.StartSerialNo.label","Common"));
		}else if(obj1.name == "max_no"){
		message1 = message1.replace("Value", getLabel("Common.maxserialno.label","Common"));
		}
		if (obj1.value <= 0){
			alert(message1);
			obj1.value="";
			obj1.focus();		
		}	
	}
}

function YearLenforReqId(Obj)
{
		if(Obj.value.length<4 && Obj.value!="")
		{
			alert(getMessage("YEAR_4_CHAR","Common"));
			Obj.select();
			Obj.focus();
		}
}

function SerialNumCheck(objMin, objMax)
{	var errMsg = getMessage('VALUE_SHOULD_BE_GR_ZERO',"Common");
	errMsg = errMsg.replace("Value", getLabel("Common.maxserialno.label","Common"));
	errMsg = errMsg.replace("ZERO", getLabel("Common.StartSerialNo.label","Common"));
	
	var minVal		= "";
	var maxVal		= "";
	
	if(objMin.value != ""){
		 minVal		= parseInt(objMin.value,10);
		objMin.value	= minVal;	
	}
	if(objMax.value != ""){
		 maxVal		= parseInt(objMax.value,10);
		 objMax.value	= maxVal; 
	}
	
	if(objMin.value != "" && objMax.value != "")
	{
		 if (minVal >=maxVal){
			alert(errMsg);
			objMax.select();
			objMax.focus();
		}
	}
}

function fnSetvalue(type)
{
	if(type=="P"){
		document.forms[0].isPrevClicked.value="Y";
	}else if(type=="N"){
		document.forms[0].isNextClicked.value="Y";
	}
}

function setNextSrlNo(objNxt)
{
	var StarttSrlNo = "";
	var NextSrlNo = "";
	if(objNxt.value != 0 || objNxt.value != "")
	{   
		StarttSrlNo = parseInt(objNxt.value,10);
		NextSrlNo = parseInt(StarttSrlNo);
		document.forms[0].next_no.value = NextSrlNo;
		document.forms[0].next_serl_no.value = NextSrlNo; 
	}
	if(objNxt.value == "")
	{
		document.forms[0].next_no.value = "";
		document.forms[0].next_serl_no.value =""; 
	}	
}
