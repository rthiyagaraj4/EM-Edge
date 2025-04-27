/*
---------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------
24/05/2018		IN065341	Prakash C	25/05/2018		Ramesh G		ML-MMOH-CRF-0115
--------------------------------------------------------------------------------------------------------
*/
patIdArr = new Array();
episodeIdArr = new Array();
patient_class = new Array();
function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	//document.getElementById(str).focus();
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

function searchForDetails(){
	
	var patient_id = document.getElementById("patient_id").value;
	//var selfacility = document.getElementById("facility_list").value;
	var name=document.getElementById("facility_list").value;
	var arr=name.split("#");
	var selfacility=arr[0];
	var RepDb=arr[1];
	var from_date = parent.viewframe.document.forms[0].from_date.value; 
	var to_date = parent.viewframe.document.forms[0].to_date.value; 
	var fromdate = parent.viewframe.document.forms[0].from_date; 
	var todate = parent.viewframe.document.forms[0].to_date;
	var called_from = parent.viewframe.document.forms[0].called_from.value; 
	var nationality_id =parent.viewframe.document.forms[0].nationality_id.value; 
	var alternate_id = parent.viewframe.document.forms[0].alternate_id.value; 	
	
	if(fromdate.value=='')
	{
	var msg =getMessage("CAN_NOT_BE_BLANK","common");
	msg = msg.replace("$","From Date");	
	alert(msg);
	fromdate.focus();
	return;
	}
	if(todate.value=='')
	{
	var msg =getMessage("CAN_NOT_BE_BLANK","common");
	msg = msg.replace("$","To Date");
	alert(msg);
	todate.focus();
	return;
	}
	
	var params = '?selfacility='+selfacility+'&from_date='+from_date+'&patient_id='+patient_id+'&to_date='+to_date+'&called_from='+called_from+'&nationality_id='+nationality_id+'&alternate_id='+alternate_id; 
	parent.resultframe.location.href = '../../eCA/jsp/CentralizedDBSearchResult.jsp'+params;
}
function clearAll(){
	document.CentrailizedCriteriaForm.reset();	
	parent.resultframe.location.href="../../eCommon/html/blank.html";
}
function loadViewChartSummary(count){
	var facility_id=document.getElementById("facility_id").value;
	var patient_id=document.getElementById("patient_id").value;
	var called_from=document.getElementById("called_from").value;
	var patient_name=document.getElementById("patient_name").value;
	var RepDb=document.getElementById("RepDb").value;
	var encounter_id=eval("document.Encounter_result.encounter_id"+count+".value");
	var patient_class=eval("document.Encounter_result.patient_class"+count+".value");
	var clob_data="_CDR";
	
	var dialogHeight= "60" ;
	var dialogWidth	= "80" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes;  status:" + status;
	
	window.showModalDialog("../../eCA/jsp/CDREncounterResults.jsp?patient_id="+patient_id+"&pat_class="+patient_class+"&facility_id1="+facility_id+"&enc_id1="+encounter_id+"&RepDb="+RepDb+"&called_from="+called_from+"&clob_data="+clob_data+"&patient_name="+patient_name,arguments,features);
}
function changeDate(){
			
		var arr=new Array();
       		var name=document.getElementById("facility_list").value;
		var arr=name.split("#");
		var facility_id=arr[0];
		var RepDb=arr[1];
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;	
		xmlStr += "RepDb=\""+ RepDb + "\" " ;		
		xmlStr += "facility_id=\""+ facility_id + "\" " ;//new line
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
		xmlHttp.open( "POST", "CentralizedDBIntermediate.jsp", false ) ;
		xmlHttp.send(xmlDoc ) ;
		responseText=xmlHttp.responseText;
		eval(responseText);
}
