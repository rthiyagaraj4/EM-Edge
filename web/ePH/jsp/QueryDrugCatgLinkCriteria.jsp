<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/QueryDrugCatgLink.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<FORM name="formQueryDrugCatgLinkCriteria" id="formQueryDrugCatgLinkCriteria" >
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR>
		<TD WIDTH="15%" CLASS="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></TD>
		<TD WIDTH="30%">&nbsp;
		
			<input type="text" name="drug_name" id="drug_name"
		 maxlength="40" size="40" value=""  ><input type="button" class="button" value="?" name="DRUG_SEARCH" id="DRUG_SEARCH" onclick="searchDrugName1(this);">


			<INPUT TYPE="hidden" name="DRUG_CODE" id="DRUG_CODE" VALUE="">
		</TD>
		<TD COLSPAN="2" CLASS="label">&nbsp;<INPUT TYPE="radio" name="LINKED_OR_NOT" id="LINKED_OR_NOT" CHECKED VALUE="Y">&nbsp;<fmt:message key="ePH.Linked.label" bundle="${ph_labels}"/></TD>
	</TR>
	<TR>
		<TD WIDTH="15%" CLASS="label"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></TD>
		<TD WIDTH="30%">&nbsp;
			<SELECT name="DRUG_CLASS" id="DRUG_CLASS">
				<OPTION VALUE=""> --<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-- </OPTION>
				<OPTION VALUE="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></OPTION>
			</SELECT>
		</TD>
		<TD WIDTH="15%" CLASS="label">&nbsp;<INPUT TYPE="radio" name="LINKED_OR_NOT" id="LINKED_OR_NOT" VALUE="N">&nbsp;<fmt:message key="ePH.NotLinked.label" bundle="${ph_labels}"/></TD>
		<TD WIDTH="15%"><INPUT TYPE="button" CLASS="button" name="SEARCH" id="SEARCH" VALUE='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResultPage1()"></TD>
	</TR>
	</TABLE>
	<INPUT TYPE="hidden" name="SELECT_SQL" id="SELECT_SQL" VALUE="<%= PhRepository.getPhKeyValue("SQL_PH_DRUG_ORDER_CAT_NOT_LINK_SELECT1") %>">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
</FORM>
</BODY>
</HTML>

