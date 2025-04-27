
var retArray;// Global Variable
/*
    Function Name :  create()
	Description :	The Function is Used For loading ChartApplicabilityAddModify.jsp in Insert Mode
 */
function create()
{
	f_query_add_mod.location.href = '../../eCA/jsp/ChartApplicabilityAddModify.jsp';
	messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}
/*
    Function Name :  deleterecord()
	Description :	The Function is Used For deleting Record of  ChartApplicabilityAddModify.jsp in delte Mode
 */
function deleterecord()
{

	if(f_query_add_mod.document.chartApplicabilityaddmodifyForm!=null)
	{
	if(f_query_add_mod.document.chartApplicabilityaddmodifyForm.mode!=null)
	{
		var mode = f_query_add_mod.document.chartApplicabilityaddmodifyForm.mode;
		if(mode.value == 'modify')
		{
			if(window.confirm(getMessage("DELETE_RECORD","Common"))==true)
			{
				mode.value = 'delete';
				f_query_add_mod.document.chartApplicabilityaddmodifyForm.patientClass.disabled = false;
				f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationType.disabled = false;
				f_query_add_mod.document.chartApplicabilityaddmodifyForm.submit();
			}
			else
			{
				commontoolbarFrame.location.reload();
				return false
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
	var mode = f_query_add_mod.document.chartApplicabilityaddmodifyForm.mode;

	var fields = new Array(f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartDesc,f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartCode)
		
	var names = new Array(getLabel("Common.Chart.label",'COMMON'));
if(f_query_add_mod.checkFields( fields, names, messageFrame))
{
	if(mode != null)
	{
		if(mode.value == 'insert')
		{
			f_query_add_mod.document.chartApplicabilityaddmodifyForm.submit();
		}
		if(mode.value=="modify")
		{
			f_query_add_mod.document.chartApplicabilityaddmodifyForm.patientClass.disabled = false;
			f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationType.disabled = false;
			f_query_add_mod.document.chartApplicabilityaddmodifyForm.submit();
		}
		if(mode.value=="delete")
		{
			mode.value = "modify"
			f_query_add_mod.document.chartApplicabilityaddmodifyForm.patientClass.disabled = false;
			f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationType.disabled = false;
			f_query_add_mod.document.chartApplicabilityaddmodifyForm.submit();
			
		}
	}
}
else
{
		var errorMsg =getMessage("CHART_CANNOT_BLANK","CA");
		messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+errorMsg;
				
}
}

/*
    Function Name :  query()
	Description :	The Function is Used For querying  the Records  that were inserted in to the Database
 */
function query()
{
	f_query_add_mod.location.href = '../../eCA/jsp/ChartApplicabilityQueryCriteria.jsp'
}
/*
    Function Name :  reset()
	Description :	The Function is Used For resetting the Contents of the Form of  ChartApplicabilityAddModify.jsp
 */
function reset()
{
		
		if(f_query_add_mod.document.chartApplicabilityaddmodifyForm != null)
		{
			if(f_query_add_mod.document.chartApplicabilityaddmodifyForm.mode !=null)
			{
				create();
			}

			if(f_query_add_mod.document.chartApplicabilityaddmodifyForm.mode.value == "insert")
			{
					f_query_add_mod.location.reload();
					messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
			}
			if(f_query_add_mod.document.chartApplicabilityaddmodifyForm.mode.value == "modify")
			{
	
				var 	patientClassCode = f_query_add_mod.document.chartApplicabilityaddmodifyForm.patientClass.value
				var chartId = f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartCode.value
				var specialtyCode = f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyCode.value;
				var practTypeCode = f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeCode.value;
				var practTypeDesc = f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeDesc.value;
				var chartDesc = f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartDesc.value;
				var specialtyDesc = f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyDesc.value;
				var practTypeDesc  = f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeDesc.value
				var locationTypeDesc = f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationType.value
				var locationDesc = f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationDesc.value
				var locationCode = f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationCode.value
				var ageGrpDesc = 	f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpDesc.value
				var ageGrpCode = 	f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpCode.value
				var dispSeqNo = 	f_query_add_mod.document.chartApplicabilityaddmodifyForm.dispSeqNo.value;//IN040032
				//f_query_add_mod.location.href='../../eCA/jsp/ChartApplicabilityAddModify.jsp?mode=modify&patientClassCode='+patientClassCode+'&chartCode='+chartId+'&specialtyCode='+specialtyCode+'&practTypeCode='+practTypeCode+'&practTypeDesc='+practTypeDesc+'&chartDesc='+chartDesc+'&specialtyDesc='+specialtyDesc+'&locationTypeCode='+locationTypeDesc+'&locationDesc='+locationDesc+'&locationCode='+locationCode+'&ageGrpDesc='+ageGrpDesc+'&ageGrpCode='+ageGrpCode;
				f_query_add_mod.location.href='../../eCA/jsp/ChartApplicabilityAddModify.jsp?mode=modify&patientClassCode='+patientClassCode+'&chartCode='+chartId+'&specialtyCode='+specialtyCode+'&practTypeCode='+practTypeCode+'&practTypeDesc='+practTypeDesc+'&chartDesc='+chartDesc+'&specialtyDesc='+specialtyDesc+'&locationTypeCode='+locationTypeDesc+'&locationDesc='+locationDesc+'&locationCode='+locationCode+'&ageGrpDesc='+ageGrpDesc+'&ageGrpCode='+ageGrpCode+'&dispSeqNo='+dispSeqNo;//IN040032
			}		
		}
		else
		{
			if(f_query_add_mod.location.href.indexOf("ChartApplicabilityQueryCriteria.jsp") != -1){
				f_query_add_mod.location.reload();
				return false;
			}			
		}
		//if(f_query_add_mod.document.forms[0])
			//f_query_add_mod.document.forms[0].reset();

}
/*
    Function Name :  onSuccess()
	Description :	The Function is Used For loading the Form ,Once data is been Inserted into Database
 */
function onSuccess()
{
	f_query_add_mod.location.href='../../eCA/jsp/ChartApplicabilityAddModify.jsp';
}
/*
    Function Name :  CheckForSpecialCharacter(ObjText)
	Description :	The Function is Used For restricting Special Chracters in the Text Box
   @param ObjText  Text Box Object
 */
function CheckForSpecialCharacter(ObjText)
{
	var key = window.event.keyCode
		if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||(key == 32)||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))
			return false
		return true
}
/*
 Function Name :      defaultValue()
 Description        :     The Function is Used For Defaulting the Values of the Text Box in insert mode
 */
function defaultValue()
{
	var objText ;
	var mode = document.chartApplicabilityaddmodifyForm.mode;
	if(mode.value=="insert")
	{
		objText  = document.chartApplicabilityaddmodifyForm.specialtyDesc;
		objText.value = getLabel("Common.all.label","Common");
		var objHidden = document.chartApplicabilityaddmodifyForm.specialtyCode;
		objHidden.value = '*ALL';
		objText  = document.chartApplicabilityaddmodifyForm.practTypeDesc;
		objText.value = getLabel("Common.all.label","Common");
		objHidden = document.chartApplicabilityaddmodifyForm.practTypeCode;
		objHidden.value = '*A';
		objText  = document.chartApplicabilityaddmodifyForm.locationDesc;
		objText.value = getLabel("Common.all.label","Common");
		objHidden = document.chartApplicabilityaddmodifyForm.locationCode;
		objHidden.value = '*ALL';
		objText  = document.chartApplicabilityaddmodifyForm.ageGrpDesc;
		objText.value = getLabel("Common.all.label","Common");
		objHidden = document.chartApplicabilityaddmodifyForm.ageGrpCode;
		objHidden.value = '*ALL';
		//objText  = document.chartApplicabilityaddmodifyForm.chartDesc;
		//objText.value = 'ALL';
		//objHidden = document.chartApplicabilityaddmodifyForm.chartCode;
		//objHidden.value = '*ALL';
		 if(document.chartApplicabilityaddmodifyForm.locationType.value=='*')
		 {
			objText  = document.chartApplicabilityaddmodifyForm.locationDesc;
			objText.value = getLabel("Common.all.label","Common");
			objHidden = document.chartApplicabilityaddmodifyForm.locationCode;
			objHidden.value = '*ALL';
			document.chartApplicabilityaddmodifyForm.locationDesc.disabled = true	
			document.chartApplicabilityaddmodifyForm.buttonLocation.disabled = true	
			 document.chartApplicabilityaddmodifyForm.locationTypeCode.value = ''
		 }
	}	
}
/*
    Function Name :  getFunctionCode(objText)
	Description :	It is a Common  Function is Used For Obtaining Code And Description from Common 					Look Up function based upon Text Box Name called 'OnBlur' Event of the Text Box
	@param ObjText  Text Box Object
 */
function getFunctionCode(objText)
{
		if(objText.name=='specialtyDesc')
		{
			if(objText.value != '')
			{
				
				 if(objText.value == getLabel("Common.all.label","Common"))
				return false
				else
				SpecialtyCode()
			}
			else
			{
				objText.value = getLabel("Common.all.label","Common");
				document.chartApplicabilityaddmodifyForm.specialtyCode.value='*ALL'
			}
		}
		if(objText.name=='practTypeDesc')
		{
			if(objText.value != '')
			{
				 if(objText.value == getLabel("Common.all.label","Common"))
				return false
				else
				practTypeCode()
			}
			else
			{
				objText.value = getLabel("Common.all.label","Common");
				document.chartApplicabilityaddmodifyForm.practTypeCode.value='*ALL'
			}
		}
		if(objText.name=='locationDesc')
		{
			if(objText.value != '')
			{
				 if(objText.value == getLabel("Common.all.label","Common"))
				return false
				else
				locationCode()
			}
			else
			{
				objText.value = getLabel("Common.all.label","Common");
				document.chartApplicabilityaddmodifyForm.locationCode.value='*ALL'
			}
		}
		if(objText.name=='ageGrpDesc')
		{
			if(objText.value != '')
			{
				 if(objText.value == getLabel("Common.all.label","Common"))
				return false
				else
				ageGrpCode()
			}
			else
			{
				objText.value = getLabel("Common.all.label","Common");
				document.chartApplicabilityaddmodifyForm.ageGrpCode.value='*ALL'
			}
		}
		if(objText.name=='chartDesc')
		{
			if(objText.value != '')
			{
				 if(objText.value == getLabel("Common.all.label","Common"))
				return false
				else
				chartCode()
			}

		}

}
/*
    Function Name :  chartCode()
	Description :	It used for   Obtaining Code And Description  of Chart Function
 
 */
function chartCode()
{
	var chart = document.chartApplicabilityaddmodifyForm.chartDesc.value;
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='ChartApplicabilityaddModifyIntermediate.jsp'><input type=hidden name='chartCode' id='chartCode' value='"+chart+"'><input type=hidden name='textName' id='textName' value='chart'></form></body></html>";
	parent.blankFrame.document.write(HtmlVal);
	parent.blankFrame.document.tempform.submit();
}
/*
    Function Name :  ageGrpCode()
	Description :	It is used for   Obtaining Code And Description  of Age Group from am_age_group
   
 */
function ageGrpCode()
{
	var ageGrp = document.chartApplicabilityaddmodifyForm.ageGrpDesc.value;
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='ChartApplicabilityaddModifyIntermediate.jsp'><input type=hidden name='ageGrpCode' id='ageGrpCode' value='"+ageGrp+"'><input type=hidden name='textName' id='textName' value='ageGrp'></form></body></html>";
	parent.blankFrame.document.write(HtmlVal);
	parent.blankFrame.document.tempform.submit();
}
/*
    Function Name :  SpecialtyCode()
	Description :	It used for   Obtaining Code And Description  of Speciality from am_Speciality
   
 */
function SpecialtyCode()
{
	var specialty = document.chartApplicabilityaddmodifyForm.specialtyDesc.value;
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='ChartApplicabilityaddModifyIntermediate.jsp'><input type=hidden name='specialty' id='specialty' value='"+specialty+"'><input type=hidden name='textName' id='textName' value='specialty'></form></body></html>";
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
async function callFunctionButton(sql,title,target)
{
	//var serviceVal   ="";
	//var search_desc	= "";
	//target.value='';
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
async function callFunction(sql,title,target)
{
	var serviceVal   ="";
	var search_desc	= "";
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
	retArray = await CommonLookup( title, argArray );
	return retArray;

 }
 /*
    Function Name :  practTypeCode()
	Description :	It used   Obtaining Code And Description  of Speciality for Practitioner
 */
 function 	practTypeCode()
 {

	var practType = document.chartApplicabilityaddmodifyForm.practTypeDesc.value;
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='ChartApplicabilityaddModifyIntermediate.jsp'><input type='hidden' name='practType' id='practType' value='"+practType+"'><input type='hidden' name='textName' id='textName' value='practType'></form></body></html>";
	parent.blankFrame.document.write(HtmlVal);
	parent.blankFrame.document.tempform.submit();
 }
  /*
    Function Name :  assignLocationType(objSelect)
	Description :	It used   for Assigning Table Name for  Dynamic Change of Queries
	@param objSelect : List Box Object
 */
 function assignLocationType(objSelect)
 {
	 if(objSelect.value=='*')
	 {
		objText  = document.chartApplicabilityaddmodifyForm.locationDesc;
		objText.value = getLabel("Common.all.label","Common");
		objHidden = document.chartApplicabilityaddmodifyForm.locationCode;
		objHidden.value = '*ALL';
		document.chartApplicabilityaddmodifyForm.locationDesc.disabled = true	
		document.chartApplicabilityaddmodifyForm.buttonLocation.disabled = true	
		 document.chartApplicabilityaddmodifyForm.locationTypeCode.value = ''
	 }
	 if(objSelect.value=='C')
	 {
		 document.chartApplicabilityaddmodifyForm.locationTypeCode.value = 'OP_CLINIC'
		 document.chartApplicabilityaddmodifyForm.locationDesc.disabled = false
		document.chartApplicabilityaddmodifyForm.buttonLocation.disabled = false	
	 }
	if(objSelect.value=='N')
	 {
		 document.chartApplicabilityaddmodifyForm.locationTypeCode.value = 'IP_NURSING_UNIT'
		 document.chartApplicabilityaddmodifyForm.locationDesc.disabled = false
		document.chartApplicabilityaddmodifyForm.buttonLocation.disabled = false	
	 }
 }
 /*
    Function Name :  locationCode()
	Description :	It used   for obtaining Location Code and Description
 */
 function locationCode()
 {
	var locationDesc = document.chartApplicabilityaddmodifyForm.locationDesc.value;
	var locationCode = document.chartApplicabilityaddmodifyForm.locationTypeCode.value;
	var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='ChartApplicabilityaddModifyIntermediate.jsp'><input type=hidden name='location' id='location' value='"+locationDesc+"'><input type=hidden name='textName' id='textName' value='location'><input type=hidden name='tableName' id='tableName' value='"+locationCode+"'></form></body></html>";
	parent.blankFrame.document.write(HtmlVal);
	parent.blankFrame.document.tempform.submit();
 }
  /*
    Function Name :  getSpecialty()
	Description :	It used   for obtaining Speacialty Code and Description
 */

async function getSpecialty()
{
	sql = "SELECT  speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
	retArray = await callFunctionButton(sql,getLabel("Common.speciality.label","Common"),document.chartApplicabilityaddmodifyForm.specialtyDesc)
	var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
					if(retArray != null && retArray !="")	
						{
							document.chartApplicabilityaddmodifyForm.specialtyDesc.value = arr[1];
							document.chartApplicabilityaddmodifyForm.specialtyCode.value = arr[0];
							
						}
						else
						{
							document.chartApplicabilityaddmodifyForm.specialtyDesc.value = getLabel("Common.all.label","Common");
							document.chartApplicabilityaddmodifyForm.specialtyCode.value = '*ALL';
							
						}
}
 /*
    Function Name :  getPractType()
	Description :	It used   for obtaining Practitioner Code and Description
 */

async function getPractType()
{
	sql = "SELECT PRACT_TYPE code,  DESC_SYSDEF description FROM am_pract_type where eff_status='E'  and upper(PRACT_TYPE) like upper(?) and upper(DESC_SYSDEF) like upper(?) order by 2 ";
	 retArray = await callFunctionButton(sql,getLabel("Common.practitionertype.label","Common"),document.chartApplicabilityaddmodifyForm.practTypeDesc)
	 var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retArray != null && retArray !="")	
			{
					document.chartApplicabilityaddmodifyForm.practTypeDesc.value = arr[1];
					document.chartApplicabilityaddmodifyForm.practTypeCode.value = arr[0];
					
			}
			else
			{
				document.chartApplicabilityaddmodifyForm.practTypeDesc.value = getLabel("Common.all.label","Common");
				document.chartApplicabilityaddmodifyForm.practTypeCode.value = '*A';
				
			}
}
 /*
    Function Name :  getLocation()
	Description :	It used   for obtaining Location Code and Description
 */
async function getLocation()
{
	var sql ;
	var locationType = document.chartApplicabilityaddmodifyForm.locationTypeCode.value;
	if(locationType == "*")
		return false
	if(locationType == "OP_CLINIC")
	{
		sql = "select CLINIC_CODE code, SHORT_DESC description from op_clinic where EFF_STATUS='E' and upper(CLINIC_CODE) like upper(?)  and upper(SHORT_DESC) like (?) order by 2";
	}
	else
	{
		sql = "select NURSING_UNIT_CODE code, SHORT_DESC description from ip_nursing_unit where EFF_STATUS='E' and upper(NURSING_UNIT_CODE) like upper(?)  and upper(SHORT_DESC) like (?) order by 2";
	}
	 retArray = await callFunctionButton(sql,getLabel("Common.Location.label","Common"),document.chartApplicabilityaddmodifyForm.locationDesc)
	 var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retArray != null && retArray !="")	
			{
					document.chartApplicabilityaddmodifyForm.locationDesc.value = arr[1];
					document.chartApplicabilityaddmodifyForm.locationCode.value = arr[0];
					
			}
			else
			{
				document.chartApplicabilityaddmodifyForm.locationDesc.value = getLabel("Common.all.label","Common");
				document.chartApplicabilityaddmodifyForm.locationCode.value = '*ALL';
				
			}
}
 /*
    Function Name : getageGroup()
	Description :	It used   for obtaining Age Group  Code and Description
 */
async function getageGroup()
{
	sql = "Select AGE_GROUP_CODE code, SHORT_DESC description from am_age_group where eff_status='E' and upper(AGE_GROUP_CODE) like upper(?)  and upper(SHORT_DESC) like upper(?) order by 2";
	 retArray = await callFunctionButton(sql,getLabel("Common.agegroup.label","Common"),document.chartApplicabilityaddmodifyForm.ageGrpDesc)
	 var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retArray != null && retArray !="")	
			{
					document.chartApplicabilityaddmodifyForm.ageGrpDesc.value = arr[1];
					document.chartApplicabilityaddmodifyForm.ageGrpCode.value = arr[0];
					
			}
			else
			{
				document.chartApplicabilityaddmodifyForm.ageGrpDesc.value = getLabel("Common.all.label","Common");
				document.chartApplicabilityaddmodifyForm.ageGrpCode.value = '*ALL';
				
			}
}
/*
    Function Name :  getChart()
	Description :	It used   for obtaining chart Id  and Description
 */
async function getChart()
{
	sql = "Select CHART_ID code, SHORT_DESC description from ca_chart where eff_status='E'  and upper(CHART_ID) like upper(?) and  upper(SHORT_DESC) like upper(?) order by 2";
	retArray = await callFunctionButton(sql,getLabel("Common.Chart.label","COMMON"),parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartDesc)
	
	var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retArray != null && retArray !="")	
			{
					document.chartApplicabilityaddmodifyForm.chartDesc.value = arr[1];
					document.chartApplicabilityaddmodifyForm.chartCode.value = arr[0];
					
			}
			else
			{
						document.chartApplicabilityaddmodifyForm.chartDesc.value = '';
						document.chartApplicabilityaddmodifyForm.chartCode.value = '';
			}
}
//IN040032 Starts
function CheckPositiveNo(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 1) {
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("INVALID_POSITIVE_NUMBER", "Common"));
            obj.select();
            obj.focus();
        }
       
    }
}
//IN040032 Ends

