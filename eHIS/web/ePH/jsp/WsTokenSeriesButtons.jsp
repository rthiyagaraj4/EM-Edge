<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>

<% 
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!--<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	<!--<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="javascript" SRC="../js/WsTokenSeries.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<SCRIPT>
		var function_id = "<%= request.getParameter( "function_id" ).trim() %>"
	</SCRIPT>
</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ).trim() ;
	String bean_id = "WsTokenSeriesBean" ;
	String bean_name = "ePH.WsTokenSeriesBean";

	if ( mode == null || mode.equals("") )
		return ;

	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	WsTokenSeriesBean bean = (WsTokenSeriesBean)
getBeanObject(bean_id,bean_name ,request) ;
bean.setLanguageId(locale);

	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
putObjectInBean(bean_id,bean,request);
	/* Initialize Function specific end*/
%>

<FORM name="formWsTokenSeriesButtons" id="formWsTokenSeriesButtons">
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="80%" ALIGN="center" BORDER="0">
	<TR>
		<TD CLASS="clicked" ID="select_tab" WIDTH="25%" HEIGHT="20"><A HREF CLASS="tablink" onClick="onSelect(1)" onMouseOver="changeCursor(this)"><B><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></B></A></TD>
		<TD CLASS="normal" ID="assoc_tab" WIDTH="25%" HEIGHT="20"><A HREF CLASS="tablink" onClick="onSelect(2)" onMouseOver="changeCursor(this)"><B><fmt:message key="Common.Association.label" bundle="${common_labels}"/></B></A></TD>
		<TD WIDTH="50%" HEIGHT="20" STYLE="background-color:#FFFFFF">&nbsp;</TD>
	</TR>
	</TABLE>
</FORM>
</BODY>
</HTML>

