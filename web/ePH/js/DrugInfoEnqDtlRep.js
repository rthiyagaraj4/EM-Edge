var message		= "" ;
function reset() {
	//frames[1].location.href="../../ePH/jsp/DrugInfoEnqDtlRepCriteria.jsp";
	frames[1].document.forms[0].reset();
}

function validate_date(Obj,ref) {
	if(document.forms[0].p_enq_date_from.value=='' || document.forms[0].p_enq_date_to.value==''){ 
		return false;
	}
	else{
		if(!isBefore(document.forms[0].p_enq_date_from.value,document.forms[0].p_enq_date_to.value,"DMY",document.forms[0].language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			alert(errors);
			return false;
		}
	}
}

// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formDrugInfoRepCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}

function DateCheck(from,to) {
	if(from.value=="" || to.value==""){ 		
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].language_id.value)) {
			var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(errors);
			return false;
		}
	}
    return true;
}


function run() {
	frames[1].document.forms[0].p_from_date.value=frames[1].document.forms[0].p_enq_date_from.value;
	frames[1].document.forms[0].p_to_date.value=frames[1].document.forms[0].p_enq_date_to.value;
	var frmObject =frames[1].document.forms[0];
	if(frames[1].document.forms[0]) {
		var fields= new Array (frmObject.p_enq_date_from, frmObject.p_enq_date_to);
		var names= new Array (getLabel("ePH.EnquiryDateFrom.label","PH"), getLabel("ePH.EnquiryDateTo.label","PH"));
		if(checkFields(fields,names,messageFrame) ) {
			    frames[1].document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				frames[1].document.forms[0].target="messageFrame";
				frames[1].document.forms[0].submit();
		}
	}
}
