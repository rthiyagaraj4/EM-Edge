<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<title><fmt:message key="Common.internalreport.label" bundle="${common_labels}"/></title>
	<frameset  rows='12%,*' FRAMEBORDER='0' framespacing='1'>
		<frame name='pline' id='pline' src='../../eCommon/jsp/pline.jsp?Facility_Id=<%=(String)session.getValue("facility_id")%>&EncounterId=<%=request.getParameter("encounterid")%>' Frameborer=no noresize scrolling=no>
		<frame name='comps' id='comps' src='OpinternlReportReprintComp.jsp?encounter_id=<%=request.getParameter("encounterid")%>&mode=view&file_created_at_regn_yn=<%=request.getParameter("file_created_at_regn_yn")%>&gen_file_no=<%=request.getParameter("gen_file_no")%>' Frameborer=no noresize>
	<frameset>
<head>
<html>

