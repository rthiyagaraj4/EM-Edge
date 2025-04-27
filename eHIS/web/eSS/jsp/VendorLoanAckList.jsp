<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.VendorLoanAckBean,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language='javascript' src='../../eSS/js/VendorLoanAck.js'></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script> 
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String facility_id				=		(String) session.getValue( "facility_id" ) ;
		String classvalue			= "";
		String doc_no				= request.getParameter("doc_no");
		String doc_type_code		= request.getParameter("doc_type_code");
		String hdr_index			= request.getParameter("index");
		String fm_vendor_code		= request.getParameter("fm_vendor_code");
		String to_store_code		= request.getParameter("to_store_code");
		String surgery_type			=		"";
		String surgery_name			=		"";
		HashMap Arrchkitem			=		new HashMap();
		ArrayList arrChkGrpDoc		= 		new ArrayList();
		String checked_yn	    =	request.getParameter("checked_yn");
		String checked					=		"checked";

		VendorLoanAckBean bean	=	(VendorLoanAckBean) getBeanObject( "VendorLoanAckBean","eSS.VendorLoanAckBean",request );
		bean.setLanguageId(locale);
		bean.setToStore(to_store_code);
	%>
	<body onload='' >
	<form name="formAcknowledgeList" id="formAcknowledgeList">
	<%
		ArrayList result = (ArrayList)bean.getTFRExpRecords(doc_no);
	
		if(result.size()<=0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}else{
	%>
	<table border='1' cellpadding='0' cellspacing='0' width=100% align=center>
		<tr>
			<th><fmt:message key="eSS.GroupCode.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.GroupDescription.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.SurgeryName.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.SurgeryType.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.RequestQty.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.IssueQtyAck.label" bundle="${ss_labels}"/></th>
			<th ><fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/></th>
			<th ><fmt:message key="eSS.AcknRemarks.label" bundle="${ss_labels}"/></th>
		</tr>
		<%
	    ArrayList alTemp	= null;
		HashMap   hmTemp	= null;
		String 	  remarks	= "" ;
		String count	= "";
		String group_code = "";
		String tray_no  ="";
		Arrchkitem						=		bean.getalGroupRecords();
		//arrChkGrpDoc 					=		bean.getalGrpRecords();
		if(Arrchkitem.size()>0) {
			Set set = Arrchkitem.keySet();
		    Iterator iter = set.iterator();
		    while (iter.hasNext()) {
		      StringTokenizer doc_no_val = new StringTokenizer((String)iter.next(), "-");
		      arrChkGrpDoc.add(doc_no_val.nextToken().trim());
		    }
		}
		
		HashMap hmRecord = new HashMap();
		for(int i=0;i<result.size();i++){
			if (i % 2 == 0)
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			   	hmRecord = (HashMap)result.get(i); 
			   	checked = "checked";
				if(Arrchkitem.size()>0) {
					if (arrChkGrpDoc.contains(doc_no)){
						if(! Arrchkitem.containsKey(doc_no+"-"+(String)hmRecord.get("GROUP_CODE") ) )
							checked = "";
					}else if(! checked_yn.equals("true")){
						checked = "";
					}
				}else if(! checked_yn.equals("true")){
					checked = "";
				}
				surgery_type	=bean.checkForNull((String)hmRecord.get("SURGERY_TYPE"),"&nbsp;");
				surgery_name	=bean.checkForNull((String)hmRecord.get("SURGERY_DESC"),"&nbsp;");
		%>
		<script>var group_desc_<%=i%>=encodeURIComponent("<%=hmRecord.get("GROUP_DESC")%>");</script>
			<tr>
			
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="details('<%=hmRecord.get("GROUP_CODE")%>',group_desc_<%=i%>);"><font class="HYPERLINK"><%=hmRecord.get("GROUP_CODE")%></font></td>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="details('<%=hmRecord.get("GROUP_CODE")%>',group_desc_<%=i%>);"><font class="HYPERLINK"><%=hmRecord.get("GROUP_DESC")%></font></td>
				<td class="<%=classvalue%>"><%=surgery_name%></td>
				<td class="<%=classvalue%>"><%=surgery_type%></td>
				<td class="<%=classvalue%>"><%=hmRecord.get("REQUEST_QTY")%></td>
				<td class="<%=classvalue%>"><%=hmRecord.get("REQUEST_QTY")%></td>
				<td class="<%=classvalue%>" align='center'><div align="center"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" onclick="saveVals('<%=i%>');" onblur="" value="<%=doc_no+"-"+(String)hmRecord.get("GROUP_CODE") %>" <%=checked %> ></div></td>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="showRemarks('<%=i%>','List');"><font class="HYPERLINK"><fmt:message key="eSS.AcknRemarks.label" bundle="${ss_labels}"/></font></td>
				
				
				<input type="hidden" name="group_code_<%=i%>" id="group_code_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("GROUP_CODE"))%>">
				<input type="hidden" name="remarks_<%=i%>" id="remarks_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("REMARKS"))%>">
<%
					}
%>
				 
				
				</td>
			</tr>

		<table>
	<input type="hidden" name="doc_no" id="doc_no" value="<%=doc_no%>">
	<input type="hidden" name="total_records" id="total_records" value="<%=result.size()%>">
	<input type="hidden" name="hdr_index" id="hdr_index" value="<%=hdr_index%>">
	<input type="hidden" name="fm_vendor_code" id="fm_vendor_code" value="<%=fm_vendor_code%>">
	<input type="hidden" name="to_store_code" id="to_store_code" value="<%=to_store_code%>">
	<input type="hidden" name="bean_id" id="bean_id" value="VendorLoanAckBean">
	<input type="hidden" name="bean_name" id="bean_name" value="eSS.VendorLoanAckBean">
	<input type="hidden" name="index" id="index" value="<%=result.size()%>">
	<input type="hidden" name="doc_type_code" id="doc_type_code" value="<%=doc_type_code%>">
	 
	
	</table>
	<%}%>
	</form>
	</body>
</html>
 

