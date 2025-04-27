<!DOCTYPE html>
<!--Created by Ashwini on 07-Jul-2017 for ML-MMOH-CRF-0702-->
<%@ page session="false" contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String params = request.getQueryString() ;
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String source = url + params ;
%>
<html>
<head>
<script language='javascript' src='../js/MedRecRequestId.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='med_rec_rep_id' id='med_rec_rep_id' src='../../eCommon/html/blank.html' frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</html>

