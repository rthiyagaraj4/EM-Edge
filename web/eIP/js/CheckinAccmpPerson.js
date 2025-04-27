/// MODULE			:	InPatient Management..(IP)
/// Developer		:	SRIDHAR R
/// Created on		:	31 JULY 2004
/// Function Name	:	Lodger -> CheckIn Accompanying Person 


/// ADDED BY SRIDHAR R on 17 MAY 2004 
/// This Function is called on click of the APPLY button on the tool bar...
/// It will Submit the form and Pass the values to Servlet...
var LocalErrors = "";
async function apply()
{
	// The if loop will check the value of the Patient ID entered by the user with pline [HEADER] Patient ID & allows to enter only if they are not same..
	if(parent.AccPersonFrame.document.AccPersonForm.Category.value == 'A')
	{
		var FormPatID=parent.AccPersonFrame.document.AccPersonForm.patient_id.value
		var PlinePatID =parent.AccPersonFrame.document.forms[0].pLine_Pat_id.value

		if(FormPatID == PlinePatID)
		{
            var msg= getMessage("ATTEND_PAT_ID_SAME","IP") ; 
			alert(msg);
		}
		else
		{
			await chkBeforeApply(); 
		}
	}
	else
	{
		await chkBeforeApply();
	}
}

/// ADDED BY SRIDHAR ON 20 FEB 2004 
/// This function will Check for Validations in the form before submit...
async function chkBeforeApply()
{
	var blur = false;
	var chkval = await chkRefNo();
	if(chkval)
	{
		var fields = new Array();
		var names = new Array()			
		var p_label = parent.AccPersonFrame.document.forms[0].label.value;
		var i=0;		
		
		/* START OF ADDITION FOR MANDATORY FIELDS */
		if (parent.AccPersonFrame.document.AccPersonForm.reason_for_stay)
		{
			fields[i] =parent.AccPersonFrame.document.AccPersonForm.patient_id;
			names[i] =p_label+getLabel("Common.patientId.label","Common");
			i++;
		}

		if(parent.AccPersonFrame.document.AccPersonForm.family_name_reqd_yn !=null && parent.AccPersonFrame.document.AccPersonForm.family_name_reqd_yn.value =='Y' )
		{		
			if(parent.AccPersonFrame.document.AccPersonForm.family_name.value == "")
				parent.AccPersonFrame.document.AccPersonForm.family_name.value = parent.AccPersonFrame.document.AccPersonForm.dflt_patient_name.value;

			blur = true;

			/*	fields[i] =parent.AccPersonFrame.document.AccPersonForm.family_name;
			names[i]=parent.AccPersonFrame.document.AccPersonForm.Family_Name_Prompt.value;
			i++;	*/
		}

		if(parent.AccPersonFrame.document.AccPersonForm.first_name_reqd_yn !=null && parent.AccPersonFrame.document.AccPersonForm.first_name_reqd_yn.value =='Y' )
		{
			if(parent.AccPersonFrame.document.AccPersonForm.first_name.value == "")
				parent.AccPersonFrame.document.AccPersonForm.first_name.value = parent.AccPersonFrame.document.AccPersonForm.dflt_patient_name.value;

			blur = true;

			/*	fields[i]=parent.AccPersonFrame.document.AccPersonForm.first_name;
			names[i]=parent.AccPersonFrame.document.AccPersonForm.First_Name_Prompt.value;
			i++; */
		}

		if(parent.AccPersonFrame.document.AccPersonForm.second_name_reqd_yn !=null && parent.AccPersonFrame.document.AccPersonForm.second_name_reqd_yn.value =='Y' )
		{
			if(parent.AccPersonFrame.document.AccPersonForm.second_name.value == "")
				parent.AccPersonFrame.document.AccPersonForm.second_name.value = parent.AccPersonFrame.document.AccPersonForm.dflt_patient_name.value;

			blur = true;

			/*	fields[i]=parent.AccPersonFrame.document.AccPersonForm.second_name;
			names[i]=parent.AccPersonFrame.document.AccPersonForm.Second_Name_Prompt.value;
			i++;*/
		}

		if(parent.AccPersonFrame.document.AccPersonForm.third_name_reqd_yn !=null && parent.AccPersonFrame.document.AccPersonForm.third_name_reqd_yn.value =='Y' )
		{
			if(parent.AccPersonFrame.document.AccPersonForm.third_name.value == "")
				parent.AccPersonFrame.document.AccPersonForm.third_name.value = parent.AccPersonFrame.document.AccPersonForm.dflt_patient_name.value;

			blur = true;

			/*	fields[i]=parent.AccPersonFrame.document.AccPersonForm.third_name;
			names[i]=parent.AccPersonFrame.document.AccPersonForm.Third_Name_Prompt.value;
			i++; */
		}

		/* 
		if(blur == true)
		parent.AccPersonFrame.document.AccPersonForm.first_name.onblur();
		*/
		/*Thursday, October 01, 2009 IN015001*/
		if(blur == true && parent.AccPersonFrame.document.AccPersonForm.first_name_reqd_yn !=null && parent.AccPersonFrame.document.AccPersonForm.first_name_reqd_yn.value =='Y')
		parent.AccPersonFrame.document.AccPersonForm.first_name.onblur();


		if(parent.AccPersonFrame.document.AccPersonForm.name_prefix_oth != null)
		{
			if(parent.AccPersonFrame.document.AccPersonForm.name_prefix_oth.style.visibility == 'visible' )
			{
				if(parent.AccPersonFrame.document.AccPersonForm.name_prefix_oth_lang != null && parent.AccPersonFrame.document.AccPersonForm.name_prefix_oth_lang.disabled ==false)
				{
					fields[i]=parent.AccPersonFrame.document.AccPersonForm.name_prefix_oth_prompt;
					names[i]=parent.AccPersonFrame.document.AccPersonForm.name_prefix_oth_lang.value;
					p++;
				}
			}
		}


		if(parent.AccPersonFrame.document.AccPersonForm.first_oth_name_reqd_yn != null)
		{
		if(parent.AccPersonFrame.document.AccPersonForm.first_oth_name_reqd_yn.style.visibility == 'visible' )
		{
		if(parent.AccPersonFrame.document.AccPersonForm.first_name_oth_lang != null && parent.AccPersonFrame.document.AccPersonForm.first_name_oth_lang.disabled ==false)
		{
		fields[i]=parent.AccPersonFrame.document.AccPersonForm.first_name_oth_prompt;
		names[i]=parent.AccPersonFrame.document.AccPersonForm.first_name_oth_lang.value;
		p++;
		}
		}
		}

		if(parent.AccPersonFrame.document.AccPersonForm.second_oth_name_reqd_yn != null)
		{
		if(parent.AccPersonFrame.document.AccPersonForm.second_oth_name_reqd_yn.style.visibility == 'visible' )
		{
		if(parent.AccPersonFrame.document.AccPersonForm.second_name_oth_lang != null && parent.AccPersonFrame.document.AccPersonForm.second_name_oth_lang.disabled ==false)
		{
		fields[i]=parent.AccPersonFrame.document.AccPersonForm.second_name_oth_prompt;
		names[i]=parent.AccPersonFrame.document.AccPersonForm.second_name_oth_lang.value;
		p++;
		}
		}
		}
		if(parent.AccPersonFrame.document.AccPersonForm.third_oth_name_reqd_yn != null)
		{
		if(parent.AccPersonFrame.document.AccPersonForm.third_oth_name_reqd_yn.style.visibility == 'visible' )
		{
		if(parent.AccPersonFrame.document.AccPersonForm.third_name_oth_lang != null && parent.AccPersonFrame.document.AccPersonForm.third_name_oth_lang.disabled ==false)
		{
		fields[i]=parent.AccPersonFrame.document.AccPersonForm.third_name_oth_prompt;
		names[i]=parent.AccPersonFrame.document.AccPersonForm.third_name_oth_lang.value;
		p++;
		}
		}
		}

		if(parent.AccPersonFrame.document.AccPersonForm.family_oth_name_reqd_yn != null)
		{
		if(parent.AccPersonFrame.document.AccPersonForm.family_oth_name_reqd_yn.style.visibility == 'visible' )
		{
		if(parent.AccPersonFrame.document.AccPersonForm.family_name_oth_lang != null && parent.AccPersonFrame.document.AccPersonForm.family_name_oth_lang.disabled ==false)
		{
		fields[i]=parent.AccPersonFrame.document.AccPersonForm.family_name_oth_prompt;
		names[i]=parent.AccPersonFrame.document.AccPersonForm.family_name_oth_lang.value;
		p++;
		}
		}
		}


		if(parent.AccPersonFrame.document.AccPersonForm.name_suffix_oth != null)
		{
		if(parent.AccPersonFrame.document.AccPersonForm.name_suffix_oth.style.visibility == 'visible' )
		{
		if(parent.AccPersonFrame.document.AccPersonForm.name_suffix_oth_lang != null && parent.AccPersonFrame.document.AccPersonForm.name_suffix_oth_lang.disabled ==false)
		{
		fields[i]=parent.AccPersonFrame.document.AccPersonForm.name_suffix_oth_prompt;
		names[i]=parent.AccPersonFrame.document.AccPersonForm.name_suffix_oth_lang.value;
		p++;
		}
		}
		}

		fields[i] = parent.AccPersonFrame.document.AccPersonForm.sex;
		names[i] =getLabel("Common.gender.label","Common");
		i++;	

		fields[i] = parent.AccPersonFrame.document.AccPersonForm.period_from;
		names[i] =getLabel("Common.periodfrom.label","Common");
		i++;

		fields[i] = parent.AccPersonFrame.document.AccPersonForm.period_to;
		names[i] =getLabel("Common.periodto.label","Common");
		i++;

		if(parent.AccPersonFrame.document.AccPersonForm.Authorised_lookup.readOnly)
		{
			fields[i] = parent.AccPersonFrame.document.AccPersonForm.Authorised_text;
			names[i] =getLabel("Common.authorizedby.label","Common");
			i++;
		}
		else
		{
			fields[i] = parent.AccPersonFrame.document.AccPersonForm.Authorised_lookup;
			names[i] =getLabel("Common.authorizedby.label","Common");
			i++;
		}

		// this code is written for validating patient prefix and suffix with the gender.
			var pat_prefix=true;
			var pat_suffix=true;
			LocalErrors = "";
		
			if (parent.AccPersonFrame.document.AccPersonForm.name_prefix != null && parent.AccPersonFrame.document.AccPersonForm.name_prefix.value.length != 0 && parent.AccPersonFrame.document.AccPersonForm.sex.value != '') 
			{
				pat_prefix=checkPatSex1();
				
			}

			if (parent.AccPersonFrame.document.AccPersonForm.name_suffix != null && parent.AccPersonFrame.document.AccPersonForm.name_suffix.value.length != 0 && parent.AccPersonFrame.document.AccPersonForm.sex.value != '') 
			{
				pat_suffix=checkPatSuffixSex1();				
			}
			
				
			if(pat_prefix==false || pat_suffix ==false)
			{
				alert(LocalErrors) ;
				return false;
			}
			/*Monday, June 28, 2010, added to check maximum age for accompanying person*/
			var maxAge = true
			if((parent.AccPersonFrame.document.AccPersonForm.b_age !=null && parent.AccPersonFrame.document.AccPersonForm.b_age.value !="")||(parent.AccPersonFrame.document.AccPersonForm.b_months !=null && parent.AccPersonFrame.document.AccPersonForm.b_months.value !="")||(parent.AccPersonFrame.document.AccPersonForm.b_days !=null && parent.AccPersonFrame.document.AccPersonForm.b_days.value !=""))
			{
				maxAge = checkMaxAge();
			}
			if(maxAge == false )
			{
				alert(LocalErrors) ;
				window.close();
				return false;
			}
			/**/
		if(parent.AccPersonFrame.checkMandatory( fields, names))
		{    
			if(eval('parent.AccPersonFrame.document.forms[0].patient_id') != null)
			{
				parent.AccPersonFrame.document.forms[0].patient_name.disabled = false;

				if(eval('parent.AccPersonFrame.document.forms[0].national_id_no') != null)
				{
					parent.AccPersonFrame.document.forms[0].national_id_no.disabled = false;
					parent.AccPersonFrame.document.forms[0].national_id_no.readonly = true;
				}

				parent.AccPersonFrame.document.forms[0].sex.disabled = false;

				if(eval('parent.AccPersonFrame.document.forms[0].other_alt_type') != null)
				{
					parent.AccPersonFrame.document.forms[0].other_alt_type.disabled = false;
					parent.AccPersonFrame.document.forms[0].other_alt_Id.disabled = false;
				}

				if(parent.AccPersonFrame.document.forms[0].alt_id1_no)					
					if(eval('parent.AccPersonFrame.document.forms[0].alt_id1_no') != null)
						parent.AccPersonFrame.document.forms[0].alt_id1_no.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].alt_id2_no)					
					if(eval('parent.AccPersonFrame.document.forms[0].alt_id2_no') != null)
						parent.AccPersonFrame.document.forms[0].alt_id2_no.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].alt_id3_no)					
					if(eval('parent.AccPersonFrame.document.forms[0].alt_id3_no') != null)
						parent.AccPersonFrame.document.forms[0].alt_id3_no.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].alt_id4_no)					
					if(eval('parent.AccPersonFrame.document.forms[0].alt_id4_no') != null)
						parent.AccPersonFrame.document.forms[0].alt_id4_no.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].alt_id1_exp_date)					
					if(eval('parent.AccPersonFrame.document.forms[0].alt_id1_exp_date') != null)
						parent.AccPersonFrame.document.forms[0].alt_id1_exp_date.disabled = false;
				
				if(parent.AccPersonFrame.document.forms[0].alt_id2_exp_date)					
					if(eval('parent.AccPersonFrame.document.forms[0].alt_id2_exp_date') != null)
						parent.AccPersonFrame.document.forms[0].alt_id2_exp_date.disabled = false;
				
				if(parent.AccPersonFrame.document.forms[0].alt_id3_exp_date)					
					if(eval('parent.AccPersonFrame.document.forms[0].alt_id3_exp_date') != null)
						parent.AccPersonFrame.document.forms[0].alt_id3_exp_date.disabled = false;
				
				if(parent.AccPersonFrame.document.forms[0].alt_id4_exp_date)					
					if(eval('parent.AccPersonFrame.document.forms[0].alt_id4_exp_date') != null)
						parent.AccPersonFrame.document.forms[0].alt_id4_exp_date.disabled = false;


				if(parent.AccPersonFrame.document.forms[0].alt_id1_type)						if(eval('parent.AccPersonFrame.document.forms[0].alt_id1_type') != null)
						parent.AccPersonFrame.document.forms[0].alt_id1_type.disabled = false;
				
				if(parent.AccPersonFrame.document.forms[0].alt_id2_type)			
					if(eval('parent.AccPersonFrame.document.forms[0].alt_id2_type') != null)
						parent.AccPersonFrame.document.forms[0].alt_id2_type.disabled = false;
				
				if(parent.AccPersonFrame.document.forms[0].alt_id3_type)					
					if(eval('parent.AccPersonFrame.document.forms[0].alt_id3_type') != null)
						parent.AccPersonFrame.document.forms[0].alt_id3_type.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].alt_id4_type)					
					if(eval('parent.AccPersonFrame.document.forms[0].alt_id4_type') != null)
						parent.AccPersonFrame.document.forms[0].alt_id4_type.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].name_prefix1)						if(eval('parent.AccPersonFrame.document.forms[0].name_prefix1') != null)
						parent.AccPersonFrame.document.forms[0].name_prefix1.disabled = false;


				if(parent.AccPersonFrame.document.forms[0].first_name)							if(eval('parent.AccPersonFrame.document.forms[0].first_name') != null)
						parent.AccPersonFrame.document.forms[0].first_name.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].second_name)							if(eval('parent.AccPersonFrame.document.forms[0].second_name') != null)
						parent.AccPersonFrame.document.forms[0].second_name.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].third_name)							if(eval('parent.AccPersonFrame.document.forms[0].third_name') != null)
						parent.AccPersonFrame.document.forms[0].third_name.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].family_name)							if(eval('parent.AccPersonFrame.document.forms[0].family_name') != null)
						parent.AccPersonFrame.document.forms[0].family_name.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].name_suffix1)						if(eval('parent.AccPersonFrame.document.forms[0].name_suffix1') != null)
						parent.AccPersonFrame.document.forms[0].name_suffix1.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].name_prefix)						if(eval('parent.AccPersonFrame.document.forms[0].name_prefix') != null)
						parent.AccPersonFrame.document.forms[0].name_prefix.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].name_suffix)						if(eval('parent.AccPersonFrame.document.forms[0].name_suffix') != null)
						parent.AccPersonFrame.document.forms[0].name_suffix.disabled = false;

				/*Friday, January 14, 2011, IN025859*/
				if(parent.AccPersonFrame.document.forms[0].name_prefix_oth_lang)						if(eval('parent.AccPersonFrame.document.forms[0].name_prefix_oth_lang') != null)
						parent.AccPersonFrame.document.forms[0].name_prefix_oth_lang.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].first_name_oth_lang)						if(eval('parent.AccPersonFrame.document.forms[0].first_name_oth_lang') != null)
						parent.AccPersonFrame.document.forms[0].first_name_oth_lang.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].second_name_oth_lang)						if(eval('parent.AccPersonFrame.document.forms[0].second_name_oth_lang') != null)
						parent.AccPersonFrame.document.forms[0].second_name_oth_lang.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].third_name_oth_lang)						if(eval('parent.AccPersonFrame.document.forms[0].third_name_oth_lang') != null)
						parent.AccPersonFrame.document.forms[0].third_name_oth_lang.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].family_name_oth_lang)						if(eval('parent.AccPersonFrame.document.forms[0].family_name_oth_lang') != null)
						parent.AccPersonFrame.document.forms[0].family_name_oth_lang.disabled = false;

				if(parent.AccPersonFrame.document.forms[0].name_suffix_oth_lang)						if(eval('parent.AccPersonFrame.document.forms[0].name_suffix_oth_lang') != null)
						parent.AccPersonFrame.document.forms[0].name_suffix_oth_lang.disabled = false;
				/**/

			}
		
			parent.AccPersonFrame.document.AccPersonForm.patientId.value = document.AccPersonForm.patient_id.value ;
			parent.AccPersonFrame.document.AccPersonForm.Dobs.value = parent.AccPersonFrame.document.AccPersonForm.date_of_birth.value;
			parent.AccPersonFrame.document.AccPersonForm.action = '../../servlet/eIP.BookLodgerServlet' ;
			parent.AccPersonFrame.document.AccPersonForm.submit();			
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

