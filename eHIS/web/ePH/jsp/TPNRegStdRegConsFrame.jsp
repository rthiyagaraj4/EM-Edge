<!DOCTYPE html>
 <%-- saved 0n 24/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;cahrset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../js/PHmessages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNRegimen.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNStdRegimen.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="ePH.ConstituentsforStandardRegimen.label" bundle="${ph_labels}"/></title>
</HEAD>
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
String Reg_Code		= request.getParameter( "RegimenCode" ) ;
%>
<iframe  frameborder="0" scrolling="no" noresize src="../../ePH/jsp/TPNRegStdRegCons.jsp?RegimenCode=<%=Reg_Code%>" style="height:85vh;width:100vw"></iframe><iframe  frameborder="0" scrolling="no" noresize src="../../ePH/jsp/TPNRegStdRegConsButtons.jsp" style="height:15vh;width:100vw"></iframe>
</html>	

