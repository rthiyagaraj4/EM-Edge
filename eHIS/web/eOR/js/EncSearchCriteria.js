/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?			?				?													?
21/10/2015    IN057196	    Ramesh G		Recording Of Consent Form
---------------------------------------------------------------------------------------------------------------
*/
function reset()
{	
	
	if(f_query_add_mod.document.getElementById('call_function').value == 'MR_VIEW_DTH_REG'){
		document.frames[2].location.href='../../eCommon/html/blank.html' ;		
	}
	f_query_add_mod.location.reload();
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
			var msg = getMessage("MRDATE1_LT_DATE2","MR");
			msg = msg.replace('$',getLabel("eMR.EncPeriod.label","MR")+" "+getLabel("Common.from.label","Common"));
			msg = msg.replace('#',getLabel("Common.SystemDate.label","Common"));
			alert(msg)
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
			var msg = getMessage("MRDATE1_LT_DATE2","MR");
			msg = msg.replace('$',getLabel("eMR.EncPeriod.label","MR")+" "+getLabel("Common.to.label","Common"));
			msg = msg.replace('#',getLabel("eMR.EncPeriod.label","MR")+" "+getLabel("Common.from.label","Common"));
			alert(msg)
			obj2.select();
			obj2.focus();

		}
	}
}

// This function will check for month value... It will fire an alert msg if the month contains zeroes...
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

	 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));

	 a=obj2.split(" ")
	 splitdate=a[0];
	 splittime=a[1]

	 splitdate1 = a[0].split("/")
	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));

	 if(Date.parse(to_date) < Date.parse(from_date))
	{
		alert( getMessage("TO_DT_GR_EQ_FM_DT","SM") );
		
		/* The focus and select will be done in JSP
		document.forms[0].alt_id2_exp_date.focus();
		document.forms[0].alt_id2_exp_date.select();
		*/
		return false;
	}
	else
		return true;
}

function CheckNumVal(obj)
{
	if (parseInt(obj.value) <= 0)
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO',"IP"));
		obj.select();
	}
	else
	{
		CheckNum(obj);
	}
}

async function callSearchScreen()
{
	var patientid=await PatientSearch('','','','','','','Y','','','VIEW');
	
		if(patientid !=null)
		document.forms[0].PatientId.value = patientid; 
		document.forms[0].PatientId.focus();
	
}

