<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
</head>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

<script language="javascript">
function changeTab(objStr)
{
	selectTab(objStr);
	//alert(objStr);
	var frmObj=document.forms[0];
	var param=frmObj.param.value;
	if(objStr=='GingivalStatus'){		//parent.frames[1].location.href="../../eOH/jsp/PeriodontalSummaryFrame.jsp.jsp?"+param+"&schedulekey=schedulekey";
	//alert(param);
		parent.SummaryTabDetailsFrame.location.href="../../eOH/jsp/PeriodontalSummaryFrame.jsp?"+param;
		parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}else if(objStr=='PeriodontalSummary'){
		//parent.frames[1].location.href="../../eOT/jsp/BookedcasesVerificationSearch.jsp?"+param+"&WaitListkey=WaitListkey";
		parent.SummaryTabDetailsFrame.location.href="../../eOH/jsp/PerioSummaryFrames.jsp?"+param;
		parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<form name="OhSummaryForm" id="OhSummaryForm"><table id="tab" cellspacing=0 cellpadding=3  align='left' border="0" width='100%'>
<tr>
<td width= "100%" class="white">


	<ul id="tablist" class="tablist">
		<li class="tablistitem" title=<fmt:message key="eOH.GingivalStatusSummary.Label" bundle="${oh_labels}"/>>
			<a onclick="changeTab('GingivalStatus')" class="tabClicked" id="GingivalStatus">
			<span class="tabSpanclicked" id="GingivalStatusspan">
			<fmt:message key="eOH.GingivalStatusSummary.Label" bundle="${oh_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="">
			<a onclick="changeTab('PeriodontalSummary')" class="tabA" id="PeriodontalSummary">
			<span class="tabAspan" id="PeriodontalSummaryspan">
			<fmt:message key="eOH.PeriodontalSummary.Label" bundle="${oh_labels}"/></span></a>
		</li>		
	</ul>
</td>
</tr>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
	<!-- The below line is required to change the select state of Initial tab selected -->
	<script>prevTabObj='GingivalStatus'
	changeTab('GingivalStatus');
	</script>	 
</table>
</form>
</body>
</html>


