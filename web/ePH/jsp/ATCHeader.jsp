<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
<script language="JavaScript" src="../../ePH/js/ATCClassification.js"></script>
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String level_num	=	request.getParameter("level_num");
	String calling_func	=	request.getParameter("called_from");
	if(level_num==null || level_num.equals("") )
		level_num = "";
	String level_value	=	"";
%>

<!-- <body topmargin="0"> -->
<body onMouseDown="" onKeyDown="lockKey()" topmargin="0">
<table border="0" align="left" width="100%" cellpadding="0" cellspacing="0">
<%	if(level_num!=""){	
	      if(level_num.equals("1"))   level_value =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AnatomicalClass.label","ph_labels");
		  if(level_num.equals("2"))   level_value =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MainClass.label","ph_labels")+")";
		  if(level_num.equals("3"))   level_value =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SubClass.label","common_labels")+")";
		  if(level_num.equals("4"))   level_value =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ChemicalClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MainClass.label","ph_labels")+")";
		  if(level_num.equals("5"))   level_value =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ChemicalClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SubClass.label","common_labels")+")";
	%>
<tr >
	<td class=' COLUMNHEADER' width="95%">&nbsp;<%=level_value%></td>
<% if(calling_func.equals("atc") ) {

		if(level_num.equals("1"))   {  
%> 
	<td class=' COLUMNHEADER' onMouseOver="style.cursor='pointer'" onClick="showATCInsert('<%=level_num%>')" width="34%" title='<fmt:message key="ePH.ClicktoInsertRecords.label" bundle="${ph_labels}"/>'><fmt:message key="Common.Add.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</td>
<% } else { %>
	<td class=' COLUMNHEADER' onMouseOver="style.cursor='pointer'" width="0%" id="addlink">&nbsp;</td>
<%			}
	
	}  else if (calling_func.equals("generic_atc"))	{
%>
<td class=' COLUMNHEADER' onMouseOver="style.cursor='pointer'" width="34%">&nbsp;</td>
<%	}	%>
</tr>
<% }	else	{%>
<tr>
	<td class=' COLUMNHEADERCENTER' onMouseOver="style.cursor='pointer'" colspan="2"><fmt:message key="ePH.ViewHierarchy.label" bundle="${ph_labels}"/></td>
</tr>
<%	}	%>
</table>
</body>
</html>

