<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*" %>
<HTML>
<HEAD>
<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>


	
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
	
</HEAD>
<title><fmt:message key="ePH.PickList.label" bundle="${ph_labels}"/></title> 
<%
//added By Himanshu for COMMON-ICN-0182 
request.setCharacterEncoding("UTF-8");
String params = request.getQueryString();
%>
<iframe name="fill_list_info" id="fill_list_info" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/PHViewPickListInfo.jsp?<%=params%>" frameborder='0' style="height:17vh;width:100vw"></iframe><iframe name="fill_list" id="fill_list" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../ePH/jsp/PHViewPickList.jsp?<%=params%>" frameborder='0' style="height:78vh;width:100vw"></iframe><iframe name="fill_list_buttons" id="fill_list_buttons" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../ePH/jsp/PHViewPickListButtons.jsp?<%=params%>" frameborder='0' style="height:5vh;width:100vw"></iframe>
</HTML>

