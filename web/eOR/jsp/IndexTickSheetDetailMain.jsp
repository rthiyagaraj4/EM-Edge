<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/* 
------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------
?           100            	?           	?				?					created
09/10/2014	IN050655		VijayakumarK	09/10/2014							iASSIST ID : 807002 Index Tick sheet by practitioner is a 
																				good functionality to provide personalised tick sheets to practitioners.
------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head><title><fmt:message key="eOR.IndexTickSheet.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eOR/js/IndexTickSheet.js"></script>
<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
String index_type = request.getParameter("index_type");
String frameSize="";
if(index_type==null)index_type="";
if(index_type.equals("F"))
	//frameSize = "15%,65%";//IN050655
	frameSize = "*,65%";//IN050655
else
	//frameSize = "8%,79%";//IN050655
	frameSize = "*,79%";//IN050655
%>
<!--<iframe name="detailsHeaderFrame" id="detailsHeaderFrame" src= "../../eOR/jsp/IndexTickSheetDetail.jsp?<% //=request.getQueryString()%>" noresize frameborder="0"  framespacing='0' scrolling=no style="height:45vh;width:100vw"></iframe>--><!-- IN050655 CRR changes updated-->
<iframe name="detailsHeaderFrame" id="detailsHeaderFrame" src= "../../eOR/jsp/IndexTickSheetDetail.jsp?<%=request.getQueryString()%>"  frameborder="0"  framespacing='0' scrolling=no style="height:30vh;width:100vw"></iframe><!-- IN050655 -->
<iframe name="detailResultFrame" id="detailResultFrame" src='../../eCommon/html/blank.html' noresize frameborder="0" scrolling=no style="height:65vh;width:100vw" ></iframe>

</html>

