<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/QueryPresVsDispDrug.js"></script> 
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
	<script language="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- 		Added CheckDateLeap funtion for RollForward from SRR - SRR20056-SCF-9383 [IN:056576] -->
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<body topmargin="0">
<%
	String	bean_id			=	"QueryPresVsDispDrugsBean" ;
	String	bean_name		=	"ePH.QueryPresVsDispDrugsBean";

	QueryPresVsDispDrugsBean bean = (QueryPresVsDispDrugsBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	ArrayList patientClass = new ArrayList();
	patientClass=bean.getPatientClass();
	
	String sql_ph_nursing_unit_select =	PhRepository.getPhKeyValue("SQL_PH_PRESVSDISP_NURSUNIT_LOOKUP");
	String sql_ph_clinic_select =	PhRepository.getPhKeyValue("SQL_PH_PRESVSDISP_CLINIC_LOOKUP");
	String patient_id			=	request.getParameter("patient_id");
	String butt_status			=	"";

	if(patient_id==null || patient_id.equals("null")){
		patient_id	=	"";
	} else {
		butt_status	=	"disabled";
	}
%>
<form name="FormQueryPresVsDispDrug" id="FormQueryPresVsDispDrug" >
<table cellpadding="2" cellspacing="0" width="100%" align="center" border="0" topmargin="0">
<tr >
		<td class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td> 
		<td>&nbsp;&nbsp;
		<select name="Order_Type" id="Order_Type">
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
		<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/>
		</option><option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option></select>
		</td>
		<td class="label"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/>
		
		</td>
		<td >&nbsp;&nbsp;
		<input type=text  name="Order_Id" id="Order_Id" size=15 maxlength=15>
		</td>
		<td class="label" nowrap><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/></td>
		<td >&nbsp;&nbsp;
		<select name="Order_Status" id="Order_Status">
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<option value="FD"><fmt:message key="ePH.FullyDispensed.label" bundle="${ph_labels}"/></option>
		<option value="PD"><fmt:message key="ePH.PartiallyDispensed.label" bundle="${ph_labels}"/></option>
		<!--<option value="PND"><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></option>-->
		<!-- added by gangadharan for SRR20056-SCF-7232 & 27232 on 20/5/2011 -->
		<option value="OUT"><fmt:message key="Common.Outstanding.label" bundle="${common_labels}"/></option>
		<option value="INP"><fmt:message key="ePH.InProcess.label"  bundle="${ph_labels}"/></option>
		<!-- added ends -->
		</select>
		</td>
		</tr>
		<tr>
		<td class="label"><fmt:message key="ePH.OrderDateTimeFrom.label" bundle="${ph_labels}"/></td>
		<td >&nbsp;&nbsp;
		<input type=text  name="Order_Date_From" id="Order_Date_From" size=8 maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%= locale %>')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('Order_Date_From');" ><!-- 		Added CheckDateLeap funtion for RollForward from SRR - SRR20056-SCF-9383 [IN:056576]  -->
		</td>
		<td class="label" >
		<fmt:message key="Common.to.label" bundle="${common_labels}"/>
		</td>
			<td >&nbsp;&nbsp;
		<input type=text  name="Order_Date_To" id="Order_Date_To" size=8 maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%= locale %>')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('Order_Date_To');" ><!-- 		Added CheckDateLeap funtion for RollForward from SRR - SRR20056-SCF-9383 [IN:056576]  -->
		</td>
		<td class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
		<td  >&nbsp;&nbsp;
			<select name="Patient_Class" id="Patient_Class" onChange="disableLocationType(this.value)">
					<option value="">&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<%
					for (int i=0;i<patientClass.size();i=i+2){
				%>
					<option value="<%=patientClass.get(i)%>"><%=patientClass.get(i+1)%></option>
				<%
					}
				%>
			</select>			
		</td>

</tr>
<tr >
		<td class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;
		<select name="Location_Type" id="Location_Type" onChange="disableLocation(this.value)">
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
		<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option><option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		</select>
		</td>

		<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;
		<input type=text STYLE='overflow:visible;' disabled size="15" name="Location" id="Location"  ><!--size="40" maxlength="30" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
		<INPUT TYPE="button" name="Location_Button" id="Location_Button" VALUE="?" CLASS="button" disabled onClick="LocationSearch(document.FormQueryPresVsDispDrug.Location)" >
		</td>
	<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td colspan="4">&nbsp;&nbsp;	<input type=text size="15" name="patient_id" id="patient_id" value="<%=patient_id%>" <%=butt_status%> maxlength="<%=bean.getPatientIDLength()%>" onKeyPress="changeToUpper()" onblur="Duplicatecheck();"><INPUT TYPE="button" name="Patient_Id_Button" id="Patient_Id_Button" VALUE="?" CLASS="button" onClick="callPatientSearch()" <%=butt_status%>><!--  onblur="Duplicatecheck();" added for ML-BRU-SCF-0621[IN036565]-->
	</td>
</tr>
<tr >
<td class="button" colspan="6" align="right" ><input type="button" class="button" name="search"  id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResultPage()"></td>
</tr>
</table>
	<input type="hidden" name="nursing_unit_query" id="nursing_unit_query" value="<%=sql_ph_nursing_unit_select%>">
	<input type="hidden" name="clinic_query" id="clinic_query" value="<%=sql_ph_clinic_select%>">
	<input type="hidden" name="Nursing_Unit_Code" id="Nursing_Unit_Code" value="">
	<input type="hidden" name="Clinic_Code" id="Clinic_Code" value="">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%= locale %>">
</form>
<% putObjectInBean(bean_id,bean,request); %>

</body>
<script>
<% if(patient_id!=null && !patient_id.equals("")) { %>
callResultPage()
<% } %>
</script>
</html>

