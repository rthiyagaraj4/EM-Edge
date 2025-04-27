<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
    <script language='JavaScript' src='../../eCommon/js/common.js'></script>
	<script language='JavaScript' src='../../eOT/js/Hashtable.js'></script>
	<script language='JavaScript' src='../../eCommon/js/ValidateControl.js'></script>
 	<script language='javascript' src='../../eOT/js/BlockSlotsByAgeGroup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> scrolling='no' style='height:8vh;width:100vw'></iframe><iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'  style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp?<%=params%>'  noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form>
	<input type="hidden" name="source" id="source" value="<%=params%>">
	</form>
</html>

