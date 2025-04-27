<!DOCTYPE html>
";
				document.getElementById("toolLink").innerHTML = tabdata;
				document.getElementById("toolLink").style.top  = obj.offsetTop;
				document.getElementById("toolLink").style.left  = obj.offsetLeft ;
				document.getElementById("toolLink").style.visibility='visible';
				flag=1;
		}

		function hideLinks()
		 {
		 	document.getElementById("toolLink").style.visibility='hidden' ;
		
		 }
async function show_Reference_details_results(input)
{
var SystemDef_id=document.forms[0].application_id.value;
var event_type_id=document.forms[0].event_type_id.value;
// var SystemDef_id=document.forms[0].SystemDefine_id.value;
	var dialogHeight= "30" ;
	var dialogWidth	= "45" ;
	var dialogTop = "190" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
await window.showModalDialog("../../eXH/jsp/RearrangeMentDialog.jsp?SystemDef_id="+SystemDef_id+"&event_type_id="+event_type_id+"&input="+input,arguments,features);

}
function Remove1()
{



fields = new Array (document.forms[0].application_name,document.forms[0].event_type);

 names = new Array (getLabel("eXH.ApplicationID.Label","XH"),getLabel("Common.EventType.label","common"));
		if(!checkFields( fields, names, parent.parent.messageFrame))
	{
	}
else
	{
var uservalue=document.forms[0].UsrDefStr.value;

document.forms[0].UserDefind_id.value=uservalue; 

document.forms[0].submit(); 
	}
} 
	function CheckForSpecCharsforID(event){
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_|^-$#%';
	
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		 key = String.fromCharCode(whichCode);  // Get key value from key code
		 if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	}

</script>
</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<!--<FORM name="navigator1" id="navigator1" onload="document.navigator.application_name.focus()">-->
<form name="navigator1" id="navigator1"  method='post' target='messageFrame' action='../../servlet/eXH.ReArrangeMentServlet' onload="document.navigator.application_name.focus()">
<table border=0>
<tr>
<td>
<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<!---<tr>
	<td width='40%'></td>
	<td width='60%'></td>
	<td width='45%'></td>
	<td width='60%'></td>
</tr>--------->
<tr>
<td class=label ><fmt:message key="eXH.ApplicationID.Label" bundle="${xh_labels}"/></td>
<td align=left><input type="text" id="application_name" value=''  name ="application_name"   size=35> 
<input style="background:navy; color:white;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=TableSearch value='?' onClick='searchApplication();' ><input type="hidden" name="application_id" id="application_id" value="null"></td>
<td> </td> <td> </td>
</tr>
<tr>
<td class=label ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
<td align=left><input type=text id="event_type"  name ="event_type" value='' onBlur='qrySystUsrDefStr();' value='' size=35> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=TableSearch value='?' onClick="searchEventType();" ><input type="hidden" name="event_type_id" id="event_type_id" value=''></td>
<td> </td> <td> </td>
</tr>
<tr>
<td class=label onClick="show_Reference_details_results('System Defined Structure')" ><fmt:message key="eXH.SysDefStr.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type="text"  size="43" name="SysDefStr" id="SysDefStr"  onKeyPress='return CheckForSpecCharsforID(event);' onBlur='arrangeTree();'  align='center' disabled><input type="hidden" name="SystemDefind_id" id="SystemDefind_id" value='' ></td>
<td class=label onClick="show_Reference_details_results('User Defined Structure')" ><fmt:message key="eXH.UserDefinedFormat.Label" bundle="${xh_labels}"/></td>
<td align=right><input type="text"  size="43" name="UsrDefStr" id="UsrDefStr"  onKeyPress='return CheckForSpecCharsforID(event);'  onBlur='arrangeTree1();'   align='center' disabled ><input type="hidden" name="UserDefind_id" id="UserDefind_id" value="null" ></td>
</td> 
</tr>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
	<td width='45%'></td>
	<td width='60%'></td>
</tr>
</table>
</FORM>
<div id='toolLink' style='position:absolute; visibility:hidden;overflow:overflow'>
</div>
</BODY>

</HTML> 

