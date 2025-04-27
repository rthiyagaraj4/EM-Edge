<!DOCTYPE html>
<%@page import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="Common.WaitList.label" bundle="${common_labels}"/></title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
		request.setCharacterEncoding("UTF-8");	
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");		
		String s=request.getQueryString();	
%>
		
				<iframe name='wiatListCriteria' id='wiatListCriteria' src='OAWaitListWrapperCriteria.jsp?<%=s%>' frameborder=0 scrolling='no' noresize style='height:27vh;width:100vw'></iframe>	
					<iframe name='search_static' id='search_static'    src='../../eOA/jsp/WaitListMgmtCriteria.jsp' frameborder=0 noresize scrolling=no style='height:0vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod1' id='f_query_add_mod1' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="auto" style='height:65vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod2' id='f_query_add_mod2' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="auto" style='height:0vh;width:100vw'></iframe>
					<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling=auto style='height:0vh;width:100vw'></iframe>		
</html>

