<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>



<html>
<head>
<script type="text/javascript">
// modified by N Munisekhar on 20-May-2013 against [IN039611]
	function reset(){
	var formObj = parent.content.workListCriteria.document.forms[0];
	formObj.reset();
		
	}
	var patientObj_NextPrev=new Object();
</script>
<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? "IeStyle.css"
			: (String) session.getAttribute("PREFERRED_STYLE");  

%>
<%      //Added Against MMS Vulnerability Issue - Starts
        request= new XSSRequestWrapper(request);
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added Against MMS Vulnerability Issue - Ends
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
	%>

	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<%-- <Script language="JavaScript" src="<%=request.getContextPath()%>/eDS/WorkListOrder/js/WorkListOrder.js"></Script> --%>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw;border:0'></iframe>
	<iframe name="workListCriteria" id="workListCriteria" src="../../eDS/jsp/WorkListMain.jsp" scrolling="no" frameborder="0" noresize="noresize"/ style="height:21vh;width:100vw;border:0"></iframe>
	<iframe name="workListResult" id="workListResult"  scrolling="no" frameborder="0" noresize="noresize"/ style="height:66vh;width:100vw;border:0"></iframe>
	<iframe name="messageFrame" id="messageFrame"	src="../../eCommon/jsp/MstCodeError.jsp" frameborder=0 noresize scrolling='auto' style='height:5vh;width:100vw;border:0'></iframe>

</html>

