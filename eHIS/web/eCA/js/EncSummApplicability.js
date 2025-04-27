//Created by Sethuraman for encounter Summary requirements

var retArray;// Global Variable

/*
    Function Name :  create()
	Description :	The Function is Used For loading EncSummApplicabilityAddModify.jsp in Insert Mode
*/
function create()
{
	f_query_add_mod.location.href = '../../eCA/jsp/EncSummApplicabilityAddModify.jsp';
	messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

/*
Function Name :  query()
Description :	The Function is Used For querying  the Records  that were inserted in to the Database
*/
function query()
{
	f_query_add_mod.location.href = '../../eCA/jsp/EncSummApplicabilityQueryCriteria.jsp';
}


/*
    Function Name :  deleterecord()
	Description :	The Function is Used For deleting Record of  EncSummApplicabilityAddModify.jsp in delete Mode
*/
function deleterecord()
{
	if(f_query_add_mod.document.encSummApplicabilityForm!=null)
	{
	if(f_query_add_mod.document.encSummApplicabilityForm.mode!=null)
	{
		var mode = f_query_add_mod.document.encSummApplicabilityForm.mode;
		if(mode.value == 'modify')
		{
			if(window.confirm(getMessage("DELETE_RECORD","Common"))==true)
			{
				mode.value = 'delete';
				f_query_add_mod.document.encSummApplicabilityForm.patientClass.disabled = false;				
				f_query_add_mod.document.encSummApplicabilityForm.method = "post";
				f_query_add_mod.document.encSummApplicabilityForm.action ="../../servlet/eCA.EncSummApplicabilityServlet";
				f_query_add_mod.document.encSummApplicabilityForm.target ="messageFrame";
				f_query_add_mod.document.encSummApplicabilityForm.submit();
			}
			else
			{
				commontoolbarFrame.location.reload();
				return false;
			}
		}
		else
		{
				var errorMsg = getMessage("RECORD_CANNOT_DELETE","CA");
				messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+errorMsg;
				
		}
	}
	else
		messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num=';
	}
	else
		messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num=';

}

/*
    Function Name :  apply()
	Description :	The Function is Used For inserting ,updating record in insert or modify Mode
*/
function apply()
{
	var mode = f_query_add_mod.document.encSummApplicabilityForm.mode;

	var fields = new Array(f_query_add_mod.document.encSummApplicabilityForm.summDesc,f_query_add_mod.document.encSummApplicabilityForm.summCode);
		
	var names = new Array(getLabel("Common.Summary.label",'COMMON'));
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		if(mode != null)
		{
			if(mode.value == 'insert')
			{
				//f_query_add_mod.document.encSummApplicabilityForm.submit();
			}
			if(mode.value=="modify")
			{
				f_query_add_mod.document.encSummApplicabilityForm.patientClass.disabled = false;
				//f_query_add_mod.document.encSummApplicabilityForm.submit();
			}
			if(mode.value=="delete")
			{
				mode.value = "modify";
				f_query_add_mod.document.encSummApplicabilityForm.patientClass.disabled = false;
				//f_query_add_mod.document.encSummApplicabilityForm.submit();				
			}
			f_query_add_mod.document.encSummApplicabilityForm.method = "post";
			f_query_add_mod.document.encSummApplicabilityForm.action ="../../servlet/eCA.EncSummApplicabilityServlet";
			f_query_add_mod.document.encSummApplicabilityForm.target ="messageFrame";
			f_query_add_mod.document.encSummApplicabilityForm.submit();
		}
	}
	else
	{
		var errorMsg = getMessage("SUMMARY_NOT_BLANK","CA");
		messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+errorMsg;				
	}
}


