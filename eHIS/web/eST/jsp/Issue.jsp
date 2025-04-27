<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8"  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
 %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'>
	</link>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<script language='javascript' src='../../eST/js/Issue.js'></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
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
	String facilityid=(String)session.getValue("facility_id");
	IssueBean bean = (IssueBean)getBeanObject( "issueBean","eST.IssueBean",request);
	bean.setLanguageId(locale);
		if(!(bean.recordExists(facilityid, "ALL"))) {
		out.println("<script>alert(getMessage('FACILITY_PARAM_NOT_SET','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
	}
	//Added for 29970	Bru-HIMS-CRF-095
	String homepage		= request.getParameter("homepage") == null?"N":request.getParameter("homepage");
	String count		= request.getParameter("count") == null?"0":request.getParameter("count");
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' style='height:82vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
<%
	if(homepage.equals("Y") && !count.equals("0")){	
%>
		<script>
			parent.workAreaFrame.f_query_add_mod.document.location.href = "../../eST/jsp/IssueQueryFrame.jsp?mode=2&<%=params%>";
		</script>
<%
}
%>
</html>
<%
putObjectInBean("issueBean",bean,request);
%>

