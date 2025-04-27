
 /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
15/05/2018  	IN065254		Kamalakannan G  		15/05/2018 		 Ramesh G 		GHL_CRF_0485
21/05/2018 		IN067697		Kamalakannan G  		21/05/2018 		 Ramesh G 		GHL_CRF_0485/01
29/05/2018 		IN067703 		Kamalakannan G  		29/05/2018 		 Ramesh G 		GHL_CRF_0485/05
---------------------------------------------------------------------------------------------------------------------------------------------
*/

function PatientLookup()
{
	var pat_id =  PatientSearch();
	if(pat_id != null)
		document.getElementById("patientId").value = pat_id;
}


function populateNursingDiagnosisSearch(target,code)
{
	if(trimString(target.value).length>0)
	{
		NursingDiagnosisSearch(target,code);
	}
	if(target.value=="")
	{
		code.value="";
	}
}

function NursingDiagnosisSearch(target,code)
{
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var formobj=document.NursingPlanReportCriteria;
	
	
 	var sql=formobj.nursing_diagnosis_sql.value;
 	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	
	retval=CommonLookup("Nursing Diagnosis",argumentArray);//IN067697
	if(retval !=null && retval != "")
	{
		code.value=retval[0];
		target.value=retval[1];
	}else{
   		target.value = "";
   		code.value = "" ;
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
	var formobj=document.NursingPlanReportCriteria;
	
	
 	var sql=formobj.goal_sql.value;
 	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	
	retval=CommonLookup("Goal Statement",argumentArray);//IN067697
	if(retval !=null && retval != "")
	{
		code.value=retval[0];
		target.value=retval[1];
	}else{
   		target.value = "";
   		code.value = "" ;
	 }
}

function populateInterventionSearch(target,code)
{
	if(trimString(target.value).length>0)
	{
		interventionSearch(target,code);
	}
	if(target.value=="")
	{
		code.value="";
	}
}
function interventionSearch(target,code)
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var formobj=document.NursingPlanReportCriteria;
	
 	var sql=formobj.intervention_sql.value;
 	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	
	retval=CommonLookup("Interventions",argumentArray);
	if(retval !=null && retval != "")
	{
		code.value=retval[0];
		target.value=retval[1];
	}else{
   		target.value = "";
   		code.value = "" ;
	 }
}

function clearresult()
{
	document.NursingPlanReportCriteria.reset();
	parent.nursePlanResult.location.href="../../eCommon/html/blank.html";
	parent.printFrame.location.href = "../../eCommon/html/blank.html";//IN067697
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



function populateResult(){
	var patient_id	= parent.nursePlanCriteria.NursingPlanReportCriteria.p_patientId;
	var nursingDiag	= parent.nursePlanCriteria.NursingPlanReportCriteria.p_nursingdiag_stmt;
	var status	= parent.nursePlanCriteria.NursingPlanReportCriteria.p_status.value;
	//commented for IN067697
	/*if(status=="ALL"){
		status = status;
	}
	else if(status!="D" && status!="C"){
		status = "O";
	}*/
	var goal_stmt	= parent.nursePlanCriteria.NursingPlanReportCriteria.p_goal_stmt;
	var Interventions	= parent.nursePlanCriteria.NursingPlanReportCriteria.p_Interventions;
	var date_from 	= parent.nursePlanCriteria.NursingPlanReportCriteria.p_date_from;
	var date_to   	= parent.nursePlanCriteria.NursingPlanReportCriteria.p_date_to;
	if(date_from.value=="")
	{
		var msg =getMessage("CAN_NOT_BE_BLANK","common");
		msg = msg.replace("$","From Date");	
		alert(msg);
		date_from.focus();
		return;
	}
	if(date_to.value=="")
	{
		var msg =getMessage("CAN_NOT_BE_BLANK","common");
		msg = msg.replace("$","To Date");
		alert(msg);
		date_to.focus();
		return;
	}
	var params = '?date_from='+date_from.value+'&date_to='+date_to.value+'&patientId='+patient_id.value+'&nursingDiag='+nursingDiag.value+'&status='+status+'&goal_stmt='+goal_stmt.value+'&Interventions='+Interventions.value;

	parent.nursePlanResult.location.href = '../../eCP/jsp/NursingPlanReportResult.jsp'+params;
	parent.printFrame.location.href = '../../eCP/jsp/NursingPlanReportPrint.jsp'+params;//IN067697
}

function printFun(){//IN067697
	
	var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
	
	var bean_id				=  "";
	var bean_name			=  "";
  //IN067697 start
	bean_id		  = eval("parent.nursePlanResult.nursing_plan_report.bean_id.value"); 
	bean_name	  = eval("parent.nursePlanResult.nursing_plan_report.bean_name.value"); 
	var p_patientId = eval("parent.nursePlanResult.nursing_plan_report.p_patientId.value"); 
	var p_nursingdiag_stmt = eval("parent.nursePlanResult.nursing_plan_report.p_nursingdiag_stmt.value"); 
	var p_status = eval("parent.nursePlanResult.nursing_plan_report.p_status.value");
	//IN067697 end
  //commented for IN067697
	/*if(p_status!="D" && p_status!="C"){
		p_status = "O";
	}*/
  //IN067697 start
	var p_goal_stmt = eval("parent.nursePlanResult.nursing_plan_report.p_goal_stmt.value");
	var p_Interventions = eval("parent.nursePlanResult.nursing_plan_report.p_Interventions.value");
	var p_date_from = eval("parent.nursePlanResult.nursing_plan_report.p_date_from.value");
	var p_date_to = eval("parent.nursePlanResult.nursing_plan_report.p_date_to.value");
	var p_facility_id = eval("parent.nursePlanResult.nursing_plan_report.p_facility_id.value");
	var p_language_id = eval("parent.nursePlanResult.nursing_plan_report.p_language_id.value");
	var p_userName = eval("parent.nursePlanResult.nursing_plan_report.p_userName.value");
  //IN067697 end
	xmlStr ="<root><SEARCH " ;
	xmlStr += " p_patientId=\""+ p_patientId +"\" " ;
	xmlStr += " p_nursingdiag_stmt=\""+ p_nursingdiag_stmt + "\" ";
	xmlStr += " p_status=\""+ p_status + "\" ";
	xmlStr += " p_goal_stmt=\""+ p_goal_stmt + "\" ";
	xmlStr += " p_Interventions=\""+ p_Interventions + "\" ";
	xmlStr += " p_date_from=\""+ p_date_from + "\" ";
	xmlStr += " p_date_to=\""+ p_date_to + "\" ";
	xmlStr += " bean_id=\""+ bean_id + "\" ";
	xmlStr += " bean_name=\""+ bean_name + "\" ";
	xmlStr += " p_facility_id=\""+ p_facility_id + "\" ";
	xmlStr += " p_language_id=\""+ p_language_id + "\" ";
	xmlStr += " p_userName=\""+ p_userName + "\" ";//IN067697
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "NursingPlanReportIntermediate.jsp?validate=PRINT_VALUES",true ) ;//IN067703 false replace to true
	xmlHttp.send( xmlDoc ) ;
	alert('APP-OR0148 Report has been Submitted to the Printer');
	//responseText = xmlHttp.responseText ;commented for IN067703 
	//eval(responseText);commented for IN067703 
}
