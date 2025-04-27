<!DOCTYPE html>
<!-- OrderableFrameSet.jsp -->
<%@page contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
   <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	//String searchText = request.getParameter("searchText"); 
	System.out.println("AdminoraclejobGatewayLookupFrameSet.jsp QryStr"+request.getQueryString());
%>

  
<html>
<title><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></title>
<head>
<%
	String sStyle	="IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>				  
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>												 
<iframe src="AdminoraclejobGatewayLookupSearch.jsp?<%=request.getQueryString()%>" name="refusal_searchframe1"  scrolling='no' frameborder="0"  style='height:25vh;width:100vw'></iframe>
<iframe src="../../eCommon/html/blank.html" name="refusal_resultframe1" id="refusal_resultframe1"    scrolling='no' frameborder="0" noresize style='height:75vh;width:100vw'></iframe>
	<iframe src="../../eCommon/html/blank.html" name="refusal_resultframe_list" id="refusal_resultframe_list"    scrolling='no' frameborder="0" noresize style='height:0vh;width:100vw'></iframe>

</html>							      
								  													 

