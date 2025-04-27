<!DOCTYPE html>
<html>
<head>
	
	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>

<!--
<iframe name='AddModifyPatFinDetailsMultiBlngGrpHeader' id='AddModifyPatFinDetailsMultiBlngGrpHeader' src='../../eBL/jsp/AddModifyPatFinDetailsMultiBlngGrpHeader.jsp' frameborder=0 noresize scrolling=NO>
-->
		<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='DummyFrame' id='DummyFrame' scrolling='no' noresize style='height:0vh;width:100vw;border:0'></iframe> 

		<iframe name='AddModifyPatFinDetailsMultiBlngGrpBody' id='AddModifyPatFinDetailsMultiBlngGrpBody' src="../../eBL/jsp/AddModifyPatFinDetailsMultiBlngGrpBody.jsp?<%=request.getQueryString()%>&" frameborder=0 noresize scrolling='no' style='height:80vh;width:100vw;'></iframe> 

		<iframe name='AddModifyPatFinDetailsMultiBlngGrpButton' id='AddModifyPatFinDetailsMultiBlngGrpButton' src="../../eBL/jsp/AddModifyPatFinDetailsMultiBlngGrpButton.jsp?<%=request.getQueryString()%>" frameborder=0 noresize scrolling='no' style='height:15vh;width:100vw;'></iframe> 
		<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='InsValidationFrame' id='InsValidationFrame' scrolling='no' noresize style='height:0vh;width:100vw;border:0'></iframe> 
		<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='DummyFrame' id='DummyFrame' scrolling='no' noresize style='height:0vh;width:100vw;border:0'></iframe> 


</head>
<input type='hidden' name='Case' id='Case' value='4'>
</html>

