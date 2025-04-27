
function apply()
{
	var ask_conf=false;
    var p_proc_status='';
    var p_proc_status=parent.frames[2].frames[1].document.forms[0].p_proc_status_update.value;
	if(p_proc_status != 'N'){
	ask_conf=true;
	}
	
	if(ask_conf==true){

		var getValue = parent.frames[2].frames[1].document.forms[0].procstatus.value;

	if (getValue == 'S0' || getValue  == 'S1' || getValue == 'M0'|| getValue == 'S2')
	{
		//var conf=confirm("Do you want to Abort the Process ?");
		var conf=confirm(getMessage("ABORT_PROCESS","DR"));
	}
	else if (getValue == 'M1' || getValue=='M2' )
	{
		var conf=confirm(getMessage("CLOSE_PROCESS","DR"));
	}
			if(conf==true){
			parent.frames[2].frames[1].document.forms[0].submit();
			parent.frames[2].frames[1].document.forms[0].refresh.disabled=true;
			}
			else{
			//var errors=getMessage('THREE_FIELD')+ "<br>";
			var errors="";
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			}
	}   
	else{
	parent.frames[2].frames[1].document.forms[0].submit();	
	}
  
}

function reset()
{
parent.frames[2].frames[1].document.forms[0].reset();	
}

function onSuccess()
{
//parent.frames[1].frames[1].document.forms[0].refresh.disabled=true;
}

function refresh_page(){
document.location.reload();		
}

