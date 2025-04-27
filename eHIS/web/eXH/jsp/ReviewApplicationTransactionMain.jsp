<!DOCTYPE html>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript"src="../../eXH/js/ApplicationMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize  style='height:40%;width:100vw'></iframe><iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eXH/jsp/ReviewApplMessageQuery.jsp" scrolling="no" frameborder="0" noresize style='height:125%;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'	src="../../eCommon/jsp/MstCodeError.jsp" frameborder=0 noresize scrolling='no'></iframe>
<body>
</body>
</html>

