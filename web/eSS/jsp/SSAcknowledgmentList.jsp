<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
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
		<script language='javascript' src='../../eSS/js/SSAcknowledgment.js'></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script> 
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
	try{
		String facility_id				=		(String) session.getValue( "facility_id" ) ;
		String classvalue			= "";
		String disable				= "";
		String doc_no				= request.getParameter("doc_no");
		String doc_type_code		= request.getParameter("doc_type_code");
		String seq_no				= request.getParameter("seq_no");
		String hdr_index			= request.getParameter("index");
		String fm_store_code		= request.getParameter("fm_store_code");
		String to_store_code		= request.getParameter("to_store_code");
		String confirm_yn			= request.getParameter("confirm_yn");
		String confirm_reqd_yn		= request.getParameter("confirm_reqd_yn");
		String req_doc_no			= request.getParameter("req_doc_no");
		String req_doc_type_code	= request.getParameter("req_doc_type_code");
		String action_type			= request.getParameter("action_type");	
		String trn_type				=	request.getParameter("trn_type"); //Added by Sakti against BRU-HIMS-CRF-376
		String visibility			= "visibility:hidden";
		String selected				= "";

		SSAcknowledgementBean bean	=	(SSAcknowledgementBean) getBeanObject( "SSAcknowledgementBean","eSS.SSAcknowledgementBean",request );
		bean.setLanguageId(locale);
		bean.setToStore(to_store_code);
		if(((String)bean.getAction_type()).equals("C")){
			disable			=	"disabled";
			visibility		=	"visibility:visible";
			selected		=   "selected";
			
		}
		
	if(trn_type.equals("ISS")) {
	%>
	<body onload='' >
	<%}else{ %>
	<body onload='' onclick='hidePopup();'>
	<%} %>
	<form name="formAcknowledgeList" id="formAcknowledgeList">
	<%
		ArrayList result = (ArrayList)bean.getTFRExpRecords(doc_no+"~"+seq_no);
	System.out.println("result"+result);
		if(result.size()<=0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}else{
	%>
	<table border='1' cellpadding='0' cellspacing='0' width=100% align=center>
		<tr>
			<th><fmt:message key="eSS.GroupDescription.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
			<%if(action_type.equals("C")) {%>
		<th><fmt:message key="eSS.SeqNo.label" bundle="${ss_labels}"/></th>
		<%}%>
			<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
			<th ><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></th>
			<th ><fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.AckRemarks.label" bundle="${ss_labels}"/></th>
			<%if(trn_type.equals("ISS")) {%>
			<th ><fmt:message key="eSS.TrayDiscrepancyRemarks.label" bundle="${ss_labels}"/></th>
			<%}if(trn_type.equals("RTG")) {%>
			<th ><fmt:message key="eSS.ReturnRemarks.label" bundle="${ss_labels}"/></th>
			<th >Discrepancy Remarks</th>
			<%} %>
		</tr>
		<%
	    ArrayList alTemp	= null;
		HashMap   hmTemp	= null;
		String 	  remarks	= "" ;
		String count	= "";
		String group_code = "";
		String tray_no  ="";
		
		HashMap hmRecord = new HashMap();
		for(int i=0;i<result.size();i++){
			if (i % 2 == 0)
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			   hmRecord = (HashMap)result.get(i);
			   
			   remarks					=			bean.checkForNull((String)hmRecord.get("RET_REMARKS"));
			   remarks					=			java.net.URLEncoder.encode(remarks,"UTF-8");
			 
			   if(bean.checkForNull((String)hmRecord.get("ACKNOWLEDGE_STATUS")).equals("R") && action_type.equals("A")) {
				   visibility		=	"visibility:visible";
			   }else if((bean.checkForNull((String)hmRecord.get("ACKNOWLEDGE_STATUS")).equals("A") || bean.checkForNull((String)hmRecord.get("ACKNOWLEDGE_STATUS")).equals("P")) && action_type.equals("A")) {
				   visibility		=	"visibility:hidden";
			   } //else part added by Sakti against inc#45344 linked to BRU-HIMS-CRF-376 not to display mendatory image for Acknowledge and pending
			
			  
	%>
			<tr>
			
				<td class="<%=classvalue%>"><%=hmRecord.get("GROUP_DESC")%></td>			
				<td class="<%=classvalue%>"><%=hmRecord.get("TRAY_NO")%></td>
			<%if(action_type.equals("C")) {%>
				<td class="<%=classvalue%>"> <%=hmRecord.get("SEQ_NO")%></td>
			<%}%>
			
				<td class="<%=classvalue%>"><%=hmRecord.get("EXPIRY_DATE")==null?"&nbsp;":hmRecord.get("EXPIRY_DATE")%></td>
				<td class="<%=classvalue%>"><%=hmRecord.get("BIN_LOCATION_CODE")%></td>
				<td class="<%=classvalue%>"><select name="acknowledge_atatus_<%=i%>" id="acknowledge_atatus_<%=i%>" onchange="showRemarksImg(img_<%=i%>,<%=i%>)" <%=disable%> >											
											<option value="A" <%=bean.checkForNull((String)hmRecord.get("ACKNOWLEDGE_STATUS")).equals("A")?"Selected":bean.checkForNull((String)hmRecord.get("ACKNOWLEDGE_STATUS"))%>><fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/></option>
											<option value="R" <%=bean.checkForNull((String)hmRecord.get("ACKNOWLEDGE_STATUS")).equals("R")?"Selected":bean.checkForNull((String)hmRecord.get("ACKNOWLEDGE_STATUS"))%> <%=selected%>><fmt:message key="eSS.Reject.label" bundle="${ss_labels}"/></option>
											<option value="P" <%=bean.checkForNull((String)hmRecord.get("ACKNOWLEDGE_STATUS")).equals("P")?"Selected":bean.checkForNull((String)hmRecord.get("ACKNOWLEDGE_STATUS"))%>><fmt:message key="eSS.Pending.label" bundle="${ss_labels}"/></option></td>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="showRemarks(<%=i%>);"><font class="HYPERLINK"><fmt:message key="eSS.AckRemarks.label" bundle="${ss_labels}"/></font><img id="img_<%=i%>"  src="../../eCommon/images/mandatory.gif" style="<%=visibility%>"/>
				<!-- Added by Sakti against BRU-HIMS-CRF-376 -->
				<%if(trn_type.equals("ISS")) {%>
				<%if(Integer.parseInt((String)hmRecord.get("COUNT_TRAY_DISC")) > 0) {%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="showDiscrepancyRemarks('<%=i%>');"><font class="HYPERLINK"><fmt:message key="eSS.TrayDiscrepancyRemarks.label" bundle="${ss_labels}"/></font></td>
				<%}else{ %>
				<td class="<%=classvalue%>"><fmt:message key="eSS.TrayDiscrepancyRemarks.label" bundle="${ss_labels}"/></td>
				<%} }%>
				<%if(trn_type.equals("RTG")) {%>
				<%if(!remarks.equals("")){%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="showReturnRemarks('<%=remarks%>');"><font class="HYPERLINK"><fmt:message key="eSS.ReturnRemarks.label" bundle="${ss_labels}"/></font></td>
				<%} else {%>
				<td class="<%=classvalue%>"><fmt:message key="eSS.ReturnRemarks.label" bundle="${ss_labels}"/></td>
				<%} if(Integer.parseInt((String)hmRecord.get("COUNT_RET_DISC")) > 0 || Integer.parseInt((String)hmRecord.get("COUNT_TRAY_DISC")) > 0 ) {%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="showPopup('<%=i%>','<%=bean.checkForNull((String)hmRecord.get("COUNT_TRAY_DISC"))%>','<%=bean.checkForNull((String)hmRecord.get("COUNT_RET_DISC"))%>');"><font class="HYPERLINK"><fmt:message key="eSS.DiscrepancyRemarks.label" bundle="${ss_labels}"/></font></td>

				<%}else{ %>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="showPopup('<%=i%>','<%=bean.checkForNull((String)hmRecord.get("COUNT_TRAY_DISC"))%>','<%=bean.checkForNull((String)hmRecord.get("COUNT_RET_DISC"))%>');"><font class="HYPERLINK"><fmt:message key="eSS.DiscrepancyRemarks.label" bundle="${ss_labels}"/></font></td><!-- Added onclick and font for TH-KW-CRF-0026 -->
				<%}%>
				<div id="manage_menu" style="border: 1px solid black;width:150px"   onmouseover="over()" onMouseout="out()" onclick="showWindow('<%=doc_no%>','<%=doc_type_code%>','<%=facility_id%>','<%=bean.checkForNull((String)hmRecord.get("COUNT_TRAY_DISC"))%>','<%=bean.checkForNull((String)hmRecord.get("COUNT_RET_DISC"))%>');">
				<div id='tray_disc' style="background-color:#83AAB4" class="manage_menuitem"  value='T'><fmt:message key="eSS.TrayDiscrepancy.label" bundle="${ss_labels}"/></div>
				<div id='ret_disc' style="background-color:#83AAB4" class="manage_menuitem" value='R'><fmt:message key="eSS.ReturnDiscrepancy.label" bundle="${ss_labels}"/></div>
				<div id='ack_disc' style="background-color:#83AAB4" class="manage_menuitem" value='A'>Ack.Discrepancy</div></div><!-- Added for TH-KW-CRF-0026 -->
				<%} //Added ends%>
				
				<input type="hidden" name="remarks_<%=i%>" id="remarks_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("REMARKS"))%>">
				<input type="hidden" name="group_code_<%=i%>" id="group_code_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("ISSUE_GROUP_CODE"))%>">
				<input type="hidden" name="group_desc_<%=i%>" id="group_desc_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("GROUP_DESC"))%>">
				<input type="hidden" name="tray_no_<%=i%>" id="tray_no_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("TRAY_NO"))%>">
				<input type="hidden" name="expiry_date_<%=i%>" id="expiry_date_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("EXPIRY_DATE"))%>">
				<input type="hidden" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("BIN_LOCATION_CODE"))%>">
				<input type="hidden" name="doc_type_code_<%=i%>" id="doc_type_code_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("DOC_TYPE_CODE"))%>">
				<input type="hidden" name="req_group_code_<%=i%>" id="req_group_code_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("REQ_GROUP_CODE"))%>">
				<input type="hidden" name="ret_group_code_<%=i%>" id="ret_group_code_<%=i%>" value="<%=bean.checkForNull((String)hmRecord.get("RETURN_GROUP_CODE"))%>">
				
				
	
				 <%}
				%>
				 
				
				</td>
			</tr>


		<table>
	<input type="hidden" name="total_records" id="total_records" value="<%=result.size()%>">
	<input type="hidden" name="doc_no" id="doc_no" value="<%=doc_no%>">
	<input type="hidden" name="seq_no" id="seq_no" value="<%=seq_no%>">
	<input type="hidden" name="hdr_index" id="hdr_index" value="<%=hdr_index%>">
	<input type="hidden" name="fm_store_code" id="fm_store_code" value="<%=fm_store_code%>">
	<input type="hidden" name="to_store_code" id="to_store_code" value="<%=to_store_code%>">
	<input type="hidden" name="bean_id" id="bean_id" value="SSAcknowledgementBean">
	<input type="hidden" name="bean_name" id="bean_name" value="eSS.SSAcknowledgementBean">
	<input type="hidden" name="action_type" id="action_type" value="<%=(String)bean.getAction_type()%>">
	<input type="hidden" name="req_doc_no" id="req_doc_no" value="<%=req_doc_no%>">
	<input type="hidden" name="req_doc_type_code" id="req_doc_type_code" value="<%=req_doc_type_code%>">
	<input type="hidden" name="index" id="index" value="<%=result.size()%>">
	<input type="hidden" name="doc_type_code" id="doc_type_code" value="<%=doc_type_code%>">
	<input type="hidden" name="trn_type" id="trn_type" value="<%=trn_type%>">
	<input type="hidden" name="rec_no" id="rec_no" value=""><!-- Added for ICN-38140 point2 -->
	 
	
	</table>
	<%}%>
	</form>
	</body>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html>
 

