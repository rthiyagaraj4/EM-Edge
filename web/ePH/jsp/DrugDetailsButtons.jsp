<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
<head>
<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/DiscontinueDrug.js"></script>
<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/DrugDetailsDisplay.js"></SCRIPT>
<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function tab_click1(id){
	selectTab(id);

}
</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name="FormDrugDetailsButtons" id="FormDrugDetailsButtons">
<%
	int diagnosislistCount = Integer.parseInt(request.getParameter("diagnosislistCount")==null?"0":request.getParameter("diagnosislistCount"));
	int ageGroupCount = Integer.parseInt(request.getParameter("ageGroupCount")==null?"0":request.getParameter("ageGroupCount"));
	String licenceRights = PhLicenceRights.getKey();
%>

	<table border="0" width="120%" cellspacing="0" cellpadding="0">
		<BR>
		<tr><td width= "140%" class="white">
		<ul id="tablist" class="tablist" style="padding-left:0px" >
			<li class="tablistitem" title='<fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/>'>
				<a onclick="tab_click1('characteristics_tab');CharecteristicsButton(this,'<%=licenceRights%>');" class="tabClicked" id="characteristics_tab" >
					<span class="tabSpanclicked" id="characteristics_tabspan"><fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title='<fmt:message key="ePH.DosageDispDetails.label" bundle="${ph_labels}"/>'>
				<a onclick="tab_click1('dosage_tab');DosageDispensingButton(this,'<%=licenceRights%>');" class="tabA" id="dosage_tab" >
					<span class="tabAspan" id="dosage_tabspan"><fmt:message key="ePH.DosageDispDetails.label" bundle="${ph_labels}"/></span>
				</a>
			</li>
<%
	if(!licenceRights.equals("PHBASIC")){
%>
<li class="tablistitem" title='<fmt:message key="ePH.InventoryItems.label" bundle="${ph_labels}"/>'>
				<a onclick="tab_click1('inventory_tab');InventoryItemsButton(this,'<%=licenceRights%>');" class="tabA" id="inventory_tab" >
					<span class="tabAspan" id="inventory_tabspan"><fmt:message key="ePH.InventoryItems.label" bundle="${ph_labels}"/></span>
				</a>
			</li>
		
<%
	}
%>
		<li class="tablistitem" title='<fmt:message key="Common.TradeName.label" bundle="${common_labels}"/>'>
				<a onclick="tab_click1('trade_tab');TradeNamesButton(this,'<%=licenceRights%>');" class="tabA" id="trade_tab" >
			<span class="tabAspan" id="trade_tabspan"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		<li class="tablistitem" title='<fmt:message key="ePH.GenricIngredints.label" bundle="${ph_labels}"/>'>
				<a onclick="tab_click1('generic_tab');GenericButton(this,'<%=licenceRights%>');" class="tabA" id="generic_tab" >
					<span class="tabAspan" id="generic_tabspan"><fmt:message key="ePH.GenricIngredints.label" bundle="${ph_labels}"/></span>
				</a>
			</li>
<%
		if(diagnosislistCount>0){
%>
			<li class="tablistitem" title='<fmt:message key="ePH.DiagnosisList.label" bundle="${ph_labels}"/>'>
				<a onclick="tab_click1('diagnosislist_tab');diagnosislistButton(this,'<%=licenceRights%>');" class="tabA" id="diagnosislist_tab" >
					<span class="tabAspan" id="diagnosislist_tabspan"><fmt:message key="ePH.DiagnosisList.label" bundle="${ph_labels}"/></span>
				</a>
			</li>
<%
		}

		if(ageGroupCount>0){
%>
			<li class="tablistitem" title='<fmt:message key="ePH.AgeGroups.label" bundle="${ph_labels}"/>'>
				<a onclick="tab_click1('agegroup_tab');ageGroupButton(this,'<%=licenceRights%>');" class="tabA" id="agegroup_tab" >
					<span class="tabAspan" id="agegroup_tabspan"><fmt:message key="ePH.AgeGroups.label" bundle="${ph_labels}"/></span>
				</a>
			</li>
<%
			}
%>
			</ul>
			</td>
		</tr>
	</table>
</form>
<script>
CharecteristicsButton(document.FormDrugDetailsButtons.characteristics_tab,'<%=licenceRights%>');
characteristics_tab.click();
</script>
</body>

</html>

