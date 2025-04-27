<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<% 
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = (String) session.getValue( "queryString" ) ;
	String source = url + params;

String func_idpassed = request.getParameter("func_idpassed")==null?"MP_MAIN_NB_REG":request.getParameter("func_idpassed");
%>
<!-- callPatSearch() is refactored to callPatientSearch() and moved to MaintainBirthRegistration.js -->
<html>
	<head>
		
		<script src='../../eMP/js/NewbornRegistration.js' language='javascript'></script>
			<script src='../../eMP/js/NewbornRegistration1.js' language='javascript'></script>
			<script src='../../eMP/js/NewbornRegistration2.js' language='javascript'></script>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src="../../eCommon/js/showModalDialog.js" language='JavaScript'></script>

	</head>
	<body onLoad="callPatientSearch('<%=source%>')" onKeyDown='lockKey();'>
		<form> 
		<input type=hidden name=func_idpassed id=func_idpassed value="<%=func_idpassed%>">
		</form>
	</body>
</html>

