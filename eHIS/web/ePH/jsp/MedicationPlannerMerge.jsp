<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,ePH.*,ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="ePH.MergeMedicationPlan.label" bundle="${ph_labels}" /></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale = (String) session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form action="" name="formMergeMedicationPlanner" id="formMergeMedicationPlanner" method="post">
<%
	try {
		String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
		String encounter_id = CommonBean.checkForNull(request.getParameter("encounter_id"));
		String med_plan_id_max = CommonBean.checkForNull(request.getParameter("med_plan_id_max"));
		String sel_lang = CommonBean.checkForNull(request.getParameter("sel_lang"));
		String  strarrKey[] = new String[4];
		MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request); 
		medplan_bean.setLanguageId(locale);
		
		HashMap hshDrugMap = medplan_bean.getMergeMediPlanDetails(patient_id,med_plan_id_max,medplan_bean.getStrCalledFrom(),sel_lang);
		Set <String> hshKeys = new HashSet<String>();
		hshKeys = hshDrugMap.keySet();
		HashMap hshtemp = new HashMap();
		int i=0;
%>
		<table cellpadding="0" cellspacing="1" width="99%" align="center" border="0">
		<tr>
		<td>
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
			<thead>
				<th class="COLUMNHEADER" ><fmt:message key="Common.Select.label" bundle="${common_labels}" /></th>
				<th class="COLUMNHEADER" ><fmt:message key="Common.DrugName.label" bundle="${common_labels}" /></th>
				<th class="COLUMNHEADER" ><fmt:message key="Common.Qty.label" bundle="${common_labels}" /> <fmt:message	key="Common.Issue.label" bundle="${common_labels}" />&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img></th>
				<th class="COLUMNHEADER" ><fmt:message key="ePH.HowToTake.label" bundle="${ph_labels}" /></th>
				<th class="COLUMNHEADER" ><fmt:message key="ePH.Morning.label" bundle="${ph_labels}" /></th>
				<th class="COLUMNHEADER" ><fmt:message key="ePH.Afternoon.label" bundle="${ph_labels}" /></th>
				<th class="COLUMNHEADER" ><fmt:message key="ePH.Evening.label" bundle="${ph_labels}" /></th>
				<th class="COLUMNHEADER" ><fmt:message key="ePH.Night.label" bundle="${ph_labels}" /></th>
				<th class="COLUMNHEADER" ><fmt:message key="ePH.ImpNotes.label" bundle="${ph_labels}" /></th>
			</thead>
