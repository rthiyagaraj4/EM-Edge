/*
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name	Description
--------------------------------------------------------------------------------------------------------
20/08/2015	IN056951		Vijayakumar K	21/08/2015	Dinesh T	GHL-SCF-959 [IN:056951]
15/09/2015  IN057492		Vijayakumar K	16/09/2015	Dinesh T	PMG2015-CRF-AAKH-CA-0001
--------------------------------------------------------------------------------------------------------
*/
function searchForDetails()
{
	//top.content.workAreaFrame.SignNotesDetailsFrame.location.href='../../eCommon/html/blank.html';
	//top.content.workAreaFrame.SignNotesTreeFrame.location.href = "../../eCommon/html/blank.html";
	var notetypecode	=	""; 
	var requestedbyid	=	parent.SignNotesCriteriaFrame.document.forms[0].requested_by.value;
	var fromDate ="";
	var ToDate ="";
	var patientId ="";
	fromDate =parent.SignNotesCriteriaFrame.document.forms[0].fromDt.value;
	ToDate = parent.SignNotesCriteriaFrame.document.forms[0].toDt.value;
	patientId = parent.SignNotesCriteriaFrame.document.forms[0].patientId.value;
	var	to = parent.SignNotesCriteriaFrame.document.forms[0].toDt ;
	var	fromDt = parent.SignNotesCriteriaFrame.document.forms[0].fromDt ;
	var locale = parent.SignNotesCriteriaFrame.document.forms[0].locale.value;
	var called_func = parent.SignNotesCriteriaFrame.document.forms[0].p_called_func.value;  //IN057492
	
	if(fromDate=='')
	{
	var msg =getMessage("CAN_NOT_BE_BLANK","common");
	msg = msg.replace("$","From Date");	
	alert(msg);
	fromDt.focus();
	return;
	}
	if(ToDate=='')
	{
	var msg =getMessage("CAN_NOT_BE_BLANK","common");
	msg = msg.replace("$","To Date");
	alert(msg);
	to.focus();
	return;
	}
	var fdate = minusDate(ToDate,"DMY",locale,1,"M");
	if(patientId=="" && daysBetween(fromDate,fdate,"DMY",locale)>0)
	{
		var msg = getMessage("DATE_RANGE_FOR_NOTES","CA");
		alert(msg);
		fromDt.focus();
		fromDt.select();
		return;
	}

	parent.SignNotesCriteriaFrame.document.getElementById("search").disabled=true;
	//--[IN057492]/Start---
	//var params = '?note_type_code='+notetypecode+'&requested_by_id='+requestedbyid+'&fromDate='+fromDate+'&ToDate='+ToDate+'&patientId='+patientId;
	var params = '?note_type_code='+notetypecode+'&requested_by_id='+requestedbyid+'&fromDate='+fromDate+'&ToDate='+ToDate+'&patientId='+patientId+'&p_called_func='+called_func;
	//--[IN057492]/End---
	parent.SignNotesDetailsFrame.location.href = '../../eCA/jsp/SignNotesDetails.jsp'+params
	parent.SignNotesTreeFrame.location.href = "../../eCA/jsp/SignNotesTree.jsp"+params;
	parent.SignNotesToolsFrame.document.getElementById("sign").disabled=false;
}

