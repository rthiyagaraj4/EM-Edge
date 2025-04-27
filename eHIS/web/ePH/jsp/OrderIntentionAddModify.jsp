<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<!--OrderIntentionAddModify.jsp -->
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<head>
<script language='javascript' src='../js/OrderIntention.js'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	String mode = request.getParameter("mode");
	String frameSize = "25%,*";
	
	String src1  = "../../ePH/jsp/OrderIntentionAddModifyHeader.jsp?mode=1&function_id=Order Intention";
	String src2  = "../../ePH/jsp/OrderIntentionAddModifyDetail.jsp?mode=1&function_id=Order Intention";
	String queryStr ="";

	String code	=  "";
	String function_id		=  "";
	
	if(mode == null)
	mode ="";

	if(mode.equalsIgnoreCase("2"))
	{
		code	=	request.getParameter("code") ;
		function_id		=	request.getParameter("function_id") ;

		frameSize="5%,*" ;
		src1     ="../../eCommon/html/blank.html";
		src2	 ="../../ePH/jsp/OrderIntentionAddModifyDetail.jsp?";

		queryStr = "mode=2&code="+code+"&function_id="+function_id ;
		src2 = src2 + queryStr ;
	}
%>
<iframe name='f_query_add_mod_header' id='f_query_add_mod_header' src='<%=src1%>'  frameborder=0 style='height:15vh;width:98vw'></iframe>
<iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail' src='<%=src2%>' frameborder=0 style='height:60vh;width:98vw'></iframe>
</html>

