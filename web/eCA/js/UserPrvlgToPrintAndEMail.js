function create()
{
	usrPrvlgPrintEmailDetailsFrame.location.href = '../../eCA/jsp/UserPrvlgToPrintAndEMailDetails.jsp';
}

async function getResponsibility(locale)
{
	//var sql = "select RESP_ID code, RESP_NAME Description from SM_RESP_LANG where EFF_STATUS = 'E' and LANGUAGE_ID = '"+locale+"' and upper(RESP_ID) like upper(?) and upper(RESP_NAME) like upper(?)  order by 2 ";
	var sql = "select RESP_ID code, RESP_NAME Description from SM_RESP where EFF_STATUS = 'E' and upper(RESP_ID) like upper(?) and upper(RESP_NAME) like upper(?)  order by 2 ";
	var title = getLabel("Common.responsibility.label","Common");
	var target = document.usrPrvlgDetailForm.respDesc;
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	var arr;
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = await CommonLookup(title, argArray);
	if(retArray != null && retArray != "" )
	{
		var ret1 = unescape(retArray);
		arr = ret1.split(",");
		document.usrPrvlgDetailForm.respDesc.value=arr[1];
		document.usrPrvlgDetailForm.respId.value=arr[0];
	}
	else
	{
		document.usrPrvlgDetailForm.respDesc.value="";
		document.usrPrvlgDetailForm.respId.value="";
	}
 }

 function loadPractNames()
 {
	 var patMedicalReport = document.usrPrvlgDetailForm.patMedicalReport;
	 var privilegeFor = document.usrPrvlgDetailForm.privilegeFor;
	 if(patMedicalReport.value == '')
	 {
		 alert(getMessage("PAT_MED_RPT_NOT_BLANK","CA"));
		 return
	 }
	 else
	 {
		//shaiju

		var searchText = document.usrPrvlgDetailForm.search_text.value;
		var searchCriteria = document.usrPrvlgDetailForm.search_criteria.value;
		var searchBy;

		if(document.usrPrvlgDetailForm.radSearch[0].checked == true) 
			searchBy = document.usrPrvlgDetailForm.radSearch[0].value;
		else if(document.usrPrvlgDetailForm.radSearch[1].checked == true)
			searchBy = document.usrPrvlgDetailForm.radSearch[1].value;
		
		//shaiju
		document.usrPrvlgDetailForm.patMedicalReport.disabled = true;
		document.usrPrvlgDetailForm.privilegeFor.disabled = true;
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		parent.usrPrvlgPrintEmailPractFrame.location.href = '../../eCA/jsp/UserPrvlgToPrintAndEMailPract.jsp?noteTypeId='+patMedicalReport.value+'&privilegeId='+privilegeFor.value+'&searchText='+searchText+'&searchCriteria='+searchCriteria+'&searchBy='+searchBy;
	 }
 }

 function reset()
 {
	usrPrvlgPrintEmailDetailsFrame.location.href = '../../eCA/jsp/UserPrvlgToPrintAndEMailDetails.jsp';
	usrPrvlgPrintEmailIntermedFrame.location.href = '../../eCA/jsp/UserPrvlgToPrintAndEMailInter.jsp?clearBean=Y';
	usrPrvlgPrintEmailPractFrame.location.href = '../../eCommon/html/blank.html';
 }

 function addIDToBean(selObj,practID)
 {
	 var cntSelected =document.usrPrvlgPractForm.cntSelected;
	 var chkCount=cntSelected.value;	
	 var chkUnchk = "";
	  if(selObj.checked == true){
		  chkUnchk = "Y";
		  chkCount  = parseInt(chkCount)+1;
	  }
	  else{
		  chkUnchk = "N";
		  chkCount  = parseInt(chkCount)-1;
	  }
	  cntSelected.value = chkCount;	 
	  parent.usrPrvlgPrintEmailIntermedFrame.location.href = '../../eCA/jsp/UserPrvlgToPrintAndEMailInter.jsp?chkUnchk='+chkUnchk+'&practID='+practID;
 }

 function apply()
 {
/*	if(usrPrvlgPrintEmailDetailsFrame.document.usrPrvlgDetailForm.privilegeFor.disabled == true) usrPrvlgPrintEmailDetailsFrame.document.usrPrvlgDetailForm.privilegeFor.disabled = false;
	if(usrPrvlgPrintEmailDetailsFrame.document.usrPrvlgDetailForm.patMedicalReport.disabled == true) usrPrvlgPrintEmailDetailsFrame.document.usrPrvlgDetailForm.patMedicalReport.disabled = false;

	usrPrvlgPrintEmailPractFrame.document.usrPrvlgPractForm.privilegeFor.value = usrPrvlgPrintEmailDetailsFrame.document.usrPrvlgDetailForm.privilegeFor.value;
	usrPrvlgPrintEmailPractFrame.document.usrPrvlgPractForm.patMedicalReport.value = usrPrvlgPrintEmailDetailsFrame.document.usrPrvlgDetailForm.patMedicalReport.value;*/
	var cntRecord = usrPrvlgPrintEmailPractFrame.document.usrPrvlgPractForm.cntSelected.value
    var cntRecord1 = usrPrvlgPrintEmailPractFrame.document.usrPrvlgPractForm.cntSelected1.value
	
	if (parseInt(cntRecord) > 0  || parseInt(cntRecord1) > 0)
	{	
		usrPrvlgPrintEmailPractFrame.document.usrPrvlgPractForm.action='../../servlet/eCA.UserPrvlgPrintEMailServlet';
		usrPrvlgPrintEmailPractFrame.document.usrPrvlgPractForm.target='messageFrame';
		usrPrvlgPrintEmailPractFrame.document.usrPrvlgPractForm.method='post';		
		usrPrvlgPrintEmailPractFrame.document.usrPrvlgPractForm.submit();
	}else{
		var errors = getMessage("ATLEAST_ONE_SELECTED","Common");
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
		return false ;
	}
 }

 function onSuccess()
 {
	usrPrvlgPrintEmailDetailsFrame.location.href = '../../eCA/jsp/UserPrvlgToPrintAndEMailDetails.jsp';
	usrPrvlgPrintEmailPractFrame.location.href = '../../eCommon/html/blank.html';
 }


 function getData(obj)
  {

	  if (obj.value!="")
	  { 
			populateReportsLookup();
	  }
	  else
	  {
		  document.usrPrvlgDetailForm.txtPatMedReport.value = "";
		  document.usrPrvlgDetailForm.patMedicalReport.value  = "";
		 // parent.f_query_add_mod_lower.location.href = "../../eCommon/html/blank.html";
		  
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


async function populateReportsLookup()
{	
	
	var target=document.usrPrvlgDetailForm.txtPatMedReport;
		//var splval= parent.frames[1].document.forms[0].speciality_code1.value;
		var retVal=  new String();
		var dialogTop	= "40";
		var dialogHeight= "10" ;
		var dialogWidth= "100vw" ;
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
					document.usrPrvlgDetailForm.txtPatMedReport.value = arr[1];
					document.usrPrvlgDetailForm.patMedicalReport.value = arr[0];
				}
				else
				{
					document.usrPrvlgDetailForm.txtPatMedReport.value = "";
					document.usrPrvlgDetailForm.patMedicalReport.value  = "";
				}
}