function clearForm(from)
{
	var noteType   = parent.SignNotesCriteriaFrame.document.getElementById("note_type_code").value;
	var requestedbyid	=	parent.SignNotesCriteriaFrame.document.forms[0].requested_by.value;
	//Below Lines are commented by Archana Dhal related to IN18229 
	//top.content.workAreaFrame.SignNotesCriteriaFrame.document.forms[0].reset();
	//alert(""+);
	/*var fromDate ="";
	var ToDate ="";
	fromDate =parent.SignNotesCriteriaFrame.document.forms[0].fromDt.value;
	ToDate = parent.SignNotesCriteriaFrame.document.forms[0].toDt.value;
	if(from == "T")
	{
		var action_url = getRelativeURL("/eCA/jsp/SignNotesDetails.jsp?note_type_code="+noteType+'&fromDate='+fromDate+'&ToDate='+ToDate+'&requestedbyid='+requestedbyid);
		parent.SignNotesDetailsFrame.location.href = action_url 
		parent.SignNotesTreeFrame.location.reload();
	}*/
	//Below Lines are added by Archana Dhal related to IN18229.
	var params = '?noteType='+noteType+'&requested_by_id='+requestedbyid;
	
	if(from == "T")
	{
		var action_url = getRelativeURL("/eCA/jsp/SignNotesDetails.jsp");
		parent.SignNotesDetailsFrame.location.href = action_url 
		parent.SignNotesDetailsFrame.location.reload();
		

		var action_url = getRelativeURL("/eCA/jsp/SignNotesTree.jsp"+params);
		var action_url_msg = getRelativeURL("/eCommon/jsp/error.jsp");
		parent.SignNotesTreeFrame.location.href = action_url 
		parent.SignNotesTreeFrame.location.reload();
		parent.parent.messageFrame.location.href = action_url_msg;
	}
}

function filterNShowDetails(obj,notetypecode,fromDate,ToDate,requestedbyid)
{
	
	var patientId = parent.SignNotesTreeFrame.document.forms[0].patient_id.value;
	var optionID = parent.SignNotesTreeFrame.document.forms[0].optionID.value;
	//--[IN057492]/Start---
	var called_func = parent.SignNotesCriteriaFrame.document.forms[0].p_called_func.value;
	//var params = '?note_type_code='+notetypecode+'&fromDate='+fromDate+'&ToDate='+ToDate+'&requested_by_id='+requestedbyid+'&patientId='+patientId+'&option_id='+optionID;
	var params = '?note_type_code='+notetypecode+'&fromDate='+fromDate+'&ToDate='+ToDate+'&requested_by_id='+requestedbyid+'&patientId='+patientId+'&option_id='+optionID+'&p_called_func='+called_func;
	//--[IN057492]/End---
	parent.SignNotesCriteriaFrame.document.getElementById("note_type_code").value = notetypecode;
	parent.SignNotesDetailsFrame.location.href = '../../eCA/jsp/SignNotesDetails.jsp'+params
}

function showDetails(val)
{	
	val = unescape(val);
	var arr = val.split("~");
	
	var action_url		=	'../../eCA/jsp/RecClinicalNotesModal.jsp';
	action_url			+=	"?function_id=SIGN_NOTES&called_from=SignNotes&facility_id="+arr[3]+"&accession_num="+arr[1]+"&title="+arr[4]+"&clinician_id="+arr[2]+"&note_type="+arr[5]+"&patient_id="+arr[6]+"&encounter_id="+arr[7]+"&visit_id="+arr[8]+"&episode_type="+arr[8]+"&patient_class="+arr[9];
	var child_window	=	window.open(action_url,null,"height=600,width=800,top=67.5,left=110,status=NO,toolbar=no,menubar=no,location=no");
	child_window.focus(); //450,width=790
}

function chkMandatory()
{
	var n = parent.SignNotesDetailsFrame.document.forms[0].noofrec.value;
	//for(var i=0; i<n*2; i+=2){
		
		for(var i=0; i<n*2; i++){
		if(parent.SignNotesDetailsFrame.document.forms[0].elements[i].checked == true)
		{			
			//IN056951 starts
			//if(parent.SignNotesDetailsFrame.document.forms[0].elements(i+1).type != 'hidden' && parent.SignNotesDetailsFrame.document.forms[0].elements(i+1).type != 'text')
			if(parent.SignNotesDetailsFrame.document.forms[0].elements[i+1].type != 'hidden')
			//IN056951 ends
			{				//if(parent.SignNotesDetailsFrame.document.forms[0].elements(i+1).options[parent.SignNotesDetailsFrame.document.forms[0].elements(i+1).selectedIndex].value == '')
				if(parent.SignNotesDetailsFrame.document.forms[0].elements[i+1].value == '')
				{
					var msg = getMessage("FORWARD_NOT_NULL",'CA');
					top.content.messageFrame.document.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
					return false;
					break;
				}
			}
		}
	}
	return true;
}

