<!DOCTYPE html>
<!-- /*  Developed By Prabhu.M
		 Date -- 06/07/2004
		 Functionality -- OP/Catalog for Clinic	
*/ -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<!--<script src='../../eAM/js/ServiceSetsDetail.js' language='javascript' ></script>-->
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<!--<script src='../../or/js/ServiceCategory.js' language='javascript'></script>-->
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 		
	String visit_type_id=request.getParameter("visit_type_id");
	String order_cat_id=request.getParameter("order_cat_id");
	
	if( visit_type_id == null) visit_type_id="";
	if( order_cat_id == null) order_cat_id="";
	
%>
<iframe name='query' id='query' 	src='../../eOP/jsp/CatalogForClinicQuery.jsp?visit_type_id=<%=visit_type_id%>&order_cat_id=<%=order_cat_id%>' frameborder=0 scrolling='no' style='height:14vh;width:100vw'></iframe>
<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:80vh;width:100vw'></iframe>

</html>

