<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../js/BLGroupOrderRouting.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String param = request.getParameter("param")==null?"":request.getParameter("param");
	if (param.equals("createIfFrameIsNull")){
%>
		<iframe name="orderroutingforbl_top" id="orderroutingforbl_top" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/BLGroupOrderRoutingCharAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_INSERT")%>" style="height:9vh;width:100vw"></iframe>
		<iframe name="orderroutingforbl_middle" id="orderroutingforbl_middle" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/BLGroupOrderRoutingLocnDetAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_INSERT")%>" style="height:34vh;width:100vw"></iframe>
		<iframe name="orderroutingforbl_bottom" id="orderroutingforbl_bottom" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/BLGroupOrderRoutingLocationAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_INSERT")%>" style="height:20vh;width:100vw"></iframe>
		<iframe name="orderroutingforbl_ALTDisplocation_header" id="orderroutingforbl_ALTDisplocation_header" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:4vh;width:100vw"></iframe>
		<iframe name="orderroutingforbl_ALTDisplocation_detail" id="orderroutingforbl_ALTDisplocation_detail" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:30vh;width:100vw"></iframe>
		<iframe name="orderroutingforbl_Buttons" id="orderroutingforbl_Buttons" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/BLGroupOrderRoutingButtons.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_INSERT")%>" style="height:5vh;width:100vw"></iframe>
<%
	}
	else{
%>
		<iframe name="orderroutingforbl_top" id="orderroutingforbl_top" frameborder="0" scrolling="no" noresize  src="../../eCommon/html/blank.html" style="height:8vh;width:100vw"></iframe>
		<iframe name="orderroutingforbl_middle" id="orderroutingforbl_middle" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:34vh;width:100vw"></iframe>
		<iframe name="orderroutingforbl_bottom" id="orderroutingforbl_bottom" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:20vh;width:100vw"></iframe>
		<iframe name="orderroutingforbl_ALTDisplocation_header" id="orderroutingforbl_ALTDisplocation_header" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:4vh;width:100vw"></iframe>
		<iframe name="orderroutingforbl_ALTDisplocation_detail" id="orderroutingforbl_ALTDisplocation_detail" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:24vh;width:100vw"></iframe>
		<iframe name="orderroutingforbl_Buttons" id="orderroutingforbl_Buttons" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:5vh;width:100vw"></iframe>
<%
	}
%>
</html>

