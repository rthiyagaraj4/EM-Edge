<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086


		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../js/ATCClassification.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
<!-- 	<script language="Javascript" src="../../eCommon/js/messages.js"></script>
 -->	<!-- <script language="Javascript" src="../../eCommon/js/CommonMessages.js"></script> -->
</head>
<title><fmt:message key="ePH.PharmacologicalClassification.label" bundle="${ph_labels}"/></title>
<%
	String bean_id		=	"@ATCClassificationBean" ;
	String bean_name	=	 "ePH.ATCClassificationBean";
	ATCClassificationBean bean = (ATCClassificationBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
	bean.clear();
%>
<frameset rows='3%,47%,3%,47%' framespacing='0'>
	<frameset cols='33.3%,33.3%,33.3%' framespacing='0' >
		<frame name='f_level1' src="../../ePH/jsp/PharmacologicalHeader.jsp?level_num=1" frameborder=0 scrolling='no' noresize>
		<frame name='f_level2' src="../../ePH/jsp/PharmacologicalHeader.jsp?level_num=2" frameborder=0 scrolling='no' noresize>
		<frame name='f_level3' src="../../ePH/jsp/PharmacologicalHeader.jsp?level_num=3" frameborder=0 scrolling='no' noresize>
	</frameset>
	<frameset cols='33.3%,33.3%,33.3%' framespacing='0' >
		<frame name='f_level1_detail' src="../../ePH/jsp/PharmacologicalLevelDetail.jsp?level_num=1" frameborder=0 scrolling='yes' noresize style="border-style: solid; border-color:white;border-width:2">
		<frame name='f_level2_detail' src="../../eCommon/html/blank.html" frameborder=0 scrolling='yes' noresize style="border-style: solid; border-color: white;border-width:2">
		<frame name='f_level3_detail' src="../../eCommon/html/blank.html" frameborder=0 scrolling='yes' noresize style="border-style: solid; border-color: white;border-width:2">
	</frameset>
	<frameset framespacing='0'>
		<frame name='f_level4' src="../../ePH/jsp/PharmacologicalHeader.jsp?level_num=4" frameborder=0 scrolling='no' noresize>	
		<frame name='f_view_levels' src="../../ePH/jsp/PharmacologicalViewLevelFrames.jsp" frameborder=0 scrolling='yes' noresize style="border-style: solid; border-color:white;border-width:2">
	</frameset>
</frameset>
<% putObjectInBean(bean_id,bean,request ) ; %>
</html>
