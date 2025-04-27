<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper" %>
<%
	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	request.setCharacterEncoding("UTF-8");
	String  range_id = request.getParameter("range_id");
		if(range_id == null) range_id="";
	String range_type = request.getParameter("range_type");
		if(range_type == null) range_type="";
%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eAM/js/AgeRange.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='description' id='description'	src="../../eAM/jsp/addAgeRange.jsp?range_id=<%=range_id%>&range_type=<%=range_type%>"  frameborder=0 scrolling='no' noresize style='height:38.5vh;width:100vw'></iframe>
				<iframe name='range' id='range' 		src="../../eAM/jsp/RangeDisplay.jsp?range_id=<%=range_id%>&range_type=<%=range_type%>" scrolling='no' frameborder=0 style='height:61.5vh;width:100vw'></iframe>

</html>

