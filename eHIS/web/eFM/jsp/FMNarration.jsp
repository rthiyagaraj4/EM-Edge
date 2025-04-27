<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eFM/js/FMNarration.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling=no noresize style='height:7vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' style="width: 100%; height:100vh; border: 0; display: flex;
		align-items: center; justify-content: center; margin: 0 auto; padding: 0;" scrolling='no'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' scrolling='no' frameborder='0' noresize 
        style='position: absolute; bottom: 0; left: 0; width: 100%; height: 50px; border: none;'></iframe>


</html>

