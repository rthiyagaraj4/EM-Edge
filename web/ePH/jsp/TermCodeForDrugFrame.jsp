<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/TermCodeForDrug.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/DateUtils.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String bean_id	=	"TermCodeForDrug";
	String bean_name	=	"ePH.TermCodeForDrugBean";
%>
<%
	String param	= request.getParameter("param");
	String params	= request.getQueryString();

		
%>
	<iframe name="TermCodeAddModifyFrame" id="TermCodeAddModifyFrame" frameborder="0" scrolling="no" noresize   src="../../ePH/jsp/TermCodeForDrugAddModify.jsp?" style="height:20vh;width:100vw"></iframe>
	<iframe name="TermCodeResultFrame" id="TermCodeResultFrame" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/TermCodeForDrugQueryResult.jsp?" style="height:79vh;width:100vw"></iframe>
</html>

