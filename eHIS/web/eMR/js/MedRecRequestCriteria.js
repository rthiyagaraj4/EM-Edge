function reset()
{	
	f_query_add_mod.location.reload();

	if(f_query_add_mod.document.forms[0].call_function.value == 'MR_VIEW_DTH_REG')
		document.frames[2].location.href='../../eCommon/html/blank.html' ;
	
	/*criteriaFrame.location.reload();

	if(criteriaFrame.document.forms[0].call_function.value == 'MR_VIEW_DTH_REG')
		document.frames[2].location.href='../../eCommon/html/blank.html' ;*/
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
			alert(msg);
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
			alert(msg);
			obj2.select();
			obj2.focus();

		}
	}
}




//added by kishore on 5/23/2005
function CompareSysDatecriteria(sysdate,obj)
{
	/*
	var fromdate = obj.value;
	var SystemDate = sysdate.value;
	var error=getMessage("MRDATE1_GT_DATE2","MR");
	var result = "Pass";
	if(fromdate != '')
	{
		if(!doDateCheckAlert(sysdate, obj))
//		if (ValidateDateTime(sysdate, obj))
		{
			error= error.replace('$','Encounter Period');
			error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
			alert(error);
			obj.select();
			obj.focus();
			result = "Fail";
		}
	}
*/
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
	splittime=a[1];

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
	var patientid= await PatientSearch('','','','','','','Y','','','VIEW');
	
		if(patientid !=null)
		document.forms[0].PatientId.value = patientid; 
		document.forms[0].PatientId.focus();
	
}
function clearPage() {

	 if (document.forms[0].call_function.value == "RECORD_DIAGNOSIS")
	{
		
		parent.frames[2].document.location.href ='../../eCommon/html/blank.html';	
 
		if(parent.messageFrame)
			parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
		


	}  
	 
}

function clearAll()
{
	
	if(document.forms[0].call_function.value == 'MR_VIEW_DTH_REG'){
			if(parent.frames[2].name == "resultFrame")
				parent.resultFrame.document.location.href ='../../eCommon/html/blank.html';
			else
				parent.frames[2].document.location.href ='../../eCommon/html/blank.html';

			if(parent.frames[3])
				parent.frames[3].document.location.href ='../../eCommon/html/blank.html';
					
			if(parent.messageFrame)
				parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';


	}
	else if(document.forms[0].call_function.value =="DIAG_RECODE")
	{
		//parent.frames[1].document.location.reload();
		if(parent.frames[2].name == "resultFrame")
				parent.resultFrame.document.location.href ='../../eCommon/html/blank.html';
			else
				parent.frames[2].document.location.href ='../../eCommon/html/blank.html';

			//if(parent.frames[3])
				//parent.frames[3].document.location.reload();

	}
	/*Friday, September 04, 2009  code added for the Record Diagnosis function clearing.. */
	else if (document.forms[0].call_function.value == "RECORD_DIAGNOSIS")
	{
		
		parent.frames[2].document.location.href ='../../eCommon/html/blank.html';	

		if(parent.messageFrame)
			parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
		


	}  
	/*code added for clearing the  Marking od mLc
	@Date :Friday, February 05, 2010
	@ICNO:18925
	@modified by Anjaneya Reddy*/
	else if(document.forms[0].call_function.value == "MARK_MLC_OSCC")
	{
		parent.frames[2].document.location.href ='../../eCommon/html/blank.html';	

		if(parent.messageFrame)
			parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	}
	

	else if(document.forms[0].call_function.value == "TRANSMIT_NOTIFY_REP")
	{
		parent.frames[2].document.location.href ='../../eCommon/html/blank.html';	

		if(parent.messageFrame)
			parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';

	}
	else if(document.forms[0].call_function.value == "CONF_TRANSMIT_NOTIFY_REP")
	{
		parent.frames[2].document.location.href ='../../eCommon/html/blank.html';	

		if(parent.messageFrame)
			parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';

	}

	else if(document.forms[0].call_function.value == "MR_REC_PAT_VAL")
	{
	
		parent.frames[2].document.location.href ='../../eCommon/html/blank.html';	

		if(parent.messageFrame)
			parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';

	}

	/*---------------*/

	else if(document.forms[0].call_function.value == "REPRINT_PAT_VAL" || document.forms[0].call_function.value == "MR_INTERNAL_REPORTS_REPRINT")
	{
		if(document.forms[0].call_function.value == "MR_INTERNAL_REPORTS_REPRINT")
		{
			parent.frames[3].document.location.href ='../../eCommon/html/blank.html';	
		}
		else
			parent.frames[2].document.location.href ='../../eCommon/html/blank.html';


	}
	else
	{
		if(document.forms[0].call_function.value == 'MEDICAL_REPORT_REQUEST' || document.forms[0].call_function.value == '')
		{
			parent.resultFrame.document.location.href ='../../eCommon/html/blank.html';		
		}
		else
		{
			if(parent.frames[2].name == "resultFrame")
				parent.resultFrame.document.location.href ='../../eCommon/html/blank.html';
			else
				parent.frames[2].document.location.href ='../../eCommon/html/blank.html';

			if(parent.frames[3])
				parent.frames[3].document.location.reload();
		}

		if(parent.messageFrame)
			parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	}
}

