<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>


<html>                                
<head>                                
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="javascript" src="../js/PhCommon.js"></script>
 	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>                               

<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

	String	dt_from				=	request.getParameter("dt_from");
	String  dt_to				=	request.getParameter("dt_to");
	String  drug_code			=	request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
	String  trade_Code			=	request.getParameter("trade_Code")==null?"":request.getParameter("trade_Code");
	String	route_code			=   request.getParameter("route_code");
	//Added for CRF 430 (disploc_code,billinggroup_code)
	String  disploc_code		=	request.getParameter("disploc_code");
	String  billinggroup_code	=   request.getParameter("billinggroup_code");
	//String  billingYN	        =   request.getParameter("billingYN");
    String url1= "../../ePH/jsp/QueryDispDrugOrder.jsp?drug_code="+drug_code+"&dt_from="+dt_from+"&dt_to="+dt_to+"&route_code="+route_code+"&disploc_code="+disploc_code+"&billinggroup_code="+billinggroup_code+"&trade_Code="+trade_Code;
%>

<iframe name="f_drugdetailsframe" id="f_drugdetailsframe"  src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:8vh;width:98vw"></iframe><iframe name="f_orderdetailsframe" id="f_orderdetailsframe" src="<%=url1%>" frameborder="0" noresize scrolling="auto" style="height:60vh;width:98vw"></iframe><iframe name="f_totaldetailsframe" id="f_totaldetailsframe" src="../../eCommon/html/blank.html" frameborder="1" noresize scrolling="no" style="height:9vh;width:98vw"></iframe><iframe name="f_orderdetailsframe1" id="f_orderdetailsframe1" src="../../eCommon/html/blank.html" noresize scrolling="no" frameborder="0"  style="height:10vh;width:98vw"></iframe>
</html>

