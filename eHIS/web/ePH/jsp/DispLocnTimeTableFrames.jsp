<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/DispLocnTimeTable.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
    <!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	
%>
<%
	//String param	= request.getParameter("param");
	//String params	= request.getQueryString();
    String mode=request.getParameter("mode");
		
%>
	<iframe name="DispLocnTimeTableFrame" id="DispLocnTimeTableFrame" frameborder="0" scrolling="no" noresize   src="../../ePH/jsp/DispLocnTimeTableHeader.jsp?mode=<%=mode%>" style="height:4vh;width:100vw"></iframe><iframe name="DispLocnTimeTableDetailsFrame" id="DispLocnTimeTableDetailsFrame" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispLocnTimeTableDetail.jsp?" style="height:7vh;width:100vw"></iframe>
</html>

