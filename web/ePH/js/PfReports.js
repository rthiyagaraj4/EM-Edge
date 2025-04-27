  var message		= "" ;

function reset() {
frames(1).document.formPfReportsCriteria.reset();
}

function run() {
	frames[1].document.formPfReportsCriteria.p_report_id.value=frames[1].document.formPfReportsCriteria.pf_report_id.value;
	frames[1].document.formPfReportsCriteria.p_from_date.value=frames[1].document.formPfReportsCriteria.enq_date_from.value;
	frames[1].document.formPfReportsCriteria.p_to_date.value=frames[1].document.formPfReportsCriteria.enq_date_to.value;
	var frmObject =frames[1].document.formPfReportsCriteria;
	var locale=frmObject.language_id.value;//Added for DateConversion
	if(frames[1].document.formPfReportsCriteria) {
		var fields= new Array (frmObject.p_report_id,frmObject.p_from_date, frmObject.p_to_date);
		var names= new Array (getLabel("Common.PFReports.label","Common"),getLabel("Common.DateFrom.label","Common"),getLabel("Common.DateTo.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {
			//if(DateCheck(frmObject.p_enq_date_from,frmObject.p_enq_date_to)){
				frmObject.p_enq_date_from.value=convertDate(frmObject.enq_date_from.value,'DMY',locale,"en");//Added for DateConversion identification
				frmObject.p_enq_date_to.value=convertDate(frmObject.enq_date_to.value,'DMY',locale,"en");//Added for DateConversion identification
				frmObject.submit();
			//}			
		}
	}
}

 /* function DateCheck(from,to) {
    var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) < Date.parse(fromdt)){		
			alert(getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH'));
			return false;
		}
	} 
	return true;
}  */

function CheckDateT(obj){
	var locale=document.formPfReportsCriteria.language_id.value;
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
function validate_date(Obj) {

	if(document.formPfReportsCriteria.enq_date_from.value=='' || document.formPfReportsCriteria.enq_date_to.value=='')
	{//p_enq_date_from  to enq_date_from  p_enq_date_to to enq_date_to Added for DateConversion 
					return false;
	}
	else{
		if(!isBefore(document.formPfReportsCriteria.enq_date_from.value,document.formPfReportsCriteria.enq_date_to.value,"DMY",document.formPfReportsCriteria.language_id.value)) {			
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM');			
				alert(errors);
				Obj.value = "";  
				return false;
			}
	}return true;
}

function DateCheck(from,to) {
    if(from=="" || to.value=="")
	{ 		
		return false;
	}
	else{
		if(!isBefore(to.value,from,"DMY",document.formPfReportsCriteria.language_id.value)) {
			var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(errors);
			to.value=""
			return false;
		}
	}  
  return true;
}
