<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,eCommon.XSSRequestWrapper" %>

<html>
<head>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<script language='javascript' src='../../eOA/js/TransferClinicSch.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='summary' id='summary'  MARGINWIDTH=0 MARGINHEIGHT=0  FRAMEBORDER=NO scrolling='no' src='../../eOA/jsp/addmodifyTransferClinicSch.jsp'  style='height:28vh;width:100vw'></iframe>
	<iframe name ='detail' MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO   src='../../eCommon/html/blank.html'   style='height:50vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>

