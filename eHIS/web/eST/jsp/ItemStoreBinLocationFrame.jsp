<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<!-- 		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
 <%
		 request.setCharacterEncoding("UTF-8");
		 String locale			=		(String)session.getAttribute("LOCALE");
		 String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!--<script language="javascript" src="../../eCommon/common/messages.js"></script> -->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<!--<script language="javascript" src="../../eST/js/StMessages.js"></script>
		<script language="javascript" src="../../eMM/js/MmMessages.js"></script> -->
		<script language="javascript" src='../../eST/js/ItemStoreBinLocation.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id			=			"<%= request.getParameter( "function_id" ) %>"
		</script>
	</head>
	<%
		String bean_id			=			"ItemStoreBinLocationBean";
		String bean_name		=			"eST.ItemStoreBinLocationBean";
		String mode				=			request.getParameter("mode");

		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;

		eST.ItemStoreBinLocationBean itemStoreBinLocationBean = (eST.ItemStoreBinLocationBean) getBeanObject( bean_id,bean_name,request);
		itemStoreBinLocationBean.setLanguageId(locale);
		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			itemStoreBinLocationBean.initialize();
		}
	%>
	<iframe name="frameItemStoreBinLocationHeader" id="frameItemStoreBinLocationHeader" src="../../eST/jsp/ItemStoreBinLocationHeader.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling='no' noresize style='height:65%;width:100vw'></iframe>
	<iframe name="frameItemStoreBinLocationDetail" id="frameItemStoreBinLocationDetail" src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>

<%
	putObjectInBean(bean_id,itemStoreBinLocationBean,request);
%>
</html>

