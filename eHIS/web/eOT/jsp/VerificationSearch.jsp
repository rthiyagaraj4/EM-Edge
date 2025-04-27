<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!--<title>Order Entry Tabs</title>-->

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
</head>
<STYLE TYPE="text/css">
       	A:link
       	{
       	     COLOR: white;
       	}
     	A:visited
     	{
             COLOR: white ;
        }
        A:active
        {
             COLOR: white;
        }
</style>
	<script language="Javascript" src="../../eOT/js/Booking.js"></script>
	<script language="Javascript" src="../../eOT/js/WaitList.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>	
	<!--<script src="../../eCommon/js/messages.js" language="javascript"></script>-->	
	<!--<script src="../../eOT/js/OTMessages.js" language="javascript"></script>-->

<script language="javascript">
function changeTab(objStr)
{
	selectTab(objStr);
	var frmObj=document.forms[0];
	var param=frmObj.param.value;
	var slateTabFrame = parent.parent.frames[1].document.getElementById("SlateTabFrame");
	if(objStr=='Schedule'){	
		if(parent.parent.commontoolbarFrame)
		{
				var cmf=parent.parent.commontoolbarFrame.document.forms[0];
			   cmf.apply.disabled=false;
		}
		if(parent.parent.parent.commontoolbarFrame)
		{
			var cmf=parent.parent.parent.commontoolbarFrame.document.forms[0];
			cmf.apply.disabled=false;
		}          
		if(parent.parent.parent.frames[1].frames[0].document.location.href.indexOf("SlateTab.jsp") == -1)
	     {
			parent.parent.frames[1].document.getElementById("booking_verification").rows='5%,35%,*,5%';//052732
	     }
	     else
		 {
		 				//parent.parent.frames[1].document.getElementById("SlateTabFrame").rows='5%,35%,*,10%';
			}
  		parent.frames[1].location.href="../../eOT/jsp/BookedcasesVerificationSearch.jsp?"+param+"&schedulekey=schedulekey";
		refreshdetails();
	}else if(objStr=='WaitList'){

			if(parent.parent.commontoolbarFrame)

			{
				var cmf=parent.parent.commontoolbarFrame.document.forms[0];
				cmf.apply.disabled=true;
			}
			if(parent.parent.parent.commontoolbarFrame)
			{
				var cmf=parent.parent.parent.commontoolbarFrame.document.forms[0];
				cmf.apply.disabled=true;
			}
			if(parent.parent.parent.frames[1].frames[0].document.location.href.indexOf("SlateTab.jsp") == -1)
			 {
				//parent.parent.frames[1].document.getElementById("booking_verification").rows='5%,18%,*,5%';//Anitha
				parent.parent.frames[1].document.getElementById("booking_verification").rows='5%,25%,*,5%';//052823
			 }
			//052823
			 else
			{
				//parent.parent.frames[1].document.getElementById("SlateTabFrame").rows='5%,25%,*,10%';
			}
		parent.frames[1].location.href="../../eOT/jsp/BookedcasesVerificationSearch.jsp?"+param+"&WaitListkey=WaitListkey";
		refreshdetails();
	}

}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body >

<form name="OrCommonForm" id="OrCommonForm">

<table id="tab" cellspacing=0 cellpadding=3  align='center' border="0" width='100%'>
<tr>
<td width= "100%" class="white">
	<ul id="tablist" class="tablist" style='padding-left: 0px;'>
		<li class="tablistitem" title="<fmt:message key='eOT.BookedCases.Label' bundle='${ot_labels}'/>">
			<a onclick="changeTab('Schedule')" class="tabclicked" id="Schedule">
			<span class="tabSpanclicked" id="Schedulespan">
			<fmt:message key="eOT.BookedCases.Label" bundle="${ot_labels}"/></span>
			</a>
		</li>
	<li class="tablistitem" title="<fmt:message key='eOT.EmergencyCases.Label' bundle='${ot_labels}'/>">
		<a onclick="changeTab('WaitList')" class="tabA" id="WaitList">
		<span class="tabAspan" id="WaitListspan">
		<fmt:message key="eOT.EmergencyCases.Label" bundle="${ot_labels}"/></span></a>
	</li>		
	</ul>
</td>
</tr>
</table>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
	<!-- The below line is required to change the select state of Initial tab selected -->
	<script>prevTabObj='Schedule'</script>
</form>
</body>
</html>