/*
    Function Name :  reset()
	Description :	The Function is Used For resetting the Contents of the Form of  SummaryApplicabilityAddModify.jsp
*/
function reset()
{
		
	if(f_query_add_mod.document.encSummApplicabilityForm != null)
	{
		if(f_query_add_mod.document.encSummApplicabilityForm.mode !=null)
		{
			create();
		}

		if(f_query_add_mod.document.encSummApplicabilityForm.mode.value == "insert")
		{
				f_query_add_mod.location.reload();
				messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
		}
		if(f_query_add_mod.document.encSummApplicabilityForm.mode.value == "modify")
		{
			var patientClassCode = f_query_add_mod.document.encSummApplicabilityForm.patientClass.value;
			var summCode = f_query_add_mod.document.encSummApplicabilityForm.summCode.value;
			var summDesc = f_query_add_mod.document.encSummApplicabilityForm.summDesc.value;
			var specialtyCode = f_query_add_mod.document.encSummApplicabilityForm.specialtyCode.value;
			var specialtyDesc = f_query_add_mod.document.encSummApplicabilityForm.specialtyDesc.value;
			var practTypeCode = f_query_add_mod.document.encSummApplicabilityForm.practTypeCode.value;
			var practTypeDesc = f_query_add_mod.document.encSummApplicabilityForm.practTypeDesc.value;
			var practitionerId = f_query_add_mod.document.encSummApplicabilityForm.practitionerId.value;
			var practitionerName = f_query_add_mod.document.encSummApplicabilityForm.practitionerName.value;
			var ageGrpCode = 	f_query_add_mod.document.encSummApplicabilityForm.ageGrpCode.value;
			var ageGrpDesc = 	f_query_add_mod.document.encSummApplicabilityForm.ageGrpDesc.value;
			
			f_query_add_mod.location.href='../../eCA/jsp/EncSummApplicabilityAddModify.jsp?'+
								'mode=modify&patientClassCode='+patientClassCode+'&summCode='+summCode+''+
								'&specialtyCode='+specialtyCode+'&summDesc='+summDesc+'&specialtyDesc='+specialtyDesc+''+
								'&ageGrpDesc='+ageGrpDesc+'&ageGrpCode='+ageGrpCode+'&practTypeDesc='+practTypeDesc+'&practTypeCode='+practTypeCode+''+
								'&practitionerId='+practitionerId+'&practitionerName='+practitionerName;
		}		
	}
	else
	{
		if(f_query_add_mod.location.href.indexOf("EncSummApplicabilityQueryCriteria.jsp") != -1){
			f_query_add_mod.location.reload();
			return false;
		}			
	}
}

/*
    Function Name :  onSuccess()
	Description :	The Function is Used For loading the Form ,Once data is been Inserted into Database
*/
function onSuccess()
{
	f_query_add_mod.location.href='../../eCA/jsp/EncSummApplicabilityAddModify.jsp';
}

/*
    Function Name :  CheckForSpecialCharacter(ObjText)
	Description :	The Function is Used For restricting Special Characters in the Text Box
    @param ObjText  Text Box Object
*/
function CheckForSpecialCharacter(ObjText)
{
	var key = window.event.keyCode;
		if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||(key == 32)||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))
			return false;
		return true;
}

/*
 Function Name :      defaultValue()
 Description        :     The Function is Used For Defaulting the Values of the Text Box in insert mode
 */
function defaultValue()
{
	var objText ;
	var objHidden = "";
	
	var mode = document.encSummApplicabilityForm.mode;
	if(mode.value=="insert")
	{
		objText  = document.encSummApplicabilityForm.specialtyDesc;
		objText.value = getLabel("Common.all.label","Common");		
		
		objHidden = document.encSummApplicabilityForm.specialtyCode;
		objHidden.value = '*ALL';
		
		objText  = document.encSummApplicabilityForm.practTypeDesc;
		objText.value = getLabel("Common.all.label","Common");
		
		objHidden = document.encSummApplicabilityForm.practTypeCode;
		objHidden.value = '*A';
		
		objText  = document.encSummApplicabilityForm.practitionerName;
		objText.value = getLabel("Common.all.label","Common");
		
		objHidden = document.encSummApplicabilityForm.practitionerId;
		objHidden.value = '*ALL';
		
		objText  = document.encSummApplicabilityForm.ageGrpDesc;
		objText.value = getLabel("Common.all.label","Common");
		
		objHidden = document.encSummApplicabilityForm.ageGrpCode;
		objHidden.value = '*ALL';
	}	
}

/*
    Function Name :  getFunctionCode(objText)
	Description :	It is a Common  Function is Used For Obtaining Code And Description from Common Look Up function based upon Text Box Name called 'OnBlur' Event of the Text Box
	@param ObjText  Text Box Object
 */
