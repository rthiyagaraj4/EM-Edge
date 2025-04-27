<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
 --><%
		request.setCharacterEncoding("UTF-8");
				
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language='javascript' src='../../eST/js/Item.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name='frameItemHeader' id='frameItemHeader' frameborder="0" scrolling="no" noresize src="../../eST/jsp/ItemHeaderAddModify.jsp?<%=request.getQueryString()%>"> -- style='height:60%;width:100vw'></iframe>
<iframe name='frameItemDetail' id='frameItemDetail' frameborder="0" scrolling="no" noresize src="../../eST/jsp/ItemDetailAddModify.jsp?<%=request.getQueryString()%>" style='height:50%;width:100vw'></iframe>	 
	

</frameset>
</html>

