//This file is saved on 26/10/2005

var message="";
/*********************************************************/
function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/AssessmentNoteHeader.jsp?mode=1";
}
/*********************************************************/
async function viewAgeGroup(target)
{
	var frmobj=parent.f_query_add_mod.document.form_add_mod ;
	frmobj.assess_note_desc.value="";
    var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray[0] = "locale";
	dataValueArray[0]= frmobj.locale.value;
	dataTypeArray[0] = STRING;

 	argumentArray[0] ="select note_type code, note_type_desc description from ca_note_type_lang_vw where NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID='CP_ASSESSMENT') and language_id like ? AND UPPER(note_type) LIKE UPPER(?) AND UPPER(note_type_desc) LIKE UPPER(?) and eff_Status = 'E' ORDER BY note_type_desc";
	
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = await CommonLookup(getLabel("Common.note.label","Common"), argumentArray );

		if(retVal != null && retVal != "") {
			var ret1=unescape(retVal);
			 var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
			target.value = arr[0] ;
			
			document.forms[0].assess_note_id.value = arr[0];
			document.forms[0].assess_desc.value=arr[1];
			//var note_id=retVal[0];
			var note_id=arr[0];
		    var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			//to get the period for selected requirement
			xmlHttp.open( "POST","../../eCP/jsp/AssessmentNoteFrameSet.jsp?note_id="+note_id+"&flag=true", false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}
		else
			target.value ="";
}

/*********************************************************/
/* function viewAgeGroup1(target)
{
	var frmobj=parent.f_query_add_mod.document.form_add_mod ;
	frmobj.reassess_intervention_desc.value="";
	 var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	

 	argumentArray[0] ="Select intervention_code code, short_desc  description from ca_intervention where eff_status = 'E'  AND UPPER(intervention_code) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?) ORDER BY short_desc";
	
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = CommonLookup("Reassessment", argumentArray );
		if(retVal != null && retVal != "") {
			target.value = retVal[1] ;
			document.forms[0].reassess_intervention_code.value = retVal[0];
			
		}else
			target.value ="";
}*/
/*********************************************************/
function query()
{
	f_query_add_mod.location.href="../../eCP/jsp/AssessmentNoteQueryCriteria.jsp";
}
/*********************************************************/
function display(obj1,obj2)
{
var frmObj=parent.frames[1].document.forms[0];

var note_desc_1=frmObj.note_desc.value;
var inpatient_1=frmObj.inpatient1.value;

obj1.innerText="   "+note_desc_1;
obj2.innerText="   "+inpatient_1;
}
/*********************************************************/
function assignDateRange(note_desc_fs,inpatient_fs)
{

var frmObj=parent.frames[1].document.forms[0];
frmObj.note_desc.value=note_desc_fs;
frmObj.inpatient1.value= inpatient_fs;

//display method not being called, set below itself
document.getElementById("note_desc1").innerText="   "+note_desc_fs;
document.getElementById("inpatient").innerText="   "+inpatient_fs;

}
/*********************************************************/
function apply()
{
		if (! checkIsValidForProceed() ) {
		   message  = getMessage("APPLY_NOT_VALID","CP");
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
		}

	if (! checkIsValidForProceed() ) {
	     message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}
	 if (!checkIsValidForProceed1()){
		 message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		 message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	//var messageFrame = parent.frames[1].frames[2]; 
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	var frmobj=f_query_add_mod.document.form_add_mod ;
	var mode=frmobj.mode.value;
	
	if(mode=="2")
	{
		
		assess_note_id=frmobj.assess_note_desc.value;
		//reassess_intervention_code=frmobj.reassess_intervention_code.value;
		//reassess_intervention_desc=frmobj.reassess_intervention_desc.value;
		assess_note_desc=frmobj.assess_desc.value;
		eff_status=frmobj.eff_status.value;

		qry_str="&assess_note_id="+frmobj.assess_note_id.value+"&assess_note_desc="+frmobj.assess_desc.value+"&eff_status="+frmobj.eff_status.value;
	}
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	var fields = new Array (frmobj.assess_note_desc);
			    
	var names = new Array (getLabel("Common.note.label","Common"));
					 
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
				frmobj.submit();
	}
	
}	
/*********************************************************/
function checkActive(target)
{
	if(target.checked==false)
	{
		target.value="D";
		target.checked=false;
	}
	else
	{
		target.value="E";
		target.checked=true;
	}
}
/*********************************************************/
function onSuccess(){	 
	var frmobj=f_query_add_mod.document.form_add_mod ;
	var mode=frmobj.mode.value;
	if(( mode == "1" ))
	{
		f_query_add_mod.location.href='../../eCP/jsp/AssessmentNoteHeader.jsp?mode=1';
	}
	else if(mode=="2")
	{
		assess_note_id=frmobj.assess_note_desc.value;
		//reassess_intervention_code=frmobj.reassess_intervention_code.value;
		//reassess_intervention_desc=frmobj.reassess_intervention_desc.value;
		eff_status=frmobj.eff_status.value;
		assess_note_desc=frmobj.assess_desc.value;
		
		qry_str="&assess_note_id="+assess_note_id+"&assess_note_desc="+assess_note_desc+"&Enabled="+eff_status;
		f_query_add_mod.location.href='../../eCP/jsp/AssessmentNoteHeader.jsp?mode=2'+qry_str;
	}
	
}
/*********************************************************/
function reset()
{
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
	 if(url.indexOf("AssessmentNoteQueryCriteria.jsp")==-1){
	var formObj=f_query_add_mod.document;
	if(formObj.forms[0].name=='form_add_mod'){
	   formObj.location.reload();
	      }
	   }
	
	 }
}	
/*********************************************************/
	function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
/*********************************************************/
function checkIsValidForProceed1()
{		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
/*********************************************************/
function checkIsValidForProceed2()
{		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}

