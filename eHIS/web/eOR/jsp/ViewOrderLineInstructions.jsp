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
--------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
28/07/2014		IN049419		Karthi L			24/08/2014		Ramesh			An Audit Trail for Additional Information Amendment of Order
15/09/2014		IN051122		Karthi L			15/09/2014		Ramesh			Audit History is not displayed at Task list after Register Order
23/07/2018		IN64543			Dinesh T		23/07/2018	Ramesh G		ML-MMOH-CRF-0776
--------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,eOR.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>  <!-- IN049419 -->
<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

String bean_id = "Or_ViewOrder" ;
String bean_name = "eOR.ViewOrder";
ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
bean.setLanguageId(localeName);
String call_from = request.getParameter("from")==null?"":request.getParameter("from");

//String orderId = "";
String line = request.getParameter("line")==null?"":request.getParameter("line");
System.out.println(" ViewOrderLineInstructions.jsp " + request.getQueryString());
String orderId = request.getParameter("order_id");
if(call_from.equalsIgnoreCase("line")){
	orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
}
else {
	orderId = request.getParameter("order_id")==null?"":request.getParameter("order_id");
}	
String order_line_num = request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
String field_mnemonic = request.getParameter("field_mnemonic")==null?"":request.getParameter("field_mnemonic");
String header_fld_mnemonic = request.getParameter("colval")==null?"":request.getParameter("colval");
String instrn_type = request.getParameter("instrn_type")==null?"":request.getParameter("instrn_type");//IN64543
int line_no = 0;
int max_seq = 0;
String base_max_sequ = "0";
String audit_comments_reqd = "Y"; //IN051122
//String maxSeqSql = "";//commented for checkstyle

if (order_line_num != null && order_line_num != "") {
	line_no = Integer.parseInt(order_line_num);
}

if(call_from.equalsIgnoreCase("line")) {
	if(header_fld_mnemonic.equalsIgnoreCase("Preps")) {
		field_mnemonic = "PAT_PREPS_TEXT";
%>	
	 	<title><fmt:message key="eOR.Preps.label" bundle="${or_labels}"/></title>  
<%
	}
	else if(header_fld_mnemonic.equalsIgnoreCase("Comments")) {
		field_mnemonic = "Comments"; 
%>	
		<title><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></title>
<%	}
	else if(header_fld_mnemonic.equalsIgnoreCase("Instructions")) {
		field_mnemonic = header_fld_mnemonic;
%>	
		<title><fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></title> 
<%	}	
}else {

	if(field_mnemonic.equalsIgnoreCase("PAT_PREPS_TEXT")) {
	%>	
		<title><fmt:message key="eOR.PrepsInstructions.label" bundle="${or_labels}"/></title>
	<%
	}
	else if(field_mnemonic.equalsIgnoreCase("DEPT_INSTRNS")) {
	%>	
		<title><fmt:message key="eOR.DepartmentInstructions.label" bundle="${or_labels}"/></title>
	<%}
	else if(field_mnemonic.equalsIgnoreCase("PATIENT_INSTRNS")) {
	%>	
		<title><fmt:message key="Common.PatientInstructions.label" bundle="${common_labels}"/></title>
	<% }
	else if(field_mnemonic.equalsIgnoreCase("Comments")) {
	%>
		<title><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></title>
	<%}
}

	base_max_sequ = bean.getOrderLineInstMaxCount(orderId, order_line_num, field_mnemonic);
	max_seq = Integer.parseInt(base_max_sequ);
	max_seq = max_seq + 1;
	
