<!DOCTYPE html>
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%
	Connection con=null;
	try{
		    request.setCharacterEncoding("UTF-8");
			con = ConnectionManager.getConnection(request);
%>

<html>
<head>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../js/AccessRightsMenuFunc.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url="../../eCommon/jsp/MstCodeToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;		
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>				
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eSM/jsp/AccessRightsMenu.jsp' frameborder=0 style='height:95vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/MstCodeError.jsp'frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
<%
}catch(Exception e){//out.println(e);
	e.printStackTrace();
}
			finally { 
	ConnectionManager.returnConnection(con,request);
}
%>
</html>

