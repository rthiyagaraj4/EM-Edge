function callPatientSearch()
{
	var pat_id =  PatientSearch();
	if(pat_id != null)
		document.getElementById("patientId").value = pat_id;
}

function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

function signRepDetailPage(reportId,moduleId,clearMsg)
{
	var fromDate = document.forms[0].fromDate.value;
	var toDate = document.forms[0].toDate.value;
	var patientId = document.forms[0].patient_id.value;
	if (clearMsg == "clearMsg")
	{
		top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
	}	
	parent.signRepCriteriaFrame.document.signRepCriteriaForm.report_id.value = reportId;
	parent.signRepDetailsFrame.location.href = '../../eCA/jsp/VerifySignReportsDetails.jsp?reportId='+reportId+'&moduleId='+moduleId+'&toDate='+toDate+'&fromDate='+fromDate+'&patient_id='+patientId;
}

async function showRepText(requestSrlNo)
{
	var dialogTop =	"80" ;
	var dialogHeight = "40" ;
    var dialogWidth = "65" ;
	var status =	"no";
	var arguments = "" ;	
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=auto; status:" + status;
	var action_url =	'../../eCA/jsp/VerifySignRepText.jsp?requestSrlNo='+requestSrlNo;
	var retVal=await window.showModalDialog(action_url,arguments,features);
}

async function showRepBody(requestSrlNo)
{
	var dialogTop =	"180" ;
	var dialogHeight = "25" ;
    var dialogWidth = "45" ;
	var status =	"no";
	var arguments = "" ;
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url =	'../../eCA/jsp/VerifySignViewBody.jsp?requestSrlNo='+requestSrlNo;
	var retVal=await window.showModalDialog(action_url,arguments,features);
}

function searchForDetails()
{
	var fromDt = document.forms[0].fromDt.value;
	var toDt = document.forms[0].toDt.value;
	var patient_id = document.forms[0].patientId.value;

	var	fields = new Array(document.forms[0].fromDt,document.forms[0].toDt);
	var	names = new Array(getLabel("Common.fromdate.label","COMMON"),getLabel("Common.todate.label","COMMON"));

	top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
	if(checkFieldsofMst( fields, names, top.content.messageFrame))
	{
		parent.signRepTreeFrame.location.href = '../../eCA/jsp/VerifySignReportsTree.jsp?patient_id='+patient_id+'&fromDate='+fromDt+'&toDate='+toDt;
	}
}

function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

function callVerifyProc()
{
	parent.signRepDetailsFrame.document.forms[0].submit();
}

function addValsToBean(obj,obj1,reportId,moduleId,requestDate,mailedUser,requestSrlNo,verify_flag,index)
{
	var mode = "add";
	requestDate = unescape(requestDate);
	var reason = "";
	if(obj.checked == true)
	{
		obj1.checked = false;
		mode = "add";
	}
	else
		mode = "remove";

	parent.signRepIntermediateFrame.location.href = '../../eCA/jsp/VerifySignRepIntermediate.jsp?reportId='+reportId+'&moduleId='+moduleId+'&requestDate='+encodeURIComponent(requestDate)+'&mailedUser='+mailedUser+'&requestSrlNo='+requestSrlNo+'&mode='+mode+'&verify_flag='+verify_flag+'&reason='+reason;
}

