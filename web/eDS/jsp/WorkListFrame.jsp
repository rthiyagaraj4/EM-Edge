<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8");
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 
 %>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>

<iframe name='qa_query_result' id='qa_query_result' src="../../eDS/jsp/WorkListResultPage.jsp?<%=request.getQueryString()%>" scrolling="no"  frameborder=0 noresize style='height:85vh;width:100vw'></iframe>
<iframe name='qa_query_result_tail' id='qa_query_result_tail' src="../../eDS/jsp/WorkListResultTailLegend.jsp" frameborder=0 noresize style='height:12vh;width:100vw'></iframe>


