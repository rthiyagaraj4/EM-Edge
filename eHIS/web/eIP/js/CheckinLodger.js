/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	Lodger -> CheckInLodger 
/// Developer		:	SRIDHAR R
/// Created on		:	30 JULY 2004

/// ADDED BY SRIDHAR R on 17 MAY 2004 
/// This Function is called on click of the APPLY button on the tool bar...
/// It will Submit the form and Pass the values to Servlet...
function apply()
{ 
	// The if loop will check the value of the Patient ID entered by the user with pline [HEADER] Patient ID & allows to enter only if they are not same..
	if(parent.frames[0].document.LodgerForm.Category.value == 'A')
	{
		var FormPatID=parent.frames[0].document.LodgerForm.patient_id.value
		var PlinePatID =parent.frames[0].document.LodgerForm.pLine_Pat_id.value

		if(FormPatID == PlinePatID)
		{

            var msg= getMessage("ATTEND_PAT_ID_SAME","IP") ; 
			parent.frames[1].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
		}
		else
		{ 
			chkBeforeApply();
		}
	}
	else
	{ 
		chkBeforeApply();
	}
}

/// ADDED BY SRIDHAR ON 20 FEB 2004 
/// This function will Check for Validations in the form before submit...
function chkBeforeApply()
{

	
	
	 if(chkRefNo())
	{ 
		/* START OF ADDITION FOR MANDATORY FIELDS */
			var fields = new Array();
			var names = new Array ()			
			var p_label = parent.frames[0].document.LodgerForm.label.value;
           
			var i=0;		
			
		if (parent.frames[0].document.LodgerForm.reason_for_stay)
		{  
			fields[i] =parent.frames[0].document.LodgerForm.patient_id;
			names[i] =p_label+getLabel("Common.patientId.label","Common");
			i++;
		}
      
		
		/* below condition added by venkatesh.s (4008) on 5/June/2012 against ML-BRU-SCF-0231 [IN:033144]  */
		
		/*  ML-BRU-SCF-0382 [IN:034809] Fix */
		/*if (parent.frames[0].document.LodgerForm.family_name.value !='')				
		{	 
		
			fields[i] =parent.frames[0].document.LodgerForm.family_name;
			names[i]=parent.frames[0].document.LodgerForm.Family_Name_Prompt.value;
			i++;	
		}*/
		
         /* ML-BRU-SCF-0231 [IN:033144] fix end */
		
		
		if(parent.frames[0].document.LodgerForm.family_name)
		{	
			//if(parent.frames[0].document.LodgerForm.Family_Name_Prompt.value=="")//commented and the following condition included for the incident 35558 on 5-10-2012
			if(parent.frames[0].document.LodgerForm.faid)
			{
			fields[i] =parent.frames[0].document.LodgerForm.family_name;
			names[i]=parent.frames[0].document.LodgerForm.Family_Name_Prompt.value;
			i++;	
		    }
		}
 

      
		if(parent.frames[0].document.LodgerForm.fid)
		{
			fields[i]=parent.frames[0].document.LodgerForm.first_name;
			names[i]=parent.frames[0].document.LodgerForm.First_Name_Prompt.value;
			i++;
		}

		
		if(parent.frames[0].document.LodgerForm.sid)
		{
			fields[i]=parent.frames[0].document.LodgerForm.second_name;
			names[i]=parent.frames[0].document.LodgerForm.Second_Name_Prompt.value;
			i++;
		}
      
		if(parent.frames[0].document.LodgerForm.tid)
		{
			fields[i]=parent.frames[0].document.LodgerForm.third_name;
			names[i]=parent.frames[0].document.LodgerForm.Third_Name_Prompt.value;
			i++;
		}

		fields[i] =parent.frames[0].document.LodgerForm.sex;
		names[i] =getLabel("Common.gender.label","Common");
		i++;	

		fields[i] =parent.frames[0].document.LodgerForm.date_of_birth;
		names[i] =getLabel("Common.birthDate.label","Common");
		i++;

		fields[i] =parent.frames[0].document.LodgerForm.nationality_desc;
		names[i] =getLabel("Common.nationality.label","Common");
		i++;	


		fields[i] =parent.frames[0].document.LodgerForm.reason_for_stay;
		names[i] =getLabel("eIP.ReasonforStay.label","IP");
		i++;
		  
		fields[i] =parent.frames[0].document.LodgerForm.period_from;
		names[i] =getLabel("Common.periodfrom.label","Common");
		i++;

		fields[i] =parent.frames[0].document.LodgerForm.period_to;
		names[i] =getLabel("Common.periodto.label","Common");
		i++;

		fields[i] 
		=parent.frames[0].document.LodgerForm.authorised_by;
		names[i] =getLabel("Common.authorizedby.label","Common");
		i++;

		if(parent.frames[0].document.LodgerForm.race_required_yn.value == 'Y')
		{	
			if(parent.frames[0].document.LodgerForm.race_code !=null &&
			  parent.frames[0].document.LodgerForm.race_code.value =="")
			{
				fields[i]=parent.frames[0].document.LodgerForm.race_code;
				names[i] = getLabel("Common.race.label","Common");
				i++;
			}		
		}
 
		if(parent.frames[0].checkMandatory( fields, names))
		{    
			/* ALL THE DISABLED VALUES ARE ENABLED BEFORE PASSING IT TO SERVLET */
			/* Eval checks whether the values are null or not */		
			if(eval('parent.frames[0].document.LodgerForm.patient_id') != null)
			{
	//			parent.frames[0].document.LodgerForm.patient_name.disabled = false;

				if(eval('parent.frames[0].document.LodgerForm.national_id_no') != null)
				{
					parent.frames[0].document.LodgerForm.national_id_no.disabled = false;
					parent.frames[0].document.LodgerForm.national_id_no.readonly = true;
				}

				parent.frames[0].document.LodgerForm.sex.disabled = false;
				parent.frames[0].document.LodgerForm.Birth_place_code.disabled = false;

				if(parent.frames[0].document.getElementById("citizen_yn")[0] != null)
				{
					parent.frames[0].document.getElementById("citizen_yn")[0].disabled = false;	
					if(parent.frames[0].document.getElementById("citizen_yn")[0].checked==true)
					{
						parent.frames[0].document.getElementById("citizenvalue").value = parent.frames[0].document.getElementById("citizen_yn")[0].value;
					}
				}

				if(parent.frames[0].document.getElementById("citizen_yn")[1] != null)
				{
					parent.frames[0].document.getElementById("citizen_yn")[1].disabled = false;
					if(parent.frames[0].document.getElementById("citizen_yn")[1].checked==true)
					{
						parent.frames[0].document.getElementById("citizenvalue").value = parent.frames[0].document.getElementById("citizen_yn")[1].value
					}
				}

				if(parent.frames[0].document.getElementById("legal_yn")[0] != null)
				{
					parent.frames[0].document.getElementById("legal_yn")[0].disabled = false;
					if(parent.frames[0].document.getElementById("legal_yn")[0].checked==true)
					{
						parent.frames[0].document.getElementById("illegalvalue").value = parent.frames[0].document.getElementById("legal_yn")[0].value
					}
				}

				if(parent.frames[0].document.getElementById("legal_yn")[1] != null)
				{
					parent.frames[0].document.getElementById("legal_yn")[1].disabled = false;
					if(parent.frames[0].document.getElementById("legal_yn")[1].checked==true)
					{
						parent.frames[0].document.getElementById("illegalvalue").value = parent.frames[0].document.getElementById("legal_yn")[1].value
					}
				}

				parent.frames[0].document.LodgerForm.nationality_code1.disabled = false;

				if(eval('parent.frames[0].document.LodgerForm.other_alt_type') != null)
				{
				parent.frames[0].document.LodgerForm.other_alt_type.disabled = false;
				parent.frames[0].document.LodgerForm.other_alt_Id.disabled = false;
				}

				if(parent.frames[0].document.LodgerForm.alt_id1_no)	
				{
					if(eval('parent.frames[0].document.LodgerForm.alt_id1_no') != null)
						parent.frames[0].document.LodgerForm.alt_id1_no.disabled = false;
				}

				if(parent.frames[0].document.LodgerForm.alt_id2_no)					
				{
					if(eval('parent.frames[0].document.LodgerForm.alt_id2_no') != null)
						parent.frames[0].document.LodgerForm.alt_id2_no.disabled = false;
				}

				if(parent.frames[0].document.LodgerForm.alt_id3_no)					
				{
					if(eval('parent.frames[0].document.LodgerForm.alt_id3_no') != null)
						parent.frames[0].document.LodgerForm.alt_id3_no.disabled = false;
				}

				if(parent.frames[0].document.LodgerForm.alt_id4_no)					
				{
					if(eval('parent.frames[0].document.LodgerForm.alt_id4_no') != null)
						parent.frames[0].document.LodgerForm.alt_id4_no.disabled = false;
				}

				if(parent.frames[0].document.LodgerForm.alt_id1_exp_date)					
				{
					if(eval('parent.frames[0].document.LodgerForm.alt_id1_exp_date') != null)
						parent.frames[0].document.LodgerForm.alt_id1_exp_date.disabled = false;
				}
				
				if(parent.frames[0].document.LodgerForm.alt_id2_exp_date)					
				{
					if(eval('parent.frames[0].document.LodgerForm.alt_id2_exp_date') != null)
						parent.frames[0].document.LodgerForm.alt_id2_exp_date.disabled = false;
				}
				
				if(parent.frames[0].document.LodgerForm.alt_id3_exp_date)					
				{	
					if(eval('parent.frames[0].document.LodgerForm.alt_id3_exp_date') != null)
						parent.frames[0].document.LodgerForm.alt_id3_exp_date.disabled = false;
				}
				
				if(parent.frames[0].document.LodgerForm.alt_id4_exp_date)					
				{
					if(eval('parent.frames[0].document.LodgerForm.alt_id4_exp_date') != null)
						parent.frames[0].document.LodgerForm.alt_id4_exp_date.disabled = false;
				}

				if(parent.frames[0].document.LodgerForm.alt_id1_type)						
				{
					if(eval('parent.frames[0].document.LodgerForm.alt_id1_type') != null)
						parent.frames[0].document.LodgerForm.alt_id1_type.disabled = false;
				}
				
				if(parent.frames[0].document.LodgerForm.alt_id2_type)			
				{
					if(eval('parent.frames[0].document.LodgerForm.alt_id2_type') != null)
						parent.frames[0].document.LodgerForm.alt_id2_type.disabled = false;
				}
				
				if(parent.frames[0].document.LodgerForm.alt_id3_type)					
				{
					if(eval('parent.frames[0].document.LodgerForm.alt_id3_type') != null)
						parent.frames[0].document.LodgerForm.alt_id3_type.disabled = false;
				}

				if(parent.frames[0].document.LodgerForm.alt_id4_type)					
				{
					if(eval('parent.frames[0].document.LodgerForm.alt_id4_type') != null)
						parent.frames[0].document.LodgerForm.alt_id4_type.disabled = false;
				}
				
				if(parent.frames[0].document.LodgerForm.name_prefix1)						
				{
					if(eval('parent.frames[0].document.LodgerForm.name_prefix1') != null)
						parent.frames[0].document.LodgerForm.name_prefix1.disabled = false;
				}
				if(parent.frames[0].document.LodgerForm.name_prefix)						
				{
					if(eval('parent.frames[0].document.LodgerForm.name_prefix') != null)
						parent.frames[0].document.LodgerForm.name_prefix.disabled = false;
				}

				if(parent.frames[0].document.LodgerForm.first_name)						
				{
					if(eval('parent.frames[0].document.LodgerForm.first_name') != null)
						parent.frames[0].document.LodgerForm.first_name.disabled = false;
				}

				if(parent.frames[0].document.LodgerForm.second_name)						
				{
					if(eval('parent.frames[0].document.LodgerForm.second_name') != null)
						parent.frames[0].document.LodgerForm.second_name.disabled = false;
				}
				if(parent.frames[0].document.LodgerForm.third_name)						
				{
					if(eval('parent.frames[0].document.LodgerForm.third_name') != null)
						parent.frames[0].document.LodgerForm.third_name.disabled = false;
				}
				
				if(parent.frames[0].document.LodgerForm.family_name)						if(eval('parent.frames[0].document.LodgerForm.family_name') != null)
						parent.frames[0].document.LodgerForm.family_name.disabled = false;

				if(parent.frames[0].document.LodgerForm.name_suffix1)						if(eval('parent.frames[0].document.LodgerForm.name_suffix1') != null)
						parent.frames[0].document.LodgerForm.name_suffix1.disabled = false;

				if(parent.frames[0].document.LodgerForm.name_suffix)						if(eval('parent.frames[0].document.LodgerForm.name_suffix') != null)
						parent.frames[0].document.LodgerForm.name_suffix.disabled = false;

				parent.frames[0].document.LodgerForm.date_of_birth.disabled = false;
				parent.frames[0].document.LodgerForm.ethnic_group.disabled = false;
				//parent.frames[0].document.LodgerForm.race_code.disabled = false;
				//if(parent.frames[0].document.LodgerForm.race_desc) {
			      parent.frames[0].document.LodgerForm.race_desc.disabled = false;
					parent.frames[0].document.LodgerForm.race_desc_id.disabled = false;
				//}

				/*Friday, January 14, 2011, IN025859*/
				if(parent.frames[0].document.LodgerForm.name_prefix_oth_lang)						if(eval('parent.frames[0].document.LodgerForm.name_prefix_oth_lang') != null)
						parent.frames[0].document.LodgerForm.name_prefix_oth_lang.disabled = false;

				if(parent.frames[0].document.LodgerForm.first_name_oth_lang)						if(eval('parent.frames[0].document.LodgerForm.first_name_oth_lang') != null)
						parent.frames[0].document.LodgerForm.first_name_oth_lang.disabled = false;

				if(parent.frames[0].document.LodgerForm.second_name_oth_lang)						if(eval('parent.frames[0].document.LodgerForm.second_name_oth_lang') != null)
						parent.frames[0].document.LodgerForm.second_name_oth_lang.disabled = false;

				if(parent.frames[0].document.LodgerForm.third_name_oth_lang)						if(eval('parent.frames[0].document.LodgerForm.third_name_oth_lang') != null)
						parent.frames[0].document.LodgerForm.third_name_oth_lang.disabled = false;

				if(parent.frames[0].document.LodgerForm.family_name_oth_lang)						if(eval('parent.frames[0].document.LodgerForm.family_name_oth_lang') != null)
						parent.frames[0].document.LodgerForm.family_name_oth_lang.disabled = false;

				if(parent.frames[0].document.LodgerForm.name_suffix_oth_lang)						if(eval('parent.frames[0].document.LodgerForm.name_suffix_oth_lang') != null)
						parent.frames[0].document.LodgerForm.name_suffix_oth_lang.disabled = false;
				/**/

			}				
			parent.frames[0].document.LodgerForm.action = '../../servlet/eIP.BookLodgerServlet' ;
			parent.frames[0].document.LodgerForm.submit();			
		}
	}
}



