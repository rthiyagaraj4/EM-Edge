<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
01/08/2018	IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776	
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
----------------------------------------------------------------------------------------------------------------------------------------------------------
-->
<!-- OROrderCatalog.jsp -->

<!-- Time Spend status
start time/Data = 20/jan/2003 3.00 clock

-->
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eOR/js/OrCommon.js"></script>
	<script language="javascript" src="../../eOR/js/OrderCatalog.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<!-- <script language="javascript" src="../js/OrMessages.js"></script> -->
	<script language="javascript" src="../../eOR/js/OrCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<script>function_id ="<%=request.getParameter("function_id")%>";</script>
<title><fmt:message key="eOR.OrderCatalog.label" bundle="${or_labels}"/></title>
<script>qry_str		="<%=request.getQueryString()%>";</script>
  <!-- <script>alert(qry_str)</script>   -->

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url					= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String module_id			= request.getParameter("module_id");
	String qry_str				= request.getQueryString();
	System.out.println("qry_str"+qry_str);
	System.out.println("OROrderCatalog.jsp request"+qry_str);
	String source1				= "../../eCommon/html/blank.html";
	String qry_str_toolBar		= qry_str;
	System.out.println("OROrderCatalog.jsp -- qry_str: "+qry_str); //added for skr-scf-1312

	
	
	//System.err.println("qry_str_toolBar=========================="+qry_str_toolBar);
	//module_id = "OR";
	//if(module_id.trim().equalsIgnoreCase("PH")){ 
	//	out.println("<script>alert('"+qry_str_toolBar+"')</script>");
	//}
	if(!module_id.trim().equalsIgnoreCase("OR")){
	 qry_str_toolBar ="module_id="+module_id  + "&function_id=OR_ORDER_MASTER&function_name=OrderCatalog&function_type=F&access=NYNNN&home_required_yn=N";
	source1 = "../../eOR/jsp/OrderCatalogAddModify.jsp?"+ qry_str;
	
	}

	String source	 = url + qry_str_toolBar	;


%>
<!-- For Testing Only -->
<!-- <script>qry_str="<%=qry_str%>";</script> -->
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
	<!--<frame name='f_query_add_mod' id='f_query_add_mod'    src='<%=source1%>' frameborder=0>--><!--IN64543-->
	<iframe name='f_query_add_mod' id='f_query_add_mod'    src='<%=source1%>' frameborder=0 scrolling='yes' style='height:85vh;width:100vw'></iframe><!--IN64543-->
	<iframe name='messageFrame' id='messageFrame'	     src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
</html>

