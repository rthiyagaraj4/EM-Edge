<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
String item_code	=	request.getParameter("item_code");
String mode			=	request.getParameter( "mode" ) ;
String function_id	=	request.getParameter( "function_id" ) ;
%>
<!-- <script language="JavaScript" src="../js/MmMessages.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script> -->

<iframe name='item_detail' id='item_detail' src='../jsp/AddModifyItem1.jsp?item_code=<%=item_code%>&mode=<%=mode%>&function_id=<%=function_id%>'  frameborder=0 scrolling='no' noresize style='height:50vh;width:100vw'></iframe>
	<!-- <iframe name='item_class_detail' id='item_class_detail' 	 src='../jsp/AddModifyItem2.jsp?item_code=<%=item_code%>&mode=<%=mode%>&function_id=<%=function_id%>' frameborder=0 scrolling='no'> -->
	<iframe name='item_class_detail' id='item_class_detail' src='../../eCommon/html/blank.html'  frameborder=0 scrolling='no' noresize frameborder='0' style='height:100vh;width:100vw'></iframe>

 
</html>

