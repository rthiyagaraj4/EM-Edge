 function getPractCode(obj)
  {

	  if (obj.value!="")
	  { 
			populatePractLookup();
	  }
	  else
	  {
		  document.MedRecAdminAlertCriteria_Form.practitioner.value = "";
		  document.MedRecAdminAlertCriteria_Form.practitioner_id.value  = "";		 
		  
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
     async function populatePractLookup()
	   {
		   var target			= document.MedRecAdminAlertCriteria_Form.practitioner;
		   var retVal			=  new String();
		   var title			= getLabel("Common.user.label","common");
		   var p_facility_id    = document.getElementById("facility_id").value;
		   var locale    = document.getElementById("locale").value;

		   var sql="select APPL_USER_ID code, APPL_USER_name description from SM_APPL_USER_LANG_VW  where LANGUAGE_ID='"+locale+"' and EFF_STATUS='E' and upper(APPL_USER_ID) like upper(?) and upper(APPL_USER_name) like upper(?) order by 2";
		   var argArray		= new Array();
		   var namesArray		= new Array();
		   var valuesArray		= new Array();
		   var datatypesArray	= new Array();
		
			argArray[0] = sql;
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[3] = datatypesArray;
			argArray[4] = "1,2";
			argArray[5] = target.value;
			argArray[6] = DESC_LINK;
			argArray[7] = CODE_DESC;
			//alert("locale"+locale);
			retVal      =await CommonLookup( title, argArray );
		
			 if (retVal != null && retVal != '' && retVal != "null")
				{
				document.MedRecAdminAlertCriteria_Form.practitioner.value = retVal[1];
				document.MedRecAdminAlertCriteria_Form.practitioner_id.value = retVal[0]
				}

			else
				{
					document.MedRecAdminAlertCriteria_Form.practitioner.value = "";
					document.MedRecAdminAlertCriteria_Form.practitioner_id.value = "";
				} 

	   }


function searchForMain()
{
	var group_by	=	""; 
	var fnName	=	""; 
	//var requestedbyid	=	parent.SignNotesCriteriaFrame.document.forms[0].requested_by.value;
	var fromDate ="";
	var ToDate ="";
	var practitioner_id ="";
		fromDate =parent.MedRecAdminAlertCriteriaFrame.document.forms[0].fromDt.value;
		ToDate = parent.MedRecAdminAlertCriteriaFrame.document.forms[0].toDt.value;
		//practitioner = parent.MedRecAdminAlertCriteriaFrame.document.forms[0].practitioner.value;
		practitioner_id = parent.MedRecAdminAlertCriteriaFrame.document.forms[0].practitioner_id.value;
		group_by = parent.MedRecAdminAlertCriteriaFrame.document.forms[0].group_by.value;
		fnName = parent.MedRecAdminAlertCriteriaFrame.document.forms[0].fnName.value;
		//alert("fnName"+fnName);
		//alert("practitioner_id"+practitioner_id);

	var	to = parent.MedRecAdminAlertCriteriaFrame.document.forms[0].toDt ;
	var locale = parent.MedRecAdminAlertCriteriaFrame.document.forms[0].locale.value;

    if(fnName== 'CAMS_PRACT_ALERT')
	 {
		group_by="PAT";

	 }
	

     if(fromDate== ''|| fromDate == null)
	 {
		alert(getMessage("FROM_DATE_NOT_BLANK","CA"));
		 return 
	 }else if(ToDate== ''|| ToDate == null)
	{
	     alert(getMessage("TO_DATE_NOT_BLANK","CA"));
		 return 
	}
	 else
	 {
		var params = '?fromDate='+fromDate+'&ToDate='+ToDate+'&fnName='+fnName+'&practitioner_id='+practitioner_id+'&group_by='+group_by;
		parent.MedRecAdminAlertResultMainFrame.location.href = '../../eCA/jsp/MedRecAdminAlertResultMain.jsp'+params;
	 }		
}


function searchForPract()
{
	var group_by	=	"PAT"; 
	//var requestedbyid	=	parent.SignNotesCriteriaFrame.document.forms[0].requested_by.value;
	var fromDate ="";
	var ToDate ="";
	//var practitioner ="";
		fromDate =parent.MedRecAdminAlertCriteriaFrame.document.forms[0].fromDt.value;
		ToDate = parent.MedRecAdminAlertCriteriaFrame.document.forms[0].toDt.value;
		//practitioner = parent.MedRecAdminAlertCriteriaFrame.document.forms[0].practitioner.value;
		//practitioner_id = parent.MedRecAdminAlertCriteriaFrame.document.forms[0].practitioner_id.value;
		//group_by = parent.MedRecAdminAlertCriteriaFrame.document.forms[0].group_by.value;
	var	to = parent.MedRecAdminAlertCriteriaFrame.document.forms[0].toDt ;
	var locale = parent.MedRecAdminAlertCriteriaFrame.document.forms[0].locale.value;
	

     if(fromDate== ''|| fromDate == null)
	 {
		alert(getMessage("FROM_DATE_NOT_BLANK","CA"));
		 return 
	 }else if(ToDate== ''|| ToDate == null)
	{
	     alert(getMessage("TO_DATE_NOT_BLANK","CA"));
		 return 
	}
	 else
	 {
		var params = '?fromDate='+fromDate+'&ToDate='+ToDate+'&group_by='+group_by;
		parent.MedRecAdminAlertResultMainFrame.location.href = '../../eCA/jsp/PractAlertResult.jsp'+params;
	 }		
}

function ftDateCheck(from,to,currDate,format,locale)
	{
		
		if(!(from.value == "" ))
		{
		 if(!isBeforeNow(from.value,format,locale))
			{
			
				//alert(top.header.getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				from.select();
				from.focus();
				return false;
				
			}
			else
			{ 
			 if(!(to.value == "" ))
				{
				   if(isBeforeNow(to.value,format,locale))

				{
					if(isAfter(to.value,from.value, format, locale))
					{
						
						/*if(document.forms[0].patientId.value=="")
						{
							if(daysBetween(from.value,to.value,format,locale)>31)
							{
								var msg = top.header.getMessage("DATE_RANGE_FOR_NOTES","CA");
								alert(msg);
								to.select();
								to.focus();
							}
						}*/
						return true;
					}
					else
					{
						//alert(top.header.getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
						alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
						return false;
					}
				}
				else
				{
					//alert(top.header.getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
					to.select();
					to.focus();
					return false;
				}
				}
			}
			if(!to.value=="")
			{
			 			 
			}
				
		}
		else
	{
			if((!to.value==""))
			{
				if(!isBeforeNow(to.value, format, locale))
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					to.select();
					to.focus();
					return false;
				}
			}
	}
}

function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}
function clearMain(){
	top.content.MedRecAdminAlertResultMainFrame.location.href="../../eCommon/html/blank.html";
	document.location.reload();	
}


function filterNShowDetails(obj,code,practitioner_id,fromDate,toDate)
{
	//alert(sum);
	var group_by = parent.MedRecAdminAlertTreeFrame.document.forms[0].group_by.value;
	
    var params = '?code='+code+'&practitioner_id='+practitioner_id+'&fromDate='+fromDate+'&ToDate='+toDate+'&group_by='+group_by;
	parent.MedRecAdminAlertResultFrame.location.href = '../../eCA/jsp/MedRecAdminAlertResult.jsp'+params;
}
