<!DOCTYPE html>
 <html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<script language='javascript' src='../../eXI/js/AmendNewInterfaced.js'></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
//	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
//	System.out.println("AmendNewinterfaceItemMain.jsp source : "+source);
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='hr_menu_bar' id='hr_menu_bar' src='../../eXI/jsp/AmendNewinterfaceItemSelectMaster.jsp' frameborder=0 noresize scrolling='no' style='height:6vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:76vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:10vh;width:100vw'></iframe>
</html>

