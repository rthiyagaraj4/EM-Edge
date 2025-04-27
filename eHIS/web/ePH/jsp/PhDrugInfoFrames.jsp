<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhDrugInfo.js"></script>
	</head>
<%
	String mode	= request.getParameter( "mode" )==null?"":request.getParameter( "mode" ) ;
	String function_id=request.getParameter("function_id")==null?"":request.getParameter( "function_id" ) ;
	String Enq_num=request.getParameter("Enq_num")==null?"":request.getParameter( "Enq_num" ) ;
	if(mode.equals("MODE_INSERT") ){
%>
		
			<iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PhDrugInfoHeader.jsp" style="height:8vh;width:100vw"></iframe>
			
				<iframe name="f_enquiry" id="f_enquiry" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PhDrugInfoEnqDtls.jsp?function_id=<%=function_id%>&mode=<%=mode%>&Enq_num=<%=Enq_num%>" style="height:84vh;width:100vw"></iframe>
				<iframe name="f_request" id="f_request" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PhDrugInfoReqDtlsFrame.jsp?function_id=<%=function_id%>&mode=<%=mode%>&Enq_num=<%=Enq_num%>" style="height:0vh;width:100vw"></iframe>
				<iframe name="f_patient" id="f_patient" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PhDrugInfoPatDtls.jsp?function_id=<%=function_id%>&mode=<%=mode%>&Enq_num=<%=Enq_num%>" style="height:0vh;width:100vw"></iframe>
				<iframe name="f_response" id="f_response" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PhDrugInfoResDtlsFrame.jsp? function_id=<%=function_id%>&mode=<%=mode%>&Enq_num=<%=Enq_num%>" style="height:0vh;width:100vw"></iframe>
		
<%
		 }
		 else{
%>
			<!-- <frameset rows="33,68" > -->
				<iframe name="f_query_criteria1" id="f_query_criteria1" frameborder="0" scrolling="no" noresize border='2' src="../../ePH/jsp/PhDrugInfoQueryCriteria.jsp" style="height:27vh;width:100vw"></iframe>
				<iframe name="f_detail" id="f_detail" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:73vh;width:100vw"></iframe>
		<!-- 	</frameset> -->
<%
		}
%>
</html>
