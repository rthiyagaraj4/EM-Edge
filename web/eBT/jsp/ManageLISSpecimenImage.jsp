<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
	<head>
		<% String locale = (String)session.getAttribute("LOCALE"); %>
		<% request.setCharacterEncoding("UTF-8");%>
		<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
		<%
			//String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String sStyle = "IeStyle.css";//Sanjay
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script src="../../eCA/js/ManageLISSpecimenImage.js" language="javascript"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		StringBuffer source = new StringBuffer();
		source.append(params) ;
	%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%= url+source.toString() %>' frameborder='0' scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
		<iframe scrolling="no" name='LISSpecQueryFrame' id='LISSpecQueryFrame' src='../../eBT/jsp/ManageLISSpecimenImageQuery.jsp'  frameborder=0 style='height:20vh;width:100vw'></iframe>
		<iframe scrolling="auto" name='LISSpecResultFrame' id='LISSpecResultFrame' src='../../eCommon/html/blank.html'  frameborder=0 style='height:66vh;width:100vw'></iframe>
		<iframe name='LISSpecBlankFrame' id='LISSpecBlankFrame' src='../../eCA/jsp/blank.jsp' frameborder='0'  style='height:0vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0'  style='height:8vh;width:100vw'></iframe>
	
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</html>

