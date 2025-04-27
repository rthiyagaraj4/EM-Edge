  //saved on 02.11.2005
function run() {
	validateDate();
	searchFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	searchFrame.document.forms[0].target="messageFrame";
	searchFrame.document.formPhRepDlyDispSumm.submit();
}

function ValidateTime(obj){
	//p_fm_date = document.formPhRepDlyDispSumm.p_fm_date;
	if(obj.value!=""){
		if(!doDateTimeChk(obj)){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.focus;
			return false;
		}
	}

}

function reset(){
	frames[1].formPhRepDlyDispSumm.reset();
}

function validateDate(){
	//alert('called'+frames[1].name);
	var formObj = searchFrame.document.formPhRepDlyDispSumm;
	if (formObj.p_fm_date.value!="" && formObj.p_to_date.value!=""){
		//alert(ValidateDateTime(formObj.p_fm_date,formObj.p_to_date));
		//alert(formObj.p_fm_date.value);
		//alert(formObj.p_to_date.value);
		if(!ValidateDateTime(formObj.p_fm_date,formObj.p_to_date)){
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("FM_DISP_NO_TO_DISP_NO","PH");
			formObj.p_to_date.focus();
		}else{
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
	}
}



// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formPhRepDlyDispSumm.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMYHM',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMYHM',locale,'en');
	}
}
