<!DOCTYPE html>
<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@include file="../../eCommon/jsp/Common.jsp" %>

<html>
<head>

<%
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
	String tab_name = request.getParameter("tab_name3") ;
	if(tab_name==null) tab_name="Operation/Procedures"  ;
	if(tab_name!=null && tab_name.equals("null")) tab_name="Operation/Procedures";
	if(tab_name.equals("Operation/Procedures")){
%>
		<iframe name='operations_procedures_frame' id='operations_procedures_frame' 		src="../../eOT/jsp/AT_PreAnaesOperationsProcedures.jsp?<%=params%>" nowrap noresize scrolling='no' style='height:100vh;width:100vw'></iframe>
<%
	}else if(tab_name.equals("Assessment")){
%>
			<iframe name='pre_morbid_tab_frame' id='pre_morbid_tab_frame' 		src="../../eOT/jsp/AT_PreAnaesPreMorbidTab.jsp?<%=params%>"  nowrap noresize scrolling='no' style='height:10vh;width:100vw'></iframe><iframe name='pre_morbid_details_tab_frame' id='pre_morbid_details_tab_frame'	 src="../../eOT/jsp/AT_PreAnaesPreMorbidTabFrames.jsp?<%=params%>"   nowrap noresize scrolling='yes' style='height:90vh;width:100vw'></iframe>
<%
}
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='PreAnaesTabForm' id='PreAnaesTabForm'>
<input type='hidden' name='remarks_tab' id='remarks_tab' value='<%=tab_name%>'>
</form>
</body>
</html>

