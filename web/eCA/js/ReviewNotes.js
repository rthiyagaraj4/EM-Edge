/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
29/06/2012	  IN030468		Dinesh T	 BRUHIMS CRF.
16/07/2012	  IN033857		Dinesh T	 BRUHIMS CRF.
--------------------------------------------------------------------------------------------------------------------
*/
function searchForDetails()
{
	var notetypecode ="";  //parent.ReviewNotesCriteriaFrame.document.forms[0].note_type.value;
	var requestedbyid = parent.ReviewNotesCriteriaFrame.document.forms[0].requested_by.value;
	var view = parent.ReviewNotesCriteriaFrame.document.forms[0].view.value;
	var requested_to = parent.ReviewNotesCriteriaFrame.document.forms[0].requested_to.value;
	var fromDate ="";
	var ToDate ="";
	var patientId ="";
		fromDate =parent.ReviewNotesCriteriaFrame.document.forms[0].fromDt.value;
		ToDate = parent.ReviewNotesCriteriaFrame.document.forms[0].toDt.value;
		patientId = parent.ReviewNotesCriteriaFrame.document.forms[0].patientId.value;
	var	to = parent.ReviewNotesCriteriaFrame.document.forms[0].toDt ;
	var	fromDt = parent.ReviewNotesCriteriaFrame.document.forms[0].fromDt ;
	var locale = parent.ReviewNotesCriteriaFrame.document.forms[0].locale.value;
	var reqFacility = parent.ReviewNotesCriteriaFrame.document.forms[0].requested_facility.value;//IN030468

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
	/*if(patientId=="") //&&(fromDate==""|| ToDate==""))
	{
		
		if((daysBetween(fromDate,ToDate,'DMY',locale)>31)||(fromDate==""||ToDate==""))
			{
					var msg = getMessage("DATE_RANGE_FOR_NOTES","CA");
					alert(msg);
					to.select();
					to.focus();
					return false;
			}
		
		//alert("please provide patientID or Date range");
		//return true;
	}  */

	document.getElementById("search").disabled = true;
	var params = '?note_type_code='+notetypecode+'&requested_by_id='+requestedbyid+'&view='+view+'&requested_to='+requested_to+'&fromDate='+fromDate+'&ToDate='+ToDate+'&patientId='+patientId+"&reqFacility="+reqFacility;//IN030468
	parent.ReviewNotesDetailsFrame.location.href = '../../eCA/jsp/ReviewNotesDetails.jsp'+params
	parent.ReviewotesTreeFrame.location.href = "../../eCA/jsp/ReviewNotesTree.jsp"+params;
	parent.ReviewNotesToolsFrame.document.getElementById("Review").disabled=false;
}

function clearForm(from)
{
	//parent.ReviewNotesCriteriaFrame.document.forms[0].reset();
	var notetypecode ="";
	var requestedbyid = parent.ReviewNotesCriteriaFrame.document.forms[0].requested_by.value;
	var view = parent.ReviewNotesCriteriaFrame.document.forms[0].view.value;
	var requested_to = parent.ReviewNotesCriteriaFrame.document.forms[0].requested_to.value;

	var params = '?note_type_code='+notetypecode+'&requested_by_id='+requestedbyid+'&view='+view+'&requested_to='+requested_to;
	
	if(from == "T")
	{
		var action_url = getRelativeURL("/eCA/jsp/ReviewNotesDetails.jsp");
		parent.ReviewNotesDetailsFrame.location.href = action_url 
		parent.ReviewNotesDetailsFrame.location.reload();
		//parent.ReviewotesTreeFrame.location.reload();

		var action_url = getRelativeURL("/eCA/jsp/ReviewNotesTree.jsp"+params);
		var action_url_msg = getRelativeURL("/eCommon/jsp/error.jsp");
		parent.ReviewotesTreeFrame.location.href = action_url 
		parent.ReviewotesTreeFrame.location.reload();
		parent.parent.messageFrame.location.href = action_url_msg;
	}
}

function filterNShowDetails(notetypecode,requestedbyid,requested_to,fromDate,ToDate,reqFacility,totalRecords)//IN033857 
{
	//IN033857,starts
	if(totalRecords != 0)
	{
		var patientId = parent.ReviewotesTreeFrame.document.forms[0].patient_id.value;
		var view = parent.ReviewNotesCriteriaFrame.document.forms[0].view.value
		var params = '?note_type_code='+notetypecode+'&requested_by_id='+requestedbyid+'&view='+view+'&requested_to='+requested_to+'&fromDate='+fromDate+'&ToDate='+ToDate+'&patientId='+patientId+"&reqFacility="+reqFacility;
		parent.ReviewNotesDetailsFrame.location.href = '../../eCA/jsp/ReviewNotesDetails.jsp'+params
	}
	else
	{
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	}
	//IN033857,ends
}

