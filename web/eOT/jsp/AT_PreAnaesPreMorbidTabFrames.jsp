<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>

<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>

</head>
<%
	String params	= request.getQueryString();
	String tab_name = request.getParameter("tab_name1") ;
	if(tab_name==null) tab_name="pre_morbid_details";
	if(tab_name!=null && tab_name.equals("null")) tab_name="pre_morbid_details";
	if(tab_name.equals("pre_morbid_details")){
%>
		<frameset rows='0%,100%'>
			<frame name='pre_morbid_remarks' src="../../eOT/jsp/AT_PreAnaesPreMorbidRemarks.jsp?<%=params%>" frameborder=0 nowrap noresize scrolling='no' >
			<frameset rows='46%,54%'>
				<frame name='pre_morbid_record_frame'  
				src="../../eOT/jsp/AT_PreAnaesPreMorbidRecord.jsp?<%=params%>" frameborder=0 nowrap noresize scrolling='auto'>
				<frame name='pre_morbid_detail_frame'  
				src="../../eCommon/html/blank.html" frameborder=0 nowrap noresize scrolling='auto'>
			</frameset>
		</frameset>
<%
	}
%>

</html>
