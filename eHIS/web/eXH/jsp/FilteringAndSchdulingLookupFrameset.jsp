<!DOCTYPE html>
<!-- OrderableFrameSet.jsp -->
<%@page contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
 
<% 
	//String searchText = request.getParameter("searchText"); 
%> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title>Filter Group</title>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eXH/js/Filteringandschdulinglookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<iframe  src="FileteringAndSchdulingLookupSearch.jsp?<%=request.getQueryString()%>" name="refusal_searchframe1" id="refusal_searchframe1"  scrolling='no' frameborder="0" noresize style='height:30vh;width:100vw'></iframe>
	<iframe src="../../eCommon/html/blank.html" name="refusal_resultframe1" id="refusal_resultframe1"    scrolling='no' frameborder="0" noresize style='height:30vh;width:100vw'></iframe>
	<iframe src="../../eCommon/html/blank.html" name="refusal_addresultframe1" id="refusal_addresultframe1"    scrolling='no' frameborder="0" noresize style='height:30vh;width:100vw'></iframe>
		<iframe src="../../eCommon/jsp/MstCodeError.jsp" name="messageFrame" id="messageFrame"    scrolling='no' frameborder="0" noresize style='height:9vh;width:100vw'></iframe>

</html>     

