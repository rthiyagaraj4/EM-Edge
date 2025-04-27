<!DOCTYPE html>
  <%@ page import="eST.CondemnExpiredBatchesHeaderBean" %>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'>
</link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language='javascript' src='../../eST/js/StCommon.js'></script>
<script language='javascript' src='../../eST/js/CondemnExpiredBatches.js'></script>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script>
<script language='javascript' src='../../eST/js/StMessages.js'></script> -->
<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script language="javascript" src="../../eST/js/StTransaction.js"></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
	<!-- Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 -->
	<title>CondemnExpiedBatches</title>
</head>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String facilityid=(String)session.getValue("facility_id");	
	String mode;
	mode	= request.getParameter( "mode" ) ;
	
	if(mode==null) {
		mode="1";
	}
String bean_id="condemnExpiredBatchesHeaderBean";
	String bean_name="eST.CondemnExpiredBatchesHeaderBean";
	//CondemnExpiredBatchesHeaderBean bean =  null;
	CondemnExpiredBatchesHeaderBean bean = (CondemnExpiredBatchesHeaderBean) getBeanObject( bean_id, bean_name,request);
	bean.setLanguageId(locale);
	// Passing login_facility_id, material_group_code as arguments
	if(!(bean.recordExists(facilityid, "ALL"))) {
		out.println("<script>alert(getMessage('FACILITY_PARAM_NOT_SET','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
	}
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013
   String disposable_yn = bean.checkForNull(request.getParameter( "disposable_yn"), "N");	
%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style="height:8vh;width:100vw"></iframe>
	<%if(disposable_yn.equals("Y")){ %> <!-- //Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 -->
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eST/jsp/CondemnExpiredBatchesFrame.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' style="height:8vh;width:100vw"></iframe>
	<%}else{ %>
    <iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' style="height:83vh;width:100vw"></iframe>
    <%} %>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style="height:9vh;width:100vw"></iframe>
	<%
putObjectInBean(bean_id,bean,request);
%>


</html>

