<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../ePH/js/PHDefineMenu.js" language="javascript" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
	<script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
    </script>
	<iframe name="commontoolbarFrame" id="commontoolbarFrame" src='<%=source%>' frameborder=0 scrolling="no" noresize  style='height:8vh;width:100vw'></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" src='../../eCommon/html/blank.html'frameborder=0 scrolling="no" noresize style='height:83vh;width:100vw'></iframe>
		<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder=0 scrolling="auto" noresize style="height:9vh;width:100vw"></iframe>
	

</html>

