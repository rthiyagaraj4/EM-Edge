var message		= "" ;
function reset() {
	frames[1].document.forms[0].reset();
}

function validate_date(Obj,ref) {
	if(document.forms[0].p_enq_date.value==''){ 
		return false;
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
	frames[1].document.forms[0].p_from_date.value=frames[1].document.forms[0].p_enq_date.value;
	var frmObject =frames[1].document.forms[0];
	if(frames[1].document.forms[0]) {
		var fields= new Array (frmObject.p_enq_date);
		var names= new Array (getLabel("ePH.EnquiryDate.label","PH"));
		if(checkFields(fields,names,messageFrame) ) {
			if(!isBefore(frames[1].document.forms[0].p_enq_date.value,frames[1].document.forms[0].sysdate.value,"DMY",frames[1].document.forms[0].language_id.value)) {	 //code added for  IN049204 -- Start				
				var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
				alert(errors);
				return false;
			} //code added for  IN049204 -- End
			frames[1].document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			frames[1].document.forms[0].target="messageFrame";
			frames[1].document.forms[0].submit();
		}
	}
}
