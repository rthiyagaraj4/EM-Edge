<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<!--<script src='../../eAM/js/ServiceSetsDetail.js' language='javascript' ></script>-->
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<% 	
	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	request.setCharacterEncoding("UTF-8");
	String spltycode=request.getParameter("specialty_code");
	String order_cat_id=request.getParameter("order_cat_id");
	
	if( spltycode == null) spltycode="";
	if( order_cat_id == null) order_cat_id="";
	
%>
<iframe name='query' id='query' 	src='../../eAM/jsp/CatalogForSpecialtyQuery.jsp?spltycode=<%=spltycode%>&order_cat_id=<%=order_cat_id%>' frameborder=0 scrolling='no' style='height:20vh;width:98vw'></iframe>
<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:75vh;width:98vw'></iframe>

</html>

