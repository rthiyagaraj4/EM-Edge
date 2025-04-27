<!--Created by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMR/js/MRMaster.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		request.setCharacterEncoding("UTF-8");
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String func = request.getParameter("function_id");
		String source = url + params ;

		Connection con	= null;
		String facilityId=(String)session.getValue("facility_id");
		String userId=(String)session.getValue("login_user");
	
		con = ConnectionManager.getConnection(request);
		

%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0 style='height:83vh;width:100vw'></iframe>
	<iframe name='blankFrame' id='blankFrame' 	src='../../eCommon/html/blank.html' frameborder=0 style='height:0vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>

<script>
blankFrame.document.write("<HTML><head></head><body onKeyDown='lockKey()'><form name='tempForm' id='tempForm'><input type='text' name='func' id='func' value='<%=func%>'></form></body></HTML>");
</script>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>
</html>

