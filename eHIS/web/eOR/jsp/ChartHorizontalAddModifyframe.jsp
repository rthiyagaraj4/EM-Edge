<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<head>
<script language='javascript' src='../js/ChartHorizontal.js'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page session="false" import="eCommon.XSSRequestWrapper" %>
</head>
<%
/*	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;*/
	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode = request.getParameter("mode");
	String frameSize = "7%,*";
	
	String src1     ="../../eOR/jsp/ChartHorizontalAdd.jsp?mode=1&function_id=Organism";
	String src2  = "../../eOR/jsp/ChartHorizontalAddModify.jsp?mode=1&function_id=Organism";
	String queryStr ="";

	String chart_result_type_desc	=	"";
	String chart_result_type	=	"";
	String org_code		=  "";
	String function_id		=  "";
	
	if(mode == null)
	mode ="";

	if(mode.equalsIgnoreCase("2"))
	{	

		chart_result_type_desc	=	request.getParameter("chart_result_type_desc") ;
		chart_result_type	=	request.getParameter("chart_result_type") ;
		org_code	=	request.getParameter("org_code") ;
		function_id		=	request.getParameter("function_id") ;
	//	function_id		= "Organism";
		frameSize="100%,0%" ;
		src1	 ="../../eOR/jsp/ChartHorizontalAddModifySingle.jsp?";
		src2    ="../../eCommon/html/blank.html";
		queryStr = "mode=2&chart_result_type_desc="+chart_result_type_desc+"&chart_result_type="+chart_result_type+"&org_code="+org_code+"&function_id="+function_id ;
		src1 = src1 + queryStr ;
		
	}
%>
<frameset rows="<%=frameSize%>" frameSpacing="0">

	<frame name='f_query_add_mod_header' id='f_query_add_mod_header' src='<%=src1%>'  frameborder=0 scrolling = no noresize>
	
	<frame name='f_query_add_mod_detail' id='f_query_add_mod_detail' src='<%=src2%>' frameborder=0 scrolling = no noresize>

</frameset>
</html>

