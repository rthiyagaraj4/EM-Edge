<!DOCTYPE html>

 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
		String locale = (String) session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/ExternalProductLink.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
	/* Mandatory checks start*/
	String mode			= request.getParameter("mode") ;
	String bean_id = "ExternalProductLinkBean" ;
	String bean_name = "ePH.ExternalProductLinkBean";
	
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT"))))
		return ;
	/* Mandatory checks end */
	/* Initialize Function specific start */
	ExternalProductLinkBean bean = (ExternalProductLinkBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	bean.setMode( mode ) ;
		
	String sql_genericlookup		=	PhRepository.getPhKeyValue("SQL_PH_EXT_PROD_LINK_SELECT3");
	/* Initialize Function specific end */
%>
<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">-->
<!-- <body onLoad="FormExtProductCriteria.mm_generic_name.focus();"> -->
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="FormExtProductCriteria.mm_generic_name.focus();">
		<FORM name="FormExtProductCriteria" id="FormExtProductCriteria">
			<TABLE CELLPADDING="1" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
				<tr>
					<th colspan=4 align="left"> <fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>
					</th>
				</tr>
				<TR>
					<TD CLASS="label" ALIGN="right" nowrap WIDTH="15%"><fmt:message key="ePH.eHISDatabase.label" bundle="${ph_labels}"/></TD>
					<td align="left" WIDTH="35%" >&nbsp;<input type="text" name="mm_generic_name" id="mm_generic_name" maxlength="40" size="30" value=""
					onBlur="FormExtProductCriteria.ext_generic_name.value=this.value"><input type="button" class="button" value="?" name="generic_search" id="generic_search" onclick="searchGenericName(
					FormExtProductCriteria.mm_generic_name);">&nbsp;<img src="../../eCommon/images/mandatory.gif"></TD>
					<TD CLASS="label" ALIGN="right" WIDTH="15%" nowrap><fmt:message key="ePH.ExtDatabase.label" bundle="${ph_labels}"/></TD>
					<td align="left" WIDTH="35%">&nbsp;
					<input type="text" name="ext_generic_name" id="ext_generic_name" maxlength="20" size="20" value="">&nbsp;<img src="../../eCommon/images/mandatory.gif" >
					<input type=button value='<fmt:message key="Common.Go.label" bundle="${common_labels}"/>' class="button" style="width:21px" onClick="callResultPage()">
					</TD>
				</TR>
			</TABLE>
			<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
			<INPUT TYPE="hidden" name="lookup_query" id="lookup_query" VALUE="<%= sql_genericlookup %>">
			<INPUT TYPE="hidden" name="generic_code" id="generic_code" VALUE="">

		</FORM>
	</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

