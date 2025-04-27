  //saved on 02.11.2005
function run() {
	
	 	var frmObject = f_query_add_mod.document.formPhIVDispLabelCriteria;		
//|| frmObject.p_disp_date.value==""

		var stage = frmObject.stage.value;
		var rprtType = frmObject.p_report_id1.value;
		var dsdl = frmObject.dsdl.value;

		if(frmObject.p_patient_id.value=="" ) {
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("DISP_DT_OR_PATIENT_ID_NOT_BLANK") ;
		} else	if(frmObject.p_disp_fm_no.value!="" && frmObject.p_disp_to_no.value!=""){
			
			if(dsdl == "DispLabel"){
				if(stage =="F" || stage =="A" ){
					if(rprtType == "IVA"){
						frmObject.p_report_id.value = "PHRIVCONTFILL";
					}else if(rprtType == "IVWA"){
						frmObject.p_report_id.value = "PHRFILLCONWOADD";
					}else if(rprtType == "IVI"){
						frmObject.p_report_id.value = "PHRIVINTTFILL";
					}else if(rprtType == "ONC"){
						frmObject.p_report_id.value = "PHRCYTOLBFILL";
					}else if(rprtType == "TPN"){
						frmObject.p_report_id.value = "PHRTPNDISPLBFILL";
						frmObject.p_pat_class=frmObject.p_patient_class.value;
					}
				}else if(stage =="D" ){
					if(rprtType == "IVA"){
						frmObject.p_report_id.value = "PHRIVCONT";
					}else if(rprtType == "IVWA"){
						frmObject.p_report_id.value = "PHRIVCONTWOADD";
					}else if(rprtType == "IVI"){
						frmObject.p_report_id.value = "PHRIVINTT";
					}else if(rprtType == "ONC"){
						frmObject.p_report_id.value = "PHRCYTOLBFILL";
					}else if(rprtType == "TPN"){
						frmObject.p_report_id.value = "PHRTPNDISPLBDL";
						frmObject.p_pat_class.value=frmObject.p_patient_class.value;
					}
				}
			}else if(dsdl == "DispSheet"){
				if(stage =="F" || stage =="A" ){
					if(rprtType == "IVA" || rprtType == "IVWA"){
						frmObject.p_report_id.value = "PHPRDISSHCONFILL";
					}else if(rprtType == "IVI"){
						frmObject.p_report_id.value = "PHPRDISSHINTFILL";
					}else if(rprtType == "ONC"){
						frmObject.p_report_id.value = "PHCYTODISSHFL";
					}else if(rprtType == "TPN"){
						frmObject.p_report_id.value = "PHRDISSHTPNFILL";
					}
				}else if(stage =="D" ){
					if(rprtType == "IVA" || rprtType == "IVWA"){
						frmObject.p_report_id.value = "PHPRDISSHIVCONT";
					}else if(rprtType == "IVI"){
						frmObject.p_report_id.value = "PHPRDISSHIVINTT";
					}else if(rprtType == "ONC"){
						frmObject.p_report_id.value = "PHCYTODISSHDL";
					}else if(rprtType == "TPN"){
						frmObject.p_report_id.value = "PHRDISSHTPNDEL";
					}
					frmObject.p_disp_fm_no.value = frmObject.p_disp_no.value;
					frmObject.p_disp_to_no.value = frmObject.p_disp_no.value;
				}
			}
			
			if(frmObject.p_disp_no.value != ""){
				frmObject.submit();
			}else{
				alert("Please select any Disp No");
			}

		} else {
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA"));
		}
	
}




function reset() {
    f_query_add_mod.formPhIVDispLabelCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

//for patient lookup
function callPatientSearch(target){

	var patient_id = PatientSearch();
 if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;
 }
}