function getFunctionCode(objText)
{
	if(objText.name=='specialtyDesc')
	{
		if(objText.value != '')
		{				
			if(objText.value == getLabel("Common.all.label","Common"))
				return false;
			else
				SpecialtyCode();
		}
		else
		{
			objText.value = getLabel("Common.all.label","Common");
			document.encSummApplicabilityForm.specialtyCode.value='*ALL';
		}
	}	
	if(objText.name=='practTypeDesc')
	{
		if(objText.value != '')
		{
			if(objText.value == getLabel("Common.all.label","Common"))
				return false;
			else
				practTypeCode();
		}
		else
		{
			objText.value = getLabel("Common.all.label","Common");
			document.encSummApplicabilityForm.practTypeCode.value='*A';
		}
	}
	if(objText.name=='practitionerName')
	{
		if(objText.value != '')
		{
			if(objText.value == getLabel("Common.all.label","Common"))
				return false;
			else
				practTypeCode();
		}
		else
		{
			objText.value = getLabel("Common.all.label","Common");
			document.encSummApplicabilityForm.practitionerId.value='*ALL';
		}
	}
	if(objText.name=='ageGrpDesc')
	{
		if(objText.value != '')
		{
			if(objText.value == getLabel("Common.all.label","Common"))
				return false;
			else
				ageGrpCode();
		}
		else
		{
			objText.value = getLabel("Common.all.label","Common");
			document.encSummApplicabilityForm.ageGrpCode.value='*ALL';
		}
	}
	if(objText.name=='summDesc')
	{
		if(objText.value != '')
		{
			if(objText.value == getLabel("Common.all.label","Common"))
				return false;
			else
				summCode();
		}

	}
}

/*
    Function Name :  summCode()
	Description :	It used to get the Code And Description of Encounter Summaries 
 */
function summCode()
{
	var summary = document.encSummApplicabilityForm.summDesc.value;
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='EncSummApplicabilityIntermediate.jsp'><input type=hidden name='summCode' id='summCode' value='"+summary+"'><input type=hidden name='textName' id='textName' value='summary'></form></body></html>";
	parent.blankFrame.document.write(HtmlVal);
	parent.blankFrame.document.tempform.submit();
}

/*
    Function Name :  ageGrpCode()
	Description :	It is used to get the code and description of Age Group from am_age_group
 */
function ageGrpCode()
{
	var ageGrp = document.encSummApplicabilityForm.ageGrpDesc.value;
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='EncSummApplicabilityIntermediate.jsp'><input type=hidden name='ageGrpCode' id='ageGrpCode' value='"+ageGrp+"'><input type=hidden name='textName' id='textName' value='ageGrp'></form></body></html>";
	parent.blankFrame.document.write(HtmlVal);
	parent.blankFrame.document.tempform.submit();
}

/*
    Function Name :  SpecialtyCode()
	Description :	It used to get the code and description of Specialty from am_Speciality
*/
function SpecialtyCode()
{
	var specialty = document.encSummApplicabilityForm.specialtyDesc.value;
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='EncSummApplicabilityIntermediate.jsp'><input type=hidden name='specialty' id='specialty' value='"+specialty+"'><input type=hidden name='textName' id='textName' value='specialty'></form></body></html>";
	parent.blankFrame.document.write(HtmlVal);
	parent.blankFrame.document.tempform.submit();
}

/*
Function Name :  practTypeCode()
Description :	It used to get the code and description of Practitioner Type
*/
function practTypeCode()
{
	var practType = document.encSummApplicabilityForm.practTypeDesc.value;
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='EncSummApplicabilityIntermediate.jsp'><input type='hidden' name='practType' id='practType' value='"+practType+"'><input type='hidden' name='textName' id='textName' value='practType'></form></body></html>";
	parent.blankFrame.document.write(HtmlVal);
	parent.blankFrame.document.tempform.submit();
}

/*
Function Name :  practitionerId()
Description :	It used to get the ID and description of Practitioner
*/
function practitionerId()
{
	var practitionerName = document.encSummApplicabilityForm.practitionerName.value;
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='EncSummApplicabilityIntermediate.jsp'><input type='hidden' name='practitionerName' id='practitionerName' value='"+practitionerName+"'><input type='hidden' name='textName' id='textName' value='practitionerName'></form></body></html>";
	parent.blankFrame.document.write(HtmlVal);
	parent.blankFrame.document.tempform.submit();
}

/*
    Function Name :  callFunctionButton(sql,title,target)
	Description :	It used  Obtaining Code And Description   from Common Lookup
	@param sql   SQL Query  for Passing into Common Look Up Function under eCommon
	@param title  Title for the Web Page
	@param target  Text Object  
*/
function callFunctionButton(sql,title,target)
{	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retVal = await CommonLookup( title, argArray );

	return retVal;
}

/*
    Function Name :  callFunction(sql,title,target)
	Description :	It used  Obtaining Code And Description   from Common Lookup
	@param sql   SQL Query  for Passing into Common Look Up Function under eCommon
	@param title  Title for the Web Page
	@param target  Text Object
   
*/
function callFunction(sql,title,target)
{
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( title, argArray );
	return retArray;
 }


