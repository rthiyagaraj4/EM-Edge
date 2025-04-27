<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
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

    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	<title> <fmt:message key="ePH.DiscontinuedDrugDetails.label" bundle="${ph_labels}"/> </title>
</head>
<style>
textarea {
  resize: none;
}
</style>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String details = request.getParameter("details") ;
	java.util.StringTokenizer st	=	new java.util.StringTokenizer(details,",");
	String disc_date	=	"";
	String disc_reason	=	"";
	String disc_by		=	"";

	if(st.hasMoreTokens())	{
	disc_date	=	st.nextToken();
	disc_reason	=	st.nextToken();
	disc_by		=	st.nextToken();
	
	if(disc_reason==null)
		disc_reason="";
	if(disc_by.equals("null") || disc_by.equals("") || disc_by==null)
		disc_by	="";
	}
	disc_date=com.ehis.util.DateUtils.convertDate(disc_date,"DMYHM","en",locale);
%>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
<tr>
	<td class="label"><fmt:message key="ePH.DiscontinuedDate.label" bundle="${ph_labels}"/></td>
	<td class="DATA">&nbsp;&nbsp;<b><%=disc_date%></b></td>
</tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr>
	<td class="label"><fmt:message key="ePH.ReasonforDiscontinued.label" bundle="${ph_labels}"/></td>
	<td class="data">&nbsp;&nbsp;<textarea rows="2" cols="30" readOnly><%=disc_reason%></textarea></td>
</tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr>
	<td class="label"><fmt:message key="ePH.DiscontinuedBy.label" bundle="${ph_labels}"/></td>
	<td  class="data">&nbsp;&nbsp;<b><%=disc_by%></b></td>
</tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr> <td colspan="2" class="white"><input type="button" class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="parent.document.getElementById('dialog_tag').close();"></td>
</table>
</body>
</html>