function showDetails(val)
{
	val = unescape(val);
	var arr = val.split("~");
	
	/*var p = "facility_id="+arr[3]+"&accession_num="+arr[1]+"&title="+arr[4]
	var retVal = 	new String();
	var dialogHeight= "27" ;
	var dialogWidth	= "80" ;
	var dialogTop	= "120" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = window.showModalDialog("../../eCA/jsp/SignNotesDocumentsView.jsp?"+p,arguments,features);*/
	var action_url		=	'../../eCA/jsp/RecClinicalNotesModal.jsp';
	action_url			+=	"?function_id=REVIEW_NOTES&called_from=SignNotes&accession_num="+arr[1]+"&title="+arr[4]+"&clinician_id="+arr[2]+"&note_type="+arr[5]+"&patient_id="+arr[6]+"&encounter_id="+arr[7]+"&visit_id="+arr[8]+"&episode_type="+arr[8]+"&patient_class="+arr[9];//IN030468
	var child_window	=	window.open(action_url,null,"height=570,width=1010,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no");
	child_window.focus();
}

function record()
{
	
	var n = parent.ReviewNotesDetailsFrame.document.forms[0].noofrec.value;
	var requested_to = parent.ReviewNotesDetailsFrame.document.forms[0].requested_to.value;
	//alert("requested_to in js"+requested_to);
	
	var dat = "";

	/*for(var i=0; i<n*2; i+=2){
		if(parent.ReviewNotesDetailsFrame.document.forms[0].elements(i).checked ==true){
			var temp = parent.ReviewNotesDetailsFrame.document.forms[0].elements(i).value;
			dat+=temp+"#";
		}
	}*/
		var  k=0;
	for(var i=0; i<n; i++){
		var object = eval("parent.ReviewNotesDetailsFrame.document.forms[0].chk_"+i);
		
		if(object.checked ==true){
			
			
			var temp = object.value;
			dat+=temp+"#";
			
		}
	}

	//alert('dat : '+dat);
	if(dat == '')
			alert(getMessage("MIN_ONE_ITEM_SEL_REQ",'CA'));
	else
	{	
		parent.ReviewNotesDetailsFrame.document.forms[0].final_values.value = dat;
		parent.ReviewNotesDetailsFrame.document.forms[0].submit();
		
	}
}

