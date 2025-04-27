<!DOCTYPE html>
<html> 
<%request.setCharacterEncoding("UTF-8"); %>
	<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=11">

<script>

function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
	
	f_query_add_mod.location.reload();
	resultFrame.location.href='../../eCommon/html/blank.html';	
}

</script>
</head>
<title>Credit Card POC</title>
	
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'src=<%=source%> frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>  
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eXH/jsp/CreditCardPOCMaster.jsp?<%=params%>" frameborder=0  scrolling='auto' style='height:86vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:6vh;width:100vw'></iframe>
	
 	
</html>

