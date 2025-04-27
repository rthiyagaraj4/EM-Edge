 <!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>                                
<head>                                
 	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language="javascript" src="../../ePH/js/PhTPNDispSheet.js"></script>
	<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk-latest.js"></SCRIPT>
</head>                               

<%

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); 
response.addHeader("X-XSS-Protection", "1; mode=block"); 
response.addHeader("X-Content-Type-Options", "nosniff");

	String locale			= (String)session.getAttribute("LOCALE");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" frameborder='0' style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PhTPNDispSheetCriteria.jsp" frameborder='0' style="height:35vh;width:100vw"></iframe><iframe name="f_query_results" id="f_query_results" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" frameborder='0' style="height:45vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" frameborder='0' style="height:12vh;width:100vw"></iframe>
</html>

