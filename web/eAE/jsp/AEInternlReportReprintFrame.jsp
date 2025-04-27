<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<title><fmt:message key="Common.internalreport.label" bundle="${common_labels}"/></title>
	<%
	   request.setCharacterEncoding("UTF-8");
	   request= new XSSRequestWrapper(request);
	   response.addHeader("X-XSS-Protection", "1; mode=block");
	   response.addHeader("X-Content-Type-Options", "nosniff");
	%>

		<iframe name='pline' id='pline' src='../../eCommon/jsp/pline.jsp?Facility_Id=<%=(String)session.getValue("facility_id")%>&EncounterId=<%=request.getParameter("encounterid")%>' Frameborer=no noresize scrolling=no style='height:12vh;width:100vw'></iframe>
		<iframe name='comps' id='comps' src='AEInternlReportReprintComp.jsp?encounter_id=<%=request.getParameter("encounterid")%>&mode=view&file_created_at_regn_yn=<%=request.getParameter("file_created_at_regn_yn")%>&gen_file_no=<%=request.getParameter("gen_file_no")%>' Frameborer=no noresize style='height:88vh;width:100vw'></iframe>

<head>
<html>
