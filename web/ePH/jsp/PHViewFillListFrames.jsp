<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<HTML>
<HEAD>
	
<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>


	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</HEAD>
<title><fmt:message key="ePH.FillList.label" bundle="${ph_labels}"/></title> 
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String params = request.getQueryString();
%>
<iframe name="fill_list_info" id="fill_list_info" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/PHViewFillListInfo.jsp?<%=params%>" style="height:21vh;width:100vw"></iframe>
<iframe name="fill_list" id="fill_list" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../ePH/jsp/PHViewFillList.jsp?<%=params%>" style="height:73vh;width:100vw"></iframe>
<iframe name="fill_list_buttons" id="fill_list_buttons" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../ePH/jsp/PHViewFillListButtons.jsp?<%=params%>" style="height:5vh;width:100vw"></iframe>
</HTML>

