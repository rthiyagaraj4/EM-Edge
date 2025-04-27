function callPatientSearch()
{
	var pat_id =  PatientSearch('','','','','','','Y','','','OTHER');

	if(pat_id != null){
		IPPrintPatientWristbandCriteria_form.patient_id.value = pat_id;
		parent.f_query_add_mod.document.IPPrintPatientWristbandCriteria_form.encounter_id_but.disabled=false;
		 }else{
		parent.f_query_add_mod.document.IPPrintPatientWristbandCriteria_form.encounter_id_but.disabled=true;
	}
}


async function encounter_search(obj,target)
{		
		var retVal = 	new String();
		var dialogHeight	= "70vh" ;
		var dialogWidth	= "60vw" ;
		var dialogTop		= "190" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;		
		
		var patientid = IPPrintPatientWristbandCriteria_form.patient_id.value;		
		var p_facility_id = IPPrintPatientWristbandCriteria_form.p_facility_id.value;		
		retVal = await window.showModalDialog("../../eIP/jsp/IPEncounterDisplayFrame_WristBband.jsp?patient_id="+patientid,arguments,features);	
		if(retVal !=null){
			//target.value = retVal;
			var retValArr=retVal.split("~");
			var care_locn_type=retValArr[1];
			var dest_locn_code=retValArr[2];
			target.value = retValArr[0];
			//submitPage();
			var sql="select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'IP' AND REPORT_ID in('IPBWBLBW','IPBWBLBB','IPBWBLBR') and language_id = 'en'";
			var reportParamNames="p_facility_id,p_module_id,p_encounter_id,p_patient_id";
			var reportParamValues=p_facility_id+",IP,"+target.value+","+patientid;
			//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the Query String.
			var getUrl			= "../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=IP_PRINT_PATIENT_WRISTBAND&rep_id=IPBWBLBW&step=1&sqlString=" + sql + "&reportParamNames="+reportParamNames+"&reportParamValues=" + reportParamValues + "&Patient_ID="+patientid+"&encounter_id="+target.value+"&dest_locn_type="+care_locn_type+"&dest_locn_code="+dest_locn_code;
			parent.frames[2].location.href=getUrl;
		}else{
			target.value ="";
			parent.f_query_add_mod1.location.href='../../eCommon/html/blank.html';
		}
}

function ValidateEncID(obj)
{
	if(obj.value!=''){
		var HTMLVal = new String();		
		var enc_id=obj.value;
		var flag="encounter_details";
		var patient_id=IPPrintPatientWristbandCriteria_form.patient_id.value;

		HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message' onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eIP/jsp/IPEncounterDisplay_WristBand.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='enc_id' id='enc_id' value='"+enc_id+"'><input type='hidden' name='flag' id='flag' value='"+flag+"'></form></BODY></HTML>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.form1.submit();
	}else{
		parent.f_query_add_mod1.location.href='../../eCommon/html/blank.html';
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	}
}

function validSplchars1(obj) {	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]=getLabel("Common.encounterid.label","common");
	if(SpecialCharCheck( fields, names,'',"A",'')) {
		return true;
	} else {
		obj.select();
		obj.focus();
		return false;
	}
}

function reset()
{
	f_query_add_mod.document.forms[0].reset();
	//f_query_add_mod.document.forms[0].encounter_id_but.disabled = true;
	f_query_add_mod1.location.href = "../../eCommon/html/blank.html";
}

function apply_wristband()
{	
	var obj=document.IPPrintPatientWristbandResult_form;
	if(obj.White.checked==false && obj.Blue.checked==false && obj.Red.checked==false)
		alert(getMessage('SELCT_CHECK_BOX','IP'));
	else	
		obj.submit();
}

function validSplchars1(obj)
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]="Encounter ID";
	if(SpecialCharCheck( fields, names,'',"A",''))
		return true;
	else
	{
		obj.select();
		obj.focus();
		return false;
	}
}

function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid = document.forms[0].p_facility_id.value;
	var tit="";	
	var locale = document.forms[0].p_locale.value;
		
	target.value=trimString(target.value);

	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);

	if(obj.name=="fromlocn")
    {
        tit=getLabel("Common.Location.label","Common");
		
		argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
                
		argumentArray[1]=new Array("facility_id");
		argumentArray[2]=new Array(facilityid);
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;                
    }	
	
	var retVal=CommonLookup(tit,argumentArray);

	if(retVal==null || retVal=="")
		target.value="";
	else
		target.value=retVal[1];
		            
}

function submitPage()
{
	var patient_id=document.forms[0].patient_id.value;
	var encounter_id=document.forms[0].encounter_id.value;
	//var location_desc=document.forms[0].location_desc.value;
	//parent.frames[2].location.href='../../eIP/jsp/IPPrintPatientWristbandResult.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id+'&location_desc='+location_desc;
	if(encounter_id==""){
		alert('encounter id is mandatory');
	}else{
		parent.f_query_add_mod1.location.href='../../eIP/jsp/IPPrintPatientWristbandResult.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id;
	}
}
function clearAll()
{
	parent.frames[2].location.href='../../eCommon/html/blank.html';
}

function changeReportID(obj)
{	
	if(obj.name=='White')
	{
		if(obj.checked)					
			document.IPPrintPatientWristbandResult_form.White.value='Y';			
		else		
			document.IPPrintPatientWristbandResult_form.White.value='N';
	}
	else if(obj.name=='Blue')
	{
		if(obj.checked)				
			document.IPPrintPatientWristbandResult_form.Blue.value='Y';		
		else		
			document.IPPrintPatientWristbandResult_form.Blue.value='N';		
	}
	else if(obj.name=='Red')
	{
		if(obj.checked)					
			document.IPPrintPatientWristbandResult_form.Red.value='Y';		
		else		
			document.IPPrintPatientWristbandResult_form.Red.value='N';		
	}	
}
function enableID()
{
	/*if(document.forms[0].patient_id.value == "")
		document.forms[0].encounter_id_but.disabled = true;
	else
	    document.forms[0].encounter_id_but.disabled = false;*/
}

function Checkvalidpat(obj)
{
	pat_id=obj.value;	
	if(pat_id !="")
	{
		HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message' onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eIP/jsp/AdmissionValidation.jsp'><input type='hidden' name='checkpat' id='checkpat' value= 'wristband'><input type='hidden' name='patient_id' id='patient_id' value='"+pat_id+"'></form></BODY></HTML>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.form1.submit();
	}

}

