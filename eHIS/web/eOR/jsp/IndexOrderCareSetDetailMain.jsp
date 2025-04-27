<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
<head><title><fmt:message key="eOR.IndexOrderSet.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/IndexOrderCareSet.js"></script>
<script language="JavaScript" src="../js/OrCommon.js"></script>
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
	frameSize = "20%,*%";
else
	frameSize = "12%,*%";
%>
<iframe name="detailsHeaderFrame" id="detailsHeaderFrame" src= "../../eOR/jsp/IndexOrderCareSetDetail.jsp?<%=request.getQueryString()%>" noresize frameborder="0"  framespacing='0' scrolling=no style="height:24vh;width:100vw"></iframe>
<iframe name="detailResultFrame" id="detailResultFrame" src='../../eCommon/html/blank.html' noresize frameborder="0" scrolling=no style="height:75vh;width:100vw" ></iframe>

</html>

