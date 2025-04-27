//FUNCTION CREATE()
//********************************************************************************************
function create()
{

window.f_query_add_mod.location.href="../../eXH/jsp/CommunicationSettingForAppl.jsp?mode=I";
window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
//********************************************************************************************
//FUNCTION QUERY() M
//********************************************************************************************
function query()
{
		window.f_query_add_mod.location.href="../../eXH/jsp/CommunicationSettingsForApplQueryCriteria.jsp";		
		window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
//********************************************************************************************
//FUNCTION APPLY()
//********************************************************************************************
function apply()
{
//window.messageFrame.location.href="../../eCommon/html/blank.html";
var fields;
var names;
if( f_query_add_mod.document.forms[0].out_use.checked==true){
fields = new Array ( f_query_add_mod.document.forms[0].appl_name,f_query_add_mod.document.forms[0].facility,f_query_add_mod.document.forms[0].out_tcp_addr,f_query_add_mod.document.forms[0].out_port_num) ;
names = new Array ( getLabel("Common.Application.label","XH"),
					getLabel("eXH.Facility.Label","XH"),
	                getLabel("eXH.TCPIPAddress.Label","XH"),
	                getLabel("eXH.PortNumber.Label","XH")
	
);
}
else{
fields = new Array ( f_query_add_mod.document.forms[0].appl_name,f_query_add_mod.document.forms[0].facility) ;
names = new Array ( getLabel("Common.Application.label","XH"),
						getLabel("eXH.Facility.Label","XH"));

}
if(window.f_query_add_mod.CommmnSettingsAppl){
if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
{

}
else{
		window.f_query_add_mod.document.forms[0].submit();
		//window.commontoolbarFrame.document.location.reload();
    }
}
else{
		window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
window.commontoolbarFrame.document.location.reload();

}
//********************************************************************************************
//FUNCTION RESET()
//********************************************************************************************
function reset()
{

if(window.f_query_add_mod.document.forms[0])
	{
	
	var flag=window.f_query_add_mod.document.forms[0].mode.value;
	if(flag=='I') window.f_query_add_mod.location.href="../../eXH/jsp/CommunicationSettingForAppl.jsp?mode=I";	
	else window.f_query_add_mod.document.forms[0].reset();
	
	
	}
window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
//********************************************************************************************
//function funOnOutbound
//********************************************************************************************
function funOnOutbound()
{
	outbounddiv.style.display='block';
}
//********************************************************************************************
//function funOffOutbound
//********************************************************************************************
function funOffOutbound()
{
	outbounddiv.style.display='none';
}
//********************************************************************************************
//function funOnInbound
//********************************************************************************************
function funOnInbound()
{
	inbounddiv.style.display='block';
}
//********************************************************************************************
//function funOffInbound
//********************************************************************************************
function funOffInbound()
{
	inbounddiv.style.display='none';
}
//********************************************************************************************
//function validatecheckbox
//********************************************************************************************
function validatecheckbox(obj)
{
   
	var out_disp=document.getElementById("outbounddiv");
	var in_disp=document.getElementById("inbounddiv");
	if(obj.checked==true)
    { 
	   obj.value="Y";
	}
	else 
	{	
	  obj.value="N";
	}

   onLoadOfpage();

}
//********************************************************************************************
//function onLoadOfpage
//********************************************************************************************
function onLoadOfpage()
{
var out_disp=document.getElementById("outbounddiv");
var in_disp=document.getElementById("inbounddiv");

if(this.document.forms[0].out_use.checked==true)
	{
	   out_disp.style.display='block';
	   in_disp.style.display='none';
	}
if(this.document.forms[0].in_use.checked==true)
	{
	   out_disp.style.display='none';
	   in_disp.style.display='block';
	}

if((this.document.forms[0].out_use.checked==true)&&(this.document.forms[0].in_use.checked==true))
	{
       out_disp.style.display='block';
	   in_disp.style.display='block';
	}

if((this.document.forms[0].out_use.checked==false)&&(this.document.forms[0].in_use.checked==false))
	{
       out_disp.style.display='none';
	   in_disp.style.display='none';
	}
parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";}

//********************************************************************************************
//function callJSPs
//********************************************************************************************
function callJSPs(obj)
{
	
	var str = obj.name;
	var frmObj=document.forms[0].elements;
	if (str=='out')
	{
		
		if(document.forms[0].out_use.checked==true)
		{
			 funOffInbound();
			 funOnOutbound();
		
		}
		else
		{
			alert(getMessage( 'XH1006','XH' ));
			document.forms[0].out_use.focus();
		}
		

	}
	if (str=='in')
	{
	
		if(document.forms[0].in_use.checked==true)
		{
			
			funOffOutbound();
			funOnInbound();
		}
		else
		{
			alert(getMessage( 'XH1005','XH' ));
			document.forms[0].in_use.focus();
		}
		
      
	}
	
}
//********************************************************************************************
//function changeSetting
//********************************************************************************************
function changeSetting(obj)
{
    
	outbounddiv.style.display='none';
	inbounddiv.style.display='none';

	if (obj=='out')
	{
     callJSPs('out'); 
    }
    if (obj=='in')
	{
		  callJSPs('in'); 
    }
}
//********************************************************************************************
//function disp_outbound_comm_settings
//********************************************************************************************
function disp_outbound_comm_settings()
{
	if(document.forms[0].out_comm_mode.value=='T')
	{
		outbound_file.style.display='none';
		outbound_tcp_ip_addr.style.display='block';
		outbound_tcp_ip_port.style.display='block';
		outbound_tcp_retry_interval.style.display='block';
		outbound_tcp_ip_max_retries.style.display='block';

	}
	else
	{
		outbound_file.style.display='block';
		outbound_tcp_ip_addr.style.display='none';
		outbound_tcp_ip_port.style.display='none';
		outbound_tcp_retry_interval.style.display='none';
		outbound_tcp_ip_max_retries.style.display='none';

	}
	
}
//********************************************************************************************
//function change_outbound_comm_mode
//********************************************************************************************
function change_outbound_comm_mode()
{
	if(document.forms[0].out_comm_mode.value=='T')
	{
		outbound_file.style.display='none';
		outbound_tcp_ip_addr.style.display='block';
		outbound_tcp_ip_port.style.display='block';
		outbound_tcp_retry_interval.style.display='block';
		outbound_tcp_ip_max_retries.style.display='block';

	}
	else
	{
		outbound_file.style.display='block';
		outbound_tcp_ip_addr.style.display='none';
		outbound_tcp_ip_port.style.display='none';
		outbound_tcp_retry_interval.style.display='none';
		outbound_tcp_ip_max_retries.style.display='none';

	}

}
//********************************************************************************************
//function disp_inbound_comm_settings
//********************************************************************************************

function disp_inbound_comm_settings()
{
	if(document.forms[0].in_comm_mode.value=='T')
	{
		inbound_file.style.display='none';		
	}
	else
	{
		inbound_file.style.display='block';		
	}
	
}
//********************************************************************************************
//function change_inbound_comm_mode
//********************************************************************************************
function change_inbound_comm_mode()
{
	if(document.forms[0].in_comm_mode.value=='T')
	{
		inbound_file.style.display='none';		
	}
	else
	{
		inbound_file.style.display='block';		
	}

}
//********************************************************************************************
//function check_status_appl
//********************************************************************************************
function check_status_appl(obj)
{
	if(document.forms[0].tab_mode.value=='U')
		obj.value=document.forms[0].update_mode_appl.value;
}
//********************************************************************************************
//function check_status_fac
//********************************************************************************************
function check_status_fac(obj)
{
	if(document.forms[0].tab_mode.value=='U')
		obj.value=document.forms[0].update_mode_fac.value;

}
//********************************************************************************************
//function checkt
//********************************************************************************************
  function checkt(obj)
 {
    var valq=obj.value;
    if(valq!='')
    {
          var arr=valq.split(':');
		  if((arr.length>2)||(arr.length==0)) alert(getMessage('XH1026','XH'));
          else
		  {   
             if((!(isNaN(arr[0])))&&(arr[0]<24))
             { 
			 
			 
			 }
             else
			 {		
				 alert(getMessage('XH1026','XH'));
	             obj.focus();
				 return false;
	         }

             if((!(isNaN(arr[1])))&&(arr[1]<60))
             { 
			 
			 
			 }
             else
			 {		
				 alert(getMessage('XH1026','XH'));
	             obj.focus();
				 return false;
	         }

		  }
	}
}

//********************************************************************************************
//function checkFormat
//********************************************************************************************

 function checkFormat(obj)
 {
var valq=obj.value;
if(valq!='')
{

if(valq.length==2) 
	{
obj.value=valq+":00";
return true;
	}
else return false;


}

}
//********************************************************************************************
// function funSubmit
//********************************************************************************************
function funSubmit()
{
	// #MOD#01
	
	var act = '../../eXH/jsp/CommunicationSettingsForApplicationQueryResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
	
}
//********************************************************************************************
// function funModify
//********************************************************************************************

function funModify(obj)
{
	// #MOD#02
	this.document.forms[0].appl_name.value = obj.getAttribute('appl_id');
	this.document.forms[0].facility.value = obj.getAttribute('fac_id');
	

	var act = '../../eXH/jsp/CommunicationSettingForAppl.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
//********************************************************************************************
// function funAction
//********************************************************************************************

function funAction(typ)
{  
	this.document.forms[0].action_type.value = typ;
	funSubmit();
	
}
//********************************************************************************************
// function validDir
//********************************************************************************************
 function validDir(obj)
 {
  var val=obj.value;
  if(val!='')
  {
   var len=val.length;
  if(val.charAt(len-1)!='/')
  {
     alert(getMessage('XH1033','XH'));
	 obj.focus();
	return false;
   }
  }			 
 }
 //********************************************************************************************
