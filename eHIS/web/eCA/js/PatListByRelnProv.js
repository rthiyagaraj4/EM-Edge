function locnTypeChange(obj)
{
	var checkValue = obj.value;
	if((checkValue=='OP') || (checkValue=='IP'))
	{
			document.getElementById("groupByEpisode").checked = true;
			document.getElementById("groupByEpisode").disabled = true;
			document.getElementById("groupByEpisode").value='Y';
	}
	else if(checkValue=='Z')
	{
		if(document.getElementById("groupByReln").disabled)
			document.getElementById("groupByReln").disabled = false;
		if(document.getElementById("groupByEpisode").disabled)
			document.getElementById("groupByEpisode").disabled = false;
	}
	
	document.forms[0].checkedOut.disabled = false;
	document.forms[0].checkedOut.checked = false;
	document.forms[0].checkedOut.value = 'N';

	document.forms[0].discharged.disabled = false;
	document.forms[0].discharged.checked = false;
	document.forms[0].discharged.value = 'N';

	document.forms[0].nonencspec.disabled = false;
	document.forms[0].nonencspec.checked = false;
	document.forms[0].nonencspec.value = 'N';
	
	if(checkValue=='XT')
	{
		document.forms[0].checkedOut.disabled = true;
		document.forms[0].discharged.disabled = true;
		document.forms[0].nonencspec.checked = true;
		document.forms[0].nonencspec.value='Y';
		document.forms[0].nonencspec.disabled = true;

		document.getElementById("visitType").selectedIndex = 0;
		document.getElementById("visitType").disabled = true;
	}
	else if (checkValue=='OP'||checkValue=='EM')
	{
		document.forms[0].checkedOut.disabled = false;
		document.forms[0].discharged.disabled = true;
		document.forms[0].nonencspec.disabled = true;
		if (checkValue=='OP')
		{
			document.getElementById("visitType").disabled = false;
		}
		else
		{
			document.getElementById("visitType").selectedIndex = 0;
			document.getElementById("visitType").disabled = true;
		}
	}
	else if (checkValue=='IP'||checkValue=='DC')
	{
		document.forms[0].checkedOut.disabled = true;
		document.forms[0].discharged.disabled = false;
		document.forms[0].nonencspec.disabled = true;
		
		document.getElementById("visitType").selectedIndex = 0;
		document.getElementById("visitType").disabled = true;
	}
	else if(checkValue=='Z')
	{
		document.forms[0].checkedOut.disabled = false;
		document.forms[0].discharged.disabled = false;
		document.forms[0].nonencspec.disabled = false;
		
		document.getElementById("visitType").selectedIndex = 0;
		document.getElementById("visitType").disabled = true;
		
	}
}

function checkboxChk(obj)
{
	if(obj.name=="groupByReln")
	{
		if(document.getElementById("groupByReln").checked==false ||document.getElementById("groupByReln").checked==true)
		{
			if((document.forms[0].locationType.value=='IP') || (document.forms[0].locationType.value=='OP') || (document.forms[0].locationType.value=='EM') || (document.forms[0].locationType.value=='DC'))
			{
				document.getElementById("groupByEpisode").disabled=false;
			}
		}
		if((document.getElementById("groupByEpisode").disabled) && (document.getElementById("groupByEpisode").checked))
		{
			document.getElementById("groupByEpisode").disabled = false;
		}
		else if((!document.getElementById("groupByEpisode").disabled) && (!document.getElementById("groupByEpisode").checked))
		{
			document.getElementById("groupByEpisode").disabled = true;
			document.getElementById("groupByEpisode").value = 'Y';
			document.getElementById("groupByEpisode").checked = true;
		}
		else if((!document.getElementById("groupByEpisode").disabled) && (document.getElementById("groupByEpisode").checked))
		{
			if(document.forms[0].locationType.value=='Z')
			{
				document.getElementById("groupByEpisode").disabled = false;
			}
			else
			{
				document.getElementById("groupByEpisode").disabled = true;
			}
		}
	}
	else if(obj.name=="groupByEpisode")
	{
		if(obj.checked == false)
		{
			if(document.getElementById("groupByReln").checked)
			{
				document.getElementById("groupByReln").checked = false;
				document.getElementById("groupByReln").value = 'N';
			}
		}
	}
	if(obj.checked ==true) obj.value='Y'
	else obj.value = 'N'
	/*
	if(obj.name=="groupByReln"){
		if((document.getElementById("groupByEpisode").disabled) && (document.getElementById("groupByEpisode").checked)){
			document.getElementById("groupByEpisode").disabled = false;
		}
		else if((!document.getElementById("groupByEpisode").disabled) && (!document.getElementById("groupByEpisode").checked)){
			document.getElementById("groupByEpisode").disabled = true;
			document.getElementById("groupByEpisode").value = 'Y';
			document.getElementById("groupByEpisode").checked = true;

		}
		else if((!document.getElementById("groupByEpisode").disabled) && (document.getElementById("groupByEpisode").checked)){
			document.getElementById("groupByEpisode").disabled = true;
		}
	}else if(obj.name=="groupByEpisode"){
		if(obj.checked == false){
			if(document.getElementById("groupByReln").checked){
				document.getElementById("groupByReln").checked = false;
			}
		}
	}
	if(obj.checked ==true) obj.value='Y'
	else obj.value = 'N'
	*/
}

