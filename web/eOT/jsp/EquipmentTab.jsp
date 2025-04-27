<!DOCTYPE html>


<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head><!--<title>Order Entry Tabs</title> -->
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
</head>
<script language="javascript">
function changeTab(objStr)
{
	selectTab(objStr);
	var frmObj=document.forms[0];
	/*r	obj1=document.getElementById("InstrumentsTab");
	obj1.className="CAFIRSTSELECTHORZ";
	obj1=document.getElementById("EquipmentsTab");
	obj1.className="CAFIRSTSELECTHORZ";
	obj1=document.getElementById("ImplantsTab");
	obj1.className="CAFIRSTSELECTHORZ";
	obj1=document.getElementById("ConsumableTab");
	obj1.className="CAFIRSTSELECTHORZ";
	obj1=document.getElementById(objStr);
	obj1.className="CASECONDSELECTHORZ";*/
	var param=frmObj.param.value+"&tab_id="+objStr+"&qry_mode_flag=Y"+"&nursing_doc_comp_yn=Y"
	//alert(param);
	//alert(objStr);
	//alert(parent.ChildBaseFrame.name);
	//parent.ChildTitleFrame.location.href='../../eOT/jsp/CommonTabsChildTitle.jsp?'+param
	parent.DetailFrame.location.href='../../eOT/jsp/NursingOperDtlsChildFrames.jsp?'+param;
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="OperationEquipmentsTabForm" id="OperationEquipmentsTabForm">
	<table id="tab" cellspacing=0 cellpadding=3 border="0" width='100%' align='center'>
<tr>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist' style='padding-left:0px'>
			<li class='tablistitem' title='<fmt:message key="eOT.InstrumentsCSSDPacks.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('InstrumentsTab')" class="tabclicked" id="InstrumentsTab">
					<span class="tabSpanclicked" id="InstrumentsTabspan">
						<fmt:message key="eOT.InstrumentsCSSDPacks.Label" bundle="${ot_labels}"/>
					</span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('EquipmentsTab')" class="tabA" id="EquipmentsTab">
					<span class="tabAspan" id="EquipmentsTabspan">
						<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.ConsumablePacks.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('ConsumableTab')" class="tabA" id="ConsumableTab">
					<span class="tabAspan" id="ConsumableTabspan">
						<fmt:message key="eOT.ConsumablePacks.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.ProsthesisImplantsDetails.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('ImplantsTab')" class="tabA" id="ImplantsTab">
					<span class="tabAspan" id="ImplantsTabspan">
						<fmt:message key="eOT.ProsthesisImplantsDetails.Label" bundle="${ot_labels}"/></span></a>
			</li>
		</ul>
	</td>
</tr>

</table>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
<script>
	changeTab('InstrumentsTab');
	prevTabObj='InstrumentsTab'
</script> 	

</form>
</body >
</html>

