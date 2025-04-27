<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head><title></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
</head>
<script language="javascript">
//IN:052732
function enableApply(){
	parent.commontoolbarFrame.document.forms[0].apply.disabled=false;
}
function changeTab(objStr){
	selectTab(objStr);
	var frmObj=document.forms[0];
//	var param=frmObj.param.value;
// Modified by rajesh for ICN 4482

	var param="menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_CHECK_IN&function_name=Check-In&function_type=F&access=YYNNY&facility_id=HS&called_from=OT_MENU&booking_num=null&slate_user_id=null";
	if(objStr=='CheckIn'){
		param+="&tab_id="+objStr;
		parent.commontoolbarFrame.patLineForm.apply.disabled=false;//[IN:052732]
		parent.f_query_add_mod.location.href="../../eOT/jsp/PreOperChkListFrames.jsp?"+param;
		//parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}else if(objStr=='PendingOrders'){
	    parent.commontoolbarFrame.document.forms[0].apply.disabled=false;//[IN:052732] // for testing Apply button disabled
		param+="&checkin_booking_flag=CHECK_IN&tab_id="+objStr;
		parent.f_query_add_mod.location.href="../../eOT/jsp/PendingOrderFrm.jsp?"+param;
		//parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
	parent.document.forms[0].tab_id.value = objStr;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!-- IN:052732-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload ='enableApply()'>
<form name="CheckInTabForm" id="CheckInTabForm">
	<table id="tab" cellspacing=0 cellpadding=3 border="0" width='100%' align="center">
	<tr>
			<td width= "100%" class="white">
				<ul id="tablist" class="tablist">
					<li class="tablistitem" title="<fmt:message key="eOT.CheckIn.Label" bundle="${ot_labels}"/>">
						<a onclick="changeTab('CheckIn')" class="tabclicked" id="CheckIn">
							<span class="tabSpanclicked" id="CheckInspan">
							<fmt:message key="eOT.CheckIn.Label" bundle="${ot_labels}"/>
							</span>
						</a>
					</li>
					<li class="tablistitem" title="<fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/>">
						<a onclick="changeTab('PendingOrders')" class="tabA" id="PendingOrders">
							<span class="tabAspan" id="PendingOrdersspan">
							<fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/>
							</span>
						</a>
					</li>		
					</ul>
			</td>
</tr>
<!-- The below line is required to change the select state of Initial tab selected -->
<script>prevTabObj='CheckIn'</script>
</table>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
<!-- The below line is required to change the select state of Initial tab selected -->
	
</form>
</body>
</html>

