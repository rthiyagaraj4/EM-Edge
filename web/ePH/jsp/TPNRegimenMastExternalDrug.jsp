<!DOCTYPE html>
 <%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNRegimenMast.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY TOPMARGIN="0" onKeyDown="lockKey()" onMouseDown="CodeArrest()">

<%
	
	String bean_id		= "TPNRegimenMastBean" ;
	String bean_name	= "ePH.TPNRegimenMastBean";

	TPNRegimenMastBean bean		= (TPNRegimenMastBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	
	//String	external_drug_id	= "";
	String  external_db			= "";

	external_db		 			= bean.getExternalDrug();
%>

<FORM name="TPNRegimenMastExternalDrug" id="TPNRegimenMastExternalDrug">
	<BR><BR><BR>
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR><TD COLSPAN="2">&nbsp;</TD></TR>
	<TR>
		<TD CLASS="label"><fmt:message key="ePH.ExternalProduct.label" bundle="${ph_labels}"/></TD>
		<TD>&nbsp;&nbsp;<INPUT TYPE="text" name="external_drug_name" id="external_drug_name" SIZE="40" VALUE="<%=external_db%>"><INPUT TYPE="button" VALUE="?" CLASS="button" onClick="callExternalDBSearch('','');"><INPUT TYPE="hidden" name="external_drug_id" id="external_drug_id" VALUE="<%=external_db%>"></TD>
	</TR>
	<TR><TD COLSPAN="2">&nbsp;</TD></TR>
	</TABLE>
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
</FORM>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>

