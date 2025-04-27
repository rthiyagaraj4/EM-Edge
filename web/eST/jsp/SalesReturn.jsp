<!DOCTYPE html>
<%@ page import ="eST.SalesReturnBean" contentType="text/html;charset=UTF-8"%>  

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head> 
<%

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<script language='javascript' src='../../eST/js/SalesReturn.js'></script>
	<script language='javascript' src='../../eST/js/StTransaction.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String facilityid=(String)session.getValue("facility_id");
	
	java.util.Properties prop   = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		= prop.getProperty( "client_ip_address" );
	String bean_id				= "salesReturnBean"+login_at_ws_no;
	String bean_name			= "eST.SalesReturnBean";


	eST.SalesReturnBean bean = (eST.SalesReturnBean)getBeanObject( bean_id, bean_name , request);
	bean.setLanguageId(locale);

	bean.setfunction_id(request.getParameter( "function_id" ));  // Added by Padmapriya
	String site_id = bean.getCustomerID();
	if(!(bean.recordExists(facilityid, "ALL"))) {
		out.println("<script>alert(getMessage('FACILITY_PARAM_NOT_SET','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
	} 
		//Added for 29970	Bru-HIMS-CRF-095
	String homepage		= request.getParameter("homepage") == null?"N":request.getParameter("homepage");
	String count		= request.getParameter("count") == null?"0":request.getParameter("count");
%>
<%
//putObjectInBean("salesReturnBean",bean,request);
%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' style='height:6vh;width:100vw'></iframe>
	
	<% if(site_id.equals("MC")){%>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eST/jsp/SalesReturnQueryFrame.jsp?mode=2&<%=params%>" frameborder=0 scrolling='no' style='height:85vh;width:100vw'></iframe>
	<%}else{ %>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' style='height:85vh;width:100vw'></iframe>
	<%}%>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
<%
if(homepage.equals("Y") && !count.equals("0")){
%>
		<script>
				parent.workAreaFrame.f_query_add_mod.document.location.href="../../eST/jsp/SalesReturnQueryFrame.jsp?mode=2&<%=params%>";
		</script>
<%
}
%>
</html>

