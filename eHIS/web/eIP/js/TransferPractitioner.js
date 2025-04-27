function submitForm()
{
	parent.frames[1].document.forms[0].transfer.disabled = true;

	var flag = "F";
	
	if(parent.frames[1].document.TransferPractitioner_form.fr_speciality_code.value != parent.frames[1].document.TransferPractitioner_form.Splcode.value || parent.frames[1].document.TransferPractitioner_form.fr_practitioner_id.value != parent.frames[1].document.TransferPractitioner_form.practid.value)
	{
		flag = "T";
	}
	
	if(flag == 'T')
	{
		var fields = new Array();
		fields[0] = parent.frames[1].document.TransferPractitioner_form.transfer_type;
		fields[1] = parent.frames[1].document.TransferPractitioner_form.Splcode_desc;
		fields[2] = parent.frames[1].document.TransferPractitioner_form.practid;

		var names = new Array (	
		    getLabel("eIP.TransferType.label","IP"),
		    getLabel("Common.speciality.label","Common"),
			getLabel("Common.practitioner.label","Common")
			)
			
		if(checkFields1( fields, names)) 
		{
			var val="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.TransferPractitionerServlet' >";
			for(var i=0;i<parent.frames[1].document.forms[0].elements.length;i++)
			{
			   val += "<input type='hidden' name=\""+ parent.frames[1].document.forms[0].elements[i].name +"\" id=\""+ parent.frames[1].document.forms[0].elements[i].name +"\" value=\""+ parent.frames[1].document.forms[0].elements[i].value +"\">"
			}
			val += "</form></body><html>";
			parent.frames[2].document.write(val);
			parent.frames[2].document.Dummy_form.submit(); 
		}
		else
		{
			parent.frames[1].document.forms[0].transfer.disabled = false;
		}
	}
	else
	{
		/*
			alert(self.getMessage('ATLEAST_ONE_CHANGE','IP'));
			parent.frames[1].document.forms[0].transfer.disabled = false;
		*/
		if(parent.frames[1].document.TransferPractitioner_form.fr_practitioner_id.value == parent.frames[1].document.TransferPractitioner_form.practid.value)
		{
			var msg = getMessage('CAN_NOT_BE_SAME','IP');
			msg=msg.replace("$",getLabel("Common.practitioner.label","IP"));
			alert(msg);
		
			parent.frames[1].document.forms[0].transfer.disabled = false;
		}
	}
}

function checkFields1( fields, names)
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck1(fields[i].value)) {}
		else	
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"\n";
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}


function trimCheck1(inString)
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

function cancel()
{
	//window.parent.close();
    parent.parent.document.getElementById("dialog_tag").close();
}

function PopulateMedicalTeam()
{ 	
	resetMedicalTeam();

	var ippractid  = document.forms[0].practid.value;
	var spl_code = document.forms[0].Splcode.value;
	var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='querydept' id='querydept' method='post' action='../../eIP/jsp/MedicalTeamPopulate.jsp'><input type='hidden' name='ippractid' id='ippractid' value='"+ippractid+"'><input type='hidden' name='booking' id='booking' value='AssignBed'><input type='hidden' name='med_code' id='med_code' value=''><input type='hidden' name='spy_code' id='spy_code' value='"+spl_code+"'><input type='hidden' name='prt_code' id='prt_code' value=''></form></body></html>";

	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.querydept.submit();

}

// To Display the Practitioner as Chief of Selected Medical Team if
//  the attending pratitioner is empty.
function getMedicalTeamHead(Obj)
{
	if (Obj.value == "")
	{
		document.forms[0].pract_desc.value = "";
	}
	else if (document.forms[0].pract_desc.value == "")
	{
		 var teamId = document.forms[0].team_id.value;
		 var locale=document.forms[0].locale.value;

		 var sqlString = "SELECT pract_role, PRACTITIONER_ID FROM am_pract_for_team_vw WHERE team_id = '"+ document.forms[0].team_id.value + "' AND pract_role='C'";
		
		document.forms[0].selecTeam.value=sqlString;

		var HTMLValue = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>";
			HTMLValue += " <input type='hidden' name='selectedTeam' id='selectedTeam' value='"+teamId+"'>";
			HTMLValue += " <input type='hidden' name='reqParam' id='reqParam' value= 'executeQuery' >";
			HTMLValue +=" <input type='hidden' name='sqlQuery' id='sqlQuery' value=\""+sqlString+"\"></form></body></html>";
			
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLValue);
		parent.frames[2].document.dum_form.submit();
	}
} // End of getMedicalTeamHead().

