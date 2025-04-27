<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>

<head>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>	
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language="javascript" src="../../eCommon/js/common.js"></script>	
<script language="javascript" src="../../eMR/js/HolidayForMedicalRecord.js"></script>

</head>

<%
    request.setCharacterEncoding("UTF-8");
	String url 	= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source   = url+params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling=no noresize frameborder='0' style='height:8%;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' frameborder='0' style='height:30%;width:100vw'></iframe><iframe name='f_query_add_mod1' id='f_query_add_mod1' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' frameborder='0' style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling=auto frameborder='0' style='height:8%;width:100vw'></iframe>

</html>