function searchClick()
{
	var locationType=document.forms[0].locationType.value;
	var relationshipCode=document.forms[0].relnCode.value;
	var frDt = document.forms[0].fromDt.value;
	var toDt=document.forms[0].toDt.value;
	var groupByReln=document.forms[0].groupByReln.value;
	var groupByEpisode=document.forms[0].groupByEpisode.value;
	var patientId = document.forms[0].patientId.value;
	var queueId = document.forms[0].queueId.value;
	var sortOrder = document.forms[0].sortOrder.value;
	var checkedOut = document.forms[0].checkedOut.value;
	var discharged = document.forms[0].discharged.value;
	var nonencspec = document.forms[0].nonencspec.value;
	var attend_practId = document.forms[0].AttendPract.value;
	var speciality = document.forms[0].specialty_code.value;
	var visitType = document.forms[0].visitType.value;

	document.forms[0].order_by.value="";
	document.forms[0].re_order.value="";
	document.forms[0].anchor_id.value="";

	/*if(patientId == null || patientId == "")
	{
		//var strMesg = getMessage("NO_PATIENT_ID",'CA');
	var strMesg=getMessage("SHOULD_NOT_BE_BLANK","Common");
	strMesg=strMesg.replace("{1}",getLabel('Common.patientId.label','Common'));
		if(locationType == "Z"||relationshipCode == 'ALL' )
		{
			alert(strMesg);
		}

	}
	else*/

	/*
		Added by Kishore Kumar N 06-05-2010, Tuning by Filter date
	*/
	var fromDate = document.PatCriteriaFrm.fromDt;
	var toDate = document.PatCriteriaFrm.toDt;
	var locale = document.PatCriteriaFrm.locale.value;
	var flag = true;

	if(fromDate.value == '')
	{
		alert(getMessage("FROM_DATE_NOT_BLANK", "CA"));
		fromDate.focus();
		return false;
	}

	if(toDate.value == '')
	{
		alert(getMessage("TO_DATE_NOT_BLANK", "CA"));
		toDate.focus();
		return false;
	}
	if(patientId == '')
	{
		if(!dateRangeValidation(fromDate, toDate, locale, '7', 'DMY'))
		{
			top.content.workAreaFrame.PatResultFr.location.href = "../../eCommon/html/blank.html";
			alert(getMessage("PAT_LST_LOCN_CRITERIA", "CA"));
			return false;
		}
		else
		{
			flag = true;
		}
	}	

	if(flag)
	{
		top.content.workAreaFrame.PatResultFr.location.href = '../jsp/PatListByRelnProvResultMain.jsp?locationType='+locationType+'&relationshipCode='+relationshipCode+'&fromDate='+frDt+'&toDate='+toDt+'&groupByReln='+groupByReln+'&groupByEpisode='+groupByEpisode+'&patientId='+patientId+'&queueId=' +queueId +'&sortOrder='+sortOrder+'&checkedOut='+checkedOut+'&discharged='+discharged+'&nonencspec='+nonencspec+ '&attend_practId='+attend_practId+ '&speciality='+speciality+'&visitType='+visitType ;
	}
	/*
		ends here.
	*/
	
}	



function clearClick()
{
	document.forms[0].reset();
	if(top.content!=null)
	{
		top.content.workAreaFrame.PatResultFr.location.href = "../../eCommon/html/blank.html";
	}
	else
	{
		parent.PatResultFr.location.href = "../../eCommon/html/blank.html";
	}
}
function defaultGroupBy()
{
	var chkLocn = document.getElementById("groupByReln").checked ; 
	if(chkLocn)
	{
		document.getElementById("groupByEpisode").value='Y';
		document.getElementById("groupByEpisode").disabled=true;
	}
}

function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

