<!DOCTYPE html>
<!-- This file created against MMS-QH-CRF-0079 [IN:038156] for September 2016 Release -->
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>

 	<script language='javascript' src='../../eDS/js/DSProcessSupplementary.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script language="Javascript" src="../../eDS/js/json.js"></script>
	<script type="text/javascript">
	/*function reset()
	{
       workListCriteria.location.href='../../eDS/jsp/DSProcessSupplementaryOrder.jsp';
    }*/
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? "IeStyle.css"
			: (String) session.getAttribute("PREFERRED_STYLE");
%>

<%      
        //Added Against MMS Vulnerability Issue - Starts
        request= new XSSRequestWrapper(request);
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Content-Type-Options", "nosniff");
	    //Added Against MMS Vulnerability Issue - Ends 
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>

<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
</head>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'  frameborder=0 scrolling='no' noresize src="<%= source %>" style='height:10vh;width:100vw;border:0'></iframe>
	<iframe name="workListCriteria" id="workListCriteria"  src="../../eDS/jsp/DSProcessSupplementaryOrder.jsp" scrolling="no" frameborder="0" noresize="resize"/ style="height:20vh;width:100vw;border:0"></iframe>
	<iframe name="RecordCriteria" id="RecordCriteria"  src="../../eDS/jsp/DSProcessSupplementaryOrderRecord.jsp" scrolling="auto" frameborder="0"  scrolling='auto'/ style='height:62vh;width:100vw;border:0'></iframe><!--Modified for Script Error-->
	<iframe name="messageFrame" id="messageFrame"	src="../../eCommon/jsp/MstCodeError.jsp" frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw;border:0'></iframe>

</html>

