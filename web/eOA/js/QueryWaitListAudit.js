function changeCase(obj)
{
	obj.value=obj.value.toUpperCase();
	if(obj.value !="")
			{
				var HTML="<html><body onKeyDown = 'lockKey()'><form name='chkpatient_id' id='chkpatient_id' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='chkpatient_id_valid'><input type=hidden name='patient_id' id='patient_id' value='"+obj.value+"'></form></body></html>";
				parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
				parent.messageFrame.document.chkpatient_id.submit();
				
			}
}

async function callPatientSearch(){
 var patientId=await PatientSearch();
 if (patientId!=null && patientId!='')
  document.forms[0].patientid.value=patientId;
}

function CallResult()
{
	var url;
	var url2;
	var patient_id=parent.frames[1].document.forms[0].patientid.value;
	var patientname=parent.frames[1].document.forms[0].patientName.value;
	var inviteddate=parent.frames[1].document.forms[0].invDate.value;
	var waitlistnum=parent.frames[1].document.forms[0].WaitListNo.value;

	if(waitlistnum=="")
	{
		var error_id=getMessage("CAN_NOT_BE_BLANK","Common") ;
		error_id=error_id.replace('$',getLabel("eOA.WaitListnumber.label","OA"));
		alert(error_id);
		parent.pat_details.document.location.href="../../eCommon/html/blank.html ";
		parent.f_query_add_result.document.location.href="../../eCommon/html/blank.html ";
	}else
	{
		url2="../../eOA/jsp/QueryWaitListAuditPatDtls.jsp?patient_id="+patient_id+"&patientname="+patientname+"&inviteddate="+inviteddate+"&waitlistnum="+waitlistnum;
	 parent.pat_details.document.location.href=url2;
	 url="../../eOA/jsp/QueryWaitListAuditResult.jsp?patient_id="+patient_id+"&patientname="+patientname+"&inviteddate="+inviteddate+"&waitlistnum="+waitlistnum;
	 parent.f_query_add_result.document.location.href=url;
	}
}

function CancelResult()
{
	 parent.pat_details.document.location.href="../../eCommon/html/blank.html ";
	 parent.f_query_add_result.document.location.href="../../eCommon/html/blank.html ";
	 parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
}
function reset()
{
	 parent.frames[2].frames[1].document.forms[0].patientid.value="";
	 parent.frames[2].frames[1].document.forms[0].patientName.value="";
	 parent.frames[2].frames[1].document.forms[0].invDate.value="";
	 parent.frames[2].frames[1].document.forms[0].WaitListNo.value="";
	 parent.frames[2].pat_details.document.location.href="../../eCommon/html/blank.html ";
	 parent.frames[2].f_query_add_result.document.location.href="../../eCommon/html/blank.html ";
	 parent.frames[2].messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
}

function scrollheader()
{
	 var x = document.body.scrollTop;
  if(x == 0){
  
   document.getElementById('header').style.position='static';
   document.getElementById('header').style.posTop  = 0;
  }else
  {
		
	document.getElementById('header').style.position = 'relative';
	document.getElementById('header').style.posTop  = x-2;

  }
}

function focus()
{
	parent.frames[1].document.forms[0].WaitListNo.focus();
}



function ValidateDate(obj)
{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
	}
}