function record()
{
	//var optionID = parent.SignNotesDetailsFrame.document.forms[0].optionID.value;
	
	var n =parent.SignNotesDetailsFrame.document.forms[0].noofrec.value;
	var dat = "";

	if(chkMandatory())
	{
		
		for(var i=0; i<n*2; i++){
			if(eval('parent.SignNotesDetailsFrame.document.forms[0].chk_'+i+' != undefined')){
				if(eval('parent.SignNotesDetailsFrame.document.forms[0].chk_'+i+'.checked == true')){
					//var temp = top.content.workAreaFrame..SignNotesDetailsFrame.document.forms[0].elements(i).value;
					var temp = eval('parent.SignNotesDetailsFrame.document.forms[0].chk_'+i+'.value');
					//if(top.content.workAreaFrame..SignNotesDetailsFrame.document.forms[0].elements(i+1).type != 'hidden')
						//IN056951 starts
						//if(eval('parent.SignNotesDetailsFrame.document.forms[0].forward_to_'+i+'.type != "hidden"'))
						if(eval('parent.SignNotesDetailsFrame.document.forms[0].forward_to_'+i+'.type == "hidden"') && eval('parent.SignNotesDetailsFrame.document.forms[0].forward_to_'+i+'.value') != '')
						//IN056951 ends
						{
							
							if(eval('parent.SignNotesDetailsFrame.document.forms[0].forward_to_'+i+' != undefined'))
							{
								//IN056951 starts
								//temp += "~"+eval('parent.SignNotesDetailsFrame.document.forms[0].forward_to_'+i+'.options[parent.SignNotesDetailsFrame.document.forms[0].forward_to_'+i+'.selectedIndex].value');
								temp += "~"+eval('parent.SignNotesDetailsFrame.document.forms[0].forward_to_'+i+'.value');
								//IN056951 ends
								
							}
						}
						else{
						temp += "~"+'Z';
					}
					dat+=temp+"#";
				}
			}
		}

		//alert('dat  :'+dat);

		if(dat == '')
		{
			var msg = getMessage("MIN_ONE_ITEM_SEL_REQ",'CA');
			alert(msg);
		}
		else
		{
			var oledb_con_string = document.forms[0].oledb_con_string.value;
			if(document.forms[0].figer_print_auth_yn.value=="Y")
			{
				if(!verifyTheFinger(oledb_con_string))
				{					
					return false;
				}
			}	

			parent.SignNotesDetailsFrame.document.forms[0].final_values.value = dat;
			parent.SignNotesDetailsFrame.document.forms[0].submit();
		}
	}
}

function onSuccess()
{
	clearForm('T');
}

function getRelativeURL(targetURL)
{
	var url= top.content.messageFrame.location.href;
	var action_url = targetURL;
	if(url.indexOf("/servlet")!=-1)
	{
		action_url = ".."+targetURL;
	}
	else
	{
		action_url = "../.."+targetURL;
	}
	return action_url;
}
//fingure printing stuff
function verifyTheFinger(obj)
{
	var result;
		
	s1 = new String(document.forms[0].user_id.value);
	try
	{
	document.WebFp.DatabaseType=0
	document.WebFp.ConnectionType=1
	document.WebFp.ConnectionString = obj;
	document.WebFp.SecurityLevel=5
	document.WebFp.UserTableName="SM_APPL_USER"
	document.WebFp.FingerTableName="SM_APPL_USER_BIO"
	document.WebFp.AccountCodeField="APPL_USER_ID"
	document.WebFp.AccountCodeFieldType = 1	
	document.WebFp.AccountCode = document.forms[0].user_id.value; 
	//alert("Acc "+document.WebFp.AccountCode ) 
	result = document.WebFp.Verify();
	//result = document.WebFp.Enroll();
	//alert(result);
	if(result)
	{
		var msg = getMessage("VERIFY_OK",'CA');
		alert(msg);
		//alert("Enrollment Successful");
		//location.href = "regist.htm";
		return(true);				
	}
	else
	{
		alert(document.WebFp.ErrorString);
		//location.href = "regist.htm";
		return(false);		
	}
	}
	catch(e)
	{
	alert(e.message);
	return(false);
	}
}

async function showPractWindow()

