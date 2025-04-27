<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language='JavaScript' src='../../eXH/js/ProtocollinkRefrence.js'></script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<!--<script language="javascript" src="../../eXH/js/" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params;
	session.setAttribute("params",params);
//System.out.println("source"+source);

/*System.out.println("source1"+source1);
String url1 = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params1 = request.getQueryString() ;
	String source = url1 + params1;
	out.println("<script>alert('"+source+"')</script>");
System.out.println("source1"+source);*/
	%>




<!--
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
-->
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:45%;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eXH/jsp/ProtocollinkDervationSelectMaster.jsp?params=<%=source%>' frameborder=0 noresize scrolling='no' style='height:65%;width:100vw'></iframe><iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail'  src='../../eCommon/html/blank.html' 
	frameborder=0 noresize scrolling='auto'>
<!--	src='../../eXH/jsp/RearrangementLayerNavigator.jsp' -- style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:30%;width:100vw'></iframe>

</html>

