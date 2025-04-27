<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'>
</link> --><%
		request.setCharacterEncoding("UTF-8");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script>
 --><script language='javascript' src='../../eST/js/StCommon.js'></script>
<!-- <script language='javascript' src='../../eST/js/StMessages.js'></script>
 --> <script language='javascript' src='../../eST/js/ReportMfgItemLabel.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></title>

    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>";
    </script>
</head>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
// pmd 29/01/05
//	String facilityid=(String)session.getValue("facility_id");

%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eST/jsp/MfgItemLabelMain.jsp" frameborder=0 scrolling='no' style='height:9vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod_sub' id='f_query_add_mod_sub' src='../../eCommon/html/blank.html?' frameborder=0 scrolling='no' style='height:35vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod_result' id='f_query_add_mod_result' src='../../eCommon/html/blank.html?' frameborder=0 scrolling='auto' style='height:35vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:13vh;width:100vw'></iframe>
</html>

