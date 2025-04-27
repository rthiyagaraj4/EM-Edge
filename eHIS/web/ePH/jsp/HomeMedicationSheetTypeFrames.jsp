<!DOCTYPE html>
<!-- 
Developed by    :Arun Kumar M
Module/Function : Home Medication Sheet Type
-->
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../../ePH/js/HomeMedicationSheetType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String mode	= request.getParameter( "mode" )==null?"":request.getParameter( "mode" ) ;
	if(mode.equals("MODE_INSERT") ){
%>
		<iframe name="f_select_criteria" id="f_select_criteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/HomeMedicationSheetTypeCriteria.jsp" style="height:12vh;width:100vw"></iframe><iframe name="f_dtl_criteria" id="f_dtl_criteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/HomeMedicationSheetTypeDtl.jsp" style="height:98vh;width:100vw"></iframe>
<%
	}
%>
</html>

