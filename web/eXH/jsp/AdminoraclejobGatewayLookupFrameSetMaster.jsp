<!DOCTYPE html>
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

<iframe src="AdminoraclejobGatewayLookupFrameSet.jsp?<%=request.getQueryString()%>" name="refusal_searchframe1_master"  scrolling='no' frameborder="0"  style='height:100vh;width:100vw'></iframe>											   
							 
</html>
		

