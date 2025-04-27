<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*"contentType="text/html;charset=UTF-8"%>  
<jsp:useBean id="alTrayDiscrepancyList" scope="session" class="java.util.ArrayList"/>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<html>
	<head>
<%
		
		 request.setCharacterEncoding("UTF-8");
		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eSS/js/InstrUsageDiscrepancyUnits.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
		
	</head>
	<body  >
		<form name="formInstrUsageDiscrepancyUnitsList" id="formInstrUsageDiscrepancyUnitsList" >
			<table border='1' cellpadding='0' cellspacing='0' border='1' width='455' >

			<tr>
			<th><fmt:message key="eSS.Del.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.InstrumentDescription.label" bundle="${ss_labels}"/> </th>
			<th><fmt:message key="eSS.Discrepancy.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
			</tr>
	<%
	
		String bean_id					=		"instrUsageDiscrepancyUnitsDetailBean";
		String bean_name				=		"eSS.InstrUsageDiscrepancyUnitsDetailBean";

		InstrUsageDiscrepancyUnitsDetailBean bean	=		(InstrUsageDiscrepancyUnitsDetailBean) getBeanObject( bean_id,  bean_name,request); 
		bean.setLoginFacilityId((String)session.getAttribute("facility_id"));
		HashMap hmRecord				=		new HashMap();
		String disabled					=		"";
		String className				=		"";
		
		int i;

		for	(i	=0;	i<alTrayDiscrepancyList.size();i++){
		hmRecord						=		(HashMap)	alTrayDiscrepancyList.get(i);
        String write_off_reason_code	=		(String)hmRecord.get("write_off_reason_code");
        String encounter_id				=		(String)hmRecord.get("encounter_id");
        String patient_name				=		(String)hmRecord.get("patient_name");
        String patient_id				=		(String)hmRecord.get("patient_id");
        String discrepancy_qty			=		(String)hmRecord.get("DISCREPANCY_QTY");
		
		bean.initialize(hmRecord);
		String deleteDisabled			=		"";
		
		className						=		((i%2)==0)?"QRYODD":"QRYEVEN";
						
		%>
	
		<tr>
<tr>
		<td nowrap class="<%=className%>" ><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=disabled%> <%=deleteDisabled%>></td>
		<td nowrap class="<%=className%>"><%if(disabled.equals("")){%><a href="javascript:listModify(<%=i%>,'<%=write_off_reason_code%>','<%=encounter_id%>','<%=patient_name%>','<%=patient_id%>');"><%}%><%=bean.getItem_desc()%></a></td>
		<td nowrap class="<%=className%>"><%=bean.getWrite_off_reason_desc()%></td>
		<% if(hmRecord.containsKey("DISCREPANCY_QTY")) {%>
		<td nowrap class="<%=className%>" ><%=bean.checkForNull(discrepancy_qty,"&nbsp;")%></td>
		<%}
		else{%>
		<td nowrap class="<%=className%>" ><%=bean.checkForNull((String)hmRecord.get("discrepancy_qty"),"&nbsp;")%></td>
		<%}%>
		
		<input type="hidden" name="Discrepancy_type" id="Discrepancy_type"	value="<%=bean.getDiscrepancy_type()%>"> 
		<input type="hidden" name="encounter_id" id="encounter_id"	value="<%=bean.getEncounter_id()%>">
		<input type="hidden" name="patient_name" id="patient_name"	value="<%=patient_name%>">
		<input type="hidden" name="patient_id" id="patient_id"		value="<%=patient_id%>">
		
	</tr>

			<%
			}
			%>
			</table>
			
			</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
	
</form>
		
		
	</body>
</html>
<%
	putObjectInBean( bean_id,bean,request);
%>

