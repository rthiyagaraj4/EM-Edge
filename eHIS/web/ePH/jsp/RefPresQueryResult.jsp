<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>-->
	<script language="JavaScript" src="../../ePH/js/RefPres.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="frmReferralPrescriptionReportResult" id="frmReferralPrescriptionReportResult" >
<%
	String bean_id		= "PHReportsBean" ;
	String bean_name	= "ePH.PHReportsBean";

	PHReportsBean bean = (PHReportsBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);

	String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
	
	String order_date_from = CommonBean.checkForNull(request.getParameter("order_date_from"));
	String order_date_to = CommonBean.checkForNull(request.getParameter("order_date_to"));
	String order_by = CommonBean.checkForNull(request.getParameter("order_by"));
	ArrayList result = bean.getRefferedPrescriptions(patient_id,order_date_from,order_date_to,order_by);

	if( result.size()>=1){
	%>
		<table cellpadding=0 cellspacing=0 align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;</td>
			</tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th ><fmt:message key="ePH.ReferredFacility.label" bundle="${ph_labels}"/></th><th ><fmt:message key="Common.ReferredPractitioner.label" bundle="${common_labels}"/></th><th ><fmt:message key="ePH.PrescriptionNo.label" bundle="${ph_labels}"/> </th><th ><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></th><th><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th><th><fmt:message key="ePH.ReferredRemarks.label" bundle="${ph_labels}"/></th>
	<%
		HashMap record=new HashMap();
		for (int i=0;i<result.size();i++){
			record= (HashMap) result.get(i);
			String classvalue="";
			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	%>
		<tr>
			
			<td class="<%=classvalue%>" style="font-size=9">&nbsp; <%=record.get("ReferredFacility")%></td>
			<td class="<%=classvalue%>" style="font-size=9">&nbsp; <%=record.get("ReferredPractitioner")%></td>
			<td class="<%=classvalue%>" style="font-size=9">&nbsp;<font class="hyperlink" style="cursor:pointer" onClick="showReport('PHREFLTR','<%=record.get("ReferredFacility")%>','<%=record.get("orderId")%>','<%=record.get("dispNo")%>')" > <%=record.get("orderId")%></td>
			<td class="<%=classvalue%>" style="font-size=9">&nbsp; <font class="hyperlink" style="cursor:pointer" onClick="showReport('PHREFLTR','<%=record.get("ReferredFacility")%>','<%=record.get("orderId")%>','<%=record.get("dispNo")%>')" ><%=record.get("dispNo")%></td>
			<td class="<%=classvalue%>" style="font-size=9">&nbsp; <%=record.get("disp_locn_desc")%></td>
			<td class="<%=classvalue%>" style="font-size=9">&nbsp;<font class="hyperlink" style="cursor:pointer" onClick="showReport('PHREFLTR','<%=record.get("ReferredFacility")%>','<%=record.get("orderId")%>','<%=record.get("dispNo")%>')" > <%=record.get("ReferredRemarks")%></td>

		</tr>
	<%
		}
	}else{
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
	<%
	}
	%>

	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	<input type="hidden" name="patient_id" id="patient_id" value="">
	<input type="hidden" name="order_date_from" id="order_date_from" value="">
	<input type="hidden" name="order_date_to" id="order_date_to" value="">
</form>

<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

