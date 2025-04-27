<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page    import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%> 
<jsp:useBean id="alPackingDiscrepancyList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eSS/js/Packing.js"></script>	
		<script language="JavaScript" src="../../eSS/js/SsCommon.js"></script>	
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>	
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<body  onUnload="preserveDiscrepancyDetails();">
<form name='formPackingDiscrepancyList' id='formPackingDiscrepancyList' >

	<table border='1' cellpadding='0' cellspacing='0' width='100%'>
		<tr>
			<th><fmt:message key="eSS.Del.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.Instrument.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.DiscrepancyReason.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
		</tr>
<%
	PackingDiscrepancyListBean bean		=	 (PackingDiscrepancyListBean)getBeanObject( "packingDiscrepancyListBean", "eSS.PackingDiscrepancyListBean",request  ) ;  
	String disabled						=	"";
	HashMap hmRecord					=	new HashMap();
	String className					=	"";
	int i=0;
	int iRecordCounter=1;
	for	(i	=0;	i<alPackingDiscrepancyList.size();i++){
		hmRecord						=	(HashMap)	alPackingDiscrepancyList.get(i);
		
		if(!bean.initialize(hmRecord))continue;
		iRecordCounter++;
		className						=	((iRecordCounter%2)==0)?"QRYODD":"QRYEVEN";

%>
	<tr>
		<td	class="<%=className%>" align='center'><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=bean.getChecked(bean.getMarkedAsDelete())%> <%=disabled%>></td>
		<td	class="<%=className%>"><a href="javascript:discrepancyListModify(<%=i%>);"><%=bean.getItem_desc()%></a></td>
		<td	class="<%=className%>"><%=bean.getWrite_off_reason_desc()%></td>
		<td	class="<%=className%>"align='right'><%=bean.getDiscrepancy_qty()%></td>
		<td	class="<%=className%>"><%=bean.getInitRemarks()%></td>
	</tr>
<%
}
%>
	</table>
	<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
</form>
<%
putObjectInBean("packingDiscrepancyListBean",bean,request);
%>
</body>

</html>

