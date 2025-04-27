function reset()
{	
	f_query_add_mod.document.forms[0].reset();
}

function Valid_DT(event)
{
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function CompareSysDate(obj,sysdate)
{
	var fromdate = obj.value;
	var SystemDate = sysdate.value;

	var result = "Pass";
	if(fromdate != '')
	{
		if (ValidateDateTime(obj,sysdate))
		{
//			alert(self.getMessage('DIS_DATE_NOT_LESS_ADM_DATE'));
			alert("Encounter Period From cannot be less than System Date")
			obj.select();
			obj.focus();
			result = "Fail";
		}

		if(result == "Pass")
		{
			CompareDateTime(obj,document.forms[0].alt_id2_exp_date);
		}
	}
}

function CompareDateTime(obj1,obj2)
{
	if(obj1.value != '' && obj2.value != '')
	{
		if (ValidateDateTime(obj2,obj1))
		{
//			alert(self.getMessage('DIS_DATE_NOT_LESS_ADM_DATE'));
			alert("Encounter Period To cannot be less than Encounter Period From")
			obj2.select();
			obj2.focus();

		}
	}
}

//FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] 
//Func will return an alert message if TO DATE is Less than FROM DATE
function ComparePeriodFromToTime(from,to)
{
	
	var continue_YN = "";
		
		if(to.value != '' )
		{
			if(!doDateTimeChk(to))
			{
				continue_YN = "N";
				alert( getMessage("INVALID_DATE_TIME") );
				to.focus();
				to.select();
				return ;
			}
			else
				continue_YN = "Y";
			
			var a=to.value.split(" ")
			splitdate=a[0];
			if(!CheckZeroMonths(splitdate))
			{
				continue_YN = "N";
				alert( getMessage("INVALID_DATE_TIME") );
				to.focus();
				to.select();
				return ;
			}
			else
				continue_YN = "Y";
		}

		if(from.value != '' )
		{
			if(!doDateTimeChk(from))
			{
				continue_YN = "N";
				alert( getMessage("INVALID_DATE_TIME") );
				from.focus();
				from.select();
				return ;
			}
			else
				continue_YN = "Y";

			var a=from.value.split(" ")
			splitdate=a[0];
			if(!CheckZeroMonths(splitdate))
			{
				continue_YN = "N";
				alert( getMessage("INVALID_DATE_TIME") );
				from.focus();
				from.select();
				return ;
			}
			else
				continue_YN = "Y";
		}


	if(continue_YN == "Y")
	{
		if(from.value != '' && to.value != '')
		{
			var frdt = from.value;
			var tdt = to.value;
			PeriodcheckDateTime(frdt,tdt);
		}
		else
			return ;
	}

}

//added by kishore on 5/23/2005
function CompareSysDatecriteria(sysdate,obj)
{
	var fromdate = obj.value;
	var SystemDate = sysdate.value;
	var error=geteMRMessage("MRDATE1_GT_DATE2");
	var result = "Pass";
	if(fromdate != '')
	{
		if (ValidateDateTime(sysdate,obj))
		{
//			alert(self.getMessage('DIS_DATE_NOT_LESS_ADM_DATE'));
			//alert("Encounter Period From cannot be greater than System Date");
			error= error.replace('$','Encounter Period');
			error= error.replace('#','System Date');
			alert(error);
			obj.select();
			obj.focus();
			result = "Fail";
		}

		/*if(result == "Pass")
		{
			CompareDateTime(obj,document.forms[0].obj);
		}*/
	}
}
/// ADDED by SRIDHAR R On 01 OCT 2004
/// This function will check for month value... It will fire an alert msg if the month contains zeroes...
function CheckZeroMonths(Object2) 
{
	var datefield = Object2;
    if (MonthChk(Object2) == false) 
	{
        return false;
    }
    else 
	{
        return true;
    }
}

function MonthChk(Object3) 
{
    var strDate;
    var strDay;
    var strMonth;
    var strYear;
    var datefield = Object3;
    var strDateArray = new Array();

    strDate = datefield;
    if (strDate.length == 0) return true;

if(Object3.indexOf('.') > 0) return false;

    strDateArray = strDate.split("/");
    if (strDateArray.length != 3) {
        return false;
    }
    else {
        strDay = strDateArray[0];
        strMonth = strDateArray[1];
        strYear = strDateArray[2];
    }


    if (strYear.length < 4 || strYear.length > 4) return false;

    if (isNaN(strDay)==true) return false;
    if (isNaN(strMonth)==true) return false;
    if (isNaN(strYear)==true) return false;

    if (strYear < 1800) return false;

        if (strMonth>12 || strMonth<1)  return false;

    if ((strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12) && (strDay > 31 || strDay < 1)) return false;

    if ((strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11) && (strDay > 30 || strDay < 1)) return false;

    if (strMonth == 2) {
        if (strDay < 1) return false;

        if (LeapYear(strYear) == true) {
            if (strDay > 29) return false;
        }
        else {
            if (strDay > 28) return false;
        }
    }
    return true;
}
/***************************/


function PeriodcheckDateTime(obj1,obj2)
{	
	var a=obj1.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 = a[0].split("/")
	var splittime1 = a[1].split(":")

	 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));

	 a=obj2.split(" ")
	 splitdate=a[0];
	 splittime=a[1]

	 splitdate1 = a[0].split("/")
	 splittime1 = a[1].split(":")

	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));

	 if(Date.parse(to_date) < Date.parse(from_date))
	{
		alert( getMessage("TO_DT_GR_EQ_FM_DT") );
		document.forms[0].alt_id2_exp_date.focus();
		document.forms[0].alt_id2_exp_date.select();
		return false;
	}
}

