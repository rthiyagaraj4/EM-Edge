/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name				Rev.Date   		Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
09/08/2016		IN064836		Krishna Gowtham		09/08/2017		Ramesh G	ML-MMOH-CRF-0566.1
24/10/2017		IN065452		Krishna Gowtham		25/10/2017		Ramesh G	ML-MMOH-CRF-0566.2
-------------------------------------------------------------------------------------------------------------------------------
*/
function locnTypeChange(obj)
{ 
	document.forms[0].locationDesc.value = "";
	document.forms[0].locationCode.value = "*ALL";


	document.getElementById("locLed").innerText=getLabel("Common.Location.label","COMMON");
	document.getElementById("locVal").style.visibility='visible';
	document.getElementById("src_butn").style.visibility='visible';
	document.forms[0].locationDesc.disabled = false;
	document.forms[0].locationDesc.value="";

	if((obj.value =='OP') || (obj.value =='IP'))
	{
		//alert("obj"+obj.value);
			document.getElementById("groupByEpisode").checked = true;
			document.getElementById("groupByEpisode").disabled = true;
			document.getElementById("groupByEpisode").value='Y';
	}
	else if(obj.value=='Z')
	{
			document.getElementById("locLed").innerText='';
			document.getElementById("locVal").style.visibility='hidden';
			document.getElementById("src_butn").style.visibility='hidden';
			document.forms[0].locationDesc.disabled = true;
		
		if(document.getElementById("groupByLocn").disabled)
			document.getElementById("groupByLocn").disabled = false;
		if(document.getElementById("groupByEpisode").disabled)
			document.getElementById("groupByEpisode").disabled = false;
	}
}

function searchClick()
{
	//IN065452 start
	if(document.forms[0].pendingRef[0] != null || document.forms[0].pendingRef[0] != undefined)
	{
		if(document.forms[0].pendingRef[0].checked)
		{
			document.forms[0].pendingRef.value = 'Y';
		}
		else if(document.forms[0].pendingRef[1].checked)
		{
			document.forms[0].pendingRef.value = 'R';
		}
	}
	//IN065452 ends
	var locationType=document.forms[0].locationType.value;
	var locationCode=document.forms[0].locationCode.value;
	var groupByLocn=document.forms[0].groupByLocn.value;
	var groupByEpisode=document.forms[0].groupByEpisode.value;
	var fromDate = document.forms[0].from_date.value;
	var toDate = document.forms[0].to_date.value;
	var mode = document.forms[0].mode.value;
	var patientId = document.forms[0].patientId.value;
	//var unAssigned = document.forms[0].unAssigned.value;
	var unAssigned = document.forms[0].IncCriteria.value;
	var pendingRef = document.forms[0].pendingRef.value;
	//IN064836 start
	/*var closed = document.forms[0].closed.value;
	var open = document.forms[0].open.value;*/
	var refStatus 		= document.forms[0].RefStatus.value;
	var refRegSiteYN	= document.forms[0].refRegSiteYN.value;
	//IN064836 ends
	var locale = document.forms[0].locale.value;
	var function_id = document.forms[0].function_id.value;
	var relnreqyn = document.forms[0].establish_reln_req_yn.value;
	
	var	fields = new Array(document.forms[0].from_date,document.forms[0].to_date);
	var	names = new Array(getLabel("Common.fromdate.label","COMMON"),getLabel("Common.todate.label","COMMON"));
	
	if(checkFieldsofMst( fields, names, top.content.messageFrame))
	{
		if(patientId == "" || patientId == null)
		{
			if(!(fromDate == null || fromDate == "" ) && !(toDate == null || toDate == "" ))
			{
				var date1 = minusDate(toDate,"DMY",locale,8,"d");
				if(isAfter(date1, fromDate, "DMY", locale))
				{
					alert(getMessage("DATE_RANGE_OR_PATIENTID","CA"));
					document.forms[0].to_date.select();
					return false;
				}
			}
		}
		//IN064836 start
		//var passurl = '../jsp/ReferralPatListResultMain.jsp?locationType='+locationType+'&locationCode='+locationCode+'&fromDate='+fromDate+'&toDate='+toDate+'&groupByLocn='+groupByLocn+'&groupByEpisode='+groupByEpisode+'&mode='+mode +'&patientId='+patientId+'&unAssigned=' +unAssigned+'&pendingRef='+pendingRef+ '&closed='+ closed + '&open='+open+'&function_id='+function_id+'&reln_req_yn='+relnreqyn;
		var passurl = '../jsp/ReferralPatListResultMain.jsp?locationType='+locationType+'&locationCode='+locationCode+'&fromDate='+fromDate+'&toDate='+toDate+'&groupByLocn='+groupByLocn+'&groupByEpisode='+groupByEpisode+'&mode='+mode +'&patientId='+patientId+'&unAssigned=' +unAssigned+'&pendingRef='+pendingRef+ '&refStatus='+ refStatus+ '&refRegSiteYN='+ refRegSiteYN +'&function_id='+function_id+'&reln_req_yn='+relnreqyn;
		//IN064836 ends
		//alert("passurl"+passurl);

		top.content.workAreaFrame.PatResultFr.location.href = passurl ;
	}
	else
		document.forms[0].search.disabled = false;
}	