function searchPractitionerName(target, mode) {
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= f_query_add_mod.document.formPhMednStatByPractCriteria.p_user_name.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= f_query_add_mod.document.formPhMednStatByPractCriteria.p_facility_code.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= f_query_add_mod.document.formPhMednStatByPractCriteria.p_facility_code.value;
	dataTypeArray[2]	= STRING ;

	argumentArray[0] = f_query_add_mod.document.formPhMednStatByPractCriteria.sql_ph_medn_stat_pract_select1.value+"'"+f_query_add_mod.document.formPhMednStatByPractCriteria.language_id.value+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4,5";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;

	retArray = CommonLookup( "Practitioner Search", argumentArray );
	
	if(retArray != null && retArray != "") {
		if (mode == 1)
			f_query_add_mod.document.formPhMednStatByPractCriteria.pract_id.value = retArray[0];
		else if (mode == 2)
			f_query_add_mod.document.formPhMednStatByPractCriteria.tpract_id.value = retArray[0];

		target.value = retArray[1];
	}
}

function callDrugSearch(obj) {
	var arrCodeDesc = DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		document.formPhRepDispStatByDrugCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}








function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN"));
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}

/*function ValidateFrom(from,to) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert("Should be Greater than Current Time");
	to.select();
	result	=	false;
	}

return result;
}*/

function ValidateFrom(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert("Should be Greater than Current Time");
	to.select();
	result	=	false;
	}
	else
	{
		if(!ValidateDateTime(to,en)) {
			alert("Should be Less than Sysdate ");
        	to.select();
			result	=	false;
		}
	}

return result;
}

function ValidateTo(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert("Should be Greater than From Time");
	to.select();
	to.focus();
	result	=	false;
	}
	else
	{
		if(!ValidateDateTime(to,en)) {
			alert("Should be Less than Sysdate + 1 ");
        	to.select();
			result	=	false;
			to.focus();
		}
	}

return result;
}

function checkPatientClass(p_disp_no)	{
	var frmObject = parent.f_query_add_mod.document.formPhIVDispLabelCriteria;
		var disp_no		=	frmObject.disp_no.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " disp_no=\""+disp_no+"\"";
		xmlStr += " bean_id=\"DispMedicationAllStages\"";
		xmlStr += " bean_name=\"ePH.DispMedicationAllStages\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DispMedicationValidation.jsp?func_mode=get_pat_class",false);
//		alert(xmlStr);
		xmlHttp.send(xmlDoc);
//		alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);
}

function assignPatientClass(pat_class) {
	var frmObject	= parent.f_query_add_mod.document.formPhIVDispLabelCriteria;	
	var result		= pat_class.split("::");

	frmObject.p_patient_id.value=result[1];
}

function defaultLocalLanguage(formObj){
	
		var xmlStr ="<root><SEARCH ";
		xmlStr += " patient_class=\""+formObj.value+"\"";
		xmlStr += " bean_id=\"DispMedicationAllStages\"";
		xmlStr += " bean_name=\"ePH.DispMedicationAllStages\"";
		xmlStr +=" /></root>";
		var temp_jsp="DispMedicationValidation.jsp?func_mode=getLocalLanguage";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);	
}