function submitPage()
{
	var continue_yn = "Y";
	if(document.forms[0].call_function.value =='MARK_MLC_OSCC'||document.forms[0].call_function.value=='TRANSMIT_NOTIFY_REP'||document.forms[0].call_function.value=='CONF_TRANSMIT_NOTIFY_REP'){
	
		parent.resultFrame.location.href ='../../eCommon/html/blank.html';

	}
	
	if(document.forms[0].call_function.value == 'MR_REC_PAT_VAL' || document.forms[0].call_function.value == 'REPRINT_PAT_VAL' || document.forms[0].call_function.value == 'MR_INTERNAL_REPORTS_REPRINT' && document.forms[0].reportname.value != 'MR')
	{	
		if(document.forms[0].alt_id2_exp_date.value == '')
		{
			parent.resultFrame.location.href ='../../eCommon/html/blank.html';
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("eMR.EncPeriod.label","MR")+" "+getLabel("Common.to.label","Common"));
			alert(error);
			document.forms[0].alt_id2_exp_date.focus();

		}
		else if(document.forms[0].alt_id1_exp_date.value == '')
		{
			parent.resultFrame.location.href ='../../eCommon/html/blank.html';
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("eMR.EncPeriod.label","MR")+" "+getLabel("Common.from.label","Common"));
			alert(error);
			document.forms[0].alt_id1_exp_date.focus();
		}
		else if(document.forms[0].lstPatientClass.value == '')
		{
			parent.resultFrame.location.href ='../../eCommon/html/blank.html';
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("Common.encountertype.label","Common"));
			alert(error);
			document.forms[0].lstPatientClass.focus();
			
		}
	}

	if(document.forms[0].call_function.value == 'DIAG_RECODE')
	{
		
		 if(document.forms[0].lstPatientClass.value == '')
		{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("Common.encountertype.label","Common"));
			alert(error);
			document.forms[0].lstPatientClass.focus();
		}
		/*else 
		{

			if(document.forms[0].lstPatientClass.value == 'OP' || document.forms[0].lstPatientClass.value == 'EM')
			{
				if(document.forms[0].alt_id1_exp_date.value == '')
				{
					continue_yn = "N";
					error  = getMessage("CAN_NOT_BE_BLANK","Common");
					error = error.replace('$', getLabel("eMR.EncPeriod.label","MR")+" "+getLabel("Common.from.label","Common"));
					alert(error);
					document.forms[0].alt_id1_exp_date.focus();
				}
				else if(document.forms[0].alt_id2_exp_date.value == '')
				{
					continue_yn = "N";
					error  = getMessage("CAN_NOT_BE_BLANK","Common");
					error = error.replace('$', getLabel("eMR.EncPeriod.label","MR")+" "+getLabel("Common.to.label","Common"));
					alert(error);
					document.forms[0].alt_id2_exp_date.focus();
				}
				else if(document.forms[0].search_by.value=='M'||document.forms[0].search_by.value=='A'){
								if(document.forms[0].status.value==''){
									error  = getMessage("CAN_NOT_BE_BLANK","Common");
									error = error.replace('$', getLabel("Common.status.label","Common"));
									alert(error);
									document.forms[0].status.focus();
									clearAll();
									return;
								}

				}
			}
			else if(document.forms[0].lstPatientClass.value == 'IP' || document.forms[0].lstPatientClass.value == 'DC')
			{
				if(document.forms[0].dischargedatefrom.value == '')
				{
					continue_yn = "N";
					error  = getMessage("CAN_NOT_BE_BLANK","Common");
					error = error.replace('$', getLabel("eMR.DischPeriod.label","MR")+" "+getLabel("Common.from.label","Common"));
					alert(error);
					document.forms[0].dischargedatefrom.focus();
				}
				else if(document.forms[0].dischargedateto.value == '')
				{
					continue_yn = "N";
					error  = getMessage("CAN_NOT_BE_BLANK","Common");
					error = error.replace('$', getLabel("eMR.DischPeriod.label","MR")+" "+getLabel("Common.to.label","Common"));
					alert(error);
					document.forms[0].dischargedateto.focus();
				}
				else if(document.forms[0].search_by.value=='M'||document.forms[0].search_by.value=='A'){
								if(document.forms[0].status.value==''){
									error  = getMessage("CAN_NOT_BE_BLANK","Common");
									error = error.replace('$', getLabel("Common.status.label","Common"));
									alert(error);
									clearAll();
									document.forms[0].status.focus();
									return;
								}

				}


			}
		}*/
		
	}
	
	if(document.forms[0].call_function.value!='QUERY_MARK_MLC_OSCC' && document.forms[0].call_function.value!='QUERY_MATERNAL_REPORT' && document.forms[0].call_function.value!= 'DIAG_RECODE' && document.forms[0].call_function.value!= 'MR_REC_PAT_VAL' && document.forms[0].call_function.value!= 'REPRINT_PAT_VAL' &&  document.forms[0].call_function.value != 'MR_INTERNAL_REPORTS_REPRINT'&& document.forms[0].call_function.value!= 'MR_VIEW_DTH_REG') 
	{
		
		if(document.forms[0].PatientId.value == '')
		{	continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("Common.patientId.label","Common"));
			alert(error);
			document.forms[0].PatientId.focus();
		}
		
	}
	
	if((document.forms[0].call_function.value == 'RECORD_DIAGNOSIS' || document.forms[0].call_function.value == 'PROCEDURE_RECORDING') && (document.forms[0].lstPatientClass.value == '' && document.forms[0].PatientId.value !=''))
	{
			continue_yn = "N";
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("Common.encountertype.label","Common"));
			alert(error);
			document.forms[0].lstPatientClass.focus();
	}
	

	if(continue_yn == "Y")
	{
		
		var condition="";
		for(var i=0; i<document.forms[0].elements.length; i++){
				condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&";
		}	
		oper_stn = document.forms[0].operstn.value;
		create_file_yn = document.forms[0].create_file_yn.value;
		

		var call_function = document.forms[0].call_function.value;
		
		//var discharge_val=document.forms[0].discharge_val.value;

		if(document.forms[0].call_function.value == 'MEDICAL_REPORT_REQUEST')
		{
			//added on 31-07-08 for SCR 4964
			if(document.forms[0].PatientId.value != '')
			{
				var error_jsp="";
				var messageFrame="";
				var conVal="Y";
			
				var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='valid_form' id='valid_form' method='post' action='../../eMR/jsp/MRPatientIDValidations.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+document.forms[0].PatientId.value+"'><input type='hidden' name='called_from' id='called_from' value='MEDICAL_REPORT_REQUEST'><input type='hidden' name='query_String' id='query_String' value='"+document.forms[0].qerString.value+"'><input type='hidden' name='condition' id='condition' value='"+condition+"'><input type='hidden' name='oper_stn' id='oper_stn' value='"+oper_stn+"'><input type='hidden' name='conVal' id='conVal' value='"+conVal+"'></form></BODY></HTML>";
	
				 parent.messageFrame.document.write(HTMLVal);
				 parent.messageFrame.valid_form.submit();
				//modified  on 31-07-08 for SCR 4964
				//parent.frames[3].location.href= '../../eMR/jsp/MedRecRequestFrames.jsp?'+document.forms[0].qerString.value+'&'+condition+'&oper_stn_id='+oper_stn+'&show_bed_yn=Y&fromSelect=fromSelect';
			}
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
					//Decsdfromdate = 	document.forms[0].p_discharge_date_from.value;
					if(document.forms[0].p_discharge_date_from.value!='')
						Decsdfromdate	=	convertDate(document.forms[0].p_discharge_date_from.value,'DMY',localeName,'en');
					
				}
			var Decsdtodate=	"";
				if ( document.forms[0].p_discharge_date_to)
				{
					//Decsdtodate = 	document.forms[0].p_discharge_date_to.value;
					if(document.forms[0].p_discharge_date_to.value!='')
						Decsdtodate	=	convertDate(document.forms[0].p_discharge_date_to.value,'DMY',localeName,'en');

					
				}

			if(PatientId=="" && (Decsdfromdate=="" || Decsdtodate==""))
			{
			   error=getMessage("MR_VIEW_DTH_REG","MR");
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
					AdmnDateFrom = 	document.forms[0].AdmnDateFrom.value;
					

				}
				var AdmnDateTo=	"";
				if ( document.forms[0].alt_id2_exp_date)
				{
					//AdmnDateTo = 	document.forms[0].alt_id2_exp_date.value;
					if(document.forms[0].alt_id2_exp_date.value!='')
						AdmnDateTo = convertDate(document.forms[0].alt_id2_exp_date.value,'DMY',localeName,'en');
					
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
				parent.frames[3].location.href= '../../eMR/jsp/DeathRegisterColourInd.jsp';

				parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
			}
		}
		else
		{
		
		 //alert("speciality "+document.forms[0].speciality_code.value);

		if(document.forms[0].call_function.value == 'MR_INTERNAL_REPORTS_REPRINT')
		{ var URL="../../eMR/jsp/MedRecRequestResult.jsp?&"+condition+"&oper_stn_id="+oper_stn+"&show_bed_yn=Y&fromSelect=fromSelect&reportname="+document.forms[0].reportname.value+"&status_to_show="+document.forms[0].status_to_show+"&from_date="+document.forms[0].from_date+"&to_date="+document.forms[0].to_date;
		
			parent.frames[3].location.href=URL;

		}
		else if(document.forms[0].call_function.value == 'DIAG_RECODE')
		{
			 //alert(document.forms[0].status.value);
			var speciality_code = document.forms[0].speciality_code.value;
			var location_code = document.forms[0].Hloc.value;
			var status = document.forms[0].status.value;
			var stage_no = document.forms[0].stage_no.value;
			var search_by = document.forms[0].search_by.value;
			parent.frames[2].location.href="../../eMR/jsp/MedRecRequestResult.jsp?clear=session&"+condition+"&oper_stn_id="+oper_stn+"&show_bed_yn=Y&fromSelect=fromSelect&speciality_code="+speciality_code+"&location_code="+location_code+"&status="+status+"&stage_no="+stage_no+"&search_by"+search_by;	
;
		}else{ 
			parent.frames[2].location.href="../../eMR/jsp/MedRecRequestResult.jsp?&"+condition+"&oper_stn_id="+oper_stn+"&create_file_yn="+create_file_yn+"&show_bed_yn=Y&fromSelect=fromSelect";
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
}
//Below modified for ML-MMOH-SCF-1854
function submitPageVal(statusFlag)
{
	
	if(statusFlag=="Y")
	{

		submitPage();
		document.getElementById('statusFlag').value='N';
	}
	else
	{
 
var call_function=document.forms[0].call_function.value;
if(document.forms[0].PatientId.value!='')
	{
	    var fields = new Array (document.forms[0].PatientId); 
        var names = new Array (getLabel("Common.patientId.label","Common"));
		var patient_id = document.forms[0].PatientId.value;
		var error_jsp="";
		var messageFrame="";
	    var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='valid_form' id='valid_form' method='post' action='../../eMR/jsp/MRPatientIDValidations.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='called_from' id='called_from' value='MEDICAL_REPORT_REQUEST'><input type='hidden' name='call_function' id='call_function' value='"+call_function+"'></form></BODY></HTML>";
	 
	    parent.messageFrame.document.write(HTMLVal);
	    /*parent.messageFrame.valid_form.action="../../eCommon/jsp/report_options.jsp";
	    parent.messageFrame.valid_form.target="messageFrame";*/
	    parent.messageFrame.valid_form.submit();
	}		
	}
}
function submitButtonClick()
{	
document.getElementById('search').onclick = function() {
document.getElementById('statusFlag').value='Y';
if(document.getElementById('statusFlag').value=='Y')
	{
		submitPage();
		document.getElementById('statusFlag').value='N';
	}
}

}
//added on 31-07-08 for SCR 4964
function PatValidations(obj)
{
	var call_function=document.forms[0].call_function.value
	var statusFlag='';
	submitButtonClick();
	
	setTimeout(function(){
		submitPageVal(document.getElementById('statusFlag').value);
		}, 2000);

	
		
	/*if(call_function=='RECORD_DIAGNOSIS') {
		parent.frames[2].document.location.href ='../../eCommon/html/blank.html';	

		if(parent.messageFrame)
		parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}*/
	/*if(document.forms[0].PatientId.value!='')
	{
	    var fields = new Array (document.forms[0].PatientId); 
        var names = new Array (getLabel("Common.patientId.label","Common"));
		var patient_id = document.forms[0].PatientId.value;
		var error_jsp="";
		var messageFrame="";
	    var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='valid_form' id='valid_form' method='post' action='../../eMR/jsp/MRPatientIDValidations.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='called_from' id='called_from' value='MEDICAL_REPORT_REQUEST'><input type='hidden' name='call_function' id='call_function' value='"+call_function+"'></form></BODY></HTML>";
	 
	    parent.messageFrame.document.write(HTMLVal);
	    parent.messageFrame.valid_form.submit();
	}
	
	*/
	
}

function clearResultPage(obj){
	if(document.getElementById("param").value=='MEDICAL_REPORT_REQUEST' || document.getElementById("param").value=='MR_INTERNAL_REPORTS_REPRINT')
	{
		parent.frames[3].document.location.href ='../../eCommon/html/blank.html';
		}
		else
		
	parent.frames[2].document.location.href ='../../eCommon/html/blank.html';

}
function getStatus(obj)
{
	
	var obj_type = document.forms[0].status;
	var length  = obj_type.length;
	for(i=0;i<=length;i++) 
	{
		obj_type.remove(1);
	}

	if(obj.value == 'M')
	{
	document.forms[0].mand_gif3.style.visibility="visible";
		var opt = "";
				/*opt = document.createElement("OPTION");
				opt.text =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
				opt.value= '';
				document.forms[0].status.add(opt)*/
				/*opt = document.createElement("OPTION");
				opt.text = getLabel("eMR.PendingReview.label","MR");
				opt.value= 'PR';
				document.forms[0].status.add(opt)*/
				opt = document.createElement("OPTION");
				opt.text = getLabel("Common.PartiallyCompleted.label","common");
				opt.value= 'PC';
				document.forms[0].status.add(opt)
				opt = document.createElement("OPTION");
				opt.text = getLabel("Common.completed.label","common");
				opt.value= 'C';
				document.forms[0].status.add(opt);
				opt = document.createElement("OPTION");
				opt.text = getLabel("Common.Authorized.label","common");
				opt.value= 'A';
				document.forms[0].status.add(opt);
					

	}
	else if(obj.value == 'A')
	{
		document.forms[0].mand_gif3.style.visibility="visible";
		var opt = "";
				//opt = document.createElement("OPTION");
				//opt.text =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
				//opt.value= '';
				//document.forms[0].status.add(opt)
				//opt = document.createElement("OPTION");
				//opt.text = getLabel("eMR.PendingReview.label","MR");
				//opt.value= 'PR';
				//document.forms[0].status.add(opt)
				opt = document.createElement("OPTION");
				opt.text = getLabel("Common.PartiallyCompleted.label","common");
				opt.value= 'PC';
				document.forms[0].status.add(opt);
				opt = document.createElement("OPTION");
				opt.text = getLabel("Common.Authorized.label","common");
				opt.value= 'A';
				document.forms[0].status.add(opt);

	}
	else if(obj.value =="")
		document.forms[0].mand_gif3.style.visibility="hidden";


parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
}

function restSPeLoc(obj){

	document.forms[0].speciality_code.value="";
	document.forms[0].Hloc.value="";
	document.forms[0].locn_code.value="";

}
function resetLoc(obj){
	document.forms[0].Hloc.value="";
	document.forms[0].locn_code.value="";

}

