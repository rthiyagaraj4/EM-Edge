<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.*, eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
<!-- 	<script language="JavaScript" src="../js/StMessages.js"></script> -->
	<script language="JavaScript" src="../js/SRRMasterCodeList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onload="FocusFirstElement()" >

<%
	/* Mandatory checks start */
//	String mode					=	request.getParameter( "mode" );
	String bean_id				=	"ReportsMasterCodeBean";
	String bean_name			=	"eST.ReportsMasterCodeBean";
	
	/* Initialize Function specific start */
	ReportsMasterCodeBean bean = (ReportsMasterCodeBean)getBeanObject( bean_id,bean_name,request ) ;  
//	bean.clear() ;
bean.setLanguageId(locale);
	/* Initialize Function specific end */

%>
		
<form name="formMasterCodeList" id="formMasterCodeList" >
<br>

<table cellpadding=0 cellspacing=0 width="70%" align="center">
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td class="label" width='35%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td align="left"  colspan="2">&nbsp;&nbsp;<select name="master_code" id="master_code" onchange="loadPage();"><option value="">&nbsp;&nbsp;&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------&nbsp;&nbsp;&nbsp;</option>
	<%
	
	ArrayList	arrMasterCode		=	null;
	HashMap		hmMasterCode		=	null;	
	String code = "",	desc		=	"";

	arrMasterCode		=	bean.getMasterCodeList();
	int arrLength		=	arrMasterCode.size();
	for(int i=0;i<arrLength; i++)
	{
		hmMasterCode      	=	(HashMap) arrMasterCode.get(i);
		code				=	(String)hmMasterCode.get("code");
		desc				=	(String)hmMasterCode.get("desc");
	
		%>
			<option value="<%=code%>"  ><%=desc%></option>
			
			<%
	}
	%>
	
	</select></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>

</html>