function populateDispNo() {	
	var frmObject		=   parent.f_query_add_mod.document.formPhIVDispLabelCriteria;
		frmObject.iv_type.innerText = "";
	var p_patient_id	=	frmObject.p_patient_id.value;
	if(p_patient_id=="")
		return false;
	var p_disp_date		=	frmObject.p_disp_date.value;
	var p_pat_class		=	frmObject.p_patient_class.value;
	var stage			=	frmObject.stage.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " p_patient_id=\""+p_patient_id+"\"";
	xmlStr += " p_disp_date=\""+p_disp_date+"\"";
	xmlStr += " p_pat_class=\""+p_pat_class+"\"";
	xmlStr += " stage=\""+stage+"\"";
	xmlStr += " bean_id=\"PHRepDispStatisByDispBean\"";
	xmlStr += " bean_name=\"ePH.PHRepDispStatisByDispBean\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ReportsValidate.jsp?called_from=populateDispNo",false);
	//alert(xmlStr);
	xmlHttp.send(xmlDoc);
	alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);

}
function clearDispNos(){
		var len =document.formPhIVDispLabelCriteria.disp_no.options.length;
		for(var i=0;i<len;i++) {
			document.formPhIVDispLabelCriteria.disp_no.remove("stage") ;
		}
		var element			= document.createElement('OPTION') ;
		element.value		=  "" ;
		element.text		=  "---- Select ----" ;
		document.formPhIVDispLabelCriteria.disp_no.add(element);
}
function loadDispNos(disp_no,ivPrepYn){

		var element			= document.createElement('OPTION') ;
		element.value		=  disp_no+'~'+ivPrepYn ;
		element.text		=  disp_no ;
		document.formPhIVDispLabelCriteria.disp_no.add(element);
}
function setType(obj){
	
	var value = obj.value;
	var disp_no;
	var iv_prep;
	var valArray = new Array();

	valArray = value.split("~");
       disp_no = valArray[0];
	   iv_prep = valArray[1];

	   if(iv_prep == "1"){
			document.formPhIVDispLabelCriteria.p_report_id1.value = "IVA";
			document.formPhIVDispLabelCriteria.iv_type.innerText = "IV With Additives";
	   }else if(iv_prep == "3"){
			document.formPhIVDispLabelCriteria.p_report_id1.value = "IVI";
			document.formPhIVDispLabelCriteria.iv_type.innerText = "IV Intermittent";
	   }else if(iv_prep == "5"){
			document.formPhIVDispLabelCriteria.p_report_id1.value = "IVWA";
			document.formPhIVDispLabelCriteria.iv_type.innerText = "IV WithOut Additives";
	   }else if(iv_prep == "7"){
			document.formPhIVDispLabelCriteria.p_report_id1.value = "TPN";
			document.formPhIVDispLabelCriteria.iv_type.innerText = "TPN Standard";
	   }else if(iv_prep == "9"){
			document.formPhIVDispLabelCriteria.p_report_id1.value = "ONC";
			document.formPhIVDispLabelCriteria.iv_type.innerText = "Oncology";
	   }else {
			document.formPhIVDispLabelCriteria.iv_type.innerText = "";
	   }
	document.formPhIVDispLabelCriteria.p_disp_no.value = disp_no;

}

function setDispNos(fm_disp_no,to_disp_no) {
	
	document.formPhIVDispLabelCriteria.p_disp_fm_no.value=fm_disp_no;
	document.formPhIVDispLabelCriteria.p_disp_to_no.value=to_disp_no;
}

function setStage(obj){

	var len =document.formPhIVDispLabelCriteria.stage.options.length;

	for(var i=0;i<len;i++) {
		document.formPhIVDispLabelCriteria.stage.remove("stage") ;
	}

	if(obj.value == "IP"){
		document.formPhIVDispLabelCriteria.p_patient_class.value = "IP";
		var opt = document.createElement("OPTION") ;
		opt.text = "Filling";
		opt.value = "F" ;
		document.formPhIVDispLabelCriteria.stage.add(opt);

		var opt = document.createElement("OPTION") ;
		opt.text = "Delivery";
		opt.value = "D" ;
		document.formPhIVDispLabelCriteria.stage.add(opt);
	}else if(obj.value == "OP"){
		document.formPhIVDispLabelCriteria.p_patient_class.value = "OP";
		var opt = document.createElement("OPTION") ;
		opt.text = "Allocation";
		opt.value = "A" ;
		document.formPhIVDispLabelCriteria.stage.add(opt);

		var opt = document.createElement("OPTION") ;
		opt.text = "Delivery";
		opt.value = "D" ;
		document.formPhIVDispLabelCriteria.stage.add(opt);
	}
}

function SetLabelLang(){

}
