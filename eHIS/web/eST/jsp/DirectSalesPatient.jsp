<!DOCTYPE html>
<%@page import="java.util.*, eST.*, eST.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->
 <%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
    String mode		=	"";
	String bean_id	=	"";
	String bean_name=	"";
	mode	= request.getParameter( "mode" ) ;
	bean_id = "directSalesPatient" ;
	bean_name = "eST.DirectSalesPatientBean";
			/* Initialize Function specific start */
	DirectSalesPatientBean bean = (DirectSalesPatientBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	/* Initialize Function specific end */
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	
		
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/DirectSalesPatient.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
    </script>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:20vh;width:100vw"></iframe>
<iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:62vh;width:100vw"></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:10vh;width:100vw"></iframe>
            <input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
</html>


