<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8");
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
%>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <STYLE TYPE="text/css">
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
</style> -->

<script language="javascript">
function changeTab(objStr){
	
	var frmObj=document.forms[0];
	//alert(obj.getElmentById(objStr));
	/*var obj1=document.getElementById("PendingOrders");
	obj1.className="tabA";
	obj1=document.getElementById("WaitList");
	obj1.className="tabA";
	obj1=document.getElementById("Schedule");
	obj1.className="tabA";
	obj1=document.getElementById(objStr);
	obj1.className="tabA";*/
	//alert(objStr);
	//var id = document.getElementById(objStr);
	//alert(id);
	selectTab(objStr);
	var param=frmObj.param.value;
	/*if(objStr=='Schedule'){
		parent.frames[1].location.href="../../eOT/jsp/CalendarFrame.jsp?"+param;
	}else if(objStr=='PendingOrders'){
		parent.frames[1].location.href="../../eOT/jsp/PendingOrderFrm.jsp?"+param;
	}else if(objStr=='WaitList'){
		parent.frames[1].location.href="../../eOT/jsp/WaitListFrame.jsp?"+param;
	}*/

	
	switch(objStr){
		case "Schedule": 
			  parent.frames[1].location.href="../../eOT/jsp/CalendarFrame.jsp?"+param;
	          document.getElementById("activeTab").value="Schedule";//PMG-MOD-0005 US-3
			  break;
		case "PendingOrders": 
			  parent.frames[1].location.href="../../eOT/jsp/PendingOrderFrm.jsp?"+param;
		      document.getElementById("activeTab").value="PendingOrders";//PMG-MOD-0005 US-3
			  break;
		case "WaitList": 
			  parent.frames[1].location.href="../../eOT/jsp/WaitListFrame.jsp?"+param;
		      document.getElementById("activeTab").value="WaitList";//PMG-MOD-0005 US-3
    		  break;
	}
	//parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;

	//alert(parent.parent.commontoolbarFrame.name)

	
		
        if(parent.parent.commontoolbarFrame!=null && parent.parent.commontoolbarFrame.document.forms[0].reset.disabled==true)
		{

			if(parent.parent.commontoolbarFrame.document.forms[0].home.value=='Menu')
			expand='0';
			else expand='1';

		param=param+"&expand="+expand;
		parent.parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?"+param;
		}
	
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="OrCommonForm" id="OrCommonForm">
<!--
<table id="tab" cellspacing=0 cellpadding=3="1" border="0" width='100%'>

		<tr>
			<td id="Schedule" 	class="CASECONDSELECTHORZ" onMouseOver="" onMouseOut=";"  nowrap>
			<a  class="MENUHIGHERLEVELLINK"  name='one' href="javascript:changeTab('Schedule');"> 
			<fmt:message key="Common.Schedule.label" bundle="${common_labels}"/></a>
			</td>

			<td id="PendingOrders" 	name='two' class="CAFIRSTSELECTHORZ" onMouseOver="" onMouseOut=";" 	onclick="" nowrap>
			<a  class="MENUHIGHERLEVELLINK"  href="javascript:changeTab('PendingOrders');"> 
			<fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/></a>
			</td>


			<td id="WaitList" 	name='three'	class="CAFIRSTSELECTHORZ"  onMouseOver="" onMouseOut=";"  onclick="" nowrap>
			<a class="MENUHIGHERLEVELLINK"   href="javascript:changeTab('WaitList');"> 
			<fmt:message key="Common.WaitList.label" bundle="${common_labels}"/></a>	
			
</td>
<td colspan='5' width='75%'>&nbsp;</td>
</tr>-->

<table id="tab" cellspacing=0 cellpadding=3 border="0" width='100%'>
<tr>
	<td width= "100%" class="white">
	<ul id="tablist" class="tablist" style="padding-left:0px">
		<li class="tablistitem" title='<fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>' >
			<a  class="tabClicked"  onclick="changeTab('Schedule');" id="Schedule"> 
				<span class="tabSpanclicked" id="Schedulespan"><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>
				</span>
			</a>
		</li>
		
		<li class="tablistitem" title='<fmt:message key="Common.Review.label" bundle="${common_labels}"/>' >
			<a  class="tabA"  onclick="changeTab('PendingOrders');" id="PendingOrders"> 
				<span class="tabAspan" id="PendingOrdersspan"><fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/>
				</span>
			</a>
		</li>
		
		<li class="tablistitem" title='<fmt:message key="Common.WaitList.label" bundle="${common_labels}"/>' >
			<a  class="tabA"  onclick="changeTab('WaitList');" id="WaitList"> 
				<span class="tabAspan" id="WaitListspan">
					<fmt:message key="Common.WaitList.label" bundle="${common_labels}"/>
				</span>
			</a>
		</li>
	</ul>
	</td>
</tr>
	<!-- The below line is required to change the select state of Initial tab selected -->
	<script>prevTabObj='Schedule'</script>

</table>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
<input type='hidden' name='activeTab' id='activeTab' value='Schedule'/><!--PMG-MOD-0005 US-3-->

</form>
</body>
</html>

