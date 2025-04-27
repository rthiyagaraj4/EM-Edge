<!DOCTYPE html>
<!-- This file created against MMS-QH-CRF-0079 [IN:038156] for September 2016 Release -->
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<script language="Javascript" src="../../eDS/js/DSPlaceSupplementaryOrder.js"></script>
<script type="text/javascript">
/*function reset(){
	//var formObj = parent.content.workListCriteria.document.forms[0];
	//formObj.reset();		
	}*/
	var patientObj_NextPrev=new Object();
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? "IeStyle.css"
			: (String) session.getAttribute("PREFERRED_STYLE");

%>
<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>

	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
</head>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw;border:0'></iframe>
		<iframe name="workListCriteria" id="workListCriteria" src="../../eDS/jsp/DSPlaceSupplementaryOrder.jsp" scrolling="no" frameborder="0" noresize="resize"/ style="height:85vh;width:100vw;border:0"></iframe>
		<!--frame name="workListResult"  scrolling="no" frameborder="0" noresize="noresize"/-->
		<iframe name="messageFrame" id="messageFrame"	src="../../eCommon/jsp/MstCodeError.jsp" frameborder=0 noresize scrolling='auto' style='height:5vh;width:100vw;border:0'></iframe>
</html>

