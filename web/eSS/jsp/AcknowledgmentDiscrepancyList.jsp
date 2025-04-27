<!DOCTYPE html>

<%@page    import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%> 
<jsp:useBean id="alAckDiscrepancyList" scope="session" class="java.util.ArrayList"/>
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
		<script language="JavaScript" src="../../eSS/js/SSAcknowledgment.js"></script>	
		<script language="JavaScript" src="../../eSS/js/SsCommon.js"></script>	
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>	
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<body  onUnload="preserveDiscrepancyDetails();">
<form name='formAckDiscrepancyList' id='formAckDiscrepancyList' >

	<table border='1' cellpadding='0' cellspacing='0' width='100%'>
		<tr>
			<th><fmt:message key="eSS.Del.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.Instrument.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.DiscrepancyReason.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
		</tr>
<%
	AckDiscrepancyListBean bean		=	(AckDiscrepancyListBean)getBeanObject( "AckDiscrepancyListBean", "eSS.AckDiscrepancyListBean",request );  
	String disabled						=	"";
	HashMap hmRecord					=	new HashMap();
	String className					=	"";
	int i=0;
	int iRecordCounter=1;
	for	(i	=0;	i<alAckDiscrepancyList.size();i++){
		hmRecord						=	(HashMap)	alAckDiscrepancyList.get(i);
		
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
putObjectInBean("AckDiscrepancyListBean",bean,request);
%>
</body>

</html>

