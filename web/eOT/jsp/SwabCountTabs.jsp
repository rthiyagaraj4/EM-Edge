<!DOCTYPE html>

<%@ page import ="eCommon.Common.CommonBean"  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head><title></title>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eOT/js/SwabCount.js' language='javascript'></SCRIPT>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
</head>

<script language="javascript">

function changeTab(objStr)
{
	selectTab(objStr);
	var frmObj=document.SwabCountTabForm;
	var params=frmObj.params.value;
	params=params+"&swab_tab_name="+objStr;
	parent.f_tab_detail_frames.location.href="../../eOT/jsp/SwabCountTabFrames.jsp?"+params;
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String swab_tab_name=request.getParameter("swab_tab_name");
	swab_tab_name=swab_tab_name==null?"SWABCOUNT":swab_tab_name;
	swab_tab_name=swab_tab_name.equalsIgnoreCase("null")?"SWABCOUNT":swab_tab_name;
	swab_tab_name=swab_tab_name.equals("")?"SWABCOUNT":swab_tab_name;
%>
<form name="SwabCountTabForm" id="SwabCountTabForm">
	<table id="tab" cellspacing=0 cellpadding=3  border="0" width="100%">
<tr>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist' style='padding-left:0px'>
			<li class='tablistitem' title='<fmt:message key="eOT.SwabandInstrumentCount.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('SWABCOUNT')" class="tabclicked" id="SWABCOUNT">
					<span class="tabSpanclicked" id="SWABCOUNTspan">
						<fmt:message key="eOT.SwabCount.Label" bundle="${ot_labels}"/></span></a>
			</li>

			<li class="tablistitem" title='<fmt:message key="eOT.BasicSetSuppltemVerifySwabCnt.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('VERIFY')" class="tabA" id="VERIFY">
					<span class="tabAspan" id="VERIFYspan">
						<fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></span></a>
			</li>

				<% if(! CommonBean.checkForNull(request.getParameter("qry_mode")).equals("YES") ) { %>
				<li class="tablistitem" title='<fmt:message key="eOT.PersonnelDetails.Label" bundle="${ot_labels}"/>'>
					<a onclick="changeTab('PERSONNELDTLS')" class="tabA" id="PERSONNELDTLS">
						<span class="tabAspan" id="PERSONNELDTLSspan">
							<fmt:message key="eOT.PersonnelDetails.Label" bundle="${ot_labels}"/></span></a>
			</li>
		<%}%>
		</ul>
	</td>
</tr>
</table>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
</form>
</body>
</html>
<!-- The below line is required to change the select state of Initial tab selected -->
<script>prevTabObj='SWABCOUNT'</script>
<script>changeTab('<%=swab_tab_name%>');</script>

