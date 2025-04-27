<!DOCTYPE html>
<!-- Newly Created for KDAH-CRF-0359.1-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<iframe name='qa_query_result' id='qa_query_result' src="../../eDS/jsp/FoodItemModifyResultPage.jsp?<%=request.getQueryString()%>" frameborder=0 noresize style='height:100vh;width:99vw'></iframe>


