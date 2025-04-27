<!DOCTYPE html>
<!-- This Page is invoked when a user select Item For Store  from the menu -->
<%@page  import="  eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%

request.setCharacterEncoding("UTF-8");
				
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
    <script language="JavaScript" src="../../eXH/js/DispenseItemMachineCodes.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
    </script>
</head>
<%

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<frameset rows="42,*,50">
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>	
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='' frameborder=0 noresize scrolling='no' style='height:70vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:12vh;width:100vw'></iframe>
	<iframe name="machineForAutoDisp" id="machineForAutoDisp" id='machineForAutoDisp' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>