function onSuccess()
{
	clearForm('T');
}
async function callSendBackWindow(obj,index,check)		
{

	
	//var k=parent.ReviewNotesDetailsFrame.document.forms[0].noofrec.value;
	//if(obj.checked){
		
		//k++;
		//parent.ReviewNotesDetailsFrame.document.forms[0].noofrec.value=k;}

	//if(!(obj.checked)){
		
	//	k--;
		//parent.ReviewNotesDetailsFrame.document.forms[0].noofrec.value=k;}
	if((obj.checked && check=="Request")||(obj.checked && check=="Forwarded to Specialty"))
	{	

		var bool = confirm(getMessage("RVT_BAK_WITH_CMTS",'CA'));
		
		if(bool)
		{
			var dialogHeight= "25vh" ;
			var dialogWidth	= "31vw" ;
			var dialogTop	= "180" ;
			var status = "no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=no; status:no";
			//var comments=parent.ReviewNotesDetailsFrame.document.forms[0].remarks.value;		
			//retVal = window.showModalDialog('../../eCA/jsp/ReviewNotesResponseRemarkWindow.jsp?resultStr='+comments,arguments,features);

		    retVal = await window.showModalDialog("../../eCA/jsp/ReviewNotesResponseRemarkWindow.jsp",arguments,features);
			//alert("here"+retVal);
			if(retVal != null && retVal != '' && retVal != undefined)
			{
				var object = eval("parent.ReviewNotesDetailsFrame.document.forms[0].chk_"+index);
				var temp = object.value;
				parent.ReviewNotesDetailsFrame.document.forms[0].final_values.value = temp+"#";
                var requested_to = parent.ReviewNotesDetailsFrame.document.forms[0].requested_to.value;
				parent.ReviewNotesDetailsFrame.document.forms[0].remarks.value = retVal;
				parent.ReviewNotesDetailsFrame.document.forms[0].action = "../../servlet/eCA.ReviewNotesResponseServlet";
				parent.ReviewNotesDetailsFrame.document.forms[0].submit();

			}
			
		}
	}
}
function sendRemarks1()
{
	if(document.forms[0].remarks.value =="")
	{
		var msg = getMessage("REMARKS_CANNOT_BLANK",'CA');
		alert(msg);
	}
	else
	{
		window.returnValue = document.forms[0].remarks.value;
		window.close();
	}
}
function sendRemarks()
{
		var obj=document.forms[0].remarks;
		var obj1 = trimString(obj.value);
		if(obj1==null || obj1=="" || obj1=="null")
		{
					alert(getMessage('REMARKS_CANNOT_BLANK','CA'));
					//window.returnValue=''; 
					 let dialogBody = parent.document.getElementById('dialog-body');
					 dialogBody.contentWindow.returnValue = '';
		}else{
					//window.returnValue=trimString(document.forms[0].remarks.value);
					 let dialogBody = parent.document.getElementById('dialog-body');
					 dialogBody.contentWindow.returnValue = trimString(document.forms[0].remarks.value);
				   if(returnValue.length > 200)
			       {
					var msg = getMessage('RMRKS_MAX_LENGTH_CNT','CA');
					msg = msg.replace('$','200');
					alert(msg);	
					//window.returnValue='';
					 let dialogBody = parent.document.getElementById('dialog-body');
					 dialogBody.contentWindow.returnValue = '';
				 }else
				 {
					//window.returnValue=trimString(document.forms[0].remarks.value);
                    //window.close();
					 let dialogBody = parent.document.getElementById('dialog-body');
					 dialogBody.contentWindow.returnValue = trimString(document.forms[0].remarks.value);
					     
					 const dialogTag = parent.document.getElementById('dialog_tag');dialogTag.close();
                    
	             }
	         }
}
function ismaxlength(obj)
{

	   var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
		if (obj.getAttribute && parseInt(obj.value.length)>mlength)
			{
				var msg = getMessage("REMARKS_CANNOT_EXCEED",'COMMON');
				msg = msg.replace("$","Remarks");
				msg = msg.replace("#",mlength);					
				alert(msg);
				obj.focus();
				//obj.value=obj.value.substring(0,mlength);
			}
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

	

	
	//var sql="select distinct a.request_by_id code ,AM_GET_DESC.AM_PRACTITIONER(a.request_by_id,'"+locale+"','1') description from ca_encntr_note_audit_log a where A.ACTION_STATUS ='RQ' AND a.action_type in ('RV','RS','FS') and a.action_by_id = '"+pract_id+"' and upper(request_by_id) like upper(?) and upper(AM_GET_DESC.AM_PRACTITIONER(a.request_by_id,'"+locale+"','1')) like upper(?)  ";
	var sql="select practitioner_id code ,practitioner_name description from am_practitioner_lang_vw where language_id='"+locale+"' and practitioner_id in (select distinct a.request_by_id code from ca_encntr_note_audit_log a where A.ACTION_STATUS ='RQ' AND a.action_type in ('RV','RS','FS') and a.action_by_id = '"+pract_id+"' ) and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?)  ";

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

			document.forms[0].requested_by.value = arr[0];
			document.forms[0].requestedBy_Desc.value = arr[1];
				//document.forms[0].performed_by_code.value = retArray[0];
								
		}
		else
		{
			document.forms[0].requested_by.value = "";
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
		document.forms[0].requested_by.value = "";
	}
}

function ftDateCheck(from,to,currDate,format,locale)
	{
		
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
						
					/*	if(document.forms[0].patientId.value=="")
						{
							if(daysBetween(from.value,to.value,format,locale)>7)
							{
								var msg = top.header.getMessage("DATE_RANGE_FOR_NOTES","CA");
								alert(msg);
								to.select();
								to.focus();
								return false;
							}
						} */
						return true;
					}
					else
					{
						//alert(top.header.getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
						alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
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
			var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='frmDuplicateId' id='frmDuplicateId' method='post' action='../../eCA/jsp/CAValidatePatientId.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+escape(obj.value)+"'><input type='hidden' name='fromFunction' id='fromFunction' value='PatListByLocation'></form></body></html>";
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
function openDocWindow(accession_num,note_type)
{
	
	//window.open("../../eCA/jsp/RecClinicalNotesFileUploadShowDocMain.jsp?accession_num="+accession_num+"&note_type="+note_type,'Document',"height=570,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");
	
	//window.open("../../eCA/jsp/RecClinicalNotesMultiFileList.jsp?accession_num="+accession_num+"&note_type="+note_type,'Document',"height=570,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");
	
	window.open("../../eCA/jsp/RecClinicalNotesMultiFileListMain.jsp?accession_num="+accession_num+"&note_type="+note_type,'Document',"height=570,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes,addressbar=no");
}

function reviewNotesClear()
{
	parent.ReviewNotesCriteriaFrame.ReviewNotesCriteria_form.reset();
	parent.ReviewotesTreeFrame.location.href="../../eCA/jsp/ReviewNotesTree.jsp";//IN033857
	parent.ReviewNotesDetailsFrame.location.href="../../eCommon/html/blank.html";
	parent.ReviewNotesToolsFrame.document.getElementById("Review").disabled=true;
}


function reviewNotescheckFromToDate(fromOrTo,obj,fromToDate,currDate,fmt,locale)
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

