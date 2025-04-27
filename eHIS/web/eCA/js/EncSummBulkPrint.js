//Created by Sethuraman for encounter Summary requirements

var summCount = 0;
var summDesc = "";

function clearList()
{
	document.forms[0].Qloc.value="";    
	document.forms[0].Qloc1.value="";     
}

function setEncounter(obj)
{
	
	var patientCount = document.getElementById("patientCount").value;

	var l_patient_id_label = "";
	var l_encounter_id_label = "";
	var l_sec_chk_label = "";

	var l_patient_id = "";
	var l_encounter_id = "";

	var patientObj = new Object();

	if(obj.checked == true)
	{
		for (var i = 0; i < patientCount; i++) {

			patientObj = new Object();

			l_patient_id = "";
			l_encounter_id = "";
			l_patient_id_label = "patientId" + i;
			l_encounter_id_label = "encounterId" + i;

			l_sec_chk_label = "secChk"+i;

			l_patient_id = document.getElementById(l_patient_id_label).value;
			l_encounter_id = document.getElementById(l_encounter_id_label).value;

			patientObj.patientId = l_patient_id;
			patientObj.encounterId = l_encounter_id;

			parent.patientArray.push(patientObj);	
			
			document.getElementById(l_sec_chk_label).checked = true;
		}
	}
	else
	{
		patientObj = new Object();

		parent.patientArray.length = 0;

		for (var i = 0; i < patientCount; i++) {		

			l_sec_chk_label = "secChk"+i;			
			
			document.getElementById(l_sec_chk_label).checked = false;
		}
	}
	
}

function onBlurgetLoc(loginuser,oper_id,fac_id,objval,target)
{	 
	if(target.value == "")
	{
		target.value="";
		document.forms[0].Qloc.value="";
		return;
	}
	getLocn(loginuser,oper_id,fac_id,objval,target);
}

function setEncounterValue(obj,patientId,encounterId)
{	
	var patientObj = new Object();
	var objIndex = 0;
	patientObj.patientId = patientId;
	patientObj.encounterId = encounterId;
	
	if(obj.checked == true)
	{	
		patientObj.patientId = patientId;
		patientObj.encounterId = encounterId;

		parent.patientArray.push(patientObj);		
	}
	else
	{
		objIndex = arrIndexOf(patientObj);
		if (objIndex>=0){
			parent.patientArray.splice(objIndex, 1);
		}
	}	
}
function arrIndexOf(obj) {    
    for (var i = 0; i < parent.patientArray.length; i++) {
        if (parent.patientArray[i].patientId == obj.patientId && parent.patientArray[i].encounterId == obj.encounterId) {
            return i;
        }
    }
    return -1;
}

/*
function viewEncounterSummary(patientId,encounterId)
{		
	var dialogHeight= "800px" ;
	var dialogWidth	= "1200px" ;
	var dialogTop	= "10";
	var dialogLeft	= "10";
	var arguments	= "" ;
	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no;help:no ";
	
	var ret = window.showModalDialog("../../eCA/jsp/EncounterSummaryGH_Kendo_XML.jsp?patient_id="+patientId+"&encounter_id="+encounterId,arguments,features);	
}
*/
function checkForSummary(patId, encId)
{	
	
	var patientId = ""; 
	var encounterId = "";	
	
	var xmlStr = "";
	
	patientId = patId;
	encounterId = encId;
	
	summCount = 0;
	summDesc = "";

	showPleaseWait();
	//hidePleaseWait();

	var errorMsg = "";
	
	var summArray = null;
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();	

	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/EncSummCheckForCode.jsp?patientId="+patientId+"&encounterId="+encounterId, false);

	xmlHttp.send(xmlDoc);

	responseText=xmlHttp.responseText;

	responseText = trimString(responseText);
	eval(responseText);	

	//alert(responseText);
	
	errorMsg = getMessage("SUMMARY_NOT_CONFIGURED",'CA');
	if (summCount == 0){
		hidePleaseWait();
		alert(errorMsg);
		return false;
	}
	if (summCount == 1)
	{	
		if (recordCount == 0){
			hidePleaseWait();
			errorMsg = getMessage("RESULTS_NOT_AVAILABLE",'CA');
			alert(errorMsg);
			return;
		}
		summArray = summDesc.split("~");	
		
		viewEncounterSummary(patientId,encounterId, summArray[0]);	
		hidePleaseWait();
	}
	else if (summCount > 1)
	{				
		hidePleaseWait();
		showSelectSummaryWindow(patientId,encounterId,summDesc);
	}		
}

