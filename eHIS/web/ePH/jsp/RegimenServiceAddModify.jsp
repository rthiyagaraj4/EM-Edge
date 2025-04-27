<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<!--RegimenServiceAddModify.jsp -->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
<script language='javascript' src='../js/RegimenService.js'></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");

	//String params = request.getQueryString() ;
	String mode = request.getParameter("mode");
	String frameSize = "25%,*";
	String src1  = "../../ePH/jsp/RegimenServiceAddModifyHeader.jsp?mode=1&function_id=Regimen Service";
	String src2  = "../../ePH/jsp/RegimenServiceAddModifyDetail.jsp?mode=1&function_id=Regimen Service";
	String queryStr ="";
	String code	=  "";
	String desc = "";
	String function_id		=  "";
	if(mode == null)
	mode ="";
	if(mode.equalsIgnoreCase("2"))
	{
		code	=	request.getParameter("code") ;
		desc	=	request.getParameter("desc") ;
		desc = java.net.URLDecoder.decode(desc);

		desc=desc.replaceAll(" ","%20");
		desc = java.net.URLEncoder.encode(desc);
		desc=desc.replaceAll("%2520","%20");
		function_id		=	request.getParameter("function_id") ;
		frameSize="5%,*" ;
		src1     ="../../eCommon/html/blank.html";
		src2	 ="../../ePH/jsp/RegimenServiceAddModifyDetail.jsp?";
		queryStr = "mode=2&code="+code+"&desc="+desc+"&function_id="+function_id ;
		src2 = src2 + queryStr ;
	}
%>
<iframe name='f_query_add_mod_header' id='f_query_add_mod_header' src='<%=src1%>'  frameborder=0 scrolling=no noresize style="height:15vh;width:99vw"></iframe>
	<iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail' src='<%=src2%>' frameborder=0 style="height:65vh;width:99vw"></iframe>
</html>

