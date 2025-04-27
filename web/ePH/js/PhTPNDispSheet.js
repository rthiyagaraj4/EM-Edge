function populateWorksheetNo()
{
	var selectElement = document.formPhTPNDispSheetCriteria.p_worksheet_id;
	 while (selectElement.options.length > 1) {
	        selectElement.remove(1);
	    }
	var frmObject		=   parent.f_query_add_mod.document.formPhTPNDispSheetCriteria;
	var p_disp_date	="";
	var p_patient_id	=	frmObject.p_patient_id.value;
	if(p_patient_id=="")
		return false;
	var locale	=	frmObject.locale.value;
	p_disp_date		=	frmObject.p_dispense_date.value;
	p_disp_date=convertDate(p_disp_date,"DMY",locale); 
	frmObject.p_dispense_date.value=p_disp_date;
	var stage			=	frmObject.stage.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " p_patient_id=\""+p_patient_id+"\"";
	xmlStr += " p_disp_date=\""+p_disp_date+"\"";
	xmlStr += " stage=\""+stage+"\"";
	xmlStr += " bean_id=\"PHRepDispStatisByDispBean\"";
	xmlStr += " bean_name=\"ePH.PHRepDispStatisByDispBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ReportsValidate.jsp?called_from=populateWorksheetNo",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}
function loadWorksheetNos(worksheet_no) {
		var element			= document.createElement('OPTION') ;
		element.value		=  worksheet_no ;
		element.text		=  worksheet_no ;
		document.formPhTPNDispSheetCriteria.p_worksheet_id.add(element);	
}
function clearloadedWorksheetNos() {
	var selectElement = f_query_add_mod.document.formPhTPNDispSheetCriteria.p_worksheet_id;
	 for (var i = selectElement.options.length - 1; i > 0; i--) {
         selectElement.remove(i);
     }
}

function run() {
	var frmObject = f_query_add_mod.document.formPhTPNDispSheetCriteria;

	if(f_query_add_mod.document.formPhTPNDispSheetCriteria) {
		var fields= new Array (frmObject.p_patient_id,frmObject.p_worksheet_id,frmObject.p_dispense_date);
	var names= new Array (getLabel("Common.patientId.label","Common"),getLabel("ePH.WorksheetID.label","PH"),getLabel("ePH.DispensedDate.label","PH"));
        
		if(checkFields(fields,names,messageFrame) ) {
			
				frmObject.p_report_id.value ='PHRDISSHTPNSTD' ;
				frmObject.submit();
		}
	}
	
}

function reset() {
	clearloadedWorksheetNos();
    f_query_add_mod.formPhTPNDispSheetCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function showResults(){
	var report_type		= parent.f_query_add_mod.document.formPhWorksheetChartCriteria.report_by.value;
	var locale		= parent.f_query_add_mod.document.formPhWorksheetChartCriteria.locale.value;
	var patient_class	= parent.f_query_add_mod.document.formPhWorksheetChartCriteria.patient_class.value;
	var stage			= parent.f_query_add_mod.document.formPhWorksheetChartCriteria.stage.value;
	var disp_locn_code	= parent.f_query_add_mod.document.formPhWorksheetChartCriteria.p_disp_locn_code.value;
	from_date		= parent.f_query_add_mod.document.formPhWorksheetChartCriteria.from_date.value;
	to_date			= parent.f_query_add_mod.document.formPhWorksheetChartCriteria.to_date.value;
    from_date=convertDate(from_date,"DMY",locale); 
    to_date=convertDate(to_date,"DMY",locale); 
	parent.f_query_results.location.href="../../ePH/jsp/PhWorksheetChartResult.jsp?report_type="+report_type+"&patient_class="+patient_class+"&stage="+stage+"&disp_locn_code="+disp_locn_code+"&from_date="+from_date+"&to_date="+to_date;
}

function showPrintReport(worksheet_id,report_type,stage,order_status){

	var formObj = parent.f_query_add_mod.formPhTPNDispSheetCriteria;
	formObj.p_worksheet_id.value = worksheet_id ;
	formObj.p_report_id.value = "PHRDISSHTPNSTD" ;
	parent.f_query_add_mod.document.formPhTPNDispSheetCriteria.submit();
}

async function callPatientSearch(target){
	var patient_id = await PatientSearch();
	if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;
	}
}

//the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formPhTPNDispSheetCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			//obj.select();
			//obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
	return true;
}
