  //saved on 17.02.2010
//Patient Search from common.js
function callPatientSearch(){

	//var formObj=document.frames.frmReferralPrescriptionQueryCriteria;
	var patient_id = PatientSearch();
	if (patient_id!= "" && patient_id != undefined){

		formSirirajPillBoxCriteria.p_patient_id.value = patient_id;
		//formSirirajPillBoxCriteria.p_patient_id.disabled = true;
		//formSirirajPillBoxCriteria.btnPatientID.disabled = true;
		
		var bean_id		= formSirirajPillBoxCriteria.bean_id.value ;
		var bean_name	= formSirirajPillBoxCriteria.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "SRRPhRepDlyDispSummValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&func_mode=CALLPATIENT", false ) ;
		xmlHttp.send( xmlDoc ) ;
//		alert('xmlHttp.responseText  ---  :'+xmlHttp.responseText);

		eval(xmlHttp.responseText);
	}
	else{
		formSirirajPillBoxCriteria.p_patient_name.style.display="none";
		formSirirajPillBoxCriteria.p_patient_name.innerText='';
	}
}




function reset() {
		f_query_add_mod.location.reload();
		messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}


function run() {
		
	var frmObject = f_query_add_mod.document.formSirirajPillBoxCriteria;
	
	if(f_query_add_mod.document.formSirirajPillBoxCriteria) {
    //assiging values to the hidden values of report parameters

		//var fields= new Array (frmObject.dt_from,frmObject.dt_to,frmObject.p_time_from,frmObject.p_time_to,frmObject.p_rep_option);
		var fields= new Array (frmObject.p_report_type,frmObject.p_patient_id,frmObject.P_FM_DATE_TEXTBOX,frmObject.P_TO_DATE_TEXTBOX);		
		var names= new Array (getLabel("Common.reporttype.label","Common"),getLabel("Common.patientId.label","Common"),getLabel("Common.Start.label","Common"),getLabel("Common.to.label","Common"));
		if(checkFields(fields,names,messageFrame)){
//alert(convertDate(frmObject.P_FM_DATE_TEXTBOX.value,'DMY',frmObject.p_language_id1.value,'en'))
		if(frmObject.P_FM_DATE_TEXTBOX.value!= null && frmObject.P_FM_DATE_TEXTBOX.value!="")
			frmObject.P_FM_DATE.value = convertDate(frmObject.P_FM_DATE_TEXTBOX.value,'DMY',frmObject.p_language_id1.value,'en');

		if(frmObject.P_TO_DATE_TEXTBOX.value!= null && frmObject.P_TO_DATE_TEXTBOX.value!="")
			frmObject.P_TO_DATE.value = convertDate(frmObject.P_TO_DATE_TEXTBOX.value,'DMY',frmObject.p_language_id1.value,'en');
			
		if( f_query_add_mod.doDateCheck(frmObject.P_FM_DATE_TEXTBOX, frmObject.P_TO_DATE_TEXTBOX, messageFrame ) ) {
			if (frmObject.p_report_type.value == 'W')
			{
				frmObject.p_report_id.value = 'PHPILLWS';
			}
			else if (frmObject.p_report_type.value == 'WR')
			{
				frmObject.p_report_id.value = 'PHPBWSLIST';
			}
			else if (frmObject.p_report_type.value == 'M')
			{
				frmObject.p_report_id.value = 'PHPILLMC';
			}
			else{
				frmObject.p_report_id.value = '';
			}
				f_query_add_mod.document.formSirirajPillBoxCriteria.submit();
			}
		}		
	}
}


//Drug Lookup:
function searchDrugName()
{
	
	var formObj = document.frames.formSirirajPillBoxCriteria;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select").value)+"'"+document.formSirirajPillBoxCriteria.p_language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );

	if(retVal != null && retVal != "" )  
	{
		formObj.drug_name.value = retVal[1] ;
		formObj.p_drug_code.value = retVal[0];
		
		//formObj.drug_name.disabled  = false;
		//formObj.drug_name_search.disabled = true;
		
	}
}

function assignPatientLine(p_name){

	//alert("p_name== 114==>" +p_name);
	formSirirajPillBoxCriteria.p_patient_name.style.display="inline";
	//Added Decode URIcomponent for P.Name to convert language for the incident number:23230 in spira on 11/Aug/2010
	formSirirajPillBoxCriteria.p_patient_name.innerText=decodeURIComponent(p_name,"UTF-8"); 
	
	
}


