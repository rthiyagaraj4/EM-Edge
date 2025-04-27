/*							
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name				Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

20/10/2020      IN073108    		Nijitha				20/10/2020       Ramesh G       ML-MMOH-CRF-1546
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

function delete_values(field)
{	
	document.clinialaudittraislreport.loca.value="";
	document.clinialaudittraislreport.locn_code.value="";	
}

function resetValues()
{
   parent.messageFrame.document.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}


function reset(){

  var formObj = parent.content.f_query_add_mod.clinialaudittraislreport;
  parent.content.f_query_clntaudittrialresult.location.href = '../../eCommon/html/blank.html';
  formObj.reset();
 
}

async function callPatientSearch(){
	var pat_id =await  PatientSearch();
	if(pat_id != null)
	{
			document.getElementById("patientId").value = pat_id;
			var frmObj=document.clinialaudittraislreport;
			resetValues();
	}
}	
	
async function patientEncounterDetailNew()
{
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop = "60" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var patId = document.clinialaudittraislreport.patientId.value;
	
	if(patId !="")
	{
		var retVal = await window.showModalDialog("../../eOR/jsp/RefusalOrderEncounterFrameSet.jsp?called_from=generic_atc&mode="+MODE_INSERT+"&patientId="+patId,arguments,features);	
		if(retVal != undefined && retVal != null)
		{
			var temp = retVal.split('$');
			var frmObj		= document.clinialaudittraislreport;
			frmObj.encounterId.value=temp[0];
			
		}
		
		resetValues();
	}
	else{
		var msg = getMessage("PATIENT_ID_CANNOT_BE_BLANK","CA");
		
		parent.messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
		
		return false;
	}
	
}	
	
function getNotegrp(obj)
{
	if(obj.value != ''){
		getNotegrpDesc();
	}else{
		document.clinialaudittraislreport.note_group_desc.value = "";
		document.clinialaudittraislreport.note_group_id.value = "";
	}
}	
	
async function  getNotegrpDesc()
{

	var patientId	=	document.clinialaudittraislreport.patientId.value;
	var encounterId		=	document.clinialaudittraislreport.encounterId.value;
	var messageFrameReference = parent.messageFrame;
	var	fields		=	new Array ( document.clinialaudittraislreport.patientId, document.clinialaudittraislreport.encounterId) ;
	var names		=	new Array (getLabel("Common.patientId.label","Common"),getLabel("Common.encounterid.label","COMMON"));
	
	if(!(checkFields(fields,names,messageFrameReference))){
		return false;
	}
	
	var sql = "SELECT DISTINCT b.note_group code, b.note_group_desc description FROM  CA_ENCNTR_NOTE a, ca_note_group b ,ca_note_type c WHERE B.NOTE_GROUP = c.NOTE_GROUP_ID AND A.NOTE_TYPE =C.NOTE_TYPE  and upper(b.note_group) like upper(?) and  upper(b.note_group_desc) like upper(?)  and  a.patient_id = '"+patientId+"'  AND a.encounter_id = '"+encounterId+"' order by 2";
	
	var title = getLabel("eCA.NoteGroup.label","CA");
	var target			= document.clinialaudittraislreport.note_group_desc;
	
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray =await CommonLookup( title, argArray );

	if(retArray != null && retArray !="")	
	{
		var str =unescape(retArray);
	 	var arr = str.split(",");
		document.clinialaudittraislreport.note_group_desc.value = arr[1];
		document.clinialaudittraislreport.note_group_id.value = arr[0];
							
	}else{
		document.clinialaudittraislreport.note_group_desc.value = "";
		document.clinialaudittraislreport.note_group_id.value = "";
	}
	resetValues();
	document.clinialaudittraislreport.note_type_txt.value = '';
	document.clinialaudittraislreport.note_type.value = '';
	
}	

function getNoteType(obj)
{
	if(obj.value != ''){
		getNoteTypeDesc();
	}else{
		document.clinialaudittraislreport.note_type_txt.value = '';
		document.clinialaudittraislreport.note_type.value = '';
	}
}

async function getNoteTypeDesc()
{
	var dialogTop	= "40";
	var dialogHeight	= "10" ;
	var dialogWidth= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	
	var patientId	=	document.clinialaudittraislreport.patientId.value;
	var encounterId		=	document.clinialaudittraislreport.encounterId.value;
	
	var messageFrameReference = parent.messageFrame;
	var	fields		=	new Array ( document.clinialaudittraislreport.patientId, document.clinialaudittraislreport.encounterId) ;
	var names		=	new Array (getLabel("Common.patientId.label","Common"),getLabel("Common.encounterid.label","COMMON"));
	
	if(!(checkFields(fields,names,messageFrameReference))){
		return false;
	}
	//var sql = "SELECT DISTINCT b.note_type code, b.note_type_desc description FROM  CA_ENCNTR_NOTE a, ca_note_type b  WHERE B.note_type = A.note_type and upper(b.note_type_desc) like upper(?) and  upper(b.note_type_desc) like upper(?)  and  a.patient_id = '"+patientId+"'  AND a.encounter_id = '"+encounterId+"' order by 2";
	var note_group_id;
	if(undefined!=document.clinialaudittraislreport.note_group_id && null!=document.clinialaudittraislreport.note_group_id.value  )
		note_group_id		=	document.clinialaudittraislreport.note_group_id.value;
	
	var sql = "SELECT DISTINCT b.note_type code, b.note_type_desc description FROM  CA_ENCNTR_NOTE a, ca_note_type b  WHERE B.note_type = A.note_type and upper(b.note_type_desc) like upper(?) and  upper(b.note_type_desc) like upper(?)  and  a.patient_id = '"+patientId+"'  AND a.encounter_id = '"+encounterId+"' #NOTE_GROUP_FILTER# order by 2";
	
	
	
	if(""!= document.clinialaudittraislreport.note_group_id.value)
	{
		sql = sql.replace("#NOTE_GROUP_FILTER#", "AND B.NOTE_GROUP_ID='"+note_group_id+"'");
	}	
	else{
		sql = sql.replace("#NOTE_GROUP_FILTER#", " ") ;
	}
	
	var title = getLabel("Common.NoteType.label","Common");
	var target = document.clinialaudittraislreport.note_type_txt;
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	retArray =await CommonLookup( title, argArray );

	if(retArray != null && retArray !="")	
	{
		var str =unescape(retArray);
	 	var arr = str.split(",");
			document.clinialaudittraislreport.note_type_txt.value = arr[1];
			document.clinialaudittraislreport.note_type.value = arr[0];
	}
	else
	{
			document.clinialaudittraislreport.note_type_txt.value = '';
			document.clinialaudittraislreport.note_type.value = '';
	}
	resetValues();
}
 
function getPractCode(obj)
 {
 	if(obj.value != ''){
		getPractitionerId13();
	}else{
		document.clinialaudittraislreport.practitioner_id.value = "";
 		document.clinialaudittraislreport.pctr.value = "";
	}		
 } 
 
async function getPractitionerId13(){
 	
	var patientId	=	document.clinialaudittraislreport.patientId.value;
	var encounterId		=	document.clinialaudittraislreport.encounterId.value;
	var messageFrameReference = parent.messageFrame;
	var	fields		=	new Array ( document.clinialaudittraislreport.patientId, document.clinialaudittraislreport.encounterId) ;
	var names		=	new Array (getLabel("Common.patientId.label","Common"),getLabel("Common.encounterid.label","COMMON"));
	
	if(!(checkFields(fields,names,messageFrameReference))){
		return false;
	}
	
 	
 	var search_code="";
 	var search_desc="";
 	var sql="";
 	search_code="practitioner_id";
 	search_desc= "practitioner_name";
	
	var target = document.clinialaudittraislreport.pctr;
	
 	sql ="select distinct b.practitioner_id code, b.practitioner_name description from CA_ENCNTR_NOTE a, am_practitioner b where b.practitioner_id = a.performed_by_id and b.eff_status='E' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?)  and  a.patient_id = '"+patientId+"'  AND a.encounter_id = '"+encounterId+"' order by 2";
 
 	
 	var title="Practitioner";
 	var serviceVal   ="";
 	var search_desc	= "";
 	var argArray = new Array();
 	var namesArray = new Array();
 	var valuesArray = new Array();
 	var datatypesArray = new Array();
 	argArray[0] = sql;
 	argArray[1] = namesArray;
 	argArray[2] = valuesArray;
 	argArray[3] = datatypesArray;
 	argArray[4] = "1,2";
 	argArray[5] = target.value;
 	argArray[6] = DESC_LINK;
 	argArray[7] = CODE_DESC;
 	retArray =await CommonLookup( title, argArray );

 	if (retArray != null && retArray != '' && retArray != "null")
 	{
 		var str =unescape(retArray);
	 	var arr = str.split(",");
 		document.clinialaudittraislreport.practitioner_id.value = arr[0];
 		document.clinialaudittraislreport.pctr.value = arr[1];
 	}else{
		document.clinialaudittraislreport.practitioner_id.value = "";
 		document.clinialaudittraislreport.pctr.value = "";
	}
	resetValues();
 }
 
function checkingDate(obj,format,locale)
{
	var from =document.forms[0].p_fm_Date;
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{
		if(!doDateCheckAlert(from,obj))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			/*obj.select();
			obj.focus();*/
			obj.value="";
		}
		if(isBeforeNow(obj.value,format,locale))
		{
			return true;
		}
		else
		{
			var label=getLabel("Common.DateRange.label","COMMON");
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");
			msg = msg.replace('$$',label);
			alert(msg);
			/*obj.select();
			obj.focus();*/
			obj.value="";
			return false;
		}
	}
	
	}

}