// To get the Available Nursing Unit.
async function getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)
{
	var nursingUnit = aNursingUnit.value;
	var facilityId	= aFacilityId;
	var loginUserId	= aLoginUser;
	var	operStnID	= pOperStnID;
	var locale = document.forms[0].locale.value;
	var retVal =    new String();

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

    
	sql="select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit_lang_vw a, am_os_user_locn_access_vw b where a.language_id='"+locale+"' and a.facility_id  like ? and a.facility_id=b.facility_id and a.EFF_STATUS = 'E' and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N' and b.oper_stn_id  like ? and b.appl_user_id  like ? and check_lodger_yn ='Y' and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?)"
	
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

// function chkRefNo will chk the MAx Reference No from IP_PARAM with the current ref no.. 
// If the current no exceeds the max ref no value it will not Enter the details...
function chkRefNo()
{
	var Max_ref_no = parent.AccPersonFrame.document.AccPersonForm.Lodger_Max_RefNo.value;
	var next_Ref_no = parent.AccPersonFrame.document.AccPersonForm.Lodger_Next_RefNo.value;

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

function enableDisable(lookup,text)
{
	if(lookup.value == '')
	{
		document.forms[0].Authorised_text.readOnly	= false;
	}
	else
	{
		document.forms[0].Authorised_text.value		= '';
		document.forms[0].Authorised_text.readOnly	= true;
	}
	
	if(text.value == '')
	{
		document.forms[0].Authorised_lookup.readOnly	= false;
		document.forms[0].search_Authorised.disabled	= false;
	}
	else
	{
		document.forms[0].Authorised_lookup.value		= '';
		document.forms[0].Authorised_lookup.readOnly	= true;
		document.forms[0].search_Authorised.disabled	= true;
	}
}

// Added by Sridhar on 7 AUG 2004
// Function will check for empty values before calling up the common lookup func..
async function beforeGetAuthorised(target_id,target)
{
	if(document.forms[0].Authorised_hid.value != document.forms[0].Authorised_lookup.value)
	{
		if(document.forms[0].Authorised_lookup.value != "")
			 await getAuthoriser(target_id,target);
	}
}

async function getAuthoriser(target_id,target) 
{
	var facility_id = document.forms[0].facility_id.value;
//	var locale = document.forms[0].locale.value;
	var title=""; 
	
	var argumentArray=new Array(8);
	
	title=getLabel("Common.authorizedby.label","Common");
 
	argumentArray[0]="select APPL_USER_ID code, APPL_USER_NAME description from SM_APPL_USER_LANG_VW where language_id='"+localeName+"' and EFF_STATUS like ? and upper(APPL_USER_ID) like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) ";

	argumentArray[1]=new Array("EFF_STATUS");
	argumentArray[2]=new Array("E");
	argumentArray[3]=new Array(STRING,STRING);
	argumentArray[4]="2,3";
	argumentArray[5]=target.value;
	argumentArray[6]=CODE_DESC_LINK;
	argumentArray[7]=CODE_DESC;
			
	var retVal=await CommonLookup(title,argumentArray);
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Authorised_hid.value		=	arr[0];		document.forms[0].Authorised_lookup.value	=	arr[1];
		document.forms[0].Authorised_lookup.focus();
		document.forms[0].Authorised_hid.value		= document.forms[0].Authorised_lookup.value;
	}
	else
	{
		document.forms[0].Authorised_hid.value		= "";		document.forms[0].Authorised_lookup.value	= "";
	}
}

// This fucntion is used for validating the number input
function ChkNumberIP(fld, e, deci)
{
	if (parseInt(deci)>0)
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

	var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&login_user="+loginUser+"&locale="+locale+"&oper_id="+operstn+"&title="+encodeURIComponent(tit)+"&facility_id="+facility_id;
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
			//if(!isAfter(greg_date,sysdateTime,"DMYHM",localeName))
			if(!isAfter(greg_date,sysdateTime,"DMYHM","en"))//Modified By Dharma for Leap Year Issue on 29th Sep 2015
			{
				alert(getMessage("FRM_DT_GREATER_CURRENT_DT","IP"));
				document.forms[0].period_from.focus();
				document.forms[0].period_from.select();
				return false
			}
		}
	}
}

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
					if(Category == 'L')
					{
						var discharge_period = document.forms[0].Acc_Disc_Period;
						var discharge_period_unit = document.forms[0].Acc_Disc_Period_unit;
					}
					else if(Category == 'A')
					{
						var discharge_period = document.forms[0].Lodger_Disc_Period;
						var discharge_period_unit = document.forms[0].Lodger_Disc_Period_unit;
					}
					ValidateDischargeDateTime(from.value,to.value,discharge_period,discharge_period_unit )
				}
			}
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