/// This Function is used for checking the DATE Format...
/// It will throw an alert if the date is not in Proper format...
function dateVal( obj )
{
	if(obj.value !="")
		validDateObj(obj,"DMYHM",localeName)	
}


// Added by Sridhar R on 6 JULY 2004
// function chkRefNo will chk the MAx Reference No from IP_PARAM with the current ref no.. 
// If the current no exceeds the max ref no value it will not Enter the details...
function chkRefNo()
{
	var Max_ref_no = parent.frames[0].document.LodgerForm.Lodger_Max_RefNo.value;
	var next_Ref_no = parent.frames[0].document.LodgerForm.Lodger_Next_RefNo.value;

	if(eval(next_Ref_no)  > eval(Max_ref_no) )
	{
		var msg=	getMessage("REF_NUM_EXCEEDED","IP")
		parent.frames[1].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
	}
	else
		return true
}





function checkMandatory( fields, names)
{ 
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) { 
		if(CheckVal(fields[i].value)) {}
		else{
			errors = errors + getMessage("CAN_NOT_BE_BLANK","Common");
            errors = errors.replace('$',names[i]);
            errors = errors + "\n" ;
		}	
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}




function CheckVal(inString)
{
	var startPos;
	var ch;
	startPos = 0;
	strlength = inString.length;

	for(var i=0;i<=strlength;i++) {
		ch = inString.charAt(startPos);
		if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
			startPos++;
		}
	}
	if(startPos == inString.length) return false;
	else return true;
}


