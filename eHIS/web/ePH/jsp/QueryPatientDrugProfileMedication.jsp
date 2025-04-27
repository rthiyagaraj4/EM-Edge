<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<title> <fmt:message key="ePH.IVMedicationDetails.label" bundle="${ph_labels}"/> </title>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> --> 
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/QueryPatientDrugProfile.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<%
	String order_id = request.getParameter("order_id");
	String	bean_id			=	"QueryPatientDrugProfileBean" ;
	String	bean_name		=	"ePH.QueryPatientDrugProfileBean";

	QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;
	bean.setLanguageId(locale);
	ArrayList result = bean.getMedicationDetails(order_id);
	ArrayList fluid = (ArrayList)result.get(0);
	ArrayList ingredients = (ArrayList)result.get(1);
%>
<form name="queryPatientDrugProfileRemarks" id="queryPatientDrugProfileRemarks" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<th colspan="4"><fmt:message key="ePH.IVFluid.label" bundle="${ph_labels}"/></th>
	</tr>
	<tr>
		<td class="label"><b><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></b></td>
		<td class="label"><b><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></b></td>
		<td class="label"><b><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></b></td>
		<td class="label"><b><fmt:message key="Common.volume.label" bundle="${common_labels}"/></b></td>
	</tr>
	<tr>
		<td class="label"><%=fluid.get(1)%></td>
		<td class="label"><%=fluid.get(3)%></td>
		<td class="label"><%=fluid.get(4)%></td>
		<td class="label"><%=fluid.get(5)%>&nbsp;<%=fluid.get(6)%></td>
	</tr>
	<tr></tr>
	<tr></tr>
	<tr>
		<td class="label"><b><fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/></b></td>
		<td class="label"><%=fluid.get(7)%></td>
		<td class="label"><b><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></b></td>
		<td class="label"><%=fluid.get(8)%>&nbsp;<%=fluid.get(9)%></td>
	</tr>
	<tr>
		<td class="label"><b><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></b></td>
		<td class="label"><%=fluid.get(10)%></td>
		<td class="label"><b><fmt:message key="Common.duration.label" bundle="${common_labels}"/></b></td>
		<td class="label"><%=fluid.get(11)%>&nbsp;<%=fluid.get(12)%></td>
	</tr>
	<tr></tr>
	<tr>
		<td colspan="4">
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<%
			if(ingredients.size()>0){
		%>
			<tr >
				<th colspan="4"><fmt:message key="ePH.IVIngredients.label" bundle="${ph_labels}"/></th>
			</tr>
			<tr>
				<td class="label"><b><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></b></td>
				<td class="label"><b><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></b></td>
				<td class="label"><b><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></b></td>
				<td class="label"><b><fmt:message key="ePH.OrderedQuantity.label" bundle="${ph_labels}"/></b></td>  
			</tr>
		<%
				for (int i=0;i<ingredients.size();i=i+7){
		%>
					<tr>
						<td class="label"><%=ingredients.get(i+1)%></td>
						<td class="label"><%=ingredients.get(i+3)%></td>
						<td class="label"><%=ingredients.get(i+4)%></td>
						<td class="label"><%=ingredients.get(i+5)%>&nbsp;<%=ingredients.get(i+6)%></td>
					</tr>
		<%
				}
			}
		%>
		</table>
		</td>
	</tr>
	<tr>
		<td colspan="4">
			<input type="button" class="button" value="Close" name="btncloseMedicationDetails" id="btncloseMedicationDetails" onClick="closeMedicationDetails()">
		</td>
	</tr>
</table>
</form>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