async function addValsToBean1(obj,obj1,reportId,moduleId,requestDate,mailedUser,requestSrlNo,verify_flag,index)
{
	var mode = "add";
	requestDate = unescape(requestDate);
	var reason = "";
	var addAllow = true;

	if(obj.checked == true)
	{
		obj1.checked = false;
		mode = "add";

		var dialogHeight	= "10" ;
		var dialogWidth		= "30" ;
		var status			= "no";
		var scroll			= "no";
		var dialogTop		= "140";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	
		var retVal 			=await window.showModalDialog('../../eCA/jsp/VerifySignReportRemarks.jsp?mode=insert',arguments,features);

		if(retVal == '' || retVal == undefined)
		{
			obj.checked = false;
			reason = "";
			addAllow = false;
		}
		else
		{
			reason = retVal;
			eval("document.forms[0].reason"+index).value = reason;
			eval("parent.signRepDetailsFrame.document.getElementById("remark")"+index+".style.display = 'inline'");
			addAllow = true;
		}
	}
	else
	{
		mode = "remove";
		reason = "";
		eval("document.forms[0].reason"+index).value = '';
		eval("parent.signRepDetailsFrame.document.getElementById("remark")"+index+".style.display = 'none'");
	}
	if(addAllow)
	{
		parent.signRepIntermediateFrame.location.href = '../../eCA/jsp/VerifySignRepIntermediate.jsp?reportId='+reportId+'&moduleId='+moduleId+'&requestDate='+encodeURIComponent(requestDate)+'&mailedUser='+mailedUser+'&requestSrlNo='+requestSrlNo+'&mode='+mode+'&verify_flag='+verify_flag+'&reason='+reason;
	}
}
function CheckWithSysDate(obj)
{
	if(obj.value != '')
	{
		if(CheckDate(obj))
		{
			var locale = document.forms[0].locale.value;
			var fromDate = document.forms[0].fromDt.value;
			var toDate = document.forms[0].toDt.value;
			
			if(!(isBeforeNow(obj.value,"DMY",locale) ))
			{
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				obj.value="";
				obj.select();
				obj.focus();
				return false;
			}
			if(toDate != '' && fromDate != '')
			{
				if(!isBefore(fromDate,toDate,"DMY",locale))
				{
					alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
					document.forms[0].toDt.value="";
					document.forms[0].toDt.select();
					return false;
				}
			}
			return true;
		}else{
			document.forms[0].fromDt.value="";
		
		}
	}
}

function onSuccess()
{
	clearForm('T');
}

function clearForm(from)
{
	var reportId   = top.content.workAreaFrame.signRepCriteriaFrame.document.signRepCriteriaForm.report_id.value;
	var fromDate = top.content.workAreaFrame.signRepTreeFrame.document.forms[0].fromDate.value;
	var ToDate = top.content.workAreaFrame.signRepTreeFrame.document.forms[0].toDate.value;
	if(from == "T")
	{
		var action_url = getRelativeURL("/eCA/jsp/VerifySignReportsDetails.jsp?reportId="+reportId+'&fromDate='+fromDate+'&toDate='+ToDate);
		top.content.workAreaFrame.signRepDetailsFrame.location.href = action_url 
		top.content.workAreaFrame.signRepTreeFrame.location.reload();
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

function ClickOK()
{
	var remarks = document.SignRepRemarkForm.remarks.value;
	window.returnValue = remarks;
	window.close();
}
function ClickCancel(mode)
{
	if(mode == 'update')
		window.returnValue = document.SignRepRemarkForm.remarks.value;
	else
		window.returnValue = "";
	window.close();
}
async function showRemarks(requestSrlNo,index)
{
	var mode = "add";
	var remarks = eval("document.forms[0].reason"+index+".value");
	var dialogHeight	= "10" ;
	var dialogWidth		= "30" ;
	var status			= "no";
	var scroll			= "no";
	var dialogTop		= "140";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;

	var retVal 			=await window.showModalDialog('../../eCA/jsp/VerifySignReportRemarks.jsp?mode=update&remarks='+remarks,arguments,features);
	
	if(retVal == '')
	{
		eval("document.forms[0].chk1"+index).checked = false;
		reason = "";
		eval("parent.signRepDetailsFrame.document.getElementById("remark")"+index+".style.display = 'none'");
		mode = "remove";
	}
	else
	{
		reason = retVal;
		eval("document.forms[0].reason"+index).value = reason;
		mode = "add";
	}
	parent.signRepIntermediateFrame.location.href = '../../eCA/jsp/VerifySignRepIntermediate.jsp?requestSrlNo='+requestSrlNo+'&mode='+mode+'&verify_flag=R&reason='+reason;
}