function showSelectSummaryWindow(patientId,encounterId,summDesc)
{	
	var dialogHeight= "300px" ;
	var dialogWidth	= "500px" ;
	var dialogTop	= "300";
	var dialogLeft	= "300";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no;help:no ";
	var ret = window.showModalDialog("../../eCA/jsp/EncSummSelectCode.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&summDesc="+summDesc,arguments,features);
	
}

function PrintSummary()
{
	var patientId = ""; 
	var encounterId = "";	
	
	var hideFeatures	= "toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left=10000, top=10000, width=10, height=10, visible=none ";
	var arguments	= "" ;
	
	var xmlStr = "";	
	var errorMsg = "";
	var errorFlag = false;
	
	var summArray = null;
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();	
	
	errorMsg = getMessage("RESULTS_NOT_AVAILABLE",'CA');
	
	 var pb = $("#progressBar").data("kendoProgressBar");
     pb.value(0);
     clearInterval(100);

	
	for (var i = 0; i < parent.patientArray.length; i++) {		
		patientId = parent.patientArray[i].patientId;
		encounterId = parent.patientArray[i].encounterId;
		
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/EncSummCheckForCode.jsp?patientId="+patientId+"&encounterId="+encounterId, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
		
		if (summCount == 0){
			errorMsg = getMessage("SUMMARY_NOT_CONFIGURED",'CA');
			alert(errorMsg);
			return false;
		}
		if (summCount == 1)
		{	
			if (recordCount == 0){
				errorMsg = errorMsg + "\n" + "Patient ID: "+patientId+ " Encounter ID: "+encounterId;
				errorFlag = true;
			}
			else
			{
				summArray = summDesc.split("~");
				var ret = window.open("../../eCA/jsp/EncounterSummaryGH_Kendo_XML.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&summCode="+summArray[0]+"&printFlag=1",arguments, hideFeatures);				
				if (pb.value() < parent.patientArray.length) {
	                pb.value(pb.value() + 1);	              
	            } 
			}
		}
	}
	if (errorFlag){
		alert(errorMsg);
	}
}

function viewEncounterSummary(patientId,encounterId, summCode)
{			
	var dialogHeight= "800px" ;
	var dialogWidth	= "1200px" ;
	var dialogTop	= "10";
	var dialogLeft	= "10";
	var arguments	= "" ;
	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no;help:no ";
	var ret = window.showModalDialog("../../eCA/jsp/EncounterSummaryGH_Kendo_XML.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&summCode="+summCode+"&printFlag=0",arguments,features);
	
	//var showFeatures	= "toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left=10, top=10, width=1200px, height=800px, visible=none";		
	//var ret = window.open("../../eCA/jsp/EncounterSummaryGH_Kendo_XML.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&summCode="+summCode+"&printFlag=0",arguments,showFeatures);
	
}

function getLocn(loginuser,oper_id,fac_id,objval,target)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
   	var dataValueArray = new Array() ;
   	var dataTypeArray  = new Array() ;
   	var tit="";				
   	locale=document.forms[0].locale.value; 
   	spec_code=document.forms[0].Qspeciality.value;
   	tit=getLabel("Common.Location.label",'Common');

   	sql ="SELECT a.clinic_code code, a.long_desc description FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+fac_id+"' AND a.language_id='"+locale+"' AND a.level_of_care_ind = 'A' AND a.eff_status='E' AND a.clinic_type = '"+objval+"' and a.facility_id = b.facility_id  AND a.clinic_code = b.locn_code and b.appl_user_id = '"+loginuser+"' and b.oper_stn_id = '"+oper_id+"' and b.manage_queue_yn = 'Y' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) and a.CLINIC_TYPE=b.LOCN_TYPE and a.rd_appl_yn = 'N' ";

	if(!spec_code=="")
	{
		sql=sql+" and a.service_code='"+spec_code+"' ORDER BY  2";
	}
	else
	{
		sql=sql+"  ORDER BY  2";
	}   
  		
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	
	retVal = await CommonLookup( tit, argumentArray );	
	
	if(retVal != null && retVal != "" )
    {
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		document.forms[0].Qloc.value=arr[0];
	}
}

