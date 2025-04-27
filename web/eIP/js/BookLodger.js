/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	Lodger -> CheckInLodger 
/// Funtion			:	This File is called on the click of Any button on the Toolbar of 						ChkInLodger...


/// This Function is called on click of the CREATE button on the tool bar...
/// It will Redirect to the BookLodgerFrames.jsp.. where the frames are defined...
function create() 
{
	f_query_add_mod.location.href = "../../eIP/jsp/BookLodgerFrames.jsp" ; 
} 

/// ADDED BY SRIDHAR R on 17 MAY 2004 
/// This Function is called on click of the APPLY button on the tool bar...
/// It will Submit the form and Pass the values to Servlet...
function apply()
{
	// The if loop will check the value of the Patient ID entered by the user with pline [HEADER] Patient ID & allows to enter only if they are not same..
	if(f_query_add_mod.frames[2].document.BlockLodgerForm.Category.value == 'A')
	{
		var FormPatID=f_query_add_mod.frames[2].document.BlockLodgerForm.patient_id.value
		var PlinePatID =f_query_add_mod.frames[2].document.forms[0].pLine_Pat_id.value

		if(FormPatID == PlinePatID)
		{
            var msg= getMessage("ATTEND_PAT_ID_SAME","IP") ; 
            parent.frames[1].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
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
	/*---- ALL THE DISABLED VALUES ARE ENABLED BEFORE PASSING IT TO SERVLET ----*/
	/* Eval checks whether the values are null or not */		

	if(eval('f_query_add_mod.frames[2].document.forms[0].patient_id') != null)
	{
		f_query_add_mod.frames[2].document.forms[0].patient_name.disabled = false;

		if(eval('f_query_add_mod.frames[2].document.forms[0].national_id_no') != null)
		{
			f_query_add_mod.frames[2].document.forms[0].national_id_no.disabled = false;
			f_query_add_mod.frames[2].document.forms[0].national_id_no.readonly = true;
		}

		f_query_add_mod.frames[2].document.forms[0].sex.disabled = false;
		f_query_add_mod.frames[2].document.forms[0].Birth_place_code.disabled = false;
		f_query_add_mod.frames[2].document.forms[0].citizen_yn.disabled = false;
		f_query_add_mod.frames[2].document.forms[0].legal_yn.disabled = false;
		f_query_add_mod.frames[2].document.forms[0].nationality_code1.disabled = false;

		if(eval('f_query_add_mod.frames[2].document.forms[0].other_alt_type') != null)
		{
		f_query_add_mod.frames[2].document.forms[0].other_alt_type.disabled = false;
		f_query_add_mod.frames[2].document.forms[0].other_alt_Id.disabled = false;
		}

		if(f_query_add_mod.frames[2].document.forms[0].alt_id1_no)					
			if(eval('f_query_add_mod.frames[2].document.forms[0].alt_id1_no') != null)
				f_query_add_mod.frames[2].document.forms[0].alt_id1_no.disabled = false;

		if(f_query_add_mod.frames[2].document.forms[0].alt_id2_no)					
			if(eval('f_query_add_mod.frames[2].document.forms[0].alt_id2_no') != null)
				f_query_add_mod.frames[2].document.forms[0].alt_id2_no.disabled = false;

		if(f_query_add_mod.frames[2].document.forms[0].alt_id3_no)					
			if(eval('f_query_add_mod.frames[2].document.forms[0].alt_id3_no') != null)
				f_query_add_mod.frames[2].document.forms[0].alt_id3_no.disabled = false;

		if(f_query_add_mod.frames[2].document.forms[0].alt_id4_no)					
			if(eval('f_query_add_mod.frames[2].document.forms[0].alt_id4_no') != null)
				f_query_add_mod.frames[2].document.forms[0].alt_id4_no.disabled = false;

		if(f_query_add_mod.frames[2].document.forms[0].alt_id1_exp_date)					
			if(eval('f_query_add_mod.frames[2].document.forms[0].alt_id1_exp_date') != null)
				f_query_add_mod.frames[2].document.forms[0].alt_id1_exp_date.disabled = false;
		
		if(f_query_add_mod.frames[2].document.forms[0].alt_id2_exp_date)					
			if(eval('f_query_add_mod.frames[2].document.forms[0].alt_id2_exp_date') != null)
				f_query_add_mod.frames[2].document.forms[0].alt_id2_exp_date.disabled = false;
		
		if(f_query_add_mod.frames[2].document.forms[0].alt_id3_exp_date)					
			if(eval('f_query_add_mod.frames[2].document.forms[0].alt_id3_exp_date') != null)
				f_query_add_mod.frames[2].document.forms[0].alt_id3_exp_date.disabled = false;
		
		if(f_query_add_mod.frames[2].document.forms[0].alt_id4_exp_date)					
			if(eval('f_query_add_mod.frames[2].document.forms[0].alt_id4_exp_date') != null)
				f_query_add_mod.frames[2].document.forms[0].alt_id4_exp_date.disabled = false;


		if(f_query_add_mod.frames[2].document.forms[0].alt_id1_type)						if(eval('f_query_add_mod.frames[2].document.forms[0].alt_id1_type') != null)
				f_query_add_mod.frames[2].document.forms[0].alt_id1_type.disabled = false;
		
		if(f_query_add_mod.frames[2].document.forms[0].alt_id2_type)			
			if(eval('f_query_add_mod.frames[2].document.forms[0].alt_id2_type') != null)
				f_query_add_mod.frames[2].document.forms[0].alt_id2_type.disabled = false;
		
		if(f_query_add_mod.frames[2].document.forms[0].alt_id3_type)					
			if(eval('f_query_add_mod.frames[2].document.forms[0].alt_id3_type') != null)
				f_query_add_mod.frames[2].document.forms[0].alt_id3_type.disabled = false;

		if(f_query_add_mod.frames[2].document.forms[0].alt_id4_type)					
			if(eval('f_query_add_mod.frames[2].document.forms[0].alt_id4_type') != null)
				f_query_add_mod.frames[2].document.forms[0].alt_id4_type.disabled = false;
		

		if(f_query_add_mod.frames[2].document.forms[0].name_prefix1)						if(eval('f_query_add_mod.frames[2].document.forms[0].name_prefix1') != null)
				f_query_add_mod.frames[2].document.forms[0].name_prefix1.disabled = false;


		if(f_query_add_mod.frames[2].document.forms[0].first_name)							if(eval('f_query_add_mod.frames[2].document.forms[0].first_name') != null)
				f_query_add_mod.frames[2].document.forms[0].first_name.disabled = false;
		
		if(f_query_add_mod.frames[2].document.forms[0].family_name)							if(eval('f_query_add_mod.frames[2].document.forms[0].family_name') != null)
				f_query_add_mod.frames[2].document.forms[0].family_name.disabled = false;

		if(f_query_add_mod.frames[2].document.forms[0].name_suffix1)						if(eval('f_query_add_mod.frames[2].document.forms[0].name_suffix1') != null)
				f_query_add_mod.frames[2].document.forms[0].name_suffix1.disabled = false;

		f_query_add_mod.frames[2].document.forms[0].date_of_birth.disabled = false;
		f_query_add_mod.frames[2].document.forms[0].ethnic_group.disabled = false;
		//f_query_add_mod.frames[2].document.forms[0].race_code.disabled = false;

		if(f_query_add_mod.frames[2].document.forms[0].race_desc) {
			f_query_add_mod.frames[2].document.forms[0].race_desc.disabled = false;
			f_query_add_mod.frames[2].document.forms[0].race_desc_id.disabled = false;
		}

	}	//-----------E O PATEIENT ID != null --------------

			var fields = new Array();
			var names = new Array ()			
			var p_label = f_query_add_mod.frames[2].document.forms[0].label.value;

			var i=0;		
			
			/* START OF ADDITION FOR MANDATORY FIELDS */
		if (f_query_add_mod.frames[2].document.BlockLodgerForm.reason_for_stay)
		{
			fields[i] =f_query_add_mod.frames[2].document.BlockLodgerForm.patient_id;
			names[i] =p_label+getLabel("Common.patientId.label","Common");
			i++;
		}

	/******************** TO BE CHANGED TO PROMPTS **********************/
			
		if(f_query_add_mod.frames[2].document.BlockLodgerForm.family_name)
		{	
			fields[i] =f_query_add_mod.frames[2].document.BlockLodgerForm.family_name;
		names[i]=f_query_add_mod.frames[2].document.BlockLodgerForm.Family_Name_Prompt.value;
			i++;	
		}

		if(f_query_add_mod.frames[2].document.BlockLodgerForm.fid)
		{
			fields[i]=f_query_add_mod.frames[2].document.BlockLodgerForm.first_name;
		names[i]=f_query_add_mod.frames[2].document.BlockLodgerForm.First_Name_Prompt.value;
			i++;
		}

		if(f_query_add_mod.frames[2].document.BlockLodgerForm.sid)
		{
			fields[i]=f_query_add_mod.frames[2].document.BlockLodgerForm.second_name;
		names[i]=f_query_add_mod.frames[2].document.BlockLodgerForm.Second_Name_Prompt.value;
			i++;
		}

		if(f_query_add_mod.frames[2].document.BlockLodgerForm.tid)
		{
			fields[i]=f_query_add_mod.frames[2].document.BlockLodgerForm.third_name;
		names[i]=f_query_add_mod.frames[2].document.BlockLodgerForm.Third_Name_Prompt.value;
			i++;
		}

	//******************* TO BE CHANGED TO PROMPTS *********************
					
		fields[i] =f_query_add_mod.frames[2].document.BlockLodgerForm.sex;
		names[i] =getLabel("Common.gender.label","Common");
		i++;	

		fields[i] =f_query_add_mod.frames[2].document.BlockLodgerForm.date_of_birth;
		names[i] =getLabel("Common.birthDate.label","Common");
		i++;

		fields[i] =f_query_add_mod.frames[2].document.BlockLodgerForm.nationality_desc;
		names[i] =getLabel("Common.nationality.label","Common");
		i++;	

		if(f_query_add_mod.frames[2].document.race_required_yn!=null)
		{		
			if(f_query_add_mod.frames[2].document.race_required_yn.value == 'Y')
			{
				fields[i] =f_query_add_mod.frames[2].document.BlockLodgerForm.ethnic_group;
				names[i] =getLabel("Common.race.label","Common");
				i++;
			}
		}
		else
		{
				fields[i] =f_query_add_mod.frames[2].document.BlockLodgerForm.ethnic_group;
				names[i] =getLabel("Common.race.label","Common");
				i++;
		}

		if (f_query_add_mod.frames[2].document.BlockLodgerForm.reason_for_stay)
		{
			fields[i] =f_query_add_mod.frames[2].document.BlockLodgerForm.reason_for_stay;
			names[i] =getLabel("eIP.ReasonforStay.label","IP")
			i++;
		}
		
		fields[i] =f_query_add_mod.frames[2].document.BlockLodgerForm.period_from;
		names[i] =getLabel("Common.periodfrom.label","Common");
		i++;

		fields[i] =f_query_add_mod.frames[2].document.BlockLodgerForm.period_to;
		names[i] =getLabel("Common.periodto.label","Common");
		i++;

		fields[i] 
		=f_query_add_mod.frames[2].document.BlockLodgerForm.authorised_by;
		names[i] =getLabel("Common.authorizedby.label","Common");
		i++;

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{    
		if(!ValidateDateTime(f_query_add_mod.frames[2].document.BlockLodgerForm.to_chk_in_dt_time,f_query_add_mod.frames[2].document.BlockLodgerForm.chk_in_dt_time,messageFrame)) 
			{
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+parent.parent.frames[0].getMessage('CHKIN_TIME_GR_SYSDATE','IP')
			}
			else
			{
				f_query_add_mod.frames[2].document.BlockLodgerForm.submit();			
			}
		}
	}
}


/// This Function is called on click of the RESET button on the tool bar...
/// It will reset all the variables in the page & reload the page...
function reset() 
{
	var p_label = parent.parent.frames[1].frames[1].frames[2].document.forms[0].label.value;

	parent.parent.frames[1].frames[1].frames[2].document.forms[0].reset();

	parent.parent.frames[1].frames[1].frames[2].document.location.href='../../eCommon/html/blank.html';
	parent.parent.frames[1].frames[1].frames[1].document.location.href='../../eCommon/html/blank.html';
}


function onSuccess() { }

function popDynamicValues(){ }


/// This Function is used for checking the DATE Format...
/// It will throw an alert if the date is not in Proper format...
function dateVal( obj )
{
	if(obj.value !="")
	{
		if(!doDateTimeChk(obj))
		{
			obj.focus()
			alert( parent.parent.parent.frames[0].getMessage("INVALID_DATE_TIME","SM") )
		}
	}
}


async function fetchVal(val,obj,mode)
{
	if(val == 'P')
	{
		var patientid=PatientSearch();
		document.BlockLodgerForm.lodger_patient_id.value = patientid;
		if( document.BlockLodgerForm.lodger_patient_id.value == 'undefined')
			document.BlockLodgerForm.lodger_patient_id.value = '';
		 document.BlockLodgerForm.lodger_patient_id.focus();

	}
	else if(val == 'B')
	{
		var retVal = 	new String();
		var dialogHeight= "75vh" ;
		var dialogWidth	= "65vw" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp",arguments,features);
		var arr = retVal.split("^");
		
		document.BlockLodgerForm.lodger_bed_no.value = arr[1];
	}
	else if( val=='E' )
	{
		var retVal = 	new String();
		var dialogHeight= "50vh" ;
		var dialogWidth	= "50vw" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

		retVal = await window.showModalDialog("../../eIP/jsp/InpatientLookupCall.jsp?modal=yes",arguments,features);
		if(retVal!=null)
		{
			document.forms[0].encounter_id.value = retVal;
			document.forms[0].encounter_id.focus();
			document.forms[0].encounter_id.select();
		}
	}
	else 
	{
		if(val == "En")
		{
		}
		else
		{
			if(val == "Bed")	
			{
				if(document.forms[0].lodger_bed_no.value !="")
				{
					var xmlStr ="<root><SEARCH nursing_unit='"+document.forms[0].lodger_nursing_unit.value+"' bed_no="+document.forms[0].lodger_bed_no.value+" value='Bed' /></root>";
	
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

					xmlHttp.open("POST","../../eIP/jsp/fetchValsForBookLodger.jsp",false);
					xmlHttp.send(xmlDoc);
	
					eval(xmlHttp.responseText );
				}						
			}
		}
	}
}



function validatePatient()
{
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	Category = parent.frames[2].document.forms[0].Category.value;
	var result  = true;
	if(Category=='A')
	{
		patient_id = parent.frames[2].document.forms[0].patient_id.value;
		lodger_patient_id = parent.frames[2].document.forms[0].lodger_patient_id.value;
		if(patient_id==lodger_patient_id)
		{
             result = false;
		}
	}
	
		
if(result)
{
	if(parent.frames[2].document.forms[0].lodger_patient_id.value !="")
	{
		
		var xmlStr ="<root><SEARCH patient_id='"+document.forms[0].lodger_patient_id.value+"' value='Patient' /></root>";
		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		xmlHttp.open("POST","../../eIP/jsp/fetchValsForBookLodger.jsp",false);
		xmlHttp.send(xmlDoc);
		
		eval(xmlHttp.responseText );
	}
	else
	{
	  if(Category=='A')
	  {
		parent.frames[2].document.BlockLodgerForm.reset();
		if (parent.frames[2].document.BlockLodgerForm.label.value==getLabel("Common.Lodger.label","Common"))
		{
			parent.frames[2].document.BlockLodgerForm.reason_for_stay.focus();
		}
		else
		{
		}
	  }
	}
  }
  else
	{
	  alert(getMessage('ATTEND_PAT_ID_SAME','IP'));
	  document.forms[0].lodger_patient_id.value = '';
	  document.forms[0].lodger_patient_id.focus();
	  document.forms[0].lodger_patient_id.select();
	}
}


function onSuccess()
{
	f_query_add_mod.location.href = "../../eIP/jsp/BookLodgerFrames.jsp" ; 
}



// By Annadurai 2/10/2004 starts., to use Common Lookups.,
// To get the Available Nursing Unit.
async function getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)
{
	var nursingUnit = aNursingUnit.value;
	var facilityId	= aFacilityId;
	var loginUserId	= aLoginUser;
	var	operStnID	= pOperStnID;
	var locale      = document.forms[0].locale.value;

	var retVal =    new String();

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 

	sql=" select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit_lang_vw a, am_os_user_locn_access_vw b where a.language_id='"+locale+"' and a.facility_id  like ? and a.facility_id=b.facility_id and a.EFF_STATUS = 'E' and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N' and b.oper_stn_id  like ? and b.appl_user_id  like ? and check_lodger_yn ='Y' and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?)";
	
	dataNameArray[0]	= "a.facility_id" ;
	dataValueArray[0]	= facilityId;
	dataTypeArray[0]	= STRING ;
	
	dataNameArray[1]	= "b.oper_stn_id" ;
	dataValueArray[1]	= operStnID; 
	dataTypeArray[1]	= STRING ;
	
	dataNameArray[2]	= "b.appl_user_id" ;
	dataValueArray[2]	= loginUserId;
	dataTypeArray[2]	= STRING ;

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4, 5";
	argumentArray[5] = nursingUnit;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	var tit=getLabel("Common.nursingUnit.label","Common");

	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].lodger_nursing_unit.value	=	arr[0];		document.forms[0].nursing_unit_desc.value	=	arr[1];
	}
	else
	{
		document.forms[0].lodger_nursing_unit.value	=	"";		document.forms[0].nursing_unit_desc.value	=	"";
	}
} 
// By Annadurai 2/10/2004 ends.



/// Added by Sridhar R on 6 JULY 2004
/// function chkRefNo will chk the MAx Reference No from IP_PARAM with the current ref no.. 
/// If the current no exceeds the max ref no value it will not Enter the details...
function chkRefNo() 
{
	var Max_ref_no = f_query_add_mod.frames[2].document.BlockLodgerForm.Lodger_Max_RefNo.value;
	var next_Ref_no = f_query_add_mod.frames[2].document.BlockLodgerForm.Lodger_Next_RefNo.value;

	if(eval(next_Ref_no)  > eval(Max_ref_no) )
	{
		var msg=	getMessage("REF_NUM_EXCEEDED","IP");
        parent.frames[1].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
	}
	else
		return true
}
