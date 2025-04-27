function query()
 {
	  f_SecondaryTriageCriteria.location.href ="../../eAE/jsp/AEQuerySecondaryTriageHistory.jsp" ;
 }
function reset() 
  {

	    f_SecondaryTriageCriteria.document.forms[0].reset();
	  	f_SecondaryTriageResult.location.href="../../eCommon/html/blank.html" ;
		messageFrame.location.href="../../eCommon/jsp/error.jsp" ;  
	    f_SecondaryTriageCriteria.document.forms[0].search.disabled = false; 
  } 
 
function clear1()  
{
	parent.f_SecondaryTriageResult.location.href="../../eCommon/html/blank.html" ;
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp" ;  
	//parent.commontoolbarFrame.document.forms[0].reset.disabled=true;
	document.forms[0].search.disabled = false; 
}


 async function callPatientSearch() 
{
	var patient_id	=	document.forms[0].patient_id;
	var retun_value =	"";
	return_value	=	await PatientSearch();
	if(return_value!=null && return_value!='undefined')
	{
		patient_id.value	=	return_value;
	}
	else
	{
		patient_id.value	=	"";
	}
}

function callSearch(patient_id,encounter_id,ae_secondary_datefrom,ae_secondary_dateto,ae_secondary_location,messageFrame)
	{
		var functionid=document.forms[0].function_id.value;

		if(trimCheck(patient_id.value)==false &&  trimCheck(encounter_id.value)==false)
		{ 
		//var msg='APP-AE0009 Specify any one of Patient ID /  Encounter ID criteria ';
           var msg=getMessage('AE_PAT_ENC_BLANK','AE');
		patient_id.focus();
		messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
		return false;
		}
		else
		{
			messageFrame.location.href ="../../eCommon/jsp/error.jsp";
			patient_id.focus();
		}
		var patid = document.forms[0].patient_id.value;
				
		var fields = new Array (document.forms[0].patient_id,
		document.forms[0].encounter_id);

		var names = new Array (getLabel("Common.patientId.label","Common"),getLabel("Common.encounterid.label","Common"));	

		var error_jsp="../../eCommon/jsp/error.jsp";
       
	    if (ae_secondary_datefrom.value !='' && ae_secondary_dateto.value!='')
	    {
			if(isBefore(ae_secondary_datefrom.value,ae_secondary_dateto.value,"DMY",localeName))
			{
				
			var sql_query=constructQuery(patient_id,encounter_id,ae_secondary_datefrom,ae_secondary_dateto,ae_secondary_location);
			//if(SpecialCharCheck(fields,names,messageFrame,"M",error_jsp))
			//{
				   document.forms[0].search.disabled = true; 
				   parent.f_SecondaryTriageResult.location.href='../../eAE/jsp/AEResultSecondaryTriageHistory.jsp?patient_id='+escape(patient_id.value)+'&sql_query='+sql_query+'&encounter_id='+escape(encounter_id.value)+'&functionid='+functionid;
				//}
				
			}
			else
			{	
				var error=error=getMessage('TO_DT_GR_EQ_FM_DT','SM');
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
				return false;
			}
		}
	    else
		{
                   var sql_query=constructQuery(patient_id,encounter_id,ae_secondary_datefrom,ae_secondary_dateto,ae_secondary_location);
				   document.forms[0].search.disabled = true; 
				   parent.f_SecondaryTriageResult.location.href='../../eAE/jsp/AEResultSecondaryTriageHistory.jsp?patient_id='+escape(patient_id.value)+'&sql_query='+sql_query+'&encounter_id='+escape(encounter_id.value)+'&functionid='+functionid;
			
		}
	} 
	/*function callSearch(patient_id,encounter_id,ae_secondary_datefrom,ae_secondary_dateto,ae_secondary_location,messageFrame)
	{
		if(trimCheck(patient_id.value)==false &&  trimCheck(encounter_id.value)==false)
		{ 
		var msg='APP-AE0009 Specify any one of Patient ID /  Encounter ID criteria ';

		patient_id.focus();
		messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
		return false;
		}
		else {
		alert("patient_id "+trimCheck(patient_id.value) );
		alert("patient_id "+document.forms[0].patient_id) ); }
	} */

