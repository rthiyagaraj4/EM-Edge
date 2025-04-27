<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

	<head>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eST/js/UserAccessForStore.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id = "<%= request.getParameter( "function_id" ) %>"
			</script>
	</head>

	<%
		String bean_id = "userAccessForStoreBean";
		String bean_name = "eST.UserAccessForStoreBean";
	// Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
		String dflt_item_search =	 request.getParameter("dflt_item_search");
		System.out.println("dflt_item_search"+ dflt_item_search);
	// Added ends
		String mode = request.getParameter("mode");
		System.out.println("mode"+ mode);
		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		eST.UserAccessForStoreBean userAccessForStoreBean = (eST.UserAccessForStoreBean)getBeanObject( bean_id, bean_name, request );
		userAccessForStoreBean.setLanguageId(locale);
		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			userAccessForStoreBean.clear();
		}
	%>
	<%
putObjectInBean(bean_id,userAccessForStoreBean,request);
%>
	
	<iframe name="UserForStoreHeaderFrame" id="UserForStoreHeaderFrame" src="../../eST/jsp/UserAccessForStoreHeader.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling='no' style='height:30vh;width:100vw' noresize></iframe>
	<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
    <iframe name="UserForStoreListFrame" id="UserForStoreListFrame" src="../../eST/jsp/UserAccessForStoreDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize  style='height:69vh;width:100vw'></iframe>
    <% } else { %>

	<iframe name="UserForStoreListFrame" id="UserForStoreListFrame" src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize  style='height:69vh;width:100vw'></iframe>
	<% } %>

</frameset>

</html>

