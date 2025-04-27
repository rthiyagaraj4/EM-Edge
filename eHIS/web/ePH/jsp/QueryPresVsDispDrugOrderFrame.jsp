<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>


<html>                                
<head>                                
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../js/QueryDispLocnDrugs.js"></script> 
 	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>                               

<%
    String order_id=request.getParameter("order_id");
	String dt_from	=	request.getParameter("dt_from");
	String  dt_to	=	request.getParameter("dt_to");
	String  order_type	=	request.getParameter("order_type");
	String  order_status	=	request.getParameter("order_status");
	String  patient_class	=	request.getParameter("patient_class");
	String  location_type	=	request.getParameter("location_type");
	String  location_code	=	request.getParameter("location_code");
	String  disp_locn_code	=	request.getParameter("disp_locn_code");
	String  patient_id		=	request.getParameter("patient_id");

String url1= "../../ePH/jsp/QueryPresVsDispOrder.jsp?dt_from="+dt_from+"&dt_to="+dt_to+"&order_id="+order_id+"&order_type="+order_type+"&order_status="+order_status+"&patient_class="+patient_class+"&location_type="+location_type+"&location_code="+location_code+"&disp_locn_code="+disp_locn_code+"&patient_id="+patient_id;

%>

	<iframe name="f_orderdetailsframe" id="f_orderdetailsframe" src="<%=url1%>" frameborder="0" noresize scrolling="auto" style="height:80vh;width:100vw"></iframe>
	<iframe name="f_ordercolorframe" id="f_ordercolorframe" src="../../ePH/jsp/QueryPresVsDispOrderColor.jsp" noresize scrolling="auto" frameborder="0"  style="height:10vh;width:100vw"></iframe>
	<iframe name="f_orderdetailsframe" id="f_orderdetailsframe" src="../../eCommon/html/blank.html" noresize scrolling="auto" frameborder="0"  style="height:0vh;width:100vw"></iframe>

</html>