{
	var target			= document.forms[0].requestedBy_Desc;
	//var stdval          = document.forms[0].locVal.value;
	//var val				= document.forms[0].facilityid.value;
	var pract_id		= document.forms[0].ca_practitioner_id.value;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.RequestedBy.label","COMMON");
	var locale			= document.forms[0].locale.value;
	

	//var sql="Select locn_code code,decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') ) description  from ca_pract_by_locn_view where  upper(locn_code) like upper(?) AND UPPER(decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') )) like upper(?) AND practitioner_id= '"+pract_id+"' and locn_type in ('C','W') and facility_id = '"+val+"' and PATIENT_CLASS = '"+loc_type+"' order by 2";
	var sql="select distinct a.request_by_id code ,AM_GET_DESC.AM_PRACTITIONER(a.request_by_id,'"+locale+"','1') description from ca_encntr_note_audit_log a where A.ACTION_STATUS ='RQ' AND a.action_type = 'SN' and a.action_by_id = '"+pract_id+"' and upper(request_by_id) like upper(?) and upper(AM_GET_DESC.AM_PRACTITIONER(a.request_by_id,'"+locale+"','1')) like upper(?)  ";

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
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}

			document.forms[0].requested_by.value = arr[0];
			document.forms[0].requestedBy_Desc.value = arr[1];
				//document.forms[0].performed_by_code.value = retArray[0];
								
		}
		else
		{
			document.forms[0].requested_by.value = "ALL";
			document.forms[0].requestedBy_Desc.value = "";
		}

}

async function getPractCode(obj)
{
	if (obj.value!= "")
	{
		await showPractWindow();
	}
	else
	{
		document.forms[0].requested_by.value = "ALL";
	}
}


function checkDuplicate(obj)	
	{
		ChangeUpperCase(obj);
		if(obj.value != "")
		{
			var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='frmDuplicateId' id='frmDuplicateId' method='post' action='../../eCA/jsp/CAValidatePatientId.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+escape(obj.value)+"'><input type='hidden' name='fromFunction' id='fromFunction' value='PatListByLocation'></form></body></html>";
			top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			top.content.messageFrame.document.frmDuplicateId.submit();
			/*if(document.forms[0].past.checked)
			{
				document.forms[0].from_date11.readOnly = false;
				document.forms[0].all.cal_pv1.disabled=false ;
								}
			}
			else
			{
				document.forms[0].from_date11.value = document.forms[0].from_date1.value ;
				document.forms[0].from_date11.readOnly = true;
				document.forms[0].all.cal_pv1.disabled=true;
				
			} */
		}
	}

async function callPatientSearch()
{
	var pat_id =  await PatientSearch();
	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}


function ftDateCheck(from,to,currDate,format,locale)
	{
		
		if(from.value=="" && to.value=="")
		{
			alert("Period can't be empty");
			return;
		}
		if(!(from.value == "" ))
		{
		 if(!isBeforeNow(from.value,format,locale))
			{
			
				//alert(top.header.getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				//from.select();
				from.value="";
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
						
						/*if(document.forms[0].patientId.value=="")
						{
							if(daysBetween(from.value,to.value,format,locale)>31)
							{
								var msg = top.header.getMessage("DATE_RANGE_FOR_NOTES","CA");
								alert(msg);
								to.select();
								to.focus();
							}
						}*/
						return true;
					}
					else
					{
						//alert(top.header.getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
						alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
						//to.select();
						to.value="";
						to.focus();
						return false;
					}
				}
				else
				{
					//alert(top.header.getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
					//to.select();
					to.value="";
					to.focus();
					return false;
				}
				}
			}
			if(!to.value=="")
			{
			 			 
			}
				
		}
		else
	{
			if((!to.value==""))
			{
				if(!isBeforeNow(to.value, format, locale))
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					//to.select();
					to.value="";
					to.focus();
					return false;
				}
			}
	}
}

function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