%>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<frameset rows='12%,90%'> 
	<!--<frame name='ViewHeaderCommentTop' id='ViewHeaderCommentTop' src='ViewOrderLineInstructionsTop.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&from=<%=call_from%>&colval=<%=header_fld_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>' frameborder=0   scrolling=no noresize> <!--  param 'audit_comments_reqd' added for IN051122 --><!--IN64543-->
	<frame name='ViewHeaderCommentTop' id='ViewHeaderCommentTop' src='ViewOrderLineInstructionsTop.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&from=<%=call_from%>&colval=<%=header_fld_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>&instrn_type=<%=instrn_type%>' frameborder=0   scrolling=no noresize> <!--  param 'audit_comments_reqd' added for IN051122 --><!--IN64543-->
	<%	
		if(call_from.equalsIgnoreCase("line")) {	
			if(header_fld_mnemonic.equalsIgnoreCase("Preps")) { %>
				<!--<frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='PrepsComment.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&from=<%=call_from%>&colval=<%=header_fld_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>' frameborder=0  scrolling=no  noresize>--> <!--  param 'audit_comments_reqd' added for IN051122 --><!--IN64543-->
				<frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='PrepsComment.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&from=<%=call_from%>&colval=<%=header_fld_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>&instrn_type=<%=instrn_type%>' frameborder=0  scrolling=no  noresize> <!--  param 'audit_comments_reqd' added for IN051122 --><!--IN64543-->
		<% } else if(header_fld_mnemonic.equalsIgnoreCase("Comments")) {%>
				<!--<frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='ViewLineComment.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&from=<%=call_from%>&colval=<%=header_fld_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>&audit_comments_reqd=<%=audit_comments_reqd%>' frameborder=0  scrolling=no  noresize>--> <!--  param 'audit_comments_reqd' added for IN051122 --><!--IN64543-->
				<frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='ViewLineComment.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&from=<%=call_from%>&colval=<%=header_fld_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>&audit_comments_reqd=<%=audit_comments_reqd%>&instrn_type=<%=instrn_type%>' frameborder=0  scrolling=no  noresize> <!--  param 'audit_comments_reqd' added for IN051122 --><!--IN64543-->
		<% } else if(header_fld_mnemonic.equalsIgnoreCase("Instructions")) {%>
				<!--<frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='ViewInstructions.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&from=<%=call_from%>&colval=<%=header_fld_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>' frameborder=0  scrolling=no  noresize> <!--  param 'audit_comments_reqd' added for IN051122 --><!--IN64543-->	
				<frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='ViewInstructions.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&from=<%=call_from%>&colval=<%=header_fld_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>&instrn_type=<%=instrn_type%>' frameborder=0  scrolling=no  noresize> <!--  param 'audit_comments_reqd' added for IN051122 --><!--IN64543-->
		<% } 
		} else {	
			if(field_mnemonic.equalsIgnoreCase("PAT_PREPS_TEXT")) { %>
				<!--<frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='ViewPrepsData.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>' frameborder=0  scrolling=no  noresize>--> <!--  param 'audit_comments_reqd' added for IN051122 --><!--IN64543-->
				<frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='ViewPrepsData.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>&instrn_type=<%=instrn_type%>' frameborder=0  scrolling=no  noresize> <!--  param 'audit_comments_reqd' added for IN051122 --><!--IN64543-->
		<% } else if(field_mnemonic.equalsIgnoreCase("DEPT_INSTRNS")) {%>
				<!--<frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='ViewDeptData.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>' frameborder=0  scrolling=no  noresize>--> <!--  param 'audit_comments_reqd' added for IN051122 --><!--IN64543-->
				<frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='ViewDeptData.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>&instrn_type=<%=instrn_type%>' frameborder=0  scrolling=no  noresize><!--IN64543-->
		<% } else if(field_mnemonic.equalsIgnoreCase("PATIENT_INSTRNS")) {%>
				<!--<frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='viewPatientData.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>' frameborder=0  scrolling=no  noresize>	--><!--  param 'audit_comments_reqd' added for IN051122 --><!--IN64543-->
				<frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='viewPatientData.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>&instrn_type=<%=instrn_type%>' frameborder=0  scrolling=no  noresize><!--IN64543-->
		<% } else if(field_mnemonic.equalsIgnoreCase("Comments")) {%>
				<!--<frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='ViewLineComment.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>&can_reason=Comments' frameborder=0  scrolling=no  noresize>--> <!--  param 'audit_comments_reqd' added for IN051122 --><!--IN64543-->
				<frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='ViewLineComment.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>&order_line_num=<%=order_line_num%>&field_mnemonic=<%=field_mnemonic%>&line=<%=line%>&audit_comments_reqd=<%=audit_comments_reqd%>&can_reason=Comments&instrn_type=<%=instrn_type%>' frameborder=0  scrolling=no  noresize><!--IN64543-->
		<% } 
		}
	%>
</frameset> 