function clearAll()
{	
	if(document.forms[0].call_function.value == 'MEDICAL_REPORT_REQUEST' || document.forms[0].call_function.value == '')
	{
		parent.f_query_add_mod.document.location.href ='../../eCommon/html/blank.html';		
	}
	else
	{
		if(parent.frames[2].name == "resultFrame")
			parent.f_query_add_mod.document.location.href ='../../eCommon/html/blank.html';
		else
			parent.frames[2].document.location.href ='../../eCommon/html/blank.html';

//		if(parent.frames[3])
//			parent.frames[3].document.location.reload();
	}

	if(parent.messageFrame)
		parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function submitPage()
{  
	 
	var continue_yn = "Y";
	if(document.forms[0].call_function.value == 'MR_REC_PAT_VAL' || document.forms[0].call_function.value == 'REPRINT_PAT_VAL')
	{
		
		if(document.forms[0].alt_id2_exp_date.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("eMR.EncPeriod.label","MR")+" "+getLabel("Common.to.label","Common"));
			alert(error);
			document.forms[0].alt_id2_exp_date.focus();
		}
		else if(document.forms[0].alt_id1_exp_date.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("eMR.EncPeriod.label","MR")+" "+getLabel("Common.from.label","Common"));
			alert(error);
			document.forms[0].alt_id1_exp_date.focus();
		}
		else if(document.forms[0].lstPatientClass.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("Common.encountertype.label","Common"));
			alert(error);
			document.forms[0].lstPatientClass.focus(); 
		}
	}

	if(document.forms[0].call_function.value == 'GEN_PLACE_ORDER' || document.forms[0].call_function.value == 'MR_DIAGNOSIS')
	{
		if(document.forms[0].p_encounter_id.value == '')
		{
			if(document.forms[0].lstPatientClass.value == '')
			{
				continue_yn = "N";
				error  = getMessage("CAN_NOT_BE_BLANK","Common");
				error = error.replace('$', getLabel("Common.encountertype.label","Common"));
				alert(error);
				document.forms[0].lstPatientClass.focus();
			}
		}
		else
		{
			document.getElementById("encType_img").style.visibility="hidden";
		}
		if(document.forms[0].lstPatientClass.value == 'XT')
		{
			if(document.forms[0].PatientId.value == '')
			{
				continue_yn = "N";
				error  = getMessage("CAN_NOT_BE_BLANK","Common");
				error = error.replace('$', getLabel("Common.patientId.label","Common"));
				alert(error);
				document.forms[0].PatientId.focus();
			}
		}
	}
	if(document.forms[0].call_function.value == 'DIAG_RECODE')
	{
		
		if(document.forms[0].p_discharge_date_from.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("eMR.DischPeriod.label","MR")+" "+getLabel("Common.from.label","Common"));
			alert(error);
			document.forms[0].p_discharge_date_from.focus();
		}
		else if(document.forms[0].p_discharge_date_to.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("eMR.DischPeriod.label","MR")+" "+getLabel("Common.to.label","Common"));
			alert(error);
			document.forms[0].p_discharge_date_to.focus();
		}
		else if(document.forms[0].lstPatientClass.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("Common.encountertype.label","Common"));
			alert(error);
			document.forms[0].lstPatientClass.focus();
		}
	}
	
	if(document.forms[0].call_function.value!='QUERY_MARK_MLC_OSCC' && document.forms[0].call_function.value!='QUERY_MATERNAL_REPORT' && document.forms[0].call_function.value!= 'DIAG_RECODE' && document.forms[0].call_function.value!= 'MR_REC_PAT_VAL' && document.forms[0].call_function.value!= 'REPRINT_PAT_VAL' && document.forms[0].call_function.value!= 'MR_VIEW_DTH_REG' && document.forms[0].call_function.value!= 'GEN_PLACE_ORDER') 
	{
	
		if(document.forms[0].PatientId.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("Common.patientId.label","Common"));
			alert(error);
			document.forms[0].PatientId.focus();
		}
	}
	if(continue_yn == "Y")
	{
		var condition=""
		for(var i=0; i<document.forms[0].elements.length; i++)
			condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
				
		if(document.forms[0].lstPatientClass.value == 'XT')
		{
			var patientClass = document.forms[0].lstPatientClass.value;
			var encounterId = document.forms[0].p_encounter_id.value;
			var patientId = document.forms[0].PatientId.value;
			var FacilityId = document.forms[0].p_facility_id.value;
			callWin(patientClass, 'ORDER_ENTRY', encounterId, patientId, '','',FacilityId);
		}
		else
		{
			
			oper_stn = document.forms[0].operstn.value;


			var call_function = document.forms[0].call_function.value;
			var cnsnt_with_order_yn = document.forms[0].cnsnt_with_order_yn.value; //IN057196
			//var discharge_val=document.forms[0].discharge_val.value;
				//alert(document.forms[0].discharge_val.value)
				//	alert("discharge_val"+discharge_val);

			if(document.forms[0].call_function.value == 'MEDICAL_REPORT_REQUEST')
			{
				
				parent.frames[3].location.href= '../../eMR/jsp/MedRecRequestFrames.jsp?'+document.forms[0].qerString.value+'&'+condition+'&oper_stn_id='+oper_stn+'&show_bed_yn=Y&fromSelect=fromSelect';
			}
			else
			if(document.forms[0].call_function.value == 'MR_VIEW_DTH_REG')
			{
				var PatientId=	"";
				if ( document.forms[0].PatientId)
				{
					PatientId = 	document.forms[0].PatientId.value;
				}
				var Decsdfromdate=	"";
					if ( document.forms[0].p_discharge_date_from)
					{
						Decsdfromdate = 	convertDate(document.forms[0].p_discharge_date_from.value,'DMY',localeName,'en');
					}
				var Decsdtodate=	"";
					if ( document.forms[0].p_discharge_date_to)
					{
						Decsdtodate = 	convertDate(document.forms[0].p_discharge_date_to.value,'DMY',localeName,'en');
					}

				if(PatientId=="" && (Decsdfromdate=="" || Decsdtodate==""))
				{
				   error=geteMRMessage("MR_VIEW_DTH_REG");
				   parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+error+'&err_value=0';
				}
				else
				{
					var EncounterId=	"";
					if ( document.forms[0].p_encounter_id)
					{
						EncounterId = 	document.forms[0].p_encounter_id.value;
					}
					var AdmnDateFrom=	"";
					if ( document.forms[0].AdmnDateFrom)
					{
						AdmnDateFrom = convertDate(document.forms[0].AdmnDateFrom.value,'DMY',localeName,'en');
					}
					var AdmnDateTo=	"";
					if ( document.forms[0].alt_id2_exp_date)
					{
						AdmnDateTo = 	convertDate(document.forms[0].alt_id2_exp_date.value,'DMY',localeName,'en');
					}
					var PatientClass=	"";
					if ( document.forms[0].lstPatientClass)
					{
						PatientClass = 	document.forms[0].lstPatientClass.value;
					}
					var NRIC=	"";
					if ( document.forms[0].national_id_no)
					{
						NRIC = 	document.forms[0].national_id_no.value;
					}
					var Birth_Cert=	"";
					if ( document.forms[0].alt_id1_no)
					{
						Birth_Cert = 	document.forms[0].alt_id1_no.value;
					}
					var PMI=	"";
					if ( document.forms[0].alt_id2_no)
					{
						PMI = 	document.forms[0].alt_id2_no.value;
					}
					var Police_ID=	"";
					if ( document.forms[0].alt_id3_no)
					{
						Police_ID = 	document.forms[0].alt_id3_no.value;
					}
					var Old_IC_No1=	"";
					if ( document.forms[0].alt_id4_no)
					{
						Old_IC_No1 = 	document.forms[0].alt_id4_no.value;
					}
					var Other_Alt_ID_Type=	"";
					if ( document.forms[0].other_alt_type)
					{
						Other_Alt_ID_Type = 	document.forms[0].other_alt_type.value;
					}
					var Other_Alt_ID_No=	"";
					if ( document.forms[0].other_alt_Id)
					{
						Other_Alt_ID_No = 	document.forms[0].other_alt_Id.value;
					}
					var OrderBy=	"";
					if ( document.forms[0].orderBy)
					{
						OrderBy = 	document.forms[0].orderBy.value;
					}
					document.forms[0].search.disabled = true;
					parent.frames[2].location.href= '../../eMR/jsp/ViewDeathRegisterResult.jsp?PatientId='+PatientId+'&EncounterId='+EncounterId+'&AdmnDateFrom='+AdmnDateFrom+'&AdmnDateTo='+AdmnDateTo+'&DischargeDateFrom='+Decsdfromdate+'&DischargeDateTo='+Decsdtodate+'&PatientClass='+PatientClass+'&NRIC='+NRIC+'&Birth_Cert='+Birth_Cert+'&PMI='+PMI+'&Police_ID='+Police_ID+'&Old_IC_No1='+Old_IC_No1+'&Other_Alt_ID_Type='+Other_Alt_ID_Type+'&Other_Alt_ID_No='+Other_Alt_ID_No+'&OrderBy='+OrderBy;
					
					parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
				}
			}
			else
			{
				parent.frames[2].location.href="../../eOR/jsp/EncSearchResult.jsp?&"+condition+"&oper_stn_id="+oper_stn+"&show_bed_yn=Y&fromSelect=fromSelect&cnsnt_with_order_yn="+cnsnt_with_order_yn;
			}
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
	else
	{
		parent.frames[2].location.href="../../eCommon/html/blank.html";
	}
}
function validDateObj(date, format, locale){
	if (date.value != '')
	{
		if ( !validDate(date.value, format, locale) )
		{
			if(top.header != null)
				alert(top.header.getMessage("INVALID_DATE_FMT", "SM"));
			else
				alert(getMessage("INVALID_DATE_FMT", "SM"));

			date.select();
			date.focus();
			return false;
		}
		else
			return true;
	}
}
function EncTypeMand(obj)
{
	if(obj.value!="")
	{
		document.getElementById("encType_img").style.visibility="hidden";
	}
	else
	{
		document.getElementById("encType_img").style.visibility="visible";
	}
}
function chkMandPatient(obj)
{
	if((obj.value)=='XT')
	{
		document.getElementById("encTypePatID").style.visibility="visible";
	}
	else
	{
		document.getElementById("encTypePatID").style.visibility="hidden";
	}
}

function callcheck_val()
{ 
	if (document.forms[0].discharge_val.checked==true)
		document.forms[0].discharge_val.value="Y";
	else
		document.forms[0].discharge_val.value="N";
}

//Func will return an alert message if FROM DATE is null and TO Date is selected
function checkFromDt(to,frmDt)
{
	if ( (frmDt.value=='') && (to.value!='') )
	{
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("Common.fromdate.label","Common"));		
		alert(error);
		to.value='';
		frmDt.focus();
	}
		return;
}

