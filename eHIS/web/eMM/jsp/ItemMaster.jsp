<!DOCTYPE html>
<!-- <jsp:useBean id="obj7" scope="page" class="eST.ItemSearchBean" /> -->
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
request.setCharacterEncoding("UTF-8");
//String locale			= (String)session.getAttribute("LOCALE");
//String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<script language="JavaScript" src="../../eMM/js/Item.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
				<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
	<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eMM/js/MmMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>
	<%
//		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
/*		String source = url + params ;
		String flag = request.getParameter("flag");
		//System.out.println("query string==="+flag);*/
	%>
	<title><fmt:message key="eMM.ItemMaster.label" bundle="${mm_labels}"/></title>
	<iframe name='qryCriteria' id='qryCriteria' src="../../eMM/jsp/ItemMasterQueryCriteria.jsp?<%=params%>" frameborder=0  scrolling='no' style='height:44vh;width:99vw'></iframe>
	<iframe name='qryResult' id='qryResult' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:54vh;width:99vw'></iframe>
</html>
 

