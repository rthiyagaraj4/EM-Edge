<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<title><fmt:message key="eOR.BillingChargesDetails.label" bundle="${or_labels}"/></title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrderEntryToolTip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- for Tool Tip-->
	
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="" id="">

<%
	


	String bean_id = "Or_billingQueryBeanr" ;
	String bean_name = "eOR.OrderEntryBillingQueryBean";
	
	String orderId = request.getParameter("orderId");
	//String order_line_num = request.getParameter("order_line_num");
	String patient_id = request.getParameter("patient_id");
	
    String ord_cat = request.getParameter("ord_cat");
    ord_cat = (ord_cat == null) ? "" : ord_cat;
	String called_from=request.getParameter("called_from");
	called_from = (called_from == null) ? "" : called_from;
	String encounter_id=request.getParameter("encounter_id");
	encounter_id = (encounter_id == null) ? "" : encounter_id;
	//ArrayList allValues = new ArrayList();
//	out.println("<script>alert('getQueryString::"+request.getQueryString()+"order_line_num"+order_line_num+"')</script>");
	
	
	OrderEntryBillingQueryBean bean = (OrderEntryBillingQueryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	bean.clearBean() ;
	
//	allValues					= bean.viewBillingDetails(orderId);
//	String slClassValue 		= "";

if(called_from.equals("register_visit"))	
{
%>
<jsp:include page="../../eCommon/jsp/pline.jsp" flush="true" >
	<jsp:param name ="EncounterId"  value= "<%=encounter_id%>" />	
</jsp:include>
<%
}
%>
<table cellpadding=3 cellspacing=0 border=1 width='100%' align='center' id='tableheader'>
<!-- <tr>
	<td  class='CAGROUPHEADING' align='left' colspan='7'><B>Billing Charges Details</B></td>
</tr> -->
<tr align='left'>
	<%
	if(called_from.equals("register_visit"))
	{
	%>
		<th class='columnheader' width='15%'><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></th>
	<%
	}
	%>
	<th class='columnheader' width='15%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
	<th class='columnheader' width='15%'><fmt:message key="eOR.TotalCharge.label" bundle="${or_labels}"/></th>
	<th class='columnheader' width='15%'><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></th>
	<th class='columnheader' width='15%'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/></th>
	<th class='columnheader' width='15%' id="Included" style="display:"><fmt:message key="Common.Included.label" bundle="${common_labels}"/></th>
	<!-- <th	width='10%'	>Current Include Flag</th> -->
	<th class='columnheader' width='15%' id="ApprovalReqd" style="display:"><fmt:message key="eOR.ApprovalReqd.label" bundle="${or_labels}"/></th>
	<th class='columnheader' width='15%'><fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/></th>
	<!--            <td class='columnheader' width='15%'><fmt:message key="eOR.OrderCatalog.label" bundle="${or_labels}"/></td>
	<td class='columnheader' width='15%'><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width='15%'><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width='3%'><fmt:message key="eOR.Qty.label" bundle="${or_labels}"/></td>
	<td class='columnheader' width='10%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width='10%'><fmt:message key="eOR.Formats.label" bundle="${or_labels}"/></td>
	<td class='columnheader' width='10%'>&nbsp;</td> -->
</tr>


</table>

<input type=hidden name='bean_id' id='bean_id' value='<%=bean_id%>'>
<input type=hidden name='bean_name' id='bean_name' value='<%=bean_name%>'>
<input type=hidden name='orderId' id='orderId' value='<%=orderId%>'>
<input type=hidden name='localeName' id='localeName' value='<%=localeName%>'>

<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">

</body>
</form>
</html>

<%
	putObjectInBean(bean_id,bean,request);
%>

