<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--TickSheetsAddModifyMultiple.jsp -->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<script language='javascript' src='../../eOR/js/TickSheets.js'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page session="false" %>
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;
	String mode = request.getParameter("mode");
	String frameSize = "6%,*";
	
	String src1  = "../../eOR/jsp/TickSheetsAddModifyHeader.jsp?mode=1&function_id=Tick_Sheets";
	String src2  = "../../eOR/jsp/TickSheetsAddModifyDetail.jsp?mode=1&function_id=Tick_Sheets";
	String queryStr ="";

	String order_category_desc	=  "";
	String order_category		=  "";
	String tick_sheet_id		=  "";
	String function_id		=  "";
	
	if(mode == null)
	mode ="";

	if(mode.equalsIgnoreCase("2"))
	{
		tick_sheet_id	=	request.getParameter("tick_sheet_id") ;
		order_category	=	request.getParameter("order_category") ;
		order_category_desc	=	request.getParameter("order_category_desc") ;
		function_id		=	request.getParameter("function_id") ;
		frameSize="100%,0%" ;
		src1	 ="../../eOR/jsp/TickSheetsAddModifySingle.jsp?";
		src2     ="../../eCommon/html/blank.html";
		queryStr = "mode=2&tick_sheet_id="+tick_sheet_id+"&order_category="+order_category+"&order_category_desc="+order_category_desc+"&function_id="+function_id ;
		src1 = src1 + queryStr ;
	}
%>
<frameset rows=<%=frameSize%>>

	<frame name='f_query_add_mod_header' src='<%=src1%>'  frameborder=0 scrolling='no'>
	
	<frame name='f_query_add_mod_detail' src='<%=src2%>' frameborder=0 scrolling='no'>

</frameset>
</html>