function localValidations(obj)
{}

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
				//if(isAfter(checkinTimeObj.value,greg_date,"DMYHM",localeName)) {
				if(isAfter(checkinTimeObj.value,greg_date,"DMYHM","en")) { //Modified By Dharma on 30th Sep 2015 against Leap Year Issue
					alert(getMessage("CHKOUT_TIME_GT_CHKIN_TIME","IP"));
					obj.focus();
					obj.select();
				}
				else
				{					
					//if(!isBefore(greg_date,sysdateTime,"DMYHM",localeName)) {
					if(!isBefore(greg_date,sysdateTime,"DMYHM","en")) { //Modified By Dharma on 30th Sep 2015 against Leap Year Issue
						alert(getMessage("CHKOUT_TIME_SH_LESS_SYSTIME","IP"));
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

//MP related prefix and suffix fields validation

function checkPatSex1()  
{

   // var arLength = f_query_add_mod.document.getElementById("NamePrefixArray").length;
   var arLength =  parent.AccPersonFrame.NamePrefixArray.length;
   var q = 0;
   var res = new Boolean(false);

     while ( q <= arLength  )
	{

             if ( (parent.AccPersonFrame.document.AccPersonForm.name_prefix.value!='')  && ( unescape(parent.AccPersonFrame.NamePrefixArray[q]) == parent.AccPersonFrame.document.AccPersonForm.name_prefix.value ) )
		 {

               if(parent.AccPersonFrame.PrefixSexArray[q] != parent.AccPersonFrame.document.AccPersonForm.sex.value && parent.AccPersonFrame.PrefixSexArray[q] != 'B')
			 {
					
                  var msg = getMessage("PATIENT_SEX_MISMATCH",'MP');
				   if(localeName=='en')
					{
						msg = msg.replace('$',parent.AccPersonFrame.document.AccPersonForm.name_prefix_prompt.value);
					}else
					{
						msg = msg.replace('$',parent.AccPersonFrame.document.AccPersonForm.name_prefix_oth_prompt.value);
					} 
				 // msg = msg.replace('$',parent.AccPersonFrame.document.AccPersonForm.name_prefix_prompt.value);
				  LocalErrors = LocalErrors +msg  + '\n';
				  res = false;
			 }
			 else
				 res = true;
		 }
		 q++;
	}
	return res;

}

function checkPatSuffixSex1()  
{

    var arLength = parent.AccPersonFrame.NameSuffixArray.length;
    var q = 0;
    var res = new Boolean(false);
	
		while ( q <= arLength  )
	       {

                  if ( (parent.AccPersonFrame.document.AccPersonForm.name_suffix.value!='')  && ( unescape(parent.AccPersonFrame.NameSuffixArray[q]) == parent.AccPersonFrame.document.AccPersonForm.name_suffix.value ) )
			   {
					  if(parent.AccPersonFrame.SuffixSexArray[q] != parent.AccPersonFrame.document.AccPersonForm.sex.value && parent.AccPersonFrame.SuffixSexArray[q] != 'B')
				   {
						  var msg = getMessage("PATIENT_SEX_MISMATCH",'MP');
                          //msg = msg.replace('$',parent.AccPersonFrame.document.AccPersonForm.name_suffix_prompt.value);

						   if(localeName=='en')
							{
								msg = msg.replace('$',parent.AccPersonFrame.document.AccPersonForm.name_suffix_prompt.value);
							}else
							{
								msg = msg.replace('$',parent.AccPersonFrame.document.AccPersonForm.name_suffix_oth_prompt.value);
							} 
                          LocalErrors = LocalErrors +msg ;
						  res = false;
				   }
				   else
					   res = true;
			   }
			   q++;
		   }
		   return res;
}


function checkMaxAge()
{
	var age = parent.AccPersonFrame.document.AccPersonForm.b_age.value
	var max_patient_age = parent.AccPersonFrame.document.AccPersonForm.maxPatAge.value
	var months = parent.AccPersonFrame.document.AccPersonForm.b_months.value
	var days = parent.AccPersonFrame.document.AccPersonForm.b_days.value
	var res = new Boolean(false);
	if(parseInt(max_patient_age) < parseInt(age))
	{
		msg = getMessage('MAX_PATIENT_AGE','MP');
		msg = msg.replace('#', '$');
		msg = msg+' '+max_patient_age+' '+ getLabel('Common.Years.label','common');
		LocalErrors = LocalErrors +msg  ;
		res = false;
	}else if(parseInt(age) == parseInt(max_patient_age) && ((parseInt(months) > 0) ||  (parseInt(days) > 0)))
	{
		msg = getMessage('MAX_PATIENT_AGE','MP');
		msg = msg.replace('#', '$');
		msg = msg+' '+max_patient_age+' '+ getLabel('Common.Years.label','common');	
		LocalErrors = LocalErrors +msg  ;
		res = false;
	}else
		res = true

	return res
}

