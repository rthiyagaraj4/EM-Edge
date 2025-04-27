function docFolderLookup(document_folder)
			{	
				var facility_id = document.forms[0].p_facility_id.value;
				var title		= getLabel("eFM.DocumentFolder.label","FM");
				var argArray	= new Array();	
				var selectArray	= new Array();	
				var headArray	= new Array();	
				var searchArray	= new Array();	
				var arr			= new Array();	
				var sql			= "SELECT doc_folder_id, doc_folder_name FROM fm_doc_folder WHERE eff_status = 'E' AND facility_id ='"+facility_id+"' " ;
				
				selectArray[0]	= "doc_folder_name";	
				selectArray[1]	= "doc_folder_id";	
				
				headArray[0]	= getLabel("eFM.DocumentFolderName.label","FM");
				headArray[1]	= getLabel("eFM.DocumentFolderID.label","FM");
				
				argArray[0]		= document_folder;    // To get Search Criteria.
				argArray[1]		= sql;			    // SQL to be executed.
				argArray[2]		= selectArray;	    // Column names to be used for getting data. 
				argArray[3]		= headArray;	    // Column Titles
				argArray[4]		= "doc_folder_name";	// To give Link

				var retVal		= CommonDocumentLookup(title, argArray);
				if(retVal != null && retVal != "" )
				{
					var ret1	=	unescape(retVal);
					arr=ret1.split("$$");
					document.forms[0].document_folder.value	=	arr[0];
					document.forms[0].doc_folder_id.value	=	arr[1];		
				}
				else
				{
					document.forms[0].document_folder.value	= "";
					document.forms[0].doc_folder_id.value	= "";			
				} 
	}

function reset() 
{
   f_search_criteria.document.forms[0].reset();
   /*Added by Ashwini on 18-Jan-2017 for ML-MMOH-CRF-0895*/
   if(f_search_criteria.document.forms[0].isNatIdInInactvFileRepAppl.value == "true")
	{
		f_search_criteria.document.forms[0].p_pat_id_no.disabled= true;
	}
}

function run() 
{
	
var period = f_search_criteria.document.forms[0].p_period.value;
if (period=="" || parseInt(period)==0){
		error_id = getMessage('CAN_NOT_BE_BLANK','Common');
		error_id = error_id.replace("$", getLabel('eFM.InactivePeriod.label','FM'));
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+ error_id;

}
else

f_search_criteria.document.forms[0].submit() ;
}

function chkVal(obj)
{
  if (obj.name=="visit_status1")
  {
	  document.forms[0].visit_status1.checked=true;
	  document.forms[0].visit_status2.checked=false;
  }
  else
	{
	  document.forms[0].visit_status1.checked=false;
	  document.forms[0].visit_status2.checked=true;
	}
  document.forms[0].p_select.value=obj.value;	
}
async function callSearchScreen(){
		var patientid=await PatientSearch('','','','','','','Y','','','OTHER');
		if(patientid !=null)
		document.forms[0].p_patient_id.value = patientid;
		 document.forms[0].p_patient_id.focus();
	}

/*Added by Ashwini on 18-Jan-2017 for ML-MMOH-CRF-0895*/
function disableNatIdField(val)
{
	if(val != "")
		{		
		document.forms[0].p_pat_id_no.disabled= false;
		document.forms[0].p_pat_id_no.value="";
		}
	else
		{
		document.forms[0].p_pat_id_no.value="";
		document.forms[0].p_pat_id_no.disabled= true;
		}
}