// This fucntion is used for validating the number input
function ChkNumberIP(fld, e, deci)
{
	if (	parseInt(deci)>0)
	   var strCheck = '.0123456789 /:';
	else
	   var strCheck = '0123456789 /:';
		
    var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function SubmitPage() 
{
	var chk_out_dt_time =document.forms[0].chk_out_dt_time.value;

	if (parseInt(chk_out_dt_time.length) <= 0 )
	{
		var error = getMessage('CAN_NOT_BE_BLANK',"Common");
		error = error.replace('$',getLabel("eIP.checkoutdatetime.label","IP"));
		alert(error);						
		document.forms[0].chk_out_dt_time.focus();
	}
	else
	{
		document.forms[0].action='../../servlet/eIP.BookLodgerServlet'
		document.forms[0].submit();
	}
}


// Function will check for empty values before calling up the General Nursing Unit func..
function beforeGetNursingUnit(nursingUnit, facility_id, loginUser, operstn)
{
	if(document.forms[0].nursing_unit_desc.value != "")
		getNursingUnitValue(nursingUnit, facility_id, loginUser, operstn)
}

// modified to General IP search on 12 OCT 2004 by Sridhar R
function getNursingUnitValue(nursingUnit, facility_id, loginUser, operstn)
{
	var nursingUnitCode	= nursingUnit.value;
	var locale = document.forms[0].locale.value;
	var retVal			= new String();
	var tit				= getLabel("Common.nursingUnit.label","Common");
	var dialogHeight	= "28" ;
	var dialogWidth		= "43" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments		= "" ;

	var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&locale="+locale+"&login_user="+loginUser+"&oper_id="+operstn+"&title="+encodeURIComponent(tit)+"&facility_id="+facility_id;
	var retVal =  window.showModalDialog(jsp_name,arguments,features);

	var arr=new Array();

	if(retVal != null && retVal != "" )
	{
		arr=retVal.split("~");
		document.forms[0].lodger_nursing_unit.value	= arr[0];
		document.forms[0].nursing_unit_desc.value	= arr[1];
	}
	else
	{
		document.forms[0].lodger_nursing_unit.value	= "";
		document.forms[0].nursing_unit_desc.value	= "";
	}
}


// CODED ON 21 FEB 2004 BY SRIDHAR 
// FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] 
// Func will return an alert message if TO DATE is Less than FROM DATE
function ComparePeriodTime(from,to)
{	
	if(to.value != '' )
	{
		if(validDateObj(to,"DMYHM",localeName))
		{
			if(from.value != '' && to.value != '')
			{								
				if(!isAfter(to.value,from.value,"DMYHM",localeName))
				{
					alert(getMessage("TO_DT_GR_EQ_FM_DT","SM") );
					document.forms[0].period_to.focus();
					document.forms[0].period_to.select();
					return false;
				}
				else
				{
					var Category = document.forms[0].Category.value;
					if(Category == 'A')
					{
						var discharge_period = document.forms[0].Acc_Disc_Period;
						var discharge_period_unit = document.forms[0].Acc_Disc_Period_unit;
					}
					else if(Category == 'L')
					{
						var discharge_period = document.forms[0].Lodger_Disc_Period;
						var discharge_period_unit = document.forms[0].Lodger_Disc_Period_unit;
					}
					ValidateDischargeDateTime(from.value,to.value,discharge_period,discharge_period_unit )
				}
			}
		}
		else
		{
			to.value='';
			return false;
		}
	}
}

// CODED ON 17 MAY 2004 BY SRIDHAR 
// Func will test the Period To value with Maximum Period of Stay after Discharge from IP param & return an alert message if TO DATE is greated than Discharge Time..
function ValidateDischargeDateTime(from, to, discharge_period, unit)
{	
	if(discharge_period.value != "")
	{
		if(unit.value == 'D')
			exp_date = plusDate(from,"DMYHM",localeName,discharge_period.value,'d');
		else if(unit.value == 'H')
			exp_date = plusDate(from,"DMYHM",localeName,discharge_period.value,'h');
		
		if((!isBefore(from,to,"DMYHM",localeName)) || (!isBefore(to,exp_date,"DMYHM",localeName)))
		{
			var Category = document.forms[0].Category.value;
			if(Category == 'A')
			{
				var error	= getMessage("LODGER_PERIOD_CHECK","IP") ;
				error		= error.replace(getLabel("Common.Lodger.label","Common"), getLabel("eIP.AccompanyingPerson.label","IP"));
				alert(error);
			}
			else if(Category == 'L')
			{
				alert(getMessage("LODGER_PERIOD_CHECK","IP"));
			}
			document.forms[0].period_to.focus();
			document.forms[0].period_to.select();
		}

	}
}

// CODED ON 23 FEB 2004 BY SRIDHAR 
// FUNC USED TO COMPARE [PERIOD FROM DATE TIME] WITH [CHECK IN DATE TIME] 
// Func will return an alert message if FROM DATE is Less than CHDCKIN DATE
function CompareCheckInTime(from,to)
{
	var str = new Object(from.value);
	if(from.value != '' && to.value != '')
	{
		//if(!doDateTimeChk(from))
		if(!validDate(from.value,"DMYHM",localeName))
		{
			from.focus();
			from.select();
			alert( getMessage("INVALID_DATE_TIME","SM") );			
			return;
		}
		//else if(!doDateTimeChk(to))
		else if(!validDate(to.value,"DMYHM",localeName))
		{
			to.focus();
			to.select();
			alert( getMessage("INVALID_DATE_TIME","SM") );			
			return;
		}

	CheckInDateTime(from.value,to.value);
	}
	else return;
}

function CheckInDateTime(obj1,obj2)
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
		alert(getMessage("PR_GT_CHK_DT",'IP'));
		document.forms[0].period_from.focus();
		document.forms[0].period_from.select();
		return false;
	}
	else
	{
		return true;
	}	
}	