function constructQuery(patient_id,encounter_id,ae_secondary_datefrom,ae_secondary_dateto,ae_secondary_location)
	{
		var sql_query=' ';
        var andCheck	=	0;            

		if(!(trimCheck(patient_id.value) == false)	)
		{
		sql_query	=' and a.patient_id ='+'\''+escape(patient_id.value)+'\'';
		andCheck	=	1;
		} 
		if(!(trimCheck(encounter_id.value) == false)	)
		{
			if(andCheck == 1)
			sql_query	=sql_query + ' and encounter_id = ' +'\''+escape(encounter_id.value)+'\' ';
			else
			sql_query	=' and encounter_id = ' +'\''+escape(encounter_id.value)+'\' ';
		}
        if( (trimCheck(ae_secondary_datefrom.value) == true) && (trimCheck(ae_secondary_dateto.value) == true ) )
		{
				
				sql_query	= sql_query + '	and to_char(trunc(to_date(queue_date,\'dd/mm/yyyy hh24:mi\')))  between to_char(to_date(\''+convertDate(ae_secondary_datefrom.value,"DMY",localeName,"en") +'\',\'dd/mm/yyyy \')) and to_char(to_date(\''+convertDate(ae_secondary_dateto.value,"DMY",localeName,"en") +'\',\'dd/mm/yyyy \')) ';
		}
		else if((trimCheck(ae_secondary_datefrom.value)== true))
		{
				sql_query = sql_query + ' and to_char(trunc(to_date(queue_date,\'dd/mm/yyyy hh24:mi\')))  =to_char(to_date(\''+convertDate(ae_secondary_datefrom.value,"DMY",localeName,"en") +'\',\'dd/mm/yyyy \'))';
		}
		else if( (trimCheck(ae_secondary_dateto.value) == true) )
		{
				sql_query = sql_query + ' and  to_char(trunc(to_date(queue_date,\'dd/mm/yyyy hh24:mi\'))) =to_char (to_date(\''+convertDate(ae_secondary_dateto.value,"DMY",localeName,"en") +'\',\'dd/mm/yyyy \'))';
		}
		else {}
		if(! (trimCheck(ae_secondary_location.value) == false))
		{
			sql_query	=sql_query + ' and LOCN_CODE = ' +'\''+ae_secondary_location.value+'\' ';
       }
	   return sql_query;   
		
	}

	
	async function patvisit() {
	var retVal;
	var dialogHeight= "70vh" ;
	var dialogWidth	= "45vw" ;
	var dialogTop = "80" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var p_mode = "TRIAGEQUERY";
	var patient_id = document.forms[0].patient_id.value;
	retVal =  await top.window.showModalDialog("../../eAE/jsp/AEPaintSearchVisit.jsp?p_mode="+p_mode+"&patient_id="+patient_id,arguments,features);
	if(retVal != null){
		if(retVal == "close")
		retVal="|";
		returnarray=retVal.split("|");
		var j1=returnarray[1];
		var j2=returnarray[0];
		document.forms[0].encounter_id.value=j2;
	}
}


function changeCase(obj)
{
  obj.value=obj.value.toUpperCase();
}

function callfocus()
{
	document.forms[0].patient_id.focus();
}

function ChkNumber(encval)
{
	var alphabet = false;
	var encvalue	=	encval.value;
	for(i=0; i<encvalue.length; i++)
	{
	if( !(encvalue.charCodeAt(i) >=48 && encvalue.charCodeAt(i) <=57))
		alphabet =true;
	}
		if(alphabet)
		{
			alert(getMessage("AE_INVALID_ENCOUNTER_ID",'AE'));
			encval.focus();
			return true;

		}
		else
			return false;
}


