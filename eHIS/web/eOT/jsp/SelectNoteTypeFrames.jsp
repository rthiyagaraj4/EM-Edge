<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<script language='javascript' src='../../eCommon/js/common.js'></script>

<%
	String params	= request.getQueryString();
	//String titledetails =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels");
%>
<html>
<head><title><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/> </title></head>
<iframe name="f_note_type_main" id="f_note_type_main"  scrolling="yes" noresize src="../../eOT/jsp/SelectNoteTypeMain.jsp?<%=params%>" style="height:100vh;width:100vw"></iframe>
<iframe name="f_set_user_attribute" id="f_set_user_attribute" scrolling="yes" noresize src="../../eCommon/html/blank.html" style="height:0vh;width:100vw"></iframe>

