<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eOA/js/OAParameter.js"> </script>
	<script language="javascript" src="../../eCommon/js/common.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
	
</head>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
	String url 	= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source   = url+params ;
%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling=no noresize style='height:8vh;width:100vw'></iframe>
       	<iframe name='f_query_add_mod' id='f_query_add_mod'    src='../../eOA/jsp/OAParameterAddModify.jsp?' frameborder=0 scrolling=auto style='height:80vh;width:100vw'></iframe>
	<iframe name='resFrame' id='resFrame'    src='' frameborder=0 scrolling=no style='height:0vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling=auto style='height:9vh;width:100vw'></iframe>

</html>