function callGetPractitioner(obj,target)
{
	
	var facility_id = document.forms[0].facility_id.value;

    target.value=trimString(target.value);
	if(target.value=="" && window.event.target == target)
	{
		document.forms[0].Qpr.value="";
		return;
	}
	
	if(document.forms[0].Qspeciality && document.forms[0].Qspeciality.value!=null)
		speciality=document.forms[0].Qspeciality.value;     
	
	getPractitioner(obj,target,facility_id,speciality,'','','','','','',"Q2");
					
}

function PractLookupRetVal(retVal,objName)
{
	var arr;

	if (retVal != null)
	{
		arr=retVal.split("~");		
		
		document.forms[0].Qpr.value = arr[0];
		document.forms[0].pract_name.value = arr[1];
	}
	else
	{		
		document.forms[0].Qpr.value="";
		document.forms[0].pract_name.value="";					
	}
}

function CheckNumberEntry(obj)
{
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) 
	{		
		//	refresh_records();
	}
	else
	{
		if ( obj.value.length > 0 ) 
		{
			alert(getMessage("NUM_ALLOWED","SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
}

function dateLength(dt)
{
	var splitValArray=new Array(2);
	splitValArray=obj.value.split(":");
	var DTlen = splitValArray[1].length;

	if(DTlen > 2)
		return false;
	else
		return true;
}

function validateTIme(obj)
{	
	if(obj.value != "")
	{
		if(validDate(obj.value,"HM",localeName) == false)
		{
			alert(getMessage("INVALID_TIME_FMT","SM"));
			obj.select();
		}
		else 
			return true;
	}
}

function SearchPatientEncounters()
{
	var specialtyCode = document.BulkPrintHeaderForm.Qspeciality.value;
	var locnType = document.BulkPrintHeaderForm.Qloctype.value;
	var locnCode = document.BulkPrintHeaderForm.Qloc.value;
	var practId = document.BulkPrintHeaderForm.Qpr.value;
	var searchDate = document.BulkPrintHeaderForm.Qdate.value;
	var patientId = document.BulkPrintHeaderForm.Qpatientid.value;
	var encounterId = document.BulkPrintHeaderForm.Qencid.value;
	var gender = document.BulkPrintHeaderForm.Qgender.value;
	
	var qString = "";
	
	qString = 'specialtyCode='+specialtyCode+'&locnType='+locnType+'&locnCode='+locnCode+'&practId='+practId+'&searchDate='+searchDate+'&patientId='+patientId+'&encounterId='+encounterId+'&gender='+gender;
	
	parent.EncSummBulkListFrame.location.href = '../../eCA/jsp/EncSummBulkPrintList.jsp?'+qString;
	parent.patientArray = new Array();
	//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}

function ClearValues()
{
	parent.EncSummBulkHeaderFrame.location.href="../../eCA/jsp/EncSummBulkPrintHeader.jsp";
	parent.EncSummBulkListFrame.location.href="../../eCommon/html/blank.html";
}

function showPleaseWait() {   

	// Get the modal
	//var modal = document.getElementById("myModal");
	//modal.style.display = "block";
	//$("#myModal").modal("show");
	$(".popup-overlay, .popup-content").addClass("active");
}

/**
 * Hides "Please wait" overlay. See function showPleaseWait().
 */
function hidePleaseWait() {
	//var modal = document.getElementById("myModal");
	//modal.style.display = "none";

	$(".popup-overlay, .popup-content").removeClass("active");
	//$("#pleaseWaitDialog").modal("hide");
}
