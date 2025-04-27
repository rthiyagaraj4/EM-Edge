<!DOCTYPE html>
<HTML>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<script language="JavaScript" src="../../eXH/js/DomainApplication.js"></script>

<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>


<script language="JavaScript">
//function load_first
function load_first()
{
//alert("load_first");
//var tab1=document.getElementById("domains");
//var tabspan1=document.getElementById("domains_tabspan");
var tab2=document.getElementById("applications");
var tabspan2=document.getElementById("applications_tabspan");

//tab1.className='tabA';
//tabspan1.className='tabAspan';
tab2.className='tabClicked';
tabspan2.className='tabSpanclicked';
/*
tab2.className='tabA';
tabspan2.className='tabAspan';
tab1.className='tabClicked';
tabspan1.className='tabSpanclicked';
*/
document.forms[0].option.value="applications";
parent.f_query_add_mod.location.href ='../../eXH/jsp/ApplicationAddModifyMaster.jsp?mode=I';

//document.forms[0].option.value="domains";
//parent.f_query_add_mod.location.href ='../../eXH/jsp/InterfaceModuleSelectMaster.jsp?mode=I';

parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}
//function callJSPs
function callJSPs(str)
{

//var tab1=document.getElementById("domains");
//var tabspan1=document.getElementById("domains_tabspan");
var tab2=document.getElementById("applications");
var tabspan2=document.getElementById("applications_tabspan");

if(str=='applications')
{
//tab1.className='tabA';
//tabspan1.className='tabAspan';
tab2.className='tabClicked';
tabspan2.className='tabSpanclicked';

document.forms[0].option.value="applications";

parent.f_query_add_mod.location.href ='../../eXH/jsp/ApplicationAddModifyMaster.jsp?mode=I';
parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}

if(str=='domains')
{
tab1.className='tabClicked';
tabspan1.className='tabSpanclicked';
tab2.className='tabA';
tabspan2.className='tabAspan';

document.forms[0].option.value="domains";
parent.f_query_add_mod.location.href='../../eXH/jsp/InterfaceModuleSelectMaster.jsp?mode=I';
parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0  bgcolor='' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="MasterMenu_form" id="MasterMenu_form">

   <table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
  <tr><td class='white'>
		<ul id="tablist" class="tablist" >
			 <li class="tablistitem" title='Application'>
				<a onclick="callJSPs('applications')" class="tabA" id="applications" >
					<span class="tabAspan" id="applications_tabspan">Application</span>
				</a>
			 </li>

<!--			<li class="tablistitem" title='Sub Domain'>
				<a onclick="callJSPs('domains')" class="tabA" id='domains' >
					<span class="tabAspan" id="domains_tabspan">Sub Domain</span>
				</a>
			 </li> -->

	   </ul>
	 </td>
   </tr>
</table>
 	<input type=hidden name='option' id='option' value=''>
	<script>
	load_first();
</script>
</form>	
</BODY>
</HTML>

