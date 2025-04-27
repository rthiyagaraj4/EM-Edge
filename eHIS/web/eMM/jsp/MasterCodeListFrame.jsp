<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eMM.*, eMM.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
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
//locale ="en";
//String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/MmCommon.js"></script>
	<!-- <script language="JavaScript" src="../js/MmMessages.js"></script> -->
	<script language="JavaScript" src="../js/MasterCodeList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onload="FocusFirstElement()" >

<%
	/* Mandatory checks start */
//	String mode					=	request.getParameter( "mode" );
	String bean_id				=	"ReportsMasterCodeBeanMM";
	String bean_name			=	"eMM.ReportsMasterCodeBeanMM";
	
	/* Initialize Function specific start */
	ReportsMasterCodeBeanMM bean = (ReportsMasterCodeBeanMM)getBeanObject( bean_id,bean_name,request ) ;  
	bean.clear() ;
bean.setLanguageId(locale);		
	/* Initialize Function specific end */

%>
		
<form name="MasterCodeListFrame" id="MasterCodeListFrame" >
<br>

<table cellpadding=0 cellspacing=0 width="70%" align=center>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label" width='35%'>Code</td>
	<td class=fields   colspan="2">&nbsp;&nbsp;<select name="master_code" id="master_code" onchange="loadPage();"><option value="">&nbsp;&nbsp;&nbsp;-----
	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
	-----&nbsp;&nbsp;&nbsp;</option>
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

