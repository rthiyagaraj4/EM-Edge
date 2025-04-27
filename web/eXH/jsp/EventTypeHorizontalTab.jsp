<!DOCTYPE html>
<HTML>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="JavaScript" src="../../eXH/js/EventTypeTabs.js"></script>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>

<script language="JavaScript">    
//function load_first
function load_first()
{ 

var tab1=document.getElementById("eventwise_segment");
var tabspan1=document.getElementById("eventwise_segment_tabspan");
var tab2=document.getElementById("segment");
var tabspan2=document.getElementById("segment_tabspan");
var tab3=document.getElementById("event");
var tabspan3=document.getElementById("event_tabspan");

tab1.className='tabA';
tabspan1.className='tabAspan';
tab2.className='tabA';
tabspan2.className='tabAspan';
tab3.className='tabClicked';
tabspan3.className='tabSpanclicked';
document.forms[0].option.value="event";
parent.f_query_add_mod.location.href ='../../eXH/jsp/EventTypeMessageTypeMain.jsp';
parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}
//function callJSPs
function callJSPs(str)
{

var tab1=document.getElementById("eventwise_segment");
var tabspan1=document.getElementById("eventwise_segment_tabspan");
var tab2=document.getElementById("segment");
var tabspan2=document.getElementById("segment_tabspan");
var tab3=document.getElementById("event");
var tabspan3=document.getElementById("event_tabspan");

if(str=='event')
{
tab1.className='tabA';
tabspan1.className='tabAspan';
tab2.className='tabA';
tabspan2.className='tabAspan';
tab3.className='tabClicked';
tabspan3.className='tabSpanclicked';
document.forms[0].option.value="event";
parent.f_query_add_mod.location.href ='../../eXH/jsp/EventTypeMessageTypeMain.jsp';
parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}

if(str=='segment')
{
tab1.className='tabA';
tabspan1.className='tabAspan';
tab2.className='tabClicked';
tabspan2.className='tabSpanclicked';
tab3.className='tabA';
tabspan3.className='tabAspan';
document.forms[0].option.value="segment";
parent.f_query_add_mod.location.href ='../../eXH/jsp/EventTypeSegmentTypeMain.jsp';
parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}

if(str=='eventwise_segment')
{
tab1.className='tabClicked';
tabspan1.className='tabSpanclicked';
tab2.className='tabA';
tabspan2.className='tabAspan';
tab3.className='tabA';
tabspan3.className='tabAspan';
document.forms[0].option.value="eventwise_segment";
parent.f_query_add_mod.location.href='../../eXH/jsp/EventTypeEventwiseSegmentMain.jsp';
parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
	ul {
            list-style-position: outside; /* Ensure bullets are outside the list */
            margin-left: 0; /* Remove any default margin */
            padding-left: 0; /* Remove any default padding */
        }
</style>

</HEAD>
<BODY  leftmargin=0 topmargin=0  bgcolor='' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="MasterMenu_form" id="MasterMenu_form">

   <table cellspacing='0' cellpadding='0' width='100%' border=0 align='left'>
  <tr><td class='white'>
		<ul id="tablist" class="tablist" >
		   <li class="tablistitem" title='Events'>
				<a onclick="callJSPs('event')" class="tabClicked" id="event" >
					<span class="tabSpanclicked" id="event_tabspan"><fmt:message key="Common.Events.label" bundle="${common_labels}"/></span>
				</a>
		   </li>  

		   <li class="tablistitem" title='Segments'>
				<a onclick="callJSPs('segment')" class="tabA" id="segment" >
					<span class="tabAspan" id="segment_tabspan"><fmt:message key="eXH.Segments.Label" bundle="${xh_labels}"/></span>
				</a>
		   </li> 
		   
		   <li class="tablistitem" title='Event wise Segments'>
				<a onclick="callJSPs('eventwise_segment')" class="tabA" id='eventwise_segment' >
					<span class="tabAspan" id="eventwise_segment_tabspan"><fmt:message key="eXH.EventwiseSegments.Label" bundle="${xh_labels}"/></span>
				</a>
		   </li>

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