function Check_Date(obj,format,locale)
{
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{	
		if(isBeforeNow(obj.value,format,locale))
		{
			return true;
		}
		else
		{
			var label=getLabel("Common.DateRange.label","COMMON");
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");			
			msg = msg.replace('$$',label);
			alert(msg);
			/*obj.select();
			obj.focus()*/
			obj.value="";
			return false;
		}
	}	
	}
}
 
 

 function getResults(){
	 
		var patientId		=	document.clinialaudittraislreport.patientId.value;
		var encounterId		=	document.clinialaudittraislreport.encounterId.value;
		var note_group		=	document.clinialaudittraislreport.note_group_id.value;
		var note_type		=	document.clinialaudittraislreport.note_type.value;
		var practitioner_id	=	document.clinialaudittraislreport.practitioner_id.value;
		var p_fm_Date		=	document.clinialaudittraislreport.p_fm_Date.value;
		var p_to_Date		=	document.clinialaudittraislreport.p_to_Date.value
		var messageFrameReference = parent.messageFrame;
		var	fields		=	new Array ( parent.f_query_add_mod.document.clinialaudittraislreport.patientId, parent.f_query_add_mod.document.clinialaudittraislreport.encounterId) ;
		var names		=	new Array (getLabel("Common.patientId.label","Common"),getLabel("Common.encounterid.label","COMMON"));
		
		if(!(checkFields(fields,names,messageFrameReference))){
			return false;
		}	
		
		var query_string		=	"&p_fm_Date="+p_fm_Date+"&p_to_Date="+p_to_Date+"&note_type="+note_type +"&note_group="+note_group+"&patientId="+patientId+"&encounterId="+encounterId+"&authorised_by="+practitioner_id;
		parent.f_query_clntaudittrialresult.location.href = "../../eCA/jsp/ClinicalNoteAuditTrailResults.jsp?"+query_string;
		
 }
 async function showpreview(calledFromOption){	 
	
	var selectedRowValue  = "";	
	var selectedRow = parent.f_query_clntaudittrialresult.document.getElementsByName('selectedRow'); 	
	for(i = 0; i < selectedRow.length; i++) { 
		if(selectedRow[i].checked) 
			selectedRowValue= selectedRow[i].value; 
	} 
	if(selectedRowValue ==""){
		alert("Atleast one Report Result to be selected");
	}else{
		var accessionNum = parent.f_query_clntaudittrialresult.document.getElementById("accessionNum"+selectedRowValue).value;
		var noteType = parent.f_query_clntaudittrialresult.document.getElementById("noteType"+selectedRowValue).value;
		var recordedFacility = parent.f_query_clntaudittrialresult.document.getElementById("recordedFacility"+selectedRowValue).value;
		
		var patient_id	=	document.clinialaudittraislreport.patientId.value;
		var encounter_id		=	document.clinialaudittraislreport.encounterId.value;
		var dialogTop	= "80";
		var dialogHeight= "40" ;
		var dialogWidth	= "60" ;
		var arguments = "";
		var features	= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scrollbars=yes;	resizable=yes; fullscreen=no;" ;
		
		var retVal =await window.showModalDialog("../../eCA/jsp/ClinicalNoteAuditTrialPrintPreview.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&called_from=&accessionNum="+accessionNum+"&noteType="+noteType+"&recordedFacility="+recordedFacility+"&calledFromOption="+calledFromOption,arguments,features);
	}
	
 }
 
