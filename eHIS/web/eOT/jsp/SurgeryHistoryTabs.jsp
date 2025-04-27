<!DOCTYPE html>
<html>
<head><!--<title>Order Entry Tabs</title> -->
<%@ page contentType="text/html;charset=UTF-8"  import="eCommon.Common.*" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
</head>
<% 
String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
%>
<script language="javascript">
function changeTab(objStr)
{
	selectTab(objStr);
	var frmObj=document.forms[0];
	/*<% if(called_from.equals("OT_SLATE")) { %>
		var obj1=document.getElementById("pre_oper_checklist_tab");
		obj1.className="CAFIRSTSELECTHORZ";
		obj1=document.getElementById("post_oper_checklist_tab");
		obj1.className="CAFIRSTSELECTHORZ";
	<%}else{ %>
	var obj1=document.getElementById("details_tab");
	obj1.className="CAFIRSTSELECTHORZ";
	obj1=document.getElementById("personnel_tab");
	obj1.className="CAFIRSTSELECTHORZ";
	obj1=document.getElementById("operative_record_tab");
	obj1.className="CAFIRSTSELECTHORZ";
	obj1=document.getElementById("post_oper_diagnosis_tab");
	obj1.className="CAFIRSTSELECTHORZ";
	obj1=document.getElementById("disposal_tab");
	obj1.className="CAFIRSTSELECTHORZ";
	obj1=document.getElementById("specimen_tab");
	obj1.className="CAFIRSTSELECTHORZ";
	obj1=document.getElementById("unusal_tab");
	obj1.className="CAFIRSTSELECTHORZ";
	obj1=document.getElementById("consumable_tab");
	obj1.className="CAFIRSTSELECTHORZ";
	obj1=document.getElementById("pre_oper_checklist_tab");
	obj1.className="CAFIRSTSELECTHORZ";
	obj1=document.getElementById("post_oper_checklist_tab");
	obj1.className="CAFIRSTSELECTHORZ";
	obj1=document.getElementById("swab_count_tab");
	obj1.className="CAFIRSTSELECTHORZ";
	<%}%>
	obj1=document.getElementById(objStr);
	obj1.className="CASECONDSELECTHORZ";*/
	if(objStr=="PostOperativeDiag"){
		callActive();
		top.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";

		return;
	}
	var param=frmObj.param.value+"&parent_tab_id="+objStr+"&nursing_doc_comp_yn=Y"+"&qry_mode=YES";
	//alert("afdsad");
	//alert(sdobjStr);
	//alert(parent.frames[2].name);
	//parent.TitleFrame.location.href='../../eOT/jsp/CommonTabsTitle.jsp?'+param;
	parent.RecordFrame.location.href='../../eOT/jsp/SurgeryHistoryCommonFrame.jsp?'+param;
	//top.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";

	//alert("Here");
}
async function callActive()
{
	var patient_id		= document.SurgeryHistoryTabForm.patient_id.value;
	var encounter_id	= document.SurgeryHistoryTabForm.encounter_id.value;
	var function_id		= "";
	var no_of_items		= "";
	var option_type		= "";
	var module_id		= "OT"
	var query_string	= "patient_id="+patient_id+"&encounter_id=&P_function_id=&P_no_of_items=&P_option_type=";
	
	/*P_function_id,P_no_of_items,P_option_type
	*/
	var retVal 			= new String();
	var dialogHeight 	= "29";
	var dialogWidth  	= "50";
	var dialogTop    	= "100";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await window.showModalDialog("../../eCA/jsp/PatProblemList.jsp?modal_yn=Y&"+query_string,arguments,features);
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="SurgeryHistoryTabForm" id="SurgeryHistoryTabForm">
	<table id="tab" cellspacing=0 cellpadding=5  border="0" width='100%' align='center'>
		<% if(!called_from.equals("OT_SLATE")){ %>
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist' style='padding-left:0px'>
			<li class='tablistitem' title='<fmt:message key="Common.details.label" bundle="${common_labels}"/>'>
				<a onclick="changeTab('details_tab')" class="tabclicked" id="details_tab">
					<span class="tabSpanclicked" id="details_tabspan">
						<fmt:message key="Common.details.label" bundle="${common_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.Personnel.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('personnel_tab')" class="tabA" id="personnel_tab">
					<span class="tabAspan" id="personnel_tabspan">
						<fmt:message key="eOT.Personnel.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.OperativeRecords.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('operative_record_tab')" class="tabA" id="operative_record_tab">
					<span class="tabAspan" id="operative_record_tabspan">
						<fmt:message key="eOT.OperativeRecords.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<!-- Commented by rajesh on 02/11 according to bavani's instruction -->
			<!-- <li class="tablistitem" title='<fmt:message key="eOT.PostOperativeDiagnosis.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('PostOperativeDiag')" class="tabA" id="PostOperativeDiag">
					<span class="tabAspan" id="PostOperativeDiagspan">
						<fmt:message key="eOT.PostOperativeDiagnosis.Label" bundle="${ot_labels}"/></span></a>
			</li> -->
			<li class="tablistitem" title='<fmt:message key="Common.SpecimenDetails.label" bundle="${common_labels}"/>'>
				<a onclick="changeTab('specimen_tab')" class="tabA" id="specimen_tab">
					<span class="tabAspan" id="specimen_tabspan">
						<fmt:message key="Common.SpecimenDetails.label" bundle="${common_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.SwabCount.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('swab_count_tab')" class="tabA" id="swab_count_tab">
					<span class="tabAspan" id="swab_count_tabspan">
						<fmt:message key="eOT.SwabCount.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.DisposalDetails.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('disposal_tab')" class="tabA" id="disposal_tab">
					<span class="tabAspan" id="disposal_tabspan">
						<fmt:message key="eOT.DisposalDetails.Label" bundle="${ot_labels}"/></span></a>
			</li>
		</ul>
	</td>	
</tr>
<tr>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist' style='padding-left:0px'>
			<li class='tablistitem' title='<fmt:message key="eOT.UnusualOccurrence.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('unusal_tab')" class="tabA" id="unusal_tab">
					<span class="tabAspan" id="unusal_tabspan">
						<fmt:message key="eOT.UnusualOccurrence.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.PreOperativeCheckList.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('pre_oper_checklist_tab')" class="tabA" id="pre_oper_checklist_tab">
					<span class="tabAspan" id="pre_oper_checklist_tabspan">
						<fmt:message key="eOT.PreOperativeCheckList.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.PostOperativeCheckList.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('post_oper_checklist_tab')" class="tabA" id="post_oper_checklist_tab">
					<span class="tabAspan" id="post_oper_checklist_tabspan">
						<fmt:message key="eOT.PostOperativeCheckList.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.PacksInstrsEquipsImplants.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('consumable_tab')" class="tabA" id="consumable_tab">
					<span class="tabAspan" id="consumable_tabspan">
						<fmt:message key="eOT.SurgicalAccessories.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<!-- 
			<li class="tablistitem" title='<fmt:message key="eOT.PacksInstrsEquipsImplants.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('consumable_tab')" class="tabA" id="consumable_tab">
					<span class="tabAspan" id="consumable_tabspan">
						<fmt:message key="eOT.PacksInstrsEquipsImplants.Label" bundle="${ot_labels}"/></span></a>
			</li> -->
		</ul>
	</td>
</tr>

<%}else{%>
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist' style='padding-left:0px'>
			<li class='tablistitem' title='<fmt:message key="eOT.PreOperativeCheckList.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('pre_oper_checklist_tab')" class="tabclicked" id="pre_oper_checklist_tab">
					<span class="tabSpanclicked" id="pre_oper_checklist_tabspan">
						<B><fmt:message key="eOT.PreOperativeCheckList.Label" bundle="${ot_labels}"/> <B></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.IntraOperativeCheckList.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('intra_oper_checklist_tab')" class="tabA" id="intra_oper_checklist_tab">
					<span class="tabAspan" id="intra_oper_checklist_tabspan">
						<B><fmt:message key="eOT.IntraOperativeCheckList.Label" bundle="${ot_labels}"/></B> </span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.PostOperativeCheckList.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('post_oper_checklist_tab')" class="tabA" id="post_oper_checklist_tab">
					<span class="tabAspan" id="post_oper_checklist_tabspan">
						<B><fmt:message key="eOT.PostOperativeCheckList.Label" bundle="${ot_labels}"/></B> </span></a>
			</li>
		</ul>
	</td>
</tr>
			
<%}%>
</table>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=request.getParameter("patient_id")%>'>
<input type='hidden' name='encounter_id' id='encounter_id' value='<%=request.getParameter("encounter_id")%>'>
<script>
<%   if(!called_from.equals("OT_SLATE")) {%>
	changeTab('details_tab');
	prevTabObj='details_tab'

  <% }else{ %>
    changeTab('pre_oper_checklist_tab');
	prevTabObj='pre_oper_checklist_tab'

  <% } %>
</script>
</form>
</body>
</html>

