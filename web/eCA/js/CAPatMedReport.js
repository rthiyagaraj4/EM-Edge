function apply() {

	var fnName = f_query_add_mod_upper.document.PatMedReportSearch_form.fnName.value;
	var NoteTypeID = f_query_add_mod_upper.document.PatMedReportSearch_form.NoteTypeID.value;
	var cntRecord = 0;
	var cntRecord1 = 0;
	//if(fnName == "Encounter Details") 
	if(fnName == "CAMS_ENC_DTL_FOR_PMR") 
	{
		if(f_query_add_mod_lower.document.PatMedEncounterDetails_form!=null)
		{
			f_query_add_mod_lower.document.PatMedEncounterDetails_form.fnName.value=fnName;

	/*    if(!(f_query_add_mod_lower.document.PatMedEncounterDetails_form.inpatient_yn.checked))
			f_query_add_mod_lower.document.PatMedEncounterDetails_form.inpatient_yn.value = 'N' ;
		else
			f_query_add_mod_lower.document.PatMedEncounterDetails_form.inpatient_yn.value = 'Y' ;
		if(!(f_query_add_mod_lower.document.PatMedEncounterDetails_form.outpatient_yn.checked))
			f_query_add_mod_lower.document.PatMedEncounterDetails_form.outpatient_yn.value = 'N' ;
		else
			f_query_add_mod_lower.document.PatMedEncounterDetails_form.outpatient_yn.value = 'Y' ;
		if(!(f_query_add_mod_lower.document.PatMedEncounterDetails_form.day_care.checked))
			f_query_add_mod_lower.document.PatMedEncounterDetails_form.day_care.value = 'N' ;
		else
			f_query_add_mod_lower.document.PatMedEncounterDetails_form.day_care.value = 'Y' ;
		if(!(f_query_add_mod_lower.document.PatMedEncounterDetails_form.emergency.checked))
			f_query_add_mod_lower.document.PatMedEncounterDetails_form.emergency.value = 'N' ;
		else
			f_query_add_mod_lower.document.PatMedEncounterDetails_form.emergency.value = 'Y' ;
		if(!(f_query_add_mod_lower.document.PatMedEncounterDetails_form.external.checked))
			f_query_add_mod_lower.document.PatMedEncounterDetails_form.external.value = 'N' ;
		else
			f_query_add_mod_lower.document.PatMedEncounterDetails_form.external.value = 'Y' ;*/

		/* if(f_query_add_mod_lower.document.PatMedEncounterDetails_form.inpatient_yn.value == 'Y' || f_query_add_mod_lower.document.PatMedEncounterDetails_form.outpatient_yn.value == 'Y' || f_query_add_mod_lower.document.PatMedEncounterDetails_form.day_care.value == 'Y' || f_query_add_mod_lower.document.PatMedEncounterDetails_form.emergency.value == 'Y' || f_query_add_mod_lower.document.PatMedEncounterDetails_form.external.value == 'Y')
		    { */
             f_query_add_mod_lower.document.PatMedEncounterDetails_form.action='../../servlet/eCA.CAPatMedReportServlet';
		     f_query_add_mod_lower.document.PatMedEncounterDetails_form.target='messageFrame';
		     f_query_add_mod_lower.document.PatMedEncounterDetails_form.method='post';		
		     f_query_add_mod_lower.document.PatMedEncounterDetails_form.submit();
		    }
	   else
		 {
		   var errorMessage = "";
		   errorMsg = getMessage("NOT_VALID","CA");
		   messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg
		   commontoolbarFrame.location.reload();
		   return false;  
	     } 

		
	}
	//else if(fnName == "Speciality") 
	else if(fnName == "CAMS_SPLTY_FOR_PMR") 
	{
		if(f_query_add_mod_lower.document.pmrSpltyForm!=null)
		{
		   cntRecord = f_query_add_mod_lower.document.pmrSpltyForm.cntSelected.value
		   cntRecord1 = f_query_add_mod_lower.document.pmrSpltyForm.cntSelected1.value
			//alert(cntRecord);
			//if (parseInt(cntRecord) > 0  || parseInt(cntRecord1) > 0)
	       // {	        
				f_query_add_mod_lower.document.pmrSpltyForm.fnName.value=fnName;
				f_query_add_mod_lower.document.pmrSpltyForm.NoteTypeID.value=NoteTypeID;		
				
				f_query_add_mod_lower.document.pmrSpltyForm.action='../../servlet/eCA.CAPatMedReportServlet';
				f_query_add_mod_lower.document.pmrSpltyForm.target='messageFrame';
				f_query_add_mod_lower.document.pmrSpltyForm.method='post';		
				f_query_add_mod_lower.document.pmrSpltyForm.submit();
			/*}else {
				var errors = getMessage("ATLEAST_ONE_SELECTED","Common");
				 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
				 return false ;
			}*/
			
	}
	  else
		 {
		   var errorMessage = "";
		   errorMsg = getMessage("NOT_VALID","CA");
		   messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg
		   commontoolbarFrame.location.reload();
		   return false;  
	     } 
	}
		// else if(fnName == "Practitioner") 
		 else if(fnName == "CAMS_PRACT_FOR_PMR") 
	{
		    if(f_query_add_mod_lower.document.pmrPractForm!=null)
		{
	        cntRecord = f_query_add_mod_lower.document.pmrPractForm.cntSelected.value
	        cntRecord1 = f_query_add_mod_lower.document.pmrPractForm.cntSelected1.value
			//alert("cntRecord    :    "+cntRecord+"     cntRecord1     :   "+cntRecord1);
		//	if (parseInt(cntRecord) > 0 || parseInt(cntRecord1) > 0)
	     //  {	        			
				f_query_add_mod_lower.document.pmrPractForm.fnName.value=fnName;
				f_query_add_mod_lower.document.pmrPractForm.NoteTypeID.value=NoteTypeID;
				
				f_query_add_mod_lower.document.pmrPractForm.action='../../servlet/eCA.CAPatMedReportServlet';
				f_query_add_mod_lower.document.pmrPractForm.target='messageFrame';
				f_query_add_mod_lower.document.pmrPractForm.method='post';		
				f_query_add_mod_lower.document.pmrPractForm.submit();
			/*}else {
				var errors = getMessage("ATLEAST_ONE_SELECTED","Common");
				 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
				 return false ;
			}*/
		
	}
	 else
		 {
		   var errorMessage = "";
		   errorMsg = getMessage("NOT_VALID","CA");
		   messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg
		   commontoolbarFrame.location.reload();
		   return false;  
	     }
	}
}

  function getData(obj)
  {

	  if (obj.value!="")
	  { 
			populateReportsLookup();
	  }
	  else
	  {
		  document.PatMedReportSearch_form.txtPatMedReport.value = "";
		  document.PatMedReportSearch_form.NoteTypeID.value  = "";
		 // parent.f_query_add_mod_lower.location.href = "../../eCommon/html/blank.html";
		  
	  }
  }

  
