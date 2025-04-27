/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/06/2014	  IN037701		 Chowminya										SKR-CRF-0036
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
function defaultValue()
{
}
function ValidateDateTimeOfPeriod(fromDate,toDate)
{

	var locale = document.forms[0].locale.value;	
	var from_date = fromDate.value;	
	var to_date = toDate.value;	

	if(CheckDateTime(fromDate) && CheckDateTime(toDate))
	{
		if(to_date !="" || from_date != "")	
		{
			if(isAfter(to_date,from_date, "DMY", locale))
				return true;
			else
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
				toDate.select();
				toDate.focus();
				return false;
			}
		}
	}
	else if(to_date !="")
	{
		checkDt(toDate);
	}
}
function CheckDateTime(objText,admDtChk)
{
	
	var locale		= document.forms[0].locale.value;
	if(objText.value !='')
	{
		if(isBeforeNow(objText.value,"DMY",locale))
		{
			
			if(checkDt(objText.value)==false)	
			{				
				alert(getMessage("INVALID_DATE_TIME","CA"));
				objText.select();						
				objText.focus();						
				return false;
			}
		}	
		if(!validDateObj(objText,"DMY",locale))
		{
			//alert(getMessage("INVALID_DATE_FMT","CA"))
			//objText.focus();
			return false
		}
		
		if(!(isBeforeNow(objText.value,"DMY",locale) ))
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
			objText.select();
			objText.focus();
			return false;
		}
		if(admDtChk == 'Y')
		{
			var adm_date = document.forms[0].adm_date.value;
			if(!(isBefore(adm_date, objText.value, "DMY", locale)))
			{
				alert(getMessage("CANNOT_BE_GREATER_THAN_ADM_DATE","CA")); 
				objText.select();
				objText.focus();
				return false;
			}
		}
		else
			return true;
	}
}
function showCalendarValidate(str){
	var flg = newShowCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
    return flg;
}
var  enableFlag=false;
function newShowCalendar(id, date_format,time_format) {
			 var el = document.getElementById(id);
			 var isModal="isDiv";
			 var timeSet="";
			if ( (date_format==undefined) || (date_format=='') || (date_format==null) || (date_format=='null'))
			{
					timeSet="dd/mm/yyyy"
			}
			else 
			{
					timeSet=date_format
			}
			if ( (time_format!=undefined) && (time_format!='') && (time_format!=null) && (time_format!='null') )
			{

				timeSet = timeSet +' '+ time_format;
			}

			if ( ( ! document.getElementById("CACalanderFun") ) && (document.getElementById(id).type !='hidden') )
			{
				document.getElementById(id).blur();
			}

			if(enableFlag)
			{
					return false
			}
			else
			{
				enableFlag=true;
			}

			newShowInModal(el,timeSet,id);
			return false;
		
}
function newShowInModal(args,timeSet,vid)
	{
			var dialogHeight= "15" ;
			var dialogWidth	= "15" ;
			var status = "no";
			//var arguments = "";
			var features	=  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
			var  dateValue=window.showModalDialog('../../eCommon/jsp/CommonStaticCalenderGlad.jsp?timeSet='+timeSet,args, features);		
		   
			
			var formatedDate = dateValue;	

			if(dateValue==undefined)
			{
					 args.value= "";
			}
			else
			{
					var temp_date=dateValue.split(" ");
					/*if(temp_date.length>1){
						if(vid=='fromDate'){
							formatedDate=temp_date[0]+" 00:00";
						}else if(vid=='toDate'){
							formatedDate=temp_date[0]+" 23:59";
						}
					}*/
					formatedDate = temp_date[0];
					args.value =formatedDate;
			}
			if ( ( ! document.getElementById("CACalanderFun") ) && (args.type !='hidden') )
			args.focus();
			enableFlag=false;
    }
