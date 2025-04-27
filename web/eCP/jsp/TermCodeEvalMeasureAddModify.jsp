<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:
*	Created By		:	
*	Created On		:	02 Nov 2005
-->

<!--OutcomeAddModify.jsp-->

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCP.*,eCommon.XSSRequestWrapper" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="TermCodeEvalMeasure" class="webbeans.eCommon.RecordSet" scope="session"/>


<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	  String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<LINK rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></LINK>
	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCP/js/TermCodeEvalMeasure.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<FORM name="termCodeEvalAddmodifyForm" id="termCodeEvalAddmodifyForm" action="" method="" >
<%
	String termSet=request.getParameter("termSet");
	String termCode=request.getParameter("termCode");
	//System.err.println("termCode in addmodify "+termCode);
	String id=request.getParameter("id")==null?"":request.getParameter("id");
	String Desc=request.getParameter("Desc")==null?"":request.getParameter("Desc");
	String score=request.getParameter("score")==null?"":request.getParameter("score");
	String seq_no=request.getParameter("seq_no")==null?"":request.getParameter("seq_no");
	String readonly="";
	String disabled="disabled";
	if(!id.equals("")){
		readonly="disabled";
		disabled="";
	}
%>
		<TABLE cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
			<TR>
				<TD colspan=2>&nbsp;</TD>
			</TR>
			<TR>
				<TD width="20%"  align=right class="label"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></TD>
				<TD>&nbsp;&nbsp;<INPUT TYPE="text" maxlength="2" size="3"  <%=readonly%> value="<%=id%>" NAME="id" onKeyPress="return CheckForSpecChars(event);">
				<img src="../../eCommon/images/mandatory.gif"></img></TD>
			</TR>
			<TR>
				<TD width="20%"  align=right class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></TD>
				<TD>&nbsp;&nbsp;<INPUT TYPE="text" value="<%=Desc%>" maxlength="30" size="34" NAME="Desc">
				<img src="../../eCommon/images/mandatory.gif"></img></TD>
			</TR>
			<TR>
				<TD width="20%"  align=right class="label"><fmt:message key="eCP.CutOffScore.label" bundle="${cp_labels}"/></TD>
				<TD>&nbsp;&nbsp;<INPUT TYPE="text" value= "<%=score%>" maxlength="3" size="3" NAME="score" onBlur="CheckNumber(this,1,100);">
				<img src="../../eCommon/images/mandatory.gif"></img></TD>
			</TR>
			<TR>
				<TD width="20%"  align=right class="label"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></TD>
				<TD>&nbsp;&nbsp;<INPUT TYPE="text" value="<%=seq_no%>" maxlength="2" size="3" NAME="seq_no" onBlur="CheckNumber(this,1,99);">
				<img src="../../eCommon/images/mandatory.gif"></img></TD>
			</TR>
			<TR>
				<TD colspan=2>&nbsp;</TD>
			</TR>
		</TABLE>
		<BR>
		 <DIV align='right'> 
			<TABLE  cellpadding='0' cellspacing='0' >
				<TR>
					<TD>
						<INPUT type='button' name='Add' id='Add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>'  class='button' onclick="addtoList()">&nbsp;
					</TD>					
					<TD>
						<INPUT type='button' name='Delete' id='Delete' value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' <%=disabled%> onclick="deletefrmList()" class='button'>&nbsp;
					</TD>
						<TD>
						<INPUT type='button' name='Clear' id='Clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'  onclick="clearAll()" class='button'>&nbsp;
					</TD>
				</TR>
			</TABLE>
		 </DIV> 

		<INPUT TYPE="hidden" name="termSet" id="termSet" value="<%=termSet%>">
		<INPUT TYPE="hidden" name="termCode" id="termCode" value="<%=termCode%>">
	</FORM>
</BODY>
</HTML>