async function populateReportsLookup()
{	
	/*var fnName = document.PatMedReportSearch_form.fnName.value;
	
	var retVal	=  new String();
	var dialogTop			= "30";
	var dialogHeight		= "30" ;
	var dialogWidth			= "40" ;
	var features	="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments= "" ;
	var search_code="";
	var search_desc="";
	var sql="";
	var title = getLabel("Common.MedicalReportRequest.label","COMMON");
	search_code="a.note_type";
	search_desc= "a.note_type_desc";	
	
	sql ="select a.note_type ,a.note_type_desc from  ca_note_type  a ,ca_note_group b where b.note_group = a.NOTE_GROUP_ID and b.APPL_TASK_ID=`PAT_MEDICAL_REPORT` and a.EFF_STATUS = `E` ";
	
	retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
	
	if (retVal != null && retVal != '' && retVal != "null")
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		document.PatMedReportSearch_form.txtPatMedReport.value = arr[0];
		document.PatMedReportSearch_form.NoteTypeID.value = arr[1];
			
	}
	else
	{
		document.PatMedReportSearch_form.txtPatMedReport.value = "";
		document.PatMedReportSearch_form.NoteTypeID.value  = "";
	}
	 */

	var target=parent.frames[1].document.forms[0].txtPatMedReport;
		//var splval= parent.frames[1].document.forms[0].speciality_code1.value;
		var retVal=  new String();
		var dialogTop	= "40";
		var dialogHeight= "10" ;
		var dialogWidth= "40" ;
		var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc	= "";
		var title = getLabel("eCA.PatMediReport.label","CA");
		
		var sql ="select a.note_type code ,a.note_type_desc description from  ca_note_type  a ,ca_note_group b where b.note_group = a.NOTE_GROUP_ID and b.APPL_TASK_ID='PAT_MEDICAL_REPORT' and a.EFF_STATUS = 'E' and upper(a.note_type_desc) like upper(?) and upper(a.note_type) like upper(?) ";

				var argArray = new Array();
				var namesArray = new Array();
				var valuesArray = new Array();
				var datatypesArray = new Array();
				argArray[0] = sql;
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[3] = datatypesArray;
				argArray[4] = "2,1";
				argArray[5] = target.value;
				argArray[6] = DESC_LINK;
				argArray[7] = DESC_CODE;
				
				retArray = await CommonLookup(title,argArray);
				var str =unescape(retArray);
				var arr = str.split(",");
				
				if(retArray != null && retArray !="")
				{
					document.PatMedReportSearch_form.txtPatMedReport.value = arr[1];
					document.PatMedReportSearch_form.NoteTypeID.value = arr[0];
				}
				else
				{
					document.PatMedReportSearch_form.txtPatMedReport.value = "";
					document.PatMedReportSearch_form.NoteTypeID.value  = "";
				}
				





}

