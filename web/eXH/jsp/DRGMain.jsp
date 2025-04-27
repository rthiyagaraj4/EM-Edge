<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>

<%
//	String locale = ((String)session.getAttribute("LOCALE"));
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<!-- <title><fmt:message key="eMR.DRGCalculation.label" bundle="${mr_labels}"/></title> -->
<title>DGR Calculator</title>
  										    
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize  style='height:8vh;width:100vw'></iframe><iframe name="drg_query_frame" id="drg_query_frame" src="../../eXH/jsp/DRGQueryCriteria.jsp" frameborder='' scrolling='no' noResize style='height:220%;width:100vw'></iframe>
	<iframe name="drg_results_frame" id="drg_results_frame" src="../../eCommon/html/blank.html" frameborder='' scrolling='no' noResize style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>

</html>

