<!DOCTYPE html>
<html>			 
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>

<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eXH/js/DMSSimulator.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function create()
{
	window.TestFrame.location.href = "../../eXH/jsp/Test.jsp";
}

function query()
{
	window.TestFrame.location.href = "../../servlet/eXH.DMSSimulatorServlet?requestType=QUERY";
}
</script>

</head>
<body style = 'margin:0'>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String moduleID = request.getParameter("module_id");
	String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%= source %>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='TestFrame' id='TestFrame' src="../../servlet/eXH.DMSSimulatorServlet?requestType=QUERY" frameborder=0 noresize scrolling='no' style='height:82vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</body>
</html>

																	   		    

