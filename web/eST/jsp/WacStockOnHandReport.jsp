<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name			INC Number       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------

10/08/2020				NMC-JD-CRF-0047			Haribabu		IN072774		13/08/2020			Manickam				NMC-JD-CRF-0047	
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page  contentType="text/html;charset=UTF-8"%>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head> 
<%
request.setCharacterEncoding("UTF-8");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eST/js/StCommon.js'></script>
<script language='javascript' src='../../eST/js/WacStockOnHandReport.js'></script>
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
<title></title>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eST/jsp/WacStockOnHandReportCriteria.jsp" frameborder=0 scrolling='no' style='height:82vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>