function changeLocnCode()
{
	obj=document.forms[0].relnCode;
	if(obj.value=='ALL')
		document.forms[0].groupByReln.disabled=false;
	else
	{
		if(document.forms[0].locationType.value=='Z')
		{
		}
		else
		{
			document.forms[0].groupByReln.checked=true;
			document.forms[0].groupByReln.disabled=true;
			document.forms[0].groupByReln.value='Y';
		}
	}
}


function CheckSystemDateLesser(from,today) { //args objects 1st is this object & second is the date in dd/mm/yyyy
 if(today != "" && from.value !="" )
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today ;
				
				if(fromdate.length > 0 && todate.length > 0 )
				{
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) < Date.parse(fromdt))
						{
							//var msg =getCAMessage("DATE_GREATER_SYSDATE");
							var msg =getMessage("FROM_DATE_GREATER_SYSDATE","CA");	
							alert(msg);
							//top.messageframe.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) >= Date.parse(fromdt))
						{
							parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp?';
							return true;
						}
				}
			return true;
	 }
	 return true;
}

/*function ftDateCheck(from,to,obj,obj1)
{
	if(CheckSystemDateLesser(obj,obj1))
	{ 
		if(doDateCheckAlert(from,to)==false)
		{
			alert(top.header.getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
				to.select();
				to.focus();
		}
	}
}*/

function ftDateCheck(from,to,currDate,format,locale,objName)
	{
		
		if(!(from.value == "" ))
		{
		 if(!isBeforeNow(from.value,format,locale))
			{
			
				alert(top.header.getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				from.select();
				from.focus();
				return false;
				
			}
			else
			{ 
			 if(!(to.value == "" ))
				{
				   if(isBeforeNow(to.value,format,locale))

				{
					if(isAfter(to.value,from.value, format, locale))
					{
						return true;
					}
					else
					{
						alert(top.header.getMessage("TO_DT_GR_EQ_FM_DT","CA"));
						if(objName!="undefined")
						{	if(objName=="to")
							{
								to.value="";								
							}
							else if(objName=="from")
							{
								from.value="";								
							}
						}
						return false;
					}
				}
				else
				{
					alert(top.header.getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
					to.select();
					to.focus();
					return false;
				}
				}
			}
		
		}
		else
	{
			if((!to.value==""))
			{
				if(!isBeforeNow(to.value, format, locale))
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					to.select();
					to.focus();
					return false;
				}
			}
	}
}
async function callPatientSearch()
{
	var pat_id =  await PatientSearch();
	if(pat_id != null)
		document.getElementById("patientId").value = pat_id;
}

function checkDuplicate(obj)
{
	ChangeUpperCase(obj);
	if(obj.value != "")
	{
		var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='frmDuplicateId' id='frmDuplicateId' method='post' action='../../eCA/jsp/CAValidatePatientId.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+escape(obj.value)+"'><input type='hidden' name='fromFunction' id='fromFunction' value='PatListByMedService'></form></body></html>";
		top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		top.content.messageFrame.document.frmDuplicateId.submit();
	}
}

function disBtn(obj)
{
	//obj.disabled = true;
}
	
async function showRelnCodeWindow()
{

	var target			= document.forms[0].relnDesc;
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight		= "10" ;
	var dialogWidth	= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= getLabel("Common.relationship.label","COMMON");
		
	var locale=document.PatCriteriaFrm.locale.value;

	//var sql="select PRACT_RELN_ID PHYS_PROV_RELN_ID, initcap(substr(PRACT_RELN_NAME,1,30)) SHORT_DESC from  CA_PRACT_RELN where eff_status!=`D`";

	/*Commented by Archana on 2/11/2010 at 9:03 PM for IN018847*/
		
	//var sql="select PRACT_RELN_ID code, initcap(substr(PRACT_RELN_NAME,1,30)) description from  CA_PRACT_RELN_LANG_VW  where eff_status='E' and language_id ='"+locale+"' and upper(PRACT_RELN_ID) like upper(?) and upper(PRACT_RELN_NAME) like upper(?) order by PRACT_RELN_NAME";


	/*added by Archana on 2/11/2010 at 9:03 AM for IN018847*/
		/*
			Removed the initcaps of the Practitioner Names in the query.
		*/

	var sql="select PRACT_RELN_ID code, PRACT_RELN_NAME description from  CA_PRACT_RELN_LANG_VW  where eff_status='E' and language_id ='"+locale+"' and upper(PRACT_RELN_ID) like upper(?) and upper(PRACT_RELN_NAME) like upper(?) order by PRACT_RELN_NAME";





	//var sql="select PRACT_RELN_ID PHYS_PROV_RELN_ID, initcap(substr(CA_GET_DESC.CA_PRACT_RELN(PRACT_RELN_ID,'"+locale+"','1'),1,30)) SHORT_DESC from  CA_PRACT_RELN where eff_status!=`D`";

	//search_code="PRACT_RELN_ID";
	//search_desc="PRACT_RELN_NAME";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
		/*Commented by Archana on 2/18/2010 at 4:01 PM for IN019460*/
	//argArray[4] = "2,1";
	   /*added by Archana on 2/18/2010 at 4:01 PM for IN019460*/
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;

	retArray= await CommonLookup(title,argArray ); 
	
	//retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+title+"&dispDescFirst=dispDescFirst",arguments,features);
		
	var arr=new Array();
	
	if (retArray != null && retArray != "" )
	{
		var retVal=unescape(retArray);
	    arr=retVal.split(",");
	   	document.forms[0].relnDesc.value=arr[1];
		document.forms[0].relnCode.value=arr[0];
		//document.forms[0].relnDesc.focus();		
	}
	else
	{
		document.forms[0].relnDesc.value="";
		document.forms[0].relnCode.value="ALL";
		//target.focus();
	}
	changeLocnCode();
}

async function getRelnCode(obj)
{
	if (obj.value!="")
	{
		await showRelnCodeWindow();
	}
	else
	{
		document.forms[0].relnDesc.value="";
		document.forms[0].relnCode.value="ALL";
	}
}
function setCheckedOut(obj)
{
	if(obj.checked)
	{
		document.forms[0].checkedOut.value='Y';
	}
	else
	{
		document.forms[0].checkedOut.value='N';
	}

}

function setDischarged(obj)
{
	if(obj.checked)
	{
		document.forms[0].discharged.value='Y';
	}
	else
	{
		document.forms[0].discharged.value='N';
	}

}
function setNonEncSpec(obj)
{
	if(obj.checked)
	{
		document.forms[0].nonencspec.value='Y';
	}
	else
	{
		document.forms[0].nonencspec.value='N';
	}
}

async function populatePract1(obj)
{
	if (obj.value != "")
	{
		await populatePract();
	}
	else
	{
		document.forms[0].AttendPract.value = "";
	}
}

async function populatePract()
{
		var target			= document.forms[0].pract;
		var stdval          = document.forms[0].AttendPract.value;
		var facilityid      = document.forms[0].facilityid.value;
		var locale			= document.forms[0].locale.value;
       
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.practitioner.label","Common");
		
		var sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id and b.language_id = '"+locale+"' and a.eff_status = 'E' and  upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by b.practitioner_name";

		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retVal = await CommonLookup( title, argArray )
		
		var arr=new Array();		
		    
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retArray=unescape(retVal);
		    arr=retArray.split(",");
		   	document.forms[0].pract.value = arr[1];
		   	document.forms[0].AttendPract.value = arr[0];
		}
		else
		{
			document.forms[0].pract.value = "";
			document.forms[0].AttendPract.value = "";
		} 
}

