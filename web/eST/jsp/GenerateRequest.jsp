<!DOCTYPE html>
 <%@ page import="eST.GenerateRequestBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eST/js/GenerateRequest.js'></script>
<script language='javascript' src='../../eST/js/StCommon.js'></script>
<script language='javascript' src='../../eST/js/StTransaction.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
        function_id = "<%=request.getParameter("function_id")%>"
		menu_id		= "<%=request.getParameter("menu_id")%>"
		module_id	= "<%=request.getParameter("module_id")%>"
</script>
</head> 
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString();
	String source = url + params;
	String facilityid=(String)session.getValue("facility_id");

	GenerateRequestBean generateRequestBean = (GenerateRequestBean)getBeanObject( "generateRequestBean","eST.GenerateRequestBean", request);  

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	

	generateRequestBean.setLanguageId(locale);

	// Passing login_facility_id, material_group_code as arguments
	if(!(generateRequestBean.recordExists(facilityid, "ALL"))) {
		out.println("<script>alert(getMessage('FACILITY_PARAM_NOT_SET','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
	}
%>
<%
putObjectInBean("generateRequestBean",generateRequestBean,request);
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%=source%>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eST/jsp/GenerateRequestFrame.jsp?<%=params%>" frameborder=0 scrolling='no' style='height:82vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>

