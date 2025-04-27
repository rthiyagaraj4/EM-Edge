<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<head>
<% String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script  src="../../eCommon/js/jquery-ui.js" language="JavaScript"></script>  
<script language="javascript" src="../../eXH/js/NotificationEventSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
String params = request.getQueryString() ;
String source = url + params ;

Connection con=null;
Statement stmt=null;
ResultSet rs=null; 
Statement stmt1=null;
ResultSet rs1=null; 
%>

</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize  style='height:7vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eXH/jsp/NotificationEventHeader.jsp' frameborder=0 noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:78vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:7vh;width:100vw'></iframe>
</html>							    

