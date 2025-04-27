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
<%@ page import="eSS.VendorLoanReturnBean, eSS.Common.*,java.util.HashMap,java.util.ArrayList,java.lang.*,java.sql.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>		
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script> 
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/VendorLoanReturn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%

	String bean_id = "VendorLoanReturnBean";
	String bean_name = "eSS.VendorLoanReturnBean";
	VendorLoanReturnBean bean = (VendorLoanReturnBean) getBeanObject( bean_id,bean_name,request );
		bean.clearHashMaps();
		int i	= 0;
		
		String index=bean.checkForNull(request.getParameter("index"),"-1");
		
		String mode								=		request.getParameter("mode");
		String doc_type_code					=		request.getParameter("doc_type_code");
		String doc_no							=		bean.checkForNull(request.getParameter("doc_no"),"");
		String return_from_store_code			=		bean.checkForNull(request.getParameter("return_from_store_code"),"");
		String return_to_vendor_code			=		bean.checkForNull(request.getParameter("return_to_vendor_code"),"");
		String request_type						=		bean.checkForNull(request.getParameter("request_type"),"");
		String from_date						=		bean.checkForNull(request.getParameter("from_date"),"");
		String to_date							=		bean.checkForNull(request.getParameter("to_date"),"");
		String added_by_id						=		bean.checkForNull(request.getParameter("added_by_id"),"");
		String entry_completed_yn				=		bean.checkForNull(request.getParameter("entry_completed_yn"),"");
		
		ArrayList alGroupRecords				=		null;
		ArrayList alGroupCodeDtls				=		null;//Ramesh
		
		bean.setDoc_type_code(doc_type_code);
		bean.setDoc_no(doc_no);
		bean.setReturn_from_store_code(return_from_store_code);
		bean.setReturn_to_vendor_code(return_to_vendor_code);
		bean.setFrom_date(from_date);
		bean.setTo_date(to_date);
		bean.setAdded_by_id(added_by_id);
		bean.setEntry_completed_yn(entry_completed_yn);
		bean.setRequest_type(request_type);
		bean.setMode(mode);
		
		
		
		HashMap hmGroupRecord 					= 	null;
		String docNo							=	"";
		String docTypeCode						=	"";
		String docType							=	"";
		String docDate							=	"";
		String requestBy						=	"";
		String requestType						=	"";
		String loanReturnAllowedDtls			=	"";		
		String className						=	"";
		String docGroupDtls						= 	"";
		String totalDocNo						=	"";
		
		if ((mode == null) || (mode.equals("")))  
			return;
		if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		mode									=		mode.trim();
		
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			return_from_store_code = bean.getReturn_from_store_code();
			return_to_vendor_code	= bean.getReturn_to_vendor_code();
		}
		
		try { 			
			alGroupRecords = bean.getSelectedList(); 
	%>

		<body onMouseDown="CodeArrest();" >
			<form name='formVendorLoanReturnList' id='formVendorLoanReturnList'>
				<table border='1' width='100%' cellpadding='0' cellspacing='0' align="center">
					<tr>
						<th >
							<fmt:message key="eSS.Select.label" bundle="${ss_labels}"/> 
							<input type="checkbox" value="Y"  name="selectAll" id="selectAll"   onClick="clickSelectAll(this);" >
						</th>
						<th width='100'><fmt:message key="eSS.VendorLoanRequestDocNo.label" bundle="${ss_labels}"/></th>
						<th ><fmt:message key="eSS.IssDocType.label" bundle="${ss_labels}"/></th>
						<th ><fmt:message key="eSS.VendorLoanRequestDocDate.label" bundle="${ss_labels}"/></th>			
						<th width='180'><fmt:message key="eSS.Requestedby.label" bundle="${ss_labels}"/> </th>
						<th width='120'><fmt:message key="eSS.RequestedType.label" bundle="${ss_labels}"/></th>			
					</tr>
					<%
					for(i=0;i<alGroupRecords.size();i++){
						hmGroupRecord=(HashMap)alGroupRecords.get(i);
						
						docNo		=bean.checkForNull((String)hmGroupRecord.get("DOC_NO"));
						docTypeCode	=bean.checkForNull((String)hmGroupRecord.get("DOC_TYPE_CODE"));
						docType		=bean.checkForNull((String)hmGroupRecord.get("SHORT_DESC"));
						docDate		=bean.checkForNull((String)hmGroupRecord.get("DOC_DATE"));
						requestBy	=bean.checkForNull((String)hmGroupRecord.get("APPL_USER_NAME"));
						requestType	=bean.checkForNull((String)hmGroupRecord.get("REQUEST_TYPE"));						
						docGroupDtls=	bean.checkForNull((String)hmGroupRecord.get("RETURN_ALLOWEDDETAIL"));						
						if("".equals(totalDocNo))
							totalDocNo ="'"+docNo+"'";
						else
							totalDocNo =totalDocNo+",'"+docNo+"'";
						
						className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
						%>
							<tr>
								<td class="<%=className%>" align='center'><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" onclick="updateSelection('<%=i %>');" ></td>
								<td  class="<%=className%>"  onmouseover="changeCursor(this);"   onClick="details('<%=docNo%>','<%=docTypeCode%>','<%=docType %>','<%=docDate %>');"><font class="HYPERLINK"><%=docNo %></font>	</td>
								<td  class="<%=className%>"  ><%=docType %></td>
								<td  class="<%=className%>"  ><%=docDate %></td>
								<td  class="<%=className%>"  ><%=requestBy %></td>
								<td  class="<%=className%>"  ><%=requestType %></td>								
								<input type="hidden" name="DOC_NO<%=i %>" id="DOC_NO<%=i %>" value="<%=docNo %>"/>
								<input type="hidden" name="GROUP_DTLS<%=docNo %>" id="GROUP_DTLS<%=docNo %>" value="<%=docGroupDtls %>"/>
							</tr>
						<%
					}
					bean.loadHashMaps(totalDocNo);					
					%>
					
				</table>
				<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i %>"/>	
				
				<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
				<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
				<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
				<input type="hidden" name="bean_name" id="bean_name"				value="<%=bean_name%>">
				<input type="hidden" name="doc_type_code" id="doc_type_code" value="<%=doc_type_code %>"/>
				<input type="hidden" name="request_type" id="request_type" value="<%=request_type %>"/>
				<input type="hidden" name="from_date" id="from_date" value="<%=from_date %>"/>
				<input type="hidden" name="to_date" id="to_date" value="<%=to_date %>"/>
				<input type="hidden" name="added_by_id" id="added_by_id" value="<%=added_by_id %>"/>
				<input type="hidden" name="entry_completed_yn" id="entry_completed_yn" value="<%=entry_completed_yn %>"/>
				<input type="hidden" name="doc_ref" id="doc_ref" value=""/>
				<input type='hidden' name="authorized" id="authorized"				value="">
				<input type='hidden' name="autono_yn" id="autono_yn"				value="No">
				<input type='hidden' name="selectedTrayDetails" id="selectedTrayDetails"		value="-1">
				<input type='hidden' name="trn_type" id="trn_type"				value="RTV">
				<input type="hidden" name="doc_no" id="doc_no" value="<%=doc_no %>"/>
				<input type="hidden" name="totalDocNo" id="totalDocNo" value="<%=totalDocNo%>" />
				<input type="hidden" name="selectedLoanReturnDocNos" id="selectedLoanReturnDocNos" value=""/>				
			</form>
			<%
			putObjectInBean(bean_id,bean,request);
		}catch (Exception exception) {
			exception.printStackTrace();
			
		}				
		%>
			<script>
				if('2'=='<%=mode%>'){
					document.formVendorLoanReturnList.selectAll.checked = true;
					clickSelectAll(document.formVendorLoanReturnList.selectAll);
				}
			</script>
		</body>
</html>
  

