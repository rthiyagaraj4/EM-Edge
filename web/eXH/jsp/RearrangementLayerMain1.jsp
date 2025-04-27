<!DOCTYPE html>
 <html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eXH/js/RearrangementLayer.js" ></script>
<script type="text/javascript" src="../../eCommon/js/dtree1.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>		    
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:4vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eXH/jsp/RearrangementLayerSelectMaster.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail' src='../../eXH/jsp/RearrangementLayerNavigator.jsp' frameborder=0 noresize scrolling='auto' style='height:19vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:6vh;width:100vw'></iframe>

</html>