function resetCriteria()
{	
	parent.ChartRecordingCriteriaFrame.location.reload()	
	parent.ChartRecordingGraphFrame.location.href = "../../eCommon/html/blank.html";
	parent.ChartRecordingListFrame.location.href = "../../eCommon/html/blank.html";
}
function SearchChart(flag,daySummary,flagString)
{
	parent.ChartRecordingGraphFrame.location.href="../../eCommon/html/blank.html";
	parent.ChartRecordingListFrame.location.href="../../eCommon/html/blank.html";
	var chartId = document.forms[0].chart_id.value;
	if(chartId == "")
	{
		alert(getMessage("CHART_CANNOT_BLANK","CA"));
		return;
	}			

	var fromDate = document.forms[0].fromDate.value;
	var toDate = document.forms[0].toDate.value;
	var encounterID = document.ChartLayoutCriteriaForm.encounter_id.value;
	var facilityID = document.ChartLayoutCriteriaForm.facility_id.value;
	var patientID = document.ChartLayoutCriteriaForm.patient_id.value;
	var p_called_from =  document.ChartLayoutCriteriaForm.p_called_from.value;//IN037701
		if(fromDate == "" && toDate == "")
		{
			alert("Period cannot be blank");
			return;
		}
		else if(fromDate == "")
		{
			alert("Period cannot be blank");
			return;
		}
		else if(toDate == "")
		{
			alert("Period cannot be blank");
			return;
		}
		////IN037701 Start.
		//parent.ChartRecordingGraphFrame.location.href="../jsp/ViewChartRecordingGraphPopulation.jsp?Chart_Id="+chartId+"&FromDate="+fromDate+"&ToDate="+toDate+"&EncounterID="+encounterID+"&PatientID="+patientID+"&FacilityID="+facilityID;
		//parent.ChartRecordingListFrame.location.href="../jsp/ViewChartRecordingTablePopulation.jsp?Chart_Id="+chartId+"&FromDate="+fromDate+"&ToDate="+toDate+"&EncounterID="+encounterID+"&PatientID="+patientID+"&FacilityID="+facilityID;
		parent.chartRecordingFrameSet.rows="9%,*,4%";
		parent.chartRecordingFrameSetInner.rows="73%,27%";
		parent.ChartRecordingGraphFrame.location.href="../jsp/ViewChartRecordingGraphPopulation.jsp?Chart_Id="+chartId+"&FromDate="+fromDate+"&ToDate="+toDate+"&EncounterID="+encounterID+"&PatientID="+patientID+"&FacilityID="+facilityID+"&p_called_from="+p_called_from;
		parent.ChartRecordingListFrame.location.href="../jsp/ViewChartRecordingTablePopulation.jsp?Chart_Id="+chartId+"&FromDate="+fromDate+"&ToDate="+toDate+"&EncounterID="+encounterID+"&PatientID="+patientID+"&FacilityID="+facilityID+"&p_called_from="+p_called_from;
		////IN037701 End.

}
async function openZoom(graphurl,filename){
		var dialogTop		=	"120" ;
		var dialogHeight= "33" ;
		var dialogWidth = "65" ;
		var status			=	"no";
		var arguments		=	"" ;
		var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url		=	'../../eCA/jsp/ViewChartRecordingZoomGraphPopulation.jsp?GraphTitle='+graphurl+'&FileName='+filename;
		
		var retVal=await window.showModalDialog(action_url,arguments,features);	
}

