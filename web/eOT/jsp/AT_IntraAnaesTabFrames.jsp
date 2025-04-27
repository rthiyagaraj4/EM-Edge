<!DOCTYPE html>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
	String params	= request.getQueryString();
	String tab_name = request.getParameter("tab_name") ;
		
	if(tab_name==null) tab_name="operations_procedures";
	if(tab_name!=null && tab_name.equals("null")) tab_name="operations_procedures";
 if(tab_name.equals("operations_procedures")){
%>
		<iframe name='operations_procedures' id='operations_procedures' src="../../eOT/jsp/AT_IntraAnaesOperProc.jsp?<%=params%>"  nowrap noresize scrolling='no' style='height:100vh;width:100vw'></iframe> 
<%}else if(tab_name.equals("personal_details")){
%>
		<iframe name='personal_record_frame' id='personal_record_frame'  
			src="../../eOT/jsp/AT_IntraAnaesPersonalRecord.jsp?<%=params%>" nowrap noresize scrolling='no' style='height:40vh;width:100vw'></iframe><iframe name='personal_details_frame' id='personal_details_frame'  
			src="../../eCommon/html/blank.html" nowrap noresize scrolling='auto' style='height:60vh;width:100vw'></iframe>
<%}%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='InteAnaesTabForm' id='InteAnaesTabForm'>
<input type='hidden' name='remarks_tab' id='remarks_tab' value='<%=tab_name%>'>
</form>
</body>
</html>

