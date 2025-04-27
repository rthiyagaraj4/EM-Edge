<!DOCTYPE html>
 <%@page  import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>  

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!--  	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
<!-- 	<script language="JavaScript" src="../../eST/js/StMessages.js"></script>
 -->	<script language="JavaScript" src="../../eST/js/GoodsReturnToVendor.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id")%>";
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
	String params = request.getQueryString();
%>
<iframe name="GoodsReturnToVendorQueryHeader" id="GoodsReturnToVendorQueryHeader" frameborder="0" scrolling="no" noresize src="../../eST/jsp/GoodsReturnToVendorQueryCriteria.jsp?<%=params%>" style="height:15vh;width:100vw">
</iframe><iframe name="GoodsReturnToVendorQueryResult" id="GoodsReturnToVendorQueryResult" frameborder="0" src="../../eCommon/html/blank.html" scrolling="auto"  style="height:85vh;width:100vw"></iframe>
</html>