function populateFormVals()
{
	
	var fields = new Array ( document.PatMedReportSearch_form.NoteTypeID );
	
	var names = new Array ( getLabel("eCA.PatMediReport.label",'CA') );
			
	if(checkFieldsofMst( fields, names, parent.messageFrame)) 
		{			
					
		callList(document.PatMedReportSearch_form.NoteTypeID,document.PatMedReportSearch_form.fnName.value);
		
		}
		else
		{
			parent.f_query_add_mod_lower.location.href = "../../eCommon/html/blank.html";
		}
	
	
	
	
}

function callList(obj,fnName)
{	
	var searchText = document.PatMedReportSearch_form.search_text.value;
	var searchCriteria = document.PatMedReportSearch_form.search_criteria.value;
	var searchBy;

	if(document.PatMedReportSearch_form.radSearch[0].checked == true) 
		searchBy = document.PatMedReportSearch_form.radSearch[0].value;
	else if(document.PatMedReportSearch_form.radSearch[1].checked == true)
		searchBy = document.PatMedReportSearch_form.radSearch[1].value;

	var NoteTypeID=obj.value;	
	//if(NoteTypeID !="" && fnName == "Speciality") 
	if(NoteTypeID !="" && fnName == "CAMS_SPLTY_FOR_PMR") 
	{
		parent.f_query_add_mod_lower.location.href="CAPMRSpecialty.jsp?NoteTypeID="+NoteTypeID+"&fnName="+fnName+"&clearBean=Y&searchText="+searchText+"&searchCriteria="+searchCriteria+"&searchBy="+searchBy;
	}else if(NoteTypeID !="" && fnName == "CAMS_PRACT_FOR_PMR") 
	//}else if(NoteTypeID !="" && fnName == "Practitioner") 
	{
		parent.f_query_add_mod_lower.location.href="CAPMRPractitioner.jsp?NoteTypeID="+NoteTypeID+"&fnName="+fnName+"&clearBean=Y&searchText="+searchText+"&searchCriteria="+searchCriteria+"&searchBy="+searchBy;
	}
	else
	{
		parent.f_query_add_mod_lower.location.href="../../eCommon/html/blank.html";
		parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}	
} 

function allowPositiveNumber()
{
  var key = window.event.keyCode;
  if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 46)) ) {
       return false;
  }
  return true;
}

function checkNumber(obj) {
   var sequence = "0123456789.";
   var obj_value = obj.value;
   var obj_length = obj_value.length;
   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			alert(getMessage("INVALID_NUMBER_FORMAT",'Common'));
			obj.focus();
			return false;
		}
   }
   return true ;
}

function checkPositiveNumber(obj) {
   var sequence = "0123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;


	if(obj.value == ""){
		return false; 
	}


	if(!checkNumber(obj))
		return false;
		
	if(obj.value!=0)
	if(parseFloat(obj.value) == 0){
			alert(getMessage("INVALID_NUMBER_FORMAT",'Common')); //Here is the Change
			obj.focus();
			return false;
	}

	
   var obj_value = obj.value;
   
   var i1 = obj_value.indexOf('.'); 
   if(i1 != -1){
	   if(obj_value.indexOf('.',i1+1)!=-1)
	   {
		    alert(getMessage("INVALID_NUMBER_FORMAT",'Common'));
			obj.focus();
			return false;
	   }
	}


	if(obj != null ){
		if(parseFloat(obj_value)>=0 && parseFloat(obj_value)<=999999999.9){
			return true;
		}else{
			alert(getMessage("NUMBER_NOT_IN_RANGE",'CA'));
			obj.select();
			obj.focus();
			return false;
		}
	}else{
		return true;
	}
}

function addIDToBean(selObj,practID,beanObj,formName)
 {	 
	 var cntSelected = eval("document."+formName+".cntSelected");
	 var chkCount=cntSelected.value;	 
	 var chkUnchk = "";
	  if(selObj.checked == true)
	 {
		  chkUnchk = "Y";
		  chkCount  = parseInt(chkCount)+1;
	 }else{
		  chkUnchk = "N";
		  chkCount  = parseInt(chkCount)-1;
	 }	
	 cntSelected.value = chkCount;	 
	  parent.f_PMR_Intermediate.location.href = '../../eCA/jsp/CAPatMedicalReportInter.jsp?chkUnchk='+chkUnchk+'&practID='+practID+'&beanObj='+beanObj;
 }

