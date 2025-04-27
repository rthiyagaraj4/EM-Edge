<!DOCTYPE html>
 <%@page import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	HolidayBean bean = (HolidayBean)getBeanObject( "holidayBean","ePH.HolidayBean", request ) ;
	bean.setLanguageId(locale);
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
 
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/Holiday.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
	<iframe name='holidayMainFrame' id='holidayMainFrame' src="../../ePH/jsp/HolidayAddModify.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:11vh;width:100vw'></iframe>
		<iframe name='holidayListResultFrame' id='holidayListResultFrame'			src="../../ePH/jsp/HolidayListResult.jsp?<%=request.getQueryString()%>"	frameborder=0 scrolling='auto' noresize style='height:87vh;width:100vw'></iframe>
	
<%
	putObjectInBean("holidayBean",bean,request);
%>
</HTML>

