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
*	Created On		:	28th Oct 2005
-->

<!--OutcomeAddModify.jsp-->

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCP.*" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

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
	String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<LINK rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></LINK>
	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
		 <script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT language="javascript" src="../js/OutcomeMeasures.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<FORM name="outcomeMeasuresForm" id="outcomeMeasuresForm" action="../../servlet/eCP.OutcomeMeasuresServlet" method="POST" >
<%
	String outcome_code			=		request.getParameter("outcome_code");
	String mode					=		request.getParameter("mode");
	String id					=		"";
	String desc					=		"";
	String score				=		"";
	String seqno				=		"";
	String readonly				=		"";
	String disable				=		"DISABLED";

	if(mode.equals("2")){
		readonly				=		"READONLY";
		disable					=		"";
		 id						=		request.getParameter("id")==null?"":request.getParameter("id");
		 desc					=		request.getParameter("desc")==null?"":request.getParameter("desc");
	     score					=		request.getParameter("score")==null?"":request.getParameter("score");
		 seqno					=		request.getParameter("seqno")==null?"":request.getParameter("seqno");
	}
%>
		<TABLE cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
			<TR>
				<TD width="20%"   class="label"><fmt:message key="Common.identification.label" bundle="${common_labels}"/><!-- <fmt:message key="Common.identification.label" bundle="${common_labels}"/> --></TD>
				<TD>&nbsp;&nbsp;<INPUT TYPE="text" maxlength="2" size="3"  <%=readonly%> value="<%=id%>" NAME="id" onKeyPress="return CheckForSpecChars(event);">
				<img src="../../eCommon/images/mandatory.gif"></img></TD>
			</TR>
			<TR>
				<TD width="20%"  class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></TD>
				<TD>&nbsp;&nbsp;<INPUT TYPE="text" value="<%=desc%>" maxlength="30" size="34" NAME="Desc"onKeyPress="return CheckForSpecChars(event);">
				<img src="../../eCommon/images/mandatory.gif"></img></TD>
			</TR>
			<TR>
				<TD width="20%"   class="label"><fmt:message key="eCP.CutOffScore.label" bundle="${common_labels}"/></TD>
				<TD>&nbsp;&nbsp;<INPUT TYPE="text"  value= "<%=score%>" maxlength="3" size="3" NAME="score" onBlur="CheckNum(this);"  o>
				<img src="../../eCommon/images/mandatory.gif"></img></TD>
			</TR>
			<TR>
				<TD width="20%" class="label"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></TD>
				<TD>&nbsp;&nbsp;<INPUT TYPE="text"  value="<%=seqno%>" maxlength="2" size="3" NAME="seq_no" onBlur="CheckNum(this);"  >
				<img src="../../eCommon/images/mandatory.gif"></img></TD>
			</TR>
		</TABLE>
		<BR>
		 <DIV align='right'> 
			<TABLE  cellpadding='0' cellspacing='0' >
							<TR>
					<TD>
						<INPUT type='button' name='apply' id='apply' value='Apply'  class='button' onclick="applymeasure('<%=mode%>')">&nbsp;
					</TD>
					<TD>
						<INPUT type='button' name='Delete' id='Delete' value='Delete' <%=disable%> onclick="applymeasure(3)" class='button'>&nbsp;
					</TD>
						<TD>
						<INPUT type='button' name='Clear' id='Clear' value='Clear'  onclick="resetform()" class='button'>&nbsp;
					</TD>
					<TD>
						<INPUT type='button' name='Close' id='Close' value='Close'  onclick="closewindow()" class='button'>
					</TD>
				</TR>
			</TABLE>
		 </DIV> 
		<INPUT TYPE="hidden" name="outcome_code" id="outcome_code" value="<%=outcome_code%>">
		<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
	</FORM>
</BODY>
</HTML>

