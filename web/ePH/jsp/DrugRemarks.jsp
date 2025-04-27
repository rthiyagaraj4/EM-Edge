<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %><%-- Mandatory declarations end --%>

<html>
<head>
	<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>
<%
	String order_id		 = request.getParameter("order_id");
	String order_line_no = request.getParameter("order_line_no");
	String bean_id	= "MedicationAdministrationFTBean";
	String bean_name= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean bean	= (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name, request );
	String remarks = bean.getDrugInstructions(order_id,order_line_no);
	if(remarks==null)remarks="";
%>
<body onMouseDown="" onKeyDown="lockKey()">
<form name="formDrugRemarks" id="formDrugRemarks">
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<th align="left"><fmt:message key="ePH.DrugInstructions.label" bundle="${ph_labels}"/></th>
		<tr>
			<td>
				<textarea cols="22" rows="6" readOnly><%=remarks%></textarea>
			</td>
		</tr>
	</table>
</form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

