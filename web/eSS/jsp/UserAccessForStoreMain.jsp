<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.Properties, eSS.Common.SsRepository, eSS.* " contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language='javascript' src='../../eSS/js/UserAccessForStore.js'></script>
		<script language="JavaScript" src="../../eSS/js/SsCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id = "<%= request.getParameter( "function_id" ) %>"
		</script>
	</head>
	<%
		String bean_id = "userAccessForStore";
		String bean_name = "eSS.UserAccessForStoreBean";
		String mode = request.getParameter("mode");
		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		eSS.UserAccessForStoreBean userAccessForStoreBean = (eSS.UserAccessForStoreBean) getBeanObject( bean_id,   bean_name,request);
		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			userAccessForStoreBean.clear();
		}
	%>
	<iframe name="UserForStoreHeaderFrame" id="UserForStoreHeaderFrame" src="../../eSS/jsp/UserAccessForStoreHeader.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling='no' noresize style='height:15vh;width:100vw'></iframe>
	<iframe name="UserForStoreListFrame" id="UserForStoreListFrame" src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize style='height:84vh;width:100vw'></iframe>

<%
putObjectInBean(bean_id,userAccessForStoreBean,request);
%>

</html>

