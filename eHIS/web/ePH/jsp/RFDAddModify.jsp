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
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="JavaScript" src="../js/PhCommon.js"></script>	
	<!--<script language="Javascript" src="../../ePH/js/PhMessages.js"></script>-->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!--<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/RFD.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0"> -->
<body onMouseDown="" onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "RFDBean" ;
	String bean_name = "ePH.RFDBean";
	String logged_fcy="";
	
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	RFDBean bean = (RFDBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	bean.clear() ;
	bean.setMode( mode ) ; 
	/* Initialize Function specific end */



	
%>
<br>
<form name="formRFDDrug" id="formRFDDrug" >
<table cellpadding="0" cellspacing="0" width="90%" align="center" border="0">
<tr>	<td class="label" id="drug_td"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>&nbsp;</td>
		<td>
			<input type=text maxlength="15" name="drug_name" id="drug_name" readonly tabIndex="8" size=50 ><INPUT TYPE="button" name="drug_name_button" id="drug_name_button" VALUE="?" CLASS="button" onfocus="DrugSearch(document.formRFDDrug.drug_name)" onClick="DrugSearch(document.formRFDDrug.drug_name)" tabIndex="9">&nbsp;<img name="PhysicalLocMandatory" src="../../eCommon/images/mandatory.gif">
</td>
</tr>
</table>
<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%= bean.getFunctionId() %>">
<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= logged_fcy %>">
<INPUT TYPE="hidden" name="drug_name_query" id="drug_name_query" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_DRUGNAME_LOOKUP" ) %>">
<INPUT TYPE="hidden" name="drug_code" id="drug_code">
</form>

<script>

document.forms[0].drug_name.focus();</script>
<% putObjectInBean(bean_id,bean,request); %>

</body>
</HTML>

