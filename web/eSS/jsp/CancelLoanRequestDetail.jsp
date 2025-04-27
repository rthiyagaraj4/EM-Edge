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
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Create History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
11/02/2014	       		BRU-HIMS-CRF-225.1	    Sakti Sankar	   11/02/2014	    Sakti Sankar			 Newly Created
--------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>


<%@ page import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="alCancelRequestList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eSS/js/CancelLoanRequest.js'></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language='javascript' src='../../eSS/js/SsCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">

	</head>
<%
	CancelLoanRequestListBean bean		=		(CancelLoanRequestListBean) getBeanObject( "cancelLoanRequestListBean", "eSS.CancelLoanRequestListBean", request ) ; 
	CancelLoanRequestBean bean1		=		(CancelLoanRequestBean) getBeanObject( "cancelLoanRequestBean", "eSS.CancelLoanRequestBean", request ) ;  
	bean.setLoginFacilityId((String)session.getAttribute("facility_id"));
	HashMap hmRecord				=		new HashMap();
	String className				=		"";
	String checked = "";
	String disabled = "";
	%>	

	<body onMouseDown="CodeArrest()" >
		<form name="formCancelRequestDetail" id="formCancelRequestDetail" >
			<table border="1" cellpadding="0" cellspacing="0" width='100%' align='center'>
				<tr>
					<th><fmt:message key="eSS.GroupCode.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
					<th width=150><fmt:message key="eSS.RequestedQuantity.label" bundle="${ss_labels}"/></th>
					<th width=150><fmt:message key="eSS.IssuedQuantity.label" bundle="${ss_labels}"/></th>
					<%if(bean1.getAckReqd()) {%>
					<th width=200><fmt:message key="eSS.PendingForAcknowledgeQuantity.label" bundle="${ss_labels}"/></th>
					<th>Reject Quantity</th>
					<%}%>
					<th width=100><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
					<input type="checkbox" value="Y" name="cancelAll" id="cancelAll"   onClick="return toggleCheck(this);" checked></th>
					
				</tr>
<%
		int i;
	   String issue_qty="";
	   String blocked_qty="";
	   String reject_qty="";
	   boolean exist= false;
	for	(i	=0;	i<alCancelRequestList.size();i++){
		hmRecord				=		(HashMap)	alCancelRequestList.get(i);
					
		bean.initialize(hmRecord);
		if(bean.getIssue_qty()==null)
		{
		   	issue_qty="";
			blocked_qty="";
		} else
			{
			issue_qty=bean.getIssue_qty();
			blocked_qty=bean.getBlocked_qty();
			reject_qty=bean.getReject_qty();
		}
		
		//Added for checked and unchecked, enable and disable checkbox based on condition below
		if(Integer.parseInt(issue_qty+blocked_qty+reject_qty)>0){
			checked = "";
			disabled ="disabled";
			exist = true;
		}else{
			checked = "checked";
			disabled ="";
			exist = false;
		}
		//Added ends

		className				=		((i%2)==0)?"QRYODD":"QRYEVEN";
%>
	<tr>
		<td class="<%=className%>"><%=(String)hmRecord.get("req_group_code")%></td>
		<td class="<%=className%>"><%=(String)hmRecord.get("description")%></td>
		<td class="<%=className%>" style="TEXT-ALIGN:right"><%=(String)hmRecord.get("request_qty")%></td>
		<td class="<%=className%>" style="TEXT-ALIGN:right"><%=bean.checkForNull(issue_qty)%></td>
		<%if(bean1.getAckReqd()) {%>
		<td class="<%=className%>" style="TEXT-ALIGN:right"><%=bean.checkForNull(blocked_qty)%></td>
		<td class="<%=className%>" style="TEXT-ALIGN:right"><%=bean.checkForNull(reject_qty)%></td>
		<%}%>
		
		<td class="<%=className%>" ><div align="center"> <input type="checkbox"  name="group_code_<%=i%>" id="group_code_<%=i%>"  value="<%=(String)hmRecord.get("req_group_code")%>-<%=(String)hmRecord.get("request_qty")%>" onclick="updateSelection();" <%=checked%> <%=disabled%>></td>
			
	</tr>
<%
}
%>

		<input type="hidden" name="checkedIndices" id="checkedIndices"			value="" >
		<input type="hidden" name="total_check_boxes" id="total_check_boxes"		value="<%=i%>">
		<input type="hidden" name="bean_id" id="bean_id"					value="<%="cancelRequestBean"%>">
		<input type="hidden" name="bean_name" id="bean_name"				value="<%= "eSS.CancelRequestBean"%>">
		<input type="hidden" name="doc_type_code" id="doc_type_code"			value="" >
		<input type="hidden" name="doc_no" id="doc_no"					value="" >
		<input type="hidden" name="doc_date" id="doc_date"				value="" >
		<input type="hidden" name="req_by_store_code" id="req_by_store_code"		value="" >
		<input type="hidden" name="req_on_store_code" id="req_on_store_code"		value="" >
		<input type="hidden" name="doc_ref" id="doc_ref"					value="" >
		<input type="hidden" name="added_by_id" id="added_by_id"				value="" >
		<input type="hidden" name="added_by_name" id="added_by_name"			value="" >
		<input type="hidden" name="request_type" id="request_type"			value="" >
		<input type="hidden" name="cancelled_remarks" id="cancelled_remarks"		value="" >
		<input type="hidden" name="mode" id="mode"					value="" >
		<input type="hidden" name="exist" id="exist"					value="<%=exist%>" >
		

			</table>
		</form>
		
			<script>
					//Added to disable cancell All check box if there is any issue qty exist		
					if(document.formCancelRequestDetail.exist.value=="true"){
						document.formCancelRequestDetail.cancelAll.disabled = true;
						document.formCancelRequestDetail.cancelAll.checked = false;
						}else{
							document.formCancelRequestDetail.cancelAll.disabled = false;
							document.formCancelRequestDetail.cancelAll.checked = true;
						}
						//updateSelection();
						//Added ends
			</script>
<%
	putObjectInBean("cancelRequestListBean",bean,request);
	putObjectInBean("cancelRequestBean",bean1,request);
%>
	</body>
</html>
 

