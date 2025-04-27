
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<script src="../../eCommon/js/common.js" language="JavaScript"></script>
		<!-- <script src='../../eCA/js/LocationforPractitioner.js' language='JavaScript'></script> -->
		<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
        <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		//String params = request.getQueryString() ;
		//String source = url + params ;
	%>
	<iframe name='Header' id='Header' src='../../eCA/jsp/LocationForPractHeader.jsp' frameborder=0 noresize style='height:11vh;width:99vw'></iframe>
		<iframe name='Result' id='Result' src='../../eCA/jsp/LocationForPractList.jsp' frameborder=0 noresize style='height:55vh;width:99vw;margin-left: -8px'></iframe>
		<iframe name='AddModify' id='AddModify' src='../../eCA/jsp/LocationForPractDetail.jsp' frameborder=0 noresize  style='height:27vh;width:99vw'></iframe>
		<iframe name='blankFrame' id='blankFrame'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:0vh;width:99vw'></iframe>
</html>

