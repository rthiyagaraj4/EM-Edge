<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>

<html>
<head>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../js/SectionForTickSheet.js'></script>
<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%@ page session="false" %> 
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode=request.getParameter("mode").trim();
	if(mode==null)mode="";
	
	
String order_category= request.getParameter("order_category");
String tick_sheet_id= request.getParameter("tick_sheet_id");
String	 eff_status = request.getParameter("eff_status");
String section_code = request.getParameter("section_code");
String	 section_desc = request.getParameter("section_desc");
String	 order_category_short_desc=request.getParameter("order_category_short_desc");
String	 tick_sheet_desc=request.getParameter("tick_sheet_desc");

if(order_category == null || order_category.equals("") ) order_category=""; else order_category.trim();
if(tick_sheet_id == null || tick_sheet_id.equals("") )tick_sheet_id=""; else tick_sheet_id.trim();
if(eff_status == null || eff_status.equals("") )eff_status=""; else eff_status.trim();
if(section_code == null || section_code.equals("") )section_code=""; else section_code.trim();
if(order_category_short_desc == null || order_category_short_desc.equals("") )order_category_short_desc=""; else order_category_short_desc.trim();
if(tick_sheet_desc == null || tick_sheet_desc.equals("") )tick_sheet_desc=""; else tick_sheet_desc.trim();
if(section_desc == null || section_desc.equals("") )section_desc=""; else section_desc.trim();
%>
<!-- <frameset rows='15%,*'> -->
	<iframe name='f_query_add_mod_header' src='../../eOR/jsp/SectionForTickSheetAddModifyHeader.jsp?order_category=<%=order_category%>&tick_sheet_id=<%=tick_sheet_id%>&section_code=<%=section_code%>&section_desc=<%=section_desc%>&eff_status=<%=eff_status %>&tick_sheet_desc=<%=tick_sheet_desc%>&order_category_short_desc=<%=order_category_short_desc%>&mode=1'  frameborder=0 scrolling='no' noresize style='height:15vh;width:100vw'></iframe> 	
	<iframe name='f_query_add_mod_detail'  src='../../eOR/jsp/SectionForTickSheetAddModifyDetail.jsp?order_category=<%=order_category%>&tick_sheet_id=<%=tick_sheet_id%>&section_code=<%=section_code%>&section_desc=<%=section_desc%>&eff_status=<%=eff_status %>&tick_sheet_desc=<%=tick_sheet_desc%>&order_category_short_desc=<%=order_category_short_desc%>&mode=1' frameborder=0 scrolling='no' noresize style='height:80vh;width:100vw'> </iframe>
<!-- </frameset> -->