function resetMedicalTeam()
{
		var selected = document.forms[0].team_id;
		while ( selected.options.length > 0 )
			selected.remove(selected.options[0]);
		var	str1 = "" ;
		var	str2 =  "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		var element = parent.frames[1].document.createElement('OPTION');
		element.text = str2; 
		element.value= str1;
		document.forms[0].team_id.add(element);
}
//========== functions copied from TranferPractitionerMain.jsp ===================
// Added by Sridhar on 2 JULY 2004
// Function chkPractRole will check whether the selected Practitioner is an Consultant Practitioner or not...IF 'Yes'.. then user will have to select another practitioner..
function chkPractRole(practID)
{
	var sStyle = document.forms[0].sStyle.value;
	var encounterId = document.forms[0].encounter_id.value;
	var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='practRole' id='practRole' method='post' action='../../eIP/jsp/PractIncompleteError.jsp?criteria=chkPractRole&encounter_ID="+encounterId+"&pract_ID="+practID+"'></form></BODY></HTML>";
	parent.frames[3].document.write(HTMLVal);
	parent.frames[3].document.forms[0].submit();
}

function focusFirst()
{
	document.forms[0].transfer_type.focus();
}

function checkSpecTxtVal(aSpecialtID, Facility_ID)
{
	if(document.forms[0].Splcode_desc.value == "")
		getSpecialty(aSpecialtID, Facility_ID)
}

function checkPractTxtVal(obj,target, aFacilityID)
{
	if(document.forms[0].pract_desc.value == "")
		getPractitionerLocal(obj,target, aFacilityID);
}

// Added by Sridhar on 3 FEB 2004
// Function will check for empty values before calling up the common lookup func..
		
function BeforeGetSpecialty(aSpecialtID, Facility_ID)
{
	
	if(document.forms[0].Splcode_desc.value == "")
	{
		document.forms[0].pract_desc.value = "";
		document.forms[0].pract_desc_hid.value = "";
			document.forms[0].practid.value = "";
			document.forms[0].team_id.value = "";
			delete_values(document.forms[0].team_id)
	}
	if(document.forms[0].spec_desc_hid.value != document.forms[0].Splcode_desc.value)
	{
		if(document.forms[0].Splcode_desc.value != "")
			getSpecialty(aSpecialtID, Facility_ID)
	}
}
function BeforGetPractitioner(obj,target, aFacilityID)
{
	if(document.forms[0].pract_desc_hid.value != document.forms[0].pract_desc.value)
	{
		if(document.forms[0].pract_desc.value != "")
			getPractitionerLocal(obj,target, aFacilityID);
		else if(document.forms[0].pract_desc.value == "")
		{
			document.forms[0].pract_desc_hid.value = "";
			document.forms[0].practid.value = "";
		}
	}
}

// By Annadurai 2/7/2004 starts.
// To get the specialty using CommonLookup.
async function getSpecialty(aSpecialtID, Facility_ID)
{
	var target			= document.forms[0].Splcode_desc;
	var code			= document.forms[0].nursing_unit.value;
	var locale          =document.forms[0].locale.value;
	var FacilityID		= Facility_ID;
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	
	sql	=	"Select a.speciality_code code, am_get_desc.am_speciality(speciality_code,'"+locale+"',2),a.short_desc description from am_speciality_lang_vw a, ip_nurs_unit_for_specialty b where language_id='"+locale+"' and eff_status like ? and a.speciality_code=b.specialty_code and b.facility_id like '"+FacilityID+"' and b.nursing_unit_code like '"+code+"' and upper(a.speciality_code) like upper(?) and upper(a.short_desc) like upper(?) ";
	var tit	= getLabel("Common.speciality.label","Common");
	
	dataNameArray[0]	= "eff_status" ;
	dataValueArray[0]	= "E";
	dataTypeArray[0]	= STRING;
	
	/*
	dataNameArray[0]	= "b.facility_id" ;
	dataValueArray[0]	= FacilityID;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "b.nursing_unit_code" ;
	dataValueArray[1]	= code;
	dataTypeArray[1]	= STRING ;
	*/
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "3, 4";
	argumentArray[5] = aSpecialtID.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	
	
	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Splcode.value=arr[0];
		document.forms[0].Splcode_desc.value=arr[1];
		document.forms[0].spec_desc_hid.value = document.forms[0].Splcode_desc.value;
		document.forms[0].pract_desc.value="";
		document.forms[0].practid.value="";
		PopulateMedicalTeam();
	}
	else
	{
		document.forms[0].Splcode_desc.value="";
		document.forms[0].Splcode.value="";
		document.forms[0].pract_desc.value="";
		document.forms[0].practid.value="";
		document.forms[0].Splcode_desc.focus();
	} 
} // End of getSpecialty().