function clearClick()
{	
	top.content.workAreaFrame.PatResultFr.location.href="../../eCommon/html/blank.html";
	document.location.reload();	
}

function doDateCheckLoc(fromDate,toDate,currDate,format,locale,fromFld)
{
	if(CheckDate(fromDate) && CheckDate(toDate))
	{
		if (!(fromDate.value == null || fromDate.value == "" ))
		{
			var patientId = document.forms[0].patientId.value;
				
			if(isBeforeNow(fromDate.value, format, locale))
			{
				if (!(toDate.value == null || toDate.value == "" ))
				{
					if(isBeforeNow(toDate.value, format, locale))
					{
						if(!isAfter(toDate.value, fromDate.value, format, locale))
						{
							alert(top.header.getMessage("TO_DT_GR_EQ_FM_DT","CA"));
							if(patientId==""|| patientId==null)
							{
								fromDate.focus();
								fromDate.value="";
								return false;
							}
							else
							{
								toDate.focus();
								toDate.value = "";
								return false;
							}

							
						}
				// add by kishore kumar N on 20/03/2009 for self consult(defaluting to 7 days)

						else
						{
							var dt = plusDate(fromDate.value, format, locale, 7, 'd');
							//alert(dt+"  "+isBetween(fromDate.value, dt, getCurrentDate("DMY",locale), "DMY", locale ));

							if(!isBetween(fromDate.value, dt, getCurrentDate("DMY",locale), "DMY", locale ) && fromFld.name == 'from_date' || (dt == getCurrentDate("DMY",locale)))
							{
								toDate.value = dt;
							}
						}
				// ends here.
					}
					else
					{

						alert(top.header.getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
						toDate.focus();
						toDate.value = getCurrentDate("DMY",locale);
						return false;
					}
				}
			}
			else
			{
				alert(top.header.getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
				fromDate.focus();
				fromDate.value = getCurrentDate("DMY",locale);
				return false;
			}
		}
	}
	else{
		return false;
	}
 }

function checkboxChk(obj)
{ 
	if(obj.name=="groupByLocn")
	{
		if(document.getElementById("groupByLocn").checked==false ||document.getElementById("groupByLocn").checked==true)
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
			if(document.getElementById("groupByLocn").checked)
			{
				document.getElementById("groupByLocn").checked = false;
				document.getElementById("groupByLocn").value = 'N';
			}
		}
	}
	if(obj.checked ==true) 
		obj.value='Y'
	else 
		obj.value = 'N'
}

function defaultGroupBy()
{
	var chkLocn = document.getElementById("groupByLocn").checked ; 
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

function callWrapper(encounter_id)
{
	var HTMLVal = "<html>";
	HTMLVal += "<form name='wrapperForm' id='wrapperForm' action='../../eCA/jsp/OpenChartWrapper.jsp' method='post'>";
	HTMLVal += "<input type='hidden' name=encounter_id value='" + encounter_id + "'>";			
	HTMLVal += "</form>";			
	HTMLVal += "</html>";
	top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	top.content.messageFrame.document.wrapperForm.submit();
}

function doDateCheck(from,to,obj,obj1)
{
	if(CheckSystemDateLesser(obj,obj1))
	{
		if(!doDateCheckAlert(from,to))
		{
			alert(top.header.getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			obj.select();
			obj.focus();
			return false;
		}
	}
}
			
async function callPatientSearch()
{
	var pat_id =  await PatientSearch();
	if(pat_id != null)	document.getElementById("patientId").value = pat_id;
	document.getElementById("patientId").focus();
}

function checkDuplicate(obj)
{
	ChangeUpperCase(obj);
	if(obj.value != "")
	{
		var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='frmDuplicateId' id='frmDuplicateId' method='post' action='../../eCA/jsp/CAValidatePatientId.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+escape(obj.value)+"'><input type='hidden' name='fromFunction' id='fromFunction' value='ReferralPatientList'></form></body></html>";
		top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		top.content.messageFrame.document.frmDuplicateId.submit();
	}
}

async function getClinicCode()
{
	var target			= document.forms[0].locVal;
	var stdval          = document.forms[0].locVal.value;
	var val				= document.forms[0].facilityid.value;	
	var pract_id		= document.forms[0].ca_practitioner_id.value;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10vh" ;
	var dialogWidth		= "40vw" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.Location.label","COMMON")
	var locale			= document.forms[0].locale.value;
	var loc_type		= document.forms[0].locationType.value;

	var sql="Select locn_code code,decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') ) description  from ca_pract_by_locn_view where  upper(locn_code) like upper(?) AND UPPER(decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') )) like upper(?) AND practitioner_id= '"+pract_id+"' and locn_type in ('C','W') and facility_id = '"+val+"' and PATIENT_CLASS = '"+loc_type+"' order by 2";

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
		
	retArray = await CommonLookup( title, argArray );	

	if(retArray != null && retArray !="")
	{
		var ret1=unescape(retArray);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
	document.forms[0].locationCode.value = arr[0];
	document.forms[0].locationDesc.value = arr[1];
	}
	else
	{
	document.forms[0].locationCode.value = "*ALL";
	document.forms[0].locationDesc.value = "";
	}
}

function getClinicCode1(obj)
{
	if (obj.value!= "")
	{
		getClinicCode();
	}
	else
	{
		document.forms[0].locationCode.value = "*ALL";
		document.forms[0].locationDesc.value = "";
	}

}

function setCheckedOut(obj)
{
	var name = obj.name;
	var obj1 = eval("document.forms[0]."+name)
	if(obj.checked)
	{
		obj1.value = 'Y';		
	}
	else
	{
		obj1.value = 'N';
	}

}
//IN065452 start
function setCheckedRef()
{
	if(document.forms[0].pendingRef[0].checked)
	{
		document.forms[0].pendingRef.value = 'Y';
		if(document.forms[0].self.value == "selected")
		{
			document.forms[0].IncCriteria(0).selected = true;
		}
		else if(document.forms[0].speciality.value == "selected")
		{
			document.forms[0].IncCriteria(1).selected = true;
		}
		else if(document.forms[0].both.value == "selected")
		{
			document.forms[0].IncCriteria(2).selected = true;
		}
		document.forms[0].IncCriteria.disabled = false;
	}
	else if(document.forms[0].pendingRef[1].checked)
	{
		document.forms[0].pendingRef.value = 'R';
		document.forms[0].IncCriteria(0).selected = true;
		document.forms[0].IncCriteria.disabled = true;
	}
}
//IN065452 end

