<!DOCTYPE html>
<!--
File Name		: PlaceMealOrderOPSearchFrames.jsp
File Description: Main/Outer Frame: This is to search all the Outpatients who 
						1) Books an appointment but yet to visit 
						2) Visit clinic with appointment
						3) Direct Visit without appointment
CRF#			: Bru-HIMS-CRF-230
Author			: Abirami
Date			: Aug-2013
-->

<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
<script type="text/javascript">
	function reset(){
		placeMealOrderOPSearch.location.href='../../eDS/jsp/PlaceMealOrderOPSearch.jsp';
		placeMealOrderOPResult.location.href='../../eCommon/html/blank.html';
	}
	 
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? "IeStyle.css" : (String) session.getAttribute("PREFERRED_STYLE");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
<fmt:setBundle basename="eDS.resources.Labels" var="ds_labels"/>
</head>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name="placeMealOrderOPSearch" id="placeMealOrderOPSearch" src="../../eDS/jsp/PlaceMealOrderOPSearch.jsp" scrolling="no" frameborder="0" noresize="noresize"/ style="height:34vh;width:100vw"></iframe>
	<iframe name="placeMealOrderOPResult" id="placeMealOrderOPResult"  scrolling="no" frameborder="0" noresize="noresize"/ style="height:49vh;width:100vw"></iframe>
	<iframe name="messageFrame" id="messageFrame"	src="../../eCommon/jsp/MstCodeError.jsp" frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
</html>