//Functions for CAPMREncounterDetails.jsp-start

function submitPage()
	{
		
		var fields = new Array (document.PatMedReportSearch_form.txtPatMedReport);
		
		var names = new Array (getLabel("eCA.PatMediReport.label",'CA'));

		parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp"; 

		if(checkFieldsofMst( fields, names,parent.messageFrame)) 
		{
			var txtPatMedReport	 = document.PatMedReportSearch_form.NoteTypeID.value;
			//var facility_id		=  document.PatMedReportSearch_form.facility_id.value;	
		
			if ((txtPatMedReport != null)&&(txtPatMedReport.length > 0))
			{
				//parent.f_query_add_mod_lower.location.href="CAPMREncounterDetails.jsp?NoteTypeID="+txtPatMedReport+"&selFacility="+facility_id+"&fnName=Encounter Details";
				parent.f_query_add_mod_lower.location.href="CAPMREncounterDetails.jsp?NoteTypeID="+txtPatMedReport+"&fnName=CAMS_ENC_DTL_FOR_PMR";
			}
			else
			{
				
				parent.f_query_add_mod_lower.location.href="../../eCommon/html/blank.html";
			}
		}	
	}

function OnConfChange(obj)
{
	if(obj.checked)
	{		
		document.PatMedEncounterDetails_form.current_encounter.value = 'Y';
		document.PatMedEncounterDetails_form.facility_scope.selectedIndex=1; //previous_enconters
		document.PatMedEncounterDetails_form.previous_enconters.readOnly=true;
		document.PatMedEncounterDetails_form.facility_scope.disabled = true;
		document.PatMedEncounterDetails_form.facility.value = 'L';
		document.PatMedEncounterDetails_form.previous_enconters.value = '';

	}
	else
	{
		document.PatMedEncounterDetails_form.current_encounter.value = 'N';
		document.PatMedEncounterDetails_form.previous_enconters.readOnly=false;
		document.PatMedEncounterDetails_form.facility_scope.disabled = false;
		document.PatMedEncounterDetails_form.facility_scope.selectedIndex=1;
		document.PatMedEncounterDetails_form.facility.value = 'L';
	}

}
function chkunchk(objCheck)
{ 		
	if(objCheck.checked==false)
	{
		objCheck.checked=false
		objCheck.value = "N";

	}else
	{		objCheck.checked= true;
			objCheck.value = "Y";
	}	
}


function CheckForSpeChar(event)
{
   var strCheck='0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
   var whichCode = (window.Event) ? event.which : event.keyCode;
   key = String.fromCharCode(whichCode);  
   if (strCheck.indexOf(key) == -1) 
		return false;  //Not a valid key
}	

function reset()
 {
	 var beanObj = "";
	 var fnName = f_query_add_mod_upper.document.PatMedReportSearch_form.fnName.value;
	 if(f_query_add_mod_lower.document.pmrSpltyForm!=null)
	 {
		// if (fnName == "Speciality")
		 if (fnName == "CAMS_SPLTY_FOR_PMR")
		 {
			beanObj = f_query_add_mod_lower.document.pmrSpltyForm.pmrBeanID.value;
		 //}else if (fnName == "Practitioner")
		 }else if (fnName == "CAMS_PRACT_FOR_PMR")
		 {
			 beanObj = f_query_add_mod_lower.document.pmrPractForm.pmrBeanID.value;
		 }
	 }
	f_query_add_mod_upper.location.href = '../../eCA/jsp/CAPatMedReportSearchCriteria.jsp?function_id='+fnName;	
	f_PMR_Intermediate.location.href = '../../eCA/jsp/CAPatMedicalReportInter.jsp?clearBean=Y&beanObj='+beanObj;
	f_query_add_mod_lower.location.href = '../../eCommon/html/blank.html';
	messageFrame.location.href = '../../eCommon/html/blank.html';
 }
 function onSuccess()
 {
	 var fnName = f_query_add_mod_upper.document.PatMedReportSearch_form.fnName.value;
	  var beanObj = "";
	 //if (fnName == "Speciality")
	 if (fnName == "CAMS_SPLTY_FOR_PMR")
	 {
		beanObj ="pmrForSpecBean";
	 //}else if (fnName == "Practitioner")
	 }else if (fnName == "CAMS_PRACT_FOR_PMR")
	 {
		 beanObj ="pmrForPracBean";
	 }
	 
	f_query_add_mod_upper.location.href = '../../eCA/jsp/CAPatMedReportSearchCriteria.jsp?function_id='+fnName+"&beanObj="+beanObj;	
	f_query_add_mod_lower.location.href = '../../eCommon/html/blank.html';
 }
function setFacility(obj)
	{
		document.PatMedEncounterDetails_form.facility.value = obj.value;
	}
