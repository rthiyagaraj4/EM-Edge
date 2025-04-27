function run() {
	
	var frmObject = f_query_add_mod.document.SKRStatisticalReportsCriteria;
	if(f_query_add_mod.document.SKRStatisticalReportsCriteria) {
		
		frmObject.monthyear.value = "";
        if(frmObject.p_month.value== null || frmObject.p_month.value==""  || frmObject.p_disp_year.value  == null | frmObject.p_disp_year.value ==""){ //p_year renamed p_disp_year as for SKR-SCF-0855 
		    frmObject.monthyear.value="";
		}
		else{
			frmObject.monthyear.value=frmObject.p_disp_year.value; 
		}
		var fields= new Array (frmObject.p_report_type,frmObject.monthyear);
		var names= new Array (getLabel("ePH.reporttype.label","PH"),getLabel("ePH.DispensePeriodMonth/Year.label","PH"));
			
		if(checkFields(fields,names,messageFrame)){	
			if (frmObject.p_report_type.value == 'H'){
				frmObject.p_report_id.value = 'PHHIVDUMO';	
			}
			else if (frmObject.p_report_type.value == 'NP'){
				frmObject.p_report_id.value = 'PHNADRPATMON';
			}
			else if (frmObject.p_report_type.value == 'NM'){
				frmObject.p_report_id.value = 'PHNADRMON';
			}
			else if(frmObject.p_report_type.value == 'PP'){
				frmObject.p_report_id.value = 'PHPYDRPATMON';
			}
			else if(frmObject.p_report_type.value == 'PM'){
				frmObject.p_report_id.value = 'PHPYDRSUMMON';
			}
			else {
				frmObject.p_report_id.value = '';
			}

			frmObject.p_disp_month.value = frmObject.p_month.value;
			var actualYear = frmObject.p_disp_year.value;
			if(frmObject.p_language_id.value!='en'){//if block and else condition Added for SKR-SCF-0855 [IN:044362] 
				var tmpDate = "01/"+frmObject.p_month.value+"/"+frmObject.p_disp_year.value; 
				tmpDate =  convertDate(tmpDate,"DMY",frmObject.p_language_id.value );
				var artmpDate = tmpDate.split("/");
				tmpDate = artmpDate[2];
				frmObject.p_year.value =  tmpDate;
				frmObject.p_disp_year.value =  tmpDate;
			}
			else{
				frmObject.p_year.value =  frmObject.p_disp_year.value; 
			}
			f_query_add_mod.document.SKRStatisticalReportsCriteria.submit();
			frmObject.p_disp_year.value =  actualYear;
		}
	}
}


function reset() {
	f_query_add_mod.location.reload();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function checkMonth(obj){
	if ((obj.value <1 ||obj.value >12) && obj.value !=''){
		if (obj.value <1){
			alert(getMessage("PH_MONTH_CANNOT_BE_LESS_THAN_1","PH"));
			obj.focus();
		}
		if (obj.value >12){
			alert(getMessage("MONTH_IS_GR_12","Common"));
			obj.focus();
		}
	}
}

function checkYear(obj){
	var formObj =document.frames.formDispByPatientClass
    if (obj.value.length<4 && obj.value != '')  {
		alert(getMessage("PH_INVALID_YEAR","PH"));
		obj.focus();
		return false;
    }
	if (obj.value <=0 && obj.value != ''){
		alert(getMessage("PH_INVALID_YEAR","PH"));
		obj.focus();
		return false;
	}
	
}

function allowPositiveNumber() { 

   var key = window.event.keyCode;// allows only numbers to be entered
   if( ! ( ( key>=48 ) && ( key<=58 ) ) ) {
       return false;
   }
}

function ChkSplChars(obj){
	var str=obj.value;
	
	var chk="1234567890";
	for(var i=0; i<str.length; i++)	{
		if (chk.indexOf(str.charAt(i)) == -1) {
			alert(getMessage("INVALID_NUMBER_FORMAT", "PH"));
			obj.select();
			obj.focus();
			return;
		}
	}
}