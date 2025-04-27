<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="alTrayDiscrepancyList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eSS/js/TrayDiscrepancy.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eSS/js/SsTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

	</head>
<body onMouseDown="CodeArrest()">
<form name='formTrayDiscrepancyList' id='formTrayDiscrepancyList' >
	<table border='1' cellpadding='0' cellspacing='0' width='455' >
		<tr>
			<th><fmt:message key="eSS.Del.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eSS.DiscReason.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eSS.Usage.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.Finalized.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
		</tr>
<%
	TrayDiscrepancyListBean bean = (TrayDiscrepancyListBean)getBeanObject( "trayDiscrepancyListBean",  "eSS.TrayDiscrepancyListBean",request) ;  
	bean.setLoginFacilityId((String)session.getAttribute("facility_id"));
	
	String disabled				=		"";
	HashMap hmRecord			=		new HashMap();
	String className			=		"";
	int i;

	for	(i	=0;	i<alTrayDiscrepancyList.size();i++){
		hmRecord				=		(HashMap)	alTrayDiscrepancyList.get(i);
		bean.initialize(hmRecord);
		String deleteDisabled	=		"";
		if( (bean.getUsage_ind().equals("U")||bean.getUsage_ind().equals("R")) && bean.getFinalized_yn().equals("N"))
			deleteDisabled		=		"disabled";
			className			=		((i%2)==0)?"QRYODD":"QRYEVEN";
%>
	<tr>
		<td nowrap class="<%=className%>" ><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=disabled%> <%=deleteDisabled%>></td>
		<td nowrap class="<%=className%>"><%if(disabled.equals("")){%><a href="javascript:listModify(<%=i%>);"><%}%><%=bean.getItem_desc()%></a></td>
		<td nowrap class="<%=className%>"><%=bean.getWrite_off_reason_desc()%></td>
		<td nowrap class="<%=className%>" ><%=bean.checkForNull(bean.getDiscrepancy_qty(),"&nbsp;")%></td>
		<td nowrap class="<%=className%>" ><%=bean.getUsage_indLegend(bean.getUsage_ind())%></td>
		<td nowrap class="<%=className%>"><%=bean.getImage(bean.getFinalized_yn())%></td>
		<td nowrap class="<%=className%>" ><%=bean.getInitRemarks()%></td>
	</tr>
<%
}
%>
	</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
</form>
	<%	putObjectInBean("trayDiscrepancyListBean",bean,request);

%>
</body>

</html>