async function CallLocationLookup()
{

	var facility_id="";//document.forms[0].facility_id.value;
	var msg="";

	facility_id				="`"+'<%=facilityId%>'+"`";
		
	var target				= document.forms[0].ae_pat_history_location_desc;
	var retVal				=    new String();
	var dialogTop			= "40";
	var dialogHeight		= "10vh" ;
	var dialogWidth			= "40vw" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql="";
	var search_desc="";
	var tit="";
	sql=" select clinic_code, short_desc from op_clinic where facility_id = "+facility_id+" and clinic_type  in (select locn_type from am_care_locn_type where care_locn_type_ind=`C`)  and level_of_care_ind = `E` and eff_status = `E` ";

	search_code="clinic_code";
	search_desc="short_desc";
	tit=encodeURIComponent(getLabel("Common.locationcode.label","Common"));
	retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
		
	var arr=new Array();

	if (!(retVal == null))
	{

		var retVal=unescape(retVal);
		arr=retVal.split("::");

		document.forms[0].ae_pat_history_location_desc.value=arr[0];
		document.forms[0].ae_pat_history_location.value=arr[1];

		document.forms[0].ae_pat_history_location_desc.focus();
	}
	else
	{
		target.focus();
	}
}

/*function doDate(obj)
{
		if ( CheckDate(obj) == false)
        {
			obj.select();
			return false;
		}
        else 
		{
			var fromdate;
			var todate;
			todate  = document.forms[0].sys_date.value;
			fromdate = obj.value;
			if(fromdate!=null && todate!=null)
			{
			 if(fromdate.length > 0 && todate.length > 0 ) 
			  {
				fromarray = fromdate.split("/");
				toarray = todate.split("/");
				var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
				var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
				if(Date.parse(todt) < Date.parse(fromdt)) 
				{
					alert(getMessage("START_DATE_GREATER_SYSDATE",'Common'));
					obj.select();
					return false ;
				}
				else
				{
				  return true;
				}
			 }
			}
	  }
}*/

function doDate(obj){
	if(obj.value!=''){
if(isBeforeNow(obj.value,"DMY",localeName))
	return true;
else {
alert(getMessage("START_DATE_GREATER_SYSDATE",'Common'));
					//obj.select();
					obj.value="";
					return false ;
	 }
	}
}


async function CallViewPatSecondaryDetails(patient_id,encounter_id,visit_adm_date_time)  
	{
            var retVal = "";
			var function_id ="query";
			var functionid ="AE_SEC_TRIAGE_HIST";
			
			var dialogHeight= "80vh" ;
			var dialogWidth	= "100vw" ;
			var dialogTop ="0";
			var dialogTop ="58";
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
			var action_url		=	"../../eAE/jsp/AESecondaryTriageHistoryMain.jsp?patient_id="+patient_id+"&episode_id="+encounter_id+"&visit_adm_date_time="+visit_adm_date_time+"&function_id="+function_id+"&functionid="+functionid;
			retVal = await top.window.showModalDialog(action_url,arguments,features);
			
    }
function disReset()
{
	parent.frames[0].document.getElementById("reset").disabled= true;
	
}
 
function onMMove(obj,e,patient_valuables)
	{
		var patient_valuables;
		obj.style.left=e.x+20;
		obj.style.top=e.y;
		obj.style.borderColor='pink';
		obj.style.borderWidth='thin';
		obj.style.borderStyle='groove';
		obj.style.width=150;
		obj.innerHTML="<table cellspacing='0' cellpadding='0' border='0' height=100% width='100%'><tr><td class='ordata' valign='top'>"+patient_valuables+"</td></tr></table>";
	}
function onMOut(obj)
	{
		obj.innerHTML='';
		obj.style.width=0;
		obj.style.borderColor='';
		obj.style.borderWidth='';
		obj.style.borderStyle='';
	}
