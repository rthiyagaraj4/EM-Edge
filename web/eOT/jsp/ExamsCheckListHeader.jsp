<!DOCTYPE html>
<%@page  import ="eOT.*,eOT.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%><%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
	<script language='javascript' src='../../eCommon/js/common.js'></script>

	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/ExamsCheckList.js" ></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
	String facility_id	= (String) session.getValue("facility_id");
	String params		= request.getQueryString() ;
	String order_id		= request.getParameter("order_id") ;
	String disabled = "";
	order_id=order_id==null?"":order_id;
	order_id=order_id.equalsIgnoreCase("null")?"":order_id;
	if(!order_id.equals(""))
		disabled="disabled";
%>
<body  onKeyDown = 'lockKey()' >
<form name="ExamCheckListHeaderForm" id="ExamCheckListHeaderForm" >
<table cellpadding=3 cellspacing="0" width="100%" align="center" border="0">
<tr>
	<td align="right" class="label" ><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/>
	</td>
	<td align="left" class="label">
		<input type="hidden" name="order_id" id="order_id" size="20" value="<%=order_id%>" disabled>
		<input type="hidden" class="button" name="generic_search" id="generic_search" value="?" onclick="searchOrders();" <%=disabled%>>
	</td>
	<td align="right" class="label" ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
	<td align="left" class="label" >
		<input type="hidden" name="ordered_date" id="ordered_date" size="15" value="" disabled>
	</td>
	<td align="right" class="label" ><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></td>
	<td align="left" class="label" colspan="3">
		<input type="hidden" name="patient_class_desc" id="patient_class_desc" size="15" value="" disabled>
		<input type="hidden" name="encounter_id" id="encounter_id" size="12" value="" disabled>
	</td>
</tr>
<tr>
	<td align="right" class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td align="left" class="label" colspan="7">
		<input type="hidden" name="patient_id" id="patient_id" size="20" value="" disabled>
		<input type="hidden" name="patient_name" id="patient_name" size="60"  value="" disabled>
	</td>
</tr>
<tr>
	<td align="right" class="label" ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
	<td align="left" class="label" >
		<input type="hidden" name="sex" id="sex" size="7" value="" disabled>
	</td>
	<td align="right" class="label" >
	<fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
	<td align="left" class="label" >
		<input type="hidden" name="dob" id="dob" size="9" value="" disabled>
	</td>
	<td align="left" class="label" ></td>
	<td align="right" class="label" ><fmt:message key="eOT.CheckListCompleted.Label" bundle="${ot_labels}"/></td>
	<td align="left" class="label" >
		<input type="checkbox" name="checklist_completed_yn" id="checklist_completed_yn" value="" >
	</td>
	<td align="left" class="label" ></td>
</tr>
<tr>
	<td align="right" class="label" colspan="8"><input type="hidden" class="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="searchCheckList()"><input type="hidden" class="button" name="Clear" id="Clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick="clearSearchCriteria(document.ExamCheckListHeaderForm)" <%=disabled%> ><input type="hidden" class="button" name="Close" id="Close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="window.returnValue='';window.close();">
	
	</td>
</tr>
</table>
	<input type="hidden" name="params" id="params" value="<%=params%>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">	
	<input type="hidden" name="patient_class" id="patient_class" value="" >	
	<input type="hidden" name="order_type_code" id="order_type_code" value="" >	
	<input type="hidden" name="episode_type" id="episode_type" value="" >		
	<input type="hidden" name="data_exists" id="data_exists" value="" >		
	<input type="hidden" name="patient_display_text" id="patient_display_text" value="" >
<%
	if(!order_id.equals("")){
%>
	<script>
		var formObj = document.ExamCheckListHeaderForm;
		assignPatientDetails(formObj);
		var patient_id = formObj.patient_id.value;
		var patient_name = formObj.patient_name.value;
		var sex = formObj.sex.value;
		var dob = formObj.dob.value;
		var order_id = formObj.order_id.value;
		var encounter_id = formObj.encounter_id.value;
		parent.f_header_title.location.href="../../eOT/jsp/ExamsCheckListHeaderTitles.jsp?order_id="+order_id+"&patient_id="+patient_id+"&patient_name="+patient_name+"&sex="+sex+"&dob="+dob+"&encounter_id="+encounter_id;
		searchCheckList();
	</script>
<%
	}
%>
</form>
</body>
</html>

