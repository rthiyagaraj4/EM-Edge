/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
22/01/2016	  	IN057193			Karthi L											Flag For Discharge Summary Not Done								
12/07/2017		IN061885			Raja S				13/07/2017		Ramesh G		ML-MMOH-CRF-0537
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
function searchForDetails()
{
	var notetypecode	=	""; 
	var fromDate ="";
	var ToDate ="";
	var patientId ="";
	
	fromDate =parent.PendDiscSummCriteriaFrame.document.forms[0].fromDt.value;
	ToDate = parent.PendDiscSummCriteriaFrame.document.forms[0].toDt.value;
	patientId = parent.PendDiscSummCriteriaFrame.document.forms[0].patientId.value;
	var	to = parent.PendDiscSummCriteriaFrame.document.forms[0].toDt ;
	var	fromDt = parent.PendDiscSummCriteriaFrame.document.forms[0].fromDt ;
	var locale = parent.PendDiscSummCriteriaFrame.document.forms[0].locale.value;
	var viewBy = parent.PendDiscSummCriteriaFrame.document.forms[0].viewBy.value; //Added for IN061885
	
	if(fromDate=='')
	{
	var msg =getMessage("CAN_NOT_BE_BLANK","common");
	msg = msg.replace("$","From Date");	
	alert(msg);
	fromDt.focus();
	return;
	}
	if(ToDate=='')
	{
	var msg =getMessage("CAN_NOT_BE_BLANK","common");
	msg = msg.replace("$","To Date");
	alert(msg);
	to.focus();
	return;
	}
	var fdate = minusDate(ToDate,"DMY",locale,1,"M");
	/*if(patientId=="" && daysBetween(fromDate,fdate,"DMY",locale)>0)
	{
		var msg = getMessage("DATE_RANGE_FOR_NOTES","CA");
		alert(msg);
		fromDt.focus();
		fromDt.select();
		return;
	} */
		//parent.SignNotesCriteriaFrame.document.getElementById("search").disabled=true;
	//var params = '?fromDate='+fromDate+'&toDate='+ToDate+'&patientId='+patientId; //Commented for IN061885
	var params = '?fromDate='+fromDate+'&toDate='+ToDate+'&patientId='+patientId+'&viewBy='+viewBy;//Added viewBy for IN061885 
	parent.PendDiscSummDetailsFrame.location.href = '../../eCA/jsp/PendDiscSummDetails.jsp'+params 
	
}

function clearForm(from){
	var action_url = getRelativeURL("/eCA/jsp/PendDiscSummDetails.jsp");
	parent.PendDiscSummDetailsFrame.location.href = action_url 
	parent.PendDiscSummDetailsFrame.location.reload();
}

async function callDiscSummNotes(patient_id,encounter_id,patient_class)
{	
	var facility_id	= parent.PendDiscSummDetailsFrame.document.forms[0].facility_id.value;
	var episode_type = "";
	if(patient_class == "IP" || patient_class=="DC")
		episode_type ="I";
	if(patient_class=="OP" ||patient_class=="EM")
		episode_type ="O";
	
	var retVal;
	
	var dialogHeight= "600";
	var dialogWidth	= "500";
	var status = "no";
	var arguments	= "";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
	var action_url;
	action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?function_id=DISCHARGE_SUMMARY&appl_task_id=DISCHARGE_SUMMARY&title=Discharge Summary Note&patient_id="+patient_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&patient_class="+patient_class+"&called_from=PEND_DISC_NOTE"; // modified senthil
	retVal=await window.showModalDialog(action_url,arguments,features);
	if(retVal != null & retVal != ''){
		parent.PendDiscSummDetailsFrame.location.reload();
	}
	//alert(parent.PendDiscSummDetailsFrame.document.forms[0].tempAccession_Num.value);
//	alert(' action_url ' + retVal)
}

function callPatientSearch()
{
	var pat_id =  PatientSearch();
	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}

function checkDuplicate(obj)	
{
	ChangeUpperCase(obj);
	if(obj.value != "")
	{
		var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='frmDuplicateId' id='frmDuplicateId' method='post' action='../../eCA/jsp/CAValidatePatientId.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+escape(obj.value)+"'><input type='hidden' name='fromFunction' id='fromFunction' value='PatListByLocation'></form></body></html>";
		top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		top.content.messageFrame.document.frmDuplicateId.submit();
	}
}
function ftDateCheck(from,to,currDate,format,locale)
{
		
		if(from.value=="" && to.value=="")
		{
			alert("Period can't be empty");
			return;
		}
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
							to.select();
							to.focus();
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


function PendDiscSummNotesClear()
{
	parent.PendDiscSummCriteriaFrame.PendDiscSummCriteria_form.reset();
	parent.PendDiscSummDetailsFrame.location.href="../../eCommon/html/blank.html";
}

function checkFromToDate(fromOrTo,obj,fromToDate,currDate,fmt,locale)
{	
	if(obj.value!='')
	{
		if(fromOrTo=='F')
		{
		
			if(CheckDate(obj))
			{
				ftDateCheck(obj,fromToDate,currDate,fmt,locale);
			}
			
		}
		else if(fromOrTo=='T')
		{
			if(CheckDate(obj))
			{
				ftDateCheck(fromToDate,obj,currDate,fmt,locale);
			}	
		
		}
	}
}	 

