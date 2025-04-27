
 /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
06/04/2018  	IN058827		Kamalakannan G  		06/04/2018 		 Ramesh G 		GHL-CRF-0485
21/05/2018 		IN067699		Kamalakannan G  		21/05/2018 		 Ramesh G 		GHL_CRF_0485/02
29/05/2018 		IN067703 		Kamalakannan G  		29/05/2018 		 Ramesh G 		GHL_CRF_0485/05
---------------------------------------------------------------------------------------------------------------------------------------------
*/

function PatientLookup()
{
	var pat_id =  PatientSearch();
	if(pat_id != null)
		document.getElementById("patientId").value = pat_id;
}
function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}
function chkDateTime(obj,format,locale)
{
	if(obj.value != '') 
	{		
		var from_date = document.getElementById("from_date");
		var to_date = document.getElementById("to_date");
	
		if(validDateObj(obj,format,locale))
		{			
			if(from_date.value != "" || to_date.value != "")
			{
				ftDateCheck(from_date,to_date,format,locale);
			}
		}
	}
}

function ftDateCheck(from,to,format,locale)
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
						   return true;
					   }
					   else
					   {
							alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
							to.select();
							to.focus();
							return false;
					   }
				   }
				   else
				   {
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

function populateGoalStmtSearch(target,code)
{
	if(trimString(target.value).length>0)
	{
		goalStmtSearch(target,code);
	}
	if(target.value=="")
	{
		code.value="";
	}
}

function goalStmtSearch(target,code)
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var formobj=document.TaskStatusReportCriteria;
	
	
 	var sql=formobj.goal_sql.value;
 	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	
	retval=CommonLookup("Goal Statement",argumentArray);//IN067699
	if(retval !=null && retval != "")
	{
		code.value=retval[0];
		target.value=retval[1];
	}else{
   		target.value = "";
   		code.value = "" ;
	 }
}
function populateTaskSearch(target,code)
{
	if(trimString(target.value).length>0)
	{
		TaskSearch(target,code);
	}
	if(target.value=="")
	{
		code.value="";
	}
}

function TaskSearch(target,code)
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var formobj=document.TaskStatusReportCriteria;
	
	
 	var sql=formobj.task_sql.value;
 	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	
	retval=CommonLookup("Task Statement",argumentArray);//IN067699
	if(retval !=null && retval != "")
	{
		code.value=retval[0];
		target.value=retval[1];
	}else{
   		target.value = "";
   		code.value = "" ;
	 }
}

function populateResult(){
	
	var patient_id	= parent.TaskReportCriteria.TaskStatusReportCriteria.p_patientId.value;
	var task = parent.TaskReportCriteria.TaskStatusReportCriteria.p_task_stmt.value;
	var status	= parent.TaskReportCriteria.TaskStatusReportCriteria.p_status.value;
	var goal_stmt	= parent.TaskReportCriteria.TaskStatusReportCriteria.p_goal_stmt.value;
	var date_from 	= parent.TaskReportCriteria.TaskStatusReportCriteria.p_date_from.value;
	var date_to   	= parent.TaskReportCriteria.TaskStatusReportCriteria.p_date_to.value;
	if(date_from=="")
	{
		var msg =getMessage("CAN_NOT_BE_BLANK","common");
		msg = msg.replace("$","From Date");	
		alert(msg);
		date_from.focus();
		return;
	}
	if(date_to=="")
	{
		var msg =getMessage("CAN_NOT_BE_BLANK","common");
		msg = msg.replace("$","To Date");
		alert(msg);
		date_to.focus();
		return;
	}
	var params = '?date_from='+date_from+'&date_to='+date_to+'&patientId='+patient_id+'&p_task_stmt='+task+'&p_status='+status+'&p_goal_stmt='+goal_stmt;

	parent.TaskReportResult.location.href = '../../eCP/jsp/TaskStatusReportResult.jsp'+params;
	parent.printFrame.location.href = '../../eCP/jsp/TaskStatusReportPrint.jsp'+params;//IN067699
}

function printFun(){//IN067699
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var bean_id				=  "";
	var bean_name			=  "";
	bean_id		  = eval("parent.TaskReportResult.task_status_report.bean_id.value"); 
	bean_name	  = eval("parent.TaskReportResult.task_status_report.bean_name.value");
	var p_patientId = eval("parent.TaskReportResult.task_status_report.p_patientId.value");
	var p_task = eval("parent.TaskReportResult.task_status_report.p_task_stmt.value");
	var p_status = eval("parent.TaskReportResult.task_status_report.p_status.value");
	var p_goal_stmt = eval("parent.TaskReportResult.task_status_report.p_goal_stmt.value");
	var p_date_from = eval("parent.TaskReportResult.task_status_report.p_date_from.value"); 
	var p_date_to = eval("parent.TaskReportResult.task_status_report.p_date_to.value"); 
	var p_facility_id = eval("parent.TaskReportResult.task_status_report.p_facility_id.value");
	var p_language_id = eval("parent.TaskReportResult.task_status_report.p_language_id.value"); 
	var p_userName = eval("parent.TaskReportResult.task_status_report.p_userName.value");
	xmlStr ="<root><SEARCH " ;
	xmlStr += " p_patientId=\""+ p_patientId +"\" " ;
	xmlStr += " p_status=\""+ p_status + "\" ";
	xmlStr += " p_goal_stmt=\""+ p_goal_stmt + "\" ";
	xmlStr += " p_task=\""+ p_task + "\" ";
	xmlStr += " p_date_from=\""+ p_date_from + "\" ";
	xmlStr += " p_date_to=\""+ p_date_to + "\" ";
	xmlStr += " bean_id=\""+ bean_id + "\" ";
	xmlStr += " bean_name=\""+ bean_name + "\" ";
	xmlStr += " p_facility_id=\""+ p_facility_id + "\" ";
	xmlStr += " p_language_id=\""+ p_language_id + "\" ";
	xmlStr += " p_userName=\""+ p_userName + "\" ";//IN067699
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TaskStatusReportIntermediate.jsp?validate=PRINT_VALUES",true) ;//false replace to true for IN067703
	xmlHttp.send( xmlDoc ) ;
	alert('APP-OR0148 Report has been Submitted to the Printer');
	// responseText = xmlHttp.responseText ;commented for IN067703
	//alert('APP-OR0148 Report has been Submitted to the Printer');//commented for IN067703
	//eval(responseText);commented for IN067703
}
function clearresult()
{
	document.TaskStatusReportCriteria.reset();
	parent.TaskReportResult.location.href="../../eCommon/html/blank.html";
	parent.printFrame.location.href = "../../eCommon/html/blank.html";//IN067699
}
