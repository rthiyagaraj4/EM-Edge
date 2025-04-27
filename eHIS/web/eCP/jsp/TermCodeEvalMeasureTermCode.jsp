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
 String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<LINK rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></LINK>
	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
	<SCRIPT language='javascript' src='../../eCommon/js/CommonLookup.js' ></SCRIPT>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCP/js/TermCodeEvalMeasure.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onKeyDown="lockKey()" >
<FORM name="TermcodeEvalMeasureHeaderForm" id="TermcodeEvalMeasureHeaderForm" action="" method="" >
<%
TermCodeEvalMeasure.clearAll();
//ArrayList Tablist=new ArrayList();
//TermCodeEvalMeasure.putObject(Tablist);

Connection connection		=	null;
Statement  stmt				=	null;
ResultSet rs				=	null;
String terminologySetQuery		  =	"Select term_Set_id,term_set_desc from mr_term_set where eff_status = 'E' order by term_set_desc ";
  try
			{
				connection = ConnectionManager.getConnection(request);
				stmt	   = connection.createStatement();	
%>
	<TABLE cellspacing='0' cellpadding='7' align='center' width="100%" border=0>
		<TR>
			<TD align="right" class="label"><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></TD>
			<TD align="left">&nbsp;&nbsp;
				<SELECT name="terminologySet" id="terminologySet" onchange="getLevels(this)">
					<OPTION value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</OPTION>
			<%
					rs=stmt.executeQuery(terminologySetQuery);
					while(rs!=null && rs.next()){
			%>
					<OPTION value="<%=(String)rs.getString(1)%>"><%=(String)rs.getString(2)%></OPTION>
			<%
				}
			%>
				</SELECT>
				<IMG src="../../eCommon/images/mandatory.gif"></IMG>
			</TD>
		</TR>
		<TR>
			<TD align="right" class="label"><fmt:message key="Common.type.label" bundle="${common_labels}"/></TD>
			<TD align="left">&nbsp;&nbsp;
				<SELECT name="type" id="type">
					<OPTION value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</OPTION>
				</SELECT>
				<IMG src="../../eCommon/images/mandatory.gif"></IMG>
			</TD>
		</TR>
		<TR>
			<TD align="right" class="label"><fmt:message key="Common.TerminologyCode.label" bundle="${common_labels}"/></TD>
				<TD align="left">&nbsp;&nbsp;
					<INPUT type="text" name="termCodeDesc" id="termCodeDesc" size="75" >
					<INPUT class='button' type=button name="termCodeButton" id="termCodeButton" value="?" onclick="termCodeLookup(termCodeDesc)" >
					<INPUT type="hidden" name="termCode" id="termCode" value="">
					<input type="hidden" name="locale" id="locale" value="<%=locale%>">
					<IMG src="../../eCommon/images/mandatory.gif"></IMG>
				</TD>
		</TR>
		<TR>
			<TD colspan=2 align="right">
				<input class='button' type=button name="Associate" id="Associate" value='<fmt:message key="eCP.Associate.label" bundle="${cp_labels}"/>' onClick='loaddetails()'>
			</TD>
		</TR>
	</TABLE>
	</FORM>
</BODY>
<%
	  }catch(Exception e){
		//  out.println("Error is--->"+e);//COMMON-ICN-0181
		  e.printStackTrace();
	  }
	finally
	{
			if(rs != null){ rs.close(); }
			if(stmt != null){ stmt.close(); }
		  ConnectionManager.returnConnection(connection,request);
	}
%> 
</HTML>

