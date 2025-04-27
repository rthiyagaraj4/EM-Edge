
function query() {
	f_query_add_mod.location.href ="../../eOP/jsp/ManageMPatQueueQuery.jsp?function=Multiple Patient Queue&refresh=600000";
}

function apply() {}

function onSuccess() {}

function reset(){}

//JS functions used in Multipatframe1.jsp
function clearfields()
{
//parent.frames[0].document.location.reload();

if(parent.frames[0].document.forms[0].call_from.value=='CA')
{
	parent.frames[0].document.forms[0].Qspeciality.value="";
	parent.frames[0].document.forms[0].start_time.value="";
	parent.frames[0].document.forms[0].visit_type.value="N";
	parent.frames[0].document.forms[0].visit_type.checked="";
	parent.frames[1].location.href="../../eCommon/html/blank.html"
}
else
{
	parent.frames[0].document.location.reload();
	parent.frames[1].location.href="../../eCommon/html/blank.html";
}

}

function refreshFrames()
	{  
		
		
		if(document.forms[0].Qspeciality.value!="")
		{

		if(document.forms[0].visit_type.checked==true)
			s="&orderby=yes"
		else
			s="&orderby=no"
		var oprstn=document.forms[0].Qoperstat.value
		var starttime = document.forms[0].start_time.value;
		var qspeciality=document.forms[0].Qspeciality.value;
		var rfresh_param= document.forms[0].rfresh_param.value;
		var call_from= document.forms[0].call_from.value;
		var bl_package_enabled_yn= document.forms[0].bl_package_enabled_yn.value;
		var action_on_pending_bill=document.forms[0].action_on_pending_bill.value;
		
		parent.frames[1].location.href="../../eOP/jsp/MultiPatframe3.jsp?refresh="+rfresh_param+"&oprstn="+oprstn+s+"&starttime="+starttime+"&Qspeciality="+qspeciality+"&call_from="+call_from+"&bl_package_enabled_yn="+bl_package_enabled_yn+"&action_on_pending_bill="+action_on_pending_bill;
		}else
		{parent.frames[1].document.location.href="../../eCommon/html/blank.html"
		alert(getMessage("LOCN_MAND","OP"));
		
		return false;
		}
	}

function callSingleQ()
{
	var rfresh_param= document.forms[0].rfresh_param.value;
	var access_rule=document.forms[0].access_rule.value;
	var	oper_stn=document.forms[0].Qoperstat.value;
	var	call_from=document.forms[0].call_from.value;
	var action_on_pending_bill=document.forms[0].action_on_pending_bill.value;
	var sdate = document.forms[0].sdate.value;
	var pat_id_length = document.forms[0].pat_id_length.value;
	var bl_package_enabled_yn = document.forms[0].bl_package_enabled_yn.value;
	parent.parent.frames[1].location.href="../../eOP/jsp/ManageSPatQueueFr2.jsp?Que=Que&refresh="+rfresh_param+"&oper_stn_access_rule="+access_rule+"&oper_id="+oper_stn+"&call_from="+call_from+"&sdate="+sdate+"&pat_id_length="+pat_id_length+"&bl_package_enabled_yn="+bl_package_enabled_yn+"&action_on_pending_bill="+action_on_pending_bill;
}

function close_op_window()
{
		//parent.parent.parent.frames[5].location.href='../../eOA/jsp/CAOAAppointment.jsp?CA=Y&callingMode=CA';
	//	parent.parent.parent.Appointment.location.href='../../eOA/jsp/CAOAAppointment.jsp?CA=Y&callingMode=CA&module_id=CA&function_id=CLINICIAN_ACCESS&function_name=Clinician Access&function_type=F&menu_id=CA_CLINICIAN_ACCESS&access=NNYNN&child_window=N&limit_function_id=&chartTitle=&reln_req_yn=Y&limit_function_id=';	
     if(parent.parent.parent.Appointment)
	{
	  parent.parent.parent.Appointment.location.href='../../eOA/jsp/CAOAAppointment.jsp?CA=Y&callingMode=CA&module_id=CA&function_id=CLINICIAN_ACCESS&function_name=Clinician Access&function_type=F&menu_id=CA_CLINICIAN_ACCESS&access=NNYNN&child_window=N&limit_function_id=&chartTitle=&reln_req_yn=Y&limit_function_id=';	
	}
	  else{
	 parent.parent.location.href='../../eOA/jsp/CAOAAppointment.jsp?CA=Y&callingMode=CA&module_id=CA&function_id=CLINICIAN_ACCESS&function_name=Clinician Access&function_type=F&menu_id=CA_CLINICIAN_ACCESS&access=NNYNN&child_window=N&limit_function_id=&chartTitle=&reln_req_yn=Y&limit_function_id=';	
		
	  }
	///parent.parent.parent.Appointment.location.href='../../eOA/jsp/CAOAAppointment.jsp?CA=Y&callingMode=CA&module_id=CA&function_id=CLINICIAN_ACCESS&function_name=Clinician Access&function_type=F&menu_id=CA_CLINICIAN_ACCESS&access=NNYNN&child_window=N&limit_function_id=&chartTitle=&reln_req_yn=Y&limit_function_id=';	
	//alert(parent.parent.parent.frames[1].location);
       // alert(parent.parent.frames[1].location);
       // alert(parent.parent.parent.frames[0].location);
}

function validateTIme(obj)
{
	
	if(obj.value != "")
	{
		if(validDate(obj.value,"HM",localeName) == false)
		{
			alert(getMessage("INVALID_TIME_FMT","SM"));
			//obj.select();
			obj.value="";
		}
		else 
			return true;
	}
}

/*function CheckTime(obj) 
	{
		if(obj.value!=""){
		if(!chkTime(obj.value))
		{			
			alert(getMessage("INVALID_TIME_FMT","SM"));
			obj.select();
			obj.focus();
		}
		}
}
*/
	
