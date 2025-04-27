<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<TITLE><fmt:message key="eST.StockAvailability.label" bundle="${st_labels}"/></TITLE>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNWorkSheet.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
	String item_list	= request.getParameter("item_list");
%>

<!-- <BODY> -->
<body onMouseDown="" onKeyDown="lockKey()">
<FORM name="formTPNWorkSheetChooseItem" id="formTPNWorkSheetChooseItem">
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
		<TR >
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR >
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD CLASS="label" ALIGN="right">
				<fmt:message key="Common.item.label" bundle="${common_labels}"/>
			</TD>
			<TD ALIGN="left">&nbsp;&nbsp;
				<SELECT name="item_code" id="item_code">
					<OPTION VALUE="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>

<%
	String item = "";
	StringTokenizer st = new StringTokenizer(item_list, ",");
	while (st.hasMoreTokens()) {
		item = st.nextToken();
%>
					<OPTION VALUE="<%= item %>"><%= item %></OPTION>

<%
	}
%>

				</SELECT>
			</TD>
		</TR>
		<TR >
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD COLSPAN="2" ALIGN="right">
				<INPUT TYPE="button" name="btnOk" id="btnOk" VALUE='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="assignItemCode('1')" CLASS="button">
				<INPUT TYPE="button" name="btnCancel" id="btnCancel" VALUE='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="assignItemCode('2')" CLASS="button">
			</TD>
		</TR>
	</TABLE>
</FORM>
</BODY>
</HTML>