/*
    Function Name :  getSpecialty()
	Description :	It used to get the Specialty Code and Description
*/

function getSpecialty()
{
	sql = "SELECT  speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
	retArray = callFunctionButton(sql,getLabel("Common.speciality.label","Common"),document.encSummApplicabilityForm.specialtyDesc);
	if(retArray != null && retArray !="")	
	{
		document.encSummApplicabilityForm.specialtyDesc.value = retArray[1];
		document.encSummApplicabilityForm.specialtyCode.value = retArray[0];		
	}
	else
	{
		document.encSummApplicabilityForm.specialtyDesc.value = getLabel("Common.all.label","Common");
		document.encSummApplicabilityForm.specialtyCode.value = '*ALL';		
	}
}

/*
	Function Name :  getPractType()
	Description :	It used to get the Practitioner Code and Description
*/

function getPractType()
{
	sql = "SELECT PRACT_TYPE code,  DESC_SYSDEF description FROM am_pract_type where eff_status='E'  and upper(PRACT_TYPE) like upper(?) and upper(DESC_SYSDEF) like upper(?) order by 2 ";
	retArray = callFunctionButton(sql,getLabel("Common.practitionertype.label","Common"),document.encSummApplicabilityForm.practTypeDesc);
	if(retArray != null && retArray !="")	
	{
		document.encSummApplicabilityForm.practTypeDesc.value = retArray[1];
		document.encSummApplicabilityForm.practTypeCode.value = retArray[0];			
	}
	else
	{
		document.encSummApplicabilityForm.practTypeDesc.value = getLabel("Common.all.label","Common");
		document.encSummApplicabilityForm.practTypeCode.value = '*A';		
	}
}
 

/*
Function Name :  getPractitionerName()
Description :	It used to get the Practitioner ID and Name
*/

function getPractitionerName()
{
sql = "SELECT PRACTITIONER_ID code,  PRACTITIONER_NAME description FROM am_practitioner where eff_status='E'  and upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_NAME) like upper(?) order by 2 ";
retArray = callFunctionButton(sql,getLabel("Common.practitioner.label","Common"),document.encSummApplicabilityForm.practitionerName);
if(retArray != null && retArray !="")	
{
	document.encSummApplicabilityForm.practitionerId.value = retArray[0];
	document.encSummApplicabilityForm.practitionerName.value = retArray[1];			
}
else
{
	document.encSummApplicabilityForm.practitionerName.value = getLabel("Common.all.label","Common");
	document.encSummApplicabilityForm.practitionerId.value = '*ALL';		
}
}

/*
    Function Name : getageGroup()
	Description :	It used to get the Age Group  Code and Description
*/
function getAgeGroup()
{
	sql = "Select AGE_GROUP_CODE code, SHORT_DESC description from am_age_group where eff_status='E' and upper(AGE_GROUP_CODE) like upper(?)  and upper(SHORT_DESC) like upper(?) order by 2";
	retArray = callFunctionButton(sql,getLabel("Common.agegroup.label","Common"),document.encSummApplicabilityForm.ageGrpDesc);
	if(retArray != null && retArray !="")	
	{
		document.encSummApplicabilityForm.ageGrpDesc.value = retArray[1];
		document.encSummApplicabilityForm.ageGrpCode.value = retArray[0];			
	}
	else
	{
		document.encSummApplicabilityForm.ageGrpDesc.value = getLabel("Common.all.label","Common");
		document.encSummApplicabilityForm.ageGrpCode.value = '*ALL';		
	}
}

/*
    Function Name :  getSummary()
	Description :	It used to get the Summary Code  and Description
*/
function getSummary()
{
	sql = "Select es_summ_code code , es_summ_desc description from cr_es_summ_hdr where ES_SUMM_STATUS ='E' and upper(es_summ_code) like upper(?) and  upper(es_summ_desc) like upper(?) order by 2 ";
	retArray = callFunctionButton(sql,getLabel("Common.Summary.label","COMMON"),parent.f_query_add_mod.document.encSummApplicabilityForm.summDesc);
	if(retArray != null && retArray !="")	
	{
		document.encSummApplicabilityForm.summDesc.value = retArray[1];
		document.encSummApplicabilityForm.summCode.value = retArray[0];			
	}
	else
	{
		document.encSummApplicabilityForm.summDesc.value = '';
		document.encSummApplicabilityForm.summCode.value = '';
	}
}

