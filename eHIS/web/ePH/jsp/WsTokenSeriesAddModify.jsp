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

<% 
	request.setCharacterEncoding("UTF-8");	
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
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

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

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
	WsTokenSeriesBean bean = (WsTokenSeriesBean)getBeanObject(bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	/* Initialize Function specific end*/
%>

<FORM name="formWsTokenSeries" id="formWsTokenSeries">

<%
	if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
		ArrayList dispLocns = bean.getDispLocns();	
		
		if (dispLocns.size() != 0) {
%>

	<BR>
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="80%" ALIGN="center" BORDER="0">
	<TR>
		<TD WIDTH="30%" CLASS="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></TD>
		<TD COLSPAN="2">
			&nbsp;<SELECT name="DISP_LOCN" id="DISP_LOCN" onChange="displayWorkStations(this.value)">
				<OPTION VALUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>

<%
			for (int i=0; i<dispLocns.size(); i += 2) {

%>

				<OPTION VALUE="<%= dispLocns.get(i) %>"><%= dispLocns.get(i+1) %></OPTION>

<%
			}
%>

			</SELECT>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
		</TD>
	</TR>
<TR><TD colspan="3">&nbsp;</TD></TR>

<TR>
<TD WIDTH="30%" CLASS="label"><fmt:message key="Common.workstation.label" bundle="${common_labels}"/></TD>
		<TD COLSPAN="2">
			&nbsp;<SELECT name="WS_LOCN" id="WS_LOCN" onChange="displayTokens(this.value)">
				<OPTION VALUE="Select">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>

			</SELECT>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
		</TD>
	</TR>


<TR><TD colspan="3">&nbsp;</TD></TR>
	</TABLE>
	<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
	

<%
		}
		else {
%>

	<SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</SCRIPT>

<%
		}
	}
	putObjectInBean(bean_id,bean,request);
%>

</FORM>
</BODY>
</HTML>

