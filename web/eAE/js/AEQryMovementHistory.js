// Added/Modified by Nanda - 11/14/2002
function query()
{
	parent.frames[1].frames[1].document.location.href='../../eAE/jsp/AEQryMovementHistCriteria.jsp';
	parent.frames[1].frames[2].document.location.href='../../eCommon/html/blank.html';
	parent.frames[1].frames[3].document.location.href='../../eCommon/html/blank.html';
	parent.frames[1].frames[4].document.location.href='../../eCommon/jsp/error.jsp';

}

async function callPatientSearch()
{
	var patientid =await PatientSearch('','','','','','','','','','');

	if(patientid !=null)
	{

		document.getElementById("patient_id").value = patientid;
		document.getElementById("patient_id").focus();
	}
	else
	{
		document.getElementById("patient_id").value = '';
	}
}

function changeCase(obj)
{
  obj.value=obj.value.toUpperCase();
}

function CallMoveHistDtl()
{
	var patient_id = parent.frames[1].document.forms[0].patient_id;
	var visit_date_time = parent.frames[1].document.forms[0].visit_date_time;
	var visit_date_to = parent.frames[1].document.forms[0].visit_date_to; //Added by Ashwini on 04-Oct-2018 for ML-MMOH-CRF-1042

	var fields = new Array (patient_id,visit_date_time,visit_date_to);

	var names = new Array (getLabel("Common.patientId.label","Common"),getLabel("Common.VisitDate.label","Common")+" "+getLabel("Common.from.label","Common"), getLabel("Common.VisitDate.label","Common")+" "+getLabel("Common.to.label","Common"));	

	query_string = "patient_id="+patient_id.value+"&visit_date_time="+convertDate(visit_date_time.value,"DMY",localeName,"en")+"&visit_date_to="+convertDate(visit_date_to.value,"DMY",localeName,"en");

	if (checkFields( fields, names, parent.frames[4])	) 
	{
	parent.frames[4].document.location.href='../../eCommon/jsp/error.jsp';	
	parent.frames[2].document.location.href='../../eCommon/jsp/pline.jsp?Patient_ID='+patient_id.value;
	parent.frames[3].document.location.href='../../eAE/jsp/AEMovementHistoryMain.jsp?called_from=Main&'+query_string;
	parent.frames[1].document.forms[0].search.disabled = true;
	//parent.frames[0].document.forms[0].reset.disabled=true;
	}
}

function clearAll()
{
	//parent.frames[1].document.forms[0].reset(); Monday, January 11, 2010  18105
	parent.frames[2].document.location.href='../../eCommon/html/blank.html';
	parent.frames[3].document.location.href='../../eCommon/html/blank.html';
	parent.frames[4].document.location.href='../../eCommon/jsp/error.jsp';
	//parent.frames[0].document.forms[0].reset.disabled=true;
	parent.frames[1].document.forms[0].search.disabled = false;
}

function reset()
{
		frames[1].document.location.reload();
		frames[2].document.location.href='../../eCommon/html/blank.html';
		frames[3].document.location.href='../../eCommon/html/blank.html';
		frames[4].document.location.href='../../eCommon/jsp/error.jsp';
		//parent.frames[1].document.forms[0].search.disabled = false;

}

function setFocus()
  {
	   if(document.forms[0].patient_id)
	  {
		   document.forms[0].patient_id.focus();
	  }
  }

  function disReset()
  {
	 // parent.parent.frames[0].document.getElementById("reset").disabled= true;
  }

  function checkDate(obj){	
		if(obj.value!="") {
			 if((!isBeforeNow(obj.value,'DMY',localeName))) 	{
				alert(getMessage("START_DATE_GREATER_SYSDATE","common"))
				obj.value = '';
				obj.focus();
				return false;
			 }else
			{
				 return true; //Added by Ashwini on 04-Oct-2018 for ML-MMOH-CRF-1042
			}
		}
}

function searchPatient(obj)
{
if(obj!='')
	{
		var sou_value="1";
		parent.frames[4].document.location.href="../../eAE/jsp/AEcommonValidation.jsp?P_Patient_ID="+obj.value+"&sou_value="+sou_value;
	}
}

/*Added by Ashwini on 04-Oct-2018 for ML-MMOH-CRF-1042*/
function ComparePeriodFromToTime(from,to)
{
	var frdt = from.value;
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}
	
	if(greg_frdt != "" && greg_tdt !="")
	{
		if(!isBefore(greg_frdt,greg_tdt,"DMY","en"))
		{
			alert( getMessage("TO_DT_GR_EQ_FM_DT",'SM') );
			document.forms[0].visit_date_to.value = '';
			document.forms[0].visit_date_to.focus();
		}
	}
}
/*End ML-MMOH-CRF-1042*/
