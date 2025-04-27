  //saved on 02.11.2005
function run() {
	var frmObject = f_query_add_mod.document.formPhIssueTokenCriteria;
	if(f_query_add_mod.document.formPhIssueTokenCriteria) {
		var fields= new Array (frmObject.p_disp_locn_code,frmObject.p_token_series_code,frmObject.p_patient_id,frmObject.p_serial_no);
		var names= new Array (getLabel("ePH.DispenseLocation.label","PH"),getLabel("ePH.TokenSeries.label","PH"),getLabel("Common.patientId.label","Common"),getLabel("ePH.TokenNo.label","PH"));

	if(checkFields(fields,names,messageFrame) ) {
		
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.formPhIssueTokenCriteria.submit();
		
		}
	}
}

function reset() {
    f_query_add_mod.formPhIssueTokenCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}


async function callPatientSearch(target){

	var patient_id = await PatientSearch();
 if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;
 }
 if(document.formPhIssueTokenCriteria.p_disp_locn_code.value!=''&& document.formPhIssueTokenCriteria.p_token_series_code.value!='' && patient_id!='')
 {
	 var p_disp_locn_code=document.formPhIssueTokenCriteria.p_disp_locn_code.value;
	 var p_token_series_code=document.formPhIssueTokenCriteria.p_token_series_code.value;
	 populateTokenSeries_NO(p_disp_locn_code,p_token_series_code,patient_id);
 }
}




function populateTokenSeries(facility_id,disp_locn_code)
{
   
	bean_id		=	document.formPhIssueTokenCriteria.bean_id.value;
	bean_name	=	document.formPhIssueTokenCriteria.bean_name.value;

	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();

    var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " facility_id=\""+facility_id+"\"";
	xmlStr += " disp_locn_code=\""+disp_locn_code+"\"";
	xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PhRepTokenSeriesValidation.jsp?validate=POPULATE_TOKEN_SERIES",false);
	xmlHttp.send(xmlDoc);
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
	
}



function addList(code,desc)	{ 
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.formPhIssueTokenCriteria.p_token_series_code.add(element);
	
}

function clearList()	{
		
    var len			= document.formPhIssueTokenCriteria.p_token_series_code.options.length;
	for(var i=0;i<len;i++) {
		document.formPhIssueTokenCriteria.p_token_series_code.remove("p_token_series_code") ;
	}


	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ; 
	opt.text = tp ;
	opt.value = "" ;
	document.formPhIssueTokenCriteria.p_token_series_code.add(opt);
}


function populateTokenSeries_NO(disp_locn_code,p_token_series_code,patient_id)
{
   
   if(disp_locn_code!=''&& disp_locn_code!=null && p_token_series_code!=''&& p_token_series_code!=null && patient_id!=''&& patient_id!=null)
	{
			bean_id		=	document.formPhIssueTokenCriteria.bean_id.value;
			bean_name	=	document.formPhIssueTokenCriteria.bean_name.value;
			var facility_id	=	document.formPhIssueTokenCriteria.p_facility_id.value;


			var xmlHttp = new XMLHttpRequest();

			var xmlStr ="<root><SEARCH ";
			xmlStr += " bean_id=\""+bean_id+"\"";
			xmlStr += " bean_name=\""+bean_name+"\"";
			xmlStr += " facility_id=\""+facility_id+"\"";
			xmlStr += " disp_locn_code=\""+disp_locn_code+"\"";
			xmlStr += " token_series_code=\""+p_token_series_code+"\"";
			xmlStr += " patient_id=\""+patient_id+"\"";
			xmlStr +=" /></root>";
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");			
			xmlHttp.open("POST","PhRepTokenSeriesValidation.jsp?validate=POPULATE_TOKEN_SERIES_NO",false);
			xmlHttp.send(xmlDoc);
			//alert(xmlHttp.responseText);
			eval(xmlHttp.responseText);
	}	
}

function clearList1()	{
		
    var len			= document.formPhIssueTokenCriteria.p_serial_no.options.length;
	for(var i=0;i<len;i++) {
		document.formPhIssueTokenCriteria.p_serial_no.remove("p_serial_no") ;
	}

	
}
function addList1(code,desc)	{
	var element = document.createElement('OPTION') ;
	element.value		= code ;
	element.text		= desc ;
	document.formPhIssueTokenCriteria.p_serial_no.add(element);
   	document.formPhIssueTokenCriteria.p_serial_no.selectedIndex=document.formPhIssueTokenCriteria.p_serial_no.options.length-1;

}

function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */ 
	var patientId = document.formPhIssueTokenCriteria.p_patient_id.value; 
	if( (patientId != null) && (patientId !="")){
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId + "\" " ;
		xmlStr+= "chkPatientID=\"false\" " ;
		xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "QueryPatientDrugProfileValidation.jsp?func_mode=Duplicate&bean_id=" + bean_id + "&bean_name=" +bean_name+"&patientId="+patientId, false ) ;	
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);	
	}	
}  
 
function mergedPatientAlert(main_patientid){ 
	msg = getMessage('PATIENT_MERGED_VALID','MP');
	msg= msg.replace('#',main_patientid);
	alert(msg);
	document.formPhIssueTokenCriteria.p_patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */
