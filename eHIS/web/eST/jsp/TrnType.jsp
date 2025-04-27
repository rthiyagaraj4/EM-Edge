<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");

		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'> -->
</link>
<script language='javascript' src='../../eST/js/TrnType.js'></script>
<script language='javascript' src='../../eST/js/StCommon.js'></script>
<!--<script language='javascript' src='../../eST/js/ChangeBinLocation.js'></script> -->
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script>
<script language='javascript' src='../../eST/js/StMessages.js'></script> -->
<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	//String facilityid=(String)session.getValue("facility_id");
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eST/jsp/TrnTypeModify.jsp?function_id=<%= request.getParameter( "function_id" ) %>" frameborder=0 scrolling='auto' style='height:84vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

