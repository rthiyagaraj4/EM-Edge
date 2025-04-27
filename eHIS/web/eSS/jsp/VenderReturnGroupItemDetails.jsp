<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
31/08/2015	IN056823		Ramesh G										The Owner Store users access the newly introduced  'Return Vendor Loan' functionality
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@	page import="eSS.VendorLoanReturnBean, eCommon.Common.*,eSS.Common.*, eSS.*,java.util.*,java.sql.* ,java.lang.*,webbeans.eCommon.*,java.util.ArrayList,java.util.HashMap" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@	include file="../../eCommon/jsp/CommonBean.jsp" %>

<%-- Mandatory declarations end --%>

<html>
	<head>
		<title><fmt:message key="eSS.GroupItemDetails.label" bundle="${ss_labels}"/></title>
		
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle				 =		 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="Javascript" src="../../eSS/js/VendorLoanReturn.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<body onload="window.scrollTo(0,0)">
<%

	String	doc_no			=	request.getParameter( "doc_no" ) ;
	String	doc_type_code	=	request.getParameter( "doc_type_code" ) ;
	String	doc_type		=	request.getParameter( "doc_type" ) ;
	String	doc_date		= 	request.getParameter( "doc_date" ) ;
	String	storeSelText	= 	request.getParameter( "storeSelText" ) ;
	String	vendorSelText	= 	request.getParameter( "vendorSelText" ) ;
	String	checklist_code 		= 		"";
	String bean_id 				= "VendorLoanReturnBean" ;
	String bean_name 			= "eSS.VendorLoanReturnBean";

	VendorLoanReturnBean bean = (VendorLoanReturnBean)getBeanObject( bean_id,  bean_name,request );
		
try{
	String classvalue				=		"";
	ArrayList alRecords	= new ArrayList();	
	HashMap hmGroupRecord 					= 		null;	
	alRecords = (ArrayList)bean.getSelectedList(doc_no,doc_type_code);	
	%>
	<form name="VenderReturnGroupItemDetailForm" id="VenderReturnGroupItemDetailForm">		
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<tr>
		<th width="12%"><fmt:message key="eSS.GroupCode.label" bundle="${ss_labels}"/></th>
		<th width="12%"><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/></th>
		<th width="12%"><fmt:message key="eSS.SurgeyType.label" bundle="${ss_labels}"/></th>
		<th width="12%"><fmt:message key="eSS.SurgeyName.label" bundle="${ss_labels}"/></th>
		<th width="10%"><fmt:message key="eSS.RequestQty.label" bundle="${ss_labels}"/></th>
		<th width="10%"><fmt:message key="eSS.AckQty.label" bundle="${ss_labels}"/></th>
		<th width="32%"><fmt:message key="eSS.AcknowledgementRemarks.label" bundle="${ss_labels}"/></th>
		</tr>

	<%
		for( int i=0; i<alRecords.size();i++) {
			hmGroupRecord = (HashMap) alRecords.get(i);		
			classvalue	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
	%>
			<script>var group_desc_<%=i%>=encodeURIComponent("<%=hmGroupRecord.get("GROUP_DESC")%>");</script>
			<tr>
				<td class="<%=classvalue%>" width='12%' onmouseover="changeCursor(this);"  onclick="groupDetails('<%=hmGroupRecord.get("REQ_GROUP_CODE")%>',group_desc_<%=i%>)"><font class="HYPERLINK"><%=(String)hmGroupRecord.get("REQ_GROUP_CODE")%></font></td>
				<td class="<%=classvalue%>" width='12%' onmouseover="changeCursor(this);"  onclick="groupDetails('<%=hmGroupRecord.get("REQ_GROUP_CODE")%>',group_desc_<%=i%>)"><font class="HYPERLINK"><%=(String)hmGroupRecord.get("GROUP_DESC")%></font></td>
				<td class="<%=classvalue%>" width='12%' ><%=bean.checkForNull((String)hmGroupRecord.get("SURGERY_TYPE"),"&nbsp;")%></td>
				<td class="<%=classvalue%>" width='12%' ><%=bean.checkForNull((String)hmGroupRecord.get("SURGERY_DESC"),"&nbsp;")%></td>
				<td class="<%=classvalue%>" width='10%' ><%=(String)hmGroupRecord.get("REQUEST_QTY")%></td>
				<td class="<%=classvalue%>" width='10%' ><%=(String)hmGroupRecord.get("ACK_QTY")%></td>
				<td class="<%=classvalue%>" width='32%' ><%=bean.checkForNull((String)hmGroupRecord.get("REMARKS"),"&nbsp;")%></td>
			</tr> 
	<%
		}
	%>
	
</table>
	</form>	
		
	<%
		out.flush();	
	
} catch(Exception e) {
	// out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0185
}
%>

<%
putObjectInBean(bean_id,bean,request); 
%>
</body>
</html>
   