function localValidations(obj)
{}


function CompareCheckTime(Obj)
{
	var dateTo=Obj;
	var dateFrom=document.forms[0].period_from;
	if(!doDateCheckAlert(dateTo,dateFrom))
	{
		alert(getMessage("PR_GT_CHK_DT","IP"));
		document.forms[0].period_from.focus();
		document.forms[0].period_from.select();
	}
}	

// FUNC USED TO COMPARE [PERIOD FROM DATE TIME] WITH [SYSTEM DATE]
// Func will return an alert message if CheckinTime is Less than System date
function ValCheckinTime(obj,sysdateTime)
{
	var str = new Object(obj.value);
	if(obj.value !=	'' )
	{
		if(validDateObj(obj,"DMYHM",localeName))
		{
			greg_date = convertDate(obj.value,"DMYHM",localeName,"en");		
			if(!isAfter(greg_date,sysdateTime,"DMYHM",localeName))
			{
				alert(getMessage("FRM_DT_GREATER_CURRENT_DT","IP"));
				document.forms[0].period_from.focus();
				document.forms[0].period_from.select();
				return false
			}
		}
		else
		{
			document.forms[0].period_from.value='';
			return false;
		}
	}
}

function compareDate(obj,checkinTimeObj,sysdateTime)
{
	var str = new Object(obj.value);
	if(obj != null && checkinTimeObj != null)
	{
		if(obj.value !=	'' )
		{
			if(validDateObj(obj,"DMYHM",localeName))
			{
				var greg_date = convertDate(obj.value,"DMYHM",localeName,"en");
				//if(isAfter(checkinTimeObj.value,greg_date,"DMYHM",localeName)){ //Modified By Dharma on 30th Sep 2015 against Leap Year Issue
				if(isAfter(checkinTimeObj.value,greg_date,"DMYHM","en")){
					
					alert(getMessage("CHKOUT_TIME_GT_CHKIN_TIME","IP"));
					obj.value = "";
					obj.focus();
					obj.select();
				}
				else
				{					
					//if(!isBefore(greg_date,sysdateTime,"DMYHM",localeName)){ //Modified By Dharma on 30th Sep 2015 against Leap Year Issue
					if(!isBefore(greg_date,sysdateTime,"DMYHM","en")){
					
						alert(getMessage("CHKOUT_TIME_SH_LESS_SYSTIME","IP"));
						document.forms[0].chk_out_dt_time.value = "";
						document.forms[0].chk_out_dt_time.focus();
						document.forms[0].chk_out_dt_time.select();
						return false ; 
					}
				}
			}
		}
	}
}

function checkMax(obj)
{
	if(obj.value.length > 200)
	{
		alert(getMessage('REMARKS_NOT_EXCEED_200_CH','SM'));
		obj.focus();
		obj.select();
	}
	else 
	makeValidString(obj);
}


function CheckMaxLength(obj,max) 
{
	if(obj.value.length >= max) 
		return false;
	else 
		return true;
}

/*
function disman()
	{
		if(document.LodgerForm.race_required_yn.value == 'Y')
	    {
		// document.getElementById("eth_gif").style.visibility='visible';
		}
		else
		{
		 // document.getElementById("eth_gif").style.visibility='hidden';
		}
}
*/
