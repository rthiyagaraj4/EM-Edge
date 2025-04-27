<!DOCTYPE html>
<!--Created by Thamizh selvi on 04/10/2016 for GDOH-CRF-0082-->
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script language="JavaScript" src="../../eMR/js/PMBCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<%
			request.setCharacterEncoding("UTF-8");
			String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = request.getQueryString() ;
			String source = url + params ;
			String mode="1";
		%>

		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
			<iframe name='queryFrame' id='queryFrame' src='../../eMR/jsp/PMBCodeQueryCriteria.jsp' frameborder=0 noresize scrolling='auto' style='height:82vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
	</head>

	<body onKeyDown='lockKey()'>
		<form name="form1" id="form1" action="../../eMR/jsp/PMBCodeQueryCriteria.jsp">
		</form>
	</body>

	<input type=hidden name="mode" id="mode" value="<%=mode%>">

</html>

