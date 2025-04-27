<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
 
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eOR/js/ReplaceableOrderable.js"></script>

	<script language="JavaScript" src="../../eOR/js/ORGeneraOl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>

<%
	
	String mode= request.getParameter("mode")== null  ? "" :request.getParameter("mode").trim();
	String function_id= request.getParameter("function_id");
	String frameSize = "";
	
	String src1="";
	String src2="";
	String queryStr ="";

	//boolean flag=false;
	if(mode.equals("1"))
	{
		//out.println("<script>alert('mode="+mode+"');</script>");
	frameSize = "8%,*";
	src1  = "../../eOR/jsp/ReplaceableOrderableAddModifyHeader.jsp?mode=1&function_id="+function_id;
	src2  = "../../eOR/jsp/ReplaceableOrderableAddModifyDetail.jsp?mode=1&function_id="+function_id;
	queryStr ="";

	}	

	else if(mode.equals("2"))
	{
		
		String catalog_desc= "";
		String order_catalog_code_repl_desc = "";
		
		//flag = true;
	
		catalog_desc	=  request.getParameter("catalog_desc");
		order_catalog_code_repl_desc = request.getParameter("order_catalog_code_repl_desc");
			
		frameSize="100%,0%" ;
		src1	 ="../../eOR/jsp/ReplaceableOrderableUpdate.jsp?";
		src2     ="../../eCommon/html/blank.html";
		queryStr = "catalog_desc="+catalog_desc+"&order_catalog_code_repl_desc="+order_catalog_code_repl_desc+"&mode=2";
		src1 = src1 + queryStr ;

	}
	
%>

<frameset rows='<%=frameSize%>'>

	<frame name='f_query_add_mod_header' id='f_query_add_mod_header' src='<%=src1%>'  frameborder=0 scrolling='no' noresize>
	
	<frame name='f_query_add_mod_detail' id='f_query_add_mod_detail' src='<%=src2%>'  frameborder=0 scrolling='auto' noresize>

</frameset>
</html>

