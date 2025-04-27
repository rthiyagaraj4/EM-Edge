
<!--Created by Ashwini on 04-Oct-2017 for ML-MMOH-CRF-0763 and ML-MMOH-CRF-0764-->
<%@ page contentType="text/html;charset=UTF-8" %>
<script>
 function reset()
 {
	searchResultFrame.document.location.href="../../eCommon/html/blank.html";  
	searchFrame.document.location.reload();
 }
</script>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
	String function_id= request.getParameter("function_id");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<!-- <script language='javascript' src='../../ecommon/js/common.js'></script> -->
	<script src='../js/NoticeofCompRepNotific.js' language='javascript'></script>
	<script src="../../eCommon/js/DateUtils.js"></script>
 <head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'      src='<%=source%>' scrolling='NO' frameborder='0'  noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='searchFrame' id='searchFrame'       src='../../eMR/jsp/NoticeofCompRepNotificSearch.jsp?function_id=<%=function_id%>' scrolling='No' frameborder='0'  style='height:34vh;width:100vw'></iframe>
	<iframe name='searchResultFrame' id='searchResultFrame' src='../../eCommon/html/blank.html' frameborder='0' scrolling='auto' style='height:50vh;width:99vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' frameborder='0' noresize style='height:8vh;width:100vw'></iframe>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

