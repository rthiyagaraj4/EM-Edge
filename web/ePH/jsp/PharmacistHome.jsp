<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.PharmacistHomeBean, ePH.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale			= (String)session.getAttribute("LOCALE");
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript' src='../../ePH/js/PharmacistHome.js' ></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title></title>
	</head>
<%
	try{
		String identityForSwitch = request.getParameter("identityForSwitch")==null?"": request.getParameter("identityForSwitch");
		String query_string = request.getQueryString() == null? "" :request.getQueryString();
%>
	<script>
			 showLoginWindow('<%=identityForSwitch%>');
			 //alert("query_string");
			 //alert("query_string : " + query_string);
	</script>
    <iframe name='CommonToolbar' id='CommonToolbar' src='PharmacistHomeToolbar.jsp?<%=query_string%>' noresize  frameborder=no marginheight=0 marginwidth=0 SCROLLING='no' noresize style='height:8vh;width:100vw'></iframe>	
	<iframe name='menuFrame' id='menuFrame' src='../../eCommon/html/blank.html' frameborder=1  marginheight=0 marginwidth=0 SCROLLING='no' BORDERCOLOR='red' noresize style='position:fixed; height:6vh;width:13vw'></iframe>
	<iframe name='matFrame' id='matFrame' src='../../eCommon/html/blank.html' frameborder=1  marginheight=0 marginwidth=0 SCROLLING='yes' BORDERCOLOR='red' style='height:80vh;width:13vw'></iframe>
	<iframe name='workAreaFrame' id='workAreaFrame' src='../../eCommon/html/blank.html'   frameborder=0  marginheight=0 marginwidth=0 SCROLLING='yes' BORDERCOLOR='green' noresize style='height:80vh;width:82vw'></iframe>
	<iframe name='lookupMenuFrame' id='lookupMenuFrame' src='../../eCommon/html/blank.html'   frameborder=1  marginheight=1 marginwidth=1 SCROLLING='auto' BORDERCOLOR='red' style='height:0vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize  frameborder=0  marginheight=0 marginwidth=0 SCROLLING='auto' noresize style='height:9vh;width:100vw'></iframe> 
    <iframe name='alertFrame' id='alertFrame' src='../../eCommon/jsp/error.jsp' noresize  frameborder=0  marginheight=0 marginwidth=0 SCROLLING='no' noresize style='height:0vh;width:100vw'></iframe> 
	
</html>

<%
	}
    catch(Exception e){
		e.printStackTrace();
		out.println("Exception in PharmacistHome.jsp"+e.toString());
    }
%>