function checkForValues()
{
	if (document.forms[0].Splcode_desc.value=="")
	{
		flag = 2;
		alert(getMessage('SPLTY_NOTNULL','IP'));
		document.forms[0].Splcode_desc.focus();
	}
} // End of checkForValues.

// To get the Attending Pratitioner using GeneralPratitionerSearch.
function getPractitionerLocal(obj,target, aFacilityID)
{
	checkForValues();
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	
	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName=document.forms[0].practid.name;

	var nursing_unit_code	= document.forms[0].nursing_unit.value;
	var spl_code			= document.forms[0].Splcode.value;
	if(nursing_unit_code != "")
	{locale=document.forms[0].locale.value;
		if(spl_code != "")
		{
			var facility_id = aFacilityID;
			getPractitioner(obj, target, facility_id, spl_code,nursing_unit_code,"Q5");
			/*
			var sql= " SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, a.PRIMARY_SPECIALITY_CODE, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2)   primary_specialty, a.gender gender, am_get_desc.am_position(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.PRIMARY_SPECIALITY_CODE = '"+spl_code+"' AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) OR UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?,a.practitioner_name))) AND a.sex LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) ";

			var sql2= " SELECT a.facility_id, a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, a.PRIMARY_SPECIALITY_CODE, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2)   primary_specialty, a.gender gender, am_get_desc.am_position(a.position_code,'"+locale+"',1) job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.PRIMARY_SPECIALITY_CODE = '"+spl_code+"' AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND e.practitioner_id = a.practitioner_id AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) and UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?,a.practitioner_name))) AND a.sex LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL) ";

			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	= "<root><SEARCH " ;
			xmlStr += " practName_FName=\"" +practName_FName + "\"";
			xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
			xmlStr += " practId_FName=\"" + practId_FName + "\"";
			xmlStr += " sql=\"" +escape(sql)+ "\"";
			xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
			xmlStr += " practitioner_type=\"" + "" + "\"";
			xmlStr += " specialty_code=\"" + spl_code+ "\"";
			xmlStr += " job_title=\"" + "" + "\"";
			xmlStr += " gender=\"" + "" + "\"";

			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);	
			*/
		}
		else
		{
			var error = parent.frames[0].getMessage('CAN_NOT_BE_BLANK',"Common");
			error = error.replace('$',getLabel("Common.speciality.label","Common"));
			alert(error);	
		}
	}
	else
	{
		var error = parent.frames[0].getMessage('CAN_NOT_BE_BLANK',"Common");
		error = error.replace('$',getLabel("Common.nursingUnit.label","Common"));
		alert(error);	
	}

} // End of getPractitioner();

// To set the values to Attending Practitioner when using  
// GeneralPratitionerLookup. It's called by the GeneralPratitionerLookup.
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practid.value=arr[0];
		document.forms[0].pract_desc.value=arr[1];			
		chkPractRole(document.forms[0].practid.value);
		PopulateMedicalTeam();
	}
	else
	{
		resetMedicalTeam();
		document.forms[0].practid.value="";
		document.forms[0].pract_desc.value="";			
		document.forms[0].team_id.value="";
	}
} // End of PractLookupRetVal().
//========== functions copied from TranferPractitionerMain.jsp **** END===================
//========== function copied from TransferPractitioner.jsp **** END===================
function reset()
{
	parent.frames[2].frames[1].document.forms[0].reset();
	parent.frames[2].frames[2].location.href = "../../eCommon/html/blank.html";
	parent.frames[2].frames[1].document.forms[0].search.disabled=false;

}


function delete_values(field)
{
	var selected = field;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	var opt=document.createElement("Option");
	opt.text="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	opt.value="";
	field.add(opt);
}

