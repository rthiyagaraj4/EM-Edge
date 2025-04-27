<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	/* Mandatory checks start */
	String mode	= "1";//request.getParameter( "mode" ) ;
//	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ResultEntry" ;
	String bean_name = "eOR.ResultEntryBean";
/* Mandatory checks end */
	
/* Initialize Function specific start */
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id, bean_name , request) ; 
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;
/* Initialize Function specific end */

	String msr_id = request.getParameter("msr_id");
	if(msr_id==null)	msr_id="";

	ArrayList templateBlock = bean.getTemplateBlocks(msr_id);
%>

<html>
<head>

	<title><fmt:message key="Common.ResultTemplate.label" bundle="${common_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ResultEntry.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body style=''  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<FORM name='result_entry_template_block' id='result_entry_template_block' METHOD=POST ACTION="">
<table cellpadding=3 cellspacing=0 border=0 align=center width='100%' height='100%'>
<tr>
	<td class='label' valign='top'>
	<table cellpadding=3 cellspacing=0 border=0 align=center width='100%'>
	<tr>
		<td class=columnheader><fmt:message key="Common.Text.label" bundle="${common_labels}"/></td>
	</tr>
<!-- 	</tr>
		<td class='label' align='left'>
			<a href="#" onclick="clickTemplateText('1')">text1</a>
			<input type='hidden' name='hiddentext_1' id='hiddentext_1' value='1111111111'>
		</td>
	</tr> -->
	<%
		if(templateBlock != null)
		{
			for(int i=0; i<templateBlock.size(); i++)
			{
				String[] blocks = new String[2];
				blocks = (String[])templateBlock.get(i);
	%>
	<tr>
		<td class='label'>
			<a class="gridLink" href="javascript:clickTemplateText('<%=i%>')" ><%=blocks[0]%></a>
			<input type='hidden' name='hiddentext_<%=i%>' id='hiddentext_<%=i%>' value="<%=blocks[1]%>">
		</td>
	</tr>
	<%		}
		}%>
	</table>
	</td>
</tr>
</table>
</FORM>
</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