function clickNextforList()
{	
	var chartId = document.ViewChartListPopulation.chart_id.value;
	var fromDate = document.ViewChartListPopulation.fromDateForExt.value;
	var toDate = document.ViewChartListPopulation.toDateForExt.value;
	var encounterID = document.ViewChartListPopulation.encounter_id.value;
	var facilityID = document.ViewChartListPopulation.facility_id.value;
	var patientID = document.ViewChartListPopulation.patient_id.value;
	
	var dDays=parseInt(document.ViewChartListPopulation.tDisplayDays.value);
	
	parent.ChartRecordingListFrame.location.href="../jsp/ViewChartRecordingTablePopulation.jsp?Chart_Id="+chartId+"&FromDate="+fromDate+"&ToDate="+toDate+"&EncounterID="+encounterID+"&PatientID="+patientID+"&FacilityID="+facilityID+"&Display_Days="+dDays;
	
}
function clickPreviousforList()
{	
	var chartId = document.ViewChartListPopulation.chart_id.value;
	var fromDate = document.ViewChartListPopulation.fromDateForExt.value;
	var toDate = document.ViewChartListPopulation.toDateForExt.value;
	var encounterID = document.ViewChartListPopulation.encounter_id.value;
	var facilityID = document.ViewChartListPopulation.facility_id.value;
	var patientID = document.ViewChartListPopulation.patient_id.value;
	
	var dDays=parseInt(document.ViewChartListPopulation.tDisplayDays.value);
	var totDays=parseInt(document.ViewChartListPopulation.tTotalRows.value);
	var minValue=5;
	if(totDays==dDays){
		var value=dDays%5;
		if(value==0){
			dDays = dDays-(5+minValue);
		
		}else{
			dDays = dDays-(5+value);			
		}
	}else{
		dDays = dDays-(5+minValue);
	}
	
	parent.ChartRecordingListFrame.location.href="../jsp/ViewChartRecordingTablePopulation.jsp?Chart_Id="+chartId+"&FromDate="+fromDate+"&ToDate="+toDate+"&EncounterID="+encounterID+"&PatientID="+patientID+"&FacilityID="+facilityID+"&Display_Days="+dDays;
	
}
function clickNextforGraph()
{	
	
	var chartId = document.ViewChartGraphForm.chart_id.value;
	var fromDate = document.ViewChartGraphForm.fromDateForExt.value;
	var toDate = document.ViewChartGraphForm.toDateForExt.value;
	var encounterID = document.ViewChartGraphForm.encounter_id.value;
	var facilityID = document.ViewChartGraphForm.facility_id.value;
	var patientID = document.ViewChartGraphForm.patient_id.value;
	
	var dDays=parseInt(document.ViewChartGraphForm.tDisplayDays.value);
	
	parent.ChartRecordingGraphFrame.location.href="../jsp/ViewChartRecordingGraphPopulation.jsp?Chart_Id="+chartId+"&FromDate="+fromDate+"&ToDate="+toDate+"&EncounterID="+encounterID+"&PatientID="+patientID+"&FacilityID="+facilityID+"&Display_Days="+dDays;
	
}
function clickPreviousforGraph()
{	
	
	var chartId = document.ViewChartGraphForm.chart_id.value;
	var fromDate = document.ViewChartGraphForm.fromDateForExt.value;
	var toDate = document.ViewChartGraphForm.toDateForExt.value;
	var encounterID = document.ViewChartGraphForm.encounter_id.value;
	var facilityID = document.ViewChartGraphForm.facility_id.value;
	var patientID = document.ViewChartGraphForm.patient_id.value;
	
	var dDays=parseInt(document.ViewChartGraphForm.tDisplayDays.value);
	var totDays=parseInt(document.ViewChartGraphForm.tTotalRows.value);
	
	var minValue=5;
	if(totDays==dDays){
		var value=dDays%5;
		if(value==0){
			dDays = dDays-(5+minValue);
		
		}else{
			dDays = dDays-(5+value);			
		}
	}else{
		
		dDays = dDays-(5+minValue);
	}
	parent.ChartRecordingGraphFrame.location.href="../jsp/ViewChartRecordingGraphPopulation.jsp?Chart_Id="+chartId+"&FromDate="+fromDate+"&ToDate="+toDate+"&EncounterID="+encounterID+"&PatientID="+patientID+"&FacilityID="+facilityID+"&Display_Days="+dDays;
	
}
function loadChart(obj){
	parent.ChartRecordingGraphFrame.location.href="../../eCommon/html/blank.html";
	parent.ChartRecordingListFrame.location.href="../../eCommon/html/blank.html";
	var result ="";
	if(obj.value!=""){
		var query_string="Mode=GetChartId&PractiotionerID="+document.forms[0].practitioner_id.value;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr  = "<root><SEARCH ";
		xmlStr +=" /></root>";
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ViewChartRecordingIntermediate.jsp?"+query_string, false ) ;
		xmlHttp.send(xmlDoc);		
		if(trimString(xmlHttp.responseText)!="Error")
		{
			result = trimString(xmlHttp.responseText);								
		}
		if(result!=""){
			if(obj.value==result){
				document.forms[0].def_Chart_Check.checked = true ;
			}else{
				document.forms[0].def_Chart_Check.checked = false ;
			}
		}else{
			document.forms[0].def_Chart_Check.checked = false ;
		}

	}else{
		document.forms[0].def_Chart_Check.checked = false ;
	}

}
function setDefaultChart(obj){	
	if(document.forms[0].chart_id.value!=""){
		if(obj.checked){
			
			var query_string="Mode=SaveChartId&PractiotionerID="+document.forms[0].practitioner_id.value+"&Chart_Id="+document.forms[0].chart_id.value;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr  = "<root><SEARCH ";
			xmlStr +=" /></root>";
		
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
			xmlHttp.open("POST","ViewChartRecordingIntermediate.jsp?"+query_string, false ) ;
			xmlHttp.send(xmlDoc);
			
			if(trimString(xmlHttp.responseText)!="Success")
			{
				alert(trimString(xmlHttp.responseText));									
			}

		}else{
			var query_string="Mode=UpdateChartId&PractiotionerID="+document.forms[0].practitioner_id.value+"&Chart_Id="+document.forms[0].chart_id.value;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr  = "<root><SEARCH ";
			xmlStr +=" /></root>";
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","ViewChartRecordingIntermediate.jsp?"+query_string, false ) ;
			xmlHttp.send(xmlDoc);
			
			if(trimString(xmlHttp.responseText)!="Success")
			{
				alert(trimString(xmlHttp.responseText));							
			}
		}

	}else{
		obj.checked = false ;
	}
}
function printGraph(imgURL){
	pwin = window.open(imgURL,"_blank");
	pwin.print();
	pwin.close();
}
