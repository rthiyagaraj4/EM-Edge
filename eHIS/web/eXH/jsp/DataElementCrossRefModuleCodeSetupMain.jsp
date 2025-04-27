<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%String params = request.getQueryString() ;%>
<head>
<script language='javascript' >
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='appltable' id='appltable' src='../../eXH/jsp/DataElementCrossRefTableSelection.jsp?<%=params%>' frameborder=0 noresize scrolling='no' style='height:30vh;width:100vw'></iframe>
<iframe name='appltablecode' id='appltablecode' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:70vh;width:100vw'></iframe>
</html>

