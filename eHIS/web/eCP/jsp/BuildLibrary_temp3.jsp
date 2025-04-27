<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sandhya.S
*	Created On		:	10 Feb 2005

--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<SCRIPT language="JavaScript" src="../../eCP/js/common.js"></SCRIPT>
<SCRIPT src="../../eCommon/js/ValidateControl.js" language="javascript"></SCRIPT>
<SCRIPT src="../../eCommon/js/common.js" language="javascript"></SCRIPT>
<SCRIPT language="JavaScript" src="../../eCP/js/BuildLibrary.js"></SCRIPT>
</HEAD>
<%
//This file is saved on 18/10/2005.
	request.setCharacterEncoding("UTF-8");
	String flag=request.getParameter("flag");
	//out.println("flag  "+flag);
%>
<BODY>
<BR>
<DIV align='right'>
<TABLE  cellpadding='0' cellspacing='0' >
	<TR>
	<%if(flag.equals("1")){%>
		<TD>
			<INPUT type='button' name='save' id='save' value='<fmt:message key="Common.Save.label" bundle="${common_labels}"/>' onClick='apply()' class='button'>&nbsp;
		</TD>
	<%}%>
		<TD>
			<INPUT type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='closelookupW()' class='button'>
		</TD>
	</TR>
</TABLE>
</DIV>
</BODY>