<%			if(hshKeys!=null && hshKeys.size()>0){
				for(String key:hshKeys){
					hshtemp = (HashMap)hshDrugMap.get(key);
					strarrKey = key.split("_");
%>
			<tr>
				<td align="center" width="4%"><input type="checkbox" name="chkdrug<%=i%>" id="chkdrug<%=i%>" value="E"/></td>
				<td align="left" width="13%" class="label"><%=(String)hshtemp.get("drug_name")%>&nbsp;</td>
				<td align="center" width="8%" class="label"><%=(String)hshtemp.get("qty_issue")%>&nbsp;</td>
				<td align="center" width="19%" class="label"><%=(String)hshtemp.get("howtotake")%>&nbsp;</td>
				<td align="center" width="8%" class="label"><%=(String)hshtemp.get("morning")%>&nbsp;</td>
				<td align="center" width="8%" class="label"><%=(String)hshtemp.get("afternoon")%>&nbsp;</td>
				<td align="center" width="8%" class="label"><%=(String)hshtemp.get("evening")%>&nbsp;</td>
				<td align="center" width="8%" class="label"><%=(String)hshtemp.get("night")%>&nbsp;</td>
				<td align="center" width="23%" class="label"><%=(String)hshtemp.get("impnote")%>&nbsp;</td>
			</tr>
			<input type="hidden" name="order_id<%=i%>" id="order_id<%=i%>" value="<%=strarrKey[0]%>"/>
			<input type="hidden" name="order_line_no<%=i%>" id="order_line_no<%=i%>" value="<%=strarrKey[1]%>"/>
			<input type="hidden" name="pres_drug_code<%=i%>" id="pres_drug_code<%=i%>" value="<%=strarrKey[2]%>"/>
			<input type="hidden" name="disp_drug_code<%=i%>" id="disp_drug_code<%=i%>" value="<%=(String)hshtemp.get("disp_drug_code")%>"/>
			<input type="hidden" name="morning<%=i%>" id="morning<%=i%>" value="<%=(String)hshtemp.get("morning")%>"/>
			<input type="hidden" name="afternoon<%=i%>" id="afternoon<%=i%>" value="<%=(String)hshtemp.get("afternoon")%>"/>
			<input type="hidden" name="evening<%=i%>" id="evening<%=i%>" value="<%=(String)hshtemp.get("evening")%>"/>
			<input type="hidden" name="night<%=i%>" id="night<%=i%>" value="<%=(String)hshtemp.get("night")%>"/>
			<input type="hidden" name="morninglocal<%=i%>" id="morninglocal<%=i%>" value="<%=(String)hshtemp.get("morninglocal")%>"/>
			<input type="hidden" name="afternoonlocal<%=i%>" id="afternoonlocal<%=i%>" value="<%=(String)hshtemp.get("afternoonlocal")%>"/>
			<input type="hidden" name="eveninglocal<%=i%>" id="eveninglocal<%=i%>" value="<%=(String)hshtemp.get("eveninglocal")%>"/>
			<input type="hidden" name="nightlocal<%=i%>" id="nightlocal<%=i%>" value="<%=(String)hshtemp.get("nightlocal")%>"/>
			<input type="hidden" name="howtotake<%=i%>" id="howtotake<%=i%>" value="<%=(String)hshtemp.get("howtotake")%>"/>
			<input type="hidden" name="howtotakelocal<%=i%>" id="howtotakelocal<%=i%>" value="<%=(String)hshtemp.get("howtotake")%>"/>
			<input type="hidden" name="impnote<%=i%>" id="impnote<%=i%>" value="<%=(String)hshtemp.get("impnote")%>"/>
			<input type="hidden" name="impnotelocal<%=i%>" id="impnotelocal<%=i%>" value="<%=(String)hshtemp.get("impnote")%>"/>
			<input type="hidden" name="merged_med_plan_id<%=i%>" id="merged_med_plan_id<%=i%>" value="<%=(String)hshtemp.get("merged_med_plan_id")%>"/>
			<input type="hidden" name="locale<%=i%>" id="locale<%=i%>" value="<%=strarrKey[3]%>"/>
			<input type="hidden" name="qty_issue<%=i%>" id="qty_issue<%=i%>" value="<%=(String)hshtemp.get("qty_issue")%>"/>
			<input type="hidden" name="qty_issuelocal<%=i%>" id="qty_issuelocal<%=i%>" value="<%=(String)hshtemp.get("qty_issuelocal")%>"/>
			<input type="hidden" name="drug_name<%=i%>" id="drug_name<%=i%>" value="<%=(String)hshtemp.get("drug_name")%>"/>
			<input type="hidden" name="drug_name_local<%=i%>" id="drug_name_local<%=i%>" value="<%=(String)hshtemp.get("drug_name")%>"/>
			<input type="hidden" name="disp_no<%=i%>" id="disp_no<%=i%>" value="<%=(String)hshtemp.get("disp_no")%>"/>
			<input type="hidden" name="disp_srl_no<%=i%>" id="disp_srl_no<%=i%>" value="<%=(String)hshtemp.get("disp_srl_no")%>"/>
<%			i++;}
			}
%>			
		</table>
		
		<br>
		<table  cellpadding="0" cellspacing="0" width="5%" align="right" border="0">
			<tr>
				<td><input type="button" value='<fmt:message key="Common.Add.label" bundle="${common_labels}" />' class="button" onClick="recordMergeMedPlan()"/></td>
				<td><input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}" />' class="button" onClick="window.close()"/></td>
			</tr>
		</table>
		</td>
		</tr>
		</table>
		<input type="hidden" name="bean_id" id="bean_id" value=""/>
		<input type="hidden" name="bean_name" id="bean_name" value=""/>
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>"/>
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>"/>
		<input type="hidden" name="totalrecords" id="totalrecords" value="<%=i%>"/>
		
		<%} catch (Exception exception) {
				exception.printStackTrace();
			}
		%>
</form>
</body>
</html>