function CheckNumVal(obj)
{
	if (parseInt(obj.value) <= 0)
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO'));
		obj.select();
	}
	else
	{
		CheckNum(obj);
	}
}

function clearAll()
{	
	parent.resultFrame.document.location.href ='../../eCommon/html/blank.html';
	if(parent.frames[3])
	parent.frames[3].document.location.reload();
	if(parent.messageFrame)
	parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
			
}

function callSearchScreen()
{
	var patientid=PatientSearch('','','','','','','Y','','','VIEW');
	
		if(patientid !=null)
		document.forms[0].PatientId.value = patientid; 
		document.forms[0].PatientId.focus();
	
}

function submitPage()
{
	var continue_yn = "Y";
	if(document.forms[0].call_function.value == 'DIAG_RECODE')
	{
		if(document.forms[0].alt_id2_exp_date.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK");
			error = error.replace('$', "Enc Period To");
			alert(error);
			document.forms[0].alt_id2_exp_date.focus();
		}
		else if(document.forms[0].alt_id1_exp_date.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK");
			error = error.replace('$', "Enc Period From");
			alert(error);
			document.forms[0].alt_id1_exp_date.focus();
		}
		else if(document.forms[0].lstPatientClass.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK");
			error = error.replace('$', "Encounter Type");
			alert(error);
			document.forms[0].lstPatientClass.focus();
		}
	}
	if(document.forms[0].call_function.value!='QUERY_MARK_MLC_OSCC' && document.forms[0].call_function.value!='QUERY_MATERNAL_REPORT' && document.forms[0].call_function.value!= 'DIAG_RECODE' ) 
	{
		if(document.forms[0].PatientId.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK");
			error = error.replace('$', "Patient ID");
			alert(error);
			document.forms[0].PatientId.focus();
		}
	}
	if(continue_yn == "Y")
	{
		var condition=""
		for(var i=0; i<document.forms[0].elements.length; i++)
				condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
			
		oper_stn = document.forms[0].operstn.value;

		var call_function = document.forms[0].call_function.value;

		if(document.forms[0].call_function.value == 'MEDICAL_REPORT_REQUEST')
		{
			parent.frames[3].location.href= '../../eMR/jsp/MedRecRequestFrames.jsp?'+document.forms[0].qerString.value+'&'+condition+'&oper_stn_id='+oper_stn+'&show_bed_yn=Y&fromSelect=fromSelect';
		}
		else
		{
			parent.frames[2].location.href='../../eMR/jsp/RecordAdverseEventResult.jsp?'+document.forms[0].qerString.value+'&'+condition+'&oper_stn_id='+oper_stn+'&show_bed_yn=Y&fromSelect=fromSelect';
		}
/*

			if(document.forms[0].modal.value == 'yes')
			{
				parent.frames[1].location.href= '../../eMR/jsp/MedRecRequestFrames.jsp?'+document.forms[0].qerString.value+'&'+condition+'&oper_stn_id='+oper_stn+'&show_bed_yn=Y&fromSelect=fromSelect';
			}
			else
			{
				parent.frames[2].location.href= '../../eMR/jsp/MedRecRequestFrames.jsp?'+document.forms[0].qerString.value+'&'+condition+'&oper_stn_id='+oper_stn+'&show_bed_yn=Y&fromSelect=fromSelect';
			}
			*/
	}
}

function AdverseEvent(encID, PatID,Pract_id,pract_type,patient_class)
{
	var call_function = "RECORD_ALLERGY";
	var FacilityId = document.forms[0].FacilityId.value;
	
	var url="../../eMR/jsp/RecordPatientAdverseEvent2.jsp?Encounter_Id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&Pract_id="+Pract_id+"&practitioner_type="+pract_type+"&patient_class="+patient_class+"&call_function="+call_function;
	parent.frames[2].location.href=url;
	
	/*var call_function = "RECORD_ALLERGY";
	var FacilityId = document.forms[0].FacilityId.value;
	var dialogHeight= "30" ;
	var dialogWidth = "50" ;
	var dialogTop 	= "170";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = 	window.showModalDialog("../../eMR/jsp/RecordPatientAdverseEvent2.jsp?Encounter_Id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function,arguments,features);*/
}



