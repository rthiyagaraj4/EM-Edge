<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, java.net.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/ReissueMed.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</HEAD>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String disp_locn = request.getParameter("disp_locn");
	String disp_locn_desc = request.getParameter("disp_locn_desc");
	String QSource = "../../ePH/jsp/ReissueMedQuery.jsp?disp_locn="+disp_locn+"&disp_locn_desc="+URLEncoder.encode(disp_locn_desc);

%>

	<iframe name="commontoolbarFrame" id="commontoolbarFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC=<%=  request.getParameter("source") %> style="height:8vh;width:100vw"></iframe>
	<iframe name="f_query_add_mod" id="f_query_add_mod" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC=<%=QSource %> style="height:11vh;width:100vw"></iframe>
	<iframe name="f_query_add_mod_result" id="f_query_add_mod_result" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:18vh;width:100vw"></iframe>
	<iframe name="f_query_add_mod_detail" id="f_query_add_mod_detail" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:19vh;width:100vw"></iframe>
	<iframe name="f_query_add_mod_result_det" id="f_query_add_mod_result_det" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:25vh;width:100vw"></iframe>
	<iframe name="buttonFrame1" id="buttonFrame1" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:8vh;width:100vw"></iframe>
	<iframe name="messageFrame" id="messageFrame" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/jsp/error.jsp" style="height:8vh;width:100vw"></iframe>
</HTML>

