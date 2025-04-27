<!DOCTYPE html>
<!-- Created jsp against NMC-JD-CRF-0011 -->
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.Hashtable,java.util.ArrayList,java.util.HashMap,java.util.Enumeration,eBL.Common.*,eBL.*,eCommon.Common.*,webbeans.eCommon.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eBL/js/BLRevnRecgStage.js'></script>		
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String beanId = "bl_BLRevenueStageBean";
	String beanName = "eBL.BLRevenueStageBean";

	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server 

	BLRevenueStageBean bean = (BLRevenueStageBean) getBeanObject(beanId, beanName, request);
	cleanBeanObject(beanId, beanName, request);
	bean.clear();
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
<script>
    <%	request.setCharacterEncoding("UTF-8");	%>
	function_id = "<%=request.getParameter("function_id")%>";
</script>
</head>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y";
	String params = request.getQueryString();
	String source = url + params;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%= source %>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='revenuedetail' id='revenuedetail' id='revenuedetail' src='BLRevnRecgStage.jsp' scrolling='no' frameborder=0 style='height:83vh;width:100vw'> </iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
	<body>
</form>	
</body>	
</html>