function doDcsdDateCheck(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) <= Date.parse(fromdt)) {
                return false;
            }
            else if(Date.parse(todt) > Date.parse(fromdt)) return true;
    }
return true;
}

function DscdPeriodChk(Dt)
{		
	if(Dt.value!="")	
	{
		var SystemDate	= document.forms[0].SystemDate.value;
		if(validDate(Dt.value,"DMY","en"))
		{
			var toDt	= convertDate(Dt.value,"DMY",localeName,"en");
			if(!isAfter(SystemDate,toDt,'DMY',localeName))// DateUtils.js
			{
				error=getMessage("MRDATE1_GT_DATE2","MR");
				error = error.replace('$', getLabel("eMR.DeceasedPeriod.label","MR"));		
				error = error.replace('#', getLabel("Common.CurrentDate.label","Common"));	
				alert(error);
				Dt.value='';
				Dt.focus();
			}
		}
	return;
}
}

//FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] 
//Func will return an alert message if TO DATE is Less than FROM DATE
function ComparePeriodFromToTime(from,to)
{
	var frdt = from.value;
	var tdt = to.value;

	if(frdt !='' && tdt !='' )// DateUtils.js
	{
		if(validDate(frdt,"DMY","en") && validDate(tdt,"DMY","en"))
		{
			var fromDt	= convertDate(frdt,"DMY",localeName,"en");
			var toDt	= convertDate(tdt,"DMY",localeName,"en");

			if(!isBefore(fromDt,toDt,'DMY',localeName))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.focus();
			}
		}
	}
}
function chkPatientID(obj)
{
	if(obj.value!='')
	{
		var patientId =obj.value;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eOR/jsp/EncSearchValidate.jsp?&operation_mode=patIDValid&patientId="+patientId, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
	}


}
 
function patValidCheck(patientIdStatus)
 {
	
	if(patientIdStatus=="INVALID_PATIENT")
	{
		alert(getMessage('INVALID_PATIENT','MP'));
		document.getElementById("PatientId").value = "";
		return false;
	}

 }
