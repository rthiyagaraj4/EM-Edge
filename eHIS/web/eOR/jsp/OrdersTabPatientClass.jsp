<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import = "java.util.*,eOR.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../js/OrdersTab.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<!--
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<!--in the case of getting the data from Bean and to display i need to write 
  a for loop specifying <option> tag in between the braces of for loop...
  -->
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="FocusFirstElement()">
<%
	
	String mode = request.getParameter("mode");
	String function_id = request.getParameter("function_id");
	String patient_class = request.getParameter("patient_class");
	String patient_class_desc = request.getParameter("patient_class_desc");
	String func_id = request.getParameter("func_id");
	String bean_id = "Or_OrdersTab";
	String bean_name = "eOR.OrdersTabBean";
	String strPatClass = "";
	Vector shDesc =  new Vector();
	Vector patClass =  new Vector();
	
	OrdersTabBean bean = (OrdersTabBean)getBeanObject( bean_id,  bean_name, request ) ;

	ArrayList obj = (ArrayList) bean.getPatientClass();
%>

<form name=frmPatientClass>
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<tr>

<% 
	if(patient_class.equals("") || patient_class.equals(" ") || patient_class == null)
	{
		patient_class = "*A";func_id="";
%>
<td class="label"  width="25%" ><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td  class="fields" width="25%">
<select name="func_id" id="func_id">
	<option value="*A" <%=eHISFormatter.select(func_id,"*A")%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<option value="ORDERS" <%=eHISFormatter.select(func_id,"ORDERS")%>><fmt:message key="Common.Orders.label" bundle="${common_labels}"/> </option>
	<option value="EXTERNAL_ORDERS" <%=eHISFormatter.select(func_id,"EXTERNAL_ORDERS")%>><fmt:message key="eOR.ExternalOrders.label" bundle="${or_labels}"/></option>
	<option value="MEDICATION_ADMIN" <%=eHISFormatter.select(func_id,"MEDICATION_ADMIN")%>><fmt:message key="Common.MedicationAdministration.label" bundle="${common_labels}"/></option>
</select>
</td>
</tr>
<tr>
<td class="label"  width='25%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>

<td class="fields"  width='25%'> 
<select name="patient_short_desc" id="patient_short_desc" onchange="javascript:PatientClassDesc()">
							<option selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%
				if(!obj.isEmpty())
				{
					shDesc = (Vector )obj.get(0); // vector for all short descriptions
					patClass = (Vector )obj.get(1); // vector for all patient classes
				}
				obj=null;
						
				for(int i=0;i<shDesc.size();i++)
				{
		%>
				<option><%= (String )shDesc.get(i) %> </option>
		<%
				}
				for(int j=0;j<patClass.size();j++)
				{
					if(j == (patClass.size() - 1))
					strPatClass = strPatClass + (String )patClass.get(j);
					else
					strPatClass = strPatClass + (String )patClass.get(j) + ",";
				}
		%>
			</select> 
</td>
</tr>
<%
	}// end of if
	else
	{
%>
<td class="label"  width="25%" > <fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
<td class="fields" width="25%" >
<select name="func_id" id="func_id" disabled>
	<option value="*A" <%=eHISFormatter.select(func_id,"*A")%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<option value="ORDERS" <%=eHISFormatter.select(func_id,"ORDERS")%>><fmt:message key="Common.Orders.label" bundle="${common_labels}"/> </option>
	<option value="EXTERNAL_ORDERS" <%=eHISFormatter.select(func_id,"EXTERNAL_ORDERS")%>><fmt:message key="eOR.ExternalOrders.label" bundle="${or_labels}"/></option>
	<option value="MEDICATION_ADMIN" <%=eHISFormatter.select(func_id,"MEDICATION_ADMIN")%>><fmt:message key="Common.MedicationAdministration.label" bundle="${common_labels}"/></option>
</select>
</td>
</tr>
<tr>
<td class="label"  width='25%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>

<td class="fields" width='25%'>
	<select name="patient_short_desc" id="patient_short_desc" disabled>
							<option selected><%=patient_class_desc%>&nbsp</option>
		</select> 
</td>
</tr>
<%
	}//end of else	
%>
</table>
	<input type="hidden" name="mode" id="mode" value='<%=mode%>'>
	<input type="hidden" name="temp" id="temp" value='<%= strPatClass %>'>
	<input type="hidden" name="patient_class_desc" id="patient_class_desc" value='<%= patient_class_desc %>'>
	<input type="hidden" name="patient_class" id="patient_class" value='<%= patient_class %>'>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value='<%= function_id %>'>

</form>
</body>
</html>
<%
		putObjectInBean(bean_id,bean,request);
 
%>