async function forwardTo(obj,note_type)
{
	
	
//	String clincsql = " Select practitioner_id clinician_id, practitioner_name clinician_short_name from am_practitioner_lang_VW where language_id = ? and practitioner_id in ( select a.func_role_id from sm_appl_user a, ca_note_type_for_resp b, sm_resp_for_user c where b.note_type = ? and b.privilege_type in ('3','4') and a.appl_user_id = c.appl_user_id and c.resp_id = b.resp_id )  order by 2 ";
	var target			= eval("document.forms[0].forward_to_desc_"+obj);
	
	//var stdval          = document.forms[0].locVal.value;
	//var val				= document.forms[0].facilityid.value;
	//var note_type		= "";//document.forms[0].ca_practitioner_id.value;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.RequestedBy.label","COMMON");//forward
	var locale			= document.forms[0].locale.value;
	

	//var sql="Select locn_code code,decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') ) description  from ca_pract_by_locn_view where  upper(locn_code) like upper(?) AND UPPER(decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') )) like upper(?) AND practitioner_id= '"+pract_id+"' and locn_type in ('C','W') and facility_id = '"+val+"' and PATIENT_CLASS = '"+loc_type+"' order by 2";
	//var sql="select distinct a.request_by_id code ,AM_GET_DESC.AM_PRACTITIONER(a.request_by_id,'"+locale+"','1') description from ca_encntr_note_audit_log a where A.ACTION_STATUS ='RQ' AND a.action_type = 'SN' and a.action_by_id = '"+pract_id+"' and upper(request_by_id) like upper(?) and upper(AM_GET_DESC.AM_PRACTITIONER(a.request_by_id,'"+locale+"','1')) like upper(?)  ";
	var sql="Select practitioner_id code, practitioner_name description from am_practitioner_lang_VW where language_id ='"+locale+"' and practitioner_id in ( select a.func_role_id from sm_appl_user a, ca_note_type_for_resp b, sm_resp_for_user c where b.note_type = '"+note_type+"' and b.privilege_type in ('3','4') and a.appl_user_id = c.appl_user_id and c.resp_id = b.resp_id ) and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?)  order by 2 ";

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
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}

			eval("document.forms[0].forward_to_"+obj).value = arr[0];
			eval("document.forms[0].forward_to_desc_"+obj).value = arr[1];
				//document.forms[0].performed_by_code.value = retArray[0];
								
		}
		else
		{
			eval("document.forms[0].forward_to_"+obj).value = "ALL";
			eval("document.forms[0].forward_to_desc_"+obj).value = "";
		}


}

function getForwardTo(obj,i,note_type)

{
  
  if(!obj.value=="")
	{
		forwardTo(i,note_type);
	}
}

function openDocWindow(accession_num,note_type)
{
	
	//window.open("../../eCA/jsp/RecClinicalNotesFileUploadShowDocMain.jsp?accession_num="+accession_num+"&note_type="+note_type,'Document',"height=570,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");
	
	//window.open("../../eCA/jsp/RecClinicalNotesMultiFileList.jsp?accession_num="+accession_num+"&note_type="+note_type,'Document',"height=570,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");
	
	window.open("../../eCA/jsp/RecClinicalNotesMultiFileListMain.jsp?accession_num="+accession_num+"&note_type="+note_type,'Document',"height=570,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes,addressbar=no");
}

function SignNotesClear()
{
	parent.SignNotesCriteriaFrame.SignNotesCriteria_form.reset();
	parent.SignNotesTreeFrame.location.href="../../eCA/jsp/ReviewNotesTree.jsp";
	parent.SignNotesDetailsFrame.location.href="../../eCommon/html/blank.html";
	parent.SignNotesToolsFrame.document.getElementById("sign").disabled=true;
}

//function added by DINESH T on 2010-05-12
function checkFromToDate(fromOrTo,obj,fromToDate,currDate,fmt,locale)
{	
	if(obj.value!='')
	{
	if(fromOrTo=='F')
	{
		//if(obj.value!='')
		//{
			if(CheckDate(obj))
			{
				ftDateCheck(obj,fromToDate,currDate,fmt,locale);
			}
		//}
	}
	else if(fromOrTo=='T')
	{
		if(CheckDate(obj))
		{
			ftDateCheck(fromToDate,obj,currDate,fmt,locale);
		}	
	
	}
	}
}	 

