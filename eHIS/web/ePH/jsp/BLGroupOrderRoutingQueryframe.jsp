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
	String param = request.getParameter("param");
	if (param == null) param = "";
	String function_id=request.getParameter("function_id");
	String mode			= request.getParameter("mode");
	String ordering_facility_desc=request.getParameter("ordering_facility_desc");
	String ordering_facility_id=request.getParameter("ordering_facility_id");
	String ordering_source_type_desc=request.getParameter("ordering_source_type_desc");
	String ordering_source_code=request.getParameter("ordering_source_code");
	String ordering_source_code_desc=request.getParameter("ordering_source_code_desc");
	String routing_level=request.getParameter("routing_level");
	String routing_code=request.getParameter("routing_code");
	String routing_code_desc=request.getParameter("routing_code_desc");
	String billing_group_code=request.getParameter("bl_group_code");
	String bl_cust_group_id=request.getParameter("bl_cust_group_id");
	String bl_cust_id=request.getParameter("bl_cust_id");
	String bl_polocy_id=request.getParameter("bl_polocy_id");
	
%>
		<iframe name="orderroutingforblquery_top" id="orderroutingforblquery_top" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/BLGroupOrderRoutingCharAddModify.jsp?function_id=<%=function_id%>&mode=<%=mode%>&ordering_facility_desc=<%=ordering_facility_desc%>&ordering_facility_id=<%=ordering_facility_id%>&ordering_source_type_desc=<%=ordering_source_type_desc%>&ordering_source_code=<%=ordering_source_code%>&ordering_source_code_desc=<%=ordering_source_code_desc%>&routing_level=<%=routing_level%>&routing_code=<%=routing_code%>&routing_code_desc=<%=routing_code_desc%>&billing_group_code=<%=billing_group_code%>&bl_cust_group_id=<%=bl_cust_group_id%>&bl_cust_id=<%=bl_cust_id%>&bl_polocy_id=<%=bl_polocy_id%>" style="height:50vh;width:100vw"></iframe>
		<iframe name="orderroutingforblquery_bottom" id="orderroutingforblquery_bottom" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:10vh;width:100vw"></iframe><iframe name="orderroutingforblqueryALT_bottom" id="orderroutingforblqueryALT_bottom" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:9vh;width:100vw"></iframe>
</html>

