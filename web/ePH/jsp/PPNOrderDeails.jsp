<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>
<html>
<head>
	<%

	String locale			= (String)session.getAttribute("LOCALE");
	 request.setCharacterEncoding("UTF-8");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String sPatientId		= request.getParameter("patientId");
	String sOrderId			= request.getParameter("orderId");
	String dispLocnCode		= request.getParameter("disp_locn_code");
	String disChargeInd = request.getParameter("disChargeInd")==null?"":request.getParameter("disChargeInd");

%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<title><fmt:message key="ePH.PPN.label" bundle="${ph_labels}"/> <fmt:message key="Common.Orders.label" bundle="${common_labels}"/>	</title> 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/PPNRegimen.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form name = "PPNSearchResult">
<%
	String bean_id_1				= "DispMedicationBean" ;
	String bean_name_1				= "ePH.DispMedicationBean";
	DispMedicationBean bean_1		= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1 , request) ;
	bean_1.setLanguageId(locale);
	
	String facility_id					= (String) session.getValue("facility_id");
	HashMap hmValues = bean_1.getPPNIOrderValues(sOrderId,sPatientId,dispLocnCode,disChargeInd);
	if(hmValues!= null && hmValues.size()>0){

%>
<table width ="100%">
	<tr>
		<td class= "COLUMNHEADER" width="17%" style="font-size:9">
			<fmt:message key="ePH.RegimenCode.label" bundle="${ph_labels}"/>
		</td>
		<td class= "COLUMNHEADER" width="35%" style="font-size:9">
			<fmt:message key="Common.longname.label" bundle="${common_labels}"/>
		</td>
		<td class= "COLUMNHEADER" width="18%" style="font-size:9">
			<fmt:message key="ePH.Quantity/Uom.label" bundle="${ph_labels}"/>
		</td>
		<td class= "COLUMNHEADER" width="15%" style="font-size:9">
			<fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>
		</td>
		<td class= "COLUMNHEADER" width="15%" style="font-size:9">
			<fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/>
		</td>
	</tr>
	<tr>
		<td class="label">
			<%=hmValues.get("itemCode")%>
		</td>
		<td class="label">
			<%=hmValues.get("itemDesc")%>
		</td>

		<td class="label">
			<%=hmValues.get("selectedQty")%> <%=bean_1.getUomDisplay(facility_id,hmValues.get("UOMCode").toString())%>
		</td>
		<td class="label">
			<%=hmValues.get("batchId")%>
		</td>
		<td class="label">
			<%=hmValues.get("expiryDate")%>
		</td>
	</tr>

</table>
<%
	}else{
%>
     <script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
         window.close();
     </script>
<%}%>
</form>
</body>
</html>