async function getSpecialty1(obj)
{
	if (obj.value != "")
	{
		await getSpecialty();
	}
	else
	{
		document.forms[0].specialty_code.value = "";
	}
}

async function getSpecialty()
{
		var target			= document.forms[0].specialty;
		var stdval          = document.forms[0].specialty_code.value;
		var pract			= document.forms[0].AttendPract.value;
		var facilityid      = document.forms[0].facilityid.value;
		var locale			= document.forms[0].locale.value;
       
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.Specialty.label","Common");
		
		var sql="select a.SPECIALITY_CODE code, a.SHORT_DESC description from AM_SPECIALITY_lang_vw a where eff_status = 'E' and language_id = '"+locale+"' ";

		if(pract != '')
			sql = sql + " and SPECIALITY_CODE  in (select nvl(PRIMARY_SPECIALITY_CODE,'***') PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id='"+pract+"' union all select SPECIALITY_CODE from AM_PRACT_SPECIALITIES where FACILITY_ID='"+facilityid+"' and PRACTITIONER_ID='"+pract+"' )";

		sql = sql + " and upper(a.SPECIALITY_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?) order by 2";

		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retVal = await CommonLookup( title, argArray )
		
		var arr=new Array();			

		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retArray=unescape(retVal);
		    arr=retArray.split(",");
		   	document.forms[0].specialty.value = arr[1];
		   	document.forms[0].specialty_code.value = arr[0];
		}
		else
		{
			document.forms[0].specialty.value = "";
			document.forms[0].specialty_code.value = "";
		} 
}
function visitTypeChange(obj)
{
	//
}

